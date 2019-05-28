package com.tencent.mm.plugin.exdevice.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
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
import com.tencent.mm.g.a.mc;
import com.tencent.mm.g.a.sd;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.r;
import com.tencent.mm.model.s;
import com.tencent.mm.model.t;
import com.tencent.mm.model.v;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.exdevice.a.b;
import com.tencent.mm.plugin.exdevice.f.a.g;
import com.tencent.mm.plugin.exdevice.f.a.i;
import com.tencent.mm.plugin.exdevice.f.a.k;
import com.tencent.mm.plugin.exdevice.f.b.a.c;
import com.tencent.mm.plugin.exdevice.f.b.e;
import com.tencent.mm.plugin.exdevice.model.ac;
import com.tencent.mm.plugin.sport.ui.SportChartView;
import com.tencent.mm.pluginsdk.ui.e.j;
import com.tencent.mm.protocal.protobuf.ach;
import com.tencent.mm.protocal.protobuf.cdo;
import com.tencent.mm.protocal.protobuf.cyk;
import com.tencent.mm.protocal.protobuf.mq;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMPullDownView;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import junit.framework.Assert;

public class ExdeviceProfileUI extends MMActivity implements e, c {
    private static int lCl = 0;
    private boolean UP = false;
    private int eOf = 0;
    private String hZn;
    private String igi;
    private String lBO;
    private com.tencent.mm.plugin.exdevice.f.b.a.a lBP;
    private ArrayList<String> lBQ;
    private cyk lBR;
    private ExdeviceProfileAffectedUserView lBS;
    private ImageView lBT;
    private ListView lBU;
    private ExdeviceProfileListHeader lBV;
    private MMSwitchBtn lBW;
    private SportChartView lBX;
    private a lBY;
    private View lBZ;
    private boolean lBt;
    private boolean lBu;
    private int lBv;
    private List<mq> lBy;
    private volatile boolean lCa;
    private String lCb;
    private String lCc;
    private List<com.tencent.mm.plugin.sport.a.e> lCd;
    private ArrayList<c> lCe;
    private List<ach> lCf;
    private int lCg;
    private b<i> lCh = new b<i>() {
        public final /* synthetic */ void a(int i, int i2, String str, m mVar) {
            AppMethodBeat.i(20023);
            final i iVar = (i) mVar;
            if (ExdeviceProfileUI.this.isFinishing() || ExdeviceProfileUI.this.UP) {
                ExdeviceProfileUI.b(ExdeviceProfileUI.this);
                ab.i("MicroMsg.Sport.ExdeviceProfileUI", "ExdeviceProfileUI has been destroyed.");
                AppMethodBeat.o(20023);
                return;
            }
            ExdeviceProfileUI.this.lCa = true;
            if (i == 0 && i2 == 0) {
                ExdeviceProfileUI.this.runOnUiThread(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(20020);
                        if (ExdeviceProfileUI.this.lzK != null) {
                            ExdeviceProfileUI.this.lzK.dismiss();
                        }
                        ExdeviceProfileUI.this.lBQ = iVar.lvE;
                        ExdeviceProfileUI.this.lBS.setAffectedUserInfo(ExdeviceProfileUI.this.lBQ);
                        AppMethodBeat.o(20020);
                    }
                });
                ExdeviceProfileUI.this.lBR = iVar.lvD;
                ExdeviceProfileUI.this.lCb = iVar.lvz;
                ExdeviceProfileUI.this.lCc = iVar.lvA;
                ExdeviceProfileUI.this.lCd = ExdeviceProfileUI.bz(iVar.lvB);
                ExdeviceProfileUI.this.lBu = iVar.lvH;
                ExdeviceProfileUI.this.lBy = iVar.lvG;
                ExdeviceProfileUI.this.lCf = iVar.lvF;
                ExdeviceProfileUI.this.lCg = iVar.lvI;
                ExdeviceProfileUI.this.lvJ = iVar.lvJ;
                ExdeviceProfileUI.this.lvw = iVar.lvw;
                ExdeviceProfileUI.this.runOnUiThread(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(20021);
                        ExdeviceProfileUI.g(ExdeviceProfileUI.this);
                        AppMethodBeat.o(20021);
                    }
                });
                if (!ExdeviceProfileUI.this.lBt) {
                    ExdeviceProfileUI exdeviceProfileUI = ExdeviceProfileUI.this;
                    ExdeviceProfileUI.this.lBu;
                    ExdeviceProfileUI.j(exdeviceProfileUI);
                }
                ExdeviceProfileUI.this.runOnUiThread(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(20022);
                        ExdeviceProfileUI.k(ExdeviceProfileUI.this);
                        ExdeviceProfileUI.this.lBY.notifyDataSetChanged();
                        AppMethodBeat.o(20022);
                    }
                });
                ExdeviceProfileUI.m(ExdeviceProfileUI.this);
                ExdeviceProfileUI.b(ExdeviceProfileUI.this);
                AppMethodBeat.o(20023);
                return;
            }
            AppMethodBeat.o(20023);
        }
    };
    private d lCi = new d() {
        public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
            AppMethodBeat.i(20057);
            switch (menuItem.getItemId()) {
                case 0:
                    com.tencent.mm.plugin.sport.a.d.kT(26);
                    ExdeviceProfileUI.s(ExdeviceProfileUI.this);
                    AppMethodBeat.o(20057);
                    return;
                case 1:
                    com.tencent.mm.plugin.sport.a.d.kT(27);
                    ExdeviceProfileUI.r(ExdeviceProfileUI.this);
                    AppMethodBeat.o(20057);
                    return;
                case 2:
                    ExdeviceProfileUI.t(ExdeviceProfileUI.this);
                    AppMethodBeat.o(20057);
                    return;
                case 3:
                    h.a(ExdeviceProfileUI.this.mController.ylL, ExdeviceProfileUI.this.getString(R.string.bih), null, true, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.i(20056);
                            aw.ZK();
                            ad aoO = com.tencent.mm.model.c.XM().aoO(ExdeviceProfileUI.this.igi);
                            com.tencent.mm.plugin.sport.a.d.kT(37);
                            t.g(aoO);
                            ExdeviceProfileUI.this.lCr.dnU();
                            if (ExdeviceProfileUI.this.lzK != null) {
                                ExdeviceProfileUI.this.lzK.show();
                            }
                            AppMethodBeat.o(20056);
                        }
                    }, null);
                    AppMethodBeat.o(20057);
                    return;
                case 4:
                    ExdeviceProfileUI.this.lvJ = true;
                    com.tencent.mm.plugin.sport.a.d.kT(10);
                    com.tencent.mm.plugin.exdevice.model.ad.bpe();
                    com.tencent.mm.plugin.exdevice.f.b.c.d("", ExdeviceProfileUI.this.mAppName, ExdeviceProfileUI.this.igi, 3);
                    AppMethodBeat.o(20057);
                    return;
                case 5:
                    com.tencent.mm.plugin.sport.a.d.kT(41);
                    Intent intent = new Intent();
                    intent.putExtra("rawUrl", ExdeviceProfileUI.this.lvw);
                    com.tencent.mm.bp.d.b(ExdeviceProfileUI.this, "webview", ".ui.tools.WebViewUI", intent);
                    break;
            }
            AppMethodBeat.o(20057);
        }
    };
    private b<com.tencent.mm.plugin.exdevice.f.a.h> lCj = new b<com.tencent.mm.plugin.exdevice.f.a.h>() {
        public final /* synthetic */ void a(int i, int i2, String str, m mVar) {
            AppMethodBeat.i(20059);
            ab.i("MicroMsg.Sport.ExdeviceProfileUI", "on NetSceneDelFollow end,errType:" + i + "  errCode:" + i2 + "  errMsg:" + str);
            if (i == 0 && i2 == 0) {
                ExdeviceProfileUI.this.finish();
            }
            AppMethodBeat.o(20059);
        }
    };
    private b<g> lCk = new b<g>() {
        public final /* synthetic */ void a(int i, int i2, String str, m mVar) {
            AppMethodBeat.i(20024);
            ab.i("MicroMsg.Sport.ExdeviceProfileUI", "on NetSceneAddFollow end,errType:" + i + "  errCode:" + i2 + "  errMsg:" + str);
            if (i == 0 && i2 == 0) {
                ExdeviceProfileUI.this.finish();
            }
            AppMethodBeat.o(20024);
        }
    };
    private Runnable lCm = new Runnable() {
        public final void run() {
            AppMethodBeat.i(20036);
            BackwardSupportUtil.c.a(ExdeviceProfileUI.this.lBU);
            if (ExdeviceProfileUI.this.lBU.getCount() > 0) {
                BackwardSupportUtil.c.b(ExdeviceProfileUI.this.lBU, ExdeviceProfileUI.this.lBU.getCount() - 1);
            }
            AppMethodBeat.o(20036);
        }
    };
    private b<g> lCn = new b<g>() {
        public final /* synthetic */ void a(int i, int i2, String str, m mVar) {
            AppMethodBeat.i(20038);
            if (i == 0 && i2 == 0) {
                ExdeviceProfileUI.m(ExdeviceProfileUI.this);
                ExdeviceProfileUI.b(ExdeviceProfileUI.this);
                ExdeviceProfileUI.this.runOnUiThread(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(20037);
                        if (ExdeviceProfileUI.this.lzK != null) {
                            ExdeviceProfileUI.this.lzK.dismiss();
                        }
                        AppMethodBeat.o(20037);
                    }
                });
            }
            AppMethodBeat.o(20038);
        }
    };
    private List<String> lCo;
    private b<k> lCp = new b<k>() {
        public final /* synthetic */ void a(int i, int i2, String str, m mVar) {
            AppMethodBeat.i(20041);
            k kVar = (k) mVar;
            if (i == 0 && i2 == 0) {
                ExdeviceProfileUI.this.lCo = kVar.lwb;
                ExdeviceProfileUI.this.lvZ = kVar.lvZ;
                ExdeviceProfileUI.this.lwa = kVar.lwa;
                ExdeviceProfileUI.this.runOnUiThread(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(20040);
                        if (ExdeviceProfileUI.this.lzK != null) {
                            ExdeviceProfileUI.this.lzK.dismiss();
                        }
                        AppMethodBeat.o(20040);
                    }
                });
                ExdeviceProfileUI.E(ExdeviceProfileUI.this);
            }
            AppMethodBeat.o(20041);
        }
    };
    private k lCq;
    private com.tencent.mm.sdk.b.c<mc> lCr = new com.tencent.mm.sdk.b.c<mc>() {
        {
            AppMethodBeat.i(20045);
            this.xxI = mc.class.getName().hashCode();
            AppMethodBeat.o(20045);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(20046);
            mc mcVar = (mc) bVar;
            ab.i("MicroMsg.Sport.ExdeviceProfileUI", "count: %d ret: %s title: %s content: %s", Integer.valueOf(mcVar.cHU.count), Integer.valueOf(mcVar.cHU.ret), mcVar.cHU.cHV, mcVar.cHU.cHW);
            if (ExdeviceProfileUI.this.lzK != null && ExdeviceProfileUI.this.lzK.isShowing()) {
                ExdeviceProfileUI.this.lzK.dismiss();
            }
            ExdeviceProfileUI.this.lCr.dead();
            Intent intent = new Intent();
            intent.putExtra("KeyNeedUpdateRank", true);
            ExdeviceProfileUI.this.setResult(-1, intent);
            ExdeviceProfileUI.this.finish();
            AppMethodBeat.o(20046);
            return false;
        }
    };
    private GestureDetector lCs;
    private com.tencent.mm.ui.base.MMPullDownView.a lCt = new com.tencent.mm.ui.base.MMPullDownView.a() {
        public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            AppMethodBeat.i(20051);
            boolean onTouchEvent = ExdeviceProfileUI.this.lCs.onTouchEvent(motionEvent);
            AppMethodBeat.o(20051);
            return onTouchEvent;
        }
    };
    private boolean lvJ;
    private List<String> lvZ;
    private String lvw;
    private List<String> lwa;
    private p lzK = null;
    private String mAppName;
    private Context mContext;
    private TextPaint oz = new TextPaint(1);

    class a extends SimpleOnGestureListener {
        private a() {
        }

        /* synthetic */ a(ExdeviceProfileUI exdeviceProfileUI, byte b) {
            this();
        }

        public final boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            AppMethodBeat.i(20060);
            if (Math.abs(f2) < Math.abs(f)) {
                AppMethodBeat.o(20060);
                return true;
            }
            AppMethodBeat.o(20060);
            return false;
        }

        public final boolean onSingleTapUp(MotionEvent motionEvent) {
            return true;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public ExdeviceProfileUI() {
        AppMethodBeat.i(20061);
        AppMethodBeat.o(20061);
    }

    static /* synthetic */ void C(ExdeviceProfileUI exdeviceProfileUI) {
        AppMethodBeat.i(20087);
        exdeviceProfileUI.bpP();
        AppMethodBeat.o(20087);
    }

    static /* synthetic */ void D(ExdeviceProfileUI exdeviceProfileUI) {
        AppMethodBeat.i(20088);
        exdeviceProfileUI.bpQ();
        AppMethodBeat.o(20088);
    }

    static /* synthetic */ void a(ExdeviceProfileUI exdeviceProfileUI, long j, long j2) {
        AppMethodBeat.i(20091);
        exdeviceProfileUI.I(j, j2);
        AppMethodBeat.o(20091);
    }

    static /* synthetic */ void b(ExdeviceProfileUI exdeviceProfileUI) {
        AppMethodBeat.i(20076);
        exdeviceProfileUI.bpN();
        AppMethodBeat.o(20076);
    }

    static /* synthetic */ void j(ExdeviceProfileUI exdeviceProfileUI) {
        AppMethodBeat.i(20079);
        exdeviceProfileUI.bpO();
        AppMethodBeat.o(20079);
    }

    static /* synthetic */ void m(ExdeviceProfileUI exdeviceProfileUI) {
        AppMethodBeat.i(20081);
        exdeviceProfileUI.bpM();
        AppMethodBeat.o(20081);
    }

    public void onCreate(Bundle bundle) {
        int dimensionPixelSize;
        CharSequence string;
        AppMethodBeat.i(20062);
        super.onCreate(bundle);
        this.mContext = this.mController.ylL;
        Intent intent = getIntent();
        bpM();
        this.igi = intent.getStringExtra("username");
        this.lBO = intent.getStringExtra("usernickname");
        String Yz = r.Yz();
        if (Yz != null) {
            this.lBt = Yz.equals(this.igi);
        }
        this.mAppName = getIntent().getStringExtra("app_username");
        this.lBu = com.tencent.mm.plugin.exdevice.model.ad.boY().Kp(this.igi);
        ab.d("MicroMsg.Sport.ExdeviceProfileUI", "is follow %s", Boolean.valueOf(this.lBu));
        Assert.assertTrue(!bo.isNullOrNil(this.igi));
        this.lBP = com.tencent.mm.plugin.exdevice.model.ad.bpa().Kr(this.igi);
        this.lBQ = getIntent().getStringArrayListExtra("key_affected_semi");
        getString(R.string.tz);
        this.lzK = h.b(this, getString(R.string.cn5), new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(20026);
                if (ExdeviceProfileUI.this.lzK != null) {
                    ExdeviceProfileUI.this.lzK.dismiss();
                    ExdeviceProfileUI.this.lzK = null;
                }
                ExdeviceProfileUI.this.finish();
                AppMethodBeat.o(20026);
            }
        });
        this.lBS = (ExdeviceProfileAffectedUserView) findViewById(R.id.bkd);
        this.lBT = (ImageView) findViewById(R.id.bka);
        this.lBU = (ListView) findViewById(R.id.bkc);
        MMPullDownView mMPullDownView = (MMPullDownView) findViewById(R.id.b64);
        this.lBS.setAffectedUserInfo(this.lBQ);
        bpQ();
        this.lBZ = findViewById(R.id.bkb);
        this.lCs = new GestureDetector(this.mController.ylL, new a(this, (byte) 0));
        mMPullDownView.setIsBottomShowAll(false);
        mMPullDownView.setTopViewVisible(false);
        mMPullDownView.setBottomViewVisible(false);
        mMPullDownView.setIsBottomShowAll(false);
        mMPullDownView.setIsTopShowAll(false);
        mMPullDownView.setCanOverScrool(true);
        mMPullDownView.setOnInterceptTouchEventListener(this.lCt);
        mMPullDownView.setAtBottomCallBack(new MMPullDownView.c() {
            public final boolean bhm() {
                AppMethodBeat.i(20027);
                View childAt = ExdeviceProfileUI.this.lBU.getChildAt(ExdeviceProfileUI.this.lBU.getChildCount() - 1);
                int count = ExdeviceProfileUI.this.lBU.getAdapter().getCount();
                if (count <= 0 || childAt == null || childAt.getBottom() > ExdeviceProfileUI.this.lBU.getHeight() || ExdeviceProfileUI.this.lBU.getLastVisiblePosition() < count - 1) {
                    AppMethodBeat.o(20027);
                    return false;
                }
                AppMethodBeat.o(20027);
                return true;
            }
        });
        mMPullDownView.setAtTopCallBack(new MMPullDownView.d() {
            public final boolean bhl() {
                AppMethodBeat.i(20028);
                if (ExdeviceProfileUI.this.lBU.getFirstVisiblePosition() == 0) {
                    View childAt = ExdeviceProfileUI.this.lBU.getChildAt(ExdeviceProfileUI.this.lBU.getFirstVisiblePosition());
                    if (childAt != null && childAt.getTop() >= 0) {
                        AppMethodBeat.o(20028);
                        return true;
                    }
                }
                AppMethodBeat.o(20028);
                return false;
            }
        });
        mMPullDownView.setOnBottomLoadDataListener(new MMPullDownView.e() {
            public final boolean bhk() {
                return true;
            }
        });
        mMPullDownView.setOnScrollChangedListener(new MMPullDownView.b() {
            public final void bpT() {
                AppMethodBeat.i(20029);
                ExdeviceProfileUI.A(ExdeviceProfileUI.this);
                AppMethodBeat.o(20029);
            }
        });
        ExdeviceProfileListHeader exdeviceProfileListHeader = new ExdeviceProfileListHeader(this);
        int J = com.tencent.mm.plugin.exdevice.j.b.J(this, getResources().getDimensionPixelSize(R.dimen.gt));
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        if (displayMetrics.widthPixels > displayMetrics.heightPixels) {
            dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.fc);
        } else {
            dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.fd);
        }
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.h3);
        int dimensionPixelSize3 = getResources().getDimensionPixelSize(R.dimen.h2);
        Display defaultDisplay = getWindowManager().getDefaultDisplay();
        dimensionPixelSize2 = ((((defaultDisplay.getHeight() / 2) - J) - dimensionPixelSize) - (dimensionPixelSize2 / 2)) - dimensionPixelSize3;
        if (defaultDisplay.getHeight() <= 0 || dimensionPixelSize2 <= 0) {
            dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.gn);
        }
        exdeviceProfileListHeader.setMinimumHeight(dimensionPixelSize2);
        exdeviceProfileListHeader.setMinimumWidth(defaultDisplay.getWidth());
        exdeviceProfileListHeader.setTag(Integer.valueOf(((defaultDisplay.getHeight() / 2) - J) - dimensionPixelSize));
        this.lBV = exdeviceProfileListHeader;
        this.lBU.addHeaderView(this.lBV, null, false);
        this.lBY = new a(this.mController.ylL, this.mAppName, this.lBt, this.igi);
        this.lBY.lBs = this;
        this.lBU.setAdapter(this.lBY);
        this.lBU.setOnScrollListener(new OnScrollListener() {
            public final void onScrollStateChanged(AbsListView absListView, int i) {
            }

            public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
                AppMethodBeat.i(20030);
                ExdeviceProfileUI.A(ExdeviceProfileUI.this);
                AppMethodBeat.o(20030);
            }
        });
        this.lBS.setUsername(this.igi);
        this.lBZ.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(20031);
                com.tencent.mm.plugin.exdevice.f.a.e.e(ExdeviceProfileUI.this);
                AppMethodBeat.o(20031);
            }
        });
        mMPullDownView.setCanOverScrool(false);
        this.lBT.setLayoutParams(new LayoutParams(com.tencent.mm.bz.a.gd(this), ((Integer) this.lBV.getTag()).intValue()));
        bpP();
        com.tencent.mm.plugin.exdevice.model.ad.bpf().a(this);
        aw.Rg().a(new i(this.igi, bo.nullAsNil(this.mAppName), this.lCh), 0);
        try {
            this.eOf = getResources().getDimensionPixelSize(R.dimen.hb);
            if (this.eOf <= 0) {
                this.eOf = 60;
            }
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.Sport.ExdeviceProfileUI", e, "", new Object[0]);
            if (this.eOf <= 0) {
                this.eOf = 60;
            }
        } catch (Throwable th) {
            if (this.eOf <= 0) {
                this.eOf = 60;
            }
            AppMethodBeat.o(20062);
        }
        ab.d("MicroMsg.Sport.ExdeviceProfileUI", "ap: ellipsizeWidth: %s", Integer.valueOf(this.eOf));
        if (this.lBt) {
            string = getString(R.string.bhg);
        } else {
            Object[] objArr = new Object[1];
            Yz = this.igi;
            int i = this.eOf;
            CharSequence mJ = s.mJ(Yz);
            if (!Yz.equalsIgnoreCase(mJ) || bo.isNullOrNil(this.lBO)) {
                string = j.b(this.mController.ylL, mJ);
            } else {
                string = j.b(this.mController.ylL, this.lBO);
            }
            ab.d("MicroMsg.Sport.ExdeviceProfileUI", " width: %d, ap: username %s, ellipseize username %s", Integer.valueOf(i), string, TextUtils.ellipsize(string, this.oz, (float) i, TruncateAt.END));
            objArr[0] = mJ;
            string = j.b((Context) this, getString(R.string.bhk, objArr));
        }
        M(string);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(20055);
                ExdeviceProfileUI.this.finish();
                AppMethodBeat.o(20055);
                return false;
            }
        });
        ab.i("MicroMsg.Sport.ExdeviceProfileUI", "mUsername:" + this.igi);
        if (r.Yz().equals(this.igi)) {
            com.tencent.mm.sdk.b.b sdVar = new sd();
            sdVar.cOe.action = 3;
            com.tencent.mm.sdk.b.a.xxA.a(sdVar, com.tencent.mm.sdk.g.d.xDG.cin());
        }
        AppMethodBeat.o(20062);
    }

    private void bpM() {
        AppMethodBeat.i(20063);
        this.lCe = com.tencent.mm.plugin.exdevice.model.ad.boY().bpk();
        if (this.lCe != null) {
            ab.d("MicroMsg.Sport.ExdeviceProfileUI", "ap: follow size:%s, %s", Integer.valueOf(this.lCe.size()), this.lCe.toString());
        } else {
            ab.d("MicroMsg.Sport.ExdeviceProfileUI", "ap: follow is null");
        }
        if (bo.ek(this.lCe)) {
            this.lBv = 0;
            AppMethodBeat.o(20063);
            return;
        }
        this.lBv = this.lCe.size();
        AppMethodBeat.o(20063);
    }

    private void bpN() {
        AppMethodBeat.i(20064);
        runOnUiThread(new Runnable() {
            public final void run() {
                AppMethodBeat.i(20054);
                a l = ExdeviceProfileUI.this.lBY;
                ArrayList p = ExdeviceProfileUI.this.lCe;
                List q = ExdeviceProfileUI.this.lBy;
                l.lBu = com.tencent.mm.plugin.exdevice.model.ad.boY().Kp(l.igi);
                l.lBx = p;
                if (bo.ek(p)) {
                    l.lBv = 0;
                } else {
                    l.lBv = p.size();
                }
                l.lBy = q;
                if (!bo.ek(q)) {
                    l.lBw = q.size();
                }
                ab.d("MicroMsg.ExdeviceProfileAdapter", "setData,mIsFollower:%s ,mFollowersNum:%s  ,mButtonNum:%s ,mUsername:%s", Boolean.valueOf(l.lBu), Integer.valueOf(l.lBv), Integer.valueOf(l.lBw), l.igi);
                ExdeviceProfileUI.this.lBY.notifyDataSetChanged();
                AppMethodBeat.o(20054);
            }
        });
        AppMethodBeat.o(20064);
    }

    public void onPause() {
        AppMethodBeat.i(20065);
        super.onPause();
        AppMethodBeat.o(20065);
    }

    public void onResume() {
        AppMethodBeat.i(20066);
        super.onResume();
        ab.v("MicroMsg.Sport.ExdeviceProfileUI", "ExdeviceProfileUI: onResume");
        bpM();
        bpN();
        if (!this.lBt) {
            com.tencent.mm.plugin.exdevice.model.ad.boY().Kp(this.igi);
            bpO();
        }
        AppMethodBeat.o(20066);
    }

    private void bpO() {
        AppMethodBeat.i(20067);
        runOnUiThread(new Runnable() {
            public final void run() {
                AppMethodBeat.i(20025);
                ExdeviceProfileUI.g(ExdeviceProfileUI.this);
                ExdeviceProfileUI.this.lBY.notifyDataSetChanged();
                AppMethodBeat.o(20025);
            }
        });
        AppMethodBeat.o(20067);
    }

    public void onDestroy() {
        AppMethodBeat.i(20068);
        if (this.lCq != null) {
            aw.Rg().c(this.lCq);
        }
        this.lCr.dead();
        this.UP = true;
        super.onDestroy();
        com.tencent.mm.plugin.exdevice.model.ad.bpf().b(this);
        AppMethodBeat.o(20068);
    }

    private void bpP() {
        AppMethodBeat.i(20069);
        String Yz = r.Yz();
        if (this.lBZ != null) {
            this.lBZ.setVisibility(8);
        }
        if (!bo.isNullOrNil(Yz) && Yz.equals(this.igi)) {
            if (!(this.lBP == null || !bo.isNullOrNil(this.lBP.field_championUrl) || this.lBZ == null)) {
                this.lBZ.setVisibility(0);
            }
            if (this.lBV != null) {
                this.lBV.setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View view) {
                        AppMethodBeat.i(20032);
                        com.tencent.mm.plugin.sport.a.d.kT(18);
                        com.tencent.mm.plugin.exdevice.f.a.e.e(ExdeviceProfileUI.this);
                        AppMethodBeat.o(20032);
                    }
                });
                AppMethodBeat.o(20069);
                return;
            }
        } else if (!(this.lBP == null || bo.isNullOrNil(this.lBP.field_championUrl) || this.lBV == null)) {
            this.lBV.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(20035);
                    ExdeviceProfileUI.B(ExdeviceProfileUI.this);
                    AppMethodBeat.o(20035);
                }
            });
        }
        AppMethodBeat.o(20069);
    }

    private void bpQ() {
        AppMethodBeat.i(20070);
        if (this.lBP == null) {
            this.lBT.setImageResource(R.color.le);
            this.hZn = null;
        } else if (this.hZn != this.lBP.field_championUrl && (this.hZn == null || !this.hZn.equals(this.lBP.field_championUrl))) {
            com.tencent.mm.plugin.exdevice.f.a.e.a(this, this.lBT, this.lBP.field_championUrl);
            this.hZn = this.lBP.field_championUrl;
            AppMethodBeat.o(20070);
            return;
        }
        AppMethodBeat.o(20070);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(20071);
        super.onActivityResult(i, i2, intent);
        if (com.tencent.mm.plugin.exdevice.f.a.e.a(this, i, i2, intent, this.mAppName)) {
            AppMethodBeat.o(20071);
            return;
        }
        switch (i) {
            case 1:
                if (i2 == -1) {
                    String str;
                    if (intent == null) {
                        str = null;
                    } else {
                        str = intent.getStringExtra("Select_Conv_User");
                    }
                    String dG = ac.dG(this);
                    if (str == null || str.length() == 0) {
                        ab.e("MicroMsg.Sport.ExdeviceProfileUI", "select conversation failed, toUser is null.");
                        AppMethodBeat.o(20071);
                        return;
                    }
                    ac.a((Context) this, str, dG, intent.getStringExtra("custom_send_text"), this.lCc);
                    h.bQ(this.mController.ylL, getResources().getString(R.string.to));
                    AppMethodBeat.o(20071);
                    return;
                }
                break;
            case 2:
                if (i2 == -1) {
                    Toast.makeText(this, R.string.egv, 1).show();
                    AppMethodBeat.o(20071);
                    return;
                }
                break;
            case 3:
                if (i2 == -1) {
                    ArrayList P = bo.P(intent.getStringExtra("Select_Contact").split(","));
                    if (P != null) {
                        if (this.lzK != null) {
                            this.lzK.show();
                        }
                        aw.Rg().a(new g(P, this.lCn), 0);
                        break;
                    }
                    AppMethodBeat.o(20071);
                    return;
                }
                break;
        }
        AppMethodBeat.o(20071);
    }

    public final int getLayoutId() {
        return R.layout.we;
    }

    public final void b(String str, com.tencent.mm.plugin.exdevice.f.b.d dVar) {
        AppMethodBeat.i(20072);
        if ("HardDeviceChampionInfo".equals(str) && this.igi.equals(dVar.username)) {
            ab.d("MicroMsg.Sport.ExdeviceProfileUI", "hy: url may changed. maybe reload background");
            this.lBP = com.tencent.mm.plugin.exdevice.model.ad.bpa().Kr(this.igi);
            runOnUiThread(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(20039);
                    ExdeviceProfileUI.C(ExdeviceProfileUI.this);
                    ExdeviceProfileUI.this.lBY.notifyDataSetChanged();
                    ExdeviceProfileUI.D(ExdeviceProfileUI.this);
                    AppMethodBeat.o(20039);
                }
            });
        }
        AppMethodBeat.o(20072);
    }

    private void I(long j, long j2) {
        AppMethodBeat.i(20075);
        List<com.tencent.mm.plugin.sport.a.e> V = ((com.tencent.mm.plugin.sport.a.b) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.sport.a.b.class)).V(j, j2);
        HashSet hashSet = new HashSet();
        ArrayList arrayList = new ArrayList();
        if (this.lCd != null) {
            for (com.tencent.mm.plugin.sport.a.e eVar : this.lCd) {
                if (hashSet.add(eVar.field_date)) {
                    arrayList.add(eVar);
                }
            }
        }
        for (com.tencent.mm.plugin.sport.a.e eVar2 : V) {
            if (hashSet.add(eVar2.field_date)) {
                arrayList.add(eVar2);
            }
        }
        Collections.sort(arrayList);
        this.lCd = arrayList;
        if (this.lBX != null) {
            this.lBX.dD(this.lCd);
        }
        AppMethodBeat.o(20075);
    }

    public final void bpR() {
        AppMethodBeat.i(20073);
        runOnUiThread(new Runnable() {
            public final void run() {
                AppMethodBeat.i(20042);
                if (ExdeviceProfileUI.this.lzK != null) {
                    ExdeviceProfileUI.this.lzK.show();
                }
                AppMethodBeat.o(20042);
            }
        });
        if (this.lCq != null) {
            aw.Rg().c(this.lCq);
        }
        this.lCq = new k(this.lCp);
        aw.Rg().a(this.lCq, 0);
        AppMethodBeat.o(20073);
    }

    public final void bpS() {
        AppMethodBeat.i(20074);
        com.tencent.mm.plugin.sport.a.d.kT(17);
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.igi);
        aw.Rg().a(new g(arrayList, this.lCk), 0);
        AppMethodBeat.o(20074);
    }

    static /* synthetic */ List bz(List list) {
        AppMethodBeat.i(20077);
        ArrayList arrayList = new ArrayList();
        for (cdo cdo : list) {
            com.tencent.mm.plugin.sport.a.e eVar = new com.tencent.mm.plugin.sport.a.e();
            eVar.field_step = cdo.hzv;
            eVar.field_timestamp = ((long) cdo.timestamp) * 1000;
            eVar.field_date = new SimpleDateFormat("yyyy-MM-dd").format(new Date(eVar.field_timestamp));
            arrayList.add(eVar);
        }
        AppMethodBeat.o(20077);
        return arrayList;
    }

    static /* synthetic */ void g(ExdeviceProfileUI exdeviceProfileUI) {
        AppMethodBeat.i(20078);
        exdeviceProfileUI.mController.removeAllOptionMenu();
        if (r.Yz().equals(exdeviceProfileUI.igi)) {
            exdeviceProfileUI.addIconOptionMenu(0, R.drawable.uu, new OnMenuItemClickListener() {
                public final boolean onMenuItemClick(MenuItem menuItem) {
                    AppMethodBeat.i(20034);
                    com.tencent.mm.ui.widget.a.d dVar = new com.tencent.mm.ui.widget.a.d(ExdeviceProfileUI.this.mController.ylL, 1, false);
                    dVar.rBl = new n.c() {
                        public final void a(l lVar) {
                            AppMethodBeat.i(20033);
                            lVar.a(0, ExdeviceProfileUI.this.getString(R.string.bh2), (int) R.raw.bottomsheet_icon_transmit);
                            lVar.a(1, ExdeviceProfileUI.this.getString(R.string.bh5), (int) R.raw.bottomsheet_icon_moment);
                            AppMethodBeat.o(20033);
                        }
                    };
                    dVar.rBm = ExdeviceProfileUI.this.lCi;
                    dVar.cpD();
                    AppMethodBeat.o(20034);
                    return true;
                }
            });
            AppMethodBeat.o(20078);
            return;
        }
        aw.ZK();
        boolean aoJ = com.tencent.mm.model.c.XM().aoJ(exdeviceProfileUI.igi);
        aw.ZK();
        boolean Ob = com.tencent.mm.model.c.XM().aoO(exdeviceProfileUI.igi).Ob();
        if (exdeviceProfileUI.lBu && aoJ) {
            exdeviceProfileUI.addIconOptionMenu(0, R.drawable.uu, new OnMenuItemClickListener() {
                public final boolean onMenuItemClick(MenuItem menuItem) {
                    AppMethodBeat.i(20049);
                    com.tencent.mm.ui.widget.a.d dVar = new com.tencent.mm.ui.widget.a.d(ExdeviceProfileUI.this.mController.ylL, 1, false);
                    dVar.rBl = new n.c() {
                        public final void a(l lVar) {
                            AppMethodBeat.i(20048);
                            lVar.e(2, ExdeviceProfileUI.this.getString(R.string.bhb));
                            AppMethodBeat.o(20048);
                        }
                    };
                    dVar.rBm = ExdeviceProfileUI.this.lCi;
                    dVar.cpD();
                    AppMethodBeat.o(20049);
                    return true;
                }
            });
            AppMethodBeat.o(20078);
            return;
        }
        if (!Ob) {
            exdeviceProfileUI.addIconOptionMenu(0, R.drawable.uu, new OnMenuItemClickListener() {
                public final boolean onMenuItemClick(MenuItem menuItem) {
                    AppMethodBeat.i(20053);
                    com.tencent.mm.ui.widget.a.d dVar = new com.tencent.mm.ui.widget.a.d(ExdeviceProfileUI.this.mController.ylL, 1, false);
                    dVar.rBl = new n.c() {
                        public final void a(l lVar) {
                            AppMethodBeat.i(20052);
                            if (!bo.isNullOrNil(ExdeviceProfileUI.this.lvw)) {
                                lVar.e(5, ExdeviceProfileUI.this.getString(R.string.bha));
                            }
                            lVar.e(3, ExdeviceProfileUI.this.getString(R.string.bh7));
                            AppMethodBeat.o(20052);
                        }
                    };
                    dVar.rBm = ExdeviceProfileUI.this.lCi;
                    dVar.cpD();
                    AppMethodBeat.o(20053);
                    return true;
                }
            });
        }
        AppMethodBeat.o(20078);
    }

    static /* synthetic */ void k(ExdeviceProfileUI exdeviceProfileUI) {
        AppMethodBeat.i(20080);
        if (exdeviceProfileUI.lBX == null) {
            exdeviceProfileUI.lBX = (SportChartView) exdeviceProfileUI.findViewById(R.id.bk6);
        }
        if (exdeviceProfileUI.lBX != null) {
            if (exdeviceProfileUI.lBW == null) {
                exdeviceProfileUI.lBW = (MMSwitchBtn) exdeviceProfileUI.findViewById(R.id.bk7);
            }
            if (exdeviceProfileUI.lCd == null || exdeviceProfileUI.lCd.size() <= 0) {
                exdeviceProfileUI.lBX.setHasSwitchBtn(false);
                exdeviceProfileUI.lBW.setVisibility(8);
                exdeviceProfileUI.lBX.dD(null);
            } else {
                if (exdeviceProfileUI.lBt) {
                    exdeviceProfileUI.lBX.setHasSwitchBtn(true);
                    exdeviceProfileUI.lBW.setVisibility(0);
                    exdeviceProfileUI.lBW.setSwitchListener(new com.tencent.mm.ui.widget.MMSwitchBtn.a() {
                        public final void di(boolean z) {
                            AppMethodBeat.i(20047);
                            if (ExdeviceProfileUI.this.lCd != null) {
                                if (z) {
                                    ExdeviceProfileUI.this.lBX.a(com.tencent.mm.plugin.sport.ui.SportChartView.a.MONTH);
                                } else {
                                    ExdeviceProfileUI.this.lBX.a(com.tencent.mm.plugin.sport.ui.SportChartView.a.WEEK);
                                }
                            }
                            ExdeviceProfileUI.this.lBX.dD(ExdeviceProfileUI.this.lCd);
                            AppMethodBeat.o(20047);
                        }
                    });
                } else {
                    exdeviceProfileUI.lBX.setHasSwitchBtn(false);
                    exdeviceProfileUI.lBW.setVisibility(8);
                    exdeviceProfileUI.lBX.a(com.tencent.mm.plugin.sport.ui.SportChartView.a.WEEK);
                    exdeviceProfileUI.lBX.dD(exdeviceProfileUI.lCd);
                }
                exdeviceProfileUI.lBX.setTodayStep(((com.tencent.mm.plugin.sport.a.e) exdeviceProfileUI.lCd.get(exdeviceProfileUI.lCd.size() - 1)).field_step);
                exdeviceProfileUI.lBX.dD(exdeviceProfileUI.lCd);
                com.tencent.mm.plugin.sport.a.e cwb = ((com.tencent.mm.plugin.sport.a.b) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.sport.a.b.class)).cwb();
                Calendar instance = Calendar.getInstance();
                instance.add(5, -1);
                instance.set(10, 23);
                instance.set(12, 59);
                instance.set(13, 59);
                final long timeInMillis = instance.getTimeInMillis();
                instance.add(5, -120);
                instance.set(10, 0);
                instance.set(12, 0);
                instance.set(13, 0);
                final long timeInMillis2 = instance.getTimeInMillis();
                if (cwb != null) {
                    instance.setTimeInMillis(cwb.field_timestamp);
                    instance.add(5, 2);
                    if (instance.getTimeInMillis() > timeInMillis) {
                        exdeviceProfileUI.I(timeInMillis2, timeInMillis);
                        AppMethodBeat.o(20080);
                        return;
                    }
                }
                ((com.tencent.mm.plugin.sport.a.b) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.sport.a.b.class)).a(timeInMillis2, timeInMillis, new com.tencent.mm.plugin.sport.a.c() {
                    public final void wL() {
                        AppMethodBeat.i(20050);
                        ExdeviceProfileUI.a(ExdeviceProfileUI.this, timeInMillis2, timeInMillis);
                        AppMethodBeat.o(20050);
                    }
                });
                AppMethodBeat.o(20080);
                return;
            }
        }
        AppMethodBeat.o(20080);
    }

    static /* synthetic */ void r(ExdeviceProfileUI exdeviceProfileUI) {
        AppMethodBeat.i(20082);
        ac acVar = new ac();
        String valueOf = String.valueOf(exdeviceProfileUI.lCg);
        String str = AppEventsConstants.EVENT_PARAM_VALUE_NO;
        if (exdeviceProfileUI.lBR != null) {
            str = String.valueOf(exdeviceProfileUI.lBR.score);
        }
        acVar.a((Context) exdeviceProfileUI, valueOf, str, exdeviceProfileUI.hZn, new com.tencent.mm.plugin.exdevice.model.ac.a() {
            public final void Kj(String str) {
                AppMethodBeat.i(20043);
                Intent intent = new Intent();
                intent.putExtra("Ksnsupload_appid", "wx7fa037cc7dfabad5");
                intent.putExtra("Ksnsupload_appname", ExdeviceProfileUI.this.getString(R.string.bij));
                intent.putExtra("Ksnsupload_source", 1);
                intent.putExtra("need_result", true);
                String nW = v.nW("wx_sport");
                v.Zp().y(nW, true).j("prePublishId", "wx_sport");
                intent.putExtra("reportSessionId", nW);
                intent.putExtra("Ksnsupload_type", 0);
                intent.putExtra("sns_kemdia_path", str);
                com.tencent.mm.bp.d.b(ExdeviceProfileUI.this, "sns", ".ui.SnsUploadUI", intent, 2);
                AppMethodBeat.o(20043);
            }
        });
        AppMethodBeat.o(20082);
    }

    static /* synthetic */ void s(ExdeviceProfileUI exdeviceProfileUI) {
        AppMethodBeat.i(20083);
        String valueOf = String.valueOf(exdeviceProfileUI.lCg);
        String str = AppEventsConstants.EVENT_PARAM_VALUE_NO;
        if (exdeviceProfileUI.lBR != null) {
            str = String.valueOf(exdeviceProfileUI.lBR.score);
        }
        new ac().a((Context) exdeviceProfileUI, valueOf, str, exdeviceProfileUI.hZn, new com.tencent.mm.plugin.exdevice.model.ac.a() {
            public final void Kj(String str) {
                AppMethodBeat.i(20044);
                ExdeviceProfileUI.d(ExdeviceProfileUI.this, str);
                AppMethodBeat.o(20044);
            }
        });
        AppMethodBeat.o(20083);
    }

    static /* synthetic */ void t(ExdeviceProfileUI exdeviceProfileUI) {
        AppMethodBeat.i(20084);
        ab.i("MicroMsg.Sport.ExdeviceProfileUI", "ap: start to del: %s", exdeviceProfileUI.igi);
        aw.Rg().a(new com.tencent.mm.plugin.exdevice.f.a.h(exdeviceProfileUI.igi, exdeviceProfileUI.lCj), 0);
        AppMethodBeat.o(20084);
    }

    static /* synthetic */ void A(ExdeviceProfileUI exdeviceProfileUI) {
        AppMethodBeat.i(20085);
        if (VERSION.SDK_INT >= 11) {
            View childAt = exdeviceProfileUI.lBU.getChildAt(0);
            int[] iArr = new int[2];
            if (childAt != null && exdeviceProfileUI.lBU.getFirstVisiblePosition() == 0) {
                childAt.getLocationOnScreen(iArr);
                if (lCl == 0) {
                    lCl = iArr[1];
                }
                int i = iArr[1];
                if (i > (-lCl) / 2) {
                    float f;
                    if (i > 0) {
                        f = ((float) (i * 2)) / (((float) lCl) * 2.0f);
                    } else {
                        f = ((float) i) / ((float) lCl);
                    }
                    exdeviceProfileUI.lBS.setAlpha(f);
                    exdeviceProfileUI.lBS.setVisibility(0);
                    AppMethodBeat.o(20085);
                    return;
                }
                exdeviceProfileUI.lBS.setAlpha(0.0f);
                exdeviceProfileUI.lBS.setVisibility(8);
            }
        }
        AppMethodBeat.o(20085);
    }

    static /* synthetic */ void B(ExdeviceProfileUI exdeviceProfileUI) {
        AppMethodBeat.i(20086);
        com.tencent.mm.ui.widget.a.d dVar = new com.tencent.mm.ui.widget.a.d(exdeviceProfileUI.mController.ylL, 1, false);
        dVar.rBl = new n.c() {
            public final void a(l lVar) {
                AppMethodBeat.i(20058);
                if (ExdeviceProfileUI.this.lvJ) {
                    lVar.e(1, ExdeviceProfileUI.this.getString(R.string.bh_));
                    AppMethodBeat.o(20058);
                    return;
                }
                lVar.e(4, ExdeviceProfileUI.this.getString(R.string.bhf));
                AppMethodBeat.o(20058);
            }
        };
        dVar.rBm = exdeviceProfileUI.lCi;
        dVar.cpD();
        AppMethodBeat.o(20086);
    }

    static /* synthetic */ void E(ExdeviceProfileUI exdeviceProfileUI) {
        AppMethodBeat.i(20089);
        Intent intent = new Intent();
        String c = bo.c(exdeviceProfileUI.lCo, ",");
        intent.putExtra("wechat_sport_contact", bo.c(exdeviceProfileUI.lvZ, ","));
        intent.putExtra("wechat_sport_recent_like", c);
        c = bo.c(exdeviceProfileUI.lwa, ",");
        intent.putExtra("titile", exdeviceProfileUI.getString(R.string.bei));
        intent.putExtra("list_type", 12);
        intent.putExtra("max_limit_num", 10);
        intent.putExtra("too_many_member_tip_string", exdeviceProfileUI.getString(R.string.bel, new Object[]{Integer.valueOf(10)}));
        intent.putExtra("list_attr", com.tencent.mm.ui.contact.s.C(2, 4, 1, WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT, 128, 64, 16384));
        intent.putExtra("always_select_contact", c);
        com.tencent.mm.bp.d.b((Context) exdeviceProfileUI, ".ui.contact.SelectContactUI", intent, 3);
        AppMethodBeat.o(20089);
    }
}
