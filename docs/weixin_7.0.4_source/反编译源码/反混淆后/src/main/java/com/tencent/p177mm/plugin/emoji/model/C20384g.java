package com.tencent.p177mm.plugin.emoji.model;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p178a.C1178g;
import com.tencent.p177mm.p230g.p231a.C26142gb;
import com.tencent.p177mm.plugin.emoji.model.C20378d.C11556a;
import com.tencent.p177mm.plugin.emoji.p725b.C6835d;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.emotion.EmojiInfo;
import com.tencent.p177mm.vfs.C5728b;
import com.tencent.p177mm.vfs.C5730e;
import com.tencent.p177mm.vfs.C5736j;
import java.io.File;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* renamed from: com.tencent.mm.plugin.emoji.model.g */
public final class C20384g {
    Set<String> kVv = Collections.synchronizedSet(new HashSet());
    C4884c<C26142gb> kVw = new C115571();
    private C11556a kVx = new C203852();

    /* renamed from: com.tencent.mm.plugin.emoji.model.g$1 */
    class C115571 extends C4884c<C26142gb> {
        C115571() {
            AppMethodBeat.m2504i(53049);
            this.xxI = C26142gb.class.getName().hashCode();
            AppMethodBeat.m2505o(53049);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(53050);
            C26142gb c26142gb = (C26142gb) c4883b;
            EmojiInfo emojiInfo = new EmojiInfo();
            emojiInfo.field_designerID = c26142gb.cAm.cAo;
            emojiInfo.field_name = c26142gb.cAm.name;
            emojiInfo.field_aeskey = c26142gb.cAm.aeskey;
            emojiInfo.field_encrypturl = c26142gb.cAm.cAp;
            emojiInfo.field_thumbUrl = c26142gb.cAm.thumbUrl;
            emojiInfo.field_md5 = c26142gb.cAm.cvZ;
            emojiInfo.field_groupId = c26142gb.cAm.cwg;
            EmojiInfo aqi = C42952j.getEmojiStorageMgr().xYn.aqi(emojiInfo.mo20410Aq());
            if (c26142gb.cAm.cuy == 3) {
                String dve = emojiInfo.dve();
                if (aqi == null || (aqi.field_reserved4 & EmojiInfo.zZi) != EmojiInfo.zZi) {
                    c26142gb.cAn.path = dve;
                } else {
                    String w = C5736j.m8649w(new C5728b(C4996ah.getContext().getCacheDir(), C1178g.m2591x(c26142gb.cAm.cvZ.getBytes())).dMD());
                    if (C5730e.m8628ct(dve) && !C5730e.m8628ct(w)) {
                        byte[] l = ((C6835d) C1720g.m3530M(C6835d.class)).getEmojiMgr().mo35656l(aqi);
                        C5730e.m8619a(w, l, l.length);
                    }
                    c26142gb.cAn.path = w;
                }
                C4990ab.m7417i("MicroMsg.FTS.FTSEmojiLogic", "gen path: %s", c26142gb.cAn.path);
            } else if (c26142gb.cAm.cuy == 1) {
                C4990ab.m7417i("MicroMsg.FTS.FTSEmojiLogic", "emoji download: %s", emojiInfo.mo20410Aq());
                C20384g.this.kVv.add(emojiInfo.mo20410Aq());
                C42952j.bkh().mo35676s(emojiInfo);
            }
            AppMethodBeat.m2505o(53050);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.emoji.model.g$2 */
    class C203852 implements C11556a {
        C203852() {
        }

        /* renamed from: a */
        public final void mo23264a(boolean z, EmojiInfo emojiInfo) {
            AppMethodBeat.m2504i(53051);
            if (emojiInfo == null || !z || C5046bo.isNullOrNil(emojiInfo.field_md5) || !C20384g.this.kVv.remove(emojiInfo.mo20410Aq())) {
                C4990ab.m7416i("MicroMsg.FTS.FTSEmojiLogic", "somethings error.");
                AppMethodBeat.m2505o(53051);
                return;
            }
            C4990ab.m7417i("MicroMsg.FTS.FTSEmojiLogic", "emojiServiceCallback onDownload %s", emojiInfo.mo20410Aq());
            C4883b c26142gb = new C26142gb();
            c26142gb.cAm.cuy = 2;
            c26142gb.cAm.cAo = emojiInfo.field_designerID;
            c26142gb.cAm.name = emojiInfo.field_name;
            c26142gb.cAm.aeskey = emojiInfo.field_aeskey;
            c26142gb.cAm.cAp = emojiInfo.field_encrypturl;
            c26142gb.cAm.thumbUrl = emojiInfo.field_thumbUrl;
            c26142gb.cAm.cvZ = emojiInfo.field_md5;
            c26142gb.cAm.cwg = emojiInfo.field_groupId;
            String dve = emojiInfo.dve();
            EmojiInfo aqi = C42952j.getEmojiStorageMgr().xYn.aqi(emojiInfo.mo20410Aq());
            if (aqi == null || (aqi.field_reserved4 & EmojiInfo.zZi) != EmojiInfo.zZi) {
                c26142gb.cAn.path = dve;
            } else {
                File externalCacheDir = C4996ah.getContext().getExternalCacheDir();
                if (externalCacheDir == null) {
                    AppMethodBeat.m2505o(53051);
                    return;
                }
                String w = C5736j.m8649w(new C5728b(externalCacheDir, C1178g.m2591x(emojiInfo.mo20410Aq().getBytes())).dMD());
                if (C5730e.m8628ct(dve) && !C5730e.m8628ct(w)) {
                    byte[] l = ((C6835d) C1720g.m3530M(C6835d.class)).getEmojiMgr().mo35656l(aqi);
                    C5730e.m8619a(w, l, l.length);
                }
                c26142gb.cAn.path = w;
            }
            C4879a.xxA.mo10048a(c26142gb, Looper.getMainLooper());
            AppMethodBeat.m2505o(53051);
        }
    }

    public C20384g() {
        AppMethodBeat.m2504i(53052);
        this.kVw.dnU();
        AppMethodBeat.m2505o(53052);
    }
}
