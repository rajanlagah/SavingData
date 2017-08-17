package com.exapmle.rajan.savingdata;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity{
    private static final String PREFS_FILE ="com.example.rajan.savingdata.preferences";
    private static final String KEY_STRING ="KEY_EDITTEXT";
    private static final String KEY_RECYCLE ="RECYCLER" ;
    private EditText mEditText;
    public RecyclerView mRecyclerView;
    private SharedPreferences mSharedPreferences;
    private SharedPreferences.Editor mEditor;
    public static int score[]=new int[18];

    @Override
    protected void onPause() {
        super.onPause();
       // mEditor.putString(KEY_STRING,mEditText.getText().toString());
       // mEditor.put
        mEditor.apply();
        System.out.println(mRecyclerView.findViewHolderForLayoutPosition(1)+" dsdsd");

        String s="";
        for(int i=0;i<score.length;i++){
            mEditor.putString("index "+i, String.valueOf(score[i]));
        }
        Toast.makeText(this,s,Toast.LENGTH_LONG).show();
     }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
     //   score=new int[18];
   /// mEditText=(EditText)findViewById(R.id.editText);
         mSharedPreferences=getSharedPreferences(PREFS_FILE, Context.MODE_PRIVATE);
         mEditor=mSharedPreferences.edit();

        mRecyclerView=(RecyclerView)findViewById(R.id.recyclerView);
       // mRecyclerView=mSharedPreferences.getClass(KEY_RECYCLE,(RecyclerView)findViewById(R.id.recyclerView));
        String editText=mSharedPreferences.getString(KEY_STRING,"");//second argumnent is for default value;
//        mEditText.setText(editText);

        //to delete single string from data use remove method
        //to clear all data (if user want to reset app) use clear method


        adapter ad=new adapter(score,this);
        mRecyclerView.setAdapter(ad);

        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);

        mRecyclerView.setHasFixedSize(true);
       }
       @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menubar,menu);

           return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==R.id.resetKey){
            Toast.makeText(this,"saa",Toast.LENGTH_LONG).show();

        }

        return super.onOptionsItemSelected(item);
    }
}
