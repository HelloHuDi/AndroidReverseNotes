package com.tencent.p177mm.plugin.account.bind.p271ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.plugin.account.bind.ui.AutoBottomScrollView */
public class AutoBottomScrollView extends ScrollView {

    /* renamed from: com.tencent.mm.plugin.account.bind.ui.AutoBottomScrollView$1 */
    class C98271 implements Runnable {
        C98271() {
        }

        public final void run() {
            AppMethodBeat.m2504i(13330);
            AutoBottomScrollView.this.smoothScrollTo(0, AutoBottomScrollView.this.getBottom());
            AppMethodBeat.m2505o(13330);
        }
    }

    public AutoBottomScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public AutoBottomScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* Access modifiers changed, original: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        AppMethodBeat.m2504i(13331);
        super.onSizeChanged(i, i2, i3, i4);
        postDelayed(new C98271(), 100);
        AppMethodBeat.m2505o(13331);
    }
}
