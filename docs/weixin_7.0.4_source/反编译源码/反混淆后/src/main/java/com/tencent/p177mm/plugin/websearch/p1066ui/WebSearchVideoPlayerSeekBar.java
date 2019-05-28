package com.tencent.p177mm.plugin.websearch.p1066ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLayoutChangeListener;
import android.view.View.OnTouchListener;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.sight.decode.p512ui.AdVideoPlayerLoadingBar;
import com.tencent.p177mm.pluginsdk.p597ui.C30135g;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.ttpic.util.VideoMaterialUtil;

/* renamed from: com.tencent.mm.plugin.websearch.ui.WebSearchVideoPlayerSeekBar */
public class WebSearchVideoPlayerSeekBar extends AdVideoPlayerLoadingBar implements C30135g {
    protected boolean cAW = false;
    private float hke;
    private int uck = -1;
    private int ucl = -1;
    private int ucm = -1;

    /* renamed from: com.tencent.mm.plugin.websearch.ui.WebSearchVideoPlayerSeekBar$1 */
    class C227621 implements OnTouchListener {
        C227621() {
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            AppMethodBeat.m2504i(73814);
            int g;
            if (motionEvent.getAction() == 0) {
                C4990ab.m7416i("MicroMsg.WebSearch.WebSearchVideoPlayerSeekBar", "ontouch down");
                WebSearchVideoPlayerSeekBar.this.hOy = false;
                WebSearchVideoPlayerSeekBar.this.hke = motionEvent.getX();
                WebSearchVideoPlayerSeekBar.this.qyu = (float) ((LayoutParams) WebSearchVideoPlayerSeekBar.this.qyn.getLayoutParams()).leftMargin;
                if (WebSearchVideoPlayerSeekBar.this.qyk != null) {
                    WebSearchVideoPlayerSeekBar.this.qyk.aFw();
                }
            } else if (motionEvent.getAction() == 2) {
                C4990ab.m7417i("MicroMsg.WebSearch.WebSearchVideoPlayerSeekBar", "move dis %f ", Float.valueOf(motionEvent.getX() - WebSearchVideoPlayerSeekBar.this.hke));
                WebSearchVideoPlayerSeekBar.this.mo41766In((int) ((r0 - WebSearchVideoPlayerSeekBar.this.hke) + ((float) WebSearchVideoPlayerSeekBar.m38931f(WebSearchVideoPlayerSeekBar.this))));
                g = WebSearchVideoPlayerSeekBar.m38932g(WebSearchVideoPlayerSeekBar.this);
                WebSearchVideoPlayerSeekBar.this.qyp.setText(AdVideoPlayerLoadingBar.m33392oy(g / 60) + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + AdVideoPlayerLoadingBar.m33392oy(g % 60));
                WebSearchVideoPlayerSeekBar.this.hOy = true;
                WebSearchVideoPlayerSeekBar.cVK();
            } else {
                C4990ab.m7416i("MicroMsg.WebSearch.WebSearchVideoPlayerSeekBar", "ontouch up");
                g = WebSearchVideoPlayerSeekBar.this.mPosition;
                if (WebSearchVideoPlayerSeekBar.this.hOy) {
                    g = WebSearchVideoPlayerSeekBar.this.mPosition = WebSearchVideoPlayerSeekBar.m38932g(WebSearchVideoPlayerSeekBar.this);
                }
                if (WebSearchVideoPlayerSeekBar.this.qyk != null) {
                    C4990ab.m7416i("MicroMsg.WebSearch.WebSearchVideoPlayerSeekBar", "current time : ".concat(String.valueOf(g)));
                    WebSearchVideoPlayerSeekBar.this.qyk.mo8552oA(g);
                }
                WebSearchVideoPlayerSeekBar.this.hOy = false;
            }
            AppMethodBeat.m2505o(73814);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.websearch.ui.WebSearchVideoPlayerSeekBar$2 */
    class C249032 implements OnLayoutChangeListener {
        C249032() {
        }

        public final void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            AppMethodBeat.m2504i(73815);
            if (i3 - i != i7 - i5) {
                WebSearchVideoPlayerSeekBar.this.aFQ();
            }
            AppMethodBeat.m2505o(73815);
        }
    }

    /* renamed from: com.tencent.mm.plugin.websearch.ui.WebSearchVideoPlayerSeekBar$3 */
    class C249043 implements OnLayoutChangeListener {
        C249043() {
        }

        public final void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            AppMethodBeat.m2504i(73816);
            if (i3 - i != i7 - i5) {
                WebSearchVideoPlayerSeekBar.this.aFQ();
            }
            AppMethodBeat.m2505o(73816);
        }
    }

    static /* synthetic */ void cVK() {
    }

    /* renamed from: f */
    static /* synthetic */ int m38931f(WebSearchVideoPlayerSeekBar webSearchVideoPlayerSeekBar) {
        AppMethodBeat.m2504i(73834);
        int curProgressBarLen = webSearchVideoPlayerSeekBar.getCurProgressBarLen();
        AppMethodBeat.m2505o(73834);
        return curProgressBarLen;
    }

    /* renamed from: g */
    static /* synthetic */ int m38932g(WebSearchVideoPlayerSeekBar webSearchVideoPlayerSeekBar) {
        AppMethodBeat.m2504i(73835);
        int curTimeByProgressBar = webSearchVideoPlayerSeekBar.getCurTimeByProgressBar();
        AppMethodBeat.m2505o(73835);
        return curTimeByProgressBar;
    }

    public WebSearchVideoPlayerSeekBar(Context context) {
        super(context);
    }

    public WebSearchVideoPlayerSeekBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public WebSearchVideoPlayerSeekBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void init() {
        AppMethodBeat.m2504i(73817);
        this.contentView = View.inflate(getContext(), getLayoutId(), this);
        this.qyl = (ImageView) this.contentView.findViewById(2131821425);
        this.qym = (ImageView) this.contentView.findViewById(2131821423);
        this.qyn = (ImageView) this.contentView.findViewById(2131821426);
        this.qyo = (ImageView) this.contentView.findViewById(2131821279);
        this.qyp = (TextView) this.contentView.findViewById(2131821421);
        this.qyq = (TextView) this.contentView.findViewById(2131821427);
        this.qyn.setOnTouchListener(new C227621());
        this.qyn.addOnLayoutChangeListener(new C249032());
        this.qym.addOnLayoutChangeListener(new C249043());
        AppMethodBeat.m2505o(73817);
    }

    private int getCurTimeByProgressBar() {
        AppMethodBeat.m2504i(73818);
        int curProgressBarLen = (int) (((((double) getCurProgressBarLen()) * 1.0d) / ((double) getBarLen())) * ((double) this.qyr));
        AppMethodBeat.m2505o(73818);
        return curProgressBarLen;
    }

    private int getCurProgressBarLen() {
        AppMethodBeat.m2504i(73819);
        int width = this.qyl.getWidth();
        AppMethodBeat.m2505o(73819);
        return width;
    }

    public int getBarPointWidth() {
        AppMethodBeat.m2504i(73820);
        if (this.uck == -1) {
            this.uck = this.qyn.getWidth();
        }
        int i = this.uck;
        AppMethodBeat.m2505o(73820);
        return i;
    }

    private int getBarPointPaddingLeft() {
        AppMethodBeat.m2504i(73821);
        if (this.ucl == -1) {
            this.ucl = this.qyn.getPaddingLeft();
        }
        int i = this.ucl;
        AppMethodBeat.m2505o(73821);
        return i;
    }

    private int getBarPointPaddingRight() {
        AppMethodBeat.m2504i(73822);
        if (this.ucm == -1) {
            this.ucm = this.qyn.getPaddingRight();
        }
        int i = this.ucm;
        AppMethodBeat.m2505o(73822);
        return i;
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: Im */
    public final int mo41765Im(int i) {
        AppMethodBeat.m2504i(73823);
        int barLen;
        if (i <= 0) {
            AppMethodBeat.m2505o(73823);
            return 0;
        } else if (i >= this.qyr) {
            barLen = getBarLen();
            AppMethodBeat.m2505o(73823);
            return barLen;
        } else {
            barLen = (int) (((((double) i) * 1.0d) / ((double) this.qyr)) * ((double) getBarLen()));
            AppMethodBeat.m2505o(73823);
            return barLen;
        }
    }

    public int getBarLen() {
        AppMethodBeat.m2504i(73824);
        int width = this.qym.getWidth();
        AppMethodBeat.m2505o(73824);
        return width;
    }

    public int getLayoutId() {
        return 2130970991;
    }

    public ImageView getPlayBtn() {
        return this.qyo;
    }

    public TextView getPlaytimeTv() {
        return this.qyp;
    }

    public final void seek(int i) {
        AppMethodBeat.m2504i(73825);
        C4990ab.m7410d("MicroMsg.WebSearch.WebSearchVideoPlayerSeekBar", "seek position : ".concat(String.valueOf(i)));
        if (i < 0) {
            i = 0;
        }
        if (i >= this.qyr) {
            i = this.qyr;
        }
        if (this.mPosition != i) {
            this.mPosition = i;
            aFQ();
        }
        AppMethodBeat.m2505o(73825);
    }

    public void setVideoTotalTime(int i) {
        AppMethodBeat.m2504i(73826);
        this.qyr = i;
        this.mPosition = 0;
        this.qyq.setText(AdVideoPlayerLoadingBar.m33392oy(this.qyr / 60) + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + AdVideoPlayerLoadingBar.m33392oy(this.qyr % 60));
        aFQ();
        AppMethodBeat.m2505o(73826);
    }

    public void aFQ() {
        AppMethodBeat.m2504i(73827);
        if (this.qyr == 0) {
            AppMethodBeat.m2505o(73827);
        } else if (this.hOy) {
            AppMethodBeat.m2505o(73827);
        } else if (this.qyn == null) {
            AppMethodBeat.m2505o(73827);
        } else if (getBarLen() == 0) {
            AppMethodBeat.m2505o(73827);
        } else {
            if (this.mPosition == this.qyr) {
                C4990ab.m7416i("MicroMsg.WebSearch.WebSearchVideoPlayerSeekBar", "test");
            }
            this.qyp.setText(AdVideoPlayerLoadingBar.m33392oy(this.mPosition / 60) + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + AdVideoPlayerLoadingBar.m33392oy(this.mPosition % 60));
            mo41766In(mo41765Im(this.mPosition));
            AppMethodBeat.m2505o(73827);
        }
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: In */
    public final void mo41766In(int i) {
        AppMethodBeat.m2504i(73828);
        if (i > getBarLen()) {
            i = getBarLen();
        } else if (i < 0) {
            i = 0;
        }
        LayoutParams layoutParams = (LayoutParams) this.qyn.getLayoutParams();
        layoutParams.leftMargin = m38922Io(i);
        this.qyn.setLayoutParams(layoutParams);
        layoutParams = (LayoutParams) this.qyl.getLayoutParams();
        layoutParams.width = i;
        this.qyl.setLayoutParams(layoutParams);
        this.qyn.requestLayout();
        this.qyl.requestLayout();
        AppMethodBeat.m2505o(73828);
    }

    /* renamed from: Io */
    private int m38922Io(int i) {
        AppMethodBeat.m2504i(73829);
        if (i > getBarLen()) {
            i = getBarLen();
        }
        int barPointWidth = (((LayoutParams) this.qym.getLayoutParams()).leftMargin + i) - (getBarPointWidth() >>> 1);
        AppMethodBeat.m2505o(73829);
        return barPointWidth;
    }

    public void setPlayBtnOnClickListener(OnClickListener onClickListener) {
        AppMethodBeat.m2504i(73830);
        if (this.qyo != null) {
            this.qyo.setOnClickListener(onClickListener);
        }
        AppMethodBeat.m2505o(73830);
    }

    public void setIsPlay(boolean z) {
        AppMethodBeat.m2504i(73831);
        this.cAW = z;
        super.setIsPlay(z);
        AppMethodBeat.m2505o(73831);
    }

    /* renamed from: Dq */
    public void mo27328Dq(int i) {
        AppMethodBeat.m2504i(73832);
        seek(i);
        AppMethodBeat.m2505o(73832);
    }

    /* renamed from: nF */
    public final void mo27337nF(boolean z) {
        AppMethodBeat.m2504i(73833);
        setIsPlay(z);
        AppMethodBeat.m2505o(73833);
    }
}
