package com.tencent.p177mm.plugin.appbrand.ipc;

import android.content.Context;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Process;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.MMActivity.C5186a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyTransparentUIProcessTask */
public abstract class AppBrandProxyTransparentUIProcessTask implements Parcelable {
    private static Map<String, WeakReference<AppBrandProxyTransparentUIProcessTask>> huK = new ConcurrentHashMap();
    private static final Set<Object> hvo = new HashSet();
    private int hvp = -1;
    private C5186a hvq = new C455681();
    private String hvr = (Process.myPid() + hashCode());
    Context mContext;

    /* renamed from: com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyTransparentUIProcessTask$a */
    public interface C19245a {
        void aBT();
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyTransparentUIProcessTask$1 */
    class C455681 implements C5186a {
        C455681() {
        }

        /* renamed from: c */
        public final void mo6069c(int i, int i2, Intent intent) {
            AppMethodBeat.m2504i(73150);
            if (i == (AppBrandProxyTransparentUIProcessTask.this.hashCode() & CdnLogic.kBizGeneric)) {
                if (intent == null) {
                    AppMethodBeat.m2505o(73150);
                    return;
                }
                AppBrandProxyTransparentUIProcessTask appBrandProxyTransparentUIProcessTask = (AppBrandProxyTransparentUIProcessTask) intent.getParcelableExtra("task_object");
                AppBrandProxyTransparentUIProcessTask AF = AppBrandProxyTransparentUIProcessTask.m84066AF(intent.getStringExtra("task_id"));
                if (AF == null) {
                    C4990ab.m7412e("MicroMsg.AppBrandProxyTransparentUIProcessTask", "task is null");
                    AppMethodBeat.m2505o(73150);
                    return;
                }
                AppBrandProxyTransparentUIProcessTask.m84067a(appBrandProxyTransparentUIProcessTask, AF);
                AF.aBW();
                AF.asQ();
                AppBrandProxyTransparentUIProcessTask.this.mContext = null;
            }
            AppMethodBeat.m2505o(73150);
        }
    }

    /* renamed from: a */
    public abstract void mo6020a(Context context, C19245a c19245a);

    protected AppBrandProxyTransparentUIProcessTask() {
    }

    public AppBrandProxyTransparentUIProcessTask(Context context) {
        this.mContext = context;
    }

    public void asQ() {
    }

    /* renamed from: g */
    public void mo6022g(Parcel parcel) {
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

    /* renamed from: AF */
    static /* synthetic */ AppBrandProxyTransparentUIProcessTask m84066AF(String str) {
        if (!huK.containsKey(str)) {
            return null;
        }
        if (((WeakReference) huK.get(str)).get() == null) {
            return null;
        }
        return (AppBrandProxyTransparentUIProcessTask) ((WeakReference) huK.get(str)).get();
    }
}
