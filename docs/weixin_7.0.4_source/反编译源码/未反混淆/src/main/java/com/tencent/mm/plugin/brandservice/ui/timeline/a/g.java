package com.tencent.mm.plugin.brandservice.ui.timeline.a;

import android.app.Activity;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.view.MenuItem;
import com.google.android.gms.common.Scopes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.af.l;
import com.tencent.mm.aj.z;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.t;
import com.tencent.mm.model.v;
import com.tencent.mm.model.v.b;
import com.tencent.mm.plugin.brandservice.ui.timeline.a;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.q;
import com.tencent.mm.ui.base.n.d;

public final class g implements d {
    private long jPG;
    private boolean jPH = false;
    a jPm;
    private Context mContext;

    public g(a aVar, Context context) {
        this.jPm = aVar;
        this.mContext = context;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        AppMethodBeat.i(14265);
        if (this.jPm.jNl == null) {
            ab.w("MicroMsg.BizTimeLineMMMenuItemListener", "onMMMenuItemSelected mInfo == null");
            AppMethodBeat.o(14265);
            return;
        }
        final q qVar = this.jPm.jNl;
        this.jPG = bo.anT();
        Intent intent;
        switch (menuItem.getItemId()) {
            case 1:
                ad aoO = ((j) com.tencent.mm.kernel.g.K(j.class)).XM().aoO(qVar.field_talker);
                if (aoO == null) {
                    ab.e("MicroMsg.BizTimeLineMMMenuItemListener", "changed biz stick status failed, contact is null, talker = " + qVar.field_talker);
                    AppMethodBeat.o(14265);
                    return;
                } else if (aoO.Oe()) {
                    h.pYm.e(13307, aoO.field_username, Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3));
                    t.x(qVar.field_talker, true);
                    com.tencent.mm.ui.base.h.bQ(this.mContext, this.mContext.getString(R.string.a_k));
                    this.jPm.jNy.a(qVar, false);
                    AppMethodBeat.o(14265);
                    return;
                } else {
                    h.pYm.e(13307, aoO.field_username, Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(3));
                    t.w(qVar.field_talker, true);
                    com.tencent.mm.ui.base.h.bQ(this.mContext, this.mContext.getString(R.string.a_f));
                    this.jPm.jNy.a(qVar, true);
                    AppMethodBeat.o(14265);
                    return;
                }
            case 2:
                ad aoO2 = ((j) com.tencent.mm.kernel.g.K(j.class)).XM().aoO(qVar.field_talker);
                ((com.tencent.mm.plugin.brandservice.a.a) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.brandservice.a.a.class)).b(z.aeR().qP(qVar.field_talker), (Activity) this.mContext, aoO2);
                this.jPm.jNy.d(qVar, 2);
                AppMethodBeat.o(14265);
                return;
            case 3:
                intent = new Intent();
                intent.putExtra("Contact_User", qVar.field_talker);
                intent.putExtra("Contact_Scene", 90);
                com.tencent.mm.bp.d.b(this.mContext, Scopes.PROFILE, ".ui.ContactInfoUI", intent);
                this.jPm.jNy.d(qVar, 1);
                AppMethodBeat.o(14265);
                return;
            case 4:
                if (this.jPH) {
                    ((com.tencent.mm.plugin.brandservice.a.a) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.brandservice.a.a.class)).a(this.jPm.jNm, this.mContext, qVar.field_content, qVar.field_talker, qVar.field_msgId, qVar.field_msgSvrId);
                    AppMethodBeat.o(14265);
                    return;
                }
                String a = l.a(this.mContext, this.jPm.jNm, qVar.field_content, qVar.field_talker, qVar.field_msgId);
                if (!bo.isNullOrNil(a)) {
                    Intent intent2 = new Intent();
                    intent2.putExtra("Retr_Msg_content", a);
                    intent2.putExtra("Retr_Msg_Type", 2);
                    intent2.putExtra("Retr_Biz_Msg_Selected_Msg_Index", this.jPm.jNm);
                    intent2.putExtra("Retr_Msg_Id", qVar.field_msgId);
                    intent2.putExtra("Retr_MsgFromScene", 1);
                    a = qVar.field_talker;
                    String nW = v.nW(qVar.field_msgSvrId);
                    intent2.putExtra("reportSessionId", nW);
                    b y = v.Zp().y(nW, true);
                    y.j("prePublishId", "msg_" + qVar.field_msgSvrId);
                    y.j("preUsername", a);
                    y.j("preChatName", a);
                    y.j("preMsgIndex", Integer.valueOf(this.jPm.jNm));
                    y.j("sendAppMsgScene", Integer.valueOf(1));
                    com.tencent.mm.bp.d.f(this.mContext, ".ui.transmit.MsgRetransmitUI", intent2);
                    AppMethodBeat.o(14265);
                    return;
                }
                break;
            case 5:
                bi jf = ((j) com.tencent.mm.kernel.g.K(j.class)).bOr().jf(qVar.field_msgId);
                if (jf.field_msgId == 0) {
                    ab.w("MicroMsg.BizTimeLineMMMenuItemListener", "favAppBrandMsg msg is null");
                    AppMethodBeat.o(14265);
                    return;
                }
                ((com.tencent.mm.plugin.brandservice.a.a) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.brandservice.a.a.class)).a(this.jPG, this.jPm.jNm, this.mContext, (Activity) this.mContext, jf);
                AppMethodBeat.o(14265);
                return;
            case 6:
                bi jf2 = ((j) com.tencent.mm.kernel.g.K(j.class)).bOr().jf(qVar.field_msgId);
                if (jf2.field_msgId == 0) {
                    ab.w("MicroMsg.BizTimeLineMMMenuItemListener", "favAppBrandMsg msg is null");
                    AppMethodBeat.o(14265);
                    return;
                }
                ((com.tencent.mm.plugin.brandservice.a.a) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.brandservice.a.a.class)).a(jf2, this.mContext);
                AppMethodBeat.o(14265);
                return;
            case 7:
                bi jf3 = ((j) com.tencent.mm.kernel.g.K(j.class)).bOr().jf(qVar.field_msgId);
                if (jf3.field_msgId == 0) {
                    ab.w("MicroMsg.BizTimeLineMMMenuItemListener", "favAppBrandMsg msg is null");
                    AppMethodBeat.o(14265);
                    return;
                }
                ((com.tencent.mm.plugin.brandservice.a.a) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.brandservice.a.a.class)).a(jf3, (Activity) this.mContext);
                AppMethodBeat.o(14265);
                return;
            case 8:
                intent = new Intent();
                intent.putExtra("Retr_Msg_content", qVar.field_content);
                intent.putExtra("Retr_Msg_Type", 4);
                com.tencent.mm.bp.d.f(this.mContext, ".ui.transmit.MsgRetransmitUI", intent);
                AppMethodBeat.o(14265);
                return;
            case 9:
                try {
                    ((ClipboardManager) ah.getContext().getSystemService("clipboard")).setText(qVar.field_content);
                } catch (Exception e) {
                    ab.e("MicroMsg.BizTimeLineMMMenuItemListener", "clip.setText error ");
                }
                com.tencent.mm.ui.base.h.bQ(this.mContext, this.mContext.getString(R.string.oz));
                com.tencent.mm.plugin.secinforeport.a.a aVar = com.tencent.mm.plugin.secinforeport.a.a.qjm;
                com.tencent.mm.plugin.secinforeport.a.a.h(1, qVar.field_msgSvrId, bo.ana(qVar.field_content));
                break;
            case 10:
                com.tencent.mm.ui.base.h.a(this.mContext, this.mContext.getString(R.string.a_j), "", this.mContext.getString(R.string.s6), this.mContext.getString(R.string.or), true, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.i(14264);
                        bf.fm(qVar.field_msgId);
                        g.this.jPm.jNy.d(qVar, 3);
                        g.this.jPm.jNo.d(qVar);
                        AppMethodBeat.o(14264);
                    }
                }, null, (int) R.color.xy);
                AppMethodBeat.o(14265);
                return;
            case 11:
                com.tencent.mm.ui.base.h.bQ(this.mContext, this.mContext.getString(R.string.a9s));
                AppMethodBeat.o(14265);
                return;
        }
        AppMethodBeat.o(14265);
    }
}
