package com.tencent.p177mm.plugin.account.bind.p271ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.database.Cursor;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.facebook.share.internal.ShareConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.hardcoder.C1625i;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p182ah.C17884o;
import com.tencent.p177mm.p182ah.C41732d.C8915a;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p264n.C7486a;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C30379h.C30382d;
import com.tencent.p177mm.p612ui.tools.C5601o;
import com.tencent.p177mm.p612ui.tools.C5601o.C5600b;
import com.tencent.p177mm.plugin.account.bind.p271ui.C42278a.C1980a;
import com.tencent.p177mm.plugin.account.friend.p272a.C38035m;
import com.tencent.p177mm.plugin.account.friend.p272a.C38036o;
import com.tencent.p177mm.plugin.account.friend.p272a.C45498n;
import com.tencent.p177mm.plugin.account.friend.p272a.C9875ae;
import com.tencent.p177mm.plugin.account.friend.p272a.C9876af;
import com.tencent.p177mm.plugin.account.friend.p273ui.InviteFriendUI;
import com.tencent.p177mm.plugin.account.p765a.C24679a;
import com.tencent.p177mm.plugin.account.p765a.p766a.C7599a;
import com.tencent.p177mm.plugin.appbrand.jsapi.p313p.C27059f;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.pluginsdk.model.C46498m;
import com.tencent.p177mm.pluginsdk.p597ui.applet.C14916a;
import com.tencent.p177mm.pluginsdk.p597ui.applet.C14916a.C14917a;
import com.tencent.p177mm.protocal.protobuf.ayl;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5023at;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7616ad;
import com.tencent.rtmp.TXLiveConstants;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.xwalk.core.XWalkUpdater;

/* renamed from: com.tencent.mm.plugin.account.bind.ui.GoogleFriendUI */
public class GoogleFriendUI extends MMActivity implements OnItemClickListener, C8915a, C1202f, C1980a {
    private String gqI;
    private boolean gql = false;
    private String gqn;
    private ProgressDialog gqo;
    private int gqq;
    private TextView gqv;
    private ListView gti;
    private C42278a gtj;
    private String gtk;
    private String gtl;
    private C9876af gtm;
    private ArrayList<C45498n> gtn = new ArrayList();
    private HashMap<String, C45498n> gto = new HashMap();
    /* renamed from: xH */
    private boolean f17175xH = false;

    /* renamed from: com.tencent.mm.plugin.account.bind.ui.GoogleFriendUI$b */
    class C1971b extends AsyncTask<Void, Void, Void> {
        private String gtl;
        private C9865a gtx;
        private Context mContext;

        /* synthetic */ C1971b(GoogleFriendUI googleFriendUI, Context context, String str, byte b) {
            this(context, str);
        }

        /* Access modifiers changed, original: protected|final|synthetic */
        public final /* synthetic */ Object doInBackground(Object[] objArr) {
            AppMethodBeat.m2504i(13663);
            Void aoY = aoY();
            AppMethodBeat.m2505o(13663);
            return aoY;
        }

        /* Access modifiers changed, original: protected|final|synthetic */
        public final /* synthetic */ void onPostExecute(Object obj) {
            AppMethodBeat.m2504i(13662);
            super.onPostExecute((Void) obj);
            C4990ab.m7416i("MicroMsg.GoogleContact.GoogleAPIAsyncTask", "onPostExecute");
            if (this.gtx != C9865a.SUCCESS) {
                GoogleFriendUI.m74734a(GoogleFriendUI.this, this.gtx, null);
                AppMethodBeat.m2505o(13662);
            } else if (GoogleFriendUI.this.gtn == null || GoogleFriendUI.this.gtn.size() <= 0) {
                GoogleFriendUI.m74734a(GoogleFriendUI.this, C9865a.NO_CONTACT, null);
                AppMethodBeat.m2505o(13662);
            } else {
                GoogleFriendUI.m74734a(GoogleFriendUI.this, C9865a.SUCCESS, GoogleFriendUI.this.gtn);
                AppMethodBeat.m2505o(13662);
            }
        }

        private C1971b(Context context, String str) {
            this.gtx = C9865a.OTHER;
            this.mContext = context;
            this.gtl = str;
        }

        /* Access modifiers changed, original: protected|final */
        public final void onPreExecute() {
            AppMethodBeat.m2504i(13658);
            super.onPreExecute();
            C4990ab.m7416i("MicroMsg.GoogleContact.GoogleAPIAsyncTask", "onPreExecute");
            GoogleFriendUI.this.gtn.clear();
            GoogleFriendUI.this.gto.clear();
            AppMethodBeat.m2505o(13658);
        }

        private Void aoY() {
            AppMethodBeat.m2504i(13659);
            C4990ab.m7416i("MicroMsg.GoogleContact.GoogleAPIAsyncTask", "doInBackground");
            int i = 0;
            int i2 = 1;
            while (true) {
                try {
                    String A;
                    Object obj;
                    C4990ab.m7417i("MicroMsg.GoogleContact.GoogleAPIAsyncTask", "startInde:%d, totalCount:%d", Integer.valueOf(i2), Integer.valueOf(i));
                    C4990ab.m7417i("MicroMsg.GoogleContact.GoogleAPIAsyncTask", "requestURL:%s", new URL("https://www.google.com/m8/feeds/contacts/default/property-email?alt=" + "json" + "&max-results=100&start-index=" + i2 + "&access_token=" + this.gtl).toString());
                    HttpURLConnection httpURLConnection = (HttpURLConnection) r6.openConnection();
                    httpURLConnection.setRequestMethod("GET");
                    httpURLConnection.setConnectTimeout(C1625i.sHCENCODEVIDEOTIMEOUT);
                    int responseCode = httpURLConnection.getResponseCode();
                    C4990ab.m7417i("MicroMsg.GoogleContact.GoogleAPIAsyncTask", "responseCode:%d", Integer.valueOf(responseCode));
                    if (responseCode == 200) {
                        InputStream inputStream = httpURLConnection.getInputStream();
                        A = C1971b.m4177A(inputStream);
                        inputStream.close();
                    } else {
                        if (responseCode == 401) {
                            C4990ab.m7412e("MicroMsg.GoogleContact.GoogleAPIAsyncTask", "Server OAuth Error,Please Try Again.");
                        } else {
                            C4990ab.m7412e("MicroMsg.GoogleContact.GoogleAPIAsyncTask", "Unknow Error.");
                        }
                        httpURLConnection.disconnect();
                        A = null;
                    }
                    responseCode = new JSONObject(A).getJSONObject("feed").getJSONObject("openSearch$totalResults").getInt("$t");
                    if (responseCode > 0) {
                        m4178vP(A);
                    }
                    if (responseCode - i2 > 100) {
                        i2 += 100;
                        obj = 1;
                    } else {
                        obj = null;
                    }
                    if (obj == null || GoogleFriendUI.this.f17175xH) {
                        this.gtx = C9865a.SUCCESS;
                    } else {
                        i = responseCode;
                    }
                } catch (IOException e) {
                    this.gtx = C9865a.ACCESS_DEDY;
                    C4990ab.m7412e("MicroMsg.GoogleContact.GoogleAPIAsyncTask", "IOException" + e.getMessage());
                } catch (JSONException e2) {
                    this.gtx = C9865a.OTHER;
                    C4990ab.m7412e("MicroMsg.GoogleContact.GoogleAPIAsyncTask", "JSONException" + e2.getMessage());
                }
            }
            this.gtx = C9865a.SUCCESS;
            AppMethodBeat.m2505o(13659);
            return null;
        }

        /* renamed from: A */
        private static String m4177A(InputStream inputStream) {
            AppMethodBeat.m2504i(13660);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[20480];
            while (true) {
                int read = inputStream.read(bArr, 0, 20480);
                if (read != -1) {
                    byteArrayOutputStream.write(bArr, 0, read);
                } else {
                    String str = new String(byteArrayOutputStream.toByteArray(), "UTF-8");
                    AppMethodBeat.m2505o(13660);
                    return str;
                }
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:42:0x0130  */
        /* JADX WARNING: Removed duplicated region for block: B:11:0x0072  */
        /* JADX WARNING: Removed duplicated region for block: B:13:0x007c  */
        /* JADX WARNING: Removed duplicated region for block: B:45:0x0128 A:{SYNTHETIC} */
        /* JADX WARNING: Removed duplicated region for block: B:26:0x00bd  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        /* renamed from: vP */
        private void m4178vP(String str) {
            AppMethodBeat.m2504i(13661);
            JSONArray jSONArray = new JSONObject(str).getJSONObject("feed").getJSONArray("entry");
            if (jSONArray != null) {
                for (int i = 0; i < jSONArray.length(); i++) {
                    String string;
                    String str2 = "";
                    String str3 = "";
                    String str4 = "";
                    JSONObject optJSONObject = jSONArray.getJSONObject(i).optJSONObject("id");
                    JSONObject optJSONObject2 = jSONArray.getJSONObject(i).optJSONObject("title");
                    JSONArray optJSONArray = jSONArray.getJSONObject(i).optJSONArray("gd$email");
                    JSONArray optJSONArray2 = jSONArray.getJSONObject(i).optJSONArray("link");
                    if (optJSONObject != null) {
                        string = optJSONObject.getString("$t");
                        int lastIndexOf = string.lastIndexOf("/");
                        if (lastIndexOf > 0) {
                            String string2;
                            string = string.substring(lastIndexOf + 1);
                            if (optJSONObject2 == null) {
                                str2 = optJSONObject2.getString("$t");
                            } else {
                                str2 = str3;
                            }
                            if (optJSONArray2 != null) {
                                for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                                    string2 = optJSONArray2.getJSONObject(i2).getString("rel");
                                    lastIndexOf = string2.lastIndexOf("#");
                                    if (lastIndexOf > 0) {
                                        string2 = string2.substring(lastIndexOf + 1);
                                        if (!TextUtils.isEmpty(string2) && "photo".equals(string2)) {
                                            str4 = optJSONArray2.getJSONObject(i2).getString(ShareConstants.WEB_DIALOG_PARAM_HREF);
                                        }
                                    }
                                }
                            }
                            str3 = str4;
                            if (optJSONArray == null) {
                                for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                                    string2 = optJSONArray.getJSONObject(i3).getString("address");
                                    if (!(TextUtils.isEmpty(string2) || !C5046bo.amW(string2) || string2.equals(GoogleFriendUI.this.gqn))) {
                                        C45498n c45498n = new C45498n();
                                        c45498n.field_googleid = string;
                                        c45498n.field_googleitemid = string + string2;
                                        c45498n.field_googlename = str2;
                                        c45498n.field_googlephotourl = str3;
                                        c45498n.field_googlegmail = string2;
                                        if (!GoogleFriendUI.this.gto.containsKey(string2)) {
                                            GoogleFriendUI.this.gtn.add(c45498n);
                                            GoogleFriendUI.this.gto.put(string2, c45498n);
                                        }
                                    }
                                }
                            }
                        }
                    }
                    string = str2;
                    if (optJSONObject2 == null) {
                    }
                    if (optJSONArray2 != null) {
                    }
                    str3 = str4;
                    if (optJSONArray == null) {
                    }
                }
            }
            AppMethodBeat.m2505o(13661);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.bind.ui.GoogleFriendUI$c */
    class C1972c extends AsyncTask<Void, Void, Void> {
        private String gqE;
        private boolean gqG;
        private String gqI;

        /* Access modifiers changed, original: protected|final|synthetic */
        public final /* synthetic */ Object doInBackground(Object[] objArr) {
            AppMethodBeat.m2504i(13667);
            Void aoY = aoY();
            AppMethodBeat.m2505o(13667);
            return aoY;
        }

        /* Access modifiers changed, original: protected|final|synthetic */
        public final /* synthetic */ void onPostExecute(Object obj) {
            AppMethodBeat.m2504i(13666);
            super.onPostExecute((Void) obj);
            C4990ab.m7416i("MicroMsg.GoogleContact.GoogleFriendUI", "onPostExecute");
            GoogleFriendUI.m74736a(GoogleFriendUI.this, this.gqG, this.gqE);
            AppMethodBeat.m2505o(13666);
        }

        public C1972c(String str) {
            this.gqI = str;
        }

        /* Access modifiers changed, original: protected|final */
        public final void onPreExecute() {
            AppMethodBeat.m2504i(13664);
            super.onPreExecute();
            C4990ab.m7416i("MicroMsg.GoogleContact.GoogleFriendUI", "onPreExecute");
            this.gqG = false;
            AppMethodBeat.m2505o(13664);
        }

        private Void aoY() {
            AppMethodBeat.m2504i(13665);
            C4990ab.m7416i("MicroMsg.GoogleContact.GoogleFriendUI", "doInBackground");
            try {
                String str = "";
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL("https://accounts.google.com/o/oauth2/token").openConnection();
                httpURLConnection.setRequestProperty("Charset", "UTF-8");
                httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setConnectTimeout(C1625i.sHCENCODEVIDEOTIMEOUT);
                httpURLConnection.setReadTimeout(C1625i.sHCENCODEVIDEOTIMEOUT);
                httpURLConnection.setDoInput(true);
                httpURLConnection.setDoOutput(true);
                ArrayList arrayList = new ArrayList();
                arrayList.add(new BasicNameValuePair("refresh_token", this.gqI));
                arrayList.add(new BasicNameValuePair("client_id", "369820936870.apps.googleusercontent.com"));
                arrayList.add(new BasicNameValuePair("client_secret", "wcFhvo-s7wNcmQ9Zjr00H06u"));
                arrayList.add(new BasicNameValuePair("grant_type", "refresh_token"));
                String au = C38035m.m64352au(arrayList);
                C4990ab.m7416i("MicroMsg.GoogleContact.GoogleFriendUI", "QueryString:%s".concat(String.valueOf(au)));
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(httpURLConnection.getOutputStream(), "UTF-8"));
                bufferedWriter.write(au);
                bufferedWriter.flush();
                bufferedWriter.close();
                int responseCode = httpURLConnection.getResponseCode();
                C4990ab.m7412e("MicroMsg.GoogleContact.GoogleFriendUI", "responseCode:".concat(String.valueOf(responseCode)));
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
                    C4990ab.m7416i("MicroMsg.GoogleContact.GoogleFriendUI", "exchange token respone:%s".concat(String.valueOf(str)));
                }
                httpURLConnection.disconnect();
                C4990ab.m7417i("MicroMsg.GoogleContact.GoogleFriendUI", "refresh response:%s", str);
                this.gqE = new JSONObject(str).optString("access_token");
                this.gqG = true;
            } catch (ProtocolException e) {
                C4990ab.m7413e("MicroMsg.GoogleContact.GoogleFriendUI", "ProtocolException:%s", e.getMessage());
            } catch (MalformedURLException e2) {
                C4990ab.m7413e("MicroMsg.GoogleContact.GoogleFriendUI", "MalformedURLException:%s", e2.getMessage());
            } catch (IOException e3) {
                C4990ab.m7413e("MicroMsg.GoogleContact.GoogleFriendUI", "IOException:%s", e3.getMessage());
            } catch (JSONException e4) {
                C4990ab.m7413e("MicroMsg.GoogleContact.GoogleFriendUI", "JSONException:%s", e4.getMessage());
            }
            AppMethodBeat.m2505o(13665);
            return null;
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.bind.ui.GoogleFriendUI$5 */
    class C98645 implements OnCancelListener {
        C98645() {
        }

        public final void onCancel(DialogInterface dialogInterface) {
            AppMethodBeat.m2504i(13654);
            GoogleFriendUI.this.f17175xH = true;
            C1720g.m3540Rg().mo14547c(GoogleFriendUI.this.gtm);
            AppMethodBeat.m2505o(13654);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.bind.ui.GoogleFriendUI$a */
    public enum C9865a {
        SUCCESS,
        NO_CONTACT,
        ACCESS_DEDY,
        OTHER;

        static {
            AppMethodBeat.m2505o(13657);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.bind.ui.GoogleFriendUI$1 */
    class C380261 implements OnMenuItemClickListener {
        C380261() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(13650);
            GoogleFriendUI.this.finish();
            AppMethodBeat.m2505o(13650);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.bind.ui.GoogleFriendUI$3 */
    class C380273 implements C14917a {
        C380273() {
        }

        /* renamed from: a */
        public final void mo5739a(boolean z, boolean z2, String str, String str2) {
            AppMethodBeat.m2504i(13652);
            C4990ab.m7411d("MicroMsg.GoogleContact.GoogleFriendUI", "MicroMsg.AddContact ok:%b hasSentVerify:%b", Boolean.valueOf(z), Boolean.valueOf(z2));
            if (z || z2) {
                C4990ab.m7411d("MicroMsg.GoogleContact.GoogleFriendUI", "gmailItem:%s", str2);
                ((C38036o) ((C7599a) C1720g.m3530M(C7599a.class)).getGoogleFriendStorage()).mo60779aj(str2, 1);
            } else {
                ((C38036o) ((C7599a) C1720g.m3530M(C7599a.class)).getGoogleFriendStorage()).mo60779aj(str2, 2);
            }
            GoogleFriendUI.this.gtj.mo6869KC();
            AppMethodBeat.m2505o(13652);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.bind.ui.GoogleFriendUI$2 */
    class C422752 implements C5600b {
        C422752() {
        }

        /* renamed from: vN */
        public final boolean mo7459vN(String str) {
            return false;
        }

        /* renamed from: vO */
        public final void mo7460vO(String str) {
            AppMethodBeat.m2504i(13651);
            GoogleFriendUI.this.gtk = C5046bo.m7586vA(str);
            if (GoogleFriendUI.this.gtj != null) {
                GoogleFriendUI.this.gtj.mo67801vM(GoogleFriendUI.this.gtk);
            }
            AppMethodBeat.m2505o(13651);
        }

        public final void apo() {
        }

        public final void app() {
        }

        public final void apq() {
        }

        public final void apr() {
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public GoogleFriendUI() {
        AppMethodBeat.m2504i(13668);
        AppMethodBeat.m2505o(13668);
    }

    public final int getLayoutId() {
        return 2130969797;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(13669);
        super.onCreate(bundle);
        this.gqn = (String) C1720g.m3536RP().mo5239Ry().get(208903, null);
        if (TextUtils.isEmpty(this.gqn)) {
            finish();
        }
        this.gqq = getIntent().getIntExtra("enter_scene", 0);
        this.gtj = new C42278a(this, this.gqn);
        this.gtj.gsZ = this;
        initView();
        this.gql = C38035m.m64353cx(this);
        if (this.gql) {
            C4990ab.m7410d("MicroMsg.GoogleContact.GoogleFriendUI", "startActivityCheckGooglePlayServices");
            startActivityForResult(new Intent("com.tencent.mm.gms.CHECK_GP_SERVICES"), TXLiveConstants.PLAY_EVT_PLAY_PROGRESS);
        } else {
            apj();
        }
        ((C38036o) ((C7599a) C1720g.m3530M(C7599a.class)).getGoogleFriendStorage()).clear();
        AppMethodBeat.m2505o(13669);
    }

    public void onResume() {
        AppMethodBeat.m2504i(13670);
        super.onResume();
        C1720g.m3540Rg().mo14539a((int) C27059f.CTRL_INDEX, (C1202f) this);
        C1720g.m3540Rg().mo14539a(489, (C1202f) this);
        C17884o.acd().mo67502d(this);
        if (this.gtj != null) {
            this.gtj.mo6869KC();
        }
        AppMethodBeat.m2505o(13670);
    }

    public void onStop() {
        AppMethodBeat.m2504i(13671);
        super.onStop();
        C1720g.m3540Rg().mo14546b((int) C27059f.CTRL_INDEX, (C1202f) this);
        C1720g.m3540Rg().mo14546b(489, (C1202f) this);
        C17884o.acd().mo67503e(this);
        AppMethodBeat.m2505o(13671);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(13672);
        super.onDestroy();
        ((C38036o) ((C7599a) C1720g.m3530M(C7599a.class)).getGoogleFriendStorage()).clear();
        AppMethodBeat.m2505o(13672);
    }

    public final void initView() {
        AppMethodBeat.m2504i(13673);
        setMMTitle((int) C25738R.string.c8j);
        setBackBtn(new C380261());
        this.gqv = (TextView) findViewById(2131821749);
        this.gti = (ListView) findViewById(2131824661);
        this.gti.setAdapter(this.gtj);
        this.gti.setOnItemClickListener(this);
        C5601o c5601o = new C5601o((byte) 0);
        c5601o.zHa = new C422752();
        mo17380a(c5601o);
        AppMethodBeat.m2505o(13673);
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        AppMethodBeat.m2504i(13674);
        C4990ab.m7411d("MicroMsg.GoogleContact.GoogleFriendUI", "onItemClick position:%d,", Integer.valueOf(i));
        if (this.gtj != null) {
            C45498n c45498n = (C45498n) this.gtj.getItem(i - this.gti.getHeaderViewsCount());
            if (c45498n != null) {
                String str = c45498n.field_username;
                C4990ab.m7411d("MicroMsg.GoogleContact.GoogleFriendUI", "jumpToProfile email:%s, username:%s", c45498n.field_googlegmail, str);
                C7616ad aoO = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(str);
                Intent intent;
                if ((aoO == null || !C7486a.m12942jh(aoO.field_type)) && TextUtils.isEmpty(c45498n.field_nickname)) {
                    intent = new Intent(this, InviteFriendUI.class);
                    intent.putExtra("friend_type", 2);
                    intent.putExtra("friend_user_name", str);
                    intent.putExtra("friend_num", c45498n.field_googlegmail);
                    intent.putExtra("friend_nick", c45498n.field_googlename);
                    intent.putExtra("friend_weixin_nick", c45498n.field_nickname);
                    intent.putExtra("friend_googleID", c45498n.field_googleid);
                    intent.putExtra("friend_googleItemID", c45498n.field_googleitemid);
                    intent.putExtra("friend_scene", 58);
                    intent.putExtra("Contact_Scene", 58);
                    startActivity(intent);
                } else {
                    intent = new Intent();
                    intent.putExtra("Contact_User", str);
                    intent.putExtra("Contact_Nick", c45498n.field_nickname);
                    intent.putExtra("Contact_ShowFMessageList", true);
                    intent.putExtra("verify_gmail", c45498n.field_googlegmail);
                    intent.putExtra("profileName", c45498n.field_googlename);
                    intent.putExtra("Contact_Source_FMessage", 58);
                    intent.putExtra("Contact_Scene", 58);
                    if (str != null && str.length() > 0) {
                        C24679a.gkE.mo38912c(intent, this.mController.ylL);
                    }
                    AppMethodBeat.m2505o(13674);
                    return;
                }
            }
        }
        AppMethodBeat.m2505o(13674);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(13675);
        C4990ab.m7417i("MicroMsg.GoogleContact.GoogleFriendUI", "requestCode:%d, resultCode:%d", Integer.valueOf(i), Integer.valueOf(i2));
        if (i == TXLiveConstants.PLAY_EVT_PLAY_PROGRESS) {
            if (i2 == -1) {
                this.gql = intent.getBooleanExtra("gpservices", false);
                apj();
                AppMethodBeat.m2505o(13675);
                return;
            }
            this.gql = intent.getBooleanExtra("gpservices", false);
            finish();
        }
        AppMethodBeat.m2505o(13675);
    }

    private void apj() {
        AppMethodBeat.m2504i(13676);
        C4990ab.m7410d("MicroMsg.GoogleContact.GoogleFriendUI", "updateToken");
        apk();
        if (TextUtils.isEmpty(this.gtl) || (!this.gql && TextUtils.isEmpty(this.gqI))) {
            mo17383aA(BindGoogleContactUI.class);
            finish();
            AppMethodBeat.m2505o(13676);
            return;
        }
        apl();
        AppMethodBeat.m2505o(13676);
    }

    /* renamed from: mS */
    public final void mo5738mS(int i) {
        AppMethodBeat.m2504i(13677);
        if (this.gtj == null) {
            AppMethodBeat.m2505o(13677);
            return;
        }
        C45498n c45498n = (C45498n) this.gtj.getItem(i);
        if (c45498n == null) {
            AppMethodBeat.m2505o(13677);
            return;
        }
        switch (c45498n.field_status) {
            case 0:
                C14916a c14916a = new C14916a(this, new C380273());
                String str = c45498n.field_googleitemid;
                c14916a.vjO = false;
                c14916a.vjN = true;
                c14916a.gyj = str;
                c14916a.vjO = false;
                LinkedList linkedList = new LinkedList();
                linkedList.add(Integer.valueOf(58));
                c14916a.mo27242b(c45498n.field_username, linkedList, true);
                c45498n.field_googlecgistatus = 0;
                ((C38036o) ((C7599a) C1720g.m3530M(C7599a.class)).getGoogleFriendStorage()).mo60781b(c45498n);
                this.gtj.mo6869KC();
                AppMethodBeat.m2505o(13677);
                return;
            case 1:
                Cursor wg = ((C38036o) ((C7599a) C1720g.m3530M(C7599a.class)).getGoogleFriendStorage()).mo60785wg(c45498n.field_googleid);
                if (wg == null || wg.getCount() <= 1) {
                    m74737a(c45498n, null);
                } else {
                    m74733a(wg, c45498n);
                }
                if (wg != null) {
                    wg.close();
                    break;
                }
                break;
        }
        AppMethodBeat.m2505o(13677);
    }

    public void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(13678);
        String str2 = "MicroMsg.GoogleContact.GoogleFriendUI";
        String str3 = "[onSceneEnd] errType:%d,errCode:%d,errMsg:%s";
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Integer.valueOf(i2);
        objArr[2] = TextUtils.isEmpty(str) ? "" : str;
        C4990ab.m7417i(str2, str3, objArr);
        int type = c1207m.getType();
        if (i != 0 || i2 != 0) {
            switch (type) {
                case 30:
                case 137:
                    if (i2 == -87) {
                        C30379h.m48461b((Context) this, getString(C25738R.string.aui), "", true);
                    } else if ((i2 == -24 || i2 == XWalkUpdater.ERROR_SET_VERNUM) && !C5046bo.isNullOrNil(str)) {
                        Toast.makeText(this, str, 1).show();
                    }
                    if (this.gtj != null) {
                        C4990ab.m7411d("MicroMsg.GoogleContact.GoogleFriendUI", "gmailItem:%s", ((C46498m) c1207m).gwh);
                        ((C38036o) ((C7599a) C1720g.m3530M(C7599a.class)).getGoogleFriendStorage()).mo60779aj(str2, 2);
                        this.gtj.mo6869KC();
                        break;
                    }
                    break;
                case C27059f.CTRL_INDEX /*488*/:
                    m74742dk(false);
                    break;
                case 489:
                    if (this.gtj != null) {
                        C4990ab.m7417i("MicroMsg.GoogleContact.GoogleFriendUI", "count:%d", Integer.valueOf(((C9875ae) c1207m).aqh().jBv));
                        C4990ab.m7411d("MicroMsg.GoogleContact.GoogleFriendUI", "gmailItem:%s", r12.gwh);
                        ((C38036o) ((C7599a) C1720g.m3530M(C7599a.class)).getGoogleFriendStorage()).mo60779aj(str2, 1);
                        this.gtj.mo6869KC();
                        break;
                    }
                    break;
                default:
                    C4990ab.m7420w("MicroMsg.GoogleContact.GoogleFriendUI", "Unknow scene type.");
                    break;
            }
        }
        switch (type) {
            case 30:
            case 137:
                if (this.gtj != null) {
                    C4990ab.m7411d("MicroMsg.GoogleContact.GoogleFriendUI", "gmailItem:%s", ((C46498m) c1207m).gwh);
                    ((C38036o) ((C7599a) C1720g.m3530M(C7599a.class)).getGoogleFriendStorage()).mo60779aj(str2, 1);
                    this.gtj.mo6869KC();
                    break;
                }
                break;
            case C27059f.CTRL_INDEX /*488*/:
                m74738a(((C9876af) c1207m).aqi());
                break;
            case 489:
                if (this.gtj != null) {
                    C4990ab.m7417i("MicroMsg.GoogleContact.GoogleFriendUI", "count:%d", Integer.valueOf(((C9875ae) c1207m).aqh().jBv));
                    C4990ab.m7411d("MicroMsg.GoogleContact.GoogleFriendUI", "gmailItem:%s", r12.gwh);
                    ((C38036o) ((C7599a) C1720g.m3530M(C7599a.class)).getGoogleFriendStorage()).mo60779aj(str2, 1);
                    this.gtj.mo6869KC();
                    break;
                }
                break;
            default:
                C4990ab.m7420w("MicroMsg.GoogleContact.GoogleFriendUI", "Unknow scene type.");
                break;
        }
        aoX();
        AppMethodBeat.m2505o(13678);
    }

    /* renamed from: qj */
    public final void mo20342qj(String str) {
        AppMethodBeat.m2504i(13679);
        if (this.gtj != null) {
            this.gtj.notifyDataSetChanged();
        }
        AppMethodBeat.m2505o(13679);
    }

    public void onBackPressed() {
        AppMethodBeat.m2504i(13680);
        super.onBackPressed();
        AppMethodBeat.m2505o(13680);
    }

    private void apk() {
        AppMethodBeat.m2504i(13681);
        if (this.gql) {
            this.gtl = (String) C1720g.m3536RP().mo5239Ry().get(208901, null);
            AppMethodBeat.m2505o(13681);
            return;
        }
        this.gtl = (String) C1720g.m3536RP().mo5239Ry().get(208902, null);
        this.gqI = (String) C1720g.m3536RP().mo5239Ry().get(208904, null);
        AppMethodBeat.m2505o(13681);
    }

    private void apl() {
        AppMethodBeat.m2504i(13682);
        if (this.gql) {
            apn();
            AppMethodBeat.m2505o(13682);
            return;
        }
        apm();
        AppMethodBeat.m2505o(13682);
    }

    /* renamed from: a */
    private void m74733a(Cursor cursor, final C45498n c45498n) {
        AppMethodBeat.m2504i(13683);
        List arrayList = new ArrayList();
        List arrayList2 = new ArrayList();
        final ArrayList arrayList3 = new ArrayList();
        if (cursor != null) {
            cursor.moveToFirst();
            int count = cursor.getCount();
            for (int i = 0; i < count; i++) {
                C45498n c45498n2 = new C45498n();
                c45498n2.mo8995d(cursor);
                arrayList.add(c45498n2.field_googlegmail);
                arrayList2.add(Integer.valueOf(i));
                arrayList3.add(c45498n2);
                cursor.moveToNext();
            }
            arrayList2.add(Integer.valueOf(-1));
        }
        Context context = this.mController.ylL;
        String string = getResources().getString(C25738R.string.c8q);
        getResources().getString(C25738R.string.f9076or);
        C30379h.m48418a(context, string, arrayList, arrayList2, new C30382d() {
            /* renamed from: bV */
            public final void mo4975bV(int i, int i2) {
                AppMethodBeat.m2504i(13653);
                if (i2 != -1) {
                    GoogleFriendUI.m74735a(GoogleFriendUI.this, (C45498n) arrayList3.get(i2), c45498n);
                }
                AppMethodBeat.m2505o(13653);
            }
        });
        AppMethodBeat.m2505o(13683);
    }

    /* renamed from: a */
    private void m74737a(C45498n c45498n, C45498n c45498n2) {
        AppMethodBeat.m2504i(13684);
        ArrayList arrayList = new ArrayList();
        arrayList.add(c45498n.field_googlegmail);
        C1207m c9875ae = new C9875ae(arrayList);
        C4990ab.m7411d("MicroMsg.GoogleContact.GoogleFriendUI", "gmailItem:%s", c45498n.field_googleitemid);
        C1720g.m3540Rg().mo14541a(c9875ae, 0);
        if (c45498n2 == null) {
            c9875ae.gwh = c45498n.field_googleitemid;
            c45498n.field_googlecgistatus = 0;
            ((C38036o) ((C7599a) C1720g.m3530M(C7599a.class)).getGoogleFriendStorage()).mo60781b(c45498n);
        } else {
            c9875ae.gwh = c45498n2.field_googleitemid;
            c45498n2.field_googlecgistatus = 0;
            ((C38036o) ((C7599a) C1720g.m3530M(C7599a.class)).getGoogleFriendStorage()).mo60781b(c45498n2);
        }
        this.gtj.mo6869KC();
        AppMethodBeat.m2505o(13684);
    }

    private void apm() {
        AppMethodBeat.m2504i(13685);
        aoW();
        new C1972c(this.gqI).execute(new Void[0]);
        AppMethodBeat.m2505o(13685);
    }

    private void apn() {
        AppMethodBeat.m2504i(13686);
        this.f17175xH = false;
        aoW();
        new C1971b(this, this, this.gtl, (byte) 0).execute(new Void[0]);
        AppMethodBeat.m2505o(13686);
    }

    /* renamed from: a */
    private synchronized void m74738a(ayl ayl) {
        AppMethodBeat.m2504i(13687);
        C4990ab.m7417i("MicroMsg.GoogleContact.GoogleFriendUI", "handleListGoogleContactCGIResponse Count:%d", Integer.valueOf(ayl.jBv));
        if (this.gtj != null) {
            this.gtj.mo6869KC();
        }
        AppMethodBeat.m2505o(13687);
    }

    /* renamed from: dk */
    private void m74742dk(boolean z) {
        CharSequence string;
        AppMethodBeat.m2504i(13688);
        this.gqv.setVisibility(0);
        if (!C5023at.isConnected(this)) {
            string = getString(C25738R.string.c8p);
        } else if (z) {
            string = getString(C25738R.string.c8i);
        } else {
            string = getString(C25738R.string.c8h);
        }
        this.gqv.setText(string);
        AppMethodBeat.m2505o(13688);
    }

    private void aoW() {
        AppMethodBeat.m2504i(13689);
        if (this.gqo == null || !this.gqo.isShowing()) {
            getString(C25738R.string.f9238tz);
            this.gqo = C30379h.m48458b((Context) this, getString(C25738R.string.f9260un), true, new C98645());
        }
        AppMethodBeat.m2505o(13689);
    }

    private void aoX() {
        AppMethodBeat.m2504i(13690);
        if (this.gqo != null && this.gqo.isShowing()) {
            this.gqo.dismiss();
        }
        AppMethodBeat.m2505o(13690);
    }
}
