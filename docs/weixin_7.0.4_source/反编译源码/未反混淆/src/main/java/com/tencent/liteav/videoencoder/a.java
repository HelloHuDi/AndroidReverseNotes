package com.tencent.liteav.videoencoder;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaCodec.CodecException;
import android.media.MediaCodecInfo;
import android.media.MediaCodecInfo.CodecCapabilities;
import android.media.MediaCodecInfo.CodecProfileLevel;
import android.media.MediaCodecInfo.EncoderCapabilities;
import android.media.MediaCodecList;
import android.media.MediaFormat;
import android.opengl.EGL14;
import android.opengl.EGLContext;
import android.opengl.GLES20;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.Surface;
import com.google.android.gms.common.Scopes;
import com.tencent.liteav.basic.e.b;
import com.tencent.liteav.basic.e.g;
import com.tencent.liteav.basic.e.j;
import com.tencent.liteav.basic.e.k;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import com.tencent.liteav.basic.util.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.ttpic.thread.FaceGestureDetGLThread;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayDeque;
import javax.microedition.khronos.egl.EGL10;

public class a extends c {
    private static final String a = a.class.getSimpleName();
    private boolean A;
    private boolean B;
    private ByteBuffer[] C;
    private byte[] D;
    private volatile long E;
    private long F;
    private long G;
    private int H;
    private int I;
    private boolean J;
    private int K;
    private int L;
    private int M;
    private int N;
    private int b;
    private long c;
    private long d;
    private long e;
    private long f;
    private int g;
    private boolean h;
    private boolean i;
    private long j;
    private long k;
    private long l;
    private long m;
    private long n;
    private boolean o;
    private long p;
    private long q;
    private MediaCodec r;
    private c s;
    private Runnable t;
    private Runnable u;
    private Runnable v;
    private ArrayDeque<Long> w;
    private Object x;
    private Surface y;
    private boolean z;

    static /* synthetic */ void b(a aVar, int i) {
        AppMethodBeat.i(67392);
        aVar.c(i);
        AppMethodBeat.o(67392);
    }

    static /* synthetic */ int c(a aVar, int i) {
        AppMethodBeat.i(67393);
        int a = aVar.a(i);
        AppMethodBeat.o(67393);
        return a;
    }

    static /* synthetic */ void d(a aVar, int i) {
        AppMethodBeat.i(67394);
        aVar.b(i);
        AppMethodBeat.o(67394);
    }

    public a() {
        AppMethodBeat.i(67366);
        this.b = 0;
        this.c = 0;
        this.d = 0;
        this.e = 0;
        this.f = 0;
        this.g = 0;
        this.h = false;
        this.i = true;
        this.j = 0;
        this.k = 0;
        this.l = 0;
        this.m = 0;
        this.n = 0;
        this.p = 0;
        this.q = 0;
        this.r = null;
        this.s = null;
        this.t = new Runnable() {
            public void run() {
                AppMethodBeat.i(67439);
                a.a(a.this);
                AppMethodBeat.o(67439);
            }
        };
        this.u = new Runnable() {
            public void run() {
                AppMethodBeat.i(67440);
                a.d(a.this, 10);
                AppMethodBeat.o(67440);
            }
        };
        this.v = new Runnable() {
            public void run() {
                AppMethodBeat.i(67364);
                a.d(a.this, 1);
                AppMethodBeat.o(67364);
            }
        };
        this.w = new ArrayDeque(10);
        this.y = null;
        this.z = true;
        this.A = true;
        this.B = false;
        this.C = null;
        this.D = null;
        this.E = 0;
        this.F = 0;
        this.G = 0;
        this.K = 0;
        this.L = 0;
        this.M = 0;
        this.N = -1;
        this.s = new c("HWVideoEncoder");
        AppMethodBeat.o(67366);
    }

    public int start(final TXSVideoEncoderParam tXSVideoEncoderParam) {
        AppMethodBeat.i(67367);
        super.start(tXSVideoEncoderParam);
        final boolean[] zArr = new boolean[1];
        if (VERSION.SDK_INT < 18) {
            zArr[0] = false;
        } else {
            synchronized (this) {
                try {
                    this.s.a(new Runnable() {
                        public void run() {
                            AppMethodBeat.i(67441);
                            if (a.this.mInit) {
                                a.a(a.this);
                            }
                            zArr[0] = a.a(a.this, tXSVideoEncoderParam);
                            AppMethodBeat.o(67441);
                        }
                    });
                } catch (Throwable th) {
                    AppMethodBeat.o(67367);
                }
            }
        }
        if (!zArr[0]) {
            callDelegate(10000004);
        }
        if (zArr[0]) {
            AppMethodBeat.o(67367);
            return 0;
        }
        AppMethodBeat.o(67367);
        return 10000004;
    }

    public void stop() {
        AppMethodBeat.i(67368);
        this.A = true;
        synchronized (this) {
            try {
                this.s.a(new Runnable() {
                    public void run() {
                        AppMethodBeat.i(67437);
                        if (a.this.mInit) {
                            a.a(a.this);
                        }
                        AppMethodBeat.o(67437);
                    }
                });
            } finally {
                while (true) {
                }
                AppMethodBeat.o(67368);
            }
        }
    }

    public void setFPS(final int i) {
        AppMethodBeat.i(67369);
        this.s.b(new Runnable() {
            public void run() {
                AppMethodBeat.i(67396);
                a.a(a.this, i);
                AppMethodBeat.o(67396);
            }
        });
        AppMethodBeat.o(67369);
    }

    public void setBitrate(final int i) {
        AppMethodBeat.i(67370);
        this.b = i;
        this.s.b(new Runnable() {
            public void run() {
                AppMethodBeat.i(67365);
                a.b(a.this, i);
                AppMethodBeat.o(67365);
            }
        });
        AppMethodBeat.o(67370);
    }

    public long getRealFPS() {
        return this.d;
    }

    public long getRealBitrate() {
        return this.c;
    }

    public long pushVideoFrame(int i, int i2, int i3, long j) {
        AppMethodBeat.i(67371);
        if (this.A) {
            AppMethodBeat.o(67371);
            return 10000004;
        }
        GLES20.glFinish();
        this.E = j;
        this.N = i;
        this.K++;
        if (this.J) {
            d();
        }
        this.s.b(this.u);
        AppMethodBeat.o(67371);
        return 0;
    }

    public long pushVideoFrameSync(int i, int i2, int i3, long j) {
        AppMethodBeat.i(67372);
        if (this.A) {
            AppMethodBeat.o(67372);
            return 10000004;
        }
        GLES20.glFinish();
        this.E = j;
        this.N = i;
        this.K++;
        if (this.J) {
            d();
        }
        this.s.a(this.v);
        AppMethodBeat.o(67372);
        return 0;
    }

    public void signalEOSAndFlush() {
        AppMethodBeat.i(67373);
        if (this.A) {
            AppMethodBeat.o(67373);
            return;
        }
        this.s.a(new Runnable() {
            public void run() {
                AppMethodBeat.i(67363);
                if (a.this.r == null) {
                    AppMethodBeat.o(67363);
                    return;
                }
                try {
                    a.this.r.signalEndOfInputStream();
                } catch (Exception e) {
                }
                do {
                } while (a.c(a.this, 10) >= 0);
                a.a(a.this);
                AppMethodBeat.o(67363);
            }
        });
        AppMethodBeat.o(67373);
    }

    @TargetApi(16)
    private MediaFormat a(int i, int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(67374);
        if (i == 0 || i2 == 0 || i3 == 0 || i4 == 0) {
            AppMethodBeat.o(67374);
            return null;
        }
        MediaFormat createVideoFormat = MediaFormat.createVideoFormat("video/avc", i, i2);
        createVideoFormat.setInteger(FFmpegMetadataRetriever.METADATA_KEY_VARIANT_BITRATE, i3 * WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
        createVideoFormat.setInteger("frame-rate", i4);
        createVideoFormat.setInteger("color-format", 2130708361);
        createVideoFormat.setInteger("i-frame-interval", i5);
        AppMethodBeat.o(67374);
        return createVideoFormat;
    }

    @TargetApi(16)
    private MediaFormat a(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        AppMethodBeat.i(67375);
        MediaFormat a = a(i, i2, i3, i4, i5);
        if (a == null) {
            AppMethodBeat.o(67375);
            return null;
        }
        if (VERSION.SDK_INT >= 21) {
            MediaCodecInfo a2 = a("video/avc");
            if (a2 == null) {
                AppMethodBeat.o(67375);
                return a;
            }
            CodecCapabilities capabilitiesForType = a2.getCapabilitiesForType("video/avc");
            EncoderCapabilities encoderCapabilities = capabilitiesForType.getEncoderCapabilities();
            if (encoderCapabilities.isBitrateModeSupported(i6)) {
                a.setInteger("bitrate-mode", i6);
            } else if (encoderCapabilities.isBitrateModeSupported(2)) {
                a.setInteger("bitrate-mode", 2);
            }
            a.setInteger("complexity", ((Integer) encoderCapabilities.getComplexityRange().clamp(Integer.valueOf(5))).intValue());
            int i8 = 0;
            if (VERSION.SDK_INT >= 23) {
                for (CodecProfileLevel codecProfileLevel : capabilitiesForType.profileLevels) {
                    if (codecProfileLevel.profile <= i7 && codecProfileLevel.profile > i8) {
                        i8 = codecProfileLevel.profile;
                        a.setInteger(Scopes.PROFILE, codecProfileLevel.profile);
                        a.setInteger("level", codecProfileLevel.level);
                    }
                }
            }
        }
        AppMethodBeat.o(67375);
        return a;
    }

    @TargetApi(16)
    private static MediaCodecInfo a(String str) {
        AppMethodBeat.i(67376);
        int codecCount = MediaCodecList.getCodecCount();
        for (int i = 0; i < codecCount; i++) {
            MediaCodecInfo codecInfoAt = MediaCodecList.getCodecInfoAt(i);
            if (codecInfoAt.isEncoder()) {
                for (String equalsIgnoreCase : codecInfoAt.getSupportedTypes()) {
                    if (equalsIgnoreCase.equalsIgnoreCase(str)) {
                        AppMethodBeat.o(67376);
                        return codecInfoAt;
                    }
                }
                continue;
            }
        }
        AppMethodBeat.o(67376);
        return null;
    }

    private void a(long j) {
        AppMethodBeat.i(67377);
        this.w.add(Long.valueOf(j));
        AppMethodBeat.o(67377);
    }

    private long a() {
        AppMethodBeat.i(67378);
        Long l = (Long) this.w.poll();
        if (l == null) {
            AppMethodBeat.o(67378);
            return 0;
        }
        long longValue = l.longValue();
        AppMethodBeat.o(67378);
        return longValue;
    }

    private boolean a(Surface surface, int i, int i2) {
        AppMethodBeat.i(67379);
        if (surface == null) {
            AppMethodBeat.o(67379);
            return false;
        }
        if (this.B) {
            EGLContext eGLContext = (EGLContext) this.mGLContextExternal;
            if (eGLContext == null) {
                eGLContext = EGL14.EGL_NO_CONTEXT;
            }
            this.x = com.tencent.liteav.basic.e.c.a(null, eGLContext, surface, i, i2);
        } else {
            javax.microedition.khronos.egl.EGLContext eGLContext2 = (javax.microedition.khronos.egl.EGLContext) this.mGLContextExternal;
            if (eGLContext2 == null) {
                eGLContext2 = EGL10.EGL_NO_CONTEXT;
            }
            this.x = b.a(null, eGLContext2, surface, i, i2);
        }
        if (this.x == null) {
            AppMethodBeat.o(67379);
            return false;
        }
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        this.mEncodeFilter = new g();
        this.mEncodeFilter.a(k.e, k.a(j.NORMAL, false, false));
        if (this.mEncodeFilter.a()) {
            GLES20.glViewport(0, 0, i, i2);
            AppMethodBeat.o(67379);
            return true;
        }
        this.mEncodeFilter = null;
        AppMethodBeat.o(67379);
        return false;
    }

    private void b() {
        AppMethodBeat.i(67380);
        if (this.mEncodeFilter != null) {
            this.mEncodeFilter.d();
            this.mEncodeFilter = null;
        }
        if (this.x instanceof b) {
            ((b) this.x).b();
            this.x = null;
        }
        if (this.x instanceof com.tencent.liteav.basic.e.c) {
            ((com.tencent.liteav.basic.e.c) this.x).b();
            this.x = null;
        }
        AppMethodBeat.o(67380);
    }

    /* JADX WARNING: Removed duplicated region for block: B:55:0x0131 A:{SYNTHETIC, Splitter:B:55:0x0131} */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0141 A:{Catch:{ Exception -> 0x014a }} */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00f6  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x0131 A:{SYNTHETIC, Splitter:B:55:0x0131} */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0141 A:{Catch:{ Exception -> 0x014a }} */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00f6  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    @TargetApi(18)
    private boolean a(TXSVideoEncoderParam tXSVideoEncoderParam) {
        int i;
        AppMethodBeat.i(67381);
        this.A = false;
        this.z = false;
        this.c = 0;
        this.d = 0;
        this.e = 0;
        this.f = 0;
        this.g = 0;
        this.j = 0;
        this.k = 0;
        this.l = 0;
        this.m = 0;
        this.n = 0;
        this.p = 0;
        this.q = 0;
        this.C = null;
        this.D = null;
        this.E = 0;
        this.H = -1;
        this.mOutputWidth = tXSVideoEncoderParam.width;
        this.mOutputHeight = tXSVideoEncoderParam.height;
        this.I = tXSVideoEncoderParam.gop;
        this.J = tXSVideoEncoderParam.fullIFrame;
        this.o = tXSVideoEncoderParam.syncOutput;
        this.B = tXSVideoEncoderParam.enableEGL14;
        this.w.clear();
        if (tXSVideoEncoderParam == null || tXSVideoEncoderParam.width == 0 || tXSVideoEncoderParam.height == 0 || tXSVideoEncoderParam.fps == 0 || tXSVideoEncoderParam.gop == 0) {
            this.z = true;
            AppMethodBeat.o(67381);
            return false;
        }
        this.h = tXSVideoEncoderParam.annexb;
        this.i = tXSVideoEncoderParam.appendSpsPps;
        if (this.b == 0) {
            this.b = (int) (Math.sqrt((((double) (tXSVideoEncoderParam.width * tXSVideoEncoderParam.width)) * 1.0d) + ((double) (tXSVideoEncoderParam.height * tXSVideoEncoderParam.height))) * 1.2d);
        }
        this.j = (long) this.b;
        this.g = tXSVideoEncoderParam.fps;
        int i2 = 2;
        switch (tXSVideoEncoderParam.encoderMode) {
            case 1:
                i2 = 2;
                break;
            case 2:
                i2 = 1;
                break;
            case 3:
                i2 = 0;
                break;
        }
        if (com.tencent.liteav.basic.f.b.a().c() == 1) {
            tXSVideoEncoderParam.encoderProfile = 1;
        }
        try {
            MediaFormat a = a(tXSVideoEncoderParam.width, tXSVideoEncoderParam.height, this.b, tXSVideoEncoderParam.fps, tXSVideoEncoderParam.gop, i2, 1);
            if (a == null) {
                this.z = true;
                AppMethodBeat.o(67381);
                return false;
            }
            this.r = MediaCodec.createEncoderByType("video/avc");
            try {
                this.r.configure(a, null, null, 1);
            } catch (Exception e) {
                if ((e instanceof IllegalArgumentException) || (VERSION.SDK_INT >= 21 && (e instanceof CodecException))) {
                    this.r.configure(a(tXSVideoEncoderParam.width, tXSVideoEncoderParam.height, this.b, tXSVideoEncoderParam.fps, tXSVideoEncoderParam.gop), null, null, 1);
                } else {
                    AppMethodBeat.o(67381);
                    throw e;
                }
            } catch (Exception e2) {
                i = 2;
                if (i >= 5) {
                    try {
                        if (this.r != null) {
                            this.r.stop();
                        }
                    } catch (Exception e3) {
                    }
                }
                this.r = null;
                if (this.y != null) {
                    this.y.release();
                }
                this.y = null;
                if (this.r != null) {
                }
                this.z = true;
                AppMethodBeat.o(67381);
                return false;
            }
            i = 3;
            try {
                this.y = this.r.createInputSurface();
                this.r.start();
                i = 5;
                this.C = this.r.getOutputBuffers();
            } catch (Exception e4) {
                if (i >= 5) {
                }
                this.r = null;
                if (this.y != null) {
                }
                this.y = null;
                if (this.r != null) {
                }
                this.z = true;
                AppMethodBeat.o(67381);
                return false;
            }
            if (this.r != null || this.C == null || this.y == null) {
                this.z = true;
                AppMethodBeat.o(67381);
                return false;
            } else if (a(this.y, tXSVideoEncoderParam.width, tXSVideoEncoderParam.height)) {
                this.mInit = true;
                AppMethodBeat.o(67381);
                return true;
            } else {
                this.z = true;
                AppMethodBeat.o(67381);
                return false;
            }
        } catch (Exception e5) {
            i = 1;
            if (i >= 5) {
            }
            this.r = null;
            if (this.y != null) {
            }
            this.y = null;
            if (this.r != null) {
            }
            this.z = true;
            AppMethodBeat.o(67381);
            return false;
        }
    }

    private int a(int i) {
        AppMethodBeat.i(67382);
        if (this.r == null) {
            AppMethodBeat.o(67382);
            return -1;
        }
        BufferInfo bufferInfo = new BufferInfo();
        try {
            int dequeueOutputBuffer = this.r.dequeueOutputBuffer(bufferInfo, (long) (i * 1000));
            if (dequeueOutputBuffer == -1) {
                AppMethodBeat.o(67382);
                return 0;
            } else if (dequeueOutputBuffer == -3) {
                this.C = this.r.getOutputBuffers();
                AppMethodBeat.o(67382);
                return 1;
            } else if (dequeueOutputBuffer == -2) {
                callDelegate(this.r.getOutputFormat());
                AppMethodBeat.o(67382);
                return 1;
            } else if (dequeueOutputBuffer < 0) {
                AppMethodBeat.o(67382);
                return -1;
            } else {
                int i2;
                ByteBuffer byteBuffer = this.C[dequeueOutputBuffer];
                if (byteBuffer == null) {
                    i2 = -1;
                } else {
                    byte[] bArr;
                    Object obj = new byte[bufferInfo.size];
                    byteBuffer.position(bufferInfo.offset);
                    byteBuffer.limit(bufferInfo.offset + bufferInfo.size);
                    byteBuffer.get(obj, 0, bufferInfo.size);
                    i2 = obj.length;
                    if (bufferInfo.size > 5 && obj[0] == (byte) 0 && obj[1] == (byte) 0 && obj[2] == (byte) 0 && obj[3] == (byte) 0 && obj[4] == (byte) 0 && obj[5] == (byte) 0) {
                        int i3 = 3;
                        while (i3 < i2 - 4) {
                            if (obj[i3] == (byte) 0 && obj[i3 + 1] == (byte) 0 && obj[i3 + 2] == (byte) 0 && obj[i3 + 3] == (byte) 1) {
                                i2 -= i3;
                                break;
                            }
                            i3++;
                        }
                        i3 = 0;
                        Object obj2 = new byte[i2];
                        System.arraycopy(obj, i3, obj2, 0, i2);
                        bArr = obj2;
                    } else {
                        Object bArr2 = obj;
                    }
                    if (bufferInfo.size != 0) {
                        int i4 = 1;
                        if ((bufferInfo.flags & 2) == 2) {
                            if (this.h) {
                                this.D = (byte[]) bArr2.clone();
                            } else {
                                this.D = a((byte[]) bArr2.clone());
                            }
                            i2 = 1;
                        } else {
                            byte[] bArr3;
                            if ((bufferInfo.flags & 1) == 1) {
                                i4 = 0;
                                this.H = -1;
                                if (this.h) {
                                    bArr3 = new byte[(this.D.length + bArr2.length)];
                                    System.arraycopy(this.D, 0, bArr3, 0, this.D.length);
                                    System.arraycopy(bArr2, 0, bArr3, this.D.length, bArr2.length);
                                } else {
                                    bArr2 = a(bArr2);
                                    bArr3 = new byte[(this.D.length + bArr2.length)];
                                    System.arraycopy(this.D, 0, bArr3, 0, this.D.length);
                                    System.arraycopy(bArr2, 0, bArr3, this.D.length, bArr2.length);
                                }
                            } else if (this.h) {
                                bArr3 = bArr2;
                            } else {
                                bArr3 = a(bArr2);
                            }
                            if (!this.J) {
                                i2 = this.H + 1;
                                this.H = i2;
                                if (i2 == this.g * this.I) {
                                    d();
                                }
                            }
                            long a = a();
                            long j = bufferInfo.presentationTimeUs / 1000;
                            if (this.G == 0) {
                                this.G = a;
                            }
                            if (this.F == 0) {
                                this.F = j;
                            }
                            long j2 = j + (this.G - this.F);
                            if (a <= this.n) {
                                a = this.n + 1;
                            }
                            if (a > j2) {
                                a = j2;
                            }
                            this.n = a;
                            a = TXCTimeUtil.getTimeTick();
                            if (i4 == 0) {
                                if (a > this.e + 1000) {
                                    this.c = (long) (((((double) this.p) * 8000.0d) / ((double) (a - this.e))) / 1024.0d);
                                    this.p = 0;
                                    this.e = a;
                                }
                                this.k++;
                                this.l = 0;
                            } else {
                                this.l++;
                            }
                            this.p += (long) bArr3.length;
                            if (a > this.f + FaceGestureDetGLThread.BRIGHTNESS_DURATION) {
                                this.d = (long) ((((double) this.q) * 1000.0d) / ((double) (a - this.f)));
                                this.q = 0;
                                this.f = a;
                            }
                            this.q++;
                            byteBuffer.position(bufferInfo.offset);
                            if (this.i) {
                                callDelegate(bArr3, i4, this.k, this.l, this.m, i4 == 0 ? 0 : this.l - 1, j2, j2, 0, byteBuffer, bufferInfo);
                            } else {
                                callDelegate(obj, i4, this.k, this.l, this.m, i4 == 0 ? 0 : this.l - 1, j2, j2, 0, byteBuffer, bufferInfo);
                            }
                            this.m++;
                            this.M++;
                            if ((bufferInfo.flags & 4) != 0) {
                                if (this.mListener != null) {
                                    this.mListener.a(null, 0);
                                }
                                i2 = -2;
                            } else {
                                i2 = 1;
                            }
                        }
                    } else if ((bufferInfo.flags & 4) != 0) {
                        if (this.mListener != null) {
                            this.mListener.a(null, 0);
                        }
                        i2 = -2;
                    } else {
                        i2 = -1;
                    }
                }
                try {
                    if (this.r != null) {
                        this.r.releaseOutputBuffer(dequeueOutputBuffer, false);
                    }
                } catch (IllegalStateException e) {
                }
                AppMethodBeat.o(67382);
                return i2;
            }
        } catch (IllegalStateException e2) {
            AppMethodBeat.o(67382);
            return -1;
        }
    }

    private byte[] a(byte[] bArr) {
        int i;
        AppMethodBeat.i(67383);
        int length = bArr.length;
        byte[] bArr2 = new byte[(length + 20)];
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i2 < length) {
            if (bArr[i2] == (byte) 0 && bArr[i2 + 1] == (byte) 0 && bArr[i2 + 2] == (byte) 1) {
                i4 = a(i2, i3, bArr2, bArr, i4);
                i = i2 + 3;
                i2 = i;
                i3 = i;
            } else if (bArr[i2] == (byte) 0 && bArr[i2 + 1] == (byte) 0 && bArr[i2 + 2] == (byte) 0 && bArr[i2 + 3] == (byte) 1) {
                i4 = a(i2, i3, bArr2, bArr, i4);
                i = i2 + 4;
                i2 = i;
                i3 = i;
            }
            if (i2 == length - 4 && (bArr[i2 + 1] != (byte) 0 || bArr[i2 + 2] != (byte) 0 || bArr[i2 + 3] != (byte) 1)) {
                i2 = length;
                break;
            }
            i2++;
        }
        i = a(i2, i3, bArr2, bArr, i4);
        byte[] bArr3 = new byte[i];
        System.arraycopy(bArr2, 0, bArr3, 0, i);
        AppMethodBeat.o(67383);
        return bArr3;
    }

    private int a(int i, int i2, byte[] bArr, byte[] bArr2, int i3) {
        AppMethodBeat.i(67384);
        if (i2 > 0 && i > i2) {
            int i4 = i - i2;
            try {
                ByteBuffer wrap = ByteBuffer.wrap(new byte[4]);
                wrap.asIntBuffer().put(i4);
                wrap.order(ByteOrder.BIG_ENDIAN);
                System.arraycopy(wrap.array(), 0, bArr, i3, 4);
                System.arraycopy(bArr2, i2, bArr, i3 + 4, i4);
                i3 += i4 + 4;
            } catch (Exception e) {
                TXCLog.e(a, "setNalData exception");
            }
        }
        AppMethodBeat.o(67384);
        return i3;
    }

    @TargetApi(18)
    private void b(int i) {
        AppMethodBeat.i(67385);
        if (this.z || this.x == null) {
            AppMethodBeat.o(67385);
            return;
        }
        int a;
        a(this.E);
        this.mEncodeFilter.a(this.N);
        if (this.x instanceof com.tencent.liteav.basic.e.c) {
            ((com.tencent.liteav.basic.e.c) this.x).a(this.E * 1000000);
            ((com.tencent.liteav.basic.e.c) this.x).c();
        }
        if (this.x instanceof b) {
            ((b) this.x).a();
        }
        do {
            a = a(i);
        } while (a > 0);
        if (a == -1 || a == -2) {
            if (a == -1) {
                callDelegate(10000005);
            }
            this.z = true;
            c();
            AppMethodBeat.o(67385);
            return;
        }
        this.L++;
        AppMethodBeat.o(67385);
    }

    private void c() {
        AppMethodBeat.i(67386);
        if (this.mInit) {
            this.z = true;
            this.A = true;
            b();
            try {
                this.r.stop();
                try {
                    this.r.release();
                } catch (Exception e) {
                }
            } catch (IllegalStateException e2) {
                try {
                    this.r.release();
                } catch (Exception e3) {
                }
            } catch (Throwable th) {
                try {
                    this.r.release();
                } catch (Exception e4) {
                }
                AppMethodBeat.o(67386);
            }
            this.r = null;
            this.N = -1;
            this.c = 0;
            this.d = 0;
            this.e = 0;
            this.f = 0;
            this.g = 0;
            this.j = 0;
            this.k = 0;
            this.l = 0;
            this.m = 0;
            this.n = 0;
            this.p = 0;
            this.q = 0;
            this.mGLContextExternal = null;
            this.C = null;
            this.D = null;
            this.E = 0;
            this.mOutputWidth = 0;
            this.mOutputHeight = 0;
            this.mInit = false;
            this.mListener = null;
            this.w.clear();
            AppMethodBeat.o(67386);
            return;
        }
        AppMethodBeat.o(67386);
    }

    private void c(int i) {
        AppMethodBeat.i(67387);
        if (this.j == ((long) this.b)) {
            AppMethodBeat.o(67387);
            return;
        }
        this.j = (long) this.b;
        if (VERSION.SDK_INT >= 19 && this.r != null) {
            Bundle bundle = new Bundle();
            bundle.putInt("video-bitrate", this.b * WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
            this.r.setParameters(bundle);
        }
        AppMethodBeat.o(67387);
    }

    private void d() {
        AppMethodBeat.i(67388);
        if (VERSION.SDK_INT >= 19 && this.r != null) {
            Bundle bundle = new Bundle();
            bundle.putInt("request-sync", 0);
            this.r.setParameters(bundle);
        }
        AppMethodBeat.o(67388);
    }

    private void d(int i) {
    }

    static {
        AppMethodBeat.i(67395);
        AppMethodBeat.o(67395);
    }
}
