package com.tencent.mm.plugin.fav.ui;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.fav.a.ae;
import com.tencent.mm.plugin.fav.a.al;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.bca;
import com.tencent.mm.protocal.protobuf.bcd;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.tools.MMTextInputUI;
import java.util.LinkedList;

public class FavTextEditUI extends MMTextInputUI {
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public final int getLayoutId() {
        return R.layout.y7;
    }

    public final void I(CharSequence charSequence) {
        AppMethodBeat.i(74162);
        if (charSequence == null || bo.isNullOrNil(charSequence.toString())) {
            ab.w("MicroMsg.FavTextEditUI", "text is null");
            AppMethodBeat.o(74162);
            return;
        }
        int intExtra = getIntent().getIntExtra("key_fav_item_id", -1);
        String charSequence2 = charSequence.toString();
        if (intExtra <= 0) {
            ab.w("MicroMsg.FavTextEditUI", "modEditText favid:%d", Integer.valueOf(intExtra));
            AppMethodBeat.o(74162);
            return;
        }
        LinkedList linkedList = new LinkedList();
        bca bca = new bca();
        bca.wGC = 4;
        bca.wGD = 0;
        linkedList.add(bca);
        LinkedList linkedList2 = new LinkedList();
        bcd bcd = new bcd();
        bcd.ncF = "favitem.desc";
        bcd.pXM = bo.bc(charSequence2, "");
        linkedList2.add(bcd);
        bcd = new bcd();
        bcd.ncF = "favitem.edittime";
        bcd.pXM = String.valueOf(bo.anT());
        linkedList2.add(bcd);
        g iF = ((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavItemInfoStorage().iF((long) intExtra);
        if (iF != null) {
            iF.field_edittime = bo.anT();
            iF.field_favProto.mk(iF.field_edittime);
            iF.field_favProto.alC(bo.bc(charSequence2, ""));
            ((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavItemInfoStorage().a(iF, "localId");
        }
        com.tencent.mm.kernel.g.Rg().a(new al(intExtra, linkedList, linkedList2), 0);
        h.pYm.e(10874, Integer.valueOf(1));
        AppMethodBeat.o(74162);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(74161);
        this.ylm = true;
        super.onCreate(bundle);
        setMMTitle((int) R.string.bo_);
        AppMethodBeat.o(74161);
    }
}
