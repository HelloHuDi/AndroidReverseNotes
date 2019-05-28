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
    static TbsLogClient a = null;
    static File c = null;
    static String d = null;
    static byte[] e = null;
    private static boolean i = true;
    TextView b;
    private SimpleDateFormat f = null;
    private Context g = null;
    private StringBuffer h = new StringBuffer();

    class a implements Runnable {
        String a = null;

        a(String str) {
            this.a = str;
        }

        public void run() {
            AppMethodBeat.i(65338);
            if (TbsLogClient.this.b != null) {
                TbsLogClient.this.b.append(this.a + IOUtils.LINE_SEPARATOR_UNIX);
            }
            AppMethodBeat.o(65338);
        }
    }

    public TbsLogClient(Context context) {
        AppMethodBeat.i(65339);
        try {
            this.g = context.getApplicationContext();
            this.f = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss.SSS", Locale.US);
            AppMethodBeat.o(65339);
        } catch (Exception e) {
            this.f = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss.SSS");
            AppMethodBeat.o(65339);
        }
    }

    private void a() {
        AppMethodBeat.i(65340);
        try {
            if (c == null) {
                if (Environment.getExternalStorageState().equals("mounted")) {
                    String a = k.a(this.g, 6);
                    if (a == null) {
                        c = null;
                        AppMethodBeat.o(65340);
                        return;
                    }
                    c = new File(a, "tbslog.txt");
                    d = LogFileUtils.createKey();
                    e = LogFileUtils.createHeaderText(c.getName(), d);
                    AppMethodBeat.o(65340);
                    return;
                }
                c = null;
            }
            AppMethodBeat.o(65340);
        } catch (SecurityException e) {
            AppMethodBeat.o(65340);
        } catch (NullPointerException e2) {
            AppMethodBeat.o(65340);
        }
    }

    public static void setWriteLogJIT(boolean z) {
        i = z;
    }

    public void d(String str, String str2) {
    }

    public void e(String str, String str2) {
    }

    public void i(String str, String str2) {
    }

    public void setLogView(TextView textView) {
        this.b = textView;
    }

    public void showLog(String str) {
        AppMethodBeat.i(65343);
        if (this.b != null) {
            this.b.post(new a(str));
        }
        AppMethodBeat.o(65343);
    }

    public void v(String str, String str2) {
    }

    public void w(String str, String str2) {
    }

    public void writeLog(String str) {
        AppMethodBeat.i(65341);
        try {
            this.h.append(this.f.format(Long.valueOf(System.currentTimeMillis()))).append(" pid=").append(Process.myPid()).append(" tid=").append(Process.myTid()).append(str).append(IOUtils.LINE_SEPARATOR_UNIX);
            if (Thread.currentThread() != Looper.getMainLooper().getThread() || i) {
                writeLogToDisk();
            }
            if (this.h.length() > SQLiteGlobal.journalSizeLimit) {
                this.h.delete(0, this.h.length());
            }
            AppMethodBeat.o(65341);
        } catch (Exception e) {
            AppMethodBeat.o(65341);
        }
    }

    public void writeLogToDisk() {
        AppMethodBeat.i(65342);
        try {
            a();
            if (c != null) {
                LogFileUtils.writeDataToStorage(c, d, e, this.h.toString(), true);
                this.h.delete(0, this.h.length());
            }
            AppMethodBeat.o(65342);
        } catch (Exception e) {
            AppMethodBeat.o(65342);
        }
    }
}
