package com.tencent.p177mm.opensdk.diffdev.p1214a;

import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Environment;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.opensdk.diffdev.OAuthErrCode;
import com.tencent.p177mm.opensdk.diffdev.OAuthListener;
import com.tencent.p177mm.opensdk.utils.Log;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.opensdk.diffdev.a.d */
public final class C37981d extends AsyncTask<Void, Void, C37982a> {
    /* renamed from: h */
    private static final String f16126h = (Environment.getExternalStorageDirectory().getAbsolutePath() + "/tencent/MicroMsg/oauth_qrcode.png");
    /* renamed from: i */
    private static String f16127i;
    private String appId;
    /* renamed from: j */
    private String f16128j;
    /* renamed from: k */
    private String f16129k;
    /* renamed from: l */
    private OAuthListener f16130l;
    /* renamed from: m */
    private C18746f f16131m;
    private String scope;
    private String signature;

    /* renamed from: com.tencent.mm.opensdk.diffdev.a.d$a */
    static class C37982a {
        /* renamed from: n */
        public OAuthErrCode f16132n;
        /* renamed from: o */
        public String f16133o;
        /* renamed from: p */
        public String f16134p;
        /* renamed from: q */
        public String f16135q;
        /* renamed from: r */
        public int f16136r;
        /* renamed from: s */
        public String f16137s;
        /* renamed from: t */
        public byte[] f16138t;

        private C37982a() {
        }

        /* renamed from: a */
        public static C37982a m64271a(byte[] bArr) {
            AppMethodBeat.m2504i(128057);
            C37982a c37982a = new C37982a();
            if (bArr == null || bArr.length == 0) {
                Log.m4140e("MicroMsg.SDK.GetQRCodeResult", "parse fail, buf is null");
                c37982a.f16132n = OAuthErrCode.WechatAuth_Err_NetworkErr;
                AppMethodBeat.m2505o(128057);
            } else {
                try {
                    try {
                        JSONObject jSONObject = new JSONObject(new String(bArr, ProtocolPackage.ServerEncoding));
                        int i = jSONObject.getInt("errcode");
                        if (i != 0) {
                            Log.m4140e("MicroMsg.SDK.GetQRCodeResult", String.format("resp errcode = %d", new Object[]{Integer.valueOf(i)}));
                            c37982a.f16132n = OAuthErrCode.WechatAuth_Err_NormalErr;
                            c37982a.f16136r = i;
                            c37982a.f16137s = jSONObject.optString("errmsg");
                            AppMethodBeat.m2505o(128057);
                        } else {
                            String string = jSONObject.getJSONObject("qrcode").getString("qrcodebase64");
                            if (string == null || string.length() == 0) {
                                Log.m4140e("MicroMsg.SDK.GetQRCodeResult", "parse fail, qrcodeBase64 is null");
                                c37982a.f16132n = OAuthErrCode.WechatAuth_Err_JsonDecodeErr;
                                AppMethodBeat.m2505o(128057);
                            } else {
                                byte[] decode = Base64.decode(string, 0);
                                if (decode == null || decode.length == 0) {
                                    Log.m4140e("MicroMsg.SDK.GetQRCodeResult", "parse fail, qrcodeBuf is null");
                                    c37982a.f16132n = OAuthErrCode.WechatAuth_Err_JsonDecodeErr;
                                    AppMethodBeat.m2505o(128057);
                                } else {
                                    c37982a.f16132n = OAuthErrCode.WechatAuth_Err_OK;
                                    c37982a.f16138t = decode;
                                    c37982a.f16133o = jSONObject.getString("uuid");
                                    c37982a.f16134p = jSONObject.getString("appname");
                                    Log.m4139d("MicroMsg.SDK.GetQRCodeResult", String.format("parse succ, save in memory, uuid = %s, appname = %s, imgBufLength = %d", new Object[]{c37982a.f16133o, c37982a.f16134p, Integer.valueOf(c37982a.f16138t.length)}));
                                    AppMethodBeat.m2505o(128057);
                                }
                            }
                        }
                    } catch (Exception e) {
                        Log.m4140e("MicroMsg.SDK.GetQRCodeResult", String.format("parse json fail, ex = %s", new Object[]{e.getMessage()}));
                        c37982a.f16132n = OAuthErrCode.WechatAuth_Err_NormalErr;
                        AppMethodBeat.m2505o(128057);
                    }
                } catch (Exception e2) {
                    Log.m4140e("MicroMsg.SDK.GetQRCodeResult", String.format("parse fail, build String fail, ex = %s", new Object[]{e2.getMessage()}));
                    c37982a.f16132n = OAuthErrCode.WechatAuth_Err_NormalErr;
                    AppMethodBeat.m2505o(128057);
                }
            }
            return c37982a;
        }
    }

    static {
        AppMethodBeat.m2504i(128036);
        f16127i = null;
        f16127i = "https://open.weixin.qq.com/connect/sdk/qrconnect?appid=%s&noncestr=%s&timestamp=%s&scope=%s&signature=%s";
        AppMethodBeat.m2505o(128036);
    }

    public C37981d(String str, String str2, String str3, String str4, String str5, OAuthListener oAuthListener) {
        this.appId = str;
        this.scope = str2;
        this.f16128j = str3;
        this.f16129k = str4;
        this.signature = str5;
        this.f16130l = oAuthListener;
    }

    /* renamed from: a */
    public final boolean mo60755a() {
        AppMethodBeat.m2504i(128033);
        Log.m4141i("MicroMsg.SDK.GetQRCodeTask", "cancelTask");
        boolean cancel;
        if (this.f16131m == null) {
            cancel = cancel(true);
            AppMethodBeat.m2505o(128033);
            return cancel;
        }
        cancel = this.f16131m.cancel(true);
        AppMethodBeat.m2505o(128033);
        return cancel;
    }

    /* Access modifiers changed, original: protected|final|synthetic */
    public final /* synthetic */ Object doInBackground(Object[] objArr) {
        AppMethodBeat.m2504i(128035);
        Log.m4141i("MicroMsg.SDK.GetQRCodeTask", "external storage available = false");
        String format = String.format(f16127i, new Object[]{this.appId, this.f16128j, this.f16129k, this.scope, this.signature});
        long currentTimeMillis = System.currentTimeMillis();
        byte[] a = C18745e.m29298a(format);
        Log.m4139d("MicroMsg.SDK.GetQRCodeTask", String.format("doInBackground, url = %s, time consumed = %d(ms)", new Object[]{format, Long.valueOf(System.currentTimeMillis() - currentTimeMillis)}));
        C37982a a2 = C37982a.m64271a(a);
        AppMethodBeat.m2505o(128035);
        return a2;
    }

    /* Access modifiers changed, original: protected|final|synthetic */
    public final /* synthetic */ void onPostExecute(Object obj) {
        AppMethodBeat.m2504i(128034);
        C37982a c37982a = (C37982a) obj;
        if (c37982a.f16132n == OAuthErrCode.WechatAuth_Err_OK) {
            Log.m4139d("MicroMsg.SDK.GetQRCodeTask", "onPostExecute, get qrcode success");
            this.f16130l.onAuthGotQrcode(c37982a.f16135q, c37982a.f16138t);
            this.f16131m = new C18746f(c37982a.f16133o, this.f16130l);
            C18746f c18746f = this.f16131m;
            if (VERSION.SDK_INT >= 11) {
                c18746f.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                AppMethodBeat.m2505o(128034);
                return;
            }
            c18746f.execute(new Void[0]);
            AppMethodBeat.m2505o(128034);
            return;
        }
        Log.m4140e("MicroMsg.SDK.GetQRCodeTask", String.format("onPostExecute, get qrcode fail, OAuthErrCode = %s", new Object[]{c37982a.f16132n}));
        this.f16130l.onAuthFinish(c37982a.f16132n, null);
        AppMethodBeat.m2505o(128034);
    }
}
