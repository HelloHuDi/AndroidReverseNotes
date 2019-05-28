package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Scroller;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;

public class GameCenterListView extends ListView {
    static boolean nfG;
    static int nfI;
    private View abB;
    private Context mContext;
    private Scroller mScroller;
    private boolean nfC;
    private float nfD;
    private int nfE;
    private boolean nfF;
    private boolean nfH;
    private ImageView nfJ;
    private ImageView nfK;

    public GameCenterListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
    }

    /* Access modifiers changed, original: protected */
    public void onFinishInflate() {
        AppMethodBeat.i(111777);
        super.onFinishInflate();
        this.nfE = ViewConfiguration.get(this.mContext).getScaledTouchSlop();
        this.mScroller = new Scroller(this.mContext);
        super.setOnScrollListener(new OnScrollListener() {
            public final void onScrollStateChanged(AbsListView absListView, int i) {
            }

            public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
                AppMethodBeat.i(111776);
                if (i == 0 && GameCenterListView.this.abB != null && GameCenterListView.this.abB.getTop() == 0) {
                    GameCenterListView.this.nfF = true;
                    AppMethodBeat.o(111776);
                    return;
                }
                GameCenterListView.this.nfF = false;
                AppMethodBeat.o(111776);
            }
        });
        AppMethodBeat.o(111777);
    }

    public static void setCanPulldown(boolean z) {
        nfG = z;
    }

    public static void setDefaultPadding(int i) {
        nfI = i;
    }

    /* Access modifiers changed, original: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        AppMethodBeat.i(111778);
        super.onLayout(z, i, i2, i3, i4);
        if (z && !this.nfC) {
            this.abB = getChildAt(0);
            this.nfK = (ImageView) this.abB.findViewById(R.id.c6v);
            this.nfJ = (ImageView) this.abB.findViewById(R.id.c5j);
            this.nfC = true;
        }
        AppMethodBeat.o(111778);
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(111779);
        boolean dispatchTouchEvent;
        if (!nfG || this.abB == null) {
            dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
            AppMethodBeat.o(111779);
            return dispatchTouchEvent;
        }
        switch (motionEvent.getAction()) {
            case 0:
                this.nfH = false;
                this.nfD = motionEvent.getRawY();
                break;
            case 2:
                if (this.nfF) {
                    if (this.nfH) {
                        AppMethodBeat.o(111779);
                        return true;
                    }
                    int rawY = (int) (motionEvent.getRawY() - this.nfD);
                    if (this.abB.getPaddingTop() <= nfI + this.nfE) {
                        if (rawY > 0 && Math.abs(rawY) >= this.nfE) {
                            this.nfH = true;
                            this.mScroller.startScroll(0, this.abB.getPaddingTop(), 0, -this.abB.getPaddingTop(), 500);
                            this.nfJ.setClickable(true);
                            invalidate();
                            motionEvent.setAction(3);
                            super.dispatchTouchEvent(motionEvent);
                            AppMethodBeat.o(111779);
                            return true;
                        }
                    } else if (this.abB.getPaddingTop() >= (-this.nfE) && rawY < 0 && Math.abs(rawY) >= this.nfE) {
                        this.nfH = true;
                        this.mScroller.startScroll(0, 0, 0, nfI, 500);
                        invalidate();
                        motionEvent.setAction(3);
                        super.dispatchTouchEvent(motionEvent);
                        AppMethodBeat.o(111779);
                        return true;
                    }
                }
                break;
        }
        dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        AppMethodBeat.o(111779);
        return dispatchTouchEvent;
    }

    public void computeScroll() {
        AppMethodBeat.i(111780);
        if (this.abB == null) {
            AppMethodBeat.o(111780);
            return;
        }
        if (this.mScroller.computeScrollOffset()) {
            int currY = this.mScroller.getCurrY();
            this.abB.setPadding(0, currY, 0, 0);
            float f = (((float) (nfI - currY)) / ((float) nfI)) * 255.0f;
            int i = 255 - ((int) f);
            currY = (int) f;
            this.nfK.setAlpha(i);
            this.nfJ.setAlpha(currY);
            invalidate();
        }
        AppMethodBeat.o(111780);
    }
}
