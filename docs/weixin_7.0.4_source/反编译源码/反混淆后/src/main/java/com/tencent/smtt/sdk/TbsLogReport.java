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
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey;
import com.tencent.smtt.utils.Apn;
import com.tencent.smtt.utils.C16160s;
import com.tencent.smtt.utils.C30950k;
import com.tencent.smtt.utils.C36443b;
import com.tencent.smtt.utils.C36446v;
import com.tencent.smtt.utils.C44463n;
import com.tencent.smtt.utils.C44464o;
import com.tencent.smtt.utils.TbsLog;
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
    /* renamed from: a */
    private static TbsLogReport f13849a;
    /* renamed from: b */
    private Handler f13850b = null;
    /* renamed from: c */
    private Context f13851c;
    /* renamed from: d */
    private boolean f13852d = false;

    public static class TbsLogInfo implements Cloneable {
        /* renamed from: a */
        int f1370a;
        /* renamed from: b */
        private long f1371b;
        /* renamed from: c */
        private String f1372c;
        /* renamed from: d */
        private String f1373d;
        /* renamed from: e */
        private int f1374e;
        /* renamed from: f */
        private int f1375f;
        /* renamed from: g */
        private int f1376g;
        /* renamed from: h */
        private int f1377h;
        /* renamed from: i */
        private String f1378i;
        /* renamed from: j */
        private int f1379j;
        /* renamed from: k */
        private int f1380k;
        /* renamed from: l */
        private long f1381l;
        /* renamed from: m */
        private long f1382m;
        /* renamed from: n */
        private int f1383n;
        /* renamed from: o */
        private String f1384o;
        /* renamed from: p */
        private String f1385p;
        /* renamed from: q */
        private long f1386q;

        private TbsLogInfo() {
            AppMethodBeat.m2504i(64484);
            resetArgs();
            AppMethodBeat.m2505o(64484);
        }

        /* synthetic */ TbsLogInfo(C44450ax c44450ax) {
            this();
        }

        /* Access modifiers changed, original: protected */
        public Object clone() {
            Object thisR;
            AppMethodBeat.m2504i(64485);
            try {
                thisR = super.clone();
                AppMethodBeat.m2505o(64485);
            } catch (CloneNotSupportedException e) {
                AppMethodBeat.m2505o(64485);
            }
            return thisR;
        }

        public int getDownFinalFlag() {
            return this.f1380k;
        }

        public void resetArgs() {
            this.f1371b = 0;
            this.f1372c = null;
            this.f1373d = null;
            this.f1374e = 0;
            this.f1375f = 0;
            this.f1376g = 0;
            this.f1377h = 2;
            this.f1378i = "unknown";
            this.f1379j = 0;
            this.f1380k = 2;
            this.f1381l = 0;
            this.f1382m = 0;
            this.f1383n = 1;
            this.f1370a = 0;
            this.f1384o = null;
            this.f1385p = null;
            this.f1386q = 0;
        }

        public void setApn(String str) {
            this.f1378i = str;
        }

        public void setCheckErrorDetail(String str) {
            AppMethodBeat.m2504i(64488);
            setErrorCode(108);
            this.f1384o = str;
            AppMethodBeat.m2505o(64488);
        }

        public void setDownConsumeTime(long j) {
            this.f1382m += j;
        }

        public void setDownFinalFlag(int i) {
            this.f1380k = i;
        }

        public void setDownloadCancel(int i) {
            this.f1376g = i;
        }

        public void setDownloadSize(long j) {
            this.f1386q += j;
        }

        public void setDownloadUrl(String str) {
            AppMethodBeat.m2504i(64486);
            if (this.f1372c == null) {
                this.f1372c = str;
                AppMethodBeat.m2505o(64486);
                return;
            }
            this.f1372c += ";" + str;
            AppMethodBeat.m2505o(64486);
        }

        public void setErrorCode(int i) {
            AppMethodBeat.m2504i(64487);
            if (!(i == 100 || i == 110 || i == 120 || i == 111 || i >= 400)) {
                TbsLog.m80435i(TbsDownloader.LOGTAG, "error occured, errorCode:".concat(String.valueOf(i)), true);
            }
            if (i == 111) {
                TbsLog.m80435i(TbsDownloader.LOGTAG, "you are not in wifi, downloading stoped", true);
            }
            this.f1370a = i;
            AppMethodBeat.m2505o(64487);
        }

        public void setEventTime(long j) {
            this.f1371b = j;
        }

        public void setFailDetail(String str) {
            AppMethodBeat.m2504i(64489);
            if (str == null) {
                AppMethodBeat.m2505o(64489);
                return;
            }
            if (str.length() > WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) {
                str = str.substring(0, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
            }
            this.f1385p = str;
            AppMethodBeat.m2505o(64489);
        }

        public void setFailDetail(Throwable th) {
            AppMethodBeat.m2504i(64490);
            if (th == null) {
                this.f1385p = "";
                AppMethodBeat.m2505o(64490);
                return;
            }
            String stackTraceString = Log.getStackTraceString(th);
            if (stackTraceString.length() > WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) {
                stackTraceString = stackTraceString.substring(0, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
            }
            this.f1385p = stackTraceString;
            AppMethodBeat.m2505o(64490);
        }

        public void setHttpCode(int i) {
            this.f1374e = i;
        }

        public void setNetworkChange(int i) {
            this.f1383n = i;
        }

        public void setNetworkType(int i) {
            this.f1379j = i;
        }

        public void setPatchUpdateFlag(int i) {
            this.f1375f = i;
        }

        public void setPkgSize(long j) {
            this.f1381l = j;
        }

        public void setResolveIp(String str) {
            this.f1373d = str;
        }

        public void setUnpkgFlag(int i) {
            this.f1377h = i;
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
        
        /* renamed from: a */
        int f13846a;

        static {
            AppMethodBeat.m2505o(64483);
        }

        private EventType(int i) {
            this.f13846a = i;
        }
    }

    /* renamed from: com.tencent.smtt.sdk.TbsLogReport$a */
    static class C30941a {
        /* renamed from: a */
        private final String f13847a;
        /* renamed from: b */
        private final String f13848b;

        public C30941a(String str, String str2) {
            this.f13847a = str;
            this.f13848b = str2;
        }

        /* JADX WARNING: Removed duplicated region for block: B:27:0x0059  */
        /* JADX WARNING: Removed duplicated region for block: B:15:0x0041 A:{SYNTHETIC, Splitter:B:15:0x0041} */
        /* JADX WARNING: Removed duplicated region for block: B:23:0x0052 A:{SYNTHETIC, Splitter:B:23:0x0052} */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        /* renamed from: a */
        private static void m49445a(File file) {
            Throwable th;
            RandomAccessFile randomAccessFile;
            AppMethodBeat.m2504i(64492);
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
                        AppMethodBeat.m2505o(64492);
                    } catch (IOException e) {
                        AppMethodBeat.m2505o(64492);
                    }
                } catch (Exception e2) {
                    if (randomAccessFile2 == null) {
                        try {
                            randomAccessFile2.close();
                            AppMethodBeat.m2505o(64492);
                            return;
                        } catch (IOException e3) {
                            AppMethodBeat.m2505o(64492);
                            return;
                        }
                    }
                    AppMethodBeat.m2505o(64492);
                } catch (Throwable th2) {
                    th = th2;
                    randomAccessFile = randomAccessFile2;
                    if (randomAccessFile != null) {
                        try {
                            randomAccessFile.close();
                        } catch (IOException e4) {
                        }
                    }
                    AppMethodBeat.m2505o(64492);
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
                AppMethodBeat.m2505o(64492);
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
        /* renamed from: a */
        public void mo49856a() {
            Throwable th;
            BufferedInputStream bufferedInputStream;
            Throwable th2;
            ZipOutputStream zipOutputStream;
            FileOutputStream fileOutputStream;
            AppMethodBeat.m2504i(64491);
            FileOutputStream fileOutputStream2;
            ZipOutputStream zipOutputStream2;
            try {
                fileOutputStream2 = new FileOutputStream(this.f13848b);
                try {
                    zipOutputStream2 = new ZipOutputStream(new BufferedOutputStream(fileOutputStream2));
                    try {
                        byte[] bArr = new byte[2048];
                        String str = this.f13847a;
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
                                    C30941a.m49445a(new File(this.f13848b));
                                    zipOutputStream2.close();
                                    fileOutputStream2.close();
                                    AppMethodBeat.m2505o(64491);
                                } catch (Throwable th3) {
                                    th = th3;
                                    bufferedInputStream = bufferedInputStream2;
                                    if (bufferedInputStream != null) {
                                    }
                                    if (fileInputStream != null) {
                                    }
                                    AppMethodBeat.m2505o(64491);
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
                                C30941a.m49445a(new File(this.f13848b));
                                zipOutputStream2.close();
                                fileOutputStream2.close();
                                AppMethodBeat.m2505o(64491);
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
                                AppMethodBeat.m2505o(64491);
                                throw th;
                            }
                        } catch (Exception e9) {
                            bufferedInputStream2 = null;
                            fileInputStream = null;
                            if (bufferedInputStream2 != null) {
                            }
                            if (fileInputStream != null) {
                            }
                            C30941a.m49445a(new File(this.f13848b));
                            zipOutputStream2.close();
                            fileOutputStream2.close();
                            AppMethodBeat.m2505o(64491);
                        } catch (Throwable th222) {
                            th = th222;
                            bufferedInputStream = null;
                            fileInputStream = null;
                            if (bufferedInputStream != null) {
                            }
                            if (fileInputStream != null) {
                            }
                            AppMethodBeat.m2505o(64491);
                            throw th;
                        }
                        C30941a.m49445a(new File(this.f13848b));
                        try {
                            zipOutputStream2.close();
                        } catch (IOException e10) {
                        }
                        try {
                            fileOutputStream2.close();
                            AppMethodBeat.m2505o(64491);
                        } catch (IOException e11) {
                            AppMethodBeat.m2505o(64491);
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
                                AppMethodBeat.m2505o(64491);
                                return;
                            } catch (IOException e14) {
                                AppMethodBeat.m2505o(64491);
                                return;
                            }
                        }
                        AppMethodBeat.m2505o(64491);
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
                        AppMethodBeat.m2505o(64491);
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
                    AppMethodBeat.m2505o(64491);
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
                AppMethodBeat.m2505o(64491);
                throw th222;
            }
        }
    }

    private TbsLogReport(Context context) {
        AppMethodBeat.m2504i(64493);
        this.f13851c = context.getApplicationContext();
        HandlerThread handlerThread = new HandlerThread("TbsLogReportThread");
        handlerThread.start();
        this.f13850b = new C44450ax(this, handlerThread.getLooper());
        AppMethodBeat.m2505o(64493);
    }

    /* renamed from: a */
    private String m49447a(int i) {
        AppMethodBeat.m2504i(64512);
        String str = i + "|";
        AppMethodBeat.m2505o(64512);
        return str;
    }

    /* renamed from: a */
    private String m49448a(long j) {
        AppMethodBeat.m2504i(64509);
        String str = null;
        try {
            str = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(new Date(j));
        } catch (Exception e) {
        }
        AppMethodBeat.m2505o(64509);
        return str;
    }

    /* renamed from: a */
    private String m49449a(String str) {
        AppMethodBeat.m2504i(64511);
        StringBuilder stringBuilder = new StringBuilder();
        if (str == null) {
            str = "";
        }
        String stringBuilder2 = stringBuilder.append(str).append("|").toString();
        AppMethodBeat.m2505o(64511);
        return stringBuilder2;
    }

    /* renamed from: a */
    private JSONArray m49450a() {
        JSONArray jSONArray;
        AppMethodBeat.m2504i(64505);
        String string = m49459d().getString("tbs_download_upload", null);
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
                        AppMethodBeat.m2505o(64505);
                        return jSONArray2;
                    }
                }
            } catch (Exception e) {
                jSONArray = new JSONArray();
            }
        }
        AppMethodBeat.m2505o(64505);
        return jSONArray;
    }

    /* renamed from: a */
    private void m49451a(int i, TbsLogInfo tbsLogInfo) {
        String str;
        AppMethodBeat.m2504i(64504);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(m49447a(i));
        stringBuilder.append(m49449a(C36443b.m60187c(this.f13851c)));
        stringBuilder.append(m49449a(C16160s.m24517a(this.f13851c)));
        stringBuilder.append(m49447a(C5813an.m8800a().mo12179n(this.f13851c)));
        String str2 = Build.MODEL;
        try {
            str = new String(str2.getBytes("UTF-8"), "ISO8859-1");
        } catch (Exception e) {
            str = str2;
        }
        stringBuilder.append(m49449a(str));
        str = this.f13851c.getPackageName();
        stringBuilder.append(m49449a(str));
        if ("com.tencent.mm".equals(str)) {
            stringBuilder.append(m49449a(C36443b.m60179a(this.f13851c, TbsDownloader.TBS_METADATA)));
        } else {
            stringBuilder.append(m49447a(C36443b.m60185b(this.f13851c)));
        }
        stringBuilder.append(m49449a(m49448a(tbsLogInfo.f1371b)));
        stringBuilder.append(m49449a(tbsLogInfo.f1372c));
        stringBuilder.append(m49449a(tbsLogInfo.f1373d));
        stringBuilder.append(m49447a(tbsLogInfo.f1374e));
        stringBuilder.append(m49447a(tbsLogInfo.f1375f));
        stringBuilder.append(m49447a(tbsLogInfo.f1376g));
        stringBuilder.append(m49447a(tbsLogInfo.f1377h));
        stringBuilder.append(m49449a(tbsLogInfo.f1378i));
        stringBuilder.append(m49447a(tbsLogInfo.f1379j));
        stringBuilder.append(m49447a(tbsLogInfo.f1380k));
        stringBuilder.append(m49455b(tbsLogInfo.f1386q));
        stringBuilder.append(m49455b(tbsLogInfo.f1381l));
        stringBuilder.append(m49455b(tbsLogInfo.f1382m));
        stringBuilder.append(m49447a(tbsLogInfo.f1383n));
        stringBuilder.append(m49447a(tbsLogInfo.f1370a));
        stringBuilder.append(m49449a(tbsLogInfo.f1384o));
        stringBuilder.append(m49449a(tbsLogInfo.f1385p));
        stringBuilder.append(m49447a(TbsDownloadConfig.getInstance(this.f13851c).mPreferences.getInt(TbsConfigKey.KEY_TBS_DOWNLOAD_V, 0)));
        stringBuilder.append(m49449a(C36443b.m60190f(this.f13851c)));
        stringBuilder.append(m49449a("4.3.0.1057_43644"));
        stringBuilder.append(false);
        SharedPreferences d = m49459d();
        JSONArray a = m49450a();
        JSONArray jSONArray = new JSONArray();
        if (jSONArray.length() >= 5) {
            for (int i2 = 4; i2 > 0; i2--) {
                try {
                    jSONArray.put(a.get(jSONArray.length() - i2));
                } catch (Exception e2) {
                    TbsLog.m80432e("upload", "JSONArray transform error!");
                }
            }
        } else {
            jSONArray = a;
        }
        jSONArray.put(stringBuilder.toString());
        Editor edit = d.edit();
        edit.putString("tbs_download_upload", jSONArray.toString());
        edit.commit();
        if (this.f13852d || i != EventType.TYPE_LOAD.f13846a) {
            m49456b();
        }
        AppMethodBeat.m2505o(64504);
    }

    /* renamed from: a */
    private void m49452a(int i, TbsLogInfo tbsLogInfo, EventType eventType) {
        AppMethodBeat.m2504i(64498);
        tbsLogInfo.setErrorCode(i);
        tbsLogInfo.setEventTime(System.currentTimeMillis());
        QbSdk.f16251m.onInstallFinish(i);
        eventReport(eventType, tbsLogInfo);
        AppMethodBeat.m2505o(64498);
    }

    /* renamed from: b */
    private String m49455b(long j) {
        AppMethodBeat.m2504i(64513);
        String str = j + "|";
        AppMethodBeat.m2505o(64513);
        return str;
    }

    /* renamed from: b */
    private void m49456b() {
        AppMethodBeat.m2504i(64507);
        if (QbSdk.f16252n != null && QbSdk.f16252n.containsKey(QbSdk.KEY_SET_SENDREQUEST_AND_UPLOAD) && QbSdk.f16252n.get(QbSdk.KEY_SET_SENDREQUEST_AND_UPLOAD).equals("false")) {
            TbsLog.m80434i("upload", "[TbsLogReport.sendLogReportRequest] -- SET_SENDREQUEST_AND_UPLOAD is false");
            AppMethodBeat.m2505o(64507);
            return;
        }
        TbsLog.m80434i(TbsDownloader.LOGTAG, "[TbsApkDownloadStat.reportDownloadStat]");
        JSONArray a = m49450a();
        if (a == null || a.length() == 0) {
            TbsLog.m80434i(TbsDownloader.LOGTAG, "[TbsApkDownloadStat.reportDownloadStat] no data");
            AppMethodBeat.m2505o(64507);
            return;
        }
        TbsLog.m80434i(TbsDownloader.LOGTAG, "[TbsApkDownloadStat.reportDownloadStat] jsonArray:".concat(String.valueOf(a)));
        try {
            TbsLog.m80434i(TbsDownloader.LOGTAG, "[TbsApkDownloadStat.reportDownloadStat] response:" + C44463n.m80450a(C36446v.m60195a(this.f13851c).mo57633c(), a.toString().getBytes(ProtocolPackage.ServerEncoding), new C44452az(this), true) + " testcase: -1");
            AppMethodBeat.m2505o(64507);
        } catch (Throwable th) {
            AppMethodBeat.m2505o(64507);
        }
    }

    /* renamed from: c */
    private void m49458c() {
        AppMethodBeat.m2504i(64508);
        Editor edit = m49459d().edit();
        edit.remove("tbs_download_upload");
        edit.commit();
        AppMethodBeat.m2505o(64508);
    }

    /* renamed from: d */
    private SharedPreferences m49459d() {
        AppMethodBeat.m2504i(64510);
        SharedPreferences sharedPreferences = this.f13851c.getSharedPreferences("tbs_download_stat", 4);
        AppMethodBeat.m2505o(64510);
        return sharedPreferences;
    }

    public static TbsLogReport getInstance(Context context) {
        AppMethodBeat.m2504i(64494);
        if (f13849a == null) {
            synchronized (TbsLogReport.class) {
                try {
                    if (f13849a == null) {
                        f13849a = new TbsLogReport(context);
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.m2505o(64494);
                    }
                }
            }
        }
        TbsLogReport tbsLogReport = f13849a;
        AppMethodBeat.m2505o(64494);
        return tbsLogReport;
    }

    public void clear() {
        AppMethodBeat.m2504i(64514);
        try {
            Editor edit = m49459d().edit();
            edit.clear();
            edit.commit();
            AppMethodBeat.m2505o(64514);
        } catch (Exception e) {
            AppMethodBeat.m2505o(64514);
        }
    }

    public void dailyReport() {
        AppMethodBeat.m2504i(64502);
        this.f13850b.sendEmptyMessage(601);
        AppMethodBeat.m2505o(64502);
    }

    public void eventReport(EventType eventType, TbsLogInfo tbsLogInfo) {
        AppMethodBeat.m2504i(64503);
        try {
            TbsLogInfo tbsLogInfo2 = (TbsLogInfo) tbsLogInfo.clone();
            Message obtainMessage = this.f13850b.obtainMessage();
            obtainMessage.what = 600;
            obtainMessage.arg1 = eventType.f13846a;
            obtainMessage.obj = tbsLogInfo2;
            this.f13850b.sendMessage(obtainMessage);
            AppMethodBeat.m2505o(64503);
        } catch (Throwable th) {
            TbsLog.m80438w("upload", "[TbsLogReport.eventReport] error, message=" + th.getMessage());
            AppMethodBeat.m2505o(64503);
        }
    }

    public boolean getShouldUploadEventReport() {
        return this.f13852d;
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
        AppMethodBeat.m2504i(64506);
        if (QbSdk.f16252n != null && QbSdk.f16252n.containsKey(QbSdk.KEY_SET_SENDREQUEST_AND_UPLOAD) && QbSdk.f16252n.get(QbSdk.KEY_SET_SENDREQUEST_AND_UPLOAD).equals("false")) {
            TbsLog.m80434i("upload", "[TbsLogReport.reportTbsLog] -- SET_SENDREQUEST_AND_UPLOAD is false");
            AppMethodBeat.m2505o(64506);
        } else if (Apn.getApnType(this.f13851c) != 3) {
            AppMethodBeat.m2505o(64506);
        } else {
            String tbsLogFilePath = TbsLog.getTbsLogFilePath();
            if (tbsLogFilePath == null) {
                AppMethodBeat.m2505o(64506);
                return;
            }
            String b = C44464o.m80456a().mo70638b();
            String c = C36443b.m60187c(this.f13851c);
            String f = C36443b.m60190f(this.f13851c);
            byte[] bytes = c.getBytes();
            byte[] bytes2 = f.getBytes();
            try {
                bytes = C44464o.m80456a().mo70637a(bytes);
                bytes2 = C44464o.m80456a().mo70637a(bytes2);
            } catch (Exception e) {
            }
            String b2 = C44464o.m80458b(bytes);
            String str = C36446v.m60195a(this.f13851c).mo57635e() + b2 + "&aid=" + C44464o.m80458b(bytes2);
            HashMap hashMap = new HashMap();
            hashMap.put("Content-Type", "application/octet-stream");
            hashMap.put("Charset", "UTF-8");
            hashMap.put("QUA2", C16160s.m24517a(this.f13851c));
            File file;
            FileInputStream fileInputStream;
            ByteArrayOutputStream byteArrayOutputStream2;
            try {
                File file2 = new File(C30950k.f13919a);
                new C30941a(tbsLogFilePath, C30950k.f13919a + "/tbslog_temp.zip").mo49856a();
                file = new File(C30950k.f13919a, "tbslog_temp.zip");
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
                                AppMethodBeat.m2505o(64506);
                                throw th;
                            }
                        }
                        byteArrayOutputStream2.flush();
                        bytes2 = C44464o.m80456a().mo70637a(byteArrayOutputStream2.toByteArray());
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
                        C44463n.m80449a(str + "&ek=" + b, hashMap, bytes2, new C44451ay(this), false);
                        AppMethodBeat.m2505o(64506);
                    } catch (Throwable th3) {
                        th = th3;
                        byteArrayOutputStream2 = null;
                        if (fileInputStream != null) {
                        }
                        if (byteArrayOutputStream2 != null) {
                        }
                        if (file != null) {
                        }
                        AppMethodBeat.m2505o(64506);
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
                    C44463n.m80449a(str + "&ek=" + b, hashMap, bytes2, new C44451ay(this), false);
                    AppMethodBeat.m2505o(64506);
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
                    AppMethodBeat.m2505o(64506);
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
                C44463n.m80449a(str + "&ek=" + b, hashMap, bytes2, new C44451ay(this), false);
                AppMethodBeat.m2505o(64506);
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
                AppMethodBeat.m2505o(64506);
                throw th;
            }
            C44463n.m80449a(str + "&ek=" + b, hashMap, bytes2, new C44451ay(this), false);
            AppMethodBeat.m2505o(64506);
        }
    }

    public void setInstallErrorCode(int i, String str) {
        AppMethodBeat.m2504i(64496);
        setInstallErrorCode(i, str, EventType.TYPE_INSTALL);
        AppMethodBeat.m2505o(64496);
    }

    public void setInstallErrorCode(int i, String str, EventType eventType) {
        AppMethodBeat.m2504i(64497);
        if (!(i == 200 || i == 220 || i == 221)) {
            TbsLog.m80435i(TbsDownloader.LOGTAG, "error occured in installation, errorCode:".concat(String.valueOf(i)), true);
        }
        TbsLogInfo tbsLogInfo = tbsLogInfo();
        tbsLogInfo.setFailDetail(str);
        m49452a(i, tbsLogInfo, eventType);
        AppMethodBeat.m2505o(64497);
    }

    public void setInstallErrorCode(int i, Throwable th) {
        AppMethodBeat.m2504i(64499);
        TbsLogInfo tbsLogInfo = tbsLogInfo();
        tbsLogInfo.setFailDetail(th);
        m49452a(i, tbsLogInfo, EventType.TYPE_INSTALL);
        AppMethodBeat.m2505o(64499);
    }

    public void setLoadErrorCode(int i, String str) {
        AppMethodBeat.m2504i(64500);
        TbsLogInfo tbsLogInfo = tbsLogInfo();
        tbsLogInfo.setErrorCode(i);
        tbsLogInfo.setEventTime(System.currentTimeMillis());
        tbsLogInfo.setFailDetail(str);
        eventReport(EventType.TYPE_LOAD, tbsLogInfo);
        AppMethodBeat.m2505o(64500);
    }

    public void setLoadErrorCode(int i, Throwable th) {
        AppMethodBeat.m2504i(64501);
        String str = "NULL";
        if (th != null) {
            str = "msg: " + th.getMessage() + "; err: " + th + "; cause: " + Log.getStackTraceString(th.getCause());
            if (str.length() > WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) {
                str = str.substring(0, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
            }
        }
        setLoadErrorCode(i, str);
        AppMethodBeat.m2505o(64501);
    }

    public void setShouldUploadEventReport(boolean z) {
        this.f13852d = z;
    }

    public TbsLogInfo tbsLogInfo() {
        AppMethodBeat.m2504i(64495);
        TbsLogInfo tbsLogInfo = new TbsLogInfo();
        AppMethodBeat.m2505o(64495);
        return tbsLogInfo;
    }
}
