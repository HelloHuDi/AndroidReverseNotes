package com.tencent.liteav.audio;

import android.media.AudioTrack;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.C17778b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;

public class TXCUGCBGMPlayer implements Runnable {
    private static final int PLAY_ERR_AUDIO_TRACK = -3;
    private static final int PLAY_ERR_AUDIO_TRACK_PLAY = -4;
    private static final int PLAY_ERR_FILE_NOTFOUND = -2;
    private static final int PLAY_ERR_OPEN = -1;
    private static final int PLAY_SUCCESS = 0;
    private static final String TAG = "AudioCenter:TXCUGCBGMPlayer";
    private static TXCUGCBGMPlayer instance;
    private long mEndTimeMS = 0;
    private String mFilePath = null;
    private boolean mIsPause = false;
    private boolean mIsRunning = false;
    private long mSeekBytes = 0;
    private float mSpeedRate = 1.0f;
    private long mStartTimeMS = 0;
    private Thread mThread = null;
    private float mVolume = 1.0f;
    private WeakReference<C45097e> mWeakListener = null;

    private native int nativeGetBitsPerChannel();

    private native int nativeGetChannels();

    private native long nativeGetCurDurationMS();

    private native long nativeGetCurPosition();

    private native long nativeGetCurPtsMS();

    private static native long nativeGetDurationMS(String str);

    private native int nativeGetSampleRate();

    private native void nativePause();

    private native void nativePlayFromTime(long j, long j2);

    private native int nativeRead(byte[] bArr, int i);

    private native void nativeResume();

    private native void nativeSeekBytes(long j);

    private native void nativeSetSpeedRate(float f);

    private native void nativeSetVolume(float f);

    private native boolean nativeStartPlay(String str);

    private native void nativeStopPlay();

    static {
        AppMethodBeat.m2504i(66725);
        C17778b.m27756e();
        AppMethodBeat.m2505o(66725);
    }

    public static TXCUGCBGMPlayer getInstance() {
        AppMethodBeat.m2504i(66709);
        if (instance == null) {
            synchronized (TXCUGCBGMPlayer.class) {
                try {
                    if (instance == null) {
                        instance = new TXCUGCBGMPlayer();
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.m2505o(66709);
                    }
                }
            }
        }
        TXCUGCBGMPlayer tXCUGCBGMPlayer = instance;
        AppMethodBeat.m2505o(66709);
        return tXCUGCBGMPlayer;
    }

    private TXCUGCBGMPlayer() {
    }

    public synchronized void setOnPlayListener(C45097e c45097e) {
        AppMethodBeat.m2504i(66710);
        if (c45097e == null) {
            this.mWeakListener = null;
        }
        this.mWeakListener = new WeakReference(c45097e);
        AppMethodBeat.m2505o(66710);
    }

    public void startPlay(String str) {
        AppMethodBeat.m2504i(66711);
        TXCLog.m15677i(TAG, "startPlay:".concat(String.valueOf(str)));
        if (str == null || str.isEmpty()) {
            AppMethodBeat.m2505o(66711);
            return;
        }
        if (this.mIsRunning) {
            TXCLog.m15679w(TAG, "BGM正在播放中，将重新启动");
            stopPlay();
        }
        this.mIsPause = false;
        this.mSeekBytes = 0;
        this.mFilePath = str;
        this.mIsRunning = true;
        this.mThread = new Thread(this, "UGCBGMPlayer");
        this.mThread.start();
        AppMethodBeat.m2505o(66711);
    }

    public void stopPlay() {
        AppMethodBeat.m2504i(66712);
        TXCLog.m15677i(TAG, "stopPlay");
        this.mIsRunning = false;
        long currentTimeMillis = System.currentTimeMillis();
        if (!(this.mThread == null || !this.mThread.isAlive() || Thread.currentThread().getId() == this.mThread.getId())) {
            try {
                this.mThread.join();
            } catch (InterruptedException e) {
            }
        }
        this.mThread = null;
        synchronized (this) {
            try {
                nativeStopPlay();
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(66712);
            }
        }
        TXCLog.m15677i(TAG, "stopBGMPlay cost(MS): " + (System.currentTimeMillis() - currentTimeMillis));
    }

    public void pause() {
        AppMethodBeat.m2504i(66713);
        TXCLog.m15677i(TAG, "pause");
        this.mIsPause = true;
        nativePause();
        AppMethodBeat.m2505o(66713);
    }

    public void resume() {
        AppMethodBeat.m2504i(66714);
        TXCLog.m15677i(TAG, "resume");
        this.mIsPause = false;
        nativeResume();
        AppMethodBeat.m2505o(66714);
    }

    public void setVolume(float f) {
        AppMethodBeat.m2504i(66715);
        this.mVolume = f;
        nativeSetVolume(f);
        AppMethodBeat.m2505o(66715);
    }

    public void setSpeedRate(float f) {
        AppMethodBeat.m2504i(66716);
        TXCLog.m15677i(TAG, "setSpeedRate:".concat(String.valueOf(f)));
        this.mSpeedRate = f;
        nativeSetSpeedRate(f);
        AppMethodBeat.m2505o(66716);
    }

    public void playFromTime(long j, long j2) {
        AppMethodBeat.m2504i(66717);
        TXCLog.m15677i(TAG, "playFromTime:" + j + ", " + j2);
        this.mStartTimeMS = j;
        this.mEndTimeMS = j2;
        nativePlayFromTime(j, j2);
        AppMethodBeat.m2505o(66717);
    }

    public void seekBytes(long j) {
        AppMethodBeat.m2504i(66718);
        TXCLog.m15677i(TAG, "seekBytes:".concat(String.valueOf(j)));
        if (j < 0) {
            TXCLog.m15676e(TAG, "seek bytes can not be negative. change to 0");
            j = 0;
        }
        this.mSeekBytes = j;
        nativeSeekBytes(j);
        AppMethodBeat.m2505o(66718);
    }

    public long getCurPosition() {
        AppMethodBeat.m2504i(66719);
        long nativeGetCurPosition = nativeGetCurPosition();
        TXCLog.m15677i(TAG, "getCurPosition:".concat(String.valueOf(nativeGetCurPosition)));
        AppMethodBeat.m2505o(66719);
        return nativeGetCurPosition;
    }

    public static long getDurationMS(String str) {
        AppMethodBeat.m2504i(66720);
        long nativeGetDurationMS = nativeGetDurationMS(str);
        AppMethodBeat.m2505o(66720);
        return nativeGetDurationMS;
    }

    private void onPlayStart() {
        AppMethodBeat.m2504i(66721);
        C45097e c45097e = null;
        synchronized (this) {
            try {
                if (this.mWeakListener != null) {
                    c45097e = (C45097e) this.mWeakListener.get();
                }
            } catch (Throwable th) {
                while (true) {
                    AppMethodBeat.m2505o(66721);
                }
            }
        }
        if (c45097e != null) {
            c45097e.mo67227a();
        }
        AppMethodBeat.m2505o(66721);
    }

    private void onPlayEnd(int i) {
        AppMethodBeat.m2504i(66722);
        C45097e c45097e = null;
        synchronized (this) {
            try {
                if (this.mWeakListener != null) {
                    c45097e = (C45097e) this.mWeakListener.get();
                }
            } catch (Throwable th) {
                while (true) {
                    AppMethodBeat.m2505o(66722);
                }
            }
        }
        if (c45097e != null) {
            c45097e.mo67228a(i);
        }
        AppMethodBeat.m2505o(66722);
    }

    private void onPlayProgress(long j, long j2) {
        AppMethodBeat.m2504i(66723);
        C45097e c45097e = null;
        synchronized (this) {
            try {
                if (this.mWeakListener != null) {
                    c45097e = (C45097e) this.mWeakListener.get();
                }
            } catch (Throwable th) {
                while (true) {
                    AppMethodBeat.m2505o(66723);
                }
            }
        }
        if (c45097e != null) {
            c45097e.mo67229a(j, j2);
        }
        AppMethodBeat.m2505o(66723);
    }

    public void run() {
        int i;
        AudioTrack audioTrack;
        int i2 = 3;
        AppMethodBeat.m2504i(66724);
        long currentTimeMillis = System.currentTimeMillis();
        onPlayStart();
        if (this.mFilePath == null || this.mFilePath.isEmpty()) {
            TXCLog.m15676e(TAG, "file path = " + this.mFilePath);
            i = -2;
            audioTrack = null;
        } else {
            nativeSetVolume(this.mVolume);
            nativeSetSpeedRate(this.mSpeedRate);
            nativePlayFromTime(this.mStartTimeMS, this.mEndTimeMS);
            nativeSeekBytes(this.mSeekBytes);
            if (nativeStartPlay(this.mFilePath)) {
                int i3;
                if (this.mIsPause) {
                    nativePause();
                } else {
                    nativeResume();
                }
                TXCLog.m15677i(TAG, "start play bgm: path = " + this.mFilePath + "volume = " + this.mVolume + ", speedRate = " + this.mSpeedRate + ", startTime = " + this.mStartTimeMS + ", endTime = " + this.mEndTimeMS + ", seekBytes = " + this.mSeekBytes + ", pause = " + this.mIsPause);
                int nativeGetSampleRate = nativeGetSampleRate();
                int nativeGetChannels = nativeGetChannels();
                i = nativeGetBitsPerChannel();
                if (nativeGetChannels == 1) {
                    i3 = 2;
                } else {
                    i3 = 3;
                }
                if (i != 8) {
                    i2 = 2;
                }
                try {
                    AudioTrack audioTrack2 = new AudioTrack(3, nativeGetSampleRate, i3, i2, AudioTrack.getMinBufferSize(nativeGetSampleRate, i3, i2), 1);
                    try {
                        audioTrack2.play();
                        i = (nativeGetChannels * 2048) * 2;
                        byte[] bArr = new byte[i];
                        while (this.mIsRunning && !Thread.interrupted()) {
                            i3 = nativeRead(bArr, i);
                            if (i3 < 0) {
                                TXCLog.m15677i(TAG, "UGC BGM播放结束");
                                onPlayProgress(nativeGetCurDurationMS(), nativeGetCurDurationMS());
                                i = 0;
                                audioTrack = audioTrack2;
                                break;
                            } else if (i3 != 0) {
                                audioTrack2.write(bArr, 0, i3);
                                onPlayProgress(nativeGetCurPtsMS(), nativeGetCurDurationMS());
                            } else if (this.mIsPause) {
                                try {
                                    Thread.sleep(100);
                                } catch (InterruptedException e) {
                                }
                            }
                        }
                        i = 0;
                        audioTrack = audioTrack2;
                    } catch (Exception e2) {
                        TXCLog.m15676e(TAG, "AudioTrack play Exception: " + e2.getMessage());
                        i = -4;
                        audioTrack = audioTrack2;
                    }
                } catch (Exception e3) {
                    TXCLog.m15676e(TAG, "new AudioTrack Exception: " + e3.getMessage());
                    i = -3;
                    audioTrack = null;
                }
            } else {
                i = -1;
                audioTrack = null;
            }
        }
        if (audioTrack != null) {
            try {
                audioTrack.pause();
                audioTrack.flush();
                audioTrack.stop();
                audioTrack.release();
            } catch (Exception e4) {
            }
        }
        TXCLog.m15677i(TAG, "UGC BGM player play time: " + (System.currentTimeMillis() - currentTimeMillis));
        if (this.mIsRunning) {
            onPlayEnd(i);
        }
        AppMethodBeat.m2505o(66724);
    }
}
