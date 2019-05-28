package com.tencent.p177mm.p181af;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p181af.C8909j.C8910b;
import com.tencent.p177mm.p235i.C9545d;
import com.tencent.p177mm.plugin.emoji.model.C42952j;
import com.tencent.p177mm.plugin.luckymoney.model.C46063x;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.emotion.EmojiInfo;
import java.util.Map;

/* renamed from: com.tencent.mm.af.d */
public class C8908d extends C37435f {
    public int cRV = 0;
    public EmojiInfo exP;

    /* renamed from: Xz */
    public final C37435f mo20330Xz() {
        AppMethodBeat.m2504i(16189);
        C8908d c8908d = new C8908d();
        AppMethodBeat.m2505o(16189);
        return c8908d;
    }

    /* renamed from: a */
    public final void mo20331a(StringBuilder stringBuilder, C8910b c8910b, String str, C9545d c9545d, int i, int i2) {
        AppMethodBeat.m2504i(16190);
        if (c8910b.type == 2001) {
            C46063x.m85807a(stringBuilder, this.exP, this.cRV);
        }
        AppMethodBeat.m2505o(16190);
    }

    /* renamed from: a */
    public final void mo20332a(Map<String, String> map, C8910b c8910b) {
        AppMethodBeat.m2504i(16191);
        if (c8910b.type == 2001) {
            EmojiInfo emojiInfo = new EmojiInfo();
            emojiInfo.field_md5 = C5046bo.nullAsNil((String) map.get(".msg.appmsg.emoji.md5"));
            emojiInfo.field_type = C5046bo.getInt((String) map.get(".msg.appmsg.emoji.type"), 0);
            emojiInfo.field_width = C5046bo.getInt((String) map.get(".msg.appmsg.emoji.width"), 0);
            emojiInfo.field_height = C5046bo.getInt((String) map.get(".msg.appmsg.emoji.height"), 0);
            emojiInfo.field_size = C5046bo.getInt((String) map.get(".msg.appmsg.emoji.len"), 0);
            emojiInfo.field_aeskey = C5046bo.nullAsNil((String) map.get(".msg.appmsg.emoji.aeskey"));
            emojiInfo.field_cdnUrl = C5046bo.nullAsNil((String) map.get(".msg.appmsg.emoji.cdnurl"));
            emojiInfo.field_encrypturl = C5046bo.nullAsNil((String) map.get(".msg.appmsg.emoji.encrypturl"));
            emojiInfo.field_externUrl = C5046bo.nullAsNil((String) map.get(".msg.appmsg.emoji.externurl"));
            emojiInfo.field_externMd5 = C5046bo.nullAsNil((String) map.get(".msg.appmsg.emoji.externmd5"));
            emojiInfo.field_groupId = C5046bo.nullAsNil((String) map.get(".msg.appmsg.emoji.productid"));
            emojiInfo.field_designerID = C5046bo.nullAsNil((String) map.get(".msg.appmsg.emoji.designerid"));
            emojiInfo.field_attachedText = C5046bo.nullAsNil((String) map.get(".msg.appmsg.emoji.attachedtext"));
            emojiInfo.field_temp = 1;
            emojiInfo.field_catalog = EmojiInfo.yau;
            emojiInfo.field_state = EmojiInfo.zZd;
            this.exP = emojiInfo;
            this.cRV = C5046bo.getInt((String) map.get(".msg.appmsg.emoji.localreceivestatus"), 0);
            if (C42952j.getEmojiStorageMgr().xYn.aqi(emojiInfo.field_md5) == null) {
                C42952j.getEmojiStorageMgr().xYn.mo48553E(this.exP);
            }
            C4990ab.m7411d("MicroMsg.AppContentLuckyMoneyEmogiPiece", "EmojiInfo: %s", this.exP);
        }
        AppMethodBeat.m2505o(16191);
    }
}
