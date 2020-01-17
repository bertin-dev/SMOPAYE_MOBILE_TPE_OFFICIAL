package com.ezpass.smopaye_mobile.vuesUtilisateur;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.ezpass.smopaye_mobile.Assistance.HomeAssistanceOnline;
import com.ezpass.smopaye_mobile.R;
import com.ezpass.smopaye_mobile.ServicesIndisponible;
import com.ezpass.smopaye_mobile.vuesAccepteur.ConsulterSolde;

import java.text.DateFormat;
import java.util.Calendar;

public class AccueilFragmentUser extends Fragment {

    TextView jour, jourSemaine, moisAnnee;
    private LinearLayout btnRecharge, btnConsulter;
    //private LinearLayout CheckCardNumber;
    FloatingActionButton assistanceOnline;
    private Button consulterHistoriqueUser;

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        View view =  inflater.inflate(R.layout.fragment_accueil_user, container, false);

        btnRecharge = (LinearLayout) view.findViewById(R.id.btnRecharger);
        btnConsulter = (LinearLayout) view.findViewById(R.id.btnConsultSolde);
        //CheckCardNumber = (LinearLayout) view.findViewById(R.id.btnCheckCardNumber);
        assistanceOnline = view.findViewById(R.id.btnAssistanceOnline);



        jour = (TextView) view.findViewById(R.id.jour);
        jourSemaine = (TextView) view.findViewById(R.id.jourSemaine);
        moisAnnee   = (TextView) view.findViewById(R.id.moisAnnee);


        //GESTION DES DATE DU MENU
        Calendar calendar = Calendar.getInstance();
        // String currentDate = DateFormat.getDateInstance().format(calendar.getTime());// 31.07.2019
        String currentDate2 = DateFormat.getDateInstance(DateFormat.FULL).format(calendar.getTime());
        String[] part =currentDate2.split(" ");
        if(part[0].equalsIgnoreCase(currentDate2)){
            Toast.makeText(getActivity(), "la date est en Anglais", Toast.LENGTH_SHORT).show();
        }
        else {
            jourSemaine.setText(part[0]);
            String Day = "0" + part[1];
            if(Integer.parseInt(part[1]) < 10)
                jour.setText(Day);
            else
                jour.setText(part[1]);
            moisAnnee.setText(String.format("%s %s", part[2], part[3]));
        }


        //GESTION DES EVENEMENTS SUR LES BOUTONS DU MENU

        btnRecharge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), RechargePropreCompte.class);
                startActivity(intent);
            }
        });

        btnConsulter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ConsulterSolde.class);
                startActivity(intent);
            }
        });

        /*CheckCardNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), VerifierNumCarte.class);
                startActivity(intent);
            }
        });*/


        //GESTION DES EVENEMENTS SUR LES BOUTONS DU MENU
        assistanceOnline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), HomeAssistanceOnline.class);
                //intent.putExtra("resultatBD", resultat_bd);
                //intent.putExtra("telephone", telephone);
                startActivity(intent);
            }
        });

        consulterHistoriqueUser = (Button) view.findViewById(R.id.consulterHistoriqueUser);
        consulterHistoriqueUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*Intent intent = new Intent(getActivity(), MenuHistoriqueTransaction.class);
                startActivity(intent);*/
                Intent intent = new Intent(getActivity(), ServicesIndisponible.class);
                startActivity(intent);
            }
        });

        return view;
    }
}
