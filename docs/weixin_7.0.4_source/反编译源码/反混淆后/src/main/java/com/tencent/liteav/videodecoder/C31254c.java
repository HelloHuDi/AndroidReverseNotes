package com.tencent.liteav.videodecoder;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.media.MediaFormat;
import android.os.Build.VERSION;
import android.view.Surface;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.p140d.C0946a;
import com.tencent.liteav.basic.p811g.C25649b;
import com.tencent.liteav.basic.util.C17778b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.rtmp.TXLiveConstants;
import com.tencent.ttpic.thread.FaceGestureDetGLThread;
import com.tencent.ttpic.util.VideoFilterUtil;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.ArrayList;

/* renamed from: com.tencent.liteav.videodecoder.c */
public class C31254c implements C25680a {
    /* renamed from: a */
    private BufferInfo f14393a = new BufferInfo();
    /* renamed from: b */
    private MediaCodec f14394b = null;
    /* renamed from: c */
    private String f14395c = "video/avc";
    /* renamed from: d */
    private int f14396d = 540;
    /* renamed from: e */
    private int f14397e = VideoFilterUtil.IMAGE_HEIGHT;
    /* renamed from: f */
    private long f14398f = 0;
    /* renamed from: g */
    private long f14399g = 0;
    /* renamed from: h */
    private boolean f14400h = true;
    /* renamed from: i */
    private boolean f14401i = false;
    /* renamed from: j */
    private boolean f14402j = false;
    /* renamed from: k */
    private Surface f14403k = null;
    /* renamed from: l */
    private int f14404l = 0;
    /* renamed from: m */
    private ArrayList<C25649b> f14405m = new ArrayList();
    /* renamed from: n */
    private C37377d f14406n;
    /* renamed from: o */
    private WeakReference<C0946a> f14407o;

    public C31254c() {
        AppMethodBeat.m2504i(67783);
        AppMethodBeat.m2505o(67783);
    }

    public void setListener(C37377d c37377d) {
        this.f14406n = c37377d;
    }

    public void setNotifyListener(WeakReference<C0946a> weakReference) {
        this.f14407o = weakReference;
    }

    public int config(Surface surface) {
        if (surface == null) {
            return -1;
        }
        this.f14403k = surface;
        return 0;
    }

    public void decode(C25649b c25649b) {
        boolean z = true;
        AppMethodBeat.m2504i(67784);
        if (c25649b.f5259i != 1) {
            z = false;
        }
        m50427a(z);
        this.f14405m.add(c25649b);
        while (!this.f14405m.isEmpty()) {
            int size = this.f14405m.size();
            m50428b();
            if (size == this.f14405m.size()) {
                break;
            }
        }
        AppMethodBeat.m2505o(67784);
    }

    public int start(ByteBuffer byteBuffer, ByteBuffer byteBuffer2, boolean z, boolean z2) {
        AppMethodBeat.m2504i(67785);
        int a = m50424a(byteBuffer, byteBuffer2, z2);
        AppMethodBeat.m2505o(67785);
        return a;
    }

    public void stop() {
        AppMethodBeat.m2504i(67786);
        m50425a();
        AppMethodBeat.m2505o(67786);
    }

    public boolean isHevc() {
        return this.f14402j;
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x00ab A:{SYNTHETIC, Splitter:B:30:0x00ab} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    private int m50424a(ByteBuffer byteBuffer, ByteBuffer byteBuffer2, boolean z) {
        Exception e;
        int i = 1;
        int i2 = -1;
        int i3 = 0;
        AppMethodBeat.m2504i(67787);
        try {
            if (this.f14394b != null || this.f14403k == null) {
                TXCLog.m15676e("MediaCodecDecoder", "decode: init decoder error, can not init for decoder=" + this.f14394b + ",surface=" + this.f14403k);
                AppMethodBeat.m2505o(67787);
                return -1;
            }
            this.f14402j = z;
            if (this.f14402j) {
                this.f14395c = "video/hevc";
            } else {
                this.f14395c = "video/avc";
            }
            MediaFormat createVideoFormat = MediaFormat.createVideoFormat(this.f14395c, this.f14396d, this.f14397e);
            if (byteBuffer != null) {
                createVideoFormat.setByteBuffer("csd-0", byteBuffer);
            }
            if (byteBuffer2 != null) {
                createVideoFormat.setByteBuffer("csd-1", byteBuffer2);
            }
            this.f14394b = MediaCodec.createDecoderByType(this.f14395c);
            try {
                this.f14394b.configure(createVideoFormat, this.f14403k, null, 0);
                this.f14394b.setVideoScalingMode(1);
                this.f14394b.start();
                i = 4;
                TXCLog.m15679w("MediaCodecDecoder", "decode: start decoder success, is hevc: " + this.f14402j);
            } catch (Exception e2) {
                e = e2;
                if (this.f14394b != null) {
                }
                TXCLog.m15676e("MediaCodecDecoder", "decode: init decoder " + i + " step exception: " + e.toString());
                m50432f();
                i3 = i2;
                AppMethodBeat.m2505o(67787);
                return i3;
            }
            try {
                this.f14404l = 0;
            } catch (Exception e3) {
                e = e3;
                i2 = 0;
                if (this.f14394b != null) {
                    try {
                        this.f14394b.release();
                        TXCLog.m15679w("MediaCodecDecoder", "decode: , decoder release success");
                        this.f14394b = null;
                    } catch (Exception e4) {
                        TXCLog.m15676e("MediaCodecDecoder", "decode: , decoder release exception: " + e.toString());
                        this.f14394b = null;
                    } catch (Throwable th) {
                        this.f14394b = null;
                        AppMethodBeat.m2505o(67787);
                    }
                }
                TXCLog.m15676e("MediaCodecDecoder", "decode: init decoder " + i + " step exception: " + e.toString());
                m50432f();
                i3 = i2;
                AppMethodBeat.m2505o(67787);
                return i3;
            }
            AppMethodBeat.m2505o(67787);
            return i3;
        } catch (Exception e5) {
            e = e5;
            i = 0;
        }
    }

    /* renamed from: a */
    private void m50425a() {
        AppMethodBeat.m2504i(67788);
        if (this.f14394b != null) {
            try {
                this.f14394b.stop();
                TXCLog.m15679w("MediaCodecDecoder", "decode: stop decoder sucess");
                try {
                    this.f14394b.release();
                    TXCLog.m15679w("MediaCodecDecoder", "decode: release decoder sucess");
                    this.f14394b = null;
                } catch (Exception e) {
                    TXCLog.m15676e("MediaCodecDecoder", "decode: release decoder exception: " + e.toString());
                    this.f14394b = null;
                } catch (Throwable th) {
                    this.f14394b = null;
                    AppMethodBeat.m2505o(67788);
                }
            } catch (Exception e2) {
                TXCLog.m15676e("MediaCodecDecoder", "decode: stop decoder Exception: " + e2.toString());
                try {
                    this.f14394b.release();
                    TXCLog.m15679w("MediaCodecDecoder", "decode: release decoder sucess");
                    this.f14394b = null;
                } catch (Exception e22) {
                    TXCLog.m15676e("MediaCodecDecoder", "decode: release decoder exception: " + e22.toString());
                    this.f14394b = null;
                } catch (Throwable th2) {
                    this.f14394b = null;
                    AppMethodBeat.m2505o(67788);
                }
            } catch (Throwable th3) {
                try {
                    this.f14394b.release();
                    TXCLog.m15679w("MediaCodecDecoder", "decode: release decoder sucess");
                    this.f14394b = null;
                } catch (Exception e3) {
                    TXCLog.m15676e("MediaCodecDecoder", "decode: release decoder exception: " + e3.toString());
                    this.f14394b = null;
                } catch (Throwable th4) {
                    this.f14394b = null;
                    AppMethodBeat.m2505o(67788);
                }
                AppMethodBeat.m2505o(67788);
            }
            this.f14405m.clear();
            this.f14398f = 0;
            this.f14400h = true;
        }
        AppMethodBeat.m2505o(67788);
    }

    @TargetApi(16)
    /* renamed from: b */
    private void m50428b() {
        AppMethodBeat.m2504i(67789);
        if (this.f14394b == null) {
            TXCLog.m15676e("MediaCodecDecoder", "null decoder");
            AppMethodBeat.m2505o(67789);
            return;
        }
        C25649b c25649b = (C25649b) this.f14405m.get(0);
        if (c25649b == null || c25649b.f5251a.length == 0) {
            TXCLog.m15676e("MediaCodecDecoder", "decode: empty buffer");
            this.f14405m.remove(0);
            AppMethodBeat.m2505o(67789);
            return;
        }
        ByteBuffer[] inputBuffers = this.f14394b.getInputBuffers();
        if (inputBuffers == null || inputBuffers.length == 0) {
            TXCLog.m15676e("MediaCodecDecoder", "decode: getInputBuffers failed");
            AppMethodBeat.m2505o(67789);
            return;
        }
        int dequeueInputBuffer;
        int dequeueOutputBuffer;
        try {
            dequeueInputBuffer = this.f14394b.dequeueInputBuffer(10000);
        } catch (Exception e) {
            TXCLog.m15676e("MediaCodecDecoder", "decode: dequeueInputBuffer Exception!! ".concat(String.valueOf(e)));
            dequeueInputBuffer = -10000;
        }
        if (dequeueInputBuffer >= 0) {
            inputBuffers[dequeueInputBuffer].put(c25649b.f5251a);
            this.f14394b.queueInputBuffer(dequeueInputBuffer, 0, c25649b.f5251a.length, c25649b.f5257g, 0);
            this.f14405m.remove(0);
            if (this.f14398f == 0) {
                TXCLog.m15679w("MediaCodecDecoder", "decode: input buffer available, dequeueInputBuffer index: ".concat(String.valueOf(dequeueInputBuffer)));
            }
        } else {
            TXCLog.m15679w("MediaCodecDecoder", "decode: input buffer not available, dequeueInputBuffer failed");
        }
        try {
            dequeueOutputBuffer = this.f14394b.dequeueOutputBuffer(this.f14393a, 10000);
        } catch (Exception e2) {
            m50433g();
            TXCLog.m15676e("MediaCodecDecoder", "decode: dequeueOutputBuffer exception!!".concat(String.valueOf(e2)));
            dequeueOutputBuffer = -10000;
        }
        if (dequeueOutputBuffer >= 0) {
            m50426a(dequeueOutputBuffer, this.f14393a.presentationTimeUs, this.f14393a.presentationTimeUs);
            this.f14404l = 0;
            AppMethodBeat.m2505o(67789);
        } else if (dequeueOutputBuffer == -1) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e3) {
            }
            TXCLog.m15675d("MediaCodecDecoder", "decode: no output from decoder available when timeout");
            m50433g();
            AppMethodBeat.m2505o(67789);
        } else if (dequeueOutputBuffer == -3) {
            TXCLog.m15675d("MediaCodecDecoder", "decode: output buffers changed");
            AppMethodBeat.m2505o(67789);
        } else if (dequeueOutputBuffer == -2) {
            m50429c();
            AppMethodBeat.m2505o(67789);
        } else {
            TXCLog.m15676e("MediaCodecDecoder", "decode: unexpected result from decoder.dequeueOutputBuffer: ".concat(String.valueOf(dequeueOutputBuffer)));
            AppMethodBeat.m2505o(67789);
        }
    }

    /* renamed from: a */
    private void m50426a(int i, long j, long j2) {
        AppMethodBeat.m2504i(67790);
        this.f14394b.releaseOutputBuffer(i, true);
        if ((this.f14393a.flags & 4) != 0) {
            TXCLog.m15675d("MediaCodecDecoder", "output EOS");
        }
        try {
            if (this.f14406n != null) {
                this.f14406n.mo20008a(null, this.f14396d, this.f14397e, j, j2);
            }
        } catch (Exception e) {
        }
        m50430d();
        AppMethodBeat.m2505o(67790);
    }

    /* renamed from: c */
    private void m50429c() {
        AppMethodBeat.m2504i(67791);
        MediaFormat outputFormat = this.f14394b.getOutputFormat();
        TXCLog.m15675d("MediaCodecDecoder", "decode output format changed: ".concat(String.valueOf(outputFormat)));
        int abs = Math.abs(outputFormat.getInteger("crop-right") - outputFormat.getInteger("crop-left")) + 1;
        int abs2 = Math.abs(outputFormat.getInteger("crop-bottom") - outputFormat.getInteger("crop-top")) + 1;
        int integer = outputFormat.getInteger("width");
        int integer2 = outputFormat.getInteger("height");
        abs = Math.min(abs, integer);
        integer2 = Math.min(abs2, integer2);
        if (abs == this.f14396d && integer2 == this.f14397e) {
            if (this.f14400h) {
                this.f14400h = false;
                if (this.f14406n != null) {
                    this.f14406n.mo20005a(this.f14396d, this.f14397e);
                }
            }
            AppMethodBeat.m2505o(67791);
            return;
        }
        this.f14396d = abs;
        this.f14397e = integer2;
        try {
            if (this.f14406n != null) {
                this.f14406n.mo20005a(this.f14396d, this.f14397e);
            }
        } catch (Exception e) {
        }
        TXCLog.m15675d("MediaCodecDecoder", "decode: video size change to w:" + abs + ",h:" + integer2);
        AppMethodBeat.m2505o(67791);
    }

    /* renamed from: d */
    private void m50430d() {
        AppMethodBeat.m2504i(67792);
        if (this.f14398f == 0) {
            TXCLog.m15679w("MediaCodecDecoder", "decode first frame sucess");
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (this.f14398f > 0 && currentTimeMillis > this.f14398f + 1000 && currentTimeMillis > this.f14399g + FaceGestureDetGLThread.BRIGHTNESS_DURATION && this.f14399g != 0) {
            TXCLog.m15676e("MediaCodecDecoder", "frame interval[" + (currentTimeMillis - this.f14398f) + "] > 1000");
            this.f14399g = currentTimeMillis;
        }
        if (this.f14399g == 0) {
            this.f14399g = currentTimeMillis;
        }
        this.f14398f = currentTimeMillis;
        AppMethodBeat.m2505o(67792);
    }

    /* renamed from: e */
    private boolean m50431e() {
        AppMethodBeat.m2504i(67793);
        int i;
        if (VERSION.SDK_INT >= 21) {
            for (MediaCodecInfo mediaCodecInfo : new MediaCodecList(1).getCodecInfos()) {
                for (String contains : mediaCodecInfo.getSupportedTypes()) {
                    if (contains.contains("video/hevc")) {
                        TXCLog.m15676e("MediaCodecDecoder", "decode: video/hevc MediaCodecInfo: " + mediaCodecInfo.getName() + ",encoder:" + mediaCodecInfo.isEncoder());
                        AppMethodBeat.m2505o(67793);
                        return true;
                    }
                }
            }
            AppMethodBeat.m2505o(67793);
            return false;
        }
        if (VERSION.SDK_INT >= 16) {
            int codecCount = MediaCodecList.getCodecCount();
            for (i = 0; i < codecCount; i++) {
                MediaCodecInfo codecInfoAt = MediaCodecList.getCodecInfoAt(i);
                for (String contains2 : codecInfoAt.getSupportedTypes()) {
                    if (contains2.contains("video/hevc")) {
                        TXCLog.m15676e("MediaCodecDecoder", "video/hevc MediaCodecInfo: " + codecInfoAt.getName() + ",encoder:" + codecInfoAt.isEncoder());
                        AppMethodBeat.m2505o(67793);
                        return true;
                    }
                }
            }
        }
        AppMethodBeat.m2505o(67793);
        return false;
    }

    /* renamed from: f */
    private void m50432f() {
        AppMethodBeat.m2504i(67794);
        if (!this.f14401i) {
            TXCLog.m15679w("MediaCodecDecoder", "decode hw decode error, hevc: " + this.f14402j);
            if (this.f14402j) {
                C17778b.m27743a(this.f14407o, (int) TXLiveConstants.PLAY_ERR_HEVC_DECODE_FAIL, "h265解码失败");
            } else {
                C17778b.m27743a(this.f14407o, (int) TXLiveConstants.PLAY_WARNING_HW_ACCELERATION_FAIL, "硬解启动失败，采用软解");
            }
            this.f14401i = true;
        }
        AppMethodBeat.m2505o(67794);
    }

    /* renamed from: g */
    private void m50433g() {
        AppMethodBeat.m2504i(67795);
        if (this.f14404l >= 40) {
            m50432f();
            this.f14404l = 0;
            AppMethodBeat.m2505o(67795);
            return;
        }
        this.f14404l++;
        AppMethodBeat.m2505o(67795);
    }

    /* renamed from: a */
    private void m50427a(boolean z) {
        AppMethodBeat.m2504i(67796);
        if (this.f14402j != z) {
            this.f14402j = z;
            if (this.f14401i) {
                AppMethodBeat.m2505o(67796);
                return;
            } else if (!this.f14402j || m50431e()) {
                m50425a();
                m50424a(null, null, this.f14402j);
            } else {
                m50425a();
                m50432f();
                AppMethodBeat.m2505o(67796);
                return;
            }
        }
        AppMethodBeat.m2505o(67796);
    }
}
