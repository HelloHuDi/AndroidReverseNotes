package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.graphics.PorterDuff.Mode;
import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.view.animation.AccelerateInterpolator;
import android.widget.AbsoluteLayout;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.facebook.appevents.AppEventsConstants;
import com.google.android.gms.actions.SearchIntents;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.bp.d;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.appbrand.jsapi.g.n;
import com.tencent.mm.plugin.fts.ui.widget.FTSMainUIEducationLayout;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.websearch.api.aa;
import com.tencent.mm.plugin.websearch.api.an;
import com.tencent.mm.plugin.websearch.api.z;
import com.tencent.mm.plugin.webview.ui.tools.WebViewKeyboardLinearLayout;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d.AnonymousClass38;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.fts.widget.FTSMainUIEducationLayoutWithAll;
import com.tencent.mm.ui.fts.widget.FTSMainUIHotWordLayout;
import com.tencent.mm.ui.tools.f;
import com.tencent.smtt.sdk.WebView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public class FTSSOSHomeWebViewUI extends BaseSOSWebViewUI {
    private OnClickListener mJH = new OnClickListener() {
        public final void onClick(View view) {
            AppMethodBeat.i(8423);
            FTSSOSHomeWebViewUI.i(FTSSOSHomeWebViewUI.this);
            if (FTSSOSHomeWebViewUI.this.uAy) {
                FTSSOSHomeWebViewUI.this.uBk.sendMessage(1);
                String charSequence = ((TextView) view).getText().toString();
                final int a = com.tencent.mm.bd.a.a((JSONObject) view.getTag(), charSequence, FTSSOSHomeWebViewUI.this);
                if (a == 64) {
                    FTSSOSHomeWebViewUI.this.uBv = true;
                    FTSSOSHomeWebViewUI.this.uAW.setVisibility(0);
                    WeappWebSearchFragment m = FTSSOSHomeWebViewUI.this.uBu;
                    int height = FTSSOSHomeWebViewUI.this.uAX.getHeight();
                    LayoutParams layoutParams = m.uCP.getLayoutParams();
                    layoutParams.height = height;
                    m.uCP.setLayoutParams(layoutParams);
                    FTSSOSHomeWebViewUI.this.uAX.setVisibility(8);
                }
                if (a != 0) {
                    FTSSOSHomeWebViewUI.this.uBt = charSequence;
                } else {
                    FTSSOSHomeWebViewUI.this.uBt = "";
                }
                if (FTSSOSHomeWebViewUI.this.uAO != a) {
                    h.pYm.e(15521, Integer.valueOf(FTSSOSHomeWebViewUI.this.scene), Integer.valueOf(4), FTSSOSHomeWebViewUI.this.dby().getInEditTextQuery(), Long.valueOf(System.currentTimeMillis()), Integer.valueOf(FTSSOSHomeWebViewUI.this.uAO));
                }
                if (!(FTSSOSHomeWebViewUI.this.uAO == a || FTSSOSHomeWebViewUI.this.dby().getTagList().isEmpty())) {
                    String totalQuery = FTSSOSHomeWebViewUI.this.getTotalQuery();
                    FTSSOSHomeWebViewUI.this.dby().clearText();
                    FTSSOSHomeWebViewUI.this.dby().n(totalQuery, null);
                    FTSSOSHomeWebViewUI.this.dby().bBs();
                }
                FTSSOSHomeWebViewUI.this.uAO = a;
                FTSSOSHomeWebViewUI.this.dbt();
                FTSSOSHomeWebViewUI.d(FTSSOSHomeWebViewUI.this, a);
                try {
                    FTSSOSHomeWebViewUI.this.uBB = 0;
                    Bundle bundle = new Bundle();
                    bundle.putInt("type", a);
                    bundle.putBoolean("isHomePage", a == 0);
                    if (FTSSOSHomeWebViewUI.this.bFf() != 20 || FTSSOSHomeWebViewUI.this.uBk.dbC()) {
                        FTSSOSHomeWebViewUI.this.uAN = FTSSOSHomeWebViewUI.this.bFf();
                        bundle.putInt("scene", FTSSOSHomeWebViewUI.this.bFf());
                    } else if (a != 0) {
                        FTSSOSHomeWebViewUI.this.uAN = 22;
                        bundle.putInt("scene", 22);
                    } else {
                        FTSSOSHomeWebViewUI.this.uAN = 20;
                        bundle.putInt("scene", 20);
                    }
                    final Bundle p = FTSSOSHomeWebViewUI.this.icy.p(4, bundle);
                    FTSSOSHomeWebViewUI.this.handler.post(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(8424);
                            boolean z = false;
                            if (FTSSOSHomeWebViewUI.this.getJsapi() != null) {
                                Map hashMap = new HashMap();
                                hashMap.put("isHomePage", AppEventsConstants.EVENT_PARAM_VALUE_NO);
                                if (a == 0) {
                                    hashMap.put("isHomePage", "1");
                                } else if (a == 1) {
                                    hashMap.put("isMostSearchBiz", p.getString("isMostSearchBiz", AppEventsConstants.EVENT_PARAM_VALUE_NO));
                                } else {
                                    hashMap.put("isHomePage", AppEventsConstants.EVENT_PARAM_VALUE_NO);
                                }
                                if (!bo.isNullOrNil(FTSSOSHomeWebViewUI.this.getTotalQuery())) {
                                    hashMap.put(SearchIntents.EXTRA_QUERY, FTSSOSHomeWebViewUI.this.getTotalQuery());
                                }
                                boolean a = FTSSOSHomeWebViewUI.this.getJsapi().a(p.getString("scene", AppEventsConstants.EVENT_PARAM_VALUE_NO), p.getString("type", AppEventsConstants.EVENT_PARAM_VALUE_NO), p.getString("isSug", AppEventsConstants.EVENT_PARAM_VALUE_NO), p.getString("isLocalSug", AppEventsConstants.EVENT_PARAM_VALUE_NO), FTSSOSHomeWebViewUI.this.getSessionId(), hashMap);
                                if (!TextUtils.isEmpty(FTSSOSHomeWebViewUI.this.getInEditTextQuery())) {
                                    z.a(FTSSOSHomeWebViewUI.this.scene, FTSSOSHomeWebViewUI.this.cvF, FTSSOSHomeWebViewUI.this.cIy, true, FTSSOSHomeWebViewUI.this.getInEditTextQuery(), FTSSOSHomeWebViewUI.this.uAO);
                                }
                                z = a;
                            }
                            if (z) {
                                FTSSOSHomeWebViewUI.this.dby().setHint(FTSSOSHomeWebViewUI.f(FTSSOSHomeWebViewUI.this, a));
                                an.e(a, FTSSOSHomeWebViewUI.this.uAN, FTSSOSHomeWebViewUI.this.uBo, FTSSOSHomeWebViewUI.this.uBk.dbC());
                                FTSSOSHomeWebViewUI.this.uBk.sendMessage(7);
                            }
                            AppMethodBeat.o(8424);
                        }
                    });
                    AppMethodBeat.o(8423);
                    return;
                } catch (Exception e) {
                    AppMethodBeat.o(8423);
                    return;
                }
            }
            AppMethodBeat.o(8423);
        }
    };
    private FTSMainUIEducationLayout mJe;
    private View qpb;
    private View qzN;
    private TextView titleView;
    private View uAV;
    private View uAW;
    private View uAX;
    private a uAY;
    private b uAZ;
    private String uBA;
    int uBB;
    private OnClickListener uBC = new OnClickListener() {
        public final void onClick(View view) {
            AppMethodBeat.i(8434);
            c cVar = (c) view.getTag();
            if (cVar.type == 1) {
                Bundle bundle = new Bundle();
                bundle.putString("history", cVar.content);
                try {
                    FTSSOSHomeWebViewUI.this.icy.j(5, bundle);
                } catch (RemoteException e) {
                }
                al.d(new AnonymousClass2(cVar));
                AppMethodBeat.o(8434);
                return;
            }
            if (cVar.type == 2) {
                FTSSOSHomeWebViewUI.this.uAY.clear();
                FTSSOSHomeWebViewUI.this.dby().n(cVar.content, null);
                FTSSOSHomeWebViewUI.a(FTSSOSHomeWebViewUI.this, cVar, 2);
                FTSSOSHomeWebViewUI.this.uBB = 2;
                FTSSOSHomeWebViewUI.A(FTSSOSHomeWebViewUI.this);
            }
            AppMethodBeat.o(8434);
        }
    };
    private OnItemClickListener uBD = new OnItemClickListener() {
        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            AppMethodBeat.i(8435);
            c JF = FTSSOSHomeWebViewUI.this.uAY.JF(i);
            FTSSOSHomeWebViewUI.this.dby().n(JF.content, null);
            if (JF.type == 2) {
                FTSSOSHomeWebViewUI.a(FTSSOSHomeWebViewUI.this, JF, 1);
                FTSSOSHomeWebViewUI.this.uBB = 1;
            }
            FTSSOSHomeWebViewUI.this.aMo();
            AppMethodBeat.o(8435);
        }
    };
    private OnClickListener uBE = new OnClickListener() {
        public final void onClick(View view) {
            AppMethodBeat.i(8436);
            FTSSOSHomeWebViewUI.B(FTSSOSHomeWebViewUI.this);
            AppMethodBeat.o(8436);
        }
    };
    private boolean uBF;
    private c uBa;
    private d uBb;
    private float uBc = Float.MAX_VALUE;
    private FTSMainUIHotWordLayout uBd;
    private FTSMainUIEducationLayoutWithAll uBe;
    private View uBf;
    private TextView uBg;
    private View uBh;
    private View uBi;
    private View uBj;
    private b uBk;
    private int uBl;
    private boolean uBm;
    private int uBn = 0;
    private String uBo = "";
    boolean uBp;
    boolean uBq;
    private int uBr = 0;
    private int uBs = 0;
    private String uBt = "";
    private WeappWebSearchFragment uBu;
    private boolean uBv;
    private OnClickListener uBw = new OnClickListener() {
        public final void onClick(View view) {
            Bundle bundle;
            final HashMap hashMap;
            AppMethodBeat.i(8427);
            com.tencent.mm.ui.fts.widget.FTSMainUIHotWordLayout.a aVar = (com.tencent.mm.ui.fts.widget.FTSMainUIHotWordLayout.a) view.getTag();
            switch (aVar.cKJ) {
                case 1:
                    if (FTSSOSHomeWebViewUI.this.uAy) {
                        FTSSOSHomeWebViewUI.this.uBA = null;
                        FTSSOSHomeWebViewUI.this.uBB = 0;
                        FTSSOSHomeWebViewUI.this.dby().clearText();
                        FTSSOSHomeWebViewUI.this.dby().n(aVar.zye, null);
                        FTSSOSHomeWebViewUI.this.dby().bBs();
                        FTSSOSHomeWebViewUI.this.uBk.sendMessage(13);
                        try {
                            bundle = new Bundle();
                            bundle.putInt("type", 0);
                            bundle.putBoolean("isHomePage", true);
                            bundle.putInt("scene", 20);
                            bundle = FTSSOSHomeWebViewUI.this.icy.p(4, bundle);
                            hashMap = new HashMap();
                            hashMap.put("sceneActionType", "2");
                            hashMap.put("recommendId", FTSSOSHomeWebViewUI.this.uBd.getSearchId());
                            FTSSOSHomeWebViewUI.this.handler.post(new Runnable() {
                                public final void run() {
                                    boolean a;
                                    AppMethodBeat.i(8426);
                                    if (FTSSOSHomeWebViewUI.this.getJsapi() != null) {
                                        a = FTSSOSHomeWebViewUI.this.getJsapi().a(bundle.getString("type", AppEventsConstants.EVENT_PARAM_VALUE_NO), bundle.getString("isMostSearchBiz", AppEventsConstants.EVENT_PARAM_VALUE_NO), bundle.getString("isSug", AppEventsConstants.EVENT_PARAM_VALUE_NO), bundle.getString("scene", AppEventsConstants.EVENT_PARAM_VALUE_NO), bundle.getString("isLocalSug", AppEventsConstants.EVENT_PARAM_VALUE_NO), FTSSOSHomeWebViewUI.this.getTotalQuery(), FTSSOSHomeWebViewUI.this.getInEditTextQuery(), FTSSOSHomeWebViewUI.this.dbB(), FTSSOSHomeWebViewUI.this.dbw(), FTSSOSHomeWebViewUI.this.uBB, hashMap);
                                    } else {
                                        a = false;
                                    }
                                    if (a) {
                                        FTSSOSHomeWebViewUI.this.dby().setHint(FTSSOSHomeWebViewUI.f(FTSSOSHomeWebViewUI.this, 0));
                                        FTSSOSHomeWebViewUI.this.uBk.sendMessage(7);
                                    }
                                    AppMethodBeat.o(8426);
                                }
                            });
                            break;
                        } catch (Exception e) {
                            break;
                        }
                    }
                    AppMethodBeat.o(8427);
                    return;
                case 4:
                    Intent intent = new Intent();
                    intent.putExtra("rawUrl", aVar.jumpUrl);
                    intent.putExtra("convertActivityFromTranslucent", false);
                    d.b(ah.getContext(), "webview", ".ui.tools.WebViewUI", intent);
                    break;
            }
            try {
                Object encode;
                hashMap = new HashMap();
                hashMap.put("isclick", Integer.valueOf(1));
                hashMap.put("scene", Integer.valueOf(20));
                hashMap.put("recommendid", FTSSOSHomeWebViewUI.this.uBd.getSearchId());
                hashMap.put("businesstype", Integer.valueOf(0));
                String str = "docid";
                if (aVar.zye != null) {
                    encode = Uri.encode(aVar.zye);
                } else {
                    encode = "";
                }
                hashMap.put(str, encode);
                hashMap.put("docpos", Integer.valueOf(aVar.zyf + 1));
                hashMap.put("ishomepage", Integer.valueOf(1));
                hashMap.put("typepos", Integer.valueOf(1));
                hashMap.put("jumpurl", Uri.encode(aVar.jumpUrl));
                String an = aa.an(hashMap);
                bundle = new Bundle();
                bundle.putString("logString", an);
                FTSSOSHomeWebViewUI.this.icy.g(131, bundle);
                AppMethodBeat.o(8427);
            } catch (Exception e2) {
                ab.w("MicroMsg.FTS.FTSSOSHomeWebViewUI", "onHotwordCellClickListener cgi report fail for %s", e2.toString());
                AppMethodBeat.o(8427);
            }
        }
    };
    private com.tencent.mm.plugin.webview.ui.tools.fts.a.a uBx = new com.tencent.mm.plugin.webview.ui.tools.fts.a.a() {
        public final void onAnimationEnd() {
            AppMethodBeat.i(8428);
            FTSSOSHomeWebViewUI.this.uBk.sendMessage(4);
            FTSSOSHomeWebViewUI.v(FTSSOSHomeWebViewUI.this);
            AppMethodBeat.o(8428);
        }

        public final void onAnimationStart() {
            AppMethodBeat.i(8429);
            FTSSOSHomeWebViewUI.w(FTSSOSHomeWebViewUI.this);
            AppMethodBeat.o(8429);
        }
    };
    private com.tencent.mm.plugin.webview.ui.tools.fts.a.a uBy = new com.tencent.mm.plugin.webview.ui.tools.fts.a.a() {
        public final void onAnimationEnd() {
            AppMethodBeat.i(8430);
            FTSSOSHomeWebViewUI.this.uBk.sendMessage(9);
            FTSSOSHomeWebViewUI.v(FTSSOSHomeWebViewUI.this);
            AppMethodBeat.o(8430);
        }

        public final void onAnimationStart() {
            AppMethodBeat.i(8431);
            FTSSOSHomeWebViewUI.w(FTSSOSHomeWebViewUI.this);
            AppMethodBeat.o(8431);
        }
    };
    private com.tencent.mm.plugin.webview.ui.tools.fts.a.a uBz = new com.tencent.mm.plugin.webview.ui.tools.fts.a.a() {
        public final void onAnimationEnd() {
            AppMethodBeat.i(8432);
            FTSSOSHomeWebViewUI.this.uBk.sendMessage(3);
            FTSSOSHomeWebViewUI.v(FTSSOSHomeWebViewUI.this);
            AppMethodBeat.o(8432);
        }

        public final void onAnimationStart() {
            AppMethodBeat.i(8433);
            FTSSOSHomeWebViewUI.w(FTSSOSHomeWebViewUI.this);
            AppMethodBeat.o(8433);
        }
    };

    class a extends BaseAdapter {
        private List<c> uBK;

        class a {
            TextView ene;
            ImageView iqT;
            ImageView uBO;

            private a() {
            }

            /* synthetic */ a(a aVar, byte b) {
                this();
            }
        }

        /* renamed from: com.tencent.mm.plugin.webview.ui.tools.fts.FTSSOSHomeWebViewUI$a$1 */
        class AnonymousClass1 implements Runnable {
            final /* synthetic */ List uBL;

            AnonymousClass1(List list) {
                this.uBL = list;
            }

            public final void run() {
                AppMethodBeat.i(8448);
                if (a.this.uBK.size() > 0) {
                    for (c cVar : a.this.uBK) {
                        if (!this.uBL.contains(cVar)) {
                            this.uBL.add(cVar);
                        }
                    }
                }
                a.this.uBK = this.uBL;
                a.this.notifyDataSetChanged();
                AppMethodBeat.o(8448);
            }
        }

        /* renamed from: com.tencent.mm.plugin.webview.ui.tools.fts.FTSSOSHomeWebViewUI$a$2 */
        class AnonymousClass2 implements Runnable {
            final /* synthetic */ c uBN;

            AnonymousClass2(c cVar) {
                this.uBN = cVar;
            }

            public final void run() {
                AppMethodBeat.i(8449);
                a.this.uBK.remove(this.uBN);
                a.this.notifyDataSetChanged();
                AppMethodBeat.o(8449);
            }
        }

        /* renamed from: com.tencent.mm.plugin.webview.ui.tools.fts.FTSSOSHomeWebViewUI$a$3 */
        class AnonymousClass3 implements Runnable {
            final /* synthetic */ List uBL;

            AnonymousClass3(List list) {
                this.uBL = list;
            }

            public final void run() {
                AppMethodBeat.i(8450);
                for (c cVar : this.uBL) {
                    if (!a.this.uBK.contains(cVar)) {
                        a.this.uBK.add(cVar);
                    }
                }
                a.this.notifyDataSetChanged();
                AppMethodBeat.o(8450);
            }
        }

        private a() {
            AppMethodBeat.i(8452);
            this.uBK = new ArrayList();
            AppMethodBeat.o(8452);
        }

        /* synthetic */ a(FTSSOSHomeWebViewUI fTSSOSHomeWebViewUI, byte b) {
            this();
        }

        public final /* synthetic */ Object getItem(int i) {
            AppMethodBeat.i(8457);
            c JF = JF(i);
            AppMethodBeat.o(8457);
            return JF;
        }

        public final void clear() {
            AppMethodBeat.i(8453);
            al.d(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(8451);
                    a.this.uBK.clear();
                    a.this.notifyDataSetChanged();
                    AppMethodBeat.o(8451);
                }
            });
            AppMethodBeat.o(8453);
        }

        public final int getCount() {
            AppMethodBeat.i(8454);
            if (this.uBK.size() > 6) {
                AppMethodBeat.o(8454);
                return 6;
            }
            int size = this.uBK.size();
            AppMethodBeat.o(8454);
            return size;
        }

        public final c JF(int i) {
            AppMethodBeat.i(8455);
            c cVar = (c) this.uBK.get(i);
            AppMethodBeat.o(8455);
            return cVar;
        }

        public final long getItemId(int i) {
            return 0;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            a aVar;
            AppMethodBeat.i(8456);
            if (view == null) {
                a aVar2 = new a(this, (byte) 0);
                view = LayoutInflater.from(FTSSOSHomeWebViewUI.this.mController.ylL).inflate(R.layout.axc, null);
                aVar2.iqT = (ImageView) view.findViewById(R.id.rq);
                aVar2.ene = (TextView) view.findViewById(R.id.b14);
                aVar2.uBO = (ImageView) view.findViewById(R.id.eoo);
                view.setTag(aVar2);
                aVar = aVar2;
            } else {
                aVar = (a) view.getTag();
            }
            c JF = JF(i);
            JF.position = i;
            if (JF.icon != 0) {
                aVar.iqT.setVisibility(0);
                aVar.iqT.setImageResource(JF.icon);
            } else {
                aVar.iqT.setVisibility(4);
            }
            if (JF.uBV != 0) {
                aVar.uBO.setVisibility(0);
                aVar.uBO.setImageResource(JF.uBV);
                aVar.uBO.setTag(JF);
                aVar.uBO.setOnClickListener(FTSSOSHomeWebViewUI.this.uBC);
            } else {
                aVar.uBO.setVisibility(4);
            }
            aVar.ene.setText(JF.content);
            AppMethodBeat.o(8456);
            return view;
        }
    }

    class c {
        String content;
        int icon;
        int position;
        int type;
        int uBV;

        private c() {
        }

        /* synthetic */ c(FTSSOSHomeWebViewUI fTSSOSHomeWebViewUI, byte b) {
            this();
        }

        public final boolean equals(Object obj) {
            AppMethodBeat.i(8474);
            boolean equals = this.content.equals(((c) obj).content);
            AppMethodBeat.o(8474);
            return equals;
        }
    }

    class b extends com.tencent.mm.sdk.d.d {
        com.tencent.mm.sdk.d.c uBP = new a(this, (byte) 0);
        com.tencent.mm.sdk.d.c uBQ = new d(this, (byte) 0);
        com.tencent.mm.sdk.d.c uBR = new b(this, (byte) 0);
        com.tencent.mm.sdk.d.c uBS = new c(this, (byte) 0);

        class a extends com.tencent.mm.sdk.d.b {
            private a() {
            }

            /* synthetic */ a(b bVar, byte b) {
                this();
            }

            public final void enter() {
                AppMethodBeat.i(8459);
                super.enter();
                FTSSOSHomeWebViewUI.F(FTSSOSHomeWebViewUI.this);
                AppMethodBeat.o(8459);
            }

            public final void exit() {
                AppMethodBeat.i(8460);
                super.exit();
                FTSSOSHomeWebViewUI.this.uBj.setBackgroundColor(FTSSOSHomeWebViewUI.this.getResources().getColor(R.color.a3p));
                AppMethodBeat.o(8460);
            }

            public final boolean k(Message message) {
                AppMethodBeat.i(8461);
                switch (message.what) {
                    case 0:
                    case 13:
                        if (FTSSOSHomeWebViewUI.this.getTotalQuery().length() > 0) {
                            FTSSOSHomeWebViewUI.this.dby().bBq();
                            FTSSOSHomeWebViewUI.this.dby().bBs();
                            FTSSOSHomeWebViewUI.this.dby().mLL.clearFocus();
                            FTSSOSHomeWebViewUI.d(FTSSOSHomeWebViewUI.this, 0);
                            FTSSOSHomeWebViewUI.this.uAZ.b(com.tencent.mm.plugin.webview.ui.tools.fts.a.b.Search);
                            FTSSOSHomeWebViewUI.a(FTSSOSHomeWebViewUI.this, com.tencent.mm.plugin.webview.ui.tools.fts.a.b.Search);
                            FTSSOSHomeWebViewUI.this.uAr.setBackgroundResource(R.color.a69);
                            FTSSOSHomeWebViewUI.this.uAY.clear();
                            break;
                        }
                        break;
                    case 1:
                        FTSSOSHomeWebViewUI.this.dby().bBq();
                        FTSSOSHomeWebViewUI.this.dby().bBs();
                        FTSSOSHomeWebViewUI.this.uBa.b(com.tencent.mm.plugin.webview.ui.tools.fts.a.b.Search);
                        FTSSOSHomeWebViewUI.a(FTSSOSHomeWebViewUI.this, com.tencent.mm.plugin.webview.ui.tools.fts.a.b.Search);
                        FTSSOSHomeWebViewUI.this.uAr.setBackgroundResource(R.color.a69);
                        FTSSOSHomeWebViewUI.this.uAY.clear();
                        FTSSOSHomeWebViewUI.this.uBm = true;
                        break;
                    case 3:
                        FTSSOSHomeWebViewUI.this.uAx = true;
                        b.this.b((com.tencent.mm.sdk.d.a) b.this.uBQ);
                        break;
                    case 4:
                        FTSSOSHomeWebViewUI.this.uAx = true;
                        b.this.b((com.tencent.mm.sdk.d.a) b.this.uBR);
                        break;
                    case 5:
                        if (FTSSOSHomeWebViewUI.this.dby().getEditText().hasFocus() && FTSSOSHomeWebViewUI.this.getTotalQuery().length() > 0) {
                            FTSSOSHomeWebViewUI.A(FTSSOSHomeWebViewUI.this);
                        }
                        if (FTSSOSHomeWebViewUI.this.dby().getEditText().hasFocus() && FTSSOSHomeWebViewUI.this.getTotalQuery().length() == 0) {
                            FTSSOSHomeWebViewUI.this.dby().bBs();
                            FTSSOSHomeWebViewUI.this.dby().bBq();
                            FTSSOSHomeWebViewUI.this.uAr.setBackgroundResource(R.color.a69);
                            FTSSOSHomeWebViewUI.this.uAs.setSearchBarCancelTextContainerVisibile(8);
                            FTSSOSHomeWebViewUI.this.uAY.clear();
                            FTSSOSHomeWebViewUI.this.uBa.b(com.tencent.mm.plugin.webview.ui.tools.fts.a.b.Search);
                            FTSSOSHomeWebViewUI.a(FTSSOSHomeWebViewUI.this, com.tencent.mm.plugin.webview.ui.tools.fts.a.b.Search);
                            FTSSOSHomeWebViewUI.this.ab(new Runnable() {
                                public final void run() {
                                    AppMethodBeat.i(8458);
                                    com.tencent.mm.plugin.webview.ui.tools.jsapi.d jsapi = FTSSOSHomeWebViewUI.this.getJsapi();
                                    if (jsapi.ready) {
                                        ab.i("MicroMsg.JsApiHandler", "onFocusSearchInput success, ready");
                                        al.d(new AnonymousClass38(com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a.b("onFocusSearchInput", null, jsapi.uFv, jsapi.uFw)));
                                        AppMethodBeat.o(8458);
                                        return;
                                    }
                                    ab.e("MicroMsg.JsApiHandler", "onFocusSearchInput fail, not ready");
                                    AppMethodBeat.o(8458);
                                }
                            });
                            h.pYm.e(15521, Integer.valueOf(FTSSOSHomeWebViewUI.this.scene), Integer.valueOf(3), FTSSOSHomeWebViewUI.this.dby().getInEditTextQuery(), Long.valueOf(System.currentTimeMillis()), Integer.valueOf(FTSSOSHomeWebViewUI.this.uAO));
                            break;
                        }
                    case 14:
                        FTSSOSHomeWebViewUI.this.dby().bBs();
                        FTSSOSHomeWebViewUI.this.dby().mLL.clearFocus();
                        FTSSOSHomeWebViewUI.d(FTSSOSHomeWebViewUI.this, 0);
                        FTSSOSHomeWebViewUI.this.uAZ.a(com.tencent.mm.plugin.webview.ui.tools.fts.a.b.Search, false);
                        FTSSOSHomeWebViewUI.a(FTSSOSHomeWebViewUI.this, com.tencent.mm.plugin.webview.ui.tools.fts.a.b.Search);
                        FTSSOSHomeWebViewUI.this.uAr.setBackgroundResource(R.color.a69);
                        FTSSOSHomeWebViewUI.this.uAY.clear();
                        b.this.b((com.tencent.mm.sdk.d.a) b.this.uBR);
                        FTSSOSHomeWebViewUI.this.uAx = true;
                        break;
                    case 15:
                        if (FTSSOSHomeWebViewUI.this.mJe != null && FTSSOSHomeWebViewUI.this.mJe.getVisibility() == 0) {
                            FTSSOSHomeWebViewUI.this.mJe.H((MotionEvent) message.obj);
                            break;
                        }
                }
                boolean k = super.k(message);
                AppMethodBeat.o(8461);
                return k;
            }

            public final String getName() {
                return "InitSate";
            }
        }

        class c extends com.tencent.mm.sdk.d.b {
            private c() {
            }

            /* synthetic */ c(b bVar, byte b) {
                this();
            }

            public final void enter() {
                AppMethodBeat.i(8465);
                super.enter();
                FTSSOSHomeWebViewUI.this.uAr.setPadding(FTSSOSHomeWebViewUI.this.uBl, 0, 0, 0);
                FTSSOSHomeWebViewUI.this.dby().bBs();
                FTSSOSHomeWebViewUI.this.oOO.setVisibility(0);
                FTSSOSHomeWebViewUI.this.dby().bBq();
                FTSSOSHomeWebViewUI.this.qpb.setVisibility(0);
                FTSSOSHomeWebViewUI.this.mJe.setVisibility(8);
                FTSSOSHomeWebViewUI.this.uBd.setVisibility(8);
                FTSSOSHomeWebViewUI.this.uBf.setVisibility(8);
                FTSSOSHomeWebViewUI.this.qzN.setVisibility(0);
                FTSSOSHomeWebViewUI.this.uAs.setSearchBarCancelTextContainerVisibile(0);
                FTSSOSHomeWebViewUI.this.uAs.setVoiceImageButtonVisibile(0);
                AppMethodBeat.o(8465);
            }

            public final void exit() {
                AppMethodBeat.i(8466);
                super.exit();
                FTSSOSHomeWebViewUI.this.aqX();
                AppMethodBeat.o(8466);
            }

            public final boolean k(Message message) {
                AppMethodBeat.i(8467);
                switch (message.what) {
                    case 0:
                        if (FTSSOSHomeWebViewUI.this.getTotalQuery().length() > 0) {
                            FTSSOSHomeWebViewUI.this.dby().bBs();
                            FTSSOSHomeWebViewUI.this.dby().mLL.clearFocus();
                            FTSSOSHomeWebViewUI.this.uAY.clear();
                            b.this.b((com.tencent.mm.sdk.d.a) b.this.uBR);
                            break;
                        }
                        break;
                    case 2:
                        if (!FTSSOSHomeWebViewUI.this.uBp) {
                            FTSSOSHomeWebViewUI.S(FTSSOSHomeWebViewUI.this);
                            FTSSOSHomeWebViewUI.this.uBf.setVisibility(8);
                            FTSSOSHomeWebViewUI.d(FTSSOSHomeWebViewUI.this, 0);
                            FTSSOSHomeWebViewUI.this.uBb.b(com.tencent.mm.plugin.webview.ui.tools.fts.a.b.Init);
                            FTSSOSHomeWebViewUI.a(FTSSOSHomeWebViewUI.this, com.tencent.mm.plugin.webview.ui.tools.fts.a.b.Init);
                            break;
                        }
                        FTSSOSHomeWebViewUI.this.finish();
                        break;
                    case 5:
                        if (FTSSOSHomeWebViewUI.this.dby().getEditText().hasFocus()) {
                            b.this.b((com.tencent.mm.sdk.d.a) b.this.uBQ);
                            h.pYm.e(15521, Integer.valueOf(FTSSOSHomeWebViewUI.this.scene), Integer.valueOf(2), FTSSOSHomeWebViewUI.this.dby().getInEditTextQuery(), Long.valueOf(System.currentTimeMillis()), Integer.valueOf(FTSSOSHomeWebViewUI.this.uAO));
                            break;
                        }
                        break;
                    case 9:
                        b.this.b((com.tencent.mm.sdk.d.a) b.this.uBP);
                        break;
                    case 10:
                        if (FTSSOSHomeWebViewUI.this.getTotalQuery().length() > 0) {
                            b.this.b((com.tencent.mm.sdk.d.a) b.this.uBR);
                            break;
                        }
                        break;
                }
                boolean k = super.k(message);
                AppMethodBeat.o(8467);
                return k;
            }

            public final String getName() {
                return "SearchWithFocusNoResultState";
            }
        }

        class d extends com.tencent.mm.sdk.d.b {
            private d() {
            }

            /* synthetic */ d(b bVar, byte b) {
                this();
            }

            public final void enter() {
                AppMethodBeat.i(8468);
                super.enter();
                FTSSOSHomeWebViewUI.this.dby().bBq();
                FTSSOSHomeWebViewUI.this.uAV.setVisibility(0);
                FTSSOSHomeWebViewUI.this.uAr.setPadding(FTSSOSHomeWebViewUI.this.uBl, 0, 0, 0);
                FTSSOSHomeWebViewUI.this.uBf.setVisibility(8);
                FTSSOSHomeWebViewUI.this.uAs.setSearchBarCancelTextContainerVisibile(8);
                FTSSOSHomeWebViewUI.this.uAs.setVoiceImageButtonVisibile(8);
                FTSSOSHomeWebViewUI.i(FTSSOSHomeWebViewUI.this);
                FTSSOSHomeWebViewUI.this.mJe.setVisibility(8);
                FTSSOSHomeWebViewUI.this.uBd.setVisibility(8);
                FTSSOSHomeWebViewUI.this.qzN.setVisibility(0);
                if (!FTSSOSHomeWebViewUI.this.dby().mLL.hasFocus()) {
                    FTSSOSHomeWebViewUI.this.dby().bBo();
                    FTSSOSHomeWebViewUI.this.showVKB();
                }
                if (com.tencent.mm.compatible.util.d.iW(23) && !com.tencent.mm.sdk.h.b.Mt()) {
                    FTSSOSHomeWebViewUI.i(FTSSOSHomeWebViewUI.this, FTSSOSHomeWebViewUI.this.getResources().getColor(R.color.a69));
                }
                if (!TextUtils.isEmpty(FTSSOSHomeWebViewUI.this.getInEditTextQuery())) {
                    FTSSOSHomeWebViewUI.this.dby().bBt();
                }
                FTSSOSHomeWebViewUI.h(FTSSOSHomeWebViewUI.this, FTSSOSHomeWebViewUI.this.uAO);
                AppMethodBeat.o(8468);
            }

            public final void exit() {
                AppMethodBeat.i(8469);
                super.exit();
                FTSSOSHomeWebViewUI.this.aqX();
                AppMethodBeat.o(8469);
            }

            public final boolean k(Message message) {
                AppMethodBeat.i(8470);
                switch (message.what) {
                    case 0:
                    case 11:
                        if (FTSSOSHomeWebViewUI.this.getTotalQuery().length() > 0) {
                            b.this.b((com.tencent.mm.sdk.d.a) b.this.uBR);
                            break;
                        }
                        break;
                    case 2:
                        if (!FTSSOSHomeWebViewUI.this.uBp) {
                            FTSSOSHomeWebViewUI.S(FTSSOSHomeWebViewUI.this);
                            FTSSOSHomeWebViewUI.this.uBf.setVisibility(8);
                            FTSSOSHomeWebViewUI.d(FTSSOSHomeWebViewUI.this, 0);
                            FTSSOSHomeWebViewUI.this.uBa.b(com.tencent.mm.plugin.webview.ui.tools.fts.a.b.Init);
                            FTSSOSHomeWebViewUI.a(FTSSOSHomeWebViewUI.this, com.tencent.mm.plugin.webview.ui.tools.fts.a.b.Init);
                            break;
                        }
                        FTSSOSHomeWebViewUI.this.finish();
                        break;
                    case 3:
                    case 4:
                        b.this.b((com.tencent.mm.sdk.d.a) b.this.uBP);
                        break;
                    case 5:
                        if (!FTSSOSHomeWebViewUI.this.dby().getEditText().hasFocus()) {
                            b.this.b((com.tencent.mm.sdk.d.a) b.this.uBR);
                            break;
                        }
                        h.pYm.e(15521, Integer.valueOf(FTSSOSHomeWebViewUI.this.scene), Integer.valueOf(2), FTSSOSHomeWebViewUI.this.dby().getInEditTextQuery(), Long.valueOf(System.currentTimeMillis()), Integer.valueOf(FTSSOSHomeWebViewUI.this.uAO));
                        break;
                }
                boolean k = super.k(message);
                AppMethodBeat.o(8470);
                return k;
            }

            public final String getName() {
                return "SearchWithFocusState";
            }
        }

        class b extends com.tencent.mm.sdk.d.b {
            private b() {
            }

            /* synthetic */ b(b bVar, byte b) {
                this();
            }

            public final void enter() {
                AppMethodBeat.i(8462);
                super.enter();
                FTSSOSHomeWebViewUI.a(FTSSOSHomeWebViewUI.this, com.tencent.mm.plugin.webview.ui.tools.fts.a.b.Search);
                FTSSOSHomeWebViewUI.this.uAr.setBackgroundResource(R.color.a69);
                FTSSOSHomeWebViewUI.this.uAs.mLL.clearFocus();
                FTSSOSHomeWebViewUI.this.aqX();
                FTSSOSHomeWebViewUI.this.uAV.setVisibility(0);
                FTSSOSHomeWebViewUI.this.uAr.setPadding(FTSSOSHomeWebViewUI.this.uBl, 0, 0, 0);
                FTSSOSHomeWebViewUI.this.dby().bBs();
                FTSSOSHomeWebViewUI.this.oOO.setVisibility(0);
                FTSSOSHomeWebViewUI.this.dby().bBq();
                FTSSOSHomeWebViewUI.this.uAY.clear();
                FTSSOSHomeWebViewUI.this.qpb.setVisibility(0);
                FTSSOSHomeWebViewUI.this.mJe.setVisibility(8);
                FTSSOSHomeWebViewUI.this.uBd.setVisibility(8);
                FTSSOSHomeWebViewUI.this.uAs.setSearchBarCancelTextContainerVisibile(0);
                FTSSOSHomeWebViewUI.this.uAs.setVoiceImageButtonVisibile(0);
                FTSSOSHomeWebViewUI.this.uAs.bBs();
                FTSSOSHomeWebViewUI.this.uBm;
                if (!FTSSOSHomeWebViewUI.this.uBp) {
                    FTSSOSHomeWebViewUI.this.dby().bBq();
                }
                FTSSOSHomeWebViewUI.this.qzN.setVisibility(0);
                if (com.tencent.mm.compatible.util.d.iW(23) && !com.tencent.mm.sdk.h.b.Mt()) {
                    FTSSOSHomeWebViewUI.g(FTSSOSHomeWebViewUI.this, FTSSOSHomeWebViewUI.this.getResources().getColor(R.color.a69));
                }
                FTSSOSHomeWebViewUI.this.titleView.setAlpha(0.0f);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) FTSSOSHomeWebViewUI.this.uAr.getLayoutParams();
                layoutParams.leftMargin = 0;
                layoutParams.rightMargin = 0;
                if (FTSSOSHomeWebViewUI.this.uBp) {
                    layoutParams.topMargin = 0;
                }
                layoutParams.width = -1;
                FTSSOSHomeWebViewUI.this.uAr.setLayoutParams(layoutParams);
                FTSSOSHomeWebViewUI.this.uAr.setY(0.0f);
                FTSSOSHomeWebViewUI.this.uAr.setX(0.0f);
                if (FTSSOSHomeWebViewUI.this.uBp) {
                    FTSSOSHomeWebViewUI.this.uAr.setTranslationX(0.0f);
                    FTSSOSHomeWebViewUI.this.uAr.setTranslationY(0.0f);
                }
                if (FTSSOSHomeWebViewUI.this.uBp && FTSSOSHomeWebViewUI.this.uBq) {
                    FTSSOSHomeWebViewUI.this.uAr.setVisibility(8);
                    FTSSOSHomeWebViewUI.this.titleView.setAlpha(1.0f);
                    FTSSOSHomeWebViewUI.this.qpb.setVisibility(0);
                    FTSSOSHomeWebViewUI.this.titleView.setVisibility(0);
                    if (FTSSOSHomeWebViewUI.this.getIntent() != null && FTSSOSHomeWebViewUI.this.getIntent().hasExtra("customize_status_bar_color")) {
                        FTSSOSHomeWebViewUI.this.uBj.setBackgroundColor(FTSSOSHomeWebViewUI.this.nfs);
                        if (FTSSOSHomeWebViewUI.this.getIntent().hasExtra("status_bar_style")) {
                            FTSSOSHomeWebViewUI.a(FTSSOSHomeWebViewUI.this, FTSSOSHomeWebViewUI.this.nfs, "black".equals(FTSSOSHomeWebViewUI.this.nft));
                        }
                    }
                }
                FTSSOSHomeWebViewUI.h(FTSSOSHomeWebViewUI.this, FTSSOSHomeWebViewUI.this.uAO);
                AppMethodBeat.o(8462);
            }

            public final void exit() {
                AppMethodBeat.i(8463);
                super.exit();
                AppMethodBeat.o(8463);
            }

            public final boolean k(Message message) {
                AppMethodBeat.i(8464);
                switch (message.what) {
                    case 0:
                        FTSSOSHomeWebViewUI.this.dby().bBs();
                        break;
                    case 2:
                        if (!FTSSOSHomeWebViewUI.this.uBp) {
                            FTSSOSHomeWebViewUI.S(FTSSOSHomeWebViewUI.this);
                            FTSSOSHomeWebViewUI.this.uBf.setVisibility(8);
                            FTSSOSHomeWebViewUI.d(FTSSOSHomeWebViewUI.this, 0);
                            FTSSOSHomeWebViewUI.this.uAZ.b(com.tencent.mm.plugin.webview.ui.tools.fts.a.b.Init);
                            FTSSOSHomeWebViewUI.a(FTSSOSHomeWebViewUI.this, com.tencent.mm.plugin.webview.ui.tools.fts.a.b.Init);
                            break;
                        }
                        FTSSOSHomeWebViewUI.this.finish();
                        break;
                    case 3:
                    case 4:
                        b.this.b((com.tencent.mm.sdk.d.a) b.this.uBP);
                        break;
                    case 5:
                        if (FTSSOSHomeWebViewUI.this.dby().getEditText().hasFocus()) {
                            b.this.b((com.tencent.mm.sdk.d.a) b.this.uBQ);
                            h.pYm.e(15521, Integer.valueOf(FTSSOSHomeWebViewUI.this.scene), Integer.valueOf(2), FTSSOSHomeWebViewUI.this.dby().getInEditTextQuery(), Long.valueOf(System.currentTimeMillis()), Integer.valueOf(FTSSOSHomeWebViewUI.this.uAO));
                            break;
                        }
                        break;
                }
                boolean k = super.k(message);
                AppMethodBeat.o(8464);
                return k;
            }

            public final String getName() {
                return "SearchNoFocusState";
            }
        }

        protected b(String str, Looper looper) {
            super(str, looper);
            AppMethodBeat.i(8471);
            a(this.uBP);
            a(this.uBQ);
            a(this.uBR);
            a(this.uBS);
            b(this.uBP);
            AppMethodBeat.o(8471);
        }

        public final void dbM() {
            AppMethodBeat.i(8472);
            FTSSOSHomeWebViewUI.this.uAs.setSearchBarCancelTextContainerVisibile(0);
            b(this.uBP);
            AppMethodBeat.o(8472);
        }

        public final boolean dbC() {
            AppMethodBeat.i(8473);
            com.tencent.mm.sdk.d.a dpQ = dpQ();
            if (dpQ == this.uBQ || dpQ == this.uBR || dpQ == this.uBS) {
                AppMethodBeat.o(8473);
                return true;
            }
            AppMethodBeat.o(8473);
            return false;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public FTSSOSHomeWebViewUI() {
        AppMethodBeat.i(8475);
        AppMethodBeat.o(8475);
    }

    static /* synthetic */ void A(FTSSOSHomeWebViewUI fTSSOSHomeWebViewUI) {
        AppMethodBeat.i(8514);
        fTSSOSHomeWebViewUI.dbK();
        AppMethodBeat.o(8514);
    }

    static /* synthetic */ void d(FTSSOSHomeWebViewUI fTSSOSHomeWebViewUI, int i) {
        AppMethodBeat.i(8509);
        fTSSOSHomeWebViewUI.JB(i);
        AppMethodBeat.o(8509);
    }

    static /* synthetic */ String f(FTSSOSHomeWebViewUI fTSSOSHomeWebViewUI, int i) {
        AppMethodBeat.i(8510);
        String JC = fTSSOSHomeWebViewUI.JC(i);
        AppMethodBeat.o(8510);
        return JC;
    }

    static /* synthetic */ void g(FTSSOSHomeWebViewUI fTSSOSHomeWebViewUI, int i) {
        AppMethodBeat.i(8518);
        fTSSOSHomeWebViewUI.at(i, true);
        AppMethodBeat.o(8518);
    }

    static /* synthetic */ void h(FTSSOSHomeWebViewUI fTSSOSHomeWebViewUI, int i) {
        AppMethodBeat.i(8520);
        fTSSOSHomeWebViewUI.JD(i);
        AppMethodBeat.o(8520);
    }

    static /* synthetic */ void i(FTSSOSHomeWebViewUI fTSSOSHomeWebViewUI) {
        AppMethodBeat.i(8508);
        fTSSOSHomeWebViewUI.dbL();
        AppMethodBeat.o(8508);
    }

    static /* synthetic */ void i(FTSSOSHomeWebViewUI fTSSOSHomeWebViewUI, int i) {
        AppMethodBeat.i(8522);
        fTSSOSHomeWebViewUI.at(i, true);
        AppMethodBeat.o(8522);
    }

    public void onCreate(Bundle bundle) {
        boolean z = false;
        AppMethodBeat.i(8476);
        super.onCreate(bundle);
        if (getIntent() != null && getIntent().getBooleanExtra("ftsInitToSearch", false)) {
            z = true;
        }
        this.uBp = z;
        this.uBu = new WeappWebSearchFragment();
        Bundle bundle2 = new Bundle();
        bundle2.putString("url", getIntent().getStringExtra("key_weapp_url"));
        this.uBu.setArguments(bundle2);
        getSupportFragmentManager().beginTransaction().a((int) R.id.eo8, this.uBu).commit();
        AppMethodBeat.o(8476);
    }

    public final void aMh() {
        Bundle bundle;
        AppMethodBeat.i(8478);
        super.aMh();
        this.uBk = new b("sos_home_webview_ui", getMainLooper());
        this.qpb = findViewById(R.id.eoj);
        this.uBj = findViewById(R.id.eok);
        this.uBh = findViewById(R.id.eo9);
        this.uBf = findViewById(R.id.eod);
        this.uBg = (TextView) findViewById(R.id.eoe);
        this.uBf.setOnClickListener(this.uBE);
        this.uAW = findViewById(R.id.eo8);
        this.uAX = findViewById(R.id.nc);
        this.titleView = (TextView) findViewById(R.id.qm);
        this.uAV = findViewById(R.id.bhl);
        ((WebViewKeyboardLinearLayout) this.uAV).setOnkbdStateListener(new com.tencent.mm.ui.KeyboardLinearLayout.a() {
            public final void sD(int i) {
                AppMethodBeat.i(8440);
                if (FTSSOSHomeWebViewUI.this.uBk == null) {
                    AppMethodBeat.o(8440);
                    return;
                }
                if (i == -2) {
                    FTSSOSHomeWebViewUI.this.uBk.sendMessage(12);
                }
                FTSSOSHomeWebViewUI.this.jYe = i;
                AppMethodBeat.o(8440);
            }
        });
        this.mJe = (FTSMainUIEducationLayout) findViewById(R.id.byx);
        this.mJe.setOnCellClickListener(this.mJH);
        this.mJe.setCellClickable(false);
        this.mJe.getViewTreeObserver().addOnGlobalLayoutListener(new OnGlobalLayoutListener() {
            public final void onGlobalLayout() {
                AppMethodBeat.i(8441);
                if (FTSSOSHomeWebViewUI.this.qpb.getHeight() <= 0) {
                    AppMethodBeat.o(8441);
                    return;
                }
                FTSSOSHomeWebViewUI.this.mJe.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                FTSSOSHomeWebViewUI.this.uCg.countDown();
                if (FTSSOSHomeWebViewUI.this.uAr.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
                    FTSSOSHomeWebViewUI.this.uBr = ((RelativeLayout.LayoutParams) FTSSOSHomeWebViewUI.this.uAr.getLayoutParams()).topMargin;
                }
                if (FTSSOSHomeWebViewUI.this.mJe.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
                    FTSSOSHomeWebViewUI.this.uBs = ((RelativeLayout.LayoutParams) FTSSOSHomeWebViewUI.this.mJe.getLayoutParams()).topMargin;
                    if (FTSSOSHomeWebViewUI.this.uCf && FTSSOSHomeWebViewUI.this.pzf.getTopView() != null && (FTSSOSHomeWebViewUI.this.pzf.getTopView() instanceof AbsoluteLayout)) {
                        ((ViewGroup) FTSSOSHomeWebViewUI.this.mJe.getParent()).removeView(FTSSOSHomeWebViewUI.this.mJe);
                        ((AbsoluteLayout) FTSSOSHomeWebViewUI.this.pzf.getTopView()).addView(FTSSOSHomeWebViewUI.this.mJe, new AbsoluteLayout.LayoutParams(-1, -2, 0, FTSSOSHomeWebViewUI.this.uBs - FTSSOSHomeWebViewUI.this.qpb.getHeight()));
                    }
                }
                FTSSOSHomeWebViewUI.h(FTSSOSHomeWebViewUI.this);
                AppMethodBeat.o(8441);
            }
        });
        this.uBe = (FTSMainUIEducationLayoutWithAll) findViewById(R.id.eo_);
        this.uBe.setOnCellClickListener(this.mJH);
        this.uBe.setCellClickable(true);
        this.uBd = (FTSMainUIHotWordLayout) findViewById(R.id.eog);
        this.uBd.setOnCellClickListener(this.uBw);
        this.uAZ = new b(this, this.uAr, this.titleView, dby().getIconView(), this.oOO, this.oOO, dby().getEditText(), this.uBi, this.qpb, this.uBj);
        this.uAZ.a(this.uBx);
        this.uBa = new c(this, this.uAr, this.titleView, dby().getIconView(), this.oOO, this.oOO, dby().getEditText(), this.uBi, this.qpb, this.uBj);
        this.uBa.a(this.uBz);
        this.uBb = new d(this, this.uAr, this.titleView, dby().getIconView(), this.oOO, this.oOO, dby().getEditText(), this.uBi, this.qpb, this.uBj);
        this.uBb.a(this.uBy);
        this.uAY = new a(this, (byte) 0);
        this.qzN = findViewById(R.id.eoi);
        try {
            bundle = new Bundle();
            bundle.putString("key", "educationTab");
            Bundle p = this.icy.p(2, bundle);
            String string = p.getString("result");
            String string2 = p.getString("result_1");
            if (string2 != null) {
                string = string2;
            }
            this.mJe.S(new JSONObject(string));
        } catch (Exception e) {
        }
        try {
            bundle = new Bundle();
            bundle.putString("key", "tabSlice");
            this.uBe.S(new JSONObject(this.icy.p(2, bundle).getString("result")));
        } catch (Exception e2) {
        }
        findViewById(R.id.a3u).setOnTouchListener(new OnTouchListener() {
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(8442);
                FTSSOSHomeWebViewUI.this.dby().mLL.clearFocus();
                FTSSOSHomeWebViewUI.this.aqX();
                AppMethodBeat.o(8442);
                return false;
            }
        });
        this.uBh.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(8443);
                FTSSOSHomeWebViewUI.i(FTSSOSHomeWebViewUI.this);
                AppMethodBeat.o(8443);
            }
        });
        this.titleView.setText(getIntent().getStringExtra("title"));
        this.uBl = ((RelativeLayout.LayoutParams) this.titleView.getLayoutParams()).leftMargin - ((int) getResources().getDimension(R.dimen.a9t));
        dby().dJf();
        boolean z = getIntent() != null && getIntent().getBooleanExtra("ftsInitToSearch", false);
        this.uBp = z;
        if (getIntent() == null || !getIntent().getBooleanExtra("hideSearchInput", false)) {
            z = false;
        } else {
            z = true;
        }
        this.uBq = z;
        if (this.uBk != null) {
            if (this.uBp) {
                this.uBj.setBackgroundColor(getResources().getColor(R.color.a3p));
                b bVar = this.uBk;
                bVar.b(bVar.uBR);
                if (com.tencent.mm.compatible.util.d.iW(23) && !com.tencent.mm.compatible.util.h.Mt()) {
                    at(getResources().getColor(R.color.a69), true);
                }
                if (this.type == 64) {
                    this.uBv = true;
                    this.uAX.setVisibility(8);
                    this.uAW.setVisibility(0);
                }
            } else {
                this.uBk.dbM();
            }
            this.uBk.start();
        }
        try {
            bundle = new Bundle();
            bundle.putString("key", "searchID");
            this.uBo = this.icy.p(6, bundle).getString("result");
            an.as(this.uBo, getSessionId(), this.mJe.getVertBizTypes());
        } catch (Exception e3) {
        }
        an.Ij(bFf());
        dbH();
        this.uAr.getViewTreeObserver().addOnPreDrawListener(new OnPreDrawListener() {
            public final boolean onPreDraw() {
                AppMethodBeat.i(8444);
                FTSSOSHomeWebViewUI.this.uAr.getViewTreeObserver().removeOnPreDrawListener(this);
                FTSSOSHomeWebViewUI.this.uBc = FTSSOSHomeWebViewUI.this.uAr.getX();
                AppMethodBeat.o(8444);
                return true;
            }
        });
        if (this.uCf) {
            this.uAV.setVisibility(0);
        } else {
            this.uAV.setVisibility(4);
        }
        this.uAs.setVoiceBtnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                int i = 2;
                AppMethodBeat.i(8445);
                ab.i("MicroMsg.FTS.FTSSOSHomeWebViewUI", "summerper checkPermission checkmicrophone[%s], stack[%s], activity[%s]", Boolean.valueOf(com.tencent.mm.pluginsdk.permission.b.a(FTSSOSHomeWebViewUI.this, "android.permission.RECORD_AUDIO", 80, "", "")), bo.dpG(), FTSSOSHomeWebViewUI.this);
                if (com.tencent.mm.pluginsdk.permission.b.a(FTSSOSHomeWebViewUI.this, "android.permission.RECORD_AUDIO", 80, "", "")) {
                    Intent intent = new Intent();
                    intent.putExtra("sessionId", FTSSOSHomeWebViewUI.this.cvF);
                    intent.putExtra("subSessionId", FTSSOSHomeWebViewUI.this.cIy);
                    intent.putExtra("key_scene", FTSSOSHomeWebViewUI.this.scene);
                    String str = "key_is_nav_voice";
                    if (FTSSOSHomeWebViewUI.this.dbC()) {
                        i = 1;
                    }
                    intent.putExtra(str, i);
                    d.b(FTSSOSHomeWebViewUI.this, ".ui.websearch.WebSearchVoiceUI", intent, 1);
                    FTSSOSHomeWebViewUI.this.overridePendingTransition(0, 0);
                    AppMethodBeat.o(8445);
                    return;
                }
                AppMethodBeat.o(8445);
            }
        });
        this.uAs.setCancelTextViewClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(8446);
                FTSSOSHomeWebViewUI.this.dbu();
                AppMethodBeat.o(8446);
            }
        });
        JB(this.uAO);
        ImageButton clearBtn = dby().getClearBtn();
        if (clearBtn != null) {
            clearBtn.getDrawable().setColorFilter(WebView.NIGHT_MODE_COLOR, Mode.SRC_ATOP);
        }
        AppMethodBeat.o(8478);
    }

    private boolean dbG() {
        return this.scene == 36;
    }

    private void dbH() {
        AppMethodBeat.i(8479);
        if (this.pzf == null) {
            AppMethodBeat.o(8479);
            return;
        }
        final AbsoluteLayout absoluteLayout = (AbsoluteLayout) this.pzf.getView();
        absoluteLayout.setOnTouchListener(new OnTouchListener() {
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(8447);
                if (FTSSOSHomeWebViewUI.this.uBk != null) {
                    b a = FTSSOSHomeWebViewUI.this.uBk;
                    com.tencent.mm.sdk.d.d.c cVar = a.xCt;
                    if (cVar != null) {
                        cVar.sendMessage(Message.obtain(a.xCt, 15, motionEvent));
                    }
                }
                boolean onTouchEvent = absoluteLayout.onTouchEvent(motionEvent);
                AppMethodBeat.o(8447);
                return onTouchEvent;
            }
        });
        AppMethodBeat.o(8479);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(8480);
        super.onActivityResult(i, i2, intent);
        switch (i) {
            case 1:
                if (intent != null) {
                    String stringExtra = intent.getStringExtra("text");
                    if (!TextUtils.isEmpty(stringExtra)) {
                        ab.i("MicroMsg.FTS.FTSSOSHomeWebViewUI", "voice input final text len %d , text %s", Integer.valueOf(agb(stringExtra).length()), stringExtra);
                        this.uAs.n(stringExtra, null);
                        aMo();
                        AppMethodBeat.o(8480);
                        return;
                    }
                }
                AppMethodBeat.o(8480);
                return;
            default:
                AppMethodBeat.o(8480);
                return;
        }
    }

    private static String agb(String str) {
        AppMethodBeat.i(8481);
        if (str != null) {
            try {
                if (f.asg(str) <= 100) {
                    AppMethodBeat.o(8481);
                } else {
                    if (str.length() > 200) {
                        str = str.substring(0, 200);
                    }
                    char[] toCharArray = str.toCharArray();
                    int length = toCharArray.length;
                    int i = 0;
                    int i2 = 0;
                    int i3 = 0;
                    while (i < length) {
                        i3 += f.asg(String.valueOf(toCharArray[i]));
                        if (i3 >= 100) {
                            str = str.substring(0, i2) + 8230;
                            AppMethodBeat.o(8481);
                            break;
                        }
                        i++;
                        i2++;
                    }
                }
            } catch (Exception e) {
                AppMethodBeat.o(8481);
            }
            return str;
        }
        AppMethodBeat.o(8481);
        return str;
    }

    public final int dbI() {
        return 1;
    }

    public void onResume() {
        AppMethodBeat.i(8482);
        super.onResume();
        an.cVv();
        AppMethodBeat.o(8482);
    }

    public void onPause() {
        AppMethodBeat.i(8483);
        super.onPause();
        an.cVw();
        AppMethodBeat.o(8483);
    }

    public void onDestroy() {
        AppMethodBeat.i(8484);
        super.onDestroy();
        an.cVx();
        an.cVy();
        AppMethodBeat.o(8484);
    }

    /* Access modifiers changed, original: protected|final */
    public final Map<String, Object> dbJ() {
        AppMethodBeat.i(8485);
        HashMap hashMap = new HashMap();
        if (this.mJe == null || this.qpb == null) {
            AppMethodBeat.o(8485);
            return hashMap;
        }
        int bottom;
        ab.i("MicroMsg.FTS.FTSSOSHomeWebViewUI", "getOnUiInitParams edu.bottom %d, title.bottom %d", Integer.valueOf(this.mJe.getBottom()), Integer.valueOf(this.qpb.getBottom()));
        if (this.mJe.getTop() < this.qpb.getBottom()) {
            bottom = this.mJe.getBottom() - this.qpb.getBottom();
        } else {
            bottom = this.mJe.getBottom();
        }
        hashMap.put("nativeHeight", Integer.valueOf(com.tencent.mm.bz.a.ao(this, bottom)));
        try {
            Bundle p = this.icy.p(7, null);
            CharSequence string = p == null ? "" : p.getString("data");
            if (!TextUtils.isEmpty(string)) {
                hashMap.put("operationData", string);
            }
        } catch (RemoteException e) {
            ab.printErrStackTrace("MicroMsg.FTS.FTSSOSHomeWebViewUI", e, "", new Object[0]);
        }
        AppMethodBeat.o(8485);
        return hashMap;
    }

    public final int aMi() {
        boolean z = false;
        AppMethodBeat.i(8486);
        if (getIntent() != null && getIntent().getBooleanExtra("ftsInitToSearch", false)) {
            z = true;
        }
        this.uBp = z;
        int aMi;
        if (!com.tencent.mm.compatible.util.d.iW(23) || com.tencent.mm.sdk.h.b.Mt()) {
            aMi = super.aMi();
            AppMethodBeat.o(8486);
            return aMi;
        } else if (this.uBp) {
            AppMethodBeat.o(8486);
            return -1;
        } else {
            aMi = getResources().getColor(R.color.a5q);
            AppMethodBeat.o(8486);
            return aMi;
        }
    }

    public final void hz(boolean z) {
        AppMethodBeat.i(8487);
        if (this.uBk == null) {
            AppMethodBeat.o(8487);
            return;
        }
        if (this.uBk.dbC()) {
            super.hz(z);
        }
        this.uBk.sendMessage(5);
        AppMethodBeat.o(8487);
    }

    /* Access modifiers changed, original: protected|final */
    public final void dbt() {
        AppMethodBeat.i(8488);
        super.dbt();
        JB(this.uAO);
        dby().setHint(JC(this.uAO));
        AppMethodBeat.o(8488);
    }

    private void dbK() {
        AppMethodBeat.i(8489);
        try {
            this.uAY.clear();
            ab.i("MicroMsg.FTS.FTSSOSHomeWebViewUI", "start to update history");
            Bundle bundle = new Bundle();
            bundle.putInt("webview_id", hashCode());
            bundle.putString(SearchIntents.EXTRA_QUERY, getInEditTextQuery());
            bundle.putInt("count", 6);
            bundle.putInt("scene", bFf());
            this.icy.j(3, bundle);
            AppMethodBeat.o(8489);
        } catch (RemoteException e) {
            AppMethodBeat.o(8489);
        }
    }

    public final void a(String str, String str2, List<com.tencent.mm.plugin.fts.ui.widget.a.b> list, com.tencent.mm.plugin.fts.ui.widget.FTSEditTextView.b bVar) {
        AppMethodBeat.i(8490);
        if (bVar == com.tencent.mm.plugin.fts.ui.widget.FTSEditTextView.b.UserInput) {
            this.uBB = 0;
        }
        if (this.uBk.dbC()) {
            super.a(str, str2, list, bVar);
            AppMethodBeat.o(8490);
        } else if (getTotalQuery().length() == 0) {
            this.mJe.setVisibility(0);
            this.uBd.setVisibility(0);
            this.uAV.setVisibility(0);
            this.uAY.clear();
            AppMethodBeat.o(8490);
        } else {
            this.mJe.setVisibility(8);
            this.uBd.setVisibility(8);
            this.uAV.setVisibility(4);
            if (bVar != com.tencent.mm.plugin.fts.ui.widget.FTSEditTextView.b.SetText) {
                dbK();
            }
            AppMethodBeat.o(8490);
        }
    }

    private void JB(int i) {
        AppMethodBeat.i(8492);
        this.uBe.setSelected(i);
        this.uBg.setText(this.uBe.wg(i));
        dby().setIconRes(com.tencent.mm.bd.a.b(i, this.mController.ylL));
        AppMethodBeat.o(8492);
    }

    /* Access modifiers changed, original: protected|final */
    public final void dbs() {
        AppMethodBeat.i(8493);
        super.dbs();
        this.uBk.sendMessage(11);
        AppMethodBeat.o(8493);
    }

    public final int dbx() {
        return this.uBB;
    }

    /* Access modifiers changed, original: protected|final */
    public final void dbu() {
        AppMethodBeat.i(8494);
        if (this.uBn > 0) {
            AppMethodBeat.o(8494);
            return;
        }
        super.dbu();
        dby().setHint(getHint());
        this.uBk.sendMessage(2);
        this.uAr.setBackgroundResource(R.drawable.a1t);
        this.qzN.setVisibility(8);
        this.uBA = null;
        this.uBB = 0;
        this.uBv = false;
        this.uAX.setVisibility(0);
        this.uAW.setVisibility(8);
        h.pYm.e(15521, Integer.valueOf(this.scene), Integer.valueOf(1), dby().getInEditTextQuery(), Long.valueOf(System.currentTimeMillis()), Integer.valueOf(this.uAO));
        AppMethodBeat.o(8494);
    }

    /* Access modifiers changed, original: protected|final */
    public final void dbv() {
        AppMethodBeat.i(8495);
        super.dbv();
        if (!this.uCf) {
            this.uAV.setVisibility(0);
            if (this.pzf.getTopView() != null && (this.pzf.getTopView() instanceof AbsoluteLayout)) {
                ((ViewGroup) this.mJe.getParent()).removeView(this.mJe);
                ((AbsoluteLayout) this.pzf.getTopView()).addView(this.mJe, new AbsoluteLayout.LayoutParams(-1, -2, 0, this.uBs - this.qpb.getHeight()));
            }
        }
        AppMethodBeat.o(8495);
    }

    public final int getLayoutId() {
        return R.layout.axa;
    }

    /* Access modifiers changed, original: protected|final */
    public final String getHint() {
        AppMethodBeat.i(8496);
        String JC = JC(dbA());
        AppMethodBeat.o(8496);
        return JC;
    }

    public final void j(int i, Bundle bundle) {
        AppMethodBeat.i(8497);
        if (this.uBv && this.uBu.x(i, bundle)) {
            AppMethodBeat.o(8497);
            return;
        }
        super.j(i, bundle);
        switch (i) {
            case com.tencent.view.d.MIC_AVROUND_BLUR /*119*/:
                this.uBk.sendMessage(8);
                AppMethodBeat.o(8497);
                return;
            case 122:
                this.uBk.sendMessage(10);
                AppMethodBeat.o(8497);
                return;
            case 126:
                ArrayList arrayList = new ArrayList();
                if (dby().mLL.hasFocus()) {
                    String string = bundle.getString(SearchIntents.EXTRA_QUERY);
                    if (getInEditTextQuery().equals(string)) {
                        int i2 = 0;
                        for (String str : bundle.getStringArrayList("result")) {
                            if (com.tencent.mm.bd.a.aO(str, string)) {
                                i2++;
                                if (i2 <= 2) {
                                    c cVar = new c(this, (byte) 0);
                                    cVar.type = 1;
                                    cVar.icon = R.raw.sos_history;
                                    cVar.content = str;
                                    cVar.uBV = R.drawable.a1s;
                                    arrayList.add(cVar);
                                }
                            }
                        }
                    }
                }
                al.d(new AnonymousClass1(arrayList));
                AppMethodBeat.o(8497);
                return;
            case com.tencent.view.d.MIC_SketchMark /*127*/:
                ArrayList arrayList2 = new ArrayList();
                if (dby().mLL.hasFocus()) {
                    if (getInEditTextQuery().equals(bundle.getString(SearchIntents.EXTRA_QUERY))) {
                        this.uBA = bundle.getString("suggestionId");
                        for (String str2 : bundle.getStringArrayList("result")) {
                            c cVar2 = new c(this, (byte) 0);
                            cVar2.type = 2;
                            cVar2.icon = 0;
                            cVar2.content = str2;
                            cVar2.uBV = R.drawable.a1u;
                            arrayList2.add(cVar2);
                        }
                    }
                }
                al.d(new AnonymousClass3(arrayList2));
                AppMethodBeat.o(8497);
                return;
            case 130:
                AppMethodBeat.o(8497);
                return;
            case n.CTRL_INDEX /*136*/:
                bundle.getString("fts_key_new_query", "");
                this.uBk.sendMessage(13);
                break;
        }
        AppMethodBeat.o(8497);
    }

    private String JC(int i) {
        AppMethodBeat.i(8498);
        JD(i);
        int i2 = -1;
        switch (i) {
            case 1:
                i2 = R.string.e0c;
                break;
            case 2:
                i2 = R.string.e0b;
                break;
            case 8:
                i2 = R.string.c1y;
                break;
            case 16:
                i2 = R.string.c1w;
                break;
            case 64:
                i2 = R.string.i9;
                break;
            case 128:
                i2 = R.string.c1m;
                break;
            case 256:
            case 384:
                i2 = R.string.c1l;
                break;
            case 512:
                i2 = R.string.c1u;
                break;
            case WXMediaMessage.DESCRIPTION_LENGTH_LIMIT /*1024*/:
                i2 = R.string.c1v;
                break;
        }
        if (dbG() || this.scene == 53) {
            i2 = R.string.e0w;
        }
        String string;
        if (i2 < 0) {
            string = getString(R.string.e0a, new Object[]{this.uBt});
            AppMethodBeat.o(8498);
            return string;
        }
        string = getString(R.string.e0a, new Object[]{getString(i2)});
        AppMethodBeat.o(8498);
        return string;
    }

    private void JD(int i) {
        AppMethodBeat.i(8499);
        if (this.uBk == null || !this.uBk.dbC()) {
            dby().setEditTextDrawableLeft(-1);
            AppMethodBeat.o(8499);
            return;
        }
        dby().setEditTextDrawableLeft(JE(i));
        AppMethodBeat.o(8499);
    }

    private static int JE(int i) {
        switch (i) {
            case 1:
                return R.raw.websearch_icon_acount;
            case 2:
                return R.raw.websearch_icon_article;
            case 8:
                return R.raw.websearch_icon_moment;
            case 64:
            case 2359360:
                return R.raw.websearch_icon_weapp;
            case 256:
            case 384:
                return R.raw.websearch_icon_emoji;
            case 512:
                return R.raw.websearch_icon_music;
            case WXMediaMessage.DESCRIPTION_LENGTH_LIMIT /*1024*/:
                return R.raw.websearch_icon_novel;
            case 12582912:
                return R.raw.websearch_icon_movie;
            case 16777220:
                return R.raw.websearch_icon_webpage;
            case 16777248:
                return R.raw.websearch_icon_question;
            case 16777728:
                return R.raw.websearch_icon_baike;
            case 16793600:
                return R.raw.websearch_icon_product;
            default:
                return R.raw.websearch_icon_search;
        }
    }

    private void dbL() {
        AppMethodBeat.i(8500);
        if (this.uBe.getVisibility() == 0 && !this.uBF) {
            this.uBF = true;
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.uBe, View.TRANSLATION_Y, new float[]{0.0f, (float) (-this.uBe.getHeight())});
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.uBh, View.ALPHA, new float[]{1.0f, 0.0f});
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.setDuration(300);
            animatorSet.setInterpolator(new AccelerateInterpolator());
            animatorSet.playTogether(new Animator[]{ofFloat2, ofFloat});
            animatorSet.addListener(new AnimatorListener() {
                public final void onAnimationStart(Animator animator) {
                }

                public final void onAnimationEnd(Animator animator) {
                    AppMethodBeat.i(8438);
                    FTSSOSHomeWebViewUI.this.uBe.setVisibility(8);
                    FTSSOSHomeWebViewUI.this.uBh.setVisibility(8);
                    FTSSOSHomeWebViewUI.this.uBF = false;
                    AppMethodBeat.o(8438);
                }

                public final void onAnimationCancel(Animator animator) {
                    AppMethodBeat.i(8439);
                    FTSSOSHomeWebViewUI.this.uBe.setVisibility(8);
                    FTSSOSHomeWebViewUI.this.uBh.setVisibility(8);
                    FTSSOSHomeWebViewUI.this.uBF = false;
                    AppMethodBeat.o(8439);
                }

                public final void onAnimationRepeat(Animator animator) {
                }
            });
            animatorSet.start();
        }
        AppMethodBeat.o(8500);
    }

    public void onBackPressed() {
        AppMethodBeat.i(8501);
        if (this.uBe.getVisibility() == 0) {
            dbL();
        } else {
            super.onBackPressed();
        }
        dby().bBs();
        AppMethodBeat.o(8501);
    }

    public final boolean dbC() {
        AppMethodBeat.i(8502);
        if (this.uBk == null) {
            AppMethodBeat.o(8502);
            return false;
        }
        boolean dbC = this.uBk.dbC();
        AppMethodBeat.o(8502);
        return dbC;
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean dbD() {
        AppMethodBeat.i(8503);
        if (!dbC() || this.uAZ.isAnimating || this.uBa.isAnimating || this.uBb.isAnimating) {
            AppMethodBeat.o(8503);
            return false;
        }
        AppMethodBeat.o(8503);
        return true;
    }

    /* Access modifiers changed, original: protected|final */
    public final com.tencent.mm.plugin.webview.ui.tools.jsapi.d getJsapi() {
        AppMethodBeat.i(8504);
        com.tencent.mm.plugin.webview.ui.tools.jsapi.d jsapi;
        if (this.uBv) {
            jsapi = this.uBu.getJsapi();
            AppMethodBeat.o(8504);
            return jsapi;
        }
        jsapi = super.getJsapi();
        AppMethodBeat.o(8504);
        return jsapi;
    }

    public final boolean cZA() {
        return true;
    }

    public final void onWebViewScrollChanged(int i, int i2, int i3, int i4) {
        AppMethodBeat.i(8505);
        super.onWebViewScrollChanged(i, i2, i3, i4);
        int min = Math.min(i2, Math.max(com.tencent.mm.bz.a.fromDPToPix(this, this.pzf.getContentHeight()) - this.pzf.getHeight(), 0));
        this.uAZ.JG(this.uBr - min);
        this.uBa.JG(this.uBr - min);
        this.uBb.JG(this.uBr - min);
        if (!this.uBk.dbC()) {
            this.uAr.setTranslationY((float) (-min));
        }
        if (i2 != 0) {
            dby().mLL.clearFocus();
            aqX();
        }
        AppMethodBeat.o(8505);
    }

    public final void Jw(int i) {
        AppMethodBeat.i(8506);
        if (this.pzf == null || this.pzf.getSettings() == null) {
            AppMethodBeat.o(8506);
            return;
        }
        float f = this.mController.ylL.getSharedPreferences(ah.doA(), 0).getFloat("current_text_size_scale_key", 1.0f);
        if (f >= 2.025f) {
            this.pzf.getSettings().setTextZoom(160);
            AppMethodBeat.o(8506);
        } else if (f >= 1.875f) {
            this.pzf.getSettings().setTextZoom(150);
            AppMethodBeat.o(8506);
        } else if (f >= 1.625f) {
            this.pzf.getSettings().setTextZoom(140);
            AppMethodBeat.o(8506);
        } else if (f >= 1.375f) {
            this.pzf.getSettings().setTextZoom(130);
            AppMethodBeat.o(8506);
        } else if (f >= 1.25f) {
            this.pzf.getSettings().setTextZoom(120);
            AppMethodBeat.o(8506);
        } else if (f >= 1.125f) {
            this.pzf.getSettings().setTextZoom(110);
            AppMethodBeat.o(8506);
        } else if (f >= 1.0f) {
            this.pzf.getSettings().setTextZoom(100);
            AppMethodBeat.o(8506);
        } else if (f >= 0.875f) {
            this.pzf.getSettings().setTextZoom(90);
            AppMethodBeat.o(8506);
        } else {
            this.pzf.getSettings().setTextZoom(80);
            AppMethodBeat.o(8506);
        }
    }

    public final boolean aMo() {
        AppMethodBeat.i(8491);
        if (this.uAy) {
            this.uBk.sendMessage(0);
            super.aMo();
            AppMethodBeat.o(8491);
        } else {
            AppMethodBeat.o(8491);
        }
        return true;
    }

    public final String dbw() {
        if (this.uBB == 0) {
            return "";
        }
        return this.uBA;
    }

    static /* synthetic */ void h(FTSSOSHomeWebViewUI fTSSOSHomeWebViewUI) {
        AppMethodBeat.i(8507);
        if (!fTSSOSHomeWebViewUI.uCf) {
            StringBuilder stringBuilder = new StringBuilder(fTSSOSHomeWebViewUI.cOG);
            ab.v("MicroMsg.FTS.FTSSOSHomeWebViewUI", "beginLoadingUrl edu.bottom %d, title.bottom %d", Integer.valueOf(fTSSOSHomeWebViewUI.mJe.getBottom()), Integer.valueOf(fTSSOSHomeWebViewUI.qpb.getBottom()));
            stringBuilder.append("&nativeHeight=").append(com.tencent.mm.bz.a.ao(fTSSOSHomeWebViewUI, fTSSOSHomeWebViewUI.mJe.getBottom() - fTSSOSHomeWebViewUI.qpb.getBottom()));
            fTSSOSHomeWebViewUI.cOG = stringBuilder.toString();
            fTSSOSHomeWebViewUI.getIntent().putExtra("rawUrl", fTSSOSHomeWebViewUI.cOG);
            fTSSOSHomeWebViewUI.uvm = fTSSOSHomeWebViewUI.cOG;
            fTSSOSHomeWebViewUI.pzf.loadUrl(fTSSOSHomeWebViewUI.cOG);
        }
        AppMethodBeat.o(8507);
    }

    static /* synthetic */ void v(FTSSOSHomeWebViewUI fTSSOSHomeWebViewUI) {
        AppMethodBeat.i(8511);
        fTSSOSHomeWebViewUI.uBn--;
        fTSSOSHomeWebViewUI.uAV.setVisibility(0);
        AppMethodBeat.o(8511);
    }

    static /* synthetic */ void w(FTSSOSHomeWebViewUI fTSSOSHomeWebViewUI) {
        AppMethodBeat.i(8512);
        fTSSOSHomeWebViewUI.uBn++;
        fTSSOSHomeWebViewUI.uAV.setVisibility(4);
        AppMethodBeat.o(8512);
    }

    static /* synthetic */ void B(FTSSOSHomeWebViewUI fTSSOSHomeWebViewUI) {
        AppMethodBeat.i(8515);
        if (fTSSOSHomeWebViewUI.uBe.getVisibility() == 0) {
            fTSSOSHomeWebViewUI.dbL();
            AppMethodBeat.o(8515);
            return;
        }
        if (fTSSOSHomeWebViewUI.uBe.getVisibility() != 0) {
            fTSSOSHomeWebViewUI.uBe.setVisibility(0);
            fTSSOSHomeWebViewUI.uBh.setVisibility(0);
            fTSSOSHomeWebViewUI.uBe.getViewTreeObserver().addOnPreDrawListener(new OnPreDrawListener() {
                public final boolean onPreDraw() {
                    AppMethodBeat.i(8437);
                    FTSSOSHomeWebViewUI.this.uBe.getViewTreeObserver().removeOnPreDrawListener(this);
                    ObjectAnimator ofFloat = ObjectAnimator.ofFloat(FTSSOSHomeWebViewUI.this.uBe, View.TRANSLATION_Y, new float[]{(float) (-FTSSOSHomeWebViewUI.this.uBe.getHeight()), 0.0f});
                    ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(FTSSOSHomeWebViewUI.this.uBh, View.ALPHA, new float[]{0.0f, 1.0f});
                    AnimatorSet animatorSet = new AnimatorSet();
                    animatorSet.setInterpolator(new AccelerateInterpolator());
                    animatorSet.setDuration(300);
                    animatorSet.playTogether(new Animator[]{ofFloat2, ofFloat});
                    animatorSet.start();
                    AppMethodBeat.o(8437);
                    return true;
                }
            });
        }
        AppMethodBeat.o(8515);
    }

    static /* synthetic */ void F(FTSSOSHomeWebViewUI fTSSOSHomeWebViewUI) {
        AppMethodBeat.i(8516);
        ab.i("MicroMsg.FTS.FTSSOSHomeWebViewUI", "setInitStatus originInputX %f, x %f ", Float.valueOf(fTSSOSHomeWebViewUI.uBc), Float.valueOf(fTSSOSHomeWebViewUI.uAr.getX()));
        if (fTSSOSHomeWebViewUI.uBc != Float.MAX_VALUE) {
            fTSSOSHomeWebViewUI.uAr.setX(fTSSOSHomeWebViewUI.uBc);
        }
        fTSSOSHomeWebViewUI.uBj.setBackgroundColor(fTSSOSHomeWebViewUI.getResources().getColor(R.color.a5q));
        fTSSOSHomeWebViewUI.titleView.setVisibility(0);
        fTSSOSHomeWebViewUI.mJe.setVisibility(0);
        fTSSOSHomeWebViewUI.uBd.setVisibility(0);
        View view = fTSSOSHomeWebViewUI.uAV;
        int i = (fTSSOSHomeWebViewUI.uAy || fTSSOSHomeWebViewUI.uCf) ? 0 : 4;
        view.setVisibility(i);
        fTSSOSHomeWebViewUI.qzN.setVisibility(8);
        if (com.tencent.mm.compatible.util.d.iW(23) && !com.tencent.mm.sdk.h.b.Mt()) {
            fTSSOSHomeWebViewUI.at(fTSSOSHomeWebViewUI.getResources().getColor(R.color.a5q), true);
        }
        fTSSOSHomeWebViewUI.dby().bBs();
        fTSSOSHomeWebViewUI.uBf.setVisibility(8);
        fTSSOSHomeWebViewUI.uBe.setVisibility(8);
        fTSSOSHomeWebViewUI.oOO.setVisibility(0);
        fTSSOSHomeWebViewUI.dby().bBr();
        fTSSOSHomeWebViewUI.uAs.bBr();
        fTSSOSHomeWebViewUI.uAr.setPadding(0, 0, 0, 0);
        fTSSOSHomeWebViewUI.JB(0);
        fTSSOSHomeWebViewUI.mJe.setVisibility(0);
        fTSSOSHomeWebViewUI.uBd.setVisibility(0);
        fTSSOSHomeWebViewUI.uAO = 0;
        fTSSOSHomeWebViewUI.uBt = "";
        fTSSOSHomeWebViewUI.dbt();
        fTSSOSHomeWebViewUI.dby().mLL.clearFocus();
        fTSSOSHomeWebViewUI.uAY.clear();
        fTSSOSHomeWebViewUI.uBm = false;
        fTSSOSHomeWebViewUI.dby().setHint(fTSSOSHomeWebViewUI.getHint());
        fTSSOSHomeWebViewUI.uAs.setSearchBarCancelTextContainerVisibile(8);
        fTSSOSHomeWebViewUI.uAs.setVoiceImageButtonVisibile(0);
        fTSSOSHomeWebViewUI.dbH();
        AppMethodBeat.o(8516);
    }

    static /* synthetic */ void S(FTSSOSHomeWebViewUI fTSSOSHomeWebViewUI) {
        AppMethodBeat.i(8521);
        fTSSOSHomeWebViewUI.uBe.setVisibility(8);
        fTSSOSHomeWebViewUI.uBh.setVisibility(8);
        AppMethodBeat.o(8521);
    }
}
