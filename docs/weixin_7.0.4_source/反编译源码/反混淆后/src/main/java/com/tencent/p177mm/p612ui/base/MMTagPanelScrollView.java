package com.tencent.p177mm.p612ui.base;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.ScrollView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.ui.base.MMTagPanelScrollView */
public class MMTagPanelScrollView extends ScrollView {
    private int eTj = 0;
    private Runnable yxO = new C52651();
    private C36062a yxP = new C36062a();
    private int yxQ = 2;

    /* renamed from: com.tencent.mm.ui.base.MMTagPanelScrollView$1 */
    class C52651 implements Runnable {
        C52651() {
        }

        public final void run() {
            AppMethodBeat.m2504i(106856);
            MMTagPanelScrollView.this.scrollTo(0, MMTagPanelScrollView.this.getBottom());
            AppMethodBeat.m2505o(106856);
        }
    }

    /* renamed from: com.tencent.mm.ui.base.MMTagPanelScrollView$a */
    static class C36062a implements Runnable {
        public MMTagPanel yxS;

        private C36062a() {
        }

        /* synthetic */ C36062a(byte b) {
            this();
        }

        public final void run() {
            AppMethodBeat.m2504i(106857);
            if (this.yxS != null) {
                this.yxS.dAc();
            }
            this.yxS = null;
            AppMethodBeat.m2505o(106857);
        }
    }

    public MMTagPanelScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(106858);
        AppMethodBeat.m2505o(106858);
    }

    public MMTagPanelScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(106859);
        AppMethodBeat.m2505o(106859);
    }

    public void setMaxLine(int i) {
        if (i <= 0) {
            i = 1;
        }
        this.yxQ = i;
    }

    /* Access modifiers changed, original: protected */
    public void onMeasure(int i, int i2) {
        AppMethodBeat.m2504i(106860);
        super.onMeasure(i, i2);
        if (getChildCount() <= 0) {
            AppMethodBeat.m2505o(106860);
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
                this.eTj = mMTagPanel.getMeasuredHeight() + getResources().getDimensionPixelOffset(C25738R.dimen.f10015nh);
            }
            if (mMTagPanel.getLineCount() >= this.yxQ) {
                int size = MeasureSpec.getSize(i);
                int max = Math.max(0, Math.min(mMTagPanel.ysy.size(), this.yxQ));
                int paddingTop = mMTagPanel.getPaddingTop();
                for (int i4 = 0; i4 < max - 1; i4++) {
                    paddingTop += ((Integer) mMTagPanel.ysy.get(i4)).intValue() + mMTagPanel.ysx;
                }
                C4990ab.m7411d("MicroMsg.FavTagPanelScrollView", "height %d", Integer.valueOf(Math.max((((Integer) mMTagPanel.ysy.get(max - 1)).intValue() + paddingTop) + mMTagPanel.getPaddingBottom(), this.eTj)));
                setMeasuredDimension(size, r1);
                if (i32 != 0) {
                    this.yxP.yxS = mMTagPanel;
                    removeCallbacks(this.yxP);
                    post(this.yxP);
                }
            }
        }
        AppMethodBeat.m2505o(106860);
    }

    /* Access modifiers changed, original: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        AppMethodBeat.m2504i(106861);
        super.onLayout(z, i, i2, i3, i4);
        scrollBy(0, i4);
        AppMethodBeat.m2505o(106861);
    }
}
