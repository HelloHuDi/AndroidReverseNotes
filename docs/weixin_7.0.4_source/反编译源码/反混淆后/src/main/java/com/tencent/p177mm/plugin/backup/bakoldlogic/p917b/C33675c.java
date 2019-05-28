package com.tencent.p177mm.plugin.backup.bakoldlogic.p917b;

import android.text.TextUtils;
import com.google.firebase.analytics.FirebaseAnalytics.C8741b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p178a.C1173e;
import com.tencent.p177mm.platformtools.C1946aa;
import com.tencent.p177mm.plugin.backup.bakoldlogic.p1393a.C27452a;
import com.tencent.p177mm.plugin.backup.bakoldlogic.p917b.C11111i.C11112a;
import com.tencent.p177mm.plugin.backup.bakoldlogic.p917b.C36746a.C11105a;
import com.tencent.p177mm.plugin.backup.bakoldlogic.p918d.C11124b;
import com.tencent.p177mm.plugin.backup.bakoldlogic.p918d.C11131d;
import com.tencent.p177mm.plugin.backup.p921i.C19993u;
import com.tencent.p177mm.plugin.emoji.p725b.C6835d;
import com.tencent.p177mm.protocal.protobuf.C40522gu;
import com.tencent.p177mm.protocal.protobuf.bts;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5049br;
import com.tencent.p177mm.storage.C23504as;
import com.tencent.p177mm.storage.C44218ap;
import com.tencent.p177mm.storage.C7620bi;
import com.tencent.p177mm.storage.emotion.EmojiInfo;
import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.util.LinkedList;
import java.util.Map;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;
import org.xmlpull.v1.XmlSerializer;

/* renamed from: com.tencent.mm.plugin.backup.bakoldlogic.b.c */
public final class C33675c implements C45737j {

    /* renamed from: com.tencent.mm.plugin.backup.bakoldlogic.b.c$a */
    static class C33674a {
        public static String jrk = "<msg>";
        public static String jrl = "</msg>";

        /* renamed from: Fg */
        public static String m54980Fg(String str) {
            AppMethodBeat.m2504i(17781);
            C11105a Fq = C36746a.m60965Fq(str);
            if (Fq == null) {
                AppMethodBeat.m2505o(17781);
                return null;
            }
            String str2 = Fq.jvN;
            AppMethodBeat.m2505o(17781);
            return str2;
        }

        /* renamed from: a */
        public static String m54981a(C7620bi c7620bi, C40522gu c40522gu) {
            AppMethodBeat.m2504i(17782);
            EmojiInfo aqi = C11124b.aUY().aUZ().aUp().aqi(c7620bi.field_imgPath);
            if (aqi == null) {
                AppMethodBeat.m2505o(17782);
                return null;
            }
            C11105a Fr = C36746a.m60966Fr(aqi.mo20410Aq());
            if (Fr == null) {
                Fr = new C11105a(aqi.mo20410Aq(), aqi.mo20410Aq(), aqi.mo20410Aq(), aqi.mo20410Aq());
            }
            StringWriter stringWriter = new StringWriter();
            String bc;
            try {
                XmlSerializer newSerializer = XmlPullParserFactory.newInstance().newSerializer();
                newSerializer.setOutput(stringWriter);
                newSerializer.startDocument("UTF-8", Boolean.TRUE);
                newSerializer.startTag(null, "msg");
                newSerializer.startTag(null, "emoji");
                newSerializer.attribute(null, "fromusername", c40522gu.vEB.wVI);
                newSerializer.attribute(null, "tousername", c40522gu.vEC.wVI);
                newSerializer.attribute(null, "type", aqi.field_type);
                newSerializer.attribute(null, "idbuffer", aqi.duW());
                newSerializer.attribute(null, "md5", Fr.jvO);
                newSerializer.attribute(null, "len", "1024");
                newSerializer.attribute(null, "androidmd5", Fr.jvN);
                newSerializer.attribute(null, "androidlen", "1024");
                newSerializer.attribute(null, "productid", aqi.field_groupId);
                newSerializer.endTag(null, "emoji");
                if (aqi.mo48552xy()) {
                    newSerializer.startTag(null, "gameext");
                    Map z = C5049br.m7595z(aqi.getContent(), "gameext");
                    String bc2 = C5046bo.m7532bc((String) z.get(".gameext.$type"), "");
                    bc = C5046bo.m7532bc((String) z.get(".gameext.$content"), "");
                    if (bc2.equals("") || bc.equals("")) {
                        stringWriter.close();
                        bc = "";
                        AppMethodBeat.m2505o(17782);
                        return bc;
                    }
                    newSerializer.attribute(null, "type", String.valueOf(bc2));
                    newSerializer.attribute(null, C8741b.CONTENT, String.valueOf(bc));
                    newSerializer.endTag(null, "gameext");
                }
                newSerializer.endTag(null, "msg");
                newSerializer.endDocument();
                stringWriter.flush();
                stringWriter.close();
                bc = stringWriter.getBuffer().toString();
                try {
                    bc = bc.substring(bc.indexOf(jrk), bc.indexOf(jrl) + jrl.length());
                    C4990ab.m7410d("MicroMsg.EmojiConvert", "xml ".concat(String.valueOf(bc)));
                    AppMethodBeat.m2505o(17782);
                    return bc;
                } catch (Exception e) {
                    bc = "";
                    AppMethodBeat.m2505o(17782);
                    return bc;
                }
            } catch (XmlPullParserException e2) {
                C4990ab.printErrStackTrace("MicroMsg.EmojiConvert", e2, "", new Object[0]);
                bc = "";
                AppMethodBeat.m2505o(17782);
                return bc;
            } catch (IllegalArgumentException e3) {
                C4990ab.printErrStackTrace("MicroMsg.EmojiConvert", e3, "", new Object[0]);
                bc = "";
                AppMethodBeat.m2505o(17782);
                return bc;
            } catch (IllegalStateException e4) {
                C4990ab.printErrStackTrace("MicroMsg.EmojiConvert", e4, "", new Object[0]);
                bc = "";
                AppMethodBeat.m2505o(17782);
                return bc;
            } catch (IOException e5) {
                C4990ab.printErrStackTrace("MicroMsg.EmojiConvert", e5, "", new Object[0]);
                bc = "";
                AppMethodBeat.m2505o(17782);
                return bc;
            }
        }
    }

    /* renamed from: Fd */
    private static boolean m54982Fd(String str) {
        AppMethodBeat.m2504i(17783);
        int indexOf = str.indexOf(60);
        if (indexOf > 0) {
            str = str.substring(indexOf);
        }
        if (C5049br.m7595z(str, "msg") != null) {
            AppMethodBeat.m2505o(17783);
            return true;
        }
        AppMethodBeat.m2505o(17783);
        return false;
    }

    /* renamed from: a */
    public final int mo22812a(String str, C40522gu c40522gu, C7620bi c7620bi) {
        boolean z = true;
        AppMethodBeat.m2504i(17785);
        c7620bi.setContent(c40522gu.vED.wVI);
        String str2 = c40522gu.vEB.wVI;
        String str3 = c40522gu.vEC.wVI;
        if (!((String) C11124b.aUY().aUZ().mo45267Ry().get(2, null)).equals(str2)) {
            str3 = str2;
        }
        str2 = c40522gu.vED.wVI;
        Map z2 = C5049br.m7595z(str2, "msg");
        C23504as dK = ((C6835d) C1720g.m3530M(C6835d.class)).getEmojiMgr().mo35645dK(str2, str3);
        if (dK == null) {
            C4990ab.m7420w("MicroMsg.BakOldItemEmoji", "EmojiMsgInfo is null");
            AppMethodBeat.m2505o(17785);
            return -1;
        }
        EmojiInfo Jd = ((C6835d) C1720g.m3530M(C6835d.class)).getEmojiMgr().mo35596Jd(dK.cvZ);
        if (Jd == null) {
            C4990ab.m7420w("MicroMsg.BakOldItemEmoji", "EmojiInfo is null");
            AppMethodBeat.m2505o(17785);
            return -1;
        }
        String Fg;
        if (z2.get(".msg.emoji.$androidmd5") == null) {
            Fg = C33674a.m54980Fg(dK.cvZ);
            if (!C5046bo.isNullOrNil(Fg)) {
                dK.cvZ = Fg;
                C4990ab.m7411d("MicroMsg.BakOldItemEmoji", "convert ip to android md5 %s", Fg);
            }
        }
        Fg = (String) z2.get(".msg.emoji.$productid");
        if (!TextUtils.isEmpty(Fg)) {
            dK.cwg = Fg;
        }
        c7620bi.setType(47);
        c7620bi.mo14795jv(dK.cvZ);
        str3 = dK.fWW;
        if (Jd.mo48552xy() || Jd.isGif()) {
            z = false;
        }
        c7620bi.setContent(C44218ap.m79810a(str3, 0, z, dK.cvZ, false, ""));
        if (!Jd.duP()) {
            str3 = C11124b.aUY().aUZ().mo45273Yb();
            if (TextUtils.isEmpty(Fg)) {
                C27452a.m43560b(c40522gu, 4, str3 + dK.cvZ + "_thumb");
                C27452a.m43560b(c40522gu, 5, str3 + dK.cvZ);
            } else {
                File file = new File(str3 + Fg);
                if (!file.exists()) {
                    file.mkdirs();
                }
                C27452a.m43560b(c40522gu, 4, str3 + Fg + File.separator + dK.cvZ + "_cover");
                C27452a.m43560b(c40522gu, 5, str3 + Fg + File.separator + dK.cvZ);
            }
            EmojiInfo emojiInfo = new EmojiInfo(str3);
            emojiInfo.field_md5 = dK.cvZ;
            emojiInfo.field_svrid = dK.f4420id;
            emojiInfo.field_catalog = EmojiInfo.yau;
            emojiInfo.field_type = dK.xYc;
            emojiInfo.field_size = dK.xYd;
            emojiInfo.field_state = EmojiInfo.zYZ;
            if (!TextUtils.isEmpty(Fg)) {
                emojiInfo.field_groupId = Fg;
            }
            if (!C5046bo.isNullOrNil(dK.xYl)) {
                emojiInfo.field_activityid = dK.xYl;
            }
            C11124b.aUY().aUZ().aUp().mo10099a(emojiInfo);
        }
        C4990ab.m7410d("MicroMsg.BakOldItemEmoji", "id ".concat(String.valueOf(C11131d.m18845l(c7620bi))));
        AppMethodBeat.m2505o(17785);
        return 0;
    }

    /* renamed from: a */
    public final int mo22811a(C40522gu c40522gu, C7620bi c7620bi, LinkedList<C19993u> linkedList) {
        int i;
        AppMethodBeat.m2504i(17784);
        if (C5046bo.isNullOrNil(c7620bi.field_content)) {
            i = 0;
        } else {
            i = c7620bi.field_content.getBytes().length;
        }
        String trim = C44218ap.aps(c7620bi.field_content).xXL.trim();
        if (!C33675c.m54982Fd(trim)) {
            trim = c7620bi.field_content;
            if (!C33675c.m54982Fd(trim)) {
                trim = C33674a.m54981a(c7620bi, c40522gu);
                if (c7620bi.field_isSend != 1 && C11131d.m18844kH(c7620bi.field_talker)) {
                    trim = c7620bi.field_talker + " :\n " + trim;
                }
            }
        }
        if (trim == null || !C33675c.m54982Fd(trim)) {
            C4990ab.m7410d("MicroMsg.BakOldItemEmoji", "emoji error".concat(String.valueOf(trim)));
            AppMethodBeat.m2505o(17784);
            return -1;
        }
        bts bts = new bts();
        bts.alV(C5046bo.m7532bc(trim, ""));
        c40522gu.vED = bts;
        EmojiInfo aqi = C11124b.aUY().aUZ().aUp().aqi(c7620bi.field_imgPath);
        if (aqi == null || !aqi.duS()) {
            int a;
            if (aqi != null) {
                String str;
                if (TextUtils.isEmpty(aqi.field_groupId)) {
                    str = C11124b.aUY().aUZ().mo45273Yb() + aqi.mo20410Aq() + "_thumb";
                    if (C1173e.m2560cs(str) < 0) {
                        C4990ab.m7412e("MicroMsg.BakOldItemEmoji", "thumbPath error");
                        AppMethodBeat.m2505o(17784);
                        return -1;
                    }
                    a = C11111i.m18825a(new C11112a(str, c40522gu, linkedList, 4, "_thumb")) + i;
                } else {
                    str = C11124b.aUY().aUZ().mo45273Yb() + aqi.field_groupId + File.separator + aqi.mo20410Aq() + "_cover";
                    if (C1173e.m2560cs(str) < 0) {
                        C4990ab.m7412e("MicroMsg.BakOldItemEmoji", "thumbPath error");
                        AppMethodBeat.m2505o(17784);
                        return -1;
                    }
                    a = C11111i.m18825a(new C11112a(str, c40522gu, linkedList, 4, "_thumb")) + i;
                }
                if (TextUtils.isEmpty(aqi.field_groupId) && aqi.duP()) {
                    a += C11111i.m18825a(new C11112a(C11124b.aUY().aUZ().mo45273Yb() + aqi.mo20410Aq(), c40522gu, linkedList, C11124b.aUY().aUZ().aUp().aqi(C44218ap.aps(C1946aa.m4148a(c40522gu.vED)).cvZ)));
                } else if (aqi.duR()) {
                    a += C11111i.m18825a(new C11112a(C11124b.aUY().aUZ().mo45273Yb() + aqi.field_groupId + File.separator + aqi.mo20410Aq(), c40522gu, linkedList, C11124b.aUY().aUZ().aUp().aqi(C44218ap.aps(C1946aa.m4148a(c40522gu.vED)).cvZ)));
                }
            } else {
                a = i;
            }
            AppMethodBeat.m2505o(17784);
            return a;
        }
        AppMethodBeat.m2505o(17784);
        return i;
    }
}
