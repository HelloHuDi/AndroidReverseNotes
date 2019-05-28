package com.tencent.p177mm.plugin.topstory.p541ui.video.list;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.topstory.p541ui.video.C35307g;
import com.tencent.p177mm.sdk.platformtools.C7564ap;
import com.tencent.p177mm.sdk.platformtools.C7564ap.C5015a;
import com.tencent.ttpic.thread.FaceGestureDetGLThread;

/* renamed from: com.tencent.mm.plugin.topstory.ui.video.list.g */
public final class C39989g extends C35307g {
    private View sFX = this.contentView.findViewById(2131828285);
    private C39990a sGX;
    C7564ap sGn;

    /* renamed from: com.tencent.mm.plugin.topstory.ui.video.list.g$1 */
    class C294591 implements C5015a {
        C294591() {
        }

        /* renamed from: BI */
        public final boolean mo4499BI() {
            AppMethodBeat.m2504i(2075);
            C39989g.this.setVisibility(8);
            C39989g.this.sGn.stopTimer();
            AppMethodBeat.m2505o(2075);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.topstory.ui.video.list.g$a */
    public interface C39990a {
        void cHb();

        void cHc();

        void update(int i, int i2);
    }

    public C39989g(Context context) {
        super(context);
        AppMethodBeat.m2504i(2076);
        AppMethodBeat.m2505o(2076);
    }

    public final void setFullScreenBtnClickListener(OnClickListener onClickListener) {
        AppMethodBeat.m2504i(2077);
        this.sFX.setOnClickListener(onClickListener);
        AppMethodBeat.m2505o(2077);
    }

    public final void hide() {
        AppMethodBeat.m2504i(138958);
        setVisibility(8);
        AppMethodBeat.m2505o(138958);
    }

    public final void show() {
        AppMethodBeat.m2504i(2079);
        setVisibility(0);
        cHf();
        if (this.sGn == null) {
            this.sGn = new C7564ap(new C294591(), false);
        }
        this.sGn.stopTimer();
        this.sGn.mo16770ae(FaceGestureDetGLThread.BRIGHTNESS_DURATION, FaceGestureDetGLThread.BRIGHTNESS_DURATION);
        AppMethodBeat.m2505o(2079);
    }

    public final void cHd() {
        AppMethodBeat.m2504i(2080);
        if (this.sGn != null) {
            this.sGn.stopTimer();
        }
        AppMethodBeat.m2505o(2080);
    }

    public final void aFE() {
        AppMethodBeat.m2504i(2081);
        if (this.sGn != null) {
            this.sGn.stopTimer();
            this.sGn.mo16770ae(FaceGestureDetGLThread.BRIGHTNESS_DURATION, FaceGestureDetGLThread.BRIGHTNESS_DURATION);
        }
        AppMethodBeat.m2505o(2081);
    }

    public final int getBarPointWidth() {
        AppMethodBeat.m2504i(2082);
        int width = this.qyn.getWidth();
        AppMethodBeat.m2505o(2082);
        return width;
    }

    public final void cHe() {
        AppMethodBeat.m2504i(2083);
        this.qyo.setVisibility(8);
        AppMethodBeat.m2505o(2083);
    }

    public final void cHf() {
        AppMethodBeat.m2504i(2084);
        this.qyo.setVisibility(0);
        AppMethodBeat.m2505o(2084);
    }

    public final int getLayoutId() {
        return 2130970955;
    }

    public final void setVisibility(int i) {
        AppMethodBeat.m2504i(2085);
        super.setVisibility(i);
        if (i == 8 || i == 4) {
            if (this.sGX != null) {
                this.sGX.cHc();
                AppMethodBeat.m2505o(2085);
                return;
            }
        } else if (i == 0 && this.sGX != null) {
            this.sGX.cHb();
        }
        AppMethodBeat.m2505o(2085);
    }

    public final void aFQ() {
        AppMethodBeat.m2504i(2086);
        super.aFQ();
        if (this.sGX != null) {
            this.sGX.update(this.mPosition, getVideoTotalTime());
        }
        AppMethodBeat.m2505o(2086);
    }

    public final void setOnUpdateProgressLenListener(C39990a c39990a) {
        this.sGX = c39990a;
    }
}
