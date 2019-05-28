package com.tencent.qqmusic.mediaplayer;

import android.media.AudioTrack;
import android.os.Handler;
import com.facebook.internal.Utility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.qqmusic.mediaplayer.audiofx.IAudioListener;
import com.tencent.qqmusic.mediaplayer.util.Logger;
import com.tencent.qqmusic.mediaplayer.utils.AudioUtil;
import java.util.ArrayList;
import java.util.List;

public class StaticDecodeDataComponent extends BaseDecodeDataComponent {
    private static final String TAG = "StaticDecodeDataComponent";
    private int mAllBufferSize;
    private List<BufferInfo> mAllPcmBufferList;
    private int mBitDept;
    private boolean mHasTerminal;
    private boolean mIsfirstStarted;

    /* renamed from: com.tencent.qqmusic.mediaplayer.StaticDecodeDataComponent$2 */
    class C161252 implements Runnable {
        C161252() {
        }

        public void run() {
            AppMethodBeat.m2504i(104484);
            StaticDecodeDataComponent.this.mCallback.playerPaused(StaticDecodeDataComponent.this.mCorePlayer);
            AppMethodBeat.m2505o(104484);
        }
    }

    /* renamed from: com.tencent.qqmusic.mediaplayer.StaticDecodeDataComponent$4 */
    class C161264 implements Runnable {
        C161264() {
        }

        public void run() {
            AppMethodBeat.m2504i(104778);
            StaticDecodeDataComponent.this.mCallback.playerEnded(StaticDecodeDataComponent.this.mCorePlayer);
            AppMethodBeat.m2505o(104778);
        }
    }

    /* renamed from: com.tencent.qqmusic.mediaplayer.StaticDecodeDataComponent$3 */
    class C364113 implements Runnable {
        C364113() {
        }

        public void run() {
            AppMethodBeat.m2504i(104482);
            StaticDecodeDataComponent.this.mCallback.playerStopped(StaticDecodeDataComponent.this.mCorePlayer);
            AppMethodBeat.m2505o(104482);
        }
    }

    /* renamed from: com.tencent.qqmusic.mediaplayer.StaticDecodeDataComponent$1 */
    class C413521 implements Runnable {
        C413521() {
        }

        public void run() {
            AppMethodBeat.m2504i(104687);
            if (StaticDecodeDataComponent.this.getPlayerState() == 8) {
                Logger.m71027w(StaticDecodeDataComponent.TAG, "[run] state changed to END during postRunnable!");
                AppMethodBeat.m2505o(104687);
                return;
            }
            StaticDecodeDataComponent.this.mCallback.playerPrepared(StaticDecodeDataComponent.this.mCorePlayer);
            AppMethodBeat.m2505o(104687);
        }
    }

    StaticDecodeDataComponent(CorePlayer corePlayer, PlayerStateRunner playerStateRunner, AudioInformation audioInformation, PlayerCallback playerCallback, HandleDecodeDataCallback handleDecodeDataCallback, Handler handler, int i) {
        super(corePlayer, playerStateRunner, audioInformation, playerCallback, handleDecodeDataCallback, handler, i);
        this.mBitDept = 2;
        this.mHasTerminal = false;
        this.mBuffSize = Utility.DEFAULT_STREAM_BUFFER_SIZE;
    }

    /* Access modifiers changed, original: 0000 */
    public int getAudioStreamType() {
        return 0;
    }

    /* Access modifiers changed, original: 0000 */
    public long getCurPosition() {
        AppMethodBeat.m2504i(104509);
        AudioTrack audioTrack = this.mAudioTrack;
        long j;
        if (audioTrack == null || audioTrack.getState() == 0) {
            j = this.mCurPosition;
            AppMethodBeat.m2505o(104509);
            return j;
        }
        this.mCurPosition = (long) BaseDecodeDataComponent.getAudioTrackPosition(0, audioTrack);
        j = this.mCurPosition;
        AppMethodBeat.m2505o(104509);
        return j;
    }

    /* Access modifiers changed, original: 0000 */
    public void handleDecodeData() {
        AppMethodBeat.m2504i(104510);
        if (this.mInformation != null) {
            try {
                if (0 == this.mInformation.getSampleRate()) {
                    Logger.m71021e(TAG, "failed to getSampleRate");
                    this.mStateRunner.transfer(Integer.valueOf(9));
                    callExceptionCallback(91, 63);
                    AppMethodBeat.m2505o(104510);
                    return;
                }
                this.mHasInit = true;
                if (!decodeAllData()) {
                    Logger.m71021e(TAG, "failed to decodeAllData");
                    this.mStateRunner.transfer(Integer.valueOf(9));
                    AppMethodBeat.m2505o(104510);
                } else if (!createAudioTrack()) {
                    Logger.m71021e(TAG, "failed to createAudioTrack");
                    this.mStateRunner.transfer(Integer.valueOf(9));
                    AppMethodBeat.m2505o(104510);
                } else if (!writeAudioTrack() && !this.mHasTerminal) {
                    Logger.m71021e(TAG, "failed to writeAudioTrack");
                    this.mStateRunner.transfer(Integer.valueOf(9));
                    AppMethodBeat.m2505o(104510);
                } else if (this.mHasTerminal) {
                    this.mStateRunner.transfer(Integer.valueOf(7));
                    AppMethodBeat.m2505o(104510);
                } else {
                    this.mStateRunner.transfer(Integer.valueOf(2));
                    this.mIsfirstStarted = false;
                    initAudioListeners(this.mInformation.getPlaySample(), getBytesPerSampleInPlay(this.mInformation.getBitDept()), this.mInformation.getChannels());
                    postRunnable(new C413521(), 20);
                    Logger.m71025i(TAG, axiliary("prepared. waiting..."));
                    this.mSignalControl.doWait();
                    Logger.m71025i(TAG, axiliary("woke after preparing"));
                    playAudioTrack();
                    AppMethodBeat.m2505o(104510);
                }
            } catch (SoNotFindException e) {
                Logger.m71024e(TAG, e);
            }
        } else {
            Logger.m71021e(TAG, axiliary("不留痕迹的退出 时机：获取Information时 step = 3"));
            this.mStateRunner.transfer(Integer.valueOf(9));
            callExceptionCallback(91, 63);
            AppMethodBeat.m2505o(104510);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0076  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean decodeAllData() {
        AppMethodBeat.m2504i(104511);
        this.mAllPcmBufferList = new ArrayList();
        while (!this.mCorePlayer.mIsExit) {
            BufferInfo bufferInfo = new BufferInfo();
            bufferInfo.setByteBufferCapacity(this.mBuffSize);
            try {
                int pullDecodeData = this.mHandleDecodeDataCallback.pullDecodeData(this.mBuffSize, bufferInfo.byteBuffer);
                this.mHasDecode = true;
                if (pullDecodeData > 0) {
                    bufferInfo.bufferSize = pullDecodeData;
                    this.mAllPcmBufferList.add(bufferInfo);
                    if (!this.mHasDecodeSuccess) {
                        this.mHasDecodeSuccess = true;
                    }
                } else if (pullDecodeData == 0) {
                    bufferInfo.bufferSize = this.mBuffSize;
                    this.mAllPcmBufferList.add(bufferInfo);
                    Logger.m71025i(TAG, "static decode end");
                    if (!this.mAllPcmBufferList.isEmpty()) {
                        pullDecodeData = 0;
                        for (BufferInfo bufferInfo2 : this.mAllPcmBufferList) {
                            pullDecodeData = bufferInfo2.bufferSize + pullDecodeData;
                        }
                        Logger.m71025i(TAG, "static totalBufferSize = ".concat(String.valueOf(pullDecodeData)));
                        this.mDecodeBufferInfo.setByteBufferCapacity(pullDecodeData);
                        pullDecodeData = 0;
                        for (BufferInfo bufferInfo22 : this.mAllPcmBufferList) {
                            System.arraycopy(bufferInfo22.byteBuffer, 0, this.mDecodeBufferInfo.byteBuffer, pullDecodeData, bufferInfo22.bufferSize);
                            pullDecodeData += bufferInfo22.bufferSize;
                            BufferInfo bufferInfo3 = this.mDecodeBufferInfo;
                            bufferInfo3.bufferSize += bufferInfo22.bufferSize;
                            this.mAllBufferSize = bufferInfo22.bufferSize + this.mAllBufferSize;
                        }
                    }
                    AppMethodBeat.m2505o(104511);
                    return true;
                } else {
                    this.mHandleDecodeDataCallback.onPullDecodeDataEndOrFailed(pullDecodeData, 91);
                    AppMethodBeat.m2505o(104511);
                    return false;
                }
            } catch (SoNotFindException e) {
                Logger.m71024e(TAG, e);
                this.mStateRunner.transfer(Integer.valueOf(9));
                callExceptionCallback(91, 62);
                AppMethodBeat.m2505o(104511);
                return false;
            } catch (Throwable e2) {
                Logger.m71024e(TAG, e2);
                this.mStateRunner.transfer(Integer.valueOf(9));
                callExceptionCallback(91, 67);
                AppMethodBeat.m2505o(104511);
                return false;
            }
        }
        if (this.mAllPcmBufferList.isEmpty()) {
        }
        AppMethodBeat.m2505o(104511);
        return true;
    }

    private boolean createAudioTrack() {
        int i = 3;
        AppMethodBeat.m2504i(104512);
        Logger.m71020d(TAG, axiliary("createAudioTrack"));
        if (this.mInformation == null) {
            Logger.m71021e(TAG, axiliary("不留痕迹的退出 时机：获取Information时 step = 3"));
            this.mStateRunner.transfer(Integer.valueOf(9));
            callExceptionCallback(91, 63);
            AppMethodBeat.m2505o(104512);
            return false;
        }
        if (!this.mStateRunner.isEqual(Integer.valueOf(3))) {
            Logger.m71021e(TAG, axiliary("mState is not preparing"));
            callExceptionCallback(91, 54);
            AppMethodBeat.m2505o(104512);
            return false;
        } else if (this.mInformation.getSampleRate() <= 0) {
            Logger.m71021e(TAG, axiliary("mInformation.getSampleRate() failed"));
            callExceptionCallback(91, 64);
            AppMethodBeat.m2505o(104512);
            return false;
        } else {
            int i2 = 12;
            int channels = this.mInformation.getChannels();
            if (channels == 1) {
                i2 = 4;
            } else if (channels == 2) {
                i2 = 12;
            } else if (channels == 6) {
                i2 = 252;
            } else if (channels == 8) {
                i2 = 1020;
            }
            this.mPlaySample = this.mInformation.getSampleRate();
            this.mBitDept = this.mInformation.getBitDept();
            while (this.mPlaySample > MAX_PLAY_SAMPLE_RATE) {
                this.mPlaySample /= 2;
            }
            if (CAN_USE_FLOAT_IN_HI_RES && this.mBitDept >= 3) {
                this.mPlayBitDepth = this.mBitDept;
                this.isUseFloatInHiRes = true;
                if (this.mPlaySample != this.mInformation.getSampleRate()) {
                    Logger.m71025i(TAG, axiliary("will use float resampled pcm for Hi-Res, bitDept: " + this.mBitDept + ", origin sample rate: " + this.mInformation.getSampleRate() + ", target sample rate: " + this.mPlaySample));
                } else {
                    Logger.m71025i(TAG, axiliary("will use float pcm for Hi-Res, bitDept: " + this.mBitDept + ", sample rate: " + this.mPlaySample));
                }
            } else if (!CAN_USE_FLOAT_IN_HI_RES && this.mBitDept >= 3) {
                this.mPlayBitDepth = 2;
                if (this.mPlaySample != this.mInformation.getSampleRate()) {
                    Logger.m71025i(TAG, axiliary("will use byte pcm resampled and bitDept converted, origin bitDept: " + this.mBitDept + ", target bitDept: " + this.mPlayBitDepth + ", origin sample rate: " + this.mInformation.getSampleRate() + ", target sample rate: " + this.mPlaySample));
                } else {
                    Logger.m71025i(TAG, axiliary("will use byte pcm with bitDept converted, origin bitDept: " + this.mBitDept + ", target bitDept: " + this.mPlayBitDepth));
                }
            } else if (this.mPlaySample != this.mInformation.getSampleRate()) {
                this.mPlayBitDepth = this.mBitDept;
                Logger.m71025i(TAG, axiliary("will use byte pcm resampled, bitDept: " + this.mBitDept + ", origin sample rate: " + this.mInformation.getSampleRate() + ", target sample rate: " + this.mPlaySample));
            } else {
                this.mPlayBitDepth = 2;
                Logger.m71025i(TAG, axiliary("will use normal byte pcm, bitDept: " + this.mBitDept + ", sample rate: " + this.mPlaySample));
            }
            if (this.mBitDept != 1) {
                if (this.mBitDept == 2) {
                    i = 2;
                } else if (this.isUseFloatInHiRes) {
                    i = 4;
                } else {
                    i = 2;
                }
            }
            Logger.m71020d(TAG, axiliary(String.format("mPlaySample: %d, playChannel: %d", new Object[]{Long.valueOf(this.mPlaySample), Integer.valueOf(channels)})));
            try {
                this.mAudioTrack = new AudioTrack(3, (int) this.mPlaySample, i2, i, this.mAllBufferSize, 0);
                if (this.mAudioTrack.getState() == 2) {
                    Logger.m71020d(TAG, axiliary("new AudioTrack succeed"));
                }
            } catch (Throwable th) {
                Logger.m71024e(TAG, th);
            }
            if (this.mAudioTrack == null || this.mAudioTrack.getState() != 2) {
                this.mCreateAudioTrackFail = true;
                Logger.m71021e(TAG, axiliary("create audioTrack fail mCreateAudioTrackFail = true"));
                this.mAudioTrack = null;
                this.mStateRunner.transfer(Integer.valueOf(9));
                callExceptionCallback(91, 66);
                AppMethodBeat.m2505o(104512);
                return false;
            }
            Logger.m71020d(TAG, axiliary("create audioTrack success"));
            AppMethodBeat.m2505o(104512);
            return true;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x017a  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0062  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean writeAudioTrack() {
        AppMethodBeat.m2504i(104513);
        if (this.mDecodeBufferInfo.byteBuffer == null || this.mAudioTrack == null) {
            AppMethodBeat.m2505o(104513);
            return false;
        }
        handleHighBitDept(this.mDecodeBufferInfo, this.mNewBitDepthBufferInfo);
        handleHighSample(this.mNewBitDepthBufferInfo, this.mReSampleBufferInfo);
        if (this.isUseFloatInHiRes) {
            convertBytePcmToFloatPcm(this.mReSampleBufferInfo, this.mFloatBufferInfo);
            processAudioListeners(this.mFloatBufferInfo, this.mFloatBufferInfo);
        } else {
            processAudioListeners(this.mReSampleBufferInfo, this.mDTSBufferInfo);
        }
        this.mHasTerminal = false;
        for (int size = this.mTerminalAudioEffectList.size() - 1; size >= 0; size--) {
            IAudioListener iAudioListener = (IAudioListener) this.mTerminalAudioEffectList.get(size);
            if (iAudioListener.isEnabled()) {
                if (this.isUseFloatInHiRes) {
                    iAudioListener.onPcm(this.mFloatBufferInfo, this.mFloatBufferInfo);
                } else {
                    iAudioListener.onPcm(this.mDTSBufferInfo, this.mDTSBufferInfo);
                }
                this.mHasTerminal = true;
                if (this.mHasTerminal) {
                    int write;
                    if (this.isUseFloatInHiRes) {
                        write = this.mAudioTrack.write(this.mFloatBufferInfo.floatBuffer, 0, this.mFloatBufferInfo.bufferSize, 0);
                        if (write < 0) {
                            Logger.m71021e(TAG, axiliary("mAudioTrack write float failed: " + write + ", expect: " + this.mFloatBufferInfo.bufferSize));
                            this.mStateRunner.transfer(Integer.valueOf(9));
                            callExceptionCallback(91, 102);
                            AppMethodBeat.m2505o(104513);
                            return false;
                        } else if (write != this.mFloatBufferInfo.bufferSize) {
                            Logger.m71027w(TAG, axiliary("mAudioTrack write float not equal: " + write + ", expect: " + this.mFloatBufferInfo.bufferSize));
                        }
                    } else {
                        write = this.mAudioTrack.write(this.mDTSBufferInfo.byteBuffer, 0, this.mDTSBufferInfo.bufferSize);
                        if (write < 0) {
                            Logger.m71021e(TAG, axiliary("mAudioTrack write bytes failed: " + write + ", expect: " + this.mDTSBufferInfo.bufferSize));
                            this.mStateRunner.transfer(Integer.valueOf(9));
                            callExceptionCallback(91, 102);
                            AppMethodBeat.m2505o(104513);
                            return false;
                        } else if (write != this.mDTSBufferInfo.bufferSize) {
                            Logger.m71027w(TAG, axiliary("mAudioTrack write bytes not equal: " + write + ", expect: " + this.mDTSBufferInfo.bufferSize));
                        }
                    }
                    AppMethodBeat.m2505o(104513);
                    return true;
                }
                Logger.m71025i(TAG, "mTerminalAudioEffectList has blocked");
                AppMethodBeat.m2505o(104513);
                return false;
            }
        }
        if (this.mHasTerminal) {
        }
    }

    public void playAudioTrack() {
        AppMethodBeat.m2504i(104514);
        this.mAudioTrack.reloadStaticData();
        while (!this.mCorePlayer.mIsExit) {
            if (!isPaused()) {
                if (isIdle()) {
                    break;
                } else if (isError()) {
                    Logger.m71021e(TAG, "static play error");
                    AppMethodBeat.m2505o(104514);
                    return;
                } else if (isStopped()) {
                    if (this.mAudioTrack.getPlayState() != 1) {
                        this.mAudioTrack.stop();
                    }
                    postRunnable(new C364113(), 20);
                    AppMethodBeat.m2505o(104514);
                    return;
                } else if (isCompleted()) {
                    this.mCorePlayer.mIsExit = true;
                    AppMethodBeat.m2505o(104514);
                    return;
                } else if (isPlaying()) {
                    if (this.mAudioTrack.getPlayState() == 2) {
                        this.mAudioTrack.play();
                    } else if (this.mAudioTrack.getPlayState() == 1) {
                        if (!this.mIsfirstStarted) {
                            this.mIsfirstStarted = true;
                            this.mAudioTrack.play();
                            this.mCallback.playerStarted(this.mCorePlayer);
                        }
                    } else if ((((long) AudioUtil.getPlaybackHeadPositionSafely(this.mAudioTrack)) * ((long) this.mInformation.getChannels())) * ((long) getBytesPerSampleInPlay(this.mInformation.getBitDept())) >= ((long) this.mAllBufferSize)) {
                        this.mStateRunner.transfer(Integer.valueOf(7));
                        Logger.m71025i(TAG, "static play completed");
                        postRunnable(new C161264(), 20);
                    }
                }
            } else {
                if (this.mAudioTrack.getPlayState() != 2) {
                    this.mAudioTrack.pause();
                }
                postRunnable(new C161252(), 20);
                doWaitForPaused();
            }
        }
        AppMethodBeat.m2505o(104514);
    }
}
