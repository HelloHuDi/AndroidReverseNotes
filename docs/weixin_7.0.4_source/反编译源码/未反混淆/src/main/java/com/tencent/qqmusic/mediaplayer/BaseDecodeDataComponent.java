package com.tencent.qqmusic.mediaplayer;

import android.media.AudioTrack;
import android.os.Build.VERSION;
import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.q.l;
import com.tencent.qqmusic.mediaplayer.audiofx.IAudioListener;
import com.tencent.qqmusic.mediaplayer.perf.PerformanceTracer;
import com.tencent.qqmusic.mediaplayer.util.Logger;
import com.tencent.qqmusic.mediaplayer.util.PcmConvertionUtil;
import com.tencent.qqmusic.mediaplayer.util.ReferenceTimer;
import com.tencent.qqmusic.mediaplayer.util.WaitNotify;
import com.tencent.qqmusic.mediaplayer.util.WaitNotify.WaitListener;
import com.tencent.ttpic.thread.FaceGestureDetGLThread;
import java.util.ArrayList;
import java.util.List;

abstract class BaseDecodeDataComponent {
    protected static final int CALL_PREPARED_DELAY_TIME = 20;
    protected static final boolean CAN_USE_FLOAT_IN_HI_RES = (VERSION.SDK_INT >= 21);
    protected static final long MAX_PLAY_SAMPLE_RATE = (VERSION.SDK_INT >= 23 ? 192000 : 48000);
    private static final String TAG = "BaseDecodeDataComponent";
    protected final List<IAudioListener> audioEffects = new ArrayList(3);
    protected boolean isUseFloatInHiRes = false;
    protected int mAudioStreamType = getAudioStreamType();
    protected AudioTrack mAudioTrack;
    protected int mBuffSize;
    protected PlayerCallback mCallback;
    protected CorePlayer mCorePlayer;
    protected boolean mCreateAudioTrackFail = false;
    protected long mCurPosition = MAX_PLAY_SAMPLE_RATE;
    protected final BufferInfo mDTSBufferInfo = new BufferInfo();
    protected final BufferInfo mDecodeBufferInfo = new BufferInfo();
    protected Handler mEventHandler;
    protected final FloatBufferInfo mFloatBufferInfo = new FloatBufferInfo();
    protected final HandleDecodeDataCallback mHandleDecodeDataCallback;
    protected boolean mHasDecode = false;
    protected boolean mHasDecodeSuccess = false;
    protected boolean mHasInit = false;
    protected AudioInformation mInformation;
    protected volatile boolean mNeedChangePlayThreadPriority = false;
    protected final BufferInfo mNewBitDepthBufferInfo = new BufferInfo();
    protected int mPlayBitDepth = 2;
    protected long mPlaySample;
    private int mPlayerID;
    protected final BufferInfo mReSampleBufferInfo = new BufferInfo();
    protected final WaitNotify mSignalControl = new WaitNotify();
    protected PlayerStateRunner mStateRunner;
    protected final List<IAudioListener> mTerminalAudioEffectList = new ArrayList();
    protected ReferenceTimer mTimer = new ReferenceTimer();
    protected PerformanceTracer performanceTracer = null;

    interface HandleDecodeDataCallback {
        long getCurPositionByDecoder();

        long getMinPcmBufferSize();

        void onPullDecodeDataEndOrFailed(int i, int i2);

        int pullDecodeData(int i, byte[] bArr);

        int seekTo(int i);
    }

    public abstract int getAudioStreamType();

    public abstract long getCurPosition();

    public abstract void handleDecodeData();

    BaseDecodeDataComponent(CorePlayer corePlayer, PlayerStateRunner playerStateRunner, AudioInformation audioInformation, PlayerCallback playerCallback, HandleDecodeDataCallback handleDecodeDataCallback, Handler handler, int i) {
        this.mCorePlayer = corePlayer;
        this.mStateRunner = playerStateRunner;
        this.mInformation = audioInformation;
        this.mCallback = playerCallback;
        this.mHandleDecodeDataCallback = handleDecodeDataCallback;
        this.mEventHandler = handler;
        this.mPlayerID = i;
    }

    /* Access modifiers changed, original: protected */
    public void postRunnable(Runnable runnable, int i) {
        this.mEventHandler.postDelayed(runnable, (long) i);
    }

    /* Access modifiers changed, original: protected */
    public String axiliary(String str) {
        return "ID: " + this.mPlayerID + ". " + str;
    }

    /* Access modifiers changed, original: 0000 */
    public void changePlayThreadPriorityImmediately() {
        Logger.d(TAG, axiliary("changePlayThreadPriorityImmediately"));
        this.mNeedChangePlayThreadPriority = true;
    }

    /* Access modifiers changed, original: protected */
    public void callExceptionCallback(int i, int i2) {
        callExceptionCallback(i, i2, 0);
    }

    /* Access modifiers changed, original: protected */
    public void callExceptionCallback(int i, int i2, int i3) {
        this.mCallback.playerException(this.mCorePlayer, i, i2, i3);
    }

    /* Access modifiers changed, original: 0000 */
    public int getPlayerState() {
        return this.mStateRunner.get().intValue();
    }

    /* Access modifiers changed, original: protected */
    public void refreshTimeAndNotify(int i) {
        this.mTimer.refreshTimeInMs((long) i);
        if (this.mSignalControl.isWaiting()) {
            Logger.d(TAG, axiliary("lock is Waiting, event: seek, doNotify"));
            this.mSignalControl.doNotify();
        }
    }

    /* Access modifiers changed, original: 0000 */
    public void seek(int i) {
    }

    /* Access modifiers changed, original: 0000 */
    public void play() {
        Logger.i(TAG, axiliary("play"));
        this.mTimer.refreshTimeInMs(this.mCurPosition);
        this.mStateRunner.transfer(Integer.valueOf(4));
        if (this.mSignalControl.isWaiting()) {
            Logger.d(TAG, axiliary("lock is Waiting, event: play, doNotify"));
            this.mSignalControl.doNotify();
        }
    }

    /* Access modifiers changed, original: 0000 */
    public void pause() {
        Logger.i(TAG, axiliary("pause"));
        this.mStateRunner.transfer(Integer.valueOf(5), Integer.valueOf(4), Integer.valueOf(2));
    }

    /* Access modifiers changed, original: 0000 */
    public void stop() {
        Logger.i(TAG, axiliary("stop"));
        if (this.mStateRunner.transfer(Integer.valueOf(6), Integer.valueOf(4), Integer.valueOf(5), Integer.valueOf(2)) && this.mSignalControl.isWaiting()) {
            Logger.d(TAG, axiliary("lock is Waiting, event: stop, doNotify"));
            this.mSignalControl.doNotify();
        }
    }

    /* Access modifiers changed, original: protected|declared_synchronized */
    public synchronized boolean isError() {
        return this.mStateRunner.isEqual(Integer.valueOf(9));
    }

    /* Access modifiers changed, original: protected|declared_synchronized */
    public synchronized boolean isIdle() {
        return this.mStateRunner.isEqual(Integer.valueOf(0));
    }

    /* Access modifiers changed, original: protected|declared_synchronized */
    public synchronized boolean isPlaying() {
        return this.mStateRunner.isEqual(Integer.valueOf(4));
    }

    /* Access modifiers changed, original: protected|declared_synchronized */
    public synchronized boolean isPaused() {
        return this.mStateRunner.isEqual(Integer.valueOf(5));
    }

    /* Access modifiers changed, original: protected|declared_synchronized */
    public synchronized boolean isStopped() {
        return this.mStateRunner.isEqual(Integer.valueOf(6));
    }

    /* Access modifiers changed, original: protected|declared_synchronized */
    public synchronized boolean isCompleted() {
        return this.mStateRunner.isEqual(Integer.valueOf(7));
    }

    /* Access modifiers changed, original: 0000 */
    public void release() {
        if (this.mAudioTrack != null) {
            try {
                this.mAudioTrack.stop();
            } catch (Throwable th) {
                Logger.e(TAG, th);
            }
            try {
                this.mAudioTrack.flush();
            } catch (Throwable th2) {
                Logger.e(TAG, th2);
            }
            try {
                this.mAudioTrack.release();
            } catch (Throwable th22) {
                Logger.e(TAG, th22);
            }
            try {
                destroyAudioListeners();
            } catch (Throwable th222) {
                Logger.i(TAG, "[run] failed to destroyAudioListeners!", th222);
            }
            this.mAudioTrack = null;
            Logger.d(TAG, axiliary("finally release audioTrack"));
        }
        if (!this.mCorePlayer.mIsExit) {
            if (this.mStateRunner.isEqual(Integer.valueOf(7))) {
                this.mCallback.playerEnded(this.mCorePlayer);
            } else {
                this.mCallback.playerStopped(this.mCorePlayer);
            }
        }
    }

    /* Access modifiers changed, original: 0000 */
    public void releaseNotify() {
        if (this.mSignalControl.isWaiting()) {
            Logger.d(TAG, axiliary("lock is Waiting, event: release, doNotify"));
            this.mSignalControl.doNotify();
        }
    }

    /* Access modifiers changed, original: 0000 */
    public void setAudioStreamType(int i) {
        if (i != this.mAudioStreamType) {
            this.mAudioStreamType = i;
        }
    }

    /* Access modifiers changed, original: declared_synchronized */
    public synchronized boolean hasDecodeData() {
        return this.mHasDecode;
    }

    /* Access modifiers changed, original: 0000 */
    public boolean isCreateAudioTrackFail() {
        return this.mCreateAudioTrackFail;
    }

    /* Access modifiers changed, original: declared_synchronized */
    public synchronized boolean hasDecodeDataSuccess() {
        return this.mHasDecodeSuccess;
    }

    /* Access modifiers changed, original: 0000 */
    public boolean isInit() {
        return this.mHasInit;
    }

    /* Access modifiers changed, original: 0000 */
    public int getSessionId() {
        if (this.mAudioTrack == null || VERSION.SDK_INT < 9) {
            return 0;
        }
        return this.mAudioTrack.getAudioSessionId();
    }

    /* Access modifiers changed, original: 0000 */
    public void setVolume(float f, float f2) {
        if (this.mAudioTrack != null) {
            try {
                this.mAudioTrack.setStereoVolume(f, f2);
            } catch (IllegalStateException e) {
                Logger.e(TAG, l.NAME, e);
            }
        }
    }

    /* Access modifiers changed, original: 0000 */
    public void flush() {
    }

    /* Access modifiers changed, original: protected */
    public void handleHighBitDept(BufferInfo bufferInfo, BufferInfo bufferInfo2) {
        if (this.isUseFloatInHiRes) {
            bufferInfo.copy(bufferInfo2);
            return;
        }
        try {
            PcmConvertionUtil.convertBitDepthTo16(bufferInfo, bufferInfo2, this.mInformation.getBitDept());
        } catch (Throwable th) {
            Logger.e(TAG, th);
        }
    }

    /* Access modifiers changed, original: protected */
    public void handleHighSample(BufferInfo bufferInfo, BufferInfo bufferInfo2) {
        try {
            PcmConvertionUtil.reSample(bufferInfo, bufferInfo2, this.mInformation.getSampleRate(), this.mPlaySample, this.mPlayBitDepth);
        } catch (Throwable th) {
            Logger.e(TAG, th);
        }
    }

    /* Access modifiers changed, original: protected */
    public void convertBytePcmToFloatPcm(BufferInfo bufferInfo, FloatBufferInfo floatBufferInfo) {
        try {
            PcmConvertionUtil.convertByteBufferToFloatBuffer(bufferInfo, floatBufferInfo, this.mInformation.getBitDept());
        } catch (Throwable th) {
            Logger.e(TAG, th);
        }
    }

    /* Access modifiers changed, original: 0000 */
    public void processAudioListeners(BufferInfo bufferInfo, BufferInfo bufferInfo2) {
        synchronized (this.audioEffects) {
            if (this.audioEffects.size() == 0) {
                bufferInfo.copy(bufferInfo2);
            } else {
                BufferInfo bufferInfo3 = bufferInfo2;
                BufferInfo bufferInfo4 = bufferInfo;
                for (IAudioListener iAudioListener : this.audioEffects) {
                    if (!iAudioListener.isEnabled()) {
                        bufferInfo4.copy(bufferInfo3);
                    } else if (processAudioListener(iAudioListener, bufferInfo4, bufferInfo3)) {
                        BufferInfo bufferInfo5 = bufferInfo4;
                        bufferInfo4 = bufferInfo3;
                        bufferInfo3 = bufferInfo5;
                    } else {
                        bufferInfo4.copy(bufferInfo3);
                    }
                }
                if (bufferInfo4 == bufferInfo) {
                    bufferInfo.copy(bufferInfo2);
                }
            }
        }
    }

    /* Access modifiers changed, original: 0000 */
    public void processAudioListeners(FloatBufferInfo floatBufferInfo, FloatBufferInfo floatBufferInfo2) {
        synchronized (this.audioEffects) {
            if (this.audioEffects.size() == 0) {
                floatBufferInfo.copy(floatBufferInfo2);
            } else {
                FloatBufferInfo floatBufferInfo3 = floatBufferInfo2;
                FloatBufferInfo floatBufferInfo4 = floatBufferInfo;
                for (IAudioListener iAudioListener : this.audioEffects) {
                    if (!iAudioListener.isEnabled()) {
                        floatBufferInfo4.copy(floatBufferInfo3);
                    } else if (processAudioListener(iAudioListener, floatBufferInfo4, floatBufferInfo3)) {
                        FloatBufferInfo floatBufferInfo5 = floatBufferInfo4;
                        floatBufferInfo4 = floatBufferInfo3;
                        floatBufferInfo3 = floatBufferInfo5;
                    } else {
                        floatBufferInfo4.copy(floatBufferInfo3);
                    }
                }
                if (floatBufferInfo4 == floatBufferInfo) {
                    floatBufferInfo.copy(floatBufferInfo2);
                }
            }
        }
    }

    /* Access modifiers changed, original: 0000 */
    public void addAudioListener(IAudioListener iAudioListener) {
        if (iAudioListener.isTerminal()) {
            synchronized (this.mTerminalAudioEffectList) {
                if (!this.mTerminalAudioEffectList.contains(iAudioListener)) {
                    this.mTerminalAudioEffectList.add(iAudioListener);
                    Logger.i(TAG, "[addAudioListener] terminal audio added: ".concat(String.valueOf(iAudioListener)));
                }
            }
        } else {
            synchronized (this.audioEffects) {
                if (!this.audioEffects.contains(iAudioListener)) {
                    this.audioEffects.add(iAudioListener);
                    Logger.i(TAG, "[addAudioListener] audio added: ".concat(String.valueOf(iAudioListener)));
                }
            }
        }
        if (this.mInformation == null || this.mInformation.getPlaySample() <= MAX_PLAY_SAMPLE_RATE || this.mInformation.getChannels() <= 0) {
            Logger.i(TAG, "[addAudioListener] audio information not ready. init will be delayed.");
            return;
        }
        long onPlayerReady;
        try {
            onPlayerReady = iAudioListener.onPlayerReady(this.mInformation.getPlaySample(), this.mPlayBitDepth, this.mInformation.getChannels());
        } catch (Throwable th) {
            Logger.e(TAG, "[addAudioListener] failed to init audio: ".concat(String.valueOf(iAudioListener)), th);
            onPlayerReady = MAX_PLAY_SAMPLE_RATE;
        }
        if (onPlayerReady != MAX_PLAY_SAMPLE_RATE) {
            Logger.e(TAG, "[addAudioListener] failed to init audio %s, ret: %d", iAudioListener, Long.valueOf(onPlayerReady));
        }
    }

    /* Access modifiers changed, original: protected */
    public void initAudioListeners(long j, int i, int i2) {
        synchronized (this.audioEffects) {
            for (IAudioListener onPlayerReady : this.audioEffects) {
                onPlayerReady.onPlayerReady(j, i, i2);
            }
        }
        synchronized (this.mTerminalAudioEffectList) {
            for (IAudioListener onPlayerReady2 : this.mTerminalAudioEffectList) {
                onPlayerReady2.onPlayerReady(j, i, i2);
            }
        }
    }

    /* Access modifiers changed, original: protected */
    public void destroyAudioListeners() {
        synchronized (this.audioEffects) {
            for (IAudioListener onPlayerStopped : this.audioEffects) {
                onPlayerStopped.onPlayerStopped();
            }
        }
        synchronized (this.mTerminalAudioEffectList) {
            for (IAudioListener onPlayerStopped2 : this.mTerminalAudioEffectList) {
                onPlayerStopped2.onPlayerStopped();
            }
        }
    }

    /* Access modifiers changed, original: 0000 */
    public void removeAudioListener(IAudioListener iAudioListener) {
        synchronized (this.audioEffects) {
            if (this.audioEffects.remove(iAudioListener)) {
                Logger.i(TAG, "[removeAudioListener] audio removed: ".concat(String.valueOf(iAudioListener)));
            }
        }
        synchronized (this.mTerminalAudioEffectList) {
            if (this.mTerminalAudioEffectList.remove(iAudioListener)) {
                Logger.i(TAG, "[removeAudioListener] terminal audio removed: ".concat(String.valueOf(iAudioListener)));
            }
        }
    }

    /* Access modifiers changed, original: protected */
    public void notifySeekCompleteForAudioListeners(long j) {
        synchronized (this.audioEffects) {
            for (IAudioListener onPlayerSeekComplete : this.audioEffects) {
                onPlayerSeekComplete.onPlayerSeekComplete(j);
            }
        }
        synchronized (this.mTerminalAudioEffectList) {
            for (IAudioListener onPlayerSeekComplete2 : this.mTerminalAudioEffectList) {
                onPlayerSeekComplete2.onPlayerSeekComplete(j);
            }
        }
    }

    private static boolean processAudioListener(IAudioListener iAudioListener, BufferInfo bufferInfo, BufferInfo bufferInfo2) {
        try {
            bufferInfo2.setByteBufferCapacity(bufferInfo.bufferSize);
            return iAudioListener.onPcm(bufferInfo, bufferInfo2);
        } catch (Throwable th) {
            Logger.e(TAG, "[processAudioListener] failed. audio: ".concat(String.valueOf(iAudioListener)), th);
            return false;
        }
    }

    private static boolean processAudioListener(IAudioListener iAudioListener, FloatBufferInfo floatBufferInfo, FloatBufferInfo floatBufferInfo2) {
        try {
            floatBufferInfo2.setFloatBufferCapacity(floatBufferInfo.bufferSize);
            return iAudioListener.onPcm(floatBufferInfo, floatBufferInfo2);
        } catch (Throwable th) {
            Logger.e(TAG, "[processAudioListener] failed. audio: ".concat(String.valueOf(iAudioListener)), th);
            return false;
        }
    }

    /* Access modifiers changed, original: protected */
    public int getBytesPerSampleInPlay(int i) {
        if (i <= 2 || CAN_USE_FLOAT_IN_HI_RES) {
            return i;
        }
        return 2;
    }

    /* Access modifiers changed, original: 0000 */
    public void setPerformanceTracer(PerformanceTracer performanceTracer) {
        this.performanceTracer = performanceTracer;
    }

    protected static int getAudioTrackPosition(long j, AudioTrack audioTrack) {
        long j2 = MAX_PLAY_SAMPLE_RATE;
        if (audioTrack != null) {
            try {
                j2 = Math.round((((double) (((long) audioTrack.getPlaybackHeadPosition()) + j)) / ((double) audioTrack.getSampleRate())) * 1000.0d);
            } catch (Exception e) {
                Logger.e(TAG, "getAudioTrackPosition", e);
            }
        }
        return (int) j2;
    }

    /* Access modifiers changed, original: protected */
    public void doWaitForPaused() {
        this.mSignalControl.doWait(FaceGestureDetGLThread.BRIGHTNESS_DURATION, 5, new WaitListener() {
            public boolean keepWaiting() {
                AppMethodBeat.i(104671);
                boolean isPaused = BaseDecodeDataComponent.this.isPaused();
                AppMethodBeat.o(104671);
                return isPaused;
            }
        });
    }
}
