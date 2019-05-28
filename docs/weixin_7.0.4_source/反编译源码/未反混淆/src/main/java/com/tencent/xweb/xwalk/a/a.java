package com.tencent.xweb.xwalk.a;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.m;
import com.tencent.xweb.v;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.lang.reflect.Method;
import org.xwalk.core.Log;
import org.xwalk.core.XWalkEnvironment;

public final class a extends c {
    public final String dVM() {
        return XWalkEnvironment.XWALK_PLUGIN_NAME_FILE_READER;
    }

    public final String aM(int i, boolean z) {
        AppMethodBeat.i(4173);
        String SE = SE(i);
        if (SE == null || SE.isEmpty()) {
            SE = "";
            AppMethodBeat.o(4173);
            return SE;
        } else if (z) {
            SE = SE + File.separator + "FileReader.patch";
            AppMethodBeat.o(4173);
            return SE;
        } else {
            SE = SE + File.separator + "FileReader.zip";
            AppMethodBeat.o(4173);
            return SE;
        }
    }

    public final boolean dVN() {
        return false;
    }

    public final boolean dVO() {
        return false;
    }

    public final int a(d dVar) {
        AppMethodBeat.i(4174);
        if (b(dVar)) {
            String bY = bY(dVar.version, "filereader.apk");
            String SE = SE(dVar.version);
            if (SE == null || SE.isEmpty()) {
                Log.e("XWalkFileReaderPlugin", "getDexDir versionDir is empty");
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
                String[] split = a(new DexClassLoader(bY, SE, null, ClassLoader.getSystemClassLoader())).split(",");
                m.dTZ().a(split, com.tencent.xweb.d.a.NONE);
                v.ab(split);
                SD(dVar.version);
                AppMethodBeat.o(4174);
                return 0;
            } catch (Exception e) {
                Log.e("XWalkFileReaderPlugin", "performInstall error: " + e.getMessage());
                AppMethodBeat.o(4174);
                return -1;
            }
        }
        Log.e("XWalkFileReaderPlugin", "performInstall unZipAndCheck failed, return");
        AppMethodBeat.o(4174);
        return -1;
    }

    private static String a(DexClassLoader dexClassLoader) {
        String str;
        Exception e;
        AppMethodBeat.i(4175);
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
                    Log.e("XWalkFileReaderPlugin", "loadSupportFormat error: " + e.getMessage());
                    AppMethodBeat.o(4175);
                    return str;
                }
            }
            if (XWalkEnvironment.getApplicationContext() == null) {
                Log.e("XWalkFileReaderPlugin", "loadSupportFormat context is null");
                AppMethodBeat.o(4175);
            } else {
                SharedPreferences sharedPreferencesForPluginVersionInfo = XWalkEnvironment.getSharedPreferencesForPluginVersionInfo(XWalkEnvironment.XWALK_PLUGIN_NAME_FILE_READER);
                if (sharedPreferencesForPluginVersionInfo == null) {
                    Log.e("XWalkFileReaderPlugin", "loadSupportFormat sp is null");
                    AppMethodBeat.o(4175);
                } else {
                    Editor edit = sharedPreferencesForPluginVersionInfo.edit();
                    edit.putString("supportFormats", str);
                    Log.i("XWalkFileReaderPlugin", "loadSupportFormat, ret = " + edit.commit() + " formats: " + str);
                    AppMethodBeat.o(4175);
                }
            }
        } catch (Exception e3) {
            e = e3;
            str = str2;
            Log.e("XWalkFileReaderPlugin", "loadSupportFormat error: " + e.getMessage());
            AppMethodBeat.o(4175);
            return str;
        }
        return str;
    }
}
