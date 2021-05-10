package com.shopping.latdtest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import org.json.JSONObject;

import io.branch.referral.Branch;
import io.branch.referral.BranchError;
import io.branch.referral.ServerRequestGetLATD;

public class MainActivity extends AppCompatActivity {

    TextView textView = findViewById(R.id.textView);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Branch.sessionBuilder(this).withCallback(branchReferralInitListener).withData(getIntent() != null ? getIntent().getData() : null).init();
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Branch.sessionBuilder(this).withCallback(branchReferralInitListener).reInit();
    }

    private Branch.BranchReferralInitListener branchReferralInitListener = (linkProperties, error) -> {
        // do stuff with deep link data (nav to page, display content, etc)
        if(error!=null){
            Log.d("Branch", ": "+error);
        }
        textView.setText(linkProperties.toString());
        Log.d("SDK response : ", "onInitFinished: " + linkProperties.toString());
    };

}