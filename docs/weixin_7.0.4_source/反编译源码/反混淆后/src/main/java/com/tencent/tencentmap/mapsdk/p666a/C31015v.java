package com.tencent.tencentmap.mapsdk.p666a;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Stack;

/* renamed from: com.tencent.tencentmap.mapsdk.a.v */
public class C31015v {
    /* renamed from: a */
    public static final void m49801a(Closeable closeable) {
        AppMethodBeat.m2504i(98283);
        if (closeable != null) {
            try {
                closeable.close();
                AppMethodBeat.m2505o(98283);
                return;
            } catch (IOException e) {
            }
        }
        AppMethodBeat.m2505o(98283);
    }

    /* renamed from: a */
    public static final byte[] m49803a(InputStream inputStream) {
        Throwable th;
        Closeable closeable;
        byte[] bArr = null;
        AppMethodBeat.m2504i(98284);
        if (inputStream == null) {
            AppMethodBeat.m2505o(98284);
        } else {
            Closeable byteArrayOutputStream;
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    byte[] bArr2 = new byte[4096];
                    while (true) {
                        int read = inputStream.read(bArr2, 0, 4096);
                        if (read == -1) {
                            break;
                        }
                        byteArrayOutputStream.write(bArr2, 0, read);
                    }
                    byteArrayOutputStream.flush();
                    bArr = byteArrayOutputStream.toByteArray();
                    C31015v.m49801a(byteArrayOutputStream);
                    AppMethodBeat.m2505o(98284);
                } catch (Throwable th2) {
                    th = th2;
                    closeable = byteArrayOutputStream;
                    C31015v.m49801a(closeable);
                    AppMethodBeat.m2505o(98284);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                closeable = bArr;
                C31015v.m49801a(closeable);
                AppMethodBeat.m2505o(98284);
                throw th;
            }
        }
        return bArr;
    }

    /* renamed from: a */
    public static final long m49799a(InputStream inputStream, OutputStream outputStream) {
        AppMethodBeat.m2504i(98285);
        if (inputStream == null || outputStream == null) {
            AppMethodBeat.m2505o(98285);
            return -1;
        }
        try {
            byte[] bArr = new byte[4096];
            long j = 0;
            while (true) {
                int read = inputStream.read(bArr);
                if (read > 0) {
                    outputStream.write(bArr, 0, read);
                    j += (long) read;
                } else {
                    AppMethodBeat.m2505o(98285);
                    return j;
                }
            }
        } catch (IOException e) {
            AppMethodBeat.m2505o(98285);
            return -1;
        }
    }

    /* renamed from: a */
    public static boolean m49802a(String str) {
        AppMethodBeat.m2504i(98286);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.m2505o(98286);
            return false;
        }
        try {
            File file = new File(str);
            if (file.exists() && file.isDirectory()) {
                AppMethodBeat.m2505o(98286);
                return true;
            }
            if (file.exists() && file.isFile()) {
                file.delete();
            }
            boolean mkdirs = file.mkdirs();
            AppMethodBeat.m2505o(98286);
            return mkdirs;
        } catch (Exception e) {
            AppMethodBeat.m2505o(98286);
            return false;
        }
    }

    /* renamed from: b */
    public static final InputStream m49804b(String str) {
        AppMethodBeat.m2504i(98287);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.m2505o(98287);
            return null;
        }
        try {
            File file = new File(str);
            if (file.exists() && file.isFile() && file.canRead()) {
                InputStream fileInputStream = new FileInputStream(file);
                AppMethodBeat.m2505o(98287);
                return fileInputStream;
            }
        } catch (IOException e) {
        }
        AppMethodBeat.m2505o(98287);
        return null;
    }

    /* renamed from: c */
    public static boolean m49805c(String str) {
        AppMethodBeat.m2504i(98288);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.m2505o(98288);
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
        AppMethodBeat.m2505o(98288);
        return true;
    }

    /* renamed from: a */
    public static void m49800a(Bitmap bitmap) {
        AppMethodBeat.m2504i(98289);
        if (!(bitmap == null || bitmap.isRecycled())) {
            bitmap.recycle();
        }
        AppMethodBeat.m2505o(98289);
    }
}
