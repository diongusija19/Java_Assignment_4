import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Clipboard;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WebTechCheatSheetSwing {

    public static void main(String[] args) {
        // Main window
        JFrame frame = new JFrame("Web Tech Cheat Sheet");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 500);
        frame.setLocationRelativeTo(null); // center on screen

        // Tabbed pane
        JTabbedPane tabbedPane = new JTabbedPane();

        // HTML Tab
        tabbedPane.addTab("HTML", createTabPanel(getHtmlCheatSheet(), Color.ORANGE));

        // CSS Tab
        tabbedPane.addTab("CSS", createTabPanel(getCssCheatSheet(), Color.CYAN.darker()));

        // JavaScript Tab
        tabbedPane.addTab("JavaScript", createTabPanel(getJsCheatSheet(), Color.YELLOW.darker()));

        frame.add(tabbedPane);
        frame.setVisible(true);
    }

    // Helper to create a tab panel with scrollable text area and copy button
    private static JPanel createTabPanel(String content, Color headingColor) {
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JTextArea textArea = new JTextArea(content);
        textArea.setEditable(false);
        textArea.setFont(new Font("Monospaced", Font.PLAIN, 13));
        JScrollPane scrollPane = new JScrollPane(textArea);

        // Heading label
        JLabel heading = new JLabel("Cheat Sheet");
        heading.setFont(new Font("Arial", Font.BOLD, 16));
        heading.setForeground(headingColor);

        // Copy button
        JButton copyButton = new JButton("Copy to Clipboard");
        copyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StringSelection selection = new StringSelection(textArea.getText());
                Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
                clipboard.setContents(selection, selection);
                JOptionPane.showMessageDialog(panel, "Copied to clipboard!");
            }
        });

        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.add(heading, BorderLayout.WEST);
        topPanel.add(copyButton, BorderLayout.EAST);

        panel.add(topPanel, BorderLayout.NORTH);
        panel.add(scrollPane, BorderLayout.CENTER);

        return panel;
    }

    private static String getHtmlCheatSheet() {
        return """
        <!DOCTYPE html>
        <html>
          <head>
            <title>Page Title</title>
          </head>
          <body>
            <h1>Heading</h1>
            <p>Paragraph</p>
            <a href="https://example.com">Link</a>
          </body>
        </html>
        """;
    }

    private static String getCssCheatSheet() {
        return """
        body { font-family: Arial; background-color: #f4f4f4; }
        h1 { color: blue; }
        a { color: red; }
        """;
    }

    private static String getJsCheatSheet() {
        return """
        // Variables
        let name = "John";
        const PI = 3.14;

        // Functions
        function greet() { console.log("Hello World!"); }

        // Event example
        document.getElementById("btn").addEventListener("click", greet);
        """;
    }
}
