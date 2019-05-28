package com.tencent.mm.plugin.story.model;

import a.a.h;
import a.f.b.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.vfs.e;
import com.tencent.ttpic.baseutils.FileUtils;
import java.util.Comparator;

@l(dWo = {1, 1, 13}, dWp = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, dWq = {"Lcom/tencent/mm/plugin/story/model/StoryConstants;", "", "()V", "Companion", "plugin-story_release"})
public final class i {
    private static String rSr;
    private static final String rSs = (rSr + "temp/");
    private static final String rSt = (rSr + "mix/");
    private static final String rSu = (rSr + "audio/");
    public static final a rSv = new a();

    @l(dWo = {1, 1, 13}, dWp = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0015\u001a\u00020\u0016H\u0007J\b\u0010\u0017\u001a\u00020\u0016H\u0007J\b\u0010\u0018\u001a\u00020\u0016H\u0007J\u0010\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u001bH\u0007J\u0010\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u001bH\u0007J\u0010\u0010\u001d\u001a\u00020\u00162\u0006\u0010\u001e\u001a\u00020\u0006H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\bR\u001a\u0010\u000b\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\bR\u000e\u0010\u0011\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u001f"}, dWq = {"Lcom/tencent/mm/plugin/story/model/StoryConstants$Companion;", "", "()V", "STORY_DEPRECATED_TIME_SECOND", "", "StoryAudioPath", "", "getStoryAudioPath", "()Ljava/lang/String;", "StoryMixPath", "getStoryMixPath", "StoryRootPath", "getStoryRootPath", "setStoryRootPath", "(Ljava/lang/String;)V", "StoryTempPath", "getStoryTempPath", "StoryTypeImage", "StoryTypeNone", "StoryTypeVideo", "videoRequestMaxThreadCount", "cleanAudioFile", "", "cleanMixFile", "cleanTempData", "getRecordTempPath", "timeStamp", "", "getRecordThumbTempPath", "setup", "accPath", "plugin-story_release"})
    public static final class a {

        @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
        public static final class a implements Runnable {
            public static final a rSw = new a();

            @l(dWo = {1, 1, 13}, dWp = {"\u0000\u001e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, dWq = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"})
            public static final class a<T> implements Comparator<T> {
                public final int compare(T t, T t2) {
                    AppMethodBeat.i(109034);
                    int a = a.b.b.a(Long.valueOf(((com.tencent.mm.vfs.b) t2).lastModified()), Long.valueOf(((com.tencent.mm.vfs.b) t).lastModified()));
                    AppMethodBeat.o(109034);
                    return a;
                }
            }

            static {
                AppMethodBeat.i(109036);
                AppMethodBeat.o(109036);
            }

            a() {
            }

            public final void run() {
                AppMethodBeat.i(109035);
                a aVar = i.rSv;
                com.tencent.mm.vfs.b[] dMF = new com.tencent.mm.vfs.b(i.rSu).dMF();
                if (dMF != null) {
                    if (dMF.length > 1) {
                        h.a(dMF, new a());
                    }
                    int length = dMF.length;
                    int i = 0;
                    int i2 = 0;
                    while (i < length) {
                        com.tencent.mm.vfs.b bVar = dMF[i];
                        int i3 = i2 + 1;
                        if (i2 >= 20) {
                            bVar.delete();
                        }
                        i++;
                        i2 = i3;
                    }
                }
                AppMethodBeat.o(109035);
            }
        }

        @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
        public static final class b implements Runnable {
            public static final b rSx = new b();

            @l(dWo = {1, 1, 13}, dWp = {"\u0000\u001e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, dWq = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"})
            public static final class a<T> implements Comparator<T> {
                public final int compare(T t, T t2) {
                    AppMethodBeat.i(109037);
                    int a = a.b.b.a(Long.valueOf(((com.tencent.mm.vfs.b) t2).lastModified()), Long.valueOf(((com.tencent.mm.vfs.b) t).lastModified()));
                    AppMethodBeat.o(109037);
                    return a;
                }
            }

            static {
                AppMethodBeat.i(109039);
                AppMethodBeat.o(109039);
            }

            b() {
            }

            public final void run() {
                AppMethodBeat.i(109038);
                a aVar = i.rSv;
                com.tencent.mm.vfs.b[] dMF = new com.tencent.mm.vfs.b(i.rSt).dMF();
                if (dMF != null) {
                    if (dMF.length > 1) {
                        h.a(dMF, new a());
                    }
                    int length = dMF.length;
                    int i = 0;
                    int i2 = 0;
                    while (i < length) {
                        com.tencent.mm.vfs.b bVar = dMF[i];
                        int i3 = i2 + 1;
                        if (i2 >= 4) {
                            bVar.delete();
                        }
                        i++;
                        i2 = i3;
                    }
                }
                AppMethodBeat.o(109038);
            }
        }

        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }

        public static String kY(long j) {
            AppMethodBeat.i(109040);
            e.tf(i.rSs);
            String str = i.rSs + "thumb" + j + FileUtils.PIC_POSTFIX_JPEG;
            AppMethodBeat.o(109040);
            return str;
        }
    }

    static {
        AppMethodBeat.i(109041);
        StringBuilder stringBuilder = new StringBuilder();
        com.tencent.mm.kernel.e RP = g.RP();
        j.o(RP, "MMKernel.storage()");
        rSr = stringBuilder.append(RP.getAccPath()).append("story/").toString();
        AppMethodBeat.o(109041);
    }
}
