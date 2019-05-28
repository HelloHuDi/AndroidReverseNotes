package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.y;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.mm.ui.widget.MMWebView.a;

public final class p extends h {
    MMWebView fow;
    FrameLayout raJ;

    public p(Context context, y yVar, ViewGroup viewGroup) {
        super(context, yVar, viewGroup);
    }

    /* Access modifiers changed, original: protected|final */
    public final void cpp() {
        AppMethodBeat.i(37192);
        this.fow.setVerticalScrollBarEnabled(false);
        this.fow.setHorizontalScrollBarEnabled(false);
        this.fow.getSettings().setJavaScriptEnabled(true);
        this.fow.loadUrl(((y) this.qZo).nmz);
        this.fow.setLayoutParams(new LayoutParams(-1, -1));
        this.fow.setVisibility(0);
        this.raJ.setPadding(this.raJ.getPaddingLeft(), (int) ((y) this.qZo).qWQ, this.raJ.getPaddingRight(), (int) ((y) this.qZo).qWR);
        this.raJ.setLayoutParams(new LinearLayout.LayoutParams(this.ieu, this.iev));
        AppMethodBeat.o(37192);
    }

    public final void cpk() {
        AppMethodBeat.i(37193);
        this.raJ = (FrameLayout) this.contentView;
        this.fow = a.in(this.context);
        this.raJ.addView(this.fow);
        AppMethodBeat.o(37193);
    }

    /* Access modifiers changed, original: protected|final */
    public final int getLayout() {
        return BaseClientBuilder.API_PRIORITY_OTHER;
    }

    /* Access modifiers changed, original: protected|final */
    public final View cpr() {
        AppMethodBeat.i(37194);
        FrameLayout frameLayout = new FrameLayout(this.context);
        AppMethodBeat.o(37194);
        return frameLayout;
    }
}
