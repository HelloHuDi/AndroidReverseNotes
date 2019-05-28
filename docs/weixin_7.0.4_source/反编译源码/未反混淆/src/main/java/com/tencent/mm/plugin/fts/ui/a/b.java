package com.tencent.mm.plugin.fts.ui.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.fts.a.a.l;
import com.tencent.mm.plugin.fts.ui.m;
import com.tencent.mm.storage.ad;

public abstract class b extends com.tencent.mm.plugin.fts.a.d.a.a {
    public ad ehM;
    public l hpS;
    public CharSequence jMY;
    public CharSequence jMZ;
    public String mJU;
    a mJV = new a();
    public String username;

    public class a extends com.tencent.mm.plugin.fts.a.d.a.a.a {
        public View contentView;
        public ImageView ejo;
        public TextView gnB;
        public TextView gnC;
        TextView mJW;

        public a() {
            super();
        }
    }

    public abstract class b extends com.tencent.mm.plugin.fts.a.d.a.a.b {
        public b() {
            super();
        }

        public final View a(Context context, ViewGroup viewGroup) {
            View inflate = LayoutInflater.from(context).inflate(R.layout.a18, viewGroup, false);
            a aVar = b.this.mJV;
            aVar.ejo = (ImageView) inflate.findViewById(R.id.qk);
            aVar.gnB = (TextView) inflate.findViewById(R.id.qm);
            aVar.gnC = (TextView) inflate.findViewById(R.id.ld);
            aVar.mJW = (TextView) inflate.findViewById(R.id.by4);
            aVar.contentView = inflate.findViewById(R.id.qj);
            inflate.setTag(aVar);
            return inflate;
        }

        public final void a(Context context, com.tencent.mm.plugin.fts.a.d.a.a.a aVar, com.tencent.mm.plugin.fts.a.d.a.a aVar2, Object... objArr) {
            a aVar3 = (a) aVar;
            b bVar = (b) aVar2;
            m.p(aVar3.contentView, b.this.mFk);
            com.tencent.mm.pluginsdk.ui.a.b.b(aVar3.ejo, bVar.username);
            m.a(bVar.jMY, aVar3.gnB);
            m.a(bVar.jMZ, aVar3.gnC);
            m.b(bVar.mJU, aVar3.mJW);
        }
    }

    public b(int i) {
        super(1, i);
    }

    public final int aAq() {
        return this.hpS.mEK;
    }
}
