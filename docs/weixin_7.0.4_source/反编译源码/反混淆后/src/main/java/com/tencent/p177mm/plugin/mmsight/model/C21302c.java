package com.tencent.p177mm.plugin.mmsight.model;

import android.content.Context;
import android.view.OrientationEventListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import com.tencent.ttpic.thread.FaceGestureDetGLThread;

/* renamed from: com.tencent.mm.plugin.mmsight.model.c */
public final class C21302c extends OrientationEventListener {
    private int orientation = -1;
    private int otG = -1;
    private int otH = -1;
    private long otI = 0;
    private long otJ = 0;
    public C21303a otK;

    /* renamed from: com.tencent.mm.plugin.mmsight.model.c$a */
    public interface C21303a {
        /* renamed from: yR */
        void mo30796yR(int i);
    }

    public C21302c(Context context) {
        super(context, 2);
    }

    public final void onOrientationChanged(int i) {
        AppMethodBeat.m2504i(76464);
        if (!C12563j.ouw) {
            AppMethodBeat.m2505o(76464);
        } else if (C5046bo.m7525az(this.otJ) < FaceGestureDetGLThread.BRIGHTNESS_DURATION) {
            C4990ab.m7418v("MicroMsg.DeviceOrientationListener", "onOrientationChanged, not reach DETECT_THRESHOLD");
            AppMethodBeat.m2505o(76464);
        } else {
            if (Math.abs(this.otG - i) >= 30 || C5046bo.m7525az(this.otI) >= 300) {
                this.otG = i;
                this.otI = C5046bo.m7588yz();
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
                    this.otK.mo30796yR(this.orientation);
                }
            }
            AppMethodBeat.m2505o(76464);
        }
    }

    public final void enable() {
        AppMethodBeat.m2504i(76465);
        C4990ab.m7417i("MicroMsg.DeviceOrientationListener", "enable, config isEnableLandscapeMode: %s", Boolean.valueOf(C12563j.ouw));
        if (C12563j.ouw) {
            super.enable();
            this.otJ = C5046bo.m7588yz();
        }
        AppMethodBeat.m2505o(76465);
    }

    public final int getOrientation() {
        if (C12563j.ouw) {
            return this.orientation;
        }
        return 0;
    }

    public final boolean isLandscape() {
        AppMethodBeat.m2504i(76466);
        if (C12563j.ouw) {
            C4990ab.m7417i("MicroMsg.DeviceOrientationListener", "isLandscape, tickToNow: %s, orientation: %s", Long.valueOf(C5046bo.m7525az(this.otJ)), Integer.valueOf(this.orientation));
            if (C5046bo.m7525az(this.otJ) < FaceGestureDetGLThread.BRIGHTNESS_DURATION) {
                AppMethodBeat.m2505o(76466);
                return false;
            } else if (this.orientation < 0) {
                AppMethodBeat.m2505o(76466);
                return false;
            } else if (this.orientation == 90 || this.orientation == 270) {
                AppMethodBeat.m2505o(76466);
                return true;
            } else {
                AppMethodBeat.m2505o(76466);
                return false;
            }
        }
        AppMethodBeat.m2505o(76466);
        return false;
    }

    public final void reset() {
        AppMethodBeat.m2504i(76467);
        C4990ab.m7416i("MicroMsg.DeviceOrientationListener", "reset");
        this.otH = -1;
        this.orientation = -1;
        this.otG = -1;
        AppMethodBeat.m2505o(76467);
    }
}
