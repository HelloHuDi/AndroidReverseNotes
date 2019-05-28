package com.tencent.mm.plugin.appbrand;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import org.json.JSONException;
import org.json.JSONObject;

public class MiniProgramNavigationBackResult implements Parcelable {
    public static final Creator<MiniProgramNavigationBackResult> CREATOR = new Creator<MiniProgramNavigationBackResult>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new MiniProgramNavigationBackResult[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.i(86791);
            MiniProgramNavigationBackResult miniProgramNavigationBackResult = new MiniProgramNavigationBackResult(parcel, (byte) 0);
            AppMethodBeat.o(86791);
            return miniProgramNavigationBackResult;
        }
    };
    public JSONObject gQt;
    public JSONObject gQu;

    /* synthetic */ MiniProgramNavigationBackResult(Parcel parcel, byte b) {
        this(parcel);
    }

    public static MiniProgramNavigationBackResult a(JSONObject jSONObject, JSONObject jSONObject2) {
        AppMethodBeat.i(86792);
        if (jSONObject == null && jSONObject2 == null) {
            AppMethodBeat.o(86792);
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
        AppMethodBeat.o(86792);
        return miniProgramNavigationBackResult;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        String str = null;
        AppMethodBeat.i(86793);
        parcel.writeString(this.gQt == null ? null : this.gQt.toString());
        if (this.gQu != null) {
            str = this.gQu.toString();
        }
        parcel.writeString(str);
        AppMethodBeat.o(86793);
    }

    private MiniProgramNavigationBackResult(Parcel parcel) {
        AppMethodBeat.i(86794);
        try {
            this.gQt = new JSONObject(bo.bc(parcel.readString(), "{}"));
            this.gQu = new JSONObject(bo.bc(parcel.readString(), "{}"));
            AppMethodBeat.o(86794);
        } catch (JSONException e) {
            ab.e("MicroMsg.AppBrand.MiniProgramNavigationBackResult", "readFromParcel, ex = %s", e);
            AppMethodBeat.o(86794);
        }
    }

    static {
        AppMethodBeat.i(86795);
        AppMethodBeat.o(86795);
    }
}
