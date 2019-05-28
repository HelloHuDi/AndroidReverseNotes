package com.tencent.p177mm.plugin.emoji.p947e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p190at.p191a.p827a.C25814c;
import com.tencent.p177mm.p190at.p191a.p827a.C25814c.C17927a;
import com.tencent.p177mm.plugin.emoji.model.EmojiLogic;
import com.tencent.p177mm.plugin.emoji.p383h.C2933b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.emoji.e.g */
public final class C20364g {
    private static final C25814c kTQ;

    /* renamed from: dH */
    public static C25814c m31459dH(String str, String str2) {
        AppMethodBeat.m2504i(52871);
        C25814c h = C20364g.m31462h(str, str2, new Object[0]);
        AppMethodBeat.m2505o(52871);
        return h;
    }

    /* renamed from: h */
    public static C25814c m31462h(String str, String str2, Object... objArr) {
        AppMethodBeat.m2504i(52872);
        String K = EmojiLogic.m44072K(C2933b.m5221Yb(), str, str2);
        if (C5046bo.isNullOrNil(K)) {
            C4990ab.m7420w("MicroMsg.emoji.EmojiImageLoaderManager", "get emoji loader options failed. path is null.");
            AppMethodBeat.m2505o(52872);
            return null;
        }
        C17927a c17927a = new C17927a();
        c17927a.ePF = true;
        c17927a.ePH = true;
        c17927a.ePJ = K;
        c17927a.eQd = objArr;
        C25814c ahG = c17927a.ahG();
        AppMethodBeat.m2505o(52872);
        return ahG;
    }

    /* renamed from: u */
    public static C25814c m31468u(String str, String str2, int i) {
        AppMethodBeat.m2504i(52873);
        String K = EmojiLogic.m44072K(C2933b.m5221Yb(), str, str2);
        if (C5046bo.isNullOrNil(K)) {
            C4990ab.m7420w("MicroMsg.emoji.EmojiImageLoaderManager", "get emoji loader options failed. path is null.");
            AppMethodBeat.m2505o(52873);
            return null;
        }
        C17927a c17927a = new C17927a();
        c17927a.ePF = true;
        c17927a.ePH = true;
        c17927a.ePJ = K;
        c17927a.ePO = i;
        c17927a.ePN = i;
        C25814c ahG = c17927a.ahG();
        AppMethodBeat.m2505o(52873);
        return ahG;
    }

    public static C25814c bjM() {
        AppMethodBeat.m2504i(52874);
        C17927a c17927a = new C17927a();
        c17927a.ePF = true;
        c17927a.ePH = false;
        c17927a.fHe = 3;
        C25814c ahG = c17927a.ahG();
        AppMethodBeat.m2505o(52874);
        return ahG;
    }

    /* renamed from: j */
    public static C25814c m31463j(String str, String str2, Object... objArr) {
        AppMethodBeat.m2504i(52875);
        String str3 = C1720g.m3536RP().eJM;
        String K = EmojiLogic.m44072K(C2933b.m5221Yb(), str, str2);
        if (C5046bo.isNullOrNil(K)) {
            C4990ab.m7420w("MicroMsg.emoji.EmojiImageLoaderManager", "get emoji loader options failed. path is null.");
            AppMethodBeat.m2505o(52875);
            return null;
        }
        C17927a c17927a = new C17927a();
        c17927a.ePF = true;
        c17927a.ePH = true;
        c17927a.ePJ = K;
        c17927a.ePK = str3;
        c17927a.eQd = objArr;
        C25814c ahG = c17927a.ahG();
        AppMethodBeat.m2505o(52875);
        return ahG;
    }

    static {
        AppMethodBeat.m2504i(52883);
        C17927a c17927a = new C17927a();
        c17927a.ePF = true;
        c17927a.fHe = 1;
        c17927a.ePZ = false;
        kTQ = c17927a.ahG();
        AppMethodBeat.m2505o(52883);
    }

    /* renamed from: q */
    public static C25814c m31466q(String str, Object... objArr) {
        AppMethodBeat.m2504i(52876);
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7420w("MicroMsg.emoji.EmojiImageLoaderManager", "get emoji loader options failed. path is null.");
            AppMethodBeat.m2505o(52876);
            return null;
        }
        C17927a c17927a = new C17927a();
        c17927a.ePH = true;
        c17927a.ePJ = str;
        c17927a.eQd = objArr;
        C25814c ahG = c17927a.ahG();
        AppMethodBeat.m2505o(52876);
        return ahG;
    }

    /* renamed from: r */
    public static C25814c m31467r(String str, Object... objArr) {
        AppMethodBeat.m2504i(52877);
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7420w("MicroMsg.emoji.EmojiImageLoaderManager", "get emoji loader options failed. path is null.");
            AppMethodBeat.m2505o(52877);
            return null;
        }
        C17927a c17927a = new C17927a();
        c17927a.ePH = true;
        c17927a.ePJ = str;
        c17927a.eQb = false;
        c17927a.eQd = objArr;
        C25814c ahG = c17927a.ahG();
        AppMethodBeat.m2505o(52877);
        return ahG;
    }

    /* renamed from: a */
    public static C25814c m31458a(String str, int i, Object... objArr) {
        AppMethodBeat.m2504i(52878);
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7420w("MicroMsg.emoji.EmojiImageLoaderManager", "get emoji loader options failed. path is null.");
            AppMethodBeat.m2505o(52878);
            return null;
        }
        C17927a c17927a = new C17927a();
        c17927a.ePH = true;
        c17927a.ePJ = str;
        c17927a.ePO = i;
        c17927a.ePN = i;
        c17927a.eQd = objArr;
        C25814c ahG = c17927a.ahG();
        AppMethodBeat.m2505o(52878);
        return ahG;
    }

    /* renamed from: dI */
    public static C25814c m31460dI(String str, String str2) {
        AppMethodBeat.m2504i(52879);
        String K = EmojiLogic.m44072K(C2933b.m5221Yb(), str, str2);
        if (C5046bo.isNullOrNil(K)) {
            C4990ab.m7420w("MicroMsg.emoji.EmojiImageLoaderManager", "get emoji loader options failed. path is null.");
            AppMethodBeat.m2505o(52879);
            return null;
        }
        C17927a c17927a = new C17927a();
        c17927a.ePF = true;
        c17927a.ePH = true;
        c17927a.ePJ = K;
        c17927a.eQf = true;
        C25814c ahG = c17927a.ahG();
        AppMethodBeat.m2505o(52879);
        return ahG;
    }

    /* renamed from: dJ */
    public static C25814c m31461dJ(String str, String str2) {
        AppMethodBeat.m2504i(52880);
        String K = EmojiLogic.m44072K(C2933b.m5221Yb(), str, str2);
        if (C5046bo.isNullOrNil(K)) {
            C4990ab.m7420w("MicroMsg.emoji.EmojiImageLoaderManager", "get emoji loader options failed. path is null.");
            AppMethodBeat.m2505o(52880);
            return null;
        }
        C17927a c17927a = new C17927a();
        c17927a.ePF = true;
        c17927a.ePH = true;
        c17927a.ePJ = K;
        c17927a.eQf = false;
        C25814c ahG = c17927a.ahG();
        AppMethodBeat.m2505o(52880);
        return ahG;
    }

    /* renamed from: k */
    public static C25814c m31464k(String str, String str2, Object... objArr) {
        AppMethodBeat.m2504i(52881);
        String K = EmojiLogic.m44072K(C2933b.m5221Yb(), str, str2);
        if (C5046bo.isNullOrNil(K)) {
            C4990ab.m7420w("MicroMsg.emoji.EmojiImageLoaderManager", "get emoji loader options failed. path is null.");
            AppMethodBeat.m2505o(52881);
            return null;
        }
        C17927a c17927a = new C17927a();
        c17927a.ePF = false;
        c17927a.ePH = true;
        c17927a.ePJ = K;
        c17927a.eQd = objArr;
        C25814c ahG = c17927a.ahG();
        AppMethodBeat.m2505o(52881);
        return ahG;
    }

    /* renamed from: l */
    public static C25814c m31465l(String str, String str2, Object... objArr) {
        AppMethodBeat.m2504i(52882);
        String K = EmojiLogic.m44072K(C2933b.m5221Yb(), str, str2);
        if (C5046bo.isNullOrNil(K)) {
            C4990ab.m7420w("MicroMsg.emoji.EmojiImageLoaderManager", "get emoji loader options failed. path is null.");
            AppMethodBeat.m2505o(52882);
            return null;
        }
        C17927a c17927a = new C17927a();
        c17927a.ePF = true;
        c17927a.ePH = true;
        c17927a.ePJ = K;
        c17927a.eQd = objArr;
        C25814c ahG = c17927a.ahG();
        AppMethodBeat.m2505o(52882);
        return ahG;
    }
}
