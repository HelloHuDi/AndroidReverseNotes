package com.tencent.ttpic.device;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.ttpic.baseutils.LogUtils;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class DeviceUpdate {
    private static final String CHARSET_UTF8 = "UTF-8";
    private static final int DEFAULT_TIMEOUT_MILLIS = 10000;
    private static final String TAG = DeviceUpdate.class.getSimpleName();

    static {
        AppMethodBeat.m2504i(49867);
        AppMethodBeat.m2505o(49867);
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x006e A:{SYNTHETIC, Splitter:B:21:0x006e} */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0073 A:{Catch:{ IOException -> 0x00b4 }} */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00ba  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0078 A:{Catch:{ IOException -> 0x00b4 }} */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00a0 A:{Catch:{ IOException -> 0x00b4 }} */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00a5 A:{Catch:{ IOException -> 0x00b4 }} */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00aa A:{Catch:{ IOException -> 0x00b4 }} */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00a0 A:{Catch:{ IOException -> 0x00b4 }} */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00a5 A:{Catch:{ IOException -> 0x00b4 }} */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00aa A:{Catch:{ IOException -> 0x00b4 }} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean httpDownloadFile(String str, String str2) {
        InputStream inputStream;
        OutputStream fileOutputStream;
        Throwable e;
        boolean z;
        AppMethodBeat.m2504i(49858);
        LogUtils.m50199d(TAG, "downloadFile");
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setConnectTimeout(5000);
            httpURLConnection.setRequestMethod("GET");
            File file = new File(str2);
            if (file.exists()) {
                LogUtils.m50199d(TAG, "downloadFile file already exist");
                file.delete();
            }
            LogUtils.m50199d(TAG, "downloadFile file not exist, do new file first");
            file.createNewFile();
            try {
                inputStream = httpURLConnection.getInputStream();
                try {
                    fileOutputStream = new FileOutputStream(file);
                } catch (Exception e2) {
                    e = e2;
                    fileOutputStream = null;
                    try {
                        LogUtils.m50199d(TAG, "downloadFile getInputStream or FileOutputStream fail");
                        LogUtils.m50206e(e);
                        if (httpURLConnection != null) {
                        }
                        if (inputStream != null) {
                        }
                        if (fileOutputStream == null) {
                        }
                        AppMethodBeat.m2505o(49858);
                        return z;
                    } catch (Throwable th) {
                        e = th;
                        if (httpURLConnection != null) {
                        }
                        if (inputStream != null) {
                        }
                        if (fileOutputStream != null) {
                        }
                        AppMethodBeat.m2505o(49858);
                        throw e;
                    }
                } catch (Throwable th2) {
                    e = th2;
                    fileOutputStream = null;
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                    AppMethodBeat.m2505o(49858);
                    throw e;
                }
                try {
                    byte[] bArr = new byte[4096];
                    while (true) {
                        int read = inputStream.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        fileOutputStream.write(bArr, 0, read);
                    }
                    fileOutputStream.flush();
                    LogUtils.m50199d(TAG, "downloadFile file finish, return true");
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    fileOutputStream.close();
                    z = true;
                } catch (Exception e3) {
                    e = e3;
                    LogUtils.m50199d(TAG, "downloadFile getInputStream or FileOutputStream fail");
                    LogUtils.m50206e(e);
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    if (fileOutputStream == null) {
                        fileOutputStream.close();
                        z = false;
                    } else {
                        z = false;
                    }
                    AppMethodBeat.m2505o(49858);
                    return z;
                }
            } catch (Exception e4) {
                e = e4;
                fileOutputStream = null;
                inputStream = null;
            } catch (Throwable th3) {
                e = th3;
                fileOutputStream = null;
                inputStream = null;
                if (httpURLConnection != null) {
                }
                if (inputStream != null) {
                }
                if (fileOutputStream != null) {
                }
                AppMethodBeat.m2505o(49858);
                throw e;
            }
        } catch (IOException e5) {
            LogUtils.m50206e(e5);
            z = false;
        }
        AppMethodBeat.m2505o(49858);
        return z;
    }

    public static String checkConfigVersion(String str, String str2, String str3, String str4, String str5) {
        AppMethodBeat.m2504i(49859);
        String str6 = null;
        HashMap hashMap = new HashMap();
        hashMap.put("PackageName", str2);
        hashMap.put("camCoreVersion", str3);
        hashMap.put("AppId", str4);
        hashMap.put("AppVersion", str5);
        try {
            str6 = post(str, hashMap);
        } catch (Exception e) {
            LogUtils.m50199d(TAG, "checkConfigVersion Exception! e = ".concat(String.valueOf(e)));
        }
        AppMethodBeat.m2505o(49859);
        return str6;
    }

    public static String get(String str) {
        AppMethodBeat.m2504i(49860);
        String str2 = get(str, 10000);
        AppMethodBeat.m2505o(49860);
        return str2;
    }

    public static String get(String str, int i) {
        AppMethodBeat.m2504i(49861);
        HttpURLConnection buildConnection = buildConnection(str, i);
        buildConnection.setRequestMethod("GET");
        String response = getResponse(buildConnection);
        AppMethodBeat.m2505o(49861);
        return response;
    }

    public static String post(String str, HashMap<String, String> hashMap) {
        AppMethodBeat.m2504i(49862);
        String post = post(str, hashMap, 10000);
        AppMethodBeat.m2505o(49862);
        return post;
    }

    public static String post(String str, HashMap<String, String> hashMap, int i) {
        AppMethodBeat.m2504i(49863);
        HttpURLConnection buildConnection = buildConnection(str, i);
        buildConnection.setRequestMethod("POST");
        if (!(hashMap == null || hashMap.isEmpty())) {
            OutputStream outputStream = buildConnection.getOutputStream();
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, CHARSET_UTF8));
            StringBuilder stringBuilder = new StringBuilder("");
            for (String str2 : hashMap.keySet()) {
                if (stringBuilder.indexOf("=") > 0) {
                    stringBuilder.append("&");
                }
                stringBuilder.append(URLEncoder.encode(str2, CHARSET_UTF8)).append("=").append(URLEncoder.encode((String) hashMap.get(str2), CHARSET_UTF8));
            }
            bufferedWriter.write(stringBuilder.toString());
            bufferedWriter.flush();
            bufferedWriter.close();
            outputStream.close();
        }
        String str22 = getResponse(buildConnection);
        AppMethodBeat.m2505o(49863);
        return str22;
    }

    private static HttpURLConnection buildConnection(String str, int i) {
        AppMethodBeat.m2504i(49864);
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        httpURLConnection.setConnectTimeout(i);
        httpURLConnection.setReadTimeout(i);
        AppMethodBeat.m2505o(49864);
        return httpURLConnection;
    }

    private static String getResponse(HttpURLConnection httpURLConnection) {
        AppMethodBeat.m2504i(49865);
        if (httpURLConnection.getResponseCode() == 200) {
            InputStream inputStream = httpURLConnection.getInputStream();
            StringBuilder stringBuilder = new StringBuilder();
            byte[] bArr = new byte[WXMediaMessage.DESCRIPTION_LENGTH_LIMIT];
            while (true) {
                int read = inputStream.read(bArr);
                if (read != -1) {
                    stringBuilder.append(new String(bArr, 0, read));
                } else {
                    inputStream.close();
                    String stringBuilder2 = stringBuilder.toString();
                    AppMethodBeat.m2505o(49865);
                    return stringBuilder2;
                }
            }
        }
        AppMethodBeat.m2505o(49865);
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:117:0x0121 A:{SYNTHETIC, Splitter:B:117:0x0121} */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x0126 A:{SYNTHETIC, Splitter:B:120:0x0126} */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0080 A:{SYNTHETIC, Splitter:B:31:0x0080} */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0085 A:{SYNTHETIC, Splitter:B:34:0x0085} */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x0121 A:{SYNTHETIC, Splitter:B:117:0x0121} */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x0126 A:{SYNTHETIC, Splitter:B:120:0x0126} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static String unZip(String str, String str2) {
        InputStream fileInputStream;
        ZipInputStream zipInputStream;
        Throwable e;
        AppMethodBeat.m2504i(49866);
        String str3 = "";
        try {
            fileInputStream = new FileInputStream(str);
        } catch (FileNotFoundException e2) {
            LogUtils.m50206e(e2);
            fileInputStream = null;
        }
        if (fileInputStream != null) {
            zipInputStream = new ZipInputStream(new BufferedInputStream(fileInputStream));
            BufferedOutputStream bufferedOutputStream = null;
            FileOutputStream fileOutputStream = null;
            while (true) {
                try {
                    ZipEntry nextEntry = zipInputStream.getNextEntry();
                    if (nextEntry != null) {
                        String name = nextEntry.getName();
                        if (!name.contains("../")) {
                            File file = new File(str2 + name);
                            name = file.getParent();
                            if (name != null) {
                                File file2 = new File(name);
                                if (!file2.exists()) {
                                    file2.mkdirs();
                                }
                                FileOutputStream fileOutputStream2;
                                BufferedOutputStream bufferedOutputStream2;
                                try {
                                    fileOutputStream2 = new FileOutputStream(file);
                                    try {
                                        bufferedOutputStream2 = new BufferedOutputStream(fileOutputStream2, 4096);
                                        try {
                                            byte[] bArr = new byte[4096];
                                            while (true) {
                                                int read = zipInputStream.read(bArr, 0, 4096);
                                                if (read == -1) {
                                                    break;
                                                }
                                                bufferedOutputStream2.write(bArr, 0, read);
                                            }
                                            bufferedOutputStream2.flush();
                                            String absolutePath = file.getAbsolutePath();
                                            try {
                                                bufferedOutputStream2.close();
                                                try {
                                                    fileOutputStream2.close();
                                                    bufferedOutputStream = bufferedOutputStream2;
                                                    fileOutputStream = fileOutputStream2;
                                                    str3 = absolutePath;
                                                } catch (Exception e3) {
                                                    try {
                                                        LogUtils.m50206e(e3);
                                                        bufferedOutputStream = bufferedOutputStream2;
                                                        fileOutputStream = fileOutputStream2;
                                                        str3 = absolutePath;
                                                    } catch (Exception e4) {
                                                        e = e4;
                                                        str3 = absolutePath;
                                                    }
                                                }
                                            } catch (Exception e32) {
                                                LogUtils.m50206e(e32);
                                                try {
                                                    fileOutputStream2.close();
                                                    bufferedOutputStream = bufferedOutputStream2;
                                                    fileOutputStream = fileOutputStream2;
                                                    str3 = absolutePath;
                                                } catch (Exception e322) {
                                                    LogUtils.m50206e(e322);
                                                    bufferedOutputStream = bufferedOutputStream2;
                                                    fileOutputStream = fileOutputStream2;
                                                    str3 = absolutePath;
                                                }
                                            } catch (Throwable th) {
                                                try {
                                                    fileOutputStream2.close();
                                                } catch (Exception e5) {
                                                    LogUtils.m50206e(e5);
                                                }
                                                AppMethodBeat.m2505o(49866);
                                                throw th;
                                            }
                                        } catch (Exception e6) {
                                            e = e6;
                                        }
                                    } catch (Exception e7) {
                                        e = e7;
                                        bufferedOutputStream2 = bufferedOutputStream;
                                        try {
                                            LogUtils.m50206e(e);
                                            if (bufferedOutputStream2 != null) {
                                            }
                                            if (fileOutputStream2 != null) {
                                            }
                                            bufferedOutputStream = bufferedOutputStream2;
                                            fileOutputStream = fileOutputStream2;
                                        } catch (Throwable th2) {
                                            e = th2;
                                            if (bufferedOutputStream2 != null) {
                                                try {
                                                    bufferedOutputStream2.close();
                                                } catch (Exception e8) {
                                                    LogUtils.m50206e(e8);
                                                    if (fileOutputStream2 != null) {
                                                        try {
                                                            fileOutputStream2.close();
                                                        } catch (Exception e82) {
                                                            LogUtils.m50206e(e82);
                                                        }
                                                    }
                                                    AppMethodBeat.m2505o(49866);
                                                    throw e;
                                                } catch (Throwable e9) {
                                                    if (fileOutputStream2 != null) {
                                                        try {
                                                            fileOutputStream2.close();
                                                        } catch (Exception e822) {
                                                            LogUtils.m50206e(e822);
                                                        }
                                                    }
                                                    AppMethodBeat.m2505o(49866);
                                                    throw e9;
                                                }
                                            }
                                            if (fileOutputStream2 != null) {
                                                try {
                                                    fileOutputStream2.close();
                                                } catch (Exception e8222) {
                                                    LogUtils.m50206e(e8222);
                                                }
                                            }
                                            AppMethodBeat.m2505o(49866);
                                            throw e9;
                                        }
                                    } catch (Throwable th3) {
                                        e9 = th3;
                                        bufferedOutputStream2 = bufferedOutputStream;
                                        if (bufferedOutputStream2 != null) {
                                        }
                                        if (fileOutputStream2 != null) {
                                        }
                                        AppMethodBeat.m2505o(49866);
                                        throw e9;
                                    }
                                } catch (Exception e10) {
                                    e9 = e10;
                                    bufferedOutputStream2 = bufferedOutputStream;
                                    fileOutputStream2 = fileOutputStream;
                                    LogUtils.m50206e(e9);
                                    if (bufferedOutputStream2 != null) {
                                        try {
                                            bufferedOutputStream2.close();
                                        } catch (Exception e52) {
                                            LogUtils.m50206e(e52);
                                            if (fileOutputStream2 != null) {
                                                try {
                                                    fileOutputStream2.close();
                                                } catch (Exception e522) {
                                                    LogUtils.m50206e(e522);
                                                    bufferedOutputStream = bufferedOutputStream2;
                                                    fileOutputStream = fileOutputStream2;
                                                }
                                            }
                                            bufferedOutputStream = bufferedOutputStream2;
                                            fileOutputStream = fileOutputStream2;
                                        } catch (Throwable e92) {
                                            if (fileOutputStream2 != null) {
                                                try {
                                                    fileOutputStream2.close();
                                                } catch (Exception e82222) {
                                                    LogUtils.m50206e(e82222);
                                                }
                                            }
                                            AppMethodBeat.m2505o(49866);
                                            throw e92;
                                        }
                                    }
                                    if (fileOutputStream2 != null) {
                                        try {
                                            fileOutputStream2.close();
                                        } catch (Exception e5222) {
                                            LogUtils.m50206e(e5222);
                                            bufferedOutputStream = bufferedOutputStream2;
                                            fileOutputStream = fileOutputStream2;
                                        }
                                    }
                                    bufferedOutputStream = bufferedOutputStream2;
                                    fileOutputStream = fileOutputStream2;
                                } catch (Throwable th4) {
                                    e92 = th4;
                                    bufferedOutputStream2 = bufferedOutputStream;
                                    fileOutputStream2 = fileOutputStream;
                                    if (bufferedOutputStream2 != null) {
                                    }
                                    if (fileOutputStream2 != null) {
                                    }
                                    AppMethodBeat.m2505o(49866);
                                    throw e92;
                                }
                            }
                        }
                    } else {
                        try {
                            break;
                        } catch (IOException e11) {
                            LogUtils.m50206e(e11);
                            try {
                                fileInputStream.close();
                            } catch (IOException e112) {
                                LogUtils.m50206e(e112);
                            }
                        } catch (Throwable th5) {
                            try {
                                fileInputStream.close();
                            } catch (IOException e1122) {
                                LogUtils.m50206e(e1122);
                            }
                            AppMethodBeat.m2505o(49866);
                            throw th5;
                        }
                    }
                } catch (Exception e12) {
                    e92 = e12;
                }
            }
            zipInputStream.close();
            try {
                fileInputStream.close();
            } catch (IOException e11222) {
                LogUtils.m50206e(e11222);
            }
        }
        AppMethodBeat.m2505o(49866);
        return str3;
        try {
            LogUtils.m50206e(e92);
            try {
                zipInputStream.close();
                try {
                    fileInputStream.close();
                } catch (IOException e112222) {
                    LogUtils.m50206e(e112222);
                }
            } catch (IOException e1122222) {
                LogUtils.m50206e(e1122222);
                try {
                    fileInputStream.close();
                } catch (IOException e11222222) {
                    LogUtils.m50206e(e11222222);
                }
            } catch (Throwable th52) {
                try {
                    fileInputStream.close();
                } catch (IOException e112222222) {
                    LogUtils.m50206e(e112222222);
                }
                AppMethodBeat.m2505o(49866);
                throw th52;
            }
            AppMethodBeat.m2505o(49866);
            return str3;
        } catch (Throwable th522) {
            try {
                zipInputStream.close();
                try {
                    fileInputStream.close();
                } catch (IOException e1122222222) {
                    LogUtils.m50206e(e1122222222);
                }
            } catch (IOException e11222222222) {
                LogUtils.m50206e(e11222222222);
                try {
                    fileInputStream.close();
                } catch (IOException e112222222222) {
                    LogUtils.m50206e(e112222222222);
                }
            } catch (Throwable th5222) {
                try {
                    fileInputStream.close();
                } catch (IOException e1122222222222) {
                    LogUtils.m50206e(e1122222222222);
                }
                AppMethodBeat.m2505o(49866);
                throw th5222;
            }
            AppMethodBeat.m2505o(49866);
            throw th5222;
        }
    }
}
