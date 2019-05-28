package com.tencent.p177mm.plugin.downloader_app.p380ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.downloader.p723c.p941a.p942a.C27701f;

/* renamed from: com.tencent.mm.plugin.downloader_app.ui.NoTaskLayout */
public class NoTaskLayout extends RelativeLayout {
    private BottomEntranceView kQq;

    public NoTaskLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* Access modifiers changed, original: protected */
    public void onFinishInflate() {
        AppMethodBeat.m2504i(136253);
        super.onFinishInflate();
        this.kQq = (BottomEntranceView) findViewById(2131826358);
        AppMethodBeat.m2505o(136253);
    }

    public void setData(C27701f c27701f) {
        AppMethodBeat.m2504i(136254);
        this.kQq.setData(c27701f);
        AppMethodBeat.m2505o(136254);
    }
}
