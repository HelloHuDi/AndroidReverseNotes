package com.tencent.p177mm.plugin.appbrand.game.page;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.page.C19640n;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

@SuppressLint({"ViewConstructor"})
/* renamed from: com.tencent.mm.plugin.appbrand.game.page.d */
public final class C10243d extends C19640n {
    private C33204f hsH;
    private String mURL;

    public C10243d(Context context, C10244e c10244e) {
        super(context, c10244e);
        AppMethodBeat.m2504i(130218);
        C4990ab.m7416i("MicroMsg.WAGamePage", "hy: WAGamePage on create");
        AppMethodBeat.m2505o(130218);
    }

    public final View aAQ() {
        AppMethodBeat.m2504i(130219);
        C33204f c33204f = new C33204f(getContext(), getContainer().getRuntime());
        this.hsH = c33204f;
        WAGamePageViewContainerLayout wAGamePageViewContainerLayout = c33204f.hsL;
        AppMethodBeat.m2505o(130219);
        return wAGamePageViewContainerLayout;
    }

    public final void loadUrl(String str) {
        AppMethodBeat.m2504i(130220);
        this.mURL = str;
        this.hsH.mo44893AA(str);
        AppMethodBeat.m2505o(130220);
    }

    /* renamed from: Ay */
    public final boolean mo21657Ay(String str) {
        return true;
    }

    /* renamed from: b */
    public final void mo21662b(String str, String str2, int[] iArr) {
        AppMethodBeat.m2504i(130221);
        this.hsH.mo51255h(str, str2, 0);
        AppMethodBeat.m2505o(130221);
    }

    public final C33204f getCurrentPageView() {
        return this.hsH;
    }

    public final String getCurrentUrl() {
        return this.mURL;
    }

    public final void cleanup() {
        AppMethodBeat.m2504i(130222);
        super.cleanup();
        this.hsH.cleanup();
        AppMethodBeat.m2505o(130222);
    }

    public final void aAR() {
        AppMethodBeat.m2504i(130223);
        super.aAR();
        this.hsH.onDestroy();
        AppMethodBeat.m2505o(130223);
    }

    public final void aAS() {
        AppMethodBeat.m2504i(130224);
        super.aAS();
        this.hsH.mo71772wU();
        AppMethodBeat.m2505o(130224);
    }

    public final void aAT() {
        AppMethodBeat.m2504i(130225);
        super.aAT();
        this.hsH.mo71773wW();
        AppMethodBeat.m2505o(130225);
    }
}
