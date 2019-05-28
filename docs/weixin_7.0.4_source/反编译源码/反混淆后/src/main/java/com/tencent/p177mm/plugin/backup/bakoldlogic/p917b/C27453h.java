package com.tencent.p177mm.plugin.backup.bakoldlogic.p917b;

import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.modelvoice.C18719u;
import com.tencent.p177mm.modelvoice.C42230n;
import com.tencent.p177mm.plugin.backup.bakoldlogic.p1393a.C27452a;
import com.tencent.p177mm.plugin.backup.bakoldlogic.p917b.C11111i.C11112a;
import com.tencent.p177mm.plugin.backup.bakoldlogic.p918d.C11131d;
import com.tencent.p177mm.plugin.backup.p921i.C19993u;
import com.tencent.p177mm.protocal.protobuf.C40522gu;
import com.tencent.p177mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.p177mm.protocal.protobuf.bts;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5049br;
import com.tencent.p177mm.storage.C7620bi;
import com.tencent.p177mm.vfs.C5728b;
import com.tencent.p177mm.vfs.C5730e;
import java.io.StringWriter;
import java.util.LinkedList;
import java.util.Map;
import org.xmlpull.v1.XmlPullParserFactory;
import org.xmlpull.v1.XmlSerializer;

/* renamed from: com.tencent.mm.plugin.backup.bakoldlogic.b.h */
public final class C27453h implements C45737j {
    byte[] jvw = new byte[]{(byte) 35, (byte) 33, (byte) 65, (byte) 77, (byte) 82, (byte) 10, (byte) 2, (byte) 35, (byte) 33};
    byte[] jvx = new byte[]{(byte) 35, (byte) 33, (byte) 65, (byte) 77, (byte) 82, (byte) 10, (byte) 35, (byte) 33};

    public C27453h() {
        AppMethodBeat.m2504i(17796);
        AppMethodBeat.m2505o(17796);
    }

    /* JADX WARNING: Removed duplicated region for block: B:40:0x015a  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x00ac  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public final int mo22812a(String str, C40522gu c40522gu, C7620bi c7620bi) {
        byte[] bArr;
        String a;
        AppMethodBeat.m2504i(17798);
        String str2 = c40522gu.vED.wVI;
        if (C11131d.m18844kH(c40522gu.vEB.wVI)) {
            int ox = C11131d.m18846ox(str2);
            if (ox != -1 && ox + 2 < str2.length()) {
                str2 = str2.substring(ox + 2);
            }
            C4990ab.m7418v("MicroMsg.BakOldItemVoice", "chatroom voicemsg, new content=".concat(String.valueOf(str2)));
        }
        Map z = C5049br.m7595z(str2, "msg");
        if (z != null) {
            try {
                c7620bi.setContent(C42230n.m74526d((String) z.get(".msg.voicemsg.$fromusername"), (long) C27452a.m43562bC((String) z.get(".msg.voicemsg.$voicelength"), 0), C27452a.m43562bC((String) z.get(".msg.voicemsg.$isPlayed"), 1) == 1));
            } catch (Exception e) {
                C4990ab.m7412e("MicroMsg.BakOldItemVoice", "parsing voice msg xml failed");
                C4990ab.printErrStackTrace("MicroMsg.BakOldItemVoice", e, "", new Object[0]);
            }
        } else {
            C4990ab.m7413e("MicroMsg.BakOldItemVoice", "voicemsg paseXml failed:%s", c40522gu.vED.wVI);
            c7620bi.setContent(c40522gu.vED.wVI);
        }
        str2 = C18719u.m29275uY(c40522gu.vEB.wVI);
        c7620bi.mo14795jv(str2);
        C11131d.m18845l(c7620bi);
        str2 = C11131d.m18842Fn(str2);
        if (c40522gu.vJf == 9) {
            byte[] bArr2 = c40522gu.vJd.getBuffer().f1226wR;
            if (C27453h.m43566g(this.jvw, bArr2)) {
                bArr = new byte[(bArr2.length - 6)];
                System.arraycopy(bArr2, 6, bArr, 0, bArr2.length - 6);
                c40522gu.vJe = bArr2.length - 6;
                c40522gu.vJd = new SKBuiltinBuffer_t().setBuffer(bArr);
            } else if (C27453h.m43566g(this.jvx, bArr2)) {
                bArr = new byte[(bArr2.length - 6)];
                System.arraycopy(bArr2, 6, bArr, 0, bArr2.length - 6);
                c40522gu.vJe = bArr2.length - 6;
                c40522gu.vJd = new SKBuiltinBuffer_t().setBuffer(bArr);
            }
            if (str2 != null) {
                AppMethodBeat.m2505o(17798);
            } else if (C27452a.m43560b(c40522gu, 9, str2)) {
                AppMethodBeat.m2505o(17798);
            } else {
                a = C27452a.m43557a(c40522gu, 9);
                if (a != null) {
                    a = C27452a.m43555Fp(a);
                    C4990ab.m7410d("MicroMsg.BakOldItemVoice", "recover Frome Sdcard".concat(String.valueOf(a)));
                    C5730e.m8644y(a, str2);
                }
                AppMethodBeat.m2505o(17798);
            }
            return 0;
        }
        a = C27452a.m43557a(c40522gu, 9);
        if (!C5046bo.isNullOrNil(a)) {
            a = C27452a.m43555Fp(a);
            if (C5730e.m8628ct(a)) {
                bArr = C5730e.m8632e(a, 0, 9);
                if (C27453h.m43566g(this.jvw, bArr)) {
                    bArr = C5730e.m8632e(a, 6, -1);
                    C5730e.deleteFile(a);
                    C5730e.m8624b(a, bArr, bArr.length);
                } else if (C27453h.m43566g(this.jvx, bArr)) {
                    bArr = C5730e.m8632e(a, 6, -1);
                    C5730e.deleteFile(a);
                    C5730e.m8624b(a, bArr, bArr.length);
                }
            }
        }
        if (str2 != null) {
        }
        return 0;
    }

    /* renamed from: g */
    private static boolean m43566g(byte[] bArr, byte[] bArr2) {
        AppMethodBeat.m2504i(17799);
        if (C5046bo.m7540cb(bArr2)) {
            AppMethodBeat.m2505o(17799);
            return false;
        }
        for (int i = 0; i < bArr.length; i++) {
            if (bArr[i] != bArr2[i]) {
                AppMethodBeat.m2505o(17799);
                return false;
            }
        }
        AppMethodBeat.m2505o(17799);
        return true;
    }

    /* renamed from: a */
    public final int mo22811a(C40522gu c40522gu, C7620bi c7620bi, LinkedList<C19993u> linkedList) {
        int i = 0;
        AppMethodBeat.m2504i(17797);
        String Fn = C11131d.m18842Fn(c7620bi.field_imgPath);
        if (C5046bo.isNullOrNil(Fn)) {
            AppMethodBeat.m2505o(17797);
        } else {
            C5728b c5728b = new C5728b(Fn);
            if (c5728b.exists()) {
                int length = (int) c5728b.length();
                int a = C11111i.m18825a(new C11112a(Fn, c40522gu, linkedList, 9, false, null));
                Fn = C27453h.m43565d(c7620bi, length);
                if (Fn == null) {
                    AppMethodBeat.m2505o(17797);
                } else {
                    c40522gu.vED = new bts().alV(Fn);
                    i = a + Fn.length();
                    if (length == 0) {
                        AppMethodBeat.m2505o(17797);
                    } else {
                        AppMethodBeat.m2505o(17797);
                    }
                }
            } else {
                AppMethodBeat.m2505o(17797);
            }
        }
        return i;
    }

    /* renamed from: d */
    private static String m43565d(C7620bi c7620bi, int i) {
        String str = null;
        AppMethodBeat.m2504i(17800);
        if (C5046bo.isNullOrNil(c7620bi.field_content)) {
            AppMethodBeat.m2505o(17800);
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
                if (C11131d.m18844kH(c7620bi.field_talker)) {
                    str = c42230n.fWW + ":\n" + str;
                }
                C4990ab.m7416i("MicroMsg.BakOldItemVoice", "parseContent xml:".concat(String.valueOf(str)));
                AppMethodBeat.m2505o(17800);
            } catch (Exception e) {
                C4990ab.m7412e("MicroMsg.BakOldItemVoice", "packetVoice xml error: " + e.toString());
                AppMethodBeat.m2505o(17800);
            }
        }
        return str;
    }
}
