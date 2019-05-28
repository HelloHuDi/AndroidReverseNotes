package com.tencent.recovery.wx.service;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.mm.hardcoder.i;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.recovery.log.RecoveryLog;
import com.tencent.recovery.model.RecoveryHandleItem;
import com.tencent.recovery.report.RecoveryReporter;
import com.tencent.recovery.service.RecoveryUploadService;
import com.tencent.recovery.util.Util;
import com.tencent.recovery.wx.util.EncryptUtil;
import com.tencent.recovery.wx.util.PByteArray;
import com.tencent.recovery.wx.util.WXUtil;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import com.tencent.tmassistantsdk.openSDK.OpenSDKTool4Assistant;
import com.tencent.ttpic.baseutils.IOUtils;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class WXRecoveryUploadService extends RecoveryUploadService {
    private static final String TAG = "Recovery.WXRecoveryUploadService";
    private static final String UNIT_REPORT_TAG = "RecoveryHandle";

    public boolean tryToUploadData() {
        Intent intent = new Intent();
        intent.setPackage(getPackageName());
        intent.setAction("com.tecent.mm.intent.action.RECOVERY_STATUS_UPLOAD");
        sendBroadcast(intent);
        List a = RecoveryReporter.a((Context) this, "HandleStatus", RecoveryHandleItem.class);
        boolean uploadData = uploadData(a);
        if (a.size() == 0 || uploadData) {
            RecoveryReporter.bX(this, "HandleStatus");
        }
        return uploadData;
    }

    /* Access modifiers changed, original: protected */
    public boolean uploadData(List<RecoveryHandleItem> list) {
        int iB = Util.iB(this);
        JSONArray jSONArray = new JSONArray();
        String str = BuildConfig.CLIENT_VERSION;
        for (RecoveryHandleItem recoveryHandleItem : list) {
            try {
                String str2;
                jSONArray.put(new JSONObject().put("tag", UNIT_REPORT_TAG).put("info", recoveryHandleItem.key).put(OpenSDKTool4Assistant.EXTRA_UIN, recoveryHandleItem.eCq).put("deviceUUID", iB).put("time", Util.nz(recoveryHandleItem.timestamp)).put("cver", recoveryHandleItem.clientVersion).put("processName", recoveryHandleItem.processName).put("phoneStatus", recoveryHandleItem.Arn));
                if (compareVersion(recoveryHandleItem.clientVersion, str) > 0) {
                    str2 = recoveryHandleItem.clientVersion;
                } else {
                    str2 = str;
                }
                str = str2;
            } catch (Exception e) {
            }
        }
        RecoveryLog.i(TAG, "upload result %b %d", Boolean.valueOf(pushData(jSONArray, str)), Integer.valueOf(list.size()));
        return pushData(jSONArray, str);
    }

    private boolean pushData(JSONArray jSONArray, String str) {
        try {
            String iH = WXUtil.iH(this);
            String str2 = "android-" + VERSION.SDK_INT;
            byte[] bytes = new JSONObject().put("head", new JSONObject().put("protocol_ver", 1).put("phone", Build.MANUFACTURER + "-" + Build.MODEL).put("os_ver", str2).put("report_time", System.currentTimeMillis())).put("items", jSONArray).toString().getBytes();
            String toLowerCase = EncryptUtil.x(String.format("weixin#$()%d%d", new Object[]{Integer.decode(str), Integer.valueOf(bytes.length)}).getBytes()).toLowerCase();
            bytes = EncryptUtil.compress(bytes);
            PByteArray pByteArray = new PByteArray();
            EncryptUtil.a(pByteArray, bytes, toLowerCase.getBytes());
            StringBuilder append = new StringBuilder(256).append("http://support.weixin.qq.com/cgi-bin/mmsupport-bin/stackreport?version=").append(str).append("&devicetype=").append(str2).append("&filelength=").append(r5).append("&sum=").append(toLowerCase).append("&reporttype=1&NewReportType=110");
            if (!(iH == null || iH.length() == 0)) {
                append.append("&username=").append(iH);
            }
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(append.toString()).openConnection();
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setReadTimeout(i.sHCENCODEVIDEOTIMEOUT);
            httpURLConnection.setConnectTimeout(Downloads.MIN_WAIT_FOR_NETWORK);
            httpURLConnection.setRequestProperty("content-type", "binary/octet-stream");
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);
            httpURLConnection.connect();
            OutputStream outputStream = httpURLConnection.getOutputStream();
            outputStream.write(pByteArray.value);
            outputStream.flush();
            outputStream.close();
            if (httpURLConnection.getResponseCode() != 200) {
                String convertStreamToString = convertStreamToString(httpURLConnection.getErrorStream());
                str2 = convertStreamToString(httpURLConnection.getInputStream());
                RecoveryLog.i(TAG, "POST returned: %d %s %s %s", Integer.valueOf(httpURLConnection.getResponseCode()), str, convertStreamToString, str2);
                return false;
            }
            RecoveryLog.i(TAG, "POST returned success %s", str);
            return true;
        } catch (Exception e) {
            RecoveryLog.printErrStackTrace(TAG, e, "pushData", new Object[0]);
            return false;
        }
    }

    public static String convertStreamToString(InputStream inputStream) {
        if (inputStream == null) {
            return "";
        }
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder stringBuilder = new StringBuilder();
        while (true) {
            try {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    stringBuilder.append(readLine + IOUtils.LINE_SEPARATOR_UNIX);
                } else {
                    try {
                        break;
                    } catch (IOException e) {
                        RecoveryLog.printErrStackTrace(TAG, e, "", new Object[0]);
                    }
                }
            } catch (IOException e2) {
                RecoveryLog.printErrStackTrace(TAG, e2, "", new Object[0]);
                try {
                    inputStream.close();
                } catch (IOException e22) {
                    RecoveryLog.printErrStackTrace(TAG, e22, "", new Object[0]);
                }
            } catch (Throwable th) {
                try {
                    inputStream.close();
                } catch (IOException e3) {
                    RecoveryLog.printErrStackTrace(TAG, e3, "", new Object[0]);
                }
                throw th;
            }
        }
        inputStream.close();
        return stringBuilder.toString();
    }

    private static int compareVersion(String str, String str2) {
        try {
            int intValue = Integer.decode(str).intValue();
            int intValue2 = Integer.decode(str2).intValue();
            if (intValue > intValue2) {
                return 1;
            }
            if (intValue2 > intValue) {
                return -1;
            }
            return 0;
        } catch (Exception e) {
            return 0;
        }
    }
}
