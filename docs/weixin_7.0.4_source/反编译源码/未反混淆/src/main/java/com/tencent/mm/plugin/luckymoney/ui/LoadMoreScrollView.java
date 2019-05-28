package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

public class LoadMoreScrollView extends ScrollView {
    private a obU;

    public interface a {
    }

    public LoadMoreScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public LoadMoreScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* Access modifiers changed, original: protected */
    public void onOverScrolled(int i, int i2, boolean z, boolean z2) {
        AppMethodBeat.i(42558);
        ab.v("MicroMsg.LoadMoreScrollView", i + ", " + i2 + ", " + z + ", " + z2 + ", " + getScrollY());
        super.onOverScrolled(i, i2, z, z2);
        AppMethodBeat.o(42558);
    }

    public void setOnLoadMoreListener(a aVar) {
        this.obU = aVar;
    }
}
