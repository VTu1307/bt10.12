package com.example.bt1012;

public class Thuvien implements QuanLySach {
    private String id;
    private String ten;
    private Book[] books;
    private int soluongsach;
    public Thuvien(String id, String ten, int maxBooks) {
        this.id = id;
        this.ten = ten;
        this.books = new Book[maxBooks];
        this.soluongsach = 0;
    }

    public String getId() { return id; }
    public void setId(String id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }
    public void setTen(String ten) {
        this.ten = ten;
    }

    public Book[] getBooks() {
        return books;
    }
    public void setBooks(Book[] books) {
        this.books = books;
    }

    public int getSoluongsach() {
        return soluongsach;
    }
    public void setSoluongsach(int soluongsach) {
        this.soluongsach = soluongsach;
    }

    @Override
    public void themSachMoi(Book book) {
        if (soluongsach < books.length) {
            books[soluongsach++] = book;
        } else {
            System.out.println("Không thể thêm sách, thư viện đã đầy!");
        }
    }

    @Override
    public void xoaSach(int bookId) {
        for (int i = 0; i < soluongsach; i++) {
            if (Integer.parseInt(books[i].getId()) == bookId) {
                for (int j = i; j < soluongsach - 1; j++) {
                    books[j] = books[j + 1];
                }
                books[--soluongsach] = null;
                System.out.println("Sách đã được xóa.");
                return;
            }
        }
        System.out.println("Không tìm thấy sách với ID: " + bookId);
    }

    @Override
    public Book timSach(String keyword) {
        for (int i = 0; i < soluongsach; i++) {
            if (books[i].getTieude().contains(keyword) || books[i].getTacgia().contains(keyword)) {
                return books[i];
            }
        }
        return null;
    }

    @Override
    public void hienThiDanhSach() {
        if (soluongsach == 0) {
            System.out.println("Không có sách trong thư viện.");
        } else {
            for (int i = 0; i < soluongsach; i++) {
                System.out.println(books[i]);
            }
        }
    }
    @Override
    public String toString() {
        return "Thư viện: " + ten + " (ID: " + id + "), Tổng số sách: " + soluongsach;
    }
    public void sapxeptheonam() {
        for (int i = 0; i < soluongsach - 1; i++) {
            for (int j = i + 1; j < soluongsach; j++) {
                if (books[i].getNamxuatban() > books[j].getNamxuatban()) {
                    Book temp = books[i];
                    books[i] = books[j];
                    books[j] = temp;
                }
            }
        }
    }
    public void sapxepthetheloai() {
        for (int i = 0; i < soluongsach - 1; i++) {
            for (int j = i + 1; j < soluongsach; j++) {
                if (books[i].getTieude().compareTo(books[j].getTieude()) > 0) {
                    Book temp = books[i];
                    books[i] = books[j];
                    books[j] = temp;
                }
            }
        }
    }
}
