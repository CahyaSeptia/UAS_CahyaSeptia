package com.example.uas_cahyaseptia.tugas;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.uas_cahyaseptia.R;
import com.example.uas_cahyaseptia.activity.MainActivity;
import com.example.uas_cahyaseptia.mahasiswa.DatabaseHelper;

public class Sqlite extends AppCompatActivity {

    DatabaseHelper myDb;

    EditText editName,editSurname,editMarks,editTextId;

    Button btnAddData;

    Button btnViewAll;

    Button btnUpdate;

    Button btnDelete;



    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_sqlite);

        myDb = new DatabaseHelper(this);

        editName = (EditText)findViewById(R.id.editText_name);

        editSurname = (EditText)findViewById(R.id.editText_surname);

        editMarks = (EditText)findViewById(R.id.editText_marks);

        editTextId = (EditText)findViewById(R.id.editTextId);

        btnAddData = (Button)findViewById(R.id.button_add);

        btnViewAll = (Button)findViewById(R.id.button_view);

        btnUpdate = (Button)findViewById(R.id.button_update);

        btnDelete = (Button)findViewById(R.id.button_delete);

        AddData();

        viewAll();

        UpdateData();

        deleteData();

    }



    //fungsi hapus

    public void deleteData() {

        btnDelete.setOnClickListener(

                new View.OnClickListener() {

                    @Override

                    public void onClick(View v) {

                        Integer deletedRows = myDb.deleteData(editTextId.getText().toString());

                        if (deletedRows > 0)

                            Toast.makeText(Sqlite.this,"Data Deleted",Toast.LENGTH_LONG).show();

                        else

                            Toast.makeText(Sqlite.this,"Data Failed to Deleted!",Toast.LENGTH_LONG).show();

                    }

                }

        );

    }



    //fungsi update

    public void UpdateData() {

        btnUpdate.setOnClickListener(

                new View.OnClickListener() {

                    @Override

                    public void onClick(View v) {

                        boolean isUpdate = myDb.updateData(editTextId.getText().toString(),

                                editName.getText().toString(),

                                editSurname.getText().toString(),

                                editMarks.getText().toString());

                        if(isUpdate == true)

                            Toast.makeText(Sqlite.this,"Data Updated",Toast.LENGTH_LONG).show();

                        else

                            Toast.makeText(Sqlite.this,"Data Failed to Update",Toast.LENGTH_LONG).show();

                    }

                }

        );

    }



    //fungsi tambah

    public void AddData() {

        btnAddData.setOnClickListener(

                new View.OnClickListener() {

                    @Override

                    public void onClick(View v) {

                        boolean isInserted = myDb.insertData(editName.getText().toString(),

                                editSurname.getText().toString(),

                                editMarks.getText().toString() );

                        if(isInserted == true)

                            Toast.makeText(Sqlite.this,"Data Berhasi disimpan",Toast.LENGTH_LONG).show();

                        else

                            Toast.makeText(Sqlite.this,"Data Tidak Berhasil disimpan",Toast.LENGTH_LONG).show();

                    }

                }

        );

    }



    //fungsi menampilkan data

    public void viewAll() {

        btnViewAll.setOnClickListener(

                new View.OnClickListener(){

                    @Override

                    public void onClick(View v) {

                        Cursor res = myDb.getAllData();

                        if(res.getCount() == 0) {

                            // show message

                            showMessage("Error","Noting Found");

                            return;

                        }



                        StringBuffer buffer = new StringBuffer();

                        while (res.moveToNext() ) {

                            buffer.append("Id :"+ res.getString(0)+"\n");

                            buffer.append("Nama :"+ res.getString(1)+"\n");

                            buffer.append("NIM :"+ res.getString(2)+"\n");

                            buffer.append("Alamat :"+ res.getString(3)+"\n\n");

                        }



                        // show all data

                        showMessage("Data",buffer.toString());

                    }

                }

        );

    }



    //membuat alert dialog

    public void showMessage(String title, String Message){

        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setCancelable(true);

        builder.setTitle(title);

        builder.setMessage(Message);

        builder.show();

    }

}
