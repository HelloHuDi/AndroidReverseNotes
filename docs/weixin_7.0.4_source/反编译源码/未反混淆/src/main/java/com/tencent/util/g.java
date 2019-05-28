package com.tencent.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;

public final class g {
    public static final char DIR_SEPARATOR = File.separatorChar;
    public static final String LINE_SEPARATOR;

    static {
        AppMethodBeat.i(86614);
        StringWriter stringWriter = new StringWriter(4);
        new PrintWriter(stringWriter).println();
        LINE_SEPARATOR = stringWriter.toString();
        AppMethodBeat.o(86614);
    }

    public static void closeQuietly(InputStream inputStream) {
        AppMethodBeat.i(86609);
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e) {
                AppMethodBeat.o(86609);
                return;
            }
        }
        AppMethodBeat.o(86609);
    }

    public static void closeQuietly(OutputStream outputStream) {
        AppMethodBeat.i(86610);
        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (IOException e) {
                AppMethodBeat.o(86610);
                return;
            }
        }
        AppMethodBeat.o(86610);
    }

    public static byte[] toByteArray(InputStream inputStream) {
        AppMethodBeat.i(86611);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        copy(inputStream, byteArrayOutputStream);
        byte[] toByteArray = byteArrayOutputStream.toByteArray();
        AppMethodBeat.o(86611);
        return toByteArray;
    }

    public static int copy(InputStream inputStream, OutputStream outputStream) {
        AppMethodBeat.i(86612);
        long copyLarge = copyLarge(inputStream, outputStream);
        if (copyLarge > 2147483647L) {
            AppMethodBeat.o(86612);
            return -1;
        }
        int i = (int) copyLarge;
        AppMethodBeat.o(86612);
        return i;
    }

    private static long copyLarge(InputStream inputStream, OutputStream outputStream) {
        AppMethodBeat.i(86613);
        byte[] bArr = new byte[4096];
        long j = 0;
        while (true) {
            int read = inputStream.read(bArr);
            if (-1 != read) {
                outputStream.write(bArr, 0, read);
                j += (long) read;
            } else {
                AppMethodBeat.o(86613);
                return j;
            }
        }
    }
}
