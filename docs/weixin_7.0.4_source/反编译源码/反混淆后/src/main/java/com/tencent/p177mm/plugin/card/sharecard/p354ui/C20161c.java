package com.tencent.p177mm.plugin.card.sharecard.p354ui;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.C46692p;
import com.tencent.p177mm.plugin.card.base.C45773c;
import com.tencent.p177mm.plugin.card.model.C33771n.C11290a;
import com.tencent.p177mm.plugin.card.model.C42852am;
import com.tencent.p177mm.plugin.card.sharecard.model.C20155k;
import com.tencent.p177mm.plugin.card.sharecard.model.ShareCardInfo;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.card.sharecard.ui.c */
public final class C20161c extends C46692p<ShareCardInfo> {
    private final String TAG = "MicroMsg.ShareCardAdatper";
    long beginTime = 0;
    long endTime = 0;
    private int kgV = 0;
    C45773c kgW;
    private int kgX = -1;

    /* renamed from: a */
    public final /* synthetic */ Object mo7687a(Object obj, Cursor cursor) {
        AppMethodBeat.m2504i(88145);
        obj = (ShareCardInfo) obj;
        if (obj == null) {
            obj = new ShareCardInfo();
        }
        if (cursor.isClosed()) {
            C4990ab.m7412e("MicroMsg.ShareCardAdatper", "cursor is closed!");
            AppMethodBeat.m2505o(88145);
        } else {
            obj.mo8995d(cursor);
            AppMethodBeat.m2505o(88145);
        }
        return obj;
    }

    public C20161c(Context context) {
        super(context, new ShareCardInfo());
        AppMethodBeat.m2504i(88140);
        mo74996pN(true);
        this.kgW = new C38756j(context, this);
        AppMethodBeat.m2505o(88140);
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        AppMethodBeat.m2504i(88141);
        View a = this.kgW.mo6879a(i, view, (ShareCardInfo) getItem(i));
        AppMethodBeat.m2505o(88141);
        return a;
    }

    /* renamed from: KC */
    public final void mo6869KC() {
        Cursor rawQuery;
        AppMethodBeat.m2504i(88142);
        this.beginTime = System.currentTimeMillis();
        if (this.kgX == -1) {
            C20155k bbe = C42852am.bbe();
            C11290a c11290a = C11290a.NORMAL_TYPE;
            StringBuilder stringBuilder = new StringBuilder();
            switch (c11290a) {
                case NORMAL_TYPE:
                    stringBuilder.append(" where (status=0 OR status=5)");
                    break;
                case INVALID_TYPE:
                    stringBuilder.append(" where (status=1 OR status=2 OR status=3 OR status=4 OR status=6)");
                    break;
                case CAN_GIFT_TYPE:
                    stringBuilder.append(" where (status=0 OR status=5) and (block_mask= '1' OR block_mask= '0' )");
                    break;
            }
            rawQuery = bbe.bSd.rawQuery("select * from ShareCardInfo" + stringBuilder.toString() + " order by status asc , share_time desc", null);
        } else {
            C20155k bbe2 = C42852am.bbe();
            int i = this.kgX;
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(" where ( status=0) ");
            String str = "";
            switch (i) {
                case 1:
                    stringBuilder2.append(" AND ");
                    stringBuilder2.append(" (");
                    stringBuilder2.append(C20155k.m31174sT(1));
                    stringBuilder2.append(" categoryType= '10' ");
                    stringBuilder2.append(") ");
                    str = " order by categoryType desc , itemIndex asc";
                    break;
                case 2:
                    stringBuilder2.append(" AND (");
                    stringBuilder2.append(" (");
                    stringBuilder2.append(C20155k.m31174sT(1));
                    stringBuilder2.append(" categoryType= '10' ");
                    stringBuilder2.append(") ");
                    stringBuilder2.append(" OR (");
                    stringBuilder2.append(C20155k.m31174sT(2));
                    stringBuilder2.append(" categoryType= '0' ");
                    stringBuilder2.append(") ");
                    stringBuilder2.append(" )");
                    str = " order by categoryType desc , itemIndex asc";
                    break;
                case 3:
                    stringBuilder2.append(" AND ");
                    stringBuilder2.append(" (");
                    stringBuilder2.append(C20155k.m31174sT(2));
                    stringBuilder2.append(" categoryType= '0' ");
                    stringBuilder2.append(") ");
                    str = " order by categoryType desc , itemIndex asc";
                    break;
                case 4:
                    stringBuilder2.append(" AND 1 != 1 ");
                    break;
            }
            rawQuery = bbe2.bSd.rawQuery("select * from ShareCardInfo" + stringBuilder2.toString() + str, null);
        }
        if (rawQuery != null) {
            this.kgV = rawQuery.getCount();
            C4990ab.m7417i("MicroMsg.ShareCardAdatper", "resetCursor showType %s, card count:%s", Integer.valueOf(this.kgX), Integer.valueOf(this.kgV));
        } else {
            C4990ab.m7413e("MicroMsg.ShareCardAdatper", "resetCursor cursor is null, showType %s", Integer.valueOf(this.kgX));
        }
        setCursor(rawQuery);
        this.endTime = System.currentTimeMillis();
        notifyDataSetChanged();
        AppMethodBeat.m2505o(88142);
    }

    /* renamed from: KD */
    public final void mo6870KD() {
        AppMethodBeat.m2504i(88143);
        bIf();
        mo6869KC();
        AppMethodBeat.m2505o(88143);
    }

    /* renamed from: sX */
    public final void mo35406sX(int i) {
        AppMethodBeat.m2504i(88144);
        this.kgX = i;
        mo5248a(null, null);
        AppMethodBeat.m2505o(88144);
    }
}
