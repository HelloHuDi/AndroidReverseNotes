package com.tencent.p177mm.plugin.story.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1706e;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.vfs.C5728b;
import com.tencent.p177mm.vfs.C5730e;
import com.tencent.ttpic.baseutils.FileUtils;
import java.util.Comparator;
import p000a.C0220l;
import p000a.p001a.C36646h;
import p000a.p005f.p007b.C25052j;
import p000a.p772b.C7992b;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, dWq = {"Lcom/tencent/mm/plugin/story/model/StoryConstants;", "", "()V", "Companion", "plugin-story_release"})
/* renamed from: com.tencent.mm.plugin.story.model.i */
public final class C43641i {
    private static String rSr;
    private static final String rSs = (rSr + "temp/");
    private static final String rSt = (rSr + "mix/");
    private static final String rSu = (rSr + "audio/");
    public static final C43642a rSv = new C43642a();

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0015\u001a\u00020\u0016H\u0007J\b\u0010\u0017\u001a\u00020\u0016H\u0007J\b\u0010\u0018\u001a\u00020\u0016H\u0007J\u0010\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u001bH\u0007J\u0010\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u001bH\u0007J\u0010\u0010\u001d\u001a\u00020\u00162\u0006\u0010\u001e\u001a\u00020\u0006H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\bR\u001a\u0010\u000b\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\bR\u000e\u0010\u0011\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u001f"}, dWq = {"Lcom/tencent/mm/plugin/story/model/StoryConstants$Companion;", "", "()V", "STORY_DEPRECATED_TIME_SECOND", "", "StoryAudioPath", "", "getStoryAudioPath", "()Ljava/lang/String;", "StoryMixPath", "getStoryMixPath", "StoryRootPath", "getStoryRootPath", "setStoryRootPath", "(Ljava/lang/String;)V", "StoryTempPath", "getStoryTempPath", "StoryTypeImage", "StoryTypeNone", "StoryTypeVideo", "videoRequestMaxThreadCount", "cleanAudioFile", "", "cleanMixFile", "cleanTempData", "getRecordTempPath", "timeStamp", "", "getRecordThumbTempPath", "setup", "accPath", "plugin-story_release"})
    /* renamed from: com.tencent.mm.plugin.story.model.i$a */
    public static final class C43642a {

        @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
        /* renamed from: com.tencent.mm.plugin.story.model.i$a$a */
        public static final class C39908a implements Runnable {
            public static final C39908a rSw = new C39908a();

            @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u001e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, dWq = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"})
            /* renamed from: com.tencent.mm.plugin.story.model.i$a$a$a */
            public static final class C13795a<T> implements Comparator<T> {
                public final int compare(T t, T t2) {
                    AppMethodBeat.m2504i(109034);
                    int a = C7992b.m14176a(Long.valueOf(((C5728b) t2).lastModified()), Long.valueOf(((C5728b) t).lastModified()));
                    AppMethodBeat.m2505o(109034);
                    return a;
                }
            }

            static {
                AppMethodBeat.m2504i(109036);
                AppMethodBeat.m2505o(109036);
            }

            C39908a() {
            }

            public final void run() {
                AppMethodBeat.m2504i(109035);
                C43642a c43642a = C43641i.rSv;
                C5728b[] dMF = new C5728b(C43641i.rSu).dMF();
                if (dMF != null) {
                    if (dMF.length > 1) {
                        C36646h.m60746a(dMF, new C13795a());
                    }
                    int length = dMF.length;
                    int i = 0;
                    int i2 = 0;
                    while (i < length) {
                        C5728b c5728b = dMF[i];
                        int i3 = i2 + 1;
                        if (i2 >= 20) {
                            c5728b.delete();
                        }
                        i++;
                        i2 = i3;
                    }
                }
                AppMethodBeat.m2505o(109035);
            }
        }

        @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
        /* renamed from: com.tencent.mm.plugin.story.model.i$a$b */
        public static final class C43643b implements Runnable {
            public static final C43643b rSx = new C43643b();

            @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u001e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, dWq = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"})
            /* renamed from: com.tencent.mm.plugin.story.model.i$a$b$a */
            public static final class C22240a<T> implements Comparator<T> {
                public final int compare(T t, T t2) {
                    AppMethodBeat.m2504i(109037);
                    int a = C7992b.m14176a(Long.valueOf(((C5728b) t2).lastModified()), Long.valueOf(((C5728b) t).lastModified()));
                    AppMethodBeat.m2505o(109037);
                    return a;
                }
            }

            static {
                AppMethodBeat.m2504i(109039);
                AppMethodBeat.m2505o(109039);
            }

            C43643b() {
            }

            public final void run() {
                AppMethodBeat.m2504i(109038);
                C43642a c43642a = C43641i.rSv;
                C5728b[] dMF = new C5728b(C43641i.rSt).dMF();
                if (dMF != null) {
                    if (dMF.length > 1) {
                        C36646h.m60746a(dMF, new C22240a());
                    }
                    int length = dMF.length;
                    int i = 0;
                    int i2 = 0;
                    while (i < length) {
                        C5728b c5728b = dMF[i];
                        int i3 = i2 + 1;
                        if (i2 >= 4) {
                            c5728b.delete();
                        }
                        i++;
                        i2 = i3;
                    }
                }
                AppMethodBeat.m2505o(109038);
            }
        }

        private C43642a() {
        }

        public /* synthetic */ C43642a(byte b) {
            this();
        }

        /* renamed from: kY */
        public static String m78108kY(long j) {
            AppMethodBeat.m2504i(109040);
            C5730e.m8643tf(C43641i.rSs);
            String str = C43641i.rSs + "thumb" + j + FileUtils.PIC_POSTFIX_JPEG;
            AppMethodBeat.m2505o(109040);
            return str;
        }
    }

    static {
        AppMethodBeat.m2504i(109041);
        StringBuilder stringBuilder = new StringBuilder();
        C1706e RP = C1720g.m3536RP();
        C25052j.m39375o(RP, "MMKernel.storage()");
        rSr = stringBuilder.append(RP.getAccPath()).append("story/").toString();
        AppMethodBeat.m2505o(109041);
    }
}
