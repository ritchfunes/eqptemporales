package com.example.alvinramirez.myapptest;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import java.util.Calendar;
  // import android.support.v4.app.FragmentManager ;

public class Asignacionequipos extends AppCompatActivity {


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


        btnagregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            Boolean valor =    chcabezaldocoperacion.isChecked() ;
            String str = String.valueOf(valor);

            edtcabezal.setText(str);


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

}
