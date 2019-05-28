package com.tencent.p177mm.p612ui.chatting;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C1829bf;
import com.tencent.p177mm.model.C1854s;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p612ui.C46692p;
import com.tencent.p177mm.platformtools.C42252ah;
import com.tencent.p177mm.pluginsdk.p1079f.C14835h;
import com.tencent.p177mm.pluginsdk.p597ui.C40459a.C40460b;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.storage.C7620bi;

/* renamed from: com.tencent.mm.ui.chatting.u */
public final class C44329u extends C46692p<C7620bi> {
    private String fsg;
    private String mHZ;
    public String talker;
    private boolean yFW;
    public C30575a yKp;

    /* renamed from: com.tencent.mm.ui.chatting.u$b */
    static class C23814b {
        public ImageView ejo;
        public TextView ejp;
        public TextView jJT;
        public TextView yKq;

        private C23814b() {
        }

        /* synthetic */ C23814b(byte b) {
            this();
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.u$a */
    public interface C30575a {
        /* renamed from: Oo */
        void mo27762Oo(int i);
    }

    /* renamed from: a */
    public final /* synthetic */ Object mo7687a(Object obj, Cursor cursor) {
        AppMethodBeat.m2504i(30759);
        C7620bi c7620bi = (C7620bi) obj;
        if (c7620bi == null) {
            c7620bi = new C7620bi();
        }
        c7620bi.mo8995d(cursor);
        AppMethodBeat.m2505o(30759);
        return c7620bi;
    }

    public C44329u(Context context, C7620bi c7620bi, String str, String str2, boolean z) {
        super(context, c7620bi);
        this.talker = str;
        this.fsg = str2;
        this.yFW = z;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        C23814b c23814b;
        AppMethodBeat.m2504i(30754);
        if (view == null) {
            view = View.inflate(this.context, 2130970566, null);
            c23814b = new C23814b();
            c23814b.ejo = (ImageView) view.findViewById(2131821183);
            c23814b.ejp = (TextView) view.findViewById(2131823149);
            c23814b.jJT = (TextView) view.findViewById(2131823150);
            c23814b.yKq = (TextView) view.findViewById(2131822913);
            view.setTag(c23814b);
        } else {
            c23814b = (C23814b) view.getTag();
        }
        C7620bi c7620bi = (C7620bi) getItem(i);
        if (c7620bi != null) {
            if (this.yFW && c7620bi.field_isSend == 0) {
                String str = c7620bi.field_content;
                String oy = C1829bf.m3762oy(str);
                if (!C42252ah.isNullOrNil(oy)) {
                    C40460b.m69434b(c23814b.ejo, oy);
                    c23814b.ejp.setText(C44089j.m79293b(this.context, C1854s.m3866mJ(oy), c23814b.ejp.getTextSize()));
                }
                c23814b.jJT.setText(m80113aK(c7620bi));
                c23814b.yKq.setText(C44089j.m79293b(this.context, C1829bf.m3763oz(str), c23814b.yKq.getTextSize()));
            } else {
                C40460b.m69434b(c23814b.ejo, m80112aJ(c7620bi));
                c23814b.ejp.setText(C44089j.m79293b(this.context, C1854s.m3866mJ(m80112aJ(c7620bi)), c23814b.ejp.getTextSize()));
                c23814b.jJT.setText(m80113aK(c7620bi));
                c23814b.yKq.setText(C44089j.m79293b(this.context, c7620bi.field_content, c23814b.yKq.getTextSize()));
            }
        }
        AppMethodBeat.m2505o(30754);
        return view;
    }

    /* renamed from: vM */
    public final void mo70200vM(String str) {
        AppMethodBeat.m2504i(30755);
        this.mHZ = str;
        if (!C42252ah.isNullOrNil(this.mHZ)) {
            bIf();
            mo6869KC();
        }
        AppMethodBeat.m2505o(30755);
    }

    /* renamed from: KC */
    public final void mo6869KC() {
        AppMethodBeat.m2504i(30756);
        C9638aw.m17190ZK();
        setCursor(C18628c.m29080XO().mo15332fb(this.talker, this.mHZ));
        if (!(this.yKp == null || C42252ah.isNullOrNil(this.mHZ))) {
            this.yKp.mo27762Oo(getCount());
        }
        super.notifyDataSetChanged();
        AppMethodBeat.m2505o(30756);
    }

    /* renamed from: KD */
    public final void mo6870KD() {
        AppMethodBeat.m2504i(30757);
        bIf();
        mo6869KC();
        AppMethodBeat.m2505o(30757);
    }

    /* renamed from: aJ */
    private String m80112aJ(C7620bi c7620bi) {
        return c7620bi.field_isSend == 1 ? this.fsg : this.talker;
    }

    /* renamed from: aK */
    private CharSequence m80113aK(C7620bi c7620bi) {
        AppMethodBeat.m2504i(30758);
        if (c7620bi.field_createTime == Long.MAX_VALUE) {
            String str = "";
            AppMethodBeat.m2505o(30758);
            return str;
        }
        CharSequence c = C14835h.m23089c(this.context, c7620bi.field_createTime, true);
        AppMethodBeat.m2505o(30758);
        return c;
    }
}
