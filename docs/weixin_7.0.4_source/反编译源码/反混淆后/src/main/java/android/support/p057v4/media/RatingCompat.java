package android.support.p057v4.media;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

/* renamed from: android.support.v4.media.RatingCompat */
public final class RatingCompat implements Parcelable {
    public static final Creator<RatingCompat> CREATOR = new C04191();
    /* renamed from: Jf */
    private final int f16822Jf;
    /* renamed from: Jg */
    private final float f16823Jg;

    /* renamed from: android.support.v4.media.RatingCompat$1 */
    static class C04191 implements Creator<RatingCompat> {
        C04191() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new RatingCompat[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new RatingCompat(parcel.readInt(), parcel.readFloat());
        }
    }

    RatingCompat(int i, float f) {
        this.f16822Jf = i;
        this.f16823Jg = f;
    }

    public final String toString() {
        String str;
        StringBuilder append = new StringBuilder("Rating:style=").append(this.f16822Jf).append(" rating=");
        if (this.f16823Jg < 0.0f) {
            str = "unrated";
        } else {
            str = String.valueOf(this.f16823Jg);
        }
        return append.append(str).toString();
    }

    public final int describeContents() {
        return this.f16822Jf;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f16822Jf);
        parcel.writeFloat(this.f16823Jg);
    }
}
