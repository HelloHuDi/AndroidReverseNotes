package com.tencent.mm.ui.contact.a;

import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.fts.a.a.l;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.fts.ui.m;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ad;
import java.util.regex.Pattern;

public final class c extends a {
    private static final Pattern zpF = Pattern.compile(";");
    public CharSequence gnx;
    public CharSequence gny;
    public l hpS;
    public String username;
    public CharSequence zpG;
    private b zpH = new b();
    a zpI = new a();

    public class a extends com.tencent.mm.ui.contact.a.a.a {
        public View contentView;
        public ImageView ejo;
        public TextView gnB;
        public TextView gnC;
        public CheckBox gnD;
        public TextView mJS;

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
            AppMethodBeat.i(105270);
            if (com.tencent.mm.bz.a.ga(context)) {
                inflate = LayoutInflater.from(context).inflate(R.layout.ar1, viewGroup, false);
            } else {
                inflate = LayoutInflater.from(context).inflate(R.layout.ar0, viewGroup, false);
            }
            a aVar = c.this.zpI;
            aVar.ejo = (ImageView) inflate.findViewById(R.id.qk);
            aVar.gnB = (TextView) inflate.findViewById(R.id.qm);
            aVar.gnB.setMaxWidth(com.tencent.mm.bz.a.fromDPToPix(context, 200));
            aVar.gnC = (TextView) inflate.findViewById(R.id.ld);
            aVar.mJS = (TextView) inflate.findViewById(R.id.n0);
            aVar.contentView = inflate.findViewById(R.id.de9);
            aVar.gnD = (CheckBox) inflate.findViewById(R.id.a1b);
            if (c.this.jLx) {
                aVar.contentView.setBackgroundResource(R.drawable.k7);
            }
            inflate.setTag(aVar);
            AppMethodBeat.o(105270);
            return inflate;
        }

        public final void a(Context context, com.tencent.mm.ui.contact.a.a.a aVar, a aVar2, boolean z, boolean z2) {
            AppMethodBeat.i(105271);
            a aVar3 = (a) aVar;
            c cVar = (c) aVar2;
            if (cVar.username == null || cVar.username.length() <= 0) {
                aVar3.ejo.setImageResource(R.drawable.ad2);
            } else {
                com.tencent.mm.pluginsdk.ui.a.b.a(aVar3.ejo, cVar.username, 0.1f, false);
            }
            m.a(cVar.gnx, aVar3.gnB);
            if (t.mP(cVar.username)) {
                Drawable drawable = context.getResources().getDrawable(R.raw.open_im_main_logo);
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                aVar3.gnB.setCompoundDrawablesWithIntrinsicBounds(null, null, drawable, null);
            } else {
                aVar3.gnB.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
            }
            m.a(cVar.gny, aVar3.gnC);
            m.a(cVar.zpG, aVar3.mJS);
            if (c.this.zmW) {
                if (z) {
                    aVar3.gnD.setChecked(true);
                    aVar3.gnD.setEnabled(false);
                } else {
                    aVar3.gnD.setChecked(z2);
                    aVar3.gnD.setEnabled(true);
                }
                aVar3.gnD.setVisibility(0);
                AppMethodBeat.o(105271);
                return;
            }
            aVar3.gnD.setVisibility(8);
            AppMethodBeat.o(105271);
        }

        public final boolean aov() {
            AppMethodBeat.i(105272);
            if (c.this.hpS != null) {
                ((n) g.M(n.class)).updateTopHitsRank(c.this.query, c.this.hpS, 1);
            }
            AppMethodBeat.o(105272);
            return false;
        }
    }

    static {
        AppMethodBeat.i(105275);
        AppMethodBeat.o(105275);
    }

    public c(int i) {
        super(3, i);
        AppMethodBeat.i(105273);
        AppMethodBeat.o(105273);
    }

    /* JADX WARNING: Missing block: B:16:0x008c, code skipped:
            if (r1 == 0) goto L_0x0132;
     */
    /* JADX WARNING: Missing block: B:17:0x008e, code skipped:
            r12.gnx = com.tencent.mm.pluginsdk.ui.e.j.b(r13, r7, com.tencent.mm.bz.a.al(r13, com.tencent.mm.R.dimen.kr));
            r12.gnx = com.tencent.mm.plugin.fts.a.f.a(com.tencent.mm.plugin.fts.a.a.d.a(r12.gnx, r12.mDz, r3, r0)).mDR;
     */
    /* JADX WARNING: Missing block: B:18:0x00ab, code skipped:
            r12.gny = r4;
            com.tencent.matrix.trace.core.AppMethodBeat.o(105274);
     */
    /* JADX WARNING: Missing block: B:20:0x00b2, code skipped:
            r0 = r2;
            r3 = true;
     */
    /* JADX WARNING: Missing block: B:21:0x00b4, code skipped:
            r6.getString(com.tencent.mm.R.string.e05);
     */
    /* JADX WARNING: Missing block: B:37:0x0132, code skipped:
            r12.gnx = com.tencent.mm.pluginsdk.ui.e.j.b(r13, r7, com.tencent.mm.bz.a.al(r13, com.tencent.mm.R.dimen.kr));
     */
    /* JADX WARNING: Missing block: B:45:?, code skipped:
            return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(Context context, com.tencent.mm.ui.contact.a.a.a aVar) {
        int i;
        CharSequence charSequence = null;
        int i2 = 1;
        boolean z = false;
        AppMethodBeat.i(105274);
        if (this.hpS != null) {
            if (this.ehM == null) {
                g.RQ();
                this.ehM = ((j) g.K(j.class)).XM().aoI(this.hpS.mDx);
                if (this.ehM == null) {
                    g.RQ();
                    this.ehM = ((j) g.K(j.class)).XM().aoN(this.hpS.mDx);
                    i = 1;
                }
            }
            i = 1;
        } else {
            i = 0;
        }
        if (this.ehM == null) {
            ab.i("MicroMsg.ChatroomDataItem", "filling dataItem Occur Error Contact is null, position=%d", Integer.valueOf(this.position));
            AppMethodBeat.o(105274);
            return;
        }
        this.username = this.ehM.field_username;
        if (i != 0) {
            l lVar = this.hpS;
            ad adVar = this.ehM;
            Resources resources = context.getResources();
            CharSequence a = ((com.tencent.mm.plugin.messenger.a.b) g.K(com.tencent.mm.plugin.messenger.a.b.class)).a(adVar, adVar.field_username);
            boolean z2;
            boolean z3;
            switch (lVar.mDw) {
                case 1:
                case 5:
                    z2 = false;
                    z3 = false;
                    break;
                case 2:
                case 6:
                    break;
                case 3:
                case 7:
                    z = true;
                    break;
                case 38:
                    String[] split;
                    g.RQ();
                    Cursor a2 = g.RP().eJN.a("SELECT memberlist FROM chatroom WHERE chatroomname=?;", new String[]{adVar.field_username}, 2);
                    if (a2.moveToFirst()) {
                        String string = a2.getString(0);
                        a2.close();
                        split = string == null ? null : zpF.split(string);
                    } else {
                        a2.close();
                        split = null;
                    }
                    if (split != null && split.length > 0) {
                        this.zpG = "(" + split.length + ")";
                    }
                    if (!(split == null || lVar.mEI == null)) {
                        CharSequence a3 = m.a(context, lVar.mEI, split, this.mDz, com.tencent.mm.plugin.fts.ui.b.c.mHz);
                        charSequence = TextUtils.concat(new CharSequence[]{resources.getString(R.string.e03), a3});
                        z2 = false;
                        z3 = false;
                        i2 = 0;
                        break;
                    }
                default:
                    z2 = false;
                    z3 = false;
                    i2 = 0;
                    break;
            }
        }
        this.gnx = ((com.tencent.mm.plugin.messenger.a.b) g.K(com.tencent.mm.plugin.messenger.a.b.class)).a(this.ehM, this.ehM.field_username);
        if (this.hpS != null) {
            this.zpG = "(" + this.hpS.mEB + ")";
        }
        AppMethodBeat.o(105274);
    }

    public final com.tencent.mm.ui.contact.a.a.b aou() {
        return this.zpH;
    }

    public final boolean bAv() {
        return this.hpS.mEL;
    }
}
