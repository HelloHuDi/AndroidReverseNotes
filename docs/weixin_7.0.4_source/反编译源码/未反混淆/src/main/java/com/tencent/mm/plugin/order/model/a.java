package com.tencent.mm.plugin.order.model;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.order.ui.a.e;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.h.d;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import java.util.LinkedList;
import java.util.List;

public final class a {

    public interface a {
        List<Preference> a(Context context, f fVar, MallTransactionObject mallTransactionObject);
    }

    public static e a(final Context context, final MallTransactionObject mallTransactionObject) {
        AppMethodBeat.i(43748);
        e eVar = new e(context);
        if (bo.isNullOrNil(mallTransactionObject.pcv)) {
            eVar.pez = context.getString(R.string.flq);
        } else {
            eVar.pez = context.getString(R.string.fln);
        }
        eVar.mOnClickListener = new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(43747);
                List linkedList = new LinkedList();
                List linkedList2 = new LinkedList();
                if (!bo.isNullOrNil(mallTransactionObject.pcm)) {
                    linkedList2.add(Integer.valueOf(0));
                    linkedList.add(context.getString(R.string.flo));
                }
                if (!bo.isNullOrNil(mallTransactionObject.pbP)) {
                    linkedList2.add(Integer.valueOf(1));
                    linkedList.add(context.getString(R.string.flp));
                }
                if (!bo.isNullOrNil(mallTransactionObject.pcv)) {
                    linkedList2.add(Integer.valueOf(2));
                    linkedList.add(context.getString(R.string.flr));
                }
                if (linkedList2.size() == 1) {
                    a.a(((Integer) linkedList2.get(0)).intValue(), context, mallTransactionObject);
                    AppMethodBeat.o(43747);
                    return;
                }
                h.a(context, null, linkedList, linkedList2, null, true, new d() {
                    public final void bV(int i, int i2) {
                        AppMethodBeat.i(43746);
                        a.a(i2, context, mallTransactionObject);
                        AppMethodBeat.o(43746);
                    }
                });
                AppMethodBeat.o(43747);
            }
        };
        AppMethodBeat.o(43748);
        return eVar;
    }

    public static void a(int i, Context context, MallTransactionObject mallTransactionObject) {
        AppMethodBeat.i(43749);
        switch (i) {
            case 0:
                g.RQ();
                ad aoO = ((j) g.K(j.class)).XM().aoO(mallTransactionObject.pcm);
                if (aoO == null || !com.tencent.mm.n.a.jh(aoO.field_type)) {
                    com.tencent.mm.wallet_core.ui.e.ae(context, mallTransactionObject.pcm);
                    AppMethodBeat.o(43749);
                    return;
                }
                com.tencent.mm.wallet_core.ui.e.ag(context, mallTransactionObject.pcm);
                AppMethodBeat.o(43749);
                return;
            case 1:
                com.tencent.mm.wallet_core.ui.e.bU(context, mallTransactionObject.pbP);
                AppMethodBeat.o(43749);
                return;
            case 2:
                com.tencent.mm.wallet_core.ui.e.n(context, mallTransactionObject.pcv, false);
                break;
        }
        AppMethodBeat.o(43749);
    }
}
