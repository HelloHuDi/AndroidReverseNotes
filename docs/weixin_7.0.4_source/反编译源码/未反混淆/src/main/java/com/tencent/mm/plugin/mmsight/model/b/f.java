package com.tencent.mm.plugin.mmsight.model.b;

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
import com.tencent.mm.plugin.mmsight.model.k;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.nio.ByteBuffer;

public final class f {
    private ByteBuffer[] aQJ;
    private int bitrate = 0;
    boolean cFy = false;
    private boolean cpc = false;
    protected int eTa = -1;
    int eTi;
    int eTj;
    private int eTk;
    int eTl;
    private int eTm;
    private BufferInfo eTy;
    protected MediaCodec eVq;
    int fXV;
    private int fXW = -1;
    private int fXX = -1;
    private boolean fXY = false;
    byte[] fXZ;
    int fYa;
    int frameCount;
    private int gLw;
    private int gLx;
    private ByteBuffer[] inputBuffers;
    protected MediaFormat mediaFormat;
    a oxu;

    public interface a {
        void a(int i, ByteBuffer byteBuffer, int i2);
    }

    private void g(ByteBuffer byteBuffer, BufferInfo bufferInfo) {
        AppMethodBeat.i(76714);
        if (!(byteBuffer == null || bufferInfo == null || this.oxu == null)) {
            this.oxu.a(this.eTa, byteBuffer, bufferInfo.size);
        }
        AppMethodBeat.o(76714);
    }

    public f(int i, int i2, int i3, int i4, int i5, int i6) {
        AppMethodBeat.i(76715);
        this.gLw = i;
        this.gLx = i2;
        ab.i("MicroMsg.MMSightRemuxMediaCodecEncoder", "create MMSightRemuxMediaCodecEncoder, init targetWidth: %d, targetHeight: %d", Integer.valueOf(i3), Integer.valueOf(i4));
        this.eTi = i3;
        this.eTj = i4;
        this.eTk = i6;
        this.eTm = 1;
        this.eTy = new BufferInfo();
        this.bitrate = i5;
        ab.i("MicroMsg.MMSightRemuxMediaCodecEncoder", "create MMSightRemuxMediaCodecEncoder, frameWidth: %s, frameHeight: %s, targetWidth: %s, targetHeight: %s, bitrate: %s", Integer.valueOf(this.gLw), Integer.valueOf(this.gLx), Integer.valueOf(this.eTi), Integer.valueOf(this.eTj), Integer.valueOf(i5));
        AppMethodBeat.o(76715);
    }

    public final int mq(int i) {
        AppMethodBeat.i(76716);
        int alL;
        try {
            this.eTa = i;
            alL = alL();
            AppMethodBeat.o(76716);
            return alL;
        } catch (Exception e) {
            ab.e("MicroMsg.MMSightRemuxMediaCodecEncoder", "init error: %s, try to re-init again", e.getMessage());
            try {
                alL = alL();
                AppMethodBeat.o(76716);
                return alL;
            } catch (Exception e2) {
                ab.e("MicroMsg.MMSightRemuxMediaCodecEncoder", "re-init again error: %s", e2.getMessage());
                k.bPA();
                AppMethodBeat.o(76716);
                return -1;
            }
        }
    }

    private int alL() {
        AppMethodBeat.i(76717);
        long yz = bo.yz();
        MediaCodecInfo selectCodec = selectCodec("video/avc");
        if (selectCodec == null) {
            ab.e("MicroMsg.MMSightRemuxMediaCodecEncoder", "Unable to find an appropriate codec for video/avc");
            k.bPA();
            AppMethodBeat.o(76717);
            return -1;
        }
        ab.i("MicroMsg.MMSightRemuxMediaCodecEncoder", "found codec: %s, used %sms", selectCodec.getName(), Long.valueOf(bo.az(yz)));
        yz = bo.yz();
        this.eTl = a(selectCodec, "video/avc");
        yz = bo.az(yz);
        ab.i("MicroMsg.MMSightRemuxMediaCodecEncoder", "found colorFormat: %s, used %sms", Integer.valueOf(this.eTl), Long.valueOf(yz));
        if (this.eTl == 19) {
            this.fYa = 2;
        } else {
            this.fYa = 1;
        }
        yz = bo.yz();
        this.mediaFormat = MediaFormat.createVideoFormat("video/avc", this.eTi, this.eTj);
        ab.i("MicroMsg.MMSightRemuxMediaCodecEncoder", "createVideoFormat used %sms", Long.valueOf(bo.az(yz)));
        if (selectCodec != null) {
            trySetProfile(selectCodec);
            trySetBitRateMode(selectCodec);
        }
        this.mediaFormat.setInteger(FFmpegMetadataRetriever.METADATA_KEY_VARIANT_BITRATE, this.bitrate);
        this.mediaFormat.setInteger("frame-rate", this.eTk);
        this.mediaFormat.setInteger("color-format", this.eTl);
        this.mediaFormat.setInteger("i-frame-interval", this.eTm);
        ab.i("MicroMsg.MMSightRemuxMediaCodecEncoder", "mediaFormat: %s", this.mediaFormat);
        this.eVq = MediaCodec.createByCodecName(selectCodec.getName());
        this.eVq.configure(this.mediaFormat, null, null, 1);
        this.eVq.start();
        AppMethodBeat.o(76717);
        return 0;
    }

    private void trySetProfile(MediaCodecInfo mediaCodecInfo) {
        AppMethodBeat.i(76718);
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
                            ab.i("MicroMsg.MMSightRemuxMediaCodecEncoder", "profile: %s, level: %s", Integer.valueOf(i), Integer.valueOf(i2));
                            if (isRecognizedProfile(i) && i >= codecProfileLevel.profile && i2 >= codecProfileLevel.level) {
                                codecProfileLevel.profile = i;
                                codecProfileLevel.level = i2;
                            }
                        }
                        ab.i("MicroMsg.MMSightRemuxMediaCodecEncoder", "best profile: %s, level: %s", Integer.valueOf(codecProfileLevel.profile), Integer.valueOf(codecProfileLevel.level));
                        if (codecProfileLevel.profile > 0 && codecProfileLevel.level >= 256) {
                            this.mediaFormat.setInteger(Scopes.PROFILE, codecProfileLevel.profile);
                            this.mediaFormat.setInteger("level", 256);
                        }
                    }
                }
                AppMethodBeat.o(76718);
                return;
            } catch (Exception e) {
                ab.e("MicroMsg.MMSightRemuxMediaCodecEncoder", "trySetProfile error: %s", e.getMessage());
            }
        }
        AppMethodBeat.o(76718);
    }

    private void trySetBitRateMode(MediaCodecInfo mediaCodecInfo) {
        AppMethodBeat.i(76719);
        try {
            if (d.iW(21)) {
                CodecCapabilities capabilitiesForType = mediaCodecInfo.getCapabilitiesForType("video/avc");
                if (capabilitiesForType != null) {
                    EncoderCapabilities encoderCapabilities = capabilitiesForType.getEncoderCapabilities();
                    if (encoderCapabilities != null) {
                        if (encoderCapabilities.isBitrateModeSupported(2)) {
                            ab.i("MicroMsg.MMSightRemuxMediaCodecEncoder", "support cbr bitrate mode");
                            this.mediaFormat.setInteger("bitrate-mode", 2);
                            AppMethodBeat.o(76719);
                            return;
                        } else if (encoderCapabilities.isBitrateModeSupported(0)) {
                            ab.i("MicroMsg.MMSightRemuxMediaCodecEncoder", "support cq bitrate mode");
                            this.mediaFormat.setInteger("bitrate-mode", 0);
                            AppMethodBeat.o(76719);
                            return;
                        } else {
                            ab.i("MicroMsg.MMSightRemuxMediaCodecEncoder", "both cbr and cq bitrate mode not support!");
                        }
                    }
                }
            }
            AppMethodBeat.o(76719);
        } catch (Exception e) {
            ab.e("MicroMsg.MMSightRemuxMediaCodecEncoder", "trySetBitRateMode error: %s", e.getMessage());
            AppMethodBeat.o(76719);
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

    public final void b(byte[] bArr, boolean z, long j) {
        AppMethodBeat.i(76720);
        try {
            if (!this.cFy) {
                ab.e("MicroMsg.MMSightRemuxMediaCodecEncoder", "writeData, not start!");
                AppMethodBeat.o(76720);
            } else if (this.eVq == null) {
                ab.e("MicroMsg.MMSightRemuxMediaCodecEncoder", "encoder is null");
                AppMethodBeat.o(76720);
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
                    ab.i("MicroMsg.MMSightRemuxMediaCodecEncoder", "video no input available, drain first");
                    UR();
                    i++;
                }
                if (this.eVq == null) {
                    ab.e("MicroMsg.MMSightRemuxMediaCodecEncoder", "encoder is null");
                    AppMethodBeat.o(76720);
                    return;
                }
                ab.v("MicroMsg.MMSightRemuxMediaCodecEncoder", "inputBufferIndex: %s", Integer.valueOf(this.fXW));
                long yz2 = bo.yz();
                if (this.fXW < 0) {
                    ab.v("MicroMsg.MMSightRemuxMediaCodecEncoder", "input buffer not available");
                } else if (!this.cFy || z || bArr == null) {
                    ab.v("MicroMsg.MMSightRemuxMediaCodecEncoder", "end of stream");
                    this.fXY = true;
                    this.eVq.queueInputBuffer(this.fXW, 0, 0, j, 4);
                    this.cpc = true;
                } else {
                    ab.v("MicroMsg.MMSightRemuxMediaCodecEncoder", "presentationTime: ".concat(String.valueOf(j)));
                    ByteBuffer byteBuffer = this.inputBuffers[this.fXW];
                    byteBuffer.clear();
                    byteBuffer.put(bArr);
                    byteBuffer.position(0);
                    this.eVq.queueInputBuffer(this.fXW, 0, bArr.length, j, 0);
                }
                UR();
                ab.v("MicroMsg.MMSightRemuxMediaCodecEncoder", "encoder used %sms %sms", Long.valueOf(bo.az(yz)), Long.valueOf(bo.az(yz2)));
                AppMethodBeat.o(76720);
            }
        } catch (Exception e) {
            k.bPB();
            ab.e("MicroMsg.MMSightRemuxMediaCodecEncoder", "writeData error: %s", e.getMessage());
            ab.printErrStackTrace("MicroMsg.MMSightRemuxMediaCodecEncoder", e, "", new Object[0]);
            AppMethodBeat.o(76720);
        }
    }

    private void UR() {
        AppMethodBeat.i(76721);
        this.fXX = this.eVq.dequeueOutputBuffer(this.eTy, 600);
        ab.v("MicroMsg.MMSightRemuxMediaCodecEncoder", "outputBufferIndex-->" + this.fXX);
        while (true) {
            if (this.fXX == -1) {
                ab.d("MicroMsg.MMSightRemuxMediaCodecEncoder", "no output from encoder available, break encoderEndStream %s", Boolean.valueOf(this.fXY));
                if (!this.fXY) {
                    break;
                }
            } else if (this.fXX == -3) {
                this.aQJ = this.eVq.getOutputBuffers();
                ab.d("MicroMsg.MMSightRemuxMediaCodecEncoder", "encoder output buffers changed");
            } else if (this.fXX == -2) {
                ab.d("MicroMsg.MMSightRemuxMediaCodecEncoder", "encoder output format changed: ".concat(String.valueOf(this.eVq.getOutputFormat())));
            } else if (this.fXX < 0) {
                ab.w("MicroMsg.MMSightRemuxMediaCodecEncoder", "unexpected result from encoder.dequeueOutputBuffer: " + this.fXX);
            } else {
                ab.v("MicroMsg.MMSightRemuxMediaCodecEncoder", "perform encoding");
                ByteBuffer byteBuffer = this.aQJ[this.fXX];
                if (byteBuffer == null) {
                    RuntimeException runtimeException = new RuntimeException("encoderOutputBuffer " + this.fXX + " was null");
                    AppMethodBeat.o(76721);
                    throw runtimeException;
                }
                this.frameCount++;
                if ((this.eTy.flags & 2) != 0) {
                    ab.v("MicroMsg.MMSightRemuxMediaCodecEncoder", "ignoring BUFFER_FLAG_CODEC_CONFIG, size: %s, %s", Integer.valueOf(this.eTy.size), Boolean.FALSE);
                }
                if (this.eTy.size != 0) {
                    byteBuffer.position(this.eTy.offset);
                    byteBuffer.limit(this.eTy.offset + this.eTy.size);
                    g(byteBuffer, this.eTy);
                }
                this.eVq.releaseOutputBuffer(this.fXX, false);
                if ((this.eTy.flags & 4) != 0) {
                    if (this.cpc) {
                        ab.w("MicroMsg.MMSightRemuxMediaCodecEncoder", "do stop encoder, frameCount: %s, writeFrameCount: %s", Integer.valueOf(this.frameCount), Integer.valueOf(this.fXV));
                        try {
                            this.eVq.stop();
                            this.eVq.release();
                            this.eVq = null;
                            this.cFy = false;
                            AppMethodBeat.o(76721);
                            return;
                        } catch (Exception e) {
                            ab.e("MicroMsg.MMSightRemuxMediaCodecEncoder", "do stop encoder error: %s", e.getMessage());
                            AppMethodBeat.o(76721);
                            return;
                        }
                    }
                    ab.e("MicroMsg.MMSightRemuxMediaCodecEncoder", "reached end of stream unexpectedly");
                    AppMethodBeat.o(76721);
                    return;
                }
            }
            this.fXX = this.eVq.dequeueOutputBuffer(this.eTy, 600);
            if (this.fXX <= 0) {
                ab.v("MicroMsg.MMSightRemuxMediaCodecEncoder", "get outputBufferIndex %d", Integer.valueOf(this.fXX));
            }
            if (this.fXX < 0 && !this.fXY) {
                break;
            }
        }
        AppMethodBeat.o(76721);
    }

    private static int a(MediaCodecInfo mediaCodecInfo, String str) {
        AppMethodBeat.i(76722);
        long yz = bo.yz();
        CodecCapabilities capabilitiesForType = mediaCodecInfo.getCapabilitiesForType(str);
        ab.i("MicroMsg.MMSightRemuxMediaCodecEncoder", "getCapabilitiesForType used %sms", Long.valueOf(bo.az(yz)));
        ab.i("MicroMsg.MMSightRemuxMediaCodecEncoder", "color format length: %s", Integer.valueOf(capabilitiesForType.colorFormats.length));
        int i = 0;
        for (int i2 : capabilitiesForType.colorFormats) {
            ab.i("MicroMsg.MMSightRemuxMediaCodecEncoder", "capabilities colorFormat: %s", Integer.valueOf(i2));
            if (mr(i2) && i2 > i) {
                if (i2 == 19) {
                    break;
                }
                i = i2;
            }
        }
        int i22 = i;
        ab.i("MicroMsg.MMSightRemuxMediaCodecEncoder", "codec: %s, colorFormat: %s", mediaCodecInfo.getName(), Integer.valueOf(i22));
        AppMethodBeat.o(76722);
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
        AppMethodBeat.i(76723);
        int codecCount = MediaCodecList.getCodecCount();
        for (int i = 0; i < codecCount; i++) {
            MediaCodecInfo codecInfoAt = MediaCodecList.getCodecInfoAt(i);
            if (codecInfoAt.isEncoder()) {
                String[] supportedTypes = codecInfoAt.getSupportedTypes();
                for (String equalsIgnoreCase : supportedTypes) {
                    if (equalsIgnoreCase.equalsIgnoreCase(str)) {
                        AppMethodBeat.o(76723);
                        return codecInfoAt;
                    }
                }
                continue;
            }
        }
        AppMethodBeat.o(76723);
        return null;
    }
}
