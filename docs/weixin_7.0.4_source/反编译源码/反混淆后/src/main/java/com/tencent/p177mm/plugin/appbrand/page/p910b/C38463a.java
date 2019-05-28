package com.tencent.p177mm.plugin.appbrand.page.p910b;

import android.annotation.TargetApi;
import android.app.Activity;
import android.view.View;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.plugin.appbrand.page.C44709u;
import com.tencent.p177mm.plugin.appbrand.page.p910b.C19627c.C19628b;

@TargetApi(21)
/* renamed from: com.tencent.mm.plugin.appbrand.page.b.a */
public class C38463a extends C27222b {
    private int ivr = 0;

    protected C38463a(C44709u c44709u) {
        super(c44709u);
    }

    public void aBr() {
        AppMethodBeat.m2504i(87365);
        aKi();
        AppMethodBeat.m2505o(87365);
    }

    private void aKi() {
        AppMethodBeat.m2504i(87366);
        this.ivt.set(C19628b.SHOWN);
        if (this.ivs.mContext instanceof Activity) {
            Window window = ((Activity) this.ivs.mContext).getWindow();
            if (window == null) {
                AppMethodBeat.m2505o(87366);
                return;
            }
            View decorView = window.getDecorView();
            window.clearFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
            decorView.setSystemUiVisibility(decorView.getSystemUiVisibility() & -5);
        }
        AppMethodBeat.m2505o(87366);
    }

    public void aBs() {
        AppMethodBeat.m2504i(87367);
        this.ivt.set(C19628b.HIDDEN);
        if (this.ivs.mContext instanceof Activity) {
            Window window = ((Activity) this.ivs.mContext).getWindow();
            if (window == null) {
                AppMethodBeat.m2505o(87367);
                return;
            }
            window.addFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
            View decorView = window.getDecorView();
            decorView.setSystemUiVisibility((decorView.getSystemUiVisibility() | 4) | 256);
        }
        AppMethodBeat.m2505o(87367);
    }

    public void aAS() {
        AppMethodBeat.m2504i(87368);
        super.aAS();
        switch ((C19628b) this.ivt.get()) {
            case SHOWN:
                aKi();
                AppMethodBeat.m2505o(87368);
                return;
            case HIDDEN:
                aBs();
                AppMethodBeat.m2505o(87368);
                return;
            default:
                AppMethodBeat.m2505o(87368);
                return;
        }
    }

    public void onOrientationChanged(int i) {
        AppMethodBeat.m2504i(87369);
        super.onOrientationChanged(i);
        Object obj = i != this.ivr ? 1 : null;
        this.ivr = i;
        if (2 == i) {
            aBs();
            AppMethodBeat.m2505o(87369);
            return;
        }
        if (obj != null || this.ivt.get() == C19628b.SHOWN) {
            aBr();
        }
        AppMethodBeat.m2505o(87369);
    }
}
