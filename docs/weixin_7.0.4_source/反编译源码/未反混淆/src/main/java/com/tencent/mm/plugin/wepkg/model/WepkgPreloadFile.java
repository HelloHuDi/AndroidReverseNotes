package com.tencent.mm.plugin.wepkg.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wepkg.b.c;
import org.json.JSONException;
import org.json.JSONObject;

public class WepkgPreloadFile implements Parcelable {
    public static final Creator<WepkgPreloadFile> CREATOR = new Creator<WepkgPreloadFile>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new WepkgPreloadFile[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.i(63561);
            WepkgPreloadFile wepkgPreloadFile = new WepkgPreloadFile(parcel);
            AppMethodBeat.o(63561);
            return wepkgPreloadFile;
        }
    };
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

    public WepkgPreloadFile(Parcel parcel) {
        AppMethodBeat.i(63562);
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
        AppMethodBeat.o(63562);
    }

    public final void a(c cVar) {
        if (cVar != null) {
            this.key = cVar.field_key;
            this.eBS = cVar.field_pkgId;
            this.version = cVar.field_version;
            this.filePath = cVar.field_filePath;
            this.uXe = cVar.field_rid;
            this.mimeType = cVar.field_mimeType;
            this.cvZ = cVar.field_md5;
            this.downloadUrl = cVar.field_downloadUrl;
            this.size = cVar.field_size;
            this.uWQ = cVar.field_downloadNetType;
            this.uXr = cVar.field_completeDownload;
            this.createTime = cVar.field_createTime;
        }
    }

    public final JSONObject dgC() {
        AppMethodBeat.i(63563);
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
        AppMethodBeat.o(63563);
        return jSONObject;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(63564);
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
        AppMethodBeat.o(63564);
    }

    static {
        AppMethodBeat.i(63565);
        AppMethodBeat.o(63565);
    }
}
