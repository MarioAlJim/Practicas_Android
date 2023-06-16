package com.wolf.booksrating;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;

public class Book implements Parcelable {

    private String title;
    private float rating;
    private String commet;
    private String author;

    protected Book(Parcel in) {
        title = in.readString();
        rating = in.readFloat();
        commet = in.readString();
        author = in.readString();
    }

    public static final Creator<Book> CREATOR = new Creator<Book>() {
        @Override
        public Book createFromParcel(Parcel in) {
            return new Book(in);
        }

        @Override
        public Book[] newArray(int size) {
            return new Book[size];
        }
    };

    public Book(String title, float rating, String commet, String author) {
        this.title = title;
        this.rating = rating;
        this.commet = commet;
        this.author = author;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public String getCommet() {
        return commet;
    }

    public void setCommet(String commet) {
        this.commet = commet;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeString(title);
        parcel.writeString(author);
        parcel.writeString(commet);
        parcel.writeFloat(rating);
    }
}
