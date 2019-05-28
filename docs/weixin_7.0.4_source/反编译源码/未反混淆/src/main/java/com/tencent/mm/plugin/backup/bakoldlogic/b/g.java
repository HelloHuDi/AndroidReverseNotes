package com.tencent.mm.plugin.backup.bakoldlogic.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelvideo.q;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.plugin.backup.bakoldlogic.b.i.a;
import com.tencent.mm.plugin.backup.bakoldlogic.d.b;
import com.tencent.mm.plugin.backup.bakoldlogic.d.d;
import com.tencent.mm.plugin.backup.i.u;
import com.tencent.mm.protocal.protobuf.bts;
import com.tencent.mm.protocal.protobuf.gu;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import com.tencent.mm.storage.bi;
import com.tencent.mm.vfs.e;
import java.io.StringWriter;
import java.util.LinkedList;
import java.util.Map;
import org.xmlpull.v1.XmlPullParserFactory;
import org.xmlpull.v1.XmlSerializer;

public final class g implements j {
    public final int a(gu guVar, bi biVar, LinkedList<u> linkedList) {
        Object obj;
        AppMethodBeat.i(17793);
        b.aUY().aUZ().all();
        String uh = t.uh(biVar.field_imgPath);
        s Fm = d.Fm(biVar.field_imgPath);
        if (Fm == null || Fm.status == 199) {
            obj = 1;
        } else {
            obj = null;
        }
        com.tencent.mm.vfs.b bVar = new com.tencent.mm.vfs.b(uh);
        int i;
        if (obj == null || !bVar.exists()) {
            i = 0;
        } else {
            i = (int) bVar.length();
        }
        int i2 = 0;
        b.aUY().aUZ().all();
        String ui = t.ui(biVar.field_imgPath);
        com.tencent.mm.vfs.b bVar2 = new com.tencent.mm.vfs.b(ui);
        if (bVar2.exists()) {
            i2 = (int) bVar2.length();
        }
        int i3 = 0;
        if (i2 != 0) {
            if (biVar.getType() == 62) {
                i3 = i.a(new a(ui, guVar, linkedList, 13, "_thumb")) + 0;
            } else {
                i3 = i.a(new a(ui, guVar, linkedList, 11, "_thumb")) + 0;
            }
        }
        if (obj == null || i == 0) {
            i2 = i3;
        } else if (biVar.getType() == 62) {
            i2 = i.a(new a(uh, guVar, linkedList, 12, false, null)) + i3;
        } else {
            i2 = i.a(new a(uh, guVar, linkedList, 10, false, null)) + i3;
        }
        ui = a(guVar, biVar);
        if (ui == null) {
            AppMethodBeat.o(17793);
            return i2;
        }
        guVar.vED = new bts().alV(ui);
        i2 += ui.length();
        AppMethodBeat.o(17793);
        return i2;
    }

    public final int a(String str, gu guVar, bi biVar) {
        AppMethodBeat.i(17794);
        s sVar = new s();
        sVar.cIS = guVar.vEB.wVI;
        sVar.createTime = biVar.field_createTime;
        sVar.cKK = guVar.ptF;
        String str2 = guVar.vED.wVI;
        ab.d("MicroMsg.BakOldItemVideo", "parseVideoMsgXML content:".concat(String.valueOf(str2)));
        Map z = br.z(str2, "msg");
        if (z != null) {
            try {
                sVar.frO = com.tencent.mm.plugin.backup.bakoldlogic.a.a.bC((String) z.get(".msg.videomsg.$length"), 0);
                sVar.fXd = com.tencent.mm.plugin.backup.bakoldlogic.a.a.bC((String) z.get(".msg.videomsg.$playlength"), 0);
                sVar.fWW = (String) z.get(".msg.videomsg.$fromusername");
                int bC = com.tencent.mm.plugin.backup.bakoldlogic.a.a.bC((String) z.get(".msg.videomsg.$type"), 0);
                ab.d("MicroMsg.BakOldItemVideo", "video msg exportType :".concat(String.valueOf(bC)));
                if (bC == 44) {
                    bC = 1;
                } else {
                    bC = 0;
                }
                sVar.fXh = bC;
            } catch (Exception e) {
                ab.e("MicroMsg.BakOldItemVideo", "parsing voice msg xml failed");
                ab.printErrStackTrace("MicroMsg.BakOldItemVideo", e, "", new Object[0]);
            }
        } else {
            ab.e("MicroMsg.BakOldItemVideo", "videomsg paseXml failed:%s", guVar.vED.wVI);
            biVar.setContent(guVar.vED.wVI);
        }
        if (com.tencent.mm.plugin.backup.bakoldlogic.a.a.d(guVar, 10) || com.tencent.mm.plugin.backup.bakoldlogic.a.a.d(guVar, 12)) {
            sVar.status = 199;
        } else {
            sVar.status = 111;
        }
        String ug = t.ug(sVar.alt());
        biVar.jv(ug);
        sVar.fileName = ug;
        if (biVar.getType() != 62) {
            biVar.setType(43);
        }
        biVar.setContent(q.d(sVar.alt(), sVar.fXc, false));
        sVar.fXe = (int) d.l(biVar);
        sVar.fXb = bo.anT();
        sVar.fXf = 0;
        ab.d("MicroMsg.BakOldItemVideo", "Insert fileName[" + sVar.getFileName() + "] size:" + sVar.frO + " svrid:" + sVar.cKK + " timelen:" + sVar.fXd + " user:" + sVar.getUser() + " human:" + sVar.alt());
        b.aUY().aUZ().all().b(sVar);
        b.aUY().aUZ().all();
        str2 = t.ui(ug);
        if (biVar.getType() == 62) {
            com.tencent.mm.plugin.backup.bakoldlogic.a.a.b(guVar, 13, str2);
            str2 = com.tencent.mm.plugin.backup.bakoldlogic.a.a.a(guVar, 12);
        } else {
            com.tencent.mm.plugin.backup.bakoldlogic.a.a.b(guVar, 11, str2);
            str2 = com.tencent.mm.plugin.backup.bakoldlogic.a.a.a(guVar, 10);
        }
        if (str2 != null) {
            str2 = com.tencent.mm.plugin.backup.bakoldlogic.a.a.Fp(str2);
            b.aUY().aUZ().all();
            e.y(str2, t.uh(ug));
        }
        AppMethodBeat.o(17794);
        return 0;
    }

    private static String a(gu guVar, bi biVar) {
        AppMethodBeat.i(17795);
        s Fm = d.Fm(biVar.field_imgPath);
        if (Fm == null) {
            AppMethodBeat.o(17795);
            return null;
        }
        int i;
        if (biVar.getType() == 62) {
            i = 62;
        } else {
            i = 43;
        }
        guVar.jCt = i;
        if (bo.isNullOrNil(biVar.field_content)) {
            AppMethodBeat.o(17795);
            return null;
        }
        String alt;
        if (d.kH(biVar.field_talker)) {
            alt = Fm.alt();
        } else {
            alt = guVar.vEB.wVI;
        }
        StringWriter stringWriter = new StringWriter();
        try {
            XmlSerializer newSerializer = XmlPullParserFactory.newInstance().newSerializer();
            newSerializer.setOutput(stringWriter);
            newSerializer.startTag(null, "msg");
            newSerializer.startTag(null, "videomsg");
            Map z = br.z(Fm.alw(), "msg");
            if (z != null) {
                newSerializer.attribute(null, "aeskey", ((String) z.get(".msg.videomsg.$aeskey")));
                newSerializer.attribute(null, "cdnthumbaeskey", ((String) z.get(".msg.videomsg.$cdnthumbaeskey")));
                newSerializer.attribute(null, "cdnvideourl", ((String) z.get(".msg.videomsg.$cdnvideourl")));
                newSerializer.attribute(null, "cdnthumburl", ((String) z.get(".msg.videomsg.$cdnthumburl")));
                newSerializer.attribute(null, "cdnthumblength", ((String) z.get(".msg.videomsg.$cdnthumblength")));
            }
            newSerializer.attribute(null, "playlength", Fm.fXd);
            newSerializer.attribute(null, "length", Fm.frO);
            newSerializer.attribute(null, "type", String.valueOf(i));
            if (!bo.isNullOrNil(alt)) {
                newSerializer.attribute(null, "fromusername", alt);
            }
            newSerializer.attribute(null, "md5", Fm.cMW);
            newSerializer.endTag(null, "videomsg");
            newSerializer.endTag(null, "msg");
            newSerializer.endDocument();
            stringWriter.flush();
            stringWriter.close();
            String stringBuffer = stringWriter.getBuffer().toString();
            ab.d("MicroMsg.BakOldItemVideo", "parseContent xml:".concat(String.valueOf(stringBuffer)));
            AppMethodBeat.o(17795);
            return stringBuffer;
        } catch (Exception e) {
            ab.e("MicroMsg.BakOldItemVideo", "packetVoice xml error: " + e.toString());
            AppMethodBeat.o(17795);
            return null;
        }
    }
}
