package com.tencent.p177mm.p612ui.conversation;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.AbsListView.LayoutParams;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.ui.conversation.EnterpriseFullHeightListView */
public class EnterpriseFullHeightListView extends ListView {
    private int itemHeight = 0;
    public boolean zuw = true;
    private View zux;

    public EnterpriseFullHeightListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public EnterpriseFullHeightListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* Access modifiers changed, original: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        int i5 = 0;
        AppMethodBeat.m2504i(34459);
        super.onSizeChanged(i, i2, i3, i4);
        if (this.zuw) {
            AppMethodBeat.m2505o(34459);
            return;
        }
        try {
            if (!this.zuw) {
                int headerViewsCount = getHeaderViewsCount();
                int count = getAdapter().getCount();
                if (this.zux != null) {
                    count--;
                }
                while (headerViewsCount < count) {
                    if (this.itemHeight <= 0) {
                        try {
                            View view = getAdapter().getView(headerViewsCount, null, this);
                            view.measure(MeasureSpec.makeMeasureSpec(0, 0), MeasureSpec.makeMeasureSpec(0, 0));
                            this.itemHeight = view.getMeasuredHeight();
                        } catch (Exception e) {
                        }
                    }
                    i5 += this.itemHeight;
                    if (i5 > i2) {
                        if (this.zux != null) {
                            removeFooterView(this.zux);
                            this.zux = null;
                        }
                        AppMethodBeat.m2505o(34459);
                        return;
                    }
                    headerViewsCount++;
                }
                if (i5 < i2) {
                    if (this.zux == null) {
                        this.zux = new View(getContext());
                    }
                    removeFooterView(this.zux);
                    this.zux.setLayoutParams(new LayoutParams(-1, i2 - i5));
                    addFooterView(this.zux, null, false);
                }
            }
            AppMethodBeat.m2505o(34459);
        } catch (Exception e2) {
            AppMethodBeat.m2505o(34459);
        }
    }
}
