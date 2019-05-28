package com.tencent.p177mm.plugin.mall.p451ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.plugin.mall.ui.MallWalletSectionView */
public class MallWalletSectionView extends LinearLayout {
    public MallWalletSectionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(43259);
        init(context);
        AppMethodBeat.m2505o(43259);
    }

    public MallWalletSectionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(43260);
        init(context);
        AppMethodBeat.m2505o(43260);
    }

    private void init(Context context) {
        AppMethodBeat.m2504i(43261);
        MallWalletSectionView.inflate(context, 2130970065, this);
        setOrientation(1);
        AppMethodBeat.m2505o(43261);
    }
}
