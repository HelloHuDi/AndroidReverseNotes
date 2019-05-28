package com.tencent.mm.bj;

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
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.plugin.mmsight.segment.MP4MuxerJNI;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.nio.ByteBuffer;

public final class c {
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
    a fXU;
    private int fXV;
    private int fXW = -1;
    private int fXX = -1;
    private boolean fXY = false;
    private byte[] fXZ;
    private int fYa;
    private int frameCount;
    private ByteBuffer[] inputBuffers;
    protected MediaFormat mediaFormat;

    public interface a {
        void a(int i, ByteBuffer byteBuffer, int i2);
    }

    private void g(ByteBuffer byteBuffer, BufferInfo bufferInfo) {
        AppMethodBeat.i(50896);
        if (!(byteBuffer == null || bufferInfo == null || this.fXU == null)) {
            this.fXU.a(this.eTa, byteBuffer, bufferInfo.size);
        }
        AppMethodBeat.o(50896);
    }

    public c(int i, int i2, int i3, int i4) {
        AppMethodBeat.i(50897);
        ab.i("MicroMsg.MediaCodecTransCodeEncoder", "create MediaCodecTransCodeEncoder, init targetWidth: %d, targetHeight: %d", Integer.valueOf(i), Integer.valueOf(i2));
        this.eTi = i;
        this.eTj = i2;
        this.eTk = i4;
        this.eTm = 1;
        this.eTy = new BufferInfo();
        this.bitrate = i3;
        ab.i("MicroMsg.MediaCodecTransCodeEncoder", "create MMSightRemuxMediaCodecEncoder, targetWidth: %s, targetHeight: %s, bitrate: %s", Integer.valueOf(this.eTi), Integer.valueOf(this.eTj), Integer.valueOf(i3));
        AppMethodBeat.o(50897);
    }

    public final int mq(int i) {
        AppMethodBeat.i(50898);
        int alL;
        try {
            this.eTa = i;
            alL = alL();
            AppMethodBeat.o(50898);
            return alL;
        } catch (Exception e) {
            ab.e("MicroMsg.MediaCodecTransCodeEncoder", "init error: %s, try to re-init again", e.getMessage());
            try {
                alL = alL();
                AppMethodBeat.o(50898);
                return alL;
            } catch (Exception e2) {
                ab.e("MicroMsg.MediaCodecTransCodeEncoder", "re-init again error: %s", e2.getMessage());
                AppMethodBeat.o(50898);
                return -1;
            }
        }
    }

    private int alL() {
        AppMethodBeat.i(50899);
        long yz = bo.yz();
        MediaCodecInfo selectCodec = selectCodec("video/avc");
        if (selectCodec == null) {
            ab.e("MicroMsg.MediaCodecTransCodeEncoder", "Unable to find an appropriate codec for video/avc");
            AppMethodBeat.o(50899);
            return -1;
        }
        ab.i("MicroMsg.MediaCodecTransCodeEncoder", "found codec: %s, used %sms", selectCodec.getName(), Long.valueOf(bo.az(yz)));
        yz = bo.yz();
        this.eTl = a(selectCodec, "video/avc");
        yz = bo.az(yz);
        ab.i("MicroMsg.MediaCodecTransCodeEncoder", "found colorFormat: %s, used %sms", Integer.valueOf(this.eTl), Long.valueOf(yz));
        if (this.eTl == 19) {
            this.fYa = 2;
        } else {
            this.fYa = 1;
        }
        yz = bo.yz();
        this.mediaFormat = MediaFormat.createVideoFormat("video/avc", this.eTi, this.eTj);
        ab.i("MicroMsg.MediaCodecTransCodeEncoder", "createVideoFormat used %sms", Long.valueOf(bo.az(yz)));
        if (selectCodec != null) {
            trySetProfile(selectCodec);
            trySetBitRateMode(selectCodec);
        }
        this.mediaFormat.setInteger(FFmpegMetadataRetriever.METADATA_KEY_VARIANT_BITRATE, this.bitrate);
        this.mediaFormat.setInteger("frame-rate", this.eTk);
        this.mediaFormat.setInteger("color-format", this.eTl);
        this.mediaFormat.setInteger("i-frame-interval", this.eTm);
        ab.i("MicroMsg.MediaCodecTransCodeEncoder", "mediaFormat: %s", this.mediaFormat);
        this.eVq = MediaCodec.createByCodecName(selectCodec.getName());
        this.eVq.configure(this.mediaFormat, null, null, 1);
        this.eVq.start();
        AppMethodBeat.o(50899);
        return 0;
    }

    private void trySetProfile(MediaCodecInfo mediaCodecInfo) {
        AppMethodBeat.i(50900);
        if (d.iW(23)) {
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
                            ab.i("MicroMsg.MediaCodecTransCodeEncoder", "profile: %s, level: %s", Integer.valueOf(i), Integer.valueOf(i2));
                            if (isRecognizedProfile(i) && i >= codecProfileLevel.profile && i2 >= codecProfileLevel.level) {
                                codecProfileLevel.profile = i;
                                codecProfileLevel.level = i2;
                            }
                        }
                        ab.i("MicroMsg.MediaCodecTransCodeEncoder", "best profile: %s, level: %s", Integer.valueOf(codecProfileLevel.profile), Integer.valueOf(codecProfileLevel.level));
                        if (codecProfileLevel.profile > 0 && codecProfileLevel.level >= 256) {
                            this.mediaFormat.setInteger(Scopes.PROFILE, codecProfileLevel.profile);
                            this.mediaFormat.setInteger("level", 256);
                        }
                    }
                }
                AppMethodBeat.o(50900);
                return;
            } catch (Exception e) {
                ab.e("MicroMsg.MediaCodecTransCodeEncoder", "trySetProfile error: %s", e.getMessage());
            }
        }
        AppMethodBeat.o(50900);
    }

    private void trySetBitRateMode(MediaCodecInfo mediaCodecInfo) {
        AppMethodBeat.i(50901);
        try {
            if (d.iW(21)) {
                CodecCapabilities capabilitiesForType = mediaCodecInfo.getCapabilitiesForType("video/avc");
                if (capabilitiesForType != null) {
                    EncoderCapabilities encoderCapabilities = capabilitiesForType.getEncoderCapabilities();
                    if (encoderCapabilities != null) {
                        if (encoderCapabilities.isBitrateModeSupported(2)) {
                            ab.i("MicroMsg.MediaCodecTransCodeEncoder", "support cbr bitrate mode");
                            this.mediaFormat.setInteger("bitrate-mode", 2);
                            AppMethodBeat.o(50901);
                            return;
                        } else if (encoderCapabilities.isBitrateModeSupported(0)) {
                            ab.i("MicroMsg.MediaCodecTransCodeEncoder", "support cq bitrate mode");
                            this.mediaFormat.setInteger("bitrate-mode", 0);
                            AppMethodBeat.o(50901);
                            return;
                        } else {
                            ab.i("MicroMsg.MediaCodecTransCodeEncoder", "both cbr and cq bitrate mode not support!");
                        }
                    }
                }
            }
            AppMethodBeat.o(50901);
        } catch (Exception e) {
            ab.e("MicroMsg.MediaCodecTransCodeEncoder", "trySetBitRateMode error: %s", e.getMessage());
            AppMethodBeat.o(50901);
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

    public final void a(byte[] bArr, int i, int i2, int i3, int i4, boolean z, long j, int i5) {
        AppMethodBeat.i(50902);
        if (z || bArr == null) {
            b(this.fXZ, true, j);
            AppMethodBeat.o(50902);
            return;
        }
        boolean z2;
        if (i3 == this.eTi && i4 == this.eTj) {
            z2 = false;
        } else {
            z2 = true;
        }
        ab.d("MicroMsg.MediaCodecTransCodeEncoder", "writeData, needScale: %s, srcSize: [%s, %s] [%s, %s], targetSize: [%s, %s], pts: %s, srcColorFormat: %s, dstColorFormat: %s, data.size:%s", Boolean.valueOf(z2), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(this.eTi), Integer.valueOf(this.eTj), Long.valueOf(j), Integer.valueOf(i5), Integer.valueOf(this.fYa), Integer.valueOf(bArr.length));
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
        b(this.fXZ, false, j);
        AppMethodBeat.o(50902);
    }

    private void b(byte[] bArr, boolean z, long j) {
        AppMethodBeat.i(50903);
        try {
            if (!this.cFy) {
                ab.e("MicroMsg.MediaCodecTransCodeEncoder", "writeData, not start!");
                AppMethodBeat.o(50903);
            } else if (this.eVq == null) {
                ab.e("MicroMsg.MediaCodecTransCodeEncoder", "encoder is null");
                AppMethodBeat.o(50903);
            } else {
                long yz = bo.yz();
                this.inputBuffers = this.eVq.getInputBuffers();
                this.aQJ = this.eVq.getOutputBuffers();
                int i = 0;
                while (this.eVq != null) {
                    int dequeueInputBuffer = this.eVq.dequeueInputBuffer(600);
                    this.fXW = dequeueInputBuffer;
                    if (dequeueInputBuffer >= 0 || i >= 10) {
                        break;
                    }
                    ab.i("MicroMsg.MediaCodecTransCodeEncoder", "video no input available, drain first");
                    UR();
                    i++;
                }
                if (this.eVq == null) {
                    ab.e("MicroMsg.MediaCodecTransCodeEncoder", "encoder is null");
                    AppMethodBeat.o(50903);
                    return;
                }
                ab.v("MicroMsg.MediaCodecTransCodeEncoder", "inputBufferIndex: %s", Integer.valueOf(this.fXW));
                long yz2 = bo.yz();
                if (this.fXW < 0) {
                    ab.v("MicroMsg.MediaCodecTransCodeEncoder", "input buffer not available");
                } else if (!this.cFy || z || bArr == null) {
                    ab.v("MicroMsg.MediaCodecTransCodeEncoder", "end of stream");
                    this.fXY = true;
                    this.eVq.queueInputBuffer(this.fXW, 0, 0, j, 4);
                    this.cpc = true;
                } else {
                    ab.v("MicroMsg.MediaCodecTransCodeEncoder", "presentationTime: ".concat(String.valueOf(j)));
                    ByteBuffer byteBuffer = this.inputBuffers[this.fXW];
                    byteBuffer.clear();
                    byteBuffer.put(bArr);
                    byteBuffer.position(0);
                    this.eVq.queueInputBuffer(this.fXW, 0, bArr.length, j, 0);
                }
                UR();
                ab.v("MicroMsg.MediaCodecTransCodeEncoder", "encoder used %sms %sms", Long.valueOf(bo.az(yz)), Long.valueOf(bo.az(yz2)));
                AppMethodBeat.o(50903);
            }
        } catch (Exception e) {
            ab.e("MicroMsg.MediaCodecTransCodeEncoder", "writeData error: %s", e.getMessage());
            ab.printErrStackTrace("MicroMsg.MediaCodecTransCodeEncoder", e, "", new Object[0]);
            AppMethodBeat.o(50903);
        }
    }

    private void UR() {
        AppMethodBeat.i(50904);
        this.fXX = this.eVq.dequeueOutputBuffer(this.eTy, 600);
        ab.v("MicroMsg.MediaCodecTransCodeEncoder", "outputBufferIndex-->" + this.fXX);
        while (true) {
            if (this.fXX == -1) {
                ab.d("MicroMsg.MediaCodecTransCodeEncoder", "no output from encoder available, break encoderEndStream %s", Boolean.valueOf(this.fXY));
                if (!this.fXY) {
                    break;
                }
            } else if (this.fXX == -3) {
                this.aQJ = this.eVq.getOutputBuffers();
                ab.d("MicroMsg.MediaCodecTransCodeEncoder", "encoder output buffers changed");
            } else if (this.fXX == -2) {
                ab.d("MicroMsg.MediaCodecTransCodeEncoder", "encoder output format changed: ".concat(String.valueOf(this.eVq.getOutputFormat())));
            } else if (this.fXX < 0) {
                ab.w("MicroMsg.MediaCodecTransCodeEncoder", "unexpected result from encoder.dequeueOutputBuffer: " + this.fXX);
            } else {
                ab.v("MicroMsg.MediaCodecTransCodeEncoder", "perform encoding");
                ByteBuffer byteBuffer = this.aQJ[this.fXX];
                if (byteBuffer == null) {
                    RuntimeException runtimeException = new RuntimeException("encoderOutputBuffer " + this.fXX + " was null");
                    AppMethodBeat.o(50904);
                    throw runtimeException;
                }
                this.frameCount++;
                if ((this.eTy.flags & 2) != 0) {
                    ab.v("MicroMsg.MediaCodecTransCodeEncoder", "ignoring BUFFER_FLAG_CODEC_CONFIG, size: %s, %s", Integer.valueOf(this.eTy.size), Boolean.FALSE);
                }
                if (this.eTy.size != 0) {
                    byteBuffer.position(this.eTy.offset);
                    byteBuffer.limit(this.eTy.offset + this.eTy.size);
                    g(byteBuffer, this.eTy);
                }
                this.eVq.releaseOutputBuffer(this.fXX, false);
                if ((this.eTy.flags & 4) != 0) {
                    if (this.cpc) {
                        ab.w("MicroMsg.MediaCodecTransCodeEncoder", "do stop encoder, frameCount: %s, writeFrameCount: %s", Integer.valueOf(this.frameCount), Integer.valueOf(this.fXV));
                        try {
                            this.eVq.stop();
                            this.eVq.release();
                            this.eVq = null;
                            this.cFy = false;
                            AppMethodBeat.o(50904);
                            return;
                        } catch (Exception e) {
                            ab.e("MicroMsg.MediaCodecTransCodeEncoder", "do stop encoder error: %s", e.getMessage());
                            AppMethodBeat.o(50904);
                            return;
                        }
                    }
                    ab.e("MicroMsg.MediaCodecTransCodeEncoder", "reached end of stream unexpectedly");
                    AppMethodBeat.o(50904);
                    return;
                }
            }
            this.fXX = this.eVq.dequeueOutputBuffer(this.eTy, 600);
            if (this.fXX <= 0) {
                ab.v("MicroMsg.MediaCodecTransCodeEncoder", "get outputBufferIndex %d", Integer.valueOf(this.fXX));
            }
            if (this.fXX < 0 && !this.fXY) {
                break;
            }
        }
        AppMethodBeat.o(50904);
    }

    private static int a(MediaCodecInfo mediaCodecInfo, String str) {
        AppMethodBeat.i(50905);
        long yz = bo.yz();
        CodecCapabilities capabilitiesForType = mediaCodecInfo.getCapabilitiesForType(str);
        ab.i("MicroMsg.MediaCodecTransCodeEncoder", "getCapabilitiesForType used %sms", Long.valueOf(bo.az(yz)));
        ab.i("MicroMsg.MediaCodecTransCodeEncoder", "color format length: %s", Integer.valueOf(capabilitiesForType.colorFormats.length));
        int i = 0;
        for (int i2 : capabilitiesForType.colorFormats) {
            ab.i("MicroMsg.MediaCodecTransCodeEncoder", "capabilities colorFormat: %s", Integer.valueOf(i2));
            if (mr(i2) && i2 > i) {
                if (i2 == 21) {
                    break;
                }
                i = i2;
            }
        }
        int i22 = i;
        ab.i("MicroMsg.MediaCodecTransCodeEncoder", "codec: %s, colorFormat: %s", mediaCodecInfo.getName(), Integer.valueOf(i22));
        AppMethodBeat.o(50905);
        return i22;
    }

    private static boolean mr(int i) {
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
        AppMethodBeat.i(50906);
        int codecCount = MediaCodecList.getCodecCount();
        for (int i = 0; i < codecCount; i++) {
            MediaCodecInfo codecInfoAt = MediaCodecList.getCodecInfoAt(i);
            if (codecInfoAt.isEncoder()) {
                String[] supportedTypes = codecInfoAt.getSupportedTypes();
                for (String equalsIgnoreCase : supportedTypes) {
                    if (equalsIgnoreCase.equalsIgnoreCase(str)) {
                        AppMethodBeat.o(50906);
                        return codecInfoAt;
                    }
                }
                continue;
            }
        }
        AppMethodBeat.o(50906);
        return null;
    }
}
