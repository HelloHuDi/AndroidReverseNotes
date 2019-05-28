package com.tencent.qqmusic.mediaplayer;

public interface PlayerState {
    public static final int END = 8;
    public static final int ERROR = 9;
    public static final int IDLE = 0;
    public static final int INITIALIZED = 1;
    public static final int PAUSED = 5;
    public static final int PLAYBACKCOMPLETED = 7;
    public static final int PREPARED = 2;
    public static final int PREPARING = 3;
    public static final int STARTED = 4;
    public static final int STOPPED = 6;
}
