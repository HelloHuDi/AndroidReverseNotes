package com.tencent.p177mm.plugin.music.p463f.p464a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C1443d;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.qqmusic.mediaplayer.AudioPlayerConfigure;
import com.tencent.qqmusic.mediaplayer.ILog;
import com.tencent.qqmusic.mediaplayer.ISoLibraryLoader;
import com.tencent.qqmusic.mediaplayer.NativeLibs;
import java.util.HashMap;

/* renamed from: com.tencent.mm.plugin.music.f.a.a */
public class C12665a {
    private static boolean aIA = false;
    private static C12670c oNN = new C12666a();
    private static boolean oNO = false;

    /* renamed from: com.tencent.mm.plugin.music.f.a.a$3 */
    static class C35273 implements Runnable {
        C35273() {
        }

        public final void run() {
            AppMethodBeat.m2504i(137641);
            C12665a.bUF();
            C12665a.aIA = false;
            AppMethodBeat.m2505o(137641);
        }
    }

    /* renamed from: com.tencent.mm.plugin.music.f.a.a$a */
    static class C12666a implements C12670c {
        private HashMap<String, Boolean> oNP;

        private C12666a() {
            AppMethodBeat.m2504i(137642);
            this.oNP = new HashMap();
            AppMethodBeat.m2505o(137642);
        }

        /* synthetic */ C12666a(byte b) {
            this();
        }

        public final boolean load(String str) {
            AppMethodBeat.m2504i(137643);
            if (TextUtils.isEmpty(str)) {
                C4990ab.m7412e("MicroMsg.Audio.AudioPlayerUtils", "LoadLibrary lib_name is null");
                AppMethodBeat.m2505o(137643);
                return false;
            } else if (this.oNP.containsKey(str) && ((Boolean) this.oNP.get(str)).booleanValue()) {
                C4990ab.m7413e("MicroMsg.Audio.AudioPlayerUtils", "LoadLibrary lib_name %s is loaded", str);
                AppMethodBeat.m2505o(137643);
                return true;
            } else {
                this.oNP.put(str, Boolean.TRUE);
                System.loadLibrary(str);
                AppMethodBeat.m2505o(137643);
                return true;
            }
        }

        public final String findLibPath(String str) {
            AppMethodBeat.m2504i(137644);
            C4990ab.m7417i("MicroMsg.Audio.AudioPlayerUtils", "findLibPath %s", str);
            if (!str.startsWith("lib")) {
                str = "lib".concat(String.valueOf(str));
            }
            if (!str.endsWith(".so")) {
                str = str + ".so";
            }
            AppMethodBeat.m2505o(137644);
            return str;
        }

        /* renamed from: Tn */
        public final boolean mo24626Tn(String str) {
            AppMethodBeat.m2504i(137645);
            if (this.oNP.containsKey(str)) {
                AppMethodBeat.m2505o(137645);
                return true;
            }
            AppMethodBeat.m2505o(137645);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.music.f.a.a$1 */
    static class C126671 implements ILog {
        C126671() {
        }

        /* renamed from: d */
        public final void mo24629d(String str, String str2) {
            AppMethodBeat.m2504i(137631);
            C4990ab.m7410d(str, str2);
            AppMethodBeat.m2505o(137631);
        }

        /* renamed from: w */
        public final void mo24636w(String str, String str2) {
            AppMethodBeat.m2504i(137632);
            C4990ab.m7420w(str, str2);
            AppMethodBeat.m2505o(137632);
        }

        /* renamed from: e */
        public final void mo24630e(String str, String str2) {
            AppMethodBeat.m2504i(137633);
            C4990ab.m7412e(str, str2);
            AppMethodBeat.m2505o(137633);
        }

        /* renamed from: i */
        public final void mo24634i(String str, String str2) {
            AppMethodBeat.m2504i(137634);
            C4990ab.m7416i(str, str2);
            AppMethodBeat.m2505o(137634);
        }

        /* renamed from: i */
        public final void mo24635i(String str, String str2, Throwable th) {
            AppMethodBeat.m2504i(137635);
            C4990ab.printErrStackTrace(str, th, str2, new Object[0]);
            AppMethodBeat.m2505o(137635);
        }

        /* renamed from: e */
        public final void mo24633e(String str, Throwable th) {
            AppMethodBeat.m2504i(137636);
            C4990ab.printErrStackTrace(str, th, " throwable", new Object[0]);
            AppMethodBeat.m2505o(137636);
        }

        /* renamed from: e */
        public final void mo24631e(String str, String str2, Throwable th) {
            AppMethodBeat.m2504i(137637);
            C4990ab.printErrStackTrace(str, th, str2, new Object[0]);
            AppMethodBeat.m2505o(137637);
        }

        /* renamed from: e */
        public final void mo24632e(String str, String str2, Object... objArr) {
            AppMethodBeat.m2504i(137638);
            C4990ab.m7412e(str, String.format(str2, objArr));
            AppMethodBeat.m2505o(137638);
        }
    }

    /* renamed from: com.tencent.mm.plugin.music.f.a.a$2 */
    static class C126682 implements ISoLibraryLoader {
        C126682() {
        }

        public final boolean load(String str) {
            AppMethodBeat.m2504i(137639);
            if (C12665a.oNN != null) {
                boolean load = C12665a.oNN.load(str);
                AppMethodBeat.m2505o(137639);
                return load;
            }
            AppMethodBeat.m2505o(137639);
            return false;
        }

        public final String findLibPath(String str) {
            AppMethodBeat.m2504i(137640);
            if (C12665a.oNN != null) {
                String findLibPath = C12665a.oNN.findLibPath(str);
                AppMethodBeat.m2505o(137640);
                return findLibPath;
            }
            AppMethodBeat.m2505o(137640);
            return null;
        }
    }

    static {
        AppMethodBeat.m2504i(137648);
        AppMethodBeat.m2505o(137648);
    }

    public static void bUE() {
        AppMethodBeat.m2504i(137646);
        C4990ab.m7416i("MicroMsg.Audio.AudioPlayerUtils", "configQQMusicSdkConfig");
        AudioPlayerConfigure.setLog(new C126671());
        AudioPlayerConfigure.setSoLibraryLoader(new C126682());
        if (!(oNO || aIA)) {
            aIA = true;
            C7305d.post(new C35273(), "audio load NLog");
        }
        AppMethodBeat.m2505o(137646);
    }

    public static synchronized boolean bUF() {
        boolean z = false;
        synchronized (C12665a.class) {
            AppMethodBeat.m2504i(137647);
            if (oNO) {
                z = true;
                AppMethodBeat.m2505o(137647);
            } else if (oNN == null) {
                AppMethodBeat.m2505o(137647);
            } else {
                oNN.load(NativeLibs.nlog.getName());
                if (oNN.mo24626Tn(NativeLibs.nlog.getName())) {
                    try {
                        oNO = AudioPlayerConfigure.enableNativeLog(null);
                    } catch (Throwable th) {
                        C4990ab.printErrStackTrace("MicroMsg.Audio.AudioPlayerUtils", th, "checkNLogLoad", new Object[0]);
                        if (C1443d.m3067fP(20)) {
                            oNO = AudioPlayerConfigure.enableNativeLog(null);
                        } else {
                            AppMethodBeat.m2505o(137647);
                        }
                    }
                    if (oNO) {
                        C4990ab.m7416i("MicroMsg.Audio.AudioPlayerUtils", "enableNativeLog success");
                    }
                    z = oNO;
                    AppMethodBeat.m2505o(137647);
                } else {
                    C4990ab.m7416i("MicroMsg.Audio.AudioPlayerUtils", "enableNativeLog fail");
                    AppMethodBeat.m2505o(137647);
                }
            }
        }
        return z;
    }

    /* renamed from: a */
    public static void m20659a(C12670c c12670c) {
        oNN = c12670c;
    }
}
