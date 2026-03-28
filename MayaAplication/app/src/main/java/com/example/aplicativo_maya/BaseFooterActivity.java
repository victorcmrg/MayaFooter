package com.example.aplicativo_maya;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

public abstract class BaseFooterActivity extends AppCompatActivity {

    protected FooterNavigationView footer;

    protected abstract int getTabIndex();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(0, 0);
    }

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        setupFooter();
    }

    private void setupFooter() {
        footer = findViewById(R.id.footer_navigation);
        if (footer == null) return;
        footer.setOnTabSelectedListener(index -> NavigationRouter.navigateTo(this, index));
    }

    @Override
    protected void onResume() {
        super.onResume();
        overridePendingTransition(0, 0);
        if (footer != null) footer.setSelectedTab(getTabIndex());
    }
}