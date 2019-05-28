package com.tencent.mm.ui.base;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.ScrollView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.ab;

public class MMTagPanelScrollView extends ScrollView {
    private int eTj = 0;
    private Runnable yxO = new Runnable() {
        public final void run() {
            AppMethodBeat.i(106856);
            MMTagPanelScrollView.this.scrollTo(0, MMTagPanelScrollView.this.getBottom());
            AppMethodBeat.o(106856);
        }
    };
    private a yxP = new a();
    private int yxQ = 2;

    static class a implements Runnable {
        public MMTagPanel yxS;

        private a() {
        }

        /* synthetic */ a(byte b) {
            this();
        }

        public final void run() {
            AppMethodBeat.i(106857);
            if (this.yxS != null) {
                this.yxS.dAc();
            }
            this.yxS = null;
            AppMethodBeat.o(106857);
        }
    }

    public MMTagPanelScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(106858);
        AppMethodBeat.o(106858);
    }

    public MMTagPanelScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(106859);
        AppMethodBeat.o(106859);
    }

    public void setMaxLine(int i) {
        if (i <= 0) {
            i = 1;
        }
        this.yxQ = i;
    }

    /* Access modifiers changed, original: protected */
    public void onMeasure(int i, int i2) {
        AppMethodBeat.i(106860);
        super.onMeasure(i, i2);
        if (getChildCount() <= 0) {
            AppMethodBeat.o(106860);
            return;
        }
        if (getChildAt(0) instanceof MMTagPanel) {
            int i3;
            MMTagPanel mMTagPanel = (MMTagPanel) getChildAt(0);
            if (mMTagPanel.yxz == null) {
                i3 = 0;
            } else {
                boolean i32 = mMTagPanel.yxz.isFocused();
            }
            if (mMTagPanel.getLineCount() == this.yxQ) {
                this.eTj = mMTagPanel.getMeasuredHeight() + getResources().getDimensionPixelOffset(R.dimen.nh);
            }
            if (mMTagPanel.getLineCount() >= this.yxQ) {
                int size = MeasureSpec.getSize(i);
                int max = Math.max(0, Math.min(mMTagPanel.ysy.size(), this.yxQ));
                int paddingTop = mMTagPanel.getPaddingTop();
                for (int i4 = 0; i4 < max - 1; i4++) {
                    paddingTop += ((Integer) mMTagPanel.ysy.get(i4)).intValue() + mMTagPanel.ysx;
                }
                ab.d("MicroMsg.FavTagPanelScrollView", "height %d", Integer.valueOf(Math.max((((Integer) mMTagPanel.ysy.get(max - 1)).intValue() + paddingTop) + mMTagPanel.getPaddingBottom(), this.eTj)));
                setMeasuredDimension(size, r1);
                if (i32 != 0) {
                    this.yxP.yxS = mMTagPanel;
                    removeCallbacks(this.yxP);
                    post(this.yxP);
                }
            }
        }
        AppMethodBeat.o(106860);
    }

    /* Access modifiers changed, original: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        AppMethodBeat.i(106861);
        super.onLayout(z, i, i2, i3, i4);
        scrollBy(0, i4);
        AppMethodBeat.o(106861);
    }
}
