package com.tencent.p177mm.plugin.appbrand.media.record.p1230a;

import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.media.encode.M4aAudioFormatJni;
import com.tencent.p177mm.plugin.appbrand.media.record.C27203j;
import com.tencent.p177mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.io.IOException;
import java.nio.ByteBuffer;

/* renamed from: com.tencent.mm.plugin.appbrand.media.record.a.a */
public final class C42629a extends C27198b {
    private final int TIMEOUT_USEC = 100;
    int ilV = 2;
    private MediaCodec ilW;
    BufferInfo mBufferInfo;
    private String mFilePath = "";

    /* renamed from: h */
    public final boolean mo34814h(String str, int i, int i2, int i3) {
        boolean z;
        AppMethodBeat.m2504i(105645);
        C4990ab.m7417i("MicroMsg.Record.AACAudioEncoder", "init, filePath:%s, sampleRate:%d, channelCount:%d, bitRate:%d", str, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3));
        this.mFilePath = str;
        try {
            C4990ab.m7416i("MicroMsg.Record.AACAudioEncoder", "initCodec");
            this.mBufferInfo = new BufferInfo();
            MediaFormat createAudioFormat = MediaFormat.createAudioFormat(this.ilX, i, i2);
            createAudioFormat.setInteger(FFmpegMetadataRetriever.METADATA_KEY_VARIANT_BITRATE, i3);
            createAudioFormat.setInteger("aac-profile", this.ilV);
            this.ilW = MediaCodec.createEncoderByType(this.ilX);
            this.ilW.configure(createAudioFormat, null, null, 1);
            this.ilW.start();
            C4990ab.m7416i("MicroMsg.Record.AACAudioEncoder", "encoder start to work");
            z = false;
        } catch (IOException e) {
            C4990ab.printErrStackTrace("MicroMsg.Record.AACAudioEncoder", e, "initCodec", new Object[0]);
            z = true;
        } catch (Exception e2) {
            C4990ab.printErrStackTrace("MicroMsg.Record.AACAudioEncoder", e2, "initCodec", new Object[0]);
            z = true;
        }
        if (z) {
            C4990ab.m7416i("MicroMsg.Record.AACAudioEncoder", "initCodec  fail,");
            C27203j.m43227pk(21);
            AppMethodBeat.m2505o(105645);
            return false;
        }
        C4990ab.m7416i("MicroMsg.Record.AACAudioEncoder", "initCodec ok");
        if (M4aAudioFormatJni.createM4aFile(str, i2, i, this.ilV) == 0) {
            C4990ab.m7416i("MicroMsg.Record.AACAudioEncoder", "createM4aFile m4a jni api ok,");
            AppMethodBeat.m2505o(105645);
            return true;
        }
        C4990ab.m7416i("MicroMsg.Record.AACAudioEncoder", "createM4aFile m4a jni api fail,");
        C27203j.m43227pk(22);
        AppMethodBeat.m2505o(105645);
        return false;
    }

    /* renamed from: a */
    public final boolean mo34811a(boolean z, byte[] bArr, int i) {
        AppMethodBeat.m2504i(105646);
        if (bArr == null) {
            C4990ab.m7412e("MicroMsg.Record.AACAudioEncoder", "pcm is null");
            AppMethodBeat.m2505o(105646);
            return false;
        } else if (this.ilW != null) {
            C4990ab.m7417i("MicroMsg.Record.AACAudioEncoder", "encodePCMToAAC endOfStream:%b", Boolean.valueOf(z));
            ByteBuffer[] inputBuffers = this.ilW.getInputBuffers();
            ByteBuffer[] outputBuffers = this.ilW.getOutputBuffers();
            int dequeueInputBuffer = this.ilW.dequeueInputBuffer(100);
            if (dequeueInputBuffer >= 0) {
                ByteBuffer byteBuffer = inputBuffers[dequeueInputBuffer];
                byteBuffer.clear();
                byteBuffer.put(bArr);
                byteBuffer.position(0);
                byteBuffer.limit(bArr.length);
                C4990ab.m7417i("MicroMsg.Record.AACAudioEncoder", "inputBufferIndex:%d, data length:%d", Integer.valueOf(dequeueInputBuffer), Integer.valueOf(bArr.length));
                if (z) {
                    this.ilW.queueInputBuffer(dequeueInputBuffer, 0, bArr.length, System.nanoTime(), 4);
                    inputBuffers = outputBuffers;
                } else {
                    this.ilW.queueInputBuffer(dequeueInputBuffer, 0, bArr.length, System.nanoTime(), 0);
                    inputBuffers = outputBuffers;
                }
            } else {
                C4990ab.m7413e("MicroMsg.Record.AACAudioEncoder", "inputBufferIndex %d", Integer.valueOf(dequeueInputBuffer));
                inputBuffers = outputBuffers;
            }
            while (true) {
                dequeueInputBuffer = this.ilW.dequeueOutputBuffer(this.mBufferInfo, 100);
                if (dequeueInputBuffer == -1) {
                    C4990ab.m7410d("MicroMsg.Record.AACAudioEncoder", "no output available, break");
                    break;
                } else if (dequeueInputBuffer == -3) {
                    C4990ab.m7412e("MicroMsg.Record.AACAudioEncoder", "output buff change");
                    inputBuffers = this.ilW.getOutputBuffers();
                } else if (dequeueInputBuffer == -2) {
                    C4990ab.m7412e("MicroMsg.Record.AACAudioEncoder", "encoder output format changed: ".concat(String.valueOf(this.ilW.getOutputFormat())));
                } else if (dequeueInputBuffer < 0) {
                    C4990ab.m7413e("MicroMsg.Record.AACAudioEncoder", "unexpected result from encoder.dequeueOutputBuffer: %s", Integer.valueOf(dequeueInputBuffer));
                } else {
                    C4990ab.m7417i("MicroMsg.Record.AACAudioEncoder", "outputBufferIndex %d", Integer.valueOf(dequeueInputBuffer));
                    ByteBuffer byteBuffer2 = inputBuffers[dequeueInputBuffer];
                    if (byteBuffer2 == null) {
                        RuntimeException runtimeException = new RuntimeException("outputBuffer " + dequeueInputBuffer + " was null");
                        AppMethodBeat.m2505o(105646);
                        throw runtimeException;
                    }
                    if ((this.mBufferInfo.flags & 2) != 0) {
                        C4990ab.m7412e("MicroMsg.Record.AACAudioEncoder", "flags is BUFFER_FLAG_CODEC_CONFIG, don't writ data into file");
                    } else {
                        int i2 = this.mBufferInfo.size;
                        byte[] bArr2 = new byte[i2];
                        byteBuffer2.get(bArr2, 0, i2);
                        int writeAudioBuff = M4aAudioFormatJni.writeAudioBuff(bArr2, i2);
                        mo44864e(bArr2, i2, false);
                        if (writeAudioBuff == 0) {
                            C4990ab.m7416i("MicroMsg.Record.AACAudioEncoder", "writeAudioBuff buff ok,");
                        } else {
                            C4990ab.m7416i("MicroMsg.Record.AACAudioEncoder", "writeAudioBuff buff fail,");
                        }
                    }
                    this.ilW.releaseOutputBuffer(dequeueInputBuffer, false);
                    if ((this.mBufferInfo.flags & 4) != 0) {
                        if (z) {
                            C4990ab.m7412e("MicroMsg.Record.AACAudioEncoder", "reach the end, and end to encode the data");
                        } else {
                            C4990ab.m7420w("MicroMsg.Record.AACAudioEncoder", "reached end of stream unexpectedly");
                        }
                    }
                }
            }
            AppMethodBeat.m2505o(105646);
            return true;
        } else {
            C4990ab.m7412e("MicroMsg.Record.AACAudioEncoder", "mEncoder is null");
            AppMethodBeat.m2505o(105646);
            return false;
        }
    }

    public final void flush() {
        AppMethodBeat.m2504i(105647);
        C4990ab.m7416i("MicroMsg.Record.AACAudioEncoder", "flush");
        mo44864e(new byte[0], 0, true);
        AppMethodBeat.m2505o(105647);
    }

    public final void close() {
        AppMethodBeat.m2504i(105648);
        C4990ab.m7416i("MicroMsg.Record.AACAudioEncoder", "close");
        if (this.ilW != null) {
            this.ilW.stop();
            this.ilW.release();
            this.ilW = null;
        }
        M4aAudioFormatJni.closeM4aFile();
        AppMethodBeat.m2505o(105648);
    }
}
