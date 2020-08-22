package com.example.game;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import java.time.Instant;
import java.util.HashMap;
import java.util.HashSet;

public class TicFragment extends Fragment {
    private int [] buttons = {R.id.btn_1_1, R.id.btn_1_2, R.id.btn_1_3, R.id.btn_2_1, R.id.btn_2_2,
    R.id.btn_2_3, R.id.btn_3_1, R.id.btn_3_2, R.id.btn_3_3};
    private int [] gamer1re = new int[3];
    private int [] gamer1di = new int[3];
    private int [] gamer2re = new int[3];
    private int [] gamer2di = new int[3];
    private int cnt = 0;
    public TicFragment() {

    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_tic, container, false);
        for (int i = 0; i < buttons.length; i++) {
            final Button button = view.findViewById(buttons[i]);
            final int finalI = i;
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (cnt % 2 == 1){
                       Toast.makeText(getActivity(), "Gamer number 2 choice!", Toast.LENGTH_SHORT).show();
                       button.setText("O");
                       gamer2re[finalI % 3]++;
                       gamer2di[finalI / 3]++;
                       for (int i = 0; i < 3; i++){
                           if (gamer2di[i] == 3 || gamer2re[i] == 3){
                               Snackbar snackBar = Snackbar.make(getActivity().findViewById(android.R.id.content),
                                       "Gamer 2 is the winner!", Snackbar.LENGTH_LONG);
                               snackBar.show();
                           }
                       }
                       if (gamer2di[0] == 1 && gamer2di[1] == 1 && gamer2di[2] == 1 &&
                               gamer2re[0] == 1 && gamer2re[1] == 1 && gamer2re[2] == 1 ){
                               Snackbar snackBar = Snackbar.make(getActivity().findViewById(android.R.id.content),
                                   "Gamer 2 is the winner!", Snackbar.LENGTH_LONG);
                               snackBar.show();
                       }
                    }
                    else{
                        Toast.makeText(getActivity(), "Gamer number 1 choice!", Toast.LENGTH_SHORT).show();
                        button.setText("X");
                        gamer1re[finalI % 3]++;
                        gamer1di[finalI / 3]++;
                        for (int i = 0; i < 3; i++){
                            if (gamer1di[i] == 3 || gamer1re[i] == 3){
                                Snackbar snackBar = Snackbar.make(getActivity().findViewById(android.R.id.content),
                                        "Gamer 1 is the winner!", Snackbar.LENGTH_LONG);
                                snackBar.show();
                            }
                        }
                        if (gamer1di[0] == 1 && gamer1di[1] == 1 && gamer1di[2] == 1 &&
                                gamer1re[0] == 1 && gamer1re[1] == 1 && gamer1re[2] == 1 ){
                            Snackbar snackBar = Snackbar.make(getActivity().findViewById(android.R.id.content),
                                    "Gamer 1 is the winner!", Snackbar.LENGTH_LONG);
                            snackBar.show();
                        }
                    }
                    cnt++;

                }
            });
        }
        return view;
    }

}