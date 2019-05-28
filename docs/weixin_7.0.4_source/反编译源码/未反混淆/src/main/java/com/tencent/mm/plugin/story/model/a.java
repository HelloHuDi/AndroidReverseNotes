package com.tencent.mm.plugin.story.model;

import a.a.p;
import a.f.b.j;
import a.f.b.k;
import a.l;
import a.y;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vfs.e;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

@l(dWo = {1, 1, 13}, dWp = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\f\u001a\u00020\rJ\u0006\u0010\u000e\u001a\u00020\rJ \u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u0007XD¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, dWq = {"Lcom/tencent/mm/plugin/story/model/CleanVideoTask;", "", "()V", "MAX_COUNT", "", "MAX_STORY_SIZE", "TAG", "", "getTAG", "()Ljava/lang/String;", "isRun", "", "cancel", "", "cleanCacheFiles", "subDir", "maxStoryCache", "maxStoryCount", "plugin-story_release"})
public final class a {
    final int MAX_COUNT = 100;
    final String TAG = "MicroMsg.GalleryMgr";
    boolean qHJ = true;
    final int rRU = 314572800;

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    static final class b extends k implements a.f.a.a<y> {
        final /* synthetic */ a rRV;

        b(a aVar) {
            this.rRV = aVar;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.i(108999);
            try {
                a.a(this.rRV, "/pic/", this.rRV.rRU / 10, this.rRV.MAX_COUNT);
                a.a(this.rRV, "/video/", this.rRV.rRU, this.rRV.MAX_COUNT);
            } catch (Exception e) {
                ab.printErrStackTrace(this.rRV.TAG, e, "", new Object[0]);
            }
            y yVar = y.AUy;
            AppMethodBeat.o(108999);
            return yVar;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u001e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, dWq = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"})
    public static final class a<T> implements Comparator<T> {
        public final int compare(T t, T t2) {
            AppMethodBeat.i(108998);
            int a = a.b.b.a(Long.valueOf(((com.tencent.mm.vfs.FileSystem.a) t).zYM), Long.valueOf(((com.tencent.mm.vfs.FileSystem.a) t2).zYM));
            AppMethodBeat.o(108998);
            return a;
        }
    }

    public static final /* synthetic */ void a(a aVar, String str, int i, int i2) {
        AppMethodBeat.i(109000);
        com.tencent.mm.ab.a aVar2 = new com.tencent.mm.ab.a("dumpCacheDir ".concat(String.valueOf(str)));
        StringBuilder stringBuilder = new StringBuilder();
        com.tencent.mm.plugin.story.model.j.a aVar3 = j.rST;
        String stringBuilder2 = stringBuilder.append(com.tencent.mm.plugin.story.model.j.a.getAccStoryCachePath()).append(str).toString();
        List cl = e.cl(stringBuilder2, true);
        if (cl != null) {
            long j;
            long j2;
            int i3;
            com.tencent.mm.vfs.FileSystem.a aVar4;
            l lVar;
            String str2;
            if (cl.size() > 1) {
                p.a(cl, new a());
            }
            long j3 = 0;
            Iterator it = cl.iterator();
            while (true) {
                j = j3;
                if (!it.hasNext()) {
                    break;
                }
                com.tencent.mm.vfs.FileSystem.a aVar5 = (com.tencent.mm.vfs.FileSystem.a) it.next();
                j3 = (aVar5 != null ? aVar5.size : 0) + j;
            }
            if (j > ((long) i)) {
                j2 = (long) (((double) j) / 2.0d);
            } else {
                j2 = 0;
            }
            int size = cl.size();
            if (size > i2) {
                i3 = i2 - size;
            } else {
                i3 = 0;
            }
            ab.i(aVar.TAG, "cleanCacheFiles cache " + stringBuilder2 + "  sumSize:" + j + " targetSize:" + j2 + "  targetCount" + i3);
            long j4 = 0;
            a aVar6 = aVar;
            int i4 = 0;
            long j5 = j2;
            for (Object next : cl) {
                int i5 = i4 + 1;
                if (i4 < 0) {
                    a.a.l.dWs();
                }
                aVar4 = (com.tencent.mm.vfs.FileSystem.a) next;
                if (aVar4 != null) {
                    if (!aVar6.qHJ) {
                        break;
                    }
                    lVar = l.rTg;
                    str2 = aVar4.name;
                    j.o(str2, "fileEntry.name");
                    if (!l.aaz(str2)) {
                        if (bo.gb(aVar4.zYM) <= 86400000) {
                            break;
                        }
                        ab.i(aVar6.TAG, "cleanCacheFiles1 " + i4 + " filePath: " + aVar4.name + " time: " + aVar4.zYM + " size: " + bo.ga(aVar4.size));
                        j2 = aVar4.size + j4;
                        j5 -= aVar4.size;
                        i3--;
                        e.deleteFile(aVar4.zYK);
                        j4 = j2;
                        i4 = i5;
                    }
                }
                i4 = i5;
            }
            if (j5 > 0 || i3 > 0) {
                aVar6 = aVar;
                int i6 = 0;
                for (Object next2 : cl) {
                    int i7 = i6 + 1;
                    if (i6 < 0) {
                        a.a.l.dWs();
                    }
                    aVar4 = (com.tencent.mm.vfs.FileSystem.a) next2;
                    if (aVar4 != null) {
                        if (!aVar6.qHJ) {
                            break;
                        }
                        ab.i(aVar6.TAG, "cleanCacheFiles2 " + i6 + " filePath: " + aVar4.name + " time: " + aVar4.zYM + " size: " + bo.ga(aVar4.size));
                        lVar = l.rTg;
                        str2 = aVar4.name;
                        j.o(str2, "fileEntry.name");
                        if (!l.aaz(str2)) {
                            j4 += aVar4.size;
                            j5 -= aVar4.size;
                            i3--;
                            e.deleteFile(aVar4.zYK);
                            if (j5 <= 0 && i3 <= 0) {
                                break;
                            }
                        }
                        continue;
                    }
                    i6 = i7;
                }
            }
            ab.i(aVar.TAG, "cleanCacheFiles totalSize " + bo.ga(j) + " newsize " + (j - j4) + " fileSize:" + cl.size() + " cost:" + aVar2);
        }
        AppMethodBeat.o(109000);
    }
}
