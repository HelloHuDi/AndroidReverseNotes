package com.tencent.mm.plugin.fts.ui;

import android.app.ActivityOptions;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.util.Pair;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.gms.actions.SearchIntents;
import com.google.android.gms.common.Scopes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.ll;
import com.tencent.mm.g.a.tv;
import com.tencent.mm.g.a.vl;
import com.tencent.mm.g.b.a.cv;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelgeo.b;
import com.tencent.mm.plugin.fts.a.f;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.fts.ui.widget.FTSLocalPageRelevantView;
import com.tencent.mm.plugin.fts.ui.widget.FTSMainUIEducationLayout;
import com.tencent.mm.plugin.fts.ui.widget.FTSVoiceInputLayoutImpl;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.websearch.api.WidgetData;
import com.tencent.mm.plugin.websearch.api.aa;
import com.tencent.mm.plugin.websearch.api.ac;
import com.tencent.mm.plugin.websearch.api.an;
import com.tencent.mm.plugin.websearch.api.d;
import com.tencent.mm.plugin.websearch.api.e;
import com.tencent.mm.plugin.websearch.api.i;
import com.tencent.mm.plugin.websearch.api.j;
import com.tencent.mm.plugin.websearch.api.m;
import com.tencent.mm.plugin.websearch.api.o;
import com.tencent.mm.plugin.websearch.api.p;
import com.tencent.mm.protocal.protobuf.brd;
import com.tencent.mm.protocal.protobuf.btf;
import com.tencent.mm.protocal.protobuf.but;
import com.tencent.mm.protocal.protobuf.buv;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.KeyboardLinearLayout;
import com.tencent.mm.ui.base.a;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.DownloadResult;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

@a(3)
public class FTSMainUI extends FTSBaseVoiceSearchUI implements b.a {
    private int ieu;
    private int iev;
    long ijU;
    private Dialog lud;
    private int mFa;
    int mIa = -1;
    private Map<String, Integer> mJA = new HashMap();
    private KeyboardLinearLayout mJB;
    private j mJC;
    private j.b mJD = new j.b() {
        public final void bAY() {
            AppMethodBeat.i(61892);
            String query = FTSMainUI.this.mJm.getQuery();
            if (!(FTSMainUI.this.mJm.getVisibility() != 0 || bo.isNullOrNil(query) || FTSMainUI.this.mJA.containsKey(query))) {
                FTSMainUI.this.mJA.put(query, Integer.valueOf(1));
                ((e) g.K(e.class)).ar(query, FTSMainUI.this.mJm.getSearchId(), FTSMainUI.this.mJm.getWordList());
            }
            FTSMainUI.this.mJC.mIS.mLH = 1;
            AppMethodBeat.o(61892);
        }

        public final void bAZ() {
            AppMethodBeat.i(61893);
            if (FTSMainUI.this.mJt.getVisibility() == 0) {
                FTSMainUI.this.mJs.onResume();
            }
            AppMethodBeat.o(61893);
        }

        public final void bBa() {
            AppMethodBeat.i(61894);
            if (FTSMainUI.this.mJt.getVisibility() == 0) {
                FTSMainUI.this.mJs.onPause();
            }
            AppMethodBeat.o(61894);
        }
    };
    private o mJE = new o() {
        public final void m(String str, List<WidgetData> list) {
            AppMethodBeat.i(61873);
            if (FTSMainUI.this.mJw) {
                FTSMainUI.this.mJk.setVisibility(0);
            }
            if (!FTSMainUI.this.query.equals(str)) {
                AppMethodBeat.o(61873);
            } else if (list == null || list.isEmpty()) {
                AppMethodBeat.o(61873);
            } else {
                if (FTSMainUI.this.mJw && FTSMainUI.this.mJs != null) {
                    FTSMainUI.this.mJs.c(list, com.tencent.mm.plugin.fts.a.e.mCM, FTSMainUI.this.query);
                    FTSMainUI.this.mJs.show();
                    FTSMainUI.this.mJt.setVisibility(0);
                }
                FTSMainUI.r(FTSMainUI.this);
                AppMethodBeat.o(61873);
            }
        }
    };
    private d mJF = new d() {
        public final void a(boolean z, brd brd, String str, String str2) {
            AppMethodBeat.i(61874);
            if (FTSMainUI.this.query.equals(str2)) {
                if (!z) {
                    FTSMainUI.this.mJm.setVisibility(8);
                } else if (FTSMainUI.this.mJk.getVisibility() == 0) {
                    int i;
                    FTSLocalPageRelevantView f = FTSMainUI.this.mJm;
                    if (brd == null || brd.vHk == null) {
                        ab.w("MicroMsg.FTS.FTSLocalPageRelevantView", "configRelevantDatas param nil!");
                        i = 0;
                    } else {
                        List ca = FTSLocalPageRelevantView.ca(brd.vHk);
                        if (ca.size() <= 0) {
                            ab.w("MicroMsg.FTS.FTSLocalPageRelevantView", "configRelevantDatas size 0 items!");
                            i = 0;
                        } else {
                            f.query = str2;
                            f.hlm = str;
                            f.mMc = brd.vHk;
                            if (f.jbJ == null) {
                                f.jbJ = new LinearLayout(f.getContext());
                                f.jbJ.setOrientation(1);
                                LayoutParams layoutParams = (LayoutParams) f.getLayoutParams();
                                layoutParams.width = -1;
                                layoutParams.height = -2;
                                f.addView(f.jbJ, layoutParams);
                            }
                            f.b(ca, f.jbJ);
                            f.requestLayout();
                            i = 1;
                        }
                    }
                    if (i != 0) {
                        FTSMainUI.this.mJm.setVisibility(0);
                        AppMethodBeat.o(61874);
                        return;
                    }
                }
                AppMethodBeat.o(61874);
                return;
            }
            ab.i("MicroMsg.FTS.FTSMainUI", "IRelevantSearchCallback callback with query %s, current query is %s ", str2, FTSMainUI.this.query);
            AppMethodBeat.o(61874);
        }
    };
    private com.tencent.mm.plugin.websearch.api.g mJG = new com.tencent.mm.plugin.websearch.api.g() {
        public final void onClick() {
            AppMethodBeat.i(61875);
            k.a(FTSMainUI.this.query, FTSMainUI.this.mJC.getCount(), FTSMainUI.this.mFa, FTSMainUI.k(FTSMainUI.this), 24);
            AppMethodBeat.o(61875);
        }

        public final void bBg() {
            AppMethodBeat.i(61876);
            FTSMainUI.this.mJC.mIS.mLG = 1;
            AppMethodBeat.o(61876);
        }

        public final boolean u(int[] iArr) {
            AppMethodBeat.i(61877);
            int s = FTSMainUI.this.ieu;
            int t = FTSMainUI.this.iev;
            if (FTSMainUI.this.mController.ymc == -3) {
                t -= x.gp(FTSMainUI.this);
            }
            if (iArr[0] < 0 || iArr[0] >= s || iArr[1] < 0 || iArr[1] >= t) {
                AppMethodBeat.o(61877);
                return false;
            }
            AppMethodBeat.o(61877);
            return true;
        }
    };
    private OnClickListener mJH = new OnClickListener() {
        /* JADX WARNING: Removed duplicated region for block: B:10:0x0039  */
        /* JADX WARNING: Removed duplicated region for block: B:6:0x001c  */
        /* JADX WARNING: Removed duplicated region for block: B:10:0x0039  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onClick(View view) {
            int optInt;
            int i;
            AppMethodBeat.i(61882);
            try {
                if (view.getTag() != null) {
                    optInt = ((JSONObject) view.getTag()).optInt("businessType");
                    if (optInt == 0) {
                        String charSequence = ((TextView) view).getText().toString();
                        if (charSequence.equals(FTSMainUI.this.getString(R.string.e0b))) {
                            i = 2;
                        } else if (charSequence.equals(FTSMainUI.this.getString(R.string.e0f))) {
                            i = 8;
                        } else if (charSequence.equals(FTSMainUI.this.getString(R.string.e0c))) {
                            i = 1;
                        }
                        if (i != 0) {
                            FTSMainUI fTSMainUI = FTSMainUI.this;
                            ((m) g.K(m.class)).a(fTSMainUI, new AnonymousClass11(i));
                        }
                        AppMethodBeat.o(61882);
                    }
                    i = optInt;
                    if (i != 0) {
                    }
                    AppMethodBeat.o(61882);
                }
            } catch (Exception e) {
            }
            optInt = 0;
            if (optInt == 0) {
            }
            i = optInt;
            if (i != 0) {
            }
            AppMethodBeat.o(61882);
        }
    };
    private c<vl> mJI = new c<vl>() {
        {
            AppMethodBeat.i(61883);
            this.xxI = vl.class.getName().hashCode();
            AppMethodBeat.o(61883);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(61884);
            FTSMainUI.this.mJe.cu();
            AppMethodBeat.o(61884);
            return false;
        }
    };
    private FTSMainUIEducationLayout mJe;
    private LinearLayout mJf;
    private LinearLayout mJg;
    private com.tencent.mm.plugin.fts.ui.widget.c mJh;
    private boolean mJi = false;
    private LinearLayout mJj;
    private View mJk;
    private View mJl;
    private FTSLocalPageRelevantView mJm;
    private TextView mJn;
    private TextView mJo;
    private View mJp;
    private View mJq;
    private TextView mJr;
    private i mJs;
    private View mJt;
    private boolean mJu;
    private long mJv;
    private boolean mJw;
    private Runnable mJx = new Runnable() {
        public final void run() {
            AppMethodBeat.i(61866);
            ab.i("MicroMsg.FTS.FTSMainUI", "showSearchNetworkLayoutRunnable canShow %b", Boolean.valueOf(FTSMainUI.this.mJw));
            if (FTSMainUI.this.mJw) {
                FTSMainUI.this.mJk.setVisibility(0);
            }
            AppMethodBeat.o(61866);
        }
    };
    private String mJy;
    private volatile boolean mJz;

    /* renamed from: com.tencent.mm.plugin.fts.ui.FTSMainUI$11 */
    class AnonymousClass11 implements Runnable {
        final /* synthetic */ int bVv;

        AnonymousClass11(int i) {
            this.bVv = i;
        }

        public final void run() {
            AppMethodBeat.i(61878);
            if (System.currentTimeMillis() - FTSMainUI.this.ijU <= 1000) {
                AppMethodBeat.o(61878);
                return;
            }
            FTSMainUI.this.ijU = System.currentTimeMillis();
            if (aa.HU(0)) {
                an.x(this.bVv, 14, ac.adM("searchID"));
                ab.i("MicroMsg.FTS.FTSMainUI", "FTSWebReportLogic.kvReportGlobalTabClick reported type %d, searchId %s", Integer.valueOf(this.bVv), r0);
                FTSMainUI.this.aqX();
                Intent cVd = aa.cVd();
                cVd.putExtra("ftsneedkeyboard", true);
                cVd.putExtra("ftsbizscene", 14);
                cVd.putExtra("ftsType", this.bVv);
                Map d = aa.d(14, true, this.bVv);
                d.put("sessionId", com.tencent.mm.plugin.fts.a.e.mCM);
                d.put("subSessionId", com.tencent.mm.plugin.fts.a.e.mCM);
                cVd.putExtra("sessionId", com.tencent.mm.plugin.fts.a.e.mCM);
                cVd.putExtra("subSessionId", com.tencent.mm.plugin.fts.a.e.mCM);
                cVd.putExtra("rawUrl", aa.E(d));
                cVd.putExtra("key_load_js_without_delay", true);
                Bundle bundle = null;
                if (VERSION.SDK_INT >= 21) {
                    bundle = ActivityOptions.makeSceneTransitionAnimation(FTSMainUI.this, new Pair[0]).toBundle();
                }
                if (this.bVv != 64) {
                    com.tencent.mm.bp.d.a(FTSMainUI.this, "webview", ".ui.tools.fts.FTSSearchTabWebViewUI", cVd, bundle);
                    AppMethodBeat.o(61878);
                    return;
                }
                ((j) g.K(j.class)).aa(FTSMainUI.this, 14);
                AppMethodBeat.o(61878);
                return;
            }
            ab.e("MicroMsg.FTS.FTSMainUI", "fts h5 template not avail");
            AppMethodBeat.o(61878);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public FTSMainUI() {
        AppMethodBeat.i(61897);
        AppMethodBeat.o(61897);
    }

    static /* synthetic */ void e(FTSMainUI fTSMainUI) {
        AppMethodBeat.i(61925);
        fTSMainUI.bBc();
        AppMethodBeat.o(61925);
    }

    static /* synthetic */ void j(FTSMainUI fTSMainUI) {
        AppMethodBeat.i(61928);
        super.finish();
        AppMethodBeat.o(61928);
    }

    static /* synthetic */ com.tencent.mm.plugin.fts.ui.c.b k(FTSMainUI fTSMainUI) {
        AppMethodBeat.i(61929);
        com.tencent.mm.plugin.fts.ui.c.b bBe = fTSMainUI.bBe();
        AppMethodBeat.o(61929);
        return bBe;
    }

    static /* synthetic */ void l(FTSMainUI fTSMainUI) {
        AppMethodBeat.i(61930);
        fTSMainUI.bBd();
        AppMethodBeat.o(61930);
    }

    static /* synthetic */ void r(FTSMainUI fTSMainUI) {
        AppMethodBeat.i(61934);
        fTSMainUI.bBf();
        AppMethodBeat.o(61934);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(61898);
        super.onCreate(bundle);
        this.ieu = ah.getResources().getDisplayMetrics().widthPixels;
        this.iev = ah.getResources().getDisplayMetrics().heightPixels;
        if (VERSION.SDK_INT >= 21) {
            Transition inflateTransition = TransitionInflater.from(this).inflateTransition(17760258);
            TransitionInflater.from(this).inflateTransition(17760258);
            inflateTransition.excludeTarget(getWindow().getDecorView().findViewById(R.id.k0), true);
            inflateTransition.excludeTarget(16908335, true);
            getWindow().setEnterTransition(inflateTransition);
        }
        this.mJB = (KeyboardLinearLayout) findViewById(R.id.l_);
        this.mJB.setOnkbdStateListener(new KeyboardLinearLayout.a() {
            public final void sD(int i) {
                AppMethodBeat.i(61881);
                if (i == -3) {
                    ab.d("MicroMsg.FTS.FTSMainUI", "KEYBOARD_STATE_SHOW");
                    new ak().postDelayed(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(61879);
                            FTSMainUI.this.mJi = true;
                            if (bo.isNullOrNil(FTSMainUI.this.mIu.getSearchContent()) && FTSMainUI.this.mJh != null) {
                                FTSMainUI.this.mJh.show();
                            }
                            AppMethodBeat.o(61879);
                        }
                    }, 0);
                    AppMethodBeat.o(61881);
                    return;
                }
                if (i == -2) {
                    new ak().postDelayed(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(61880);
                            FTSMainUI.this.mJi = false;
                            if (FTSMainUI.this.mJh != null) {
                                FTSMainUI.this.mJh.bBy();
                            }
                            AppMethodBeat.o(61880);
                        }
                    }, 0);
                    ab.d("MicroMsg.FTS.FTSMainUI", "KEYBOARD_STATE_HIDE");
                }
                AppMethodBeat.o(61881);
            }
        });
        this.mIu.setHint(getString(R.string.te));
        com.tencent.mm.plugin.fts.a.e.mCM = aa.HP(3);
        ab.d("MicroMsg.FTS.FTSReportLogic", "reportFTSEnterClick: %d, %s", Integer.valueOf(10991), String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s", new Object[]{Integer.valueOf(this.mFa), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), com.tencent.mm.plugin.fts.a.e.mCM, ""}));
        h.pYm.X(10991, r0);
        this.mJe = (FTSMainUIEducationLayout) findViewById(R.id.byx);
        this.mJj = (LinearLayout) findViewById(R.id.bxt);
        this.mJe.setOnCellClickListener(this.mJH);
        this.mJe.setOnHotwordClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(61886);
                FTSMainUI fTSMainUI = FTSMainUI.this;
                String str = (String) view.getTag();
                if (System.currentTimeMillis() - fTSMainUI.ijU > 1000) {
                    fTSMainUI.ijU = System.currentTimeMillis();
                    if (aa.HU(0)) {
                        Intent cVd = aa.cVd();
                        cVd.putExtra("ftsbizscene", 15);
                        cVd.putExtra("ftsQuery", str);
                        cVd.putExtra("title", str);
                        cVd.putExtra("isWebwx", str);
                        cVd.putExtra("ftscaneditable", false);
                        Map d = aa.d(15, false, 2);
                        d.put(SearchIntents.EXTRA_QUERY, str);
                        d.put("sceneActionType", "2");
                        cVd.putExtra("rawUrl", aa.E(d));
                        ll llVar = new ll();
                        llVar.cHk.scene = 0;
                        com.tencent.mm.sdk.b.a.xxA.m(llVar);
                        cVd.putExtra("ftsInitToSearch", true);
                        com.tencent.mm.bp.d.b(fTSMainUI.mController.ylL, "webview", ".ui.tools.fts.FTSSOSHomeWebViewUI", cVd);
                        an.bz(15, str);
                    } else {
                        ab.e("MicroMsg.FTS.FTSMainUI", "fts h5 template not avail");
                        AppMethodBeat.o(61886);
                        return;
                    }
                }
                AppMethodBeat.o(61886);
            }
        });
        this.mJe.setNeedHotWord(false);
        g.K(com.tencent.mm.plugin.appbrand.widget.recentview.d.class);
        com.tencent.mm.sdk.g.d.xDG.b(new Runnable() {
            public final void run() {
                AppMethodBeat.i(61891);
                com.tencent.mm.modelgeo.d.agz().a(FTSMainUI.this, true);
                AppMethodBeat.o(61891);
            }
        }, "FTSMainUI.GetLocation");
        if (((n) g.M(n.class)).getFTSImageLoader() == null) {
            finish();
            AppMethodBeat.o(61898);
            return;
        }
        ((n) g.M(n.class)).getFTSImageLoader().bzY();
        ac.Ig(3);
        com.tencent.mm.sdk.b.a.xxA.b(this.mJI);
        com.tencent.mm.sdk.g.d.post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(61885);
                com.tencent.mm.storage.c ll = com.tencent.mm.model.c.c.abi().ll("100441");
                if (ll.isValid()) {
                    Map dru = ll.dru();
                    String str = "MicroMsg.FTS.FTSMainUI";
                    String str2 = "widget switch conf is %s";
                    Object[] objArr = new Object[1];
                    objArr[0] = dru == null ? "" : dru.toString();
                    ab.i(str, str2, objArr);
                    FTSMainUI.this.mJu = "1".equals(dru.get("isOpen"));
                    FTSMainUI.this.mJv = bo.anl((String) dru.get("searchBarWaitTimeoutMs"));
                }
                AppMethodBeat.o(61885);
            }
        }, "init-widget-switch");
        AppMethodBeat.o(61898);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        int i;
        boolean z = true;
        AppMethodBeat.i(61899);
        boolean onCreateOptionsMenu = super.onCreateOptionsMenu(menu);
        if (com.tencent.mm.sdk.platformtools.aa.don() || com.tencent.mm.sdk.platformtools.aa.dor().equals("en")) {
            i = true;
        } else {
            i = 0;
        }
        if (i == 0) {
            AppMethodBeat.o(61899);
            return onCreateOptionsMenu;
        }
        FTSVoiceInputLayoutImpl fTSVoiceInputLayoutImpl = (FTSVoiceInputLayoutImpl) findViewById(R.id.byz);
        TextView textView = (TextView) findViewById(R.id.byv);
        ImageView imageView = (ImageView) findViewById(R.id.byw);
        if (fTSVoiceInputLayoutImpl == null || textView == null || imageView == null) {
            boolean z2;
            String str = "MicroMsg.FTS.FTSMainUI";
            String str2 = "voicePanel == null || sayTv == null || loadingIv == null, %s, %s, %s";
            Object[] objArr = new Object[3];
            if (fTSVoiceInputLayoutImpl == null) {
                z2 = true;
            } else {
                z2 = false;
            }
            objArr[0] = Boolean.valueOf(z2);
            if (textView == null) {
                z2 = true;
            } else {
                z2 = false;
            }
            objArr[1] = Boolean.valueOf(z2);
            if (imageView != null) {
                z = false;
            }
            objArr[2] = Boolean.valueOf(z);
            ab.w(str, str2, objArr);
            AppMethodBeat.o(61899);
            return onCreateOptionsMenu;
        }
        this.mJh = new com.tencent.mm.plugin.fts.ui.widget.c(this, fTSVoiceInputLayoutImpl, textView, imageView);
        this.mJh.mMG = new com.tencent.mm.plugin.fts.ui.widget.c.a() {
            public final void bBh() {
                AppMethodBeat.i(61887);
                FTSMainUI.this.mIu.setCursorVisible(false);
                FTSMainUI.this.mJC.wd(1);
                FTSMainUI.e(FTSMainUI.this);
                FTSMainUI.this.mIu.setHint(FTSMainUI.this.mController.ylL.getString(R.string.c2d));
                AppMethodBeat.o(61887);
            }

            public final void Nx(String str) {
                AppMethodBeat.i(61888);
                FTSMainUI.this.mIu.setSearchContent(str);
                AppMethodBeat.o(61888);
            }

            public final void a(boolean z, boolean z2, String str) {
                AppMethodBeat.i(61889);
                FTSMainUI.this.mIu.setSearchContent(str);
                FTSMainUI.a(FTSMainUI.this, str);
                if (!z) {
                    if (z2) {
                        FTSMainUI.Nw(FTSMainUI.this.getString(R.string.c2f));
                        AppMethodBeat.o(61889);
                        return;
                    }
                    FTSMainUI.Nw(FTSMainUI.this.getString(R.string.c2g));
                }
                AppMethodBeat.o(61889);
            }

            public final void Ny(String str) {
                AppMethodBeat.i(61890);
                FTSMainUI.this.mJC.mIS.mLI = str;
                FTSMainUI.this.mIu.setSearchContent(str);
                FTSMainUI.a(FTSMainUI.this, str);
                AppMethodBeat.o(61890);
            }
        };
        AppMethodBeat.o(61899);
        return onCreateOptionsMenu;
    }

    public void onBackPressed() {
        AppMethodBeat.i(61900);
        finish();
        AppMethodBeat.o(61900);
    }

    public void onStop() {
        AppMethodBeat.i(61901);
        aqX();
        super.onStop();
        if (this.mJs != null) {
            this.mJs.onPause();
        }
        AppMethodBeat.o(61901);
    }

    /* Access modifiers changed, original: protected|final */
    public final void bAQ() {
        AppMethodBeat.i(61902);
        switch (getIntent().getIntExtra("from_tab_index", -1)) {
            case 0:
                this.mFa = 1;
                AppMethodBeat.o(61902);
                return;
            case 1:
                this.mFa = 2;
                AppMethodBeat.o(61902);
                return;
            case 2:
                this.mFa = 3;
                AppMethodBeat.o(61902);
                return;
            case 3:
                this.mFa = 4;
                AppMethodBeat.o(61902);
                return;
            default:
                this.mFa = 0;
                AppMethodBeat.o(61902);
                return;
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final d a(e eVar) {
        AppMethodBeat.i(61903);
        this.mJC = new j(eVar, this.mFa, this.mJD);
        this.mJC.wd(2);
        j jVar = this.mJC;
        AppMethodBeat.o(61903);
        return jVar;
    }

    public final int getLayoutId() {
        return R.layout.a1n;
    }

    public final void a(com.tencent.mm.plugin.fts.a.d.a.a aVar) {
    }

    public void onDestroy() {
        AppMethodBeat.i(61904);
        com.tencent.mm.sdk.g.d.xDG.remove("FTSMainUI.GetLocation");
        com.tencent.mm.modelgeo.d.agz().c(this);
        if (((n) g.M(n.class)).getFTSImageLoader() != null) {
            ((n) g.M(n.class)).getFTSImageLoader().bzZ();
        }
        com.tencent.mm.sdk.b.a.xxA.d(this.mJI);
        if (this.mJh != null) {
            com.tencent.mm.plugin.fts.ui.widget.c cVar = this.mJh;
            if (cVar.mMI != null) {
                cVar.mMI.amA();
                FTSVoiceInputLayoutImpl fTSVoiceInputLayoutImpl = cVar.mMI;
                if (fTSVoiceInputLayoutImpl.ilv != null) {
                    fTSVoiceInputLayoutImpl.ilv.removeCallbacksAndMessages(null);
                }
                if (fTSVoiceInputLayoutImpl.mNk != null) {
                    fTSVoiceInputLayoutImpl.mNk.removeCallbacksAndMessages(null);
                }
                if (fTSVoiceInputLayoutImpl.gci != null) {
                    fTSVoiceInputLayoutImpl.gci.stopTimer();
                }
            }
        }
        if (this.mJs != null) {
            this.mJs.onDestroy();
        }
        k.a(bBe());
        super.onDestroy();
        AppMethodBeat.o(61904);
    }

    public void onResume() {
        AppMethodBeat.i(61905);
        super.onResume();
        runOnUiThread(new Runnable() {
            public final void run() {
                AppMethodBeat.i(61895);
                com.tencent.mm.compatible.util.j.r(FTSMainUI.this);
                AppMethodBeat.o(61895);
            }
        });
        tv tvVar = new tv();
        tvVar.cPX.cvc = 0;
        com.tencent.mm.sdk.b.a.xxA.m(tvVar);
        com.tencent.mm.cj.c.aNX();
        if (this.mJk != null) {
            this.mJk.setEnabled(true);
        }
        if (!bo.isNullOrNil(this.mJy)) {
            this.query = this.mJy;
            this.mJy = null;
        }
        aa.cVe();
        if (this.mJs != null) {
            this.mJs.onResume();
        }
        AppMethodBeat.o(61905);
    }

    public void finish() {
        AppMethodBeat.i(61906);
        int i = 100;
        if (!this.mController.hideVKB()) {
            i = 0;
        }
        al.n(new Runnable() {
            public final void run() {
                AppMethodBeat.i(61896);
                ab.i("MicroMsg.FTS.FTSMainUI", " finish");
                FTSMainUI.j(FTSMainUI.this);
                AppMethodBeat.o(61896);
            }
        }, (long) i);
        AppMethodBeat.o(61906);
    }

    public final boolean a(boolean z, float f, float f2, int i, double d, double d2, double d3) {
        AppMethodBeat.i(61907);
        ab.i("MicroMsg.FTS.FTSMainUI", "onGetLocation %b %f|%f", Boolean.valueOf(z), Float.valueOf(f), Float.valueOf(f2));
        com.tencent.mm.modelgeo.d.agz().c(this);
        AppMethodBeat.o(61907);
        return false;
    }

    private void bBb() {
        AppMethodBeat.i(61908);
        this.mJe.setVisibility(0);
        this.mJe.cu();
        AppMethodBeat.o(61908);
    }

    private void bBc() {
        AppMethodBeat.i(61909);
        this.mJe.setVisibility(8);
        AppMethodBeat.o(61909);
    }

    /* Access modifiers changed, original: protected|final */
    public final void bAV() {
        AppMethodBeat.i(61910);
        super.bAV();
        bBb();
        this.mJj.setVisibility(8);
        if (this.mJi && this.mJh != null) {
            this.mJh.show();
        }
        AppMethodBeat.o(61910);
    }

    /* Access modifiers changed, original: protected|final */
    public final void bAU() {
        AppMethodBeat.i(61911);
        super.bAU();
        bBc();
        this.mJj.setVisibility(8);
        if (!(this.mJh == null || this.mJh.mMH)) {
            this.mJh.bBy();
        }
        AppMethodBeat.o(61911);
    }

    /* Access modifiers changed, original: protected|final */
    public final void bAT() {
        AppMethodBeat.i(61912);
        super.bAT();
        bBc();
        this.mJj.setVisibility(8);
        this.mIn.setVisibility(0);
        this.mIp.setVisibility(8);
        if (!(this.mJh == null || this.mJh.mMH)) {
            this.mJh.bBy();
        }
        AppMethodBeat.o(61912);
    }

    /* Access modifiers changed, original: protected|final */
    public final void bAS() {
        AppMethodBeat.i(61913);
        super.bAS();
        bBc();
        this.mJj.setVisibility(8);
        if (!(this.mJh == null || this.mJh.mMH)) {
            this.mJh.bBy();
        }
        AppMethodBeat.o(61913);
    }

    public final View aWz() {
        AppMethodBeat.i(61914);
        if (this.mJf == null) {
            this.mJf = (LinearLayout) getLayoutInflater().inflate(R.layout.a1k, null);
            this.mJn = (TextView) this.mJf.findViewById(R.id.byr);
            this.mJo = (TextView) this.mJf.findViewById(R.id.bys);
            try {
                ab.i("MicroMsg.FTS.FTSMainUI", "set searchNetworkTips %s", ac.adL("webSearchBar").optString("wording"));
                this.mJo.setText(r0);
            } catch (Exception e) {
            }
            this.mJl = this.mJf.findViewById(R.id.byo);
            this.mJk = this.mJf.findViewById(R.id.byn);
            this.mJf.findViewById(R.id.byq).setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(61867);
                    FTSMainUI.this.mJC.mIO = true;
                    if (!FTSMainUI.this.mJC.mIF) {
                        FTSMainUI.this.mJC.mIF = true;
                        k.a(FTSMainUI.this.query, true, FTSMainUI.this.mJC.getCount(), 0, FTSMainUI.k(FTSMainUI.this));
                    }
                    FTSMainUI.l(FTSMainUI.this);
                    AppMethodBeat.o(61867);
                }
            });
            this.mJt = this.mJf.findViewById(R.id.byp);
            this.mJs = ((com.tencent.mm.plugin.websearch.api.h) g.K(com.tencent.mm.plugin.websearch.api.h.class)).a((LinearLayout) this.mJt, com.tencent.mm.bz.a.ao(ah.getContext(), ah.getResources().getDisplayMetrics().widthPixels) - 26, this, this.mJG);
            this.mJm = new FTSLocalPageRelevantView(this);
            this.mJm.setOnRelevantClickListener(new FTSLocalPageRelevantView.b() {
                public final void a(btf btf, String str, int i) {
                    AppMethodBeat.i(61868);
                    String str2 = FTSMainUI.this.query;
                    if (btf.nbk == 1) {
                        FTSMainUI.this.mJy = FTSMainUI.this.query;
                        FTSMainUI.this.query = btf.wVl;
                        Map hashMap = new HashMap();
                        hashMap.put("prefixSug", FTSMainUI.this.mJy);
                        hashMap.put("sugId", str);
                        hashMap.put("sceneActionType", "6");
                        FTSMainUI.a(FTSMainUI.this, hashMap);
                    } else if (btf.nbk == 4 && !bo.isNullOrNil(btf.mZj)) {
                        Intent intent = new Intent();
                        intent.putExtra("rawUrl", btf.mZj);
                        intent.putExtra("convertActivityFromTranslucent", false);
                        com.tencent.mm.bp.d.b(ah.getContext(), "webview", ".ui.tools.WebViewUI", intent);
                    }
                    ((e) g.K(e.class)).d(str2, str, i, btf.wVl);
                    com.tencent.mm.plugin.fts.ui.c.b k = FTSMainUI.k(FTSMainUI.this);
                    k.a(str2, FTSMainUI.this.mJC.getCount(), FTSMainUI.this.mFa, k, 23);
                    FTSMainUI.this.mJC.mIO = true;
                    if (!FTSMainUI.this.mJC.mIF) {
                        FTSMainUI.this.mJC.mIF = true;
                        k.a(str2, true, FTSMainUI.this.mJC.getCount(), 0, k);
                    }
                    AppMethodBeat.o(61868);
                }
            });
            int indexOfChild = this.mJf.indexOfChild(this.mJk);
            if (indexOfChild >= 0 && indexOfChild < this.mJf.getChildCount()) {
                this.mJf.addView(this.mJm, indexOfChild + 1);
            }
            this.mJr = (TextView) this.mJf.findViewById(R.id.bym);
            this.mJq = this.mJf.findViewById(R.id.byk);
            this.mJp = this.mJf.findViewById(R.id.byl);
            this.mJp.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(61869);
                    FTSMainUI.c(FTSMainUI.this, FTSMainUI.this.query);
                    AppMethodBeat.o(61869);
                }
            });
            this.mJg = (LinearLayout) this.mJf.findViewById(R.id.byt);
        }
        LinearLayout linearLayout = this.mJf;
        AppMethodBeat.o(61914);
        return linearLayout;
    }

    private void bBd() {
        AppMethodBeat.i(61915);
        this.mJC.mIO = true;
        String str = this.query;
        if (str == null || bo.isNullOrNil(str.trim())) {
            AppMethodBeat.o(61915);
        } else if (System.currentTimeMillis() - this.ijU <= 1000) {
            AppMethodBeat.o(61915);
        } else {
            this.ijU = System.currentTimeMillis();
            String str2 = com.tencent.mm.plugin.fts.a.e.mCM;
            HashMap hashMap = new HashMap();
            hashMap.put("sceneActionType", "15");
            hashMap.put("clickType", "15");
            ((j) g.K(j.class)).a(this.mController.ylL, 3, str, str2, hashMap);
            an.Ik(3);
            if (!bo.isNullOrNil(this.query)) {
                an.l(this.query, 2, 2, 3);
            }
            this.mJk.setEnabled(false);
            k.a(this.query, this.mJC.getCount(), this.mFa, bBe(), 18);
            AppMethodBeat.o(61915);
        }
    }

    private com.tencent.mm.plugin.fts.ui.c.b bBe() {
        AppMethodBeat.i(61916);
        com.tencent.mm.plugin.fts.ui.c.b bVar = this.mJC.mIS;
        if (this.mJp == null || this.mJp.getVisibility() != 0) {
            bVar.mLE = this.mJC.getBlockCount() + 1;
        } else {
            bVar.mLE = this.mJC.getBlockCount() + 2;
        }
        AppMethodBeat.o(61916);
        return bVar;
    }

    public final boolean vN(String str) {
        AppMethodBeat.i(61917);
        super.vN(str);
        bBf();
        AppMethodBeat.o(61917);
        return false;
    }

    private void bBf() {
        AppMethodBeat.i(61918);
        if (this.mJz && !TextUtils.isEmpty(this.query)) {
            cv cvVar;
            if (this.mJC.getBlockCount() == 0 && this.mJt.getVisibility() == 8 && TextUtils.isEmpty(this.mJr.getText())) {
                bBd();
                cvVar = new cv();
                cvVar.dim = 1;
                cvVar.cTl = 1;
                cvVar.hL(this.query).ajK();
                AppMethodBeat.o(61918);
                return;
            }
            cvVar = new cv();
            cvVar.dim = 1;
            cvVar.cTl = 2;
            cvVar.hL(this.query).ajK();
        }
        AppMethodBeat.o(61918);
    }

    /* Access modifiers changed, original: protected|final */
    public final void bAW() {
        AppMethodBeat.i(61919);
        if (this.mJg != null) {
            this.mJg.setVisibility(0);
        }
        AppMethodBeat.o(61919);
    }

    /* Access modifiers changed, original: protected|final */
    public final void bAX() {
        AppMethodBeat.i(61920);
        if (this.mJg != null) {
            this.mJg.setVisibility(8);
        }
        AppMethodBeat.o(61920);
    }

    public final void U(int i, boolean z) {
        AppMethodBeat.i(61921);
        super.U(i, z);
        this.mJm.setVisibility(8);
        this.mJs.hide();
        this.mJt.setVisibility(8);
        if (!z && i == 0 && this.mJC.mJa) {
            this.mJj.setVisibility(0);
        } else {
            this.mJj.setVisibility(8);
        }
        if (z) {
            this.mJz = true;
            boolean Nd = com.tencent.mm.plugin.fts.a.d.Nd(this.query);
            boolean Ne = com.tencent.mm.plugin.fts.a.d.Ne(this.query);
            if (i > 0) {
                if (Nd || Ne) {
                    this.mJq.setVisibility(0);
                }
                this.mJl.setVisibility(0);
            } else {
                this.mJq.setVisibility(8);
                if (Nd || Ne) {
                    this.mJl.setVisibility(0);
                } else {
                    this.mJl.setVisibility(8);
                }
            }
            if (Nd || Ne) {
                this.mJp.setVisibility(0);
            }
            this.mJw = true;
            if (this.mJu) {
                ab.i("MicroMsg.FTS.FTSMainUI", "wait for search widget result , timeout %d", Long.valueOf(this.mJv));
                al.n(this.mJx, this.mJv);
            } else {
                this.mJk.setVisibility(0);
            }
            if (this.query != null && this.query.length() > 0) {
                ((e) g.K(e.class)).a(this.query, this.mJF, this);
                ((p) g.K(p.class)).a(this.query, com.tencent.mm.plugin.fts.a.e.mCM, this.mJE);
            }
            AppMethodBeat.o(61921);
            return;
        }
        al.af(this.mJx);
        this.mJk.setVisibility(8);
        this.mJp.setVisibility(8);
        this.mJw = false;
        AppMethodBeat.o(61921);
    }

    public final void vO(String str) {
        AppMethodBeat.i(61922);
        if (this.mJh == null || !this.mJh.mMH) {
            super.vO(str);
        }
        this.mJz = false;
        AppMethodBeat.o(61922);
    }

    /* Access modifiers changed, original: protected|final */
    public final void bAM() {
        AppMethodBeat.i(61923);
        super.bAM();
        this.mJn.setText(com.tencent.mm.pluginsdk.ui.e.j.b((Context) this, f.a(getString(R.string.c28), "", com.tencent.mm.plugin.fts.a.a.d.b(this.query, this.query)).mDR, com.tencent.mm.bz.a.al(this, R.dimen.m5)));
        CharSequence charSequence = null;
        if (com.tencent.mm.plugin.fts.a.d.Nd(this.query)) {
            charSequence = f.a(getString(R.string.c1f), "", com.tencent.mm.plugin.fts.a.a.d.b(this.query, this.query)).mDR;
        } else if (com.tencent.mm.plugin.fts.a.d.Ne(this.query)) {
            charSequence = f.a(getString(R.string.c1g), "", com.tencent.mm.plugin.fts.a.a.d.b(this.query, this.query)).mDR;
        }
        this.mJr.setText(com.tencent.mm.pluginsdk.ui.e.j.b((Context) this, charSequence, com.tencent.mm.bz.a.al(this, R.dimen.m5)));
        AppMethodBeat.o(61923);
    }

    public void onClickWxApp(View view) {
        AppMethodBeat.i(61924);
        if (view.getTag().equals("more-click")) {
            ((com.tencent.mm.plugin.appbrand.service.i) g.K(com.tencent.mm.plugin.appbrand.service.i.class)).a((Context) this, com.tencent.mm.plugin.fts.a.e.mCM, com.tencent.mm.plugin.appbrand.service.i.a.CLICK);
            AppMethodBeat.o(61924);
        } else if (view.getTag().equals("more-swipe")) {
            ((com.tencent.mm.plugin.appbrand.service.i) g.K(com.tencent.mm.plugin.appbrand.service.i.class)).a((Context) this, com.tencent.mm.plugin.fts.a.e.mCM, com.tencent.mm.plugin.appbrand.service.i.a.SWIPE);
            AppMethodBeat.o(61924);
        } else {
            ((com.tencent.mm.plugin.appbrand.service.i) g.K(com.tencent.mm.plugin.appbrand.service.i.class)).a((Context) this, (com.tencent.mm.plugin.appbrand.service.i.c) view.getTag(), com.tencent.mm.plugin.fts.a.e.mCM);
            AppMethodBeat.o(61924);
        }
    }

    static /* synthetic */ void Nw(String str) {
        AppMethodBeat.i(61927);
        com.tencent.mm.ui.widget.a.e.a re = new com.tencent.mm.ui.widget.a.e.a(ah.getContext()).asL(str).re(true);
        re.zQM = true;
        re.a(null, null).show();
        AppMethodBeat.o(61927);
    }

    static /* synthetic */ void c(FTSMainUI fTSMainUI, final String str) {
        int i;
        AppMethodBeat.i(61932);
        com.tencent.mm.plugin.fts.ui.c.b bVar = fTSMainUI.mJC.mIS;
        bVar.mLE = fTSMainUI.mJC.getBlockCount() + 1;
        int count = fTSMainUI.mJC.getCount();
        int i2 = fTSMainUI.mFa;
        if (com.tencent.mm.plugin.fts.a.d.Nd(str)) {
            i = 8;
        } else {
            i = 9;
        }
        int i3 = count + 1;
        long currentTimeMillis = System.currentTimeMillis() - bVar.mLr;
        if (currentTimeMillis < 0 || bVar.mLr == 0) {
            currentTimeMillis = 0;
        }
        Object obj = !bVar.mLI.equals(str) ? 1 : null;
        String str2 = "%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s";
        Object[] objArr = new Object[32];
        objArr[0] = Integer.valueOf(i2);
        objArr[1] = Integer.valueOf(i);
        objArr[2] = Integer.valueOf(i3);
        objArr[3] = Integer.valueOf(0);
        objArr[4] = Integer.valueOf(0);
        objArr[5] = "";
        objArr[6] = "";
        objArr[7] = Integer.valueOf(0);
        objArr[8] = Integer.valueOf(0);
        objArr[9] = Integer.valueOf(0);
        objArr[10] = Integer.valueOf(0);
        objArr[11] = "";
        objArr[12] = Long.valueOf(currentTimeMillis);
        objArr[13] = Integer.valueOf(bVar.mLu);
        objArr[14] = Integer.valueOf(bVar.mLv);
        objArr[15] = Integer.valueOf(bVar.mLw);
        objArr[16] = Integer.valueOf(bVar.mLx);
        objArr[17] = Integer.valueOf(bVar.mLy);
        objArr[18] = Integer.valueOf(bVar.mLz);
        objArr[19] = Integer.valueOf(bVar.mLA);
        objArr[20] = Integer.valueOf(bVar.mLC);
        objArr[21] = Integer.valueOf(bVar.mLD);
        objArr[22] = com.tencent.mm.plugin.fts.a.e.mCM;
        objArr[23] = str;
        objArr[24] = Integer.valueOf(bVar.mLB);
        objArr[25] = Integer.valueOf(bVar.mLE);
        objArr[26] = Integer.valueOf(bVar.bBj());
        objArr[27] = "";
        objArr[28] = "";
        objArr[29] = "";
        objArr[30] = Integer.valueOf(1);
        if (obj != null) {
            i = 1;
        } else {
            i = 0;
        }
        objArr[31] = Integer.valueOf(i);
        ab.d("MicroMsg.FTS.FTSReportLogic", "10991 reportSearchWeChatId click: %d, %s", Integer.valueOf(10991), String.format(str2, objArr));
        h.pYm.X(10991, r0);
        j jVar = fTSMainUI.mJC;
        jVar.mIO = true;
        if (!bo.isNullOrNil(jVar.query)) {
            an.l(jVar.query, jVar.mHU, 1, 3);
        }
        fTSMainUI.mJC.mIO = true;
        if (!fTSMainUI.mJC.mIF) {
            fTSMainUI.mJC.mIF = true;
            k.a(str, true, fTSMainUI.mJC.getCount(), 0, bVar);
        }
        if (str == null || str.length() == 0 || str.trim().length() == 0) {
            AppMethodBeat.o(61932);
            return;
        }
        fTSMainUI.mIa = Character.isDigit(str.charAt(0)) ? 15 : 3;
        final com.tencent.mm.ai.f anonymousClass5 = new com.tencent.mm.ai.f() {
            public final void onSceneEnd(int i, int i2, String str, com.tencent.mm.ai.m mVar) {
                AppMethodBeat.i(61870);
                g.Rg().b(106, (com.tencent.mm.ai.f) this);
                if (i == 4 && i2 == -4) {
                    FTSMainUI.o(FTSMainUI.this);
                    com.tencent.mm.ui.base.h.a(FTSMainUI.this, (int) R.string.dzx, 0, true, null);
                    AppMethodBeat.o(61870);
                    return;
                }
                FTSMainUI.o(FTSMainUI.this);
                if (i == 0 && i2 == 0) {
                    buv bOj = ((com.tencent.mm.plugin.messenger.a.f) mVar).bOj();
                    Intent intent;
                    if (bOj.wod <= 0) {
                        if (bo.nullAsNil(com.tencent.mm.platformtools.aa.a(bOj.wcB)).length() > 0) {
                            if (2 == bOj.wWh) {
                                FTSMainUI.this.mIa = 15;
                            } else if (1 == bOj.wWh) {
                                FTSMainUI.this.mIa = 1;
                            }
                            intent = new Intent();
                            ((com.tencent.mm.api.j) g.K(com.tencent.mm.api.j.class)).a(intent, bOj, FTSMainUI.this.mIa);
                            if (FTSMainUI.this.mIa == 15) {
                                intent.putExtra("Contact_Search_Mobile", str.trim());
                            }
                            intent.putExtra("Contact_Scene", FTSMainUI.this.mIa);
                            intent.putExtra("add_more_friend_search_scene", 2);
                            com.tencent.mm.bp.d.b(FTSMainUI.this, Scopes.PROFILE, ".ui.ContactInfoUI", intent);
                        }
                        AppMethodBeat.o(61870);
                        return;
                    } else if (bOj.woe.isEmpty()) {
                        com.tencent.mm.ui.base.h.a(FTSMainUI.this, (int) R.string.dzx, 0, true, null);
                        AppMethodBeat.o(61870);
                        return;
                    } else {
                        intent = new Intent();
                        ((com.tencent.mm.api.j) g.K(com.tencent.mm.api.j.class)).a(intent, (but) bOj.woe.getFirst(), FTSMainUI.this.mIa);
                        com.tencent.mm.bp.d.b(FTSMainUI.this, Scopes.PROFILE, ".ui.ContactInfoUI", intent);
                        AppMethodBeat.o(61870);
                        return;
                    }
                }
                switch (i2) {
                    case DownloadResult.CODE_CONNECTION_EXCEPTION /*-24*/:
                        com.tencent.mm.h.a jY = com.tencent.mm.h.a.jY(str);
                        if (jY != null) {
                            com.tencent.mm.ui.base.h.a(FTSMainUI.this, jY.desc, jY.Title, true, null);
                            break;
                        }
                        break;
                    case -4:
                        Toast.makeText(FTSMainUI.this, FTSMainUI.this.getString(R.string.dzs), 0).show();
                        break;
                }
                ab.w("MicroMsg.FTS.FTSMainUI", String.format("Search contact failed: %d, %d.", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}));
                AppMethodBeat.o(61870);
            }
        };
        g.Rg().a(106, anonymousClass5);
        final com.tencent.mm.ai.m fVar = new com.tencent.mm.plugin.messenger.a.f(str, 3);
        g.Rg().a(fVar, 0);
        fTSMainUI.getString(R.string.tz);
        fTSMainUI.lud = com.tencent.mm.ui.base.h.b((Context) fTSMainUI, fTSMainUI.getString(R.string.dzr), true, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(61871);
                g.Rg().c(fVar);
                g.Rg().b(106, anonymousClass5);
                FTSMainUI.this.lud = null;
                AppMethodBeat.o(61871);
            }
        });
        AppMethodBeat.o(61932);
    }

    static /* synthetic */ void o(FTSMainUI fTSMainUI) {
        AppMethodBeat.i(61933);
        al.d(new Runnable() {
            public final void run() {
                AppMethodBeat.i(61872);
                if (FTSMainUI.this.lud != null) {
                    FTSMainUI.this.lud.dismiss();
                    FTSMainUI.this.lud = null;
                }
                AppMethodBeat.o(61872);
            }
        });
        AppMethodBeat.o(61933);
    }
}
