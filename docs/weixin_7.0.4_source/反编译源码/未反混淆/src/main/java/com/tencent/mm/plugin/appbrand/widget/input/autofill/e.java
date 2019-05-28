package com.tencent.mm.plugin.appbrand.widget.input.autofill;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;

public final class e extends AutoFillListPopupWindowBase {
    private final Context mContext;

    e(Context context) {
        super(context, null, 0);
        AppMethodBeat.i(123905);
        this.mContext = context;
        this.amH.setInputMethodMode(2);
        this.amH.setBackgroundDrawable(context.getResources().getDrawable(R.drawable.a9m));
        this.amH.setFocusable(false);
        this.ams = false;
        this.amt = true;
        this.amH.setAnimationStyle(R.anim.x);
        AppMethodBeat.o(123905);
    }

    public final void show() {
        AppMethodBeat.i(123906);
        super.show();
        AppMethodBeat.o(123906);
    }
}
