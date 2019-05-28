package com.tencent.p177mm.plugin.topstory.p541ui.video;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p178a.C1173e;
import com.tencent.p177mm.p187al.C37461f;
import com.tencent.p177mm.p235i.C18496c;
import com.tencent.p177mm.p235i.C42130g.C1628a;
import com.tencent.p177mm.p235i.C42130g.C1629b;
import com.tencent.p177mm.p235i.C9545d;
import com.tencent.p177mm.plugin.topstory.p539a.C39964g;
import com.tencent.p177mm.plugin.topstory.p541ui.C4210c;
import com.tencent.p177mm.pluginsdk.p1079f.C14835h;
import com.tencent.p177mm.protocal.protobuf.chw;
import com.tencent.p177mm.protocal.protobuf.chx;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
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

/* renamed from: com.tencent.mm.plugin.topstory.ui.video.m */
public final class C13979m {
    C4232b sDo;
    String sES;
    Map<String, chx> sET = Collections.synchronizedMap(new HashMap());
    Set<String> sEU = Collections.synchronizedSet(new HashSet());
    private int sEV = 0;

    /* renamed from: com.tencent.mm.plugin.topstory.ui.video.m$d */
    class C13980d implements C1628a {
        private C13980d() {
        }

        /* synthetic */ C13980d(C13979m c13979m, byte b) {
            this();
        }

        /* renamed from: a */
        public final int mo5082a(String str, int i, C18496c c18496c, C9545d c9545d, boolean z) {
            AppMethodBeat.m2504i(1750);
            if (c18496c != null && c18496c.field_toltalLength > 0 && C13979m.this.sET.containsKey(str)) {
                chx chx = (chx) C13979m.this.sET.get(str);
                chx.xhj = (long) c18496c.field_finishedLength;
                chx.xhk = C13979m.m22110aa((long) c18496c.field_finishedLength, (long) c18496c.field_toltalLength);
                chx.xha = (long) c18496c.field_toltalLength;
                C13979m.this.sET.put(str, chx);
            }
            AppMethodBeat.m2505o(1750);
            return 0;
        }

        /* renamed from: a */
        public final void mo5083a(String str, ByteArrayOutputStream byteArrayOutputStream) {
        }

        /* renamed from: l */
        public final byte[] mo5084l(String str, byte[] bArr) {
            return new byte[0];
        }
    }

    /* renamed from: com.tencent.mm.plugin.topstory.ui.video.m$a */
    class C13981a implements Runnable {
        private String mPq;

        /* renamed from: com.tencent.mm.plugin.topstory.ui.video.m$a$1 */
        class C139781 implements Comparator<File> {
            C139781() {
            }

            public final /* synthetic */ int compare(Object obj, Object obj2) {
                AppMethodBeat.m2504i(1746);
                int lastModified = (int) (((File) obj2).lastModified() - ((File) obj).lastModified());
                AppMethodBeat.m2505o(1746);
                return lastModified;
            }
        }

        C13981a(String str) {
            this.mPq = str;
        }

        /* JADX WARNING: Removed duplicated region for block: B:21:0x00e0  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void run() {
            AppMethodBeat.m2504i(1747);
            File file = new File(this.mPq);
            if (file.exists()) {
                File[] listFiles = file.listFiles();
                String str = "MicroMsg.TopStory.TopStoryPreloadMgr";
                String str2 = "DeleteVideoCacheTask preloadSize: %d cacheSize: %d folderSize: %d";
                Object[] objArr = new Object[3];
                objArr[0] = Integer.valueOf(C13979m.this.sEU.size());
                objArr[1] = Integer.valueOf(C13979m.this.sET.size());
                objArr[2] = Integer.valueOf(listFiles != null ? listFiles.length : 0);
                C4990ab.m7417i(str, str2, objArr);
                if (listFiles != null && listFiles.length > 10) {
                    ArrayList arrayList = new ArrayList(listFiles.length);
                    for (Object add : listFiles) {
                        arrayList.add(add);
                    }
                    Collections.sort(arrayList, new C139781());
                    C4990ab.m7417i("MicroMsg.TopStory.TopStoryPreloadMgr", "First: %s Last: %s", C14835h.formatTime("yyyy-MM-dd HH:mm:ss", ((File) arrayList.get(0)).lastModified() / 1000), C14835h.formatTime("yyyy-MM-dd HH:mm:ss", ((File) arrayList.get(arrayList.size() - 1)).lastModified() / 1000));
                    List<File> subList = arrayList.subList(10, arrayList.size());
                    String str3 = "";
                    if (C13979m.this.sDo != null) {
                        chw chw = C13979m.this.sDo.cFV().sFv;
                        if (chw != null) {
                            Object au = C4210c.m6559au(chw.xgS, chw.xgT);
                            for (File file2 : subList) {
                                str2 = file2.getName().split("\\.")[0];
                                if (!(str2.equals(au) || C13979m.this.sEU.contains(str2))) {
                                    C4990ab.m7417i("MicroMsg.TopStory.TopStoryPreloadMgr", "Delete cache video %s %s", file2.getName(), C14835h.formatTime("yyyy-MM-dd HH:mm:ss", file2.lastModified() / 1000));
                                    C13979m.this.sET.remove(str2);
                                    file2.delete();
                                }
                            }
                        }
                    }
                    String au2 = str3;
                    for (File file22 : subList) {
                    }
                }
                AppMethodBeat.m2505o(1747);
                return;
            }
            C4990ab.m7417i("MicroMsg.TopStory.TopStoryPreloadMgr", "DeleteVideoCacheTask folder %s not exist", this.mPq);
            AppMethodBeat.m2505o(1747);
        }
    }

    /* renamed from: com.tencent.mm.plugin.topstory.ui.video.m$c */
    class C13982c implements C1629b {
        private C13982c() {
        }

        /* synthetic */ C13982c(C13979m c13979m, byte b) {
            this();
        }

        /* renamed from: a */
        public final void mo5085a(String str, C9545d c9545d) {
            AppMethodBeat.m2504i(1749);
            if (C13979m.this.sET.containsKey(str)) {
                chx chx = (chx) C13979m.this.sET.get(str);
                chx.xhj = (long) c9545d.field_recvedBytes;
                chx.xhk = C13979m.m22110aa(chx.xhj, (long) c9545d.field_fileLength);
                chx.xha = (long) c9545d.field_fileLength;
                C13979m.this.sET.put(str, chx);
                C4990ab.m7417i("MicroMsg.TopStory.TopStoryPreloadMgr", "VideoPreloadCallback onFinish %s %d %s", str, Long.valueOf(chx.xhk), C5046bo.m7526b(chx.xhj, 100.0d));
            }
            AppMethodBeat.m2505o(1749);
        }
    }

    /* renamed from: com.tencent.mm.plugin.topstory.ui.video.m$b */
    class C13983b implements Runnable {
        private String mPq;

        C13983b(String str) {
            this.mPq = str;
        }

        public final void run() {
            AppMethodBeat.m2504i(1748);
            long currentTimeMillis = System.currentTimeMillis();
            C1173e.m2562cu(this.mPq);
            C4990ab.m7417i("MicroMsg.TopStory.TopStoryPreloadMgr", "DeleteVideoFolderTask %s %d", this.mPq, Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            AppMethodBeat.m2505o(1748);
        }
    }

    public C13979m() {
        AppMethodBeat.m2504i(1751);
        AppMethodBeat.m2505o(1751);
    }

    /* renamed from: d */
    public final void mo26212d(C4232b c4232b) {
        AppMethodBeat.m2504i(1752);
        this.sEV++;
        C4990ab.m7417i("MicroMsg.TopStory.TopStoryPreloadMgr", "onUICreate %d", Integer.valueOf(this.sEV));
        this.sDo = c4232b;
        this.sES = C39964g.abz(c4232b.cFT().xgj);
        AppMethodBeat.m2505o(1752);
    }

    public final void aEX() {
        AppMethodBeat.m2504i(1753);
        this.sEV--;
        C4990ab.m7417i("MicroMsg.TopStory.TopStoryPreloadMgr", "onUIDestroy %d", Integer.valueOf(this.sEV));
        if (this.sEV <= 0) {
            cGP();
            this.sEU.clear();
            C7305d.post(new C13983b(this.sES), "TopStory.DeleteVideoFolderTask");
            this.sDo = null;
        }
        AppMethodBeat.m2505o(1753);
    }

    public final void cGP() {
        AppMethodBeat.m2504i(1754);
        for (String rO : this.sEU) {
            C37461f.afx().mo51228rO(rO);
        }
        AppMethodBeat.m2505o(1754);
    }

    /* renamed from: aa */
    static long m22110aa(long j, long j2) {
        if (j2 != 0) {
            return (100 * j) / j2;
        }
        return 0;
    }
}
