package com.tencent.mm.plugin.topstory.ui.video.list;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.ttpic.thread.FaceGestureDetGLThread;

public final class g extends com.tencent.mm.plugin.topstory.ui.video.g {
    private View sFX = this.contentView.findViewById(R.id.ex9);
    private a sGX;
    ap sGn;

    public interface a {
        void cHb();

        void cHc();

        void update(int i, int i2);
    }

    public g(Context context) {
        super(context);
        AppMethodBeat.i(2076);
        AppMethodBeat.o(2076);
    }

    public final void setFullScreenBtnClickListener(OnClickListener onClickListener) {
        AppMethodBeat.i(2077);
        this.sFX.setOnClickListener(onClickListener);
        AppMethodBeat.o(2077);
    }

    public final void hide() {
        AppMethodBeat.i(138958);
        setVisibility(8);
        AppMethodBeat.o(138958);
    }

    public final void show() {
        AppMethodBeat.i(2079);
        setVisibility(0);
        cHf();
        if (this.sGn == null) {
            this.sGn = new ap(new com.tencent.mm.sdk.platformtools.ap.a() {
                public final boolean BI() {
                    AppMethodBeat.i(2075);
                    g.this.setVisibility(8);
                    g.this.sGn.stopTimer();
                    AppMethodBeat.o(2075);
                    return false;
                }
            }, false);
        }
        this.sGn.stopTimer();
        this.sGn.ae(FaceGestureDetGLThread.BRIGHTNESS_DURATION, FaceGestureDetGLThread.BRIGHTNESS_DURATION);
        AppMethodBeat.o(2079);
    }

    public final void cHd() {
        AppMethodBeat.i(2080);
        if (this.sGn != null) {
            this.sGn.stopTimer();
        }
        AppMethodBeat.o(2080);
    }

    public final void aFE() {
        AppMethodBeat.i(2081);
        if (this.sGn != null) {
            this.sGn.stopTimer();
            this.sGn.ae(FaceGestureDetGLThread.BRIGHTNESS_DURATION, FaceGestureDetGLThread.BRIGHTNESS_DURATION);
        }
        AppMethodBeat.o(2081);
    }

    public final int getBarPointWidth() {
        AppMethodBeat.i(2082);
        int width = this.qyn.getWidth();
        AppMethodBeat.o(2082);
        return width;
    }

    public final void cHe() {
        AppMethodBeat.i(2083);
        this.qyo.setVisibility(8);
        AppMethodBeat.o(2083);
    }

    public final void cHf() {
        AppMethodBeat.i(2084);
        this.qyo.setVisibility(0);
        AppMethodBeat.o(2084);
    }

    public final int getLayoutId() {
        return R.layout.b0f;
    }

    public final void setVisibility(int i) {
        AppMethodBeat.i(2085);
        super.setVisibility(i);
        if (i == 8 || i == 4) {
            if (this.sGX != null) {
                this.sGX.cHc();
                AppMethodBeat.o(2085);
                return;
            }
        } else if (i == 0 && this.sGX != null) {
            this.sGX.cHb();
        }
        AppMethodBeat.o(2085);
    }

    public final void aFQ() {
        AppMethodBeat.i(2086);
        super.aFQ();
        if (this.sGX != null) {
            this.sGX.update(this.mPosition, getVideoTotalTime());
        }
        AppMethodBeat.o(2086);
    }

    public final void setOnUpdateProgressLenListener(a aVar) {
        this.sGX = aVar;
    }
}
