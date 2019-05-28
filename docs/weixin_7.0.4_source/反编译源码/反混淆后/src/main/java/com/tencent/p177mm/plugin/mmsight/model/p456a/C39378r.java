package com.tencent.p177mm.plugin.mmsight.model.p456a;

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
import com.tencent.p177mm.compatible.util.C1443d;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p838bj.C41791b;
import com.tencent.p177mm.plugin.expt.p394a.C34069a;
import com.tencent.p177mm.plugin.expt.p394a.C34069a.C11745a;
import com.tencent.p177mm.plugin.mmsight.model.C34549k;
import com.tencent.p177mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.p177mm.plugin.mmsight.model.p456a.C21292f.C21293a;
import com.tencent.p177mm.plugin.mmsight.model.p456a.C46075a.C43301a;
import com.tencent.p177mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import java.nio.ByteBuffer;

@TargetApi(16)
/* renamed from: com.tencent.mm.plugin.mmsight.model.a.r */
public class C39378r implements C21292f {
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
    private C34545o ovV;
    private boolean ovW = true;
    int owS = -1;
    int owT = -1;
    int owU = -1;
    int owV = -1;
    C46075a owW = new C46075a(this.owY);
    C21293a owX;
    private C43301a owY = new C393791();
    private long startTime = 0;

    /* renamed from: com.tencent.mm.plugin.mmsight.model.a.r$2 */
    class C125562 implements Runnable {
        C125562() {
        }

        public final void run() {
            AppMethodBeat.m2504i(76671);
            C39378r.m67161a(C39378r.this);
            if (C39378r.this.owX != null) {
                C39378r.this.owX.bPP();
                C39378r.this.owX = null;
            }
            AppMethodBeat.m2505o(76671);
        }
    }

    /* renamed from: com.tencent.mm.plugin.mmsight.model.a.r$1 */
    class C393791 implements C43301a {
        C393791() {
        }

        public final void output(byte[] bArr) {
            AppMethodBeat.m2504i(76670);
            long yz = C5046bo.m7588yz();
            boolean bPL = C39378r.this.owW.bPL();
            C39378r c39378r = C39378r.this;
            boolean z = bPL && C39378r.this.cpc;
            c39378r.mo62273d(bArr, z);
            C41791b.fXS.mo67542g(bArr);
            C4990ab.m7417i("MicroMsg.MMSightYUVMediaCodecRecorder", "markStop: %s isEnd %s costTime %d", Boolean.valueOf(C39378r.this.cpc), Boolean.valueOf(bPL), Long.valueOf(C5046bo.m7525az(yz)));
            if (bPL && C39378r.this.cpc) {
                C39378r.this.bPX();
            }
            AppMethodBeat.m2505o(76670);
        }
    }

    public C39378r(int i, int i2, int i3, int i4, int i5, int i6, int i7, boolean z) {
        AppMethodBeat.m2504i(76672);
        this.gLw = i;
        this.gLx = i2;
        C4990ab.m7417i("MicroMsg.MMSightYUVMediaCodecRecorder", "create MMSightYUVMediaCodecRecorder, init targetWidth: %d, targetHeight: %d", Integer.valueOf(i3), Integer.valueOf(i4));
        C4990ab.m7417i("MicroMsg.MMSightYUVMediaCodecRecorder", "create MMSightYUVMediaCodecRecorder, after align 16, targetWidth: %d, targetHeight: %d", Integer.valueOf(i3), Integer.valueOf(i4));
        this.eTi = i3;
        this.eTj = i4;
        this.eTk = i7;
        this.eTm = i6;
        this.ovV = null;
        this.eTy = new BufferInfo();
        this.bitrate = i5;
        this.ouL = z;
        this.ovW = ((C34069a) C1720g.m3528K(C34069a.class)).mo54614a(C11745a.clicfg_ignore_mediacodec_lock, true);
        C4990ab.m7417i("MicroMsg.MMSightYUVMediaCodecRecorder", "create BigSightMediaCodecYUVRecorder, frameWidth: %s, frameHeight: %s, targetWidth: %s, targetHeight: %s, bitrate: %s, needRotateEachFrame: %s, muxer: %s", Integer.valueOf(this.gLw), Integer.valueOf(this.gLx), Integer.valueOf(this.eTi), Integer.valueOf(this.eTj), Integer.valueOf(i5), Boolean.valueOf(z), null);
        AppMethodBeat.m2505o(76672);
    }

    public final void start() {
        AppMethodBeat.m2504i(76673);
        C4990ab.m7416i("MicroMsg.MMSightYUVMediaCodecRecorder", "Start");
        this.cFy = true;
        C4990ab.m7416i("MicroMsg.MMSightYUVMediaCodecRecorder", "Start：isStart：" + this.cFy);
        this.startTime = System.currentTimeMillis();
        AppMethodBeat.m2505o(76673);
    }

    /* renamed from: ew */
    public int mo46466ew(int i, int i2) {
        int i3 = -1;
        AppMethodBeat.m2504i(76674);
        try {
            this.owS = i2;
            i3 = alL();
            AppMethodBeat.m2505o(76674);
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.MMSightYUVMediaCodecRecorder", "init error: %s, try to re-init again", e.getMessage());
            try {
                if (CaptureMMProxy.getInstance() != null) {
                    CaptureMMProxy.getInstance().set(C5127a.USERINFO_MMSIGHT_MEDIACODEC_COLORFORMAT_INT, Integer.valueOf(-1));
                }
                i3 = alL();
                AppMethodBeat.m2505o(76674);
            } catch (Exception e2) {
                C4990ab.m7413e("MicroMsg.MMSightYUVMediaCodecRecorder", "re-init again error: %s", e2.getMessage());
                C34549k.bPA();
                AppMethodBeat.m2505o(76674);
            }
        }
        return i3;
    }

    private int alL() {
        int i;
        int i2;
        MediaCodecInfo mediaCodecInfo;
        AppMethodBeat.m2504i(76675);
        long yz = C5046bo.m7588yz();
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
            C4990ab.m7412e("MicroMsg.MMSightYUVMediaCodecRecorder", "Unable to find an appropriate codec for video/avc");
            C34549k.bPA();
            AppMethodBeat.m2505o(76675);
            return -1;
        }
        long yz2;
        int i3;
        C4990ab.m7417i("MicroMsg.MMSightYUVMediaCodecRecorder", "found codec: %s, used %sms", mediaCodecInfo.getName(), Long.valueOf(C5046bo.m7525az(yz)));
        yz = C5046bo.m7588yz();
        i2 = -1;
        if (CaptureMMProxy.getInstance() != null) {
            i2 = CaptureMMProxy.getInstance().getInt(C5127a.USERINFO_MMSIGHT_MEDIACODEC_COLORFORMAT_INT, -1);
        }
        C4990ab.m7417i("MicroMsg.MMSightYUVMediaCodecRecorder", "saveColorFormat: %s", Integer.valueOf(i2));
        if (i2 <= 0) {
            i2 = 0;
            yz2 = C5046bo.m7588yz();
            CodecCapabilities capabilitiesForType = mediaCodecInfo.getCapabilitiesForType("video/avc");
            C4990ab.m7417i("MicroMsg.MMSightYUVMediaCodecRecorder", "getCapabilitiesForType used %sms", Long.valueOf(C5046bo.m7525az(yz2)));
            C4990ab.m7417i("MicroMsg.MMSightYUVMediaCodecRecorder", "color format length: %s", Integer.valueOf(capabilitiesForType.colorFormats.length));
            for (int i4 : capabilitiesForType.colorFormats) {
                Object obj;
                C4990ab.m7417i("MicroMsg.MMSightYUVMediaCodecRecorder", "capabilities colorFormat: %s", Integer.valueOf(i4));
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
            C4990ab.m7417i("MicroMsg.MMSightYUVMediaCodecRecorder", "codec: %s, colorFormat: %s", mediaCodecInfo.getName(), Integer.valueOf(i2));
        }
        this.eTl = i2;
        long az = C5046bo.m7525az(yz);
        if (this.eTl > 0 && az > 200 && CaptureMMProxy.getInstance() != null) {
            CaptureMMProxy.getInstance().set(C5127a.USERINFO_MMSIGHT_MEDIACODEC_COLORFORMAT_INT, Integer.valueOf(this.eTl));
        }
        C4990ab.m7417i("MicroMsg.MMSightYUVMediaCodecRecorder", "found colorFormat: %s, used %sms", Integer.valueOf(this.eTl), Long.valueOf(az));
        yz2 = C5046bo.m7588yz();
        C4990ab.m7417i("MicroMsg.MMSightYUVMediaCodecRecorder", "initRotate: %s", Integer.valueOf(this.owS));
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
        C4990ab.m7417i("MicroMsg.MMSightYUVMediaCodecRecorder", "createVideoFormat used %sms", Long.valueOf(C5046bo.m7525az(yz2)));
        if (mediaCodecInfo != null) {
            if (C1443d.m3068iW(23)) {
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
                                C4990ab.m7417i("MicroMsg.MMSightYUVMediaCodecRecorder", "profile: %s, level: %s", Integer.valueOf(i5), Integer.valueOf(i6));
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
                            C4990ab.m7417i("MicroMsg.MMSightYUVMediaCodecRecorder", "best profile: %s, level: %s", Integer.valueOf(codecProfileLevel.profile), Integer.valueOf(codecProfileLevel.level));
                            if (codecProfileLevel.profile > 0 && codecProfileLevel.level >= 256) {
                                this.mediaFormat.setInteger(Scopes.PROFILE, codecProfileLevel.profile);
                                this.mediaFormat.setInteger("level", 256);
                            }
                        }
                    }
                } catch (Exception e) {
                    C4990ab.m7413e("MicroMsg.MMSightYUVMediaCodecRecorder", "trySetProfile error: %s", e.getMessage());
                }
            }
            try {
                if (C1443d.m3068iW(21)) {
                    this.mediaFormat.setInteger("bitrate-mode", 1);
                }
            } catch (Exception e2) {
                C4990ab.m7413e("MicroMsg.MMSightYUVMediaCodecRecorder", "trySetBitRateMode error: %s", e2.getMessage());
            }
        }
        this.mediaFormat.setInteger(FFmpegMetadataRetriever.METADATA_KEY_VARIANT_BITRATE, this.bitrate);
        this.mediaFormat.setInteger("frame-rate", this.eTk);
        this.mediaFormat.setInteger("color-format", this.eTl);
        this.mediaFormat.setInteger("i-frame-interval", this.eTm);
        C4990ab.m7417i("MicroMsg.MMSightYUVMediaCodecRecorder", "mediaFormat: %s", this.mediaFormat);
        this.eVq = MediaCodec.createByCodecName(mediaCodecInfo.getName());
        this.eVq.configure(this.mediaFormat, null, null, 1);
        this.eVq.start();
        if (this.ovW) {
            AppMethodBeat.m2505o(76675);
            return 0;
        }
        synchronized (this.eVL) {
            try {
                this.eVK = false;
            } finally {
                while (true) {
                    AppMethodBeat.m2505o(76675);
                }
            }
        }
        return 0;
    }

    /* renamed from: d */
    public final void mo62273d(byte[] bArr, boolean z) {
        AppMethodBeat.m2504i(76678);
        if (!this.ovW) {
            synchronized (this.eVL) {
                try {
                    if (this.eVK) {
                    }
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.m2505o(76678);
                }
            }
        }
        try {
            if (!this.cFy) {
                C4990ab.m7412e("MicroMsg.MMSightYUVMediaCodecRecorder", "writeData, not start!");
                AppMethodBeat.m2505o(76678);
            } else if (this.eVq == null) {
                C4990ab.m7412e("MicroMsg.MMSightYUVMediaCodecRecorder", "encoder is null");
                AppMethodBeat.m2505o(76678);
            } else {
                if (this.ovV != null && this.ovV.owQ <= 0) {
                    this.ovV.owQ = System.nanoTime();
                }
                long yz = C5046bo.m7588yz();
                this.inputBuffers = this.eVq.getInputBuffers();
                this.aQJ = this.eVq.getOutputBuffers();
                int dequeueInputBuffer = this.eVq.dequeueInputBuffer(100);
                this.fXW = dequeueInputBuffer;
                if (dequeueInputBuffer < 0) {
                    C4990ab.m7416i("MicroMsg.MMSightYUVMediaCodecRecorder", "video no input available, drain first");
                    m67160UR();
                }
                if (this.eVq == null) {
                    C4990ab.m7412e("MicroMsg.MMSightYUVMediaCodecRecorder", "encoder is null");
                    AppMethodBeat.m2505o(76678);
                    return;
                }
                C4990ab.m7419v("MicroMsg.MMSightYUVMediaCodecRecorder", "inputBufferIndex: %s", Integer.valueOf(this.fXW));
                long yz2 = C5046bo.m7588yz();
                if (this.fXW >= 0) {
                    long j;
                    long nanoTime = System.nanoTime() - ((long) ((bArr.length / 1600000) / 1000000000));
                    if (this.ovV != null) {
                        j = this.ovV.owQ;
                    } else {
                        j = this.startTime;
                    }
                    long j2 = (nanoTime - j) / 1000;
                    C4990ab.m7418v("MicroMsg.MMSightYUVMediaCodecRecorder", "presentationTime: ".concat(String.valueOf(j2)));
                    ByteBuffer byteBuffer = this.inputBuffers[this.fXW];
                    byteBuffer.clear();
                    byteBuffer.put(bArr);
                    byteBuffer.position(0);
                    if (!this.cFy || z) {
                        C4990ab.m7418v("MicroMsg.MMSightYUVMediaCodecRecorder", "end of stream");
                        this.fXY = true;
                        this.eVq.queueInputBuffer(this.fXW, 0, bArr.length, j2, 4);
                    } else {
                        this.eVq.queueInputBuffer(this.fXW, 0, bArr.length, j2, 0);
                    }
                } else {
                    C4990ab.m7418v("MicroMsg.MMSightYUVMediaCodecRecorder", "input buffer not available");
                }
                m67160UR();
                C4990ab.m7419v("MicroMsg.MMSightYUVMediaCodecRecorder", "encoder used %sms %sms", Long.valueOf(C5046bo.m7525az(yz)), Long.valueOf(C5046bo.m7525az(yz2)));
                AppMethodBeat.m2505o(76678);
            }
        } catch (Exception e) {
            C34549k.bPB();
            C4990ab.m7413e("MicroMsg.MMSightYUVMediaCodecRecorder", "writeData error: %s", e.getMessage());
            C4990ab.printErrStackTrace("MicroMsg.MMSightYUVMediaCodecRecorder", e, "", new Object[0]);
            AppMethodBeat.m2505o(76678);
        }
    }

    /* renamed from: UR */
    private void m67160UR() {
        AppMethodBeat.m2504i(76679);
        this.fXX = this.eVq.dequeueOutputBuffer(this.eTy, 100);
        C4990ab.m7418v("MicroMsg.MMSightYUVMediaCodecRecorder", "outputBufferIndex-->" + this.fXX);
        while (true) {
            if (this.fXX == -1) {
                C4990ab.m7411d("MicroMsg.MMSightYUVMediaCodecRecorder", "no output from encoder available, break encoderEndStream %s", Boolean.valueOf(this.fXY));
                if (!this.fXY) {
                    break;
                }
            } else if (this.fXX == -3) {
                this.aQJ = this.eVq.getOutputBuffers();
                C4990ab.m7410d("MicroMsg.MMSightYUVMediaCodecRecorder", "encoder output buffers changed");
            } else if (this.fXX == -2) {
                MediaFormat outputFormat = this.eVq.getOutputFormat();
                C4990ab.m7410d("MicroMsg.MMSightYUVMediaCodecRecorder", "encoder output format changed: ".concat(String.valueOf(outputFormat)));
                if (this.ovV != null) {
                    this.ovV.mo55073d(outputFormat);
                }
            } else if (this.fXX < 0) {
                C4990ab.m7420w("MicroMsg.MMSightYUVMediaCodecRecorder", "unexpected result from encoder.dequeueOutputBuffer: " + this.fXX);
            } else {
                C4990ab.m7418v("MicroMsg.MMSightYUVMediaCodecRecorder", "perform encoding");
                ByteBuffer byteBuffer = this.aQJ[this.fXX];
                if (byteBuffer == null) {
                    RuntimeException runtimeException = new RuntimeException("encoderOutputBuffer " + this.fXX + " was null");
                    AppMethodBeat.m2505o(76679);
                    throw runtimeException;
                }
                this.frameCount++;
                if ((this.eTy.flags & 2) != 0) {
                    C4990ab.m7419v("MicroMsg.MMSightYUVMediaCodecRecorder", "ignoring BUFFER_FLAG_CODEC_CONFIG, size: %s, %s", Integer.valueOf(this.eTy.size), Boolean.FALSE);
                }
                if (this.eTy.size != 0) {
                    if (!(this.ovV == null || this.ovV.cFy)) {
                        this.ovV.mo55073d(this.eVq.getOutputFormat());
                    }
                    byteBuffer.position(this.eTy.offset);
                    byteBuffer.limit(this.eTy.offset + this.eTy.size);
                    mo46467g(byteBuffer, this.eTy);
                }
                this.eVq.releaseOutputBuffer(this.fXX, false);
                if ((this.eTy.flags & 4) != 0) {
                    if (this.cpc) {
                        C4990ab.m7420w("MicroMsg.MMSightYUVMediaCodecRecorder", "do stop encoder");
                        m67159UO();
                        if (this.owX != null) {
                            this.owX.bPP();
                            this.owX = null;
                            AppMethodBeat.m2505o(76679);
                            return;
                        }
                    } else {
                        C4990ab.m7412e("MicroMsg.MMSightYUVMediaCodecRecorder", "reached end of stream unexpectedly");
                        AppMethodBeat.m2505o(76679);
                        return;
                    }
                }
            }
            this.fXX = this.eVq.dequeueOutputBuffer(this.eTy, 100);
            if (this.fXX <= 0) {
                C4990ab.m7419v("MicroMsg.MMSightYUVMediaCodecRecorder", "get outputBufferIndex %d", Integer.valueOf(this.fXX));
            }
            if (this.fXX < 0 && !this.fXY) {
                break;
            }
        }
        AppMethodBeat.m2505o(76679);
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: g */
    public void mo46467g(ByteBuffer byteBuffer, BufferInfo bufferInfo) {
        AppMethodBeat.m2504i(76680);
        if (this.ovV != null && (bufferInfo.flags & 4) == 0) {
            C34545o c34545o = this.ovV;
            try {
                if (!(c34545o.owN == null || c34545o.owO == -1 || !c34545o.cFy)) {
                    int i;
                    int i2 = byteBuffer != null ? 1 : 0;
                    if (bufferInfo != null) {
                        i = 1;
                    } else {
                        i = 0;
                    }
                    if ((i & i2) != 0) {
                        long j = bufferInfo.presentationTimeUs;
                        bufferInfo.presentationTimeUs = (System.nanoTime() - c34545o.owQ) / 1000;
                        bufferInfo.flags = 1;
                        long yz = C5046bo.m7588yz();
                        c34545o.owN.writeSampleData(c34545o.owO, byteBuffer, bufferInfo);
                        C4990ab.m7419v("MicroMsg.MMSightSystemMediaMuxer", "writeAACSampleData size: %s used %dms oldpts %s fix pts: %s", Integer.valueOf(bufferInfo.size), Long.valueOf(C5046bo.m7525az(yz)), Long.valueOf(j), Long.valueOf(bufferInfo.presentationTimeUs));
                    }
                }
                AppMethodBeat.m2505o(76680);
                return;
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.MMSightSystemMediaMuxer", "writeX264SampleData error: %s", e.getMessage());
            }
        }
        AppMethodBeat.m2505o(76680);
    }

    /* renamed from: a */
    public final void mo62271a(C21293a c21293a) {
        AppMethodBeat.m2504i(76681);
        this.owX = c21293a;
        this.cpc = true;
        C4990ab.m7417i("MicroMsg.MMSightYUVMediaCodecRecorder", "!!!stop, isStart!!: %s %s isEnd %s", Boolean.valueOf(this.cFy), this.owX, Boolean.valueOf(this.owW.bPL()));
        if (this.owW.bPL()) {
            bPX();
        }
        AppMethodBeat.m2505o(76681);
    }

    /* Access modifiers changed, original: final */
    public final void bPX() {
        AppMethodBeat.m2504i(76682);
        C4990ab.m7417i("MicroMsg.MMSightYUVMediaCodecRecorder", "stopImp %s  isStart:%b", C5046bo.dpG().toString(), Boolean.valueOf(this.cFy));
        try {
            if (this.cFy) {
                C5004al.m7442n(new C125562(), 500);
            }
            AppMethodBeat.m2505o(76682);
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.MMSightYUVMediaCodecRecorder", "stop error: %s", e.getMessage());
            AppMethodBeat.m2505o(76682);
        }
    }

    /* renamed from: UQ */
    public final long mo62270UQ() {
        AppMethodBeat.m2504i(76683);
        if (this.startTime <= 0) {
            C4990ab.m7420w("MicroMsg.MMSightYUVMediaCodecRecorder", "do not start record");
            AppMethodBeat.m2505o(76683);
            return 0;
        }
        long currentTimeMillis = System.currentTimeMillis() - this.startTime;
        AppMethodBeat.m2505o(76683);
        return currentTimeMillis;
    }

    public void clear() {
        AppMethodBeat.m2504i(76684);
        C4990ab.m7416i("MicroMsg.MMSightYUVMediaCodecRecorder", "clear");
        m67159UO();
        AppMethodBeat.m2505o(76684);
    }

    /* renamed from: UO */
    private void m67159UO() {
        AppMethodBeat.m2504i(138320);
        if (this.ovW) {
            bPY();
            AppMethodBeat.m2505o(138320);
            return;
        }
        synchronized (this.eVL) {
            try {
                if (this.eVK || 0 == this.startTime) {
                } else {
                    this.eVK = true;
                    bPY();
                    AppMethodBeat.m2505o(138320);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(138320);
            }
        }
    }

    private void bPY() {
        AppMethodBeat.m2504i(138321);
        try {
            if (this.owW != null) {
                this.owW.stop();
            }
            if (this.eVq != null) {
                C4990ab.m7416i("MicroMsg.MMSightYUVMediaCodecRecorder", "stop encoder");
                this.eVq.stop();
                this.eVq.release();
                this.cFy = false;
                this.eVq = null;
            }
            AppMethodBeat.m2505o(138321);
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.MMSightYUVMediaCodecRecorder", "clear error: %s", e.getMessage());
            AppMethodBeat.m2505o(138321);
        }
    }
}
