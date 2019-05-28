package com.tencent.p177mm.plugin.appbrand.jsapi.appdownload;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.appdownload.AppbrandDownloadState */
public class AppbrandDownloadState implements Parcelable {
    public static final Creator<AppbrandDownloadState> CREATOR = new C102981();
    public String appId;
    public long crZ;
    public long hzC;
    public long progress;
    public String state;

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.appdownload.AppbrandDownloadState$1 */
    static class C102981 implements Creator<AppbrandDownloadState> {
        C102981() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new AppbrandDownloadState[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(130633);
            AppbrandDownloadState appbrandDownloadState = new AppbrandDownloadState(parcel, (byte) 0);
            AppMethodBeat.m2505o(130633);
            return appbrandDownloadState;
        }
    }

    /* synthetic */ AppbrandDownloadState(Parcel parcel, byte b) {
        this(parcel);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(130634);
        parcel.writeString(this.state);
        parcel.writeLong(this.crZ);
        parcel.writeString(this.appId);
        parcel.writeLong(this.progress);
        parcel.writeLong(this.hzC);
        AppMethodBeat.m2505o(130634);
    }

    private AppbrandDownloadState(Parcel parcel) {
        AppMethodBeat.m2504i(130635);
        this.state = parcel.readString();
        this.crZ = parcel.readLong();
        this.appId = parcel.readString();
        this.progress = parcel.readLong();
        this.hzC = parcel.readLong();
        AppMethodBeat.m2505o(130635);
    }

    static {
        AppMethodBeat.m2504i(130637);
        AppMethodBeat.m2505o(130637);
    }

    public final JSONObject aCq() {
        AppMethodBeat.m2504i(130636);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("state", this.state);
            jSONObject.put("downloadId", this.crZ);
            jSONObject.put("appId", this.appId);
            jSONObject.put("progress", this.progress);
            jSONObject.put("taskSize", this.hzC);
        } catch (JSONException e) {
            C4990ab.m7412e("MicroMsg.AppbrandDownloadState", "toJsonObject: " + e.getMessage());
        }
        AppMethodBeat.m2505o(130636);
        return jSONObject;
    }
}
