package com.example.gobuhat;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;


/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment {

    private TextView RegText;

    private EditText UserName, UserPassword;
    private Button LoginBn;

    OnLoginFormActivityListener loginFormActivityListener;
    public interface OnLoginFormActivityListener
    {
        public void performRegister();
        public void performLogin(String name);
    }


    public LoginFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        RegText = view.findViewById(R.id.register_txt);
        UserName = view.findViewById(R.id.user_name);
        UserPassword = view.findViewById(R.id.user_password);

        RegText.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                loginFormActivityListener.performRegister();
            }
        });

        return view;
    }

    @Override
    public void onAttach(Context context)
    {
        super.onAttach(context);
        Activity activity = (Activity) context;

        loginFormActivityListener = (OnLoginFormActivityListener) activity;
    }

}
