package com.tencent.mm.plugin.mmsight.model;

import android.content.Context;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.e.d.a.a;
import com.tencent.mm.compatible.e.t;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

final class n {
    boolean fbr = false;
    a fbs;
    final Object lock = new byte[0];

    n() {
        AppMethodBeat.i(76544);
        AppMethodBeat.o(76544);
    }

    public final a R(Context context, int i) {
        AppMethodBeat.i(76545);
        if (context == null) {
            AppMethodBeat.o(76545);
            return null;
        }
        final long anU = bo.anU();
        final long id = Thread.currentThread().getId();
        synchronized (this.lock) {
            try {
                this.fbr = false;
                this.fbs = null;
                final Context context2 = context;
                final int i2 = i;
                d.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(76543);
                        ab.i("MicroMsg.SightCamera.OpenCameraThread", "Start Open Camera thread[parent:%d this:%d] time:%d", Long.valueOf(id), Long.valueOf(Thread.currentThread().getId()), Long.valueOf(bo.anU() - anU));
                        synchronized (n.this.lock) {
                            try {
                                n.this.fbs = com.tencent.mm.compatible.e.d.a(context2, i2, Looper.getMainLooper());
                            } catch (Exception e) {
                                ab.e("MicroMsg.SightCamera.OpenCameraThread", "openCamera failed e:%s", e.getMessage());
                                n.this.fbs = null;
                            } catch (Throwable th) {
                                AppMethodBeat.o(76543);
                            }
                            if (n.this.fbr && n.this.fbs != null) {
                                ab.e("MicroMsg.SightCamera.OpenCameraThread", "thread time out now, release camera :%d ", Long.valueOf(bo.anU() - anU));
                                try {
                                    t tVar = n.this.fbs.erH;
                                    tVar.setPreviewCallback(null);
                                    tVar.stopPreview();
                                    tVar.release();
                                    n.this.fbs = null;
                                } catch (Exception e2) {
                                    ab.e("MicroMsg.SightCamera.OpenCameraThread", "realease Camera failed e:%s", e2.getMessage());
                                }
                            }
                            n.this.lock.notify();
                        }
                        AppMethodBeat.o(76543);
                    }
                }, "SightCamera_openCamera");
                this.lock.wait(30000);
            } catch (InterruptedException e) {
                ab.e("MicroMsg.SightCamera.OpenCameraThread", "Lock wait failed e:%s", e.getMessage());
            } catch (Throwable th) {
                AppMethodBeat.o(76545);
            }
            if (this.fbs == null || this.fbs.erH == null) {
                this.fbr = true;
                ab.e("MicroMsg.SightCamera.OpenCameraThread", "Open Camera Timeout:%d", Long.valueOf(bo.anU() - anU));
                AppMethodBeat.o(76545);
                return null;
            }
            ab.i("MicroMsg.SightCamera.OpenCameraThread", "Open Camera Succ thread:%d Time:%d camera:%s", Long.valueOf(id), Long.valueOf(bo.anU() - anU), this.fbs.erH);
            a aVar = this.fbs;
            AppMethodBeat.o(76545);
            return aVar;
        }
    }
}
