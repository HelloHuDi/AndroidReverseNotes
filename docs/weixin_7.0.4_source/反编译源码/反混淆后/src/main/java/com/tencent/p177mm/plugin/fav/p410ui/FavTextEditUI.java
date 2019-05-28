package com.tencent.p177mm.plugin.fav.p410ui;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p612ui.tools.MMTextInputUI;
import com.tencent.p177mm.plugin.fav.p407a.C11850al;
import com.tencent.p177mm.plugin.fav.p407a.C27966g;
import com.tencent.p177mm.plugin.fav.p407a.C7604ae;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.protocal.protobuf.bca;
import com.tencent.p177mm.protocal.protobuf.bcd;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.fav.ui.FavTextEditUI */
public class FavTextEditUI extends MMTextInputUI {
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public final int getLayoutId() {
        return 2130969499;
    }

    /* renamed from: I */
    public final void mo23730I(CharSequence charSequence) {
        AppMethodBeat.m2504i(74162);
        if (charSequence == null || C5046bo.isNullOrNil(charSequence.toString())) {
            C4990ab.m7420w("MicroMsg.FavTextEditUI", "text is null");
            AppMethodBeat.m2505o(74162);
            return;
        }
        int intExtra = getIntent().getIntExtra("key_fav_item_id", -1);
        String charSequence2 = charSequence.toString();
        if (intExtra <= 0) {
            C4990ab.m7421w("MicroMsg.FavTextEditUI", "modEditText favid:%d", Integer.valueOf(intExtra));
            AppMethodBeat.m2505o(74162);
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
        bcd.pXM = C5046bo.m7532bc(charSequence2, "");
        linkedList2.add(bcd);
        bcd = new bcd();
        bcd.ncF = "favitem.edittime";
        bcd.pXM = String.valueOf(C5046bo.anT());
        linkedList2.add(bcd);
        C27966g iF = ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavItemInfoStorage().mo23694iF((long) intExtra);
        if (iF != null) {
            iF.field_edittime = C5046bo.anT();
            iF.field_favProto.mo74748mk(iF.field_edittime);
            iF.field_favProto.alC(C5046bo.m7532bc(charSequence2, ""));
            ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavItemInfoStorage().mo23678a(iF, "localId");
        }
        C1720g.m3540Rg().mo14541a(new C11850al(intExtra, linkedList, linkedList2), 0);
        C7060h.pYm.mo8381e(10874, Integer.valueOf(1));
        AppMethodBeat.m2505o(74162);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(74161);
        this.ylm = true;
        super.onCreate(bundle);
        setMMTitle((int) C25738R.string.bo_);
        AppMethodBeat.m2505o(74161);
    }
}
