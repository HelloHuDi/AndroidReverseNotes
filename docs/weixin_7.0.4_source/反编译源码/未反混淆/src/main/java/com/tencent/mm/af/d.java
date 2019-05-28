package com.tencent.mm.af;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.j.b;
import com.tencent.mm.plugin.emoji.model.j;
import com.tencent.mm.plugin.luckymoney.model.x;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.util.Map;

public class d extends f {
    public int cRV = 0;
    public EmojiInfo exP;

    public final f Xz() {
        AppMethodBeat.i(16189);
        d dVar = new d();
        AppMethodBeat.o(16189);
        return dVar;
    }

    public final void a(StringBuilder stringBuilder, b bVar, String str, com.tencent.mm.i.d dVar, int i, int i2) {
        AppMethodBeat.i(16190);
        if (bVar.type == 2001) {
            x.a(stringBuilder, this.exP, this.cRV);
        }
        AppMethodBeat.o(16190);
    }

    public final void a(Map<String, String> map, b bVar) {
        AppMethodBeat.i(16191);
        if (bVar.type == 2001) {
            EmojiInfo emojiInfo = new EmojiInfo();
            emojiInfo.field_md5 = bo.nullAsNil((String) map.get(".msg.appmsg.emoji.md5"));
            emojiInfo.field_type = bo.getInt((String) map.get(".msg.appmsg.emoji.type"), 0);
            emojiInfo.field_width = bo.getInt((String) map.get(".msg.appmsg.emoji.width"), 0);
            emojiInfo.field_height = bo.getInt((String) map.get(".msg.appmsg.emoji.height"), 0);
            emojiInfo.field_size = bo.getInt((String) map.get(".msg.appmsg.emoji.len"), 0);
            emojiInfo.field_aeskey = bo.nullAsNil((String) map.get(".msg.appmsg.emoji.aeskey"));
            emojiInfo.field_cdnUrl = bo.nullAsNil((String) map.get(".msg.appmsg.emoji.cdnurl"));
            emojiInfo.field_encrypturl = bo.nullAsNil((String) map.get(".msg.appmsg.emoji.encrypturl"));
            emojiInfo.field_externUrl = bo.nullAsNil((String) map.get(".msg.appmsg.emoji.externurl"));
            emojiInfo.field_externMd5 = bo.nullAsNil((String) map.get(".msg.appmsg.emoji.externmd5"));
            emojiInfo.field_groupId = bo.nullAsNil((String) map.get(".msg.appmsg.emoji.productid"));
            emojiInfo.field_designerID = bo.nullAsNil((String) map.get(".msg.appmsg.emoji.designerid"));
            emojiInfo.field_attachedText = bo.nullAsNil((String) map.get(".msg.appmsg.emoji.attachedtext"));
            emojiInfo.field_temp = 1;
            emojiInfo.field_catalog = EmojiInfo.yau;
            emojiInfo.field_state = EmojiInfo.zZd;
            this.exP = emojiInfo;
            this.cRV = bo.getInt((String) map.get(".msg.appmsg.emoji.localreceivestatus"), 0);
            if (j.getEmojiStorageMgr().xYn.aqi(emojiInfo.field_md5) == null) {
                j.getEmojiStorageMgr().xYn.E(this.exP);
            }
            ab.d("MicroMsg.AppContentLuckyMoneyEmogiPiece", "EmojiInfo: %s", this.exP);
        }
        AppMethodBeat.o(16191);
    }
}
