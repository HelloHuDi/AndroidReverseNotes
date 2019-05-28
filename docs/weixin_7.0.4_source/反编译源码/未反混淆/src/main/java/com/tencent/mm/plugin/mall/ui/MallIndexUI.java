package com.tencent.mm.plugin.mall.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.m;
import com.tencent.mm.bp.d;
import com.tencent.mm.g.a.lu;
import com.tencent.mm.g.a.uo;
import com.tencent.mm.g.a.uq;
import com.tencent.mm.g.a.uq.b;
import com.tencent.mm.g.a.vc;
import com.tencent.mm.g.a.vw;
import com.tencent.mm.kernel.g;
import com.tencent.mm.kernel.i;
import com.tencent.mm.plugin.mall.a.j;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.c.y;
import com.tencent.mm.plugin.wallet_core.model.ECardInfo;
import com.tencent.mm.plugin.wallet_core.model.ai;
import com.tencent.mm.plugin.wallet_core.model.ak;
import com.tencent.mm.plugin.wallet_core.model.k;
import com.tencent.mm.plugin.wallet_core.model.n;
import com.tencent.mm.plugin.wallet_core.model.r;
import com.tencent.mm.plugin.wallet_core.ui.s;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.ui.v;
import com.tencent.mm.wallet_core.c.f;
import com.tencent.mm.wallet_core.c.z;
import com.tencent.mm.wallet_core.ui.e;
import java.math.RoundingMode;

@i
public class MallIndexUI extends MallIndexBaseUI {
    private String cRs;
    private boolean eTM = false;
    private View jNV = null;
    private TextView omQ = null;
    private boolean omR = false;
    b onh;
    private RelativeLayout oni;
    private boolean onj;
    private boolean onk;
    s onl = new s();
    private boolean onm = false;
    private Dialog onn;
    private boolean ono = false;
    private c<lu> onp = new c<lu>() {
        {
            AppMethodBeat.i(43204);
            this.xxI = lu.class.getName().hashCode();
            AppMethodBeat.o(43204);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(43205);
            ab.i("MicorMsg.MallIndexUI", "open ecard finish");
            ECardInfo.aw(null);
            AppMethodBeat.o(43205);
            return false;
        }
    };
    private boolean onq = false;
    private c onr = new c<vc>() {
        {
            AppMethodBeat.i(43212);
            this.xxI = vc.class.getName().hashCode();
            AppMethodBeat.o(43212);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(43213);
            ab.i("MicorMsg.MallIndexUI", "real name verify callback, result: %s, isDoRealNameForBalance: %s", Integer.valueOf(((vc) bVar).cRZ.result), Boolean.valueOf(MallIndexUI.this.onq));
            if (((vc) bVar).cRZ.result == -1 && MallIndexUI.this.onq) {
                MallIndexUI.this.onq = false;
                MallIndexUI.c(MallIndexUI.this);
            }
            AppMethodBeat.o(43213);
            return false;
        }
    };
    private c<vw> ons = new c<vw>() {
        {
            AppMethodBeat.i(43214);
            this.xxI = vw.class.getName().hashCode();
            AppMethodBeat.o(43214);
        }

        private static boolean a(vw vwVar) {
            AppMethodBeat.i(43215);
            ab.i("MicorMsg.MallIndexUI", "get result %s", vwVar.cTd.cBp);
            if ("agree_privacy".equals(vwVar.cTd.cBp)) {
                g.RQ();
                g.RP().Ry().set(a.USERINFO_MALL_INDEX_GDPR_AGREE_BOOLEAN_SYNC, Boolean.TRUE);
            }
            AppMethodBeat.o(43215);
            return false;
        }
    };
    private boolean ont = false;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public MallIndexUI() {
        AppMethodBeat.i(43222);
        AppMethodBeat.o(43222);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(43223);
        ab.i("MicorMsg.MallIndexUI", "onActivityResult %s %s %s", Integer.valueOf(i), Integer.valueOf(i2), intent);
        super.onActivityResult(i, i2, intent);
        if (i != 3) {
            if (i == 5) {
                g.RQ();
                if (!((Boolean) g.RP().Ry().get(a.USERINFO_MALL_INDEX_GDPR_AGREE_BOOLEAN_SYNC, Boolean.FALSE)).booleanValue()) {
                    finish();
                }
            }
            AppMethodBeat.o(43223);
        } else if (i2 == -1) {
            this.onl.bNo();
            AppMethodBeat.o(43223);
        } else {
            this.onl.cancel();
            AppMethodBeat.o(43223);
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final void bFY() {
        AppMethodBeat.i(43225);
        int color = getResources().getColor(R.color.uk);
        xE(color);
        dyb();
        findViewById(R.id.d3v).setBackgroundColor(color);
        AppMethodBeat.o(43225);
    }

    /* Access modifiers changed, original: protected|final */
    public final void bbC() {
        AppMethodBeat.i(43226);
        setMMTitle((int) R.string.cwn);
        AppMethodBeat.o(43226);
    }

    public final void initView() {
        AppMethodBeat.i(43227);
        super.initView();
        this.omu.setPadding(a.olm, 0, a.olm, 0);
        AppMethodBeat.o(43227);
    }

    /* Access modifiers changed, original: protected|final */
    public final void initHeaderView() {
        AppMethodBeat.i(43228);
        this.omD = v.hu(this).inflate(R.layout.abl, null);
        this.omu.addHeaderView(this.omD, null, false);
        LinearLayout linearLayout = (LinearLayout) this.omD.findViewById(R.id.d37);
        LayoutParams layoutParams = (LayoutParams) linearLayout.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new LayoutParams(-1, -2);
        }
        layoutParams.height = a.bMX();
        linearLayout.setLayoutParams(layoutParams);
        AppMethodBeat.o(43228);
    }

    /* Access modifiers changed, original: protected|final */
    public final void bGb() {
        AppMethodBeat.i(43229);
        this.omC = j.bMV().yl(this.okT).field_isShowSetting;
        if (this.omE == null) {
            this.omE = v.hu(this).inflate(R.layout.abm, null);
            this.omu.addFooterView(this.omE, null, false);
            View view = (TextView) this.omE.findViewById(R.id.d3b);
            e.aA(view, 100);
            view.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(43217);
                    ab.i("MicorMsg.MallIndexUI", "click settings btn");
                    d.H(MallIndexUI.this.mController.ylL, "mall", ".ui.MallFunctionSettingsUI");
                    AppMethodBeat.o(43217);
                }
            });
        }
        ab.i("MicorMsg.MallIndexUI", "is show setting: %s", Integer.valueOf(this.omC));
        if (this.omC == 0) {
            this.omE.setVisibility(8);
            this.omE.setPadding(0, 0, 0, 0);
            AppMethodBeat.o(43229);
            return;
        }
        this.omE.setVisibility(0);
        getWindow().getDecorView().post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(43218);
                int ge = com.tencent.mm.bz.a.ge(MallIndexUI.this.mController.ylL);
                int fromDPToPix = com.tencent.mm.bz.a.fromDPToPix(MallIndexUI.this.mController.ylL, 53);
                int[] iArr = new int[2];
                MallIndexUI.this.omu.getLocationInWindow(iArr);
                int bottom = (MallIndexUI.this.omE.getBottom() + iArr[1]) - ge;
                int height = (MallIndexUI.this.omu.getHeight() - MallIndexUI.this.omE.getHeight()) + iArr[1];
                if (bottom > 0) {
                    height += bottom;
                }
                fromDPToPix = (ge - height) - fromDPToPix;
                int fromDPToPix2 = com.tencent.mm.bz.a.fromDPToPix(MallIndexUI.this.mController.ylL, 33);
                ab.d("MicorMsg.MallIndexUI", "winHeight: %d, height: %d, footerHeight: %s, Y: %d, scrollDiff: %d, diff: %d", Integer.valueOf(ge), Integer.valueOf(height), Integer.valueOf(MallIndexUI.this.omE.getHeight()), Integer.valueOf(iArr[1]), Integer.valueOf(bottom), Integer.valueOf(fromDPToPix));
                if (fromDPToPix > fromDPToPix2) {
                    MallIndexUI.this.omE.setPadding(0, fromDPToPix, 0, fromDPToPix2);
                    AppMethodBeat.o(43218);
                    return;
                }
                MallIndexUI.this.omE.setPadding(0, fromDPToPix2, 0, fromDPToPix2);
                AppMethodBeat.o(43218);
            }
        });
        AppMethodBeat.o(43229);
    }

    /* Access modifiers changed, original: protected|final */
    public final void dp(View view) {
        int i;
        AppMethodBeat.i(43230);
        g.RQ();
        boolean booleanValue = ((Boolean) g.RP().Ry().get(a.USERINFO_WALLET_New_MALL_UI_REDDOT_CONFIG_BOOLEAN_SYNC, Boolean.FALSE)).booleanValue();
        g.RQ();
        long longValue = ((Long) g.RP().Ry().get(a.USERINFO_WALLET_New_MALL_UI_REDDOT_CONFIG_EXPIRETIME_LONG_SYNC, Long.valueOf(0))).longValue();
        if (!booleanValue || longValue <= 0 || System.currentTimeMillis() < longValue) {
            boolean i2 = booleanValue;
        } else {
            ab.i("MicorMsg.MallIndexUI", "hasRedDot expire, ignore reddot");
            g.RQ();
            g.RP().Ry().set(a.USERINFO_WALLET_New_MALL_UI_REDDOT_CONFIG_BOOLEAN_SYNC, Boolean.FALSE);
            g.RQ();
            g.RP().Ry().set(a.USERINFO_WALLET_New_MALL_UI_REDDOT_CONFIG_EXPIRETIME_LONG_SYNC, Long.valueOf(0));
            i2 = 0;
        }
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.d38);
        LinearLayout linearLayout2 = (LinearLayout) view.findViewById(R.id.d39);
        this.omy = (TextView) linearLayout2.findViewById(R.id.d3a);
        ImageView imageView = (ImageView) linearLayout2.findViewById(R.id.d3_);
        if (i2 != 0) {
            imageView.setVisibility(0);
        } else {
            imageView.setVisibility(8);
        }
        linearLayout.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(43219);
                Intent intent = new Intent();
                intent.putExtra("key_from_scene", 1);
                d.b(MallIndexUI.this.mController.ylL, "offline", ".ui.WalletOfflineEntranceUI", intent);
                z.hL(9, 0);
                h.pYm.e(11850, Integer.valueOf(5), Integer.valueOf(0));
                h.pYm.e(14419, MallIndexUI.this.eCq, Integer.valueOf(1));
                AppMethodBeat.o(43219);
            }
        });
        linearLayout2.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(43220);
                MallIndexUI.c(MallIndexUI.this);
                AppMethodBeat.o(43220);
            }
        });
        AppMethodBeat.o(43230);
    }

    /* Access modifiers changed, original: protected|final */
    public final void bNh() {
        AppMethodBeat.i(43231);
        final uo uoVar = new uo();
        uoVar.cQJ.cQL = "1";
        uoVar.callback = new Runnable() {
            public final void run() {
                AppMethodBeat.i(43221);
                if (!bo.isNullOrNil(uoVar.cQK.cQM)) {
                    e.a(MallIndexUI.this.omz, uoVar.cQK.cQM, uoVar.cQK.content, uoVar.cQK.url);
                }
                AppMethodBeat.o(43221);
            }
        };
        com.tencent.mm.sdk.b.a.xxA.m(uoVar);
        AppMethodBeat.o(43231);
    }

    /* Access modifiers changed, original: protected|final */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x006d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void bNm() {
        AppMethodBeat.i(43233);
        if (this.omx == null) {
            AppMethodBeat.o(43233);
            return;
        }
        if (!(com.tencent.mm.x.c.PK().b(a.NEW_BANDAGE_DATASOURCE_WALLET_BANKCARD_STRING_SYNC, a.NEW_BANDAGE_WATCHER_WALLET_COMMON_STRING_SYNC) || this.onh.cQV)) {
            int i;
            n nVar = r.cPI().tCW;
            if (nVar != null) {
                int i2 = nVar.field_red_dot_index;
                g.RQ();
                if (((Integer) g.RP().Ry().get(a.USERINFO_LOAN_ENTRANCE_RED_POINT_INT, Integer.valueOf(-1))).intValue() >= i2 || i2 <= 0) {
                    ab.i("MicorMsg.MallIndexUI", "bankcard do not need red point");
                } else {
                    ab.i("MicorMsg.MallIndexUI", "bankcard need red point");
                    i = 1;
                    if (i == 0) {
                        this.omx.setVisibility(8);
                        AppMethodBeat.o(43233);
                        return;
                    }
                }
            }
            i = 0;
            if (i == 0) {
            }
        }
        this.omx.setVisibility(0);
        AppMethodBeat.o(43233);
    }

    /* Access modifiers changed, original: protected|final */
    public final void bNi() {
        AppMethodBeat.i(43234);
        ab.i("MicorMsg.MallIndexUI", "updateBalanceNum");
        ai aiVar = new ai();
        ab.i("MicroMsg.WalletSwitchConfig", "isHideBalanceNum, ret = %s switchBit %s", Boolean.valueOf((aiVar.tCP & 16384) > 0), Integer.valueOf(aiVar.tCP));
        if ((aiVar.tCP & 16384) > 0) {
            g.RQ();
            this.omy.setText((String) g.RP().Ry().get(a.USERINFO_WALLET_RELEAY_NAME_BALANCE_CONTENT_STRING_SYNC, getString(R.string.dil)));
            this.omy.setVisibility(0);
            iQ(aiVar.cQf());
            AppMethodBeat.o(43234);
            return;
        }
        ab.i("MicroMsg.WalletSwitchConfig", "isShowBalanceAmount, ret = %s switchBit %s", Boolean.valueOf((aiVar.tCP & 4194304) > 0), Integer.valueOf(aiVar.tCP));
        if ((aiVar.tCP & 4194304) > 0) {
            long j;
            ab.i("MicorMsg.MallIndexUI", "show balance amount");
            ak cPI = r.cPI();
            if (cPI.tCT != null) {
                j = cPI.tCT.field_wallet_balance;
            } else {
                j = -1;
            }
            if (j < 0) {
                ab.w("MicorMsg.MallIndexUI", "wallet balance is null!");
            } else {
                this.omy.setText(e.G(e.a(String.valueOf(j), "100", 2, RoundingMode.HALF_UP).doubleValue()));
                this.omy.setVisibility(0);
                iQ(aiVar.cQf());
                AppMethodBeat.o(43234);
                return;
            }
        }
        this.omy.setVisibility(8);
        AppMethodBeat.o(43234);
    }

    private void iQ(boolean z) {
        AppMethodBeat.i(43235);
        if (z) {
            this.omy.setText(getString(R.string.ffw));
        }
        AppMethodBeat.o(43235);
    }

    public void onResume() {
        AppMethodBeat.i(43237);
        ab.v("MicorMsg.MallIndexUI", "alvinluo MallIndexUI onResume");
        this.onl.onResume();
        com.tencent.mm.plugin.walletlock.a.b bVar = (com.tencent.mm.plugin.walletlock.a.b) g.K(com.tencent.mm.plugin.walletlock.a.b.class);
        bVar.a(this, bVar.cTi(), null);
        super.onResume();
        AppMethodBeat.o(43237);
    }

    public void onPause() {
        AppMethodBeat.i(43238);
        super.onPause();
        this.onl.onPause();
        AppMethodBeat.o(43238);
    }

    public void onDestroy() {
        AppMethodBeat.i(43239);
        super.onDestroy();
        this.onp.dead();
        this.ons.dead();
        ng(2713);
        ng(385);
        com.tencent.mm.sdk.b.a.xxA.d(this.onr);
        AppMethodBeat.o(43239);
    }

    /* Access modifiers changed, original: protected|final */
    public final void bNa() {
        AppMethodBeat.i(43240);
        com.tencent.mm.plugin.mall.b.a.bNu();
        AppMethodBeat.o(43240);
    }

    /* Access modifiers changed, original: protected|final */
    public final void bNb() {
        AppMethodBeat.i(43241);
        r.cPE().cRh();
        if ((r.cPE().cRh().cQj() || r.cPE().cRh().cQi()) && com.tencent.mm.model.r.YM()) {
            ab.e("MicorMsg.MallIndexUI", "hy: user not open wallet or status unknown. try query");
            a(new com.tencent.mm.plugin.wallet_core.c.b.a("", false), true, false);
        }
        AppMethodBeat.o(43241);
    }

    public void finish() {
        AppMethodBeat.i(43242);
        this.eTM = true;
        super.finish();
        AppMethodBeat.o(43242);
    }

    public final boolean c(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(43243);
        super.c(i, i2, str, mVar);
        if (mVar instanceof com.tencent.mm.plugin.mall.a.e) {
            a(((com.tencent.mm.plugin.mall.a.e) mVar).okN);
        } else if (mVar instanceof y) {
            y yVar = (y) mVar;
            if (yVar.bLD() && yVar.nYe.a((Activity) this, new f() {
                public final void bMI() {
                }
            })) {
                AppMethodBeat.o(43243);
                return true;
            }
        }
        AppMethodBeat.o(43243);
        return true;
    }

    private void a(final com.tencent.mm.plugin.mall.a.d dVar) {
        AppMethodBeat.i(43244);
        if (dVar == null || bo.isNullOrNil(dVar.okM)) {
            AppMethodBeat.o(43244);
        } else if (this.omR) {
            if (this.omQ != null) {
                this.omQ.setText(R.string.cwj);
                this.omQ.setOnClickListener(new OnClickListener() {
                    public final void onClick(View view) {
                        AppMethodBeat.i(43210);
                        Intent intent = new Intent();
                        e.bV(MallIndexUI.this, dVar.okM);
                        AppMethodBeat.o(43210);
                    }
                });
            }
            AppMethodBeat.o(43244);
        } else {
            this.jNV = View.inflate(this, R.layout.abj, null);
            this.jNV.setClickable(false);
            this.jNV.setEnabled(false);
            this.omQ = (TextView) this.jNV.findViewById(R.id.d2x);
            this.omQ.setVisibility(0);
            this.omQ.setText(R.string.cwj);
            this.omQ.setTextColor(getResources().getColor(R.color.t7));
            this.omQ.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(43211);
                    Intent intent = new Intent();
                    intent.putExtra("rawUrl", dVar.okM);
                    d.b(MallIndexUI.this, "webview", ".ui.tools.WebViewUI", intent);
                    AppMethodBeat.o(43211);
                }
            });
            this.omu.addFooterView(this.jNV);
            this.omR = true;
            AppMethodBeat.o(43244);
        }
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(43224);
        this.yll = true;
        ((com.tencent.mm.plugin.walletlock.a.b) g.K(com.tencent.mm.plugin.walletlock.a.b.class)).a(this, null);
        k.Hp(2);
        this.onh = new b();
        this.onh.cQT = false;
        this.onh.cQU = true;
        this.onh.cQV = false;
        this.onp.dnU();
        this.ons.dnU();
        this.onl.tLw = new s.b() {
            public final int bNq() {
                return 3;
            }

            public final Context getContext() {
                return MallIndexUI.this;
            }
        };
        c.iR(true);
        a.a(this, false, true);
        super.onCreate(bundle);
        com.tencent.mm.sdk.b.a.xxA.c(this.onr);
        nf(2713);
        nf(385);
        if (com.tencent.mm.au.b.sO((String) g.RP().Ry().get(274436, null))) {
            g.RQ();
            a(new com.tencent.mm.plugin.mall.a.d((String) g.RP().Ry().get(a.USERINFO_MALL_INDEX_GDPR_CACHE_STRING_SYNC, (Object) "")));
            g.RQ();
            ((Boolean) g.RP().Ry().get(a.USERINFO_MALL_INDEX_GDPR_AGREE_BOOLEAN_SYNC, Boolean.FALSE)).booleanValue();
            a(new com.tencent.mm.plugin.mall.a.e(), false, false);
        }
        h.pYm.e(16500, Integer.valueOf(1));
        AppMethodBeat.o(43224);
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean bNd() {
        AppMethodBeat.i(43232);
        ab.i("MicorMsg.MallIndexUI", "init BankcardList");
        final com.tencent.mm.sdk.b.b uqVar = new uq();
        uqVar.cQP.scene = 1;
        uqVar.cQP.cQR = true;
        uqVar.cQP.cQS = true;
        uqVar.cQQ.cQH = new Runnable() {
            boolean ftW = false;

            public final void run() {
                AppMethodBeat.i(43207);
                ab.d("MicorMsg.MallIndexUI", "mUserInfo needBind : " + MallIndexUI.this.onh.cQU + " hasNewTips : " + MallIndexUI.this.onh.cQV + " swipeOn : " + MallIndexUI.this.onh.cQW);
                if (MallIndexUI.this.eTM || MallIndexUI.this.mController.ylL.isFinishing()) {
                    ab.e("MicorMsg.MallIndexUI", "error for callback ac finish");
                    AppMethodBeat.o(43207);
                    return;
                }
                ab.i("MicorMsg.MallIndexUI", "after get userInfo, isFromCgiEnd: %s, hasCallback: %s", Boolean.valueOf(uqVar.cQQ.cRt), Boolean.valueOf(this.ftW));
                MallIndexUI.this.onh = uqVar.cQQ;
                if (((MallIndexUI.this.onh.cRu != null ? 1 : 0) & (MallIndexUI.this.onh.cRu instanceof com.tencent.mm.wallet_core.tenpay.model.m)) != 0) {
                    com.tencent.mm.wallet_core.tenpay.model.m mVar = (com.tencent.mm.wallet_core.tenpay.model.m) MallIndexUI.this.onh.cRu;
                    if (mVar.bLD()) {
                        mVar.nYe.a(MallIndexUI.this, new f() {
                            public final void bMI() {
                            }
                        });
                    }
                }
                if (MallIndexUI.this.onh.errCode == 0) {
                    MallIndexUI.this.bNm();
                    MallIndexUI.this.bNi();
                    MallIndexUI mallIndexUI = MallIndexUI.this;
                    ab.i("MicorMsg.MallIndexUI", "showGetNewWalletTip call");
                    if (mallIndexUI.onh == null || !(mallIndexUI.onh.cQT || mallIndexUI.onh.cQZ)) {
                        ab.e("MicorMsg.MallIndexUI", "user is not reg or simplereg，should not show this dialog");
                    } else {
                        boolean booleanValue;
                        boolean cQa = r.cPI().cQo().cQa();
                        Object obj = g.RP().Ry().get(a.USERINFO_HAD_SHOW_WALLET_MULTI_WALLET_GUIDE_BOOLEAN, Boolean.FALSE);
                        if (obj != null) {
                            booleanValue = ((Boolean) obj).booleanValue();
                        } else {
                            booleanValue = false;
                        }
                        ab.i("MicorMsg.MallIndexUI", "showGetNewWalletTip hadShow=" + booleanValue + ";isswc=" + cQa);
                        if (!booleanValue && cQa) {
                            g.RP().Ry().set(a.USERINFO_HAD_SHOW_WALLET_MULTI_WALLET_GUIDE_BOOLEAN, Boolean.TRUE);
                            com.tencent.mm.ui.widget.a.c.a aVar = new com.tencent.mm.ui.widget.a.c.a(mallIndexUI);
                            View inflate = LayoutInflater.from(mallIndexUI).inflate(R.layout.b6b, null, false);
                            TextView textView = (TextView) inflate.findViewById(R.id.fhh);
                            ((ImageView) inflate.findViewById(R.id.fhg)).setImageResource(R.drawable.blv);
                            textView.setText(R.string.cwq);
                            aVar.rd(true);
                            aVar.rc(false);
                            aVar.fn(inflate);
                            aVar.PV(R.string.ftt);
                            aVar.Qc(R.string.g0z);
                            aVar.aMb().show();
                        }
                    }
                    if (!this.ftW) {
                        MallIndexUI.bNn();
                    }
                    MallIndexUI.b(MallIndexUI.this, MallIndexUI.this.onh);
                    MallIndexUI.this.bNk();
                    ab.i("MicorMsg.MallIndexUI", "after get userInfo, isShowLqb: %s, isOpenLqb: %s, lqbOpenUrl: %s", Integer.valueOf(MallIndexUI.this.onh.cRq), Boolean.valueOf(MallIndexUI.this.onh.cRr), MallIndexUI.this.onh.cRs);
                    MallIndexUI.this.onj = MallIndexUI.this.onh.cRq == 1;
                    MallIndexUI.this.onk = MallIndexUI.this.onh.cRr;
                    MallIndexUI.this.cRs = MallIndexUI.this.onh.cRs;
                    if (MallIndexUI.this.oni != null) {
                        if (MallIndexUI.this.onj) {
                            MallIndexUI.this.oni.setVisibility(0);
                        } else {
                            MallIndexUI.this.oni.setVisibility(8);
                        }
                    }
                    MallIndexUI mallIndexUI2 = MallIndexUI.this;
                    mallIndexUI2.onl.a(new s.a() {
                        public final void bNo() {
                        }

                        public final void cancel() {
                            AppMethodBeat.i(43208);
                            MallIndexUI.this.finish();
                            AppMethodBeat.o(43208);
                        }

                        public final void bNp() {
                        }
                    }, new ai().cQe());
                }
                if (uqVar.cQQ.cRt && this.ftW) {
                    MallIndexUI.this.cu();
                }
                this.ftW = true;
                AppMethodBeat.o(43207);
            }
        };
        com.tencent.mm.sdk.b.a.xxA.a(uqVar, Looper.myLooper());
        AppMethodBeat.o(43232);
        return false;
    }

    /* Access modifiers changed, original: protected|final */
    public final void bNk() {
        AppMethodBeat.i(43236);
        this.mController.removeAllOptionMenu();
        ab.i("MicorMsg.MallIndexUI", "addIconOptionMenuByMode");
        this.mController.addIconOptionMenu(0, 0, (int) R.drawable.uu, false, new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(43209);
                h.pYm.e(14872, Integer.valueOf(0), Integer.valueOf(0), "", "", Integer.valueOf(0));
                h.pYm.e(16500, Integer.valueOf(3));
                Context context = MallIndexUI.this;
                boolean z = MallIndexUI.this.onh.cRa;
                Intent intent = new Intent();
                intent.putExtra("key_default_show_currency", z);
                d.b(context, "wallet", ".pwd.ui.WalletPasswordSettingUI", intent);
                AppMethodBeat.o(43209);
                return true;
            }
        });
        h.pYm.e(14872, Integer.valueOf(0), Integer.valueOf(0), "", "", Integer.valueOf(1));
        AppMethodBeat.o(43236);
    }

    static /* synthetic */ void c(MallIndexUI mallIndexUI) {
        AppMethodBeat.i(43245);
        if (com.tencent.mm.model.r.YM()) {
            Intent intent = new Intent();
            intent.putExtra("key_scene_balance_manager", 2);
            d.b((Context) mallIndexUI, "wallet_payu", ".balance.ui.WalletPayUBalanceManagerUI", intent);
        } else {
            ImageView imageView = (ImageView) mallIndexUI.findViewById(R.id.d3_);
            mallIndexUI.startActivity(new Intent(mallIndexUI.mController.ylL, MallWalletUI.class));
            imageView.setVisibility(8);
            g.RQ();
            g.RP().Ry().set(a.USERINFO_WALLET_New_MALL_UI_REDDOT_CONFIG_BOOLEAN_SYNC, Boolean.FALSE);
            g.RQ();
            g.RP().Ry().set(a.USERINFO_WALLET_New_MALL_UI_REDDOT_CONFIG_EXPIRETIME_LONG_SYNC, Long.valueOf(0));
            h.pYm.e(16500, Integer.valueOf(2));
        }
        e.QS(11);
        h.pYm.e(14419, mallIndexUI.eCq, Integer.valueOf(2));
        AppMethodBeat.o(43245);
    }

    static /* synthetic */ void bNn() {
        AppMethodBeat.i(43246);
        ab.i("MicorMsg.MallIndexUI", "query wechat wallet");
        com.tencent.mm.plugin.mall.a.i.a(null, false);
        AppMethodBeat.o(43246);
    }
}
