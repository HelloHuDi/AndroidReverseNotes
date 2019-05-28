package com.tencent.liteav.audio.impl.Record;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.media.MediaFormat;
import com.tencent.liteav.audio.b;
import com.tencent.liteav.audio.d;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.ugc.TXRecordCommon;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.Vector;

public class e extends Thread {
    private BufferInfo a;
    private MediaCodecInfo b;
    private MediaFormat c;
    private MediaCodec d;
    private Vector<byte[]> e;
    private WeakReference<d> f;
    private volatile boolean g = false;
    private volatile boolean h = false;
    private final Object i = new Object();
    private long j = 0;
    private int k = b.a;
    private int l = b.b;
    private int m = b.c;
    private byte[] n;

    static {
        AppMethodBeat.i(66681);
        com.tencent.liteav.basic.util.b.e();
        AppMethodBeat.o(66681);
    }

    @TargetApi(16)
    public e() {
        super("TXAudioRecordThread");
        AppMethodBeat.i(66669);
        AppMethodBeat.o(66669);
    }

    public void a(int i, int i2, int i3, int i4, WeakReference<d> weakReference) {
        AppMethodBeat.i(66670);
        this.f = weakReference;
        this.a = new BufferInfo();
        this.e = new Vector();
        this.k = i2;
        this.l = i3;
        this.m = i4;
        b();
        AppMethodBeat.o(66670);
    }

    public void a(byte[] bArr, long j) {
        AppMethodBeat.i(66671);
        if (!(this.e == null || bArr == null)) {
            synchronized (this.e) {
                try {
                    if (this.e == null) {
                    } else {
                        this.e.add(bArr);
                    }
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.o(66671);
                }
            }
        }
        synchronized (this.i) {
            try {
                this.i.notify();
            } finally {
                while (true) {
                }
                AppMethodBeat.o(66671);
            }
        }
    }

    public void a() {
        AppMethodBeat.i(66672);
        c();
        AppMethodBeat.o(66672);
    }

    private void b() {
        int i = TXRecordCommon.AUDIO_SAMPLERATE_32000;
        AppMethodBeat.i(66673);
        this.b = a("audio/mp4a-latm");
        if (this.b == null) {
            TXCLog.e("AudioCenter:TXCAudioHWEncoder", "Unable to find an appropriate codec for audio/mp4a-latm");
            AppMethodBeat.o(66673);
            return;
        }
        TXCLog.i("AudioCenter:TXCAudioHWEncoder", "selected codec: " + this.b.getName());
        if (this.k >= TXRecordCommon.AUDIO_SAMPLERATE_32000) {
            i = 64000;
        }
        this.c = MediaFormat.createAudioFormat("audio/mp4a-latm", this.k, this.l);
        this.c.setInteger(FFmpegMetadataRetriever.METADATA_KEY_VARIANT_BITRATE, i);
        this.c.setInteger("channel-count", this.l);
        this.c.setInteger("sample-rate", this.k);
        this.c.setInteger("aac-profile", 2);
        TXCLog.i("AudioCenter:TXCAudioHWEncoder", "format: " + this.c);
        try {
            d();
        } catch (Exception e) {
        }
        start();
        AppMethodBeat.o(66673);
    }

    private void c() {
        this.h = true;
    }

    @TargetApi(16)
    private void d() {
        AppMethodBeat.i(66674);
        if (this.d != null) {
            AppMethodBeat.o(66674);
            return;
        }
        this.d = MediaCodec.createEncoderByType("audio/mp4a-latm");
        this.d.configure(this.c, null, null, 1);
        this.d.start();
        TXCLog.i("AudioCenter:TXCAudioHWEncoder", "prepare finishing");
        this.g = true;
        AppMethodBeat.o(66674);
    }

    private void e() {
        AppMethodBeat.i(66675);
        if (this.d != null) {
            this.d.stop();
            this.d.release();
            this.d = null;
        }
        this.g = false;
        AppMethodBeat.o(66675);
    }

    public void run() {
        AppMethodBeat.i(66676);
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
        while (!this.h) {
            if (this.g) {
                boolean isEmpty;
                synchronized (this.e) {
                    try {
                        isEmpty = this.e.isEmpty();
                    } catch (Throwable th) {
                        while (true) {
                            AppMethodBeat.o(66676);
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
                    synchronized (this.e) {
                        try {
                            bArr = (byte[]) this.e.remove(0);
                        } catch (Throwable th2) {
                            while (true) {
                                AppMethodBeat.o(66676);
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
                            a(allocateDirect, bArr.length, f());
                        } catch (Exception e2) {
                        }
                    }
                    allocateDirect = allocateDirect;
                }
            } else {
                synchronized (this.i) {
                    try {
                        this.i.wait();
                    } catch (InterruptedException e3) {
                    }
                    try {
                    } catch (Throwable th3) {
                        AppMethodBeat.o(66676);
                    }
                }
            }
        }
        e();
        AppMethodBeat.o(66676);
    }

    private void a(ByteBuffer byteBuffer, int i, long j) {
        AppMethodBeat.i(66677);
        if (this.h) {
            AppMethodBeat.o(66677);
            return;
        }
        ByteBuffer[] inputBuffers = this.d.getInputBuffers();
        int dequeueInputBuffer = this.d.dequeueInputBuffer(10000);
        if (dequeueInputBuffer >= 0) {
            ByteBuffer byteBuffer2 = inputBuffers[dequeueInputBuffer];
            byteBuffer2.clear();
            if (byteBuffer != null) {
                byteBuffer2.put(byteBuffer);
            }
            if (i <= 0) {
                TXCLog.i("AudioCenter:TXCAudioHWEncoder", "send BUFFER_FLAG_END_OF_STREAM");
                this.d.queueInputBuffer(dequeueInputBuffer, 0, 0, j, 4);
            } else {
                this.d.queueInputBuffer(dequeueInputBuffer, 0, i, j, 0);
            }
        }
        inputBuffers = this.d.getOutputBuffers();
        do {
            dequeueInputBuffer = this.d.dequeueOutputBuffer(this.a, 10000);
            if (dequeueInputBuffer != -1) {
                if (dequeueInputBuffer == -3) {
                    inputBuffers = this.d.getOutputBuffers();
                    continue;
                } else if (dequeueInputBuffer == -2) {
                    this.d.getOutputFormat();
                    continue;
                } else if (dequeueInputBuffer >= 0) {
                    ByteBuffer byteBuffer3 = inputBuffers[dequeueInputBuffer];
                    if ((this.a.flags & 2) != 0) {
                        TXCLog.d("AudioCenter:TXCAudioHWEncoder", "drain:BUFFER_FLAG_CODEC_CONFIG");
                        this.a.size = 0;
                    }
                    if (this.a.size != 0) {
                        this.a.presentationTimeUs = f();
                        this.n = new byte[byteBuffer3.limit()];
                        byteBuffer3.get(this.n);
                        b(this.n, this.a.presentationTimeUs);
                        this.j = this.a.presentationTimeUs;
                    }
                    this.d.releaseOutputBuffer(dequeueInputBuffer, false);
                    continue;
                } else {
                    continue;
                }
            }
        } while (dequeueInputBuffer >= 0);
        AppMethodBeat.o(66677);
    }

    private long f() {
        AppMethodBeat.i(66678);
        long timeTick = TXCTimeUtil.getTimeTick();
        if (timeTick < this.j) {
            timeTick += this.j - timeTick;
        }
        AppMethodBeat.o(66678);
        return timeTick;
    }

    private static final MediaCodecInfo a(String str) {
        MediaCodecInfo mediaCodecInfo;
        AppMethodBeat.i(66679);
        TXCLog.v("AudioCenter:TXCAudioHWEncoder", "selectAudioCodec:");
        int codecCount = MediaCodecList.getCodecCount();
        loop0:
        for (int i = 0; i < codecCount; i++) {
            MediaCodecInfo codecInfoAt = MediaCodecList.getCodecInfoAt(i);
            if (codecInfoAt.isEncoder()) {
                String[] supportedTypes = codecInfoAt.getSupportedTypes();
                for (int i2 = 0; i2 < supportedTypes.length; i2++) {
                    TXCLog.i("AudioCenter:TXCAudioHWEncoder", "supportedType:" + codecInfoAt.getName() + ",MIME=" + supportedTypes[i2]);
                    if (supportedTypes[i2].equalsIgnoreCase(str)) {
                        mediaCodecInfo = codecInfoAt;
                        break loop0;
                    }
                }
                continue;
            }
        }
        mediaCodecInfo = null;
        AppMethodBeat.o(66679);
        return mediaCodecInfo;
    }

    private void b(byte[] bArr, long j) {
        AppMethodBeat.i(66680);
        if (this.f != null) {
            d dVar = (d) this.f.get();
            if (dVar != null) {
                dVar.b(bArr, j, this.k, this.l, this.m);
            }
        }
        AppMethodBeat.o(66680);
    }
}
