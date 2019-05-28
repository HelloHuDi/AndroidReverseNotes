package com.tencent.qqmusic.mediaplayer;

import android.media.AudioTrack;
import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.qqmusic.mediaplayer.audiofx.IAudioListener;
import com.tencent.qqmusic.mediaplayer.util.Logger;
import com.tencent.qqmusic.mediaplayer.utils.AudioUtil;
import java.util.Stack;

public class StreamDecodeDataComponent extends BaseDecodeDataComponent {
    private static final int DTS_OPTIMAL_FRAME_BYTE = 2048;
    private static final int MAX_AUDIO_TRACK_BUFFER_TIME = 1;
    private static final int MIN_AUDIO_TRACK_BUFFER_TIMES = 1;
    private static final String TAG = "StreamDecodeDataComponent";
    private static final int USE_AUDIO_TRACK_TIME_THRESHOLD = 1000;
    private long mCurrentFrameCount = 0;
    private boolean mNeedFlush = false;
    private final Stack<Integer> mSeekRecord = new Stack();
    private int mTrackBufferSizeInByte;

    /* renamed from: com.tencent.qqmusic.mediaplayer.StreamDecodeDataComponent$2 */
    class C161272 implements Runnable {
        C161272() {
        }

        public void run() {
            AppMethodBeat.m2504i(104688);
            StreamDecodeDataComponent.this.mCallback.playerPaused(StreamDecodeDataComponent.this.mCorePlayer);
            AppMethodBeat.m2505o(104688);
        }
    }

    /* renamed from: com.tencent.qqmusic.mediaplayer.StreamDecodeDataComponent$1 */
    class C242471 implements Runnable {
        C242471() {
        }

        public void run() {
            AppMethodBeat.m2504i(104694);
            if (StreamDecodeDataComponent.this.getPlayerState() == 8) {
                Logger.m71027w(StreamDecodeDataComponent.TAG, "[run] state changed to END during postRunnable!");
                AppMethodBeat.m2505o(104694);
                return;
            }
            StreamDecodeDataComponent.this.mCallback.playerPrepared(StreamDecodeDataComponent.this.mCorePlayer);
            AppMethodBeat.m2505o(104694);
        }
    }

    StreamDecodeDataComponent(CorePlayer corePlayer, PlayerStateRunner playerStateRunner, AudioInformation audioInformation, PlayerCallback playerCallback, HandleDecodeDataCallback handleDecodeDataCallback, Handler handler, int i) {
        super(corePlayer, playerStateRunner, audioInformation, playerCallback, handleDecodeDataCallback, handler, i);
        AppMethodBeat.m2504i(104488);
        AppMethodBeat.m2505o(104488);
    }

    /* Access modifiers changed, original: 0000 */
    public void play() {
        AppMethodBeat.m2504i(104489);
        super.play();
        if (!(this.mAudioTrack == null || this.mAudioTrack.getState() != 1 || this.mAudioTrack.getPlayState() == 3)) {
            try {
                this.mAudioTrack.play();
                AppMethodBeat.m2505o(104489);
                return;
            } catch (IllegalStateException e) {
            }
        }
        AppMethodBeat.m2505o(104489);
    }

    /* Access modifiers changed, original: 0000 */
    public void pause() {
        AppMethodBeat.m2504i(104490);
        super.pause();
        if (!(this.mAudioTrack == null || this.mAudioTrack.getState() != 1 || this.mAudioTrack.getPlayState() == 2)) {
            try {
                this.mAudioTrack.pause();
                AppMethodBeat.m2505o(104490);
                return;
            } catch (IllegalStateException e) {
            }
        }
        AppMethodBeat.m2505o(104490);
    }

    /* Access modifiers changed, original: 0000 */
    public int getAudioStreamType() {
        return 3;
    }

    /* Access modifiers changed, original: 0000 */
    /* JADX WARNING: Removed duplicated region for block: B:177:0x07c0  */
    /* JADX WARNING: Removed duplicated region for block: B:143:0x05b1  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void handleDecodeData() {
        AppMethodBeat.m2504i(104491);
        if (this.mInformation == null || this.mCorePlayer.mIsExit) {
            if (!this.mCorePlayer.mIsExit) {
                Logger.m71021e(TAG, axiliary("不留痕迹的退出 时机：获取Information时 step = 3"));
                this.mStateRunner.transfer(Integer.valueOf(9));
                callExceptionCallback(91, 63);
            }
            AppMethodBeat.m2505o(104491);
            return;
        }
        try {
            if (0 == this.mInformation.getSampleRate()) {
                Logger.m71021e(TAG, "failed to getSampleRate");
                this.mStateRunner.transfer(Integer.valueOf(9));
                callExceptionCallback(91, 63);
                AppMethodBeat.m2505o(104491);
                return;
            }
            this.mHasInit = true;
            if (!createAudioTrack()) {
                Logger.m71021e(TAG, "failed to createAudioTrack");
                this.mStateRunner.transfer(Integer.valueOf(9));
                AppMethodBeat.m2505o(104491);
                return;
            }
            this.mStateRunner.transfer(Integer.valueOf(2));
            initAudioListeners(this.mInformation.getPlaySample(), this.mPlayBitDepth, this.mInformation.getChannels());
            postRunnable(new C242471(), 20);
            if (!(isPlaying() || this.mCorePlayer.mIsExit)) {
                Logger.m71025i(TAG, axiliary("prepared. waiting..."));
                this.mSignalControl.doWait();
                Logger.m71025i(TAG, axiliary("woke after preparing"));
            }
            PlayerConfigManager.getInstance().setCommonPlayerRef(this.mCorePlayer);
            this.mDecodeBufferInfo.setByteBufferCapacity(this.mBuffSize);
            int i = 0;
            long j = 0;
            long currentTimeMillis = System.currentTimeMillis();
            long j2 = 0;
            int i2 = 0;
            int i3 = 0;
            Object obj = 1;
            int i4 = 0;
            while (!this.mCorePlayer.mIsExit) {
                int seekTo;
                int i5 = -1;
                synchronized (this.mSeekRecord) {
                    try {
                        if (!this.mSeekRecord.empty()) {
                            i5 = ((Integer) this.mSeekRecord.pop()).intValue();
                            this.mSeekRecord.clear();
                            Logger.m71025i(TAG, "execute seek: " + i5 + ", abandon the others");
                        }
                    } finally {
                        while (true) {
                        }
                        AppMethodBeat.m2505o(104491);
                    }
                }
                if (i5 < 0 && this.mNeedFlush) {
                    i5 = BaseDecodeDataComponent.getAudioTrackPosition(this.mCurrentFrameCount, this.mAudioTrack);
                    Logger.m71025i(TAG, axiliary("[run] flashback to ".concat(String.valueOf(i5))));
                    this.mNeedFlush = false;
                }
                if (i5 >= 0) {
                    if (((long) i5) > this.mInformation.getDuration() - 1000 && this.mInformation.getDuration() > 1000) {
                        i5 = (int) (this.mInformation.getDuration() - 1000);
                    }
                    seekTo = this.mHandleDecodeDataCallback.seekTo(i5);
                    if (seekTo < 0) {
                        Logger.m71021e(TAG, axiliary("seekTo failed: ".concat(String.valueOf(seekTo))));
                        this.mStateRunner.transfer(Integer.valueOf(9));
                        callExceptionCallback(95, 74);
                        AppMethodBeat.m2505o(104491);
                        return;
                    }
                    if (this.mAudioTrack != null) {
                        this.mCurrentFrameCount = Math.round((((double) i5) / 1000.0d) * ((double) this.mAudioTrack.getSampleRate()));
                        if (this.mAudioTrack.getPlayState() == 3) {
                            this.mAudioTrack.pause();
                            this.mAudioTrack.flush();
                            this.mAudioTrack.play();
                        } else {
                            this.mAudioTrack.flush();
                        }
                        i2 = 0;
                    }
                    this.mCurPosition = (long) i5;
                    this.mTimer.refreshTimeInMs((long) i5);
                    notifySeekCompleteForAudioListeners((long) i5);
                    this.mCallback.playerSeekCompletion(this.mCorePlayer, i5);
                }
                int i6 = i2;
                if (!isPaused()) {
                    if (isIdle() || isError() || isStopped()) {
                        break;
                    } else if (isCompleted()) {
                        i5 = (i6 / this.mInformation.getChannels()) - i4;
                        if (i5 <= 0) {
                            i5 = 0;
                        }
                        i3 = (this.mTrackBufferSizeInByte / getBytesPerSampleInPlay(this.mInformation.getBitDept())) / this.mInformation.getChannels();
                        if (i5 >= i3) {
                            i5 = i3;
                        }
                        i5 = (int) (((long) (i5 * 1000)) / this.mInformation.getSampleRate());
                        i3 = AudioPlayerConfigure.minAudioTrackWaitTimeMs;
                        Logger.m71025i(TAG, axiliary("writeShortCount: " + i6 + ", playFramePosition: " + i4 + ", leftTimeInMs: " + i5 + ", minAudioTrackWaitTimeMs: " + i3));
                        if (i5 > 0) {
                            synchronized (this) {
                                try {
                                    wait((long) Math.max(i3, i5));
                                } finally {
                                    while (true) {
                                    }
                                    AppMethodBeat.m2505o(104491);
                                }
                            }
                            return;
                        }
                    } else {
                        int i7;
                        long j3;
                        if (obj != null) {
                            try {
                                long j4;
                                seekTo = this.mHandleDecodeDataCallback.pullDecodeData(this.mBuffSize, this.mDecodeBufferInfo.byteBuffer);
                                this.mDecodeBufferInfo.bufferSize = seekTo;
                                long j5 = ((long) this.mDecodeBufferInfo.bufferSize) + j;
                                j = ((long) this.mDecodeBufferInfo.bufferSize) + j2;
                                this.mHasDecode = true;
                                if (i == 0) {
                                    int i8;
                                    i7 = 10;
                                    long calcBitMinSize = getCalcBitMinSize(this.mInformation);
                                    Logger.m71025i(TAG, axiliary("minSize: " + calcBitMinSize + ", mDecodeBufferInfo.bufferSize: " + this.mDecodeBufferInfo.bufferSize));
                                    if (calcBitMinSize > 0) {
                                        i8 = seekTo;
                                        while (((long) this.mDecodeBufferInfo.bufferSize) < calcBitMinSize && i7 >= 0) {
                                            this.mDecodeBufferInfo.setTempByteBufferCapacity(this.mBuffSize);
                                            i8 = this.mHandleDecodeDataCallback.pullDecodeData(this.mBuffSize, this.mDecodeBufferInfo.tempByteBuffer);
                                            if (i8 > 0) {
                                                this.mDecodeBufferInfo.appendByte(this.mDecodeBufferInfo.tempByteBuffer, 0, i8);
                                                BufferInfo bufferInfo = this.mDecodeBufferInfo;
                                                bufferInfo.bufferSize += i8;
                                                j5 += (long) i8;
                                                j += (long) i8;
                                            }
                                            seekTo = i7 - 1;
                                            Logger.m71020d(TAG, axiliary("decode tmpSize: " + i8 + ", mDecodeBufferInfo.bufferSize: " + this.mDecodeBufferInfo.bufferSize));
                                            i7 = seekTo;
                                        }
                                    } else {
                                        i8 = seekTo;
                                    }
                                    if (this.mInformation.getBitDept() == 0) {
                                        this.mInformation.setBitDept(AudioRecognition.calcBitDept(j5, this.mHandleDecodeDataCallback.getCurPositionByDecoder(), this.mInformation.getChannels(), this.mInformation.getSampleRate()));
                                    }
                                    i = this.mInformation.getBitDept();
                                    if ((!this.isUseFloatInHiRes && i >= 3) || i <= 0) {
                                        Logger.m71027w(TAG, "mPlayBitDept is set with 2, old value: ".concat(String.valueOf(i)));
                                        i = 2;
                                    }
                                    Logger.m71020d(TAG, axiliary("mPlayBitDept: ".concat(String.valueOf(i))));
                                    seekTo = i8;
                                    j3 = j;
                                    j4 = j5;
                                } else {
                                    j3 = j;
                                    j4 = j5;
                                }
                                i3 = seekTo;
                                j = j4;
                            } catch (SoNotFindException e) {
                                Logger.m71024e(TAG, e);
                                this.mStateRunner.transfer(Integer.valueOf(9));
                                callExceptionCallback(92, 62);
                                AppMethodBeat.m2505o(104491);
                                return;
                            } catch (Throwable e2) {
                                Logger.m71024e(TAG, e2);
                                this.mStateRunner.transfer(Integer.valueOf(9));
                                callExceptionCallback(92, 67);
                                AppMethodBeat.m2505o(104491);
                                return;
                            }
                        }
                        j3 = j2;
                        if (this.mNeedChangePlayThreadPriority) {
                            this.mNeedChangePlayThreadPriority = false;
                            PlayerConfigManager.getInstance().changeDecodeThreadPriorityIfNeed();
                        }
                        long currentTimeMillis2 = System.currentTimeMillis();
                        j2 = currentTimeMillis2 - currentTimeMillis;
                        if (j2 > 1000) {
                            PlayerConfigManager.getInstance().updateDecodeSpeed((long) ((1.0f * ((float) j3)) / ((float) j2)));
                            j2 = 0;
                            currentTimeMillis = currentTimeMillis2;
                        } else {
                            j2 = j3;
                        }
                        if (this.mDecodeBufferInfo.bufferSize > 0) {
                            if (!this.mHasDecodeSuccess) {
                                this.mCallback.playerStarted(this.mCorePlayer);
                                this.mHasDecodeSuccess = true;
                            }
                            handleHighBitDept(this.mDecodeBufferInfo, this.mNewBitDepthBufferInfo);
                            handleHighSample(this.mNewBitDepthBufferInfo, this.mReSampleBufferInfo);
                            if (this.isUseFloatInHiRes) {
                                convertBytePcmToFloatPcm(this.mReSampleBufferInfo, this.mFloatBufferInfo);
                                processAudioListeners(this.mFloatBufferInfo, this.mFloatBufferInfo);
                            } else {
                                processAudioListeners(this.mReSampleBufferInfo, this.mDTSBufferInfo);
                            }
                            if (this.mAudioTrack != null && isPlaying()) {
                                Object obj2;
                                i7 = this.mTerminalAudioEffectList.size() - 1;
                                while (i7 >= 0) {
                                    IAudioListener iAudioListener = (IAudioListener) this.mTerminalAudioEffectList.get(i7);
                                    if (iAudioListener.isEnabled()) {
                                        if (this.isUseFloatInHiRes) {
                                            iAudioListener.onPcm(this.mFloatBufferInfo, this.mFloatBufferInfo);
                                        } else {
                                            iAudioListener.onPcm(this.mDTSBufferInfo, this.mDTSBufferInfo);
                                        }
                                        obj2 = 1;
                                        if (obj2 != null) {
                                            if (this.isUseFloatInHiRes) {
                                                seekTo = this.mAudioTrack.write(this.mFloatBufferInfo.floatBuffer, 0, this.mFloatBufferInfo.bufferSize, 0);
                                                if (seekTo >= 0) {
                                                    obj2 = 1;
                                                    if (seekTo != this.mFloatBufferInfo.bufferSize) {
                                                        Logger.m71027w(TAG, axiliary("mAudioTrack write float not equal: " + seekTo + ", expect: " + this.mFloatBufferInfo.bufferSize));
                                                    }
                                                    i6 += this.mFloatBufferInfo.bufferSize * 2;
                                                } else if (this.mAudioTrack.getPlayState() == 3) {
                                                    Logger.m71021e(TAG, axiliary("mAudioTrack write float failed: " + seekTo + ", expect: " + this.mFloatBufferInfo.bufferSize));
                                                    this.mStateRunner.transfer(Integer.valueOf(9));
                                                    callExceptionCallback(92, 102);
                                                    return;
                                                } else {
                                                    obj2 = null;
                                                    Logger.m71025i(TAG, axiliary("write data to audiotrack failed, but it's OK"));
                                                }
                                            } else {
                                                seekTo = this.mAudioTrack.write(this.mDTSBufferInfo.byteBuffer, 0, this.mDTSBufferInfo.bufferSize);
                                                if (seekTo >= 0) {
                                                    obj2 = 1;
                                                    if (seekTo != this.mDTSBufferInfo.bufferSize) {
                                                        Logger.m71027w(TAG, axiliary("mAudioTrack write bytes not equal: " + seekTo + ", expect: " + this.mDTSBufferInfo.bufferSize));
                                                    }
                                                    i6 += this.mDTSBufferInfo.bufferSize;
                                                } else if (this.mAudioTrack.getPlayState() == 3) {
                                                    Logger.m71021e(TAG, axiliary("mAudioTrack write bytes failed: " + seekTo + ", expect: " + this.mDTSBufferInfo.bufferSize));
                                                    this.mStateRunner.transfer(Integer.valueOf(9));
                                                    callExceptionCallback(92, 102);
                                                    AppMethodBeat.m2505o(104491);
                                                    return;
                                                } else {
                                                    obj2 = null;
                                                    Logger.m71025i(TAG, axiliary("write data to audiotrack failed, but it's OK"));
                                                }
                                            }
                                            seekTo = AudioUtil.getPlaybackHeadPositionSafely(this.mAudioTrack);
                                        } else {
                                            obj2 = obj;
                                            seekTo = i4;
                                        }
                                        obj = obj2;
                                        i4 = seekTo;
                                        i2 = i6;
                                    } else {
                                        i7--;
                                    }
                                }
                                obj2 = null;
                                if (obj2 != null) {
                                }
                                obj = obj2;
                                i4 = seekTo;
                                i2 = i6;
                            }
                        } else {
                            this.mHandleDecodeDataCallback.onPullDecodeDataEndOrFailed(i3, 92);
                        }
                        i2 = i6;
                    }
                } else {
                    postRunnable(new C161272(), 20);
                    Logger.m71025i(TAG, axiliary("paused. waiting..."));
                    doWaitForPaused();
                    Logger.m71025i(TAG, axiliary("woke after pausing"));
                    i2 = i6;
                }
            }
            AppMethodBeat.m2505o(104491);
        } catch (SoNotFindException e22) {
            Logger.m71024e(TAG, e22);
        }
    }

    private boolean createAudioTrack() {
        AppMethodBeat.m2504i(104492);
        Logger.m71020d(TAG, axiliary("createAudioTrack"));
        if (!this.mStateRunner.isEqual(Integer.valueOf(3))) {
            Logger.m71021e(TAG, "mState is not preparing");
            callExceptionCallback(91, 54);
            AppMethodBeat.m2505o(104492);
            return false;
        } else if (this.mInformation.getSampleRate() <= 0) {
            Logger.m71021e(TAG, "mInformation.getSampleRate() failed");
            callExceptionCallback(91, 64);
            AppMethodBeat.m2505o(104492);
            return false;
        } else {
            int i = 12;
            int channels = this.mInformation.getChannels();
            if (channels == 1) {
                i = 4;
            } else if (channels == 2) {
                i = 12;
            } else if (channels == 6) {
                i = 252;
            } else if (channels == 8) {
                i = 1020;
            }
            int minPcmBufferSize = (int) this.mHandleDecodeDataCallback.getMinPcmBufferSize();
            Logger.m71020d(TAG, axiliary(this.mInformation.toString()));
            this.mPlaySample = this.mInformation.getSampleRate();
            while (this.mPlaySample > MAX_PLAY_SAMPLE_RATE) {
                this.mPlaySample /= 2;
            }
            this.mInformation.setPlaySample(this.mPlaySample);
            int bytesPerSampleInPlay = getBytesPerSampleInPlay(this.mInformation.getBitDept());
            if (bytesPerSampleInPlay == 0) {
                bytesPerSampleInPlay = 2;
            }
            if (CAN_USE_FLOAT_IN_HI_RES && this.mInformation.getBitDept() >= 3 && this.mInformation.getSampleRate() > 48000) {
                this.mPlayBitDepth = bytesPerSampleInPlay;
                this.isUseFloatInHiRes = true;
                if (this.mPlaySample != this.mInformation.getSampleRate()) {
                    Logger.m71025i(TAG, axiliary("will use float resampled pcm for Hi-Res, bitDept: " + this.mInformation.getBitDept() + ", origin sample rate: " + this.mInformation.getSampleRate() + ", target sample rate: " + this.mPlaySample));
                } else {
                    Logger.m71025i(TAG, axiliary("will use float pcm for Hi-Res, bitDept: " + this.mInformation.getBitDept() + ", sample rate: " + this.mPlaySample));
                }
            } else if (!CAN_USE_FLOAT_IN_HI_RES && this.mInformation.getBitDept() >= 3) {
                this.mPlayBitDepth = 2;
                if (this.mPlaySample != this.mInformation.getSampleRate()) {
                    Logger.m71025i(TAG, axiliary("will use byte pcm resampled and bitDept converted, origin bitDept: " + this.mInformation.getBitDept() + ", target bitDept: " + this.mPlayBitDepth + ", origin sample rate: " + this.mInformation.getSampleRate() + ", target sample rate: " + this.mPlaySample));
                } else {
                    Logger.m71025i(TAG, axiliary("will use byte pcm with bitDept converted, origin bitDept: " + this.mInformation.getBitDept() + ", target bitDept: " + this.mPlayBitDepth));
                }
            } else if (this.mPlaySample != this.mInformation.getSampleRate()) {
                this.mPlayBitDepth = bytesPerSampleInPlay;
                Logger.m71025i(TAG, axiliary("will use byte pcm resampled, bitDept: " + this.mInformation.getBitDept() + ", origin sample rate: " + this.mInformation.getSampleRate() + ", target sample rate: " + this.mPlaySample));
            } else {
                this.mPlayBitDepth = 2;
                Logger.m71025i(TAG, axiliary("will use normal byte pcm, bitDept: " + this.mInformation.getBitDept() + ", sample rate: " + this.mPlaySample));
            }
            int i2 = 2;
            if (bytesPerSampleInPlay == 1) {
                i2 = 3;
            } else if (bytesPerSampleInPlay == 2) {
                i2 = 2;
            } else if (this.isUseFloatInHiRes) {
                i2 = 4;
            }
            int minBufferSize = getMinBufferSize(this.mPlaySample, i, i2, channels, bytesPerSampleInPlay);
            Logger.m71025i(TAG, axiliary("[createAudioTrack] playback_bufsize:" + minBufferSize + " decoderBufsizeInByte:" + minPcmBufferSize));
            if (minBufferSize % 2048 != 0) {
                minBufferSize = ((minBufferSize / 2048) + 1) * 2048;
            }
            if (minBufferSize > minPcmBufferSize) {
                minPcmBufferSize = minBufferSize;
            }
            this.mBuffSize = minPcmBufferSize;
            Logger.m71025i(TAG, axiliary(String.format("playback_bufsize: %d, mBuffSize: %d, mPlaySample: %d, playChannel: %d, pcmEncoding: %d", new Object[]{Integer.valueOf(minBufferSize), Integer.valueOf(this.mBuffSize), Long.valueOf(this.mPlaySample), Integer.valueOf(channels), Integer.valueOf(i2)})));
            minPcmBufferSize = Math.max((int) (Math.floor((double) ((((1 * this.mPlaySample) * ((long) channels)) * 2) / ((long) minBufferSize))) + 1.0d), 1);
            Logger.m71020d(TAG, axiliary("times: " + minPcmBufferSize + ", MIN_AUDIO_TRACK_BUFFER_TIMES: 1"));
            int i3 = minPcmBufferSize;
            while (i3 > 0) {
                try {
                    this.mTrackBufferSizeInByte = minBufferSize * i3;
                    this.mAudioTrack = new AudioTrack(this.mAudioStreamType, (int) this.mPlaySample, i, i2, this.mTrackBufferSizeInByte, 1);
                    Logger.m71025i(TAG, axiliary("[createAudioTrack] new AudioTrack, sampleRate: " + this.mPlaySample + ", channels: " + i + ", bitDepth: " + bytesPerSampleInPlay + ", buffer: " + this.mTrackBufferSizeInByte));
                    minPcmBufferSize = this.mAudioTrack.getState();
                    if (minPcmBufferSize == 1) {
                        Logger.m71025i(TAG, axiliary("new AudioTrack succeed"));
                        break;
                    }
                    Logger.m71021e(TAG, axiliary("audioTrack create fail!!! state = ".concat(String.valueOf(minPcmBufferSize))));
                    this.mAudioTrack.release();
                    i3 -= 2;
                } catch (Throwable th) {
                    Logger.m71024e(TAG, th);
                }
            }
            if (this.mAudioTrack == null || this.mAudioTrack.getState() != 1) {
                this.mCreateAudioTrackFail = true;
                Logger.m71021e(TAG, axiliary("create audioTrack fail mCreateAudioTrackFail = true"));
                this.mAudioTrack = null;
                callExceptionCallback(92, 66);
                AppMethodBeat.m2505o(104492);
                return false;
            }
            Logger.m71020d(TAG, axiliary("create audioTrack success times = ".concat(String.valueOf(i3))));
            this.mStateRunner.setAudioTrack(this.mAudioTrack);
            AppMethodBeat.m2505o(104492);
            return true;
        }
    }

    private int getMinBufferSize(long j, int i, int i2, int i3, int i4) {
        AppMethodBeat.m2504i(104493);
        int minBufferSize = AudioTrack.getMinBufferSize((int) j, i, i2);
        if (minBufferSize < 0) {
            Logger.m71025i(TAG, axiliary("minBufferSize = " + minBufferSize + " mPlaySample = " + j + "  channelConfiguration = " + i + "   pcmEncoding = " + i2));
            minBufferSize = (i3 * 3536) * i4;
        }
        AppMethodBeat.m2505o(104493);
        return minBufferSize;
    }

    private void addSeekRecord(int i) {
        AppMethodBeat.m2504i(104494);
        synchronized (this.mSeekRecord) {
            try {
                Logger.m71025i(TAG, "add seek: ".concat(String.valueOf(i)));
                this.mSeekRecord.push(Integer.valueOf(i));
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(104494);
            }
        }
    }

    /* Access modifiers changed, original: 0000 */
    public void flush() {
        this.mNeedFlush = true;
    }

    private long getCalcBitMinSize(AudioInformation audioInformation) {
        AppMethodBeat.m2504i(104495);
        if (audioInformation != null) {
            long sampleRate = (long) ((((float) ((audioInformation.getSampleRate() * ((long) audioInformation.getChannels())) * ((long) audioInformation.getBitDept()))) * 5.0f) / 1000.0f);
            AppMethodBeat.m2505o(104495);
            return sampleRate;
        }
        AppMethodBeat.m2505o(104495);
        return 0;
    }

    /* Access modifiers changed, original: 0000 */
    public void setAudioStreamType(int i) {
        AppMethodBeat.m2504i(104496);
        if (i == this.mAudioStreamType) {
            AppMethodBeat.m2505o(104496);
            return;
        }
        try {
            this.mAudioStreamType = i;
            if (this.mAudioTrack != null) {
                AudioTrack audioTrack = new AudioTrack(i, this.mAudioTrack.getSampleRate(), this.mAudioTrack.getChannelConfiguration(), this.mAudioTrack.getAudioFormat(), this.mTrackBufferSizeInByte, 1);
                Logger.m71025i(TAG, axiliary("[setAudioStreamType] new AudioTrack, sampleRate: " + this.mAudioTrack.getSampleRate() + ", channels: " + this.mAudioTrack.getChannelConfiguration() + ", bitDepth: " + this.mAudioTrack.getAudioFormat() + ", buffer: " + this.mTrackBufferSizeInByte));
                int playState = this.mAudioTrack.getPlayState();
                if (playState == 3) {
                    pause();
                }
                this.mAudioTrack.release();
                this.mAudioTrack = audioTrack;
                this.mStateRunner.setAudioTrack(this.mAudioTrack);
                if (playState == 3) {
                    play();
                }
            }
            AppMethodBeat.m2505o(104496);
        } catch (IllegalArgumentException | IllegalStateException e) {
            Logger.m71022e(TAG, "failed in setting audio stream type to :".concat(String.valueOf(i)), e);
            AppMethodBeat.m2505o(104496);
        }
    }

    /* Access modifiers changed, original: 0000 */
    public long getCurPosition() {
        AppMethodBeat.m2504i(104497);
        AudioTrack audioTrack = this.mAudioTrack;
        long j;
        if (audioTrack == null || audioTrack.getState() == 0) {
            j = this.mCurPosition;
            AppMethodBeat.m2505o(104497);
            return j;
        }
        AudioInformation audioInformation = this.mInformation;
        if (audioInformation == null) {
            j = this.mCurPosition;
            AppMethodBeat.m2505o(104497);
            return j;
        }
        int audioTrackPosition = BaseDecodeDataComponent.getAudioTrackPosition(this.mCurrentFrameCount, audioTrack);
        j = audioInformation.getPlaySample() * ((long) (audioInformation.getChannels() * getBytesPerSampleInPlay(audioInformation.getBitDept())));
        j = this.mHandleDecodeDataCallback.getCurPositionByDecoder() - Math.max(0, j > 0 ? (((long) this.mTrackBufferSizeInByte) / j) * 1000 : 0);
        if (j < 0) {
            this.mCurPosition = (long) audioTrackPosition;
        } else if (audioTrackPosition <= 0 || Math.abs(((long) audioTrackPosition) - j) >= 1000) {
            this.mCurPosition = j;
        } else {
            this.mCurPosition = (long) audioTrackPosition;
        }
        j = this.mCurPosition;
        AppMethodBeat.m2505o(104497);
        return j;
    }

    /* Access modifiers changed, original: 0000 */
    public void seek(int i) {
        AppMethodBeat.m2504i(104498);
        addSeekRecord(i);
        refreshTimeAndNotify(i);
        AppMethodBeat.m2505o(104498);
    }

    /* Access modifiers changed, original: 0000 */
    public void release() {
        AppMethodBeat.m2504i(104499);
        super.release();
        this.mCurrentFrameCount = 0;
        AppMethodBeat.m2505o(104499);
    }
}
