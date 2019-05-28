package com.tencent.liteav;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.p811g.C25649b;
import com.tencent.liteav.basic.util.C17778b;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import com.tencent.liteav.beauty.C37363c;
import com.tencent.liteav.beauty.C8811d;
import com.tencent.liteav.videoencoder.C0973b;
import com.tencent.liteav.videoencoder.C0982d;
import com.tencent.liteav.videoencoder.TXSVideoEncoderParam;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.rtmp.TXLivePushConfig;
import com.tencent.smtt.sdk.WebView;
import com.tencent.ttpic.util.ActUtil;
import com.tencent.ttpic.util.VideoFilterUtil;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import javax.microedition.khronos.egl.EGLContext;

/* renamed from: com.tencent.liteav.a */
public class C17762a implements C8811d, C0982d {
    /* renamed from: a */
    private static final String f4050a = C17762a.class.getSimpleName();
    /* renamed from: b */
    private int f4051b = 300;
    /* renamed from: c */
    private long f4052c = 0;
    /* renamed from: d */
    private C17763a f4053d;
    /* renamed from: e */
    private HandlerThread f4054e;
    /* renamed from: f */
    private boolean f4055f = false;
    /* renamed from: g */
    private C0973b f4056g;
    /* renamed from: h */
    private C25649b f4057h;
    /* renamed from: i */
    private C37363c f4058i = null;
    /* renamed from: j */
    private ByteBuffer f4059j = null;
    /* renamed from: k */
    private Bitmap f4060k = null;
    /* renamed from: l */
    private int f4061l = 0;
    /* renamed from: m */
    private int f4062m = 0;
    /* renamed from: n */
    private WeakReference<C8789b> f4063n = null;

    /* renamed from: com.tencent.liteav.a$b */
    public interface C8789b {
        /* renamed from: a */
        void mo19831a();

        /* renamed from: a */
        void mo19832a(Bitmap bitmap, ByteBuffer byteBuffer, int i, int i2);

        /* renamed from: a */
        void mo19833a(C0973b c0973b);
    }

    /* renamed from: com.tencent.liteav.a$a */
    class C17763a extends Handler {
        /* renamed from: b */
        private int f4065b = 300;
        /* renamed from: c */
        private long f4066c = 0;

        public C17763a(Looper looper, int i, long j) {
            super(looper);
            this.f4065b = i;
            this.f4066c = j;
        }

        public void handleMessage(Message message) {
            AppMethodBeat.m2504i(66380);
            if (message.what == 1001) {
                try {
                    C17762a.m27657a(C17762a.this);
                    if (System.currentTimeMillis() < this.f4066c) {
                        sendEmptyMessageDelayed(1001, (long) this.f4065b);
                        AppMethodBeat.m2505o(66380);
                        return;
                    }
                    TXCLog.m15679w(C17762a.f4050a, "bkgpush:stop background publish when timeout");
                    if (C17762a.this.f4063n != null && C17762a.this.f4055f) {
                        C8789b c8789b = (C8789b) C17762a.this.f4063n.get();
                        if (c8789b != null) {
                            c8789b.mo19831a();
                        }
                        C17762a.this.f4055f = false;
                    }
                    AppMethodBeat.m2505o(66380);
                    return;
                } catch (Exception e) {
                }
            }
            AppMethodBeat.m2505o(66380);
        }
    }

    static {
        AppMethodBeat.m2504i(67720);
        AppMethodBeat.m2505o(67720);
    }

    /* renamed from: a */
    public int mo19908a(int i, int i2, int i3) {
        return 0;
    }

    /* renamed from: a */
    public void mo19909a(int i, int i2, int i3, long j) {
        AppMethodBeat.m2504i(67708);
        TXCLog.m15679w(f4050a, "bkgpush: got texture");
        if (this.f4056g != null) {
            this.f4056g.mo3917a(i, i2, i3, TXCTimeUtil.getTimeTick());
        }
        AppMethodBeat.m2505o(67708);
    }

    /* renamed from: a */
    public void mo19910a(byte[] bArr, int i, int i2, int i3, long j) {
    }

    /* renamed from: a */
    public void mo3950a(C25649b c25649b, int i) {
        Object c25649b2;
        AppMethodBeat.m2504i(67709);
        this.f4057h = c25649b2;
        String str = f4050a;
        StringBuilder stringBuilder = new StringBuilder("bkgpush: got nal type: ");
        if (c25649b2 != null) {
            c25649b2 = Integer.valueOf(c25649b2.f5252b);
        }
        TXCLog.m15679w(str, stringBuilder.append(c25649b2).toString());
        if (this.f4056g != null) {
            this.f4056g.mo3923a(null);
            C0973b c0973b = this.f4056g;
            try {
                if (this.f4063n != null) {
                    C8789b c8789b = (C8789b) this.f4063n.get();
                    if (c8789b != null) {
                        c8789b.mo19833a(c0973b);
                    }
                }
                AppMethodBeat.m2505o(67709);
                return;
            } catch (Exception e) {
            }
        }
        AppMethodBeat.m2505o(67709);
    }

    /* renamed from: a */
    public void mo3949a(MediaFormat mediaFormat) {
    }

    public C17762a(C8789b c8789b) {
        AppMethodBeat.m2504i(67710);
        this.f4063n = new WeakReference(c8789b);
        AppMethodBeat.m2505o(67710);
    }

    /* renamed from: a */
    public void mo32844a(int i, int i2) {
        AppMethodBeat.m2504i(67711);
        if (this.f4055f) {
            TXCLog.m15679w(f4050a, "bkgpush: start background publish return when started");
            AppMethodBeat.m2505o(67711);
            return;
        }
        this.f4055f = true;
        m27661b(i, i2);
        m27662c();
        if (this.f4053d != null) {
            this.f4053d.sendEmptyMessageDelayed(1001, (long) this.f4051b);
        }
        TXCLog.m15679w(f4050a, "bkgpush: start background publish with time:" + ((this.f4052c - System.currentTimeMillis()) / 1000) + ", interval:" + this.f4051b);
        AppMethodBeat.m2505o(67711);
    }

    /* renamed from: a */
    public void mo32845a(int i, int i2, Bitmap bitmap, int i3, int i4) {
        AppMethodBeat.m2504i(67712);
        if (this.f4055f) {
            TXCLog.m15679w(f4050a, "bkgpush: start background publish return when started");
            AppMethodBeat.m2505o(67712);
            return;
        }
        if (bitmap == null) {
            try {
                TXCLog.m15679w(f4050a, "bkgpush: background publish img is empty, add default img");
                ColorDrawable colorDrawable = new ColorDrawable(WebView.NIGHT_MODE_COLOR);
                bitmap = Bitmap.createBitmap(i3, i4, Config.ARGB_8888);
                colorDrawable.draw(new Canvas(bitmap));
            } catch (Error | Exception e) {
            }
        }
        TXCLog.m15679w(f4050a, "bkgpush: generate bitmap");
        this.f4060k = bitmap;
        this.f4061l = i3;
        this.f4062m = i4;
        mo32844a(i, i2);
        AppMethodBeat.m2505o(67712);
    }

    /* renamed from: a */
    public void mo32843a() {
        AppMethodBeat.m2504i(67713);
        this.f4055f = false;
        this.f4059j = null;
        this.f4060k = null;
        TXCLog.m15679w(f4050a, "bkgpush: stop background publish");
        m27664d();
        AppMethodBeat.m2505o(67713);
    }

    /* renamed from: a */
    public void mo32846a(EGLContext eGLContext, Context context, Bitmap bitmap, int i, int i2) {
        AppMethodBeat.m2504i(67714);
        TXCLog.m15679w(f4050a, "bkgpush: generate background push");
        if (bitmap == null) {
            try {
                TXCLog.m15679w(f4050a, "bkgpush: background publish img is empty, add default img");
                ColorDrawable colorDrawable = new ColorDrawable(WebView.NIGHT_MODE_COLOR);
                bitmap = Bitmap.createBitmap(i, i2, Config.ARGB_8888);
                colorDrawable.draw(new Canvas(bitmap));
            } catch (Exception e) {
                AppMethodBeat.m2505o(67714);
                return;
            } catch (Error e2) {
                AppMethodBeat.m2505o(67714);
                return;
            }
        }
        TXCLog.m15679w(f4050a, "bkgpush: generate nal");
        TXSVideoEncoderParam tXSVideoEncoderParam = new TXSVideoEncoderParam();
        tXSVideoEncoderParam.width = i;
        tXSVideoEncoderParam.height = i2;
        tXSVideoEncoderParam.fps = 1;
        tXSVideoEncoderParam.gop = 1;
        tXSVideoEncoderParam.enableBFrame = false;
        tXSVideoEncoderParam.realTime = true;
        tXSVideoEncoderParam.encoderProfile = 1;
        tXSVideoEncoderParam.encoderMode = 1;
        tXSVideoEncoderParam.glContext = eGLContext;
        this.f4056g = new C0973b(2);
        this.f4056g.mo3923a((C0982d) this);
        this.f4056g.mo3916a(tXSVideoEncoderParam);
        if (i == 720 || i == ActUtil.HEIGHT) {
            this.f4056g.mo3921a(1800);
        } else if (i == VideoFilterUtil.IMAGE_HEIGHT || i == 544) {
            this.f4056g.mo3921a((int) TXLivePushConfig.DEFAULT_MAX_VIDEO_BITRATE);
        } else {
            this.f4056g.mo3921a(800);
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect((width * height) * 4);
        bitmap.copyPixelsToBuffer(allocateDirect);
        allocateDirect.rewind();
        if (this.f4058i == null) {
            this.f4058i = new C37363c(context, true);
            this.f4058i.mo60140a((C8811d) this);
        }
        this.f4058i.mo60139a(C17778b.m27738a(width, height, i, i2));
        this.f4058i.mo60143a(false);
        this.f4058i.mo60135a(i, i2);
        this.f4058i.mo60134a(0);
        this.f4058i.mo60131a(allocateDirect.array(), width, height, 0, 2, 0);
        this.f4058i.mo60132a();
        this.f4058i.mo60140a(null);
        this.f4058i = null;
        AppMethodBeat.m2505o(67714);
    }

    /* renamed from: b */
    private void m27661b(int i, int i2) {
        AppMethodBeat.m2504i(67715);
        if (i > 0) {
            if (i >= 8) {
                i = 8;
            } else if (i <= 3) {
                i = 3;
            }
            this.f4051b = 1000 / i;
        } else {
            this.f4051b = 200;
        }
        long j = (long) i2;
        if (i2 > 0) {
            this.f4052c = (j * 1000) + System.currentTimeMillis();
            AppMethodBeat.m2505o(67715);
            return;
        }
        this.f4052c = System.currentTimeMillis() + 300000;
        AppMethodBeat.m2505o(67715);
    }

    /* renamed from: c */
    private void m27662c() {
        AppMethodBeat.m2504i(67716);
        m27664d();
        this.f4054e = new HandlerThread("TXImageCapturer");
        this.f4054e.start();
        this.f4053d = new C17763a(this.f4054e.getLooper(), this.f4051b, this.f4052c);
        AppMethodBeat.m2505o(67716);
    }

    /* renamed from: d */
    private void m27664d() {
        AppMethodBeat.m2504i(67717);
        if (this.f4053d != null) {
            this.f4053d.removeCallbacksAndMessages(null);
            this.f4053d = null;
        }
        if (this.f4054e != null) {
            this.f4054e.quit();
            this.f4054e = null;
        }
        AppMethodBeat.m2505o(67717);
    }

    /* renamed from: e */
    private void m27665e() {
        AppMethodBeat.m2504i(67718);
        try {
            if (this.f4063n != null && this.f4055f) {
                C8789b c8789b = (C8789b) this.f4063n.get();
                if (c8789b != null) {
                    Bitmap bitmap = this.f4060k;
                    ByteBuffer byteBuffer = this.f4059j;
                    if (byteBuffer == null && bitmap != null) {
                        byteBuffer = ByteBuffer.allocateDirect((bitmap.getWidth() * bitmap.getHeight()) * 4);
                        bitmap.copyPixelsToBuffer(byteBuffer);
                        byteBuffer.rewind();
                        this.f4059j = byteBuffer;
                    }
                    if (!(bitmap == null || byteBuffer == null)) {
                        c8789b.mo19832a(bitmap, byteBuffer, this.f4061l, this.f4062m);
                    }
                }
            }
            AppMethodBeat.m2505o(67718);
        } catch (Exception e) {
            AppMethodBeat.m2505o(67718);
        }
    }
}
