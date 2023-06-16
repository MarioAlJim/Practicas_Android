package com.wolf.booksrating;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.Toast;

import com.wolf.booksrating.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private Bitmap takenPhotoBitmap;

    public MainActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.saveButton.setOnClickListener(view -> {
            String title = binding.bookTitle.getText().toString();
            String comment = binding.bookComment.getText().toString();
            String author = binding.bookComment.getText().toString();
            float rating = binding.ratingBook.getRating();
            openDetailActivity(title, rating, comment, author);
        });

        binding.bookImage.setOnClickListener(view -> {
            openCamera();
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == Activity.RESULT_OK && requestCode == 1000) {
            if(data != null) {
                takenPhotoBitmap = data.getExtras().getParcelable("data");
                binding.bookImage.setImageBitmap(takenPhotoBitmap);
            } else {
                Toast.makeText(this, "Error taking photo", Toast.LENGTH_LONG);
            }
        }
    }


    private void openDetailActivity(String title, float rating, String comment, String author) {
        Book book = new Book(title, rating, comment, author);
        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra("bookkey", book);
        intent.putExtra("bitmapkey", takenPhotoBitmap);
        startActivity(intent);
    }

    private void openCamera(){
        Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(cameraIntent, 1000);
    }
}