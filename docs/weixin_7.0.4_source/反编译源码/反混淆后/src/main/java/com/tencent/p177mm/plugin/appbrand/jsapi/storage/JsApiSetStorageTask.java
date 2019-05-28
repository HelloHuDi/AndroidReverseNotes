package com.tencent.p177mm.plugin.appbrand.jsapi.storage;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.luggage.p1170a.C37384e;
import com.tencent.luggage.sdk.customize.C0997b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.appstorage.C42362b;
import com.tencent.p177mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.storage.JsApiSetStorageTask */
class JsApiSetStorageTask extends MainProcessTask {
    public static final Creator<JsApiSetStorageTask> CREATOR = new C333941();
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

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.storage.JsApiSetStorageTask$1 */
    static class C333941 implements Creator<JsApiSetStorageTask> {
        C333941() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new JsApiSetStorageTask[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(102084);
            JsApiSetStorageTask jsApiSetStorageTask = new JsApiSetStorageTask();
            jsApiSetStorageTask.mo6032g(parcel);
            AppMethodBeat.m2505o(102084);
            return jsApiSetStorageTask;
        }
    }

    JsApiSetStorageTask() {
    }

    /* renamed from: C */
    public final void mo53868C(String str, String str2, String str3) {
        AppMethodBeat.m2504i(102085);
        if (C45621p.m84208m(str, str2, str3) > 102400) {
            this.hXn = C45621p.m84208m(str);
            this.hXo = C45621p.m84208m(str2);
            this.hXp = C45621p.m84208m(str3);
            try {
                C45621p.m84207g(this.hvr, str, str2, str3);
            } catch (Exception e) {
                C4990ab.m7412e("MicroMsg.JsApiSetStorageTask", e.getMessage());
            }
            this.hXm = true;
            AppMethodBeat.m2505o(102085);
            return;
        }
        this.hXm = false;
        this.key = str;
        this.value = str2;
        this.type = str3;
        AppMethodBeat.m2505o(102085);
    }

    private void aET() {
        this.key = null;
        this.value = null;
        this.type = null;
    }

    public final void asQ() {
        AppMethodBeat.m2504i(102086);
        if (this.hww != null) {
            this.hww.run();
        }
        AppMethodBeat.m2505o(102086);
    }

    public final void asP() {
        C42362b c42362b;
        AppMethodBeat.m2504i(102087);
        if (this.hXm) {
            try {
                String BL = C45621p.m84203BL(this.hvr);
                if (BL.length() == (this.hXn + this.hXo) + this.hXp) {
                    this.key = BL.substring(0, this.hXn);
                    this.value = BL.substring(this.hXn, this.hXn + this.hXo);
                    this.type = BL.substring(this.hXn + this.hXo, (this.hXn + this.hXo) + this.hXp);
                }
                C45621p.m84204BM(this.hvr);
            } catch (Exception e) {
                C4990ab.m7412e("MicroMsg.JsApiSetStorageTask", e.getMessage());
                C45621p.m84204BM(this.hvr);
            } catch (Throwable th) {
                C45621p.m84204BM(this.hvr);
                AppMethodBeat.m2505o(102087);
            }
        }
        if (C37384e.m62985B(C0997b.class) == null) {
            c42362b = null;
        } else {
            c42362b = ((C0997b) C37384e.m62985B(C0997b.class)).mo3975xG();
        }
        if (c42362b == null) {
            this.result = "fail:internal error get DB fail";
            aET();
            aCb();
            AppMethodBeat.m2505o(102087);
            return;
        }
        this.result = C45621p.m84206a(c42362b.mo67872b(this.hXg, this.appId, this.key, this.value, this.type));
        aET();
        aCb();
        AppMethodBeat.m2505o(102087);
    }

    /* renamed from: g */
    public final void mo6032g(Parcel parcel) {
        AppMethodBeat.m2504i(102088);
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
        AppMethodBeat.m2505o(102088);
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(102089);
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
        AppMethodBeat.m2505o(102089);
    }

    static {
        AppMethodBeat.m2504i(102090);
        AppMethodBeat.m2505o(102090);
    }
}
