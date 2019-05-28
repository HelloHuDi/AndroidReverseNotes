package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.jsapi.g.b;
import com.tencent.mm.plugin.appbrand.jsapi.g.e;
import com.tencent.mm.plugin.appbrand.jsapi.g.n;
import com.tencent.mm.plugin.websearch.api.h;
import com.tencent.mm.plugin.websearch.api.x;
import com.tencent.mm.plugin.websearch.api.y;
import com.tencent.mm.plugin.webview.fts.d.a;
import com.tencent.mm.plugin.webview.stub.d;
import com.tencent.mm.plugin.webview.ui.tools.widget.MMWebViewWithJsApi;
import com.tencent.mm.plugin.webview.ui.tools.widget.f;
import com.tencent.mm.plugin.webview.ui.tools.widget.k;
import com.tencent.mm.plugin.webview.ui.tools.widget.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.qqmusic.mediaplayer.PlayerException;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class WeappWebSearchFragment extends Fragment {
    private String cOG;
    private LinearLayout eol;
    private ak handler;
    private int scene = 201;
    private e uAv;
    private a uAw;
    MMWebViewWithJsApi uCP;

    public void onActivityCreated(Bundle bundle) {
        AppMethodBeat.i(8618);
        super.onActivityCreated(bundle);
        AppMethodBeat.o(8618);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        AppMethodBeat.i(8619);
        this.handler = new ak();
        this.uCP = (MMWebViewWithJsApi) f.a.uJi.du(getContext());
        this.uCP.setWebViewClient(new k(this.uCP) {
            public final void a(d dVar, com.tencent.mm.plugin.webview.ui.tools.k kVar) {
                AppMethodBeat.i(8608);
                try {
                    super.a(dVar, kVar);
                    if (WeappWebSearchFragment.this.uAw != null) {
                        WeappWebSearchFragment.this.uAw.uhz = WeappWebSearchFragment.this.uCP.getJsapi();
                    }
                    AppMethodBeat.o(8608);
                } catch (Exception e) {
                    ab.printErrStackTrace("WeappWebSearchFragment", e, "", new Object[0]);
                    AppMethodBeat.o(8608);
                }
            }

            public final m aGt() {
                AppMethodBeat.i(8609);
                AnonymousClass1 anonymousClass1 = new m() {
                    public final boolean c(int i, Bundle bundle) {
                        AppMethodBeat.i(8607);
                        switch (i) {
                            case 60:
                            case PlayerException.EXCEPTION_TYPE_INITLIB /*61*/:
                            case 62:
                            case com.tencent.view.d.MIC_AVROUND_BLUR /*119*/:
                            case 120:
                            case 121:
                            case 122:
                            case 123:
                            case 124:
                            case 125:
                            case 126:
                            case com.tencent.view.d.MIC_SketchMark /*127*/:
                            case 128:
                            case 130:
                            case e.CTRL_INDEX /*133*/:
                            case com.tencent.mm.plugin.appbrand.jsapi.g.d.CTRL_INDEX /*134*/:
                            case b.CTRL_INDEX /*135*/:
                            case n.CTRL_INDEX /*136*/:
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
                                WeappWebSearchFragment.this.w(i, bundle);
                                break;
                        }
                        boolean c = super.c(i, bundle);
                        AppMethodBeat.o(8607);
                        return c;
                    }
                };
                AppMethodBeat.o(8609);
                return anonymousClass1;
            }
        });
        this.uAw = new a(this.uCP);
        this.uAv = new e(((h) g.K(h.class)).a(getContext(), this.uAw));
        this.cOG = getArguments().getString("url");
        if (!TextUtils.isEmpty(this.cOG)) {
            this.uCP.loadUrl(this.cOG);
        }
        this.eol = (LinearLayout) layoutInflater.inflate(R.layout.b76, viewGroup, false);
        this.eol.addView(this.uCP);
        LinearLayout linearLayout = this.eol;
        AppMethodBeat.o(8619);
        return linearLayout;
    }

    public void onDestroy() {
        AppMethodBeat.i(8620);
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
            AppMethodBeat.o(8620);
        } catch (Exception e) {
            ab.e("WeappWebSearchFragment", "onDestroy, set web infos to null,  ex = %s", e.getMessage());
            AppMethodBeat.o(8620);
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean w(int i, Bundle bundle) {
        AppMethodBeat.i(8621);
        switch (i) {
            case ErrorCode.NEEDDOWNLOAD_3 /*142*/:
                boolean x = x(i, bundle);
                AppMethodBeat.o(8621);
                return x;
            default:
                ((FTSSOSHomeWebViewUI) getActivity()).j(i, bundle);
                AppMethodBeat.o(8621);
                return true;
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean x(int i, Bundle bundle) {
        AppMethodBeat.i(8622);
        final int i2;
        final String string;
        final String string2;
        switch (i) {
            case 60:
                this.uAv.b(bundle, this.scene);
                break;
            case PlayerException.EXCEPTION_TYPE_INITLIB /*61*/:
                this.uAv.aj(bundle);
                break;
            case 62:
                this.uAv.ak(bundle);
                break;
            case com.tencent.view.d.MIC_AVROUND_BLUR /*119*/:
                final String string3 = bundle.getString("fts_key_json_data");
                final String string4 = bundle.getString("fts_key_req_id");
                final boolean z = bundle.getBoolean("fts_key_new_query", true);
                final Bundle bundle2 = bundle.getBundle("fts_key_data");
                this.handler.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(8612);
                        if (WeappWebSearchFragment.this.getJsapi() != null) {
                            if (bundle2 == null || bundle2.getInt("isRefresh") != 1 || bundle2.getString("widgetId") == null) {
                                WeappWebSearchFragment.this.getJsapi().h(string3, z, string4);
                            } else {
                                WeappWebSearchFragment.this.getJsapi().hj(bundle2.getString("widgetId"), string3);
                                AppMethodBeat.o(8612);
                                return;
                            }
                        }
                        AppMethodBeat.o(8612);
                    }
                });
                break;
            case 120:
                i2 = bundle.getInt("fts_key_ret", 0);
                string = bundle.getString("fts_key_data");
                this.handler.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(8613);
                        if (WeappWebSearchFragment.this.getJsapi() != null) {
                            WeappWebSearchFragment.this.getJsapi().bH(i2, string);
                        }
                        AppMethodBeat.o(8613);
                    }
                });
                break;
            case 121:
                string = bundle.getString("fts_key_json_data");
                final int i3 = bundle.getInt("fts_key_teach_request_type", 0);
                i2 = bundle.getInt("fts_key_is_cache_data", 0);
                this.handler.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(8614);
                        if (WeappWebSearchFragment.this.getJsapi() != null) {
                            WeappWebSearchFragment.this.getJsapi().n(i3, string, i2);
                        }
                        AppMethodBeat.o(8614);
                    }
                });
                break;
            case 124:
                string2 = bundle.getString("fts_key_json_data");
                this.handler.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(8615);
                        if (WeappWebSearchFragment.this.getJsapi() != null) {
                            WeappWebSearchFragment.this.getJsapi().agq(string2);
                        }
                        AppMethodBeat.o(8615);
                    }
                });
                break;
            case 125:
                string = bundle.getString("fts_key_sns_id");
                i2 = bundle.getInt("fts_key_status", 0);
                this.handler.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(8616);
                        if (WeappWebSearchFragment.this.getJsapi() != null) {
                            WeappWebSearchFragment.this.getJsapi().dN(string, i2);
                        }
                        AppMethodBeat.o(8616);
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
                        AppMethodBeat.i(8611);
                        if (WeappWebSearchFragment.this.getJsapi() != null) {
                            WeappWebSearchFragment.this.getJsapi().aO(hashMap);
                        }
                        AppMethodBeat.o(8611);
                    }
                });
                break;
            case e.CTRL_INDEX /*133*/:
                ah(bundle);
                break;
            case com.tencent.mm.plugin.appbrand.jsapi.g.d.CTRL_INDEX /*134*/:
                com.tencent.mm.plugin.websearch.widget.view.a.cVT().Ip(bundle.getInt("actionSheetId"));
                break;
            case b.CTRL_INDEX /*135*/:
            case 144:
                break;
            case 137:
                string = bundle.getString("fts_key_json_data");
                if (getJsapi() != null) {
                    try {
                        getJsapi().aP(new JSONObject(string));
                        break;
                    } catch (JSONException e) {
                        ab.printErrStackTrace("WeappWebSearchFragment", e, "", new Object[0]);
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
                        AppMethodBeat.i(8610);
                        if (WeappWebSearchFragment.this.getJsapi() != null) {
                            WeappWebSearchFragment.this.getJsapi().m(string5, i4, i5, i6);
                        }
                        AppMethodBeat.o(8610);
                    }
                });
                break;
            case 145:
                getJsapi().ap(bundle);
                break;
            case 100001:
                this.uAv.ai(bundle);
                break;
            case 100002:
                e eVar = this.uAv;
                if (eVar == null) {
                    ab.e("WeappWebSearchFragment", "can not find FTSSearchWidgetMgr to handle tapSearchWAWidgetView");
                    getJsapi().a(bundle.getString(""), false, "can not find FTSSearchWidgetMgr to handle tapSearchWAWidgetView", bundle.getString("widgetId"));
                    break;
                }
                eVar.al(bundle);
                break;
            default:
                AppMethodBeat.o(8622);
                return false;
        }
        AppMethodBeat.o(8622);
        return true;
    }

    private void ah(Bundle bundle) {
        AppMethodBeat.i(8623);
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
            ab.e("WeappWebSearchFragment", bo.l(e));
        }
        ab.v("WeappWebSearchFragment", "doShowSearchActionSheet args: title %s,subTitle %s,items %s", string, string2, r7);
        if (!arrayList.isEmpty()) {
            bundle.putInt("actionSheetId", ((h) g.K(h.class)).a(getActivity(), string, string2, arrayList, new x() {
                public final void go(int i, int i2) {
                    AppMethodBeat.i(8617);
                    if (WeappWebSearchFragment.this.getJsapi() != null) {
                        WeappWebSearchFragment.this.getJsapi().gA(i, i2);
                    }
                    AppMethodBeat.o(8617);
                }
            }));
        }
        AppMethodBeat.o(8623);
    }

    public final com.tencent.mm.plugin.webview.ui.tools.jsapi.d getJsapi() {
        AppMethodBeat.i(8624);
        if (this.uCP != null) {
            com.tencent.mm.plugin.webview.ui.tools.jsapi.d jsapi = this.uCP.getJsapi();
            AppMethodBeat.o(8624);
            return jsapi;
        }
        AppMethodBeat.o(8624);
        return null;
    }
}
