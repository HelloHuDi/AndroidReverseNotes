package com.tencent.rtmp;

import android.content.Context;
import com.tencent.liteav.basic.c.e;
import com.tencent.liteav.basic.datareport.TXCDRApi;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.TXCCommonUtil;
import com.tencent.liteav.basic.util.b;
import com.tencent.liteav.p;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class TXLiveBase {
    private static final String FILE_MD5_FFMPEG = "___md5_libtxffmpeg_md5__________";
    private static final String FILE_MD5_LITEAV = "___md5_libliteavsdk_md5_________";
    private static final String FILE_MD5_SATURN = "___md5_libsaturn_md5____________";
    private static final String FILE_MD5_TRAE = "___md5_libtraeimp_md5___________";
    private static final String TAG = "TXLiveBase";
    private static TXLiveBase instance = new TXLiveBase();
    private static ITXLiveBaseListener listener = null;

    static class a implements com.tencent.liteav.basic.log.TXCLog.a {
        private a() {
        }

        /* synthetic */ a(AnonymousClass1 anonymousClass1) {
            this();
        }

        public void a(int i, String str, String str2) {
            AppMethodBeat.i(65931);
            if (TXLiveBase.listener != null) {
                TXLiveBase.listener.OnLog(i, str, str2);
            }
            AppMethodBeat.o(65931);
        }
    }

    static {
        AppMethodBeat.i(65607);
        AppMethodBeat.o(65607);
    }

    private TXLiveBase() {
    }

    public static TXLiveBase getInstance() {
        return instance;
    }

    public void setLicence(Context context, String str, String str2) {
        AppMethodBeat.i(65595);
        e.a().a(context, str, str2);
        AppMethodBeat.o(65595);
    }

    public static void setListener(ITXLiveBaseListener iTXLiveBaseListener) {
        AppMethodBeat.i(65596);
        TXCLog.setListener(new a());
        listener = iTXLiveBaseListener;
        AppMethodBeat.o(65596);
    }

    public static void setLogLevel(int i) {
        AppMethodBeat.i(65597);
        TXCLog.setLevel(i);
        AppMethodBeat.o(65597);
    }

    public static void setConsoleEnabled(boolean z) {
        AppMethodBeat.i(65598);
        TXCLog.setConsoleEnabled(z);
        AppMethodBeat.o(65598);
    }

    public static void setAppVersion(String str) {
        AppMethodBeat.i(65599);
        TXCDRApi.txSetAppVersion(str);
        TXCCommonUtil.setAppVersion(str);
        AppMethodBeat.o(65599);
    }

    public static void setLibraryPath(String str) {
        AppMethodBeat.i(65600);
        b.b(str);
        AppMethodBeat.o(65600);
    }

    public static boolean isLibraryPathValid(String str) {
        AppMethodBeat.i(65601);
        String fileMD5 = getFileMD5(str, "libliteavsdk.so");
        String fileMD52 = getFileMD5(str, "libsaturn.so");
        String fileMD53 = getFileMD5(str, "libtxffmpeg.so");
        String fileMD54 = getFileMD5(str, "libtraeimp-rtmp-armeabi.so");
        new StringBuilder("MD5-Check libliteavsdk = ").append(fileMD5).append(" FILE_MD5_LITEAV = ___md5_libliteavsdk_md5_________");
        new StringBuilder("MD5-Check libsaturn = ").append(fileMD52).append(" FILE_MD5_SATURN = ___md5_libsaturn_md5____________");
        new StringBuilder("MD5-Check libtxffmpeg = ").append(fileMD53).append(" FILE_MD5_FFMPEG = ___md5_libtxffmpeg_md5__________");
        new StringBuilder("MD5-Check libtraeimpl = ").append(fileMD54).append(" FILE_MD5_TRAE = ___md5_libtraeimp_md5___________");
        if (fileMD5 == null || !fileMD5.equalsIgnoreCase(FILE_MD5_LITEAV) || fileMD52 == null || !fileMD52.equalsIgnoreCase(FILE_MD5_SATURN) || fileMD53 == null || !fileMD53.equalsIgnoreCase(FILE_MD5_FFMPEG) || fileMD54 == null || !fileMD54.equalsIgnoreCase(FILE_MD5_TRAE)) {
            AppMethodBeat.o(65601);
            return false;
        }
        AppMethodBeat.o(65601);
        return true;
    }

    public static String getSDKVersionStr() {
        AppMethodBeat.i(65602);
        String sDKVersionStr = TXCCommonUtil.getSDKVersionStr();
        AppMethodBeat.o(65602);
        return sDKVersionStr;
    }

    public static void setPituLicencePath(String str) {
        AppMethodBeat.i(65603);
        TXCCommonUtil.setPituLicencePath(str);
        AppMethodBeat.o(65603);
    }

    public static String getPituSDKVersion() {
        AppMethodBeat.i(65604);
        String a = p.a();
        AppMethodBeat.o(65604);
        return a;
    }

    public static void setAppID(String str) {
        AppMethodBeat.i(65605);
        TXCCommonUtil.setAppID(str);
        AppMethodBeat.o(65605);
    }

    private static String getFileMD5(String str, String str2) {
        MessageDigest messageDigest = null;
        AppMethodBeat.i(65606);
        File file = new File(str, str2);
        if (file.exists() && file.isFile()) {
            byte[] bArr = new byte[WXMediaMessage.DESCRIPTION_LENGTH_LIMIT];
            try {
                messageDigest = MessageDigest.getInstance("MD5");
                FileInputStream fileInputStream = new FileInputStream(file);
                while (true) {
                    int read = fileInputStream.read(bArr, 0, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
                    if (read == -1) {
                        break;
                    }
                    messageDigest.update(bArr, 0, read);
                }
                fileInputStream.close();
            } catch (FileNotFoundException | IOException | NoSuchAlgorithmException e) {
            }
            String bigInteger = new BigInteger(1, messageDigest.digest()).toString(16);
            AppMethodBeat.o(65606);
            return bigInteger;
        }
        AppMethodBeat.o(65606);
        return null;
    }
}
