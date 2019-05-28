package com.tencent.p177mm.plugin.wepkg.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.wepkg.p1076b.C41334e;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.wepkg.model.WepkgVersion */
public class WepkgVersion implements Parcelable {
    public static final Creator<WepkgVersion> CREATOR = new C357621();
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

    /* renamed from: com.tencent.mm.plugin.wepkg.model.WepkgVersion$1 */
    static class C357621 implements Creator<WepkgVersion> {
        C357621() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new WepkgVersion[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(63601);
            WepkgVersion wepkgVersion = new WepkgVersion(parcel);
            AppMethodBeat.m2505o(63601);
            return wepkgVersion;
        }
    }

    public WepkgVersion(Parcel parcel) {
        boolean z;
        boolean z2 = true;
        AppMethodBeat.m2504i(63602);
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
        AppMethodBeat.m2505o(63602);
    }

    /* renamed from: a */
    public final void mo63810a(C41334e c41334e) {
        if (c41334e != null) {
            this.eBS = c41334e.field_pkgId;
            this.appId = c41334e.field_appId;
            this.version = c41334e.field_version;
            this.gSP = c41334e.field_pkgPath;
            this.uXG = c41334e.field_disableWvCache;
            this.uXH = c41334e.field_clearPkgTime;
            this.uXI = c41334e.field_checkIntervalTime;
            this.uXJ = c41334e.field_packMethod;
            this.cSx = c41334e.field_domain;
            this.cvZ = c41334e.field_md5;
            this.downloadUrl = c41334e.field_downloadUrl;
            this.uXK = c41334e.field_pkgSize;
            this.uWQ = c41334e.field_downloadNetType;
            this.uXL = c41334e.field_nextCheckTime;
            this.createTime = c41334e.field_createTime;
            this.charset = c41334e.field_charset;
            this.uXM = c41334e.field_bigPackageReady;
            this.uXN = c41334e.field_preloadFilesReady;
            this.uXO = c41334e.field_preloadFilesAtomic;
            this.uXP = c41334e.field_totalDownloadCount;
            this.cTb = c41334e.field_downloadTriggerType;
        }
    }

    public final JSONObject dgC() {
        AppMethodBeat.m2504i(63603);
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
        AppMethodBeat.m2505o(63603);
        return jSONObject;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2;
        int i3 = 1;
        AppMethodBeat.m2504i(63604);
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
        AppMethodBeat.m2505o(63604);
    }

    static {
        AppMethodBeat.m2504i(63605);
        AppMethodBeat.m2505o(63605);
    }
}
