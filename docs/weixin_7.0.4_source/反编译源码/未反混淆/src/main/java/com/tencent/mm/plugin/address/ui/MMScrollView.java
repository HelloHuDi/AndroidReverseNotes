package com.tencent.mm.plugin.address.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.view.ViewGroup;
import android.widget.ScrollView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

public class MMScrollView extends ScrollView implements OnFocusChangeListener {
    private a gKw;

    public interface a {
    }

    public MMScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MMScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setOnSizeChangeListener(a aVar) {
        if (aVar != null) {
            this.gKw = aVar;
        }
    }

    /* Access modifiers changed, original: final */
    public final void a(ViewGroup viewGroup, OnFocusChangeListener onFocusChangeListener) {
        AppMethodBeat.i(16909);
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt instanceof AddrEditView) {
                childAt.setOnFocusChangeListener(onFocusChangeListener);
            } else if (childAt instanceof ViewGroup) {
                a((ViewGroup) childAt, onFocusChangeListener);
            }
        }
        AppMethodBeat.o(16909);
    }

    public void onFocusChange(final View view, boolean z) {
        AppMethodBeat.i(16910);
        ab.d("MicroMsg.MMScrollView", "onFocusChange:".concat(String.valueOf(z)));
        if (z) {
            postDelayed(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(16908);
                    MMScrollView.this.scrollTo(0, view.getTop() - com.tencent.mm.bz.a.fromDPToPix(MMScrollView.this.getContext(), 10));
                    AppMethodBeat.o(16908);
                }
            }, 200);
            AppMethodBeat.o(16910);
            return;
        }
        AppMethodBeat.o(16910);
    }

    /* Access modifiers changed, original: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        AppMethodBeat.i(16911);
        super.onSizeChanged(i, i2, i3, i4);
        AppMethodBeat.o(16911);
    }
}
