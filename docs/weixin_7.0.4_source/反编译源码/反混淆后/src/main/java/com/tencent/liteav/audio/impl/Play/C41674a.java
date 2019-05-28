package com.tencent.liteav.audio.impl.Play;

import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaCodec.CodecException;
import android.media.MediaFormat;
import android.os.Build.VERSION;
import com.tencent.liteav.audio.C8791c;
import com.tencent.liteav.audio.TXEAudioDef;
import com.tencent.liteav.audio.impl.C17769b;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.p1587a.C41678a;
import com.tencent.liteav.basic.p811g.C25648a;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/* renamed from: com.tencent.liteav.audio.impl.Play.a */
public class C41674a implements Runnable {
    /* renamed from: a */
    private static final String f16890a = ("AudioCenter:" + C41674a.class.getSimpleName());
    /* renamed from: b */
    private WeakReference<C8791c> f16891b = null;
    /* renamed from: c */
    private MediaCodec f16892c = null;
    /* renamed from: d */
    private BufferInfo f16893d;
    /* renamed from: e */
    private MediaFormat f16894e;
    /* renamed from: f */
    private long f16895f = 0;
    /* renamed from: g */
    private volatile boolean f16896g = false;
    /* renamed from: h */
    private Vector<C25648a> f16897h;
    /* renamed from: i */
    private List f16898i;
    /* renamed from: j */
    private Thread f16899j = null;

    static {
        AppMethodBeat.m2504i(66592);
        AppMethodBeat.m2505o(66592);
    }

    /* renamed from: a */
    public void mo67218a(WeakReference<C8791c> weakReference) {
        AppMethodBeat.m2504i(66584);
        if (this.f16896g) {
            mo67219b();
        }
        this.f16891b = weakReference;
        this.f16895f = 0;
        this.f16897h = new Vector();
        this.f16898i = new ArrayList();
        this.f16896g = true;
        this.f16899j = new Thread(this);
        this.f16899j.setName(f16890a);
        this.f16899j.start();
        AppMethodBeat.m2505o(66584);
    }

    /* renamed from: a */
    public void mo67217a(C25648a c25648a) {
        AppMethodBeat.m2504i(66585);
        if (this.f16896g) {
            synchronized (this.f16897h) {
                try {
                    if (this.f16897h != null) {
                        this.f16897h.add(c25648a);
                    }
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.m2505o(66585);
                }
            }
            return;
        }
        AppMethodBeat.m2505o(66585);
    }

    /* renamed from: a */
    public long mo67216a() {
        AppMethodBeat.m2504i(66586);
        if (this.f16894e != null) {
            float integer = (float) this.f16894e.getInteger("sample-rate");
            if (integer != 0.0f) {
                long size = (long) (((((float) this.f16898i.size()) * 1024.0f) * 1000.0f) / integer);
                AppMethodBeat.m2505o(66586);
                return size;
            }
            AppMethodBeat.m2505o(66586);
            return 0;
        }
        AppMethodBeat.m2505o(66586);
        return 0;
    }

    /* renamed from: b */
    public void mo67219b() {
        AppMethodBeat.m2504i(66587);
        this.f16896g = false;
        if (this.f16899j != null) {
            try {
                this.f16899j.join();
            } catch (InterruptedException e) {
            }
            this.f16899j = null;
        }
        AppMethodBeat.m2505o(66587);
    }

    public void run() {
        int i;
        Object e;
        AppMethodBeat.m2504i(66588);
        while (this.f16896g) {
            boolean isEmpty;
            synchronized (this.f16897h) {
                try {
                    isEmpty = this.f16897h.isEmpty();
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.m2505o(66588);
                }
            }
            if (isEmpty) {
                try {
                    Thread.sleep(10);
                } catch (Exception e2) {
                }
            } else {
                ByteBuffer[] inputBuffers;
                C25648a c25648a;
                if (this.f16892c != null) {
                    try {
                        inputBuffers = this.f16892c.getInputBuffers();
                        i = 1;
                        try {
                            int dequeueInputBuffer = this.f16892c.dequeueInputBuffer(10000);
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
                        TXCLog.m15676e(f16890a, "Exception. step: " + i + ", error: " + e);
                        AppMethodBeat.m2505o(66588);
                        return;
                    }
                }
                i = -1;
                inputBuffers = null;
                synchronized (this.f16897h) {
                    try {
                        c25648a = (C25648a) this.f16897h.remove(0);
                    } catch (Throwable th) {
                        while (true) {
                            AppMethodBeat.m2505o(66588);
                        }
                    }
                }
                if (c25648a.f5248d == C41678a.f16929k) {
                    m73078b(c25648a);
                } else if (c25648a.f5248d == C41678a.f16930l) {
                    this.f16898i.add(Long.valueOf(c25648a.f5249e));
                    m73077a(c25648a, inputBuffers, i);
                } else {
                    TXCLog.m15676e(f16890a, "not support audio format");
                }
            }
        }
        if (this.f16892c != null) {
            this.f16892c.stop();
            this.f16892c.release();
            this.f16892c = null;
        }
        AppMethodBeat.m2505o(66588);
    }

    /* JADX WARNING: Removed duplicated region for block: B:55:0x01a6  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x00be  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00d2  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x00be  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x01a6  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00d2  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: b */
    private int m73078b(C25648a c25648a) {
        Object e;
        int i;
        Object e2;
        AppMethodBeat.m2504i(66589);
        if (c25648a.f5250f.length != 2) {
            TXCLog.m15679w(f16890a, "aac seq header len not equal to 2 , with len " + c25648a.f5250f.length);
        }
        if (c25648a.f5250f != null) {
            int a = C17769b.m27677a(((c25648a.f5250f[0] & 7) << 1) | ((c25648a.f5250f[1] & 128) >> 7));
            int i2 = (c25648a.f5250f[1] & 120) >> 3;
            this.f16894e = MediaFormat.createAudioFormat("audio/mp4a-latm", a, i2);
            this.f16894e.setInteger(FFmpegMetadataRetriever.METADATA_KEY_VARIANT_BITRATE, 64000);
            this.f16894e.setInteger("is-adts", 0);
            this.f16894e.setInteger("aac-profile", 2);
            TXCLog.m15677i(f16890a, "audio decoder media format: " + this.f16894e);
            if (this.f16891b != null) {
                C8791c c8791c = (C8791c) this.f16891b.get();
                C25648a c25648a2 = new C25648a();
                c25648a2.f5247c = C41678a.f16926h;
                c25648a2.f5246b = i2;
                c25648a2.f5245a = a;
                if (c8791c != null) {
                    c8791c.onPlayAudioInfoChanged(c25648a2, c25648a2);
                }
            }
            if (this.f16892c != null) {
                try {
                    this.f16892c.stop();
                    try {
                        this.f16892c.release();
                    } catch (Exception e3) {
                        e = e3;
                        a = 1;
                        TXCLog.m15676e(f16890a, "hw audio decoder release error: " + a + ". error: " + e);
                        this.f16892c = MediaCodec.createDecoderByType("audio/mp4a-latm");
                        if (VERSION.SDK_INT >= 21) {
                        }
                        if (this.f16892c != null) {
                        }
                        i = TXEAudioDef.TXE_AUDIO_PLAY_ERR_OK;
                        AppMethodBeat.m2505o(66589);
                        return i;
                    }
                } catch (Exception e4) {
                    e = e4;
                    a = 0;
                    TXCLog.m15676e(f16890a, "hw audio decoder release error: " + a + ". error: " + e);
                    this.f16892c = MediaCodec.createDecoderByType("audio/mp4a-latm");
                    if (VERSION.SDK_INT >= 21) {
                    }
                    if (this.f16892c != null) {
                    }
                    i = TXEAudioDef.TXE_AUDIO_PLAY_ERR_OK;
                    AppMethodBeat.m2505o(66589);
                    return i;
                }
            }
            try {
                this.f16892c = MediaCodec.createDecoderByType("audio/mp4a-latm");
            } catch (IOException e5) {
                TXCLog.m15676e(f16890a, "createDecoderByType exception: " + e5.getMessage());
            }
            if (VERSION.SDK_INT >= 21) {
                i = 0;
                while (true) {
                    try {
                        this.f16892c.configure(this.f16894e, null, null, 0);
                        try {
                            this.f16892c.start();
                            break;
                        } catch (CodecException e6) {
                            e2 = e6;
                            i2 = 1;
                        }
                    } catch (CodecException e7) {
                        e2 = e7;
                        i2 = 0;
                        TXCLog.m15676e(f16890a, "CodecException: " + e2 + ". step: " + i2 + ", mediaformat: " + this.f16894e);
                        i++;
                        if (i > 1) {
                            TXCLog.m15676e(f16890a, "decoder start error!");
                            this.f16892c.release();
                            this.f16892c = null;
                            i = TXEAudioDef.TXE_AUDIO_PLAY_ERR_INVALID_STATE;
                            AppMethodBeat.m2505o(66589);
                            return i;
                        } else if (e2.isRecoverable()) {
                            try {
                                this.f16892c.stop();
                            } catch (Exception e8) {
                            }
                        } else if (e2.isTransient()) {
                            try {
                                Thread.sleep(20);
                            } catch (InterruptedException e9) {
                            }
                        } else {
                            TXCLog.m15676e(f16890a, "decoder cath unrecoverable error!");
                            this.f16892c.release();
                            this.f16892c = null;
                            i = TXEAudioDef.TXE_AUDIO_PLAY_ERR_INVALID_STATE;
                            AppMethodBeat.m2505o(66589);
                            return i;
                        }
                    }
                }
            }
            i = 0;
            while (true) {
                try {
                    this.f16892c.configure(this.f16894e, null, null, 0);
                    try {
                        this.f16892c.start();
                        break;
                    } catch (IllegalStateException e10) {
                        e2 = e10;
                        i2 = 1;
                    }
                } catch (IllegalStateException e11) {
                    e2 = e11;
                    i2 = 0;
                    TXCLog.m15676e(f16890a, "CodecException1: " + e2 + ". step: " + i2);
                    i++;
                    if (i > 1) {
                        TXCLog.m15676e(f16890a, "decoder start error!");
                        this.f16892c.release();
                        this.f16892c = null;
                        i = TXEAudioDef.TXE_AUDIO_PLAY_ERR_INVALID_STATE;
                        AppMethodBeat.m2505o(66589);
                        return i;
                    }
                    try {
                        this.f16892c.reset();
                    } catch (Exception e12) {
                    }
                }
            }
            if (this.f16892c != null) {
                m73077a(c25648a, this.f16892c.getInputBuffers(), this.f16892c.dequeueInputBuffer(10000));
            }
            i = TXEAudioDef.TXE_AUDIO_PLAY_ERR_OK;
            AppMethodBeat.m2505o(66589);
            return i;
        }
        i = TXEAudioDef.TXE_AUDIO_COMMON_ERR_INVALID_PARAMS;
        AppMethodBeat.m2505o(66589);
        return i;
    }

    /* renamed from: a */
    private int m73077a(C25648a c25648a, ByteBuffer[] byteBufferArr, int i) {
        ByteBuffer byteBuffer;
        AppMethodBeat.m2504i(66590);
        if (i >= 0) {
            try {
                if (c25648a.f5250f != null) {
                    byteBuffer = byteBufferArr[i];
                    byteBuffer.clear();
                    byteBuffer.put(c25648a.f5250f);
                }
                if (c25648a == null || c25648a.f5250f.length <= 0) {
                    this.f16892c.queueInputBuffer(i, 0, 0, m73079c(), 4);
                } else {
                    this.f16892c.queueInputBuffer(i, 0, c25648a.f5250f.length, m73079c(), 0);
                }
            } catch (Exception e) {
            }
        } else if (i == -1) {
            AppMethodBeat.m2505o(66590);
            return -1;
        }
        ByteBuffer[] outputBuffers = this.f16892c.getOutputBuffers();
        if (this.f16893d == null) {
            this.f16893d = new BufferInfo();
        }
        int dequeueOutputBuffer;
        do {
            ByteBuffer[] byteBufferArr2 = outputBuffers;
            dequeueOutputBuffer = this.f16892c.dequeueOutputBuffer(this.f16893d, 10000);
            if (dequeueOutputBuffer == -3) {
                outputBuffers = this.f16892c.getOutputBuffers();
                continue;
            } else {
                C8791c c8791c;
                if (dequeueOutputBuffer == -2) {
                    this.f16894e = this.f16892c.getOutputFormat();
                    if (this.f16891b != null) {
                        c8791c = (C8791c) this.f16891b.get();
                        C25648a c25648a2 = new C25648a();
                        c25648a2.f5247c = C41678a.f16926h;
                        c25648a2.f5246b = this.f16894e.getInteger("channel-count");
                        c25648a2.f5245a = this.f16894e.getInteger("sample-rate");
                        if (c8791c != null) {
                            c8791c.onPlayAudioInfoChanged(c25648a2, c25648a2);
                        }
                        outputBuffers = byteBufferArr2;
                        continue;
                    }
                } else if (dequeueOutputBuffer >= 0) {
                    byteBuffer = byteBufferArr2[dequeueOutputBuffer];
                    byteBuffer.position(this.f16893d.offset);
                    byteBuffer.limit(this.f16893d.offset + this.f16893d.size);
                    byte[] bArr = new byte[this.f16893d.size];
                    byteBuffer.get(bArr);
                    long longValue = ((Long) this.f16898i.get(0)).longValue();
                    this.f16898i.remove(0);
                    if (this.f16891b != null) {
                        c8791c = (C8791c) this.f16891b.get();
                        if (c8791c != null) {
                            c8791c.onPlayPcmData(bArr, longValue);
                        }
                    }
                    this.f16892c.releaseOutputBuffer(dequeueOutputBuffer, false);
                }
                outputBuffers = byteBufferArr2;
                continue;
            }
        } while (dequeueOutputBuffer >= 0);
        int i2 = TXEAudioDef.TXE_AUDIO_PLAY_ERR_OK;
        AppMethodBeat.m2505o(66590);
        return i2;
    }

    /* renamed from: c */
    private long m73079c() {
        AppMethodBeat.m2504i(66591);
        long timeTick = TXCTimeUtil.getTimeTick();
        if (timeTick < this.f16895f) {
            timeTick += this.f16895f - timeTick;
        }
        this.f16895f = timeTick;
        AppMethodBeat.m2505o(66591);
        return timeTick;
    }
}
