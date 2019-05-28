package com.tencent.mm.plugin.fav.ui.b;

import android.content.Context;
import android.os.Looper;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.gh;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.fts.a.a.d;
import com.tencent.mm.plugin.fts.a.a.l;
import com.tencent.mm.plugin.fts.a.f;
import com.tencent.mm.plugin.fts.ui.b.c;
import com.tencent.mm.plugin.fts.ui.m;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.protocal.protobuf.aar;
import com.tencent.mm.protocal.protobuf.aaw;
import com.tencent.mm.protocal.protobuf.aay;
import com.tencent.mm.protocal.protobuf.abf;
import com.tencent.mm.protocal.protobuf.abh;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.ui.MMImageView;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

public final class a extends com.tencent.mm.plugin.fts.a.d.a.a {
    private static final ak handler = new ak(Looper.getMainLooper());
    private static final String mnp = ah.getContext().getString(R.string.c25);
    private static final Pattern mnq = Pattern.compile("['\r\n' | '\n']+");
    public String gEl;
    public l hpS;
    public CharSequence mnr;
    public CharSequence mns;
    public CharSequence mnt;
    public String mnu;
    public int mnv;
    private b mnw = new b();
    a mnx = new a();

    public class a extends com.tencent.mm.plugin.fts.a.d.a.a.a {
        public View contentView;
        public TextView gnB;
        public TextView mnA;
        public MMImageView mny;
        public TextView mnz;

        public a() {
            super();
        }
    }

    public class b extends com.tencent.mm.plugin.fts.a.d.a.a.b {
        public b() {
            super();
        }

        public final View a(Context context, ViewGroup viewGroup) {
            AppMethodBeat.i(74489);
            View inflate = LayoutInflater.from(context).inflate(R.layout.a1f, viewGroup, false);
            a aVar = a.this.mnx;
            aVar.mny = (MMImageView) inflate.findViewById(R.id.qk);
            aVar.gnB = (TextView) inflate.findViewById(R.id.qm);
            aVar.mnz = (TextView) inflate.findViewById(R.id.bxu);
            aVar.mnA = (TextView) inflate.findViewById(R.id.bxv);
            aVar.contentView = inflate.findViewById(R.id.qj);
            inflate.setTag(aVar);
            AppMethodBeat.o(74489);
            return inflate;
        }

        public final void a(Context context, com.tencent.mm.plugin.fts.a.d.a.a.a aVar, com.tencent.mm.plugin.fts.a.d.a.a aVar2, Object... objArr) {
            AppMethodBeat.i(74490);
            a aVar3 = (a) aVar;
            a aVar4 = (a) aVar2;
            m.p(aVar3.contentView, a.this.mFk);
            m.a(context, aVar3.mny, aVar4.gEl, aVar4.mnu, aVar4.mnv, false, aVar3.mny.getMeasuredWidth(), aVar3.mny.getMeasuredHeight());
            a.a(aVar3.gnB, aVar3.mnz, a.this.mnr, a.this.mns);
            m.a(a.this.mnt, aVar3.mnA);
            AppMethodBeat.o(74490);
        }

        public final boolean a(Context context, com.tencent.mm.plugin.fts.a.d.a.a aVar) {
            AppMethodBeat.i(74491);
            a aVar2 = (a) aVar;
            gh ghVar = new gh();
            ghVar.cAH.type = 10;
            ghVar.cAH.cvv = aVar2.hpS.mEB;
            ghVar.cAH.context = context;
            ghVar.cAH.cAS = new abh();
            if (a.this.pageType == 1) {
                ghVar.cAH.cAS.scene = 3;
            } else {
                ghVar.cAH.cAS.scene = 4;
            }
            ghVar.cAH.cAS.jSW = 3;
            ghVar.cAH.cAS.index = a.this.mFn;
            com.tencent.mm.sdk.b.a.xxA.m(ghVar);
            AppMethodBeat.o(74491);
            return true;
        }
    }

    static {
        AppMethodBeat.i(74498);
        AppMethodBeat.o(74498);
    }

    public static void a(TextView textView, TextView textView2, CharSequence charSequence, CharSequence charSequence2) {
        AppMethodBeat.i(74492);
        if (!m.a(charSequence, textView)) {
            if (m.a(charSequence2, textView2)) {
                textView2.setMaxLines(2);
            }
            AppMethodBeat.o(74492);
        } else if (m.a(charSequence2, textView2)) {
            textView.setMaxLines(1);
            textView2.setMaxLines(1);
            AppMethodBeat.o(74492);
        } else {
            textView.setMaxLines(2);
            AppMethodBeat.o(74492);
        }
    }

    public a(int i) {
        super(7, i);
        AppMethodBeat.i(74493);
        AppMethodBeat.o(74493);
    }

    /* JADX WARNING: Missing block: B:78:0x027f, code skipped:
            if (r0 == null) goto L_0x0375;
     */
    /* JADX WARNING: Missing block: B:79:0x0281, code skipped:
            r6 = b(r0, true) + "-" + b(r13, r9);
            r0 = r1;
            r3 = r2;
     */
    /* JADX WARNING: Missing block: B:80:0x02a3, code skipped:
            r1 = com.tencent.mm.pluginsdk.ui.e.j.b(r13, r6, com.tencent.mm.bz.a.al(r13, com.tencent.mm.R.dimen.kr));
     */
    /* JADX WARNING: Missing block: B:81:0x02ae, code skipped:
            if (r7 == 0) goto L_0x03c3;
     */
    /* JADX WARNING: Missing block: B:82:0x02b0, code skipped:
            r0 = com.tencent.mm.plugin.fts.a.f.a(com.tencent.mm.plugin.fts.a.a.d.a(r1, r12.mDz, r3, r0)).mDR;
     */
    /* JADX WARNING: Missing block: B:83:0x02bc, code skipped:
            r0 = android.text.TextUtils.concat(new java.lang.CharSequence[]{r13.getResources().getString(com.tencent.mm.R.string.dzt), r0});
     */
    /* JADX WARNING: Missing block: B:85:0x02d4, code skipped:
            r2 = true;
     */
    /* JADX WARNING: Missing block: B:86:0x02d5, code skipped:
            if (r0 == null) goto L_0x02fb;
     */
    /* JADX WARNING: Missing block: B:87:0x02d7, code skipped:
            r6 = b(r0, false) + "-" + b(r13, r9);
            r0 = r1;
            r3 = r2;
            r7 = 1;
     */
    /* JADX WARNING: Missing block: B:88:0x02fb, code skipped:
            r6 = b(r9, false);
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
            r1 = b(r0, true) + "-" + b(r13, r9);
     */
    /* JADX WARNING: Missing block: B:93:0x0329, code skipped:
            r1 = r1 + "-" + b(((com.tencent.mm.plugin.messenger.foundation.a.j) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).XM().aoO(r8.csl), true);
            r0 = r2;
            r6 = r1;
            r7 = 1;
     */
    /* JADX WARNING: Missing block: B:95:0x0362, code skipped:
            if (com.tencent.mm.model.t.kH(r9.field_username) == false) goto L_0x036a;
     */
    /* JADX WARNING: Missing block: B:96:0x0364, code skipped:
            r1 = b(r13, r9);
     */
    /* JADX WARNING: Missing block: B:97:0x036a, code skipped:
            r1 = b(r9, true);
     */
    /* JADX WARNING: Missing block: B:99:0x0371, code skipped:
            r2 = true;
     */
    /* JADX WARNING: Missing block: B:100:0x0372, code skipped:
            r7 = 1;
     */
    /* JADX WARNING: Missing block: B:102:0x037b, code skipped:
            if (com.tencent.mm.model.t.kH(r9.field_username) == false) goto L_0x0385;
     */
    /* JADX WARNING: Missing block: B:103:0x037d, code skipped:
            r6 = b(r13, r9);
            r0 = r1;
            r3 = r2;
     */
    /* JADX WARNING: Missing block: B:104:0x0385, code skipped:
            r6 = b(r9, true);
            r0 = r1;
            r3 = r2;
     */
    /* JADX WARNING: Missing block: B:114:0x03c3, code skipped:
            r0 = r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(Context context, com.tencent.mm.plugin.fts.a.d.a.a.a aVar, Object... objArr) {
        aay aay;
        String a;
        String str;
        int i;
        String str2;
        int i2;
        AppMethodBeat.i(74494);
        long j = this.hpS.mEB;
        gh ghVar = new gh();
        ghVar.cAH.type = 9;
        ghVar.cAH.cvv = j;
        com.tencent.mm.sdk.b.a.xxA.m(ghVar);
        aaw aaw = ghVar.cAI.cAT;
        j = this.hpS.mEB;
        ghVar = new gh();
        ghVar.cAH.type = 11;
        ghVar.cAH.cvv = j;
        ghVar.cAH.handler = handler;
        com.tencent.mm.sdk.b.a.xxA.m(ghVar);
        this.mnu = bo.bc(ghVar.cAI.thumbPath, "");
        this.gEl = bo.bc(ghVar.cAI.thumbUrl, "");
        l lVar = this.hpS;
        float f = (float) (com.tencent.mm.plugin.fts.ui.b.a.mHq * 2);
        abf abf = aaw.cKb;
        CharSequence charSequence = "";
        switch (aaw.type) {
            case 1:
                charSequence = mnq.matcher(aaw.desc).replaceAll(" ");
                break;
            case 2:
                charSequence = context.getResources().getString(R.string.e0i);
                break;
            case 3:
                charSequence = context.getResources().getString(R.string.e0n);
                break;
            case 4:
                charSequence = context.getResources().getString(R.string.e0m);
                break;
            case 6:
                aay = aaw.cKb.why;
                if (!mnp.equals(aay.cIK) && !bo.isNullOrNil(aay.cIK)) {
                    charSequence = aay.cIK;
                    break;
                } else {
                    charSequence = aay.label;
                    break;
                }
                break;
            case 7:
                charSequence = aaw.title;
                if (!bo.isNullOrNil(aaw.desc)) {
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
                    a = com.tencent.mm.plugin.fav.a.b.a((aar) it.next());
                    if (!bo.isNullOrNil(a)) {
                        stringBuffer.append(a);
                        stringBuffer.append(" ");
                    }
                }
                charSequence = mnq.matcher(stringBuffer.toString()).replaceAll(" ");
                if (bo.isNullOrNil(charSequence)) {
                    charSequence = context.getResources().getString(R.string.e0k);
                    break;
                }
                break;
            case 16:
                charSequence = context.getResources().getString(R.string.e0l);
                break;
            default:
                charSequence = aaw.title;
                break;
        }
        switch (lVar.mDw) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                charSequence = f.a(d.a(charSequence, this.mDz, f, c.mHz)).mDR;
                break;
        }
        this.mnr = charSequence;
        lVar = this.hpS;
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
                if (!bo.isNullOrNil(aaw.appId)) {
                    charSequence = com.tencent.mm.model.ad.a.fls.t(context, aaw.appId);
                    break;
                }
                break;
            case 6:
                aay = aaw.cKb.why;
                if (!mnp.equals(aay.cIK) && !bo.isNullOrNil(aay.cIK)) {
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
        switch (lVar.mDw) {
            case 6:
                str = f.a(d.a(charSequence, this.mDz)).mDR;
                i = -1;
                break;
            case 7:
            case 8:
                i = R.string.e0j;
                charSequence = bR(aaw.wig);
                str = f.a(d.a(charSequence, this.mDz)).mDR;
                break;
            case 23:
                i = R.string.e0h;
                str = f.a(d.a(charSequence, this.mDz)).mDR;
                break;
            default:
                str = "";
                i = -1;
                break;
        }
        if (i == -1 || bo.isNullOrNil(r0)) {
            Object obj = str;
        } else {
            charSequence = TextUtils.concat(new CharSequence[]{context.getResources().getString(i), str});
        }
        this.mns = charSequence;
        l lVar2 = this.hpS;
        a = aaw.cEV;
        String str3 = aaw.wif;
        if (bo.isNullOrNil(a)) {
            str = null;
            str2 = str3;
        } else {
            str = str3;
            str2 = a;
        }
        if (!bo.isNullOrNil(str2)) {
            ad aoO = ((j) g.K(j.class)).XM().aoO(str2);
            aoO.setUsername(str2);
            ad adVar = null;
            if (t.kH(str2) && !bo.isNullOrNil(str)) {
                adVar = ((j) g.K(j.class)).XM().aoO(str);
                adVar.setUsername(str);
            }
            boolean z;
            boolean z2;
            switch (lVar2.mDw) {
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
                i2 = R.raw.app_attach_file_icon_voice;
                break;
            case 4:
                i2 = R.raw.app_attach_file_icon_video;
                break;
            case 5:
                i2 = R.raw.app_attach_file_icon_webpage;
                break;
            case 6:
                i2 = R.raw.app_attach_file_icon_location;
                break;
            case 8:
                if (aaw.cKb.wiv != null && aaw.cKb.wiv.size() > 0) {
                    i2 = com.tencent.mm.pluginsdk.d.ail(((aar) aaw.cKb.wiv.get(0)).wgo);
                    break;
                }
            default:
                i2 = R.raw.fts_default_img;
                break;
        }
        this.mnv = i2;
        AppMethodBeat.o(74494);
    }

    public final com.tencent.mm.plugin.fts.a.d.a.a.b Ps() {
        return this.mnw;
    }

    private static String b(ad adVar, boolean z) {
        String str;
        AppMethodBeat.i(74495);
        if (!z || bo.isNullOrNil(adVar.field_conRemark)) {
            str = adVar.field_nickname;
        } else {
            str = adVar.field_conRemark;
        }
        if (bo.isNullOrNil(str)) {
            str = adVar.field_username;
        }
        AppMethodBeat.o(74495);
        return str;
    }

    private String bR(List<String> list) {
        String str;
        AppMethodBeat.i(74497);
        StringBuffer stringBuffer = new StringBuffer();
        for (CharSequence charSequence : this.mDz.mEa) {
            for (String str2 : list) {
                if (com.tencent.mm.plugin.fts.a.d.Nb(str2).contains(charSequence)) {
                    stringBuffer.append(str2);
                    stringBuffer.append(",");
                }
            }
        }
        stringBuffer.trimToSize();
        if (stringBuffer.length() == 0) {
            str2 = "";
            AppMethodBeat.o(74497);
            return str2;
        }
        str2 = stringBuffer.substring(0, stringBuffer.length() - 1);
        AppMethodBeat.o(74497);
        return str2;
    }

    public final int aAq() {
        return this.hpS.mEK;
    }

    private static String b(Context context, ad adVar) {
        AppMethodBeat.i(74496);
        String str = adVar.field_conRemark;
        if (bo.isNullOrNil(str)) {
            str = adVar.field_nickname;
        }
        if (bo.isNullOrNil(str)) {
            str = context.getString(R.string.c1j);
        }
        AppMethodBeat.o(74496);
        return str;
    }
}
