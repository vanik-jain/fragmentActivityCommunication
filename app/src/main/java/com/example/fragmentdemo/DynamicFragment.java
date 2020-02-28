package com.example.fragmentdemo;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class DynamicFragment extends Fragment {
    private IFragmentCommunicator iFragmentCommunicator;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        Log.i("FRAGMENT", "onAttach");

        try {
            iFragmentCommunicator = (IFragmentCommunicator) context;
        } catch (ClassCastException e)
        {
            e.printStackTrace();
        }


    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("FRAGMENT", "onCreate");
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        return super.onCreateView(inflater, container, savedInstanceState);
        Log.i("FRAGMENT", "onCreateView");
        return inflater.inflate(R.layout.dynamic_fragment, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        EditText editText = view.findViewById(R.id.editText);
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                iFragmentCommunicator.onTextChangeOfFragment(DynamicFragment.this);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.i("FRAGMENT", "onActivityCreated");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.i("FRAGMENT", "onStart");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.i("FRAGMENT", "onResume");
    }


    @Override
    public void onPause() {
        super.onPause();
        Log.i("FRAGMENT", "onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.i("FRAGMENT", "onStop");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.i("FRAGMENT", "onDestroyView");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i("FRAGMENT", "onDestroy");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.i("FRAGMENT", "onDetach");
    }


    public interface IFragmentCommunicator {
        void onTextChangeOfFragment(DynamicFragment dynamicFragment);
    }


}
