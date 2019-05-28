package com.tencent.p177mm.p838bj;

import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaCodecInfo;
import android.media.MediaCodecInfo.CodecCapabilities;
import android.media.MediaCodecInfo.CodecProfileLevel;
import android.media.MediaCodecInfo.EncoderCapabilities;
import android.media.MediaCodecList;
import android.media.MediaFormat;
import com.google.android.gms.common.Scopes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C1443d;
import com.tencent.p177mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.p177mm.plugin.mmsight.segment.MP4MuxerJNI;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.nio.ByteBuffer;

/* renamed from: com.tencent.mm.bj.c */
public final class C41792c {
    private ByteBuffer[] aQJ;
    private int bitrate = 0;
    boolean cFy = false;
    private boolean cpc = false;
    protected int eTa = -1;
    private int eTi;
    private int eTj;
    private int eTk;
    private int eTl;
    private int eTm;
    private BufferInfo eTy;
    protected MediaCodec eVq;
    C17984a fXU;
    private int fXV;
    private int fXW = -1;
    private int fXX = -1;
    private boolean fXY = false;
    private byte[] fXZ;
    private int fYa;
    private int frameCount;
    private ByteBuffer[] inputBuffers;
    protected MediaFormat mediaFormat;

    /* renamed from: com.tencent.mm.bj.c$a */
    public interface C17984a {
        /* renamed from: a */
        void mo33528a(int i, ByteBuffer byteBuffer, int i2);
    }

    /* renamed from: g */
    private void m73790g(ByteBuffer byteBuffer, BufferInfo bufferInfo) {
        AppMethodBeat.m2504i(50896);
        if (!(byteBuffer == null || bufferInfo == null || this.fXU == null)) {
            this.fXU.mo33528a(this.eTa, byteBuffer, bufferInfo.size);
        }
        AppMethodBeat.m2505o(50896);
    }

    public C41792c(int i, int i2, int i3, int i4) {
        AppMethodBeat.m2504i(50897);
        C4990ab.m7417i("MicroMsg.MediaCodecTransCodeEncoder", "create MediaCodecTransCodeEncoder, init targetWidth: %d, targetHeight: %d", Integer.valueOf(i), Integer.valueOf(i2));
        this.eTi = i;
        this.eTj = i2;
        this.eTk = i4;
        this.eTm = 1;
        this.eTy = new BufferInfo();
        this.bitrate = i3;
        C4990ab.m7417i("MicroMsg.MediaCodecTransCodeEncoder", "create MMSightRemuxMediaCodecEncoder, targetWidth: %s, targetHeight: %s, bitrate: %s", Integer.valueOf(this.eTi), Integer.valueOf(this.eTj), Integer.valueOf(i3));
        AppMethodBeat.m2505o(50897);
    }

    /* renamed from: mq */
    public final int mo67545mq(int i) {
        AppMethodBeat.m2504i(50898);
        int alL;
        try {
            this.eTa = i;
            alL = alL();
            AppMethodBeat.m2505o(50898);
            return alL;
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.MediaCodecTransCodeEncoder", "init error: %s, try to re-init again", e.getMessage());
            try {
                alL = alL();
                AppMethodBeat.m2505o(50898);
                return alL;
            } catch (Exception e2) {
                C4990ab.m7413e("MicroMsg.MediaCodecTransCodeEncoder", "re-init again error: %s", e2.getMessage());
                AppMethodBeat.m2505o(50898);
                return -1;
            }
        }
    }

    private int alL() {
        AppMethodBeat.m2504i(50899);
        long yz = C5046bo.m7588yz();
        MediaCodecInfo selectCodec = C41792c.selectCodec("video/avc");
        if (selectCodec == null) {
            C4990ab.m7412e("MicroMsg.MediaCodecTransCodeEncoder", "Unable to find an appropriate codec for video/avc");
            AppMethodBeat.m2505o(50899);
            return -1;
        }
        C4990ab.m7417i("MicroMsg.MediaCodecTransCodeEncoder", "found codec: %s, used %sms", selectCodec.getName(), Long.valueOf(C5046bo.m7525az(yz)));
        yz = C5046bo.m7588yz();
        this.eTl = C41792c.m73788a(selectCodec, "video/avc");
        yz = C5046bo.m7525az(yz);
        C4990ab.m7417i("MicroMsg.MediaCodecTransCodeEncoder", "found colorFormat: %s, used %sms", Integer.valueOf(this.eTl), Long.valueOf(yz));
        if (this.eTl == 19) {
            this.fYa = 2;
        } else {
            this.fYa = 1;
        }
        yz = C5046bo.m7588yz();
        this.mediaFormat = MediaFormat.createVideoFormat("video/avc", this.eTi, this.eTj);
        C4990ab.m7417i("MicroMsg.MediaCodecTransCodeEncoder", "createVideoFormat used %sms", Long.valueOf(C5046bo.m7525az(yz)));
        if (selectCodec != null) {
            trySetProfile(selectCodec);
            trySetBitRateMode(selectCodec);
        }
        this.mediaFormat.setInteger(FFmpegMetadataRetriever.METADATA_KEY_VARIANT_BITRATE, this.bitrate);
        this.mediaFormat.setInteger("frame-rate", this.eTk);
        this.mediaFormat.setInteger("color-format", this.eTl);
        this.mediaFormat.setInteger("i-frame-interval", this.eTm);
        C4990ab.m7417i("MicroMsg.MediaCodecTransCodeEncoder", "mediaFormat: %s", this.mediaFormat);
        this.eVq = MediaCodec.createByCodecName(selectCodec.getName());
        this.eVq.configure(this.mediaFormat, null, null, 1);
        this.eVq.start();
        AppMethodBeat.m2505o(50899);
        return 0;
    }

    private void trySetProfile(MediaCodecInfo mediaCodecInfo) {
        AppMethodBeat.m2504i(50900);
        if (C1443d.m3068iW(23)) {
            try {
                CodecCapabilities capabilitiesForType = mediaCodecInfo.getCapabilitiesForType("video/avc");
                if (capabilitiesForType != null) {
                    CodecProfileLevel[] codecProfileLevelArr = capabilitiesForType.profileLevels;
                    if (codecProfileLevelArr != null) {
                        CodecProfileLevel codecProfileLevel = new CodecProfileLevel();
                        codecProfileLevel.level = 0;
                        codecProfileLevel.profile = 0;
                        for (CodecProfileLevel codecProfileLevel2 : codecProfileLevelArr) {
                            int i = codecProfileLevel2.profile;
                            int i2 = codecProfileLevel2.level;
                            C4990ab.m7417i("MicroMsg.MediaCodecTransCodeEncoder", "profile: %s, level: %s", Integer.valueOf(i), Integer.valueOf(i2));
                            if (C41792c.isRecognizedProfile(i) && i >= codecProfileLevel.profile && i2 >= codecProfileLevel.level) {
                                codecProfileLevel.profile = i;
                                codecProfileLevel.level = i2;
                            }
                        }
                        C4990ab.m7417i("MicroMsg.MediaCodecTransCodeEncoder", "best profile: %s, level: %s", Integer.valueOf(codecProfileLevel.profile), Integer.valueOf(codecProfileLevel.level));
                        if (codecProfileLevel.profile > 0 && codecProfileLevel.level >= 256) {
                            this.mediaFormat.setInteger(Scopes.PROFILE, codecProfileLevel.profile);
                            this.mediaFormat.setInteger("level", 256);
                        }
                    }
                }
                AppMethodBeat.m2505o(50900);
                return;
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.MediaCodecTransCodeEncoder", "trySetProfile error: %s", e.getMessage());
            }
        }
        AppMethodBeat.m2505o(50900);
    }

    private void trySetBitRateMode(MediaCodecInfo mediaCodecInfo) {
        AppMethodBeat.m2504i(50901);
        try {
            if (C1443d.m3068iW(21)) {
                CodecCapabilities capabilitiesForType = mediaCodecInfo.getCapabilitiesForType("video/avc");
                if (capabilitiesForType != null) {
                    EncoderCapabilities encoderCapabilities = capabilitiesForType.getEncoderCapabilities();
                    if (encoderCapabilities != null) {
                        if (encoderCapabilities.isBitrateModeSupported(2)) {
                            C4990ab.m7416i("MicroMsg.MediaCodecTransCodeEncoder", "support cbr bitrate mode");
                            this.mediaFormat.setInteger("bitrate-mode", 2);
                            AppMethodBeat.m2505o(50901);
                            return;
                        } else if (encoderCapabilities.isBitrateModeSupported(0)) {
                            C4990ab.m7416i("MicroMsg.MediaCodecTransCodeEncoder", "support cq bitrate mode");
                            this.mediaFormat.setInteger("bitrate-mode", 0);
                            AppMethodBeat.m2505o(50901);
                            return;
                        } else {
                            C4990ab.m7416i("MicroMsg.MediaCodecTransCodeEncoder", "both cbr and cq bitrate mode not support!");
                        }
                    }
                }
            }
            AppMethodBeat.m2505o(50901);
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.MediaCodecTransCodeEncoder", "trySetBitRateMode error: %s", e.getMessage());
            AppMethodBeat.m2505o(50901);
        }
    }

    private static boolean isRecognizedProfile(int i) {
        switch (i) {
            case 1:
            case 2:
            case 8:
                return true;
            default:
                return false;
        }
    }

    /* renamed from: a */
    public final void mo67544a(byte[] bArr, int i, int i2, int i3, int i4, boolean z, long j, int i5) {
        AppMethodBeat.m2504i(50902);
        if (z || bArr == null) {
            m73789b(this.fXZ, true, j);
            AppMethodBeat.m2505o(50902);
            return;
        }
        boolean z2;
        if (i3 == this.eTi && i4 == this.eTj) {
            z2 = false;
        } else {
            z2 = true;
        }
        C4990ab.m7411d("MicroMsg.MediaCodecTransCodeEncoder", "writeData, needScale: %s, srcSize: [%s, %s] [%s, %s], targetSize: [%s, %s], pts: %s, srcColorFormat: %s, dstColorFormat: %s, data.size:%s", Boolean.valueOf(z2), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(this.eTi), Integer.valueOf(this.eTj), Long.valueOf(j), Integer.valueOf(i5), Integer.valueOf(this.fYa), Integer.valueOf(bArr.length));
        if (this.fXZ == null) {
            this.fXZ = new byte[(((this.eTi * this.eTj) * 3) >> 1)];
        }
        if (this.fXZ.length != bArr.length) {
            this.fXZ = new byte[bArr.length];
        }
        if (this.eTl != 19 || z2) {
            MP4MuxerJNI.yuv420pTo420XXAndScaleLock(bArr, i5, this.fXZ, this.fYa, i, i2, i3, i4, this.eTi, this.eTj);
        } else {
            System.arraycopy(bArr, 0, this.fXZ, 0, bArr.length);
        }
        this.fXV++;
        m73789b(this.fXZ, false, j);
        AppMethodBeat.m2505o(50902);
    }

    /* renamed from: b */
    private void m73789b(byte[] bArr, boolean z, long j) {
        AppMethodBeat.m2504i(50903);
        try {
            if (!this.cFy) {
                C4990ab.m7412e("MicroMsg.MediaCodecTransCodeEncoder", "writeData, not start!");
                AppMethodBeat.m2505o(50903);
            } else if (this.eVq == null) {
                C4990ab.m7412e("MicroMsg.MediaCodecTransCodeEncoder", "encoder is null");
                AppMethodBeat.m2505o(50903);
            } else {
                long yz = C5046bo.m7588yz();
                this.inputBuffers = this.eVq.getInputBuffers();
                this.aQJ = this.eVq.getOutputBuffers();
                int i = 0;
                while (this.eVq != null) {
                    int dequeueInputBuffer = this.eVq.dequeueInputBuffer(600);
                    this.fXW = dequeueInputBuffer;
                    if (dequeueInputBuffer >= 0 || i >= 10) {
                        break;
                    }
                    C4990ab.m7416i("MicroMsg.MediaCodecTransCodeEncoder", "video no input available, drain first");
                    m73787UR();
                    i++;
                }
                if (this.eVq == null) {
                    C4990ab.m7412e("MicroMsg.MediaCodecTransCodeEncoder", "encoder is null");
                    AppMethodBeat.m2505o(50903);
                    return;
                }
                C4990ab.m7419v("MicroMsg.MediaCodecTransCodeEncoder", "inputBufferIndex: %s", Integer.valueOf(this.fXW));
                long yz2 = C5046bo.m7588yz();
                if (this.fXW < 0) {
                    C4990ab.m7418v("MicroMsg.MediaCodecTransCodeEncoder", "input buffer not available");
                } else if (!this.cFy || z || bArr == null) {
                    C4990ab.m7418v("MicroMsg.MediaCodecTransCodeEncoder", "end of stream");
                    this.fXY = true;
                    this.eVq.queueInputBuffer(this.fXW, 0, 0, j, 4);
                    this.cpc = true;
                } else {
                    C4990ab.m7418v("MicroMsg.MediaCodecTransCodeEncoder", "presentationTime: ".concat(String.valueOf(j)));
                    ByteBuffer byteBuffer = this.inputBuffers[this.fXW];
                    byteBuffer.clear();
                    byteBuffer.put(bArr);
                    byteBuffer.position(0);
                    this.eVq.queueInputBuffer(this.fXW, 0, bArr.length, j, 0);
                }
                m73787UR();
                C4990ab.m7419v("MicroMsg.MediaCodecTransCodeEncoder", "encoder used %sms %sms", Long.valueOf(C5046bo.m7525az(yz)), Long.valueOf(C5046bo.m7525az(yz2)));
                AppMethodBeat.m2505o(50903);
            }
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.MediaCodecTransCodeEncoder", "writeData error: %s", e.getMessage());
            C4990ab.printErrStackTrace("MicroMsg.MediaCodecTransCodeEncoder", e, "", new Object[0]);
            AppMethodBeat.m2505o(50903);
        }
    }

    /* renamed from: UR */
    private void m73787UR() {
        AppMethodBeat.m2504i(50904);
        this.fXX = this.eVq.dequeueOutputBuffer(this.eTy, 600);
        C4990ab.m7418v("MicroMsg.MediaCodecTransCodeEncoder", "outputBufferIndex-->" + this.fXX);
        while (true) {
            if (this.fXX == -1) {
                C4990ab.m7411d("MicroMsg.MediaCodecTransCodeEncoder", "no output from encoder available, break encoderEndStream %s", Boolean.valueOf(this.fXY));
                if (!this.fXY) {
                    break;
                }
            } else if (this.fXX == -3) {
                this.aQJ = this.eVq.getOutputBuffers();
                C4990ab.m7410d("MicroMsg.MediaCodecTransCodeEncoder", "encoder output buffers changed");
            } else if (this.fXX == -2) {
                C4990ab.m7410d("MicroMsg.MediaCodecTransCodeEncoder", "encoder output format changed: ".concat(String.valueOf(this.eVq.getOutputFormat())));
            } else if (this.fXX < 0) {
                C4990ab.m7420w("MicroMsg.MediaCodecTransCodeEncoder", "unexpected result from encoder.dequeueOutputBuffer: " + this.fXX);
            } else {
                C4990ab.m7418v("MicroMsg.MediaCodecTransCodeEncoder", "perform encoding");
                ByteBuffer byteBuffer = this.aQJ[this.fXX];
                if (byteBuffer == null) {
                    RuntimeException runtimeException = new RuntimeException("encoderOutputBuffer " + this.fXX + " was null");
                    AppMethodBeat.m2505o(50904);
                    throw runtimeException;
                }
                this.frameCount++;
                if ((this.eTy.flags & 2) != 0) {
                    C4990ab.m7419v("MicroMsg.MediaCodecTransCodeEncoder", "ignoring BUFFER_FLAG_CODEC_CONFIG, size: %s, %s", Integer.valueOf(this.eTy.size), Boolean.FALSE);
                }
                if (this.eTy.size != 0) {
                    byteBuffer.position(this.eTy.offset);
                    byteBuffer.limit(this.eTy.offset + this.eTy.size);
                    m73790g(byteBuffer, this.eTy);
                }
                this.eVq.releaseOutputBuffer(this.fXX, false);
                if ((this.eTy.flags & 4) != 0) {
                    if (this.cpc) {
                        C4990ab.m7421w("MicroMsg.MediaCodecTransCodeEncoder", "do stop encoder, frameCount: %s, writeFrameCount: %s", Integer.valueOf(this.frameCount), Integer.valueOf(this.fXV));
                        try {
                            this.eVq.stop();
                            this.eVq.release();
                            this.eVq = null;
                            this.cFy = false;
                            AppMethodBeat.m2505o(50904);
                            return;
                        } catch (Exception e) {
                            C4990ab.m7413e("MicroMsg.MediaCodecTransCodeEncoder", "do stop encoder error: %s", e.getMessage());
                            AppMethodBeat.m2505o(50904);
                            return;
                        }
                    }
                    C4990ab.m7412e("MicroMsg.MediaCodecTransCodeEncoder", "reached end of stream unexpectedly");
                    AppMethodBeat.m2505o(50904);
                    return;
                }
            }
            this.fXX = this.eVq.dequeueOutputBuffer(this.eTy, 600);
            if (this.fXX <= 0) {
                C4990ab.m7419v("MicroMsg.MediaCodecTransCodeEncoder", "get outputBufferIndex %d", Integer.valueOf(this.fXX));
            }
            if (this.fXX < 0 && !this.fXY) {
                break;
            }
        }
        AppMethodBeat.m2505o(50904);
    }

    /* renamed from: a */
    private static int m73788a(MediaCodecInfo mediaCodecInfo, String str) {
        AppMethodBeat.m2504i(50905);
        long yz = C5046bo.m7588yz();
        CodecCapabilities capabilitiesForType = mediaCodecInfo.getCapabilitiesForType(str);
        C4990ab.m7417i("MicroMsg.MediaCodecTransCodeEncoder", "getCapabilitiesForType used %sms", Long.valueOf(C5046bo.m7525az(yz)));
        C4990ab.m7417i("MicroMsg.MediaCodecTransCodeEncoder", "color format length: %s", Integer.valueOf(capabilitiesForType.colorFormats.length));
        int i = 0;
        for (int i2 : capabilitiesForType.colorFormats) {
            C4990ab.m7417i("MicroMsg.MediaCodecTransCodeEncoder", "capabilities colorFormat: %s", Integer.valueOf(i2));
            if (C41792c.m73791mr(i2) && i2 > i) {
                if (i2 == 21) {
                    break;
                }
                i = i2;
            }
        }
        int i22 = i;
        C4990ab.m7417i("MicroMsg.MediaCodecTransCodeEncoder", "codec: %s, colorFormat: %s", mediaCodecInfo.getName(), Integer.valueOf(i22));
        AppMethodBeat.m2505o(50905);
        return i22;
    }

    /* renamed from: mr */
    private static boolean m73791mr(int i) {
        switch (i) {
            case 19:
            case 21:
            case 2130706688:
                return true;
            default:
                return false;
        }
    }

    private static MediaCodecInfo selectCodec(String str) {
        AppMethodBeat.m2504i(50906);
        int codecCount = MediaCodecList.getCodecCount();
        for (int i = 0; i < codecCount; i++) {
            MediaCodecInfo codecInfoAt = MediaCodecList.getCodecInfoAt(i);
            if (codecInfoAt.isEncoder()) {
                String[] supportedTypes = codecInfoAt.getSupportedTypes();
                for (String equalsIgnoreCase : supportedTypes) {
                    if (equalsIgnoreCase.equalsIgnoreCase(str)) {
                        AppMethodBeat.m2505o(50906);
                        return codecInfoAt;
                    }
                }
                continue;
            }
        }
        AppMethodBeat.m2505o(50906);
        return null;
    }
}
