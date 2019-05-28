package com.tencent.recovery.wx.service;

import android.content.Context;
import android.os.PowerManager;
import com.tencent.mm.hardcoder.i;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.recovery.log.RecoveryLog;
import com.tencent.recovery.model.RecoveryData;
import com.tencent.recovery.model.RecoveryHandleItem;
import com.tencent.recovery.model.RecoveryHandleResult;
import com.tencent.recovery.service.RecoveryHandleService;
import com.tencent.recovery.util.Util;
import com.tencent.recovery.wx.RecoveryTinkerManager;
import com.tencent.recovery.wx.util.EncryptUtil;
import com.tencent.recovery.wx.util.FileUtil;
import com.tencent.recovery.wx.util.NetUtil;
import com.tencent.recovery.wx.util.WXUtil;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.URL;
import java.util.ArrayList;
import org.json.JSONObject;

public class WXRecoveryHandleService extends RecoveryHandleService {
    private PowerManager tXN;

    public void onCreate() {
        super.onCreate();
        RecoveryLog.i("Recovery.WXRecoveryHandleService", "onCreate", new Object[0]);
        this.tXN = (PowerManager) getSystemService("power");
    }

    public void onDestroy() {
        RecoveryLog.i("Recovery.WXRecoveryHandleService", "onDestroy", new Object[0]);
        super.onDestroy();
    }

    public final void a(RecoveryData recoveryData, ArrayList<RecoveryHandleItem> arrayList, boolean z) {
        arrayList.add(a(recoveryData, String.format("%s[%b]", new Object[]{"KeyTotalCount", Boolean.valueOf(z)})));
        arrayList.add(a(recoveryData, String.format("%s[%b]", new Object[]{"KeyAlreadyRunning", Boolean.valueOf(z)})));
    }

    /* JADX WARNING: Removed duplicated region for block: B:47:0x0132  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00d1  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0112 A:{SYNTHETIC, Splitter:B:37:0x0112} */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00d1  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0132  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x011d A:{SYNTHETIC, Splitter:B:43:0x011d} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final RecoveryHandleResult a(Context context, RecoveryData recoveryData, ArrayList<RecoveryHandleItem> arrayList, boolean z) {
        Throwable th;
        FileOutputStream fileOutputStream;
        RecoveryHandleResult recoveryHandleResult = new RecoveryHandleResult();
        arrayList.add(a(recoveryData, String.format("%s[%b]", new Object[]{"KeyTotalCount", Boolean.valueOf(z)})));
        RecoveryHandleItem a = a(recoveryData, "");
        if (NetUtil.isConnected(this)) {
            RecoveryLog.i("Recovery.WXRecoveryHandleService", "recoveryConfigUrl %s", recoveryData.Arl);
            String a2 = a(r0, a);
            if (a2 != null) {
                JSONObject jSONObject;
                RecoveryLog.i("Recovery.WXRecoveryHandleService", "recoveryConfigStr is %s", a2);
                try {
                    jSONObject = new JSONObject(a2);
                } catch (Exception e) {
                    jSONObject = null;
                }
                if (jSONObject != null) {
                    int optInt = jSONObject.optInt("abTestBaseNumber", -1);
                    int optInt2 = jSONObject.optInt("abTestReminder", -1);
                    String optString = jSONObject.optString("patchPackageUrl", "");
                    String optString2 = jSONObject.optString("patchPackageMd5", "");
                    if ((Util.iB(this) % optInt == optInt2 ? 1 : 0) != 0) {
                        RecoveryLog.i("Recovery.WXRecoveryHandleService", "patchPackageUrl=%s", optString);
                        byte[] a3 = a(optString, optString2, a);
                        if (a3 != null) {
                            String str = context.getCacheDir() + "/recovery.patch";
                            File file = new File(str);
                            if (file.exists()) {
                                file.delete();
                            }
                            FileOutputStream fileOutputStream2;
                            try {
                                fileOutputStream2 = new FileOutputStream(file);
                                try {
                                    fileOutputStream2.write(a3);
                                    try {
                                        fileOutputStream2.close();
                                    } catch (IOException e2) {
                                    }
                                } catch (Exception e3) {
                                    if (fileOutputStream2 != null) {
                                        try {
                                            fileOutputStream2.close();
                                        } catch (IOException e4) {
                                        }
                                    }
                                    if (file.exists()) {
                                    }
                                    arrayList.add(a);
                                    return recoveryHandleResult;
                                } catch (Throwable th2) {
                                    th = th2;
                                    fileOutputStream = fileOutputStream2;
                                    if (fileOutputStream != null) {
                                        try {
                                            fileOutputStream.close();
                                        } catch (IOException e5) {
                                        }
                                    }
                                    throw th;
                                }
                            } catch (Exception e6) {
                                fileOutputStream2 = null;
                                if (fileOutputStream2 != null) {
                                }
                                if (file.exists()) {
                                }
                                arrayList.add(a);
                                return recoveryHandleResult;
                            } catch (Throwable th3) {
                                th = th3;
                                fileOutputStream = null;
                                if (fileOutputStream != null) {
                                }
                                throw th;
                            }
                            if (file.exists()) {
                                int bY = RecoveryTinkerManager.bY(context, str);
                                if (bY != 0) {
                                    a.key = "KeyPatchStartFailCount[" + bY + "]";
                                    RecoveryLog.i("Recovery.WXRecoveryHandleService", "patch fail tinkerPatchCode=%d", Integer.valueOf(bY));
                                } else {
                                    a.key = "KeyPatchStartSuccessCount";
                                    RecoveryLog.i("Recovery.WXRecoveryHandleService", "start patch file", new Object[0]);
                                }
                                recoveryHandleResult.csN = true;
                            } else {
                                a.key = "KeyCheckPatchMd5FailCount";
                                RecoveryLog.i("Recovery.WXRecoveryHandleService", "patch file save fail", new Object[0]);
                            }
                        } else {
                            RecoveryLog.i("Recovery.WXRecoveryHandleService", "get patch data fail", new Object[0]);
                        }
                    } else {
                        RecoveryLog.i("Recovery.WXRecoveryHandleService", "no need recovery", new Object[0]);
                        a.key = "KeyPatchNoNeedCount";
                    }
                } else {
                    RecoveryLog.i("Recovery.WXRecoveryHandleService", "parse config fail", new Object[0]);
                    a.key = "KeyConfigParseFailCount";
                }
            } else {
                RecoveryLog.i("Recovery.WXRecoveryHandleService", "recoveryConfigStr is null", new Object[0]);
                if (Util.isNullOrNil(a.key)) {
                    a.key = "RecoveryConfigStrIsNull";
                }
            }
        } else {
            RecoveryLog.i("Recovery.WXRecoveryHandleService", "no network", new Object[0]);
            if (!z) {
                recoveryHandleResult.retry = true;
            }
            a.key = String.format("%s[%b]", new Object[]{"KeyNoNetWork", Boolean.valueOf(z)});
        }
        arrayList.add(a);
        return recoveryHandleResult;
    }

    private RecoveryHandleItem a(RecoveryData recoveryData, String str) {
        RecoveryHandleItem recoveryHandleItem = new RecoveryHandleItem();
        recoveryHandleItem.eCq = recoveryData.eCq;
        recoveryHandleItem.clientVersion = recoveryData.clientVersion;
        recoveryHandleItem.timestamp = System.currentTimeMillis();
        recoveryHandleItem.key = str;
        recoveryHandleItem.processName = recoveryData.processName;
        recoveryHandleItem.Arn = iE(this);
        return recoveryHandleItem;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0028 A:{SYNTHETIC, Splitter:B:10:0x0028} */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x0112 A:{SYNTHETIC, Splitter:B:68:0x0112} */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x0117  */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0028 A:{SYNTHETIC, Splitter:B:10:0x0028} */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x0112 A:{SYNTHETIC, Splitter:B:68:0x0112} */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x0117  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0070 A:{SYNTHETIC, Splitter:B:26:0x0070} */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x0112 A:{SYNTHETIC, Splitter:B:68:0x0112} */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x0117  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x010d A:{Splitter:B:46:0x00ba, ExcHandler: all (r1_2 'th' java.lang.Throwable)} */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:46:0x00ba, B:50:0x00c7] */
    /* JADX WARNING: Missing block: B:52:0x00cd, code skipped:
            r2 = e;
     */
    /* JADX WARNING: Missing block: B:53:0x00ce, code skipped:
            r4 = r0;
     */
    /* JADX WARNING: Missing block: B:65:0x010d, code skipped:
            r1 = move-exception;
     */
    /* JADX WARNING: Missing block: B:66:0x010e, code skipped:
            r2 = r1;
            r4 = r0;
     */
    /* JADX WARNING: Missing block: B:69:?, code skipped:
            r3.close();
     */
    /* JADX WARNING: Missing block: B:71:0x0117, code skipped:
            r4.disconnect();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static String a(String str, RecoveryHandleItem recoveryHandleItem) {
        byte[] q;
        Throwable th;
        InputStream inputStream;
        HttpURLConnection httpURLConnection;
        if (str.startsWith("file://")) {
            InputStream fileInputStream;
            try {
                fileInputStream = new FileInputStream(new File(str.replace("file://", "")));
                try {
                    q = FileUtil.q(fileInputStream);
                    try {
                        fileInputStream.close();
                    } catch (IOException e) {
                    }
                } catch (Exception e2) {
                } catch (Throwable th2) {
                    th = th2;
                    inputStream = fileInputStream;
                    if (inputStream != null) {
                    }
                    throw th;
                }
            } catch (Exception e3) {
                fileInputStream = null;
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                        q = null;
                    } catch (IOException e4) {
                        q = null;
                    }
                } else {
                    q = null;
                }
                if (q != null) {
                }
                return null;
            } catch (Throwable th3) {
                th = th3;
                inputStream = null;
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e5) {
                    }
                }
                throw th;
            }
        }
        try {
            HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL(WXUtil.atN(str)).openConnection();
            try {
                httpURLConnection2.setRequestMethod("GET");
                httpURLConnection2.setConnectTimeout(Downloads.MIN_WAIT_FOR_NETWORK);
                httpURLConnection2.setReadTimeout(i.sHCENCODEVIDEOTIMEOUT);
                httpURLConnection2.connect();
                int responseCode = httpURLConnection2.getResponseCode();
                if (responseCode != 200) {
                    recoveryHandleItem.key = WXUtil.QZ(responseCode);
                    inputStream = null;
                    q = null;
                } else {
                    inputStream = httpURLConnection2.getInputStream();
                    if (inputStream == null) {
                        try {
                            recoveryHandleItem.key = "KeyConfigHttpInputStreamIsNull";
                            q = null;
                        } catch (Exception e6) {
                            th = e6;
                            httpURLConnection = httpURLConnection2;
                            q = null;
                        } catch (Throwable th4) {
                        }
                    } else {
                        q = q(inputStream);
                        if (q == null) {
                            recoveryHandleItem.key = "KeyConfigHttpInputStreamReadDataIsNull";
                        } else if (q.length == 0) {
                            recoveryHandleItem.key = "KeyConfigHttpInputStreamReadDataLengthZero";
                        }
                    }
                }
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e7) {
                    }
                }
                if (httpURLConnection2 != null) {
                    httpURLConnection2.disconnect();
                }
            } catch (Exception e8) {
                th = e8;
                inputStream = null;
                httpURLConnection = httpURLConnection2;
                q = null;
            } catch (Throwable th5) {
                th = th5;
                inputStream = null;
                httpURLConnection = httpURLConnection2;
                if (inputStream != null) {
                }
                if (httpURLConnection != null) {
                }
                throw th;
            }
        } catch (Exception th32) {
            th = th32;
            inputStream = null;
            httpURLConnection = null;
            q = null;
            try {
                RecoveryLog.printErrStackTrace("Recovery.WXRecoveryHandleService", th, "getConfigData", new Object[0]);
                recoveryHandleItem.key = "Config HttpInputStream Exception: [" + th.getMessage() + "]";
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e9) {
                    }
                }
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                if (q != null) {
                }
                return null;
            } catch (Throwable th322) {
                th = th322;
                if (inputStream != null) {
                }
                if (httpURLConnection != null) {
                }
                throw th;
            }
        } catch (Throwable th3222) {
            th = th3222;
            inputStream = null;
            httpURLConnection = null;
            if (inputStream != null) {
            }
            if (httpURLConnection != null) {
            }
            throw th;
        }
        if (q != null) {
            try {
                RecoveryLog.i("Recovery.WXRecoveryHandleService", "config data md5=%s", EncryptUtil.x(q));
                byte[] g = EncryptUtil.g(q, "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQC0oMW80k4h7zmBbHGhzQzs5Jv1uy5j0JVUG//dWHeu0q6PF/xCU97h/e6h2Q9SXLu0M4TTd89QMXbab9MMUXrxqIqVjzm92A4WyNbAElAwhE9AGO16ryYn+tNzDfmwyjVz6dwLzZbNjjH7akYZRopJYqo17kKn+xrnqM+GRKMOJQIDAQAB");
                if (g == null) {
                    recoveryHandleItem.key = "KeyConfigDecryptFail[" + r0 + "]";
                    return null;
                }
                RecoveryLog.i("Recovery.WXRecoveryHandleService", "config data decrypt md5=%s", EncryptUtil.x(g));
                return new String(g);
            } catch (Exception e10) {
                RecoveryLog.printErrStackTrace("Recovery.WXRecoveryHandleService", e10, "getConfigData", new Object[0]);
                recoveryHandleItem.key = "Config Decrypt Exception: [" + e10.getMessage() + "]";
            }
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:61:0x00d9 A:{SYNTHETIC, Splitter:B:61:0x00d9} */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x00de  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x00d9 A:{SYNTHETIC, Splitter:B:61:0x00d9} */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x00de  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x00d9 A:{SYNTHETIC, Splitter:B:61:0x00d9} */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x00de  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0035 A:{SYNTHETIC, Splitter:B:19:0x0035} */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00d4 A:{Splitter:B:39:0x007f, ExcHandler: all (r1_9 'th' java.lang.Throwable)} */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:39:0x007f, B:43:0x008c] */
    /* JADX WARNING: Missing block: B:45:0x0092, code skipped:
            r1 = move-exception;
     */
    /* JADX WARNING: Missing block: B:46:0x0093, code skipped:
            r3 = r1;
            r5 = r0;
     */
    /* JADX WARNING: Missing block: B:58:0x00d4, code skipped:
            r1 = move-exception;
     */
    /* JADX WARNING: Missing block: B:59:0x00d5, code skipped:
            r2 = r1;
            r5 = r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static byte[] a(String str, String str2, RecoveryHandleItem recoveryHandleItem) {
        InputStream inputStream;
        Throwable th;
        Throwable e;
        HttpURLConnection httpURLConnection;
        Throwable th2;
        InputStream inputStream2 = null;
        if (str.startsWith("file://")) {
            try {
                InputStream fileInputStream = new FileInputStream(new File(str.replace("file://", "")));
                try {
                    byte[] q = q(fileInputStream);
                    try {
                        fileInputStream.close();
                        return q;
                    } catch (IOException e2) {
                        return q;
                    }
                } catch (Exception e3) {
                    inputStream = fileInputStream;
                } catch (Throwable th3) {
                    th = th3;
                    inputStream2 = fileInputStream;
                    if (inputStream2 != null) {
                    }
                    throw th;
                }
            } catch (Exception e4) {
                inputStream = null;
                if (inputStream == null) {
                    return null;
                }
                try {
                    inputStream.close();
                    return null;
                } catch (IOException e5) {
                    return null;
                }
            } catch (Throwable th4) {
                th = th4;
                if (inputStream2 != null) {
                    try {
                        inputStream2.close();
                    } catch (IOException e6) {
                    }
                }
                throw th;
            }
        }
        byte[] bArr;
        InputStream inputStream3;
        try {
            HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL(WXUtil.atN(str)).openConnection();
            try {
                httpURLConnection2.setRequestMethod("GET");
                httpURLConnection2.setConnectTimeout(Downloads.MIN_WAIT_FOR_NETWORK);
                httpURLConnection2.setReadTimeout(i.sHCENCODEVIDEOTIMEOUT);
                httpURLConnection2.connect();
                int responseCode = httpURLConnection2.getResponseCode();
                if (responseCode != 200) {
                    recoveryHandleItem.key = WXUtil.Ra(responseCode);
                    inputStream3 = null;
                    bArr = null;
                } else {
                    inputStream3 = httpURLConnection2.getInputStream();
                    if (inputStream3 == null) {
                        try {
                            recoveryHandleItem.key = "KeyPatchHttpInputStreamIsNull";
                            bArr = null;
                        } catch (Exception e7) {
                            e = e7;
                            httpURLConnection = httpURLConnection2;
                            bArr = null;
                        } catch (Throwable th5) {
                        }
                    } else {
                        bArr = FileUtil.q(inputStream3);
                        if (bArr == null) {
                            recoveryHandleItem.key = "KeyPatchHttpInputStreamReadDataIsNull";
                        } else if (bArr.length == 0) {
                            recoveryHandleItem.key = "KeyPatchHttpInputStreamReadDataLengthZero";
                        } else if (!EncryptUtil.x(bArr).equals(str2)) {
                            recoveryHandleItem.key = "KeyPatchCheckMd5Fail";
                            bArr = null;
                        }
                    }
                }
                if (inputStream3 != null) {
                    try {
                        inputStream3.close();
                    } catch (IOException e8) {
                    }
                }
                if (httpURLConnection2 != null) {
                    httpURLConnection2.disconnect();
                    return bArr;
                }
            } catch (Exception e9) {
                e = e9;
                inputStream3 = null;
                httpURLConnection = httpURLConnection2;
                bArr = null;
            } catch (Throwable th6) {
                th2 = th6;
                inputStream3 = null;
                httpURLConnection = httpURLConnection2;
                if (inputStream3 != null) {
                }
                if (httpURLConnection != null) {
                }
                throw th2;
            }
        } catch (Exception th7) {
            e = th7;
            inputStream3 = null;
            httpURLConnection = null;
            bArr = null;
            try {
                RecoveryLog.printErrStackTrace("Recovery.WXRecoveryHandleService", e, "getPatchDataFromHttp", new Object[0]);
                recoveryHandleItem.key = "Patch HttpInputStream Exception: [" + e.getMessage() + "]";
                if (inputStream3 != null) {
                    try {
                        inputStream3.close();
                    } catch (IOException e10) {
                    }
                }
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                    return bArr;
                }
                return bArr;
            } catch (Throwable th72) {
                th2 = th72;
                if (inputStream3 != null) {
                    try {
                        inputStream3.close();
                    } catch (IOException e11) {
                    }
                }
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                throw th2;
            }
        } catch (Throwable th722) {
            th2 = th722;
            inputStream3 = null;
            httpURLConnection = null;
            if (inputStream3 != null) {
            }
            if (httpURLConnection != null) {
            }
            throw th2;
        }
        return bArr;
    }

    private static byte[] q(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[WXMediaMessage.DESCRIPTION_LENGTH_LIMIT];
        while (true) {
            int read = inputStream.read(bArr, 0, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
            if (read <= 0) {
                return byteArrayOutputStream.toByteArray();
            }
            byteArrayOutputStream.write(bArr, 0, read);
        }
    }

    private static boolean atM(String str) {
        try {
            InetAddress byName = InetAddress.getByName(str);
            if (byName == null || byName.getHostAddress() == null) {
                return false;
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private String iE(Context context) {
        String iF = NetUtil.iF(context);
        boolean isScreenOn = this.tXN.isScreenOn();
        boolean atM = atM("dldir1.qq.com");
        return iF + "|" + isScreenOn + "|" + atM + "|" + atM("www.qq.com");
    }
}
