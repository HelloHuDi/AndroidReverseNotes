package com.tencent.mm.plugin.appbrand.ipc;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import java.lang.reflect.Constructor;

public abstract class AppBrandProxyUIProcessTask implements com.tencent.mm.ui.MMActivity.a {
    public b hvt;

    public static abstract class ProcessRequest implements Parcelable {
        public abstract Class<? extends AppBrandProxyUIProcessTask> aCa();

        public ProcessRequest(Parcel parcel) {
            k(parcel);
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
        public void k(Parcel parcel) {
        }
    }

    public static abstract class ProcessResult implements Parcelable {
        public abstract void k(Parcel parcel);

        public ProcessResult(Parcel parcel) {
            k(parcel);
        }
    }

    public interface b<R extends ProcessResult> {
        void c(R r);
    }

    static final class a {
        static <_Model extends AppBrandProxyUIProcessTask> _Model AG(String str) {
            AppMethodBeat.i(73152);
            try {
                Constructor declaredConstructor = Class.forName(str).getDeclaredConstructor(new Class[0]);
                declaredConstructor.setAccessible(true);
                AppBrandProxyUIProcessTask appBrandProxyUIProcessTask = (AppBrandProxyUIProcessTask) declaredConstructor.newInstance(new Object[0]);
                AppMethodBeat.o(73152);
                return appBrandProxyUIProcessTask;
            } catch (Exception e) {
                ab.e("MicroMsg.AppBrand.IpcProxyUIModelFactory", "create mode object using className(%s), exp = %s", str, bo.l(e));
                AppMethodBeat.o(73152);
                return null;
            }
        }
    }

    public abstract void a(ProcessRequest processRequest);

    public final MMActivity aBQ() {
        return this.hvt.aBQ();
    }

    public final void a(final ProcessResult processResult) {
        AnonymousClass1 anonymousClass1 = new Runnable() {
            public final void run() {
                AppMethodBeat.i(73151);
                if (AppBrandProxyUIProcessTask.this.hvt == null) {
                    AppMethodBeat.o(73151);
                    return;
                }
                AppBrandProxyUIProcessTask.this.hvt.a(processResult);
                AppMethodBeat.o(73151);
            }
        };
        if (this.hvt != null) {
            this.hvt.runOnUiThread(anonymousClass1);
        }
    }

    protected static String getString(int i) {
        return ah.getResources().getString(i);
    }

    public void c(int i, int i2, Intent intent) {
    }

    /* Access modifiers changed, original: protected */
    public void aBX() {
    }
}
