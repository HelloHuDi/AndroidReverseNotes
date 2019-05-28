package com.tencent.p177mm.plugin.wallet_core.model;

import android.content.Context;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.wallet_core.model.t */
public final class C4397t {
    public SparseArray<String> tCm = null;
    public List<ElementQuery> tum = null;

    /* renamed from: fk */
    public final String mo9422fk(Context context) {
        AppMethodBeat.m2504i(46887);
        String Z = mo9419Z(context, C14241r.cPI().cQq());
        AppMethodBeat.m2505o(46887);
        return Z;
    }

    /* renamed from: Z */
    public final String mo9419Z(Context context, int i) {
        String str;
        AppMethodBeat.m2504i(46888);
        if (this.tCm != null) {
            str = (String) this.tCm.get(i);
            if (!C5046bo.isNullOrNil(str)) {
                AppMethodBeat.m2505o(46888);
                return str;
            }
        }
        str = context.getString(C25738R.string.faq);
        AppMethodBeat.m2505o(46888);
        return str;
    }

    public final ElementQuery acy(String str) {
        AppMethodBeat.m2504i(46889);
        if (this.tum == null || this.tum.size() == 0) {
            C4990ab.m7420w("MicroMsg.WalletBankElementManager", "hy: no element from given banktype");
            AppMethodBeat.m2505o(46889);
            return null;
        }
        for (ElementQuery elementQuery : this.tum) {
            if (elementQuery.pbn != null && elementQuery.pbn.equals(str)) {
                AppMethodBeat.m2505o(46889);
                return elementQuery;
            }
        }
        C4990ab.m7421w("MicroMsg.WalletBankElementManager", "hy: not found given banktype: %s", str);
        AppMethodBeat.m2505o(46889);
        return null;
    }

    public final ElementQuery acz(String str) {
        AppMethodBeat.m2504i(46890);
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7420w("MicroMsg.WalletBankElementManager", "hy: bindSerail given is null");
            AppMethodBeat.m2505o(46890);
            return null;
        } else if (this.tum == null || this.tum.size() == 0) {
            C4990ab.m7420w("MicroMsg.WalletBankElementManager", "hy: element list is null. get element failed");
            AppMethodBeat.m2505o(46890);
            return null;
        } else {
            for (ElementQuery elementQuery : this.tum) {
                if (str.equals(elementQuery.pbo)) {
                    AppMethodBeat.m2505o(46890);
                    return elementQuery;
                }
            }
            C4990ab.m7420w("MicroMsg.WalletBankElementManager", "hy: not found given element query");
            AppMethodBeat.m2505o(46890);
            return null;
        }
    }
}
