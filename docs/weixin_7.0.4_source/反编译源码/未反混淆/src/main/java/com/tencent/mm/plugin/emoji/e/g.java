package com.tencent.mm.plugin.emoji.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.at.a.a.c;
import com.tencent.mm.at.a.a.c.a;
import com.tencent.mm.plugin.emoji.h.b;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class g {
    private static final c kTQ;

    public static c dH(String str, String str2) {
        AppMethodBeat.i(52871);
        c h = h(str, str2, new Object[0]);
        AppMethodBeat.o(52871);
        return h;
    }

    public static c h(String str, String str2, Object... objArr) {
        AppMethodBeat.i(52872);
        String K = EmojiLogic.K(b.Yb(), str, str2);
        if (bo.isNullOrNil(K)) {
            ab.w("MicroMsg.emoji.EmojiImageLoaderManager", "get emoji loader options failed. path is null.");
            AppMethodBeat.o(52872);
            return null;
        }
        a aVar = new a();
        aVar.ePF = true;
        aVar.ePH = true;
        aVar.ePJ = K;
        aVar.eQd = objArr;
        c ahG = aVar.ahG();
        AppMethodBeat.o(52872);
        return ahG;
    }

    public static c u(String str, String str2, int i) {
        AppMethodBeat.i(52873);
        String K = EmojiLogic.K(b.Yb(), str, str2);
        if (bo.isNullOrNil(K)) {
            ab.w("MicroMsg.emoji.EmojiImageLoaderManager", "get emoji loader options failed. path is null.");
            AppMethodBeat.o(52873);
            return null;
        }
        a aVar = new a();
        aVar.ePF = true;
        aVar.ePH = true;
        aVar.ePJ = K;
        aVar.ePO = i;
        aVar.ePN = i;
        c ahG = aVar.ahG();
        AppMethodBeat.o(52873);
        return ahG;
    }

    public static c bjM() {
        AppMethodBeat.i(52874);
        a aVar = new a();
        aVar.ePF = true;
        aVar.ePH = false;
        aVar.fHe = 3;
        c ahG = aVar.ahG();
        AppMethodBeat.o(52874);
        return ahG;
    }

    public static c j(String str, String str2, Object... objArr) {
        AppMethodBeat.i(52875);
        String str3 = com.tencent.mm.kernel.g.RP().eJM;
        String K = EmojiLogic.K(b.Yb(), str, str2);
        if (bo.isNullOrNil(K)) {
            ab.w("MicroMsg.emoji.EmojiImageLoaderManager", "get emoji loader options failed. path is null.");
            AppMethodBeat.o(52875);
            return null;
        }
        a aVar = new a();
        aVar.ePF = true;
        aVar.ePH = true;
        aVar.ePJ = K;
        aVar.ePK = str3;
        aVar.eQd = objArr;
        c ahG = aVar.ahG();
        AppMethodBeat.o(52875);
        return ahG;
    }

    static {
        AppMethodBeat.i(52883);
        a aVar = new a();
        aVar.ePF = true;
        aVar.fHe = 1;
        aVar.ePZ = false;
        kTQ = aVar.ahG();
        AppMethodBeat.o(52883);
    }

    public static c q(String str, Object... objArr) {
        AppMethodBeat.i(52876);
        if (bo.isNullOrNil(str)) {
            ab.w("MicroMsg.emoji.EmojiImageLoaderManager", "get emoji loader options failed. path is null.");
            AppMethodBeat.o(52876);
            return null;
        }
        a aVar = new a();
        aVar.ePH = true;
        aVar.ePJ = str;
        aVar.eQd = objArr;
        c ahG = aVar.ahG();
        AppMethodBeat.o(52876);
        return ahG;
    }

    public static c r(String str, Object... objArr) {
        AppMethodBeat.i(52877);
        if (bo.isNullOrNil(str)) {
            ab.w("MicroMsg.emoji.EmojiImageLoaderManager", "get emoji loader options failed. path is null.");
            AppMethodBeat.o(52877);
            return null;
        }
        a aVar = new a();
        aVar.ePH = true;
        aVar.ePJ = str;
        aVar.eQb = false;
        aVar.eQd = objArr;
        c ahG = aVar.ahG();
        AppMethodBeat.o(52877);
        return ahG;
    }

    public static c a(String str, int i, Object... objArr) {
        AppMethodBeat.i(52878);
        if (bo.isNullOrNil(str)) {
            ab.w("MicroMsg.emoji.EmojiImageLoaderManager", "get emoji loader options failed. path is null.");
            AppMethodBeat.o(52878);
            return null;
        }
        a aVar = new a();
        aVar.ePH = true;
        aVar.ePJ = str;
        aVar.ePO = i;
        aVar.ePN = i;
        aVar.eQd = objArr;
        c ahG = aVar.ahG();
        AppMethodBeat.o(52878);
        return ahG;
    }

    public static c dI(String str, String str2) {
        AppMethodBeat.i(52879);
        String K = EmojiLogic.K(b.Yb(), str, str2);
        if (bo.isNullOrNil(K)) {
            ab.w("MicroMsg.emoji.EmojiImageLoaderManager", "get emoji loader options failed. path is null.");
            AppMethodBeat.o(52879);
            return null;
        }
        a aVar = new a();
        aVar.ePF = true;
        aVar.ePH = true;
        aVar.ePJ = K;
        aVar.eQf = true;
        c ahG = aVar.ahG();
        AppMethodBeat.o(52879);
        return ahG;
    }

    public static c dJ(String str, String str2) {
        AppMethodBeat.i(52880);
        String K = EmojiLogic.K(b.Yb(), str, str2);
        if (bo.isNullOrNil(K)) {
            ab.w("MicroMsg.emoji.EmojiImageLoaderManager", "get emoji loader options failed. path is null.");
            AppMethodBeat.o(52880);
            return null;
        }
        a aVar = new a();
        aVar.ePF = true;
        aVar.ePH = true;
        aVar.ePJ = K;
        aVar.eQf = false;
        c ahG = aVar.ahG();
        AppMethodBeat.o(52880);
        return ahG;
    }

    public static c k(String str, String str2, Object... objArr) {
        AppMethodBeat.i(52881);
        String K = EmojiLogic.K(b.Yb(), str, str2);
        if (bo.isNullOrNil(K)) {
            ab.w("MicroMsg.emoji.EmojiImageLoaderManager", "get emoji loader options failed. path is null.");
            AppMethodBeat.o(52881);
            return null;
        }
        a aVar = new a();
        aVar.ePF = false;
        aVar.ePH = true;
        aVar.ePJ = K;
        aVar.eQd = objArr;
        c ahG = aVar.ahG();
        AppMethodBeat.o(52881);
        return ahG;
    }

    public static c l(String str, String str2, Object... objArr) {
        AppMethodBeat.i(52882);
        String K = EmojiLogic.K(b.Yb(), str, str2);
        if (bo.isNullOrNil(K)) {
            ab.w("MicroMsg.emoji.EmojiImageLoaderManager", "get emoji loader options failed. path is null.");
            AppMethodBeat.o(52882);
            return null;
        }
        a aVar = new a();
        aVar.ePF = true;
        aVar.ePH = true;
        aVar.ePJ = K;
        aVar.eQd = objArr;
        c ahG = aVar.ahG();
        AppMethodBeat.o(52882);
        return ahG;
    }
}
