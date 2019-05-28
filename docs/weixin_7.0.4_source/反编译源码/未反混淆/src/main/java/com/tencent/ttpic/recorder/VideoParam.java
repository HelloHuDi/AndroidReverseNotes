package com.tencent.ttpic.recorder;

import android.annotation.TargetApi;
import android.hardware.Camera.Parameters;
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
    public int mBps = BPS;
    public int[] mFpsRange;
    public int mIfi = 5;
    public String mMime = MIME;

    static {
        AppMethodBeat.i(83728);
        AppMethodBeat.o(83728);
    }

    public int getMaxFps() {
        if (this.mFpsRange == null || this.mFpsRange.length <= 1) {
            return 25;
        }
        return this.mFpsRange[1] / 1000;
    }

    @TargetApi(18)
    public void init(Parameters parameters) {
        AppMethodBeat.i(83727);
        if (parameters == null) {
            AppMethodBeat.o(83727);
            return;
        }
        int[] iArr = null;
        if (parameters.getSupportedPreviewFpsRange() != null) {
            for (int[] iArr2 : parameters.getSupportedPreviewFpsRange()) {
                int[] iArr22;
                if (iArr22[1] < 25000) {
                    iArr22 = iArr;
                }
                iArr = iArr22;
            }
        }
        if (iArr == null) {
            String.format("Not support fps: %d", new Object[]{Integer.valueOf(25)});
        }
        this.mFpsRange = iArr;
        AppMethodBeat.o(83727);
    }
}
