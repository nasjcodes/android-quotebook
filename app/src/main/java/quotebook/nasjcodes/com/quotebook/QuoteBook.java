package quotebook.nasjcodes.com.quotebook;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class QuoteBook extends Activity {
    int count = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quotebook);
        getActionBar().setTitle(R.string.title);

        RelativeLayout touch = findViewById(R.id.touch);
        final TextView quoteText = findViewById(R.id.quote);
        final TextView personText = findViewById(R.id.person);

        //Get end quote
        final Quote endQuote = stringToQuote(getString(R.string.end_quote));

        //List of quotes
        final ArrayList<Quote> quoteList = new ArrayList<Quote>();
        String[] texts = getResources().getStringArray(R.array.quotes_array);
        addQuotes(quoteList, texts);



        touch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (count < quoteList.size()) {

                    setQuote(quoteList.get(count), quoteText, personText);
                    count++;

                } else {

                    setQuote(endQuote, quoteText, personText);
                    count = 0;

                }

            }
        });
    }

    private Quote stringToQuote(String text) {
        String[] splitQuote = text.split("\\|");

        return new Quote(splitQuote[0], splitQuote[1]);
    }

    private void setQuote(Quote quote, TextView quoteText, TextView personText) {
        quoteText.setText(quote.getQuote());
        personText.setText(quote.getPerson());
    }

    private void addQuotes(List<Quote> quoteList, String[] texts) {

        for(String text : texts) {
            quoteList.add(stringToQuote(text));
        }

    }
}
