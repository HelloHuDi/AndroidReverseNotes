package com.tencent.mm.plugin.location.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.e.a;
import com.tencent.mm.ai.e.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.e;
import com.tencent.mm.model.r;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.protocal.protobuf.cm;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import com.tencent.ttpic.baseutils.IOUtils;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class n extends e {
    public final b b(a aVar) {
        AppMethodBeat.i(113379);
        cm cmVar = aVar.eAB;
        if (cmVar == null) {
            ab.e("MicroMsg.TrackMsgExtension", "onPreAddMessage cmdAM is null");
            AppMethodBeat.o(113379);
            return null;
        }
        LinkedList linkedList = new LinkedList();
        String a = aa.a(cmVar.vEB);
        String a2 = aa.a(cmVar.vEC);
        String str = ((String) g.RP().Ry().get(2, null)).equals(a) ? a2 : a;
        String a3 = aa.a(cmVar.vED);
        ab.d("MicroMsg.TrackMsgExtension", "cmd ".concat(String.valueOf(a3)));
        Map z = br.z(a3, "sysmsg");
        if (z != null) {
            try {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("talk  " + str + IOUtils.LINE_SEPARATOR_WINDOWS);
                stringBuffer.append("from fromUser " + a + IOUtils.LINE_SEPARATOR_WINDOWS);
                stringBuffer.append("from toUser " + a2 + IOUtils.LINE_SEPARATOR_WINDOWS);
                String str2 = (String) z.get(".sysmsg.trackmsg.trackroominfo.trackroompoi.addr");
                double PP = PP((String) z.get(".sysmsg.trackmsg.trackroominfo.trackroompoi.latitude"));
                stringBuffer.append("lat " + PP + IOUtils.LINE_SEPARATOR_WINDOWS);
                double PP2 = PP((String) z.get(".sysmsg.trackmsg.trackroominfo.trackroompoi.longitude"));
                stringBuffer.append("lng " + PP2 + IOUtils.LINE_SEPARATOR_WINDOWS);
                stringBuffer.append("times " + bo.getInt((String) z.get(".sysmsg.trackmsg.trackroominfo.timestamp"), 0) + IOUtils.LINE_SEPARATOR_WINDOWS);
                int i = 0;
                while (true) {
                    a3 = (String) z.get((".sysmsg.trackmsg.trackroominfo.trackmemberlist.member" + (i == 0 ? "" : Integer.valueOf(i))) + ".username");
                    if (bo.isNullOrNil(a3)) {
                        break;
                    }
                    i++;
                    linkedList.add(a3);
                }
                stringBuffer.append("userNameList size " + linkedList.size() + IOUtils.LINE_SEPARATOR_WINDOWS);
                ab.i("MicroMsg.TrackMsgExtension", "xml : " + stringBuffer.toString());
                String str3 = null;
                String str4 = null;
                if (str.equals(l.bJy().nKN)) {
                    str3 = cg(linkedList);
                    if (bo.isNullOrNil(str3)) {
                        str4 = ch(linkedList);
                    }
                }
                l.bJz().a(str, linkedList, PP, PP2, str2, str3, str4);
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.TrackMsgExtension", e, "", new Object[0]);
            }
        }
        AppMethodBeat.o(113379);
        return null;
    }

    private static double PP(String str) {
        AppMethodBeat.i(113380);
        if (str == null) {
            AppMethodBeat.o(113380);
            return 0.0d;
        }
        double d = bo.getDouble(str, 0.0d);
        AppMethodBeat.o(113380);
        return d;
    }

    private static String cg(List<String> list) {
        String str;
        AppMethodBeat.i(113381);
        List<String> bJF = l.bJy().bJF();
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
            AppMethodBeat.o(113381);
            return null;
        }
        int i = 0;
        while (i < linkedList.size()) {
            str2 = (String) linkedList.get(i);
            if (str2.equals(r.Yz())) {
                i++;
            } else {
                AppMethodBeat.o(113381);
                return str2;
            }
        }
        AppMethodBeat.o(113381);
        return null;
    }

    private static String ch(List<String> list) {
        String str;
        AppMethodBeat.i(113382);
        List<String> bJF = l.bJy().bJF();
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
            AppMethodBeat.o(113382);
            return null;
        }
        int i = 0;
        while (i < linkedList.size()) {
            str3 = (String) linkedList.get(i);
            if (str3.equals(r.Yz())) {
                i++;
            } else {
                AppMethodBeat.o(113382);
                return str3;
            }
        }
        AppMethodBeat.o(113382);
        return null;
    }
}
