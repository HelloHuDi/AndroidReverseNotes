package com.tencent.p177mm.plugin.appbrand.widget.input.autofill;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;

/* renamed from: com.tencent.mm.plugin.appbrand.widget.input.autofill.e */
public final class C33621e extends AutoFillListPopupWindowBase {
    private final Context mContext;

    C33621e(Context context) {
        super(context, null, 0);
        AppMethodBeat.m2504i(123905);
        this.mContext = context;
        this.amH.setInputMethodMode(2);
        this.amH.setBackgroundDrawable(context.getResources().getDrawable(C25738R.drawable.a9m));
        this.amH.setFocusable(false);
        this.ams = false;
        this.amt = true;
        this.amH.setAnimationStyle(C25738R.anim.f8295x);
        AppMethodBeat.m2505o(123905);
    }

    public final void show() {
        AppMethodBeat.m2504i(123906);
        super.show();
        AppMethodBeat.m2505o(123906);
    }
}
