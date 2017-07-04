package drbond.mortgagecalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import java.text.NumberFormat;
import java.lang.Math;

public class MainActivity extends AppCompatActivity {

    // Formatting
    private static final NumberFormat currencyFormat =
            NumberFormat.getCurrencyInstance();
    private static final NumberFormat percentFormat =
            NumberFormat.getPercentInstance();

    // Variables
    private double purchasePrice = 0.0;
    private double downPayment = 0.0;
    private double interestRate = 0.0;
    private int duration = 20;

    //TextViews
    private TextView mortgagePayment;
    private TextView durationTerm;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // TextView References
        mortgagePayment = (TextView) findViewById(R.id.mortgagePayment);
        durationTerm = (TextView) findViewById(R.id.durationTermTextView);

        // TextWatchers
        EditText purchasePriceEditText =
                (EditText) findViewById(R.id.purchasePriceEditText);
        purchasePriceEditText.addTextChangedListener(purchasePriceEditTextWatcher);

        EditText downPaymentEditText =
                (EditText) findViewById(R.id.downPaymentEditText);
        downPaymentEditText.addTextChangedListener(downPaymentEditTextWatcher);

        EditText interestEditText =
                (EditText) findViewById(R.id.interestEditText);
        interestEditText.addTextChangedListener(interestEditTextWatcher);

        // SeekBar
        SeekBar durationSeekBar =
                (SeekBar) findViewById(R.id.durationSeekBar);
        durationSeekBar.setOnSeekBarChangeListener(seekBarListener);

    }

    // mortgage calculator

    private void calculator() {
    // prepare inputs for calculation
        interestRate /= 100.0;
        double loanAmount = purchasePrice-downPayment;
        double monthlyRate = interestRate / 12.0;
        int termInMonths = duration * 12;

        // calculate the monthly payment and display
        double mortgageCalc =(loanAmount*monthlyRate) /
                (1-Math.pow(1+monthlyRate, -termInMonths));
        mortgagePayment.setText(currencyFormat.format((mortgageCalc)));
    }

    // listener object for PurchasePrice EditText
    private final TextWatcher purchasePriceEditTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            purchasePrice = Double.parseDouble(s.toString());
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };

    // listener object for DownPayment EditText
    private final TextWatcher downPaymentEditTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            downPayment = Double.parseDouble(s.toString());
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };

    // listener object for InterestRate EditText

    private final TextWatcher interestEditTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            interestRate = Double.parseDouble(s.toString());
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };

    // listener object for the Duration SeekBar
    private final SeekBar.OnSeekBarChangeListener seekBarListener =
            new SeekBar.OnSeekBarChangeListener() {
                // update percent, then call calculate
                @Override
                public void onProgressChanged(SeekBar seekBar, int progress,
                                              boolean fromUser) {
                    seekBar.setProgress(20);
                    seekBar.setMax(30);

                    duration = progress; // set duration based on bar progress
                    calculator(); // calculate & display
                }

                @Override
                public void onStartTrackingTouch(SeekBar seekBar) { }

                @Override
                public void onStopTrackingTouch(SeekBar seekBar) { }
            };

}


