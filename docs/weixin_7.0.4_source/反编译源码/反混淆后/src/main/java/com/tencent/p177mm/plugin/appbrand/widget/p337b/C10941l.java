package com.tencent.p177mm.plugin.appbrand.widget.p337b;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import p000a.C0220l;
import p000a.C44941v;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/widget/dialog/RequestDialogRotationHelper;", "", "()V", "Companion", "luggage-wechat-full-sdk_release"})
/* renamed from: com.tencent.mm.plugin.appbrand.widget.b.l */
public final class C10941l {
    public static final C10942a jcT = new C10942a();

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J&\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000b¨\u0006\f"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/widget/dialog/RequestDialogRotationHelper$Companion;", "", "()V", "applyStyleByRotation", "", "context", "Landroid/content/Context;", "rootView", "Landroid/view/View;", "buttonGroup", "rotation", "", "luggage-wechat-full-sdk_release"})
    /* renamed from: com.tencent.mm.plugin.appbrand.widget.b.l$a */
    public static final class C10942a {
        private C10942a() {
        }

        public /* synthetic */ C10942a(byte b) {
            this();
        }

        /* renamed from: a */
        public static void m18668a(Context context, View view, View view2, int i) {
            AppMethodBeat.m2504i(102507);
            C25052j.m39376p(context, "context");
            C25052j.m39376p(view, "rootView");
            C25052j.m39376p(view2, "buttonGroup");
            LayoutParams layoutParams = view2.getLayoutParams();
            C44941v c44941v;
            if (i == 1 || i == 3) {
                if (view2.getParent() instanceof RelativeLayout) {
                    if (layoutParams == null) {
                        c44941v = new C44941v("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
                        AppMethodBeat.m2505o(102507);
                        throw c44941v;
                    }
                    ((RelativeLayout.LayoutParams) layoutParams).bottomMargin = context.getResources().getDimensionPixelSize(C25738R.dimen.f10198u5);
                }
                layoutParams = view.getLayoutParams();
                layoutParams.width = context.getResources().getDimensionPixelSize(C25738R.dimen.f10201u8);
                view.setLayoutParams(layoutParams);
                AppMethodBeat.m2505o(102507);
                return;
            }
            if (view2.getParent() instanceof RelativeLayout) {
                if (layoutParams == null) {
                    c44941v = new C44941v("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
                    AppMethodBeat.m2505o(102507);
                    throw c44941v;
                }
                ((RelativeLayout.LayoutParams) layoutParams).bottomMargin = context.getResources().getDimensionPixelSize(C25738R.dimen.f10199u6);
            }
            layoutParams = view.getLayoutParams();
            layoutParams.width = -1;
            view.setLayoutParams(layoutParams);
            AppMethodBeat.m2505o(102507);
        }
    }

    static {
        AppMethodBeat.m2504i(102508);
        AppMethodBeat.m2505o(102508);
    }
}
