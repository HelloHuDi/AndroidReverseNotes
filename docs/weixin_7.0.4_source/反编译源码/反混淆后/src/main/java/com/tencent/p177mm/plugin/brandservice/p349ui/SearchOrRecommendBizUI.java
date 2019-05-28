package com.tencent.p177mm.plugin.brandservice.p349ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import android.os.Looper;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p184aj.C41747z;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.tools.SearchViewNotRealTimeHelper;
import com.tencent.p177mm.p612ui.tools.SearchViewNotRealTimeHelper.C5576a;
import com.tencent.p177mm.plugin.brandservice.p349ui.BizSearchResultItemContainer.C11191b;
import com.tencent.p177mm.plugin.brandservice.p926b.C20025f;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.brandservice.ui.SearchOrRecommendBizUI */
public class SearchOrRecommendBizUI extends MMActivity implements C11191b {
    private int emC = 0;
    private BizSearchResultItemContainer jKU;
    private ProgressDialog jMB = null;
    private int jMC = 0;
    private SearchViewNotRealTimeHelper jMD;

    /* renamed from: com.tencent.mm.plugin.brandservice.ui.SearchOrRecommendBizUI$1 */
    class C275131 implements C1202f {
        C275131() {
        }

        public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
            AppMethodBeat.m2504i(14041);
            if (c1207m == null) {
                C4990ab.m7412e("MicroMsg.BrandService.SearchOrRecommendBizUI", "NetScene is null.");
                AppMethodBeat.m2505o(14041);
            } else if (c1207m.getType() != 456) {
                C4990ab.m7412e("MicroMsg.BrandService.SearchOrRecommendBizUI", "The NetScene is not a RecommendGroupNetScene.");
                AppMethodBeat.m2505o(14041);
            } else {
                C1720g.m3540Rg().mo14546b(456, (C1202f) this);
                C4990ab.m7417i("MicroMsg.BrandService.SearchOrRecommendBizUI", "errType(%d) , errCode(%d) , errMsg(%s)", Integer.valueOf(i), Integer.valueOf(i2), str);
                if (i == 0 && i2 == 0) {
                    LinkedList aVW = C20025f.aVW();
                    final C20045f c20045f = SearchOrRecommendBizUI.this.jKU == null ? null : (C20045f) SearchOrRecommendBizUI.this.jKU.getAdapter();
                    if (!(c20045f == null || aVW == null || aVW.size() <= 0)) {
                        int i3;
                        if (c20045f.getCount() == 0) {
                            i3 = 1;
                        } else {
                            i3 = 0;
                        }
                        c20045f.jMx = aVW;
                        if (i3 != 0) {
                            C5004al.m7441d(new Runnable() {
                                public final void run() {
                                    AppMethodBeat.m2504i(14040);
                                    C4990ab.m7416i("MicroMsg.BrandService.SearchOrRecommendBizUI", "Has got recommend groups, so notifyDataSetChanged.");
                                    c20045f.notifyDataSetChanged();
                                    AppMethodBeat.m2505o(14040);
                                }
                            });
                        }
                    }
                }
                AppMethodBeat.m2505o(14041);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.brandservice.ui.SearchOrRecommendBizUI$3 */
    class C427993 implements OnMenuItemClickListener {
        C427993() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(14043);
            SearchOrRecommendBizUI.this.aqX();
            SearchOrRecommendBizUI.this.finish();
            AppMethodBeat.m2505o(14043);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.brandservice.ui.SearchOrRecommendBizUI$4 */
    class C428004 implements OnTouchListener {
        C428004() {
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            AppMethodBeat.m2504i(14044);
            SearchOrRecommendBizUI.this.jMD.clearFocus();
            SearchOrRecommendBizUI.this.aqX();
            AppMethodBeat.m2505o(14044);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.brandservice.ui.SearchOrRecommendBizUI$5 */
    class C428015 implements C5576a {
        C428015() {
        }

        /* renamed from: vN */
        public final boolean mo11299vN(String str) {
            AppMethodBeat.m2504i(14045);
            mo11297FD(str);
            AppMethodBeat.m2505o(14045);
            return true;
        }

        /* renamed from: FD */
        public final void mo11297FD(String str) {
            AppMethodBeat.m2504i(14046);
            if (C5046bo.isNullOrNil(str)) {
                C30379h.m48465bQ(SearchOrRecommendBizUI.this.mController.ylL, SearchOrRecommendBizUI.this.getString(C25738R.string.b2g));
                AppMethodBeat.m2505o(14046);
                return;
            }
            SearchOrRecommendBizUI.this.aqX();
            SearchOrRecommendBizUI.this.jKU.mo61525bH(str, 0);
            AppMethodBeat.m2505o(14046);
        }

        public final void aWl() {
            AppMethodBeat.m2504i(14047);
            SearchOrRecommendBizUI.this.showVKB();
            AppMethodBeat.m2505o(14047);
        }
    }

    /* renamed from: com.tencent.mm.plugin.brandservice.ui.SearchOrRecommendBizUI$6 */
    class C428026 implements OnCancelListener {
        C428026() {
        }

        public final void onCancel(DialogInterface dialogInterface) {
            AppMethodBeat.m2504i(14048);
            BizSearchResultItemContainer a = SearchOrRecommendBizUI.this.jKU;
            C1720g.m3540Rg().mo14547c(a.jLr);
            a.jLp.jLC = false;
            AppMethodBeat.m2505o(14048);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public final int getLayoutId() {
        return 2130969238;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(14049);
        super.onCreate(bundle);
        this.jMC = getIntent().getIntExtra("intent_extra_entry_flag", 0);
        this.emC = getIntent().getIntExtra("fromScene", 0);
        initView();
        if (C20025f.aVV()) {
            C1720g.m3540Rg().mo14539a(456, new C275131());
            C1720g.m3540Rg().mo14541a(new C20025f(), 0);
        }
        final String stringExtra = getIntent().getStringExtra("Search_Str");
        if (!C5046bo.isNullOrNil(stringExtra)) {
            new C7306ak(Looper.getMainLooper()).post(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(14042);
                    SearchOrRecommendBizUI.this.jMD.setSearchContent(stringExtra);
                    SearchOrRecommendBizUI.this.jMD.zHm.performClick();
                    AppMethodBeat.m2505o(14042);
                }
            });
        }
        AppMethodBeat.m2505o(14049);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(14050);
        super.onDestroy();
        C41747z.afb().aeL();
        AppMethodBeat.m2505o(14050);
    }

    public final void initView() {
        AppMethodBeat.m2504i(14051);
        setMMTitle((int) C25738R.string.b2j);
        setBackBtn(new C427993());
        aWk();
        this.jKU = (BizSearchResultItemContainer) findViewById(2131821800);
        this.jKU.setOnTouchListener(new C428004());
        C20045f c20045f = new C20045f(this);
        c20045f.jMx = C20025f.aVW();
        this.jKU.setAdapter(c20045f);
        this.jKU.setBusinessTypes(1);
        this.jKU.setDisplayArgs$25decb5(false);
        this.jKU.setMode(1);
        this.jKU.setScene(this.emC);
        this.jKU.setIOnSearchStateChangedListener(this);
        AppMethodBeat.m2505o(14051);
    }

    private void aWk() {
        AppMethodBeat.m2504i(14052);
        this.jMD = (SearchViewNotRealTimeHelper) findViewById(2131823137);
        this.jMD.setSearchColor(getResources().getColor(C25738R.color.f12212w4));
        this.jMD.setSearchHint(getString(C25738R.string.b2j));
        this.jMD.setSearchHintColor(getResources().getColor(C25738R.color.f12091rz));
        this.jMD.setSearchIcon(0);
        this.jMD.setShowBackIcon(false);
        this.jMD.setCallBack(new C428015());
        AppMethodBeat.m2505o(14052);
    }

    public final void aWd() {
        AppMethodBeat.m2504i(14054);
        if (this.jMB != null) {
            this.jMB.dismiss();
            this.jMB = null;
        }
        AppMethodBeat.m2505o(14054);
    }

    public final void aWc() {
        AppMethodBeat.m2504i(14053);
        Context context = this.mController.ylL;
        getString(C25738R.string.f9238tz);
        this.jMB = C30379h.m48458b(context, getString(C25738R.string.b2h), true, new C428026());
        AppMethodBeat.m2505o(14053);
    }
}
