package com.vinhbqph33437.lab2_ph33437

import java.util.Scanner

data class SinhVien(var ten: String, var mssv: String, var diemTB: Float, var daTotNghiep: Boolean?, var tuoi: Int?)

class QuanLySinhVien {
    private val danhSachSV = mutableListOf<SinhVien>()

    fun themSinhVien(sv: SinhVien) {
        danhSachSV.add(sv)
    }

    fun xoaSinhVien(mssv: String) {
        val sv = danhSachSV.find { it.mssv == mssv }
        sv?.let {
            danhSachSV.remove(it)
            println("Đã xóa sinh viên có MSSV $mssv")
        } ?: println("Không tìm thấy sinh viên có MSSV $mssv")
    }

    fun xemDanhSachSinhVien() {
        if (danhSachSV.isEmpty()) {
            println("Danh sách sinh viên trống.")
        } else {
            println("Danh sách sinh viên:")
            danhSachSV.forEachIndexed { index, sv ->
                println("${index + 1}. Tên: ${sv.ten}, MSSV: ${sv.mssv}, Điểm TB: ${sv.diemTB}, Đã tốt nghiệp: ${sv.daTotNghiep}, Tuổi: ${sv.tuoi}")
            }
        }
    }
}

fun main() {
    val quanLySV = QuanLySinhVien()
    val scanner = Scanner(System.`in`)

    // Thêm sinh viên
    quanLySV.themSinhVien(SinhVien("Bùi Quang Vinh", "PH33437", 8.5f, true, 21))
    quanLySV.themSinhVien(SinhVien("Nguyễn Văn Vũ", "PH33438", 7.9f, false, 22))

    while (true) {
        println("Chọn chức năng:")
        println("1. Thêm sinh viên")
        println("2. Xóa sinh viên")
        println("3. Xem danh sách sinh viên")
        println("0. Thoát chương trình")
        print("Nhập lựa chọn của bạn: ")
        when (scanner.nextInt()) {
            1 -> {
                println("Nhập thông tin sinh viên mới:")
                print("Tên: ")
                val ten = readLine() ?: ""
                print("MSSV: ")
                val mssv = readLine() ?: ""
                print("Điểm TB: ")
                val diemTB = scanner.nextFloat()
                print("Đã tốt nghiệp? (true/false): ")
                val daTotNghiep = scanner.nextBoolean()
                print("Tuổi: ")
                val tuoi = scanner.nextInt()
                quanLySV.themSinhVien(SinhVien(ten, mssv, diemTB, daTotNghiep, tuoi))
            }
            2 -> {
                print("Nhập MSSV của sinh viên cần xóa: ")
                val mssv = readLine() ?: ""
                quanLySV.xoaSinhVien(mssv)
            }
            3 -> quanLySV.xemDanhSachSinhVien()
            0 -> {
                println("Đã thoát chương trình.")
                return
            }
            else -> println("Lựa chọn không hợp lệ. Vui lòng chọn lại.")
        }
    }
}
