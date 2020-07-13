package com.example.quanylysinhvien;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.quanylysinhvien.adapter.LopAdapter;
import com.example.quanylysinhvien.dao.LopDao;
import com.example.quanylysinhvien.dao.SinhVienDao;
import com.example.quanylysinhvien.loginandregisteractivity.LoginActivity;
import com.example.quanylysinhvien.model.Lop;
import com.example.quanylysinhvien.model.SinhVien;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class DanhSachLopActivity extends AppCompatActivity {
    TextView tvanhien;
    EditText edtSearch;
    Button btnthem,btntrolai;
    ArrayList<Lop> dsLop = new ArrayList<>();
    ArrayList<Lop> timKiem = new ArrayList<>();
    ArrayList<SinhVien> svlist;
    static ArrayList<SinhVien> svlistDuocLoc;
    public static boolean xetList = true;
    ListView listView;
    LopAdapter lopAdapter;
    LopDao lopDao;
    SinhVienDao sinhVienDao;
   RelativeLayout relativeLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danh_sach_lop);
        relativeLayout=findViewById(R.id.relativel_layout);
        listView = findViewById(R.id.listviewLop);
        tvanhien = findViewById(R.id.tvAnHien);
        edtSearch = findViewById(R.id.edtserchLop);
        btnthem=findViewById(R.id.btninsert);
        btntrolai=findViewById(R.id.btntrolai1);
        fbAction();
        lopDao = new LopDao(DanhSachLopActivity.this);

        dsLop = lopDao.getAll();
        timKiem = lopDao.getAll();

        //Sự  Kiện nút thêm
        btnthem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DanhSachLopActivity.this, ThemLopActivity.class));
            }
        });

        lopAdapter = new LopAdapter(DanhSachLopActivity.this, R.layout.dong_lop, dsLop);
        listView.setAdapter(lopAdapter);

        if (dsLop.size() == 0) {
            listView.setVisibility(View.INVISIBLE);
            tvanhien.setVisibility(View.VISIBLE);
        } else {
            listView.setVisibility(View.VISIBLE);
            tvanhien.setVisibility(View.INVISIBLE);
        }
        // Click vào listview sẽ hiện sinh viên của lớp đó
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String maLop = dsLop.get(position).toString();
                sinhVienDao = new SinhVienDao(DanhSachLopActivity.this);
                svlist = sinhVienDao.getALL();
                int dem = 0;
                svlistDuocLoc = new ArrayList<>();
                for (int i = 0; i < svlist.size(); i++) {

                    SinhVien sv = svlist.get(i);
                    if (maLop.matches(sv.getMaLop())) {
                        svlistDuocLoc.add(svlist.get(i));
                        dem++;
                    }
                }
                if (dem > 0) {
                    Intent i = new Intent(DanhSachLopActivity.this, MainActivity.class);
                    xetList = true;
                    startActivity(i);
                } else {
                    Toast.makeText(DanhSachLopActivity.this, "Không có sinh viên nào thuộc mã lớp " + dsLop.get(position), Toast.LENGTH_LONG).show();
                }
            }
        });

 // Tìm kiếm
        edtSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                //Search or Filter
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (count < before) {
                    lopAdapter.resetData();
                } else {
                    lopAdapter.getFilter().filter(s);
                }
            }
            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }
  // Quay lại form manager
    private void fbAction() {
        btntrolai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DanhSachLopActivity.this, ManagerActivity.class));
            }
        });
    }


}
