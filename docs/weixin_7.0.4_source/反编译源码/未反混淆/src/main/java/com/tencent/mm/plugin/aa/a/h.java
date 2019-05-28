package com.tencent.mm.plugin.aa.a;

import android.app.Activity;
import android.os.Bundle;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.a.g;
import com.tencent.mm.af.j;
import com.tencent.mm.af.j.b;
import com.tencent.mm.at.a.a;
import com.tencent.mm.at.o;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.r;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.aa.a.b.c;
import com.tencent.mm.protocal.protobuf.y;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import com.tencent.mm.storage.ac;
import com.tencent.mm.storage.bi;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class h {
    private static synchronized void bf(String str, String str2) {
        boolean z = true;
        synchronized (h.class) {
            AppMethodBeat.i(40609);
            if (!bo.isNullOrNil(str)) {
                b me = b.me(str);
                if (!(me == null || bo.isNullOrNil(me.fih))) {
                    long j;
                    c vH = com.tencent.mm.plugin.aa.b.aod().vH(me.fih);
                    String str3 = "MicroMsg.AAUtil";
                    String str4 = "insertAAMsg, billNo: %s, chatroom: %s, oldRecord: %s, insertMsg: %s, localMsgId: %s";
                    Object[] objArr = new Object[5];
                    objArr[0] = me.fih;
                    objArr[1] = str2;
                    objArr[2] = vH;
                    if (vH == null || !vH.field_insertmsg) {
                        z = false;
                    }
                    objArr[3] = Boolean.valueOf(z);
                    if (vH != null) {
                        j = vH.field_localMsgId;
                    } else {
                        j = 0;
                    }
                    objArr[4] = Long.valueOf(j);
                    ab.i(str3, str4, objArr);
                    if (vH == null) {
                        ab.e("MicroMsg.AAUtil", "insertAAMsg, record is null!!");
                        AppMethodBeat.o(40609);
                    } else if (!vH.field_insertmsg || vH.field_localMsgId <= 0) {
                        bi biVar = new bi();
                        biVar.eJ(bf.oC(str2));
                        biVar.setType(436207665);
                        biVar.setContent(r.Yz() + ":\n" + str);
                        String x = g.x((bo.anU()).getBytes());
                        String fullPath = o.ahl().getFullPath(x);
                        o.ahl();
                        x = com.tencent.mm.at.g.si(x);
                        a ahp = o.ahp();
                        String str5 = me.fhR;
                        com.tencent.mm.at.a.a.c.a aVar = new com.tencent.mm.at.a.a.c.a();
                        aVar.ePJ = fullPath;
                        aVar.ePH = true;
                        ahp.a(str5, null, aVar.ahG());
                        biVar.jv(x);
                        biVar.hO(1);
                        biVar.ju(str2);
                        biVar.setStatus(3);
                        biVar.setMsgId(bf.l(biVar));
                        ab.i("MicroMsg.AAUtil", "finish insert aa msg");
                        a(me.fih, true, biVar.field_msgId);
                        j jVar = new j();
                        me.a(jVar);
                        jVar.field_msgId = biVar.field_msgId;
                        com.tencent.mm.plugin.s.a.bYK().b((com.tencent.mm.sdk.e.c) jVar);
                    }
                }
            }
            AppMethodBeat.o(40609);
        }
    }

    public static synchronized void a(String str, boolean z, long j) {
        synchronized (h.class) {
            AppMethodBeat.i(40610);
            if (!bo.isNullOrNil(str)) {
                ab.i("MicroMsg.AAUtil", "insertOrUpdateAARecord, billNo: %s, insertMsg: %s", str, Boolean.valueOf(z));
                c cVar = new c();
                cVar.field_billNo = str;
                cVar.field_insertmsg = z;
                cVar.field_localMsgId = j;
                com.tencent.mm.plugin.aa.b.aod().b(cVar);
            }
            AppMethodBeat.o(40610);
        }
    }

    public static synchronized void bg(String str, String str2) {
        boolean z = true;
        synchronized (h.class) {
            AppMethodBeat.i(40611);
            if (!bo.isNullOrNil(str)) {
                b me = b.me(str);
                String str3 = "MicroMsg.AAUtil";
                String str4 = "checkIfInsertAAMsg, billNo: %s, appMsgContent: %s";
                Object[] objArr = new Object[2];
                objArr[0] = me != null ? me.fih : "";
                objArr[1] = str.trim().replace(" ", "");
                ab.d(str3, str4, objArr);
                if (!(me == null || bo.isNullOrNil(me.fih))) {
                    boolean z2;
                    long j;
                    String str5 = me.fih;
                    c vH = com.tencent.mm.plugin.aa.b.aod().vH(str5);
                    str4 = "MicroMsg.AAUtil";
                    String str6 = "checkIfInsertAAMsg, record==null: %s, billNo: %s, insertMsg: %s, chatroom: %s, localMsgId: %s";
                    Object[] objArr2 = new Object[5];
                    if (vH == null) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    objArr2[0] = Boolean.valueOf(z2);
                    objArr2[1] = str5;
                    if (vH == null || !vH.field_insertmsg) {
                        z = false;
                    }
                    objArr2[2] = Boolean.valueOf(z);
                    objArr2[3] = str2;
                    if (vH != null) {
                        j = vH.field_localMsgId;
                    } else {
                        j = 0;
                    }
                    objArr2[4] = Long.valueOf(j);
                    ab.i(str4, str6, objArr2);
                    if (vH == null) {
                        ab.e("MicroMsg.AAUtil", "checkIfInsertAAMsg, record is null, ignore");
                        a(str5, false, 0);
                    }
                    if (vH != null && vH.field_insertmsg && vH.field_localMsgId > 0 && ((com.tencent.mm.plugin.messenger.foundation.a.j) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bOr().jf(vH.field_localMsgId).field_msgId <= 0) {
                        ab.i("MicroMsg.AAUtil", "checkIfInsertAAMsg, the oldMsgInfo has deleted, ignore this");
                        com.tencent.mm.plugin.aa.b.aod().a(vH, new String[0]);
                        AppMethodBeat.o(40611);
                    } else if (vH == null || !vH.field_insertmsg || vH.field_localMsgId <= 0) {
                        ab.i("MicroMsg.AAUtil", "checkIfInsertAAMsg, insert new aa msg");
                        bf(str, str2);
                        AppMethodBeat.o(40611);
                    } else {
                        ab.i("MicroMsg.AAUtil", "checkIfInsertAAMsg, update aa msg");
                        g(vH.field_localMsgId, str);
                    }
                }
            }
            AppMethodBeat.o(40611);
        }
    }

    public static synchronized void w(String str, String str2, String str3) {
        synchronized (h.class) {
            AppMethodBeat.i(40612);
            ab.i("MicroMsg.AAUtil", "setAARecordAfterLaunchAA, billNo: %s, chatroom: %s, msgContent==null:%s, oldRecord: %s", str, str2, Boolean.valueOf(bo.isNullOrNil(str3)), com.tencent.mm.plugin.aa.b.aod().vH(str));
            if (com.tencent.mm.plugin.aa.b.aod().vH(str) == null) {
                a(str, false, 0);
            }
            bg(str3, str2);
            AppMethodBeat.o(40612);
        }
    }

    public static synchronized void c(String str, String str2, String str3, String str4, String str5) {
        boolean z = true;
        synchronized (h.class) {
            AppMethodBeat.i(40613);
            ab.d("MicroMsg.AAUtil", "insertPayMsgAfterPaySucc, launcherUsername: %s, billNo: %s, payMsgId: %s", str, str3, str4);
            if (!(bo.isNullOrNil(str) || bo.isNullOrNil(str3) || bo.isNullOrNil(str4))) {
                com.tencent.mm.plugin.aa.a.b.a vG = com.tencent.mm.plugin.aa.b.aoe().vG(str4);
                String str6 = "MicroMsg.AAUtil";
                String str7 = "insertPayMsgAfterPaySucc, launcherUsername: %s, chatroom: %s, payMsgId: %s, record: %s, insertmsg: %s";
                Object[] objArr = new Object[5];
                objArr[0] = str;
                objArr[1] = str2;
                objArr[2] = str4;
                objArr[3] = vG;
                if (vG == null || !vG.field_insertmsg) {
                    z = false;
                }
                objArr[4] = Boolean.valueOf(z);
                ab.i(str6, str7, objArr);
                if (vG == null || !vG.field_insertmsg) {
                    String str8 = "weixin://weixinnewaa/opendetail?billno=" + str3 + "&launcherusername=" + str;
                    if (bo.isNullOrNil(str5)) {
                        ab.i("MicroMsg.AAUtil", "empty msgxml, insert local msgcontent");
                        if (str.equals(r.Yz())) {
                            str5 = ah.getContext().getString(R.string.db9, new Object[]{str8});
                        } else {
                            String displayName = ((com.tencent.mm.plugin.messenger.a.b) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.messenger.a.b.class)).getDisplayName(str, str2);
                            str5 = ah.getContext().getString(R.string.db_, new Object[]{displayName, str8});
                        }
                    } else {
                        ab.d("MicroMsg.AAUtil", "insert msgxml: %s", str5);
                    }
                    a(str5, str2, vG, str4);
                }
            }
            AppMethodBeat.o(40613);
        }
    }

    public static synchronized void x(String str, String str2, String str3) {
        synchronized (h.class) {
            AppMethodBeat.i(40614);
            try {
                if (!(bo.isNullOrNil(str) || bo.isNullOrNil(str2) || bo.isNullOrNil(str3))) {
                    ab.i("MicroMsg.AAUtil", "checkIfInsertPaySysMsg, chatroom: %s, payMsgId: %s", str2, str3);
                    com.tencent.mm.plugin.aa.a.b.a vG = com.tencent.mm.plugin.aa.b.aoe().vG(str3);
                    if (vG == null || !vG.field_insertmsg) {
                        ab.i("MicroMsg.AAUtil", "checkIfInsertPaySysMsg, insert new msg");
                        a(str, str2, vG, str3);
                        AppMethodBeat.o(40614);
                    } else {
                        bi jf = ((com.tencent.mm.plugin.messenger.foundation.a.j) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bOr().jf(vG.field_msgId);
                        ab.i("MicroMsg.AAUtil", "checkIfInsertPaySysMsg, update old one, msgId: %s, dbMsginfo.id: %s", Long.valueOf(vG.field_msgId), Long.valueOf(jf.field_msgId));
                        jf.setContent(str);
                        ((com.tencent.mm.plugin.messenger.foundation.a.j) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bOr().a(vG.field_msgId, jf);
                    }
                }
                AppMethodBeat.o(40614);
            } catch (Exception e) {
                ab.e("MicroMsg.AAUtil", "checkIfInsertPaySysMsg error: %s", e.getMessage());
                AppMethodBeat.o(40614);
            }
        }
        return;
    }

    private static synchronized void a(String str, String str2, com.tencent.mm.plugin.aa.a.b.a aVar, String str3) {
        synchronized (h.class) {
            AppMethodBeat.i(40615);
            bi biVar = new bi();
            biVar.hO(0);
            biVar.ju(str2);
            biVar.setStatus(3);
            biVar.setContent(str);
            biVar.eJ(bf.q(str2, System.currentTimeMillis() / 1000));
            biVar.setType(Downloads.MIN_WAIT_FOR_NETWORK);
            long Z = ((com.tencent.mm.plugin.messenger.foundation.a.j) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bOr().Z(biVar);
            ab.i("MicroMsg.AAUtil", "insertPaySysMsg, inserted msgId: %s", Long.valueOf(Z));
            if (aVar == null) {
                aVar = new com.tencent.mm.plugin.aa.a.b.a();
            }
            if (Z > 0) {
                aVar.field_payMsgId = str3;
                aVar.field_chatroom = str2;
                aVar.field_insertmsg = true;
                aVar.field_msgId = Z;
                com.tencent.mm.plugin.aa.b.aoe().a(aVar);
            }
            AppMethodBeat.o(40615);
        }
    }

    public static synchronized void g(long j, String str) {
        synchronized (h.class) {
            AppMethodBeat.i(40616);
            if (j <= 0 || bo.isNullOrNil(str)) {
                ab.e("MicroMsg.AAUtil", "updateAARecordMsgAfterReceive, msgContent is null or msgId invalid, msgId: %s, %s", Long.valueOf(j), Boolean.valueOf(bo.isNullOrNil(str)));
                AppMethodBeat.o(40616);
            } else {
                b me = b.me(str);
                if (me == null || bo.isNullOrNil(me.fih)) {
                    ab.e("MicroMsg.AAUtil", "updateAARecordMsgAfterReceive, parse app msg failed, msgId: %s", Long.valueOf(j));
                    AppMethodBeat.o(40616);
                } else {
                    ab.i("MicroMsg.AAUtil", "updateAARecordMsgAfterReceive, msgId: %s, billNo: %s", Long.valueOf(j), me.fih);
                    c vH = com.tencent.mm.plugin.aa.b.aod().vH(me.fih);
                    if (vH != null) {
                        long j2 = vH.field_localMsgId;
                        bi jf = ((com.tencent.mm.plugin.messenger.foundation.a.j) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bOr().jf(j2);
                        if (jf.field_msgId > 0) {
                            jf.setContent(bf.oy(jf.field_content) + ":\n" + str);
                            ((com.tencent.mm.plugin.messenger.foundation.a.j) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bOr().a(j2, jf);
                            ab.i("MicroMsg.AAUtil", "updateAARecordMsgAfterReceive, update success, oldMsgId: %s, billNo: %s", Long.valueOf(j2), vH.field_billNo);
                            AppMethodBeat.o(40616);
                        } else {
                            ab.e("MicroMsg.AAUtil", "updateAARecordMsgAfterReceive, cannot find old msg, insert new one, billNo: %s, oldMsgId: %s, newMsgId: %s, needUpdateInfo.msgId: %s", vH.field_billNo, Long.valueOf(vH.field_localMsgId), Long.valueOf(j), Long.valueOf(jf.field_msgId));
                            AppMethodBeat.o(40616);
                        }
                    } else {
                        vH = new c();
                        vH.field_localMsgId = j;
                        vH.field_billNo = me.fih;
                        vH.field_insertmsg = true;
                        com.tencent.mm.plugin.aa.b.aod().a(vH);
                        ab.i("MicroMsg.AAUtil", "updateAARecordMsgAfterReceive, insert new aa record, msgId: %s, billNo: %s", Long.valueOf(j), me.fih);
                        AppMethodBeat.o(40616);
                    }
                }
            }
        }
    }

    public static void h(long j, String str) {
        AppMethodBeat.i(40617);
        ab.i("MicroMsg.AAUtil", "do update sys msg, %s, %s", Long.valueOf(j), str);
        bi jf = ((com.tencent.mm.plugin.messenger.foundation.a.j) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bOr().jf(j);
        String vD = vD(str);
        if (!bo.isNullOrNil(vD)) {
            jf.setContent(vD);
        }
        ((com.tencent.mm.plugin.messenger.foundation.a.j) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bOr().a(j, jf);
        AppMethodBeat.o(40617);
    }

    public static boolean a(Activity activity, y yVar) {
        AppMethodBeat.i(40618);
        boolean a;
        if (yVar.vAF == 1) {
            ab.i("MicroMsg.AAUtil", "need realname verify");
            Bundle bundle = new Bundle();
            bundle.putString("realname_verify_process_jump_activity", ".ui.LaunchAAUI");
            bundle.putString("realname_verify_process_jump_plugin", "aa");
            a = com.tencent.mm.plugin.wallet_core.id_verify.util.a.a(activity, bundle, null, 0);
            AppMethodBeat.o(40618);
            return a;
        } else if (yVar.vAF == 2) {
            ab.i("MicroMsg.AAUtil", "need upload credit");
            a = com.tencent.mm.plugin.wallet_core.id_verify.util.a.a(activity, yVar.nZa, yVar.nZd, yVar.nZb, yVar.nZc, false, null);
            AppMethodBeat.o(40618);
            return a;
        } else {
            ab.i("MicroMsg.AAUtil", "realnameGuideFlag =  " + yVar.vAF);
            AppMethodBeat.o(40618);
            return false;
        }
    }

    private static String vD(String str) {
        UnsupportedEncodingException e;
        AppMethodBeat.i(40619);
        Map z = br.z(str, "sysmsg");
        String str2;
        if (z == null) {
            str2 = "";
            AppMethodBeat.o(40619);
            return str2;
        }
        str2 = (String) z.get(".sysmsg.paymsg.appmsgcontent");
        if (bo.isNullOrNil(str2)) {
            ab.e("MicroMsg.AAUtil", "empty appmsgcontent!");
            str2 = "";
            AppMethodBeat.o(40619);
            return str2;
        }
        String str3 = "";
        try {
            str2 = URLDecoder.decode(str2, "UTF-8");
            try {
                ab.d("MicroMsg.AAUtil", "msgContent: %s", str2);
            } catch (UnsupportedEncodingException e2) {
                e = e2;
                ab.e("MicroMsg.AAUtil", e.getMessage());
                AppMethodBeat.o(40619);
                return str2;
            }
        } catch (UnsupportedEncodingException e3) {
            e = e3;
            str2 = str3;
        }
        AppMethodBeat.o(40619);
        return str2;
    }

    public static double a(String str, String str2, int i, int i2) {
        double d = 0.0d;
        AppMethodBeat.i(40620);
        try {
            d = new BigDecimal(bo.getDouble(str.trim(), 0.0d) == 0.0d ? AppEventsConstants.EVENT_PARAM_VALUE_NO : str.trim()).divide(new BigDecimal(str2.trim()), i, i2).doubleValue();
            AppMethodBeat.o(40620);
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.AAUtil", e, "", new Object[0]);
            AppMethodBeat.o(40620);
        }
        return d;
    }

    public static long bh(String str, String str2) {
        AppMethodBeat.i(40621);
        try {
            double d = bo.getDouble(str, 0.0d);
            double d2 = bo.getDouble(str2, 0.0d);
            if (d == 0.0d) {
                str = AppEventsConstants.EVENT_PARAM_VALUE_NO;
            }
            BigDecimal bigDecimal = new BigDecimal(str);
            if (d2 == 0.0d) {
                str2 = AppEventsConstants.EVENT_PARAM_VALUE_NO;
            }
            long longValue = bigDecimal.multiply(new BigDecimal(str2)).longValue();
            AppMethodBeat.o(40621);
            return longValue;
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.AAUtil", e, "", new Object[0]);
            AppMethodBeat.o(40621);
            return 0;
        }
    }

    public static List<String> vE(String str) {
        AppMethodBeat.i(40622);
        List<String> oe;
        if (bo.isNullOrNil(str)) {
            ab.i("MicroMsg.AAUtil", "illegal chatroomName");
            ArrayList arrayList = new ArrayList();
            AppMethodBeat.o(40622);
            return arrayList;
        } else if (t.kH(str)) {
            try {
                oe = ((com.tencent.mm.plugin.chatroom.a.c) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.chatroom.a.c.class)).XV().oe(str);
                if (oe == null) {
                    oe = new ArrayList();
                }
                AppMethodBeat.o(40622);
                return oe;
            } catch (Exception e) {
                ab.e("MicroMsg.AAUtil", "getChatroomMemberList error! %s", e.getMessage());
                oe = new ArrayList();
                AppMethodBeat.o(40622);
                return oe;
            }
        } else {
            oe = new ArrayList();
            oe.add(r.Yz());
            oe.add(str);
            AppMethodBeat.o(40622);
            return oe;
        }
    }

    public static String aom() {
        AppMethodBeat.i(40623);
        com.tencent.mm.kernel.g.RQ();
        String nullAsNil = bo.nullAsNil((String) com.tencent.mm.kernel.g.RP().Ry().get(ac.a.USERINFO_RECENT_LAUNCH_AA_GROUP_STRING_SYNC, null));
        AppMethodBeat.o(40623);
        return nullAsNil;
    }

    public static void vF(String str) {
        AppMethodBeat.i(40624);
        String aom = aom();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(",");
        if (!bo.isNullOrNil(aom)) {
            String[] split = aom.split(",");
            int i = 1;
            for (String str2 : split) {
                if (!str2.equals(str) && i < 5) {
                    stringBuilder.append(str2);
                    stringBuilder.append(",");
                    i++;
                }
            }
        }
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        ab.d("MicroMsg.AAUtil", "recent group: %s", stringBuilder.toString());
        com.tencent.mm.kernel.g.RQ();
        com.tencent.mm.kernel.g.RP().Ry().set(ac.a.USERINFO_RECENT_LAUNCH_AA_GROUP_STRING_SYNC, stringBuilder.toString());
        AppMethodBeat.o(40624);
    }
}
