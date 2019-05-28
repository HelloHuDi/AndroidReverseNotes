package com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.widget.MMWebView;
import com.tencent.p177mm.p612ui.widget.MMWebView.C30798a;
import com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.C13472y;

/* renamed from: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.p */
public final class C34982p extends C13437h {
    MMWebView fow;
    FrameLayout raJ;

    public C34982p(Context context, C13472y c13472y, ViewGroup viewGroup) {
        super(context, c13472y, viewGroup);
    }

    /* Access modifiers changed, original: protected|final */
    public final void cpp() {
        AppMethodBeat.m2504i(37192);
        this.fow.setVerticalScrollBarEnabled(false);
        this.fow.setHorizontalScrollBarEnabled(false);
        this.fow.getSettings().setJavaScriptEnabled(true);
        this.fow.loadUrl(((C13472y) this.qZo).nmz);
        this.fow.setLayoutParams(new LayoutParams(-1, -1));
        this.fow.setVisibility(0);
        this.raJ.setPadding(this.raJ.getPaddingLeft(), (int) ((C13472y) this.qZo).qWQ, this.raJ.getPaddingRight(), (int) ((C13472y) this.qZo).qWR);
        this.raJ.setLayoutParams(new LinearLayout.LayoutParams(this.ieu, this.iev));
        AppMethodBeat.m2505o(37192);
    }

    public final void cpk() {
        AppMethodBeat.m2504i(37193);
        this.raJ = (FrameLayout) this.contentView;
        this.fow = C30798a.m49145in(this.context);
        this.raJ.addView(this.fow);
        AppMethodBeat.m2505o(37193);
    }

    /* Access modifiers changed, original: protected|final */
    public final int getLayout() {
        return BaseClientBuilder.API_PRIORITY_OTHER;
    }

    /* Access modifiers changed, original: protected|final */
    public final View cpr() {
        AppMethodBeat.m2504i(37194);
        FrameLayout frameLayout = new FrameLayout(this.context);
        AppMethodBeat.m2505o(37194);
        return frameLayout;
    }
}
