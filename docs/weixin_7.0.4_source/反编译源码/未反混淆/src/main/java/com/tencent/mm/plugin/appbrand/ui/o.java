package com.tencent.mm.plugin.appbrand.ui;

import a.l;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.statusbar.b;
import com.tencent.mm.ui.widget.SwipeBackLayout;
import com.tencent.mm.vending.c.a;

@l(dWo = {1, 1, 13}, dWp = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a&\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005¨\u0006\b"}, dWq = {"runIfDrawStatusBarLayoutPresent", "", "activity", "Lcom/tencent/mm/ui/MMActivity;", "function", "Lcom/tencent/mm/vending/functional/Functional;", "Ljava/lang/Void;", "Lcom/tencent/mm/ui/statusbar/DrawStatusBarFrameLayout;", "plugin-appbrand-integration_release"})
public final class o {
    public static final void a(MMActivity mMActivity, a<Void, b> aVar) {
        View targetContentView;
        AppMethodBeat.i(135002);
        SwipeBackLayout swipeBackLayout = mMActivity.getSwipeBackLayout();
        if (swipeBackLayout != null) {
            targetContentView = swipeBackLayout.getTargetContentView();
        } else {
            targetContentView = null;
        }
        if (!(targetContentView instanceof b)) {
            targetContentView = null;
        }
        b bVar = (b) targetContentView;
        if (bVar != null) {
            aVar.call(bVar);
            AppMethodBeat.o(135002);
            return;
        }
        AppMethodBeat.o(135002);
    }
}
