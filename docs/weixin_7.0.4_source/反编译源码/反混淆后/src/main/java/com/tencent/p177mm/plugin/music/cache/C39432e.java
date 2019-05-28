package com.tencent.p177mm.plugin.music.cache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.loader.p248j.C1761b;
import com.tencent.p177mm.p198aw.C9060h;
import com.tencent.p177mm.plugin.music.p1282c.C34577a;
import com.tencent.p177mm.plugin.music.p463f.p1616c.C43329b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.music.cache.e */
public final class C39432e {
    public static boolean bTG() {
        AppMethodBeat.m2504i(137414);
        if (C43329b.m77295ar(C21343c.class) != null) {
            AppMethodBeat.m2505o(137414);
            return true;
        }
        AppMethodBeat.m2505o(137414);
        return false;
    }

    public static String getAccPath() {
        String accPath;
        AppMethodBeat.m2504i(137415);
        if (C39432e.bTG()) {
            accPath = ((C21343c) C43329b.m77295ar(C21343c.class)).getAccPath();
            if (!C5046bo.isNullOrNil(accPath)) {
                AppMethodBeat.m2505o(137415);
                return accPath;
            }
        }
        C4990ab.m7412e("MicroMsg.Music.MusicDataStorageImpl", "IMusicDataStorage service not exist");
        accPath = C1761b.eSn;
        AppMethodBeat.m2505o(137415);
        return accPath;
    }

    /* renamed from: SQ */
    public static C9060h m67338SQ(String str) {
        AppMethodBeat.m2504i(137416);
        if (C39432e.bTG()) {
            C9060h SQ = ((C21343c) C43329b.m77295ar(C21343c.class)).mo36785SQ(str);
            AppMethodBeat.m2505o(137416);
            return SQ;
        }
        C4990ab.m7412e("MicroMsg.Music.MusicDataStorageImpl", "IMusicDataStorage service not exist");
        AppMethodBeat.m2505o(137416);
        return null;
    }

    /* renamed from: y */
    public static void m67342y(String str, byte[] bArr) {
        AppMethodBeat.m2504i(137417);
        if (C39432e.bTG()) {
            ((C21343c) C43329b.m77295ar(C21343c.class)).mo36801y(str, bArr);
            AppMethodBeat.m2505o(137417);
            return;
        }
        C4990ab.m7412e("MicroMsg.Music.MusicDataStorageImpl", "IMusicDataStorage service not exist");
        AppMethodBeat.m2505o(137417);
    }

    /* renamed from: cH */
    public static void m67341cH(String str, int i) {
        AppMethodBeat.m2504i(137418);
        if (C39432e.bTG()) {
            ((C21343c) C43329b.m77295ar(C21343c.class)).mo36796cH(str, i);
        }
        AppMethodBeat.m2505o(137418);
    }

    /* renamed from: SU */
    public static C34577a m67339SU(String str) {
        AppMethodBeat.m2504i(137419);
        C34577a SU;
        if (C39432e.bTG()) {
            SU = ((C21343c) C43329b.m77295ar(C21343c.class)).mo36789SU(str);
            AppMethodBeat.m2505o(137419);
            return SU;
        }
        C4990ab.m7412e("MicroMsg.Music.MusicDataStorageImpl", "IMusicDataStorage service not exist");
        SU = new C34577a();
        AppMethodBeat.m2505o(137419);
        return SU;
    }

    /* renamed from: a */
    public static void m67340a(String str, C34577a c34577a) {
        AppMethodBeat.m2504i(137420);
        if (C39432e.bTG()) {
            ((C21343c) C43329b.m77295ar(C21343c.class)).mo36790a(str, c34577a);
            AppMethodBeat.m2505o(137420);
            return;
        }
        C4990ab.m7412e("MicroMsg.Music.MusicDataStorageImpl", "IMusicDataStorage service not exist");
        AppMethodBeat.m2505o(137420);
    }
}
