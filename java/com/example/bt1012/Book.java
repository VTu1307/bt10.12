package com.example.bt1012;

public class Book {
    private String id;
    private String tieude;
    private String tacgia;
    private String theloai;
    private int namxuatban;
    private boolean trangthai;  

    
    public Book(String id, String tieude, String tacgia, String theloai, int namxuatban, boolean trangthai) {
        this.id = id;
        this.tieude = tieude;
        this.tacgia = tacgia;
        this.theloai = theloai;
        this.namxuatban = namxuatban;
        this.trangthai = trangthai;
    }

  
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getTieude() { return tieude; }
    public void setTieude(String tieude) { this.tieude = tieude; }

    public String getTacgia() { return tacgia; }
    public void setTacgia(String tacgia) { this.tacgia = tacgia; }

    public String getTheloai() { return theloai; }
    public void setTheloai(String theloai) { this.theloai = theloai; }

    public int getNamxuatban() { return namxuatban; }
    public void setNamxuatban(int namxuatban) { this.namxuatban = namxuatban; }

    public boolean isTrangthai() { return trangthai; }
    public void setTrangthai(boolean trangthai) { this.trangthai = trangthai; }

    @Override
    public String toString() {
        return "ID: " + id + ", Tiêu đề: " + tieude + ", Tác giả: " + tacgia + ", Thể loại: " + theloai
                + ", Năm xuất bản: " + namxuatban + ", Trạng thái: " + (trangthai ? "Sẵn sàng" : "Đang mượn");
    }
}

