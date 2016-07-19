package com.example.nanchen.designcoodinatordemo;

import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;

public class TextInputActivity extends AppCompatActivity implements TextWatcher {

    private TextInputLayout textInput;
    private TextInputEditText textEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_input);

        textInput = (TextInputLayout) findViewById(R.id.text_input_layout);
        textInput.getEditText().addTextChangedListener(this);

        textEdit = (TextInputEditText) findViewById(R.id.text_input_edit);
        textEdit.addTextChangedListener(this);
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    //完成
    @Override
    public void afterTextChanged(Editable s) {
        if(s.length()<6){
            textInput.setError("密码不能小于6！");
            textInput.setErrorEnabled(true);
            textEdit.setError("邮箱长度不能小于6");

        }else{
            textInput.setErrorEnabled(false);
        }
    }
}
