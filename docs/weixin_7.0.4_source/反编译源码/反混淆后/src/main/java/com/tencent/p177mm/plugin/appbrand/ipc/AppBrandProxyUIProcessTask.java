package com.tencent.p177mm.plugin.appbrand.ipc;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.MMActivity.C5186a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.lang.reflect.Constructor;

/* renamed from: com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask */
public abstract class AppBrandProxyUIProcessTask implements C5186a {
    public C10273b hvt;

    /* renamed from: com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask$ProcessRequest */
    public static abstract class ProcessRequest implements Parcelable {
        public abstract Class<? extends AppBrandProxyUIProcessTask> aCa();

        public ProcessRequest(Parcel parcel) {
            mo6049k(parcel);
        }

        /* Access modifiers changed, original: protected */
        public boolean aBY() {
            return false;
        }

        /* Access modifiers changed, original: protected */
        public String aBZ() {
            return null;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
        }

        /* Access modifiers changed, original: protected */
        /* renamed from: k */
        public void mo6049k(Parcel parcel) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask$ProcessResult */
    public static abstract class ProcessResult implements Parcelable {
        /* renamed from: k */
        public abstract void mo6045k(Parcel parcel);

        public ProcessResult(Parcel parcel) {
            mo6045k(parcel);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask$b */
    public interface C19247b<R extends ProcessResult> {
        /* renamed from: c */
        void mo6053c(R r);
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask$a */
    static final class C19248a {
        /* renamed from: AG */
        static <_Model extends AppBrandProxyUIProcessTask> _Model m29899AG(String str) {
            AppMethodBeat.m2504i(73152);
            try {
                Constructor declaredConstructor = Class.forName(str).getDeclaredConstructor(new Class[0]);
                declaredConstructor.setAccessible(true);
                AppBrandProxyUIProcessTask appBrandProxyUIProcessTask = (AppBrandProxyUIProcessTask) declaredConstructor.newInstance(new Object[0]);
                AppMethodBeat.m2505o(73152);
                return appBrandProxyUIProcessTask;
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.AppBrand.IpcProxyUIModelFactory", "create mode object using className(%s), exp = %s", str, C5046bo.m7574l(e));
                AppMethodBeat.m2505o(73152);
                return null;
            }
        }
    }

    /* renamed from: a */
    public abstract void mo6047a(ProcessRequest processRequest);

    public final MMActivity aBQ() {
        return this.hvt.aBQ();
    }

    /* renamed from: a */
    public final void mo34449a(final ProcessResult processResult) {
        C192461 c192461 = new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(73151);
                if (AppBrandProxyUIProcessTask.this.hvt == null) {
                    AppMethodBeat.m2505o(73151);
                    return;
                }
                AppBrandProxyUIProcessTask.this.hvt.mo21712a(processResult);
                AppMethodBeat.m2505o(73151);
            }
        };
        if (this.hvt != null) {
            this.hvt.runOnUiThread(c192461);
        }
    }

    protected static String getString(int i) {
        return C4996ah.getResources().getString(i);
    }

    /* renamed from: c */
    public void mo6069c(int i, int i2, Intent intent) {
    }

    /* Access modifiers changed, original: protected */
    public void aBX() {
    }
}
