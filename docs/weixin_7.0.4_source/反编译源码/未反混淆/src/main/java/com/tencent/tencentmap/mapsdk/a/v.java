package com.tencent.tencentmap.mapsdk.a;

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

public class v {
    public static final void a(Closeable closeable) {
        AppMethodBeat.i(98283);
        if (closeable != null) {
            try {
                closeable.close();
                AppMethodBeat.o(98283);
                return;
            } catch (IOException e) {
            }
        }
        AppMethodBeat.o(98283);
    }

    public static final byte[] a(InputStream inputStream) {
        Throwable th;
        Closeable closeable;
        byte[] bArr = null;
        AppMethodBeat.i(98284);
        if (inputStream == null) {
            AppMethodBeat.o(98284);
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
                    a(byteArrayOutputStream);
                    AppMethodBeat.o(98284);
                } catch (Throwable th2) {
                    th = th2;
                    closeable = byteArrayOutputStream;
                    a(closeable);
                    AppMethodBeat.o(98284);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                closeable = bArr;
                a(closeable);
                AppMethodBeat.o(98284);
                throw th;
            }
        }
        return bArr;
    }

    public static final long a(InputStream inputStream, OutputStream outputStream) {
        AppMethodBeat.i(98285);
        if (inputStream == null || outputStream == null) {
            AppMethodBeat.o(98285);
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
                    AppMethodBeat.o(98285);
                    return j;
                }
            }
        } catch (IOException e) {
            AppMethodBeat.o(98285);
            return -1;
        }
    }

    public static boolean a(String str) {
        AppMethodBeat.i(98286);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(98286);
            return false;
        }
        try {
            File file = new File(str);
            if (file.exists() && file.isDirectory()) {
                AppMethodBeat.o(98286);
                return true;
            }
            if (file.exists() && file.isFile()) {
                file.delete();
            }
            boolean mkdirs = file.mkdirs();
            AppMethodBeat.o(98286);
            return mkdirs;
        } catch (Exception e) {
            AppMethodBeat.o(98286);
            return false;
        }
    }

    public static final InputStream b(String str) {
        AppMethodBeat.i(98287);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(98287);
            return null;
        }
        try {
            File file = new File(str);
            if (file.exists() && file.isFile() && file.canRead()) {
                InputStream fileInputStream = new FileInputStream(file);
                AppMethodBeat.o(98287);
                return fileInputStream;
            }
        } catch (IOException e) {
        }
        AppMethodBeat.o(98287);
        return null;
    }

    public static boolean c(String str) {
        AppMethodBeat.i(98288);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(98288);
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
        AppMethodBeat.o(98288);
        return true;
    }

    public static void a(Bitmap bitmap) {
        AppMethodBeat.i(98289);
        if (!(bitmap == null || bitmap.isRecycled())) {
            bitmap.recycle();
        }
        AppMethodBeat.o(98289);
    }
}
