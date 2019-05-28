package com.tencent.p177mm.remoteservice;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.remoteservice.C15406c.C15407a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.remoteservice.d */
public final class C46607d {
    private Context context;
    private ServiceConnection ktl = new C302611();
    List<Runnable> xtZ = new LinkedList();
    C15406c xua;

    /* renamed from: com.tencent.mm.remoteservice.d$1 */
    class C302611 implements ServiceConnection {
        C302611() {
        }

        public final void onServiceDisconnected(ComponentName componentName) {
            C46607d.this.xua = null;
        }

        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            AppMethodBeat.m2504i(80230);
            C46607d.this.xua = C15407a.m23686L(iBinder);
            for (Runnable run : (Runnable[]) C46607d.this.xtZ.toArray(new Runnable[C46607d.this.xtZ.size()])) {
                run.run();
            }
            C46607d.this.xtZ.clear();
            AppMethodBeat.m2505o(80230);
        }
    }

    public C46607d(Context context) {
        AppMethodBeat.m2504i(80231);
        this.context = context;
        AppMethodBeat.m2505o(80231);
    }

    public final void connect(Runnable runnable) {
        AppMethodBeat.m2504i(80232);
        new StringBuilder("RemoteServiceProxy construct, thread id:").append(Thread.currentThread().getId());
        if (isConnected()) {
            runnable.run();
            AppMethodBeat.m2505o(80232);
        } else if (this.context == null) {
            AppMethodBeat.m2505o(80232);
        } else {
            this.xtZ.add(runnable);
            this.context.bindService(new Intent(this.context, RemoteService.class), this.ktl, 1);
            AppMethodBeat.m2505o(80232);
        }
    }

    public final boolean isConnected() {
        AppMethodBeat.m2504i(80233);
        if (this.xua == null || !this.xua.asBinder().isBinderAlive()) {
            AppMethodBeat.m2505o(80233);
            return false;
        }
        AppMethodBeat.m2505o(80233);
        return true;
    }

    public final void release() {
        AppMethodBeat.m2504i(80234);
        if (!(this.xua == null || this.ktl == null)) {
            this.context.unbindService(this.ktl);
            this.xua = null;
        }
        this.context = null;
        AppMethodBeat.m2505o(80234);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: a */
    public final void mo74749a(C30258b c30258b, String str, Bundle bundle) {
        AppMethodBeat.m2504i(80235);
        if (isConnected()) {
            try {
                this.xua.mo27448a(c30258b.getClass().getName(), str, bundle, c30258b);
                AppMethodBeat.m2505o(80235);
                return;
            } catch (RemoteException e) {
                C4990ab.m7413e("MicroMsg.RemoteServiceProxy", "exception:%s", C5046bo.m7574l(e));
            }
        }
        AppMethodBeat.m2505o(80235);
    }
}
