package com.example.alvinramirez.myapptest;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.Response.ErrorListener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link AsignarEquiposFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link AsignarEquiposFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AsignarEquiposFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private RequestQueue queue ;

    private OnFragmentInteractionListener mListener;

    public AsignarEquiposFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AsignarEquiposFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AsignarEquiposFragment newInstance(String param1, String param2) {
        AsignarEquiposFragment fragment = new AsignarEquiposFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


      //  return inflater.inflate(R.layout.fragment_asignar_equipos, container, false);
        View vista = inflater.inflate(R.layout.fragment_asignar_equipos, container, false);
        queue = Volley.newRequestQueue(getContext() ) ;
        obtenerdatosvolley();
        return vista ;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }


    private void obtenerdatosvolley()
    {
      //  String url = "https://api.androidhive.info/contacts/" ;
        String url = "131.161.52.171:3000/api/Salestables/" ;
        final JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

          //      JSONObject myjsonobject = response.getJSONObject(0);
                try {
                    JSONObject myjsonobject = response.getJSONObject(0);
                    String Cabezal = myjsonobject.getString("Cabezal");
                 //   String Cabezal = response.getString(0);
                   String id = "3"; // response.getString(1);
                    Toast.makeText(getContext() ,"response" +response + Cabezal +id , Toast.LENGTH_SHORT).show();


                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        } , new ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        })  ;
      //  final JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
        //    @Override
       //     public void onResponse(JSONObject response) {


        //        try {
                //   JSONArray myjsonarray = response.getJSONArray();

      //            JSONArray myjsonarray = response.getJSONArray("")  ;
                 //  JSONArray jsonte ;
                //    for(int i = 0 ; i < myjsonarray.length(); i++) {
                     //   JSONObject myjsonobject = response.getJSONObject(i) ;
            //                         JSONObject myjsonobject = myjsonarray.getJSONObject(0);
                     //   String name = myjsonobject.getString("name");
                     //   String name = myjsonobject.getString("Cabezal");
           //             String Cabezal = response.getString("Cabezal");
            //            Toast.makeText(getContext() ,response + Cabezal , Toast.LENGTH_SHORT).show();

                 //   }

           //     } catch (  JSONException e) {
           //         e.printStackTrace();
           //         Toast.makeText(getContext() ,response +  e.toString() , Toast.LENGTH_SHORT).show();


           //     }

        //    }
     //   } , new Response.ErrorListener(){
//
    //        @Override
      //      public void onErrorResponse(VolleyError error) {

      //      }
     //   });
     //   Toast.makeText(getContext() , "response"+ "response" , Toast.LENGTH_SHORT).show();

        queue.add(request);

    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
