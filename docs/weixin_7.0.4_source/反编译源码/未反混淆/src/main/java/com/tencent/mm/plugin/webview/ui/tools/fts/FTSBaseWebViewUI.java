package com.tencent.mm.plugin.webview.ui.tools.fts;

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
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.websearch.api.an;
import com.tencent.mm.plugin.websearch.api.h;
import com.tencent.mm.plugin.websearch.api.z;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vfs.e;
import com.tencent.qqmusic.mediaplayer.PlayerException;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import com.tencent.view.d;
import com.tencent.xweb.WebView;
import com.tencent.xweb.n;
import com.tencent.xweb.o;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class FTSBaseWebViewUI extends BaseSearchWebViewUI implements com.tencent.mm.plugin.fts.ui.widget.FTSEditTextView.a, com.tencent.mm.plugin.fts.ui.widget.a.a {
    protected com.tencent.mm.plugin.fts.ui.widget.a mIr;
    int scene;
    int type;
    private boolean uAT;
    private e uAv;
    private com.tencent.mm.plugin.webview.fts.d.a uAw;
    private boolean uzU;

    public class a implements com.tencent.mm.plugin.fts.ui.widget.a.b {
        int aTq;
        String rMJ;
        String userName;

        public final String getTagName() {
            return this.rMJ;
        }

        public final int compareTo(Object obj) {
            AppMethodBeat.i(8397);
            if (obj == null || !(obj instanceof a)) {
                AppMethodBeat.o(8397);
                return -1;
            }
            int compareTo = this.rMJ.compareTo(((a) obj).rMJ);
            AppMethodBeat.o(8397);
            return compareTo;
        }
    }

    class b extends a {
        private b() {
            super();
        }

        /* synthetic */ b(FTSBaseWebViewUI fTSBaseWebViewUI, byte b) {
            this();
        }

        public final void b(WebView webView, String str) {
            AppMethodBeat.i(8398);
            super.b(webView, str);
            ab.i("MicroMsg.FTS.FTSBaseWebViewUI", "onPageFinished %s", str);
            FTSBaseWebViewUI.this.showOptionMenu(false);
            if (!(FTSBaseWebViewUI.this.mIr == null || FTSBaseWebViewUI.this.uzU)) {
                FTSBaseWebViewUI.this.mIr.getFtsEditText().mLL.clearFocus();
                FTSBaseWebViewUI.this.aqX();
            }
            AppMethodBeat.o(8398);
        }

        public final void b(WebView webView, String str, Bitmap bitmap) {
            AppMethodBeat.i(8399);
            super.b(webView, str, bitmap);
            ab.i("MicroMsg.FTS.FTSBaseWebViewUI", "onPageStarted %s", str);
            FTSBaseWebViewUI.this.showOptionMenu(false);
            if (!(FTSBaseWebViewUI.this.mIr == null || FTSBaseWebViewUI.this.uzU)) {
                FTSBaseWebViewUI.this.mIr.getFtsEditText().mLL.clearFocus();
                FTSBaseWebViewUI.this.aqX();
            }
            an.reportIdKey649ForLook(FTSBaseWebViewUI.this.scene, 1);
            an.gp(FTSBaseWebViewUI.this.scene, 1);
            AppMethodBeat.o(8399);
        }

        public final o a(WebView webView, n nVar, Bundle bundle) {
            o aga;
            AppMethodBeat.i(8400);
            if (!(nVar == null || nVar.getUrl() == null || !nVar.getUrl().toString().startsWith("weixin://fts"))) {
                aga = aga(nVar.getUrl().toString());
                if (aga != null) {
                    AppMethodBeat.o(8400);
                    return aga;
                }
            }
            aga = super.a(webView, nVar);
            AppMethodBeat.o(8400);
            return aga;
        }

        public final o a(WebView webView, n nVar) {
            o aga;
            AppMethodBeat.i(8401);
            if (!(nVar == null || nVar.getUrl() == null || !nVar.getUrl().toString().startsWith("weixin://fts"))) {
                aga = aga(nVar.getUrl().toString());
                if (aga != null) {
                    AppMethodBeat.o(8401);
                    return aga;
                }
            }
            aga = super.a(webView, nVar);
            AppMethodBeat.o(8401);
            return aga;
        }

        public final o c(WebView webView, String str) {
            o aga;
            AppMethodBeat.i(8402);
            if (str.startsWith("weixin://fts")) {
                aga = aga(str);
                if (aga != null) {
                    AppMethodBeat.o(8402);
                    return aga;
                }
            }
            aga = super.c(webView, str);
            AppMethodBeat.o(8402);
            return aga;
        }

        private static o aga(String str) {
            InputStream openRead;
            AppMethodBeat.i(8403);
            ab.i("MicroMsg.FTS.FTSBaseWebViewUI", "url=%s | thread=%d", str, Long.valueOf(Thread.currentThread().getId()));
            try {
                openRead = e.openRead(Uri.parse(str).getQueryParameter("path"));
            } catch (Exception e) {
                openRead = null;
            }
            if (openRead != null) {
                o oVar = new o("image/*", "utf8", openRead);
                AppMethodBeat.o(8403);
                return oVar;
            }
            AppMethodBeat.o(8403);
            return null;
        }

        public final void a(WebView webView, int i, String str, String str2) {
            AppMethodBeat.i(8404);
            super.a(webView, i, str, str2);
            if (str2 != null && str2.equals(FTSBaseWebViewUI.this.cOG)) {
                an.reportIdKey649ForLook(FTSBaseWebViewUI.this.scene, 16);
            }
            AppMethodBeat.o(8404);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(8405);
        super.onCreate(bundle);
        this.uAw = new com.tencent.mm.plugin.webview.fts.d.a(this.pzf);
        this.uAv = new e(((h) g.K(h.class)).a(this.mController.ylL, this.uAw));
        xE(this.mController.ylL.getResources().getColor(R.color.vy));
        AppMethodBeat.o(8405);
    }

    public void aMh() {
        AppMethodBeat.i(8406);
        super.aMh();
        String trim = bo.bc(getIntent().getStringExtra("ftsQuery"), "").trim();
        this.type = getIntent().getIntExtra("ftsType", 0);
        this.scene = getIntent().getIntExtra("ftsbizscene", 0);
        this.uzU = getIntent().getBooleanExtra("ftsneedkeyboard", false);
        this.uAT = getIntent().getBooleanExtra("ftscaneditable", true);
        this.pzf.setWebViewClient(new b(this, (byte) 0));
        this.pzf.setOnTouchListener(new OnTouchListener() {
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(8384);
                FTSBaseWebViewUI.this.aqX();
                AppMethodBeat.o(8384);
                return false;
            }
        });
        if (this.uAT) {
            this.mIr = new com.tencent.mm.plugin.fts.ui.widget.a(this);
            this.mIr.setSearchViewListener(this);
            this.mIr.getFtsEditText().setHint(getHint());
            this.mIr.getFtsEditText().setFtsEditTextListener(this);
            getSupportActionBar().setCustomView(this.mIr);
            if (!bo.isNullOrNil(trim)) {
                this.mIr.getFtsEditText().n(trim, null);
            }
            if (this.uzU) {
                this.mIr.getFtsEditText().bBo();
                this.mIr.getFtsEditText().bBn();
            }
        }
        showOptionMenu(false);
        if (dao() != null) {
            dao().nM(true);
        }
        this.pzf.setOnLongClickListener(new OnLongClickListener() {
            public final boolean onLongClick(View view) {
                return true;
            }
        });
        this.uAw.uhz = this.uhz;
        AppMethodBeat.o(8406);
    }

    private void cGC() {
        AppMethodBeat.i(8407);
        aqX();
        finish();
        overridePendingTransition(0, 0);
        AppMethodBeat.o(8407);
    }

    public final int dam() {
        return R.raw.actionbar_icon_dark_back;
    }

    public final boolean dax() {
        return true;
    }

    /* Access modifiers changed, original: protected|final */
    public final String getTotalQuery() {
        AppMethodBeat.i(8408);
        String totalQuery = this.mIr.getFtsEditText().getTotalQuery();
        AppMethodBeat.o(8408);
        return totalQuery;
    }

    /* Access modifiers changed, original: protected|final */
    public final String getInEditTextQuery() {
        AppMethodBeat.i(8409);
        String inEditTextQuery = this.mIr.getFtsEditText().getInEditTextQuery();
        AppMethodBeat.o(8409);
        return inEditTextQuery;
    }

    public final boolean dan() {
        return false;
    }

    public void onClickBackBtn(View view) {
        AppMethodBeat.i(8410);
        cGC();
        AppMethodBeat.o(8410);
    }

    public final void bAR() {
        AppMethodBeat.i(8411);
        if (!this.mIr.getFtsEditText().mLL.hasFocus()) {
            this.mIr.getFtsEditText().bBo();
            showVKB();
        }
        AppMethodBeat.o(8411);
    }

    public void onResume() {
        AppMethodBeat.i(8412);
        super.onResume();
        this.uAv.onResume();
        AppMethodBeat.o(8412);
    }

    public void onPause() {
        AppMethodBeat.i(8413);
        super.onPause();
        this.uAv.onPause();
        AppMethodBeat.o(8413);
    }

    public void a(String str, String str2, List<com.tencent.mm.plugin.fts.ui.widget.a.b> list, com.tencent.mm.plugin.fts.ui.widget.FTSEditTextView.b bVar) {
        AppMethodBeat.i(8414);
        ab.i("MicroMsg.FTS.FTSBaseWebViewUI", "onEditTextChange %s %s %s", str, str2, bVar);
        if (bVar == com.tencent.mm.plugin.fts.ui.widget.FTSEditTextView.b.UserInput || bVar == com.tencent.mm.plugin.fts.ui.widget.FTSEditTextView.b.ClearText) {
            this.handler.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(8390);
                    if (FTSBaseWebViewUI.this.uhz != null) {
                        FTSBaseWebViewUI.this.uhz.a(FTSBaseWebViewUI.this.getTotalQuery(), FTSBaseWebViewUI.this.getInEditTextQuery(), FTSBaseWebViewUI.this.dbB(), 0);
                    }
                    AppMethodBeat.o(8390);
                }
            });
        }
        AppMethodBeat.o(8414);
    }

    public final void hz(boolean z) {
        AppMethodBeat.i(8415);
        if (z) {
            this.handler.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(8391);
                    if (FTSBaseWebViewUI.this.uhz != null) {
                        FTSBaseWebViewUI.this.uhz.a(FTSBaseWebViewUI.this.getTotalQuery(), FTSBaseWebViewUI.this.getInEditTextQuery(), FTSBaseWebViewUI.this.dbB(), 0);
                    }
                    AppMethodBeat.o(8391);
                }
            });
        }
        AppMethodBeat.o(8415);
    }

    public void onClickClearTextBtn(View view) {
        AppMethodBeat.i(8416);
        if (this.mIr != null) {
            if (!this.mIr.getFtsEditText().mLL.hasFocus()) {
                this.mIr.getFtsEditText().bBo();
                showVKB();
            }
            this.mIr.getFtsEditText().setHint(getHint());
        }
        AppMethodBeat.o(8416);
    }

    public boolean aMo() {
        AppMethodBeat.i(8417);
        ab.i("MicroMsg.FTS.FTSBaseWebViewUI", "onSearchKeyDown");
        if (getTotalQuery().length() > 0) {
            this.handler.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(8392);
                    if (FTSBaseWebViewUI.this.uhz != null) {
                        FTSBaseWebViewUI.this.uhz.a(FTSBaseWebViewUI.this.getTotalQuery(), FTSBaseWebViewUI.this.getInEditTextQuery(), FTSBaseWebViewUI.this.dbB(), 0, null);
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
                            z.a(g, str, str2, z, FTSBaseWebViewUI.this.getInEditTextQuery(), FTSBaseWebViewUI.this.type);
                        }
                    }
                    AppMethodBeat.o(8392);
                }
            });
            aqX();
        }
        AppMethodBeat.o(8417);
        return false;
    }

    public final JSONArray dbB() {
        AppMethodBeat.i(8418);
        List<com.tencent.mm.plugin.fts.ui.widget.a.b> tagList = this.mIr.getFtsEditText().getTagList();
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
        AppMethodBeat.o(8418);
        return jSONArray;
    }

    public void j(int i, Bundle bundle) {
        int i2 = 0;
        AppMethodBeat.i(8419);
        final String string;
        final String string2;
        switch (i) {
            case 60:
                this.uAv.b(bundle, this.scene);
                AppMethodBeat.o(8419);
                return;
            case PlayerException.EXCEPTION_TYPE_INITLIB /*61*/:
                this.uAv.aj(bundle);
                AppMethodBeat.o(8419);
                return;
            case 62:
                this.uAv.ak(bundle);
                AppMethodBeat.o(8419);
                return;
            case d.MIC_AVROUND_BLUR /*119*/:
                final String string3 = bundle.getString("fts_key_json_data");
                final String string4 = bundle.getString("fts_key_req_id");
                final boolean z = bundle.getBoolean("fts_key_new_query", true);
                final Bundle bundle2 = bundle.getBundle("fts_key_data");
                this.handler.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(8394);
                        if (FTSBaseWebViewUI.this.uhz != null) {
                            if (bundle2 == null || bundle2.getInt("isRefresh") != 1 || bundle2.getString("widgetId") == null) {
                                FTSBaseWebViewUI.this.uhz.h(string3, z, string4);
                            } else {
                                FTSBaseWebViewUI.this.uhz.hj(bundle2.getString("widgetId"), string3);
                                AppMethodBeat.o(8394);
                                return;
                            }
                        }
                        AppMethodBeat.o(8394);
                    }
                });
                AppMethodBeat.o(8419);
                return;
            case 120:
                i2 = bundle.getInt("fts_key_ret", 0);
                string = bundle.getString("fts_key_data");
                this.handler.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(8395);
                        if (FTSBaseWebViewUI.this.uhz != null) {
                            FTSBaseWebViewUI.this.uhz.bH(i2, string);
                        }
                        AppMethodBeat.o(8395);
                    }
                });
                AppMethodBeat.o(8419);
                return;
            case 121:
                string = bundle.getString("fts_key_json_data");
                final int i3 = bundle.getInt("fts_key_teach_request_type", 0);
                i2 = bundle.getInt("fts_key_is_cache_data", 0);
                this.handler.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(8396);
                        if (FTSBaseWebViewUI.this.uhz != null) {
                            FTSBaseWebViewUI.this.uhz.n(i3, string, i2);
                        }
                        AppMethodBeat.o(8396);
                    }
                });
                AppMethodBeat.o(8419);
                return;
            case 122:
                string = bundle.getString("fts_key_new_query");
                String string5 = bundle.getString("fts_key_custom_query");
                boolean z2 = bundle.getBoolean("fts_key_need_keyboard", false);
                String string6 = bundle.getString("fts_key_tag_list");
                ab.i("MicroMsg.FTS.FTSBaseWebViewUI", "onFTSSearchQueryChange: totalQuery: %s isInputChange %b", string, Boolean.valueOf(z2));
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
                if (this.mIr != null) {
                    if (arrayList.size() > 0) {
                        this.mIr.getFtsEditText().n(string5, arrayList);
                    } else {
                        this.mIr.getFtsEditText().n(string, arrayList);
                    }
                }
                if (z2) {
                    this.handler.post(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(8385);
                            if (FTSBaseWebViewUI.this.uhz != null) {
                                FTSBaseWebViewUI.this.uhz.a(FTSBaseWebViewUI.this.getTotalQuery(), FTSBaseWebViewUI.this.getInEditTextQuery(), FTSBaseWebViewUI.this.dbB(), 0);
                            }
                            AppMethodBeat.o(8385);
                        }
                    });
                    if (this.mIr != null) {
                        this.mIr.getFtsEditText().bBo();
                    }
                    daE();
                    AppMethodBeat.o(8419);
                    return;
                } else if (this.mIr != null) {
                    this.mIr.getFtsEditText().mLL.clearFocus();
                    aqX();
                    AppMethodBeat.o(8419);
                    return;
                }
                break;
            case 124:
                string2 = bundle.getString("fts_key_json_data");
                this.handler.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(8386);
                        if (FTSBaseWebViewUI.this.uhz != null) {
                            FTSBaseWebViewUI.this.uhz.agq(string2);
                        }
                        AppMethodBeat.o(8386);
                    }
                });
                AppMethodBeat.o(8419);
                return;
            case 125:
                string = bundle.getString("fts_key_sns_id");
                i2 = bundle.getInt("fts_key_status", 0);
                this.handler.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(8387);
                        if (FTSBaseWebViewUI.this.uhz != null) {
                            FTSBaseWebViewUI.this.uhz.dN(string, i2);
                        }
                        AppMethodBeat.o(8387);
                    }
                });
                AppMethodBeat.o(8419);
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
                        AppMethodBeat.i(8393);
                        if (FTSBaseWebViewUI.this.uhz != null) {
                            FTSBaseWebViewUI.this.uhz.aO(hashMap);
                        }
                        AppMethodBeat.o(8393);
                    }
                });
                AppMethodBeat.o(8419);
                return;
            case 144:
                AppMethodBeat.o(8419);
                return;
            case ErrorCode.NEEDDOWNLOAD_8 /*147*/:
                final int i4 = bundle.getInt("ret");
                final long j = bundle.getLong("reqId");
                final String string7 = bundle.getString("json", "");
                this.handler.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(8388);
                        if (FTSBaseWebViewUI.this.uhz != null) {
                            FTSBaseWebViewUI.this.uhz.a(i4, j, string7);
                            ab.i("MicroMsg.FTS.FTSBaseWebViewUI", "wxaapp_opsearch resp, ret = %d, reqId = %d, json = %s", Integer.valueOf(i4), Long.valueOf(j), string7);
                        }
                        AppMethodBeat.o(8388);
                    }
                });
                AppMethodBeat.o(8419);
                return;
            case 100001:
                this.uAv.ai(bundle);
                AppMethodBeat.o(8419);
                return;
            default:
                super.j(i, bundle);
                break;
        }
        AppMethodBeat.o(8419);
    }

    /* Access modifiers changed, original: protected|final */
    public final e dbz() {
        return this.uAv;
    }

    public void onDestroy() {
        AppMethodBeat.i(8420);
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
        AppMethodBeat.o(8420);
    }

    /* Access modifiers changed, original: protected */
    public String getHint() {
        return null;
    }

    public final int getLayoutId() {
        return R.layout.a23;
    }

    public final boolean aYb() {
        return false;
    }

    public final void dai() {
        AppMethodBeat.i(8421);
        cGC();
        AppMethodBeat.o(8421);
    }

    public final int getForceOrientation() {
        return 1;
    }

    public void onClickCancelBtn(View view) {
        AppMethodBeat.i(8422);
        this.mIr.getFtsEditText().n("", null);
        this.handler.post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(8389);
                if (FTSBaseWebViewUI.this.uhz != null) {
                    FTSBaseWebViewUI.this.uhz.a(FTSBaseWebViewUI.this.getTotalQuery(), FTSBaseWebViewUI.this.getInEditTextQuery(), FTSBaseWebViewUI.this.dbB(), 1);
                }
                AppMethodBeat.o(8389);
            }
        });
        this.mIr.getFtsEditText().mLL.clearFocus();
        aqX();
        AppMethodBeat.o(8422);
    }
}
