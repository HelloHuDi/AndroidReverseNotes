package com.tencent.mm.plugin.mmsight.model.a;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaCodecInfo;
import android.media.MediaCodecInfo.CodecCapabilities;
import android.media.MediaCodecInfo.CodecProfileLevel;
import android.media.MediaCodecList;
import android.media.MediaFormat;
import com.google.android.gms.common.Scopes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bj.b;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.mm.plugin.mmsight.model.a.f.a;
import com.tencent.mm.plugin.mmsight.model.k;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac;
import java.nio.ByteBuffer;

@TargetApi(16)
public class r implements f {
    private ByteBuffer[] aQJ;
    private int bitrate = 0;
    private boolean cFy = false;
    boolean cpc = false;
    private long eDL = 0;
    int eTi;
    int eTj;
    private int eTk;
    int eTl;
    private int eTm;
    private BufferInfo eTy;
    private boolean eVK = false;
    private final Object eVL = new Object();
    protected MediaCodec eVq;
    private int fXW = -1;
    private int fXX = -1;
    private boolean fXY = false;
    int frameCount;
    private int gLw;
    private int gLx;
    private ByteBuffer[] inputBuffers;
    protected MediaFormat mediaFormat;
    boolean ouL = false;
    private o ovV;
    private boolean ovW = true;
    int owS = -1;
    int owT = -1;
    int owU = -1;
    int owV = -1;
    a owW = new a(this.owY);
    a owX;
    private a.a owY = new a.a() {
        public final void output(byte[] bArr) {
            AppMethodBeat.i(76670);
            long yz = bo.yz();
            boolean bPL = r.this.owW.bPL();
            r rVar = r.this;
            boolean z = bPL && r.this.cpc;
            rVar.d(bArr, z);
            b.fXS.g(bArr);
            ab.i("MicroMsg.MMSightYUVMediaCodecRecorder", "markStop: %s isEnd %s costTime %d", Boolean.valueOf(r.this.cpc), Boolean.valueOf(bPL), Long.valueOf(bo.az(yz)));
            if (bPL && r.this.cpc) {
                r.this.bPX();
            }
            AppMethodBeat.o(76670);
        }
    };
    private long startTime = 0;

    public r(int i, int i2, int i3, int i4, int i5, int i6, int i7, boolean z) {
        AppMethodBeat.i(76672);
        this.gLw = i;
        this.gLx = i2;
        ab.i("MicroMsg.MMSightYUVMediaCodecRecorder", "create MMSightYUVMediaCodecRecorder, init targetWidth: %d, targetHeight: %d", Integer.valueOf(i3), Integer.valueOf(i4));
        ab.i("MicroMsg.MMSightYUVMediaCodecRecorder", "create MMSightYUVMediaCodecRecorder, after align 16, targetWidth: %d, targetHeight: %d", Integer.valueOf(i3), Integer.valueOf(i4));
        this.eTi = i3;
        this.eTj = i4;
        this.eTk = i7;
        this.eTm = i6;
        this.ovV = null;
        this.eTy = new BufferInfo();
        this.bitrate = i5;
        this.ouL = z;
        this.ovW = ((com.tencent.mm.plugin.expt.a.a) g.K(com.tencent.mm.plugin.expt.a.a.class)).a(com.tencent.mm.plugin.expt.a.a.a.clicfg_ignore_mediacodec_lock, true);
        ab.i("MicroMsg.MMSightYUVMediaCodecRecorder", "create BigSightMediaCodecYUVRecorder, frameWidth: %s, frameHeight: %s, targetWidth: %s, targetHeight: %s, bitrate: %s, needRotateEachFrame: %s, muxer: %s", Integer.valueOf(this.gLw), Integer.valueOf(this.gLx), Integer.valueOf(this.eTi), Integer.valueOf(this.eTj), Integer.valueOf(i5), Boolean.valueOf(z), null);
        AppMethodBeat.o(76672);
    }

    public final void start() {
        AppMethodBeat.i(76673);
        ab.i("MicroMsg.MMSightYUVMediaCodecRecorder", "Start");
        this.cFy = true;
        ab.i("MicroMsg.MMSightYUVMediaCodecRecorder", "Start：isStart：" + this.cFy);
        this.startTime = System.currentTimeMillis();
        AppMethodBeat.o(76673);
    }

    public int ew(int i, int i2) {
        int i3 = -1;
        AppMethodBeat.i(76674);
        try {
            this.owS = i2;
            i3 = alL();
            AppMethodBeat.o(76674);
        } catch (Exception e) {
            ab.e("MicroMsg.MMSightYUVMediaCodecRecorder", "init error: %s, try to re-init again", e.getMessage());
            try {
                if (CaptureMMProxy.getInstance() != null) {
                    CaptureMMProxy.getInstance().set(ac.a.USERINFO_MMSIGHT_MEDIACODEC_COLORFORMAT_INT, Integer.valueOf(-1));
                }
                i3 = alL();
                AppMethodBeat.o(76674);
            } catch (Exception e2) {
                ab.e("MicroMsg.MMSightYUVMediaCodecRecorder", "re-init again error: %s", e2.getMessage());
                k.bPA();
                AppMethodBeat.o(76674);
            }
        }
        return i3;
    }

    private int alL() {
        int i;
        int i2;
        MediaCodecInfo mediaCodecInfo;
        AppMethodBeat.i(76675);
        long yz = bo.yz();
        String str = "video/avc";
        int codecCount = MediaCodecList.getCodecCount();
        for (i = 0; i < codecCount; i++) {
            MediaCodecInfo codecInfoAt = MediaCodecList.getCodecInfoAt(i);
            if (codecInfoAt.isEncoder()) {
                String[] supportedTypes = codecInfoAt.getSupportedTypes();
                for (String equalsIgnoreCase : supportedTypes) {
                    if (equalsIgnoreCase.equalsIgnoreCase(str)) {
                        mediaCodecInfo = codecInfoAt;
                        break;
                    }
                }
                continue;
            }
        }
        mediaCodecInfo = null;
        if (mediaCodecInfo == null) {
            ab.e("MicroMsg.MMSightYUVMediaCodecRecorder", "Unable to find an appropriate codec for video/avc");
            k.bPA();
            AppMethodBeat.o(76675);
            return -1;
        }
        long yz2;
        int i3;
        ab.i("MicroMsg.MMSightYUVMediaCodecRecorder", "found codec: %s, used %sms", mediaCodecInfo.getName(), Long.valueOf(bo.az(yz)));
        yz = bo.yz();
        i2 = -1;
        if (CaptureMMProxy.getInstance() != null) {
            i2 = CaptureMMProxy.getInstance().getInt(ac.a.USERINFO_MMSIGHT_MEDIACODEC_COLORFORMAT_INT, -1);
        }
        ab.i("MicroMsg.MMSightYUVMediaCodecRecorder", "saveColorFormat: %s", Integer.valueOf(i2));
        if (i2 <= 0) {
            i2 = 0;
            yz2 = bo.yz();
            CodecCapabilities capabilitiesForType = mediaCodecInfo.getCapabilitiesForType("video/avc");
            ab.i("MicroMsg.MMSightYUVMediaCodecRecorder", "getCapabilitiesForType used %sms", Long.valueOf(bo.az(yz2)));
            ab.i("MicroMsg.MMSightYUVMediaCodecRecorder", "color format length: %s", Integer.valueOf(capabilitiesForType.colorFormats.length));
            for (int i4 : capabilitiesForType.colorFormats) {
                Object obj;
                ab.i("MicroMsg.MMSightYUVMediaCodecRecorder", "capabilities colorFormat: %s", Integer.valueOf(i4));
                switch (i4) {
                    case 19:
                    case 21:
                    case 2130706688:
                        obj = 1;
                        break;
                    default:
                        obj = null;
                        break;
                }
                if (obj != null && (i4 > i2 || i4 == 21)) {
                    i2 = i4;
                }
            }
            ab.i("MicroMsg.MMSightYUVMediaCodecRecorder", "codec: %s, colorFormat: %s", mediaCodecInfo.getName(), Integer.valueOf(i2));
        }
        this.eTl = i2;
        long az = bo.az(yz);
        if (this.eTl > 0 && az > 200 && CaptureMMProxy.getInstance() != null) {
            CaptureMMProxy.getInstance().set(ac.a.USERINFO_MMSIGHT_MEDIACODEC_COLORFORMAT_INT, Integer.valueOf(this.eTl));
        }
        ab.i("MicroMsg.MMSightYUVMediaCodecRecorder", "found colorFormat: %s, used %sms", Integer.valueOf(this.eTl), Long.valueOf(az));
        yz2 = bo.yz();
        ab.i("MicroMsg.MMSightYUVMediaCodecRecorder", "initRotate: %s", Integer.valueOf(this.owS));
        String str2;
        if (this.ouL) {
            str2 = "video/avc";
            i2 = (this.owS == 180 || this.owS == 0) ? this.eTi : this.eTj;
            i3 = (this.owS == 180 || this.owS == 0) ? this.eTj : this.eTi;
            this.mediaFormat = MediaFormat.createVideoFormat(str2, i2, i3);
        } else {
            str2 = "video/avc";
            i2 = (this.owS == 180 || this.owS == 0) ? this.eTj : this.eTi;
            i3 = (this.owS == 180 || this.owS == 0) ? this.eTi : this.eTj;
            this.mediaFormat = MediaFormat.createVideoFormat(str2, i2, i3);
        }
        ab.i("MicroMsg.MMSightYUVMediaCodecRecorder", "createVideoFormat used %sms", Long.valueOf(bo.az(yz2)));
        if (mediaCodecInfo != null) {
            if (d.iW(23)) {
                try {
                    CodecCapabilities capabilitiesForType2 = mediaCodecInfo.getCapabilitiesForType("video/avc");
                    if (capabilitiesForType2 != null) {
                        CodecProfileLevel[] codecProfileLevelArr = capabilitiesForType2.profileLevels;
                        if (codecProfileLevelArr != null) {
                            CodecProfileLevel codecProfileLevel = new CodecProfileLevel();
                            codecProfileLevel.level = 0;
                            codecProfileLevel.profile = 0;
                            for (CodecProfileLevel codecProfileLevel2 : codecProfileLevelArr) {
                                Object obj2;
                                int i5 = codecProfileLevel2.profile;
                                int i6 = codecProfileLevel2.level;
                                ab.i("MicroMsg.MMSightYUVMediaCodecRecorder", "profile: %s, level: %s", Integer.valueOf(i5), Integer.valueOf(i6));
                                switch (i5) {
                                    case 1:
                                    case 2:
                                    case 8:
                                        obj2 = 1;
                                        break;
                                    default:
                                        obj2 = null;
                                        break;
                                }
                                if (obj2 != null && i5 >= codecProfileLevel.profile && i6 >= codecProfileLevel.level) {
                                    codecProfileLevel.profile = i5;
                                    codecProfileLevel.level = i6;
                                }
                            }
                            ab.i("MicroMsg.MMSightYUVMediaCodecRecorder", "best profile: %s, level: %s", Integer.valueOf(codecProfileLevel.profile), Integer.valueOf(codecProfileLevel.level));
                            if (codecProfileLevel.profile > 0 && codecProfileLevel.level >= 256) {
                                this.mediaFormat.setInteger(Scopes.PROFILE, codecProfileLevel.profile);
                                this.mediaFormat.setInteger("level", 256);
                            }
                        }
                    }
                } catch (Exception e) {
                    ab.e("MicroMsg.MMSightYUVMediaCodecRecorder", "trySetProfile error: %s", e.getMessage());
                }
            }
            try {
                if (d.iW(21)) {
                    this.mediaFormat.setInteger("bitrate-mode", 1);
                }
            } catch (Exception e2) {
                ab.e("MicroMsg.MMSightYUVMediaCodecRecorder", "trySetBitRateMode error: %s", e2.getMessage());
            }
        }
        this.mediaFormat.setInteger(FFmpegMetadataRetriever.METADATA_KEY_VARIANT_BITRATE, this.bitrate);
        this.mediaFormat.setInteger("frame-rate", this.eTk);
        this.mediaFormat.setInteger("color-format", this.eTl);
        this.mediaFormat.setInteger("i-frame-interval", this.eTm);
        ab.i("MicroMsg.MMSightYUVMediaCodecRecorder", "mediaFormat: %s", this.mediaFormat);
        this.eVq = MediaCodec.createByCodecName(mediaCodecInfo.getName());
        this.eVq.configure(this.mediaFormat, null, null, 1);
        this.eVq.start();
        if (this.ovW) {
            AppMethodBeat.o(76675);
            return 0;
        }
        synchronized (this.eVL) {
            try {
                this.eVK = false;
            } finally {
                while (true) {
                    AppMethodBeat.o(76675);
                }
            }
        }
        return 0;
    }

    public final void d(byte[] bArr, boolean z) {
        AppMethodBeat.i(76678);
        if (!this.ovW) {
            synchronized (this.eVL) {
                try {
                    if (this.eVK) {
                    }
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.o(76678);
                }
            }
        }
        try {
            if (!this.cFy) {
                ab.e("MicroMsg.MMSightYUVMediaCodecRecorder", "writeData, not start!");
                AppMethodBeat.o(76678);
            } else if (this.eVq == null) {
                ab.e("MicroMsg.MMSightYUVMediaCodecRecorder", "encoder is null");
                AppMethodBeat.o(76678);
            } else {
                if (this.ovV != null && this.ovV.owQ <= 0) {
                    this.ovV.owQ = System.nanoTime();
                }
                long yz = bo.yz();
                this.inputBuffers = this.eVq.getInputBuffers();
                this.aQJ = this.eVq.getOutputBuffers();
                int dequeueInputBuffer = this.eVq.dequeueInputBuffer(100);
                this.fXW = dequeueInputBuffer;
                if (dequeueInputBuffer < 0) {
                    ab.i("MicroMsg.MMSightYUVMediaCodecRecorder", "video no input available, drain first");
                    UR();
                }
                if (this.eVq == null) {
                    ab.e("MicroMsg.MMSightYUVMediaCodecRecorder", "encoder is null");
                    AppMethodBeat.o(76678);
                    return;
                }
                ab.v("MicroMsg.MMSightYUVMediaCodecRecorder", "inputBufferIndex: %s", Integer.valueOf(this.fXW));
                long yz2 = bo.yz();
                if (this.fXW >= 0) {
                    long j;
                    long nanoTime = System.nanoTime() - ((long) ((bArr.length / 1600000) / 1000000000));
                    if (this.ovV != null) {
                        j = this.ovV.owQ;
                    } else {
                        j = this.startTime;
                    }
                    long j2 = (nanoTime - j) / 1000;
                    ab.v("MicroMsg.MMSightYUVMediaCodecRecorder", "presentationTime: ".concat(String.valueOf(j2)));
                    ByteBuffer byteBuffer = this.inputBuffers[this.fXW];
                    byteBuffer.clear();
                    byteBuffer.put(bArr);
                    byteBuffer.position(0);
                    if (!this.cFy || z) {
                        ab.v("MicroMsg.MMSightYUVMediaCodecRecorder", "end of stream");
                        this.fXY = true;
                        this.eVq.queueInputBuffer(this.fXW, 0, bArr.length, j2, 4);
                    } else {
                        this.eVq.queueInputBuffer(this.fXW, 0, bArr.length, j2, 0);
                    }
                } else {
                    ab.v("MicroMsg.MMSightYUVMediaCodecRecorder", "input buffer not available");
                }
                UR();
                ab.v("MicroMsg.MMSightYUVMediaCodecRecorder", "encoder used %sms %sms", Long.valueOf(bo.az(yz)), Long.valueOf(bo.az(yz2)));
                AppMethodBeat.o(76678);
            }
        } catch (Exception e) {
            k.bPB();
            ab.e("MicroMsg.MMSightYUVMediaCodecRecorder", "writeData error: %s", e.getMessage());
            ab.printErrStackTrace("MicroMsg.MMSightYUVMediaCodecRecorder", e, "", new Object[0]);
            AppMethodBeat.o(76678);
        }
    }

    private void UR() {
        AppMethodBeat.i(76679);
        this.fXX = this.eVq.dequeueOutputBuffer(this.eTy, 100);
        ab.v("MicroMsg.MMSightYUVMediaCodecRecorder", "outputBufferIndex-->" + this.fXX);
        while (true) {
            if (this.fXX == -1) {
                ab.d("MicroMsg.MMSightYUVMediaCodecRecorder", "no output from encoder available, break encoderEndStream %s", Boolean.valueOf(this.fXY));
                if (!this.fXY) {
                    break;
                }
            } else if (this.fXX == -3) {
                this.aQJ = this.eVq.getOutputBuffers();
                ab.d("MicroMsg.MMSightYUVMediaCodecRecorder", "encoder output buffers changed");
            } else if (this.fXX == -2) {
                MediaFormat outputFormat = this.eVq.getOutputFormat();
                ab.d("MicroMsg.MMSightYUVMediaCodecRecorder", "encoder output format changed: ".concat(String.valueOf(outputFormat)));
                if (this.ovV != null) {
                    this.ovV.d(outputFormat);
                }
            } else if (this.fXX < 0) {
                ab.w("MicroMsg.MMSightYUVMediaCodecRecorder", "unexpected result from encoder.dequeueOutputBuffer: " + this.fXX);
            } else {
                ab.v("MicroMsg.MMSightYUVMediaCodecRecorder", "perform encoding");
                ByteBuffer byteBuffer = this.aQJ[this.fXX];
                if (byteBuffer == null) {
                    RuntimeException runtimeException = new RuntimeException("encoderOutputBuffer " + this.fXX + " was null");
                    AppMethodBeat.o(76679);
                    throw runtimeException;
                }
                this.frameCount++;
                if ((this.eTy.flags & 2) != 0) {
                    ab.v("MicroMsg.MMSightYUVMediaCodecRecorder", "ignoring BUFFER_FLAG_CODEC_CONFIG, size: %s, %s", Integer.valueOf(this.eTy.size), Boolean.FALSE);
                }
                if (this.eTy.size != 0) {
                    if (!(this.ovV == null || this.ovV.cFy)) {
                        this.ovV.d(this.eVq.getOutputFormat());
                    }
                    byteBuffer.position(this.eTy.offset);
                    byteBuffer.limit(this.eTy.offset + this.eTy.size);
                    g(byteBuffer, this.eTy);
                }
                this.eVq.releaseOutputBuffer(this.fXX, false);
                if ((this.eTy.flags & 4) != 0) {
                    if (this.cpc) {
                        ab.w("MicroMsg.MMSightYUVMediaCodecRecorder", "do stop encoder");
                        UO();
                        if (this.owX != null) {
                            this.owX.bPP();
                            this.owX = null;
                            AppMethodBeat.o(76679);
                            return;
                        }
                    } else {
                        ab.e("MicroMsg.MMSightYUVMediaCodecRecorder", "reached end of stream unexpectedly");
                        AppMethodBeat.o(76679);
                        return;
                    }
                }
            }
            this.fXX = this.eVq.dequeueOutputBuffer(this.eTy, 100);
            if (this.fXX <= 0) {
                ab.v("MicroMsg.MMSightYUVMediaCodecRecorder", "get outputBufferIndex %d", Integer.valueOf(this.fXX));
            }
            if (this.fXX < 0 && !this.fXY) {
                break;
            }
        }
        AppMethodBeat.o(76679);
    }

    /* Access modifiers changed, original: protected */
    public void g(ByteBuffer byteBuffer, BufferInfo bufferInfo) {
        AppMethodBeat.i(76680);
        if (this.ovV != null && (bufferInfo.flags & 4) == 0) {
            o oVar = this.ovV;
            try {
                if (!(oVar.owN == null || oVar.owO == -1 || !oVar.cFy)) {
                    int i;
                    int i2 = byteBuffer != null ? 1 : 0;
                    if (bufferInfo != null) {
                        i = 1;
                    } else {
                        i = 0;
                    }
                    if ((i & i2) != 0) {
                        long j = bufferInfo.presentationTimeUs;
                        bufferInfo.presentationTimeUs = (System.nanoTime() - oVar.owQ) / 1000;
                        bufferInfo.flags = 1;
                        long yz = bo.yz();
                        oVar.owN.writeSampleData(oVar.owO, byteBuffer, bufferInfo);
                        ab.v("MicroMsg.MMSightSystemMediaMuxer", "writeAACSampleData size: %s used %dms oldpts %s fix pts: %s", Integer.valueOf(bufferInfo.size), Long.valueOf(bo.az(yz)), Long.valueOf(j), Long.valueOf(bufferInfo.presentationTimeUs));
                    }
                }
                AppMethodBeat.o(76680);
                return;
            } catch (Exception e) {
                ab.e("MicroMsg.MMSightSystemMediaMuxer", "writeX264SampleData error: %s", e.getMessage());
            }
        }
        AppMethodBeat.o(76680);
    }

    public final void a(a aVar) {
        AppMethodBeat.i(76681);
        this.owX = aVar;
        this.cpc = true;
        ab.i("MicroMsg.MMSightYUVMediaCodecRecorder", "!!!stop, isStart!!: %s %s isEnd %s", Boolean.valueOf(this.cFy), this.owX, Boolean.valueOf(this.owW.bPL()));
        if (this.owW.bPL()) {
            bPX();
        }
        AppMethodBeat.o(76681);
    }

    /* Access modifiers changed, original: final */
    public final void bPX() {
        AppMethodBeat.i(76682);
        ab.i("MicroMsg.MMSightYUVMediaCodecRecorder", "stopImp %s  isStart:%b", bo.dpG().toString(), Boolean.valueOf(this.cFy));
        try {
            if (this.cFy) {
                al.n(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(76671);
                        r.a(r.this);
                        if (r.this.owX != null) {
                            r.this.owX.bPP();
                            r.this.owX = null;
                        }
                        AppMethodBeat.o(76671);
                    }
                }, 500);
            }
            AppMethodBeat.o(76682);
        } catch (Exception e) {
            ab.e("MicroMsg.MMSightYUVMediaCodecRecorder", "stop error: %s", e.getMessage());
            AppMethodBeat.o(76682);
        }
    }

    public final long UQ() {
        AppMethodBeat.i(76683);
        if (this.startTime <= 0) {
            ab.w("MicroMsg.MMSightYUVMediaCodecRecorder", "do not start record");
            AppMethodBeat.o(76683);
            return 0;
        }
        long currentTimeMillis = System.currentTimeMillis() - this.startTime;
        AppMethodBeat.o(76683);
        return currentTimeMillis;
    }

    public void clear() {
        AppMethodBeat.i(76684);
        ab.i("MicroMsg.MMSightYUVMediaCodecRecorder", "clear");
        UO();
        AppMethodBeat.o(76684);
    }

    private void UO() {
        AppMethodBeat.i(138320);
        if (this.ovW) {
            bPY();
            AppMethodBeat.o(138320);
            return;
        }
        synchronized (this.eVL) {
            try {
                if (this.eVK || 0 == this.startTime) {
                } else {
                    this.eVK = true;
                    bPY();
                    AppMethodBeat.o(138320);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(138320);
            }
        }
    }

    private void bPY() {
        AppMethodBeat.i(138321);
        try {
            if (this.owW != null) {
                this.owW.stop();
            }
            if (this.eVq != null) {
                ab.i("MicroMsg.MMSightYUVMediaCodecRecorder", "stop encoder");
                this.eVq.stop();
                this.eVq.release();
                this.cFy = false;
                this.eVq = null;
            }
            AppMethodBeat.o(138321);
        } catch (Exception e) {
            ab.e("MicroMsg.MMSightYUVMediaCodecRecorder", "clear error: %s", e.getMessage());
            AppMethodBeat.o(138321);
        }
    }
}
