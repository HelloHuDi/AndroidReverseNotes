package com.tencent.mm.audio.mix.h;

import android.os.Environment;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

public final class a {
    private static boolean coh = false;

    public static String eh(String str) {
        String str2;
        AppMethodBeat.i(137205);
        String absolutePath = Environment.getExternalStorageDirectory().getAbsolutePath();
        if (coh && str.contains(".") && str.contains("/")) {
            str2 = str.substring(str.lastIndexOf("/") + 1, str.lastIndexOf(".")) + "_convert.pcm";
        } else if (str.contains(".") && str.contains("/") && str.lastIndexOf(".") > str.lastIndexOf("/")) {
            str2 = str.substring(str.lastIndexOf("/") + 1, str.lastIndexOf(".")) + "_convert.pcm";
            absolutePath = absolutePath + "/tencent/MicroMsg/MixAudio";
        } else {
            str2 = c.ck(str.hashCode()) + "_convert.pcm";
            absolutePath = absolutePath + "/tencent/MicroMsg/MixAudio";
        }
        File file = new File(absolutePath);
        if (!file.exists()) {
            file.mkdirs();
        }
        absolutePath = absolutePath + File.separator + str2;
        AppMethodBeat.o(137205);
        return absolutePath;
    }

    public static File ei(String str) {
        AppMethodBeat.i(137206);
        File file = new File(str);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (Exception e) {
                b.printErrStackTrace("MicroMsg.Mix.FileUtil", e, "createNewFile", new Object[0]);
            }
        }
        AppMethodBeat.o(137206);
        return file;
    }

    public static String F(String str, String str2) {
        String str3;
        AppMethodBeat.i(137207);
        String absolutePath = Environment.getExternalStorageDirectory().getAbsolutePath();
        if (coh && str2.contains(".") && str2.contains("/")) {
            str3 = str2.substring(str2.lastIndexOf("/") + 1, str2.lastIndexOf(".")) + "_cache.pcm";
        } else if (str2.contains(".") && str2.contains("/") && str2.lastIndexOf(".") > str2.lastIndexOf("/")) {
            str3 = str2.substring(str2.lastIndexOf("/") + 1, str2.lastIndexOf(".")) + "_cache.pcm";
            absolutePath = absolutePath + "/tencent/MicroMsg/MixAudio";
        } else {
            str3 = c.ck(str2.hashCode()) + "_cache.pcm";
            absolutePath = absolutePath + "/tencent/MicroMsg/MixAudio";
        }
        absolutePath = absolutePath + (File.separator + str);
        File file = new File(absolutePath);
        if (!file.exists()) {
            file.mkdirs();
        }
        absolutePath = absolutePath + File.separator + str3;
        AppMethodBeat.o(137207);
        return absolutePath;
    }

    public static void b(String str, ArrayList<String> arrayList) {
        AppMethodBeat.i(137208);
        if (arrayList.size() > 0) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                File file = new File(F(str, (String) it.next()));
                if (file.exists()) {
                    file.delete();
                    b.i("MicroMsg.Mix.FileUtil", "delete pcm cache file, file:%s", r0);
                }
            }
        }
        AppMethodBeat.o(137208);
    }

    public static boolean ej(String str) {
        AppMethodBeat.i(137209);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(137209);
            return false;
        }
        File file = new File(str);
        if (!file.exists()) {
            AppMethodBeat.o(137209);
            return false;
        } else if (file.isDirectory()) {
            AppMethodBeat.o(137209);
            return false;
        } else {
            boolean z;
            if (str.endsWith(".wav")) {
                if (file.length() >= 5000000) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    AppMethodBeat.o(137209);
                    return false;
                }
            }
            if (!str.endsWith(".wav")) {
                if (file.length() >= 2000000) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    AppMethodBeat.o(137209);
                    return false;
                }
            }
            AppMethodBeat.o(137209);
            return true;
        }
    }

    public static long ek(String str) {
        AppMethodBeat.i(137210);
        File file = new File(str);
        if (file.exists()) {
            long length = file.length();
            AppMethodBeat.o(137210);
            return length;
        }
        AppMethodBeat.o(137210);
        return 0;
    }
}
