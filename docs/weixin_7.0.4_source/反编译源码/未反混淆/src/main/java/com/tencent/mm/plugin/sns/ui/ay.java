package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.widget.a.c.a;

public final class ay {
    public static void b(Context context, OnClickListener onClickListener) {
        AppMethodBeat.i(39834);
        a aVar = new a(context);
        aVar.PV(R.string.eqm);
        aVar.asE(context.getString(R.string.eqn) + "\n\n" + context.getString(R.string.eqo));
        aVar.Qc(R.string.g0z).a(onClickListener);
        aVar.a(new OnDismissListener() {
            public final void onDismiss(DialogInterface dialogInterface) {
                AppMethodBeat.i(39833);
                g.RQ();
                int a = bo.a((Integer) g.RP().Ry().get(68385, null), 0) + 1;
                g.RQ();
                g.RP().Ry().set(68385, Integer.valueOf(a));
                AppMethodBeat.o(39833);
            }
        });
        aVar.aMb().show();
        AppMethodBeat.o(39834);
    }
}
