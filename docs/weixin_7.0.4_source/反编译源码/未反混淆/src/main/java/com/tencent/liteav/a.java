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
import com.tencent.liteav.basic.util.TXCTimeUtil;
import com.tencent.liteav.beauty.c;
import com.tencent.liteav.beauty.d;
import com.tencent.liteav.videoencoder.TXSVideoEncoderParam;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.rtmp.TXLivePushConfig;
import com.tencent.smtt.sdk.WebView;
import com.tencent.ttpic.util.ActUtil;
import com.tencent.ttpic.util.VideoFilterUtil;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import javax.microedition.khronos.egl.EGLContext;

public class a implements d, com.tencent.liteav.videoencoder.d {
    private static final String a = a.class.getSimpleName();
    private int b = 300;
    private long c = 0;
    private a d;
    private HandlerThread e;
    private boolean f = false;
    private com.tencent.liteav.videoencoder.b g;
    private com.tencent.liteav.basic.g.b h;
    private c i = null;
    private ByteBuffer j = null;
    private Bitmap k = null;
    private int l = 0;
    private int m = 0;
    private WeakReference<b> n = null;

    public interface b {
        void a();

        void a(Bitmap bitmap, ByteBuffer byteBuffer, int i, int i2);

        void a(com.tencent.liteav.videoencoder.b bVar);
    }

    class a extends Handler {
        private int b = 300;
        private long c = 0;

        public a(Looper looper, int i, long j) {
            super(looper);
            this.b = i;
            this.c = j;
        }

        public void handleMessage(Message message) {
            AppMethodBeat.i(66380);
            if (message.what == 1001) {
                try {
                    a.a(a.this);
                    if (System.currentTimeMillis() < this.c) {
                        sendEmptyMessageDelayed(1001, (long) this.b);
                        AppMethodBeat.o(66380);
                        return;
                    }
                    TXCLog.w(a.a, "bkgpush:stop background publish when timeout");
                    if (a.this.n != null && a.this.f) {
                        b bVar = (b) a.this.n.get();
                        if (bVar != null) {
                            bVar.a();
                        }
                        a.this.f = false;
                    }
                    AppMethodBeat.o(66380);
                    return;
                } catch (Exception e) {
                }
            }
            AppMethodBeat.o(66380);
        }
    }

    static {
        AppMethodBeat.i(67720);
        AppMethodBeat.o(67720);
    }

    public int a(int i, int i2, int i3) {
        return 0;
    }

    public void a(int i, int i2, int i3, long j) {
        AppMethodBeat.i(67708);
        TXCLog.w(a, "bkgpush: got texture");
        if (this.g != null) {
            this.g.a(i, i2, i3, TXCTimeUtil.getTimeTick());
        }
        AppMethodBeat.o(67708);
    }

    public void a(byte[] bArr, int i, int i2, int i3, long j) {
    }

    public void a(com.tencent.liteav.basic.g.b bVar, int i) {
        Object bVar2;
        AppMethodBeat.i(67709);
        this.h = bVar2;
        String str = a;
        StringBuilder stringBuilder = new StringBuilder("bkgpush: got nal type: ");
        if (bVar2 != null) {
            bVar2 = Integer.valueOf(bVar2.b);
        }
        TXCLog.w(str, stringBuilder.append(bVar2).toString());
        if (this.g != null) {
            this.g.a(null);
            com.tencent.liteav.videoencoder.b bVar3 = this.g;
            try {
                if (this.n != null) {
                    b bVar4 = (b) this.n.get();
                    if (bVar4 != null) {
                        bVar4.a(bVar3);
                    }
                }
                AppMethodBeat.o(67709);
                return;
            } catch (Exception e) {
            }
        }
        AppMethodBeat.o(67709);
    }

    public void a(MediaFormat mediaFormat) {
    }

    public a(b bVar) {
        AppMethodBeat.i(67710);
        this.n = new WeakReference(bVar);
        AppMethodBeat.o(67710);
    }

    public void a(int i, int i2) {
        AppMethodBeat.i(67711);
        if (this.f) {
            TXCLog.w(a, "bkgpush: start background publish return when started");
            AppMethodBeat.o(67711);
            return;
        }
        this.f = true;
        b(i, i2);
        c();
        if (this.d != null) {
            this.d.sendEmptyMessageDelayed(1001, (long) this.b);
        }
        TXCLog.w(a, "bkgpush: start background publish with time:" + ((this.c - System.currentTimeMillis()) / 1000) + ", interval:" + this.b);
        AppMethodBeat.o(67711);
    }

    public void a(int i, int i2, Bitmap bitmap, int i3, int i4) {
        AppMethodBeat.i(67712);
        if (this.f) {
            TXCLog.w(a, "bkgpush: start background publish return when started");
            AppMethodBeat.o(67712);
            return;
        }
        if (bitmap == null) {
            try {
                TXCLog.w(a, "bkgpush: background publish img is empty, add default img");
                ColorDrawable colorDrawable = new ColorDrawable(WebView.NIGHT_MODE_COLOR);
                bitmap = Bitmap.createBitmap(i3, i4, Config.ARGB_8888);
                colorDrawable.draw(new Canvas(bitmap));
            } catch (Error | Exception e) {
            }
        }
        TXCLog.w(a, "bkgpush: generate bitmap");
        this.k = bitmap;
        this.l = i3;
        this.m = i4;
        a(i, i2);
        AppMethodBeat.o(67712);
    }

    public void a() {
        AppMethodBeat.i(67713);
        this.f = false;
        this.j = null;
        this.k = null;
        TXCLog.w(a, "bkgpush: stop background publish");
        d();
        AppMethodBeat.o(67713);
    }

    public void a(EGLContext eGLContext, Context context, Bitmap bitmap, int i, int i2) {
        AppMethodBeat.i(67714);
        TXCLog.w(a, "bkgpush: generate background push");
        if (bitmap == null) {
            try {
                TXCLog.w(a, "bkgpush: background publish img is empty, add default img");
                ColorDrawable colorDrawable = new ColorDrawable(WebView.NIGHT_MODE_COLOR);
                bitmap = Bitmap.createBitmap(i, i2, Config.ARGB_8888);
                colorDrawable.draw(new Canvas(bitmap));
            } catch (Exception e) {
                AppMethodBeat.o(67714);
                return;
            } catch (Error e2) {
                AppMethodBeat.o(67714);
                return;
            }
        }
        TXCLog.w(a, "bkgpush: generate nal");
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
        this.g = new com.tencent.liteav.videoencoder.b(2);
        this.g.a((com.tencent.liteav.videoencoder.d) this);
        this.g.a(tXSVideoEncoderParam);
        if (i == 720 || i == ActUtil.HEIGHT) {
            this.g.a(1800);
        } else if (i == VideoFilterUtil.IMAGE_HEIGHT || i == 544) {
            this.g.a((int) TXLivePushConfig.DEFAULT_MAX_VIDEO_BITRATE);
        } else {
            this.g.a(800);
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect((width * height) * 4);
        bitmap.copyPixelsToBuffer(allocateDirect);
        allocateDirect.rewind();
        if (this.i == null) {
            this.i = new c(context, true);
            this.i.a((d) this);
        }
        this.i.a(com.tencent.liteav.basic.util.b.a(width, height, i, i2));
        this.i.a(false);
        this.i.a(i, i2);
        this.i.a(0);
        this.i.a(allocateDirect.array(), width, height, 0, 2, 0);
        this.i.a();
        this.i.a(null);
        this.i = null;
        AppMethodBeat.o(67714);
    }

    private void b(int i, int i2) {
        AppMethodBeat.i(67715);
        if (i > 0) {
            if (i >= 8) {
                i = 8;
            } else if (i <= 3) {
                i = 3;
            }
            this.b = 1000 / i;
        } else {
            this.b = 200;
        }
        long j = (long) i2;
        if (i2 > 0) {
            this.c = (j * 1000) + System.currentTimeMillis();
            AppMethodBeat.o(67715);
            return;
        }
        this.c = System.currentTimeMillis() + 300000;
        AppMethodBeat.o(67715);
    }

    private void c() {
        AppMethodBeat.i(67716);
        d();
        this.e = new HandlerThread("TXImageCapturer");
        this.e.start();
        this.d = new a(this.e.getLooper(), this.b, this.c);
        AppMethodBeat.o(67716);
    }

    private void d() {
        AppMethodBeat.i(67717);
        if (this.d != null) {
            this.d.removeCallbacksAndMessages(null);
            this.d = null;
        }
        if (this.e != null) {
            this.e.quit();
            this.e = null;
        }
        AppMethodBeat.o(67717);
    }

    private void e() {
        AppMethodBeat.i(67718);
        try {
            if (this.n != null && this.f) {
                b bVar = (b) this.n.get();
                if (bVar != null) {
                    Bitmap bitmap = this.k;
                    ByteBuffer byteBuffer = this.j;
                    if (byteBuffer == null && bitmap != null) {
                        byteBuffer = ByteBuffer.allocateDirect((bitmap.getWidth() * bitmap.getHeight()) * 4);
                        bitmap.copyPixelsToBuffer(byteBuffer);
                        byteBuffer.rewind();
                        this.j = byteBuffer;
                    }
                    if (!(bitmap == null || byteBuffer == null)) {
                        bVar.a(bitmap, byteBuffer, this.l, this.m);
                    }
                }
            }
            AppMethodBeat.o(67718);
        } catch (Exception e) {
            AppMethodBeat.o(67718);
        }
    }
}
