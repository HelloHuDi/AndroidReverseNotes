package com.tencent.p177mm.plugin.fav.p410ui.p411b;

import android.content.Context;
import android.os.Looper;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.model.C26408ad.C26410a;
import com.tencent.p177mm.p230g.p231a.C37721gh;
import com.tencent.p177mm.p612ui.MMImageView;
import com.tencent.p177mm.plugin.fav.p407a.C39037b;
import com.tencent.p177mm.plugin.fts.p419a.C3161d;
import com.tencent.p177mm.plugin.fts.p419a.C34204f;
import com.tencent.p177mm.plugin.fts.p419a.p420a.C39127d;
import com.tencent.p177mm.plugin.fts.p419a.p420a.C45966l;
import com.tencent.p177mm.plugin.fts.p419a.p421d.p422a.C3154a;
import com.tencent.p177mm.plugin.fts.p419a.p421d.p422a.C3154a.C3155a;
import com.tencent.p177mm.plugin.fts.p419a.p421d.p422a.C3154a.C3156b;
import com.tencent.p177mm.plugin.fts.p424ui.C3201m;
import com.tencent.p177mm.plugin.fts.p424ui.C45976b.C20875a;
import com.tencent.p177mm.plugin.fts.p424ui.C45976b.C3197c;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.pluginsdk.C30034d;
import com.tencent.p177mm.protocal.protobuf.aar;
import com.tencent.p177mm.protocal.protobuf.aaw;
import com.tencent.p177mm.protocal.protobuf.aay;
import com.tencent.p177mm.protocal.protobuf.abf;
import com.tencent.p177mm.protocal.protobuf.abh;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.storage.C7616ad;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

/* renamed from: com.tencent.mm.plugin.fav.ui.b.a */
public final class C34153a extends C3154a {
    private static final C7306ak handler = new C7306ak(Looper.getMainLooper());
    private static final String mnp = C4996ah.getContext().getString(C25738R.string.c25);
    private static final Pattern mnq = Pattern.compile("['\r\n' | '\n']+");
    public String gEl;
    public C45966l hpS;
    public CharSequence mnr;
    public CharSequence mns;
    public CharSequence mnt;
    public String mnu;
    public int mnv;
    private C34155b mnw = new C34155b();
    C34154a mnx = new C34154a();

    /* renamed from: com.tencent.mm.plugin.fav.ui.b.a$a */
    public class C34154a extends C3155a {
        public View contentView;
        public TextView gnB;
        public TextView mnA;
        public MMImageView mny;
        public TextView mnz;

        public C34154a() {
            super();
        }
    }

    /* renamed from: com.tencent.mm.plugin.fav.ui.b.a$b */
    public class C34155b extends C3156b {
        public C34155b() {
            super();
        }

        /* renamed from: a */
        public final View mo7420a(Context context, ViewGroup viewGroup) {
            AppMethodBeat.m2504i(74489);
            View inflate = LayoutInflater.from(context).inflate(2130969621, viewGroup, false);
            C34154a c34154a = C34153a.this.mnx;
            c34154a.mny = (MMImageView) inflate.findViewById(2131821183);
            c34154a.gnB = (TextView) inflate.findViewById(2131821185);
            c34154a.mnz = (TextView) inflate.findViewById(2131824201);
            c34154a.mnA = (TextView) inflate.findViewById(2131824202);
            c34154a.contentView = inflate.findViewById(2131821182);
            inflate.setTag(c34154a);
            AppMethodBeat.m2505o(74489);
            return inflate;
        }

        /* renamed from: a */
        public final void mo7421a(Context context, C3155a c3155a, C3154a c3154a, Object... objArr) {
            AppMethodBeat.m2504i(74490);
            C34154a c34154a = (C34154a) c3155a;
            C34153a c34153a = (C34153a) c3154a;
            C3201m.m5503p(c34154a.contentView, C34153a.this.mFk);
            C3201m.m5500a(context, c34154a.mny, c34153a.gEl, c34153a.mnu, c34153a.mnv, false, c34154a.mny.getMeasuredWidth(), c34154a.mny.getMeasuredHeight());
            C34153a.m55995a(c34154a.gnB, c34154a.mnz, C34153a.this.mnr, C34153a.this.mns);
            C3201m.m5501a(C34153a.this.mnt, c34154a.mnA);
            AppMethodBeat.m2505o(74490);
        }

        /* renamed from: a */
        public final boolean mo7422a(Context context, C3154a c3154a) {
            AppMethodBeat.m2504i(74491);
            C34153a c34153a = (C34153a) c3154a;
            C37721gh c37721gh = new C37721gh();
            c37721gh.cAH.type = 10;
            c37721gh.cAH.cvv = c34153a.hpS.mEB;
            c37721gh.cAH.context = context;
            c37721gh.cAH.cAS = new abh();
            if (C34153a.this.pageType == 1) {
                c37721gh.cAH.cAS.scene = 3;
            } else {
                c37721gh.cAH.cAS.scene = 4;
            }
            c37721gh.cAH.cAS.jSW = 3;
            c37721gh.cAH.cAS.index = C34153a.this.mFn;
            C4879a.xxA.mo10055m(c37721gh);
            AppMethodBeat.m2505o(74491);
            return true;
        }
    }

    static {
        AppMethodBeat.m2504i(74498);
        AppMethodBeat.m2505o(74498);
    }

    /* renamed from: a */
    public static void m55995a(TextView textView, TextView textView2, CharSequence charSequence, CharSequence charSequence2) {
        AppMethodBeat.m2504i(74492);
        if (!C3201m.m5501a(charSequence, textView)) {
            if (C3201m.m5501a(charSequence2, textView2)) {
                textView2.setMaxLines(2);
            }
            AppMethodBeat.m2505o(74492);
        } else if (C3201m.m5501a(charSequence2, textView2)) {
            textView.setMaxLines(1);
            textView2.setMaxLines(1);
            AppMethodBeat.m2505o(74492);
        } else {
            textView.setMaxLines(2);
            AppMethodBeat.m2505o(74492);
        }
    }

    public C34153a(int i) {
        super(7, i);
        AppMethodBeat.m2504i(74493);
        AppMethodBeat.m2505o(74493);
    }

    /* JADX WARNING: Missing block: B:78:0x027f, code skipped:
            if (r0 == null) goto L_0x0375;
     */
    /* JADX WARNING: Missing block: B:79:0x0281, code skipped:
            r6 = com.tencent.p177mm.plugin.fav.p410ui.p411b.C34153a.m55997b(r0, true) + "-" + com.tencent.p177mm.plugin.fav.p410ui.p411b.C34153a.m55996b(r13, r9);
            r0 = r1;
            r3 = r2;
     */
    /* JADX WARNING: Missing block: B:80:0x02a3, code skipped:
            r1 = com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j.m79294b(r13, r6, com.tencent.p177mm.p208bz.C1338a.m2856al(r13, com.tencent.p177mm.C25738R.dimen.f9936kr));
     */
    /* JADX WARNING: Missing block: B:81:0x02ae, code skipped:
            if (r7 == 0) goto L_0x03c3;
     */
    /* JADX WARNING: Missing block: B:82:0x02b0, code skipped:
            r0 = com.tencent.p177mm.plugin.fts.p419a.C34204f.m56086a(com.tencent.p177mm.plugin.fts.p419a.p420a.C39127d.m66568a(r1, r12.mDz, r3, r0)).mDR;
     */
    /* JADX WARNING: Missing block: B:83:0x02bc, code skipped:
            r0 = android.text.TextUtils.concat(new java.lang.CharSequence[]{r13.getResources().getString(com.tencent.p177mm.C25738R.string.dzt), r0});
     */
    /* JADX WARNING: Missing block: B:85:0x02d4, code skipped:
            r2 = true;
     */
    /* JADX WARNING: Missing block: B:86:0x02d5, code skipped:
            if (r0 == null) goto L_0x02fb;
     */
    /* JADX WARNING: Missing block: B:87:0x02d7, code skipped:
            r6 = com.tencent.p177mm.plugin.fav.p410ui.p411b.C34153a.m55997b(r0, false) + "-" + com.tencent.p177mm.plugin.fav.p410ui.p411b.C34153a.m55996b(r13, r9);
            r0 = r1;
            r3 = r2;
            r7 = 1;
     */
    /* JADX WARNING: Missing block: B:88:0x02fb, code skipped:
            r6 = com.tencent.p177mm.plugin.fav.p410ui.p411b.C34153a.m55997b(r9, false);
            r0 = r1;
            r3 = r2;
            r7 = 1;
     */
    /* JADX WARNING: Missing block: B:90:0x0304, code skipped:
            r2 = r1;
            r3 = true;
     */
    /* JADX WARNING: Missing block: B:91:0x0306, code skipped:
            if (r0 == null) goto L_0x035c;
     */
    /* JADX WARNING: Missing block: B:92:0x0308, code skipped:
            r1 = com.tencent.p177mm.plugin.fav.p410ui.p411b.C34153a.m55997b(r0, true) + "-" + com.tencent.p177mm.plugin.fav.p410ui.p411b.C34153a.m55996b(r13, r9);
     */
    /* JADX WARNING: Missing block: B:93:0x0329, code skipped:
            r1 = r1 + "-" + com.tencent.p177mm.plugin.fav.p410ui.p411b.C34153a.m55997b(((com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j) com.tencent.p177mm.kernel.C1720g.m3528K(com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j.class)).mo15369XM().aoO(r8.csl), true);
            r0 = r2;
            r6 = r1;
            r7 = 1;
     */
    /* JADX WARNING: Missing block: B:95:0x0362, code skipped:
            if (com.tencent.p177mm.model.C1855t.m3896kH(r9.field_username) == false) goto L_0x036a;
     */
    /* JADX WARNING: Missing block: B:96:0x0364, code skipped:
            r1 = com.tencent.p177mm.plugin.fav.p410ui.p411b.C34153a.m55996b(r13, r9);
     */
    /* JADX WARNING: Missing block: B:97:0x036a, code skipped:
            r1 = com.tencent.p177mm.plugin.fav.p410ui.p411b.C34153a.m55997b(r9, true);
     */
    /* JADX WARNING: Missing block: B:99:0x0371, code skipped:
            r2 = true;
     */
    /* JADX WARNING: Missing block: B:100:0x0372, code skipped:
            r7 = 1;
     */
    /* JADX WARNING: Missing block: B:102:0x037b, code skipped:
            if (com.tencent.p177mm.model.C1855t.m3896kH(r9.field_username) == false) goto L_0x0385;
     */
    /* JADX WARNING: Missing block: B:103:0x037d, code skipped:
            r6 = com.tencent.p177mm.plugin.fav.p410ui.p411b.C34153a.m55996b(r13, r9);
            r0 = r1;
            r3 = r2;
     */
    /* JADX WARNING: Missing block: B:104:0x0385, code skipped:
            r6 = com.tencent.p177mm.plugin.fav.p410ui.p411b.C34153a.m55997b(r9, true);
            r0 = r1;
            r3 = r2;
     */
    /* JADX WARNING: Missing block: B:114:0x03c3, code skipped:
            r0 = r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public final void mo7413a(Context context, C3155a c3155a, Object... objArr) {
        aay aay;
        String a;
        String str;
        int i;
        String str2;
        int i2;
        AppMethodBeat.m2504i(74494);
        long j = this.hpS.mEB;
        C37721gh c37721gh = new C37721gh();
        c37721gh.cAH.type = 9;
        c37721gh.cAH.cvv = j;
        C4879a.xxA.mo10055m(c37721gh);
        aaw aaw = c37721gh.cAI.cAT;
        j = this.hpS.mEB;
        c37721gh = new C37721gh();
        c37721gh.cAH.type = 11;
        c37721gh.cAH.cvv = j;
        c37721gh.cAH.handler = handler;
        C4879a.xxA.mo10055m(c37721gh);
        this.mnu = C5046bo.m7532bc(c37721gh.cAI.thumbPath, "");
        this.gEl = C5046bo.m7532bc(c37721gh.cAI.thumbUrl, "");
        C45966l c45966l = this.hpS;
        float f = (float) (C20875a.mHq * 2);
        abf abf = aaw.cKb;
        CharSequence charSequence = "";
        switch (aaw.type) {
            case 1:
                charSequence = mnq.matcher(aaw.desc).replaceAll(" ");
                break;
            case 2:
                charSequence = context.getResources().getString(C25738R.string.e0i);
                break;
            case 3:
                charSequence = context.getResources().getString(C25738R.string.e0n);
                break;
            case 4:
                charSequence = context.getResources().getString(C25738R.string.e0m);
                break;
            case 6:
                aay = aaw.cKb.why;
                if (!mnp.equals(aay.cIK) && !C5046bo.isNullOrNil(aay.cIK)) {
                    charSequence = aay.cIK;
                    break;
                } else {
                    charSequence = aay.label;
                    break;
                }
                break;
            case 7:
                charSequence = aaw.title;
                if (!C5046bo.isNullOrNil(aaw.desc)) {
                    charSequence = charSequence + "-" + aaw.desc;
                    break;
                }
                break;
            case 10:
            case 11:
                if (abf.whC != null) {
                    charSequence = abf.whC.title;
                    break;
                }
                break;
            case 14:
                StringBuffer stringBuffer = new StringBuffer();
                Iterator it = abf.wiv.iterator();
                while (it.hasNext()) {
                    a = C39037b.m66348a((aar) it.next());
                    if (!C5046bo.isNullOrNil(a)) {
                        stringBuffer.append(a);
                        stringBuffer.append(" ");
                    }
                }
                charSequence = mnq.matcher(stringBuffer.toString()).replaceAll(" ");
                if (C5046bo.isNullOrNil(charSequence)) {
                    charSequence = context.getResources().getString(C25738R.string.e0k);
                    break;
                }
                break;
            case 16:
                charSequence = context.getResources().getString(C25738R.string.e0l);
                break;
            default:
                charSequence = aaw.title;
                break;
        }
        switch (c45966l.mDw) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                charSequence = C34204f.m56086a(C39127d.m66567a(charSequence, this.mDz, f, C3197c.mHz)).mDR;
                break;
        }
        this.mnr = charSequence;
        c45966l = this.hpS;
        abf abf2 = aaw.cKb;
        charSequence = "";
        switch (aaw.type) {
            case 2:
                charSequence = aaw.title;
                break;
            case 5:
            case 7:
            case 12:
            case 15:
                if (!C5046bo.isNullOrNil(aaw.appId)) {
                    charSequence = C26410a.fls.mo44181t(context, aaw.appId);
                    break;
                }
                break;
            case 6:
                aay = aaw.cKb.why;
                if (!mnp.equals(aay.cIK) && !C5046bo.isNullOrNil(aay.cIK)) {
                    charSequence = aay.cIK;
                    break;
                } else {
                    charSequence = aay.label;
                    break;
                }
            case 10:
            case 11:
                if (abf2.whC != null) {
                    charSequence = abf2.whC.desc;
                    break;
                }
                break;
            case 14:
                charSequence = "";
                break;
            default:
                charSequence = "";
                break;
        }
        switch (c45966l.mDw) {
            case 6:
                str = C34204f.m56086a(C39127d.m66566a(charSequence, this.mDz)).mDR;
                i = -1;
                break;
            case 7:
            case 8:
                i = C25738R.string.e0j;
                charSequence = m55998bR(aaw.wig);
                str = C34204f.m56086a(C39127d.m66566a(charSequence, this.mDz)).mDR;
                break;
            case 23:
                i = C25738R.string.e0h;
                str = C34204f.m56086a(C39127d.m66566a(charSequence, this.mDz)).mDR;
                break;
            default:
                str = "";
                i = -1;
                break;
        }
        if (i == -1 || C5046bo.isNullOrNil(r0)) {
            Object obj = str;
        } else {
            charSequence = TextUtils.concat(new CharSequence[]{context.getResources().getString(i), str});
        }
        this.mns = charSequence;
        C45966l c45966l2 = this.hpS;
        a = aaw.cEV;
        String str3 = aaw.wif;
        if (C5046bo.isNullOrNil(a)) {
            str = null;
            str2 = str3;
        } else {
            str = str3;
            str2 = a;
        }
        if (!C5046bo.isNullOrNil(str2)) {
            C7616ad aoO = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(str2);
            aoO.setUsername(str2);
            C7616ad c7616ad = null;
            if (C1855t.m3896kH(str2) && !C5046bo.isNullOrNil(str)) {
                c7616ad = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(str);
                c7616ad.setUsername(str);
            }
            boolean z;
            boolean z2;
            switch (c45966l2.mDw) {
                case 9:
                case 16:
                    z = false;
                    z2 = false;
                    break;
                case 10:
                case 17:
                    z = false;
                    break;
                case 11:
                case 18:
                    z = true;
                    break;
                case 12:
                    z = false;
                    z2 = false;
                    break;
                case 13:
                    z = false;
                    break;
                case 14:
                    z = true;
                    break;
                case 20:
                    z2 = false;
                    boolean z3 = false;
                    break;
                case 21:
                    z = false;
                    break;
                case 22:
                    z = true;
                    break;
                default:
                    z = false;
                    z2 = false;
                    int i3 = 0;
                    break;
            }
        }
        charSequence = new SpannableString("");
        this.mnt = charSequence;
        switch (aaw.type) {
            case 3:
                i2 = C1318a.app_attach_file_icon_voice;
                break;
            case 4:
                i2 = C1318a.app_attach_file_icon_video;
                break;
            case 5:
                i2 = C1318a.app_attach_file_icon_webpage;
                break;
            case 6:
                i2 = C1318a.app_attach_file_icon_location;
                break;
            case 8:
                if (aaw.cKb.wiv != null && aaw.cKb.wiv.size() > 0) {
                    i2 = C30034d.ail(((aar) aaw.cKb.wiv.get(0)).wgo);
                    break;
                }
            default:
                i2 = C1318a.fts_default_img;
                break;
        }
        this.mnv = i2;
        AppMethodBeat.m2505o(74494);
    }

    /* renamed from: Ps */
    public final C3156b mo7412Ps() {
        return this.mnw;
    }

    /* renamed from: b */
    private static String m55997b(C7616ad c7616ad, boolean z) {
        String str;
        AppMethodBeat.m2504i(74495);
        if (!z || C5046bo.isNullOrNil(c7616ad.field_conRemark)) {
            str = c7616ad.field_nickname;
        } else {
            str = c7616ad.field_conRemark;
        }
        if (C5046bo.isNullOrNil(str)) {
            str = c7616ad.field_username;
        }
        AppMethodBeat.m2505o(74495);
        return str;
    }

    /* renamed from: bR */
    private String m55998bR(List<String> list) {
        String str;
        AppMethodBeat.m2504i(74497);
        StringBuffer stringBuffer = new StringBuffer();
        for (CharSequence charSequence : this.mDz.mEa) {
            for (String str2 : list) {
                if (C3161d.m5404Nb(str2).contains(charSequence)) {
                    stringBuffer.append(str2);
                    stringBuffer.append(",");
                }
            }
        }
        stringBuffer.trimToSize();
        if (stringBuffer.length() == 0) {
            str2 = "";
            AppMethodBeat.m2505o(74497);
            return str2;
        }
        str2 = stringBuffer.substring(0, stringBuffer.length() - 1);
        AppMethodBeat.m2505o(74497);
        return str2;
    }

    public final int aAq() {
        return this.hpS.mEK;
    }

    /* renamed from: b */
    private static String m55996b(Context context, C7616ad c7616ad) {
        AppMethodBeat.m2504i(74496);
        String str = c7616ad.field_conRemark;
        if (C5046bo.isNullOrNil(str)) {
            str = c7616ad.field_nickname;
        }
        if (C5046bo.isNullOrNil(str)) {
            str = context.getString(C25738R.string.c1j);
        }
        AppMethodBeat.m2505o(74496);
        return str;
    }
}
