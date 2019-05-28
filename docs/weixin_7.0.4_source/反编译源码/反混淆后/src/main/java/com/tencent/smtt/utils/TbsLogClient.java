package com.tencent.smtt.utils;

import android.content.Context;
import android.os.Environment;
import android.os.Looper;
import android.os.Process;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.IOUtils;
import com.tencent.wcdb.database.SQLiteGlobal;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class TbsLogClient {
    /* renamed from: a */
    static TbsLogClient f16316a = null;
    /* renamed from: c */
    static File f16317c = null;
    /* renamed from: d */
    static String f16318d = null;
    /* renamed from: e */
    static byte[] f16319e = null;
    /* renamed from: i */
    private static boolean f16320i = true;
    /* renamed from: b */
    TextView f16321b;
    /* renamed from: f */
    private SimpleDateFormat f16322f = null;
    /* renamed from: g */
    private Context f16323g = null;
    /* renamed from: h */
    private StringBuffer f16324h = new StringBuffer();

    /* renamed from: com.tencent.smtt.utils.TbsLogClient$a */
    class C40984a implements Runnable {
        /* renamed from: a */
        String f16314a = null;

        C40984a(String str) {
            this.f16314a = str;
        }

        public void run() {
            AppMethodBeat.m2504i(65338);
            if (TbsLogClient.this.f16321b != null) {
                TbsLogClient.this.f16321b.append(this.f16314a + IOUtils.LINE_SEPARATOR_UNIX);
            }
            AppMethodBeat.m2505o(65338);
        }
    }

    public TbsLogClient(Context context) {
        AppMethodBeat.m2504i(65339);
        try {
            this.f16323g = context.getApplicationContext();
            this.f16322f = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss.SSS", Locale.US);
            AppMethodBeat.m2505o(65339);
        } catch (Exception e) {
            this.f16322f = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss.SSS");
            AppMethodBeat.m2505o(65339);
        }
    }

    /* renamed from: a */
    private void m71080a() {
        AppMethodBeat.m2504i(65340);
        try {
            if (f16317c == null) {
                if (Environment.getExternalStorageState().equals("mounted")) {
                    String a = C30950k.m49545a(this.f16323g, 6);
                    if (a == null) {
                        f16317c = null;
                        AppMethodBeat.m2505o(65340);
                        return;
                    }
                    f16317c = new File(a, "tbslog.txt");
                    f16318d = LogFileUtils.createKey();
                    f16319e = LogFileUtils.createHeaderText(f16317c.getName(), f16318d);
                    AppMethodBeat.m2505o(65340);
                    return;
                }
                f16317c = null;
            }
            AppMethodBeat.m2505o(65340);
        } catch (SecurityException e) {
            AppMethodBeat.m2505o(65340);
        } catch (NullPointerException e2) {
            AppMethodBeat.m2505o(65340);
        }
    }

    public static void setWriteLogJIT(boolean z) {
        f16320i = z;
    }

    /* renamed from: d */
    public void mo13226d(String str, String str2) {
    }

    /* renamed from: e */
    public void mo13227e(String str, String str2) {
    }

    /* renamed from: i */
    public void mo13228i(String str, String str2) {
    }

    public void setLogView(TextView textView) {
        this.f16321b = textView;
    }

    public void showLog(String str) {
        AppMethodBeat.m2504i(65343);
        if (this.f16321b != null) {
            this.f16321b.post(new C40984a(str));
        }
        AppMethodBeat.m2505o(65343);
    }

    /* renamed from: v */
    public void mo13231v(String str, String str2) {
    }

    /* renamed from: w */
    public void mo13232w(String str, String str2) {
    }

    public void writeLog(String str) {
        AppMethodBeat.m2504i(65341);
        try {
            this.f16324h.append(this.f16322f.format(Long.valueOf(System.currentTimeMillis()))).append(" pid=").append(Process.myPid()).append(" tid=").append(Process.myTid()).append(str).append(IOUtils.LINE_SEPARATOR_UNIX);
            if (Thread.currentThread() != Looper.getMainLooper().getThread() || f16320i) {
                writeLogToDisk();
            }
            if (this.f16324h.length() > SQLiteGlobal.journalSizeLimit) {
                this.f16324h.delete(0, this.f16324h.length());
            }
            AppMethodBeat.m2505o(65341);
        } catch (Exception e) {
            AppMethodBeat.m2505o(65341);
        }
    }

    public void writeLogToDisk() {
        AppMethodBeat.m2504i(65342);
        try {
            m71080a();
            if (f16317c != null) {
                LogFileUtils.writeDataToStorage(f16317c, f16318d, f16319e, this.f16324h.toString(), true);
                this.f16324h.delete(0, this.f16324h.length());
            }
            AppMethodBeat.m2505o(65342);
        } catch (Exception e) {
            AppMethodBeat.m2505o(65342);
        }
    }
}
