package com.tencent.p177mm.emoji.p227a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p823ab.C8902b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5018as;
import com.tencent.p177mm.storage.C23505at;
import com.tencent.p177mm.storage.emotion.EmojiInfo;
import java.util.ArrayList;
import java.util.List;
import p000a.C0220l;
import p000a.C37091y;
import p000a.p005f.p006a.C31214a;
import p000a.p005f.p007b.C25052j;
import p000a.p005f.p007b.C25053k;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u000b\u001a\u00020\fJ\u0006\u0010\r\u001a\u00020\u000eJ\u0006\u0010\u000f\u001a\u00020\fJ\u0006\u0010\u0010\u001a\u00020\u0011J\u0006\u0010\u0012\u001a\u00020\u0011J\u000e\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u0011J\u000e\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u0011R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u0016"}, dWq = {"Lcom/tencent/mm/emoji/model/EmojiStorageState;", "", "()V", "KVName", "", "KeyCaptureFull", "KeyCaptureSize", "KeyCustomFull", "KeyCustomSize", "KeySync", "TAG", "checkSize", "", "getKV", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "init", "isCaptureFull", "", "isCustomFull", "setCaptureFull", "full", "setCustomFull", "plugin-emojisdk_release"})
/* renamed from: com.tencent.mm.emoji.a.b */
public final class C32498b {
    private static final String TAG = TAG;
    private static final String eyC = eyC;
    public static final C32498b eyD = new C32498b();

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    /* renamed from: com.tencent.mm.emoji.a.b$a */
    static final class C18189a extends C25053k implements C31214a<C37091y> {
        public static final C18189a eyE = new C18189a();

        static {
            AppMethodBeat.m2504i(63238);
            AppMethodBeat.m2505o(63238);
        }

        C18189a() {
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            boolean z = true;
            AppMethodBeat.m2504i(63237);
            C23505at dsZ = C23505at.dsZ();
            C25052j.m39375o(dsZ, "EmojiStorageMgr.getInstance()");
            List MD = dsZ.aUp().mo48562MD(0);
            C32497a OB = C32497a.m53203OB();
            C25052j.m39375o(OB, "EmojiStorageCache.getInstance()");
            ArrayList<EmojiInfo> OC = OB.mo53134OC();
            C25052j.m39375o(OC, "customList");
            for (EmojiInfo emojiInfo : OC) {
                C25052j.m39375o(emojiInfo, "it");
                if (!MD.contains(emojiInfo.mo20410Aq())) {
                    MD.add(emojiInfo.mo20410Aq());
                }
            }
            int size = MD.size();
            boolean z2 = size >= C26072e.m41618OM();
            C32498b c32498b = C32498b.eyD;
            C32498b.m53213OE().putInt("normal_custom_size", size);
            c32498b = C32498b.eyD;
            C32498b.m53213OE().putBoolean("custom_full", z2);
            dsZ = C23505at.dsZ();
            C25052j.m39375o(dsZ, "EmojiStorageMgr.getInstance()");
            List MD2 = dsZ.aUp().mo48562MD(1);
            OC = C32497a.m53203OB().mo53137bZ(false);
            C25052j.m39375o(OC, "captureList");
            for (EmojiInfo emojiInfo2 : OC) {
                C25052j.m39375o(emojiInfo2, "it");
                if (!MD2.contains(emojiInfo2.mo20410Aq())) {
                    MD2.add(emojiInfo2.mo20410Aq());
                }
            }
            int size2 = MD2.size();
            if (size2 < C26072e.m41619ON()) {
                z = false;
            }
            C32498b c32498b2 = C32498b.eyD;
            C32498b.m53213OE().putInt("capture_custom_size", size2);
            c32498b2 = C32498b.eyD;
            C32498b.m53213OE().putBoolean("capture_full", z);
            c32498b2 = C32498b.eyD;
            C4990ab.m7416i(C32498b.TAG, "init: normal size is " + size + ' ' + z2 + "; capture size is " + size2 + ' ' + z);
            C37091y c37091y = C37091y.AUy;
            AppMethodBeat.m2505o(63237);
            return c37091y;
        }
    }

    static {
        AppMethodBeat.m2504i(63244);
        AppMethodBeat.m2505o(63244);
    }

    private C32498b() {
    }

    /* renamed from: OE */
    public static C5018as m53213OE() {
        AppMethodBeat.m2504i(63239);
        C5018as amF = C5018as.amF(eyC);
        C25052j.m39375o(amF, "MultiProcessMMKV.getMMKV(KVName)");
        AppMethodBeat.m2505o(63239);
        return amF;
    }

    /* renamed from: OF */
    public static boolean m53214OF() {
        AppMethodBeat.m2504i(63240);
        boolean z = C32498b.m53213OE().getBoolean("capture_full", false);
        AppMethodBeat.m2505o(63240);
        return z;
    }

    /* renamed from: ce */
    public static void m53217ce(boolean z) {
        AppMethodBeat.m2504i(63241);
        C32498b.m53213OE().putBoolean("custom_full", z);
        if (z && C32498b.m53213OE().getInt("normal_custom_size", 0) < C26072e.m41618OM()) {
            C4990ab.m7420w(TAG, "custom state mismatch!");
        }
        AppMethodBeat.m2505o(63241);
    }

    /* renamed from: cf */
    public static void m53218cf(boolean z) {
        AppMethodBeat.m2504i(63242);
        C32498b.m53213OE().putBoolean("capture_full", z);
        if (z && C32498b.m53213OE().getInt("capture_custom_size", 0) < C26072e.m41619ON()) {
            C4990ab.m7420w(TAG, "capture state mismatch!");
        }
        AppMethodBeat.m2505o(63242);
    }

    /* renamed from: OG */
    public static void m53215OG() {
        AppMethodBeat.m2504i(63243);
        C8902b.m16044a("EmojiStorageState_checkSize", (C31214a) C18189a.eyE);
        AppMethodBeat.m2505o(63243);
    }
}
