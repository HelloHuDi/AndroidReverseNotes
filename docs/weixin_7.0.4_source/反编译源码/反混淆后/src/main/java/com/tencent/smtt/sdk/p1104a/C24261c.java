package com.tencent.smtt.sdk.p1104a;

import MTT.ThirdAppInfoNew;
import android.content.Context;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.hardcoder.C1625i;
import com.tencent.smtt.sdk.TbsDownloadConfig;
import com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey;
import com.tencent.smtt.sdk.TbsDownloadUpload;
import com.tencent.smtt.sdk.TbsLogReport;
import com.tencent.smtt.sdk.TbsLogReport.EventType;
import com.tencent.smtt.sdk.TbsLogReport.TbsLogInfo;
import com.tencent.smtt.utils.C36443b;
import com.tencent.smtt.utils.C36446v;
import com.tencent.smtt.utils.C44464o;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

/* renamed from: com.tencent.smtt.sdk.a.c */
final class C24261c extends Thread {
    /* renamed from: a */
    final /* synthetic */ ThirdAppInfoNew f4507a;
    /* renamed from: b */
    final /* synthetic */ Context f4508b;

    C24261c(String str, ThirdAppInfoNew thirdAppInfoNew, Context context) {
        this.f4507a = thirdAppInfoNew;
        this.f4508b = context;
        super(str);
    }

    public final void run() {
        AppMethodBeat.m2504i(65139);
        this.f4507a.sCpu = C36443b.m60176a();
        if (VERSION.SDK_INT < 8) {
            AppMethodBeat.m2505o(65139);
            return;
        }
        if (C40969b.f16285a == null) {
            try {
                C40969b.f16285a = "65dRa93L".getBytes(ProtocolPackage.ServerEncoding);
            } catch (UnsupportedEncodingException e) {
                C40969b.f16285a = null;
                TbsLog.m80432e("sdkreport", "Post failed -- get POST_DATA_KEY failed!");
            }
        }
        if (C40969b.f16285a == null) {
            TbsLog.m80432e("sdkreport", "Post failed -- POST_DATA_KEY is null!");
            AppMethodBeat.m2505o(65139);
            return;
        }
        String string = TbsDownloadConfig.getInstance(this.f4508b).mPreferences.getString(TbsConfigKey.KEY_DESkEY_TOKEN, "");
        CharSequence charSequence = "";
        String str = "";
        if (TextUtils.isEmpty(string)) {
            string = str;
        } else {
            charSequence = string.substring(0, string.indexOf("&"));
            string = string.substring(string.indexOf("&") + 1, string.length());
        }
        boolean z = TextUtils.isEmpty(charSequence) || charSequence.length() != 96 || TextUtils.isEmpty(string) || string.length() != 24;
        try {
            JSONObject b;
            C36446v a = C36446v.m60194a();
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(z ? a.mo57632b() + C44464o.m80456a().mo70638b() : a.mo57636f() + charSequence).openConnection();
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setConnectTimeout(C1625i.sHCENCODEVIDEOTIMEOUT);
            if (VERSION.SDK_INT > 13) {
                httpURLConnection.setRequestProperty("Connection", "close");
            }
            try {
                b = C40969b.m71060b(this.f4507a, this.f4508b);
            } catch (Exception e2) {
                b = null;
            }
            if (b == null) {
                TbsLog.m80432e("sdkreport", "post -- jsonData is null!");
                AppMethodBeat.m2505o(65139);
                return;
            }
            try {
                byte[] bytes = b.toString().getBytes(ProtocolPackage.ServerEncoding);
                bytes = z ? C44464o.m80456a().mo70637a(bytes) : C44464o.m80457a(bytes, string);
                httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                httpURLConnection.setRequestProperty("Content-Length", String.valueOf(bytes.length));
                TbsLogInfo tbsLogInfo;
                try {
                    OutputStream outputStream = httpURLConnection.getOutputStream();
                    outputStream.write(bytes);
                    outputStream.flush();
                    if (httpURLConnection.getResponseCode() == 200) {
                        TbsLog.m80434i("sdkreport", "Post successful!");
                        TbsLog.m80434i("sdkreport", "SIGNATURE is " + b.getString("SIGNATURE"));
                        C40969b.m71056a(this.f4508b, C40969b.m71054a(httpURLConnection, string, z));
                        new TbsDownloadUpload(this.f4508b).clearUploadCode();
                        AppMethodBeat.m2505o(65139);
                        return;
                    }
                    TbsLog.m80432e("sdkreport", "Post failed -- not 200 code is " + httpURLConnection.getResponseCode());
                    tbsLogInfo = TbsLogReport.getInstance(this.f4508b).tbsLogInfo();
                    tbsLogInfo.setErrorCode(126);
                    tbsLogInfo.setFailDetail(httpURLConnection.getResponseCode());
                    TbsLogReport.getInstance(this.f4508b).eventReport(EventType.TYPE_DOWNLOAD, tbsLogInfo);
                    AppMethodBeat.m2505o(65139);
                } catch (Throwable th) {
                    TbsLog.m80432e("sdkreport", "Post failed -- exceptions:" + th.getMessage());
                    tbsLogInfo = TbsLogReport.getInstance(this.f4508b).tbsLogInfo();
                    tbsLogInfo.setErrorCode(126);
                    tbsLogInfo.setFailDetail(th);
                    TbsLogReport.getInstance(this.f4508b).eventReport(EventType.TYPE_DOWNLOAD, tbsLogInfo);
                    AppMethodBeat.m2505o(65139);
                }
            } catch (Throwable th2) {
                AppMethodBeat.m2505o(65139);
            }
        } catch (IOException e3) {
            TbsLog.m80432e("sdkreport", "Post failed -- IOException:".concat(String.valueOf(e3)));
            AppMethodBeat.m2505o(65139);
        } catch (AssertionError e4) {
            TbsLog.m80432e("sdkreport", "Post failed -- AssertionError:".concat(String.valueOf(e4)));
            AppMethodBeat.m2505o(65139);
        } catch (NoClassDefFoundError e5) {
            TbsLog.m80432e("sdkreport", "Post failed -- NoClassDefFoundError:".concat(String.valueOf(e5)));
            AppMethodBeat.m2505o(65139);
        }
    }
}
