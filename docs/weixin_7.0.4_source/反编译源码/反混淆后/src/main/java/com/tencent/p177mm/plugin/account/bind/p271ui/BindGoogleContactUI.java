package com.tencent.p177mm.plugin.account.bind.p271ui;

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
import com.p802jg.EType;
import com.p802jg.JgClassChecked;
import com.tencent.liteav.network.TXCStreamUploader;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.hardcoder.C1625i;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.widget.MMWebView;
import com.tencent.p177mm.p612ui.widget.MMWebView.C30798a;
import com.tencent.p177mm.plugin.account.friend.p272a.C32968w;
import com.tencent.p177mm.plugin.account.friend.p272a.C32968w.C1993a;
import com.tencent.p177mm.plugin.account.friend.p272a.C38035m;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.pluginsdk.p597ui.tools.C30152u;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5023at;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import com.tencent.xweb.C24526c;
import com.tencent.xweb.C36592s;
import com.tencent.xweb.C44576b;
import com.tencent.xweb.C6031l;
import com.tencent.xweb.WebView;
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
/* renamed from: com.tencent.mm.plugin.account.bind.ui.BindGoogleContactUI */
public class BindGoogleContactUI extends MMActivity implements C1202f {
    private boolean eVT = false;
    private MMWebView fow;
    private C32968w gqA;
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
    class C98284 implements OnClickListener {
        final /* synthetic */ String gqD;

        C98284(String str) {
            this.gqD = str;
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(13351);
            BindGoogleContactUI.m74687a(BindGoogleContactUI.this, this.gqD, C32968w.gvL);
            AppMethodBeat.m2505o(13351);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.bind.ui.BindGoogleContactUI$7 */
    class C98297 implements OnClickListener {
        C98297() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(13354);
            BindGoogleContactUI.m74691d(BindGoogleContactUI.this);
            BindGoogleContactUI.m74692e(BindGoogleContactUI.this);
            AppMethodBeat.m2505o(13354);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.bind.ui.BindGoogleContactUI$6 */
    class C187996 implements OnClickListener {
        C187996() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(13353);
            BindGoogleContactUI.m74685a(BindGoogleContactUI.this, C32968w.gvM);
            AppMethodBeat.m2505o(13353);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.bind.ui.BindGoogleContactUI$b */
    class C18800b extends AsyncTask<Void, Void, Void> {
        private boolean cxT;
        private String gqE;
        private String gqH;
        private String gqI;

        /* Access modifiers changed, original: protected|final|synthetic */
        public final /* synthetic */ Object doInBackground(Object[] objArr) {
            AppMethodBeat.m2504i(13363);
            Void aoY = aoY();
            AppMethodBeat.m2505o(13363);
            return aoY;
        }

        /* Access modifiers changed, original: protected|final|synthetic */
        public final /* synthetic */ void onPostExecute(Object obj) {
            AppMethodBeat.m2504i(13362);
            super.onPostExecute((Void) obj);
            C4990ab.m7416i("MicroMsg.GoogleContact.BindGoogleContactUI", "onPostExecute");
            BindGoogleContactUI bindGoogleContactUI = BindGoogleContactUI.this;
            boolean z = this.cxT;
            String str = this.gqE;
            String str2 = this.gqI;
            if (!z || TextUtils.isEmpty(str)) {
                bindGoogleContactUI.aoX();
                bindGoogleContactUI.aoU();
                AppMethodBeat.m2505o(13362);
                return;
            }
            bindGoogleContactUI.gqy = str;
            bindGoogleContactUI.gqz = str2;
            new C32936a(bindGoogleContactUI.gqy).execute(new Void[0]);
            AppMethodBeat.m2505o(13362);
        }

        public C18800b(String str) {
            this.gqH = str;
        }

        /* Access modifiers changed, original: protected|final */
        public final void onPreExecute() {
            AppMethodBeat.m2504i(13360);
            super.onPreExecute();
            C4990ab.m7416i("MicroMsg.GoogleContact.BindGoogleContactUI", "onPreExecute");
            this.gqE = "";
            this.gqI = "";
            this.cxT = false;
            AppMethodBeat.m2505o(13360);
        }

        private Void aoY() {
            AppMethodBeat.m2504i(13361);
            try {
                String str = this.gqH;
                String str2 = "";
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL("https://accounts.google.com/o/oauth2/token").openConnection();
                httpURLConnection.setRequestProperty("Charset", "UTF-8");
                httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setConnectTimeout(C1625i.sHCENCODEVIDEOTIMEOUT);
                httpURLConnection.setReadTimeout(C1625i.sHCENCODEVIDEOTIMEOUT);
                httpURLConnection.setDoInput(true);
                httpURLConnection.setDoOutput(true);
                ArrayList arrayList = new ArrayList();
                arrayList.add(new BasicNameValuePair(TMQQDownloaderOpenSDKConst.UINTYPE_CODE, str));
                arrayList.add(new BasicNameValuePair("client_id", "369820936870.apps.googleusercontent.com"));
                arrayList.add(new BasicNameValuePair("client_secret", "wcFhvo-s7wNcmQ9Zjr00H06u"));
                arrayList.add(new BasicNameValuePair(ServerProtocol.DIALOG_PARAM_REDIRECT_URI, "urn:ietf:wg:oauth:2.0:oob"));
                arrayList.add(new BasicNameValuePair("grant_type", "authorization_code"));
                str = C38035m.m64352au(arrayList);
                C4990ab.m7417i("MicroMsg.GoogleContact.BindGoogleContactUI", "QueryString:%s", str);
                httpURLConnection.setRequestProperty("Content-length", String.valueOf(str.getBytes().length));
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(httpURLConnection.getOutputStream(), "UTF-8"));
                bufferedWriter.write(str);
                bufferedWriter.flush();
                bufferedWriter.close();
                int responseCode = httpURLConnection.getResponseCode();
                C4990ab.m7412e("MicroMsg.GoogleContact.BindGoogleContactUI", "responseCode:".concat(String.valueOf(responseCode)));
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
                    C4990ab.m7417i("MicroMsg.GoogleContact.BindGoogleContactUI", "exchange token respone:%s", str2);
                }
                httpURLConnection.disconnect();
                this.gqE = new JSONObject(str2).optString("access_token");
                this.gqI = new JSONObject(str2).optString("refresh_token");
                C4990ab.m7417i("MicroMsg.GoogleContact.BindGoogleContactUI", "response:%s", str2);
                C4990ab.m7417i("MicroMsg.GoogleContact.BindGoogleContactUI", "mAccessToken:%s", this.gqE);
                C4990ab.m7417i("MicroMsg.GoogleContact.BindGoogleContactUI", "mRefreshToken:%s", this.gqI);
                this.cxT = true;
            } catch (MalformedURLException e) {
                C4990ab.m7412e("MicroMsg.GoogleContact.BindGoogleContactUI", "MalformedURLException:%s" + e.getMessage());
            } catch (ProtocolException e2) {
                C4990ab.m7412e("MicroMsg.GoogleContact.BindGoogleContactUI", "ProtocolException:%s" + e2.getMessage());
            } catch (IOException e3) {
                C4990ab.m7412e("MicroMsg.GoogleContact.BindGoogleContactUI", "IOException:%s" + e3.getMessage());
            } catch (JSONException e4) {
                C4990ab.m7412e("MicroMsg.GoogleContact.BindGoogleContactUI", "JSONException:%s" + e4.getMessage());
            }
            AppMethodBeat.m2505o(13361);
            return null;
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.bind.ui.BindGoogleContactUI$3 */
    class C265483 extends C6031l {
        C265483() {
        }

        public final boolean onConsoleMessage(ConsoleMessage consoleMessage) {
            AppMethodBeat.m2504i(13350);
            String akn = C30152u.akn(consoleMessage != null ? consoleMessage.message() : null);
            if (akn.toLowerCase().startsWith("weixin://private/googlegetcode")) {
                BindGoogleContactUI.m74686a(BindGoogleContactUI.this, akn);
                AppMethodBeat.m2505o(13350);
                return true;
            }
            boolean onConsoleMessage = super.onConsoleMessage(consoleMessage);
            AppMethodBeat.m2505o(13350);
            return onConsoleMessage;
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.bind.ui.BindGoogleContactUI$5 */
    class C265495 implements OnClickListener {
        C265495() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(13352);
            C1720g.m3536RP().mo5239Ry().set(208905, Boolean.TRUE);
            BindGoogleContactUI.this.finish();
            AppMethodBeat.m2505o(13352);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.bind.ui.BindGoogleContactUI$a */
    class C32936a extends AsyncTask<Void, Void, Void> {
        private String gqE;
        private String gqF;
        private boolean gqG;

        /* Access modifiers changed, original: protected|final|synthetic */
        public final /* synthetic */ Object doInBackground(Object[] objArr) {
            AppMethodBeat.m2504i(13359);
            Void aoY = aoY();
            AppMethodBeat.m2505o(13359);
            return aoY;
        }

        /* Access modifiers changed, original: protected|final|synthetic */
        public final /* synthetic */ void onPostExecute(Object obj) {
            AppMethodBeat.m2504i(13358);
            super.onPostExecute((Void) obj);
            C4990ab.m7416i("MicroMsg.GoogleContact.BindGoogleContactUI", "onPostExecute");
            Context context = BindGoogleContactUI.this;
            boolean z = this.gqG;
            String str = this.gqF;
            if (!z || TextUtils.isEmpty(str)) {
                context.aoX();
                context.aoU();
                AppMethodBeat.m2505o(13358);
            } else if (TextUtils.isEmpty(context.gqn) || TextUtils.isEmpty(str) || context.gqn.equalsIgnoreCase(str)) {
                context.gqn = str;
                context.mo67783ai(context.gqn, C32968w.gvL);
                AppMethodBeat.m2505o(13358);
            } else {
                context.aoX();
                C30379h.m48440a(context, context.getString(C25738R.string.c8o), "", new C98284(str), new C265495());
                AppMethodBeat.m2505o(13358);
            }
        }

        public C32936a(String str) {
            this.gqE = str;
        }

        /* Access modifiers changed, original: protected|final */
        public final void onPreExecute() {
            AppMethodBeat.m2504i(13356);
            super.onPreExecute();
            C4990ab.m7416i("MicroMsg.GoogleContact.BindGoogleContactUI", "onPreExecute");
            this.gqG = false;
            AppMethodBeat.m2505o(13356);
        }

        private Void aoY() {
            AppMethodBeat.m2504i(13357);
            C4990ab.m7416i("MicroMsg.GoogleContact.BindGoogleContactUI", "doInBackground");
            try {
                String str = "";
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL("https://www.googleapis.com/oauth2/v1/userinfo?access_token=".concat(String.valueOf(this.gqE))).openConnection();
                httpURLConnection.setRequestProperty("Charset", "UTF-8");
                httpURLConnection.setRequestMethod("GET");
                httpURLConnection.setConnectTimeout(C1625i.sHCENCODEVIDEOTIMEOUT);
                httpURLConnection.setReadTimeout(C1625i.sHCENCODEVIDEOTIMEOUT);
                int responseCode = httpURLConnection.getResponseCode();
                C4990ab.m7412e("MicroMsg.GoogleContact.BindGoogleContactUI", "responseCode:".concat(String.valueOf(responseCode)));
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
                    C4990ab.m7417i("MicroMsg.GoogleContact.BindGoogleContactUI", "get EmailAccount respone:%s", str);
                }
                httpURLConnection.disconnect();
                this.gqF = new JSONObject(str).optString(Scopes.EMAIL);
                if (!TextUtils.isEmpty(this.gqF)) {
                    this.gqG = true;
                }
            } catch (MalformedURLException e) {
                C4990ab.m7413e("MicroMsg.GoogleContact.BindGoogleContactUI", "MalformedURLException:%s", e.getMessage());
            } catch (ProtocolException e2) {
                C4990ab.m7413e("MicroMsg.GoogleContact.BindGoogleContactUI", "ProtocolException:%s", e2.getMessage());
            } catch (UnsupportedEncodingException e3) {
                C4990ab.m7413e("MicroMsg.GoogleContact.BindGoogleContactUI", "UnsupportedEncodingException:%s", e3.getMessage());
            } catch (IOException e4) {
                C4990ab.m7413e("MicroMsg.GoogleContact.BindGoogleContactUI", "IOException:%s", e4.getMessage());
            } catch (JSONException e5) {
                C4990ab.printErrStackTrace("MicroMsg.GoogleContact.BindGoogleContactUI", e5, "", new Object[0]);
            }
            AppMethodBeat.m2505o(13357);
            return null;
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.bind.ui.BindGoogleContactUI$2 */
    class C380192 extends C36592s {
        C380192() {
        }

        /* renamed from: b */
        public final void mo5992b(WebView webView, String str) {
            AppMethodBeat.m2504i(13348);
            C4990ab.m7410d("MicroMsg.GoogleContact.BindGoogleContactUI", "onPageFinished URL:".concat(String.valueOf(str)));
            if (!(BindGoogleContactUI.this.fow == null || BindGoogleContactUI.this.fow.getVisibility() == 0)) {
                BindGoogleContactUI.this.fow.setVisibility(0);
                if (BindGoogleContactUI.this.gqv != null) {
                    BindGoogleContactUI.this.gqv.setVisibility(4);
                }
            }
            BindGoogleContactUI.m74689c(BindGoogleContactUI.this);
            if (webView != null) {
                String title = webView.getTitle();
                C4990ab.m7411d("MicroMsg.GoogleContact.BindGoogleContactUI", "title:%s", title);
                if (!TextUtils.isEmpty(title)) {
                    if (title.toLowerCase().contains("success")) {
                        if (BindGoogleContactUI.this.fow != null) {
                            BindGoogleContactUI.this.fow.setVisibility(4);
                        }
                        C30152u.m47744a(BindGoogleContactUI.this.fow, "weixin://private/googlegetcode", "document.getElementById('code').value");
                        AppMethodBeat.m2505o(13348);
                        return;
                    } else if (title.toLowerCase().contains("error")) {
                        C4990ab.m7420w("MicroMsg.GoogleContact.BindGoogleContactUI", "failed." + title.substring(title.indexOf("=")));
                    }
                }
            }
            AppMethodBeat.m2505o(13348);
        }

        /* renamed from: a */
        public final boolean mo4762a(WebView webView, String str) {
            AppMethodBeat.m2504i(13349);
            C4990ab.m7411d("MicroMsg.GoogleContact.BindGoogleContactUI", "shouldOverrideUrlLoading, url = %s", str);
            if (str.toLowerCase().startsWith("weixin://private/googlegetcode")) {
                BindGoogleContactUI.m74686a(BindGoogleContactUI.this, str);
                AppMethodBeat.m2505o(13349);
                return true;
            }
            boolean a = super.mo4762a(webView, str);
            AppMethodBeat.m2505o(13349);
            return a;
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.bind.ui.BindGoogleContactUI$1 */
    class C422631 implements OnMenuItemClickListener {
        C422631() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(13347);
            BindGoogleContactUI.this.finish();
            AppMethodBeat.m2505o(13347);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.bind.ui.BindGoogleContactUI$8 */
    class C422648 implements OnCancelListener {
        C422648() {
        }

        public final void onCancel(DialogInterface dialogInterface) {
            AppMethodBeat.m2504i(13355);
            BindGoogleContactUI.this.eVT = true;
            if (BindGoogleContactUI.this.gqA != null) {
                C1720g.m3540Rg().mo14547c(BindGoogleContactUI.this.gqA);
            }
            AppMethodBeat.m2505o(13355);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    /* renamed from: a */
    static /* synthetic */ void m74687a(BindGoogleContactUI bindGoogleContactUI, String str, int i) {
        AppMethodBeat.m2504i(13383);
        bindGoogleContactUI.mo67783ai(str, i);
        AppMethodBeat.m2505o(13383);
    }

    /* renamed from: c */
    static /* synthetic */ void m74689c(BindGoogleContactUI bindGoogleContactUI) {
        AppMethodBeat.m2504i(13381);
        bindGoogleContactUI.aoX();
        AppMethodBeat.m2505o(13381);
    }

    /* renamed from: d */
    static /* synthetic */ void m74691d(BindGoogleContactUI bindGoogleContactUI) {
        AppMethodBeat.m2504i(13385);
        bindGoogleContactUI.aoV();
        AppMethodBeat.m2505o(13385);
    }

    /* renamed from: e */
    static /* synthetic */ void m74692e(BindGoogleContactUI bindGoogleContactUI) {
        AppMethodBeat.m2504i(13386);
        bindGoogleContactUI.aoT();
        AppMethodBeat.m2505o(13386);
    }

    public final int getLayoutId() {
        return 2130968838;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(13364);
        super.onCreate(bundle);
        this.gqq = getIntent().getIntExtra("enter_scene", 0);
        this.gqB = getIntent().getBooleanExtra("KEnterFromBanner", false);
        this.gql = C38035m.m64353cx(this);
        this.gqn = (String) C1720g.m3536RP().mo5239Ry().get(208903, null);
        initView();
        if (this.gql) {
            startActivityForResult(new Intent("com.tencent.mm.gms.CHECK_GP_SERVICES"), 1005);
            AppMethodBeat.m2505o(13364);
            return;
        }
        m74690cu();
        AppMethodBeat.m2505o(13364);
    }

    /* renamed from: cu */
    private void m74690cu() {
        AppMethodBeat.m2504i(13365);
        if (this.gql) {
            aoQ();
            aoW();
            aoS();
            AppMethodBeat.m2505o(13365);
            return;
        }
        aoR();
        aoT();
        AppMethodBeat.m2505o(13365);
    }

    public void onResume() {
        AppMethodBeat.m2504i(13366);
        super.onResume();
        C1720g.m3540Rg().mo14539a(487, (C1202f) this);
        this.gqw = ((Boolean) C1720g.m3536RP().mo5239Ry().get(208905, Boolean.FALSE)).booleanValue();
        if (this.gqw) {
            aoV();
            this.gqw = false;
            C1720g.m3536RP().mo5239Ry().set(208905, Boolean.FALSE);
        }
        AppMethodBeat.m2505o(13366);
    }

    public void onPause() {
        AppMethodBeat.m2504i(13367);
        super.onPause();
        C1720g.m3540Rg().mo14546b(487, (C1202f) this);
        AppMethodBeat.m2505o(13367);
    }

    public final void initView() {
        AppMethodBeat.m2504i(13368);
        setMMTitle((int) C25738R.string.c8g);
        setBackBtn(new C422631());
        this.fow = C30798a.m49146n(this, 2131821748);
        this.gqv = (TextView) findViewById(2131821749);
        AppMethodBeat.m2505o(13368);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(13369);
        C4990ab.m7417i("MicroMsg.GoogleContact.BindGoogleContactUI", "requestCode:%d, resultCode:%d", Integer.valueOf(i), Integer.valueOf(i2));
        if (i2 == -1) {
            switch (i) {
                case 1003:
                    C4990ab.m7417i("MicroMsg.GoogleContact.BindGoogleContactUI", "errorCode:%d ", Integer.valueOf(intent.getIntExtra(NativeProtocol.BRIDGE_ARG_ERROR_CODE, -1)));
                    if (intent.getIntExtra(NativeProtocol.BRIDGE_ARG_ERROR_CODE, -1) == 0) {
                        this.gqn = intent.getStringExtra("account");
                        if (this.eVT) {
                            aoX();
                            AppMethodBeat.m2505o(13369);
                            return;
                        }
                        C4990ab.m7410d("MicroMsg.GoogleContact.BindGoogleContactUI", "startAcitivtyForGetToken");
                        Intent intent2 = new Intent("com.tencent.mm.gms.ACTION_GET_TOKEN");
                        intent2.putExtra("gmail", this.gqn);
                        intent2.putExtra("scope", "oauth2:https://www.googleapis.com/auth/userinfo.email https://www.google.com/m8/feeds");
                        startActivityForResult(intent2, 1004);
                        AppMethodBeat.m2505o(13369);
                        return;
                    }
                    aoX();
                    aoU();
                    AppMethodBeat.m2505o(13369);
                    return;
                case 1004:
                    int intExtra = intent.getIntExtra(NativeProtocol.BRIDGE_ARG_ERROR_CODE, -1);
                    String stringExtra = intent.getStringExtra("error_msg");
                    C4990ab.m7417i("MicroMsg.GoogleContact.BindGoogleContactUI", "errorCode:%d errorMsg:%s", Integer.valueOf(intExtra), stringExtra);
                    if (intExtra != 0) {
                        aoX();
                        aoU();
                        break;
                    }
                    this.gqx = intent.getStringExtra("token");
                    m74695mR(C32968w.gvL);
                    AppMethodBeat.m2505o(13369);
                    return;
                case 1005:
                    this.gql = intent.getBooleanExtra("gpservices", false);
                    m74690cu();
                    AppMethodBeat.m2505o(13369);
                    return;
            }
            AppMethodBeat.m2505o(13369);
        } else if (i == 1005) {
            this.gql = intent.getBooleanExtra("gpservices", false);
            m74690cu();
            AppMethodBeat.m2505o(13369);
        } else {
            aoX();
            aoU();
            AppMethodBeat.m2505o(13369);
        }
    }

    public void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(13370);
        String str2 = "MicroMsg.GoogleContact.BindGoogleContactUI";
        String str3 = "[onSceneEnd] errType:%d,errCode:%d,errMsg:%s";
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Integer.valueOf(i2);
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        objArr[2] = str;
        C4990ab.m7417i(str2, str3, objArr);
        aoX();
        if (i == 0 && i2 == 0) {
            if (this.gql) {
                C1720g.m3536RP().mo5239Ry().set(208903, this.gqn);
                C1720g.m3536RP().mo5239Ry().set(208901, this.gqx);
            } else {
                C1720g.m3536RP().mo5239Ry().set(208903, this.gqn);
                C1720g.m3536RP().mo5239Ry().set(208902, this.gqy);
                C1720g.m3536RP().mo5239Ry().set(208904, this.gqz);
            }
            C1720g.m3536RP().mo5239Ry().dsb();
            Intent intent = new Intent(this, GoogleFriendUI.class);
            intent.putExtra("enter_scene", this.gqq);
            startActivity(intent);
            finish();
            if (this.gqB) {
                C7060h.pYm.mo8381e(TXCStreamUploader.TXE_UPLOAD_INFO_PUSH_BEGIN, Integer.valueOf(6), Integer.valueOf(6));
            }
            AppMethodBeat.m2505o(13370);
        } else if (i2 == C32968w.gvN) {
            C30379h.m48440a((Context) this, getString(C25738R.string.c8n), "", new C187996(), new C98297());
            AppMethodBeat.m2505o(13370);
        } else {
            aoU();
            AppMethodBeat.m2505o(13370);
        }
    }

    private void aoQ() {
        AppMethodBeat.m2504i(13371);
        this.fow.setVisibility(8);
        AppMethodBeat.m2505o(13371);
    }

    private void aoR() {
        AppMethodBeat.m2504i(13372);
        this.gqv.setVisibility(4);
        this.fow.setVisibility(0);
        AppMethodBeat.m2505o(13372);
    }

    private void aoS() {
        AppMethodBeat.m2504i(13373);
        startActivityForResult(new Intent("com.tencent.mm.gms.ACTION_CHOOSE_ACCOUNT"), 1003);
        AppMethodBeat.m2505o(13373);
    }

    private void aoT() {
        AppMethodBeat.m2504i(13374);
        aoW();
        this.fow.getSettings().setJavaScriptEnabled(true);
        this.fow.setWebViewClient(new C380192());
        this.fow.setWebChromeClient(new C265483());
        this.fow.loadUrl(C38035m.aqc());
        AppMethodBeat.m2505o(13374);
    }

    /* renamed from: mR */
    private void m74695mR(int i) {
        AppMethodBeat.m2504i(13375);
        this.gqA = new C32968w(C1993a.MM_BIND_GCONTACT_OPCODE_BIND, this.gqn, i);
        C1720g.m3540Rg().mo14541a(this.gqA, 0);
        C4990ab.m7417i("MicroMsg.GoogleContact.BindGoogleContactUI", "doScene mAppToken:%s, mWebToke:%s", this.gqx, this.gqy);
        AppMethodBeat.m2505o(13375);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: ai */
    public final void mo67783ai(String str, int i) {
        AppMethodBeat.m2504i(13376);
        this.gqn = str;
        m74695mR(i);
        AppMethodBeat.m2505o(13376);
    }

    /* Access modifiers changed, original: final */
    public final void aoU() {
        CharSequence string;
        AppMethodBeat.m2504i(13377);
        if (this.fow != null) {
            this.fow.setVisibility(4);
        }
        if (this.gqv != null) {
            this.gqv.setVisibility(0);
        }
        if (C5023at.isConnected(this)) {
            string = getString(C25738R.string.c8h);
        } else {
            string = getString(C25738R.string.c8p);
        }
        this.gqv.setText(string);
        AppMethodBeat.m2505o(13377);
    }

    private void aoV() {
        AppMethodBeat.m2504i(13378);
        try {
            C24526c.m38159jx(this);
            C44576b.dTR().removeAllCookie();
            AppMethodBeat.m2505o(13378);
        } catch (Exception e) {
            C4990ab.m7410d("Google Login", "Clear cookie failed");
            AppMethodBeat.m2505o(13378);
        }
    }

    private void aoW() {
        AppMethodBeat.m2504i(13379);
        if (this.gqo == null || !this.gqo.isShowing()) {
            getString(C25738R.string.f9238tz);
            this.gqo = C30379h.m48458b((Context) this, getString(C25738R.string.f9260un), true, new C422648());
        }
        AppMethodBeat.m2505o(13379);
    }

    /* Access modifiers changed, original: final */
    public final void aoX() {
        AppMethodBeat.m2504i(13380);
        if (this.gqo != null && this.gqo.isShowing()) {
            this.gqo.dismiss();
        }
        AppMethodBeat.m2505o(13380);
    }
}
