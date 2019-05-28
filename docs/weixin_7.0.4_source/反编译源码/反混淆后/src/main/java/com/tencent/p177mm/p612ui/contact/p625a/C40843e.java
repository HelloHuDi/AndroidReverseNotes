package com.tencent.p177mm.p612ui.contact.p625a;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.openim.p1210a.C32873b;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p612ui.contact.p625a.C5445a.C5446a;
import com.tencent.p177mm.p612ui.contact.p625a.C5445a.C5447b;
import com.tencent.p177mm.plugin.fts.p419a.C12029n;
import com.tencent.p177mm.plugin.fts.p419a.C3161d;
import com.tencent.p177mm.plugin.fts.p419a.C34204f;
import com.tencent.p177mm.plugin.fts.p419a.p420a.C39127d;
import com.tencent.p177mm.plugin.fts.p419a.p420a.C45966l;
import com.tencent.p177mm.plugin.fts.p424ui.C3201m;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.messenger.p993a.C34530b;
import com.tencent.p177mm.pluginsdk.p597ui.C40459a.C40460b;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7616ad;
import java.util.List;
import java.util.regex.Pattern;

/* renamed from: com.tencent.mm.ui.contact.a.e */
public class C40843e extends C5445a {
    private static final Pattern gnw = Pattern.compile(",");
    public CharSequence gnx;
    public CharSequence gny;
    public C45966l hpS;
    public String username;
    public String zpO;
    public boolean zpP;
    private C40844b zpQ = new C40844b();
    private C15815a zpR = new C15815a();

    /* renamed from: com.tencent.mm.ui.contact.a.e$a */
    public class C15815a extends C5446a {
        public View contentView;
        public ImageView ejo;
        public TextView gnB;
        public TextView gnC;
        public CheckBox gnD;
        public TextView zjV;
        public CheckBox zpS;

        public C15815a() {
            super();
        }
    }

    /* renamed from: com.tencent.mm.ui.contact.a.e$b */
    public class C40844b extends C5447b {
        public C40844b() {
            super();
        }

        /* renamed from: a */
        public View mo11086a(Context context, ViewGroup viewGroup) {
            View inflate;
            AppMethodBeat.m2504i(105279);
            if (C1338a.m2865ga(context)) {
                inflate = LayoutInflater.from(context).inflate(2130970606, viewGroup, false);
            } else {
                inflate = LayoutInflater.from(context).inflate(2130970605, viewGroup, false);
            }
            C15815a c15815a = (C15815a) C40843e.this.clJ();
            c15815a.ejo = (ImageView) inflate.findViewById(2131821183);
            c15815a.gnB = (TextView) inflate.findViewById(2131821185);
            c15815a.gnC = (TextView) inflate.findViewById(2131820991);
            c15815a.contentView = inflate.findViewById(2131826213);
            c15815a.gnD = (CheckBox) inflate.findViewById(2131821593);
            c15815a.zpS = (CheckBox) inflate.findViewById(2131827336);
            c15815a.zjV = (TextView) inflate.findViewById(2131821087);
            inflate.setTag(c15815a);
            AppMethodBeat.m2505o(105279);
            return inflate;
        }

        /* renamed from: a */
        public void mo11087a(Context context, C5446a c5446a, C5445a c5445a, boolean z, boolean z2) {
            AppMethodBeat.m2504i(105280);
            C15815a c15815a = (C15815a) c5446a;
            C40843e c40843e = (C40843e) c5445a;
            if (c40843e.username == null || c40843e.username.length() <= 0) {
                c15815a.ejo.setImageResource(C25738R.drawable.ad2);
            } else {
                C40460b.m69433a(c15815a.ejo, c40843e.username, 0.1f, false);
            }
            C3201m.m5501a(c40843e.gnx, c15815a.gnB);
            C3201m.m5501a(c40843e.gny, c15815a.gnC);
            if (C40843e.this.zmW) {
                c15815a.gnD.setBackgroundResource(C25738R.drawable.f6884ub);
                if (z) {
                    c15815a.gnD.setChecked(true);
                    c15815a.gnD.setEnabled(false);
                } else {
                    c15815a.gnD.setChecked(z2);
                    c15815a.gnD.setEnabled(true);
                }
                c15815a.gnD.setVisibility(0);
            } else if (C40843e.this.zpB) {
                c15815a.gnD.setBackgroundResource(C25738R.drawable.f7022yu);
                if (z) {
                    c15815a.gnD.setChecked(true);
                    c15815a.gnD.setEnabled(false);
                } else {
                    c15815a.gnD.setChecked(z2);
                    c15815a.gnD.setEnabled(true);
                }
                c15815a.gnD.setVisibility(0);
            } else if (C40843e.this.zmX) {
                c15815a.gnD.setVisibility(8);
                c15815a.zpS.setChecked(z2);
                c15815a.zpS.setEnabled(true);
                c15815a.zpS.setVisibility(0);
            } else {
                c15815a.gnD.setVisibility(8);
            }
            if (C40843e.this.jLx) {
                c15815a.contentView.setBackgroundResource(C25738R.drawable.f6625k7);
            } else {
                c15815a.contentView.setBackgroundResource(C25738R.drawable.f6623k5);
            }
            if (c40843e.ehM.field_deleteFlag == 1) {
                c15815a.gnC.setVisibility(0);
                c15815a.gnC.setText(context.getString(C25738R.string.e17));
            }
            if (!(C40843e.this.zpP || c15815a.zjV == null)) {
                if (C7616ad.aox(c40843e.username)) {
                    c15815a.zjV.setText(c40843e.zpO);
                    c15815a.zjV.setVisibility(0);
                    AppMethodBeat.m2505o(105280);
                    return;
                }
                c15815a.zjV.setVisibility(8);
            }
            AppMethodBeat.m2505o(105280);
        }

        public final boolean aov() {
            AppMethodBeat.m2504i(105281);
            if (C40843e.this.hpS != null) {
                ((C12029n) C1720g.m3530M(C12029n.class)).updateTopHitsRank(C40843e.this.query, C40843e.this.hpS, 1);
            }
            AppMethodBeat.m2505o(105281);
            return false;
        }
    }

    static {
        AppMethodBeat.m2504i(105284);
        AppMethodBeat.m2505o(105284);
    }

    public C40843e(int i) {
        super(2, i);
        AppMethodBeat.m2504i(105282);
        AppMethodBeat.m2505o(105282);
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
            r8 = r11.getString(com.tencent.p177mm.C25738R.string.e05);
            r4 = 1;
            r7 = r5;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public final void mo11082a(Context context, C5446a c5446a) {
        AppMethodBeat.m2504i(105283);
        Object obj = 1;
        if (this.hpS == null) {
            obj = null;
        } else if (this.ehM == null) {
            C1720g.m3537RQ();
            this.ehM = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoI(this.hpS.mDx);
            if (this.ehM == null) {
                C1720g.m3537RQ();
                this.ehM = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoN(this.hpS.mDx);
            }
        }
        if (this.ehM == null) {
            C4990ab.m7417i("MicroMsg.ContactDataItem", "filling dataItem Occur Error Contact is null, position=%d", Integer.valueOf(this.position));
            AppMethodBeat.m2505o(105283);
            return;
        }
        this.username = this.ehM.field_username;
        this.zpO = ((C32873b) C1720g.m3528K(C32873b.class)).mo44306ba(this.ehM.field_openImAppid, this.ehM.field_descWordingId);
        if (obj != null) {
            CharSequence a;
            C45966l c45966l = this.hpS;
            C7616ad c7616ad = this.ehM;
            String str = null;
            CharSequence charSequence = null;
            Object obj2 = null;
            Object obj3 = null;
            boolean z = false;
            boolean z2 = false;
            Resources resources = context.getResources();
            if (c7616ad != null) {
                a = ((C34530b) C1720g.m3528K(C34530b.class)).mo55062a(c7616ad, c7616ad.field_username);
                boolean z3;
                String str2;
                int obj32;
                Object charSequence2;
                String str3;
                switch (c45966l.mDw) {
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
                        str2 = c7616ad.dul;
                        str = resources.getString(C25738R.string.e00);
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
                        List<String> MX = ((C12029n) C1720g.m3530M(C12029n.class)).getFTSMainDB().mo46036MX(c7616ad.field_contactLabelIds);
                        StringBuffer stringBuffer = new StringBuffer();
                        for (CharSequence charSequence3 : this.mDz.mEa) {
                            for (String str32 : MX) {
                                if (C3161d.m5404Nb(str32).contains(charSequence3)) {
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
                        str = resources.getString(C25738R.string.e08);
                        break;
                    case 15:
                        obj32 = 1;
                        str32 = c7616ad.mo14673Hq();
                        if (C5046bo.isNullOrNil(str32)) {
                            str32 = c7616ad.field_username;
                        }
                        charSequence2 = str32;
                        str = resources.getString(C25738R.string.e09);
                        break;
                    case 16:
                        String str4 = c45966l.content;
                        if (!C5046bo.isNullOrNil(str4)) {
                            for (String str322 : str4.split("​")) {
                                if (str322.startsWith(this.query)) {
                                    str = resources.getString(C25738R.string.e04);
                                    obj32 = 1;
                                    charSequence2 = str322;
                                    break;
                                }
                            }
                        }
                        str322 = str4;
                        str = resources.getString(C25738R.string.e04);
                        obj32 = 1;
                        charSequence2 = str322;
                    case 17:
                    case 18:
                        str2 = c45966l.content;
                        str = resources.getString(C25738R.string.e02);
                        obj32 = 1;
                        charSequence2 = str2;
                        break;
                }
            }
            a = null;
            if (obj2 != null) {
                C4990ab.m7410d("MicroMsg.ContactDataItem", "highlight first line");
                this.gnx = C44089j.m79294b(context, a, C1338a.m2856al(context, C25738R.dimen.f9980m5));
                this.gnx = C34204f.m56086a(C39127d.m66568a(this.gnx, this.mDz, z, z2)).mDR;
            } else {
                this.gnx = C44089j.m79294b(context, a, C1338a.m2856al(context, C25738R.dimen.f9980m5));
            }
            if (obj32 != null) {
                C4990ab.m7410d("MicroMsg.ContactDataItem", "highlight second line");
                this.gny = C44089j.m79294b(context, charSequence2, C1338a.m2856al(context, C25738R.dimen.f9936kr));
                this.gny = C34204f.m56086a(C39127d.m66568a(this.gny, this.mDz, z, z2)).mDR;
            } else {
                this.gny = C44089j.m79294b(context, charSequence2, C1338a.m2856al(context, C25738R.dimen.f9936kr));
            }
            if (!(C5046bo.isNullOrNil(str) || this.gny == null)) {
                this.gny = TextUtils.concat(new CharSequence[]{str, this.gny});
            }
            AppMethodBeat.m2505o(105283);
            return;
        }
        CharSequence c;
        if (C5046bo.isNullOrNil(this.cuP)) {
            c = ((C34530b) C1720g.m3528K(C34530b.class)).mo55063c(this.ehM);
        } else {
            c = ((C34530b) C1720g.m3528K(C34530b.class)).getDisplayName(this.ehM.field_username, this.cuP);
        }
        this.gnx = C44089j.m79294b(context, c, C1338a.m2856al(context, C25738R.dimen.f9980m5));
        AppMethodBeat.m2505o(105283);
    }

    public C5447b aou() {
        return this.zpQ;
    }

    public C5446a clJ() {
        return this.zpR;
    }
}
