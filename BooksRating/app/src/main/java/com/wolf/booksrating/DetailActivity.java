package com.wolf.booksrating;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;

import com.wolf.booksrating.databinding.ActivityDetailBinding;
import com.wolf.booksrating.databinding.ActivityMainBinding;

public class DetailActivity extends AppCompatActivity {

    private ActivityDetailBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Bundle extras = getIntent().getExtras();
        Book reatedBook = extras.getParcelable("bookkey");
        Bitmap bitmap = extras.getParcelable("bitmapkey");

        if(bitmap != null) {
            binding.imageView.setImageBitmap(bitmap);
        }
        binding.setRatedbook(reatedBook);
    }
}