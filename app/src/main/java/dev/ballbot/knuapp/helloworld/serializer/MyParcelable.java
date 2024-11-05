package dev.ballbot.knuapp.helloworld.serializer;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class MyParcelable implements Parcelable {
    public int mData;
    public String mString;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeInt(mData);
        dest.writeString(mString);
    }

    public static final Parcelable.Creator<MyParcelable> CREATOR = new Parcelable.Creator<MyParcelable>() {

        @Override
        public MyParcelable createFromParcel(Parcel source) {
            return new MyParcelable(source);
        }

        @Override
        public MyParcelable[] newArray(int size) {
            return new MyParcelable[size];
        }
    };

    public MyParcelable(int mData, String mString) {
        this.mData = mData;
        this.mString = mString;
    }

    private MyParcelable(Parcel in) {
        mData = in.readInt();
        mString = in.readString();
    }
}
