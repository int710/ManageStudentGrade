package studentmanagementpoint.views;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import studentmanagementpoint.dto.StudentModel;
import studentmanagementpoint.service.ClassService;
import studentmanagementpoint.service.TeacherService;
import studentmanagementpoint.service.UserService;
import studentmanagementpoint.utils.SessionManager;

/**
 *
 * @author Admin
 */
public class TableStudentAdmin extends javax.swing.JFrame {

    private List<StudentModel> students;
    private int selectedRow = -1;

    /**
     * Creates new form TableStudent
     */
    public TableStudentAdmin(List<StudentModel> students) {
        if (!SessionManager.isLogin() || !SessionManager.isAdmin()) {
            JOptionPane.showMessageDialog(this, "Bạn không có quyền truy cập vào chức năng này!", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
            System.exit(0); // Đóng cửa sổ nếu không có quyền
        }
        this.students = students;
        initComponents();
        setSizeColumn();
        loadClasses();
        loadDataToTable(students);
        setLocationRelativeTo(null);
    }

    public TableStudentAdmin() {
        if (!SessionManager.isLogin() || !SessionManager.isAdmin()) {
            JOptionPane.showMessageDialog(this, "Bạn không có quyền truy cập vào chức năng này!", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
            System.exit(0); // Đóng cửa sổ nếu không có quyền
        }
        initComponents();
    }

    private void setSizeColumn() {
        tableListStudent.getColumnModel().getColumn(0).setPreferredWidth(50); // STT
        tableListStudent.getColumnModel().getColumn(1).setPreferredWidth(110); // Mã SV
        tableListStudent.getColumnModel().getColumn(2).setPreferredWidth(180); // Họ và Tên
        tableListStudent.getColumnModel().getColumn(3).setPreferredWidth(70); // Giới tính
        tableListStudent.getColumnModel().getColumn(4).setPreferredWidth(100); // Ngày sinh
        tableListStudent.getColumnModel().getColumn(5).setPreferredWidth(50); // Lớp
        tableListStudent.getColumnModel().getColumn(6).setPreferredWidth(180); // Khoa
        tableListStudent.getColumnModel().getColumn(7).setPreferredWidth(200); // Địa chỉ
    }

    public void reloadDataTable(List<StudentModel> ds) throws SQLException, ParseException {
        loadDataToTable(ds);
    }

    public void loadDataToTable(List<StudentModel> std) {
        DefaultTableModel tableModel = (DefaultTableModel) tableListStudent.getModel();
        tableModel.setRowCount(0);

        int currentIndex = 1;
        for (StudentModel u : std) {
            tableModel.addRow(new Object[]{
                currentIndex++,
                u.getStudentId(),
                u.getName(),
                u.getGender(),
                u.getDob(),
                UserService.getNameByClassId(u.getClassId()),
                u.getNameDepartment(),
                u.getAddress()
            });
        }
        tableListStudent.setModel(tableModel);
    }

    private void loadClasses() {
        List<String> classes = ClassService.getAllClasses();
        for (String className : classes) {
            boxClass.addItem(className);
        }
    }

    private void mouseListenSelectedRow() {
        tableListStudent.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                selectedRow = tableListStudent.getSelectedRow();
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableListStudent = new javax.swing.JTable();
        btnAdd = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDel = new javax.swing.JButton();
        btnSearch = new javax.swing.JButton();
        textSearch = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        boxClass = new javax.swing.JComboBox<>();
        btnSearchByClassName = new javax.swing.JButton();
        refresh = new javax.swing.JLabel();

        jLabel4.setText("jLabel4");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tableListStudent.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã Sinh Viên", "Họ và Tên", "Giới tính", "Ngày sinh", "Lớp", "Ngành ", "Quê quán"
            }
        ));
        tableListStudent.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableListStudentMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableListStudent);

        btnAdd.setText("Thêm");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnUpdate.setText("Sửa");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnDel.setText("Xóa");
        btnDel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelActionPerformed(evt);
            }
        });

        btnSearch.setText("Tìm kiếm");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        jLabel1.setText("Mã sinh viên:");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 204, 204));
        jLabel2.setText("DANH SÁCH TẤT CẢ SINH VIÊN");

        boxClass.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả" }));

        btnSearchByClassName.setText("Filter");
        btnSearchByClassName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchByClassNameActionPerformed(evt);
            }
        });

        refresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/studentmanagementpoint/assets/Refresh.png"))); // NOI18N
        refresh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                refreshMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(boxClass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSearchByClassName))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(261, 261, 261)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(186, 186, 186)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnSearch))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(229, 229, 229)
                                .addComponent(btnAdd)
                                .addGap(39, 39, 39)
                                .addComponent(btnUpdate)
                                .addGap(39, 39, 39)
                                .addComponent(btnDel))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 738, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(refresh))))
                        .addGap(0, 13, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd)
                    .addComponent(btnUpdate)
                    .addComponent(btnDel))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(boxClass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearchByClassName)
                    .addComponent(refresh, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Hãy bấm chọn một sinh viên hiển thị trong bảng để thực hiện chức năng này", "Thông báo", JOptionPane.NO_OPTION);
            return;
        }
        if (UserService.isStudentExits((String) tableListStudent.getValueAt(selectedRow, 1))) {
            StudentManageAdmin init = new StudentManageAdmin(true);
            init.updateFields(tableListStudent, selectedRow);
            init.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Sinh viên không tồn tại, bạn không thể sửa thông tin cho người dùng này");
        }

    }//GEN-LAST:event_btnUpdateActionPerformed

    private void tableListStudentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableListStudentMouseClicked
        this.selectedRow = tableListStudent.rowAtPoint(evt.getPoint());
    }//GEN-LAST:event_tableListStudentMouseClicked

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        new StudentManageAdmin(false).setVisible(true);
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        String isIdDeleteFields = textSearch.getText();
        if (isIdDeleteFields.isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Nhập mã sinh viên để tìm kiếm", "Thông báo", JOptionPane.ERROR_MESSAGE);
        } else {
            StudentModel u = null;
            try {
                u = UserService.getStudent(isIdDeleteFields);
            } catch (ParseException ex) {
                Logger.getLogger(TableStudentAdmin.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (u != null) {
                DefaultTableModel tableModel = (DefaultTableModel) tableListStudent.getModel();
                tableModel.setRowCount(0);
                int currentIndex = 1;
                tableModel.addRow(new Object[]{currentIndex++, u.getStudentId(), u.getName(), u.getGender(), u.getDob(), UserService.getNameByClassId(u.getClassId()), u.getNameDepartment(), u.getAddress()});
                tableListStudent.setModel(tableModel);
            } else {
                JOptionPane.showMessageDialog(this, "404 Not found ! \n Không tìm thấy sinh viên !");
            }
        }
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnDelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelActionPerformed
        if (textSearch.getText().isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Nhập mã sinh viên muốn xóa", "Thông báo", JOptionPane.ERROR_MESSAGE);
        } else {
            int confirm = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn xóa sinh viên " + textSearch.getText() + " này không?", "Xác nhận", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                if (UserService.isStudentExits(textSearch.getText())) {
                    try {
                        if (UserService.deleteStudent(textSearch.getText())) {
                            JOptionPane.showMessageDialog(null, "Xóa sinh viên thành công!");
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(TableStudentAdmin.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "404 Not found! \n Không tìm thấy sinh viên cần xóa");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Bạn vừa hủy hành động xóa!");
            }
        }
    }//GEN-LAST:event_btnDelActionPerformed

    private void refreshMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_refreshMouseClicked
        try {
            reloadDataTable(TeacherService.getAllStudent());
        } catch (SQLException ex) {
            Logger.getLogger(TableStudentAdmin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(TableStudentAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_refreshMouseClicked

    private void btnSearchByClassNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchByClassNameActionPerformed
        try {
            int idClass = boxClass.getSelectedIndex();
            if (idClass == 0) {
                reloadDataTable(TeacherService.getAllStudent());
            } else {
                reloadDataTable(TeacherService.getListByClass(idClass));
            }
        } catch (SQLException ex) {
            Logger.getLogger(TableStudentAdmin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(TableStudentAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSearchByClassNameActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TableStudentAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TableStudentAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TableStudentAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TableStudentAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TableStudentAdmin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> boxClass;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDel;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnSearchByClassName;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel refresh;
    private javax.swing.JTable tableListStudent;
    private javax.swing.JTextField textSearch;
    // End of variables declaration//GEN-END:variables
}
