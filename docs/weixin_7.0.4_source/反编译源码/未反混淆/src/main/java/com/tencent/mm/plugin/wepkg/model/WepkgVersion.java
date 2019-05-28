package com.tencent.mm.plugin.wepkg.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wepkg.b.e;
import org.json.JSONException;
import org.json.JSONObject;

public class WepkgVersion implements Parcelable {
    public static final Creator<WepkgVersion> CREATOR = new Creator<WepkgVersion>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new WepkgVersion[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.i(63601);
            WepkgVersion wepkgVersion = new WepkgVersion(parcel);
            AppMethodBeat.o(63601);
            return wepkgVersion;
        }
    };
    public String appId;
    public String cSx;
    public int cTb;
    public String charset;
    public long createTime;
    public String cvZ;
    public String downloadUrl;
    public String eBS;
    public String gSP;
    public int uWQ;
    public boolean uXG;
    public long uXH;
    public long uXI;
    public int uXJ;
    public int uXK;
    public long uXL;
    public boolean uXM;
    public boolean uXN;
    public boolean uXO;
    public int uXP;
    public String version;

    public WepkgVersion(Parcel parcel) {
        boolean z;
        boolean z2 = true;
        AppMethodBeat.i(63602);
        this.eBS = parcel.readString();
        this.appId = parcel.readString();
        this.version = parcel.readString();
        this.gSP = parcel.readString();
        this.uXG = parcel.readByte() != (byte) 0;
        this.uXH = parcel.readLong();
        this.uXI = parcel.readLong();
        this.uXJ = parcel.readInt();
        this.cSx = parcel.readString();
        this.cvZ = parcel.readString();
        this.downloadUrl = parcel.readString();
        this.uXK = parcel.readInt();
        this.uWQ = parcel.readInt();
        this.uXL = parcel.readLong();
        this.createTime = parcel.readLong();
        this.charset = parcel.readString();
        this.uXM = parcel.readByte() != (byte) 0;
        if (parcel.readByte() != (byte) 0) {
            z = true;
        } else {
            z = false;
        }
        this.uXN = z;
        if (parcel.readByte() == (byte) 0) {
            z2 = false;
        }
        this.uXO = z2;
        this.uXP = parcel.readInt();
        this.cTb = parcel.readInt();
        AppMethodBeat.o(63602);
    }

    public final void a(e eVar) {
        if (eVar != null) {
            this.eBS = eVar.field_pkgId;
            this.appId = eVar.field_appId;
            this.version = eVar.field_version;
            this.gSP = eVar.field_pkgPath;
            this.uXG = eVar.field_disableWvCache;
            this.uXH = eVar.field_clearPkgTime;
            this.uXI = eVar.field_checkIntervalTime;
            this.uXJ = eVar.field_packMethod;
            this.cSx = eVar.field_domain;
            this.cvZ = eVar.field_md5;
            this.downloadUrl = eVar.field_downloadUrl;
            this.uXK = eVar.field_pkgSize;
            this.uWQ = eVar.field_downloadNetType;
            this.uXL = eVar.field_nextCheckTime;
            this.createTime = eVar.field_createTime;
            this.charset = eVar.field_charset;
            this.uXM = eVar.field_bigPackageReady;
            this.uXN = eVar.field_preloadFilesReady;
            this.uXO = eVar.field_preloadFilesAtomic;
            this.uXP = eVar.field_totalDownloadCount;
            this.cTb = eVar.field_downloadTriggerType;
        }
    }

    public final JSONObject dgC() {
        AppMethodBeat.i(63603);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("appId", this.appId);
            jSONObject.put("version", this.version);
            jSONObject.put("pkgPath", this.gSP);
            jSONObject.put("disableWvCache", this.uXG);
            jSONObject.put("clearPkgTime", this.uXH);
            jSONObject.put("checkIntervalTime", this.uXI);
            jSONObject.put("packMethod", this.uXJ);
            jSONObject.put("domain", this.cSx);
            jSONObject.put("md5", this.cvZ);
            jSONObject.put("downloadUrl", this.downloadUrl);
            jSONObject.put("pkgSize", this.uXK);
            jSONObject.put("downloadNetType", this.uWQ);
            jSONObject.put("nextCheckTime", this.uXL);
            jSONObject.put("charset", this.charset);
            jSONObject.put("bigPackageReady", this.uXM);
            jSONObject.put("preloadFilesReady", this.uXN);
            jSONObject.put("preloadFilesAtomic", this.uXO);
            jSONObject.put("totalDownloadCount", this.uXP);
            jSONObject.put("downloadTriggerType", this.cTb);
        } catch (JSONException e) {
        }
        AppMethodBeat.o(63603);
        return jSONObject;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2;
        int i3 = 1;
        AppMethodBeat.i(63604);
        parcel.writeString(this.eBS);
        parcel.writeString(this.appId);
        parcel.writeString(this.version);
        parcel.writeString(this.gSP);
        parcel.writeByte((byte) (this.uXG ? 1 : 0));
        parcel.writeLong(this.uXH);
        parcel.writeLong(this.uXI);
        parcel.writeInt(this.uXJ);
        parcel.writeString(this.cSx);
        parcel.writeString(this.cvZ);
        parcel.writeString(this.downloadUrl);
        parcel.writeInt(this.uXK);
        parcel.writeInt(this.uWQ);
        parcel.writeLong(this.uXL);
        parcel.writeLong(this.createTime);
        parcel.writeString(this.charset);
        parcel.writeByte((byte) (this.uXM ? 1 : 0));
        if (this.uXN) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        if (!this.uXO) {
            i3 = 0;
        }
        parcel.writeByte((byte) i3);
        parcel.writeInt(this.uXP);
        parcel.writeInt(this.cTb);
        AppMethodBeat.o(63604);
    }

    static {
        AppMethodBeat.i(63605);
        AppMethodBeat.o(63605);
    }
}
