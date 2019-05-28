package com.tencent.mm.plugin.backup.bakoldlogic.b;

import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelvoice.n;
import com.tencent.mm.modelvoice.u;
import com.tencent.mm.plugin.backup.bakoldlogic.a.a;
import com.tencent.mm.plugin.backup.bakoldlogic.d.d;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.bts;
import com.tencent.mm.protocal.protobuf.gu;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import com.tencent.mm.storage.bi;
import com.tencent.mm.vfs.b;
import com.tencent.mm.vfs.e;
import java.io.StringWriter;
import java.util.LinkedList;
import java.util.Map;
import org.xmlpull.v1.XmlPullParserFactory;
import org.xmlpull.v1.XmlSerializer;

public final class h implements j {
    byte[] jvw = new byte[]{(byte) 35, (byte) 33, (byte) 65, (byte) 77, (byte) 82, (byte) 10, (byte) 2, (byte) 35, (byte) 33};
    byte[] jvx = new byte[]{(byte) 35, (byte) 33, (byte) 65, (byte) 77, (byte) 82, (byte) 10, (byte) 35, (byte) 33};

    public h() {
        AppMethodBeat.i(17796);
        AppMethodBeat.o(17796);
    }

    /* JADX WARNING: Removed duplicated region for block: B:40:0x015a  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x00ac  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int a(String str, gu guVar, bi biVar) {
        byte[] bArr;
        String a;
        AppMethodBeat.i(17798);
        String str2 = guVar.vED.wVI;
        if (d.kH(guVar.vEB.wVI)) {
            int ox = d.ox(str2);
            if (ox != -1 && ox + 2 < str2.length()) {
                str2 = str2.substring(ox + 2);
            }
            ab.v("MicroMsg.BakOldItemVoice", "chatroom voicemsg, new content=".concat(String.valueOf(str2)));
        }
        Map z = br.z(str2, "msg");
        if (z != null) {
            try {
                biVar.setContent(n.d((String) z.get(".msg.voicemsg.$fromusername"), (long) a.bC((String) z.get(".msg.voicemsg.$voicelength"), 0), a.bC((String) z.get(".msg.voicemsg.$isPlayed"), 1) == 1));
            } catch (Exception e) {
                ab.e("MicroMsg.BakOldItemVoice", "parsing voice msg xml failed");
                ab.printErrStackTrace("MicroMsg.BakOldItemVoice", e, "", new Object[0]);
            }
        } else {
            ab.e("MicroMsg.BakOldItemVoice", "voicemsg paseXml failed:%s", guVar.vED.wVI);
            biVar.setContent(guVar.vED.wVI);
        }
        str2 = u.uY(guVar.vEB.wVI);
        biVar.jv(str2);
        d.l(biVar);
        str2 = d.Fn(str2);
        if (guVar.vJf == 9) {
            byte[] bArr2 = guVar.vJd.getBuffer().wR;
            if (g(this.jvw, bArr2)) {
                bArr = new byte[(bArr2.length - 6)];
                System.arraycopy(bArr2, 6, bArr, 0, bArr2.length - 6);
                guVar.vJe = bArr2.length - 6;
                guVar.vJd = new SKBuiltinBuffer_t().setBuffer(bArr);
            } else if (g(this.jvx, bArr2)) {
                bArr = new byte[(bArr2.length - 6)];
                System.arraycopy(bArr2, 6, bArr, 0, bArr2.length - 6);
                guVar.vJe = bArr2.length - 6;
                guVar.vJd = new SKBuiltinBuffer_t().setBuffer(bArr);
            }
            if (str2 != null) {
                AppMethodBeat.o(17798);
            } else if (a.b(guVar, 9, str2)) {
                AppMethodBeat.o(17798);
            } else {
                a = a.a(guVar, 9);
                if (a != null) {
                    a = a.Fp(a);
                    ab.d("MicroMsg.BakOldItemVoice", "recover Frome Sdcard".concat(String.valueOf(a)));
                    e.y(a, str2);
                }
                AppMethodBeat.o(17798);
            }
            return 0;
        }
        a = a.a(guVar, 9);
        if (!bo.isNullOrNil(a)) {
            a = a.Fp(a);
            if (e.ct(a)) {
                bArr = e.e(a, 0, 9);
                if (g(this.jvw, bArr)) {
                    bArr = e.e(a, 6, -1);
                    e.deleteFile(a);
                    e.b(a, bArr, bArr.length);
                } else if (g(this.jvx, bArr)) {
                    bArr = e.e(a, 6, -1);
                    e.deleteFile(a);
                    e.b(a, bArr, bArr.length);
                }
            }
        }
        if (str2 != null) {
        }
        return 0;
    }

    private static boolean g(byte[] bArr, byte[] bArr2) {
        AppMethodBeat.i(17799);
        if (bo.cb(bArr2)) {
            AppMethodBeat.o(17799);
            return false;
        }
        for (int i = 0; i < bArr.length; i++) {
            if (bArr[i] != bArr2[i]) {
                AppMethodBeat.o(17799);
                return false;
            }
        }
        AppMethodBeat.o(17799);
        return true;
    }

    public final int a(gu guVar, bi biVar, LinkedList<com.tencent.mm.plugin.backup.i.u> linkedList) {
        int i = 0;
        AppMethodBeat.i(17797);
        String Fn = d.Fn(biVar.field_imgPath);
        if (bo.isNullOrNil(Fn)) {
            AppMethodBeat.o(17797);
        } else {
            b bVar = new b(Fn);
            if (bVar.exists()) {
                int length = (int) bVar.length();
                int a = i.a(new i.a(Fn, guVar, linkedList, 9, false, null));
                Fn = d(biVar, length);
                if (Fn == null) {
                    AppMethodBeat.o(17797);
                } else {
                    guVar.vED = new bts().alV(Fn);
                    i = a + Fn.length();
                    if (length == 0) {
                        AppMethodBeat.o(17797);
                    } else {
                        AppMethodBeat.o(17797);
                    }
                }
            } else {
                AppMethodBeat.o(17797);
            }
        }
        return i;
    }

    private static String d(bi biVar, int i) {
        String str = null;
        AppMethodBeat.i(17800);
        if (bo.isNullOrNil(biVar.field_content)) {
            AppMethodBeat.o(17800);
        } else {
            n nVar = new n(biVar.field_content);
            StringWriter stringWriter = new StringWriter();
            try {
                XmlSerializer newSerializer = XmlPullParserFactory.newInstance().newSerializer();
                newSerializer.setOutput(stringWriter);
                newSerializer.startTag(null, "msg");
                newSerializer.startTag(null, "voicemsg");
                newSerializer.attribute(null, "length", String.valueOf(i));
                newSerializer.attribute(null, "endflag", "1");
                newSerializer.attribute(null, "cancelflag", AppEventsConstants.EVENT_PARAM_VALUE_NO);
                newSerializer.attribute(null, "voicelength", nVar.time);
                if (!bo.isNullOrNil(nVar.fWW)) {
                    newSerializer.attribute(null, "fromusername", nVar.fWW);
                }
                newSerializer.attribute(null, "isPlayed", nVar.fWX ? "1" : AppEventsConstants.EVENT_PARAM_VALUE_NO);
                newSerializer.endTag(null, "voicemsg");
                newSerializer.endTag(null, "msg");
                newSerializer.endDocument();
                stringWriter.flush();
                stringWriter.close();
                str = stringWriter.getBuffer().toString();
                if (d.kH(biVar.field_talker)) {
                    str = nVar.fWW + ":\n" + str;
                }
                ab.i("MicroMsg.BakOldItemVoice", "parseContent xml:".concat(String.valueOf(str)));
                AppMethodBeat.o(17800);
            } catch (Exception e) {
                ab.e("MicroMsg.BakOldItemVoice", "packetVoice xml error: " + e.toString());
                AppMethodBeat.o(17800);
            }
        }
        return str;
    }
}
