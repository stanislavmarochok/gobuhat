package com.example.gobuhat;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class RegistrationFragment extends Fragment {
    private EditText Name, UserName, UserSurname, UserEmail, UserPassword;
    private Button BnRegister;


    public RegistrationFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_registration, container, false);

        Name = view.findViewById(R.id.name);
        UserName = view.findViewById(R.id.user_name);
        UserSurname = view.findViewById(R.id.user_surname);
        UserEmail = view.findViewById(R.id.user_email);
        UserPassword = view.findViewById(R.id.user_password);

        BnRegister = view.findViewById(R.id.sign_up);
        BnRegister.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                performRegistration();
            }
        });
        return view;
    }

    public void performRegistration()
    {
        String name = Name.getText().toString();
        String user_name = UserName.getText().toString();
        String user_surname = UserSurname.getText().toString();
        String user_email = UserEmail.getText().toString();
        String user_password = UserPassword.getText().toString();

        Call<User> call = MainActivity.apiInterface.performRegitration(name, user_name, user_surname, user_email, user_password, 1);

        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if (response.body().getResponse().equals("ok"))
                {
                    MainActivity.prefConfig.displayToast("Registration success.....");
                }
                else
                    if (response.body().getResponse().equals("exist"))
                    {
                        MainActivity.prefConfig.displayToast("User already exist....");
                    }
                else if (response.body().getResponse().equals("error"))
                    {
                        MainActivity.prefConfig.displayToast("Registration failed....");
                    }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {

            }
        });
        Name.setText("");
        UserName.setText("");
        UserSurname.setText("");
        UserEmail.setText("");
        UserPassword.setText("");
    }

}
