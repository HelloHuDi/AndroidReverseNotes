package com.tencent.liteav.videodecoder;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.media.MediaFormat;
import android.os.Build.VERSION;
import android.view.Surface;
import com.tencent.liteav.basic.d.a;
import com.tencent.liteav.basic.g.b;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.rtmp.TXLiveConstants;
import com.tencent.ttpic.thread.FaceGestureDetGLThread;
import com.tencent.ttpic.util.VideoFilterUtil;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.ArrayList;

public class c implements a {
    private BufferInfo a = new BufferInfo();
    private MediaCodec b = null;
    private String c = "video/avc";
    private int d = 540;
    private int e = VideoFilterUtil.IMAGE_HEIGHT;
    private long f = 0;
    private long g = 0;
    private boolean h = true;
    private boolean i = false;
    private boolean j = false;
    private Surface k = null;
    private int l = 0;
    private ArrayList<b> m = new ArrayList();
    private d n;
    private WeakReference<a> o;

    public c() {
        AppMethodBeat.i(67783);
        AppMethodBeat.o(67783);
    }

    public void setListener(d dVar) {
        this.n = dVar;
    }

    public void setNotifyListener(WeakReference<a> weakReference) {
        this.o = weakReference;
    }

    public int config(Surface surface) {
        if (surface == null) {
            return -1;
        }
        this.k = surface;
        return 0;
    }

    public void decode(b bVar) {
        boolean z = true;
        AppMethodBeat.i(67784);
        if (bVar.i != 1) {
            z = false;
        }
        a(z);
        this.m.add(bVar);
        while (!this.m.isEmpty()) {
            int size = this.m.size();
            b();
            if (size == this.m.size()) {
                break;
            }
        }
        AppMethodBeat.o(67784);
    }

    public int start(ByteBuffer byteBuffer, ByteBuffer byteBuffer2, boolean z, boolean z2) {
        AppMethodBeat.i(67785);
        int a = a(byteBuffer, byteBuffer2, z2);
        AppMethodBeat.o(67785);
        return a;
    }

    public void stop() {
        AppMethodBeat.i(67786);
        a();
        AppMethodBeat.o(67786);
    }

    public boolean isHevc() {
        return this.j;
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x00ab A:{SYNTHETIC, Splitter:B:30:0x00ab} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int a(ByteBuffer byteBuffer, ByteBuffer byteBuffer2, boolean z) {
        Exception e;
        int i = 1;
        int i2 = -1;
        int i3 = 0;
        AppMethodBeat.i(67787);
        try {
            if (this.b != null || this.k == null) {
                TXCLog.e("MediaCodecDecoder", "decode: init decoder error, can not init for decoder=" + this.b + ",surface=" + this.k);
                AppMethodBeat.o(67787);
                return -1;
            }
            this.j = z;
            if (this.j) {
                this.c = "video/hevc";
            } else {
                this.c = "video/avc";
            }
            MediaFormat createVideoFormat = MediaFormat.createVideoFormat(this.c, this.d, this.e);
            if (byteBuffer != null) {
                createVideoFormat.setByteBuffer("csd-0", byteBuffer);
            }
            if (byteBuffer2 != null) {
                createVideoFormat.setByteBuffer("csd-1", byteBuffer2);
            }
            this.b = MediaCodec.createDecoderByType(this.c);
            try {
                this.b.configure(createVideoFormat, this.k, null, 0);
                this.b.setVideoScalingMode(1);
                this.b.start();
                i = 4;
                TXCLog.w("MediaCodecDecoder", "decode: start decoder success, is hevc: " + this.j);
            } catch (Exception e2) {
                e = e2;
                if (this.b != null) {
                }
                TXCLog.e("MediaCodecDecoder", "decode: init decoder " + i + " step exception: " + e.toString());
                f();
                i3 = i2;
                AppMethodBeat.o(67787);
                return i3;
            }
            try {
                this.l = 0;
            } catch (Exception e3) {
                e = e3;
                i2 = 0;
                if (this.b != null) {
                    try {
                        this.b.release();
                        TXCLog.w("MediaCodecDecoder", "decode: , decoder release success");
                        this.b = null;
                    } catch (Exception e4) {
                        TXCLog.e("MediaCodecDecoder", "decode: , decoder release exception: " + e.toString());
                        this.b = null;
                    } catch (Throwable th) {
                        this.b = null;
                        AppMethodBeat.o(67787);
                    }
                }
                TXCLog.e("MediaCodecDecoder", "decode: init decoder " + i + " step exception: " + e.toString());
                f();
                i3 = i2;
                AppMethodBeat.o(67787);
                return i3;
            }
            AppMethodBeat.o(67787);
            return i3;
        } catch (Exception e5) {
            e = e5;
            i = 0;
        }
    }

    private void a() {
        AppMethodBeat.i(67788);
        if (this.b != null) {
            try {
                this.b.stop();
                TXCLog.w("MediaCodecDecoder", "decode: stop decoder sucess");
                try {
                    this.b.release();
                    TXCLog.w("MediaCodecDecoder", "decode: release decoder sucess");
                    this.b = null;
                } catch (Exception e) {
                    TXCLog.e("MediaCodecDecoder", "decode: release decoder exception: " + e.toString());
                    this.b = null;
                } catch (Throwable th) {
                    this.b = null;
                    AppMethodBeat.o(67788);
                }
            } catch (Exception e2) {
                TXCLog.e("MediaCodecDecoder", "decode: stop decoder Exception: " + e2.toString());
                try {
                    this.b.release();
                    TXCLog.w("MediaCodecDecoder", "decode: release decoder sucess");
                    this.b = null;
                } catch (Exception e22) {
                    TXCLog.e("MediaCodecDecoder", "decode: release decoder exception: " + e22.toString());
                    this.b = null;
                } catch (Throwable th2) {
                    this.b = null;
                    AppMethodBeat.o(67788);
                }
            } catch (Throwable th3) {
                try {
                    this.b.release();
                    TXCLog.w("MediaCodecDecoder", "decode: release decoder sucess");
                    this.b = null;
                } catch (Exception e3) {
                    TXCLog.e("MediaCodecDecoder", "decode: release decoder exception: " + e3.toString());
                    this.b = null;
                } catch (Throwable th4) {
                    this.b = null;
                    AppMethodBeat.o(67788);
                }
                AppMethodBeat.o(67788);
            }
            this.m.clear();
            this.f = 0;
            this.h = true;
        }
        AppMethodBeat.o(67788);
    }

    @TargetApi(16)
    private void b() {
        AppMethodBeat.i(67789);
        if (this.b == null) {
            TXCLog.e("MediaCodecDecoder", "null decoder");
            AppMethodBeat.o(67789);
            return;
        }
        b bVar = (b) this.m.get(0);
        if (bVar == null || bVar.a.length == 0) {
            TXCLog.e("MediaCodecDecoder", "decode: empty buffer");
            this.m.remove(0);
            AppMethodBeat.o(67789);
            return;
        }
        ByteBuffer[] inputBuffers = this.b.getInputBuffers();
        if (inputBuffers == null || inputBuffers.length == 0) {
            TXCLog.e("MediaCodecDecoder", "decode: getInputBuffers failed");
            AppMethodBeat.o(67789);
            return;
        }
        int dequeueInputBuffer;
        int dequeueOutputBuffer;
        try {
            dequeueInputBuffer = this.b.dequeueInputBuffer(10000);
        } catch (Exception e) {
            TXCLog.e("MediaCodecDecoder", "decode: dequeueInputBuffer Exception!! ".concat(String.valueOf(e)));
            dequeueInputBuffer = -10000;
        }
        if (dequeueInputBuffer >= 0) {
            inputBuffers[dequeueInputBuffer].put(bVar.a);
            this.b.queueInputBuffer(dequeueInputBuffer, 0, bVar.a.length, bVar.g, 0);
            this.m.remove(0);
            if (this.f == 0) {
                TXCLog.w("MediaCodecDecoder", "decode: input buffer available, dequeueInputBuffer index: ".concat(String.valueOf(dequeueInputBuffer)));
            }
        } else {
            TXCLog.w("MediaCodecDecoder", "decode: input buffer not available, dequeueInputBuffer failed");
        }
        try {
            dequeueOutputBuffer = this.b.dequeueOutputBuffer(this.a, 10000);
        } catch (Exception e2) {
            g();
            TXCLog.e("MediaCodecDecoder", "decode: dequeueOutputBuffer exception!!".concat(String.valueOf(e2)));
            dequeueOutputBuffer = -10000;
        }
        if (dequeueOutputBuffer >= 0) {
            a(dequeueOutputBuffer, this.a.presentationTimeUs, this.a.presentationTimeUs);
            this.l = 0;
            AppMethodBeat.o(67789);
        } else if (dequeueOutputBuffer == -1) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e3) {
            }
            TXCLog.d("MediaCodecDecoder", "decode: no output from decoder available when timeout");
            g();
            AppMethodBeat.o(67789);
        } else if (dequeueOutputBuffer == -3) {
            TXCLog.d("MediaCodecDecoder", "decode: output buffers changed");
            AppMethodBeat.o(67789);
        } else if (dequeueOutputBuffer == -2) {
            c();
            AppMethodBeat.o(67789);
        } else {
            TXCLog.e("MediaCodecDecoder", "decode: unexpected result from decoder.dequeueOutputBuffer: ".concat(String.valueOf(dequeueOutputBuffer)));
            AppMethodBeat.o(67789);
        }
    }

    private void a(int i, long j, long j2) {
        AppMethodBeat.i(67790);
        this.b.releaseOutputBuffer(i, true);
        if ((this.a.flags & 4) != 0) {
            TXCLog.d("MediaCodecDecoder", "output EOS");
        }
        try {
            if (this.n != null) {
                this.n.a(null, this.d, this.e, j, j2);
            }
        } catch (Exception e) {
        }
        d();
        AppMethodBeat.o(67790);
    }

    private void c() {
        AppMethodBeat.i(67791);
        MediaFormat outputFormat = this.b.getOutputFormat();
        TXCLog.d("MediaCodecDecoder", "decode output format changed: ".concat(String.valueOf(outputFormat)));
        int abs = Math.abs(outputFormat.getInteger("crop-right") - outputFormat.getInteger("crop-left")) + 1;
        int abs2 = Math.abs(outputFormat.getInteger("crop-bottom") - outputFormat.getInteger("crop-top")) + 1;
        int integer = outputFormat.getInteger("width");
        int integer2 = outputFormat.getInteger("height");
        abs = Math.min(abs, integer);
        integer2 = Math.min(abs2, integer2);
        if (abs == this.d && integer2 == this.e) {
            if (this.h) {
                this.h = false;
                if (this.n != null) {
                    this.n.a(this.d, this.e);
                }
            }
            AppMethodBeat.o(67791);
            return;
        }
        this.d = abs;
        this.e = integer2;
        try {
            if (this.n != null) {
                this.n.a(this.d, this.e);
            }
        } catch (Exception e) {
        }
        TXCLog.d("MediaCodecDecoder", "decode: video size change to w:" + abs + ",h:" + integer2);
        AppMethodBeat.o(67791);
    }

    private void d() {
        AppMethodBeat.i(67792);
        if (this.f == 0) {
            TXCLog.w("MediaCodecDecoder", "decode first frame sucess");
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (this.f > 0 && currentTimeMillis > this.f + 1000 && currentTimeMillis > this.g + FaceGestureDetGLThread.BRIGHTNESS_DURATION && this.g != 0) {
            TXCLog.e("MediaCodecDecoder", "frame interval[" + (currentTimeMillis - this.f) + "] > 1000");
            this.g = currentTimeMillis;
        }
        if (this.g == 0) {
            this.g = currentTimeMillis;
        }
        this.f = currentTimeMillis;
        AppMethodBeat.o(67792);
    }

    private boolean e() {
        AppMethodBeat.i(67793);
        int i;
        if (VERSION.SDK_INT >= 21) {
            for (MediaCodecInfo mediaCodecInfo : new MediaCodecList(1).getCodecInfos()) {
                for (String contains : mediaCodecInfo.getSupportedTypes()) {
                    if (contains.contains("video/hevc")) {
                        TXCLog.e("MediaCodecDecoder", "decode: video/hevc MediaCodecInfo: " + mediaCodecInfo.getName() + ",encoder:" + mediaCodecInfo.isEncoder());
                        AppMethodBeat.o(67793);
                        return true;
                    }
                }
            }
            AppMethodBeat.o(67793);
            return false;
        }
        if (VERSION.SDK_INT >= 16) {
            int codecCount = MediaCodecList.getCodecCount();
            for (i = 0; i < codecCount; i++) {
                MediaCodecInfo codecInfoAt = MediaCodecList.getCodecInfoAt(i);
                for (String contains2 : codecInfoAt.getSupportedTypes()) {
                    if (contains2.contains("video/hevc")) {
                        TXCLog.e("MediaCodecDecoder", "video/hevc MediaCodecInfo: " + codecInfoAt.getName() + ",encoder:" + codecInfoAt.isEncoder());
                        AppMethodBeat.o(67793);
                        return true;
                    }
                }
            }
        }
        AppMethodBeat.o(67793);
        return false;
    }

    private void f() {
        AppMethodBeat.i(67794);
        if (!this.i) {
            TXCLog.w("MediaCodecDecoder", "decode hw decode error, hevc: " + this.j);
            if (this.j) {
                com.tencent.liteav.basic.util.b.a(this.o, (int) TXLiveConstants.PLAY_ERR_HEVC_DECODE_FAIL, "h265解码失败");
            } else {
                com.tencent.liteav.basic.util.b.a(this.o, (int) TXLiveConstants.PLAY_WARNING_HW_ACCELERATION_FAIL, "硬解启动失败，采用软解");
            }
            this.i = true;
        }
        AppMethodBeat.o(67794);
    }

    private void g() {
        AppMethodBeat.i(67795);
        if (this.l >= 40) {
            f();
            this.l = 0;
            AppMethodBeat.o(67795);
            return;
        }
        this.l++;
        AppMethodBeat.o(67795);
    }

    private void a(boolean z) {
        AppMethodBeat.i(67796);
        if (this.j != z) {
            this.j = z;
            if (this.i) {
                AppMethodBeat.o(67796);
                return;
            } else if (!this.j || e()) {
                a();
                a(null, null, this.j);
            } else {
                a();
                f();
                AppMethodBeat.o(67796);
                return;
            }
        }
        AppMethodBeat.o(67796);
    }
}
