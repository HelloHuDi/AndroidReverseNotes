package com.tencent.p177mm.plugin.topstory.p541ui.video;

import android.content.Context;
import android.view.OrientationEventListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import com.tencent.ttpic.thread.FaceGestureDetGLThread;

/* renamed from: com.tencent.mm.plugin.topstory.ui.video.i */
public final class C35308i extends OrientationEventListener {
    private int orientation = -1;
    private int otG = -1;
    private int otH = -1;
    private long otI = 0;
    private long otJ = 0;
    C35309a sEB;

    /* renamed from: com.tencent.mm.plugin.topstory.ui.video.i$a */
    public interface C35309a {
        /* renamed from: yR */
        void mo9152yR(int i);
    }

    public C35308i(Context context) {
        super(context);
    }

    public final void onOrientationChanged(int i) {
        AppMethodBeat.m2504i(1730);
        if (C5046bo.m7525az(this.otJ) < FaceGestureDetGLThread.BRIGHTNESS_DURATION) {
            C4990ab.m7418v("MicroMsg.TopStory.TopStoryDeviceOrientationListener", "onOrientationChanged, not reach DETECT_THRESHOLD");
            AppMethodBeat.m2505o(1730);
            return;
        }
        C4990ab.m7411d("MicroMsg.TopStory.TopStoryDeviceOrientationListener", "onOrientationChanged: %s", Integer.valueOf(i));
        if (Math.abs(this.otG - i) >= 60 && C5046bo.m7525az(this.otI) >= 1000) {
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
            if (this.sEB != null) {
                this.sEB.mo9152yR(this.orientation);
            }
        }
        AppMethodBeat.m2505o(1730);
    }

    public final void enable() {
        AppMethodBeat.m2504i(1731);
        super.enable();
        this.otJ = C5046bo.m7588yz();
        AppMethodBeat.m2505o(1731);
    }
}
