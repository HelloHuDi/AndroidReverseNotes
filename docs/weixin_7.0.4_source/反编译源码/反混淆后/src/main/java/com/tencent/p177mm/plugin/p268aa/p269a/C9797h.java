package com.tencent.p177mm.plugin.p268aa.p269a;

import android.app.Activity;
import android.os.Bundle;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1829bf;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.p178a.C1178g;
import com.tencent.p177mm.p181af.C8909j;
import com.tencent.p177mm.p181af.C8909j.C8910b;
import com.tencent.p177mm.p190at.C32291o;
import com.tencent.p177mm.p190at.C45160g;
import com.tencent.p177mm.p190at.p191a.C25815a;
import com.tencent.p177mm.p190at.p191a.p827a.C25814c.C17927a;
import com.tencent.p177mm.plugin.chatroom.p721a.C6822c;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.messenger.p993a.C34530b;
import com.tencent.p177mm.plugin.p268aa.C45488b;
import com.tencent.p177mm.plugin.p268aa.p269a.p879b.C26535c;
import com.tencent.p177mm.plugin.p268aa.p269a.p879b.C31278a;
import com.tencent.p177mm.plugin.p500s.C34832a;
import com.tencent.p177mm.plugin.wallet_core.id_verify.util.C43795a;
import com.tencent.p177mm.protocal.protobuf.C35967y;
import com.tencent.p177mm.sdk.p603e.C4925c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5049br;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.p177mm.storage.C7620bi;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.aa.a.h */
public final class C9797h {
    /* renamed from: bf */
    private static synchronized void m17455bf(String str, String str2) {
        boolean z = true;
        synchronized (C9797h.class) {
            AppMethodBeat.m2504i(40609);
            if (!C5046bo.isNullOrNil(str)) {
                C8910b me = C8910b.m16064me(str);
                if (!(me == null || C5046bo.isNullOrNil(me.fih))) {
                    long j;
                    C26535c vH = C45488b.aod().mo21152vH(me.fih);
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
                    C4990ab.m7417i(str3, str4, objArr);
                    if (vH == null) {
                        C4990ab.m7412e("MicroMsg.AAUtil", "insertAAMsg, record is null!!");
                        AppMethodBeat.m2505o(40609);
                    } else if (!vH.field_insertmsg || vH.field_localMsgId <= 0) {
                        C7620bi c7620bi = new C7620bi();
                        c7620bi.mo14775eJ(C1829bf.m3756oC(str2));
                        c7620bi.setType(436207665);
                        c7620bi.setContent(C1853r.m3846Yz() + ":\n" + str);
                        String x = C1178g.m2591x((C5046bo.anU()).getBytes());
                        String fullPath = C32291o.ahl().getFullPath(x);
                        C32291o.ahl();
                        x = C45160g.m83082si(x);
                        C25815a ahp = C32291o.ahp();
                        String str5 = me.fhR;
                        C17927a c17927a = new C17927a();
                        c17927a.ePJ = fullPath;
                        c17927a.ePH = true;
                        ahp.mo43766a(str5, null, c17927a.ahG());
                        c7620bi.mo14795jv(x);
                        c7620bi.mo14781hO(1);
                        c7620bi.mo14794ju(str2);
                        c7620bi.setStatus(3);
                        c7620bi.setMsgId(C1829bf.m3752l(c7620bi));
                        C4990ab.m7416i("MicroMsg.AAUtil", "finish insert aa msg");
                        C9797h.m17453a(me.fih, true, c7620bi.field_msgId);
                        C8909j c8909j = new C8909j();
                        me.mo20335a(c8909j);
                        c8909j.field_msgId = c7620bi.field_msgId;
                        C34832a.bYK().mo10101b((C4925c) c8909j);
                    }
                }
            }
            AppMethodBeat.m2505o(40609);
        }
    }

    /* renamed from: a */
    public static synchronized void m17453a(String str, boolean z, long j) {
        synchronized (C9797h.class) {
            AppMethodBeat.m2504i(40610);
            if (!C5046bo.isNullOrNil(str)) {
                C4990ab.m7417i("MicroMsg.AAUtil", "insertOrUpdateAARecord, billNo: %s, insertMsg: %s", str, Boolean.valueOf(z));
                C26535c c26535c = new C26535c();
                c26535c.field_billNo = str;
                c26535c.field_insertmsg = z;
                c26535c.field_localMsgId = j;
                C45488b.aod().mo21151b(c26535c);
            }
            AppMethodBeat.m2505o(40610);
        }
    }

    /* renamed from: bg */
    public static synchronized void m17456bg(String str, String str2) {
        boolean z = true;
        synchronized (C9797h.class) {
            AppMethodBeat.m2504i(40611);
            if (!C5046bo.isNullOrNil(str)) {
                C8910b me = C8910b.m16064me(str);
                String str3 = "MicroMsg.AAUtil";
                String str4 = "checkIfInsertAAMsg, billNo: %s, appMsgContent: %s";
                Object[] objArr = new Object[2];
                objArr[0] = me != null ? me.fih : "";
                objArr[1] = str.trim().replace(" ", "");
                C4990ab.m7411d(str3, str4, objArr);
                if (!(me == null || C5046bo.isNullOrNil(me.fih))) {
                    boolean z2;
                    long j;
                    String str5 = me.fih;
                    C26535c vH = C45488b.aod().mo21152vH(str5);
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
                    C4990ab.m7417i(str4, str6, objArr2);
                    if (vH == null) {
                        C4990ab.m7412e("MicroMsg.AAUtil", "checkIfInsertAAMsg, record is null, ignore");
                        C9797h.m17453a(str5, false, 0);
                    }
                    if (vH != null && vH.field_insertmsg && vH.field_localMsgId > 0 && ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15340jf(vH.field_localMsgId).field_msgId <= 0) {
                        C4990ab.m7416i("MicroMsg.AAUtil", "checkIfInsertAAMsg, the oldMsgInfo has deleted, ignore this");
                        C45488b.aod().mo21150a(vH, new String[0]);
                        AppMethodBeat.m2505o(40611);
                    } else if (vH == null || !vH.field_insertmsg || vH.field_localMsgId <= 0) {
                        C4990ab.m7416i("MicroMsg.AAUtil", "checkIfInsertAAMsg, insert new aa msg");
                        C9797h.m17455bf(str, str2);
                        AppMethodBeat.m2505o(40611);
                    } else {
                        C4990ab.m7416i("MicroMsg.AAUtil", "checkIfInsertAAMsg, update aa msg");
                        C9797h.m17459g(vH.field_localMsgId, str);
                    }
                }
            }
            AppMethodBeat.m2505o(40611);
        }
    }

    /* renamed from: w */
    public static synchronized void m17464w(String str, String str2, String str3) {
        synchronized (C9797h.class) {
            AppMethodBeat.m2504i(40612);
            C4990ab.m7417i("MicroMsg.AAUtil", "setAARecordAfterLaunchAA, billNo: %s, chatroom: %s, msgContent==null:%s, oldRecord: %s", str, str2, Boolean.valueOf(C5046bo.isNullOrNil(str3)), C45488b.aod().mo21152vH(str));
            if (C45488b.aod().mo21152vH(str) == null) {
                C9797h.m17453a(str, false, 0);
            }
            C9797h.m17456bg(str3, str2);
            AppMethodBeat.m2505o(40612);
        }
    }

    /* renamed from: c */
    public static synchronized void m17458c(String str, String str2, String str3, String str4, String str5) {
        boolean z = true;
        synchronized (C9797h.class) {
            AppMethodBeat.m2504i(40613);
            C4990ab.m7411d("MicroMsg.AAUtil", "insertPayMsgAfterPaySucc, launcherUsername: %s, billNo: %s, payMsgId: %s", str, str3, str4);
            if (!(C5046bo.isNullOrNil(str) || C5046bo.isNullOrNil(str3) || C5046bo.isNullOrNil(str4))) {
                C31278a vG = C45488b.aoe().mo34041vG(str4);
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
                C4990ab.m7417i(str6, str7, objArr);
                if (vG == null || !vG.field_insertmsg) {
                    String str8 = "weixin://weixinnewaa/opendetail?billno=" + str3 + "&launcherusername=" + str;
                    if (C5046bo.isNullOrNil(str5)) {
                        C4990ab.m7416i("MicroMsg.AAUtil", "empty msgxml, insert local msgcontent");
                        if (str.equals(C1853r.m3846Yz())) {
                            str5 = C4996ah.getContext().getString(C25738R.string.db9, new Object[]{str8});
                        } else {
                            String displayName = ((C34530b) C1720g.m3528K(C34530b.class)).getDisplayName(str, str2);
                            str5 = C4996ah.getContext().getString(C25738R.string.db_, new Object[]{displayName, str8});
                        }
                    } else {
                        C4990ab.m7411d("MicroMsg.AAUtil", "insert msgxml: %s", str5);
                    }
                    C9797h.m17452a(str5, str2, vG, str4);
                }
            }
            AppMethodBeat.m2505o(40613);
        }
    }

    /* renamed from: x */
    public static synchronized void m17465x(String str, String str2, String str3) {
        synchronized (C9797h.class) {
            AppMethodBeat.m2504i(40614);
            try {
                if (!(C5046bo.isNullOrNil(str) || C5046bo.isNullOrNil(str2) || C5046bo.isNullOrNil(str3))) {
                    C4990ab.m7417i("MicroMsg.AAUtil", "checkIfInsertPaySysMsg, chatroom: %s, payMsgId: %s", str2, str3);
                    C31278a vG = C45488b.aoe().mo34041vG(str3);
                    if (vG == null || !vG.field_insertmsg) {
                        C4990ab.m7416i("MicroMsg.AAUtil", "checkIfInsertPaySysMsg, insert new msg");
                        C9797h.m17452a(str, str2, vG, str3);
                        AppMethodBeat.m2505o(40614);
                    } else {
                        C7620bi jf = ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15340jf(vG.field_msgId);
                        C4990ab.m7417i("MicroMsg.AAUtil", "checkIfInsertPaySysMsg, update old one, msgId: %s, dbMsginfo.id: %s", Long.valueOf(vG.field_msgId), Long.valueOf(jf.field_msgId));
                        jf.setContent(str);
                        ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15284a(vG.field_msgId, jf);
                    }
                }
                AppMethodBeat.m2505o(40614);
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.AAUtil", "checkIfInsertPaySysMsg error: %s", e.getMessage());
                AppMethodBeat.m2505o(40614);
            }
        }
        return;
    }

    /* renamed from: a */
    private static synchronized void m17452a(String str, String str2, C31278a c31278a, String str3) {
        synchronized (C9797h.class) {
            AppMethodBeat.m2504i(40615);
            C7620bi c7620bi = new C7620bi();
            c7620bi.mo14781hO(0);
            c7620bi.mo14794ju(str2);
            c7620bi.setStatus(3);
            c7620bi.setContent(str);
            c7620bi.mo14775eJ(C1829bf.m3764q(str2, System.currentTimeMillis() / 1000));
            c7620bi.setType(Downloads.MIN_WAIT_FOR_NETWORK);
            long Z = ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15281Z(c7620bi);
            C4990ab.m7417i("MicroMsg.AAUtil", "insertPaySysMsg, inserted msgId: %s", Long.valueOf(Z));
            if (c31278a == null) {
                c31278a = new C31278a();
            }
            if (Z > 0) {
                c31278a.field_payMsgId = str3;
                c31278a.field_chatroom = str2;
                c31278a.field_insertmsg = true;
                c31278a.field_msgId = Z;
                C45488b.aoe().mo10099a(c31278a);
            }
            AppMethodBeat.m2505o(40615);
        }
    }

    /* renamed from: g */
    public static synchronized void m17459g(long j, String str) {
        synchronized (C9797h.class) {
            AppMethodBeat.m2504i(40616);
            if (j <= 0 || C5046bo.isNullOrNil(str)) {
                C4990ab.m7413e("MicroMsg.AAUtil", "updateAARecordMsgAfterReceive, msgContent is null or msgId invalid, msgId: %s, %s", Long.valueOf(j), Boolean.valueOf(C5046bo.isNullOrNil(str)));
                AppMethodBeat.m2505o(40616);
            } else {
                C8910b me = C8910b.m16064me(str);
                if (me == null || C5046bo.isNullOrNil(me.fih)) {
                    C4990ab.m7413e("MicroMsg.AAUtil", "updateAARecordMsgAfterReceive, parse app msg failed, msgId: %s", Long.valueOf(j));
                    AppMethodBeat.m2505o(40616);
                } else {
                    C4990ab.m7417i("MicroMsg.AAUtil", "updateAARecordMsgAfterReceive, msgId: %s, billNo: %s", Long.valueOf(j), me.fih);
                    C26535c vH = C45488b.aod().mo21152vH(me.fih);
                    if (vH != null) {
                        long j2 = vH.field_localMsgId;
                        C7620bi jf = ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15340jf(j2);
                        if (jf.field_msgId > 0) {
                            jf.setContent(C1829bf.m3762oy(jf.field_content) + ":\n" + str);
                            ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15284a(j2, jf);
                            C4990ab.m7417i("MicroMsg.AAUtil", "updateAARecordMsgAfterReceive, update success, oldMsgId: %s, billNo: %s", Long.valueOf(j2), vH.field_billNo);
                            AppMethodBeat.m2505o(40616);
                        } else {
                            C4990ab.m7413e("MicroMsg.AAUtil", "updateAARecordMsgAfterReceive, cannot find old msg, insert new one, billNo: %s, oldMsgId: %s, newMsgId: %s, needUpdateInfo.msgId: %s", vH.field_billNo, Long.valueOf(vH.field_localMsgId), Long.valueOf(j), Long.valueOf(jf.field_msgId));
                            AppMethodBeat.m2505o(40616);
                        }
                    } else {
                        vH = new C26535c();
                        vH.field_localMsgId = j;
                        vH.field_billNo = me.fih;
                        vH.field_insertmsg = true;
                        C45488b.aod().mo21149a(vH);
                        C4990ab.m7417i("MicroMsg.AAUtil", "updateAARecordMsgAfterReceive, insert new aa record, msgId: %s, billNo: %s", Long.valueOf(j), me.fih);
                        AppMethodBeat.m2505o(40616);
                    }
                }
            }
        }
    }

    /* renamed from: h */
    public static void m17460h(long j, String str) {
        AppMethodBeat.m2504i(40617);
        C4990ab.m7417i("MicroMsg.AAUtil", "do update sys msg, %s, %s", Long.valueOf(j), str);
        C7620bi jf = ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15340jf(j);
        String vD = C9797h.m17461vD(str);
        if (!C5046bo.isNullOrNil(vD)) {
            jf.setContent(vD);
        }
        ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15284a(j, jf);
        AppMethodBeat.m2505o(40617);
    }

    /* renamed from: a */
    public static boolean m17454a(Activity activity, C35967y c35967y) {
        AppMethodBeat.m2504i(40618);
        boolean a;
        if (c35967y.vAF == 1) {
            C4990ab.m7416i("MicroMsg.AAUtil", "need realname verify");
            Bundle bundle = new Bundle();
            bundle.putString("realname_verify_process_jump_activity", ".ui.LaunchAAUI");
            bundle.putString("realname_verify_process_jump_plugin", "aa");
            a = C43795a.m78493a(activity, bundle, null, 0);
            AppMethodBeat.m2505o(40618);
            return a;
        } else if (c35967y.vAF == 2) {
            C4990ab.m7416i("MicroMsg.AAUtil", "need upload credit");
            a = C43795a.m78495a(activity, c35967y.nZa, c35967y.nZd, c35967y.nZb, c35967y.nZc, false, null);
            AppMethodBeat.m2505o(40618);
            return a;
        } else {
            C4990ab.m7416i("MicroMsg.AAUtil", "realnameGuideFlag =  " + c35967y.vAF);
            AppMethodBeat.m2505o(40618);
            return false;
        }
    }

    /* renamed from: vD */
    private static String m17461vD(String str) {
        UnsupportedEncodingException e;
        AppMethodBeat.m2504i(40619);
        Map z = C5049br.m7595z(str, "sysmsg");
        String str2;
        if (z == null) {
            str2 = "";
            AppMethodBeat.m2505o(40619);
            return str2;
        }
        str2 = (String) z.get(".sysmsg.paymsg.appmsgcontent");
        if (C5046bo.isNullOrNil(str2)) {
            C4990ab.m7412e("MicroMsg.AAUtil", "empty appmsgcontent!");
            str2 = "";
            AppMethodBeat.m2505o(40619);
            return str2;
        }
        String str3 = "";
        try {
            str2 = URLDecoder.decode(str2, "UTF-8");
            try {
                C4990ab.m7411d("MicroMsg.AAUtil", "msgContent: %s", str2);
            } catch (UnsupportedEncodingException e2) {
                e = e2;
                C4990ab.m7412e("MicroMsg.AAUtil", e.getMessage());
                AppMethodBeat.m2505o(40619);
                return str2;
            }
        } catch (UnsupportedEncodingException e3) {
            e = e3;
            str2 = str3;
        }
        AppMethodBeat.m2505o(40619);
        return str2;
    }

    /* renamed from: a */
    public static double m17451a(String str, String str2, int i, int i2) {
        double d = 0.0d;
        AppMethodBeat.m2504i(40620);
        try {
            d = new BigDecimal(C5046bo.getDouble(str.trim(), 0.0d) == 0.0d ? AppEventsConstants.EVENT_PARAM_VALUE_NO : str.trim()).divide(new BigDecimal(str2.trim()), i, i2).doubleValue();
            AppMethodBeat.m2505o(40620);
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.AAUtil", e, "", new Object[0]);
            AppMethodBeat.m2505o(40620);
        }
        return d;
    }

    /* renamed from: bh */
    public static long m17457bh(String str, String str2) {
        AppMethodBeat.m2504i(40621);
        try {
            double d = C5046bo.getDouble(str, 0.0d);
            double d2 = C5046bo.getDouble(str2, 0.0d);
            if (d == 0.0d) {
                str = AppEventsConstants.EVENT_PARAM_VALUE_NO;
            }
            BigDecimal bigDecimal = new BigDecimal(str);
            if (d2 == 0.0d) {
                str2 = AppEventsConstants.EVENT_PARAM_VALUE_NO;
            }
            long longValue = bigDecimal.multiply(new BigDecimal(str2)).longValue();
            AppMethodBeat.m2505o(40621);
            return longValue;
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.AAUtil", e, "", new Object[0]);
            AppMethodBeat.m2505o(40621);
            return 0;
        }
    }

    /* renamed from: vE */
    public static List<String> m17462vE(String str) {
        AppMethodBeat.m2504i(40622);
        List<String> oe;
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7416i("MicroMsg.AAUtil", "illegal chatroomName");
            ArrayList arrayList = new ArrayList();
            AppMethodBeat.m2505o(40622);
            return arrayList;
        } else if (C1855t.m3896kH(str)) {
            try {
                oe = ((C6822c) C1720g.m3528K(C6822c.class)).mo15090XV().mo14889oe(str);
                if (oe == null) {
                    oe = new ArrayList();
                }
                AppMethodBeat.m2505o(40622);
                return oe;
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.AAUtil", "getChatroomMemberList error! %s", e.getMessage());
                oe = new ArrayList();
                AppMethodBeat.m2505o(40622);
                return oe;
            }
        } else {
            oe = new ArrayList();
            oe.add(C1853r.m3846Yz());
            oe.add(str);
            AppMethodBeat.m2505o(40622);
            return oe;
        }
    }

    public static String aom() {
        AppMethodBeat.m2504i(40623);
        C1720g.m3537RQ();
        String nullAsNil = C5046bo.nullAsNil((String) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_RECENT_LAUNCH_AA_GROUP_STRING_SYNC, null));
        AppMethodBeat.m2505o(40623);
        return nullAsNil;
    }

    /* renamed from: vF */
    public static void m17463vF(String str) {
        AppMethodBeat.m2504i(40624);
        String aom = C9797h.aom();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(",");
        if (!C5046bo.isNullOrNil(aom)) {
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
        C4990ab.m7411d("MicroMsg.AAUtil", "recent group: %s", stringBuilder.toString());
        C1720g.m3537RQ();
        C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_RECENT_LAUNCH_AA_GROUP_STRING_SYNC, stringBuilder.toString());
        AppMethodBeat.m2505o(40624);
    }
}
