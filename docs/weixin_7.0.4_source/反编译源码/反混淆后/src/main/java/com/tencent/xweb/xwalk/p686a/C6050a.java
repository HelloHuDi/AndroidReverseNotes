package com.tencent.xweb.xwalk.p686a;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.C31139d.C31140a;
import com.tencent.xweb.C31146m;
import com.tencent.xweb.C31149v;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.lang.reflect.Method;
import org.xwalk.core.Log;
import org.xwalk.core.XWalkEnvironment;

/* renamed from: com.tencent.xweb.xwalk.a.a */
public final class C6050a extends C24550c {
    public final String dVM() {
        return XWalkEnvironment.XWALK_PLUGIN_NAME_FILE_READER;
    }

    /* renamed from: aM */
    public final String mo13331aM(int i, boolean z) {
        AppMethodBeat.m2504i(4173);
        String SE = mo41308SE(i);
        if (SE == null || SE.isEmpty()) {
            SE = "";
            AppMethodBeat.m2505o(4173);
            return SE;
        } else if (z) {
            SE = SE + File.separator + "FileReader.patch";
            AppMethodBeat.m2505o(4173);
            return SE;
        } else {
            SE = SE + File.separator + "FileReader.zip";
            AppMethodBeat.m2505o(4173);
            return SE;
        }
    }

    public final boolean dVN() {
        return false;
    }

    public final boolean dVO() {
        return false;
    }

    /* renamed from: a */
    public final int mo13330a(C6051d c6051d) {
        AppMethodBeat.m2504i(4174);
        if (mo41309b(c6051d)) {
            String bY = mo41310bY(c6051d.version, "filereader.apk");
            String SE = mo41308SE(c6051d.version);
            if (SE == null || SE.isEmpty()) {
                Log.m81046e("XWalkFileReaderPlugin", "getDexDir versionDir is empty");
                SE = "";
            } else {
                SE = SE + File.separator + "dex";
            }
            File file = new File(SE);
            if (file.exists()) {
                File[] listFiles = file.listFiles();
                if (listFiles != null && listFiles.length > 0) {
                    for (File file2 : listFiles) {
                        if (file2 != null && file2.exists()) {
                            file2.delete();
                        }
                    }
                }
            } else {
                file.mkdirs();
            }
            try {
                String[] split = C6050a.m9522a(new DexClassLoader(bY, SE, null, ClassLoader.getSystemClassLoader())).split(",");
                C31146m.dTZ().mo50906a(split, C31140a.NONE);
                C31149v.m50238ab(split);
                mo41307SD(c6051d.version);
                AppMethodBeat.m2505o(4174);
                return 0;
            } catch (Exception e) {
                Log.m81046e("XWalkFileReaderPlugin", "performInstall error: " + e.getMessage());
                AppMethodBeat.m2505o(4174);
                return -1;
            }
        }
        Log.m81046e("XWalkFileReaderPlugin", "performInstall unZipAndCheck failed, return");
        AppMethodBeat.m2505o(4174);
        return -1;
    }

    /* renamed from: a */
    private static String m9522a(DexClassLoader dexClassLoader) {
        String str;
        Exception e;
        AppMethodBeat.m2504i(4175);
        String str2 = "";
        try {
            Method method = dexClassLoader.loadClass("com.tencent.xweb.filereader.XWebFileReaderEnvironment").getMethod("getSupportFormats", new Class[0]);
            method.setAccessible(true);
            str = (String) method.invoke(null, new Object[0]);
            if (str == null) {
                try {
                    str = "";
                } catch (Exception e2) {
                    e = e2;
                    Log.m81046e("XWalkFileReaderPlugin", "loadSupportFormat error: " + e.getMessage());
                    AppMethodBeat.m2505o(4175);
                    return str;
                }
            }
            if (XWalkEnvironment.getApplicationContext() == null) {
                Log.m81046e("XWalkFileReaderPlugin", "loadSupportFormat context is null");
                AppMethodBeat.m2505o(4175);
            } else {
                SharedPreferences sharedPreferencesForPluginVersionInfo = XWalkEnvironment.getSharedPreferencesForPluginVersionInfo(XWalkEnvironment.XWALK_PLUGIN_NAME_FILE_READER);
                if (sharedPreferencesForPluginVersionInfo == null) {
                    Log.m81046e("XWalkFileReaderPlugin", "loadSupportFormat sp is null");
                    AppMethodBeat.m2505o(4175);
                } else {
                    Editor edit = sharedPreferencesForPluginVersionInfo.edit();
                    edit.putString("supportFormats", str);
                    Log.m81049i("XWalkFileReaderPlugin", "loadSupportFormat, ret = " + edit.commit() + " formats: " + str);
                    AppMethodBeat.m2505o(4175);
                }
            }
        } catch (Exception e3) {
            e = e3;
            str = str2;
            Log.m81046e("XWalkFileReaderPlugin", "loadSupportFormat error: " + e.getMessage());
            AppMethodBeat.m2505o(4175);
            return str;
        }
        return str;
    }
}
