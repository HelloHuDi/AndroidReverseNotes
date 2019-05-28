package com.tencent.mm.plugin.mmsight.model.b;

import android.graphics.Point;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaCodecInfo;
import android.media.MediaCodecInfo.CodecCapabilities;
import android.media.MediaCodecList;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import java.nio.ByteBuffer;

public final class e implements a {
    protected long bqO;
    protected MediaExtractor clX;
    protected long eTA;
    protected int eTJ;
    protected MediaCodec eTq;
    protected BufferInfo eTy = new BufferInfo();
    protected int eWc = -1;
    protected String fUM = null;
    protected MediaFormat fYc;
    private byte[] fYd;
    private int frameCount = 0;
    protected h oxp;
    private boolean oxs = false;
    protected int sampleSize;

    public e() {
        AppMethodBeat.i(76705);
        AppMethodBeat.o(76705);
    }

    public final int e(String str, long j, long j2, int i) {
        AppMethodBeat.i(76706);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(76706);
            return -1;
        }
        ab.i("MicroMsg.MMSightRemuxMediaCodecDecoder", "initDecoder, srcFilePath: %s, startTime: %s, endTime: %s, videoFps: %s", str, Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i));
        try {
            int i2;
            this.clX = new MediaExtractor();
            this.clX.setDataSource(str);
            for (i2 = 0; i2 < this.clX.getTrackCount(); i2++) {
                MediaFormat trackFormat = this.clX.getTrackFormat(i2);
                if (trackFormat.getString("mime").toLowerCase().startsWith("video/")) {
                    this.eWc = i2;
                    this.fYc = trackFormat;
                    break;
                }
            }
            if (this.eWc < 0) {
                AppMethodBeat.o(76706);
                return -1;
            }
            this.fUM = str;
            this.bqO = j;
            this.eTA = j2;
            this.clX.selectTrack(this.eWc);
            String string = this.fYc.getString("mime");
            this.eTq = MediaCodec.createDecoderByType(string);
            MediaCodecInfo selectCodec = selectCodec(string);
            ab.i("MicroMsg.MMSightRemuxMediaCodecDecoder", "found codec: %s", selectCodec);
            if (selectCodec != null) {
                ab.i("MicroMsg.MMSightRemuxMediaCodecDecoder", "codec name: %s", selectCodec.getName());
                ab.i("MicroMsg.MMSightRemuxMediaCodecDecoder", "found colorFormat: %s", Integer.valueOf(a(selectCodec, string)));
                this.fYc.setInteger("color-format", i2);
            }
            this.eTq.configure(this.fYc, null, null, 0);
            this.eTq.start();
            AppMethodBeat.o(76706);
            return 0;
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.MMSightRemuxMediaCodecDecoder", e, "Init decoder failed : %s", e.getMessage());
            AppMethodBeat.o(76706);
            return -1;
        }
    }

    private static MediaCodecInfo selectCodec(String str) {
        AppMethodBeat.i(76707);
        int codecCount = MediaCodecList.getCodecCount();
        for (int i = 0; i < codecCount; i++) {
            MediaCodecInfo codecInfoAt = MediaCodecList.getCodecInfoAt(i);
            if (!codecInfoAt.isEncoder()) {
                String[] supportedTypes = codecInfoAt.getSupportedTypes();
                for (String equalsIgnoreCase : supportedTypes) {
                    if (equalsIgnoreCase.equalsIgnoreCase(str)) {
                        AppMethodBeat.o(76707);
                        return codecInfoAt;
                    }
                }
                continue;
            }
        }
        AppMethodBeat.o(76707);
        return null;
    }

    private static int a(MediaCodecInfo mediaCodecInfo, String str) {
        AppMethodBeat.i(76708);
        ab.i("MicroMsg.MMSightRemuxMediaCodecDecoder", "selectColorFormat, mimeType: %s, codecInfo: %s", str, mediaCodecInfo);
        long yz = bo.yz();
        CodecCapabilities capabilitiesForType = mediaCodecInfo.getCapabilitiesForType(str);
        ab.i("MicroMsg.MMSightRemuxMediaCodecDecoder", "getCapabilitiesForType used %sms", Long.valueOf(bo.az(yz)));
        ab.i("MicroMsg.MMSightRemuxMediaCodecDecoder", "color format length: %s", Integer.valueOf(capabilitiesForType.colorFormats.length));
        int i = 0;
        for (int i2 : capabilitiesForType.colorFormats) {
            int i3;
            ab.i("MicroMsg.MMSightRemuxMediaCodecDecoder", "capabilities colorFormat: %s", Integer.valueOf(i2));
            switch (i2) {
                case 19:
                case 21:
                    i3 = 1;
                    break;
                default:
                    i3 = 0;
                    break;
            }
            if (i3 != 0 && (i2 > i || i2 == 21)) {
                i = i2;
            }
        }
        ab.i("MicroMsg.MMSightRemuxMediaCodecDecoder", "codec: %s, colorFormat: %s", mediaCodecInfo.getName(), Integer.valueOf(i));
        AppMethodBeat.o(76708);
        return i;
    }

    private boolean UF() {
        AppMethodBeat.i(76709);
        if (this.eTq == null) {
            ab.e("MicroMsg.MMSightRemuxMediaCodecDecoder", "drainDecoder, decoder is null");
            AppMethodBeat.o(76709);
            return true;
        }
        ByteBuffer[] outputBuffers = this.eTq.getOutputBuffers();
        ab.i("MicroMsg.MMSightRemuxMediaCodecDecoder", "decoderOutputByteBuffers length: %s", Integer.valueOf(outputBuffers.length));
        int dequeueOutputBuffer = this.eTq.dequeueOutputBuffer(this.eTy, 60000);
        ab.i("MicroMsg.MMSightRemuxMediaCodecDecoder", "outputBufferIndex-->".concat(String.valueOf(dequeueOutputBuffer)));
        while (dequeueOutputBuffer != -1) {
            if (dequeueOutputBuffer != -3) {
                if (dequeueOutputBuffer != -2) {
                    if (dequeueOutputBuffer >= 0) {
                        ab.v("MicroMsg.MMSightRemuxMediaCodecDecoder", "perform decoding");
                        ByteBuffer byteBuffer = outputBuffers[dequeueOutputBuffer];
                        if (byteBuffer == null) {
                            break;
                        }
                        long j = this.eTy.presentationTimeUs;
                        if (j < this.bqO * 1000 && (this.eTy.flags & 4) == 0) {
                            this.eTq.releaseOutputBuffer(dequeueOutputBuffer, false);
                            ab.i("MicroMsg.MMSightRemuxMediaCodecDecoder", "decoder pts: %s, not reach start: %s", Long.valueOf(j), Long.valueOf(this.bqO * 1000));
                            AppMethodBeat.o(76709);
                            return false;
                        } else if (this.eTy.size != 0) {
                            byteBuffer.position(this.eTy.offset);
                            byteBuffer.limit(this.eTy.offset + this.eTy.size);
                            long yz = bo.yz();
                            BufferInfo bufferInfo = this.eTy;
                            if (byteBuffer == null) {
                                ab.e("MicroMsg.MMSightRemuxMediaCodecDecoder", "processDecodeOutputBuffer error! byteBuffer is null");
                            } else {
                                this.frameCount++;
                                if (this.eTJ <= 1 || this.frameCount % this.eTJ != 0) {
                                    if (this.fYd == null) {
                                        this.fYd = new byte[byteBuffer.remaining()];
                                    }
                                    long yz2 = bo.yz();
                                    try {
                                        this.fYc = this.eTq.getOutputFormat();
                                    } catch (Exception e) {
                                        ab.e("MicroMsg.MMSightRemuxMediaCodecDecoder", "get output format error");
                                    }
                                    byteBuffer.get(this.fYd, 0, byteBuffer.remaining());
                                    ab.i("MicroMsg.MMSightRemuxMediaCodecDecoder", "processDecodeOutputBuffer, byteBuffer: %s, bufferInfo: %s, size: %d cost %d", byteBuffer, bufferInfo, Integer.valueOf(bufferInfo.size), Long.valueOf(bo.az(yz2)));
                                    if (this.oxp != null) {
                                        boolean z;
                                        Object obj = (this.eTA == 1 || bufferInfo.presentationTimeUs < this.eTA * 1000) ? null : 1;
                                        h hVar = this.oxp;
                                        byte[] bArr = this.fYd;
                                        if (this.fYd == null || this.oxs || obj != null) {
                                            z = true;
                                        } else {
                                            z = false;
                                        }
                                        hVar.a(bArr, z, bufferInfo.presentationTimeUs / 1000);
                                    }
                                }
                            }
                            ab.v("MicroMsg.MMSightRemuxMediaCodecDecoder", "processDecodeOutputBuffer %s", Long.valueOf(bo.az(yz)));
                            this.eTq.releaseOutputBuffer(dequeueOutputBuffer, false);
                            if (this.eTA != 1 && j >= this.eTA * 1000) {
                                ab.e("MicroMsg.MMSightRemuxMediaCodecDecoder", "exceed endTimeMs");
                                this.oxs = true;
                                AppMethodBeat.o(76709);
                                return true;
                            } else if ((this.eTy.flags & 4) != 0) {
                                ab.i("MicroMsg.MMSightRemuxMediaCodecDecoder", "receive end of stream");
                                try {
                                    this.eTq.stop();
                                    this.eTq.release();
                                    this.oxs = true;
                                    this.eTq = null;
                                } catch (Exception e2) {
                                    ab.e("MicroMsg.MMSightRemuxMediaCodecDecoder", "stop and release decoder error: %s", e2.getMessage());
                                }
                                AppMethodBeat.o(76709);
                                return true;
                            } else {
                                AppMethodBeat.o(76709);
                                return false;
                            }
                        } else {
                            this.eTq.releaseOutputBuffer(dequeueOutputBuffer, false);
                        }
                    } else {
                        ab.w("MicroMsg.MMSightRemuxMediaCodecDecoder", "unexpected result from decoder.dequeueOutputBuffer: ".concat(String.valueOf(dequeueOutputBuffer)));
                    }
                } else {
                    this.fYc = this.eTq.getOutputFormat();
                    ab.i("MicroMsg.MMSightRemuxMediaCodecDecoder", "decoder output format changed: " + this.fYc);
                }
            } else {
                outputBuffers = this.eTq.getOutputBuffers();
                ab.i("MicroMsg.MMSightRemuxMediaCodecDecoder", "decoder output buffers changed");
            }
            dequeueOutputBuffer = this.eTq.dequeueOutputBuffer(this.eTy, 60000);
            if (dequeueOutputBuffer < 0) {
                break;
            }
        }
        ab.i("MicroMsg.MMSightRemuxMediaCodecDecoder", "no output from decoder available, break");
        AppMethodBeat.o(76709);
        return false;
    }

    /* JADX WARNING: Missing block: B:11:0x0071, code skipped:
            if (UF() == false) goto L_0x0073;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void bPZ() {
        int dequeueInputBuffer;
        long yz;
        AppMethodBeat.i(76710);
        this.frameCount = 0;
        this.oxs = false;
        do {
            boolean z;
            MediaExtractor mediaExtractor = this.clX;
            if (this.eTq == null) {
                ab.i("MicroMsg.MMSightRemuxMediaCodecDecoder", "input decoder is null");
                z = true;
            } else {
                ByteBuffer[] inputBuffers = this.eTq.getInputBuffers();
                if (inputBuffers == null) {
                    z = false;
                } else {
                    ab.i("MicroMsg.MMSightRemuxMediaCodecDecoder", "decoderInputByteBuffers size: %d", Integer.valueOf(inputBuffers.length));
                    int i = 0;
                    while (true) {
                        dequeueInputBuffer = this.eTq.dequeueInputBuffer(60000);
                        if (dequeueInputBuffer < 0 && i < 15) {
                            yz = bo.yz();
                            boolean UF = UF();
                            ab.i("MicroMsg.MMSightRemuxMediaCodecDecoder", "drain cost1 %d", Long.valueOf(bo.az(yz)));
                            if (UF) {
                                z = true;
                                break;
                            }
                            i++;
                        }
                    }
                    if (dequeueInputBuffer >= 0) {
                        ByteBuffer byteBuffer = inputBuffers[dequeueInputBuffer];
                        byteBuffer.clear();
                        this.sampleSize = mediaExtractor.readSampleData(byteBuffer, 0);
                        byteBuffer.position(0);
                        yz = mediaExtractor.getSampleTime();
                        ab.i("MicroMsg.MMSightRemuxMediaCodecDecoder", "sampleTime: %s", Long.valueOf(yz));
                        if (this.sampleSize < 0 || yz >= this.eTA * 1000) {
                            z = true;
                        } else {
                            z = false;
                        }
                        ab.i("MicroMsg.MMSightRemuxMediaCodecDecoder", "sawInputEOS: %s", Boolean.valueOf(z));
                        this.eTq.queueInputBuffer(dequeueInputBuffer, 0, this.sampleSize, yz, z ? 4 : 0);
                    } else {
                        ab.w("MicroMsg.MMSightRemuxMediaCodecDecoder", "input buffer not available");
                        z = false;
                    }
                    long yz2 = bo.yz();
                    boolean UF2 = UF();
                    ab.i("MicroMsg.MMSightRemuxMediaCodecDecoder", "drain cost2 %d", Long.valueOf(bo.az(yz2)));
                    if (UF2) {
                        z = true;
                    }
                }
            }
            if (z) {
                break;
            }
            this.clX.advance();
        } while (this.clX.getSampleTrackIndex() == this.eWc);
        ab.i("MicroMsg.MMSightRemuxMediaCodecDecoder", "track index not match, break");
        MediaExtractor mediaExtractor2 = this.clX;
        ab.i("MicroMsg.MMSightRemuxMediaCodecDecoder", "sendDecoderEOS");
        ByteBuffer[] inputBuffers2 = this.eTq.getInputBuffers();
        dequeueInputBuffer = this.eTq.dequeueInputBuffer(60000);
        if (dequeueInputBuffer < 0) {
            ab.i("MicroMsg.MMSightRemuxMediaCodecDecoder", "check decoder input buffer index = %d count = %d", Integer.valueOf(dequeueInputBuffer), Integer.valueOf(0));
        }
        if (dequeueInputBuffer >= 0) {
            ByteBuffer byteBuffer2 = inputBuffers2[dequeueInputBuffer];
            byteBuffer2.clear();
            this.sampleSize = mediaExtractor2.readSampleData(byteBuffer2, 0);
            byteBuffer2.position(0);
            yz = mediaExtractor2.getSampleTime();
            if (dequeueInputBuffer >= 0) {
                ab.i("MicroMsg.MMSightRemuxMediaCodecDecoder", "send EOS, decoderInputBufferIndex: %s", Integer.valueOf(dequeueInputBuffer));
                this.eTq.queueInputBuffer(dequeueInputBuffer, 0, 0, yz * 1000, 4);
            } else {
                ab.w("MicroMsg.MMSightRemuxMediaCodecDecoder", "input buffer not available");
            }
        }
        this.oxs = true;
        UF();
        al.n(new Runnable() {
            public final void run() {
                AppMethodBeat.i(76704);
                if (e.this.eTq != null) {
                    ab.i("MicroMsg.MMSightRemuxMediaCodecDecoder", "delay to stop decoder");
                    try {
                        e.this.eTq.stop();
                        e.this.eTq.release();
                        e.this.eTq = null;
                        AppMethodBeat.o(76704);
                        return;
                    } catch (Exception e) {
                        ab.printErrStackTrace("MicroMsg.MMSightRemuxMediaCodecDecoder", e, "delay to stop decoder error: %s", e.getMessage());
                    }
                }
                AppMethodBeat.o(76704);
            }
        }, 500);
        this.clX.release();
        AppMethodBeat.o(76710);
    }

    public final void a(h hVar) {
        this.oxp = hVar;
    }

    public final int alK() {
        AppMethodBeat.i(76711);
        ab.i("MicroMsg.MMSightRemuxMediaCodecDecoder", "src color format: %s", Integer.valueOf(this.fYc.getInteger("color-format")));
        switch (this.fYc.getInteger("color-format")) {
            case 19:
                AppMethodBeat.o(76711);
                return 2;
            case 21:
            case 2130706688:
                AppMethodBeat.o(76711);
                return 1;
            default:
                AppMethodBeat.o(76711);
                return 1;
        }
    }

    public final Point alJ() {
        AppMethodBeat.i(76712);
        Point point = new Point(this.fYc.getInteger("width"), this.fYc.getInteger("height"));
        AppMethodBeat.o(76712);
        return point;
    }

    public final void mp(int i) {
        AppMethodBeat.i(76713);
        ab.i("MicroMsg.MMSightRemuxMediaCodecDecoder", "setFrameDropInterval: %s", Integer.valueOf(i));
        this.eTJ = i;
        AppMethodBeat.o(76713);
    }
}
