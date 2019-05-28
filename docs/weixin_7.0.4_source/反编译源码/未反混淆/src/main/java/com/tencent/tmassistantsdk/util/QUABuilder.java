package com.tencent.tmassistantsdk.util;

import android.text.TextUtils;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class QUABuilder {
    public String mAdrRelease;
    public String mBuildNo;
    public String mChannel;
    public String mChannelId;
    public int mDeviceHeight;
    public int mDeviceWidth;
    public int mRootStatus;
    public String mUA;
    public String mVersionName;

    public final String get() {
        AppMethodBeat.i(76272);
        String appSpec = getAppSpec();
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("TMASDK_");
        stringBuffer.append(this.mVersionName);
        if (!TextUtils.isEmpty(this.mChannel)) {
            stringBuffer.append("_");
            stringBuffer.append(this.mChannel);
        }
        stringBuffer.append("/");
        stringBuffer.append(appSpec);
        stringBuffer.append("&NA/");
        stringBuffer.append(appSpec);
        stringBuffer.append("&");
        stringBuffer.append(this.mAdrRelease);
        stringBuffer.append("_");
        stringBuffer.append(this.mRootStatus);
        stringBuffer.append("&");
        stringBuffer.append(this.mDeviceWidth / 16);
        stringBuffer.append("_");
        stringBuffer.append(this.mDeviceHeight / 16);
        stringBuffer.append("_");
        stringBuffer.append("14&");
        stringBuffer.append(this.mUA);
        stringBuffer.append("&");
        stringBuffer.append(this.mChannelId);
        stringBuffer.append("&");
        stringBuffer.append("NA");
        stringBuffer.append("&");
        stringBuffer.append("V3");
        appSpec = stringBuffer.toString();
        AppMethodBeat.o(76272);
        return appSpec;
    }

    private String getAppSpec() {
        AppMethodBeat.i(76273);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(AppEventsConstants.EVENT_PARAM_VALUE_NO);
        stringBuffer.append(this.mVersionName.subSequence(0, 1));
        stringBuffer.append(this.mBuildNo);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(76273);
        return stringBuffer2;
    }
}
