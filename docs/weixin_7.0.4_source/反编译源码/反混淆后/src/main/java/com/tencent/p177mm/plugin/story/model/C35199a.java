package com.tencent.p177mm.plugin.story.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p823ab.C8901a;
import com.tencent.p177mm.plugin.story.model.C43644j.C4133a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.vfs.C5730e;
import com.tencent.p177mm.vfs.FileSystem.C5712a;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import p000a.C0220l;
import p000a.C37091y;
import p000a.p001a.C41363p;
import p000a.p001a.C7987l;
import p000a.p005f.p006a.C31214a;
import p000a.p005f.p007b.C25052j;
import p000a.p005f.p007b.C25053k;
import p000a.p772b.C7992b;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\f\u001a\u00020\rJ\u0006\u0010\u000e\u001a\u00020\rJ \u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u0007XD¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, dWq = {"Lcom/tencent/mm/plugin/story/model/CleanVideoTask;", "", "()V", "MAX_COUNT", "", "MAX_STORY_SIZE", "TAG", "", "getTAG", "()Ljava/lang/String;", "isRun", "", "cancel", "", "cleanCacheFiles", "subDir", "maxStoryCache", "maxStoryCount", "plugin-story_release"})
/* renamed from: com.tencent.mm.plugin.story.model.a */
public final class C35199a {
    final int MAX_COUNT = 100;
    final String TAG = "MicroMsg.GalleryMgr";
    boolean qHJ = true;
    final int rRU = 314572800;

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    /* renamed from: com.tencent.mm.plugin.story.model.a$b */
    static final class C22217b extends C25053k implements C31214a<C37091y> {
        final /* synthetic */ C35199a rRV;

        C22217b(C35199a c35199a) {
            this.rRV = c35199a;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.m2504i(108999);
            try {
                C35199a.m57818a(this.rRV, "/pic/", this.rRV.rRU / 10, this.rRV.MAX_COUNT);
                C35199a.m57818a(this.rRV, "/video/", this.rRV.rRU, this.rRV.MAX_COUNT);
            } catch (Exception e) {
                C4990ab.printErrStackTrace(this.rRV.TAG, e, "", new Object[0]);
            }
            C37091y c37091y = C37091y.AUy;
            AppMethodBeat.m2505o(108999);
            return c37091y;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u001e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, dWq = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"})
    /* renamed from: com.tencent.mm.plugin.story.model.a$a */
    public static final class C29299a<T> implements Comparator<T> {
        public final int compare(T t, T t2) {
            AppMethodBeat.m2504i(108998);
            int a = C7992b.m14176a(Long.valueOf(((C5712a) t).zYM), Long.valueOf(((C5712a) t2).zYM));
            AppMethodBeat.m2505o(108998);
            return a;
        }
    }

    /* renamed from: a */
    public static final /* synthetic */ void m57818a(C35199a c35199a, String str, int i, int i2) {
        AppMethodBeat.m2504i(109000);
        C8901a c8901a = new C8901a("dumpCacheDir ".concat(String.valueOf(str)));
        StringBuilder stringBuilder = new StringBuilder();
        C4133a c4133a = C43644j.rST;
        String stringBuilder2 = stringBuilder.append(C4133a.getAccStoryCachePath()).append(str).toString();
        List cl = C5730e.m8627cl(stringBuilder2, true);
        if (cl != null) {
            long j;
            long j2;
            int i3;
            C5712a c5712a;
            C29309l c29309l;
            String str2;
            if (cl.size() > 1) {
                C41363p.m72150a(cl, new C29299a());
            }
            long j3 = 0;
            Iterator it = cl.iterator();
            while (true) {
                j = j3;
                if (!it.hasNext()) {
                    break;
                }
                C5712a c5712a2 = (C5712a) it.next();
                j3 = (c5712a2 != null ? c5712a2.size : 0) + j;
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
            C4990ab.m7416i(c35199a.TAG, "cleanCacheFiles cache " + stringBuilder2 + "  sumSize:" + j + " targetSize:" + j2 + "  targetCount" + i3);
            long j4 = 0;
            C35199a c35199a2 = c35199a;
            int i4 = 0;
            long j5 = j2;
            for (Object next : cl) {
                int i5 = i4 + 1;
                if (i4 < 0) {
                    C7987l.dWs();
                }
                c5712a = (C5712a) next;
                if (c5712a != null) {
                    if (!c35199a2.qHJ) {
                        break;
                    }
                    c29309l = C29309l.rTg;
                    str2 = c5712a.name;
                    C25052j.m39375o(str2, "fileEntry.name");
                    if (!C29309l.aaz(str2)) {
                        if (C5046bo.m7566gb(c5712a.zYM) <= 86400000) {
                            break;
                        }
                        C4990ab.m7416i(c35199a2.TAG, "cleanCacheFiles1 " + i4 + " filePath: " + c5712a.name + " time: " + c5712a.zYM + " size: " + C5046bo.m7565ga(c5712a.size));
                        j2 = c5712a.size + j4;
                        j5 -= c5712a.size;
                        i3--;
                        C5730e.deleteFile(c5712a.zYK);
                        j4 = j2;
                        i4 = i5;
                    }
                }
                i4 = i5;
            }
            if (j5 > 0 || i3 > 0) {
                c35199a2 = c35199a;
                int i6 = 0;
                for (Object next2 : cl) {
                    int i7 = i6 + 1;
                    if (i6 < 0) {
                        C7987l.dWs();
                    }
                    c5712a = (C5712a) next2;
                    if (c5712a != null) {
                        if (!c35199a2.qHJ) {
                            break;
                        }
                        C4990ab.m7416i(c35199a2.TAG, "cleanCacheFiles2 " + i6 + " filePath: " + c5712a.name + " time: " + c5712a.zYM + " size: " + C5046bo.m7565ga(c5712a.size));
                        c29309l = C29309l.rTg;
                        str2 = c5712a.name;
                        C25052j.m39375o(str2, "fileEntry.name");
                        if (!C29309l.aaz(str2)) {
                            j4 += c5712a.size;
                            j5 -= c5712a.size;
                            i3--;
                            C5730e.deleteFile(c5712a.zYK);
                            if (j5 <= 0 && i3 <= 0) {
                                break;
                            }
                        }
                        continue;
                    }
                    i6 = i7;
                }
            }
            C4990ab.m7416i(c35199a.TAG, "cleanCacheFiles totalSize " + C5046bo.m7565ga(j) + " newsize " + (j - j4) + " fileSize:" + cl.size() + " cost:" + c8901a);
        }
        AppMethodBeat.m2505o(109000);
    }
}
