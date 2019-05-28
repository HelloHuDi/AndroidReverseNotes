package com.tencent.mm.ui.bizchat;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.at.a.a.c;
import com.tencent.mm.at.o;
import com.tencent.mm.plugin.fts.ui.m;
import com.tencent.mm.pluginsdk.ui.e.j;
import java.util.HashMap;
import java.util.Map;

public final class a extends com.tencent.mm.ui.contact.a.a {
    private static Map<String, c> yDP = new HashMap();
    public CharSequence gnx;
    public long jMj = -1;
    public String username;
    public String yDO;
    private b yDQ = new b();
    a yDR = new a();

    public class a extends com.tencent.mm.ui.contact.a.a.a {
        public ImageView ejo;
        public TextView ejp;
        public TextView gnC;

        public a() {
            super();
        }
    }

    public class b extends com.tencent.mm.ui.contact.a.a.b {
        public b() {
            super();
        }

        public final View a(Context context, ViewGroup viewGroup) {
            View inflate;
            AppMethodBeat.i(105184);
            if (com.tencent.mm.bz.a.ga(context)) {
                inflate = LayoutInflater.from(context).inflate(R.layout.ar1, viewGroup, false);
            } else {
                inflate = LayoutInflater.from(context).inflate(R.layout.ar0, viewGroup, false);
            }
            a aVar = a.this.yDR;
            aVar.ejo = (ImageView) inflate.findViewById(R.id.qk);
            aVar.ejp = (TextView) inflate.findViewById(R.id.qm);
            aVar.gnC = (TextView) inflate.findViewById(R.id.ld);
            aVar.gnC.setVisibility(8);
            inflate.setTag(aVar);
            AppMethodBeat.o(105184);
            return inflate;
        }

        public final void a(Context context, com.tencent.mm.ui.contact.a.a.a aVar, com.tencent.mm.ui.contact.a.a aVar2, boolean z, boolean z2) {
            AppMethodBeat.i(105185);
            a aVar3 = (a) aVar2;
            a aVar4 = (a) aVar;
            m.a(aVar3.gnx, aVar4.ejp);
            o.ahp().a(aVar3.yDO, aVar4.ejo, a.aqU(aVar3.username));
            AppMethodBeat.o(105185);
        }

        public final boolean aov() {
            return false;
        }
    }

    static {
        AppMethodBeat.i(105189);
        AppMethodBeat.o(105189);
    }

    public a(int i) {
        super(4, i);
        AppMethodBeat.i(105186);
        AppMethodBeat.o(105186);
    }

    public final void a(Context context, com.tencent.mm.ui.contact.a.a.a aVar) {
        AppMethodBeat.i(105187);
        this.gnx = j.b(context, this.gnx, com.tencent.mm.bz.a.al(context, R.dimen.m5));
        AppMethodBeat.o(105187);
    }

    public final com.tencent.mm.ui.contact.a.a.b aou() {
        return this.yDQ;
    }

    static /* synthetic */ c aqU(String str) {
        AppMethodBeat.i(105188);
        c ahG;
        if (str == null) {
            AppMethodBeat.o(105188);
            return null;
        } else if (!yDP.containsKey(str) || yDP.get(str) == null) {
            com.tencent.mm.at.a.a.c.a aVar = new com.tencent.mm.at.a.a.c.a();
            aVar.ePK = com.tencent.mm.api.a.cC(str);
            aVar.ePH = true;
            aVar.ePZ = true;
            aVar.ePT = R.raw.default_avatar;
            ahG = aVar.ahG();
            yDP.put(str, ahG);
            AppMethodBeat.o(105188);
            return ahG;
        } else {
            ahG = (c) yDP.get(str);
            AppMethodBeat.o(105188);
            return ahG;
        }
    }
}
