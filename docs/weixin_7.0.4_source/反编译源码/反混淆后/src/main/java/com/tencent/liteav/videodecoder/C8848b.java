package com.tencent.liteav.videodecoder;

import android.graphics.SurfaceTexture;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.view.Surface;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.p140d.C0946a;
import com.tencent.liteav.basic.p811g.C25649b;
import com.tencent.liteav.basic.util.C17778b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.rtmp.TXLiveConstants;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: com.tencent.liteav.videodecoder.b */
public class C8848b implements C0946a, C37377d {
    /* renamed from: a */
    boolean f2772a = true;
    /* renamed from: b */
    boolean f2773b = true;
    /* renamed from: c */
    boolean f2774c = false;
    /* renamed from: d */
    boolean f2775d = false;
    /* renamed from: e */
    Surface f2776e;
    /* renamed from: f */
    C37377d f2777f;
    /* renamed from: g */
    private int f2778g;
    /* renamed from: h */
    private ByteBuffer f2779h;
    /* renamed from: i */
    private ByteBuffer f2780i;
    /* renamed from: j */
    private long f2781j;
    /* renamed from: k */
    private boolean f2782k = false;
    /* renamed from: l */
    private ArrayList<C25649b> f2783l = new ArrayList();
    /* renamed from: m */
    private C8849a f2784m;
    /* renamed from: n */
    private WeakReference<C0946a> f2785n;

    /* renamed from: com.tencent.liteav.videodecoder.b$a */
    static class C8849a extends Handler {
        /* renamed from: a */
        C25680a f2786a;
        /* renamed from: b */
        C37377d f2787b;
        /* renamed from: c */
        WeakReference<C0946a> f2788c;
        /* renamed from: d */
        boolean f2789d;
        /* renamed from: e */
        boolean f2790e;
        /* renamed from: f */
        Surface f2791f;
        /* renamed from: g */
        private ByteBuffer f2792g;
        /* renamed from: h */
        private ByteBuffer f2793h;

        public C8849a(Looper looper) {
            super(looper);
        }

        /* renamed from: a */
        public void mo20020a(boolean z, boolean z2, Surface surface, ByteBuffer byteBuffer, ByteBuffer byteBuffer2, C37377d c37377d, C0946a c0946a) {
            AppMethodBeat.m2504i(67803);
            this.f2790e = z;
            this.f2789d = z2;
            this.f2791f = surface;
            this.f2792g = byteBuffer;
            this.f2793h = byteBuffer2;
            this.f2787b = c37377d;
            this.f2788c = new WeakReference(c0946a);
            AppMethodBeat.m2505o(67803);
        }

        public void handleMessage(Message message) {
            boolean z = true;
            AppMethodBeat.m2504i(67804);
            switch (message.what) {
                case 100:
                    m15793a(((Boolean) message.obj).booleanValue());
                    AppMethodBeat.m2505o(67804);
                    return;
                case 101:
                    try {
                        Bundle data = message.getData();
                        m15795a(data.getByteArray("nal"), data.getLong("pts"), data.getLong("dts"), data.getInt("codecId"));
                        AppMethodBeat.m2505o(67804);
                        return;
                    } catch (Exception e) {
                        AppMethodBeat.m2505o(67804);
                        return;
                    }
                case 102:
                    m15796b();
                    AppMethodBeat.m2505o(67804);
                    return;
                case 103:
                    boolean z2 = message.arg1 == 1;
                    if (message.arg2 != 1) {
                        z = false;
                    }
                    m15794a(z2, z);
                    break;
            }
            AppMethodBeat.m2505o(67804);
        }

        /* renamed from: a */
        public boolean mo20021a() {
            AppMethodBeat.m2504i(67805);
            if (this.f2786a != null) {
                boolean isHevc = this.f2786a.isHevc();
                AppMethodBeat.m2505o(67805);
                return isHevc;
            }
            AppMethodBeat.m2505o(67805);
            return false;
        }

        /* renamed from: a */
        private void m15795a(byte[] bArr, long j, long j2, int i) {
            AppMethodBeat.m2504i(67806);
            C25649b c25649b = new C25649b();
            c25649b.f5251a = bArr;
            c25649b.f5257g = j;
            c25649b.f5258h = j2;
            c25649b.f5259i = i;
            if (this.f2786a != null) {
                this.f2786a.decode(c25649b);
            }
            AppMethodBeat.m2505o(67806);
        }

        /* renamed from: b */
        private void m15796b() {
            AppMethodBeat.m2504i(67807);
            if (this.f2786a != null) {
                this.f2786a.stop();
                this.f2786a.setListener(null);
                this.f2786a.setNotifyListener(null);
                this.f2786a = null;
            }
            Looper.myLooper().quit();
            TXCLog.m15679w("TXCVideoDecoder", "play:decode: stop decode hwdec: " + this.f2789d);
            AppMethodBeat.m2505o(67807);
        }

        /* renamed from: a */
        private void m15794a(boolean z, boolean z2) {
            AppMethodBeat.m2504i(67808);
            this.f2789d = z;
            TXCLog.m15679w("TXCVideoDecoder", "play:decode: restart decode hwdec: " + this.f2789d);
            if (this.f2786a != null) {
                this.f2786a.stop();
                this.f2786a.setListener(null);
                this.f2786a.setNotifyListener(null);
                this.f2786a = null;
            }
            m15793a(z2);
            AppMethodBeat.m2505o(67808);
        }

        /* renamed from: a */
        private void m15793a(boolean z) {
            AppMethodBeat.m2504i(67809);
            if (this.f2786a != null) {
                TXCLog.m15677i("TXCVideoDecoder", "play:decode: start decode ignore hwdec: " + this.f2789d);
                AppMethodBeat.m2505o(67809);
                return;
            }
            if (this.f2789d) {
                this.f2786a = new C31254c();
            } else {
                this.f2786a = new TXCVideoFfmpegDecoder();
            }
            this.f2786a.setListener(this.f2787b);
            this.f2786a.setNotifyListener(this.f2788c);
            this.f2786a.config(this.f2791f);
            this.f2786a.start(this.f2792g, this.f2793h, z, this.f2790e);
            TXCLog.m15679w("TXCVideoDecoder", "play:decode: start decode hwdec: " + this.f2789d + ", hevc: " + this.f2790e);
            AppMethodBeat.m2505o(67809);
        }
    }

    public void onNotifyEvent(int i, Bundle bundle) {
        AppMethodBeat.m2504i(67768);
        C17778b.m27744a(this.f2785n, this.f2781j, i, bundle);
        AppMethodBeat.m2505o(67768);
    }

    /* renamed from: a */
    public void mo20006a(long j) {
        this.f2781j = j;
    }

    public C8848b() {
        AppMethodBeat.m2504i(67769);
        AppMethodBeat.m2505o(67769);
    }

    /* renamed from: a */
    public void mo20011a(C37377d c37377d) {
        this.f2777f = c37377d;
    }

    /* renamed from: a */
    public boolean mo20014a() {
        return this.f2773b;
    }

    /* renamed from: a */
    public void mo20009a(C0946a c0946a) {
        AppMethodBeat.m2504i(67770);
        this.f2785n = new WeakReference(c0946a);
        AppMethodBeat.m2505o(67770);
    }

    /* renamed from: a */
    public int mo20003a(SurfaceTexture surfaceTexture, ByteBuffer byteBuffer, ByteBuffer byteBuffer2, boolean z) {
        AppMethodBeat.m2504i(67771);
        int a = mo20004a(new Surface(surfaceTexture), byteBuffer, byteBuffer2, z);
        AppMethodBeat.m2505o(67771);
        return a;
    }

    /* renamed from: a */
    public int mo20004a(Surface surface, ByteBuffer byteBuffer, ByteBuffer byteBuffer2, boolean z) {
        this.f2776e = surface;
        this.f2779h = byteBuffer;
        this.f2780i = byteBuffer2;
        this.f2772a = z;
        return 0;
    }

    /* renamed from: a */
    public void mo20012a(boolean z) {
        this.f2773b = z;
    }

    /* renamed from: b */
    private void m15775b(C25649b c25649b) {
        AppMethodBeat.m2504i(67772);
        boolean z = c25649b.f5252b == 0;
        Bundle bundle = new Bundle();
        bundle.putBoolean("iframe", z);
        bundle.putByteArray("nal", c25649b.f5251a);
        bundle.putLong("pts", c25649b.f5257g);
        bundle.putLong("dts", c25649b.f5258h);
        bundle.putInt("codecId", c25649b.f5259i);
        Message message = new Message();
        message.what = 101;
        message.setData(bundle);
        C8849a c8849a = this.f2784m;
        if (c8849a != null) {
            c8849a.sendMessage(message);
        }
        this.f2778g++;
        AppMethodBeat.m2505o(67772);
    }

    /* renamed from: a */
    public void mo20010a(C25649b c25649b) {
        AppMethodBeat.m2504i(67773);
        Object obj = c25649b.f5252b == 0 ? 1 : null;
        if (this.f2775d || obj != null) {
            try {
                if (!(this.f2775d || obj == null)) {
                    TXCLog.m15679w("TXCVideoDecoder", "play:decode: push first i frame");
                    this.f2775d = true;
                }
                if (!(this.f2782k || c25649b.f5259i != 1 || this.f2773b)) {
                    TXCLog.m15679w("TXCVideoDecoder", "play:decode: hevc decode error  ");
                    C17778b.m27743a(this.f2785n, (int) TXLiveConstants.PLAY_ERR_HEVC_DECODE_FAIL, "h265解码失败");
                    this.f2782k = true;
                }
                if (this.f2784m != null) {
                    if (!this.f2783l.isEmpty()) {
                        Iterator it = this.f2783l.iterator();
                        while (it.hasNext()) {
                            m15775b((C25649b) it.next());
                        }
                    }
                    this.f2783l.clear();
                    m15775b(c25649b);
                    AppMethodBeat.m2505o(67773);
                    return;
                }
                if (!(obj == null || this.f2783l.isEmpty())) {
                    this.f2783l.clear();
                }
                this.f2783l.add(c25649b);
                if (!this.f2782k) {
                    mo20015b();
                }
                AppMethodBeat.m2505o(67773);
                return;
            } catch (Exception e) {
                AppMethodBeat.m2505o(67773);
                return;
            }
        }
        TXCLog.m15677i("TXCVideoDecoder", "play:decode: push nal ignore p frame when not got i frame");
        AppMethodBeat.m2505o(67773);
    }

    /* JADX WARNING: Missing block: B:15:0x0091, code skipped:
            r1 = new android.os.Bundle();
            r1.putInt("EVT_ID", 2008);
            r1.putLong("EVT_TIME", com.tencent.liteav.basic.util.TXCTimeUtil.getTimeTick());
            r2 = com.tencent.rtmp.TXLiveConstants.EVT_DESCRIPTION;
     */
    /* JADX WARNING: Missing block: B:16:0x00ab, code skipped:
            if (r11.f2773b == false) goto L_0x00d1;
     */
    /* JADX WARNING: Missing block: B:17:0x00ad, code skipped:
            r0 = "启动硬解";
     */
    /* JADX WARNING: Missing block: B:18:0x00b0, code skipped:
            r1.putCharSequence(r2, r0);
            r2 = "EVT_PARAM1";
     */
    /* JADX WARNING: Missing block: B:19:0x00b8, code skipped:
            if (r11.f2773b == false) goto L_0x00d5;
     */
    /* JADX WARNING: Missing block: B:20:0x00ba, code skipped:
            r0 = 1;
     */
    /* JADX WARNING: Missing block: B:21:0x00bb, code skipped:
            r1.putInt(r2, r0);
            com.tencent.liteav.basic.util.C17778b.m27744a(r11.f2785n, r11.f2781j, 2008, r1);
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(67774);
     */
    /* JADX WARNING: Missing block: B:26:0x00d1, code skipped:
            r0 = "启动软解";
     */
    /* JADX WARNING: Missing block: B:27:0x00d5, code skipped:
            r0 = 2;
     */
    /* JADX WARNING: Missing block: B:33:?, code skipped:
            return 0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: b */
    public int mo20015b() {
        AppMethodBeat.m2504i(67774);
        if (this.f2773b && this.f2776e == null) {
            TXCLog.m15677i("TXCVideoDecoder", "play:decode: start decoder error when not setup surface");
            AppMethodBeat.m2505o(67774);
            return -1;
        }
        synchronized (this) {
            try {
                if (this.f2784m != null) {
                    TXCLog.m15676e("TXCVideoDecoder", "play:decode: start decoder error when decoder is started");
                } else {
                    this.f2778g = 0;
                    this.f2782k = false;
                    HandlerThread handlerThread = new HandlerThread("VDecoder");
                    handlerThread.start();
                    handlerThread.setName("VDecoder" + handlerThread.getId());
                    C8849a c8849a = new C8849a(handlerThread.getLooper());
                    c8849a.mo20020a(this.f2774c, this.f2773b, this.f2776e, this.f2779h, this.f2780i, this, this);
                    TXCLog.m15679w("TXCVideoDecoder", "play:decode: start decode thread");
                    Message obtain = Message.obtain();
                    obtain.what = 100;
                    obtain.obj = Boolean.valueOf(this.f2772a);
                    c8849a.sendMessage(obtain);
                    this.f2784m = c8849a;
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(67774);
            }
        }
        return -1;
    }

    /* renamed from: c */
    public void mo20017c() {
        AppMethodBeat.m2504i(67775);
        synchronized (this) {
            try {
                if (this.f2784m != null) {
                    this.f2784m.sendEmptyMessage(102);
                }
                this.f2784m = null;
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(67775);
            }
        }
        this.f2783l.clear();
        this.f2775d = false;
        this.f2778g = 0;
    }

    /* renamed from: b */
    public void mo20016b(boolean z) {
        int i = 1;
        AppMethodBeat.m2504i(67776);
        synchronized (this) {
            try {
                this.f2773b = z;
                this.f2783l.clear();
                this.f2775d = false;
                this.f2778g = 0;
                Message obtain = Message.obtain();
                obtain.what = 103;
                obtain.arg1 = this.f2773b ? 1 : 0;
                if (!this.f2772a) {
                    i = 0;
                }
                obtain.arg2 = i;
                if (this.f2784m != null) {
                    this.f2784m.sendMessage(obtain);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(67776);
            }
        }
    }

    /* renamed from: a */
    public void mo20013a(byte[] bArr, long j, int i) {
        AppMethodBeat.m2504i(67777);
        C8849a c8849a = this.f2784m;
        if (!(c8849a == null || c8849a.f2789d || c8849a.f2786a == null)) {
            ((TXCVideoFfmpegDecoder) c8849a.f2786a).loadNativeData(bArr, j, i);
        }
        AppMethodBeat.m2505o(67777);
    }

    /* renamed from: d */
    public int mo20018d() {
        AppMethodBeat.m2504i(67778);
        int size = this.f2778g + this.f2783l.size();
        AppMethodBeat.m2505o(67778);
        return size;
    }

    /* renamed from: a */
    public void mo20008a(SurfaceTexture surfaceTexture, int i, int i2, long j, long j2) {
        AppMethodBeat.m2504i(67779);
        if (this.f2777f != null) {
            this.f2777f.mo20008a(surfaceTexture, i, i2, j, j2);
        }
        if (this.f2778g > 0) {
            this.f2778g--;
        }
        AppMethodBeat.m2505o(67779);
    }

    /* renamed from: a */
    public void mo20007a(long j, int i, int i2, long j2, long j3) {
        AppMethodBeat.m2504i(67780);
        if (this.f2777f != null) {
            this.f2777f.mo20007a(j, i, i2, j2, j3);
        }
        if (this.f2778g > 0) {
            this.f2778g--;
        }
        AppMethodBeat.m2505o(67780);
    }

    /* renamed from: a */
    public void mo20005a(int i, int i2) {
        AppMethodBeat.m2504i(67781);
        if (this.f2777f != null) {
            this.f2777f.mo20005a(i, i2);
        }
        AppMethodBeat.m2505o(67781);
    }

    /* renamed from: e */
    public boolean mo20019e() {
        AppMethodBeat.m2504i(67782);
        C8849a c8849a = this.f2784m;
        if (c8849a != null) {
            boolean a = c8849a.mo20021a();
            AppMethodBeat.m2505o(67782);
            return a;
        }
        AppMethodBeat.m2505o(67782);
        return false;
    }
}
