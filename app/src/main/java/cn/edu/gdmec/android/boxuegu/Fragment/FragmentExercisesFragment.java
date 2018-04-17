package cn.edu.gdmec.android.boxuegu.Fragment;

import android.support.v4.app.Fragment;
import android.view.View;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import cn.edu.gdmec.android.boxuegu.Adapter.ExerciseListItemAdapter;
import cn.edu.gdmec.android.boxuegu.Bean.ExercisesBean;
import cn.edu.gdmec.android.boxuegu.R;


public class FragmentExercisesFragment extends Fragment  {

    private ListView lvList;
    private ExerciseListItemAdapter adapter;
    private List<ExercisesBean> ebl;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_exercises, null);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initData();
        lvList=(ListView) view.findViewById(R.id.lv_list);
        adapter=new ExerciseListItemAdapter(getActivity());
        adapter.setData(ebl);
        lvList.setAdapter(adapter);

    }

    private void initData(){
        ebl=new ArrayList<ExercisesBean>();
        for (int i=0;i<10;i++){
            ExercisesBean bean= new ExercisesBean();
            bean.id=(i+1);
            switch (i){
                case 0:
                    bean.title="第1章 Android基础入门";
                    bean.content="共计5题";
                    bean.background=(R.drawable.exercises_bg_1);
                    break;
                case 1:
                    bean.title="第2章 Android UI开发";
                    bean.content="共计5题";
                    bean.background=(R.drawable.exercises_bg_2);
                    break;
                case 2:
                    bean.title="第3章 Activity";
                    bean.content="共计5题";
                    bean.background=(R.drawable.exercises_bg_3);
                    break;
                case 3:
                    bean.title="第4章 数据储存";
                    bean.content="共计5题";
                    bean.background=(R.drawable.exercises_bg_4);
                    break;
                case 4:
                    bean.title="第5章 SQLite数据库";
                    bean.content="共计5题";
                    bean.background=(R.drawable.exercises_bg_1);
                    break;
                case 5:
                    bean.title="第6章 广播接收者";
                    bean.content="共计5题";
                    bean.background=(R.drawable.exercises_bg_2);
                    break;
                case 6:
                    bean.title="第7章 服务";
                    bean.content="共计5题";
                    bean.background=(R.drawable.exercises_bg_3);
                    break;
                case 7: bean.title="第8章 内容提供者";
                    bean.content="共计5题";
                    bean.background=(R.drawable.exercises_bg_4);
                    break;
                case 8:
                    bean.title="第9章 网络编程";
                    bean.content="共计5题";
                    bean.background=(R.drawable.exercises_bg_1);
                    break;
                case 9:
                    bean.title="第10章 高级编程";
                    bean.content="共计5题";
                    bean.background=(R.drawable.exercises_bg_2);
                    break;
            }
            ebl.add(bean);
        }
    }

}
