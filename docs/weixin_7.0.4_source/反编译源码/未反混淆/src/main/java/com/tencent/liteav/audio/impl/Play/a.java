package com.tencent.liteav.audio.impl.Play;

import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaCodec.CodecException;
import android.media.MediaFormat;
import android.os.Build.VERSION;
import com.tencent.liteav.audio.TXEAudioDef;
import com.tencent.liteav.audio.c;
import com.tencent.liteav.audio.impl.b;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class a implements Runnable {
    private static final String a = ("AudioCenter:" + a.class.getSimpleName());
    private WeakReference<c> b = null;
    private MediaCodec c = null;
    private BufferInfo d;
    private MediaFormat e;
    private long f = 0;
    private volatile boolean g = false;
    private Vector<com.tencent.liteav.basic.g.a> h;
    private List i;
    private Thread j = null;

    static {
        AppMethodBeat.i(66592);
        AppMethodBeat.o(66592);
    }

    public void a(WeakReference<c> weakReference) {
        AppMethodBeat.i(66584);
        if (this.g) {
            b();
        }
        this.b = weakReference;
        this.f = 0;
        this.h = new Vector();
        this.i = new ArrayList();
        this.g = true;
        this.j = new Thread(this);
        this.j.setName(a);
        this.j.start();
        AppMethodBeat.o(66584);
    }

    public void a(com.tencent.liteav.basic.g.a aVar) {
        AppMethodBeat.i(66585);
        if (this.g) {
            synchronized (this.h) {
                try {
                    if (this.h != null) {
                        this.h.add(aVar);
                    }
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.o(66585);
                }
            }
            return;
        }
        AppMethodBeat.o(66585);
    }

    public long a() {
        AppMethodBeat.i(66586);
        if (this.e != null) {
            float integer = (float) this.e.getInteger("sample-rate");
            if (integer != 0.0f) {
                long size = (long) (((((float) this.i.size()) * 1024.0f) * 1000.0f) / integer);
                AppMethodBeat.o(66586);
                return size;
            }
            AppMethodBeat.o(66586);
            return 0;
        }
        AppMethodBeat.o(66586);
        return 0;
    }

    public void b() {
        AppMethodBeat.i(66587);
        this.g = false;
        if (this.j != null) {
            try {
                this.j.join();
            } catch (InterruptedException e) {
            }
            this.j = null;
        }
        AppMethodBeat.o(66587);
    }

    public void run() {
        int i;
        Object e;
        AppMethodBeat.i(66588);
        while (this.g) {
            boolean isEmpty;
            synchronized (this.h) {
                try {
                    isEmpty = this.h.isEmpty();
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.o(66588);
                }
            }
            if (isEmpty) {
                try {
                    Thread.sleep(10);
                } catch (Exception e2) {
                }
            } else {
                ByteBuffer[] inputBuffers;
                com.tencent.liteav.basic.g.a aVar;
                if (this.c != null) {
                    try {
                        inputBuffers = this.c.getInputBuffers();
                        i = 1;
                        try {
                            int dequeueInputBuffer = this.c.dequeueInputBuffer(10000);
                            if (dequeueInputBuffer >= 0) {
                                i = dequeueInputBuffer;
                            } else {
                                return;
                            }
                        } catch (Exception e3) {
                            e = e3;
                        }
                    } catch (Exception e4) {
                        e = e4;
                        i = 0;
                        TXCLog.e(a, "Exception. step: " + i + ", error: " + e);
                        AppMethodBeat.o(66588);
                        return;
                    }
                }
                i = -1;
                inputBuffers = null;
                synchronized (this.h) {
                    try {
                        aVar = (com.tencent.liteav.basic.g.a) this.h.remove(0);
                    } catch (Throwable th) {
                        while (true) {
                            AppMethodBeat.o(66588);
                        }
                    }
                }
                if (aVar.d == com.tencent.liteav.basic.a.a.k) {
                    b(aVar);
                } else if (aVar.d == com.tencent.liteav.basic.a.a.l) {
                    this.i.add(Long.valueOf(aVar.e));
                    a(aVar, inputBuffers, i);
                } else {
                    TXCLog.e(a, "not support audio format");
                }
            }
        }
        if (this.c != null) {
            this.c.stop();
            this.c.release();
            this.c = null;
        }
        AppMethodBeat.o(66588);
    }

    /* JADX WARNING: Removed duplicated region for block: B:55:0x01a6  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x00be  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00d2  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x00be  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x01a6  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00d2  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int b(com.tencent.liteav.basic.g.a aVar) {
        Object e;
        int i;
        Object e2;
        AppMethodBeat.i(66589);
        if (aVar.f.length != 2) {
            TXCLog.w(a, "aac seq header len not equal to 2 , with len " + aVar.f.length);
        }
        if (aVar.f != null) {
            int a = b.a(((aVar.f[0] & 7) << 1) | ((aVar.f[1] & 128) >> 7));
            int i2 = (aVar.f[1] & 120) >> 3;
            this.e = MediaFormat.createAudioFormat("audio/mp4a-latm", a, i2);
            this.e.setInteger(FFmpegMetadataRetriever.METADATA_KEY_VARIANT_BITRATE, 64000);
            this.e.setInteger("is-adts", 0);
            this.e.setInteger("aac-profile", 2);
            TXCLog.i(a, "audio decoder media format: " + this.e);
            if (this.b != null) {
                c cVar = (c) this.b.get();
                com.tencent.liteav.basic.g.a aVar2 = new com.tencent.liteav.basic.g.a();
                aVar2.c = com.tencent.liteav.basic.a.a.h;
                aVar2.b = i2;
                aVar2.a = a;
                if (cVar != null) {
                    cVar.onPlayAudioInfoChanged(aVar2, aVar2);
                }
            }
            if (this.c != null) {
                try {
                    this.c.stop();
                    try {
                        this.c.release();
                    } catch (Exception e3) {
                        e = e3;
                        a = 1;
                        TXCLog.e(a, "hw audio decoder release error: " + a + ". error: " + e);
                        this.c = MediaCodec.createDecoderByType("audio/mp4a-latm");
                        if (VERSION.SDK_INT >= 21) {
                        }
                        if (this.c != null) {
                        }
                        i = TXEAudioDef.TXE_AUDIO_PLAY_ERR_OK;
                        AppMethodBeat.o(66589);
                        return i;
                    }
                } catch (Exception e4) {
                    e = e4;
                    a = 0;
                    TXCLog.e(a, "hw audio decoder release error: " + a + ". error: " + e);
                    this.c = MediaCodec.createDecoderByType("audio/mp4a-latm");
                    if (VERSION.SDK_INT >= 21) {
                    }
                    if (this.c != null) {
                    }
                    i = TXEAudioDef.TXE_AUDIO_PLAY_ERR_OK;
                    AppMethodBeat.o(66589);
                    return i;
                }
            }
            try {
                this.c = MediaCodec.createDecoderByType("audio/mp4a-latm");
            } catch (IOException e5) {
                TXCLog.e(a, "createDecoderByType exception: " + e5.getMessage());
            }
            if (VERSION.SDK_INT >= 21) {
                i = 0;
                while (true) {
                    try {
                        this.c.configure(this.e, null, null, 0);
                        try {
                            this.c.start();
                            break;
                        } catch (CodecException e6) {
                            e2 = e6;
                            i2 = 1;
                        }
                    } catch (CodecException e7) {
                        e2 = e7;
                        i2 = 0;
                        TXCLog.e(a, "CodecException: " + e2 + ". step: " + i2 + ", mediaformat: " + this.e);
                        i++;
                        if (i > 1) {
                            TXCLog.e(a, "decoder start error!");
                            this.c.release();
                            this.c = null;
                            i = TXEAudioDef.TXE_AUDIO_PLAY_ERR_INVALID_STATE;
                            AppMethodBeat.o(66589);
                            return i;
                        } else if (e2.isRecoverable()) {
                            try {
                                this.c.stop();
                            } catch (Exception e8) {
                            }
                        } else if (e2.isTransient()) {
                            try {
                                Thread.sleep(20);
                            } catch (InterruptedException e9) {
                            }
                        } else {
                            TXCLog.e(a, "decoder cath unrecoverable error!");
                            this.c.release();
                            this.c = null;
                            i = TXEAudioDef.TXE_AUDIO_PLAY_ERR_INVALID_STATE;
                            AppMethodBeat.o(66589);
                            return i;
                        }
                    }
                }
            }
            i = 0;
            while (true) {
                try {
                    this.c.configure(this.e, null, null, 0);
                    try {
                        this.c.start();
                        break;
                    } catch (IllegalStateException e10) {
                        e2 = e10;
                        i2 = 1;
                    }
                } catch (IllegalStateException e11) {
                    e2 = e11;
                    i2 = 0;
                    TXCLog.e(a, "CodecException1: " + e2 + ". step: " + i2);
                    i++;
                    if (i > 1) {
                        TXCLog.e(a, "decoder start error!");
                        this.c.release();
                        this.c = null;
                        i = TXEAudioDef.TXE_AUDIO_PLAY_ERR_INVALID_STATE;
                        AppMethodBeat.o(66589);
                        return i;
                    }
                    try {
                        this.c.reset();
                    } catch (Exception e12) {
                    }
                }
            }
            if (this.c != null) {
                a(aVar, this.c.getInputBuffers(), this.c.dequeueInputBuffer(10000));
            }
            i = TXEAudioDef.TXE_AUDIO_PLAY_ERR_OK;
            AppMethodBeat.o(66589);
            return i;
        }
        i = TXEAudioDef.TXE_AUDIO_COMMON_ERR_INVALID_PARAMS;
        AppMethodBeat.o(66589);
        return i;
    }

    private int a(com.tencent.liteav.basic.g.a aVar, ByteBuffer[] byteBufferArr, int i) {
        ByteBuffer byteBuffer;
        AppMethodBeat.i(66590);
        if (i >= 0) {
            try {
                if (aVar.f != null) {
                    byteBuffer = byteBufferArr[i];
                    byteBuffer.clear();
                    byteBuffer.put(aVar.f);
                }
                if (aVar == null || aVar.f.length <= 0) {
                    this.c.queueInputBuffer(i, 0, 0, c(), 4);
                } else {
                    this.c.queueInputBuffer(i, 0, aVar.f.length, c(), 0);
                }
            } catch (Exception e) {
            }
        } else if (i == -1) {
            AppMethodBeat.o(66590);
            return -1;
        }
        ByteBuffer[] outputBuffers = this.c.getOutputBuffers();
        if (this.d == null) {
            this.d = new BufferInfo();
        }
        int dequeueOutputBuffer;
        do {
            ByteBuffer[] byteBufferArr2 = outputBuffers;
            dequeueOutputBuffer = this.c.dequeueOutputBuffer(this.d, 10000);
            if (dequeueOutputBuffer == -3) {
                outputBuffers = this.c.getOutputBuffers();
                continue;
            } else {
                c cVar;
                if (dequeueOutputBuffer == -2) {
                    this.e = this.c.getOutputFormat();
                    if (this.b != null) {
                        cVar = (c) this.b.get();
                        com.tencent.liteav.basic.g.a aVar2 = new com.tencent.liteav.basic.g.a();
                        aVar2.c = com.tencent.liteav.basic.a.a.h;
                        aVar2.b = this.e.getInteger("channel-count");
                        aVar2.a = this.e.getInteger("sample-rate");
                        if (cVar != null) {
                            cVar.onPlayAudioInfoChanged(aVar2, aVar2);
                        }
                        outputBuffers = byteBufferArr2;
                        continue;
                    }
                } else if (dequeueOutputBuffer >= 0) {
                    byteBuffer = byteBufferArr2[dequeueOutputBuffer];
                    byteBuffer.position(this.d.offset);
                    byteBuffer.limit(this.d.offset + this.d.size);
                    byte[] bArr = new byte[this.d.size];
                    byteBuffer.get(bArr);
                    long longValue = ((Long) this.i.get(0)).longValue();
                    this.i.remove(0);
                    if (this.b != null) {
                        cVar = (c) this.b.get();
                        if (cVar != null) {
                            cVar.onPlayPcmData(bArr, longValue);
                        }
                    }
                    this.c.releaseOutputBuffer(dequeueOutputBuffer, false);
                }
                outputBuffers = byteBufferArr2;
                continue;
            }
        } while (dequeueOutputBuffer >= 0);
        int i2 = TXEAudioDef.TXE_AUDIO_PLAY_ERR_OK;
        AppMethodBeat.o(66590);
        return i2;
    }

    private long c() {
        AppMethodBeat.i(66591);
        long timeTick = TXCTimeUtil.getTimeTick();
        if (timeTick < this.f) {
            timeTick += this.f - timeTick;
        }
        this.f = timeTick;
        AppMethodBeat.o(66591);
        return timeTick;
    }
}
