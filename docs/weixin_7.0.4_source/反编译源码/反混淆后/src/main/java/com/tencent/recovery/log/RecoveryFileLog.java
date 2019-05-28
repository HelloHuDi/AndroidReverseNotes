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

    /* renamed from: cm */
    public final synchronized void mo15972cm(String str, boolean z) {
        this.Arj.mo12029e(str.getBytes(), z);
    }

    /* renamed from: v */
    public final void mo11998v(String str, String str2, Object... objArr) {
        mo15972cm(m12617aG("V", str, String.format(str2, objArr)), false);
        if (this.ktK) {
            String.format(str2, objArr);
        }
    }

    /* renamed from: i */
    public final void mo11996i(String str, String str2, Object... objArr) {
        mo15972cm(m12617aG("I", str, String.format(str2, objArr)), false);
        if (this.ktK) {
            String.format(str2, objArr);
        }
    }

    /* renamed from: w */
    public final void mo11999w(String str, String str2, Object... objArr) {
        mo15972cm(m12617aG(QLog.TAG_REPORTLEVEL_COLORUSER, str, String.format(str2, objArr)), false);
        if (this.ktK) {
            String.format(str2, objArr);
        }
    }

    /* renamed from: d */
    public final void mo11994d(String str, String str2, Object... objArr) {
        mo15972cm(m12617aG(QLog.TAG_REPORTLEVEL_DEVELOPER, str, String.format(str2, objArr)), false);
        if (this.ktK) {
            String.format(str2, objArr);
        }
    }

    /* renamed from: e */
    public final void mo11995e(String str, String str2, Object... objArr) {
        mo15972cm(m12617aG(QLog.TAG_REPORTLEVEL_USER, str, String.format(str2, objArr)), false);
        if (this.ktK) {
            String.format(str2, objArr);
        }
    }

    public final void printErrStackTrace(String str, Throwable th, String str2, Object... objArr) {
        mo15972cm(m12617aG(QLog.TAG_REPORTLEVEL_USER, str, String.format(str2, objArr) + "  " + Log.getStackTraceString(th)), false);
        if (this.ktK) {
            String.format(str2, objArr);
        }
    }

    /* renamed from: aG */
    private String m12617aG(String str, String str2, String str3) {
        String format = this.Ark.format(new Date());
        return String.format("%s​%s​[%d][%d][%s]: %s​​", new Object[]{str, str2, Integer.valueOf(Process.myPid()), Long.valueOf(Thread.currentThread().getId()), format, str3});
    }
}
