package com.kubo.gitlabandroid;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

import com.kubo.gitlabandroid.utils.DialogUtil;
import com.kubo.gitlabandroid.utils.GitLabUtil;
import com.kubo.gitlabandroid.utils.ToastUtil;

public class VerifyConnection extends AppCompatActivity {
    private EditText host;
    private Switch sslSwitch;
    private TextView verifyConnection;
    private GitLabUtil gitLabUtil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.verify_connection_main);

        verifyConnection(this);

    }

    private void verifyConnection(final Context context) {
        host = findViewById(R.id.host);
        sslSwitch = findViewById(R.id.ssl_switch);
        verifyConnection = findViewById(R.id.verify_tv);
        verifyConnection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(host == null || "".equals(host)) {
                    DialogUtil.showDialog(context, "Connection Error",
                            "Could not connect to the server");
                }
                StringBuilder stringBuilder = gitLabUtil.getUser();
                if (stringBuilder == null) {
                    DialogUtil.showDialog(context, "Connection Error",
                            "Could not connect to the server");
                }
                new ToastUtil().show(context, "Verifying connection...");
            }
        });

    }



}
