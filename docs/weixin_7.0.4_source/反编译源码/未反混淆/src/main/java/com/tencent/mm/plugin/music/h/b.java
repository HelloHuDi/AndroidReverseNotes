package com.tencent.mm.plugin.music.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aw.e;
import com.tencent.mm.plugin.music.cache.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ag;
import java.io.File;

public final class b {
    public static String Tu(String str) {
        AppMethodBeat.i(137690);
        String str2 = "piece" + ag.ck(str.hashCode());
        AppMethodBeat.o(137690);
        return str2;
    }

    public static String Tv(String str) {
        AppMethodBeat.i(137691);
        File file = new File(g.getAccPath(), "music");
        if (!file.exists()) {
            file.mkdirs();
        }
        ab.d("MicroMsg.Music.MusicFileUtil", "getMusicPieceFilePath music name %s path %s", Tu(str), new File(file, Tu(str)).getAbsoluteFile());
        String absolutePath = r2.getAbsolutePath();
        AppMethodBeat.o(137691);
        return absolutePath;
    }

    public static String K(e eVar) {
        AppMethodBeat.i(137692);
        String str;
        if (eVar.fJS == 6) {
            str = "6_" + ag.ck(eVar.fJU);
            AppMethodBeat.o(137692);
            return str;
        }
        str = "0_" + ag.ck(eVar.fJU);
        AppMethodBeat.o(137692);
        return str;
    }

    public static String aW(String str, boolean z) {
        AppMethodBeat.i(137693);
        File file = new File(g.getAccPath(), "music");
        if (!file.exists()) {
            ab.i("MicroMsg.Music.MusicFileUtil", "create file folder:%b for path:%s", Boolean.valueOf(file.mkdirs()), file.getAbsolutePath());
        }
        ab.d("MicroMsg.Music.MusicFileUtil", "music name %s path %s", aX(str, z), new File(file, aX(str, z)).getAbsoluteFile());
        String absolutePath = r2.getAbsolutePath();
        AppMethodBeat.o(137693);
        return absolutePath;
    }

    private static String aX(String str, boolean z) {
        AppMethodBeat.i(137694);
        String str2;
        if (z) {
            str2 = ag.ck(str + "temp") + "-wifi";
            AppMethodBeat.o(137694);
            return str2;
        }
        str2 = ag.ck(str + "temp");
        AppMethodBeat.o(137694);
        return str2;
    }

    public static String aY(String str, boolean z) {
        AppMethodBeat.i(137695);
        String str2 = aW(str, false) + "-thumb-" + z;
        AppMethodBeat.o(137695);
        return str2;
    }
}
