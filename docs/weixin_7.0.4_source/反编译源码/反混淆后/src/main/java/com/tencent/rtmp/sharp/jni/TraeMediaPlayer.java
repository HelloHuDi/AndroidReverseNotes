package com.tencent.rtmp.sharp.jni;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.net.Uri;
import android.os.Build.VERSION;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class TraeMediaPlayer implements OnCompletionListener, OnErrorListener {
    public static final int TRAE_MEDIAPLAER_DATASOURCE_FILEPATH = 2;
    public static final int TRAE_MEDIAPLAER_DATASOURCE_RSID = 0;
    public static final int TRAE_MEDIAPLAER_DATASOURCE_URI = 1;
    public static final int TRAE_MEDIAPLAER_STOP = 100;
    private Context _context;
    private int _durationMS = -1;
    private boolean _hasCall = false;
    private boolean _loop = false;
    int _loopCount = 0;
    private int _prevVolume = -1;
    boolean _ringMode = false;
    private int _streamType = 0;
    private Timer _watchTimer = null;
    private TimerTask _watchTimertask = null;
    private C24256a mCallback;
    private MediaPlayer mMediaPlay = null;

    /* renamed from: com.tencent.rtmp.sharp.jni.TraeMediaPlayer$a */
    public interface C24256a {
        /* renamed from: a */
        void mo12031a();
    }

    /* renamed from: com.tencent.rtmp.sharp.jni.TraeMediaPlayer$1 */
    class C409631 extends TimerTask {
        C409631() {
        }

        public void run() {
            AppMethodBeat.m2504i(65610);
            if (TraeMediaPlayer.this.mMediaPlay != null) {
                if (QLog.isColorLevel()) {
                    QLog.m8765e("TRAE", 2, "TraeMediaPlay | play timeout");
                }
                if (TraeMediaPlayer.this.mCallback != null) {
                    TraeMediaPlayer.this.mCallback.mo12031a();
                }
            }
            AppMethodBeat.m2505o(65610);
        }
    }

    public TraeMediaPlayer(Context context, C24256a c24256a) {
        this._context = context;
        this.mCallback = c24256a;
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x00fe A:{Catch:{ Exception -> 0x0131, all -> 0x0178, IllegalStateException -> 0x0136, IOException -> 0x0183, IllegalArgumentException -> 0x0283, SecurityException -> 0x02d7 }} */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x01e7 A:{SYNTHETIC, Splitter:B:62:0x01e7} */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0121 A:{Catch:{ Exception -> 0x0131, all -> 0x0178, IllegalStateException -> 0x0136, IOException -> 0x0183, IllegalArgumentException -> 0x0283, SecurityException -> 0x02d7 }} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean playRing(int i, int i2, Uri uri, String str, boolean z, int i3, boolean z2, boolean z3, int i4) {
        String str2;
        AppMethodBeat.m2504i(65619);
        if (QLog.isColorLevel()) {
            QLog.m8765e("TRAE", 2, "TraeMediaPlay | playRing datasource:" + i + " rsid:" + i2 + " uri:" + uri + " filepath:" + str + " loop:" + (z ? "Y" : "N") + " :loopCount" + i3 + " ringMode:" + (z2 ? "Y" : "N") + " hasCall:" + z3 + " cst:" + i4);
        }
        if (z || i3 > 0) {
            AudioManager audioManager;
            MediaPlayer e;
            try {
                if (this.mMediaPlay != null) {
                    boolean isPlaying = this.mMediaPlay.isPlaying();
                    if (isPlaying) {
                        AppMethodBeat.m2505o(65619);
                        return isPlaying;
                    }
                    e = this.mMediaPlay;
                    e.release();
                    this.mMediaPlay = e;
                }
            } catch (Exception e2) {
                e = e2;
                this.mMediaPlay = e;
                if (this._watchTimer != null) {
                }
                audioManager = (AudioManager) this._context.getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE);
                this.mMediaPlay = new MediaPlayer();
                if (this.mMediaPlay != null) {
                }
            } catch (IllegalStateException e3) {
                e = e3;
                try {
                    if (QLog.isColorLevel()) {
                        str2 = "TRAE";
                    }
                } catch (Exception e4) {
                    if (QLog.isColorLevel()) {
                        QLog.m8763d("TRAE", 2, "TraeMediaPlay | Except: " + e4.getLocalizedMessage() + " " + e4.getMessage());
                    }
                }
                try {
                    this.mMediaPlay.release();
                } catch (Exception e5) {
                }
                this.mMediaPlay = null;
                AppMethodBeat.m2505o(65619);
                return false;
            } catch (IOException e6) {
                e = e6;
                if (QLog.isColorLevel()) {
                    str2 = "TRAE";
                }
                this.mMediaPlay.release();
                this.mMediaPlay = null;
                AppMethodBeat.m2505o(65619);
                return false;
            } catch (IllegalArgumentException e7) {
                e = e7;
                if (QLog.isColorLevel()) {
                    str2 = "TRAE";
                }
                this.mMediaPlay.release();
                this.mMediaPlay = null;
                AppMethodBeat.m2505o(65619);
                return false;
            } catch (SecurityException e8) {
                e = e8;
                if (QLog.isColorLevel()) {
                    str2 = "TRAE";
                }
                this.mMediaPlay.release();
                this.mMediaPlay = null;
                AppMethodBeat.m2505o(65619);
                return false;
            } finally {
                this.mMediaPlay = null;
                AppMethodBeat.m2505o(65619);
            }
            if (this._watchTimer != null) {
                this._watchTimer.cancel();
                this._watchTimer = null;
                this._watchTimertask = null;
            }
            audioManager = (AudioManager) this._context.getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE);
            this.mMediaPlay = new MediaPlayer();
            if (this.mMediaPlay != null) {
                this.mMediaPlay.release();
                this.mMediaPlay = null;
                AppMethodBeat.m2505o(65619);
                return false;
            }
            this.mMediaPlay.setOnCompletionListener(this);
            this.mMediaPlay.setOnErrorListener(this);
            switch (i) {
                case 0:
                    if (QLog.isColorLevel()) {
                        QLog.m8765e("TRAE", 2, "TraeMediaPlay | rsid:".concat(String.valueOf(i2)));
                    }
                    AssetFileDescriptor openRawResourceFd = this._context.getResources().openRawResourceFd(i2);
                    if (openRawResourceFd != null) {
                        this.mMediaPlay.setDataSource(openRawResourceFd.getFileDescriptor(), openRawResourceFd.getStartOffset(), openRawResourceFd.getLength());
                        openRawResourceFd.close();
                        break;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.m8765e("TRAE", 2, "TraeMediaPlay | afd == null rsid:".concat(String.valueOf(i2)));
                    }
                    this.mMediaPlay.release();
                    this.mMediaPlay = null;
                    AppMethodBeat.m2505o(65619);
                    return false;
                case 1:
                    if (QLog.isColorLevel()) {
                        QLog.m8765e("TRAE", 2, "TraeMediaPlay | uri:".concat(String.valueOf(uri)));
                    }
                    this.mMediaPlay.setDataSource(this._context, uri);
                    break;
                case 2:
                    if (QLog.isColorLevel()) {
                        QLog.m8765e("TRAE", 2, "TraeMediaPlay | FilePath:".concat(String.valueOf(str)));
                    }
                    this.mMediaPlay.setDataSource(str);
                    break;
                default:
                    if (QLog.isColorLevel()) {
                        QLog.m8765e("TRAE", 2, "TraeMediaPlay | err datasource:".concat(String.valueOf(i)));
                    }
                    this.mMediaPlay.release();
                    this.mMediaPlay = null;
                    break;
            }
            if (this.mMediaPlay == null) {
                AppMethodBeat.m2505o(65619);
                return false;
            }
            this._ringMode = z2;
            int i5 = 0;
            if (this._ringMode) {
                this._streamType = 2;
                i5 = 1;
            } else {
                this._streamType = 0;
                if (VERSION.SDK_INT >= 11) {
                    i5 = 3;
                }
            }
            this._hasCall = z3;
            if (this._hasCall) {
                this._streamType = i4;
            }
            this.mMediaPlay.setAudioStreamType(this._streamType);
            this.mMediaPlay.prepare();
            this.mMediaPlay.setLooping(z);
            this.mMediaPlay.start();
            this._loop = z;
            if (this._loop) {
                this._loopCount = 1;
                this._durationMS = -1;
            } else {
                this._loopCount = i3;
                this._durationMS = this._loopCount * this.mMediaPlay.getDuration();
            }
            this._loopCount--;
            if (!this._hasCall) {
                audioManager.setMode(i5);
            }
            if (this._durationMS > 0) {
                this._watchTimer = new Timer();
                this._watchTimertask = new C409631();
                this._watchTimer.schedule(this._watchTimertask, (long) (this._durationMS + 1000));
            }
            if (QLog.isColorLevel()) {
                QLog.m8765e("TRAE", 2, "TraeMediaPlay | DurationMS:" + this.mMediaPlay.getDuration() + " loop:" + z);
            }
            AppMethodBeat.m2505o(65619);
            return true;
        }
        if (QLog.isColorLevel()) {
            QLog.m8765e("TRAE", 2, "TraeMediaPlay | playRing err datasource:" + i + " loop:" + (z ? "Y" : "N") + " :loopCount" + i3);
        }
        AppMethodBeat.m2505o(65619);
        return false;
    }

    public void stopRing() {
        AppMethodBeat.m2504i(65620);
        if (QLog.isColorLevel()) {
            QLog.m8763d("TRAE", 2, "TraeMediaPlay stopRing ");
        }
        if (this.mMediaPlay == null) {
            AppMethodBeat.m2505o(65620);
            return;
        }
        if (this.mMediaPlay.isPlaying()) {
            this.mMediaPlay.stop();
        }
        this.mMediaPlay.reset();
        try {
            if (this._watchTimer != null) {
                this._watchTimer.cancel();
                this._watchTimer = null;
                this._watchTimertask = null;
            }
            this.mMediaPlay.release();
        } catch (Exception e) {
        }
        this.mMediaPlay = null;
        this._durationMS = -1;
        AppMethodBeat.m2505o(65620);
    }

    public int getStreamType() {
        return this._streamType;
    }

    public int getDuration() {
        return this._durationMS;
    }

    public boolean hasCall() {
        return this._hasCall;
    }

    public void onCompletion(MediaPlayer mediaPlayer) {
        AppMethodBeat.m2504i(65621);
        AudioDeviceInterface.LogTraceEntry(" cb:" + this.mCallback + " loopCount:" + this._loopCount + " _loop:" + this._loop);
        if (this._loop) {
            if (QLog.isColorLevel()) {
                QLog.m8763d("TRAE", 2, "loop play,continue...");
            }
            AppMethodBeat.m2505o(65621);
            return;
        }
        try {
            if (this._loopCount <= 0) {
                volumeUndo();
                if (this.mMediaPlay.isPlaying()) {
                    this.mMediaPlay.stop();
                }
                this.mMediaPlay.reset();
                this.mMediaPlay.release();
                this.mMediaPlay = null;
                if (this.mCallback != null) {
                    this.mCallback.mo12031a();
                }
            } else {
                this.mMediaPlay.start();
                this._loopCount--;
            }
        } catch (Exception e) {
        }
        AudioDeviceInterface.LogTraceExit();
        AppMethodBeat.m2505o(65621);
    }

    public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        AppMethodBeat.m2504i(65622);
        AudioDeviceInterface.LogTraceEntry(" cb:" + this.mCallback + " arg1:" + i + " arg2:" + i2);
        try {
            this.mMediaPlay.release();
        } catch (Exception e) {
        }
        this.mMediaPlay = null;
        if (this.mCallback != null) {
            this.mCallback.mo12031a();
        }
        AudioDeviceInterface.LogTraceExit();
        AppMethodBeat.m2505o(65622);
        return false;
    }

    private void volumeDo() {
        AppMethodBeat.m2504i(65623);
        if (this.mMediaPlay == null || !this._ringMode || this._streamType == 2) {
            AppMethodBeat.m2505o(65623);
            return;
        }
        try {
            AudioManager audioManager = (AudioManager) this._context.getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE);
            int streamVolume = audioManager.getStreamVolume(this._streamType);
            int streamMaxVolume = audioManager.getStreamMaxVolume(this._streamType);
            int streamVolume2 = audioManager.getStreamVolume(2);
            int streamMaxVolume2 = audioManager.getStreamMaxVolume(2);
            int i = (int) (((((double) streamVolume2) * 1.0d) / ((double) streamMaxVolume2)) * ((double) streamMaxVolume));
            if (QLog.isColorLevel()) {
                QLog.m8765e("TRAE", 2, "TraeMediaPlay volumeDo currV:" + streamVolume + " maxV:" + streamMaxVolume + " currRV:" + streamVolume2 + " maxRV:" + streamMaxVolume2 + " setV:" + i);
            }
            if (i + 1 < streamMaxVolume) {
                streamMaxVolume = i + 1;
            }
            audioManager.setStreamVolume(this._streamType, streamMaxVolume, 0);
            this._prevVolume = streamVolume;
            AppMethodBeat.m2505o(65623);
        } catch (Exception e) {
            AppMethodBeat.m2505o(65623);
        }
    }

    private void volumeUndo() {
        AppMethodBeat.m2504i(65624);
        if (this.mMediaPlay == null || !this._ringMode || this._streamType == 2 || this._prevVolume == -1) {
            AppMethodBeat.m2505o(65624);
            return;
        }
        try {
            if (QLog.isColorLevel()) {
                QLog.m8765e("TRAE", 2, "TraeMediaPlay volumeUndo _prevVolume:" + this._prevVolume);
            }
            ((AudioManager) this._context.getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE)).setStreamVolume(this._streamType, this._prevVolume, 0);
            AppMethodBeat.m2505o(65624);
        } catch (Exception e) {
            AppMethodBeat.m2505o(65624);
        }
    }
}
