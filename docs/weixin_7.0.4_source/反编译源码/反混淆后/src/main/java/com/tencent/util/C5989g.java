package com.tencent.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;

/* renamed from: com.tencent.util.g */
public final class C5989g {
    public static final char DIR_SEPARATOR = File.separatorChar;
    public static final String LINE_SEPARATOR;

    static {
        AppMethodBeat.m2504i(86614);
        StringWriter stringWriter = new StringWriter(4);
        new PrintWriter(stringWriter).println();
        LINE_SEPARATOR = stringWriter.toString();
        AppMethodBeat.m2505o(86614);
    }

    public static void closeQuietly(InputStream inputStream) {
        AppMethodBeat.m2504i(86609);
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e) {
                AppMethodBeat.m2505o(86609);
                return;
            }
        }
        AppMethodBeat.m2505o(86609);
    }

    public static void closeQuietly(OutputStream outputStream) {
        AppMethodBeat.m2504i(86610);
        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (IOException e) {
                AppMethodBeat.m2505o(86610);
                return;
            }
        }
        AppMethodBeat.m2505o(86610);
    }

    public static byte[] toByteArray(InputStream inputStream) {
        AppMethodBeat.m2504i(86611);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        C5989g.copy(inputStream, byteArrayOutputStream);
        byte[] toByteArray = byteArrayOutputStream.toByteArray();
        AppMethodBeat.m2505o(86611);
        return toByteArray;
    }

    public static int copy(InputStream inputStream, OutputStream outputStream) {
        AppMethodBeat.m2504i(86612);
        long copyLarge = C5989g.copyLarge(inputStream, outputStream);
        if (copyLarge > 2147483647L) {
            AppMethodBeat.m2505o(86612);
            return -1;
        }
        int i = (int) copyLarge;
        AppMethodBeat.m2505o(86612);
        return i;
    }

    private static long copyLarge(InputStream inputStream, OutputStream outputStream) {
        AppMethodBeat.m2504i(86613);
        byte[] bArr = new byte[4096];
        long j = 0;
        while (true) {
            int read = inputStream.read(bArr);
            if (-1 != read) {
                outputStream.write(bArr, 0, read);
                j += (long) read;
            } else {
                AppMethodBeat.m2505o(86613);
                return j;
            }
        }
    }
}
