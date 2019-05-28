package com.tencent.p177mm.plugin.wear.model.p576f;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p205bt.C1332b;
import com.tencent.p177mm.plugin.wear.model.C22742f;
import com.tencent.p177mm.plugin.wear.model.C43841a;
import com.tencent.p177mm.plugin.wear.model.C43845h;
import com.tencent.p177mm.plugin.wear.model.p1662c.C46393a;
import com.tencent.p177mm.plugin.wear.model.p575e.C40185r;
import com.tencent.p177mm.protocal.protobuf.cug;
import com.tencent.p177mm.sdk.platformtools.C46614bq;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4995ag;
import com.tencent.p177mm.storage.C7620bi;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: com.tencent.mm.plugin.wear.model.f.j */
public final class C29725j extends C14413b {
    private boolean cGH;
    private int csm;
    private String talker;

    public C29725j(String str, int i, boolean z) {
        this.talker = str;
        this.csm = i;
        this.cGH = z;
    }

    /* renamed from: k */
    private static String m47128k(String str, ArrayList<C7620bi> arrayList) {
        AppMethodBeat.m2504i(26448);
        C4990ab.m7411d("MicroMsg.WearNotificationCreateTask", "Talker: %s, MsgSize: %d", str, Integer.valueOf(arrayList.size()));
        StringBuffer stringBuffer = new StringBuffer();
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            stringBuffer.append(C14413b.m22631b(str, (C7620bi) arrayList.get(size)));
            stringBuffer.append("​​");
        }
        String trim = stringBuffer.toString().trim();
        AppMethodBeat.m2505o(26448);
        return trim;
    }

    /* renamed from: Y */
    private static String m47127Y(ArrayList<C7620bi> arrayList) {
        AppMethodBeat.m2504i(26449);
        StringBuffer stringBuffer = new StringBuffer();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            C7620bi c7620bi = (C7620bi) it.next();
            stringBuffer.append(c7620bi.field_msgId);
            stringBuffer.append(c7620bi.field_talker);
            stringBuffer.append(c7620bi.field_content);
            stringBuffer.append(c7620bi.getType());
            stringBuffer.append(c7620bi.field_createTime);
        }
        String ck = C4995ag.m7428ck(stringBuffer.toString());
        AppMethodBeat.m2505o(26449);
        return ck;
    }

    public final String getName() {
        return "WearNotificationCreateTask";
    }

    /* Access modifiers changed, original: protected|final */
    public final void send() {
        AppMethodBeat.m2504i(26450);
        C4990ab.m7410d("MicroMsg.WearNotificationCreateTask", "start to execute notification create task");
        C22742f adr = C43841a.cUn().tXv.adr(this.talker);
        ArrayList arrayList = new ArrayList();
        int i = this.csm - adr.tYc;
        if (i < 0) {
            i = 0;
        }
        C4990ab.m7411d("MicroMsg.WearNotificationCreateTask", "limit=%d", Integer.valueOf(i));
        C9638aw.m17190ZK();
        for (C7620bi c7620bi : C18628c.m29080XO().mo15320cs(this.talker, i)) {
            int i2;
            if (c7620bi.isSystem()) {
                i2 = 0;
            } else {
                i2 = 1;
            }
            if (i2 != 0) {
                arrayList.add(c7620bi);
            }
        }
        C4990ab.m7417i("MicroMsg.WearNotificationCreateTask", "receiveUnreadMsgList.size=%d", Integer.valueOf(arrayList.size()));
        if (arrayList.size() == 0) {
            AppMethodBeat.m2505o(26450);
            return;
        }
        String Y = C29725j.m47127Y(arrayList);
        if (adr.cvZ.equals(Y)) {
            C4990ab.m7416i("MicroMsg.WearNotificationCreateTask", "same md5, not to update");
            AppMethodBeat.m2505o(26450);
            return;
        }
        adr.cvZ = Y;
        cug cug = new cug();
        cug.ndE = adr.f4403id;
        cug.wyw = adr.talker;
        cug.Title = C43845h.adw(adr.talker);
        cug.ncM = C29725j.m47128k(adr.talker, arrayList);
        cug.wXt = this.csm;
        cug.xqJ = this.cGH;
        cug.xqI = !C46614bq.dpN();
        Bitmap adv = C43845h.adv(adr.talker);
        if (adv != null) {
            cug.xqr = new C1332b(C43845h.m78627ad(adv));
        }
        C4990ab.m7410d("MicroMsg.WearNotificationCreateTask", "generate notification content and ready to send");
        try {
            C43841a.cUn();
            C40185r.m68920b(20003, cug.toByteArray(), true);
        } catch (IOException e) {
        }
        C4990ab.m7410d("MicroMsg.WearNotificationCreateTask", "start to update notification status");
        C43841a.cUn().tXv.mo38312a(adr);
        C43841a.cUn().tXv.adu(this.talker);
        C46393a.m87276gn(6, 0);
        C46393a.m87275HH(1);
        AppMethodBeat.m2505o(26450);
    }
}
