package com.example.nimmy.task9_quotes_fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Nimmy on 25-02-2017.
 */

public class ThirdFragment extends Fragment {

    private String id;
    private TextView t1;
    private Button share;
    private View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_main3, container, false);
        id = getArguments().getString("Quote");
        t1 = (TextView)view.findViewById(R.id.main_TV3);
        t1.setText(id);

        share = (Button)view.findViewById(R.id.main_button1);
        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent shareIntent = new Intent(Intent.ACTION_SEND);
                shareIntent.setType("text/plain");
                shareIntent.putExtra(Intent.EXTRA_TEXT, t1.getText());
                startActivity(Intent.createChooser(shareIntent, "Share Via"));
            }
        });
        return view;
    }
}
