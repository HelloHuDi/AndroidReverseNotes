package com.tencent.smtt.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.utils.TbsLog;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class TbsDownloadUpload {
    private static TbsDownloadUpload b;
    Map<String, Object> a = new HashMap();
    private Context c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;
    private int i;
    public SharedPreferences mPreferences;

    public interface TbsUploadKey {
        public static final String KEY_LOCAL_CORE_VERSION = "tbs_local_core_version";
        public static final String KEY_NEEDDOWNLOAD_CODE = "tbs_needdownload_code";
        public static final String KEY_NEEDDOWNLOAD_RETURN = "tbs_needdownload_return";
        public static final String KEY_NEEDDOWNLOAD_SENT = "tbs_needdownload_sent";
        public static final String KEY_STARTDOWNLOAD_CODE = "tbs_startdownload_code";
        public static final String KEY_STARTDOWNLOAD_SENT = "tbs_startdownload_sent";
    }

    public TbsDownloadUpload(Context context) {
        AppMethodBeat.i(64339);
        this.mPreferences = context.getSharedPreferences("tbs_download_upload", 4);
        this.c = context.getApplicationContext();
        if (this.c == null) {
            this.c = context;
        }
        AppMethodBeat.o(64339);
    }

    private static File a(Context context, String str) {
        AppMethodBeat.i(64343);
        an.a();
        File t = an.t(context);
        if (t == null) {
            AppMethodBeat.o(64343);
            return null;
        }
        File file = new File(t, str);
        if (file.exists()) {
            AppMethodBeat.o(64343);
            return file;
        }
        try {
            file.createNewFile();
            AppMethodBeat.o(64343);
            return file;
        } catch (IOException e) {
            AppMethodBeat.o(64343);
            return null;
        }
    }

    public static synchronized void clear() {
        synchronized (TbsDownloadUpload.class) {
            b = null;
        }
    }

    public static synchronized TbsDownloadUpload getInstance() {
        TbsDownloadUpload tbsDownloadUpload;
        synchronized (TbsDownloadUpload.class) {
            tbsDownloadUpload = b;
        }
        return tbsDownloadUpload;
    }

    public static synchronized TbsDownloadUpload getInstance(Context context) {
        TbsDownloadUpload tbsDownloadUpload;
        synchronized (TbsDownloadUpload.class) {
            AppMethodBeat.i(64340);
            if (b == null) {
                b = new TbsDownloadUpload(context);
            }
            tbsDownloadUpload = b;
            AppMethodBeat.o(64340);
        }
        return tbsDownloadUpload;
    }

    public void clearUploadCode() {
        AppMethodBeat.i(64341);
        this.a.put(TbsUploadKey.KEY_NEEDDOWNLOAD_CODE, Integer.valueOf(0));
        this.a.put(TbsUploadKey.KEY_STARTDOWNLOAD_CODE, Integer.valueOf(0));
        this.a.put(TbsUploadKey.KEY_NEEDDOWNLOAD_RETURN, Integer.valueOf(0));
        this.a.put(TbsUploadKey.KEY_NEEDDOWNLOAD_SENT, Integer.valueOf(0));
        this.a.put(TbsUploadKey.KEY_STARTDOWNLOAD_SENT, Integer.valueOf(0));
        this.a.put(TbsUploadKey.KEY_LOCAL_CORE_VERSION, Integer.valueOf(0));
        writeTbsDownloadInfo();
        AppMethodBeat.o(64341);
    }

    public synchronized void commit() {
        AppMethodBeat.i(64345);
        writeTbsDownloadInfo();
        AppMethodBeat.o(64345);
    }

    public synchronized int getLocalCoreVersion() {
        return this.i;
    }

    public synchronized int getNeedDownloadCode() {
        return this.g == 1 ? 148 : this.d;
    }

    public synchronized int getNeedDownloadReturn() {
        return this.f;
    }

    public synchronized int getStartDownloadCode() {
        return this.h == 1 ? 168 : this.e;
    }

    /* JADX WARNING: Removed duplicated region for block: B:59:0x0115 A:{SYNTHETIC, Splitter:B:59:0x0115} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void readTbsDownloadInfo(Context context) {
        Throwable th;
        BufferedInputStream bufferedInputStream;
        AppMethodBeat.i(64342);
        BufferedInputStream bufferedInputStream2;
        try {
            File a = a(this.c, "download_upload");
            if (a == null) {
                AppMethodBeat.o(64342);
            } else {
                bufferedInputStream2 = new BufferedInputStream(new FileInputStream(a));
                try {
                    Properties properties = new Properties();
                    properties.load(bufferedInputStream2);
                    String property = properties.getProperty(TbsUploadKey.KEY_NEEDDOWNLOAD_CODE, "");
                    if (!"".equals(property)) {
                        this.d = Math.max(Integer.parseInt(property), 0);
                    }
                    property = properties.getProperty(TbsUploadKey.KEY_STARTDOWNLOAD_CODE, "");
                    if (!"".equals(property)) {
                        this.e = Math.max(Integer.parseInt(property), 0);
                    }
                    property = properties.getProperty(TbsUploadKey.KEY_NEEDDOWNLOAD_RETURN, "");
                    if (!"".equals(property)) {
                        this.f = Math.max(Integer.parseInt(property), 0);
                    }
                    property = properties.getProperty(TbsUploadKey.KEY_NEEDDOWNLOAD_SENT, "");
                    if (!"".equals(property)) {
                        this.g = Math.max(Integer.parseInt(property), 0);
                    }
                    property = properties.getProperty(TbsUploadKey.KEY_STARTDOWNLOAD_SENT, "");
                    if (!"".equals(property)) {
                        this.h = Math.max(Integer.parseInt(property), 0);
                    }
                    String property2 = properties.getProperty(TbsUploadKey.KEY_LOCAL_CORE_VERSION, "");
                    if (!"".equals(property2)) {
                        this.i = Math.max(Integer.parseInt(property2), 0);
                    }
                    try {
                        bufferedInputStream2.close();
                        AppMethodBeat.o(64342);
                    } catch (Exception e) {
                        AppMethodBeat.o(64342);
                    }
                } catch (Throwable th2) {
                    th = th2;
                    bufferedInputStream = bufferedInputStream2;
                    if (bufferedInputStream != null) {
                        try {
                            bufferedInputStream.close();
                        } catch (Exception e2) {
                        }
                    }
                    AppMethodBeat.o(64342);
                    throw th;
                }
            }
        } catch (Throwable th3) {
            th = th3;
            bufferedInputStream = null;
            if (bufferedInputStream != null) {
            }
            AppMethodBeat.o(64342);
            throw th;
        }
        return;
    }

    /* JADX WARNING: Removed duplicated region for block: B:54:0x00ca A:{SYNTHETIC, Splitter:B:54:0x00ca} */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00cf A:{SYNTHETIC, Splitter:B:57:0x00cf} */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x007f A:{SYNTHETIC, Splitter:B:24:0x007f} */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0084 A:{SYNTHETIC, Splitter:B:27:0x0084} */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00ca A:{SYNTHETIC, Splitter:B:54:0x00ca} */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00cf A:{SYNTHETIC, Splitter:B:57:0x00cf} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void writeTbsDownloadInfo() {
        BufferedOutputStream bufferedOutputStream;
        Throwable th;
        BufferedOutputStream bufferedOutputStream2;
        AppMethodBeat.i(64344);
        TbsLog.i("TbsDownloadUpload", "writeTbsDownloadInfo #1");
        BufferedInputStream bufferedInputStream;
        try {
            File a = a(this.c, "download_upload");
            if (a == null) {
                AppMethodBeat.o(64344);
            } else {
                Properties properties;
                bufferedInputStream = new BufferedInputStream(new FileInputStream(a));
                try {
                    properties = new Properties();
                    properties.load(bufferedInputStream);
                    for (String str : this.a.keySet()) {
                        Object obj = this.a.get(str);
                        properties.setProperty(str, String.valueOf(obj));
                        TbsLog.i("TbsDownloadUpload", "writeTbsDownloadInfo key is " + str + " value is " + obj);
                    }
                    this.a.clear();
                    bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(a));
                } catch (Throwable th2) {
                    th = th2;
                    bufferedOutputStream2 = null;
                    if (bufferedInputStream != null) {
                    }
                    if (bufferedOutputStream2 != null) {
                    }
                    AppMethodBeat.o(64344);
                    throw th;
                }
                try {
                    properties.store(bufferedOutputStream, null);
                    try {
                        bufferedInputStream.close();
                    } catch (Exception e) {
                    }
                    try {
                        bufferedOutputStream.close();
                        AppMethodBeat.o(64344);
                    } catch (Exception e2) {
                        AppMethodBeat.o(64344);
                    }
                } catch (Throwable th3) {
                    th = th3;
                    bufferedOutputStream2 = bufferedOutputStream;
                    if (bufferedInputStream != null) {
                    }
                    if (bufferedOutputStream2 != null) {
                    }
                    AppMethodBeat.o(64344);
                    throw th;
                }
            }
        } catch (Throwable th22) {
            th = th22;
            bufferedOutputStream2 = null;
            bufferedInputStream = null;
            if (bufferedInputStream != null) {
                try {
                    bufferedInputStream.close();
                } catch (Exception e3) {
                }
            }
            if (bufferedOutputStream2 != null) {
                try {
                    bufferedOutputStream2.close();
                } catch (Exception e4) {
                }
            }
            AppMethodBeat.o(64344);
            throw th;
        }
    }
}
