package com.tencent.mm.plugin.base.stub;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.model.r;
import com.tencent.mm.ui.base.h;

public final class a extends d {
    public a(Context context, String str, String str2, com.tencent.mm.plugin.base.stub.d.a aVar) {
        super(context, str, str2, aVar);
    }

    /* Access modifiers changed, original: protected|final */
    public final void aVh() {
        AppMethodBeat.i(18110);
        h.a(this.context, (int) R.string.c7h, (int) R.string.tz, false, new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.i(18109);
                com.tencent.mm.plugin.game.a.a bDb = com.tencent.mm.plugin.game.a.a.a.bDb();
                if (bDb != null) {
                    bDb.m(a.this.openId, r.YC(), a.this.appId);
                }
                a.this.jDq.ft(false);
                AppMethodBeat.o(18109);
            }
        });
        AppMethodBeat.o(18110);
    }
}
