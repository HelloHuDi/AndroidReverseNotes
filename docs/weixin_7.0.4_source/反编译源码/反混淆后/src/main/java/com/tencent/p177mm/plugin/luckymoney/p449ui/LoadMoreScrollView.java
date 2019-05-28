package com.tencent.p177mm.plugin.luckymoney.p449ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.luckymoney.ui.LoadMoreScrollView */
public class LoadMoreScrollView extends ScrollView {
    private C34459a obU;

    /* renamed from: com.tencent.mm.plugin.luckymoney.ui.LoadMoreScrollView$a */
    public interface C34459a {
    }

    public LoadMoreScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public LoadMoreScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* Access modifiers changed, original: protected */
    public void onOverScrolled(int i, int i2, boolean z, boolean z2) {
        AppMethodBeat.m2504i(42558);
        C4990ab.m7418v("MicroMsg.LoadMoreScrollView", i + ", " + i2 + ", " + z + ", " + z2 + ", " + getScrollY());
        super.onOverScrolled(i, i2, z, z2);
        AppMethodBeat.m2505o(42558);
    }

    public void setOnLoadMoreListener(C34459a c34459a) {
        this.obU = c34459a;
    }
}
