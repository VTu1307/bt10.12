package com.example.bt1012;

import javafx.application.Application;
import javafx.stage.Stage;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class LibraryApp extends Application {
    private Thuvien thuvien;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        // Tạo thư viện
        thuvien = new Thuvien("TV01", "Thư viện Hà Nội", 10);

        TextField txtId = new TextField();
        txtId.setPromptText("Mã sách");
        TextField txtTieude = new TextField();
        txtTieude.setPromptText("Tiêu đề");
        TextField txtTacgia = new TextField();
        txtTacgia.setPromptText("Tác giả");
        TextField txtTheloai = new TextField();
        txtTheloai.setPromptText("Thể loại");
        TextField txtNamxuatban = new TextField();
        txtNamxuatban.setPromptText("Năm xuất bản");
        CheckBox chkTrangthai = new CheckBox("Trạng thái");

        Button btnAdd = new Button("Thêm sách");
        Button btnRemove = new Button("Xóa sách");
        Button btnSearch = new Button("Tìm sách");
        Button btnShow = new Button("Hiển thị danh sách");

        btnAdd.setOnAction(e -> {
            String id = txtId.getText();
            String tieude = txtTieude.getText();
            String tacgia = txtTacgia.getText();
            String theloai = txtTheloai.getText();
            int namxuatban = Integer.parseInt(txtNamxuatban.getText());
            boolean trangthai = chkTrangthai.isSelected();
            Book newBook = new Book(id, tieude, tacgia, theloai, namxuatban, trangthai);
            thuvien.themSachMoi(newBook);
            clearFields(txtId, txtTieude, txtTacgia, txtTheloai, txtNamxuatban, chkTrangthai);
        });

        btnRemove.setOnAction(e -> {
            int bookId = Integer.parseInt(txtId.getText());
            thuvien.xoaSach(bookId);
            clearFields(txtId, txtTieude, txtTacgia, txtTheloai, txtNamxuatban, chkTrangthai);
        });

        btnSearch.setOnAction(e -> {
            String keyword = txtTieude.getText(); // Tìm theo tiêu đề sách
            Book foundBook = thuvien.timSach(keyword);
            if (foundBook != null) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Tìm thấy sách");
                alert.setHeaderText(null);
                alert.setContentText(foundBook.toString());
                alert.showAndWait();
            } else {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Không tìm thấy sách");
                alert.setHeaderText(null);
                alert.setContentText("Không có sách nào với tiêu đề \"" + keyword + "\".");
                alert.showAndWait();
            }
        });

        btnShow.setOnAction(e -> thuvien.hienThiDanhSach());

        VBox layout = new VBox(10);
        layout.getChildren().addAll(
                txtId, txtTieude, txtTacgia, txtTheloai, txtNamxuatban, chkTrangthai,
                btnAdd, btnRemove, btnSearch, btnShow
        );

        Scene scene = new Scene(layout, 400, 400);
        primaryStage.setTitle("Quản lý Thư viện");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void clearFields(TextField txtId, TextField txtTieude, TextField txtTacgia, TextField txtTheloai, TextField txtNamxuatban, CheckBox chkTrangthai) {
        txtId.clear();
        txtTieude.clear();
        txtTacgia.clear();
        txtTheloai.clear();
        txtNamxuatban.clear();
        chkTrangthai.setSelected(false);
    }
}
