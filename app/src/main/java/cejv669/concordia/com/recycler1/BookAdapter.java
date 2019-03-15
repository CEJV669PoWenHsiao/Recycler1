package cejv669.concordia.com.recycler1;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.util.List;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.MyViewHolder> {

    List<Book> bookList;

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name, pages, isbn;
        Button btnCheckout;
        ToggleButton btnToggleLent;
        MyViewHolder(View view) {
            super(view);

            name = view.findViewById(R.id.txtName);
            pages = view.findViewById(R.id.txtPages);
            isbn = view.findViewById(R.id.txtISBN);
            btnCheckout = view.findViewById(R.id.btnCheckout);
            btnToggleLent = view.findViewById(R.id.btnToggleLent);
        }
    }

    BookAdapter(List<Book> bookList) {
        this.bookList = bookList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, final int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).
                inflate(R.layout.book_row, viewGroup, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, final int i) {
        final Book book = bookList.get(i);

        myViewHolder.name.setText(book.getName());
        myViewHolder.isbn.setText(Integer.toString(book.getISBN()));
        myViewHolder.pages.setText(Integer.toString(book.getPages()));
        myViewHolder.btnToggleLent.setChecked(book.isLent());

        myViewHolder.btnCheckout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                book.setLent(!book.isLent());

                bookList.set(i, book);

                Toast.makeText(v.getContext(), "Value Changed",
                        Toast.LENGTH_LONG).show();

                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return this.bookList.size();
    }

}
