package com.tencent.p177mm.audio.mix.p197h;

import android.os.Environment;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: com.tencent.mm.audio.mix.h.a */
public final class C41782a {
    private static boolean coh = false;

    /* renamed from: eh */
    public static String m73753eh(String str) {
        String str2;
        AppMethodBeat.m2504i(137205);
        String absolutePath = Environment.getExternalStorageDirectory().getAbsolutePath();
        if (coh && str.contains(".") && str.contains("/")) {
            str2 = str.substring(str.lastIndexOf("/") + 1, str.lastIndexOf(".")) + "_convert.pcm";
        } else if (str.contains(".") && str.contains("/") && str.lastIndexOf(".") > str.lastIndexOf("/")) {
            str2 = str.substring(str.lastIndexOf("/") + 1, str.lastIndexOf(".")) + "_convert.pcm";
            absolutePath = absolutePath + "/tencent/MicroMsg/MixAudio";
        } else {
            str2 = C9057c.m16429ck(str.hashCode()) + "_convert.pcm";
            absolutePath = absolutePath + "/tencent/MicroMsg/MixAudio";
        }
        File file = new File(absolutePath);
        if (!file.exists()) {
            file.mkdirs();
        }
        absolutePath = absolutePath + File.separator + str2;
        AppMethodBeat.m2505o(137205);
        return absolutePath;
    }

    /* renamed from: ei */
    public static File m73754ei(String str) {
        AppMethodBeat.m2504i(137206);
        File file = new File(str);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (Exception e) {
                C45174b.printErrStackTrace("MicroMsg.Mix.FileUtil", e, "createNewFile", new Object[0]);
            }
        }
        AppMethodBeat.m2505o(137206);
        return file;
    }

    /* renamed from: F */
    public static String m73751F(String str, String str2) {
        String str3;
        AppMethodBeat.m2504i(137207);
        String absolutePath = Environment.getExternalStorageDirectory().getAbsolutePath();
        if (coh && str2.contains(".") && str2.contains("/")) {
            str3 = str2.substring(str2.lastIndexOf("/") + 1, str2.lastIndexOf(".")) + "_cache.pcm";
        } else if (str2.contains(".") && str2.contains("/") && str2.lastIndexOf(".") > str2.lastIndexOf("/")) {
            str3 = str2.substring(str2.lastIndexOf("/") + 1, str2.lastIndexOf(".")) + "_cache.pcm";
            absolutePath = absolutePath + "/tencent/MicroMsg/MixAudio";
        } else {
            str3 = C9057c.m16429ck(str2.hashCode()) + "_cache.pcm";
            absolutePath = absolutePath + "/tencent/MicroMsg/MixAudio";
        }
        absolutePath = absolutePath + (File.separator + str);
        File file = new File(absolutePath);
        if (!file.exists()) {
            file.mkdirs();
        }
        absolutePath = absolutePath + File.separator + str3;
        AppMethodBeat.m2505o(137207);
        return absolutePath;
    }

    /* renamed from: b */
    public static void m73752b(String str, ArrayList<String> arrayList) {
        AppMethodBeat.m2504i(137208);
        if (arrayList.size() > 0) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                File file = new File(C41782a.m73751F(str, (String) it.next()));
                if (file.exists()) {
                    file.delete();
                    C45174b.m83210i("MicroMsg.Mix.FileUtil", "delete pcm cache file, file:%s", r0);
                }
            }
        }
        AppMethodBeat.m2505o(137208);
    }

    /* renamed from: ej */
    public static boolean m73755ej(String str) {
        AppMethodBeat.m2504i(137209);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.m2505o(137209);
            return false;
        }
        File file = new File(str);
        if (!file.exists()) {
            AppMethodBeat.m2505o(137209);
            return false;
        } else if (file.isDirectory()) {
            AppMethodBeat.m2505o(137209);
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
                    AppMethodBeat.m2505o(137209);
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
                    AppMethodBeat.m2505o(137209);
                    return false;
                }
            }
            AppMethodBeat.m2505o(137209);
            return true;
        }
    }

    /* renamed from: ek */
    public static long m73756ek(String str) {
        AppMethodBeat.m2504i(137210);
        File file = new File(str);
        if (file.exists()) {
            long length = file.length();
            AppMethodBeat.m2505o(137210);
            return length;
        }
        AppMethodBeat.m2505o(137210);
        return 0;
    }
}
