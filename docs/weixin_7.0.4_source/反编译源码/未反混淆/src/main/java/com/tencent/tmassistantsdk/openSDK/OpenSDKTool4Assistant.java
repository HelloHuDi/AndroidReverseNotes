package com.tencent.tmassistantsdk.openSDK;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import com.tencent.tmassistantsdk.util.Base64;
import java.util.Map;
import java.util.Map.Entry;

public class OpenSDKTool4Assistant {
    public static final int ACTION_TYPE_APP_DETAIL = 2;
    public static final int ACTION_TYPE_AUTHORIZED = 3;
    public static final int ACTION_TYPE_DOWNLOAD_TASKLIST = 1;
    public static final int ACTION_TYPE_RELATE = 4;
    public static final int ACTION_TYPE_WEBVIEW = 5;
    public static final int BATCH_REQUEST_TYPE_GET_STATE = 3;
    public static final int BATCH_REQUEST_TYPE_PAUSE_ALL = 6;
    public static final int BATCH_REQUEST_TYPE_PAUSE_SPECIFIED_APPS = 8;
    public static final int BATCH_REQUEST_TYPE_RESUME_ALL = 5;
    public static final int BATCH_REQUEST_TYPE_RESUME_SPECIFIED_APPS = 7;
    public static final int BATCH_REQUEST_TYPE_SHOW_ALL = 2;
    public static final int BATCH_REQUEST_TYPE_START_ALL = 1;
    public static final int BATCH_REQUEST_TYPE_START_SPECIFIED_APPS = 4;
    protected static final String CRYPT_KEY = "ji*9^&43U0X-~./(";
    public static final String DOWNLOADSTATECHANGED_RECEIVERPERMISSION = "com.tencent.qqdownloader.stateChangedReceiverPermission";
    public static final String EXTRA_ERROR_CODE = "errorCode";
    public static final String EXTRA_ERROR_MSG = "errorMsg";
    public static final String EXTRA_HOST_PAGECKAGENAME = "hostPackageName";
    public static final String EXTRA_HOST_VERSION = "hostVersion";
    public static final String EXTRA_SNGAPPID = "sngAppId";
    public static final String EXTRA_STATE = "state";
    public static final String EXTRA_TASK_APKID = "taskApkId";
    public static final String EXTRA_TASK_APPID = "taskAppId";
    public static final String EXTRA_TASK_ID = "taskId";
    public static final String EXTRA_TASK_PACKAGENAME = "taskPackageName";
    public static final String EXTRA_TASK_VERSION = "taskVersion";
    public static final String EXTRA_UIN = "uin";
    public static final String EXTRA_UINTYPE = "uinType";
    public static final String EXTRA_VIA = "via";
    public static final String OPENSDK_ACTION_NAME = "com.tencent.assistantOpenSDK.downloadStateChange.action";
    public static final String STATE_CHANGED_PARAM = "stateChangedParam";

    public static void sendDownloadStateChanged(Context context, Map<String, String> map) {
        AppMethodBeat.i(75847);
        Intent intent = new Intent(OPENSDK_ACTION_NAME);
        for (Entry entry : map.entrySet()) {
            intent.putExtra((String) entry.getKey(), (String) entry.getValue());
        }
        context.sendBroadcast(intent);
        AppMethodBeat.o(75847);
    }

    public static String encryptUri(String str) {
        AppMethodBeat.i(75848);
        String encodeToString = Base64.encodeToString(ProtocolPackage.encrypt(str.getBytes(), CRYPT_KEY.getBytes()), 0);
        AppMethodBeat.o(75848);
        return encodeToString;
    }

    public static String decryptUri(String str) {
        AppMethodBeat.i(75849);
        String str2 = new String(ProtocolPackage.decrypt(Base64.decode(str, 0), CRYPT_KEY.getBytes()));
        AppMethodBeat.o(75849);
        return str2;
    }
}
