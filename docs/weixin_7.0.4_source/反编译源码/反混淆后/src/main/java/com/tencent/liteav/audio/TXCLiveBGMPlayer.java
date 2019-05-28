package com.tencent.liteav.audio;

import android.content.Context;
import android.media.AudioTrack;
import android.os.Handler;
import android.os.Looper;
import com.tencent.liteav.audio.impl.TXCTraeJNI;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.C17778b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;

public class TXCLiveBGMPlayer implements Runnable {
    private static final int PLAY_ERR_AUDIO_TRACK = -3;
    private static final int PLAY_ERR_AUDIO_TRACK_PLAY = -4;
    private static final int PLAY_ERR_FILE_NOTFOUND = -2;
    private static final int PLAY_ERR_OPEN = -1;
    private static final int PLAY_SUCCESS = 0;
    private static final String TAG = ("AudioCenter:" + TXCLiveBGMPlayer.class.getSimpleName());
    private static TXCLiveBGMPlayer instance;
    private int mAECType = TXEAudioDef.TXE_AEC_NONE;
    private Context mContext = null;
    private String mFilePath = null;
    private boolean mIsPause = false;
    private boolean mIsRunning = false;
    private float mPitch = 0.0f;
    private Thread mThread = null;
    private WeakReference<C45097e> mWeakListener = null;

    private native int nativeGetBitsPerChannel();

    private native int nativeGetChannels();

    private native long nativeGetCurDurationMS();

    private native long nativeGetCurPtsMS();

    private native long nativeGetDurationMS(String str);

    private native int nativeGetSampleRate();

    private native void nativePause();

    private native int nativeRead(byte[] bArr, int i);

    private native void nativeResume();

    private native void nativeSetPitch(float f);

    private native void nativeSetVolume(float f);

    private native boolean nativeStartPlay(String str, TXCLiveBGMPlayer tXCLiveBGMPlayer);

    private native void nativeStopPlay();

    static {
        AppMethodBeat.m2504i(66516);
        C17778b.m27756e();
        AppMethodBeat.m2505o(66516);
    }

    public static TXCLiveBGMPlayer getInstance() {
        AppMethodBeat.m2504i(66501);
        if (instance == null) {
            synchronized (TXCLiveBGMPlayer.class) {
                try {
                    if (instance == null) {
                        instance = new TXCLiveBGMPlayer();
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.m2505o(66501);
                    }
                }
            }
        }
        TXCLiveBGMPlayer tXCLiveBGMPlayer = instance;
        AppMethodBeat.m2505o(66501);
        return tXCLiveBGMPlayer;
    }

    private TXCLiveBGMPlayer() {
    }

    public synchronized void setOnPlayListener(C45097e c45097e) {
        AppMethodBeat.m2504i(66502);
        if (c45097e == null) {
            this.mWeakListener = null;
        }
        this.mWeakListener = new WeakReference(c45097e);
        AppMethodBeat.m2505o(66502);
    }

    public void setContext(Context context) {
        this.mContext = context;
    }

    public boolean startPlay(String str, int i) {
        AppMethodBeat.m2504i(66503);
        if (str == null || str.isEmpty()) {
            TXCLog.m15676e(TAG, "start live bgm failed! invalid params!");
            AppMethodBeat.m2505o(66503);
            return false;
        }
        stopPlay();
        this.mAECType = i;
        this.mFilePath = str;
        this.mIsRunning = true;
        onPlayStart();
        if (nativeStartPlay(this.mFilePath, this)) {
            if (this.mAECType == TXEAudioDef.TXE_AEC_TRAE) {
                TXCTraeJNI.traeStartPlay(this.mContext);
            } else if (this.mThread == null) {
                this.mThread = new Thread(this, "BGMPlayer");
                this.mThread.start();
            }
            TXCLog.m15677i(TAG, "startPlay filePath = ".concat(String.valueOf(str)));
            AppMethodBeat.m2505o(66503);
            return true;
        }
        onPlayEnd(-1);
        AppMethodBeat.m2505o(66503);
        return false;
    }

    public void stopPlay() {
        AppMethodBeat.m2504i(66504);
        this.mIsRunning = false;
        long currentTimeMillis = System.currentTimeMillis();
        if (!(this.mThread == null || !this.mThread.isAlive() || Thread.currentThread().getId() == this.mThread.getId())) {
            try {
                this.mThread.join();
            } catch (InterruptedException e) {
            }
        }
        this.mThread = null;
        nativeStopPlay();
        TXCTraeJNI.traeStopPlay();
        this.mIsPause = false;
        TXCLog.m15677i(TAG, "stopBGMPlay cost(MS): " + (System.currentTimeMillis() - currentTimeMillis));
        AppMethodBeat.m2505o(66504);
    }

    public boolean isRunning() {
        return this.mIsRunning && !this.mIsPause;
    }

    public boolean isPlaying() {
        return this.mIsRunning;
    }

    public void switchAecType(int i) {
        AppMethodBeat.m2504i(66505);
        if (!this.mIsRunning) {
            TXCLog.m15679w(TAG, "未开始播放BGM，不能切换AEC Type");
            AppMethodBeat.m2505o(66505);
        } else if (this.mAECType == i) {
            TXCLog.m15677i(TAG, "无需切换AEC Type. aecType = " + this.mAECType);
            AppMethodBeat.m2505o(66505);
        } else {
            TXCLog.m15677i(TAG, "切换AEC Type为 ".concat(String.valueOf(i)));
            this.mAECType = i;
            if (this.mAECType == TXEAudioDef.TXE_AEC_TRAE) {
                if (!(this.mThread == null || !this.mThread.isAlive() || Thread.currentThread().getId() == this.mThread.getId())) {
                    try {
                        this.mThread.join();
                    } catch (InterruptedException e) {
                    }
                }
                this.mThread = null;
                AppMethodBeat.m2505o(66505);
                return;
            }
            if (this.mThread == null) {
                this.mThread = new Thread(this, "BGMPlayer");
                this.mThread.start();
            }
            AppMethodBeat.m2505o(66505);
        }
    }

    public void pause() {
        AppMethodBeat.m2504i(66506);
        TXCLog.m15677i(TAG, "pause");
        this.mIsPause = true;
        nativePause();
        AppMethodBeat.m2505o(66506);
    }

    public void resume() {
        AppMethodBeat.m2504i(66507);
        TXCLog.m15677i(TAG, "resume");
        this.mIsPause = false;
        nativeResume();
        AppMethodBeat.m2505o(66507);
    }

    public void setVolume(float f) {
        AppMethodBeat.m2504i(66508);
        nativeSetVolume(f);
        AppMethodBeat.m2505o(66508);
    }

    public long getMusicDuration(String str) {
        AppMethodBeat.m2504i(66509);
        long nativeGetDurationMS = nativeGetDurationMS(str);
        AppMethodBeat.m2505o(66509);
        return nativeGetDurationMS;
    }

    public void setPitch(float f) {
        AppMethodBeat.m2504i(66510);
        this.mPitch = f;
        nativeSetPitch(f);
        AppMethodBeat.m2505o(66510);
    }

    private void onPlayStart() {
        AppMethodBeat.m2504i(66511);
        C45097e c45097e = null;
        synchronized (this) {
            try {
                if (this.mWeakListener != null) {
                    c45097e = (C45097e) this.mWeakListener.get();
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(66511);
            }
        }
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            public void run() {
                AppMethodBeat.m2504i(66517);
                if (c45097e != null) {
                    c45097e.mo67227a();
                }
                AppMethodBeat.m2505o(66517);
            }
        });
    }

    private void onPlayEnd(final int i) {
        AppMethodBeat.m2504i(66512);
        C45097e c45097e = null;
        synchronized (this) {
            try {
                if (this.mWeakListener != null) {
                    c45097e = (C45097e) this.mWeakListener.get();
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(66512);
            }
        }
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            public void run() {
                AppMethodBeat.m2504i(66708);
                if (c45097e != null) {
                    c45097e.mo67228a(i);
                }
                AppMethodBeat.m2505o(66708);
            }
        });
    }

    private void onPlayProgress(long j, long j2) {
        AppMethodBeat.m2504i(66513);
        C45097e c45097e = null;
        synchronized (this) {
            try {
                if (this.mWeakListener != null) {
                    c45097e = (C45097e) this.mWeakListener.get();
                }
            } catch (Throwable th) {
                while (true) {
                    AppMethodBeat.m2505o(66513);
                }
            }
        }
        if (c45097e != null) {
            c45097e.mo67229a(j, j2);
        }
        AppMethodBeat.m2505o(66513);
    }

    private void nativeOPlayProgress(long j, long j2) {
        AppMethodBeat.m2504i(66514);
        onPlayProgress(j, j2);
        if (j == j2) {
            onPlayEnd(0);
        }
        AppMethodBeat.m2505o(66514);
    }

    public void run() {
        int i;
        AudioTrack audioTrack;
        int i2 = 3;
        AppMethodBeat.m2504i(66515);
        long currentTimeMillis = System.currentTimeMillis();
        if (this.mFilePath == null || this.mFilePath.isEmpty()) {
            i = -2;
            audioTrack = null;
        } else {
            int i3;
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
                    i = nativeGetChannels * 2048;
                    byte[] bArr = new byte[i];
                    while (this.mIsRunning && !Thread.interrupted() && this.mAECType != TXEAudioDef.TXE_AEC_TRAE) {
                        i3 = nativeRead(bArr, i);
                        if (i3 < 0) {
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
        TXCLog.m15677i(TAG, "Live BGM player play time: " + (System.currentTimeMillis() - currentTimeMillis));
        if (this.mIsRunning) {
            onPlayEnd(i);
        }
        AppMethodBeat.m2505o(66515);
    }
}
