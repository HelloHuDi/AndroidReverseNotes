package com.tencent.mm.plugin.account.bind.ui;

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
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.hardcoder.i;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.friend.a.ae;
import com.tencent.mm.plugin.account.friend.a.af;
import com.tencent.mm.plugin.account.friend.a.m;
import com.tencent.mm.plugin.account.friend.a.n;
import com.tencent.mm.plugin.account.friend.a.o;
import com.tencent.mm.plugin.account.friend.ui.InviteFriendUI;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.protocal.protobuf.ayl;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.h.d;
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

public class GoogleFriendUI extends MMActivity implements OnItemClickListener, com.tencent.mm.ah.d.a, f, a {
    private String gqI;
    private boolean gql = false;
    private String gqn;
    private ProgressDialog gqo;
    private int gqq;
    private TextView gqv;
    private ListView gti;
    private a gtj;
    private String gtk;
    private String gtl;
    private af gtm;
    private ArrayList<n> gtn = new ArrayList();
    private HashMap<String, n> gto = new HashMap();
    private boolean xH = false;

    class b extends AsyncTask<Void, Void, Void> {
        private String gtl;
        private a gtx;
        private Context mContext;

        /* synthetic */ b(GoogleFriendUI googleFriendUI, Context context, String str, byte b) {
            this(context, str);
        }

        /* Access modifiers changed, original: protected|final|synthetic */
        public final /* synthetic */ Object doInBackground(Object[] objArr) {
            AppMethodBeat.i(13663);
            Void aoY = aoY();
            AppMethodBeat.o(13663);
            return aoY;
        }

        /* Access modifiers changed, original: protected|final|synthetic */
        public final /* synthetic */ void onPostExecute(Object obj) {
            AppMethodBeat.i(13662);
            super.onPostExecute((Void) obj);
            ab.i("MicroMsg.GoogleContact.GoogleAPIAsyncTask", "onPostExecute");
            if (this.gtx != a.SUCCESS) {
                GoogleFriendUI.a(GoogleFriendUI.this, this.gtx, null);
                AppMethodBeat.o(13662);
            } else if (GoogleFriendUI.this.gtn == null || GoogleFriendUI.this.gtn.size() <= 0) {
                GoogleFriendUI.a(GoogleFriendUI.this, a.NO_CONTACT, null);
                AppMethodBeat.o(13662);
            } else {
                GoogleFriendUI.a(GoogleFriendUI.this, a.SUCCESS, GoogleFriendUI.this.gtn);
                AppMethodBeat.o(13662);
            }
        }

        private b(Context context, String str) {
            this.gtx = a.OTHER;
            this.mContext = context;
            this.gtl = str;
        }

        /* Access modifiers changed, original: protected|final */
        public final void onPreExecute() {
            AppMethodBeat.i(13658);
            super.onPreExecute();
            ab.i("MicroMsg.GoogleContact.GoogleAPIAsyncTask", "onPreExecute");
            GoogleFriendUI.this.gtn.clear();
            GoogleFriendUI.this.gto.clear();
            AppMethodBeat.o(13658);
        }

        private Void aoY() {
            AppMethodBeat.i(13659);
            ab.i("MicroMsg.GoogleContact.GoogleAPIAsyncTask", "doInBackground");
            int i = 0;
            int i2 = 1;
            while (true) {
                try {
                    String A;
                    Object obj;
                    ab.i("MicroMsg.GoogleContact.GoogleAPIAsyncTask", "startInde:%d, totalCount:%d", Integer.valueOf(i2), Integer.valueOf(i));
                    ab.i("MicroMsg.GoogleContact.GoogleAPIAsyncTask", "requestURL:%s", new URL("https://www.google.com/m8/feeds/contacts/default/property-email?alt=" + "json" + "&max-results=100&start-index=" + i2 + "&access_token=" + this.gtl).toString());
                    HttpURLConnection httpURLConnection = (HttpURLConnection) r6.openConnection();
                    httpURLConnection.setRequestMethod("GET");
                    httpURLConnection.setConnectTimeout(i.sHCENCODEVIDEOTIMEOUT);
                    int responseCode = httpURLConnection.getResponseCode();
                    ab.i("MicroMsg.GoogleContact.GoogleAPIAsyncTask", "responseCode:%d", Integer.valueOf(responseCode));
                    if (responseCode == 200) {
                        InputStream inputStream = httpURLConnection.getInputStream();
                        A = A(inputStream);
                        inputStream.close();
                    } else {
                        if (responseCode == 401) {
                            ab.e("MicroMsg.GoogleContact.GoogleAPIAsyncTask", "Server OAuth Error,Please Try Again.");
                        } else {
                            ab.e("MicroMsg.GoogleContact.GoogleAPIAsyncTask", "Unknow Error.");
                        }
                        httpURLConnection.disconnect();
                        A = null;
                    }
                    responseCode = new JSONObject(A).getJSONObject("feed").getJSONObject("openSearch$totalResults").getInt("$t");
                    if (responseCode > 0) {
                        vP(A);
                    }
                    if (responseCode - i2 > 100) {
                        i2 += 100;
                        obj = 1;
                    } else {
                        obj = null;
                    }
                    if (obj == null || GoogleFriendUI.this.xH) {
                        this.gtx = a.SUCCESS;
                    } else {
                        i = responseCode;
                    }
                } catch (IOException e) {
                    this.gtx = a.ACCESS_DEDY;
                    ab.e("MicroMsg.GoogleContact.GoogleAPIAsyncTask", "IOException" + e.getMessage());
                } catch (JSONException e2) {
                    this.gtx = a.OTHER;
                    ab.e("MicroMsg.GoogleContact.GoogleAPIAsyncTask", "JSONException" + e2.getMessage());
                }
            }
            this.gtx = a.SUCCESS;
            AppMethodBeat.o(13659);
            return null;
        }

        private static String A(InputStream inputStream) {
            AppMethodBeat.i(13660);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[20480];
            while (true) {
                int read = inputStream.read(bArr, 0, 20480);
                if (read != -1) {
                    byteArrayOutputStream.write(bArr, 0, read);
                } else {
                    String str = new String(byteArrayOutputStream.toByteArray(), "UTF-8");
                    AppMethodBeat.o(13660);
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
        private void vP(String str) {
            AppMethodBeat.i(13661);
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
                                    if (!(TextUtils.isEmpty(string2) || !bo.amW(string2) || string2.equals(GoogleFriendUI.this.gqn))) {
                                        n nVar = new n();
                                        nVar.field_googleid = string;
                                        nVar.field_googleitemid = string + string2;
                                        nVar.field_googlename = str2;
                                        nVar.field_googlephotourl = str3;
                                        nVar.field_googlegmail = string2;
                                        if (!GoogleFriendUI.this.gto.containsKey(string2)) {
                                            GoogleFriendUI.this.gtn.add(nVar);
                                            GoogleFriendUI.this.gto.put(string2, nVar);
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
            AppMethodBeat.o(13661);
        }
    }

    class c extends AsyncTask<Void, Void, Void> {
        private String gqE;
        private boolean gqG;
        private String gqI;

        /* Access modifiers changed, original: protected|final|synthetic */
        public final /* synthetic */ Object doInBackground(Object[] objArr) {
            AppMethodBeat.i(13667);
            Void aoY = aoY();
            AppMethodBeat.o(13667);
            return aoY;
        }

        /* Access modifiers changed, original: protected|final|synthetic */
        public final /* synthetic */ void onPostExecute(Object obj) {
            AppMethodBeat.i(13666);
            super.onPostExecute((Void) obj);
            ab.i("MicroMsg.GoogleContact.GoogleFriendUI", "onPostExecute");
            GoogleFriendUI.a(GoogleFriendUI.this, this.gqG, this.gqE);
            AppMethodBeat.o(13666);
        }

        public c(String str) {
            this.gqI = str;
        }

        /* Access modifiers changed, original: protected|final */
        public final void onPreExecute() {
            AppMethodBeat.i(13664);
            super.onPreExecute();
            ab.i("MicroMsg.GoogleContact.GoogleFriendUI", "onPreExecute");
            this.gqG = false;
            AppMethodBeat.o(13664);
        }

        private Void aoY() {
            AppMethodBeat.i(13665);
            ab.i("MicroMsg.GoogleContact.GoogleFriendUI", "doInBackground");
            try {
                String str = "";
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL("https://accounts.google.com/o/oauth2/token").openConnection();
                httpURLConnection.setRequestProperty("Charset", "UTF-8");
                httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setConnectTimeout(i.sHCENCODEVIDEOTIMEOUT);
                httpURLConnection.setReadTimeout(i.sHCENCODEVIDEOTIMEOUT);
                httpURLConnection.setDoInput(true);
                httpURLConnection.setDoOutput(true);
                ArrayList arrayList = new ArrayList();
                arrayList.add(new BasicNameValuePair("refresh_token", this.gqI));
                arrayList.add(new BasicNameValuePair("client_id", "369820936870.apps.googleusercontent.com"));
                arrayList.add(new BasicNameValuePair("client_secret", "wcFhvo-s7wNcmQ9Zjr00H06u"));
                arrayList.add(new BasicNameValuePair("grant_type", "refresh_token"));
                String au = m.au(arrayList);
                ab.i("MicroMsg.GoogleContact.GoogleFriendUI", "QueryString:%s".concat(String.valueOf(au)));
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(httpURLConnection.getOutputStream(), "UTF-8"));
                bufferedWriter.write(au);
                bufferedWriter.flush();
                bufferedWriter.close();
                int responseCode = httpURLConnection.getResponseCode();
                ab.e("MicroMsg.GoogleContact.GoogleFriendUI", "responseCode:".concat(String.valueOf(responseCode)));
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
                    ab.i("MicroMsg.GoogleContact.GoogleFriendUI", "exchange token respone:%s".concat(String.valueOf(str)));
                }
                httpURLConnection.disconnect();
                ab.i("MicroMsg.GoogleContact.GoogleFriendUI", "refresh response:%s", str);
                this.gqE = new JSONObject(str).optString("access_token");
                this.gqG = true;
            } catch (ProtocolException e) {
                ab.e("MicroMsg.GoogleContact.GoogleFriendUI", "ProtocolException:%s", e.getMessage());
            } catch (MalformedURLException e2) {
                ab.e("MicroMsg.GoogleContact.GoogleFriendUI", "MalformedURLException:%s", e2.getMessage());
            } catch (IOException e3) {
                ab.e("MicroMsg.GoogleContact.GoogleFriendUI", "IOException:%s", e3.getMessage());
            } catch (JSONException e4) {
                ab.e("MicroMsg.GoogleContact.GoogleFriendUI", "JSONException:%s", e4.getMessage());
            }
            AppMethodBeat.o(13665);
            return null;
        }
    }

    public enum a {
        SUCCESS,
        NO_CONTACT,
        ACCESS_DEDY,
        OTHER;

        static {
            AppMethodBeat.o(13657);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public GoogleFriendUI() {
        AppMethodBeat.i(13668);
        AppMethodBeat.o(13668);
    }

    public final int getLayoutId() {
        return R.layout.a67;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(13669);
        super.onCreate(bundle);
        this.gqn = (String) g.RP().Ry().get(208903, null);
        if (TextUtils.isEmpty(this.gqn)) {
            finish();
        }
        this.gqq = getIntent().getIntExtra("enter_scene", 0);
        this.gtj = new a(this, this.gqn);
        this.gtj.gsZ = this;
        initView();
        this.gql = m.cx(this);
        if (this.gql) {
            ab.d("MicroMsg.GoogleContact.GoogleFriendUI", "startActivityCheckGooglePlayServices");
            startActivityForResult(new Intent("com.tencent.mm.gms.CHECK_GP_SERVICES"), TXLiveConstants.PLAY_EVT_PLAY_PROGRESS);
        } else {
            apj();
        }
        ((o) ((com.tencent.mm.plugin.account.a.a.a) g.M(com.tencent.mm.plugin.account.a.a.a.class)).getGoogleFriendStorage()).clear();
        AppMethodBeat.o(13669);
    }

    public void onResume() {
        AppMethodBeat.i(13670);
        super.onResume();
        g.Rg().a((int) com.tencent.mm.plugin.appbrand.jsapi.p.f.CTRL_INDEX, (f) this);
        g.Rg().a(489, (f) this);
        com.tencent.mm.ah.o.acd().d(this);
        if (this.gtj != null) {
            this.gtj.KC();
        }
        AppMethodBeat.o(13670);
    }

    public void onStop() {
        AppMethodBeat.i(13671);
        super.onStop();
        g.Rg().b((int) com.tencent.mm.plugin.appbrand.jsapi.p.f.CTRL_INDEX, (f) this);
        g.Rg().b(489, (f) this);
        com.tencent.mm.ah.o.acd().e(this);
        AppMethodBeat.o(13671);
    }

    public void onDestroy() {
        AppMethodBeat.i(13672);
        super.onDestroy();
        ((o) ((com.tencent.mm.plugin.account.a.a.a) g.M(com.tencent.mm.plugin.account.a.a.a.class)).getGoogleFriendStorage()).clear();
        AppMethodBeat.o(13672);
    }

    public final void initView() {
        AppMethodBeat.i(13673);
        setMMTitle((int) R.string.c8j);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(13650);
                GoogleFriendUI.this.finish();
                AppMethodBeat.o(13650);
                return true;
            }
        });
        this.gqv = (TextView) findViewById(R.id.a5j);
        this.gti = (ListView) findViewById(R.id.c__);
        this.gti.setAdapter(this.gtj);
        this.gti.setOnItemClickListener(this);
        com.tencent.mm.ui.tools.o oVar = new com.tencent.mm.ui.tools.o((byte) 0);
        oVar.zHa = new com.tencent.mm.ui.tools.o.b() {
            public final boolean vN(String str) {
                return false;
            }

            public final void vO(String str) {
                AppMethodBeat.i(13651);
                GoogleFriendUI.this.gtk = bo.vA(str);
                if (GoogleFriendUI.this.gtj != null) {
                    GoogleFriendUI.this.gtj.vM(GoogleFriendUI.this.gtk);
                }
                AppMethodBeat.o(13651);
            }

            public final void apo() {
            }

            public final void app() {
            }

            public final void apq() {
            }

            public final void apr() {
            }
        };
        a(oVar);
        AppMethodBeat.o(13673);
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        AppMethodBeat.i(13674);
        ab.d("MicroMsg.GoogleContact.GoogleFriendUI", "onItemClick position:%d,", Integer.valueOf(i));
        if (this.gtj != null) {
            n nVar = (n) this.gtj.getItem(i - this.gti.getHeaderViewsCount());
            if (nVar != null) {
                String str = nVar.field_username;
                ab.d("MicroMsg.GoogleContact.GoogleFriendUI", "jumpToProfile email:%s, username:%s", nVar.field_googlegmail, str);
                ad aoO = ((j) g.K(j.class)).XM().aoO(str);
                Intent intent;
                if ((aoO == null || !com.tencent.mm.n.a.jh(aoO.field_type)) && TextUtils.isEmpty(nVar.field_nickname)) {
                    intent = new Intent(this, InviteFriendUI.class);
                    intent.putExtra("friend_type", 2);
                    intent.putExtra("friend_user_name", str);
                    intent.putExtra("friend_num", nVar.field_googlegmail);
                    intent.putExtra("friend_nick", nVar.field_googlename);
                    intent.putExtra("friend_weixin_nick", nVar.field_nickname);
                    intent.putExtra("friend_googleID", nVar.field_googleid);
                    intent.putExtra("friend_googleItemID", nVar.field_googleitemid);
                    intent.putExtra("friend_scene", 58);
                    intent.putExtra("Contact_Scene", 58);
                    startActivity(intent);
                } else {
                    intent = new Intent();
                    intent.putExtra("Contact_User", str);
                    intent.putExtra("Contact_Nick", nVar.field_nickname);
                    intent.putExtra("Contact_ShowFMessageList", true);
                    intent.putExtra("verify_gmail", nVar.field_googlegmail);
                    intent.putExtra("profileName", nVar.field_googlename);
                    intent.putExtra("Contact_Source_FMessage", 58);
                    intent.putExtra("Contact_Scene", 58);
                    if (str != null && str.length() > 0) {
                        com.tencent.mm.plugin.account.a.a.gkE.c(intent, this.mController.ylL);
                    }
                    AppMethodBeat.o(13674);
                    return;
                }
            }
        }
        AppMethodBeat.o(13674);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(13675);
        ab.i("MicroMsg.GoogleContact.GoogleFriendUI", "requestCode:%d, resultCode:%d", Integer.valueOf(i), Integer.valueOf(i2));
        if (i == TXLiveConstants.PLAY_EVT_PLAY_PROGRESS) {
            if (i2 == -1) {
                this.gql = intent.getBooleanExtra("gpservices", false);
                apj();
                AppMethodBeat.o(13675);
                return;
            }
            this.gql = intent.getBooleanExtra("gpservices", false);
            finish();
        }
        AppMethodBeat.o(13675);
    }

    private void apj() {
        AppMethodBeat.i(13676);
        ab.d("MicroMsg.GoogleContact.GoogleFriendUI", "updateToken");
        apk();
        if (TextUtils.isEmpty(this.gtl) || (!this.gql && TextUtils.isEmpty(this.gqI))) {
            aA(BindGoogleContactUI.class);
            finish();
            AppMethodBeat.o(13676);
            return;
        }
        apl();
        AppMethodBeat.o(13676);
    }

    public final void mS(int i) {
        AppMethodBeat.i(13677);
        if (this.gtj == null) {
            AppMethodBeat.o(13677);
            return;
        }
        n nVar = (n) this.gtj.getItem(i);
        if (nVar == null) {
            AppMethodBeat.o(13677);
            return;
        }
        switch (nVar.field_status) {
            case 0:
                com.tencent.mm.pluginsdk.ui.applet.a aVar = new com.tencent.mm.pluginsdk.ui.applet.a(this, new com.tencent.mm.pluginsdk.ui.applet.a.a() {
                    public final void a(boolean z, boolean z2, String str, String str2) {
                        AppMethodBeat.i(13652);
                        ab.d("MicroMsg.GoogleContact.GoogleFriendUI", "MicroMsg.AddContact ok:%b hasSentVerify:%b", Boolean.valueOf(z), Boolean.valueOf(z2));
                        if (z || z2) {
                            ab.d("MicroMsg.GoogleContact.GoogleFriendUI", "gmailItem:%s", str2);
                            ((o) ((com.tencent.mm.plugin.account.a.a.a) g.M(com.tencent.mm.plugin.account.a.a.a.class)).getGoogleFriendStorage()).aj(str2, 1);
                        } else {
                            ((o) ((com.tencent.mm.plugin.account.a.a.a) g.M(com.tencent.mm.plugin.account.a.a.a.class)).getGoogleFriendStorage()).aj(str2, 2);
                        }
                        GoogleFriendUI.this.gtj.KC();
                        AppMethodBeat.o(13652);
                    }
                });
                String str = nVar.field_googleitemid;
                aVar.vjO = false;
                aVar.vjN = true;
                aVar.gyj = str;
                aVar.vjO = false;
                LinkedList linkedList = new LinkedList();
                linkedList.add(Integer.valueOf(58));
                aVar.b(nVar.field_username, linkedList, true);
                nVar.field_googlecgistatus = 0;
                ((o) ((com.tencent.mm.plugin.account.a.a.a) g.M(com.tencent.mm.plugin.account.a.a.a.class)).getGoogleFriendStorage()).b(nVar);
                this.gtj.KC();
                AppMethodBeat.o(13677);
                return;
            case 1:
                Cursor wg = ((o) ((com.tencent.mm.plugin.account.a.a.a) g.M(com.tencent.mm.plugin.account.a.a.a.class)).getGoogleFriendStorage()).wg(nVar.field_googleid);
                if (wg == null || wg.getCount() <= 1) {
                    a(nVar, null);
                } else {
                    a(wg, nVar);
                }
                if (wg != null) {
                    wg.close();
                    break;
                }
                break;
        }
        AppMethodBeat.o(13677);
    }

    public void onSceneEnd(int i, int i2, String str, com.tencent.mm.ai.m mVar) {
        AppMethodBeat.i(13678);
        String str2 = "MicroMsg.GoogleContact.GoogleFriendUI";
        String str3 = "[onSceneEnd] errType:%d,errCode:%d,errMsg:%s";
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Integer.valueOf(i2);
        objArr[2] = TextUtils.isEmpty(str) ? "" : str;
        ab.i(str2, str3, objArr);
        int type = mVar.getType();
        if (i != 0 || i2 != 0) {
            switch (type) {
                case 30:
                case 137:
                    if (i2 == -87) {
                        h.b((Context) this, getString(R.string.aui), "", true);
                    } else if ((i2 == -24 || i2 == XWalkUpdater.ERROR_SET_VERNUM) && !bo.isNullOrNil(str)) {
                        Toast.makeText(this, str, 1).show();
                    }
                    if (this.gtj != null) {
                        ab.d("MicroMsg.GoogleContact.GoogleFriendUI", "gmailItem:%s", ((com.tencent.mm.pluginsdk.model.m) mVar).gwh);
                        ((o) ((com.tencent.mm.plugin.account.a.a.a) g.M(com.tencent.mm.plugin.account.a.a.a.class)).getGoogleFriendStorage()).aj(str2, 2);
                        this.gtj.KC();
                        break;
                    }
                    break;
                case com.tencent.mm.plugin.appbrand.jsapi.p.f.CTRL_INDEX /*488*/:
                    dk(false);
                    break;
                case 489:
                    if (this.gtj != null) {
                        ab.i("MicroMsg.GoogleContact.GoogleFriendUI", "count:%d", Integer.valueOf(((ae) mVar).aqh().jBv));
                        ab.d("MicroMsg.GoogleContact.GoogleFriendUI", "gmailItem:%s", r12.gwh);
                        ((o) ((com.tencent.mm.plugin.account.a.a.a) g.M(com.tencent.mm.plugin.account.a.a.a.class)).getGoogleFriendStorage()).aj(str2, 1);
                        this.gtj.KC();
                        break;
                    }
                    break;
                default:
                    ab.w("MicroMsg.GoogleContact.GoogleFriendUI", "Unknow scene type.");
                    break;
            }
        }
        switch (type) {
            case 30:
            case 137:
                if (this.gtj != null) {
                    ab.d("MicroMsg.GoogleContact.GoogleFriendUI", "gmailItem:%s", ((com.tencent.mm.pluginsdk.model.m) mVar).gwh);
                    ((o) ((com.tencent.mm.plugin.account.a.a.a) g.M(com.tencent.mm.plugin.account.a.a.a.class)).getGoogleFriendStorage()).aj(str2, 1);
                    this.gtj.KC();
                    break;
                }
                break;
            case com.tencent.mm.plugin.appbrand.jsapi.p.f.CTRL_INDEX /*488*/:
                a(((af) mVar).aqi());
                break;
            case 489:
                if (this.gtj != null) {
                    ab.i("MicroMsg.GoogleContact.GoogleFriendUI", "count:%d", Integer.valueOf(((ae) mVar).aqh().jBv));
                    ab.d("MicroMsg.GoogleContact.GoogleFriendUI", "gmailItem:%s", r12.gwh);
                    ((o) ((com.tencent.mm.plugin.account.a.a.a) g.M(com.tencent.mm.plugin.account.a.a.a.class)).getGoogleFriendStorage()).aj(str2, 1);
                    this.gtj.KC();
                    break;
                }
                break;
            default:
                ab.w("MicroMsg.GoogleContact.GoogleFriendUI", "Unknow scene type.");
                break;
        }
        aoX();
        AppMethodBeat.o(13678);
    }

    public final void qj(String str) {
        AppMethodBeat.i(13679);
        if (this.gtj != null) {
            this.gtj.notifyDataSetChanged();
        }
        AppMethodBeat.o(13679);
    }

    public void onBackPressed() {
        AppMethodBeat.i(13680);
        super.onBackPressed();
        AppMethodBeat.o(13680);
    }

    private void apk() {
        AppMethodBeat.i(13681);
        if (this.gql) {
            this.gtl = (String) g.RP().Ry().get(208901, null);
            AppMethodBeat.o(13681);
            return;
        }
        this.gtl = (String) g.RP().Ry().get(208902, null);
        this.gqI = (String) g.RP().Ry().get(208904, null);
        AppMethodBeat.o(13681);
    }

    private void apl() {
        AppMethodBeat.i(13682);
        if (this.gql) {
            apn();
            AppMethodBeat.o(13682);
            return;
        }
        apm();
        AppMethodBeat.o(13682);
    }

    private void a(Cursor cursor, final n nVar) {
        AppMethodBeat.i(13683);
        List arrayList = new ArrayList();
        List arrayList2 = new ArrayList();
        final ArrayList arrayList3 = new ArrayList();
        if (cursor != null) {
            cursor.moveToFirst();
            int count = cursor.getCount();
            for (int i = 0; i < count; i++) {
                n nVar2 = new n();
                nVar2.d(cursor);
                arrayList.add(nVar2.field_googlegmail);
                arrayList2.add(Integer.valueOf(i));
                arrayList3.add(nVar2);
                cursor.moveToNext();
            }
            arrayList2.add(Integer.valueOf(-1));
        }
        Context context = this.mController.ylL;
        String string = getResources().getString(R.string.c8q);
        getResources().getString(R.string.or);
        h.a(context, string, arrayList, arrayList2, new d() {
            public final void bV(int i, int i2) {
                AppMethodBeat.i(13653);
                if (i2 != -1) {
                    GoogleFriendUI.a(GoogleFriendUI.this, (n) arrayList3.get(i2), nVar);
                }
                AppMethodBeat.o(13653);
            }
        });
        AppMethodBeat.o(13683);
    }

    private void a(n nVar, n nVar2) {
        AppMethodBeat.i(13684);
        ArrayList arrayList = new ArrayList();
        arrayList.add(nVar.field_googlegmail);
        com.tencent.mm.ai.m aeVar = new ae(arrayList);
        ab.d("MicroMsg.GoogleContact.GoogleFriendUI", "gmailItem:%s", nVar.field_googleitemid);
        g.Rg().a(aeVar, 0);
        if (nVar2 == null) {
            aeVar.gwh = nVar.field_googleitemid;
            nVar.field_googlecgistatus = 0;
            ((o) ((com.tencent.mm.plugin.account.a.a.a) g.M(com.tencent.mm.plugin.account.a.a.a.class)).getGoogleFriendStorage()).b(nVar);
        } else {
            aeVar.gwh = nVar2.field_googleitemid;
            nVar2.field_googlecgistatus = 0;
            ((o) ((com.tencent.mm.plugin.account.a.a.a) g.M(com.tencent.mm.plugin.account.a.a.a.class)).getGoogleFriendStorage()).b(nVar2);
        }
        this.gtj.KC();
        AppMethodBeat.o(13684);
    }

    private void apm() {
        AppMethodBeat.i(13685);
        aoW();
        new c(this.gqI).execute(new Void[0]);
        AppMethodBeat.o(13685);
    }

    private void apn() {
        AppMethodBeat.i(13686);
        this.xH = false;
        aoW();
        new b(this, this, this.gtl, (byte) 0).execute(new Void[0]);
        AppMethodBeat.o(13686);
    }

    private synchronized void a(ayl ayl) {
        AppMethodBeat.i(13687);
        ab.i("MicroMsg.GoogleContact.GoogleFriendUI", "handleListGoogleContactCGIResponse Count:%d", Integer.valueOf(ayl.jBv));
        if (this.gtj != null) {
            this.gtj.KC();
        }
        AppMethodBeat.o(13687);
    }

    private void dk(boolean z) {
        CharSequence string;
        AppMethodBeat.i(13688);
        this.gqv.setVisibility(0);
        if (!at.isConnected(this)) {
            string = getString(R.string.c8p);
        } else if (z) {
            string = getString(R.string.c8i);
        } else {
            string = getString(R.string.c8h);
        }
        this.gqv.setText(string);
        AppMethodBeat.o(13688);
    }

    private void aoW() {
        AppMethodBeat.i(13689);
        if (this.gqo == null || !this.gqo.isShowing()) {
            getString(R.string.tz);
            this.gqo = h.b((Context) this, getString(R.string.un), true, new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                    AppMethodBeat.i(13654);
                    GoogleFriendUI.this.xH = true;
                    g.Rg().c(GoogleFriendUI.this.gtm);
                    AppMethodBeat.o(13654);
                }
            });
        }
        AppMethodBeat.o(13689);
    }

    private void aoX() {
        AppMethodBeat.i(13690);
        if (this.gqo != null && this.gqo.isShowing()) {
            this.gqo.dismiss();
        }
        AppMethodBeat.o(13690);
    }
}
