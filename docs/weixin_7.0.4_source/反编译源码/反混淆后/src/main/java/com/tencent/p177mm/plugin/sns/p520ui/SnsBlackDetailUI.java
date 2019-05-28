package com.tencent.p177mm.plugin.sns.p520ui;

import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p264n.C7486a;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.sns.model.C13373af;
import com.tencent.p177mm.plugin.sns.p1363c.C24826a;
import com.tencent.p177mm.sdk.p603e.C7298n.C4937b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7309bd;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.sns.ui.SnsBlackDetailUI */
public class SnsBlackDetailUI extends SnsTagDetailUI implements C1202f, C4937b {
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public final void csO() {
        AppMethodBeat.m2504i(38739);
        C4990ab.m7410d("MicroMsg.SnsBlackDetailUI", "SnsBlackDetailUI __onCreate");
        C1720g.m3537RQ();
        ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().mo10118a(this);
        AppMethodBeat.m2505o(38739);
    }

    /* Access modifiers changed, original: protected|final */
    public final void csP() {
        AppMethodBeat.m2504i(38740);
        C4990ab.m7410d("MicroMsg.SnsBlackDetailUI", "SnsBlackDetailUI __onDestroy");
        C1720g.m3537RQ();
        if (C1720g.m3534RN().mo5161QY()) {
            C1720g.m3537RQ();
            ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().mo10121b(this);
        }
        AppMethodBeat.m2505o(38740);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(38741);
        super.onCreate(bundle);
        C4990ab.m7410d("MicroMsg.SnsBlackDetailUI", "SnsBlackDetailUI onCreate");
        AppMethodBeat.m2505o(38741);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(38742);
        if (this.tipDialog != null) {
            this.tipDialog.dismiss();
        }
        C1720g.m3537RQ();
        C1720g.m3535RO().eJo.mo14546b(290, (C1202f) this);
        C1720g.m3537RQ();
        C1720g.m3535RO().eJo.mo14546b(291, (C1202f) this);
        C1720g.m3537RQ();
        C1720g.m3535RO().eJo.mo14546b(292, (C1202f) this);
        C1720g.m3537RQ();
        C1720g.m3535RO().eJo.mo14546b(293, (C1202f) this);
        C1720g.m3537RQ();
        if (C1720g.m3534RN().mo5161QY()) {
            C1720g.m3537RQ();
            ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().mo10121b(this);
        }
        super.onDestroy();
        AppMethodBeat.m2505o(38742);
    }

    /* Access modifiers changed, original: protected|final */
    public final void csQ() {
    }

    /* Access modifiers changed, original: protected|final */
    public final void bKl() {
        AppMethodBeat.m2504i(38743);
        if ((this.rxA + " " + C5046bo.m7536c(this.kPL, ",")).equals(this.cvZ) && this.qJQ != 0) {
            finish();
            AppMethodBeat.m2505o(38743);
        } else if (C13373af.cnL().mo55581v(this.qJQ, this.rxA)) {
            C30379h.m48461b((Context) this, getString(C25738R.string.eow, new Object[]{this.rxA}), getString(C25738R.string.f9238tz), true);
            AppMethodBeat.m2505o(38743);
        } else {
            List<String> csS = csS();
            LinkedList<String> linkedList = new LinkedList();
            LinkedList<String> linkedList2 = new LinkedList();
            for (String str : csS) {
                if (!this.kPL.contains(str)) {
                    linkedList.add(str);
                }
            }
            for (String str2 : this.kPL) {
                if (!csS.contains(str2)) {
                    linkedList2.add(str2);
                }
            }
            for (String str22 : linkedList) {
                C1855t.m3966v(str22, false);
            }
            for (String str222 : linkedList2) {
                C1855t.m3966v(str222, true);
            }
            C24826a.gkF.mo38844BS();
            finish();
            AppMethodBeat.m2505o(38743);
        }
    }

    private static List<String> csR() {
        AppMethodBeat.m2504i(38744);
        LinkedList linkedList = new LinkedList();
        List Zn = C1855t.m3877Zn();
        AppMethodBeat.m2505o(38744);
        return Zn;
    }

    /* Access modifiers changed, original: protected|final */
    public final List<String> csS() {
        AppMethodBeat.m2504i(38745);
        List<String> linkedList = new LinkedList();
        if (this.qJQ == 4) {
            List csR = SnsBlackDetailUI.csR();
            AppMethodBeat.m2505o(38745);
            return csR;
        }
        AppMethodBeat.m2505o(38745);
        return linkedList;
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: km */
    public final void mo47265km(String str) {
        AppMethodBeat.m2504i(38746);
        super.mo47265km(str);
        AppMethodBeat.m2505o(38746);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: dr */
    public final void mo47264dr(List<String> list) {
        AppMethodBeat.m2504i(38747);
        C7309bd cnt = C13373af.cnt();
        String Yz = C1853r.m3846Yz();
        for (String str : list) {
            if (!(this.kPL.contains(str) || !C7486a.m12942jh(cnt.aoO(str).field_type) || Yz.equals(str))) {
                this.kPL.add(str);
            }
        }
        if (this.ehS != null) {
            this.ehS.mo48360ci(this.kPL);
        }
        updateTitle();
        AppMethodBeat.m2505o(38747);
    }

    public void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(38748);
        C4990ab.m7416i("MicroMsg.SnsBlackDetailUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (this.tipDialog != null) {
            this.tipDialog.dismiss();
        }
        AppMethodBeat.m2505o(38748);
    }
}
