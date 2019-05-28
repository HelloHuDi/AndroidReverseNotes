package com.tencent.p177mm.wallet_core.p650ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.view.ViewGroup;
import android.widget.ScrollView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.wallet_core.p650ui.formview.EditHintPasswdView;
import com.tencent.p177mm.wallet_core.p650ui.formview.WalletFormView;

/* renamed from: com.tencent.mm.wallet_core.ui.MMScrollView */
public class MMScrollView extends ScrollView implements OnFocusChangeListener {
    private C16094b Ahk;
    private C16095a Ahl;

    /* renamed from: com.tencent.mm.wallet_core.ui.MMScrollView$b */
    public interface C16094b {
        /* renamed from: ni */
        void mo28530ni(boolean z);
    }

    /* renamed from: com.tencent.mm.wallet_core.ui.MMScrollView$a */
    public interface C16095a {
    }

    public MMScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MMScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setOnSizeChangeListener(C16094b c16094b) {
        if (c16094b != null) {
            this.Ahk = c16094b;
        }
    }

    public void setOnScrollListener(C16095a c16095a) {
        this.Ahl = c16095a;
    }

    /* renamed from: a */
    public final void mo28524a(ViewGroup viewGroup, OnFocusChangeListener onFocusChangeListener) {
        AppMethodBeat.m2504i(49223);
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            if ((childAt instanceof WalletFormView) || (childAt instanceof EditHintPasswdView)) {
                childAt.setOnFocusChangeListener(onFocusChangeListener);
            } else if (childAt instanceof ViewGroup) {
                mo28524a((ViewGroup) childAt, onFocusChangeListener);
            }
        }
        AppMethodBeat.m2505o(49223);
    }

    public void onFocusChange(final View view, boolean z) {
        AppMethodBeat.m2504i(49224);
        C4990ab.m7410d("MicroMsg.MMScrollView", "onFocusChange:".concat(String.valueOf(z)));
        if (z) {
            postDelayed(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(49222);
                    MMScrollView.this.scrollTo(0, view.getTop() - C1338a.fromDPToPix(MMScrollView.this.getContext(), 10));
                    AppMethodBeat.m2505o(49222);
                }
            }, 200);
            AppMethodBeat.m2505o(49224);
            return;
        }
        AppMethodBeat.m2505o(49224);
    }

    /* Access modifiers changed, original: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        AppMethodBeat.m2504i(49225);
        if (!(this.Ahk == null || i2 == i4)) {
            this.Ahk.mo28530ni(i2 < i4);
        }
        super.onSizeChanged(i, i2, i3, i4);
        AppMethodBeat.m2505o(49225);
    }

    /* Access modifiers changed, original: protected */
    public void onScrollChanged(int i, int i2, int i3, int i4) {
        AppMethodBeat.m2504i(49226);
        super.onScrollChanged(i, i2, i3, i4);
        AppMethodBeat.m2505o(49226);
    }
}
