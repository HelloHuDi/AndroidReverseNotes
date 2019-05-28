package com.tencent.smtt.sdk.a;

import MTT.ThirdAppInfoNew;
import android.content.Context;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hardcoder.i;
import com.tencent.smtt.sdk.TbsDownloadConfig;
import com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey;
import com.tencent.smtt.sdk.TbsDownloadUpload;
import com.tencent.smtt.sdk.TbsLogReport;
import com.tencent.smtt.sdk.TbsLogReport.EventType;
import com.tencent.smtt.sdk.TbsLogReport.TbsLogInfo;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.b;
import com.tencent.smtt.utils.o;
import com.tencent.smtt.utils.v;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

final class c extends Thread {
    final /* synthetic */ ThirdAppInfoNew a;
    final /* synthetic */ Context b;

    c(String str, ThirdAppInfoNew thirdAppInfoNew, Context context) {
        this.a = thirdAppInfoNew;
        this.b = context;
        super(str);
    }

    public final void run() {
        AppMethodBeat.i(65139);
        this.a.sCpu = b.a();
        if (VERSION.SDK_INT < 8) {
            AppMethodBeat.o(65139);
            return;
        }
        if (b.a == null) {
            try {
                b.a = "65dRa93L".getBytes(ProtocolPackage.ServerEncoding);
            } catch (UnsupportedEncodingException e) {
                b.a = null;
                TbsLog.e("sdkreport", "Post failed -- get POST_DATA_KEY failed!");
            }
        }
        if (b.a == null) {
            TbsLog.e("sdkreport", "Post failed -- POST_DATA_KEY is null!");
            AppMethodBeat.o(65139);
            return;
        }
        String string = TbsDownloadConfig.getInstance(this.b).mPreferences.getString(TbsConfigKey.KEY_DESkEY_TOKEN, "");
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
            v a = v.a();
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(z ? a.b() + o.a().b() : a.f() + charSequence).openConnection();
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setConnectTimeout(i.sHCENCODEVIDEOTIMEOUT);
            if (VERSION.SDK_INT > 13) {
                httpURLConnection.setRequestProperty("Connection", "close");
            }
            try {
                b = b.b(this.a, this.b);
            } catch (Exception e2) {
                b = null;
            }
            if (b == null) {
                TbsLog.e("sdkreport", "post -- jsonData is null!");
                AppMethodBeat.o(65139);
                return;
            }
            try {
                byte[] bytes = b.toString().getBytes(ProtocolPackage.ServerEncoding);
                bytes = z ? o.a().a(bytes) : o.a(bytes, string);
                httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                httpURLConnection.setRequestProperty("Content-Length", String.valueOf(bytes.length));
                TbsLogInfo tbsLogInfo;
                try {
                    OutputStream outputStream = httpURLConnection.getOutputStream();
                    outputStream.write(bytes);
                    outputStream.flush();
                    if (httpURLConnection.getResponseCode() == 200) {
                        TbsLog.i("sdkreport", "Post successful!");
                        TbsLog.i("sdkreport", "SIGNATURE is " + b.getString("SIGNATURE"));
                        b.a(this.b, b.a(httpURLConnection, string, z));
                        new TbsDownloadUpload(this.b).clearUploadCode();
                        AppMethodBeat.o(65139);
                        return;
                    }
                    TbsLog.e("sdkreport", "Post failed -- not 200 code is " + httpURLConnection.getResponseCode());
                    tbsLogInfo = TbsLogReport.getInstance(this.b).tbsLogInfo();
                    tbsLogInfo.setErrorCode(126);
                    tbsLogInfo.setFailDetail(httpURLConnection.getResponseCode());
                    TbsLogReport.getInstance(this.b).eventReport(EventType.TYPE_DOWNLOAD, tbsLogInfo);
                    AppMethodBeat.o(65139);
                } catch (Throwable th) {
                    TbsLog.e("sdkreport", "Post failed -- exceptions:" + th.getMessage());
                    tbsLogInfo = TbsLogReport.getInstance(this.b).tbsLogInfo();
                    tbsLogInfo.setErrorCode(126);
                    tbsLogInfo.setFailDetail(th);
                    TbsLogReport.getInstance(this.b).eventReport(EventType.TYPE_DOWNLOAD, tbsLogInfo);
                    AppMethodBeat.o(65139);
                }
            } catch (Throwable th2) {
                AppMethodBeat.o(65139);
            }
        } catch (IOException e3) {
            TbsLog.e("sdkreport", "Post failed -- IOException:".concat(String.valueOf(e3)));
            AppMethodBeat.o(65139);
        } catch (AssertionError e4) {
            TbsLog.e("sdkreport", "Post failed -- AssertionError:".concat(String.valueOf(e4)));
            AppMethodBeat.o(65139);
        } catch (NoClassDefFoundError e5) {
            TbsLog.e("sdkreport", "Post failed -- NoClassDefFoundError:".concat(String.valueOf(e5)));
            AppMethodBeat.o(65139);
        }
    }
}
