package com.tencent.p177mm.plugin.recharge.p491ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.recharge.model.MallRechargeProduct;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.recharge.ui.a */
public final class C46160a {
    /* renamed from: cL */
    public static MallRechargeProduct m86166cL(List<MallRechargeProduct> list) {
        AppMethodBeat.m2504i(44246);
        for (MallRechargeProduct mallRechargeProduct : list) {
            if (mallRechargeProduct.isDefault && mallRechargeProduct.isValid()) {
                C4990ab.m7410d("MicroMsg.MallRechargeLogic", "find the defaultProduct");
                AppMethodBeat.m2505o(44246);
                return mallRechargeProduct;
            }
        }
        C4990ab.m7410d("MicroMsg.MallRechargeLogic", "products.get(0)");
        MallRechargeProduct mallRechargeProduct2 = (MallRechargeProduct) list.get(0);
        AppMethodBeat.m2505o(44246);
        return mallRechargeProduct2;
    }
}
