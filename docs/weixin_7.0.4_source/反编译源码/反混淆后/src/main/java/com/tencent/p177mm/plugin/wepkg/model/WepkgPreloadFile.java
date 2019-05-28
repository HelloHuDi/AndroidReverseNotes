package com.tencent.p177mm.plugin.wepkg.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.wepkg.p1076b.C14798c;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.wepkg.model.WepkgPreloadFile */
public class WepkgPreloadFile implements Parcelable {
    public static final Creator<WepkgPreloadFile> CREATOR = new C357611();
    public long createTime;
    public String cvZ;
    public String downloadUrl;
    public String eBS;
    public String filePath;
    public String key;
    public String mimeType;
    public int size;
    public int uWQ;
    public String uXe;
    public boolean uXr;
    public String version;

    /* renamed from: com.tencent.mm.plugin.wepkg.model.WepkgPreloadFile$1 */
    static class C357611 implements Creator<WepkgPreloadFile> {
        C357611() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new WepkgPreloadFile[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(63561);
            WepkgPreloadFile wepkgPreloadFile = new WepkgPreloadFile(parcel);
            AppMethodBeat.m2505o(63561);
            return wepkgPreloadFile;
        }
    }

    public WepkgPreloadFile(Parcel parcel) {
        AppMethodBeat.m2504i(63562);
        this.key = parcel.readString();
        this.eBS = parcel.readString();
        this.version = parcel.readString();
        this.filePath = parcel.readString();
        this.uXe = parcel.readString();
        this.mimeType = parcel.readString();
        this.cvZ = parcel.readString();
        this.downloadUrl = parcel.readString();
        this.size = parcel.readInt();
        this.uWQ = parcel.readInt();
        this.uXr = parcel.readByte() != (byte) 0;
        this.createTime = parcel.readLong();
        AppMethodBeat.m2505o(63562);
    }

    /* renamed from: a */
    public final void mo69721a(C14798c c14798c) {
        if (c14798c != null) {
            this.key = c14798c.field_key;
            this.eBS = c14798c.field_pkgId;
            this.version = c14798c.field_version;
            this.filePath = c14798c.field_filePath;
            this.uXe = c14798c.field_rid;
            this.mimeType = c14798c.field_mimeType;
            this.cvZ = c14798c.field_md5;
            this.downloadUrl = c14798c.field_downloadUrl;
            this.size = c14798c.field_size;
            this.uWQ = c14798c.field_downloadNetType;
            this.uXr = c14798c.field_completeDownload;
            this.createTime = c14798c.field_createTime;
        }
    }

    public final JSONObject dgC() {
        AppMethodBeat.m2504i(63563);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("key", this.key);
            jSONObject.put("pkgId", this.eBS);
            jSONObject.put("version", this.version);
            jSONObject.put("filePath", this.filePath);
            jSONObject.put("rid", this.uXe);
            jSONObject.put("mimeType", this.mimeType);
            jSONObject.put("md5", this.cvZ);
            jSONObject.put("downloadUrl", this.downloadUrl);
            jSONObject.put("size", this.size);
            jSONObject.put("downloadNetType", this.uWQ);
            jSONObject.put("completeDownload", this.uXr);
            jSONObject.put("createTime", this.createTime);
        } catch (JSONException e) {
        }
        AppMethodBeat.m2505o(63563);
        return jSONObject;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(63564);
        parcel.writeString(this.key);
        parcel.writeString(this.eBS);
        parcel.writeString(this.version);
        parcel.writeString(this.filePath);
        parcel.writeString(this.uXe);
        parcel.writeString(this.mimeType);
        parcel.writeString(this.cvZ);
        parcel.writeString(this.downloadUrl);
        parcel.writeInt(this.size);
        parcel.writeInt(this.uWQ);
        parcel.writeByte((byte) (this.uXr ? 1 : 0));
        parcel.writeLong(this.createTime);
        AppMethodBeat.m2505o(63564);
    }

    static {
        AppMethodBeat.m2504i(63565);
        AppMethodBeat.m2505o(63565);
    }
}
