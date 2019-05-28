package com.tencent.mm.plugin.shake.c.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ql;
import com.tencent.mm.model.aw;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.br;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

public final class f {
    public List<WeakReference<a>> kaD;
    private String qsx;

    public static class c {
    }

    public static class b extends c {
        protected String qsA = "";
        protected int qsB = 0;
        protected int qsC = 0;
        protected int qsD = 7;
        protected String qsE = "";
        protected int qsy = 0;
        protected int qsz = 0;
    }

    public interface a {
        void ckb();
    }

    public static class d extends c {
        protected String qsF;
        protected String qsG;
        protected String qsH;
    }

    public f() {
        AppMethodBeat.i(24519);
        this.kaD = new ArrayList();
        this.qsx = "";
        this.qsx = com.tencent.mm.plugin.shake.c.c.a.cko();
        AppMethodBeat.o(24519);
    }

    public final void i(String str, long j, int i) {
        AppMethodBeat.i(24520);
        ab.i("MicroMsg.ShakeCardMsgMgr", "msg_id is ".concat(String.valueOf(j)));
        if (TextUtils.isEmpty(str)) {
            ab.e("MicroMsg.ShakeCardMsgMgr", "onReceive() msgText is empty");
            AppMethodBeat.o(24520);
            return;
        }
        if (i == 0) {
            ab.i("MicroMsg.ShakeCardMsgMgr", "onReceive() msgText is MSG_TYPE_ENTRANCE");
            a(WD(str));
            cka();
        } else if (i == 1) {
            ab.i("MicroMsg.ShakeCardMsgMgr", "onReceive() msgText is MSG_TYPE_RED_DOT");
            a(WE(str));
            cka();
        }
        com.tencent.mm.plugin.shake.c.c.a.cjM();
        AppMethodBeat.o(24520);
    }

    private static void cka() {
        AppMethodBeat.i(24521);
        com.tencent.mm.sdk.b.a.xxA.m(new ql());
        AppMethodBeat.o(24521);
    }

    private static b WD(String str) {
        AppMethodBeat.i(24522);
        Map z = br.z(str, "sysmsg");
        if (z == null) {
            AppMethodBeat.o(24522);
            return null;
        }
        b bVar = new b();
        String str2 = (String) z.get(".sysmsg.begintime");
        if (TextUtils.isEmpty(str2) || !isNumeric(str2)) {
            ab.e("MicroMsg.ShakeCardMsgMgr", "parseEntrancedMsgFromMsgXml begintime is ".concat(String.valueOf(str2)));
            bVar.qsy = 0;
        } else {
            bVar.qsy = Integer.valueOf(str2).intValue();
        }
        str2 = (String) z.get(".sysmsg.endtime");
        if (TextUtils.isEmpty(str2) || !isNumeric(str2)) {
            ab.e("MicroMsg.ShakeCardMsgMgr", "parseEntrancedMsgFromMsgXml endtime is ".concat(String.valueOf(str2)));
            bVar.qsz = 0;
        } else {
            bVar.qsz = Integer.valueOf(str2).intValue();
        }
        bVar.qsA = (String) z.get(".sysmsg.entrancename");
        str2 = (String) z.get(".sysmsg.activitytype");
        if (TextUtils.isEmpty(str2) || !isNumeric(str2)) {
            bVar.qsB = 1;
        } else {
            bVar.qsB = Integer.valueOf(str2).intValue();
        }
        ab.i("MicroMsg.ShakeCardMsgMgr", "parseEntrancedMsgFromMsgXml activitytype is ".concat(String.valueOf(str2)));
        str2 = (String) z.get(".sysmsg.flowcontrollevelmin");
        if (TextUtils.isEmpty(str2) || !isNumeric(str2)) {
            ab.e("MicroMsg.ShakeCardMsgMgr", "parseEntrancedMsgFromMsgXml flowcontrollevelmin is ".concat(String.valueOf(str2)));
            bVar.qsC = 0;
        } else {
            bVar.qsC = Integer.valueOf(str2).intValue();
        }
        bVar.qsE = (String) z.get(".sysmsg.shakecardentrancetip");
        str2 = (String) z.get(".sysmsg.flowcontrollevelmax");
        if (TextUtils.isEmpty(str2) || !isNumeric(str2)) {
            ab.e("MicroMsg.ShakeCardMsgMgr", "parseEntrancedMsgFromMsgXml flowcontrollevelmax is ".concat(String.valueOf(str2)));
            bVar.qsD = 0;
        } else {
            bVar.qsD = Integer.valueOf(str2).intValue();
        }
        AppMethodBeat.o(24522);
        return bVar;
    }

    private static void a(b bVar) {
        AppMethodBeat.i(24523);
        if (bVar == null) {
            ab.e("MicroMsg.ShakeCardMsgMgr", "saveEntranceMsg msg == null");
            AppMethodBeat.o(24523);
            return;
        }
        ab.i("MicroMsg.ShakeCardMsgMgr", "saveEntranceMsg msg");
        if (!com.tencent.mm.plugin.shake.c.c.a.cjN()) {
            ab.i("MicroMsg.ShakeCardMsgMgr", "saveEntranceMsg isShakeCardEntranceOpen is false");
        }
        ab.i("MicroMsg.ShakeCardMsgMgr", "saveEntranceMsg begintime:" + bVar.qsy + "  endtime:" + bVar.qsz + "  flowlevelmin:" + bVar.qsC + "  flowlevelmax:" + bVar.qsD + " entrancename:" + bVar.qsA + " activitytype:" + bVar.qsB);
        aw.ZK();
        com.tencent.mm.model.c.Ry().set(com.tencent.mm.storage.ac.a.USERINFO_SHAKE_CARD_ENTRANCE_BEGIN_TIME_INT_SYNC, Integer.valueOf(bVar.qsy));
        aw.ZK();
        com.tencent.mm.model.c.Ry().set(com.tencent.mm.storage.ac.a.USERINFO_SHAKE_CARD_ENTRANCE_END_TIME_INT_SYNC, Integer.valueOf(bVar.qsz));
        aw.ZK();
        com.tencent.mm.model.c.Ry().set(com.tencent.mm.storage.ac.a.USERINFO_SHAKE_CARD_ENTRANCE_NAME_STRING_SYNC, bVar.qsA);
        aw.ZK();
        com.tencent.mm.model.c.Ry().set(com.tencent.mm.storage.ac.a.USERINFO_SHAKE_CARD_ACTIVITY_TYPE_INT_SYNC, Integer.valueOf(bVar.qsB));
        aw.ZK();
        com.tencent.mm.model.c.Ry().set(com.tencent.mm.storage.ac.a.USERINFO_SHAKE_CARD_FLOW_CONTROL_LEVEL_MIN_INT_SYNC, Integer.valueOf(bVar.qsC));
        aw.ZK();
        com.tencent.mm.model.c.Ry().set(com.tencent.mm.storage.ac.a.USERINFO_SHAKE_CARD_FLOW_CONTROL_LEVEL_MAX_INT_SYNC, Integer.valueOf(bVar.qsD));
        aw.ZK();
        com.tencent.mm.model.c.Ry().set(com.tencent.mm.storage.ac.a.USERINFO_SHAKE_CARD_ENTRANCE_TIP_STRING_SYNC, bVar.qsE);
        AppMethodBeat.o(24523);
    }

    private static d WE(String str) {
        AppMethodBeat.i(24524);
        Map z = br.z(str, "sysmsg");
        if (z == null) {
            AppMethodBeat.o(24524);
            return null;
        }
        d dVar = new d();
        dVar.qsF = (String) z.get(".sysmsg.reddotid");
        dVar.qsG = (String) z.get(".sysmsg.reddotdesc");
        dVar.qsH = (String) z.get(".sysmsg.reddottext");
        AppMethodBeat.o(24524);
        return dVar;
    }

    private void a(d dVar) {
        AppMethodBeat.i(24525);
        if (dVar == null) {
            ab.e("MicroMsg.ShakeCardMsgMgr", "saveRedDotMsg msg == null");
            AppMethodBeat.o(24525);
            return;
        }
        ab.i("MicroMsg.ShakeCardMsgMgr", "saveRedDotMsg msg reddotid is " + dVar.qsF);
        ab.i("MicroMsg.ShakeCardMsgMgr", "saveRedDotMsg pre reddotid is " + this.qsx);
        if (TextUtils.isEmpty(dVar.qsF)) {
            ab.i("MicroMsg.ShakeCardMsgMgr", "msg.reddotid is empty");
            AppMethodBeat.o(24525);
        } else if (TextUtils.isEmpty(this.qsx)) {
            ab.i("MicroMsg.ShakeCardMsgMgr", "redDotId is empty, msg.reddotid is not empty");
            com.tencent.mm.x.c.PK().y(262154, true);
            aw.ZK();
            com.tencent.mm.model.c.Ry().set(com.tencent.mm.storage.ac.a.USERINFO_SHAKE_CARD_ENTRANCE_RED_DOT_ID_STRING_SYNC, dVar.qsF);
            aw.ZK();
            com.tencent.mm.model.c.Ry().set(com.tencent.mm.storage.ac.a.USERINFO_SHAKE_CARD_ENTRANCE_RED_DOT_DESC_STRING_SYNC, dVar.qsG);
            aw.ZK();
            com.tencent.mm.model.c.Ry().set(com.tencent.mm.storage.ac.a.USERINFO_SHAKE_CARD_ENTRANCE_RED_DOT_TEXT_STRING_SYNC, dVar.qsH);
            aVU();
            AppMethodBeat.o(24525);
        } else if (this.qsx.equals(dVar.qsF)) {
            if (this.qsx.equals(dVar.qsF)) {
                ab.i("MicroMsg.ShakeCardMsgMgr", "redDotId equals msg.reddotid");
            }
            AppMethodBeat.o(24525);
        } else {
            ab.i("MicroMsg.ShakeCardMsgMgr", "redDotId and msg.reddotid is not empty, but no equals");
            com.tencent.mm.x.c.PK().y(262154, true);
            aw.ZK();
            com.tencent.mm.model.c.Ry().set(com.tencent.mm.storage.ac.a.USERINFO_SHAKE_CARD_ENTRANCE_RED_DOT_ID_STRING_SYNC, dVar.qsF);
            aw.ZK();
            com.tencent.mm.model.c.Ry().set(com.tencent.mm.storage.ac.a.USERINFO_SHAKE_CARD_ENTRANCE_RED_DOT_DESC_STRING_SYNC, dVar.qsG);
            aw.ZK();
            com.tencent.mm.model.c.Ry().set(com.tencent.mm.storage.ac.a.USERINFO_SHAKE_CARD_ENTRANCE_RED_DOT_TEXT_STRING_SYNC, dVar.qsH);
            aVU();
            AppMethodBeat.o(24525);
        }
    }

    private static boolean isNumeric(String str) {
        AppMethodBeat.i(24526);
        boolean matches = Pattern.compile("[0-9]*").matcher(str).matches();
        AppMethodBeat.o(24526);
        return matches;
    }

    private void aVU() {
        AppMethodBeat.i(24527);
        if (this.kaD == null) {
            AppMethodBeat.o(24527);
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.kaD.size()) {
                WeakReference weakReference = (WeakReference) this.kaD.get(i2);
                if (weakReference != null) {
                    a aVar = (a) weakReference.get();
                    if (aVar != null) {
                        aVar.ckb();
                    }
                }
                i = i2 + 1;
            } else {
                AppMethodBeat.o(24527);
                return;
            }
        }
    }
}
