package com.tencent.mm.plugin.music.cache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aw.h;
import com.tencent.mm.plugin.music.c.a;
import com.tencent.mm.plugin.music.f.c.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class e {
    public static boolean bTG() {
        AppMethodBeat.i(137414);
        if (b.ar(c.class) != null) {
            AppMethodBeat.o(137414);
            return true;
        }
        AppMethodBeat.o(137414);
        return false;
    }

    public static String getAccPath() {
        String accPath;
        AppMethodBeat.i(137415);
        if (bTG()) {
            accPath = ((c) b.ar(c.class)).getAccPath();
            if (!bo.isNullOrNil(accPath)) {
                AppMethodBeat.o(137415);
                return accPath;
            }
        }
        ab.e("MicroMsg.Music.MusicDataStorageImpl", "IMusicDataStorage service not exist");
        accPath = com.tencent.mm.loader.j.b.eSn;
        AppMethodBeat.o(137415);
        return accPath;
    }

    public static h SQ(String str) {
        AppMethodBeat.i(137416);
        if (bTG()) {
            h SQ = ((c) b.ar(c.class)).SQ(str);
            AppMethodBeat.o(137416);
            return SQ;
        }
        ab.e("MicroMsg.Music.MusicDataStorageImpl", "IMusicDataStorage service not exist");
        AppMethodBeat.o(137416);
        return null;
    }

    public static void y(String str, byte[] bArr) {
        AppMethodBeat.i(137417);
        if (bTG()) {
            ((c) b.ar(c.class)).y(str, bArr);
            AppMethodBeat.o(137417);
            return;
        }
        ab.e("MicroMsg.Music.MusicDataStorageImpl", "IMusicDataStorage service not exist");
        AppMethodBeat.o(137417);
    }

    public static void cH(String str, int i) {
        AppMethodBeat.i(137418);
        if (bTG()) {
            ((c) b.ar(c.class)).cH(str, i);
        }
        AppMethodBeat.o(137418);
    }

    public static a SU(String str) {
        AppMethodBeat.i(137419);
        a SU;
        if (bTG()) {
            SU = ((c) b.ar(c.class)).SU(str);
            AppMethodBeat.o(137419);
            return SU;
        }
        ab.e("MicroMsg.Music.MusicDataStorageImpl", "IMusicDataStorage service not exist");
        SU = new a();
        AppMethodBeat.o(137419);
        return SU;
    }

    public static void a(String str, a aVar) {
        AppMethodBeat.i(137420);
        if (bTG()) {
            ((c) b.ar(c.class)).a(str, aVar);
            AppMethodBeat.o(137420);
            return;
        }
        ab.e("MicroMsg.Music.MusicDataStorageImpl", "IMusicDataStorage service not exist");
        AppMethodBeat.o(137420);
    }
}
