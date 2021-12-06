package com.example.bankapp.fragments;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.bankapp.R;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
import com.journeyapps.barcodescanner.BarcodeEncoder;

public class QRFragment extends Fragment {

    private EditText qr_editText;
    private Button qr_generate,btn_layout_generate,btn_layout_scan,qr_scan;
    private ImageView qr_output;
    private LinearLayout qr_gen,qr_sc;


    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        IntentResult intentResult =IntentIntegrator.parseActivityResult(requestCode,resultCode,data);

        if (intentResult.getContents() != null){
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            builder.setTitle("Result");
            builder.setMessage(intentResult.getContents());
            builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            });
            builder.show();
        }else{
            Toast.makeText(getActivity(), "Nothing Was Scanned", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_q_r, container, false);

        qr_editText = view.findViewById(R.id.qr_editText);
        qr_generate = view.findViewById(R.id.qr_generate);
        qr_scan = view.findViewById(R.id.qr_scan);
        qr_output = view.findViewById(R.id.qr_output);
        btn_layout_generate = view.findViewById(R.id.btn_layout_generate);
        btn_layout_scan = view.findViewById(R.id.btn_layout_scan);
        qr_gen = view.findViewById(R.id.qr_layout_generate);
        qr_sc = view.findViewById(R.id.qr_layout_scan);

        btn_layout_generate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                qr_gen.setVisibility(View.VISIBLE);
            }
        });

        btn_layout_scan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                qr_sc.setVisibility(View.VISIBLE);
            }
        });

        qr_generate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input = qr_editText.getText().toString().trim();
                MultiFormatWriter writer = new MultiFormatWriter();
                try {
                    BitMatrix matrix = writer.encode(input, BarcodeFormat.QR_CODE,350,350);
                    BarcodeEncoder encoder = new BarcodeEncoder();

                    Bitmap bitmap = encoder.createBitmap(matrix);
                    qr_output.setImageBitmap(bitmap);

                    InputMethodManager manager = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                    manager.hideSoftInputFromWindow(qr_editText.getApplicationWindowToken(),0);
                } catch (WriterException e) {
                    e.printStackTrace();
                }

            }
        });

        qr_scan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IntentIntegrator intentIntegrator = new IntentIntegrator(getActivity());
                intentIntegrator.setPrompt("For Flash use the Volume up button");
                intentIntegrator.setBeepEnabled(true);
                intentIntegrator.setOrientationLocked(true);
                intentIntegrator.setCaptureActivity(Capture.class);
                intentIntegrator.initiateScan();
            }
        });



        return view;
    }
}