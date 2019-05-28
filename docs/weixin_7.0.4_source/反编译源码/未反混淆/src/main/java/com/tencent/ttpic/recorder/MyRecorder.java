package com.tencent.ttpic.recorder;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.ttpic.VideoParam;
import com.tencent.ttpic.util.FrameRateUtil;
import java.nio.ByteBuffer;

@TargetApi(18)
public class MyRecorder {
    private static final String TAG = MyRecorder.class.getSimpleName();
    private BufferInfo mBufferInfo = null;
    private MediaCodec mMediaCodec = null;
    private MediaMuxer mMediaMuxer = null;
    private boolean mMuxerStarted = false;
    private String mOutput;
    private float mPlayRate = 1.0f;
    private Surface mSurface;
    private int mTrackIndex = -1;

    static {
        AppMethodBeat.i(83706);
        AppMethodBeat.o(83706);
    }

    public MyRecorder(String str) {
        this.mOutput = str;
    }

    public boolean prepareEncoder(int i, int i2) {
        AppMethodBeat.i(83700);
        if (this.mMediaCodec != null) {
            AppMethodBeat.o(83700);
            return true;
        }
        this.mBufferInfo = new BufferInfo();
        try {
            MediaFormat createVideoFormat = MediaFormat.createVideoFormat(VideoParam.mMime, i, i2);
            createVideoFormat.setInteger("color-format", 2130708361);
            createVideoFormat.setInteger(FFmpegMetadataRetriever.METADATA_KEY_VARIANT_BITRATE, FrameRateUtil.getRenderLevel().bps);
            createVideoFormat.setInteger("frame-rate", 18);
            createVideoFormat.setInteger("i-frame-interval", VideoParam.mIfi);
            this.mMediaCodec = MediaCodec.createEncoderByType(VideoParam.mMime);
            if (this.mMediaCodec != null) {
                this.mMediaCodec.configure(createVideoFormat, null, null, 1);
            }
            this.mMediaMuxer = new MediaMuxer(this.mOutput, 0);
            this.mMuxerStarted = false;
            if (this.mSurface == null && this.mMediaCodec != null) {
                this.mSurface = this.mMediaCodec.createInputSurface();
            }
            AppMethodBeat.o(83700);
            return true;
        } catch (Exception e) {
            releaseEncoder();
            AppMethodBeat.o(83700);
            return false;
        }
    }

    public boolean isRecording() {
        return this.mMediaCodec != null;
    }

    public void swapBuffers() {
        AppMethodBeat.i(83701);
        if (isRecording() && isValid()) {
            drainEncoder(false);
            AppMethodBeat.o(83701);
            return;
        }
        AppMethodBeat.o(83701);
    }

    public void stop() {
        AppMethodBeat.i(83702);
        drainEncoder(true);
        releaseEncoder();
        AppMethodBeat.o(83702);
    }

    public void releaseEncoder() {
        AppMethodBeat.i(83703);
        try {
            if (this.mMediaCodec != null) {
                this.mMediaCodec.stop();
                this.mMediaCodec.release();
                this.mMediaCodec = null;
            }
            if (this.mMediaMuxer != null) {
                this.mMediaMuxer.stop();
                this.mMediaMuxer.release();
                this.mMediaMuxer = null;
            }
            this.mBufferInfo = null;
            AppMethodBeat.o(83703);
        } catch (RuntimeException e) {
            AppMethodBeat.o(83703);
        }
    }

    private void drainEncoder(boolean z) {
        AppMethodBeat.i(83704);
        if (isValid()) {
            if (z) {
                try {
                    this.mMediaCodec.signalEndOfInputStream();
                } catch (RuntimeException e) {
                    AppMethodBeat.o(83704);
                    return;
                }
            }
            while (true) {
                ByteBuffer[] outputBuffers = this.mMediaCodec.getOutputBuffers();
                while (true) {
                    int dequeueOutputBuffer = this.mMediaCodec.dequeueOutputBuffer(this.mBufferInfo, 0);
                    if (dequeueOutputBuffer == -1) {
                        if (!z) {
                            AppMethodBeat.o(83704);
                            return;
                        }
                    } else if (dequeueOutputBuffer != -3) {
                        if (dequeueOutputBuffer != -2) {
                            ByteBuffer byteBuffer = outputBuffers[dequeueOutputBuffer];
                            if (byteBuffer == null) {
                                new StringBuilder("encoderOutputBuffer ").append(dequeueOutputBuffer).append(" was null");
                                this.mMediaCodec.releaseOutputBuffer(dequeueOutputBuffer, false);
                            } else {
                                if ((this.mBufferInfo.flags & 2) != 0) {
                                    this.mBufferInfo.size = 0;
                                }
                                if (this.mBufferInfo.size != 0) {
                                    if (this.mMuxerStarted) {
                                        byteBuffer.position(this.mBufferInfo.offset);
                                        byteBuffer.limit(this.mBufferInfo.offset + this.mBufferInfo.size);
                                        if (Float.compare(this.mPlayRate, 1.0f) != 0) {
                                            this.mBufferInfo.presentationTimeUs = (long) (((float) this.mBufferInfo.presentationTimeUs) * this.mPlayRate);
                                        }
                                        this.mMediaMuxer.writeSampleData(this.mTrackIndex, byteBuffer, this.mBufferInfo);
                                    } else {
                                        this.mMediaCodec.releaseOutputBuffer(dequeueOutputBuffer, false);
                                    }
                                }
                                this.mMediaCodec.releaseOutputBuffer(dequeueOutputBuffer, false);
                                if ((this.mBufferInfo.flags & 4) != 0) {
                                    AppMethodBeat.o(83704);
                                    return;
                                }
                            }
                        } else if (this.mMuxerStarted) {
                            this.mMediaCodec.releaseOutputBuffer(dequeueOutputBuffer, false);
                        } else {
                            this.mTrackIndex = this.mMediaMuxer.addTrack(this.mMediaCodec.getOutputFormat());
                            this.mMediaMuxer.start();
                            this.mMuxerStarted = true;
                        }
                    }
                }
            }
        } else {
            AppMethodBeat.o(83704);
        }
    }

    private boolean isValid() {
        return (this.mMediaCodec == null || this.mMediaMuxer == null || this.mBufferInfo == null) ? false : true;
    }

    public String getOutputPath() {
        return this.mOutput;
    }

    public void start() {
        AppMethodBeat.i(83705);
        if (this.mMediaCodec != null) {
            this.mMediaCodec.start();
        }
        AppMethodBeat.o(83705);
    }

    public Surface getInputSurface() {
        return this.mSurface;
    }

    public void setPlayRate(float f) {
        this.mPlayRate = f;
    }
}
