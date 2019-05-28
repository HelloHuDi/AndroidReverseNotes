package com.tencent.mm.plugin.account.bind.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.webkit.ConsoleMessage;
import android.widget.TextView;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.ServerProtocol;
import com.google.android.gms.common.Scopes;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.tencent.liteav.network.TXCStreamUploader;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.hardcoder.i;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.friend.a.m;
import com.tencent.mm.plugin.account.friend.a.w;
import com.tencent.mm.pluginsdk.ui.tools.u;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import com.tencent.xweb.WebView;
import com.tencent.xweb.c;
import com.tencent.xweb.l;
import com.tencent.xweb.s;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

@JgClassChecked(author = 20, fComment = "checked", lastDate = "20140429", reviewer = 20, vComment = {EType.JSEXECUTECHECK})
public class BindGoogleContactUI extends MMActivity implements f {
    private boolean eVT = false;
    private MMWebView fow;
    private w gqA;
    private boolean gqB = false;
    private boolean gql = false;
    String gqn;
    private ProgressDialog gqo;
    private int gqq;
    private TextView gqv;
    private boolean gqw = false;
    private String gqx;
    String gqy;
    String gqz;

    /* renamed from: com.tencent.mm.plugin.account.bind.ui.BindGoogleContactUI$4 */
    class AnonymousClass4 implements OnClickListener {
        final /* synthetic */ String gqD;

        AnonymousClass4(String str) {
            this.gqD = str;
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.i(13351);
            BindGoogleContactUI.a(BindGoogleContactUI.this, this.gqD, w.gvL);
            AppMethodBeat.o(13351);
        }
    }

    class b extends AsyncTask<Void, Void, Void> {
        private boolean cxT;
        private String gqE;
        private String gqH;
        private String gqI;

        /* Access modifiers changed, original: protected|final|synthetic */
        public final /* synthetic */ Object doInBackground(Object[] objArr) {
            AppMethodBeat.i(13363);
            Void aoY = aoY();
            AppMethodBeat.o(13363);
            return aoY;
        }

        /* Access modifiers changed, original: protected|final|synthetic */
        public final /* synthetic */ void onPostExecute(Object obj) {
            AppMethodBeat.i(13362);
            super.onPostExecute((Void) obj);
            ab.i("MicroMsg.GoogleContact.BindGoogleContactUI", "onPostExecute");
            BindGoogleContactUI bindGoogleContactUI = BindGoogleContactUI.this;
            boolean z = this.cxT;
            String str = this.gqE;
            String str2 = this.gqI;
            if (!z || TextUtils.isEmpty(str)) {
                bindGoogleContactUI.aoX();
                bindGoogleContactUI.aoU();
                AppMethodBeat.o(13362);
                return;
            }
            bindGoogleContactUI.gqy = str;
            bindGoogleContactUI.gqz = str2;
            new a(bindGoogleContactUI.gqy).execute(new Void[0]);
            AppMethodBeat.o(13362);
        }

        public b(String str) {
            this.gqH = str;
        }

        /* Access modifiers changed, original: protected|final */
        public final void onPreExecute() {
            AppMethodBeat.i(13360);
            super.onPreExecute();
            ab.i("MicroMsg.GoogleContact.BindGoogleContactUI", "onPreExecute");
            this.gqE = "";
            this.gqI = "";
            this.cxT = false;
            AppMethodBeat.o(13360);
        }

        private Void aoY() {
            AppMethodBeat.i(13361);
            try {
                String str = this.gqH;
                String str2 = "";
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL("https://accounts.google.com/o/oauth2/token").openConnection();
                httpURLConnection.setRequestProperty("Charset", "UTF-8");
                httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setConnectTimeout(i.sHCENCODEVIDEOTIMEOUT);
                httpURLConnection.setReadTimeout(i.sHCENCODEVIDEOTIMEOUT);
                httpURLConnection.setDoInput(true);
                httpURLConnection.setDoOutput(true);
                ArrayList arrayList = new ArrayList();
                arrayList.add(new BasicNameValuePair(TMQQDownloaderOpenSDKConst.UINTYPE_CODE, str));
                arrayList.add(new BasicNameValuePair("client_id", "369820936870.apps.googleusercontent.com"));
                arrayList.add(new BasicNameValuePair("client_secret", "wcFhvo-s7wNcmQ9Zjr00H06u"));
                arrayList.add(new BasicNameValuePair(ServerProtocol.DIALOG_PARAM_REDIRECT_URI, "urn:ietf:wg:oauth:2.0:oob"));
                arrayList.add(new BasicNameValuePair("grant_type", "authorization_code"));
                str = m.au(arrayList);
                ab.i("MicroMsg.GoogleContact.BindGoogleContactUI", "QueryString:%s", str);
                httpURLConnection.setRequestProperty("Content-length", String.valueOf(str.getBytes().length));
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(httpURLConnection.getOutputStream(), "UTF-8"));
                bufferedWriter.write(str);
                bufferedWriter.flush();
                bufferedWriter.close();
                int responseCode = httpURLConnection.getResponseCode();
                ab.e("MicroMsg.GoogleContact.BindGoogleContactUI", "responseCode:".concat(String.valueOf(responseCode)));
                if (200 == responseCode) {
                    StringBuffer stringBuffer = new StringBuffer();
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream(), "UTF-8"));
                    while (true) {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        stringBuffer.append(readLine);
                    }
                    bufferedReader.close();
                    str2 = stringBuffer.toString();
                    ab.i("MicroMsg.GoogleContact.BindGoogleContactUI", "exchange token respone:%s", str2);
                }
                httpURLConnection.disconnect();
                this.gqE = new JSONObject(str2).optString("access_token");
                this.gqI = new JSONObject(str2).optString("refresh_token");
                ab.i("MicroMsg.GoogleContact.BindGoogleContactUI", "response:%s", str2);
                ab.i("MicroMsg.GoogleContact.BindGoogleContactUI", "mAccessToken:%s", this.gqE);
                ab.i("MicroMsg.GoogleContact.BindGoogleContactUI", "mRefreshToken:%s", this.gqI);
                this.cxT = true;
            } catch (MalformedURLException e) {
                ab.e("MicroMsg.GoogleContact.BindGoogleContactUI", "MalformedURLException:%s" + e.getMessage());
            } catch (ProtocolException e2) {
                ab.e("MicroMsg.GoogleContact.BindGoogleContactUI", "ProtocolException:%s" + e2.getMessage());
            } catch (IOException e3) {
                ab.e("MicroMsg.GoogleContact.BindGoogleContactUI", "IOException:%s" + e3.getMessage());
            } catch (JSONException e4) {
                ab.e("MicroMsg.GoogleContact.BindGoogleContactUI", "JSONException:%s" + e4.getMessage());
            }
            AppMethodBeat.o(13361);
            return null;
        }
    }

    class a extends AsyncTask<Void, Void, Void> {
        private String gqE;
        private String gqF;
        private boolean gqG;

        /* Access modifiers changed, original: protected|final|synthetic */
        public final /* synthetic */ Object doInBackground(Object[] objArr) {
            AppMethodBeat.i(13359);
            Void aoY = aoY();
            AppMethodBeat.o(13359);
            return aoY;
        }

        /* Access modifiers changed, original: protected|final|synthetic */
        public final /* synthetic */ void onPostExecute(Object obj) {
            AppMethodBeat.i(13358);
            super.onPostExecute((Void) obj);
            ab.i("MicroMsg.GoogleContact.BindGoogleContactUI", "onPostExecute");
            Context context = BindGoogleContactUI.this;
            boolean z = this.gqG;
            String str = this.gqF;
            if (!z || TextUtils.isEmpty(str)) {
                context.aoX();
                context.aoU();
                AppMethodBeat.o(13358);
            } else if (TextUtils.isEmpty(context.gqn) || TextUtils.isEmpty(str) || context.gqn.equalsIgnoreCase(str)) {
                context.gqn = str;
                context.ai(context.gqn, w.gvL);
                AppMethodBeat.o(13358);
            } else {
                context.aoX();
                h.a(context, context.getString(R.string.c8o), "", new AnonymousClass4(str), new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.i(13352);
                        g.RP().Ry().set(208905, Boolean.TRUE);
                        BindGoogleContactUI.this.finish();
                        AppMethodBeat.o(13352);
                    }
                });
                AppMethodBeat.o(13358);
            }
        }

        public a(String str) {
            this.gqE = str;
        }

        /* Access modifiers changed, original: protected|final */
        public final void onPreExecute() {
            AppMethodBeat.i(13356);
            super.onPreExecute();
            ab.i("MicroMsg.GoogleContact.BindGoogleContactUI", "onPreExecute");
            this.gqG = false;
            AppMethodBeat.o(13356);
        }

        private Void aoY() {
            AppMethodBeat.i(13357);
            ab.i("MicroMsg.GoogleContact.BindGoogleContactUI", "doInBackground");
            try {
                String str = "";
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL("https://www.googleapis.com/oauth2/v1/userinfo?access_token=".concat(String.valueOf(this.gqE))).openConnection();
                httpURLConnection.setRequestProperty("Charset", "UTF-8");
                httpURLConnection.setRequestMethod("GET");
                httpURLConnection.setConnectTimeout(i.sHCENCODEVIDEOTIMEOUT);
                httpURLConnection.setReadTimeout(i.sHCENCODEVIDEOTIMEOUT);
                int responseCode = httpURLConnection.getResponseCode();
                ab.e("MicroMsg.GoogleContact.BindGoogleContactUI", "responseCode:".concat(String.valueOf(responseCode)));
                if (200 == responseCode) {
                    StringBuffer stringBuffer = new StringBuffer();
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream(), "UTF-8"));
                    while (true) {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        stringBuffer.append(readLine);
                    }
                    bufferedReader.close();
                    str = stringBuffer.toString();
                    ab.i("MicroMsg.GoogleContact.BindGoogleContactUI", "get EmailAccount respone:%s", str);
                }
                httpURLConnection.disconnect();
                this.gqF = new JSONObject(str).optString(Scopes.EMAIL);
                if (!TextUtils.isEmpty(this.gqF)) {
                    this.gqG = true;
                }
            } catch (MalformedURLException e) {
                ab.e("MicroMsg.GoogleContact.BindGoogleContactUI", "MalformedURLException:%s", e.getMessage());
            } catch (ProtocolException e2) {
                ab.e("MicroMsg.GoogleContact.BindGoogleContactUI", "ProtocolException:%s", e2.getMessage());
            } catch (UnsupportedEncodingException e3) {
                ab.e("MicroMsg.GoogleContact.BindGoogleContactUI", "UnsupportedEncodingException:%s", e3.getMessage());
            } catch (IOException e4) {
                ab.e("MicroMsg.GoogleContact.BindGoogleContactUI", "IOException:%s", e4.getMessage());
            } catch (JSONException e5) {
                ab.printErrStackTrace("MicroMsg.GoogleContact.BindGoogleContactUI", e5, "", new Object[0]);
            }
            AppMethodBeat.o(13357);
            return null;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static /* synthetic */ void a(BindGoogleContactUI bindGoogleContactUI, String str, int i) {
        AppMethodBeat.i(13383);
        bindGoogleContactUI.ai(str, i);
        AppMethodBeat.o(13383);
    }

    static /* synthetic */ void c(BindGoogleContactUI bindGoogleContactUI) {
        AppMethodBeat.i(13381);
        bindGoogleContactUI.aoX();
        AppMethodBeat.o(13381);
    }

    static /* synthetic */ void d(BindGoogleContactUI bindGoogleContactUI) {
        AppMethodBeat.i(13385);
        bindGoogleContactUI.aoV();
        AppMethodBeat.o(13385);
    }

    static /* synthetic */ void e(BindGoogleContactUI bindGoogleContactUI) {
        AppMethodBeat.i(13386);
        bindGoogleContactUI.aoT();
        AppMethodBeat.o(13386);
    }

    public final int getLayoutId() {
        return R.layout.gd;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(13364);
        super.onCreate(bundle);
        this.gqq = getIntent().getIntExtra("enter_scene", 0);
        this.gqB = getIntent().getBooleanExtra("KEnterFromBanner", false);
        this.gql = m.cx(this);
        this.gqn = (String) g.RP().Ry().get(208903, null);
        initView();
        if (this.gql) {
            startActivityForResult(new Intent("com.tencent.mm.gms.CHECK_GP_SERVICES"), 1005);
            AppMethodBeat.o(13364);
            return;
        }
        cu();
        AppMethodBeat.o(13364);
    }

    private void cu() {
        AppMethodBeat.i(13365);
        if (this.gql) {
            aoQ();
            aoW();
            aoS();
            AppMethodBeat.o(13365);
            return;
        }
        aoR();
        aoT();
        AppMethodBeat.o(13365);
    }

    public void onResume() {
        AppMethodBeat.i(13366);
        super.onResume();
        g.Rg().a(487, (f) this);
        this.gqw = ((Boolean) g.RP().Ry().get(208905, Boolean.FALSE)).booleanValue();
        if (this.gqw) {
            aoV();
            this.gqw = false;
            g.RP().Ry().set(208905, Boolean.FALSE);
        }
        AppMethodBeat.o(13366);
    }

    public void onPause() {
        AppMethodBeat.i(13367);
        super.onPause();
        g.Rg().b(487, (f) this);
        AppMethodBeat.o(13367);
    }

    public final void initView() {
        AppMethodBeat.i(13368);
        setMMTitle((int) R.string.c8g);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(13347);
                BindGoogleContactUI.this.finish();
                AppMethodBeat.o(13347);
                return true;
            }
        });
        this.fow = com.tencent.mm.ui.widget.MMWebView.a.n(this, R.id.a5i);
        this.gqv = (TextView) findViewById(R.id.a5j);
        AppMethodBeat.o(13368);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(13369);
        ab.i("MicroMsg.GoogleContact.BindGoogleContactUI", "requestCode:%d, resultCode:%d", Integer.valueOf(i), Integer.valueOf(i2));
        if (i2 == -1) {
            switch (i) {
                case 1003:
                    ab.i("MicroMsg.GoogleContact.BindGoogleContactUI", "errorCode:%d ", Integer.valueOf(intent.getIntExtra(NativeProtocol.BRIDGE_ARG_ERROR_CODE, -1)));
                    if (intent.getIntExtra(NativeProtocol.BRIDGE_ARG_ERROR_CODE, -1) == 0) {
                        this.gqn = intent.getStringExtra("account");
                        if (this.eVT) {
                            aoX();
                            AppMethodBeat.o(13369);
                            return;
                        }
                        ab.d("MicroMsg.GoogleContact.BindGoogleContactUI", "startAcitivtyForGetToken");
                        Intent intent2 = new Intent("com.tencent.mm.gms.ACTION_GET_TOKEN");
                        intent2.putExtra("gmail", this.gqn);
                        intent2.putExtra("scope", "oauth2:https://www.googleapis.com/auth/userinfo.email https://www.google.com/m8/feeds");
                        startActivityForResult(intent2, 1004);
                        AppMethodBeat.o(13369);
                        return;
                    }
                    aoX();
                    aoU();
                    AppMethodBeat.o(13369);
                    return;
                case 1004:
                    int intExtra = intent.getIntExtra(NativeProtocol.BRIDGE_ARG_ERROR_CODE, -1);
                    String stringExtra = intent.getStringExtra("error_msg");
                    ab.i("MicroMsg.GoogleContact.BindGoogleContactUI", "errorCode:%d errorMsg:%s", Integer.valueOf(intExtra), stringExtra);
                    if (intExtra != 0) {
                        aoX();
                        aoU();
                        break;
                    }
                    this.gqx = intent.getStringExtra("token");
                    mR(w.gvL);
                    AppMethodBeat.o(13369);
                    return;
                case 1005:
                    this.gql = intent.getBooleanExtra("gpservices", false);
                    cu();
                    AppMethodBeat.o(13369);
                    return;
            }
            AppMethodBeat.o(13369);
        } else if (i == 1005) {
            this.gql = intent.getBooleanExtra("gpservices", false);
            cu();
            AppMethodBeat.o(13369);
        } else {
            aoX();
            aoU();
            AppMethodBeat.o(13369);
        }
    }

    public void onSceneEnd(int i, int i2, String str, com.tencent.mm.ai.m mVar) {
        AppMethodBeat.i(13370);
        String str2 = "MicroMsg.GoogleContact.BindGoogleContactUI";
        String str3 = "[onSceneEnd] errType:%d,errCode:%d,errMsg:%s";
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Integer.valueOf(i2);
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        objArr[2] = str;
        ab.i(str2, str3, objArr);
        aoX();
        if (i == 0 && i2 == 0) {
            if (this.gql) {
                g.RP().Ry().set(208903, this.gqn);
                g.RP().Ry().set(208901, this.gqx);
            } else {
                g.RP().Ry().set(208903, this.gqn);
                g.RP().Ry().set(208902, this.gqy);
                g.RP().Ry().set(208904, this.gqz);
            }
            g.RP().Ry().dsb();
            Intent intent = new Intent(this, GoogleFriendUI.class);
            intent.putExtra("enter_scene", this.gqq);
            startActivity(intent);
            finish();
            if (this.gqB) {
                com.tencent.mm.plugin.report.service.h.pYm.e(TXCStreamUploader.TXE_UPLOAD_INFO_PUSH_BEGIN, Integer.valueOf(6), Integer.valueOf(6));
            }
            AppMethodBeat.o(13370);
        } else if (i2 == w.gvN) {
            h.a((Context) this, getString(R.string.c8n), "", new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(13353);
                    BindGoogleContactUI.a(BindGoogleContactUI.this, w.gvM);
                    AppMethodBeat.o(13353);
                }
            }, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(13354);
                    BindGoogleContactUI.d(BindGoogleContactUI.this);
                    BindGoogleContactUI.e(BindGoogleContactUI.this);
                    AppMethodBeat.o(13354);
                }
            });
            AppMethodBeat.o(13370);
        } else {
            aoU();
            AppMethodBeat.o(13370);
        }
    }

    private void aoQ() {
        AppMethodBeat.i(13371);
        this.fow.setVisibility(8);
        AppMethodBeat.o(13371);
    }

    private void aoR() {
        AppMethodBeat.i(13372);
        this.gqv.setVisibility(4);
        this.fow.setVisibility(0);
        AppMethodBeat.o(13372);
    }

    private void aoS() {
        AppMethodBeat.i(13373);
        startActivityForResult(new Intent("com.tencent.mm.gms.ACTION_CHOOSE_ACCOUNT"), 1003);
        AppMethodBeat.o(13373);
    }

    private void aoT() {
        AppMethodBeat.i(13374);
        aoW();
        this.fow.getSettings().setJavaScriptEnabled(true);
        this.fow.setWebViewClient(new s() {
            public final void b(WebView webView, String str) {
                AppMethodBeat.i(13348);
                ab.d("MicroMsg.GoogleContact.BindGoogleContactUI", "onPageFinished URL:".concat(String.valueOf(str)));
                if (!(BindGoogleContactUI.this.fow == null || BindGoogleContactUI.this.fow.getVisibility() == 0)) {
                    BindGoogleContactUI.this.fow.setVisibility(0);
                    if (BindGoogleContactUI.this.gqv != null) {
                        BindGoogleContactUI.this.gqv.setVisibility(4);
                    }
                }
                BindGoogleContactUI.c(BindGoogleContactUI.this);
                if (webView != null) {
                    String title = webView.getTitle();
                    ab.d("MicroMsg.GoogleContact.BindGoogleContactUI", "title:%s", title);
                    if (!TextUtils.isEmpty(title)) {
                        if (title.toLowerCase().contains("success")) {
                            if (BindGoogleContactUI.this.fow != null) {
                                BindGoogleContactUI.this.fow.setVisibility(4);
                            }
                            u.a(BindGoogleContactUI.this.fow, "weixin://private/googlegetcode", "document.getElementById('code').value");
                            AppMethodBeat.o(13348);
                            return;
                        } else if (title.toLowerCase().contains("error")) {
                            ab.w("MicroMsg.GoogleContact.BindGoogleContactUI", "failed." + title.substring(title.indexOf("=")));
                        }
                    }
                }
                AppMethodBeat.o(13348);
            }

            public final boolean a(WebView webView, String str) {
                AppMethodBeat.i(13349);
                ab.d("MicroMsg.GoogleContact.BindGoogleContactUI", "shouldOverrideUrlLoading, url = %s", str);
                if (str.toLowerCase().startsWith("weixin://private/googlegetcode")) {
                    BindGoogleContactUI.a(BindGoogleContactUI.this, str);
                    AppMethodBeat.o(13349);
                    return true;
                }
                boolean a = super.a(webView, str);
                AppMethodBeat.o(13349);
                return a;
            }
        });
        this.fow.setWebChromeClient(new l() {
            public final boolean onConsoleMessage(ConsoleMessage consoleMessage) {
                AppMethodBeat.i(13350);
                String akn = u.akn(consoleMessage != null ? consoleMessage.message() : null);
                if (akn.toLowerCase().startsWith("weixin://private/googlegetcode")) {
                    BindGoogleContactUI.a(BindGoogleContactUI.this, akn);
                    AppMethodBeat.o(13350);
                    return true;
                }
                boolean onConsoleMessage = super.onConsoleMessage(consoleMessage);
                AppMethodBeat.o(13350);
                return onConsoleMessage;
            }
        });
        this.fow.loadUrl(m.aqc());
        AppMethodBeat.o(13374);
    }

    private void mR(int i) {
        AppMethodBeat.i(13375);
        this.gqA = new w(com.tencent.mm.plugin.account.friend.a.w.a.MM_BIND_GCONTACT_OPCODE_BIND, this.gqn, i);
        g.Rg().a(this.gqA, 0);
        ab.i("MicroMsg.GoogleContact.BindGoogleContactUI", "doScene mAppToken:%s, mWebToke:%s", this.gqx, this.gqy);
        AppMethodBeat.o(13375);
    }

    /* Access modifiers changed, original: final */
    public final void ai(String str, int i) {
        AppMethodBeat.i(13376);
        this.gqn = str;
        mR(i);
        AppMethodBeat.o(13376);
    }

    /* Access modifiers changed, original: final */
    public final void aoU() {
        CharSequence string;
        AppMethodBeat.i(13377);
        if (this.fow != null) {
            this.fow.setVisibility(4);
        }
        if (this.gqv != null) {
            this.gqv.setVisibility(0);
        }
        if (at.isConnected(this)) {
            string = getString(R.string.c8h);
        } else {
            string = getString(R.string.c8p);
        }
        this.gqv.setText(string);
        AppMethodBeat.o(13377);
    }

    private void aoV() {
        AppMethodBeat.i(13378);
        try {
            c.jx(this);
            com.tencent.xweb.b.dTR().removeAllCookie();
            AppMethodBeat.o(13378);
        } catch (Exception e) {
            ab.d("Google Login", "Clear cookie failed");
            AppMethodBeat.o(13378);
        }
    }

    private void aoW() {
        AppMethodBeat.i(13379);
        if (this.gqo == null || !this.gqo.isShowing()) {
            getString(R.string.tz);
            this.gqo = h.b((Context) this, getString(R.string.un), true, new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                    AppMethodBeat.i(13355);
                    BindGoogleContactUI.this.eVT = true;
                    if (BindGoogleContactUI.this.gqA != null) {
                        g.Rg().c(BindGoogleContactUI.this.gqA);
                    }
                    AppMethodBeat.o(13355);
                }
            });
        }
        AppMethodBeat.o(13379);
    }

    /* Access modifiers changed, original: final */
    public final void aoX() {
        AppMethodBeat.i(13380);
        if (this.gqo != null && this.gqo.isShowing()) {
            this.gqo.dismiss();
        }
        AppMethodBeat.o(13380);
    }
}
