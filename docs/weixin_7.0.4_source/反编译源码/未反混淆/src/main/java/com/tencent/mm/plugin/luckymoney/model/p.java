package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import java.util.HashSet;
import java.util.Set;

public final class p {
    private Object lock = new Object();
    private Set<String> nXG = new HashSet();

    public p() {
        AppMethodBeat.i(42336);
        String str = (String) g.RP().Ry().get(a.USERINFO_WALLET_HONGBAO_PAYMSGID_STRING_SYNC, (Object) "");
        if (!bo.isNullOrNil(str)) {
            for (Object add : str.split(",")) {
                this.nXG.add(add);
            }
        }
        AppMethodBeat.o(42336);
    }

    public final boolean Qh(String str) {
        boolean z = false;
        AppMethodBeat.i(42337);
        synchronized (this.lock) {
            try {
                if (this.nXG.contains(str)) {
                    ab.i("MicroMsg.LuckyMoneyMsg", "has contains msg, %s", str);
                    AppMethodBeat.o(42337);
                } else {
                    StringBuilder stringBuilder = new StringBuilder((String) g.RP().Ry().get(a.USERINFO_WALLET_HONGBAO_PAYMSGID_STRING_SYNC, (Object) ""));
                    if (this.nXG.size() <= 0) {
                        stringBuilder.append(str);
                    } else {
                        stringBuilder.append(",").append(str);
                    }
                    g.RP().Ry().set(a.USERINFO_WALLET_HONGBAO_PAYMSGID_STRING_SYNC, stringBuilder.toString());
                    z = this.nXG.add(str);
                }
            } finally {
                AppMethodBeat.o(42337);
            }
        }
        return z;
    }

    public final void Qi(String str) {
        AppMethodBeat.i(42338);
        synchronized (this.lock) {
            try {
                Object stringBuilder;
                this.nXG.remove(str);
                StringBuilder stringBuilder2 = new StringBuilder();
                for (String append : this.nXG) {
                    stringBuilder2.append(append).append(",");
                }
                if (stringBuilder2.length() == 0) {
                    stringBuilder = stringBuilder2.toString();
                } else {
                    stringBuilder = stringBuilder2.substring(0, stringBuilder2.length() - 1);
                }
                g.RP().Ry().set(a.USERINFO_WALLET_HONGBAO_PAYMSGID_STRING_SYNC, stringBuilder);
            } finally {
                AppMethodBeat.o(42338);
            }
        }
    }
}
