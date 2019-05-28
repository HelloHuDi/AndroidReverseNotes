package com.tencent.smtt.sdk;

import android.graphics.SurfaceTexture;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class TbsMediaPlayer {
    /* renamed from: a */
    private C30945ba f17980a = null;

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

    public TbsMediaPlayer(C30945ba c30945ba) {
        this.f17980a = c30945ba;
    }

    public void audio(int i) {
        AppMethodBeat.m2504i(64528);
        this.f17980a.mo50057b(i);
        AppMethodBeat.m2505o(64528);
    }

    public void close() {
        AppMethodBeat.m2504i(64532);
        this.f17980a.mo50060e();
        AppMethodBeat.m2505o(64532);
    }

    public float getVolume() {
        AppMethodBeat.m2504i(64524);
        float b = this.f17980a.mo50056b();
        AppMethodBeat.m2505o(64524);
        return b;
    }

    public boolean isAvailable() {
        AppMethodBeat.m2504i(64521);
        boolean a = this.f17980a.mo50055a();
        AppMethodBeat.m2505o(64521);
        return a;
    }

    public void pause() {
        AppMethodBeat.m2504i(64529);
        this.f17980a.mo50058c();
        AppMethodBeat.m2505o(64529);
    }

    public void play() {
        AppMethodBeat.m2504i(64530);
        this.f17980a.mo50059d();
        AppMethodBeat.m2505o(64530);
    }

    public void seek(long j) {
        AppMethodBeat.m2504i(64531);
        this.f17980a.mo50051a(j);
        AppMethodBeat.m2505o(64531);
    }

    public void setPlayerListener(TbsMediaPlayerListener tbsMediaPlayerListener) {
        AppMethodBeat.m2504i(64523);
        this.f17980a.mo50053a(tbsMediaPlayerListener);
        AppMethodBeat.m2505o(64523);
    }

    public void setSurfaceTexture(SurfaceTexture surfaceTexture) {
        AppMethodBeat.m2504i(64522);
        this.f17980a.mo50052a(surfaceTexture);
        AppMethodBeat.m2505o(64522);
    }

    public void setVolume(float f) {
        AppMethodBeat.m2504i(64525);
        this.f17980a.mo50049a(f);
        AppMethodBeat.m2505o(64525);
    }

    public void startPlay(String str, Bundle bundle) {
        AppMethodBeat.m2504i(64526);
        this.f17980a.mo50054a(str, bundle);
        AppMethodBeat.m2505o(64526);
    }

    public void subtitle(int i) {
        AppMethodBeat.m2504i(64527);
        this.f17980a.mo50050a(i);
        AppMethodBeat.m2505o(64527);
    }
}
