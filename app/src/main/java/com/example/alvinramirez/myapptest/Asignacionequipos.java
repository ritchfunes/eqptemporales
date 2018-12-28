package com.example.alvinramirez.myapptest;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
// import android.support.v4.app.FragmentManager ;

public class Asignacionequipos extends AppCompatActivity {

    private RequestQueue queued ;
    private DatePickerDialog.OnDateSetListener sDateSetListner ;
    private DatePickerDialog.OnDateSetListener sDateSetListnerhasta ;
    private DatePickerDialog.OnDateSetListener sDateSetListnerfecextintor ;
    private DatePickerDialog.OnDateSetListener sDateSetListnerfecoperacioncisterna ;
    private DatePickerDialog.OnDateSetListener sDateSetListnerfecrevisioncisterna ;
    private DatePickerDialog.OnDateSetListener sDateSetListnerfecextintoronecisterna;
    private DatePickerDialog.OnDateSetListener sDateSetListnerfecextintortwocisterna ;
    private EditText edtcabezalfecoperacion , edtcabezalfecrevision , edtcabezalfecextintor ;
    private EditText edtcabezal , edtcabezalplaca , edtcabezalextintor , edtcabezalcuniaseg , edtcabezalparlante , edtcabezalradio ;
    private EditText edtcisterna , edtcisternaplaca , edtfecoperacioncisterna , edtfecrevisioncisterna, edtcisfecextintorcisone ;
    private EditText edtcisfecextintorcistwo , edtcisconos , edtcismangueras ;
    private String fecdesde , fechasta , fecextirntor ;
    private Button btncabezaln , btncabezalplaca , btncisternaplaca , btncisternan,  btnagregar ;
    private CheckBox chcabezaldocoperacion, chcabezaldoclicencia , ckcabezaldocrevision, chcabezalextintor, chcabezalpala ;
    private CheckBox chcabezalabsorventes, chcabezaltacos, chcabezalcunias , chcabezalmartillo , chcabezaljabonepoxy  ;
    private CheckBox chcabezalcuniasegu , chcabezalbotiquin ,  chcabezalfoco , chcabezalllantas , chcabezalluces ;
    private CheckBox chcabezalsnfugas , chcabezalchasissn , chcabezalcinturon, chcabezalmaster,  chalarma ;
    private CheckBox chcabezalgps, chcabezalintcabina, chcabezalpinturaext , chcabezallimpiezaint, chcabezalparlante;
    private CheckBox chcabezalradio, chcabezalcamarote, chcabezaltapizadogen,  chdocoperacioncisterna, ckdocrevisioncisterna ;
    private CheckBox chciscalibrar, chcisextintor,  chciscubeta , chcisembudo, chcistigfill;
    private CheckBox chcisconos, chcismangueras, chcisllantas, chcischasis,chcisgrada  ;
    private CheckBox chcislineas, chciscinta, chcismanhole, chcislodera,  chcisterminal ;
    private CheckBox chcisluces, chciscondcutor, chcismanguera , chcitanque ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asignacionequipos);

        chcabezaldocoperacion = (CheckBox) findViewById(R.id.chcabezaldocoperacion) ;
        chcabezaldoclicencia = (CheckBox) findViewById(R.id.chcabezaldoclicencia) ;
        ckcabezaldocrevision = (CheckBox) findViewById(R.id.ckcabezaldocrevision) ;
        chcabezalextintor = (CheckBox) findViewById(R.id.chcabezalextintor) ;
        chcabezalpala = (CheckBox) findViewById(R.id.chcabezalpala) ;
        chcabezaltacos = (CheckBox) findViewById(R.id.chcabezaltacos) ;
        chcabezalabsorventes = (CheckBox) findViewById(R.id.chcabezalabsorventes) ;
        chcabezalcunias = (CheckBox) findViewById(R.id.chcabezalcunias) ;
        chcabezalmartillo = (CheckBox) findViewById(R.id.chcabezalmartillo) ;
        chcabezaljabonepoxy = (CheckBox) findViewById(R.id.chcabezaljabonepoxy) ;

        chcabezalcuniasegu = (CheckBox) findViewById(R.id.chcabezalcuniasegu) ;
        chcabezalbotiquin = (CheckBox) findViewById(R.id.chcabezalbotiquin) ;
        chcabezalfoco = (CheckBox) findViewById(R.id.chcabezalfoco) ;
        chcabezalllantas = (CheckBox) findViewById(R.id.chcabezalllantas) ;
        chcabezalluces = (CheckBox) findViewById(R.id.chcabezalluces) ;
        chcabezalsnfugas = (CheckBox) findViewById(R.id.chcabezalsnfugas) ;
        chcabezalchasissn = (CheckBox) findViewById(R.id.chcabezalchasissn) ;
        chcabezalcinturon = (CheckBox) findViewById(R.id.chcabezalcinturon) ;
        chcabezalmaster = (CheckBox) findViewById(R.id.chcabezalmaster) ;
        chalarma = (CheckBox) findViewById(R.id.chalarma) ;

        chcabezalgps = (CheckBox) findViewById(R.id.chcabezalgps) ;
        chcabezalintcabina = (CheckBox) findViewById(R.id.chcabezalintcabina) ;
        chcabezalpinturaext = (CheckBox) findViewById(R.id.chcabezalpinturaext) ;
        chcabezallimpiezaint = (CheckBox) findViewById(R.id.chcabezallimpiezaint) ;
        chcabezalparlante = (CheckBox) findViewById(R.id.chcabezalparlante) ;
        chcabezalradio = (CheckBox) findViewById(R.id.chcabezalradio) ;
        chcabezalcamarote = (CheckBox) findViewById(R.id.chcabezalcamarote) ;
        chcabezaltapizadogen = (CheckBox) findViewById(R.id.chcabezaltapizadogen) ;
        chdocoperacioncisterna = (CheckBox) findViewById(R.id.chdocoperacioncisterna) ;
        ckdocrevisioncisterna = (CheckBox) findViewById(R.id.ckdocrevisioncisterna) ;

        chciscalibrar = (CheckBox) findViewById(R.id.chciscalibrar) ;
        chcisextintor = (CheckBox) findViewById(R.id.chcisextintor) ;
        chciscubeta = (CheckBox) findViewById(R.id.chciscubeta) ;
        chcisembudo = (CheckBox) findViewById(R.id.chcisembudo) ;
        chcistigfill = (CheckBox) findViewById(R.id.chcistigfill) ;
        chcisconos = (CheckBox) findViewById(R.id.chcisconos) ;
        chcismangueras = (CheckBox) findViewById(R.id.chcismangueras) ;
        chcisllantas = (CheckBox) findViewById(R.id.chcisllantas) ;
        chcischasis = (CheckBox) findViewById(R.id.chcischasis) ;
        chcisgrada = (CheckBox) findViewById(R.id.chcisgrada) ;
        chcislineas = (CheckBox) findViewById(R.id.chcislineas) ;
        chciscinta = (CheckBox) findViewById(R.id.chciscinta) ;
        chcismanhole = (CheckBox) findViewById(R.id.chcismanhole) ;
        chcislodera = (CheckBox) findViewById(R.id.chcislodera) ;
        chcisterminal = (CheckBox) findViewById(R.id.chcisterminal) ;
        chcisluces = (CheckBox) findViewById(R.id.chcisluces) ;
        chciscondcutor = (CheckBox) findViewById(R.id.chciscondcutor) ;
        chcismanguera = (CheckBox) findViewById(R.id.chcismanguera) ;
        chcitanque = (CheckBox) findViewById(R.id.chcitanque) ;

        btncabezaln = (Button) findViewById(R.id.btncabezaln) ;
        btncabezalplaca = (Button) findViewById(R.id.btncabezalplaca) ;
        btncisternaplaca = (Button) findViewById(R.id.btncisternaplaca) ;
        btncisternan = (Button) findViewById(R.id.btncisternan) ;
        btnagregar = (Button) findViewById(R.id.btnagregar) ;
        final Activity activity = this ;
       // final Activity activityplacacabezal = this ;
       // final Activity activityplacacisterna = this ;
      //  final Activity activitycisterna = this ;
        edtcabezalfecoperacion = (EditText) findViewById(R.id.edtcabezalfecoperacion) ;
        edtcabezalfecrevision = (EditText) findViewById(R.id.edtcabezalfecrevision) ;
        edtcabezalfecextintor = (EditText) findViewById(R.id.edtcabezalfecextintor) ;

        edtcabezal = (EditText) findViewById(R.id.edtcabezal) ;
        edtcabezalplaca = (EditText) findViewById(R.id.edtcabezalplaca) ;
        edtcabezalextintor = (EditText) findViewById(R.id.edtcabezalextintor) ;
        edtcabezalcuniaseg = (EditText) findViewById(R.id.edtcabezalcuniaseg) ;
        edtcabezalparlante = (EditText) findViewById(R.id.edtcabezalparlante) ;
        edtcabezalradio = (EditText) findViewById(R.id.edtcabezalradio) ;
        edtcisterna = (EditText) findViewById(R.id.edtcisterna) ;
        edtcisternaplaca = (EditText) findViewById(R.id.edtcisternaplaca) ;
        edtfecoperacioncisterna = (EditText) findViewById(R.id.edtfecoperacioncisterna) ;
        edtfecrevisioncisterna = (EditText) findViewById(R.id.edtfecrevisioncisterna) ;
               edtcisfecextintorcisone = (EditText) findViewById(R.id.edtcisfecextintorcisone) ;
        edtcisfecextintorcistwo = (EditText) findViewById(R.id.edtcisfecextintorcistwo) ;
        edtcisconos = (EditText) findViewById(R.id.edtcisconos) ;
        edtcismangueras = (EditText) findViewById(R.id.edtcismangueras) ;





        queued = Volley.newRequestQueue(this) ;
        edtcabezal.setEnabled(false);
        edtcabezalplaca.setEnabled(false);
        edtcisterna.setEnabled(false);
        edtcisternaplaca.setEnabled(false);


        btnagregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sedtcabezalfecoperacion = edtcabezalfecoperacion.getText().toString() ;
                String sedtcabezalfecrevision =  edtcabezalfecrevision .getText().toString() ;
                String sedtcabezalfecextintor =  edtcabezalfecextintor .getText().toString() ;
                String sedtcabezal = edtcabezal.getText().toString() ;
                String sedtcabezalplaca = edtcabezalplaca .getText().toString() ;
                String sedtcabezalextintor = edtcabezalextintor .getText().toString() ;
                String sedtcabezalcuniaseg = edtcabezalcuniaseg .getText().toString() ;
                String sedtcabezalparlante = edtcabezalparlante .getText().toString() ;
                String sedtcabezalradio = edtcabezalradio.getText().toString() ;
                String sedtcisterna = edtcisterna.getText().toString() ;
                String sedtcisternaplaca = edtcisternaplaca.getText().toString() ;
                String sedtfecoperacioncisterna = edtfecoperacioncisterna.getText().toString() ;
                String sedtfecrevisioncisterna = edtfecrevisioncisterna .getText().toString() ;
                String sedtcisfecextintorcisone = edtcisfecextintorcisone.getText().toString() ;
                String sedtcisfecextintorcistwo = edtcisfecextintorcistwo .getText().toString() ;
                String sedtcisconos = edtcisconos .getText().toString() ;
                String sedtcismangueras = edtcismangueras .getText().toString() ;

              if(  sedtcabezalfecoperacion.equals("") )
              {
                  Toast.makeText( getApplication() ,"fecha de permiso de operacion vacio" , Toast.LENGTH_SHORT  ).show();

              }
              else if (  sedtcabezalfecrevision.equals("") )
              {
                  Toast.makeText( getApplication() ,"fehca de revision cabezal vacio" , Toast.LENGTH_SHORT  ).show();

              }
              else if (  sedtcabezalfecextintor.equals(""))
              {
                  Toast.makeText( getApplication() ,"fecha del extintor cabezal vacio" , Toast.LENGTH_SHORT  ).show();

              }
              else if (  sedtcabezal.equals(""))
              {
                  Toast.makeText( getApplication() ,"nombre de cabezal vacio" , Toast.LENGTH_SHORT  ).show();

              }
              else if (  sedtcabezalplaca.equals(""))
                {
                    Toast.makeText( getApplication() ,"cabezal placa vacio" , Toast.LENGTH_SHORT  ).show();

                }
              else if (  sedtcabezalextintor.equals(""))
                {
                    Toast.makeText( getApplication() ,"extintor cantidad cabezal vacio" , Toast.LENGTH_SHORT  ).show();

                }
              else if (  sedtcabezalcuniaseg.equals(""))
                {
                    Toast.makeText( getApplication() ,"cuñas de seguirdad cabezal vacio" , Toast.LENGTH_SHORT  ).show();

                }
             else if (   sedtcabezalparlante.equals(""))
                {
                    Toast.makeText( getApplication() ,"parlantes de cabezal vacio" , Toast.LENGTH_SHORT  ).show();

                }
              else if (  sedtcabezalradio.equals(""))
                {
                    Toast.makeText( getApplication() ,"radios de cabezal vacio" , Toast.LENGTH_SHORT  ).show();

                }
              else if (  sedtcisterna.equals(""))
                {
                    Toast.makeText( getApplication() ,"nombre de cisterna vacio" , Toast.LENGTH_SHORT  ).show();

                }
             else if (   sedtcisternaplaca.equals(""))
                {
                    Toast.makeText( getApplication() ,"cisterna placa vacio" , Toast.LENGTH_SHORT  ).show();

                }
             else if (   sedtfecrevisioncisterna.equals(""))
                {
                    Toast.makeText( getApplication() ,"fecha de revision cisterna vacio" , Toast.LENGTH_SHORT  ).show();

                }
             else if (   sedtcisfecextintorcisone.equals(""))
                {
                    Toast.makeText( getApplication() ,"fecha de extintor cisterna vacio" , Toast.LENGTH_SHORT  ).show();

                }
             else if (   sedtcisfecextintorcistwo.equals(""))
                {
                    Toast.makeText( getApplication() ,"fecha de extintor cisterna vacio" , Toast.LENGTH_SHORT  ).show();

                }
            else if (    sedtcisconos.equals(""))
                {
                    Toast.makeText( getApplication() ,"conos de cisterna vacio" , Toast.LENGTH_SHORT  ).show();

                }
              else if (  sedtcismangueras.equals("") )
                {
                    Toast.makeText( getApplication() ,"mangueras cisterna vacio" , Toast.LENGTH_SHORT  ).show();

                }
              else if (  sedtfecoperacioncisterna.equals(""))
                {
                    Toast.makeText( getApplication() ,"feche de operacion cisterna vacio" , Toast.LENGTH_SHORT  ).show();

                }
            else {
                      consumirserviciopostd(edtcabezal.getText().toString(), edtcabezalplaca.getText().toString(), edtcabezalextintor.getText().toString(), edtcabezalcuniaseg.getText().toString(), edtcabezalparlante.getText().toString(),
                              edtcabezalradio.getText().toString(), edtcisterna.getText().toString(), edtcisternaplaca.getText().toString(), edtfecoperacioncisterna.getText().toString(), edtfecrevisioncisterna.getText().toString(),
                              edtcisfecextintorcisone.getText().toString(), edtcisfecextintorcistwo.getText().toString(), edtcisconos.getText().toString(), edtcismangueras.getText().toString(),
                              edtcabezalfecoperacion.getText().toString(), edtcabezalfecrevision.getText().toString(), edtcabezalfecextintor.getText().toString(),
                              String.valueOf(chcabezaldocoperacion.isChecked()), String.valueOf(chcabezaldoclicencia.isChecked()), String.valueOf(ckcabezaldocrevision.isChecked()), String.valueOf(chcabezalextintor.isChecked()), String.valueOf(chcabezalpala.isChecked()),
                              String.valueOf(chcabezaltacos.isChecked()), String.valueOf(chcabezalabsorventes.isChecked()), String.valueOf(chcabezalcunias.isChecked()), String.valueOf(chcabezalmartillo.isChecked()), String.valueOf(chcabezaljabonepoxy.isChecked()),
                              String.valueOf(chcabezalcuniasegu.isChecked()), String.valueOf(chcabezalbotiquin.isChecked()), String.valueOf(chcabezalfoco.isChecked()), String.valueOf(chcabezalllantas.isChecked()), String.valueOf(chcabezalluces.isChecked()),
                              String.valueOf(chcabezalsnfugas.isChecked()), String.valueOf(chcabezalchasissn.isChecked()), String.valueOf(chcabezalcinturon.isChecked()), String.valueOf(chcabezalmaster.isChecked()), String.valueOf(chalarma.isChecked()),
                              String.valueOf(chcabezalgps.isChecked()), String.valueOf(chcabezalintcabina.isChecked()), String.valueOf(chcabezalpinturaext.isChecked()), String.valueOf(chcabezallimpiezaint.isChecked()), String.valueOf(chcabezalparlante.isChecked()),
                              String.valueOf(chcabezalradio.isChecked()), String.valueOf(chcabezalcamarote.isChecked()), String.valueOf(chcabezaltapizadogen.isChecked()), String.valueOf(chdocoperacioncisterna.isChecked()), String.valueOf(ckdocrevisioncisterna.isChecked()),
                              String.valueOf(chciscalibrar.isChecked()), String.valueOf(chcisextintor.isChecked()), String.valueOf(chciscubeta.isChecked()), String.valueOf(chcisembudo.isChecked()), String.valueOf(chcistigfill.isChecked()),
                              String.valueOf(chcisconos.isChecked()), String.valueOf(chcismangueras.isChecked()), String.valueOf(chcisllantas.isChecked()), String.valueOf(chcischasis.isChecked()), String.valueOf(chcisgrada.isChecked()),
                              String.valueOf(chcislineas.isChecked()), String.valueOf(chciscinta.isChecked()), String.valueOf(chcismanhole.isChecked()), String.valueOf(chcislodera.isChecked()), String.valueOf(chcisterminal.isChecked()),
                              String.valueOf(chcisluces.isChecked()), String.valueOf(chciscondcutor.isChecked()), String.valueOf(chcismanguera.isChecked()), String.valueOf(chcitanque.isChecked())
                      );

                      Intent intent = new Intent(Asignacionequipos.this, MenuPrincipal.class);
                      startActivity(intent);

              }

            }
        });

        btncabezaln.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IntentIntegrator integrator = new IntentIntegrator( activity ) ;

                integrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE_TYPES);
                integrator.setPrompt("scan") ;
                integrator.setCameraId(0) ;
                integrator.setBeepEnabled(false);
                integrator.setBarcodeImageEnabled(false) ;
                integrator.initiateScan();
            }
        });

        btncabezalplaca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IntentIntegrator integrator = new IntentIntegrator( activity ) ;
                integrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE_TYPES);
                integrator.setPrompt("scan") ;
                integrator.setCameraId(0) ;
                integrator.setBeepEnabled(false);
                integrator.setBarcodeImageEnabled(false) ;
                integrator.initiateScan();
            }
        });

        btncisternaplaca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IntentIntegrator integrator = new IntentIntegrator( activity ) ;
                integrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE_TYPES);
                integrator.setPrompt("scan") ;
                integrator.setCameraId(0) ;
                integrator.setBeepEnabled(false);
                integrator.setBarcodeImageEnabled(false) ;
                integrator.initiateScan();
            }
        });

        btncisternan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                IntentIntegrator integrator = new IntentIntegrator(  activity  ) ;

                integrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE_TYPES);
                integrator.setPrompt("scan") ;
                integrator.setCameraId(0) ;
                integrator.setBeepEnabled(false);
                integrator.setBarcodeImageEnabled(false) ;
                integrator.initiateScan();
            }
        });


        edtcisfecextintorcisone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar cal = Calendar.getInstance() ;
                int year = cal.get(Calendar.YEAR) ;
                int month = cal.get(Calendar.MONTH) ;
                int day = cal.get(Calendar.DAY_OF_MONTH) ;

                DatePickerDialog dialog = new DatePickerDialog(
                        //    getSupportFragmentManager() ,
                        //    getActivity() ,
                        v.getContext() ,
                        android.R.style.Theme_Material_Light_Dialog_MinWidth ,
                        sDateSetListnerfecextintoronecisterna ,
                        year , month , day);

                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.WHITE) );
                dialog.show();
            }
        });


        sDateSetListnerfecextintoronecisterna = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {

                month = month + 1 ;
                String mes ;
                String dia ;

                if( month < 10)
                {
                    mes = "0"+month ;
                }
                else {
                    mes = String.valueOf( month ) ;
                }

                if(day < 10)
                {
                    dia = "0"+day ;
                }
                else {
                    dia = String.valueOf( day ) ;
                }

                String date = year+"-"+mes+"-"+dia ;
                fecextirntor = date ;
                edtcisfecextintorcisone.setText(date);

            }
        } ;


        edtcisfecextintorcistwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar cal = Calendar.getInstance() ;
                int year = cal.get(Calendar.YEAR) ;
                int month = cal.get(Calendar.MONTH) ;
                int day = cal.get(Calendar.DAY_OF_MONTH) ;

                DatePickerDialog dialog = new DatePickerDialog(
                        //    getSupportFragmentManager() ,
                        //    getActivity() ,
                        v.getContext() ,
                        android.R.style.Theme_Material_Light_Dialog_MinWidth ,
                        sDateSetListnerfecextintortwocisterna ,
                        year , month , day);

                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.WHITE) );
                dialog.show();
            }
        });


        sDateSetListnerfecextintortwocisterna = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {

                month = month + 1 ;
                String mes ;
                String dia ;

                if( month < 10)
                {
                    mes = "0"+month ;
                }
                else {
                    mes = String.valueOf( month ) ;
                }

                if(day < 10)
                {
                    dia = "0"+day ;
                }
                else {
                    dia = String.valueOf( day ) ;
                }

                String date = year+"-"+mes+"-"+dia ;
                fecextirntor = date ;
                edtcisfecextintorcistwo.setText(date);

            }
        } ;


        edtfecrevisioncisterna.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar cal = Calendar.getInstance() ;
                int year = cal.get(Calendar.YEAR) ;
                int month = cal.get(Calendar.MONTH) ;
                int day = cal.get(Calendar.DAY_OF_MONTH) ;

                DatePickerDialog dialog = new DatePickerDialog(
                        //    getSupportFragmentManager() ,
                        //    getActivity() ,
                        v.getContext() ,
                        android.R.style.Theme_Material_Light_Dialog_MinWidth ,
                        sDateSetListnerfecrevisioncisterna ,
                        year , month , day);

                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.WHITE) );
                dialog.show();
            }
        });


        sDateSetListnerfecrevisioncisterna = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {

                month = month + 1 ;
                String mes ;
                String dia ;

                if( month < 10)
                {
                    mes = "0"+month ;
                }
                else {
                    mes = String.valueOf( month ) ;
                }

                if(day < 10)
                {
                    dia = "0"+day ;
                }
                else {
                    dia = String.valueOf( day ) ;
                }

                String date = year+"-"+mes+"-"+dia ;
                fecextirntor = date ;
                edtfecrevisioncisterna.setText(date);

            }
        } ;


        edtfecoperacioncisterna.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar cal = Calendar.getInstance() ;
                int year = cal.get(Calendar.YEAR) ;
                int month = cal.get(Calendar.MONTH) ;
                int day = cal.get(Calendar.DAY_OF_MONTH) ;

                DatePickerDialog dialog = new DatePickerDialog(
                        //    getSupportFragmentManager() ,
                        //    getActivity() ,
                        v.getContext() ,
                        android.R.style.Theme_Material_Light_Dialog_MinWidth ,
                        sDateSetListnerfecoperacioncisterna ,
                        year , month , day);

                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.WHITE) );
                dialog.show();
            }
        });


        sDateSetListnerfecoperacioncisterna = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {

                month = month + 1 ;
                String mes ;
                String dia ;

                if( month < 10)
                {
                    mes = "0"+month ;
                }
                else {
                    mes = String.valueOf( month ) ;
                }

                if(day < 10)
                {
                    dia = "0"+day ;
                }
                else {
                    dia = String.valueOf( day ) ;
                }

                String date = year+"-"+mes+"-"+dia ;
                fecextirntor = date ;
                edtfecoperacioncisterna.setText(date);

            }
        } ;

        edtcabezalfecextintor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar cal = Calendar.getInstance() ;
                int year = cal.get(Calendar.YEAR) ;
                int month = cal.get(Calendar.MONTH) ;
                int day = cal.get(Calendar.DAY_OF_MONTH) ;

                DatePickerDialog dialog = new DatePickerDialog(
                        //    getSupportFragmentManager() ,
                        //    getActivity() ,
                        v.getContext() ,
                        android.R.style.Theme_Material_Light_Dialog_MinWidth ,
                        sDateSetListnerfecextintor ,
                        year , month , day);

                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.WHITE) );
                dialog.show();
            }
        });


        sDateSetListnerfecextintor = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {

                month = month + 1 ;
                String mes ;
                String dia ;

                if( month < 10)
                {
                    mes = "0"+month ;
                }
                else {
                    mes = String.valueOf( month ) ;
                }

                if(day < 10)
                {
                    dia = "0"+day ;
                }
                else {
                    dia = String.valueOf( day ) ;
                }

                String date = year+"-"+mes+"-"+dia ;
                fecextirntor = date ;
                edtcabezalfecextintor.setText(date);

            }
        } ;




        edtcabezalfecoperacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar cal = Calendar.getInstance() ;
                int year = cal.get(Calendar.YEAR) ;
                int month = cal.get(Calendar.MONTH) ;
                int day = cal.get(Calendar.DAY_OF_MONTH) ;

                DatePickerDialog dialog = new DatePickerDialog(
                    //    getSupportFragmentManager() ,
                    //    getActivity() ,
                         v.getContext() ,
                        android.R.style.Theme_Material_Light_Dialog_MinWidth ,
                        sDateSetListner ,
                        year , month , day);

                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.WHITE) );
                dialog.show();
            }
        });


        sDateSetListner = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {

                month = month + 1 ;
                String mes ;
                String dia ;

                if( month < 10)
                {
                    mes = "0"+month ;
                }
                else {
                    mes = String.valueOf( month ) ;
                }

                if(day < 10)
                {
                    dia = "0"+day ;
                }
                else {
                    dia = String.valueOf( day ) ;
                }

                String date = year+"-"+mes+"-"+dia ;
                fecdesde = date ;
                edtcabezalfecoperacion.setText(date);

            }
        } ;


        edtcabezalfecrevision.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar cal = Calendar.getInstance() ;
                int year = cal.get(Calendar.YEAR) ;
                int month = cal.get(Calendar.MONTH) ;
                int day = cal.get(Calendar.DAY_OF_MONTH) ;

                DatePickerDialog dialog = new DatePickerDialog(
                        //    getSupportFragmentManager() ,
                        //    getActivity() ,
                        v.getContext() ,
                        android.R.style.Theme_Material_Light_Dialog_MinWidth ,
                        sDateSetListnerhasta ,
                        year , month , day);

                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.WHITE) );
                dialog.show();
            }
        });


        sDateSetListnerhasta = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {

                month = month + 1 ;
                String mes ;
                String dia ;

                if( month < 10)
                {
                    mes = "0"+month ;
                }
                else {
                    mes = String.valueOf( month ) ;
                }

                if(day < 10)
                {
                    dia = "0"+day ;
                }
                else {
                    dia = String.valueOf( day ) ;
                }

                String date = year+"-"+mes+"-"+dia ;
                fechasta = date ;
                edtcabezalfecrevision.setText(date);

            }
        } ;

    }




    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        IntentResult result = IntentIntegrator.parseActivityResult(requestCode , resultCode , data) ;
        if (result != null)
        {
            if (result.getContents() == null)
            {
                Toast.makeText(this , "cancelar la escaneada" , Toast.LENGTH_LONG).show();
            }
            else {

                String formatolecturaqr = "" ;
                String lecturacodigoqr = "" ;
                formatolecturaqr = ""+result.getContents() ;
                lecturacodigoqr = ""+result.getContents() ;
                formatolecturaqr = formatolecturaqr.replace(" " , "");
                lecturacodigoqr = lecturacodigoqr.replace(" " , "");
                formatolecturaqr = formatolecturaqr.substring(0 , 6) ;
                lecturacodigoqr = lecturacodigoqr.substring(6) ;
                formatolecturaqr = formatolecturaqr.toLowerCase();
                formatolecturaqr = formatolecturaqr.trim() ;
                if(formatolecturaqr.equals("cabund")  )
                {
                    edtcabezal.setText(lecturacodigoqr);
                    Toast.makeText(this ,  result.getContents() + " "+ formatolecturaqr , Toast.LENGTH_LONG).show();

                }
                else if (formatolecturaqr.equals("cisund") )
                {
                    edtcisterna.setText(lecturacodigoqr);
                    Toast.makeText(this ,  result.getContents() + " "+ formatolecturaqr , Toast.LENGTH_LONG).show();

                }
                else if (formatolecturaqr.equals("cispla"))
                {
                    edtcisternaplaca.setText(lecturacodigoqr);
                    Toast.makeText(this ,  result.getContents() + " "+ formatolecturaqr , Toast.LENGTH_LONG).show();

                }
                else if (formatolecturaqr.equals("cabpla") )
                {
                    edtcabezalplaca.setText(lecturacodigoqr);
                    Toast.makeText(this ,  result.getContents() + " "+ formatolecturaqr , Toast.LENGTH_LONG).show();

                }
                else {
                    Toast.makeText(this , "Formato no encontrado para codigos QR" , Toast.LENGTH_LONG).show();
                }
              //  edtcabezalplaca.setText(lecturacodigoqr);
              //  Toast.makeText(this ,  result.getContents() + " "+ formatolecturaqr , Toast.LENGTH_LONG).show();
            }

        }
        else {
            super.onActivityResult(requestCode, resultCode, data);
        }


    }


    private void consumirserviciopostd( final String edtcabezal  , final String edtcabezalplaca  ,final String edtcabezalextintor  ,final String edtcabezalcuniaseg  ,
                                        final String edtcabezalparlante  ,final String edtcabezalradio ,final String edtcisterna  ,final String edtcisternaplaca  ,final String edtfecoperacioncisterna ,
                                        final String edtfecrevisioncisterna  ,final String edtcisfecextintorcisone  ,final String edtcisfecextintorcistwo ,final String edtcisconos ,final String edtcismangueras ,
                                        final  String edtcabezalfecoperacion ,final String edtcabezalfecrevision  ,final String edtcabezalfecextintor ,
                                        final   String chcabezaldocoperacion  ,final String chcabezaldoclicencia ,final String ckcabezaldocrevision  ,final String chcabezalextintor  ,final String chcabezalpala  ,
                                        final  String chcabezaltacos  ,final String chcabezalabsorventes  ,final String chcabezalcunias  ,final String chcabezalmartillo  ,final String chcabezaljabonepoxy ,
                                        final  String chcabezalcuniasegu  ,final String chcabezalbotiquin  ,final String chcabezalfoco ,final String chcabezalllantas ,final String chcabezalluces ,
                                        final  String chcabezalsnfugas ,final String chcabezalchasissn ,final String chcabezalcinturon ,final String chcabezalmaster ,final String chalarma ,
                                        final  String chcabezalgps  ,final String chcabezalintcabina  ,final String chcabezalpinturaext  ,final String chcabezallimpiezaint ,final String chcabezalparlante ,
                                        final   String chcabezalradio  ,final String chcabezalcamarote ,final String chcabezaltapizadogen ,final String chdocoperacioncisterna ,final String ckdocrevisioncisterna ,
                                        final   String chciscalibrar ,final String chcisextintor  ,final String chciscubeta  ,final String chcisembudo  ,final String chcistigfill ,
                                        final   String chcisconos ,final String chcismangueras ,final String chcisllantas ,final String chcischasis ,final String chcisgrada ,
                                        final   String chcislineas  ,final String chciscinta ,final String chcismanhole  ,final String chcislodera ,final String chcisterminal  ,
                                        final   String chcisluces ,final String chciscondcutor  ,final String chcismanguera  ,final String chcitanque )
    {

      /*  JSONObject json = new JSONObject();
        try {
        //    json.put("store","amz");
        //    json.put("category","fashion");
        //    json.put("type","coupons");
            json.put("ID", 1);
            json.put("CABEZALNOMBRE", "C101");
            json.put("CABEZALPLACA", "CP101");
            json.put("CABEZALPEROPERACION", true);
            //  json.put("CABEZALFECHAOPERACION", null);
            json.put("CABEZALLICENCIA", true);
            json.put("CABEZALBOLETAREVISION", true);
            //  json.put("CABEZALFECHABOLETAREVIISON", null);
            json.put("CABEZALEXTINTOR", true);
            //   json.put("CABEZALFECHAEXTINTOR", null);
            json.put("CABEZALCANTIDADEXTINTOR", 1 );
            json.put("CABEZALPALA", true);
            json.put("CABEZALABOSRVENTE", true);
            json.put("CABEZALTACO", true);
            json.put("CABEZALCUNIA", true);
            json.put("CABEZALMARTILLO", true);
            json.put("CABEZALEXPOXY", true);
            json.put("CABEZALCUNSEG", true);
            json.put("CABEZALCANTIDADCUNSEG", 2);
            json.put("CABEZALBOTIQUIN", true);
            json.put("CABEZALFOCO", true);
            json.put("CABEZALLLANTAS", true);
            json.put("CABEZALLUCES", true);
            json.put("CABEZALSNFUGAS", true);
            json.put("CABEZALCHASIS", true);
            json.put("CABEZALCINTURON", true);
            json.put("CABEZALMASSHITCH", true);
            json.put("CABEZALALARMA", true);
            json.put("CABEZALGPS", true);
            json.put("CABEZALINTCABINA", true);
            json.put("CABEZALEXTCARROCERIA", true);
            json.put("CABEZALLIMPIEZA", true);
            json.put("CABEZALPARLANTES", true);
            json.put("CABEZALCANTIDADPARLANTES", 3);
            json.put("CABEZALRADIO", true);
            json.put("CABEZALCANTIDADRADIO", 4);
            json.put("CABEZALCOLCHON", true);
            json.put("CABEZALTAPIZADO", true);
            json.put("CISTERNANOMBRE", "CIS101");
            json.put("CISTERNAPLACA", "CISP101");
            json.put("CISTERNAPEROPERACION", true);
            // json.put("CISTERNAFECHAOPERACION", null);
            json.put("CISTERNAREVISION", true);
         //   json.put("CISTERNAFECHAREVISION", null);
            json.put("CISTERNACALIBRACION", true);
            json.put("CISTERNAEXTINTOR", true);
            //   json.put("CISTERNAEXTINTORA", null);
         //   json.put("CISTERNAEXTINTORB", null);
            json.put("CISTERNACUBETA", true);
            json.put("CISTERNAEMBUDO", true);
            json.put("CISTERNATIGHFILL", true);
            json.put("CISTERNACONO", true);
            json.put("CISTERNACANTIDADCONO", 5);
            json.put("CISTERNAMANGUERAS", true);
            json.put("CISTERNACANTIDADMANGUERAS", 6);
            json.put("CISTERNALLANTAS", true);
            json.put("CISTERNACHASIS", true);
            json.put("CISTERNAGRADAS", true);
            json.put("CISTERNALINEAS", true);
            json.put("CISTERNACINTA", true);
            json.put("CISTERNAMANHOLES", true);
            json.put("CISTERNALODERAS", true);
            json.put("CISTERNATERMINALES", true);
            json.put("CISTERNALUCES", true);
            json.put("CISTERNACONDUCTORES", true);
            json.put("CISTERNAESTMANGUERA", true);
            json.put("CISTERNATANQUE", true);

        } catch (JSONException e) {
            e.printStackTrace();
        }
        edtcabezalplaca.setText(json.toString());

        String url =  "http://131.161.52.171:3001/api/EQUIPOSASIGNACIONTEMPs/";
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, url, json,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        edtcabezalplaca.setText("String Response : "+ response.toString());
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                edtcabezalplaca.setText("Error getting response");
            }
        });
     //   jsonObjectRequest.setTag(REQ_TAG);

        queue.add(jsonObjectRequest);
      */
      //  String url = "http://131.161.52.171:3001/api/Salestables/";
      //  queued = null ;
        String url = "http://131.161.52.171:3001/api/EQUIPOSASIGNACIONTEMPs/";
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
            protected Map<String, String  > getParams( ) throws AuthFailureError {
                Map<String, String  > params = new HashMap<String, String >();
           //     params.put("id", "10");
           //     params.put("Cabezal", "ritchie");
             //   params.put("Content-Type", "application/x-www-form-urlencoded");
                params.put("ID", "1");
                params.put("CABEZALNOMBRE", edtcabezal);
                Log.d("response", params.toString());
                params.put("CABEZALPLACA", edtcabezalplaca);
                params.put("CABEZALPEROPERACION", chcabezaldocoperacion );
                params.put("CABEZALFECHAOPERACION", edtcabezalfecoperacion );
                params.put("CABEZALLICENCIA", chcabezaldoclicencia );
                params.put("CABEZALBOLETAREVISION", ckcabezaldocrevision );
                params.put("CABEZALFECHABOLETAREVIISON", edtcabezalfecrevision );
                params.put("CABEZALEXTINTOR", chcabezalextintor );
                params.put("CABEZALFECHAEXTINTOR",edtcabezalfecextintor );

                params.put("CABEZALCANTIDADEXTINTOR",edtcabezalextintor  );
                params.put("CABEZALPALA", chcabezalpala );
                params.put("CABEZALABOSRVENTE", chcabezalabsorventes );
                params.put("CABEZALTACO", chcabezaltacos );
                params.put("CABEZALCUNIA", chcabezalcunias );
                params.put("CABEZALMARTILLO", chcabezalmartillo );
                params.put("CABEZALEXPOXY", chcabezaljabonepoxy );
                params.put("CABEZALCUNSEG", chcabezalcuniasegu );
                params.put("CABEZALCANTIDADCUNSEG", edtcabezalcuniaseg );
                params.put("CABEZALBOTIQUIN", chcabezalbotiquin );
                params.put("CABEZALFOCO", chcabezalfoco );

                params.put("CABEZALLLANTAS", chcabezalllantas );
                params.put("CABEZALLUCES", chcabezalluces );
                params.put("CABEZALSNFUGAS", chcabezalsnfugas  );
                params.put("CABEZALCHASIS", chcabezalchasissn );
                params.put("CABEZALCINTURON", chcabezalcinturon );
                params.put("CABEZALMASSHITCH", chcabezalmaster );
                params.put("CABEZALALARMA", chalarma );
                params.put("CABEZALGPS", chcabezalgps );
                params.put("CABEZALINTCABINA", chcabezalintcabina );
                params.put("CABEZALEXTCARROCERIA", chcabezalpinturaext );

                params.put("CABEZALLIMPIEZA", chcabezallimpiezaint );
                params.put("CABEZALPARLANTES", chcabezalparlante );
                params.put("CABEZALCANTIDADPARLANTES", edtcabezalparlante );
                params.put("CABEZALRADIO", chcabezalradio );
                params.put("CABEZALCANTIDADRADIO", edtcabezalradio );
                params.put("CABEZALCOLCHON", chcabezalcamarote  );
                params.put("CABEZALTAPIZADO", chcabezaltapizadogen );
                params.put("CISTERNANOMBRE", edtcisterna );
                params.put("CISTERNAPLACA", edtcisternaplaca );
                params.put("CISTERNAPEROPERACION", chdocoperacioncisterna );

                params.put("CISTERNAFECHAOPERACION",edtfecoperacioncisterna );
                params.put("CISTERNAREVISION", ckdocrevisioncisterna );
                params.put("CISTERNAFECHAREVISION", edtfecrevisioncisterna );  // "2018-12-26"
                params.put("CISTERNACALIBRACION", chciscalibrar );
                params.put("CISTERNAEXTINTOR", chcisextintor );
                params.put("CISTERNAEXTINTORA", edtcisfecextintorcisone );
                params.put("CISTERNAEXTINTORB", edtcisfecextintorcistwo );
                params.put("CISTERNACUBETA", chciscubeta );
                params.put("CISTERNAEMBUDO", chcisembudo );
                params.put("CISTERNATIGHFILL", chcistigfill );

                params.put("CISTERNACONO", chcisconos );
                params.put("CISTERNACANTIDADCONO", edtcisconos );
                params.put("CISTERNAMANGUERAS", chcismangueras );
                params.put("CISTERNACANTIDADMANGUERAS", edtcismangueras );
                params.put("CISTERNALLANTAS", chcisllantas );
                params.put("CISTERNACHASIS", chcischasis );
                params.put("CISTERNAGRADAS", chcisgrada );
                params.put("CISTERNALINEAS", chcislineas );
                params.put("CISTERNACINTA", chciscinta );
                params.put("CISTERNAMANHOLES", chcismanhole );

                params.put("CISTERNALODERAS", chcislodera );
                params.put("CISTERNATERMINALES", chcisterminal );
                params.put("CISTERNALUCES", chcisluces );
                params.put("CISTERNACONDUCTORES", chciscondcutor );
                params.put("CISTERNAESTMANGUERA", chcismanguera );
                params.put("CISTERNATANQUE", chcitanque );

          //     Toast.makeText( getApplication() ,"response" , Toast.LENGTH_SHORT  ).show();

                return params;

            }


        };
        Log.d("post", postrequest.toString());
        queued.add(postrequest);

    }


}
