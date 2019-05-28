package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.i;
import android.view.Display;
import android.view.WindowManager.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;

public final class a extends i {
    a obT;

    interface a {
        void bMl();
    }

    public a(Context context) {
        super(context, R.style.h4);
        AppMethodBeat.i(42555);
        fA();
        AppMethodBeat.o(42555);
    }

    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(42556);
        super.onCreate(bundle);
        getWindow().setGravity(80);
        Display defaultDisplay = getWindow().getWindowManager().getDefaultDisplay();
        LayoutParams attributes = getWindow().getAttributes();
        attributes.width = defaultDisplay.getWidth();
        getWindow().setAttributes(attributes);
        AppMethodBeat.o(42556);
    }

    public final void onBackPressed() {
        AppMethodBeat.i(42557);
        if (this.obT != null) {
            this.obT.bMl();
        }
        AppMethodBeat.o(42557);
    }
}
