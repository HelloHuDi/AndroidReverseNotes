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
/* renamed from: com.tencent.liteav.muxer.b */
public class C8816b implements C32170a {
    /* renamed from: a */
    public static float f2682a = 0.5f;
    /* renamed from: b */
    public static float f2683b = 0.8f;
    /* renamed from: c */
    public static float f2684c = 1.25f;
    /* renamed from: d */
    public static float f2685d = 2.0f;
    /* renamed from: e */
    private int f2686e = 2;
    /* renamed from: f */
    private MediaMuxer f2687f;
    /* renamed from: g */
    private String f2688g = null;
    /* renamed from: h */
    private MediaFormat f2689h = null;
    /* renamed from: i */
    private MediaFormat f2690i = null;
    /* renamed from: j */
    private int f2691j = 0;
    /* renamed from: k */
    private int f2692k = 0;
    /* renamed from: l */
    private boolean f2693l = false;
    /* renamed from: m */
    private boolean f2694m = false;
    /* renamed from: n */
    private ConcurrentLinkedQueue<C8817a> f2695n = new ConcurrentLinkedQueue();
    /* renamed from: o */
    private ConcurrentLinkedQueue<C8817a> f2696o = new ConcurrentLinkedQueue();
    /* renamed from: p */
    private long f2697p = -1;
    /* renamed from: q */
    private long f2698q = -1;
    /* renamed from: r */
    private long f2699r = -1;

    /* renamed from: com.tencent.liteav.muxer.b$a */
    static class C8817a {
        /* renamed from: a */
        ByteBuffer f2700a;
        /* renamed from: b */
        BufferInfo f2701b;

        public C8817a(ByteBuffer byteBuffer, BufferInfo bufferInfo) {
            this.f2700a = byteBuffer;
            this.f2701b = bufferInfo;
        }

        /* renamed from: a */
        public ByteBuffer mo19927a() {
            return this.f2700a;
        }

        /* renamed from: b */
        public BufferInfo mo19928b() {
            return this.f2701b;
        }
    }

    public C8816b() {
        AppMethodBeat.m2504i(67097);
        AppMethodBeat.m2505o(67097);
    }

    /* renamed from: a */
    public synchronized void mo19918a(MediaFormat mediaFormat) {
        AppMethodBeat.m2504i(67098);
        TXCLog.m15675d("TXCMP4HWMuxer", "addVideoTrack:".concat(String.valueOf(mediaFormat)));
        this.f2689h = mediaFormat;
        this.f2695n.clear();
        AppMethodBeat.m2505o(67098);
    }

    /* renamed from: b */
    public synchronized void mo19923b(MediaFormat mediaFormat) {
        AppMethodBeat.m2504i(67099);
        TXCLog.m15675d("TXCMP4HWMuxer", "addAudioTrack:".concat(String.valueOf(mediaFormat)));
        this.f2690i = mediaFormat;
        this.f2696o.clear();
        AppMethodBeat.m2505o(67099);
    }

    /* renamed from: c */
    public synchronized boolean mo19926c() {
        boolean z;
        if (this.f2689h != null) {
            z = true;
        } else {
            z = false;
        }
        return z;
    }

    /* renamed from: a */
    public synchronized int mo19917a() {
        int i = 0;
        synchronized (this) {
            AppMethodBeat.m2504i(67100);
            if (this.f2688g == null || this.f2688g.isEmpty()) {
                TXCLog.m15676e("TXCMP4HWMuxer", "target path not set yet!");
                i = -1;
                AppMethodBeat.m2505o(67100);
            } else if (!mo19926c()) {
                TXCLog.m15676e("TXCMP4HWMuxer", "video track not set yet!");
                i = -2;
                AppMethodBeat.m2505o(67100);
            } else if (this.f2687f != null) {
                TXCLog.m15679w("TXCMP4HWMuxer", "start has been called. stop must be called before start");
                AppMethodBeat.m2505o(67100);
            } else {
                TXCLog.m15675d("TXCMP4HWMuxer", "start");
                try {
                    this.f2687f = new MediaMuxer(this.f2688g, 0);
                    if (this.f2689h != null) {
                        try {
                            this.f2692k = this.f2687f.addTrack(this.f2689h);
                        } catch (IllegalArgumentException e) {
                            TXCLog.m15676e("TXCMP4HWMuxer", "addVideoTrack IllegalArgumentException: ".concat(String.valueOf(e)));
                            i = -5;
                            AppMethodBeat.m2505o(67100);
                        } catch (IllegalStateException e2) {
                            TXCLog.m15676e("TXCMP4HWMuxer", "addVideoTrack IllegalStateException: ".concat(String.valueOf(e2)));
                            i = -6;
                            AppMethodBeat.m2505o(67100);
                        }
                    }
                    if (this.f2690i != null) {
                        try {
                            this.f2691j = this.f2687f.addTrack(this.f2690i);
                        } catch (IllegalArgumentException e3) {
                            TXCLog.m15676e("TXCMP4HWMuxer", "addAudioTrack IllegalArgumentException: ".concat(String.valueOf(e3)));
                            i = -7;
                            AppMethodBeat.m2505o(67100);
                        } catch (IllegalStateException e22) {
                            TXCLog.m15676e("TXCMP4HWMuxer", "addAudioTrack IllegalStateException: ".concat(String.valueOf(e22)));
                            i = -8;
                            AppMethodBeat.m2505o(67100);
                        }
                    }
                    this.f2687f.start();
                    this.f2697p = -1;
                    this.f2693l = true;
                    this.f2694m = false;
                    this.f2698q = -1;
                    this.f2699r = -1;
                    AppMethodBeat.m2505o(67100);
                } catch (IOException e4) {
                    TXCLog.m15676e("TXCMP4HWMuxer", "create MediaMuxer exception:".concat(String.valueOf(e4)));
                    i = -4;
                    AppMethodBeat.m2505o(67100);
                }
            }
        }
        return i;
    }

    /* renamed from: b */
    public synchronized int mo19922b() {
        int i = 0;
        synchronized (this) {
            AppMethodBeat.m2504i(67101);
            if (this.f2687f != null) {
                TXCLog.m15675d("TXCMP4HWMuxer", "stop. start flag = " + this.f2693l + ", video key frame set = " + this.f2694m);
                try {
                    if (this.f2693l && this.f2694m) {
                        this.f2687f.stop();
                    }
                    this.f2687f.release();
                    this.f2693l = false;
                    this.f2687f = null;
                    this.f2694m = false;
                    this.f2695n.clear();
                    this.f2696o.clear();
                    this.f2689h = null;
                    this.f2690i = null;
                    this.f2698q = -1;
                    this.f2699r = -1;
                } catch (Exception e) {
                    TXCLog.m15676e("TXCMP4HWMuxer", "muxer stop/release exception: ".concat(String.valueOf(e)));
                    this.f2693l = false;
                    this.f2687f = null;
                    this.f2694m = false;
                    this.f2695n.clear();
                    this.f2696o.clear();
                    this.f2689h = null;
                    this.f2690i = null;
                    this.f2698q = -1;
                    this.f2699r = -1;
                    i = -1;
                    AppMethodBeat.m2505o(67101);
                } catch (Throwable th) {
                    this.f2693l = false;
                    this.f2687f = null;
                    this.f2694m = false;
                    this.f2695n.clear();
                    this.f2696o.clear();
                    this.f2689h = null;
                    this.f2690i = null;
                    this.f2698q = -1;
                    this.f2699r = -1;
                    AppMethodBeat.m2505o(67101);
                }
            }
            AppMethodBeat.m2505o(67101);
        }
        return i;
    }

    /* renamed from: a */
    public synchronized void mo19919a(String str) {
        this.f2688g = str;
    }

    /* renamed from: b */
    public synchronized void mo19925b(byte[] bArr, int i, int i2, long j, int i3) {
        AppMethodBeat.m2504i(67102);
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(i2);
        allocateDirect.put(bArr, i, i2);
        BufferInfo bufferInfo = new BufferInfo();
        bufferInfo.presentationTimeUs = j;
        bufferInfo.offset = 0;
        bufferInfo.size = i2;
        bufferInfo.flags = i3;
        mo19920a(allocateDirect, bufferInfo);
        AppMethodBeat.m2505o(67102);
    }

    /* renamed from: a */
    public synchronized void mo19921a(byte[] bArr, int i, int i2, long j, int i3) {
        AppMethodBeat.m2504i(67103);
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(i2);
        allocateDirect.put(bArr, i, i2);
        BufferInfo bufferInfo = new BufferInfo();
        bufferInfo.presentationTimeUs = j;
        bufferInfo.offset = 0;
        bufferInfo.size = i2;
        bufferInfo.flags = i3;
        mo19924b(allocateDirect, bufferInfo);
        AppMethodBeat.m2505o(67103);
    }

    /* renamed from: a */
    public synchronized void mo19920a(ByteBuffer byteBuffer, BufferInfo bufferInfo) {
        AppMethodBeat.m2504i(67104);
        if (this.f2687f == null) {
            m15694a(true, byteBuffer, bufferInfo);
            TXCLog.m15679w("TXCMP4HWMuxer", "cache frame before muexer ready. ptsUs: " + bufferInfo.presentationTimeUs);
            AppMethodBeat.m2505o(67104);
        } else if (this.f2697p < 0) {
            m15694a(true, byteBuffer, bufferInfo);
            this.f2697p = m15696d();
            TXCLog.m15675d("TXCMP4HWMuxer", "first frame offset = " + this.f2697p);
            m15698e();
            AppMethodBeat.m2505o(67104);
        } else {
            m15695c(byteBuffer, bufferInfo);
            AppMethodBeat.m2505o(67104);
        }
    }

    /* renamed from: b */
    public synchronized void mo19924b(ByteBuffer byteBuffer, BufferInfo bufferInfo) {
        AppMethodBeat.m2504i(67105);
        if (this.f2687f == null || this.f2697p < 0) {
            TXCLog.m15679w("TXCMP4HWMuxer", "cache sample before muexer ready. ptsUs: " + bufferInfo.presentationTimeUs);
            m15694a(false, byteBuffer, bufferInfo);
            AppMethodBeat.m2505o(67105);
        } else {
            m15697d(byteBuffer, bufferInfo);
            AppMethodBeat.m2505o(67105);
        }
    }

    /* renamed from: c */
    private void m15695c(ByteBuffer byteBuffer, BufferInfo bufferInfo) {
        long j = 0;
        AppMethodBeat.m2504i(67106);
        long j2 = bufferInfo.presentationTimeUs - this.f2697p;
        if (j2 < 0) {
            TXCLog.m15676e("TXCMP4HWMuxer", "pts error! first frame offset timeus = " + this.f2697p + ", current timeus = " + bufferInfo.presentationTimeUs);
            if (this.f2698q > 0) {
                j = this.f2698q;
            }
        } else {
            j = j2;
        }
        if (j < this.f2698q) {
            TXCLog.m15679w("TXCMP4HWMuxer", "video is not in chronological order. current frame's pts(" + j + ") smaller than pre frame's pts(" + this.f2698q + ")");
        } else {
            this.f2698q = j;
        }
        if (this.f2686e != 2) {
            if (this.f2686e == 3) {
                j = (long) (((float) j) * f2683b);
            } else if (this.f2686e == 4) {
                j = (long) (((float) j) * f2682a);
            } else if (this.f2686e == 1) {
                j = (long) (((float) j) * f2684c);
            } else if (this.f2686e == 0) {
                j = (long) (((float) j) * f2685d);
            }
        }
        bufferInfo.presentationTimeUs = j;
        try {
            byteBuffer.position(bufferInfo.offset);
            byteBuffer.limit(bufferInfo.offset + bufferInfo.size);
            this.f2687f.writeSampleData(this.f2692k, byteBuffer, bufferInfo);
            if ((bufferInfo.flags & 1) != 0) {
                this.f2694m = true;
            }
            AppMethodBeat.m2505o(67106);
        } catch (IllegalStateException e) {
            TXCLog.m15676e("TXCMP4HWMuxer", "write frame IllegalStateException: ".concat(String.valueOf(e)));
            AppMethodBeat.m2505o(67106);
        } catch (IllegalArgumentException e2) {
            TXCLog.m15676e("TXCMP4HWMuxer", "write frame IllegalArgumentException: ".concat(String.valueOf(e2)));
            AppMethodBeat.m2505o(67106);
        }
    }

    /* renamed from: d */
    private void m15697d(ByteBuffer byteBuffer, BufferInfo bufferInfo) {
        AppMethodBeat.m2504i(67107);
        long j = bufferInfo.presentationTimeUs - this.f2697p;
        if (this.f2697p < 0 || j < 0) {
            TXCLog.m15679w("TXCMP4HWMuxer", "drop sample. first frame offset timeus = " + this.f2697p + ", current sample timeus = " + bufferInfo.presentationTimeUs);
            AppMethodBeat.m2505o(67107);
            return;
        }
        if (j < this.f2699r) {
            TXCLog.m15676e("TXCMP4HWMuxer", "audio is not in chronological order. current audio's pts pts(" + j + ") must larger than pre audio's pts(" + this.f2699r + ")");
            j = this.f2699r + 1;
        } else {
            this.f2699r = j;
        }
        if (this.f2686e != 2) {
            if (this.f2686e == 3) {
                j = (long) (((float) j) * f2683b);
            } else if (this.f2686e == 4) {
                j = (long) (((float) j) * f2682a);
            } else if (this.f2686e == 1) {
                j = (long) (((float) j) * f2684c);
            } else if (this.f2686e == 0) {
                j = (long) (((float) j) * f2685d);
            }
        }
        bufferInfo.presentationTimeUs = j;
        try {
            this.f2687f.writeSampleData(this.f2691j, byteBuffer, bufferInfo);
            AppMethodBeat.m2505o(67107);
        } catch (IllegalStateException e) {
            TXCLog.m15676e("TXCMP4HWMuxer", "write sample IllegalStateException: ".concat(String.valueOf(e)));
            AppMethodBeat.m2505o(67107);
        } catch (IllegalArgumentException e2) {
            TXCLog.m15676e("TXCMP4HWMuxer", "write sample IllegalArgumentException: ".concat(String.valueOf(e2)));
            AppMethodBeat.m2505o(67107);
        }
    }

    /* renamed from: a */
    private void m15694a(boolean z, ByteBuffer byteBuffer, BufferInfo bufferInfo) {
        AppMethodBeat.m2504i(67108);
        if (byteBuffer == null || bufferInfo == null) {
            AppMethodBeat.m2505o(67108);
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
        C8817a c8817a = new C8817a(allocateDirect, bufferInfo2);
        if (z) {
            if (this.f2695n.size() < 200) {
                this.f2695n.add(c8817a);
                AppMethodBeat.m2505o(67108);
                return;
            }
            TXCLog.m15676e("TXCMP4HWMuxer", "drop video frame. video cache size is larger than 200");
            AppMethodBeat.m2505o(67108);
        } else if (this.f2696o.size() < 600) {
            this.f2696o.add(c8817a);
            AppMethodBeat.m2505o(67108);
        } else {
            TXCLog.m15676e("TXCMP4HWMuxer", "drop audio frame. audio cache size is larger than 600");
            AppMethodBeat.m2505o(67108);
        }
    }

    /* renamed from: d */
    private long m15696d() {
        long j;
        AppMethodBeat.m2504i(67109);
        if (this.f2695n.size() > 0) {
            j = ((C8817a) this.f2695n.peek()).mo19928b().presentationTimeUs;
        } else {
            j = 0;
        }
        if (this.f2696o.size() > 0) {
            C8817a c8817a = (C8817a) this.f2696o.peek();
            if (!(c8817a == null || c8817a.mo19928b() == null)) {
                long j2 = ((C8817a) this.f2696o.peek()).mo19928b().presentationTimeUs;
                if (j > j2) {
                    j = j2;
                }
            }
        }
        AppMethodBeat.m2505o(67109);
        return j;
    }

    /* renamed from: e */
    private void m15698e() {
        C8817a c8817a;
        AppMethodBeat.m2504i(67110);
        while (this.f2695n.size() > 0) {
            c8817a = (C8817a) this.f2695n.poll();
            m15695c(c8817a.mo19927a(), c8817a.mo19928b());
        }
        while (this.f2696o.size() > 0) {
            c8817a = (C8817a) this.f2696o.poll();
            m15697d(c8817a.mo19927a(), c8817a.mo19928b());
        }
        AppMethodBeat.m2505o(67110);
    }
}
