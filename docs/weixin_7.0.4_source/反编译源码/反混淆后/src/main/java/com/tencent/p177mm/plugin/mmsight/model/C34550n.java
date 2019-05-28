package com.tencent.p177mm.plugin.mmsight.model;

import android.content.Context;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.p221e.C32468d;
import com.tencent.p177mm.compatible.p221e.C32468d.C32469a.C32470a;
import com.tencent.p177mm.compatible.p221e.C41938t;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.mmsight.model.n */
final class C34550n {
    boolean fbr = false;
    C32470a fbs;
    final Object lock = new byte[0];

    C34550n() {
        AppMethodBeat.m2504i(76544);
        AppMethodBeat.m2505o(76544);
    }

    /* renamed from: R */
    public final C32470a mo55080R(Context context, int i) {
        AppMethodBeat.m2504i(76545);
        if (context == null) {
            AppMethodBeat.m2505o(76545);
            return null;
        }
        final long anU = C5046bo.anU();
        final long id = Thread.currentThread().getId();
        synchronized (this.lock) {
            try {
                this.fbr = false;
                this.fbs = null;
                final Context context2 = context;
                final int i2 = i;
                C7305d.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(76543);
                        C4990ab.m7417i("MicroMsg.SightCamera.OpenCameraThread", "Start Open Camera thread[parent:%d this:%d] time:%d", Long.valueOf(id), Long.valueOf(Thread.currentThread().getId()), Long.valueOf(C5046bo.anU() - anU));
                        synchronized (C34550n.this.lock) {
                            try {
                                C34550n.this.fbs = C32468d.m53155a(context2, i2, Looper.getMainLooper());
                            } catch (Exception e) {
                                C4990ab.m7413e("MicroMsg.SightCamera.OpenCameraThread", "openCamera failed e:%s", e.getMessage());
                                C34550n.this.fbs = null;
                            } catch (Throwable th) {
                                AppMethodBeat.m2505o(76543);
                            }
                            if (C34550n.this.fbr && C34550n.this.fbs != null) {
                                C4990ab.m7413e("MicroMsg.SightCamera.OpenCameraThread", "thread time out now, release camera :%d ", Long.valueOf(C5046bo.anU() - anU));
                                try {
                                    C41938t c41938t = C34550n.this.fbs.erH;
                                    c41938t.setPreviewCallback(null);
                                    c41938t.stopPreview();
                                    c41938t.release();
                                    C34550n.this.fbs = null;
                                } catch (Exception e2) {
                                    C4990ab.m7413e("MicroMsg.SightCamera.OpenCameraThread", "realease Camera failed e:%s", e2.getMessage());
                                }
                            }
                            C34550n.this.lock.notify();
                        }
                        AppMethodBeat.m2505o(76543);
                    }
                }, "SightCamera_openCamera");
                this.lock.wait(30000);
            } catch (InterruptedException e) {
                C4990ab.m7413e("MicroMsg.SightCamera.OpenCameraThread", "Lock wait failed e:%s", e.getMessage());
            } catch (Throwable th) {
                AppMethodBeat.m2505o(76545);
            }
            if (this.fbs == null || this.fbs.erH == null) {
                this.fbr = true;
                C4990ab.m7413e("MicroMsg.SightCamera.OpenCameraThread", "Open Camera Timeout:%d", Long.valueOf(C5046bo.anU() - anU));
                AppMethodBeat.m2505o(76545);
                return null;
            }
            C4990ab.m7417i("MicroMsg.SightCamera.OpenCameraThread", "Open Camera Succ thread:%d Time:%d camera:%s", Long.valueOf(id), Long.valueOf(C5046bo.anU() - anU), this.fbs.erH);
            C32470a c32470a = this.fbs;
            AppMethodBeat.m2505o(76545);
            return c32470a;
        }
    }
}
