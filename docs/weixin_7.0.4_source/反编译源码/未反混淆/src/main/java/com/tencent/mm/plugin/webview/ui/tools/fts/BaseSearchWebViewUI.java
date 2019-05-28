package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.os.Bundle;
import android.os.RemoteException;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.appbrand.jsapi.g.e;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.plugin.websearch.api.aa;
import com.tencent.mm.plugin.websearch.api.h;
import com.tencent.mm.plugin.websearch.api.x;
import com.tencent.mm.plugin.websearch.api.y;
import com.tencent.mm.plugin.websearch.api.z;
import com.tencent.mm.plugin.webview.fts.c.b.a;
import com.tencent.mm.plugin.webview.fts.c.b.b;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class BaseSearchWebViewUI extends LoadDataWebviewUI implements b {
    protected View emz;
    protected String hlm;
    private View iqO;
    protected String query;
    protected int scene;
    protected int type;
    protected boolean uAK;
    private com.tencent.mm.plugin.webview.fts.c.b uAL;
    private Set<a> uAM = new HashSet();
    protected int uAN;
    protected int uAO;
    protected String uAP;
    protected List<Runnable> uAQ;
    private Runnable uAR;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static /* synthetic */ void a(BaseSearchWebViewUI baseSearchWebViewUI, String str, String str2, int i, final boolean z) {
        if (baseSearchWebViewUI.emz != null) {
            baseSearchWebViewUI.bDG();
            ImageView imageView = (ImageView) baseSearchWebViewUI.emz.findViewById(R.id.vn);
            View findViewById = baseSearchWebViewUI.emz.findViewById(R.id.vm);
            if (str2.equals("loading")) {
                imageView.setVisibility(8);
                findViewById.setVisibility(0);
            } else {
                imageView.setVisibility(0);
                findViewById.setVisibility(8);
                if (str2.equals("success")) {
                    imageView.setImageResource(R.drawable.awb);
                } else if (str2.equals("fail")) {
                    imageView.setImageResource(R.drawable.bgw);
                } else {
                    imageView.setVisibility(8);
                }
            }
            TextView textView = (TextView) baseSearchWebViewUI.emz.findViewById(R.id.cx);
            LinearLayout linearLayout = (LinearLayout) baseSearchWebViewUI.emz.findViewById(R.id.vl);
            LayoutParams layoutParams = (LayoutParams) textView.getLayoutParams();
            if (imageView.getVisibility() == 8 && findViewById.getVisibility() == 8) {
                layoutParams.bottomMargin = baseSearchWebViewUI.getResources().getDimensionPixelSize(R.dimen.dy);
                linearLayout.setMinimumHeight(0);
            } else {
                layoutParams.bottomMargin = 0;
                linearLayout.setMinimumHeight(com.tencent.mm.bz.a.fromDPToPix(baseSearchWebViewUI, 120));
            }
            textView.setLayoutParams(layoutParams);
            textView.setText(str);
            baseSearchWebViewUI.emz.setOnTouchListener(new OnTouchListener() {
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    return z;
                }
            });
            baseSearchWebViewUI.emz.setVisibility(0);
            if (i > 0) {
                baseSearchWebViewUI.uAR = new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(8383);
                        BaseSearchWebViewUI.this.bDG();
                        AppMethodBeat.o(8383);
                    }
                };
                baseSearchWebViewUI.handler.postDelayed(baseSearchWebViewUI.uAR, (long) i);
            }
        }
    }

    public void onCreate(Bundle bundle) {
        boolean z = false;
        super.onCreate(bundle);
        if (getIntent() != null) {
            this.uAK = getIntent().getBooleanExtra("jumpto_sns_contact_page", false);
        }
        this.uAL = new com.tencent.mm.plugin.webview.fts.c.b(this.mController.ylL, this.pzf, this);
        this.scene = getIntent().getIntExtra("ftsbizscene", 0);
        this.uAN = this.scene;
        this.type = getIntent().getIntExtra("ftsType", 0);
        this.query = getIntent().getStringExtra("ftsQuery");
        this.uAP = getIntent().getStringExtra("tabId");
        this.hlm = getIntent().getStringExtra("searchId");
        this.uAO = this.type;
        int i = this.scene;
        String str = this.cvF;
        String str2 = this.cIy;
        if (this.type == 0) {
            z = true;
        }
        z.a(i, str, str2, z, this.query, this.type, this.uAP, this.uCf, this.hlm);
        if (aa.j(this, this.scene)) {
            ab.i("BaseSearchWebViewUI", "has location permission");
        } else {
            ab.i("BaseSearchWebViewUI", "request for grant location permission");
        }
        View inflate = View.inflate(this, R.layout.aq1, null);
        inflate.setBackgroundResource(R.color.a3p);
        inflate.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.emz = inflate;
        if (this.emz != null && (this.mController.contentView instanceof ViewGroup)) {
            ((ViewGroup) this.mController.contentView).addView(this.emz);
        }
        bDG();
    }

    /* Access modifiers changed, original: protected|final */
    public final void dbE() {
        boolean z;
        super.dbE();
        int i = this.scene;
        String str = this.cvF;
        String str2 = this.cIy;
        if (this.type == 0) {
            z = true;
        } else {
            z = false;
        }
        z.a(i, str, str2, z, this.query, this.type, this.uAP, this.uCf);
    }

    public void aMh() {
        super.aMh();
        this.uAL.uhz = getJsapi();
        if (getJsapi() == null || getJsapi().ready) {
            dbF();
            ab.d("BaseSearchWebViewUI", "jsapi ready");
            z.cUX();
        } else {
            getJsapi().a(new d.a() {
                public final void onReady() {
                    AppMethodBeat.i(8379);
                    BaseSearchWebViewUI.this.dbF();
                    ab.d("BaseSearchWebViewUI", "jsapi ready");
                    z.cUX();
                    AppMethodBeat.o(8379);
                }
            });
        }
        if (this.icy != null) {
            try {
                this.icy.g(51, new Bundle());
                return;
            } catch (RemoteException e) {
                ab.printErrStackTrace("BaseSearchWebViewUI", e, "", new Object[0]);
                return;
            }
        }
        ab.i("BaseSearchWebViewUI", "invoker is null, fail to invoke get geo");
    }

    private void dbF() {
        if (this.uAQ != null && !this.uAQ.isEmpty()) {
            ab.i("BaseSearchWebViewUI", "jsapi ready callback, running jsapi count %d", Integer.valueOf(new ArrayList(this.uAQ).size()));
            this.uAQ.clear();
            for (Runnable runnable : r0) {
                if (runnable != null) {
                    runnable.run();
                }
            }
        }
    }

    public final void a(a aVar) {
        this.uAM.add(aVar);
    }

    /* Access modifiers changed, original: protected */
    public void b(int i, String str, Map<String, Object> map) {
    }

    public void j(int i, Bundle bundle) {
        boolean z = true;
        String string;
        com.tencent.mm.plugin.webview.fts.c.b bVar;
        switch (i) {
            case e.CTRL_INDEX /*133*/:
                ah(bundle);
                return;
            case com.tencent.mm.plugin.appbrand.jsapi.g.d.CTRL_INDEX /*134*/:
                com.tencent.mm.plugin.websearch.widget.view.a.cVT().Ip(bundle.getInt("actionSheetId"));
                return;
            case com.tencent.mm.plugin.appbrand.jsapi.g.b.CTRL_INDEX /*135*/:
                b(bundle.getInt("FTS_KEY_onStartWebSearch_type", 0), bundle.getString("FTS_KEY_onStartWebSearch_query"), (Map) bundle.getSerializable("FTS_KEY_onStartWebSearch_params"));
                return;
            case 137:
                string = bundle.getString("fts_key_json_data");
                if (getJsapi() != null) {
                    try {
                        getJsapi().aP(new JSONObject(string));
                        return;
                    } catch (JSONException e) {
                        ab.printErrStackTrace("BaseSearchWebViewUI", e, "", new Object[0]);
                        return;
                    }
                }
                return;
            case 145:
                getJsapi().ap(bundle);
                return;
            case 148:
                final String string2 = bundle.getString("title", "");
                final String string3 = bundle.getString("icon", "");
                final int i2 = bundle.getInt(FFmpegMetadataRetriever.METADATA_KEY_DURATION, 500);
                if (bundle.getInt("mask", 0) <= 0) {
                    z = false;
                }
                this.handler.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(8380);
                        BaseSearchWebViewUI.a(BaseSearchWebViewUI.this, string2, string3, i2, z);
                        AppMethodBeat.o(8380);
                    }
                });
                return;
            case 149:
                string = bundle.getString("title", "");
                if (bundle.getInt("mask", 0) <= 0) {
                    z = false;
                }
                this.handler.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(8381);
                        BaseSearchWebViewUI.a(BaseSearchWebViewUI.this, string, "loading", -1, z);
                        AppMethodBeat.o(8381);
                    }
                });
                return;
            case 150:
                bDG();
                return;
            case 100002:
                e dbz = dbz();
                if (dbz != null) {
                    dbz.al(bundle);
                    return;
                }
                ab.e("BaseSearchWebViewUI", "can not find FTSSearchWidgetMgr to handle tapSearchWAWidgetView");
                getJsapi().a(bundle.getString(""), false, "can not find FTSSearchWidgetMgr to handle tapSearchWAWidgetView", bundle.getString("widgetId"));
                return;
            case 200000:
                bVar = this.uAL;
                if (bVar != null) {
                    bVar.G(ag(bundle), bundle.getString("viewProps"), bundle.getString("videoProps"));
                    return;
                }
                return;
            case 200001:
                bVar = this.uAL;
                if (bVar != null) {
                    bVar.H(ag(bundle), bundle.getString("viewProps"), bundle.getString("videoProps"));
                    return;
                }
                return;
            case 200002:
                bVar = this.uAL;
                if (bVar != null) {
                    bVar.ID(ag(bundle));
                    return;
                }
                return;
            case 200003:
                bVar = this.uAL;
                if (bVar != null) {
                    bVar.bC(ag(bundle), bundle.getString("type"));
                    return;
                }
                return;
            default:
                super.j(i, bundle);
                return;
        }
    }

    /* Access modifiers changed, original: protected */
    public e dbz() {
        return null;
    }

    private static int ag(Bundle bundle) {
        return bo.ank(bundle.getString("playerId"));
    }

    private void ah(Bundle bundle) {
        ArrayList arrayList = new ArrayList();
        String string = bundle.getString("title");
        String string2 = bundle.getString("desc");
        try {
            JSONArray jSONArray = new JSONArray(bundle.getString("items"));
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    boolean z;
                    y yVar = new y();
                    yVar.iconUrl = optJSONObject.optString("icon");
                    yVar.title = optJSONObject.optString("title");
                    if (optJSONObject.optInt("selected") == 1) {
                        z = true;
                    } else {
                        z = false;
                    }
                    yVar.gBF = z;
                    yVar.desc = optJSONObject.optString("desc");
                    arrayList.add(yVar);
                }
            }
        } catch (JSONException e) {
            ab.e("BaseSearchWebViewUI", bo.l(e));
        }
        ab.v("BaseSearchWebViewUI", "doShowSearchActionSheet args: title %s,subTitle %s,items %s", string, string2, r7);
        if (!arrayList.isEmpty()) {
            bundle.putInt("actionSheetId", ((h) g.K(h.class)).a(this, string, string2, arrayList, new x() {
                public final void go(int i, int i2) {
                    AppMethodBeat.i(8382);
                    if (BaseSearchWebViewUI.this.getJsapi() != null) {
                        BaseSearchWebViewUI.this.getJsapi().gA(i, i2);
                    }
                    AppMethodBeat.o(8382);
                }
            }));
        }
    }

    private void bDG() {
        if (this.emz != null) {
            this.emz.setVisibility(8);
            if (this.uAR != null) {
                this.handler.removeCallbacks(this.uAR);
                this.uAR = null;
            }
        }
    }

    public void onResume() {
        super.onResume();
        for (a wU : this.uAM) {
            wU.wU();
        }
    }

    public void onPause() {
        super.onPause();
        for (a wW : this.uAM) {
            wW.wW();
        }
    }

    public void onDestroy() {
        boolean z;
        super.onDestroy();
        for (a onDestroy : this.uAM) {
            onDestroy.onDestroy();
        }
        this.uAM.clear();
        int i = this.scene;
        String str = this.cvF;
        String str2 = this.cIy;
        if (this.type == 0) {
            z = true;
        } else {
            z = false;
        }
        z.a(i, str, str2, z, this.query, this.type, this.uCf);
        ab.d("BaseSearchWebViewUI", "onDestroy");
    }

    public final void s(View view, boolean z) {
        cWA();
        this.iqO = view;
        ViewGroup viewGroup = (ViewGroup) getWindow().getDecorView();
        viewGroup.addView(view, new ViewGroup.LayoutParams(-1, -1));
        view.setX(0.0f);
        view.setY(0.0f);
        if (com.tencent.mm.compatible.util.d.fP(19)) {
            viewGroup.setSystemUiVisibility(2);
        } else {
            viewGroup.setSystemUiVisibility(4098);
        }
        getWindow().addFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
        if (z) {
            setRequestedOrientation(0);
        }
    }

    public final void cWA() {
        if (this.iqO != null) {
            ViewGroup viewGroup = (ViewGroup) getWindow().getDecorView();
            viewGroup.setSystemUiVisibility(0);
            viewGroup.removeView(this.iqO);
            getWindow().clearFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
            if (getRequestedOrientation() == 0) {
                setRequestedOrientation(1);
            }
            this.iqO = null;
            for (a aDI : this.uAM) {
                aDI.aDI();
            }
        }
    }

    public void onBackPressed() {
        int i;
        int i2 = 0;
        Iterator it = this.uAM.iterator();
        while (true) {
            i = i2;
            if (!it.hasNext()) {
                break;
            }
            i2 = ((a) it.next()).wY() | i;
        }
        if (i == 0) {
            super.onBackPressed();
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 25) {
            for (a cWy : this.uAM) {
                cWy.cWy();
            }
        } else if (i == 24) {
            for (a cWy2 : this.uAM) {
                cWy2.cWz();
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* Access modifiers changed, original: protected|final */
    public final void ab(Runnable runnable) {
        if (getJsapi() == null || !getJsapi().ready) {
            ab.i("BaseSearchWebViewUI", "jsapi not ready, waiting");
            if (this.uAQ == null) {
                this.uAQ = new ArrayList();
            }
            this.uAQ.add(runnable);
            return;
        }
        runnable.run();
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        String str = "BaseSearchWebViewUI";
        String str2 = "onRequestPermissionsResult, granted ? %s";
        Object[] objArr = new Object[1];
        objArr[0] = iArr.length > 0 ? iArr[0] : "";
        ab.i(str, str2, objArr);
    }

    public final boolean aMj() {
        return true;
    }
}
