package com.tencent.p177mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import java.util.HashSet;
import java.util.Set;

/* renamed from: com.tencent.mm.plugin.luckymoney.model.p */
public final class C21204p {
    private Object lock = new Object();
    private Set<String> nXG = new HashSet();

    public C21204p() {
        AppMethodBeat.m2504i(42336);
        String str = (String) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_WALLET_HONGBAO_PAYMSGID_STRING_SYNC, (Object) "");
        if (!C5046bo.isNullOrNil(str)) {
            for (Object add : str.split(",")) {
                this.nXG.add(add);
            }
        }
        AppMethodBeat.m2505o(42336);
    }

    /* renamed from: Qh */
    public final boolean mo36579Qh(String str) {
        boolean z = false;
        AppMethodBeat.m2504i(42337);
        synchronized (this.lock) {
            try {
                if (this.nXG.contains(str)) {
                    C4990ab.m7417i("MicroMsg.LuckyMoneyMsg", "has contains msg, %s", str);
                    AppMethodBeat.m2505o(42337);
                } else {
                    StringBuilder stringBuilder = new StringBuilder((String) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_WALLET_HONGBAO_PAYMSGID_STRING_SYNC, (Object) ""));
                    if (this.nXG.size() <= 0) {
                        stringBuilder.append(str);
                    } else {
                        stringBuilder.append(",").append(str);
                    }
                    C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_WALLET_HONGBAO_PAYMSGID_STRING_SYNC, stringBuilder.toString());
                    z = this.nXG.add(str);
                }
            } finally {
                AppMethodBeat.m2505o(42337);
            }
        }
        return z;
    }

    /* renamed from: Qi */
    public final void mo36580Qi(String str) {
        AppMethodBeat.m2504i(42338);
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
                C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_WALLET_HONGBAO_PAYMSGID_STRING_SYNC, stringBuilder);
            } finally {
                AppMethodBeat.m2505o(42338);
            }
        }
    }
}
