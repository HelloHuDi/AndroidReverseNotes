package com.tencent.p177mm.plugin.appbrand.jsapi.storage;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.luggage.p1170a.C37384e;
import com.tencent.luggage.sdk.customize.C0997b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.appstorage.C10108n.C10107a;
import com.tencent.p177mm.plugin.appbrand.appstorage.C42362b;
import com.tencent.p177mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.storage.JsApiGetStorageTask */
class JsApiGetStorageTask extends MainProcessTask {
    public static final Creator<JsApiGetStorageTask> CREATOR = new C333931();
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

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.storage.JsApiGetStorageTask$1 */
    static class C333931 implements Creator<JsApiGetStorageTask> {
        C333931() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new JsApiGetStorageTask[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(102054);
            JsApiGetStorageTask jsApiGetStorageTask = new JsApiGetStorageTask();
            jsApiGetStorageTask.mo6032g(parcel);
            AppMethodBeat.m2505o(102054);
            return jsApiGetStorageTask;
        }
    }

    public final void asP() {
        AppMethodBeat.m2504i(102055);
        if (((C0997b) C37384e.m62985B(C0997b.class)) == null) {
            aCb();
            AppMethodBeat.m2505o(102055);
            return;
        }
        C42362b xG = ((C0997b) C37384e.m62985B(C0997b.class)).mo3975xG();
        if (xG == null) {
            aCb();
            AppMethodBeat.m2505o(102055);
            return;
        }
        Object[] k = xG.mo67873k(this.hXg, this.appId, this.key);
        if (((C10107a) k[0]) == C10107a.NONE) {
            if (C45621p.m84208m((String) k[1], (String) k[2]) > 102400) {
                this.hXo = C45621p.m84208m((String) k[1]);
                this.hXp = C45621p.m84208m(r1);
                try {
                    C45621p.m84207g(this.hvr, r0, r1);
                } catch (Exception e) {
                    C4990ab.m7412e("MicroMsg.JsApiGetStorageTask", e.getMessage());
                }
                this.hXm = true;
            } else {
                this.hXm = false;
                this.value = r0;
                this.type = r1;
            }
        }
        aCb();
        AppMethodBeat.m2505o(102055);
    }

    public final void asQ() {
        AppMethodBeat.m2504i(102056);
        if (this.hXm) {
            try {
                String BL = C45621p.m84203BL(this.hvr);
                if (BL.length() == this.hXo + this.hXp) {
                    this.value = BL.substring(0, this.hXo);
                    this.type = BL.substring(this.hXo, this.hXo + this.hXp);
                }
                C45621p.m84204BM(this.hvr);
            } catch (Exception e) {
                C4990ab.m7412e("MicroMsg.JsApiGetStorageTask", e.getMessage());
                C45621p.m84204BM(this.hvr);
            } catch (Throwable th) {
                C45621p.m84204BM(this.hvr);
                AppMethodBeat.m2505o(102056);
            }
        }
        if (this.hww != null) {
            this.hww.run();
        }
        AppMethodBeat.m2505o(102056);
    }

    /* renamed from: g */
    public final void mo6032g(Parcel parcel) {
        AppMethodBeat.m2504i(102057);
        this.appId = parcel.readString();
        this.hXg = parcel.readInt();
        this.hXm = parcel.readByte() != (byte) 0;
        this.hXn = parcel.readInt();
        this.hXo = parcel.readInt();
        this.hXp = parcel.readInt();
        this.key = parcel.readString();
        this.value = parcel.readString();
        this.type = parcel.readString();
        AppMethodBeat.m2505o(102057);
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(102058);
        parcel.writeString(this.appId);
        parcel.writeInt(this.hXg);
        parcel.writeByte(this.hXm ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.hXn);
        parcel.writeInt(this.hXo);
        parcel.writeInt(this.hXp);
        parcel.writeString(this.key);
        parcel.writeString(this.value);
        parcel.writeString(this.type);
        AppMethodBeat.m2505o(102058);
    }

    static {
        AppMethodBeat.m2504i(102059);
        AppMethodBeat.m2505o(102059);
    }
}
