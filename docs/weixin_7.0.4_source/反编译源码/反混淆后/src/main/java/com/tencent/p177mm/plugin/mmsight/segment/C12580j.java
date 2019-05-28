package com.tencent.p177mm.plugin.mmsight.segment;

import android.annotation.TargetApi;
import android.graphics.ImageFormat;
import android.media.Image;
import android.media.Image.Plane;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaCodecInfo;
import android.media.MediaCodecInfo.CodecCapabilities;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.mmsight.model.p456a.C43305j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.nio.ByteBuffer;

@TargetApi(21)
/* renamed from: com.tencent.mm.plugin.mmsight.segment.j */
public final class C12580j extends C28517i {
    public static String TAG = "MicroMsg.MediaCodecTranscodeDecoder21";

    public C12580j(MediaExtractor mediaExtractor, MediaFormat mediaFormat, int i) {
        super(mediaExtractor, mediaFormat, i);
        AppMethodBeat.m2504i(3674);
        C4990ab.m7416i(TAG, "init ");
        AppMethodBeat.m2505o(3674);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: a */
    public final int mo24514a(MediaCodecInfo mediaCodecInfo, String str) {
        AppMethodBeat.m2504i(3675);
        C4990ab.m7417i(TAG, "selectColorFormat, mimeType: %s, codecInfo: %s", str, mediaCodecInfo);
        long yz = C5046bo.m7588yz();
        CodecCapabilities capabilitiesForType = mediaCodecInfo.getCapabilitiesForType(str);
        C4990ab.m7417i(TAG, "getCapabilitiesForType used %sms", Long.valueOf(C5046bo.m7525az(yz)));
        C4990ab.m7417i(TAG, "color format length: %s", Integer.valueOf(capabilitiesForType.colorFormats.length));
        int i = 0;
        for (int i2 : capabilitiesForType.colorFormats) {
            C4990ab.m7417i(TAG, "capabilities colorFormat: %s", Integer.valueOf(i2));
            if (mo24515mr(i2) && (i2 > i || i2 == 2135033992)) {
                i = i2;
            }
        }
        C4990ab.m7417i(TAG, "codec: %s, colorFormat: %s", mediaCodecInfo.getName(), Integer.valueOf(i));
        AppMethodBeat.m2505o(3675);
        return i;
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: mr */
    public final boolean mo24515mr(int i) {
        switch (i) {
            case 2135033992:
                return true;
            default:
                return false;
        }
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: UF */
    public final boolean mo24513UF() {
        AppMethodBeat.m2504i(3676);
        if (this.eTq == null) {
            C4990ab.m7412e(TAG, "drainDecoder, decoder is null");
            AppMethodBeat.m2505o(3676);
            return true;
        }
        int dequeueOutputBuffer = this.eTq.dequeueOutputBuffer(this.eTy, 60000);
        C4990ab.m7416i(TAG, "outputBufferIndex-->".concat(String.valueOf(dequeueOutputBuffer)));
        while (dequeueOutputBuffer != -1) {
            if (dequeueOutputBuffer == -3) {
                C4990ab.m7416i(TAG, "decoder output buffers changed");
            } else if (dequeueOutputBuffer == -2) {
                this.fYc = this.eTq.getOutputFormat();
                C4990ab.m7416i(TAG, "decoder output format changed: " + this.fYc);
            } else if (dequeueOutputBuffer < 0) {
                C4990ab.m7420w(TAG, "unexpected result from decoder.dequeueOutputBuffer: ".concat(String.valueOf(dequeueOutputBuffer)));
            } else {
                C4990ab.m7418v(TAG, "perform decoding");
                long yz = C5046bo.m7588yz();
                byte[] a = C12580j.m20514a(this.eTq.getOutputImage(dequeueOutputBuffer));
                C4990ab.m7419v(TAG, "perform decoding costImage %s", Long.valueOf(C5046bo.m7525az(yz)));
                if (a == null) {
                    break;
                } else if (a.length != 0) {
                    BufferInfo bufferInfo = this.eTy;
                    if (a == null) {
                        C4990ab.m7412e(TAG, "processDecodeOutputBuffer error! byteBuffer is null");
                    } else {
                        C4990ab.m7417i(TAG, "processDecodeOutputBuffer, byteBuffer: %s, bufferInfo: %s, size: %d", a, bufferInfo, Integer.valueOf(bufferInfo.size));
                        this.fYc = this.eTq.getOutputFormat();
                        if (this.oxF != null) {
                            this.oxF.mo24511ba(a);
                        }
                    }
                    this.eTq.releaseOutputBuffer(dequeueOutputBuffer, false);
                    long j = this.eTy.presentationTimeUs;
                    if (this.eTA != 1 && j >= this.eTA * 1000) {
                        C4990ab.m7412e(TAG, "exceed endTimeMs");
                        AppMethodBeat.m2505o(3676);
                        return true;
                    } else if ((this.eTy.flags & 4) != 0) {
                        C4990ab.m7416i(TAG, "receive end of stream");
                        try {
                            this.eTq.stop();
                            this.eTq.release();
                            this.eTq = null;
                        } catch (Exception e) {
                            C4990ab.m7413e(TAG, "stop and release decoder error: %s", e.getMessage());
                        }
                        AppMethodBeat.m2505o(3676);
                        return true;
                    } else {
                        AppMethodBeat.m2505o(3676);
                        return false;
                    }
                } else {
                    this.eTq.releaseOutputBuffer(dequeueOutputBuffer, false);
                }
            }
            dequeueOutputBuffer = this.eTq.dequeueOutputBuffer(this.eTy, 60000);
            if (dequeueOutputBuffer < 0) {
                break;
            }
        }
        C4990ab.m7416i(TAG, "no output from decoder available, break");
        AppMethodBeat.m2505o(3676);
        return false;
    }

    public final int alK() {
        return 2;
    }

    /* renamed from: a */
    private static byte[] m20514a(Image image) {
        int i;
        AppMethodBeat.m2504i(3677);
        int format = image.getFormat();
        int width = image.getWidth();
        int height = image.getHeight();
        int i2 = 0;
        Plane[] planes = image.getPlanes();
        C4990ab.m7417i(TAG, "planes len %d, datalen: %s width %d height %d format %d", Integer.valueOf(planes.length), Integer.valueOf(((width * height) * ImageFormat.getBitsPerPixel(format)) / 8), Integer.valueOf(width), Integer.valueOf(height), Integer.valueOf(format));
        byte[] g = C43305j.owk.mo68846g(Integer.valueOf(i));
        format = 0;
        while (true) {
            i = format;
            if (i < planes.length) {
                ByteBuffer buffer = planes[i].getBuffer();
                int rowStride = planes[i].getRowStride();
                int pixelStride = planes[i].getPixelStride();
                int i3 = i == 0 ? width : width / 2;
                format = i == 0 ? height : height / 2;
                C4990ab.m7419v(TAG, "row planes rowStride %d w %d h %d pixelStride %d", Integer.valueOf(rowStride), Integer.valueOf(i3), Integer.valueOf(format), Integer.valueOf(pixelStride));
                byte[] g2 = C43305j.owk.mo68846g(Integer.valueOf(rowStride));
                for (int i4 = 0; i4 < format; i4++) {
                    int bitsPerPixel = ImageFormat.getBitsPerPixel(35) / 8;
                    if (pixelStride == bitsPerPixel) {
                        bitsPerPixel *= i3;
                        buffer.get(g, i2, bitsPerPixel);
                        if (format - i4 != 1) {
                            buffer.position((buffer.position() + rowStride) - bitsPerPixel);
                        }
                        i2 += bitsPerPixel;
                    } else {
                        if (format - i4 == 1) {
                            buffer.get(g2, 0, (width - pixelStride) + 1);
                        } else {
                            buffer.get(g2, 0, rowStride);
                        }
                        bitsPerPixel = 0;
                        while (bitsPerPixel < i3) {
                            int i5 = i2 + 1;
                            g[i2] = g2[bitsPerPixel * pixelStride];
                            bitsPerPixel++;
                            i2 = i5;
                        }
                    }
                }
                C43305j.owk.mo68845g(g2);
                format = i + 1;
            } else {
                AppMethodBeat.m2505o(3677);
                return g;
            }
        }
    }
}
