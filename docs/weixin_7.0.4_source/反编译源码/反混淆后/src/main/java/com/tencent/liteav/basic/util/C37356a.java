package com.tencent.liteav.basic.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/* renamed from: com.tencent.liteav.basic.util.a */
public class C37356a {
    /* renamed from: a */
    public static boolean m62791a(Context context) {
        AppMethodBeat.m2504i(66030);
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null) {
            AppMethodBeat.m2505o(66030);
            return false;
        }
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isConnectedOrConnecting()) {
            AppMethodBeat.m2505o(66030);
            return false;
        }
        AppMethodBeat.m2505o(66030);
        return true;
    }

    @TargetApi(18)
    /* renamed from: a */
    public static long m62788a(StatFs statFs) {
        long availableBytes;
        AppMethodBeat.m2504i(66031);
        if (VERSION.SDK_INT >= 18) {
            availableBytes = statFs.getAvailableBytes();
        } else {
            availableBytes = ((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize());
        }
        AppMethodBeat.m2505o(66031);
        return availableBytes;
    }

    /* renamed from: a */
    public static boolean m62790a(long j) {
        AppMethodBeat.m2504i(66032);
        if (C37356a.m62788a(new StatFs(Environment.getExternalStorageDirectory().getAbsolutePath())) > j) {
            AppMethodBeat.m2505o(66032);
            return true;
        }
        AppMethodBeat.m2505o(66032);
        return false;
    }

    /* renamed from: a */
    public static boolean m62793a(String str) {
        AppMethodBeat.m2504i(66033);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.m2505o(66033);
            return false;
        }
        File file = new File(str);
        if (file.exists() && file.isFile()) {
            AppMethodBeat.m2505o(66033);
            return true;
        }
        AppMethodBeat.m2505o(66033);
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x004c A:{SYNTHETIC, Splitter:B:19:0x004c} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: b */
    public static String m62795b(String str) {
        Throwable e;
        RuntimeException runtimeException;
        String str2 = null;
        AppMethodBeat.m2504i(66034);
        File file = new File(str);
        StringBuilder stringBuilder = new StringBuilder("");
        if (file.isFile()) {
            BufferedReader bufferedReader;
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
                while (true) {
                    try {
                        str2 = bufferedReader.readLine();
                        if (str2 == null) {
                            break;
                        }
                        stringBuilder.append(str2);
                    } catch (IOException e2) {
                        e = e2;
                    }
                }
                bufferedReader.close();
                str2 = stringBuilder.toString();
                try {
                    bufferedReader.close();
                    AppMethodBeat.m2505o(66034);
                } catch (IOException e3) {
                    runtimeException = new RuntimeException("IOException occurred. ", e3);
                    AppMethodBeat.m2505o(66034);
                    throw runtimeException;
                }
            } catch (IOException e4) {
                e = e4;
                bufferedReader = null;
                try {
                    RuntimeException runtimeException2 = new RuntimeException("IOException occurred. ", e);
                    AppMethodBeat.m2505o(66034);
                    throw runtimeException2;
                } catch (Throwable e22) {
                    e = e22;
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e32) {
                            runtimeException = new RuntimeException("IOException occurred. ", e32);
                            AppMethodBeat.m2505o(66034);
                            throw runtimeException;
                        }
                    }
                    AppMethodBeat.m2505o(66034);
                    throw e;
                }
            } catch (Throwable th) {
                e = th;
                bufferedReader = null;
                if (bufferedReader != null) {
                }
                AppMethodBeat.m2505o(66034);
                throw e;
            }
        }
        AppMethodBeat.m2505o(66034);
        return str2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x002d A:{SYNTHETIC, Splitter:B:15:0x002d} */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0032 A:{Catch:{ Exception -> 0x0039 }} */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0044 A:{SYNTHETIC, Splitter:B:25:0x0044} */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0049 A:{Catch:{ Exception -> 0x0050 }} */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x002d A:{SYNTHETIC, Splitter:B:15:0x002d} */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0032 A:{Catch:{ Exception -> 0x0039 }} */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0044 A:{SYNTHETIC, Splitter:B:25:0x0044} */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0049 A:{Catch:{ Exception -> 0x0050 }} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public static void m62789a(String str, byte[] bArr) {
        Throwable th;
        FileOutputStream fileOutputStream;
        BufferedOutputStream bufferedOutputStream;
        AppMethodBeat.m2504i(66035);
        FileOutputStream fileOutputStream2;
        BufferedOutputStream bufferedOutputStream2;
        try {
            fileOutputStream2 = new FileOutputStream(new File(str));
            try {
                bufferedOutputStream2 = new BufferedOutputStream(fileOutputStream2);
                try {
                    bufferedOutputStream2.write(bArr);
                    try {
                        bufferedOutputStream2.close();
                        fileOutputStream2.close();
                        AppMethodBeat.m2505o(66035);
                    } catch (Exception e) {
                        AppMethodBeat.m2505o(66035);
                    }
                } catch (Exception e2) {
                    if (bufferedOutputStream2 != null) {
                    }
                    if (fileOutputStream2 != null) {
                    }
                    AppMethodBeat.m2505o(66035);
                } catch (Throwable th2) {
                    th = th2;
                    fileOutputStream = fileOutputStream2;
                    bufferedOutputStream = bufferedOutputStream2;
                    if (bufferedOutputStream != null) {
                    }
                    if (fileOutputStream != null) {
                    }
                    AppMethodBeat.m2505o(66035);
                    throw th;
                }
            } catch (Exception e3) {
                bufferedOutputStream2 = null;
                if (bufferedOutputStream2 != null) {
                }
                if (fileOutputStream2 != null) {
                }
                AppMethodBeat.m2505o(66035);
            } catch (Throwable th3) {
                th = th3;
                fileOutputStream = fileOutputStream2;
                bufferedOutputStream = null;
                if (bufferedOutputStream != null) {
                }
                if (fileOutputStream != null) {
                }
                AppMethodBeat.m2505o(66035);
                throw th;
            }
        } catch (Exception e4) {
            fileOutputStream2 = null;
            bufferedOutputStream2 = null;
            if (bufferedOutputStream2 != null) {
                try {
                    bufferedOutputStream2.close();
                } catch (Exception e5) {
                    AppMethodBeat.m2505o(66035);
                    return;
                }
            }
            if (fileOutputStream2 != null) {
                fileOutputStream2.close();
            }
            AppMethodBeat.m2505o(66035);
        } catch (Throwable th4) {
            th = th4;
            fileOutputStream = null;
            bufferedOutputStream = null;
            if (bufferedOutputStream != null) {
                try {
                    bufferedOutputStream.close();
                } catch (Exception e6) {
                    AppMethodBeat.m2505o(66035);
                    throw th;
                }
            }
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
            AppMethodBeat.m2505o(66035);
            throw th;
        }
    }

    /* renamed from: a */
    public static boolean m62792a(Context context, String str) {
        AppMethodBeat.m2504i(66036);
        try {
            String[] list = context.getAssets().list("");
            for (String equals : list) {
                if (equals.equals(str.trim())) {
                    TXCLog.m15677i("isAssetFileExists", str + " exist");
                    AppMethodBeat.m2505o(66036);
                    return true;
                }
            }
            TXCLog.m15677i("isAssetFileExists", str + " not exist");
            AppMethodBeat.m2505o(66036);
            return false;
        } catch (IOException e) {
            TXCLog.m15677i("isAssetFileExists", str + " not exist");
            AppMethodBeat.m2505o(66036);
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x004d A:{SYNTHETIC, Splitter:B:25:0x004d} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: b */
    public static String m62794b(Context context, String str) {
        Throwable th;
        InputStream inputStream;
        AppMethodBeat.m2504i(66037);
        InputStream inputStream2 = null;
        try {
            InputStream open = context.getAssets().open(str);
            String str2;
            try {
                byte[] bArr = new byte[open.available()];
                if (open.read(bArr) <= 0) {
                    str2 = "";
                    if (open != null) {
                        try {
                            open.close();
                        } catch (IOException e) {
                        }
                    }
                    AppMethodBeat.m2505o(66037);
                    return str2;
                }
                open.close();
                str2 = new String(bArr, ProtocolPackage.ServerEncoding);
                if (open != null) {
                    try {
                        open.close();
                    } catch (IOException e2) {
                    }
                }
                AppMethodBeat.m2505o(66037);
                return str2;
            } catch (IOException e3) {
                inputStream2 = open;
                if (inputStream2 != null) {
                    try {
                        inputStream2.close();
                    } catch (IOException e4) {
                    }
                }
                str2 = "";
                AppMethodBeat.m2505o(66037);
                return str2;
            } catch (Throwable th2) {
                th = th2;
                inputStream = open;
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e5) {
                    }
                }
                AppMethodBeat.m2505o(66037);
                throw th;
            }
        } catch (IOException e6) {
        } catch (Throwable th3) {
            th = th3;
            inputStream = null;
            if (inputStream != null) {
            }
            AppMethodBeat.m2505o(66037);
            throw th;
        }
    }
}
