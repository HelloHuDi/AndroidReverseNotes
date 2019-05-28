package com.tencent.smtt.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.util.Log;
import com.facebook.internal.Utility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey;
import com.tencent.smtt.utils.Apn;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.b;
import com.tencent.smtt.utils.k;
import com.tencent.smtt.utils.n;
import com.tencent.smtt.utils.o;
import com.tencent.smtt.utils.s;
import com.tencent.smtt.utils.v;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import org.json.JSONArray;

public class TbsLogReport {
    private static TbsLogReport a;
    private Handler b = null;
    private Context c;
    private boolean d = false;

    public static class TbsLogInfo implements Cloneable {
        int a;
        private long b;
        private String c;
        private String d;
        private int e;
        private int f;
        private int g;
        private int h;
        private String i;
        private int j;
        private int k;
        private long l;
        private long m;
        private int n;
        private String o;
        private String p;
        private long q;

        private TbsLogInfo() {
            AppMethodBeat.i(64484);
            resetArgs();
            AppMethodBeat.o(64484);
        }

        /* synthetic */ TbsLogInfo(ax axVar) {
            this();
        }

        /* Access modifiers changed, original: protected */
        public Object clone() {
            Object thisR;
            AppMethodBeat.i(64485);
            try {
                thisR = super.clone();
                AppMethodBeat.o(64485);
            } catch (CloneNotSupportedException e) {
                AppMethodBeat.o(64485);
            }
            return thisR;
        }

        public int getDownFinalFlag() {
            return this.k;
        }

        public void resetArgs() {
            this.b = 0;
            this.c = null;
            this.d = null;
            this.e = 0;
            this.f = 0;
            this.g = 0;
            this.h = 2;
            this.i = "unknown";
            this.j = 0;
            this.k = 2;
            this.l = 0;
            this.m = 0;
            this.n = 1;
            this.a = 0;
            this.o = null;
            this.p = null;
            this.q = 0;
        }

        public void setApn(String str) {
            this.i = str;
        }

        public void setCheckErrorDetail(String str) {
            AppMethodBeat.i(64488);
            setErrorCode(108);
            this.o = str;
            AppMethodBeat.o(64488);
        }

        public void setDownConsumeTime(long j) {
            this.m += j;
        }

        public void setDownFinalFlag(int i) {
            this.k = i;
        }

        public void setDownloadCancel(int i) {
            this.g = i;
        }

        public void setDownloadSize(long j) {
            this.q += j;
        }

        public void setDownloadUrl(String str) {
            AppMethodBeat.i(64486);
            if (this.c == null) {
                this.c = str;
                AppMethodBeat.o(64486);
                return;
            }
            this.c += ";" + str;
            AppMethodBeat.o(64486);
        }

        public void setErrorCode(int i) {
            AppMethodBeat.i(64487);
            if (!(i == 100 || i == 110 || i == 120 || i == 111 || i >= 400)) {
                TbsLog.i(TbsDownloader.LOGTAG, "error occured, errorCode:".concat(String.valueOf(i)), true);
            }
            if (i == 111) {
                TbsLog.i(TbsDownloader.LOGTAG, "you are not in wifi, downloading stoped", true);
            }
            this.a = i;
            AppMethodBeat.o(64487);
        }

        public void setEventTime(long j) {
            this.b = j;
        }

        public void setFailDetail(String str) {
            AppMethodBeat.i(64489);
            if (str == null) {
                AppMethodBeat.o(64489);
                return;
            }
            if (str.length() > WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) {
                str = str.substring(0, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
            }
            this.p = str;
            AppMethodBeat.o(64489);
        }

        public void setFailDetail(Throwable th) {
            AppMethodBeat.i(64490);
            if (th == null) {
                this.p = "";
                AppMethodBeat.o(64490);
                return;
            }
            String stackTraceString = Log.getStackTraceString(th);
            if (stackTraceString.length() > WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) {
                stackTraceString = stackTraceString.substring(0, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
            }
            this.p = stackTraceString;
            AppMethodBeat.o(64490);
        }

        public void setHttpCode(int i) {
            this.e = i;
        }

        public void setNetworkChange(int i) {
            this.n = i;
        }

        public void setNetworkType(int i) {
            this.j = i;
        }

        public void setPatchUpdateFlag(int i) {
            this.f = i;
        }

        public void setPkgSize(long j) {
            this.l = j;
        }

        public void setResolveIp(String str) {
            this.d = str;
        }

        public void setUnpkgFlag(int i) {
            this.h = i;
        }
    }

    public enum EventType {
        TYPE_DOWNLOAD(0),
        TYPE_INSTALL(1),
        TYPE_LOAD(2),
        TYPE_DOWNLOAD_DECOUPLE(3),
        TYPE_INSTALL_DECOUPLE(4),
        TYPE_COOKIE_DB_SWITCH(5),
        TYPE_SDK_REPORT_INFO(6);
        
        int a;

        static {
            AppMethodBeat.o(64483);
        }

        private EventType(int i) {
            this.a = i;
        }
    }

    static class a {
        private final String a;
        private final String b;

        public a(String str, String str2) {
            this.a = str;
            this.b = str2;
        }

        /* JADX WARNING: Removed duplicated region for block: B:27:0x0059  */
        /* JADX WARNING: Removed duplicated region for block: B:15:0x0041 A:{SYNTHETIC, Splitter:B:15:0x0041} */
        /* JADX WARNING: Removed duplicated region for block: B:23:0x0052 A:{SYNTHETIC, Splitter:B:23:0x0052} */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private static void a(File file) {
            Throwable th;
            RandomAccessFile randomAccessFile;
            AppMethodBeat.i(64492);
            RandomAccessFile randomAccessFile2;
            try {
                randomAccessFile2 = new RandomAccessFile(file, "rw");
                try {
                    int parseInt = Integer.parseInt("00001000", 2);
                    randomAccessFile2.seek(7);
                    int read = randomAccessFile2.read();
                    if ((read & parseInt) > 0) {
                        randomAccessFile2.seek(7);
                        randomAccessFile2.write(((parseInt ^ -1) & 255) & read);
                    }
                    try {
                        randomAccessFile2.close();
                        AppMethodBeat.o(64492);
                    } catch (IOException e) {
                        AppMethodBeat.o(64492);
                    }
                } catch (Exception e2) {
                    if (randomAccessFile2 == null) {
                        try {
                            randomAccessFile2.close();
                            AppMethodBeat.o(64492);
                            return;
                        } catch (IOException e3) {
                            AppMethodBeat.o(64492);
                            return;
                        }
                    }
                    AppMethodBeat.o(64492);
                } catch (Throwable th2) {
                    th = th2;
                    randomAccessFile = randomAccessFile2;
                    if (randomAccessFile != null) {
                        try {
                            randomAccessFile.close();
                        } catch (IOException e4) {
                        }
                    }
                    AppMethodBeat.o(64492);
                    throw th;
                }
            } catch (Exception e5) {
                randomAccessFile2 = null;
                if (randomAccessFile2 == null) {
                }
            } catch (Throwable th3) {
                th = th3;
                randomAccessFile = null;
                if (randomAccessFile != null) {
                }
                AppMethodBeat.o(64492);
                throw th;
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:54:0x0096 A:{SYNTHETIC, Splitter:B:54:0x0096} */
        /* JADX WARNING: Removed duplicated region for block: B:74:0x00bd  */
        /* JADX WARNING: Removed duplicated region for block: B:57:0x009b A:{SYNTHETIC, Splitter:B:57:0x009b} */
        /* JADX WARNING: Removed duplicated region for block: B:67:0x00b1 A:{SYNTHETIC, Splitter:B:67:0x00b1} */
        /* JADX WARNING: Removed duplicated region for block: B:70:0x00b6 A:{SYNTHETIC, Splitter:B:70:0x00b6} */
        /* JADX WARNING: Removed duplicated region for block: B:20:0x0051 A:{SYNTHETIC, Splitter:B:20:0x0051} */
        /* JADX WARNING: Removed duplicated region for block: B:23:0x0056 A:{SYNTHETIC, Splitter:B:23:0x0056} */
        /* JADX WARNING: Removed duplicated region for block: B:42:0x0082 A:{SYNTHETIC, Splitter:B:42:0x0082} */
        /* JADX WARNING: Removed duplicated region for block: B:45:0x0087 A:{SYNTHETIC, Splitter:B:45:0x0087} */
        /* JADX WARNING: Removed duplicated region for block: B:54:0x0096 A:{SYNTHETIC, Splitter:B:54:0x0096} */
        /* JADX WARNING: Removed duplicated region for block: B:57:0x009b A:{SYNTHETIC, Splitter:B:57:0x009b} */
        /* JADX WARNING: Removed duplicated region for block: B:74:0x00bd  */
        /* JADX WARNING: Removed duplicated region for block: B:67:0x00b1 A:{SYNTHETIC, Splitter:B:67:0x00b1} */
        /* JADX WARNING: Removed duplicated region for block: B:70:0x00b6 A:{SYNTHETIC, Splitter:B:70:0x00b6} */
        /* JADX WARNING: Removed duplicated region for block: B:20:0x0051 A:{SYNTHETIC, Splitter:B:20:0x0051} */
        /* JADX WARNING: Removed duplicated region for block: B:23:0x0056 A:{SYNTHETIC, Splitter:B:23:0x0056} */
        /* JADX WARNING: Removed duplicated region for block: B:42:0x0082 A:{SYNTHETIC, Splitter:B:42:0x0082} */
        /* JADX WARNING: Removed duplicated region for block: B:45:0x0087 A:{SYNTHETIC, Splitter:B:45:0x0087} */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void a() {
            Throwable th;
            BufferedInputStream bufferedInputStream;
            Throwable th2;
            ZipOutputStream zipOutputStream;
            FileOutputStream fileOutputStream;
            AppMethodBeat.i(64491);
            FileOutputStream fileOutputStream2;
            ZipOutputStream zipOutputStream2;
            try {
                fileOutputStream2 = new FileOutputStream(this.b);
                try {
                    zipOutputStream2 = new ZipOutputStream(new BufferedOutputStream(fileOutputStream2));
                    try {
                        byte[] bArr = new byte[2048];
                        String str = this.a;
                        FileInputStream fileInputStream;
                        BufferedInputStream bufferedInputStream2;
                        try {
                            fileInputStream = new FileInputStream(str);
                            try {
                                bufferedInputStream2 = new BufferedInputStream(fileInputStream, 2048);
                                try {
                                    zipOutputStream2.putNextEntry(new ZipEntry(str.substring(str.lastIndexOf("/") + 1)));
                                    while (true) {
                                        int read = bufferedInputStream2.read(bArr, 0, 2048);
                                        if (read == -1) {
                                            break;
                                        }
                                        zipOutputStream2.write(bArr, 0, read);
                                    }
                                    zipOutputStream2.flush();
                                    zipOutputStream2.closeEntry();
                                    try {
                                        bufferedInputStream2.close();
                                    } catch (IOException e) {
                                    }
                                    try {
                                        fileInputStream.close();
                                    } catch (IOException e2) {
                                    }
                                } catch (Exception e3) {
                                    if (bufferedInputStream2 != null) {
                                    }
                                    if (fileInputStream != null) {
                                    }
                                    a(new File(this.b));
                                    zipOutputStream2.close();
                                    fileOutputStream2.close();
                                    AppMethodBeat.o(64491);
                                } catch (Throwable th3) {
                                    th = th3;
                                    bufferedInputStream = bufferedInputStream2;
                                    if (bufferedInputStream != null) {
                                    }
                                    if (fileInputStream != null) {
                                    }
                                    AppMethodBeat.o(64491);
                                    throw th;
                                }
                            } catch (Exception e4) {
                                bufferedInputStream2 = null;
                                if (bufferedInputStream2 != null) {
                                    try {
                                        bufferedInputStream2.close();
                                    } catch (IOException e5) {
                                    }
                                }
                                if (fileInputStream != null) {
                                    try {
                                        fileInputStream.close();
                                    } catch (IOException e6) {
                                    }
                                }
                                a(new File(this.b));
                                zipOutputStream2.close();
                                fileOutputStream2.close();
                                AppMethodBeat.o(64491);
                            } catch (Throwable th22) {
                                th = th22;
                                bufferedInputStream = null;
                                if (bufferedInputStream != null) {
                                    try {
                                        bufferedInputStream.close();
                                    } catch (IOException e7) {
                                    }
                                }
                                if (fileInputStream != null) {
                                    try {
                                        fileInputStream.close();
                                    } catch (IOException e8) {
                                    }
                                }
                                AppMethodBeat.o(64491);
                                throw th;
                            }
                        } catch (Exception e9) {
                            bufferedInputStream2 = null;
                            fileInputStream = null;
                            if (bufferedInputStream2 != null) {
                            }
                            if (fileInputStream != null) {
                            }
                            a(new File(this.b));
                            zipOutputStream2.close();
                            fileOutputStream2.close();
                            AppMethodBeat.o(64491);
                        } catch (Throwable th222) {
                            th = th222;
                            bufferedInputStream = null;
                            fileInputStream = null;
                            if (bufferedInputStream != null) {
                            }
                            if (fileInputStream != null) {
                            }
                            AppMethodBeat.o(64491);
                            throw th;
                        }
                        a(new File(this.b));
                        try {
                            zipOutputStream2.close();
                        } catch (IOException e10) {
                        }
                        try {
                            fileOutputStream2.close();
                            AppMethodBeat.o(64491);
                        } catch (IOException e11) {
                            AppMethodBeat.o(64491);
                        }
                    } catch (Exception e12) {
                        zipOutputStream = zipOutputStream2;
                        fileOutputStream = fileOutputStream2;
                        if (zipOutputStream != null) {
                            try {
                                zipOutputStream.close();
                            } catch (IOException e13) {
                            }
                        }
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                                AppMethodBeat.o(64491);
                                return;
                            } catch (IOException e14) {
                                AppMethodBeat.o(64491);
                                return;
                            }
                        }
                        AppMethodBeat.o(64491);
                    } catch (Throwable th4) {
                        th222 = th4;
                        if (zipOutputStream2 != null) {
                            try {
                                zipOutputStream2.close();
                            } catch (IOException e15) {
                            }
                        }
                        if (fileOutputStream2 != null) {
                            try {
                                fileOutputStream2.close();
                            } catch (IOException e16) {
                            }
                        }
                        AppMethodBeat.o(64491);
                        throw th222;
                    }
                } catch (Exception e17) {
                    zipOutputStream = null;
                    fileOutputStream = fileOutputStream2;
                    if (zipOutputStream != null) {
                    }
                    if (fileOutputStream != null) {
                    }
                } catch (Throwable th5) {
                    th222 = th5;
                    zipOutputStream2 = null;
                    if (zipOutputStream2 != null) {
                    }
                    if (fileOutputStream2 != null) {
                    }
                    AppMethodBeat.o(64491);
                    throw th222;
                }
            } catch (Exception e18) {
                zipOutputStream = null;
                fileOutputStream = null;
                if (zipOutputStream != null) {
                }
                if (fileOutputStream != null) {
                }
            } catch (Throwable th6) {
                th222 = th6;
                zipOutputStream2 = null;
                fileOutputStream2 = null;
                if (zipOutputStream2 != null) {
                }
                if (fileOutputStream2 != null) {
                }
                AppMethodBeat.o(64491);
                throw th222;
            }
        }
    }

    private TbsLogReport(Context context) {
        AppMethodBeat.i(64493);
        this.c = context.getApplicationContext();
        HandlerThread handlerThread = new HandlerThread("TbsLogReportThread");
        handlerThread.start();
        this.b = new ax(this, handlerThread.getLooper());
        AppMethodBeat.o(64493);
    }

    private String a(int i) {
        AppMethodBeat.i(64512);
        String str = i + "|";
        AppMethodBeat.o(64512);
        return str;
    }

    private String a(long j) {
        AppMethodBeat.i(64509);
        String str = null;
        try {
            str = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(new Date(j));
        } catch (Exception e) {
        }
        AppMethodBeat.o(64509);
        return str;
    }

    private String a(String str) {
        AppMethodBeat.i(64511);
        StringBuilder stringBuilder = new StringBuilder();
        if (str == null) {
            str = "";
        }
        String stringBuilder2 = stringBuilder.append(str).append("|").toString();
        AppMethodBeat.o(64511);
        return stringBuilder2;
    }

    private JSONArray a() {
        JSONArray jSONArray;
        AppMethodBeat.i(64505);
        String string = d().getString("tbs_download_upload", null);
        if (string == null) {
            jSONArray = new JSONArray();
        } else {
            try {
                jSONArray = new JSONArray(string);
                if (jSONArray.length() > 5) {
                    JSONArray jSONArray2 = new JSONArray();
                    int length = jSONArray.length() - 1;
                    if (length > jSONArray.length() - 5) {
                        jSONArray2.put(jSONArray.get(length));
                        AppMethodBeat.o(64505);
                        return jSONArray2;
                    }
                }
            } catch (Exception e) {
                jSONArray = new JSONArray();
            }
        }
        AppMethodBeat.o(64505);
        return jSONArray;
    }

    private void a(int i, TbsLogInfo tbsLogInfo) {
        String str;
        AppMethodBeat.i(64504);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(a(i));
        stringBuilder.append(a(b.c(this.c)));
        stringBuilder.append(a(s.a(this.c)));
        stringBuilder.append(a(an.a().n(this.c)));
        String str2 = Build.MODEL;
        try {
            str = new String(str2.getBytes("UTF-8"), "ISO8859-1");
        } catch (Exception e) {
            str = str2;
        }
        stringBuilder.append(a(str));
        str = this.c.getPackageName();
        stringBuilder.append(a(str));
        if ("com.tencent.mm".equals(str)) {
            stringBuilder.append(a(b.a(this.c, TbsDownloader.TBS_METADATA)));
        } else {
            stringBuilder.append(a(b.b(this.c)));
        }
        stringBuilder.append(a(a(tbsLogInfo.b)));
        stringBuilder.append(a(tbsLogInfo.c));
        stringBuilder.append(a(tbsLogInfo.d));
        stringBuilder.append(a(tbsLogInfo.e));
        stringBuilder.append(a(tbsLogInfo.f));
        stringBuilder.append(a(tbsLogInfo.g));
        stringBuilder.append(a(tbsLogInfo.h));
        stringBuilder.append(a(tbsLogInfo.i));
        stringBuilder.append(a(tbsLogInfo.j));
        stringBuilder.append(a(tbsLogInfo.k));
        stringBuilder.append(b(tbsLogInfo.q));
        stringBuilder.append(b(tbsLogInfo.l));
        stringBuilder.append(b(tbsLogInfo.m));
        stringBuilder.append(a(tbsLogInfo.n));
        stringBuilder.append(a(tbsLogInfo.a));
        stringBuilder.append(a(tbsLogInfo.o));
        stringBuilder.append(a(tbsLogInfo.p));
        stringBuilder.append(a(TbsDownloadConfig.getInstance(this.c).mPreferences.getInt(TbsConfigKey.KEY_TBS_DOWNLOAD_V, 0)));
        stringBuilder.append(a(b.f(this.c)));
        stringBuilder.append(a("4.3.0.1057_43644"));
        stringBuilder.append(false);
        SharedPreferences d = d();
        JSONArray a = a();
        JSONArray jSONArray = new JSONArray();
        if (jSONArray.length() >= 5) {
            for (int i2 = 4; i2 > 0; i2--) {
                try {
                    jSONArray.put(a.get(jSONArray.length() - i2));
                } catch (Exception e2) {
                    TbsLog.e("upload", "JSONArray transform error!");
                }
            }
        } else {
            jSONArray = a;
        }
        jSONArray.put(stringBuilder.toString());
        Editor edit = d.edit();
        edit.putString("tbs_download_upload", jSONArray.toString());
        edit.commit();
        if (this.d || i != EventType.TYPE_LOAD.a) {
            b();
        }
        AppMethodBeat.o(64504);
    }

    private void a(int i, TbsLogInfo tbsLogInfo, EventType eventType) {
        AppMethodBeat.i(64498);
        tbsLogInfo.setErrorCode(i);
        tbsLogInfo.setEventTime(System.currentTimeMillis());
        QbSdk.m.onInstallFinish(i);
        eventReport(eventType, tbsLogInfo);
        AppMethodBeat.o(64498);
    }

    private String b(long j) {
        AppMethodBeat.i(64513);
        String str = j + "|";
        AppMethodBeat.o(64513);
        return str;
    }

    private void b() {
        AppMethodBeat.i(64507);
        if (QbSdk.n != null && QbSdk.n.containsKey(QbSdk.KEY_SET_SENDREQUEST_AND_UPLOAD) && QbSdk.n.get(QbSdk.KEY_SET_SENDREQUEST_AND_UPLOAD).equals("false")) {
            TbsLog.i("upload", "[TbsLogReport.sendLogReportRequest] -- SET_SENDREQUEST_AND_UPLOAD is false");
            AppMethodBeat.o(64507);
            return;
        }
        TbsLog.i(TbsDownloader.LOGTAG, "[TbsApkDownloadStat.reportDownloadStat]");
        JSONArray a = a();
        if (a == null || a.length() == 0) {
            TbsLog.i(TbsDownloader.LOGTAG, "[TbsApkDownloadStat.reportDownloadStat] no data");
            AppMethodBeat.o(64507);
            return;
        }
        TbsLog.i(TbsDownloader.LOGTAG, "[TbsApkDownloadStat.reportDownloadStat] jsonArray:".concat(String.valueOf(a)));
        try {
            TbsLog.i(TbsDownloader.LOGTAG, "[TbsApkDownloadStat.reportDownloadStat] response:" + n.a(v.a(this.c).c(), a.toString().getBytes(ProtocolPackage.ServerEncoding), new az(this), true) + " testcase: -1");
            AppMethodBeat.o(64507);
        } catch (Throwable th) {
            AppMethodBeat.o(64507);
        }
    }

    private void c() {
        AppMethodBeat.i(64508);
        Editor edit = d().edit();
        edit.remove("tbs_download_upload");
        edit.commit();
        AppMethodBeat.o(64508);
    }

    private SharedPreferences d() {
        AppMethodBeat.i(64510);
        SharedPreferences sharedPreferences = this.c.getSharedPreferences("tbs_download_stat", 4);
        AppMethodBeat.o(64510);
        return sharedPreferences;
    }

    public static TbsLogReport getInstance(Context context) {
        AppMethodBeat.i(64494);
        if (a == null) {
            synchronized (TbsLogReport.class) {
                try {
                    if (a == null) {
                        a = new TbsLogReport(context);
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.o(64494);
                    }
                }
            }
        }
        TbsLogReport tbsLogReport = a;
        AppMethodBeat.o(64494);
        return tbsLogReport;
    }

    public void clear() {
        AppMethodBeat.i(64514);
        try {
            Editor edit = d().edit();
            edit.clear();
            edit.commit();
            AppMethodBeat.o(64514);
        } catch (Exception e) {
            AppMethodBeat.o(64514);
        }
    }

    public void dailyReport() {
        AppMethodBeat.i(64502);
        this.b.sendEmptyMessage(601);
        AppMethodBeat.o(64502);
    }

    public void eventReport(EventType eventType, TbsLogInfo tbsLogInfo) {
        AppMethodBeat.i(64503);
        try {
            TbsLogInfo tbsLogInfo2 = (TbsLogInfo) tbsLogInfo.clone();
            Message obtainMessage = this.b.obtainMessage();
            obtainMessage.what = 600;
            obtainMessage.arg1 = eventType.a;
            obtainMessage.obj = tbsLogInfo2;
            this.b.sendMessage(obtainMessage);
            AppMethodBeat.o(64503);
        } catch (Throwable th) {
            TbsLog.w("upload", "[TbsLogReport.eventReport] error, message=" + th.getMessage());
            AppMethodBeat.o(64503);
        }
    }

    public boolean getShouldUploadEventReport() {
        return this.d;
    }

    /* JADX WARNING: Removed duplicated region for block: B:50:0x0167 A:{SYNTHETIC, Splitter:B:50:0x0167} */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x016c A:{SYNTHETIC, Splitter:B:53:0x016c} */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0171  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0115 A:{SYNTHETIC, Splitter:B:32:0x0115} */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x011a A:{SYNTHETIC, Splitter:B:35:0x011a} */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x019e  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x011f  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0167 A:{SYNTHETIC, Splitter:B:50:0x0167} */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x016c A:{SYNTHETIC, Splitter:B:53:0x016c} */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0171  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0115 A:{SYNTHETIC, Splitter:B:32:0x0115} */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x011a A:{SYNTHETIC, Splitter:B:35:0x011a} */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x011f  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x019e  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0167 A:{SYNTHETIC, Splitter:B:50:0x0167} */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x016c A:{SYNTHETIC, Splitter:B:53:0x016c} */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0171  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void reportTbsLog() {
        ByteArrayOutputStream byteArrayOutputStream;
        Throwable th;
        AppMethodBeat.i(64506);
        if (QbSdk.n != null && QbSdk.n.containsKey(QbSdk.KEY_SET_SENDREQUEST_AND_UPLOAD) && QbSdk.n.get(QbSdk.KEY_SET_SENDREQUEST_AND_UPLOAD).equals("false")) {
            TbsLog.i("upload", "[TbsLogReport.reportTbsLog] -- SET_SENDREQUEST_AND_UPLOAD is false");
            AppMethodBeat.o(64506);
        } else if (Apn.getApnType(this.c) != 3) {
            AppMethodBeat.o(64506);
        } else {
            String tbsLogFilePath = TbsLog.getTbsLogFilePath();
            if (tbsLogFilePath == null) {
                AppMethodBeat.o(64506);
                return;
            }
            String b = o.a().b();
            String c = b.c(this.c);
            String f = b.f(this.c);
            byte[] bytes = c.getBytes();
            byte[] bytes2 = f.getBytes();
            try {
                bytes = o.a().a(bytes);
                bytes2 = o.a().a(bytes2);
            } catch (Exception e) {
            }
            String b2 = o.b(bytes);
            String str = v.a(this.c).e() + b2 + "&aid=" + o.b(bytes2);
            HashMap hashMap = new HashMap();
            hashMap.put("Content-Type", "application/octet-stream");
            hashMap.put("Charset", "UTF-8");
            hashMap.put("QUA2", s.a(this.c));
            File file;
            FileInputStream fileInputStream;
            ByteArrayOutputStream byteArrayOutputStream2;
            try {
                File file2 = new File(k.a);
                new a(tbsLogFilePath, k.a + "/tbslog_temp.zip").a();
                file = new File(k.a, "tbslog_temp.zip");
                try {
                    fileInputStream = new FileInputStream(file);
                    try {
                        bytes2 = new byte[Utility.DEFAULT_STREAM_BUFFER_SIZE];
                        byteArrayOutputStream2 = new ByteArrayOutputStream();
                        while (true) {
                            try {
                                int read = fileInputStream.read(bytes2);
                                if (read == -1) {
                                    break;
                                }
                                byteArrayOutputStream2.write(bytes2, 0, read);
                            } catch (Exception e2) {
                                byteArrayOutputStream = byteArrayOutputStream2;
                            } catch (Throwable th2) {
                                th = th2;
                                if (fileInputStream != null) {
                                }
                                if (byteArrayOutputStream2 != null) {
                                }
                                if (file != null) {
                                }
                                AppMethodBeat.o(64506);
                                throw th;
                            }
                        }
                        byteArrayOutputStream2.flush();
                        bytes2 = o.a().a(byteArrayOutputStream2.toByteArray());
                        try {
                            fileInputStream.close();
                        } catch (Exception e3) {
                        }
                        try {
                            byteArrayOutputStream2.close();
                        } catch (Exception e4) {
                        }
                        file.delete();
                    } catch (Exception e5) {
                        byteArrayOutputStream = null;
                        if (fileInputStream != null) {
                        }
                        if (byteArrayOutputStream != null) {
                        }
                        if (file != null) {
                        }
                        n.a(str + "&ek=" + b, hashMap, bytes2, new ay(this), false);
                        AppMethodBeat.o(64506);
                    } catch (Throwable th3) {
                        th = th3;
                        byteArrayOutputStream2 = null;
                        if (fileInputStream != null) {
                        }
                        if (byteArrayOutputStream2 != null) {
                        }
                        if (file != null) {
                        }
                        AppMethodBeat.o(64506);
                        throw th;
                    }
                } catch (Exception e6) {
                    byteArrayOutputStream = null;
                    fileInputStream = null;
                    if (fileInputStream != null) {
                    }
                    if (byteArrayOutputStream != null) {
                    }
                    if (file != null) {
                    }
                    n.a(str + "&ek=" + b, hashMap, bytes2, new ay(this), false);
                    AppMethodBeat.o(64506);
                } catch (Throwable th4) {
                    th = th4;
                    byteArrayOutputStream2 = null;
                    fileInputStream = null;
                    if (fileInputStream != null) {
                    }
                    if (byteArrayOutputStream2 != null) {
                    }
                    if (file != null) {
                    }
                    AppMethodBeat.o(64506);
                    throw th;
                }
            } catch (Exception e7) {
                byteArrayOutputStream = null;
                file = null;
                fileInputStream = null;
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (Exception e8) {
                    }
                }
                if (byteArrayOutputStream != null) {
                    try {
                        byteArrayOutputStream.close();
                    } catch (Exception e9) {
                    }
                }
                if (file != null) {
                    file.delete();
                    bytes2 = null;
                } else {
                    bytes2 = null;
                }
                n.a(str + "&ek=" + b, hashMap, bytes2, new ay(this), false);
                AppMethodBeat.o(64506);
            } catch (Throwable th5) {
                th = th5;
                byteArrayOutputStream2 = null;
                file = null;
                fileInputStream = null;
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (Exception e10) {
                    }
                }
                if (byteArrayOutputStream2 != null) {
                    try {
                        byteArrayOutputStream2.close();
                    } catch (Exception e11) {
                    }
                }
                if (file != null) {
                    file.delete();
                }
                AppMethodBeat.o(64506);
                throw th;
            }
            n.a(str + "&ek=" + b, hashMap, bytes2, new ay(this), false);
            AppMethodBeat.o(64506);
        }
    }

    public void setInstallErrorCode(int i, String str) {
        AppMethodBeat.i(64496);
        setInstallErrorCode(i, str, EventType.TYPE_INSTALL);
        AppMethodBeat.o(64496);
    }

    public void setInstallErrorCode(int i, String str, EventType eventType) {
        AppMethodBeat.i(64497);
        if (!(i == 200 || i == 220 || i == 221)) {
            TbsLog.i(TbsDownloader.LOGTAG, "error occured in installation, errorCode:".concat(String.valueOf(i)), true);
        }
        TbsLogInfo tbsLogInfo = tbsLogInfo();
        tbsLogInfo.setFailDetail(str);
        a(i, tbsLogInfo, eventType);
        AppMethodBeat.o(64497);
    }

    public void setInstallErrorCode(int i, Throwable th) {
        AppMethodBeat.i(64499);
        TbsLogInfo tbsLogInfo = tbsLogInfo();
        tbsLogInfo.setFailDetail(th);
        a(i, tbsLogInfo, EventType.TYPE_INSTALL);
        AppMethodBeat.o(64499);
    }

    public void setLoadErrorCode(int i, String str) {
        AppMethodBeat.i(64500);
        TbsLogInfo tbsLogInfo = tbsLogInfo();
        tbsLogInfo.setErrorCode(i);
        tbsLogInfo.setEventTime(System.currentTimeMillis());
        tbsLogInfo.setFailDetail(str);
        eventReport(EventType.TYPE_LOAD, tbsLogInfo);
        AppMethodBeat.o(64500);
    }

    public void setLoadErrorCode(int i, Throwable th) {
        AppMethodBeat.i(64501);
        String str = "NULL";
        if (th != null) {
            str = "msg: " + th.getMessage() + "; err: " + th + "; cause: " + Log.getStackTraceString(th.getCause());
            if (str.length() > WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) {
                str = str.substring(0, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
            }
        }
        setLoadErrorCode(i, str);
        AppMethodBeat.o(64501);
    }

    public void setShouldUploadEventReport(boolean z) {
        this.d = z;
    }

    public TbsLogInfo tbsLogInfo() {
        AppMethodBeat.i(64495);
        TbsLogInfo tbsLogInfo = new TbsLogInfo();
        AppMethodBeat.o(64495);
        return tbsLogInfo;
    }
}
