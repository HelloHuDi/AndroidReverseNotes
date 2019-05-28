package com.tencent.p177mm.plugin.music.cache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.music.p463f.p1616c.C43329b;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.music.cache.f */
public final class C46095f implements C21342b {
    private static long clx = 0;
    private List<String> clw = new ArrayList(10);

    public C46095f(List<String> list) {
        AppMethodBeat.m2504i(137422);
        if (!list.isEmpty()) {
            this.clw.addAll(list);
        }
        AppMethodBeat.m2505o(137422);
    }

    /* renamed from: dA */
    private boolean m85973dA(String str) {
        AppMethodBeat.m2504i(137424);
        for (String contains : this.clw) {
            if (str.contains(contains)) {
                AppMethodBeat.m2505o(137424);
                return true;
            }
        }
        AppMethodBeat.m2505o(137424);
        return false;
    }

    public final void bTy() {
        long j = 0;
        AppMethodBeat.m2504i(137423);
        if (clx == 0) {
            if (C39432e.bTG()) {
                j = ((C21343c) C43329b.m77295ar(C21343c.class)).bTB();
            } else {
                C4990ab.m7412e("MicroMsg.Music.MusicDataStorageImpl", "IMusicDataStorage service not exist");
            }
            clx = j;
        }
        j = System.currentTimeMillis();
        if (j - clx <= oLa.longValue()) {
            C4990ab.m7412e("MicroMsg.Music.PieceCacheCleanController", "startClean the last clean time is in MUSIC_NO_SCAN_TIME time");
            AppMethodBeat.m2505o(137423);
            return;
        }
        clx = j;
        C4990ab.m7416i("MicroMsg.Music.PieceCacheCleanController", "start clean music file");
        C7305d.post(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(137421);
                long j = j;
                if (C39432e.bTG()) {
                    ((C21343c) C43329b.m77295ar(C21343c.class)).mo36800jm(j);
                }
                C46095f.m85972a(C46095f.this);
                AppMethodBeat.m2505o(137421);
            }
        }, "PieceCacheCleanController");
        AppMethodBeat.m2505o(137423);
    }

    /* renamed from: a */
    static /* synthetic */ void m85972a(C46095f c46095f) {
        String str;
        AppMethodBeat.m2504i(137425);
        C4990ab.m7416i("MicroMsg.Music.PieceCacheCleanController", "clean music piece file");
        String accPath = C39432e.getAccPath();
        if (accPath.endsWith("/")) {
            str = accPath + "music";
        } else {
            str = accPath + File.separator + "music";
        }
        File file = new File(str);
        if (file.exists() && file.isDirectory()) {
            String[] list = file.list();
            if (list == null || list.length == 0) {
                C4990ab.m7416i("MicroMsg.Music.PieceCacheCleanController", "none files exist");
                AppMethodBeat.m2505o(137425);
                return;
            }
            for (String str2 : list) {
                if (c46095f.m85973dA(str2)) {
                    C4990ab.m7416i("MicroMsg.Music.PieceCacheCleanController", "file is the block file, don't delete");
                } else {
                    file = new File(str + File.separator + str2);
                    if (!file.exists()) {
                        C4990ab.m7416i("MicroMsg.Music.PieceCacheCleanController", "file not exist");
                    } else if (file.isDirectory()) {
                        C4990ab.m7416i("MicroMsg.Music.PieceCacheCleanController", "file is directory, don't delete");
                    } else if (System.currentTimeMillis() - file.lastModified() > cln.longValue()) {
                        C4990ab.m7413e("MicroMsg.Music.PieceCacheCleanController", "Clean 7 days file in music file name=%s, path:%s", file.getName(), file.getAbsolutePath());
                        file.delete();
                        if (str2.startsWith("piece")) {
                            C4990ab.m7412e("MicroMsg.Music.PieceCacheCleanController", "file is piece prefix, delete the piece info in db");
                            if (C39432e.bTG()) {
                                ((C21343c) C43329b.m77295ar(C21343c.class)).mo36787SS(str2);
                            }
                        }
                    } else {
                        C4990ab.m7416i("MicroMsg.Music.PieceCacheCleanController", "not delete the file, file is in valid time for 7 day");
                    }
                }
            }
            AppMethodBeat.m2505o(137425);
            return;
        }
        C4990ab.m7416i("MicroMsg.Music.PieceCacheCleanController", "musicFolder is not exist or not Directory");
        AppMethodBeat.m2505o(137425);
    }
}
