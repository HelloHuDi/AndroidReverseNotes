package com.tencent.tmassistantsdk.downloadservice;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Environment;
import android.os.PowerManager.WakeLock;
import android.os.StatFs;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.tmassistantsdk.storage.TMAssistantFile;
import com.tencent.tmassistantsdk.util.GlobalUtil;
import com.tencent.tmassistantsdk.util.TMLog;
import com.tencent.ttpic.baseutils.IOUtils;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.io.File;
import java.net.URI;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class DownloadHelper {
    public static final int PHONE = 1;
    public static final float SAVE_FATOR = 1.5f;
    public static final long SAVE_LENGTH = 104857600;
    public static final int SDCARD = 2;
    public static final String TAG = DownloadHelper.class.getSimpleName();
    public static final int UNKNOWN = 0;

    static {
        AppMethodBeat.i(75713);
        AppMethodBeat.o(75713);
    }

    public static WakeLock getWakeLock() {
        return null;
    }

    public static String correctURL(String str) {
        AppMethodBeat.i(75700);
        String trim = str.replace("\r", "").replace(IOUtils.LINE_SEPARATOR_UNIX, "").trim();
        String str2 = new String(trim);
        try {
            Uri parse = Uri.parse(trim);
            String lastPathSegment = parse.getLastPathSegment();
            if (lastPathSegment != null && lastPathSegment.length() > 0) {
                str2 = str2.replace(lastPathSegment, URLEncoder.encode(parse.getLastPathSegment()).replace("+", "%20"));
            }
        } catch (Exception e) {
            ab.printErrStackTrace(TAG, e, "", new Object[0]);
        }
        AppMethodBeat.o(75700);
        return str2;
    }

    public static String genAPKFileName(String str) {
        AppMethodBeat.i(75701);
        if (str.contains(".apk")) {
            CharSequence trim = str.trim().substring(str.lastIndexOf("/") + 1).trim();
            if (trim.contains("?")) {
                trim = trim.substring(0, trim.lastIndexOf("?"));
            }
            if (!TextUtils.isEmpty(trim)) {
                TMLog.i(TAG, "file name = ".concat(String.valueOf(trim)));
                String renameAPKFileName = renameAPKFileName(trim);
                AppMethodBeat.o(75701);
                return renameAPKFileName;
            }
        }
        AppMethodBeat.o(75701);
        return null;
    }

    public static String decodeFileName(String str) {
        AppMethodBeat.i(75702);
        if (str != null) {
            String decode = URLDecoder.decode(str);
            AppMethodBeat.o(75702);
            return decode;
        }
        AppMethodBeat.o(75702);
        return null;
    }

    public static String correctFileName(String str) {
        AppMethodBeat.i(75703);
        String replace = str.replace("?", "_").replace("*", "_").replace(" ", "_").replace("$", "_").replace("&", "_").replace("@", "_").replace("#", "_").replace("<", "_").replace(">", "_").replace("|", "_").replace(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D, "_").replace("/", "_").replace("\\", "_").replace("\"", "_");
        AppMethodBeat.o(75703);
        return replace;
    }

    public static String renameAPKFileName(String str) {
        AppMethodBeat.i(75704);
        if (str == null) {
            AppMethodBeat.o(75704);
            return null;
        }
        int lastIndexOf = str.lastIndexOf(46);
        if (lastIndexOf <= 0 || lastIndexOf == str.length() - 1) {
            AppMethodBeat.o(75704);
            return str;
        }
        String str2;
        String[] strArr = new String[]{str.substring(0, lastIndexOf), str.substring(lastIndexOf, str.length())};
        int i = 0;
        do {
            if (i == 0) {
                str2 = str;
            } else {
                str2 = strArr[0] + "(" + i + ")" + strArr[1];
            }
            i++;
        } while (new File(TMAssistantFile.getSavePathRootDir() + File.separator + str2).exists());
        AppMethodBeat.o(75704);
        return str2;
    }

    public static boolean isValidURL(String str) {
        boolean z = false;
        AppMethodBeat.i(75705);
        try {
            URI uri = new URI(correctURL(str));
            z = true;
        } catch (Throwable th) {
            ab.printErrStackTrace(TAG, th, "", new Object[0]);
        }
        AppMethodBeat.o(75705);
        return z;
    }

    public static String generateFileNameFromURL(String str, String str2) {
        AppMethodBeat.i(75706);
        String calcMD5AsString = GlobalUtil.calcMD5AsString(str);
        if (TextUtils.isEmpty(calcMD5AsString)) {
            calcMD5AsString = Integer.toString(Math.abs(str.hashCode()));
        }
        String str3 = "";
        if (!TextUtils.isEmpty(str2)) {
            if (str2.equals("application/vnd.android.package-archive")) {
                str3 = ".apk";
            } else if (str2.equals("application/tm.android.apkdiff")) {
                str3 = ".diff";
            } else if (str2.equals("resource/tm.android.unknown")) {
                str3 = ".other";
            }
        }
        calcMD5AsString = calcMD5AsString + str3;
        AppMethodBeat.o(75706);
        return calcMD5AsString;
    }

    public static synchronized String getNetStatus() {
        String str;
        synchronized (DownloadHelper.class) {
            AppMethodBeat.i(75707);
            Context context = GlobalUtil.getInstance().getContext();
            if (context == null) {
                str = "";
                AppMethodBeat.o(75707);
            } else {
                try {
                    if (context.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") != 0) {
                        str = "";
                        AppMethodBeat.o(75707);
                    } else {
                        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
                        if (activeNetworkInfo == null) {
                            str = "";
                            AppMethodBeat.o(75707);
                        } else if (activeNetworkInfo.getType() == 1) {
                            str = "wifi";
                            AppMethodBeat.o(75707);
                        } else {
                            str = activeNetworkInfo.getExtraInfo();
                            if (str == null) {
                                str = "";
                                AppMethodBeat.o(75707);
                            } else {
                                str = str.toLowerCase();
                                TMLog.v(TAG, "netInfo  =  ".concat(String.valueOf(str)));
                                AppMethodBeat.o(75707);
                            }
                        }
                    }
                } catch (Exception e) {
                    str = "";
                    AppMethodBeat.o(75707);
                }
            }
        }
        return str;
    }

    public static boolean isNetworkConncted() {
        AppMethodBeat.i(75708);
        Context context = GlobalUtil.getInstance().getContext();
        if (context == null) {
            TMLog.w(TAG, "GlobalUtil.getInstance().getContext() == null.");
            AppMethodBeat.o(75708);
            return false;
        }
        boolean isAvailable;
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo != null) {
            isAvailable = activeNetworkInfo.isAvailable();
        } else {
            isAvailable = false;
        }
        AppMethodBeat.o(75708);
        return isAvailable;
    }

    public static boolean isDownloadFileExisted(String str, String str2) {
        boolean z = false;
        AppMethodBeat.i(75709);
        try {
            if (new File(TMAssistantFile.getSaveFilePath(generateFileNameFromURL(str, str2))).exists()) {
                z = true;
            }
        } catch (Exception e) {
            ab.printErrStackTrace(TAG, e, "", new Object[0]);
        } catch (Throwable th) {
            AppMethodBeat.o(75709);
        }
        AppMethodBeat.o(75709);
        return z;
    }

    public static boolean isDownloadFileExisted(String str) {
        boolean z = false;
        AppMethodBeat.i(75710);
        if (str == null) {
            AppMethodBeat.o(75710);
        } else {
            try {
                if (new File(TMAssistantFile.getSaveFilePath(str)).exists()) {
                    z = true;
                }
            } catch (Exception e) {
                ab.printErrStackTrace(TAG, e, "", new Object[0]);
            } catch (Throwable th) {
                AppMethodBeat.o(75710);
            }
            AppMethodBeat.o(75710);
        }
        return z;
    }

    /* JADX WARNING: Missing block: B:3:0x002f, code skipped:
            if (r2 < 0) goto L_0x0031;
     */
    /* JADX WARNING: Missing block: B:14:0x007a, code skipped:
            if (r2 >= 0) goto L_0x007c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean isSpaceEnough(String str, long j) {
        long j2 = 0;
        AppMethodBeat.i(75711);
        long j3 = -1;
        int storePosition = getStorePosition(str);
        if (storePosition == 1) {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            j3 = (((long) statFs.getAvailableBlocks()) - 4) * ((long) statFs.getBlockSize());
        } else {
            if (storePosition == 2) {
                if ("mounted".equals(Environment.getExternalStorageState())) {
                    StatFs statFs2 = new StatFs(new File(Environment.getExternalStorageDirectory().getPath()).getPath());
                    j3 = (((long) statFs2.getAvailableBlocks()) - 4) * ((long) statFs2.getBlockSize());
                }
            }
            j2 = j3;
        }
        j3 = (long) (((float) j) * 1.5f);
        if (j3 > SAVE_LENGTH) {
            if (j2 >= j3) {
                AppMethodBeat.o(75711);
                return true;
            }
            AppMethodBeat.o(75711);
            return false;
        } else if (j2 >= SAVE_LENGTH) {
            AppMethodBeat.o(75711);
            return true;
        } else {
            AppMethodBeat.o(75711);
            return false;
        }
    }

    public static int getStorePosition(String str) {
        AppMethodBeat.i(75712);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(75712);
            return 0;
        } else if (str != null && str.startsWith("/data")) {
            AppMethodBeat.o(75712);
            return 1;
        } else if (TMAssistantFile.isSDCardExistAndCanWrite()) {
            AppMethodBeat.o(75712);
            return 2;
        } else {
            AppMethodBeat.o(75712);
            return 0;
        }
    }
}
