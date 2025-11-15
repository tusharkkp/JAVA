import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;
import java.util.regex.Pattern;

public class RegistrationForm extends JFrame {
    // Form fields
    private JTextField tfFirstName = new JTextField(15);
    private JTextField tfLastName = new JTextField(15);
    private JTextField tfUsername = new JTextField(15);
    private JPasswordField pfPassword = new JPasswordField(15);
    private JPasswordField pfConfirm = new JPasswordField(15);
    private JTextField tfEmail = new JTextField(20);
    private JTextField tfPhone = new JTextField(12);
    private JRadioButton rbMale = new JRadioButton("Male");
    private JRadioButton rbFemale = new JRadioButton("Female");
    private JRadioButton rbOther = new JRadioButton("Other");
    private JComboBox<String> cbDay, cbMonth, cbYear;
    private JTextArea taAddress = new JTextArea(4, 20);
    private JComboBox<String> cbCountry;
    private JCheckBox chAgree = new JCheckBox("I agree to Terms & Conditions");
    private JButton btnSubmit = new JButton("Submit");
    private JButton btnReset = new JButton("Reset");

    public RegistrationForm() {
        super("User Registration Form");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        buildUI();
        pack();
        setLocationRelativeTo(null); // center
    }

    private void buildUI() {
        JPanel content = new JPanel(new GridBagLayout());
        content.setBorder(new EmptyBorder(12, 12, 12, 12));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(6, 6, 6, 6);
        gbc.anchor = GridBagConstraints.WEST;

        int row = 0;

        // --- Row helper lambda to add components ---
        BiConsumer<Component, Integer> addLabel = (comp, r) -> {
            gbc.gridx = 0; gbc.gridy = r; gbc.gridwidth = 1;
            content.add(comp, gbc);
        };

        BiConsumer<Component, Integer> addField = (comp, r) -> {
            gbc.gridx = 1; gbc.gridy = r; gbc.gridwidth = 3; gbc.fill = GridBagConstraints.HORIZONTAL;
            content.add(comp, gbc);
            gbc.fill = GridBagConstraints.NONE;
        };

        // First name
        addLabel.accept(new JLabel("First Name *:"), row);
        addField.accept(tfFirstName, row++);
        // Last name
        addLabel.accept(new JLabel("Last Name *:"), row);
        addField.accept(tfLastName, row++);
        // Username
        addLabel.accept(new JLabel("Username *:"), row);
        addField.accept(tfUsername, row++);
        // Password
        addLabel.accept(new JLabel("Password *:"), row);
        addField.accept(pfPassword, row++);
        // Confirm password
        addLabel.accept(new JLabel("Confirm Password *:"), row);
        addField.accept(pfConfirm, row++);
        // Email
        addLabel.accept(new JLabel("Email *:"), row);
        addField.accept(tfEmail, row++);
        // Phone
        addLabel.accept(new JLabel("Phone:"), row);
        addField.accept(tfPhone, row++);
        // Gender (radio buttons)
        addLabel.accept(new JLabel("Gender:"), row);
        JPanel pGender = new JPanel(new FlowLayout(FlowLayout.LEFT, 6, 0));
        ButtonGroup bg = new ButtonGroup();
        bg.add(rbMale); bg.add(rbFemale); bg.add(rbOther);
        pGender.add(rbMale); pGender.add(rbFemale); pGender.add(rbOther);
        addField.accept(pGender, row++);
        // Date of Birth (simple combo boxes)
        addLabel.accept(new JLabel("Date of Birth:"), row);
        cbDay = new JComboBox<>(generateRange(1, 31));
        cbMonth = new JComboBox<>(new String[]{"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"});
        cbYear = new JComboBox<>(generateRange(1950, 2025));
        JPanel pDob = new JPanel(new FlowLayout(FlowLayout.LEFT, 4, 0));
        pDob.add(cbDay); pDob.add(cbMonth); pDob.add(cbYear);
        addField.accept(pDob, row++);
        // Address
        addLabel.accept(new JLabel("Address:"), row);
        taAddress.setLineWrap(true);
        taAddress.setWrapStyleWord(true);
        JScrollPane sp = new JScrollPane(taAddress, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        addField.accept(sp, row++);
        // Country
        addLabel.accept(new JLabel("Country:"), row);
        cbCountry = new JComboBox<>(new String[]{"Select...", "India", "United States", "United Kingdom", "Canada", "Australia", "Other"});
        addField.accept(cbCountry, row++);
        // Agree
        addLabel.accept(new JLabel(""), row);
        addField.accept(chAgree, row++);
        // Buttons
        gbc.gridx = 0; gbc.gridy = row; gbc.gridwidth = 4; gbc.anchor = GridBagConstraints.CENTER;
        JPanel pButtons = new JPanel(new FlowLayout(FlowLayout.CENTER, 12, 0));
        btnSubmit.setMnemonic(KeyEvent.VK_S);
        btnReset.setMnemonic(KeyEvent.VK_R);
        pButtons.add(btnSubmit);
        pButtons.add(btnReset);
        content.add(pButtons, gbc);

        // Tooltips
        tfEmail.setToolTipText("e.g. user@example.com");
        pfPassword.setToolTipText("Min 8 chars, include letter and digit");
        tfPhone.setToolTipText("Digits only, optional");

        // Add action listeners
        btnSubmit.addActionListener(e -> onSubmit());
        btnReset.addActionListener(e -> onReset());

        // Enter key presses submit
        getRootPane().setDefaultButton(btnSubmit);

        setContentPane(content);
    }

    private void onSubmit() {
        String first = tfFirstName.getText().trim();
        String last = tfLastName.getText().trim();
        String username = tfUsername.getText().trim();
        String password = new String(pfPassword.getPassword());
        String confirm = new String(pfConfirm.getPassword());
        String email = tfEmail.getText().trim();
        String phone = tfPhone.getText().trim();
        String gender = rbMale.isSelected() ? "Male" : rbFemale.isSelected() ? "Female" : rbOther.isSelected() ? "Other" : "";
        String address = taAddress.getText().trim();
        String country = cbCountry.getSelectedItem() != null ? cbCountry.getSelectedItem().toString() : "";

        // Basic validation
        StringBuilder errors = new StringBuilder();

        if (first.isEmpty()) errors.append("- First name is required.\n");
        if (last.isEmpty()) errors.append("- Last name is required.\n");
        if (username.isEmpty()) errors.append("- Username is required.\n");
        if (password.isEmpty()) errors.append("- Password is required.\n");
        if (confirm.isEmpty()) errors.append("- Confirm password is required.\n");

        if (!password.equals(confirm)) errors.append("- Password and Confirm do not match.\n");
        if (!isStrongPassword(password)) errors.append("- Password must be at least 8 chars and include letters and digits.\n");
        if (!email.isEmpty() && !isValidEmail(email)) errors.append("- Email address looks invalid.\n");
        if (!phone.isEmpty() && !phone.matches("\\d+")) errors.append("- Phone must contain digits only.\n");
        if (!chAgree.isSelected()) errors.append("- You must agree to Terms & Conditions.\n");

        if (errors.length() > 0) {
            JOptionPane.showMessageDialog(this, errors.toString(), "Validation Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // If validation passes, show confirmation (real app would save to DB)
        StringBuilder msg = new StringBuilder();
        msg.append("Registration Successful!\n\n");
        msg.append("Name: ").append(first).append(" ").append(last).append("\n");
        msg.append("Username: ").append(username).append("\n");
        msg.append("Email: ").append(email.isEmpty() ? "N/A" : email).append("\n");
        msg.append("Phone: ").append(phone.isEmpty() ? "N/A" : phone).append("\n");
        msg.append("Gender: ").append(gender.isEmpty() ? "N/A" : gender).append("\n");
        msg.append("Country: ").append(country).append("\n");

        JOptionPane.showMessageDialog(this, msg.toString(), "Success", JOptionPane.INFORMATION_MESSAGE);
        // after success - optional reset
        onReset();
    }

    private void onReset() {
        tfFirstName.setText("");
        tfLastName.setText("");
        tfUsername.setText("");
        pfPassword.setText("");
        pfConfirm.setText("");
        tfEmail.setText("");
        tfPhone.setText("");
        rbMale.setSelected(false);
        rbFemale.setSelected(false);
        rbOther.setSelected(false);
        cbDay.setSelectedIndex(0);
        cbMonth.setSelectedIndex(0);
        cbYear.setSelectedIndex(cbYear.getItemCount() - 1); // default to last year
        taAddress.setText("");
        cbCountry.setSelectedIndex(0);
        chAgree.setSelected(false);
    }

    // Utility: generate String[] of numbers range inclusive as strings, first element is "Select..." removed - but simpler we return numbers
    private String[] generateRange(int start, int end) {
        int n = end - start + 1;
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) arr[i] = Integer.toString(start + i);
        return arr;
    }

    // Basic email pattern
    private boolean isValidEmail(String email) {
        if (email == null) return false;
        // simple regex - good enough for form validation
        String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        return Pattern.compile(regex).matcher(email).matches();
    }

    // Basic password strength: at least 8 characters, contains a letter and a digit
    private boolean isStrongPassword(String pwd) {
        if (pwd == null || pwd.length() < 8) return false;
        boolean hasLetter = false, hasDigit = false;
        for (char c : pwd.toCharArray()) {
            if (Character.isLetter(c)) hasLetter = true;
            if (Character.isDigit(c)) hasDigit = true;
            if (hasLetter && hasDigit) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        // Run UI on Event Dispatch Thread
        SwingUtilities.invokeLater(() -> {
            // Optional: set look and feel to system default
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception ignored) {}
            new RegistrationForm().setVisible(true);
        });
    }

    // simple BiConsumer implementation for Java 7/8 compatibility in this single-file example
    private interface BiConsumer<T, U> {
        void accept(T t, U u);
    }
}
