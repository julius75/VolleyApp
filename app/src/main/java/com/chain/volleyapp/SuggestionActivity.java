package com.chain.volleyapp;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class SuggestionActivity extends AppCompatActivity
{

    private static String S_URL ="http://10.0.3.2/volley/suggestions.php";
    EditText title,message,signUpPassword;
    Button suggestion;
    CheckBox checkBoxTerms;private Snackbar snackbar;
    private ProgressDialog pd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suggestion);
        title = findViewById(R.id.title);
        pd = new ProgressDialog(SuggestionActivity.this);
        suggestion = findViewById(R.id.submit);
        message = findViewById(R.id.message);

        suggestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SuggestionActivity.this, "success", Toast.LENGTH_SHORT).show();
                suggestionPost();
            }
        });
    }


    private void suggestionPost(){
        pd.setMessage("Signing Up . . .");
        pd.show();
        RequestQueue queue = Volley.newRequestQueue(SuggestionActivity.this);
        String response = null;
        final String finalResponse = response;

        StringRequest postRequest = new StringRequest(Request.Method.POST, S_URL,
                new Response.Listener<String>()
                {
                    @Override
                    public void onResponse(String response) {
                       // pd.hide();
                        pd.dismiss();
                        //Response
                       // showSnackbar(response);

                        if(response.equals("Successfully Posted the suggestion")) {
                            Toast.makeText(SuggestionActivity.this, "Suggestion successful posted",
                                    Toast.LENGTH_SHORT).show();

                            //startActivity(new Intent(getApplicationContext(), LoginActivity.class));

                        }
                        else{
                            Toast.makeText(SuggestionActivity.this, "Suggestion not successful posted"+response,
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                },
                new Response.ErrorListener()
                {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // error
                        Log.d("ErrorResponse","error in response");


                    }
                }
        ) {
            @Override
            protected Map<String, String> getParams()
            {
                SharedPreferences sharedPref = getPreferences(Context.MODE_PRIVATE);
                String id=sharedPref.getString("logged", String.valueOf(1));
                Map<String, String>  params = new HashMap<String, String>();

                params.put("title", title.getText().toString());
                params.put("description", message.getText().toString());
                //Toast.makeText(getApplicationContext(),""+id,Toast.LENGTH_LONG).show();

                Log.d("const id",Constants.useridlogged);

                params.put("user_id",Constants.useridlogged);

                return params;
            }
        };
        postRequest.setRetryPolicy(new DefaultRetryPolicy(0,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        queue.add(postRequest);

    }

    public void showSnackbar(String stringSnackbar){
        snackbar.make(findViewById(android.R.id.content), stringSnackbar.toString(), Snackbar.LENGTH_SHORT)
                .setActionTextColor(getResources().getColor(R.color.colorPrimary))
                .show();
    }

    public void submitSuggest(View view) {
        Toast.makeText(this, "yess", Toast.LENGTH_SHORT).show();
        suggestionPost();
    }
}
