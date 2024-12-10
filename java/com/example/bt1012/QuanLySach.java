package com.example.bt1012;

public interface QuanLySach {
    void themSachMoi(Book book);  // Thêm sách mới
    void xoaSach(int bookId);     // Xóa sách
    Book timSach(String keyword); // Tìm kiếm sách theo tiêu đề hoặc tác giả
    void hienThiDanhSach();       // Hiển thị danh sách sách
}

