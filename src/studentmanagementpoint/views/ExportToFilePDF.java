package studentmanagementpoint.views;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;

import javax.swing.JTable;
import java.io.FileOutputStream;

public class ExportToFilePDF {

    public static boolean exportTableToPDF(JTable table, String filePath, String studentName, String studentID, String className, String dob, String faculty, String address) {
        try {
            // Đường dẫn font
            BaseFont baseFont = BaseFont.createFont("D:\\Workspace\\JavaOOP\\CNPM\\StudentManagementPoint\\src\\studentmanagementpoint\\assets\\font\\times.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);

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

            // Thêm thông tin sinh viên
            document.add(new Paragraph("Họ và Tên: " + studentName, cellFont));
            document.add(new Paragraph("Mã SV: " + studentID, cellFont));
            document.add(new Paragraph("Lớp: " + className, cellFont));
            document.add(new Paragraph("Ngày sinh: " + dob, cellFont));
            document.add(new Paragraph("Khoa: " + faculty, cellFont));
            document.add(new Paragraph("Quê quán: " + address, cellFont));
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
                    297.5f, 421, writer.getPageNumber() % 2 == 0 ? 45 : -45);

            // Đóng tài liệu
            document.close();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void main(String[] args) {
        // Test xuất PDF
        JTable table = new JTable(
                new Object[][]{
                        {"Chung003", "Tiếng Anh 3", "4", "6.0", "6.0", "5.0", "5.3", "D+", "Hoàn thành"},
                        {"CNTT101", "Cấu trúc dữ liệu", "2", "8.0", "8.0", "9.0", "8.7", "A", "Hoàn thành"},
                        {"CNTT102", "Chương trình dịch", "2", "8.0", "8.0", "7.5", "7.65", "B", "Hoàn thành"},
                        {"CNTT110", "Lập trình cơ bản", "3", "10.0", "9.0", "8.0", "8.39", "B+", "Hoàn thành"}
                },
                new String[]{"Mã MH", "Tên MH", "Tín chỉ", "Điểm TP", "Điểm GK", "Điểm CK", "Điểm KTHP", "Điểm chữ", "Trạng thái"}
        );

        exportTableToPDF(
                table,
                "StudentScores.pdf",
                "Bùi Thanh Quân",
                "CT070242",
                "CT7B",
                "07/10/2004",
                "Công nghệ thông tin",
                "Thanh Xuân - Hà Nội"
        );
    }
}
