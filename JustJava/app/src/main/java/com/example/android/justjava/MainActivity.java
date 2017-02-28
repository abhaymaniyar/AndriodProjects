package com.example.android.justjava; /**
 * Add your package below. Package name can be found in the project's AndroidManifest.xml file.
 * This is the package name our example uses:
 * <p/>
 * package com.example.android.justjava;
 */

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

     int quantity = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        int price = 5; // price per cup of coffee
        CheckBox whippedCreamCheck = (CheckBox) findViewById(R.id.cream_checkbox);
        CheckBox chocolateToppingsCheck = (CheckBox) findViewById(R.id.choclate_toppings_checkbox);
        EditText nameOfUser = (EditText) findViewById(R.id.name_entered);
        String userName = nameOfUser.getText().toString();
        boolean hasWhippedCream = whippedCreamCheck.isChecked();
        if(hasWhippedCream){
            price++;
        }
        boolean hasChocolateToppings = chocolateToppingsCheck.isChecked();
        if(hasChocolateToppings){
            price += 2;
        }
        price *= quantity;
        String priceMessage = "Name: "+userName;
        priceMessage += "\nAdd whipped cream? : "+(hasWhippedCream ? "Yes" : "No");
        priceMessage += "\nAdd Chocolate toppings? : "+(hasChocolateToppings ? "Yes" : "No");
        priceMessage += "\nQuantity: "+quantity;
        priceMessage += "\nTotal : Rs." + price;
        priceMessage += "\nThank you!";
//        displayMessage(priceMessage, hasWhippedCream);
        String subject = "JustJava order for ";
        String msg = priceMessage;
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_SUBJECT, subject+userName);
        intent.putExtra(Intent.EXTRA_TEXT, msg);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }



    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);

    }

    /**
     * This method displays the given price on the screen.
     */
//    private void displayPrice(int number) {
//        TextView orderSummaryView = (TextView) findViewById(R.id.order_summary_view);
//        orderSummaryView.setText(NumberFormat.getCurrencyInstance().format(number));
//    }

    public void increment(View view) {
        if(quantity >= 100) {
            Toast.makeText(this, "Cannot order more than 100 coffees", Toast.LENGTH_SHORT).show();
            return;
        }
        quantity++;
        display(quantity);
    }

    public void decrement(View view) {
        if(quantity <= 1){
            Toast.makeText(this, "Cannot order less than 1 coffee", Toast.LENGTH_SHORT).show();
            return;
        }
            quantity--;

        display(quantity);
    }

    /**
     * This method displays the given text on the screen.
     */
//    private void displayMessage(String message, boolean check) {
//        TextView orderSummaryView = (TextView) findViewById(R.id.order_summary_view);
//        orderSummaryView.setText(message+"\n Add whipped cream? : "+check);
//        orderSummaryView.setText(message);
//    }

//    @Override
//    protected void onSaveInstanceState(Bundle outState) {
//        TextView orderSummaryView = (TextView) findViewById(R.id.order_summary_view);
//        CheckBox whippedCreamCheck = (CheckBox) findViewById(R.id.cream_checkbox);
//        CheckBox chocolateToppingsCheck = (CheckBox) findViewById(R.id.choclate_toppings_checkbox);
//        String orderSummary = "asdf";
//        outState.putString(orderSummary, orderSummaryView.toString());
//        outState.putInt("quantity", quantity);
//        outState.putBoolean("whipped", Boolean.valueOf(whippedCreamCheck.toString()));
//        outState.putBoolean("Chocolate", Boolean.valueOf(chocolateToppingsCheck.toString()));
//        super.onSaveInstanceState(outState);
//    }
//
//    @Override
//    protected void onRestoreInstanceState(Bundle savedInstanceState) {
//        super.onRestoreInstanceState(savedInstanceState);
//        TextView orderSummaryView = (TextView) findViewById(R.id.order_summary_view);
//        CheckBox whippedCreamCheck = (CheckBox) findViewById(R.id.cream_checkbox);
//        CheckBox chocolateToppingsCheck = (CheckBox) findViewById(R.id.choclate_toppings_checkbox);
//        orderSummaryView.setText(savedInstanceState.getString("asdf"));
//        whippedCreamCheck.performClick(Boolean.valueOf(savedInstanceState.getBoolean("whipped")));
//
//    }
}