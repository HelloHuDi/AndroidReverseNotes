package com.tencent.mm.plugin.mall.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;

public class MallWalletSectionView extends LinearLayout {
    public MallWalletSectionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(43259);
        init(context);
        AppMethodBeat.o(43259);
    }

    public MallWalletSectionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(43260);
        init(context);
        AppMethodBeat.o(43260);
    }

    private void init(Context context) {
        AppMethodBeat.i(43261);
        inflate(context, R.layout.acf, this);
        setOrientation(1);
        AppMethodBeat.o(43261);
    }
}
