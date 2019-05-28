package com.tencent.p177mm.plugin.account.p275ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ScrollView;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.plugin.account.ui.MMKeyboardUperView */
public class MMKeyboardUperView extends ScrollView {
    private int defaultHeight = -1;
    private View gDh;
    private Runnable gDi = new C422931();
    private Runnable gDj = new C422942();

    /* renamed from: com.tencent.mm.plugin.account.ui.MMKeyboardUperView$1 */
    class C422931 implements Runnable {
        C422931() {
        }

        public final void run() {
            AppMethodBeat.m2504i(125077);
            MMKeyboardUperView.this.fullScroll(130);
            MMKeyboardUperView.this.gDh.setVisibility(4);
            AppMethodBeat.m2505o(125077);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.MMKeyboardUperView$2 */
    class C422942 implements Runnable {
        C422942() {
        }

        public final void run() {
            AppMethodBeat.m2504i(125078);
            MMKeyboardUperView.this.gDh.setVisibility(0);
            AppMethodBeat.m2505o(125078);
        }
    }

    public MMKeyboardUperView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(125079);
        AppMethodBeat.m2505o(125079);
    }

    public MMKeyboardUperView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(125080);
        AppMethodBeat.m2505o(125080);
    }

    public void setupUperView(View view) {
        this.gDh = view;
        this.defaultHeight = -1;
    }
}
