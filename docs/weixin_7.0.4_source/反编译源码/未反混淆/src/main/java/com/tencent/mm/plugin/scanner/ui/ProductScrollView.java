package com.tencent.mm.plugin.scanner.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class ProductScrollView extends ScrollView {
    private a qcT;

    public interface a {
        void bpT();
    }

    public ProductScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ProductScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setOnScrollListener(a aVar) {
        this.qcT = aVar;
    }

    /* Access modifiers changed, original: protected */
    public void onScrollChanged(int i, int i2, int i3, int i4) {
        AppMethodBeat.i(81077);
        super.onScrollChanged(i, i2, i3, i4);
        if (this.qcT != null) {
            this.qcT.bpT();
        }
        AppMethodBeat.o(81077);
    }
}
