package net.gfdz.com.drawerlayoutdemo.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import net.gfdz.com.drawerlayoutdemo.R;

/**
 * Created by Administrator on 2015/12/2.
 */
public class ContentFragment extends Fragment {
   private TextView tvContent;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
       View view= inflater.inflate(R.layout.fragment_content, container, false);
        tvContent= (TextView) view.findViewById(R.id.tvContent);
        String text=  getArguments().getString("text");
        tvContent.setText(text);
        return view;
    }
}
