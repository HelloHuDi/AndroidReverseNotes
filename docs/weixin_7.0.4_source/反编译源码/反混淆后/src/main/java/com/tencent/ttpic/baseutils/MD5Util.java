package com.tencent.ttpic.baseutils;

import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Util {
    private static final String[] strDigits = new String[]{AppEventsConstants.EVENT_PARAM_VALUE_NO, "1", "2", TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL, "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};

    private static String byteToArrayString(byte b) {
        int b2;
        AppMethodBeat.m2504i(49787);
        if (b2 < (byte) 0) {
            b2 = b2 + 256;
        }
        String str = strDigits[b2 / 16] + strDigits[b2 % 16];
        AppMethodBeat.m2505o(49787);
        return str;
    }

    private static String byteToNum(byte b) {
        int b2;
        AppMethodBeat.m2504i(49788);
        if (b2 < (byte) 0) {
            b2 = b2 + 256;
        }
        String valueOf = String.valueOf(b2);
        AppMethodBeat.m2505o(49788);
        return valueOf;
    }

    private static String byteToString(byte[] bArr) {
        AppMethodBeat.m2504i(49789);
        StringBuffer stringBuffer = new StringBuffer();
        for (byte byteToArrayString : bArr) {
            stringBuffer.append(byteToArrayString(byteToArrayString));
        }
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.m2505o(49789);
        return stringBuffer2;
    }

    public static String GetMD5Code(String str) {
        String str2;
        Throwable e;
        AppMethodBeat.m2504i(49790);
        try {
            str2 = new String(str);
            try {
                str2 = byteToString(MessageDigest.getInstance("MD5").digest(str.getBytes()));
            } catch (NoSuchAlgorithmException e2) {
                e = e2;
            }
        } catch (NoSuchAlgorithmException e3) {
            e = e3;
            str2 = null;
            LogUtils.m50206e(e);
            AppMethodBeat.m2505o(49790);
            return str2;
        }
        AppMethodBeat.m2505o(49790);
        return str2;
    }
}
