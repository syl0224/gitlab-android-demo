package com.kubo.gitlabandroid.utils;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.Gravity;
import android.widget.TextView;

public class DialogUtil {
    public static AlertDialog alertDialog;

    public static void showCustomDialog(Context context, String title, String msg) {
        TextView titleView = new TextView(context);
        titleView.setText(title);
        titleView.setPadding(10, 40, 10, 0);
        titleView.setGravity(Gravity.CENTER);
        titleView.setTextSize(18);

        TextView msgView = new TextView(context);
        msgView.setText(msg);
        msgView.setPadding(10, 0, 10, 0);
        msgView.setGravity(Gravity.CENTER);
        msgView.setTextSize(14);

        alertDialog = new AlertDialog.Builder(context)
                .setCustomTitle(titleView)
                .setView(msgView)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        if(i == DialogInterface.BUTTON_POSITIVE) {
                            alertDialog.hide();
                        }
                    }
                })
                .create();
        alertDialog.show();
    }

    public static void showDialog(Context context, String title, String msg) {
        alertDialog = new AlertDialog.Builder(context)
                .setTitle(title)
                .setMessage(msg)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        if(i == DialogInterface.BUTTON_POSITIVE) {
                            alertDialog.hide();
                        }
                    }
                })
                .create();
        alertDialog.show();
    }

}
