package com.tencent.tencentmap.mapsdk.p666a;

import android.text.TextUtils;
import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Stack;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* renamed from: com.tencent.tencentmap.mapsdk.a.k */
public class C46764k {
    /* renamed from: a */
    public static final void m88658a(Closeable closeable) {
        AppMethodBeat.m2504i(101230);
        if (closeable != null) {
            try {
                closeable.close();
                AppMethodBeat.m2505o(101230);
                return;
            } catch (IOException e) {
            }
        }
        AppMethodBeat.m2505o(101230);
    }

    /* renamed from: a */
    public static boolean m88660a(String str) {
        AppMethodBeat.m2504i(101231);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.m2505o(101231);
            return false;
        }
        Stack stack = new Stack();
        stack.push(str);
        while (!stack.isEmpty()) {
            File file = new File((String) stack.peek());
            if (!file.exists()) {
                stack.pop();
            } else if (file.isDirectory()) {
                File[] listFiles = file.listFiles();
                if (listFiles == null || listFiles.length == 0) {
                    file.delete();
                    stack.pop();
                } else {
                    for (File file2 : listFiles) {
                        if (file2.isDirectory()) {
                            stack.push(file2.getAbsolutePath());
                        } else {
                            file2.delete();
                        }
                    }
                }
            } else {
                file.delete();
                stack.pop();
            }
        }
        AppMethodBeat.m2505o(101231);
        return true;
    }

    /* renamed from: b */
    public static boolean m88661b(String str) {
        AppMethodBeat.m2504i(101232);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.m2505o(101232);
            return false;
        }
        try {
            File file = new File(str);
            if (file.exists() && file.isDirectory()) {
                AppMethodBeat.m2505o(101232);
                return true;
            }
            if (file.exists() && file.isFile()) {
                file.delete();
            }
            boolean mkdirs = file.mkdirs();
            AppMethodBeat.m2505o(101232);
            return mkdirs;
        } catch (Exception e) {
            AppMethodBeat.m2505o(101232);
            return false;
        }
    }

    /* renamed from: a */
    public static boolean m88659a(File file, String str) {
        Closeable closeable;
        Throwable e;
        AppMethodBeat.m2504i(101233);
        File file2 = new File(str);
        if (!file2.exists()) {
            file2.mkdirs();
        }
        ZipFile zipFile;
        Closeable closeable2;
        try {
            zipFile = new ZipFile(file);
            try {
                byte[] bArr = new byte[4096];
                Enumeration entries = zipFile.entries();
                closeable = null;
                closeable2 = null;
                while (entries.hasMoreElements()) {
                    try {
                        ZipEntry zipEntry = (ZipEntry) entries.nextElement();
                        String name = zipEntry.getName();
                        if (name == null || !name.contains("../")) {
                            if (zipEntry.isDirectory()) {
                                new File(str + File.separator + zipEntry.getName()).mkdir();
                            } else {
                                closeable2 = zipFile.getInputStream(zipEntry);
                                File file3 = new File(str + File.separator + zipEntry.getName());
                                if (!file3.exists()) {
                                    file2 = file3.getParentFile();
                                    if (!(file2 == null || file2.exists())) {
                                        file2.mkdirs();
                                    }
                                    file3.createNewFile();
                                }
                                Closeable fileOutputStream = new FileOutputStream(file3);
                                while (true) {
                                    try {
                                        int read = closeable2.read(bArr);
                                        if (read <= 0) {
                                            break;
                                        }
                                        fileOutputStream.write(bArr, 0, read);
                                    } catch (Exception e2) {
                                        e = e2;
                                        closeable = fileOutputStream;
                                        try {
                                            C36476dy.m60313b(Log.getStackTraceString(e));
                                            C46764k.m88658a(closeable2);
                                            C46764k.m88658a(closeable);
                                            try {
                                                zipFile.close();
                                            } catch (IOException e3) {
                                            }
                                            AppMethodBeat.m2505o(101233);
                                            return false;
                                        } catch (Throwable th) {
                                            e = th;
                                            C46764k.m88658a(closeable2);
                                            C46764k.m88658a(closeable);
                                            try {
                                                zipFile.close();
                                            } catch (IOException e4) {
                                            }
                                            AppMethodBeat.m2505o(101233);
                                            throw e;
                                        }
                                    } catch (Throwable th2) {
                                        e = th2;
                                        closeable = fileOutputStream;
                                        C46764k.m88658a(closeable2);
                                        C46764k.m88658a(closeable);
                                        zipFile.close();
                                        AppMethodBeat.m2505o(101233);
                                        throw e;
                                    }
                                }
                                fileOutputStream.flush();
                                C46764k.m88658a(closeable2);
                                C46764k.m88658a(fileOutputStream);
                                closeable = fileOutputStream;
                            }
                        }
                    } catch (Exception e5) {
                        e = e5;
                        C36476dy.m60313b(Log.getStackTraceString(e));
                        C46764k.m88658a(closeable2);
                        C46764k.m88658a(closeable);
                        zipFile.close();
                        AppMethodBeat.m2505o(101233);
                        return false;
                    }
                }
                C46764k.m88658a(closeable2);
                C46764k.m88658a(closeable);
                try {
                    zipFile.close();
                } catch (IOException e6) {
                }
                AppMethodBeat.m2505o(101233);
                return true;
            } catch (Exception e7) {
                e = e7;
                closeable = null;
                closeable2 = null;
                C36476dy.m60313b(Log.getStackTraceString(e));
                C46764k.m88658a(closeable2);
                C46764k.m88658a(closeable);
                zipFile.close();
                AppMethodBeat.m2505o(101233);
                return false;
            } catch (Throwable th3) {
                e = th3;
                closeable = null;
                closeable2 = null;
                C46764k.m88658a(closeable2);
                C46764k.m88658a(closeable);
                zipFile.close();
                AppMethodBeat.m2505o(101233);
                throw e;
            }
        } catch (Exception e8) {
            e = e8;
            closeable = null;
            closeable2 = null;
            zipFile = null;
            C36476dy.m60313b(Log.getStackTraceString(e));
            C46764k.m88658a(closeable2);
            C46764k.m88658a(closeable);
            zipFile.close();
            AppMethodBeat.m2505o(101233);
            return false;
        } catch (Throwable th4) {
            e = th4;
            closeable = null;
            closeable2 = null;
            zipFile = null;
            C46764k.m88658a(closeable2);
            C46764k.m88658a(closeable);
            zipFile.close();
            AppMethodBeat.m2505o(101233);
            throw e;
        }
    }
}
