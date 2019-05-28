package com.tencent.p177mm.plugin.webview.p580ui.tools.fts;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.plugin.fts.p424ui.widget.C43138a;
import com.tencent.p177mm.plugin.fts.p424ui.widget.C43138a.C12070a;
import com.tencent.p177mm.plugin.fts.p424ui.widget.C43138a.C12071b;
import com.tencent.p177mm.plugin.fts.p424ui.widget.FTSEditTextView.C20890b;
import com.tencent.p177mm.plugin.fts.p424ui.widget.FTSEditTextView.C20892a;
import com.tencent.p177mm.plugin.websearch.api.C14423an;
import com.tencent.p177mm.plugin.websearch.api.C29740h;
import com.tencent.p177mm.plugin.websearch.api.C29744z;
import com.tencent.p177mm.plugin.webview.fts.p1664d.C46411a;
import com.tencent.p177mm.plugin.webview.p580ui.tools.fts.PreLoadWebViewUI.C35671a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.vfs.C5730e;
import com.tencent.qqmusic.mediaplayer.PlayerException;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import com.tencent.view.C31128d;
import com.tencent.xweb.C24530n;
import com.tencent.xweb.C31147o;
import com.tencent.xweb.WebView;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.webview.ui.tools.fts.FTSBaseWebViewUI */
public class FTSBaseWebViewUI extends BaseSearchWebViewUI implements C20892a, C12070a {
    protected C43138a mIr;
    int scene;
    int type;
    private boolean uAT;
    private C29915e uAv;
    private C46411a uAw;
    private boolean uzU;

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.fts.FTSBaseWebViewUI$6 */
    class C229506 implements Runnable {
        C229506() {
        }

        public final void run() {
            AppMethodBeat.m2504i(8389);
            if (FTSBaseWebViewUI.this.uhz != null) {
                FTSBaseWebViewUI.this.uhz.mo71888a(FTSBaseWebViewUI.this.getTotalQuery(), FTSBaseWebViewUI.this.getInEditTextQuery(), FTSBaseWebViewUI.this.dbB(), 1);
            }
            AppMethodBeat.m2505o(8389);
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.fts.FTSBaseWebViewUI$7 */
    class C229517 implements OnLongClickListener {
        C229517() {
        }

        public final boolean onLongClick(View view) {
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.fts.FTSBaseWebViewUI$9 */
    class C229529 implements Runnable {
        C229529() {
        }

        public final void run() {
            AppMethodBeat.m2504i(8391);
            if (FTSBaseWebViewUI.this.uhz != null) {
                FTSBaseWebViewUI.this.uhz.mo71888a(FTSBaseWebViewUI.this.getTotalQuery(), FTSBaseWebViewUI.this.getInEditTextQuery(), FTSBaseWebViewUI.this.dbB(), 0);
            }
            AppMethodBeat.m2505o(8391);
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.fts.FTSBaseWebViewUI$a */
    public class C22953a implements C12071b {
        int aTq;
        String rMJ;
        String userName;

        public final String getTagName() {
            return this.rMJ;
        }

        public final int compareTo(Object obj) {
            AppMethodBeat.m2504i(8397);
            if (obj == null || !(obj instanceof C22953a)) {
                AppMethodBeat.m2505o(8397);
                return -1;
            }
            int compareTo = this.rMJ.compareTo(((C22953a) obj).rMJ);
            AppMethodBeat.m2505o(8397);
            return compareTo;
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.fts.FTSBaseWebViewUI$b */
    class C22954b extends C35671a {
        private C22954b() {
            super();
        }

        /* synthetic */ C22954b(FTSBaseWebViewUI fTSBaseWebViewUI, byte b) {
            this();
        }

        /* renamed from: b */
        public final void mo5992b(WebView webView, String str) {
            AppMethodBeat.m2504i(8398);
            super.mo5992b(webView, str);
            C4990ab.m7417i("MicroMsg.FTS.FTSBaseWebViewUI", "onPageFinished %s", str);
            FTSBaseWebViewUI.this.showOptionMenu(false);
            if (!(FTSBaseWebViewUI.this.mIr == null || FTSBaseWebViewUI.this.uzU)) {
                FTSBaseWebViewUI.this.mIr.getFtsEditText().mLL.clearFocus();
                FTSBaseWebViewUI.this.aqX();
            }
            AppMethodBeat.m2505o(8398);
        }

        /* renamed from: b */
        public final void mo7562b(WebView webView, String str, Bitmap bitmap) {
            AppMethodBeat.m2504i(8399);
            super.mo7562b(webView, str, bitmap);
            C4990ab.m7417i("MicroMsg.FTS.FTSBaseWebViewUI", "onPageStarted %s", str);
            FTSBaseWebViewUI.this.showOptionMenu(false);
            if (!(FTSBaseWebViewUI.this.mIr == null || FTSBaseWebViewUI.this.uzU)) {
                FTSBaseWebViewUI.this.mIr.getFtsEditText().mLL.clearFocus();
                FTSBaseWebViewUI.this.aqX();
            }
            C14423an.reportIdKey649ForLook(FTSBaseWebViewUI.this.scene, 1);
            C14423an.m22655gp(FTSBaseWebViewUI.this.scene, 1);
            AppMethodBeat.m2505o(8399);
        }

        /* renamed from: a */
        public final C31147o mo5991a(WebView webView, C24530n c24530n, Bundle bundle) {
            C31147o aga;
            AppMethodBeat.m2504i(8400);
            if (!(c24530n == null || c24530n.getUrl() == null || !c24530n.getUrl().toString().startsWith("weixin://fts"))) {
                aga = C22954b.aga(c24530n.getUrl().toString());
                if (aga != null) {
                    AppMethodBeat.m2505o(8400);
                    return aga;
                }
            }
            aga = super.mo5990a(webView, c24530n);
            AppMethodBeat.m2505o(8400);
            return aga;
        }

        /* renamed from: a */
        public final C31147o mo5990a(WebView webView, C24530n c24530n) {
            C31147o aga;
            AppMethodBeat.m2504i(8401);
            if (!(c24530n == null || c24530n.getUrl() == null || !c24530n.getUrl().toString().startsWith("weixin://fts"))) {
                aga = C22954b.aga(c24530n.getUrl().toString());
                if (aga != null) {
                    AppMethodBeat.m2505o(8401);
                    return aga;
                }
            }
            aga = super.mo5990a(webView, c24530n);
            AppMethodBeat.m2505o(8401);
            return aga;
        }

        /* renamed from: c */
        public final C31147o mo5993c(WebView webView, String str) {
            C31147o aga;
            AppMethodBeat.m2504i(8402);
            if (str.startsWith("weixin://fts")) {
                aga = C22954b.aga(str);
                if (aga != null) {
                    AppMethodBeat.m2505o(8402);
                    return aga;
                }
            }
            aga = super.mo5993c(webView, str);
            AppMethodBeat.m2505o(8402);
            return aga;
        }

        private static C31147o aga(String str) {
            InputStream openRead;
            AppMethodBeat.m2504i(8403);
            C4990ab.m7417i("MicroMsg.FTS.FTSBaseWebViewUI", "url=%s | thread=%d", str, Long.valueOf(Thread.currentThread().getId()));
            try {
                openRead = C5730e.openRead(Uri.parse(str).getQueryParameter("path"));
            } catch (Exception e) {
                openRead = null;
            }
            if (openRead != null) {
                C31147o c31147o = new C31147o("image/*", "utf8", openRead);
                AppMethodBeat.m2505o(8403);
                return c31147o;
            }
            AppMethodBeat.m2505o(8403);
            return null;
        }

        /* renamed from: a */
        public final void mo7559a(WebView webView, int i, String str, String str2) {
            AppMethodBeat.m2504i(8404);
            super.mo7559a(webView, i, str, str2);
            if (str2 != null && str2.equals(FTSBaseWebViewUI.this.cOG)) {
                C14423an.reportIdKey649ForLook(FTSBaseWebViewUI.this.scene, 16);
            }
            AppMethodBeat.m2505o(8404);
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.fts.FTSBaseWebViewUI$10 */
    class C2989810 implements Runnable {
        C2989810() {
        }

        public final void run() {
            AppMethodBeat.m2504i(8392);
            if (FTSBaseWebViewUI.this.uhz != null) {
                FTSBaseWebViewUI.this.uhz.mo71889a(FTSBaseWebViewUI.this.getTotalQuery(), FTSBaseWebViewUI.this.getInEditTextQuery(), FTSBaseWebViewUI.this.dbB(), 0, null);
                if (!TextUtils.isEmpty(FTSBaseWebViewUI.this.getInEditTextQuery())) {
                    boolean z;
                    int g = FTSBaseWebViewUI.this.scene;
                    String str = FTSBaseWebViewUI.this.cvF;
                    String str2 = FTSBaseWebViewUI.this.cIy;
                    if (FTSBaseWebViewUI.this.uAO == 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    C29744z.m47160a(g, str, str2, z, FTSBaseWebViewUI.this.getInEditTextQuery(), FTSBaseWebViewUI.this.type);
                }
            }
            AppMethodBeat.m2505o(8392);
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.fts.FTSBaseWebViewUI$8 */
    class C299018 implements Runnable {
        C299018() {
        }

        public final void run() {
            AppMethodBeat.m2504i(8390);
            if (FTSBaseWebViewUI.this.uhz != null) {
                FTSBaseWebViewUI.this.uhz.mo71888a(FTSBaseWebViewUI.this.getTotalQuery(), FTSBaseWebViewUI.this.getInEditTextQuery(), FTSBaseWebViewUI.this.dbB(), 0);
            }
            AppMethodBeat.m2505o(8390);
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.fts.FTSBaseWebViewUI$1 */
    class C439521 implements OnTouchListener {
        C439521() {
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            AppMethodBeat.m2504i(8384);
            FTSBaseWebViewUI.this.aqX();
            AppMethodBeat.m2505o(8384);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.fts.FTSBaseWebViewUI$2 */
    class C439532 implements Runnable {
        C439532() {
        }

        public final void run() {
            AppMethodBeat.m2504i(8385);
            if (FTSBaseWebViewUI.this.uhz != null) {
                FTSBaseWebViewUI.this.uhz.mo71888a(FTSBaseWebViewUI.this.getTotalQuery(), FTSBaseWebViewUI.this.getInEditTextQuery(), FTSBaseWebViewUI.this.dbB(), 0);
            }
            AppMethodBeat.m2505o(8385);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(8405);
        super.onCreate(bundle);
        this.uAw = new C46411a(this.pzf);
        this.uAv = new C29915e(((C29740h) C1720g.m3528K(C29740h.class)).mo47979a(this.mController.ylL, this.uAw));
        mo17446xE(this.mController.ylL.getResources().getColor(C25738R.color.f12206vy));
        AppMethodBeat.m2505o(8405);
    }

    public void aMh() {
        AppMethodBeat.m2504i(8406);
        super.aMh();
        String trim = C5046bo.m7532bc(getIntent().getStringExtra("ftsQuery"), "").trim();
        this.type = getIntent().getIntExtra("ftsType", 0);
        this.scene = getIntent().getIntExtra("ftsbizscene", 0);
        this.uzU = getIntent().getBooleanExtra("ftsneedkeyboard", false);
        this.uAT = getIntent().getBooleanExtra("ftscaneditable", true);
        this.pzf.setWebViewClient(new C22954b(this, (byte) 0));
        this.pzf.setOnTouchListener(new C439521());
        if (this.uAT) {
            this.mIr = new C43138a(this);
            this.mIr.setSearchViewListener(this);
            this.mIr.getFtsEditText().setHint(getHint());
            this.mIr.getFtsEditText().setFtsEditTextListener(this);
            getSupportActionBar().setCustomView(this.mIr);
            if (!C5046bo.isNullOrNil(trim)) {
                this.mIr.getFtsEditText().mo36173n(trim, null);
            }
            if (this.uzU) {
                this.mIr.getFtsEditText().bBo();
                this.mIr.getFtsEditText().bBn();
            }
        }
        showOptionMenu(false);
        if (dao() != null) {
            dao().mo69669nM(true);
        }
        this.pzf.setOnLongClickListener(new C229517());
        this.uAw.uhz = this.uhz;
        AppMethodBeat.m2505o(8406);
    }

    private void cGC() {
        AppMethodBeat.m2504i(8407);
        aqX();
        finish();
        overridePendingTransition(0, 0);
        AppMethodBeat.m2505o(8407);
    }

    public final int dam() {
        return C1318a.actionbar_icon_dark_back;
    }

    public final boolean dax() {
        return true;
    }

    /* Access modifiers changed, original: protected|final */
    public final String getTotalQuery() {
        AppMethodBeat.m2504i(8408);
        String totalQuery = this.mIr.getFtsEditText().getTotalQuery();
        AppMethodBeat.m2505o(8408);
        return totalQuery;
    }

    /* Access modifiers changed, original: protected|final */
    public final String getInEditTextQuery() {
        AppMethodBeat.m2504i(8409);
        String inEditTextQuery = this.mIr.getFtsEditText().getInEditTextQuery();
        AppMethodBeat.m2505o(8409);
        return inEditTextQuery;
    }

    public final boolean dan() {
        return false;
    }

    public void onClickBackBtn(View view) {
        AppMethodBeat.m2504i(8410);
        cGC();
        AppMethodBeat.m2505o(8410);
    }

    public final void bAR() {
        AppMethodBeat.m2504i(8411);
        if (!this.mIr.getFtsEditText().mLL.hasFocus()) {
            this.mIr.getFtsEditText().bBo();
            showVKB();
        }
        AppMethodBeat.m2505o(8411);
    }

    public void onResume() {
        AppMethodBeat.m2504i(8412);
        super.onResume();
        this.uAv.onResume();
        AppMethodBeat.m2505o(8412);
    }

    public void onPause() {
        AppMethodBeat.m2504i(8413);
        super.onPause();
        this.uAv.onPause();
        AppMethodBeat.m2505o(8413);
    }

    /* renamed from: a */
    public void mo6403a(String str, String str2, List<C12071b> list, C20890b c20890b) {
        AppMethodBeat.m2504i(8414);
        C4990ab.m7417i("MicroMsg.FTS.FTSBaseWebViewUI", "onEditTextChange %s %s %s", str, str2, c20890b);
        if (c20890b == C20890b.UserInput || c20890b == C20890b.ClearText) {
            this.handler.post(new C299018());
        }
        AppMethodBeat.m2505o(8414);
    }

    /* renamed from: hz */
    public final void mo25276hz(boolean z) {
        AppMethodBeat.m2504i(8415);
        if (z) {
            this.handler.post(new C229529());
        }
        AppMethodBeat.m2505o(8415);
    }

    public void onClickClearTextBtn(View view) {
        AppMethodBeat.m2504i(8416);
        if (this.mIr != null) {
            if (!this.mIr.getFtsEditText().mLL.hasFocus()) {
                this.mIr.getFtsEditText().bBo();
                showVKB();
            }
            this.mIr.getFtsEditText().setHint(getHint());
        }
        AppMethodBeat.m2505o(8416);
    }

    public boolean aMo() {
        AppMethodBeat.m2504i(8417);
        C4990ab.m7416i("MicroMsg.FTS.FTSBaseWebViewUI", "onSearchKeyDown");
        if (getTotalQuery().length() > 0) {
            this.handler.post(new C2989810());
            aqX();
        }
        AppMethodBeat.m2505o(8417);
        return false;
    }

    public final JSONArray dbB() {
        AppMethodBeat.m2504i(8418);
        List<C12071b> tagList = this.mIr.getFtsEditText().getTagList();
        JSONArray jSONArray = new JSONArray();
        for (C12071b c12071b : tagList) {
            C22953a c22953a = (C22953a) c12071b;
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("tagName", c22953a.rMJ);
                jSONObject.put("tagType", c22953a.aTq);
                jSONObject.put("userName", c22953a.userName);
                jSONArray.put(jSONObject);
            } catch (JSONException e) {
            }
        }
        AppMethodBeat.m2505o(8418);
        return jSONArray;
    }

    /* renamed from: j */
    public void mo9685j(int i, Bundle bundle) {
        int i2 = 0;
        AppMethodBeat.m2504i(8419);
        final String string;
        final String string2;
        switch (i) {
            case 60:
                this.uAv.mo48161b(bundle, this.scene);
                AppMethodBeat.m2505o(8419);
                return;
            case PlayerException.EXCEPTION_TYPE_INITLIB /*61*/:
                this.uAv.mo48158aj(bundle);
                AppMethodBeat.m2505o(8419);
                return;
            case 62:
                this.uAv.mo48159ak(bundle);
                AppMethodBeat.m2505o(8419);
                return;
            case C31128d.MIC_AVROUND_BLUR /*119*/:
                final String string3 = bundle.getString("fts_key_json_data");
                final String string4 = bundle.getString("fts_key_req_id");
                final boolean z = bundle.getBoolean("fts_key_new_query", true);
                final Bundle bundle2 = bundle.getBundle("fts_key_data");
                this.handler.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(8394);
                        if (FTSBaseWebViewUI.this.uhz != null) {
                            if (bundle2 == null || bundle2.getInt("isRefresh") != 1 || bundle2.getString("widgetId") == null) {
                                FTSBaseWebViewUI.this.uhz.mo71931h(string3, z, string4);
                            } else {
                                FTSBaseWebViewUI.this.uhz.mo71932hj(bundle2.getString("widgetId"), string3);
                                AppMethodBeat.m2505o(8394);
                                return;
                            }
                        }
                        AppMethodBeat.m2505o(8394);
                    }
                });
                AppMethodBeat.m2505o(8419);
                return;
            case 120:
                i2 = bundle.getInt("fts_key_ret", 0);
                string = bundle.getString("fts_key_data");
                this.handler.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(8395);
                        if (FTSBaseWebViewUI.this.uhz != null) {
                            FTSBaseWebViewUI.this.uhz.mo71909bH(i2, string);
                        }
                        AppMethodBeat.m2505o(8395);
                    }
                });
                AppMethodBeat.m2505o(8419);
                return;
            case 121:
                string = bundle.getString("fts_key_json_data");
                final int i3 = bundle.getInt("fts_key_teach_request_type", 0);
                i2 = bundle.getInt("fts_key_is_cache_data", 0);
                this.handler.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(8396);
                        if (FTSBaseWebViewUI.this.uhz != null) {
                            FTSBaseWebViewUI.this.uhz.mo71936n(i3, string, i2);
                        }
                        AppMethodBeat.m2505o(8396);
                    }
                });
                AppMethodBeat.m2505o(8419);
                return;
            case 122:
                string = bundle.getString("fts_key_new_query");
                String string5 = bundle.getString("fts_key_custom_query");
                boolean z2 = bundle.getBoolean("fts_key_need_keyboard", false);
                String string6 = bundle.getString("fts_key_tag_list");
                C4990ab.m7417i("MicroMsg.FTS.FTSBaseWebViewUI", "onFTSSearchQueryChange: totalQuery: %s isInputChange %b", string, Boolean.valueOf(z2));
                ArrayList arrayList = new ArrayList();
                try {
                    if (!C5046bo.isNullOrNil(string6)) {
                        JSONArray jSONArray = new JSONArray(string6);
                        while (i2 < jSONArray.length()) {
                            JSONObject jSONObject = jSONArray.getJSONObject(i2);
                            C22953a c22953a = new C22953a();
                            c22953a.rMJ = jSONObject.getString("tagName");
                            c22953a.aTq = jSONObject.getInt("tagType");
                            c22953a.userName = jSONObject.getString("userName");
                            arrayList.add(c22953a);
                            i2++;
                        }
                    }
                } catch (Exception e) {
                }
                if (this.mIr != null) {
                    if (arrayList.size() > 0) {
                        this.mIr.getFtsEditText().mo36173n(string5, arrayList);
                    } else {
                        this.mIr.getFtsEditText().mo36173n(string, arrayList);
                    }
                }
                if (z2) {
                    this.handler.post(new C439532());
                    if (this.mIr != null) {
                        this.mIr.getFtsEditText().bBo();
                    }
                    daE();
                    AppMethodBeat.m2505o(8419);
                    return;
                } else if (this.mIr != null) {
                    this.mIr.getFtsEditText().mLL.clearFocus();
                    aqX();
                    AppMethodBeat.m2505o(8419);
                    return;
                }
                break;
            case 124:
                string2 = bundle.getString("fts_key_json_data");
                this.handler.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(8386);
                        if (FTSBaseWebViewUI.this.uhz != null) {
                            FTSBaseWebViewUI.this.uhz.agq(string2);
                        }
                        AppMethodBeat.m2505o(8386);
                    }
                });
                AppMethodBeat.m2505o(8419);
                return;
            case 125:
                string = bundle.getString("fts_key_sns_id");
                i2 = bundle.getInt("fts_key_status", 0);
                this.handler.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(8387);
                        if (FTSBaseWebViewUI.this.uhz != null) {
                            FTSBaseWebViewUI.this.uhz.mo71920dN(string, i2);
                        }
                        AppMethodBeat.m2505o(8387);
                    }
                });
                AppMethodBeat.m2505o(8419);
                return;
            case 128:
                bundle.getString("fts_key_json_data");
                bundle.getBoolean("fts_key_new_query", true);
                final HashMap hashMap = new HashMap();
                for (String string22 : bundle.keySet()) {
                    hashMap.put(string22, bundle.get(string22));
                }
                this.handler.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(8393);
                        if (FTSBaseWebViewUI.this.uhz != null) {
                            FTSBaseWebViewUI.this.uhz.mo71898aO(hashMap);
                        }
                        AppMethodBeat.m2505o(8393);
                    }
                });
                AppMethodBeat.m2505o(8419);
                return;
            case 144:
                AppMethodBeat.m2505o(8419);
                return;
            case ErrorCode.NEEDDOWNLOAD_8 /*147*/:
                final int i4 = bundle.getInt("ret");
                final long j = bundle.getLong("reqId");
                final String string7 = bundle.getString("json", "");
                this.handler.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(8388);
                        if (FTSBaseWebViewUI.this.uhz != null) {
                            FTSBaseWebViewUI.this.uhz.mo71882a(i4, j, string7);
                            C4990ab.m7417i("MicroMsg.FTS.FTSBaseWebViewUI", "wxaapp_opsearch resp, ret = %d, reqId = %d, json = %s", Integer.valueOf(i4), Long.valueOf(j), string7);
                        }
                        AppMethodBeat.m2505o(8388);
                    }
                });
                AppMethodBeat.m2505o(8419);
                return;
            case 100001:
                this.uAv.mo48157ai(bundle);
                AppMethodBeat.m2505o(8419);
                return;
            default:
                super.mo9685j(i, bundle);
                break;
        }
        AppMethodBeat.m2505o(8419);
    }

    /* Access modifiers changed, original: protected|final */
    public final C29915e dbz() {
        return this.uAv;
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(8420);
        try {
            if (this.icy != null) {
                Bundle bundle = new Bundle();
                bundle.putInt("webview_id", hashCode());
                this.icy.mo15582j(1, bundle);
            }
            this.uAv.onDestroy();
        } catch (RemoteException e) {
        }
        aqX();
        super.onDestroy();
        AppMethodBeat.m2505o(8420);
    }

    /* Access modifiers changed, original: protected */
    public String getHint() {
        return null;
    }

    public final int getLayoutId() {
        return 2130969645;
    }

    public final boolean aYb() {
        return false;
    }

    public final void dai() {
        AppMethodBeat.m2504i(8421);
        cGC();
        AppMethodBeat.m2505o(8421);
    }

    public final int getForceOrientation() {
        return 1;
    }

    public void onClickCancelBtn(View view) {
        AppMethodBeat.m2504i(8422);
        this.mIr.getFtsEditText().mo36173n("", null);
        this.handler.post(new C229506());
        this.mIr.getFtsEditText().mLL.clearFocus();
        aqX();
        AppMethodBeat.m2505o(8422);
    }
}
