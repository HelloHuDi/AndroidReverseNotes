package com.tencent.p177mm.plugin.webview.p580ui.tools.fts;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.compatible.util.C1443d;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.plugin.appbrand.jsapi.p306g.C19392d;
import com.tencent.p177mm.plugin.appbrand.jsapi.p306g.C19394e;
import com.tencent.p177mm.plugin.appbrand.jsapi.p306g.C44697b;
import com.tencent.p177mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.p177mm.plugin.websearch.api.C14427x;
import com.tencent.p177mm.plugin.websearch.api.C29740h;
import com.tencent.p177mm.plugin.websearch.api.C29743y;
import com.tencent.p177mm.plugin.websearch.api.C29744z;
import com.tencent.p177mm.plugin.websearch.api.C46400aa;
import com.tencent.p177mm.plugin.websearch.widget.view.C43855a;
import com.tencent.p177mm.plugin.webview.fts.p752c.C43872b;
import com.tencent.p177mm.plugin.webview.fts.p752c.C43872b.C22790a;
import com.tencent.p177mm.plugin.webview.fts.p752c.C43872b.C22791b;
import com.tencent.p177mm.plugin.webview.p580ui.tools.jsapi.C44786d.C23001a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.webview.ui.tools.fts.BaseSearchWebViewUI */
public abstract class BaseSearchWebViewUI extends LoadDataWebviewUI implements C22791b {
    protected View emz;
    protected String hlm;
    private View iqO;
    protected String query;
    protected int scene;
    protected int type;
    protected boolean uAK;
    private C43872b uAL;
    private Set<C22790a> uAM = new HashSet();
    protected int uAN;
    protected int uAO;
    protected String uAP;
    protected List<Runnable> uAQ;
    private Runnable uAR;

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.fts.BaseSearchWebViewUI$4 */
    class C46004 implements C14427x {
        C46004() {
        }

        /* renamed from: go */
        public final void mo9690go(int i, int i2) {
            AppMethodBeat.m2504i(8382);
            if (BaseSearchWebViewUI.this.getJsapi() != null) {
                BaseSearchWebViewUI.this.getJsapi().mo71929gA(i, i2);
            }
            AppMethodBeat.m2505o(8382);
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.fts.BaseSearchWebViewUI$1 */
    class C46011 implements C23001a {
        C46011() {
        }

        public final void onReady() {
            AppMethodBeat.m2504i(8379);
            BaseSearchWebViewUI.this.dbF();
            C4990ab.m7410d("BaseSearchWebViewUI", "jsapi ready");
            C29744z.cUX();
            AppMethodBeat.m2505o(8379);
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.fts.BaseSearchWebViewUI$6 */
    class C46026 implements Runnable {
        C46026() {
        }

        public final void run() {
            AppMethodBeat.m2504i(8383);
            BaseSearchWebViewUI.this.bDG();
            AppMethodBeat.m2505o(8383);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    /* renamed from: a */
    static /* synthetic */ void m6966a(BaseSearchWebViewUI baseSearchWebViewUI, String str, String str2, int i, final boolean z) {
        if (baseSearchWebViewUI.emz != null) {
            baseSearchWebViewUI.bDG();
            ImageView imageView = (ImageView) baseSearchWebViewUI.emz.findViewById(2131821371);
            View findViewById = baseSearchWebViewUI.emz.findViewById(2131821370);
            if (str2.equals("loading")) {
                imageView.setVisibility(8);
                findViewById.setVisibility(0);
            } else {
                imageView.setVisibility(0);
                findViewById.setVisibility(8);
                if (str2.equals("success")) {
                    imageView.setImageResource(C25738R.drawable.awb);
                } else if (str2.equals("fail")) {
                    imageView.setImageResource(C25738R.drawable.bgw);
                } else {
                    imageView.setVisibility(8);
                }
            }
            TextView textView = (TextView) baseSearchWebViewUI.emz.findViewById(2131820678);
            LinearLayout linearLayout = (LinearLayout) baseSearchWebViewUI.emz.findViewById(2131821369);
            LayoutParams layoutParams = (LayoutParams) textView.getLayoutParams();
            if (imageView.getVisibility() == 8 && findViewById.getVisibility() == 8) {
                layoutParams.bottomMargin = baseSearchWebViewUI.getResources().getDimensionPixelSize(C25738R.dimen.f9732dy);
                linearLayout.setMinimumHeight(0);
            } else {
                layoutParams.bottomMargin = 0;
                linearLayout.setMinimumHeight(C1338a.fromDPToPix(baseSearchWebViewUI, 120));
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
                baseSearchWebViewUI.uAR = new C46026();
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
        this.uAL = new C43872b(this.mController.ylL, this.pzf, this);
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
        C29744z.m47162a(i, str, str2, z, this.query, this.type, this.uAP, this.uCf, this.hlm);
        if (C46400aa.m87337j(this, this.scene)) {
            C4990ab.m7416i("BaseSearchWebViewUI", "has location permission");
        } else {
            C4990ab.m7416i("BaseSearchWebViewUI", "request for grant location permission");
        }
        View inflate = View.inflate(this, 2130970569, null);
        inflate.setBackgroundResource(C25738R.color.a3p);
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
        C29744z.m47161a(i, str, str2, z, this.query, this.type, this.uAP, this.uCf);
    }

    public void aMh() {
        super.aMh();
        this.uAL.uhz = getJsapi();
        if (getJsapi() == null || getJsapi().ready) {
            dbF();
            C4990ab.m7410d("BaseSearchWebViewUI", "jsapi ready");
            C29744z.cUX();
        } else {
            getJsapi().mo71883a(new C46011());
        }
        if (this.icy != null) {
            try {
                this.icy.mo15575g(51, new Bundle());
                return;
            } catch (RemoteException e) {
                C4990ab.printErrStackTrace("BaseSearchWebViewUI", e, "", new Object[0]);
                return;
            }
        }
        C4990ab.m7416i("BaseSearchWebViewUI", "invoker is null, fail to invoke get geo");
    }

    private void dbF() {
        if (this.uAQ != null && !this.uAQ.isEmpty()) {
            C4990ab.m7417i("BaseSearchWebViewUI", "jsapi ready callback, running jsapi count %d", Integer.valueOf(new ArrayList(this.uAQ).size()));
            this.uAQ.clear();
            for (Runnable runnable : r0) {
                if (runnable != null) {
                    runnable.run();
                }
            }
        }
    }

    /* renamed from: a */
    public final void mo9679a(C22790a c22790a) {
        this.uAM.add(c22790a);
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: b */
    public void mo9681b(int i, String str, Map<String, Object> map) {
    }

    /* renamed from: j */
    public void mo9685j(int i, Bundle bundle) {
        boolean z = true;
        String string;
        C43872b c43872b;
        switch (i) {
            case C19394e.CTRL_INDEX /*133*/:
                m6968ah(bundle);
                return;
            case C19392d.CTRL_INDEX /*134*/:
                C43855a.cVT().mo69534Ip(bundle.getInt("actionSheetId"));
                return;
            case C44697b.CTRL_INDEX /*135*/:
                mo9681b(bundle.getInt("FTS_KEY_onStartWebSearch_type", 0), bundle.getString("FTS_KEY_onStartWebSearch_query"), (Map) bundle.getSerializable("FTS_KEY_onStartWebSearch_params"));
                return;
            case 137:
                string = bundle.getString("fts_key_json_data");
                if (getJsapi() != null) {
                    try {
                        getJsapi().mo71899aP(new JSONObject(string));
                        return;
                    } catch (JSONException e) {
                        C4990ab.printErrStackTrace("BaseSearchWebViewUI", e, "", new Object[0]);
                        return;
                    }
                }
                return;
            case 145:
                getJsapi().mo71907ap(bundle);
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
                        AppMethodBeat.m2504i(8380);
                        BaseSearchWebViewUI.m6966a(BaseSearchWebViewUI.this, string2, string3, i2, z);
                        AppMethodBeat.m2505o(8380);
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
                        AppMethodBeat.m2504i(8381);
                        BaseSearchWebViewUI.m6966a(BaseSearchWebViewUI.this, string, "loading", -1, z);
                        AppMethodBeat.m2505o(8381);
                    }
                });
                return;
            case 150:
                bDG();
                return;
            case 100002:
                C29915e dbz = dbz();
                if (dbz != null) {
                    dbz.mo48160al(bundle);
                    return;
                }
                C4990ab.m7412e("BaseSearchWebViewUI", "can not find FTSSearchWidgetMgr to handle tapSearchWAWidgetView");
                getJsapi().mo71891a(bundle.getString(""), false, "can not find FTSSearchWidgetMgr to handle tapSearchWAWidgetView", bundle.getString("widgetId"));
                return;
            case 200000:
                c43872b = this.uAL;
                if (c43872b != null) {
                    c43872b.mo38387G(BaseSearchWebViewUI.m6967ag(bundle), bundle.getString("viewProps"), bundle.getString("videoProps"));
                    return;
                }
                return;
            case 200001:
                c43872b = this.uAL;
                if (c43872b != null) {
                    c43872b.mo38388H(BaseSearchWebViewUI.m6967ag(bundle), bundle.getString("viewProps"), bundle.getString("videoProps"));
                    return;
                }
                return;
            case 200002:
                c43872b = this.uAL;
                if (c43872b != null) {
                    c43872b.mo38389ID(BaseSearchWebViewUI.m6967ag(bundle));
                    return;
                }
                return;
            case 200003:
                c43872b = this.uAL;
                if (c43872b != null) {
                    c43872b.mo38390bC(BaseSearchWebViewUI.m6967ag(bundle), bundle.getString("type"));
                    return;
                }
                return;
            default:
                super.mo9685j(i, bundle);
                return;
        }
    }

    /* Access modifiers changed, original: protected */
    public C29915e dbz() {
        return null;
    }

    /* renamed from: ag */
    private static int m6967ag(Bundle bundle) {
        return C5046bo.ank(bundle.getString("playerId"));
    }

    /* renamed from: ah */
    private void m6968ah(Bundle bundle) {
        ArrayList arrayList = new ArrayList();
        String string = bundle.getString("title");
        String string2 = bundle.getString("desc");
        try {
            JSONArray jSONArray = new JSONArray(bundle.getString("items"));
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    boolean z;
                    C29743y c29743y = new C29743y();
                    c29743y.iconUrl = optJSONObject.optString("icon");
                    c29743y.title = optJSONObject.optString("title");
                    if (optJSONObject.optInt("selected") == 1) {
                        z = true;
                    } else {
                        z = false;
                    }
                    c29743y.gBF = z;
                    c29743y.desc = optJSONObject.optString("desc");
                    arrayList.add(c29743y);
                }
            }
        } catch (JSONException e) {
            C4990ab.m7412e("BaseSearchWebViewUI", C5046bo.m7574l(e));
        }
        C4990ab.m7419v("BaseSearchWebViewUI", "doShowSearchActionSheet args: title %s,subTitle %s,items %s", string, string2, r7);
        if (!arrayList.isEmpty()) {
            bundle.putInt("actionSheetId", ((C29740h) C1720g.m3528K(C29740h.class)).mo47978a(this, string, string2, arrayList, new C46004()));
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
        for (C22790a wU : this.uAM) {
            wU.mo38384wU();
        }
    }

    public void onPause() {
        super.onPause();
        for (C22790a wW : this.uAM) {
            wW.mo38385wW();
        }
    }

    public void onDestroy() {
        boolean z;
        super.onDestroy();
        for (C22790a onDestroy : this.uAM) {
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
        C29744z.m47163a(i, str, str2, z, this.query, this.type, this.uCf);
        C4990ab.m7410d("BaseSearchWebViewUI", "onDestroy");
    }

    /* renamed from: s */
    public final void mo9686s(View view, boolean z) {
        cWA();
        this.iqO = view;
        ViewGroup viewGroup = (ViewGroup) getWindow().getDecorView();
        viewGroup.addView(view, new ViewGroup.LayoutParams(-1, -1));
        view.setX(0.0f);
        view.setY(0.0f);
        if (C1443d.m3067fP(19)) {
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
            for (C22790a aDI : this.uAM) {
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
            i2 = ((C22790a) it.next()).mo38386wY() | i;
        }
        if (i == 0) {
            super.onBackPressed();
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 25) {
            for (C22790a cWy : this.uAM) {
                cWy.cWy();
            }
        } else if (i == 24) {
            for (C22790a cWy2 : this.uAM) {
                cWy2.cWz();
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: ab */
    public final void mo9680ab(Runnable runnable) {
        if (getJsapi() == null || !getJsapi().ready) {
            C4990ab.m7416i("BaseSearchWebViewUI", "jsapi not ready, waiting");
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
        C4990ab.m7417i(str, str2, objArr);
    }

    public final boolean aMj() {
        return true;
    }
}
