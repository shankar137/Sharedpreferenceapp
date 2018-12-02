package com.alliance.ex9;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity
{
    SharedPreferences sp;
    EditText em;
    EditText name;
    public static final String mypreference="mypref";
    public static final String Name="nameKey";
    public static final String Email="emailKey";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        em=findViewById(R.id.e1);
        name=findViewById(R.id.e2);
        sp=getSharedPreferences(mypreference,MODE_PRIVATE);
        retrieve();

    }

    public void Save(View view)
    {
        String n=name.getText().toString();
        String e=em.getText().toString();
        SharedPreferences.Editor edit=sp.edit();
        edit.putString(Name,n);
        edit.putString(Email,e);
        edit.apply();
    }

    public void Retrieve(View view)
    {
        retrieve();
    }

    private void retrieve()
    {
        if (sp.contains(Name))
        {
            name.setText(sp.getString(Name,""));
        }
        if (sp.contains(Email))
        {
            em.setText(sp.getString(Email,""));
        }
    }

    public void Clear(View view)
    {
        name.setText("");
        em.setText("");
    }
}
