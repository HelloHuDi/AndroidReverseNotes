package com.tencent.p177mm.p612ui.contact.p625a;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p612ui.contact.p625a.C5445a.C5446a;
import com.tencent.p177mm.p612ui.contact.p625a.C5445a.C5447b;
import com.tencent.p177mm.plugin.fts.p419a.C12029n;
import com.tencent.p177mm.plugin.fts.p419a.p420a.C45966l;
import com.tencent.p177mm.plugin.fts.p424ui.C3201m;
import com.tencent.p177mm.plugin.fts.p424ui.C45976b.C3197c;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.messenger.p993a.C34530b;
import com.tencent.p177mm.pluginsdk.p597ui.C40459a.C40460b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.storage.C7616ad;
import java.util.regex.Pattern;

/* renamed from: com.tencent.mm.ui.contact.a.c */
public final class C40842c extends C5445a {
    private static final Pattern zpF = Pattern.compile(";");
    public CharSequence gnx;
    public CharSequence gny;
    public C45966l hpS;
    public String username;
    public CharSequence zpG;
    private C23919b zpH = new C23919b();
    C23918a zpI = new C23918a();

    /* renamed from: com.tencent.mm.ui.contact.a.c$a */
    public class C23918a extends C5446a {
        public View contentView;
        public ImageView ejo;
        public TextView gnB;
        public TextView gnC;
        public CheckBox gnD;
        public TextView mJS;

        public C23918a() {
            super();
        }
    }

    /* renamed from: com.tencent.mm.ui.contact.a.c$b */
    public class C23919b extends C5447b {
        public C23919b() {
            super();
        }

        /* renamed from: a */
        public final View mo11086a(Context context, ViewGroup viewGroup) {
            View inflate;
            AppMethodBeat.m2504i(105270);
            if (C1338a.m2865ga(context)) {
                inflate = LayoutInflater.from(context).inflate(2130970606, viewGroup, false);
            } else {
                inflate = LayoutInflater.from(context).inflate(2130970605, viewGroup, false);
            }
            C23918a c23918a = C40842c.this.zpI;
            c23918a.ejo = (ImageView) inflate.findViewById(2131821183);
            c23918a.gnB = (TextView) inflate.findViewById(2131821185);
            c23918a.gnB.setMaxWidth(C1338a.fromDPToPix(context, 200));
            c23918a.gnC = (TextView) inflate.findViewById(2131820991);
            c23918a.mJS = (TextView) inflate.findViewById(2131821051);
            c23918a.contentView = inflate.findViewById(2131826213);
            c23918a.gnD = (CheckBox) inflate.findViewById(2131821593);
            if (C40842c.this.jLx) {
                c23918a.contentView.setBackgroundResource(C25738R.drawable.f6625k7);
            }
            inflate.setTag(c23918a);
            AppMethodBeat.m2505o(105270);
            return inflate;
        }

        /* renamed from: a */
        public final void mo11087a(Context context, C5446a c5446a, C5445a c5445a, boolean z, boolean z2) {
            AppMethodBeat.m2504i(105271);
            C23918a c23918a = (C23918a) c5446a;
            C40842c c40842c = (C40842c) c5445a;
            if (c40842c.username == null || c40842c.username.length() <= 0) {
                c23918a.ejo.setImageResource(C25738R.drawable.ad2);
            } else {
                C40460b.m69433a(c23918a.ejo, c40842c.username, 0.1f, false);
            }
            C3201m.m5501a(c40842c.gnx, c23918a.gnB);
            if (C1855t.m3903mP(c40842c.username)) {
                Drawable drawable = context.getResources().getDrawable(C1318a.open_im_main_logo);
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                c23918a.gnB.setCompoundDrawablesWithIntrinsicBounds(null, null, drawable, null);
            } else {
                c23918a.gnB.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
            }
            C3201m.m5501a(c40842c.gny, c23918a.gnC);
            C3201m.m5501a(c40842c.zpG, c23918a.mJS);
            if (C40842c.this.zmW) {
                if (z) {
                    c23918a.gnD.setChecked(true);
                    c23918a.gnD.setEnabled(false);
                } else {
                    c23918a.gnD.setChecked(z2);
                    c23918a.gnD.setEnabled(true);
                }
                c23918a.gnD.setVisibility(0);
                AppMethodBeat.m2505o(105271);
                return;
            }
            c23918a.gnD.setVisibility(8);
            AppMethodBeat.m2505o(105271);
        }

        public final boolean aov() {
            AppMethodBeat.m2504i(105272);
            if (C40842c.this.hpS != null) {
                ((C12029n) C1720g.m3530M(C12029n.class)).updateTopHitsRank(C40842c.this.query, C40842c.this.hpS, 1);
            }
            AppMethodBeat.m2505o(105272);
            return false;
        }
    }

    static {
        AppMethodBeat.m2504i(105275);
        AppMethodBeat.m2505o(105275);
    }

    public C40842c(int i) {
        super(3, i);
        AppMethodBeat.m2504i(105273);
        AppMethodBeat.m2505o(105273);
    }

    /* JADX WARNING: Missing block: B:16:0x008c, code skipped:
            if (r1 == 0) goto L_0x0132;
     */
    /* JADX WARNING: Missing block: B:17:0x008e, code skipped:
            r12.gnx = com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j.m79294b(r13, r7, com.tencent.p177mm.p208bz.C1338a.m2856al(r13, com.tencent.p177mm.C25738R.dimen.f9936kr));
            r12.gnx = com.tencent.p177mm.plugin.fts.p419a.C34204f.m56086a(com.tencent.p177mm.plugin.fts.p419a.p420a.C39127d.m66568a(r12.gnx, r12.mDz, r3, r0)).mDR;
     */
    /* JADX WARNING: Missing block: B:18:0x00ab, code skipped:
            r12.gny = r4;
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(105274);
     */
    /* JADX WARNING: Missing block: B:20:0x00b2, code skipped:
            r0 = r2;
            r3 = true;
     */
    /* JADX WARNING: Missing block: B:21:0x00b4, code skipped:
            r6.getString(com.tencent.p177mm.C25738R.string.e05);
     */
    /* JADX WARNING: Missing block: B:37:0x0132, code skipped:
            r12.gnx = com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j.m79294b(r13, r7, com.tencent.p177mm.p208bz.C1338a.m2856al(r13, com.tencent.p177mm.C25738R.dimen.f9936kr));
     */
    /* JADX WARNING: Missing block: B:45:?, code skipped:
            return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public final void mo11082a(Context context, C5446a c5446a) {
        int i;
        CharSequence charSequence = null;
        int i2 = 1;
        boolean z = false;
        AppMethodBeat.m2504i(105274);
        if (this.hpS != null) {
            if (this.ehM == null) {
                C1720g.m3537RQ();
                this.ehM = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoI(this.hpS.mDx);
                if (this.ehM == null) {
                    C1720g.m3537RQ();
                    this.ehM = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoN(this.hpS.mDx);
                    i = 1;
                }
            }
            i = 1;
        } else {
            i = 0;
        }
        if (this.ehM == null) {
            C4990ab.m7417i("MicroMsg.ChatroomDataItem", "filling dataItem Occur Error Contact is null, position=%d", Integer.valueOf(this.position));
            AppMethodBeat.m2505o(105274);
            return;
        }
        this.username = this.ehM.field_username;
        if (i != 0) {
            C45966l c45966l = this.hpS;
            C7616ad c7616ad = this.ehM;
            Resources resources = context.getResources();
            CharSequence a = ((C34530b) C1720g.m3528K(C34530b.class)).mo55062a(c7616ad, c7616ad.field_username);
            boolean z2;
            boolean z3;
            switch (c45966l.mDw) {
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
                    C1720g.m3537RQ();
                    Cursor a2 = C1720g.m3536RP().eJN.mo10104a("SELECT memberlist FROM chatroom WHERE chatroomname=?;", new String[]{c7616ad.field_username}, 2);
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
                    if (!(split == null || c45966l.mEI == null)) {
                        CharSequence a3 = C3201m.m5498a(context, c45966l.mEI, split, this.mDz, C3197c.mHz);
                        charSequence = TextUtils.concat(new CharSequence[]{resources.getString(C25738R.string.e03), a3});
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
        this.gnx = ((C34530b) C1720g.m3528K(C34530b.class)).mo55062a(this.ehM, this.ehM.field_username);
        if (this.hpS != null) {
            this.zpG = "(" + this.hpS.mEB + ")";
        }
        AppMethodBeat.m2505o(105274);
    }

    public final C5447b aou() {
        return this.zpH;
    }

    public final boolean bAv() {
        return this.hpS.mEL;
    }
}
