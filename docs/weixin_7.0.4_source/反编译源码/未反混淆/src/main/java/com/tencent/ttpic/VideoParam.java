package com.tencent.ttpic;

import android.os.Environment;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class VideoParam {
    private static final int BPS = 4194304;
    private static final int FPS = 25;
    private static final int IFI = 5;
    private static final String MIME = "video/avc";
    private static final String SDCARD = Environment.getExternalStorageDirectory().getPath();
    private static final String TAG = "VideoParam";
    private static final int VIDEO_H = 480;
    private static final int VIDEO_W = 640;
    public static int mBps = BPS;
    public static int mIfi = 5;
    public static String mMime = MIME;
    public int[] mFpsRange;

    static {
        AppMethodBeat.i(49576);
        AppMethodBeat.o(49576);
    }
}
