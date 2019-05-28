package com.tencent.rtmp;

import android.content.Context;
import com.tencent.liteav.C25666p;
import com.tencent.liteav.basic.datareport.TXCDRApi;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.log.TXCLog.C8804a;
import com.tencent.liteav.basic.p810c.C37352e;
import com.tencent.liteav.basic.util.C17778b;
import com.tencent.liteav.basic.util.TXCCommonUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
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

    /* renamed from: com.tencent.rtmp.TXLiveBase$a */
    static class C24995a implements C8804a {
        private C24995a() {
        }

        /* synthetic */ C24995a(C444461 c444461) {
            this();
        }

        /* renamed from: a */
        public void mo19901a(int i, String str, String str2) {
            AppMethodBeat.m2504i(65931);
            if (TXLiveBase.listener != null) {
                TXLiveBase.listener.OnLog(i, str, str2);
            }
            AppMethodBeat.m2505o(65931);
        }
    }

    static {
        AppMethodBeat.m2504i(65607);
        AppMethodBeat.m2505o(65607);
    }

    private TXLiveBase() {
    }

    public static TXLiveBase getInstance() {
        return instance;
    }

    public void setLicence(Context context, String str, String str2) {
        AppMethodBeat.m2504i(65595);
        C37352e.m62754a().mo60121a(context, str, str2);
        AppMethodBeat.m2505o(65595);
    }

    public static void setListener(ITXLiveBaseListener iTXLiveBaseListener) {
        AppMethodBeat.m2504i(65596);
        TXCLog.setListener(new C24995a());
        listener = iTXLiveBaseListener;
        AppMethodBeat.m2505o(65596);
    }

    public static void setLogLevel(int i) {
        AppMethodBeat.m2504i(65597);
        TXCLog.setLevel(i);
        AppMethodBeat.m2505o(65597);
    }

    public static void setConsoleEnabled(boolean z) {
        AppMethodBeat.m2504i(65598);
        TXCLog.setConsoleEnabled(z);
        AppMethodBeat.m2505o(65598);
    }

    public static void setAppVersion(String str) {
        AppMethodBeat.m2504i(65599);
        TXCDRApi.txSetAppVersion(str);
        TXCCommonUtil.setAppVersion(str);
        AppMethodBeat.m2505o(65599);
    }

    public static void setLibraryPath(String str) {
        AppMethodBeat.m2504i(65600);
        C17778b.m27750b(str);
        AppMethodBeat.m2505o(65600);
    }

    public static boolean isLibraryPathValid(String str) {
        AppMethodBeat.m2504i(65601);
        String fileMD5 = getFileMD5(str, "libliteavsdk.so");
        String fileMD52 = getFileMD5(str, "libsaturn.so");
        String fileMD53 = getFileMD5(str, "libtxffmpeg.so");
        String fileMD54 = getFileMD5(str, "libtraeimp-rtmp-armeabi.so");
        new StringBuilder("MD5-Check libliteavsdk = ").append(fileMD5).append(" FILE_MD5_LITEAV = ___md5_libliteavsdk_md5_________");
        new StringBuilder("MD5-Check libsaturn = ").append(fileMD52).append(" FILE_MD5_SATURN = ___md5_libsaturn_md5____________");
        new StringBuilder("MD5-Check libtxffmpeg = ").append(fileMD53).append(" FILE_MD5_FFMPEG = ___md5_libtxffmpeg_md5__________");
        new StringBuilder("MD5-Check libtraeimpl = ").append(fileMD54).append(" FILE_MD5_TRAE = ___md5_libtraeimp_md5___________");
        if (fileMD5 == null || !fileMD5.equalsIgnoreCase(FILE_MD5_LITEAV) || fileMD52 == null || !fileMD52.equalsIgnoreCase(FILE_MD5_SATURN) || fileMD53 == null || !fileMD53.equalsIgnoreCase(FILE_MD5_FFMPEG) || fileMD54 == null || !fileMD54.equalsIgnoreCase(FILE_MD5_TRAE)) {
            AppMethodBeat.m2505o(65601);
            return false;
        }
        AppMethodBeat.m2505o(65601);
        return true;
    }

    public static String getSDKVersionStr() {
        AppMethodBeat.m2504i(65602);
        String sDKVersionStr = TXCCommonUtil.getSDKVersionStr();
        AppMethodBeat.m2505o(65602);
        return sDKVersionStr;
    }

    public static void setPituLicencePath(String str) {
        AppMethodBeat.m2504i(65603);
        TXCCommonUtil.setPituLicencePath(str);
        AppMethodBeat.m2505o(65603);
    }

    public static String getPituSDKVersion() {
        AppMethodBeat.m2504i(65604);
        String a = C25666p.m40717a();
        AppMethodBeat.m2505o(65604);
        return a;
    }

    public static void setAppID(String str) {
        AppMethodBeat.m2504i(65605);
        TXCCommonUtil.setAppID(str);
        AppMethodBeat.m2505o(65605);
    }

    private static String getFileMD5(String str, String str2) {
        MessageDigest messageDigest = null;
        AppMethodBeat.m2504i(65606);
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
            AppMethodBeat.m2505o(65606);
            return bigInteger;
        }
        AppMethodBeat.m2505o(65606);
        return null;
    }
}
