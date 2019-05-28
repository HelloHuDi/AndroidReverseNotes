package com.tencent.p177mm.p612ui.p629f.p630a;

import android.app.AlertDialog.Builder;
import android.content.Context;
import android.os.Bundle;
import com.facebook.internal.NativeProtocol;
import com.facebook.share.internal.ShareConstants;
import com.google.firebase.analytics.FirebaseAnalytics.C8741b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.hardcoder.C1625i;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.ttpic.baseutils.IOUtils;
import com.tencent.xweb.C24526c;
import com.tencent.xweb.C44576b;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.ui.f.a.f */
public final class C44373f {
    /* renamed from: m */
    private static String m80200m(Bundle bundle, String str) {
        AppMethodBeat.m2504i(80322);
        String str2;
        if (bundle == null) {
            str2 = "";
            AppMethodBeat.m2505o(80322);
            return str2;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (String str22 : bundle.keySet()) {
            if (bundle.getByteArray(str22) == null) {
                stringBuilder.append("Content-Disposition: form-data; name=\"" + str22 + "\"\r\n\r\n" + bundle.getString(str22));
                stringBuilder.append("\r\n--" + str + IOUtils.LINE_SEPARATOR_WINDOWS);
            }
        }
        str22 = stringBuilder.toString();
        AppMethodBeat.m2505o(80322);
        return str22;
    }

    /* renamed from: aA */
    public static String m80197aA(Bundle bundle) {
        AppMethodBeat.m2504i(80323);
        String str;
        if (bundle == null) {
            str = "";
            AppMethodBeat.m2505o(80323);
            return str;
        }
        StringBuilder stringBuilder = new StringBuilder();
        Object obj = 1;
        for (String str2 : bundle.keySet()) {
            if (obj != null) {
                obj = null;
            } else {
                stringBuilder.append('&');
            }
            stringBuilder.append(URLEncoder.encode(str2) + "=" + URLEncoder.encode(bundle.getString(str2)));
        }
        str2 = stringBuilder.toString();
        AppMethodBeat.m2505o(80323);
        return str2;
    }

    private static Bundle arZ(String str) {
        AppMethodBeat.m2504i(80324);
        Bundle bundle = new Bundle();
        if (str != null) {
            for (String split : str.split("&")) {
                String[] split2 = split.split("=");
                bundle.putString(URLDecoder.decode(split2[0]), URLDecoder.decode(split2[1]));
            }
        }
        AppMethodBeat.m2505o(80324);
        return bundle;
    }

    public static Bundle asa(String str) {
        AppMethodBeat.m2504i(80325);
        Bundle arZ;
        try {
            URL url = new URL(str.replace("fbconnect", "http"));
            arZ = C44373f.arZ(url.getQuery());
            arZ.putAll(C44373f.arZ(url.getRef()));
            AppMethodBeat.m2505o(80325);
            return arZ;
        } catch (MalformedURLException e) {
            arZ = new Bundle();
            AppMethodBeat.m2505o(80325);
            return arZ;
        }
    }

    /* renamed from: e */
    public static String m80198e(String str, String str2, Bundle bundle) {
        String J;
        AppMethodBeat.m2504i(80326);
        String str3 = "3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f";
        String str4 = IOUtils.LINE_SEPARATOR_WINDOWS;
        if (str2.equals("GET")) {
            str = str + "?" + C44373f.m80197aA(bundle);
        }
        C4990ab.m7410d("Facebook-Util", str2 + " URL: " + str);
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        httpURLConnection.setConnectTimeout(C1625i.sHCENCODEVIDEOTIMEOUT);
        httpURLConnection.setReadTimeout(C1625i.sHCENCODEVIDEOTIMEOUT);
        httpURLConnection.setRequestProperty("User-Agent", System.getProperties().getProperty("http.agent") + " FacebookAndroidSDK");
        if (!str2.equals("GET")) {
            Bundle bundle2 = new Bundle();
            for (String str5 : bundle.keySet()) {
                if (bundle.getByteArray(str5) != null) {
                    bundle2.putByteArray(str5, bundle.getByteArray(str5));
                }
            }
            if (!bundle.containsKey(C8741b.METHOD)) {
                bundle.putString(C8741b.METHOD, str2);
            }
            if (bundle.containsKey("access_token")) {
                bundle.putString("access_token", URLDecoder.decode(bundle.getString("access_token")));
            }
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setRequestProperty("Content-Type", "multipart/form-data;boundary=".concat(String.valueOf(str3)));
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setRequestProperty("Connection", "Keep-Alive");
            httpURLConnection.connect();
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(httpURLConnection.getOutputStream());
            bufferedOutputStream.write(("--" + str3 + str4).getBytes());
            bufferedOutputStream.write(C44373f.m80200m(bundle, str3).getBytes());
            bufferedOutputStream.write((str4 + "--" + str3 + str4).getBytes());
            if (!bundle2.isEmpty()) {
                for (String str52 : bundle2.keySet()) {
                    bufferedOutputStream.write(("Content-Disposition: form-data; filename=\"" + str52 + "\"" + str4).getBytes());
                    bufferedOutputStream.write(("Content-Type: content/unknown" + str4 + str4).getBytes());
                    bufferedOutputStream.write(bundle2.getByteArray(str52));
                    bufferedOutputStream.write((str4 + "--" + str3 + str4).getBytes());
                }
            }
            bufferedOutputStream.flush();
        }
        try {
            J = C44373f.m80195J(httpURLConnection.getInputStream());
        } catch (FileNotFoundException e) {
            J = C44373f.m80195J(httpURLConnection.getErrorStream());
        }
        AppMethodBeat.m2505o(80326);
        return J;
    }

    /* renamed from: J */
    private static String m80195J(InputStream inputStream) {
        String readLine;
        AppMethodBeat.m2504i(80327);
        StringBuilder stringBuilder = new StringBuilder();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream), 1000);
        for (readLine = bufferedReader.readLine(); readLine != null; readLine = bufferedReader.readLine()) {
            stringBuilder.append(readLine);
        }
        inputStream.close();
        readLine = stringBuilder.toString();
        AppMethodBeat.m2505o(80327);
        return readLine;
    }

    /* renamed from: if */
    public static void m80199if(Context context) {
        AppMethodBeat.m2504i(80328);
        C24526c.m38159jx(context);
        C44576b.dTR().removeAllCookie();
        AppMethodBeat.m2505o(80328);
    }

    public static JSONObject asb(String str) {
        AppMethodBeat.m2504i(80329);
        if (str.equals("false")) {
            C30706e c30706e = new C30706e("request failed");
            AppMethodBeat.m2505o(80329);
            throw c30706e;
        }
        if (str.equals("true")) {
            str = "{value : true}";
        }
        JSONObject jSONObject = new JSONObject(str);
        C30706e c30706e2;
        if (jSONObject.has("error")) {
            jSONObject = jSONObject.getJSONObject("error");
            c30706e2 = new C30706e(jSONObject.getString(ShareConstants.WEB_DIALOG_PARAM_MESSAGE), jSONObject.getString("type"), 0);
            AppMethodBeat.m2505o(80329);
            throw c30706e2;
        } else if (jSONObject.has(NativeProtocol.BRIDGE_ARG_ERROR_CODE) && jSONObject.has("error_msg")) {
            c30706e2 = new C30706e(jSONObject.getString("error_msg"), "", Integer.parseInt(jSONObject.getString(NativeProtocol.BRIDGE_ARG_ERROR_CODE)));
            AppMethodBeat.m2505o(80329);
            throw c30706e2;
        } else if (jSONObject.has(NativeProtocol.BRIDGE_ARG_ERROR_CODE)) {
            c30706e2 = new C30706e("request failed", "", Integer.parseInt(jSONObject.getString(NativeProtocol.BRIDGE_ARG_ERROR_CODE)));
            AppMethodBeat.m2505o(80329);
            throw c30706e2;
        } else if (jSONObject.has("error_msg")) {
            c30706e2 = new C30706e(jSONObject.getString("error_msg"));
            AppMethodBeat.m2505o(80329);
            throw c30706e2;
        } else if (jSONObject.has("error_reason")) {
            c30706e2 = new C30706e(jSONObject.getString("error_reason"));
            AppMethodBeat.m2505o(80329);
            throw c30706e2;
        } else {
            AppMethodBeat.m2505o(80329);
            return jSONObject;
        }
    }

    /* renamed from: L */
    public static void m80196L(Context context, String str, String str2) {
        AppMethodBeat.m2504i(80330);
        Builder builder = new Builder(context);
        builder.setTitle(str);
        builder.setMessage(str2);
        builder.create().show();
        AppMethodBeat.m2505o(80330);
    }
}
