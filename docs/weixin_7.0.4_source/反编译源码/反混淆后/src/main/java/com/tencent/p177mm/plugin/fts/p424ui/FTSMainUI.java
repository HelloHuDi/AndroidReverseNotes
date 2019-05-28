package com.tencent.p177mm.plugin.fts.p424ui;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.api.C32250j;
import com.tencent.p177mm.compatible.util.C18175j;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.p262c.C18624c;
import com.tencent.p177mm.modelgeo.C26443d;
import com.tencent.p177mm.modelgeo.C42207b.C42206a;
import com.tencent.p177mm.p1192h.C42124a;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p218cj.C45287c;
import com.tencent.p177mm.p230g.p231a.C18427vl;
import com.tencent.p177mm.p230g.p231a.C26190ll;
import com.tencent.p177mm.p230g.p231a.C26245tv;
import com.tencent.p177mm.p230g.p232b.p233a.C46884cv;
import com.tencent.p177mm.p612ui.KeyboardLinearLayout;
import com.tencent.p177mm.p612ui.KeyboardLinearLayout.C44246a;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.p612ui.widget.p633a.C5663e.C5659a;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.platformtools.C1946aa;
import com.tencent.p177mm.plugin.appbrand.service.C19734i;
import com.tencent.p177mm.plugin.appbrand.service.C19734i.C10734c;
import com.tencent.p177mm.plugin.appbrand.service.C19734i.C19735a;
import com.tencent.p177mm.plugin.appbrand.widget.recentview.C11048d;
import com.tencent.p177mm.plugin.fts.p419a.C12029n;
import com.tencent.p177mm.plugin.fts.p419a.C3161d;
import com.tencent.p177mm.plugin.fts.p419a.C3163e;
import com.tencent.p177mm.plugin.fts.p419a.C34204f;
import com.tencent.p177mm.plugin.fts.p419a.p420a.C39127d;
import com.tencent.p177mm.plugin.fts.p419a.p421d.p422a.C3154a;
import com.tencent.p177mm.plugin.fts.p424ui.C34231j.C34233b;
import com.tencent.p177mm.plugin.fts.p424ui.p1551c.C39154b;
import com.tencent.p177mm.plugin.fts.p424ui.widget.C45979c;
import com.tencent.p177mm.plugin.fts.p424ui.widget.C45979c.C39156a;
import com.tencent.p177mm.plugin.fts.p424ui.widget.FTSLocalPageRelevantView;
import com.tencent.p177mm.plugin.fts.p424ui.widget.FTSLocalPageRelevantView.C20895b;
import com.tencent.p177mm.plugin.fts.p424ui.widget.FTSMainUIEducationLayout;
import com.tencent.p177mm.plugin.fts.p424ui.widget.FTSVoiceInputLayoutImpl;
import com.tencent.p177mm.plugin.messenger.p993a.C12518f;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.websearch.api.C14423an;
import com.tencent.p177mm.plugin.websearch.api.C22757j;
import com.tencent.p177mm.plugin.websearch.api.C22758p;
import com.tencent.p177mm.plugin.websearch.api.C29736ac;
import com.tencent.p177mm.plugin.websearch.api.C29739g;
import com.tencent.p177mm.plugin.websearch.api.C29740h;
import com.tencent.p177mm.plugin.websearch.api.C29741i;
import com.tencent.p177mm.plugin.websearch.api.C40191d;
import com.tencent.p177mm.plugin.websearch.api.C40193m;
import com.tencent.p177mm.plugin.websearch.api.C43853o;
import com.tencent.p177mm.plugin.websearch.api.C46400aa;
import com.tencent.p177mm.plugin.websearch.api.C46402e;
import com.tencent.p177mm.plugin.websearch.api.WidgetData;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.protocal.protobuf.brd;
import com.tencent.p177mm.protocal.protobuf.btf;
import com.tencent.p177mm.protocal.protobuf.but;
import com.tencent.p177mm.protocal.protobuf.buv;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C40619x;
import com.tencent.p177mm.sdk.platformtools.C4988aa;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.storage.C5141c;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.DownloadResult;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

@C5271a(3)
/* renamed from: com.tencent.mm.plugin.fts.ui.FTSMainUI */
public class FTSMainUI extends FTSBaseVoiceSearchUI implements C42206a {
    private int ieu;
    private int iev;
    long ijU;
    private Dialog lud;
    private int mFa;
    int mIa = -1;
    private Map<String, Integer> mJA = new HashMap();
    private KeyboardLinearLayout mJB;
    private C34231j mJC;
    private C34233b mJD = new C317819();
    private C43853o mJE = new C31868();
    private C40191d mJF = new C31719();
    private C29739g mJG = new C317910();
    private OnClickListener mJH = new C318113();
    private C4884c<C18427vl> mJI = new C319014();
    private FTSMainUIEducationLayout mJe;
    private LinearLayout mJf;
    private LinearLayout mJg;
    private C45979c mJh;
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
    private C29741i mJs;
    private View mJt;
    private boolean mJu;
    private long mJv;
    private boolean mJw;
    private Runnable mJx = new C31721();
    private String mJy;
    private volatile boolean mJz;

    /* renamed from: com.tencent.mm.plugin.fts.ui.FTSMainUI$15 */
    class C316815 implements Runnable {
        C316815() {
        }

        public final void run() {
            AppMethodBeat.m2504i(61885);
            C5141c ll = C18624c.abi().mo17131ll("100441");
            if (ll.isValid()) {
                Map dru = ll.dru();
                String str = "MicroMsg.FTS.FTSMainUI";
                String str2 = "widget switch conf is %s";
                Object[] objArr = new Object[1];
                objArr[0] = dru == null ? "" : dru.toString();
                C4990ab.m7417i(str, str2, objArr);
                FTSMainUI.this.mJu = "1".equals(dru.get("isOpen"));
                FTSMainUI.this.mJv = C5046bo.anl((String) dru.get("searchBarWaitTimeoutMs"));
            }
            AppMethodBeat.m2505o(61885);
        }
    }

    /* renamed from: com.tencent.mm.plugin.fts.ui.FTSMainUI$17 */
    class C316917 implements C39156a {
        C316917() {
        }

        public final void bBh() {
            AppMethodBeat.m2504i(61887);
            FTSMainUI.this.mIu.setCursorVisible(false);
            FTSMainUI.this.mJC.mo54795wd(1);
            FTSMainUI.m5444e(FTSMainUI.this);
            FTSMainUI.this.mIu.setHint(FTSMainUI.this.mController.ylL.getString(C25738R.string.c2d));
            AppMethodBeat.m2505o(61887);
        }

        /* renamed from: Nx */
        public final void mo7462Nx(String str) {
            AppMethodBeat.m2504i(61888);
            FTSMainUI.this.mIu.setSearchContent(str);
            AppMethodBeat.m2505o(61888);
        }

        /* renamed from: a */
        public final void mo7464a(boolean z, boolean z2, String str) {
            AppMethodBeat.m2504i(61889);
            FTSMainUI.this.mIu.setSearchContent(str);
            FTSMainUI.m5433a(FTSMainUI.this, str);
            if (!z) {
                if (z2) {
                    FTSMainUI.m5431Nw(FTSMainUI.this.getString(C25738R.string.c2f));
                    AppMethodBeat.m2505o(61889);
                    return;
                }
                FTSMainUI.m5431Nw(FTSMainUI.this.getString(C25738R.string.c2g));
            }
            AppMethodBeat.m2505o(61889);
        }

        /* renamed from: Ny */
        public final void mo7463Ny(String str) {
            AppMethodBeat.m2504i(61890);
            FTSMainUI.this.mJC.mIS.mLI = str;
            FTSMainUI.this.mIu.setSearchContent(str);
            FTSMainUI.m5433a(FTSMainUI.this, str);
            AppMethodBeat.m2505o(61890);
        }
    }

    /* renamed from: com.tencent.mm.plugin.fts.ui.FTSMainUI$18 */
    class C317018 implements Runnable {
        C317018() {
        }

        public final void run() {
            AppMethodBeat.m2504i(61891);
            C26443d.agz().mo44204a(FTSMainUI.this, true);
            AppMethodBeat.m2505o(61891);
        }
    }

    /* renamed from: com.tencent.mm.plugin.fts.ui.FTSMainUI$9 */
    class C31719 implements C40191d {
        C31719() {
        }

        /* renamed from: a */
        public final void mo7467a(boolean z, brd brd, String str, String str2) {
            AppMethodBeat.m2504i(61874);
            if (FTSMainUI.this.query.equals(str2)) {
                if (!z) {
                    FTSMainUI.this.mJm.setVisibility(8);
                } else if (FTSMainUI.this.mJk.getVisibility() == 0) {
                    int i;
                    FTSLocalPageRelevantView f = FTSMainUI.this.mJm;
                    if (brd == null || brd.vHk == null) {
                        C4990ab.m7420w("MicroMsg.FTS.FTSLocalPageRelevantView", "configRelevantDatas param nil!");
                        i = 0;
                    } else {
                        List ca = FTSLocalPageRelevantView.m32132ca(brd.vHk);
                        if (ca.size() <= 0) {
                            C4990ab.m7420w("MicroMsg.FTS.FTSLocalPageRelevantView", "configRelevantDatas size 0 items!");
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
                            f.mo36184b(ca, f.jbJ);
                            f.requestLayout();
                            i = 1;
                        }
                    }
                    if (i != 0) {
                        FTSMainUI.this.mJm.setVisibility(0);
                        AppMethodBeat.m2505o(61874);
                        return;
                    }
                }
                AppMethodBeat.m2505o(61874);
                return;
            }
            C4990ab.m7417i("MicroMsg.FTS.FTSMainUI", "IRelevantSearchCallback callback with query %s, current query is %s ", str2, FTSMainUI.this.query);
            AppMethodBeat.m2505o(61874);
        }
    }

    /* renamed from: com.tencent.mm.plugin.fts.ui.FTSMainUI$1 */
    class C31721 implements Runnable {
        C31721() {
        }

        public final void run() {
            AppMethodBeat.m2504i(61866);
            C4990ab.m7417i("MicroMsg.FTS.FTSMainUI", "showSearchNetworkLayoutRunnable canShow %b", Boolean.valueOf(FTSMainUI.this.mJw));
            if (FTSMainUI.this.mJw) {
                FTSMainUI.this.mJk.setVisibility(0);
            }
            AppMethodBeat.m2505o(61866);
        }
    }

    /* renamed from: com.tencent.mm.plugin.fts.ui.FTSMainUI$20 */
    class C317320 implements Runnable {
        C317320() {
        }

        public final void run() {
            AppMethodBeat.m2504i(61895);
            C18175j.m28619r(FTSMainUI.this);
            AppMethodBeat.m2505o(61895);
        }
    }

    /* renamed from: com.tencent.mm.plugin.fts.ui.FTSMainUI$21 */
    class C317421 implements Runnable {
        C317421() {
        }

        public final void run() {
            AppMethodBeat.m2504i(61896);
            C4990ab.m7416i("MicroMsg.FTS.FTSMainUI", " finish");
            FTSMainUI.m5449j(FTSMainUI.this);
            AppMethodBeat.m2505o(61896);
        }
    }

    /* renamed from: com.tencent.mm.plugin.fts.ui.FTSMainUI$2 */
    class C31752 implements OnClickListener {
        C31752() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(61867);
            FTSMainUI.this.mJC.mIO = true;
            if (!FTSMainUI.this.mJC.mIF) {
                FTSMainUI.this.mJC.mIF = true;
                C34234k.m56146a(FTSMainUI.this.query, true, FTSMainUI.this.mJC.getCount(), 0, FTSMainUI.m5450k(FTSMainUI.this));
            }
            FTSMainUI.m5451l(FTSMainUI.this);
            AppMethodBeat.m2505o(61867);
        }
    }

    /* renamed from: com.tencent.mm.plugin.fts.ui.FTSMainUI$4 */
    class C31764 implements OnClickListener {
        C31764() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(61869);
            FTSMainUI.m5442c(FTSMainUI.this, FTSMainUI.this.query);
            AppMethodBeat.m2505o(61869);
        }
    }

    /* renamed from: com.tencent.mm.plugin.fts.ui.FTSMainUI$16 */
    class C317716 implements OnClickListener {
        C317716() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(61886);
            FTSMainUI fTSMainUI = FTSMainUI.this;
            String str = (String) view.getTag();
            if (System.currentTimeMillis() - fTSMainUI.ijU > 1000) {
                fTSMainUI.ijU = System.currentTimeMillis();
                if (C46400aa.m87304HU(0)) {
                    Intent cVd = C46400aa.cVd();
                    cVd.putExtra("ftsbizscene", 15);
                    cVd.putExtra("ftsQuery", str);
                    cVd.putExtra("title", str);
                    cVd.putExtra("isWebwx", str);
                    cVd.putExtra("ftscaneditable", false);
                    Map d = C46400aa.m87334d(15, false, 2);
                    d.put(SearchIntents.EXTRA_QUERY, str);
                    d.put("sceneActionType", "2");
                    cVd.putExtra("rawUrl", C46400aa.m87298E(d));
                    C26190ll c26190ll = new C26190ll();
                    c26190ll.cHk.scene = 0;
                    C4879a.xxA.mo10055m(c26190ll);
                    cVd.putExtra("ftsInitToSearch", true);
                    C25985d.m41467b(fTSMainUI.mController.ylL, "webview", ".ui.tools.fts.FTSSOSHomeWebViewUI", cVd);
                    C14423an.m22652bz(15, str);
                } else {
                    C4990ab.m7412e("MicroMsg.FTS.FTSMainUI", "fts h5 template not avail");
                    AppMethodBeat.m2505o(61886);
                    return;
                }
            }
            AppMethodBeat.m2505o(61886);
        }
    }

    /* renamed from: com.tencent.mm.plugin.fts.ui.FTSMainUI$19 */
    class C317819 implements C34233b {
        C317819() {
        }

        public final void bAY() {
            AppMethodBeat.m2504i(61892);
            String query = FTSMainUI.this.mJm.getQuery();
            if (!(FTSMainUI.this.mJm.getVisibility() != 0 || C5046bo.isNullOrNil(query) || FTSMainUI.this.mJA.containsKey(query))) {
                FTSMainUI.this.mJA.put(query, Integer.valueOf(1));
                ((C46402e) C1720g.m3528K(C46402e.class)).mo63536ar(query, FTSMainUI.this.mJm.getSearchId(), FTSMainUI.this.mJm.getWordList());
            }
            FTSMainUI.this.mJC.mIS.mLH = 1;
            AppMethodBeat.m2505o(61892);
        }

        public final void bAZ() {
            AppMethodBeat.m2504i(61893);
            if (FTSMainUI.this.mJt.getVisibility() == 0) {
                FTSMainUI.this.mJs.onResume();
            }
            AppMethodBeat.m2505o(61893);
        }

        public final void bBa() {
            AppMethodBeat.m2504i(61894);
            if (FTSMainUI.this.mJt.getVisibility() == 0) {
                FTSMainUI.this.mJs.onPause();
            }
            AppMethodBeat.m2505o(61894);
        }
    }

    /* renamed from: com.tencent.mm.plugin.fts.ui.FTSMainUI$10 */
    class C317910 implements C29739g {
        C317910() {
        }

        public final void onClick() {
            AppMethodBeat.m2504i(61875);
            C34234k.m56145a(FTSMainUI.this.query, FTSMainUI.this.mJC.getCount(), FTSMainUI.this.mFa, FTSMainUI.m5450k(FTSMainUI.this), 24);
            AppMethodBeat.m2505o(61875);
        }

        public final void bBg() {
            AppMethodBeat.m2504i(61876);
            FTSMainUI.this.mJC.mIS.mLG = 1;
            AppMethodBeat.m2505o(61876);
        }

        /* renamed from: u */
        public final boolean mo7479u(int[] iArr) {
            AppMethodBeat.m2504i(61877);
            int s = FTSMainUI.this.ieu;
            int t = FTSMainUI.this.iev;
            if (FTSMainUI.this.mController.ymc == -3) {
                t -= C40619x.m70070gp(FTSMainUI.this);
            }
            if (iArr[0] < 0 || iArr[0] >= s || iArr[1] < 0 || iArr[1] >= t) {
                AppMethodBeat.m2505o(61877);
                return false;
            }
            AppMethodBeat.m2505o(61877);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.fts.ui.FTSMainUI$3 */
    class C31803 implements C20895b {
        C31803() {
        }

        /* renamed from: a */
        public final void mo7480a(btf btf, String str, int i) {
            AppMethodBeat.m2504i(61868);
            String str2 = FTSMainUI.this.query;
            if (btf.nbk == 1) {
                FTSMainUI.this.mJy = FTSMainUI.this.query;
                FTSMainUI.this.query = btf.wVl;
                Map hashMap = new HashMap();
                hashMap.put("prefixSug", FTSMainUI.this.mJy);
                hashMap.put("sugId", str);
                hashMap.put("sceneActionType", "6");
                FTSMainUI.m5434a(FTSMainUI.this, hashMap);
            } else if (btf.nbk == 4 && !C5046bo.isNullOrNil(btf.mZj)) {
                Intent intent = new Intent();
                intent.putExtra("rawUrl", btf.mZj);
                intent.putExtra("convertActivityFromTranslucent", false);
                C25985d.m41467b(C4996ah.getContext(), "webview", ".ui.tools.WebViewUI", intent);
            }
            ((C46402e) C1720g.m3528K(C46402e.class)).mo63537d(str2, str, i, btf.wVl);
            C39154b k = FTSMainUI.m5450k(FTSMainUI.this);
            C34234k.m56145a(str2, FTSMainUI.this.mJC.getCount(), FTSMainUI.this.mFa, k, 23);
            FTSMainUI.this.mJC.mIO = true;
            if (!FTSMainUI.this.mJC.mIF) {
                FTSMainUI.this.mJC.mIF = true;
                C34234k.m56146a(str2, true, FTSMainUI.this.mJC.getCount(), 0, k);
            }
            AppMethodBeat.m2505o(61868);
        }
    }

    /* renamed from: com.tencent.mm.plugin.fts.ui.FTSMainUI$13 */
    class C318113 implements OnClickListener {
        C318113() {
        }

        /* JADX WARNING: Removed duplicated region for block: B:10:0x0039  */
        /* JADX WARNING: Removed duplicated region for block: B:6:0x001c  */
        /* JADX WARNING: Removed duplicated region for block: B:10:0x0039  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onClick(View view) {
            int optInt;
            int i;
            AppMethodBeat.m2504i(61882);
            try {
                if (view.getTag() != null) {
                    optInt = ((JSONObject) view.getTag()).optInt("businessType");
                    if (optInt == 0) {
                        String charSequence = ((TextView) view).getText().toString();
                        if (charSequence.equals(FTSMainUI.this.getString(C25738R.string.e0b))) {
                            i = 2;
                        } else if (charSequence.equals(FTSMainUI.this.getString(C25738R.string.e0f))) {
                            i = 8;
                        } else if (charSequence.equals(FTSMainUI.this.getString(C25738R.string.e0c))) {
                            i = 1;
                        }
                        if (i != 0) {
                            FTSMainUI fTSMainUI = FTSMainUI.this;
                            ((C40193m) C1720g.m3528K(C40193m.class)).mo63531a(fTSMainUI, new C318211(i));
                        }
                        AppMethodBeat.m2505o(61882);
                    }
                    i = optInt;
                    if (i != 0) {
                    }
                    AppMethodBeat.m2505o(61882);
                }
            } catch (Exception e) {
            }
            optInt = 0;
            if (optInt == 0) {
            }
            i = optInt;
            if (i != 0) {
            }
            AppMethodBeat.m2505o(61882);
        }
    }

    /* renamed from: com.tencent.mm.plugin.fts.ui.FTSMainUI$11 */
    class C318211 implements Runnable {
        final /* synthetic */ int bVv;

        C318211(int i) {
            this.bVv = i;
        }

        public final void run() {
            AppMethodBeat.m2504i(61878);
            if (System.currentTimeMillis() - FTSMainUI.this.ijU <= 1000) {
                AppMethodBeat.m2505o(61878);
                return;
            }
            FTSMainUI.this.ijU = System.currentTimeMillis();
            if (C46400aa.m87304HU(0)) {
                C14423an.m22657x(this.bVv, 14, C29736ac.adM("searchID"));
                C4990ab.m7417i("MicroMsg.FTS.FTSMainUI", "FTSWebReportLogic.kvReportGlobalTabClick reported type %d, searchId %s", Integer.valueOf(this.bVv), r0);
                FTSMainUI.this.aqX();
                Intent cVd = C46400aa.cVd();
                cVd.putExtra("ftsneedkeyboard", true);
                cVd.putExtra("ftsbizscene", 14);
                cVd.putExtra("ftsType", this.bVv);
                Map d = C46400aa.m87334d(14, true, this.bVv);
                d.put("sessionId", C3163e.mCM);
                d.put("subSessionId", C3163e.mCM);
                cVd.putExtra("sessionId", C3163e.mCM);
                cVd.putExtra("subSessionId", C3163e.mCM);
                cVd.putExtra("rawUrl", C46400aa.m87298E(d));
                cVd.putExtra("key_load_js_without_delay", true);
                Bundle bundle = null;
                if (VERSION.SDK_INT >= 21) {
                    bundle = ActivityOptions.makeSceneTransitionAnimation(FTSMainUI.this, new Pair[0]).toBundle();
                }
                if (this.bVv != 64) {
                    C25985d.m41455a(FTSMainUI.this, "webview", ".ui.tools.fts.FTSSearchTabWebViewUI", cVd, bundle);
                    AppMethodBeat.m2505o(61878);
                    return;
                }
                ((C22757j) C1720g.m3528K(C22757j.class)).mo38338aa(FTSMainUI.this, 14);
                AppMethodBeat.m2505o(61878);
                return;
            }
            C4990ab.m7412e("MicroMsg.FTS.FTSMainUI", "fts h5 template not avail");
            AppMethodBeat.m2505o(61878);
        }
    }

    /* renamed from: com.tencent.mm.plugin.fts.ui.FTSMainUI$7 */
    class C31857 implements Runnable {
        C31857() {
        }

        public final void run() {
            AppMethodBeat.m2504i(61872);
            if (FTSMainUI.this.lud != null) {
                FTSMainUI.this.lud.dismiss();
                FTSMainUI.this.lud = null;
            }
            AppMethodBeat.m2505o(61872);
        }
    }

    /* renamed from: com.tencent.mm.plugin.fts.ui.FTSMainUI$8 */
    class C31868 implements C43853o {
        C31868() {
        }

        /* renamed from: m */
        public final void mo7485m(String str, List<WidgetData> list) {
            AppMethodBeat.m2504i(61873);
            if (FTSMainUI.this.mJw) {
                FTSMainUI.this.mJk.setVisibility(0);
            }
            if (!FTSMainUI.this.query.equals(str)) {
                AppMethodBeat.m2505o(61873);
            } else if (list == null || list.isEmpty()) {
                AppMethodBeat.m2505o(61873);
            } else {
                if (FTSMainUI.this.mJw && FTSMainUI.this.mJs != null) {
                    FTSMainUI.this.mJs.mo47982c(list, C3163e.mCM, FTSMainUI.this.query);
                    FTSMainUI.this.mJs.show();
                    FTSMainUI.this.mJt.setVisibility(0);
                }
                FTSMainUI.m5457r(FTSMainUI.this);
                AppMethodBeat.m2505o(61873);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.fts.ui.FTSMainUI$12 */
    class C318712 implements C44246a {

        /* renamed from: com.tencent.mm.plugin.fts.ui.FTSMainUI$12$1 */
        class C31881 implements Runnable {
            C31881() {
            }

            public final void run() {
                AppMethodBeat.m2504i(61879);
                FTSMainUI.this.mJi = true;
                if (C5046bo.isNullOrNil(FTSMainUI.this.mIu.getSearchContent()) && FTSMainUI.this.mJh != null) {
                    FTSMainUI.this.mJh.show();
                }
                AppMethodBeat.m2505o(61879);
            }
        }

        /* renamed from: com.tencent.mm.plugin.fts.ui.FTSMainUI$12$2 */
        class C31892 implements Runnable {
            C31892() {
            }

            public final void run() {
                AppMethodBeat.m2504i(61880);
                FTSMainUI.this.mJi = false;
                if (FTSMainUI.this.mJh != null) {
                    FTSMainUI.this.mJh.bBy();
                }
                AppMethodBeat.m2505o(61880);
            }
        }

        C318712() {
        }

        /* renamed from: sD */
        public final void mo7486sD(int i) {
            AppMethodBeat.m2504i(61881);
            if (i == -3) {
                C4990ab.m7410d("MicroMsg.FTS.FTSMainUI", "KEYBOARD_STATE_SHOW");
                new C7306ak().postDelayed(new C31881(), 0);
                AppMethodBeat.m2505o(61881);
                return;
            }
            if (i == -2) {
                new C7306ak().postDelayed(new C31892(), 0);
                C4990ab.m7410d("MicroMsg.FTS.FTSMainUI", "KEYBOARD_STATE_HIDE");
            }
            AppMethodBeat.m2505o(61881);
        }
    }

    /* renamed from: com.tencent.mm.plugin.fts.ui.FTSMainUI$14 */
    class C319014 extends C4884c<C18427vl> {
        C319014() {
            AppMethodBeat.m2504i(61883);
            this.xxI = C18427vl.class.getName().hashCode();
            AppMethodBeat.m2505o(61883);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(61884);
            FTSMainUI.this.mJe.mo36197cu();
            AppMethodBeat.m2505o(61884);
            return false;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public FTSMainUI() {
        AppMethodBeat.m2504i(61897);
        AppMethodBeat.m2505o(61897);
    }

    /* renamed from: e */
    static /* synthetic */ void m5444e(FTSMainUI fTSMainUI) {
        AppMethodBeat.m2504i(61925);
        fTSMainUI.bBc();
        AppMethodBeat.m2505o(61925);
    }

    /* renamed from: j */
    static /* synthetic */ void m5449j(FTSMainUI fTSMainUI) {
        AppMethodBeat.m2504i(61928);
        super.finish();
        AppMethodBeat.m2505o(61928);
    }

    /* renamed from: k */
    static /* synthetic */ C39154b m5450k(FTSMainUI fTSMainUI) {
        AppMethodBeat.m2504i(61929);
        C39154b bBe = fTSMainUI.bBe();
        AppMethodBeat.m2505o(61929);
        return bBe;
    }

    /* renamed from: l */
    static /* synthetic */ void m5451l(FTSMainUI fTSMainUI) {
        AppMethodBeat.m2504i(61930);
        fTSMainUI.bBd();
        AppMethodBeat.m2505o(61930);
    }

    /* renamed from: r */
    static /* synthetic */ void m5457r(FTSMainUI fTSMainUI) {
        AppMethodBeat.m2504i(61934);
        fTSMainUI.bBf();
        AppMethodBeat.m2505o(61934);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(61898);
        super.onCreate(bundle);
        this.ieu = C4996ah.getResources().getDisplayMetrics().widthPixels;
        this.iev = C4996ah.getResources().getDisplayMetrics().heightPixels;
        if (VERSION.SDK_INT >= 21) {
            Transition inflateTransition = TransitionInflater.from(this).inflateTransition(17760258);
            TransitionInflater.from(this).inflateTransition(17760258);
            inflateTransition.excludeTarget(getWindow().getDecorView().findViewById(2131820940), true);
            inflateTransition.excludeTarget(16908335, true);
            getWindow().setEnterTransition(inflateTransition);
        }
        this.mJB = (KeyboardLinearLayout) findViewById(2131820987);
        this.mJB.setOnkbdStateListener(new C318712());
        this.mIu.setHint(getString(C25738R.string.f9220te));
        C3163e.mCM = C46400aa.m87299HP(3);
        C4990ab.m7411d("MicroMsg.FTS.FTSReportLogic", "reportFTSEnterClick: %d, %s", Integer.valueOf(10991), String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s", new Object[]{Integer.valueOf(this.mFa), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), C3163e.mCM, ""}));
        C7060h.pYm.mo8374X(10991, r0);
        this.mJe = (FTSMainUIEducationLayout) findViewById(2131824241);
        this.mJj = (LinearLayout) findViewById(2131824200);
        this.mJe.setOnCellClickListener(this.mJH);
        this.mJe.setOnHotwordClickListener(new C317716());
        this.mJe.setNeedHotWord(false);
        C1720g.m3528K(C11048d.class);
        C7305d.xDG.mo10151b(new C317018(), "FTSMainUI.GetLocation");
        if (((C12029n) C1720g.m3530M(C12029n.class)).getFTSImageLoader() == null) {
            finish();
            AppMethodBeat.m2505o(61898);
            return;
        }
        ((C12029n) C1720g.m3530M(C12029n.class)).getFTSImageLoader().bzY();
        C29736ac.m47143Ig(3);
        C4879a.xxA.mo10051b(this.mJI);
        C7305d.post(new C316815(), "init-widget-switch");
        AppMethodBeat.m2505o(61898);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        int i;
        boolean z = true;
        AppMethodBeat.m2504i(61899);
        boolean onCreateOptionsMenu = super.onCreateOptionsMenu(menu);
        if (C4988aa.don() || C4988aa.dor().equals("en")) {
            i = true;
        } else {
            i = 0;
        }
        if (i == 0) {
            AppMethodBeat.m2505o(61899);
            return onCreateOptionsMenu;
        }
        FTSVoiceInputLayoutImpl fTSVoiceInputLayoutImpl = (FTSVoiceInputLayoutImpl) findViewById(2131824243);
        TextView textView = (TextView) findViewById(2131824239);
        ImageView imageView = (ImageView) findViewById(2131824240);
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
            C4990ab.m7421w(str, str2, objArr);
            AppMethodBeat.m2505o(61899);
            return onCreateOptionsMenu;
        }
        this.mJh = new C45979c(this, fTSVoiceInputLayoutImpl, textView, imageView);
        this.mJh.mMG = new C316917();
        AppMethodBeat.m2505o(61899);
        return onCreateOptionsMenu;
    }

    public void onBackPressed() {
        AppMethodBeat.m2504i(61900);
        finish();
        AppMethodBeat.m2505o(61900);
    }

    public void onStop() {
        AppMethodBeat.m2504i(61901);
        aqX();
        super.onStop();
        if (this.mJs != null) {
            this.mJs.onPause();
        }
        AppMethodBeat.m2505o(61901);
    }

    /* Access modifiers changed, original: protected|final */
    public final void bAQ() {
        AppMethodBeat.m2504i(61902);
        switch (getIntent().getIntExtra("from_tab_index", -1)) {
            case 0:
                this.mFa = 1;
                AppMethodBeat.m2505o(61902);
                return;
            case 1:
                this.mFa = 2;
                AppMethodBeat.m2505o(61902);
                return;
            case 2:
                this.mFa = 3;
                AppMethodBeat.m2505o(61902);
                return;
            case 3:
                this.mFa = 4;
                AppMethodBeat.m2505o(61902);
                return;
            default:
                this.mFa = 0;
                AppMethodBeat.m2505o(61902);
                return;
        }
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: a */
    public final C12067d mo7445a(C28149e c28149e) {
        AppMethodBeat.m2504i(61903);
        this.mJC = new C34231j(c28149e, this.mFa, this.mJD);
        this.mJC.mo54795wd(2);
        C34231j c34231j = this.mJC;
        AppMethodBeat.m2505o(61903);
        return c34231j;
    }

    public final int getLayoutId() {
        return 2130969629;
    }

    /* renamed from: a */
    public final void mo7441a(C3154a c3154a) {
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(61904);
        C7305d.xDG.remove("FTSMainUI.GetLocation");
        C26443d.agz().mo44208c(this);
        if (((C12029n) C1720g.m3530M(C12029n.class)).getFTSImageLoader() != null) {
            ((C12029n) C1720g.m3530M(C12029n.class)).getFTSImageLoader().bzZ();
        }
        C4879a.xxA.mo10053d(this.mJI);
        if (this.mJh != null) {
            C45979c c45979c = this.mJh;
            if (c45979c.mMI != null) {
                c45979c.mMI.amA();
                FTSVoiceInputLayoutImpl fTSVoiceInputLayoutImpl = c45979c.mMI;
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
        C34234k.m56144a(bBe());
        super.onDestroy();
        AppMethodBeat.m2505o(61904);
    }

    public void onResume() {
        AppMethodBeat.m2504i(61905);
        super.onResume();
        runOnUiThread(new C317320());
        C26245tv c26245tv = new C26245tv();
        c26245tv.cPX.cvc = 0;
        C4879a.xxA.mo10055m(c26245tv);
        C45287c.aNX();
        if (this.mJk != null) {
            this.mJk.setEnabled(true);
        }
        if (!C5046bo.isNullOrNil(this.mJy)) {
            this.query = this.mJy;
            this.mJy = null;
        }
        C46400aa.cVe();
        if (this.mJs != null) {
            this.mJs.onResume();
        }
        AppMethodBeat.m2505o(61905);
    }

    public void finish() {
        AppMethodBeat.m2504i(61906);
        int i = 100;
        if (!this.mController.hideVKB()) {
            i = 0;
        }
        C5004al.m7442n(new C317421(), (long) i);
        AppMethodBeat.m2505o(61906);
    }

    /* renamed from: a */
    public final boolean mo5861a(boolean z, float f, float f2, int i, double d, double d2, double d3) {
        AppMethodBeat.m2504i(61907);
        C4990ab.m7417i("MicroMsg.FTS.FTSMainUI", "onGetLocation %b %f|%f", Boolean.valueOf(z), Float.valueOf(f), Float.valueOf(f2));
        C26443d.agz().mo44208c(this);
        AppMethodBeat.m2505o(61907);
        return false;
    }

    private void bBb() {
        AppMethodBeat.m2504i(61908);
        this.mJe.setVisibility(0);
        this.mJe.mo36197cu();
        AppMethodBeat.m2505o(61908);
    }

    private void bBc() {
        AppMethodBeat.m2504i(61909);
        this.mJe.setVisibility(8);
        AppMethodBeat.m2505o(61909);
    }

    /* Access modifiers changed, original: protected|final */
    public final void bAV() {
        AppMethodBeat.m2504i(61910);
        super.bAV();
        bBb();
        this.mJj.setVisibility(8);
        if (this.mJi && this.mJh != null) {
            this.mJh.show();
        }
        AppMethodBeat.m2505o(61910);
    }

    /* Access modifiers changed, original: protected|final */
    public final void bAU() {
        AppMethodBeat.m2504i(61911);
        super.bAU();
        bBc();
        this.mJj.setVisibility(8);
        if (!(this.mJh == null || this.mJh.mMH)) {
            this.mJh.bBy();
        }
        AppMethodBeat.m2505o(61911);
    }

    /* Access modifiers changed, original: protected|final */
    public final void bAT() {
        AppMethodBeat.m2504i(61912);
        super.bAT();
        bBc();
        this.mJj.setVisibility(8);
        this.mIn.setVisibility(0);
        this.mIp.setVisibility(8);
        if (!(this.mJh == null || this.mJh.mMH)) {
            this.mJh.bBy();
        }
        AppMethodBeat.m2505o(61912);
    }

    /* Access modifiers changed, original: protected|final */
    public final void bAS() {
        AppMethodBeat.m2504i(61913);
        super.bAS();
        bBc();
        this.mJj.setVisibility(8);
        if (!(this.mJh == null || this.mJh.mMH)) {
            this.mJh.bBy();
        }
        AppMethodBeat.m2505o(61913);
    }

    public final View aWz() {
        AppMethodBeat.m2504i(61914);
        if (this.mJf == null) {
            this.mJf = (LinearLayout) getLayoutInflater().inflate(2130969626, null);
            this.mJn = (TextView) this.mJf.findViewById(2131824235);
            this.mJo = (TextView) this.mJf.findViewById(2131824236);
            try {
                C4990ab.m7417i("MicroMsg.FTS.FTSMainUI", "set searchNetworkTips %s", C29736ac.adL("webSearchBar").optString("wording"));
                this.mJo.setText(r0);
            } catch (Exception e) {
            }
            this.mJl = this.mJf.findViewById(2131824232);
            this.mJk = this.mJf.findViewById(2131824231);
            this.mJf.findViewById(2131824234).setOnClickListener(new C31752());
            this.mJt = this.mJf.findViewById(2131824233);
            this.mJs = ((C29740h) C1720g.m3528K(C29740h.class)).mo47980a((LinearLayout) this.mJt, C1338a.m2859ao(C4996ah.getContext(), C4996ah.getResources().getDisplayMetrics().widthPixels) - 26, this, this.mJG);
            this.mJm = new FTSLocalPageRelevantView(this);
            this.mJm.setOnRelevantClickListener(new C31803());
            int indexOfChild = this.mJf.indexOfChild(this.mJk);
            if (indexOfChild >= 0 && indexOfChild < this.mJf.getChildCount()) {
                this.mJf.addView(this.mJm, indexOfChild + 1);
            }
            this.mJr = (TextView) this.mJf.findViewById(2131824230);
            this.mJq = this.mJf.findViewById(2131824228);
            this.mJp = this.mJf.findViewById(2131824229);
            this.mJp.setOnClickListener(new C31764());
            this.mJg = (LinearLayout) this.mJf.findViewById(2131824237);
        }
        LinearLayout linearLayout = this.mJf;
        AppMethodBeat.m2505o(61914);
        return linearLayout;
    }

    private void bBd() {
        AppMethodBeat.m2504i(61915);
        this.mJC.mIO = true;
        String str = this.query;
        if (str == null || C5046bo.isNullOrNil(str.trim())) {
            AppMethodBeat.m2505o(61915);
        } else if (System.currentTimeMillis() - this.ijU <= 1000) {
            AppMethodBeat.m2505o(61915);
        } else {
            this.ijU = System.currentTimeMillis();
            String str2 = C3163e.mCM;
            HashMap hashMap = new HashMap();
            hashMap.put("sceneActionType", "15");
            hashMap.put("clickType", "15");
            ((C22757j) C1720g.m3528K(C22757j.class)).mo38334a(this.mController.ylL, 3, str, str2, hashMap);
            C14423an.m22639Ik(3);
            if (!C5046bo.isNullOrNil(this.query)) {
                C14423an.m22656l(this.query, 2, 2, 3);
            }
            this.mJk.setEnabled(false);
            C34234k.m56145a(this.query, this.mJC.getCount(), this.mFa, bBe(), 18);
            AppMethodBeat.m2505o(61915);
        }
    }

    private C39154b bBe() {
        AppMethodBeat.m2504i(61916);
        C39154b c39154b = this.mJC.mIS;
        if (this.mJp == null || this.mJp.getVisibility() != 0) {
            c39154b.mLE = this.mJC.getBlockCount() + 1;
        } else {
            c39154b.mLE = this.mJC.getBlockCount() + 2;
        }
        AppMethodBeat.m2505o(61916);
        return c39154b;
    }

    /* renamed from: vN */
    public final boolean mo7459vN(String str) {
        AppMethodBeat.m2504i(61917);
        super.mo7459vN(str);
        bBf();
        AppMethodBeat.m2505o(61917);
        return false;
    }

    private void bBf() {
        AppMethodBeat.m2504i(61918);
        if (this.mJz && !TextUtils.isEmpty(this.query)) {
            C46884cv c46884cv;
            if (this.mJC.getBlockCount() == 0 && this.mJt.getVisibility() == 8 && TextUtils.isEmpty(this.mJr.getText())) {
                bBd();
                c46884cv = new C46884cv();
                c46884cv.dim = 1;
                c46884cv.cTl = 1;
                c46884cv.mo76077hL(this.query).ajK();
                AppMethodBeat.m2505o(61918);
                return;
            }
            c46884cv = new C46884cv();
            c46884cv.dim = 1;
            c46884cv.cTl = 2;
            c46884cv.mo76077hL(this.query).ajK();
        }
        AppMethodBeat.m2505o(61918);
    }

    /* Access modifiers changed, original: protected|final */
    public final void bAW() {
        AppMethodBeat.m2504i(61919);
        if (this.mJg != null) {
            this.mJg.setVisibility(0);
        }
        AppMethodBeat.m2505o(61919);
    }

    /* Access modifiers changed, original: protected|final */
    public final void bAX() {
        AppMethodBeat.m2504i(61920);
        if (this.mJg != null) {
            this.mJg.setVisibility(8);
        }
        AppMethodBeat.m2505o(61920);
    }

    /* renamed from: U */
    public final void mo7444U(int i, boolean z) {
        AppMethodBeat.m2504i(61921);
        super.mo7444U(i, z);
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
            boolean Nd = C3161d.m5406Nd(this.query);
            boolean Ne = C3161d.m5407Ne(this.query);
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
                C4990ab.m7417i("MicroMsg.FTS.FTSMainUI", "wait for search widget result , timeout %d", Long.valueOf(this.mJv));
                C5004al.m7442n(this.mJx, this.mJv);
            } else {
                this.mJk.setVisibility(0);
            }
            if (this.query != null && this.query.length() > 0) {
                ((C46402e) C1720g.m3528K(C46402e.class)).mo63535a(this.query, this.mJF, this);
                ((C22758p) C1720g.m3528K(C22758p.class)).mo38341a(this.query, C3163e.mCM, this.mJE);
            }
            AppMethodBeat.m2505o(61921);
            return;
        }
        C5004al.m7439af(this.mJx);
        this.mJk.setVisibility(8);
        this.mJp.setVisibility(8);
        this.mJw = false;
        AppMethodBeat.m2505o(61921);
    }

    /* renamed from: vO */
    public final void mo7460vO(String str) {
        AppMethodBeat.m2504i(61922);
        if (this.mJh == null || !this.mJh.mMH) {
            super.mo7460vO(str);
        }
        this.mJz = false;
        AppMethodBeat.m2505o(61922);
    }

    /* Access modifiers changed, original: protected|final */
    public final void bAM() {
        AppMethodBeat.m2504i(61923);
        super.bAM();
        this.mJn.setText(C44089j.m79294b((Context) this, C34204f.m56087a(getString(C25738R.string.c28), "", C39127d.m66573b(this.query, this.query)).mDR, C1338a.m2856al(this, C25738R.dimen.f9980m5)));
        CharSequence charSequence = null;
        if (C3161d.m5406Nd(this.query)) {
            charSequence = C34204f.m56087a(getString(C25738R.string.c1f), "", C39127d.m66573b(this.query, this.query)).mDR;
        } else if (C3161d.m5407Ne(this.query)) {
            charSequence = C34204f.m56087a(getString(C25738R.string.c1g), "", C39127d.m66573b(this.query, this.query)).mDR;
        }
        this.mJr.setText(C44089j.m79294b((Context) this, charSequence, C1338a.m2856al(this, C25738R.dimen.f9980m5)));
        AppMethodBeat.m2505o(61923);
    }

    public void onClickWxApp(View view) {
        AppMethodBeat.m2504i(61924);
        if (view.getTag().equals("more-click")) {
            ((C19734i) C1720g.m3528K(C19734i.class)).mo34968a((Context) this, C3163e.mCM, C19735a.CLICK);
            AppMethodBeat.m2505o(61924);
        } else if (view.getTag().equals("more-swipe")) {
            ((C19734i) C1720g.m3528K(C19734i.class)).mo34968a((Context) this, C3163e.mCM, C19735a.SWIPE);
            AppMethodBeat.m2505o(61924);
        } else {
            ((C19734i) C1720g.m3528K(C19734i.class)).mo34967a((Context) this, (C10734c) view.getTag(), C3163e.mCM);
            AppMethodBeat.m2505o(61924);
        }
    }

    /* renamed from: Nw */
    static /* synthetic */ void m5431Nw(String str) {
        AppMethodBeat.m2504i(61927);
        C5659a re = new C5659a(C4996ah.getContext()).asL(str).mo11526re(true);
        re.zQM = true;
        re.mo11513a(null, null).show();
        AppMethodBeat.m2505o(61927);
    }

    /* renamed from: c */
    static /* synthetic */ void m5442c(FTSMainUI fTSMainUI, final String str) {
        int i;
        AppMethodBeat.m2504i(61932);
        C39154b c39154b = fTSMainUI.mJC.mIS;
        c39154b.mLE = fTSMainUI.mJC.getBlockCount() + 1;
        int count = fTSMainUI.mJC.getCount();
        int i2 = fTSMainUI.mFa;
        if (C3161d.m5406Nd(str)) {
            i = 8;
        } else {
            i = 9;
        }
        int i3 = count + 1;
        long currentTimeMillis = System.currentTimeMillis() - c39154b.mLr;
        if (currentTimeMillis < 0 || c39154b.mLr == 0) {
            currentTimeMillis = 0;
        }
        Object obj = !c39154b.mLI.equals(str) ? 1 : null;
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
        objArr[13] = Integer.valueOf(c39154b.mLu);
        objArr[14] = Integer.valueOf(c39154b.mLv);
        objArr[15] = Integer.valueOf(c39154b.mLw);
        objArr[16] = Integer.valueOf(c39154b.mLx);
        objArr[17] = Integer.valueOf(c39154b.mLy);
        objArr[18] = Integer.valueOf(c39154b.mLz);
        objArr[19] = Integer.valueOf(c39154b.mLA);
        objArr[20] = Integer.valueOf(c39154b.mLC);
        objArr[21] = Integer.valueOf(c39154b.mLD);
        objArr[22] = C3163e.mCM;
        objArr[23] = str;
        objArr[24] = Integer.valueOf(c39154b.mLB);
        objArr[25] = Integer.valueOf(c39154b.mLE);
        objArr[26] = Integer.valueOf(c39154b.bBj());
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
        C4990ab.m7411d("MicroMsg.FTS.FTSReportLogic", "10991 reportSearchWeChatId click: %d, %s", Integer.valueOf(10991), String.format(str2, objArr));
        C7060h.pYm.mo8374X(10991, r0);
        C34231j c34231j = fTSMainUI.mJC;
        c34231j.mIO = true;
        if (!C5046bo.isNullOrNil(c34231j.query)) {
            C14423an.m22656l(c34231j.query, c34231j.mHU, 1, 3);
        }
        fTSMainUI.mJC.mIO = true;
        if (!fTSMainUI.mJC.mIF) {
            fTSMainUI.mJC.mIF = true;
            C34234k.m56146a(str, true, fTSMainUI.mJC.getCount(), 0, c39154b);
        }
        if (str == null || str.length() == 0 || str.trim().length() == 0) {
            AppMethodBeat.m2505o(61932);
            return;
        }
        fTSMainUI.mIa = Character.isDigit(str.charAt(0)) ? 15 : 3;
        final C1202f c31835 = new C1202f() {
            public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
                AppMethodBeat.m2504i(61870);
                C1720g.m3540Rg().mo14546b(106, (C1202f) this);
                if (i == 4 && i2 == -4) {
                    FTSMainUI.m5454o(FTSMainUI.this);
                    C30379h.m48433a(FTSMainUI.this, (int) C25738R.string.dzx, 0, true, null);
                    AppMethodBeat.m2505o(61870);
                    return;
                }
                FTSMainUI.m5454o(FTSMainUI.this);
                if (i == 0 && i2 == 0) {
                    buv bOj = ((C12518f) c1207m).bOj();
                    Intent intent;
                    if (bOj.wod <= 0) {
                        if (C5046bo.nullAsNil(C1946aa.m4148a(bOj.wcB)).length() > 0) {
                            if (2 == bOj.wWh) {
                                FTSMainUI.this.mIa = 15;
                            } else if (1 == bOj.wWh) {
                                FTSMainUI.this.mIa = 1;
                            }
                            intent = new Intent();
                            ((C32250j) C1720g.m3528K(C32250j.class)).mo20992a(intent, bOj, FTSMainUI.this.mIa);
                            if (FTSMainUI.this.mIa == 15) {
                                intent.putExtra("Contact_Search_Mobile", str.trim());
                            }
                            intent.putExtra("Contact_Scene", FTSMainUI.this.mIa);
                            intent.putExtra("add_more_friend_search_scene", 2);
                            C25985d.m41467b(FTSMainUI.this, Scopes.PROFILE, ".ui.ContactInfoUI", intent);
                        }
                        AppMethodBeat.m2505o(61870);
                        return;
                    } else if (bOj.woe.isEmpty()) {
                        C30379h.m48433a(FTSMainUI.this, (int) C25738R.string.dzx, 0, true, null);
                        AppMethodBeat.m2505o(61870);
                        return;
                    } else {
                        intent = new Intent();
                        ((C32250j) C1720g.m3528K(C32250j.class)).mo20991a(intent, (but) bOj.woe.getFirst(), FTSMainUI.this.mIa);
                        C25985d.m41467b(FTSMainUI.this, Scopes.PROFILE, ".ui.ContactInfoUI", intent);
                        AppMethodBeat.m2505o(61870);
                        return;
                    }
                }
                switch (i2) {
                    case DownloadResult.CODE_CONNECTION_EXCEPTION /*-24*/:
                        C42124a jY = C42124a.m74268jY(str);
                        if (jY != null) {
                            C30379h.m48448a(FTSMainUI.this, jY.desc, jY.Title, true, null);
                            break;
                        }
                        break;
                    case -4:
                        Toast.makeText(FTSMainUI.this, FTSMainUI.this.getString(C25738R.string.dzs), 0).show();
                        break;
                }
                C4990ab.m7420w("MicroMsg.FTS.FTSMainUI", String.format("Search contact failed: %d, %d.", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}));
                AppMethodBeat.m2505o(61870);
            }
        };
        C1720g.m3540Rg().mo14539a(106, c31835);
        final C1207m c12518f = new C12518f(str, 3);
        C1720g.m3540Rg().mo14541a(c12518f, 0);
        fTSMainUI.getString(C25738R.string.f9238tz);
        fTSMainUI.lud = C30379h.m48458b((Context) fTSMainUI, fTSMainUI.getString(C25738R.string.dzr), true, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.m2504i(61871);
                C1720g.m3540Rg().mo14547c(c12518f);
                C1720g.m3540Rg().mo14546b(106, c31835);
                FTSMainUI.this.lud = null;
                AppMethodBeat.m2505o(61871);
            }
        });
        AppMethodBeat.m2505o(61932);
    }

    /* renamed from: o */
    static /* synthetic */ void m5454o(FTSMainUI fTSMainUI) {
        AppMethodBeat.m2504i(61933);
        C5004al.m7441d(new C31857());
        AppMethodBeat.m2505o(61933);
    }
}
