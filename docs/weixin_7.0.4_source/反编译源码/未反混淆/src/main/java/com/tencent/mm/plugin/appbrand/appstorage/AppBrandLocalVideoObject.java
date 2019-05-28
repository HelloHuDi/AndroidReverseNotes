package com.tencent.mm.plugin.appbrand.appstorage;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

@Deprecated
public class AppBrandLocalVideoObject extends AppBrandLocalMediaObject {
    public static final Creator<AppBrandLocalVideoObject> CREATOR = new Creator<AppBrandLocalVideoObject>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new AppBrandLocalVideoObject[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.i(105360);
            AppBrandLocalVideoObject appBrandLocalVideoObject = new AppBrandLocalVideoObject(parcel, (byte) 0);
            AppMethodBeat.o(105360);
            return appBrandLocalVideoObject;
        }
    };
    public int duration;
    public int height;
    public int size;
    public int width;

    /* synthetic */ AppBrandLocalVideoObject(Parcel parcel, byte b) {
        this(parcel);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(105361);
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.duration);
        parcel.writeInt(this.size);
        parcel.writeInt(this.width);
        parcel.writeInt(this.height);
        AppMethodBeat.o(105361);
    }

    private AppBrandLocalVideoObject(Parcel parcel) {
        super(parcel);
        AppMethodBeat.i(105362);
        this.duration = parcel.readInt();
        this.size = parcel.readInt();
        this.width = parcel.readInt();
        this.height = parcel.readInt();
        AppMethodBeat.o(105362);
    }

    public String toString() {
        AppMethodBeat.i(105363);
        String str = "AppBrandLocalVideoObject{duration=" + this.duration + ", size=" + this.size + ", width=" + this.width + ", height=" + this.height + '}';
        AppMethodBeat.o(105363);
        return str;
    }

    static {
        AppMethodBeat.i(105364);
        AppMethodBeat.o(105364);
    }
}
