package com.tencent.liteav.audio;

import android.content.Context;
import android.media.AudioTrack;
import android.os.Handler;
import android.os.Looper;
import com.tencent.liteav.audio.impl.TXCTraeJNI;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.b;
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
    private WeakReference<e> mWeakListener = null;

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
        AppMethodBeat.i(66516);
        b.e();
        AppMethodBeat.o(66516);
    }

    public static TXCLiveBGMPlayer getInstance() {
        AppMethodBeat.i(66501);
        if (instance == null) {
            synchronized (TXCLiveBGMPlayer.class) {
                try {
                    if (instance == null) {
                        instance = new TXCLiveBGMPlayer();
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.o(66501);
                    }
                }
            }
        }
        TXCLiveBGMPlayer tXCLiveBGMPlayer = instance;
        AppMethodBeat.o(66501);
        return tXCLiveBGMPlayer;
    }

    private TXCLiveBGMPlayer() {
    }

    public synchronized void setOnPlayListener(e eVar) {
        AppMethodBeat.i(66502);
        if (eVar == null) {
            this.mWeakListener = null;
        }
        this.mWeakListener = new WeakReference(eVar);
        AppMethodBeat.o(66502);
    }

    public void setContext(Context context) {
        this.mContext = context;
    }

    public boolean startPlay(String str, int i) {
        AppMethodBeat.i(66503);
        if (str == null || str.isEmpty()) {
            TXCLog.e(TAG, "start live bgm failed! invalid params!");
            AppMethodBeat.o(66503);
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
            TXCLog.i(TAG, "startPlay filePath = ".concat(String.valueOf(str)));
            AppMethodBeat.o(66503);
            return true;
        }
        onPlayEnd(-1);
        AppMethodBeat.o(66503);
        return false;
    }

    public void stopPlay() {
        AppMethodBeat.i(66504);
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
        TXCLog.i(TAG, "stopBGMPlay cost(MS): " + (System.currentTimeMillis() - currentTimeMillis));
        AppMethodBeat.o(66504);
    }

    public boolean isRunning() {
        return this.mIsRunning && !this.mIsPause;
    }

    public boolean isPlaying() {
        return this.mIsRunning;
    }

    public void switchAecType(int i) {
        AppMethodBeat.i(66505);
        if (!this.mIsRunning) {
            TXCLog.w(TAG, "未开始播放BGM，不能切换AEC Type");
            AppMethodBeat.o(66505);
        } else if (this.mAECType == i) {
            TXCLog.i(TAG, "无需切换AEC Type. aecType = " + this.mAECType);
            AppMethodBeat.o(66505);
        } else {
            TXCLog.i(TAG, "切换AEC Type为 ".concat(String.valueOf(i)));
            this.mAECType = i;
            if (this.mAECType == TXEAudioDef.TXE_AEC_TRAE) {
                if (!(this.mThread == null || !this.mThread.isAlive() || Thread.currentThread().getId() == this.mThread.getId())) {
                    try {
                        this.mThread.join();
                    } catch (InterruptedException e) {
                    }
                }
                this.mThread = null;
                AppMethodBeat.o(66505);
                return;
            }
            if (this.mThread == null) {
                this.mThread = new Thread(this, "BGMPlayer");
                this.mThread.start();
            }
            AppMethodBeat.o(66505);
        }
    }

    public void pause() {
        AppMethodBeat.i(66506);
        TXCLog.i(TAG, "pause");
        this.mIsPause = true;
        nativePause();
        AppMethodBeat.o(66506);
    }

    public void resume() {
        AppMethodBeat.i(66507);
        TXCLog.i(TAG, "resume");
        this.mIsPause = false;
        nativeResume();
        AppMethodBeat.o(66507);
    }

    public void setVolume(float f) {
        AppMethodBeat.i(66508);
        nativeSetVolume(f);
        AppMethodBeat.o(66508);
    }

    public long getMusicDuration(String str) {
        AppMethodBeat.i(66509);
        long nativeGetDurationMS = nativeGetDurationMS(str);
        AppMethodBeat.o(66509);
        return nativeGetDurationMS;
    }

    public void setPitch(float f) {
        AppMethodBeat.i(66510);
        this.mPitch = f;
        nativeSetPitch(f);
        AppMethodBeat.o(66510);
    }

    private void onPlayStart() {
        AppMethodBeat.i(66511);
        e eVar = null;
        synchronized (this) {
            try {
                if (this.mWeakListener != null) {
                    eVar = (e) this.mWeakListener.get();
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(66511);
            }
        }
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            public void run() {
                AppMethodBeat.i(66517);
                if (eVar != null) {
                    eVar.a();
                }
                AppMethodBeat.o(66517);
            }
        });
    }

    private void onPlayEnd(final int i) {
        AppMethodBeat.i(66512);
        e eVar = null;
        synchronized (this) {
            try {
                if (this.mWeakListener != null) {
                    eVar = (e) this.mWeakListener.get();
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(66512);
            }
        }
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            public void run() {
                AppMethodBeat.i(66708);
                if (eVar != null) {
                    eVar.a(i);
                }
                AppMethodBeat.o(66708);
            }
        });
    }

    private void onPlayProgress(long j, long j2) {
        AppMethodBeat.i(66513);
        e eVar = null;
        synchronized (this) {
            try {
                if (this.mWeakListener != null) {
                    eVar = (e) this.mWeakListener.get();
                }
            } catch (Throwable th) {
                while (true) {
                    AppMethodBeat.o(66513);
                }
            }
        }
        if (eVar != null) {
            eVar.a(j, j2);
        }
        AppMethodBeat.o(66513);
    }

    private void nativeOPlayProgress(long j, long j2) {
        AppMethodBeat.i(66514);
        onPlayProgress(j, j2);
        if (j == j2) {
            onPlayEnd(0);
        }
        AppMethodBeat.o(66514);
    }

    public void run() {
        int i;
        AudioTrack audioTrack;
        int i2 = 3;
        AppMethodBeat.i(66515);
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
                    TXCLog.e(TAG, "AudioTrack play Exception: " + e2.getMessage());
                    i = -4;
                    audioTrack = audioTrack2;
                }
            } catch (Exception e3) {
                TXCLog.e(TAG, "new AudioTrack Exception: " + e3.getMessage());
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
        TXCLog.i(TAG, "Live BGM player play time: " + (System.currentTimeMillis() - currentTimeMillis));
        if (this.mIsRunning) {
            onPlayEnd(i);
        }
        AppMethodBeat.o(66515);
    }
}
