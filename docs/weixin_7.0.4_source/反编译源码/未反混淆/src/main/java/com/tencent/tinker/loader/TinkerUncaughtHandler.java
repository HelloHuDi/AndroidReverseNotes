package com.tencent.tinker.loader;

import android.content.Context;
import android.os.Process;
import android.util.Log;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.Thread.UncaughtExceptionHandler;

public class TinkerUncaughtHandler implements UncaughtExceptionHandler {
    private final File ACV;
    private final Context context;
    private final UncaughtExceptionHandler xzv = Thread.getDefaultUncaughtExceptionHandler();

    public TinkerUncaughtHandler(Context context) {
        this.context = context;
        this.ACV = SharePatchFileUtil.jj(context);
    }

    public void uncaughtException(Thread thread, Throwable th) {
        Throwable e;
        new StringBuilder("TinkerUncaughtHandler catch exception:").append(Log.getStackTraceString(th));
        this.xzv.uncaughtException(thread, th);
        if (this.ACV != null && (Thread.getDefaultUncaughtExceptionHandler() instanceof TinkerUncaughtHandler)) {
            File parentFile = this.ACV.getParentFile();
            if (parentFile.exists() || parentFile.mkdirs()) {
                Object printWriter;
                try {
                    printWriter = new PrintWriter(new FileWriter(this.ACV, false));
                    try {
                        printWriter.println("process:" + ShareTinkerInternals.aD(this.context));
                        printWriter.println(ShareTinkerInternals.m(th));
                        SharePatchFileUtil.ah(printWriter);
                    } catch (IOException e2) {
                        e = e2;
                        try {
                            new StringBuilder("print crash file error:").append(Log.getStackTraceString(e));
                            SharePatchFileUtil.ah(printWriter);
                            Process.killProcess(Process.myPid());
                        } catch (Throwable th2) {
                            e = th2;
                            SharePatchFileUtil.ah(printWriter);
                            throw e;
                        }
                    }
                } catch (IOException e3) {
                    e = e3;
                    printWriter = null;
                    new StringBuilder("print crash file error:").append(Log.getStackTraceString(e));
                    SharePatchFileUtil.ah(printWriter);
                    Process.killProcess(Process.myPid());
                } catch (Throwable th3) {
                    e = th3;
                    printWriter = null;
                    SharePatchFileUtil.ah(printWriter);
                    throw e;
                }
                Process.killProcess(Process.myPid());
            }
        }
    }
}
