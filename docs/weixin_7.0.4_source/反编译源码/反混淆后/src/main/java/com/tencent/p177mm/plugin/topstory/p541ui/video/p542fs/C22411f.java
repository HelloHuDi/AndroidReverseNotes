package com.tencent.p177mm.plugin.topstory.p541ui.video.p542fs;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.plugin.topstory.p541ui.video.C35307g;
import com.tencent.p177mm.protocal.protobuf.chw;
import com.tencent.p177mm.sdk.platformtools.C7564ap;
import com.tencent.p177mm.sdk.platformtools.C7564ap.C5015a;
import com.tencent.ttpic.thread.FaceGestureDetGLThread;

/* renamed from: com.tencent.mm.plugin.topstory.ui.video.fs.f */
public class C22411f extends C35307g {
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
    C7564ap sGn;
    private C4238a sGo;

    /* renamed from: com.tencent.mm.plugin.topstory.ui.video.fs.f$a */
    public interface C4238a {
        void cHb();

        void cHc();

        void update(int i, int i2);
    }

    /* renamed from: com.tencent.mm.plugin.topstory.ui.video.fs.f$1 */
    class C224121 implements C5015a {
        C224121() {
        }

        /* renamed from: BI */
        public final boolean mo4499BI() {
            AppMethodBeat.m2504i(1925);
            C22411f.this.setVisibility(8);
            C22411f.this.sGn.stopTimer();
            AppMethodBeat.m2505o(1925);
            return false;
        }
    }

    public C22411f(Context context) {
        super(context);
    }

    public int getLayoutId() {
        return 2130970942;
    }

    public final void init() {
        AppMethodBeat.m2504i(1926);
        super.init();
        this.sFY = this.contentView.findViewById(2131828270);
        this.sFX = this.contentView.findViewById(2131828285);
        this.sFZ = this.contentView.findViewById(2131828269);
        this.sGa = this.contentView.findViewById(2131828271);
        this.sGb = (ImageView) this.contentView.findViewById(2131828272);
        this.sGc = (TextView) this.contentView.findViewById(2131828273);
        this.sGd = this.contentView.findViewById(2131828265);
        this.sGe = this.contentView.findViewById(2131828284);
        this.sGf = this.contentView.findViewById(2131828274);
        this.sGg = this.contentView.findViewById(2131828275);
        this.sGh = (TextView) this.contentView.findViewById(2131828282);
        this.sGi = this.contentView.findViewById(2131828276);
        this.sGj = this.contentView.findViewById(2131828279);
        this.mLM = (TextView) this.contentView.findViewById(2131828278);
        this.mLN = (TextView) this.contentView.findViewById(2131828281);
        this.sGk = (ImageView) this.contentView.findViewById(2131828277);
        this.sGl = (ImageView) this.contentView.findViewById(2131828280);
        this.sDW = (ImageView) this.contentView.findViewById(2131828267);
        this.qeX = (TextView) this.contentView.findViewById(2131821512);
        this.sGm = this.contentView.findViewById(2131828268);
        this.gne = (TextView) this.contentView.findViewById(2131821185);
        AppMethodBeat.m2505o(1926);
    }

    /* renamed from: h */
    public final void mo37955h(chw chw) {
        AppMethodBeat.m2504i(1927);
        if ((chw.xhd & 128) > 0) {
            this.sGa.setVisibility(0);
            if (chw.xhh) {
                this.sGb.setImageResource(C1318a.top_story_wow_selected);
                this.sGc.setTextColor(getResources().getColor(C25738R.color.a3n));
                AppMethodBeat.m2505o(1927);
                return;
            }
            this.sGb.setImageResource(C1318a.top_story_wow_unselected);
            this.sGc.setTextColor(getResources().getColor(C25738R.color.a69));
            AppMethodBeat.m2505o(1927);
            return;
        }
        this.sGa.setVisibility(8);
        AppMethodBeat.m2505o(1927);
    }

    public final void hide() {
        AppMethodBeat.m2504i(138956);
        setVisibility(8);
        AppMethodBeat.m2505o(138956);
    }

    public final void show() {
        AppMethodBeat.m2504i(1929);
        setVisibility(0);
        cHf();
        if (this.sGn == null) {
            this.sGn = new C7564ap(new C224121(), false);
        }
        this.sGn.stopTimer();
        this.sGn.mo16770ae(FaceGestureDetGLThread.BRIGHTNESS_DURATION, FaceGestureDetGLThread.BRIGHTNESS_DURATION);
        AppMethodBeat.m2505o(1929);
    }

    public final void cHd() {
        AppMethodBeat.m2504i(1930);
        if (this.sGn != null) {
            this.sGn.stopTimer();
        }
        AppMethodBeat.m2505o(1930);
    }

    public final void aFE() {
        AppMethodBeat.m2504i(1931);
        if (this.sGn != null) {
            this.sGn.stopTimer();
            this.sGn.mo16770ae(FaceGestureDetGLThread.BRIGHTNESS_DURATION, FaceGestureDetGLThread.BRIGHTNESS_DURATION);
        }
        AppMethodBeat.m2505o(1931);
    }

    public int getBarPointWidth() {
        AppMethodBeat.m2504i(1932);
        int width = this.qyn.getWidth();
        AppMethodBeat.m2505o(1932);
        return width;
    }

    public void setFullScreenBtnClickListener(OnClickListener onClickListener) {
        AppMethodBeat.m2504i(1933);
        this.sFX.setOnClickListener(onClickListener);
        AppMethodBeat.m2505o(1933);
    }

    public void setFeedbackBtnClickListener(OnClickListener onClickListener) {
        AppMethodBeat.m2504i(1934);
        this.sFZ.setOnClickListener(onClickListener);
        AppMethodBeat.m2505o(1934);
    }

    public void setShareBtnClickListener(OnClickListener onClickListener) {
        AppMethodBeat.m2504i(1935);
        this.sFY.setOnClickListener(onClickListener);
        AppMethodBeat.m2505o(1935);
    }

    public void setTagBtnClickListener(OnClickListener onClickListener) {
        AppMethodBeat.m2504i(1936);
        this.sGi.setOnClickListener(onClickListener);
        this.sGj.setOnClickListener(onClickListener);
        AppMethodBeat.m2505o(1936);
    }

    public void setWowBtnClickListener(OnClickListener onClickListener) {
        AppMethodBeat.m2504i(1937);
        this.sGa.setVisibility(0);
        this.sGa.setOnClickListener(onClickListener);
        AppMethodBeat.m2505o(1937);
    }

    public void setSourceItemClickListener(OnClickListener onClickListener) {
        AppMethodBeat.m2504i(1938);
        if (this.qeX != null) {
            this.qeX.setOnClickListener(onClickListener);
        }
        if (this.sDW != null) {
            this.sDW.setOnClickListener(onClickListener);
        }
        if (this.sGm != null) {
            this.sGm.setOnClickListener(onClickListener);
        }
        AppMethodBeat.m2505o(1938);
    }

    public void setTitleClickListener(OnClickListener onClickListener) {
        AppMethodBeat.m2504i(1939);
        this.gne.setOnClickListener(onClickListener);
        AppMethodBeat.m2505o(1939);
    }

    public final void cHe() {
        AppMethodBeat.m2504i(1940);
        this.qyo.setVisibility(8);
        AppMethodBeat.m2505o(1940);
    }

    public final void cHf() {
        AppMethodBeat.m2504i(1941);
        this.qyo.setVisibility(0);
        AppMethodBeat.m2505o(1941);
    }

    public final void aFQ() {
        AppMethodBeat.m2504i(1942);
        super.aFQ();
        if (this.sGo != null) {
            this.sGo.update(this.mPosition, getVideoTotalTime());
        }
        AppMethodBeat.m2505o(1942);
    }

    public void setOnUpdateProgressLenListener(C4238a c4238a) {
        this.sGo = c4238a;
    }

    public void setVisibility(int i) {
        AppMethodBeat.m2504i(1943);
        super.setVisibility(i);
        if (i == 8 || i == 4) {
            if (this.sGo != null) {
                this.sGo.cHc();
                AppMethodBeat.m2505o(1943);
                return;
            }
        } else if (i == 0 && this.sGo != null) {
            this.sGo.cHb();
        }
        AppMethodBeat.m2505o(1943);
    }

    /* Access modifiers changed, original: final */
    public final void aFL() {
        AppMethodBeat.m2504i(1944);
        float dimensionPixelSize = (float) getResources().getDimensionPixelSize(C25738R.dimen.a2e);
        this.qyp.setTextSize(0, dimensionPixelSize);
        this.qyq.setTextSize(0, dimensionPixelSize);
        AppMethodBeat.m2505o(1944);
    }

    public void setOnlyFS(boolean z) {
        this.sFT = z;
    }

    public View getWowView() {
        return this.sGa;
    }
}
