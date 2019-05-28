package com.tencent.mm.plugin.appbrand.media.record.a;

import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.media.encode.M4aAudioFormatJni;
import com.tencent.mm.plugin.appbrand.media.record.j;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.sdk.platformtools.ab;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class a extends b {
    private final int TIMEOUT_USEC = 100;
    int ilV = 2;
    private MediaCodec ilW;
    BufferInfo mBufferInfo;
    private String mFilePath = "";

    public final boolean h(String str, int i, int i2, int i3) {
        boolean z;
        AppMethodBeat.i(105645);
        ab.i("MicroMsg.Record.AACAudioEncoder", "init, filePath:%s, sampleRate:%d, channelCount:%d, bitRate:%d", str, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3));
        this.mFilePath = str;
        try {
            ab.i("MicroMsg.Record.AACAudioEncoder", "initCodec");
            this.mBufferInfo = new BufferInfo();
            MediaFormat createAudioFormat = MediaFormat.createAudioFormat(this.ilX, i, i2);
            createAudioFormat.setInteger(FFmpegMetadataRetriever.METADATA_KEY_VARIANT_BITRATE, i3);
            createAudioFormat.setInteger("aac-profile", this.ilV);
            this.ilW = MediaCodec.createEncoderByType(this.ilX);
            this.ilW.configure(createAudioFormat, null, null, 1);
            this.ilW.start();
            ab.i("MicroMsg.Record.AACAudioEncoder", "encoder start to work");
            z = false;
        } catch (IOException e) {
            ab.printErrStackTrace("MicroMsg.Record.AACAudioEncoder", e, "initCodec", new Object[0]);
            z = true;
        } catch (Exception e2) {
            ab.printErrStackTrace("MicroMsg.Record.AACAudioEncoder", e2, "initCodec", new Object[0]);
            z = true;
        }
        if (z) {
            ab.i("MicroMsg.Record.AACAudioEncoder", "initCodec  fail,");
            j.pk(21);
            AppMethodBeat.o(105645);
            return false;
        }
        ab.i("MicroMsg.Record.AACAudioEncoder", "initCodec ok");
        if (M4aAudioFormatJni.createM4aFile(str, i2, i, this.ilV) == 0) {
            ab.i("MicroMsg.Record.AACAudioEncoder", "createM4aFile m4a jni api ok,");
            AppMethodBeat.o(105645);
            return true;
        }
        ab.i("MicroMsg.Record.AACAudioEncoder", "createM4aFile m4a jni api fail,");
        j.pk(22);
        AppMethodBeat.o(105645);
        return false;
    }

    public final boolean a(boolean z, byte[] bArr, int i) {
        AppMethodBeat.i(105646);
        if (bArr == null) {
            ab.e("MicroMsg.Record.AACAudioEncoder", "pcm is null");
            AppMethodBeat.o(105646);
            return false;
        } else if (this.ilW != null) {
            ab.i("MicroMsg.Record.AACAudioEncoder", "encodePCMToAAC endOfStream:%b", Boolean.valueOf(z));
            ByteBuffer[] inputBuffers = this.ilW.getInputBuffers();
            ByteBuffer[] outputBuffers = this.ilW.getOutputBuffers();
            int dequeueInputBuffer = this.ilW.dequeueInputBuffer(100);
            if (dequeueInputBuffer >= 0) {
                ByteBuffer byteBuffer = inputBuffers[dequeueInputBuffer];
                byteBuffer.clear();
                byteBuffer.put(bArr);
                byteBuffer.position(0);
                byteBuffer.limit(bArr.length);
                ab.i("MicroMsg.Record.AACAudioEncoder", "inputBufferIndex:%d, data length:%d", Integer.valueOf(dequeueInputBuffer), Integer.valueOf(bArr.length));
                if (z) {
                    this.ilW.queueInputBuffer(dequeueInputBuffer, 0, bArr.length, System.nanoTime(), 4);
                    inputBuffers = outputBuffers;
                } else {
                    this.ilW.queueInputBuffer(dequeueInputBuffer, 0, bArr.length, System.nanoTime(), 0);
                    inputBuffers = outputBuffers;
                }
            } else {
                ab.e("MicroMsg.Record.AACAudioEncoder", "inputBufferIndex %d", Integer.valueOf(dequeueInputBuffer));
                inputBuffers = outputBuffers;
            }
            while (true) {
                dequeueInputBuffer = this.ilW.dequeueOutputBuffer(this.mBufferInfo, 100);
                if (dequeueInputBuffer == -1) {
                    ab.d("MicroMsg.Record.AACAudioEncoder", "no output available, break");
                    break;
                } else if (dequeueInputBuffer == -3) {
                    ab.e("MicroMsg.Record.AACAudioEncoder", "output buff change");
                    inputBuffers = this.ilW.getOutputBuffers();
                } else if (dequeueInputBuffer == -2) {
                    ab.e("MicroMsg.Record.AACAudioEncoder", "encoder output format changed: ".concat(String.valueOf(this.ilW.getOutputFormat())));
                } else if (dequeueInputBuffer < 0) {
                    ab.e("MicroMsg.Record.AACAudioEncoder", "unexpected result from encoder.dequeueOutputBuffer: %s", Integer.valueOf(dequeueInputBuffer));
                } else {
                    ab.i("MicroMsg.Record.AACAudioEncoder", "outputBufferIndex %d", Integer.valueOf(dequeueInputBuffer));
                    ByteBuffer byteBuffer2 = inputBuffers[dequeueInputBuffer];
                    if (byteBuffer2 == null) {
                        RuntimeException runtimeException = new RuntimeException("outputBuffer " + dequeueInputBuffer + " was null");
                        AppMethodBeat.o(105646);
                        throw runtimeException;
                    }
                    if ((this.mBufferInfo.flags & 2) != 0) {
                        ab.e("MicroMsg.Record.AACAudioEncoder", "flags is BUFFER_FLAG_CODEC_CONFIG, don't writ data into file");
                    } else {
                        int i2 = this.mBufferInfo.size;
                        byte[] bArr2 = new byte[i2];
                        byteBuffer2.get(bArr2, 0, i2);
                        int writeAudioBuff = M4aAudioFormatJni.writeAudioBuff(bArr2, i2);
                        e(bArr2, i2, false);
                        if (writeAudioBuff == 0) {
                            ab.i("MicroMsg.Record.AACAudioEncoder", "writeAudioBuff buff ok,");
                        } else {
                            ab.i("MicroMsg.Record.AACAudioEncoder", "writeAudioBuff buff fail,");
                        }
                    }
                    this.ilW.releaseOutputBuffer(dequeueInputBuffer, false);
                    if ((this.mBufferInfo.flags & 4) != 0) {
                        if (z) {
                            ab.e("MicroMsg.Record.AACAudioEncoder", "reach the end, and end to encode the data");
                        } else {
                            ab.w("MicroMsg.Record.AACAudioEncoder", "reached end of stream unexpectedly");
                        }
                    }
                }
            }
            AppMethodBeat.o(105646);
            return true;
        } else {
            ab.e("MicroMsg.Record.AACAudioEncoder", "mEncoder is null");
            AppMethodBeat.o(105646);
            return false;
        }
    }

    public final void flush() {
        AppMethodBeat.i(105647);
        ab.i("MicroMsg.Record.AACAudioEncoder", "flush");
        e(new byte[0], 0, true);
        AppMethodBeat.o(105647);
    }

    public final void close() {
        AppMethodBeat.i(105648);
        ab.i("MicroMsg.Record.AACAudioEncoder", "close");
        if (this.ilW != null) {
            this.ilW.stop();
            this.ilW.release();
            this.ilW = null;
        }
        M4aAudioFormatJni.closeM4aFile();
        AppMethodBeat.o(105648);
    }
}
