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
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.view.Surface;
import android.view.WindowManager;
import com.tencent.liteav.basic.p140d.C0946a;
import com.tencent.liteav.basic.util.C17778b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.rtmp.TXLiveConstants;
import com.tencent.rtmp.video.TXScreenCapture.TXScreenCaptureAssistantActivity;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

@TargetApi(21)
/* renamed from: com.tencent.liteav.screencapture.b */
public class C25675b {
    /* renamed from: b */
    private static final String f5399b = C25675b.class.getSimpleName();
    /* renamed from: c */
    private static C25675b f5400c = new C25675b();
    /* renamed from: a */
    Callback f5401a;
    /* renamed from: d */
    private HashMap<Surface, VirtualDisplay> f5402d;
    /* renamed from: e */
    private Context f5403e;
    /* renamed from: f */
    private MediaProjectionManager f5404f;
    /* renamed from: g */
    private MediaProjection f5405g;
    /* renamed from: h */
    private HashSet<C8847b> f5406h;
    /* renamed from: i */
    private int f5407i;
    /* renamed from: j */
    private Handler f5408j;
    /* renamed from: k */
    private HashSet<Object> f5409k;
    /* renamed from: l */
    private boolean f5410l;
    /* renamed from: m */
    private WeakReference<C0946a> f5411m;
    /* renamed from: n */
    private HandlerThread f5412n;
    /* renamed from: o */
    private Handler f5413o;
    /* renamed from: p */
    private int f5414p;
    /* renamed from: q */
    private HashSet<C8846a> f5415q;
    /* renamed from: r */
    private Runnable f5416r;
    /* renamed from: s */
    private BroadcastReceiver f5417s;

    /* renamed from: com.tencent.liteav.screencapture.b$6 */
    class C88456 implements Runnable {
        C88456() {
        }

        public void run() {
            AppMethodBeat.m2504i(66770);
            if (C25675b.this.f5411m != null) {
                C0946a c0946a = (C0946a) C25675b.this.f5411m.get();
                if (c0946a != null) {
                    Bundle bundle = new Bundle();
                    bundle.putString(TXLiveConstants.EVT_DESCRIPTION, "录屏启动成功");
                    c0946a.onNotifyEvent(1004, bundle);
                }
            }
            AppMethodBeat.m2505o(66770);
        }
    }

    /* renamed from: com.tencent.liteav.screencapture.b$a */
    public interface C8846a {
        /* renamed from: a */
        void mo19989a(int i);
    }

    /* renamed from: com.tencent.liteav.screencapture.b$b */
    class C8847b {
        /* renamed from: a */
        Surface f2768a;
        /* renamed from: b */
        int f2769b;
        /* renamed from: c */
        int f2770c;

        private C8847b() {
        }

        /* synthetic */ C8847b(C25675b c25675b, C256761 c256761) {
            this();
        }
    }

    /* renamed from: com.tencent.liteav.screencapture.b$7 */
    class C256747 extends BroadcastReceiver {
        C256747() {
        }

        public void onReceive(Context context, Intent intent) {
            AppMethodBeat.m2504i(66764);
            if (intent != null && intent.getAction().equalsIgnoreCase("TXScreenCapture.OnAssistantActivityResult")) {
                C25675b.m40749a(C25675b.this, intent.getIntExtra("TXScreenCapture.RequestCode", 0), intent.getIntExtra("TXScreenCapture.ResultCode", 0), (Intent) intent.getParcelableExtra("TXScreenCapture.ResultData"));
            }
            AppMethodBeat.m2505o(66764);
        }
    }

    /* renamed from: com.tencent.liteav.screencapture.b$1 */
    class C256761 implements Runnable {
        C256761() {
        }

        /* JADX WARNING: Missing block: B:9:0x0034, code skipped:
            if (r0 == 0) goto L_0x0039;
     */
        /* JADX WARNING: Missing block: B:11:0x0037, code skipped:
            if (r0 != 2) goto L_0x008d;
     */
        /* JADX WARNING: Missing block: B:13:0x003f, code skipped:
            if (com.tencent.liteav.screencapture.C25675b.m40752c(r6.f5418a) == 0) goto L_0x0084;
     */
        /* JADX WARNING: Missing block: B:14:0x0041, code skipped:
            com.tencent.liteav.basic.log.TXCLog.m15675d(com.tencent.liteav.screencapture.C25675b.m40753c(), "ORIENTATION_PORTRAIT, mDelegateSet size = " + com.tencent.liteav.screencapture.C25675b.m40754d(r6.f5418a).size());
            r1 = com.tencent.liteav.screencapture.C25675b.m40754d(r6.f5418a).iterator();
     */
        /* JADX WARNING: Missing block: B:16:0x0070, code skipped:
            if (r1.hasNext() == false) goto L_0x0084;
     */
        /* JADX WARNING: Missing block: B:17:0x0072, code skipped:
            r0 = (com.tencent.liteav.screencapture.C25675b.C8846a) r1.next();
     */
        /* JADX WARNING: Missing block: B:18:0x0078, code skipped:
            if (r0 == null) goto L_0x006c;
     */
        /* JADX WARNING: Missing block: B:19:0x007a, code skipped:
            r0.mo19989a(0);
     */
        /* JADX WARNING: Missing block: B:24:0x0084, code skipped:
            com.tencent.liteav.screencapture.C25675b.m40745a(r6.f5418a, 0);
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(66800);
     */
        /* JADX WARNING: Missing block: B:26:0x0093, code skipped:
            if (com.tencent.liteav.screencapture.C25675b.m40752c(r6.f5418a) == 90) goto L_0x00d2;
     */
        /* JADX WARNING: Missing block: B:27:0x0095, code skipped:
            com.tencent.liteav.basic.log.TXCLog.m15675d(com.tencent.liteav.screencapture.C25675b.m40753c(), "ORIENTATION_LANDSCAPE, mDelegateSet size = " + com.tencent.liteav.screencapture.C25675b.m40754d(r6.f5418a).size());
            r1 = com.tencent.liteav.screencapture.C25675b.m40754d(r6.f5418a).iterator();
     */
        /* JADX WARNING: Missing block: B:29:0x00c4, code skipped:
            if (r1.hasNext() == false) goto L_0x00d2;
     */
        /* JADX WARNING: Missing block: B:30:0x00c6, code skipped:
            r0 = (com.tencent.liteav.screencapture.C25675b.C8846a) r1.next();
     */
        /* JADX WARNING: Missing block: B:31:0x00cc, code skipped:
            if (r0 == null) goto L_0x00c0;
     */
        /* JADX WARNING: Missing block: B:32:0x00ce, code skipped:
            r0.mo19989a(90);
     */
        /* JADX WARNING: Missing block: B:33:0x00d2, code skipped:
            com.tencent.liteav.screencapture.C25675b.m40745a(r6.f5418a, 90);
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(66800);
     */
        /* JADX WARNING: Missing block: B:46:?, code skipped:
            return;
     */
        /* JADX WARNING: Missing block: B:47:?, code skipped:
            return;
     */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            AppMethodBeat.m2504i(66800);
            C25675b.m40748a(C25675b.this);
            synchronized (this) {
                try {
                    if (C25675b.this.f5403e == null) {
                    } else {
                        int rotation = ((WindowManager) C25675b.this.f5403e.getSystemService("window")).getDefaultDisplay().getRotation();
                    }
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.m2505o(66800);
                }
            }
        }
    }

    /* renamed from: com.tencent.liteav.screencapture.b$2 */
    class C256772 extends Callback {
        C256772() {
        }

        public void onStop() {
            AppMethodBeat.m2504i(66769);
            if (C25675b.this.f5410l) {
                C25675b.this.f5410l = false;
                AppMethodBeat.m2505o(66769);
                return;
            }
            AppMethodBeat.m2505o(66769);
        }
    }

    /* renamed from: com.tencent.liteav.screencapture.b$3 */
    class C256783 implements Runnable {
        C256783() {
        }

        public void run() {
            AppMethodBeat.m2504i(66761);
            synchronized (C25675b.this) {
                try {
                    if (C25675b.this.f5402d.size() == 0) {
                        C25675b.m40761g(C25675b.this);
                    }
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.m2505o(66761);
                }
            }
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m40749a(C25675b c25675b, int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(66788);
        c25675b.m40747a(i, i2, intent);
        AppMethodBeat.m2505o(66788);
    }

    /* renamed from: g */
    static /* synthetic */ void m40761g(C25675b c25675b) {
        AppMethodBeat.m2504i(66787);
        c25675b.m40764i();
        AppMethodBeat.m2505o(66787);
    }

    static {
        AppMethodBeat.m2504i(66789);
        AppMethodBeat.m2505o(66789);
    }

    private C25675b() {
        AppMethodBeat.m2504i(66771);
        this.f5402d = new HashMap();
        this.f5403e = null;
        this.f5404f = null;
        this.f5405g = null;
        this.f5406h = new HashSet();
        this.f5407i = 1;
        this.f5408j = null;
        this.f5409k = new HashSet();
        this.f5410l = false;
        this.f5411m = null;
        this.f5412n = new HandlerThread("TXCScreenCaptureImplSingleton");
        this.f5413o = null;
        this.f5414p = 0;
        this.f5415q = new HashSet();
        this.f5416r = new C256761();
        this.f5401a = new C256772();
        this.f5417s = new C256747();
        this.f5408j = new Handler(Looper.getMainLooper());
        this.f5412n.start();
        this.f5413o = new Handler(this.f5412n.getLooper());
        AppMethodBeat.m2505o(66771);
    }

    /* renamed from: a */
    public static C25675b m40746a() {
        return f5400c;
    }

    /* renamed from: a */
    public void mo43459a(C0946a c0946a) {
        AppMethodBeat.m2504i(66772);
        if (c0946a == null) {
            this.f5411m = null;
            AppMethodBeat.m2505o(66772);
            return;
        }
        this.f5411m = new WeakReference(c0946a);
        AppMethodBeat.m2505o(66772);
    }

    /* JADX WARNING: Missing block: B:13:0x002e, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(66773);
     */
    /* JADX WARNING: Missing block: B:22:?, code skipped:
            return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public void mo43457a(Context context) {
        AppMethodBeat.m2504i(66773);
        synchronized (this) {
            try {
                if (this.f5403e != context) {
                    mo43462b();
                    this.f5404f = null;
                    this.f5403e = context;
                    if (this.f5403e == null) {
                    } else if (this.f5404f == null) {
                        this.f5404f = (MediaProjectionManager) this.f5403e.getSystemService("media_projection");
                    }
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(66773);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0032 A:{SYNTHETIC, Splitter:B:14:0x0032} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    @TargetApi(21)
    /* renamed from: a */
    public boolean mo43461a(Surface surface, int i, int i2) {
        boolean z = false;
        AppMethodBeat.m2504i(66774);
        synchronized (this) {
            try {
                boolean z2;
                if (this.f5407i == 3 || this.f5407i == 4) {
                    if (this.f5405g == null) {
                    }
                    if (this.f5405g != null) {
                        this.f5410l = true;
                        VirtualDisplay createVirtualDisplay = this.f5405g.createVirtualDisplay("TXCScreenCapture", i, i2, 1, 1, surface, null, null);
                        if (createVirtualDisplay != null) {
                            this.f5407i = 3;
                            this.f5402d.put(surface, createVirtualDisplay);
                            z = true;
                        }
                        if (!z) {
                            try {
                                C17778b.m27743a(this.f5411m, (int) TXLiveConstants.PUSH_ERR_SCREEN_CAPTURE_START_FAILED, "录屏失败");
                            } catch (Throwable th) {
                                while (true) {
                                    AppMethodBeat.m2505o(66774);
                                }
                            }
                        }
                    } else {
                        z2 = false;
                    }
                } else {
                    C8847b c8847b = new C8847b(this, null);
                    c8847b.f2770c = i2;
                    c8847b.f2769b = i;
                    c8847b.f2768a = surface;
                    this.f5406h.add(c8847b);
                    z2 = m40763h();
                }
                z = z2;
            } catch (Exception e) {
            }
            if (z) {
            }
        }
        AppMethodBeat.m2505o(66774);
        return z;
    }

    /* renamed from: a */
    public void mo43458a(Surface surface) {
        AppMethodBeat.m2504i(66775);
        synchronized (this) {
            try {
                Iterator it = this.f5406h.iterator();
                while (it.hasNext()) {
                    C8847b c8847b = (C8847b) it.next();
                    if (c8847b != null && c8847b.f2768a != null && c8847b.f2769b != 0 && c8847b.f2770c != 0 && c8847b.f2768a == surface) {
                        this.f5406h.remove(c8847b);
                        break;
                    }
                }
                if (this.f5402d.containsKey(surface)) {
                    ((VirtualDisplay) this.f5402d.get(surface)).release();
                    this.f5402d.remove(surface);
                    m40755d();
                    AppMethodBeat.m2505o(66775);
                    return;
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(66775);
            }
        }
    }

    /* renamed from: b */
    public void mo43462b() {
        AppMethodBeat.m2504i(66776);
        synchronized (this) {
            try {
                m40756e();
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(66776);
            }
        }
    }

    /* renamed from: d */
    private void m40755d() {
        AppMethodBeat.m2504i(66777);
        this.f5407i = 4;
        this.f5408j.postDelayed(new C256783(), 1000);
        AppMethodBeat.m2505o(66777);
    }

    /* renamed from: e */
    private void m40756e() {
        AppMethodBeat.m2504i(66778);
        for (VirtualDisplay virtualDisplay : this.f5402d.values()) {
            if (virtualDisplay != null) {
                virtualDisplay.release();
            }
        }
        this.f5402d.clear();
        this.f5409k.clear();
        m40764i();
        AppMethodBeat.m2505o(66778);
    }

    /* renamed from: f */
    private void m40759f() {
        AppMethodBeat.m2504i(66779);
        this.f5413o.postDelayed(this.f5416r, 50);
        AppMethodBeat.m2505o(66779);
    }

    /* renamed from: g */
    private void m40760g() {
        AppMethodBeat.m2504i(66780);
        this.f5413o.removeCallbacks(this.f5416r);
        AppMethodBeat.m2505o(66780);
    }

    /* renamed from: a */
    public void mo43460a(final C8846a c8846a) {
        AppMethodBeat.m2504i(66781);
        this.f5408j.post(new Runnable() {
            public void run() {
                AppMethodBeat.m2504i(66768);
                C25675b.this.f5415q.add(c8846a);
                AppMethodBeat.m2505o(66768);
            }
        });
        AppMethodBeat.m2505o(66781);
    }

    /* renamed from: b */
    public void mo43463b(final C8846a c8846a) {
        AppMethodBeat.m2504i(66782);
        this.f5408j.post(new Runnable() {
            public void run() {
                AppMethodBeat.m2504i(66763);
                C25675b.this.f5415q.remove(c8846a);
                AppMethodBeat.m2505o(66763);
            }
        });
        AppMethodBeat.m2505o(66782);
    }

    @TargetApi(21)
    /* renamed from: h */
    private boolean m40763h() {
        AppMethodBeat.m2504i(66783);
        if (this.f5407i != 1) {
            AppMethodBeat.m2505o(66783);
            return true;
        } else if (this.f5403e == null || this.f5404f == null) {
            AppMethodBeat.m2505o(66783);
            return false;
        } else {
            m40759f();
            this.f5407i = 2;
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("TXScreenCapture.OnAssistantActivityResult");
            this.f5403e.registerReceiver(this.f5417s, intentFilter);
            Intent intent = new Intent(this.f5403e, TXScreenCaptureAssistantActivity.class);
            intent.addFlags(268435456);
            intent.putExtra("TXScreenCapture.ScreenCaptureIntent", this.f5404f.createScreenCaptureIntent());
            this.f5403e.startActivity(intent);
            AppMethodBeat.m2505o(66783);
            return true;
        }
    }

    @TargetApi(21)
    /* renamed from: i */
    private void m40764i() {
        AppMethodBeat.m2504i(66784);
        if (this.f5409k.isEmpty()) {
            this.f5410l = false;
            if (this.f5405g != null) {
                this.f5405g.stop();
                this.f5405g.unregisterCallback(this.f5401a);
            }
            try {
                if (this.f5403e != null) {
                    this.f5403e.unregisterReceiver(this.f5417s);
                }
            } catch (Exception e) {
            }
            this.f5405g = null;
            this.f5407i = 1;
            m40760g();
            AppMethodBeat.m2505o(66784);
            return;
        }
        AppMethodBeat.m2505o(66784);
    }

    /* JADX WARNING: Missing block: B:54:0x00e2, code skipped:
            if (r12.f5411m == null) goto L_0x00f5;
     */
    /* JADX WARNING: Missing block: B:55:0x00e4, code skipped:
            new android.os.Handler(android.os.Looper.getMainLooper()).post(new com.tencent.liteav.screencapture.C25675b.C88456(r12));
     */
    /* JADX WARNING: Missing block: B:56:0x00f5, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(66785);
     */
    /* JADX WARNING: Missing block: B:69:?, code skipped:
            return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    @TargetApi(21)
    /* renamed from: a */
    private void m40747a(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(66785);
        try {
            synchronized (this) {
                try {
                    if (this.f5403e != null) {
                        this.f5403e.unregisterReceiver(this.f5417s);
                    }
                } catch (Exception e) {
                }
                if (i == 1001 && i2 == -1) {
                    if (this.f5407i == 2) {
                        this.f5405g = this.f5404f.getMediaProjection(i2, intent);
                        this.f5405g.registerCallback(this.f5401a, this.f5408j);
                        this.f5410l = true;
                        if (this.f5406h.size() == 0) {
                            C17778b.m27743a(this.f5411m, (int) TXLiveConstants.PUSH_ERR_SCREEN_CAPTURE_START_FAILED, "录屏失败");
                            this.f5407i = 1;
                            AppMethodBeat.m2505o(66785);
                            return;
                        }
                        Iterator it = this.f5406h.iterator();
                        while (it.hasNext()) {
                            C8847b c8847b = (C8847b) it.next();
                            if (!(c8847b == null || c8847b.f2768a == null || c8847b.f2769b == 0 || c8847b.f2770c == 0)) {
                                VirtualDisplay createVirtualDisplay = this.f5405g.createVirtualDisplay("TXCScreenCapture", c8847b.f2769b, c8847b.f2770c, 1, 1, c8847b.f2768a, null, null);
                                if (createVirtualDisplay == null) {
                                    C17778b.m27743a(this.f5411m, (int) TXLiveConstants.PUSH_ERR_SCREEN_CAPTURE_START_FAILED, "录屏失败");
                                    this.f5407i = 1;
                                    AppMethodBeat.m2505o(66785);
                                    return;
                                }
                                this.f5402d.put(c8847b.f2768a, createVirtualDisplay);
                            }
                        }
                        this.f5406h.clear();
                        this.f5407i = 3;
                    }
                }
                this.f5407i = 1;
                C17778b.m27743a(this.f5411m, (int) TXLiveConstants.PUSH_ERR_SCREEN_CAPTURE_START_FAILED, "录屏失败");
                AppMethodBeat.m2505o(66785);
            }
        } catch (Exception e2) {
            this.f5407i = 1;
            C17778b.m27743a(this.f5411m, (int) TXLiveConstants.PUSH_ERR_SCREEN_CAPTURE_START_FAILED, "录屏失败");
            AppMethodBeat.m2505o(66785);
        } catch (Throwable th) {
            AppMethodBeat.m2505o(66785);
            throw th;
        }
    }
}
