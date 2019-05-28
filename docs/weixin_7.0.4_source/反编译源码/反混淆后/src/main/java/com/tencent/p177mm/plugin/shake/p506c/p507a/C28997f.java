package com.tencent.p177mm.plugin.shake.p506c.p507a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p1099x.C16112c;
import com.tencent.p177mm.p230g.p231a.C26219ql;
import com.tencent.p177mm.plugin.shake.p506c.p1411c.C28999a;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5049br;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/* renamed from: com.tencent.mm.plugin.shake.c.a.f */
public final class C28997f {
    public List<WeakReference<C28996a>> kaD;
    private String qsx;

    /* renamed from: com.tencent.mm.plugin.shake.c.a.f$c */
    public static class C13256c {
    }

    /* renamed from: com.tencent.mm.plugin.shake.c.a.f$b */
    public static class C16864b extends C13256c {
        protected String qsA = "";
        protected int qsB = 0;
        protected int qsC = 0;
        protected int qsD = 7;
        protected String qsE = "";
        protected int qsy = 0;
        protected int qsz = 0;
    }

    /* renamed from: com.tencent.mm.plugin.shake.c.a.f$a */
    public interface C28996a {
        void ckb();
    }

    /* renamed from: com.tencent.mm.plugin.shake.c.a.f$d */
    public static class C28998d extends C13256c {
        protected String qsF;
        protected String qsG;
        protected String qsH;
    }

    public C28997f() {
        AppMethodBeat.m2504i(24519);
        this.kaD = new ArrayList();
        this.qsx = "";
        this.qsx = C28999a.cko();
        AppMethodBeat.m2505o(24519);
    }

    /* renamed from: i */
    public final void mo47086i(String str, long j, int i) {
        AppMethodBeat.m2504i(24520);
        C4990ab.m7416i("MicroMsg.ShakeCardMsgMgr", "msg_id is ".concat(String.valueOf(j)));
        if (TextUtils.isEmpty(str)) {
            C4990ab.m7412e("MicroMsg.ShakeCardMsgMgr", "onReceive() msgText is empty");
            AppMethodBeat.m2505o(24520);
            return;
        }
        if (i == 0) {
            C4990ab.m7416i("MicroMsg.ShakeCardMsgMgr", "onReceive() msgText is MSG_TYPE_ENTRANCE");
            C28997f.m46030a(C28997f.m46028WD(str));
            C28997f.cka();
        } else if (i == 1) {
            C4990ab.m7416i("MicroMsg.ShakeCardMsgMgr", "onReceive() msgText is MSG_TYPE_RED_DOT");
            m46031a(C28997f.m46029WE(str));
            C28997f.cka();
        }
        C28999a.cjM();
        AppMethodBeat.m2505o(24520);
    }

    private static void cka() {
        AppMethodBeat.m2504i(24521);
        C4879a.xxA.mo10055m(new C26219ql());
        AppMethodBeat.m2505o(24521);
    }

    /* renamed from: WD */
    private static C16864b m46028WD(String str) {
        AppMethodBeat.m2504i(24522);
        Map z = C5049br.m7595z(str, "sysmsg");
        if (z == null) {
            AppMethodBeat.m2505o(24522);
            return null;
        }
        C16864b c16864b = new C16864b();
        String str2 = (String) z.get(".sysmsg.begintime");
        if (TextUtils.isEmpty(str2) || !C28997f.isNumeric(str2)) {
            C4990ab.m7412e("MicroMsg.ShakeCardMsgMgr", "parseEntrancedMsgFromMsgXml begintime is ".concat(String.valueOf(str2)));
            c16864b.qsy = 0;
        } else {
            c16864b.qsy = Integer.valueOf(str2).intValue();
        }
        str2 = (String) z.get(".sysmsg.endtime");
        if (TextUtils.isEmpty(str2) || !C28997f.isNumeric(str2)) {
            C4990ab.m7412e("MicroMsg.ShakeCardMsgMgr", "parseEntrancedMsgFromMsgXml endtime is ".concat(String.valueOf(str2)));
            c16864b.qsz = 0;
        } else {
            c16864b.qsz = Integer.valueOf(str2).intValue();
        }
        c16864b.qsA = (String) z.get(".sysmsg.entrancename");
        str2 = (String) z.get(".sysmsg.activitytype");
        if (TextUtils.isEmpty(str2) || !C28997f.isNumeric(str2)) {
            c16864b.qsB = 1;
        } else {
            c16864b.qsB = Integer.valueOf(str2).intValue();
        }
        C4990ab.m7416i("MicroMsg.ShakeCardMsgMgr", "parseEntrancedMsgFromMsgXml activitytype is ".concat(String.valueOf(str2)));
        str2 = (String) z.get(".sysmsg.flowcontrollevelmin");
        if (TextUtils.isEmpty(str2) || !C28997f.isNumeric(str2)) {
            C4990ab.m7412e("MicroMsg.ShakeCardMsgMgr", "parseEntrancedMsgFromMsgXml flowcontrollevelmin is ".concat(String.valueOf(str2)));
            c16864b.qsC = 0;
        } else {
            c16864b.qsC = Integer.valueOf(str2).intValue();
        }
        c16864b.qsE = (String) z.get(".sysmsg.shakecardentrancetip");
        str2 = (String) z.get(".sysmsg.flowcontrollevelmax");
        if (TextUtils.isEmpty(str2) || !C28997f.isNumeric(str2)) {
            C4990ab.m7412e("MicroMsg.ShakeCardMsgMgr", "parseEntrancedMsgFromMsgXml flowcontrollevelmax is ".concat(String.valueOf(str2)));
            c16864b.qsD = 0;
        } else {
            c16864b.qsD = Integer.valueOf(str2).intValue();
        }
        AppMethodBeat.m2505o(24522);
        return c16864b;
    }

    /* renamed from: a */
    private static void m46030a(C16864b c16864b) {
        AppMethodBeat.m2504i(24523);
        if (c16864b == null) {
            C4990ab.m7412e("MicroMsg.ShakeCardMsgMgr", "saveEntranceMsg msg == null");
            AppMethodBeat.m2505o(24523);
            return;
        }
        C4990ab.m7416i("MicroMsg.ShakeCardMsgMgr", "saveEntranceMsg msg");
        if (!C28999a.cjN()) {
            C4990ab.m7416i("MicroMsg.ShakeCardMsgMgr", "saveEntranceMsg isShakeCardEntranceOpen is false");
        }
        C4990ab.m7416i("MicroMsg.ShakeCardMsgMgr", "saveEntranceMsg begintime:" + c16864b.qsy + "  endtime:" + c16864b.qsz + "  flowlevelmin:" + c16864b.qsC + "  flowlevelmax:" + c16864b.qsD + " entrancename:" + c16864b.qsA + " activitytype:" + c16864b.qsB);
        C9638aw.m17190ZK();
        C18628c.m29072Ry().set(C5127a.USERINFO_SHAKE_CARD_ENTRANCE_BEGIN_TIME_INT_SYNC, Integer.valueOf(c16864b.qsy));
        C9638aw.m17190ZK();
        C18628c.m29072Ry().set(C5127a.USERINFO_SHAKE_CARD_ENTRANCE_END_TIME_INT_SYNC, Integer.valueOf(c16864b.qsz));
        C9638aw.m17190ZK();
        C18628c.m29072Ry().set(C5127a.USERINFO_SHAKE_CARD_ENTRANCE_NAME_STRING_SYNC, c16864b.qsA);
        C9638aw.m17190ZK();
        C18628c.m29072Ry().set(C5127a.USERINFO_SHAKE_CARD_ACTIVITY_TYPE_INT_SYNC, Integer.valueOf(c16864b.qsB));
        C9638aw.m17190ZK();
        C18628c.m29072Ry().set(C5127a.USERINFO_SHAKE_CARD_FLOW_CONTROL_LEVEL_MIN_INT_SYNC, Integer.valueOf(c16864b.qsC));
        C9638aw.m17190ZK();
        C18628c.m29072Ry().set(C5127a.USERINFO_SHAKE_CARD_FLOW_CONTROL_LEVEL_MAX_INT_SYNC, Integer.valueOf(c16864b.qsD));
        C9638aw.m17190ZK();
        C18628c.m29072Ry().set(C5127a.USERINFO_SHAKE_CARD_ENTRANCE_TIP_STRING_SYNC, c16864b.qsE);
        AppMethodBeat.m2505o(24523);
    }

    /* renamed from: WE */
    private static C28998d m46029WE(String str) {
        AppMethodBeat.m2504i(24524);
        Map z = C5049br.m7595z(str, "sysmsg");
        if (z == null) {
            AppMethodBeat.m2505o(24524);
            return null;
        }
        C28998d c28998d = new C28998d();
        c28998d.qsF = (String) z.get(".sysmsg.reddotid");
        c28998d.qsG = (String) z.get(".sysmsg.reddotdesc");
        c28998d.qsH = (String) z.get(".sysmsg.reddottext");
        AppMethodBeat.m2505o(24524);
        return c28998d;
    }

    /* renamed from: a */
    private void m46031a(C28998d c28998d) {
        AppMethodBeat.m2504i(24525);
        if (c28998d == null) {
            C4990ab.m7412e("MicroMsg.ShakeCardMsgMgr", "saveRedDotMsg msg == null");
            AppMethodBeat.m2505o(24525);
            return;
        }
        C4990ab.m7416i("MicroMsg.ShakeCardMsgMgr", "saveRedDotMsg msg reddotid is " + c28998d.qsF);
        C4990ab.m7416i("MicroMsg.ShakeCardMsgMgr", "saveRedDotMsg pre reddotid is " + this.qsx);
        if (TextUtils.isEmpty(c28998d.qsF)) {
            C4990ab.m7416i("MicroMsg.ShakeCardMsgMgr", "msg.reddotid is empty");
            AppMethodBeat.m2505o(24525);
        } else if (TextUtils.isEmpty(this.qsx)) {
            C4990ab.m7416i("MicroMsg.ShakeCardMsgMgr", "redDotId is empty, msg.reddotid is not empty");
            C16112c.m24429PK().mo28557y(262154, true);
            C9638aw.m17190ZK();
            C18628c.m29072Ry().set(C5127a.USERINFO_SHAKE_CARD_ENTRANCE_RED_DOT_ID_STRING_SYNC, c28998d.qsF);
            C9638aw.m17190ZK();
            C18628c.m29072Ry().set(C5127a.USERINFO_SHAKE_CARD_ENTRANCE_RED_DOT_DESC_STRING_SYNC, c28998d.qsG);
            C9638aw.m17190ZK();
            C18628c.m29072Ry().set(C5127a.USERINFO_SHAKE_CARD_ENTRANCE_RED_DOT_TEXT_STRING_SYNC, c28998d.qsH);
            aVU();
            AppMethodBeat.m2505o(24525);
        } else if (this.qsx.equals(c28998d.qsF)) {
            if (this.qsx.equals(c28998d.qsF)) {
                C4990ab.m7416i("MicroMsg.ShakeCardMsgMgr", "redDotId equals msg.reddotid");
            }
            AppMethodBeat.m2505o(24525);
        } else {
            C4990ab.m7416i("MicroMsg.ShakeCardMsgMgr", "redDotId and msg.reddotid is not empty, but no equals");
            C16112c.m24429PK().mo28557y(262154, true);
            C9638aw.m17190ZK();
            C18628c.m29072Ry().set(C5127a.USERINFO_SHAKE_CARD_ENTRANCE_RED_DOT_ID_STRING_SYNC, c28998d.qsF);
            C9638aw.m17190ZK();
            C18628c.m29072Ry().set(C5127a.USERINFO_SHAKE_CARD_ENTRANCE_RED_DOT_DESC_STRING_SYNC, c28998d.qsG);
            C9638aw.m17190ZK();
            C18628c.m29072Ry().set(C5127a.USERINFO_SHAKE_CARD_ENTRANCE_RED_DOT_TEXT_STRING_SYNC, c28998d.qsH);
            aVU();
            AppMethodBeat.m2505o(24525);
        }
    }

    private static boolean isNumeric(String str) {
        AppMethodBeat.m2504i(24526);
        boolean matches = Pattern.compile("[0-9]*").matcher(str).matches();
        AppMethodBeat.m2505o(24526);
        return matches;
    }

    private void aVU() {
        AppMethodBeat.m2504i(24527);
        if (this.kaD == null) {
            AppMethodBeat.m2505o(24527);
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.kaD.size()) {
                WeakReference weakReference = (WeakReference) this.kaD.get(i2);
                if (weakReference != null) {
                    C28996a c28996a = (C28996a) weakReference.get();
                    if (c28996a != null) {
                        c28996a.ckb();
                    }
                }
                i = i2 + 1;
            } else {
                AppMethodBeat.m2505o(24527);
                return;
            }
        }
    }
}
