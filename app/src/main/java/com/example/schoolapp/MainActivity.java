package com.example.schoolapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final int REQUEST_CODE = 1 ;
    public static final String INTENT_EXTRA = "login";

    TextView mTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonLogin = findViewById(R.id.btnLogin);

        buttonLogin.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Register.class);
                //startActivity(intent);
                intent.putExtra(INTENT_EXTRA, "Value Entered");
                startActivity(intent);
                //startActivityForResult(intent,REQUEST_CODE);
            }
        });

        SharedPreferences sharedPreferences = getSharedPreferences(Register.PREF_ID, Context.MODE_PRIVATE);
        //SharedPreferences.Editor editor = sharedPreferences.edit();
        String name = sharedPreferences.getString("name","defaultValue");
        String add = sharedPreferences.getString("address","");
        String pop = sharedPreferences.getString("population","");

        mTextView = findViewById(R.id.textView);
        mTextView.setText(name + " address: " + add + "population:" + pop);

        new SchoolAsyncTask().execute();

        Toast.makeText(this,"Got Here", Toast.LENGTH_LONG).show();


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

       /* if(requestCode == REQUEST_CODE){
            if(resultCode == RESULT_OK){
                String reply = data.getStringExtra("reply");
                mTextView = findViewById(R.id.textView);
                mTextView.setText(reply);
            }
        }*/
    }

    class SchoolAsyncTask extends AsyncTask<Void,Void,String>{

        @Override
        protected void onPreExecute() {
            mTextView = findViewById(R.id.textView);
            mTextView.setText("Background Process Started");

        }

        @Override
        protected String doInBackground(Void... voids) {
            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            mTextView = findViewById(R.id.textView);
            mTextView.setText("Completed Successfully");

        }

    }
}
