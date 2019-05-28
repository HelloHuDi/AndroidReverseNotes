package com.tencent.liteav.audio.impl.Record;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.media.MediaFormat;
import com.tencent.liteav.audio.C8790b;
import com.tencent.liteav.audio.C8792d;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.C17778b;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.ugc.TXRecordCommon;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.Vector;

/* renamed from: com.tencent.liteav.audio.impl.Record.e */
public class C41677e extends Thread {
    /* renamed from: a */
    private BufferInfo f16905a;
    /* renamed from: b */
    private MediaCodecInfo f16906b;
    /* renamed from: c */
    private MediaFormat f16907c;
    /* renamed from: d */
    private MediaCodec f16908d;
    /* renamed from: e */
    private Vector<byte[]> f16909e;
    /* renamed from: f */
    private WeakReference<C8792d> f16910f;
    /* renamed from: g */
    private volatile boolean f16911g = false;
    /* renamed from: h */
    private volatile boolean f16912h = false;
    /* renamed from: i */
    private final Object f16913i = new Object();
    /* renamed from: j */
    private long f16914j = 0;
    /* renamed from: k */
    private int f16915k = C8790b.f2444a;
    /* renamed from: l */
    private int f16916l = C8790b.f2445b;
    /* renamed from: m */
    private int f16917m = C8790b.f2446c;
    /* renamed from: n */
    private byte[] f16918n;

    static {
        AppMethodBeat.m2504i(66681);
        C17778b.m27756e();
        AppMethodBeat.m2505o(66681);
    }

    @TargetApi(16)
    public C41677e() {
        super("TXAudioRecordThread");
        AppMethodBeat.m2504i(66669);
        AppMethodBeat.m2505o(66669);
    }

    /* renamed from: a */
    public void mo67224a(int i, int i2, int i3, int i4, WeakReference<C8792d> weakReference) {
        AppMethodBeat.m2504i(66670);
        this.f16910f = weakReference;
        this.f16905a = new BufferInfo();
        this.f16909e = new Vector();
        this.f16915k = i2;
        this.f16916l = i3;
        this.f16917m = i4;
        m73090b();
        AppMethodBeat.m2505o(66670);
    }

    /* renamed from: a */
    public void mo67225a(byte[] bArr, long j) {
        AppMethodBeat.m2504i(66671);
        if (!(this.f16909e == null || bArr == null)) {
            synchronized (this.f16909e) {
                try {
                    if (this.f16909e == null) {
                    } else {
                        this.f16909e.add(bArr);
                    }
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.m2505o(66671);
                }
            }
        }
        synchronized (this.f16913i) {
            try {
                this.f16913i.notify();
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(66671);
            }
        }
    }

    /* renamed from: a */
    public void mo67223a() {
        AppMethodBeat.m2504i(66672);
        m73092c();
        AppMethodBeat.m2505o(66672);
    }

    /* renamed from: b */
    private void m73090b() {
        int i = TXRecordCommon.AUDIO_SAMPLERATE_32000;
        AppMethodBeat.m2504i(66673);
        this.f16906b = C41677e.m73088a("audio/mp4a-latm");
        if (this.f16906b == null) {
            TXCLog.m15676e("AudioCenter:TXCAudioHWEncoder", "Unable to find an appropriate codec for audio/mp4a-latm");
            AppMethodBeat.m2505o(66673);
            return;
        }
        TXCLog.m15677i("AudioCenter:TXCAudioHWEncoder", "selected codec: " + this.f16906b.getName());
        if (this.f16915k >= TXRecordCommon.AUDIO_SAMPLERATE_32000) {
            i = 64000;
        }
        this.f16907c = MediaFormat.createAudioFormat("audio/mp4a-latm", this.f16915k, this.f16916l);
        this.f16907c.setInteger(FFmpegMetadataRetriever.METADATA_KEY_VARIANT_BITRATE, i);
        this.f16907c.setInteger("channel-count", this.f16916l);
        this.f16907c.setInteger("sample-rate", this.f16915k);
        this.f16907c.setInteger("aac-profile", 2);
        TXCLog.m15677i("AudioCenter:TXCAudioHWEncoder", "format: " + this.f16907c);
        try {
            m73093d();
        } catch (Exception e) {
        }
        start();
        AppMethodBeat.m2505o(66673);
    }

    /* renamed from: c */
    private void m73092c() {
        this.f16912h = true;
    }

    @TargetApi(16)
    /* renamed from: d */
    private void m73093d() {
        AppMethodBeat.m2504i(66674);
        if (this.f16908d != null) {
            AppMethodBeat.m2505o(66674);
            return;
        }
        this.f16908d = MediaCodec.createEncoderByType("audio/mp4a-latm");
        this.f16908d.configure(this.f16907c, null, null, 1);
        this.f16908d.start();
        TXCLog.m15677i("AudioCenter:TXCAudioHWEncoder", "prepare finishing");
        this.f16911g = true;
        AppMethodBeat.m2505o(66674);
    }

    /* renamed from: e */
    private void m73094e() {
        AppMethodBeat.m2504i(66675);
        if (this.f16908d != null) {
            this.f16908d.stop();
            this.f16908d.release();
            this.f16908d = null;
        }
        this.f16911g = false;
        AppMethodBeat.m2505o(66675);
    }

    public void run() {
        AppMethodBeat.m2504i(66676);
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
        while (!this.f16912h) {
            if (this.f16911g) {
                boolean isEmpty;
                synchronized (this.f16909e) {
                    try {
                        isEmpty = this.f16909e.isEmpty();
                    } catch (Throwable th) {
                        while (true) {
                            AppMethodBeat.m2505o(66676);
                        }
                    }
                }
                if (isEmpty) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                    }
                } else {
                    byte[] bArr;
                    synchronized (this.f16909e) {
                        try {
                            bArr = (byte[]) this.f16909e.remove(0);
                        } catch (Throwable th2) {
                            while (true) {
                                AppMethodBeat.m2505o(66676);
                            }
                        }
                    }
                    if (bArr != null) {
                        try {
                            allocateDirect.clear();
                            if (bArr.length > allocateDirect.capacity()) {
                                allocateDirect = ByteBuffer.allocateDirect(bArr.length);
                            }
                            allocateDirect.clear();
                            allocateDirect.put(bArr);
                            allocateDirect.flip();
                            m73089a(allocateDirect, bArr.length, m73095f());
                        } catch (Exception e2) {
                        }
                    }
                    allocateDirect = allocateDirect;
                }
            } else {
                synchronized (this.f16913i) {
                    try {
                        this.f16913i.wait();
                    } catch (InterruptedException e3) {
                    }
                    try {
                    } catch (Throwable th3) {
                        AppMethodBeat.m2505o(66676);
                    }
                }
            }
        }
        m73094e();
        AppMethodBeat.m2505o(66676);
    }

    /* renamed from: a */
    private void m73089a(ByteBuffer byteBuffer, int i, long j) {
        AppMethodBeat.m2504i(66677);
        if (this.f16912h) {
            AppMethodBeat.m2505o(66677);
            return;
        }
        ByteBuffer[] inputBuffers = this.f16908d.getInputBuffers();
        int dequeueInputBuffer = this.f16908d.dequeueInputBuffer(10000);
        if (dequeueInputBuffer >= 0) {
            ByteBuffer byteBuffer2 = inputBuffers[dequeueInputBuffer];
            byteBuffer2.clear();
            if (byteBuffer != null) {
                byteBuffer2.put(byteBuffer);
            }
            if (i <= 0) {
                TXCLog.m15677i("AudioCenter:TXCAudioHWEncoder", "send BUFFER_FLAG_END_OF_STREAM");
                this.f16908d.queueInputBuffer(dequeueInputBuffer, 0, 0, j, 4);
            } else {
                this.f16908d.queueInputBuffer(dequeueInputBuffer, 0, i, j, 0);
            }
        }
        inputBuffers = this.f16908d.getOutputBuffers();
        do {
            dequeueInputBuffer = this.f16908d.dequeueOutputBuffer(this.f16905a, 10000);
            if (dequeueInputBuffer != -1) {
                if (dequeueInputBuffer == -3) {
                    inputBuffers = this.f16908d.getOutputBuffers();
                    continue;
                } else if (dequeueInputBuffer == -2) {
                    this.f16908d.getOutputFormat();
                    continue;
                } else if (dequeueInputBuffer >= 0) {
                    ByteBuffer byteBuffer3 = inputBuffers[dequeueInputBuffer];
                    if ((this.f16905a.flags & 2) != 0) {
                        TXCLog.m15675d("AudioCenter:TXCAudioHWEncoder", "drain:BUFFER_FLAG_CODEC_CONFIG");
                        this.f16905a.size = 0;
                    }
                    if (this.f16905a.size != 0) {
                        this.f16905a.presentationTimeUs = m73095f();
                        this.f16918n = new byte[byteBuffer3.limit()];
                        byteBuffer3.get(this.f16918n);
                        m73091b(this.f16918n, this.f16905a.presentationTimeUs);
                        this.f16914j = this.f16905a.presentationTimeUs;
                    }
                    this.f16908d.releaseOutputBuffer(dequeueInputBuffer, false);
                    continue;
                } else {
                    continue;
                }
            }
        } while (dequeueInputBuffer >= 0);
        AppMethodBeat.m2505o(66677);
    }

    /* renamed from: f */
    private long m73095f() {
        AppMethodBeat.m2504i(66678);
        long timeTick = TXCTimeUtil.getTimeTick();
        if (timeTick < this.f16914j) {
            timeTick += this.f16914j - timeTick;
        }
        AppMethodBeat.m2505o(66678);
        return timeTick;
    }

    /* renamed from: a */
    private static final MediaCodecInfo m73088a(String str) {
        MediaCodecInfo mediaCodecInfo;
        AppMethodBeat.m2504i(66679);
        TXCLog.m15678v("AudioCenter:TXCAudioHWEncoder", "selectAudioCodec:");
        int codecCount = MediaCodecList.getCodecCount();
        loop0:
        for (int i = 0; i < codecCount; i++) {
            MediaCodecInfo codecInfoAt = MediaCodecList.getCodecInfoAt(i);
            if (codecInfoAt.isEncoder()) {
                String[] supportedTypes = codecInfoAt.getSupportedTypes();
                for (int i2 = 0; i2 < supportedTypes.length; i2++) {
                    TXCLog.m15677i("AudioCenter:TXCAudioHWEncoder", "supportedType:" + codecInfoAt.getName() + ",MIME=" + supportedTypes[i2]);
                    if (supportedTypes[i2].equalsIgnoreCase(str)) {
                        mediaCodecInfo = codecInfoAt;
                        break loop0;
                    }
                }
                continue;
            }
        }
        mediaCodecInfo = null;
        AppMethodBeat.m2505o(66679);
        return mediaCodecInfo;
    }

    /* renamed from: b */
    private void m73091b(byte[] bArr, long j) {
        AppMethodBeat.m2504i(66680);
        if (this.f16910f != null) {
            C8792d c8792d = (C8792d) this.f16910f.get();
            if (c8792d != null) {
                c8792d.mo19858b(bArr, j, this.f16915k, this.f16916l, this.f16917m);
            }
        }
        AppMethodBeat.m2505o(66680);
    }
}
