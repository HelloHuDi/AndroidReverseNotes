package com.tencent.p177mm.plugin.webview.p580ui.tools.fts;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.compatible.util.C1443d;
import com.tencent.p177mm.compatible.util.C1448h;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p612ui.KeyboardLinearLayout.C44246a;
import com.tencent.p177mm.p612ui.fts.widget.FTSMainUIEducationLayoutWithAll;
import com.tencent.p177mm.p612ui.fts.widget.FTSMainUIHotWordLayout;
import com.tencent.p177mm.p612ui.fts.widget.FTSMainUIHotWordLayout.C40869a;
import com.tencent.p177mm.p612ui.tools.C5584f;
import com.tencent.p177mm.p835bd.C17977a;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.appbrand.jsapi.p306g.C19395n;
import com.tencent.p177mm.plugin.fts.p424ui.widget.C43138a.C12071b;
import com.tencent.p177mm.plugin.fts.p424ui.widget.FTSEditTextView.C20890b;
import com.tencent.p177mm.plugin.fts.p424ui.widget.FTSMainUIEducationLayout;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.websearch.api.C14423an;
import com.tencent.p177mm.plugin.websearch.api.C29744z;
import com.tencent.p177mm.plugin.websearch.api.C46400aa;
import com.tencent.p177mm.plugin.webview.p580ui.tools.WebViewKeyboardLinearLayout;
import com.tencent.p177mm.plugin.webview.p580ui.tools.fts.C40306a.C29904a;
import com.tencent.p177mm.plugin.webview.p580ui.tools.fts.C40306a.C40305b;
import com.tencent.p177mm.plugin.webview.p580ui.tools.jsapi.C29945i.C23124a;
import com.tencent.p177mm.plugin.webview.p580ui.tools.jsapi.C44786d;
import com.tencent.p177mm.plugin.webview.p580ui.tools.jsapi.C44786d.C2299538;
import com.tencent.p177mm.pluginsdk.permission.C35805b;
import com.tencent.p177mm.sdk.p602d.C15419b;
import com.tencent.p177mm.sdk.p602d.C4886a;
import com.tencent.p177mm.sdk.p602d.C4887d;
import com.tencent.p177mm.sdk.p602d.C4887d.C4890c;
import com.tencent.p177mm.sdk.p602d.C7292c;
import com.tencent.p177mm.sdk.p609h.C4971b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.smtt.sdk.WebView;
import com.tencent.view.C31128d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.webview.ui.tools.fts.FTSSOSHomeWebViewUI */
public class FTSSOSHomeWebViewUI extends BaseSOSWebViewUI {
    private OnClickListener mJH = new C46031();
    private FTSMainUIEducationLayout mJe;
    private View qpb;
    private View qzN;
    private TextView titleView;
    private View uAV;
    private View uAW;
    private View uAX;
    private C35666a uAY;
    private C29907b uAZ;
    private String uBA;
    int uBB;
    private OnClickListener uBC = new C356656();
    private OnItemClickListener uBD = new C402937();
    private OnClickListener uBE = new C145968();
    private boolean uBF;
    private C29911c uBa;
    private C14602d uBb;
    private float uBc = Float.MAX_VALUE;
    private FTSMainUIHotWordLayout uBd;
    private FTSMainUIEducationLayoutWithAll uBe;
    private View uBf;
    private TextView uBg;
    private View uBh;
    private View uBi;
    private View uBj;
    private C40296b uBk;
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
    private OnClickListener uBw = new C46052();
    private C29904a uBx = new C356623();
    private C29904a uBy = new C356634();
    private C29904a uBz = new C356645();

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.fts.FTSSOSHomeWebViewUI$1 */
    class C46031 implements OnClickListener {
        C46031() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(8423);
            FTSSOSHomeWebViewUI.m87565i(FTSSOSHomeWebViewUI.this);
            if (FTSSOSHomeWebViewUI.this.uAy) {
                FTSSOSHomeWebViewUI.this.uBk.sendMessage(1);
                String charSequence = ((TextView) view).getText().toString();
                final int a = C17977a.m28288a((JSONObject) view.getTag(), charSequence, FTSSOSHomeWebViewUI.this);
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
                    C7060h.pYm.mo8381e(15521, Integer.valueOf(FTSSOSHomeWebViewUI.this.scene), Integer.valueOf(4), FTSSOSHomeWebViewUI.this.dby().getInEditTextQuery(), Long.valueOf(System.currentTimeMillis()), Integer.valueOf(FTSSOSHomeWebViewUI.this.uAO));
                }
                if (!(FTSSOSHomeWebViewUI.this.uAO == a || FTSSOSHomeWebViewUI.this.dby().getTagList().isEmpty())) {
                    String totalQuery = FTSSOSHomeWebViewUI.this.getTotalQuery();
                    FTSSOSHomeWebViewUI.this.dby().clearText();
                    FTSSOSHomeWebViewUI.this.dby().mo36173n(totalQuery, null);
                    FTSSOSHomeWebViewUI.this.dby().bBs();
                }
                FTSSOSHomeWebViewUI.this.uAO = a;
                FTSSOSHomeWebViewUI.this.dbt();
                FTSSOSHomeWebViewUI.m87556d(FTSSOSHomeWebViewUI.this, a);
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
                    final Bundle p = FTSSOSHomeWebViewUI.this.icy.mo15588p(4, bundle);
                    FTSSOSHomeWebViewUI.this.handler.post(new Runnable() {
                        public final void run() {
                            AppMethodBeat.m2504i(8424);
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
                                if (!C5046bo.isNullOrNil(FTSSOSHomeWebViewUI.this.getTotalQuery())) {
                                    hashMap.put(SearchIntents.EXTRA_QUERY, FTSSOSHomeWebViewUI.this.getTotalQuery());
                                }
                                boolean a = FTSSOSHomeWebViewUI.this.getJsapi().mo71893a(p.getString("scene", AppEventsConstants.EVENT_PARAM_VALUE_NO), p.getString("type", AppEventsConstants.EVENT_PARAM_VALUE_NO), p.getString("isSug", AppEventsConstants.EVENT_PARAM_VALUE_NO), p.getString("isLocalSug", AppEventsConstants.EVENT_PARAM_VALUE_NO), FTSSOSHomeWebViewUI.this.getSessionId(), hashMap);
                                if (!TextUtils.isEmpty(FTSSOSHomeWebViewUI.this.getInEditTextQuery())) {
                                    C29744z.m47160a(FTSSOSHomeWebViewUI.this.scene, FTSSOSHomeWebViewUI.this.cvF, FTSSOSHomeWebViewUI.this.cIy, true, FTSSOSHomeWebViewUI.this.getInEditTextQuery(), FTSSOSHomeWebViewUI.this.uAO);
                                }
                                z = a;
                            }
                            if (z) {
                                FTSSOSHomeWebViewUI.this.dby().setHint(FTSSOSHomeWebViewUI.m87560f(FTSSOSHomeWebViewUI.this, a));
                                C14423an.m22653e(a, FTSSOSHomeWebViewUI.this.uAN, FTSSOSHomeWebViewUI.this.uBo, FTSSOSHomeWebViewUI.this.uBk.dbC());
                                FTSSOSHomeWebViewUI.this.uBk.sendMessage(7);
                            }
                            AppMethodBeat.m2505o(8424);
                        }
                    });
                    AppMethodBeat.m2505o(8423);
                    return;
                } catch (Exception e) {
                    AppMethodBeat.m2505o(8423);
                    return;
                }
            }
            AppMethodBeat.m2505o(8423);
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.fts.FTSSOSHomeWebViewUI$2 */
    class C46052 implements OnClickListener {
        C46052() {
        }

        public final void onClick(View view) {
            Bundle bundle;
            final HashMap hashMap;
            AppMethodBeat.m2504i(8427);
            C40869a c40869a = (C40869a) view.getTag();
            switch (c40869a.cKJ) {
                case 1:
                    if (FTSSOSHomeWebViewUI.this.uAy) {
                        FTSSOSHomeWebViewUI.this.uBA = null;
                        FTSSOSHomeWebViewUI.this.uBB = 0;
                        FTSSOSHomeWebViewUI.this.dby().clearText();
                        FTSSOSHomeWebViewUI.this.dby().mo36173n(c40869a.zye, null);
                        FTSSOSHomeWebViewUI.this.dby().bBs();
                        FTSSOSHomeWebViewUI.this.uBk.sendMessage(13);
                        try {
                            bundle = new Bundle();
                            bundle.putInt("type", 0);
                            bundle.putBoolean("isHomePage", true);
                            bundle.putInt("scene", 20);
                            bundle = FTSSOSHomeWebViewUI.this.icy.mo15588p(4, bundle);
                            hashMap = new HashMap();
                            hashMap.put("sceneActionType", "2");
                            hashMap.put("recommendId", FTSSOSHomeWebViewUI.this.uBd.getSearchId());
                            FTSSOSHomeWebViewUI.this.handler.post(new Runnable() {
                                public final void run() {
                                    boolean a;
                                    AppMethodBeat.m2504i(8426);
                                    if (FTSSOSHomeWebViewUI.this.getJsapi() != null) {
                                        a = FTSSOSHomeWebViewUI.this.getJsapi().mo71892a(bundle.getString("type", AppEventsConstants.EVENT_PARAM_VALUE_NO), bundle.getString("isMostSearchBiz", AppEventsConstants.EVENT_PARAM_VALUE_NO), bundle.getString("isSug", AppEventsConstants.EVENT_PARAM_VALUE_NO), bundle.getString("scene", AppEventsConstants.EVENT_PARAM_VALUE_NO), bundle.getString("isLocalSug", AppEventsConstants.EVENT_PARAM_VALUE_NO), FTSSOSHomeWebViewUI.this.getTotalQuery(), FTSSOSHomeWebViewUI.this.getInEditTextQuery(), FTSSOSHomeWebViewUI.this.dbB(), FTSSOSHomeWebViewUI.this.dbw(), FTSSOSHomeWebViewUI.this.uBB, hashMap);
                                    } else {
                                        a = false;
                                    }
                                    if (a) {
                                        FTSSOSHomeWebViewUI.this.dby().setHint(FTSSOSHomeWebViewUI.m87560f(FTSSOSHomeWebViewUI.this, 0));
                                        FTSSOSHomeWebViewUI.this.uBk.sendMessage(7);
                                    }
                                    AppMethodBeat.m2505o(8426);
                                }
                            });
                            break;
                        } catch (Exception e) {
                            break;
                        }
                    }
                    AppMethodBeat.m2505o(8427);
                    return;
                case 4:
                    Intent intent = new Intent();
                    intent.putExtra("rawUrl", c40869a.jumpUrl);
                    intent.putExtra("convertActivityFromTranslucent", false);
                    C25985d.m41467b(C4996ah.getContext(), "webview", ".ui.tools.WebViewUI", intent);
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
                if (c40869a.zye != null) {
                    encode = Uri.encode(c40869a.zye);
                } else {
                    encode = "";
                }
                hashMap.put(str, encode);
                hashMap.put("docpos", Integer.valueOf(c40869a.zyf + 1));
                hashMap.put("ishomepage", Integer.valueOf(1));
                hashMap.put("typepos", Integer.valueOf(1));
                hashMap.put("jumpurl", Uri.encode(c40869a.jumpUrl));
                String an = C46400aa.m87329an(hashMap);
                bundle = new Bundle();
                bundle.putString("logString", an);
                FTSSOSHomeWebViewUI.this.icy.mo15575g(131, bundle);
                AppMethodBeat.m2505o(8427);
            } catch (Exception e2) {
                C4990ab.m7421w("MicroMsg.FTS.FTSSOSHomeWebViewUI", "onHotwordCellClickListener cgi report fail for %s", e2.toString());
                AppMethodBeat.m2505o(8427);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.fts.FTSSOSHomeWebViewUI$8 */
    class C145968 implements OnClickListener {
        C145968() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(8436);
            FTSSOSHomeWebViewUI.m87520B(FTSSOSHomeWebViewUI.this);
            AppMethodBeat.m2505o(8436);
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.fts.FTSSOSHomeWebViewUI$9 */
    class C145979 implements OnPreDrawListener {
        C145979() {
        }

        public final boolean onPreDraw() {
            AppMethodBeat.m2504i(8437);
            FTSSOSHomeWebViewUI.this.uBe.getViewTreeObserver().removeOnPreDrawListener(this);
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(FTSSOSHomeWebViewUI.this.uBe, View.TRANSLATION_Y, new float[]{(float) (-FTSSOSHomeWebViewUI.this.uBe.getHeight()), 0.0f});
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(FTSSOSHomeWebViewUI.this.uBh, View.ALPHA, new float[]{0.0f, 1.0f});
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.setInterpolator(new AccelerateInterpolator());
            animatorSet.setDuration(300);
            animatorSet.playTogether(new Animator[]{ofFloat2, ofFloat});
            animatorSet.start();
            AppMethodBeat.m2505o(8437);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.fts.FTSSOSHomeWebViewUI$11 */
    class C2295511 implements C44246a {
        C2295511() {
        }

        /* renamed from: sD */
        public final void mo7486sD(int i) {
            AppMethodBeat.m2504i(8440);
            if (FTSSOSHomeWebViewUI.this.uBk == null) {
                AppMethodBeat.m2505o(8440);
                return;
            }
            if (i == -2) {
                FTSSOSHomeWebViewUI.this.uBk.sendMessage(12);
            }
            FTSSOSHomeWebViewUI.this.jYe = i;
            AppMethodBeat.m2505o(8440);
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.fts.FTSSOSHomeWebViewUI$12 */
    class C2295612 implements OnGlobalLayoutListener {
        C2295612() {
        }

        public final void onGlobalLayout() {
            AppMethodBeat.m2504i(8441);
            if (FTSSOSHomeWebViewUI.this.qpb.getHeight() <= 0) {
                AppMethodBeat.m2505o(8441);
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
            FTSSOSHomeWebViewUI.m87563h(FTSSOSHomeWebViewUI.this);
            AppMethodBeat.m2505o(8441);
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.fts.FTSSOSHomeWebViewUI$13 */
    class C2295713 implements OnTouchListener {
        C2295713() {
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            AppMethodBeat.m2504i(8442);
            FTSSOSHomeWebViewUI.this.dby().mLL.clearFocus();
            FTSSOSHomeWebViewUI.this.aqX();
            AppMethodBeat.m2505o(8442);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.fts.FTSSOSHomeWebViewUI$15 */
    class C2295815 implements OnPreDrawListener {
        C2295815() {
        }

        public final boolean onPreDraw() {
            AppMethodBeat.m2504i(8444);
            FTSSOSHomeWebViewUI.this.uAr.getViewTreeObserver().removeOnPreDrawListener(this);
            FTSSOSHomeWebViewUI.this.uBc = FTSSOSHomeWebViewUI.this.uAr.getX();
            AppMethodBeat.m2505o(8444);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.fts.FTSSOSHomeWebViewUI$14 */
    class C3566114 implements OnClickListener {
        C3566114() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(8443);
            FTSSOSHomeWebViewUI.m87565i(FTSSOSHomeWebViewUI.this);
            AppMethodBeat.m2505o(8443);
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.fts.FTSSOSHomeWebViewUI$3 */
    class C356623 implements C29904a {
        C356623() {
        }

        public final void onAnimationEnd() {
            AppMethodBeat.m2504i(8428);
            FTSSOSHomeWebViewUI.this.uBk.sendMessage(4);
            FTSSOSHomeWebViewUI.m87579v(FTSSOSHomeWebViewUI.this);
            AppMethodBeat.m2505o(8428);
        }

        public final void onAnimationStart() {
            AppMethodBeat.m2504i(8429);
            FTSSOSHomeWebViewUI.m87580w(FTSSOSHomeWebViewUI.this);
            AppMethodBeat.m2505o(8429);
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.fts.FTSSOSHomeWebViewUI$4 */
    class C356634 implements C29904a {
        C356634() {
        }

        public final void onAnimationEnd() {
            AppMethodBeat.m2504i(8430);
            FTSSOSHomeWebViewUI.this.uBk.sendMessage(9);
            FTSSOSHomeWebViewUI.m87579v(FTSSOSHomeWebViewUI.this);
            AppMethodBeat.m2505o(8430);
        }

        public final void onAnimationStart() {
            AppMethodBeat.m2504i(8431);
            FTSSOSHomeWebViewUI.m87580w(FTSSOSHomeWebViewUI.this);
            AppMethodBeat.m2505o(8431);
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.fts.FTSSOSHomeWebViewUI$5 */
    class C356645 implements C29904a {
        C356645() {
        }

        public final void onAnimationEnd() {
            AppMethodBeat.m2504i(8432);
            FTSSOSHomeWebViewUI.this.uBk.sendMessage(3);
            FTSSOSHomeWebViewUI.m87579v(FTSSOSHomeWebViewUI.this);
            AppMethodBeat.m2505o(8432);
        }

        public final void onAnimationStart() {
            AppMethodBeat.m2504i(8433);
            FTSSOSHomeWebViewUI.m87580w(FTSSOSHomeWebViewUI.this);
            AppMethodBeat.m2505o(8433);
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.fts.FTSSOSHomeWebViewUI$6 */
    class C356656 implements OnClickListener {
        C356656() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(8434);
            C35670c c35670c = (C35670c) view.getTag();
            if (c35670c.type == 1) {
                Bundle bundle = new Bundle();
                bundle.putString("history", c35670c.content);
                try {
                    FTSSOSHomeWebViewUI.this.icy.mo15582j(5, bundle);
                } catch (RemoteException e) {
                }
                C5004al.m7441d(new C356682(c35670c));
                AppMethodBeat.m2505o(8434);
                return;
            }
            if (c35670c.type == 2) {
                FTSSOSHomeWebViewUI.this.uAY.clear();
                FTSSOSHomeWebViewUI.this.dby().mo36173n(c35670c.content, null);
                FTSSOSHomeWebViewUI.m87549a(FTSSOSHomeWebViewUI.this, c35670c, 2);
                FTSSOSHomeWebViewUI.this.uBB = 2;
                FTSSOSHomeWebViewUI.m87519A(FTSSOSHomeWebViewUI.this);
            }
            AppMethodBeat.m2505o(8434);
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.fts.FTSSOSHomeWebViewUI$a */
    class C35666a extends BaseAdapter {
        private List<C35670c> uBK;

        /* renamed from: com.tencent.mm.plugin.webview.ui.tools.fts.FTSSOSHomeWebViewUI$a$a */
        class C14598a {
            TextView ene;
            ImageView iqT;
            ImageView uBO;

            private C14598a() {
            }

            /* synthetic */ C14598a(C35666a c35666a, byte b) {
                this();
            }
        }

        /* renamed from: com.tencent.mm.plugin.webview.ui.tools.fts.FTSSOSHomeWebViewUI$a$4 */
        class C299024 implements Runnable {
            C299024() {
            }

            public final void run() {
                AppMethodBeat.m2504i(8451);
                C35666a.this.uBK.clear();
                C35666a.this.notifyDataSetChanged();
                AppMethodBeat.m2505o(8451);
            }
        }

        /* renamed from: com.tencent.mm.plugin.webview.ui.tools.fts.FTSSOSHomeWebViewUI$a$1 */
        class C356671 implements Runnable {
            final /* synthetic */ List uBL;

            C356671(List list) {
                this.uBL = list;
            }

            public final void run() {
                AppMethodBeat.m2504i(8448);
                if (C35666a.this.uBK.size() > 0) {
                    for (C35670c c35670c : C35666a.this.uBK) {
                        if (!this.uBL.contains(c35670c)) {
                            this.uBL.add(c35670c);
                        }
                    }
                }
                C35666a.this.uBK = this.uBL;
                C35666a.this.notifyDataSetChanged();
                AppMethodBeat.m2505o(8448);
            }
        }

        /* renamed from: com.tencent.mm.plugin.webview.ui.tools.fts.FTSSOSHomeWebViewUI$a$2 */
        class C356682 implements Runnable {
            final /* synthetic */ C35670c uBN;

            C356682(C35670c c35670c) {
                this.uBN = c35670c;
            }

            public final void run() {
                AppMethodBeat.m2504i(8449);
                C35666a.this.uBK.remove(this.uBN);
                C35666a.this.notifyDataSetChanged();
                AppMethodBeat.m2505o(8449);
            }
        }

        /* renamed from: com.tencent.mm.plugin.webview.ui.tools.fts.FTSSOSHomeWebViewUI$a$3 */
        class C356693 implements Runnable {
            final /* synthetic */ List uBL;

            C356693(List list) {
                this.uBL = list;
            }

            public final void run() {
                AppMethodBeat.m2504i(8450);
                for (C35670c c35670c : this.uBL) {
                    if (!C35666a.this.uBK.contains(c35670c)) {
                        C35666a.this.uBK.add(c35670c);
                    }
                }
                C35666a.this.notifyDataSetChanged();
                AppMethodBeat.m2505o(8450);
            }
        }

        private C35666a() {
            AppMethodBeat.m2504i(8452);
            this.uBK = new ArrayList();
            AppMethodBeat.m2505o(8452);
        }

        /* synthetic */ C35666a(FTSSOSHomeWebViewUI fTSSOSHomeWebViewUI, byte b) {
            this();
        }

        public final /* synthetic */ Object getItem(int i) {
            AppMethodBeat.m2504i(8457);
            C35670c JF = mo56389JF(i);
            AppMethodBeat.m2505o(8457);
            return JF;
        }

        public final void clear() {
            AppMethodBeat.m2504i(8453);
            C5004al.m7441d(new C299024());
            AppMethodBeat.m2505o(8453);
        }

        public final int getCount() {
            AppMethodBeat.m2504i(8454);
            if (this.uBK.size() > 6) {
                AppMethodBeat.m2505o(8454);
                return 6;
            }
            int size = this.uBK.size();
            AppMethodBeat.m2505o(8454);
            return size;
        }

        /* renamed from: JF */
        public final C35670c mo56389JF(int i) {
            AppMethodBeat.m2504i(8455);
            C35670c c35670c = (C35670c) this.uBK.get(i);
            AppMethodBeat.m2505o(8455);
            return c35670c;
        }

        public final long getItemId(int i) {
            return 0;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            C14598a c14598a;
            AppMethodBeat.m2504i(8456);
            if (view == null) {
                C14598a c14598a2 = new C14598a(this, (byte) 0);
                view = LayoutInflater.from(FTSSOSHomeWebViewUI.this.mController.ylL).inflate(2130970839, null);
                c14598a2.iqT = (ImageView) view.findViewById(2131821226);
                c14598a2.ene = (TextView) view.findViewById(2131822953);
                c14598a2.uBO = (ImageView) view.findViewById(2131827968);
                view.setTag(c14598a2);
                c14598a = c14598a2;
            } else {
                c14598a = (C14598a) view.getTag();
            }
            C35670c JF = mo56389JF(i);
            JF.position = i;
            if (JF.icon != 0) {
                c14598a.iqT.setVisibility(0);
                c14598a.iqT.setImageResource(JF.icon);
            } else {
                c14598a.iqT.setVisibility(4);
            }
            if (JF.uBV != 0) {
                c14598a.uBO.setVisibility(0);
                c14598a.uBO.setImageResource(JF.uBV);
                c14598a.uBO.setTag(JF);
                c14598a.uBO.setOnClickListener(FTSSOSHomeWebViewUI.this.uBC);
            } else {
                c14598a.uBO.setVisibility(4);
            }
            c14598a.ene.setText(JF.content);
            AppMethodBeat.m2505o(8456);
            return view;
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.fts.FTSSOSHomeWebViewUI$c */
    class C35670c {
        String content;
        int icon;
        int position;
        int type;
        int uBV;

        private C35670c() {
        }

        /* synthetic */ C35670c(FTSSOSHomeWebViewUI fTSSOSHomeWebViewUI, byte b) {
            this();
        }

        public final boolean equals(Object obj) {
            AppMethodBeat.m2504i(8474);
            boolean equals = this.content.equals(((C35670c) obj).content);
            AppMethodBeat.m2505o(8474);
            return equals;
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.fts.FTSSOSHomeWebViewUI$7 */
    class C402937 implements OnItemClickListener {
        C402937() {
        }

        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            AppMethodBeat.m2504i(8435);
            C35670c JF = FTSSOSHomeWebViewUI.this.uAY.mo56389JF(i);
            FTSSOSHomeWebViewUI.this.dby().mo36173n(JF.content, null);
            if (JF.type == 2) {
                FTSSOSHomeWebViewUI.m87549a(FTSSOSHomeWebViewUI.this, JF, 1);
                FTSSOSHomeWebViewUI.this.uBB = 1;
            }
            FTSSOSHomeWebViewUI.this.aMo();
            AppMethodBeat.m2505o(8435);
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.fts.FTSSOSHomeWebViewUI$b */
    class C40296b extends C4887d {
        C7292c uBP = new C40294a(this, (byte) 0);
        C7292c uBQ = new C40297d(this, (byte) 0);
        C7292c uBR = new C40298b(this, (byte) 0);
        C7292c uBS = new C40295c(this, (byte) 0);

        /* renamed from: com.tencent.mm.plugin.webview.ui.tools.fts.FTSSOSHomeWebViewUI$b$a */
        class C40294a extends C15419b {

            /* renamed from: com.tencent.mm.plugin.webview.ui.tools.fts.FTSSOSHomeWebViewUI$b$a$1 */
            class C229591 implements Runnable {
                C229591() {
                }

                public final void run() {
                    AppMethodBeat.m2504i(8458);
                    C44786d jsapi = FTSSOSHomeWebViewUI.this.getJsapi();
                    if (jsapi.ready) {
                        C4990ab.m7416i("MicroMsg.JsApiHandler", "onFocusSearchInput success, ready");
                        C5004al.m7441d(new C2299538(C23124a.m35500b("onFocusSearchInput", null, jsapi.uFv, jsapi.uFw)));
                        AppMethodBeat.m2505o(8458);
                        return;
                    }
                    C4990ab.m7412e("MicroMsg.JsApiHandler", "onFocusSearchInput fail, not ready");
                    AppMethodBeat.m2505o(8458);
                }
            }

            private C40294a() {
            }

            /* synthetic */ C40294a(C40296b c40296b, byte b) {
                this();
            }

            public final void enter() {
                AppMethodBeat.m2504i(8459);
                super.enter();
                FTSSOSHomeWebViewUI.m87524F(FTSSOSHomeWebViewUI.this);
                AppMethodBeat.m2505o(8459);
            }

            public final void exit() {
                AppMethodBeat.m2504i(8460);
                super.exit();
                FTSSOSHomeWebViewUI.this.uBj.setBackgroundColor(FTSSOSHomeWebViewUI.this.getResources().getColor(C25738R.color.a3p));
                AppMethodBeat.m2505o(8460);
            }

            /* renamed from: k */
            public final boolean mo10090k(Message message) {
                AppMethodBeat.m2504i(8461);
                switch (message.what) {
                    case 0:
                    case 13:
                        if (FTSSOSHomeWebViewUI.this.getTotalQuery().length() > 0) {
                            FTSSOSHomeWebViewUI.this.dby().bBq();
                            FTSSOSHomeWebViewUI.this.dby().bBs();
                            FTSSOSHomeWebViewUI.this.dby().mLL.clearFocus();
                            FTSSOSHomeWebViewUI.m87556d(FTSSOSHomeWebViewUI.this, 0);
                            FTSSOSHomeWebViewUI.this.uAZ.mo48143b(C40305b.Search);
                            FTSSOSHomeWebViewUI.m87550a(FTSSOSHomeWebViewUI.this, C40305b.Search);
                            FTSSOSHomeWebViewUI.this.uAr.setBackgroundResource(C25738R.color.a69);
                            FTSSOSHomeWebViewUI.this.uAY.clear();
                            break;
                        }
                        break;
                    case 1:
                        FTSSOSHomeWebViewUI.this.dby().bBq();
                        FTSSOSHomeWebViewUI.this.dby().bBs();
                        FTSSOSHomeWebViewUI.this.uBa.mo48143b(C40305b.Search);
                        FTSSOSHomeWebViewUI.m87550a(FTSSOSHomeWebViewUI.this, C40305b.Search);
                        FTSSOSHomeWebViewUI.this.uAr.setBackgroundResource(C25738R.color.a69);
                        FTSSOSHomeWebViewUI.this.uAY.clear();
                        FTSSOSHomeWebViewUI.this.uBm = true;
                        break;
                    case 3:
                        FTSSOSHomeWebViewUI.this.uAx = true;
                        C40296b.this.mo10075b((C4886a) C40296b.this.uBQ);
                        break;
                    case 4:
                        FTSSOSHomeWebViewUI.this.uAx = true;
                        C40296b.this.mo10075b((C4886a) C40296b.this.uBR);
                        break;
                    case 5:
                        if (FTSSOSHomeWebViewUI.this.dby().getEditText().hasFocus() && FTSSOSHomeWebViewUI.this.getTotalQuery().length() > 0) {
                            FTSSOSHomeWebViewUI.m87519A(FTSSOSHomeWebViewUI.this);
                        }
                        if (FTSSOSHomeWebViewUI.this.dby().getEditText().hasFocus() && FTSSOSHomeWebViewUI.this.getTotalQuery().length() == 0) {
                            FTSSOSHomeWebViewUI.this.dby().bBs();
                            FTSSOSHomeWebViewUI.this.dby().bBq();
                            FTSSOSHomeWebViewUI.this.uAr.setBackgroundResource(C25738R.color.a69);
                            FTSSOSHomeWebViewUI.this.uAs.setSearchBarCancelTextContainerVisibile(8);
                            FTSSOSHomeWebViewUI.this.uAY.clear();
                            FTSSOSHomeWebViewUI.this.uBa.mo48143b(C40305b.Search);
                            FTSSOSHomeWebViewUI.m87550a(FTSSOSHomeWebViewUI.this, C40305b.Search);
                            FTSSOSHomeWebViewUI.this.mo9680ab(new C229591());
                            C7060h.pYm.mo8381e(15521, Integer.valueOf(FTSSOSHomeWebViewUI.this.scene), Integer.valueOf(3), FTSSOSHomeWebViewUI.this.dby().getInEditTextQuery(), Long.valueOf(System.currentTimeMillis()), Integer.valueOf(FTSSOSHomeWebViewUI.this.uAO));
                            break;
                        }
                    case 14:
                        FTSSOSHomeWebViewUI.this.dby().bBs();
                        FTSSOSHomeWebViewUI.this.dby().mLL.clearFocus();
                        FTSSOSHomeWebViewUI.m87556d(FTSSOSHomeWebViewUI.this, 0);
                        FTSSOSHomeWebViewUI.this.uAZ.mo48142a(C40305b.Search, false);
                        FTSSOSHomeWebViewUI.m87550a(FTSSOSHomeWebViewUI.this, C40305b.Search);
                        FTSSOSHomeWebViewUI.this.uAr.setBackgroundResource(C25738R.color.a69);
                        FTSSOSHomeWebViewUI.this.uAY.clear();
                        C40296b.this.mo10075b((C4886a) C40296b.this.uBR);
                        FTSSOSHomeWebViewUI.this.uAx = true;
                        break;
                    case 15:
                        if (FTSSOSHomeWebViewUI.this.mJe != null && FTSSOSHomeWebViewUI.this.mJe.getVisibility() == 0) {
                            FTSSOSHomeWebViewUI.this.mJe.mo36192H((MotionEvent) message.obj);
                            break;
                        }
                }
                boolean k = super.mo10090k(message);
                AppMethodBeat.m2505o(8461);
                return k;
            }

            public final String getName() {
                return "InitSate";
            }
        }

        /* renamed from: com.tencent.mm.plugin.webview.ui.tools.fts.FTSSOSHomeWebViewUI$b$c */
        class C40295c extends C15419b {
            private C40295c() {
            }

            /* synthetic */ C40295c(C40296b c40296b, byte b) {
                this();
            }

            public final void enter() {
                AppMethodBeat.m2504i(8465);
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
                AppMethodBeat.m2505o(8465);
            }

            public final void exit() {
                AppMethodBeat.m2504i(8466);
                super.exit();
                FTSSOSHomeWebViewUI.this.aqX();
                AppMethodBeat.m2505o(8466);
            }

            /* renamed from: k */
            public final boolean mo10090k(Message message) {
                AppMethodBeat.m2504i(8467);
                switch (message.what) {
                    case 0:
                        if (FTSSOSHomeWebViewUI.this.getTotalQuery().length() > 0) {
                            FTSSOSHomeWebViewUI.this.dby().bBs();
                            FTSSOSHomeWebViewUI.this.dby().mLL.clearFocus();
                            FTSSOSHomeWebViewUI.this.uAY.clear();
                            C40296b.this.mo10075b((C4886a) C40296b.this.uBR);
                            break;
                        }
                        break;
                    case 2:
                        if (!FTSSOSHomeWebViewUI.this.uBp) {
                            FTSSOSHomeWebViewUI.m87541S(FTSSOSHomeWebViewUI.this);
                            FTSSOSHomeWebViewUI.this.uBf.setVisibility(8);
                            FTSSOSHomeWebViewUI.m87556d(FTSSOSHomeWebViewUI.this, 0);
                            FTSSOSHomeWebViewUI.this.uBb.mo48143b(C40305b.Init);
                            FTSSOSHomeWebViewUI.m87550a(FTSSOSHomeWebViewUI.this, C40305b.Init);
                            break;
                        }
                        FTSSOSHomeWebViewUI.this.finish();
                        break;
                    case 5:
                        if (FTSSOSHomeWebViewUI.this.dby().getEditText().hasFocus()) {
                            C40296b.this.mo10075b((C4886a) C40296b.this.uBQ);
                            C7060h.pYm.mo8381e(15521, Integer.valueOf(FTSSOSHomeWebViewUI.this.scene), Integer.valueOf(2), FTSSOSHomeWebViewUI.this.dby().getInEditTextQuery(), Long.valueOf(System.currentTimeMillis()), Integer.valueOf(FTSSOSHomeWebViewUI.this.uAO));
                            break;
                        }
                        break;
                    case 9:
                        C40296b.this.mo10075b((C4886a) C40296b.this.uBP);
                        break;
                    case 10:
                        if (FTSSOSHomeWebViewUI.this.getTotalQuery().length() > 0) {
                            C40296b.this.mo10075b((C4886a) C40296b.this.uBR);
                            break;
                        }
                        break;
                }
                boolean k = super.mo10090k(message);
                AppMethodBeat.m2505o(8467);
                return k;
            }

            public final String getName() {
                return "SearchWithFocusNoResultState";
            }
        }

        /* renamed from: com.tencent.mm.plugin.webview.ui.tools.fts.FTSSOSHomeWebViewUI$b$d */
        class C40297d extends C15419b {
            private C40297d() {
            }

            /* synthetic */ C40297d(C40296b c40296b, byte b) {
                this();
            }

            public final void enter() {
                AppMethodBeat.m2504i(8468);
                super.enter();
                FTSSOSHomeWebViewUI.this.dby().bBq();
                FTSSOSHomeWebViewUI.this.uAV.setVisibility(0);
                FTSSOSHomeWebViewUI.this.uAr.setPadding(FTSSOSHomeWebViewUI.this.uBl, 0, 0, 0);
                FTSSOSHomeWebViewUI.this.uBf.setVisibility(8);
                FTSSOSHomeWebViewUI.this.uAs.setSearchBarCancelTextContainerVisibile(8);
                FTSSOSHomeWebViewUI.this.uAs.setVoiceImageButtonVisibile(8);
                FTSSOSHomeWebViewUI.m87565i(FTSSOSHomeWebViewUI.this);
                FTSSOSHomeWebViewUI.this.mJe.setVisibility(8);
                FTSSOSHomeWebViewUI.this.uBd.setVisibility(8);
                FTSSOSHomeWebViewUI.this.qzN.setVisibility(0);
                if (!FTSSOSHomeWebViewUI.this.dby().mLL.hasFocus()) {
                    FTSSOSHomeWebViewUI.this.dby().bBo();
                    FTSSOSHomeWebViewUI.this.showVKB();
                }
                if (C1443d.m3068iW(23) && !C4971b.m7364Mt()) {
                    FTSSOSHomeWebViewUI.m87566i(FTSSOSHomeWebViewUI.this, FTSSOSHomeWebViewUI.this.getResources().getColor(C25738R.color.a69));
                }
                if (!TextUtils.isEmpty(FTSSOSHomeWebViewUI.this.getInEditTextQuery())) {
                    FTSSOSHomeWebViewUI.this.dby().bBt();
                }
                FTSSOSHomeWebViewUI.m87564h(FTSSOSHomeWebViewUI.this, FTSSOSHomeWebViewUI.this.uAO);
                AppMethodBeat.m2505o(8468);
            }

            public final void exit() {
                AppMethodBeat.m2504i(8469);
                super.exit();
                FTSSOSHomeWebViewUI.this.aqX();
                AppMethodBeat.m2505o(8469);
            }

            /* renamed from: k */
            public final boolean mo10090k(Message message) {
                AppMethodBeat.m2504i(8470);
                switch (message.what) {
                    case 0:
                    case 11:
                        if (FTSSOSHomeWebViewUI.this.getTotalQuery().length() > 0) {
                            C40296b.this.mo10075b((C4886a) C40296b.this.uBR);
                            break;
                        }
                        break;
                    case 2:
                        if (!FTSSOSHomeWebViewUI.this.uBp) {
                            FTSSOSHomeWebViewUI.m87541S(FTSSOSHomeWebViewUI.this);
                            FTSSOSHomeWebViewUI.this.uBf.setVisibility(8);
                            FTSSOSHomeWebViewUI.m87556d(FTSSOSHomeWebViewUI.this, 0);
                            FTSSOSHomeWebViewUI.this.uBa.mo48143b(C40305b.Init);
                            FTSSOSHomeWebViewUI.m87550a(FTSSOSHomeWebViewUI.this, C40305b.Init);
                            break;
                        }
                        FTSSOSHomeWebViewUI.this.finish();
                        break;
                    case 3:
                    case 4:
                        C40296b.this.mo10075b((C4886a) C40296b.this.uBP);
                        break;
                    case 5:
                        if (!FTSSOSHomeWebViewUI.this.dby().getEditText().hasFocus()) {
                            C40296b.this.mo10075b((C4886a) C40296b.this.uBR);
                            break;
                        }
                        C7060h.pYm.mo8381e(15521, Integer.valueOf(FTSSOSHomeWebViewUI.this.scene), Integer.valueOf(2), FTSSOSHomeWebViewUI.this.dby().getInEditTextQuery(), Long.valueOf(System.currentTimeMillis()), Integer.valueOf(FTSSOSHomeWebViewUI.this.uAO));
                        break;
                }
                boolean k = super.mo10090k(message);
                AppMethodBeat.m2505o(8470);
                return k;
            }

            public final String getName() {
                return "SearchWithFocusState";
            }
        }

        /* renamed from: com.tencent.mm.plugin.webview.ui.tools.fts.FTSSOSHomeWebViewUI$b$b */
        class C40298b extends C15419b {
            private C40298b() {
            }

            /* synthetic */ C40298b(C40296b c40296b, byte b) {
                this();
            }

            public final void enter() {
                AppMethodBeat.m2504i(8462);
                super.enter();
                FTSSOSHomeWebViewUI.m87550a(FTSSOSHomeWebViewUI.this, C40305b.Search);
                FTSSOSHomeWebViewUI.this.uAr.setBackgroundResource(C25738R.color.a69);
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
                if (C1443d.m3068iW(23) && !C4971b.m7364Mt()) {
                    FTSSOSHomeWebViewUI.m87562g(FTSSOSHomeWebViewUI.this, FTSSOSHomeWebViewUI.this.getResources().getColor(C25738R.color.a69));
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
                            FTSSOSHomeWebViewUI.m87548a(FTSSOSHomeWebViewUI.this, FTSSOSHomeWebViewUI.this.nfs, "black".equals(FTSSOSHomeWebViewUI.this.nft));
                        }
                    }
                }
                FTSSOSHomeWebViewUI.m87564h(FTSSOSHomeWebViewUI.this, FTSSOSHomeWebViewUI.this.uAO);
                AppMethodBeat.m2505o(8462);
            }

            public final void exit() {
                AppMethodBeat.m2504i(8463);
                super.exit();
                AppMethodBeat.m2505o(8463);
            }

            /* renamed from: k */
            public final boolean mo10090k(Message message) {
                AppMethodBeat.m2504i(8464);
                switch (message.what) {
                    case 0:
                        FTSSOSHomeWebViewUI.this.dby().bBs();
                        break;
                    case 2:
                        if (!FTSSOSHomeWebViewUI.this.uBp) {
                            FTSSOSHomeWebViewUI.m87541S(FTSSOSHomeWebViewUI.this);
                            FTSSOSHomeWebViewUI.this.uBf.setVisibility(8);
                            FTSSOSHomeWebViewUI.m87556d(FTSSOSHomeWebViewUI.this, 0);
                            FTSSOSHomeWebViewUI.this.uAZ.mo48143b(C40305b.Init);
                            FTSSOSHomeWebViewUI.m87550a(FTSSOSHomeWebViewUI.this, C40305b.Init);
                            break;
                        }
                        FTSSOSHomeWebViewUI.this.finish();
                        break;
                    case 3:
                    case 4:
                        C40296b.this.mo10075b((C4886a) C40296b.this.uBP);
                        break;
                    case 5:
                        if (FTSSOSHomeWebViewUI.this.dby().getEditText().hasFocus()) {
                            C40296b.this.mo10075b((C4886a) C40296b.this.uBQ);
                            C7060h.pYm.mo8381e(15521, Integer.valueOf(FTSSOSHomeWebViewUI.this.scene), Integer.valueOf(2), FTSSOSHomeWebViewUI.this.dby().getInEditTextQuery(), Long.valueOf(System.currentTimeMillis()), Integer.valueOf(FTSSOSHomeWebViewUI.this.uAO));
                            break;
                        }
                        break;
                }
                boolean k = super.mo10090k(message);
                AppMethodBeat.m2505o(8464);
                return k;
            }

            public final String getName() {
                return "SearchNoFocusState";
            }
        }

        protected C40296b(String str, Looper looper) {
            super(str, looper);
            AppMethodBeat.m2504i(8471);
            mo10073a(this.uBP);
            mo10073a(this.uBQ);
            mo10073a(this.uBR);
            mo10073a(this.uBS);
            mo10076b(this.uBP);
            AppMethodBeat.m2505o(8471);
        }

        public final void dbM() {
            AppMethodBeat.m2504i(8472);
            FTSSOSHomeWebViewUI.this.uAs.setSearchBarCancelTextContainerVisibile(0);
            mo10076b(this.uBP);
            AppMethodBeat.m2505o(8472);
        }

        public final boolean dbC() {
            AppMethodBeat.m2504i(8473);
            C4886a dpQ = dpQ();
            if (dpQ == this.uBQ || dpQ == this.uBR || dpQ == this.uBS) {
                AppMethodBeat.m2505o(8473);
                return true;
            }
            AppMethodBeat.m2505o(8473);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.fts.FTSSOSHomeWebViewUI$10 */
    class C4395710 implements AnimatorListener {
        C4395710() {
        }

        public final void onAnimationStart(Animator animator) {
        }

        public final void onAnimationEnd(Animator animator) {
            AppMethodBeat.m2504i(8438);
            FTSSOSHomeWebViewUI.this.uBe.setVisibility(8);
            FTSSOSHomeWebViewUI.this.uBh.setVisibility(8);
            FTSSOSHomeWebViewUI.this.uBF = false;
            AppMethodBeat.m2505o(8438);
        }

        public final void onAnimationCancel(Animator animator) {
            AppMethodBeat.m2504i(8439);
            FTSSOSHomeWebViewUI.this.uBe.setVisibility(8);
            FTSSOSHomeWebViewUI.this.uBh.setVisibility(8);
            FTSSOSHomeWebViewUI.this.uBF = false;
            AppMethodBeat.m2505o(8439);
        }

        public final void onAnimationRepeat(Animator animator) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.fts.FTSSOSHomeWebViewUI$16 */
    class C4395816 implements OnClickListener {
        C4395816() {
        }

        public final void onClick(View view) {
            int i = 2;
            AppMethodBeat.m2504i(8445);
            C4990ab.m7417i("MicroMsg.FTS.FTSSOSHomeWebViewUI", "summerper checkPermission checkmicrophone[%s], stack[%s], activity[%s]", Boolean.valueOf(C35805b.m58707a(FTSSOSHomeWebViewUI.this, "android.permission.RECORD_AUDIO", 80, "", "")), C5046bo.dpG(), FTSSOSHomeWebViewUI.this);
            if (C35805b.m58707a(FTSSOSHomeWebViewUI.this, "android.permission.RECORD_AUDIO", 80, "", "")) {
                Intent intent = new Intent();
                intent.putExtra("sessionId", FTSSOSHomeWebViewUI.this.cvF);
                intent.putExtra("subSessionId", FTSSOSHomeWebViewUI.this.cIy);
                intent.putExtra("key_scene", FTSSOSHomeWebViewUI.this.scene);
                String str = "key_is_nav_voice";
                if (FTSSOSHomeWebViewUI.this.dbC()) {
                    i = 1;
                }
                intent.putExtra(str, i);
                C25985d.m41466b(FTSSOSHomeWebViewUI.this, ".ui.websearch.WebSearchVoiceUI", intent, 1);
                FTSSOSHomeWebViewUI.this.overridePendingTransition(0, 0);
                AppMethodBeat.m2505o(8445);
                return;
            }
            AppMethodBeat.m2505o(8445);
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.fts.FTSSOSHomeWebViewUI$17 */
    class C4395917 implements OnClickListener {
        C4395917() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(8446);
            FTSSOSHomeWebViewUI.this.dbu();
            AppMethodBeat.m2505o(8446);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public FTSSOSHomeWebViewUI() {
        AppMethodBeat.m2504i(8475);
        AppMethodBeat.m2505o(8475);
    }

    /* renamed from: A */
    static /* synthetic */ void m87519A(FTSSOSHomeWebViewUI fTSSOSHomeWebViewUI) {
        AppMethodBeat.m2504i(8514);
        fTSSOSHomeWebViewUI.dbK();
        AppMethodBeat.m2505o(8514);
    }

    /* renamed from: d */
    static /* synthetic */ void m87556d(FTSSOSHomeWebViewUI fTSSOSHomeWebViewUI, int i) {
        AppMethodBeat.m2504i(8509);
        fTSSOSHomeWebViewUI.m87529JB(i);
        AppMethodBeat.m2505o(8509);
    }

    /* renamed from: f */
    static /* synthetic */ String m87560f(FTSSOSHomeWebViewUI fTSSOSHomeWebViewUI, int i) {
        AppMethodBeat.m2504i(8510);
        String JC = fTSSOSHomeWebViewUI.m87530JC(i);
        AppMethodBeat.m2505o(8510);
        return JC;
    }

    /* renamed from: g */
    static /* synthetic */ void m87562g(FTSSOSHomeWebViewUI fTSSOSHomeWebViewUI, int i) {
        AppMethodBeat.m2504i(8518);
        fTSSOSHomeWebViewUI.mo30967at(i, true);
        AppMethodBeat.m2505o(8518);
    }

    /* renamed from: h */
    static /* synthetic */ void m87564h(FTSSOSHomeWebViewUI fTSSOSHomeWebViewUI, int i) {
        AppMethodBeat.m2504i(8520);
        fTSSOSHomeWebViewUI.m87531JD(i);
        AppMethodBeat.m2505o(8520);
    }

    /* renamed from: i */
    static /* synthetic */ void m87565i(FTSSOSHomeWebViewUI fTSSOSHomeWebViewUI) {
        AppMethodBeat.m2504i(8508);
        fTSSOSHomeWebViewUI.dbL();
        AppMethodBeat.m2505o(8508);
    }

    /* renamed from: i */
    static /* synthetic */ void m87566i(FTSSOSHomeWebViewUI fTSSOSHomeWebViewUI, int i) {
        AppMethodBeat.m2504i(8522);
        fTSSOSHomeWebViewUI.mo30967at(i, true);
        AppMethodBeat.m2505o(8522);
    }

    public void onCreate(Bundle bundle) {
        boolean z = false;
        AppMethodBeat.m2504i(8476);
        super.onCreate(bundle);
        if (getIntent() != null && getIntent().getBooleanExtra("ftsInitToSearch", false)) {
            z = true;
        }
        this.uBp = z;
        this.uBu = new WeappWebSearchFragment();
        Bundle bundle2 = new Bundle();
        bundle2.putString("url", getIntent().getStringExtra("key_weapp_url"));
        this.uBu.setArguments(bundle2);
        getSupportFragmentManager().beginTransaction().mo552a(2131827951, this.uBu).commit();
        AppMethodBeat.m2505o(8476);
    }

    public final void aMh() {
        Bundle bundle;
        AppMethodBeat.m2504i(8478);
        super.aMh();
        this.uBk = new C40296b("sos_home_webview_ui", getMainLooper());
        this.qpb = findViewById(2131827963);
        this.uBj = findViewById(2131827964);
        this.uBh = findViewById(2131827952);
        this.uBf = findViewById(2131827957);
        this.uBg = (TextView) findViewById(2131827958);
        this.uBf.setOnClickListener(this.uBE);
        this.uAW = findViewById(2131827951);
        this.uAX = findViewById(2131821064);
        this.titleView = (TextView) findViewById(2131821185);
        this.uAV = findViewById(2131823600);
        ((WebViewKeyboardLinearLayout) this.uAV).setOnkbdStateListener(new C2295511());
        this.mJe = (FTSMainUIEducationLayout) findViewById(2131824241);
        this.mJe.setOnCellClickListener(this.mJH);
        this.mJe.setCellClickable(false);
        this.mJe.getViewTreeObserver().addOnGlobalLayoutListener(new C2295612());
        this.uBe = (FTSMainUIEducationLayoutWithAll) findViewById(2131827953);
        this.uBe.setOnCellClickListener(this.mJH);
        this.uBe.setCellClickable(true);
        this.uBd = (FTSMainUIHotWordLayout) findViewById(2131827960);
        this.uBd.setOnCellClickListener(this.uBw);
        this.uAZ = new C29907b(this, this.uAr, this.titleView, dby().getIconView(), this.oOO, this.oOO, dby().getEditText(), this.uBi, this.qpb, this.uBj);
        this.uAZ.mo63665a(this.uBx);
        this.uBa = new C29911c(this, this.uAr, this.titleView, dby().getIconView(), this.oOO, this.oOO, dby().getEditText(), this.uBi, this.qpb, this.uBj);
        this.uBa.mo63665a(this.uBz);
        this.uBb = new C14602d(this, this.uAr, this.titleView, dby().getIconView(), this.oOO, this.oOO, dby().getEditText(), this.uBi, this.qpb, this.uBj);
        this.uBb.mo63665a(this.uBy);
        this.uAY = new C35666a(this, (byte) 0);
        this.qzN = findViewById(2131827962);
        try {
            bundle = new Bundle();
            bundle.putString("key", "educationTab");
            Bundle p = this.icy.mo15588p(2, bundle);
            String string = p.getString("result");
            String string2 = p.getString("result_1");
            if (string2 != null) {
                string = string2;
            }
            this.mJe.mo36193S(new JSONObject(string));
        } catch (Exception e) {
        }
        try {
            bundle = new Bundle();
            bundle.putString("key", "tabSlice");
            this.uBe.mo36193S(new JSONObject(this.icy.mo15588p(2, bundle).getString("result")));
        } catch (Exception e2) {
        }
        findViewById(2131821686).setOnTouchListener(new C2295713());
        this.uBh.setOnClickListener(new C3566114());
        this.titleView.setText(getIntent().getStringExtra("title"));
        this.uBl = ((RelativeLayout.LayoutParams) this.titleView.getLayoutParams()).leftMargin - ((int) getResources().getDimension(C25738R.dimen.a9t));
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
                this.uBj.setBackgroundColor(getResources().getColor(C25738R.color.a3p));
                C40296b c40296b = this.uBk;
                c40296b.mo10076b(c40296b.uBR);
                if (C1443d.m3068iW(23) && !C1448h.m3077Mt()) {
                    mo30967at(getResources().getColor(C25738R.color.a69), true);
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
            this.uBo = this.icy.mo15588p(6, bundle).getString("result");
            C14423an.m22648as(this.uBo, getSessionId(), this.mJe.getVertBizTypes());
        } catch (Exception e3) {
        }
        C14423an.m22638Ij(bFf());
        dbH();
        this.uAr.getViewTreeObserver().addOnPreDrawListener(new C2295815());
        if (this.uCf) {
            this.uAV.setVisibility(0);
        } else {
            this.uAV.setVisibility(4);
        }
        this.uAs.setVoiceBtnClickListener(new C4395816());
        this.uAs.setCancelTextViewClickListener(new C4395917());
        m87529JB(this.uAO);
        ImageButton clearBtn = dby().getClearBtn();
        if (clearBtn != null) {
            clearBtn.getDrawable().setColorFilter(WebView.NIGHT_MODE_COLOR, Mode.SRC_ATOP);
        }
        AppMethodBeat.m2505o(8478);
    }

    private boolean dbG() {
        return this.scene == 36;
    }

    private void dbH() {
        AppMethodBeat.m2504i(8479);
        if (this.pzf == null) {
            AppMethodBeat.m2505o(8479);
            return;
        }
        final AbsoluteLayout absoluteLayout = (AbsoluteLayout) this.pzf.getView();
        absoluteLayout.setOnTouchListener(new OnTouchListener() {
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.m2504i(8447);
                if (FTSSOSHomeWebViewUI.this.uBk != null) {
                    C40296b a = FTSSOSHomeWebViewUI.this.uBk;
                    C4890c c4890c = a.xCt;
                    if (c4890c != null) {
                        c4890c.sendMessage(Message.obtain(a.xCt, 15, motionEvent));
                    }
                }
                boolean onTouchEvent = absoluteLayout.onTouchEvent(motionEvent);
                AppMethodBeat.m2505o(8447);
                return onTouchEvent;
            }
        });
        AppMethodBeat.m2505o(8479);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(8480);
        super.onActivityResult(i, i2, intent);
        switch (i) {
            case 1:
                if (intent != null) {
                    String stringExtra = intent.getStringExtra("text");
                    if (!TextUtils.isEmpty(stringExtra)) {
                        C4990ab.m7417i("MicroMsg.FTS.FTSSOSHomeWebViewUI", "voice input final text len %d , text %s", Integer.valueOf(FTSSOSHomeWebViewUI.agb(stringExtra).length()), stringExtra);
                        this.uAs.mo36173n(stringExtra, null);
                        aMo();
                        AppMethodBeat.m2505o(8480);
                        return;
                    }
                }
                AppMethodBeat.m2505o(8480);
                return;
            default:
                AppMethodBeat.m2505o(8480);
                return;
        }
    }

    private static String agb(String str) {
        AppMethodBeat.m2504i(8481);
        if (str != null) {
            try {
                if (C5584f.asg(str) <= 100) {
                    AppMethodBeat.m2505o(8481);
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
                        i3 += C5584f.asg(String.valueOf(toCharArray[i]));
                        if (i3 >= 100) {
                            str = str.substring(0, i2) + 8230;
                            AppMethodBeat.m2505o(8481);
                            break;
                        }
                        i++;
                        i2++;
                    }
                }
            } catch (Exception e) {
                AppMethodBeat.m2505o(8481);
            }
            return str;
        }
        AppMethodBeat.m2505o(8481);
        return str;
    }

    public final int dbI() {
        return 1;
    }

    public void onResume() {
        AppMethodBeat.m2504i(8482);
        super.onResume();
        C14423an.cVv();
        AppMethodBeat.m2505o(8482);
    }

    public void onPause() {
        AppMethodBeat.m2504i(8483);
        super.onPause();
        C14423an.cVw();
        AppMethodBeat.m2505o(8483);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(8484);
        super.onDestroy();
        C14423an.cVx();
        C14423an.cVy();
        AppMethodBeat.m2505o(8484);
    }

    /* Access modifiers changed, original: protected|final */
    public final Map<String, Object> dbJ() {
        AppMethodBeat.m2504i(8485);
        HashMap hashMap = new HashMap();
        if (this.mJe == null || this.qpb == null) {
            AppMethodBeat.m2505o(8485);
            return hashMap;
        }
        int bottom;
        C4990ab.m7417i("MicroMsg.FTS.FTSSOSHomeWebViewUI", "getOnUiInitParams edu.bottom %d, title.bottom %d", Integer.valueOf(this.mJe.getBottom()), Integer.valueOf(this.qpb.getBottom()));
        if (this.mJe.getTop() < this.qpb.getBottom()) {
            bottom = this.mJe.getBottom() - this.qpb.getBottom();
        } else {
            bottom = this.mJe.getBottom();
        }
        hashMap.put("nativeHeight", Integer.valueOf(C1338a.m2859ao(this, bottom)));
        try {
            Bundle p = this.icy.mo15588p(7, null);
            CharSequence string = p == null ? "" : p.getString("data");
            if (!TextUtils.isEmpty(string)) {
                hashMap.put("operationData", string);
            }
        } catch (RemoteException e) {
            C4990ab.printErrStackTrace("MicroMsg.FTS.FTSSOSHomeWebViewUI", e, "", new Object[0]);
        }
        AppMethodBeat.m2505o(8485);
        return hashMap;
    }

    public final int aMi() {
        boolean z = false;
        AppMethodBeat.m2504i(8486);
        if (getIntent() != null && getIntent().getBooleanExtra("ftsInitToSearch", false)) {
            z = true;
        }
        this.uBp = z;
        int aMi;
        if (!C1443d.m3068iW(23) || C4971b.m7364Mt()) {
            aMi = super.aMi();
            AppMethodBeat.m2505o(8486);
            return aMi;
        } else if (this.uBp) {
            AppMethodBeat.m2505o(8486);
            return -1;
        } else {
            aMi = getResources().getColor(C25738R.color.a5q);
            AppMethodBeat.m2505o(8486);
            return aMi;
        }
    }

    /* renamed from: hz */
    public final void mo25276hz(boolean z) {
        AppMethodBeat.m2504i(8487);
        if (this.uBk == null) {
            AppMethodBeat.m2505o(8487);
            return;
        }
        if (this.uBk.dbC()) {
            super.mo25276hz(z);
        }
        this.uBk.sendMessage(5);
        AppMethodBeat.m2505o(8487);
    }

    /* Access modifiers changed, original: protected|final */
    public final void dbt() {
        AppMethodBeat.m2504i(8488);
        super.dbt();
        m87529JB(this.uAO);
        dby().setHint(m87530JC(this.uAO));
        AppMethodBeat.m2505o(8488);
    }

    private void dbK() {
        AppMethodBeat.m2504i(8489);
        try {
            this.uAY.clear();
            C4990ab.m7416i("MicroMsg.FTS.FTSSOSHomeWebViewUI", "start to update history");
            Bundle bundle = new Bundle();
            bundle.putInt("webview_id", hashCode());
            bundle.putString(SearchIntents.EXTRA_QUERY, getInEditTextQuery());
            bundle.putInt("count", 6);
            bundle.putInt("scene", bFf());
            this.icy.mo15582j(3, bundle);
            AppMethodBeat.m2505o(8489);
        } catch (RemoteException e) {
            AppMethodBeat.m2505o(8489);
        }
    }

    /* renamed from: a */
    public final void mo6403a(String str, String str2, List<C12071b> list, C20890b c20890b) {
        AppMethodBeat.m2504i(8490);
        if (c20890b == C20890b.UserInput) {
            this.uBB = 0;
        }
        if (this.uBk.dbC()) {
            super.mo6403a(str, str2, list, c20890b);
            AppMethodBeat.m2505o(8490);
        } else if (getTotalQuery().length() == 0) {
            this.mJe.setVisibility(0);
            this.uBd.setVisibility(0);
            this.uAV.setVisibility(0);
            this.uAY.clear();
            AppMethodBeat.m2505o(8490);
        } else {
            this.mJe.setVisibility(8);
            this.uBd.setVisibility(8);
            this.uAV.setVisibility(4);
            if (c20890b != C20890b.SetText) {
                dbK();
            }
            AppMethodBeat.m2505o(8490);
        }
    }

    /* renamed from: JB */
    private void m87529JB(int i) {
        AppMethodBeat.m2504i(8492);
        this.uBe.setSelected(i);
        this.uBg.setText(this.uBe.mo36206wg(i));
        dby().setIconRes(C17977a.m28290b(i, this.mController.ylL));
        AppMethodBeat.m2505o(8492);
    }

    /* Access modifiers changed, original: protected|final */
    public final void dbs() {
        AppMethodBeat.m2504i(8493);
        super.dbs();
        this.uBk.sendMessage(11);
        AppMethodBeat.m2505o(8493);
    }

    public final int dbx() {
        return this.uBB;
    }

    /* Access modifiers changed, original: protected|final */
    public final void dbu() {
        AppMethodBeat.m2504i(8494);
        if (this.uBn > 0) {
            AppMethodBeat.m2505o(8494);
            return;
        }
        super.dbu();
        dby().setHint(getHint());
        this.uBk.sendMessage(2);
        this.uAr.setBackgroundResource(C25738R.drawable.a1t);
        this.qzN.setVisibility(8);
        this.uBA = null;
        this.uBB = 0;
        this.uBv = false;
        this.uAX.setVisibility(0);
        this.uAW.setVisibility(8);
        C7060h.pYm.mo8381e(15521, Integer.valueOf(this.scene), Integer.valueOf(1), dby().getInEditTextQuery(), Long.valueOf(System.currentTimeMillis()), Integer.valueOf(this.uAO));
        AppMethodBeat.m2505o(8494);
    }

    /* Access modifiers changed, original: protected|final */
    public final void dbv() {
        AppMethodBeat.m2504i(8495);
        super.dbv();
        if (!this.uCf) {
            this.uAV.setVisibility(0);
            if (this.pzf.getTopView() != null && (this.pzf.getTopView() instanceof AbsoluteLayout)) {
                ((ViewGroup) this.mJe.getParent()).removeView(this.mJe);
                ((AbsoluteLayout) this.pzf.getTopView()).addView(this.mJe, new AbsoluteLayout.LayoutParams(-1, -2, 0, this.uBs - this.qpb.getHeight()));
            }
        }
        AppMethodBeat.m2505o(8495);
    }

    public final int getLayoutId() {
        return 2130970837;
    }

    /* Access modifiers changed, original: protected|final */
    public final String getHint() {
        AppMethodBeat.m2504i(8496);
        String JC = m87530JC(dbA());
        AppMethodBeat.m2505o(8496);
        return JC;
    }

    /* renamed from: j */
    public final void mo9685j(int i, Bundle bundle) {
        AppMethodBeat.m2504i(8497);
        if (this.uBv && this.uBu.mo63662x(i, bundle)) {
            AppMethodBeat.m2505o(8497);
            return;
        }
        super.mo9685j(i, bundle);
        switch (i) {
            case C31128d.MIC_AVROUND_BLUR /*119*/:
                this.uBk.sendMessage(8);
                AppMethodBeat.m2505o(8497);
                return;
            case 122:
                this.uBk.sendMessage(10);
                AppMethodBeat.m2505o(8497);
                return;
            case 126:
                ArrayList arrayList = new ArrayList();
                if (dby().mLL.hasFocus()) {
                    String string = bundle.getString(SearchIntents.EXTRA_QUERY);
                    if (getInEditTextQuery().equals(string)) {
                        int i2 = 0;
                        for (String str : bundle.getStringArrayList("result")) {
                            if (C17977a.m28289aO(str, string)) {
                                i2++;
                                if (i2 <= 2) {
                                    C35670c c35670c = new C35670c(this, (byte) 0);
                                    c35670c.type = 1;
                                    c35670c.icon = C1318a.sos_history;
                                    c35670c.content = str;
                                    c35670c.uBV = C25738R.drawable.a1s;
                                    arrayList.add(c35670c);
                                }
                            }
                        }
                    }
                }
                C5004al.m7441d(new C356671(arrayList));
                AppMethodBeat.m2505o(8497);
                return;
            case C31128d.MIC_SketchMark /*127*/:
                ArrayList arrayList2 = new ArrayList();
                if (dby().mLL.hasFocus()) {
                    if (getInEditTextQuery().equals(bundle.getString(SearchIntents.EXTRA_QUERY))) {
                        this.uBA = bundle.getString("suggestionId");
                        for (String str2 : bundle.getStringArrayList("result")) {
                            C35670c c35670c2 = new C35670c(this, (byte) 0);
                            c35670c2.type = 2;
                            c35670c2.icon = 0;
                            c35670c2.content = str2;
                            c35670c2.uBV = C25738R.drawable.a1u;
                            arrayList2.add(c35670c2);
                        }
                    }
                }
                C5004al.m7441d(new C356693(arrayList2));
                AppMethodBeat.m2505o(8497);
                return;
            case 130:
                AppMethodBeat.m2505o(8497);
                return;
            case C19395n.CTRL_INDEX /*136*/:
                bundle.getString("fts_key_new_query", "");
                this.uBk.sendMessage(13);
                break;
        }
        AppMethodBeat.m2505o(8497);
    }

    /* renamed from: JC */
    private String m87530JC(int i) {
        AppMethodBeat.m2504i(8498);
        m87531JD(i);
        int i2 = -1;
        switch (i) {
            case 1:
                i2 = C25738R.string.e0c;
                break;
            case 2:
                i2 = C25738R.string.e0b;
                break;
            case 8:
                i2 = C25738R.string.c1y;
                break;
            case 16:
                i2 = C25738R.string.c1w;
                break;
            case 64:
                i2 = C25738R.string.f8887i9;
                break;
            case 128:
                i2 = C25738R.string.c1m;
                break;
            case 256:
            case 384:
                i2 = C25738R.string.c1l;
                break;
            case 512:
                i2 = C25738R.string.c1u;
                break;
            case WXMediaMessage.DESCRIPTION_LENGTH_LIMIT /*1024*/:
                i2 = C25738R.string.c1v;
                break;
        }
        if (dbG() || this.scene == 53) {
            i2 = C25738R.string.e0w;
        }
        String string;
        if (i2 < 0) {
            string = getString(C25738R.string.e0a, new Object[]{this.uBt});
            AppMethodBeat.m2505o(8498);
            return string;
        }
        string = getString(C25738R.string.e0a, new Object[]{getString(i2)});
        AppMethodBeat.m2505o(8498);
        return string;
    }

    /* renamed from: JD */
    private void m87531JD(int i) {
        AppMethodBeat.m2504i(8499);
        if (this.uBk == null || !this.uBk.dbC()) {
            dby().setEditTextDrawableLeft(-1);
            AppMethodBeat.m2505o(8499);
            return;
        }
        dby().setEditTextDrawableLeft(FTSSOSHomeWebViewUI.m87532JE(i));
        AppMethodBeat.m2505o(8499);
    }

    /* renamed from: JE */
    private static int m87532JE(int i) {
        switch (i) {
            case 1:
                return C1318a.websearch_icon_acount;
            case 2:
                return C1318a.websearch_icon_article;
            case 8:
                return C1318a.websearch_icon_moment;
            case 64:
            case 2359360:
                return C1318a.websearch_icon_weapp;
            case 256:
            case 384:
                return C1318a.websearch_icon_emoji;
            case 512:
                return C1318a.websearch_icon_music;
            case WXMediaMessage.DESCRIPTION_LENGTH_LIMIT /*1024*/:
                return C1318a.websearch_icon_novel;
            case 12582912:
                return C1318a.websearch_icon_movie;
            case 16777220:
                return C1318a.websearch_icon_webpage;
            case 16777248:
                return C1318a.websearch_icon_question;
            case 16777728:
                return C1318a.websearch_icon_baike;
            case 16793600:
                return C1318a.websearch_icon_product;
            default:
                return C1318a.websearch_icon_search;
        }
    }

    private void dbL() {
        AppMethodBeat.m2504i(8500);
        if (this.uBe.getVisibility() == 0 && !this.uBF) {
            this.uBF = true;
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.uBe, View.TRANSLATION_Y, new float[]{0.0f, (float) (-this.uBe.getHeight())});
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.uBh, View.ALPHA, new float[]{1.0f, 0.0f});
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.setDuration(300);
            animatorSet.setInterpolator(new AccelerateInterpolator());
            animatorSet.playTogether(new Animator[]{ofFloat2, ofFloat});
            animatorSet.addListener(new C4395710());
            animatorSet.start();
        }
        AppMethodBeat.m2505o(8500);
    }

    public void onBackPressed() {
        AppMethodBeat.m2504i(8501);
        if (this.uBe.getVisibility() == 0) {
            dbL();
        } else {
            super.onBackPressed();
        }
        dby().bBs();
        AppMethodBeat.m2505o(8501);
    }

    public final boolean dbC() {
        AppMethodBeat.m2504i(8502);
        if (this.uBk == null) {
            AppMethodBeat.m2505o(8502);
            return false;
        }
        boolean dbC = this.uBk.dbC();
        AppMethodBeat.m2505o(8502);
        return dbC;
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean dbD() {
        AppMethodBeat.m2504i(8503);
        if (!dbC() || this.uAZ.isAnimating || this.uBa.isAnimating || this.uBb.isAnimating) {
            AppMethodBeat.m2505o(8503);
            return false;
        }
        AppMethodBeat.m2505o(8503);
        return true;
    }

    /* Access modifiers changed, original: protected|final */
    public final C44786d getJsapi() {
        AppMethodBeat.m2504i(8504);
        C44786d jsapi;
        if (this.uBv) {
            jsapi = this.uBu.getJsapi();
            AppMethodBeat.m2505o(8504);
            return jsapi;
        }
        jsapi = super.getJsapi();
        AppMethodBeat.m2505o(8504);
        return jsapi;
    }

    public final boolean cZA() {
        return true;
    }

    public final void onWebViewScrollChanged(int i, int i2, int i3, int i4) {
        AppMethodBeat.m2504i(8505);
        super.onWebViewScrollChanged(i, i2, i3, i4);
        int min = Math.min(i2, Math.max(C1338a.fromDPToPix(this, this.pzf.getContentHeight()) - this.pzf.getHeight(), 0));
        this.uAZ.mo63664JG(this.uBr - min);
        this.uBa.mo63664JG(this.uBr - min);
        this.uBb.mo63664JG(this.uBr - min);
        if (!this.uBk.dbC()) {
            this.uAr.setTranslationY((float) (-min));
        }
        if (i2 != 0) {
            dby().mLL.clearFocus();
            aqX();
        }
        AppMethodBeat.m2505o(8505);
    }

    /* renamed from: Jw */
    public final void mo30945Jw(int i) {
        AppMethodBeat.m2504i(8506);
        if (this.pzf == null || this.pzf.getSettings() == null) {
            AppMethodBeat.m2505o(8506);
            return;
        }
        float f = this.mController.ylL.getSharedPreferences(C4996ah.doA(), 0).getFloat("current_text_size_scale_key", 1.0f);
        if (f >= 2.025f) {
            this.pzf.getSettings().setTextZoom(160);
            AppMethodBeat.m2505o(8506);
        } else if (f >= 1.875f) {
            this.pzf.getSettings().setTextZoom(150);
            AppMethodBeat.m2505o(8506);
        } else if (f >= 1.625f) {
            this.pzf.getSettings().setTextZoom(140);
            AppMethodBeat.m2505o(8506);
        } else if (f >= 1.375f) {
            this.pzf.getSettings().setTextZoom(130);
            AppMethodBeat.m2505o(8506);
        } else if (f >= 1.25f) {
            this.pzf.getSettings().setTextZoom(120);
            AppMethodBeat.m2505o(8506);
        } else if (f >= 1.125f) {
            this.pzf.getSettings().setTextZoom(110);
            AppMethodBeat.m2505o(8506);
        } else if (f >= 1.0f) {
            this.pzf.getSettings().setTextZoom(100);
            AppMethodBeat.m2505o(8506);
        } else if (f >= 0.875f) {
            this.pzf.getSettings().setTextZoom(90);
            AppMethodBeat.m2505o(8506);
        } else {
            this.pzf.getSettings().setTextZoom(80);
            AppMethodBeat.m2505o(8506);
        }
    }

    public final boolean aMo() {
        AppMethodBeat.m2504i(8491);
        if (this.uAy) {
            this.uBk.sendMessage(0);
            super.aMo();
            AppMethodBeat.m2505o(8491);
        } else {
            AppMethodBeat.m2505o(8491);
        }
        return true;
    }

    public final String dbw() {
        if (this.uBB == 0) {
            return "";
        }
        return this.uBA;
    }

    /* renamed from: h */
    static /* synthetic */ void m87563h(FTSSOSHomeWebViewUI fTSSOSHomeWebViewUI) {
        AppMethodBeat.m2504i(8507);
        if (!fTSSOSHomeWebViewUI.uCf) {
            StringBuilder stringBuilder = new StringBuilder(fTSSOSHomeWebViewUI.cOG);
            C4990ab.m7419v("MicroMsg.FTS.FTSSOSHomeWebViewUI", "beginLoadingUrl edu.bottom %d, title.bottom %d", Integer.valueOf(fTSSOSHomeWebViewUI.mJe.getBottom()), Integer.valueOf(fTSSOSHomeWebViewUI.qpb.getBottom()));
            stringBuilder.append("&nativeHeight=").append(C1338a.m2859ao(fTSSOSHomeWebViewUI, fTSSOSHomeWebViewUI.mJe.getBottom() - fTSSOSHomeWebViewUI.qpb.getBottom()));
            fTSSOSHomeWebViewUI.cOG = stringBuilder.toString();
            fTSSOSHomeWebViewUI.getIntent().putExtra("rawUrl", fTSSOSHomeWebViewUI.cOG);
            fTSSOSHomeWebViewUI.uvm = fTSSOSHomeWebViewUI.cOG;
            fTSSOSHomeWebViewUI.pzf.loadUrl(fTSSOSHomeWebViewUI.cOG);
        }
        AppMethodBeat.m2505o(8507);
    }

    /* renamed from: v */
    static /* synthetic */ void m87579v(FTSSOSHomeWebViewUI fTSSOSHomeWebViewUI) {
        AppMethodBeat.m2504i(8511);
        fTSSOSHomeWebViewUI.uBn--;
        fTSSOSHomeWebViewUI.uAV.setVisibility(0);
        AppMethodBeat.m2505o(8511);
    }

    /* renamed from: w */
    static /* synthetic */ void m87580w(FTSSOSHomeWebViewUI fTSSOSHomeWebViewUI) {
        AppMethodBeat.m2504i(8512);
        fTSSOSHomeWebViewUI.uBn++;
        fTSSOSHomeWebViewUI.uAV.setVisibility(4);
        AppMethodBeat.m2505o(8512);
    }

    /* renamed from: B */
    static /* synthetic */ void m87520B(FTSSOSHomeWebViewUI fTSSOSHomeWebViewUI) {
        AppMethodBeat.m2504i(8515);
        if (fTSSOSHomeWebViewUI.uBe.getVisibility() == 0) {
            fTSSOSHomeWebViewUI.dbL();
            AppMethodBeat.m2505o(8515);
            return;
        }
        if (fTSSOSHomeWebViewUI.uBe.getVisibility() != 0) {
            fTSSOSHomeWebViewUI.uBe.setVisibility(0);
            fTSSOSHomeWebViewUI.uBh.setVisibility(0);
            fTSSOSHomeWebViewUI.uBe.getViewTreeObserver().addOnPreDrawListener(new C145979());
        }
        AppMethodBeat.m2505o(8515);
    }

    /* renamed from: F */
    static /* synthetic */ void m87524F(FTSSOSHomeWebViewUI fTSSOSHomeWebViewUI) {
        AppMethodBeat.m2504i(8516);
        C4990ab.m7417i("MicroMsg.FTS.FTSSOSHomeWebViewUI", "setInitStatus originInputX %f, x %f ", Float.valueOf(fTSSOSHomeWebViewUI.uBc), Float.valueOf(fTSSOSHomeWebViewUI.uAr.getX()));
        if (fTSSOSHomeWebViewUI.uBc != Float.MAX_VALUE) {
            fTSSOSHomeWebViewUI.uAr.setX(fTSSOSHomeWebViewUI.uBc);
        }
        fTSSOSHomeWebViewUI.uBj.setBackgroundColor(fTSSOSHomeWebViewUI.getResources().getColor(C25738R.color.a5q));
        fTSSOSHomeWebViewUI.titleView.setVisibility(0);
        fTSSOSHomeWebViewUI.mJe.setVisibility(0);
        fTSSOSHomeWebViewUI.uBd.setVisibility(0);
        View view = fTSSOSHomeWebViewUI.uAV;
        int i = (fTSSOSHomeWebViewUI.uAy || fTSSOSHomeWebViewUI.uCf) ? 0 : 4;
        view.setVisibility(i);
        fTSSOSHomeWebViewUI.qzN.setVisibility(8);
        if (C1443d.m3068iW(23) && !C4971b.m7364Mt()) {
            fTSSOSHomeWebViewUI.mo30967at(fTSSOSHomeWebViewUI.getResources().getColor(C25738R.color.a5q), true);
        }
        fTSSOSHomeWebViewUI.dby().bBs();
        fTSSOSHomeWebViewUI.uBf.setVisibility(8);
        fTSSOSHomeWebViewUI.uBe.setVisibility(8);
        fTSSOSHomeWebViewUI.oOO.setVisibility(0);
        fTSSOSHomeWebViewUI.dby().bBr();
        fTSSOSHomeWebViewUI.uAs.bBr();
        fTSSOSHomeWebViewUI.uAr.setPadding(0, 0, 0, 0);
        fTSSOSHomeWebViewUI.m87529JB(0);
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
        AppMethodBeat.m2505o(8516);
    }

    /* renamed from: S */
    static /* synthetic */ void m87541S(FTSSOSHomeWebViewUI fTSSOSHomeWebViewUI) {
        AppMethodBeat.m2504i(8521);
        fTSSOSHomeWebViewUI.uBe.setVisibility(8);
        fTSSOSHomeWebViewUI.uBh.setVisibility(8);
        AppMethodBeat.m2505o(8521);
    }
}
