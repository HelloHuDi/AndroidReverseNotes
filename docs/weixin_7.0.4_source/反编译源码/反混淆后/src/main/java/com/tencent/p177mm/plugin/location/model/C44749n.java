package com.tencent.p177mm.plugin.location.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C42194e;
import com.tencent.p177mm.p183ai.C1201e.C1197a;
import com.tencent.p177mm.p183ai.C1201e.C1198b;
import com.tencent.p177mm.platformtools.C1946aa;
import com.tencent.p177mm.protocal.protobuf.C7254cm;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5049br;
import com.tencent.ttpic.baseutils.IOUtils;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.location.model.n */
public final class C44749n extends C42194e {
    /* renamed from: b */
    public final C1198b mo4453b(C1197a c1197a) {
        AppMethodBeat.m2504i(113379);
        C7254cm c7254cm = c1197a.eAB;
        if (c7254cm == null) {
            C4990ab.m7412e("MicroMsg.TrackMsgExtension", "onPreAddMessage cmdAM is null");
            AppMethodBeat.m2505o(113379);
            return null;
        }
        LinkedList linkedList = new LinkedList();
        String a = C1946aa.m4148a(c7254cm.vEB);
        String a2 = C1946aa.m4148a(c7254cm.vEC);
        String str = ((String) C1720g.m3536RP().mo5239Ry().get(2, null)).equals(a) ? a2 : a;
        String a3 = C1946aa.m4148a(c7254cm.vED);
        C4990ab.m7410d("MicroMsg.TrackMsgExtension", "cmd ".concat(String.valueOf(a3)));
        Map z = C5049br.m7595z(a3, "sysmsg");
        if (z != null) {
            try {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("talk  " + str + IOUtils.LINE_SEPARATOR_WINDOWS);
                stringBuffer.append("from fromUser " + a + IOUtils.LINE_SEPARATOR_WINDOWS);
                stringBuffer.append("from toUser " + a2 + IOUtils.LINE_SEPARATOR_WINDOWS);
                String str2 = (String) z.get(".sysmsg.trackmsg.trackroominfo.trackroompoi.addr");
                double PP = C44749n.m81568PP((String) z.get(".sysmsg.trackmsg.trackroominfo.trackroompoi.latitude"));
                stringBuffer.append("lat " + PP + IOUtils.LINE_SEPARATOR_WINDOWS);
                double PP2 = C44749n.m81568PP((String) z.get(".sysmsg.trackmsg.trackroominfo.trackroompoi.longitude"));
                stringBuffer.append("lng " + PP2 + IOUtils.LINE_SEPARATOR_WINDOWS);
                stringBuffer.append("times " + C5046bo.getInt((String) z.get(".sysmsg.trackmsg.trackroominfo.timestamp"), 0) + IOUtils.LINE_SEPARATOR_WINDOWS);
                int i = 0;
                while (true) {
                    a3 = (String) z.get((".sysmsg.trackmsg.trackroominfo.trackmemberlist.member" + (i == 0 ? "" : Integer.valueOf(i))) + ".username");
                    if (C5046bo.isNullOrNil(a3)) {
                        break;
                    }
                    i++;
                    linkedList.add(a3);
                }
                stringBuffer.append("userNameList size " + linkedList.size() + IOUtils.LINE_SEPARATOR_WINDOWS);
                C4990ab.m7416i("MicroMsg.TrackMsgExtension", "xml : " + stringBuffer.toString());
                String str3 = null;
                String str4 = null;
                if (str.equals(C39287l.bJy().nKN)) {
                    str3 = C44749n.m81569cg(linkedList);
                    if (C5046bo.isNullOrNil(str3)) {
                        str4 = C44749n.m81570ch(linkedList);
                    }
                }
                C39287l.bJz().mo20559a(str, linkedList, PP, PP2, str2, str3, str4);
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.TrackMsgExtension", e, "", new Object[0]);
            }
        }
        AppMethodBeat.m2505o(113379);
        return null;
    }

    /* renamed from: PP */
    private static double m81568PP(String str) {
        AppMethodBeat.m2504i(113380);
        if (str == null) {
            AppMethodBeat.m2505o(113380);
            return 0.0d;
        }
        double d = C5046bo.getDouble(str, 0.0d);
        AppMethodBeat.m2505o(113380);
        return d;
    }

    /* renamed from: cg */
    private static String m81569cg(List<String> list) {
        String str;
        AppMethodBeat.m2504i(113381);
        List<String> bJF = C39287l.bJy().bJF();
        LinkedList linkedList = new LinkedList();
        for (String str2 : list) {
            Object obj;
            for (String equals : bJF) {
                if (equals.equals(str2)) {
                    obj = 1;
                    break;
                }
            }
            obj = null;
            if (obj == null) {
                linkedList.add(str2);
            }
        }
        if (linkedList.isEmpty()) {
            AppMethodBeat.m2505o(113381);
            return null;
        }
        int i = 0;
        while (i < linkedList.size()) {
            str2 = (String) linkedList.get(i);
            if (str2.equals(C1853r.m3846Yz())) {
                i++;
            } else {
                AppMethodBeat.m2505o(113381);
                return str2;
            }
        }
        AppMethodBeat.m2505o(113381);
        return null;
    }

    /* renamed from: ch */
    private static String m81570ch(List<String> list) {
        String str;
        AppMethodBeat.m2504i(113382);
        List<String> bJF = C39287l.bJy().bJF();
        LinkedList linkedList = new LinkedList();
        for (String str2 : bJF) {
            Object obj;
            for (String str3 : list) {
                if (str3.equals(str2)) {
                    obj = 1;
                    break;
                }
            }
            obj = null;
            if (obj == null) {
                linkedList.add(str2);
            }
        }
        if (linkedList.isEmpty()) {
            AppMethodBeat.m2505o(113382);
            return null;
        }
        int i = 0;
        while (i < linkedList.size()) {
            str3 = (String) linkedList.get(i);
            if (str3.equals(C1853r.m3846Yz())) {
                i++;
            } else {
                AppMethodBeat.m2505o(113382);
                return str3;
            }
        }
        AppMethodBeat.m2505o(113382);
        return null;
    }
}
