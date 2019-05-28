package com.tencent.p177mm.p612ui.base;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.ui.base.CustomScrollView */
public class CustomScrollView extends ScrollView {
    private C40664a yso;

    /* renamed from: com.tencent.mm.ui.base.CustomScrollView$a */
    public interface C40664a {
        /* renamed from: a */
        void mo25553a(ScrollView scrollView, int i, int i2);
    }

    public CustomScrollView(Context context) {
        super(context);
    }

    public CustomScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public CustomScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setOnScrollChangeListener(C40664a c40664a) {
        this.yso = c40664a;
    }

    /* Access modifiers changed, original: protected */
    public void onScrollChanged(int i, int i2, int i3, int i4) {
        AppMethodBeat.m2504i(112504);
        super.onScrollChanged(i, i2, i3, i4);
        if (this.yso != null) {
            this.yso.mo25553a(this, i2, i4);
        }
        AppMethodBeat.m2505o(112504);
    }
}
