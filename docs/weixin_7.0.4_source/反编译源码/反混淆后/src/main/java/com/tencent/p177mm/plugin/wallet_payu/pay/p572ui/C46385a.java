package com.tencent.p177mm.plugin.wallet_payu.pay.p572ui;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.wallet_core.model.Bankcard;
import com.tencent.p177mm.plugin.wallet_core.model.Orders;
import com.tencent.p177mm.plugin.wallet_core.p561ui.C40128i;
import java.util.ArrayList;

/* renamed from: com.tencent.mm.plugin.wallet_payu.pay.ui.a */
public final class C46385a extends C40128i {
    public final /* synthetic */ Object getItem(int i) {
        AppMethodBeat.m2504i(48460);
        Bankcard Hd = mo63458Hd(i);
        AppMethodBeat.m2505o(48460);
        return Hd;
    }

    public C46385a(Context context, ArrayList<Bankcard> arrayList, int i, Orders orders) {
        super(context, arrayList, i, orders);
    }

    public final int getCount() {
        AppMethodBeat.m2504i(48458);
        if (this.tgB == null || this.tgB.size() == 0) {
            AppMethodBeat.m2505o(48458);
            return 1;
        }
        int size = this.tgB.size();
        AppMethodBeat.m2505o(48458);
        return size;
    }

    /* renamed from: Hd */
    public final Bankcard mo63458Hd(int i) {
        AppMethodBeat.m2504i(48459);
        Bankcard bankcard;
        if (this.tgB != null && this.tgB.size() != 0) {
            bankcard = (Bankcard) this.tgB.get(i);
            AppMethodBeat.m2505o(48459);
            return bankcard;
        } else if (i != getCount() - 1) {
            bankcard = (Bankcard) this.tgB.get(i);
            AppMethodBeat.m2505o(48459);
            return bankcard;
        } else {
            AppMethodBeat.m2505o(48459);
            return null;
        }
    }
}
