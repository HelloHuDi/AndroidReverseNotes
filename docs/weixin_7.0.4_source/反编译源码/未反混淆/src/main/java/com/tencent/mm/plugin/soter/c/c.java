package com.tencent.mm.plugin.soter.c;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.b;
import com.facebook.internal.NativeProtocol;
import com.tencent.mm.plugin.soter.d.j;
import com.tencent.mm.plugin.soter.d.k;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.soter.a.f.e;
import com.tencent.soter.core.c.i;
import java.lang.ref.WeakReference;

public abstract class c {
    public int gOW = -1;
    protected Handler handler = null;
    protected WeakReference<Activity> hiC = null;
    protected j rOa = null;
    protected k rOb = null;
    public e rOc = null;
    public e rOd = null;
    public a rOe = null;

    public interface a {
        void a(i iVar);
    }

    public abstract void fj();

    public abstract void onPause();

    public abstract void onRequestPermissionsResult(int i, String[] strArr, int[] iArr);

    public abstract void onResume();

    public c(WeakReference<Activity> weakReference, j jVar, k kVar, Handler handler) {
        this.rOa = jVar;
        this.rOb = kVar;
        this.hiC = weakReference;
        this.handler = handler;
    }

    /* Access modifiers changed, original: protected|final */
    public final void cvI() {
        if (this.handler != null) {
            this.handler.obtainMessage(4).sendToTarget();
        } else {
            ab.e("MicroMsg.SoterMpBaseController", "hy: handler not bind");
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final void cvJ() {
        if (this.handler != null) {
            this.handler.obtainMessage(5).sendToTarget();
        } else {
            ab.e("MicroMsg.SoterMpBaseController", "hy: handler not bind");
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final void cvK() {
        if (this.handler != null) {
            cvJ();
            this.handler.obtainMessage(0, this.rOb).sendToTarget();
            return;
        }
        ab.e("MicroMsg.SoterMpBaseController", "hy: handler not bind");
    }

    /* Access modifiers changed, original: protected|final */
    public final void cvL() {
        if (this.handler != null) {
            cvJ();
            this.handler.obtainMessage(1, this.rOb).sendToTarget();
            return;
        }
        ab.e("MicroMsg.SoterMpBaseController", "hy: handler not bind");
    }

    /* Access modifiers changed, original: protected|final */
    public final void cvM() {
        if (this.handler != null) {
            cvJ();
            this.handler.obtainMessage(2, this.rOb).sendToTarget();
            return;
        }
        ab.e("MicroMsg.SoterMpBaseController", "hy: handler not bind");
    }

    /* Access modifiers changed, original: protected|final */
    public final void G(String[] strArr) {
        if (this.handler != null) {
            Message obtainMessage = this.handler.obtainMessage(3);
            Bundle bundle = new Bundle();
            bundle.putStringArray(NativeProtocol.RESULT_ARGS_PERMISSIONS, strArr);
            bundle.putInt("request_code", 0);
            obtainMessage.setData(bundle);
            obtainMessage.sendToTarget();
            return;
        }
        ab.e("MicroMsg.SoterMpBaseController", "hy: handler not bind");
    }

    /* Access modifiers changed, original: protected|final */
    public final void a(b bVar) {
        if (bVar == null) {
            ab.e("MicroMsg.SoterMpBaseController", "hy: dialog is null.");
        } else if (this.handler != null) {
            cvJ();
            this.handler.obtainMessage(6, bVar).sendToTarget();
        } else {
            ab.e("MicroMsg.SoterMpBaseController", "hy: handler not bind");
        }
    }
}
