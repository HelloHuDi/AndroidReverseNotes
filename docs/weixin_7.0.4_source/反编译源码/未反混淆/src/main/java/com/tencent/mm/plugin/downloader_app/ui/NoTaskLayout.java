package com.tencent.mm.plugin.downloader_app.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.downloader.c.a.a.f;

public class NoTaskLayout extends RelativeLayout {
    private BottomEntranceView kQq;

    public NoTaskLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* Access modifiers changed, original: protected */
    public void onFinishInflate() {
        AppMethodBeat.i(136253);
        super.onFinishInflate();
        this.kQq = (BottomEntranceView) findViewById(R.id.di6);
        AppMethodBeat.o(136253);
    }

    public void setData(f fVar) {
        AppMethodBeat.i(136254);
        this.kQq.setData(fVar);
        AppMethodBeat.o(136254);
    }
}
