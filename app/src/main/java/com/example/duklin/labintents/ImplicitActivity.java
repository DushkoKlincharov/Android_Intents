package com.example.duklin.labintents;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

public class ImplicitActivity extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_implicit);

        textView = (TextView) findViewById(R.id.launchers);

        StringBuilder sb = new StringBuilder();

        PackageManager pm = getPackageManager();
        Intent i = new Intent(Intent.ACTION_MAIN);
        i.addCategory(Intent.CATEGORY_LAUNCHER);
        List<ResolveInfo> lst = pm.queryIntentActivities(i, 0);
        for (ResolveInfo resolveInfo : lst) {
            sb.append(resolveInfo.activityInfo.packageName + "\n");
        }

        textView.setMovementMethod(new ScrollingMovementMethod());
        textView.setText(sb.toString());
    }
}
