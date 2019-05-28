package android.support.v4.media;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public final class RatingCompat implements Parcelable {
    public static final Creator<RatingCompat> CREATOR = new Creator<RatingCompat>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new RatingCompat[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new RatingCompat(parcel.readInt(), parcel.readFloat());
        }
    };
    private final int Jf;
    private final float Jg;

    RatingCompat(int i, float f) {
        this.Jf = i;
        this.Jg = f;
    }

    public final String toString() {
        String str;
        StringBuilder append = new StringBuilder("Rating:style=").append(this.Jf).append(" rating=");
        if (this.Jg < 0.0f) {
            str = "unrated";
        } else {
            str = String.valueOf(this.Jg);
        }
        return append.append(str).toString();
    }

    public final int describeContents() {
        return this.Jf;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.Jf);
        parcel.writeFloat(this.Jg);
    }
}
