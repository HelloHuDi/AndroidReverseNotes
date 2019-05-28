package com.tencent.mm.plugin.appbrand.ipc;

import android.content.Context;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Process;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMActivity;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public abstract class AppBrandProxyTransparentUIProcessTask implements Parcelable {
    private static Map<String, WeakReference<AppBrandProxyTransparentUIProcessTask>> huK = new ConcurrentHashMap();
    private static final Set<Object> hvo = new HashSet();
    private int hvp = -1;
    private com.tencent.mm.ui.MMActivity.a hvq = new com.tencent.mm.ui.MMActivity.a() {
        public final void c(int i, int i2, Intent intent) {
            AppMethodBeat.i(73150);
            if (i == (AppBrandProxyTransparentUIProcessTask.this.hashCode() & CdnLogic.kBizGeneric)) {
                if (intent == null) {
                    AppMethodBeat.o(73150);
                    return;
                }
                AppBrandProxyTransparentUIProcessTask appBrandProxyTransparentUIProcessTask = (AppBrandProxyTransparentUIProcessTask) intent.getParcelableExtra("task_object");
                AppBrandProxyTransparentUIProcessTask AF = AppBrandProxyTransparentUIProcessTask.AF(intent.getStringExtra("task_id"));
                if (AF == null) {
                    ab.e("MicroMsg.AppBrandProxyTransparentUIProcessTask", "task is null");
                    AppMethodBeat.o(73150);
                    return;
                }
                AppBrandProxyTransparentUIProcessTask.a(appBrandProxyTransparentUIProcessTask, AF);
                AF.aBW();
                AF.asQ();
                AppBrandProxyTransparentUIProcessTask.this.mContext = null;
            }
            AppMethodBeat.o(73150);
        }
    };
    private String hvr = (Process.myPid() + hashCode());
    Context mContext;

    public interface a {
        void aBT();
    }

    public abstract void a(Context context, a aVar);

    protected AppBrandProxyTransparentUIProcessTask() {
    }

    public AppBrandProxyTransparentUIProcessTask(Context context) {
        this.mContext = context;
    }

    public void asQ() {
    }

    public void g(Parcel parcel) {
    }

    public void writeToParcel(Parcel parcel, int i) {
    }

    public int describeContents() {
        return 0;
    }

    public final void aBU() {
        if (this.mContext != null) {
            huK.put(this.hvr, new WeakReference(this));
            Intent intent = new Intent();
            intent.setClass(this.mContext, AppBrandProxyTransparentUI.class);
            intent.putExtra("task_object", this);
            intent.putExtra("task_class_name", getClass().getName());
            intent.putExtra("task_id", this.hvr);
            intent.putExtra("orientation", this.hvp);
            if (this.mContext instanceof MMActivity) {
                aBV();
                ((MMActivity) this.mContext).ifE = this.hvq;
                ((MMActivity) this.mContext).startActivityForResult(intent, hashCode() & CdnLogic.kBizGeneric);
                return;
            }
            intent.addFlags(268435456);
            this.mContext.startActivity(intent);
        }
    }

    public final void aBV() {
        hvo.add(this);
    }

    public final void aBW() {
        hvo.remove(this);
    }

    static /* synthetic */ AppBrandProxyTransparentUIProcessTask AF(String str) {
        if (!huK.containsKey(str)) {
            return null;
        }
        if (((WeakReference) huK.get(str)).get() == null) {
            return null;
        }
        return (AppBrandProxyTransparentUIProcessTask) ((WeakReference) huK.get(str)).get();
    }
}
