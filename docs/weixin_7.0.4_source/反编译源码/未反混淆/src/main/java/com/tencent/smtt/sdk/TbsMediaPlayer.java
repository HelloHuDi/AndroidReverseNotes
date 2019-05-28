package com.tencent.smtt.sdk;

import android.graphics.SurfaceTexture;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class TbsMediaPlayer {
    private ba a = null;

    public interface TbsMediaPlayerListener {
        public static final int MEDIA_EXTRA_AUDIOTRACK_INDEX = 104;
        public static final int MEDIA_EXTRA_AUDIOTRACK_TITLES = 103;
        public static final int MEDIA_EXTRA_SUBTITLE_COUNT = 101;
        public static final int MEDIA_EXTRA_SUBTITLE_INDEX = 102;
        public static final int MEDIA_INFO_BAD_INTERLEAVING = 800;
        public static final int MEDIA_INFO_BUFFERING_END = 702;
        public static final int MEDIA_INFO_BUFFERING_PERCENTAGE = 790;
        public static final int MEDIA_INFO_BUFFERING_START = 701;
        public static final int MEDIA_INFO_EXTERNAL_METADATA_UPDATE = 803;
        public static final int MEDIA_INFO_HAVE_VIDEO_DATA = 752;
        public static final int MEDIA_INFO_METADATA_UPDATE = 802;
        public static final int MEDIA_INFO_NETWORK_BANDWIDTH = 703;
        public static final int MEDIA_INFO_NOT_SEEKABLE = 801;
        public static final int MEDIA_INFO_NO_VIDEO_DATA = 751;
        public static final int MEDIA_INFO_SUBTITLE_TIMED_OUT = 902;
        public static final int MEDIA_INFO_TIMED_TEXT_ERROR = 900;
        public static final int MEDIA_INFO_UNSUPPORTED_SUBTITLE = 901;
        public static final int MEDIA_INFO_VIDEO_TRACK_LAGGING = 700;
        public static final int ROTATE_ACTION_HASROTATE = 3;
        public static final int ROTATE_ACTION_NOTHING = 1;
        public static final int ROTATE_ACTION_SETDEGREE = 2;
        public static final int ROTATE_ACTION_UNKNOWN = 0;

        void onBufferingUpdate(float f);

        void onPlayerCompleted();

        void onPlayerError(String str, int i, int i2, Throwable th);

        void onPlayerExtra(int i, Object obj);

        void onPlayerInfo(int i, int i2);

        void onPlayerPaused();

        void onPlayerPlaying();

        void onPlayerPrepared(long j, int i, int i2, int i3, int i4);

        void onPlayerProgress(long j);

        void onPlayerSeeked(long j);

        void onPlayerSubtitle(String str);
    }

    public TbsMediaPlayer(ba baVar) {
        this.a = baVar;
    }

    public void audio(int i) {
        AppMethodBeat.i(64528);
        this.a.b(i);
        AppMethodBeat.o(64528);
    }

    public void close() {
        AppMethodBeat.i(64532);
        this.a.e();
        AppMethodBeat.o(64532);
    }

    public float getVolume() {
        AppMethodBeat.i(64524);
        float b = this.a.b();
        AppMethodBeat.o(64524);
        return b;
    }

    public boolean isAvailable() {
        AppMethodBeat.i(64521);
        boolean a = this.a.a();
        AppMethodBeat.o(64521);
        return a;
    }

    public void pause() {
        AppMethodBeat.i(64529);
        this.a.c();
        AppMethodBeat.o(64529);
    }

    public void play() {
        AppMethodBeat.i(64530);
        this.a.d();
        AppMethodBeat.o(64530);
    }

    public void seek(long j) {
        AppMethodBeat.i(64531);
        this.a.a(j);
        AppMethodBeat.o(64531);
    }

    public void setPlayerListener(TbsMediaPlayerListener tbsMediaPlayerListener) {
        AppMethodBeat.i(64523);
        this.a.a(tbsMediaPlayerListener);
        AppMethodBeat.o(64523);
    }

    public void setSurfaceTexture(SurfaceTexture surfaceTexture) {
        AppMethodBeat.i(64522);
        this.a.a(surfaceTexture);
        AppMethodBeat.o(64522);
    }

    public void setVolume(float f) {
        AppMethodBeat.i(64525);
        this.a.a(f);
        AppMethodBeat.o(64525);
    }

    public void startPlay(String str, Bundle bundle) {
        AppMethodBeat.i(64526);
        this.a.a(str, bundle);
        AppMethodBeat.o(64526);
    }

    public void subtitle(int i) {
        AppMethodBeat.i(64527);
        this.a.a(i);
        AppMethodBeat.o(64527);
    }
}
