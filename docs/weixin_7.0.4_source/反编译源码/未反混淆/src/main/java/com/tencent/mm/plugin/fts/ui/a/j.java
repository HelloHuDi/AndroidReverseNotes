package com.tencent.mm.plugin.fts.ui.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.a.c;
import com.tencent.mm.plugin.fts.a.a.d;
import com.tencent.mm.plugin.fts.a.a.l;
import com.tencent.mm.plugin.fts.a.f;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.fts.ui.m;

public final class j extends com.tencent.mm.plugin.fts.a.d.a.a {
    public int actionType = -1;
    public l hpS;
    public CharSequence mKK;
    public String mKL;
    public c mKM;
    private b mKN = new b();
    a mKO = new a();
    public CharSequence mnr;
    public String mnu;

    public class a extends com.tencent.mm.plugin.fts.a.d.a.a.a {
        public View contentView;
        public ImageView ejo;
        public TextView gnB;
        public TextView gnC;

        public a() {
            super();
        }
    }

    public class b extends com.tencent.mm.plugin.fts.a.d.a.a.b {
        public b() {
            super();
        }

        public final View a(Context context, ViewGroup viewGroup) {
            AppMethodBeat.i(62000);
            View inflate = LayoutInflater.from(context).inflate(R.layout.a18, viewGroup, false);
            a aVar = j.this.mKO;
            aVar.ejo = (ImageView) inflate.findViewById(R.id.qk);
            aVar.gnB = (TextView) inflate.findViewById(R.id.qm);
            aVar.gnC = (TextView) inflate.findViewById(R.id.ld);
            aVar.contentView = inflate.findViewById(R.id.qj);
            inflate.setTag(aVar);
            AppMethodBeat.o(62000);
            return inflate;
        }

        public final void a(Context context, com.tencent.mm.plugin.fts.a.d.a.a.a aVar, com.tencent.mm.plugin.fts.a.d.a.a aVar2, Object... objArr) {
            AppMethodBeat.i(62001);
            a aVar3 = (a) aVar;
            j jVar = (j) aVar2;
            m.p(aVar3.contentView, j.this.mFk);
            m.a(j.this.mnr, aVar3.gnB);
            m.a(j.this.mKK, aVar3.gnC);
            m.a(context, aVar3.ejo, null, jVar.mnu, (int) R.raw.fts_default_img);
            AppMethodBeat.o(62001);
        }

        public final boolean a(Context context, com.tencent.mm.plugin.fts.a.d.a.a aVar) {
            AppMethodBeat.i(62002);
            boolean a = ((n) g.M(n.class)).getItemClickHandler(j.this.klY).a(context, aVar);
            AppMethodBeat.o(62002);
            return a;
        }
    }

    public j(int i) {
        super(3, i);
        AppMethodBeat.i(62003);
        AppMethodBeat.o(62003);
    }

    /* JADX WARNING: Missing block: B:5:0x003d, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.o(62004);
     */
    /* JADX WARNING: Missing block: B:7:0x0042, code skipped:
            r5.mnr = com.tencent.mm.plugin.fts.a.f.a(com.tencent.mm.plugin.fts.a.a.d.a(r5.mnr, r5.mDz, r1, r0)).mDR;
            com.tencent.matrix.trace.core.AppMethodBeat.o(62004);
     */
    /* JADX WARNING: Missing block: B:12:?, code skipped:
            return;
     */
    /* JADX WARNING: Missing block: B:13:?, code skipped:
            return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(Context context, com.tencent.mm.plugin.fts.a.d.a.a.a aVar, Object... objArr) {
        boolean z = true;
        AppMethodBeat.i(62004);
        this.mKM = (c) this.hpS.userData;
        if (this.mKM != null) {
            this.mnr = this.mKM.field_title;
            this.mKK = this.mKM.field_tag;
            this.mnu = this.mKM.field_iconPath;
            this.mKL = this.mKM.field_androidUrl;
            this.actionType = this.mKM.field_actionType;
            boolean z2;
            switch (this.hpS.mDw) {
                case 1:
                    z = false;
                    z2 = false;
                    break;
                case 2:
                    z2 = false;
                    break;
                case 3:
                    z2 = true;
                    break;
                case 4:
                    this.mKK = f.a(d.a(this.mKK, this.mDz)).mDR;
                    break;
            }
        }
        AppMethodBeat.o(62004);
    }

    public final com.tencent.mm.plugin.fts.a.d.a.a.b Ps() {
        return this.mKN;
    }

    public final String aAp() {
        return this.mKM.field_title;
    }

    public final int aAq() {
        return this.hpS.mEK;
    }
}
