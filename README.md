# Dự án Quản lý Điểm Sinh viên

[![Build Status](https://img.shields.io/badge/build-passing-brightgreen)](https://example.com/build)
[![License](https://img.shields.io/badge/license-MIT-blue)](https://opensource.org/licenses/MIT)

## Giới thiệu

Dự án Quản lý Điểm Sinh viên là một ứng dụng Java Swing giúp quản lý điểm của sinh viên/học sinh trong một trường học. Ứng dụng này cho phép người dùng đăng nhập, thay đổi mật khẩu, quản lý điểm của sinh viên và hiển thị thông tin cá nhân/thông tin điểm của sinh viên.

## Tính năng

*   Đăng nhập và quản lý tài khoản người dùng, phân chia role (Admin/Student)
*   Thay đổi mật khẩu
*   Quản lý điểm của sinh viên (Thêm, Sửa, Xóa, Tìm kiếm)
*   Hiển thị thông tin về điểm của sinh viên (Theo lớp, theo sinh viên)
*   Hiển thị danh sách sinh viên
*   Xuất báo cáo Kết quả học tập (KQHT), bảng điểm ra file PDF

## Công nghệ sử dụng

*   **Giao diện người dùng:** Java Swing
*   **Cơ sở dữ liệu:** MySQL
*   **Thư viện:** itextpdf, mysql-jdbc ... (đính kèm trong folder libs)

## Cài đặt

1.  **Cài đặt Java Development Kit (JDK):** Tải và cài đặt JDK từ [website chính thức của Oracle](https://www.oracle.com/java/technologies/javase-downloads.html) hoặc [Adoptium (AdoptOpenJDK)](https://adoptium.net/).
2.  **Cài đặt MySQL Server:** Sử dụng Docker, DBeaver, DB Workbench hoặc đơn giản hơn là cài đặt MySQL Server từ [website chính thức của MySQL](https://www.mysql.com/downloads/).
3.  **Clone dự án về máy tính:**
    ```bash
    git clone git@github.com:int710/ManageStudentGrade.git
    ```
4.  **Cấu hình kết nối cơ sở dữ liệu:** Sửa file cấu hình (ví dụ: `/config/MySQLConnection.java`) để kết nối đến cơ sở dữ liệu MySQL của bạn. Có sẵn file SQL trong đó để xem thông tin các bảng cơ sở dữ liệu.
5.  **Biên dịch và chạy ứng dụng:**
    *   Sử dụng IDE (IntelliJ IDEA, NetBeans, Eclipse)

## Sử dụng

1.  Đăng nhập vào ứng dụng bằng tài khoản người dùng.
2.  Thay đổi mật khẩu nếu cần.
3.  Quản lý điểm của sinh viên (thêm, sửa, xóa điểm).
4.  Xem thông tin điểm của sinh viên.

## Phát triển

Dự án này được phát triển bởi tôi trong quá trình học tập môn OOP. Dự án được làm trong thời gian ngắn nên còn rất nhiều điều chưa hợp lý và chưa hoàn thiện tốt, chỉ có vài chức năng cơ bản mang tính chất trong quá trình học tập và nghiên cứu là chủ yếu.

## Đóng góp

Mọi đóng góp cho dự án đều được hoan nghênh. Vui lòng tạo pull request hoặc báo cáo lỗi (issues) trên GitHub.

## Liên hệ

Nếu bạn có bất kỳ câu hỏi hoặc vấn đề nào liên quan đến dự án này, vui lòng liên hệ với tôi.
