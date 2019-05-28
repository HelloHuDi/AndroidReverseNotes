package com.tencent.mm.ui.contact.a;

import android.content.Context;
import android.content.res.Resources;
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
import com.tencent.mm.plugin.fts.a.a.l;
import com.tencent.mm.plugin.fts.a.d;
import com.tencent.mm.plugin.fts.a.f;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.fts.ui.m;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import java.util.List;
import java.util.regex.Pattern;

public class e extends a {
    private static final Pattern gnw = Pattern.compile(",");
    public CharSequence gnx;
    public CharSequence gny;
    public l hpS;
    public String username;
    public String zpO;
    public boolean zpP;
    private b zpQ = new b();
    private a zpR = new a();

    public class a extends com.tencent.mm.ui.contact.a.a.a {
        public View contentView;
        public ImageView ejo;
        public TextView gnB;
        public TextView gnC;
        public CheckBox gnD;
        public TextView zjV;
        public CheckBox zpS;

        public a() {
            super();
        }
    }

    public class b extends com.tencent.mm.ui.contact.a.a.b {
        public b() {
            super();
        }

        public View a(Context context, ViewGroup viewGroup) {
            View inflate;
            AppMethodBeat.i(105279);
            if (com.tencent.mm.bz.a.ga(context)) {
                inflate = LayoutInflater.from(context).inflate(R.layout.ar1, viewGroup, false);
            } else {
                inflate = LayoutInflater.from(context).inflate(R.layout.ar0, viewGroup, false);
            }
            a aVar = (a) e.this.clJ();
            aVar.ejo = (ImageView) inflate.findViewById(R.id.qk);
            aVar.gnB = (TextView) inflate.findViewById(R.id.qm);
            aVar.gnC = (TextView) inflate.findViewById(R.id.ld);
            aVar.contentView = inflate.findViewById(R.id.de9);
            aVar.gnD = (CheckBox) inflate.findViewById(R.id.a1b);
            aVar.zpS = (CheckBox) inflate.findViewById(R.id.e8l);
            aVar.zjV = (TextView) inflate.findViewById(R.id.nz);
            inflate.setTag(aVar);
            AppMethodBeat.o(105279);
            return inflate;
        }

        public void a(Context context, com.tencent.mm.ui.contact.a.a.a aVar, a aVar2, boolean z, boolean z2) {
            AppMethodBeat.i(105280);
            a aVar3 = (a) aVar;
            e eVar = (e) aVar2;
            if (eVar.username == null || eVar.username.length() <= 0) {
                aVar3.ejo.setImageResource(R.drawable.ad2);
            } else {
                com.tencent.mm.pluginsdk.ui.a.b.a(aVar3.ejo, eVar.username, 0.1f, false);
            }
            m.a(eVar.gnx, aVar3.gnB);
            m.a(eVar.gny, aVar3.gnC);
            if (e.this.zmW) {
                aVar3.gnD.setBackgroundResource(R.drawable.ub);
                if (z) {
                    aVar3.gnD.setChecked(true);
                    aVar3.gnD.setEnabled(false);
                } else {
                    aVar3.gnD.setChecked(z2);
                    aVar3.gnD.setEnabled(true);
                }
                aVar3.gnD.setVisibility(0);
            } else if (e.this.zpB) {
                aVar3.gnD.setBackgroundResource(R.drawable.yu);
                if (z) {
                    aVar3.gnD.setChecked(true);
                    aVar3.gnD.setEnabled(false);
                } else {
                    aVar3.gnD.setChecked(z2);
                    aVar3.gnD.setEnabled(true);
                }
                aVar3.gnD.setVisibility(0);
            } else if (e.this.zmX) {
                aVar3.gnD.setVisibility(8);
                aVar3.zpS.setChecked(z2);
                aVar3.zpS.setEnabled(true);
                aVar3.zpS.setVisibility(0);
            } else {
                aVar3.gnD.setVisibility(8);
            }
            if (e.this.jLx) {
                aVar3.contentView.setBackgroundResource(R.drawable.k7);
            } else {
                aVar3.contentView.setBackgroundResource(R.drawable.k5);
            }
            if (eVar.ehM.field_deleteFlag == 1) {
                aVar3.gnC.setVisibility(0);
                aVar3.gnC.setText(context.getString(R.string.e17));
            }
            if (!(e.this.zpP || aVar3.zjV == null)) {
                if (ad.aox(eVar.username)) {
                    aVar3.zjV.setText(eVar.zpO);
                    aVar3.zjV.setVisibility(0);
                    AppMethodBeat.o(105280);
                    return;
                }
                aVar3.zjV.setVisibility(8);
            }
            AppMethodBeat.o(105280);
        }

        public final boolean aov() {
            AppMethodBeat.i(105281);
            if (e.this.hpS != null) {
                ((n) g.M(n.class)).updateTopHitsRank(e.this.query, e.this.hpS, 1);
            }
            AppMethodBeat.o(105281);
            return false;
        }
    }

    static {
        AppMethodBeat.i(105284);
        AppMethodBeat.o(105284);
    }

    public e(int i) {
        super(2, i);
        AppMethodBeat.i(105282);
        AppMethodBeat.o(105282);
    }

    /* JADX WARNING: Missing block: B:28:0x015c, code skipped:
            r3 = true;
     */
    /* JADX WARNING: Missing block: B:29:0x015e, code skipped:
            r2 = r1;
            r6 = 1;
     */
    /* JADX WARNING: Missing block: B:31:0x0164, code skipped:
            r3 = true;
     */
    /* JADX WARNING: Missing block: B:32:0x0165, code skipped:
            r5 = r5.field_nickname;
            r8 = r11.getString(com.tencent.mm.R.string.e05);
            r4 = 1;
            r7 = r5;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(Context context, com.tencent.mm.ui.contact.a.a.a aVar) {
        AppMethodBeat.i(105283);
        Object obj = 1;
        if (this.hpS == null) {
            obj = null;
        } else if (this.ehM == null) {
            g.RQ();
            this.ehM = ((j) g.K(j.class)).XM().aoI(this.hpS.mDx);
            if (this.ehM == null) {
                g.RQ();
                this.ehM = ((j) g.K(j.class)).XM().aoN(this.hpS.mDx);
            }
        }
        if (this.ehM == null) {
            ab.i("MicroMsg.ContactDataItem", "filling dataItem Occur Error Contact is null, position=%d", Integer.valueOf(this.position));
            AppMethodBeat.o(105283);
            return;
        }
        this.username = this.ehM.field_username;
        this.zpO = ((com.tencent.mm.openim.a.b) g.K(com.tencent.mm.openim.a.b.class)).ba(this.ehM.field_openImAppid, this.ehM.field_descWordingId);
        if (obj != null) {
            CharSequence a;
            l lVar = this.hpS;
            ad adVar = this.ehM;
            String str = null;
            CharSequence charSequence = null;
            Object obj2 = null;
            Object obj3 = null;
            boolean z = false;
            boolean z2 = false;
            Resources resources = context.getResources();
            if (adVar != null) {
                a = ((com.tencent.mm.plugin.messenger.a.b) g.K(com.tencent.mm.plugin.messenger.a.b.class)).a(adVar, adVar.field_username);
                boolean z3;
                String str2;
                int obj32;
                Object charSequence2;
                String str3;
                switch (lVar.mDw) {
                    case 1:
                        z3 = false;
                        break;
                    case 2:
                        z3 = false;
                        break;
                    case 3:
                        z3 = true;
                        break;
                    case 4:
                        str2 = adVar.dul;
                        str = resources.getString(R.string.e00);
                        obj32 = 1;
                        charSequence2 = str2;
                        break;
                    case 5:
                        break;
                    case 6:
                        break;
                    case 7:
                        z2 = true;
                        break;
                    case 11:
                        obj32 = 1;
                        List<String> MX = ((n) g.M(n.class)).getFTSMainDB().MX(adVar.field_contactLabelIds);
                        StringBuffer stringBuffer = new StringBuffer();
                        for (CharSequence charSequence3 : this.mDz.mEa) {
                            for (String str32 : MX) {
                                if (d.Nb(str32).contains(charSequence3)) {
                                    stringBuffer.append(str32);
                                    stringBuffer.append(",");
                                }
                            }
                        }
                        stringBuffer.trimToSize();
                        if (stringBuffer.length() == 0) {
                            str32 = "";
                        } else {
                            str32 = stringBuffer.substring(0, stringBuffer.length() - 1);
                        }
                        charSequence2 = str32;
                        str = resources.getString(R.string.e08);
                        break;
                    case 15:
                        obj32 = 1;
                        str32 = adVar.Hq();
                        if (bo.isNullOrNil(str32)) {
                            str32 = adVar.field_username;
                        }
                        charSequence2 = str32;
                        str = resources.getString(R.string.e09);
                        break;
                    case 16:
                        String str4 = lVar.content;
                        if (!bo.isNullOrNil(str4)) {
                            for (String str322 : str4.split("​")) {
                                if (str322.startsWith(this.query)) {
                                    str = resources.getString(R.string.e04);
                                    obj32 = 1;
                                    charSequence2 = str322;
                                    break;
                                }
                            }
                        }
                        str322 = str4;
                        str = resources.getString(R.string.e04);
                        obj32 = 1;
                        charSequence2 = str322;
                    case 17:
                    case 18:
                        str2 = lVar.content;
                        str = resources.getString(R.string.e02);
                        obj32 = 1;
                        charSequence2 = str2;
                        break;
                }
            }
            a = null;
            if (obj2 != null) {
                ab.d("MicroMsg.ContactDataItem", "highlight first line");
                this.gnx = com.tencent.mm.pluginsdk.ui.e.j.b(context, a, com.tencent.mm.bz.a.al(context, R.dimen.m5));
                this.gnx = f.a(com.tencent.mm.plugin.fts.a.a.d.a(this.gnx, this.mDz, z, z2)).mDR;
            } else {
                this.gnx = com.tencent.mm.pluginsdk.ui.e.j.b(context, a, com.tencent.mm.bz.a.al(context, R.dimen.m5));
            }
            if (obj32 != null) {
                ab.d("MicroMsg.ContactDataItem", "highlight second line");
                this.gny = com.tencent.mm.pluginsdk.ui.e.j.b(context, charSequence2, com.tencent.mm.bz.a.al(context, R.dimen.kr));
                this.gny = f.a(com.tencent.mm.plugin.fts.a.a.d.a(this.gny, this.mDz, z, z2)).mDR;
            } else {
                this.gny = com.tencent.mm.pluginsdk.ui.e.j.b(context, charSequence2, com.tencent.mm.bz.a.al(context, R.dimen.kr));
            }
            if (!(bo.isNullOrNil(str) || this.gny == null)) {
                this.gny = TextUtils.concat(new CharSequence[]{str, this.gny});
            }
            AppMethodBeat.o(105283);
            return;
        }
        CharSequence c;
        if (bo.isNullOrNil(this.cuP)) {
            c = ((com.tencent.mm.plugin.messenger.a.b) g.K(com.tencent.mm.plugin.messenger.a.b.class)).c(this.ehM);
        } else {
            c = ((com.tencent.mm.plugin.messenger.a.b) g.K(com.tencent.mm.plugin.messenger.a.b.class)).getDisplayName(this.ehM.field_username, this.cuP);
        }
        this.gnx = com.tencent.mm.pluginsdk.ui.e.j.b(context, c, com.tencent.mm.bz.a.al(context, R.dimen.m5));
        AppMethodBeat.o(105283);
    }

    public com.tencent.mm.ui.contact.a.a.b aou() {
        return this.zpQ;
    }

    public com.tencent.mm.ui.contact.a.a.a clJ() {
        return this.zpR;
    }
}
