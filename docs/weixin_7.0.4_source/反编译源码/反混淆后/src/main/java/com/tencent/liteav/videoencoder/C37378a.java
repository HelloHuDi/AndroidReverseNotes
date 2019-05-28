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
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.p1169f.C45104b;
import com.tencent.liteav.basic.p141e.C32141b;
import com.tencent.liteav.basic.p141e.C32142c;
import com.tencent.liteav.basic.p141e.C37353j;
import com.tencent.liteav.basic.p141e.C45103k;
import com.tencent.liteav.basic.p141e.C8796g;
import com.tencent.liteav.basic.util.C17779c;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.ttpic.thread.FaceGestureDetGLThread;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayDeque;
import javax.microedition.khronos.egl.EGL10;

/* renamed from: com.tencent.liteav.videoencoder.a */
public class C37378a extends C0981c {
    /* renamed from: a */
    private static final String f16025a = C37378a.class.getSimpleName();
    /* renamed from: A */
    private boolean f16026A;
    /* renamed from: B */
    private boolean f16027B;
    /* renamed from: C */
    private ByteBuffer[] f16028C;
    /* renamed from: D */
    private byte[] f16029D;
    /* renamed from: E */
    private volatile long f16030E;
    /* renamed from: F */
    private long f16031F;
    /* renamed from: G */
    private long f16032G;
    /* renamed from: H */
    private int f16033H;
    /* renamed from: I */
    private int f16034I;
    /* renamed from: J */
    private boolean f16035J;
    /* renamed from: K */
    private int f16036K;
    /* renamed from: L */
    private int f16037L;
    /* renamed from: M */
    private int f16038M;
    /* renamed from: N */
    private int f16039N;
    /* renamed from: b */
    private int f16040b;
    /* renamed from: c */
    private long f16041c;
    /* renamed from: d */
    private long f16042d;
    /* renamed from: e */
    private long f16043e;
    /* renamed from: f */
    private long f16044f;
    /* renamed from: g */
    private int f16045g;
    /* renamed from: h */
    private boolean f16046h;
    /* renamed from: i */
    private boolean f16047i;
    /* renamed from: j */
    private long f16048j;
    /* renamed from: k */
    private long f16049k;
    /* renamed from: l */
    private long f16050l;
    /* renamed from: m */
    private long f16051m;
    /* renamed from: n */
    private long f16052n;
    /* renamed from: o */
    private boolean f16053o;
    /* renamed from: p */
    private long f16054p;
    /* renamed from: q */
    private long f16055q;
    /* renamed from: r */
    private MediaCodec f16056r;
    /* renamed from: s */
    private C17779c f16057s;
    /* renamed from: t */
    private Runnable f16058t;
    /* renamed from: u */
    private Runnable f16059u;
    /* renamed from: v */
    private Runnable f16060v;
    /* renamed from: w */
    private ArrayDeque<Long> f16061w;
    /* renamed from: x */
    private Object f16062x;
    /* renamed from: y */
    private Surface f16063y;
    /* renamed from: z */
    private boolean f16064z;

    /* renamed from: com.tencent.liteav.videoencoder.a$2 */
    class C178122 implements Runnable {
        C178122() {
        }

        public void run() {
            AppMethodBeat.m2504i(67437);
            if (C37378a.this.mInit) {
                C37378a.m62967a(C37378a.this);
            }
            AppMethodBeat.m2505o(67437);
        }
    }

    /* renamed from: com.tencent.liteav.videoencoder.a$5 */
    class C373795 implements Runnable {
        C373795() {
        }

        public void run() {
            AppMethodBeat.m2504i(67363);
            if (C37378a.this.f16056r == null) {
                AppMethodBeat.m2505o(67363);
                return;
            }
            try {
                C37378a.this.f16056r.signalEndOfInputStream();
            } catch (Exception e) {
            }
            do {
            } while (C37378a.m62977c(C37378a.this, 10) >= 0);
            C37378a.m62967a(C37378a.this);
            AppMethodBeat.m2505o(67363);
        }
    }

    /* renamed from: com.tencent.liteav.videoencoder.a$6 */
    class C373806 implements Runnable {
        C373806() {
        }

        public void run() {
            AppMethodBeat.m2504i(67439);
            C37378a.m62967a(C37378a.this);
            AppMethodBeat.m2505o(67439);
        }
    }

    /* renamed from: com.tencent.liteav.videoencoder.a$7 */
    class C373817 implements Runnable {
        C373817() {
        }

        public void run() {
            AppMethodBeat.m2504i(67440);
            C37378a.m62982d(C37378a.this, 10);
            AppMethodBeat.m2505o(67440);
        }
    }

    /* renamed from: com.tencent.liteav.videoencoder.a$8 */
    class C373828 implements Runnable {
        C373828() {
        }

        public void run() {
            AppMethodBeat.m2504i(67364);
            C37378a.m62982d(C37378a.this, 1);
            AppMethodBeat.m2505o(67364);
        }
    }

    /* renamed from: b */
    static /* synthetic */ void m62976b(C37378a c37378a, int i) {
        AppMethodBeat.m2504i(67392);
        c37378a.m62979c(i);
        AppMethodBeat.m2505o(67392);
    }

    /* renamed from: c */
    static /* synthetic */ int m62977c(C37378a c37378a, int i) {
        AppMethodBeat.m2504i(67393);
        int a = c37378a.m62960a(i);
        AppMethodBeat.m2505o(67393);
        return a;
    }

    /* renamed from: d */
    static /* synthetic */ void m62982d(C37378a c37378a, int i) {
        AppMethodBeat.m2504i(67394);
        c37378a.m62975b(i);
        AppMethodBeat.m2505o(67394);
    }

    public C37378a() {
        AppMethodBeat.m2504i(67366);
        this.f16040b = 0;
        this.f16041c = 0;
        this.f16042d = 0;
        this.f16043e = 0;
        this.f16044f = 0;
        this.f16045g = 0;
        this.f16046h = false;
        this.f16047i = true;
        this.f16048j = 0;
        this.f16049k = 0;
        this.f16050l = 0;
        this.f16051m = 0;
        this.f16052n = 0;
        this.f16054p = 0;
        this.f16055q = 0;
        this.f16056r = null;
        this.f16057s = null;
        this.f16058t = new C373806();
        this.f16059u = new C373817();
        this.f16060v = new C373828();
        this.f16061w = new ArrayDeque(10);
        this.f16063y = null;
        this.f16064z = true;
        this.f16026A = true;
        this.f16027B = false;
        this.f16028C = null;
        this.f16029D = null;
        this.f16030E = 0;
        this.f16031F = 0;
        this.f16032G = 0;
        this.f16036K = 0;
        this.f16037L = 0;
        this.f16038M = 0;
        this.f16039N = -1;
        this.f16057s = new C17779c("HWVideoEncoder");
        AppMethodBeat.m2505o(67366);
    }

    public int start(final TXSVideoEncoderParam tXSVideoEncoderParam) {
        AppMethodBeat.m2504i(67367);
        super.start(tXSVideoEncoderParam);
        final boolean[] zArr = new boolean[1];
        if (VERSION.SDK_INT < 18) {
            zArr[0] = false;
        } else {
            synchronized (this) {
                try {
                    this.f16057s.mo32893a(new Runnable() {
                        public void run() {
                            AppMethodBeat.m2504i(67441);
                            if (C37378a.this.mInit) {
                                C37378a.m62967a(C37378a.this);
                            }
                            zArr[0] = C37378a.m62971a(C37378a.this, tXSVideoEncoderParam);
                            AppMethodBeat.m2505o(67441);
                        }
                    });
                } catch (Throwable th) {
                    AppMethodBeat.m2505o(67367);
                }
            }
        }
        if (!zArr[0]) {
            callDelegate(10000004);
        }
        if (zArr[0]) {
            AppMethodBeat.m2505o(67367);
            return 0;
        }
        AppMethodBeat.m2505o(67367);
        return 10000004;
    }

    public void stop() {
        AppMethodBeat.m2504i(67368);
        this.f16026A = true;
        synchronized (this) {
            try {
                this.f16057s.mo32893a(new C178122());
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(67368);
            }
        }
    }

    public void setFPS(final int i) {
        AppMethodBeat.m2504i(67369);
        this.f16057s.mo32894b(new Runnable() {
            public void run() {
                AppMethodBeat.m2504i(67396);
                C37378a.m62968a(C37378a.this, i);
                AppMethodBeat.m2505o(67396);
            }
        });
        AppMethodBeat.m2505o(67369);
    }

    public void setBitrate(final int i) {
        AppMethodBeat.m2504i(67370);
        this.f16040b = i;
        this.f16057s.mo32894b(new Runnable() {
            public void run() {
                AppMethodBeat.m2504i(67365);
                C37378a.m62976b(C37378a.this, i);
                AppMethodBeat.m2505o(67365);
            }
        });
        AppMethodBeat.m2505o(67370);
    }

    public long getRealFPS() {
        return this.f16042d;
    }

    public long getRealBitrate() {
        return this.f16041c;
    }

    public long pushVideoFrame(int i, int i2, int i3, long j) {
        AppMethodBeat.m2504i(67371);
        if (this.f16026A) {
            AppMethodBeat.m2505o(67371);
            return 10000004;
        }
        GLES20.glFinish();
        this.f16030E = j;
        this.f16039N = i;
        this.f16036K++;
        if (this.f16035J) {
            m62980d();
        }
        this.f16057s.mo32894b(this.f16059u);
        AppMethodBeat.m2505o(67371);
        return 0;
    }

    public long pushVideoFrameSync(int i, int i2, int i3, long j) {
        AppMethodBeat.m2504i(67372);
        if (this.f16026A) {
            AppMethodBeat.m2505o(67372);
            return 10000004;
        }
        GLES20.glFinish();
        this.f16030E = j;
        this.f16039N = i;
        this.f16036K++;
        if (this.f16035J) {
            m62980d();
        }
        this.f16057s.mo32893a(this.f16060v);
        AppMethodBeat.m2505o(67372);
        return 0;
    }

    public void signalEOSAndFlush() {
        AppMethodBeat.m2504i(67373);
        if (this.f16026A) {
            AppMethodBeat.m2505o(67373);
            return;
        }
        this.f16057s.mo32893a(new C373795());
        AppMethodBeat.m2505o(67373);
    }

    @TargetApi(16)
    /* renamed from: a */
    private MediaFormat m62964a(int i, int i2, int i3, int i4, int i5) {
        AppMethodBeat.m2504i(67374);
        if (i == 0 || i2 == 0 || i3 == 0 || i4 == 0) {
            AppMethodBeat.m2505o(67374);
            return null;
        }
        MediaFormat createVideoFormat = MediaFormat.createVideoFormat("video/avc", i, i2);
        createVideoFormat.setInteger(FFmpegMetadataRetriever.METADATA_KEY_VARIANT_BITRATE, i3 * WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
        createVideoFormat.setInteger("frame-rate", i4);
        createVideoFormat.setInteger("color-format", 2130708361);
        createVideoFormat.setInteger("i-frame-interval", i5);
        AppMethodBeat.m2505o(67374);
        return createVideoFormat;
    }

    @TargetApi(16)
    /* renamed from: a */
    private MediaFormat m62965a(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        AppMethodBeat.m2504i(67375);
        MediaFormat a = m62964a(i, i2, i3, i4, i5);
        if (a == null) {
            AppMethodBeat.m2505o(67375);
            return null;
        }
        if (VERSION.SDK_INT >= 21) {
            MediaCodecInfo a2 = C37378a.m62963a("video/avc");
            if (a2 == null) {
                AppMethodBeat.m2505o(67375);
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
        AppMethodBeat.m2505o(67375);
        return a;
    }

    @TargetApi(16)
    /* renamed from: a */
    private static MediaCodecInfo m62963a(String str) {
        AppMethodBeat.m2504i(67376);
        int codecCount = MediaCodecList.getCodecCount();
        for (int i = 0; i < codecCount; i++) {
            MediaCodecInfo codecInfoAt = MediaCodecList.getCodecInfoAt(i);
            if (codecInfoAt.isEncoder()) {
                for (String equalsIgnoreCase : codecInfoAt.getSupportedTypes()) {
                    if (equalsIgnoreCase.equalsIgnoreCase(str)) {
                        AppMethodBeat.m2505o(67376);
                        return codecInfoAt;
                    }
                }
                continue;
            }
        }
        AppMethodBeat.m2505o(67376);
        return null;
    }

    /* renamed from: a */
    private void m62966a(long j) {
        AppMethodBeat.m2504i(67377);
        this.f16061w.add(Long.valueOf(j));
        AppMethodBeat.m2505o(67377);
    }

    /* renamed from: a */
    private long m62962a() {
        AppMethodBeat.m2504i(67378);
        Long l = (Long) this.f16061w.poll();
        if (l == null) {
            AppMethodBeat.m2505o(67378);
            return 0;
        }
        long longValue = l.longValue();
        AppMethodBeat.m2505o(67378);
        return longValue;
    }

    /* renamed from: a */
    private boolean m62969a(Surface surface, int i, int i2) {
        AppMethodBeat.m2504i(67379);
        if (surface == null) {
            AppMethodBeat.m2505o(67379);
            return false;
        }
        if (this.f16027B) {
            EGLContext eGLContext = (EGLContext) this.mGLContextExternal;
            if (eGLContext == null) {
                eGLContext = EGL14.EGL_NO_CONTEXT;
            }
            this.f16062x = C32142c.m52286a(null, eGLContext, surface, i, i2);
        } else {
            javax.microedition.khronos.egl.EGLContext eGLContext2 = (javax.microedition.khronos.egl.EGLContext) this.mGLContextExternal;
            if (eGLContext2 == null) {
                eGLContext2 = EGL10.EGL_NO_CONTEXT;
            }
            this.f16062x = C32141b.m52280a(null, eGLContext2, surface, i, i2);
        }
        if (this.f16062x == null) {
            AppMethodBeat.m2505o(67379);
            return false;
        }
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        this.mEncodeFilter = new C8796g();
        this.mEncodeFilter.mo19875a(C45103k.f17758e, C45103k.m82749a(C37353j.NORMAL, false, false));
        if (this.mEncodeFilter.mo19876a()) {
            GLES20.glViewport(0, 0, i, i2);
            AppMethodBeat.m2505o(67379);
            return true;
        }
        this.mEncodeFilter = null;
        AppMethodBeat.m2505o(67379);
        return false;
    }

    /* renamed from: b */
    private void m62974b() {
        AppMethodBeat.m2504i(67380);
        if (this.mEncodeFilter != null) {
            this.mEncodeFilter.mo19883d();
            this.mEncodeFilter = null;
        }
        if (this.f16062x instanceof C32141b) {
            ((C32141b) this.f16062x).mo52723b();
            this.f16062x = null;
        }
        if (this.f16062x instanceof C32142c) {
            ((C32142c) this.f16062x).mo52728b();
            this.f16062x = null;
        }
        AppMethodBeat.m2505o(67380);
    }

    /* JADX WARNING: Removed duplicated region for block: B:55:0x0131 A:{SYNTHETIC, Splitter:B:55:0x0131} */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0141 A:{Catch:{ Exception -> 0x014a }} */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00f6  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x0131 A:{SYNTHETIC, Splitter:B:55:0x0131} */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0141 A:{Catch:{ Exception -> 0x014a }} */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00f6  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    @TargetApi(18)
    /* renamed from: a */
    private boolean m62970a(TXSVideoEncoderParam tXSVideoEncoderParam) {
        int i;
        AppMethodBeat.m2504i(67381);
        this.f16026A = false;
        this.f16064z = false;
        this.f16041c = 0;
        this.f16042d = 0;
        this.f16043e = 0;
        this.f16044f = 0;
        this.f16045g = 0;
        this.f16048j = 0;
        this.f16049k = 0;
        this.f16050l = 0;
        this.f16051m = 0;
        this.f16052n = 0;
        this.f16054p = 0;
        this.f16055q = 0;
        this.f16028C = null;
        this.f16029D = null;
        this.f16030E = 0;
        this.f16033H = -1;
        this.mOutputWidth = tXSVideoEncoderParam.width;
        this.mOutputHeight = tXSVideoEncoderParam.height;
        this.f16034I = tXSVideoEncoderParam.gop;
        this.f16035J = tXSVideoEncoderParam.fullIFrame;
        this.f16053o = tXSVideoEncoderParam.syncOutput;
        this.f16027B = tXSVideoEncoderParam.enableEGL14;
        this.f16061w.clear();
        if (tXSVideoEncoderParam == null || tXSVideoEncoderParam.width == 0 || tXSVideoEncoderParam.height == 0 || tXSVideoEncoderParam.fps == 0 || tXSVideoEncoderParam.gop == 0) {
            this.f16064z = true;
            AppMethodBeat.m2505o(67381);
            return false;
        }
        this.f16046h = tXSVideoEncoderParam.annexb;
        this.f16047i = tXSVideoEncoderParam.appendSpsPps;
        if (this.f16040b == 0) {
            this.f16040b = (int) (Math.sqrt((((double) (tXSVideoEncoderParam.width * tXSVideoEncoderParam.width)) * 1.0d) + ((double) (tXSVideoEncoderParam.height * tXSVideoEncoderParam.height))) * 1.2d);
        }
        this.f16048j = (long) this.f16040b;
        this.f16045g = tXSVideoEncoderParam.fps;
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
        if (C45104b.m82752a().mo72880c() == 1) {
            tXSVideoEncoderParam.encoderProfile = 1;
        }
        try {
            MediaFormat a = m62965a(tXSVideoEncoderParam.width, tXSVideoEncoderParam.height, this.f16040b, tXSVideoEncoderParam.fps, tXSVideoEncoderParam.gop, i2, 1);
            if (a == null) {
                this.f16064z = true;
                AppMethodBeat.m2505o(67381);
                return false;
            }
            this.f16056r = MediaCodec.createEncoderByType("video/avc");
            try {
                this.f16056r.configure(a, null, null, 1);
            } catch (Exception e) {
                if ((e instanceof IllegalArgumentException) || (VERSION.SDK_INT >= 21 && (e instanceof CodecException))) {
                    this.f16056r.configure(m62964a(tXSVideoEncoderParam.width, tXSVideoEncoderParam.height, this.f16040b, tXSVideoEncoderParam.fps, tXSVideoEncoderParam.gop), null, null, 1);
                } else {
                    AppMethodBeat.m2505o(67381);
                    throw e;
                }
            } catch (Exception e2) {
                i = 2;
                if (i >= 5) {
                    try {
                        if (this.f16056r != null) {
                            this.f16056r.stop();
                        }
                    } catch (Exception e3) {
                    }
                }
                this.f16056r = null;
                if (this.f16063y != null) {
                    this.f16063y.release();
                }
                this.f16063y = null;
                if (this.f16056r != null) {
                }
                this.f16064z = true;
                AppMethodBeat.m2505o(67381);
                return false;
            }
            i = 3;
            try {
                this.f16063y = this.f16056r.createInputSurface();
                this.f16056r.start();
                i = 5;
                this.f16028C = this.f16056r.getOutputBuffers();
            } catch (Exception e4) {
                if (i >= 5) {
                }
                this.f16056r = null;
                if (this.f16063y != null) {
                }
                this.f16063y = null;
                if (this.f16056r != null) {
                }
                this.f16064z = true;
                AppMethodBeat.m2505o(67381);
                return false;
            }
            if (this.f16056r != null || this.f16028C == null || this.f16063y == null) {
                this.f16064z = true;
                AppMethodBeat.m2505o(67381);
                return false;
            } else if (m62969a(this.f16063y, tXSVideoEncoderParam.width, tXSVideoEncoderParam.height)) {
                this.mInit = true;
                AppMethodBeat.m2505o(67381);
                return true;
            } else {
                this.f16064z = true;
                AppMethodBeat.m2505o(67381);
                return false;
            }
        } catch (Exception e5) {
            i = 1;
            if (i >= 5) {
            }
            this.f16056r = null;
            if (this.f16063y != null) {
            }
            this.f16063y = null;
            if (this.f16056r != null) {
            }
            this.f16064z = true;
            AppMethodBeat.m2505o(67381);
            return false;
        }
    }

    /* renamed from: a */
    private int m62960a(int i) {
        AppMethodBeat.m2504i(67382);
        if (this.f16056r == null) {
            AppMethodBeat.m2505o(67382);
            return -1;
        }
        BufferInfo bufferInfo = new BufferInfo();
        try {
            int dequeueOutputBuffer = this.f16056r.dequeueOutputBuffer(bufferInfo, (long) (i * 1000));
            if (dequeueOutputBuffer == -1) {
                AppMethodBeat.m2505o(67382);
                return 0;
            } else if (dequeueOutputBuffer == -3) {
                this.f16028C = this.f16056r.getOutputBuffers();
                AppMethodBeat.m2505o(67382);
                return 1;
            } else if (dequeueOutputBuffer == -2) {
                callDelegate(this.f16056r.getOutputFormat());
                AppMethodBeat.m2505o(67382);
                return 1;
            } else if (dequeueOutputBuffer < 0) {
                AppMethodBeat.m2505o(67382);
                return -1;
            } else {
                int i2;
                ByteBuffer byteBuffer = this.f16028C[dequeueOutputBuffer];
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
                            if (this.f16046h) {
                                this.f16029D = (byte[]) bArr2.clone();
                            } else {
                                this.f16029D = m62972a((byte[]) bArr2.clone());
                            }
                            i2 = 1;
                        } else {
                            byte[] bArr3;
                            if ((bufferInfo.flags & 1) == 1) {
                                i4 = 0;
                                this.f16033H = -1;
                                if (this.f16046h) {
                                    bArr3 = new byte[(this.f16029D.length + bArr2.length)];
                                    System.arraycopy(this.f16029D, 0, bArr3, 0, this.f16029D.length);
                                    System.arraycopy(bArr2, 0, bArr3, this.f16029D.length, bArr2.length);
                                } else {
                                    bArr2 = m62972a(bArr2);
                                    bArr3 = new byte[(this.f16029D.length + bArr2.length)];
                                    System.arraycopy(this.f16029D, 0, bArr3, 0, this.f16029D.length);
                                    System.arraycopy(bArr2, 0, bArr3, this.f16029D.length, bArr2.length);
                                }
                            } else if (this.f16046h) {
                                bArr3 = bArr2;
                            } else {
                                bArr3 = m62972a(bArr2);
                            }
                            if (!this.f16035J) {
                                i2 = this.f16033H + 1;
                                this.f16033H = i2;
                                if (i2 == this.f16045g * this.f16034I) {
                                    m62980d();
                                }
                            }
                            long a = m62962a();
                            long j = bufferInfo.presentationTimeUs / 1000;
                            if (this.f16032G == 0) {
                                this.f16032G = a;
                            }
                            if (this.f16031F == 0) {
                                this.f16031F = j;
                            }
                            long j2 = j + (this.f16032G - this.f16031F);
                            if (a <= this.f16052n) {
                                a = this.f16052n + 1;
                            }
                            if (a > j2) {
                                a = j2;
                            }
                            this.f16052n = a;
                            a = TXCTimeUtil.getTimeTick();
                            if (i4 == 0) {
                                if (a > this.f16043e + 1000) {
                                    this.f16041c = (long) (((((double) this.f16054p) * 8000.0d) / ((double) (a - this.f16043e))) / 1024.0d);
                                    this.f16054p = 0;
                                    this.f16043e = a;
                                }
                                this.f16049k++;
                                this.f16050l = 0;
                            } else {
                                this.f16050l++;
                            }
                            this.f16054p += (long) bArr3.length;
                            if (a > this.f16044f + FaceGestureDetGLThread.BRIGHTNESS_DURATION) {
                                this.f16042d = (long) ((((double) this.f16055q) * 1000.0d) / ((double) (a - this.f16044f)));
                                this.f16055q = 0;
                                this.f16044f = a;
                            }
                            this.f16055q++;
                            byteBuffer.position(bufferInfo.offset);
                            if (this.f16047i) {
                                callDelegate(bArr3, i4, this.f16049k, this.f16050l, this.f16051m, i4 == 0 ? 0 : this.f16050l - 1, j2, j2, 0, byteBuffer, bufferInfo);
                            } else {
                                callDelegate(obj, i4, this.f16049k, this.f16050l, this.f16051m, i4 == 0 ? 0 : this.f16050l - 1, j2, j2, 0, byteBuffer, bufferInfo);
                            }
                            this.f16051m++;
                            this.f16038M++;
                            if ((bufferInfo.flags & 4) != 0) {
                                if (this.mListener != null) {
                                    this.mListener.mo3950a(null, 0);
                                }
                                i2 = -2;
                            } else {
                                i2 = 1;
                            }
                        }
                    } else if ((bufferInfo.flags & 4) != 0) {
                        if (this.mListener != null) {
                            this.mListener.mo3950a(null, 0);
                        }
                        i2 = -2;
                    } else {
                        i2 = -1;
                    }
                }
                try {
                    if (this.f16056r != null) {
                        this.f16056r.releaseOutputBuffer(dequeueOutputBuffer, false);
                    }
                } catch (IllegalStateException e) {
                }
                AppMethodBeat.m2505o(67382);
                return i2;
            }
        } catch (IllegalStateException e2) {
            AppMethodBeat.m2505o(67382);
            return -1;
        }
    }

    /* renamed from: a */
    private byte[] m62972a(byte[] bArr) {
        int i;
        AppMethodBeat.m2504i(67383);
        int length = bArr.length;
        byte[] bArr2 = new byte[(length + 20)];
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i2 < length) {
            if (bArr[i2] == (byte) 0 && bArr[i2 + 1] == (byte) 0 && bArr[i2 + 2] == (byte) 1) {
                i4 = m62961a(i2, i3, bArr2, bArr, i4);
                i = i2 + 3;
                i2 = i;
                i3 = i;
            } else if (bArr[i2] == (byte) 0 && bArr[i2 + 1] == (byte) 0 && bArr[i2 + 2] == (byte) 0 && bArr[i2 + 3] == (byte) 1) {
                i4 = m62961a(i2, i3, bArr2, bArr, i4);
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
        i = m62961a(i2, i3, bArr2, bArr, i4);
        byte[] bArr3 = new byte[i];
        System.arraycopy(bArr2, 0, bArr3, 0, i);
        AppMethodBeat.m2505o(67383);
        return bArr3;
    }

    /* renamed from: a */
    private int m62961a(int i, int i2, byte[] bArr, byte[] bArr2, int i3) {
        AppMethodBeat.m2504i(67384);
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
                TXCLog.m15676e(f16025a, "setNalData exception");
            }
        }
        AppMethodBeat.m2505o(67384);
        return i3;
    }

    @TargetApi(18)
    /* renamed from: b */
    private void m62975b(int i) {
        AppMethodBeat.m2504i(67385);
        if (this.f16064z || this.f16062x == null) {
            AppMethodBeat.m2505o(67385);
            return;
        }
        int a;
        m62966a(this.f16030E);
        this.mEncodeFilter.mo19864a(this.f16039N);
        if (this.f16062x instanceof C32142c) {
            ((C32142c) this.f16062x).mo52727a(this.f16030E * 1000000);
            ((C32142c) this.f16062x).mo52729c();
        }
        if (this.f16062x instanceof C32141b) {
            ((C32141b) this.f16062x).mo52722a();
        }
        do {
            a = m62960a(i);
        } while (a > 0);
        if (a == -1 || a == -2) {
            if (a == -1) {
                callDelegate(10000005);
            }
            this.f16064z = true;
            m62978c();
            AppMethodBeat.m2505o(67385);
            return;
        }
        this.f16037L++;
        AppMethodBeat.m2505o(67385);
    }

    /* renamed from: c */
    private void m62978c() {
        AppMethodBeat.m2504i(67386);
        if (this.mInit) {
            this.f16064z = true;
            this.f16026A = true;
            m62974b();
            try {
                this.f16056r.stop();
                try {
                    this.f16056r.release();
                } catch (Exception e) {
                }
            } catch (IllegalStateException e2) {
                try {
                    this.f16056r.release();
                } catch (Exception e3) {
                }
            } catch (Throwable th) {
                try {
                    this.f16056r.release();
                } catch (Exception e4) {
                }
                AppMethodBeat.m2505o(67386);
            }
            this.f16056r = null;
            this.f16039N = -1;
            this.f16041c = 0;
            this.f16042d = 0;
            this.f16043e = 0;
            this.f16044f = 0;
            this.f16045g = 0;
            this.f16048j = 0;
            this.f16049k = 0;
            this.f16050l = 0;
            this.f16051m = 0;
            this.f16052n = 0;
            this.f16054p = 0;
            this.f16055q = 0;
            this.mGLContextExternal = null;
            this.f16028C = null;
            this.f16029D = null;
            this.f16030E = 0;
            this.mOutputWidth = 0;
            this.mOutputHeight = 0;
            this.mInit = false;
            this.mListener = null;
            this.f16061w.clear();
            AppMethodBeat.m2505o(67386);
            return;
        }
        AppMethodBeat.m2505o(67386);
    }

    /* renamed from: c */
    private void m62979c(int i) {
        AppMethodBeat.m2504i(67387);
        if (this.f16048j == ((long) this.f16040b)) {
            AppMethodBeat.m2505o(67387);
            return;
        }
        this.f16048j = (long) this.f16040b;
        if (VERSION.SDK_INT >= 19 && this.f16056r != null) {
            Bundle bundle = new Bundle();
            bundle.putInt("video-bitrate", this.f16040b * WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
            this.f16056r.setParameters(bundle);
        }
        AppMethodBeat.m2505o(67387);
    }

    /* renamed from: d */
    private void m62980d() {
        AppMethodBeat.m2504i(67388);
        if (VERSION.SDK_INT >= 19 && this.f16056r != null) {
            Bundle bundle = new Bundle();
            bundle.putInt("request-sync", 0);
            this.f16056r.setParameters(bundle);
        }
        AppMethodBeat.m2505o(67388);
    }

    /* renamed from: d */
    private void m62981d(int i) {
    }

    static {
        AppMethodBeat.m2504i(67395);
        AppMethodBeat.m2505o(67395);
    }
}
