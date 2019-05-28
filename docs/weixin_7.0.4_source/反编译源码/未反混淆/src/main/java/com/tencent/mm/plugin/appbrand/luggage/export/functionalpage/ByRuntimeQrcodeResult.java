package com.tencent.mm.plugin.appbrand.luggage.export.functionalpage;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aa.g;
import com.tencent.mm.aa.i;
import com.tencent.mm.sdk.platformtools.ab;

public class ByRuntimeQrcodeResult implements Parcelable {
    public static final Creator<ByRuntimeQrcodeResult> CREATOR = new Creator<ByRuntimeQrcodeResult>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new ByRuntimeQrcodeResult[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.i(132113);
            ByRuntimeQrcodeResult byRuntimeQrcodeResult = new ByRuntimeQrcodeResult(parcel);
            AppMethodBeat.o(132113);
            return byRuntimeQrcodeResult;
        }
    };
    public String data;
    public String hgU;

    public ByRuntimeQrcodeResult(String str, String str2) {
        this.data = str;
        this.hgU = str2;
    }

    public final String aHQ() {
        AppMethodBeat.i(132114);
        String iVar;
        try {
            iVar = new i().g("transitiveData", this.hgU).g("data", this.data).toString();
            AppMethodBeat.o(132114);
            return iVar;
        } catch (g e) {
            ab.e("MicroMsg.AppBrand.Functional.ByRuntimeQrcodeResult", "toJsonString e = %s", e);
            iVar = "{}";
            AppMethodBeat.o(132114);
            return iVar;
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(132115);
        parcel.writeString(this.data);
        parcel.writeString(this.hgU);
        AppMethodBeat.o(132115);
    }

    protected ByRuntimeQrcodeResult(Parcel parcel) {
        AppMethodBeat.i(132116);
        this.data = parcel.readString();
        this.hgU = parcel.readString();
        AppMethodBeat.o(132116);
    }

    static {
        AppMethodBeat.i(132117);
        AppMethodBeat.o(132117);
    }
}
