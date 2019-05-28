package com.tencent.mm.plugin.wear.model.f;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.b;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.wear.model.a;
import com.tencent.mm.plugin.wear.model.e.r;
import com.tencent.mm.plugin.wear.model.f;
import com.tencent.mm.plugin.wear.model.h;
import com.tencent.mm.protocal.protobuf.cug;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bq;
import com.tencent.mm.storage.bi;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public final class j extends b {
    private boolean cGH;
    private int csm;
    private String talker;

    public j(String str, int i, boolean z) {
        this.talker = str;
        this.csm = i;
        this.cGH = z;
    }

    private static String k(String str, ArrayList<bi> arrayList) {
        AppMethodBeat.i(26448);
        ab.d("MicroMsg.WearNotificationCreateTask", "Talker: %s, MsgSize: %d", str, Integer.valueOf(arrayList.size()));
        StringBuffer stringBuffer = new StringBuffer();
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            stringBuffer.append(b.b(str, (bi) arrayList.get(size)));
            stringBuffer.append("​​");
        }
        String trim = stringBuffer.toString().trim();
        AppMethodBeat.o(26448);
        return trim;
    }

    private static String Y(ArrayList<bi> arrayList) {
        AppMethodBeat.i(26449);
        StringBuffer stringBuffer = new StringBuffer();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            bi biVar = (bi) it.next();
            stringBuffer.append(biVar.field_msgId);
            stringBuffer.append(biVar.field_talker);
            stringBuffer.append(biVar.field_content);
            stringBuffer.append(biVar.getType());
            stringBuffer.append(biVar.field_createTime);
        }
        String ck = ag.ck(stringBuffer.toString());
        AppMethodBeat.o(26449);
        return ck;
    }

    public final String getName() {
        return "WearNotificationCreateTask";
    }

    /* Access modifiers changed, original: protected|final */
    public final void send() {
        AppMethodBeat.i(26450);
        ab.d("MicroMsg.WearNotificationCreateTask", "start to execute notification create task");
        f adr = a.cUn().tXv.adr(this.talker);
        ArrayList arrayList = new ArrayList();
        int i = this.csm - adr.tYc;
        if (i < 0) {
            i = 0;
        }
        ab.d("MicroMsg.WearNotificationCreateTask", "limit=%d", Integer.valueOf(i));
        aw.ZK();
        for (bi biVar : c.XO().cs(this.talker, i)) {
            int i2;
            if (biVar.isSystem()) {
                i2 = 0;
            } else {
                i2 = 1;
            }
            if (i2 != 0) {
                arrayList.add(biVar);
            }
        }
        ab.i("MicroMsg.WearNotificationCreateTask", "receiveUnreadMsgList.size=%d", Integer.valueOf(arrayList.size()));
        if (arrayList.size() == 0) {
            AppMethodBeat.o(26450);
            return;
        }
        String Y = Y(arrayList);
        if (adr.cvZ.equals(Y)) {
            ab.i("MicroMsg.WearNotificationCreateTask", "same md5, not to update");
            AppMethodBeat.o(26450);
            return;
        }
        adr.cvZ = Y;
        cug cug = new cug();
        cug.ndE = adr.id;
        cug.wyw = adr.talker;
        cug.Title = h.adw(adr.talker);
        cug.ncM = k(adr.talker, arrayList);
        cug.wXt = this.csm;
        cug.xqJ = this.cGH;
        cug.xqI = !bq.dpN();
        Bitmap adv = h.adv(adr.talker);
        if (adv != null) {
            cug.xqr = new b(h.ad(adv));
        }
        ab.d("MicroMsg.WearNotificationCreateTask", "generate notification content and ready to send");
        try {
            a.cUn();
            r.b(20003, cug.toByteArray(), true);
        } catch (IOException e) {
        }
        ab.d("MicroMsg.WearNotificationCreateTask", "start to update notification status");
        a.cUn().tXv.a(adr);
        a.cUn().tXv.adu(this.talker);
        com.tencent.mm.plugin.wear.model.c.a.gn(6, 0);
        com.tencent.mm.plugin.wear.model.c.a.HH(1);
        AppMethodBeat.o(26450);
    }
}
