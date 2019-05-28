package com.tencent.p177mm.plugin.appbrand.p336ui.collection;

import android.content.Context;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0014¨\u0006\n"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/ui/collection/CollectionItemViewLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "onMeasure", "", "widthMeasureSpec", "", "heightMeasureSpec", "plugin-appbrand-integration_release"})
/* renamed from: com.tencent.mm.plugin.appbrand.ui.collection.g */
final class C10868g extends FrameLayout {
    public C10868g(Context context) {
        C25052j.m39376p(context, "context");
        super(context);
        AppMethodBeat.m2504i(135102);
        AppMethodBeat.m2505o(135102);
    }

    /* Access modifiers changed, original: protected|final */
    public final void onMeasure(int i, int i2) {
        AppMethodBeat.m2504i(135101);
        super.onMeasure(i, i2);
        if (getMeasuredHeight() < getMeasuredWidth()) {
            setMeasuredDimension(getMeasuredWidth(), getMeasuredWidth());
        }
        AppMethodBeat.m2505o(135101);
    }
}
