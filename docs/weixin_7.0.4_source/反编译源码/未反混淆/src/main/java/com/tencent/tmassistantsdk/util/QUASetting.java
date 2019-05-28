package com.tencent.tmassistantsdk.util;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.IOUtils;

public class QUASetting {
    protected static final String APP_VERSION = "100";
    protected static final String BUILD_NO = "100";
    public static final int ROOT_STATUS_UNKNOWN = 0;
    protected static final String UN_DEFINED = "NA";
    protected static String mChannelId = UN_DEFINED;
    protected Context mContext = null;

    public QUASetting(Context context) {
        this.mContext = context;
    }

    public String buildQUA() {
        AppMethodBeat.i(76274);
        QUABuilder qUABuilder = new QUABuilder();
        qUABuilder.mBuildNo = getBuildNo();
        qUABuilder.mChannel = "";
        qUABuilder.mChannelId = mChannelId;
        qUABuilder.mAdrRelease = getAndroidVersion();
        qUABuilder.mDeviceHeight = getDeviceHeight();
        qUABuilder.mDeviceWidth = getDeviceWidth();
        qUABuilder.mRootStatus = getRootStatus();
        qUABuilder.mUA = getUA();
        qUABuilder.mVersionName = "100";
        String str = qUABuilder.get();
        AppMethodBeat.o(76274);
        return str;
    }

    private int getDeviceWidth() {
        AppMethodBeat.i(76275);
        int i = this.mContext.getResources().getDisplayMetrics().widthPixels;
        AppMethodBeat.o(76275);
        return i;
    }

    private int getDeviceHeight() {
        AppMethodBeat.i(76276);
        int i = this.mContext.getResources().getDisplayMetrics().heightPixels;
        AppMethodBeat.o(76276);
        return i;
    }

    public static String getBuildNo() {
        AppMethodBeat.i(76277);
        String str;
        if ("100".contains("BuildNo")) {
            str = "0000";
            AppMethodBeat.o(76277);
            return str;
        }
        str = "100";
        AppMethodBeat.o(76277);
        return str;
    }

    private int getRootStatus() {
        return 0;
    }

    private String getUA() {
        AppMethodBeat.i(76278);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(filter(Build.BRAND));
        stringBuffer.append("_");
        stringBuffer.append(filter(Build.MODEL));
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(76278);
        return stringBuffer2;
    }

    private String getAndroidVersion() {
        AppMethodBeat.i(76279);
        StringBuffer stringBuffer = new StringBuffer();
        String str = VERSION.RELEASE;
        if (TextUtils.isEmpty(str)) {
            stringBuffer.append(UN_DEFINED);
        } else {
            stringBuffer.append(str);
        }
        stringBuffer.append("_");
        stringBuffer.append(VERSION.SDK_INT);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(76279);
        return stringBuffer2;
    }

    private StringBuffer filter(String str) {
        AppMethodBeat.i(76280);
        StringBuffer stringBuffer = new StringBuffer();
        if (TextUtils.isEmpty(str)) {
            stringBuffer.append(UN_DEFINED);
            AppMethodBeat.o(76280);
            return stringBuffer;
        }
        char[] toCharArray = str.toCharArray();
        int i = 0;
        while (i < toCharArray.length) {
            if (!(toCharArray[i] <= ' ' || toCharArray[i] == IOUtils.DIR_SEPARATOR_UNIX || toCharArray[i] == '_' || toCharArray[i] == '&' || toCharArray[i] == '|' || toCharArray[i] == '-')) {
                stringBuffer.append(toCharArray[i]);
            }
            i++;
        }
        AppMethodBeat.o(76280);
        return stringBuffer;
    }
}
