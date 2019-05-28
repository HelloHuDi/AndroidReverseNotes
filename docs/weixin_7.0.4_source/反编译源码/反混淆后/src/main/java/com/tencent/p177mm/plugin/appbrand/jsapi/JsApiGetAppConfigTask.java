package com.tencent.p177mm.plugin.appbrand.jsapi;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.plugin.appbrand.app.C42340f;
import com.tencent.p177mm.plugin.appbrand.appcache.p277b.p279e.C45513b;
import com.tencent.p177mm.plugin.appbrand.appcache.p277b.p883c.C19050a;
import com.tencent.p177mm.plugin.appbrand.config.C45535l;
import com.tencent.p177mm.plugin.appbrand.config.C45535l.C42404c;
import com.tencent.p177mm.plugin.appbrand.ipc.MainProcessTask;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.JsApiGetAppConfigTask */
class JsApiGetAppConfigTask extends MainProcessTask {
    public static final Creator<JsApiGetAppConfigTask> CREATOR = new C382462();
    public String appId;
    public Runnable hww;
    public String key;
    public int scene;
    public int type;
    public String value;

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.JsApiGetAppConfigTask$2 */
    static class C382462 implements Creator<JsApiGetAppConfigTask> {
        C382462() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new JsApiGetAppConfigTask[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(130426);
            JsApiGetAppConfigTask jsApiGetAppConfigTask = new JsApiGetAppConfigTask(parcel);
            AppMethodBeat.m2505o(130426);
            return jsApiGetAppConfigTask;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.JsApiGetAppConfigTask$1 */
    class C382471 implements C42404c {
        C382471() {
        }

        /* renamed from: xC */
        public final void mo53649xC(String str) {
            AppMethodBeat.m2504i(130425);
            JsApiGetAppConfigTask.this.value = str;
            JsApiGetAppConfigTask.m64723a(JsApiGetAppConfigTask.this);
            AppMethodBeat.m2505o(130425);
        }
    }

    /* renamed from: a */
    static /* synthetic */ boolean m64723a(JsApiGetAppConfigTask jsApiGetAppConfigTask) {
        AppMethodBeat.m2504i(130432);
        boolean aCb = jsApiGetAppConfigTask.aCb();
        AppMethodBeat.m2505o(130432);
        return aCb;
    }

    public JsApiGetAppConfigTask(Parcel parcel) {
        AppMethodBeat.m2504i(130427);
        mo6032g(parcel);
        AppMethodBeat.m2505o(130427);
    }

    public final void asP() {
        AppMethodBeat.m2504i(130428);
        if (C1720g.m3534RN().eJb) {
            Pair y = ((C45513b) C42340f.m74878E(C45513b.class)).mo73326y(this.appId, 4, this.scene);
            if (((Boolean) y.first).booleanValue()) {
                C19050a c19050a = C19050a.gWl;
                C19050a.m29623z((long) ((Integer) y.second).intValue(), 166);
            }
            C45535l.m83971a(this.appId, this.type, 0, new C382471(), !((Boolean) y.first).booleanValue());
            AppMethodBeat.m2505o(130428);
            return;
        }
        AppMethodBeat.m2505o(130428);
    }

    public final void asQ() {
        AppMethodBeat.m2504i(130429);
        if (this.hww != null) {
            this.hww.run();
        }
        AppMethodBeat.m2505o(130429);
    }

    /* renamed from: g */
    public final void mo6032g(Parcel parcel) {
        AppMethodBeat.m2504i(130430);
        this.appId = parcel.readString();
        this.key = parcel.readString();
        this.value = parcel.readString();
        this.type = parcel.readInt();
        this.scene = parcel.readInt();
        AppMethodBeat.m2505o(130430);
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(130431);
        parcel.writeString(this.appId);
        parcel.writeString(this.key);
        parcel.writeString(this.value);
        parcel.writeInt(this.type);
        parcel.writeInt(this.scene);
        AppMethodBeat.m2505o(130431);
    }

    static {
        AppMethodBeat.m2504i(130433);
        AppMethodBeat.m2505o(130433);
    }
}
