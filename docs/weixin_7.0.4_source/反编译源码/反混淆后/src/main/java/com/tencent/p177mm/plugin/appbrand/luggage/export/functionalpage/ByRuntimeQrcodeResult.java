package com.tencent.p177mm.plugin.appbrand.luggage.export.functionalpage;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p1174aa.C41724g;
import com.tencent.p177mm.p1174aa.C41726i;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.ByRuntimeQrcodeResult */
public class ByRuntimeQrcodeResult implements Parcelable {
    public static final Creator<ByRuntimeQrcodeResult> CREATOR = new C106071();
    public String data;
    public String hgU;

    /* renamed from: com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.ByRuntimeQrcodeResult$1 */
    static class C106071 implements Creator<ByRuntimeQrcodeResult> {
        C106071() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new ByRuntimeQrcodeResult[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(132113);
            ByRuntimeQrcodeResult byRuntimeQrcodeResult = new ByRuntimeQrcodeResult(parcel);
            AppMethodBeat.m2505o(132113);
            return byRuntimeQrcodeResult;
        }
    }

    public ByRuntimeQrcodeResult(String str, String str2) {
        this.data = str;
        this.hgU = str2;
    }

    public final String aHQ() {
        AppMethodBeat.m2504i(132114);
        String c41726i;
        try {
            c41726i = new C41726i().mo67475g("transitiveData", this.hgU).mo67475g("data", this.data).toString();
            AppMethodBeat.m2505o(132114);
            return c41726i;
        } catch (C41724g e) {
            C4990ab.m7413e("MicroMsg.AppBrand.Functional.ByRuntimeQrcodeResult", "toJsonString e = %s", e);
            c41726i = "{}";
            AppMethodBeat.m2505o(132114);
            return c41726i;
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(132115);
        parcel.writeString(this.data);
        parcel.writeString(this.hgU);
        AppMethodBeat.m2505o(132115);
    }

    protected ByRuntimeQrcodeResult(Parcel parcel) {
        AppMethodBeat.m2504i(132116);
        this.data = parcel.readString();
        this.hgU = parcel.readString();
        AppMethodBeat.m2505o(132116);
    }

    static {
        AppMethodBeat.m2504i(132117);
        AppMethodBeat.m2505o(132117);
    }
}
