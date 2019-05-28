package com.tencent.p177mm.plugin.emoji.p727g;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C6673bz.C1837a;
import com.tencent.p177mm.p1099x.C16112c;
import com.tencent.p177mm.p183ai.C1201e.C1197a;
import com.tencent.p177mm.platformtools.C1946aa;
import com.tencent.p177mm.plugin.emoji.p726f.C38881k;
import com.tencent.p177mm.protocal.protobuf.C7254cm;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5049br;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.emoji.g.c */
public final class C33951c implements C1837a {

    /* renamed from: com.tencent.mm.plugin.emoji.g.c$a */
    public class C33950a {
        private String cud;
        int kXf;
        int kXg;
        String thumburl;

        public C33950a(int i, int i2, String str, String str2) {
            this.kXf = i;
            this.kXg = i2;
            this.thumburl = str;
            this.cud = str2;
        }
    }

    /* renamed from: a */
    public final void mo5414a(C1197a c1197a) {
        AppMethodBeat.m2504i(53160);
        C7254cm c7254cm = c1197a.eAB;
        if (c7254cm.nao == 10002) {
            String a = C1946aa.m4148a(c7254cm.vED);
            if (C5046bo.isNullOrNil(a)) {
                C4990ab.m7420w("MicroMsg.emoji.EmojiNewFreeSysCmdMsgListener", "msg content is null");
                AppMethodBeat.m2505o(53160);
                return;
            }
            Map z = C5049br.m7595z(a, "sysmsg");
            if (z != null && z.size() > 0) {
                a = (String) z.get(".sysmsg.$type");
                if (C5046bo.isNullOrNil(a) || !a.equalsIgnoreCase("emotionstore")) {
                    C4990ab.m7412e("MicroMsg.emoji.EmojiNewFreeSysCmdMsgListener", "not emoji message type :".concat(String.valueOf(a)));
                } else {
                    try {
                        int i;
                        int i2;
                        String str = (String) z.get(".sysmsg.emotionstore.productid");
                        a = (String) z.get(".sysmsg.emotionstore.newcount");
                        String str2 = (String) z.get(".sysmsg.emotionstore.freecount");
                        String str3 = (String) z.get(".sysmsg.emotionstore.thumburl");
                        if (C5046bo.isNullOrNil(a)) {
                            i = 0;
                        } else {
                            i = Integer.valueOf(a).intValue();
                        }
                        if (TextUtils.isEmpty(str2)) {
                            i2 = 0;
                        } else {
                            i2 = Integer.valueOf(str2).intValue();
                        }
                        C33950a c33950a = new C33950a(i, i2, str3, str);
                        if (C5046bo.isNullOrNil(str)) {
                            C33951c.m55566a(c33950a);
                        } else {
                            C4990ab.m7417i("MicroMsg.emoji.EmojiNewFreeSysCmdMsgListener", "new xml productid is %s. now try to get download flag", str);
                            C1720g.m3535RO().eJo.mo14541a(new C38881k(str, c33950a), 0);
                        }
                        a = (String) z.get(".sysmsg.personalemotion.newcount");
                        if (!C5046bo.isNullOrNil(a) && Integer.valueOf(a).intValue() > 0) {
                            C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_EMOJI_STORE_NEW_ORIGINAL_BOOLEAN, Boolean.TRUE);
                        }
                        a = (String) z.get(".sysmsg.personalemoji.emojicount");
                        if (!C5046bo.isNullOrNil(a) && Integer.valueOf(a).intValue() > 0) {
                            C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_EMOJI_STORE_NEW_DESIGNER_EMOJI_BOOLEAN, Boolean.TRUE);
                        }
                        AppMethodBeat.m2505o(53160);
                        return;
                    } catch (Exception e) {
                        C4990ab.m7413e("MicroMsg.emoji.EmojiNewFreeSysCmdMsgListener", "onRecieveMsg:%s", C5046bo.m7574l(e));
                        AppMethodBeat.m2505o(53160);
                        return;
                    }
                }
            }
            AppMethodBeat.m2505o(53160);
            return;
        }
        C4990ab.m7417i("MicroMsg.emoji.EmojiNewFreeSysCmdMsgListener", "not new xml type:%d ", Integer.valueOf(c7254cm.nao));
        AppMethodBeat.m2505o(53160);
    }

    /* renamed from: a */
    public static void m55566a(C33950a c33950a) {
        AppMethodBeat.m2504i(53161);
        if (c33950a == null) {
            C4990ab.m7420w("MicroMsg.emoji.EmojiNewFreeSysCmdMsgListener", "xml is null.");
            AppMethodBeat.m2505o(53161);
            return;
        }
        if (c33950a.kXf > 0) {
            C1720g.m3536RP().mo5239Ry().set(208899, Boolean.TRUE);
            C16112c.m24429PK().mo28556x(262147, true);
        }
        if (c33950a.kXg > 0) {
            C1720g.m3536RP().mo5239Ry().set(208913, Boolean.TRUE);
            C16112c.m24429PK().mo28556x(262149, true);
        }
        if (C5046bo.isNullOrNil(c33950a.thumburl)) {
            C1720g.m3536RP().mo5239Ry().set(229633, (Object) "");
            C1720g.m3536RP().mo5239Ry().set(229634, (Object) "");
            AppMethodBeat.m2505o(53161);
            return;
        }
        C4990ab.m7411d("MicroMsg.emoji.EmojiNewFreeSysCmdMsgListener", "Thumb URL %s", c33950a.thumburl);
        C1720g.m3536RP().mo5239Ry().set(229633, c33950a.thumburl);
        C1720g.m3536RP().mo5239Ry().set(229634, System.currentTimeMillis());
        AppMethodBeat.m2505o(53161);
    }
}
