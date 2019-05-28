package com.tencent.qqmusic.mediaplayer;

import android.os.Handler;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.qqmusic.mediaplayer.audiofx.IAudioListener;
import com.tencent.qqmusic.mediaplayer.codec.BaseDecoder;
import com.tencent.qqmusic.mediaplayer.perf.PerformanceTracer;
import com.tencent.qqmusic.mediaplayer.perf.PrefInfoCollector;
import com.tencent.qqmusic.mediaplayer.seektable.NativeSeekTable;
import com.tencent.qqmusic.mediaplayer.seektable.SeekTable;
import com.tencent.qqmusic.mediaplayer.upstream.IDataSource;
import com.tencent.qqmusic.mediaplayer.upstream.INativeDataSource;
import com.tencent.qqmusic.mediaplayer.util.CpuInfoUtil;
import com.tencent.qqmusic.mediaplayer.util.Logger;
import com.tencent.ttpic.thread.FaceGestureDetGLThread;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

class CorePlayer implements HandleDecodeDataCallback, Runnable {
    private static final AtomicInteger PLAYER_ID_CREATOR = new AtomicInteger(0);
    private static final String TAG = "CorePlayer";
    private final PlayerCallback mCallback;
    private IDataSource mDataSource;
    private final BaseDecoder mDecoder;
    private final Handler mEventHandler;
    protected AudioInformation mInformation;
    volatile boolean mIsExit = false;
    private INativeDataSource mNativeDataSource;
    private BaseDecodeDataComponent mPcmCompnent;
    private int mPlayerID = PLAYER_ID_CREATOR.addAndGet(1);
    private int mPlayerMode = 0;
    protected final PrefInfoCollector mPrefInfoCollector = PrefInfoCollector.getInstance();
    private final PlayerStateRunner mStateRunner = new PlayerStateRunner(Integer.valueOf(0));
    private String mThreadName = "Unnamed";
    private final PerformanceTracer performanceTracer = new PerformanceTracer();

    static {
        AppMethodBeat.i(104670);
        AppMethodBeat.o(104670);
    }

    CorePlayer(IDataSource iDataSource, INativeDataSource iNativeDataSource, PlayerCallback playerCallback, Looper looper, BaseDecoder baseDecoder) {
        AppMethodBeat.i(104638);
        IllegalArgumentException illegalArgumentException;
        if (iDataSource != null && iNativeDataSource != null) {
            illegalArgumentException = new IllegalArgumentException("you can't set IDataSource and INativeDataSource at the same time!");
            AppMethodBeat.o(104638);
            throw illegalArgumentException;
        } else if (iDataSource == null && iNativeDataSource == null) {
            illegalArgumentException = new IllegalArgumentException("at least on data source is required!");
            AppMethodBeat.o(104638);
            throw illegalArgumentException;
        } else {
            this.mEventHandler = new Handler(looper);
            this.mDecoder = baseDecoder;
            this.mDataSource = iDataSource;
            this.mNativeDataSource = iNativeDataSource;
            this.mCallback = playerCallback;
            this.mStateRunner.transfer(Integer.valueOf(1));
            AppMethodBeat.o(104638);
        }
    }

    /* Access modifiers changed, original: 0000 */
    public void setThreadName(String str) {
        this.mThreadName = str;
    }

    private void exitNotCallback() {
        AppMethodBeat.i(104639);
        Logger.i(TAG, axiliary("exitNotCallback"));
        this.mIsExit = true;
        AppMethodBeat.o(104639);
    }

    /* Access modifiers changed, original: 0000 */
    public void changePlayThreadPriorityImmediately() {
        AppMethodBeat.i(104640);
        Logger.d(TAG, axiliary("changePlayThreadPriorityImmediately"));
        if (this.mPcmCompnent == null) {
            AppMethodBeat.o(104640);
            return;
        }
        this.mPcmCompnent.changePlayThreadPriorityImmediately();
        AppMethodBeat.o(104640);
    }

    /* JADX WARNING: Removed duplicated region for block: B:63:0x01a5  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x0219  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        AppMethodBeat.i(104641);
        CpuInfoUtil.startProcessInfoOutput();
        Logger.i(TAG, axiliary("run, thread: " + Thread.currentThread().getName()));
        try {
            int init;
            this.mCallback.playThreadStart(this);
            if (this.mDataSource != null) {
                init = this.mDecoder.init(this.mDataSource);
                Logger.i(TAG, axiliary("mDecoder init from dataSource: ".concat(String.valueOf(init))));
            } else if (this.mNativeDataSource != null) {
                init = this.mDecoder.init(this.mNativeDataSource);
                Logger.i(TAG, axiliary("mDecoder init from native dataSource: ".concat(String.valueOf(init))));
            } else {
                init = -1;
                Logger.i(TAG, axiliary("[run] no dataSource!"));
            }
            if (init == -9) {
                Logger.e(TAG, axiliary("empty file, maybe external sdcard or other permission issue"));
                this.mStateRunner.transfer(Integer.valueOf(9));
                callExceptionCallback(91, 100);
            } else if (init != 0) {
                Logger.e(TAG, axiliary("不留痕迹的退出 时机：初始化时 step = 1"));
                this.mStateRunner.transfer(Integer.valueOf(9));
                callExceptionCallback(91, init == -2 ? 55 : 62);
                callExceptionCallback(91, 62);
                if (this.mPcmCompnent != null) {
                    Logger.i(TAG, axiliary("thread finally, mIsExit = " + this.mIsExit));
                } else {
                    Logger.e(TAG, axiliary("thread finally, ERROR!!!, no mPcmCompnent"));
                }
                CpuInfoUtil.stopProcessInfoOutput();
                try {
                    this.mDecoder.release();
                } catch (Throwable th) {
                    Logger.e(TAG, axiliary("release throw a exception = " + th.getMessage()), th);
                }
                if (this.mDataSource != null) {
                    try {
                        this.mDataSource.close();
                    } catch (IOException th2) {
                        Logger.e(TAG, axiliary("release dataSource throw a exception = " + th2.getMessage()), th2);
                    }
                }
                if (this.mPcmCompnent != null) {
                    this.mPcmCompnent.release();
                }
                this.mPlayerMode = 0;
                Logger.i(TAG, axiliary("exit, thread: " + Thread.currentThread().getName()));
                AppMethodBeat.o(104641);
                return;
            } else {
                this.mInformation = this.mDecoder.getAudioInformation();
            }
            PlayerConfigManager.getInstance().setCommonPlayerRef(this);
            if (!(this.mInformation == null || this.mIsExit || this.mPcmCompnent != null)) {
                if (this.mInformation.getDuration() < FaceGestureDetGLThread.BRIGHTNESS_DURATION || this.mPlayerMode == 1) {
                    if (this.mPlayerMode != 1) {
                        this.mPlayerMode = 1;
                    }
                    this.mPcmCompnent = new StaticDecodeDataComponent(this, this.mStateRunner, this.mInformation, this.mCallback, this, this.mEventHandler, this.mPlayerID);
                } else {
                    this.mPcmCompnent = new StreamDecodeDataComponent(this, this.mStateRunner, this.mInformation, this.mCallback, this, this.mEventHandler, this.mPlayerID);
                }
            }
            if (this.mPcmCompnent != null) {
                this.mPcmCompnent.handleDecodeData();
            }
            if (this.mPcmCompnent != null) {
                Logger.i(TAG, axiliary("thread finally, mIsExit = " + this.mIsExit));
            } else {
                Logger.e(TAG, axiliary("thread finally, ERROR!!!, no mPcmCompnent"));
            }
            CpuInfoUtil.stopProcessInfoOutput();
            try {
                this.mDecoder.release();
            } catch (Throwable th22) {
                Logger.e(TAG, axiliary("release throw a exception = " + th22.getMessage()), th22);
            }
            if (this.mDataSource != null) {
                try {
                    this.mDataSource.close();
                } catch (IOException th222) {
                    Logger.e(TAG, axiliary("release dataSource throw a exception = " + th222.getMessage()), th222);
                }
            }
            if (this.mPcmCompnent != null) {
                this.mPcmCompnent.release();
            }
            this.mPlayerMode = 0;
            Logger.i(TAG, axiliary("exit, thread: " + Thread.currentThread().getName()));
            AppMethodBeat.o(104641);
            return;
            if (this.mPcmCompnent != null) {
                this.mPcmCompnent.release();
            }
            this.mPlayerMode = 0;
            Logger.i(TAG, axiliary("exit, thread: " + Thread.currentThread().getName()));
            AppMethodBeat.o(104641);
            return;
            if (this.mPcmCompnent != null) {
                this.mPcmCompnent.release();
            }
            this.mPlayerMode = 0;
            Logger.i(TAG, axiliary("exit, thread: " + Thread.currentThread().getName()));
            AppMethodBeat.o(104641);
            if (this.mDataSource != null) {
                try {
                    this.mDataSource.close();
                } catch (IOException th2222) {
                    Logger.e(TAG, axiliary("release dataSource throw a exception = " + th2222.getMessage()), th2222);
                }
            }
            if (this.mPcmCompnent != null) {
            }
            this.mPlayerMode = 0;
            Logger.i(TAG, axiliary("exit, thread: " + Thread.currentThread().getName()));
            AppMethodBeat.o(104641);
            return;
            if (this.mDataSource != null) {
                try {
                    this.mDataSource.close();
                } catch (IOException e) {
                    Logger.e(TAG, axiliary("release dataSource throw a exception = " + e.getMessage()), e);
                }
            }
            if (this.mPcmCompnent != null) {
            }
            this.mPlayerMode = 0;
            Logger.i(TAG, axiliary("exit, thread: " + Thread.currentThread().getName()));
            AppMethodBeat.o(104641);
        } catch (Throwable th22222) {
            Logger.e(TAG, axiliary("release throw a exception = " + th22222.getMessage()), th22222);
        }
    }

    private void callExceptionCallback(int i, int i2) {
        AppMethodBeat.i(104642);
        callExceptionCallback(i, i2, 0);
        AppMethodBeat.o(104642);
    }

    private void callExceptionCallback(int i, int i2, int i3) {
        AppMethodBeat.i(104643);
        this.mCallback.playerException(this, i, i2, i3);
        AppMethodBeat.o(104643);
    }

    private String axiliary(String str) {
        AppMethodBeat.i(104644);
        String str2 = "ID: " + this.mPlayerID + ". " + str;
        AppMethodBeat.o(104644);
        return str2;
    }

    private void decodeEndOrFailed(int i, int i2) {
        AppMethodBeat.i(104645);
        Logger.d(TAG, axiliary("decodeEndOrFailed"));
        try {
            if (this.mPcmCompnent == null) {
                Logger.e(TAG, axiliary("mPcmCompnent null! Exiting"));
                AppMethodBeat.o(104645);
                return;
            }
            if (this.mInformation != null) {
                Logger.i(TAG, axiliary(String.format("current: %d, duration: %d, isExit: %b, decodeSucc: %b", new Object[]{Long.valueOf(this.mDecoder.getCurrentTime()), Long.valueOf(this.mInformation.getDuration()), Boolean.valueOf(this.mIsExit), Boolean.valueOf(this.mPcmCompnent.hasDecodeDataSuccess())})));
                i &= this.mDecoder.getErrorCodeMask();
            }
            if (this.mIsExit || !this.mPcmCompnent.hasDecodeDataSuccess()) {
                Logger.i(TAG, axiliary("不留痕迹的退出 时机：解码时退出  step = 4"));
                exitNotCallback();
                this.mStateRunner.transfer(Integer.valueOf(9));
                callExceptionCallback(i2, 67, i);
                AppMethodBeat.o(104645);
            } else if (getCurPositionByDecoder() < getDuration() - 5000) {
                Logger.e(TAG, axiliary("Decode failed! Exiting."));
                callExceptionCallback(i2, 67, i);
                this.mStateRunner.transfer(Integer.valueOf(6));
                AppMethodBeat.o(104645);
            } else {
                if (i2 == 92) {
                    Logger.i(TAG, axiliary("Decode ended! Exiting."));
                    this.mStateRunner.transfer(Integer.valueOf(7));
                }
                AppMethodBeat.o(104645);
            }
        } catch (Throwable th) {
            Logger.e(TAG, th);
            AppMethodBeat.o(104645);
        }
    }

    /* Access modifiers changed, original: 0000 */
    public long getDuration() {
        AppMethodBeat.i(104646);
        if (this.mInformation != null) {
            try {
                long duration = this.mInformation.getDuration();
                AppMethodBeat.o(104646);
                return duration;
            } catch (Throwable th) {
                Logger.e(TAG, th);
            }
        }
        AppMethodBeat.o(104646);
        return 0;
    }

    /* Access modifiers changed, original: 0000 */
    public int getPlayerState() {
        AppMethodBeat.i(104647);
        if (this.mPcmCompnent == null) {
            AppMethodBeat.o(104647);
            return 0;
        }
        int playerState = this.mPcmCompnent.getPlayerState();
        AppMethodBeat.o(104647);
        return playerState;
    }

    /* Access modifiers changed, original: 0000 */
    public long getCurPosition() {
        AppMethodBeat.i(104648);
        if (this.mPcmCompnent == null) {
            AppMethodBeat.o(104648);
            return 0;
        }
        long curPosition = this.mPcmCompnent.getCurPosition();
        AppMethodBeat.o(104648);
        return curPosition;
    }

    /* Access modifiers changed, original: declared_synchronized */
    public synchronized boolean hasDecodeData() {
        boolean z;
        AppMethodBeat.i(104649);
        if (this.mPcmCompnent == null) {
            z = false;
            AppMethodBeat.o(104649);
        } else {
            z = this.mPcmCompnent.hasDecodeData();
            AppMethodBeat.o(104649);
        }
        return z;
    }

    /* Access modifiers changed, original: declared_synchronized */
    public synchronized boolean hasDecodeDataSuccess() {
        boolean z;
        AppMethodBeat.i(104650);
        if (this.mPcmCompnent == null) {
            z = false;
            AppMethodBeat.o(104650);
        } else {
            z = this.mPcmCompnent.hasDecodeDataSuccess();
            AppMethodBeat.o(104650);
        }
        return z;
    }

    /* Access modifiers changed, original: 0000 */
    public boolean isInit() {
        AppMethodBeat.i(104651);
        if (this.mPcmCompnent == null) {
            AppMethodBeat.o(104651);
            return false;
        }
        boolean isInit = this.mPcmCompnent.isInit();
        AppMethodBeat.o(104651);
        return isInit;
    }

    /* Access modifiers changed, original: 0000 */
    public AudioInformation getCurrentAudioInformation() {
        return this.mInformation;
    }

    /* Access modifiers changed, original: 0000 */
    public int getSessionId() {
        AppMethodBeat.i(104652);
        if (this.mPcmCompnent != null) {
            int sessionId = this.mPcmCompnent.getSessionId();
            AppMethodBeat.o(104652);
            return sessionId;
        }
        AppMethodBeat.o(104652);
        return 0;
    }

    /* Access modifiers changed, original: 0000 */
    public void addAudioListener(IAudioListener iAudioListener) {
        AppMethodBeat.i(104653);
        if (this.mPcmCompnent != null) {
            this.mPcmCompnent.addAudioListener(iAudioListener);
        }
        AppMethodBeat.o(104653);
    }

    /* Access modifiers changed, original: 0000 */
    public void removeAudioListener(IAudioListener iAudioListener) {
        AppMethodBeat.i(104654);
        if (this.mPcmCompnent != null) {
            this.mPcmCompnent.removeAudioListener(iAudioListener);
        }
        AppMethodBeat.o(104654);
    }

    public void prepare() {
        AppMethodBeat.i(104655);
        Logger.i(TAG, axiliary("prepare"));
        this.mStateRunner.transfer(Integer.valueOf(3));
        new Thread(this, "decoder-" + this.mThreadName).start();
        AppMethodBeat.o(104655);
    }

    /* Access modifiers changed, original: 0000 */
    public void play() {
        AppMethodBeat.i(104656);
        Logger.i(TAG, axiliary("play"));
        if (this.mPcmCompnent == null) {
            AppMethodBeat.o(104656);
            return;
        }
        this.mPcmCompnent.play();
        AppMethodBeat.o(104656);
    }

    /* Access modifiers changed, original: 0000 */
    public void pause() {
        AppMethodBeat.i(104657);
        Logger.i(TAG, axiliary("pause"));
        if (this.mPcmCompnent == null) {
            AppMethodBeat.o(104657);
            return;
        }
        this.mPcmCompnent.pause();
        AppMethodBeat.o(104657);
    }

    /* Access modifiers changed, original: 0000 */
    public void stop() {
        AppMethodBeat.i(104658);
        Logger.i(TAG, axiliary("stop"));
        if (this.mPcmCompnent == null) {
            AppMethodBeat.o(104658);
            return;
        }
        this.mPcmCompnent.stop();
        AppMethodBeat.o(104658);
    }

    public void release() {
        AppMethodBeat.i(104659);
        Logger.i(TAG, axiliary("release"));
        this.mEventHandler.removeCallbacksAndMessages(null);
        exitNotCallback();
        if (this.mPcmCompnent != null) {
            this.mPcmCompnent.releaseNotify();
        }
        this.mStateRunner.transfer(Integer.valueOf(8));
        AppMethodBeat.o(104659);
    }

    /* Access modifiers changed, original: 0000 */
    public void setVolume(float f, float f2) {
        AppMethodBeat.i(104660);
        if (this.mPcmCompnent != null) {
            this.mPcmCompnent.setVolume(f, f2);
        }
        AppMethodBeat.o(104660);
    }

    /* Access modifiers changed, original: 0000 */
    public void flush() {
        AppMethodBeat.i(104661);
        if (this.mPcmCompnent != null) {
            this.mPcmCompnent.flush();
        }
        AppMethodBeat.o(104661);
    }

    /* Access modifiers changed, original: 0000 */
    public void setAudioStreamType(int i) {
        AppMethodBeat.i(104662);
        if (this.mPcmCompnent != null) {
            this.mPcmCompnent.setAudioStreamType(i);
        }
        AppMethodBeat.o(104662);
    }

    /* Access modifiers changed, original: 0000 */
    public void setPlayerMode(int i) {
        this.mPlayerMode = i;
    }

    /* Access modifiers changed, original: 0000 */
    public int getPlayerMode() {
        return this.mPlayerMode;
    }

    public void seek(int i) {
        AppMethodBeat.i(104663);
        if (this.mPcmCompnent != null) {
            this.mPcmCompnent.seek(i);
        }
        AppMethodBeat.o(104663);
    }

    /* Access modifiers changed, original: 0000 */
    public SeekTable createSeekTable() {
        AppMethodBeat.i(104664);
        if (this.mDecoder == null) {
            IllegalStateException illegalStateException = new IllegalStateException("please setDataSource before creating seek table!");
            AppMethodBeat.o(104664);
            throw illegalStateException;
        }
        NativeSeekTable nativeSeekTable = new NativeSeekTable(this.mDecoder);
        AppMethodBeat.o(104664);
        return nativeSeekTable;
    }

    public int seekTo(int i) {
        AppMethodBeat.i(104665);
        int seekTo = this.mDecoder.seekTo(i);
        AppMethodBeat.o(104665);
        return seekTo;
    }

    public long getCurPositionByDecoder() {
        AppMethodBeat.i(104666);
        try {
            long currentTime = this.mDecoder.getCurrentTime();
            AppMethodBeat.o(104666);
            return currentTime;
        } catch (SoNotFindException e) {
            Logger.e(TAG, e);
            AppMethodBeat.o(104666);
            return 0;
        } catch (Throwable e2) {
            Logger.e(TAG, "Strange Exception!", e2);
            AppMethodBeat.o(104666);
            return 0;
        }
    }

    public long getMinPcmBufferSize() {
        AppMethodBeat.i(104667);
        long minBufferSize = this.mDecoder.getMinBufferSize();
        AppMethodBeat.o(104667);
        return minBufferSize;
    }

    public int pullDecodeData(int i, byte[] bArr) {
        AppMethodBeat.i(104668);
        int decodeData = this.mDecoder.decodeData(i, bArr);
        AppMethodBeat.o(104668);
        return decodeData;
    }

    public void onPullDecodeDataEndOrFailed(int i, int i2) {
        AppMethodBeat.i(104669);
        decodeEndOrFailed(i, i2);
        AppMethodBeat.o(104669);
    }
}
