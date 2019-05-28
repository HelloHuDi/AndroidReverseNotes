package com.tencent.liteav.videoencoder;

import android.opengl.GLES20;
import android.os.Bundle;
import com.google.android.gms.wearable.WearableStatusCodes;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import com.tencent.liteav.basic.util.c;
import com.tencent.liteav.beauty.b.k;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.rtmp.TXLiveConstants;
import com.tencent.ttpic.util.ActUtil;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Timer;
import java.util.TimerTask;
import javax.microedition.khronos.egl.EGLContext;

public class b extends com.tencent.liteav.basic.module.a {
    private static Integer r = Integer.valueOf(1);
    private static final String u = b.class.getSimpleName();
    private static int v = 0;
    private c a = null;
    private d b = null;
    private WeakReference<com.tencent.liteav.basic.d.a> c = null;
    private int d = 0;
    private int e = 2;
    private int f = 1;
    private Timer g = null;
    private TimerTask h = null;
    private LinkedList<Runnable> i = new LinkedList();
    private TXSVideoEncoderParam j;
    private float k = 0.0f;
    private float l = 0.0f;
    private float m = 0.0f;
    private int n = 0;
    private int o = 0;
    private com.tencent.liteav.basic.e.b p;
    private c q;
    private boolean s;
    private k t;

    static class a extends TimerTask {
        private WeakReference<b> a;

        public a(b bVar) {
            AppMethodBeat.i(67410);
            this.a = new WeakReference(bVar);
            AppMethodBeat.o(67410);
        }

        public void run() {
            AppMethodBeat.i(67411);
            if (this.a == null) {
                AppMethodBeat.o(67411);
                return;
            }
            b bVar = (b) this.a.get();
            if (bVar == null) {
                AppMethodBeat.o(67411);
            } else if (bVar.n < bVar.o) {
                int[] a = com.tencent.liteav.basic.util.b.a();
                b.k(bVar);
                bVar.k = bVar.k + ((float) (a[0] / 10));
                bVar.l = ((float) (a[1] / 10)) + bVar.l;
                bVar.m = bVar.m + ((float) ((bVar.b() * 100) / ((long) bVar.j.fps)));
                AppMethodBeat.o(67411);
            } else {
                if (com.tencent.liteav.basic.f.b.a().a(bVar.k / ((float) bVar.o), bVar.l / ((float) bVar.o), bVar.m / ((float) bVar.o)) && com.tencent.liteav.basic.f.b.a().c() != 0) {
                    b.o(bVar);
                }
                b.p(bVar);
                AppMethodBeat.o(67411);
            }
        }
    }

    static /* synthetic */ int k(b bVar) {
        int i = bVar.n + 1;
        bVar.n = i;
        return i;
    }

    static /* synthetic */ void o(b bVar) {
        AppMethodBeat.i(67433);
        bVar.e();
        AppMethodBeat.o(67433);
    }

    static /* synthetic */ void p(b bVar) {
        AppMethodBeat.i(67434);
        bVar.d();
        AppMethodBeat.o(67434);
    }

    static {
        AppMethodBeat.i(67435);
        AppMethodBeat.o(67435);
    }

    public b(int i) {
        AppMethodBeat.i(67414);
        this.e = i;
        AppMethodBeat.o(67414);
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x00a7  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int a(TXSVideoEncoderParam tXSVideoEncoderParam) {
        int c;
        AppMethodBeat.i(67415);
        this.j = tXSVideoEncoderParam;
        if (tXSVideoEncoderParam.enableBlackList) {
            c = com.tencent.liteav.basic.f.b.a().c();
        } else {
            c = 2;
        }
        if (this.e == 1 && c != 0) {
            this.a = new a();
            this.f = 1;
            a(1008, "启动硬编", 1);
        } else if (this.e == 3 && tXSVideoEncoderParam.width == 720 && tXSVideoEncoderParam.height == ActUtil.HEIGHT && c != 0) {
            this.a = new a();
            this.f = 1;
            a(1008, "启动硬编", 1);
        } else {
            this.a = new TXCSWVideoEncoder();
            this.f = 2;
            a(1008, "启动软编", 2);
        }
        setStatusValue(WearableStatusCodes.INVALID_TARGET_NODE, Long.valueOf((long) this.f));
        if (this.a != null) {
            if (this.b != null) {
                this.a.setListener(this.b);
            }
            if (this.d != 0) {
                this.a.setBitrate(this.d);
            }
            this.a.setID(getID());
            c = this.a.start(tXSVideoEncoderParam);
            if (c != 0) {
                AppMethodBeat.o(67415);
            }
            if (this.e == 3) {
                this.k = 0.0f;
                this.l = 0.0f;
                this.m = 0.0f;
                this.n = 0;
                this.o = com.tencent.liteav.basic.f.b.a().f();
                c();
            }
            AppMethodBeat.o(67415);
        } else {
            c = 10000002;
            if (this.e == 3) {
            }
            AppMethodBeat.o(67415);
        }
        return c;
    }

    public void setID(String str) {
        AppMethodBeat.i(67416);
        super.setID(str);
        if (this.a != null) {
            this.a.setID(str);
        }
        setStatusValue(WearableStatusCodes.INVALID_TARGET_NODE, Long.valueOf((long) this.f));
        AppMethodBeat.o(67416);
    }

    public EGLContext a(final int i, final int i2) {
        AppMethodBeat.i(67417);
        EGLContext c;
        if (!this.s) {
            this.s = true;
            synchronized (r) {
                try {
                    StringBuilder stringBuilder = new StringBuilder("CVGLThread");
                    Integer num = r;
                    r = Integer.valueOf(r.intValue() + 1);
                    this.q = new c(stringBuilder.append(num).toString());
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.o(67417);
                }
            }
            final boolean[] zArr = new boolean[1];
            this.q.a(new Runnable() {
                public void run() {
                    boolean z;
                    AppMethodBeat.i(67361);
                    b.this.p = com.tencent.liteav.basic.e.b.a(null, null, null, i, i2);
                    boolean[] zArr = zArr;
                    if (b.this.p != null) {
                        z = true;
                    } else {
                        z = false;
                    }
                    zArr[0] = z;
                    AppMethodBeat.o(67361);
                }
            });
            if (zArr[0]) {
                c = this.p.c();
                return c;
            }
            AppMethodBeat.o(67417);
            return null;
        } else if (this.p != null) {
            c = this.p.c();
            AppMethodBeat.o(67417);
            return c;
        } else {
            AppMethodBeat.o(67417);
            return null;
        }
    }

    /* Access modifiers changed, original: protected */
    public void a(Runnable runnable) {
        AppMethodBeat.i(67418);
        synchronized (this.i) {
            try {
                this.i.add(runnable);
            } finally {
                while (true) {
                }
                AppMethodBeat.o(67418);
            }
        }
    }

    /* JADX WARNING: Missing block: B:9:0x001b, code skipped:
            if (r0 != null) goto L_0x0028;
     */
    /* JADX WARNING: Missing block: B:10:0x001d, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.o(67419);
     */
    /* JADX WARNING: Missing block: B:15:0x0028, code skipped:
            r0.run();
            com.tencent.matrix.trace.core.AppMethodBeat.o(67419);
     */
    /* JADX WARNING: Missing block: B:20:?, code skipped:
            return false;
     */
    /* JADX WARNING: Missing block: B:21:?, code skipped:
            return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean a(Queue<Runnable> queue) {
        AppMethodBeat.i(67419);
        synchronized (queue) {
            try {
                if (queue.isEmpty()) {
                } else {
                    Runnable runnable = (Runnable) queue.poll();
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(67419);
            }
        }
        return false;
    }

    public long a(byte[] bArr, int i, int i2, int i3, long j) {
        AppMethodBeat.i(67420);
        if (this.p == null) {
            AppMethodBeat.o(67420);
            return -1;
        }
        final int i4 = i2;
        final int i5 = i3;
        final int i6 = i;
        final byte[] bArr2 = bArr;
        final long j2 = j;
        this.q.b(new Runnable() {
            public void run() {
                AppMethodBeat.i(67438);
                if (!(b.this.t != null && b.this.t.n() == i4 && b.this.t.o() == i5)) {
                    if (b.this.t != null) {
                        b.this.t.d();
                        b.this.t = null;
                    }
                    b.this.t = new k(i6);
                    if (b.this.t.a()) {
                        b.this.t.a(true);
                        b.this.t.a(i4, i5);
                    } else {
                        b.this.p.b();
                        b.this.p = null;
                        b.this.t = null;
                        AppMethodBeat.o(67438);
                        return;
                    }
                }
                b.this.t.a(bArr2);
                GLES20.glViewport(0, 0, i4, i5);
                int q = b.this.t.q();
                GLES20.glFlush();
                b bVar = b.this;
                bVar.a(q, bVar.j.width, b.this.j.height, j2);
                AppMethodBeat.o(67438);
            }
        });
        AppMethodBeat.o(67420);
        return 0;
    }

    public void a() {
        AppMethodBeat.i(67421);
        if (this.q != null) {
            final com.tencent.liteav.basic.e.b bVar = this.p;
            this.q.b(new Runnable() {
                public void run() {
                    AppMethodBeat.i(67362);
                    b.this.i.clear();
                    if (b.this.a != null) {
                        b.this.a.stop();
                    }
                    if (b.this.t != null) {
                        b.this.t.d();
                        b.this.t = null;
                    }
                    if (bVar != null) {
                        bVar.b();
                    }
                    AppMethodBeat.o(67362);
                }
            });
            this.q = null;
            this.p = null;
        } else {
            this.i.clear();
            if (this.a != null) {
                this.a.stop();
            }
        }
        if (this.e == 3) {
            this.k = 0.0f;
            this.l = 0.0f;
            this.m = 0.0f;
            this.n = 0;
            d();
        }
        this.b = null;
        this.d = 0;
        AppMethodBeat.o(67421);
    }

    public long a(int i, int i2, int i3, long j) {
        AppMethodBeat.i(67422);
        long j2 = 10000002;
        do {
        } while (a(this.i));
        if (this.a != null) {
            j2 = this.a.pushVideoFrame(i, i2, i3, j);
        }
        AppMethodBeat.o(67422);
        return j2;
    }

    public void a(com.tencent.liteav.basic.d.a aVar) {
        AppMethodBeat.i(67423);
        this.c = new WeakReference(aVar);
        AppMethodBeat.o(67423);
    }

    public void a(d dVar) {
        AppMethodBeat.i(67424);
        this.b = dVar;
        a(new Runnable() {
            public void run() {
                AppMethodBeat.i(67413);
                if (b.this.a != null) {
                    b.this.a.setListener(b.this.b);
                }
                AppMethodBeat.o(67413);
            }
        });
        AppMethodBeat.o(67424);
    }

    public void a(int i) {
        AppMethodBeat.i(67425);
        this.d = i;
        a(new Runnable() {
            public void run() {
                AppMethodBeat.i(67436);
                if (b.this.a != null) {
                    b.this.a.setBitrate(b.this.d);
                }
                AppMethodBeat.o(67436);
            }
        });
        AppMethodBeat.o(67425);
    }

    public long b() {
        AppMethodBeat.i(67426);
        long j = 0;
        if (this.a != null) {
            j = this.a.getRealFPS();
        }
        AppMethodBeat.o(67426);
        return j;
    }

    private void c() {
        AppMethodBeat.i(67427);
        if (this.h == null) {
            this.h = new a(this);
        }
        this.g = new Timer();
        this.g.schedule(this.h, 1000, 1000);
        AppMethodBeat.o(67427);
    }

    private void d() {
        AppMethodBeat.i(67428);
        if (this.g != null) {
            this.g.cancel();
            this.g = null;
        }
        if (this.h != null) {
            this.h = null;
        }
        AppMethodBeat.o(67428);
    }

    private void a(int i, String str) {
        AppMethodBeat.i(67429);
        if (this.c == null) {
            AppMethodBeat.o(67429);
            return;
        }
        com.tencent.liteav.basic.d.a aVar = (com.tencent.liteav.basic.d.a) this.c.get();
        if (aVar == null) {
            AppMethodBeat.o(67429);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("EVT_ID", i);
        bundle.putLong("EVT_TIME", TXCTimeUtil.getTimeTick());
        bundle.putCharSequence(TXLiveConstants.EVT_DESCRIPTION, str);
        aVar.onNotifyEvent(i, bundle);
        AppMethodBeat.o(67429);
    }

    private void a(int i, String str, int i2) {
        AppMethodBeat.i(67430);
        if (this.c == null) {
            AppMethodBeat.o(67430);
            return;
        }
        com.tencent.liteav.basic.d.a aVar = (com.tencent.liteav.basic.d.a) this.c.get();
        if (aVar == null) {
            AppMethodBeat.o(67430);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("EVT_ID", i);
        bundle.putLong("EVT_TIME", TXCTimeUtil.getTimeTick());
        bundle.putCharSequence(TXLiveConstants.EVT_DESCRIPTION, str);
        bundle.putInt("EVT_PARAM1", i2);
        aVar.onNotifyEvent(i, bundle);
        AppMethodBeat.o(67430);
    }

    private void e() {
        AppMethodBeat.i(67431);
        a(new Runnable() {
            public void run() {
                AppMethodBeat.i(67445);
                b.a(b.this, 1107, "软编切硬编");
                if (b.this.a != null) {
                    b.this.a.setListener(null);
                    b.this.a.stop();
                }
                b.this.a = new a();
                b.this.f = 1;
                b.this.setStatusValue(WearableStatusCodes.INVALID_TARGET_NODE, Long.valueOf((long) b.this.f));
                b.this.a.start(b.this.j);
                if (b.this.b != null) {
                    b.this.a.setListener(b.this.b);
                }
                if (b.this.d != 0) {
                    b.this.a.setBitrate(b.this.d);
                }
                b.this.a.setID(b.this.getID());
                AppMethodBeat.o(67445);
            }
        });
        TXCLog.w("TXCVideoEncoder", "switchSWToHW");
        AppMethodBeat.o(67431);
    }
}
