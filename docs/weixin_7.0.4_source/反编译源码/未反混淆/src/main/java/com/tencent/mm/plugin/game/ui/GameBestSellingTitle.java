package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.bo;

public class GameBestSellingTitle extends LinearLayout {
    public GameBestSellingTitle(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void setText(String str) {
        AppMethodBeat.i(111735);
        if (bo.isNullOrNil(str)) {
            setVisibility(8);
            AppMethodBeat.o(111735);
            return;
        }
        setVisibility(0);
        ((TextView) findViewById(R.id.c0j)).setText(str);
        AppMethodBeat.o(111735);
    }
}
