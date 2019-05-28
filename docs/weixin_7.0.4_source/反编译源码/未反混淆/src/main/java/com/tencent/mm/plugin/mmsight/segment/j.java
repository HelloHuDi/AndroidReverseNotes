package com.tencent.mm.plugin.mmsight.segment;

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
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.nio.ByteBuffer;

@TargetApi(21)
public final class j extends i {
    public static String TAG = "MicroMsg.MediaCodecTranscodeDecoder21";

    public j(MediaExtractor mediaExtractor, MediaFormat mediaFormat, int i) {
        super(mediaExtractor, mediaFormat, i);
        AppMethodBeat.i(3674);
        ab.i(TAG, "init ");
        AppMethodBeat.o(3674);
    }

    /* Access modifiers changed, original: protected|final */
    public final int a(MediaCodecInfo mediaCodecInfo, String str) {
        AppMethodBeat.i(3675);
        ab.i(TAG, "selectColorFormat, mimeType: %s, codecInfo: %s", str, mediaCodecInfo);
        long yz = bo.yz();
        CodecCapabilities capabilitiesForType = mediaCodecInfo.getCapabilitiesForType(str);
        ab.i(TAG, "getCapabilitiesForType used %sms", Long.valueOf(bo.az(yz)));
        ab.i(TAG, "color format length: %s", Integer.valueOf(capabilitiesForType.colorFormats.length));
        int i = 0;
        for (int i2 : capabilitiesForType.colorFormats) {
            ab.i(TAG, "capabilities colorFormat: %s", Integer.valueOf(i2));
            if (mr(i2) && (i2 > i || i2 == 2135033992)) {
                i = i2;
            }
        }
        ab.i(TAG, "codec: %s, colorFormat: %s", mediaCodecInfo.getName(), Integer.valueOf(i));
        AppMethodBeat.o(3675);
        return i;
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean mr(int i) {
        switch (i) {
            case 2135033992:
                return true;
            default:
                return false;
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean UF() {
        AppMethodBeat.i(3676);
        if (this.eTq == null) {
            ab.e(TAG, "drainDecoder, decoder is null");
            AppMethodBeat.o(3676);
            return true;
        }
        int dequeueOutputBuffer = this.eTq.dequeueOutputBuffer(this.eTy, 60000);
        ab.i(TAG, "outputBufferIndex-->".concat(String.valueOf(dequeueOutputBuffer)));
        while (dequeueOutputBuffer != -1) {
            if (dequeueOutputBuffer == -3) {
                ab.i(TAG, "decoder output buffers changed");
            } else if (dequeueOutputBuffer == -2) {
                this.fYc = this.eTq.getOutputFormat();
                ab.i(TAG, "decoder output format changed: " + this.fYc);
            } else if (dequeueOutputBuffer < 0) {
                ab.w(TAG, "unexpected result from decoder.dequeueOutputBuffer: ".concat(String.valueOf(dequeueOutputBuffer)));
            } else {
                ab.v(TAG, "perform decoding");
                long yz = bo.yz();
                byte[] a = a(this.eTq.getOutputImage(dequeueOutputBuffer));
                ab.v(TAG, "perform decoding costImage %s", Long.valueOf(bo.az(yz)));
                if (a == null) {
                    break;
                } else if (a.length != 0) {
                    BufferInfo bufferInfo = this.eTy;
                    if (a == null) {
                        ab.e(TAG, "processDecodeOutputBuffer error! byteBuffer is null");
                    } else {
                        ab.i(TAG, "processDecodeOutputBuffer, byteBuffer: %s, bufferInfo: %s, size: %d", a, bufferInfo, Integer.valueOf(bufferInfo.size));
                        this.fYc = this.eTq.getOutputFormat();
                        if (this.oxF != null) {
                            this.oxF.ba(a);
                        }
                    }
                    this.eTq.releaseOutputBuffer(dequeueOutputBuffer, false);
                    long j = this.eTy.presentationTimeUs;
                    if (this.eTA != 1 && j >= this.eTA * 1000) {
                        ab.e(TAG, "exceed endTimeMs");
                        AppMethodBeat.o(3676);
                        return true;
                    } else if ((this.eTy.flags & 4) != 0) {
                        ab.i(TAG, "receive end of stream");
                        try {
                            this.eTq.stop();
                            this.eTq.release();
                            this.eTq = null;
                        } catch (Exception e) {
                            ab.e(TAG, "stop and release decoder error: %s", e.getMessage());
                        }
                        AppMethodBeat.o(3676);
                        return true;
                    } else {
                        AppMethodBeat.o(3676);
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
        ab.i(TAG, "no output from decoder available, break");
        AppMethodBeat.o(3676);
        return false;
    }

    public final int alK() {
        return 2;
    }

    private static byte[] a(Image image) {
        int i;
        AppMethodBeat.i(3677);
        int format = image.getFormat();
        int width = image.getWidth();
        int height = image.getHeight();
        int i2 = 0;
        Plane[] planes = image.getPlanes();
        ab.i(TAG, "planes len %d, datalen: %s width %d height %d format %d", Integer.valueOf(planes.length), Integer.valueOf(((width * height) * ImageFormat.getBitsPerPixel(format)) / 8), Integer.valueOf(width), Integer.valueOf(height), Integer.valueOf(format));
        byte[] g = com.tencent.mm.plugin.mmsight.model.a.j.owk.g(Integer.valueOf(i));
        format = 0;
        while (true) {
            i = format;
            if (i < planes.length) {
                ByteBuffer buffer = planes[i].getBuffer();
                int rowStride = planes[i].getRowStride();
                int pixelStride = planes[i].getPixelStride();
                int i3 = i == 0 ? width : width / 2;
                format = i == 0 ? height : height / 2;
                ab.v(TAG, "row planes rowStride %d w %d h %d pixelStride %d", Integer.valueOf(rowStride), Integer.valueOf(i3), Integer.valueOf(format), Integer.valueOf(pixelStride));
                byte[] g2 = com.tencent.mm.plugin.mmsight.model.a.j.owk.g(Integer.valueOf(rowStride));
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
                com.tencent.mm.plugin.mmsight.model.a.j.owk.g(g2);
                format = i + 1;
            } else {
                AppMethodBeat.o(3677);
                return g;
            }
        }
    }
}
