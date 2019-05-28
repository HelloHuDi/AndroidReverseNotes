package com.tencent.mm.plugin.wallet_core.model;

import android.content.Context;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.List;

public final class t {
    public SparseArray<String> tCm = null;
    public List<ElementQuery> tum = null;

    public final String fk(Context context) {
        AppMethodBeat.i(46887);
        String Z = Z(context, r.cPI().cQq());
        AppMethodBeat.o(46887);
        return Z;
    }

    public final String Z(Context context, int i) {
        String str;
        AppMethodBeat.i(46888);
        if (this.tCm != null) {
            str = (String) this.tCm.get(i);
            if (!bo.isNullOrNil(str)) {
                AppMethodBeat.o(46888);
                return str;
            }
        }
        str = context.getString(R.string.faq);
        AppMethodBeat.o(46888);
        return str;
    }

    public final ElementQuery acy(String str) {
        AppMethodBeat.i(46889);
        if (this.tum == null || this.tum.size() == 0) {
            ab.w("MicroMsg.WalletBankElementManager", "hy: no element from given banktype");
            AppMethodBeat.o(46889);
            return null;
        }
        for (ElementQuery elementQuery : this.tum) {
            if (elementQuery.pbn != null && elementQuery.pbn.equals(str)) {
                AppMethodBeat.o(46889);
                return elementQuery;
            }
        }
        ab.w("MicroMsg.WalletBankElementManager", "hy: not found given banktype: %s", str);
        AppMethodBeat.o(46889);
        return null;
    }

    public final ElementQuery acz(String str) {
        AppMethodBeat.i(46890);
        if (bo.isNullOrNil(str)) {
            ab.w("MicroMsg.WalletBankElementManager", "hy: bindSerail given is null");
            AppMethodBeat.o(46890);
            return null;
        } else if (this.tum == null || this.tum.size() == 0) {
            ab.w("MicroMsg.WalletBankElementManager", "hy: element list is null. get element failed");
            AppMethodBeat.o(46890);
            return null;
        } else {
            for (ElementQuery elementQuery : this.tum) {
                if (str.equals(elementQuery.pbo)) {
                    AppMethodBeat.o(46890);
                    return elementQuery;
                }
            }
            ab.w("MicroMsg.WalletBankElementManager", "hy: not found given element query");
            AppMethodBeat.o(46890);
            return null;
        }
    }
}
