package com.tencent.mm.plugin.exdevice.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.Toast;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.m;
import com.tencent.mm.g.a.qb;
import com.tencent.mm.g.a.sd;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.r;
import com.tencent.mm.model.t;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.exdevice.a.b;
import com.tencent.mm.plugin.exdevice.f.a.j;
import com.tencent.mm.plugin.exdevice.f.a.j.a;
import com.tencent.mm.plugin.exdevice.f.b.a.c;
import com.tencent.mm.plugin.exdevice.f.b.e;
import com.tencent.mm.plugin.exdevice.f.b.f;
import com.tencent.mm.plugin.exdevice.model.ac;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.plugin.messenger.a.g;
import com.tencent.mm.plugin.sport.a.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMPullDownView;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.p;
import com.tencent.ttpic.FilterEnum4Shaka;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import junit.framework.Assert;

public class ExdeviceRankInfoUI extends MMActivity implements a, e, f, d {
    private static int lCl = 128;
    private boolean UP;
    private String hZn;
    private String igi;
    private ImageView lBT;
    private View lBZ;
    private Map<String, String> lCE = new HashMap();
    private String lCb;
    private String lCc;
    private b<j> lDA = new b<j>() {
        public final /* synthetic */ void a(int i, int i2, String str, m mVar) {
            AppMethodBeat.i(20150);
            j jVar = (j) mVar;
            ab.i("MicroMsg.Sport.ExdeviceRankInfoUI", "onNetSceneEndCallback, errType(%s), errCode(%s), errMsg(%s).", Integer.valueOf(i), Integer.valueOf(i2), str);
            if (ExdeviceRankInfoUI.this.isFinishing() || ExdeviceRankInfoUI.this.UP) {
                ab.i("MicroMsg.Sport.ExdeviceRankInfoUI", "ExdeviceRankInfoUI has been destroyed.");
                AppMethodBeat.o(20150);
                return;
            }
            ExdeviceRankInfoUI.this.runOnUiThread(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(20146);
                    if (ExdeviceRankInfoUI.this.lzK != null && ExdeviceRankInfoUI.this.lzK.isShowing()) {
                        ExdeviceRankInfoUI.this.lzK.dismiss();
                        ExdeviceRankInfoUI.this.lzK = null;
                        ab.d("MicroMsg.Sport.ExdeviceRankInfoUI", "dismiss tips dialog.");
                    }
                    AppMethodBeat.o(20146);
                }
            });
            if (i == 0 && i2 == 0) {
                ExdeviceRankInfoUI.this.lCb = jVar.lvz;
                ExdeviceRankInfoUI.this.lCc = jVar.lvA;
                ExdeviceRankInfoUI.this.lvW = jVar.lvW;
                ExdeviceRankInfoUI.this.lvV = jVar.lvV;
                ExdeviceRankInfoUI.this.lvJ = jVar.lvJ;
                ExdeviceRankInfoUI.g(ExdeviceRankInfoUI.this);
                ExdeviceRankInfoUI.this.runOnUiThread(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(20149);
                        ExdeviceRankInfoUI.h(ExdeviceRankInfoUI.this);
                        if (!bo.isNullOrNil(ExdeviceRankInfoUI.this.lCb)) {
                            ExdeviceRankInfoUI.this.addIconOptionMenu(0, R.raw.actionbar_icon_dark_more, new OnMenuItemClickListener() {
                                public final boolean onMenuItemClick(MenuItem menuItem) {
                                    AppMethodBeat.i(20148);
                                    d.kT(11);
                                    ExdeviceRankInfoUI.j(ExdeviceRankInfoUI.this);
                                    AppMethodBeat.o(20148);
                                    return true;
                                }
                            });
                        }
                        if (ExdeviceRankInfoUI.this.lDj != null) {
                            ExdeviceRankInfoUI.this.lDj.KF(ExdeviceRankInfoUI.this.lDq);
                        }
                        AppMethodBeat.o(20149);
                    }
                });
                AppMethodBeat.o(20150);
                return;
            }
            if (ExdeviceRankInfoUI.this.lDs == null || ExdeviceRankInfoUI.this.lDs.size() == 0) {
                ExdeviceRankInfoUI.this.runOnUiThread(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(20147);
                        Toast.makeText(ExdeviceRankInfoUI.this, R.string.bh0, 1).show();
                        ExdeviceRankInfoUI.this.finish();
                        AppMethodBeat.o(20147);
                    }
                });
            }
            AppMethodBeat.o(20150);
        }
    };
    private int lDB;
    private ListView lDf;
    private b lDg;
    private View lDh;
    private ExdeviceRankListHeaderView lDi;
    private ExdeviceRankChampionInfoView lDj;
    private View lDk;
    private String lDl;
    private String lDm;
    private String lDn;
    private String lDo;
    private com.tencent.mm.plugin.exdevice.f.b.a.a lDp;
    private String lDq;
    private int lDr;
    private List<e> lDs;
    private ArrayList<c> lDt;
    private ArrayList<com.tencent.mm.plugin.exdevice.f.b.a.d> lDu;
    private boolean lDv;
    private boolean lDw;
    private String lDx;
    private boolean lDy;
    private j lDz;
    private boolean lvJ;
    public boolean lvV;
    public String lvW;
    private p lzK = null;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public ExdeviceRankInfoUI() {
        AppMethodBeat.i(20163);
        AppMethodBeat.o(20163);
    }

    static /* synthetic */ void g(ExdeviceRankInfoUI exdeviceRankInfoUI) {
        AppMethodBeat.i(20190);
        exdeviceRankInfoUI.gP(false);
        AppMethodBeat.o(20190);
    }

    static /* synthetic */ void h(ExdeviceRankInfoUI exdeviceRankInfoUI) {
        AppMethodBeat.i(20191);
        exdeviceRankInfoUI.bpV();
        AppMethodBeat.o(20191);
    }

    static /* synthetic */ void m(ExdeviceRankInfoUI exdeviceRankInfoUI) {
        AppMethodBeat.i(20193);
        exdeviceRankInfoUI.bqb();
        AppMethodBeat.o(20193);
    }

    static /* synthetic */ void r(ExdeviceRankInfoUI exdeviceRankInfoUI) {
        AppMethodBeat.i(20197);
        exdeviceRankInfoUI.bpY();
        AppMethodBeat.o(20197);
    }

    static /* synthetic */ void s(ExdeviceRankInfoUI exdeviceRankInfoUI) {
        AppMethodBeat.i(20198);
        exdeviceRankInfoUI.bpP();
        AppMethodBeat.o(20198);
    }

    static /* synthetic */ void t(ExdeviceRankInfoUI exdeviceRankInfoUI) {
        AppMethodBeat.i(20199);
        exdeviceRankInfoUI.bpZ();
        AppMethodBeat.o(20199);
    }

    static /* synthetic */ void u(ExdeviceRankInfoUI exdeviceRankInfoUI) {
        AppMethodBeat.i(20200);
        exdeviceRankInfoUI.gQ(true);
        AppMethodBeat.o(20200);
    }

    private void gP(boolean z) {
        AppMethodBeat.i(20164);
        if (!this.lDw || z) {
            ad.bpe();
            this.lDu = com.tencent.mm.plugin.exdevice.f.b.c.Kn(this.lDo);
            this.lDt = ad.boY().bpk();
            this.lDs = this.lDg.b(this.lDt, this.lDu, this.lvV);
            runOnUiThread(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(20134);
                    ExdeviceRankInfoUI.this.lDg.lCD = ExdeviceRankInfoUI.this.lDs;
                    ExdeviceRankInfoUI.this.lDg.notifyDataSetChanged();
                    ExdeviceRankInfoUI.c(ExdeviceRankInfoUI.this);
                    AppMethodBeat.o(20134);
                }
            });
            AppMethodBeat.o(20164);
            return;
        }
        AppMethodBeat.o(20164);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(20165);
        super.onCreate(bundle);
        this.UP = false;
        this.igi = r.Yz();
        Intent intent = getIntent();
        this.lDl = intent.getStringExtra("key_rank_info");
        this.lDm = intent.getStringExtra("key_rank_semi");
        this.lDn = intent.getStringExtra("app_username");
        this.lDo = intent.getStringExtra("rank_id");
        this.lDv = intent.getBooleanExtra("key_is_latest", false);
        this.lDq = intent.getStringExtra("key_champioin_username");
        this.lDr = intent.getIntExtra("device_type", 0);
        this.lDx = intent.getStringExtra("locate_to_username");
        this.lDw = intent.getBooleanExtra("key_only_show_latest_rank", false);
        if (bo.isNullOrNil(this.lDo) || "#".equals(this.lDo)) {
            if (!this.lDw) {
                com.tencent.mm.plugin.exdevice.f.b.a.d dVar;
                com.tencent.mm.plugin.exdevice.f.b.b.d boX = ad.boX();
                Cursor a = boX.bSd.a(String.format("select * from %s order by %s desc limit 1", new Object[]{"HardDeviceRankInfo", "rankID"}), null, 2);
                if (a == null) {
                    ab.e("MicroMsg.ExdeviceRankInfoStg", "Get no rank in DB");
                    dVar = null;
                } else {
                    if (a.moveToFirst()) {
                        dVar = new com.tencent.mm.plugin.exdevice.f.b.a.d();
                        dVar.d(a);
                    } else {
                        ab.d("MicroMsg.ExdeviceRankInfoStg", "hy: no record");
                        dVar = null;
                    }
                    a.close();
                }
                if (dVar != null) {
                    this.lDo = dVar.field_rankID;
                    this.lDn = dVar.field_appusername;
                }
            }
            this.lDq = null;
            this.lDv = true;
        }
        ad.bpe();
        this.lDu = com.tencent.mm.plugin.exdevice.f.b.c.Kn(this.lDo);
        if (!this.lDw) {
            if (this.lDu == null || this.lDu.size() <= 0) {
                this.lDt = new ArrayList();
                this.lDu = com.tencent.mm.plugin.exdevice.f.a.a.a(this.lDo, this.lDn, this.lDl, this.lDm, this.lCE, this.lDt);
                ad.bpe();
                com.tencent.mm.plugin.exdevice.f.b.c.f(this.lDo, this.lDu);
            } else {
                com.tencent.mm.plugin.exdevice.f.a.a.d(this.lDl, this.lDm, this.lCE);
            }
            this.lDt = ad.boY().bpk();
        }
        this.lDg = new b(this, this.lDn);
        this.lDg.lCE = this.lCE;
        this.lDs = this.lDg.b(this.lDt, this.lDu, this.lvV);
        this.lDg.lCD = this.lDs;
        if (bo.isNullOrNil(this.lDq)) {
            bpW();
        }
        this.lDp = ad.bpa().Kr(this.lDq);
        if (this.lDp == null && !bo.isNullOrNil(this.lDq)) {
            this.lDp = new com.tencent.mm.plugin.exdevice.f.b.a.a();
            this.lDp.field_username = this.lDq;
            this.lDp.field_championMotto = getIntent().getStringExtra("key_champion_info");
            this.lDp.field_championUrl = getIntent().getStringExtra("key_champion_coverimg");
            ad.bpe();
            ad.bpa().a(this.lDp);
        }
        initView();
        if (this.lDu != null && this.lDu.size() > 0) {
            this.lDj.KF(((com.tencent.mm.plugin.exdevice.f.b.a.d) this.lDu.get(0)).field_username);
        }
        ad.bpf().a(this);
        ad.bpe().lwf = this;
        bpU();
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(20156);
                ExdeviceRankInfoUI.this.finish();
                AppMethodBeat.o(20156);
                return false;
            }
        });
        setMMTitle((int) R.string.bik);
        showOptionMenu(true);
        bpV();
        com.tencent.mm.sdk.b.b sdVar = new sd();
        sdVar.cOe.action = 2;
        com.tencent.mm.sdk.b.a.xxA.a(sdVar, com.tencent.mm.sdk.g.d.xDG.cin());
        AppMethodBeat.o(20165);
    }

    private void bpU() {
        AppMethodBeat.i(20166);
        ab.i("MicroMsg.Sport.ExdeviceRankInfoUI", "updateRankInfoUIFromServer");
        this.lDz = new j(this.lDo, this.lDn, this.lDq, this.lDv, this.lDA);
        this.lDz.lvY = this;
        aw.Rg().a(this.lDz, 0);
        AppMethodBeat.o(20166);
    }

    private void bpV() {
        AppMethodBeat.i(20167);
        ab.i("MicroMsg.Sport.ExdeviceRankInfoUI", "try2LocateToUser, locate2User(%s), username(%s).", this.lDx, this.igi);
        if (bo.isNullOrNil(this.lDx) || KH(this.lDx) < 0) {
            ab.d("MicroMsg.Sport.ExdeviceRankInfoUI", "locate to username is null or nil.");
            AppMethodBeat.o(20167);
            return;
        }
        AppMethodBeat.o(20167);
    }

    private int KH(String str) {
        AppMethodBeat.i(20168);
        ab.i("MicroMsg.Sport.ExdeviceRankInfoUI", "locateToUser, locate2User(%s), username(%s).", str, this.igi);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(20168);
            return -1;
        } else if (this.lDs == null || this.lDs.size() == 0) {
            AppMethodBeat.o(20168);
            return -2;
        } else {
            int i = 0;
            while (i < this.lDs.size()) {
                com.tencent.mm.plugin.exdevice.f.b.a.d dVar = ((e) this.lDs.get(i)).lFy;
                int i2 = ((e) this.lDs.get(i)).lFz;
                if (dVar == null || !str.equalsIgnoreCase(dVar.field_username) || str.equalsIgnoreCase(this.igi) || (i2 & 2) == 2) {
                    i++;
                } else {
                    DisplayMetrics displayMetrics = new DisplayMetrics();
                    getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
                    ab.i("MicroMsg.Sport.ExdeviceRankInfoUI", "locateToUser pos(%d).(h : %d)", Integer.valueOf(i), Integer.valueOf(displayMetrics.heightPixels));
                    this.lDf.setSelectionFromTop(i, i2 / 4);
                    this.lDg.lCF = str;
                    this.lDg.notifyDataSetInvalidated();
                    bpY();
                    AppMethodBeat.o(20168);
                    return i;
                }
            }
            this.lDg.lCF = null;
            AppMethodBeat.o(20168);
            return -3;
        }
    }

    private void bpP() {
        AppMethodBeat.i(20169);
        if (this.lDp == null || this.igi == null || !this.igi.equals(this.lDp.field_username) || !bo.isNullOrNil(this.lDp.field_championUrl)) {
            if (this.lBZ != null) {
                this.lBZ.setVisibility(8);
            }
            if (!(this.lDp == null || bo.bc(this.lDp.field_username, "").equals(this.igi) || bo.isNullOrNil(this.lDp.field_championUrl))) {
                this.lDi.setOnViewClickListener(new OnClickListener() {
                    public final void onClick(View view) {
                        AppMethodBeat.i(20160);
                        ExdeviceRankInfoUI.p(ExdeviceRankInfoUI.this);
                        AppMethodBeat.o(20160);
                    }
                });
            }
        } else {
            if (this.lBZ != null) {
                this.lBZ.setVisibility(0);
            }
            if (this.lDi != null) {
                this.lDi.setOnViewClickListener(new OnClickListener() {
                    public final void onClick(View view) {
                        AppMethodBeat.i(20159);
                        com.tencent.mm.plugin.exdevice.f.a.e.e(ExdeviceRankInfoUI.this);
                        AppMethodBeat.o(20159);
                    }
                });
                AppMethodBeat.o(20169);
                return;
            }
        }
        AppMethodBeat.o(20169);
    }

    private void bpW() {
        AppMethodBeat.i(20170);
        String bpX = bpX();
        if (!bo.isNullOrNil(bpX)) {
            this.lDq = bpX;
        }
        AppMethodBeat.o(20170);
    }

    private String bpX() {
        AppMethodBeat.i(20171);
        if (this.lDs != null) {
            for (e eVar : this.lDs) {
                com.tencent.mm.plugin.exdevice.f.b.a.d dVar = eVar.lFy;
                if (dVar != null && dVar.field_ranknum == 1) {
                    String str = dVar.field_username;
                    AppMethodBeat.o(20171);
                    return str;
                }
            }
        }
        AppMethodBeat.o(20171);
        return null;
    }

    public final void initView() {
        int dimensionPixelSize;
        int size;
        boolean z;
        AppMethodBeat.i(20172);
        this.lDh = findViewById(R.id.bkm);
        ExdeviceRankListHeaderView exdeviceRankListHeaderView = new ExdeviceRankListHeaderView(this);
        Rect rect = new Rect();
        getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
        int i = rect.top;
        if (i == 0) {
            i = com.tencent.mm.plugin.exdevice.j.b.J(this, getResources().getDimensionPixelSize(R.dimen.gt));
        }
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        if (displayMetrics.widthPixels > displayMetrics.heightPixels) {
            dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.fc);
        } else {
            dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.fd);
        }
        Display defaultDisplay = getWindowManager().getDefaultDisplay();
        i = ((defaultDisplay.getHeight() / 2) - i) - dimensionPixelSize;
        if (defaultDisplay.getHeight() <= 0 || i <= 0) {
            i = getResources().getDimensionPixelSize(R.dimen.gn);
        }
        exdeviceRankListHeaderView.setMinimumHeight(i);
        exdeviceRankListHeaderView.setMinimumWidth(defaultDisplay.getWidth());
        exdeviceRankListHeaderView.setTag(Integer.valueOf(i));
        this.lDi = exdeviceRankListHeaderView;
        MMPullDownView mMPullDownView = (MMPullDownView) findViewById(R.id.bkk);
        this.lDf = (ListView) findViewById(R.id.bkl);
        this.lDj = (ExdeviceRankChampionInfoView) findViewById(R.id.bkn);
        this.lBZ = findViewById(R.id.bkb);
        this.lBZ.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(20161);
                ab.d("MicroMsg.Sport.ExdeviceRankInfoUI", "ap: start change cover");
                com.tencent.mm.plugin.exdevice.f.a.e.e(ExdeviceRankInfoUI.this);
                AppMethodBeat.o(20161);
            }
        });
        this.lDi.setIsShowTip(false);
        bpP();
        mMPullDownView.setIsBottomShowAll(false);
        mMPullDownView.setTopViewVisible(false);
        mMPullDownView.setBottomViewVisible(false);
        mMPullDownView.setIsBottomShowAll(false);
        mMPullDownView.setIsTopShowAll(false);
        mMPullDownView.setCanOverScrool(true);
        mMPullDownView.setOnInterceptTouchEventListener(new MMPullDownView.a() {
            public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
                boolean z;
                AppMethodBeat.i(20162);
                ExdeviceRankInfoUI exdeviceRankInfoUI = ExdeviceRankInfoUI.this;
                if (ExdeviceRankInfoUI.this.lDs == null || ExdeviceRankInfoUI.this.lDs.size() == 0) {
                    z = false;
                } else {
                    z = true;
                }
                exdeviceRankInfoUI.lDy = z;
                AppMethodBeat.o(20162);
                return false;
            }
        });
        mMPullDownView.setAtBottomCallBack(new MMPullDownView.c() {
            public final boolean bhm() {
                AppMethodBeat.i(20135);
                View childAt = ExdeviceRankInfoUI.this.lDf.getChildAt(ExdeviceRankInfoUI.this.lDf.getChildCount() - 1);
                int count = ExdeviceRankInfoUI.this.lDf.getCount();
                if (count <= 0 || childAt == null || childAt.getBottom() > ExdeviceRankInfoUI.this.lDf.getHeight() || ExdeviceRankInfoUI.this.lDf.getLastVisiblePosition() != count - 1) {
                    AppMethodBeat.o(20135);
                    return false;
                }
                AppMethodBeat.o(20135);
                return true;
            }
        });
        mMPullDownView.setOnScrollChangedListener(new MMPullDownView.b() {
            public final void bpT() {
                AppMethodBeat.i(20136);
                ExdeviceRankInfoUI.r(ExdeviceRankInfoUI.this);
                AppMethodBeat.o(20136);
            }
        });
        mMPullDownView.setAtTopCallBack(new MMPullDownView.d() {
            public final boolean bhl() {
                AppMethodBeat.i(20137);
                int firstVisiblePosition = ExdeviceRankInfoUI.this.lDf.getFirstVisiblePosition();
                if (firstVisiblePosition == 0) {
                    View childAt = ExdeviceRankInfoUI.this.lDf.getChildAt(firstVisiblePosition);
                    if (childAt != null && childAt.getTop() >= 0) {
                        AppMethodBeat.o(20137);
                        return true;
                    }
                }
                AppMethodBeat.o(20137);
                return false;
            }
        });
        this.lDf.setOnScrollListener(new OnScrollListener() {
            public final void onScrollStateChanged(AbsListView absListView, int i) {
                AppMethodBeat.i(20138);
                ExdeviceRankInfoUI.r(ExdeviceRankInfoUI.this);
                AppMethodBeat.o(20138);
            }

            public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
                AppMethodBeat.i(20139);
                ExdeviceRankInfoUI.r(ExdeviceRankInfoUI.this);
                AppMethodBeat.o(20139);
            }
        });
        this.lDf.addHeaderView(this.lDi, null, false);
        View inflate = getLayoutInflater().inflate(R.layout.wl, null);
        this.lDk = inflate.findViewById(R.id.bkh);
        inflate.findViewById(R.id.bki).setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(20140);
                d.kT(24);
                Intent intent = new Intent();
                intent.putExtra("Select_Talker_Name", "gh_43f2581f6fd6");
                intent.putExtra("Select_block_List", "gh_43f2581f6fd6");
                intent.putExtra("Select_Conv_Type", 3);
                intent.putExtra("mutil_select_is_ret", true);
                intent.putExtra("Select_Send_Card", true);
                com.tencent.mm.bp.d.b(ExdeviceRankInfoUI.this, ".ui.transmit.SelectConversationUI", intent, 3);
                AppMethodBeat.o(20140);
            }
        });
        this.lDk.setVisibility(8);
        this.lDf.addFooterView(inflate);
        if (this.lDt != null) {
            dimensionPixelSize = this.lDt.size();
        } else {
            dimensionPixelSize = 0;
        }
        if (this.lDu != null) {
            size = this.lDu.size();
        } else {
            size = 0;
        }
        if (dimensionPixelSize + size == 0) {
            this.lDs = new ArrayList();
            this.lDg.lCD = this.lDs;
            getString(R.string.tz);
            this.lzK = h.b((Context) this, getString(R.string.cn5), true, new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                    AppMethodBeat.i(20141);
                    if (ExdeviceRankInfoUI.this.lzK != null) {
                        ExdeviceRankInfoUI.this.lzK.dismiss();
                        ExdeviceRankInfoUI.this.lzK = null;
                    }
                    ExdeviceRankInfoUI.this.finish();
                    AppMethodBeat.o(20141);
                }
            });
        }
        this.lDf.setAdapter(this.lDg);
        this.lDg.lCG = this;
        if (this.lDr == 1) {
            this.lDf.setVisibility(0);
            this.lDh.setVisibility(8);
            z = true;
        } else {
            this.lDf.setVisibility(8);
            this.lDh.setVisibility(0);
            z = false;
        }
        if (z) {
            this.lBT = (ImageView) findViewById(R.id.bka);
            mMPullDownView.setCanOverScrool(false);
            dimensionPixelSize = com.tencent.mm.bz.a.gd(this);
            i = ((Integer) this.lDi.getTag()).intValue();
            if (this.lvV) {
                i += (getResources().getDimensionPixelSize(R.dimen.h3) / 2) + getResources().getDimensionPixelSize(R.dimen.h2);
            }
            this.lBT.setLayoutParams(new LayoutParams(dimensionPixelSize, i));
            bpZ();
            gQ(false);
            AppMethodBeat.o(20172);
            return;
        }
        ab.d("MicroMsg.Sport.ExdeviceRankInfoUI", "hy: cannot handle this device type");
        finish();
        AppMethodBeat.o(20172);
    }

    private void bpY() {
        AppMethodBeat.i(20173);
        View childAt = this.lDf.getChildAt(0);
        int[] iArr = new int[2];
        if (childAt != null) {
            if (this.lDf.getFirstVisiblePosition() == 0) {
                childAt.getLocationOnScreen(iArr);
                if (bo.isNullOrNil(this.lDx) && lCl == 128) {
                    lCl = iArr[1];
                }
                int i = iArr[1];
                if (i > 0) {
                    float f;
                    if (i >= lCl) {
                        f = 1.0f;
                    } else {
                        f = ((float) i) / ((float) lCl);
                    }
                    ab.d("MicroMsg.Sport.ExdeviceRankInfoUI", "ap-alpha: %s", Float.valueOf(f));
                    this.lDj.setAlpha(f);
                    this.lDj.setVisibility(0);
                    this.lBZ.setAlpha(f);
                    AppMethodBeat.o(20173);
                    return;
                }
            }
            this.lDj.setAlpha(0.0f);
            this.lBZ.setAlpha(0.0f);
            this.lDj.setVisibility(8);
        }
        AppMethodBeat.o(20173);
    }

    public void onResume() {
        AppMethodBeat.i(20174);
        super.onResume();
        AppMethodBeat.o(20174);
    }

    /* Access modifiers changed, original: protected */
    public void onRestart() {
        AppMethodBeat.i(20175);
        super.onRestart();
        gP(true);
        AppMethodBeat.o(20175);
    }

    public void onDestroy() {
        AppMethodBeat.i(20176);
        this.UP = true;
        if (this.lDg != null) {
            b.finish();
        }
        super.onDestroy();
        if (this.lDz != null) {
            this.lDz.lvY = null;
        }
        ad.bpf().b(this);
        ad.bpe().lwf = null;
        ad.bpe().lwg = null;
        if (this.lDB > 0) {
            int i = this.lDB;
            ab.v("MicroMsg.Sport.SportReportLogic", "reportLikeCount count=%d", Integer.valueOf(i));
            com.tencent.mm.plugin.report.e.pXa.e(13168, Integer.valueOf(0), Integer.valueOf(i));
        }
        AppMethodBeat.o(20176);
    }

    public void onPause() {
        AppMethodBeat.i(20177);
        super.onPause();
        AppMethodBeat.o(20177);
    }

    public final int getLayoutId() {
        return R.layout.wn;
    }

    private void bpZ() {
        AppMethodBeat.i(20178);
        if (this.lDp == null) {
            this.lBT.setImageResource(R.color.le);
            this.hZn = null;
        } else if (this.hZn != this.lDp.field_championUrl && (this.hZn == null || !this.hZn.equals(this.lDp.field_championUrl))) {
            com.tencent.mm.plugin.exdevice.f.a.e.a(this, this.lBT, this.lDp.field_championUrl);
            this.hZn = this.lDp.field_championUrl;
            AppMethodBeat.o(20178);
            return;
        }
        AppMethodBeat.o(20178);
    }

    private void gQ(boolean z) {
        AppMethodBeat.i(20179);
        if (z) {
            bpW();
        }
        if (bo.isNullOrNil(this.lDn)) {
            this.lDj.setVisibility(8);
            AppMethodBeat.o(20179);
            return;
        }
        this.lDj.KF(this.lDq);
        this.lDj.setVisibility(0);
        AppMethodBeat.o(20179);
    }

    public final void b(String str, com.tencent.mm.plugin.exdevice.f.b.d dVar) {
        AppMethodBeat.i(20180);
        boolean z = (dVar == null || bo.isNullOrNil(str)) ? false : true;
        Assert.assertTrue(z);
        if ("HardDeviceRankInfo".equals(str)) {
            if (this.lDo != null && this.lDo.equals(dVar.lvL)) {
                ab.i("MicroMsg.Sport.ExdeviceRankInfoUI", "onRankChange, rankId(%s).", this.lDo);
                gP(true);
                if (bo.isNullOrNil(this.lDq) || !this.lDq.equals(bpX())) {
                    bpW();
                    this.lDp = ad.bpa().Kr(this.lDq);
                    runOnUiThread(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(20142);
                            ExdeviceRankInfoUI.s(ExdeviceRankInfoUI.this);
                            ExdeviceRankInfoUI.t(ExdeviceRankInfoUI.this);
                            AppMethodBeat.o(20142);
                        }
                    });
                }
                runOnUiThread(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(20143);
                        ExdeviceRankInfoUI.u(ExdeviceRankInfoUI.this);
                        if (ExdeviceRankInfoUI.this.lDy) {
                            ExdeviceRankInfoUI.this.lDg.notifyDataSetChanged();
                            AppMethodBeat.o(20143);
                            return;
                        }
                        ExdeviceRankInfoUI.h(ExdeviceRankInfoUI.this);
                        AppMethodBeat.o(20143);
                    }
                });
                AppMethodBeat.o(20180);
                return;
            }
        } else if ("HardDeviceChampionInfo".equals(str) && !bo.isNullOrNil(this.lDq) && this.lDq.equals(dVar.username)) {
            this.lDp = ad.bpa().Kr(this.lDq);
            runOnUiThread(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(20144);
                    ExdeviceRankInfoUI.s(ExdeviceRankInfoUI.this);
                    ExdeviceRankInfoUI.t(ExdeviceRankInfoUI.this);
                    AppMethodBeat.o(20144);
                }
            });
        }
        AppMethodBeat.o(20180);
    }

    public final void Ko(String str) {
        AppMethodBeat.i(20181);
        ab.d("MicroMsg.Sport.ExdeviceRankInfoUI", "hy: rank changed to %s", str);
        this.lDo = str;
        AppMethodBeat.o(20181);
    }

    public final void KI(String str) {
        AppMethodBeat.i(20182);
        d.kT(6);
        Intent intent = new Intent(this, ExdeviceProfileUI.class);
        intent.putExtra("username", str);
        intent.putExtra("usernickname", (String) this.lCE.get(str));
        intent.putExtra("app_username", this.lDn);
        intent.putExtra("rank_id", this.lDo);
        startActivityForResult(intent, 4);
        AppMethodBeat.o(20182);
    }

    public final void bqa() {
        AppMethodBeat.i(20183);
        d.kT(31);
        bqb();
        AppMethodBeat.o(20183);
    }

    public final void cd(String str, int i) {
        AppMethodBeat.i(20184);
        ad.bpe();
        String str2 = this.lDo;
        String str3 = this.lDn;
        com.tencent.mm.plugin.exdevice.f.b.b.d boX = ad.boX();
        boolean z = (bo.isNullOrNil(str2) || bo.isNullOrNil(str) || (i != 1 && i != 0 && i != 2)) ? false : true;
        Assert.assertTrue(z);
        com.tencent.mm.plugin.exdevice.f.b.a.d a = boX.a(new com.tencent.mm.plugin.exdevice.f.b.d(str2, null, str));
        if (a == null) {
            ab.w("MicroMsg.ExdeviceRankInfoStg", "hy: info is null. abort");
        } else {
            a.field_selfLikeState = i;
            switch (a.field_selfLikeState) {
                case 0:
                    a.field_likecount--;
                    break;
                case 1:
                    a.field_likecount++;
                    break;
                default:
                    ab.w("MicroMsg.ExdeviceRankInfoStg", "hy: still loading...abort");
                    break;
            }
            boX.a(a, true);
        }
        com.tencent.mm.plugin.exdevice.f.b.c.d(str2, str3, str, i);
        this.lDB++;
        AppMethodBeat.o(20184);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(20185);
        super.onActivityResult(i, i2, intent);
        if (com.tencent.mm.plugin.exdevice.f.a.e.a(this, i, i2, intent, this.lDn)) {
            AppMethodBeat.o(20185);
            return;
        }
        if (i2 == -1) {
            String stringExtra;
            switch (i) {
                case 1:
                    if (intent == null) {
                        ab.e("MicroMsg.Sport.ExdeviceRankInfoUI", "onActivityResult, data is null.(reqestCode : %d)", Integer.valueOf(i));
                        AppMethodBeat.o(20185);
                        return;
                    }
                    stringExtra = intent == null ? null : intent.getStringExtra("Select_Conv_User");
                    if (stringExtra == null || stringExtra.length() == 0) {
                        ab.e("MicroMsg.Sport.ExdeviceRankInfoUI", "select conversation failed, toUser is null.");
                        AppMethodBeat.o(20185);
                        return;
                    }
                    ac.a((Context) this, stringExtra, ac.dG(this), intent.getStringExtra("custom_send_text"), this.lCc);
                    h.bQ(this.mController.ylL, getResources().getString(R.string.to));
                    ab.d("MicroMsg.Sport.ExdeviceRankInfoUI", "Select conversation return.");
                    AppMethodBeat.o(20185);
                    return;
                case 2:
                    h.bQ(this.mController.ylL, getResources().getString(R.string.to));
                    ab.d("MicroMsg.Sport.ExdeviceRankInfoUI", "Share to timeline return.");
                    AppMethodBeat.o(20185);
                    return;
                case 3:
                    if (intent != null) {
                        ArrayList<String> P = bo.P(intent.getStringExtra("received_card_name").split(","));
                        String stringExtra2 = intent.getStringExtra("custom_send_text");
                        for (String stringExtra3 : P) {
                            g.bOk().q("gh_43f2581f6fd6", stringExtra3, t.kH(stringExtra3));
                            if (!bo.isNullOrNil(stringExtra2)) {
                                qb qbVar = new qb();
                                qbVar.cMq.cMr = stringExtra3;
                                qbVar.cMq.content = stringExtra2;
                                qbVar.cMq.type = t.nK(stringExtra3);
                                qbVar.cMq.flags = 0;
                                com.tencent.mm.sdk.b.a.xxA.m(qbVar);
                            }
                        }
                        AppMethodBeat.o(20185);
                        return;
                    }
                    break;
                case 4:
                    if (intent != null && intent.getBooleanExtra("KeyNeedUpdateRank", false)) {
                        bpU();
                        break;
                    }
            }
        }
        AppMethodBeat.o(20185);
    }

    public final boolean KJ(String str) {
        AppMethodBeat.i(20186);
        if (bo.isNullOrNil(this.lDo) || "#".equals(this.lDo)) {
            ab.d("MicroMsg.Sport.ExdeviceRankInfoUI", "hy: rank id is not valid.abort the event");
            Toast.makeText(this, getString(R.string.bhm), 0).show();
            AppMethodBeat.o(20186);
            return true;
        } else if (r.Yz().equals(str)) {
            ab.d("MicroMsg.Sport.ExdeviceRankInfoUI", "hy: is self. see who likes me");
            Intent intent = new Intent(this, ExdeviceLikeUI.class);
            intent.putExtra("app_username", this.lDn);
            intent.putExtra("rank_id", this.lDo);
            intent.putExtra("key_is_like_read_only", true);
            startActivity(intent);
            AppMethodBeat.o(20186);
            return true;
        } else {
            AppMethodBeat.o(20186);
            return false;
        }
    }

    private void bqb() {
        AppMethodBeat.i(20187);
        if (bo.isNullOrNil(this.lvW)) {
            com.tencent.mm.plugin.exdevice.f.b.a.a Kr = ad.bpa().Kr(this.igi);
            if (Kr != null) {
                this.lvW = Kr.field_championUrl;
            }
        }
        com.tencent.mm.plugin.exdevice.f.b.a.d h = b.h(this.igi, this.lDu);
        String str = "--";
        String str2 = AppEventsConstants.EVENT_PARAM_VALUE_NO;
        if (h != null) {
            str = String.valueOf(h.field_ranknum);
            str2 = String.valueOf(h.field_score);
        }
        new ac().a((Context) this, str, str2, this.lvW, new ac.a() {
            public final void Kj(String str) {
                AppMethodBeat.i(20145);
                Intent intent = new Intent();
                intent.putExtra("Ksnsupload_appid", "wx7fa037cc7dfabad5");
                intent.putExtra("Ksnsupload_appname", ExdeviceRankInfoUI.this.getString(R.string.bij));
                intent.putExtra("Ksnsupload_source", 1);
                intent.putExtra("need_result", true);
                String nW = v.nW("wx_sport");
                v.Zp().y(nW, true).j("prePublishId", "wx_sport");
                intent.putExtra("reportSessionId", nW);
                intent.putExtra("Ksnsupload_type", 0);
                intent.putExtra("sns_kemdia_path", str);
                com.tencent.mm.bp.d.b(ExdeviceRankInfoUI.this, "sns", ".ui.SnsUploadUI", intent, 2);
                AppMethodBeat.o(20145);
            }
        });
        AppMethodBeat.o(20187);
    }

    public final void a(j jVar) {
        AppMethodBeat.i(20188);
        runOnUiThread(new Runnable() {
            public final void run() {
                AppMethodBeat.i(20152);
                if (ExdeviceRankInfoUI.this.lzK != null && ExdeviceRankInfoUI.this.lzK.isShowing()) {
                    ExdeviceRankInfoUI.this.lzK.dismiss();
                    ExdeviceRankInfoUI.this.lzK = null;
                    ab.d("MicroMsg.Sport.ExdeviceRankInfoUI", "dismiss tips dialog.");
                }
                AppMethodBeat.o(20152);
            }
        });
        this.lCb = jVar.lvz;
        this.lCc = jVar.lvA;
        this.lvW = jVar.lvW;
        this.lvV = jVar.lvV;
        this.lvJ = jVar.lvJ;
        this.lDu = jVar.lvO;
        this.lDt = jVar.lvP;
        this.lDs = this.lDg.b(this.lDt, this.lDu, this.lvV);
        runOnUiThread(new Runnable() {
            public final void run() {
                AppMethodBeat.i(20153);
                ExdeviceRankInfoUI.this.lDg.lCD = ExdeviceRankInfoUI.this.lDs;
                ExdeviceRankInfoUI.this.lDg.notifyDataSetChanged();
                ExdeviceRankInfoUI.c(ExdeviceRankInfoUI.this);
                AppMethodBeat.o(20153);
            }
        });
        AppMethodBeat.o(20188);
    }

    static /* synthetic */ void c(ExdeviceRankInfoUI exdeviceRankInfoUI) {
        AppMethodBeat.i(20189);
        exdeviceRankInfoUI.lDk.setVisibility(0);
        AppMethodBeat.o(20189);
    }

    static /* synthetic */ void j(ExdeviceRankInfoUI exdeviceRankInfoUI) {
        AppMethodBeat.i(20192);
        com.tencent.mm.ui.widget.a.d dVar = new com.tencent.mm.ui.widget.a.d(exdeviceRankInfoUI.mController.ylL, 1, false);
        dVar.rBl = new n.c() {
            public final void a(l lVar) {
                int i;
                AppMethodBeat.i(20157);
                if (ab.getLogLevel() == 0) {
                    i = 2;
                } else {
                    i = com.tencent.mm.m.g.Nu().getInt("WeRunLaunchGroupRankWeAppSwitch", 0);
                }
                if (i == 2) {
                    lVar.a(3, ExdeviceRankInfoUI.this.getString(R.string.bh4), (int) R.raw.bottomsheet_icon_transmit);
                }
                lVar.a(0, ExdeviceRankInfoUI.this.getString(R.string.bh2), (int) R.raw.bottomsheet_icon_transmit);
                lVar.a(1, ExdeviceRankInfoUI.this.getString(R.string.bh5), (int) R.raw.bottomsheet_icon_moment);
                lVar.a(2, ExdeviceRankInfoUI.this.getString(R.string.bh1), (int) R.raw.bottomsheet_icon_donate);
                AppMethodBeat.o(20157);
            }
        };
        dVar.rBm = new n.d() {
            public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                AppMethodBeat.i(20158);
                switch (menuItem.getItemId()) {
                    case 0:
                        d.kT(15);
                        ExdeviceRankInfoUI.n(ExdeviceRankInfoUI.this);
                        AppMethodBeat.o(20158);
                        return;
                    case 1:
                        d.kT(16);
                        ExdeviceRankInfoUI.m(ExdeviceRankInfoUI.this);
                        AppMethodBeat.o(20158);
                        return;
                    case 2:
                        d.kT(7);
                        ExdeviceRankInfoUI.o(ExdeviceRankInfoUI.this);
                        AppMethodBeat.o(20158);
                        return;
                    case 3:
                        d.kT(36);
                        AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
                        appBrandStatObject.scene = FilterEnum4Shaka.MIC_WEISHI_BAIXIANG;
                        ((com.tencent.mm.plugin.appbrand.service.e) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.appbrand.service.e.class)).a(null, "gh_1f9ebf140e39@app", null, 0, 0, null, appBrandStatObject);
                        break;
                }
                AppMethodBeat.o(20158);
            }
        };
        dVar.cpD();
        AppMethodBeat.o(20192);
    }

    static /* synthetic */ void n(ExdeviceRankInfoUI exdeviceRankInfoUI) {
        AppMethodBeat.i(20194);
        if (bo.isNullOrNil(exdeviceRankInfoUI.lvW)) {
            com.tencent.mm.plugin.exdevice.f.b.a.a Kr = ad.bpa().Kr(exdeviceRankInfoUI.igi);
            if (Kr != null) {
                exdeviceRankInfoUI.lvW = Kr.field_championUrl;
            }
        }
        com.tencent.mm.plugin.exdevice.f.b.a.d h = b.h(exdeviceRankInfoUI.igi, exdeviceRankInfoUI.lDu);
        String str = "--";
        String str2 = AppEventsConstants.EVENT_PARAM_VALUE_NO;
        if (h != null) {
            str = String.valueOf(h.field_ranknum);
            str2 = String.valueOf(h.field_score);
        }
        new ac().a((Context) exdeviceRankInfoUI, str, str2, exdeviceRankInfoUI.lvW, new ac.a() {
            public final void Kj(String str) {
                AppMethodBeat.i(20151);
                ExdeviceRankInfoUI.c(ExdeviceRankInfoUI.this, str);
                AppMethodBeat.o(20151);
            }
        });
        AppMethodBeat.o(20194);
    }

    static /* synthetic */ void o(ExdeviceRankInfoUI exdeviceRankInfoUI) {
        AppMethodBeat.i(20195);
        AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
        appBrandStatObject.scene = FilterEnum4Shaka.MIC_WEISHI_BAIXIANG;
        ((com.tencent.mm.plugin.appbrand.service.e) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.appbrand.service.e.class)).a(exdeviceRankInfoUI.mController.ylL, null, "wx3fca79fc5715b185", 0, 0, "", appBrandStatObject);
        AppMethodBeat.o(20195);
    }

    static /* synthetic */ void p(ExdeviceRankInfoUI exdeviceRankInfoUI) {
        AppMethodBeat.i(20196);
        com.tencent.mm.ui.widget.a.d dVar = new com.tencent.mm.ui.widget.a.d(exdeviceRankInfoUI.mController.ylL, 1, false);
        dVar.rBl = new n.c() {
            public final void a(l lVar) {
                AppMethodBeat.i(20154);
                if (ExdeviceRankInfoUI.this.lvJ) {
                    lVar.e(1, ExdeviceRankInfoUI.this.getString(R.string.bh_));
                    AppMethodBeat.o(20154);
                    return;
                }
                lVar.e(0, ExdeviceRankInfoUI.this.getString(R.string.bhf));
                AppMethodBeat.o(20154);
            }
        };
        dVar.rBm = new n.d() {
            public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                AppMethodBeat.i(20155);
                if (ExdeviceRankInfoUI.this.lDp == null) {
                    AppMethodBeat.o(20155);
                    return;
                }
                switch (i) {
                    case 0:
                        ExdeviceRankInfoUI.this.lvJ = true;
                        d.kT(10);
                        ad.bpe();
                        com.tencent.mm.plugin.exdevice.f.b.c.d("", ExdeviceRankInfoUI.this.lDn, ExdeviceRankInfoUI.this.lDp.field_username, 3);
                        break;
                }
                AppMethodBeat.o(20155);
            }
        };
        dVar.cpD();
        AppMethodBeat.o(20196);
    }

    static /* synthetic */ void c(ExdeviceRankInfoUI exdeviceRankInfoUI, String str) {
        AppMethodBeat.i(20201);
        Intent intent = new Intent();
        intent.putExtra("Select_Conv_Type", 3);
        intent.putExtra("select_is_ret", true);
        intent.putExtra("Retr_Msg_Type", 0);
        intent.putExtra("image_path", str);
        com.tencent.mm.bp.d.b((Context) exdeviceRankInfoUI, ".ui.transmit.SelectConversationUI", intent, 1);
        AppMethodBeat.o(20201);
    }
}
