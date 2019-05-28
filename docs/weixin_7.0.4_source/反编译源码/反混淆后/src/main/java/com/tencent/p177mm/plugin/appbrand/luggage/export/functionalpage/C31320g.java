package com.tencent.p177mm.plugin.appbrand.luggage.export.functionalpage;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C44275p;
import com.tencent.p177mm.p612ui.statusbar.C7355b;
import com.tencent.p177mm.plugin.appbrand.p336ui.C27333q;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\tH\u0016J\b\u0010\r\u001a\u00020\tH\u0014J\b\u0010\u000e\u001a\u00020\tH\u0014J\u0012\u0010\u000f\u001a\u00020\t2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000bH\u0016J\u0018\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J\u0010\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u0017H\u0016R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/FunctionalLoadingSplash;", "Lcom/tencent/mm/ui/statusbar/DrawStatusBarFrameLayout;", "Lcom/tencent/mm/plugin/appbrand/ui/IAppBrandLoadingSplash;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "progresDialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "animateHide", "", "getView", "Landroid/view/View;", "hideNavBtn", "onAttachedToWindow", "onDetachedFromWindow", "onViewAdded", "child", "setAppInfo", "icon", "", "name", "setProgress", "progress", "", "plugin-appbrand-integration_release"})
/* renamed from: com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.g */
public final class C31320g extends C7355b implements C27333q {
    private C44275p iku;

    public C31320g(Context context) {
        C25052j.m39376p(context, "context");
        super(context);
        AppMethodBeat.m2504i(134746);
        mo15851K(0, true);
        setBackgroundColor(0);
        AppMethodBeat.m2505o(134746);
    }

    public final void onViewAdded(View view) {
        AppMethodBeat.m2504i(134742);
        super.onViewAdded(view);
        if (view != null) {
            if (view.getId() == 2131821483) {
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
            AppMethodBeat.m2505o(134742);
            return;
        }
        AppMethodBeat.m2505o(134742);
    }

    /* Access modifiers changed, original: protected|final */
    public final void onAttachedToWindow() {
        AppMethodBeat.m2504i(134743);
        super.onAttachedToWindow();
        Context context = getContext();
        getResources().getString(C25738R.string.f9238tz);
        this.iku = C30379h.m48458b(context, getResources().getString(C25738R.string.cn5), false, null);
        AppMethodBeat.m2505o(134743);
    }

    /* Access modifiers changed, original: protected|final */
    public final void onDetachedFromWindow() {
        AppMethodBeat.m2504i(134744);
        super.onDetachedFromWindow();
        C44275p c44275p = this.iku;
        if (c44275p != null) {
            c44275p.dismiss();
            AppMethodBeat.m2505o(134744);
            return;
        }
        AppMethodBeat.m2505o(134744);
    }

    /* renamed from: cz */
    public final void mo22399cz(String str, String str2) {
        AppMethodBeat.m2504i(134745);
        C25052j.m39376p(str, "icon");
        C25052j.m39376p(str2, "name");
        AppMethodBeat.m2505o(134745);
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
