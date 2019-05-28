package com.tencent.p177mm.plugin.address.p276ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.view.ViewGroup;
import android.widget.ScrollView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.address.ui.MMScrollView */
public class MMScrollView extends ScrollView implements OnFocusChangeListener {
    private C26704a gKw;

    /* renamed from: com.tencent.mm.plugin.address.ui.MMScrollView$a */
    public interface C26704a {
    }

    public MMScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MMScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setOnSizeChangeListener(C26704a c26704a) {
        if (c26704a != null) {
            this.gKw = c26704a;
        }
    }

    /* Access modifiers changed, original: final */
    /* renamed from: a */
    public final void mo67850a(ViewGroup viewGroup, OnFocusChangeListener onFocusChangeListener) {
        AppMethodBeat.m2504i(16909);
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt instanceof AddrEditView) {
                childAt.setOnFocusChangeListener(onFocusChangeListener);
            } else if (childAt instanceof ViewGroup) {
                mo67850a((ViewGroup) childAt, onFocusChangeListener);
            }
        }
        AppMethodBeat.m2505o(16909);
    }

    public void onFocusChange(final View view, boolean z) {
        AppMethodBeat.m2504i(16910);
        C4990ab.m7410d("MicroMsg.MMScrollView", "onFocusChange:".concat(String.valueOf(z)));
        if (z) {
            postDelayed(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(16908);
                    MMScrollView.this.scrollTo(0, view.getTop() - C1338a.fromDPToPix(MMScrollView.this.getContext(), 10));
                    AppMethodBeat.m2505o(16908);
                }
            }, 200);
            AppMethodBeat.m2505o(16910);
            return;
        }
        AppMethodBeat.m2505o(16910);
    }

    /* Access modifiers changed, original: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        AppMethodBeat.m2504i(16911);
        super.onSizeChanged(i, i2, i3, i4);
        AppMethodBeat.m2505o(16911);
    }
}
