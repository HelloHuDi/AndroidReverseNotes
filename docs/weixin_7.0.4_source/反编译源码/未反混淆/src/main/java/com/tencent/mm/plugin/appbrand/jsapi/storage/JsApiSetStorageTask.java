package com.tencent.mm.plugin.appbrand.jsapi.storage;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.luggage.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.b;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.sdk.platformtools.ab;

class JsApiSetStorageTask extends MainProcessTask {
    public static final Creator<JsApiSetStorageTask> CREATOR = new Creator<JsApiSetStorageTask>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new JsApiSetStorageTask[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.i(102084);
            JsApiSetStorageTask jsApiSetStorageTask = new JsApiSetStorageTask();
            jsApiSetStorageTask.g(parcel);
            AppMethodBeat.o(102084);
            return jsApiSetStorageTask;
        }
    };
    public String appId;
    public int hXg;
    private boolean hXm;
    private int hXn;
    private int hXo;
    private int hXp;
    public Runnable hww;
    private String key;
    public String result;
    private String type;
    private String value;

    JsApiSetStorageTask() {
    }

    public final void C(String str, String str2, String str3) {
        AppMethodBeat.i(102085);
        if (p.m(str, str2, str3) > 102400) {
            this.hXn = p.m(str);
            this.hXo = p.m(str2);
            this.hXp = p.m(str3);
            try {
                p.g(this.hvr, str, str2, str3);
            } catch (Exception e) {
                ab.e("MicroMsg.JsApiSetStorageTask", e.getMessage());
            }
            this.hXm = true;
            AppMethodBeat.o(102085);
            return;
        }
        this.hXm = false;
        this.key = str;
        this.value = str2;
        this.type = str3;
        AppMethodBeat.o(102085);
    }

    private void aET() {
        this.key = null;
        this.value = null;
        this.type = null;
    }

    public final void asQ() {
        AppMethodBeat.i(102086);
        if (this.hww != null) {
            this.hww.run();
        }
        AppMethodBeat.o(102086);
    }

    public final void asP() {
        b bVar;
        AppMethodBeat.i(102087);
        if (this.hXm) {
            try {
                String BL = p.BL(this.hvr);
                if (BL.length() == (this.hXn + this.hXo) + this.hXp) {
                    this.key = BL.substring(0, this.hXn);
                    this.value = BL.substring(this.hXn, this.hXn + this.hXo);
                    this.type = BL.substring(this.hXn + this.hXo, (this.hXn + this.hXo) + this.hXp);
                }
                p.BM(this.hvr);
            } catch (Exception e) {
                ab.e("MicroMsg.JsApiSetStorageTask", e.getMessage());
                p.BM(this.hvr);
            } catch (Throwable th) {
                p.BM(this.hvr);
                AppMethodBeat.o(102087);
            }
        }
        if (e.B(com.tencent.luggage.sdk.customize.b.class) == null) {
            bVar = null;
        } else {
            bVar = ((com.tencent.luggage.sdk.customize.b) e.B(com.tencent.luggage.sdk.customize.b.class)).xG();
        }
        if (bVar == null) {
            this.result = "fail:internal error get DB fail";
            aET();
            aCb();
            AppMethodBeat.o(102087);
            return;
        }
        this.result = p.a(bVar.b(this.hXg, this.appId, this.key, this.value, this.type));
        aET();
        aCb();
        AppMethodBeat.o(102087);
    }

    public final void g(Parcel parcel) {
        AppMethodBeat.i(102088);
        this.appId = parcel.readString();
        this.hXg = parcel.readInt();
        this.hXm = parcel.readByte() != (byte) 0;
        this.hXn = parcel.readInt();
        this.hXo = parcel.readInt();
        this.hXp = parcel.readInt();
        this.key = parcel.readString();
        this.value = parcel.readString();
        this.type = parcel.readString();
        this.result = parcel.readString();
        AppMethodBeat.o(102088);
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(102089);
        parcel.writeString(this.appId);
        parcel.writeInt(this.hXg);
        parcel.writeByte(this.hXm ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.hXn);
        parcel.writeInt(this.hXo);
        parcel.writeInt(this.hXp);
        parcel.writeString(this.key);
        parcel.writeString(this.value);
        parcel.writeString(this.type);
        parcel.writeString(this.result);
        AppMethodBeat.o(102089);
    }

    static {
        AppMethodBeat.i(102090);
        AppMethodBeat.o(102090);
    }
}
