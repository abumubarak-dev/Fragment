package com.example.user.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import java.util.ArrayList;
import java.util.List;

/**
 * A fragment representing a list of Items.
 * <p/>
 * Activities containing this fragment MUST implement the {@link OnListFragmentInteractionListener}
 * interface.
 */
public class ItemFragment extends Fragment {

    private List<DummyContent> dummyContents;
    OnListFragmentInteractionListener mListener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_item_list, container, false);


        dummyContents= new ArrayList<>();

        setData(view);

        return view;
    }

    public void setData(View view){

        dummyContents.add(new DummyContent("1","First","1jhsjsjsjsjsjsjsj1"));
        dummyContents.add(new DummyContent("2","Second","1jhsjsjsjsjsjsjsj2"));
        dummyContents.add(new DummyContent("3","Thrid","1jhsjsjsjsjsjsjsj3"));
        dummyContents.add(new DummyContent("4","Fouth","1jhsjsjsjsjsjsjsj4"));


        init(view,dummyContents);
    }


    public void init(View view,List<DummyContent>  dummyContents){
        RecyclerView recyclerView=view.findViewById(R.id.list);
        MyItemRecyclerViewAdapter myItemRecyclerViewAdapter= new MyItemRecyclerViewAdapter(dummyContents,mListener);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(myItemRecyclerViewAdapter);

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnListFragmentInteractionListener) {
            mListener = (OnListFragmentInteractionListener) context;
        } else {
          }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
}
