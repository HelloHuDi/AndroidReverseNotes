package com.tencent.mm.plugin.voip.model;

import android.annotation.SuppressLint;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaCodecInfo;
import android.media.MediaCodecInfo.CodecCapabilities;
import android.media.MediaCodecInfo.CodecProfileLevel;
import android.media.MediaCodecList;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import android.os.Build.VERSION;
import android.os.Bundle;
import com.facebook.appevents.AppEventsConstants;
import com.google.android.gms.common.Scopes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.b;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.protocal.protobuf.asn;
import com.tencent.mm.protocal.protobuf.aso;
import com.tencent.mm.protocal.protobuf.asp;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.rtmp.TXLiveConstants;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.LinkedList;

public final class e {
    public static int EMethodGetQosPara = 25;
    public static short[] SizeFormat2WH = new short[]{(short) 128, (short) 96, (short) 240, (short) 160, (short) 320, (short) 240, (short) 480, (short) 360, (short) 640, (short) 480};
    public static int VFMT_HEVC_HW = 19;
    public static int VFMT_i264 = 18;
    public static int frameID = 0;
    private static String path = com.tencent.mm.compatible.util.e.eSn;
    private static int streamqueuesize = 100;
    private static final String[] supportedH264HwCodecPrefixes = new String[]{"OMX.qcom.", "OMX.Exynos.", "OMX.hisi", "OMX.MTK"};
    public String ENCODING = "hevc";
    private int TIMEOUT_USEC = 12000;
    public byte[] configbyte = null;
    public int encLen = 0;
    public boolean isRuning = false;
    public long mGeneratedIdx = 0;
    private boolean mMuxerStarted;
    int mPrevResolution = 8;
    int mProfileCfg = 1;
    private int mTrackIndex;
    int m_CapH;
    int m_CapW;
    int m_br_kbps;
    int m_framerate;
    int m_height;
    int m_width;
    MediaCodec mediaCodec;
    protected MediaFormat mediaFormat;
    private BufferedOutputStream outputStream;
    k sNl = null;
    public int sOo = 0;
    private byte[] sOp = null;
    private MediaMuxer sOq;
    private BufferedOutputStream sOr;
    public LinkedList<asp> sOs = new LinkedList();
    public LinkedList<Integer> sOt = new LinkedList();
    g sOu = null;
    public int sOv = 0;
    public int sOw = 8;
    public int sOx = 0;
    public int sOy = 0;
    a sOz;

    class a {
        public byte cFps;
        public byte cHPPMaxLyr;
        public byte cIPeriod;
        public byte cIReqFlag;
        public byte cQPmax;
        public byte cQPmin;
        public byte cRSLevel;
        public byte cResolution;
        public byte cRsvd1;
        public byte cRsvd2;
        public byte cSkipFlag;
        public byte cSwitch;
        public short iKbps;
        public byte[] s2p = new byte[14];

        public a() {
            AppMethodBeat.i(4340);
            AppMethodBeat.o(4340);
        }
    }

    @SuppressLint({"NewApi"})
    private boolean b(MediaCodecInfo mediaCodecInfo, String str) {
        AppMethodBeat.i(4341);
        boolean z = false;
        if (VERSION.SDK_INT >= 18 && 8 <= this.sOw) {
            String name = mediaCodecInfo.getName();
            for (String startsWith : supportedH264HwCodecPrefixes) {
                if (name.startsWith(startsWith)) {
                    try {
                        for (CodecProfileLevel codecProfileLevel : mediaCodecInfo.getCapabilitiesForType(str).profileLevels) {
                            if (codecProfileLevel.profile == 8) {
                                z = true;
                            }
                            ab.d("MeidaCodec[HWEnc]", "steve : [" + name + "] supported profiles:" + codecProfileLevel.profile + ", maxAllowedProfile: " + this.sOw + ", MIME:" + str);
                        }
                    } catch (Exception e) {
                    }
                }
            }
        }
        AppMethodBeat.o(4341);
        return z;
    }

    private void a(MediaCodecInfo mediaCodecInfo, int i) {
        AppMethodBeat.i(4342);
        if (d.iW(23)) {
            try {
                CodecCapabilities capabilitiesForType = mediaCodecInfo.getCapabilitiesForType(this.ENCODING);
                if (capabilitiesForType != null) {
                    CodecProfileLevel[] codecProfileLevelArr = capabilitiesForType.profileLevels;
                    if (codecProfileLevelArr != null) {
                        CodecProfileLevel codecProfileLevel = new CodecProfileLevel();
                        codecProfileLevel.level = 0;
                        codecProfileLevel.profile = 0;
                        int length = codecProfileLevelArr.length;
                        int i2 = 0;
                        while (i2 < length) {
                            CodecProfileLevel codecProfileLevel2 = codecProfileLevelArr[i2];
                            int i3 = codecProfileLevel2.profile;
                            int i4 = codecProfileLevel2.level;
                            if (i3 <= i) {
                                Object obj;
                                ab.i("MeidaCodec[HWEnc]", "profile: " + i3 + ", level: " + i4);
                                switch (i3) {
                                    case 1:
                                    case 2:
                                    case 8:
                                        obj = 1;
                                        break;
                                    default:
                                        obj = null;
                                        break;
                                }
                                if (obj != null && i3 >= codecProfileLevel.profile && i4 >= codecProfileLevel.level) {
                                    codecProfileLevel.profile = i3;
                                    codecProfileLevel.level = i4;
                                }
                                i2++;
                            } else {
                                ab.i("MeidaCodec[HWEnc]", "best profile: " + codecProfileLevel.profile + ", best level: " + codecProfileLevel.level);
                                if (codecProfileLevel.profile > 0 && codecProfileLevel.level >= 256) {
                                    this.mediaFormat.setInteger(Scopes.PROFILE, codecProfileLevel.profile);
                                    this.mediaFormat.setInteger("level", 256);
                                }
                            }
                        }
                        ab.i("MeidaCodec[HWEnc]", "best profile: " + codecProfileLevel.profile + ", best level: " + codecProfileLevel.level);
                        this.mediaFormat.setInteger(Scopes.PROFILE, codecProfileLevel.profile);
                        this.mediaFormat.setInteger("level", 256);
                    }
                }
                AppMethodBeat.o(4342);
                return;
            } catch (Exception e) {
                ab.e("MeidaCodec[HWEnc]", "trySetProfile error: " + e.getMessage());
            }
        }
        AppMethodBeat.o(4342);
    }

    private static boolean b(MediaCodecInfo mediaCodecInfo) {
        boolean z = false;
        AppMethodBeat.i(4343);
        String name = mediaCodecInfo.getName();
        for (String startsWith : supportedH264HwCodecPrefixes) {
            if (name.startsWith(startsWith)) {
                z = true;
                ab.d("MeidaCodec[HWEnc]", "steve : known H.264 HW encoder :".concat(String.valueOf(name)));
                break;
            }
        }
        AppMethodBeat.o(4343);
        return z;
    }

    @SuppressLint({"NewApi"})
    private int cIw() {
        MediaCodecInfo codecInfoAt;
        int i;
        int i2 = 0;
        AppMethodBeat.i(4344);
        if (this.mediaCodec != null) {
            StopEncoder();
        }
        String str = this.ENCODING;
        int codecCount = MediaCodecList.getCodecCount();
        loop0:
        for (int i3 = 0; i3 < codecCount; i3++) {
            codecInfoAt = MediaCodecList.getCodecInfoAt(i3);
            if (codecInfoAt.isEncoder()) {
                String[] supportedTypes = codecInfoAt.getSupportedTypes();
                for (String equalsIgnoreCase : supportedTypes) {
                    if (equalsIgnoreCase.equalsIgnoreCase(str)) {
                        ab.d("MeidaCodec[HWEnc]", "steve : H.264 HW encoder found:".concat(String.valueOf(codecInfoAt.getName())));
                        break loop0;
                    }
                }
                continue;
            }
        }
        codecInfoAt = null;
        if (codecInfoAt == null) {
            ab.e("MeidaCodec[HWEnc]", "steve: Unable to find an appropriate codec for " + this.ENCODING);
            this.sOo = 2001;
            i = -this.sOo;
            AppMethodBeat.o(4344);
            return i;
        }
        ab.i("MeidaCodec[HWEnc]", "steve: found HW codec: " + codecInfoAt.getName());
        this.mediaFormat = MediaFormat.createVideoFormat(this.ENCODING, this.m_width, this.m_height);
        this.mediaFormat.setInteger("color-format", 21);
        this.mediaFormat.setInteger(FFmpegMetadataRetriever.METADATA_KEY_VARIANT_BITRATE, this.m_br_kbps * 1000);
        this.mediaFormat.setInteger("frame-rate", this.m_framerate);
        this.mediaFormat.setInteger("i-frame-interval", 4);
        String string = this.mediaFormat.getString("mime");
        this.sOv = 1;
        if (this.ENCODING.equalsIgnoreCase("video/avc") && b(codecInfoAt) && d.iW(23)) {
            i = (this.mProfileCfg <= 0 || (this.mProfileCfg & 1) == 0) ? 0 : 1;
            if (this.mProfileCfg > 0 && (this.mProfileCfg & 4) != 0) {
                i2 = 1;
            }
            boolean b = b(codecInfoAt, string);
            if (i2 != 0 && b) {
                this.mediaFormat.setInteger(Scopes.PROFILE, 8);
                this.mediaFormat.setInteger("level", 256);
            } else if (i != 0) {
                this.mediaFormat.setInteger(Scopes.PROFILE, 1);
                this.mediaFormat.setInteger("level", 256);
            } else if (codecInfoAt != null) {
                a(codecInfoAt, this.sOw);
            }
            this.sOv = this.mediaFormat.getInteger(Scopes.PROFILE);
        }
        this.mediaFormat.setInteger("bitrate-mode", 2);
        try {
            this.mediaCodec = MediaCodec.createEncoderByType(string);
            ab.i("MeidaCodec[HWEnc]", "steve: mediaFormat: " + this.mediaFormat + ", actProfile: " + this.sOv);
            this.mediaCodec.configure(this.mediaFormat, null, null, 1);
            this.mediaCodec.start();
            this.sOu = new g();
            AppMethodBeat.o(4344);
            return 2000;
        } catch (Exception e) {
            ab.e("MeidaCodec[HWEnc]", " error:" + e.toString());
            this.sOo = 2002;
            i = -this.sOo;
            AppMethodBeat.o(4344);
            return i;
        }
    }

    public e(int i, int i2, int i3, int i4, int i5, String str) {
        AppMethodBeat.i(4345);
        this.m_width = i;
        this.m_height = i2;
        this.m_CapW = i;
        this.m_CapH = i2;
        this.ENCODING = str;
        this.m_framerate = i3;
        this.m_br_kbps = i4;
        this.mProfileCfg = i5;
        frameID = 0;
        this.mGeneratedIdx = 0;
        this.sOz = new a();
        this.mediaCodec = null;
        this.sOw = 8;
        this.sOv = 0;
        this.sOx = 0;
        this.sOo = 0;
        asp asp = new asp();
        asp.wwg = 1;
        asp.wwh = 24;
        asp.wwi = 1;
        asp.wwj = 24;
        asp.wwk = 0;
        asp.wwl = 0;
        this.sOs.add(asp);
        this.sOt.add(Integer.valueOf(0));
        this.sOp = null;
        this.sOy = 0;
        AppMethodBeat.o(4345);
    }

    @SuppressLint({"NewApi"})
    private void StopEncoder() {
        AppMethodBeat.i(4346);
        try {
            if (this.mediaCodec != null) {
                this.mediaCodec.stop();
                this.mediaCodec.release();
            }
            AppMethodBeat.o(4346);
        } catch (Exception e) {
            ab.e("MeidaCodec[HWEnc]", " error:" + e.toString());
            AppMethodBeat.o(4346);
        }
    }

    public final void cIv() {
        AppMethodBeat.i(4347);
        this.isRuning = false;
        try {
            StopEncoder();
            if (this.outputStream != null) {
                this.outputStream.flush();
                this.outputStream.close();
            }
            if (this.sOr != null) {
                this.sOr.flush();
                this.sOr.close();
            }
            if (this.sOq != null) {
                this.sOq.stop();
                this.sOq.release();
            }
            AppMethodBeat.o(4347);
        } catch (Exception e) {
            ab.e("MeidaCodec[HWEnc]", " error:" + e.toString());
            AppMethodBeat.o(4347);
        }
    }

    private static String bm(byte[] bArr) {
        AppMethodBeat.i(4348);
        String str = "";
        for (byte b : bArr) {
            String toHexString = Integer.toHexString(b & 255);
            if (toHexString.length() == 1) {
                toHexString = AppEventsConstants.EVENT_PARAM_VALUE_NO.concat(String.valueOf(toHexString));
            }
            str = str + toHexString;
        }
        AppMethodBeat.o(4348);
        return str;
    }

    private static ArrayList<Integer> bn(byte[] bArr) {
        AppMethodBeat.i(4349);
        byte[] bArr2 = new byte[]{(byte) 0, (byte) 0, (byte) 0, (byte) 1};
        ArrayList arrayList = new ArrayList();
        int i = 0;
        String bm = bm(bArr);
        String bm2 = bm(bArr2);
        ab.d("MeidaCodec[HWEnc]", "parent: " + bm + ", child:" + bm2);
        while (true) {
            int indexOf = bm.indexOf(bm2, i);
            if (indexOf != -1) {
                ab.d("MeidaCodec[HWEnc]", "vps/sps/pps start: " + i + ", nextStartIdx:" + indexOf);
                i = bm2.length() + indexOf;
                arrayList.add(Integer.valueOf(indexOf / 2));
            } else {
                AppMethodBeat.o(4349);
                return arrayList;
            }
        }
    }

    public final int e(byte[] bArr, int i, int i2, int i3) {
        byte[] bArr2;
        int i4;
        AppMethodBeat.i(4350);
        int i5 = 0;
        if (!(i == this.m_CapW && i2 == this.m_CapH)) {
            this.m_CapW = i;
            this.m_CapH = i2;
        }
        if (this.sOp == null) {
            this.sOp = new byte[(((this.m_CapW * this.m_CapH) * 3) / 2)];
        }
        ab.d("MeidaCodec[HWEnc]", "steve: m_framerate: " + this.m_framerate + ", m_br_kbps:" + this.m_br_kbps);
        if (this.sOz.cSkipFlag == (byte) 0) {
            this.sNl.sPp.videoHWProcess(bArr, bArr.length, this.m_CapW, this.m_CapH, i3, this.sOp);
            bArr2 = this.sOp;
            if (this.m_width == this.sNl.sPp.field_HWEncW && this.m_height == this.sNl.sPp.field_HWEncH) {
                i4 = 0;
            } else {
                ab.d("MeidaCodec[HWEnc]", "restart encoder! clipWH:" + this.sNl.sPp.field_HWEncW + VideoMaterialUtil.CRAZYFACE_X + this.sNl.sPp.field_HWEncH + ", wh:" + this.m_width + VideoMaterialUtil.CRAZYFACE_X + this.m_height);
                this.m_width = this.sNl.sPp.field_HWEncW;
                this.m_height = this.sNl.sPp.field_HWEncH;
                this.encLen = ((this.m_width * this.m_height) * 3) >> 1;
                try {
                    i4 = cIw();
                } catch (Exception e) {
                    ab.e("MeidaCodec[HWEnc]", "mediacodec init error: " + e.getMessage());
                    this.sOo = 2003;
                    i4 = -this.sOo;
                }
                if (i4 < 0) {
                    ab.e("MeidaCodec[HWEnc]", "mediacodec init failed, stop HW encoding! ret: ".concat(String.valueOf(i4)));
                    cIv();
                    AppMethodBeat.o(4350);
                    return i4;
                }
            }
            if (frameID <= 100 && this.sOr != null) {
                try {
                    this.sOr.write(this.sOp, 0, this.encLen);
                    i5 = i4;
                } catch (Exception e2) {
                    ab.e("MeidaCodec[HWEnc]", " error:" + e2.toString());
                }
            }
            i5 = i4;
        } else {
            bArr2 = null;
        }
        if (bArr2 == null || this.mediaCodec == null) {
            i4 = this.sOy;
            this.sOy = i4 + 1;
            if (i4 > 5) {
                this.sOo = TXLiveConstants.PLAY_EVT_PLAY_END;
                i4 = -this.sOo;
            } else {
                i4 = i5;
            }
        } else {
            try {
                ByteBuffer byteBuffer;
                this.sOy = 0;
                ab.d("MeidaCodec[HWEnc]", "steve: put YUV into encoder, size:" + this.encLen + ", idx:" + frameID + ", time:" + System.currentTimeMillis());
                ByteBuffer[] inputBuffers = this.mediaCodec.getInputBuffers();
                ByteBuffer[] outputBuffers = this.mediaCodec.getOutputBuffers();
                int dequeueInputBuffer = this.mediaCodec.dequeueInputBuffer(-1);
                if (dequeueInputBuffer >= 0) {
                    long j = ((this.mGeneratedIdx * 1000000) / 15) + 132;
                    byteBuffer = inputBuffers[dequeueInputBuffer];
                    byteBuffer.clear();
                    byteBuffer.put(bArr2, 0, this.encLen);
                    this.mediaCodec.queueInputBuffer(dequeueInputBuffer, 0, this.encLen, j, 0);
                    this.mGeneratedIdx++;
                }
                BufferInfo bufferInfo = new BufferInfo();
                dequeueInputBuffer = this.mediaCodec.dequeueOutputBuffer(bufferInfo, (long) this.TIMEOUT_USEC);
                if (dequeueInputBuffer == -2) {
                    MediaFormat outputFormat = this.mediaCodec.getOutputFormat();
                    ab.i("MeidaCodec[HWEnc]", "steve: encoder output format changed: ".concat(String.valueOf(outputFormat)));
                    if (outputFormat.containsKey(FFmpegMetadataRetriever.METADATA_KEY_VARIANT_BITRATE) && ((double) outputFormat.getInteger(FFmpegMetadataRetriever.METADATA_KEY_VARIANT_BITRATE)) > ((double) (this.m_br_kbps * 1000)) * 1.5d) {
                        ab.e("MeidaCodec[HWEnc]", "steve: bitrate NOT match!! real:" + outputFormat.getInteger(FFmpegMetadataRetriever.METADATA_KEY_VARIANT_BITRATE) + ", target:" + this.m_br_kbps);
                        this.sOo = TXLiveConstants.PLAY_EVT_PLAY_LOADING;
                        i4 = -this.sOo;
                        AppMethodBeat.o(4350);
                        return i4;
                    }
                }
                i4 = i5;
                while (dequeueInputBuffer >= 0) {
                    ByteBuffer byteBuffer2 = outputBuffers[dequeueInputBuffer];
                    byte[] bArr3 = new byte[bufferInfo.size];
                    byteBuffer2.get(bArr3);
                    if (this.outputStream != null) {
                        this.outputStream.write(bArr3, 0, bArr3.length);
                    }
                    int i6;
                    if (bufferInfo.flags == 2) {
                        ArrayList bn = bn(bArr3);
                        aso aso = new aso();
                        int i7 = 0;
                        int i8 = 0;
                        int i9 = 0;
                        int i10 = 0;
                        i6 = 0;
                        i4 = 0;
                        if (bn.size() == 3 && this.ENCODING.equalsIgnoreCase("video/hevc")) {
                            i7 = ((Integer) bn.get(0)).intValue() + 4;
                            i9 = ((Integer) bn.get(1)).intValue() + 4;
                            i6 = ((Integer) bn.get(2)).intValue() + 4;
                            i8 = (i9 - i7) - 4;
                            i10 = (i6 - i9) - 4;
                            i4 = bufferInfo.size - i6;
                            aso.wwf = b.y(bArr3, i7, i8);
                        } else if (bn.size() == 2) {
                            i9 = ((Integer) bn.get(0)).intValue() + 4;
                            i6 = ((Integer) bn.get(1)).intValue() + 4;
                            i10 = (i6 - i9) - 4;
                            i4 = bufferInfo.size - i6;
                        }
                        ab.d("MeidaCodec[HWEnc]", "sps start: " + i9 + ", len:" + i10 + ", pps start:" + i6 + ", len:" + i4 + ", vps start: " + i7 + ", len:" + i8);
                        if (this.sOv == 1 || !this.sOu.G(new ByteArrayInputStream(bArr3))) {
                            aso.wwc = 4;
                            aso.wwd = b.y(bArr3, i9, i10);
                            aso.wwe = b.y(bArr3, i6, i4);
                            x(aso.toByteArray(), bufferInfo.flags, aso.toByteArray().length);
                        } else {
                            this.sOx = this.sOu.sOC;
                            this.sOw = 1;
                            ab.i("MeidaCodec[HWEnc]", "steve:B-frames exist in High Profile, reset to Baseline!!!,maxAllowedProfile:" + this.sOw + ", checkCodeForBSlice:" + this.sOx);
                            try {
                                i4 = cIw();
                            } catch (Exception e3) {
                                ab.e("MeidaCodec[HWEnc]", "mediacodec reinit error: " + e3.getMessage());
                                this.sOo = TXLiveConstants.PLAY_EVT_PLAY_PROGRESS;
                                i4 = -this.sOo;
                            }
                            AppMethodBeat.o(4350);
                            return i4;
                        }
                    }
                    if (this.sOv != 1) {
                        Object obj;
                        g gVar = this.sOu;
                        j jVar = new j(new ByteArrayInputStream(bArr3));
                        jVar.FY(8);
                        jVar.FY(8);
                        jVar.FY(8);
                        jVar.FY(8);
                        jVar.FY(8);
                        jVar.cIB();
                        i6 = jVar.cIA();
                        ab.d("TAG", "steve:slice_type:".concat(String.valueOf(i6)));
                        if (i6 == 1 || i6 == 6) {
                            gVar.sOC |= 8;
                            obj = 1;
                        } else {
                            obj = null;
                        }
                        if (obj != null) {
                            this.sOx = this.sOu.sOC;
                            this.sOw = 1;
                            ab.i("MeidaCodec[HWEnc]", "steve:B-frames exist in High Profile, reset to Baseline!!!,maxAllowedProfile:" + this.sOw + ", checkCodeForBSlice:" + this.sOx);
                            try {
                                i4 = cIw();
                            } catch (Exception e32) {
                                ab.e("MeidaCodec[HWEnc]", "mediacodec reinit error: " + e32.getMessage());
                                this.sOo = TXLiveConstants.PLAY_EVT_PLAY_PROGRESS;
                                i4 = -this.sOo;
                            }
                            AppMethodBeat.o(4350);
                            return i4;
                        }
                    }
                    byteBuffer = ByteBuffer.allocate(4);
                    byteBuffer.putInt(bufferInfo.size - 4);
                    System.arraycopy(byteBuffer.order(ByteOrder.BIG_ENDIAN).array(), 0, bArr3, 0, 4);
                    ab.d("MeidaCodec[HWEnc]", " type:" + bufferInfo.flags + ", size:" + bufferInfo.size + ", idx:" + frameID + ", time:" + System.currentTimeMillis());
                    asn asn = new asn();
                    asn.wvY = b.y(bArr3, 0, bufferInfo.size);
                    asn.wvZ = 1;
                    asn.wwa = this.sOs;
                    this.sOt.set(0, Integer.valueOf(bufferInfo.size));
                    asn.wwb = this.sOt;
                    x(asn.toByteArray(), bufferInfo.flags, asn.toByteArray().length);
                    if (this.mMuxerStarted && byteBuffer2 != null) {
                        this.sOq.writeSampleData(this.mTrackIndex, byteBuffer2, bufferInfo);
                    }
                    i5 = bufferInfo.flags;
                    frameID++;
                    this.mediaCodec.releaseOutputBuffer(dequeueInputBuffer, false);
                    dequeueInputBuffer = this.mediaCodec.dequeueOutputBuffer(bufferInfo, (long) this.TIMEOUT_USEC);
                    i4 = i5;
                }
            } catch (Exception e322) {
                ab.e("MeidaCodec[HWEnc]", " error:" + e322.toString());
                this.sOo = 2004;
                i4 = -this.sOo;
            }
        }
        AppMethodBeat.o(4350);
        return i4;
    }

    @SuppressLint({"NewApi"})
    public final boolean SetBitRate(int i) {
        AppMethodBeat.i(4351);
        try {
            if (this.mediaCodec != null) {
                Bundle bundle = new Bundle();
                int i2 = i * 1000;
                ab.v("MeidaCodec[HWEnc]", "steve: setRates: ".concat(String.valueOf(i2)));
                bundle.putInt("video-bitrate", i2);
                this.mediaCodec.setParameters(bundle);
                AppMethodBeat.o(4351);
                return true;
            }
        } catch (Exception e) {
            ab.e("MeidaCodec[HWEnc]", "steve: setRates failed:".concat(String.valueOf(e)));
        }
        AppMethodBeat.o(4351);
        return false;
    }

    private void x(byte[] bArr, int i, int i2) {
        AppMethodBeat.i(4352);
        if (!(bArr == null || this.sNl.sPp == null)) {
            int i3 = VFMT_i264;
            if (this.ENCODING.equalsIgnoreCase("video/hevc")) {
                i3 = VFMT_HEVC_HW;
            }
            int videoEncodeToSend = this.sNl.sPp.videoEncodeToSend(bArr, i2, this.m_width, i, i3);
            if (videoEncodeToSend > 0) {
                ab.d("MeidaCodec[HWEnc]", "steve: send successfully! frameLen = " + i2 + ", type = " + i + ", pkt cnt = " + videoEncodeToSend);
            }
        }
        AppMethodBeat.o(4352);
    }
}
