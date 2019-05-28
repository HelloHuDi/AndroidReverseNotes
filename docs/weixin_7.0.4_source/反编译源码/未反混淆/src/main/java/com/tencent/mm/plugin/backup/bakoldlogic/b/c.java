package com.tencent.mm.plugin.backup.bakoldlogic.b;

import android.text.TextUtils;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.backup.bakoldlogic.d.b;
import com.tencent.mm.plugin.backup.i.u;
import com.tencent.mm.plugin.emoji.b.d;
import com.tencent.mm.protocal.protobuf.bts;
import com.tencent.mm.protocal.protobuf.gu;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import com.tencent.mm.storage.ap;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.util.LinkedList;
import java.util.Map;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;
import org.xmlpull.v1.XmlSerializer;

public final class c implements j {

    static class a {
        public static String jrk = "<msg>";
        public static String jrl = "</msg>";

        public static String Fg(String str) {
            AppMethodBeat.i(17781);
            com.tencent.mm.plugin.backup.bakoldlogic.b.a.a Fq = a.Fq(str);
            if (Fq == null) {
                AppMethodBeat.o(17781);
                return null;
            }
            String str2 = Fq.jvN;
            AppMethodBeat.o(17781);
            return str2;
        }

        public static String a(bi biVar, gu guVar) {
            AppMethodBeat.i(17782);
            EmojiInfo aqi = b.aUY().aUZ().aUp().aqi(biVar.field_imgPath);
            if (aqi == null) {
                AppMethodBeat.o(17782);
                return null;
            }
            com.tencent.mm.plugin.backup.bakoldlogic.b.a.a Fr = a.Fr(aqi.Aq());
            if (Fr == null) {
                Fr = new com.tencent.mm.plugin.backup.bakoldlogic.b.a.a(aqi.Aq(), aqi.Aq(), aqi.Aq(), aqi.Aq());
            }
            StringWriter stringWriter = new StringWriter();
            String bc;
            try {
                XmlSerializer newSerializer = XmlPullParserFactory.newInstance().newSerializer();
                newSerializer.setOutput(stringWriter);
                newSerializer.startDocument("UTF-8", Boolean.TRUE);
                newSerializer.startTag(null, "msg");
                newSerializer.startTag(null, "emoji");
                newSerializer.attribute(null, "fromusername", guVar.vEB.wVI);
                newSerializer.attribute(null, "tousername", guVar.vEC.wVI);
                newSerializer.attribute(null, "type", aqi.field_type);
                newSerializer.attribute(null, "idbuffer", aqi.duW());
                newSerializer.attribute(null, "md5", Fr.jvO);
                newSerializer.attribute(null, "len", "1024");
                newSerializer.attribute(null, "androidmd5", Fr.jvN);
                newSerializer.attribute(null, "androidlen", "1024");
                newSerializer.attribute(null, "productid", aqi.field_groupId);
                newSerializer.endTag(null, "emoji");
                if (aqi.xy()) {
                    newSerializer.startTag(null, "gameext");
                    Map z = br.z(aqi.getContent(), "gameext");
                    String bc2 = bo.bc((String) z.get(".gameext.$type"), "");
                    bc = bo.bc((String) z.get(".gameext.$content"), "");
                    if (bc2.equals("") || bc.equals("")) {
                        stringWriter.close();
                        bc = "";
                        AppMethodBeat.o(17782);
                        return bc;
                    }
                    newSerializer.attribute(null, "type", String.valueOf(bc2));
                    newSerializer.attribute(null, FirebaseAnalytics.b.CONTENT, String.valueOf(bc));
                    newSerializer.endTag(null, "gameext");
                }
                newSerializer.endTag(null, "msg");
                newSerializer.endDocument();
                stringWriter.flush();
                stringWriter.close();
                bc = stringWriter.getBuffer().toString();
                try {
                    bc = bc.substring(bc.indexOf(jrk), bc.indexOf(jrl) + jrl.length());
                    ab.d("MicroMsg.EmojiConvert", "xml ".concat(String.valueOf(bc)));
                    AppMethodBeat.o(17782);
                    return bc;
                } catch (Exception e) {
                    bc = "";
                    AppMethodBeat.o(17782);
                    return bc;
                }
            } catch (XmlPullParserException e2) {
                ab.printErrStackTrace("MicroMsg.EmojiConvert", e2, "", new Object[0]);
                bc = "";
                AppMethodBeat.o(17782);
                return bc;
            } catch (IllegalArgumentException e3) {
                ab.printErrStackTrace("MicroMsg.EmojiConvert", e3, "", new Object[0]);
                bc = "";
                AppMethodBeat.o(17782);
                return bc;
            } catch (IllegalStateException e4) {
                ab.printErrStackTrace("MicroMsg.EmojiConvert", e4, "", new Object[0]);
                bc = "";
                AppMethodBeat.o(17782);
                return bc;
            } catch (IOException e5) {
                ab.printErrStackTrace("MicroMsg.EmojiConvert", e5, "", new Object[0]);
                bc = "";
                AppMethodBeat.o(17782);
                return bc;
            }
        }
    }

    private static boolean Fd(String str) {
        AppMethodBeat.i(17783);
        int indexOf = str.indexOf(60);
        if (indexOf > 0) {
            str = str.substring(indexOf);
        }
        if (br.z(str, "msg") != null) {
            AppMethodBeat.o(17783);
            return true;
        }
        AppMethodBeat.o(17783);
        return false;
    }

    public final int a(String str, gu guVar, bi biVar) {
        boolean z = true;
        AppMethodBeat.i(17785);
        biVar.setContent(guVar.vED.wVI);
        String str2 = guVar.vEB.wVI;
        String str3 = guVar.vEC.wVI;
        if (!((String) b.aUY().aUZ().Ry().get(2, null)).equals(str2)) {
            str3 = str2;
        }
        str2 = guVar.vED.wVI;
        Map z2 = br.z(str2, "msg");
        as dK = ((d) g.M(d.class)).getEmojiMgr().dK(str2, str3);
        if (dK == null) {
            ab.w("MicroMsg.BakOldItemEmoji", "EmojiMsgInfo is null");
            AppMethodBeat.o(17785);
            return -1;
        }
        EmojiInfo Jd = ((d) g.M(d.class)).getEmojiMgr().Jd(dK.cvZ);
        if (Jd == null) {
            ab.w("MicroMsg.BakOldItemEmoji", "EmojiInfo is null");
            AppMethodBeat.o(17785);
            return -1;
        }
        String Fg;
        if (z2.get(".msg.emoji.$androidmd5") == null) {
            Fg = a.Fg(dK.cvZ);
            if (!bo.isNullOrNil(Fg)) {
                dK.cvZ = Fg;
                ab.d("MicroMsg.BakOldItemEmoji", "convert ip to android md5 %s", Fg);
            }
        }
        Fg = (String) z2.get(".msg.emoji.$productid");
        if (!TextUtils.isEmpty(Fg)) {
            dK.cwg = Fg;
        }
        biVar.setType(47);
        biVar.jv(dK.cvZ);
        str3 = dK.fWW;
        if (Jd.xy() || Jd.isGif()) {
            z = false;
        }
        biVar.setContent(ap.a(str3, 0, z, dK.cvZ, false, ""));
        if (!Jd.duP()) {
            str3 = b.aUY().aUZ().Yb();
            if (TextUtils.isEmpty(Fg)) {
                com.tencent.mm.plugin.backup.bakoldlogic.a.a.b(guVar, 4, str3 + dK.cvZ + "_thumb");
                com.tencent.mm.plugin.backup.bakoldlogic.a.a.b(guVar, 5, str3 + dK.cvZ);
            } else {
                File file = new File(str3 + Fg);
                if (!file.exists()) {
                    file.mkdirs();
                }
                com.tencent.mm.plugin.backup.bakoldlogic.a.a.b(guVar, 4, str3 + Fg + File.separator + dK.cvZ + "_cover");
                com.tencent.mm.plugin.backup.bakoldlogic.a.a.b(guVar, 5, str3 + Fg + File.separator + dK.cvZ);
            }
            EmojiInfo emojiInfo = new EmojiInfo(str3);
            emojiInfo.field_md5 = dK.cvZ;
            emojiInfo.field_svrid = dK.id;
            emojiInfo.field_catalog = EmojiInfo.yau;
            emojiInfo.field_type = dK.xYc;
            emojiInfo.field_size = dK.xYd;
            emojiInfo.field_state = EmojiInfo.zYZ;
            if (!TextUtils.isEmpty(Fg)) {
                emojiInfo.field_groupId = Fg;
            }
            if (!bo.isNullOrNil(dK.xYl)) {
                emojiInfo.field_activityid = dK.xYl;
            }
            b.aUY().aUZ().aUp().a(emojiInfo);
        }
        ab.d("MicroMsg.BakOldItemEmoji", "id ".concat(String.valueOf(com.tencent.mm.plugin.backup.bakoldlogic.d.d.l(biVar))));
        AppMethodBeat.o(17785);
        return 0;
    }

    public final int a(gu guVar, bi biVar, LinkedList<u> linkedList) {
        int i;
        AppMethodBeat.i(17784);
        if (bo.isNullOrNil(biVar.field_content)) {
            i = 0;
        } else {
            i = biVar.field_content.getBytes().length;
        }
        String trim = ap.aps(biVar.field_content).xXL.trim();
        if (!Fd(trim)) {
            trim = biVar.field_content;
            if (!Fd(trim)) {
                trim = a.a(biVar, guVar);
                if (biVar.field_isSend != 1 && com.tencent.mm.plugin.backup.bakoldlogic.d.d.kH(biVar.field_talker)) {
                    trim = biVar.field_talker + " :\n " + trim;
                }
            }
        }
        if (trim == null || !Fd(trim)) {
            ab.d("MicroMsg.BakOldItemEmoji", "emoji error".concat(String.valueOf(trim)));
            AppMethodBeat.o(17784);
            return -1;
        }
        bts bts = new bts();
        bts.alV(bo.bc(trim, ""));
        guVar.vED = bts;
        EmojiInfo aqi = b.aUY().aUZ().aUp().aqi(biVar.field_imgPath);
        if (aqi == null || !aqi.duS()) {
            int a;
            if (aqi != null) {
                String str;
                if (TextUtils.isEmpty(aqi.field_groupId)) {
                    str = b.aUY().aUZ().Yb() + aqi.Aq() + "_thumb";
                    if (e.cs(str) < 0) {
                        ab.e("MicroMsg.BakOldItemEmoji", "thumbPath error");
                        AppMethodBeat.o(17784);
                        return -1;
                    }
                    a = i.a(new com.tencent.mm.plugin.backup.bakoldlogic.b.i.a(str, guVar, linkedList, 4, "_thumb")) + i;
                } else {
                    str = b.aUY().aUZ().Yb() + aqi.field_groupId + File.separator + aqi.Aq() + "_cover";
                    if (e.cs(str) < 0) {
                        ab.e("MicroMsg.BakOldItemEmoji", "thumbPath error");
                        AppMethodBeat.o(17784);
                        return -1;
                    }
                    a = i.a(new com.tencent.mm.plugin.backup.bakoldlogic.b.i.a(str, guVar, linkedList, 4, "_thumb")) + i;
                }
                if (TextUtils.isEmpty(aqi.field_groupId) && aqi.duP()) {
                    a += i.a(new com.tencent.mm.plugin.backup.bakoldlogic.b.i.a(b.aUY().aUZ().Yb() + aqi.Aq(), guVar, linkedList, b.aUY().aUZ().aUp().aqi(ap.aps(aa.a(guVar.vED)).cvZ)));
                } else if (aqi.duR()) {
                    a += i.a(new com.tencent.mm.plugin.backup.bakoldlogic.b.i.a(b.aUY().aUZ().Yb() + aqi.field_groupId + File.separator + aqi.Aq(), guVar, linkedList, b.aUY().aUZ().aUp().aqi(ap.aps(aa.a(guVar.vED)).cvZ)));
                }
            } else {
                a = i;
            }
            AppMethodBeat.o(17784);
            return a;
        }
        AppMethodBeat.o(17784);
        return i;
    }
}
