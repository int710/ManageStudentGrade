package studentmanagementpoint.views;

import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import studentmanagementpoint.dto.GradeModel;
import studentmanagementpoint.dto.StudentModel;
import studentmanagementpoint.service.GradenService;
import studentmanagementpoint.utils.SessionManager;

/**
 *
 * @author Admin
 */
public class GradenStudentAdmin extends javax.swing.JFrame {

    private static StudentModel student;
    private static int rowSelectedCurrent = -1;

    /**
     * Creates new form NewJFrame
     */
    public GradenStudentAdmin(StudentModel student) throws SQLException {
        if (!SessionManager.isLogin() || !SessionManager.isAdmin()) {
            JOptionPane.showMessageDialog(this, "Bạn không có quyền truy cập vào chức năng này!", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
            System.exit(0); // Đóng cửa sổ nếu không có quyền
        }
        this.student = student;
        setTitle("Quản lý điểm sinh viên " + student.getStudentId());
        initComponents();
        loadData();
        displayGrade(GradenService.getAllGradeByStudentId(student.getStudentId()));
        setLocationRelativeTo(null);
    }

    private void loadData() {
        txStudentId.setText(student.getStudentId());
        txStudentId.setEnabled(false);
        txFullname.setText(student.getName());
        txFullname.setEnabled(false);
        txClass.setText(student.getNameByClassId());
        txClass.setEnabled(false);
        txKhoa.setText(student.getNameDepartment());
        txKhoa.setEnabled(false);
        loadSubject();
    }

    private void loadSubject() {
        List<String> subjects = GradenService.getAllSubject(student.getDepartmentId());
        for (String subject : subjects) {
            cbSubject.addItem(subject);
        }
    }

    private void clearFields() {
        txDiemck.setText("");
        txDiemgk.setText("");
        txDiemtp.setText("");
    }

    private void displayGrade(List<GradeModel> grade) throws SQLException {
        DefaultTableModel tableModel = (DefaultTableModel) tableGraden.getModel();
        tableModel.setRowCount(0);

        for (GradeModel x : grade) {
            tableModel.addRow(new Object[]{
                x.getSubjectId(),
                x.getNameSubjectById(),
                x.getCredit(),
                x.getComponentScore(),
                x.getMidtermScore(),
                x.getFinalScore(),
                x.getFinalGrade(),
                x.getLetterGrade(),
                x.statusSubject()
            });
        }

        tableGraden.setModel(tableModel);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        txStudentId = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        cbSubject = new javax.swing.JComboBox<>();
        txKhoa = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txClass = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txFullname = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        txDiemgk = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txDiemck = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txDiemtp = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        btnAdd = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableGraden = new javax.swing.JTable();
        btnThongke = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("QUẢN LÝ KẾT QUẢ HỌC TẬP ");

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel3.setText("Lớp:");

        jLabel4.setText("Tên MH:");

        jLabel5.setText("Họ và Tên:");

        jLabel6.setText("Khoa:");

        jLabel2.setText("Mã SV:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(cbSubject, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(86, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txStudentId, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txClass, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(19, 19, 19)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txFullname)
                    .addComponent(txKhoa))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel5)
                    .addComponent(txStudentId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txFullname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel6)
                    .addComponent(txClass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txKhoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbSubject, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addContainerGap())
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel9.setText("Điểm cuối kì:");

        jLabel7.setText("Điểm thành phần:");

        txDiemtp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txDiemtpActionPerformed(evt);
            }
        });

        jLabel8.setText("Điểm giữa kì:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txDiemtp, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txDiemgk, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txDiemck, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txDiemtp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txDiemgk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txDiemck, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        btnAdd.setText("Thêm");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnUpdate.setText("Sửa");
        btnUpdate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnUpdateMouseClicked(evt);
            }
        });
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnDelete.setText("Xóa");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        tableGraden.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã MH", "Tên MH", "Số tín", "Điểm TP", "Điểm GK", "ĐIểm CK", "Điểm KTHP", "Điểm chữ", "Trang thái"
            }
        ));
        tableGraden.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableGradenMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableGraden);

        btnThongke.setText("Thống kê");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(43, 43, 43)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(230, 230, 230)
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(168, 168, 168)
                                .addComponent(btnAdd)
                                .addGap(26, 26, 26)
                                .addComponent(btnUpdate)
                                .addGap(18, 18, 18)
                                .addComponent(btnDelete)
                                .addGap(28, 28, 28)
                                .addComponent(btnThongke)))
                        .addGap(0, 36, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd)
                    .addComponent(btnUpdate)
                    .addComponent(btnDelete)
                    .addComponent(btnThongke))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txDiemtpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txDiemtpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txDiemtpActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        String subjectName = cbSubject.getSelectedItem() != null ? cbSubject.getSelectedItem().toString() : "";
        String studentId = txStudentId.getText().trim();
        float diemtp, diemgk, diemck;

        try {
            diemtp = Float.parseFloat(txDiemtp.getText().trim());
            diemgk = Float.parseFloat(txDiemgk.getText().trim());
            diemck = Float.parseFloat(txDiemck.getText().trim());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Điểm số phải là số thực!");
            return;
        }
        if (subjectName.isEmpty() || diemtp < 0 || diemtp > 10 || diemgk < 0 || diemgk > 10 || diemck < 0 || diemck > 10) {
            JOptionPane.showMessageDialog(null, "Vui lòng kiểm tra lại các giá trị điểm số!");
            return;
        }

        try {
            String subjectId;
            try {
                subjectId = GradenService.getSubjectIdByName(subjectName);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Lỗi khi lấy mã môn học!");
                Logger.getLogger(GradenStudentAdmin.class.getName()).log(Level.SEVERE, null, ex);
                return;
            }

            if (GradenService.insertGrade(studentId, subjectId, diemtp, diemgk, diemck)) {
                clearFields();
                displayGrade(GradenService.getAllGradeByStudentId(student.getStudentId()));
                JOptionPane.showMessageDialog(null, "Thành công");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Lỗi kết nối cơ sở dữ liệu! \n Có thể đã có điểm môn này");
            Logger.getLogger(GradenStudentAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnUpdateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUpdateMouseClicked

    }//GEN-LAST:event_btnUpdateMouseClicked

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        if (rowSelectedCurrent <= -1) {
            JOptionPane.showMessageDialog(this, "Hãy chọn một môn trước khi chỉnh sửa");
        } else {
            int confirm = JOptionPane.showConfirmDialog(null, "Cập nhật lại dữ liệu điểm môn này chứ? ", "Xác nhận", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                try {
                    if (GradenService.updateGrade(student.getStudentId(), (String) tableGraden.getValueAt(rowSelectedCurrent, 0),
                                Float.parseFloat(txDiemtp.getText()), Float.parseFloat(txDiemgk.getText()), Float.parseFloat(txDiemck.getText()))) {
                        JOptionPane.showMessageDialog(this, "Cập nhật thành công !");
                        displayGrade(GradenService.getAllGradeByStudentId(student.getStudentId()));
                        clearFields();
                    } else {
                        JOptionPane.showMessageDialog(this, "Thất bại ! \n Không cập nhật được điểm số", "Cập nhật điểm", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(GradenStudentAdmin.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {

            }
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void tableGradenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableGradenMouseClicked
        this.rowSelectedCurrent = tableGraden.rowAtPoint(evt.getPoint());
        txDiemtp.setText(String.valueOf(tableGraden.getValueAt(rowSelectedCurrent, 3)));
        txDiemgk.setText(String.valueOf(tableGraden.getValueAt(rowSelectedCurrent, 4)));
        txDiemck.setText(String.valueOf(tableGraden.getValueAt(rowSelectedCurrent, 5)));
    }//GEN-LAST:event_tableGradenMouseClicked

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        if (rowSelectedCurrent <= -1) {
            JOptionPane.showMessageDialog(this, "Hãy chọn một môn trước khi xóa");
        } else {
            int confirm = JOptionPane.showConfirmDialog(null, "Thực hiện xóa dữ liệu này? ", "Xác nhận", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                try {
                    if (GradenService.deleteGrade(student.getStudentId(), (String) tableGraden.getValueAt(rowSelectedCurrent, 0))) {
                        JOptionPane.showMessageDialog(this, "Xóa hoàn tất !");
                        displayGrade(GradenService.getAllGradeByStudentId(student.getStudentId()));
                        clearFields();
                    } else {
                        JOptionPane.showMessageDialog(this, "Thất bại ! \n Không cập nhật được điểm số", "Cập nhật điểm", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(GradenStudentAdmin.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                return;
            }
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

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
            java.util.logging.Logger.getLogger(GradenStudentAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GradenStudentAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GradenStudentAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GradenStudentAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new GradenStudentAdmin(student).setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(GradenStudentAdmin.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnThongke;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> cbSubject;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableGraden;
    private javax.swing.JTextField txClass;
    private javax.swing.JTextField txDiemck;
    private javax.swing.JTextField txDiemgk;
    private javax.swing.JTextField txDiemtp;
    private javax.swing.JTextField txFullname;
    private javax.swing.JTextField txKhoa;
    private javax.swing.JTextField txStudentId;
    // End of variables declaration//GEN-END:variables
}
