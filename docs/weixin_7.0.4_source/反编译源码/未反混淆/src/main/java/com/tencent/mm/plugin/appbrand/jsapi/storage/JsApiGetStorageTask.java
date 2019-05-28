package com.tencent.mm.plugin.appbrand.jsapi.storage;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.luggage.a.e;
import com.tencent.luggage.sdk.customize.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.n.a;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.sdk.platformtools.ab;

class JsApiGetStorageTask extends MainProcessTask {
    public static final Creator<JsApiGetStorageTask> CREATOR = new Creator<JsApiGetStorageTask>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new JsApiGetStorageTask[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.i(102054);
            JsApiGetStorageTask jsApiGetStorageTask = new JsApiGetStorageTask();
            jsApiGetStorageTask.g(parcel);
            AppMethodBeat.o(102054);
            return jsApiGetStorageTask;
        }
    };
    public String appId;
    public int hXg;
    private boolean hXm;
    private int hXn;
    private int hXo;
    private int hXp;
    public Runnable hww;
    public String key;
    public String type;
    public String value;

    public final void asP() {
        AppMethodBeat.i(102055);
        if (((b) e.B(b.class)) == null) {
            aCb();
            AppMethodBeat.o(102055);
            return;
        }
        com.tencent.mm.plugin.appbrand.appstorage.b xG = ((b) e.B(b.class)).xG();
        if (xG == null) {
            aCb();
            AppMethodBeat.o(102055);
            return;
        }
        Object[] k = xG.k(this.hXg, this.appId, this.key);
        if (((a) k[0]) == a.NONE) {
            if (p.m((String) k[1], (String) k[2]) > 102400) {
                this.hXo = p.m((String) k[1]);
                this.hXp = p.m(r1);
                try {
                    p.g(this.hvr, r0, r1);
                } catch (Exception e) {
                    ab.e("MicroMsg.JsApiGetStorageTask", e.getMessage());
                }
                this.hXm = true;
            } else {
                this.hXm = false;
                this.value = r0;
                this.type = r1;
            }
        }
        aCb();
        AppMethodBeat.o(102055);
    }

    public final void asQ() {
        AppMethodBeat.i(102056);
        if (this.hXm) {
            try {
                String BL = p.BL(this.hvr);
                if (BL.length() == this.hXo + this.hXp) {
                    this.value = BL.substring(0, this.hXo);
                    this.type = BL.substring(this.hXo, this.hXo + this.hXp);
                }
                p.BM(this.hvr);
            } catch (Exception e) {
                ab.e("MicroMsg.JsApiGetStorageTask", e.getMessage());
                p.BM(this.hvr);
            } catch (Throwable th) {
                p.BM(this.hvr);
                AppMethodBeat.o(102056);
            }
        }
        if (this.hww != null) {
            this.hww.run();
        }
        AppMethodBeat.o(102056);
    }

    public final void g(Parcel parcel) {
        AppMethodBeat.i(102057);
        this.appId = parcel.readString();
        this.hXg = parcel.readInt();
        this.hXm = parcel.readByte() != (byte) 0;
        this.hXn = parcel.readInt();
        this.hXo = parcel.readInt();
        this.hXp = parcel.readInt();
        this.key = parcel.readString();
        this.value = parcel.readString();
        this.type = parcel.readString();
        AppMethodBeat.o(102057);
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(102058);
        parcel.writeString(this.appId);
        parcel.writeInt(this.hXg);
        parcel.writeByte(this.hXm ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.hXn);
        parcel.writeInt(this.hXo);
        parcel.writeInt(this.hXp);
        parcel.writeString(this.key);
        parcel.writeString(this.value);
        parcel.writeString(this.type);
        AppMethodBeat.o(102058);
    }

    static {
        AppMethodBeat.i(102059);
        AppMethodBeat.o(102059);
    }
}
