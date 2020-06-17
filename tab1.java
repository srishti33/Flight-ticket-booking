package com.example.travel;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.R.layout;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;
import java.util.HashMap;

import static android.R.layout.*;

public class tab1  extends Fragment {
    //Overriden method onCreateView
    TextView txt2;
    DatePickerDialog datePickerDialog;
    Calendar calender = Calendar.getInstance();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        String[] place ={"Varanasi(VNS)","Vijayawada(VGA)","Udaipur(UDR)","Tiruchirappally(TRZ)",
                "Thiruvananthapuram(TRV)","Salem(SXV)","Srinagar(SXR)","Surat(STV)","Ratnagiri(RTC)","Rourkela(RRK)","Durgapur(RDP)","Pondicherry(PNY)",
                "Pune(PNQ)","Patna(PAT)","Bilaspur(PAB)","Daman and Diu(NMB)","Chennai(MAA)","Ludhiana(LUH)","Lucknow(LKO)","Kota(KTU)",
                "Ajmer(KQH)","Maharashtra(KLH)","Madhya Pradesh(JLR)","Jodhpur(JDH)","Jaipur(JAI)","Port Blair(IXZ)","Kandla(IXY)","Jamshedpur(IXW)",
                "Arunachal Pradesh(IXV)","Aurangabad(IXU)","Silchar(IXS)","Ranchi(IXR)","Pathankot(IXP)","Madurai(IXM)","Jammu(IXJ)","Mangalore(IXE)",
                "Allahabad(IXD)","Chandigarh(IXC)","Siliguri(IXB)","Agartala(IXA)","Nasik(ISK)","Indore(IDR)","Hyderabad(HYD)","Haryana(HSS)",
                "Gwalior(GWL)","Gorakhpur(GOP)","Guwahati(GAU)","Kangra(DHM)","New Delhi(DEL)","Dehradun(DED)","Dhanbad(DBD)","Coimbatore(CJB)",
                "Kolkata(CCU)","Bathinda(BUP)","Mumbai(BOM)","Bangalore(BLR)","Bhopal(BHO)","Vadodara(BDQ)","Bhubaneswar(BBI)","Amritsar(ATQ)","Ahmedabad(AMD)","Gujrat(AMD)","Gaya(GAY)"
        };
        String[] passengers = { "1", "2", "3", "4"};
        String[] cabin = { "Economy", "Premium Economy", "Business class", "First class"};
        final TextView date;
        final DatePickerDialog[] datePickerDialog = new DatePickerDialog[1];
        final int[] year = new int[1];
        final int[] month = new int[1];
        final int[] dayOfMonth = new int[1];
        final Calendar[] calendar = new Calendar[1];
        final String MESSAGE_KEY ="message_key";
        Button btnOpen;

        View view = inflater.inflate(R.layout.activity_tab1, container, false);

        final Spinner spin = (Spinner)view.findViewById(R.id.spin1);
        //Creating the ArrayAdapter instance having the country list
        ArrayAdapter aa = new ArrayAdapter(getActivity(),android.R.layout.simple_spinner_item,passengers);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(aa);

        final Spinner spin2 = (Spinner)view.findViewById(R.id.spin2);
        //Creating the ArrayAdapter instance having the country list
        ArrayAdapter aa1 = new ArrayAdapter(getActivity(),android.R.layout.simple_spinner_item,cabin);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin2.setAdapter(aa1);

        date =(TextView)view.findViewById(R.id.txt2);
        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calendar[0] = Calendar.getInstance();
                year[0] = calendar[0].get(Calendar.YEAR);
                month[0] = calendar[0].get(Calendar.MONTH);
                dayOfMonth[0] = calendar[0].get(Calendar.DAY_OF_MONTH);
                datePickerDialog[0] = new DatePickerDialog(getActivity(),
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                                date.setText(day + "/" + (month + 1) + "/" + year);
                            }
                        }, year[0], month[0], dayOfMonth[0]);
                datePickerDialog[0].getDatePicker().setMinDate(System.currentTimeMillis());
                datePickerDialog[0].show();
            }
        });

        btnOpen=(Button)view.findViewById(R.id.button4);
        ArrayAdapter<String> adapter;
        adapter = new ArrayAdapter<String>
                (getActivity(), select_dialog_item,place);
        //Getting the instance of AutoCompleteTextView
        final AutoCompleteTextView actv =  (AutoCompleteTextView)view.findViewById(R.id.autoCompleteTextView);
        final AutoCompleteTextView actv2 =  (AutoCompleteTextView)view.findViewById(R.id.autoCompleteTextView2);
        actv.setThreshold(1);//will start working from first character
        actv.setAdapter(adapter);//setting the adapter data into the AutoCompleteTextView
        actv2.setThreshold(1);//will start working from first character
        actv2.setAdapter(adapter);

        btnOpen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               String  dest = actv.getText().toString();
                String  arr = actv2.getText().toString();
                String dat=date.getText().toString();

                HashMap<String,Object> map = new HashMap<>();
                map.put("from",actv.getText().toString());
                map.put("to",actv2.getText().toString());
                map.put("date",date.getText().toString());
                map.put("passengers",spin.getSelectedItem().toString());
                map.put("cabin class",spin2.getSelectedItem().toString());

                FirebaseDatabase.getInstance().getReference().child("searchdetail").push()
                        .setValue(map)
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                Log.i("jfbvkj", "onComplete: ");
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Log.i("jfbvkj", "onFailure: "+e.toString());
                            }
                        }).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Log.i("jfbvkj", "onSuccess: ");
                    }
                });
                //Check if getActivity() is actually not null, could be null if fragment detatched, you could also check if its an instance you expect to be
                if(getActivity() != null && getActivity() instanceof searchflight) {
                    Intent intent = new Intent(getActivity(), displayflights.class);
                    intent.putExtra("dept", dest.substring(dest.indexOf('(')+1,dest.length()-1));
                    intent.putExtra("arr", arr.substring(arr.indexOf('(')+1,arr.length()-1));
                    intent.putExtra("datet",dat);
                    getActivity().startActivity(intent);
                }
            }
        });
        //Returning the layout file after inflating
        //Change R.layout.tab1 in you classes
        return view;
    }

}