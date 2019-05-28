package com.tencent.mm.plugin.websearch.ui;

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
import com.tencent.mm.R;
import com.tencent.mm.plugin.sight.decode.ui.AdVideoPlayerLoadingBar;
import com.tencent.mm.pluginsdk.ui.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.ttpic.util.VideoMaterialUtil;

public class WebSearchVideoPlayerSeekBar extends AdVideoPlayerLoadingBar implements g {
    protected boolean cAW = false;
    private float hke;
    private int uck = -1;
    private int ucl = -1;
    private int ucm = -1;

    static /* synthetic */ void cVK() {
    }

    static /* synthetic */ int f(WebSearchVideoPlayerSeekBar webSearchVideoPlayerSeekBar) {
        AppMethodBeat.i(73834);
        int curProgressBarLen = webSearchVideoPlayerSeekBar.getCurProgressBarLen();
        AppMethodBeat.o(73834);
        return curProgressBarLen;
    }

    static /* synthetic */ int g(WebSearchVideoPlayerSeekBar webSearchVideoPlayerSeekBar) {
        AppMethodBeat.i(73835);
        int curTimeByProgressBar = webSearchVideoPlayerSeekBar.getCurTimeByProgressBar();
        AppMethodBeat.o(73835);
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
        AppMethodBeat.i(73817);
        this.contentView = View.inflate(getContext(), getLayoutId(), this);
        this.qyl = (ImageView) this.contentView.findViewById(R.id.x4);
        this.qym = (ImageView) this.contentView.findViewById(R.id.x2);
        this.qyn = (ImageView) this.contentView.findViewById(R.id.x5);
        this.qyo = (ImageView) this.contentView.findViewById(R.id.t6);
        this.qyp = (TextView) this.contentView.findViewById(R.id.x0);
        this.qyq = (TextView) this.contentView.findViewById(R.id.x6);
        this.qyn.setOnTouchListener(new OnTouchListener() {
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(73814);
                int g;
                if (motionEvent.getAction() == 0) {
                    ab.i("MicroMsg.WebSearch.WebSearchVideoPlayerSeekBar", "ontouch down");
                    WebSearchVideoPlayerSeekBar.this.hOy = false;
                    WebSearchVideoPlayerSeekBar.this.hke = motionEvent.getX();
                    WebSearchVideoPlayerSeekBar.this.qyu = (float) ((LayoutParams) WebSearchVideoPlayerSeekBar.this.qyn.getLayoutParams()).leftMargin;
                    if (WebSearchVideoPlayerSeekBar.this.qyk != null) {
                        WebSearchVideoPlayerSeekBar.this.qyk.aFw();
                    }
                } else if (motionEvent.getAction() == 2) {
                    ab.i("MicroMsg.WebSearch.WebSearchVideoPlayerSeekBar", "move dis %f ", Float.valueOf(motionEvent.getX() - WebSearchVideoPlayerSeekBar.this.hke));
                    WebSearchVideoPlayerSeekBar.this.In((int) ((r0 - WebSearchVideoPlayerSeekBar.this.hke) + ((float) WebSearchVideoPlayerSeekBar.f(WebSearchVideoPlayerSeekBar.this))));
                    g = WebSearchVideoPlayerSeekBar.g(WebSearchVideoPlayerSeekBar.this);
                    WebSearchVideoPlayerSeekBar.this.qyp.setText(AdVideoPlayerLoadingBar.oy(g / 60) + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + AdVideoPlayerLoadingBar.oy(g % 60));
                    WebSearchVideoPlayerSeekBar.this.hOy = true;
                    WebSearchVideoPlayerSeekBar.cVK();
                } else {
                    ab.i("MicroMsg.WebSearch.WebSearchVideoPlayerSeekBar", "ontouch up");
                    g = WebSearchVideoPlayerSeekBar.this.mPosition;
                    if (WebSearchVideoPlayerSeekBar.this.hOy) {
                        g = WebSearchVideoPlayerSeekBar.this.mPosition = WebSearchVideoPlayerSeekBar.g(WebSearchVideoPlayerSeekBar.this);
                    }
                    if (WebSearchVideoPlayerSeekBar.this.qyk != null) {
                        ab.i("MicroMsg.WebSearch.WebSearchVideoPlayerSeekBar", "current time : ".concat(String.valueOf(g)));
                        WebSearchVideoPlayerSeekBar.this.qyk.oA(g);
                    }
                    WebSearchVideoPlayerSeekBar.this.hOy = false;
                }
                AppMethodBeat.o(73814);
                return true;
            }
        });
        this.qyn.addOnLayoutChangeListener(new OnLayoutChangeListener() {
            public final void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                AppMethodBeat.i(73815);
                if (i3 - i != i7 - i5) {
                    WebSearchVideoPlayerSeekBar.this.aFQ();
                }
                AppMethodBeat.o(73815);
            }
        });
        this.qym.addOnLayoutChangeListener(new OnLayoutChangeListener() {
            public final void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                AppMethodBeat.i(73816);
                if (i3 - i != i7 - i5) {
                    WebSearchVideoPlayerSeekBar.this.aFQ();
                }
                AppMethodBeat.o(73816);
            }
        });
        AppMethodBeat.o(73817);
    }

    private int getCurTimeByProgressBar() {
        AppMethodBeat.i(73818);
        int curProgressBarLen = (int) (((((double) getCurProgressBarLen()) * 1.0d) / ((double) getBarLen())) * ((double) this.qyr));
        AppMethodBeat.o(73818);
        return curProgressBarLen;
    }

    private int getCurProgressBarLen() {
        AppMethodBeat.i(73819);
        int width = this.qyl.getWidth();
        AppMethodBeat.o(73819);
        return width;
    }

    public int getBarPointWidth() {
        AppMethodBeat.i(73820);
        if (this.uck == -1) {
            this.uck = this.qyn.getWidth();
        }
        int i = this.uck;
        AppMethodBeat.o(73820);
        return i;
    }

    private int getBarPointPaddingLeft() {
        AppMethodBeat.i(73821);
        if (this.ucl == -1) {
            this.ucl = this.qyn.getPaddingLeft();
        }
        int i = this.ucl;
        AppMethodBeat.o(73821);
        return i;
    }

    private int getBarPointPaddingRight() {
        AppMethodBeat.i(73822);
        if (this.ucm == -1) {
            this.ucm = this.qyn.getPaddingRight();
        }
        int i = this.ucm;
        AppMethodBeat.o(73822);
        return i;
    }

    /* Access modifiers changed, original: protected|final */
    public final int Im(int i) {
        AppMethodBeat.i(73823);
        int barLen;
        if (i <= 0) {
            AppMethodBeat.o(73823);
            return 0;
        } else if (i >= this.qyr) {
            barLen = getBarLen();
            AppMethodBeat.o(73823);
            return barLen;
        } else {
            barLen = (int) (((((double) i) * 1.0d) / ((double) this.qyr)) * ((double) getBarLen()));
            AppMethodBeat.o(73823);
            return barLen;
        }
    }

    public int getBarLen() {
        AppMethodBeat.i(73824);
        int width = this.qym.getWidth();
        AppMethodBeat.o(73824);
        return width;
    }

    public int getLayoutId() {
        return R.layout.b1e;
    }

    public ImageView getPlayBtn() {
        return this.qyo;
    }

    public TextView getPlaytimeTv() {
        return this.qyp;
    }

    public final void seek(int i) {
        AppMethodBeat.i(73825);
        ab.d("MicroMsg.WebSearch.WebSearchVideoPlayerSeekBar", "seek position : ".concat(String.valueOf(i)));
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
        AppMethodBeat.o(73825);
    }

    public void setVideoTotalTime(int i) {
        AppMethodBeat.i(73826);
        this.qyr = i;
        this.mPosition = 0;
        this.qyq.setText(AdVideoPlayerLoadingBar.oy(this.qyr / 60) + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + AdVideoPlayerLoadingBar.oy(this.qyr % 60));
        aFQ();
        AppMethodBeat.o(73826);
    }

    public void aFQ() {
        AppMethodBeat.i(73827);
        if (this.qyr == 0) {
            AppMethodBeat.o(73827);
        } else if (this.hOy) {
            AppMethodBeat.o(73827);
        } else if (this.qyn == null) {
            AppMethodBeat.o(73827);
        } else if (getBarLen() == 0) {
            AppMethodBeat.o(73827);
        } else {
            if (this.mPosition == this.qyr) {
                ab.i("MicroMsg.WebSearch.WebSearchVideoPlayerSeekBar", "test");
            }
            this.qyp.setText(AdVideoPlayerLoadingBar.oy(this.mPosition / 60) + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + AdVideoPlayerLoadingBar.oy(this.mPosition % 60));
            In(Im(this.mPosition));
            AppMethodBeat.o(73827);
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final void In(int i) {
        AppMethodBeat.i(73828);
        if (i > getBarLen()) {
            i = getBarLen();
        } else if (i < 0) {
            i = 0;
        }
        LayoutParams layoutParams = (LayoutParams) this.qyn.getLayoutParams();
        layoutParams.leftMargin = Io(i);
        this.qyn.setLayoutParams(layoutParams);
        layoutParams = (LayoutParams) this.qyl.getLayoutParams();
        layoutParams.width = i;
        this.qyl.setLayoutParams(layoutParams);
        this.qyn.requestLayout();
        this.qyl.requestLayout();
        AppMethodBeat.o(73828);
    }

    private int Io(int i) {
        AppMethodBeat.i(73829);
        if (i > getBarLen()) {
            i = getBarLen();
        }
        int barPointWidth = (((LayoutParams) this.qym.getLayoutParams()).leftMargin + i) - (getBarPointWidth() >>> 1);
        AppMethodBeat.o(73829);
        return barPointWidth;
    }

    public void setPlayBtnOnClickListener(OnClickListener onClickListener) {
        AppMethodBeat.i(73830);
        if (this.qyo != null) {
            this.qyo.setOnClickListener(onClickListener);
        }
        AppMethodBeat.o(73830);
    }

    public void setIsPlay(boolean z) {
        AppMethodBeat.i(73831);
        this.cAW = z;
        super.setIsPlay(z);
        AppMethodBeat.o(73831);
    }

    public void Dq(int i) {
        AppMethodBeat.i(73832);
        seek(i);
        AppMethodBeat.o(73832);
    }

    public final void nF(boolean z) {
        AppMethodBeat.i(73833);
        setIsPlay(z);
        AppMethodBeat.o(73833);
    }
}
