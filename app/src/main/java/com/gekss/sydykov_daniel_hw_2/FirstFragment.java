package com.gekss.sydykov_daniel_hw_2;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class FirstFragment extends Fragment {

    private TextView tvZero;
    private Button btnPlus, btnMinus, btnNext;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        findId();
        onClick();
    }

    private void findId() {
        tvZero = requireActivity().findViewById(R.id.tv_zero);
        btnMinus = requireActivity().findViewById(R.id.btn_minus);
        btnPlus = requireActivity().findViewById(R.id.btn_plus);
        btnNext = requireActivity(). findViewById(R.id.btn_next);
    }

    private void onClick (){
        btnPlus.setOnClickListener(view -> {
            operationPlus();
        });
        btnMinus.setOnClickListener(view -> {
            operationMinus();
        });
        btnNext.setOnClickListener(view -> {
            navigateSek();
        });
    }

    private void operationPlus(){
        int val = Integer.parseInt(tvZero.getText().toString());
        if (val < 10){
            val++;
            tvZero.setText(String.valueOf(val));
        } else if (val==10) {
            btnNext.setVisibility(View.VISIBLE);
        }
    }

    private void operationMinus() {
        int val = Integer.parseInt(tvZero.getText().toString());
        if (val >= 0) {
            val--;
            tvZero.setText(String.valueOf(val));
        }
    }

    private void navigateSek(){
        String value = tvZero.getText().toString();
        Bundle bundle = new Bundle();
        bundle.putString("num",value);
        SecontFragment secontFragment = new SecontFragment();
        secontFragment.setArguments(bundle);
        requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, secontFragment).commit();
    }
}