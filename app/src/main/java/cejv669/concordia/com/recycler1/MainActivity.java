package cejv669.concordia.com.recycler1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Book> bookList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recycler = findViewById(R.id.recycler1);
        BookAdapter ba = new BookAdapter(bookList);

        RecyclerView.LayoutManager mLayoutManager = new
                LinearLayoutManager(getApplicationContext());
        recycler.setLayoutManager(mLayoutManager);
        recycler.setItemAnimator(new DefaultItemAnimator());

        bookList.addAll(generateData());

        recycler.setAdapter(ba);
    }

    protected ArrayList<Book> generateData()
    {
        ArrayList<Book> alb = new ArrayList<>();

        Book b;

        b = new Book("Dune", 450, 1234, true);
        alb.add(b);

        b = new Book("Star Wars", 200, 2345, false);
        alb.add(b);

        b = new Book("Star Trek", 225, 3456, false);
        alb.add(b);

        return alb;
    }
}
