package com.tencent.p177mm.plugin.card.p355ui.view;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.card.base.C42837b;
import com.tencent.p177mm.plugin.card.p931d.C42839c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.card.ui.view.j */
public final class C42868j extends C11358g {
    /* renamed from: f */
    public final boolean mo23070f(C42837b c42837b) {
        AppMethodBeat.m2504i(88747);
        if (this.kaS == null) {
            C4990ab.m7416i("MicroMsg.CardCodeView", "isNeedUpdateViewAgain mCardInfo is null！");
            AppMethodBeat.m2505o(88747);
            return true;
        } else if (c42837b == null) {
            C4990ab.m7416i("MicroMsg.CardCodeView", "isNeedUpdateViewAgain false  newCardInfo null！");
            AppMethodBeat.m2505o(88747);
            return false;
        } else {
            String str = this.kaS.aZW().code;
            String str2 = c42837b.aZW().code;
            if (C5046bo.isNullOrNil(str) || C5046bo.isNullOrNil(str2) || str.equals(str2)) {
                AppMethodBeat.m2505o(88747);
                return false;
            }
            C4990ab.m7416i("MicroMsg.CardCodeView", "isNeedUpdateViewAgain   code  is diffrent！");
            AppMethodBeat.m2505o(88747);
            return true;
        }
    }

    /* renamed from: e */
    public final String mo23069e(C42839c c42839c) {
        AppMethodBeat.m2504i(88748);
        String str = this.kaS.aZW().code;
        AppMethodBeat.m2505o(88748);
        return str;
    }

    public final C45799ab bey() {
        AppMethodBeat.m2504i(88749);
        C27632v c27632v = new C27632v(this, this.jiE);
        AppMethodBeat.m2505o(88749);
        return c27632v;
    }

    public final C45799ab bez() {
        AppMethodBeat.m2504i(88750);
        C16727f c16727f = new C16727f(this, this.jiE);
        AppMethodBeat.m2505o(88750);
        return c16727f;
    }

    public final C45799ab beA() {
        AppMethodBeat.m2504i(88751);
        C42871t c42871t = new C42871t(this, this.jiE);
        AppMethodBeat.m2505o(88751);
        return c42871t;
    }
}
