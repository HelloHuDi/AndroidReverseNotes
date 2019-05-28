package com.tencent.smtt.sdk;

import com.facebook.internal.Utility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class a {
    public static int a = 600;
    private static int b = 0;

    /* JADX WARNING: Removed duplicated region for block: B:24:0x006f A:{SYNTHETIC, Splitter:B:24:0x006f} */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0079 A:{SYNTHETIC, Splitter:B:30:0x0079} */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0083 A:{SYNTHETIC, Splitter:B:36:0x0083} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int a() {
        Throwable th;
        int i = 0;
        AppMethodBeat.i(63899);
        if (b > 0) {
            i = b;
            AppMethodBeat.o(63899);
            return i;
        }
        BufferedReader bufferedReader;
        try {
            int indexOf;
            String readLine;
            bufferedReader = new BufferedReader(new FileReader("/proc/meminfo"), Utility.DEFAULT_STREAM_BUFFER_SIZE);
            do {
                try {
                    readLine = bufferedReader.readLine();
                    if (readLine != null) {
                        indexOf = readLine.indexOf("MemTotal:");
                    }
                    break;
                } catch (IOException e) {
                    if (bufferedReader != null) {
                    }
                    b = i;
                    AppMethodBeat.o(63899);
                    return i;
                } catch (Throwable th2) {
                    th = th2;
                    if (bufferedReader != null) {
                    }
                    AppMethodBeat.o(63899);
                    throw th;
                }
            } while (-1 == indexOf);
            readLine = readLine.substring(indexOf + 9).trim();
            if (readLine != null && readLine.length() != 0 && readLine.contains("k")) {
                i = Integer.parseInt(readLine.substring(0, readLine.indexOf("k")).trim()) / WXMediaMessage.DESCRIPTION_LENGTH_LIMIT;
            }
            try {
                bufferedReader.close();
            } catch (IOException e2) {
            }
        } catch (IOException e3) {
            bufferedReader = null;
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e4) {
                }
            }
            b = i;
            AppMethodBeat.o(63899);
            return i;
        } catch (Throwable th3) {
            th = th3;
            bufferedReader = null;
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e5) {
                }
            }
            AppMethodBeat.o(63899);
            throw th;
        }
        b = i;
        AppMethodBeat.o(63899);
        return i;
    }
}
