package com.tencent.smtt.sdk.p1104a;

import MTT.ThirdAppInfoNew;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.text.TextUtils;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.TbsConfig;
import com.tencent.smtt.sdk.TbsCoreLoadStat;
import com.tencent.smtt.sdk.TbsDownloadConfig;
import com.tencent.smtt.sdk.TbsDownloadUpload;
import com.tencent.smtt.sdk.TbsDownloader;
import com.tencent.smtt.sdk.TbsPVConfig;
import com.tencent.smtt.sdk.TbsShareManager;
import com.tencent.smtt.utils.C16160s;
import com.tencent.smtt.utils.C36443b;
import com.tencent.smtt.utils.C36446v;
import com.tencent.smtt.utils.C44464o;
import com.tencent.smtt.utils.C46743p;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;
import java.util.zip.GZIPInputStream;
import java.util.zip.Inflater;
import java.util.zip.InflaterInputStream;
import org.json.JSONObject;

/* renamed from: com.tencent.smtt.sdk.a.b */
public class C40969b {
    /* renamed from: a */
    public static byte[] f16285a;

    static {
        AppMethodBeat.m2504i(65150);
        f16285a = null;
        try {
            f16285a = "65dRa93L".getBytes(ProtocolPackage.ServerEncoding);
            AppMethodBeat.m2505o(65150);
        } catch (UnsupportedEncodingException e) {
            AppMethodBeat.m2505o(65150);
        }
    }

    /* renamed from: a */
    private static String m71053a(Context context) {
        String str = null;
        AppMethodBeat.m2504i(65143);
        try {
            byte[] toByteArray = context.getPackageManager().getPackageInfo(context.getPackageName(), 64).signatures[0].toByteArray();
            if (toByteArray != null) {
                MessageDigest instance = MessageDigest.getInstance("SHA-1");
                instance.update(toByteArray);
                toByteArray = instance.digest();
                if (toByteArray != null) {
                    StringBuilder stringBuilder = new StringBuilder("");
                    if (toByteArray == null || toByteArray.length <= 0) {
                        AppMethodBeat.m2505o(65143);
                        return str;
                    }
                    for (int i = 0; i < toByteArray.length; i++) {
                        String toUpperCase = Integer.toHexString(toByteArray[i] & 255).toUpperCase();
                        if (i > 0) {
                            stringBuilder.append(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D);
                        }
                        if (toUpperCase.length() < 2) {
                            stringBuilder.append(0);
                        }
                        stringBuilder.append(toUpperCase);
                    }
                    str = stringBuilder.toString();
                    AppMethodBeat.m2505o(65143);
                    return str;
                }
            }
        } catch (Exception e) {
        }
        AppMethodBeat.m2505o(65143);
        return str;
    }

    /* renamed from: a */
    public static void m71055a(ThirdAppInfoNew thirdAppInfoNew, Context context) {
        AppMethodBeat.m2504i(65140);
        new C24261c("HttpUtils", thirdAppInfoNew, context).start();
        AppMethodBeat.m2505o(65140);
    }

    /* renamed from: a */
    private static void m71057a(Context context, String str, String str2) {
        AppMethodBeat.m2504i(65146);
        if ("reset".equals(str) && "true".equals(str2)) {
            QbSdk.reset(context);
            AppMethodBeat.m2505o(65146);
            return;
        }
        TbsPVConfig.getInstance(context).putData(str, str2);
        AppMethodBeat.m2505o(65146);
    }

    /* renamed from: a */
    public static void m71058a(Context context, String str, String str2, String str3, int i, boolean z, long j) {
        AppMethodBeat.m2504i(65142);
        if (QbSdk.getSettings() != null && QbSdk.getSettings().containsKey(QbSdk.KEY_SET_SENDREQUEST_AND_UPLOAD) && QbSdk.getSettings().get(QbSdk.KEY_SET_SENDREQUEST_AND_UPLOAD).equals("false")) {
            TbsLog.m80434i("sdkreport", "[HttpUtils.doReport] -- SET_SENDREQUEST_AND_UPLOAD is false");
            AppMethodBeat.m2505o(65142);
            return;
        }
        String str4;
        String str5 = "";
        try {
            ApplicationInfo applicationInfo = context.getApplicationInfo();
            if (TbsConfig.APP_QQ.equals(applicationInfo.packageName)) {
                str5 = context.getPackageManager().getPackageInfo(applicationInfo.packageName, 0).versionName;
                if (!TextUtils.isEmpty(QbSdk.getQQBuildNumber())) {
                    str5 = str5 + "." + QbSdk.getQQBuildNumber();
                }
            }
            str4 = str5;
        } catch (Exception e) {
            str4 = str5;
        }
        try {
            int i2;
            ThirdAppInfoNew thirdAppInfoNew;
            ThirdAppInfoNew thirdAppInfoNew2 = new ThirdAppInfoNew();
            thirdAppInfoNew2.sAppName = context.getApplicationContext().getApplicationInfo().packageName;
            C36446v.m60195a(context);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT+08"));
            thirdAppInfoNew2.sTime = simpleDateFormat.format(Calendar.getInstance().getTime());
            thirdAppInfoNew2.sVersionCode = C36443b.m60185b(context);
            str5 = C36443b.m60179a(context, TbsDownloader.TBS_METADATA);
            if (!TextUtils.isEmpty(str5)) {
                thirdAppInfoNew2.sMetaData = str5;
            }
            thirdAppInfoNew2.sGuid = str;
            if (z) {
                thirdAppInfoNew2.sQua2 = str2;
            } else {
                thirdAppInfoNew2.sQua2 = C16160s.m24517a(context);
            }
            thirdAppInfoNew2.sLc = str3;
            str5 = C36443b.m60189e(context);
            String c = C36443b.m60187c(context);
            String d = C36443b.m60188d(context);
            String f = C36443b.m60190f(context);
            if (!(c == null || "".equals(c))) {
                thirdAppInfoNew2.sImei = c;
            }
            if (!(d == null || "".equals(d))) {
                thirdAppInfoNew2.sImsi = d;
            }
            if (!TextUtils.isEmpty(f)) {
                thirdAppInfoNew2.sAndroidID = f;
            }
            if (!(str5 == null || "".equals(str5))) {
                thirdAppInfoNew2.sMac = str5;
            }
            thirdAppInfoNew2.iPv = (long) i;
            ThirdAppInfoNew thirdAppInfoNew3;
            if (TbsShareManager.isThirdPartyApp(context)) {
                if (!z) {
                    thirdAppInfoNew3 = thirdAppInfoNew2;
                    i2 = 0;
                    thirdAppInfoNew = thirdAppInfoNew3;
                } else if (TbsShareManager.getCoreFormOwn()) {
                    i2 = 2;
                    thirdAppInfoNew = thirdAppInfoNew2;
                } else {
                    i2 = 1;
                    thirdAppInfoNew = thirdAppInfoNew2;
                }
            } else if (z) {
                i2 = 1;
                thirdAppInfoNew = thirdAppInfoNew2;
            } else {
                thirdAppInfoNew3 = thirdAppInfoNew2;
                i2 = 0;
                thirdAppInfoNew = thirdAppInfoNew3;
            }
            thirdAppInfoNew.iCoreType = i2;
            thirdAppInfoNew2.sAppVersionName = str4;
            thirdAppInfoNew2.sAppSignature = C40969b.m71053a(context);
            if (!z) {
                thirdAppInfoNew2.sWifiConnectedTime = j;
                thirdAppInfoNew2.localCoreVersion = QbSdk.getTbsVersion(context);
            }
            C40969b.m71055a(thirdAppInfoNew2, context.getApplicationContext());
            AppMethodBeat.m2505o(65142);
        } catch (Throwable th) {
            AppMethodBeat.m2505o(65142);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x003a A:{SYNTHETIC, Splitter:B:18:0x003a} */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x003f A:{SYNTHETIC, Splitter:B:21:0x003f} */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00b9 A:{SYNTHETIC, Splitter:B:50:0x00b9} */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00be A:{SYNTHETIC, Splitter:B:53:0x00be} */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x003a A:{SYNTHETIC, Splitter:B:18:0x003a} */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x003f A:{SYNTHETIC, Splitter:B:21:0x003f} */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00b9 A:{SYNTHETIC, Splitter:B:50:0x00b9} */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00be A:{SYNTHETIC, Splitter:B:53:0x00be} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: b */
    private static String m71059b(HttpURLConnection httpURLConnection, String str, boolean z) {
        Throwable th;
        AppMethodBeat.m2504i(65144);
        String str2 = "";
        InputStream inflaterInputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        try {
            InputStream inputStream = httpURLConnection.getInputStream();
            String contentEncoding = httpURLConnection.getContentEncoding();
            if (contentEncoding == null || !contentEncoding.equalsIgnoreCase("gzip")) {
                if (contentEncoding != null) {
                    if (contentEncoding.equalsIgnoreCase("deflate")) {
                        inflaterInputStream = new InflaterInputStream(inputStream, new Inflater(true));
                    }
                }
                inflaterInputStream = inputStream;
            } else {
                inflaterInputStream = new GZIPInputStream(inputStream);
            }
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    byte[] bArr = new byte[128];
                    while (true) {
                        int read = inflaterInputStream.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        byteArrayOutputStream.write(bArr, 0, read);
                    }
                    str2 = z ? new String(C44464o.m80456a().mo70639c(byteArrayOutputStream.toByteArray())) : new String(C44464o.m80459b(byteArrayOutputStream.toByteArray(), str));
                    if (byteArrayOutputStream != null) {
                        try {
                            byteArrayOutputStream.close();
                        } catch (IOException e) {
                        }
                    }
                    if (inflaterInputStream != null) {
                        inflaterInputStream.close();
                    }
                } catch (Exception e2) {
                    if (byteArrayOutputStream != null) {
                    }
                    if (inflaterInputStream != null) {
                    }
                    TbsLog.m80434i("HttpUtils", "getResponseFromConnection,response=" + str2 + ";isUseRSA=" + z);
                    AppMethodBeat.m2505o(65144);
                    return str2;
                } catch (Throwable th2) {
                    th = th2;
                    if (byteArrayOutputStream != null) {
                    }
                    if (inflaterInputStream != null) {
                    }
                    AppMethodBeat.m2505o(65144);
                    throw th;
                }
            } catch (Exception e3) {
                byteArrayOutputStream = null;
                if (byteArrayOutputStream != null) {
                }
                if (inflaterInputStream != null) {
                }
                TbsLog.m80434i("HttpUtils", "getResponseFromConnection,response=" + str2 + ";isUseRSA=" + z);
                AppMethodBeat.m2505o(65144);
                return str2;
            } catch (Throwable th3) {
                th = th3;
                byteArrayOutputStream = null;
                if (byteArrayOutputStream != null) {
                }
                if (inflaterInputStream != null) {
                }
                AppMethodBeat.m2505o(65144);
                throw th;
            }
        } catch (Exception e4) {
            byteArrayOutputStream = null;
            inflaterInputStream = null;
            if (byteArrayOutputStream != null) {
                try {
                    byteArrayOutputStream.close();
                } catch (IOException e5) {
                }
            }
            if (inflaterInputStream != null) {
                try {
                    inflaterInputStream.close();
                } catch (IOException e6) {
                }
            }
            TbsLog.m80434i("HttpUtils", "getResponseFromConnection,response=" + str2 + ";isUseRSA=" + z);
            AppMethodBeat.m2505o(65144);
            return str2;
        } catch (Throwable th4) {
            th = th4;
            byteArrayOutputStream = null;
            inflaterInputStream = null;
            if (byteArrayOutputStream != null) {
                try {
                    byteArrayOutputStream.close();
                } catch (IOException e7) {
                }
            }
            if (inflaterInputStream != null) {
                try {
                    inflaterInputStream.close();
                } catch (IOException e8) {
                }
            }
            AppMethodBeat.m2505o(65144);
            throw th;
        }
        TbsLog.m80434i("HttpUtils", "getResponseFromConnection,response=" + str2 + ";isUseRSA=" + z);
        AppMethodBeat.m2505o(65144);
        return str2;
    }

    /* renamed from: b */
    private static void m71061b(Context context, String str) {
        AppMethodBeat.m2504i(65145);
        try {
            TbsPVConfig.releaseInstance();
            TbsPVConfig.getInstance(context).clear();
            if (TextUtils.isEmpty(str)) {
                AppMethodBeat.m2505o(65145);
                return;
            }
            for (String split : str.split("\\|")) {
                try {
                    String[] split2 = split.split("=");
                    if (split2.length == 2) {
                        C40969b.m71057a(context, split2[0], split2[1]);
                    }
                } catch (Exception e) {
                }
            }
            TbsPVConfig.getInstance(context).commit();
            AppMethodBeat.m2505o(65145);
        } catch (Exception e2) {
            AppMethodBeat.m2505o(65145);
        }
    }

    /* renamed from: c */
    private static JSONObject m71062c(ThirdAppInfoNew thirdAppInfoNew, Context context) {
        AppMethodBeat.m2504i(65141);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("APPNAME", thirdAppInfoNew.sAppName);
            jSONObject.put("TIME", thirdAppInfoNew.sTime);
            jSONObject.put("QUA2", thirdAppInfoNew.sQua2);
            jSONObject.put("LC", thirdAppInfoNew.sLc);
            jSONObject.put("GUID", thirdAppInfoNew.sGuid);
            jSONObject.put("IMEI", thirdAppInfoNew.sImei);
            jSONObject.put("IMSI", thirdAppInfoNew.sImsi);
            jSONObject.put("MAC", thirdAppInfoNew.sMac);
            jSONObject.put("PV", thirdAppInfoNew.iPv);
            jSONObject.put("CORETYPE", thirdAppInfoNew.iCoreType);
            jSONObject.put("APPVN", thirdAppInfoNew.sAppVersionName);
            jSONObject.put("APPMETADATA", thirdAppInfoNew.sMetaData);
            jSONObject.put("VERSION_CODE", thirdAppInfoNew.sVersionCode);
            jSONObject.put("CPU", thirdAppInfoNew.sCpu);
            if ("com.tencent.mm".equals(thirdAppInfoNew.sAppName) || TbsConfig.APP_QQ.equals(thirdAppInfoNew.sAppName) || TbsConfig.APP_DEMO.equals(thirdAppInfoNew.sAppName)) {
                TbsDownloadUpload tbsDownloadUpload = new TbsDownloadUpload(context);
                tbsDownloadUpload.readTbsDownloadInfo(context);
                int needDownloadCode = tbsDownloadUpload.getNeedDownloadCode();
                int startDownloadCode = tbsDownloadUpload.getStartDownloadCode();
                int needDownloadReturn = tbsDownloadUpload.getNeedDownloadReturn();
                jSONObject.put("SIGNATURE", needDownloadCode + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + startDownloadCode + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + needDownloadReturn + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + tbsDownloadUpload.getLocalCoreVersion());
            } else if (thirdAppInfoNew.sAppSignature == null) {
                jSONObject.put("SIGNATURE", AppEventsConstants.EVENT_PARAM_VALUE_NO);
            } else {
                jSONObject.put("SIGNATURE", thirdAppInfoNew.sAppSignature);
            }
            jSONObject.put("PROTOCOL_VERSION", 3);
            jSONObject.put("ANDROID_ID", thirdAppInfoNew.sAndroidID);
            if (TbsShareManager.isThirdPartyApp(context)) {
                jSONObject.put("HOST_COREVERSION", TbsShareManager.getHostCoreVersions(context));
            } else {
                jSONObject.put("HOST_COREVERSION", TbsDownloader.getCoreShareDecoupleCoreVersionByContext(context));
                jSONObject.put("DECOUPLE_COREVERSION", TbsDownloader.getCoreShareDecoupleCoreVersionByContext(context));
            }
            if (thirdAppInfoNew.iCoreType == 0) {
                jSONObject.put("WIFICONNECTEDTIME", thirdAppInfoNew.sWifiConnectedTime);
                jSONObject.put("CORE_EXIST", thirdAppInfoNew.localCoreVersion);
                int i = TbsCoreLoadStat.mLoadErrorCode;
                if (thirdAppInfoNew.localCoreVersion <= 0) {
                    jSONObject.put("TBS_ERROR_CODE", TbsDownloadConfig.getInstance(context).getDownloadInterruptCode());
                } else {
                    jSONObject.put("TBS_ERROR_CODE", i);
                }
                if (i == -1) {
                    TbsLog.m80432e("sdkreport", "ATTENTION: Load errorCode missed!");
                }
            }
            TbsDownloadConfig.getInstance(context).uploadDownloadInterruptCodeIfNeeded(context);
            try {
                if (QbSdk.getTID() != null) {
                    if (thirdAppInfoNew.sAppName.equals(TbsConfig.APP_QQ)) {
                        jSONObject.put("TID", C46743p.m88599a().mo75290a(QbSdk.getTID()));
                        jSONObject.put("TIDTYPE", 1);
                    } else if (thirdAppInfoNew.sAppName.equals("com.tencent.mm")) {
                        jSONObject.put("TID", QbSdk.getTID());
                        jSONObject.put("TIDTYPE", 0);
                    }
                }
            } catch (Exception e) {
            }
            AppMethodBeat.m2505o(65141);
            return jSONObject;
        } catch (Exception e2) {
            TbsLog.m80432e("sdkreport", "getPostData exception!");
            AppMethodBeat.m2505o(65141);
            return null;
        }
    }
}
