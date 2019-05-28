package com.tencent.matrix.resource;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Process;
import com.tencent.matrix.p157d.C1070c;
import com.tencent.matrix.resource.analyzer.model.C1097a;
import com.tencent.matrix.resource.p161a.p162a.C1095c;
import com.tencent.matrix.resource.p164c.C1103a;
import com.tencent.matrix.resource.p164c.C1103a.C1104a;
import com.tencent.matrix.resource.p164c.C1103a.C1106b;
import com.tencent.matrix.resource.p164c.C1103a.C1108c;
import com.tencent.matrix.resource.p164c.C1113c;
import com.tencent.matrix.resource.p164c.C6288e;
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
    /* renamed from: a */
    public static void m10301a(Context context, C1097a c1097a) {
        Intent intent = new Intent(context, CanaryWorkerService.class);
        intent.setAction("com.tencent.matrix.resource.worker.action.SHRINK_HPROF");
        intent.putExtra("com.tencent.matrix.resource.worker.param.HEAPDUMP", c1097a);
        MatrixJobIntentService.m2396a(context, CanaryWorkerService.class, -84148995, intent);
    }

    /* Access modifiers changed, original: protected|final */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:19:0x00f2=Splitter:B:19:0x00f2, B:32:0x020f=Splitter:B:32:0x020f} */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:19:0x00f2=Splitter:B:19:0x00f2, B:32:0x020f=Splitter:B:32:0x020f} */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0207 A:{SYNTHETIC, Splitter:B:27:0x0207} */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x020c A:{SYNTHETIC, Splitter:B:30:0x020c} */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0207 A:{SYNTHETIC, Splitter:B:27:0x0207} */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x020c A:{SYNTHETIC, Splitter:B:30:0x020c} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: l */
    public final void mo4290l(Intent intent) {
        FileInputStream fileInputStream;
        OutputStream bufferedOutputStream;
        Throwable th;
        if (intent != null) {
            if ("com.tencent.matrix.resource.worker.action.SHRINK_HPROF".equals(intent.getAction())) {
                C1097a c1097a = (C1097a) intent.getSerializableExtra("com.tencent.matrix.resource.worker.param.HEAPDUMP");
                if (c1097a != null) {
                    File parentFile = c1097a.bWS.getParentFile();
                    String name = c1097a.bWS.getName();
                    File file = new File(parentFile, name.substring(0, name.indexOf(".hprof")) + "_shrink.hprof");
                    name = "dump_result_" + Process.myPid();
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(name).append('_').append(new SimpleDateFormat("yyyyMMddHHmmss", Locale.ENGLISH).format(new Date())).append(".zip");
                    File file2 = new File(parentFile, stringBuilder.toString());
                    File file3 = c1097a.bWS;
                    Object zipOutputStream;
                    try {
                        long currentTimeMillis = System.currentTimeMillis();
                        C1103a c1103a = new C1103a();
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
                                C1113c c1113c = new C1113c(new BufferedInputStream(fileInputStream));
                                c1113c.mo4325a(new C1106b());
                                fileInputStream.getChannel().position(0);
                                c1113c.mo4325a(new C1108c());
                                fileInputStream.getChannel().position(0);
                                c1113c.mo4325a(new C1104a(new C6288e(bufferedOutputStream)));
                                try {
                                    bufferedOutputStream.close();
                                } catch (Throwable th3) {
                                }
                                try {
                                    fileInputStream.close();
                                } catch (Throwable th4) {
                                }
                                C1070c.m2368i("Matrix.CanaryWorkerService", "shrink hprof file %s, size: %dk to %s, size: %dk, use time:%d", file3.getPath(), Long.valueOf(file3.length() / 1024), file.getPath(), Long.valueOf(file.length() / 1024), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
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
                                    printWriter.println("leakedActivityKey=" + c1097a.bWT);
                                    printWriter.flush();
                                    zipOutputStream.closeEntry();
                                    zipOutputStream.putNextEntry(zipEntry2);
                                    C1095c.m2410a(file, zipOutputStream);
                                    zipOutputStream.closeEntry();
                                    file.delete();
                                    file3.delete();
                                    C1070c.m2368i("Matrix.CanaryWorkerService", "process hprof file use total time:%d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                                    CanaryResultService.m10299d(this, file2.getAbsolutePath(), c1097a.mActivityName);
                                    C1095c.m2411ah(zipOutputStream);
                                    return;
                                } catch (IOException e) {
                                    th = e;
                                    try {
                                        C1070c.printErrStackTrace("Matrix.CanaryWorkerService", th, "", new Object[0]);
                                        C1095c.m2411ah(zipOutputStream);
                                        return;
                                    } catch (Throwable th5) {
                                        th = th5;
                                        C1095c.m2411ah(zipOutputStream);
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
                        C1095c.m2411ah(zipOutputStream);
                        throw th;
                    }
                }
                C1070c.m2367e("Matrix.CanaryWorkerService", "failed to deserialize heap dump, give up shrinking and reporting.", new Object[0]);
            }
        }
    }
}
