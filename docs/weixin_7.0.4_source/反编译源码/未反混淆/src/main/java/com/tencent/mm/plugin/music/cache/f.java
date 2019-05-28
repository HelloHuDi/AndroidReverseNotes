package com.tencent.mm.plugin.music.cache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.music.f.c.b;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public final class f implements b {
    private static long clx = 0;
    private List<String> clw = new ArrayList(10);

    public f(List<String> list) {
        AppMethodBeat.i(137422);
        if (!list.isEmpty()) {
            this.clw.addAll(list);
        }
        AppMethodBeat.o(137422);
    }

    private boolean dA(String str) {
        AppMethodBeat.i(137424);
        for (String contains : this.clw) {
            if (str.contains(contains)) {
                AppMethodBeat.o(137424);
                return true;
            }
        }
        AppMethodBeat.o(137424);
        return false;
    }

    public final void bTy() {
        long j = 0;
        AppMethodBeat.i(137423);
        if (clx == 0) {
            if (e.bTG()) {
                j = ((c) b.ar(c.class)).bTB();
            } else {
                ab.e("MicroMsg.Music.MusicDataStorageImpl", "IMusicDataStorage service not exist");
            }
            clx = j;
        }
        j = System.currentTimeMillis();
        if (j - clx <= oLa.longValue()) {
            ab.e("MicroMsg.Music.PieceCacheCleanController", "startClean the last clean time is in MUSIC_NO_SCAN_TIME time");
            AppMethodBeat.o(137423);
            return;
        }
        clx = j;
        ab.i("MicroMsg.Music.PieceCacheCleanController", "start clean music file");
        d.post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(137421);
                long j = j;
                if (e.bTG()) {
                    ((c) b.ar(c.class)).jm(j);
                }
                f.a(f.this);
                AppMethodBeat.o(137421);
            }
        }, "PieceCacheCleanController");
        AppMethodBeat.o(137423);
    }

    static /* synthetic */ void a(f fVar) {
        String str;
        AppMethodBeat.i(137425);
        ab.i("MicroMsg.Music.PieceCacheCleanController", "clean music piece file");
        String accPath = e.getAccPath();
        if (accPath.endsWith("/")) {
            str = accPath + "music";
        } else {
            str = accPath + File.separator + "music";
        }
        File file = new File(str);
        if (file.exists() && file.isDirectory()) {
            String[] list = file.list();
            if (list == null || list.length == 0) {
                ab.i("MicroMsg.Music.PieceCacheCleanController", "none files exist");
                AppMethodBeat.o(137425);
                return;
            }
            for (String str2 : list) {
                if (fVar.dA(str2)) {
                    ab.i("MicroMsg.Music.PieceCacheCleanController", "file is the block file, don't delete");
                } else {
                    file = new File(str + File.separator + str2);
                    if (!file.exists()) {
                        ab.i("MicroMsg.Music.PieceCacheCleanController", "file not exist");
                    } else if (file.isDirectory()) {
                        ab.i("MicroMsg.Music.PieceCacheCleanController", "file is directory, don't delete");
                    } else if (System.currentTimeMillis() - file.lastModified() > cln.longValue()) {
                        ab.e("MicroMsg.Music.PieceCacheCleanController", "Clean 7 days file in music file name=%s, path:%s", file.getName(), file.getAbsolutePath());
                        file.delete();
                        if (str2.startsWith("piece")) {
                            ab.e("MicroMsg.Music.PieceCacheCleanController", "file is piece prefix, delete the piece info in db");
                            if (e.bTG()) {
                                ((c) b.ar(c.class)).SS(str2);
                            }
                        }
                    } else {
                        ab.i("MicroMsg.Music.PieceCacheCleanController", "not delete the file, file is in valid time for 7 day");
                    }
                }
            }
            AppMethodBeat.o(137425);
            return;
        }
        ab.i("MicroMsg.Music.PieceCacheCleanController", "musicFolder is not exist or not Directory");
        AppMethodBeat.o(137425);
    }
}
