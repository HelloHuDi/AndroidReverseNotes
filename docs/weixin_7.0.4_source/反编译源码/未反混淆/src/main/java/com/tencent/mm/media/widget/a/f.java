package com.tencent.mm.media.widget.a;

import a.f.b.j;
import a.l;
import a.y;
import android.content.Context;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.e.d;
import com.tencent.mm.compatible.e.t;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

@l(dWo = {1, 1, 13}, dWp = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J&\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, dWq = {"Lcom/tencent/mm/media/widget/camera/OpenCameraThread;", "", "()V", "TAG", "", "isTimeouted", "", "lock", "Ljava/lang/Object;", "res", "Lcom/tencent/mm/compatible/deviceinfo/CameraUtil$IImpl$OpenCameraRes;", "openCamera", "context", "Landroid/content/Context;", "nowCameraId", "", "looper", "Landroid/os/Looper;", "plugin-mediaeditor_release"})
public final class f {
    final String TAG = "MicroMsg.SightCamera.OpenCameraThread";
    boolean fbr;
    com.tencent.mm.compatible.e.d.a.a fbs;
    final Object lock = new Object();

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, dWq = {"<anonymous>", "", "run", "com/tencent/mm/media/widget/camera/OpenCameraThread$openCamera$1$1"})
    static final class a implements Runnable {
        final /* synthetic */ f fbt;
        final /* synthetic */ long fbu;
        final /* synthetic */ long fbv;
        final /* synthetic */ Context fbw;
        final /* synthetic */ int fbx;
        final /* synthetic */ Looper fby;

        a(f fVar, long j, long j2, Context context, int i, Looper looper) {
            this.fbt = fVar;
            this.fbu = j;
            this.fbv = j2;
            this.fbw = context;
            this.fbx = i;
            this.fby = looper;
        }

        public final void run() {
            AppMethodBeat.i(13225);
            Object[] objArr = new Object[3];
            objArr[0] = Long.valueOf(this.fbu);
            Thread currentThread = Thread.currentThread();
            j.o(currentThread, "Thread.currentThread()");
            objArr[1] = Long.valueOf(currentThread.getId());
            objArr[2] = Long.valueOf(bo.anU() - this.fbv);
            ab.i(this.fbt.TAG, "Start Open Camera thread[parent:%d this:%d] time:%d", objArr);
            synchronized (this.fbt.lock) {
                try {
                    this.fbt.fbs = d.a(this.fbw, this.fbx, this.fby);
                } catch (Exception e) {
                    ab.e(this.fbt.TAG, "openCamera failed e:%s", e.getMessage());
                    this.fbt.fbs = null;
                } catch (Throwable th) {
                    AppMethodBeat.o(13225);
                }
                if (this.fbt.fbr && this.fbt.fbs != null) {
                    ab.e(this.fbt.TAG, "thread time out now, release camera :%d ", Long.valueOf(bo.anU() - this.fbv));
                    try {
                        com.tencent.mm.compatible.e.d.a.a aVar = this.fbt.fbs;
                        if (aVar == null) {
                            j.dWJ();
                        }
                        t tVar = aVar.erH;
                        tVar.setPreviewCallback(null);
                        tVar.stopPreview();
                        tVar.release();
                        this.fbt.fbs = null;
                    } catch (Exception e2) {
                        ab.e(this.fbt.TAG, "realease Camera failed e:%s", e2.getMessage());
                    }
                }
                this.fbt.lock.notify();
                y yVar = y.AUy;
            }
            AppMethodBeat.o(13225);
        }
    }

    public f() {
        AppMethodBeat.i(13227);
        AppMethodBeat.o(13227);
    }

    public final com.tencent.mm.compatible.e.d.a.a a(Context context, int i, Looper looper) {
        AppMethodBeat.i(13226);
        if (context == null) {
            AppMethodBeat.o(13226);
            return null;
        }
        long anU = bo.anU();
        Thread currentThread = Thread.currentThread();
        j.o(currentThread, "Thread.currentThread()");
        long id = currentThread.getId();
        synchronized (this.lock) {
            try {
                this.fbr = false;
                this.fbs = null;
                com.tencent.mm.sdk.g.d.post(new a(this, id, anU, context, i, looper), "SightCamera_openCamera");
                this.lock.wait(30000);
            } catch (InterruptedException e) {
                ab.e(this.TAG, "Lock wait failed e:%s", e.getMessage());
            } catch (Throwable th) {
                AppMethodBeat.o(13226);
            }
            if (this.fbs != null) {
                com.tencent.mm.compatible.e.d.a.a aVar = this.fbs;
                if (aVar == null) {
                    j.dWJ();
                }
                if (aVar.erH != null) {
                    String str = this.TAG;
                    String str2 = "Open Camera Succ thread:%d Time:%d camera:%s";
                    Object[] objArr = new Object[3];
                    objArr[0] = Long.valueOf(id);
                    objArr[1] = Long.valueOf(bo.anU() - anU);
                    com.tencent.mm.compatible.e.d.a.a aVar2 = this.fbs;
                    if (aVar2 == null) {
                        j.dWJ();
                    }
                    objArr[2] = aVar2.erH;
                    ab.i(str, str2, objArr);
                    aVar = this.fbs;
                    AppMethodBeat.o(13226);
                    return aVar;
                }
            }
            this.fbr = true;
            ab.e(this.TAG, "Open Camera Timeout:%d", Long.valueOf(bo.anU() - anU));
            AppMethodBeat.o(13226);
            return null;
        }
    }
}
