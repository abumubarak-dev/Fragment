package com.example.user.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class DetailsFragment extends Fragment {

    TextView textView;
    String mMessage;
    OnListFragmentInteractionListener listener;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("kk",mMessage);
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.fragment_details,container,false);

        textView=view.findViewById(R.id.txt);

        Bundle bundle=this.getArguments();

        if (bundle!=null && !bundle.isEmpty()){

            mMessage=(bundle.getString(getString(R.string.msg)));

            textView.setText(mMessage);

        }
        return view;

    }
    @Override
    public void onResume() {
        super.onResume();
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        listener=(OnListFragmentInteractionListener) getActivity();
    }
}
