package com.tencent.mm.plugin.wallet_core.model;

import android.content.Context;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.h;

public final class m {
    public String hwA;
    public boolean kDs;
    public int retCode;
    public int tzy;

    public static m a(boolean z, int i, int i2, String str) {
        AppMethodBeat.i(46781);
        m mVar = new m();
        mVar.kDs = z;
        mVar.retCode = i;
        mVar.tzy = i2;
        mVar.hwA = str;
        AppMethodBeat.o(46781);
        return mVar;
    }

    public static m gi(int i, int i2) {
        AppMethodBeat.i(46782);
        m a = a(false, i, i2, "");
        AppMethodBeat.o(46782);
        return a;
    }

    public final void y(Context context, boolean z) {
        AppMethodBeat.i(46783);
        if (!this.kDs) {
            h.b(context, context.getString(R.string.fiu), "", false);
        } else if (!bo.isNullOrNil(this.hwA)) {
            if (z) {
                Toast.makeText(context, this.hwA, 1).show();
                AppMethodBeat.o(46783);
                return;
            }
            h.b(context, this.hwA, "", false);
            AppMethodBeat.o(46783);
            return;
        }
        AppMethodBeat.o(46783);
    }
}
