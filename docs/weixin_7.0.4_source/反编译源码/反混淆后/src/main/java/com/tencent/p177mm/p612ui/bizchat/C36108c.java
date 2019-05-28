package com.tencent.p177mm.p612ui.bizchat;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.p184aj.C41747z;
import com.tencent.p177mm.p184aj.p185a.C25754e;
import com.tencent.p177mm.p184aj.p185a.C37448d;
import com.tencent.p177mm.p184aj.p185a.C45142c;
import com.tencent.p177mm.p190at.C32291o;
import com.tencent.p177mm.p190at.p191a.p827a.C25814c;
import com.tencent.p177mm.p190at.p191a.p827a.C25814c.C17927a;
import com.tencent.p177mm.p612ui.C46692p;
import com.tencent.p177mm.p612ui.C46692p.C30723a;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.MMSlideDelView;
import com.tencent.p177mm.p612ui.base.MMSlideDelView.C15521c;
import com.tencent.p177mm.p612ui.base.MMSlideDelView.C23597d;
import com.tencent.p177mm.p612ui.base.MMSlideDelView.C23599f;
import com.tencent.p177mm.p612ui.base.MMSlideDelView.C23600g;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.sdk.p603e.C7298n;
import com.tencent.p177mm.sdk.p603e.C7298n.C4937b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.ui.bizchat.c */
public final class C36108c extends C46692p<C45142c> implements C4937b {
    private final MMActivity crP;
    private C25814c elH = null;
    protected C23600g jJO;
    protected C15521c jJP;
    protected C23599f jJQ;
    protected C23597d jJR = MMSlideDelView.getItemStatusCallBack();
    private final String jMp;

    /* renamed from: com.tencent.mm.ui.bizchat.c$a */
    public static class C30410a {
        public ImageView ejo;
        public TextView ejp;
    }

    /* renamed from: a */
    public final /* synthetic */ Object mo7687a(Object obj, Cursor cursor) {
        AppMethodBeat.m2504i(30106);
        C45142c c45142c = (C45142c) obj;
        if (c45142c == null) {
            c45142c = new C45142c();
        }
        c45142c.mo8995d(cursor);
        AppMethodBeat.m2505o(30106);
        return c45142c;
    }

    public C36108c(Context context, C30723a c30723a, String str) {
        super(context, new C45142c());
        AppMethodBeat.m2504i(30100);
        super.mo74992a(c30723a);
        this.crP = (MMActivity) context;
        this.jMp = str;
        C17927a c17927a = new C17927a();
        c17927a.ePK = C25754e.m40894cC(this.jMp);
        c17927a.ePH = true;
        c17927a.ePZ = true;
        c17927a.ePT = C1318a.default_avatar;
        this.elH = c17927a.ahG();
        AppMethodBeat.m2505o(30100);
    }

    /* renamed from: KC */
    public final void mo6869KC() {
        AppMethodBeat.m2504i(30101);
        bIf();
        C37448d aeT = C41747z.aeT();
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
        C4990ab.m7411d("MicroMsg.BizChatInfoStorage", "getBizChatFavCursor: sql:%s", stringBuilder.toString());
        setCursor(aeT.bSd.rawQuery(stringBuilder.toString(), null));
        if (this.yle != null) {
            this.yle.apt();
        }
        super.notifyDataSetChanged();
        AppMethodBeat.m2505o(30101);
    }

    public final int getViewTypeCount() {
        return 1;
    }

    public final void setPerformItemClickListener(C23600g c23600g) {
        this.jJO = c23600g;
    }

    /* renamed from: a */
    public final void mo56949a(C23599f c23599f) {
        this.jJQ = c23599f;
    }

    public final void setGetViewPositionCallback(C15521c c15521c) {
        this.jJP = c15521c;
    }

    public final int getItemViewType(int i) {
        return 0;
    }

    public final void onPause() {
        AppMethodBeat.m2504i(30102);
        if (this.jJR != null) {
            this.jJR.bIp();
        }
        AppMethodBeat.m2505o(30102);
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        C30410a c30410a;
        AppMethodBeat.m2504i(30103);
        C45142c c45142c = (C45142c) getItem(i);
        if (view == null) {
            C30410a c30410a2 = new C30410a();
            view = View.inflate(this.crP, 2130969401, null);
            c30410a2.ejo = (ImageView) view.findViewById(2131821183);
            c30410a2.ejp = (TextView) view.findViewById(2131821227);
            view.setTag(c30410a2);
            c30410a = c30410a2;
        } else {
            c30410a = (C30410a) view.getTag();
        }
        C32291o.ahp().mo43766a(c45142c.field_headImageUrl, c30410a.ejo, this.elH);
        c30410a.ejp.setText(C44089j.m79294b(this.crP, c45142c.field_chatName, (int) c30410a.ejp.getTextSize()));
        AppMethodBeat.m2505o(30103);
        return view;
    }

    /* renamed from: KD */
    public final void mo6870KD() {
        AppMethodBeat.m2504i(30104);
        mo6869KC();
        AppMethodBeat.m2505o(30104);
    }

    /* renamed from: a */
    public final void mo10136a(int i, C7298n c7298n, Object obj) {
        AppMethodBeat.m2504i(30105);
        super.mo10136a(i, c7298n, obj);
        AppMethodBeat.m2505o(30105);
    }
}
