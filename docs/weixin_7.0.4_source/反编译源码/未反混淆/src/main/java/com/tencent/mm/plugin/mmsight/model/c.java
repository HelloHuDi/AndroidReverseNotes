package com.tencent.mm.plugin.mmsight.model;

import android.content.Context;
import android.view.OrientationEventListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import com.tencent.ttpic.thread.FaceGestureDetGLThread;

public final class c extends OrientationEventListener {
    private int orientation = -1;
    private int otG = -1;
    private int otH = -1;
    private long otI = 0;
    private long otJ = 0;
    public a otK;

    public interface a {
        void yR(int i);
    }

    public c(Context context) {
        super(context, 2);
    }

    public final void onOrientationChanged(int i) {
        AppMethodBeat.i(76464);
        if (!j.ouw) {
            AppMethodBeat.o(76464);
        } else if (bo.az(this.otJ) < FaceGestureDetGLThread.BRIGHTNESS_DURATION) {
            ab.v("MicroMsg.DeviceOrientationListener", "onOrientationChanged, not reach DETECT_THRESHOLD");
            AppMethodBeat.o(76464);
        } else {
            if (Math.abs(this.otG - i) >= 30 || bo.az(this.otI) >= 300) {
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
                if (this.otK != null) {
                    this.otK.yR(this.orientation);
                }
            }
            AppMethodBeat.o(76464);
        }
    }

    public final void enable() {
        AppMethodBeat.i(76465);
        ab.i("MicroMsg.DeviceOrientationListener", "enable, config isEnableLandscapeMode: %s", Boolean.valueOf(j.ouw));
        if (j.ouw) {
            super.enable();
            this.otJ = bo.yz();
        }
        AppMethodBeat.o(76465);
    }

    public final int getOrientation() {
        if (j.ouw) {
            return this.orientation;
        }
        return 0;
    }

    public final boolean isLandscape() {
        AppMethodBeat.i(76466);
        if (j.ouw) {
            ab.i("MicroMsg.DeviceOrientationListener", "isLandscape, tickToNow: %s, orientation: %s", Long.valueOf(bo.az(this.otJ)), Integer.valueOf(this.orientation));
            if (bo.az(this.otJ) < FaceGestureDetGLThread.BRIGHTNESS_DURATION) {
                AppMethodBeat.o(76466);
                return false;
            } else if (this.orientation < 0) {
                AppMethodBeat.o(76466);
                return false;
            } else if (this.orientation == 90 || this.orientation == 270) {
                AppMethodBeat.o(76466);
                return true;
            } else {
                AppMethodBeat.o(76466);
                return false;
            }
        }
        AppMethodBeat.o(76466);
        return false;
    }

    public final void reset() {
        AppMethodBeat.i(76467);
        ab.i("MicroMsg.DeviceOrientationListener", "reset");
        this.otH = -1;
        this.orientation = -1;
        this.otG = -1;
        AppMethodBeat.o(76467);
    }
}
