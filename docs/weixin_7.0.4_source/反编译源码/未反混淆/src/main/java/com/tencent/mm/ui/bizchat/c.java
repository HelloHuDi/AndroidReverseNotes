package com.tencent.mm.ui.bizchat;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.aj.a.e;
import com.tencent.mm.aj.z;
import com.tencent.mm.at.o;
import com.tencent.mm.pluginsdk.ui.e.j;
import com.tencent.mm.sdk.e.n;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMSlideDelView;
import com.tencent.mm.ui.base.MMSlideDelView.d;
import com.tencent.mm.ui.base.MMSlideDelView.f;
import com.tencent.mm.ui.base.MMSlideDelView.g;
import com.tencent.mm.ui.p;

public final class c extends p<com.tencent.mm.aj.a.c> implements b {
    private final MMActivity crP;
    private com.tencent.mm.at.a.a.c elH = null;
    protected g jJO;
    protected com.tencent.mm.ui.base.MMSlideDelView.c jJP;
    protected f jJQ;
    protected d jJR = MMSlideDelView.getItemStatusCallBack();
    private final String jMp;

    public static class a {
        public ImageView ejo;
        public TextView ejp;
    }

    public final /* synthetic */ Object a(Object obj, Cursor cursor) {
        AppMethodBeat.i(30106);
        com.tencent.mm.aj.a.c cVar = (com.tencent.mm.aj.a.c) obj;
        if (cVar == null) {
            cVar = new com.tencent.mm.aj.a.c();
        }
        cVar.d(cursor);
        AppMethodBeat.o(30106);
        return cVar;
    }

    public c(Context context, com.tencent.mm.ui.p.a aVar, String str) {
        super(context, new com.tencent.mm.aj.a.c());
        AppMethodBeat.i(30100);
        super.a(aVar);
        this.crP = (MMActivity) context;
        this.jMp = str;
        com.tencent.mm.at.a.a.c.a aVar2 = new com.tencent.mm.at.a.a.c.a();
        aVar2.ePK = e.cC(this.jMp);
        aVar2.ePH = true;
        aVar2.ePZ = true;
        aVar2.ePT = R.raw.default_avatar;
        this.elH = aVar2.ahG();
        AppMethodBeat.o(30100);
    }

    public final void KC() {
        AppMethodBeat.i(30101);
        bIf();
        com.tencent.mm.aj.a.d aeT = z.aeT();
        String str = this.jMp;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("select * from BizChatInfo");
        stringBuilder.append(" where brandUserName = '").append(str).append("'");
        stringBuilder.append(" and (bitFlag & 8) != 0 ");
        StringBuilder append = stringBuilder.append(" order by ");
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(" case when length(BizChatInfo.chatNamePY) > 0 then upper(BizChatInfo.chatNamePY) ");
        stringBuffer.append(" else upper(BizChatInfo.chatName) end asc, ");
        stringBuffer.append(" upper(BizChatInfo.chatNamePY) asc, ");
        stringBuffer.append(" upper(BizChatInfo.chatName) asc ");
        append.append(stringBuffer.toString());
        ab.d("MicroMsg.BizChatInfoStorage", "getBizChatFavCursor: sql:%s", stringBuilder.toString());
        setCursor(aeT.bSd.rawQuery(stringBuilder.toString(), null));
        if (this.yle != null) {
            this.yle.apt();
        }
        super.notifyDataSetChanged();
        AppMethodBeat.o(30101);
    }

    public final int getViewTypeCount() {
        return 1;
    }

    public final void setPerformItemClickListener(g gVar) {
        this.jJO = gVar;
    }

    public final void a(f fVar) {
        this.jJQ = fVar;
    }

    public final void setGetViewPositionCallback(com.tencent.mm.ui.base.MMSlideDelView.c cVar) {
        this.jJP = cVar;
    }

    public final int getItemViewType(int i) {
        return 0;
    }

    public final void onPause() {
        AppMethodBeat.i(30102);
        if (this.jJR != null) {
            this.jJR.bIp();
        }
        AppMethodBeat.o(30102);
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        AppMethodBeat.i(30103);
        com.tencent.mm.aj.a.c cVar = (com.tencent.mm.aj.a.c) getItem(i);
        if (view == null) {
            a aVar2 = new a();
            view = View.inflate(this.crP, R.layout.vj, null);
            aVar2.ejo = (ImageView) view.findViewById(R.id.qk);
            aVar2.ejp = (TextView) view.findViewById(R.id.rr);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        o.ahp().a(cVar.field_headImageUrl, aVar.ejo, this.elH);
        aVar.ejp.setText(j.b(this.crP, cVar.field_chatName, (int) aVar.ejp.getTextSize()));
        AppMethodBeat.o(30103);
        return view;
    }

    public final void KD() {
        AppMethodBeat.i(30104);
        KC();
        AppMethodBeat.o(30104);
    }

    public final void a(int i, n nVar, Object obj) {
        AppMethodBeat.i(30105);
        super.a(i, nVar, obj);
        AppMethodBeat.o(30105);
    }
}
