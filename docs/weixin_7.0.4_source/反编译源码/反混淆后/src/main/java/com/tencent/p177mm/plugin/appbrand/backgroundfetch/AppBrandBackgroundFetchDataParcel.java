package com.tencent.p177mm.plugin.appbrand.backgroundfetch;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.plugin.appbrand.backgroundfetch.AppBrandBackgroundFetchDataParcel */
public class AppBrandBackgroundFetchDataParcel implements Parcelable {
    public static final Creator<AppBrandBackgroundFetchDataParcel> CREATOR = new C101451();
    public String data;
    public int hca;
    public String path;
    public String query;
    public int scene;
    public long updateTime;
    public String username;

    /* renamed from: com.tencent.mm.plugin.appbrand.backgroundfetch.AppBrandBackgroundFetchDataParcel$1 */
    static class C101451 implements Creator<AppBrandBackgroundFetchDataParcel> {
        C101451() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new AppBrandBackgroundFetchDataParcel[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(129766);
            AppBrandBackgroundFetchDataParcel appBrandBackgroundFetchDataParcel = new AppBrandBackgroundFetchDataParcel(parcel);
            AppMethodBeat.m2505o(129766);
            return appBrandBackgroundFetchDataParcel;
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(129767);
        parcel.writeString(this.username);
        parcel.writeInt(this.hca);
        parcel.writeString(this.path);
        parcel.writeString(this.query);
        parcel.writeString(this.data);
        parcel.writeInt(this.scene);
        parcel.writeLong(this.updateTime);
        AppMethodBeat.m2505o(129767);
    }

    protected AppBrandBackgroundFetchDataParcel(Parcel parcel) {
        AppMethodBeat.m2504i(129768);
        this.username = parcel.readString();
        this.hca = parcel.readInt();
        this.path = parcel.readString();
        this.query = parcel.readString();
        this.data = parcel.readString();
        this.scene = parcel.readInt();
        this.updateTime = parcel.readLong();
        AppMethodBeat.m2505o(129768);
    }

    static {
        AppMethodBeat.m2504i(129769);
        AppMethodBeat.m2505o(129769);
    }
}
