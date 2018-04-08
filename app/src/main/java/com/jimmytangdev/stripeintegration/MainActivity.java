package com.jimmytangdev.stripeintegration;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.support.customtabs.CustomTabsIntent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.stripe.android.Stripe;
import com.stripe.android.TokenCallback;
import com.stripe.android.model.Card;
import com.stripe.android.model.Token;
import com.stripe.android.view.CardInputWidget;

import java.util.HashMap;
import java.util.Map;

import static java.security.AccessController.getContext;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


//        CardInputWidget mCardInputWidget = (CardInputWidget) findViewById(R.id.card_input_widget);
//
//        Card cardToSave = mCardInputWidget.getCard();
//        if (cardToSave == null) {
//            Toast.makeText(this, "Invalid Card", Toast.LENGTH_SHORT).show();
//        } else {
//            Stripe stripe = new Stripe(this, "pk_test_1Tqu2RRf2owV3RCWuHV0whMY");
//            stripe.createToken(
//                    cardToSave,
//                    new TokenCallback() {
//                        public void onSuccess(Token token) {
//                            // Send token to your server
//                        }
//
//                        public void onError(Exception error) {
//                            // Show localized error message
//                            Toast.makeText(MainActivity.this, "Error has occurred", Toast.LENGTH_SHORT).show();
//                        }
//                    }
//            );
//        }


    }

    public void stripeConnectClick(View view) {


        try {
            String url = "https://connect.stripe.com/oauth/authorize?response_type=code&client_id=ca_CZ4aDK786Nldnls07ScF72v6UnNbhMvN&scope=read_write";
            CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
            CustomTabsIntent customTabsIntent = builder.build();
            customTabsIntent.launchUrl(this, Uri.parse(url));
            Intent s = new Intent(this, StripeConnectView.class);
            startActivity(s);
        } catch (ActivityNotFoundException f) {
//            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://connect.stripe.com/oauth/authorize?response_type=code&client_id=ca_CZ4aDK786Nldnls07ScF72v6UnNbhMvN&scope=read_write"));
//            startActivity(browserIntent);
            Intent stripe_connect = new Intent(getApplicationContext(), StripeConnectView.class);
            startActivity(stripe_connect);
        }


    }

    public void stipeConnectBrowswer(View view) {
//        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://connect.stripe.com/oauth/authorize?response_type=code&client_id=ca_CZ4aDK786Nldnls07ScF72v6UnNbhMvN&scope=read_write"));
//        startActivity(browserIntent);
        Intent stripe_connect = new Intent(getApplicationContext(), StripeConnectView.class);
        startActivity(stripe_connect);
    }
}
