package com.tencent.p177mm.p612ui.chatting;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1829bf;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.opensdk.modelmsg.WXEmojiObject;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.p612ui.base.C23639t;
import com.tencent.p177mm.plugin.emoji.p725b.C6835d;
import com.tencent.p177mm.pluginsdk.model.app.C4733l;
import com.tencent.p177mm.pluginsdk.p1336a.C44795d;
import com.tencent.p177mm.pluginsdk.p597ui.chat.C23297j;
import com.tencent.p177mm.sdk.platformtools.BackwardSupportUtil.C4977b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C44218ap;
import com.tencent.p177mm.storage.C7616ad;
import com.tencent.p177mm.storage.C7620bi;
import com.tencent.p177mm.storage.emotion.EmojiInfo;
import com.tencent.p177mm.vfs.C5730e;
import java.io.Closeable;
import java.io.InputStream;

/* renamed from: com.tencent.mm.ui.chatting.v */
public final class C30576v implements C23297j {
    private Context context;
    private C7616ad ehM;
    private String yJf;
    private boolean yLd = true;
    private boolean yLe = true;

    public C30576v(Context context, C7616ad c7616ad, String str) {
        AppMethodBeat.m2504i(30811);
        this.context = context;
        this.ehM = c7616ad;
        this.yJf = str;
        if (C7616ad.m13548mR(this.yJf)) {
            this.yLe = false;
        }
        if (C7616ad.aow(this.yJf)) {
            this.yLd = false;
        }
        if (C7616ad.aou(this.yJf)) {
            this.yLd = false;
        }
        String str2 = (this.ehM == null || !C7616ad.m13548mR(this.ehM.field_username)) ? this.ehM == null ? null : this.ehM.field_username : this.yJf;
        if (C1855t.m3907mT(str2)) {
            this.yLe = false;
        }
        AppMethodBeat.m2505o(30811);
    }

    /* renamed from: A */
    public final void mo39016A(EmojiInfo emojiInfo) {
        AppMethodBeat.m2504i(30812);
        C9638aw.m17190ZK();
        if (!C18628c.isSDCardAvailable()) {
            C23639t.m36492hO(this.context);
            AppMethodBeat.m2505o(30812);
        } else if (emojiInfo == null) {
            AppMethodBeat.m2505o(30812);
        } else {
            int i;
            if (this.ehM.field_username.equals("medianote") && (C1853r.m3822YD() & 16384) == 0) {
                i = 1;
            } else {
                i = 0;
            }
            if (i != 0) {
                emojiInfo.field_start = 0;
                emojiInfo.field_state = EmojiInfo.zZb;
                ((C6835d) C1720g.m3530M(C6835d.class)).getEmojiMgr().updateEmojiInfo(emojiInfo);
                C7620bi c7620bi = new C7620bi();
                c7620bi.setType(47);
                c7620bi.mo14794ju("medianote");
                c7620bi.mo14781hO(1);
                if (emojiInfo.mo48552xy()) {
                    c7620bi.setContent(C44218ap.m79810a(C1853r.m3846Yz(), 0, false, emojiInfo.mo20410Aq(), false, ""));
                }
                c7620bi.mo14795jv(emojiInfo.mo20410Aq());
                c7620bi.mo14775eJ(C1829bf.m3756oC(c7620bi.field_talker));
                c7620bi.setStatus(2);
                C9638aw.m17190ZK();
                C18628c.m29080XO().mo15281Z(c7620bi);
                AppMethodBeat.m2505o(30812);
                return;
            }
            String str;
            C44795d emojiMgr = ((C6835d) C1720g.m3530M(C6835d.class)).getEmojiMgr();
            if (C5046bo.isNullOrNil(this.yJf)) {
                str = this.ehM.field_username;
            } else {
                str = this.yJf;
            }
            emojiMgr.mo35620a(str, emojiInfo, null);
            AppMethodBeat.m2505o(30812);
        }
    }

    /* renamed from: B */
    public final void mo39017B(EmojiInfo emojiInfo) {
        Throwable e;
        Throwable th;
        AppMethodBeat.m2504i(30813);
        C9638aw.m17190ZK();
        if (!C18628c.isSDCardAvailable()) {
            C23639t.m36492hO(this.context);
            AppMethodBeat.m2505o(30813);
        } else if (emojiInfo == null) {
            AppMethodBeat.m2505o(30813);
        } else {
            WXMediaMessage wXMediaMessage = new WXMediaMessage();
            StringBuilder stringBuilder = new StringBuilder();
            C9638aw.m17190ZK();
            String stringBuilder2 = stringBuilder.append(C18628c.m29093Yb()).append(emojiInfo.mo20410Aq()).toString();
            if (C5730e.m8628ct(stringBuilder2 + "_thumb")) {
                wXMediaMessage.thumbData = C5730e.m8632e(stringBuilder2 + "_thumb", 0, (int) C5730e.asZ(stringBuilder2 + "_thumb"));
            } else {
                Closeable openRead;
                try {
                    openRead = C5730e.openRead(stringBuilder2);
                    try {
                        wXMediaMessage.setThumbImage(C4977b.m7372b((InputStream) openRead, 1.0f));
                        C5046bo.m7527b(openRead);
                    } catch (Exception e2) {
                        e = e2;
                        try {
                            C4990ab.printErrStackTrace("MicroMsg.ChattingSmileyPanelImpl", e, "", new Object[0]);
                            C4990ab.m7412e("MicroMsg.ChattingSmileyPanelImpl", "sendAppMsgEmoji Fail cause there is no thumb");
                            C5046bo.m7527b(openRead);
                            wXMediaMessage.mediaObject = new WXEmojiObject(stringBuilder2);
                            C4733l.m7090a(wXMediaMessage, emojiInfo.field_app_id, null, this.yJf, 1, emojiInfo.mo20410Aq());
                            AppMethodBeat.m2505o(30813);
                        } catch (Throwable th2) {
                            th = th2;
                            C5046bo.m7527b(openRead);
                            AppMethodBeat.m2505o(30813);
                            throw th;
                        }
                    }
                } catch (Exception e3) {
                    e = e3;
                    openRead = null;
                    C4990ab.printErrStackTrace("MicroMsg.ChattingSmileyPanelImpl", e, "", new Object[0]);
                    C4990ab.m7412e("MicroMsg.ChattingSmileyPanelImpl", "sendAppMsgEmoji Fail cause there is no thumb");
                    C5046bo.m7527b(openRead);
                    wXMediaMessage.mediaObject = new WXEmojiObject(stringBuilder2);
                    C4733l.m7090a(wXMediaMessage, emojiInfo.field_app_id, null, this.yJf, 1, emojiInfo.mo20410Aq());
                    AppMethodBeat.m2505o(30813);
                } catch (Throwable th3) {
                    th = th3;
                    openRead = null;
                    C5046bo.m7527b(openRead);
                    AppMethodBeat.m2505o(30813);
                    throw th;
                }
            }
            wXMediaMessage.mediaObject = new WXEmojiObject(stringBuilder2);
            C4733l.m7090a(wXMediaMessage, emojiInfo.field_app_id, null, this.yJf, 1, emojiInfo.mo20410Aq());
            AppMethodBeat.m2505o(30813);
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
