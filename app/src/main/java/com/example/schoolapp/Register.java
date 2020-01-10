package com.example.schoolapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Register extends AppCompatActivity {

    public static final String PREF_ID = "prefence_ID";
    private static final String LOG_CAT = Register.class.getSimpleName();
    private SharedPreferences mSharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        EditText schoolName = findViewById(R.id.editTextName);
        EditText schoolAdd = findViewById(R.id.editTextAddress);
        EditText population = findViewById(R.id.editTextPopulation);

        mSharedPreferences = getSharedPreferences(PREF_ID, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor =  mSharedPreferences.edit();
        editor.putString("name",schoolName.getText().toString());
        editor.putString("address", schoolAdd.getText().toString());
        editor.putString("population", population.getText().toString());
        editor.commit();

        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.INTENT_EXTRA);
        EditText name = findViewById(R.id.editTextName);
        name.setText(message);



       /* Intent intentReply = new Intent();
        intentReply.putExtra("reply", "Reply from Activity");
        setResult(RESULT_OK,intentReply);
        finish(); */

    }

    public void returnReply(View view){

        Log.d(LOG_CAT,"Reach Here" + mSharedPreferences.getString("name","DefaultValue"));

        Toast.makeText(this,"Got Here", Toast.LENGTH_LONG).show();
        //Intent intentReply = new Intent(this, MainActivity.class);
        //startActivity(intentReply);
        //intentReply.putExtra("reply", "Reply from Activity");
        //setResult(RESULT_OK,intentReply);
        //finish();
    }
}
