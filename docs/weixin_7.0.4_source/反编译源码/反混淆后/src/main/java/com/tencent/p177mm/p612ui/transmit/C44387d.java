package com.tencent.p177mm.p612ui.transmit;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C37907bv;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.modelmulti.C26451h;
import com.tencent.p177mm.p181af.C8909j.C8910b;
import com.tencent.p177mm.p190at.C9022l;
import com.tencent.p177mm.p230g.p231a.C18372qb;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C44275p;
import com.tencent.p177mm.p612ui.contact.C23927z;
import com.tencent.p177mm.p612ui.transmit.MsgRetransmitUI.C36349a;
import com.tencent.p177mm.plugin.messenger.p993a.C28488d;
import com.tencent.p177mm.pluginsdk.model.app.C14877am;
import com.tencent.p177mm.pluginsdk.model.app.C30065b;
import com.tencent.p177mm.pluginsdk.model.app.C4733l;
import com.tencent.p177mm.protocal.protobuf.cfh;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p603e.C4925c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7616ad;
import com.tencent.p177mm.vfs.C5730e;
import java.util.ArrayList;

/* renamed from: com.tencent.mm.ui.transmit.d */
public final class C44387d implements C28488d {
    /* renamed from: F */
    public final void mo46456F(String str, String str2, int i) {
        AppMethodBeat.m2504i(35240);
        if (str == null || str2 == null) {
            C4990ab.m7421w("MicroMsg.SendMsgMgr", "send msg args error, toUser[%s] content[%s]", str, str2);
            AppMethodBeat.m2505o(35240);
            return;
        }
        C9638aw.m17182Rg().mo14541a(new C26451h(str, str2, i), 0);
        AppMethodBeat.m2505o(35240);
    }

    /* renamed from: a */
    public final void mo46459a(Context context, String str, String str2, String str3, int i, int i2, String str4) {
        AppMethodBeat.m2504i(35241);
        mo46458a(context, str, str2, str3, i, i2, null, str4);
        AppMethodBeat.m2505o(35241);
    }

    /* renamed from: a */
    public final void mo46458a(Context context, String str, String str2, String str3, int i, int i2, cfh cfh, String str4) {
        int i3 = 1;
        AppMethodBeat.m2504i(35242);
        if (context == null) {
            C4990ab.m7420w("MicroMsg.SendMsgMgr", "send vedio context is null");
            AppMethodBeat.m2505o(35242);
        } else if (str == null || str2 == null) {
            C4990ab.m7421w("MicroMsg.SendMsgMgr", "send vedio args error, toUser[%s] fileName[%s]", str, str2);
            AppMethodBeat.m2505o(35242);
        } else {
            C9638aw.m17190ZK();
            if (C18628c.isSDCardAvailable()) {
                final C36349a c36349a = new C36349a();
                context.getResources().getString(C25738R.string.f9238tz);
                C44275p b = C30379h.m48458b(context, context.getResources().getString(C25738R.string.f9222th), true, new OnCancelListener() {
                    public final void onCancel(DialogInterface dialogInterface) {
                        c36349a.zJA = true;
                    }
                });
                c36349a.context = context;
                c36349a.fileName = str2;
                c36349a.zJB = str3;
                c36349a.gII = b;
                c36349a.userName = str;
                c36349a.cMn = str4;
                c36349a.zJE = false;
                if (62 == i) {
                    c36349a.fVl = 11;
                }
                if (i <= 0) {
                    i3 = 0;
                }
                c36349a.zIW = i3;
                c36349a.fXd = i2;
                c36349a.zJC = false;
                c36349a.zJF = cfh;
                c36349a.execute(new Object[0]);
                AppMethodBeat.m2505o(35242);
                return;
            }
            C4990ab.m7420w("MicroMsg.SendMsgMgr", "sdcard not ready, send video fail");
            Toast.makeText(context, C25738R.string.d1q, 1).show();
            AppMethodBeat.m2505o(35242);
        }
    }

    /* renamed from: a */
    public final void mo46457a(Context context, String str, String str2, int i, String str3, String str4) {
        AppMethodBeat.m2504i(35243);
        if (str == null || str2 == null) {
            C4990ab.m7421w("MicroMsg.SendMsgMgr", "sendImg: args error, toUser[%s], fileName[%s]", str, str2);
            AppMethodBeat.m2505o(35243);
            return;
        }
        C9638aw.m17190ZK();
        if (C18628c.isSDCardAvailable()) {
            C9638aw.m17182Rg().mo14541a(new C9022l(4, C1853r.m3846Yz(), str, str2, i, null, 0, str3, str4, true, C25738R.drawable.b0p), 0);
            C37907bv.aaq().mo60662c(C37907bv.fnv, null);
            AppMethodBeat.m2505o(35243);
            return;
        }
        C4990ab.m7420w("MicroMsg.SendMsgMgr", "sdcard not ready, send video fail");
        Toast.makeText(context, C25738R.string.d1q, 1).show();
        AppMethodBeat.m2505o(35243);
    }

    /* renamed from: a */
    public final void mo46460a(String str, byte[] bArr, String str2, String str3) {
        AppMethodBeat.m2504i(35244);
        if (str == null) {
            C4990ab.m7420w("MicroMsg.SendMsgMgr", "sendAppMsg: args error, toUser is null");
            AppMethodBeat.m2505o(35244);
            return;
        }
        C4990ab.m7419v("MicroMsg.SendMsgMgr", "for track bug sendAppMsg %s", str2);
        C8910b me = C8910b.m16064me(C5046bo.anj(str2));
        if (me == null) {
            C4990ab.m7420w("MicroMsg.SendMsgMgr", "send: parse app msg content return null");
            AppMethodBeat.m2505o(35244);
            return;
        }
        C30065b c30065b = new C30065b();
        C4990ab.m7417i("MicroMsg.SendMsgMgr", "content.attachid %s", me.csD);
        if (!C5046bo.isNullOrNil(me.csD)) {
            long j = C5046bo.getLong(me.csD, -1);
            if (j != -1) {
                C14877am.aUq().mo16761b(j, (C4925c) c30065b);
                if (c30065b.xDa != j) {
                    c30065b = C14877am.aUq().aiE(me.csD);
                    if (c30065b == null || !c30065b.field_mediaSvrId.equals(me.csD)) {
                        c30065b = null;
                    }
                    if (c30065b == null) {
                        C4990ab.m7417i("MicroMsg.SendMsgMgr", "appAttachInfo1  %s", me.csD);
                    } else {
                        C4990ab.m7417i("MicroMsg.SendMsgMgr", "appAttachInfo2  %s : %s : %s", me.csD, Long.valueOf(c30065b.xDa), c30065b.field_fileFullPath);
                    }
                }
            } else {
                c30065b = C14877am.aUq().aiE(me.csD);
                if (c30065b == null || !c30065b.field_mediaSvrId.equals(me.csD)) {
                    c30065b = null;
                }
                if (c30065b == null) {
                    C4990ab.m7417i("MicroMsg.SendMsgMgr", "appAttachInfo3  %s", me.csD);
                } else {
                    C4990ab.m7417i("MicroMsg.SendMsgMgr", "appAttachInfo4  %s : %s : %s", me.csD, Long.valueOf(c30065b.xDa), c30065b.field_fileFullPath);
                }
            }
        }
        String str4 = "";
        if (!(c30065b == null || c30065b.field_fileFullPath == null || c30065b.field_fileFullPath.equals(""))) {
            C9638aw.m17190ZK();
            str4 = C4733l.m7083X(C18628c.m29096Ye(), me.title, me.fgp);
            C5730e.m8644y(c30065b.field_fileFullPath, str4);
            C4990ab.m7417i("MicroMsg.SendMsgMgr", "copy from src %s to dest %s size: %s", c30065b.field_fileFullPath, str4, Long.valueOf(C5730e.asZ(c30065b.field_fileFullPath)));
        }
        C8910b a = C8910b.m16060a(me);
        a.fgr = 3;
        C4733l.m7088a(a, me.appId, me.appName, str, str4, bArr, str3);
        AppMethodBeat.m2505o(35244);
    }

    /* renamed from: q */
    public final void mo46462q(String str, String str2, boolean z) {
        AppMethodBeat.m2504i(35245);
        if (z) {
            C9638aw.m17182Rg().mo14541a(new C26451h(C5046bo.m7532bc(str2, ""), C23927z.arT(str), C7616ad.aox(str) ? 66 : 42), 0);
            AppMethodBeat.m2505o(35245);
            return;
        }
        ArrayList P = C5046bo.m7508P(C5046bo.m7532bc(str2, "").split(","));
        String arT = C23927z.arT(str);
        for (int i = 0; i < P.size(); i++) {
            int i2;
            String str3 = (String) P.get(i);
            if (C7616ad.aox(str)) {
                i2 = 66;
            } else {
                i2 = 42;
            }
            C9638aw.m17182Rg().mo14541a(new C26451h(str3, arT, i2), 0);
        }
        AppMethodBeat.m2505o(35245);
    }

    /* renamed from: eZ */
    public final void mo46461eZ(String str, String str2) {
        AppMethodBeat.m2504i(35246);
        ArrayList<String> P = C5046bo.m7508P(C5046bo.m7532bc(str2, "").split(","));
        if (!TextUtils.isEmpty(str)) {
            for (String str3 : P) {
                C18372qb c18372qb = new C18372qb();
                c18372qb.cMq.cMr = str3;
                c18372qb.cMq.content = str;
                c18372qb.cMq.type = C1855t.m3925nK(str3);
                c18372qb.cMq.flags = 0;
                C4879a.xxA.mo10055m(c18372qb);
            }
        }
        AppMethodBeat.m2505o(35246);
    }
}
