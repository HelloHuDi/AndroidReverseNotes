package com.tencent.mm.plugin.recharge.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recharge.model.MallRechargeProduct;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.List;

public final class a {
    public static MallRechargeProduct cL(List<MallRechargeProduct> list) {
        AppMethodBeat.i(44246);
        for (MallRechargeProduct mallRechargeProduct : list) {
            if (mallRechargeProduct.isDefault && mallRechargeProduct.isValid()) {
                ab.d("MicroMsg.MallRechargeLogic", "find the defaultProduct");
                AppMethodBeat.o(44246);
                return mallRechargeProduct;
            }
        }
        ab.d("MicroMsg.MallRechargeLogic", "products.get(0)");
        MallRechargeProduct mallRechargeProduct2 = (MallRechargeProduct) list.get(0);
        AppMethodBeat.o(44246);
        return mallRechargeProduct2;
    }
}
