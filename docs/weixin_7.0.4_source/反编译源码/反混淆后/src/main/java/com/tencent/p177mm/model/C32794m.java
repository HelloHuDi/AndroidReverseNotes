package com.tencent.p177mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.openim.p1211c.p1212a.C18735c;
import com.tencent.p177mm.openim.p1211c.p1212a.C42242b;
import com.tencent.p177mm.openim.room.p266a.C42249a;
import com.tencent.p177mm.p183ai.C1201e.C1197a;
import com.tencent.p177mm.p183ai.C1201e.C1198b;
import com.tencent.p177mm.p200ay.C1304a;
import com.tencent.p177mm.p200ay.C1304a.C1302a;
import com.tencent.p177mm.p200ay.C17965c;
import com.tencent.p177mm.p200ay.C25849b;
import com.tencent.p177mm.p200ay.C32322e;
import com.tencent.p177mm.p200ay.C37497f;
import com.tencent.p177mm.p200ay.C6331d;
import com.tencent.p177mm.platformtools.C1946aa;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C3472n;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7616ad;
import com.tencent.p177mm.storage.C7617ak;
import com.tencent.p177mm.storage.C7620bi;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* renamed from: com.tencent.mm.model.m */
public final class C32794m {

    /* renamed from: com.tencent.mm.model.m$1 */
    public static class C66751 extends C1302a {
        /* renamed from: a */
        public final C1304a mo4612a(Map<String, String> map, C7620bi c7620bi) {
            AppMethodBeat.m2504i(5501);
            C32322e c32322e = new C32322e(map, c7620bi);
            AppMethodBeat.m2505o(5501);
            return c32322e;
        }
    }

    /* renamed from: com.tencent.mm.model.m$2 */
    public static class C96712 extends C1302a {
        /* renamed from: a */
        public final C1304a mo4612a(Map<String, String> map, C7620bi c7620bi) {
            AppMethodBeat.m2504i(5502);
            C6331d c6331d = new C6331d(map, c7620bi);
            AppMethodBeat.m2505o(5502);
            return c6331d;
        }
    }

    /* renamed from: com.tencent.mm.model.m$3 */
    public static class C96723 extends C1302a {
        /* renamed from: a */
        public final C1304a mo4612a(Map<String, String> map, C7620bi c7620bi) {
            AppMethodBeat.m2504i(5503);
            C25849b c25849b = new C25849b(map, c7620bi);
            AppMethodBeat.m2505o(5503);
            return c25849b;
        }
    }

    /* renamed from: com.tencent.mm.model.m$4 */
    public static class C96734 extends C1302a {
        /* renamed from: a */
        public final C1304a mo4612a(Map<String, String> map, C7620bi c7620bi) {
            AppMethodBeat.m2504i(5504);
            C17965c c17965c = new C17965c(map, c7620bi);
            AppMethodBeat.m2505o(5504);
            return c17965c;
        }
    }

    /* renamed from: com.tencent.mm.model.m$6 */
    public static class C327956 extends C1302a {
        /* renamed from: a */
        public final C1304a mo4612a(Map<String, String> map, C7620bi c7620bi) {
            AppMethodBeat.m2504i(5506);
            C18735c c18735c = new C18735c(map, c7620bi);
            AppMethodBeat.m2505o(5506);
            return c18735c;
        }
    }

    /* renamed from: com.tencent.mm.model.m$5 */
    public static class C327965 extends C1302a {
        /* renamed from: a */
        public final C1304a mo4612a(Map<String, String> map, C7620bi c7620bi) {
            AppMethodBeat.m2504i(5505);
            C42242b c42242b = new C42242b(map, c7620bi);
            AppMethodBeat.m2505o(5505);
            return c42242b;
        }
    }

    /* renamed from: com.tencent.mm.model.m$7 */
    public static class C327977 implements C3472n {
        /* renamed from: a */
        public final C1198b mo7932a(String str, Map<String, String> map, C1197a c1197a) {
            AppMethodBeat.m2504i(5507);
            C37497f c37497f = new C37497f();
            if (map == null) {
                try {
                    C4990ab.m7412e("MicroMsg.DisableChatroomAccessVerifyNewXmlMsg", "[parseXml] values == null ");
                } catch (Exception e) {
                    C4990ab.printErrStackTrace("MicroMsg.DisableChatroomAccessVerifyNewXmlMsg", e, "", new Object[0]);
                }
            } else {
                String a = C1946aa.m4148a(c1197a.eAB.vEB);
                C4990ab.m7417i("MicroMsg.DisableChatroomAccessVerifyNewXmlMsg", "[parseXml] type:%s, values size:%s", C5046bo.nullAsNil(c37497f.TYPE), Integer.valueOf(map.size()));
                c37497f.fLm = (String) map.get(".sysmsg.confirm_username");
                c37497f.fLn = C5046bo.getLong((String) map.get(".sysmsg.newmsgid"), 0);
                C4990ab.m7417i("MicroMsg.DisableChatroomAccessVerifyNewXmlMsg", "[parseXml] mConfirmUsername:%s, mDisableMsgId:%s username:%s", c37497f.fLm, Long.valueOf(c37497f.fLn), a);
                if (C5046bo.isNullOrNil(a)) {
                    C4990ab.m7412e("MicroMsg.DisableChatroomAccessVerifyNewXmlMsg", "[handle] username is null!");
                } else {
                    C7620bi Q = ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15241Q(a, c37497f.fLn);
                    if (Q.field_msgId > 0 && !C5046bo.isNullOrNil(Q.field_talker)) {
                        Q.dtQ();
                        ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15302b(Q.field_msgSvrId, Q);
                    }
                }
            }
            AppMethodBeat.m2505o(5507);
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x00bf  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00d5  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: S */
    public static List<Boolean> m53571S(List<String> list) {
        AppMethodBeat.m2504i(5508);
        if (list == null) {
            AppMethodBeat.m2505o(5508);
            return null;
        }
        ArrayList arrayList = new ArrayList(list.size());
        for (String str : list) {
            boolean z;
            if (C1855t.m3896kH(str)) {
                boolean z2;
                boolean z3 = false;
                long j = 0;
                C7617ak aoZ = ((C6982j) C1720g.m3528K(C6982j.class)).mo15371XR().aoZ(str);
                if (aoZ != null) {
                    if (aoZ.field_lastSeq != 0 && ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15246R(str, aoZ.field_lastSeq).field_msgId == 0) {
                        j = aoZ.field_lastSeq;
                        z3 = true;
                    }
                    if (aoZ.field_firstUnDeliverSeq != 0) {
                        aoZ.mo14745eG(0);
                        aoZ.mo14744eF(0);
                        ((C6982j) C1720g.m3528K(C6982j.class)).mo15371XR().mo15767a(aoZ, str);
                        C4990ab.m7416i("MicroMsg.ChatroomLogic", "summerbadcr deleteConv chatroomId update conv");
                    }
                }
                long j2 = j;
                if (!z3) {
                    C7620bi Rv = ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15268Rv(str);
                    if (!(Rv == null || Rv.field_msgId == 0)) {
                        z2 = true;
                        if (j2 == 0) {
                            j2 = ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15267Ru(str);
                        }
                        if (j2 != 0) {
                            ((C6982j) C1720g.m3528K(C6982j.class)).mo15373Yo().mo7905N(str, j2);
                        }
                        C4990ab.m7417i("MicroMsg.ChatroomLogic", "summerbadcr deleteConv chatroomId[%s], needClear[%b], lastMsgSeq[%d]", str, Boolean.valueOf(z2), Long.valueOf(j2));
                        z = z2;
                    }
                }
                z2 = z3;
                if (j2 == 0) {
                }
                if (j2 != 0) {
                }
                C4990ab.m7417i("MicroMsg.ChatroomLogic", "summerbadcr deleteConv chatroomId[%s], needClear[%b], lastMsgSeq[%d]", str, Boolean.valueOf(z2), Long.valueOf(j2));
                z = z2;
            } else {
                z = false;
            }
            arrayList.add(Boolean.valueOf(z));
        }
        AppMethodBeat.m2505o(5508);
        return arrayList;
    }

    /* renamed from: a */
    public static void m53572a(String str, List<String> list, String str2, boolean z, String str3) {
        AppMethodBeat.m2504i(5509);
        C32794m.m53573a(str, list, str2, z, str3, 2);
        AppMethodBeat.m2505o(5509);
    }

    /* renamed from: a */
    public static void m53573a(String str, List<String> list, String str2, boolean z, String str3, int i) {
        AppMethodBeat.m2504i(5510);
        C7620bi c7620bi = new C7620bi();
        c7620bi.mo14794ju(str);
        c7620bi.setType(Downloads.MIN_WAIT_FOR_NETWORK);
        c7620bi.mo14775eJ(System.currentTimeMillis());
        c7620bi.setStatus(4);
        c7620bi.mo14781hO(i);
        StringBuffer stringBuffer = new StringBuffer();
        if (list != null) {
            String Yz = C1853r.m3846Yz();
            String string = C4996ah.getContext().getString(C25738R.string.ajw);
            for (String str4 : list) {
                if (!str4.equals(Yz)) {
                    C7616ad aoO = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(str4);
                    if (aoO == null || ((int) aoO.ewQ) == 0) {
                        if (z) {
                            stringBuffer.append("<a href=\"" + str3 + str4 + "\">" + str4 + "</a>" + string);
                        } else {
                            stringBuffer.append(str4 + string);
                        }
                    } else if (z) {
                        stringBuffer.append("<a href=\"" + str3 + str4 + "\">" + C32794m.m53574d(aoO) + "</a>" + string);
                    } else {
                        stringBuffer.append(C32794m.m53574d(aoO) + string);
                    }
                }
            }
            if (stringBuffer.length() > 0) {
                stringBuffer.deleteCharAt(stringBuffer.lastIndexOf(string));
            }
        }
        c7620bi.setContent(str2.replace("%s", stringBuffer));
        ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15281Z(c7620bi);
        AppMethodBeat.m2505o(5510);
    }

    /* renamed from: d */
    private static String m53574d(C7616ad c7616ad) {
        AppMethodBeat.m2504i(5511);
        String A;
        if (C42249a.m74600z(c7616ad)) {
            A = C42249a.m74595A(c7616ad);
            if (A != null) {
                A = c7616ad.mo16707Oj() + A;
                AppMethodBeat.m2505o(5511);
                return A;
            }
            A = c7616ad.mo16707Oj();
            AppMethodBeat.m2505o(5511);
            return A;
        }
        A = c7616ad.mo16707Oj();
        AppMethodBeat.m2505o(5511);
        return A;
    }

    /* renamed from: mo */
    public static boolean m53575mo(String str) {
        AppMethodBeat.m2504i(5512);
        if (C1855t.m3900mM(str) || C7616ad.aox(str)) {
            AppMethodBeat.m2505o(5512);
            return true;
        }
        AppMethodBeat.m2505o(5512);
        return false;
    }
}
