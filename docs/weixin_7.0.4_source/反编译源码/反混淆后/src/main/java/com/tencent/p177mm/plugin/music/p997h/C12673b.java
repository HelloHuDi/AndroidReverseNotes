package com.tencent.p177mm.plugin.music.p997h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p198aw.C9058e;
import com.tencent.p177mm.plugin.music.cache.C39433g;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4995ag;
import java.io.File;

/* renamed from: com.tencent.mm.plugin.music.h.b */
public final class C12673b {
    /* renamed from: Tu */
    public static String m20671Tu(String str) {
        AppMethodBeat.m2504i(137690);
        String str2 = "piece" + C4995ag.m7428ck(str.hashCode());
        AppMethodBeat.m2505o(137690);
        return str2;
    }

    /* renamed from: Tv */
    public static String m20672Tv(String str) {
        AppMethodBeat.m2504i(137691);
        File file = new File(C39433g.getAccPath(), "music");
        if (!file.exists()) {
            file.mkdirs();
        }
        C4990ab.m7411d("MicroMsg.Music.MusicFileUtil", "getMusicPieceFilePath music name %s path %s", C12673b.m20671Tu(str), new File(file, C12673b.m20671Tu(str)).getAbsoluteFile());
        String absolutePath = r2.getAbsolutePath();
        AppMethodBeat.m2505o(137691);
        return absolutePath;
    }

    /* renamed from: K */
    public static String m20670K(C9058e c9058e) {
        AppMethodBeat.m2504i(137692);
        String str;
        if (c9058e.fJS == 6) {
            str = "6_" + C4995ag.m7428ck(c9058e.fJU);
            AppMethodBeat.m2505o(137692);
            return str;
        }
        str = "0_" + C4995ag.m7428ck(c9058e.fJU);
        AppMethodBeat.m2505o(137692);
        return str;
    }

    /* renamed from: aW */
    public static String m20673aW(String str, boolean z) {
        AppMethodBeat.m2504i(137693);
        File file = new File(C39433g.getAccPath(), "music");
        if (!file.exists()) {
            C4990ab.m7417i("MicroMsg.Music.MusicFileUtil", "create file folder:%b for path:%s", Boolean.valueOf(file.mkdirs()), file.getAbsolutePath());
        }
        C4990ab.m7411d("MicroMsg.Music.MusicFileUtil", "music name %s path %s", C12673b.m20674aX(str, z), new File(file, C12673b.m20674aX(str, z)).getAbsoluteFile());
        String absolutePath = r2.getAbsolutePath();
        AppMethodBeat.m2505o(137693);
        return absolutePath;
    }

    /* renamed from: aX */
    private static String m20674aX(String str, boolean z) {
        AppMethodBeat.m2504i(137694);
        String str2;
        if (z) {
            str2 = C4995ag.m7428ck(str + "temp") + "-wifi";
            AppMethodBeat.m2505o(137694);
            return str2;
        }
        str2 = C4995ag.m7428ck(str + "temp");
        AppMethodBeat.m2505o(137694);
        return str2;
    }

    /* renamed from: aY */
    public static String m20675aY(String str, boolean z) {
        AppMethodBeat.m2504i(137695);
        String str2 = C12673b.m20673aW(str, false) + "-thumb-" + z;
        AppMethodBeat.m2505o(137695);
        return str2;
    }
}
