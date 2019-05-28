package com.tencent.mm.opensdk.diffdev.a;

import android.os.AsyncTask;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.diffdev.OAuthErrCode;
import com.tencent.mm.opensdk.diffdev.OAuthListener;
import com.tencent.mm.opensdk.utils.Log;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import org.json.JSONObject;

final class f extends AsyncTask<Void, Void, a> {
    private OAuthListener l;
    private String o;
    private int u;
    private String url;

    static class a {
        public OAuthErrCode n;
        public String v;
        public int w;

        a() {
        }

        public static a b(byte[] bArr) {
            AppMethodBeat.i(128046);
            a aVar = new a();
            if (bArr == null || bArr.length == 0) {
                Log.e("MicroMsg.SDK.NoopingResult", "parse fail, buf is null");
                aVar.n = OAuthErrCode.WechatAuth_Err_NetworkErr;
                AppMethodBeat.o(128046);
            } else {
                try {
                    try {
                        JSONObject jSONObject = new JSONObject(new String(bArr, ProtocolPackage.ServerEncoding));
                        aVar.w = jSONObject.getInt("wx_errcode");
                        Log.d("MicroMsg.SDK.NoopingResult", String.format("nooping uuidStatusCode = %d", new Object[]{Integer.valueOf(aVar.w)}));
                        switch (aVar.w) {
                            case 402:
                                aVar.n = OAuthErrCode.WechatAuth_Err_Timeout;
                                break;
                            case 403:
                                aVar.n = OAuthErrCode.WechatAuth_Err_Cancel;
                                break;
                            case 404:
                                aVar.n = OAuthErrCode.WechatAuth_Err_OK;
                                break;
                            case 405:
                                aVar.n = OAuthErrCode.WechatAuth_Err_OK;
                                aVar.v = jSONObject.getString("wx_code");
                                break;
                            case 408:
                                aVar.n = OAuthErrCode.WechatAuth_Err_OK;
                                break;
                            case 500:
                                aVar.n = OAuthErrCode.WechatAuth_Err_NormalErr;
                                break;
                            default:
                                aVar.n = OAuthErrCode.WechatAuth_Err_NormalErr;
                                break;
                        }
                        AppMethodBeat.o(128046);
                    } catch (Exception e) {
                        Log.e("MicroMsg.SDK.NoopingResult", String.format("parse json fail, ex = %s", new Object[]{e.getMessage()}));
                        aVar.n = OAuthErrCode.WechatAuth_Err_NormalErr;
                        AppMethodBeat.o(128046);
                    }
                } catch (Exception e2) {
                    Log.e("MicroMsg.SDK.NoopingResult", String.format("parse fail, build String fail, ex = %s", new Object[]{e2.getMessage()}));
                    aVar.n = OAuthErrCode.WechatAuth_Err_NormalErr;
                    AppMethodBeat.o(128046);
                }
            }
            return aVar;
        }
    }

    public f(String str, OAuthListener oAuthListener) {
        AppMethodBeat.i(128054);
        this.o = str;
        this.l = oAuthListener;
        this.url = String.format("https://long.open.weixin.qq.com/connect/l/qrconnect?f=json&uuid=%s", new Object[]{str});
        AppMethodBeat.o(128054);
    }

    /* Access modifiers changed, original: protected|final|synthetic */
    public final /* synthetic */ Object doInBackground(Object[] objArr) {
        AppMethodBeat.i(128056);
        a aVar;
        if (this.o == null || this.o.length() == 0) {
            Log.e("MicroMsg.SDK.NoopingTask", "run fail, uuid is null");
            aVar = new a();
            aVar.n = OAuthErrCode.WechatAuth_Err_NormalErr;
            AppMethodBeat.o(128056);
            return aVar;
        }
        while (!isCancelled()) {
            String str = this.url + (this.u == 0 ? "" : "&last=" + this.u);
            long currentTimeMillis = System.currentTimeMillis();
            byte[] a = e.a(str);
            long currentTimeMillis2 = System.currentTimeMillis();
            aVar = a.b(a);
            Log.d("MicroMsg.SDK.NoopingTask", String.format("nooping, url = %s, errCode = %s, uuidStatusCode = %d, time consumed = %d(ms)", new Object[]{str, aVar.n.toString(), Integer.valueOf(aVar.w), Long.valueOf(currentTimeMillis2 - currentTimeMillis)}));
            if (aVar.n == OAuthErrCode.WechatAuth_Err_OK) {
                this.u = aVar.w;
                if (aVar.w == g.UUID_SCANED.getCode()) {
                    this.l.onQrcodeScanned();
                } else if (aVar.w != g.UUID_KEEP_CONNECT.getCode() && aVar.w == g.UUID_CONFIRM.getCode()) {
                    if (aVar.v == null || aVar.v.length() == 0) {
                        Log.e("MicroMsg.SDK.NoopingTask", "nooping fail, confirm with an empty code!!!");
                        aVar.n = OAuthErrCode.WechatAuth_Err_NormalErr;
                    }
                    AppMethodBeat.o(128056);
                    return aVar;
                }
            }
            Log.e("MicroMsg.SDK.NoopingTask", String.format("nooping fail, errCode = %s, uuidStatusCode = %d", new Object[]{aVar.n.toString(), Integer.valueOf(aVar.w)}));
            AppMethodBeat.o(128056);
            return aVar;
        }
        Log.i("MicroMsg.SDK.NoopingTask", "IDiffDevOAuth.stopAuth / detach invoked");
        aVar = new a();
        aVar.n = OAuthErrCode.WechatAuth_Err_Auth_Stopped;
        AppMethodBeat.o(128056);
        return aVar;
    }

    /* Access modifiers changed, original: protected|final|synthetic */
    public final /* synthetic */ void onPostExecute(Object obj) {
        AppMethodBeat.i(128055);
        a aVar = (a) obj;
        this.l.onAuthFinish(aVar.n, aVar.v);
        AppMethodBeat.o(128055);
    }
}
