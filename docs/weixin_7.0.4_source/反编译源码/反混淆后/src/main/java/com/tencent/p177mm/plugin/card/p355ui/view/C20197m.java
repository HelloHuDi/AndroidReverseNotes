package com.tencent.p177mm.plugin.card.p355ui.view;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.card.base.C42837b;
import com.tencent.p177mm.plugin.card.model.C11288k;
import com.tencent.p177mm.plugin.card.model.C20149i;
import com.tencent.p177mm.plugin.card.model.C42852am;
import com.tencent.p177mm.plugin.card.p352b.C33753g;
import com.tencent.p177mm.plugin.card.p931d.C11280q;
import com.tencent.p177mm.plugin.card.p931d.C38736l;
import com.tencent.p177mm.plugin.card.p931d.C42839c;
import com.tencent.p177mm.plugin.card.p931d.C42843e;
import com.tencent.p177mm.protocal.protobuf.C23446tm;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.card.ui.view.m */
public final class C20197m extends C11358g {
    /* renamed from: f */
    public final boolean mo23070f(C42837b c42837b) {
        AppMethodBeat.m2504i(88757);
        if (this.kaS == null) {
            C4990ab.m7416i("MicroMsg.CarDynamicCodeView", "isNeedUpdateViewAgain mCardInfo is null！");
            AppMethodBeat.m2505o(88757);
            return true;
        } else if (c42837b == null) {
            C4990ab.m7416i("MicroMsg.CarDynamicCodeView", "isNeedUpdateViewAgain false  newCardInfo null！");
            AppMethodBeat.m2505o(88757);
            return false;
        } else if (this.kaS.aZW().vSq != c42837b.aZW().vSq) {
            C4990ab.m7416i("MicroMsg.CarDynamicCodeView", "isNeedUpdateViewAgain is_commom_card is different！");
            AppMethodBeat.m2505o(88757);
            return true;
        } else {
            C23446tm c23446tm = this.kaS.aZW().vSp;
            C23446tm c23446tm2 = c42837b.aZW().vSp;
            if ((c23446tm == null && c23446tm2 != null) || (c23446tm != null && c23446tm2 == null)) {
                C4990ab.m7416i("MicroMsg.CarDynamicCodeView", "isNeedUpdateViewAgain unavailable_qrcode_field is different！");
                AppMethodBeat.m2505o(88757);
                return true;
            } else if (c23446tm == null || c23446tm2 == null || c23446tm.title == null || c23446tm2.title == null || !c23446tm.title.equals(c23446tm2.title)) {
                c23446tm = this.kaS.aZV().vUA;
                c23446tm2 = c42837b.aZV().vUA;
                if ((c23446tm == null && c23446tm2 != null) || (c23446tm != null && c23446tm2 == null)) {
                    C4990ab.m7416i("MicroMsg.CarDynamicCodeView", "isNeedUpdateViewAgain pay_and_qrcode_field  is diffrent！");
                    AppMethodBeat.m2505o(88757);
                    return true;
                } else if (c23446tm != null && c23446tm2 != null && c23446tm.title != null && c23446tm2.title != null && !c23446tm.title.equals(c23446tm2.title)) {
                    C4990ab.m7416i("MicroMsg.CarDynamicCodeView", "isNeedUpdateViewAgain pay_and_qrcode_field title is diffrent！");
                    AppMethodBeat.m2505o(88757);
                    return true;
                } else if (c23446tm == null || c23446tm2 == null || c23446tm.kbX == null || c23446tm2.kbX == null || c23446tm.kbX.equals(c23446tm2.kbX)) {
                    AppMethodBeat.m2505o(88757);
                    return false;
                } else {
                    C4990ab.m7416i("MicroMsg.CarDynamicCodeView", "isNeedUpdateViewAgain pay_and_qrcode_field aux_title  is diffrent！");
                    AppMethodBeat.m2505o(88757);
                    return true;
                }
            } else {
                C4990ab.m7416i("MicroMsg.CarDynamicCodeView", "isNeedUpdateViewAgain unavailable_qrcode_field title is different！");
                AppMethodBeat.m2505o(88757);
                return true;
            }
        }
    }

    /* renamed from: e */
    public final String mo23069e(C42839c c42839c) {
        AppMethodBeat.m2504i(88758);
        C4990ab.m7416i("MicroMsg.CarDynamicCodeView", "code from dynamic offline");
        C33753g bbm = C42852am.bbm();
        C42837b c42837b = this.kaS;
        String str = "";
        if (c42837b == null) {
            C4990ab.m7412e("MicroMsg.CardDynamicQrcodeOfflineMgr", "get code is failure! cardInfo is null");
        } else {
            int i;
            bbm.bao();
            bbm.kaZ = c42839c;
            String aZZ = c42837b.aZZ();
            Cursor rawQuery = C42852am.bbk().bSd.rawQuery("select count(1) from CardQrCodeDataInfo where card_id =? AND status=0", new String[]{aZZ});
            if (rawQuery != null) {
                rawQuery.moveToFirst();
                i = rawQuery.getInt(0);
                rawQuery.close();
            } else {
                i = 0;
            }
            if (i == 0) {
                C4990ab.m7412e("MicroMsg.CardDynamicQrcodeOfflineMgr", "can not getFrom db！db is empty!");
                i = 0;
            } else {
                C20149i Gv = C42852am.bbl().mo17030Gv(aZZ);
                if (Gv != null) {
                    if (C33753g.m55147a(Gv)) {
                        bbm.kaZ = C42839c.CARDCODEREFRESHACTION_UNSHOWN_TIMEOUT;
                        i = 0;
                    } else if (i < Gv.field_lower_bound && C38736l.isNetworkAvailable(C4996ah.getContext())) {
                        C4990ab.m7413e("MicroMsg.CardDynamicQrcodeOfflineMgr", "can not getFrom db！ currentCodeSize < lower_bound,currentCodeSize =%d,lower_bound=%d", Integer.valueOf(i), Integer.valueOf(Gv.field_lower_bound));
                        bbm.kaZ = C42839c.CARDCODEREFRESHACTION_UPDATECHANGE;
                        i = 0;
                    }
                }
                i = 1;
            }
            if (i == 0) {
                C4990ab.m7416i("MicroMsg.CardDynamicQrcodeOfflineMgr", "can not getFrom db！ request doNetSceneGetDynamicQrcode!");
                bbm.mo54285a(c42837b, C11280q.EN_DYNAMIC_CODE_SCENE_ENTER_CARD_DETAIL);
                str = "";
                AppMethodBeat.m2505o(88758);
                return str;
            }
            C11288k Gx = C42852am.bbk().mo22984Gx(c42837b.aZZ());
            if (Gx == null) {
                C4990ab.m7417i("MicroMsg.CardDynamicQrcodeOfflineMgr", "get code is failure! db is  empty! doNetSceneGetDynamicQrcode! cardId= %s", c42837b.aZZ());
                bbm.mo54285a(c42837b, C11280q.EN_DYNAMIC_CODE_SCENE_ENTER_CARD_DETAIL);
                str = "";
                AppMethodBeat.m2505o(88758);
                return str;
            }
            C11288k Gy = C42852am.bbk().mo22985Gy(aZZ);
            if (Gy != null && C42852am.bbk().mo22986dm(aZZ, Gy.field_code_id)) {
                bbm.mo54287a(aZZ, Gy.field_code_id, c42839c);
            }
            bbm.exv = 0;
            C4990ab.m7417i("MicroMsg.CardDynamicQrcodeOfflineMgr", "update current code showing! newQrCodeData cardId= %s,codeId=%s，refreshReason=%d", aZZ, Gx.field_code_id, Integer.valueOf(c42839c.action));
            aZZ = c42837b.aZZ();
            if (Gx == null) {
                str = "";
            } else {
                str = C42843e.m76044ds(aZZ, Gx.field_code);
                C20149i Gv2 = C42852am.bbl().mo17030Gv(aZZ);
                if (Gv2 == null || C5046bo.isNullOrNil(str) || !Gv2.field_need_insert_show_timestamp || C5046bo.isNullOrNil(Gv2.field_show_timestamp_encrypt_key)) {
                    C4990ab.m7416i("MicroMsg.CardDynamicQrcodeOfflineMgr", "getCodeData only decrypt qrcode!");
                } else {
                    C4990ab.m7416i("MicroMsg.CardDynamicQrcodeOfflineMgr", "getCodeData is need insert show timestamp! code signTimestamp!");
                    str = C42843e.m76046du(str, Gv2.field_show_timestamp_encrypt_key);
                }
            }
            if (C5046bo.isNullOrNil(str)) {
                bbm.mo54283R(1, "");
                str = "";
                AppMethodBeat.m2505o(88758);
                return str;
            }
            Gx.field_status = 1;
            if (C42852am.bbk().mo10103c(Gx, "card_id", "code_id")) {
                C4990ab.m7417i("MicroMsg.CardQrCodeDataInfoStorage", "update qrCodeData  success! card_id = %s, code_id = %s ,status = %d", Gx.field_card_id, Gx.field_code_id, Integer.valueOf(Gx.field_status));
            } else {
                C4990ab.m7413e("MicroMsg.CardQrCodeDataInfoStorage", "update qrCodeData  failure! card_id = %s, code_id = %s ,status = %d", Gx.field_card_id, Gx.field_code_id, Integer.valueOf(Gx.field_status));
            }
            C33753g bbm2 = C42852am.bbm();
            C20149i Gv3 = C42852am.bbl().mo17030Gv(c42837b.aZZ());
            if (Gv3 == null) {
                C4990ab.m7412e("MicroMsg.CardDynamicQrcodeOfflineMgr", "startRequestCodeTimer failure! CardQrCodeConfi is null!");
            } else {
                long j = (long) (Gv3.field_show_expire_interval * 1000);
                C4990ab.m7416i("MicroMsg.CardDynamicQrcodeOfflineMgr", "startRefreshCodeTimer refreshTime: ".concat(String.valueOf(j)));
                bbm2.kba.mo16770ae(j, j);
            }
        }
        AppMethodBeat.m2505o(88758);
        return str;
    }

    public final C45799ab bey() {
        AppMethodBeat.m2504i(88759);
        C27628n c27628n = new C27628n(this, this.jiE);
        AppMethodBeat.m2505o(88759);
        return c27628n;
    }

    public final C45799ab bez() {
        AppMethodBeat.m2504i(88760);
        C16727f c16727f = new C16727f(this, this.jiE);
        AppMethodBeat.m2505o(88760);
        return c16727f;
    }

    public final C45799ab beA() {
        AppMethodBeat.m2504i(88761);
        C42871t c42871t = new C42871t(this, this.jiE);
        AppMethodBeat.m2505o(88761);
        return c42871t;
    }
}
