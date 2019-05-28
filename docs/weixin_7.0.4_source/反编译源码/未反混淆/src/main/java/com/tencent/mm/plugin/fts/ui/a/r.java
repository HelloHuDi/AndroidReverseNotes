package com.tencent.mm.plugin.fts.ui.a;

import android.content.Context;
import android.content.Intent;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.bp.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.openim.a.c;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.fts.ui.a.b.b;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import java.util.List;

public final class r extends b {
    private a mLp = new a();

    public class a extends b {
        public a() {
            super();
        }

        public final boolean a(Context context, com.tencent.mm.plugin.fts.a.d.a.a aVar) {
            AppMethodBeat.i(62035);
            r rVar = (r) aVar;
            com.tencent.mm.plugin.fts.a.d.a.a.b.a(r.this.mDz.mDY, rVar.hpS);
            d.f(context, ".ui.chatting.ChattingUI", new Intent().putExtra("Chat_User", rVar.username).putExtra("finish_direct", true));
            AppMethodBeat.o(62035);
            return true;
        }
    }

    public r(int i) {
        super(i);
        AppMethodBeat.i(62036);
        AppMethodBeat.o(62036);
    }

    /* JADX WARNING: Missing block: B:3:0x0034, code skipped:
            if (r5 == null) goto L_0x01fa;
     */
    /* JADX WARNING: Missing block: B:4:0x0036, code skipped:
            r14.jMY = com.tencent.mm.pluginsdk.ui.e.j.d(r15, r9, (float) com.tencent.mm.bz.a.al(r15, com.tencent.mm.R.dimen.m5));
            r14.jMY = com.tencent.mm.plugin.fts.a.f.a(com.tencent.mm.plugin.fts.a.a.d.a(r14.jMY, r14.mDz, r2, r3, (float) com.tencent.mm.plugin.fts.ui.b.a.mHq, com.tencent.mm.plugin.fts.ui.b.c.mHx)).mDR;
     */
    /* JADX WARNING: Missing block: B:5:0x0059, code skipped:
            if (r6 == null) goto L_0x008f;
     */
    /* JADX WARNING: Missing block: B:6:0x005b, code skipped:
            r14.jMZ = com.tencent.mm.pluginsdk.ui.e.j.d(r15, r7, (float) com.tencent.mm.bz.a.al(r15, com.tencent.mm.R.dimen.m5));
            r14.jMZ = com.tencent.mm.plugin.fts.a.f.a(com.tencent.mm.plugin.fts.a.a.d.a(r14.jMZ, r14.mDz, r2, r3, (float) com.tencent.mm.plugin.fts.ui.b.a.mHq, com.tencent.mm.plugin.fts.ui.b.c.mHz)).mDR;
            r14.jMZ = android.text.TextUtils.concat(new java.lang.CharSequence[]{r8, r14.jMZ});
     */
    /* JADX WARNING: Missing block: B:8:0x0097, code skipped:
            if (com.tencent.mm.storage.ad.aox(r14.ehM.field_username) == false) goto L_0x020a;
     */
    /* JADX WARNING: Missing block: B:9:0x0099, code skipped:
            r14.mJU = ((com.tencent.mm.openim.a.b) com.tencent.mm.kernel.g.K(com.tencent.mm.openim.a.b.class)).ba(r14.ehM.field_openImAppid, r14.ehM.field_descWordingId);
            com.tencent.matrix.trace.core.AppMethodBeat.o(62037);
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
            r8 = r15.getString(com.tencent.mm.R.string.e05);
     */
    /* JADX WARNING: Missing block: B:49:0x01fa, code skipped:
            r14.jMY = com.tencent.mm.pluginsdk.ui.e.j.d(r15, r9, (float) com.tencent.mm.bz.a.al(r15, com.tencent.mm.R.dimen.m5));
     */
    /* JADX WARNING: Missing block: B:50:0x020a, code skipped:
            r14.mJU = "";
            com.tencent.matrix.trace.core.AppMethodBeat.o(62037);
     */
    /* JADX WARNING: Missing block: B:61:?, code skipped:
            return;
     */
    /* JADX WARNING: Missing block: B:62:?, code skipped:
            return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(Context context, com.tencent.mm.plugin.fts.a.d.a.a.a aVar, Object... objArr) {
        AppMethodBeat.i(62037);
        this.username = this.hpS.mDx;
        this.ehM = ((j) g.K(j.class)).XM().aoO(this.username);
        CharSequence charSequence = null;
        CharSequence charSequence2 = null;
        Object obj = null;
        boolean z = false;
        boolean z2 = false;
        CharSequence LC = com.tencent.mm.plugin.fts.a.d.LC(this.username);
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
                charSequence3 = context.getString(R.string.e00);
                break;
            case 5:
                break;
            case 6:
                break;
            case 7:
                z2 = true;
                break;
            case 11:
                List<String> MX = ((n) g.M(n.class)).getFTSMainDB().MX(this.ehM.field_contactLabelIds);
                StringBuffer stringBuffer = new StringBuffer();
                for (CharSequence charSequence4 : this.mDz.mEa) {
                    for (String str2 : MX) {
                        if (com.tencent.mm.plugin.fts.a.d.Nb(str2).contains(charSequence4)) {
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
                charSequence3 = context.getString(R.string.e08);
                break;
            case 15:
                str2 = this.ehM.Hq();
                if (bo.isNullOrNil(str2)) {
                    str2 = this.ehM.field_username;
                }
                i = 1;
                charSequence22 = str2;
                charSequence3 = context.getString(R.string.e09);
                break;
            case 16:
                String str3 = this.hpS.content;
                if (!bo.isNullOrNil(str3)) {
                    for (String str22 : str3.split("​")) {
                        if (str22.startsWith(this.mDz.mDY)) {
                            i = 1;
                            charSequence22 = str22;
                            charSequence3 = context.getString(R.string.e04);
                            break;
                        }
                    }
                }
                str22 = str3;
                i = 1;
                charSequence22 = str22;
                charSequence3 = context.getString(R.string.e04);
            case 17:
                i = 1;
                charSequence22 = this.hpS.content;
                charSequence3 = context.getString(R.string.dzz);
                break;
            case 18:
                i = 1;
                charSequence22 = this.hpS.content;
                charSequence3 = context.getString(R.string.e06);
                break;
            case 51:
                Pair K = K(this.ehM);
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

    private Pair<String, String> K(ad adVar) {
        AppMethodBeat.i(62038);
        c cVar = new c();
        cVar.vj(adVar.duw);
        for (int i = 0; i < cVar.geU.size(); i++) {
            com.tencent.mm.openim.a.c.a aVar = (com.tencent.mm.openim.a.c.a) cVar.geU.get(i);
            for (c.b vk : aVar.geV) {
                String vk2 = vk.vk(adVar.field_openImAppid);
                if (!bo.isNullOrNil(vk2)) {
                    for (CharSequence contains : this.mDz.mEa) {
                        if (vk2.contains(contains)) {
                            Pair<String, String> pair = new Pair(aVar.title, vk2);
                            AppMethodBeat.o(62038);
                            return pair;
                        }
                    }
                    continue;
                }
            }
        }
        AppMethodBeat.o(62038);
        return null;
    }

    public final com.tencent.mm.plugin.fts.a.d.a.a.b Ps() {
        return this.mLp;
    }

    public final String aAp() {
        AppMethodBeat.i(62039);
        String str;
        if (this.ehM == null || !ad.aox(this.ehM.field_username)) {
            str = "";
            AppMethodBeat.o(62039);
            return str;
        }
        str = "openim:" + this.ehM.field_openImAppid;
        AppMethodBeat.o(62039);
        return str;
    }
}
