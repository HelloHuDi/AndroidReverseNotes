package com.tencent.mm.plugin.card.model;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.card.model.n.a;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac;
import java.util.ArrayList;
import java.util.List;

public final class c extends j<CardInfo> {
    public static final String[] fnj = new String[]{j.a(CardInfo.ccO, "UserCardInfo"), "CREATE INDEX IF NOT EXISTS  stickyIndexIndex ON UserCardInfo ( stickyIndex ) "};
    public e bSd;

    static {
        AppMethodBeat.i(87828);
        AppMethodBeat.o(87828);
    }

    public c(e eVar) {
        super(eVar, CardInfo.ccO, "UserCardInfo", null);
        this.bSd = eVar;
    }

    public final CardInfo Gu(String str) {
        AppMethodBeat.i(87826);
        com.tencent.mm.sdk.e.c cardInfo = new CardInfo();
        cardInfo.field_card_id = str;
        if (super.b(cardInfo, new String[0])) {
            AppMethodBeat.o(87826);
            return cardInfo;
        }
        AppMethodBeat.o(87826);
        return null;
    }

    public final List<CardInfo> baL() {
        AppMethodBeat.i(87827);
        Cursor rawQuery = this.bSd.rawQuery("select * from UserCardInfo where is_dynamic=?", new String[]{"1"});
        if (rawQuery == null) {
            ab.e("MicroMsg.CardInfoStorage", "getCardInfoList by is_dynamic is failure! cu is null!");
            AppMethodBeat.o(87827);
            return null;
        }
        List<CardInfo> arrayList = new ArrayList();
        while (rawQuery.moveToNext()) {
            try {
                CardInfo cardInfo = new CardInfo();
                cardInfo.d(rawQuery);
                arrayList.add(cardInfo);
            } catch (Exception e) {
                ab.e("MicroMsg.CardInfoStorage", "getCardInfoList by is_dynamic is failure! is_dynamic = true", e.getMessage());
                rawQuery.close();
            } catch (Throwable th) {
                rawQuery.close();
                AppMethodBeat.o(87827);
            }
        }
        rawQuery.close();
        AppMethodBeat.o(87827);
        return arrayList;
    }

    public final Cursor a(a aVar) {
        AppMethodBeat.i(87825);
        this.bSd.hY("UserCardInfo", "update UserCardInfo set stickyIndex=0, stickyEndTime=0 where stickyIndex>0 and (" + bo.anT() + ">stickyEndTime and stickyEndTime<>0)");
        StringBuilder stringBuilder = new StringBuilder("select * from UserCardInfo");
        switch (aVar) {
            case NORMAL_TYPE:
                stringBuilder.append(" where (status=0 OR status=5)");
                break;
            case MEMBER_CARD_TYPE:
            case HOME_MEMBER_CARD_TYPE:
                stringBuilder.append(" where (status=0 OR status=5) AND card_type=10");
                break;
            case GENERAL_TYPE:
                stringBuilder.append(" where (status=0 OR status=5) AND card_type!=10");
                break;
            case GENERAL_WITHOUT_INVOICE_TYPE:
                stringBuilder.append(" where (status=0 OR status=5) AND card_type!=10 AND card_type!=30");
                break;
            case INVALID_TYPE:
                stringBuilder.append(" where (status=1 OR status=2 OR status=3 OR status=4 OR status=6)");
                break;
            case CAN_GIFT_TYPE:
                stringBuilder.append(" where (status=0 OR status=5) and (block_mask= '1' OR block_mask= '0' )");
                break;
        }
        stringBuilder.append(" order by stickyIndex desc, status asc , updateTime desc");
        if (aVar == a.HOME_MEMBER_CARD_TYPE) {
            stringBuilder.append(" LIMIT ").append(((Integer) g.RP().Ry().get(ac.a.USERINFO_CARD_HOME_PAGE_CARD_NUM_INT_SYNC, Integer.valueOf(3))).intValue());
        }
        Cursor rawQuery = this.bSd.rawQuery(stringBuilder.toString(), null);
        AppMethodBeat.o(87825);
        return rawQuery;
    }
}
