package com.tencent.p177mm.plugin.appbrand.jsapi.storage;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.luggage.p1170a.C37384e;
import com.tencent.luggage.sdk.customize.C0997b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.appstorage.C42362b;
import com.tencent.p177mm.plugin.appbrand.ipc.MainProcessTask;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.storage.JsApiRemoveStorageTask */
public class JsApiRemoveStorageTask extends MainProcessTask {
    public static final Creator<JsApiRemoveStorageTask> CREATOR = new C270821();
    public String appId;
    public int hXg;
    public String key;

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.storage.JsApiRemoveStorageTask$1 */
    static class C270821 implements Creator<JsApiRemoveStorageTask> {
        C270821() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new JsApiRemoveStorageTask[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(102067);
            JsApiRemoveStorageTask jsApiRemoveStorageTask = new JsApiRemoveStorageTask();
            jsApiRemoveStorageTask.mo6032g(parcel);
            AppMethodBeat.m2505o(102067);
            return jsApiRemoveStorageTask;
        }
    }

    public final void asP() {
        C42362b c42362b;
        AppMethodBeat.m2504i(102068);
        if (C37384e.m62985B(C0997b.class) == null) {
            c42362b = null;
        } else {
            c42362b = ((C0997b) C37384e.m62985B(C0997b.class)).mo3975xG();
        }
        if (c42362b == null) {
            AppMethodBeat.m2505o(102068);
            return;
        }
        c42362b.mo67874l(this.hXg, this.appId, this.key);
        AppMethodBeat.m2505o(102068);
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(102069);
        parcel.writeString(this.appId);
        parcel.writeInt(this.hXg);
        parcel.writeString(this.key);
        AppMethodBeat.m2505o(102069);
    }

    /* renamed from: g */
    public final void mo6032g(Parcel parcel) {
        AppMethodBeat.m2504i(102070);
        this.appId = parcel.readString();
        this.hXg = parcel.readInt();
        this.key = parcel.readString();
        AppMethodBeat.m2505o(102070);
    }

    static {
        AppMethodBeat.m2504i(102071);
        AppMethodBeat.m2505o(102071);
    }
}
