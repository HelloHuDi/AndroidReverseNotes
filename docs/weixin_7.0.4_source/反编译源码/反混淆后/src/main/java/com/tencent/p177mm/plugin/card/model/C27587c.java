package com.tencent.p177mm.plugin.card.model;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.plugin.card.model.C33771n.C11290a;
import com.tencent.p177mm.sdk.p603e.C4925c;
import com.tencent.p177mm.sdk.p603e.C4927e;
import com.tencent.p177mm.sdk.p603e.C7563j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.card.model.c */
public final class C27587c extends C7563j<CardInfo> {
    public static final String[] fnj = new String[]{C7563j.m13217a(CardInfo.ccO, "UserCardInfo"), "CREATE INDEX IF NOT EXISTS  stickyIndexIndex ON UserCardInfo ( stickyIndex ) "};
    public C4927e bSd;

    static {
        AppMethodBeat.m2504i(87828);
        AppMethodBeat.m2505o(87828);
    }

    public C27587c(C4927e c4927e) {
        super(c4927e, CardInfo.ccO, "UserCardInfo", null);
        this.bSd = c4927e;
    }

    /* renamed from: Gu */
    public final CardInfo mo45383Gu(String str) {
        AppMethodBeat.m2504i(87826);
        C4925c cardInfo = new CardInfo();
        cardInfo.field_card_id = str;
        if (super.mo10102b(cardInfo, new String[0])) {
            AppMethodBeat.m2505o(87826);
            return cardInfo;
        }
        AppMethodBeat.m2505o(87826);
        return null;
    }

    public final List<CardInfo> baL() {
        AppMethodBeat.m2504i(87827);
        Cursor rawQuery = this.bSd.rawQuery("select * from UserCardInfo where is_dynamic=?", new String[]{"1"});
        if (rawQuery == null) {
            C4990ab.m7412e("MicroMsg.CardInfoStorage", "getCardInfoList by is_dynamic is failure! cu is null!");
            AppMethodBeat.m2505o(87827);
            return null;
        }
        List<CardInfo> arrayList = new ArrayList();
        while (rawQuery.moveToNext()) {
            try {
                CardInfo cardInfo = new CardInfo();
                cardInfo.mo8995d(rawQuery);
                arrayList.add(cardInfo);
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.CardInfoStorage", "getCardInfoList by is_dynamic is failure! is_dynamic = true", e.getMessage());
                rawQuery.close();
            } catch (Throwable th) {
                rawQuery.close();
                AppMethodBeat.m2505o(87827);
            }
        }
        rawQuery.close();
        AppMethodBeat.m2505o(87827);
        return arrayList;
    }

    /* renamed from: a */
    public final Cursor mo45384a(C11290a c11290a) {
        AppMethodBeat.m2504i(87825);
        this.bSd.mo10108hY("UserCardInfo", "update UserCardInfo set stickyIndex=0, stickyEndTime=0 where stickyIndex>0 and (" + C5046bo.anT() + ">stickyEndTime and stickyEndTime<>0)");
        StringBuilder stringBuilder = new StringBuilder("select * from UserCardInfo");
        switch (c11290a) {
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
        if (c11290a == C11290a.HOME_MEMBER_CARD_TYPE) {
            stringBuilder.append(" LIMIT ").append(((Integer) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_CARD_HOME_PAGE_CARD_NUM_INT_SYNC, Integer.valueOf(3))).intValue());
        }
        Cursor rawQuery = this.bSd.rawQuery(stringBuilder.toString(), null);
        AppMethodBeat.m2505o(87825);
        return rawQuery;
    }
}
