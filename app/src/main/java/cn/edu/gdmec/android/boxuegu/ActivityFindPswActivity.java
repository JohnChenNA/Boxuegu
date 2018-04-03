package cn.edu.gdmec.android.boxuegu;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.Button;

public class ActivityFindPswActivity extends Activity implements View.OnClickListener {

    private TextView tvUserName;
    private TextView tvResetPsw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_psw);

        tvUserName = (TextView) findViewById(R.id.tv_user_name);
        tvResetPsw = (TextView) findViewById(R.id.tv_reset_psw);
        findViewById(R.id.btn_validate).setOnClickListener(this);
    }

    private EditText getEtUserName(){
        return (EditText) findViewById(R.id.et_user_name);
    }

    private EditText getEtValidateName(){
        return (EditText) findViewById(R.id.et_validate_name);
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_validate:
                //TODO implement
                break;
        }
    }
}
