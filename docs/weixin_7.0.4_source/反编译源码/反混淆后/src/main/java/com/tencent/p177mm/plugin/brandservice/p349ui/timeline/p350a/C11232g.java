package com.tencent.p177mm.plugin.brandservice.p349ui.timeline.p350a;

import android.app.Activity;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.view.MenuItem;
import com.google.android.gms.common.Scopes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1829bf;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.model.C37922v;
import com.tencent.p177mm.model.C37922v.C32800b;
import com.tencent.p177mm.p181af.C1192l;
import com.tencent.p177mm.p184aj.C41747z;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C40671n.C5279d;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.brandservice.p1241a.C20022a;
import com.tencent.p177mm.plugin.brandservice.p349ui.timeline.C38701a;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.secinforeport.p1293a.C21734a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C46627q;
import com.tencent.p177mm.storage.C7616ad;
import com.tencent.p177mm.storage.C7620bi;

/* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.a.g */
public final class C11232g implements C5279d {
    private long jPG;
    private boolean jPH = false;
    C38701a jPm;
    private Context mContext;

    public C11232g(C38701a c38701a, Context context) {
        this.jPm = c38701a;
        this.mContext = context;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        AppMethodBeat.m2504i(14265);
        if (this.jPm.jNl == null) {
            C4990ab.m7420w("MicroMsg.BizTimeLineMMMenuItemListener", "onMMMenuItemSelected mInfo == null");
            AppMethodBeat.m2505o(14265);
            return;
        }
        final C46627q c46627q = this.jPm.jNl;
        this.jPG = C5046bo.anT();
        Intent intent;
        switch (menuItem.getItemId()) {
            case 1:
                C7616ad aoO = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(c46627q.field_talker);
                if (aoO == null) {
                    C4990ab.m7412e("MicroMsg.BizTimeLineMMMenuItemListener", "changed biz stick status failed, contact is null, talker = " + c46627q.field_talker);
                    AppMethodBeat.m2505o(14265);
                    return;
                } else if (aoO.mo16702Oe()) {
                    C7060h.pYm.mo8381e(13307, aoO.field_username, Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3));
                    C1855t.m3969x(c46627q.field_talker, true);
                    C30379h.m48465bQ(this.mContext, this.mContext.getString(C25738R.string.a_k));
                    this.jPm.jNy.mo35301a(c46627q, false);
                    AppMethodBeat.m2505o(14265);
                    return;
                } else {
                    C7060h.pYm.mo8381e(13307, aoO.field_username, Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(3));
                    C1855t.m3967w(c46627q.field_talker, true);
                    C30379h.m48465bQ(this.mContext, this.mContext.getString(C25738R.string.a_f));
                    this.jPm.jNy.mo35301a(c46627q, true);
                    AppMethodBeat.m2505o(14265);
                    return;
                }
            case 2:
                C7616ad aoO2 = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(c46627q.field_talker);
                ((C20022a) C1720g.m3528K(C20022a.class)).mo35265b(C41747z.aeR().mo43729qP(c46627q.field_talker), (Activity) this.mContext, aoO2);
                this.jPm.jNy.mo35304d(c46627q, 2);
                AppMethodBeat.m2505o(14265);
                return;
            case 3:
                intent = new Intent();
                intent.putExtra("Contact_User", c46627q.field_talker);
                intent.putExtra("Contact_Scene", 90);
                C25985d.m41467b(this.mContext, Scopes.PROFILE, ".ui.ContactInfoUI", intent);
                this.jPm.jNy.mo35304d(c46627q, 1);
                AppMethodBeat.m2505o(14265);
                return;
            case 4:
                if (this.jPH) {
                    ((C20022a) C1720g.m3528K(C20022a.class)).mo35259a(this.jPm.jNm, this.mContext, c46627q.field_content, c46627q.field_talker, c46627q.field_msgId, c46627q.field_msgSvrId);
                    AppMethodBeat.m2505o(14265);
                    return;
                }
                String a = C1192l.m2618a(this.mContext, this.jPm.jNm, c46627q.field_content, c46627q.field_talker, c46627q.field_msgId);
                if (!C5046bo.isNullOrNil(a)) {
                    Intent intent2 = new Intent();
                    intent2.putExtra("Retr_Msg_content", a);
                    intent2.putExtra("Retr_Msg_Type", 2);
                    intent2.putExtra("Retr_Biz_Msg_Selected_Msg_Index", this.jPm.jNm);
                    intent2.putExtra("Retr_Msg_Id", c46627q.field_msgId);
                    intent2.putExtra("Retr_MsgFromScene", 1);
                    a = c46627q.field_talker;
                    String nW = C37922v.m64078nW(c46627q.field_msgSvrId);
                    intent2.putExtra("reportSessionId", nW);
                    C32800b y = C37922v.m64076Zp().mo60676y(nW, true);
                    y.mo53356j("prePublishId", "msg_" + c46627q.field_msgSvrId);
                    y.mo53356j("preUsername", a);
                    y.mo53356j("preChatName", a);
                    y.mo53356j("preMsgIndex", Integer.valueOf(this.jPm.jNm));
                    y.mo53356j("sendAppMsgScene", Integer.valueOf(1));
                    C25985d.m41473f(this.mContext, ".ui.transmit.MsgRetransmitUI", intent2);
                    AppMethodBeat.m2505o(14265);
                    return;
                }
                break;
            case 5:
                C7620bi jf = ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15340jf(c46627q.field_msgId);
                if (jf.field_msgId == 0) {
                    C4990ab.m7420w("MicroMsg.BizTimeLineMMMenuItemListener", "favAppBrandMsg msg is null");
                    AppMethodBeat.m2505o(14265);
                    return;
                }
                ((C20022a) C1720g.m3528K(C20022a.class)).mo35260a(this.jPG, this.jPm.jNm, this.mContext, (Activity) this.mContext, jf);
                AppMethodBeat.m2505o(14265);
                return;
            case 6:
                C7620bi jf2 = ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15340jf(c46627q.field_msgId);
                if (jf2.field_msgId == 0) {
                    C4990ab.m7420w("MicroMsg.BizTimeLineMMMenuItemListener", "favAppBrandMsg msg is null");
                    AppMethodBeat.m2505o(14265);
                    return;
                }
                ((C20022a) C1720g.m3528K(C20022a.class)).mo35264a(jf2, this.mContext);
                AppMethodBeat.m2505o(14265);
                return;
            case 7:
                C7620bi jf3 = ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15340jf(c46627q.field_msgId);
                if (jf3.field_msgId == 0) {
                    C4990ab.m7420w("MicroMsg.BizTimeLineMMMenuItemListener", "favAppBrandMsg msg is null");
                    AppMethodBeat.m2505o(14265);
                    return;
                }
                ((C20022a) C1720g.m3528K(C20022a.class)).mo35263a(jf3, (Activity) this.mContext);
                AppMethodBeat.m2505o(14265);
                return;
            case 8:
                intent = new Intent();
                intent.putExtra("Retr_Msg_content", c46627q.field_content);
                intent.putExtra("Retr_Msg_Type", 4);
                C25985d.m41473f(this.mContext, ".ui.transmit.MsgRetransmitUI", intent);
                AppMethodBeat.m2505o(14265);
                return;
            case 9:
                try {
                    ((ClipboardManager) C4996ah.getContext().getSystemService("clipboard")).setText(c46627q.field_content);
                } catch (Exception e) {
                    C4990ab.m7412e("MicroMsg.BizTimeLineMMMenuItemListener", "clip.setText error ");
                }
                C30379h.m48465bQ(this.mContext, this.mContext.getString(C25738R.string.f9083oz));
                C21734a c21734a = C21734a.qjm;
                C21734a.m33275h(1, c46627q.field_msgSvrId, C5046bo.ana(c46627q.field_content));
                break;
            case 10:
                C30379h.m48446a(this.mContext, this.mContext.getString(C25738R.string.a_j), "", this.mContext.getString(C25738R.string.f9187s6), this.mContext.getString(C25738R.string.f9076or), true, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.m2504i(14264);
                        C1829bf.m3748fm(c46627q.field_msgId);
                        C11232g.this.jPm.jNy.mo35304d(c46627q, 3);
                        C11232g.this.jPm.jNo.mo68287d(c46627q);
                        AppMethodBeat.m2505o(14264);
                    }
                }, null, (int) C25738R.color.f12266xy);
                AppMethodBeat.m2505o(14265);
                return;
            case 11:
                C30379h.m48465bQ(this.mContext, this.mContext.getString(C25738R.string.a9s));
                AppMethodBeat.m2505o(14265);
                return;
        }
        AppMethodBeat.m2505o(14265);
    }
}
