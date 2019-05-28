package com.tencent.p177mm.plugin.webview.p580ui.tools.fts;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.widget.ImageButton;
import com.google.android.gms.actions.SearchIntents;
import com.google.android.gms.common.internal.ImagesContract;
import com.google.firebase.analytics.FirebaseAnalytics.C8741b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p612ui.fts.widget.SOSEditTextView;
import com.tencent.p177mm.plugin.fts.p424ui.widget.C43138a.C12071b;
import com.tencent.p177mm.plugin.fts.p424ui.widget.FTSEditTextView.C20890b;
import com.tencent.p177mm.plugin.fts.p424ui.widget.FTSEditTextView.C20892a;
import com.tencent.p177mm.plugin.websearch.api.C29740h;
import com.tencent.p177mm.plugin.websearch.api.C29744z;
import com.tencent.p177mm.plugin.webview.fts.p1664d.C46411a;
import com.tencent.p177mm.plugin.webview.fts.p578b.p579a.C4539a;
import com.tencent.p177mm.plugin.webview.p580ui.tools.fts.FTSBaseWebViewUI.C22953a;
import com.tencent.p177mm.plugin.webview.p580ui.tools.fts.LoadDataWebviewUI.C22964a;
import com.tencent.p177mm.plugin.webview.p580ui.tools.jsapi.C29945i.C23124a;
import com.tencent.p177mm.plugin.webview.p580ui.tools.jsapi.C44786d;
import com.tencent.p177mm.plugin.webview.p580ui.tools.jsapi.C44786d.C3568835;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
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
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.webview.ui.tools.fts.BaseSOSWebViewUI */
public class BaseSOSWebViewUI extends BaseSearchWebViewUI implements C20892a {
    protected ImageButton oOO;
    protected View qkP;
    View uAr;
    protected SOSEditTextView uAs;
    private List<C14595c> uAt;
    protected int uAu = 0;
    private C29915e uAv;
    private C46411a uAw;
    boolean uAx;
    boolean uAy;
    private boolean uzU;

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.fts.BaseSOSWebViewUI$c */
    protected class C14595c {
        List<C12071b> kPL;
        int type;
        String uAH = "";
        String uAI = "";
        Map<String, Object> uAJ = new HashMap();

        protected C14595c() {
            AppMethodBeat.m2504i(8357);
            AppMethodBeat.m2505o(8357);
        }

        public final boolean equals(Object obj) {
            AppMethodBeat.m2504i(8358);
            if (this == obj) {
                AppMethodBeat.m2505o(8358);
                return true;
            } else if (obj instanceof C14595c) {
                C14595c c14595c = (C14595c) obj;
                if (c14595c.type == this.type && c14595c.uAI.equals(this.uAI)) {
                    AppMethodBeat.m2505o(8358);
                    return true;
                }
                AppMethodBeat.m2505o(8358);
                return false;
            } else {
                AppMethodBeat.m2505o(8358);
                return false;
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.fts.BaseSOSWebViewUI$19 */
    class C2294919 implements Runnable {
        C2294919() {
        }

        public final void run() {
            AppMethodBeat.m2504i(8349);
            if (BaseSOSWebViewUI.this.getJsapi() != null) {
                BaseSOSWebViewUI.this.getJsapi().mo71887a(BaseSOSWebViewUI.this.getTotalQuery(), BaseSOSWebViewUI.this.getInEditTextQuery(), BaseSOSWebViewUI.this.dbB());
            }
            AppMethodBeat.m2505o(8349);
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.fts.BaseSOSWebViewUI$17 */
    class C2989017 implements Runnable {

        /* renamed from: com.tencent.mm.plugin.webview.ui.tools.fts.BaseSOSWebViewUI$17$1 */
        class C298911 implements Runnable {
            C298911() {
            }

            public final void run() {
                AppMethodBeat.m2504i(8346);
                C44786d jsapi = BaseSOSWebViewUI.this.getJsapi();
                int i = BaseSOSWebViewUI.this.scene;
                Map hashMap = new HashMap();
                hashMap.put("isCancelButtonClick", Integer.valueOf(1));
                hashMap.put("isInputChange", Integer.valueOf(1));
                hashMap.put("scene", Integer.valueOf(i));
                jsapi.mo71890a("onSearchInputChange", hashMap, null);
                AppMethodBeat.m2505o(8346);
            }
        }

        C2989017() {
        }

        public final void run() {
            AppMethodBeat.m2504i(8347);
            if (BaseSOSWebViewUI.this.getJsapi() != null) {
                BaseSOSWebViewUI.this.mo9680ab(new C298911());
            }
            AppMethodBeat.m2505o(8347);
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.fts.BaseSOSWebViewUI$18 */
    class C2989218 implements Runnable {
        C2989218() {
        }

        public final void run() {
            AppMethodBeat.m2504i(8348);
            if (BaseSOSWebViewUI.this.getJsapi() != null) {
                BaseSOSWebViewUI.this.getJsapi().mo71887a(BaseSOSWebViewUI.this.getTotalQuery(), BaseSOSWebViewUI.this.getInEditTextQuery(), BaseSOSWebViewUI.this.dbB());
            }
            AppMethodBeat.m2505o(8348);
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.fts.BaseSOSWebViewUI$8 */
    class C298948 implements Runnable {
        C298948() {
        }

        public final void run() {
            AppMethodBeat.m2504i(8338);
            if (BaseSOSWebViewUI.this.getJsapi() != null) {
                BaseSOSWebViewUI.this.getJsapi().mo71887a(BaseSOSWebViewUI.this.getTotalQuery(), BaseSOSWebViewUI.this.getInEditTextQuery(), BaseSOSWebViewUI.this.dbB());
            }
            AppMethodBeat.m2505o(8338);
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.fts.BaseSOSWebViewUI$a */
    public class C29896a implements C12071b {
        int aTq;
        String rMJ;
        String userName;

        public final String getTagName() {
            return this.rMJ;
        }

        public final int compareTo(Object obj) {
            AppMethodBeat.m2504i(8350);
            if (obj == null || !(obj instanceof C22953a)) {
                AppMethodBeat.m2505o(8350);
                return -1;
            }
            int compareTo = this.rMJ.compareTo(((C22953a) obj).rMJ);
            AppMethodBeat.m2505o(8350);
            return compareTo;
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.fts.BaseSOSWebViewUI$b */
    class C29897b extends C22964a {
        private C29897b() {
            super();
        }

        /* synthetic */ C29897b(BaseSOSWebViewUI baseSOSWebViewUI, byte b) {
            this();
        }

        /* renamed from: b */
        public final void mo5992b(WebView webView, String str) {
            AppMethodBeat.m2504i(8351);
            super.mo5992b(webView, str);
            C4990ab.m7417i("MicroMsg.FTS.BaseSOSWebViewUI", "scene %d, onPageFinished %s", Integer.valueOf(BaseSOSWebViewUI.this.scene), str);
            BaseSOSWebViewUI.this.showOptionMenu(false);
            if (!(BaseSOSWebViewUI.this.uAs == null || BaseSOSWebViewUI.this.uzU)) {
                BaseSOSWebViewUI.this.uAs.mLL.clearFocus();
                BaseSOSWebViewUI.this.aqX();
            }
            BaseSOSWebViewUI.this.uAy = true;
            BaseSOSWebViewUI.this.dbv();
            AppMethodBeat.m2505o(8351);
        }

        /* renamed from: b */
        public final void mo7562b(WebView webView, String str, Bitmap bitmap) {
            AppMethodBeat.m2504i(8352);
            super.mo7562b(webView, str, bitmap);
            C4990ab.m7417i("MicroMsg.FTS.BaseSOSWebViewUI", "onPageStarted %s", str);
            BaseSOSWebViewUI.this.showOptionMenu(false);
            if (!(BaseSOSWebViewUI.this.uAs == null || BaseSOSWebViewUI.this.uzU)) {
                BaseSOSWebViewUI.this.uAs.mLL.clearFocus();
                BaseSOSWebViewUI.this.aqX();
            }
            AppMethodBeat.m2505o(8352);
        }

        /* renamed from: a */
        public final C31147o mo5991a(WebView webView, C24530n c24530n, Bundle bundle) {
            C31147o aga;
            AppMethodBeat.m2504i(8353);
            if (!(c24530n == null || c24530n.getUrl() == null || !c24530n.getUrl().toString().startsWith("weixin://fts"))) {
                aga = C29897b.aga(c24530n.getUrl().toString());
                if (aga != null) {
                    AppMethodBeat.m2505o(8353);
                    return aga;
                }
            }
            aga = super.mo5990a(webView, c24530n);
            AppMethodBeat.m2505o(8353);
            return aga;
        }

        /* renamed from: a */
        public final C31147o mo5990a(WebView webView, C24530n c24530n) {
            C31147o aga;
            AppMethodBeat.m2504i(8354);
            if (!(c24530n == null || c24530n.getUrl() == null || !c24530n.getUrl().toString().startsWith("weixin://fts"))) {
                aga = C29897b.aga(c24530n.getUrl().toString());
                if (aga != null) {
                    AppMethodBeat.m2505o(8354);
                    return aga;
                }
            }
            aga = super.mo5990a(webView, c24530n);
            AppMethodBeat.m2505o(8354);
            return aga;
        }

        /* renamed from: c */
        public final C31147o mo5993c(WebView webView, String str) {
            C31147o aga;
            AppMethodBeat.m2504i(8355);
            if (str.startsWith("weixin://fts")) {
                aga = C29897b.aga(str);
                if (aga != null) {
                    AppMethodBeat.m2505o(8355);
                    return aga;
                }
            }
            aga = super.mo5993c(webView, str);
            AppMethodBeat.m2505o(8355);
            return aga;
        }

        private static C31147o aga(String str) {
            InputStream openRead;
            AppMethodBeat.m2504i(8356);
            C4990ab.m7417i("MicroMsg.FTS.BaseSOSWebViewUI", "url=%s | thread=%d", str, Long.valueOf(Thread.currentThread().getId()));
            try {
                openRead = C5730e.openRead(Uri.parse(str).getQueryParameter("path"));
            } catch (Exception e) {
                openRead = null;
            }
            if (openRead != null) {
                C31147o c31147o = new C31147o("image/*", "utf8", openRead);
                AppMethodBeat.m2505o(8356);
                return c31147o;
            }
            AppMethodBeat.m2505o(8356);
            return null;
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.fts.BaseSOSWebViewUI$13 */
    class C3565313 implements OnTouchListener {
        C3565313() {
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            AppMethodBeat.m2504i(8343);
            BaseSOSWebViewUI.this.dby().getEditText().clearFocus();
            BaseSOSWebViewUI.this.aqX();
            AppMethodBeat.m2505o(8343);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.fts.BaseSOSWebViewUI$15 */
    class C3565415 implements OnLongClickListener {
        C3565415() {
        }

        public final boolean onLongClick(View view) {
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.fts.BaseSOSWebViewUI$1 */
    class C356551 implements OnClickListener {
        C356551() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(8331);
            BaseSOSWebViewUI.this.dbu();
            AppMethodBeat.m2505o(8331);
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.fts.BaseSOSWebViewUI$2 */
    class C356562 implements Runnable {
        C356562() {
        }

        public final void run() {
            AppMethodBeat.m2504i(8332);
            if (BaseSOSWebViewUI.this.getJsapi() != null) {
                HashMap hashMap = new HashMap();
                if (BaseSOSWebViewUI.this.dbx() != 0) {
                    hashMap.put("sugClickType", Integer.valueOf(BaseSOSWebViewUI.this.dbx()));
                    hashMap.put("sugId", BaseSOSWebViewUI.this.dbw());
                }
                C44786d jsapi = BaseSOSWebViewUI.this.getJsapi();
                String totalQuery = BaseSOSWebViewUI.this.getTotalQuery();
                String inEditTextQuery = BaseSOSWebViewUI.this.getInEditTextQuery();
                JSONArray dbB = BaseSOSWebViewUI.this.dbB();
                Map hashMap2 = new HashMap();
                hashMap2.putAll(hashMap);
                hashMap2.put(SearchIntents.EXTRA_QUERY, totalQuery);
                hashMap2.put("custom", inEditTextQuery);
                hashMap2.put("tagList", dbB);
                jsapi.mo71890a("onSearchInputConfirm", hashMap2, null);
                if (!TextUtils.isEmpty(BaseSOSWebViewUI.this.getInEditTextQuery())) {
                    C29744z.m47160a(BaseSOSWebViewUI.this.uAN, BaseSOSWebViewUI.this.cvF, BaseSOSWebViewUI.this.cIy, true, BaseSOSWebViewUI.this.getInEditTextQuery(), BaseSOSWebViewUI.this.uAO);
                }
            }
            AppMethodBeat.m2505o(8332);
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.fts.BaseSOSWebViewUI$12 */
    class C3565812 implements OnClickListener {
        C3565812() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(8342);
            BaseSOSWebViewUI.this.cGC();
            AppMethodBeat.m2505o(8342);
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.fts.BaseSOSWebViewUI$14 */
    class C3565914 implements Runnable {
        C3565914() {
        }

        public final void run() {
            AppMethodBeat.m2504i(8344);
            BaseSOSWebViewUI.this.dby().bBo();
            BaseSOSWebViewUI.this.dby().bBn();
            AppMethodBeat.m2505o(8344);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(8359);
        super.onCreate(bundle);
        getSupportActionBar().hide();
        this.uAw = new C46411a(this.pzf);
        this.uAv = new C29915e(((C29740h) C1720g.m3528K(C29740h.class)).mo47979a(this.mController.ylL, this.uAw));
        AppMethodBeat.m2505o(8359);
    }

    public void aMh() {
        AppMethodBeat.m2504i(8360);
        super.aMh();
        this.uzU = getIntent().getBooleanExtra("ftsneedkeyboard", false);
        this.uAr = findViewById(2131827954);
        this.uAs = (SOSEditTextView) findViewById(2131827956);
        this.uAs.setFtsEditTextListener(this);
        this.uAs.setHint(getHint());
        this.qkP = findViewById(2131822819);
        this.qkP.setOnClickListener(new C356551());
        this.oOO = (ImageButton) findViewById(2131826267);
        this.oOO.setOnClickListener(new C3565812());
        this.pzf.setWebViewClient(new C29897b(this, (byte) 0));
        this.pzf.setOnTouchListener(new C3565313());
        if (this.uzU) {
            this.mController.contentView.postDelayed(new C3565914(), 128);
        }
        if (dao() != null) {
            dao().mo69669nM(true);
        }
        this.pzf.setOnLongClickListener(new C3565415());
        this.uAw.uhz = this.uhz;
        AppMethodBeat.m2505o(8360);
    }

    public void onResume() {
        AppMethodBeat.m2504i(8361);
        super.onResume();
        this.uAv.onResume();
        AppMethodBeat.m2505o(8361);
    }

    public void onPause() {
        AppMethodBeat.m2504i(8362);
        super.onPause();
        this.uAv.onPause();
        AppMethodBeat.m2505o(8362);
    }

    public final String getSessionId() {
        return this.cvF;
    }

    /* Access modifiers changed, original: protected|final */
    public final void cGC() {
        AppMethodBeat.m2504i(8363);
        aqX();
        if (this.uAt != null && this.uAt.size() > 1) {
            this.uAt.remove(0);
            final C14595c c14595c = (C14595c) this.uAt.get(0);
            this.uAs.mo36173n(c14595c.uAI, c14595c.kPL);
            this.handler.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(8345);
                    if (BaseSOSWebViewUI.this.getJsapi() != null) {
                        BaseSOSWebViewUI.this.dbs();
                        BaseSOSWebViewUI.this.uAO = c14595c.type;
                        BaseSOSWebViewUI.this.dbt();
                        Bundle bundle = new Bundle();
                        bundle.putInt("type", BaseSOSWebViewUI.this.uAO);
                        bundle.putBoolean("isHomePage", true);
                        bundle.putInt("scene", BaseSOSWebViewUI.this.bFf());
                        try {
                            BaseSOSWebViewUI.this.icy.mo15588p(4, bundle);
                            HashMap hashMap = new HashMap();
                            hashMap.put("isBackButtonClick", "1");
                            hashMap.put("custom", BaseSOSWebViewUI.this.getInEditTextQuery());
                            BaseSOSWebViewUI.this.getJsapi().mo71889a(BaseSOSWebViewUI.this.getTotalQuery(), BaseSOSWebViewUI.this.getInEditTextQuery(), BaseSOSWebViewUI.this.dbB(), 1, c14595c.uAJ);
                            if (!TextUtils.isEmpty(BaseSOSWebViewUI.this.getInEditTextQuery())) {
                                C29744z.m47160a(BaseSOSWebViewUI.this.scene, BaseSOSWebViewUI.this.cvF, BaseSOSWebViewUI.this.cIy, true, BaseSOSWebViewUI.this.getInEditTextQuery(), BaseSOSWebViewUI.this.type);
                            }
                            AppMethodBeat.m2505o(8345);
                            return;
                        } catch (RemoteException e) {
                            C4990ab.m7413e("MicroMsg.FTS.BaseSOSWebViewUI", "ex %s", e.getMessage());
                        }
                    }
                    AppMethodBeat.m2505o(8345);
                }
            });
            AppMethodBeat.m2505o(8363);
        } else if (this.uAx) {
            dbu();
            AppMethodBeat.m2505o(8363);
        } else {
            finish();
            AppMethodBeat.m2505o(8363);
        }
    }

    /* Access modifiers changed, original: protected */
    public void dbs() {
    }

    /* Access modifiers changed, original: protected */
    public void dbt() {
    }

    /* Access modifiers changed, original: protected */
    public void dbu() {
        AppMethodBeat.m2504i(8364);
        this.uAs.mo36173n("", null);
        aqX();
        this.handler.post(new C2989017());
        this.uAt = null;
        this.uAx = false;
        this.uAv.onDestroy();
        AppMethodBeat.m2505o(8364);
    }

    public final boolean dax() {
        return true;
    }

    public final void bAR() {
        AppMethodBeat.m2504i(8365);
        if (!this.uAs.mLL.hasFocus()) {
            this.uAs.bBo();
            showVKB();
        }
        AppMethodBeat.m2505o(8365);
    }

    public final boolean dan() {
        return false;
    }

    /* Access modifiers changed, original: protected|final */
    public final int getType() {
        return this.type;
    }

    /* Access modifiers changed, original: protected|final */
    public final int bFf() {
        return this.scene;
    }

    /* renamed from: a */
    public void mo6403a(String str, String str2, List<C12071b> list, C20890b c20890b) {
        AppMethodBeat.m2504i(8366);
        C4990ab.m7417i("MicroMsg.FTS.BaseSOSWebViewUI", "onEditTextChange %s %s %s", str, str2, c20890b);
        if (c20890b == C20890b.UserInput || c20890b == C20890b.ClearText) {
            this.handler.post(new C2989218());
            AppMethodBeat.m2505o(8366);
            return;
        }
        if (c20890b == C20890b.SetText) {
            if (this.uAs.mLL.hasFocus()) {
                this.uAs.bBt();
                AppMethodBeat.m2505o(8366);
                return;
            }
            this.uAs.bBs();
        }
        AppMethodBeat.m2505o(8366);
    }

    /* renamed from: hz */
    public void mo25276hz(boolean z) {
        AppMethodBeat.m2504i(8367);
        if (z && !C5046bo.isNullOrNil(getTotalQuery())) {
            this.handler.post(new C2294919());
        }
        AppMethodBeat.m2505o(8367);
    }

    public void onClickClearTextBtn(View view) {
        AppMethodBeat.m2504i(8368);
        if (this.uAs != null) {
            if (!this.uAs.mLL.hasFocus()) {
                this.uAs.bBo();
                showVKB();
            }
            this.uAs.setHint(getHint());
        }
        AppMethodBeat.m2505o(8368);
    }

    /* Access modifiers changed, original: protected */
    public String getHint() {
        return null;
    }

    public boolean aMo() {
        AppMethodBeat.m2504i(8369);
        this.uAs.mLL.clearFocus();
        aqX();
        if (getTotalQuery().length() > 0) {
            this.handler.post(new C356562());
            aqX();
            this.uAx = true;
            AppMethodBeat.m2505o(8369);
        } else {
            AppMethodBeat.m2505o(8369);
        }
        return true;
    }

    /* Access modifiers changed, original: protected */
    public void dbv() {
    }

    /* Access modifiers changed, original: protected */
    public String dbw() {
        return "";
    }

    /* Access modifiers changed, original: protected */
    public int dbx() {
        return 0;
    }

    public final SOSEditTextView dby() {
        return this.uAs;
    }

    public final boolean aYb() {
        return false;
    }

    public final void dai() {
        AppMethodBeat.m2504i(8370);
        cGC();
        AppMethodBeat.m2505o(8370);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(8371);
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
        AppMethodBeat.m2505o(8371);
    }

    /* renamed from: j */
    public void mo9685j(int i, Bundle bundle) {
        int i2 = 0;
        AppMethodBeat.m2504i(8372);
        final String string;
        final String string2;
        switch (i) {
            case 60:
                if (dbD()) {
                    this.uAv.mo48161b(bundle, this.scene);
                    AppMethodBeat.m2505o(8372);
                    return;
                }
                C4990ab.m7420w("MicroMsg.FTS.BaseSOSWebViewUI", "current state is not search");
                AppMethodBeat.m2505o(8372);
                return;
            case PlayerException.EXCEPTION_TYPE_INITLIB /*61*/:
                this.uAv.mo48158aj(bundle);
                AppMethodBeat.m2505o(8372);
                return;
            case 62:
                this.uAv.mo48159ak(bundle);
                AppMethodBeat.m2505o(8372);
                return;
            case C31128d.MIC_AVROUND_BLUR /*119*/:
                final String string3 = bundle.getString("fts_key_json_data");
                final String string4 = bundle.getString("fts_key_req_id");
                final boolean z = bundle.getBoolean("fts_key_new_query", true);
                final Bundle bundle2 = bundle.getBundle("fts_key_data");
                this.handler.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(8334);
                        if (BaseSOSWebViewUI.this.getJsapi() != null) {
                            if (bundle2 == null || bundle2.getInt("isRefresh") != 1 || bundle2.getString("widgetId") == null) {
                                BaseSOSWebViewUI.this.getJsapi().mo71931h(string3, z, string4);
                            } else {
                                BaseSOSWebViewUI.this.getJsapi().mo71932hj(bundle2.getString("widgetId"), string3);
                                AppMethodBeat.m2505o(8334);
                                return;
                            }
                        }
                        AppMethodBeat.m2505o(8334);
                    }
                });
                AppMethodBeat.m2505o(8372);
                return;
            case 120:
                i2 = bundle.getInt("fts_key_ret", 0);
                string = bundle.getString("fts_key_data");
                this.handler.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(8336);
                        if (BaseSOSWebViewUI.this.getJsapi() != null) {
                            BaseSOSWebViewUI.this.getJsapi().mo71909bH(i2, string);
                        }
                        AppMethodBeat.m2505o(8336);
                    }
                });
                AppMethodBeat.m2505o(8372);
                return;
            case 121:
                string = bundle.getString("fts_key_json_data");
                final int i3 = bundle.getInt("fts_key_teach_request_type", 0);
                i2 = bundle.getInt("fts_key_is_cache_data", 0);
                this.handler.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(8337);
                        if (BaseSOSWebViewUI.this.getJsapi() != null) {
                            BaseSOSWebViewUI.this.getJsapi().mo71936n(i3, string, i2);
                        }
                        AppMethodBeat.m2505o(8337);
                    }
                });
                AppMethodBeat.m2505o(8372);
                return;
            case 122:
                string = bundle.getString("fts_key_new_query");
                String string5 = bundle.getString("fts_key_custom_query");
                boolean z2 = bundle.getBoolean("fts_key_need_keyboard", false);
                String string6 = bundle.getString("fts_key_tag_list");
                C4990ab.m7417i("MicroMsg.FTS.BaseSOSWebViewUI", "onFTSSearchQueryChange: totalQuery: %s isInputChange %b", string, Boolean.valueOf(z2));
                ArrayList arrayList = new ArrayList();
                try {
                    if (!C5046bo.isNullOrNil(string6)) {
                        JSONArray jSONArray = new JSONArray(string6);
                        while (i2 < jSONArray.length()) {
                            JSONObject jSONObject = jSONArray.getJSONObject(i2);
                            C29896a c29896a = new C29896a();
                            c29896a.rMJ = jSONObject.getString("tagName");
                            c29896a.aTq = jSONObject.getInt("tagType");
                            c29896a.userName = jSONObject.getString("userName");
                            arrayList.add(c29896a);
                            i2++;
                        }
                    }
                } catch (Exception e) {
                }
                if (this.uAs != null) {
                    if (arrayList.size() > 0) {
                        this.uAs.mo36173n(string5, arrayList);
                    } else {
                        this.uAs.mo36173n(string, arrayList);
                    }
                }
                if (z2) {
                    this.handler.post(new C298948());
                    if (this.uAs != null) {
                        this.uAs.bBo();
                    }
                    daE();
                } else if (this.uAs != null) {
                    this.uAs.mLL.clearFocus();
                }
                C4539a.cWt();
                C4539a.aeb(getTotalQuery());
                AppMethodBeat.m2505o(8372);
                return;
            case 124:
                string2 = bundle.getString("fts_key_json_data");
                this.handler.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(8339);
                        if (BaseSOSWebViewUI.this.getJsapi() != null) {
                            BaseSOSWebViewUI.this.getJsapi().agq(string2);
                        }
                        AppMethodBeat.m2505o(8339);
                    }
                });
                AppMethodBeat.m2505o(8372);
                return;
            case 125:
                string = bundle.getString("fts_key_sns_id");
                i2 = bundle.getInt("fts_key_status", 0);
                this.handler.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(8340);
                        if (BaseSOSWebViewUI.this.getJsapi() != null) {
                            BaseSOSWebViewUI.this.getJsapi().mo71920dN(string, i2);
                        }
                        AppMethodBeat.m2505o(8340);
                    }
                });
                AppMethodBeat.m2505o(8372);
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
                        AppMethodBeat.m2504i(8333);
                        if (BaseSOSWebViewUI.this.getJsapi() != null) {
                            BaseSOSWebViewUI.this.getJsapi().mo71898aO(hashMap);
                        }
                        AppMethodBeat.m2505o(8333);
                    }
                });
                AppMethodBeat.m2505o(8372);
                return;
            case 138:
                string = bundle.getString("fts_key_data");
                if (C5046bo.isNullOrNil(string)) {
                    this.uAu = 0;
                    AppMethodBeat.m2505o(8372);
                    return;
                } else if (C8741b.INDEX.equals(string)) {
                    this.uAu = 1;
                    AppMethodBeat.m2505o(8372);
                    return;
                } else if ("result".equals(string)) {
                    this.uAu = 2;
                    AppMethodBeat.m2505o(8372);
                    return;
                } else if ("suggestion".equals(string)) {
                    this.uAu = 3;
                    AppMethodBeat.m2505o(8372);
                    return;
                } else if ("teach".equals(string)) {
                    this.uAu = 4;
                    AppMethodBeat.m2505o(8372);
                    return;
                } else if (ImagesContract.LOCAL.equals(string)) {
                    this.uAu = 5;
                    AppMethodBeat.m2505o(8372);
                    return;
                } else {
                    this.uAu = 0;
                    AppMethodBeat.m2505o(8372);
                    return;
                }
            case ErrorCode.NEEDDOWNLOAD_4 /*143*/:
                string22 = bundle.getString("data");
                this.handler.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(8335);
                        if (BaseSOSWebViewUI.this.getJsapi() != null) {
                            C44786d jsapi = BaseSOSWebViewUI.this.getJsapi();
                            String str = string22;
                            if (jsapi.ready) {
                                C4990ab.m7416i("MicroMsg.JsApiHandler", "onSearchHistoryReady success, ready");
                                try {
                                    C5004al.m7441d(new C3568835(C23124a.m35498a("onSearchHistoryReady", new JSONObject(str), jsapi.uFv, jsapi.uFw)));
                                    AppMethodBeat.m2505o(8335);
                                    return;
                                } catch (JSONException e) {
                                    C4990ab.printErrStackTrace("MicroMsg.JsApiHandler", e, "", new Object[0]);
                                }
                            } else {
                                C4990ab.m7412e("MicroMsg.JsApiHandler", "onSearchHistoryReady fail, not ready");
                                AppMethodBeat.m2505o(8335);
                                return;
                            }
                        }
                        AppMethodBeat.m2505o(8335);
                    }
                });
                AppMethodBeat.m2505o(8372);
                return;
            case 144:
                AppMethodBeat.m2505o(8372);
                return;
            case ErrorCode.NEEDDOWNLOAD_8 /*147*/:
                final int i4 = bundle.getInt("ret");
                final long j = bundle.getLong("reqId");
                final String string7 = bundle.getString("json", "");
                this.handler.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(8341);
                        if (BaseSOSWebViewUI.this.uhz != null) {
                            BaseSOSWebViewUI.this.uhz.mo71882a(i4, j, string7);
                            C4990ab.m7417i("MicroMsg.FTS.BaseSOSWebViewUI", "wxaapp_opsearch resp, ret = %d, reqId = %d, json = %s", Integer.valueOf(i4), Long.valueOf(j), string7);
                        }
                        AppMethodBeat.m2505o(8341);
                    }
                });
                AppMethodBeat.m2505o(8372);
                return;
            case 100001:
                this.uAv.mo48157ai(bundle);
                AppMethodBeat.m2505o(8372);
                return;
            default:
                super.mo9685j(i, bundle);
                AppMethodBeat.m2505o(8372);
                return;
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final C29915e dbz() {
        return this.uAv;
    }

    /* Access modifiers changed, original: protected|final */
    public final String getTotalQuery() {
        AppMethodBeat.m2504i(8373);
        String totalQuery;
        if (this.uAs != null) {
            totalQuery = this.uAs.getTotalQuery();
            AppMethodBeat.m2505o(8373);
            return totalQuery;
        }
        totalQuery = "";
        AppMethodBeat.m2505o(8373);
        return totalQuery;
    }

    /* Access modifiers changed, original: protected|final */
    public final int dbA() {
        return this.uAO;
    }

    /* Access modifiers changed, original: protected|final */
    public final String getInEditTextQuery() {
        AppMethodBeat.m2504i(8374);
        String inEditTextQuery = this.uAs.getInEditTextQuery();
        AppMethodBeat.m2505o(8374);
        return inEditTextQuery;
    }

    public final JSONArray dbB() {
        AppMethodBeat.m2504i(8375);
        List<C12071b> tagList = this.uAs.getTagList();
        JSONArray jSONArray = new JSONArray();
        for (C12071b c12071b : tagList) {
            C29896a c29896a = (C29896a) c12071b;
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("tagName", c29896a.rMJ);
                jSONObject.put("tagType", c29896a.aTq);
                jSONObject.put("userName", c29896a.userName);
                jSONArray.put(jSONObject);
            } catch (JSONException e) {
            }
        }
        AppMethodBeat.m2505o(8375);
        return jSONArray;
    }

    public void onBackPressed() {
        AppMethodBeat.m2504i(8376);
        cGC();
        AppMethodBeat.m2505o(8376);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: b */
    public final void mo9681b(int i, String str, Map<String, Object> map) {
        C14595c c14595c;
        AppMethodBeat.m2504i(8377);
        C4990ab.m7419v("MicroMsg.FTS.BaseSOSWebViewUI", "adding history cgi params type %d, inEditQuery %s, params %s", Integer.valueOf(i), str, map);
        int i2 = this.uAO;
        this.uAO = i;
        if (i2 != i) {
            dbt();
        }
        if (this.uAt == null) {
            this.uAt = new ArrayList();
        }
        if (getTotalQuery().length() > 0) {
            c14595c = new C14595c();
            c14595c.type = this.uAO;
            c14595c.kPL = new ArrayList(this.uAs.getTagList());
            c14595c.uAI = this.uAs.getInEditTextQuery();
            c14595c.uAH = this.uAs.getTotalQuery();
            if (this.uAt.size() == 0) {
                this.uAt.add(c14595c);
            } else if (!c14595c.equals((C14595c) this.uAt.get(0))) {
                this.uAt.add(0, c14595c);
            }
        }
        if (!(this.uAt == null || this.uAt.isEmpty())) {
            C14595c c14595c2 = (C14595c) this.uAt.get(0);
            c14595c = new C14595c();
            c14595c.type = i;
            c14595c.uAH = str;
            c14595c.uAJ = map;
            if (c14595c2 != null) {
                int i3;
                if (c14595c2 == c14595c) {
                    i3 = 1;
                } else {
                    c14595c = c14595c;
                    i3 = (c14595c.type == c14595c2.type && c14595c.uAH.trim().equals(c14595c2.uAH.trim())) ? 1 : 0;
                }
                if (i3 != 0) {
                    c14595c2.uAJ = map;
                }
            }
        }
        AppMethodBeat.m2505o(8377);
    }

    public boolean dbC() {
        return false;
    }

    /* Access modifiers changed, original: protected */
    public boolean dbD() {
        return true;
    }

    /* renamed from: JA */
    public final String mo56361JA(int i) {
        AppMethodBeat.m2504i(8378);
        try {
            Bundle bundle = new Bundle();
            bundle.putString("key", "educationTab");
            Bundle p = this.icy.mo15588p(2, bundle);
            String string = p.getString("result");
            String string2 = p.getString("result_1");
            if (string2 != null) {
                string = string2;
            }
            JSONArray optJSONArray = new JSONObject(string).optJSONArray("items");
            if (optJSONArray == null) {
                string = "";
                AppMethodBeat.m2505o(8378);
                return string;
            }
            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
                if (optJSONObject.optInt("businessType") == i) {
                    string = optJSONObject.optString("hotword");
                    AppMethodBeat.m2505o(8378);
                    return string;
                }
            }
            string = "";
            AppMethodBeat.m2505o(8378);
            return string;
        } catch (Exception e) {
        }
    }
}
