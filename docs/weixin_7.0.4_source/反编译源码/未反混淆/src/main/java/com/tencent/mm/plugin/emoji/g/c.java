package com.tencent.mm.plugin.emoji.g;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.emoji.f.k;
import com.tencent.mm.protocal.protobuf.cm;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import java.util.Map;

public final class c implements com.tencent.mm.model.bz.a {

    public class a {
        private String cud;
        int kXf;
        int kXg;
        String thumburl;

        public a(int i, int i2, String str, String str2) {
            this.kXf = i;
            this.kXg = i2;
            this.thumburl = str;
            this.cud = str2;
        }
    }

    public final void a(com.tencent.mm.ai.e.a aVar) {
        AppMethodBeat.i(53160);
        cm cmVar = aVar.eAB;
        if (cmVar.nao == 10002) {
            String a = aa.a(cmVar.vED);
            if (bo.isNullOrNil(a)) {
                ab.w("MicroMsg.emoji.EmojiNewFreeSysCmdMsgListener", "msg content is null");
                AppMethodBeat.o(53160);
                return;
            }
            Map z = br.z(a, "sysmsg");
            if (z != null && z.size() > 0) {
                a = (String) z.get(".sysmsg.$type");
                if (bo.isNullOrNil(a) || !a.equalsIgnoreCase("emotionstore")) {
                    ab.e("MicroMsg.emoji.EmojiNewFreeSysCmdMsgListener", "not emoji message type :".concat(String.valueOf(a)));
                } else {
                    try {
                        int i;
                        int i2;
                        String str = (String) z.get(".sysmsg.emotionstore.productid");
                        a = (String) z.get(".sysmsg.emotionstore.newcount");
                        String str2 = (String) z.get(".sysmsg.emotionstore.freecount");
                        String str3 = (String) z.get(".sysmsg.emotionstore.thumburl");
                        if (bo.isNullOrNil(a)) {
                            i = 0;
                        } else {
                            i = Integer.valueOf(a).intValue();
                        }
                        if (TextUtils.isEmpty(str2)) {
                            i2 = 0;
                        } else {
                            i2 = Integer.valueOf(str2).intValue();
                        }
                        a aVar2 = new a(i, i2, str3, str);
                        if (bo.isNullOrNil(str)) {
                            a(aVar2);
                        } else {
                            ab.i("MicroMsg.emoji.EmojiNewFreeSysCmdMsgListener", "new xml productid is %s. now try to get download flag", str);
                            g.RO().eJo.a(new k(str, aVar2), 0);
                        }
                        a = (String) z.get(".sysmsg.personalemotion.newcount");
                        if (!bo.isNullOrNil(a) && Integer.valueOf(a).intValue() > 0) {
                            g.RP().Ry().set(com.tencent.mm.storage.ac.a.USERINFO_EMOJI_STORE_NEW_ORIGINAL_BOOLEAN, Boolean.TRUE);
                        }
                        a = (String) z.get(".sysmsg.personalemoji.emojicount");
                        if (!bo.isNullOrNil(a) && Integer.valueOf(a).intValue() > 0) {
                            g.RP().Ry().set(com.tencent.mm.storage.ac.a.USERINFO_EMOJI_STORE_NEW_DESIGNER_EMOJI_BOOLEAN, Boolean.TRUE);
                        }
                        AppMethodBeat.o(53160);
                        return;
                    } catch (Exception e) {
                        ab.e("MicroMsg.emoji.EmojiNewFreeSysCmdMsgListener", "onRecieveMsg:%s", bo.l(e));
                        AppMethodBeat.o(53160);
                        return;
                    }
                }
            }
            AppMethodBeat.o(53160);
            return;
        }
        ab.i("MicroMsg.emoji.EmojiNewFreeSysCmdMsgListener", "not new xml type:%d ", Integer.valueOf(cmVar.nao));
        AppMethodBeat.o(53160);
    }

    public static void a(a aVar) {
        AppMethodBeat.i(53161);
        if (aVar == null) {
            ab.w("MicroMsg.emoji.EmojiNewFreeSysCmdMsgListener", "xml is null.");
            AppMethodBeat.o(53161);
            return;
        }
        if (aVar.kXf > 0) {
            g.RP().Ry().set(208899, Boolean.TRUE);
            com.tencent.mm.x.c.PK().x(262147, true);
        }
        if (aVar.kXg > 0) {
            g.RP().Ry().set(208913, Boolean.TRUE);
            com.tencent.mm.x.c.PK().x(262149, true);
        }
        if (bo.isNullOrNil(aVar.thumburl)) {
            g.RP().Ry().set(229633, (Object) "");
            g.RP().Ry().set(229634, (Object) "");
            AppMethodBeat.o(53161);
            return;
        }
        ab.d("MicroMsg.emoji.EmojiNewFreeSysCmdMsgListener", "Thumb URL %s", aVar.thumburl);
        g.RP().Ry().set(229633, aVar.thumburl);
        g.RP().Ry().set(229634, System.currentTimeMillis());
        AppMethodBeat.o(53161);
    }
}
