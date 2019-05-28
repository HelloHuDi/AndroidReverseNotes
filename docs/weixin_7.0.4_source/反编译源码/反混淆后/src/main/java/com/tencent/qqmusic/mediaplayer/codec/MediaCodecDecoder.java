package com.tencent.qqmusic.mediaplayer.codec;

import android.annotation.TargetApi;
import android.media.AudioTrack;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaDataSource;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.qqmusic.mediaplayer.AudioFormat.AudioType;
import com.tencent.qqmusic.mediaplayer.AudioInformation;
import com.tencent.qqmusic.mediaplayer.AudioRecognition;
import com.tencent.qqmusic.mediaplayer.NativeLibs;
import com.tencent.qqmusic.mediaplayer.seektable.InvalidBoxException;
import com.tencent.qqmusic.mediaplayer.seektable.SeekTable;
import com.tencent.qqmusic.mediaplayer.seektable.flac.FlacSeekTable;
import com.tencent.qqmusic.mediaplayer.seektable.mp3.Mp3SeekTable;
import com.tencent.qqmusic.mediaplayer.seektable.mpeg4.Mp4SeekTable;
import com.tencent.qqmusic.mediaplayer.upstream.FileDataSource;
import com.tencent.qqmusic.mediaplayer.upstream.IDataSource;
import com.tencent.qqmusic.mediaplayer.upstream.INativeDataSource;
import com.tencent.qqmusic.mediaplayer.util.Logger;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

@TargetApi(16)
public class MediaCodecDecoder extends BaseDecoder {
    private static final String TAG = "MediaCodecDecoder";
    private static final int TIMEOUT_US = 500000;
    private long mCurrentDecodeTime = 0;
    private boolean mDecoderFinished = false;
    private long mFileSize = 0;
    private AudioInformation mInfo = null;
    private MediaCodec mMediaCodec = null;
    private final MediaExtractor mMediaExtractor = new MediaExtractor();
    private MediaFormat mMediaFormat = null;
    private byte[] mRemainBuffer = null;
    private SeekTable mSeekTable = null;

    public MediaCodecDecoder() {
        AppMethodBeat.m2504i(128535);
        AppMethodBeat.m2505o(128535);
    }

    /* Access modifiers changed, original: protected */
    public List<NativeLibs> getNativeLibs() {
        AppMethodBeat.m2504i(128536);
        ArrayList arrayList = new ArrayList();
        AppMethodBeat.m2505o(128536);
        return arrayList;
    }

    public int init(String str, boolean z) {
        AppMethodBeat.m2504i(128537);
        int init = init(new FileDataSource(str));
        AppMethodBeat.m2505o(128537);
        return init;
    }

    @TargetApi(23)
    public int init(final IDataSource iDataSource) {
        AppMethodBeat.m2504i(128538);
        int i = -1;
        if (iDataSource != null) {
            try {
                iDataSource.open();
                this.mMediaExtractor.setDataSource(new MediaDataSource() {
                    public int readAt(long j, byte[] bArr, int i, int i2) {
                        AppMethodBeat.m2504i(128549);
                        int readAt = iDataSource.readAt(j, bArr, i, i2);
                        AppMethodBeat.m2505o(128549);
                        return readAt;
                    }

                    public long getSize() {
                        AppMethodBeat.m2504i(128550);
                        long size = iDataSource.getSize();
                        AppMethodBeat.m2505o(128550);
                        return size;
                    }

                    public void close() {
                        AppMethodBeat.m2504i(128551);
                        iDataSource.close();
                        AppMethodBeat.m2505o(128551);
                    }
                });
                this.mFileSize = iDataSource.getSize();
                initMediaCodecAndFormat(iDataSource);
                i = 0;
            } catch (IOException e) {
                Logger.m71022e(TAG, "init", e);
            }
        }
        AppMethodBeat.m2505o(128538);
        return i;
    }

    public int init(INativeDataSource iNativeDataSource) {
        return -1;
    }

    public AudioInformation getAudioInformation() {
        return this.mInfo;
    }

    public int decodeData(int i, byte[] bArr) {
        int i2;
        AppMethodBeat.m2504i(128539);
        int i3 = 0;
        int i4;
        if (this.mRemainBuffer == null || this.mRemainBuffer.length <= 0) {
            if (this.mMediaCodec != null) {
                ByteBuffer[] inputBuffers = this.mMediaCodec.getInputBuffers();
                ByteBuffer[] outputBuffers = this.mMediaCodec.getOutputBuffers();
                BufferInfo bufferInfo = new BufferInfo();
                while (true) {
                    ByteBuffer[] byteBufferArr = outputBuffers;
                    i2 = i3;
                    if (!this.mDecoderFinished && i2 <= 0) {
                        i3 = this.mMediaCodec.dequeueInputBuffer(500000);
                        if (i3 >= 0) {
                            int readSampleData = this.mMediaExtractor.readSampleData(inputBuffers[i3], 0);
                            if (readSampleData < 0) {
                                Logger.m71025i(TAG, "InputBuffer BUFFER_FLAG_END_OF_STREAM");
                                this.mMediaCodec.queueInputBuffer(i3, 0, 0, 0, 4);
                            } else {
                                this.mMediaCodec.queueInputBuffer(i3, 0, readSampleData, this.mMediaExtractor.getSampleTime(), 0);
                                this.mMediaExtractor.advance();
                            }
                        }
                        i3 = this.mMediaCodec.dequeueOutputBuffer(bufferInfo, 500000);
                        switch (i3) {
                            case -3:
                                Logger.m71025i(TAG, "INFO_OUTPUT_BUFFERS_CHANGED");
                                outputBuffers = this.mMediaCodec.getOutputBuffers();
                                i3 = i2;
                                break;
                            case -2:
                                this.mMediaFormat = this.mMediaCodec.getOutputFormat();
                                Logger.m71025i(TAG, "New format " + this.mMediaFormat);
                                outputBuffers = byteBufferArr;
                                i3 = i2;
                                break;
                            case -1:
                                Logger.m71025i(TAG, "dequeueOutputBuffer timed out!");
                                outputBuffers = byteBufferArr;
                                i3 = i2;
                                break;
                            default:
                                ByteBuffer byteBuffer = byteBufferArr[i3];
                                i2 = i < bufferInfo.size ? i : bufferInfo.size;
                                byteBuffer.get(bArr, 0, i2);
                                if (bufferInfo.size > i) {
                                    i4 = bufferInfo.size - i;
                                    this.mRemainBuffer = new byte[i4];
                                    byteBuffer.get(this.mRemainBuffer, 0, i4);
                                }
                                byteBuffer.clear();
                                this.mMediaCodec.releaseOutputBuffer(i3, false);
                                long j = this.mCurrentDecodeTime;
                                this.mCurrentDecodeTime = bufferInfo.presentationTimeUs / 1000;
                                if (this.mInfo != null && this.mInfo.getBitDept() == 0) {
                                    this.mInfo.setBitDept(AudioRecognition.calcBitDept((long) bufferInfo.size, this.mCurrentDecodeTime - j, this.mInfo.getChannels(), this.mInfo.getSampleRate()));
                                }
                                outputBuffers = byteBufferArr;
                                i3 = i2;
                                break;
                        }
                        if ((bufferInfo.flags & 4) != 0) {
                            this.mDecoderFinished = true;
                            Logger.m71025i(TAG, "OutputBuffer BUFFER_FLAG_END_OF_STREAM");
                        }
                    }
                }
            } else {
                i2 = 0;
            }
        } else if (i >= this.mRemainBuffer.length) {
            System.arraycopy(this.mRemainBuffer, 0, bArr, 0, this.mRemainBuffer.length);
            i2 = this.mRemainBuffer.length;
            this.mRemainBuffer = null;
        } else {
            System.arraycopy(this.mRemainBuffer, 0, bArr, 0, i);
            i4 = this.mRemainBuffer.length - i;
            byte[] bArr2 = new byte[i4];
            System.arraycopy(this.mRemainBuffer, i, bArr2, 0, i4);
            this.mRemainBuffer = bArr2;
            i2 = i;
        }
        AppMethodBeat.m2505o(128539);
        return i2;
    }

    public long getCurrentTime() {
        return this.mCurrentDecodeTime;
    }

    public int seekTo(int i) {
        AppMethodBeat.m2504i(128540);
        this.mMediaExtractor.seekTo((long) (i * 1000), 2);
        AppMethodBeat.m2505o(128540);
        return i;
    }

    public int release() {
        AppMethodBeat.m2504i(128541);
        this.mMediaExtractor.release();
        if (this.mMediaCodec != null) {
            this.mMediaCodec.release();
        }
        AppMethodBeat.m2505o(128541);
        return 0;
    }

    public int getErrorCodeMask() {
        return -1;
    }

    public long getDuration() {
        AppMethodBeat.m2504i(128542);
        long j = 0;
        if (this.mInfo != null) {
            j = this.mInfo.getDuration();
        }
        AppMethodBeat.m2505o(128542);
        return j;
    }

    public long getMinBufferSize() {
        long minBufferSize;
        int i = 4;
        AppMethodBeat.m2504i(128543);
        if (this.mInfo != null) {
            int bitDept = this.mInfo.getBitDept();
            if (bitDept == 1) {
                i = 3;
            } else if (bitDept != 4 || VERSION.SDK_INT < 21) {
                i = 2;
            }
            minBufferSize = (long) AudioTrack.getMinBufferSize((int) this.mInfo.getSampleRate(), 12, i);
        } else {
            minBufferSize = 0;
        }
        AppMethodBeat.m2505o(128543);
        return minBufferSize;
    }

    private void initMediaCodecAndFormat(IDataSource iDataSource) {
        AppMethodBeat.m2504i(128544);
        int i = 0;
        while (i < this.mMediaExtractor.getTrackCount()) {
            MediaFormat trackFormat = this.mMediaExtractor.getTrackFormat(i);
            String string = trackFormat.getString("mime");
            if (TextUtils.isEmpty(string) || !string.startsWith(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE)) {
                i++;
            } else {
                this.mInfo = new AudioInformation();
                this.mInfo.setAudioType(iDataSource.getAudioType());
                setAudioType(iDataSource.getAudioType());
                initAudioInformation(string, i, trackFormat, iDataSource);
                AppMethodBeat.m2505o(128544);
                return;
            }
        }
        AppMethodBeat.m2505o(128544);
    }

    private void initAudioInformation(String str, int i, MediaFormat mediaFormat, IDataSource iDataSource) {
        int integer;
        int i2;
        AppMethodBeat.m2504i(128545);
        this.mMediaExtractor.selectTrack(i);
        this.mMediaCodec = MediaCodec.createDecoderByType(str);
        this.mMediaCodec.configure(mediaFormat, null, null, 0);
        this.mMediaFormat = mediaFormat;
        int integer2 = this.mMediaFormat.getInteger("sample-rate");
        int integer3 = this.mMediaFormat.getInteger("channel-count");
        long j = this.mMediaFormat.getLong("durationUs") / 1000;
        if (this.mMediaFormat.containsKey(FFmpegMetadataRetriever.METADATA_KEY_VARIANT_BITRATE)) {
            integer = this.mMediaFormat.getInteger(FFmpegMetadataRetriever.METADATA_KEY_VARIANT_BITRATE) / 1000;
        } else if (j > 0) {
            integer = (int) ((iDataSource.getSize() / j) * 8);
        } else {
            integer = 0;
        }
        if (VERSION.SDK_INT >= 24 && this.mMediaFormat.containsKey("pcm-encoding")) {
            switch (this.mMediaFormat.getInteger("pcm-encoding")) {
                case 3:
                    i2 = 1;
                    break;
                case 4:
                    i2 = 4;
                    break;
                default:
                    i2 = 2;
                    break;
            }
        }
        i2 = 2;
        if (VERSION.SDK_INT >= 21) {
            int i3 = 0;
            try {
                i3 = this.mMediaFormat.getInteger("bitrate-mode");
            } catch (Exception e) {
            }
            switch (i3) {
                case 1:
                    this.mInfo.setCbr(3);
                    break;
                case 2:
                    this.mInfo.setCbr(1);
                    break;
            }
        }
        this.mInfo.setSampleRate((long) integer2);
        this.mInfo.setChannels(integer3);
        this.mInfo.setDuration(j);
        this.mInfo.setBitrate(integer);
        this.mInfo.setBitDept(i2);
        AudioType audioType = iDataSource.getAudioType();
        if (audioType == AudioType.FLAC) {
            this.mSeekTable = new FlacSeekTable(integer2);
        } else if (audioType == AudioType.M4A || audioType == AudioType.MP4) {
            this.mSeekTable = new Mp4SeekTable();
        } else if (audioType == AudioType.MP3) {
            this.mSeekTable = new Mp3SeekTable();
        }
        if (this.mSeekTable != null) {
            try {
                this.mSeekTable.parse(iDataSource);
            } catch (InvalidBoxException e2) {
                this.mSeekTable = null;
                Logger.m71022e(TAG, "seek table parse", e2);
            }
        }
        this.mMediaCodec.start();
        AppMethodBeat.m2505o(128545);
    }

    public long getBytePositionOfTime(long j) {
        AppMethodBeat.m2504i(128546);
        int bitrate = this.mInfo.getBitrate();
        long seek;
        if (this.mSeekTable != null) {
            seek = this.mSeekTable.seek(j);
            AppMethodBeat.m2505o(128546);
            return seek;
        } else if (bitrate > 0) {
            seek = ((long) bitrate) * j;
            AppMethodBeat.m2505o(128546);
            return seek;
        } else if (getDuration() > 0) {
            seek = (this.mFileSize * j) / getDuration();
            AppMethodBeat.m2505o(128546);
            return seek;
        } else {
            AppMethodBeat.m2505o(128546);
            return 0;
        }
    }
}
