package com.example.rahul.interactivitycommunication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Activity1 extends AppCompatActivity {
    public static final String KEY_MY_NAME = "myName";
    // public static final String KEY_BOOL = "boolean";
    public static final int REQ_NEW = 1234;

    /*
    * 1. Starting the new Activity
    * 2. Sending the data new Activity
    * 3. Getting the data new Activity
    * 4. throwing data back from new activity to previous activity
    *
    * */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1);

        findViewById(R.id.btnNext).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(Activity1.this, Activity2.class);

                Bundle bundle = new Bundle();

                bundle.putString(KEY_MY_NAME, getEmail());
                // bundle.putBoolean(KEY_BOOL, true);

                intent.putExtras(bundle);

                // startActivity(intent);

                startActivityForResult(intent, REQ_NEW);


            }
        });


    }

    private String getEmail() {

        return ((EditText)findViewById(R.id.edtName)).getText().toString();
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQ_NEW) {


            if (resultCode == RESULT_OK) {

                Bundle bundle1 = data.getExtras();
                String resultBack = bundle1.getString(Activity2.KEY_MY_RES);


                if (data != null) {
                    ((EditText) findViewById(R.id.edtName))
                            .setText(data.getExtras().getString(Activity2.KEY_MY_RES));


                }
            }

        }


    }
}





