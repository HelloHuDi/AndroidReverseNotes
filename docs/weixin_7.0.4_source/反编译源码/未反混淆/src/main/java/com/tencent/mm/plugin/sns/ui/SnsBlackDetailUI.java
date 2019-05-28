package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.r;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.sns.c.a;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.base.h;
import java.util.LinkedList;
import java.util.List;

public class SnsBlackDetailUI extends SnsTagDetailUI implements f, b {
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public final void csO() {
        AppMethodBeat.i(38739);
        ab.d("MicroMsg.SnsBlackDetailUI", "SnsBlackDetailUI __onCreate");
        g.RQ();
        ((j) g.K(j.class)).XM().a(this);
        AppMethodBeat.o(38739);
    }

    /* Access modifiers changed, original: protected|final */
    public final void csP() {
        AppMethodBeat.i(38740);
        ab.d("MicroMsg.SnsBlackDetailUI", "SnsBlackDetailUI __onDestroy");
        g.RQ();
        if (g.RN().QY()) {
            g.RQ();
            ((j) g.K(j.class)).XM().b(this);
        }
        AppMethodBeat.o(38740);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(38741);
        super.onCreate(bundle);
        ab.d("MicroMsg.SnsBlackDetailUI", "SnsBlackDetailUI onCreate");
        AppMethodBeat.o(38741);
    }

    public void onDestroy() {
        AppMethodBeat.i(38742);
        if (this.tipDialog != null) {
            this.tipDialog.dismiss();
        }
        g.RQ();
        g.RO().eJo.b(290, (f) this);
        g.RQ();
        g.RO().eJo.b(291, (f) this);
        g.RQ();
        g.RO().eJo.b(292, (f) this);
        g.RQ();
        g.RO().eJo.b(293, (f) this);
        g.RQ();
        if (g.RN().QY()) {
            g.RQ();
            ((j) g.K(j.class)).XM().b(this);
        }
        super.onDestroy();
        AppMethodBeat.o(38742);
    }

    /* Access modifiers changed, original: protected|final */
    public final void csQ() {
    }

    /* Access modifiers changed, original: protected|final */
    public final void bKl() {
        AppMethodBeat.i(38743);
        if ((this.rxA + " " + bo.c(this.kPL, ",")).equals(this.cvZ) && this.qJQ != 0) {
            finish();
            AppMethodBeat.o(38743);
        } else if (af.cnL().v(this.qJQ, this.rxA)) {
            h.b((Context) this, getString(R.string.eow, new Object[]{this.rxA}), getString(R.string.tz), true);
            AppMethodBeat.o(38743);
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
                t.v(str22, false);
            }
            for (String str222 : linkedList2) {
                t.v(str222, true);
            }
            a.gkF.BS();
            finish();
            AppMethodBeat.o(38743);
        }
    }

    private static List<String> csR() {
        AppMethodBeat.i(38744);
        LinkedList linkedList = new LinkedList();
        List Zn = t.Zn();
        AppMethodBeat.o(38744);
        return Zn;
    }

    /* Access modifiers changed, original: protected|final */
    public final List<String> csS() {
        AppMethodBeat.i(38745);
        List<String> linkedList = new LinkedList();
        if (this.qJQ == 4) {
            List csR = csR();
            AppMethodBeat.o(38745);
            return csR;
        }
        AppMethodBeat.o(38745);
        return linkedList;
    }

    /* Access modifiers changed, original: protected|final */
    public final void km(String str) {
        AppMethodBeat.i(38746);
        super.km(str);
        AppMethodBeat.o(38746);
    }

    /* Access modifiers changed, original: protected|final */
    public final void dr(List<String> list) {
        AppMethodBeat.i(38747);
        bd cnt = af.cnt();
        String Yz = r.Yz();
        for (String str : list) {
            if (!(this.kPL.contains(str) || !com.tencent.mm.n.a.jh(cnt.aoO(str).field_type) || Yz.equals(str))) {
                this.kPL.add(str);
            }
        }
        if (this.ehS != null) {
            this.ehS.ci(this.kPL);
        }
        updateTitle();
        AppMethodBeat.o(38747);
    }

    public void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(38748);
        ab.i("MicroMsg.SnsBlackDetailUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (this.tipDialog != null) {
            this.tipDialog.dismiss();
        }
        AppMethodBeat.o(38748);
    }
}
