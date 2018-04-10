package cn.edu.gdmec.android.boxuegu;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import cn.edu.gdmec.android.boxuegu.Fragment.FragmentCourseFragment;
import cn.edu.gdmec.android.boxuegu.Fragment.FragmentExercisesFragment;
import cn.edu.gdmec.android.boxuegu.Fragment.FragmentMyinfoFragment;
import cn.edu.gdmec.android.boxuegu.utils.AnalysisUtils;

public class MainActivity extends FragmentActivity implements View.OnClickListener{
    private TextView et_user_name;
    private RelativeLayout main_body;
    private TextView bottom_bar_text_course;
    private ImageView bottom_bar_image_course;
    private RelativeLayout bottom_bar_course_btn;
    private TextView bottom_bar_text_exercises;
    private ImageView bottom_bar_image_exercises;
    private RelativeLayout bottom_bar_exercises_btn;
    protected long exitTiem;



    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (keyCode==KeyEvent.KEYCODE_BACK && event.getAction()==KeyEvent.ACTION_DOWN){
            if ((System.currentTimeMillis()-exitTiem)>2000){
                Toast.makeText(MainActivity.this,"再按一次退出博学谷",Toast.LENGTH_SHORT).show();
                exitTiem=System.currentTimeMillis();

            }else{
                this.finish();
                if(AnalysisUtils.readLoginStatus(this)){

                    AnalysisUtils.clearLoginStatus(this);
                }
                System.exit(0);
            }
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(data!=null){
            boolean isLogin=data.getBooleanExtra("isLogin",false);
            if (isLogin){
                setSelectStatus(2);
            }
            else {
                setSelectStatus(2);
            }
        }
    }

    private TextView bottom_bar_text_myinfo;
    private ImageView bottom_bar_image_myinfo;
    private RelativeLayout bottom_bar_myinfo_btn;
    private LinearLayout main_bottom_bar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        et_user_name = findViewById(R.id.et_user_name);
        /*Intent intent = new Intent(MainActivity.this, LoginActivity.class);
        startActivityForResult(intent, 1);
*/
        setMain();
    }

//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        if (data != null) {
//            String userName = data.getStringExtra("userName");
//            //if (!TextUtils.isEmpty(userName)){
//            Toast.makeText(MainActivity.this, "登陆成功：" + userName, Toast.LENGTH_SHORT).show();
//            et_user_name.setText(userName);
//            //}
//        }
//    }

    private void initView() {
        main_body = (RelativeLayout) findViewById(R.id.main_body);
        bottom_bar_text_course = (TextView) findViewById(R.id.bottom_bar_text_course);
        bottom_bar_image_course = (ImageView) findViewById(R.id.bottom_bar_image_course);
        bottom_bar_course_btn = (RelativeLayout) findViewById(R.id.bottom_bar_course_btn);
        bottom_bar_text_exercises = (TextView) findViewById(R.id.bottom_bar_text_exercises);
        bottom_bar_image_exercises = (ImageView) findViewById(R.id.bottom_bar_image_exercises);
        bottom_bar_exercises_btn = (RelativeLayout) findViewById(R.id.bottom_bar_exercises_btn);
        bottom_bar_text_myinfo = (TextView) findViewById(R.id.bottom_bar_text_myinfo);
        bottom_bar_image_myinfo = (ImageView) findViewById(R.id.bottom_bar_image_myinfo);
        bottom_bar_myinfo_btn = (RelativeLayout) findViewById(R.id.bottom_bar_myinfo_btn);
        main_bottom_bar = (LinearLayout) findViewById(R.id.main_bottom_bar);

        bottom_bar_course_btn.setOnClickListener(this);
        bottom_bar_exercises_btn.setOnClickListener(this);
        bottom_bar_myinfo_btn.setOnClickListener(this);

    }
    private void setSelectStatus(int index){
        switch(index){
            case 0:
                bottom_bar_image_course.setImageResource(R.drawable.main_course_icon_selected);
                bottom_bar_text_course.setTextColor(Color.parseColor("#0097F7"));

                bottom_bar_image_exercises.setImageResource(R.drawable.main_course_icon);
                bottom_bar_text_exercises.setTextColor(Color.parseColor("#666666"));

                bottom_bar_image_myinfo.setImageResource(R.drawable.main_course_icon);
                bottom_bar_text_myinfo.setTextColor(Color.parseColor("#666666"));

                break;

            case 1:
                bottom_bar_image_exercises.setImageResource(R.drawable.main_exercises_icon_selected);
                bottom_bar_text_exercises.setTextColor(Color.parseColor("#0097F7"));

                bottom_bar_image_course.setImageResource(R.drawable.main_course_icon);
                bottom_bar_text_course.setTextColor(Color.parseColor("#666666"));

                bottom_bar_image_myinfo.setImageResource(R.drawable.main_my_icon);
                bottom_bar_text_myinfo.setTextColor(Color.parseColor("#666666"));
                break;

            case 2:
                bottom_bar_image_myinfo.setImageResource(R.drawable.main_my_icon_selected);
                bottom_bar_text_myinfo.setTextColor(Color.parseColor("#0097F7"));

                bottom_bar_image_course.setImageResource(R.drawable.main_course_icon);
                bottom_bar_text_course.setTextColor(Color.parseColor("#666666"));

                bottom_bar_image_exercises.setImageResource(R.drawable.main_exercises_icon);
                bottom_bar_text_exercises.setTextColor(Color.parseColor("#666666"));
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bottom_bar_course_btn:
                this.getSupportFragmentManager().beginTransaction().add(R.id.main_body,
                        new FragmentCourseFragment()).commit();
                setSelectStatus(0);
                break;

            case R.id.bottom_bar_exercises_btn:
                this.getSupportFragmentManager().beginTransaction().add(R.id.main_body,
                        new FragmentExercisesFragment()).commit();
                setSelectStatus(1);
                break;

            case R.id.bottom_bar_myinfo_btn:
                this.getSupportFragmentManager().beginTransaction().add(R.id.main_body,
                        new FragmentMyinfoFragment()).commit();
                setSelectStatus(2);
                break;

        }
    }

    private void setMain(){
        this.getSupportFragmentManager().beginTransaction().add(R.id.main_body,
                new FragmentMyinfoFragment()).commit();
        setSelectStatus(0);
    }
}