package com.tencent.liteav.screencapture;

import android.annotation.TargetApi;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.hardware.display.VirtualDisplay;
import android.media.projection.MediaProjection;
import android.media.projection.MediaProjection.Callback;
import android.media.projection.MediaProjectionManager;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.view.Surface;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.rtmp.TXLiveConstants;
import com.tencent.rtmp.video.TXScreenCapture.TXScreenCaptureAssistantActivity;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

@TargetApi(21)
public class b {
    private static final String b = b.class.getSimpleName();
    private static b c = new b();
    Callback a;
    private HashMap<Surface, VirtualDisplay> d;
    private Context e;
    private MediaProjectionManager f;
    private MediaProjection g;
    private HashSet<b> h;
    private int i;
    private Handler j;
    private HashSet<Object> k;
    private boolean l;
    private WeakReference<com.tencent.liteav.basic.d.a> m;
    private HandlerThread n;
    private Handler o;
    private int p;
    private HashSet<a> q;
    private Runnable r;
    private BroadcastReceiver s;

    public interface a {
        void a(int i);
    }

    class b {
        Surface a;
        int b;
        int c;

        private b() {
        }

        /* synthetic */ b(b bVar, AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    static /* synthetic */ void a(b bVar, int i, int i2, Intent intent) {
        AppMethodBeat.i(66788);
        bVar.a(i, i2, intent);
        AppMethodBeat.o(66788);
    }

    static /* synthetic */ void g(b bVar) {
        AppMethodBeat.i(66787);
        bVar.i();
        AppMethodBeat.o(66787);
    }

    static {
        AppMethodBeat.i(66789);
        AppMethodBeat.o(66789);
    }

    private b() {
        AppMethodBeat.i(66771);
        this.d = new HashMap();
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = new HashSet();
        this.i = 1;
        this.j = null;
        this.k = new HashSet();
        this.l = false;
        this.m = null;
        this.n = new HandlerThread("TXCScreenCaptureImplSingleton");
        this.o = null;
        this.p = 0;
        this.q = new HashSet();
        this.r = new Runnable() {
            /* JADX WARNING: Missing block: B:9:0x0034, code skipped:
            if (r0 == 0) goto L_0x0039;
     */
            /* JADX WARNING: Missing block: B:11:0x0037, code skipped:
            if (r0 != 2) goto L_0x008d;
     */
            /* JADX WARNING: Missing block: B:13:0x003f, code skipped:
            if (com.tencent.liteav.screencapture.b.c(r6.a) == 0) goto L_0x0084;
     */
            /* JADX WARNING: Missing block: B:14:0x0041, code skipped:
            com.tencent.liteav.basic.log.TXCLog.d(com.tencent.liteav.screencapture.b.c(), "ORIENTATION_PORTRAIT, mDelegateSet size = " + com.tencent.liteav.screencapture.b.d(r6.a).size());
            r1 = com.tencent.liteav.screencapture.b.d(r6.a).iterator();
     */
            /* JADX WARNING: Missing block: B:16:0x0070, code skipped:
            if (r1.hasNext() == false) goto L_0x0084;
     */
            /* JADX WARNING: Missing block: B:17:0x0072, code skipped:
            r0 = (com.tencent.liteav.screencapture.b.a) r1.next();
     */
            /* JADX WARNING: Missing block: B:18:0x0078, code skipped:
            if (r0 == null) goto L_0x006c;
     */
            /* JADX WARNING: Missing block: B:19:0x007a, code skipped:
            r0.a(0);
     */
            /* JADX WARNING: Missing block: B:24:0x0084, code skipped:
            com.tencent.liteav.screencapture.b.a(r6.a, 0);
            com.tencent.matrix.trace.core.AppMethodBeat.o(66800);
     */
            /* JADX WARNING: Missing block: B:26:0x0093, code skipped:
            if (com.tencent.liteav.screencapture.b.c(r6.a) == 90) goto L_0x00d2;
     */
            /* JADX WARNING: Missing block: B:27:0x0095, code skipped:
            com.tencent.liteav.basic.log.TXCLog.d(com.tencent.liteav.screencapture.b.c(), "ORIENTATION_LANDSCAPE, mDelegateSet size = " + com.tencent.liteav.screencapture.b.d(r6.a).size());
            r1 = com.tencent.liteav.screencapture.b.d(r6.a).iterator();
     */
            /* JADX WARNING: Missing block: B:29:0x00c4, code skipped:
            if (r1.hasNext() == false) goto L_0x00d2;
     */
            /* JADX WARNING: Missing block: B:30:0x00c6, code skipped:
            r0 = (com.tencent.liteav.screencapture.b.a) r1.next();
     */
            /* JADX WARNING: Missing block: B:31:0x00cc, code skipped:
            if (r0 == null) goto L_0x00c0;
     */
            /* JADX WARNING: Missing block: B:32:0x00ce, code skipped:
            r0.a(90);
     */
            /* JADX WARNING: Missing block: B:33:0x00d2, code skipped:
            com.tencent.liteav.screencapture.b.a(r6.a, 90);
            com.tencent.matrix.trace.core.AppMethodBeat.o(66800);
     */
            /* JADX WARNING: Missing block: B:46:?, code skipped:
            return;
     */
            /* JADX WARNING: Missing block: B:47:?, code skipped:
            return;
     */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void run() {
                AppMethodBeat.i(66800);
                b.a(b.this);
                synchronized (this) {
                    try {
                        if (b.this.e == null) {
                        } else {
                            int rotation = ((WindowManager) b.this.e.getSystemService("window")).getDefaultDisplay().getRotation();
                        }
                    } finally {
                        while (true) {
                        }
                        AppMethodBeat.o(66800);
                    }
                }
            }
        };
        this.a = new Callback() {
            public void onStop() {
                AppMethodBeat.i(66769);
                if (b.this.l) {
                    b.this.l = false;
                    AppMethodBeat.o(66769);
                    return;
                }
                AppMethodBeat.o(66769);
            }
        };
        this.s = new BroadcastReceiver() {
            public void onReceive(Context context, Intent intent) {
                AppMethodBeat.i(66764);
                if (intent != null && intent.getAction().equalsIgnoreCase("TXScreenCapture.OnAssistantActivityResult")) {
                    b.a(b.this, intent.getIntExtra("TXScreenCapture.RequestCode", 0), intent.getIntExtra("TXScreenCapture.ResultCode", 0), (Intent) intent.getParcelableExtra("TXScreenCapture.ResultData"));
                }
                AppMethodBeat.o(66764);
            }
        };
        this.j = new Handler(Looper.getMainLooper());
        this.n.start();
        this.o = new Handler(this.n.getLooper());
        AppMethodBeat.o(66771);
    }

    public static b a() {
        return c;
    }

    public void a(com.tencent.liteav.basic.d.a aVar) {
        AppMethodBeat.i(66772);
        if (aVar == null) {
            this.m = null;
            AppMethodBeat.o(66772);
            return;
        }
        this.m = new WeakReference(aVar);
        AppMethodBeat.o(66772);
    }

    /* JADX WARNING: Missing block: B:13:0x002e, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.o(66773);
     */
    /* JADX WARNING: Missing block: B:22:?, code skipped:
            return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(Context context) {
        AppMethodBeat.i(66773);
        synchronized (this) {
            try {
                if (this.e != context) {
                    b();
                    this.f = null;
                    this.e = context;
                    if (this.e == null) {
                    } else if (this.f == null) {
                        this.f = (MediaProjectionManager) this.e.getSystemService("media_projection");
                    }
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(66773);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0032 A:{SYNTHETIC, Splitter:B:14:0x0032} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    @TargetApi(21)
    public boolean a(Surface surface, int i, int i2) {
        boolean z = false;
        AppMethodBeat.i(66774);
        synchronized (this) {
            try {
                boolean z2;
                if (this.i == 3 || this.i == 4) {
                    if (this.g == null) {
                    }
                    if (this.g != null) {
                        this.l = true;
                        VirtualDisplay createVirtualDisplay = this.g.createVirtualDisplay("TXCScreenCapture", i, i2, 1, 1, surface, null, null);
                        if (createVirtualDisplay != null) {
                            this.i = 3;
                            this.d.put(surface, createVirtualDisplay);
                            z = true;
                        }
                        if (!z) {
                            try {
                                com.tencent.liteav.basic.util.b.a(this.m, (int) TXLiveConstants.PUSH_ERR_SCREEN_CAPTURE_START_FAILED, "录屏失败");
                            } catch (Throwable th) {
                                while (true) {
                                    AppMethodBeat.o(66774);
                                }
                            }
                        }
                    } else {
                        z2 = false;
                    }
                } else {
                    b bVar = new b(this, null);
                    bVar.c = i2;
                    bVar.b = i;
                    bVar.a = surface;
                    this.h.add(bVar);
                    z2 = h();
                }
                z = z2;
            } catch (Exception e) {
            }
            if (z) {
            }
        }
        AppMethodBeat.o(66774);
        return z;
    }

    public void a(Surface surface) {
        AppMethodBeat.i(66775);
        synchronized (this) {
            try {
                Iterator it = this.h.iterator();
                while (it.hasNext()) {
                    b bVar = (b) it.next();
                    if (bVar != null && bVar.a != null && bVar.b != 0 && bVar.c != 0 && bVar.a == surface) {
                        this.h.remove(bVar);
                        break;
                    }
                }
                if (this.d.containsKey(surface)) {
                    ((VirtualDisplay) this.d.get(surface)).release();
                    this.d.remove(surface);
                    d();
                    AppMethodBeat.o(66775);
                    return;
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(66775);
            }
        }
    }

    public void b() {
        AppMethodBeat.i(66776);
        synchronized (this) {
            try {
                e();
            } finally {
                while (true) {
                }
                AppMethodBeat.o(66776);
            }
        }
    }

    private void d() {
        AppMethodBeat.i(66777);
        this.i = 4;
        this.j.postDelayed(new Runnable() {
            public void run() {
                AppMethodBeat.i(66761);
                synchronized (b.this) {
                    try {
                        if (b.this.d.size() == 0) {
                            b.g(b.this);
                        }
                    } finally {
                        while (true) {
                        }
                        AppMethodBeat.o(66761);
                    }
                }
            }
        }, 1000);
        AppMethodBeat.o(66777);
    }

    private void e() {
        AppMethodBeat.i(66778);
        for (VirtualDisplay virtualDisplay : this.d.values()) {
            if (virtualDisplay != null) {
                virtualDisplay.release();
            }
        }
        this.d.clear();
        this.k.clear();
        i();
        AppMethodBeat.o(66778);
    }

    private void f() {
        AppMethodBeat.i(66779);
        this.o.postDelayed(this.r, 50);
        AppMethodBeat.o(66779);
    }

    private void g() {
        AppMethodBeat.i(66780);
        this.o.removeCallbacks(this.r);
        AppMethodBeat.o(66780);
    }

    public void a(final a aVar) {
        AppMethodBeat.i(66781);
        this.j.post(new Runnable() {
            public void run() {
                AppMethodBeat.i(66768);
                b.this.q.add(aVar);
                AppMethodBeat.o(66768);
            }
        });
        AppMethodBeat.o(66781);
    }

    public void b(final a aVar) {
        AppMethodBeat.i(66782);
        this.j.post(new Runnable() {
            public void run() {
                AppMethodBeat.i(66763);
                b.this.q.remove(aVar);
                AppMethodBeat.o(66763);
            }
        });
        AppMethodBeat.o(66782);
    }

    @TargetApi(21)
    private boolean h() {
        AppMethodBeat.i(66783);
        if (this.i != 1) {
            AppMethodBeat.o(66783);
            return true;
        } else if (this.e == null || this.f == null) {
            AppMethodBeat.o(66783);
            return false;
        } else {
            f();
            this.i = 2;
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("TXScreenCapture.OnAssistantActivityResult");
            this.e.registerReceiver(this.s, intentFilter);
            Intent intent = new Intent(this.e, TXScreenCaptureAssistantActivity.class);
            intent.addFlags(268435456);
            intent.putExtra("TXScreenCapture.ScreenCaptureIntent", this.f.createScreenCaptureIntent());
            this.e.startActivity(intent);
            AppMethodBeat.o(66783);
            return true;
        }
    }

    @TargetApi(21)
    private void i() {
        AppMethodBeat.i(66784);
        if (this.k.isEmpty()) {
            this.l = false;
            if (this.g != null) {
                this.g.stop();
                this.g.unregisterCallback(this.a);
            }
            try {
                if (this.e != null) {
                    this.e.unregisterReceiver(this.s);
                }
            } catch (Exception e) {
            }
            this.g = null;
            this.i = 1;
            g();
            AppMethodBeat.o(66784);
            return;
        }
        AppMethodBeat.o(66784);
    }

    /* JADX WARNING: Missing block: B:54:0x00e2, code skipped:
            if (r12.m == null) goto L_0x00f5;
     */
    /* JADX WARNING: Missing block: B:55:0x00e4, code skipped:
            new android.os.Handler(android.os.Looper.getMainLooper()).post(new com.tencent.liteav.screencapture.b.AnonymousClass6(r12));
     */
    /* JADX WARNING: Missing block: B:56:0x00f5, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.o(66785);
     */
    /* JADX WARNING: Missing block: B:69:?, code skipped:
            return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    @TargetApi(21)
    private void a(int i, int i2, Intent intent) {
        AppMethodBeat.i(66785);
        try {
            synchronized (this) {
                try {
                    if (this.e != null) {
                        this.e.unregisterReceiver(this.s);
                    }
                } catch (Exception e) {
                }
                if (i == 1001 && i2 == -1) {
                    if (this.i == 2) {
                        this.g = this.f.getMediaProjection(i2, intent);
                        this.g.registerCallback(this.a, this.j);
                        this.l = true;
                        if (this.h.size() == 0) {
                            com.tencent.liteav.basic.util.b.a(this.m, (int) TXLiveConstants.PUSH_ERR_SCREEN_CAPTURE_START_FAILED, "录屏失败");
                            this.i = 1;
                            AppMethodBeat.o(66785);
                            return;
                        }
                        Iterator it = this.h.iterator();
                        while (it.hasNext()) {
                            b bVar = (b) it.next();
                            if (!(bVar == null || bVar.a == null || bVar.b == 0 || bVar.c == 0)) {
                                VirtualDisplay createVirtualDisplay = this.g.createVirtualDisplay("TXCScreenCapture", bVar.b, bVar.c, 1, 1, bVar.a, null, null);
                                if (createVirtualDisplay == null) {
                                    com.tencent.liteav.basic.util.b.a(this.m, (int) TXLiveConstants.PUSH_ERR_SCREEN_CAPTURE_START_FAILED, "录屏失败");
                                    this.i = 1;
                                    AppMethodBeat.o(66785);
                                    return;
                                }
                                this.d.put(bVar.a, createVirtualDisplay);
                            }
                        }
                        this.h.clear();
                        this.i = 3;
                    }
                }
                this.i = 1;
                com.tencent.liteav.basic.util.b.a(this.m, (int) TXLiveConstants.PUSH_ERR_SCREEN_CAPTURE_START_FAILED, "录屏失败");
                AppMethodBeat.o(66785);
            }
        } catch (Exception e2) {
            this.i = 1;
            com.tencent.liteav.basic.util.b.a(this.m, (int) TXLiveConstants.PUSH_ERR_SCREEN_CAPTURE_START_FAILED, "录屏失败");
            AppMethodBeat.o(66785);
        } catch (Throwable th) {
            AppMethodBeat.o(66785);
            throw th;
        }
    }
}
