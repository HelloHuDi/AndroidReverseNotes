package com.tencent.p177mm.plugin.appbrand;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.MiniProgramNavigationBackResult */
public class MiniProgramNavigationBackResult implements Parcelable {
    public static final Creator<MiniProgramNavigationBackResult> CREATOR = new C189931();
    public JSONObject gQt;
    public JSONObject gQu;

    /* renamed from: com.tencent.mm.plugin.appbrand.MiniProgramNavigationBackResult$1 */
    static class C189931 implements Creator<MiniProgramNavigationBackResult> {
        C189931() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new MiniProgramNavigationBackResult[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(86791);
            MiniProgramNavigationBackResult miniProgramNavigationBackResult = new MiniProgramNavigationBackResult(parcel, (byte) 0);
            AppMethodBeat.m2505o(86791);
            return miniProgramNavigationBackResult;
        }
    }

    /* synthetic */ MiniProgramNavigationBackResult(Parcel parcel, byte b) {
        this(parcel);
    }

    /* renamed from: a */
    public static MiniProgramNavigationBackResult m64438a(JSONObject jSONObject, JSONObject jSONObject2) {
        AppMethodBeat.m2504i(86792);
        if (jSONObject == null && jSONObject2 == null) {
            AppMethodBeat.m2505o(86792);
            return null;
        }
        MiniProgramNavigationBackResult miniProgramNavigationBackResult = new MiniProgramNavigationBackResult();
        JSONObject jSONObject3 = new JSONObject();
        if (jSONObject != null) {
            jSONObject3 = jSONObject;
        }
        miniProgramNavigationBackResult.gQt = jSONObject3;
        jSONObject3 = new JSONObject();
        if (jSONObject2 != null) {
            jSONObject3 = jSONObject2;
        }
        miniProgramNavigationBackResult.gQu = jSONObject3;
        AppMethodBeat.m2505o(86792);
        return miniProgramNavigationBackResult;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        String str = null;
        AppMethodBeat.m2504i(86793);
        parcel.writeString(this.gQt == null ? null : this.gQt.toString());
        if (this.gQu != null) {
            str = this.gQu.toString();
        }
        parcel.writeString(str);
        AppMethodBeat.m2505o(86793);
    }

    private MiniProgramNavigationBackResult(Parcel parcel) {
        AppMethodBeat.m2504i(86794);
        try {
            this.gQt = new JSONObject(C5046bo.m7532bc(parcel.readString(), "{}"));
            this.gQu = new JSONObject(C5046bo.m7532bc(parcel.readString(), "{}"));
            AppMethodBeat.m2505o(86794);
        } catch (JSONException e) {
            C4990ab.m7413e("MicroMsg.AppBrand.MiniProgramNavigationBackResult", "readFromParcel, ex = %s", e);
            AppMethodBeat.m2505o(86794);
        }
    }

    static {
        AppMethodBeat.m2504i(86795);
        AppMethodBeat.m2505o(86795);
    }
}
