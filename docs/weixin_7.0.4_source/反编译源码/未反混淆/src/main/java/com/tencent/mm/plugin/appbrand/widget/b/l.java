package com.tencent.mm.plugin.appbrand.widget.b;

import a.f.b.j;
import a.v;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;

@a.l(dWo = {1, 1, 13}, dWp = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/widget/dialog/RequestDialogRotationHelper;", "", "()V", "Companion", "luggage-wechat-full-sdk_release"})
public final class l {
    public static final a jcT = new a();

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J&\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000b¨\u0006\f"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/widget/dialog/RequestDialogRotationHelper$Companion;", "", "()V", "applyStyleByRotation", "", "context", "Landroid/content/Context;", "rootView", "Landroid/view/View;", "buttonGroup", "rotation", "", "luggage-wechat-full-sdk_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }

        public static void a(Context context, View view, View view2, int i) {
            AppMethodBeat.i(102507);
            j.p(context, "context");
            j.p(view, "rootView");
            j.p(view2, "buttonGroup");
            LayoutParams layoutParams = view2.getLayoutParams();
            v vVar;
            if (i == 1 || i == 3) {
                if (view2.getParent() instanceof RelativeLayout) {
                    if (layoutParams == null) {
                        vVar = new v("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
                        AppMethodBeat.o(102507);
                        throw vVar;
                    }
                    ((RelativeLayout.LayoutParams) layoutParams).bottomMargin = context.getResources().getDimensionPixelSize(R.dimen.u5);
                }
                layoutParams = view.getLayoutParams();
                layoutParams.width = context.getResources().getDimensionPixelSize(R.dimen.u8);
                view.setLayoutParams(layoutParams);
                AppMethodBeat.o(102507);
                return;
            }
            if (view2.getParent() instanceof RelativeLayout) {
                if (layoutParams == null) {
                    vVar = new v("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
                    AppMethodBeat.o(102507);
                    throw vVar;
                }
                ((RelativeLayout.LayoutParams) layoutParams).bottomMargin = context.getResources().getDimensionPixelSize(R.dimen.u6);
            }
            layoutParams = view.getLayoutParams();
            layoutParams.width = -1;
            view.setLayoutParams(layoutParams);
            AppMethodBeat.o(102507);
        }
    }

    static {
        AppMethodBeat.i(102508);
        AppMethodBeat.o(102508);
    }
}
