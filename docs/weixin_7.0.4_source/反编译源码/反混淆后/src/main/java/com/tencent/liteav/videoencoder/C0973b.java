package com.tencent.liteav.videoencoder;

import android.opengl.GLES20;
import android.os.Bundle;
import com.google.android.gms.wearable.WearableStatusCodes;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.module.C32147a;
import com.tencent.liteav.basic.p1169f.C45104b;
import com.tencent.liteav.basic.p140d.C0946a;
import com.tencent.liteav.basic.p141e.C32141b;
import com.tencent.liteav.basic.util.C17778b;
import com.tencent.liteav.basic.util.C17779c;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import com.tencent.liteav.beauty.p144b.C16520k;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.rtmp.TXLiveConstants;
import com.tencent.ttpic.util.ActUtil;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Timer;
import java.util.TimerTask;
import javax.microedition.khronos.egl.EGLContext;

/* renamed from: com.tencent.liteav.videoencoder.b */
public class C0973b extends C32147a {
    /* renamed from: r */
    private static Integer f1172r = Integer.valueOf(1);
    /* renamed from: u */
    private static final String f1173u = C0973b.class.getSimpleName();
    /* renamed from: v */
    private static int f1174v = 0;
    /* renamed from: a */
    private C0981c f1175a = null;
    /* renamed from: b */
    private C0982d f1176b = null;
    /* renamed from: c */
    private WeakReference<C0946a> f1177c = null;
    /* renamed from: d */
    private int f1178d = 0;
    /* renamed from: e */
    private int f1179e = 2;
    /* renamed from: f */
    private int f1180f = 1;
    /* renamed from: g */
    private Timer f1181g = null;
    /* renamed from: h */
    private TimerTask f1182h = null;
    /* renamed from: i */
    private LinkedList<Runnable> f1183i = new LinkedList();
    /* renamed from: j */
    private TXSVideoEncoderParam f1184j;
    /* renamed from: k */
    private float f1185k = 0.0f;
    /* renamed from: l */
    private float f1186l = 0.0f;
    /* renamed from: m */
    private float f1187m = 0.0f;
    /* renamed from: n */
    private int f1188n = 0;
    /* renamed from: o */
    private int f1189o = 0;
    /* renamed from: p */
    private C32141b f1190p;
    /* renamed from: q */
    private C17779c f1191q;
    /* renamed from: s */
    private boolean f1192s;
    /* renamed from: t */
    private C16520k f1193t;

    /* renamed from: com.tencent.liteav.videoencoder.b$4 */
    class C09764 implements Runnable {
        C09764() {
        }

        public void run() {
            AppMethodBeat.m2504i(67413);
            if (C0973b.this.f1175a != null) {
                C0973b.this.f1175a.setListener(C0973b.this.f1176b);
            }
            AppMethodBeat.m2505o(67413);
        }
    }

    /* renamed from: com.tencent.liteav.videoencoder.b$5 */
    class C09775 implements Runnable {
        C09775() {
        }

        public void run() {
            AppMethodBeat.m2504i(67436);
            if (C0973b.this.f1175a != null) {
                C0973b.this.f1175a.setBitrate(C0973b.this.f1178d);
            }
            AppMethodBeat.m2505o(67436);
        }
    }

    /* renamed from: com.tencent.liteav.videoencoder.b$6 */
    class C09786 implements Runnable {
        C09786() {
        }

        public void run() {
            AppMethodBeat.m2504i(67445);
            C0973b.m2206a(C0973b.this, 1107, "软编切硬编");
            if (C0973b.this.f1175a != null) {
                C0973b.this.f1175a.setListener(null);
                C0973b.this.f1175a.stop();
            }
            C0973b.this.f1175a = new C37378a();
            C0973b.this.f1180f = 1;
            C0973b.this.setStatusValue(WearableStatusCodes.INVALID_TARGET_NODE, Long.valueOf((long) C0973b.this.f1180f));
            C0973b.this.f1175a.start(C0973b.this.f1184j);
            if (C0973b.this.f1176b != null) {
                C0973b.this.f1175a.setListener(C0973b.this.f1176b);
            }
            if (C0973b.this.f1178d != 0) {
                C0973b.this.f1175a.setBitrate(C0973b.this.f1178d);
            }
            C0973b.this.f1175a.setID(C0973b.this.getID());
            AppMethodBeat.m2505o(67445);
        }
    }

    /* renamed from: com.tencent.liteav.videoencoder.b$a */
    static class C0979a extends TimerTask {
        /* renamed from: a */
        private WeakReference<C0973b> f1207a;

        public C0979a(C0973b c0973b) {
            AppMethodBeat.m2504i(67410);
            this.f1207a = new WeakReference(c0973b);
            AppMethodBeat.m2505o(67410);
        }

        public void run() {
            AppMethodBeat.m2504i(67411);
            if (this.f1207a == null) {
                AppMethodBeat.m2505o(67411);
                return;
            }
            C0973b c0973b = (C0973b) this.f1207a.get();
            if (c0973b == null) {
                AppMethodBeat.m2505o(67411);
            } else if (c0973b.f1188n < c0973b.f1189o) {
                int[] a = C17778b.m27747a();
                C0973b.m2222k(c0973b);
                c0973b.f1185k = c0973b.f1185k + ((float) (a[0] / 10));
                c0973b.f1186l = ((float) (a[1] / 10)) + c0973b.f1186l;
                c0973b.f1187m = c0973b.f1187m + ((float) ((c0973b.mo3925b() * 100) / ((long) c0973b.f1184j.fps)));
                AppMethodBeat.m2505o(67411);
            } else {
                if (C45104b.m82752a().mo72876a(c0973b.f1185k / ((float) c0973b.f1189o), c0973b.f1186l / ((float) c0973b.f1189o), c0973b.f1187m / ((float) c0973b.f1189o)) && C45104b.m82752a().mo72880c() != 0) {
                    C0973b.m2226o(c0973b);
                }
                C0973b.m2227p(c0973b);
                AppMethodBeat.m2505o(67411);
            }
        }
    }

    /* renamed from: k */
    static /* synthetic */ int m2222k(C0973b c0973b) {
        int i = c0973b.f1188n + 1;
        c0973b.f1188n = i;
        return i;
    }

    /* renamed from: o */
    static /* synthetic */ void m2226o(C0973b c0973b) {
        AppMethodBeat.m2504i(67433);
        c0973b.m2216e();
        AppMethodBeat.m2505o(67433);
    }

    /* renamed from: p */
    static /* synthetic */ void m2227p(C0973b c0973b) {
        AppMethodBeat.m2504i(67434);
        c0973b.m2214d();
        AppMethodBeat.m2505o(67434);
    }

    static {
        AppMethodBeat.m2504i(67435);
        AppMethodBeat.m2505o(67435);
    }

    public C0973b(int i) {
        AppMethodBeat.m2504i(67414);
        this.f1179e = i;
        AppMethodBeat.m2505o(67414);
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x00a7  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public int mo3916a(TXSVideoEncoderParam tXSVideoEncoderParam) {
        int c;
        AppMethodBeat.m2504i(67415);
        this.f1184j = tXSVideoEncoderParam;
        if (tXSVideoEncoderParam.enableBlackList) {
            c = C45104b.m82752a().mo72880c();
        } else {
            c = 2;
        }
        if (this.f1179e == 1 && c != 0) {
            this.f1175a = new C37378a();
            this.f1180f = 1;
            m2205a(1008, "启动硬编", 1);
        } else if (this.f1179e == 3 && tXSVideoEncoderParam.width == 720 && tXSVideoEncoderParam.height == ActUtil.HEIGHT && c != 0) {
            this.f1175a = new C37378a();
            this.f1180f = 1;
            m2205a(1008, "启动硬编", 1);
        } else {
            this.f1175a = new TXCSWVideoEncoder();
            this.f1180f = 2;
            m2205a(1008, "启动软编", 2);
        }
        setStatusValue(WearableStatusCodes.INVALID_TARGET_NODE, Long.valueOf((long) this.f1180f));
        if (this.f1175a != null) {
            if (this.f1176b != null) {
                this.f1175a.setListener(this.f1176b);
            }
            if (this.f1178d != 0) {
                this.f1175a.setBitrate(this.f1178d);
            }
            this.f1175a.setID(getID());
            c = this.f1175a.start(tXSVideoEncoderParam);
            if (c != 0) {
                AppMethodBeat.m2505o(67415);
            }
            if (this.f1179e == 3) {
                this.f1185k = 0.0f;
                this.f1186l = 0.0f;
                this.f1187m = 0.0f;
                this.f1188n = 0;
                this.f1189o = C45104b.m82752a().mo72883f();
                m2212c();
            }
            AppMethodBeat.m2505o(67415);
        } else {
            c = 10000002;
            if (this.f1179e == 3) {
            }
            AppMethodBeat.m2505o(67415);
        }
        return c;
    }

    public void setID(String str) {
        AppMethodBeat.m2504i(67416);
        super.setID(str);
        if (this.f1175a != null) {
            this.f1175a.setID(str);
        }
        setStatusValue(WearableStatusCodes.INVALID_TARGET_NODE, Long.valueOf((long) this.f1180f));
        AppMethodBeat.m2505o(67416);
    }

    /* renamed from: a */
    public EGLContext mo3919a(final int i, final int i2) {
        AppMethodBeat.m2504i(67417);
        EGLContext c;
        if (!this.f1192s) {
            this.f1192s = true;
            synchronized (f1172r) {
                try {
                    StringBuilder stringBuilder = new StringBuilder("CVGLThread");
                    Integer num = f1172r;
                    f1172r = Integer.valueOf(f1172r.intValue() + 1);
                    this.f1191q = new C17779c(stringBuilder.append(num).toString());
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.m2505o(67417);
                }
            }
            final boolean[] zArr = new boolean[1];
            this.f1191q.mo32893a(new Runnable() {
                public void run() {
                    boolean z;
                    AppMethodBeat.m2504i(67361);
                    C0973b.this.f1190p = C32141b.m52280a(null, null, null, i, i2);
                    boolean[] zArr = zArr;
                    if (C0973b.this.f1190p != null) {
                        z = true;
                    } else {
                        z = false;
                    }
                    zArr[0] = z;
                    AppMethodBeat.m2505o(67361);
                }
            });
            if (zArr[0]) {
                c = this.f1190p.mo52724c();
                return c;
            }
            AppMethodBeat.m2505o(67417);
            return null;
        } else if (this.f1190p != null) {
            c = this.f1190p.mo52724c();
            AppMethodBeat.m2505o(67417);
            return c;
        } else {
            AppMethodBeat.m2505o(67417);
            return null;
        }
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: a */
    public void mo3924a(Runnable runnable) {
        AppMethodBeat.m2504i(67418);
        synchronized (this.f1183i) {
            try {
                this.f1183i.add(runnable);
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(67418);
            }
        }
    }

    /* JADX WARNING: Missing block: B:9:0x001b, code skipped:
            if (r0 != null) goto L_0x0028;
     */
    /* JADX WARNING: Missing block: B:10:0x001d, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(67419);
     */
    /* JADX WARNING: Missing block: B:15:0x0028, code skipped:
            r0.run();
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(67419);
     */
    /* JADX WARNING: Missing block: B:20:?, code skipped:
            return false;
     */
    /* JADX WARNING: Missing block: B:21:?, code skipped:
            return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    private boolean m2207a(Queue<Runnable> queue) {
        AppMethodBeat.m2504i(67419);
        synchronized (queue) {
            try {
                if (queue.isEmpty()) {
                } else {
                    Runnable runnable = (Runnable) queue.poll();
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(67419);
            }
        }
        return false;
    }

    /* renamed from: a */
    public long mo3918a(byte[] bArr, int i, int i2, int i3, long j) {
        AppMethodBeat.m2504i(67420);
        if (this.f1190p == null) {
            AppMethodBeat.m2505o(67420);
            return -1;
        }
        final int i4 = i2;
        final int i5 = i3;
        final int i6 = i;
        final byte[] bArr2 = bArr;
        final long j2 = j;
        this.f1191q.mo32894b(new Runnable() {
            public void run() {
                AppMethodBeat.m2504i(67438);
                if (!(C0973b.this.f1193t != null && C0973b.this.f1193t.mo19892n() == i4 && C0973b.this.f1193t.mo19893o() == i5)) {
                    if (C0973b.this.f1193t != null) {
                        C0973b.this.f1193t.mo19883d();
                        C0973b.this.f1193t = null;
                    }
                    C0973b.this.f1193t = new C16520k(i6);
                    if (C0973b.this.f1193t.mo19876a()) {
                        C0973b.this.f1193t.mo19873a(true);
                        C0973b.this.f1193t.mo3839a(i4, i5);
                    } else {
                        C0973b.this.f1190p.mo52723b();
                        C0973b.this.f1190p = null;
                        C0973b.this.f1193t = null;
                        AppMethodBeat.m2505o(67438);
                        return;
                    }
                }
                C0973b.this.f1193t.mo30453a(bArr2);
                GLES20.glViewport(0, 0, i4, i5);
                int q = C0973b.this.f1193t.mo30454q();
                GLES20.glFlush();
                C0973b c0973b = C0973b.this;
                c0973b.mo3917a(q, c0973b.f1184j.width, C0973b.this.f1184j.height, j2);
                AppMethodBeat.m2505o(67438);
            }
        });
        AppMethodBeat.m2505o(67420);
        return 0;
    }

    /* renamed from: a */
    public void mo3920a() {
        AppMethodBeat.m2504i(67421);
        if (this.f1191q != null) {
            final C32141b c32141b = this.f1190p;
            this.f1191q.mo32894b(new Runnable() {
                public void run() {
                    AppMethodBeat.m2504i(67362);
                    C0973b.this.f1183i.clear();
                    if (C0973b.this.f1175a != null) {
                        C0973b.this.f1175a.stop();
                    }
                    if (C0973b.this.f1193t != null) {
                        C0973b.this.f1193t.mo19883d();
                        C0973b.this.f1193t = null;
                    }
                    if (c32141b != null) {
                        c32141b.mo52723b();
                    }
                    AppMethodBeat.m2505o(67362);
                }
            });
            this.f1191q = null;
            this.f1190p = null;
        } else {
            this.f1183i.clear();
            if (this.f1175a != null) {
                this.f1175a.stop();
            }
        }
        if (this.f1179e == 3) {
            this.f1185k = 0.0f;
            this.f1186l = 0.0f;
            this.f1187m = 0.0f;
            this.f1188n = 0;
            m2214d();
        }
        this.f1176b = null;
        this.f1178d = 0;
        AppMethodBeat.m2505o(67421);
    }

    /* renamed from: a */
    public long mo3917a(int i, int i2, int i3, long j) {
        AppMethodBeat.m2504i(67422);
        long j2 = 10000002;
        do {
        } while (m2207a(this.f1183i));
        if (this.f1175a != null) {
            j2 = this.f1175a.pushVideoFrame(i, i2, i3, j);
        }
        AppMethodBeat.m2505o(67422);
        return j2;
    }

    /* renamed from: a */
    public void mo3922a(C0946a c0946a) {
        AppMethodBeat.m2504i(67423);
        this.f1177c = new WeakReference(c0946a);
        AppMethodBeat.m2505o(67423);
    }

    /* renamed from: a */
    public void mo3923a(C0982d c0982d) {
        AppMethodBeat.m2504i(67424);
        this.f1176b = c0982d;
        mo3924a(new C09764());
        AppMethodBeat.m2505o(67424);
    }

    /* renamed from: a */
    public void mo3921a(int i) {
        AppMethodBeat.m2504i(67425);
        this.f1178d = i;
        mo3924a(new C09775());
        AppMethodBeat.m2505o(67425);
    }

    /* renamed from: b */
    public long mo3925b() {
        AppMethodBeat.m2504i(67426);
        long j = 0;
        if (this.f1175a != null) {
            j = this.f1175a.getRealFPS();
        }
        AppMethodBeat.m2505o(67426);
        return j;
    }

    /* renamed from: c */
    private void m2212c() {
        AppMethodBeat.m2504i(67427);
        if (this.f1182h == null) {
            this.f1182h = new C0979a(this);
        }
        this.f1181g = new Timer();
        this.f1181g.schedule(this.f1182h, 1000, 1000);
        AppMethodBeat.m2505o(67427);
    }

    /* renamed from: d */
    private void m2214d() {
        AppMethodBeat.m2504i(67428);
        if (this.f1181g != null) {
            this.f1181g.cancel();
            this.f1181g = null;
        }
        if (this.f1182h != null) {
            this.f1182h = null;
        }
        AppMethodBeat.m2505o(67428);
    }

    /* renamed from: a */
    private void m2204a(int i, String str) {
        AppMethodBeat.m2504i(67429);
        if (this.f1177c == null) {
            AppMethodBeat.m2505o(67429);
            return;
        }
        C0946a c0946a = (C0946a) this.f1177c.get();
        if (c0946a == null) {
            AppMethodBeat.m2505o(67429);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("EVT_ID", i);
        bundle.putLong("EVT_TIME", TXCTimeUtil.getTimeTick());
        bundle.putCharSequence(TXLiveConstants.EVT_DESCRIPTION, str);
        c0946a.onNotifyEvent(i, bundle);
        AppMethodBeat.m2505o(67429);
    }

    /* renamed from: a */
    private void m2205a(int i, String str, int i2) {
        AppMethodBeat.m2504i(67430);
        if (this.f1177c == null) {
            AppMethodBeat.m2505o(67430);
            return;
        }
        C0946a c0946a = (C0946a) this.f1177c.get();
        if (c0946a == null) {
            AppMethodBeat.m2505o(67430);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("EVT_ID", i);
        bundle.putLong("EVT_TIME", TXCTimeUtil.getTimeTick());
        bundle.putCharSequence(TXLiveConstants.EVT_DESCRIPTION, str);
        bundle.putInt("EVT_PARAM1", i2);
        c0946a.onNotifyEvent(i, bundle);
        AppMethodBeat.m2505o(67430);
    }

    /* renamed from: e */
    private void m2216e() {
        AppMethodBeat.m2504i(67431);
        mo3924a(new C09786());
        TXCLog.m15679w("TXCVideoEncoder", "switchSWToHW");
        AppMethodBeat.m2505o(67431);
    }
}
