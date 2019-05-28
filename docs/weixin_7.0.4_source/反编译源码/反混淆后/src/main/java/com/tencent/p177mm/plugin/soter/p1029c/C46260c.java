package com.tencent.p177mm.plugin.soter.p1029c;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.p069v7.app.C7452b;
import com.facebook.internal.NativeProtocol;
import com.tencent.p177mm.plugin.soter.p528d.C39856k;
import com.tencent.p177mm.plugin.soter.p528d.C46263j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.soter.core.p1351c.C30972i;
import com.tencent.soter.p663a.p1108f.C30958e;
import java.lang.ref.WeakReference;

/* renamed from: com.tencent.mm.plugin.soter.c.c */
public abstract class C46260c {
    public int gOW = -1;
    protected Handler handler = null;
    protected WeakReference<Activity> hiC = null;
    protected C46263j rOa = null;
    protected C39856k rOb = null;
    public C30958e rOc = null;
    public C30958e rOd = null;
    public C39853a rOe = null;

    /* renamed from: com.tencent.mm.plugin.soter.c.c$a */
    public interface C39853a {
        /* renamed from: a */
        void mo17329a(C30972i c30972i);
    }

    /* renamed from: fj */
    public abstract void mo69233fj();

    public abstract void onPause();

    public abstract void onRequestPermissionsResult(int i, String[] strArr, int[] iArr);

    public abstract void onResume();

    public C46260c(WeakReference<Activity> weakReference, C46263j c46263j, C39856k c39856k, Handler handler) {
        this.rOa = c46263j;
        this.rOb = c39856k;
        this.hiC = weakReference;
        this.handler = handler;
    }

    /* Access modifiers changed, original: protected|final */
    public final void cvI() {
        if (this.handler != null) {
            this.handler.obtainMessage(4).sendToTarget();
        } else {
            C4990ab.m7412e("MicroMsg.SoterMpBaseController", "hy: handler not bind");
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final void cvJ() {
        if (this.handler != null) {
            this.handler.obtainMessage(5).sendToTarget();
        } else {
            C4990ab.m7412e("MicroMsg.SoterMpBaseController", "hy: handler not bind");
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final void cvK() {
        if (this.handler != null) {
            cvJ();
            this.handler.obtainMessage(0, this.rOb).sendToTarget();
            return;
        }
        C4990ab.m7412e("MicroMsg.SoterMpBaseController", "hy: handler not bind");
    }

    /* Access modifiers changed, original: protected|final */
    public final void cvL() {
        if (this.handler != null) {
            cvJ();
            this.handler.obtainMessage(1, this.rOb).sendToTarget();
            return;
        }
        C4990ab.m7412e("MicroMsg.SoterMpBaseController", "hy: handler not bind");
    }

    /* Access modifiers changed, original: protected|final */
    public final void cvM() {
        if (this.handler != null) {
            cvJ();
            this.handler.obtainMessage(2, this.rOb).sendToTarget();
            return;
        }
        C4990ab.m7412e("MicroMsg.SoterMpBaseController", "hy: handler not bind");
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: G */
    public final void mo74368G(String[] strArr) {
        if (this.handler != null) {
            Message obtainMessage = this.handler.obtainMessage(3);
            Bundle bundle = new Bundle();
            bundle.putStringArray(NativeProtocol.RESULT_ARGS_PERMISSIONS, strArr);
            bundle.putInt("request_code", 0);
            obtainMessage.setData(bundle);
            obtainMessage.sendToTarget();
            return;
        }
        C4990ab.m7412e("MicroMsg.SoterMpBaseController", "hy: handler not bind");
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: a */
    public final void mo74369a(C7452b c7452b) {
        if (c7452b == null) {
            C4990ab.m7412e("MicroMsg.SoterMpBaseController", "hy: dialog is null.");
        } else if (this.handler != null) {
            cvJ();
            this.handler.obtainMessage(6, c7452b).sendToTarget();
        } else {
            C4990ab.m7412e("MicroMsg.SoterMpBaseController", "hy: handler not bind");
        }
    }
}
