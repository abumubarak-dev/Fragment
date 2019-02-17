package com.example.user.fragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;


public class MainActivity extends FragmentActivity implements OnListFragmentInteractionListener {

    String fragmentMsg;


    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        fragmentMsg=savedInstanceState.getString("fragment_msg");

        //Log.i("rrr",savedInstanceState.getString("fragment_msg"));

        super.onRestoreInstanceState(savedInstanceState);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (findViewById(R.id.activity_land) !=null){

            if(savedInstanceState!=null){

                if(savedInstanceState.getString("fragment_msg")!=null &&

                        !savedInstanceState.getString("fragment_msg").equals("")){


                    initdetails(savedInstanceState.getString("fragment_msg"));

                    initFragment();

                }

            }else {

               initdetails("");

               initFragment();


            }

        }else if(findViewById(R.id.activity_port) !=null){

            if(savedInstanceState!=null) {

                if (savedInstanceState.getString("fragment_msg") != null &&

                        !savedInstanceState.getString("fragment_msg").equals("")) {


                    initdetails(savedInstanceState.getString("fragment_msg"));

                }
            }else{
                initFragment();

            }
        }
    }

    public void initdetails(String s){

        DetailsFragment detailsFragment = new DetailsFragment();

        setFragment(detailsFragment, "detailsFragment", s,
                R.id.fragment_container);

    }

    public void initFragment(){

        ItemFragment detailsFragment= new ItemFragment();

        setFragment(detailsFragment,"detailsFragment","",R.id.fragment_container);

    }

    public void setFragment(Fragment fragment,String tag,String msg,int id){

        FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();

        if (!msg.equals("") && msg!=null) {

            Bundle bundle= new Bundle();


            bundle.putString(getString(R.string.msg),msg);

            fragment.setArguments(bundle);

        }

        transaction.replace(id,fragment,tag);

        transaction.commit();

    }

    @Override
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);

        if(fragmentMsg!=null && !fragmentMsg.equals("")) {

            bundle.putString("fragment_msg", fragmentMsg);

        }

    }

    @Override
    public void onListFragmentInteraction(DummyContent item) {

        if (item!=null){

            fragmentMsg=item.details;

            if (findViewById(R.id.activity_land) !=null){

                DetailsFragment fragment= new DetailsFragment();

                setFragment(fragment,"detailsFragment",item.details,R.id.fragment_container2);

            }else if(findViewById(R.id.activity_port) !=null){

                DetailsFragment fragment= new DetailsFragment();

                setFragment(fragment,"detailsFragment",item.details,R.id.fragment_container);


            }

        }
    }
}

