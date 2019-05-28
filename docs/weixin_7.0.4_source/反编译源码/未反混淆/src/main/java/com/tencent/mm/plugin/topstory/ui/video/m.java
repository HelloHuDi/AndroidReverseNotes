package com.tencent.mm.plugin.topstory.ui.video;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.e;
import com.tencent.mm.al.f;
import com.tencent.mm.plugin.topstory.a.g;
import com.tencent.mm.pluginsdk.f.h;
import com.tencent.mm.protocal.protobuf.chw;
import com.tencent.mm.protocal.protobuf.chx;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class m {
    b sDo;
    String sES;
    Map<String, chx> sET = Collections.synchronizedMap(new HashMap());
    Set<String> sEU = Collections.synchronizedSet(new HashSet());
    private int sEV = 0;

    class d implements com.tencent.mm.i.g.a {
        private d() {
        }

        /* synthetic */ d(m mVar, byte b) {
            this();
        }

        public final int a(String str, int i, com.tencent.mm.i.c cVar, com.tencent.mm.i.d dVar, boolean z) {
            AppMethodBeat.i(1750);
            if (cVar != null && cVar.field_toltalLength > 0 && m.this.sET.containsKey(str)) {
                chx chx = (chx) m.this.sET.get(str);
                chx.xhj = (long) cVar.field_finishedLength;
                chx.xhk = m.aa((long) cVar.field_finishedLength, (long) cVar.field_toltalLength);
                chx.xha = (long) cVar.field_toltalLength;
                m.this.sET.put(str, chx);
            }
            AppMethodBeat.o(1750);
            return 0;
        }

        public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
        }

        public final byte[] l(String str, byte[] bArr) {
            return new byte[0];
        }
    }

    class a implements Runnable {
        private String mPq;

        a(String str) {
            this.mPq = str;
        }

        /* JADX WARNING: Removed duplicated region for block: B:21:0x00e0  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void run() {
            AppMethodBeat.i(1747);
            File file = new File(this.mPq);
            if (file.exists()) {
                File[] listFiles = file.listFiles();
                String str = "MicroMsg.TopStory.TopStoryPreloadMgr";
                String str2 = "DeleteVideoCacheTask preloadSize: %d cacheSize: %d folderSize: %d";
                Object[] objArr = new Object[3];
                objArr[0] = Integer.valueOf(m.this.sEU.size());
                objArr[1] = Integer.valueOf(m.this.sET.size());
                objArr[2] = Integer.valueOf(listFiles != null ? listFiles.length : 0);
                ab.i(str, str2, objArr);
                if (listFiles != null && listFiles.length > 10) {
                    ArrayList arrayList = new ArrayList(listFiles.length);
                    for (Object add : listFiles) {
                        arrayList.add(add);
                    }
                    Collections.sort(arrayList, new Comparator<File>() {
                        public final /* synthetic */ int compare(Object obj, Object obj2) {
                            AppMethodBeat.i(1746);
                            int lastModified = (int) (((File) obj2).lastModified() - ((File) obj).lastModified());
                            AppMethodBeat.o(1746);
                            return lastModified;
                        }
                    });
                    ab.i("MicroMsg.TopStory.TopStoryPreloadMgr", "First: %s Last: %s", h.formatTime("yyyy-MM-dd HH:mm:ss", ((File) arrayList.get(0)).lastModified() / 1000), h.formatTime("yyyy-MM-dd HH:mm:ss", ((File) arrayList.get(arrayList.size() - 1)).lastModified() / 1000));
                    List<File> subList = arrayList.subList(10, arrayList.size());
                    String str3 = "";
                    if (m.this.sDo != null) {
                        chw chw = m.this.sDo.cFV().sFv;
                        if (chw != null) {
                            Object au = com.tencent.mm.plugin.topstory.ui.c.au(chw.xgS, chw.xgT);
                            for (File file2 : subList) {
                                str2 = file2.getName().split("\\.")[0];
                                if (!(str2.equals(au) || m.this.sEU.contains(str2))) {
                                    ab.i("MicroMsg.TopStory.TopStoryPreloadMgr", "Delete cache video %s %s", file2.getName(), h.formatTime("yyyy-MM-dd HH:mm:ss", file2.lastModified() / 1000));
                                    m.this.sET.remove(str2);
                                    file2.delete();
                                }
                            }
                        }
                    }
                    String au2 = str3;
                    for (File file22 : subList) {
                    }
                }
                AppMethodBeat.o(1747);
                return;
            }
            ab.i("MicroMsg.TopStory.TopStoryPreloadMgr", "DeleteVideoCacheTask folder %s not exist", this.mPq);
            AppMethodBeat.o(1747);
        }
    }

    class c implements com.tencent.mm.i.g.b {
        private c() {
        }

        /* synthetic */ c(m mVar, byte b) {
            this();
        }

        public final void a(String str, com.tencent.mm.i.d dVar) {
            AppMethodBeat.i(1749);
            if (m.this.sET.containsKey(str)) {
                chx chx = (chx) m.this.sET.get(str);
                chx.xhj = (long) dVar.field_recvedBytes;
                chx.xhk = m.aa(chx.xhj, (long) dVar.field_fileLength);
                chx.xha = (long) dVar.field_fileLength;
                m.this.sET.put(str, chx);
                ab.i("MicroMsg.TopStory.TopStoryPreloadMgr", "VideoPreloadCallback onFinish %s %d %s", str, Long.valueOf(chx.xhk), bo.b(chx.xhj, 100.0d));
            }
            AppMethodBeat.o(1749);
        }
    }

    class b implements Runnable {
        private String mPq;

        b(String str) {
            this.mPq = str;
        }

        public final void run() {
            AppMethodBeat.i(1748);
            long currentTimeMillis = System.currentTimeMillis();
            e.cu(this.mPq);
            ab.i("MicroMsg.TopStory.TopStoryPreloadMgr", "DeleteVideoFolderTask %s %d", this.mPq, Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            AppMethodBeat.o(1748);
        }
    }

    public m() {
        AppMethodBeat.i(1751);
        AppMethodBeat.o(1751);
    }

    public final void d(b bVar) {
        AppMethodBeat.i(1752);
        this.sEV++;
        ab.i("MicroMsg.TopStory.TopStoryPreloadMgr", "onUICreate %d", Integer.valueOf(this.sEV));
        this.sDo = bVar;
        this.sES = g.abz(bVar.cFT().xgj);
        AppMethodBeat.o(1752);
    }

    public final void aEX() {
        AppMethodBeat.i(1753);
        this.sEV--;
        ab.i("MicroMsg.TopStory.TopStoryPreloadMgr", "onUIDestroy %d", Integer.valueOf(this.sEV));
        if (this.sEV <= 0) {
            cGP();
            this.sEU.clear();
            com.tencent.mm.sdk.g.d.post(new b(this.sES), "TopStory.DeleteVideoFolderTask");
            this.sDo = null;
        }
        AppMethodBeat.o(1753);
    }

    public final void cGP() {
        AppMethodBeat.i(1754);
        for (String rO : this.sEU) {
            f.afx().rO(rO);
        }
        AppMethodBeat.o(1754);
    }

    static long aa(long j, long j2) {
        if (j2 != 0) {
            return (100 * j) / j2;
        }
        return 0;
    }
}
