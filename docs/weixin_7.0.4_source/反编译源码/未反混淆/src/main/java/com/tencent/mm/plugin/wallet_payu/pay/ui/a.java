package com.tencent.mm.plugin.wallet_payu.pay.ui;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.ui.i;
import java.util.ArrayList;

public final class a extends i {
    public final /* synthetic */ Object getItem(int i) {
        AppMethodBeat.i(48460);
        Bankcard Hd = Hd(i);
        AppMethodBeat.o(48460);
        return Hd;
    }

    public a(Context context, ArrayList<Bankcard> arrayList, int i, Orders orders) {
        super(context, arrayList, i, orders);
    }

    public final int getCount() {
        AppMethodBeat.i(48458);
        if (this.tgB == null || this.tgB.size() == 0) {
            AppMethodBeat.o(48458);
            return 1;
        }
        int size = this.tgB.size();
        AppMethodBeat.o(48458);
        return size;
    }

    public final Bankcard Hd(int i) {
        AppMethodBeat.i(48459);
        Bankcard bankcard;
        if (this.tgB != null && this.tgB.size() != 0) {
            bankcard = (Bankcard) this.tgB.get(i);
            AppMethodBeat.o(48459);
            return bankcard;
        } else if (i != getCount() - 1) {
            bankcard = (Bankcard) this.tgB.get(i);
            AppMethodBeat.o(48459);
            return bankcard;
        } else {
            AppMethodBeat.o(48459);
            return null;
        }
    }
}
