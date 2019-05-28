package com.tencent.mm.plugin.card.ui.view;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.b.g;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.d.c;
import com.tencent.mm.plugin.card.d.e;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.card.d.q;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.model.i;
import com.tencent.mm.plugin.card.model.k;
import com.tencent.mm.protocal.protobuf.tm;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;

public final class m extends g {
    public final boolean f(b bVar) {
        AppMethodBeat.i(88757);
        if (this.kaS == null) {
            ab.i("MicroMsg.CarDynamicCodeView", "isNeedUpdateViewAgain mCardInfo is null！");
            AppMethodBeat.o(88757);
            return true;
        } else if (bVar == null) {
            ab.i("MicroMsg.CarDynamicCodeView", "isNeedUpdateViewAgain false  newCardInfo null！");
            AppMethodBeat.o(88757);
            return false;
        } else if (this.kaS.aZW().vSq != bVar.aZW().vSq) {
            ab.i("MicroMsg.CarDynamicCodeView", "isNeedUpdateViewAgain is_commom_card is different！");
            AppMethodBeat.o(88757);
            return true;
        } else {
            tm tmVar = this.kaS.aZW().vSp;
            tm tmVar2 = bVar.aZW().vSp;
            if ((tmVar == null && tmVar2 != null) || (tmVar != null && tmVar2 == null)) {
                ab.i("MicroMsg.CarDynamicCodeView", "isNeedUpdateViewAgain unavailable_qrcode_field is different！");
                AppMethodBeat.o(88757);
                return true;
            } else if (tmVar == null || tmVar2 == null || tmVar.title == null || tmVar2.title == null || !tmVar.title.equals(tmVar2.title)) {
                tmVar = this.kaS.aZV().vUA;
                tmVar2 = bVar.aZV().vUA;
                if ((tmVar == null && tmVar2 != null) || (tmVar != null && tmVar2 == null)) {
                    ab.i("MicroMsg.CarDynamicCodeView", "isNeedUpdateViewAgain pay_and_qrcode_field  is diffrent！");
                    AppMethodBeat.o(88757);
                    return true;
                } else if (tmVar != null && tmVar2 != null && tmVar.title != null && tmVar2.title != null && !tmVar.title.equals(tmVar2.title)) {
                    ab.i("MicroMsg.CarDynamicCodeView", "isNeedUpdateViewAgain pay_and_qrcode_field title is diffrent！");
                    AppMethodBeat.o(88757);
                    return true;
                } else if (tmVar == null || tmVar2 == null || tmVar.kbX == null || tmVar2.kbX == null || tmVar.kbX.equals(tmVar2.kbX)) {
                    AppMethodBeat.o(88757);
                    return false;
                } else {
                    ab.i("MicroMsg.CarDynamicCodeView", "isNeedUpdateViewAgain pay_and_qrcode_field aux_title  is diffrent！");
                    AppMethodBeat.o(88757);
                    return true;
                }
            } else {
                ab.i("MicroMsg.CarDynamicCodeView", "isNeedUpdateViewAgain unavailable_qrcode_field title is different！");
                AppMethodBeat.o(88757);
                return true;
            }
        }
    }

    public final String e(c cVar) {
        AppMethodBeat.i(88758);
        ab.i("MicroMsg.CarDynamicCodeView", "code from dynamic offline");
        g bbm = am.bbm();
        b bVar = this.kaS;
        String str = "";
        if (bVar == null) {
            ab.e("MicroMsg.CardDynamicQrcodeOfflineMgr", "get code is failure! cardInfo is null");
        } else {
            int i;
            bbm.bao();
            bbm.kaZ = cVar;
            String aZZ = bVar.aZZ();
            Cursor rawQuery = am.bbk().bSd.rawQuery("select count(1) from CardQrCodeDataInfo where card_id =? AND status=0", new String[]{aZZ});
            if (rawQuery != null) {
                rawQuery.moveToFirst();
                i = rawQuery.getInt(0);
                rawQuery.close();
            } else {
                i = 0;
            }
            if (i == 0) {
                ab.e("MicroMsg.CardDynamicQrcodeOfflineMgr", "can not getFrom db！db is empty!");
                i = 0;
            } else {
                i Gv = am.bbl().Gv(aZZ);
                if (Gv != null) {
                    if (g.a(Gv)) {
                        bbm.kaZ = c.CARDCODEREFRESHACTION_UNSHOWN_TIMEOUT;
                        i = 0;
                    } else if (i < Gv.field_lower_bound && l.isNetworkAvailable(ah.getContext())) {
                        ab.e("MicroMsg.CardDynamicQrcodeOfflineMgr", "can not getFrom db！ currentCodeSize < lower_bound,currentCodeSize =%d,lower_bound=%d", Integer.valueOf(i), Integer.valueOf(Gv.field_lower_bound));
                        bbm.kaZ = c.CARDCODEREFRESHACTION_UPDATECHANGE;
                        i = 0;
                    }
                }
                i = 1;
            }
            if (i == 0) {
                ab.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "can not getFrom db！ request doNetSceneGetDynamicQrcode!");
                bbm.a(bVar, q.EN_DYNAMIC_CODE_SCENE_ENTER_CARD_DETAIL);
                str = "";
                AppMethodBeat.o(88758);
                return str;
            }
            k Gx = am.bbk().Gx(bVar.aZZ());
            if (Gx == null) {
                ab.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "get code is failure! db is  empty! doNetSceneGetDynamicQrcode! cardId= %s", bVar.aZZ());
                bbm.a(bVar, q.EN_DYNAMIC_CODE_SCENE_ENTER_CARD_DETAIL);
                str = "";
                AppMethodBeat.o(88758);
                return str;
            }
            k Gy = am.bbk().Gy(aZZ);
            if (Gy != null && am.bbk().dm(aZZ, Gy.field_code_id)) {
                bbm.a(aZZ, Gy.field_code_id, cVar);
            }
            bbm.exv = 0;
            ab.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "update current code showing! newQrCodeData cardId= %s,codeId=%s，refreshReason=%d", aZZ, Gx.field_code_id, Integer.valueOf(cVar.action));
            aZZ = bVar.aZZ();
            if (Gx == null) {
                str = "";
            } else {
                str = e.ds(aZZ, Gx.field_code);
                i Gv2 = am.bbl().Gv(aZZ);
                if (Gv2 == null || bo.isNullOrNil(str) || !Gv2.field_need_insert_show_timestamp || bo.isNullOrNil(Gv2.field_show_timestamp_encrypt_key)) {
                    ab.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "getCodeData only decrypt qrcode!");
                } else {
                    ab.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "getCodeData is need insert show timestamp! code signTimestamp!");
                    str = e.du(str, Gv2.field_show_timestamp_encrypt_key);
                }
            }
            if (bo.isNullOrNil(str)) {
                bbm.R(1, "");
                str = "";
                AppMethodBeat.o(88758);
                return str;
            }
            Gx.field_status = 1;
            if (am.bbk().c(Gx, "card_id", "code_id")) {
                ab.i("MicroMsg.CardQrCodeDataInfoStorage", "update qrCodeData  success! card_id = %s, code_id = %s ,status = %d", Gx.field_card_id, Gx.field_code_id, Integer.valueOf(Gx.field_status));
            } else {
                ab.e("MicroMsg.CardQrCodeDataInfoStorage", "update qrCodeData  failure! card_id = %s, code_id = %s ,status = %d", Gx.field_card_id, Gx.field_code_id, Integer.valueOf(Gx.field_status));
            }
            g bbm2 = am.bbm();
            i Gv3 = am.bbl().Gv(bVar.aZZ());
            if (Gv3 == null) {
                ab.e("MicroMsg.CardDynamicQrcodeOfflineMgr", "startRequestCodeTimer failure! CardQrCodeConfi is null!");
            } else {
                long j = (long) (Gv3.field_show_expire_interval * 1000);
                ab.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "startRefreshCodeTimer refreshTime: ".concat(String.valueOf(j)));
                bbm2.kba.ae(j, j);
            }
        }
        AppMethodBeat.o(88758);
        return str;
    }

    public final ab bey() {
        AppMethodBeat.i(88759);
        n nVar = new n(this, this.jiE);
        AppMethodBeat.o(88759);
        return nVar;
    }

    public final ab bez() {
        AppMethodBeat.i(88760);
        f fVar = new f(this, this.jiE);
        AppMethodBeat.o(88760);
        return fVar;
    }

    public final ab beA() {
        AppMethodBeat.i(88761);
        t tVar = new t(this, this.jiE);
        AppMethodBeat.o(88761);
        return tVar;
    }
}
