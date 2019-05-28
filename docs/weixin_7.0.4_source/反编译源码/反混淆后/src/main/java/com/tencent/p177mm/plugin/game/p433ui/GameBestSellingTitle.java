package com.tencent.p177mm.plugin.game.p433ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.game.ui.GameBestSellingTitle */
public class GameBestSellingTitle extends LinearLayout {
    public GameBestSellingTitle(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void setText(String str) {
        AppMethodBeat.m2504i(111735);
        if (C5046bo.isNullOrNil(str)) {
            setVisibility(8);
            AppMethodBeat.m2505o(111735);
            return;
        }
        setVisibility(0);
        ((TextView) findViewById(2131824301)).setText(str);
        AppMethodBeat.m2505o(111735);
    }
}
