package com.tencent.p177mm.plugin.appbrand.jsapi.storage;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.luggage.p1170a.C37384e;
import com.tencent.luggage.sdk.customize.C0997b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.appstorage.C42362b;
import com.tencent.p177mm.plugin.appbrand.ipc.MainProcessTask;
import java.util.ArrayList;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.storage.JsApiGetStorageInfoTask */
public class JsApiGetStorageInfoTask extends MainProcessTask {
    public static final Creator<JsApiGetStorageInfoTask> CREATOR = new C105171();
    public String appId;
    public int hXg;
    public ArrayList<String> hXl;
    public Runnable hww;
    public int limit;
    public int size;

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.storage.JsApiGetStorageInfoTask$1 */
    static class C105171 implements Creator<JsApiGetStorageInfoTask> {
        C105171() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new JsApiGetStorageInfoTask[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(102047);
            JsApiGetStorageInfoTask jsApiGetStorageInfoTask = new JsApiGetStorageInfoTask();
            jsApiGetStorageInfoTask.mo6032g(parcel);
            AppMethodBeat.m2505o(102047);
            return jsApiGetStorageInfoTask;
        }
    }

    public final void asP() {
        C42362b c42362b;
        AppMethodBeat.m2504i(102048);
        if (C37384e.m62985B(C0997b.class) == null) {
            c42362b = null;
        } else {
            c42362b = ((C0997b) C37384e.m62985B(C0997b.class)).mo3975xG();
        }
        if (c42362b == null) {
            aCb();
            AppMethodBeat.m2505o(102048);
            return;
        }
        Object[] G = c42362b.mo67871G(this.hXg, this.appId);
        this.hXl = (ArrayList) G[0];
        this.size = (int) Math.ceil(((Integer) G[1]).doubleValue() / 1000.0d);
        this.limit = (int) Math.ceil(((Integer) G[2]).doubleValue() / 1000.0d);
        aCb();
        AppMethodBeat.m2505o(102048);
    }

    public final void asQ() {
        AppMethodBeat.m2504i(102049);
        if (this.hww != null) {
            this.hww.run();
        }
        AppMethodBeat.m2505o(102049);
    }

    /* renamed from: g */
    public final void mo6032g(Parcel parcel) {
        AppMethodBeat.m2504i(102050);
        this.appId = parcel.readString();
        this.hXg = parcel.readInt();
        this.hXl = parcel.createStringArrayList();
        this.size = parcel.readInt();
        this.limit = parcel.readInt();
        AppMethodBeat.m2505o(102050);
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(102051);
        parcel.writeString(this.appId);
        parcel.writeInt(this.hXg);
        parcel.writeStringList(this.hXl);
        parcel.writeInt(this.size);
        parcel.writeInt(this.limit);
        AppMethodBeat.m2505o(102051);
    }

    static {
        AppMethodBeat.m2504i(102052);
        AppMethodBeat.m2505o(102052);
    }
}
