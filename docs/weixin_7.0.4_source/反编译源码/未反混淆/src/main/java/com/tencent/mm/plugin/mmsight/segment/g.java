package com.tencent.mm.plugin.mmsight.segment;

import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.al;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

public final class g {
    private long bqO;
    private MediaExtractor clX;
    String clY = null;
    private long eTA;
    MediaFormat eVr;
    VideoTransPara fYK;
    MediaFormat fYc;
    MediaCodec oxW;
    MediaCodec oxX;
    boolean oxY = true;
    List<byte[]> oxZ = null;
    private boolean oya = false;
    private boolean oyb = false;
    private byte[] oyc;
    private HandlerThread oyd = null;
    private ak oye = null;

    public g(MediaExtractor mediaExtractor, MediaFormat mediaFormat, long j, long j2, VideoTransPara videoTransPara) {
        AppMethodBeat.i(3644);
        this.clX = mediaExtractor;
        this.fYc = mediaFormat;
        this.bqO = j;
        this.eTA = j2;
        this.fYK = videoTransPara;
        this.clY = mediaFormat.getString("mime");
        this.oxZ = new ArrayList();
        ab.i("MicroMsg.MediaCodecAACTranscoder", "create MediaCodecAACTranscoder, startTimeMs: %s, endTimeMs: %s, mime: %s, srcMediaFormat: %s, para: %s", Long.valueOf(j), Long.valueOf(j2), this.clY, mediaFormat, videoTransPara);
        AppMethodBeat.o(3644);
    }

    public final void bQh() {
        AppMethodBeat.i(3645);
        this.oya = false;
        this.oyb = false;
        while (this.oxW != null && this.clX != null) {
            try {
                ByteBuffer[] inputBuffers = this.oxW.getInputBuffers();
                int dequeueInputBuffer = this.oxW.dequeueInputBuffer(20000);
                if (dequeueInputBuffer < 0) {
                    ab.d("MicroMsg.MediaCodecAACTranscoder", "decoder no input buffer available, drain first");
                    UD();
                }
                if (dequeueInputBuffer >= 0) {
                    boolean z;
                    ab.d("MicroMsg.MediaCodecAACTranscoder", "decoderInputBufferIndex: %d", Integer.valueOf(dequeueInputBuffer));
                    ByteBuffer byteBuffer = inputBuffers[dequeueInputBuffer];
                    byteBuffer.clear();
                    byteBuffer.position(0);
                    int readSampleData = this.clX.readSampleData(byteBuffer, 0);
                    long sampleTime = this.clX.getSampleTime();
                    this.clX.advance();
                    ab.d("MicroMsg.MediaCodecAACTranscoder", "sampleSize: %s, pts: %s", Integer.valueOf(readSampleData), Long.valueOf(sampleTime));
                    if (sampleTime >= this.eTA * 1000 || sampleTime <= 0 || readSampleData <= 0) {
                        ab.i("MicroMsg.MediaCodecAACTranscoder", "reach end time, send EOS and try delay stop decoder");
                        this.oyb = true;
                        al.n(new Runnable() {
                            public final void run() {
                                AppMethodBeat.i(3642);
                                try {
                                    if (g.this.oxW != null) {
                                        ab.i("MicroMsg.MediaCodecAACTranscoder", "delay to stop decoder");
                                        g.this.oxW.stop();
                                        g.this.oxW.release();
                                        g.this.oxW = null;
                                    }
                                    AppMethodBeat.o(3642);
                                } catch (Exception e) {
                                    ab.e("MicroMsg.MediaCodecAACTranscoder", "delayStopDecoder error: %s", e.getMessage());
                                    AppMethodBeat.o(3642);
                                }
                            }
                        }, 500);
                        z = true;
                    } else {
                        z = false;
                    }
                    if (this.oxW == null) {
                        AppMethodBeat.o(3645);
                        return;
                    } else if (z) {
                        ab.i("MicroMsg.MediaCodecAACTranscoder", "EOS received in sendAudioToEncoder");
                        this.oxW.queueInputBuffer(dequeueInputBuffer, 0, readSampleData, sampleTime, 4);
                    } else {
                        this.oxW.queueInputBuffer(dequeueInputBuffer, 0, readSampleData, sampleTime, 0);
                    }
                }
                UD();
                if (this.oyb && this.oxX == null) {
                    AppMethodBeat.o(3645);
                    return;
                }
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.MediaCodecAACTranscoder", e, "startTranscodeBlockLoop error: %s", e.getMessage());
                AppMethodBeat.o(3645);
                return;
            }
        }
        ab.e("MicroMsg.MediaCodecAACTranscoder", "startTranscodeBlockLoop error");
        AppMethodBeat.o(3645);
    }

    private void UD() {
        AppMethodBeat.i(3646);
        if (this.oxW == null) {
            AppMethodBeat.o(3646);
            return;
        }
        try {
            ByteBuffer[] outputBuffers = this.oxW.getOutputBuffers();
            BufferInfo bufferInfo = new BufferInfo();
            ByteBuffer[] byteBufferArr = outputBuffers;
            while (true) {
                int dequeueOutputBuffer = this.oxW.dequeueOutputBuffer(bufferInfo, 20000);
                ab.d("MicroMsg.MediaCodecAACTranscoder", "decoderOutputBufferIndex: %s", Integer.valueOf(dequeueOutputBuffer));
                if (dequeueOutputBuffer == -1) {
                    ab.d("MicroMsg.MediaCodecAACTranscoder", "no output available, break");
                    AppMethodBeat.o(3646);
                    return;
                } else if (dequeueOutputBuffer == -3) {
                    byteBufferArr = this.oxW.getOutputBuffers();
                } else if (dequeueOutputBuffer == -2) {
                    this.fYc = this.oxW.getOutputFormat();
                    ab.i("MicroMsg.MediaCodecAACTranscoder", "srcMediaFormat change: %s", this.fYc);
                } else if (dequeueOutputBuffer < 0) {
                    ab.e("MicroMsg.MediaCodecAACTranscoder", "unexpected decoderOutputBufferIndex: %s", Integer.valueOf(dequeueOutputBuffer));
                } else {
                    ab.v("MicroMsg.MediaCodecAACTranscoder", "perform decoding");
                    ByteBuffer byteBuffer = byteBufferArr[dequeueOutputBuffer];
                    if (byteBuffer == null) {
                        ab.e("MicroMsg.MediaCodecAACTranscoder", "ERROR, retrieve decoderOutputBuffer is null!!");
                        AppMethodBeat.o(3646);
                        return;
                    }
                    if ((bufferInfo.flags & 2) != 0) {
                        ab.e("MicroMsg.MediaCodecAACTranscoder", "ignore BUFFER_FLAG_CODEC_CONFIG");
                        bufferInfo.size = 0;
                    }
                    if (bufferInfo.size > 0) {
                        byteBuffer.position(bufferInfo.offset);
                        byteBuffer.limit(bufferInfo.offset + bufferInfo.size);
                        a(byteBuffer, bufferInfo, (bufferInfo.flags & 4) != 0);
                    }
                    this.oxW.releaseOutputBuffer(dequeueOutputBuffer, false);
                    if ((bufferInfo.flags & 4) != 0) {
                        ab.i("MicroMsg.MediaCodecAACTranscoder", "receive EOS!");
                        if (this.oxW != null) {
                            this.oxW.stop();
                            this.oxW.release();
                            this.oxW = null;
                            AppMethodBeat.o(3646);
                            return;
                        }
                        AppMethodBeat.o(3646);
                        return;
                    }
                }
            }
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.MediaCodecAACTranscoder", e, "drainDecoder error: %s", e.getMessage());
            AppMethodBeat.o(3646);
        }
    }

    private void a(ByteBuffer byteBuffer, BufferInfo bufferInfo, boolean z) {
        AppMethodBeat.i(3647);
        if (byteBuffer == null) {
            AppMethodBeat.o(3647);
            return;
        }
        ab.d("MicroMsg.MediaCodecAACTranscoder", "processDecodeBuffer, EOS: %s, finishGetAllInputAACData: %s", Boolean.valueOf(z), Boolean.valueOf(this.oyb));
        if (this.oxY) {
            if (!this.oya) {
                bQi();
                this.oya = true;
            }
            if (this.oyc == null) {
                this.oyc = new byte[byteBuffer.remaining()];
                byteBuffer.get(this.oyc, 0, byteBuffer.remaining());
            }
            c(this.oyc, bufferInfo.presentationTimeUs, z);
            AppMethodBeat.o(3647);
            return;
        }
        byte[] bArr = new byte[byteBuffer.remaining()];
        byteBuffer.get(bArr, 0, byteBuffer.remaining());
        this.oxZ.add(bArr);
        if (this.oyb || z) {
            try {
                this.oxW.stop();
                this.oxW.release();
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.MediaCodecAACTranscoder", e, "", new Object[0]);
            }
            bQi();
            this.oya = true;
            int i = 0;
            for (byte[] bArr2 : this.oxZ) {
                boolean z2;
                long j = bufferInfo.presentationTimeUs;
                if (i >= this.oxZ.size() - 1) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                c(bArr2, j, z2);
                i++;
            }
        }
        AppMethodBeat.o(3647);
    }

    private void bQi() {
        AppMethodBeat.i(3648);
        if (this.oxX == null || !this.oxY || this.oya) {
            try {
                this.eVr = new MediaFormat();
                this.eVr.setString("mime", "audio/mp4a-latm");
                this.eVr.setInteger("aac-profile", 2);
                this.eVr.setInteger("sample-rate", this.fYK.audioSampleRate);
                this.eVr.setInteger("channel-count", 1);
                this.eVr.setInteger(FFmpegMetadataRetriever.METADATA_KEY_VARIANT_BITRATE, this.fYK.fzS);
                this.eVr.setInteger("max-input-size", 16384);
                this.oxX = MediaCodec.createEncoderByType(this.clY);
                this.oxX.configure(this.eVr, null, null, 1);
                this.oxX.start();
                ab.i("MicroMsg.MediaCodecAACTranscoder", "checkInitAndStartEncoder, not canEncodeDecodeBothExist, create new encoder");
                AppMethodBeat.o(3648);
                return;
            } catch (Exception e) {
                ab.e("MicroMsg.MediaCodecAACTranscoder", "checkInitAndStartEncoder, not canEncodeDecodeBothExist, error: %s", e.getMessage());
                AppMethodBeat.o(3648);
                return;
            }
        }
        this.oxW.start();
        AppMethodBeat.o(3648);
    }

    private void c(byte[] bArr, long j, boolean z) {
        AppMethodBeat.i(3649);
        if (this.oxX == null || bArr == null) {
            AppMethodBeat.o(3649);
            return;
        }
        ByteBuffer[] inputBuffers = this.oxX.getInputBuffers();
        int dequeueInputBuffer = this.oxX.dequeueInputBuffer(20000);
        if (dequeueInputBuffer < 0) {
            ab.d("MicroMsg.MediaCodecAACTranscoder", "encoder no input buffer available, drain first");
            UR();
        }
        if (dequeueInputBuffer >= 0) {
            int i;
            ByteBuffer byteBuffer = inputBuffers[dequeueInputBuffer];
            byteBuffer.clear();
            byteBuffer.position(0);
            byteBuffer.put(bArr);
            if (z) {
                ab.i("MicroMsg.MediaCodecAACTranscoder", "last, send EOS and try delay stop encoder");
                i = 1;
                bQj();
            } else {
                i = 0;
            }
            if (this.oxX == null) {
                AppMethodBeat.o(3649);
                return;
            } else if (i != 0) {
                ab.i("MicroMsg.MediaCodecAACTranscoder", "EOS received in sendAudioToEncoder");
                this.oxX.queueInputBuffer(dequeueInputBuffer, 0, bArr.length, j, 4);
            } else {
                this.oxX.queueInputBuffer(dequeueInputBuffer, 0, bArr.length, j, 0);
            }
        }
        UR();
        AppMethodBeat.o(3649);
    }

    private void UR() {
        AppMethodBeat.i(3650);
        if (this.oxX == null) {
            AppMethodBeat.o(3650);
            return;
        }
        try {
            ByteBuffer[] outputBuffers = this.oxX.getOutputBuffers();
            BufferInfo bufferInfo = new BufferInfo();
            while (true) {
                int dequeueOutputBuffer = this.oxX.dequeueOutputBuffer(bufferInfo, 20000);
                ab.d("MicroMsg.MediaCodecAACTranscoder", "encoderOutputBufferIndex: %s", Integer.valueOf(dequeueOutputBuffer));
                if (dequeueOutputBuffer == -1) {
                    ab.d("MicroMsg.MediaCodecAACTranscoder", "no output available, break");
                    AppMethodBeat.o(3650);
                    return;
                } else if (dequeueOutputBuffer == -3) {
                    outputBuffers = this.oxX.getOutputBuffers();
                } else if (dequeueOutputBuffer == -2) {
                    this.eVr = this.oxX.getOutputFormat();
                    ab.i("MicroMsg.MediaCodecAACTranscoder", "dstMediaFormat change: %s", this.eVr);
                } else if (dequeueOutputBuffer < 0) {
                    ab.e("MicroMsg.MediaCodecAACTranscoder", "unexpected encoderOutputBufferIndex: %s", Integer.valueOf(dequeueOutputBuffer));
                } else {
                    ab.v("MicroMsg.MediaCodecAACTranscoder", "perform encoding");
                    ByteBuffer byteBuffer = outputBuffers[dequeueOutputBuffer];
                    if (byteBuffer == null) {
                        ab.e("MicroMsg.MediaCodecAACTranscoder", "ERROR, retrieve encoderOutputBuffer is null!!");
                        AppMethodBeat.o(3650);
                        return;
                    }
                    if (bufferInfo.size > 0) {
                        byteBuffer.position(bufferInfo.offset);
                        byteBuffer.limit(bufferInfo.offset + bufferInfo.size);
                        h(byteBuffer, bufferInfo);
                    }
                    this.oxX.releaseOutputBuffer(dequeueOutputBuffer, false);
                    if ((bufferInfo.flags & 4) != 0) {
                        ab.i("MicroMsg.MediaCodecAACTranscoder", "receive EOS!");
                        if (this.oxX != null) {
                            this.oxX.stop();
                            this.oxX.release();
                            this.oxX = null;
                            AppMethodBeat.o(3650);
                            return;
                        }
                        AppMethodBeat.o(3650);
                        return;
                    }
                }
            }
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.MediaCodecAACTranscoder", e, "drainEncoder error: %s", e.getMessage());
            AppMethodBeat.o(3650);
        }
    }

    private static void h(ByteBuffer byteBuffer, BufferInfo bufferInfo) {
        AppMethodBeat.i(3651);
        if (byteBuffer != null) {
            MP4MuxerJNI.writeAACData(0, byteBuffer, bufferInfo.size);
        }
        AppMethodBeat.o(3651);
    }

    private void bQj() {
        AppMethodBeat.i(3652);
        al.n(new Runnable() {
            public final void run() {
                AppMethodBeat.i(3643);
                try {
                    if (g.this.oxX != null) {
                        ab.i("MicroMsg.MediaCodecAACTranscoder", "delay to stop encoder");
                        g.this.oxX.stop();
                        g.this.oxX.release();
                        g.this.oxX = null;
                    }
                    AppMethodBeat.o(3643);
                } catch (Exception e) {
                    ab.e("MicroMsg.MediaCodecAACTranscoder", "delayStopEncoder error: %s", e.getMessage());
                    AppMethodBeat.o(3643);
                }
            }
        }, 500);
        AppMethodBeat.o(3652);
    }
}
