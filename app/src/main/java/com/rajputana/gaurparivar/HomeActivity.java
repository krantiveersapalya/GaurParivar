package com.rajputana.gaurparivar;


import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.rajputana.gaurparivar.Adapter.PurvajHomeActivityAdapter;
import com.rajputana.gaurparivar.Model.Data;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;

import static android.widget.Toast.LENGTH_LONG;

public class HomeActivity extends AppCompatActivity {

    private Toolbar toolbar;

    private FloatingActionButton fab_btn;

    DatabaseReference reffdata;
    /*private FirebaseAuth mAuth;*/

    RecyclerView recyclerView;


    //Globar variable..
    long maxid = 0;

    ArrayList<Data> list = new ArrayList<>();
    PurvajHomeActivityAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        toolbar = findViewById(R.id.home_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("पूर्वज या पुरखा ");

//data show

        recyclerView = findViewById(R.id.recycler_home);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setStackFromEnd(true);
        /*layoutManager.setReverseLayout(true);*/
        recyclerView.setHasFixedSize(true);

        recyclerView.setLayoutManager(layoutManager);
        list = new ArrayList<Data>();

        reffdata = FirebaseDatabase.getInstance().getReference().child("Purvaj");
        reffdata.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    maxid = (dataSnapshot.getChildrenCount());
                }
                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                    Data d = dataSnapshot1.getValue(Data.class);
                    list.add(d);
                }
                adapter = new PurvajHomeActivityAdapter(HomeActivity.this, list);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(HomeActivity.this, "Opssss ..... facing some technical issue", LENGTH_LONG).show();
            }
        });

          reffdata.keepSynced(true);


        fab_btn = findViewById(R.id.fab);

        fab_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                customDialog();
                reffdata = FirebaseDatabase.getInstance().getReference().child("Purvaj");
            }
        });

    }


    private void customDialog() {

        AlertDialog.Builder mydialog = new AlertDialog.Builder(HomeActivity.this);

        LayoutInflater inflater = LayoutInflater.from(HomeActivity.this);
        View myview = inflater.inflate(R.layout.input_data, null);

        final AlertDialog dialog = mydialog.create();

        dialog.setView(myview);

        final EditText edtName = myview.findViewById(R.id.edt_name);
        final EditText edtFname = myview.findViewById(R.id.edt_fname);
        final EditText note = myview.findViewById(R.id.edt_note);
        Button btnSave = myview.findViewById(R.id.btn_save);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String mName = edtName.getText().toString().trim();
                String mFname = edtFname.getText().toString().trim();
                String mNote = note.getText().toString().trim();

                /*   String ammint=mAmount;
                 */
                if (TextUtils.isEmpty(mName)) {
                    edtName.setError("Required Field..");
                    return;
                }
                if (TextUtils.isEmpty(mFname)) {
                    edtFname.setError("Required Field..");
                    return;
                }
                if (TextUtils.isEmpty(mNote)) {
                    note.setError("Required Field..");
                    return;
                }
                Data data = new Data(mName, mFname, mNote);
                reffdata.child(String.valueOf(maxid + 1)).setValue(data);

                Toast.makeText(HomeActivity.this, "data inserted successfully", LENGTH_LONG).show();


/*
                String id=mDatabase.push().getKey();

                String date= DateFormat.getDateInstance().format(new Date());

                Data data=new Data(mType,ammint,mNote,date,id);

                mDatabase.child(id).setValue(data);

                Toast.makeText(getApplicationContext(),"Data Add",Toast.LENGTH_SHORT).show();

*/
                dialog.dismiss();
                Intent intent = new Intent(HomeActivity.this,HomeActivity.class);
                finish();
                startActivity(intent);
            }
        });


        dialog.show();

    }


/*
    @Override
    protected void onStart() {
        super.onStart();
//here we have firebase recycler view adapter
 */
/*       FirebaseRecyclerAdapter<Data,MyViewHolder> adapter=new FirebaseRecyclerAdapter<Data, MyViewHolder>
                (
                        Data.class,
                        R.layout.item_data,
                        MyViewHolder.class,
                        datainsert
                )
        {
            @Override
            protected void populateViewHolder(MyViewHolder viewHolder, final Data model, final int position) {
                viewHolder.setName(model.getName());
                viewHolder.setFname(model.getFname());
                viewHolder.setNote(model.getNote());

*//*
     */
/*
                viewHolder.myview.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        post_key=getRef(position).getKey();
                        type=model.getName();
                        note=model.getNote();
                        amount=model.getFname();


                        updateData();
                    }
                });
*//*
     */
/*

            }
        };

        recyclerView.setAdapter(adapter);
*//*

    }
*/
/*
    public static class MyViewHolder extends RecyclerView.ViewHolder{

        View myview;

        public MyViewHolder(View itemView) {
            super(itemView);
            myview=itemView;
        }

        public void setName(String name){
            TextView mName=myview.findViewById(R.id.name);
            mName.setText(name);
        }

        public void setNote(String note){
            TextView mNote=myview.findViewById(R.id.note);
            mNote.setText(note);
        }

*//*
        public void setDate(String date){
            TextView mDate=myview.findViewById(R.id.date);
            mDate.setText(date);
        }
*//*

        public void setFname(String fname){

            TextView mFname=myview.findViewById(R.id.fname);
            mFname.setText(fname);

        }



    }
    *//*

    public void updateData(){

        AlertDialog.Builder mydialog=new AlertDialog.Builder(HomeActivity.this);

        LayoutInflater inflater=LayoutInflater.from(HomeActivity.this);

        View mView=inflater.inflate(R.layout.update_inputfield,null);

        final AlertDialog dialog=mydialog.create();

        dialog.setView(mView);

        final EditText edt_Type=mView.findViewById(R.id.edt_type_upd);
        final EditText edt_Ammoun=mView.findViewById(R.id.edt_ammount_upd);
        final EditText edt_Note=mView.findViewById(R.id.edt_note_upd);

        edt_Type.setText(type);
        edt_Type.setSelection(type.length());

        edt_Ammoun.setText(String.valueOf(amount));
        edt_Ammoun.setSelection(String.valueOf(amount).length());

        edt_Note.setText(note);
        edt_Note.setSelection(note.length());



        Button btnUpdate=mView.findViewById(R.id.btn_SAVE_upd);
        Button btnDelete=mView.findViewById(R.id.btn_delete_upd);

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                type=edt_Type.getText().toString().trim();

                String mAmmount=String.valueOf(amount);

                mAmmount=edt_Ammoun.getText().toString().trim();

                note=edt_Note.getText().toString().trim();

                String intammount=mAmmount;

                String date=DateFormat.getDateInstance().format(new Date());

                Data data=new Data(type,intammount,note,date,post_key);

                mDatabase.child(post_key).setValue(data);


                dialog.dismiss();
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mDatabase.child(post_key).removeValue();

                dialog.dismiss();

            }
        });



        dialog.show();




    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }
*/

    /*@Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.log_out:
*//*
                mAuth.signOut();
*//*
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
                break;
        }

        return super.onOptionsItemSelected(item);
    }*/
}
