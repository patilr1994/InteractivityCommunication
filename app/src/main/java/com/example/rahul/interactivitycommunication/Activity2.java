package com.example.rahul.interactivitycommunication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Activity2 extends AppCompatActivity {

    public static final String KEY_MY_RES ="myResult";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        Intent responsibleIntent = getIntent();

        Bundle bundle = responsibleIntent.getExtras();

        if (bundle!=null) {

            String myName = bundle.getString(Activity1.KEY_MY_NAME);
            // Boolean bool = bundle.getBoolean(Activity1.KEY_BOOL);

            ((EditText)findViewById(R.id.edtResult)).setText(myName);


            //((EditText)findViewById(R.id.edtResult)).setText(myName+ System.currentTimeMillis());


        }
        findViewById(R.id.btnBack).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent();

                Bundle bundle1 = new Bundle();

                bundle1.putString(KEY_MY_RES,((EditText)findViewById(R.id.edtResult)).getText().toString().toUpperCase());

                intent.putExtras(bundle1);
                setResult(RESULT_OK,intent);
                finish();

            }
        });



    }
}