package com.tencent.p177mm.plugin.backup.p346f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.modelvideo.C26493s;
import com.tencent.p177mm.modelvideo.C37963q;
import com.tencent.p177mm.modelvideo.C9720t;
import com.tencent.p177mm.plugin.backup.p1394h.C38658d;
import com.tencent.p177mm.plugin.backup.p1394h.C45748c;
import com.tencent.p177mm.plugin.backup.p342b.C38635g;
import com.tencent.p177mm.plugin.backup.p346f.C11149i.C11150a;
import com.tencent.p177mm.plugin.backup.p346f.C45745h.C19972a;
import com.tencent.p177mm.plugin.backup.p921i.C19993u;
import com.tencent.p177mm.protocal.protobuf.C40522gu;
import com.tencent.p177mm.protocal.protobuf.bts;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5049br;
import com.tencent.p177mm.storage.C7620bi;
import com.tencent.p177mm.vfs.C5728b;
import com.tencent.p177mm.vfs.C5730e;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import org.xmlpull.v1.XmlPullParserFactory;
import org.xmlpull.v1.XmlSerializer;

/* renamed from: com.tencent.mm.plugin.backup.f.f */
public final class C42769f implements C27487l {
    /* renamed from: a */
    public final int mo35219a(C40522gu c40522gu, boolean z, C7620bi c7620bi, String str, LinkedList<C19993u> linkedList, HashMap<Long, C19972a> hashMap, boolean z2, long j) {
        Object obj;
        int i;
        AppMethodBeat.m2504i(17459);
        C38658d.aUr().aUs().all();
        String uh = C9720t.m17303uh(c7620bi.field_imgPath);
        C26493s Fm = C45748c.m84546Fm(c7620bi.field_imgPath);
        if (Fm == null || Fm.status == 199) {
            obj = 1;
        } else {
            obj = null;
        }
        C5728b c5728b = new C5728b(uh);
        if (obj == null || !c5728b.exists()) {
            i = 0;
        } else {
            i = (int) c5728b.length();
        }
        int i2 = 0;
        C38658d.aUr().aUs().all();
        String ui = C9720t.m17304ui(c7620bi.field_imgPath);
        C5728b c5728b2 = new C5728b(ui);
        if (c5728b2.exists()) {
            i2 = (int) c5728b2.length();
        }
        if (z) {
            i2 += i;
            AppMethodBeat.m2505o(17459);
            return i2;
        }
        int i3 = 0;
        if (i2 != 0) {
            if (c7620bi.getType() == 62) {
                i3 = C11149i.m18856a(new C11150a(ui, c40522gu, (LinkedList) linkedList, 13, z, "_thumb", z2)) + 0;
            } else {
                i3 = C11149i.m18856a(new C11150a(ui, c40522gu, (LinkedList) linkedList, 11, z, "_thumb", z2)) + 0;
            }
        }
        if (obj == null || i == 0) {
            i2 = i3;
        } else if (c7620bi.getType() == 62) {
            i2 = C11149i.m18856a(new C11150a(uh, c40522gu, (LinkedList) linkedList, 12, z, z2, null)) + i3;
        } else {
            i2 = C11149i.m18856a(new C11150a(uh, c40522gu, (LinkedList) linkedList, 10, z, z2, null)) + i3;
        }
        ui = C42769f.m75831a(c40522gu, c7620bi);
        if (ui == null) {
            AppMethodBeat.m2505o(17459);
            return i2;
        }
        c40522gu.vED = new bts().alV(ui);
        i2 += ui.length();
        AppMethodBeat.m2505o(17459);
        return i2;
    }

    /* renamed from: a */
    public final int mo35220a(String str, C40522gu c40522gu, C7620bi c7620bi) {
        AppMethodBeat.m2504i(17460);
        C26493s c26493s = new C26493s();
        c26493s.cIS = c40522gu.vEB.wVI;
        c26493s.createTime = c7620bi.field_createTime;
        c26493s.cKK = c40522gu.ptF;
        String str2 = c40522gu.vED.wVI;
        C4990ab.m7410d("MicroMsg.BackupItemVideo", "parseVideoMsgXML content:".concat(String.valueOf(str2)));
        Map z = C5049br.m7595z(str2, "msg");
        if (z != null) {
            try {
                c26493s.frO = C38635g.m65521bC((String) z.get(".msg.videomsg.$length"), 0);
                c26493s.fXd = C38635g.m65521bC((String) z.get(".msg.videomsg.$playlength"), 0);
                c26493s.fWW = (String) z.get(".msg.videomsg.$fromusername");
                int bC = C38635g.m65521bC((String) z.get(".msg.videomsg.$type"), 0);
                C4990ab.m7410d("MicroMsg.BackupItemVideo", "video msg exportType :".concat(String.valueOf(bC)));
                if (bC == 44) {
                    bC = 1;
                } else {
                    bC = 0;
                }
                c26493s.fXh = bC;
            } catch (Exception e) {
                C4990ab.m7412e("MicroMsg.BackupItemVideo", "parsing voice msg xml failed");
                C4990ab.printErrStackTrace("MicroMsg.BackupItemVideo", e, "", new Object[0]);
            }
        } else {
            C4990ab.m7413e("MicroMsg.BackupItemVideo", "videomsg paseXml failed:%s", c40522gu.vED.wVI);
            c7620bi.setContent(c40522gu.vED.wVI);
        }
        if (C38635g.m65525d(c40522gu, 10) || C38635g.m65525d(c40522gu, 12)) {
            c26493s.status = 199;
        } else {
            c26493s.status = 111;
        }
        String ug = C9720t.m17302ug(c26493s.alt());
        c7620bi.mo14795jv(ug);
        c26493s.fileName = ug;
        if (c7620bi.getType() != 62) {
            c7620bi.setType(43);
        }
        c7620bi.setContent(C37963q.m64228d(c26493s.alt(), c26493s.fXc, false));
        c26493s.fXe = (int) C45748c.m84550l(c7620bi);
        c26493s.fXb = C5046bo.anT();
        c26493s.fXf = 0;
        C4990ab.m7410d("MicroMsg.BackupItemVideo", "Insert fileName[" + c26493s.getFileName() + "] size:" + c26493s.frO + " svrid:" + c26493s.cKK + " timelen:" + c26493s.fXd + " user:" + c26493s.getUser() + " human:" + c26493s.alt());
        C38658d.aUr().aUs().all().mo21059b(c26493s);
        C38658d.aUr().aUs().all();
        str2 = C9720t.m17304ui(ug);
        if (c7620bi.getType() == 62) {
            C38635g.m65519b(c40522gu, 13, str2);
            str2 = C38635g.m65511a(c40522gu, 12);
        } else {
            C38635g.m65519b(c40522gu, 11, str2);
            str2 = C38635g.m65511a(c40522gu, 10);
        }
        if (str2 != null) {
            str2 = C38635g.m65503Fa(str2) + str2;
            C38658d.aUr().aUs().all();
            C5730e.m8644y(str2, C9720t.m17303uh(ug));
        }
        AppMethodBeat.m2505o(17460);
        return 0;
    }

    /* renamed from: a */
    private static String m75831a(C40522gu c40522gu, C7620bi c7620bi) {
        AppMethodBeat.m2504i(17461);
        C26493s Fm = C45748c.m84546Fm(c7620bi.field_imgPath);
        if (Fm == null) {
            AppMethodBeat.m2505o(17461);
            return null;
        }
        int i;
        if (c7620bi.getType() == 62) {
            i = 62;
        } else {
            i = 43;
        }
        c40522gu.jCt = i;
        if (C5046bo.isNullOrNil(c7620bi.field_content)) {
            AppMethodBeat.m2505o(17461);
            return null;
        }
        String alt;
        if (C45748c.m84549kH(c7620bi.field_talker)) {
            alt = Fm.alt();
        } else {
            alt = c40522gu.vEB.wVI;
        }
        StringWriter stringWriter = new StringWriter();
        try {
            XmlSerializer newSerializer = XmlPullParserFactory.newInstance().newSerializer();
            newSerializer.setOutput(stringWriter);
            newSerializer.startTag(null, "msg");
            newSerializer.startTag(null, "videomsg");
            Map z = C5049br.m7595z(Fm.alw(), "msg");
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
            if (!C5046bo.isNullOrNil(alt)) {
                newSerializer.attribute(null, "fromusername", alt);
            }
            newSerializer.attribute(null, "md5", Fm.cMW);
            newSerializer.endTag(null, "videomsg");
            newSerializer.endTag(null, "msg");
            newSerializer.endDocument();
            stringWriter.flush();
            stringWriter.close();
            String stringBuffer = stringWriter.getBuffer().toString();
            C4990ab.m7410d("MicroMsg.BackupItemVideo", "parseContent xml:".concat(String.valueOf(stringBuffer)));
            AppMethodBeat.m2505o(17461);
            return stringBuffer;
        } catch (Exception e) {
            C4990ab.m7412e("MicroMsg.BackupItemVideo", "packetVoice xml error: " + e.toString());
            AppMethodBeat.m2505o(17461);
            return null;
        }
    }
}
