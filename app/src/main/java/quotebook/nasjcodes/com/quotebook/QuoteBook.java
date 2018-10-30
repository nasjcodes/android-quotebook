package quotebook.nasjcodes.com.quotebook;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class QuoteBook extends Activity {
    int count = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quotebook);

        RelativeLayout touch = findViewById(R.id.touch);
        final TextView quoteText = findViewById(R.id.quote);
        final TextView personText = findViewById(R.id.person);

        //Set initial prompt to tap for quotes
        quoteText.setText("Tap screen for quotes");
        personText.setText("nasjcodes");


        //List of quotes
        final ArrayList<Quote> quoteList = new ArrayList<Quote>();

        Quote quote4 = new Quote("You're more of a fun vampire. You don't suck blood, you just suck.", "Troy Barnes");
        quoteList.add(quote4);

        Quote quote1 = new Quote("Cool Beans", "Rod Kimble");
        quoteList.add(quote1);

        Quote quote2 = new Quote("How can mirrors be real if our eyes aren't real", "Jaden Smith");
        quoteList.add(quote2);

        Quote quote3 = new Quote("That's like me blaming owls for how bad I suck at analogies.", "Britta Perry");
        quoteList.add(quote3);

        Quote quote5 = new Quote("I was gonna be the first person in my family to graduate from community college. Everyone else graduated from normal college", "Troy Barnes");
        quoteList.add(quote5);

        //End quote
        Quote quote6 = new Quote("End! Tap to begin again", "nasjcodes");
        quoteList.add(quote6);


        touch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (count >= quoteList.size()) {
                    count = 0;
                }

                Quote q = quoteList.get(count);

                quoteText.setText(q.getQuote());

                personText.setText(q.getPerson());

                count = count + 1;

            }
        });
    }
}
