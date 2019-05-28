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
/* renamed from: com.tencent.liteav.muxer.d */
public class C25660d implements C32170a {
    /* renamed from: a */
    public static float f5338a = 0.5f;
    /* renamed from: b */
    public static float f5339b = 0.8f;
    /* renamed from: c */
    public static float f5340c = 1.25f;
    /* renamed from: d */
    public static float f5341d = 2.0f;
    /* renamed from: e */
    private int f5342e = 2;
    /* renamed from: f */
    private TXSWMuxerJNI f5343f;
    /* renamed from: g */
    private String f5344g = null;
    /* renamed from: h */
    private MediaFormat f5345h = null;
    /* renamed from: i */
    private MediaFormat f5346i = null;
    /* renamed from: j */
    private int f5347j = 0;
    /* renamed from: k */
    private int f5348k = 0;
    /* renamed from: l */
    private boolean f5349l = false;
    /* renamed from: m */
    private boolean f5350m = false;
    /* renamed from: n */
    private ConcurrentLinkedQueue<C8819a> f5351n = new ConcurrentLinkedQueue();
    /* renamed from: o */
    private ConcurrentLinkedQueue<C8819a> f5352o = new ConcurrentLinkedQueue();
    /* renamed from: p */
    private long f5353p = -1;
    /* renamed from: q */
    private long f5354q = -1;
    /* renamed from: r */
    private long f5355r = -1;

    /* renamed from: com.tencent.liteav.muxer.d$a */
    static class C8819a {
        /* renamed from: a */
        ByteBuffer f2704a;
        /* renamed from: b */
        BufferInfo f2705b;

        public C8819a(ByteBuffer byteBuffer, BufferInfo bufferInfo) {
            this.f2704a = byteBuffer;
            this.f2705b = bufferInfo;
        }

        /* renamed from: a */
        public ByteBuffer mo19929a() {
            return this.f2704a;
        }

        /* renamed from: b */
        public BufferInfo mo19930b() {
            return this.f2705b;
        }
    }

    public C25660d() {
        AppMethodBeat.m2504i(67121);
        AppMethodBeat.m2505o(67121);
    }

    /* renamed from: a */
    public synchronized void mo19918a(MediaFormat mediaFormat) {
        AppMethodBeat.m2504i(67122);
        TXCLog.m15675d("TXCMP4SWMuxer", "addVideoTrack:".concat(String.valueOf(mediaFormat)));
        this.f5345h = mediaFormat;
        this.f5351n.clear();
        AppMethodBeat.m2505o(67122);
    }

    /* renamed from: b */
    public synchronized void mo19923b(MediaFormat mediaFormat) {
        AppMethodBeat.m2504i(67123);
        TXCLog.m15675d("TXCMP4SWMuxer", "addAudioTrack:".concat(String.valueOf(mediaFormat)));
        this.f5346i = mediaFormat;
        this.f5352o.clear();
        AppMethodBeat.m2505o(67123);
    }

    /* renamed from: c */
    public synchronized boolean mo19926c() {
        boolean z;
        if (this.f5345h != null) {
            z = true;
        } else {
            z = false;
        }
        return z;
    }

    /* renamed from: d */
    private ByteBuffer m40695d() {
        AppMethodBeat.m2504i(67124);
        ByteBuffer byteBuffer = this.f5346i.getByteBuffer("csd-0");
        byteBuffer.position(0);
        AppMethodBeat.m2505o(67124);
        return byteBuffer;
    }

    /* renamed from: e */
    private ByteBuffer m40697e() {
        AppMethodBeat.m2504i(67125);
        ByteBuffer byteBuffer = this.f5345h.getByteBuffer("csd-0");
        AppMethodBeat.m2505o(67125);
        return byteBuffer;
    }

    /* renamed from: f */
    private ByteBuffer m40698f() {
        AppMethodBeat.m2504i(67126);
        ByteBuffer byteBuffer = this.f5345h.getByteBuffer("csd-1");
        AppMethodBeat.m2505o(67126);
        return byteBuffer;
    }

    /* renamed from: a */
    public synchronized int mo19917a() {
        int i = 0;
        synchronized (this) {
            AppMethodBeat.m2504i(67127);
            if (this.f5344g == null || this.f5344g.isEmpty()) {
                TXCLog.m15676e("TXCMP4SWMuxer", "target path not set yet!");
                i = -1;
                AppMethodBeat.m2505o(67127);
            } else if (!mo19926c()) {
                TXCLog.m15676e("TXCMP4SWMuxer", "video track not set yet!");
                i = -2;
                AppMethodBeat.m2505o(67127);
            } else if (this.f5343f != null) {
                TXCLog.m15679w("TXCMP4SWMuxer", "start has been called. stop must be called before start");
                AppMethodBeat.m2505o(67127);
            } else {
                int integer;
                TXCLog.m15675d("TXCMP4SWMuxer", "start");
                this.f5343f = new TXSWMuxerJNI();
                AVOptions aVOptions = new AVOptions();
                if (this.f5345h != null) {
                    integer = this.f5345h.getInteger("width");
                    aVOptions.videoHeight = this.f5345h.getInteger("height");
                    aVOptions.videoWidth = integer;
                    aVOptions.videoGOP = this.f5345h.containsKey("i-frame-interval") ? this.f5345h.getInteger("i-frame-interval") : 3;
                }
                if (this.f5346i != null) {
                    integer = this.f5346i.getInteger("channel-count");
                    int integer2 = this.f5346i.getInteger("sample-rate");
                    aVOptions.audioChannels = integer;
                    aVOptions.audioSampleRate = integer2;
                }
                ByteBuffer e = m40697e();
                ByteBuffer f = m40698f();
                ByteBuffer byteBuffer = null;
                if (this.f5346i != null) {
                    byteBuffer = m40695d();
                }
                if (e == null || f == null) {
                    TXCLog.m15676e("TXCMP4SWMuxer", "video format contains error csd!");
                    AppMethodBeat.m2505o(67127);
                    i = -3;
                } else if (this.f5346i == null || byteBuffer != null) {
                    this.f5343f.mo52799a(e, e.capacity(), f, f.capacity());
                    if (this.f5346i != null) {
                        this.f5343f.mo52798a(byteBuffer, byteBuffer.capacity());
                    }
                    this.f5343f.mo52796a(aVOptions);
                    this.f5343f.mo52797a(this.f5344g);
                    this.f5343f.mo52794a();
                    this.f5353p = -1;
                    this.f5349l = true;
                    this.f5350m = false;
                    this.f5354q = -1;
                    this.f5355r = -1;
                    AppMethodBeat.m2505o(67127);
                } else {
                    TXCLog.m15676e("TXCMP4SWMuxer", "audio format contains error csd!");
                    AppMethodBeat.m2505o(67127);
                    i = -3;
                }
            }
        }
        return i;
    }

    /* renamed from: b */
    public synchronized int mo19922b() {
        int i = 0;
        synchronized (this) {
            AppMethodBeat.m2504i(67128);
            if (this.f5343f != null) {
                m40700h();
                TXCLog.m15675d("TXCMP4SWMuxer", "stop. start flag = " + this.f5349l + ", video key frame set = " + this.f5350m);
                try {
                    if (this.f5349l && this.f5350m) {
                        this.f5343f.mo52800b();
                    }
                    this.f5343f.mo52801c();
                    this.f5343f = null;
                    this.f5349l = false;
                    this.f5343f = null;
                    this.f5350m = false;
                    this.f5351n.clear();
                    this.f5352o.clear();
                    this.f5345h = null;
                    this.f5346i = null;
                    this.f5354q = -1;
                    this.f5355r = -1;
                } catch (Exception e) {
                    TXCLog.m15676e("TXCMP4SWMuxer", "muxer stop/release exception: ".concat(String.valueOf(e)));
                    this.f5349l = false;
                    this.f5343f = null;
                    this.f5350m = false;
                    this.f5351n.clear();
                    this.f5352o.clear();
                    this.f5345h = null;
                    this.f5346i = null;
                    this.f5354q = -1;
                    this.f5355r = -1;
                    i = -1;
                    AppMethodBeat.m2505o(67128);
                } catch (Throwable th) {
                    this.f5349l = false;
                    this.f5343f = null;
                    this.f5350m = false;
                    this.f5351n.clear();
                    this.f5352o.clear();
                    this.f5345h = null;
                    this.f5346i = null;
                    this.f5354q = -1;
                    this.f5355r = -1;
                    AppMethodBeat.m2505o(67128);
                }
            }
            AppMethodBeat.m2505o(67128);
        }
        return i;
    }

    /* renamed from: a */
    public synchronized void mo19919a(String str) {
        AppMethodBeat.m2504i(67129);
        this.f5344g = str;
        if (!TextUtils.isEmpty(this.f5344g)) {
            File file = new File(this.f5344g);
            if (file.exists()) {
                file.delete();
            }
            try {
                file.createNewFile();
                AppMethodBeat.m2505o(67129);
            } catch (IOException e) {
            }
        }
        AppMethodBeat.m2505o(67129);
    }

    /* renamed from: b */
    public synchronized void mo19925b(byte[] bArr, int i, int i2, long j, int i3) {
        AppMethodBeat.m2504i(67130);
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(i2);
        allocateDirect.put(bArr, i, i2);
        BufferInfo bufferInfo = new BufferInfo();
        bufferInfo.presentationTimeUs = j;
        bufferInfo.offset = 0;
        bufferInfo.size = i2;
        bufferInfo.flags = i3;
        mo43411a(allocateDirect, bufferInfo);
        AppMethodBeat.m2505o(67130);
    }

    /* renamed from: a */
    public synchronized void mo19921a(byte[] bArr, int i, int i2, long j, int i3) {
        AppMethodBeat.m2504i(67131);
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(i2);
        allocateDirect.put(bArr, i, i2);
        BufferInfo bufferInfo = new BufferInfo();
        bufferInfo.presentationTimeUs = j;
        bufferInfo.offset = 0;
        bufferInfo.size = i2;
        bufferInfo.flags = i3;
        mo43412b(allocateDirect, bufferInfo);
        AppMethodBeat.m2505o(67131);
    }

    /* renamed from: a */
    public synchronized void mo43411a(ByteBuffer byteBuffer, BufferInfo bufferInfo) {
        AppMethodBeat.m2504i(67132);
        if (this.f5343f == null) {
            m40693a(true, byteBuffer, bufferInfo);
            TXCLog.m15679w("TXCMP4SWMuxer", "cache frame before muexer ready. ptsUs: " + bufferInfo.presentationTimeUs);
            AppMethodBeat.m2505o(67132);
        } else if (this.f5353p < 0) {
            m40693a(true, byteBuffer, bufferInfo);
            this.f5353p = m40699g();
            TXCLog.m15675d("TXCMP4SWMuxer", "first frame offset = " + this.f5353p);
            m40701i();
            AppMethodBeat.m2505o(67132);
        } else {
            m40692a(bufferInfo.presentationTimeUs);
            m40694c(byteBuffer, bufferInfo);
            AppMethodBeat.m2505o(67132);
        }
    }

    /* renamed from: b */
    public synchronized void mo43412b(ByteBuffer byteBuffer, BufferInfo bufferInfo) {
        AppMethodBeat.m2504i(67133);
        m40693a(false, byteBuffer, bufferInfo);
        AppMethodBeat.m2505o(67133);
    }

    /* renamed from: c */
    private void m40694c(ByteBuffer byteBuffer, BufferInfo bufferInfo) {
        long j = 0;
        int i = 1;
        AppMethodBeat.m2504i(67134);
        long j2 = bufferInfo.presentationTimeUs - this.f5353p;
        if (j2 < 0) {
            TXCLog.m15676e("TXCMP4SWMuxer", "pts error! first frame offset timeus = " + this.f5353p + ", current timeus = " + bufferInfo.presentationTimeUs);
            if (this.f5354q > 0) {
                j = this.f5354q;
            }
        } else {
            j = j2;
        }
        if (j < this.f5354q) {
            TXCLog.m15679w("TXCMP4SWMuxer", "video is not in chronological order. current frame's pts(" + j + ") smaller than pre frame's pts(" + this.f5354q + ")");
        } else {
            this.f5354q = j;
        }
        if (this.f5342e != 2) {
            if (this.f5342e == 3) {
                j = (long) (((float) j) * f5339b);
            } else if (this.f5342e == 4) {
                j = (long) (((float) j) * f5338a);
            } else if (this.f5342e == 1) {
                j = (long) (((float) j) * f5340c);
            } else if (this.f5342e == 0) {
                j = (long) (((float) j) * f5341d);
            }
        }
        bufferInfo.presentationTimeUs = j;
        try {
            byteBuffer.position(bufferInfo.offset);
            byteBuffer.limit(bufferInfo.offset + bufferInfo.size);
            TXSWMuxerJNI tXSWMuxerJNI = this.f5343f;
            int i2 = bufferInfo.offset;
            int i3 = bufferInfo.size;
            if (bufferInfo.flags != 1) {
                i = 0;
            }
            tXSWMuxerJNI.mo52795a(byteBuffer, 1, i2, i3, i, bufferInfo.presentationTimeUs);
            if ((bufferInfo.flags & 1) != 0) {
                this.f5350m = true;
            }
            AppMethodBeat.m2505o(67134);
        } catch (IllegalStateException e) {
            TXCLog.m15676e("TXCMP4SWMuxer", "write frame IllegalStateException: ".concat(String.valueOf(e)));
            AppMethodBeat.m2505o(67134);
        } catch (IllegalArgumentException e2) {
            TXCLog.m15676e("TXCMP4SWMuxer", "write frame IllegalArgumentException: ".concat(String.valueOf(e2)));
            AppMethodBeat.m2505o(67134);
        }
    }

    /* renamed from: d */
    private void m40696d(ByteBuffer byteBuffer, BufferInfo bufferInfo) {
        AppMethodBeat.m2504i(67135);
        long j = bufferInfo.presentationTimeUs - this.f5353p;
        if (this.f5353p < 0 || j < 0) {
            TXCLog.m15679w("TXCMP4SWMuxer", "drop sample. first frame offset timeus = " + this.f5353p + ", current sample timeus = " + bufferInfo.presentationTimeUs);
            AppMethodBeat.m2505o(67135);
            return;
        }
        if (j < this.f5355r) {
            TXCLog.m15676e("TXCMP4SWMuxer", "audio is not in chronological order. current audio's pts pts(" + j + ") must larger than pre audio's pts(" + this.f5355r + ")");
            j = this.f5355r + 1;
        } else {
            this.f5355r = j;
        }
        if (this.f5342e != 2) {
            if (this.f5342e == 3) {
                j = (long) (((float) j) * f5339b);
            } else if (this.f5342e == 4) {
                j = (long) (((float) j) * f5338a);
            } else if (this.f5342e == 1) {
                j = (long) (((float) j) * f5340c);
            } else if (this.f5342e == 0) {
                j = (long) (((float) j) * f5341d);
            }
        }
        bufferInfo.presentationTimeUs = j;
        try {
            byteBuffer.position(bufferInfo.offset);
            byteBuffer.limit(bufferInfo.offset + bufferInfo.size);
            this.f5343f.mo52795a(byteBuffer, 0, bufferInfo.offset, bufferInfo.size, bufferInfo.flags, bufferInfo.presentationTimeUs);
            AppMethodBeat.m2505o(67135);
        } catch (IllegalStateException e) {
            TXCLog.m15676e("TXCMP4SWMuxer", "write sample IllegalStateException: ".concat(String.valueOf(e)));
            AppMethodBeat.m2505o(67135);
        } catch (IllegalArgumentException e2) {
            TXCLog.m15676e("TXCMP4SWMuxer", "write sample IllegalArgumentException: ".concat(String.valueOf(e2)));
            AppMethodBeat.m2505o(67135);
        }
    }

    /* renamed from: a */
    private void m40693a(boolean z, ByteBuffer byteBuffer, BufferInfo bufferInfo) {
        AppMethodBeat.m2504i(67136);
        if (byteBuffer == null || bufferInfo == null) {
            AppMethodBeat.m2505o(67136);
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
        C8819a c8819a = new C8819a(allocateDirect, bufferInfo2);
        if (!z) {
            this.f5352o.add(c8819a);
            AppMethodBeat.m2505o(67136);
        } else if (this.f5351n.size() < 200) {
            this.f5351n.add(c8819a);
            AppMethodBeat.m2505o(67136);
        } else {
            TXCLog.m15676e("TXCMP4SWMuxer", "drop video frame. video cache size is larger than 200");
            AppMethodBeat.m2505o(67136);
        }
    }

    /* renamed from: g */
    private long m40699g() {
        long j;
        AppMethodBeat.m2504i(67137);
        if (this.f5351n.size() > 0) {
            j = ((C8819a) this.f5351n.peek()).mo19930b().presentationTimeUs;
        } else {
            j = 0;
        }
        if (this.f5352o.size() > 0) {
            C8819a c8819a = (C8819a) this.f5352o.peek();
            if (!(c8819a == null || c8819a.mo19930b() == null)) {
                long j2 = ((C8819a) this.f5352o.peek()).mo19930b().presentationTimeUs;
                if (j > j2) {
                    j = j2;
                }
            }
        }
        AppMethodBeat.m2505o(67137);
        return j;
    }

    /* renamed from: h */
    private void m40700h() {
        C8819a c8819a;
        AppMethodBeat.m2504i(67138);
        while (this.f5351n.size() > 0) {
            c8819a = (C8819a) this.f5351n.poll();
            m40694c(c8819a.mo19929a(), c8819a.mo19930b());
        }
        while (this.f5352o.size() > 0) {
            c8819a = (C8819a) this.f5352o.poll();
            m40696d(c8819a.mo19929a(), c8819a.mo19930b());
        }
        AppMethodBeat.m2505o(67138);
    }

    /* renamed from: i */
    private void m40701i() {
        AppMethodBeat.m2504i(67139);
        while (this.f5351n.size() > 0) {
            C8819a c8819a = (C8819a) this.f5351n.poll();
            m40692a(c8819a.mo19930b().presentationTimeUs);
            m40694c(c8819a.mo19929a(), c8819a.mo19930b());
        }
        AppMethodBeat.m2505o(67139);
    }

    /* renamed from: a */
    private void m40692a(long j) {
        AppMethodBeat.m2504i(67140);
        while (this.f5352o.size() > 0) {
            if (((C8819a) this.f5352o.peek()).mo19930b() != null) {
                if (((C8819a) this.f5352o.peek()).mo19930b().presentationTimeUs >= j) {
                    break;
                }
                C8819a c8819a = (C8819a) this.f5352o.poll();
                m40696d(c8819a.mo19929a(), c8819a.mo19930b());
            } else {
                TXCLog.m15676e("TXCMP4SWMuxer", "flushAudioCache, bufferInfo is null");
                this.f5352o.remove();
            }
        }
        AppMethodBeat.m2505o(67140);
    }
}
