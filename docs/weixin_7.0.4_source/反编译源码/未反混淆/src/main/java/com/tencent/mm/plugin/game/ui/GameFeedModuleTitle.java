package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.game.model.d;
import com.tencent.mm.sdk.platformtools.bo;

public class GameFeedModuleTitle extends LinearLayout {
    private TextView iDT;

    public GameFeedModuleTitle(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* Access modifiers changed, original: protected */
    public void onFinishInflate() {
        AppMethodBeat.i(111937);
        super.onFinishInflate();
        this.iDT = (TextView) findViewById(R.id.c5p);
        AppMethodBeat.o(111937);
    }

    public void setData(d dVar) {
        AppMethodBeat.i(111938);
        if (dVar == null || bo.isNullOrNil(dVar.mVG)) {
            setVisibility(8);
            AppMethodBeat.o(111938);
            return;
        }
        setVisibility(0);
        this.iDT.setText(dVar.mVG);
        AppMethodBeat.o(111938);
    }
}
