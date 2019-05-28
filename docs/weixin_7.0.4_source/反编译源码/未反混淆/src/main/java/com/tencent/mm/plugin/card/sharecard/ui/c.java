package com.tencent.mm.plugin.card.sharecard.ui;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.model.n.a;
import com.tencent.mm.plugin.card.sharecard.model.ShareCardInfo;
import com.tencent.mm.plugin.card.sharecard.model.k;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.p;

public final class c extends p<ShareCardInfo> {
    private final String TAG = "MicroMsg.ShareCardAdatper";
    long beginTime = 0;
    long endTime = 0;
    private int kgV = 0;
    com.tencent.mm.plugin.card.base.c kgW;
    private int kgX = -1;

    public final /* synthetic */ Object a(Object obj, Cursor cursor) {
        AppMethodBeat.i(88145);
        obj = (ShareCardInfo) obj;
        if (obj == null) {
            obj = new ShareCardInfo();
        }
        if (cursor.isClosed()) {
            ab.e("MicroMsg.ShareCardAdatper", "cursor is closed!");
            AppMethodBeat.o(88145);
        } else {
            obj.d(cursor);
            AppMethodBeat.o(88145);
        }
        return obj;
    }

    public c(Context context) {
        super(context, new ShareCardInfo());
        AppMethodBeat.i(88140);
        pN(true);
        this.kgW = new j(context, this);
        AppMethodBeat.o(88140);
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        AppMethodBeat.i(88141);
        View a = this.kgW.a(i, view, (ShareCardInfo) getItem(i));
        AppMethodBeat.o(88141);
        return a;
    }

    public final void KC() {
        Cursor rawQuery;
        AppMethodBeat.i(88142);
        this.beginTime = System.currentTimeMillis();
        if (this.kgX == -1) {
            k bbe = am.bbe();
            a aVar = a.NORMAL_TYPE;
            StringBuilder stringBuilder = new StringBuilder();
            switch (aVar) {
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
            k bbe2 = am.bbe();
            int i = this.kgX;
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(" where ( status=0) ");
            String str = "";
            switch (i) {
                case 1:
                    stringBuilder2.append(" AND ");
                    stringBuilder2.append(" (");
                    stringBuilder2.append(k.sT(1));
                    stringBuilder2.append(" categoryType= '10' ");
                    stringBuilder2.append(") ");
                    str = " order by categoryType desc , itemIndex asc";
                    break;
                case 2:
                    stringBuilder2.append(" AND (");
                    stringBuilder2.append(" (");
                    stringBuilder2.append(k.sT(1));
                    stringBuilder2.append(" categoryType= '10' ");
                    stringBuilder2.append(") ");
                    stringBuilder2.append(" OR (");
                    stringBuilder2.append(k.sT(2));
                    stringBuilder2.append(" categoryType= '0' ");
                    stringBuilder2.append(") ");
                    stringBuilder2.append(" )");
                    str = " order by categoryType desc , itemIndex asc";
                    break;
                case 3:
                    stringBuilder2.append(" AND ");
                    stringBuilder2.append(" (");
                    stringBuilder2.append(k.sT(2));
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
            ab.i("MicroMsg.ShareCardAdatper", "resetCursor showType %s, card count:%s", Integer.valueOf(this.kgX), Integer.valueOf(this.kgV));
        } else {
            ab.e("MicroMsg.ShareCardAdatper", "resetCursor cursor is null, showType %s", Integer.valueOf(this.kgX));
        }
        setCursor(rawQuery);
        this.endTime = System.currentTimeMillis();
        notifyDataSetChanged();
        AppMethodBeat.o(88142);
    }

    public final void KD() {
        AppMethodBeat.i(88143);
        bIf();
        KC();
        AppMethodBeat.o(88143);
    }

    public final void sX(int i) {
        AppMethodBeat.i(88144);
        this.kgX = i;
        a(null, null);
        AppMethodBeat.o(88144);
    }
}
