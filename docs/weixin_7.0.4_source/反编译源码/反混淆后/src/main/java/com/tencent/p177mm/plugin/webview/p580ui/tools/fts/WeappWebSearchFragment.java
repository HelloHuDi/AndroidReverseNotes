package com.tencent.p177mm.plugin.webview.p580ui.tools.fts;

import android.os.Bundle;
import android.support.p057v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.plugin.appbrand.jsapi.p306g.C19392d;
import com.tencent.p177mm.plugin.appbrand.jsapi.p306g.C19394e;
import com.tencent.p177mm.plugin.appbrand.jsapi.p306g.C19395n;
import com.tencent.p177mm.plugin.appbrand.jsapi.p306g.C44697b;
import com.tencent.p177mm.plugin.websearch.api.C14427x;
import com.tencent.p177mm.plugin.websearch.api.C29740h;
import com.tencent.p177mm.plugin.websearch.api.C29743y;
import com.tencent.p177mm.plugin.websearch.widget.view.C43855a;
import com.tencent.p177mm.plugin.webview.fts.p1664d.C46411a;
import com.tencent.p177mm.plugin.webview.p580ui.tools.C40344k;
import com.tencent.p177mm.plugin.webview.p580ui.tools.jsapi.C44786d;
import com.tencent.p177mm.plugin.webview.p580ui.tools.widget.C29959f.C23152a;
import com.tencent.p177mm.plugin.webview.p580ui.tools.widget.C43989k;
import com.tencent.p177mm.plugin.webview.p580ui.tools.widget.C46936m;
import com.tencent.p177mm.plugin.webview.p580ui.tools.widget.MMWebViewWithJsApi;
import com.tencent.p177mm.plugin.webview.stub.C46434d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.qqmusic.mediaplayer.PlayerException;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import com.tencent.view.C31128d;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.webview.ui.tools.fts.WeappWebSearchFragment */
public class WeappWebSearchFragment extends Fragment {
    private String cOG;
    private LinearLayout eol;
    private C7306ak handler;
    private int scene = 201;
    private C29915e uAv;
    private C46411a uAw;
    MMWebViewWithJsApi uCP;

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.fts.WeappWebSearchFragment$9 */
    class C403039 implements C14427x {
        C403039() {
        }

        /* renamed from: go */
        public final void mo9690go(int i, int i2) {
            AppMethodBeat.m2504i(8617);
            if (WeappWebSearchFragment.this.getJsapi() != null) {
                WeappWebSearchFragment.this.getJsapi().mo71929gA(i, i2);
            }
            AppMethodBeat.m2505o(8617);
        }
    }

    public void onActivityCreated(Bundle bundle) {
        AppMethodBeat.m2504i(8618);
        super.onActivityCreated(bundle);
        AppMethodBeat.m2505o(8618);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        AppMethodBeat.m2504i(8619);
        this.handler = new C7306ak();
        this.uCP = (MMWebViewWithJsApi) C23152a.uJi.mo30691du(getContext());
        this.uCP.setWebViewClient(new C43989k(this.uCP) {

            /* renamed from: com.tencent.mm.plugin.webview.ui.tools.fts.WeappWebSearchFragment$1$1 */
            class C403001 extends C46936m {
                C403001() {
                }

                /* renamed from: c */
                public final boolean mo26784c(int i, Bundle bundle) {
                    AppMethodBeat.m2504i(8607);
                    switch (i) {
                        case 60:
                        case PlayerException.EXCEPTION_TYPE_INITLIB /*61*/:
                        case 62:
                        case C31128d.MIC_AVROUND_BLUR /*119*/:
                        case 120:
                        case 121:
                        case 122:
                        case 123:
                        case 124:
                        case 125:
                        case 126:
                        case C31128d.MIC_SketchMark /*127*/:
                        case 128:
                        case 130:
                        case C19394e.CTRL_INDEX /*133*/:
                        case C19392d.CTRL_INDEX /*134*/:
                        case C44697b.CTRL_INDEX /*135*/:
                        case C19395n.CTRL_INDEX /*136*/:
                        case 137:
                        case 138:
                        case ErrorCode.NEEDDOWNLOAD_3 /*142*/:
                        case ErrorCode.NEEDDOWNLOAD_4 /*143*/:
                        case 144:
                        case 145:
                        case ErrorCode.NEEDDOWNLOAD_8 /*147*/:
                        case 148:
                        case 149:
                        case 150:
                        case 100001:
                        case 100002:
                        case 200000:
                        case 200001:
                        case 200002:
                        case 200003:
                            WeappWebSearchFragment.this.mo63661w(i, bundle);
                            break;
                    }
                    boolean c = super.mo26784c(i, bundle);
                    AppMethodBeat.m2505o(8607);
                    return c;
                }
            }

            /* renamed from: a */
            public final void mo38561a(C46434d c46434d, C40344k c40344k) {
                AppMethodBeat.m2504i(8608);
                try {
                    super.mo38561a(c46434d, c40344k);
                    if (WeappWebSearchFragment.this.uAw != null) {
                        WeappWebSearchFragment.this.uAw.uhz = WeappWebSearchFragment.this.uCP.getJsapi();
                    }
                    AppMethodBeat.m2505o(8608);
                } catch (Exception e) {
                    C4990ab.printErrStackTrace("WeappWebSearchFragment", e, "", new Object[0]);
                    AppMethodBeat.m2505o(8608);
                }
            }

            public final C46936m aGt() {
                AppMethodBeat.m2504i(8609);
                C403001 c403001 = new C403001();
                AppMethodBeat.m2505o(8609);
                return c403001;
            }
        });
        this.uAw = new C46411a(this.uCP);
        this.uAv = new C29915e(((C29740h) C1720g.m3528K(C29740h.class)).mo47979a(getContext(), this.uAw));
        this.cOG = getArguments().getString("url");
        if (!TextUtils.isEmpty(this.cOG)) {
            this.uCP.loadUrl(this.cOG);
        }
        this.eol = (LinearLayout) layoutInflater.inflate(2130971206, viewGroup, false);
        this.eol.addView(this.uCP);
        LinearLayout linearLayout = this.eol;
        AppMethodBeat.m2505o(8619);
        return linearLayout;
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(8620);
        super.onDestroy();
        try {
            this.uCP.destroy();
            this.uCP.setWebChromeClient(null);
            this.uCP.setWebViewClient(null);
            this.uCP.setOnTouchListener(null);
            this.uCP.setOnLongClickListener(null);
            this.uCP.setVisibility(8);
            this.uCP.removeAllViews();
            this.uCP.clearView();
            this.uCP = null;
            this.uAv.onDestroy();
            AppMethodBeat.m2505o(8620);
        } catch (Exception e) {
            C4990ab.m7413e("WeappWebSearchFragment", "onDestroy, set web infos to null,  ex = %s", e.getMessage());
            AppMethodBeat.m2505o(8620);
        }
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: w */
    public final boolean mo63661w(int i, Bundle bundle) {
        AppMethodBeat.m2504i(8621);
        switch (i) {
            case ErrorCode.NEEDDOWNLOAD_3 /*142*/:
                boolean x = mo63662x(i, bundle);
                AppMethodBeat.m2505o(8621);
                return x;
            default:
                ((FTSSOSHomeWebViewUI) getActivity()).mo9685j(i, bundle);
                AppMethodBeat.m2505o(8621);
                return true;
        }
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: x */
    public final boolean mo63662x(int i, Bundle bundle) {
        AppMethodBeat.m2504i(8622);
        final int i2;
        final String string;
        final String string2;
        switch (i) {
            case 60:
                this.uAv.mo48161b(bundle, this.scene);
                break;
            case PlayerException.EXCEPTION_TYPE_INITLIB /*61*/:
                this.uAv.mo48158aj(bundle);
                break;
            case 62:
                this.uAv.mo48159ak(bundle);
                break;
            case C31128d.MIC_AVROUND_BLUR /*119*/:
                final String string3 = bundle.getString("fts_key_json_data");
                final String string4 = bundle.getString("fts_key_req_id");
                final boolean z = bundle.getBoolean("fts_key_new_query", true);
                final Bundle bundle2 = bundle.getBundle("fts_key_data");
                this.handler.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(8612);
                        if (WeappWebSearchFragment.this.getJsapi() != null) {
                            if (bundle2 == null || bundle2.getInt("isRefresh") != 1 || bundle2.getString("widgetId") == null) {
                                WeappWebSearchFragment.this.getJsapi().mo71931h(string3, z, string4);
                            } else {
                                WeappWebSearchFragment.this.getJsapi().mo71932hj(bundle2.getString("widgetId"), string3);
                                AppMethodBeat.m2505o(8612);
                                return;
                            }
                        }
                        AppMethodBeat.m2505o(8612);
                    }
                });
                break;
            case 120:
                i2 = bundle.getInt("fts_key_ret", 0);
                string = bundle.getString("fts_key_data");
                this.handler.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(8613);
                        if (WeappWebSearchFragment.this.getJsapi() != null) {
                            WeappWebSearchFragment.this.getJsapi().mo71909bH(i2, string);
                        }
                        AppMethodBeat.m2505o(8613);
                    }
                });
                break;
            case 121:
                string = bundle.getString("fts_key_json_data");
                final int i3 = bundle.getInt("fts_key_teach_request_type", 0);
                i2 = bundle.getInt("fts_key_is_cache_data", 0);
                this.handler.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(8614);
                        if (WeappWebSearchFragment.this.getJsapi() != null) {
                            WeappWebSearchFragment.this.getJsapi().mo71936n(i3, string, i2);
                        }
                        AppMethodBeat.m2505o(8614);
                    }
                });
                break;
            case 124:
                string2 = bundle.getString("fts_key_json_data");
                this.handler.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(8615);
                        if (WeappWebSearchFragment.this.getJsapi() != null) {
                            WeappWebSearchFragment.this.getJsapi().agq(string2);
                        }
                        AppMethodBeat.m2505o(8615);
                    }
                });
                break;
            case 125:
                string = bundle.getString("fts_key_sns_id");
                i2 = bundle.getInt("fts_key_status", 0);
                this.handler.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(8616);
                        if (WeappWebSearchFragment.this.getJsapi() != null) {
                            WeappWebSearchFragment.this.getJsapi().mo71920dN(string, i2);
                        }
                        AppMethodBeat.m2505o(8616);
                    }
                });
                break;
            case 128:
                final HashMap hashMap = new HashMap();
                for (String string22 : bundle.keySet()) {
                    hashMap.put(string22, bundle.get(string22));
                }
                this.handler.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(8611);
                        if (WeappWebSearchFragment.this.getJsapi() != null) {
                            WeappWebSearchFragment.this.getJsapi().mo71898aO(hashMap);
                        }
                        AppMethodBeat.m2505o(8611);
                    }
                });
                break;
            case C19394e.CTRL_INDEX /*133*/:
                m69094ah(bundle);
                break;
            case C19392d.CTRL_INDEX /*134*/:
                C43855a.cVT().mo69534Ip(bundle.getInt("actionSheetId"));
                break;
            case C44697b.CTRL_INDEX /*135*/:
            case 144:
                break;
            case 137:
                string = bundle.getString("fts_key_json_data");
                if (getJsapi() != null) {
                    try {
                        getJsapi().mo71899aP(new JSONObject(string));
                        break;
                    } catch (JSONException e) {
                        C4990ab.printErrStackTrace("WeappWebSearchFragment", e, "", new Object[0]);
                        break;
                    }
                }
                break;
            case ErrorCode.NEEDDOWNLOAD_3 /*142*/:
                final String string5 = bundle.getString("fts_key_json_data");
                final int i4 = bundle.getInt("fts_key_is_cache_data", 0);
                final int i5 = bundle.getInt("fts_key_is_expired", 1);
                final int i6 = bundle.getInt("fts_key_is_preload", 0);
                this.handler.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(8610);
                        if (WeappWebSearchFragment.this.getJsapi() != null) {
                            WeappWebSearchFragment.this.getJsapi().mo71935m(string5, i4, i5, i6);
                        }
                        AppMethodBeat.m2505o(8610);
                    }
                });
                break;
            case 145:
                getJsapi().mo71907ap(bundle);
                break;
            case 100001:
                this.uAv.mo48157ai(bundle);
                break;
            case 100002:
                C29915e c29915e = this.uAv;
                if (c29915e == null) {
                    C4990ab.m7412e("WeappWebSearchFragment", "can not find FTSSearchWidgetMgr to handle tapSearchWAWidgetView");
                    getJsapi().mo71891a(bundle.getString(""), false, "can not find FTSSearchWidgetMgr to handle tapSearchWAWidgetView", bundle.getString("widgetId"));
                    break;
                }
                c29915e.mo48160al(bundle);
                break;
            default:
                AppMethodBeat.m2505o(8622);
                return false;
        }
        AppMethodBeat.m2505o(8622);
        return true;
    }

    /* renamed from: ah */
    private void m69094ah(Bundle bundle) {
        AppMethodBeat.m2504i(8623);
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
            C4990ab.m7412e("WeappWebSearchFragment", C5046bo.m7574l(e));
        }
        C4990ab.m7419v("WeappWebSearchFragment", "doShowSearchActionSheet args: title %s,subTitle %s,items %s", string, string2, r7);
        if (!arrayList.isEmpty()) {
            bundle.putInt("actionSheetId", ((C29740h) C1720g.m3528K(C29740h.class)).mo47978a(getActivity(), string, string2, arrayList, new C403039()));
        }
        AppMethodBeat.m2505o(8623);
    }

    public final C44786d getJsapi() {
        AppMethodBeat.m2504i(8624);
        if (this.uCP != null) {
            C44786d jsapi = this.uCP.getJsapi();
            AppMethodBeat.m2505o(8624);
            return jsapi;
        }
        AppMethodBeat.m2505o(8624);
        return null;
    }
}
