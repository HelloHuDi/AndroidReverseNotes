package com.tencent.mm.plugin.appbrand.luggage.export.functionalpage;

import a.f.b.j;
import a.l;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.ui.q;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.statusbar.b;

@l(dWo = {1, 1, 13}, dWp = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\tH\u0016J\b\u0010\r\u001a\u00020\tH\u0014J\b\u0010\u000e\u001a\u00020\tH\u0014J\u0012\u0010\u000f\u001a\u00020\t2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000bH\u0016J\u0018\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J\u0010\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u0017H\u0016R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/FunctionalLoadingSplash;", "Lcom/tencent/mm/ui/statusbar/DrawStatusBarFrameLayout;", "Lcom/tencent/mm/plugin/appbrand/ui/IAppBrandLoadingSplash;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "progresDialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "animateHide", "", "getView", "Landroid/view/View;", "hideNavBtn", "onAttachedToWindow", "onDetachedFromWindow", "onViewAdded", "child", "setAppInfo", "icon", "", "name", "setProgress", "progress", "", "plugin-appbrand-integration_release"})
public final class g extends b implements q {
    private p iku;

    public g(Context context) {
        j.p(context, "context");
        super(context);
        AppMethodBeat.i(134746);
        K(0, true);
        setBackgroundColor(0);
        AppMethodBeat.o(134746);
    }

    public final void onViewAdded(View view) {
        AppMethodBeat.i(134742);
        super.onViewAdded(view);
        if (view != null) {
            if (view.getId() == R.id.yo) {
                LayoutParams layoutParams = view.getLayoutParams();
                if (!(layoutParams instanceof FrameLayout.LayoutParams)) {
                    layoutParams = null;
                }
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
                if (layoutParams2 != null) {
                    layoutParams2.gravity = 17;
                }
                view.setLayoutParams(view.getLayoutParams());
            }
            AppMethodBeat.o(134742);
            return;
        }
        AppMethodBeat.o(134742);
    }

    /* Access modifiers changed, original: protected|final */
    public final void onAttachedToWindow() {
        AppMethodBeat.i(134743);
        super.onAttachedToWindow();
        Context context = getContext();
        getResources().getString(R.string.tz);
        this.iku = h.b(context, getResources().getString(R.string.cn5), false, null);
        AppMethodBeat.o(134743);
    }

    /* Access modifiers changed, original: protected|final */
    public final void onDetachedFromWindow() {
        AppMethodBeat.i(134744);
        super.onDetachedFromWindow();
        p pVar = this.iku;
        if (pVar != null) {
            pVar.dismiss();
            AppMethodBeat.o(134744);
            return;
        }
        AppMethodBeat.o(134744);
    }

    public final void cz(String str, String str2) {
        AppMethodBeat.i(134745);
        j.p(str, "icon");
        j.p(str2, "name");
        AppMethodBeat.o(134745);
    }

    public final void aHS() {
    }

    public final void aHT() {
    }

    public final View getView() {
        return this;
    }

    public final void setProgress(int i) {
    }
}
