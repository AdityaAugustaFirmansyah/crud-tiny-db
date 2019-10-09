package com.example.crudtinydb;

import android.os.Parcel;
import android.os.Parcelable;

public class AnimeModel implements Parcelable {
    private String idAnime;
    private String titleAnime;
    private String imgAnime;

    public AnimeModel(String idAnime, String titleAnime, String imgAnime, String descriptionAnime) {
        this.idAnime = idAnime;
        this.titleAnime = titleAnime;
        this.imgAnime = imgAnime;
        this.descriptionAnime = descriptionAnime;
    }

    public String getImgAnime() {
        return imgAnime;
    }


    private String descriptionAnime;

    public String getIdAnime() {
        return idAnime;
    }

    public String getTitleAnime() {
        return titleAnime;
    }

    public String getDescriptionAnime() {
        return descriptionAnime;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.idAnime);
        dest.writeString(this.titleAnime);
        dest.writeString(this.imgAnime);
        dest.writeString(this.descriptionAnime);
    }

    protected AnimeModel(Parcel in) {
        this.idAnime = in.readString();
        this.titleAnime = in.readString();
        this.imgAnime = in.readString();
        this.descriptionAnime = in.readString();
    }

    public static final Parcelable.Creator<AnimeModel> CREATOR = new Parcelable.Creator<AnimeModel>() {
        @Override
        public AnimeModel createFromParcel(Parcel source) {
            return new AnimeModel(source);
        }

        @Override
        public AnimeModel[] newArray(int size) {
            return new AnimeModel[size];
        }
    };
}
