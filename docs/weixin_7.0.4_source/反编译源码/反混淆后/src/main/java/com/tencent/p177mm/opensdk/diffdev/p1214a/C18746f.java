package com.tencent.p177mm.opensdk.diffdev.p1214a;

import android.os.AsyncTask;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.opensdk.diffdev.OAuthErrCode;
import com.tencent.p177mm.opensdk.diffdev.OAuthListener;
import com.tencent.p177mm.opensdk.utils.Log;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.opensdk.diffdev.a.f */
final class C18746f extends AsyncTask<Void, Void, C18747a> {
    /* renamed from: l */
    private OAuthListener f4322l;
    /* renamed from: o */
    private String f4323o;
    /* renamed from: u */
    private int f4324u;
    private String url;

    /* renamed from: com.tencent.mm.opensdk.diffdev.a.f$a */
    static class C18747a {
        /* renamed from: n */
        public OAuthErrCode f4325n;
        /* renamed from: v */
        public String f4326v;
        /* renamed from: w */
        public int f4327w;

        C18747a() {
        }

        /* renamed from: b */
        public static C18747a m29299b(byte[] bArr) {
            AppMethodBeat.m2504i(128046);
            C18747a c18747a = new C18747a();
            if (bArr == null || bArr.length == 0) {
                Log.m4140e("MicroMsg.SDK.NoopingResult", "parse fail, buf is null");
                c18747a.f4325n = OAuthErrCode.WechatAuth_Err_NetworkErr;
                AppMethodBeat.m2505o(128046);
            } else {
                try {
                    try {
                        JSONObject jSONObject = new JSONObject(new String(bArr, ProtocolPackage.ServerEncoding));
                        c18747a.f4327w = jSONObject.getInt("wx_errcode");
                        Log.m4139d("MicroMsg.SDK.NoopingResult", String.format("nooping uuidStatusCode = %d", new Object[]{Integer.valueOf(c18747a.f4327w)}));
                        switch (c18747a.f4327w) {
                            case 402:
                                c18747a.f4325n = OAuthErrCode.WechatAuth_Err_Timeout;
                                break;
                            case 403:
                                c18747a.f4325n = OAuthErrCode.WechatAuth_Err_Cancel;
                                break;
                            case 404:
                                c18747a.f4325n = OAuthErrCode.WechatAuth_Err_OK;
                                break;
                            case 405:
                                c18747a.f4325n = OAuthErrCode.WechatAuth_Err_OK;
                                c18747a.f4326v = jSONObject.getString("wx_code");
                                break;
                            case 408:
                                c18747a.f4325n = OAuthErrCode.WechatAuth_Err_OK;
                                break;
                            case 500:
                                c18747a.f4325n = OAuthErrCode.WechatAuth_Err_NormalErr;
                                break;
                            default:
                                c18747a.f4325n = OAuthErrCode.WechatAuth_Err_NormalErr;
                                break;
                        }
                        AppMethodBeat.m2505o(128046);
                    } catch (Exception e) {
                        Log.m4140e("MicroMsg.SDK.NoopingResult", String.format("parse json fail, ex = %s", new Object[]{e.getMessage()}));
                        c18747a.f4325n = OAuthErrCode.WechatAuth_Err_NormalErr;
                        AppMethodBeat.m2505o(128046);
                    }
                } catch (Exception e2) {
                    Log.m4140e("MicroMsg.SDK.NoopingResult", String.format("parse fail, build String fail, ex = %s", new Object[]{e2.getMessage()}));
                    c18747a.f4325n = OAuthErrCode.WechatAuth_Err_NormalErr;
                    AppMethodBeat.m2505o(128046);
                }
            }
            return c18747a;
        }
    }

    public C18746f(String str, OAuthListener oAuthListener) {
        AppMethodBeat.m2504i(128054);
        this.f4323o = str;
        this.f4322l = oAuthListener;
        this.url = String.format("https://long.open.weixin.qq.com/connect/l/qrconnect?f=json&uuid=%s", new Object[]{str});
        AppMethodBeat.m2505o(128054);
    }

    /* Access modifiers changed, original: protected|final|synthetic */
    public final /* synthetic */ Object doInBackground(Object[] objArr) {
        AppMethodBeat.m2504i(128056);
        C18747a c18747a;
        if (this.f4323o == null || this.f4323o.length() == 0) {
            Log.m4140e("MicroMsg.SDK.NoopingTask", "run fail, uuid is null");
            c18747a = new C18747a();
            c18747a.f4325n = OAuthErrCode.WechatAuth_Err_NormalErr;
            AppMethodBeat.m2505o(128056);
            return c18747a;
        }
        while (!isCancelled()) {
            String str = this.url + (this.f4324u == 0 ? "" : "&last=" + this.f4324u);
            long currentTimeMillis = System.currentTimeMillis();
            byte[] a = C18745e.m29298a(str);
            long currentTimeMillis2 = System.currentTimeMillis();
            c18747a = C18747a.m29299b(a);
            Log.m4139d("MicroMsg.SDK.NoopingTask", String.format("nooping, url = %s, errCode = %s, uuidStatusCode = %d, time consumed = %d(ms)", new Object[]{str, c18747a.f4325n.toString(), Integer.valueOf(c18747a.f4327w), Long.valueOf(currentTimeMillis2 - currentTimeMillis)}));
            if (c18747a.f4325n == OAuthErrCode.WechatAuth_Err_OK) {
                this.f4324u = c18747a.f4327w;
                if (c18747a.f4327w == C18748g.UUID_SCANED.getCode()) {
                    this.f4322l.onQrcodeScanned();
                } else if (c18747a.f4327w != C18748g.UUID_KEEP_CONNECT.getCode() && c18747a.f4327w == C18748g.UUID_CONFIRM.getCode()) {
                    if (c18747a.f4326v == null || c18747a.f4326v.length() == 0) {
                        Log.m4140e("MicroMsg.SDK.NoopingTask", "nooping fail, confirm with an empty code!!!");
                        c18747a.f4325n = OAuthErrCode.WechatAuth_Err_NormalErr;
                    }
                    AppMethodBeat.m2505o(128056);
                    return c18747a;
                }
            }
            Log.m4140e("MicroMsg.SDK.NoopingTask", String.format("nooping fail, errCode = %s, uuidStatusCode = %d", new Object[]{c18747a.f4325n.toString(), Integer.valueOf(c18747a.f4327w)}));
            AppMethodBeat.m2505o(128056);
            return c18747a;
        }
        Log.m4141i("MicroMsg.SDK.NoopingTask", "IDiffDevOAuth.stopAuth / detach invoked");
        c18747a = new C18747a();
        c18747a.f4325n = OAuthErrCode.WechatAuth_Err_Auth_Stopped;
        AppMethodBeat.m2505o(128056);
        return c18747a;
    }

    /* Access modifiers changed, original: protected|final|synthetic */
    public final /* synthetic */ void onPostExecute(Object obj) {
        AppMethodBeat.m2504i(128055);
        C18747a c18747a = (C18747a) obj;
        this.f4322l.onAuthFinish(c18747a.f4325n, c18747a.f4326v);
        AppMethodBeat.m2505o(128055);
    }
}
