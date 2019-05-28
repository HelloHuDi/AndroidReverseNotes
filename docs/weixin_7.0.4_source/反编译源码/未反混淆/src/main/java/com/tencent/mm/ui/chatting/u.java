package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.c;
import com.tencent.mm.model.s;
import com.tencent.mm.platformtools.ah;
import com.tencent.mm.pluginsdk.f.h;
import com.tencent.mm.pluginsdk.ui.e.j;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.p;

public final class u extends p<bi> {
    private String fsg;
    private String mHZ;
    public String talker;
    private boolean yFW;
    public a yKp;

    static class b {
        public ImageView ejo;
        public TextView ejp;
        public TextView jJT;
        public TextView yKq;

        private b() {
        }

        /* synthetic */ b(byte b) {
            this();
        }
    }

    public interface a {
        void Oo(int i);
    }

    public final /* synthetic */ Object a(Object obj, Cursor cursor) {
        AppMethodBeat.i(30759);
        bi biVar = (bi) obj;
        if (biVar == null) {
            biVar = new bi();
        }
        biVar.d(cursor);
        AppMethodBeat.o(30759);
        return biVar;
    }

    public u(Context context, bi biVar, String str, String str2, boolean z) {
        super(context, biVar);
        this.talker = str;
        this.fsg = str2;
        this.yFW = z;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        AppMethodBeat.i(30754);
        if (view == null) {
            view = View.inflate(this.context, R.layout.apy, null);
            bVar = new b();
            bVar.ejo = (ImageView) view.findViewById(R.id.qk);
            bVar.ejp = (TextView) view.findViewById(R.id.b6e);
            bVar.jJT = (TextView) view.findViewById(R.id.b6f);
            bVar.yKq = (TextView) view.findViewById(R.id.b01);
            view.setTag(bVar);
        } else {
            bVar = (b) view.getTag();
        }
        bi biVar = (bi) getItem(i);
        if (biVar != null) {
            if (this.yFW && biVar.field_isSend == 0) {
                String str = biVar.field_content;
                String oy = bf.oy(str);
                if (!ah.isNullOrNil(oy)) {
                    com.tencent.mm.pluginsdk.ui.a.b.b(bVar.ejo, oy);
                    bVar.ejp.setText(j.b(this.context, s.mJ(oy), bVar.ejp.getTextSize()));
                }
                bVar.jJT.setText(aK(biVar));
                bVar.yKq.setText(j.b(this.context, bf.oz(str), bVar.yKq.getTextSize()));
            } else {
                com.tencent.mm.pluginsdk.ui.a.b.b(bVar.ejo, aJ(biVar));
                bVar.ejp.setText(j.b(this.context, s.mJ(aJ(biVar)), bVar.ejp.getTextSize()));
                bVar.jJT.setText(aK(biVar));
                bVar.yKq.setText(j.b(this.context, biVar.field_content, bVar.yKq.getTextSize()));
            }
        }
        AppMethodBeat.o(30754);
        return view;
    }

    public final void vM(String str) {
        AppMethodBeat.i(30755);
        this.mHZ = str;
        if (!ah.isNullOrNil(this.mHZ)) {
            bIf();
            KC();
        }
        AppMethodBeat.o(30755);
    }

    public final void KC() {
        AppMethodBeat.i(30756);
        aw.ZK();
        setCursor(c.XO().fb(this.talker, this.mHZ));
        if (!(this.yKp == null || ah.isNullOrNil(this.mHZ))) {
            this.yKp.Oo(getCount());
        }
        super.notifyDataSetChanged();
        AppMethodBeat.o(30756);
    }

    public final void KD() {
        AppMethodBeat.i(30757);
        bIf();
        KC();
        AppMethodBeat.o(30757);
    }

    private String aJ(bi biVar) {
        return biVar.field_isSend == 1 ? this.fsg : this.talker;
    }

    private CharSequence aK(bi biVar) {
        AppMethodBeat.i(30758);
        if (biVar.field_createTime == Long.MAX_VALUE) {
            String str = "";
            AppMethodBeat.o(30758);
            return str;
        }
        CharSequence c = h.c(this.context, biVar.field_createTime, true);
        AppMethodBeat.o(30758);
        return c;
    }
}
