package com.tencent.p177mm.plugin.story.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p178a.C1178g;
import com.tencent.p177mm.p823ab.C8901a;
import com.tencent.p177mm.plugin.story.model.C43644j.C4133a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.vfs.C5730e;
import com.tencent.p177mm.vfs.FileSystem.C5712a;
import java.util.Comparator;
import java.util.List;
import p000a.C0220l;
import p000a.C31826o;
import p000a.p001a.C41363p;
import p000a.p001a.C7987l;
import p000a.p005f.p007b.C25052j;
import p000a.p051k.C17355d;
import p000a.p772b.C7992b;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u001a\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0018\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0015\u001a\u00020\u0004H\u0002J\b\u0010\u0016\u001a\u00020\u0004H\u0002J\u001a\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00042\b\u0010\u0019\u001a\u0004\u0018\u00010\u0004H\u0002J\u0012\u0010\u001a\u001a\u00020\u00042\b\u0010\u001b\u001a\u0004\u0018\u00010\u0004H\u0002J\b\u0010\u001c\u001a\u00020\u0004H\u0002J\b\u0010\u001d\u001a\u00020\u0004H\u0002J\u0018\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00042\b\b\u0002\u0010!\u001a\u00020\"J\u0006\u0010#\u001a\u00020\u001fJ\u000e\u0010$\u001a\u00020\u00042\u0006\u0010%\u001a\u00020\u0004J\u0006\u0010&\u001a\u00020\u0004J\u001c\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020(0'2\u0006\u0010)\u001a\u00020\u0004H\u0002J\u0012\u0010*\u001a\u00020\u00042\b\u0010+\u001a\u0004\u0018\u00010\u0004H\u0007J\u0012\u0010,\u001a\u00020\u00042\b\u0010+\u001a\u0004\u0018\u00010\u0004H\u0007J\u0012\u0010-\u001a\u00020\u00042\b\u0010+\u001a\u0004\u0018\u00010\u0004H\u0007J\u0006\u0010.\u001a\u00020\u001fJ\u000e\u0010/\u001a\u00020\"2\u0006\u00100\u001a\u00020\u0004J\u0012\u00101\u001a\u00020\"2\b\u00102\u001a\u0004\u0018\u00010\u0004H\u0002J\u0010\u00103\u001a\u00020\u00042\b\u00104\u001a\u0004\u0018\u00010\u0004J\u0006\u00105\u001a\u00020\u001fJ\u0006\u00106\u001a\u00020\u001fJ\u001a\u00107\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00042\b\u0010\u0019\u001a\u0004\u0018\u00010\u0004H\u0002J\u001a\u00108\u001a\u00020\u00042\b\u00109\u001a\u0004\u0018\u00010\u00042\b\u00104\u001a\u0004\u0018\u00010\u0004J\u001a\u0010:\u001a\u00020\u00042\b\u00109\u001a\u0004\u0018\u00010\u00042\b\u00104\u001a\u0004\u0018\u00010\u0004J\u0010\u0010;\u001a\u00020\u00042\b\u0010\u0019\u001a\u0004\u0018\u00010\u0004J\u001a\u0010<\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00042\b\u0010\u0019\u001a\u0004\u0018\u00010\u0004H\u0002J\u001a\u0010=\u001a\u00020\u00042\b\u00109\u001a\u0004\u0018\u00010\u00042\b\u00104\u001a\u0004\u0018\u00010\u0004J\u0010\u0010>\u001a\u00020\u00042\b\u0010\u0019\u001a\u0004\u0018\u00010\u0004J\u0010\u0010?\u001a\u00020\u00042\b\u0010\u0019\u001a\u0004\u0018\u00010\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006@"}, dWq = {"Lcom/tencent/mm/plugin/story/model/StoryFileNameUtil;", "", "()V", "MIX_AUDIO_FILE", "", "MIX_CP_DIR", "MIX_DIR", "MIX_THUMB_FILE", "MIX_VIDEO_FILE", "PICFILE", "PIC_FILE", "TAG", "TMP_FILE", "UP_FILE", "VIDEOFILE", "VIDEO_FILE", "selfName", "getSelfName", "()Ljava/lang/String;", "setSelfName", "(Ljava/lang/String;)V", "accMixStoryPath", "accPath", "audioEnsurePath", "parentPath", "mediaId", "autoPath", "user", "cachePath", "checkSelfName", "checkToCreateDir", "", "newVideoPath", "noMedia", "", "cleanFiles", "copyCacheDir", "path", "dumpCacheDir", "Lkotlin/Pair;", "", "subDir", "getMixAudioPath", "localId", "getMixThumbPath", "getMixVideoPath", "init", "isNoMedia", "name", "isSelf", "userName", "primaryPathVideoPath", "username", "reset", "testCreateFiles", "thumbEnsurePath", "thumbPath", "url", "thumbPathInDownload", "thumbPathInUpload", "videoEnsurePath", "videoPath", "videoPathInDownload", "videoPathInUpload", "plugin-story_release"})
/* renamed from: com.tencent.mm.plugin.story.model.l */
public final class C29309l {
    private static String ecX = "";
    public static final C29309l rTg = new C29309l();

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u001e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, dWq = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"})
    /* renamed from: com.tencent.mm.plugin.story.model.l$a */
    public static final class C29308a<T> implements Comparator<T> {
        public final int compare(T t, T t2) {
            AppMethodBeat.m2504i(109097);
            int a = C7992b.m14176a(Long.valueOf(((C5712a) t).zYM), Long.valueOf(((C5712a) t2).zYM));
            AppMethodBeat.m2505o(109097);
            return a;
        }
    }

    static {
        AppMethodBeat.m2504i(109117);
        AppMethodBeat.m2505o(109117);
    }

    private C29309l() {
    }

    public static void reset() {
        ecX = "";
    }

    private static String cyj() {
        AppMethodBeat.m2504i(109098);
        StringBuilder stringBuilder = new StringBuilder();
        C4133a c4133a = C43644j.rST;
        String stringBuilder2 = stringBuilder.append(C4133a.getAccStoryPath()).append("coming/").toString();
        AppMethodBeat.m2505o(109098);
        return stringBuilder2;
    }

    static String cyk() {
        AppMethodBeat.m2504i(139083);
        C4133a c4133a = C43644j.rST;
        String accStoryPath = C4133a.getAccStoryPath();
        AppMethodBeat.m2505o(139083);
        return accStoryPath;
    }

    static String cyl() {
        AppMethodBeat.m2504i(109100);
        C4133a c4133a = C43644j.rST;
        String accStoryCachePath = C4133a.getAccStoryCachePath();
        AppMethodBeat.m2505o(109100);
        return accStoryCachePath;
    }

    /* renamed from: gv */
    public static String m46526gv(String str, String str2) {
        AppMethodBeat.m2504i(109102);
        String str3;
        if (str2 == null) {
            str3 = "";
            AppMethodBeat.m2505o(109102);
            return str3;
        }
        str3 = str + str2 + ".p";
        AppMethodBeat.m2505o(109102);
        return str3;
    }

    /* renamed from: gw */
    private static String m46527gw(String str, String str2) {
        AppMethodBeat.m2504i(109103);
        String str3;
        if (str2 == null) {
            str3 = "";
            AppMethodBeat.m2505o(109103);
            return str3;
        }
        str3 = str + str2 + ".v";
        AppMethodBeat.m2505o(109103);
        return str3;
    }

    /* renamed from: gx */
    public static String m46528gx(String str, String str2) {
        AppMethodBeat.m2504i(109104);
        String str3;
        if (str == null) {
            str3 = "";
            AppMethodBeat.m2505o(109104);
            return str3;
        }
        str3 = C29309l.aar(str2) + "/pic/";
        byte[] bytes = str.getBytes(C17355d.UTF_8);
        C25052j.m39375o(bytes, "(this as java.lang.String).getBytes(charset)");
        str3 = C29309l.m46526gv(str3, C1178g.m2591x(bytes));
        AppMethodBeat.m2505o(109104);
        return str3;
    }

    /* renamed from: gy */
    public static String m46529gy(String str, String str2) {
        AppMethodBeat.m2504i(109105);
        String str3;
        if (str == null) {
            str3 = "";
            AppMethodBeat.m2505o(109105);
            return str3;
        }
        str3 = C29309l.aar(str2) + "/video/";
        byte[] bytes = str.getBytes(C17355d.UTF_8);
        C25052j.m39375o(bytes, "(this as java.lang.String).getBytes(charset)");
        str3 = C29309l.m46527gw(str3, C1178g.m2591x(bytes));
        AppMethodBeat.m2505o(109105);
        return str3;
    }

    public static String aas(String str) {
        AppMethodBeat.m2504i(109106);
        String str2;
        if (str == null) {
            str2 = "";
            AppMethodBeat.m2505o(109106);
            return str2;
        }
        StringBuilder stringBuilder = new StringBuilder();
        C4133a c4133a = C43644j.rST;
        str2 = stringBuilder.append(C29309l.m46526gv(C4133a.getAccStoryPath(), str)).append(".u").toString();
        AppMethodBeat.m2505o(109106);
        return str2;
    }

    public static String aat(String str) {
        AppMethodBeat.m2504i(109107);
        String str2;
        if (str == null) {
            str2 = "";
            AppMethodBeat.m2505o(109107);
            return str2;
        }
        StringBuilder stringBuilder = new StringBuilder();
        C4133a c4133a = C43644j.rST;
        str2 = stringBuilder.append(C29309l.m46527gw(C4133a.getAccStoryPath(), str)).append(".u").toString();
        AppMethodBeat.m2505o(109107);
        return str2;
    }

    public static final String aau(String str) {
        AppMethodBeat.m2504i(109108);
        String str2;
        if (str == null) {
            str2 = "";
            AppMethodBeat.m2505o(109108);
            return str2;
        }
        str2 = C29309l.m46527gw(C29309l.cyj(), str) + ".mixv";
        AppMethodBeat.m2505o(109108);
        return str2;
    }

    public static final String aav(String str) {
        AppMethodBeat.m2504i(109109);
        String str2;
        if (str == null) {
            str2 = "";
            AppMethodBeat.m2505o(109109);
            return str2;
        }
        str2 = C29309l.m46526gv(C29309l.cyj(), str) + ".mixt";
        AppMethodBeat.m2505o(109109);
        return str2;
    }

    public static final String aaw(String str) {
        AppMethodBeat.m2504i(109110);
        String str2;
        if (str == null) {
            str2 = "";
            AppMethodBeat.m2505o(109110);
            return str2;
        }
        StringBuilder stringBuilder = new StringBuilder();
        str2 = C29309l.cyj();
        if (str == null) {
            str2 = "";
        } else {
            str2 = str2 + str + ".p";
        }
        str2 = stringBuilder.append(str2).append(".mixa").toString();
        AppMethodBeat.m2505o(109110);
        return str2;
    }

    public static /* synthetic */ void aay(String str) {
        AppMethodBeat.m2504i(109112);
        C29309l.aax(str);
        AppMethodBeat.m2505o(109112);
    }

    public static void aax(String str) {
        AppMethodBeat.m2504i(109111);
        C25052j.m39376p(str, "newVideoPath");
        if ((((CharSequence) str).length() == 0 ? 1 : null) != null) {
            AppMethodBeat.m2505o(109111);
            return;
        }
        String atb = C5730e.atb(str);
        C5730e.m8643tf(atb);
        C5730e.ate(atb);
        AppMethodBeat.m2505o(109111);
    }

    public static boolean aaz(String str) {
        AppMethodBeat.m2504i(109113);
        C25052j.m39376p(str, "name");
        if (C25052j.m39373j(".nomedia", str)) {
            AppMethodBeat.m2505o(109113);
            return true;
        }
        AppMethodBeat.m2505o(109113);
        return false;
    }

    public static String cym() {
        AppMethodBeat.m2504i(109114);
        C8901a c8901a = new C8901a("dumpCacheDir");
        C31826o aaA = C29309l.aaA("/pic/");
        C31826o aaA2 = C29309l.aaA("/video/");
        String str = ((String) aaA.first) + "  " + ((String) aaA2.first) + " total: " + C5046bo.m7580my(((Number) aaA2.second).longValue() + ((Number) aaA.second).longValue());
        AppMethodBeat.m2505o(109114);
        return str;
    }

    private static C31826o<String, Long> aaA(String str) {
        AppMethodBeat.m2504i(109115);
        C8901a c8901a = new C8901a("dumpCacheDir");
        StringBuilder stringBuilder = new StringBuilder();
        C4133a c4133a = C43644j.rST;
        String stringBuilder2 = stringBuilder.append(C4133a.getAccStoryCachePath()).append(str).toString();
        C4990ab.m7416i("MicroMsg.StoryFileNameUtil", "dumpCacheDir cache ".concat(String.valueOf(stringBuilder2)));
        List cl = C5730e.m8627cl(stringBuilder2, true);
        if (cl != null && cl.size() > 1) {
            C41363p.m72150a(cl, new C29308a());
        }
        long j = 0;
        if (cl != null) {
            int i = 0;
            for (Object next : cl) {
                int i2 = i + 1;
                if (i < 0) {
                    C7987l.dWs();
                }
                C5712a c5712a = (C5712a) next;
                if (c5712a != null) {
                    C4990ab.m7416i("MicroMsg.StoryFileNameUtil", "dumpCacheDir " + i + " filePath: " + c5712a.name + " time: " + c5712a.zYM + " size: " + C5046bo.m7565ga(c5712a.size) + ' ' + c5712a.zYK);
                    String str2 = c5712a.name;
                    C25052j.m39375o(str2, "fileEntry.name");
                    if (!C29309l.aaz(str2)) {
                        j += c5712a.size;
                    }
                }
                i = i2;
            }
        }
        stringBuilder2 = "dumpCacheDir " + str + " totalSize " + C5046bo.m7565ga(j) + " fileCounts " + (cl != null ? Integer.valueOf(cl.size()) : null) + " cost:" + c8901a + " \n";
        C4990ab.m7416i("MicroMsg.StoryFileNameUtil", stringBuilder2);
        C31826o c31826o = new C31826o(stringBuilder2, Long.valueOf(j));
        AppMethodBeat.m2505o(109115);
        return c31826o;
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x0058  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x003e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static String aar(String str) {
        Object obj = 1;
        AppMethodBeat.m2504i(109101);
        CharSequence charSequence = str;
        Object obj2 = (charSequence == null || charSequence.length() == 0) ? 1 : null;
        if (obj2 == null) {
            charSequence = ecX;
            if (charSequence == null || charSequence.length() == 0) {
                obj2 = 1;
            } else {
                obj2 = null;
            }
            C4133a c4133a;
            if (obj2 != null) {
                charSequence = ecX;
                if (!(charSequence == null || charSequence.length() == 0)) {
                    obj = null;
                }
                if (obj != null) {
                    c4133a = C43644j.rST;
                    ecX = C4133a.cnk();
                }
            } else if (C25052j.m39373j(ecX, str)) {
                int i = 1;
                String accStoryPath;
                if (obj2 == null) {
                    c4133a = C43644j.rST;
                    accStoryPath = C4133a.getAccStoryPath();
                    AppMethodBeat.m2505o(109101);
                    return accStoryPath;
                }
                c4133a = C43644j.rST;
                accStoryPath = C4133a.getAccStoryCachePath();
                AppMethodBeat.m2505o(109101);
                return accStoryPath;
            }
        }
        obj2 = null;
        if (obj2 == null) {
        }
    }

    public static void cyn() {
        AppMethodBeat.m2504i(109116);
        C4133a c4133a = C43644j.rST;
        String accStoryCachePath = C4133a.getAccStoryCachePath();
        C4990ab.m7416i("MicroMsg.StoryFileNameUtil", "dumpCacheDir cache ".concat(String.valueOf(accStoryCachePath)));
        List cl = C5730e.m8627cl(accStoryCachePath, true);
        for (int i = 0; i < 100; i++) {
            C25052j.m39375o(cl, "files");
            int i2 = 0;
            for (Object next : cl) {
                int i3 = i2 + 1;
                if (i2 < 0) {
                    C7987l.dWs();
                }
                C5712a c5712a = (C5712a) next;
                String str = c5712a.name;
                C25052j.m39375o(str, "it.name");
                if (!C29309l.aaz(str)) {
                    C5730e.m8644y(c5712a.zYK, c5712a.zYK + System.currentTimeMillis());
                    if (i2 > 2) {
                        break;
                    }
                }
                i2 = i3;
            }
        }
        C4990ab.m7416i("MicroMsg.StoryFileNameUtil", "testCreateFiles done cache ".concat(String.valueOf(accStoryCachePath)));
        AppMethodBeat.m2505o(109116);
    }
}
