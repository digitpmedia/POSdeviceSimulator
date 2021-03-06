package org.jumpmind.pos.javapos.sim.ui;

import java.awt.BorderLayout;

import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
import javax.swing.text.StyledDocument;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class SimulatedPOSPrinterPanel extends BaseSimulatedPanel {
    static final Log logger = LogFactory.getLog(SimulatedPOSPrinterPanel.class);
    private static final long serialVersionUID = 1L;
    private static SimulatedPOSPrinterPanel me;
    private JTextPane textArea;

    protected SimulatedPOSPrinterPanel() {
    }

    public static SimulatedPOSPrinterPanel getInstance() {
        if (me == null) {
            me = new SimulatedPOSPrinterPanel();
        }
        return me;
    }

    public void init() {
        setInitialized(true);
        this.setFocusable(false);
        this.setName("SimulatedPOSPrinter");
        textArea = new JTextPane();
        textArea.setEditable(false);
        textArea.setName("POSPrinterOutput");

        StyledDocument doc = textArea.getStyledDocument();
        Style def = StyleContext.getDefaultStyleContext().getStyle(
                StyleContext.DEFAULT_STYLE);
        Style s = doc.addStyle("text", def);
        StyleConstants.setFontFamily(s, "Monospaced");

        JScrollPane scrollPane = new JScrollPane(textArea,
                ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);

        setLayout(new BorderLayout());
        this.add(scrollPane, BorderLayout.CENTER);
    }

    public JTextPane getTextArea() {
        return textArea;
    }

    public void setTextArea(JTextPane textArea) {
        this.textArea = textArea;
    }

}
