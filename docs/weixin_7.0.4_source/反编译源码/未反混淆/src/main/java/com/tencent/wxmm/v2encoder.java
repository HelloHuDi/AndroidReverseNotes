package com.tencent.wxmm;

import android.annotation.SuppressLint;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaCodecInfo;
import android.media.MediaCodecInfo.CodecCapabilities;
import android.media.MediaCodecInfo.CodecProfileLevel;
import android.media.MediaCodecInfo.EncoderCapabilities;
import android.media.MediaCodecList;
import android.media.MediaFormat;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
import com.google.android.gms.common.Scopes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;

public class v2encoder {
    public static int EMethodGetQosPara = 25;
    public static final int EMethodGetRemoteHW = 26;
    public static final int ENUM_AVCEncCfgERROR = 2003;
    public static final int ENUM_AVCEncCreateERROR = 2002;
    public static final int ENUM_AVCEncERROR = 2004;
    public static final int ENUM_AVCEncNotFound = 2001;
    public static final int ENUM_AVCEncOK = 2000;
    public static final boolean SAVEVIDEOSTREAM = true;
    public static short[] SizeFormat2WH = new short[]{(short) 128, (short) 96, (short) 240, (short) 160, (short) 320, (short) 240, (short) 480, (short) 360, (short) 640, (short) 480};
    private static final String TAG = "v2encoder";
    public static final int VFMT_420SP = 7;
    public static final int VFMT_HEVC_HW = 19;
    public static final int VFMT_ROTATE = 32;
    public static final int VFMT_i264 = 18;
    public static final byte enumCODEC_Vcodec2_hw = (byte) 4;
    public static final byte enumCODEC_f264 = (byte) 1;
    public static final byte enumCODEC_i264 = (byte) 8;
    public static final byte enumCODEC_vcodec2 = (byte) 16;
    public static int frameID = 0;
    private static String path = Environment.getExternalStorageDirectory().getAbsolutePath();
    private static int streamqueuesize = 100;
    private static final String[] supportedH264HwCodecPrefixes = new String[]{"OMX.qcom.", "OMX.Exynos.", "OMX.hisi"};
    public String ENCODING = "hevc";
    private int TIMEOUT_USEC = 12000;
    public byte[] configbyte = null;
    public int encLen = 0;
    public boolean isRuning = false;
    public long mGeneratedIdx = 0;
    int mPrevResolution = 8;
    int mProfileCfg = 1;
    public v2service mProtocol;
    int m_CapH;
    int m_CapW;
    int m_br_kbps;
    int m_framerate;
    int m_height;
    int m_width;
    private MediaCodec mediaCodec = null;
    protected MediaFormat mediaFormat;
    private BufferedOutputStream outputStream;
    v2stqos stQoS;

    public static class Frame {
        public byte[] frameData = null;
        public int id;
        public int type = 0;

        public Frame(int i) {
            this.id = i;
        }
    }

    static {
        AppMethodBeat.i(35413);
        AppMethodBeat.o(35413);
    }

    @SuppressLint({"NewApi"})
    private boolean SupportAvcCodec(String str, int i) {
        AppMethodBeat.i(35397);
        boolean z = false;
        if (VERSION.SDK_INT >= 18) {
            for (int codecCount = MediaCodecList.getCodecCount() - 1; codecCount >= 0; codecCount--) {
                MediaCodecInfo codecInfoAt = MediaCodecList.getCodecInfoAt(codecCount);
                new StringBuilder("codecInfo : ").append(codecInfoAt.getName());
                if (codecInfoAt.isEncoder()) {
                    String[] supportedTypes = codecInfoAt.getSupportedTypes();
                    String name = codecInfoAt.getName();
                    for (String equalsIgnoreCase : supportedTypes) {
                        if (equalsIgnoreCase.equalsIgnoreCase(str)) {
                            for (String equalsIgnoreCase2 : supportedH264HwCodecPrefixes) {
                                if (name.startsWith(equalsIgnoreCase2)) {
                                    try {
                                        for (CodecProfileLevel codecProfileLevel : codecInfoAt.getCapabilitiesForType(str).profileLevels) {
                                            if (codecProfileLevel.profile == i) {
                                                z = true;
                                            }
                                            new StringBuilder("steve : supported profiles:").append(codecProfileLevel.profile).append(", MIME:").append(str);
                                        }
                                    } catch (Exception e) {
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        AppMethodBeat.o(35397);
        return z;
    }

    private MediaCodecInfo selectCodec(String str) {
        AppMethodBeat.i(35398);
        int codecCount = MediaCodecList.getCodecCount();
        for (int i = 0; i < codecCount; i++) {
            MediaCodecInfo codecInfoAt = MediaCodecList.getCodecInfoAt(i);
            if (codecInfoAt.isEncoder()) {
                String[] supportedTypes = codecInfoAt.getSupportedTypes();
                new StringBuilder("selectCodec one : ").append(i).append(supportedTypes);
                for (int i2 = 0; i2 < supportedTypes.length; i2++) {
                    if (supportedTypes[i2].equalsIgnoreCase(str)) {
                        new StringBuilder("selectCodec two : ").append(i2).append(codecInfoAt.getName());
                        AppMethodBeat.o(35398);
                        return codecInfoAt;
                    }
                }
                continue;
            }
        }
        AppMethodBeat.o(35398);
        return null;
    }

    private void trySetProfile(MediaCodecInfo mediaCodecInfo) {
        AppMethodBeat.i(35399);
        if (VERSION.SDK_INT >= 23) {
            try {
                CodecCapabilities capabilitiesForType = mediaCodecInfo.getCapabilitiesForType(this.ENCODING);
                if (capabilitiesForType != null) {
                    CodecProfileLevel[] codecProfileLevelArr = capabilitiesForType.profileLevels;
                    if (codecProfileLevelArr != null) {
                        CodecProfileLevel codecProfileLevel = new CodecProfileLevel();
                        codecProfileLevel.level = 0;
                        codecProfileLevel.profile = 0;
                        for (CodecProfileLevel codecProfileLevel2 : codecProfileLevelArr) {
                            int i = codecProfileLevel2.profile;
                            int i2 = codecProfileLevel2.level;
                            new StringBuilder("profile: ").append(i).append(", level: ").append(i2);
                            if (isRecognizedProfile(i) && i >= codecProfileLevel.profile && i2 >= codecProfileLevel.level) {
                                codecProfileLevel.profile = i;
                                codecProfileLevel.level = i2;
                            }
                        }
                        new StringBuilder("best profile: ").append(codecProfileLevel.profile).append(", best level: ").append(codecProfileLevel.level);
                        if (codecProfileLevel.profile > 0 && codecProfileLevel.level >= 256) {
                            this.mediaFormat.setInteger(Scopes.PROFILE, codecProfileLevel.profile);
                            this.mediaFormat.setInteger("level", 256);
                        }
                    }
                }
                AppMethodBeat.o(35399);
                return;
            } catch (Exception e) {
                new StringBuilder("trySetProfile error: ").append(e.getMessage());
            }
        }
        AppMethodBeat.o(35399);
    }

    @SuppressLint({"NewApi"})
    private void trySetBitRateMode(MediaCodecInfo mediaCodecInfo) {
        AppMethodBeat.i(35400);
        try {
            if (VERSION.SDK_INT > 21) {
                CodecCapabilities capabilitiesForType = mediaCodecInfo.getCapabilitiesForType(this.ENCODING);
                if (capabilitiesForType != null) {
                    EncoderCapabilities encoderCapabilities = capabilitiesForType.getEncoderCapabilities();
                    if (encoderCapabilities != null) {
                        if (encoderCapabilities.isBitrateModeSupported(2)) {
                            this.mediaFormat.setInteger("bitrate-mode", 2);
                            AppMethodBeat.o(35400);
                            return;
                        } else if (encoderCapabilities.isBitrateModeSupported(1)) {
                            this.mediaFormat.setInteger("bitrate-mode", 1);
                        }
                    }
                }
            }
            AppMethodBeat.o(35400);
        } catch (Exception e) {
            new StringBuilder("trySetBitRateMode error: ").append(e.getMessage());
            AppMethodBeat.o(35400);
        }
    }

    private boolean isRecognizedProfile(int i) {
        switch (i) {
            case 1:
            case 2:
            case 8:
                return true;
            default:
                return false;
        }
    }

    @SuppressLint({"NewApi"})
    public int StartEncoder() {
        AppMethodBeat.i(35401);
        if (this.mediaCodec != null) {
            StopEncoder();
        }
        MediaCodecInfo selectCodec = selectCodec(this.ENCODING);
        if (selectCodec == null) {
            new StringBuilder("steve: Unable to find an appropriate codec for ").append(this.ENCODING);
            AppMethodBeat.o(35401);
            return -2001;
        }
        new StringBuilder("steve: found HW codec: ").append(selectCodec.getName());
        this.mediaFormat = MediaFormat.createVideoFormat(this.ENCODING, this.m_width, this.m_height);
        this.mediaFormat.setInteger("color-format", 21);
        this.mediaFormat.setInteger(FFmpegMetadataRetriever.METADATA_KEY_VARIANT_BITRATE, this.m_br_kbps * 1000);
        this.mediaFormat.setInteger("frame-rate", this.m_framerate);
        this.mediaFormat.setInteger("i-frame-interval", 1);
        String string = this.mediaFormat.getString("mime");
        if (this.ENCODING.equalsIgnoreCase("video/avc")) {
            int i = (this.mProfileCfg & 4) != 0 ? 1 : 0;
            if (VERSION.SDK_INT < 23 || i == 0) {
                if (selectCodec != null) {
                    trySetProfile(selectCodec);
                }
            } else if (SupportAvcCodec(string, 8)) {
                this.mediaFormat.setInteger(Scopes.PROFILE, 8);
            }
        }
        this.mediaFormat.setInteger("bitrate-mode", 2);
        try {
            this.mediaCodec = MediaCodec.createEncoderByType(string);
            new StringBuilder("steve: mediaFormat: ").append(this.mediaFormat);
            this.mediaCodec.configure(this.mediaFormat, null, null, 1);
            this.mediaCodec.start();
            AppMethodBeat.o(35401);
            return 2000;
        } catch (Exception e) {
            new StringBuilder(" error392:").append(e.toString());
            AppMethodBeat.o(35401);
            return -2002;
        }
    }

    public v2encoder(int i, int i2, int i3, int i4, int i5, v2service v2service) {
        AppMethodBeat.i(35402);
        this.m_width = i;
        this.m_height = i2;
        this.m_CapW = i;
        this.m_CapH = i2;
        this.mProtocol = v2service;
        this.m_framerate = i3;
        this.m_br_kbps = i4;
        this.mProfileCfg = i5;
        frameID = 0;
        this.mGeneratedIdx = 0;
        this.stQoS = new v2stqos();
        AppMethodBeat.o(35402);
    }

    public int InitHWEncoder(boolean z) {
        int StartEncoder;
        AppMethodBeat.i(35403);
        this.ENCODING = z ? "video/avc" : "video/hevc";
        byte[] bArr = new byte[4];
        bArr[0] = (byte) 0;
        this.mProtocol.setAppCmd(26, bArr, 4);
        new StringBuilder("InitHWEncoder remoteHW: ").append(bArr[0]).append(bArr[1]).append(bArr[2]).append(bArr[3]);
        if (z) {
            if ((bArr[0] & 1) == 0 && (bArr[0] & 8) == 0) {
                AppMethodBeat.o(35403);
                return -2;
            }
        } else if ((bArr[0] & 16) == 0 && (bArr[0] & 4) == 0) {
            AppMethodBeat.o(35403);
            return -3;
        }
        try {
            StartEncoder = StartEncoder();
        } catch (Exception e) {
            new StringBuilder("mediacodec init error: ").append(e.getMessage());
            StartEncoder = -2003;
        }
        if (StartEncoder < 0) {
            AppMethodBeat.o(35403);
            return StartEncoder;
        }
        createfile(path + "/AVLog/mediacodec.h264");
        AppMethodBeat.o(35403);
        return StartEncoder;
    }

    private void createfile(String str) {
        AppMethodBeat.i(35404);
        File file = new File(str);
        if (file.exists()) {
            file.delete();
        }
        try {
            this.outputStream = new BufferedOutputStream(new FileOutputStream(file));
            AppMethodBeat.o(35404);
        } catch (Exception e) {
            new StringBuilder(" error510:").append(e.toString());
            AppMethodBeat.o(35404);
        }
    }

    @SuppressLint({"NewApi"})
    private void StopEncoder() {
        AppMethodBeat.i(35405);
        try {
            if (this.mediaCodec != null) {
                this.mediaCodec.stop();
                this.mediaCodec.release();
            }
            AppMethodBeat.o(35405);
        } catch (Exception e) {
            new StringBuilder(" error523:").append(e.toString());
            AppMethodBeat.o(35405);
        }
    }

    public void UninitHWEncoder() {
        AppMethodBeat.i(35406);
        this.isRuning = false;
        try {
            StopEncoder();
            if (this.outputStream != null) {
                this.outputStream.flush();
                this.outputStream.close();
            }
            AppMethodBeat.o(35406);
        } catch (Exception e) {
            new StringBuilder(" error401:").append(e.toString());
            AppMethodBeat.o(35406);
        }
    }

    public int DoMediacodecEnc(byte[] bArr, int i) {
        int StartEncoder;
        int i2 = 0;
        AppMethodBeat.i(35407);
        byte[] bArr2 = null;
        new StringBuilder("steve: m_framerate: ").append(this.m_framerate).append(", m_br_kbps:").append(this.m_br_kbps).append(" cwh ").append(this.m_CapW).append(this.m_CapH).append(" ewh ").append(this.m_width).append(this.m_height);
        if (this.stQoS.cSkipFlag == (byte) 0) {
            bArr2 = new byte[(((this.m_CapW * this.m_CapH) * 3) / 2)];
            NV21ToNV12(bArr, bArr2, this.m_width, this.m_height, i & 32);
            this.encLen = ((this.m_width * this.m_height) * 3) >> 1;
            if (!(this.m_width == this.m_width && this.m_height == this.m_height)) {
                this.encLen = ((this.m_width * this.m_height) * 3) >> 1;
                try {
                    StartEncoder = StartEncoder();
                } catch (Exception e) {
                    new StringBuilder("mediacodec init error: ").append(e.getMessage());
                    StartEncoder = -2003;
                }
                if (StartEncoder < 0) {
                    UninitHWEncoder();
                    AppMethodBeat.o(35407);
                    return StartEncoder;
                }
                i2 = StartEncoder;
            }
        }
        if (bArr2 != null) {
            try {
                long currentTimeMillis = System.currentTimeMillis();
                ByteBuffer[] inputBuffers = this.mediaCodec.getInputBuffers();
                ByteBuffer[] outputBuffers = this.mediaCodec.getOutputBuffers();
                int dequeueInputBuffer = this.mediaCodec.dequeueInputBuffer(-1);
                if (dequeueInputBuffer >= 0) {
                    long computePresentationTime = computePresentationTime(this.mGeneratedIdx);
                    ByteBuffer byteBuffer = inputBuffers[dequeueInputBuffer];
                    byteBuffer.clear();
                    byteBuffer.put(bArr2, 0, this.encLen);
                    this.mediaCodec.queueInputBuffer(dequeueInputBuffer, 0, this.encLen, computePresentationTime, 0);
                    this.mGeneratedIdx++;
                }
                BufferInfo bufferInfo = new BufferInfo();
                dequeueInputBuffer = this.mediaCodec.dequeueOutputBuffer(bufferInfo, (long) this.TIMEOUT_USEC);
                new StringBuilder("put YUV into encoder, size:").append(this.encLen).append(", idx:").append(frameID).append(", time:").append(currentTimeMillis).append("outbuf: ").append(dequeueInputBuffer);
                StartEncoder = i2;
                while (dequeueInputBuffer >= 0) {
                    new StringBuilder("Get H264 Buffer Success! flag = ").append(bufferInfo.flags).append(", enc size = ").append(bufferInfo.size).append(",pts = ").append(bufferInfo.presentationTimeUs);
                    byte[] bArr3 = new byte[bufferInfo.size];
                    outputBuffers[dequeueInputBuffer].get(bArr3);
                    if (this.outputStream != null) {
                        this.outputStream.write(bArr3, 0, bArr3.length);
                    }
                    putH2645Data(bArr3, bufferInfo.flags, bArr3.length);
                    new StringBuilder("Protobuf  ").append(bufferInfo.size).append(" : ").append(bArr3.length);
                    StartEncoder = bufferInfo.flags;
                    frameID++;
                    this.mediaCodec.releaseOutputBuffer(dequeueInputBuffer, false);
                    dequeueInputBuffer = this.mediaCodec.dequeueOutputBuffer(bufferInfo, (long) this.TIMEOUT_USEC);
                }
            } catch (Exception e2) {
                new StringBuilder(" error495:").append(e2.toString());
                StartEncoder = -2004;
            }
        } else {
            StartEncoder = i2;
        }
        AppMethodBeat.o(35407);
        return StartEncoder;
    }

    public void DoQosSvrCtrl() {
        AppMethodBeat.i(35408);
        if (this.mProtocol != null) {
            if (this.mProtocol.setAppCmd(EMethodGetQosPara, this.stQoS.s2p, this.stQoS.s2p.length) >= 0) {
                this.stQoS.parseS2PData();
                this.stQoS.printS2P();
            }
            if (this.stQoS.iKbps != this.m_br_kbps) {
                SetBitRate(this.m_br_kbps);
                this.m_br_kbps = this.stQoS.iKbps;
                new StringBuilder("steve[QoS]: Update BR! frameID: ").append(frameID).append(", new_br: ").append(this.m_br_kbps);
            }
            if ((byte) 1 == this.stQoS.cIReqFlag) {
                MakeIFrame();
                new StringBuilder("steve[QoS]: Force I Frame! frameID: ").append(frameID);
            }
            if (this.stQoS.cFps != this.m_framerate) {
                this.m_framerate = this.stQoS.cFps;
            }
        }
        AppMethodBeat.o(35408);
    }

    @SuppressLint({"NewApi"})
    public boolean SetBitRate(int i) {
        AppMethodBeat.i(35409);
        try {
            if (this.mediaCodec != null) {
                Bundle bundle = new Bundle();
                bundle.putInt("video-bitrate", i * 1000);
                this.mediaCodec.setParameters(bundle);
                AppMethodBeat.o(35409);
                return true;
            }
        } catch (Exception e) {
            new StringBuilder("steve: setRates failed:").append(e);
        }
        AppMethodBeat.o(35409);
        return false;
    }

    @SuppressLint({"NewApi"})
    public void MakeIFrame() {
        AppMethodBeat.i(35410);
        if (this.mediaCodec != null) {
            Bundle bundle = new Bundle();
            bundle.putInt("request-sync", 0);
            this.mediaCodec.setParameters(bundle);
        }
        AppMethodBeat.o(35410);
    }

    public void putH2645Data(byte[] bArr, int i, int i2) {
        AppMethodBeat.i(35411);
        if (!(bArr == null || this.mProtocol == null)) {
            int i3 = 18;
            if (this.ENCODING.equalsIgnoreCase("video/hevc")) {
                i3 = 19;
            }
            this.mProtocol.videoEncodeToSend(bArr, i2, this.m_width, i, i3);
        }
        AppMethodBeat.o(35411);
    }

    private void NV21ToNV12(byte[] bArr, byte[] bArr2, int i, int i2, int i3) {
        int i4 = 0;
        AppMethodBeat.i(35412);
        if (bArr == null || bArr2 == null) {
            AppMethodBeat.o(35412);
            return;
        }
        int i5 = i * i2;
        if (i3 == 0) {
            System.arraycopy(bArr, 0, bArr2, 0, i5);
            while (i4 < i5 / 2) {
                bArr2[i5 + i4] = bArr[(i5 + i4) + 1];
                bArr2[(i5 + i4) + 1] = bArr[i5 + i4];
                i4 += 2;
            }
        } else {
            for (int i6 = 0; i6 < i5; i6++) {
                bArr2[i6] = bArr[(i5 - 1) - i6];
            }
            while (i4 < i5 / 2) {
                bArr2[i5 + i4] = bArr[(((i5 / 2) + i5) - 1) - i4];
                i4++;
            }
        }
        AppMethodBeat.o(35412);
    }

    private long computePresentationTime(long j) {
        return 132 + ((1000000 * j) / 15);
    }
}
