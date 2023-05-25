package view;

import model.Document;

import javax.swing.*;
import java.awt.*;

/**
 * A Dialog to read a document.
 * @Author Tin Phu
 */
public class DocumentTabRead extends JPanel {

    private final JDialog dialog = new JDialog();
    public DocumentTabRead(Document theDoc){
        setLayout(new GridBagLayout());

        // Create components for document details
        JLabel nameLabel = createLabel("Name:");
        JLabel descriptionLabel = createLabel("Description:");
        JLabel costLabel = createLabel("Cost:");

        // Set font for labels (without changing the default font)
        Font labelFont = nameLabel.getFont();
        nameLabel.setFont(labelFont.deriveFont(Font.BOLD, labelFont.getSize() + 2));
        descriptionLabel.setFont(labelFont.deriveFont(Font.BOLD, labelFont.getSize()));
        costLabel.setFont(labelFont.deriveFont(Font.BOLD, labelFont.getSize()));

        // Create constraints for positioning the labels and details
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.NORTHWEST; // Align labels to the top-left corner
        constraints.insets = new Insets(5, 5, 5, 5);

        // Add labels to the panel
        constraints.gridx = 0;
        constraints.gridy = 0;
        add(nameLabel, constraints);

        constraints.gridy = 1;
        add(descriptionLabel, constraints);

        constraints.gridy = 2;
        add(costLabel, constraints);

        // Create components for document details
        JLabel nameDetailLabel = createDetailLabel(theDoc.getDocumentName());
        JTextArea descriptionTextArea = createDescriptionTextArea(theDoc.getDocumentDescription());
        JLabel costDetailLabel = createDetailLabel(theDoc.getTotalCost().toString());

        // Add detail components to the panel
        constraints.gridx = 1;
        constraints.gridy = 0;
        add(nameDetailLabel, constraints);

        constraints.gridy = 1;
        constraints.fill = GridBagConstraints.BOTH;
        constraints.weightx = 1.0;
        constraints.weighty = 1.0;
        add(descriptionTextArea, constraints);

        constraints.gridy = 2;
        constraints.fill = GridBagConstraints.NONE;
        constraints.weightx = 0.0;
        constraints.weighty = 0.0;
        add(costDetailLabel, constraints);
        //Set this panel to dialog.
        dialog.setContentPane(this);
        dialog.setTitle("Document");
        dialog.setSize(600, 400);

        dialog.setLocationRelativeTo(null); // Center the dialog on the screen
        dialog.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        dialog.setVisible(true);


    }

    /**
     * Label Helper.
     * @param text
     *  @Author Tin Phu
     * @return
     */
    private JLabel createLabel(String text) {
        JLabel label = new JLabel(text);
        label.setFont(label.getFont().deriveFont(Font.BOLD));
        return label;
    }
    /**
     * Detail JLabel Helper.
     * @param text
     *  @Author Tin Phu
     * @return
     */
    private JLabel createDetailLabel(String text) {
        JLabel label = new JLabel(text);
        label.setFont(label.getFont().deriveFont(Font.PLAIN));
        return label;
    }

    /**
     * TextArea Helper.
     * @param text
     * @Author Tin Phu
     * @return
     */
    private JTextArea createDescriptionTextArea(String text) {
        JTextArea textArea = new JTextArea(text);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setEditable(false);
        textArea.setBackground(this.getBackground());
        textArea.setFont(textArea.getFont().deriveFont(Font.PLAIN));
        return textArea;
    }
}
