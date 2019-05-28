package com.tencent.matrix.resource;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Process;
import com.tencent.matrix.resource.analyzer.model.a;
import com.tencent.matrix.resource.c.a.b;
import com.tencent.matrix.resource.c.c;
import com.tencent.matrix.resource.c.e;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class CanaryWorkerService extends MatrixJobIntentService {
    public static void a(Context context, a aVar) {
        Intent intent = new Intent(context, CanaryWorkerService.class);
        intent.setAction("com.tencent.matrix.resource.worker.action.SHRINK_HPROF");
        intent.putExtra("com.tencent.matrix.resource.worker.param.HEAPDUMP", aVar);
        MatrixJobIntentService.a(context, CanaryWorkerService.class, -84148995, intent);
    }

    /* Access modifiers changed, original: protected|final */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:19:0x00f2=Splitter:B:19:0x00f2, B:32:0x020f=Splitter:B:32:0x020f} */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:19:0x00f2=Splitter:B:19:0x00f2, B:32:0x020f=Splitter:B:32:0x020f} */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0207 A:{SYNTHETIC, Splitter:B:27:0x0207} */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x020c A:{SYNTHETIC, Splitter:B:30:0x020c} */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0207 A:{SYNTHETIC, Splitter:B:27:0x0207} */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x020c A:{SYNTHETIC, Splitter:B:30:0x020c} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void l(Intent intent) {
        FileInputStream fileInputStream;
        OutputStream bufferedOutputStream;
        Throwable th;
        if (intent != null) {
            if ("com.tencent.matrix.resource.worker.action.SHRINK_HPROF".equals(intent.getAction())) {
                a aVar = (a) intent.getSerializableExtra("com.tencent.matrix.resource.worker.param.HEAPDUMP");
                if (aVar != null) {
                    File parentFile = aVar.bWS.getParentFile();
                    String name = aVar.bWS.getName();
                    File file = new File(parentFile, name.substring(0, name.indexOf(".hprof")) + "_shrink.hprof");
                    name = "dump_result_" + Process.myPid();
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(name).append('_').append(new SimpleDateFormat("yyyyMMddHHmmss", Locale.ENGLISH).format(new Date())).append(".zip");
                    File file2 = new File(parentFile, stringBuilder.toString());
                    File file3 = aVar.bWS;
                    Object zipOutputStream;
                    try {
                        long currentTimeMillis = System.currentTimeMillis();
                        com.tencent.matrix.resource.c.a aVar2 = new com.tencent.matrix.resource.c.a();
                        try {
                            fileInputStream = new FileInputStream(file3);
                            try {
                                bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
                            } catch (Throwable th2) {
                                th = th2;
                                bufferedOutputStream = null;
                                if (bufferedOutputStream != null) {
                                }
                                if (fileInputStream != null) {
                                }
                                throw th;
                            }
                            try {
                                c cVar = new c(new BufferedInputStream(fileInputStream));
                                cVar.a(new b());
                                fileInputStream.getChannel().position(0);
                                cVar.a(new com.tencent.matrix.resource.c.a.c());
                                fileInputStream.getChannel().position(0);
                                cVar.a(new com.tencent.matrix.resource.c.a.a(new e(bufferedOutputStream)));
                                try {
                                    bufferedOutputStream.close();
                                } catch (Throwable th3) {
                                }
                                try {
                                    fileInputStream.close();
                                } catch (Throwable th4) {
                                }
                                com.tencent.matrix.d.c.i("Matrix.CanaryWorkerService", "shrink hprof file %s, size: %dk to %s, size: %dk, use time:%d", file3.getPath(), Long.valueOf(file3.length() / 1024), file.getPath(), Long.valueOf(file.length() / 1024), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                                zipOutputStream = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(file2)));
                                try {
                                    ZipEntry zipEntry = new ZipEntry("result.info");
                                    ZipEntry zipEntry2 = new ZipEntry(file.getName());
                                    zipOutputStream.putNextEntry(zipEntry);
                                    PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(zipOutputStream, Charset.forName("UTF-8")));
                                    printWriter.println("# Resource Canary Result Infomation. THIS FILE IS IMPORTANT FOR THE ANALYZER !!");
                                    printWriter.println("sdkVersion=" + VERSION.SDK_INT);
                                    printWriter.println("manufacturer=" + Build.MANUFACTURER);
                                    printWriter.println("hprofEntry=" + zipEntry2.getName());
                                    printWriter.println("leakedActivityKey=" + aVar.bWT);
                                    printWriter.flush();
                                    zipOutputStream.closeEntry();
                                    zipOutputStream.putNextEntry(zipEntry2);
                                    com.tencent.matrix.resource.a.a.c.a(file, zipOutputStream);
                                    zipOutputStream.closeEntry();
                                    file.delete();
                                    file3.delete();
                                    com.tencent.matrix.d.c.i("Matrix.CanaryWorkerService", "process hprof file use total time:%d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                                    CanaryResultService.d(this, file2.getAbsolutePath(), aVar.mActivityName);
                                    com.tencent.matrix.resource.a.a.c.ah(zipOutputStream);
                                    return;
                                } catch (IOException e) {
                                    th = e;
                                    try {
                                        com.tencent.matrix.d.c.printErrStackTrace("Matrix.CanaryWorkerService", th, "", new Object[0]);
                                        com.tencent.matrix.resource.a.a.c.ah(zipOutputStream);
                                        return;
                                    } catch (Throwable th5) {
                                        th = th5;
                                        com.tencent.matrix.resource.a.a.c.ah(zipOutputStream);
                                        throw th;
                                    }
                                }
                            } catch (Throwable th6) {
                                th = th6;
                                if (bufferedOutputStream != null) {
                                }
                                if (fileInputStream != null) {
                                }
                                throw th;
                            }
                        } catch (Throwable th7) {
                            th = th7;
                            bufferedOutputStream = null;
                            fileInputStream = null;
                            if (bufferedOutputStream != null) {
                                try {
                                    bufferedOutputStream.close();
                                } catch (Throwable th8) {
                                }
                            }
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (Throwable th9) {
                                }
                            }
                            throw th;
                        }
                    } catch (IOException e2) {
                        th = e2;
                        zipOutputStream = null;
                    } catch (Throwable th10) {
                        th = th10;
                        zipOutputStream = null;
                        com.tencent.matrix.resource.a.a.c.ah(zipOutputStream);
                        throw th;
                    }
                }
                com.tencent.matrix.d.c.e("Matrix.CanaryWorkerService", "failed to deserialize heap dump, give up shrinking and reporting.", new Object[0]);
            }
        }
    }
}
