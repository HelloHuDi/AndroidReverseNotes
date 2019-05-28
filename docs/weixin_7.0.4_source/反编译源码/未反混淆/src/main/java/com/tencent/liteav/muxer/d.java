package com.tencent.liteav.muxer;

import android.annotation.TargetApi;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import android.text.TextUtils;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.muxer.jni.TXSWMuxerJNI;
import com.tencent.liteav.muxer.jni.TXSWMuxerJNI.AVOptions;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.concurrent.ConcurrentLinkedQueue;

@TargetApi(18)
public class d implements a {
    public static float a = 0.5f;
    public static float b = 0.8f;
    public static float c = 1.25f;
    public static float d = 2.0f;
    private int e = 2;
    private TXSWMuxerJNI f;
    private String g = null;
    private MediaFormat h = null;
    private MediaFormat i = null;
    private int j = 0;
    private int k = 0;
    private boolean l = false;
    private boolean m = false;
    private ConcurrentLinkedQueue<a> n = new ConcurrentLinkedQueue();
    private ConcurrentLinkedQueue<a> o = new ConcurrentLinkedQueue();
    private long p = -1;
    private long q = -1;
    private long r = -1;

    static class a {
        ByteBuffer a;
        BufferInfo b;

        public a(ByteBuffer byteBuffer, BufferInfo bufferInfo) {
            this.a = byteBuffer;
            this.b = bufferInfo;
        }

        public ByteBuffer a() {
            return this.a;
        }

        public BufferInfo b() {
            return this.b;
        }
    }

    public d() {
        AppMethodBeat.i(67121);
        AppMethodBeat.o(67121);
    }

    public synchronized void a(MediaFormat mediaFormat) {
        AppMethodBeat.i(67122);
        TXCLog.d("TXCMP4SWMuxer", "addVideoTrack:".concat(String.valueOf(mediaFormat)));
        this.h = mediaFormat;
        this.n.clear();
        AppMethodBeat.o(67122);
    }

    public synchronized void b(MediaFormat mediaFormat) {
        AppMethodBeat.i(67123);
        TXCLog.d("TXCMP4SWMuxer", "addAudioTrack:".concat(String.valueOf(mediaFormat)));
        this.i = mediaFormat;
        this.o.clear();
        AppMethodBeat.o(67123);
    }

    public synchronized boolean c() {
        boolean z;
        if (this.h != null) {
            z = true;
        } else {
            z = false;
        }
        return z;
    }

    private ByteBuffer d() {
        AppMethodBeat.i(67124);
        ByteBuffer byteBuffer = this.i.getByteBuffer("csd-0");
        byteBuffer.position(0);
        AppMethodBeat.o(67124);
        return byteBuffer;
    }

    private ByteBuffer e() {
        AppMethodBeat.i(67125);
        ByteBuffer byteBuffer = this.h.getByteBuffer("csd-0");
        AppMethodBeat.o(67125);
        return byteBuffer;
    }

    private ByteBuffer f() {
        AppMethodBeat.i(67126);
        ByteBuffer byteBuffer = this.h.getByteBuffer("csd-1");
        AppMethodBeat.o(67126);
        return byteBuffer;
    }

    public synchronized int a() {
        int i = 0;
        synchronized (this) {
            AppMethodBeat.i(67127);
            if (this.g == null || this.g.isEmpty()) {
                TXCLog.e("TXCMP4SWMuxer", "target path not set yet!");
                i = -1;
                AppMethodBeat.o(67127);
            } else if (!c()) {
                TXCLog.e("TXCMP4SWMuxer", "video track not set yet!");
                i = -2;
                AppMethodBeat.o(67127);
            } else if (this.f != null) {
                TXCLog.w("TXCMP4SWMuxer", "start has been called. stop must be called before start");
                AppMethodBeat.o(67127);
            } else {
                int integer;
                TXCLog.d("TXCMP4SWMuxer", "start");
                this.f = new TXSWMuxerJNI();
                AVOptions aVOptions = new AVOptions();
                if (this.h != null) {
                    integer = this.h.getInteger("width");
                    aVOptions.videoHeight = this.h.getInteger("height");
                    aVOptions.videoWidth = integer;
                    aVOptions.videoGOP = this.h.containsKey("i-frame-interval") ? this.h.getInteger("i-frame-interval") : 3;
                }
                if (this.i != null) {
                    integer = this.i.getInteger("channel-count");
                    int integer2 = this.i.getInteger("sample-rate");
                    aVOptions.audioChannels = integer;
                    aVOptions.audioSampleRate = integer2;
                }
                ByteBuffer e = e();
                ByteBuffer f = f();
                ByteBuffer byteBuffer = null;
                if (this.i != null) {
                    byteBuffer = d();
                }
                if (e == null || f == null) {
                    TXCLog.e("TXCMP4SWMuxer", "video format contains error csd!");
                    AppMethodBeat.o(67127);
                    i = -3;
                } else if (this.i == null || byteBuffer != null) {
                    this.f.a(e, e.capacity(), f, f.capacity());
                    if (this.i != null) {
                        this.f.a(byteBuffer, byteBuffer.capacity());
                    }
                    this.f.a(aVOptions);
                    this.f.a(this.g);
                    this.f.a();
                    this.p = -1;
                    this.l = true;
                    this.m = false;
                    this.q = -1;
                    this.r = -1;
                    AppMethodBeat.o(67127);
                } else {
                    TXCLog.e("TXCMP4SWMuxer", "audio format contains error csd!");
                    AppMethodBeat.o(67127);
                    i = -3;
                }
            }
        }
        return i;
    }

    public synchronized int b() {
        int i = 0;
        synchronized (this) {
            AppMethodBeat.i(67128);
            if (this.f != null) {
                h();
                TXCLog.d("TXCMP4SWMuxer", "stop. start flag = " + this.l + ", video key frame set = " + this.m);
                try {
                    if (this.l && this.m) {
                        this.f.b();
                    }
                    this.f.c();
                    this.f = null;
                    this.l = false;
                    this.f = null;
                    this.m = false;
                    this.n.clear();
                    this.o.clear();
                    this.h = null;
                    this.i = null;
                    this.q = -1;
                    this.r = -1;
                } catch (Exception e) {
                    TXCLog.e("TXCMP4SWMuxer", "muxer stop/release exception: ".concat(String.valueOf(e)));
                    this.l = false;
                    this.f = null;
                    this.m = false;
                    this.n.clear();
                    this.o.clear();
                    this.h = null;
                    this.i = null;
                    this.q = -1;
                    this.r = -1;
                    i = -1;
                    AppMethodBeat.o(67128);
                } catch (Throwable th) {
                    this.l = false;
                    this.f = null;
                    this.m = false;
                    this.n.clear();
                    this.o.clear();
                    this.h = null;
                    this.i = null;
                    this.q = -1;
                    this.r = -1;
                    AppMethodBeat.o(67128);
                }
            }
            AppMethodBeat.o(67128);
        }
        return i;
    }

    public synchronized void a(String str) {
        AppMethodBeat.i(67129);
        this.g = str;
        if (!TextUtils.isEmpty(this.g)) {
            File file = new File(this.g);
            if (file.exists()) {
                file.delete();
            }
            try {
                file.createNewFile();
                AppMethodBeat.o(67129);
            } catch (IOException e) {
            }
        }
        AppMethodBeat.o(67129);
    }

    public synchronized void b(byte[] bArr, int i, int i2, long j, int i3) {
        AppMethodBeat.i(67130);
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(i2);
        allocateDirect.put(bArr, i, i2);
        BufferInfo bufferInfo = new BufferInfo();
        bufferInfo.presentationTimeUs = j;
        bufferInfo.offset = 0;
        bufferInfo.size = i2;
        bufferInfo.flags = i3;
        a(allocateDirect, bufferInfo);
        AppMethodBeat.o(67130);
    }

    public synchronized void a(byte[] bArr, int i, int i2, long j, int i3) {
        AppMethodBeat.i(67131);
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(i2);
        allocateDirect.put(bArr, i, i2);
        BufferInfo bufferInfo = new BufferInfo();
        bufferInfo.presentationTimeUs = j;
        bufferInfo.offset = 0;
        bufferInfo.size = i2;
        bufferInfo.flags = i3;
        b(allocateDirect, bufferInfo);
        AppMethodBeat.o(67131);
    }

    public synchronized void a(ByteBuffer byteBuffer, BufferInfo bufferInfo) {
        AppMethodBeat.i(67132);
        if (this.f == null) {
            a(true, byteBuffer, bufferInfo);
            TXCLog.w("TXCMP4SWMuxer", "cache frame before muexer ready. ptsUs: " + bufferInfo.presentationTimeUs);
            AppMethodBeat.o(67132);
        } else if (this.p < 0) {
            a(true, byteBuffer, bufferInfo);
            this.p = g();
            TXCLog.d("TXCMP4SWMuxer", "first frame offset = " + this.p);
            i();
            AppMethodBeat.o(67132);
        } else {
            a(bufferInfo.presentationTimeUs);
            c(byteBuffer, bufferInfo);
            AppMethodBeat.o(67132);
        }
    }

    public synchronized void b(ByteBuffer byteBuffer, BufferInfo bufferInfo) {
        AppMethodBeat.i(67133);
        a(false, byteBuffer, bufferInfo);
        AppMethodBeat.o(67133);
    }

    private void c(ByteBuffer byteBuffer, BufferInfo bufferInfo) {
        long j = 0;
        int i = 1;
        AppMethodBeat.i(67134);
        long j2 = bufferInfo.presentationTimeUs - this.p;
        if (j2 < 0) {
            TXCLog.e("TXCMP4SWMuxer", "pts error! first frame offset timeus = " + this.p + ", current timeus = " + bufferInfo.presentationTimeUs);
            if (this.q > 0) {
                j = this.q;
            }
        } else {
            j = j2;
        }
        if (j < this.q) {
            TXCLog.w("TXCMP4SWMuxer", "video is not in chronological order. current frame's pts(" + j + ") smaller than pre frame's pts(" + this.q + ")");
        } else {
            this.q = j;
        }
        if (this.e != 2) {
            if (this.e == 3) {
                j = (long) (((float) j) * b);
            } else if (this.e == 4) {
                j = (long) (((float) j) * a);
            } else if (this.e == 1) {
                j = (long) (((float) j) * c);
            } else if (this.e == 0) {
                j = (long) (((float) j) * d);
            }
        }
        bufferInfo.presentationTimeUs = j;
        try {
            byteBuffer.position(bufferInfo.offset);
            byteBuffer.limit(bufferInfo.offset + bufferInfo.size);
            TXSWMuxerJNI tXSWMuxerJNI = this.f;
            int i2 = bufferInfo.offset;
            int i3 = bufferInfo.size;
            if (bufferInfo.flags != 1) {
                i = 0;
            }
            tXSWMuxerJNI.a(byteBuffer, 1, i2, i3, i, bufferInfo.presentationTimeUs);
            if ((bufferInfo.flags & 1) != 0) {
                this.m = true;
            }
            AppMethodBeat.o(67134);
        } catch (IllegalStateException e) {
            TXCLog.e("TXCMP4SWMuxer", "write frame IllegalStateException: ".concat(String.valueOf(e)));
            AppMethodBeat.o(67134);
        } catch (IllegalArgumentException e2) {
            TXCLog.e("TXCMP4SWMuxer", "write frame IllegalArgumentException: ".concat(String.valueOf(e2)));
            AppMethodBeat.o(67134);
        }
    }

    private void d(ByteBuffer byteBuffer, BufferInfo bufferInfo) {
        AppMethodBeat.i(67135);
        long j = bufferInfo.presentationTimeUs - this.p;
        if (this.p < 0 || j < 0) {
            TXCLog.w("TXCMP4SWMuxer", "drop sample. first frame offset timeus = " + this.p + ", current sample timeus = " + bufferInfo.presentationTimeUs);
            AppMethodBeat.o(67135);
            return;
        }
        if (j < this.r) {
            TXCLog.e("TXCMP4SWMuxer", "audio is not in chronological order. current audio's pts pts(" + j + ") must larger than pre audio's pts(" + this.r + ")");
            j = this.r + 1;
        } else {
            this.r = j;
        }
        if (this.e != 2) {
            if (this.e == 3) {
                j = (long) (((float) j) * b);
            } else if (this.e == 4) {
                j = (long) (((float) j) * a);
            } else if (this.e == 1) {
                j = (long) (((float) j) * c);
            } else if (this.e == 0) {
                j = (long) (((float) j) * d);
            }
        }
        bufferInfo.presentationTimeUs = j;
        try {
            byteBuffer.position(bufferInfo.offset);
            byteBuffer.limit(bufferInfo.offset + bufferInfo.size);
            this.f.a(byteBuffer, 0, bufferInfo.offset, bufferInfo.size, bufferInfo.flags, bufferInfo.presentationTimeUs);
            AppMethodBeat.o(67135);
        } catch (IllegalStateException e) {
            TXCLog.e("TXCMP4SWMuxer", "write sample IllegalStateException: ".concat(String.valueOf(e)));
            AppMethodBeat.o(67135);
        } catch (IllegalArgumentException e2) {
            TXCLog.e("TXCMP4SWMuxer", "write sample IllegalArgumentException: ".concat(String.valueOf(e2)));
            AppMethodBeat.o(67135);
        }
    }

    private void a(boolean z, ByteBuffer byteBuffer, BufferInfo bufferInfo) {
        AppMethodBeat.i(67136);
        if (byteBuffer == null || bufferInfo == null) {
            AppMethodBeat.o(67136);
            return;
        }
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(byteBuffer.capacity());
        byteBuffer.rewind();
        if (bufferInfo.size > 0) {
            byteBuffer.position(bufferInfo.offset);
            byteBuffer.limit(bufferInfo.size);
        }
        allocateDirect.rewind();
        allocateDirect.put(byteBuffer);
        BufferInfo bufferInfo2 = new BufferInfo();
        bufferInfo2.set(bufferInfo.offset, bufferInfo.size, bufferInfo.presentationTimeUs, bufferInfo.flags);
        a aVar = new a(allocateDirect, bufferInfo2);
        if (!z) {
            this.o.add(aVar);
            AppMethodBeat.o(67136);
        } else if (this.n.size() < 200) {
            this.n.add(aVar);
            AppMethodBeat.o(67136);
        } else {
            TXCLog.e("TXCMP4SWMuxer", "drop video frame. video cache size is larger than 200");
            AppMethodBeat.o(67136);
        }
    }

    private long g() {
        long j;
        AppMethodBeat.i(67137);
        if (this.n.size() > 0) {
            j = ((a) this.n.peek()).b().presentationTimeUs;
        } else {
            j = 0;
        }
        if (this.o.size() > 0) {
            a aVar = (a) this.o.peek();
            if (!(aVar == null || aVar.b() == null)) {
                long j2 = ((a) this.o.peek()).b().presentationTimeUs;
                if (j > j2) {
                    j = j2;
                }
            }
        }
        AppMethodBeat.o(67137);
        return j;
    }

    private void h() {
        a aVar;
        AppMethodBeat.i(67138);
        while (this.n.size() > 0) {
            aVar = (a) this.n.poll();
            c(aVar.a(), aVar.b());
        }
        while (this.o.size() > 0) {
            aVar = (a) this.o.poll();
            d(aVar.a(), aVar.b());
        }
        AppMethodBeat.o(67138);
    }

    private void i() {
        AppMethodBeat.i(67139);
        while (this.n.size() > 0) {
            a aVar = (a) this.n.poll();
            a(aVar.b().presentationTimeUs);
            c(aVar.a(), aVar.b());
        }
        AppMethodBeat.o(67139);
    }

    private void a(long j) {
        AppMethodBeat.i(67140);
        while (this.o.size() > 0) {
            if (((a) this.o.peek()).b() != null) {
                if (((a) this.o.peek()).b().presentationTimeUs >= j) {
                    break;
                }
                a aVar = (a) this.o.poll();
                d(aVar.a(), aVar.b());
            } else {
                TXCLog.e("TXCMP4SWMuxer", "flushAudioCache, bufferInfo is null");
                this.o.remove();
            }
        }
        AppMethodBeat.o(67140);
    }
}
