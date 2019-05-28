package com.tencent.p177mm.plugin.card.p355ui.view;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.card.base.C42837b;
import com.tencent.p177mm.plugin.card.p931d.C42839c;
import com.tencent.p177mm.protocal.protobuf.C23446tm;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.card.ui.view.q */
public final class C42869q extends C11358g {
    public String knw = "";

    /* renamed from: f */
    public final boolean mo23070f(C42837b c42837b) {
        AppMethodBeat.m2504i(88775);
        if (this.kaS == null) {
            C4990ab.m7416i("MicroMsg.CardCodeView", "isNeedUpdateViewAgain mCardInfo is null！");
            AppMethodBeat.m2505o(88775);
            return true;
        } else if (c42837b == null) {
            C4990ab.m7416i("MicroMsg.CardCodeView", "isNeedUpdateViewAgain false  newCardInfo null！");
            AppMethodBeat.m2505o(88775);
            return false;
        } else {
            String str = this.kaS.aZW().code;
            String str2 = c42837b.aZW().code;
            if (C5046bo.isNullOrNil(str) || C5046bo.isNullOrNil(str2) || str.equals(str2)) {
                C23446tm c23446tm = this.kaS.aZV().vUA;
                C23446tm c23446tm2 = c42837b.aZV().vUA;
                if ((c23446tm == null && c23446tm2 != null) || (c23446tm != null && c23446tm2 == null)) {
                    C4990ab.m7416i("MicroMsg.CardCodeView", "isNeedUpdateViewAgain pay_and_qrcode_field  is diffrent！");
                    AppMethodBeat.m2505o(88775);
                    return true;
                } else if (c23446tm != null && c23446tm2 != null && c23446tm.title != null && c23446tm2.title != null && !c23446tm.title.equals(c23446tm2.title)) {
                    C4990ab.m7416i("MicroMsg.CardCodeView", "isNeedUpdateViewAgain pay_and_qrcode_field title is diffrent！");
                    AppMethodBeat.m2505o(88775);
                    return true;
                } else if (c23446tm != null && c23446tm2 != null && c23446tm.kbX != null && c23446tm2.kbX != null && !c23446tm.kbX.equals(c23446tm2.kbX)) {
                    C4990ab.m7416i("MicroMsg.CardCodeView", "isNeedUpdateViewAgain pay_and_qrcode_field aux_title  is diffrent！");
                    AppMethodBeat.m2505o(88775);
                    return true;
                } else if (!this.kaS.aZQ() || C5046bo.isNullOrNil(this.knw)) {
                    AppMethodBeat.m2505o(88775);
                    return false;
                } else {
                    C4990ab.m7416i("MicroMsg.CardCodeView", "dynamicCode updated！");
                    AppMethodBeat.m2505o(88775);
                    return true;
                }
            }
            C4990ab.m7416i("MicroMsg.CardCodeView", "isNeedUpdateViewAgain   code  is diffrent！");
            AppMethodBeat.m2505o(88775);
            return true;
        }
    }

    /* renamed from: e */
    public final String mo23069e(C42839c c42839c) {
        AppMethodBeat.m2504i(88776);
        String str;
        if (!C5046bo.isNullOrNil(this.kaS.aZW().vSo)) {
            str = this.kaS.aZW().vSo;
            AppMethodBeat.m2505o(88776);
            return str;
        } else if (!this.kaS.aZQ() || C5046bo.isNullOrNil(this.knw)) {
            str = this.kaS.aZW().code;
            AppMethodBeat.m2505o(88776);
            return str;
        } else {
            str = this.knw;
            AppMethodBeat.m2505o(88776);
            return str;
        }
    }

    public final C45799ab bey() {
        AppMethodBeat.m2504i(88777);
        C42870s c42870s = new C42870s(this, this.jiE);
        AppMethodBeat.m2505o(88777);
        return c42870s;
    }

    public final C45799ab bez() {
        AppMethodBeat.m2504i(88778);
        C20199p c20199p = new C20199p(this, this.jiE);
        AppMethodBeat.m2505o(88778);
        return c20199p;
    }

    public final C45799ab beA() {
        AppMethodBeat.m2504i(88779);
        C45801r c45801r = new C45801r(this, this.jiE);
        AppMethodBeat.m2505o(88779);
        return c45801r;
    }
}
