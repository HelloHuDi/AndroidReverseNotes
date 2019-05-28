package com.tencent.mm.ui.chatting;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.c;
import com.tencent.mm.model.r;
import com.tencent.mm.model.t;
import com.tencent.mm.opensdk.modelmsg.WXEmojiObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.emoji.b.d;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.pluginsdk.ui.chat.j;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.ap;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.vfs.e;
import java.io.Closeable;
import java.io.InputStream;

public final class v implements j {
    private Context context;
    private ad ehM;
    private String yJf;
    private boolean yLd = true;
    private boolean yLe = true;

    public v(Context context, ad adVar, String str) {
        AppMethodBeat.i(30811);
        this.context = context;
        this.ehM = adVar;
        this.yJf = str;
        if (ad.mR(this.yJf)) {
            this.yLe = false;
        }
        if (ad.aow(this.yJf)) {
            this.yLd = false;
        }
        if (ad.aou(this.yJf)) {
            this.yLd = false;
        }
        String str2 = (this.ehM == null || !ad.mR(this.ehM.field_username)) ? this.ehM == null ? null : this.ehM.field_username : this.yJf;
        if (t.mT(str2)) {
            this.yLe = false;
        }
        AppMethodBeat.o(30811);
    }

    public final void A(EmojiInfo emojiInfo) {
        AppMethodBeat.i(30812);
        aw.ZK();
        if (!c.isSDCardAvailable()) {
            com.tencent.mm.ui.base.t.hO(this.context);
            AppMethodBeat.o(30812);
        } else if (emojiInfo == null) {
            AppMethodBeat.o(30812);
        } else {
            int i;
            if (this.ehM.field_username.equals("medianote") && (r.YD() & 16384) == 0) {
                i = 1;
            } else {
                i = 0;
            }
            if (i != 0) {
                emojiInfo.field_start = 0;
                emojiInfo.field_state = EmojiInfo.zZb;
                ((d) g.M(d.class)).getEmojiMgr().updateEmojiInfo(emojiInfo);
                bi biVar = new bi();
                biVar.setType(47);
                biVar.ju("medianote");
                biVar.hO(1);
                if (emojiInfo.xy()) {
                    biVar.setContent(ap.a(r.Yz(), 0, false, emojiInfo.Aq(), false, ""));
                }
                biVar.jv(emojiInfo.Aq());
                biVar.eJ(bf.oC(biVar.field_talker));
                biVar.setStatus(2);
                aw.ZK();
                c.XO().Z(biVar);
                AppMethodBeat.o(30812);
                return;
            }
            String str;
            com.tencent.mm.pluginsdk.a.d emojiMgr = ((d) g.M(d.class)).getEmojiMgr();
            if (bo.isNullOrNil(this.yJf)) {
                str = this.ehM.field_username;
            } else {
                str = this.yJf;
            }
            emojiMgr.a(str, emojiInfo, null);
            AppMethodBeat.o(30812);
        }
    }

    public final void B(EmojiInfo emojiInfo) {
        Throwable e;
        Throwable th;
        AppMethodBeat.i(30813);
        aw.ZK();
        if (!c.isSDCardAvailable()) {
            com.tencent.mm.ui.base.t.hO(this.context);
            AppMethodBeat.o(30813);
        } else if (emojiInfo == null) {
            AppMethodBeat.o(30813);
        } else {
            WXMediaMessage wXMediaMessage = new WXMediaMessage();
            StringBuilder stringBuilder = new StringBuilder();
            aw.ZK();
            String stringBuilder2 = stringBuilder.append(c.Yb()).append(emojiInfo.Aq()).toString();
            if (e.ct(stringBuilder2 + "_thumb")) {
                wXMediaMessage.thumbData = e.e(stringBuilder2 + "_thumb", 0, (int) e.asZ(stringBuilder2 + "_thumb"));
            } else {
                Closeable openRead;
                try {
                    openRead = e.openRead(stringBuilder2);
                    try {
                        wXMediaMessage.setThumbImage(b.b((InputStream) openRead, 1.0f));
                        bo.b(openRead);
                    } catch (Exception e2) {
                        e = e2;
                        try {
                            ab.printErrStackTrace("MicroMsg.ChattingSmileyPanelImpl", e, "", new Object[0]);
                            ab.e("MicroMsg.ChattingSmileyPanelImpl", "sendAppMsgEmoji Fail cause there is no thumb");
                            bo.b(openRead);
                            wXMediaMessage.mediaObject = new WXEmojiObject(stringBuilder2);
                            l.a(wXMediaMessage, emojiInfo.field_app_id, null, this.yJf, 1, emojiInfo.Aq());
                            AppMethodBeat.o(30813);
                        } catch (Throwable th2) {
                            th = th2;
                            bo.b(openRead);
                            AppMethodBeat.o(30813);
                            throw th;
                        }
                    }
                } catch (Exception e3) {
                    e = e3;
                    openRead = null;
                    ab.printErrStackTrace("MicroMsg.ChattingSmileyPanelImpl", e, "", new Object[0]);
                    ab.e("MicroMsg.ChattingSmileyPanelImpl", "sendAppMsgEmoji Fail cause there is no thumb");
                    bo.b(openRead);
                    wXMediaMessage.mediaObject = new WXEmojiObject(stringBuilder2);
                    l.a(wXMediaMessage, emojiInfo.field_app_id, null, this.yJf, 1, emojiInfo.Aq());
                    AppMethodBeat.o(30813);
                } catch (Throwable th3) {
                    th = th3;
                    openRead = null;
                    bo.b(openRead);
                    AppMethodBeat.o(30813);
                    throw th;
                }
            }
            wXMediaMessage.mediaObject = new WXEmojiObject(stringBuilder2);
            l.a(wXMediaMessage, emojiInfo.field_app_id, null, this.yJf, 1, emojiInfo.Aq());
            AppMethodBeat.o(30813);
        }
    }

    public final boolean bOe() {
        return this.yLe;
    }

    public final boolean bOf() {
        return this.yLd;
    }

    public final void bOg() {
    }
}
