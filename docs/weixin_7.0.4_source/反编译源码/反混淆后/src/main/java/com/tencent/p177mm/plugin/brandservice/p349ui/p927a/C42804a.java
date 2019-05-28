package com.tencent.p177mm.plugin.brandservice.p349ui.p927a;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1854s;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.openim.p1210a.C32873b;
import com.tencent.p177mm.p184aj.C16527d;
import com.tencent.p177mm.p184aj.C17903f;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.fts.p419a.p420a.C45966l;
import com.tencent.p177mm.plugin.fts.p419a.p421d.p422a.C3154a;
import com.tencent.p177mm.plugin.fts.p419a.p421d.p422a.C3154a.C3155a;
import com.tencent.p177mm.plugin.fts.p419a.p421d.p422a.C3154a.C3156b;
import com.tencent.p177mm.plugin.fts.p424ui.C3201m;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.websearch.api.C35573ai;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7616ad;

/* renamed from: com.tencent.mm.plugin.brandservice.ui.a.a */
public final class C42804a extends C3154a {
    public C7616ad ehM;
    public C45966l hpS;
    public String iconUrl;
    public CharSequence jMY;
    public CharSequence jMZ;
    private C11199b jNa = new C11199b();
    C42803a jNb = new C42803a();
    public String username;

    /* renamed from: com.tencent.mm.plugin.brandservice.ui.a.a$b */
    public class C11199b extends C3156b {
        public C11199b() {
            super();
        }

        /* renamed from: a */
        public final View mo7420a(Context context, ViewGroup viewGroup) {
            AppMethodBeat.m2504i(14081);
            View inflate = LayoutInflater.from(context).inflate(2130969608, viewGroup, false);
            C42803a c42803a = C42804a.this.jNb;
            c42803a.ejo = (ImageView) inflate.findViewById(2131821183);
            c42803a.gnB = (TextView) inflate.findViewById(2131821185);
            c42803a.gnC = (TextView) inflate.findViewById(2131820991);
            c42803a.contentView = inflate.findViewById(2131821182);
            inflate.setTag(c42803a);
            AppMethodBeat.m2505o(14081);
            return inflate;
        }

        /* renamed from: a */
        public final void mo7421a(Context context, C3155a c3155a, C3154a c3154a, Object... objArr) {
            AppMethodBeat.m2504i(14082);
            C42804a c42804a = (C42804a) c3154a;
            C42803a c42803a = (C42803a) c3155a;
            C3201m.m5503p(c42803a.contentView, C42804a.this.mFk);
            C3201m.m5499a(context, c42803a.ejo, c42804a.iconUrl, null, (int) C25738R.drawable.abh);
            if (C1855t.m3903mP(c42804a.username)) {
                C3201m.m5501a(((C32873b) C1720g.m3528K(C32873b.class)).mo44298a(context, c42804a.jMY), c42803a.gnB);
            } else {
                C3201m.m5501a(c42804a.jMY, c42803a.gnB);
            }
            C3201m.m5501a(c42804a.jMZ, c42803a.gnC);
            AppMethodBeat.m2505o(14082);
        }

        /* renamed from: a */
        public final boolean mo7422a(Context context, C3154a c3154a) {
            AppMethodBeat.m2504i(14083);
            C42804a c42804a = (C42804a) c3154a;
            C3156b.m5386a(C42804a.this.mDz.mDY, c42804a.hpS);
            Intent intent;
            if (C17903f.m28109rc(c42804a.username)) {
                intent = new Intent();
                intent.putExtra("enterprise_biz_name", c42804a.username);
                intent.putExtra("enterprise_biz_display_name", C1854s.m3866mJ(c42804a.username));
                intent.putExtra("enterprise_from_scene", 3);
                C25985d.m41473f(context, ".ui.conversation.EnterpriseConversationUI", intent);
            } else if (C17903f.m28103kq(c42804a.username)) {
                intent = new Intent();
                intent.putExtra("Contact_User", c42804a.username);
                intent.addFlags(67108864);
                intent.putExtra("biz_chat_from_scene", 5);
                C25985d.m41473f(context, ".ui.bizchat.BizChatConversationUI", intent);
            } else if (C17903f.m28110rd(c42804a.username)) {
                C16527d qX = C17903f.m28104qX(c42804a.username);
                String adT = qX == null ? null : qX.adT();
                if (adT == null) {
                    adT = "";
                }
                Intent intent2 = new Intent();
                intent2.putExtra("rawUrl", adT);
                intent2.putExtra("useJs", true);
                intent2.putExtra("srcUsername", c42804a.username);
                intent2.putExtra("bizofstartfrom", "enterpriseHomeSubBrand");
                intent2.addFlags(67108864);
                C25985d.m41467b(context, "webview", ".ui.tools.WebViewUI", intent2);
            } else {
                intent = new Intent();
                intent.putExtra("Chat_User", c42804a.username);
                intent.putExtra("finish_direct", true);
                intent.putExtra("specific_chat_from_scene", 3);
                intent.putExtra("preChatTYPE", 9);
                C25985d.m41473f(context, ".ui.chatting.ChattingUI", intent);
            }
            C35573ai.adO(c42804a.username);
            AppMethodBeat.m2505o(14083);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.brandservice.ui.a.a$a */
    public class C42803a extends C3155a {
        public View contentView;
        public ImageView ejo;
        public TextView gnB;
        public TextView gnC;

        public C42803a() {
            super();
        }
    }

    public C42804a(int i) {
        super(4, i);
        AppMethodBeat.m2504i(14084);
        AppMethodBeat.m2505o(14084);
    }

    /* JADX WARNING: Missing block: B:10:0x0049, code skipped:
            if (r5 == null) goto L_0x0135;
     */
    /* JADX WARNING: Missing block: B:11:0x004b, code skipped:
            r12.jMY = com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j.m79300d(r13, r8, (float) com.tencent.p177mm.p208bz.C1338a.m2856al(r13, com.tencent.p177mm.C25738R.dimen.f9980m5));
            r12.jMY = com.tencent.p177mm.plugin.fts.p419a.C34204f.m56086a(com.tencent.p177mm.plugin.fts.p419a.p420a.C39127d.m66568a(r12.jMY, r12.mDz, r3, r2)).mDR;
     */
    /* JADX WARNING: Missing block: B:12:0x0069, code skipped:
            if (r4 == null) goto L_0x009c;
     */
    /* JADX WARNING: Missing block: B:13:0x006b, code skipped:
            if (r1 == null) goto L_0x009c;
     */
    /* JADX WARNING: Missing block: B:14:0x006d, code skipped:
            r12.jMZ = com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j.m79300d(r13, r7, (float) com.tencent.p177mm.p208bz.C1338a.m2856al(r13, com.tencent.p177mm.C25738R.dimen.f9980m5));
            r12.jMZ = com.tencent.p177mm.plugin.fts.p419a.C34204f.m56086a(com.tencent.p177mm.plugin.fts.p419a.p420a.C39127d.m66568a(r12.jMZ, r12.mDz, r3, r2)).mDR;
            r12.jMZ = android.text.TextUtils.concat(new java.lang.CharSequence[]{r6, r12.jMZ});
     */
    /* JADX WARNING: Missing block: B:15:0x009c, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(14085);
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
            r9 = ((com.tencent.p177mm.api.C32250j) com.tencent.p177mm.kernel.C1720g.m3528K(com.tencent.p177mm.api.C32250j.class)).mo20994cK(r12.username).iterator();
     */
    /* JADX WARNING: Missing block: B:30:0x00e0, code skipped:
            if (r9.hasNext() == false) goto L_0x010a;
     */
    /* JADX WARNING: Missing block: B:31:0x00e2, code skipped:
            r12.jMZ = com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j.m79300d(r13, (java.lang.String) r9.next(), (float) com.tencent.p177mm.p208bz.C1338a.m2856al(r13, com.tencent.p177mm.C25738R.dimen.f9980m5));
            r0 = com.tencent.p177mm.plugin.fts.p419a.C34204f.m56086a(com.tencent.p177mm.plugin.fts.p419a.p420a.C39127d.m66568a(r12.jMZ, r12.mDz, r3, r2));
     */
    /* JADX WARNING: Missing block: B:32:0x0104, code skipped:
            if (r0.bFZ != 0) goto L_0x00dc;
     */
    /* JADX WARNING: Missing block: B:33:0x0106, code skipped:
            r12.jMZ = r0.mDR;
     */
    /* JADX WARNING: Missing block: B:34:0x010a, code skipped:
            r12.jMZ = android.text.TextUtils.concat(new java.lang.CharSequence[]{r12.jMZ, r13.getString(com.tencent.p177mm.C25738R.string.dze) + r8});
     */
    /* JADX WARNING: Missing block: B:35:0x0135, code skipped:
            r12.jMY = com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j.m79300d(r13, r8, (float) com.tencent.p177mm.p208bz.C1338a.m2856al(r13, com.tencent.p177mm.C25738R.dimen.f9980m5));
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public final void mo7413a(Context context, C3155a c3155a, Object... objArr) {
        AppMethodBeat.m2504i(14085);
        this.username = this.hpS.mDx;
        this.ehM = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(this.username);
        C16527d qX = C17903f.m28104qX(this.username);
        this.iconUrl = qX == null ? "" : qX.field_brandIconURL;
        CharSequence mJ = C1854s.m3866mJ(this.username);
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
                String Hq = this.ehM.mo14673Hq();
                if (C5046bo.isNullOrNil(Hq)) {
                    Hq = this.ehM.field_username;
                }
                str = context.getString(C25738R.string.e09);
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

    /* renamed from: Ps */
    public final C3156b mo7412Ps() {
        return this.jNa;
    }

    public final int aAq() {
        return this.hpS.mEK;
    }

    public final String aAp() {
        AppMethodBeat.m2504i(14086);
        String charSequence;
        if (this.jMY != null) {
            charSequence = this.jMY.toString();
            AppMethodBeat.m2505o(14086);
            return charSequence;
        }
        charSequence = "";
        AppMethodBeat.m2505o(14086);
        return charSequence;
    }
}
