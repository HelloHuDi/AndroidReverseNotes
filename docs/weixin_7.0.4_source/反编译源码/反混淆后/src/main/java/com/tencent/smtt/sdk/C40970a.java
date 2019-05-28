package com.tencent.smtt.sdk;

import com.facebook.internal.Utility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/* renamed from: com.tencent.smtt.sdk.a */
public class C40970a {
    /* renamed from: a */
    public static int f16286a = 600;
    /* renamed from: b */
    private static int f16287b = 0;

    /* JADX WARNING: Removed duplicated region for block: B:24:0x006f A:{SYNTHETIC, Splitter:B:24:0x006f} */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0079 A:{SYNTHETIC, Splitter:B:30:0x0079} */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0083 A:{SYNTHETIC, Splitter:B:36:0x0083} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public static int m71063a() {
        Throwable th;
        int i = 0;
        AppMethodBeat.m2504i(63899);
        if (f16287b > 0) {
            i = f16287b;
            AppMethodBeat.m2505o(63899);
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
                    f16287b = i;
                    AppMethodBeat.m2505o(63899);
                    return i;
                } catch (Throwable th2) {
                    th = th2;
                    if (bufferedReader != null) {
                    }
                    AppMethodBeat.m2505o(63899);
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
            f16287b = i;
            AppMethodBeat.m2505o(63899);
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
            AppMethodBeat.m2505o(63899);
            throw th;
        }
        f16287b = i;
        AppMethodBeat.m2505o(63899);
        return i;
    }
}
