package drbond.mortgagecalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import java.text.DecimalFormat;
import java.text.NumberFormat;


public class MainActivity extends AppCompatActivity {

    // formatters
    private static final NumberFormat currencyFormat =
            NumberFormat.getCurrencyInstance();
    private static final NumberFormat percentFormat =
            NumberFormat.getPercentInstance();

    private double purchasePrice = 0.0;
    private double downPayment = 0.0;
    private double interestRate = 0.0;
    private int duration = 20;

    private TextView purchasePriceTextView;
    private TextView downPaymentTextView;
    private TextView mortgagePayment;



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



    }

    // mortgage calculator

    private void calculator() {


    }


    // listener object for PurchasePrice EditText


    // listener object for DownPayment EditText

    // listener object for InterestRate EditText



    // listener object for the Duration SeekBar

    private final SeekBar.OnSeekBarChangeListener seekBarListener =
            new SeekBar.OnSeekBarChangeListener() {
                // update percent, then call calculate
                @Override
                public void onProgressChanged(SeekBar seekBar, int progress,
                                              boolean fromUser) {
                    duration = progress; // set percent based on progress
                    calculator(); // calculate and display tip and total
                }

                @Override
                public void onStartTrackingTouch(SeekBar seekBar) { }

                @Override
                public void onStopTrackingTouch(SeekBar seekBar) { }
            };



}


