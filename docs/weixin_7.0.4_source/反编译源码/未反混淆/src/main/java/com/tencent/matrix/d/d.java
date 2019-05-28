package com.tencent.matrix.d;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.os.Process;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public final class d {
    private static char[] caT = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    private static final ThreadLocal<MessageDigest> caU = new ThreadLocal<MessageDigest>() {
        /* Access modifiers changed, original: protected|final|synthetic */
        public final /* synthetic */ Object initialValue() {
            return AnonymousClass1.zN();
        }

        private static MessageDigest zN() {
            try {
                return MessageDigest.getInstance("MD5");
            } catch (NoSuchAlgorithmException e) {
                throw new RuntimeException("Initialize MD5 failed.", e);
            }
        }
    };
    private static String processName = null;

    public static String formatTime(String str, long j) {
        return new SimpleDateFormat(str).format(new Date(j));
    }

    public static String aD(Context context) {
        if (processName != null) {
            return processName;
        }
        String aE = aE(context);
        processName = aE;
        return aE;
    }

    /* JADX WARNING: Removed duplicated region for block: B:46:0x00b4 A:{SYNTHETIC, Splitter:B:46:0x00b4} */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00c1 A:{SYNTHETIC, Splitter:B:53:0x00c1} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static String aE(Context context) {
        Exception e;
        Throwable th;
        int myPid = Process.myPid();
        if (context == null || myPid <= 0) {
            return "";
        }
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        if (activityManager != null) {
            List<RunningAppProcessInfo> runningAppProcesses = activityManager.getRunningAppProcesses();
            if (runningAppProcesses != null) {
                RunningAppProcessInfo runningAppProcessInfo;
                try {
                    for (RunningAppProcessInfo runningAppProcessInfo2 : runningAppProcesses) {
                        if (runningAppProcessInfo2.pid == myPid) {
                            break;
                        }
                    }
                    runningAppProcessInfo2 = null;
                } catch (Exception e2) {
                    new StringBuilder("getProcessNameInternal exception:").append(e2.getMessage());
                    runningAppProcessInfo2 = null;
                }
                if (runningAppProcessInfo2 != null) {
                    return runningAppProcessInfo2.processName;
                }
            }
        }
        byte[] bArr = new byte[128];
        FileInputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream("/proc/" + myPid + "/cmdline");
            try {
                int read = fileInputStream.read(bArr);
                if (read > 0) {
                    for (int i = 0; i < read; i++) {
                        if (bArr[i] <= (byte) 0) {
                            read = i;
                            break;
                        }
                    }
                    String str = new String(bArr, 0, read, Charset.forName("UTF-8"));
                    try {
                        fileInputStream.close();
                        return str;
                    } catch (Exception e3) {
                        e3.getMessage();
                        return str;
                    }
                }
                try {
                    fileInputStream.close();
                } catch (Exception e22) {
                    e22.getMessage();
                }
                return "";
            } catch (Exception e4) {
                e22 = e4;
                try {
                    new StringBuilder("getProcessNameInternal exception:").append(e22.getMessage());
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Exception e222) {
                            e222.getMessage();
                        }
                    }
                    return "";
                } catch (Throwable th2) {
                    th = th2;
                    if (fileInputStream != null) {
                    }
                    throw th;
                }
            }
        } catch (Exception e5) {
            e222 = e5;
            fileInputStream = null;
            new StringBuilder("getProcessNameInternal exception:").append(e222.getMessage());
            if (fileInputStream != null) {
            }
            return "";
        } catch (Throwable th3) {
            th = th3;
            fileInputStream = null;
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (Exception e32) {
                    e32.getMessage();
                }
            }
            throw th;
        }
    }

    public static void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
            }
        }
    }

    public static String ck(String str) {
        byte[] digest = ((MessageDigest) caU.get()).digest(str.getBytes());
        int length = digest.length;
        StringBuffer stringBuffer = new StringBuffer(length * 2);
        int i = length + 0;
        for (length = 0; length < i; length++) {
            byte b = digest[length];
            char c = caT[(b & 240) >> 4];
            char c2 = caT[b & 15];
            stringBuffer.append(c);
            stringBuffer.append(c2);
        }
        return stringBuffer.toString();
    }
}
