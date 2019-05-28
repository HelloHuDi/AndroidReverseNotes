package com.tencent.p177mm.plugin.game.p433ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.game.model.C28226d;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.game.ui.GameFeedModuleTitle */
public class GameFeedModuleTitle extends LinearLayout {
    private TextView iDT;

    public GameFeedModuleTitle(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* Access modifiers changed, original: protected */
    public void onFinishInflate() {
        AppMethodBeat.m2504i(111937);
        super.onFinishInflate();
        this.iDT = (TextView) findViewById(2131824492);
        AppMethodBeat.m2505o(111937);
    }

    public void setData(C28226d c28226d) {
        AppMethodBeat.m2504i(111938);
        if (c28226d == null || C5046bo.isNullOrNil(c28226d.mVG)) {
            setVisibility(8);
            AppMethodBeat.m2505o(111938);
            return;
        }
        setVisibility(0);
        this.iDT.setText(c28226d.mVG);
        AppMethodBeat.m2505o(111938);
    }
}
