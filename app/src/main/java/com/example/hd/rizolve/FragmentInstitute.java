package com.example.hd.rizolve;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.json.JSONObject;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link FragmentInstitute.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link FragmentInstitute#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentInstitute extends Fragment {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    JSONObject complaints_data;

    public FragmentInstitute() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MainActivity activity = (MainActivity) getActivity();
        complaints_data =  activity.getInstiComplains();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_complaints, container, false);

        mRecyclerView = (RecyclerView) view.findViewById(R.id.complaint_recycler_view);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(mLayoutManager);

        // specify an adapter (see also next example)
        MainActivity activity = (MainActivity) getActivity();
        complaints_data =  activity.getInstiComplains();
        mAdapter = new Adapter_Complaints(complaints_data);
        //Log.i("hagga", complaints_data.toString());

        mRecyclerView.setAdapter(mAdapter);
        return view;
    }


}