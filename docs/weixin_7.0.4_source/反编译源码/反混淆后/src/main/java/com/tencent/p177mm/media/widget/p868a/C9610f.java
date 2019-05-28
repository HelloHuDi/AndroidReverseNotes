package com.tencent.p177mm.media.widget.p868a;

import android.content.Context;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.p221e.C32468d;
import com.tencent.p177mm.compatible.p221e.C32468d.C32469a.C32470a;
import com.tencent.p177mm.compatible.p221e.C41938t;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import p000a.C0220l;
import p000a.C37091y;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J&\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, dWq = {"Lcom/tencent/mm/media/widget/camera/OpenCameraThread;", "", "()V", "TAG", "", "isTimeouted", "", "lock", "Ljava/lang/Object;", "res", "Lcom/tencent/mm/compatible/deviceinfo/CameraUtil$IImpl$OpenCameraRes;", "openCamera", "context", "Landroid/content/Context;", "nowCameraId", "", "looper", "Landroid/os/Looper;", "plugin-mediaeditor_release"})
/* renamed from: com.tencent.mm.media.widget.a.f */
public final class C9610f {
    final String TAG = "MicroMsg.SightCamera.OpenCameraThread";
    boolean fbr;
    C32470a fbs;
    final Object lock = new Object();

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, dWq = {"<anonymous>", "", "run", "com/tencent/mm/media/widget/camera/OpenCameraThread$openCamera$1$1"})
    /* renamed from: com.tencent.mm.media.widget.a.f$a */
    static final class C9611a implements Runnable {
        final /* synthetic */ C9610f fbt;
        final /* synthetic */ long fbu;
        final /* synthetic */ long fbv;
        final /* synthetic */ Context fbw;
        final /* synthetic */ int fbx;
        final /* synthetic */ Looper fby;

        C9611a(C9610f c9610f, long j, long j2, Context context, int i, Looper looper) {
            this.fbt = c9610f;
            this.fbu = j;
            this.fbv = j2;
            this.fbw = context;
            this.fbx = i;
            this.fby = looper;
        }

        public final void run() {
            AppMethodBeat.m2504i(13225);
            Object[] objArr = new Object[3];
            objArr[0] = Long.valueOf(this.fbu);
            Thread currentThread = Thread.currentThread();
            C25052j.m39375o(currentThread, "Thread.currentThread()");
            objArr[1] = Long.valueOf(currentThread.getId());
            objArr[2] = Long.valueOf(C5046bo.anU() - this.fbv);
            C4990ab.m7417i(this.fbt.TAG, "Start Open Camera thread[parent:%d this:%d] time:%d", objArr);
            synchronized (this.fbt.lock) {
                try {
                    this.fbt.fbs = C32468d.m53155a(this.fbw, this.fbx, this.fby);
                } catch (Exception e) {
                    C4990ab.m7413e(this.fbt.TAG, "openCamera failed e:%s", e.getMessage());
                    this.fbt.fbs = null;
                } catch (Throwable th) {
                    AppMethodBeat.m2505o(13225);
                }
                if (this.fbt.fbr && this.fbt.fbs != null) {
                    C4990ab.m7413e(this.fbt.TAG, "thread time out now, release camera :%d ", Long.valueOf(C5046bo.anU() - this.fbv));
                    try {
                        C32470a c32470a = this.fbt.fbs;
                        if (c32470a == null) {
                            C25052j.dWJ();
                        }
                        C41938t c41938t = c32470a.erH;
                        c41938t.setPreviewCallback(null);
                        c41938t.stopPreview();
                        c41938t.release();
                        this.fbt.fbs = null;
                    } catch (Exception e2) {
                        C4990ab.m7413e(this.fbt.TAG, "realease Camera failed e:%s", e2.getMessage());
                    }
                }
                this.fbt.lock.notify();
                C37091y c37091y = C37091y.AUy;
            }
            AppMethodBeat.m2505o(13225);
        }
    }

    public C9610f() {
        AppMethodBeat.m2504i(13227);
        AppMethodBeat.m2505o(13227);
    }

    /* renamed from: a */
    public final C32470a mo20922a(Context context, int i, Looper looper) {
        AppMethodBeat.m2504i(13226);
        if (context == null) {
            AppMethodBeat.m2505o(13226);
            return null;
        }
        long anU = C5046bo.anU();
        Thread currentThread = Thread.currentThread();
        C25052j.m39375o(currentThread, "Thread.currentThread()");
        long id = currentThread.getId();
        synchronized (this.lock) {
            try {
                this.fbr = false;
                this.fbs = null;
                C7305d.post(new C9611a(this, id, anU, context, i, looper), "SightCamera_openCamera");
                this.lock.wait(30000);
            } catch (InterruptedException e) {
                C4990ab.m7413e(this.TAG, "Lock wait failed e:%s", e.getMessage());
            } catch (Throwable th) {
                AppMethodBeat.m2505o(13226);
            }
            if (this.fbs != null) {
                C32470a c32470a = this.fbs;
                if (c32470a == null) {
                    C25052j.dWJ();
                }
                if (c32470a.erH != null) {
                    String str = this.TAG;
                    String str2 = "Open Camera Succ thread:%d Time:%d camera:%s";
                    Object[] objArr = new Object[3];
                    objArr[0] = Long.valueOf(id);
                    objArr[1] = Long.valueOf(C5046bo.anU() - anU);
                    C32470a c32470a2 = this.fbs;
                    if (c32470a2 == null) {
                        C25052j.dWJ();
                    }
                    objArr[2] = c32470a2.erH;
                    C4990ab.m7417i(str, str2, objArr);
                    c32470a = this.fbs;
                    AppMethodBeat.m2505o(13226);
                    return c32470a;
                }
            }
            this.fbr = true;
            C4990ab.m7413e(this.TAG, "Open Camera Timeout:%d", Long.valueOf(C5046bo.anU() - anU));
            AppMethodBeat.m2505o(13226);
            return null;
        }
    }
}
