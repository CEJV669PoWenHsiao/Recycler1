package cejv669.concordia.com.recycler1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Book> bookList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recycler = findViewById(R.id.recycler1);
        final BookAdapter ba = new BookAdapter(bookList);

        RecyclerView.LayoutManager mLayoutManager = new
                LinearLayoutManager(getApplicationContext());
        recycler.setLayoutManager(mLayoutManager);
        recycler.setItemAnimator(new DefaultItemAnimator());


        // OPTIONAL
        recycler.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));

        final Button btnAddBook = findViewById(R.id.btnAdd);

        btnAddBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText txtAddISBN = findViewById(R.id.txtAddISBN);
                EditText txtAddBookName = findViewById(R.id.txtAddBookName);
                EditText txtAddPages = findViewById(R.id.txtAddPages);
                ToggleButton btnToggle = findViewById(R.id.btnToggle);

                Book newBook = new Book(txtAddBookName.getText().toString(),
                    Integer.valueOf(txtAddPages.getText().toString()),
                    Integer.valueOf(txtAddISBN.getText().toString()),
                    btnToggle.isChecked());

                bookList.add(newBook);
                // need to have notifyDateChanged, otherwise it update the list after close the enter pad

                ba.notifyDataSetChanged();

                Toast.makeText(getApplicationContext(), "Record Added", Toast.LENGTH_LONG).show();

            }
        });



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
