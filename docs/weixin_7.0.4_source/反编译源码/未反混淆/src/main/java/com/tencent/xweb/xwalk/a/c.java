package com.tencent.xweb.xwalk.a;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.ttpic.util.VideoMaterialUtil;
import com.tencent.xweb.util.b;
import com.tencent.xweb.util.d;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileReader;
import java.net.URLEncoder;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import org.xwalk.core.Log;
import org.xwalk.core.XWalkEnvironment;

public abstract class c {
    public int ASG = -1;

    public abstract int a(d dVar);

    public abstract String aM(int i, boolean z);

    public abstract String dVM();

    public abstract boolean dVN();

    public abstract boolean dVO();

    public c() {
        if (XWalkEnvironment.getApplicationContext() == null) {
            Log.e("XWalkPlugin", "load ver of " + dVM() + " context is null");
            return;
        }
        SharedPreferences sharedPreferencesForPluginVersionInfo = XWalkEnvironment.getSharedPreferencesForPluginVersionInfo(dVM());
        if (sharedPreferencesForPluginVersionInfo == null) {
            XWalkEnvironment.addXWalkInitializeLog("XWalkPlugin", "load ver of " + dVM() + " sp is null");
            return;
        }
        this.ASG = sharedPreferencesForPluginVersionInfo.getInt(XWalkEnvironment.SP_KEY_PLUGIN_AVAILABLE_VERSION, -1);
        XWalkEnvironment.addXWalkInitializeLog("XWalkPlugin", "load ver of " + dVM() + " ver " + this.ASG);
    }

    public final boolean SD(int i) {
        boolean z = false;
        if (XWalkEnvironment.getApplicationContext() == null) {
            Log.e("XWalkPlugin", "set ver of " + dVM() + " context is null");
        } else {
            SharedPreferences sharedPreferencesForPluginVersionInfo = XWalkEnvironment.getSharedPreferencesForPluginVersionInfo(dVM());
            if (sharedPreferencesForPluginVersionInfo == null) {
                XWalkEnvironment.addXWalkInitializeLog("XWalkPlugin", "set ver of " + dVM() + " sp is null");
            } else {
                Editor edit = sharedPreferencesForPluginVersionInfo.edit();
                edit.putInt(XWalkEnvironment.SP_KEY_PLUGIN_AVAILABLE_VERSION, i);
                z = edit.commit();
                if (z) {
                    this.ASG = i;
                }
                XWalkEnvironment.addXWalkInitializeLog("XWalkPlugin", "set ver of " + dVM() + " to " + i + ", isNow = true, ret = " + z);
            }
        }
        return z;
    }

    public final String SE(int i) {
        if (XWalkEnvironment.getApplicationContext() == null) {
            Log.e("XWalkPlugin", "get dir of " + dVM() + " context is null");
            return "";
        }
        String pluginBaseDir = XWalkEnvironment.getPluginBaseDir();
        if (pluginBaseDir.isEmpty()) {
            Log.e("XWalkPlugin", "get dir of " + dVM() + " pluginBaseDir is null");
            return "";
        }
        pluginBaseDir = pluginBaseDir + File.separator + dVM() + "_" + i;
        File file = new File(pluginBaseDir);
        if (file.exists()) {
            return pluginBaseDir;
        }
        file.mkdirs();
        return pluginBaseDir;
    }

    public final String bY(int i, String str) {
        if (str == null || str.isEmpty()) {
            Log.e("XWalkPlugin", "getExtractFile fileName is null");
            return "";
        }
        String SE = SE(i);
        if (SE.isEmpty()) {
            Log.e("XWalkPlugin", "getExtractFile versionDir is null");
            return "";
        }
        SE = SE + File.separator + "extracted";
        File file = new File(SE);
        if (!file.exists()) {
            file.mkdirs();
        }
        return SE + File.separator + str;
    }

    /* JADX WARNING: Removed duplicated region for block: B:67:0x0159  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0144  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x0159  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x0159  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean b(d dVar) {
        Exception e;
        Closeable closeable;
        Throwable th;
        File file = new File(dVar.path);
        Closeable zipFile;
        Closeable bufferedReader;
        try {
            if (d.gA(dVar.path, dVar.cvZ)) {
                zipFile = new ZipFile(dVar.path);
                try {
                    Enumeration entries = zipFile.entries();
                    while (entries.hasMoreElements()) {
                        ZipEntry zipEntry = (ZipEntry) entries.nextElement();
                        String encode = URLEncoder.encode(zipEntry.getName(), "UTF-8");
                        if (!encode.contains("../") && !encode.contains("..\\") && !zipEntry.isDirectory() && !b.b(zipFile.getInputStream(zipEntry), new File(bY(dVar.version, encode)))) {
                            Log.e("XWalkPlugin", "unZipAndCheck error, return");
                            b.tryClose(zipFile);
                            b.tryClose(null);
                            if (file.exists()) {
                                file.delete();
                            }
                            return false;
                        }
                    }
                    bufferedReader = new BufferedReader(new FileReader(bY(dVar.version, XWalkEnvironment.XWALK_CORE_FILELIST_CONFIG_NAME)));
                    while (true) {
                        try {
                            String readLine = bufferedReader.readLine();
                            if (readLine == null) {
                                b.tryClose(zipFile);
                                b.tryClose(bufferedReader);
                                if (file.exists()) {
                                    file.delete();
                                }
                                return true;
                            } else if (!readLine.isEmpty()) {
                                String[] split = readLine.split(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D);
                                if (!(split.length != 2 || split[0] == null || split[0].isEmpty() || split[1] == null || split[1].isEmpty())) {
                                    String str = split[0];
                                    if (!d.gA(bY(dVar.version, str), split[1])) {
                                        Log.e("XWalkPlugin", "unZipAndCheck md5 not match: ".concat(String.valueOf(str)));
                                        b.tryClose(zipFile);
                                        b.tryClose(bufferedReader);
                                        if (file.exists()) {
                                            file.delete();
                                        }
                                        return false;
                                    }
                                }
                            }
                        } catch (Exception e2) {
                            e = e2;
                            closeable = bufferedReader;
                            try {
                                Log.e("XWalkPlugin", "unZipAndCheck error: " + e.getMessage());
                                b.tryClose(zipFile);
                                b.tryClose(closeable);
                                if (file.exists()) {
                                }
                                return false;
                            } catch (Throwable th2) {
                                th = th2;
                                bufferedReader = closeable;
                                b.tryClose(zipFile);
                                b.tryClose(bufferedReader);
                                if (file.exists()) {
                                    file.delete();
                                }
                                throw th;
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            b.tryClose(zipFile);
                            b.tryClose(bufferedReader);
                            if (file.exists()) {
                            }
                            throw th;
                        }
                    }
                } catch (Exception e3) {
                    e = e3;
                    closeable = null;
                    Log.e("XWalkPlugin", "unZipAndCheck error: " + e.getMessage());
                    b.tryClose(zipFile);
                    b.tryClose(closeable);
                    if (file.exists()) {
                        file.delete();
                    }
                    return false;
                } catch (Throwable th4) {
                    th = th4;
                    bufferedReader = null;
                    b.tryClose(zipFile);
                    b.tryClose(bufferedReader);
                    if (file.exists()) {
                    }
                    throw th;
                }
            }
            b.tryClose(null);
            b.tryClose(null);
            if (file.exists()) {
                file.delete();
            }
            return false;
        } catch (Exception e4) {
            e = e4;
            closeable = null;
            zipFile = null;
        } catch (Throwable th5) {
            th = th5;
            bufferedReader = null;
            zipFile = null;
            b.tryClose(zipFile);
            b.tryClose(bufferedReader);
            if (file.exists()) {
            }
            throw th;
        }
    }
}
