package com.example.alvinramirez.myapptest;

import android.app.DownloadManager;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


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
    private ListView listaequipos ;
    private ArrayList<String> Listadoequipos ;

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
        listaequipos = (ListView) vista.findViewById(R.id.listaequipos) ;

        queue = Volley.newRequestQueue(getContext() ) ;
        consumirserviciopost();
        getdata() ;
      //  obtenerdatosvolley();
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

    public void getdata()  {
       // String sql = "131.161.52.171:3001/mecanicoss/";
        ArrayList<String> Equipos = new ArrayList<String>();

        String sql = "http://131.161.52.171:3001/api/Salestables/";
        StrictMode.ThreadPolicy policy  = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        URL url = null ;
        HttpURLConnection con  ;

        try {
            url = new URL(sql) ;
            con = (HttpURLConnection) url.openConnection() ;
            con.setRequestMethod("GET");
            con.connect();
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputline ;
            StringBuffer response = new StringBuffer();
            String json = "" ;

            while( (inputline = in.readLine() )!= null ){
                response.append(inputline);

            }

            json = response.toString() ;
            JSONArray jsonarray = null ;
            jsonarray = new JSONArray(json) ;

            for(int i = 0 ; i < jsonarray.length() ; i++)
            {

                JSONObject jsonobj = jsonarray.getJSONObject(i);
             //   Log.d(null, "SALIDA: " , jsonobj.optString("Cabezal"));
             //   Cargarequipos( jsonobj.optString("Cabezal") );
                Equipos.add(jsonobj.optString("Cabezal") );
           //     Toast.makeText(getContext() ,"response" +jsonobj.optString("Cabezal"), Toast.LENGTH_SHORT).show();

            }
            Listadoequipos = Equipos ;
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext() , android.R.layout.simple_list_item_1 ,Listadoequipos );
            listaequipos.setAdapter(adapter);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }


    }

    private void consumirserviciopost()
    {
        String url = "http://131.161.52.171:3001/api/Salestables/";
        StringRequest postrequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
                params.put("id", "10");
                params.put("Cabezal", "ritchie");
                Toast.makeText(getContext() ,"response" +params, Toast.LENGTH_SHORT).show();

                return params;
            }

        };

        queue.add(postrequest);
    }

    private void Cargarequipos(String cabezal)
    {
        Listadoequipos = Listarequipos(cabezal);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext() , android.R.layout.simple_list_item_1 ,Listadoequipos );
        listaequipos.setAdapter(adapter);

    }

    private ArrayList<String> Listarequipos(String cabezal){
        ArrayList<String> Equipos = new ArrayList<String>();
        Equipos.add(cabezal);
        return Equipos ;
    }

    private void obtenerdatosvolley()
    {

      //  String url = "https://api.androidhive.info/contacts/" ;
      //  String url = "http://131.161.52.171:3001/mecanicoss/" ;
          String url = "http://131.161.52.171:3001/api/Salestables/" ;

       /*  JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

          //      JSONObject myjsonobject = response.getJSONObject(0);

                    Toast.makeText(getContext() ,"response" +response.toString(), Toast.LENGTH_SHORT).show();



            }
        } , new ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        })  ;
        */
        final JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {


                try {

                 JSONArray myjsonarray = response.getJSONArray("")  ;
                    for(int i = 0 ; i < myjsonarray.length(); i++) {
                                   JSONObject myjsonobject = myjsonarray.getJSONObject(i);
                        String Cabezal = myjsonobject.getString("Cabezal");
                     Toast.makeText(getContext() ,response + Cabezal , Toast.LENGTH_SHORT).show();

                   }

               } catch (  JSONException e) {
                    e.printStackTrace();
               //    Toast.makeText(getContext() , response + name, Toast.LENGTH_SHORT).show();


                }
                }
        } , new Response.ErrorListener(){
//
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
     //   Toast.makeText(getContext() , "response"+ request , Toast.LENGTH_SHORT).show();

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
