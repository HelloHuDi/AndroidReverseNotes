package com.tencent.mm.plugin.music.f.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.qqmusic.mediaplayer.AudioPlayerConfigure;
import com.tencent.qqmusic.mediaplayer.ILog;
import com.tencent.qqmusic.mediaplayer.ISoLibraryLoader;
import com.tencent.qqmusic.mediaplayer.NativeLibs;
import java.util.HashMap;

public class a {
    private static boolean aIA = false;
    private static c oNN = new a();
    private static boolean oNO = false;

    static class a implements c {
        private HashMap<String, Boolean> oNP;

        private a() {
            AppMethodBeat.i(137642);
            this.oNP = new HashMap();
            AppMethodBeat.o(137642);
        }

        /* synthetic */ a(byte b) {
            this();
        }

        public final boolean load(String str) {
            AppMethodBeat.i(137643);
            if (TextUtils.isEmpty(str)) {
                ab.e("MicroMsg.Audio.AudioPlayerUtils", "LoadLibrary lib_name is null");
                AppMethodBeat.o(137643);
                return false;
            } else if (this.oNP.containsKey(str) && ((Boolean) this.oNP.get(str)).booleanValue()) {
                ab.e("MicroMsg.Audio.AudioPlayerUtils", "LoadLibrary lib_name %s is loaded", str);
                AppMethodBeat.o(137643);
                return true;
            } else {
                this.oNP.put(str, Boolean.TRUE);
                System.loadLibrary(str);
                AppMethodBeat.o(137643);
                return true;
            }
        }

        public final String findLibPath(String str) {
            AppMethodBeat.i(137644);
            ab.i("MicroMsg.Audio.AudioPlayerUtils", "findLibPath %s", str);
            if (!str.startsWith("lib")) {
                str = "lib".concat(String.valueOf(str));
            }
            if (!str.endsWith(".so")) {
                str = str + ".so";
            }
            AppMethodBeat.o(137644);
            return str;
        }

        public final boolean Tn(String str) {
            AppMethodBeat.i(137645);
            if (this.oNP.containsKey(str)) {
                AppMethodBeat.o(137645);
                return true;
            }
            AppMethodBeat.o(137645);
            return false;
        }
    }

    static {
        AppMethodBeat.i(137648);
        AppMethodBeat.o(137648);
    }

    public static void bUE() {
        AppMethodBeat.i(137646);
        ab.i("MicroMsg.Audio.AudioPlayerUtils", "configQQMusicSdkConfig");
        AudioPlayerConfigure.setLog(new ILog() {
            public final void d(String str, String str2) {
                AppMethodBeat.i(137631);
                ab.d(str, str2);
                AppMethodBeat.o(137631);
            }

            public final void w(String str, String str2) {
                AppMethodBeat.i(137632);
                ab.w(str, str2);
                AppMethodBeat.o(137632);
            }

            public final void e(String str, String str2) {
                AppMethodBeat.i(137633);
                ab.e(str, str2);
                AppMethodBeat.o(137633);
            }

            public final void i(String str, String str2) {
                AppMethodBeat.i(137634);
                ab.i(str, str2);
                AppMethodBeat.o(137634);
            }

            public final void i(String str, String str2, Throwable th) {
                AppMethodBeat.i(137635);
                ab.printErrStackTrace(str, th, str2, new Object[0]);
                AppMethodBeat.o(137635);
            }

            public final void e(String str, Throwable th) {
                AppMethodBeat.i(137636);
                ab.printErrStackTrace(str, th, " throwable", new Object[0]);
                AppMethodBeat.o(137636);
            }

            public final void e(String str, String str2, Throwable th) {
                AppMethodBeat.i(137637);
                ab.printErrStackTrace(str, th, str2, new Object[0]);
                AppMethodBeat.o(137637);
            }

            public final void e(String str, String str2, Object... objArr) {
                AppMethodBeat.i(137638);
                ab.e(str, String.format(str2, objArr));
                AppMethodBeat.o(137638);
            }
        });
        AudioPlayerConfigure.setSoLibraryLoader(new ISoLibraryLoader() {
            public final boolean load(String str) {
                AppMethodBeat.i(137639);
                if (a.oNN != null) {
                    boolean load = a.oNN.load(str);
                    AppMethodBeat.o(137639);
                    return load;
                }
                AppMethodBeat.o(137639);
                return false;
            }

            public final String findLibPath(String str) {
                AppMethodBeat.i(137640);
                if (a.oNN != null) {
                    String findLibPath = a.oNN.findLibPath(str);
                    AppMethodBeat.o(137640);
                    return findLibPath;
                }
                AppMethodBeat.o(137640);
                return null;
            }
        });
        if (!(oNO || aIA)) {
            aIA = true;
            d.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(137641);
                    a.bUF();
                    a.aIA = false;
                    AppMethodBeat.o(137641);
                }
            }, "audio load NLog");
        }
        AppMethodBeat.o(137646);
    }

    public static synchronized boolean bUF() {
        boolean z = false;
        synchronized (a.class) {
            AppMethodBeat.i(137647);
            if (oNO) {
                z = true;
                AppMethodBeat.o(137647);
            } else if (oNN == null) {
                AppMethodBeat.o(137647);
            } else {
                oNN.load(NativeLibs.nlog.getName());
                if (oNN.Tn(NativeLibs.nlog.getName())) {
                    try {
                        oNO = AudioPlayerConfigure.enableNativeLog(null);
                    } catch (Throwable th) {
                        ab.printErrStackTrace("MicroMsg.Audio.AudioPlayerUtils", th, "checkNLogLoad", new Object[0]);
                        if (com.tencent.mm.compatible.util.d.fP(20)) {
                            oNO = AudioPlayerConfigure.enableNativeLog(null);
                        } else {
                            AppMethodBeat.o(137647);
                        }
                    }
                    if (oNO) {
                        ab.i("MicroMsg.Audio.AudioPlayerUtils", "enableNativeLog success");
                    }
                    z = oNO;
                    AppMethodBeat.o(137647);
                } else {
                    ab.i("MicroMsg.Audio.AudioPlayerUtils", "enableNativeLog fail");
                    AppMethodBeat.o(137647);
                }
            }
        }
        return z;
    }

    public static void a(c cVar) {
        oNN = cVar;
    }
}
