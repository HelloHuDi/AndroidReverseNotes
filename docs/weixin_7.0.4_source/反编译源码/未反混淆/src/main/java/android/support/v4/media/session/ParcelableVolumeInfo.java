package android.support.v4.media.session;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class ParcelableVolumeInfo implements Parcelable {
    public static final Creator<ParcelableVolumeInfo> CREATOR = new Creator<ParcelableVolumeInfo>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new ParcelableVolumeInfo[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new ParcelableVolumeInfo(parcel);
        }
    };
    public int JH;
    public int JI;
    public int JJ;
    public int JK;
    public int JL;

    public ParcelableVolumeInfo(Parcel parcel) {
        this.JH = parcel.readInt();
        this.JJ = parcel.readInt();
        this.JK = parcel.readInt();
        this.JL = parcel.readInt();
        this.JI = parcel.readInt();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.JH);
        parcel.writeInt(this.JJ);
        parcel.writeInt(this.JK);
        parcel.writeInt(this.JL);
        parcel.writeInt(this.JI);
    }
}
