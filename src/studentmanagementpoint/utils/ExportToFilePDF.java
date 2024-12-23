package studentmanagementpoint.utils;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;

import javax.swing.JTable;
import java.io.FileOutputStream;
import java.sql.SQLException;
import studentmanagementpoint.dto.GradeModel;
import studentmanagementpoint.dto.StudentModel;
import studentmanagementpoint.dto.StudyResultModel;

public class ExportToFilePDF {

    public static boolean exportTableToPDF(JTable table, String filePath, String studentName, String studentID, String className, String dob, String faculty, String address, float gpa, String xeploai, int passCredit, int failCredit) {
        try {
            // Đường dẫn font
            BaseFont baseFont = BaseFont.createFont("\\src\\studentmanagementpoint\\assets\\font\\times.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);

            Font titleFont = new Font(baseFont, 16, Font.BOLD);
            Font headerFont = new Font(baseFont, 12, Font.BOLD);
            Font cellFont = new Font(baseFont, 12, Font.NORMAL);
            Font watermarkFont = new Font(baseFont, 20, Font.BOLD, BaseColor.LIGHT_GRAY);

            Document document = new Document();
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(filePath));

            document.open();

            // Thêm tiêu đề
            Paragraph title = new Paragraph("BẢNG ĐIỂM - KẾT QUẢ HỌC TẬP", titleFont);
            title.setAlignment(Element.ALIGN_CENTER);
            document.add(title);
            document.add(new Paragraph("\n"));
            
            // Thêm thông tin sinh viên
            document.add(new Paragraph("Họ và Tên: " + studentName, cellFont));
            document.add(new Paragraph("Mã SV: " + studentID, cellFont));
            document.add(new Paragraph("Lớp: " + className, cellFont));
            document.add(new Paragraph("Ngày sinh: " + dob, cellFont));
            document.add(new Paragraph("Khoa: " + faculty, cellFont));
            document.add(new Paragraph("Quê quán: " + address, cellFont));
            document.add(new Paragraph("\n"));
            String gpaString = String.format("%.2f", gpa);
            document.add(new Paragraph("GPA: " + gpaString, cellFont));
            document.add(new Paragraph("Xếp loại: " + xeploai, cellFont));
            document.add(new Paragraph("Tín chỉ tích lũy: " + passCredit , cellFont));
            document.add(new Paragraph("Tín chỉ nợ: " + failCredit, cellFont));
            document.add(new Paragraph("\n"));

            // Tạo bảng
            PdfPTable pdfTable = new PdfPTable(table.getColumnCount());
            pdfTable.setWidthPercentage(100);

            // Thêm tiêu đề cột
            for (int i = 0; i < table.getColumnCount(); i++) {
                PdfPCell headerCell = new PdfPCell(new Phrase(table.getColumnName(i), headerFont));
                headerCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                headerCell.setBackgroundColor(BaseColor.LIGHT_GRAY);
                pdfTable.addCell(headerCell);
            }

            // Thêm dữ liệu vào bảng
            for (int row = 0; row < table.getRowCount(); row++) {
                for (int col = 0; col < table.getColumnCount(); col++) {
                    String cellValue = table.getValueAt(row, col).toString();
                    PdfPCell cell = new PdfPCell(new Phrase(cellValue, cellFont));
                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    pdfTable.addCell(cell);
                }
            }

            document.add(pdfTable);

            // Thêm watermark
            PdfContentByte canvas = writer.getDirectContentUnder();
            ColumnText.showTextAligned(canvas, Element.ALIGN_CENTER,
                        new Phrase("int710 (thanhquan) - Version 1.0", watermarkFont),
                        297.5f, 721, writer.getPageNumber() % 2 == 0 ? 45 : -45);

            // Đóng tài liệu
            document.close();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    // Phương thức thêm hàng vào mảng
    public static Object[][] addRow(Object[][] data, GradeModel monHoc) throws SQLException {
        Object[][] newData = new Object[data.length + 1][9];
        System.arraycopy(data, 0, newData, 0, data.length);
        newData[data.length] = new Object[]{monHoc.getSubjectId(), monHoc.getNameSubjectById(), monHoc.getCredit(), monHoc.getComponentScore(), monHoc.getMidtermScore(), monHoc.getFinalScore(), monHoc.getFinalGrade(), monHoc.getLetterGrade(), monHoc.statusSubject()};
        return newData;
    }

    public static JTable initTableResult(java.util.List<GradeModel> grade) throws SQLException {
        Object[][] data = new Object[0][9];
        for (GradeModel x : grade) {
            data = addRow(data, x);
        }
        // Tạo bảng dữ liệu
        String[] columnNames = {"Mã MH", "Tên MH", "Tín chỉ", "Điểm TP", "Điểm GK", "Điểm CK", "Điểm KTHP", "Điểm chữ", "Trạng thái"};
        return new JTable(data, columnNames);
    }
}
