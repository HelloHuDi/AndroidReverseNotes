package com.tencent.mm.plugin.emoji.model;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.gb;
import com.tencent.mm.plugin.emoji.b.d;
import com.tencent.mm.plugin.emoji.model.d.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.j;
import java.io.File;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public final class g {
    Set<String> kVv = Collections.synchronizedSet(new HashSet());
    c<gb> kVw = new c<gb>() {
        {
            AppMethodBeat.i(53049);
            this.xxI = gb.class.getName().hashCode();
            AppMethodBeat.o(53049);
        }

        public final /* synthetic */ boolean a(b bVar) {
            AppMethodBeat.i(53050);
            gb gbVar = (gb) bVar;
            EmojiInfo emojiInfo = new EmojiInfo();
            emojiInfo.field_designerID = gbVar.cAm.cAo;
            emojiInfo.field_name = gbVar.cAm.name;
            emojiInfo.field_aeskey = gbVar.cAm.aeskey;
            emojiInfo.field_encrypturl = gbVar.cAm.cAp;
            emojiInfo.field_thumbUrl = gbVar.cAm.thumbUrl;
            emojiInfo.field_md5 = gbVar.cAm.cvZ;
            emojiInfo.field_groupId = gbVar.cAm.cwg;
            EmojiInfo aqi = j.getEmojiStorageMgr().xYn.aqi(emojiInfo.Aq());
            if (gbVar.cAm.cuy == 3) {
                String dve = emojiInfo.dve();
                if (aqi == null || (aqi.field_reserved4 & EmojiInfo.zZi) != EmojiInfo.zZi) {
                    gbVar.cAn.path = dve;
                } else {
                    String w = j.w(new com.tencent.mm.vfs.b(ah.getContext().getCacheDir(), com.tencent.mm.a.g.x(gbVar.cAm.cvZ.getBytes())).dMD());
                    if (e.ct(dve) && !e.ct(w)) {
                        byte[] l = ((d) com.tencent.mm.kernel.g.M(d.class)).getEmojiMgr().l(aqi);
                        e.a(w, l, l.length);
                    }
                    gbVar.cAn.path = w;
                }
                ab.i("MicroMsg.FTS.FTSEmojiLogic", "gen path: %s", gbVar.cAn.path);
            } else if (gbVar.cAm.cuy == 1) {
                ab.i("MicroMsg.FTS.FTSEmojiLogic", "emoji download: %s", emojiInfo.Aq());
                g.this.kVv.add(emojiInfo.Aq());
                j.bkh().s(emojiInfo);
            }
            AppMethodBeat.o(53050);
            return false;
        }
    };
    private a kVx = new a() {
        public final void a(boolean z, EmojiInfo emojiInfo) {
            AppMethodBeat.i(53051);
            if (emojiInfo == null || !z || bo.isNullOrNil(emojiInfo.field_md5) || !g.this.kVv.remove(emojiInfo.Aq())) {
                ab.i("MicroMsg.FTS.FTSEmojiLogic", "somethings error.");
                AppMethodBeat.o(53051);
                return;
            }
            ab.i("MicroMsg.FTS.FTSEmojiLogic", "emojiServiceCallback onDownload %s", emojiInfo.Aq());
            b gbVar = new gb();
            gbVar.cAm.cuy = 2;
            gbVar.cAm.cAo = emojiInfo.field_designerID;
            gbVar.cAm.name = emojiInfo.field_name;
            gbVar.cAm.aeskey = emojiInfo.field_aeskey;
            gbVar.cAm.cAp = emojiInfo.field_encrypturl;
            gbVar.cAm.thumbUrl = emojiInfo.field_thumbUrl;
            gbVar.cAm.cvZ = emojiInfo.field_md5;
            gbVar.cAm.cwg = emojiInfo.field_groupId;
            String dve = emojiInfo.dve();
            EmojiInfo aqi = j.getEmojiStorageMgr().xYn.aqi(emojiInfo.Aq());
            if (aqi == null || (aqi.field_reserved4 & EmojiInfo.zZi) != EmojiInfo.zZi) {
                gbVar.cAn.path = dve;
            } else {
                File externalCacheDir = ah.getContext().getExternalCacheDir();
                if (externalCacheDir == null) {
                    AppMethodBeat.o(53051);
                    return;
                }
                String w = j.w(new com.tencent.mm.vfs.b(externalCacheDir, com.tencent.mm.a.g.x(emojiInfo.Aq().getBytes())).dMD());
                if (e.ct(dve) && !e.ct(w)) {
                    byte[] l = ((d) com.tencent.mm.kernel.g.M(d.class)).getEmojiMgr().l(aqi);
                    e.a(w, l, l.length);
                }
                gbVar.cAn.path = w;
            }
            com.tencent.mm.sdk.b.a.xxA.a(gbVar, Looper.getMainLooper());
            AppMethodBeat.o(53051);
        }
    };

    public g() {
        AppMethodBeat.i(53052);
        this.kVw.dnU();
        AppMethodBeat.o(53052);
    }
}
