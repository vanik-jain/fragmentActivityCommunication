package com.example.fragmentdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity  implements DynamicFragment.IFragmentCommunicator {


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("FRAGMENT","ActivityOnCreate");

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        DynamicFragment dynamicFragment = new DynamicFragment();
        fragmentTransaction.add(R.id.fragment_container,dynamicFragment);
        fragmentTransaction.commit();
    }

    @Override
    protected void onStart()
    {
        super.onStart();
        Log.i("FRAGMENT","ActivityOnStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("FRAGMENT","ActivityOnResume");
    }

    @Override
    protected void onPause()
    {
        super.onPause();
        Log.i("FRAGMENT","ActivityOnPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("FRAGMENT","ActivityOnStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("FRAGMENT","ActivityOnDestroy");
    }

    @Override
    public void onTextChangeOfFragment(DynamicFragment dynamicFragment)
    {

        View view=dynamicFragment.getView();
        EditText editText = view.findViewById(R.id.editText);
        String text = editText.getText().toString();
        TextView textView = findViewById(R.id.textView);
        textView.setText(text);
    }
}
