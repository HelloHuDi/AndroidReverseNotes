package com.tencent.p177mm.plugin.emoji.p947e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p612ui.widget.p633a.C5663e.C5662c;
import com.tencent.p177mm.plugin.emoji.model.C42952j;
import com.tencent.p177mm.plugin.emoji.p726f.C42945g;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5023at;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.emotion.EmojiGroupInfo;
import com.tencent.p177mm.storage.emotion.EmojiInfo;
import java.util.ArrayList;

/* renamed from: com.tencent.mm.plugin.emoji.e.d */
public class C42942d {
    public static C42942d kTE;
    public ArrayList<String> kTF = new ArrayList();
    public boolean kTG = true;
    public boolean kTH = false;

    /* renamed from: com.tencent.mm.plugin.emoji.e.d$2 */
    class C429392 implements Runnable {
        final /* synthetic */ EmojiInfo kTI;

        C429392(EmojiInfo emojiInfo) {
            this.kTI = emojiInfo;
        }

        /* JADX WARNING: Missing block: B:9:0x002c, code skipped:
            if (r2.field_sync > 0) goto L_0x002e;
     */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void run() {
            boolean z = true;
            AppMethodBeat.m2504i(52850);
            if (!(this.kTI == null || this.kTI.duP())) {
                String str = this.kTI.field_groupId;
                if (!C5046bo.isNullOrNil(str)) {
                    EmojiGroupInfo bZ = C42952j.getEmojiStorageMgr().xYo.mo74770bZ(str, true);
                    if (bZ != null) {
                    }
                }
                z = false;
                if (z) {
                    C42942d.m76263a(C42942d.this, this.kTI);
                    AppMethodBeat.m2505o(52850);
                    return;
                }
                C42942d.m76264a(this.kTI, false);
            }
            AppMethodBeat.m2505o(52850);
        }
    }

    /* renamed from: com.tencent.mm.plugin.emoji.e.d$3 */
    class C429403 implements C5662c {
        C429403() {
        }

        /* renamed from: d */
        public final void mo5699d(boolean z, String str) {
            C42942d.this.kTH = false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.emoji.e.d$1 */
    class C429431 implements Runnable {
        final /* synthetic */ EmojiInfo kTI;

        C429431(EmojiInfo emojiInfo) {
            this.kTI = emojiInfo;
        }

        public final void run() {
            AppMethodBeat.m2504i(52849);
            if (!(this.kTI == null || this.kTI.duP())) {
                C4990ab.m7417i("MicroMsg.emoji.EmojiFileCheckerMgr", "chatting emoji broken. try to recover:%s", this.kTI.mo20410Aq());
                C42942d.m76264a(this.kTI, true);
            }
            AppMethodBeat.m2505o(52849);
        }
    }

    public C42942d() {
        AppMethodBeat.m2504i(52852);
        AppMethodBeat.m2505o(52852);
    }

    public static C42942d bjH() {
        AppMethodBeat.m2504i(52853);
        if (kTE == null) {
            synchronized (C42942d.class) {
                try {
                    kTE = new C42942d();
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.m2505o(52853);
                    }
                }
            }
        }
        C42942d c42942d = kTE;
        AppMethodBeat.m2505o(52853);
        return c42942d;
    }

    /* renamed from: a */
    public static void m76264a(EmojiInfo emojiInfo, boolean z) {
        AppMethodBeat.m2504i(52854);
        if (emojiInfo != null) {
            emojiInfo.field_reserved4 = 0;
            C42952j.getEmojiStorageMgr().xYn.mo48556H(emojiInfo);
            C42952j.bkh().mo35676s(emojiInfo);
            if (z) {
                C7060h.pYm.mo8378a(231, 0, 1, false);
                AppMethodBeat.m2505o(52854);
                return;
            }
            C7060h.pYm.mo8378a(231, 1, 1, false);
        }
        AppMethodBeat.m2505o(52854);
    }

    /* renamed from: b */
    private void m76266b(EmojiInfo emojiInfo, boolean z) {
        AppMethodBeat.m2504i(52855);
        if (this.kTF == null) {
            this.kTF = new ArrayList();
        }
        this.kTF.add(emojiInfo.field_groupId);
        C1720g.m3535RO().eJo.mo14541a(new C42945g(emojiInfo.field_groupId), 0);
        if (z) {
            C7060h.pYm.mo8378a(231, 3, 1, false);
            AppMethodBeat.m2505o(52855);
            return;
        }
        C7060h.pYm.mo8378a(231, 2, 1, false);
        AppMethodBeat.m2505o(52855);
    }

    private static boolean bjI() {
        AppMethodBeat.m2504i(52856);
        if (C5023at.is3G(C4996ah.getContext()) || C5023at.is4G(C4996ah.getContext()) || C5023at.is2G(C4996ah.getContext())) {
            AppMethodBeat.m2505o(52856);
            return true;
        }
        AppMethodBeat.m2505o(52856);
        return false;
    }
}
