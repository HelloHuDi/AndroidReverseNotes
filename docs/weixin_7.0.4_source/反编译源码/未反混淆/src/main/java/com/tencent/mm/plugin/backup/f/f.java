package com.tencent.mm.plugin.backup.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelvideo.q;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.plugin.backup.b.g;
import com.tencent.mm.plugin.backup.f.h.a;
import com.tencent.mm.plugin.backup.h.c;
import com.tencent.mm.plugin.backup.h.d;
import com.tencent.mm.plugin.backup.i.u;
import com.tencent.mm.protocal.protobuf.bts;
import com.tencent.mm.protocal.protobuf.gu;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import com.tencent.mm.storage.bi;
import com.tencent.mm.vfs.b;
import com.tencent.mm.vfs.e;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import org.xmlpull.v1.XmlPullParserFactory;
import org.xmlpull.v1.XmlSerializer;

public final class f implements l {
    public final int a(gu guVar, boolean z, bi biVar, String str, LinkedList<u> linkedList, HashMap<Long, a> hashMap, boolean z2, long j) {
        Object obj;
        int i;
        AppMethodBeat.i(17459);
        d.aUr().aUs().all();
        String uh = t.uh(biVar.field_imgPath);
        s Fm = c.Fm(biVar.field_imgPath);
        if (Fm == null || Fm.status == 199) {
            obj = 1;
        } else {
            obj = null;
        }
        b bVar = new b(uh);
        if (obj == null || !bVar.exists()) {
            i = 0;
        } else {
            i = (int) bVar.length();
        }
        int i2 = 0;
        d.aUr().aUs().all();
        String ui = t.ui(biVar.field_imgPath);
        b bVar2 = new b(ui);
        if (bVar2.exists()) {
            i2 = (int) bVar2.length();
        }
        if (z) {
            i2 += i;
            AppMethodBeat.o(17459);
            return i2;
        }
        int i3 = 0;
        if (i2 != 0) {
            if (biVar.getType() == 62) {
                i3 = i.a(new i.a(ui, guVar, (LinkedList) linkedList, 13, z, "_thumb", z2)) + 0;
            } else {
                i3 = i.a(new i.a(ui, guVar, (LinkedList) linkedList, 11, z, "_thumb", z2)) + 0;
            }
        }
        if (obj == null || i == 0) {
            i2 = i3;
        } else if (biVar.getType() == 62) {
            i2 = i.a(new i.a(uh, guVar, (LinkedList) linkedList, 12, z, z2, null)) + i3;
        } else {
            i2 = i.a(new i.a(uh, guVar, (LinkedList) linkedList, 10, z, z2, null)) + i3;
        }
        ui = a(guVar, biVar);
        if (ui == null) {
            AppMethodBeat.o(17459);
            return i2;
        }
        guVar.vED = new bts().alV(ui);
        i2 += ui.length();
        AppMethodBeat.o(17459);
        return i2;
    }

    public final int a(String str, gu guVar, bi biVar) {
        AppMethodBeat.i(17460);
        s sVar = new s();
        sVar.cIS = guVar.vEB.wVI;
        sVar.createTime = biVar.field_createTime;
        sVar.cKK = guVar.ptF;
        String str2 = guVar.vED.wVI;
        ab.d("MicroMsg.BackupItemVideo", "parseVideoMsgXML content:".concat(String.valueOf(str2)));
        Map z = br.z(str2, "msg");
        if (z != null) {
            try {
                sVar.frO = g.bC((String) z.get(".msg.videomsg.$length"), 0);
                sVar.fXd = g.bC((String) z.get(".msg.videomsg.$playlength"), 0);
                sVar.fWW = (String) z.get(".msg.videomsg.$fromusername");
                int bC = g.bC((String) z.get(".msg.videomsg.$type"), 0);
                ab.d("MicroMsg.BackupItemVideo", "video msg exportType :".concat(String.valueOf(bC)));
                if (bC == 44) {
                    bC = 1;
                } else {
                    bC = 0;
                }
                sVar.fXh = bC;
            } catch (Exception e) {
                ab.e("MicroMsg.BackupItemVideo", "parsing voice msg xml failed");
                ab.printErrStackTrace("MicroMsg.BackupItemVideo", e, "", new Object[0]);
            }
        } else {
            ab.e("MicroMsg.BackupItemVideo", "videomsg paseXml failed:%s", guVar.vED.wVI);
            biVar.setContent(guVar.vED.wVI);
        }
        if (g.d(guVar, 10) || g.d(guVar, 12)) {
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
        sVar.fXe = (int) c.l(biVar);
        sVar.fXb = bo.anT();
        sVar.fXf = 0;
        ab.d("MicroMsg.BackupItemVideo", "Insert fileName[" + sVar.getFileName() + "] size:" + sVar.frO + " svrid:" + sVar.cKK + " timelen:" + sVar.fXd + " user:" + sVar.getUser() + " human:" + sVar.alt());
        d.aUr().aUs().all().b(sVar);
        d.aUr().aUs().all();
        str2 = t.ui(ug);
        if (biVar.getType() == 62) {
            g.b(guVar, 13, str2);
            str2 = g.a(guVar, 12);
        } else {
            g.b(guVar, 11, str2);
            str2 = g.a(guVar, 10);
        }
        if (str2 != null) {
            str2 = g.Fa(str2) + str2;
            d.aUr().aUs().all();
            e.y(str2, t.uh(ug));
        }
        AppMethodBeat.o(17460);
        return 0;
    }

    private static String a(gu guVar, bi biVar) {
        AppMethodBeat.i(17461);
        s Fm = c.Fm(biVar.field_imgPath);
        if (Fm == null) {
            AppMethodBeat.o(17461);
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
            AppMethodBeat.o(17461);
            return null;
        }
        String alt;
        if (c.kH(biVar.field_talker)) {
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
            ab.d("MicroMsg.BackupItemVideo", "parseContent xml:".concat(String.valueOf(stringBuffer)));
            AppMethodBeat.o(17461);
            return stringBuffer;
        } catch (Exception e) {
            ab.e("MicroMsg.BackupItemVideo", "packetVoice xml error: " + e.toString());
            AppMethodBeat.o(17461);
            return null;
        }
    }
}
