package com.happy.plugin.quickcompare.ui;

import com.happy.plugin.quickcompare.CompareManager;
import com.happy.plugin.quickcompare.Constants;
import com.happy.plugin.quickcompare.policy.ComparePolicy;
import com.happy.plugin.quickcompare.policy.ComparePolicyFactory;
import com.intellij.ide.util.PropertiesComponent;
import com.intellij.openapi.fileChooser.FileChooser;
import com.intellij.openapi.fileChooser.FileChooserDescriptor;
import com.intellij.openapi.fileChooser.FileChooserDescriptorFactory;
import com.intellij.openapi.util.text.StringUtil;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import com.intellij.uiDesigner.core.Spacer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**
 * Created by zxx on 2016/6/16.
 */
public class CompareForm {
    public JPanel mContentPanel;
    private JTextField mPathTextField;
    private JButton mChoosePathButton;
    private JComboBox comboBox1;

    private boolean mIsModified = false;

    public void apply() {
        System.out.println("apply........");
        mIsModified = false;

        System.out.println("select path:" + mPathTextField.getText());

        PropertiesComponent component = PropertiesComponent.getInstance();
        if (StringUtil.isEmpty(component.getValue(Constants.KEY_EXECUTABLE_PATH))) {
            System.out.println("original path is empty!");
            component.setValue(Constants.KEY_EXECUTABLE_PATH, mPathTextField.getText());
        } else {
            System.out.println("original path is: " + component.getValue(Constants.KEY_EXECUTABLE_PATH));
            component.setValue(Constants.KEY_EXECUTABLE_PATH, mPathTextField.getText());
            System.out.println("update path is: " + mPathTextField.getText());
        }

        if (comboBox1.getSelectedIndex() != -1) {
            System.out.println("save user choose index:" + comboBox1.getSelectedIndex());
            component.setValue(Constants.KEY_CHOOSE_TOOL, "" + comboBox1.getSelectedIndex());
        }

        if (comboBox1.getSelectedIndex() != -1 && !StringUtil.isEmpty(mPathTextField.getText())) {
            updateComparePolicy(comboBox1.getSelectedIndex());
        }
    }

    private void updateComparePolicy(int policyIndex) {

        ComparePolicy.PolicyType type = ComparePolicy.PolicyType.values()[policyIndex];
        ComparePolicy currentPolicy = ComparePolicyFactory.getFactoryInstance().makeComparePolicy(type);
        CompareManager.getApplicationInstance().setComparePolicy(currentPolicy);

        System.out.println("update policy to : " + currentPolicy);

    }

    public void reset() {
        System.out.println("reset..........");
        PropertiesComponent component = PropertiesComponent.getInstance();
        String originalPath = component.getValue(Constants.KEY_EXECUTABLE_PATH);
        mPathTextField.setText(originalPath);
    }

    public CompareForm() {
        System.out.println("CompareForm constructor");
        mChoosePathButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                chooseFile();
            }
        });

        comboBox1.addItem("QuickCompare");
        comboBox1.addItem("Internal Diff");

        loadUISettings();

        comboBox1.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {

                if (e.getStateChange() == ItemEvent.SELECTED) {
                    System.out.println("choose: " + e.getItem());
                    mIsModified = true;
                }

            }
        });


    }

    private void loadUISettings() {

        // TODO: 2017/7/7 need change bc to const string
        final PropertiesComponent component = PropertiesComponent.getInstance();
        if (!StringUtil.isEmpty(component.getValue(Constants.KEY_EXECUTABLE_PATH))) {

            final String path = component.getValue(Constants.KEY_EXECUTABLE_PATH);

            mPathTextField.setText(path);
            mPathTextField.invalidate();
            mPathTextField.updateUI();
            mContentPanel.invalidate();
            mContentPanel.updateUI();

        }

        if (!StringUtil.isEmpty(component.getValue(Constants.KEY_CHOOSE_TOOL))) {

            final String index = component.getValue(Constants.KEY_CHOOSE_TOOL);

            comboBox1.setSelectedIndex(Integer.parseInt(index));


        }


    }


    private void chooseFile() {

        final FileChooserDescriptor descriptor = FileChooserDescriptorFactory.createSingleFileDescriptor();
        descriptor.setTitle("Select compare tool folder");
        VirtualFile virtualFile = FileChooser.chooseFile(descriptor, null, null);

        if (virtualFile == null) {
            return;
        }

        VirtualFile selectedFile = virtualFile;  //取得选中的文件

        mPathTextField.setText(selectedFile.getPath());
        mContentPanel.invalidate();
        mContentPanel.updateUI();
        mIsModified = true;

    }

    public boolean isModified() {
        return mIsModified;
    }

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        mContentPanel = new JPanel();
        mContentPanel.setLayout(new GridLayoutManager(4, 3, new Insets(0, 0, 0, 0), -1, -1));
        final Spacer spacer1 = new Spacer();
        mContentPanel.add(spacer1, new GridConstraints(2, 0, 1, 3, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1, GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        final Spacer spacer2 = new Spacer();
        mContentPanel.add(spacer2, new GridConstraints(3, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1, GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        final Spacer spacer3 = new Spacer();
        mContentPanel.add(spacer3, new GridConstraints(0, 1, 1, 2, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1, GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        final JPanel panel1 = new JPanel();
        panel1.setLayout(new BorderLayout(0, 0));
        mContentPanel.add(panel1, new GridConstraints(1, 0, 1, 3, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        final JLabel label1 = new JLabel();
        label1.setText("Path to executable:     ");
        panel1.add(label1, BorderLayout.WEST);
        mPathTextField = new JTextField();
        panel1.add(mPathTextField, BorderLayout.CENTER);
        mChoosePathButton = new JButton();
        mChoosePathButton.setText("...");
        panel1.add(mChoosePathButton, BorderLayout.EAST);
        final JPanel panel2 = new JPanel();
        panel2.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 5));
        mContentPanel.add(panel2, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label2 = new JLabel();
        label2.setPreferredSize(new Dimension(150, 16));
        label2.setText("Choose compare tool:");
        panel2.add(label2);
        comboBox1 = new JComboBox();
        panel2.add(comboBox1);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return mContentPanel;
    }
}
