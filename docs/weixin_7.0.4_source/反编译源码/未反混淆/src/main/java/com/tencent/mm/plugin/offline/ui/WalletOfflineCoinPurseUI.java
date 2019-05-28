package com.tencent.mm.plugin.offline.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.WindowManager.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.CheckedTextView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.internal.Utility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.a.p;
import com.tencent.mm.bp.d;
import com.tencent.mm.g.a.ca;
import com.tencent.mm.g.a.cm;
import com.tencent.mm.g.a.gq;
import com.tencent.mm.g.a.lf;
import com.tencent.mm.g.a.lg;
import com.tencent.mm.g.a.lu;
import com.tencent.mm.g.a.qs;
import com.tencent.mm.g.a.uo;
import com.tencent.mm.g.a.us;
import com.tencent.mm.g.a.uv;
import com.tencent.mm.kernel.i;
import com.tencent.mm.platformtools.x;
import com.tencent.mm.plugin.offline.a.f;
import com.tencent.mm.plugin.offline.a.j;
import com.tencent.mm.plugin.offline.a.m;
import com.tencent.mm.plugin.offline.a.n;
import com.tencent.mm.plugin.offline.a.o;
import com.tencent.mm.plugin.offline.a.q;
import com.tencent.mm.plugin.offline.a.s;
import com.tencent.mm.plugin.offline.b;
import com.tencent.mm.plugin.offline.c.a;
import com.tencent.mm.plugin.offline.e;
import com.tencent.mm.plugin.offline.g;
import com.tencent.mm.plugin.offline.k;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.c.y;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.ac;
import com.tencent.mm.plugin.wallet_core.model.r;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.protocal.protobuf.aw;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bc;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.ListViewInScrollView;
import com.tencent.mm.ui.ae;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.wallet_core.c.z;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@i
public class WalletOfflineCoinPurseUI extends WalletBaseUI implements com.tencent.mm.platformtools.x.a, com.tencent.mm.plugin.offline.a.s.a, b, a, com.tencent.mm.sdk.platformtools.bc.a {
    private static int jpc = 0;
    private int emC;
    private OnClickListener gKK = new OnClickListener() {
        public final void onClick(View view) {
            AppMethodBeat.i(43521);
            if (view.getId() == R.id.fch || view.getId() == R.id.fcg || view.getId() == R.id.fcf) {
                if (view.getId() == R.id.fch && WalletOfflineCoinPurseUI.this.pah != null && WalletOfflineCoinPurseUI.this.pah.isShowing()) {
                    ab.i("MicroMsg.WalletOfflineCoinPurseUI", "offlineAlertView is showing");
                    AppMethodBeat.o(43521);
                    return;
                }
                long currentTimeMillis = System.currentTimeMillis();
                if ((WalletOfflineCoinPurseUI.this.pah == null || !WalletOfflineCoinPurseUI.this.pah.isShowing()) && currentTimeMillis - WalletOfflineCoinPurseUI.this.mLastTime >= 400 && com.tencent.mm.plugin.offline.c.a.bYd() && !WalletOfflineCoinPurseUI.v(WalletOfflineCoinPurseUI.this)) {
                    if (view.getId() == R.id.fch) {
                        WalletOfflineCoinPurseUI.this.kjx = false;
                    } else if (view.getId() == R.id.fcg || view.getId() == R.id.fcf) {
                        h.pYm.e(13958, Integer.valueOf(4));
                        WalletOfflineCoinPurseUI.this.kjx = true;
                    }
                    if (WalletOfflineCoinPurseUI.this.paf != null) {
                        WalletOfflineCoinPurseUI.x(WalletOfflineCoinPurseUI.this);
                        WalletOfflineCoinPurseUI.this.paf.G(view, WalletOfflineCoinPurseUI.this.kjx);
                    }
                    WalletOfflineCoinPurseUI.this.mLastTime = currentTimeMillis;
                }
            }
            AppMethodBeat.o(43521);
        }
    };
    private int gwj = -1;
    private boolean kXv;
    private boolean kjx = true;
    private int lTe;
    private long mLastTime = 0;
    private int mState = 3;
    private String oWS = "";
    private ap oXA = new ap(new com.tencent.mm.sdk.platformtools.ap.a() {
        public final boolean BI() {
            AppMethodBeat.i(43542);
            if (!WalletOfflineCoinPurseUI.this.oZX) {
                WalletOfflineCoinPurseUI.C(WalletOfflineCoinPurseUI.this);
                WalletOfflineCoinPurseUI.D(WalletOfflineCoinPurseUI.this);
            }
            long M = (long) WalletOfflineCoinPurseUI.this.oXz;
            WalletOfflineCoinPurseUI.this.oXA.ae(M, M);
            AppMethodBeat.o(43542);
            return false;
        }
    }, false);
    private String oXv = "";
    private m oXx;
    private int oXz = 60000;
    Bitmap oZA = null;
    private a oZB;
    private boolean oZC = false;
    private boolean oZD = false;
    private ArrayList<String> oZE = new ArrayList();
    private ArrayList<String> oZF = new ArrayList();
    private ArrayList<Boolean> oZG = new ArrayList();
    private View oZH;
    private ImageView oZI;
    private ImageView oZJ;
    private TextView oZK;
    private String oZL;
    private View oZM;
    private TextView oZN;
    private ImageView oZO;
    private RelativeLayout oZP;
    private LinearLayout oZQ;
    private LinearLayout oZR;
    private LinearLayout oZS;
    private LinearLayout oZT;
    private LinearLayout oZU;
    private Dialog oZV;
    private String oZW = "";
    private boolean oZX = false;
    private g oZY;
    private boolean oZZ = false;
    private HashMap<String, View> oZx = new HashMap();
    private HashMap<String, Integer> oZy = new HashMap();
    Bitmap oZz = null;
    private boolean paa = false;
    private boolean pab = false;
    private boolean pac = false;
    private ArrayList<Bitmap> pad = new ArrayList();
    private ArrayList<Bitmap> pae = new ArrayList();
    private c paf;
    private c pag;
    private OfflineAlertView pah;
    private boolean pai = false;
    com.tencent.mm.sdk.b.c<uv> paj = new com.tencent.mm.sdk.b.c<uv>() {
        {
            AppMethodBeat.i(43503);
            this.xxI = uv.class.getName().hashCode();
            AppMethodBeat.o(43503);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(43504);
            uv uvVar = (uv) bVar;
            com.tencent.mm.sdk.b.a.xxA.d(this);
            if (com.tencent.mm.plugin.offline.c.a.bYE() && uvVar.cRF.result == 0) {
                WalletOfflineCoinPurseUI.this.oZX = false;
            }
            AppMethodBeat.o(43504);
            return false;
        }
    };
    private com.tencent.mm.sdk.b.c<cm> pak = new com.tencent.mm.sdk.b.c<cm>() {
        {
            AppMethodBeat.i(43517);
            this.xxI = cm.class.getName().hashCode();
            AppMethodBeat.o(43517);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(43518);
            cm cmVar = (cm) bVar;
            ab.d("MicroMsg.WalletOfflineCoinPurseUI", "do offline showcode");
            k.bXg();
            k.bXi();
            com.tencent.mm.ai.m oVar = new o(e.bWZ(), WalletOfflineCoinPurseUI.this.gwj, cmVar.cvK.cvL);
            com.tencent.mm.kernel.g.RQ();
            com.tencent.mm.kernel.g.RO().eJo.a(oVar, 0);
            AppMethodBeat.o(43518);
            return false;
        }
    };
    private com.tencent.mm.sdk.b.c<lu> pal = new com.tencent.mm.sdk.b.c<lu>() {
        {
            AppMethodBeat.i(43529);
            this.xxI = lu.class.getName().hashCode();
            AppMethodBeat.o(43529);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(43530);
            ab.i("MicroMsg.WalletOfflineCoinPurseUI", " ecard finish: %s", Integer.valueOf(((lu) bVar).cHC.retCode));
            WalletOfflineCoinPurseUI.this.a(new y(null, 8), false, false);
            AppMethodBeat.o(43530);
            return false;
        }
    };
    private com.tencent.mm.sdk.b.c<lf> pam = new com.tencent.mm.sdk.b.c<lf>() {
        {
            AppMethodBeat.i(43546);
            this.xxI = lf.class.getName().hashCode();
            AppMethodBeat.o(43546);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(43547);
            WalletOfflineCoinPurseUI.this.a(new y(null, 8), false, false);
            WalletOfflineCoinPurseUI.d(WalletOfflineCoinPurseUI.this);
            WalletOfflineCoinPurseUI.e(WalletOfflineCoinPurseUI.this);
            WalletOfflineCoinPurseUI.f(WalletOfflineCoinPurseUI.this);
            AppMethodBeat.o(43547);
            return false;
        }
    };
    private com.tencent.mm.sdk.b.c<lg> pan = new com.tencent.mm.sdk.b.c<lg>() {
        {
            AppMethodBeat.i(43548);
            this.xxI = lg.class.getName().hashCode();
            AppMethodBeat.o(43548);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(43549);
            if (((lg) bVar).cHi.aBR != hashCode()) {
                ab.i("MicroMsg.WalletOfflineCoinPurseUI", "has create a new ui, finish self");
                WalletOfflineCoinPurseUI.this.finish();
            }
            AppMethodBeat.o(43549);
            return false;
        }
    };
    private com.tencent.mm.sdk.b.c pao = new com.tencent.mm.sdk.b.c<qs>() {
        {
            AppMethodBeat.i(43550);
            this.xxI = qs.class.getName().hashCode();
            AppMethodBeat.o(43550);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(43551);
            if (!WalletOfflineCoinPurseUI.this.isFinishing()) {
                WalletOfflineCoinPurseUI.this.finish();
            }
            AppMethodBeat.o(43551);
            return false;
        }
    };
    private com.tencent.mm.sdk.b.c pap = new com.tencent.mm.sdk.b.c<us>() {
        {
            AppMethodBeat.i(43552);
            this.xxI = us.class.getName().hashCode();
            AppMethodBeat.o(43552);
        }

        public final /* bridge */ /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(43553);
            us usVar = (us) bVar;
            if (usVar instanceof us) {
                WalletOfflineCoinPurseUI.a(WalletOfflineCoinPurseUI.this, usVar.cRy.cRz);
            }
            AppMethodBeat.o(43553);
            return false;
        }
    };
    private com.tencent.mm.sdk.b.c paq = new com.tencent.mm.sdk.b.c<com.tencent.mm.g.a.ap>() {
        {
            AppMethodBeat.i(43554);
            this.xxI = com.tencent.mm.g.a.ap.class.getName().hashCode();
            AppMethodBeat.o(43554);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(43555);
            com.tencent.mm.g.a.ap apVar = (com.tencent.mm.g.a.ap) bVar;
            if (com.tencent.mm.plugin.offline.c.a.pbe == 3 && (apVar instanceof com.tencent.mm.g.a.ap) && apVar.ctF.ctG) {
                ab.i("MicroMsg.WalletOfflineCoinPurseUI", "finish button event!");
                WalletOfflineCoinPurseUI.this.finish();
                AppMethodBeat.o(43555);
                return true;
            }
            AppMethodBeat.o(43555);
            return false;
        }
    };
    public boolean par = false;
    private HashMap<String, Integer> pas = new HashMap();
    private ap pat = new ap(new com.tencent.mm.sdk.platformtools.ap.a() {
        public final boolean BI() {
            AppMethodBeat.i(43543);
            WalletOfflineCoinPurseUI.this.oZX = false;
            if (WalletOfflineCoinPurseUI.this.oZV != null && WalletOfflineCoinPurseUI.this.oZV.isShowing()) {
                WalletOfflineCoinPurseUI.this.oZV.dismiss();
            }
            g.bXc();
            WalletOfflineCoinPurseUI.O(WalletOfflineCoinPurseUI.this);
            if (com.tencent.mm.plugin.offline.c.a.bYE()) {
                WalletOfflineCoinPurseUI.this.bXu();
            }
            AppMethodBeat.o(43543);
            return false;
        }
    }, false);
    private ap pau = new ap(new com.tencent.mm.sdk.platformtools.ap.a() {
        public final boolean BI() {
            AppMethodBeat.i(43545);
            ab.i("MicroMsg.WalletOfflineCoinPurseUI", "onTimerExpired, send ConsumedCardByOfflinePay event: %s", Boolean.valueOf(WalletOfflineCoinPurseUI.this.kXv));
            if (WalletOfflineCoinPurseUI.this.kXv) {
                ca caVar = new ca();
                caVar.cvj.bFZ = 0;
                com.tencent.mm.sdk.b.a.xxA.m(caVar);
            }
            WalletOfflineCoinPurseUI.this.finish();
            AppMethodBeat.o(43545);
            return false;
        }
    }, false);

    class a extends BaseAdapter {
        ArrayList<String> iPr = new ArrayList();
        ArrayList<Boolean> paT = new ArrayList();

        public a() {
            AppMethodBeat.i(43556);
            AppMethodBeat.o(43556);
        }

        public final int getCount() {
            AppMethodBeat.i(43557);
            int size = this.iPr.size();
            AppMethodBeat.o(43557);
            return size;
        }

        public final Object getItem(int i) {
            AppMethodBeat.i(43558);
            Object obj = this.iPr.get(i);
            AppMethodBeat.o(43558);
            return obj;
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final boolean isEnabled(int i) {
            AppMethodBeat.i(43559);
            boolean booleanValue = ((Boolean) this.paT.get(i)).booleanValue();
            AppMethodBeat.o(43559);
            return booleanValue;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            AppMethodBeat.i(43560);
            CheckedTextView checkedTextView = (CheckedTextView) View.inflate(WalletOfflineCoinPurseUI.this, R.layout.b4p, null);
            checkedTextView.setText((String) this.iPr.get(i));
            if (WalletOfflineCoinPurseUI.jpc == i) {
                checkedTextView.setChecked(true);
            } else {
                checkedTextView.setChecked(false);
            }
            if (isEnabled(i)) {
                checkedTextView.setTextColor(WalletOfflineCoinPurseUI.this.getResources().getColor(R.color.w4));
                checkedTextView.setEnabled(true);
            } else {
                checkedTextView.setTextColor(WalletOfflineCoinPurseUI.this.getResources().getColor(R.color.s0));
                checkedTextView.setEnabled(false);
            }
            AppMethodBeat.o(43560);
            return checkedTextView;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public WalletOfflineCoinPurseUI() {
        AppMethodBeat.i(43561);
        AppMethodBeat.o(43561);
    }

    static /* synthetic */ void C(WalletOfflineCoinPurseUI walletOfflineCoinPurseUI) {
        AppMethodBeat.i(43626);
        walletOfflineCoinPurseUI.Az(0);
        AppMethodBeat.o(43626);
    }

    static /* synthetic */ void D(WalletOfflineCoinPurseUI walletOfflineCoinPurseUI) {
        AppMethodBeat.i(43627);
        walletOfflineCoinPurseUI.jG(true);
        AppMethodBeat.o(43627);
    }

    static /* synthetic */ void E(WalletOfflineCoinPurseUI walletOfflineCoinPurseUI) {
        AppMethodBeat.i(43628);
        walletOfflineCoinPurseUI.bLz();
        AppMethodBeat.o(43628);
    }

    static /* synthetic */ void J(WalletOfflineCoinPurseUI walletOfflineCoinPurseUI) {
        AppMethodBeat.i(43630);
        walletOfflineCoinPurseUI.E(true, true);
        AppMethodBeat.o(43630);
    }

    static /* synthetic */ void O(WalletOfflineCoinPurseUI walletOfflineCoinPurseUI) {
        AppMethodBeat.i(43631);
        walletOfflineCoinPurseUI.bXK();
        AppMethodBeat.o(43631);
    }

    static /* synthetic */ void d(WalletOfflineCoinPurseUI walletOfflineCoinPurseUI) {
        AppMethodBeat.i(43616);
        walletOfflineCoinPurseUI.bXQ();
        AppMethodBeat.o(43616);
    }

    static /* synthetic */ void e(WalletOfflineCoinPurseUI walletOfflineCoinPurseUI) {
        AppMethodBeat.i(43617);
        walletOfflineCoinPurseUI.bXR();
        AppMethodBeat.o(43617);
    }

    static /* synthetic */ void f(WalletOfflineCoinPurseUI walletOfflineCoinPurseUI) {
        AppMethodBeat.i(43618);
        walletOfflineCoinPurseUI.bXO();
        AppMethodBeat.o(43618);
    }

    static /* synthetic */ void m(WalletOfflineCoinPurseUI walletOfflineCoinPurseUI) {
        AppMethodBeat.i(43621);
        walletOfflineCoinPurseUI.bXz();
        AppMethodBeat.o(43621);
    }

    static /* synthetic */ void s(WalletOfflineCoinPurseUI walletOfflineCoinPurseUI) {
        AppMethodBeat.i(43623);
        walletOfflineCoinPurseUI.bXW();
        AppMethodBeat.o(43623);
    }

    static /* synthetic */ boolean v(WalletOfflineCoinPurseUI walletOfflineCoinPurseUI) {
        AppMethodBeat.i(43624);
        boolean bXF = walletOfflineCoinPurseUI.bXF();
        AppMethodBeat.o(43624);
        return bXF;
    }

    static /* synthetic */ void x(WalletOfflineCoinPurseUI walletOfflineCoinPurseUI) {
        AppMethodBeat.i(43625);
        walletOfflineCoinPurseUI.bXH();
        AppMethodBeat.o(43625);
    }

    public void onCreate(Bundle bundle) {
        boolean z;
        AppMethodBeat.i(43562);
        super.onCreate(bundle);
        k.oXK = true;
        com.tencent.mm.wallet_core.ui.e.QS(41);
        Intent intent = getIntent();
        this.oZZ = intent.getBooleanExtra("is_offline_create", false);
        if (intent != null && intent.hasExtra("key_entry_scene")) {
            this.gwj = intent.getIntExtra("key_entry_scene", this.gwj);
        }
        this.emC = intent.getIntExtra("key_from_scene", 0);
        this.oZL = bo.bc(intent.getStringExtra("key_business_attach"), "");
        this.lTe = 1;
        if (this.gwj == 2) {
            this.lTe = 1;
        } else if (this.gwj == 1) {
            this.lTe = 2;
        } else if (this.gwj == 8) {
            this.lTe = 4;
        } else if (this.gwj == 4) {
            this.lTe = 6;
        } else {
            ab.i("MicroMsg.WalletOfflineCoinPurseUI", "unknown scene: %d", Integer.valueOf(this.lTe));
        }
        getWindow().addFlags(Utility.DEFAULT_STREAM_BUFFER_SIZE);
        ((com.tencent.mm.plugin.walletlock.a.b) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.walletlock.a.b.class)).a(this, null);
        AM(0);
        xE(getResources().getColor(R.color.a4t));
        dyb();
        LayoutParams attributes = getWindow().getAttributes();
        if (attributes.screenBrightness < 0.85f) {
            attributes.screenBrightness = 0.85f;
            getWindow().setAttributes(attributes);
        }
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(43544);
                gq gqVar = new gq();
                gqVar.cBo.cBp = "ok";
                com.tencent.mm.sdk.b.a.xxA.m(gqVar);
                if (WalletOfflineCoinPurseUI.this.emC == 8) {
                    com.tencent.mm.plugin.offline.c.a.Up(WalletOfflineCoinPurseUI.this.getIntent().getStringExtra("key_appid"));
                }
                WalletOfflineCoinPurseUI.this.finish();
                AppMethodBeat.o(43544);
                return false;
            }
        });
        try {
            bc.a(this, this);
            z = true;
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.WalletOfflineCoinPurseUI", e, "", new Object[0]);
            getWindow().setFlags(Utility.DEFAULT_STREAM_BUFFER_SIZE, Utility.DEFAULT_STREAM_BUFFER_SIZE);
            z = false;
        }
        if (z) {
            bc.a(this, null);
        }
        com.tencent.mm.wallet_core.ui.e.dOK();
        if (!q.isEnabled()) {
            a(new y(null, 8), false, false);
        }
        if (r.cPI().cQl()) {
            ab.e("MicroMsg.WalletOfflineCoinPurseUI", "coin purse onCreate data is invalid");
        } else if (r.cPI().cQi()) {
            ab.e("MicroMsg.WalletOfflineCoinPurseUI", "coin purse onCreate data is isUnreg");
            com.tencent.mm.plugin.offline.c.a.bYo();
            k.bXg();
            k.aT(196648, AppEventsConstants.EVENT_PARAM_VALUE_NO);
        } else if (r.cPI().cQg() && com.tencent.mm.plugin.offline.c.a.bYd()) {
            bXX();
        }
        initView();
        x.a((com.tencent.mm.platformtools.x.a) this);
        k.bXg();
        k.bXh().a(this);
        nf(606);
        nf(609);
        nf(1501);
        k.bXg();
        k.bXi().cl(this);
        com.tencent.mm.sdk.b.a.xxA.c(this.paq);
        com.tencent.mm.plugin.offline.c.a.bYp();
        com.tencent.mm.sdk.b.a.xxA.b(this.pao);
        com.tencent.mm.sdk.b.a.xxA.b(this.pam);
        com.tencent.mm.sdk.b.a.xxA.b(this.paj);
        this.pak.dnU();
        this.pal.dnU();
        this.oZY = new g();
        lg lgVar = new lg();
        lgVar.cHi.aBR = hashCode();
        com.tencent.mm.sdk.b.a.xxA.m(lgVar);
        this.pan.dnU();
        AppMethodBeat.o(43562);
    }

    private void bXy() {
        AppMethodBeat.i(43563);
        bXQ();
        bXV();
        bXR();
        bXO();
        AppMethodBeat.o(43563);
    }

    public void onResume() {
        boolean z;
        AppMethodBeat.i(43564);
        super.onResume();
        com.tencent.mm.sdk.b.a.xxA.c(this.pap);
        try {
            bc.a(this, this);
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.WalletOfflineCoinPurseUI", e, "", new Object[0]);
        }
        if (!this.pai) {
            bXy();
            this.pai = true;
        }
        ab.i("MicroMsg.WalletOfflineCoinPurseUI", "hy: on resume");
        this.kXv = true;
        com.tencent.mm.plugin.walletlock.a.b bVar = (com.tencent.mm.plugin.walletlock.a.b) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.walletlock.a.b.class);
        bVar.a(this, bVar.cTi(), null);
        if (at.isNetworkConnected(getBaseContext())) {
            if (r.cPI().cQl()) {
                a(new y(null, 8), true, false);
            }
            if (com.tencent.mm.plugin.offline.c.a.bYd()) {
                k.bXg();
                k.bXj().jF(false);
                if (!c.bXw()) {
                    if (q.isEnabled()) {
                        a(new q(com.tencent.mm.plugin.offline.c.a.pbe), false, false);
                    } else {
                        bXL();
                    }
                }
            }
        }
        bXE();
        Bankcard bYf = com.tencent.mm.plugin.offline.c.a.bYf();
        if (bYf == null || bYf.field_bindSerial == null || bYf.field_bindSerial.equals(this.oWS)) {
            z = false;
        } else {
            this.oWS = bYf.field_bindSerial;
            k.bXg();
            k.bXi().oWS = this.oWS;
            z = true;
        }
        if (z || (this.oZD && this.oZC)) {
            ab.i("MicroMsg.WalletOfflineCoinPurseUI", "onresume BindSerial isChange");
            this.oZD = false;
            this.oZC = false;
            bXM();
            Az(0);
            jG(true);
        }
        g gVar = this.oZY;
        if (com.tencent.mm.plugin.offline.c.a.bYE()) {
            ab.i(g.TAG, "OFFLINEGETMSGLOGIN START; IS stopped=" + gVar.oXm.doT());
            if (gVar.oXm == null || gVar.oXm.doT()) {
                gVar.status = 1;
                h.pYm.a(135, 61, 1, true);
                long j;
                int i;
                if (gVar.oXl) {
                    g.bXc();
                    j = (long) g.oWV;
                    gVar.oXm.ae(j, j);
                    i = g.oWV;
                    AppMethodBeat.o(43564);
                    return;
                }
                j = (long) g.oXj;
                gVar.oXm.ae(j, j);
                i = g.oXj;
                AppMethodBeat.o(43564);
                return;
            }
        }
        ab.i(g.TAG, "OfflineGetMsg is not in abtest");
        AppMethodBeat.o(43564);
    }

    private void bXz() {
        AppMethodBeat.i(43565);
        com.tencent.mm.wallet_core.ui.e.QS(32);
        com.tencent.mm.pluginsdk.wallet.h.ai(this, this.lTe);
        AppMethodBeat.o(43565);
    }

    public void onNewIntent(Intent intent) {
        AppMethodBeat.i(43566);
        super.onNewIntent(intent);
        ab.i("MicroMsg.WalletOfflineCoinPurseUI", "hy: on new intent");
        this.oZC = true;
        AppMethodBeat.o(43566);
    }

    public void onPause() {
        AppMethodBeat.i(43567);
        k.bXg();
        com.tencent.mm.plugin.offline.i bXj = k.bXj();
        bXj.mHandler.removeCallbacks(bXj.oXy);
        bc.a(this, null);
        this.kXv = false;
        com.tencent.mm.sdk.b.a.xxA.d(this.pap);
        this.oZY.stop();
        super.onPause();
        AppMethodBeat.o(43567);
    }

    public void onDestroy() {
        AppMethodBeat.i(43568);
        k.oXK = false;
        com.tencent.mm.wallet_core.ui.e.K(this.oZz);
        com.tencent.mm.wallet_core.ui.e.K(this.oZA);
        com.tencent.mm.wallet_core.ui.e.ar(this.pad);
        com.tencent.mm.wallet_core.ui.e.ar(this.pae);
        this.pad.clear();
        this.pae.clear();
        this.oZE.clear();
        this.oZF.clear();
        this.oZG.clear();
        x.c((com.tencent.mm.platformtools.x.a) this);
        k.bXg();
        k.bXh().b((com.tencent.mm.plugin.offline.a.s.a) this);
        ng(606);
        ng(609);
        ng(1501);
        k.bXg();
        k.bXi().cm(this);
        com.tencent.mm.sdk.b.a.xxA.d(this.paq);
        com.tencent.mm.sdk.b.a.xxA.d(this.pao);
        com.tencent.mm.sdk.b.a.xxA.d(this.paj);
        if (!this.oXA.doT()) {
            this.oXA.stopTimer();
        }
        if (!this.pau.doT()) {
            this.pau.stopTimer();
        }
        if (this.paf != null) {
            this.paf.release();
        }
        if (this.pag != null) {
            c cVar = this.pag;
            cVar.kgA.cancel();
            cVar.mActivity = null;
        }
        com.tencent.mm.sdk.b.a.xxA.d(this.pam);
        this.pak.dead();
        this.pal.dead();
        g gVar = this.oZY;
        gVar.stop();
        g.bXc();
        com.tencent.mm.kernel.g.RQ();
        com.tencent.mm.kernel.g.RO().eJo.b(385, gVar.oXk);
        gVar.oXm = null;
        this.pan.dead();
        super.onDestroy();
        AppMethodBeat.o(43568);
    }

    public final boolean c(int i, int i2, String str, com.tencent.mm.ai.m mVar) {
        AppMethodBeat.i(43569);
        ab.i("MicroMsg.WalletOfflineCoinPurseUI", "errType:" + i + "  errCode" + i2 + " errMsg:" + str + " scene: " + mVar);
        if ((mVar instanceof f) && ((i == 0 && i2 == 0) || i != 0)) {
            ab.i("MicroMsg.WalletOfflineCoinPurseUI", "onSceneEnd NetSceneOfflineVerifyToken errType %d errCode %d", Integer.valueOf(i), Integer.valueOf(i2));
            this.oXx.bXn();
            this.oXx = null;
        }
        if (i == 0 && i2 == 0) {
            if (mVar instanceof y) {
                if (com.tencent.mm.plugin.offline.c.a.bYd()) {
                    if (com.tencent.mm.plugin.offline.c.a.bYg() != null) {
                        bXL();
                    }
                    bXX();
                }
                bXV();
            } else if (mVar instanceof m) {
                this.oXx = (m) mVar;
                String str2 = this.oXx.oYz;
                k.bXg();
                com.tencent.mm.ai.m fVar = new f(str2, k.Ax(196617));
                com.tencent.mm.kernel.g.RQ();
                com.tencent.mm.kernel.g.RO().eJo.a(fVar, 0);
            } else if (mVar instanceof j) {
                bXE();
                bXy();
            } else if (mVar instanceof n) {
                n nVar = (n) mVar;
                if ("1".equals(nVar.oYE)) {
                    ab.w("MicroMsg.WalletOfflineCoinPurseUI", "hy: should pause. showFirstPostTip alert to finish");
                    com.tencent.mm.ui.base.h.a((Context) this, bo.isNullOrNil(nVar.oYF) ? getString(R.string.fdx) : nVar.oYF, "", false, new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.i(43505);
                            WalletOfflineCoinPurseUI.this.finish();
                            AppMethodBeat.o(43505);
                        }
                    });
                    AppMethodBeat.o(43569);
                    return true;
                } else if (nVar.oXZ == 0) {
                    c cVar = this.pag;
                    cVar.oZp = (float) com.tencent.mm.plugin.offline.c.a.bYk();
                    cVar.oZp = cVar.oZp;
                    if ("1".equals(nVar.oYD)) {
                        ab.i("MicroMsg.WalletOfflineCoinPurseUI", "hy: should refresh codes. doscene");
                        a(new m(((int) (System.currentTimeMillis() / 1000)), 8), false, false);
                    }
                } else if (nVar.oXZ != 0) {
                    this.pag.a(nVar, nVar.oXZ, nVar.oYa);
                }
            } else if (!(mVar instanceof com.tencent.mm.plugin.offline.a.a)) {
                if (mVar instanceof com.tencent.mm.plugin.offline.a.e) {
                    this.pag.c(i, i2, str, mVar);
                } else if (mVar instanceof com.tencent.mm.plugin.wallet_core.id_verify.model.f) {
                    if (this.oZV != null && this.oZV.isShowing()) {
                        this.oZV.dismiss();
                    }
                    com.tencent.mm.plugin.wallet_core.id_verify.model.f fVar2 = (com.tencent.mm.plugin.wallet_core.id_verify.model.f) mVar;
                    if ("1".equals(fVar2.tvH) || ("2".equals(fVar2.tvH) && !bo.isNullOrNil(fVar2.tvI))) {
                        Bundle bundle = new Bundle();
                        bundle.putString("realname_verify_process_jump_activity", ".ui.WalletOfflineCoinPurseUI");
                        bundle.putString("realname_verify_process_jump_plugin", "offline");
                        com.tencent.mm.plugin.wallet_core.id_verify.util.a.a(this, bundle, null, 1006);
                    } else if ("collect".equals(fVar2.tvL)) {
                        bXz();
                    } else if ("reward".equals(fVar2.tvL)) {
                        d.H(this.mController.ylL, "collect", ".reward.ui.QrRewardMainUI");
                    } else {
                        ab.w("MicroMsg.WalletOfflineCoinPurseUI", "unknown scene: %s", fVar2.tvL);
                    }
                    AppMethodBeat.o(43569);
                    return true;
                } else if (mVar instanceof q) {
                    q qVar = (q) mVar;
                    if (qVar.bLD() && !this.pac && qVar.nYe.a((Activity) this, new com.tencent.mm.wallet_core.c.f() {
                        public final void bMI() {
                        }
                    })) {
                        this.pac = true;
                    }
                    c(qVar.oYK.errType, qVar.oYK.errCode, qVar.oYK.aIm, qVar.oYI);
                    c(qVar.oYJ.errType, qVar.oYJ.errCode, qVar.oYJ.aIm, qVar.oYH);
                }
            }
            if ((mVar instanceof y) || (mVar instanceof n) || (mVar instanceof com.tencent.mm.plugin.offline.a.a) || (mVar instanceof com.tencent.mm.plugin.offline.a.e)) {
                bXE();
                E(false, true);
            } else if (mVar instanceof f) {
                bXE();
                E(true, true);
            }
        } else if (mVar instanceof n) {
            bXE();
            E(false, true);
            if (411 == i2) {
                this.pag.a(mVar, i2, str);
            }
        } else if (mVar instanceof com.tencent.mm.plugin.offline.a.e) {
            this.pag.c(i, i2, str, mVar);
        } else if (!(mVar instanceof j)) {
            if (mVar instanceof f) {
                this.oXx = null;
            } else if (mVar instanceof com.tencent.mm.plugin.wallet_core.id_verify.model.f) {
                if (this.oZV != null && this.oZV.isShowing()) {
                    this.oZV.dismiss();
                }
            } else if (mVar instanceof q) {
                bXE();
                E(false, true);
                if (411 == i2) {
                    this.pag.a(mVar, i2, str);
                }
            }
        }
        AppMethodBeat.o(43569);
        return true;
    }

    public final int getLayoutId() {
        return R.layout.b54;
    }

    public final void initView() {
        AppMethodBeat.i(43570);
        this.pah = (OfflineAlertView) findViewById(R.id.fcm);
        this.pah.dismiss();
        this.pah.setDialogState(new com.tencent.mm.plugin.offline.ui.OfflineAlertView.a() {
            public final void onClose() {
                AppMethodBeat.i(43506);
                WalletOfflineCoinPurseUI.g(WalletOfflineCoinPurseUI.this);
                AppMethodBeat.o(43506);
            }

            public final void onShow() {
                AppMethodBeat.i(43507);
                WalletOfflineCoinPurseUI.g(WalletOfflineCoinPurseUI.this);
                AppMethodBeat.o(43507);
            }
        });
        com.tencent.mm.wallet_core.c.b.dNJ();
        com.tencent.mm.wallet_core.c.b.init(getApplicationContext());
        if (this.gwj == 3 || this.gwj == 10 || this.gwj == 11 || this.gwj == 12) {
            setMMTitle((int) R.string.fvk);
        } else {
            setMMTitle((int) R.string.fvl);
        }
        this.pag = new c(this, this);
        this.pag.init();
        this.paf = new c(this, true);
        this.paf.ase();
        bXC();
        bXB();
        if (com.tencent.mm.plugin.offline.c.a.bYd() && c.bXw()) {
            c cVar = this.pag;
            k.bXg();
            cVar.a(k.bXh().oYL);
        }
        bXA();
        long j = (long) this.oXz;
        this.oXA.ae(j, j);
        bXY();
        bXD();
        final uo uoVar = new uo();
        uoVar.cQJ.cQL = "5";
        uoVar.callback = new Runnable() {
            public final void run() {
                AppMethodBeat.i(43508);
                if (bo.isNullOrNil(uoVar.cQK.cQM)) {
                    ab.i("MicroMsg.WalletOfflineCoinPurseUI", "no bulletin data");
                    AppMethodBeat.o(43508);
                    return;
                }
                com.tencent.mm.wallet_core.ui.e.a((TextView) WalletOfflineCoinPurseUI.this.findViewById(R.id.a2f), uoVar.cQK.cQM, uoVar.cQK.content, uoVar.cQK.url);
                AppMethodBeat.o(43508);
            }
        };
        com.tencent.mm.sdk.b.a.xxA.m(uoVar);
        AppMethodBeat.o(43570);
    }

    private void bXA() {
        AppMethodBeat.i(43571);
        bXE();
        E(true, false);
        AppMethodBeat.o(43571);
    }

    private void a(boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
        AppMethodBeat.i(43572);
        if (((Boolean) com.tencent.mm.kernel.g.RP().Ry().get(com.tencent.mm.storage.ac.a.USERINFO_PAY_OR_RECV_HAS_SHOW_RED_DOT_BOOLEAN_SYNC, Boolean.FALSE)).booleanValue()) {
            ab.i("MicroMsg.WalletOfflineCoinPurseUI", "no need scroll");
            AppMethodBeat.o(43572);
            return;
        }
        final boolean z6 = z;
        final boolean z7 = z4;
        final boolean z8 = z2;
        final boolean z9 = z3;
        final boolean z10 = z5;
        getWindow().getDecorView().post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(43509);
                ScrollView scrollView = (ScrollView) WalletOfflineCoinPurseUI.this.findViewById(R.id.fcz);
                if (scrollView == null) {
                    AppMethodBeat.o(43509);
                    return;
                }
                int bottom;
                int[] iArr = new int[2];
                scrollView.getLocationInWindow(iArr);
                int i = ae.hy(WalletOfflineCoinPurseUI.this.mController.ylL).y;
                if (ae.hw(WalletOfflineCoinPurseUI.this.mController.ylL)) {
                    ab.d("MicroMsg.WalletOfflineCoinPurseUI", "has navi");
                    i -= ae.fr(WalletOfflineCoinPurseUI.this.mController.ylL);
                }
                if (z6) {
                    bottom = iArr[1] + WalletOfflineCoinPurseUI.this.oZQ.getBottom();
                } else {
                    bottom = 0;
                }
                if (z7) {
                    bottom = iArr[1] + WalletOfflineCoinPurseUI.this.oZT.getBottom();
                }
                if (z8) {
                    bottom = iArr[1] + WalletOfflineCoinPurseUI.this.oZR.getBottom();
                }
                if (z9) {
                    bottom = iArr[1] + WalletOfflineCoinPurseUI.this.oZS.getBottom();
                }
                if (z10) {
                    bottom = iArr[1] + WalletOfflineCoinPurseUI.this.oZU.getBottom();
                }
                ab.d("MicroMsg.WalletOfflineCoinPurseUI", "f2f: %s, screen: %s", Integer.valueOf(bottom), Integer.valueOf(i));
                i = bottom - i;
                if (i > 0) {
                    scrollView.scrollBy(0, i);
                }
                com.tencent.mm.kernel.g.RP().Ry().set(com.tencent.mm.storage.ac.a.USERINFO_PAY_OR_RECV_HAS_SHOW_RED_DOT_BOOLEAN_SYNC, Boolean.TRUE);
                AppMethodBeat.o(43509);
            }
        });
        AppMethodBeat.o(43572);
    }

    private void bXB() {
        AppMethodBeat.i(43573);
        this.oZQ = (LinearLayout) findViewById(R.id.fcn);
        this.oZR = (LinearLayout) findViewById(R.id.fct);
        this.oZS = (LinearLayout) findViewById(R.id.fcv);
        this.oZT = (LinearLayout) findViewById(R.id.fcr);
        this.oZU = (LinearLayout) findViewById(R.id.fcx);
        if (this.gwj == 3 || this.gwj == 10 || this.gwj == 11 || this.gwj == 12) {
            this.oZQ.setVisibility(8);
            this.oZR.setVisibility(8);
            this.oZS.setVisibility(8);
            this.oZT.setVisibility(8);
            AppMethodBeat.o(43573);
            return;
        }
        this.oZT.setVisibility(0);
        this.oZU.setVisibility(0);
        boolean b = com.tencent.mm.x.c.PK().b(com.tencent.mm.storage.ac.a.NEW_BANDAGE_DATASOURCE_GROUP_PAY_STRING_SYNC, com.tencent.mm.storage.ac.a.NEW_BANDAGE_WATCHER_WALLET_COMMON_STRING_SYNC);
        boolean b2 = com.tencent.mm.x.c.PK().b(com.tencent.mm.storage.ac.a.NEW_BANDAGE_DATASOURCE_F2F_COLLECT_STRING_SYNC, com.tencent.mm.storage.ac.a.NEW_BANDAGE_WATCHER_WALLET_COMMON_STRING_SYNC);
        boolean b3 = com.tencent.mm.x.c.PK().b(com.tencent.mm.storage.ac.a.NEW_BANDAGE_DATASOURCE_F2F_HB_STRING_SYNC, com.tencent.mm.storage.ac.a.NEW_BANDAGE_WATCHER_WALLET_COMMON_STRING_SYNC);
        boolean b4 = com.tencent.mm.x.c.PK().b(com.tencent.mm.storage.ac.a.NEW_BANDAGE_DATASOURCE_QR_REWARD_STRING_SYNC, com.tencent.mm.storage.ac.a.NEW_BANDAGE_WATCHER_WALLET_COMMON_STRING_SYNC);
        boolean b5 = com.tencent.mm.x.c.PK().b(com.tencent.mm.storage.ac.a.NEW_BANDAGE_DATASOURCE_BANK_REMIT_STRING_SYNC, com.tencent.mm.storage.ac.a.NEW_BANDAGE_WATCHER_WALLET_COMMON_STRING_SYNC);
        final ImageView imageView = (ImageView) this.oZR.findViewById(R.id.fcu);
        final ImageView imageView2 = (ImageView) this.oZQ.findViewById(R.id.fco);
        final ImageView imageView3 = (ImageView) this.oZS.findViewById(R.id.fcw);
        final ImageView imageView4 = (ImageView) this.oZT.findViewById(R.id.fcs);
        final TextView textView = (TextView) this.oZQ.findViewById(R.id.fcp);
        final ImageView imageView5 = (ImageView) this.oZQ.findViewById(R.id.fcq);
        final ImageView imageView6 = (ImageView) this.oZU.findViewById(R.id.fcy);
        if (b) {
            imageView.setVisibility(0);
        }
        if (b2) {
            com.tencent.mm.kernel.g.RQ();
            String str = (String) com.tencent.mm.kernel.g.RP().Ry().get(com.tencent.mm.storage.ac.a.USERINFO_WALLET_FACING_REDDOT_WORDING_STRING_SYNC, (Object) "");
            if (bo.isNullOrNil(str)) {
                imageView2.setVisibility(0);
            } else {
                textView.setText(str);
                textView.setVisibility(0);
                imageView5.setVisibility(0);
            }
        }
        if (b3) {
            imageView3.setVisibility(0);
        }
        if (b4) {
            imageView4.setVisibility(0);
        }
        if (b5) {
            imageView6.setVisibility(0);
        }
        a(b2, b, b3, b4, b5);
        this.oZQ.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(43511);
                if (com.tencent.mm.x.c.PK().b(com.tencent.mm.storage.ac.a.NEW_BANDAGE_DATASOURCE_F2F_COLLECT_STRING_SYNC, com.tencent.mm.storage.ac.a.NEW_BANDAGE_WATCHER_WALLET_COMMON_STRING_SYNC)) {
                    com.tencent.mm.x.c.PK().c(com.tencent.mm.storage.ac.a.NEW_BANDAGE_DATASOURCE_F2F_COLLECT_STRING_SYNC, com.tencent.mm.storage.ac.a.NEW_BANDAGE_WATCHER_WALLET_COMMON_STRING_SYNC);
                    imageView2.setVisibility(8);
                    textView.setVisibility(8);
                    imageView5.setVisibility(8);
                    com.tencent.mm.kernel.g.RQ();
                    com.tencent.mm.kernel.g.RP().Ry().set(com.tencent.mm.storage.ac.a.USERINFO_WALLET_FACING_REDDOT_WORDING_STRING_SYNC, (Object) "");
                    h.pYm.e(14396, Integer.valueOf(3));
                }
                if (r.cPI().cQg()) {
                    WalletOfflineCoinPurseUI.m(WalletOfflineCoinPurseUI.this);
                    AppMethodBeat.o(43511);
                    return;
                }
                r.cPD();
                WalletOfflineCoinPurseUI walletOfflineCoinPurseUI = WalletOfflineCoinPurseUI.this;
                com.tencent.mm.wallet_core.d.i n = WalletOfflineCoinPurseUI.this.Ahr;
                AnonymousClass1 anonymousClass1 = new com.tencent.mm.plugin.wallet_core.id_verify.util.a.a() {
                    public final boolean c(int i, int i2, String str, boolean z) {
                        AppMethodBeat.i(43510);
                        ab.i("MicroMsg.WalletOfflineCoinPurseUI", "getDisclaimer   resultCode=" + i + ";errCode=" + i2 + ";errMsg=" + str + ";hadAgree = " + z);
                        if (i == 2) {
                            WalletOfflineCoinPurseUI.this.a(new com.tencent.mm.plugin.wallet_core.id_verify.model.f("collect"), false, false);
                        } else if (i == 0 && z) {
                            WalletOfflineCoinPurseUI.this.a(new com.tencent.mm.plugin.wallet_core.id_verify.model.f("collect"), false, false);
                        } else if (WalletOfflineCoinPurseUI.this.oZV != null) {
                            WalletOfflineCoinPurseUI.this.oZV.dismiss();
                        }
                        AppMethodBeat.o(43510);
                        return true;
                    }
                };
                if (!r.b(walletOfflineCoinPurseUI, n)) {
                    WalletOfflineCoinPurseUI.this.a(new com.tencent.mm.plugin.wallet_core.id_verify.model.f("collect"), true, false);
                }
                AppMethodBeat.o(43511);
            }
        });
        this.oZR.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(43512);
                ab.i("MicroMsg.WalletOfflineCoinPurseUI", "click aa");
                h.pYm.e(14021, Integer.valueOf(3), Integer.valueOf(WalletOfflineCoinPurseUI.this.lTe));
                Intent intent = new Intent();
                if (WalletOfflineCoinPurseUI.this.emC == 1) {
                    intent.putExtra("enter_scene", 2);
                } else if (WalletOfflineCoinPurseUI.this.emC == 2) {
                    intent.putExtra("enter_scene", 4);
                } else {
                    ab.w("MicroMsg.WalletOfflineCoinPurseUI", "unknown scene: %s", Integer.valueOf(WalletOfflineCoinPurseUI.this.emC));
                }
                d.b(WalletOfflineCoinPurseUI.this.mController.ylL, "aa", ".ui.AAEntranceUI", intent);
                if (com.tencent.mm.x.c.PK().b(com.tencent.mm.storage.ac.a.NEW_BANDAGE_DATASOURCE_GROUP_PAY_STRING_SYNC, com.tencent.mm.storage.ac.a.NEW_BANDAGE_WATCHER_WALLET_COMMON_STRING_SYNC)) {
                    com.tencent.mm.x.c.PK().c(com.tencent.mm.storage.ac.a.NEW_BANDAGE_DATASOURCE_GROUP_PAY_STRING_SYNC, com.tencent.mm.storage.ac.a.NEW_BANDAGE_WATCHER_WALLET_COMMON_STRING_SYNC);
                    imageView.setVisibility(8);
                    h.pYm.e(14396, Integer.valueOf(4));
                }
                AppMethodBeat.o(43512);
            }
        });
        this.oZS.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(43513);
                ab.i("MicroMsg.WalletOfflineCoinPurseUI", "click f2f lucky");
                h.pYm.e(14021, Integer.valueOf(4), Integer.valueOf(WalletOfflineCoinPurseUI.this.lTe));
                d.H(WalletOfflineCoinPurseUI.this.mController.ylL, "luckymoney", ".f2f.ui.LuckyMoneyF2FQRCodeUI");
                if (com.tencent.mm.x.c.PK().b(com.tencent.mm.storage.ac.a.NEW_BANDAGE_DATASOURCE_F2F_HB_STRING_SYNC, com.tencent.mm.storage.ac.a.NEW_BANDAGE_WATCHER_WALLET_COMMON_STRING_SYNC)) {
                    com.tencent.mm.x.c.PK().c(com.tencent.mm.storage.ac.a.NEW_BANDAGE_DATASOURCE_F2F_HB_STRING_SYNC, com.tencent.mm.storage.ac.a.NEW_BANDAGE_WATCHER_WALLET_COMMON_STRING_SYNC);
                    imageView3.setVisibility(8);
                    h.pYm.e(14396, Integer.valueOf(5));
                }
                AppMethodBeat.o(43513);
            }
        });
        this.oZT.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(43515);
                ab.i("MicroMsg.WalletOfflineCoinPurseUI", "click qr reward");
                h.pYm.e(14021, Integer.valueOf(5), Integer.valueOf(WalletOfflineCoinPurseUI.this.lTe));
                if (com.tencent.mm.x.c.PK().b(com.tencent.mm.storage.ac.a.NEW_BANDAGE_DATASOURCE_QR_REWARD_STRING_SYNC, com.tencent.mm.storage.ac.a.NEW_BANDAGE_WATCHER_WALLET_COMMON_STRING_SYNC)) {
                    com.tencent.mm.x.c.PK().c(com.tencent.mm.storage.ac.a.NEW_BANDAGE_DATASOURCE_QR_REWARD_STRING_SYNC, com.tencent.mm.storage.ac.a.NEW_BANDAGE_WATCHER_WALLET_COMMON_STRING_SYNC);
                    imageView4.setVisibility(8);
                }
                if (r.cPI().cQg()) {
                    d.H(WalletOfflineCoinPurseUI.this.mController.ylL, "collect", ".reward.ui.QrRewardMainUI");
                    AppMethodBeat.o(43515);
                    return;
                }
                r.cPD();
                WalletOfflineCoinPurseUI walletOfflineCoinPurseUI = WalletOfflineCoinPurseUI.this;
                com.tencent.mm.wallet_core.d.i q = WalletOfflineCoinPurseUI.this.Ahr;
                AnonymousClass1 anonymousClass1 = new com.tencent.mm.plugin.wallet_core.id_verify.util.a.a() {
                    public final boolean c(int i, int i2, String str, boolean z) {
                        AppMethodBeat.i(43514);
                        ab.i("MicroMsg.WalletOfflineCoinPurseUI", "getDisclaimer   resultCode=" + i + ";errCode=" + i2 + ";errMsg=" + str + ";hadAgree = " + z);
                        if (i == 2) {
                            WalletOfflineCoinPurseUI.this.a(new com.tencent.mm.plugin.wallet_core.id_verify.model.f("reward"), false, false);
                        } else if (i == 0 && z) {
                            WalletOfflineCoinPurseUI.this.a(new com.tencent.mm.plugin.wallet_core.id_verify.model.f("reward"), false, false);
                        } else if (WalletOfflineCoinPurseUI.this.oZV != null) {
                            WalletOfflineCoinPurseUI.this.oZV.dismiss();
                        }
                        AppMethodBeat.o(43514);
                        return true;
                    }
                };
                if (!r.b(walletOfflineCoinPurseUI, q)) {
                    WalletOfflineCoinPurseUI.this.a(new com.tencent.mm.plugin.wallet_core.id_verify.model.f("reward"), true, false);
                }
                AppMethodBeat.o(43515);
            }
        });
        this.oZU.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(43516);
                d.H(WalletOfflineCoinPurseUI.this.mController.ylL, "remittance", ".bankcard.ui.BankRemitBankcardInputUI");
                if (com.tencent.mm.x.c.PK().b(com.tencent.mm.storage.ac.a.NEW_BANDAGE_DATASOURCE_BANK_REMIT_STRING_SYNC, com.tencent.mm.storage.ac.a.NEW_BANDAGE_WATCHER_WALLET_COMMON_STRING_SYNC)) {
                    com.tencent.mm.x.c.PK().c(com.tencent.mm.storage.ac.a.NEW_BANDAGE_DATASOURCE_BANK_REMIT_STRING_SYNC, com.tencent.mm.storage.ac.a.NEW_BANDAGE_WATCHER_WALLET_COMMON_STRING_SYNC);
                    imageView6.setVisibility(8);
                }
                AppMethodBeat.o(43516);
            }
        });
        AppMethodBeat.o(43573);
    }

    private void bXC() {
        AppMethodBeat.i(43574);
        this.oZH = findViewById(R.id.fce);
        this.oZI = (ImageView) findViewById(R.id.fch);
        this.oZJ = (ImageView) findViewById(R.id.fcg);
        this.oZK = (TextView) findViewById(R.id.fcf);
        this.oZM = findViewById(R.id.fci);
        this.oZN = (TextView) findViewById(R.id.fck);
        this.oZO = (ImageView) findViewById(R.id.fcj);
        this.oZP = (RelativeLayout) findViewById(R.id.fcd);
        this.oZP.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(43519);
                WalletOfflineCoinPurseUI.r(WalletOfflineCoinPurseUI.this);
                AppMethodBeat.o(43519);
            }
        });
        this.oZI.setOnClickListener(this.gKK);
        this.oZJ.setOnClickListener(this.gKK);
        this.oZK.setOnClickListener(this.gKK);
        this.oZM.setClickable(true);
        this.oZM.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(43520);
                h.pYm.e(14515, Integer.valueOf(1));
                WalletOfflineCoinPurseUI.s(WalletOfflineCoinPurseUI.this);
                AppMethodBeat.o(43520);
            }
        });
        this.mLastTime = System.currentTimeMillis();
        AppMethodBeat.o(43574);
    }

    private void bcQ() {
        AppMethodBeat.i(43575);
        if (com.tencent.mm.plugin.offline.c.a.bYd()) {
            this.oZP.setVisibility(0);
            AppMethodBeat.o(43575);
            return;
        }
        this.oZP.setVisibility(4);
        AppMethodBeat.o(43575);
    }

    private void E(boolean z, boolean z2) {
        AppMethodBeat.i(43576);
        if (com.tencent.mm.plugin.offline.c.a.jH(true).size() > 0) {
            ab.i("MicroMsg.WalletOfflineCoinPurseUI", "refreshUI tempList size > 0");
            bXN();
            bXM();
            this.oZM.setVisibility(0);
        } else {
            this.oZM.setVisibility(0);
            ab.e("MicroMsg.WalletOfflineCoinPurseUI", "refreshUI tempList== null or size is 0");
        }
        if (z) {
            Az(0);
        }
        jG(z2);
        bcQ();
        bXD();
        AppMethodBeat.o(43576);
    }

    private void bXD() {
        AppMethodBeat.i(43577);
        if (!(this.par || at.isNetworkConnected(getBaseContext()))) {
            k.bXg();
            k.bXi();
            if (e.bWZ() == 0) {
                this.par = true;
                b.T(this);
                ab.e("MicroMsg.WalletOfflineCoinPurseUI", "network disconnect and code count == 0");
            }
        }
        AppMethodBeat.o(43577);
    }

    private void bXE() {
        AppMethodBeat.i(43578);
        int bYi = com.tencent.mm.plugin.offline.c.a.bYi();
        Bankcard bYg = com.tencent.mm.plugin.offline.c.a.bYg();
        if (c.bXw()) {
            this.mState = 7;
            ab.i("MicroMsg.WalletOfflineCoinPurseUI", "refreshState STATE_FREEZE");
            AppMethodBeat.o(43578);
        } else if (!at.isNetworkConnected(getBaseContext())) {
            ab.i("MicroMsg.WalletOfflineCoinPurseUI", "refreshState STATE_DISCONNECT_NETWORK");
            this.mState = 6;
            AppMethodBeat.o(43578);
        } else if (com.tencent.mm.plugin.offline.c.a.bYd()) {
            if (bYi == 0) {
                ab.i("MicroMsg.WalletOfflineCoinPurseUI", "refreshState offline is create bindCount == 0");
                this.mState = 1;
                AppMethodBeat.o(43578);
            } else if (bYi == 0 || bYg != null) {
                ab.i("MicroMsg.WalletOfflineCoinPurseUI", "refreshState STATE_FEE_CAN_USE");
                this.mState = 5;
                AppMethodBeat.o(43578);
            } else {
                ab.i("MicroMsg.WalletOfflineCoinPurseUI", "refreshState offline is create bindCount != 0 && bankcard == null");
                this.mState = 2;
                AppMethodBeat.o(43578);
            }
        } else if (bYi == 0) {
            ab.i("MicroMsg.WalletOfflineCoinPurseUI", "refreshState offline is not create bindCount == 0");
            this.mState = 1;
            AppMethodBeat.o(43578);
        } else if (bYi == 0 || bYg != null) {
            ab.i("MicroMsg.WalletOfflineCoinPurseUI", "refreshState STATE_FEE_CAN_USE");
            this.mState = 5;
            AppMethodBeat.o(43578);
        } else {
            ab.i("MicroMsg.WalletOfflineCoinPurseUI", "refreshState offline is not create bindCount != 0 && bankcard == null");
            this.mState = 2;
            AppMethodBeat.o(43578);
        }
    }

    public final boolean bNf() {
        return false;
    }

    private void jG(boolean z) {
        int i = 0;
        AppMethodBeat.i(43579);
        long currentTimeMillis = System.currentTimeMillis();
        if (z && (bo.isNullOrNil(this.oZW) || bo.isNullOrNil(this.oXv))) {
            ab.i("MicroMsg.WalletOfflineCoinPurseUI", "empty code!");
            bXS();
        } else {
            bXU();
        }
        bLh();
        ab.i("MicroMsg.WalletOfflineCoinPurseUI", "doRefresh cost time for fresh qrcode is " + (System.currentTimeMillis() - currentTimeMillis));
        bXG();
        ab.i("MicroMsg.WalletOfflineCoinPurseUI", "doRefresh cost time for fresh is " + (System.currentTimeMillis() - currentTimeMillis));
        bds();
        bXH();
        z.hL(10, 0);
        h hVar = h.pYm;
        Object[] objArr = new Object[4];
        objArr[0] = Integer.valueOf(3);
        objArr[1] = Integer.valueOf(com.tencent.mm.plugin.offline.c.a.eA(ah.getContext()) ? 0 : 1);
        if (at.isNetworkConnected(ah.getContext())) {
            i = 1;
        }
        objArr[2] = Integer.valueOf(i);
        k.bXg();
        k.bXi();
        objArr[3] = Integer.valueOf(e.bWZ());
        hVar.e(14163, objArr);
        h.pYm.a(135, 67, 1, true);
        if (at.isNetworkConnected(ah.getContext())) {
            h.pYm.a(135, 32, 1, true);
        } else {
            h.pYm.a(135, 33, 1, true);
        }
        if (com.tencent.mm.plugin.offline.c.a.eA(this)) {
            h.pYm.a(135, 34, 1, true);
            AppMethodBeat.o(43579);
            return;
        }
        h.pYm.a(135, 35, 1, true);
        AppMethodBeat.o(43579);
    }

    private boolean bXF() {
        return this.mState == 2 || this.mState == 1 || this.mState == 7;
    }

    private void bLh() {
        AppMethodBeat.i(43580);
        Bitmap bitmap = this.oZz;
        this.oZz = bXJ();
        this.oZI.setImageBitmap(this.oZz);
        if (bXF()) {
            this.oZI.setAlpha(10);
        } else {
            this.oZI.setAlpha(255);
        }
        this.pad.add(0, bitmap);
        AppMethodBeat.o(43580);
    }

    private void bXG() {
        AppMethodBeat.i(43581);
        Bitmap bitmap = this.oZA;
        this.oZA = bXI();
        this.oZJ.setImageBitmap(this.oZA);
        if (bXF()) {
            this.oZJ.setAlpha(10);
        } else {
            this.oZJ.setAlpha(255);
        }
        this.pae.add(0, bitmap);
        AppMethodBeat.o(43581);
    }

    private void bXH() {
        AppMethodBeat.i(43582);
        if (this.paf != null) {
            this.paf.iw(this.oZW, this.oXv);
            this.paf.oZz = this.oZz;
            this.paf.oZA = this.oZA;
            this.paf.dOv();
        }
        AppMethodBeat.o(43582);
    }

    private void bds() {
        int size;
        AppMethodBeat.i(43583);
        if (this.pad.size() >= 2) {
            for (size = this.pad.size() - 1; size > 1; size--) {
                com.tencent.mm.wallet_core.ui.e.K((Bitmap) this.pad.remove(size));
            }
        }
        if (this.pae.size() >= 2) {
            for (size = this.pae.size() - 1; size > 1; size--) {
                com.tencent.mm.wallet_core.ui.e.K((Bitmap) this.pae.remove(size));
            }
        }
        AppMethodBeat.o(43583);
    }

    private Bitmap bXI() {
        AppMethodBeat.i(43584);
        if (TextUtils.isEmpty(this.oXv)) {
            ab.e("MicroMsg.WalletOfflineCoinPurseUI", "getBarcodeBitmap mBarcode == null");
            AppMethodBeat.o(43584);
            return null;
        }
        Bitmap b = com.tencent.mm.bw.a.a.b(this, this.oXv, 5, 0);
        AppMethodBeat.o(43584);
        return b;
    }

    private Bitmap bXJ() {
        AppMethodBeat.i(43585);
        if (TextUtils.isEmpty(this.oZW)) {
            ab.e("MicroMsg.WalletOfflineCoinPurseUI", "getBitmap mQRcode == null");
            AppMethodBeat.o(43585);
            return null;
        }
        Bitmap b = com.tencent.mm.bw.a.a.b(this, this.oZW, 12, 3);
        AppMethodBeat.o(43585);
        return b;
    }

    private void Az(int i) {
        int i2 = 0;
        AppMethodBeat.i(43586);
        if (com.tencent.mm.plugin.offline.c.a.bYd()) {
            k.bXg();
            String q = k.bXi().q(this.gwj, i, this.oZL);
            this.oXv = q;
            this.oZW = q;
            ab.v("MicroMsg.WalletOfflineCoinPurseUI", "updateCode isSnapshot:%s mBarcode:%s mQRcode:%s stack: %s", Integer.valueOf(i), this.oXv, this.oZW, bo.dpG().toString());
            bhw();
            if (bo.isNullOrNil(q)) {
                int i3;
                h hVar = h.pYm;
                Object[] objArr = new Object[3];
                objArr[0] = Integer.valueOf(1);
                if (com.tencent.mm.plugin.offline.c.a.eA(ah.getContext())) {
                    i3 = 0;
                } else {
                    i3 = 1;
                }
                objArr[1] = Integer.valueOf(i3);
                if (at.isNetworkConnected(getBaseContext())) {
                    i2 = 1;
                }
                objArr[2] = Integer.valueOf(i2);
                hVar.e(14163, objArr);
                h.pYm.a(135, 26, 1, true);
                if (at.isNetworkConnected(getBaseContext())) {
                    h.pYm.a(135, 28, 1, true);
                    AppMethodBeat.o(43586);
                    return;
                }
                h.pYm.a(135, 27, 1, true);
            }
            AppMethodBeat.o(43586);
            return;
        }
        ab.w("MicroMsg.WalletOfflineCoinPurseUI", "offline is not create!");
        AppMethodBeat.o(43586);
    }

    public final boolean a(s.c cVar) {
        AppMethodBeat.i(43587);
        if (cVar == null) {
            ab.e("MicroMsg.WalletOfflineCoinPurseUI", "onNotify msg == null");
            AppMethodBeat.o(43587);
            return false;
        }
        boolean z;
        bXK();
        this.paf.dismiss();
        ab.i("MicroMsg.WalletOfflineCoinPurseUI", "msgtype=" + cVar.oYS);
        if (4 == cVar.oYS) {
            this.oZX = false;
            z = false;
        } else {
            if (5 == cVar.oYS) {
                this.oZX = true;
                this.paa = true;
                this.pab = false;
                if (!this.pat.doT()) {
                    this.pat.stopTimer();
                    z = false;
                }
            } else {
                if (6 == cVar.oYS) {
                    if (!this.pat.doT()) {
                        this.pat.stopTimer();
                    }
                    if (!this.oXA.doT()) {
                        this.oXA.stopTimer();
                    }
                    this.oZX = false;
                    if (com.tencent.mm.plugin.offline.c.a.bYe()) {
                        z = false;
                    }
                } else if (8 == cVar.oYS) {
                    if (!this.pat.doT()) {
                        this.pat.stopTimer();
                        z = true;
                    }
                } else if (23 == cVar.oYS) {
                    if (!this.pat.doT()) {
                        this.pat.stopTimer();
                        z = false;
                    }
                } else if (20 == cVar.oYS) {
                    this.oZX = false;
                    if (!this.pat.doT()) {
                        this.pat.stopTimer();
                        z = false;
                    }
                } else if (24 == cVar.oYS) {
                    if (com.tencent.mm.plugin.offline.c.a.bYE()) {
                        this.oZX = true;
                        if (com.tencent.mm.plugin.offline.c.a.bYE()) {
                            if (this.oZV == null) {
                                this.oZV = com.tencent.mm.wallet_core.ui.g.a(this.mController.ylL, false, new OnCancelListener() {
                                    public final void onCancel(DialogInterface dialogInterface) {
                                        AppMethodBeat.i(43524);
                                        WalletOfflineCoinPurseUI.E(WalletOfflineCoinPurseUI.this);
                                        AppMethodBeat.o(43524);
                                    }
                                });
                            } else if (!this.oZV.isShowing()) {
                                this.oZV.show();
                            }
                        }
                        long bXb = (long) g.bXb();
                        this.pat.ae(bXb, bXb);
                    }
                }
                z = true;
            }
            z = false;
        }
        c cVar2 = this.pag;
        if (cVar == null) {
            ab.e("MicroMsg.OfflineLogicMgr", "onNotify msg == null");
        } else {
            ab.i("MicroMsg.OfflineLogicMgr", "onNotify OfflineMsg type :" + cVar.oYS);
            if (cVar.oYS == 24) {
                cVar2.kgA.vibrate(50);
            }
            if (4 == cVar.oYS) {
                cVar2.a((s.b) cVar);
                g.bXc();
            } else if (5 == cVar.oYS) {
                s.e eVar = (s.e) cVar;
                if (eVar != null) {
                    ab.i("MicroMsg.OfflineLogicMgr", "showNotifyMsg msg.wxRetCode:" + eVar.oYV + " msg.wxRetMsg:" + eVar.oYW + " msg.cftRetCode:" + eVar.oYV + " msg.cftRetMsg:" + eVar.oYU);
                    if (!(TextUtils.isEmpty(eVar.oYV) && TextUtils.isEmpty(eVar.oYW) && TextUtils.isEmpty(eVar.oYT) && TextUtils.isEmpty(eVar.oYU))) {
                        if (TextUtils.isEmpty(eVar.oYV) && TextUtils.isEmpty(eVar.oYW) && !TextUtils.isEmpty(eVar.oYT) && !TextUtils.isEmpty(eVar.oYU)) {
                            b.b(cVar2.mActivity, eVar.oYU);
                        } else if (TextUtils.isEmpty(eVar.oYV) || !com.tencent.mm.plugin.offline.c.a.isNumeric(eVar.oYV)) {
                            b.b(cVar2.mActivity, eVar.oYW);
                        } else {
                            cVar2.a(null, Integer.valueOf(eVar.oYV).intValue(), eVar.oYW, eVar.oYX);
                        }
                    }
                }
                g.bXc();
                h.pYm.a(135, 0, 1, true);
            } else if (6 == cVar.oYS) {
                s.f fVar = (s.f) cVar;
                if (fVar != null) {
                    ab.i("MicroMsg.OfflineLogicMgr", "showOrderSuccessUI transid : " + fVar.oYZ);
                    k.bXg();
                    com.tencent.mm.plugin.offline.a.r TY = k.bXk().TY(fVar.oZa.czZ);
                    boolean z2 = TY != null ? TY.field_status == g.oXg : false;
                    if (!z2) {
                        g.cM(fVar.oZa.czZ, g.oXg);
                        com.tencent.mm.plugin.offline.c.a.a(cVar2.mActivity, fVar);
                        cVar2.mActivity.setResult(-1);
                        cVar2.mActivity.finish();
                    }
                }
                g.bXc();
                h.pYm.a(135, 7, 1, true);
                if (com.tencent.mm.plugin.offline.c.a.pbe == 4) {
                    ab.i("MicroMsg.OfflineLogicMgr", "hy: is from ext");
                    h.pYm.e(13412, new Object[0]);
                }
            } else if (8 == cVar.oYS) {
                s.g gVar = (s.g) cVar;
                ab.i("MicroMsg.OfflineLogicMgr", "showPayConfirmMsg msg id:" + gVar.id);
                if (gVar.kKC == 0) {
                    View inflate = cVar2.mActivity.getLayoutInflater().inflate(R.layout.b59, null);
                    TextView textView = (TextView) inflate.findViewById(R.id.fdb);
                    ((TextView) inflate.findViewById(R.id.fda)).setText(gVar.oZc);
                    textView.setText(gVar.oZb);
                    g.cM(gVar.cBT, g.oXi);
                    com.tencent.mm.ui.base.h.a(cVar2.mActivity, "", inflate, cVar2.getString(R.string.fvx), cVar2.getString(R.string.or), new com.tencent.mm.plugin.offline.ui.c.AnonymousClass11(gVar), new com.tencent.mm.plugin.offline.ui.c.AnonymousClass12(gVar));
                } else if (gVar.kKC == 1) {
                    if (cVar2.oZo != null) {
                        cVar2.oZo.show();
                    }
                    h.pYm.e(13955, Integer.valueOf(1));
                    ab.i("MicroMsg.OfflineLogicMgr", "launchPwdDialog msg id:" + gVar.id);
                    g.cM(gVar.cBT, g.oXi);
                    cVar2.oZo = com.tencent.mm.plugin.wallet_core.ui.q.a(cVar2.mActivity, gVar.oZb, gVar.oZc, new com.tencent.mm.plugin.offline.ui.c.AnonymousClass13(gVar), new OnCancelListener() {
                        public final void onCancel(DialogInterface dialogInterface) {
                            AppMethodBeat.i(43484);
                            c.this.bXv();
                            AppMethodBeat.o(43484);
                        }
                    }, new com.tencent.mm.plugin.offline.ui.c.AnonymousClass15(gVar));
                    cVar2.oZo.qcc.setVisibility(0);
                    cVar2.oZo.pUA.setVisibility(8);
                }
            } else if (23 == cVar.oYS) {
                s.d dVar = (s.d) cVar;
                PayInfo payInfo = new PayInfo();
                payInfo.czZ = dVar.cBT;
                payInfo.cIf = 8;
                payInfo.vwn = 1;
                payInfo.vwh = new Bundle();
                payInfo.vwh.putLong("extinfo_key_9", System.currentTimeMillis());
                com.tencent.mm.sdk.b.a.xxA.b(new com.tencent.mm.plugin.offline.ui.c.AnonymousClass1(payInfo));
                com.tencent.mm.pluginsdk.wallet.h.a(cVar2.mActivity, false, "", cVar2.oZn == null ? "" : cVar2.oZn.bXt(), payInfo, "", new Intent(), 1);
            } else if (20 == cVar.oYS) {
                g.bXc();
            }
        }
        if (this.paa && !this.pab) {
            this.paa = false;
            this.oZX = false;
        }
        if (z) {
            Az(0);
            jG(true);
        }
        AppMethodBeat.o(43587);
        return true;
    }

    public final void addDialog(Dialog dialog) {
        AppMethodBeat.i(43588);
        if ((dialog instanceof com.tencent.mm.ui.widget.a.c) && this.paa) {
            this.pab = true;
            final OnDismissListener onDismissListener = ((com.tencent.mm.ui.widget.a.c) dialog).zPV;
            dialog.setOnDismissListener(new OnDismissListener() {
                public final void onDismiss(DialogInterface dialogInterface) {
                    AppMethodBeat.i(43523);
                    if (onDismissListener != null) {
                        onDismissListener.onDismiss(dialogInterface);
                    }
                    if (WalletOfflineCoinPurseUI.this.paa) {
                        WalletOfflineCoinPurseUI.this.oZX = false;
                        WalletOfflineCoinPurseUI.this.paa = false;
                        WalletOfflineCoinPurseUI.C(WalletOfflineCoinPurseUI.this);
                        WalletOfflineCoinPurseUI.D(WalletOfflineCoinPurseUI.this);
                    }
                    AppMethodBeat.o(43523);
                }
            });
        }
        super.addDialog(dialog);
        AppMethodBeat.o(43588);
    }

    private void bXK() {
        AppMethodBeat.i(43589);
        if (this.oZV != null && this.oZV.isShowing()) {
            this.oZV.dismiss();
        }
        AppMethodBeat.o(43589);
    }

    private void bXL() {
        AppMethodBeat.i(43590);
        a(new n(System.currentTimeMillis(), com.tencent.mm.plugin.offline.c.a.pbe), false, false);
        AppMethodBeat.o(43590);
    }

    private void e(ImageView imageView, String str, int i) {
        AppMethodBeat.i(43591);
        if (imageView == null || TextUtils.isEmpty(str)) {
            AppMethodBeat.o(43591);
            return;
        }
        Bitmap a = x.a(new com.tencent.mm.plugin.wallet_core.ui.view.c(str));
        if (a != null) {
            imageView.setImageBitmap(com.tencent.mm.sdk.platformtools.d.a(a, i, i, true, false));
        }
        this.oZx.put(str, imageView);
        this.oZy.put(str, Integer.valueOf(i));
        AppMethodBeat.o(43591);
    }

    public final void m(String str, final Bitmap bitmap) {
        AppMethodBeat.i(43592);
        if (TextUtils.isEmpty(str) || bitmap == null || bitmap.isRecycled()) {
            AppMethodBeat.o(43592);
            return;
        }
        final ImageView imageView = (ImageView) this.oZx.get(str);
        final Integer num = (Integer) this.oZy.get(str);
        if (imageView == null || num == null) {
            AppMethodBeat.o(43592);
            return;
        }
        new ak(getMainLooper()).post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(43525);
                int intValue = num.intValue();
                imageView.setImageBitmap(com.tencent.mm.sdk.platformtools.d.a(bitmap, intValue, intValue, true, false));
                AppMethodBeat.o(43525);
            }
        });
        AppMethodBeat.o(43592);
    }

    public final void aNW() {
        AppMethodBeat.i(43593);
        ab.i("MicroMsg.WalletOfflineCoinPurseUI", "setScreenShotCallback");
        Az(1);
        jG(true);
        com.tencent.mm.wallet_core.ui.e.QS(40);
        h.pYm.a(135, 21, 1, true);
        if (this.paf.gKG.isShowing()) {
            if (this.paf.kjx) {
                this.paf.dOw();
                AppMethodBeat.o(43593);
                return;
            }
            this.paf.dismiss();
        }
        bXP();
        AppMethodBeat.o(43593);
    }

    public final void bXM() {
        int i = 1;
        int i2 = 0;
        AppMethodBeat.i(43594);
        Bankcard bYf = com.tencent.mm.plugin.offline.c.a.bYf();
        findViewById(R.id.fcl).setVisibility(0);
        this.oZN.setTextSize(0, (float) getResources().getDimensionPixelSize(R.dimen.m5));
        if (this.oZN != null && bYf != null) {
            CharSequence charSequence;
            String string = getString(R.string.fv7, new Object[]{bYf.field_desc});
            List<com.tencent.mm.plugin.wallet_core.model.c> cQC = r.cPI().cQC();
            if (!(cQC == null || bo.isNullOrNil(bYf.field_forbidWord))) {
                for (com.tencent.mm.plugin.wallet_core.model.c cVar : cQC) {
                    if (cVar.pbo.equals(bYf.field_bindSerial)) {
                        break;
                    }
                }
            }
            com.tencent.mm.plugin.wallet_core.model.c cVar2 = null;
            if (cVar2 == null || bo.isNullOrNil(cVar2.twE)) {
                Object charSequence2 = string;
                i = 0;
            } else {
                charSequence2 = bYf.field_desc + cVar2.twE;
                findViewById(R.id.fcl).setVisibility(8);
                h.pYm.e(14515, Integer.valueOf(2));
                this.oZN.setTextSize(0, (float) getResources().getDimensionPixelSize(R.dimen.kr));
            }
            this.oZN.setText(com.tencent.mm.pluginsdk.ui.e.j.b(this.mController.ylL, charSequence2, this.oZN.getTextSize()));
            i2 = i;
        } else if (bYf == null) {
            ab.e("MicroMsg.WalletOfflineCoinPurseUI", "setChangeBankcardText bankcard == null");
        }
        if (bYf != null) {
            a(bYf);
        }
        if (i2 != 0) {
            this.oZO.setImageResource(R.raw.error_offline_info);
        }
        AppMethodBeat.o(43594);
    }

    private void bXN() {
        AppMethodBeat.i(43595);
        Bankcard bYf = com.tencent.mm.plugin.offline.c.a.bYf();
        if (bYf != null) {
            ab.i("MicroMsg.WalletOfflineCoinPurseUI", "initBindSerial() have bankcard");
            com.tencent.mm.plugin.offline.c.a.Ue(bYf.field_bindSerial);
            this.oWS = bYf.field_bindSerial;
            k.bXg();
            k.bXi().oWS = this.oWS;
            AppMethodBeat.o(43595);
            return;
        }
        ab.e("MicroMsg.WalletOfflineCoinPurseUI", "initBindSerial() fail,  bankcard == null");
        AppMethodBeat.o(43595);
    }

    private void bXO() {
        AppMethodBeat.i(43596);
        if (this.oZZ) {
            AppMethodBeat.o(43596);
        } else if (this.pah.Ay(4)) {
            com.tencent.mm.kernel.g.RQ();
            if (!(((Boolean) com.tencent.mm.kernel.g.RP().Ry().get(com.tencent.mm.storage.ac.a.USERINFO_ADDRESS_HAS_SHOW_WALLETOFFLINE2_DIALOG_BOOLEAN_SYNC, Boolean.FALSE)).booleanValue() || this.pah.isShowing())) {
                bXP();
            }
            AppMethodBeat.o(43596);
        } else {
            AppMethodBeat.o(43596);
        }
    }

    private void bXP() {
        AppMethodBeat.i(43597);
        if (this.pah.Ay(4)) {
            this.pah.dq(this.oZH);
            AppMethodBeat.o(43597);
            return;
        }
        AppMethodBeat.o(43597);
    }

    private void bXQ() {
        AppMethodBeat.i(43598);
        if (this.pah.Ay(1)) {
            if (this.pah.oZe == 1) {
                this.pah.dismiss();
            }
            boolean cQi = r.cPI().cQi();
            boolean cQh = r.cPI().cQh();
            if (cQi || cQh) {
                ab.i("MicroMsg.WalletOfflineCoinPurseUI", "unreg: %B, simplereg: %B", Boolean.valueOf(cQi), Boolean.valueOf(cQh));
                this.pah.a(this.oZH, new OnClickListener() {
                    public final void onClick(View view) {
                        AppMethodBeat.i(43531);
                        com.tencent.mm.plugin.offline.c.a.bYo();
                        k.bXg();
                        k.aT(196648, AppEventsConstants.EVENT_PARAM_VALUE_NO);
                        WalletOfflineCoinPurseUI.I(WalletOfflineCoinPurseUI.this);
                        AppMethodBeat.o(43531);
                    }
                }, 1);
            }
            AppMethodBeat.o(43598);
            return;
        }
        AppMethodBeat.o(43598);
    }

    private void bXR() {
        AppMethodBeat.i(43599);
        if (this.pah.Ay(3)) {
            if (this.pah.oZe == 3) {
                this.pah.dismiss();
            }
            k.bXg();
            String Ax = k.Ax(196617);
            com.tencent.mm.wallet_core.c.b.dNJ();
            boolean isCertExist = com.tencent.mm.wallet_core.c.b.isCertExist(Ax);
            ab.i("MicroMsg.WalletOfflineCoinPurseUI", "show unopened alert, %B, %B", Boolean.valueOf(isCertExist), Boolean.valueOf(com.tencent.mm.plugin.offline.c.a.bYd()));
            if (!(isCertExist && r2)) {
                if (!isCertExist) {
                    com.tencent.mm.kernel.g.RQ();
                    String str = (String) com.tencent.mm.kernel.g.RP().Ry().get(com.tencent.mm.storage.ac.a.USERINFO_WALLET_OFFLINE_IEMI_STRING_SYNC, (Object) "");
                    if (str == null || !str.equals(com.tencent.mm.compatible.e.q.LK())) {
                        ab.i("MicroMsg.WalletOfflineCoinPurseUI", " WalletOfflineEntranceUI iemi is diff between create and getToken");
                    } else {
                        ab.i("MicroMsg.WalletOfflineCoinPurseUI", " WalletOfflineEntranceUI iemi is same between create and getToken");
                    }
                    ab.i("MicroMsg.WalletOfflineCoinPurseUI", "WalletOfflineEntranceUI CertUtil.getInstance().isCertExist(cn) is false ,cn == " + Ax + " ,recreate offline");
                    com.tencent.mm.plugin.offline.c.a.bYo();
                }
                this.pah.a(this.oZH, new OnClickListener() {
                    public final void onClick(View view) {
                        AppMethodBeat.i(43532);
                        com.tencent.mm.plugin.offline.c.a.f(WalletOfflineCoinPurseUI.this, WalletOfflineCoinPurseUI.this.emC);
                        WalletOfflineCoinPurseUI.this.finish();
                        AppMethodBeat.o(43532);
                    }
                }, 3);
            }
            AppMethodBeat.o(43599);
            return;
        }
        AppMethodBeat.o(43599);
    }

    private void bXS() {
        AppMethodBeat.i(43600);
        if (this.pah.Ay(5)) {
            if (this.pah.oZe == 5) {
                this.pah.dismiss();
            }
            this.pah.b(this.oZH, new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(43533);
                    Object[] objArr = new Object[1];
                    k.bXg();
                    k.bXj();
                    objArr[0] = Integer.valueOf(com.tencent.mm.plugin.offline.i.bXf());
                    ab.i("MicroMsg.WalletOfflineCoinPurseUI", "do get token, %s", objArr);
                    k.bXg();
                    k.bXj();
                    if (com.tencent.mm.plugin.offline.i.bXf() <= 0) {
                        WalletOfflineCoinPurseUI.this.a(new m(((int) (System.currentTimeMillis() / 1000)), 10), true, false);
                        AppMethodBeat.o(43533);
                        return;
                    }
                    WalletOfflineCoinPurseUI.J(WalletOfflineCoinPurseUI.this);
                    AppMethodBeat.o(43533);
                }
            });
            h.pYm.a(135, 73, 1, true);
            AppMethodBeat.o(43600);
            return;
        }
        AppMethodBeat.o(43600);
    }

    public final void bXT() {
        AppMethodBeat.i(43601);
        this.oZP.setVisibility(4);
        this.pah.a(this.oZH, new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(43534);
                com.tencent.mm.plugin.offline.c.a.bYo();
                com.tencent.mm.plugin.offline.c.a.g(WalletOfflineCoinPurseUI.this, WalletOfflineCoinPurseUI.this.emC);
                WalletOfflineCoinPurseUI.this.finish();
                AppMethodBeat.o(43534);
            }
        });
        AppMethodBeat.o(43601);
    }

    private void bXU() {
        AppMethodBeat.i(43602);
        if (this.pah.isShowing() && this.pah.oZe == 5) {
            this.pah.dismiss();
        }
        AppMethodBeat.o(43602);
    }

    private boolean bXV() {
        AppMethodBeat.i(43603);
        if (this.pah.Ay(2)) {
            if (this.pah.oZe == 2) {
                this.pah.dismiss();
            }
            List bYj = com.tencent.mm.plugin.offline.c.a.bYj();
            if (bYj.size() <= 0) {
                ab.e("MicroMsg.WalletOfflineCoinPurseUI", "getBindBankCardList == null or size < 1");
                AppMethodBeat.o(43603);
                return false;
            }
            for (int i = 0; i < bYj.size(); i++) {
                Bankcard bankcard = (Bankcard) bYj.get(i);
                if (bankcard != null && bankcard.field_support_micropay && bo.isNullOrNil(bankcard.field_forbidWord)) {
                    AppMethodBeat.o(43603);
                    return true;
                }
            }
            this.pah.dismiss();
            this.pah.a(this.oZH, new Runnable() {
                public final void run() {
                    AppMethodBeat.i(43535);
                    c z = WalletOfflineCoinPurseUI.this.pag;
                    com.tencent.mm.plugin.offline.c.a.e(z.mActivity, z.oZq);
                    WalletOfflineCoinPurseUI.this.oZD = true;
                    AppMethodBeat.o(43535);
                }
            }, new Runnable() {
                public final void run() {
                    AppMethodBeat.i(43536);
                    WalletOfflineCoinPurseUI.s(WalletOfflineCoinPurseUI.this);
                    AppMethodBeat.o(43536);
                }
            });
            AppMethodBeat.o(43603);
            return false;
        }
        AppMethodBeat.o(43603);
        return false;
    }

    private void bXW() {
        AppMethodBeat.i(43604);
        if (!com.tencent.mm.plugin.offline.c.a.bYd()) {
            ab.i("MicroMsg.WalletOfflineCoinPurseUI", "unOpen %s", Boolean.valueOf(com.tencent.mm.plugin.offline.c.a.bYd()));
            AppMethodBeat.o(43604);
        } else if (com.tencent.mm.plugin.offline.c.a.jH(false).size() <= 0) {
            ab.e("MicroMsg.WalletOfflineCoinPurseUI", "getBindBankCardList == null or size < 1");
            this.oZN.setVisibility(8);
            AppMethodBeat.o(43604);
        } else {
            final ArrayList ne = ac.ne(true);
            final com.tencent.mm.ui.widget.a.d dVar = new com.tencent.mm.ui.widget.a.d(this, 2, true);
            int i = 0;
            for (int i2 = 0; i2 < ne.size(); i2++) {
                Bankcard bankcard = (Bankcard) ne.get(i2);
                if (!bo.isNullOrNil(bankcard.field_bindSerial) && this.oWS.equals(bankcard.field_bindSerial)) {
                    i = i2;
                }
            }
            dVar.rBl = new com.tencent.mm.ui.base.n.c() {
                public final void a(final l lVar) {
                    AppMethodBeat.i(43540);
                    for (int i = 0; i < ne.size(); i++) {
                        CharSequence charSequence;
                        CharSequence spannableString;
                        String str;
                        Drawable f;
                        Drawable drawable;
                        boolean z;
                        final Bankcard bankcard = (Bankcard) ne.get(i);
                        String Uk = com.tencent.mm.plugin.offline.c.a.Uk(bankcard.field_bankcardType);
                        if (bankcard.cPd() && bankcard.txc != null) {
                            Uk = bankcard.txc.oRi;
                        }
                        Bitmap a = x.a(new com.tencent.mm.plugin.wallet_core.ui.view.c(Uk));
                        x.a(new com.tencent.mm.platformtools.x.a() {
                            public final void m(final String str, final Bitmap bitmap) {
                                AppMethodBeat.i(43538);
                                al.d(new Runnable() {
                                    public final void run() {
                                        AppMethodBeat.i(43537);
                                        ab.i("MicroMsg.WalletOfflineCoinPurseUI", "dancy test get picture finish, notifyKey:%s, finalIconUrl:%s", str, Uk);
                                        if (WalletOfflineCoinPurseUI.this.pas.containsKey(str)) {
                                            int intValue = ((Integer) WalletOfflineCoinPurseUI.this.pas.get(str)).intValue();
                                            if (lVar.getItem(intValue) != null) {
                                                lVar.getItem(intValue).setIcon(new BitmapDrawable(com.tencent.mm.sdk.platformtools.d.a(bitmap, WalletOfflineCoinPurseUI.this.getResources().getDimensionPixelOffset(R.dimen.aaq), WalletOfflineCoinPurseUI.this.getResources().getDimensionPixelOffset(R.dimen.aaq), true, false)));
                                                dVar.dKX();
                                            }
                                        }
                                        AppMethodBeat.o(43537);
                                    }
                                });
                                AppMethodBeat.o(43538);
                            }
                        });
                        String str2 = "";
                        if (!bo.isNullOrNil(bankcard.field_forbidWord)) {
                            str2 = bankcard.field_forbidWord;
                        }
                        if (!bo.isNullOrNil(str2) || bankcard.field_support_micropay) {
                            Object charSequence2 = str2;
                        } else {
                            charSequence2 = bo.isNullOrNil(bankcard.field_no_micro_word) ? "" : bankcard.field_no_micro_word;
                        }
                        if (bo.isNullOrNil(bankcard.field_forbid_title)) {
                            spannableString = new SpannableString(charSequence2);
                            str = charSequence2;
                        } else {
                            String str3 = charSequence2 + " ";
                            spannableString = new SpannableString(str3 + bankcard.field_forbid_title);
                            AnonymousClass2 anonymousClass2 = new com.tencent.mm.plugin.wallet_core.ui.j(WalletOfflineCoinPurseUI.this) {
                                public final void onClick(View view) {
                                    AppMethodBeat.i(43539);
                                    Intent intent = new Intent();
                                    ab.i("MicroMsg.WalletOfflineCoinPurseUI", "go to url %s", bankcard.field_forbid_url);
                                    intent.putExtra("rawUrl", r1);
                                    intent.putExtra("geta8key_username", com.tencent.mm.model.r.Yz());
                                    intent.putExtra("pay_channel", 1);
                                    d.b(WalletOfflineCoinPurseUI.this.mController.ylL, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
                                    AppMethodBeat.o(43539);
                                }
                            };
                            int length = str3.length();
                            int length2 = str3.length() + bankcard.field_forbid_title.length();
                            spannableString.setSpan(new ForegroundColorSpan(WalletOfflineCoinPurseUI.this.getResources().getColor(R.color.a50)), length, length2, 33);
                            spannableString.setSpan(anonymousClass2, length, length2, 33);
                            str = str3;
                        }
                        if ((bankcard.cPc() || bankcard.cPd()) && bankcard.twS >= 0.0d) {
                            charSequence2 = bankcard.field_desc + WalletOfflineCoinPurseUI.this.getString(R.string.f94, new Object[]{com.tencent.mm.wallet_core.ui.e.G(bankcard.twS)});
                        } else {
                            charSequence2 = bankcard.field_desc;
                        }
                        if (bankcard.cPg()) {
                            f = com.tencent.mm.svg.a.a.f(WalletOfflineCoinPurseUI.this.getResources(), R.raw.honey_pay_bank_logo);
                        } else if (a != null) {
                            f = new BitmapDrawable(com.tencent.mm.sdk.platformtools.d.a(a, WalletOfflineCoinPurseUI.this.getResources().getDimensionPixelOffset(R.dimen.aaq), WalletOfflineCoinPurseUI.this.getResources().getDimensionPixelOffset(R.dimen.aaq), true, false));
                        } else {
                            f = null;
                        }
                        if (f == null) {
                            WalletOfflineCoinPurseUI.this.pas.put(Uk, Integer.valueOf(i));
                        }
                        ab.i("MicroMsg.WalletOfflineCoinPurseUI", "i %d fee %s %s", Integer.valueOf(i), charSequence2, spannableString);
                        SpannableString b = com.tencent.mm.pluginsdk.ui.e.j.b(WalletOfflineCoinPurseUI.this.mController.ylL, charSequence2);
                        if (f == null) {
                            drawable = null;
                        } else {
                            drawable = f;
                        }
                        if (bo.isNullOrNil(str)) {
                            z = false;
                        } else {
                            z = true;
                        }
                        lVar.a(i, b, spannableString, drawable, z);
                    }
                    AppMethodBeat.o(43540);
                }
            };
            dVar.rBm = new com.tencent.mm.ui.base.n.d() {
                public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                    AppMethodBeat.i(43541);
                    if (dVar != null) {
                        dVar.cpE();
                        Bankcard bankcard = (Bankcard) ne.get(i);
                        h.pYm.e(14515, Integer.valueOf(3));
                        if (!(bo.isNullOrNil(bankcard.field_forbid_title) && bo.isNullOrNil(bankcard.field_forbidWord) && bankcard.field_support_micropay)) {
                            h.pYm.e(14515, Integer.valueOf(4));
                        }
                        String str = bankcard.field_bindSerial;
                        if (!(TextUtils.isEmpty(str) || str.equals(WalletOfflineCoinPurseUI.this.oWS))) {
                            WalletOfflineCoinPurseUI.this.oWS = str;
                            com.tencent.mm.plugin.offline.c.a.Ue(WalletOfflineCoinPurseUI.this.oWS);
                            k.bXg();
                            k.bXi().oWS = WalletOfflineCoinPurseUI.this.oWS;
                            WalletOfflineCoinPurseUI.this.bXM();
                            WalletOfflineCoinPurseUI.C(WalletOfflineCoinPurseUI.this);
                            WalletOfflineCoinPurseUI.D(WalletOfflineCoinPurseUI.this);
                        }
                    }
                    AppMethodBeat.o(43541);
                }
            };
            View inflate = View.inflate(this, R.layout.b52, null);
            dVar.pIf = true;
            dVar.zQA = i;
            dVar.zQy = true;
            dVar.F(inflate, false);
            dVar.cpD();
            h.pYm.e(13955, Integer.valueOf(3));
            AppMethodBeat.o(43604);
        }
    }

    public final int getForceOrientation() {
        return 1;
    }

    private static void bXX() {
        AppMethodBeat.i(43605);
        if (!com.tencent.mm.plugin.offline.c.a.bYw()) {
            ab.i("MicroMsg.WalletOfflineCoinPurseUI", "WalletOfflineUtil.isSameMD5ForBindSerial() return false, token is invalid, do doNetSceneToken");
            k.bXg();
            k.bXj().eO(3, 3);
        }
        AppMethodBeat.o(43605);
    }

    private void a(Bankcard bankcard) {
        AppMethodBeat.i(43606);
        if (TextUtils.isEmpty(this.oWS)) {
            ab.e("MicroMsg.WalletOfflineCoinPurseUI", "updateBankLogo() mBindSerial is null");
            AppMethodBeat.o(43606);
        } else if (bankcard.cPg()) {
            ab.i("MicroMsg.WalletOfflineCoinPurseUI", "show local hy logo");
            this.oZO.setImageDrawable(com.tencent.mm.svg.a.a.f(this.mController.ylL.getResources(), R.raw.honey_pay_bank_logo));
            AppMethodBeat.o(43606);
        } else {
            CharSequence Ul = com.tencent.mm.plugin.offline.c.a.Ul(this.oWS);
            if (bankcard.cPd() && bankcard.txc != null) {
                Ul = bankcard.txc.oRi;
            }
            if (TextUtils.isEmpty(Ul)) {
                ab.e("MicroMsg.WalletOfflineCoinPurseUI", "updateBankLogo() icon_url == null, can not find this icon_url");
                AppMethodBeat.o(43606);
                return;
            }
            e(this.oZO, Ul, getResources().getDimensionPixelOffset(R.dimen.aaq));
            AppMethodBeat.o(43606);
        }
    }

    public final void bap() {
        AppMethodBeat.i(43607);
        Az(0);
        jG(true);
        AppMethodBeat.o(43607);
    }

    public final void bXr() {
        AppMethodBeat.i(43609);
        bXW();
        AppMethodBeat.o(43609);
    }

    public final void bXs() {
        AppMethodBeat.i(43610);
        a(new j(""), false, false);
        AppMethodBeat.o(43610);
    }

    public final String bXt() {
        return this.oWS;
    }

    private void bXY() {
        AppMethodBeat.i(43611);
        if (com.tencent.mm.plugin.offline.c.a.pbe == 3 && com.tencent.mm.plugin.offline.c.a.pbh) {
            ab.i("MicroMsg.WalletOfflineCoinPurseUI", "The scene is from card detail ui, is marked!");
            int i = com.tencent.mm.plugin.offline.c.a.pbf;
            long j = com.tencent.mm.plugin.offline.c.a.pbg;
            long currentTimeMillis = System.currentTimeMillis();
            long j2 = (((long) (i * 1000)) + j) - currentTimeMillis;
            ab.i("MicroMsg.WalletOfflineCoinPurseUI", "expire_time:" + i + " beginTime:" + j + " now:" + currentTimeMillis + " interval:" + j2);
            if (com.tencent.mm.plugin.offline.c.a.pbf <= 0 || com.tencent.mm.plugin.offline.c.a.pbg <= 0 || j2 <= 0) {
                ab.e("MicroMsg.WalletOfflineCoinPurseUI", "not to start card expire timer!");
                AppMethodBeat.o(43611);
                return;
            }
            if (!this.pau.doT()) {
                this.pau.stopTimer();
            }
            this.pau.ae(j2, j2);
            ab.i("MicroMsg.WalletOfflineCoinPurseUI", "start card expire timer!");
            AppMethodBeat.o(43611);
        } else if (com.tencent.mm.plugin.offline.c.a.pbe == 3) {
            ab.i("MicroMsg.WalletOfflineCoinPurseUI", "The scene is from card detail ui, not need to mark!");
            AppMethodBeat.o(43611);
        } else {
            ab.i("MicroMsg.WalletOfflineCoinPurseUI", "The scene is from %d, not need to start timer!", Integer.valueOf(com.tencent.mm.plugin.offline.c.a.pbe));
            AppMethodBeat.o(43611);
        }
    }

    private void bhw() {
        AppMethodBeat.i(43612);
        aw cPy = com.tencent.mm.plugin.wallet_core.model.k.cPy();
        StringBuilder append = new StringBuilder().append(this.oZW);
        com.tencent.mm.kernel.g.RQ();
        com.tencent.mm.kernel.g.RN();
        String ck = ag.ck(append.append(p.getString(com.tencent.mm.kernel.a.QF())).toString());
        if (cPy != null) {
            h.pYm.e(13444, cPy.vCF, cPy.vCG, Long.valueOf(cPy.vCE), ck, cPy.vCH, cPy.vCI);
        }
        AppMethodBeat.o(43612);
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        AppMethodBeat.i(43613);
        if (i == 4 && this.pah != null && this.pah.getVisibility() == 0 && this.pah.oZg) {
            this.pah.dismiss();
            AppMethodBeat.o(43613);
            return true;
        }
        boolean onKeyUp = super.onKeyUp(i, keyEvent);
        AppMethodBeat.o(43613);
        return onKeyUp;
    }

    public final void bXu() {
        AppMethodBeat.i(43614);
        if (!this.oXA.doT()) {
            this.oXA.stopTimer();
        }
        Az(0);
        jG(true);
        this.oZX = false;
        long j = (long) this.oXz;
        this.oXA.ae(j, j);
        AppMethodBeat.o(43614);
    }

    public final void e(int i, String str, String str2, String str3) {
        AppMethodBeat.i(43608);
        a(new com.tencent.mm.plugin.offline.a.e(i, str, str2, str3), com.tencent.mm.plugin.offline.c.a.bYe(), false);
        AppMethodBeat.o(43608);
    }

    public /* synthetic */ Dialog onCreateDialog(final int i) {
        AppMethodBeat.i(43615);
        View inflate = getLayoutInflater().inflate(R.layout.b4o, null);
        ListViewInScrollView listViewInScrollView = (ListViewInScrollView) inflate.findViewById(R.id.n3);
        if (this.oZB == null) {
            this.oZB = new a();
        }
        if (i == 1) {
            a aVar = this.oZB;
            ArrayList arrayList = this.oZE;
            ArrayList arrayList2 = this.oZG;
            if (arrayList != null) {
                aVar.iPr.clear();
                aVar.iPr.addAll(arrayList);
            }
            if (arrayList2 != null) {
                aVar.paT.clear();
                aVar.paT.addAll(arrayList2);
            }
        }
        listViewInScrollView.setAdapter(this.oZB);
        this.oZB.notifyDataSetChanged();
        listViewInScrollView.setOnItemClickListener(new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                AppMethodBeat.i(43526);
                WalletOfflineCoinPurseUI.this.dismissDialog(i);
                WalletOfflineCoinPurseUI.jpc = i;
                if (i == 1) {
                    String str = (String) WalletOfflineCoinPurseUI.this.oZF.get(i);
                    if (!(TextUtils.isEmpty(str) || str.equals(WalletOfflineCoinPurseUI.this.oWS))) {
                        WalletOfflineCoinPurseUI.this.oWS = str;
                        com.tencent.mm.plugin.offline.c.a.Ue(WalletOfflineCoinPurseUI.this.oWS);
                        k.bXg();
                        k.bXi().oWS = WalletOfflineCoinPurseUI.this.oWS;
                        WalletOfflineCoinPurseUI.this.bXM();
                        WalletOfflineCoinPurseUI.C(WalletOfflineCoinPurseUI.this);
                        WalletOfflineCoinPurseUI.D(WalletOfflineCoinPurseUI.this);
                    }
                }
                AppMethodBeat.o(43526);
            }
        });
        com.tencent.mm.ui.widget.a.c.a aVar2 = new com.tencent.mm.ui.widget.a.c.a(this);
        if (i == 1) {
            aVar2.PV(R.string.fv9);
        }
        aVar2.fn(inflate);
        aVar2.f(null);
        com.tencent.mm.ui.widget.a.c aMb = aVar2.aMb();
        AppMethodBeat.o(43615);
        return aMb;
    }

    static /* synthetic */ void g(WalletOfflineCoinPurseUI walletOfflineCoinPurseUI) {
        AppMethodBeat.i(43620);
        walletOfflineCoinPurseUI.pah.getVisibility();
        AppMethodBeat.o(43620);
    }

    static /* synthetic */ void r(WalletOfflineCoinPurseUI walletOfflineCoinPurseUI) {
        AppMethodBeat.i(43622);
        com.tencent.mm.ui.base.h.a(walletOfflineCoinPurseUI.mController.ylL, null, walletOfflineCoinPurseUI.getResources().getStringArray(R.array.at), null, false, new com.tencent.mm.ui.base.h.c() {
            public final void iE(int i) {
                AppMethodBeat.i(43522);
                switch (i) {
                    case 0:
                        com.tencent.mm.plugin.offline.c.a.eH(WalletOfflineCoinPurseUI.this);
                        AppMethodBeat.o(43522);
                        return;
                    case 1:
                        c z = WalletOfflineCoinPurseUI.this.pag;
                        if (((com.tencent.mm.plugin.walletlock.a.b) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.walletlock.a.b.class)).cTj()) {
                            com.tencent.mm.ui.base.h.d(z.mActivity, z.getString(R.string.fvg), "", z.getString(R.string.fvf), z.getString(R.string.or), new DialogInterface.OnClickListener() {
                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    AppMethodBeat.i(43479);
                                    dialogInterface.dismiss();
                                    a.bYo();
                                    com.tencent.mm.ui.base.h.bQ(c.this.mActivity, c.this.mActivity.getResources().getString(R.string.fvj));
                                    c.a(c.this);
                                    AppMethodBeat.o(43479);
                                }
                            }, new DialogInterface.OnClickListener() {
                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    AppMethodBeat.i(43480);
                                    dialogInterface.dismiss();
                                    AppMethodBeat.o(43480);
                                }
                            });
                            break;
                        }
                        com.tencent.mm.ui.base.h.d(z.mActivity, z.getString(R.string.fvi), "", z.getString(R.string.fwg), z.getString(R.string.fvf), new DialogInterface.OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                AppMethodBeat.i(43477);
                                ((com.tencent.mm.plugin.walletlock.a.b) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.walletlock.a.b.class)).b(c.this.mActivity, new Intent());
                                AppMethodBeat.o(43477);
                            }
                        }, new DialogInterface.OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                AppMethodBeat.i(43478);
                                dialogInterface.dismiss();
                                a.bYo();
                                com.tencent.mm.ui.base.h.bQ(c.this.mActivity, c.this.mActivity.getResources().getString(R.string.fvj));
                                c.a(c.this);
                                AppMethodBeat.o(43478);
                            }
                        });
                        AppMethodBeat.o(43522);
                        return;
                }
                AppMethodBeat.o(43522);
            }
        });
        AppMethodBeat.o(43622);
    }

    static /* synthetic */ void I(WalletOfflineCoinPurseUI walletOfflineCoinPurseUI) {
        AppMethodBeat.i(43629);
        com.tencent.mm.ui.base.h.a((Context) walletOfflineCoinPurseUI, false, walletOfflineCoinPurseUI.getString(R.string.fuz), "", walletOfflineCoinPurseUI.getString(R.string.fvd), walletOfflineCoinPurseUI.getString(R.string.or), new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.i(43527);
                dialogInterface.dismiss();
                com.tencent.mm.plugin.offline.c.a.a(WalletOfflineCoinPurseUI.this, 0, WalletOfflineCoinPurseUI.this.gwj);
                WalletOfflineCoinPurseUI.this.oZD = true;
                ab.v("MicroMsg.WalletOfflineCoinPurseUI", "WalletOfflineEntranceUI startBindProcess()");
                AppMethodBeat.o(43527);
            }
        }, new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.i(43528);
                dialogInterface.dismiss();
                WalletOfflineCoinPurseUI.this.finish();
                AppMethodBeat.o(43528);
            }
        });
        AppMethodBeat.o(43629);
    }
}
