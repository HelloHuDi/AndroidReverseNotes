package com.tencent.recovery.log;

import android.os.Process;
import android.util.Log;
import com.tencent.recovery.log.RecoveryLog.RecoveryLogImpl;
import com.tencent.recovery.storage.MMappedFileStorage;
import com.tencent.rtmp.sharp.jni.QLog;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RecoveryFileLog implements RecoveryLogImpl {
    private MMappedFileStorage Arj;
    private SimpleDateFormat Ark;
    private boolean ktK;

    public final synchronized void cm(String str, boolean z) {
        this.Arj.e(str.getBytes(), z);
    }

    public final void v(String str, String str2, Object... objArr) {
        cm(aG("V", str, String.format(str2, objArr)), false);
        if (this.ktK) {
            String.format(str2, objArr);
        }
    }

    public final void i(String str, String str2, Object... objArr) {
        cm(aG("I", str, String.format(str2, objArr)), false);
        if (this.ktK) {
            String.format(str2, objArr);
        }
    }

    public final void w(String str, String str2, Object... objArr) {
        cm(aG(QLog.TAG_REPORTLEVEL_COLORUSER, str, String.format(str2, objArr)), false);
        if (this.ktK) {
            String.format(str2, objArr);
        }
    }

    public final void d(String str, String str2, Object... objArr) {
        cm(aG(QLog.TAG_REPORTLEVEL_DEVELOPER, str, String.format(str2, objArr)), false);
        if (this.ktK) {
            String.format(str2, objArr);
        }
    }

    public final void e(String str, String str2, Object... objArr) {
        cm(aG(QLog.TAG_REPORTLEVEL_USER, str, String.format(str2, objArr)), false);
        if (this.ktK) {
            String.format(str2, objArr);
        }
    }

    public final void printErrStackTrace(String str, Throwable th, String str2, Object... objArr) {
        cm(aG(QLog.TAG_REPORTLEVEL_USER, str, String.format(str2, objArr) + "  " + Log.getStackTraceString(th)), false);
        if (this.ktK) {
            String.format(str2, objArr);
        }
    }

    private String aG(String str, String str2, String str3) {
        String format = this.Ark.format(new Date());
        return String.format("%s​%s​[%d][%d][%s]: %s​​", new Object[]{str, str2, Integer.valueOf(Process.myPid()), Long.valueOf(Thread.currentThread().getId()), format, str3});
    }
}
