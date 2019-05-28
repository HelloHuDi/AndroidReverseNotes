package com.tencent.p177mm.plugin.scanner.p504ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.plugin.scanner.ui.ProductScrollView */
public class ProductScrollView extends ScrollView {
    private C13135a qcT;

    /* renamed from: com.tencent.mm.plugin.scanner.ui.ProductScrollView$a */
    public interface C13135a {
        void bpT();
    }

    public ProductScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ProductScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setOnScrollListener(C13135a c13135a) {
        this.qcT = c13135a;
    }

    /* Access modifiers changed, original: protected */
    public void onScrollChanged(int i, int i2, int i3, int i4) {
        AppMethodBeat.m2504i(81077);
        super.onScrollChanged(i, i2, i3, i4);
        if (this.qcT != null) {
            this.qcT.bpT();
        }
        AppMethodBeat.m2505o(81077);
    }
}
