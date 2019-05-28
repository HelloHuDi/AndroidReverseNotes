package com.tencent.mm.ui.transmit;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.af.j.b;
import com.tencent.mm.at.l;
import com.tencent.mm.g.a.qb;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bv;
import com.tencent.mm.model.c;
import com.tencent.mm.model.r;
import com.tencent.mm.model.t;
import com.tencent.mm.modelmulti.h;
import com.tencent.mm.pluginsdk.model.app.am;
import com.tencent.mm.protocal.protobuf.cfh;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.contact.z;
import com.tencent.mm.ui.transmit.MsgRetransmitUI.a;
import com.tencent.mm.vfs.e;
import java.util.ArrayList;

public final class d implements com.tencent.mm.plugin.messenger.a.d {
    public final void F(String str, String str2, int i) {
        AppMethodBeat.i(35240);
        if (str == null || str2 == null) {
            ab.w("MicroMsg.SendMsgMgr", "send msg args error, toUser[%s] content[%s]", str, str2);
            AppMethodBeat.o(35240);
            return;
        }
        aw.Rg().a(new h(str, str2, i), 0);
        AppMethodBeat.o(35240);
    }

    public final void a(Context context, String str, String str2, String str3, int i, int i2, String str4) {
        AppMethodBeat.i(35241);
        a(context, str, str2, str3, i, i2, null, str4);
        AppMethodBeat.o(35241);
    }

    public final void a(Context context, String str, String str2, String str3, int i, int i2, cfh cfh, String str4) {
        int i3 = 1;
        AppMethodBeat.i(35242);
        if (context == null) {
            ab.w("MicroMsg.SendMsgMgr", "send vedio context is null");
            AppMethodBeat.o(35242);
        } else if (str == null || str2 == null) {
            ab.w("MicroMsg.SendMsgMgr", "send vedio args error, toUser[%s] fileName[%s]", str, str2);
            AppMethodBeat.o(35242);
        } else {
            aw.ZK();
            if (c.isSDCardAvailable()) {
                final a aVar = new a();
                context.getResources().getString(R.string.tz);
                p b = com.tencent.mm.ui.base.h.b(context, context.getResources().getString(R.string.th), true, new OnCancelListener() {
                    public final void onCancel(DialogInterface dialogInterface) {
                        aVar.zJA = true;
                    }
                });
                aVar.context = context;
                aVar.fileName = str2;
                aVar.zJB = str3;
                aVar.gII = b;
                aVar.userName = str;
                aVar.cMn = str4;
                aVar.zJE = false;
                if (62 == i) {
                    aVar.fVl = 11;
                }
                if (i <= 0) {
                    i3 = 0;
                }
                aVar.zIW = i3;
                aVar.fXd = i2;
                aVar.zJC = false;
                aVar.zJF = cfh;
                aVar.execute(new Object[0]);
                AppMethodBeat.o(35242);
                return;
            }
            ab.w("MicroMsg.SendMsgMgr", "sdcard not ready, send video fail");
            Toast.makeText(context, R.string.d1q, 1).show();
            AppMethodBeat.o(35242);
        }
    }

    public final void a(Context context, String str, String str2, int i, String str3, String str4) {
        AppMethodBeat.i(35243);
        if (str == null || str2 == null) {
            ab.w("MicroMsg.SendMsgMgr", "sendImg: args error, toUser[%s], fileName[%s]", str, str2);
            AppMethodBeat.o(35243);
            return;
        }
        aw.ZK();
        if (c.isSDCardAvailable()) {
            aw.Rg().a(new l(4, r.Yz(), str, str2, i, null, 0, str3, str4, true, R.drawable.b0p), 0);
            bv.aaq().c(bv.fnv, null);
            AppMethodBeat.o(35243);
            return;
        }
        ab.w("MicroMsg.SendMsgMgr", "sdcard not ready, send video fail");
        Toast.makeText(context, R.string.d1q, 1).show();
        AppMethodBeat.o(35243);
    }

    public final void a(String str, byte[] bArr, String str2, String str3) {
        AppMethodBeat.i(35244);
        if (str == null) {
            ab.w("MicroMsg.SendMsgMgr", "sendAppMsg: args error, toUser is null");
            AppMethodBeat.o(35244);
            return;
        }
        ab.v("MicroMsg.SendMsgMgr", "for track bug sendAppMsg %s", str2);
        b me = b.me(bo.anj(str2));
        if (me == null) {
            ab.w("MicroMsg.SendMsgMgr", "send: parse app msg content return null");
            AppMethodBeat.o(35244);
            return;
        }
        com.tencent.mm.pluginsdk.model.app.b bVar = new com.tencent.mm.pluginsdk.model.app.b();
        ab.i("MicroMsg.SendMsgMgr", "content.attachid %s", me.csD);
        if (!bo.isNullOrNil(me.csD)) {
            long j = bo.getLong(me.csD, -1);
            if (j != -1) {
                am.aUq().b(j, (com.tencent.mm.sdk.e.c) bVar);
                if (bVar.xDa != j) {
                    bVar = am.aUq().aiE(me.csD);
                    if (bVar == null || !bVar.field_mediaSvrId.equals(me.csD)) {
                        bVar = null;
                    }
                    if (bVar == null) {
                        ab.i("MicroMsg.SendMsgMgr", "appAttachInfo1  %s", me.csD);
                    } else {
                        ab.i("MicroMsg.SendMsgMgr", "appAttachInfo2  %s : %s : %s", me.csD, Long.valueOf(bVar.xDa), bVar.field_fileFullPath);
                    }
                }
            } else {
                bVar = am.aUq().aiE(me.csD);
                if (bVar == null || !bVar.field_mediaSvrId.equals(me.csD)) {
                    bVar = null;
                }
                if (bVar == null) {
                    ab.i("MicroMsg.SendMsgMgr", "appAttachInfo3  %s", me.csD);
                } else {
                    ab.i("MicroMsg.SendMsgMgr", "appAttachInfo4  %s : %s : %s", me.csD, Long.valueOf(bVar.xDa), bVar.field_fileFullPath);
                }
            }
        }
        String str4 = "";
        if (!(bVar == null || bVar.field_fileFullPath == null || bVar.field_fileFullPath.equals(""))) {
            aw.ZK();
            str4 = com.tencent.mm.pluginsdk.model.app.l.X(c.Ye(), me.title, me.fgp);
            e.y(bVar.field_fileFullPath, str4);
            ab.i("MicroMsg.SendMsgMgr", "copy from src %s to dest %s size: %s", bVar.field_fileFullPath, str4, Long.valueOf(e.asZ(bVar.field_fileFullPath)));
        }
        b a = b.a(me);
        a.fgr = 3;
        com.tencent.mm.pluginsdk.model.app.l.a(a, me.appId, me.appName, str, str4, bArr, str3);
        AppMethodBeat.o(35244);
    }

    public final void q(String str, String str2, boolean z) {
        AppMethodBeat.i(35245);
        if (z) {
            aw.Rg().a(new h(bo.bc(str2, ""), z.arT(str), ad.aox(str) ? 66 : 42), 0);
            AppMethodBeat.o(35245);
            return;
        }
        ArrayList P = bo.P(bo.bc(str2, "").split(","));
        String arT = z.arT(str);
        for (int i = 0; i < P.size(); i++) {
            int i2;
            String str3 = (String) P.get(i);
            if (ad.aox(str)) {
                i2 = 66;
            } else {
                i2 = 42;
            }
            aw.Rg().a(new h(str3, arT, i2), 0);
        }
        AppMethodBeat.o(35245);
    }

    public final void eZ(String str, String str2) {
        AppMethodBeat.i(35246);
        ArrayList<String> P = bo.P(bo.bc(str2, "").split(","));
        if (!TextUtils.isEmpty(str)) {
            for (String str3 : P) {
                qb qbVar = new qb();
                qbVar.cMq.cMr = str3;
                qbVar.cMq.content = str;
                qbVar.cMq.type = t.nK(str3);
                qbVar.cMq.flags = 0;
                com.tencent.mm.sdk.b.a.xxA.m(qbVar);
            }
        }
        AppMethodBeat.o(35246);
    }
}
