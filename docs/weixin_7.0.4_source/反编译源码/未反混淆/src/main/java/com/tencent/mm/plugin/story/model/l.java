package com.tencent.mm.plugin.story.model;

import a.a.p;
import a.b.b;
import a.f.b.j;
import a.k.d;
import a.o;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vfs.e;
import java.util.Comparator;
import java.util.List;

@a.l(dWo = {1, 1, 13}, dWp = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u001a\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0018\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0015\u001a\u00020\u0004H\u0002J\b\u0010\u0016\u001a\u00020\u0004H\u0002J\u001a\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00042\b\u0010\u0019\u001a\u0004\u0018\u00010\u0004H\u0002J\u0012\u0010\u001a\u001a\u00020\u00042\b\u0010\u001b\u001a\u0004\u0018\u00010\u0004H\u0002J\b\u0010\u001c\u001a\u00020\u0004H\u0002J\b\u0010\u001d\u001a\u00020\u0004H\u0002J\u0018\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00042\b\b\u0002\u0010!\u001a\u00020\"J\u0006\u0010#\u001a\u00020\u001fJ\u000e\u0010$\u001a\u00020\u00042\u0006\u0010%\u001a\u00020\u0004J\u0006\u0010&\u001a\u00020\u0004J\u001c\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020(0'2\u0006\u0010)\u001a\u00020\u0004H\u0002J\u0012\u0010*\u001a\u00020\u00042\b\u0010+\u001a\u0004\u0018\u00010\u0004H\u0007J\u0012\u0010,\u001a\u00020\u00042\b\u0010+\u001a\u0004\u0018\u00010\u0004H\u0007J\u0012\u0010-\u001a\u00020\u00042\b\u0010+\u001a\u0004\u0018\u00010\u0004H\u0007J\u0006\u0010.\u001a\u00020\u001fJ\u000e\u0010/\u001a\u00020\"2\u0006\u00100\u001a\u00020\u0004J\u0012\u00101\u001a\u00020\"2\b\u00102\u001a\u0004\u0018\u00010\u0004H\u0002J\u0010\u00103\u001a\u00020\u00042\b\u00104\u001a\u0004\u0018\u00010\u0004J\u0006\u00105\u001a\u00020\u001fJ\u0006\u00106\u001a\u00020\u001fJ\u001a\u00107\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00042\b\u0010\u0019\u001a\u0004\u0018\u00010\u0004H\u0002J\u001a\u00108\u001a\u00020\u00042\b\u00109\u001a\u0004\u0018\u00010\u00042\b\u00104\u001a\u0004\u0018\u00010\u0004J\u001a\u0010:\u001a\u00020\u00042\b\u00109\u001a\u0004\u0018\u00010\u00042\b\u00104\u001a\u0004\u0018\u00010\u0004J\u0010\u0010;\u001a\u00020\u00042\b\u0010\u0019\u001a\u0004\u0018\u00010\u0004J\u001a\u0010<\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00042\b\u0010\u0019\u001a\u0004\u0018\u00010\u0004H\u0002J\u001a\u0010=\u001a\u00020\u00042\b\u00109\u001a\u0004\u0018\u00010\u00042\b\u00104\u001a\u0004\u0018\u00010\u0004J\u0010\u0010>\u001a\u00020\u00042\b\u0010\u0019\u001a\u0004\u0018\u00010\u0004J\u0010\u0010?\u001a\u00020\u00042\b\u0010\u0019\u001a\u0004\u0018\u00010\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006@"}, dWq = {"Lcom/tencent/mm/plugin/story/model/StoryFileNameUtil;", "", "()V", "MIX_AUDIO_FILE", "", "MIX_CP_DIR", "MIX_DIR", "MIX_THUMB_FILE", "MIX_VIDEO_FILE", "PICFILE", "PIC_FILE", "TAG", "TMP_FILE", "UP_FILE", "VIDEOFILE", "VIDEO_FILE", "selfName", "getSelfName", "()Ljava/lang/String;", "setSelfName", "(Ljava/lang/String;)V", "accMixStoryPath", "accPath", "audioEnsurePath", "parentPath", "mediaId", "autoPath", "user", "cachePath", "checkSelfName", "checkToCreateDir", "", "newVideoPath", "noMedia", "", "cleanFiles", "copyCacheDir", "path", "dumpCacheDir", "Lkotlin/Pair;", "", "subDir", "getMixAudioPath", "localId", "getMixThumbPath", "getMixVideoPath", "init", "isNoMedia", "name", "isSelf", "userName", "primaryPathVideoPath", "username", "reset", "testCreateFiles", "thumbEnsurePath", "thumbPath", "url", "thumbPathInDownload", "thumbPathInUpload", "videoEnsurePath", "videoPath", "videoPathInDownload", "videoPathInUpload", "plugin-story_release"})
public final class l {
    private static String ecX = "";
    public static final l rTg = new l();

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\u001e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, dWq = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"})
    public static final class a<T> implements Comparator<T> {
        public final int compare(T t, T t2) {
            AppMethodBeat.i(109097);
            int a = b.a(Long.valueOf(((com.tencent.mm.vfs.FileSystem.a) t).zYM), Long.valueOf(((com.tencent.mm.vfs.FileSystem.a) t2).zYM));
            AppMethodBeat.o(109097);
            return a;
        }
    }

    static {
        AppMethodBeat.i(109117);
        AppMethodBeat.o(109117);
    }

    private l() {
    }

    public static void reset() {
        ecX = "";
    }

    private static String cyj() {
        AppMethodBeat.i(109098);
        StringBuilder stringBuilder = new StringBuilder();
        com.tencent.mm.plugin.story.model.j.a aVar = j.rST;
        String stringBuilder2 = stringBuilder.append(com.tencent.mm.plugin.story.model.j.a.getAccStoryPath()).append("coming/").toString();
        AppMethodBeat.o(109098);
        return stringBuilder2;
    }

    static String cyk() {
        AppMethodBeat.i(139083);
        com.tencent.mm.plugin.story.model.j.a aVar = j.rST;
        String accStoryPath = com.tencent.mm.plugin.story.model.j.a.getAccStoryPath();
        AppMethodBeat.o(139083);
        return accStoryPath;
    }

    static String cyl() {
        AppMethodBeat.i(109100);
        com.tencent.mm.plugin.story.model.j.a aVar = j.rST;
        String accStoryCachePath = com.tencent.mm.plugin.story.model.j.a.getAccStoryCachePath();
        AppMethodBeat.o(109100);
        return accStoryCachePath;
    }

    public static String gv(String str, String str2) {
        AppMethodBeat.i(109102);
        String str3;
        if (str2 == null) {
            str3 = "";
            AppMethodBeat.o(109102);
            return str3;
        }
        str3 = str + str2 + ".p";
        AppMethodBeat.o(109102);
        return str3;
    }

    private static String gw(String str, String str2) {
        AppMethodBeat.i(109103);
        String str3;
        if (str2 == null) {
            str3 = "";
            AppMethodBeat.o(109103);
            return str3;
        }
        str3 = str + str2 + ".v";
        AppMethodBeat.o(109103);
        return str3;
    }

    public static String gx(String str, String str2) {
        AppMethodBeat.i(109104);
        String str3;
        if (str == null) {
            str3 = "";
            AppMethodBeat.o(109104);
            return str3;
        }
        str3 = aar(str2) + "/pic/";
        byte[] bytes = str.getBytes(d.UTF_8);
        j.o(bytes, "(this as java.lang.String).getBytes(charset)");
        str3 = gv(str3, g.x(bytes));
        AppMethodBeat.o(109104);
        return str3;
    }

    public static String gy(String str, String str2) {
        AppMethodBeat.i(109105);
        String str3;
        if (str == null) {
            str3 = "";
            AppMethodBeat.o(109105);
            return str3;
        }
        str3 = aar(str2) + "/video/";
        byte[] bytes = str.getBytes(d.UTF_8);
        j.o(bytes, "(this as java.lang.String).getBytes(charset)");
        str3 = gw(str3, g.x(bytes));
        AppMethodBeat.o(109105);
        return str3;
    }

    public static String aas(String str) {
        AppMethodBeat.i(109106);
        String str2;
        if (str == null) {
            str2 = "";
            AppMethodBeat.o(109106);
            return str2;
        }
        StringBuilder stringBuilder = new StringBuilder();
        com.tencent.mm.plugin.story.model.j.a aVar = j.rST;
        str2 = stringBuilder.append(gv(com.tencent.mm.plugin.story.model.j.a.getAccStoryPath(), str)).append(".u").toString();
        AppMethodBeat.o(109106);
        return str2;
    }

    public static String aat(String str) {
        AppMethodBeat.i(109107);
        String str2;
        if (str == null) {
            str2 = "";
            AppMethodBeat.o(109107);
            return str2;
        }
        StringBuilder stringBuilder = new StringBuilder();
        com.tencent.mm.plugin.story.model.j.a aVar = j.rST;
        str2 = stringBuilder.append(gw(com.tencent.mm.plugin.story.model.j.a.getAccStoryPath(), str)).append(".u").toString();
        AppMethodBeat.o(109107);
        return str2;
    }

    public static final String aau(String str) {
        AppMethodBeat.i(109108);
        String str2;
        if (str == null) {
            str2 = "";
            AppMethodBeat.o(109108);
            return str2;
        }
        str2 = gw(cyj(), str) + ".mixv";
        AppMethodBeat.o(109108);
        return str2;
    }

    public static final String aav(String str) {
        AppMethodBeat.i(109109);
        String str2;
        if (str == null) {
            str2 = "";
            AppMethodBeat.o(109109);
            return str2;
        }
        str2 = gv(cyj(), str) + ".mixt";
        AppMethodBeat.o(109109);
        return str2;
    }

    public static final String aaw(String str) {
        AppMethodBeat.i(109110);
        String str2;
        if (str == null) {
            str2 = "";
            AppMethodBeat.o(109110);
            return str2;
        }
        StringBuilder stringBuilder = new StringBuilder();
        str2 = cyj();
        if (str == null) {
            str2 = "";
        } else {
            str2 = str2 + str + ".p";
        }
        str2 = stringBuilder.append(str2).append(".mixa").toString();
        AppMethodBeat.o(109110);
        return str2;
    }

    public static /* synthetic */ void aay(String str) {
        AppMethodBeat.i(109112);
        aax(str);
        AppMethodBeat.o(109112);
    }

    public static void aax(String str) {
        AppMethodBeat.i(109111);
        j.p(str, "newVideoPath");
        if ((((CharSequence) str).length() == 0 ? 1 : null) != null) {
            AppMethodBeat.o(109111);
            return;
        }
        String atb = e.atb(str);
        e.tf(atb);
        e.ate(atb);
        AppMethodBeat.o(109111);
    }

    public static boolean aaz(String str) {
        AppMethodBeat.i(109113);
        j.p(str, "name");
        if (j.j(".nomedia", str)) {
            AppMethodBeat.o(109113);
            return true;
        }
        AppMethodBeat.o(109113);
        return false;
    }

    public static String cym() {
        AppMethodBeat.i(109114);
        com.tencent.mm.ab.a aVar = new com.tencent.mm.ab.a("dumpCacheDir");
        o aaA = aaA("/pic/");
        o aaA2 = aaA("/video/");
        String str = ((String) aaA.first) + "  " + ((String) aaA2.first) + " total: " + bo.my(((Number) aaA2.second).longValue() + ((Number) aaA.second).longValue());
        AppMethodBeat.o(109114);
        return str;
    }

    private static o<String, Long> aaA(String str) {
        AppMethodBeat.i(109115);
        com.tencent.mm.ab.a aVar = new com.tencent.mm.ab.a("dumpCacheDir");
        StringBuilder stringBuilder = new StringBuilder();
        com.tencent.mm.plugin.story.model.j.a aVar2 = j.rST;
        String stringBuilder2 = stringBuilder.append(com.tencent.mm.plugin.story.model.j.a.getAccStoryCachePath()).append(str).toString();
        ab.i("MicroMsg.StoryFileNameUtil", "dumpCacheDir cache ".concat(String.valueOf(stringBuilder2)));
        List cl = e.cl(stringBuilder2, true);
        if (cl != null && cl.size() > 1) {
            p.a(cl, new a());
        }
        long j = 0;
        if (cl != null) {
            int i = 0;
            for (Object next : cl) {
                int i2 = i + 1;
                if (i < 0) {
                    a.a.l.dWs();
                }
                com.tencent.mm.vfs.FileSystem.a aVar3 = (com.tencent.mm.vfs.FileSystem.a) next;
                if (aVar3 != null) {
                    ab.i("MicroMsg.StoryFileNameUtil", "dumpCacheDir " + i + " filePath: " + aVar3.name + " time: " + aVar3.zYM + " size: " + bo.ga(aVar3.size) + ' ' + aVar3.zYK);
                    String str2 = aVar3.name;
                    j.o(str2, "fileEntry.name");
                    if (!aaz(str2)) {
                        j += aVar3.size;
                    }
                }
                i = i2;
            }
        }
        stringBuilder2 = "dumpCacheDir " + str + " totalSize " + bo.ga(j) + " fileCounts " + (cl != null ? Integer.valueOf(cl.size()) : null) + " cost:" + aVar + " \n";
        ab.i("MicroMsg.StoryFileNameUtil", stringBuilder2);
        o oVar = new o(stringBuilder2, Long.valueOf(j));
        AppMethodBeat.o(109115);
        return oVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x0058  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x003e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static String aar(String str) {
        Object obj = 1;
        AppMethodBeat.i(109101);
        CharSequence charSequence = str;
        Object obj2 = (charSequence == null || charSequence.length() == 0) ? 1 : null;
        if (obj2 == null) {
            charSequence = ecX;
            if (charSequence == null || charSequence.length() == 0) {
                obj2 = 1;
            } else {
                obj2 = null;
            }
            com.tencent.mm.plugin.story.model.j.a aVar;
            if (obj2 != null) {
                charSequence = ecX;
                if (!(charSequence == null || charSequence.length() == 0)) {
                    obj = null;
                }
                if (obj != null) {
                    aVar = j.rST;
                    ecX = com.tencent.mm.plugin.story.model.j.a.cnk();
                }
            } else if (j.j(ecX, str)) {
                int i = 1;
                String accStoryPath;
                if (obj2 == null) {
                    aVar = j.rST;
                    accStoryPath = com.tencent.mm.plugin.story.model.j.a.getAccStoryPath();
                    AppMethodBeat.o(109101);
                    return accStoryPath;
                }
                aVar = j.rST;
                accStoryPath = com.tencent.mm.plugin.story.model.j.a.getAccStoryCachePath();
                AppMethodBeat.o(109101);
                return accStoryPath;
            }
        }
        obj2 = null;
        if (obj2 == null) {
        }
    }

    public static void cyn() {
        AppMethodBeat.i(109116);
        com.tencent.mm.plugin.story.model.j.a aVar = j.rST;
        String accStoryCachePath = com.tencent.mm.plugin.story.model.j.a.getAccStoryCachePath();
        ab.i("MicroMsg.StoryFileNameUtil", "dumpCacheDir cache ".concat(String.valueOf(accStoryCachePath)));
        List cl = e.cl(accStoryCachePath, true);
        for (int i = 0; i < 100; i++) {
            j.o(cl, "files");
            int i2 = 0;
            for (Object next : cl) {
                int i3 = i2 + 1;
                if (i2 < 0) {
                    a.a.l.dWs();
                }
                com.tencent.mm.vfs.FileSystem.a aVar2 = (com.tencent.mm.vfs.FileSystem.a) next;
                String str = aVar2.name;
                j.o(str, "it.name");
                if (!aaz(str)) {
                    e.y(aVar2.zYK, aVar2.zYK + System.currentTimeMillis());
                    if (i2 > 2) {
                        break;
                    }
                }
                i2 = i3;
            }
        }
        ab.i("MicroMsg.StoryFileNameUtil", "testCreateFiles done cache ".concat(String.valueOf(accStoryCachePath)));
        AppMethodBeat.o(109116);
    }
}
