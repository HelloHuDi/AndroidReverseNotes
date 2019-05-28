package com.tencent.mm.plugin.brandservice.ui;

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
import com.tencent.mm.R;
import com.tencent.mm.ai.m;
import com.tencent.mm.aj.z;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.brandservice.b.f;
import com.tencent.mm.plugin.brandservice.ui.BizSearchResultItemContainer.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.tools.SearchViewNotRealTimeHelper;
import com.tencent.mm.ui.tools.SearchViewNotRealTimeHelper.a;
import java.util.LinkedList;

public class SearchOrRecommendBizUI extends MMActivity implements b {
    private int emC = 0;
    private BizSearchResultItemContainer jKU;
    private ProgressDialog jMB = null;
    private int jMC = 0;
    private SearchViewNotRealTimeHelper jMD;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public final int getLayoutId() {
        return R.layout.r5;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(14049);
        super.onCreate(bundle);
        this.jMC = getIntent().getIntExtra("intent_extra_entry_flag", 0);
        this.emC = getIntent().getIntExtra("fromScene", 0);
        initView();
        if (f.aVV()) {
            g.Rg().a(456, new com.tencent.mm.ai.f() {
                public final void onSceneEnd(int i, int i2, String str, m mVar) {
                    AppMethodBeat.i(14041);
                    if (mVar == null) {
                        ab.e("MicroMsg.BrandService.SearchOrRecommendBizUI", "NetScene is null.");
                        AppMethodBeat.o(14041);
                    } else if (mVar.getType() != 456) {
                        ab.e("MicroMsg.BrandService.SearchOrRecommendBizUI", "The NetScene is not a RecommendGroupNetScene.");
                        AppMethodBeat.o(14041);
                    } else {
                        g.Rg().b(456, (com.tencent.mm.ai.f) this);
                        ab.i("MicroMsg.BrandService.SearchOrRecommendBizUI", "errType(%d) , errCode(%d) , errMsg(%s)", Integer.valueOf(i), Integer.valueOf(i2), str);
                        if (i == 0 && i2 == 0) {
                            LinkedList aVW = f.aVW();
                            final f fVar = SearchOrRecommendBizUI.this.jKU == null ? null : (f) SearchOrRecommendBizUI.this.jKU.getAdapter();
                            if (!(fVar == null || aVW == null || aVW.size() <= 0)) {
                                int i3;
                                if (fVar.getCount() == 0) {
                                    i3 = 1;
                                } else {
                                    i3 = 0;
                                }
                                fVar.jMx = aVW;
                                if (i3 != 0) {
                                    al.d(new Runnable() {
                                        public final void run() {
                                            AppMethodBeat.i(14040);
                                            ab.i("MicroMsg.BrandService.SearchOrRecommendBizUI", "Has got recommend groups, so notifyDataSetChanged.");
                                            fVar.notifyDataSetChanged();
                                            AppMethodBeat.o(14040);
                                        }
                                    });
                                }
                            }
                        }
                        AppMethodBeat.o(14041);
                    }
                }
            });
            g.Rg().a(new f(), 0);
        }
        final String stringExtra = getIntent().getStringExtra("Search_Str");
        if (!bo.isNullOrNil(stringExtra)) {
            new ak(Looper.getMainLooper()).post(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(14042);
                    SearchOrRecommendBizUI.this.jMD.setSearchContent(stringExtra);
                    SearchOrRecommendBizUI.this.jMD.zHm.performClick();
                    AppMethodBeat.o(14042);
                }
            });
        }
        AppMethodBeat.o(14049);
    }

    public void onDestroy() {
        AppMethodBeat.i(14050);
        super.onDestroy();
        z.afb().aeL();
        AppMethodBeat.o(14050);
    }

    public final void initView() {
        AppMethodBeat.i(14051);
        setMMTitle((int) R.string.b2j);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(14043);
                SearchOrRecommendBizUI.this.aqX();
                SearchOrRecommendBizUI.this.finish();
                AppMethodBeat.o(14043);
                return true;
            }
        });
        aWk();
        this.jKU = (BizSearchResultItemContainer) findViewById(R.id.a6x);
        this.jKU.setOnTouchListener(new OnTouchListener() {
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(14044);
                SearchOrRecommendBizUI.this.jMD.clearFocus();
                SearchOrRecommendBizUI.this.aqX();
                AppMethodBeat.o(14044);
                return false;
            }
        });
        f fVar = new f(this);
        fVar.jMx = f.aVW();
        this.jKU.setAdapter(fVar);
        this.jKU.setBusinessTypes(1);
        this.jKU.setDisplayArgs$25decb5(false);
        this.jKU.setMode(1);
        this.jKU.setScene(this.emC);
        this.jKU.setIOnSearchStateChangedListener(this);
        AppMethodBeat.o(14051);
    }

    private void aWk() {
        AppMethodBeat.i(14052);
        this.jMD = (SearchViewNotRealTimeHelper) findViewById(R.id.b63);
        this.jMD.setSearchColor(getResources().getColor(R.color.w4));
        this.jMD.setSearchHint(getString(R.string.b2j));
        this.jMD.setSearchHintColor(getResources().getColor(R.color.rz));
        this.jMD.setSearchIcon(0);
        this.jMD.setShowBackIcon(false);
        this.jMD.setCallBack(new a() {
            public final boolean vN(String str) {
                AppMethodBeat.i(14045);
                FD(str);
                AppMethodBeat.o(14045);
                return true;
            }

            public final void FD(String str) {
                AppMethodBeat.i(14046);
                if (bo.isNullOrNil(str)) {
                    h.bQ(SearchOrRecommendBizUI.this.mController.ylL, SearchOrRecommendBizUI.this.getString(R.string.b2g));
                    AppMethodBeat.o(14046);
                    return;
                }
                SearchOrRecommendBizUI.this.aqX();
                SearchOrRecommendBizUI.this.jKU.bH(str, 0);
                AppMethodBeat.o(14046);
            }

            public final void aWl() {
                AppMethodBeat.i(14047);
                SearchOrRecommendBizUI.this.showVKB();
                AppMethodBeat.o(14047);
            }
        });
        AppMethodBeat.o(14052);
    }

    public final void aWd() {
        AppMethodBeat.i(14054);
        if (this.jMB != null) {
            this.jMB.dismiss();
            this.jMB = null;
        }
        AppMethodBeat.o(14054);
    }

    public final void aWc() {
        AppMethodBeat.i(14053);
        Context context = this.mController.ylL;
        getString(R.string.tz);
        this.jMB = h.b(context, getString(R.string.b2h), true, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(14048);
                BizSearchResultItemContainer a = SearchOrRecommendBizUI.this.jKU;
                g.Rg().c(a.jLr);
                a.jLp.jLC = false;
                AppMethodBeat.o(14048);
            }
        });
        AppMethodBeat.o(14053);
    }
}
