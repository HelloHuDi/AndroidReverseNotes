package com.tencent.p177mm.plugin.fts.p424ui.p425a;

import android.content.Context;
import android.content.Intent;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.openim.p1210a.C32875c;
import com.tencent.p177mm.openim.p1210a.C32875c.C18734a;
import com.tencent.p177mm.openim.p1210a.C32875c.C26514b;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.fts.p419a.C12029n;
import com.tencent.p177mm.plugin.fts.p419a.C3161d;
import com.tencent.p177mm.plugin.fts.p419a.p421d.p422a.C3154a;
import com.tencent.p177mm.plugin.fts.p419a.p421d.p422a.C3154a.C3155a;
import com.tencent.p177mm.plugin.fts.p419a.p421d.p422a.C3154a.C3156b;
import com.tencent.p177mm.plugin.fts.p424ui.p425a.C20869b.C20870b;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7616ad;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.fts.ui.a.r */
public final class C3195r extends C20869b {
    private C3196a mLp = new C3196a();

    /* renamed from: com.tencent.mm.plugin.fts.ui.a.r$a */
    public class C3196a extends C20870b {
        public C3196a() {
            super();
        }

        /* renamed from: a */
        public final boolean mo7422a(Context context, C3154a c3154a) {
            AppMethodBeat.m2504i(62035);
            C3195r c3195r = (C3195r) c3154a;
            C3156b.m5386a(C3195r.this.mDz.mDY, c3195r.hpS);
            C25985d.m41473f(context, ".ui.chatting.ChattingUI", new Intent().putExtra("Chat_User", c3195r.username).putExtra("finish_direct", true));
            AppMethodBeat.m2505o(62035);
            return true;
        }
    }

    public C3195r(int i) {
        super(i);
        AppMethodBeat.m2504i(62036);
        AppMethodBeat.m2505o(62036);
    }

    /* JADX WARNING: Missing block: B:3:0x0034, code skipped:
            if (r5 == null) goto L_0x01fa;
     */
    /* JADX WARNING: Missing block: B:4:0x0036, code skipped:
            r14.jMY = com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j.m79300d(r15, r9, (float) com.tencent.p177mm.p208bz.C1338a.m2856al(r15, com.tencent.p177mm.C25738R.dimen.f9980m5));
            r14.jMY = com.tencent.p177mm.plugin.fts.p419a.C34204f.m56086a(com.tencent.p177mm.plugin.fts.p419a.p420a.C39127d.m66569a(r14.jMY, r14.mDz, r2, r3, (float) com.tencent.p177mm.plugin.fts.p424ui.C45976b.C20875a.mHq, com.tencent.p177mm.plugin.fts.p424ui.C45976b.C3197c.mHx)).mDR;
     */
    /* JADX WARNING: Missing block: B:5:0x0059, code skipped:
            if (r6 == null) goto L_0x008f;
     */
    /* JADX WARNING: Missing block: B:6:0x005b, code skipped:
            r14.jMZ = com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j.m79300d(r15, r7, (float) com.tencent.p177mm.p208bz.C1338a.m2856al(r15, com.tencent.p177mm.C25738R.dimen.f9980m5));
            r14.jMZ = com.tencent.p177mm.plugin.fts.p419a.C34204f.m56086a(com.tencent.p177mm.plugin.fts.p419a.p420a.C39127d.m66569a(r14.jMZ, r14.mDz, r2, r3, (float) com.tencent.p177mm.plugin.fts.p424ui.C45976b.C20875a.mHq, com.tencent.p177mm.plugin.fts.p424ui.C45976b.C3197c.mHz)).mDR;
            r14.jMZ = android.text.TextUtils.concat(new java.lang.CharSequence[]{r8, r14.jMZ});
     */
    /* JADX WARNING: Missing block: B:8:0x0097, code skipped:
            if (com.tencent.p177mm.storage.C7616ad.aox(r14.ehM.field_username) == false) goto L_0x020a;
     */
    /* JADX WARNING: Missing block: B:9:0x0099, code skipped:
            r14.mJU = ((com.tencent.p177mm.openim.p1210a.C32873b) com.tencent.p177mm.kernel.C1720g.m3528K(com.tencent.p177mm.openim.p1210a.C32873b.class)).mo44306ba(r14.ehM.field_openImAppid, r14.ehM.field_descWordingId);
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(62037);
     */
    /* JADX WARNING: Missing block: B:11:0x00b7, code skipped:
            r1 = true;
     */
    /* JADX WARNING: Missing block: B:12:0x00b8, code skipped:
            r5 = 1;
            r3 = r0;
            r2 = r1;
            r6 = null;
     */
    /* JADX WARNING: Missing block: B:14:0x00bf, code skipped:
            r2 = true;
     */
    /* JADX WARNING: Missing block: B:15:0x00c0, code skipped:
            r6 = 1;
            r7 = r14.ehM.field_nickname;
            r8 = r15.getString(com.tencent.p177mm.C25738R.string.e05);
     */
    /* JADX WARNING: Missing block: B:49:0x01fa, code skipped:
            r14.jMY = com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j.m79300d(r15, r9, (float) com.tencent.p177mm.p208bz.C1338a.m2856al(r15, com.tencent.p177mm.C25738R.dimen.f9980m5));
     */
    /* JADX WARNING: Missing block: B:50:0x020a, code skipped:
            r14.mJU = "";
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(62037);
     */
    /* JADX WARNING: Missing block: B:61:?, code skipped:
            return;
     */
    /* JADX WARNING: Missing block: B:62:?, code skipped:
            return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public final void mo7413a(Context context, C3155a c3155a, Object... objArr) {
        AppMethodBeat.m2504i(62037);
        this.username = this.hpS.mDx;
        this.ehM = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(this.username);
        CharSequence charSequence = null;
        CharSequence charSequence2 = null;
        Object obj = null;
        boolean z = false;
        boolean z2 = false;
        CharSequence LC = C3161d.m5401LC(this.username);
        boolean z3;
        int i;
        Object charSequence22;
        Object charSequence3;
        String str;
        switch (this.hpS.mDw) {
            case 1:
                z3 = false;
                boolean z4 = false;
                break;
            case 2:
                z3 = false;
                break;
            case 3:
                z3 = true;
                break;
            case 4:
                i = 1;
                charSequence22 = this.ehM.dul;
                charSequence3 = context.getString(C25738R.string.e00);
                break;
            case 5:
                break;
            case 6:
                break;
            case 7:
                z2 = true;
                break;
            case 11:
                List<String> MX = ((C12029n) C1720g.m3530M(C12029n.class)).getFTSMainDB().mo46036MX(this.ehM.field_contactLabelIds);
                StringBuffer stringBuffer = new StringBuffer();
                for (CharSequence charSequence4 : this.mDz.mEa) {
                    for (String str2 : MX) {
                        if (C3161d.m5404Nb(str2).contains(charSequence4)) {
                            stringBuffer.append(str2);
                            stringBuffer.append(",");
                        }
                    }
                }
                stringBuffer.trimToSize();
                if (stringBuffer.length() == 0) {
                    str2 = "";
                } else {
                    str2 = stringBuffer.substring(0, stringBuffer.length() - 1);
                }
                i = 1;
                charSequence22 = str2;
                charSequence3 = context.getString(C25738R.string.e08);
                break;
            case 15:
                str2 = this.ehM.mo14673Hq();
                if (C5046bo.isNullOrNil(str2)) {
                    str2 = this.ehM.field_username;
                }
                i = 1;
                charSequence22 = str2;
                charSequence3 = context.getString(C25738R.string.e09);
                break;
            case 16:
                String str3 = this.hpS.content;
                if (!C5046bo.isNullOrNil(str3)) {
                    for (String str22 : str3.split("​")) {
                        if (str22.startsWith(this.mDz.mDY)) {
                            i = 1;
                            charSequence22 = str22;
                            charSequence3 = context.getString(C25738R.string.e04);
                            break;
                        }
                    }
                }
                str22 = str3;
                i = 1;
                charSequence22 = str22;
                charSequence3 = context.getString(C25738R.string.e04);
            case 17:
                i = 1;
                charSequence22 = this.hpS.content;
                charSequence3 = context.getString(C25738R.string.dzz);
                break;
            case 18:
                i = 1;
                charSequence22 = this.hpS.content;
                charSequence3 = context.getString(C25738R.string.e06);
                break;
            case 51:
                Pair K = m5483K(this.ehM);
                if (K == null) {
                    i = 1;
                    charSequence22 = "";
                    charSequence3 = "";
                    break;
                }
                i = 1;
                charSequence22 = (String) K.second;
                charSequence3 = ((String) K.first) + "：";
                break;
            default:
                Object i2 = null;
                break;
        }
    }

    /* renamed from: K */
    private Pair<String, String> m5483K(C7616ad c7616ad) {
        AppMethodBeat.m2504i(62038);
        C32875c c32875c = new C32875c();
        c32875c.mo53440vj(c7616ad.duw);
        for (int i = 0; i < c32875c.geU.size(); i++) {
            C18734a c18734a = (C18734a) c32875c.geU.get(i);
            for (C26514b vk : c18734a.geV) {
                String vk2 = vk.mo44297vk(c7616ad.field_openImAppid);
                if (!C5046bo.isNullOrNil(vk2)) {
                    for (CharSequence contains : this.mDz.mEa) {
                        if (vk2.contains(contains)) {
                            Pair<String, String> pair = new Pair(c18734a.title, vk2);
                            AppMethodBeat.m2505o(62038);
                            return pair;
                        }
                    }
                    continue;
                }
            }
        }
        AppMethodBeat.m2505o(62038);
        return null;
    }

    /* renamed from: Ps */
    public final C3156b mo7412Ps() {
        return this.mLp;
    }

    public final String aAp() {
        AppMethodBeat.m2504i(62039);
        String str;
        if (this.ehM == null || !C7616ad.aox(this.ehM.field_username)) {
            str = "";
            AppMethodBeat.m2505o(62039);
            return str;
        }
        str = "openim:" + this.ehM.field_openImAppid;
        AppMethodBeat.m2505o(62039);
        return str;
    }
}
