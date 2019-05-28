package com.tencent.p177mm.plugin.voip.model;

import android.annotation.SuppressLint;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import android.os.Build.VERSION;
import android.view.Surface;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C6457e;
import com.tencent.p177mm.plugin.voip.model.C14047k.C140519;
import com.tencent.p177mm.protocal.protobuf.asn;
import com.tencent.p177mm.protocal.protobuf.aso;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* renamed from: com.tencent.mm.plugin.voip.model.d */
public final class C43732d extends Thread {
    public static int sNT = 64;
    private static String sNU = C6457e.eSn;
    public static byte[] sNW = null;
    public static byte[] sNX = null;
    public static byte[] sNY = null;
    public static int sOa = 640;
    public static int sOb = 480;
    private Surface aOO;
    public byte[] configbyte;
    private MediaCodec mDecoder;
    private BufferedOutputStream outputStream;
    private BufferedOutputStream sNV;
    private boolean sNZ;
    C14047k sNl;
    private boolean sOc;
    public boolean sOd;
    public boolean sOe;
    public boolean sOf;
    public int sOg;
    public byte[] sOh;
    public int sOi;
    public int sOj;
    public int sOk;
    public byte[] sOl;
    public byte[] sOm;
    public byte[] sOn;

    public C43732d(Surface surface) {
        AppMethodBeat.m2504i(4333);
        this.outputStream = null;
        this.sNV = null;
        this.configbyte = null;
        this.sNZ = false;
        this.sOc = false;
        this.sOd = true;
        this.sOe = true;
        this.sOf = false;
        this.sOg = 0;
        this.sNl = null;
        this.sOh = new byte[]{(byte) 0, (byte) 0, (byte) 0, (byte) 1};
        this.sOi = 0;
        this.sOj = 0;
        this.sOk = 0;
        this.sOl = new byte[]{(byte) 103, (byte) 100, (byte) 0, (byte) 13, (byte) -84, (byte) -74, (byte) 10, (byte) 15, (byte) -120};
        this.sOm = new byte[]{(byte) 0, (byte) 0, (byte) 0, (byte) 1, (byte) 40, (byte) -50, (byte) 60, (byte) 48};
        this.sOn = new byte[]{(byte) 13, (byte) 0, (byte) -15, (byte) 98, (byte) -22};
        this.sOd = true;
        this.sOe = true;
        this.mDecoder = null;
        this.sNZ = false;
        this.sOk = 0;
        if (surface != null) {
            this.aOO = surface;
        }
        AppMethodBeat.m2505o(4333);
    }

    /* renamed from: a */
    public final void mo69420a(C14047k c14047k) {
        AppMethodBeat.m2504i(4334);
        this.sNl = c14047k;
        C4990ab.m7416i("MeidaCodec[HWDec]", "setCallBack");
        AppMethodBeat.m2505o(4334);
    }

    private int cIu() {
        AppMethodBeat.m2504i(4335);
        this.sOg++;
        C4990ab.m7416i("MeidaCodec[HWDec]", "[HW]:DecFrmError: I Req mIReqFlag = " + this.sOf + ", mIsHWDecEnable = " + this.sOd + ", mHWErrorDecFrmCount = " + this.sOg);
        if (!this.sOd || this.sOg > sNT) {
            cIv();
            this.sNl.mo26326mq(true);
            this.sOk |= 64;
            C4990ab.m7416i("MeidaCodec[HWDec]", "[HW]: ErrFrm > threshold, end HWDec!!");
            AppMethodBeat.m2505o(4335);
            return 0;
        }
        ByteBuffer allocate = ByteBuffer.allocate(1);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        allocate.put((byte) 1);
        this.sNl.sPp.setAppCmd(28, allocate.array(), 1);
        this.sOf = true;
        AppMethodBeat.m2505o(4335);
        return 1;
    }

    /* renamed from: bm */
    private static String m78397bm(byte[] bArr) {
        AppMethodBeat.m2504i(4336);
        String str = "";
        for (byte b : bArr) {
            String toHexString = Integer.toHexString(b & 255);
            if (toHexString.length() == 1) {
                toHexString = AppEventsConstants.EVENT_PARAM_VALUE_NO.concat(String.valueOf(toHexString));
            }
            str = str + toHexString;
        }
        AppMethodBeat.m2505o(4336);
        return str;
    }

    /* renamed from: T */
    public final int mo69419T(byte[] bArr, int i) {
        AppMethodBeat.m2504i(4337);
        if (this.sOd) {
            int i2;
            int length;
            String bm;
            Object obj;
            byte[] bArr2;
            System.currentTimeMillis();
            int length2;
            if (i == 2) {
                try {
                    aso aso = (aso) new aso().parseFrom(bArr);
                    if (aso.wwf == null) {
                        i2 = 0;
                    } else {
                        i2 = aso.wwf.f1226wR.length;
                    }
                    length2 = aso.wwd.f1226wR.length;
                    length = aso.wwe.f1226wR.length;
                    if (i2 != 0) {
                        if (!this.sNZ) {
                            this.sOc = false;
                        }
                        this.sNZ = true;
                        sNW = new byte[(i2 + 4)];
                        sNX = new byte[(length2 + 4)];
                        sNY = new byte[(length + 4)];
                        System.arraycopy(this.sOh, 0, sNW, 0, 4);
                        System.arraycopy(this.sOh, 0, sNX, 0, 4);
                        System.arraycopy(this.sOh, 0, sNY, 0, 4);
                        aso.wwf.mo4676bJ(sNW);
                        aso.wwd.mo4676bJ(sNX);
                        aso.wwe.mo4676bJ(sNY);
                        this.configbyte = new byte[((sNW.length + sNX.length) + sNY.length)];
                        System.arraycopy(sNW, 0, this.configbyte, 0, sNW.length);
                        int length3 = sNW.length + 0;
                        System.arraycopy(sNX, 0, this.configbyte, length3, sNX.length);
                        System.arraycopy(sNY, 0, this.configbyte, length3 + sNX.length, sNY.length);
                    } else {
                        if (this.sNZ) {
                            this.sOc = false;
                        }
                        this.sNZ = false;
                        byte[] bArr3 = new byte[(length2 + 4)];
                        System.arraycopy(this.sOh, 0, bArr3, 0, 4);
                        aso.wwd.mo4676bJ(bArr3);
                        C4990ab.m7410d("MeidaCodec[HWDec]", " old sps: ".concat(String.valueOf(bArr3)));
                        byte[] bArr4 = new byte[]{(byte) 0, (byte) 0, (byte) 3};
                        String bm2 = C43732d.m78397bm(bArr3);
                        bm = C43732d.m78397bm(bArr4);
                        C4990ab.m7410d("MeidaCodec[HWDec]", "parent: " + bm2 + ", child:" + bm);
                        i2 = bm2.indexOf(bm, 0);
                        if (i2 != -1) {
                            C4990ab.m7410d("MeidaCodec[HWDec]", "hack code detected!!pos: ".concat(String.valueOf(i2)));
                            obj = 1;
                        } else {
                            obj = null;
                        }
                        if (obj != null) {
                            C4990ab.m7416i("MeidaCodec[HWDec]", " Hack code existed!! NO modify ");
                            sNX = bArr3;
                        } else {
                            C46322g c46322g = new C46322g();
                            sNX = C46322g.m87001F(new ByteArrayInputStream(bArr3));
                        }
                        C4990ab.m7410d("MeidaCodec[HWDec]", " Parsing protobuf, spsLen = " + sNX.length + ", original=" + length2);
                        sNY = new byte[(length + 4)];
                        System.arraycopy(this.sOh, 0, sNY, 0, 4);
                        aso.wwe.mo4676bJ(sNY);
                        this.configbyte = new byte[(sNX.length + sNY.length)];
                        System.arraycopy(sNX, 0, this.configbyte, 0, sNX.length);
                        System.arraycopy(sNY, 0, this.configbyte, sNX.length + 0, sNY.length);
                    }
                    bArr2 = null;
                    obj = 1;
                } catch (Exception e) {
                    this.sOk |= 2;
                    C4990ab.m7412e("MeidaCodec[HWDec]", " sps/pps parsing error:" + e.toString());
                    bArr2 = null;
                    obj = null;
                }
            } else {
                try {
                    Object obj2;
                    asn asn = (asn) new asn().parseFrom(bArr);
                    length = ((Integer) asn.wwb.getFirst()).intValue();
                    i2 = 0;
                    C4990ab.m7410d("MeidaCodec[HWDec]", " Parsing protobuf, framelen = ".concat(String.valueOf(length)));
                    if (i == 1) {
                        i2 = this.configbyte.length;
                        length2 = length + i2;
                        obj2 = new byte[length2];
                        System.arraycopy(this.configbyte, 0, obj2, 0, i2);
                        i2 += 0;
                    } else {
                        obj2 = new byte[length];
                        length2 = length;
                    }
                    int i3 = 0;
                    int i4 = length;
                    while (true) {
                        ByteBuffer allocate = ByteBuffer.allocate(4);
                        asn.wvY.mo4678f(allocate.array(), i3, 0, 4);
                        allocate.order(ByteOrder.BIG_ENDIAN);
                        int i5 = allocate.getInt(0);
                        System.arraycopy(this.sOh, 0, obj2, i3 + i2, 4);
                        length = i3 + 4;
                        asn.wvY.mo4678f(obj2, length, length + i2, i5);
                        length += i5;
                        i4 -= i5 + 4;
                        C4990ab.m7410d("MeidaCodec[HWDec]", "steve: nTmpLen :" + i5 + ", framelen:" + length2 + ", naluType:" + i);
                        if (i4 <= 0) {
                            break;
                        }
                        i3 = length;
                    }
                    Object bArr22 = obj2;
                    obj = null;
                } catch (Exception e2) {
                    this.sOk |= 4;
                    C4990ab.m7412e("MeidaCodec[HWDec]", " frame parsing error:" + e2.toString());
                    bArr22 = null;
                    obj = null;
                }
            }
            if (!(bArr22 == null || this.sNV == null)) {
                try {
                    this.sNV.write(bArr22, 0, bArr22.length);
                } catch (IOException e3) {
                    C4990ab.m7412e("MeidaCodec[HWDec]", " error:" + e3.toString());
                }
            }
            if (obj != null) {
                try {
                    if (!(sNX == null || sNY == null)) {
                        if (!this.sOc) {
                            MediaFormat createVideoFormat;
                            if (this.mDecoder != null) {
                                try {
                                    this.mDecoder.stop();
                                    this.mDecoder.release();
                                    this.mDecoder = null;
                                } catch (Exception e22) {
                                    C4990ab.m7412e("MeidaCodec[HWDec]", " decoder stop  error:" + e22.toString());
                                }
                            }
                            if (this.sNZ) {
                                createVideoFormat = MediaFormat.createVideoFormat("video/hevc", sOa, sOb);
                            } else {
                                createVideoFormat = MediaFormat.createVideoFormat("video/avc", sOa, sOb);
                            }
                            createVideoFormat.setInteger("rotation-degrees", 90);
                            C4990ab.m7416i("MeidaCodec[HWDec]", "create HW decoder, format : ".concat(String.valueOf(createVideoFormat)));
                            bm = createVideoFormat.getString("mime");
                            if (bm.startsWith("video/")) {
                                this.mDecoder = MediaCodec.createDecoderByType(bm);
                                try {
                                    C4990ab.m7410d("MeidaCodec[HWDec]", "configure, format : ".concat(String.valueOf(createVideoFormat)));
                                    this.mDecoder.configure(createVideoFormat, this.aOO, null, 0);
                                    this.mDecoder.start();
                                    this.sOc = true;
                                    start();
                                } catch (Exception e222) {
                                    this.sOk |= 8;
                                    C4990ab.m7412e("MeidaCodec[HWDec]", "codec '" + bm + "' failed configuration. " + e222);
                                    this.sOd = false;
                                    cIu();
                                    AppMethodBeat.m2505o(4337);
                                    return -1;
                                }
                            }
                        }
                        AppMethodBeat.m2505o(4337);
                        return 1;
                    }
                } catch (Exception e2222) {
                    this.sOk |= 16;
                    C4990ab.m7412e("MeidaCodec[HWDec]", " error:" + e2222.toString());
                }
            }
            if (this.sOc) {
                if (!this.sOe) {
                    this.sOe = true;
                }
                length = bArr22.length;
                i2 = bArr22[4] & 31;
                char c = (i2 == 7 || i2 == 8) ? 'S' : (i2 == 5 || i2 == 6) ? 'I' : 'P';
                C4990ab.m7410d("MeidaCodec[HWDec]", "steve: before dequeueInputBuffer, frameLen=" + length + ", fNalType=" + i2 + ", frmType=" + c + ", mInputCnt=" + this.sOj);
                if (this.sOf && c == 'P') {
                    C4990ab.m7412e("MeidaCodec[HWDec]", "DECODER_THREAD:: IRequest, not decodeable!");
                    AppMethodBeat.m2505o(4337);
                    return -2;
                }
                i2 = this.mDecoder.dequeueInputBuffer(10000);
                if (i2 < 0) {
                    if (this.sOf && c != 'P') {
                        this.sOd = false;
                        this.sOk |= 32;
                    }
                    cIu();
                    C4990ab.m7412e("MeidaCodec[HWDec]", "steve: fail to input data into mediacodec inputbuffer!!");
                } else if (bArr22 != null && length > 0) {
                    ByteBuffer byteBuffer;
                    long currentTimeMillis = System.currentTimeMillis();
                    C4990ab.m7410d("MeidaCodec[HWDec]", "steve: (10000us)put data into inputbuffer,idx=" + i2 + ", frameLen=" + length + ", frmType=" + c + ", inputpts=" + currentTimeMillis);
                    if (VERSION.SDK_INT < 21) {
                        byteBuffer = this.mDecoder.getInputBuffers()[i2];
                        byteBuffer.clear();
                    } else {
                        byteBuffer = this.mDecoder.getInputBuffer(i2);
                    }
                    byteBuffer.clear();
                    byteBuffer.put(bArr22, 0, length);
                    this.mDecoder.queueInputBuffer(i2, 0, length, currentTimeMillis, 0);
                    this.sOj++;
                    this.sOg = 0;
                    if (this.sOf) {
                        byteBuffer = ByteBuffer.allocate(1);
                        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
                        byteBuffer.put((byte) 0);
                        this.sNl.sPp.setAppCmd(28, byteBuffer.array(), 1);
                        this.sOf = false;
                    }
                }
                AppMethodBeat.m2505o(4337);
                return 0;
            }
            C4990ab.m7412e("MeidaCodec[HWDec]", "DECODER_THREAD:: decoder not ready yet");
            AppMethodBeat.m2505o(4337);
            return -1;
        }
        this.sOk |= 1;
        C4990ab.m7410d("TAG", "DECODER_THREAD:: HWDec NOT supported!");
        AppMethodBeat.m2505o(4337);
        return -1;
    }

    /* Code decompiled incorrectly, please refer to instructions dump. */
    @SuppressLint({"NewApi"})
    public final void run() {
        AppMethodBeat.m2504i(4338);
        while (!Thread.interrupted() && this.sOd) {
            if (this.mDecoder != null && this.sOc && this.sOe) {
                try {
                    BufferInfo bufferInfo = new BufferInfo();
                    int dequeueOutputBuffer = this.mDecoder.dequeueOutputBuffer(bufferInfo, 10000);
                    C4990ab.m7410d("MeidaCodec[HWDec]", "steve:  outIndex=".concat(String.valueOf(dequeueOutputBuffer)));
                    switch (dequeueOutputBuffer) {
                        case -3:
                            C4990ab.m7410d("MeidaCodec[HWDec]", "INFO_OUTPUT_BUFFERS_CHANGED");
                            break;
                        case -2:
                            MediaFormat outputFormat = this.mDecoder.getOutputFormat();
                            C4990ab.m7416i("MeidaCodec[HWDec]", "DECODER_THREAD:: New format : ".concat(String.valueOf(outputFormat)));
                            dequeueOutputBuffer = outputFormat.getInteger("width");
                            int integer = outputFormat.getInteger("height");
                            if (!(this.sNl == null || this.sNl.sPp == null)) {
                                C14047k c14047k = this.sNl;
                                c14047k.mHandler.post(new C140519(integer, dequeueOutputBuffer));
                                break;
                            }
                        case -1:
                            C4990ab.m7410d("MeidaCodec[HWDec]", "DECODER_THREAD:: dequeueOutputBuffer timed out!");
                            break;
                        default:
                            if (bufferInfo.size <= 0) {
                                C4990ab.m7410d("MeidaCodec[HWDec]", "steve: drop frame: " + this.sOi + ", size:" + bufferInfo.size + ", pts:" + bufferInfo.presentationTimeUs);
                                this.mDecoder.releaseOutputBuffer(dequeueOutputBuffer, false);
                                break;
                            }
                            long j = bufferInfo.presentationTimeUs;
                            C4990ab.m7410d("MeidaCodec[HWDec]", "DECODER_THREAD:: decoded SUCCESSFULLY!!! cnt : " + this.sOi + ", size:" + bufferInfo.size + ", pts:" + bufferInfo.presentationTimeUs + ", latency:" + (System.currentTimeMillis() - j));
                            this.sOi++;
                            this.mDecoder.releaseOutputBuffer(dequeueOutputBuffer, true);
                            long currentTimeMillis = System.currentTimeMillis();
                            C4990ab.m7410d("MeidaCodec[HWDec]", "steve: Avcdecoder frame processTime = " + (currentTimeMillis - j) + ", decFrameCnt=" + this.sOi + ", endTime=" + currentTimeMillis);
                            break;
                    }
                } catch (Exception e) {
                    this.sOd = false;
                    this.sOk |= 128;
                    cIu();
                    C4990ab.m7412e("MeidaCodec[HWDec]", " dequeueOutputBuffer/releaseOutputBuffer error:" + e.toString());
                }
            } else {
                try {
                    Thread.sleep(20);
                } catch (InterruptedException e2) {
                    C4990ab.m7412e("MeidaCodec[HWDec]", " error:" + e2.toString());
                }
            }
        }
        if (!(this.sOd || this.mDecoder == null)) {
            try {
                this.mDecoder.stop();
                this.mDecoder.release();
                this.mDecoder = null;
                AppMethodBeat.m2505o(4338);
                return;
            } catch (Exception e3) {
                C4990ab.m7412e("MeidaCodec[HWDec]", " decoder stop  error:" + e3.toString());
            }
        }
        AppMethodBeat.m2505o(4338);
    }

    public final void cIv() {
        AppMethodBeat.m2504i(4339);
        this.sOd = false;
        this.sOe = false;
        this.sOg = 0;
        C4990ab.m7410d("MeidaCodec[HWDec]", "steve: Stop Decode Thread!");
        try {
            if (this.outputStream != null) {
                this.outputStream.flush();
                this.outputStream.close();
            }
            if (this.sNV != null) {
                this.sNV.flush();
                this.sNV.close();
            }
            AppMethodBeat.m2505o(4339);
        } catch (IOException e) {
            C4990ab.m7412e("MeidaCodec[HWDec]", " error:" + e.toString());
            AppMethodBeat.m2505o(4339);
        }
    }
}
