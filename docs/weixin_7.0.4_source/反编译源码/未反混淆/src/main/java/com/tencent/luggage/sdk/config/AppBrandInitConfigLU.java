package com.tencent.luggage.sdk.config;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.luggage.sdk.launching.OnWXAppResultXPCWrapper;
import com.tencent.luggage.sdk.launching.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.launching.params.AppBrandWeishiParams;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.sdk.platformtools.bo;
import org.json.JSONException;
import org.json.JSONObject;

public class AppBrandInitConfigLU extends AppBrandInitConfig {
    public static final Creator<AppBrandInitConfigLU> CREATOR = new Creator<AppBrandInitConfigLU>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new AppBrandInitConfigLU[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.i(101609);
            AppBrandInitConfigLU appBrandInitConfigLU = new AppBrandInitConfigLU(parcel);
            AppMethodBeat.o(101609);
            return appBrandInitConfigLU;
        }
    };
    public int axy;
    protected String bQd;
    public int bQe;
    public boolean bQf;
    public boolean bQg;
    public String bQh;
    public String bQi;
    public final AppBrandWeishiParams bQj;
    public String bQk;
    public int bQl;
    public b<?> bQm;
    public transient AppBrandStatObject bQn;
    public String extInfo;
    public long startTime;
    public int uin;
    public String username;

    public /* synthetic */ Object clone() {
        AppMethodBeat.i(101619);
        AppBrandInitConfigLU xC = xC();
        AppMethodBeat.o(101619);
        return xC;
    }

    public final void resetSession() {
        AppMethodBeat.i(101610);
        this.bQd = "SessionId@" + hashCode() + "#" + bo.anU();
        AppMethodBeat.o(101610);
    }

    public final AppBrandStatObject xx() {
        return this.bQn;
    }

    public boolean xy() {
        return this.bQe == 4;
    }

    public final String xz() {
        return this.bQd;
    }

    public final JSONObject xA() {
        AppMethodBeat.i(101611);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("shareKey", this.bQi);
            jSONObject.put("shareName", this.bQh);
            if (jSONObject.length() == 0) {
                AppMethodBeat.o(101611);
                return null;
            }
            AppMethodBeat.o(101611);
            return jSONObject;
        } catch (JSONException e) {
            AppMethodBeat.o(101611);
            return null;
        }
    }

    public final JSONObject xB() {
        AppMethodBeat.i(101612);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("appId", this.appId);
            jSONObject.put("nickname", this.cwz);
            jSONObject.put("icon", this.iconUrl);
            if (jSONObject.length() == 0) {
                AppMethodBeat.o(101612);
                return null;
            }
            AppMethodBeat.o(101612);
            return jSONObject;
        } catch (JSONException e) {
            AppMethodBeat.o(101612);
            return null;
        }
    }

    public AppBrandInitConfigLU() {
        AppMethodBeat.i(101613);
        this.bQj = new AppBrandWeishiParams();
        AppMethodBeat.o(101613);
    }

    protected AppBrandInitConfigLU(Parcel parcel) {
        boolean z = true;
        super(parcel);
        AppMethodBeat.i(101614);
        this.bQd = parcel.readString();
        this.username = parcel.readString();
        this.bQh = parcel.readString();
        this.bQi = parcel.readString();
        this.bQj = (AppBrandWeishiParams) parcel.readParcelable(AppBrandWeishiParams.class.getClassLoader());
        this.bQe = parcel.readInt();
        this.bQf = parcel.readByte() != (byte) 0;
        if (parcel.readByte() == (byte) 0) {
            z = false;
        }
        this.bQg = z;
        this.extInfo = parcel.readString();
        this.bQk = parcel.readString();
        this.startTime = parcel.readLong();
        this.axy = parcel.readInt();
        this.bQl = parcel.readInt();
        this.uin = parcel.readInt();
        this.bQm = OnWXAppResultXPCWrapper.b(parcel);
        AppMethodBeat.o(101614);
    }

    public String toString() {
        AppMethodBeat.i(101615);
        String str = "AppBrandInitConfigLU {visitingSessionId='" + this.bQd + '\'' + ", username='" + this.username + '\'' + ", appId='" + this.appId + '\'' + ", brandName='" + this.cwz + '\'' + ", debugType=" + this.gVs + ", orientation='" + this.hfh + '\'' + ", enterPath='" + this.hgC + '\'' + ", shareName='" + this.bQh + '\'' + ", shareKey='" + this.bQi + '\'' + ", weishiParams=" + this.bQj + ", startTime=" + this.startTime + ", referrer=" + this.hgF + ", extInfo=" + this.extInfo + ", appVersion=" + this.axy + '}';
        AppMethodBeat.o(101615);
        return str;
    }

    public AppBrandInitConfigLU xC() {
        AppMethodBeat.i(101616);
        Parcel xD = xD();
        AppBrandInitConfigLU appBrandInitConfigLU = new AppBrandInitConfigLU(xD);
        xD.recycle();
        AppMethodBeat.o(101616);
        return appBrandInitConfigLU;
    }

    public Parcel xD() {
        AppMethodBeat.i(101617);
        Parcel obtain = Parcel.obtain();
        obtain.setDataPosition(0);
        writeToParcel(obtain, 0);
        obtain.setDataPosition(0);
        AppMethodBeat.o(101617);
        return obtain;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        byte b = (byte) 1;
        AppMethodBeat.i(101618);
        super.writeToParcel(parcel, i);
        parcel.writeString(this.bQd);
        parcel.writeString(this.username);
        parcel.writeString(this.bQh);
        parcel.writeString(this.bQi);
        parcel.writeParcelable(this.bQj, i);
        parcel.writeInt(this.bQe);
        parcel.writeByte(this.bQf ? (byte) 1 : (byte) 0);
        if (!this.bQg) {
            b = (byte) 0;
        }
        parcel.writeByte(b);
        parcel.writeString(this.extInfo);
        parcel.writeString(this.bQk);
        parcel.writeLong(this.startTime);
        parcel.writeInt(this.axy);
        parcel.writeInt(this.bQl);
        parcel.writeInt(this.uin);
        OnWXAppResultXPCWrapper.a(this.bQm, parcel);
        AppMethodBeat.o(101618);
    }

    static {
        AppMethodBeat.i(101620);
        AppMethodBeat.o(101620);
    }
}
