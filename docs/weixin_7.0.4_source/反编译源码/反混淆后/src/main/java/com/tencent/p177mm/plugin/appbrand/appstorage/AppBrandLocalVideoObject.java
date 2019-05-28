package com.tencent.p177mm.plugin.appbrand.appstorage;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

@Deprecated
/* renamed from: com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalVideoObject */
public class AppBrandLocalVideoObject extends AppBrandLocalMediaObject {
    public static final Creator<AppBrandLocalVideoObject> CREATOR = new C331011();
    public int duration;
    public int height;
    public int size;
    public int width;

    /* renamed from: com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalVideoObject$1 */
    static class C331011 implements Creator<AppBrandLocalVideoObject> {
        C331011() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new AppBrandLocalVideoObject[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(105360);
            AppBrandLocalVideoObject appBrandLocalVideoObject = new AppBrandLocalVideoObject(parcel, (byte) 0);
            AppMethodBeat.m2505o(105360);
            return appBrandLocalVideoObject;
        }
    }

    /* synthetic */ AppBrandLocalVideoObject(Parcel parcel, byte b) {
        this(parcel);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(105361);
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.duration);
        parcel.writeInt(this.size);
        parcel.writeInt(this.width);
        parcel.writeInt(this.height);
        AppMethodBeat.m2505o(105361);
    }

    private AppBrandLocalVideoObject(Parcel parcel) {
        super(parcel);
        AppMethodBeat.m2504i(105362);
        this.duration = parcel.readInt();
        this.size = parcel.readInt();
        this.width = parcel.readInt();
        this.height = parcel.readInt();
        AppMethodBeat.m2505o(105362);
    }

    public String toString() {
        AppMethodBeat.m2504i(105363);
        String str = "AppBrandLocalVideoObject{duration=" + this.duration + ", size=" + this.size + ", width=" + this.width + ", height=" + this.height + '}';
        AppMethodBeat.m2505o(105363);
        return str;
    }

    static {
        AppMethodBeat.m2504i(105364);
        AppMethodBeat.m2505o(105364);
    }
}
