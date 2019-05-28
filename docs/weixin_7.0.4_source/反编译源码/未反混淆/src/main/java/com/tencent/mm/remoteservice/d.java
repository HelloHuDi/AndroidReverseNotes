package com.tencent.mm.remoteservice;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.remoteservice.c.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.LinkedList;
import java.util.List;

public final class d {
    private Context context;
    private ServiceConnection ktl = new ServiceConnection() {
        public final void onServiceDisconnected(ComponentName componentName) {
            d.this.xua = null;
        }

        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            AppMethodBeat.i(80230);
            d.this.xua = a.L(iBinder);
            for (Runnable run : (Runnable[]) d.this.xtZ.toArray(new Runnable[d.this.xtZ.size()])) {
                run.run();
            }
            d.this.xtZ.clear();
            AppMethodBeat.o(80230);
        }
    };
    List<Runnable> xtZ = new LinkedList();
    c xua;

    public d(Context context) {
        AppMethodBeat.i(80231);
        this.context = context;
        AppMethodBeat.o(80231);
    }

    public final void connect(Runnable runnable) {
        AppMethodBeat.i(80232);
        new StringBuilder("RemoteServiceProxy construct, thread id:").append(Thread.currentThread().getId());
        if (isConnected()) {
            runnable.run();
            AppMethodBeat.o(80232);
        } else if (this.context == null) {
            AppMethodBeat.o(80232);
        } else {
            this.xtZ.add(runnable);
            this.context.bindService(new Intent(this.context, RemoteService.class), this.ktl, 1);
            AppMethodBeat.o(80232);
        }
    }

    public final boolean isConnected() {
        AppMethodBeat.i(80233);
        if (this.xua == null || !this.xua.asBinder().isBinderAlive()) {
            AppMethodBeat.o(80233);
            return false;
        }
        AppMethodBeat.o(80233);
        return true;
    }

    public final void release() {
        AppMethodBeat.i(80234);
        if (!(this.xua == null || this.ktl == null)) {
            this.context.unbindService(this.ktl);
            this.xua = null;
        }
        this.context = null;
        AppMethodBeat.o(80234);
    }

    /* Access modifiers changed, original: final */
    public final void a(b bVar, String str, Bundle bundle) {
        AppMethodBeat.i(80235);
        if (isConnected()) {
            try {
                this.xua.a(bVar.getClass().getName(), str, bundle, bVar);
                AppMethodBeat.o(80235);
                return;
            } catch (RemoteException e) {
                ab.e("MicroMsg.RemoteServiceProxy", "exception:%s", bo.l(e));
            }
        }
        AppMethodBeat.o(80235);
    }
}
