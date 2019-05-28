package com.tencent.mm.plugin.topstory.ui.video.fs;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.topstory.ui.video.g;
import com.tencent.mm.protocal.protobuf.chw;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.ttpic.thread.FaceGestureDetGLThread;

public class f extends g {
    public TextView gne;
    public TextView mLM;
    public TextView mLN;
    public TextView qeX;
    public ImageView sDW;
    boolean sFT;
    View sFX;
    View sFY;
    private View sFZ;
    private View sGa;
    private ImageView sGb;
    private TextView sGc;
    private View sGd;
    View sGe;
    public View sGf;
    public View sGg;
    public TextView sGh;
    public View sGi;
    public View sGj;
    public ImageView sGk;
    public ImageView sGl;
    public View sGm;
    ap sGn;
    private a sGo;

    public interface a {
        void cHb();

        void cHc();

        void update(int i, int i2);
    }

    public f(Context context) {
        super(context);
    }

    public int getLayoutId() {
        return R.layout.b03;
    }

    public final void init() {
        AppMethodBeat.i(1926);
        super.init();
        this.sFY = this.contentView.findViewById(R.id.ewu);
        this.sFX = this.contentView.findViewById(R.id.ex9);
        this.sFZ = this.contentView.findViewById(R.id.ewt);
        this.sGa = this.contentView.findViewById(R.id.ewv);
        this.sGb = (ImageView) this.contentView.findViewById(R.id.eww);
        this.sGc = (TextView) this.contentView.findViewById(R.id.ewx);
        this.sGd = this.contentView.findViewById(R.id.ewp);
        this.sGe = this.contentView.findViewById(R.id.ex8);
        this.sGf = this.contentView.findViewById(R.id.ewy);
        this.sGg = this.contentView.findViewById(R.id.ewz);
        this.sGh = (TextView) this.contentView.findViewById(R.id.ex6);
        this.sGi = this.contentView.findViewById(R.id.ex0);
        this.sGj = this.contentView.findViewById(R.id.ex3);
        this.mLM = (TextView) this.contentView.findViewById(R.id.ex2);
        this.mLN = (TextView) this.contentView.findViewById(R.id.ex5);
        this.sGk = (ImageView) this.contentView.findViewById(R.id.ex1);
        this.sGl = (ImageView) this.contentView.findViewById(R.id.ex4);
        this.sDW = (ImageView) this.contentView.findViewById(R.id.ewr);
        this.qeX = (TextView) this.contentView.findViewById(R.id.z5);
        this.sGm = this.contentView.findViewById(R.id.ews);
        this.gne = (TextView) this.contentView.findViewById(R.id.qm);
        AppMethodBeat.o(1926);
    }

    public final void h(chw chw) {
        AppMethodBeat.i(1927);
        if ((chw.xhd & 128) > 0) {
            this.sGa.setVisibility(0);
            if (chw.xhh) {
                this.sGb.setImageResource(R.raw.top_story_wow_selected);
                this.sGc.setTextColor(getResources().getColor(R.color.a3n));
                AppMethodBeat.o(1927);
                return;
            }
            this.sGb.setImageResource(R.raw.top_story_wow_unselected);
            this.sGc.setTextColor(getResources().getColor(R.color.a69));
            AppMethodBeat.o(1927);
            return;
        }
        this.sGa.setVisibility(8);
        AppMethodBeat.o(1927);
    }

    public final void hide() {
        AppMethodBeat.i(138956);
        setVisibility(8);
        AppMethodBeat.o(138956);
    }

    public final void show() {
        AppMethodBeat.i(1929);
        setVisibility(0);
        cHf();
        if (this.sGn == null) {
            this.sGn = new ap(new com.tencent.mm.sdk.platformtools.ap.a() {
                public final boolean BI() {
                    AppMethodBeat.i(1925);
                    f.this.setVisibility(8);
                    f.this.sGn.stopTimer();
                    AppMethodBeat.o(1925);
                    return false;
                }
            }, false);
        }
        this.sGn.stopTimer();
        this.sGn.ae(FaceGestureDetGLThread.BRIGHTNESS_DURATION, FaceGestureDetGLThread.BRIGHTNESS_DURATION);
        AppMethodBeat.o(1929);
    }

    public final void cHd() {
        AppMethodBeat.i(1930);
        if (this.sGn != null) {
            this.sGn.stopTimer();
        }
        AppMethodBeat.o(1930);
    }

    public final void aFE() {
        AppMethodBeat.i(1931);
        if (this.sGn != null) {
            this.sGn.stopTimer();
            this.sGn.ae(FaceGestureDetGLThread.BRIGHTNESS_DURATION, FaceGestureDetGLThread.BRIGHTNESS_DURATION);
        }
        AppMethodBeat.o(1931);
    }

    public int getBarPointWidth() {
        AppMethodBeat.i(1932);
        int width = this.qyn.getWidth();
        AppMethodBeat.o(1932);
        return width;
    }

    public void setFullScreenBtnClickListener(OnClickListener onClickListener) {
        AppMethodBeat.i(1933);
        this.sFX.setOnClickListener(onClickListener);
        AppMethodBeat.o(1933);
    }

    public void setFeedbackBtnClickListener(OnClickListener onClickListener) {
        AppMethodBeat.i(1934);
        this.sFZ.setOnClickListener(onClickListener);
        AppMethodBeat.o(1934);
    }

    public void setShareBtnClickListener(OnClickListener onClickListener) {
        AppMethodBeat.i(1935);
        this.sFY.setOnClickListener(onClickListener);
        AppMethodBeat.o(1935);
    }

    public void setTagBtnClickListener(OnClickListener onClickListener) {
        AppMethodBeat.i(1936);
        this.sGi.setOnClickListener(onClickListener);
        this.sGj.setOnClickListener(onClickListener);
        AppMethodBeat.o(1936);
    }

    public void setWowBtnClickListener(OnClickListener onClickListener) {
        AppMethodBeat.i(1937);
        this.sGa.setVisibility(0);
        this.sGa.setOnClickListener(onClickListener);
        AppMethodBeat.o(1937);
    }

    public void setSourceItemClickListener(OnClickListener onClickListener) {
        AppMethodBeat.i(1938);
        if (this.qeX != null) {
            this.qeX.setOnClickListener(onClickListener);
        }
        if (this.sDW != null) {
            this.sDW.setOnClickListener(onClickListener);
        }
        if (this.sGm != null) {
            this.sGm.setOnClickListener(onClickListener);
        }
        AppMethodBeat.o(1938);
    }

    public void setTitleClickListener(OnClickListener onClickListener) {
        AppMethodBeat.i(1939);
        this.gne.setOnClickListener(onClickListener);
        AppMethodBeat.o(1939);
    }

    public final void cHe() {
        AppMethodBeat.i(1940);
        this.qyo.setVisibility(8);
        AppMethodBeat.o(1940);
    }

    public final void cHf() {
        AppMethodBeat.i(1941);
        this.qyo.setVisibility(0);
        AppMethodBeat.o(1941);
    }

    public final void aFQ() {
        AppMethodBeat.i(1942);
        super.aFQ();
        if (this.sGo != null) {
            this.sGo.update(this.mPosition, getVideoTotalTime());
        }
        AppMethodBeat.o(1942);
    }

    public void setOnUpdateProgressLenListener(a aVar) {
        this.sGo = aVar;
    }

    public void setVisibility(int i) {
        AppMethodBeat.i(1943);
        super.setVisibility(i);
        if (i == 8 || i == 4) {
            if (this.sGo != null) {
                this.sGo.cHc();
                AppMethodBeat.o(1943);
                return;
            }
        } else if (i == 0 && this.sGo != null) {
            this.sGo.cHb();
        }
        AppMethodBeat.o(1943);
    }

    /* Access modifiers changed, original: final */
    public final void aFL() {
        AppMethodBeat.i(1944);
        float dimensionPixelSize = (float) getResources().getDimensionPixelSize(R.dimen.a2e);
        this.qyp.setTextSize(0, dimensionPixelSize);
        this.qyq.setTextSize(0, dimensionPixelSize);
        AppMethodBeat.o(1944);
    }

    public void setOnlyFS(boolean z) {
        this.sFT = z;
    }

    public View getWowView() {
        return this.sGa;
    }
}
