package com.example.currencyconverterapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity implements View.OnClickListener {


   // TextToSpeech textToSpeech;

    Button bE, bC, bs;
    EditText tres1;
    TextView tres2;

    countryitem countryitems;
    String clickedcountrynames;


    countryitem countryitemTo;
    String clickedcountrynamesTo;


    private ArrayList<countryitem> countrylist;
    private countryAdapter madapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        inlistcountry();


        tres1 = findViewById(R.id.t1);
        tres1.setOnClickListener(this);

        tres2 = findViewById(R.id.t2);
        tres2.setOnClickListener(this);


        bC = findViewById(R.id.btn_c);
        bC.setOnClickListener(this);

        bE = findViewById(R.id.btn_eq);
        bE.setOnClickListener(this);


        Spinner spin1 = findViewById(R.id.spinner11);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) Spinner spin2 = findViewById(R.id.spinner22);


        madapter = new countryAdapter(this, countrylist);

        spin1.setAdapter(madapter);
        spin2.setAdapter(madapter);

        spin1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                countryitems = (countryitem) adapterView.getItemAtPosition(i);
                clickedcountrynames = countryitems.getCountryname();
                Toast.makeText(MainActivity2.this, clickedcountrynames + "selected", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        spin2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                countryitemTo = (countryitem) adapterView.getItemAtPosition(i);
                clickedcountrynamesTo = countryitemTo.getCountryname();
                Toast.makeText(MainActivity2.this, clickedcountrynamesTo + "selected", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_list,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id=item.getItemId();

        if (id ==R.id.notes){

            Intent intent=new Intent(MainActivity2.this,note1.class);
            startActivity(intent);

            return  true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void inlistcountry() {

        countrylist = new ArrayList<>();
        countrylist.add(new countryitem("India", R.drawable.india));
        countrylist.add(new countryitem("USA", R.drawable.usa));
        countrylist.add(new countryitem("Canada", R.drawable.cad));
        countrylist.add(new countryitem("England", R.drawable.england));
        countrylist.add(new countryitem("Germany", R.drawable.germany));
        countrylist.add(new countryitem("Malaysia", R.drawable.malaysia));

    }


    @Override
    public void onClick(View v) {
        if (v.equals(bC)) {
            tres1.setText(" ");
            tres2.setText("");
        }

        if (v.equals(bE)) {

            try {
                Double totalconcvertedamount;
                Double amount = Double.parseDouble(tres1.getText().toString());
                // Double amount = Double.valueOf("200");


                if (clickedcountrynames.equals("India") && clickedcountrynamesTo.equals("USA")) {

                    totalconcvertedamount = amount / 82.56;
                    String tot = String.format("%.2f", totalconcvertedamount);
                    tres2.setText("" + tot + "$");
                } else if (clickedcountrynames.equals("India") && clickedcountrynamesTo.equals("Canada")) {

                    totalconcvertedamount = amount / 60.60;
                    String tot = String.format("%.2f", totalconcvertedamount);
                    tres2.setText("" + tot + "C$");

                } else if (clickedcountrynames.equals("India") && clickedcountrynamesTo.equals("England")) {

                    totalconcvertedamount = amount / 101.93;
                    String tot = String.format("%.2f", totalconcvertedamount);
                    tres2.setText("" + tot + "£");


                } else if (clickedcountrynames.equals("India") && clickedcountrynamesTo.equals("Germany")) {

                    totalconcvertedamount = amount / 88.60;
                    String tot = String.format("%.2f", totalconcvertedamount);
                    tres2.setText("" + tot + "€");
                } else if (clickedcountrynames.equals("India") && clickedcountrynamesTo.equals("Malaysia")) {

                    totalconcvertedamount = amount / 17.94;
                    String tot = String.format("%.2f", totalconcvertedamount);
                    tres2.setText("" + tot + "RM");

                    //usa to others

                } else if (clickedcountrynames.equals("USA") && clickedcountrynamesTo.equals("India")) {

                    totalconcvertedamount = amount * 82.56;
                    String tot = String.format("%.2f", totalconcvertedamount);
                    tres2.setText("" + tot + "₹");
                } else if (clickedcountrynames.equals("USA") && clickedcountrynamesTo.equals("Canada")) {

                    totalconcvertedamount = amount * 1.36;
                    String tot = String.format("%.2f", totalconcvertedamount);
                    tres2.setText("" + tot + "C$");

                } else if (clickedcountrynames.equals("USA") && clickedcountrynamesTo.equals("England")) {

                    totalconcvertedamount = amount * 0.81;
                    String tot = String.format("%.2f", totalconcvertedamount);
                    tres2.setText("" + tot + "£");


                } else if (clickedcountrynames.equals("USA") && clickedcountrynamesTo.equals("Germany")) {

                    totalconcvertedamount = amount * 0.93;
                    String tot = String.format("%.2f", totalconcvertedamount);
                    tres2.setText("" + tot + "€");
                } else if (clickedcountrynames.equals("USA") && clickedcountrynamesTo.equals("Malaysia")) {

                    totalconcvertedamount = amount * 4.60;
                    String tot = String.format("%.2f", totalconcvertedamount);
                    tres2.setText("" + tot + "RM");
                }

                // canada to others
                else if (clickedcountrynames.equals("Canada") && clickedcountrynamesTo.equals("India")) {

                    totalconcvertedamount = amount * 60.66;
                    String tot = String.format("%.2f", totalconcvertedamount);
                    tres2.setText("" + tot + "₹");

                } else if (clickedcountrynames.equals("Canada") && clickedcountrynamesTo.equals("USA")) {

                    totalconcvertedamount = amount * 0.73;
                    String tot = String.format("%.2f", totalconcvertedamount);
                    tres2.setText("" + tot + "$");

                } else if (clickedcountrynames.equals("Canada") && clickedcountrynamesTo.equals("England")) {

                    totalconcvertedamount = amount * 0.81;
                    String tot = String.format("%.2f", totalconcvertedamount);
                    tres2.setText("" + tot + "£");


                } else if (clickedcountrynames.equals("Canada") && clickedcountrynamesTo.equals("Germany")) {

                    totalconcvertedamount = amount * 1.46;
                    String tot = String.format("%.2f", totalconcvertedamount);
                    tres2.setText("" + tot + "€");
                } else if (clickedcountrynames.equals("Canada") && clickedcountrynamesTo.equals("Malaysia")) {

                    totalconcvertedamount = amount * 3.38;
                    String tot = String.format("%.2f", totalconcvertedamount);
                    tres2.setText("" + tot + "RM");
                }


                //england to others

                else if (clickedcountrynames.equals("England") && clickedcountrynamesTo.equals("India")) {

                    totalconcvertedamount = amount * 101.93;
                    String tot = String.format("%.2f", totalconcvertedamount);
                    tres2.setText("" + tot + "₹");

                } else if (clickedcountrynames.equals("England") && clickedcountrynamesTo.equals("USA")) {

                    totalconcvertedamount = amount * 1.23;
                    String tot = String.format("%.2f", totalconcvertedamount);
                    tres2.setText("" + tot + "$");

                } else if (clickedcountrynames.equals("England") && clickedcountrynamesTo.equals("Canada")) {

                    totalconcvertedamount = amount * 1.68;
                    String tot = String.format("%.2f", totalconcvertedamount);
                    tres2.setText("" + tot + "C$");


                } else if (clickedcountrynames.equals("England") && clickedcountrynamesTo.equals("Germany")) {

                    totalconcvertedamount = amount * 1.15;
                    String tot = String.format("%.2f", totalconcvertedamount);
                    tres2.setText("" + tot + "€");
                } else if (clickedcountrynames.equals("England") && clickedcountrynamesTo.equals("Malaysia")) {

                    totalconcvertedamount = amount * 5.68;
                    String tot = String.format("%.2f", totalconcvertedamount);
                    tres2.setText("" + tot + "RM");
                }

                // germany to others


                else if (clickedcountrynames.equals("Germany") && clickedcountrynamesTo.equals("India")) {

                    totalconcvertedamount = amount * 88.60;
                    String tot = String.format("%.2f", totalconcvertedamount);
                    tres2.setText("" + tot + "₹");

                } else if (clickedcountrynames.equals("Germany") && clickedcountrynamesTo.equals("USA")) {

                    totalconcvertedamount = amount * 1.07;
                    String tot = String.format("%.2f", totalconcvertedamount);
                    tres2.setText("" + tot + "$");

                } else if (clickedcountrynames.equals("Germany") && clickedcountrynamesTo.equals("Canada")) {

                    totalconcvertedamount = amount * 1.46;
                    String tot = String.format("%.2f", totalconcvertedamount);
                    tres2.setText("" + tot + "C$");


                } else if (clickedcountrynames.equals("Germany") && clickedcountrynamesTo.equals("England")) {

                    totalconcvertedamount = amount * 0.87;
                    String tot = String.format("%.2f", totalconcvertedamount);
                    tres2.setText("" + tot + "£");
                } else if (clickedcountrynames.equals("Germany") && clickedcountrynamesTo.equals("Malaysia")) {

                    totalconcvertedamount = amount * 4.94;
                    String tot = String.format("%.2f", totalconcvertedamount);
                    tres2.setText("" + tot + "RM");
                }

                // malaysia to others


                else if (clickedcountrynames.equals("Malaysia") && clickedcountrynamesTo.equals("India")) {

                    totalconcvertedamount = amount * 17.94;
                    String tot = String.format("%.2f", totalconcvertedamount);
                    tres2.setText("" + tot + "₹");

                } else if (clickedcountrynames.equals("Malaysia") && clickedcountrynamesTo.equals("USA")) {

                    totalconcvertedamount = amount * 0.22;
                    String tot = String.format("%.2f", totalconcvertedamount);
                    tres2.setText("" + tot + "$");

                } else if (clickedcountrynames.equals("Malaysia") && clickedcountrynamesTo.equals("Canada")) {

                    totalconcvertedamount = amount * 0.30;
                    String tot = String.format("%.2f", totalconcvertedamount);
                    tres2.setText("" + tot + "C$");


                } else if (clickedcountrynames.equals("Malaysia") && clickedcountrynamesTo.equals("England")) {

                    totalconcvertedamount = amount * 0.18;
                    String tot = String.format("%.2f", totalconcvertedamount);
                    tres2.setText("" + tot + "£");
                } else if (clickedcountrynames.equals("Malaysia") && clickedcountrynamesTo.equals("Germany")) {

                    totalconcvertedamount = amount * 0.20;
                    String tot = String.format("%.2f", totalconcvertedamount);
                    tres2.setText("" + tot + "€");
                }

            } catch (Exception e) {
                Toast.makeText(MainActivity2.this, "invalid", Toast.LENGTH_SHORT).show();
            }


        }
    }
}