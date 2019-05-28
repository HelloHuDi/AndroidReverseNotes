package com.tencent.mm.wallet_core.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.view.ViewGroup;
import android.widget.ScrollView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;

public class MMScrollView extends ScrollView implements OnFocusChangeListener {
    private b Ahk;
    private a Ahl;

    public interface b {
        void ni(boolean z);
    }

    public interface a {
    }

    public MMScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MMScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setOnSizeChangeListener(b bVar) {
        if (bVar != null) {
            this.Ahk = bVar;
        }
    }

    public void setOnScrollListener(a aVar) {
        this.Ahl = aVar;
    }

    public final void a(ViewGroup viewGroup, OnFocusChangeListener onFocusChangeListener) {
        AppMethodBeat.i(49223);
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            if ((childAt instanceof WalletFormView) || (childAt instanceof EditHintPasswdView)) {
                childAt.setOnFocusChangeListener(onFocusChangeListener);
            } else if (childAt instanceof ViewGroup) {
                a((ViewGroup) childAt, onFocusChangeListener);
            }
        }
        AppMethodBeat.o(49223);
    }

    public void onFocusChange(final View view, boolean z) {
        AppMethodBeat.i(49224);
        ab.d("MicroMsg.MMScrollView", "onFocusChange:".concat(String.valueOf(z)));
        if (z) {
            postDelayed(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(49222);
                    MMScrollView.this.scrollTo(0, view.getTop() - com.tencent.mm.bz.a.fromDPToPix(MMScrollView.this.getContext(), 10));
                    AppMethodBeat.o(49222);
                }
            }, 200);
            AppMethodBeat.o(49224);
            return;
        }
        AppMethodBeat.o(49224);
    }

    /* Access modifiers changed, original: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        AppMethodBeat.i(49225);
        if (!(this.Ahk == null || i2 == i4)) {
            this.Ahk.ni(i2 < i4);
        }
        super.onSizeChanged(i, i2, i3, i4);
        AppMethodBeat.o(49225);
    }

    /* Access modifiers changed, original: protected */
    public void onScrollChanged(int i, int i2, int i3, int i4) {
        AppMethodBeat.i(49226);
        super.onScrollChanged(i, i2, i3, i4);
        AppMethodBeat.o(49226);
    }
}
