package com.tencent.p177mm.plugin.backup.p346f;

import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.modelvoice.C18719u;
import com.tencent.p177mm.modelvoice.C42230n;
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

/* renamed from: com.tencent.mm.plugin.backup.f.g */
public final class C38654g implements C27487l {
    byte[] jvw = new byte[]{(byte) 35, (byte) 33, (byte) 65, (byte) 77, (byte) 82, (byte) 10, (byte) 2, (byte) 35, (byte) 33};
    byte[] jvx = new byte[]{(byte) 35, (byte) 33, (byte) 65, (byte) 77, (byte) 82, (byte) 10, (byte) 35, (byte) 33};

    public C38654g() {
        AppMethodBeat.m2504i(17462);
        AppMethodBeat.m2505o(17462);
    }

    /* renamed from: a */
    public final int mo35220a(String str, C40522gu c40522gu, C7620bi c7620bi) {
        AppMethodBeat.m2504i(17464);
        String str2 = c40522gu.vED.wVI;
        if (C45748c.m84549kH(c40522gu.vEB.wVI)) {
            int ox = C45748c.m84551ox(str2);
            if (ox != -1 && ox + 2 < str2.length()) {
                str2 = str2.substring(ox + 2);
            }
            C4990ab.m7419v("MicroMsg.BackupItemVoice", "recover, voiceContentXml:%s", str2);
        }
        Map z = C5049br.m7595z(str2, "msg");
        if (z != null) {
            try {
                c7620bi.setContent(C42230n.m74526d((String) z.get(".msg.voicemsg.$fromusername"), (long) C38635g.m65521bC((String) z.get(".msg.voicemsg.$voicelength"), 0), C38635g.m65521bC((String) z.get(".msg.voicemsg.$isPlayed"), 1) == 1));
            } catch (Exception e) {
                C4990ab.m7412e("MicroMsg.BackupItemVoice", "parsing voice msg xml failed");
                C4990ab.printErrStackTrace("MicroMsg.BackupItemVoice", e, "", new Object[0]);
            }
        } else {
            C4990ab.m7413e("MicroMsg.BackupItemVoice", "voicemsg paseXml failed:%s", c40522gu.vED.wVI);
            c7620bi.setContent(c40522gu.vED.wVI);
        }
        str2 = C18719u.m29275uY(c40522gu.vEB.wVI);
        c7620bi.mo14795jv(str2);
        C45748c.m84550l(c7620bi);
        str2 = C45748c.m84547Fn(str2);
        String a = C38635g.m65511a(c40522gu, 9);
        if (!C5046bo.isNullOrNil(a)) {
            a = C38635g.m65503Fa(a) + a;
            if (C5730e.m8628ct(a)) {
                byte[] e2 = C5730e.m8632e(a, 0, 9);
                if (C38654g.m65557g(this.jvw, e2)) {
                    e2 = C5730e.m8632e(a, 6, -1);
                    C5730e.deleteFile(a);
                    C5730e.m8624b(a, e2, e2.length);
                } else if (C38654g.m65557g(this.jvx, e2)) {
                    e2 = C5730e.m8632e(a, 6, -1);
                    C5730e.deleteFile(a);
                    C5730e.m8624b(a, e2, e2.length);
                }
            }
        }
        if (str2 == null) {
            AppMethodBeat.m2505o(17464);
        } else if (C38635g.m65519b(c40522gu, 9, str2)) {
            AppMethodBeat.m2505o(17464);
        } else {
            a = C38635g.m65511a(c40522gu, 9);
            if (a != null) {
                C4990ab.m7411d("MicroMsg.BackupItemVoice", "recover from path:%s", C38635g.m65503Fa(a) + a);
                C5730e.m8644y(a, str2);
            }
            AppMethodBeat.m2505o(17464);
        }
        return 0;
    }

    /* renamed from: g */
    private static boolean m65557g(byte[] bArr, byte[] bArr2) {
        AppMethodBeat.m2504i(17465);
        if (C5046bo.m7540cb(bArr2)) {
            AppMethodBeat.m2505o(17465);
            return false;
        }
        for (int i = 0; i < bArr.length; i++) {
            if (bArr[i] != bArr2[i]) {
                AppMethodBeat.m2505o(17465);
                return false;
            }
        }
        AppMethodBeat.m2505o(17465);
        return true;
    }

    /* renamed from: a */
    public final int mo35219a(C40522gu c40522gu, boolean z, C7620bi c7620bi, String str, LinkedList<C19993u> linkedList, HashMap<Long, C19972a> hashMap, boolean z2, long j) {
        AppMethodBeat.m2504i(17463);
        String Fn = C45748c.m84547Fn(c7620bi.field_imgPath);
        if (C5046bo.isNullOrNil(Fn)) {
            AppMethodBeat.m2505o(17463);
            return 0;
        }
        C5728b c5728b = new C5728b(Fn);
        if (c5728b.exists()) {
            int length = (int) c5728b.length();
            if (z) {
                AppMethodBeat.m2505o(17463);
                return length;
            }
            int a = C11149i.m18856a(new C11150a(Fn, c40522gu, (LinkedList) linkedList, 9, z2, z2, null));
            Fn = C38654g.m65556d(c7620bi, length);
            if (Fn == null) {
                AppMethodBeat.m2505o(17463);
                return 0;
            }
            c40522gu.vED = new bts().alV(Fn);
            a += Fn.length();
            if (length == 0) {
                AppMethodBeat.m2505o(17463);
                return a;
            }
            AppMethodBeat.m2505o(17463);
            return a;
        }
        AppMethodBeat.m2505o(17463);
        return 0;
    }

    /* renamed from: d */
    private static String m65556d(C7620bi c7620bi, int i) {
        String str = null;
        AppMethodBeat.m2504i(17466);
        if (C5046bo.isNullOrNil(c7620bi.field_content)) {
            AppMethodBeat.m2505o(17466);
        } else {
            C42230n c42230n = new C42230n(c7620bi.field_content);
            StringWriter stringWriter = new StringWriter();
            try {
                XmlSerializer newSerializer = XmlPullParserFactory.newInstance().newSerializer();
                newSerializer.setOutput(stringWriter);
                newSerializer.startTag(null, "msg");
                newSerializer.startTag(null, "voicemsg");
                newSerializer.attribute(null, "length", String.valueOf(i));
                newSerializer.attribute(null, "endflag", "1");
                newSerializer.attribute(null, "cancelflag", AppEventsConstants.EVENT_PARAM_VALUE_NO);
                newSerializer.attribute(null, "voicelength", c42230n.time);
                if (!C5046bo.isNullOrNil(c42230n.fWW)) {
                    newSerializer.attribute(null, "fromusername", c42230n.fWW);
                }
                newSerializer.attribute(null, "isPlayed", c42230n.fWX ? "1" : AppEventsConstants.EVENT_PARAM_VALUE_NO);
                newSerializer.endTag(null, "voicemsg");
                newSerializer.endTag(null, "msg");
                newSerializer.endDocument();
                stringWriter.flush();
                stringWriter.close();
                str = stringWriter.getBuffer().toString();
                if (C45748c.m84549kH(c7620bi.field_talker)) {
                    str = c42230n.fWW + ":\n" + str;
                }
                C4990ab.m7417i("MicroMsg.BackupItemVoice", "parseContent xml:%s", str);
                AppMethodBeat.m2505o(17466);
            } catch (Exception e) {
                C4990ab.m7412e("MicroMsg.BackupItemVoice", "packetVoice xml error: " + e.toString());
                AppMethodBeat.m2505o(17466);
            }
        }
        return str;
    }
}
