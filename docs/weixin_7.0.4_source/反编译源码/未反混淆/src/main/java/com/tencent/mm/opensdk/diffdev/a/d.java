package com.tencent.mm.opensdk.diffdev.a;

import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Environment;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.diffdev.OAuthErrCode;
import com.tencent.mm.opensdk.diffdev.OAuthListener;
import com.tencent.mm.opensdk.utils.Log;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import org.json.JSONObject;

public final class d extends AsyncTask<Void, Void, a> {
    private static final String h = (Environment.getExternalStorageDirectory().getAbsolutePath() + "/tencent/MicroMsg/oauth_qrcode.png");
    private static String i;
    private String appId;
    private String j;
    private String k;
    private OAuthListener l;
    private f m;
    private String scope;
    private String signature;

    static class a {
        public OAuthErrCode n;
        public String o;
        public String p;
        public String q;
        public int r;
        public String s;
        public byte[] t;

        private a() {
        }

        public static a a(byte[] bArr) {
            AppMethodBeat.i(128057);
            a aVar = new a();
            if (bArr == null || bArr.length == 0) {
                Log.e("MicroMsg.SDK.GetQRCodeResult", "parse fail, buf is null");
                aVar.n = OAuthErrCode.WechatAuth_Err_NetworkErr;
                AppMethodBeat.o(128057);
            } else {
                try {
                    try {
                        JSONObject jSONObject = new JSONObject(new String(bArr, ProtocolPackage.ServerEncoding));
                        int i = jSONObject.getInt("errcode");
                        if (i != 0) {
                            Log.e("MicroMsg.SDK.GetQRCodeResult", String.format("resp errcode = %d", new Object[]{Integer.valueOf(i)}));
                            aVar.n = OAuthErrCode.WechatAuth_Err_NormalErr;
                            aVar.r = i;
                            aVar.s = jSONObject.optString("errmsg");
                            AppMethodBeat.o(128057);
                        } else {
                            String string = jSONObject.getJSONObject("qrcode").getString("qrcodebase64");
                            if (string == null || string.length() == 0) {
                                Log.e("MicroMsg.SDK.GetQRCodeResult", "parse fail, qrcodeBase64 is null");
                                aVar.n = OAuthErrCode.WechatAuth_Err_JsonDecodeErr;
                                AppMethodBeat.o(128057);
                            } else {
                                byte[] decode = Base64.decode(string, 0);
                                if (decode == null || decode.length == 0) {
                                    Log.e("MicroMsg.SDK.GetQRCodeResult", "parse fail, qrcodeBuf is null");
                                    aVar.n = OAuthErrCode.WechatAuth_Err_JsonDecodeErr;
                                    AppMethodBeat.o(128057);
                                } else {
                                    aVar.n = OAuthErrCode.WechatAuth_Err_OK;
                                    aVar.t = decode;
                                    aVar.o = jSONObject.getString("uuid");
                                    aVar.p = jSONObject.getString("appname");
                                    Log.d("MicroMsg.SDK.GetQRCodeResult", String.format("parse succ, save in memory, uuid = %s, appname = %s, imgBufLength = %d", new Object[]{aVar.o, aVar.p, Integer.valueOf(aVar.t.length)}));
                                    AppMethodBeat.o(128057);
                                }
                            }
                        }
                    } catch (Exception e) {
                        Log.e("MicroMsg.SDK.GetQRCodeResult", String.format("parse json fail, ex = %s", new Object[]{e.getMessage()}));
                        aVar.n = OAuthErrCode.WechatAuth_Err_NormalErr;
                        AppMethodBeat.o(128057);
                    }
                } catch (Exception e2) {
                    Log.e("MicroMsg.SDK.GetQRCodeResult", String.format("parse fail, build String fail, ex = %s", new Object[]{e2.getMessage()}));
                    aVar.n = OAuthErrCode.WechatAuth_Err_NormalErr;
                    AppMethodBeat.o(128057);
                }
            }
            return aVar;
        }
    }

    static {
        AppMethodBeat.i(128036);
        i = null;
        i = "https://open.weixin.qq.com/connect/sdk/qrconnect?appid=%s&noncestr=%s&timestamp=%s&scope=%s&signature=%s";
        AppMethodBeat.o(128036);
    }

    public d(String str, String str2, String str3, String str4, String str5, OAuthListener oAuthListener) {
        this.appId = str;
        this.scope = str2;
        this.j = str3;
        this.k = str4;
        this.signature = str5;
        this.l = oAuthListener;
    }

    public final boolean a() {
        AppMethodBeat.i(128033);
        Log.i("MicroMsg.SDK.GetQRCodeTask", "cancelTask");
        boolean cancel;
        if (this.m == null) {
            cancel = cancel(true);
            AppMethodBeat.o(128033);
            return cancel;
        }
        cancel = this.m.cancel(true);
        AppMethodBeat.o(128033);
        return cancel;
    }

    /* Access modifiers changed, original: protected|final|synthetic */
    public final /* synthetic */ Object doInBackground(Object[] objArr) {
        AppMethodBeat.i(128035);
        Log.i("MicroMsg.SDK.GetQRCodeTask", "external storage available = false");
        String format = String.format(i, new Object[]{this.appId, this.j, this.k, this.scope, this.signature});
        long currentTimeMillis = System.currentTimeMillis();
        byte[] a = e.a(format);
        Log.d("MicroMsg.SDK.GetQRCodeTask", String.format("doInBackground, url = %s, time consumed = %d(ms)", new Object[]{format, Long.valueOf(System.currentTimeMillis() - currentTimeMillis)}));
        a a2 = a.a(a);
        AppMethodBeat.o(128035);
        return a2;
    }

    /* Access modifiers changed, original: protected|final|synthetic */
    public final /* synthetic */ void onPostExecute(Object obj) {
        AppMethodBeat.i(128034);
        a aVar = (a) obj;
        if (aVar.n == OAuthErrCode.WechatAuth_Err_OK) {
            Log.d("MicroMsg.SDK.GetQRCodeTask", "onPostExecute, get qrcode success");
            this.l.onAuthGotQrcode(aVar.q, aVar.t);
            this.m = new f(aVar.o, this.l);
            f fVar = this.m;
            if (VERSION.SDK_INT >= 11) {
                fVar.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                AppMethodBeat.o(128034);
                return;
            }
            fVar.execute(new Void[0]);
            AppMethodBeat.o(128034);
            return;
        }
        Log.e("MicroMsg.SDK.GetQRCodeTask", String.format("onPostExecute, get qrcode fail, OAuthErrCode = %s", new Object[]{aVar.n}));
        this.l.onAuthFinish(aVar.n, null);
        AppMethodBeat.o(128034);
    }
}
