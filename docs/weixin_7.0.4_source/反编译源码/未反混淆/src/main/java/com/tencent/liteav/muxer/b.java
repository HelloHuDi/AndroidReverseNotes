package com.tencent.liteav.muxer;

import android.annotation.TargetApi;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.concurrent.ConcurrentLinkedQueue;

@TargetApi(18)
public class b implements a {
    public static float a = 0.5f;
    public static float b = 0.8f;
    public static float c = 1.25f;
    public static float d = 2.0f;
    private int e = 2;
    private MediaMuxer f;
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

    public b() {
        AppMethodBeat.i(67097);
        AppMethodBeat.o(67097);
    }

    public synchronized void a(MediaFormat mediaFormat) {
        AppMethodBeat.i(67098);
        TXCLog.d("TXCMP4HWMuxer", "addVideoTrack:".concat(String.valueOf(mediaFormat)));
        this.h = mediaFormat;
        this.n.clear();
        AppMethodBeat.o(67098);
    }

    public synchronized void b(MediaFormat mediaFormat) {
        AppMethodBeat.i(67099);
        TXCLog.d("TXCMP4HWMuxer", "addAudioTrack:".concat(String.valueOf(mediaFormat)));
        this.i = mediaFormat;
        this.o.clear();
        AppMethodBeat.o(67099);
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

    public synchronized int a() {
        int i = 0;
        synchronized (this) {
            AppMethodBeat.i(67100);
            if (this.g == null || this.g.isEmpty()) {
                TXCLog.e("TXCMP4HWMuxer", "target path not set yet!");
                i = -1;
                AppMethodBeat.o(67100);
            } else if (!c()) {
                TXCLog.e("TXCMP4HWMuxer", "video track not set yet!");
                i = -2;
                AppMethodBeat.o(67100);
            } else if (this.f != null) {
                TXCLog.w("TXCMP4HWMuxer", "start has been called. stop must be called before start");
                AppMethodBeat.o(67100);
            } else {
                TXCLog.d("TXCMP4HWMuxer", "start");
                try {
                    this.f = new MediaMuxer(this.g, 0);
                    if (this.h != null) {
                        try {
                            this.k = this.f.addTrack(this.h);
                        } catch (IllegalArgumentException e) {
                            TXCLog.e("TXCMP4HWMuxer", "addVideoTrack IllegalArgumentException: ".concat(String.valueOf(e)));
                            i = -5;
                            AppMethodBeat.o(67100);
                        } catch (IllegalStateException e2) {
                            TXCLog.e("TXCMP4HWMuxer", "addVideoTrack IllegalStateException: ".concat(String.valueOf(e2)));
                            i = -6;
                            AppMethodBeat.o(67100);
                        }
                    }
                    if (this.i != null) {
                        try {
                            this.j = this.f.addTrack(this.i);
                        } catch (IllegalArgumentException e3) {
                            TXCLog.e("TXCMP4HWMuxer", "addAudioTrack IllegalArgumentException: ".concat(String.valueOf(e3)));
                            i = -7;
                            AppMethodBeat.o(67100);
                        } catch (IllegalStateException e22) {
                            TXCLog.e("TXCMP4HWMuxer", "addAudioTrack IllegalStateException: ".concat(String.valueOf(e22)));
                            i = -8;
                            AppMethodBeat.o(67100);
                        }
                    }
                    this.f.start();
                    this.p = -1;
                    this.l = true;
                    this.m = false;
                    this.q = -1;
                    this.r = -1;
                    AppMethodBeat.o(67100);
                } catch (IOException e4) {
                    TXCLog.e("TXCMP4HWMuxer", "create MediaMuxer exception:".concat(String.valueOf(e4)));
                    i = -4;
                    AppMethodBeat.o(67100);
                }
            }
        }
        return i;
    }

    public synchronized int b() {
        int i = 0;
        synchronized (this) {
            AppMethodBeat.i(67101);
            if (this.f != null) {
                TXCLog.d("TXCMP4HWMuxer", "stop. start flag = " + this.l + ", video key frame set = " + this.m);
                try {
                    if (this.l && this.m) {
                        this.f.stop();
                    }
                    this.f.release();
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
                    TXCLog.e("TXCMP4HWMuxer", "muxer stop/release exception: ".concat(String.valueOf(e)));
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
                    AppMethodBeat.o(67101);
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
                    AppMethodBeat.o(67101);
                }
            }
            AppMethodBeat.o(67101);
        }
        return i;
    }

    public synchronized void a(String str) {
        this.g = str;
    }

    public synchronized void b(byte[] bArr, int i, int i2, long j, int i3) {
        AppMethodBeat.i(67102);
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(i2);
        allocateDirect.put(bArr, i, i2);
        BufferInfo bufferInfo = new BufferInfo();
        bufferInfo.presentationTimeUs = j;
        bufferInfo.offset = 0;
        bufferInfo.size = i2;
        bufferInfo.flags = i3;
        a(allocateDirect, bufferInfo);
        AppMethodBeat.o(67102);
    }

    public synchronized void a(byte[] bArr, int i, int i2, long j, int i3) {
        AppMethodBeat.i(67103);
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(i2);
        allocateDirect.put(bArr, i, i2);
        BufferInfo bufferInfo = new BufferInfo();
        bufferInfo.presentationTimeUs = j;
        bufferInfo.offset = 0;
        bufferInfo.size = i2;
        bufferInfo.flags = i3;
        b(allocateDirect, bufferInfo);
        AppMethodBeat.o(67103);
    }

    public synchronized void a(ByteBuffer byteBuffer, BufferInfo bufferInfo) {
        AppMethodBeat.i(67104);
        if (this.f == null) {
            a(true, byteBuffer, bufferInfo);
            TXCLog.w("TXCMP4HWMuxer", "cache frame before muexer ready. ptsUs: " + bufferInfo.presentationTimeUs);
            AppMethodBeat.o(67104);
        } else if (this.p < 0) {
            a(true, byteBuffer, bufferInfo);
            this.p = d();
            TXCLog.d("TXCMP4HWMuxer", "first frame offset = " + this.p);
            e();
            AppMethodBeat.o(67104);
        } else {
            c(byteBuffer, bufferInfo);
            AppMethodBeat.o(67104);
        }
    }

    public synchronized void b(ByteBuffer byteBuffer, BufferInfo bufferInfo) {
        AppMethodBeat.i(67105);
        if (this.f == null || this.p < 0) {
            TXCLog.w("TXCMP4HWMuxer", "cache sample before muexer ready. ptsUs: " + bufferInfo.presentationTimeUs);
            a(false, byteBuffer, bufferInfo);
            AppMethodBeat.o(67105);
        } else {
            d(byteBuffer, bufferInfo);
            AppMethodBeat.o(67105);
        }
    }

    private void c(ByteBuffer byteBuffer, BufferInfo bufferInfo) {
        long j = 0;
        AppMethodBeat.i(67106);
        long j2 = bufferInfo.presentationTimeUs - this.p;
        if (j2 < 0) {
            TXCLog.e("TXCMP4HWMuxer", "pts error! first frame offset timeus = " + this.p + ", current timeus = " + bufferInfo.presentationTimeUs);
            if (this.q > 0) {
                j = this.q;
            }
        } else {
            j = j2;
        }
        if (j < this.q) {
            TXCLog.w("TXCMP4HWMuxer", "video is not in chronological order. current frame's pts(" + j + ") smaller than pre frame's pts(" + this.q + ")");
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
            this.f.writeSampleData(this.k, byteBuffer, bufferInfo);
            if ((bufferInfo.flags & 1) != 0) {
                this.m = true;
            }
            AppMethodBeat.o(67106);
        } catch (IllegalStateException e) {
            TXCLog.e("TXCMP4HWMuxer", "write frame IllegalStateException: ".concat(String.valueOf(e)));
            AppMethodBeat.o(67106);
        } catch (IllegalArgumentException e2) {
            TXCLog.e("TXCMP4HWMuxer", "write frame IllegalArgumentException: ".concat(String.valueOf(e2)));
            AppMethodBeat.o(67106);
        }
    }

    private void d(ByteBuffer byteBuffer, BufferInfo bufferInfo) {
        AppMethodBeat.i(67107);
        long j = bufferInfo.presentationTimeUs - this.p;
        if (this.p < 0 || j < 0) {
            TXCLog.w("TXCMP4HWMuxer", "drop sample. first frame offset timeus = " + this.p + ", current sample timeus = " + bufferInfo.presentationTimeUs);
            AppMethodBeat.o(67107);
            return;
        }
        if (j < this.r) {
            TXCLog.e("TXCMP4HWMuxer", "audio is not in chronological order. current audio's pts pts(" + j + ") must larger than pre audio's pts(" + this.r + ")");
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
            this.f.writeSampleData(this.j, byteBuffer, bufferInfo);
            AppMethodBeat.o(67107);
        } catch (IllegalStateException e) {
            TXCLog.e("TXCMP4HWMuxer", "write sample IllegalStateException: ".concat(String.valueOf(e)));
            AppMethodBeat.o(67107);
        } catch (IllegalArgumentException e2) {
            TXCLog.e("TXCMP4HWMuxer", "write sample IllegalArgumentException: ".concat(String.valueOf(e2)));
            AppMethodBeat.o(67107);
        }
    }

    private void a(boolean z, ByteBuffer byteBuffer, BufferInfo bufferInfo) {
        AppMethodBeat.i(67108);
        if (byteBuffer == null || bufferInfo == null) {
            AppMethodBeat.o(67108);
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
        if (z) {
            if (this.n.size() < 200) {
                this.n.add(aVar);
                AppMethodBeat.o(67108);
                return;
            }
            TXCLog.e("TXCMP4HWMuxer", "drop video frame. video cache size is larger than 200");
            AppMethodBeat.o(67108);
        } else if (this.o.size() < 600) {
            this.o.add(aVar);
            AppMethodBeat.o(67108);
        } else {
            TXCLog.e("TXCMP4HWMuxer", "drop audio frame. audio cache size is larger than 600");
            AppMethodBeat.o(67108);
        }
    }

    private long d() {
        long j;
        AppMethodBeat.i(67109);
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
        AppMethodBeat.o(67109);
        return j;
    }

    private void e() {
        a aVar;
        AppMethodBeat.i(67110);
        while (this.n.size() > 0) {
            aVar = (a) this.n.poll();
            c(aVar.a(), aVar.b());
        }
        while (this.o.size() > 0) {
            aVar = (a) this.o.poll();
            d(aVar.a(), aVar.b());
        }
        AppMethodBeat.o(67110);
    }
}
