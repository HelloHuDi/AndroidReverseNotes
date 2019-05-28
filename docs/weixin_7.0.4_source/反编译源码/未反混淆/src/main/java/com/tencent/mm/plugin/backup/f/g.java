package com.tencent.mm.plugin.backup.f;

import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelvoice.n;
import com.tencent.mm.modelvoice.u;
import com.tencent.mm.plugin.backup.f.h.a;
import com.tencent.mm.plugin.backup.h.c;
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

public final class g implements l {
    byte[] jvw = new byte[]{(byte) 35, (byte) 33, (byte) 65, (byte) 77, (byte) 82, (byte) 10, (byte) 2, (byte) 35, (byte) 33};
    byte[] jvx = new byte[]{(byte) 35, (byte) 33, (byte) 65, (byte) 77, (byte) 82, (byte) 10, (byte) 35, (byte) 33};

    public g() {
        AppMethodBeat.i(17462);
        AppMethodBeat.o(17462);
    }

    public final int a(String str, gu guVar, bi biVar) {
        AppMethodBeat.i(17464);
        String str2 = guVar.vED.wVI;
        if (c.kH(guVar.vEB.wVI)) {
            int ox = c.ox(str2);
            if (ox != -1 && ox + 2 < str2.length()) {
                str2 = str2.substring(ox + 2);
            }
            ab.v("MicroMsg.BackupItemVoice", "recover, voiceContentXml:%s", str2);
        }
        Map z = br.z(str2, "msg");
        if (z != null) {
            try {
                biVar.setContent(n.d((String) z.get(".msg.voicemsg.$fromusername"), (long) com.tencent.mm.plugin.backup.b.g.bC((String) z.get(".msg.voicemsg.$voicelength"), 0), com.tencent.mm.plugin.backup.b.g.bC((String) z.get(".msg.voicemsg.$isPlayed"), 1) == 1));
            } catch (Exception e) {
                ab.e("MicroMsg.BackupItemVoice", "parsing voice msg xml failed");
                ab.printErrStackTrace("MicroMsg.BackupItemVoice", e, "", new Object[0]);
            }
        } else {
            ab.e("MicroMsg.BackupItemVoice", "voicemsg paseXml failed:%s", guVar.vED.wVI);
            biVar.setContent(guVar.vED.wVI);
        }
        str2 = u.uY(guVar.vEB.wVI);
        biVar.jv(str2);
        c.l(biVar);
        str2 = c.Fn(str2);
        String a = com.tencent.mm.plugin.backup.b.g.a(guVar, 9);
        if (!bo.isNullOrNil(a)) {
            a = com.tencent.mm.plugin.backup.b.g.Fa(a) + a;
            if (e.ct(a)) {
                byte[] e2 = e.e(a, 0, 9);
                if (g(this.jvw, e2)) {
                    e2 = e.e(a, 6, -1);
                    e.deleteFile(a);
                    e.b(a, e2, e2.length);
                } else if (g(this.jvx, e2)) {
                    e2 = e.e(a, 6, -1);
                    e.deleteFile(a);
                    e.b(a, e2, e2.length);
                }
            }
        }
        if (str2 == null) {
            AppMethodBeat.o(17464);
        } else if (com.tencent.mm.plugin.backup.b.g.b(guVar, 9, str2)) {
            AppMethodBeat.o(17464);
        } else {
            a = com.tencent.mm.plugin.backup.b.g.a(guVar, 9);
            if (a != null) {
                ab.d("MicroMsg.BackupItemVoice", "recover from path:%s", com.tencent.mm.plugin.backup.b.g.Fa(a) + a);
                e.y(a, str2);
            }
            AppMethodBeat.o(17464);
        }
        return 0;
    }

    private static boolean g(byte[] bArr, byte[] bArr2) {
        AppMethodBeat.i(17465);
        if (bo.cb(bArr2)) {
            AppMethodBeat.o(17465);
            return false;
        }
        for (int i = 0; i < bArr.length; i++) {
            if (bArr[i] != bArr2[i]) {
                AppMethodBeat.o(17465);
                return false;
            }
        }
        AppMethodBeat.o(17465);
        return true;
    }

    public final int a(gu guVar, boolean z, bi biVar, String str, LinkedList<com.tencent.mm.plugin.backup.i.u> linkedList, HashMap<Long, a> hashMap, boolean z2, long j) {
        AppMethodBeat.i(17463);
        String Fn = c.Fn(biVar.field_imgPath);
        if (bo.isNullOrNil(Fn)) {
            AppMethodBeat.o(17463);
            return 0;
        }
        b bVar = new b(Fn);
        if (bVar.exists()) {
            int length = (int) bVar.length();
            if (z) {
                AppMethodBeat.o(17463);
                return length;
            }
            int a = i.a(new i.a(Fn, guVar, (LinkedList) linkedList, 9, z2, z2, null));
            Fn = d(biVar, length);
            if (Fn == null) {
                AppMethodBeat.o(17463);
                return 0;
            }
            guVar.vED = new bts().alV(Fn);
            a += Fn.length();
            if (length == 0) {
                AppMethodBeat.o(17463);
                return a;
            }
            AppMethodBeat.o(17463);
            return a;
        }
        AppMethodBeat.o(17463);
        return 0;
    }

    private static String d(bi biVar, int i) {
        String str = null;
        AppMethodBeat.i(17466);
        if (bo.isNullOrNil(biVar.field_content)) {
            AppMethodBeat.o(17466);
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
                if (c.kH(biVar.field_talker)) {
                    str = nVar.fWW + ":\n" + str;
                }
                ab.i("MicroMsg.BackupItemVoice", "parseContent xml:%s", str);
                AppMethodBeat.o(17466);
            } catch (Exception e) {
                ab.e("MicroMsg.BackupItemVoice", "packetVoice xml error: " + e.toString());
                AppMethodBeat.o(17466);
            }
        }
        return str;
    }
}
