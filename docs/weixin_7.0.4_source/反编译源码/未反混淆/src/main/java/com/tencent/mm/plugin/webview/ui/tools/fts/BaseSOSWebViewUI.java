package com.tencent.mm.plugin.webview.ui.tools.fts;

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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.websearch.api.h;
import com.tencent.mm.plugin.websearch.api.z;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d.AnonymousClass35;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.fts.widget.SOSEditTextView;
import com.tencent.mm.vfs.e;
import com.tencent.qqmusic.mediaplayer.PlayerException;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import com.tencent.xweb.WebView;
import com.tencent.xweb.n;
import com.tencent.xweb.o;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class BaseSOSWebViewUI extends BaseSearchWebViewUI implements com.tencent.mm.plugin.fts.ui.widget.FTSEditTextView.a {
    protected ImageButton oOO;
    protected View qkP;
    View uAr;
    protected SOSEditTextView uAs;
    private List<c> uAt;
    protected int uAu = 0;
    private e uAv;
    private com.tencent.mm.plugin.webview.fts.d.a uAw;
    boolean uAx;
    boolean uAy;
    private boolean uzU;

    protected class c {
        List<com.tencent.mm.plugin.fts.ui.widget.a.b> kPL;
        int type;
        String uAH = "";
        String uAI = "";
        Map<String, Object> uAJ = new HashMap();

        protected c() {
            AppMethodBeat.i(8357);
            AppMethodBeat.o(8357);
        }

        public final boolean equals(Object obj) {
            AppMethodBeat.i(8358);
            if (this == obj) {
                AppMethodBeat.o(8358);
                return true;
            } else if (obj instanceof c) {
                c cVar = (c) obj;
                if (cVar.type == this.type && cVar.uAI.equals(this.uAI)) {
                    AppMethodBeat.o(8358);
                    return true;
                }
                AppMethodBeat.o(8358);
                return false;
            } else {
                AppMethodBeat.o(8358);
                return false;
            }
        }
    }

    public class a implements com.tencent.mm.plugin.fts.ui.widget.a.b {
        int aTq;
        String rMJ;
        String userName;

        public final String getTagName() {
            return this.rMJ;
        }

        public final int compareTo(Object obj) {
            AppMethodBeat.i(8350);
            if (obj == null || !(obj instanceof com.tencent.mm.plugin.webview.ui.tools.fts.FTSBaseWebViewUI.a)) {
                AppMethodBeat.o(8350);
                return -1;
            }
            int compareTo = this.rMJ.compareTo(((com.tencent.mm.plugin.webview.ui.tools.fts.FTSBaseWebViewUI.a) obj).rMJ);
            AppMethodBeat.o(8350);
            return compareTo;
        }
    }

    class b extends a {
        private b() {
            super();
        }

        /* synthetic */ b(BaseSOSWebViewUI baseSOSWebViewUI, byte b) {
            this();
        }

        public final void b(WebView webView, String str) {
            AppMethodBeat.i(8351);
            super.b(webView, str);
            ab.i("MicroMsg.FTS.BaseSOSWebViewUI", "scene %d, onPageFinished %s", Integer.valueOf(BaseSOSWebViewUI.this.scene), str);
            BaseSOSWebViewUI.this.showOptionMenu(false);
            if (!(BaseSOSWebViewUI.this.uAs == null || BaseSOSWebViewUI.this.uzU)) {
                BaseSOSWebViewUI.this.uAs.mLL.clearFocus();
                BaseSOSWebViewUI.this.aqX();
            }
            BaseSOSWebViewUI.this.uAy = true;
            BaseSOSWebViewUI.this.dbv();
            AppMethodBeat.o(8351);
        }

        public final void b(WebView webView, String str, Bitmap bitmap) {
            AppMethodBeat.i(8352);
            super.b(webView, str, bitmap);
            ab.i("MicroMsg.FTS.BaseSOSWebViewUI", "onPageStarted %s", str);
            BaseSOSWebViewUI.this.showOptionMenu(false);
            if (!(BaseSOSWebViewUI.this.uAs == null || BaseSOSWebViewUI.this.uzU)) {
                BaseSOSWebViewUI.this.uAs.mLL.clearFocus();
                BaseSOSWebViewUI.this.aqX();
            }
            AppMethodBeat.o(8352);
        }

        public final o a(WebView webView, n nVar, Bundle bundle) {
            o aga;
            AppMethodBeat.i(8353);
            if (!(nVar == null || nVar.getUrl() == null || !nVar.getUrl().toString().startsWith("weixin://fts"))) {
                aga = aga(nVar.getUrl().toString());
                if (aga != null) {
                    AppMethodBeat.o(8353);
                    return aga;
                }
            }
            aga = super.a(webView, nVar);
            AppMethodBeat.o(8353);
            return aga;
        }

        public final o a(WebView webView, n nVar) {
            o aga;
            AppMethodBeat.i(8354);
            if (!(nVar == null || nVar.getUrl() == null || !nVar.getUrl().toString().startsWith("weixin://fts"))) {
                aga = aga(nVar.getUrl().toString());
                if (aga != null) {
                    AppMethodBeat.o(8354);
                    return aga;
                }
            }
            aga = super.a(webView, nVar);
            AppMethodBeat.o(8354);
            return aga;
        }

        public final o c(WebView webView, String str) {
            o aga;
            AppMethodBeat.i(8355);
            if (str.startsWith("weixin://fts")) {
                aga = aga(str);
                if (aga != null) {
                    AppMethodBeat.o(8355);
                    return aga;
                }
            }
            aga = super.c(webView, str);
            AppMethodBeat.o(8355);
            return aga;
        }

        private static o aga(String str) {
            InputStream openRead;
            AppMethodBeat.i(8356);
            ab.i("MicroMsg.FTS.BaseSOSWebViewUI", "url=%s | thread=%d", str, Long.valueOf(Thread.currentThread().getId()));
            try {
                openRead = e.openRead(Uri.parse(str).getQueryParameter("path"));
            } catch (Exception e) {
                openRead = null;
            }
            if (openRead != null) {
                o oVar = new o("image/*", "utf8", openRead);
                AppMethodBeat.o(8356);
                return oVar;
            }
            AppMethodBeat.o(8356);
            return null;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(8359);
        super.onCreate(bundle);
        getSupportActionBar().hide();
        this.uAw = new com.tencent.mm.plugin.webview.fts.d.a(this.pzf);
        this.uAv = new e(((h) g.K(h.class)).a(this.mController.ylL, this.uAw));
        AppMethodBeat.o(8359);
    }

    public void aMh() {
        AppMethodBeat.i(8360);
        super.aMh();
        this.uzU = getIntent().getBooleanExtra("ftsneedkeyboard", false);
        this.uAr = findViewById(R.id.eoa);
        this.uAs = (SOSEditTextView) findViewById(R.id.eoc);
        this.uAs.setFtsEditTextListener(this);
        this.uAs.setHint(getHint());
        this.qkP = findViewById(R.id.axh);
        this.qkP.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(8331);
                BaseSOSWebViewUI.this.dbu();
                AppMethodBeat.o(8331);
            }
        });
        this.oOO = (ImageButton) findViewById(R.id.dfp);
        this.oOO.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(8342);
                BaseSOSWebViewUI.this.cGC();
                AppMethodBeat.o(8342);
            }
        });
        this.pzf.setWebViewClient(new b(this, (byte) 0));
        this.pzf.setOnTouchListener(new OnTouchListener() {
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(8343);
                BaseSOSWebViewUI.this.dby().getEditText().clearFocus();
                BaseSOSWebViewUI.this.aqX();
                AppMethodBeat.o(8343);
                return false;
            }
        });
        if (this.uzU) {
            this.mController.contentView.postDelayed(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(8344);
                    BaseSOSWebViewUI.this.dby().bBo();
                    BaseSOSWebViewUI.this.dby().bBn();
                    AppMethodBeat.o(8344);
                }
            }, 128);
        }
        if (dao() != null) {
            dao().nM(true);
        }
        this.pzf.setOnLongClickListener(new OnLongClickListener() {
            public final boolean onLongClick(View view) {
                return true;
            }
        });
        this.uAw.uhz = this.uhz;
        AppMethodBeat.o(8360);
    }

    public void onResume() {
        AppMethodBeat.i(8361);
        super.onResume();
        this.uAv.onResume();
        AppMethodBeat.o(8361);
    }

    public void onPause() {
        AppMethodBeat.i(8362);
        super.onPause();
        this.uAv.onPause();
        AppMethodBeat.o(8362);
    }

    public final String getSessionId() {
        return this.cvF;
    }

    /* Access modifiers changed, original: protected|final */
    public final void cGC() {
        AppMethodBeat.i(8363);
        aqX();
        if (this.uAt != null && this.uAt.size() > 1) {
            this.uAt.remove(0);
            final c cVar = (c) this.uAt.get(0);
            this.uAs.n(cVar.uAI, cVar.kPL);
            this.handler.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(8345);
                    if (BaseSOSWebViewUI.this.getJsapi() != null) {
                        BaseSOSWebViewUI.this.dbs();
                        BaseSOSWebViewUI.this.uAO = cVar.type;
                        BaseSOSWebViewUI.this.dbt();
                        Bundle bundle = new Bundle();
                        bundle.putInt("type", BaseSOSWebViewUI.this.uAO);
                        bundle.putBoolean("isHomePage", true);
                        bundle.putInt("scene", BaseSOSWebViewUI.this.bFf());
                        try {
                            BaseSOSWebViewUI.this.icy.p(4, bundle);
                            HashMap hashMap = new HashMap();
                            hashMap.put("isBackButtonClick", "1");
                            hashMap.put("custom", BaseSOSWebViewUI.this.getInEditTextQuery());
                            BaseSOSWebViewUI.this.getJsapi().a(BaseSOSWebViewUI.this.getTotalQuery(), BaseSOSWebViewUI.this.getInEditTextQuery(), BaseSOSWebViewUI.this.dbB(), 1, cVar.uAJ);
                            if (!TextUtils.isEmpty(BaseSOSWebViewUI.this.getInEditTextQuery())) {
                                z.a(BaseSOSWebViewUI.this.scene, BaseSOSWebViewUI.this.cvF, BaseSOSWebViewUI.this.cIy, true, BaseSOSWebViewUI.this.getInEditTextQuery(), BaseSOSWebViewUI.this.type);
                            }
                            AppMethodBeat.o(8345);
                            return;
                        } catch (RemoteException e) {
                            ab.e("MicroMsg.FTS.BaseSOSWebViewUI", "ex %s", e.getMessage());
                        }
                    }
                    AppMethodBeat.o(8345);
                }
            });
            AppMethodBeat.o(8363);
        } else if (this.uAx) {
            dbu();
            AppMethodBeat.o(8363);
        } else {
            finish();
            AppMethodBeat.o(8363);
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
        AppMethodBeat.i(8364);
        this.uAs.n("", null);
        aqX();
        this.handler.post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(8347);
                if (BaseSOSWebViewUI.this.getJsapi() != null) {
                    BaseSOSWebViewUI.this.ab(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(8346);
                            d jsapi = BaseSOSWebViewUI.this.getJsapi();
                            int i = BaseSOSWebViewUI.this.scene;
                            Map hashMap = new HashMap();
                            hashMap.put("isCancelButtonClick", Integer.valueOf(1));
                            hashMap.put("isInputChange", Integer.valueOf(1));
                            hashMap.put("scene", Integer.valueOf(i));
                            jsapi.a("onSearchInputChange", hashMap, null);
                            AppMethodBeat.o(8346);
                        }
                    });
                }
                AppMethodBeat.o(8347);
            }
        });
        this.uAt = null;
        this.uAx = false;
        this.uAv.onDestroy();
        AppMethodBeat.o(8364);
    }

    public final boolean dax() {
        return true;
    }

    public final void bAR() {
        AppMethodBeat.i(8365);
        if (!this.uAs.mLL.hasFocus()) {
            this.uAs.bBo();
            showVKB();
        }
        AppMethodBeat.o(8365);
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

    public void a(String str, String str2, List<com.tencent.mm.plugin.fts.ui.widget.a.b> list, com.tencent.mm.plugin.fts.ui.widget.FTSEditTextView.b bVar) {
        AppMethodBeat.i(8366);
        ab.i("MicroMsg.FTS.BaseSOSWebViewUI", "onEditTextChange %s %s %s", str, str2, bVar);
        if (bVar == com.tencent.mm.plugin.fts.ui.widget.FTSEditTextView.b.UserInput || bVar == com.tencent.mm.plugin.fts.ui.widget.FTSEditTextView.b.ClearText) {
            this.handler.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(8348);
                    if (BaseSOSWebViewUI.this.getJsapi() != null) {
                        BaseSOSWebViewUI.this.getJsapi().a(BaseSOSWebViewUI.this.getTotalQuery(), BaseSOSWebViewUI.this.getInEditTextQuery(), BaseSOSWebViewUI.this.dbB());
                    }
                    AppMethodBeat.o(8348);
                }
            });
            AppMethodBeat.o(8366);
            return;
        }
        if (bVar == com.tencent.mm.plugin.fts.ui.widget.FTSEditTextView.b.SetText) {
            if (this.uAs.mLL.hasFocus()) {
                this.uAs.bBt();
                AppMethodBeat.o(8366);
                return;
            }
            this.uAs.bBs();
        }
        AppMethodBeat.o(8366);
    }

    public void hz(boolean z) {
        AppMethodBeat.i(8367);
        if (z && !bo.isNullOrNil(getTotalQuery())) {
            this.handler.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(8349);
                    if (BaseSOSWebViewUI.this.getJsapi() != null) {
                        BaseSOSWebViewUI.this.getJsapi().a(BaseSOSWebViewUI.this.getTotalQuery(), BaseSOSWebViewUI.this.getInEditTextQuery(), BaseSOSWebViewUI.this.dbB());
                    }
                    AppMethodBeat.o(8349);
                }
            });
        }
        AppMethodBeat.o(8367);
    }

    public void onClickClearTextBtn(View view) {
        AppMethodBeat.i(8368);
        if (this.uAs != null) {
            if (!this.uAs.mLL.hasFocus()) {
                this.uAs.bBo();
                showVKB();
            }
            this.uAs.setHint(getHint());
        }
        AppMethodBeat.o(8368);
    }

    /* Access modifiers changed, original: protected */
    public String getHint() {
        return null;
    }

    public boolean aMo() {
        AppMethodBeat.i(8369);
        this.uAs.mLL.clearFocus();
        aqX();
        if (getTotalQuery().length() > 0) {
            this.handler.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(8332);
                    if (BaseSOSWebViewUI.this.getJsapi() != null) {
                        HashMap hashMap = new HashMap();
                        if (BaseSOSWebViewUI.this.dbx() != 0) {
                            hashMap.put("sugClickType", Integer.valueOf(BaseSOSWebViewUI.this.dbx()));
                            hashMap.put("sugId", BaseSOSWebViewUI.this.dbw());
                        }
                        d jsapi = BaseSOSWebViewUI.this.getJsapi();
                        String totalQuery = BaseSOSWebViewUI.this.getTotalQuery();
                        String inEditTextQuery = BaseSOSWebViewUI.this.getInEditTextQuery();
                        JSONArray dbB = BaseSOSWebViewUI.this.dbB();
                        Map hashMap2 = new HashMap();
                        hashMap2.putAll(hashMap);
                        hashMap2.put(SearchIntents.EXTRA_QUERY, totalQuery);
                        hashMap2.put("custom", inEditTextQuery);
                        hashMap2.put("tagList", dbB);
                        jsapi.a("onSearchInputConfirm", hashMap2, null);
                        if (!TextUtils.isEmpty(BaseSOSWebViewUI.this.getInEditTextQuery())) {
                            z.a(BaseSOSWebViewUI.this.uAN, BaseSOSWebViewUI.this.cvF, BaseSOSWebViewUI.this.cIy, true, BaseSOSWebViewUI.this.getInEditTextQuery(), BaseSOSWebViewUI.this.uAO);
                        }
                    }
                    AppMethodBeat.o(8332);
                }
            });
            aqX();
            this.uAx = true;
            AppMethodBeat.o(8369);
        } else {
            AppMethodBeat.o(8369);
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
        AppMethodBeat.i(8370);
        cGC();
        AppMethodBeat.o(8370);
    }

    public void onDestroy() {
        AppMethodBeat.i(8371);
        try {
            if (this.icy != null) {
                Bundle bundle = new Bundle();
                bundle.putInt("webview_id", hashCode());
                this.icy.j(1, bundle);
            }
            this.uAv.onDestroy();
        } catch (RemoteException e) {
        }
        aqX();
        super.onDestroy();
        AppMethodBeat.o(8371);
    }

    public void j(int i, Bundle bundle) {
        int i2 = 0;
        AppMethodBeat.i(8372);
        final String string;
        final String string2;
        switch (i) {
            case 60:
                if (dbD()) {
                    this.uAv.b(bundle, this.scene);
                    AppMethodBeat.o(8372);
                    return;
                }
                ab.w("MicroMsg.FTS.BaseSOSWebViewUI", "current state is not search");
                AppMethodBeat.o(8372);
                return;
            case PlayerException.EXCEPTION_TYPE_INITLIB /*61*/:
                this.uAv.aj(bundle);
                AppMethodBeat.o(8372);
                return;
            case 62:
                this.uAv.ak(bundle);
                AppMethodBeat.o(8372);
                return;
            case com.tencent.view.d.MIC_AVROUND_BLUR /*119*/:
                final String string3 = bundle.getString("fts_key_json_data");
                final String string4 = bundle.getString("fts_key_req_id");
                final boolean z = bundle.getBoolean("fts_key_new_query", true);
                final Bundle bundle2 = bundle.getBundle("fts_key_data");
                this.handler.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(8334);
                        if (BaseSOSWebViewUI.this.getJsapi() != null) {
                            if (bundle2 == null || bundle2.getInt("isRefresh") != 1 || bundle2.getString("widgetId") == null) {
                                BaseSOSWebViewUI.this.getJsapi().h(string3, z, string4);
                            } else {
                                BaseSOSWebViewUI.this.getJsapi().hj(bundle2.getString("widgetId"), string3);
                                AppMethodBeat.o(8334);
                                return;
                            }
                        }
                        AppMethodBeat.o(8334);
                    }
                });
                AppMethodBeat.o(8372);
                return;
            case 120:
                i2 = bundle.getInt("fts_key_ret", 0);
                string = bundle.getString("fts_key_data");
                this.handler.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(8336);
                        if (BaseSOSWebViewUI.this.getJsapi() != null) {
                            BaseSOSWebViewUI.this.getJsapi().bH(i2, string);
                        }
                        AppMethodBeat.o(8336);
                    }
                });
                AppMethodBeat.o(8372);
                return;
            case 121:
                string = bundle.getString("fts_key_json_data");
                final int i3 = bundle.getInt("fts_key_teach_request_type", 0);
                i2 = bundle.getInt("fts_key_is_cache_data", 0);
                this.handler.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(8337);
                        if (BaseSOSWebViewUI.this.getJsapi() != null) {
                            BaseSOSWebViewUI.this.getJsapi().n(i3, string, i2);
                        }
                        AppMethodBeat.o(8337);
                    }
                });
                AppMethodBeat.o(8372);
                return;
            case 122:
                string = bundle.getString("fts_key_new_query");
                String string5 = bundle.getString("fts_key_custom_query");
                boolean z2 = bundle.getBoolean("fts_key_need_keyboard", false);
                String string6 = bundle.getString("fts_key_tag_list");
                ab.i("MicroMsg.FTS.BaseSOSWebViewUI", "onFTSSearchQueryChange: totalQuery: %s isInputChange %b", string, Boolean.valueOf(z2));
                ArrayList arrayList = new ArrayList();
                try {
                    if (!bo.isNullOrNil(string6)) {
                        JSONArray jSONArray = new JSONArray(string6);
                        while (i2 < jSONArray.length()) {
                            JSONObject jSONObject = jSONArray.getJSONObject(i2);
                            a aVar = new a();
                            aVar.rMJ = jSONObject.getString("tagName");
                            aVar.aTq = jSONObject.getInt("tagType");
                            aVar.userName = jSONObject.getString("userName");
                            arrayList.add(aVar);
                            i2++;
                        }
                    }
                } catch (Exception e) {
                }
                if (this.uAs != null) {
                    if (arrayList.size() > 0) {
                        this.uAs.n(string5, arrayList);
                    } else {
                        this.uAs.n(string, arrayList);
                    }
                }
                if (z2) {
                    this.handler.post(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(8338);
                            if (BaseSOSWebViewUI.this.getJsapi() != null) {
                                BaseSOSWebViewUI.this.getJsapi().a(BaseSOSWebViewUI.this.getTotalQuery(), BaseSOSWebViewUI.this.getInEditTextQuery(), BaseSOSWebViewUI.this.dbB());
                            }
                            AppMethodBeat.o(8338);
                        }
                    });
                    if (this.uAs != null) {
                        this.uAs.bBo();
                    }
                    daE();
                } else if (this.uAs != null) {
                    this.uAs.mLL.clearFocus();
                }
                com.tencent.mm.plugin.webview.fts.b.a.a.cWt();
                com.tencent.mm.plugin.webview.fts.b.a.a.aeb(getTotalQuery());
                AppMethodBeat.o(8372);
                return;
            case 124:
                string2 = bundle.getString("fts_key_json_data");
                this.handler.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(8339);
                        if (BaseSOSWebViewUI.this.getJsapi() != null) {
                            BaseSOSWebViewUI.this.getJsapi().agq(string2);
                        }
                        AppMethodBeat.o(8339);
                    }
                });
                AppMethodBeat.o(8372);
                return;
            case 125:
                string = bundle.getString("fts_key_sns_id");
                i2 = bundle.getInt("fts_key_status", 0);
                this.handler.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(8340);
                        if (BaseSOSWebViewUI.this.getJsapi() != null) {
                            BaseSOSWebViewUI.this.getJsapi().dN(string, i2);
                        }
                        AppMethodBeat.o(8340);
                    }
                });
                AppMethodBeat.o(8372);
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
                        AppMethodBeat.i(8333);
                        if (BaseSOSWebViewUI.this.getJsapi() != null) {
                            BaseSOSWebViewUI.this.getJsapi().aO(hashMap);
                        }
                        AppMethodBeat.o(8333);
                    }
                });
                AppMethodBeat.o(8372);
                return;
            case 138:
                string = bundle.getString("fts_key_data");
                if (bo.isNullOrNil(string)) {
                    this.uAu = 0;
                    AppMethodBeat.o(8372);
                    return;
                } else if (com.google.firebase.analytics.FirebaseAnalytics.b.INDEX.equals(string)) {
                    this.uAu = 1;
                    AppMethodBeat.o(8372);
                    return;
                } else if ("result".equals(string)) {
                    this.uAu = 2;
                    AppMethodBeat.o(8372);
                    return;
                } else if ("suggestion".equals(string)) {
                    this.uAu = 3;
                    AppMethodBeat.o(8372);
                    return;
                } else if ("teach".equals(string)) {
                    this.uAu = 4;
                    AppMethodBeat.o(8372);
                    return;
                } else if (ImagesContract.LOCAL.equals(string)) {
                    this.uAu = 5;
                    AppMethodBeat.o(8372);
                    return;
                } else {
                    this.uAu = 0;
                    AppMethodBeat.o(8372);
                    return;
                }
            case ErrorCode.NEEDDOWNLOAD_4 /*143*/:
                string22 = bundle.getString("data");
                this.handler.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(8335);
                        if (BaseSOSWebViewUI.this.getJsapi() != null) {
                            d jsapi = BaseSOSWebViewUI.this.getJsapi();
                            String str = string22;
                            if (jsapi.ready) {
                                ab.i("MicroMsg.JsApiHandler", "onSearchHistoryReady success, ready");
                                try {
                                    al.d(new AnonymousClass35(com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a.a("onSearchHistoryReady", new JSONObject(str), jsapi.uFv, jsapi.uFw)));
                                    AppMethodBeat.o(8335);
                                    return;
                                } catch (JSONException e) {
                                    ab.printErrStackTrace("MicroMsg.JsApiHandler", e, "", new Object[0]);
                                }
                            } else {
                                ab.e("MicroMsg.JsApiHandler", "onSearchHistoryReady fail, not ready");
                                AppMethodBeat.o(8335);
                                return;
                            }
                        }
                        AppMethodBeat.o(8335);
                    }
                });
                AppMethodBeat.o(8372);
                return;
            case 144:
                AppMethodBeat.o(8372);
                return;
            case ErrorCode.NEEDDOWNLOAD_8 /*147*/:
                final int i4 = bundle.getInt("ret");
                final long j = bundle.getLong("reqId");
                final String string7 = bundle.getString("json", "");
                this.handler.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(8341);
                        if (BaseSOSWebViewUI.this.uhz != null) {
                            BaseSOSWebViewUI.this.uhz.a(i4, j, string7);
                            ab.i("MicroMsg.FTS.BaseSOSWebViewUI", "wxaapp_opsearch resp, ret = %d, reqId = %d, json = %s", Integer.valueOf(i4), Long.valueOf(j), string7);
                        }
                        AppMethodBeat.o(8341);
                    }
                });
                AppMethodBeat.o(8372);
                return;
            case 100001:
                this.uAv.ai(bundle);
                AppMethodBeat.o(8372);
                return;
            default:
                super.j(i, bundle);
                AppMethodBeat.o(8372);
                return;
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final e dbz() {
        return this.uAv;
    }

    /* Access modifiers changed, original: protected|final */
    public final String getTotalQuery() {
        AppMethodBeat.i(8373);
        String totalQuery;
        if (this.uAs != null) {
            totalQuery = this.uAs.getTotalQuery();
            AppMethodBeat.o(8373);
            return totalQuery;
        }
        totalQuery = "";
        AppMethodBeat.o(8373);
        return totalQuery;
    }

    /* Access modifiers changed, original: protected|final */
    public final int dbA() {
        return this.uAO;
    }

    /* Access modifiers changed, original: protected|final */
    public final String getInEditTextQuery() {
        AppMethodBeat.i(8374);
        String inEditTextQuery = this.uAs.getInEditTextQuery();
        AppMethodBeat.o(8374);
        return inEditTextQuery;
    }

    public final JSONArray dbB() {
        AppMethodBeat.i(8375);
        List<com.tencent.mm.plugin.fts.ui.widget.a.b> tagList = this.uAs.getTagList();
        JSONArray jSONArray = new JSONArray();
        for (com.tencent.mm.plugin.fts.ui.widget.a.b bVar : tagList) {
            a aVar = (a) bVar;
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("tagName", aVar.rMJ);
                jSONObject.put("tagType", aVar.aTq);
                jSONObject.put("userName", aVar.userName);
                jSONArray.put(jSONObject);
            } catch (JSONException e) {
            }
        }
        AppMethodBeat.o(8375);
        return jSONArray;
    }

    public void onBackPressed() {
        AppMethodBeat.i(8376);
        cGC();
        AppMethodBeat.o(8376);
    }

    /* Access modifiers changed, original: protected|final */
    public final void b(int i, String str, Map<String, Object> map) {
        c cVar;
        AppMethodBeat.i(8377);
        ab.v("MicroMsg.FTS.BaseSOSWebViewUI", "adding history cgi params type %d, inEditQuery %s, params %s", Integer.valueOf(i), str, map);
        int i2 = this.uAO;
        this.uAO = i;
        if (i2 != i) {
            dbt();
        }
        if (this.uAt == null) {
            this.uAt = new ArrayList();
        }
        if (getTotalQuery().length() > 0) {
            cVar = new c();
            cVar.type = this.uAO;
            cVar.kPL = new ArrayList(this.uAs.getTagList());
            cVar.uAI = this.uAs.getInEditTextQuery();
            cVar.uAH = this.uAs.getTotalQuery();
            if (this.uAt.size() == 0) {
                this.uAt.add(cVar);
            } else if (!cVar.equals((c) this.uAt.get(0))) {
                this.uAt.add(0, cVar);
            }
        }
        if (!(this.uAt == null || this.uAt.isEmpty())) {
            c cVar2 = (c) this.uAt.get(0);
            cVar = new c();
            cVar.type = i;
            cVar.uAH = str;
            cVar.uAJ = map;
            if (cVar2 != null) {
                int i3;
                if (cVar2 == cVar) {
                    i3 = 1;
                } else {
                    cVar = cVar;
                    i3 = (cVar.type == cVar2.type && cVar.uAH.trim().equals(cVar2.uAH.trim())) ? 1 : 0;
                }
                if (i3 != 0) {
                    cVar2.uAJ = map;
                }
            }
        }
        AppMethodBeat.o(8377);
    }

    public boolean dbC() {
        return false;
    }

    /* Access modifiers changed, original: protected */
    public boolean dbD() {
        return true;
    }

    public final String JA(int i) {
        AppMethodBeat.i(8378);
        try {
            Bundle bundle = new Bundle();
            bundle.putString("key", "educationTab");
            Bundle p = this.icy.p(2, bundle);
            String string = p.getString("result");
            String string2 = p.getString("result_1");
            if (string2 != null) {
                string = string2;
            }
            JSONArray optJSONArray = new JSONObject(string).optJSONArray("items");
            if (optJSONArray == null) {
                string = "";
                AppMethodBeat.o(8378);
                return string;
            }
            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
                if (optJSONObject.optInt("businessType") == i) {
                    string = optJSONObject.optString("hotword");
                    AppMethodBeat.o(8378);
                    return string;
                }
            }
            string = "";
            AppMethodBeat.o(8378);
            return string;
        } catch (Exception e) {
        }
    }
}
