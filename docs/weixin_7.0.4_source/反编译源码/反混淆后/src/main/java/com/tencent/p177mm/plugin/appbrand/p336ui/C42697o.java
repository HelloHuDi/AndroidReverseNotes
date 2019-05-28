package com.tencent.p177mm.plugin.appbrand.p336ui;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.statusbar.C7355b;
import com.tencent.p177mm.p612ui.widget.SwipeBackLayout;
import com.tencent.p177mm.vending.p637c.C5681a;
import p000a.C0220l;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a&\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005¨\u0006\b"}, dWq = {"runIfDrawStatusBarLayoutPresent", "", "activity", "Lcom/tencent/mm/ui/MMActivity;", "function", "Lcom/tencent/mm/vending/functional/Functional;", "Ljava/lang/Void;", "Lcom/tencent/mm/ui/statusbar/DrawStatusBarFrameLayout;", "plugin-appbrand-integration_release"})
/* renamed from: com.tencent.mm.plugin.appbrand.ui.o */
public final class C42697o {
    /* renamed from: a */
    public static final void m75625a(MMActivity mMActivity, C5681a<Void, C7355b> c5681a) {
        View targetContentView;
        AppMethodBeat.m2504i(135002);
        SwipeBackLayout swipeBackLayout = mMActivity.getSwipeBackLayout();
        if (swipeBackLayout != null) {
            targetContentView = swipeBackLayout.getTargetContentView();
        } else {
            targetContentView = null;
        }
        if (!(targetContentView instanceof C7355b)) {
            targetContentView = null;
        }
        C7355b c7355b = (C7355b) targetContentView;
        if (c7355b != null) {
            c5681a.call(c7355b);
            AppMethodBeat.m2505o(135002);
            return;
        }
        AppMethodBeat.m2505o(135002);
    }
}
