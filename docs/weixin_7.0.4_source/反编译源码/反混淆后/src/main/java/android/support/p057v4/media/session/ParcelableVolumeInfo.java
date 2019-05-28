package android.support.p057v4.media.session;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

/* renamed from: android.support.v4.media.session.ParcelableVolumeInfo */
public class ParcelableVolumeInfo implements Parcelable {
    public static final Creator<ParcelableVolumeInfo> CREATOR = new C415121();
    /* renamed from: JH */
    public int f16824JH;
    /* renamed from: JI */
    public int f16825JI;
    /* renamed from: JJ */
    public int f16826JJ;
    /* renamed from: JK */
    public int f16827JK;
    /* renamed from: JL */
    public int f16828JL;

    /* renamed from: android.support.v4.media.session.ParcelableVolumeInfo$1 */
    static class C415121 implements Creator<ParcelableVolumeInfo> {
        C415121() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new ParcelableVolumeInfo[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new ParcelableVolumeInfo(parcel);
        }
    }

    public ParcelableVolumeInfo(Parcel parcel) {
        this.f16824JH = parcel.readInt();
        this.f16826JJ = parcel.readInt();
        this.f16827JK = parcel.readInt();
        this.f16828JL = parcel.readInt();
        this.f16825JI = parcel.readInt();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f16824JH);
        parcel.writeInt(this.f16826JJ);
        parcel.writeInt(this.f16827JK);
        parcel.writeInt(this.f16828JL);
        parcel.writeInt(this.f16825JI);
    }
}
