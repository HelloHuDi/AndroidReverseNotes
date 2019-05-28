package com.tencent.mm.plugin.brandservice.ui.a;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.aj.f;
import com.tencent.mm.bp.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.s;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.fts.a.a.l;
import com.tencent.mm.plugin.fts.ui.m;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;

public final class a extends com.tencent.mm.plugin.fts.a.d.a.a {
    public ad ehM;
    public l hpS;
    public String iconUrl;
    public CharSequence jMY;
    public CharSequence jMZ;
    private b jNa = new b();
    a jNb = new a();
    public String username;

    public class b extends com.tencent.mm.plugin.fts.a.d.a.a.b {
        public b() {
            super();
        }

        public final View a(Context context, ViewGroup viewGroup) {
            AppMethodBeat.i(14081);
            View inflate = LayoutInflater.from(context).inflate(R.layout.a13, viewGroup, false);
            a aVar = a.this.jNb;
            aVar.ejo = (ImageView) inflate.findViewById(R.id.qk);
            aVar.gnB = (TextView) inflate.findViewById(R.id.qm);
            aVar.gnC = (TextView) inflate.findViewById(R.id.ld);
            aVar.contentView = inflate.findViewById(R.id.qj);
            inflate.setTag(aVar);
            AppMethodBeat.o(14081);
            return inflate;
        }

        public final void a(Context context, com.tencent.mm.plugin.fts.a.d.a.a.a aVar, com.tencent.mm.plugin.fts.a.d.a.a aVar2, Object... objArr) {
            AppMethodBeat.i(14082);
            a aVar3 = (a) aVar2;
            a aVar4 = (a) aVar;
            m.p(aVar4.contentView, a.this.mFk);
            m.a(context, aVar4.ejo, aVar3.iconUrl, null, (int) R.drawable.abh);
            if (t.mP(aVar3.username)) {
                m.a(((com.tencent.mm.openim.a.b) g.K(com.tencent.mm.openim.a.b.class)).a(context, aVar3.jMY), aVar4.gnB);
            } else {
                m.a(aVar3.jMY, aVar4.gnB);
            }
            m.a(aVar3.jMZ, aVar4.gnC);
            AppMethodBeat.o(14082);
        }

        public final boolean a(Context context, com.tencent.mm.plugin.fts.a.d.a.a aVar) {
            AppMethodBeat.i(14083);
            a aVar2 = (a) aVar;
            com.tencent.mm.plugin.fts.a.d.a.a.b.a(a.this.mDz.mDY, aVar2.hpS);
            Intent intent;
            if (f.rc(aVar2.username)) {
                intent = new Intent();
                intent.putExtra("enterprise_biz_name", aVar2.username);
                intent.putExtra("enterprise_biz_display_name", s.mJ(aVar2.username));
                intent.putExtra("enterprise_from_scene", 3);
                d.f(context, ".ui.conversation.EnterpriseConversationUI", intent);
            } else if (f.kq(aVar2.username)) {
                intent = new Intent();
                intent.putExtra("Contact_User", aVar2.username);
                intent.addFlags(67108864);
                intent.putExtra("biz_chat_from_scene", 5);
                d.f(context, ".ui.bizchat.BizChatConversationUI", intent);
            } else if (f.rd(aVar2.username)) {
                com.tencent.mm.aj.d qX = f.qX(aVar2.username);
                String adT = qX == null ? null : qX.adT();
                if (adT == null) {
                    adT = "";
                }
                Intent intent2 = new Intent();
                intent2.putExtra("rawUrl", adT);
                intent2.putExtra("useJs", true);
                intent2.putExtra("srcUsername", aVar2.username);
                intent2.putExtra("bizofstartfrom", "enterpriseHomeSubBrand");
                intent2.addFlags(67108864);
                d.b(context, "webview", ".ui.tools.WebViewUI", intent2);
            } else {
                intent = new Intent();
                intent.putExtra("Chat_User", aVar2.username);
                intent.putExtra("finish_direct", true);
                intent.putExtra("specific_chat_from_scene", 3);
                intent.putExtra("preChatTYPE", 9);
                d.f(context, ".ui.chatting.ChattingUI", intent);
            }
            ai.adO(aVar2.username);
            AppMethodBeat.o(14083);
            return true;
        }
    }

    public class a extends com.tencent.mm.plugin.fts.a.d.a.a.a {
        public View contentView;
        public ImageView ejo;
        public TextView gnB;
        public TextView gnC;

        public a() {
            super();
        }
    }

    public a(int i) {
        super(4, i);
        AppMethodBeat.i(14084);
        AppMethodBeat.o(14084);
    }

    /* JADX WARNING: Missing block: B:10:0x0049, code skipped:
            if (r5 == null) goto L_0x0135;
     */
    /* JADX WARNING: Missing block: B:11:0x004b, code skipped:
            r12.jMY = com.tencent.mm.pluginsdk.ui.e.j.d(r13, r8, (float) com.tencent.mm.bz.a.al(r13, com.tencent.mm.R.dimen.m5));
            r12.jMY = com.tencent.mm.plugin.fts.a.f.a(com.tencent.mm.plugin.fts.a.a.d.a(r12.jMY, r12.mDz, r3, r2)).mDR;
     */
    /* JADX WARNING: Missing block: B:12:0x0069, code skipped:
            if (r4 == null) goto L_0x009c;
     */
    /* JADX WARNING: Missing block: B:13:0x006b, code skipped:
            if (r1 == null) goto L_0x009c;
     */
    /* JADX WARNING: Missing block: B:14:0x006d, code skipped:
            r12.jMZ = com.tencent.mm.pluginsdk.ui.e.j.d(r13, r7, (float) com.tencent.mm.bz.a.al(r13, com.tencent.mm.R.dimen.m5));
            r12.jMZ = com.tencent.mm.plugin.fts.a.f.a(com.tencent.mm.plugin.fts.a.a.d.a(r12.jMZ, r12.mDz, r3, r2)).mDR;
            r12.jMZ = android.text.TextUtils.concat(new java.lang.CharSequence[]{r6, r12.jMZ});
     */
    /* JADX WARNING: Missing block: B:15:0x009c, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.o(14085);
     */
    /* JADX WARNING: Missing block: B:16:0x00a1, code skipped:
            return;
     */
    /* JADX WARNING: Missing block: B:20:0x00a9, code skipped:
            r3 = true;
     */
    /* JADX WARNING: Missing block: B:21:0x00ab, code skipped:
            r5 = 1;
            r2 = r0;
     */
    /* JADX WARNING: Missing block: B:27:0x00c9, code skipped:
            r3 = true;
     */
    /* JADX WARNING: Missing block: B:28:0x00ca, code skipped:
            r9 = ((com.tencent.mm.api.j) com.tencent.mm.kernel.g.K(com.tencent.mm.api.j.class)).cK(r12.username).iterator();
     */
    /* JADX WARNING: Missing block: B:30:0x00e0, code skipped:
            if (r9.hasNext() == false) goto L_0x010a;
     */
    /* JADX WARNING: Missing block: B:31:0x00e2, code skipped:
            r12.jMZ = com.tencent.mm.pluginsdk.ui.e.j.d(r13, (java.lang.String) r9.next(), (float) com.tencent.mm.bz.a.al(r13, com.tencent.mm.R.dimen.m5));
            r0 = com.tencent.mm.plugin.fts.a.f.a(com.tencent.mm.plugin.fts.a.a.d.a(r12.jMZ, r12.mDz, r3, r2));
     */
    /* JADX WARNING: Missing block: B:32:0x0104, code skipped:
            if (r0.bFZ != 0) goto L_0x00dc;
     */
    /* JADX WARNING: Missing block: B:33:0x0106, code skipped:
            r12.jMZ = r0.mDR;
     */
    /* JADX WARNING: Missing block: B:34:0x010a, code skipped:
            r12.jMZ = android.text.TextUtils.concat(new java.lang.CharSequence[]{r12.jMZ, r13.getString(com.tencent.mm.R.string.dze) + r8});
     */
    /* JADX WARNING: Missing block: B:35:0x0135, code skipped:
            r12.jMY = com.tencent.mm.pluginsdk.ui.e.j.d(r13, r8, (float) com.tencent.mm.bz.a.al(r13, com.tencent.mm.R.dimen.m5));
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(Context context, com.tencent.mm.plugin.fts.a.d.a.a.a aVar, Object... objArr) {
        AppMethodBeat.i(14085);
        this.username = this.hpS.mDx;
        this.ehM = ((j) g.K(j.class)).XM().aoO(this.username);
        com.tencent.mm.aj.d qX = f.qX(this.username);
        this.iconUrl = qX == null ? "" : qX.field_brandIconURL;
        CharSequence mJ = s.mJ(this.username);
        CharSequence charSequence = null;
        String str = null;
        Object obj = null;
        Object obj2 = null;
        boolean z = false;
        boolean z2 = false;
        Object obj3 = (qX == null || qX.adV()) ? 1 : null;
        boolean z3;
        switch (this.hpS.mDw) {
            case 1:
                z3 = false;
                break;
            case 2:
                z3 = false;
                break;
            case 3:
                z3 = true;
                break;
            case 15:
                obj2 = 1;
                String Hq = this.ehM.Hq();
                if (bo.isNullOrNil(Hq)) {
                    Hq = this.ehM.field_username;
                }
                str = context.getString(R.string.e09);
                Object charSequence2 = Hq;
                break;
            case 19:
                break;
            case 20:
                break;
            case 21:
                z2 = true;
                break;
        }
    }

    public final com.tencent.mm.plugin.fts.a.d.a.a.b Ps() {
        return this.jNa;
    }

    public final int aAq() {
        return this.hpS.mEK;
    }

    public final String aAp() {
        AppMethodBeat.i(14086);
        String charSequence;
        if (this.jMY != null) {
            charSequence = this.jMY.toString();
            AppMethodBeat.o(14086);
            return charSequence;
        }
        charSequence = "";
        AppMethodBeat.o(14086);
        return charSequence;
    }
}
