package com.tencent.mm.plugin.topstory.ui.video;

import android.content.Context;
import android.view.OrientationEventListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import com.tencent.ttpic.thread.FaceGestureDetGLThread;

public final class i extends OrientationEventListener {
    private int orientation = -1;
    private int otG = -1;
    private int otH = -1;
    private long otI = 0;
    private long otJ = 0;
    a sEB;

    public interface a {
        void yR(int i);
    }

    public i(Context context) {
        super(context);
    }

    public final void onOrientationChanged(int i) {
        AppMethodBeat.i(1730);
        if (bo.az(this.otJ) < FaceGestureDetGLThread.BRIGHTNESS_DURATION) {
            ab.v("MicroMsg.TopStory.TopStoryDeviceOrientationListener", "onOrientationChanged, not reach DETECT_THRESHOLD");
            AppMethodBeat.o(1730);
            return;
        }
        ab.d("MicroMsg.TopStory.TopStoryDeviceOrientationListener", "onOrientationChanged: %s", Integer.valueOf(i));
        if (Math.abs(this.otG - i) >= 60 && bo.az(this.otI) >= 1000) {
            this.otG = i;
            this.otI = bo.yz();
            if (i <= 60 || i >= 300) {
                if (i <= 30 || i >= ErrorCode.ERROR_QBSDK_INIT_ERROR_RET_TYPE_NOT_BUNDLE) {
                    this.orientation = 0;
                }
            } else if (i < 30 || i > 150) {
                if (i < 120 || i > 240) {
                    if (i >= 210 && i <= ErrorCode.ERROR_QBSDK_INIT_ERROR_RET_TYPE_NOT_BUNDLE && i >= 240 && i <= 300) {
                        this.orientation = 270;
                    }
                } else if (i >= 150 && i <= 210) {
                    this.orientation = 180;
                }
            } else if (i >= 60 && i <= 120) {
                this.orientation = 90;
            }
            if (this.sEB != null) {
                this.sEB.yR(this.orientation);
            }
        }
        AppMethodBeat.o(1730);
    }

    public final void enable() {
        AppMethodBeat.i(1731);
        super.enable();
        this.otJ = bo.yz();
        AppMethodBeat.o(1731);
    }
}
