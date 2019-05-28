package com.tencent.p177mm.plugin.appbrand.jsapi.storage;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.luggage.p1170a.C37384e;
import com.tencent.luggage.sdk.customize.C0997b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.appstorage.C42362b;
import com.tencent.p177mm.plugin.appbrand.ipc.MainProcessTask;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.storage.JsApiClearStorageTask */
class JsApiClearStorageTask extends MainProcessTask {
    public static final Creator<JsApiClearStorageTask> CREATOR = new C105161();
    public String appId;
    public int hXg;

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.storage.JsApiClearStorageTask$1 */
    static class C105161 implements Creator<JsApiClearStorageTask> {
        C105161() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new JsApiClearStorageTask[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(102028);
            JsApiClearStorageTask jsApiClearStorageTask = new JsApiClearStorageTask(parcel);
            AppMethodBeat.m2505o(102028);
            return jsApiClearStorageTask;
        }
    }

    public JsApiClearStorageTask(Parcel parcel) {
        AppMethodBeat.m2504i(102029);
        mo6032g(parcel);
        AppMethodBeat.m2505o(102029);
    }

    public final void asP() {
        C42362b c42362b;
        AppMethodBeat.m2504i(102030);
        if (C37384e.m62985B(C0997b.class) == null) {
            c42362b = null;
        } else {
            c42362b = ((C0997b) C37384e.m62985B(C0997b.class)).mo3975xG();
        }
        if (c42362b == null) {
            AppMethodBeat.m2505o(102030);
            return;
        }
        c42362b.mo67870F(this.hXg, this.appId);
        AppMethodBeat.m2505o(102030);
    }

    /* renamed from: g */
    public final void mo6032g(Parcel parcel) {
        AppMethodBeat.m2504i(102031);
        this.appId = parcel.readString();
        this.hXg = parcel.readInt();
        AppMethodBeat.m2505o(102031);
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(102032);
        parcel.writeString(this.appId);
        parcel.writeInt(this.hXg);
        AppMethodBeat.m2505o(102032);
    }

    static {
        AppMethodBeat.m2504i(102033);
        AppMethodBeat.m2505o(102033);
    }
}
