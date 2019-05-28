package com.tencent.p177mm.p612ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.ui.widget.MMLoadScrollView */
public class MMLoadScrollView extends ScrollView {
    private C36354a zMq;

    /* renamed from: com.tencent.mm.ui.widget.MMLoadScrollView$a */
    public interface C36354a {
        void bmh();
    }

    public MMLoadScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public MMLoadScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* Access modifiers changed, original: protected */
    public void onOverScrolled(int i, int i2, boolean z, boolean z2) {
        AppMethodBeat.m2504i(107884);
        if (z2 && i2 > 0 && this.zMq != null) {
            this.zMq.bmh();
        }
        super.onOverScrolled(i, i2, z, z2);
        AppMethodBeat.m2505o(107884);
    }

    public void setOnTopOrBottomListerner(C36354a c36354a) {
        this.zMq = c36354a;
    }
}
