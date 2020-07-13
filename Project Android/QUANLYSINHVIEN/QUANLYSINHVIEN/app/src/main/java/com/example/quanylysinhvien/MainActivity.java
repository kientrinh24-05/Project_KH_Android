package com.example.quanylysinhvien;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.quanylysinhvien.adapter.SinhVienAdapter;
import com.example.quanylysinhvien.dao.SinhVienDao;
import com.example.quanylysinhvien.loginandregisteractivity.LoginActivity;
import com.example.quanylysinhvien.model.SinhVien;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    EditText edtSearch;
    public static ArrayList<SinhVien> ds;
    ArrayList<SinhVien> timKiem = new ArrayList<>();
    SinhVienAdapter sinhVienAdapter;
    SinhVienDao sinhVienDao;
    Button btnthem;
    Button btntrolai;
    RelativeLayout relativeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        relativeLayout=findViewById(R.id.relativel_layout);
        edtSearch = findViewById(R.id.edtsearch);
        listView = findViewById(R.id.listSV);
        btnthem = findViewById(R.id.btnthem1);
        btntrolai=findViewById(R.id.btntrolai);


        ds = new ArrayList<>();
        sinhVienDao = new SinhVienDao(MainActivity.this);
        if (DanhSachLopActivity.xetList == true) {
            ds = DanhSachLopActivity.svlistDuocLoc;
        } else {
            ds = sinhVienDao.getALL();
        }
        timKiem = sinhVienDao.getALL();
        sinhVienAdapter = new SinhVienAdapter(MainActivity.this, ds);
        listView.setAdapter(sinhVienAdapter);
        // sự kiện thêm
        btnthem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ThemSinhVienActivity.class);
                startActivity(intent);
               overridePendingTransition(R.anim.ani_intent, R.anim.ani_intenexit);
            }
        });
        listView.setTextFilterEnabled(true);
        // Tìm Kiếm
        edtSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (count < before) {
                    sinhVienAdapter.resetData();
                } else {
                    sinhVienAdapter.getFilter().filter(s);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    // Quay lại manager
        btntrolai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ManagerActivity.class));
            }
        });

    }


    @Override
    protected void onResume() {

        if (DanhSachLopActivity.xetList == true) {
            ds = DanhSachLopActivity.svlistDuocLoc;
        } else {
            ds.clear();
            ds.addAll(sinhVienDao.getALL());
        }

        sinhVienAdapter.notifyDataSetChanged();
        super.onResume();


    }
}
