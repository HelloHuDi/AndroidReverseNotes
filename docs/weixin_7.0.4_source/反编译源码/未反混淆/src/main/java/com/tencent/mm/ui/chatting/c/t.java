package com.tencent.mm.ui.chatting.c;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.ActionBarContainer;
import android.text.SpannableString;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.google.android.gms.common.Scopes;
import com.tencent.liteav.network.TXCStreamUploader;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ax.c;
import com.tencent.mm.bp.d;
import com.tencent.mm.g.a.ui;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.b.b;
import com.tencent.mm.model.n;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.e.j;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.ad;
import com.tencent.mm.ui.ServiceNotifySettingsUI;
import com.tencent.mm.ui.SingleChatInfoUI;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.c.b.f;
import com.tencent.mm.ui.chatting.c.b.o;
import com.tencent.mm.ui.chatting.c.b.r;
import com.tencent.mm.ui.chatting.c.b.z;
import com.tencent.mm.ui.conversation.a.e;
import com.tencent.mm.ui.v;
import java.util.LinkedList;
import java.util.List;

@com.tencent.mm.ui.chatting.c.a.a(dFp = r.class)
public class t extends a implements r {
    private int qvb = 0;
    private final com.tencent.mm.sdk.e.k.a yOu = new com.tencent.mm.sdk.e.k.a() {
        public final void a(String str, m mVar) {
            AppMethodBeat.i(31478);
            ab.v("MicroMsg.ChattingUI.HeaderComponent", "roommember watcher notify ".concat(String.valueOf(str)));
            if (t.this.cgL.dFx() && !bo.isNullOrNil(str)) {
                t.this.dEm();
                t.this.dEp();
            }
            AppMethodBeat.o(31478);
        }
    };
    private boolean yOx = false;
    protected LinearLayout yQi;
    protected LinearLayout yQj;
    private List<String> yQk = new LinkedList();
    private String yQl;
    private ActionBarContainer yQm = null;
    public com.tencent.mm.ui.r yQn = null;
    private com.tencent.mm.ui.a yQo;
    private View yQp;
    final com.tencent.mm.ui.t yQq = new a();
    private com.tencent.mm.model.b.b.a yQr = new com.tencent.mm.model.b.b.a() {
        public final void aaW() {
            AppMethodBeat.i(31473);
            com.tencent.mm.ui.chatting.d.a.dFz().post(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(31472);
                    aw.ZK().Ym();
                    if (b.a(b.b.Chatting)) {
                        t.b(t.this);
                        AppMethodBeat.o(31472);
                        return;
                    }
                    t.c(t.this);
                    AppMethodBeat.o(31472);
                }
            });
            AppMethodBeat.o(31473);
        }
    };
    private Runnable yQs = null;
    private final com.tencent.mm.ah.d.a yQt = new com.tencent.mm.ah.d.a() {
        public final void qj(final String str) {
            AppMethodBeat.i(31477);
            com.tencent.mm.ui.chatting.d.a.dFz().removeCallbacks(t.this.yQs);
            com.tencent.mm.ui.chatting.d.a.dFz().postDelayed(t.this.yQs = new Runnable() {
                public final void run() {
                    AppMethodBeat.i(31476);
                    if (!(bo.isNullOrNil(t.this.yQl) || bo.isNullOrNil(str) || !str.equals(t.this.yQl))) {
                        t.this.qr(false);
                    }
                    AppMethodBeat.o(31476);
                }
            }, 1000);
            AppMethodBeat.o(31477);
        }
    };
    private OnMenuItemClickListener yQu = new OnMenuItemClickListener() {
        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.i(31485);
            boolean dBP = t.this.cgL.yTx.dBP();
            AppMethodBeat.o(31485);
            return dBP;
        }
    };
    final int yQv = 1;
    final int yQw = 2;
    final OnMenuItemClickListener yQx = new OnMenuItemClickListener() {
        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.i(31486);
            ui uiVar = new ui();
            uiVar.cQx.cAd = 5;
            uiVar.cQx.talker = t.this.cgL.sRl.field_username;
            uiVar.cQx.context = t.this.cgL.yTx.getContext();
            if (menuItem.getItemId() == 1) {
                uiVar.cQx.cQs = 4;
            } else if (menuItem.getItemId() == 2) {
                uiVar.cQx.cQs = 2;
            }
            com.tencent.mm.sdk.b.a.xxA.m(uiVar);
            AppMethodBeat.o(31486);
            return true;
        }
    };
    private View yQy = null;
    private View yQz = null;

    class a extends com.tencent.mm.ui.t {
        a() {
        }

        public final void Kp() {
            AppMethodBeat.i(31492);
            if (com.tencent.mm.model.t.mP(t.this.cgL.getTalkerUserName())) {
                com.tencent.mm.g.b.a.t tVar = new com.tencent.mm.g.b.a.t();
                tVar.eO(t.this.cgL.getTalkerUserName());
                tVar.cXP = 4;
                tVar.ajK();
            }
            t.this.cgL.aqX();
            Intent intent;
            if (com.tencent.mm.model.t.nD(t.this.cgL.getTalkerUserName())) {
                t.this.cgL.yTx.getContext().startActivity(new Intent(t.this.cgL.yTx.getContext(), ServiceNotifySettingsUI.class));
                AppMethodBeat.o(31492);
            } else if (com.tencent.mm.model.t.mV(t.this.cgL.getTalkerUserName())) {
                intent = new Intent();
                intent.putExtra("Contact_User", t.this.cgL.getTalkerUserName());
                d.b(t.this.cgL.yTx.getContext(), Scopes.PROFILE, ".ui.ContactInfoUI", intent);
                AppMethodBeat.o(31492);
            } else if (((com.tencent.mm.ui.chatting.c.b.t) t.this.cgL.aF(com.tencent.mm.ui.chatting.c.b.t.class)).dEF()) {
                t.a(t.this);
                AppMethodBeat.o(31492);
            } else if (((com.tencent.mm.ui.chatting.c.b.d) t.this.cgL.aF(com.tencent.mm.ui.chatting.c.b.d.class)).dDx()) {
                AppMethodBeat.o(31492);
            } else {
                intent = new Intent();
                intent.setClass(t.this.cgL.yTx.getContext(), SingleChatInfoUI.class);
                intent.putExtra("Single_Chat_Talker", t.this.cgL.getTalkerUserName());
                intent.putExtra("fromChatting", true);
                t.this.cgL.yTx.startActivity(intent);
                AppMethodBeat.o(31492);
            }
        }
    }

    public t() {
        AppMethodBeat.i(31493);
        AppMethodBeat.o(31493);
    }

    static /* synthetic */ void c(t tVar) {
        AppMethodBeat.i(31535);
        tVar.dEw();
        AppMethodBeat.o(31535);
    }

    static /* synthetic */ void f(t tVar) {
        AppMethodBeat.i(31536);
        tVar.dEs();
        AppMethodBeat.o(31536);
    }

    static /* synthetic */ void g(t tVar) {
        AppMethodBeat.i(31537);
        tVar.dEt();
        AppMethodBeat.o(31537);
    }

    static /* synthetic */ void h(t tVar) {
        AppMethodBeat.i(31538);
        tVar.dEu();
        AppMethodBeat.o(31538);
    }

    static /* synthetic */ void i(t tVar) {
        AppMethodBeat.i(31539);
        tVar.dEv();
        AppMethodBeat.o(31539);
    }

    public final void onConfigurationChanged(Configuration configuration) {
        int i = 1;
        AppMethodBeat.i(31494);
        super.onConfigurationChanged(configuration);
        ab.d("MicroMsg.ChattingUI.HeaderComponent", "getConfiguration().orientation = " + this.cgL.yTx.getMMResources().getConfiguration().orientation + ", newConfig.orientation = " + configuration.orientation);
        this.cgL.yTx.getMMResources().getConfiguration().orientation = configuration.orientation;
        ((o) this.cgL.aF(o.class)).dDX().djS();
        int i2 = this.yQm != null ? 1 : 0;
        if (this.yQp == null) {
            i = 0;
        }
        if ((i2 & i) != 0) {
            i = com.tencent.mm.compatible.util.a.bG(this.cgL.yTx.getContext());
            this.yQp.setMinimumHeight(i);
            LayoutParams layoutParams = this.yQp.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new LayoutParams(-1, -1);
            }
            layoutParams.height = i;
            this.yQp.setLayoutParams(layoutParams);
            layoutParams = this.yQm.getLayoutParams();
            layoutParams.height = i;
            this.yQm.setLayoutParams(layoutParams);
        }
        if (this.yQn != null) {
            this.yQn.ymW.mActionBar.onConfigurationChanged(configuration);
        }
        AppMethodBeat.o(31494);
    }

    public final void a(com.tencent.mm.ui.chatting.d.a aVar) {
        AppMethodBeat.i(31495);
        super.a(aVar);
        if (isSupportCustomActionBar()) {
            this.yQn = new com.tencent.mm.ui.r();
            com.tencent.mm.ui.r rVar = this.yQn;
            BaseChattingUIFragment baseChattingUIFragment = this.cgL.yTx;
            rVar.ymV = baseChattingUIFragment;
            rVar.ymW = new com.tencent.mm.ui.b.b(baseChattingUIFragment.thisActivity(), rVar);
            this.cgL.yTx.setActivityController(this.yQn);
        }
        AppMethodBeat.o(31495);
    }

    public final void dxx() {
        AppMethodBeat.i(31496);
        dEn();
        AppMethodBeat.o(31496);
    }

    public final void dxz() {
        AppMethodBeat.i(31498);
        qr(true);
        AppMethodBeat.o(31498);
    }

    public final void dxC() {
        AppMethodBeat.i(31501);
        dEl();
        AppMethodBeat.o(31501);
    }

    public final void dDh() {
        AppMethodBeat.i(31502);
        super.dDh();
        dEl();
        AppMethodBeat.o(31502);
    }

    public final void dEk() {
        AppMethodBeat.i(31503);
        if (this.cgL.getHeaderViewsCount() > 0) {
            this.yQi = (LinearLayout) this.cgL.getListView().findViewById(R.id.au0);
        } else {
            this.yQi = (LinearLayout) this.cgL.yTx.getContext().getLayoutInflater().inflate(R.layout.nv, null);
            com.tencent.mm.ui.chatting.d.a aVar = this.cgL;
            aVar.yTy.addHeaderView(this.yQi);
        }
        dEt();
        AppMethodBeat.o(31503);
    }

    private void dBr() {
        AppMethodBeat.i(31504);
        if (com.tencent.mm.model.t.mU(this.cgL.getTalkerUserName())) {
            com.tencent.mm.plugin.r.a.bVv();
            this.cgL.yTx.addIconOptionMenu(0, (int) R.string.cg, (int) R.raw.actionbar_setting_icon, Boolean.valueOf(c.lQ(com.tencent.mm.ax.b.fKF)).booleanValue(), this.yQq);
        }
        AppMethodBeat.o(31504);
    }

    private void dEl() {
        AppMethodBeat.i(31505);
        if (g.RN().QY()) {
            com.tencent.mm.ah.o.acd().b(this.yQt);
            aw.ZK();
            com.tencent.mm.model.c.XV().d(this.yOu);
        }
        com.tencent.mm.ui.chatting.d.a.dFz().removeCallbacks(this.yQs);
        AppMethodBeat.o(31505);
    }

    public final void dEm() {
        AppMethodBeat.i(31506);
        this.cgL.yTx.setMMSubTitle(null);
        if (com.tencent.mm.model.t.mU(this.cgL.getTalkerUserName())) {
            M(this.cgL.sRl.Oi());
            AppMethodBeat.o(31506);
        } else if (((z) this.cgL.aF(z.class)).dET()) {
            setMMTitle(R.string.dzg);
            AppMethodBeat.o(31506);
        } else if (ad.aou(this.cgL.getTalkerUserName())) {
            ((o) this.cgL.aF(o.class)).dDX().setWordCountLimit(140);
            M(this.cgL.sRl.Oj());
            AppMethodBeat.o(31506);
        } else if (com.tencent.mm.model.t.nF(this.cgL.getTalkerUserName())) {
            M(this.cgL.sRl.Oi());
            AppMethodBeat.o(31506);
        } else if (ad.mR(this.cgL.getTalkerUserName())) {
            M(this.cgL.yTx.getContext().getString(R.string.aa8, new Object[]{b(this.cgL.sRl)}).trim());
            AppMethodBeat.o(31506);
        } else {
            if (ad.mg(this.cgL.getTalkerUserName())) {
                if (this.cgL.aF(com.tencent.mm.ui.chatting.c.b.a.class) != null) {
                    ((com.tencent.mm.ui.chatting.c.b.a) this.cgL.aF(com.tencent.mm.ui.chatting.c.b.a.class)).dEm();
                    AppMethodBeat.o(31506);
                    return;
                }
            } else if (this.cgL.dFw()) {
                if (com.tencent.mm.model.t.mO(this.cgL.getTalkerUserName())) {
                    if (!bo.isNullOrNil(this.cgL.sRl.field_nickname)) {
                        M(this.cgL.yTx.getContext().getString(R.string.bwu, new Object[]{this.cgL.sRl.Oi(), Integer.valueOf(n.mA(this.cgL.getTalkerUserName()))}));
                        AppMethodBeat.o(31506);
                        return;
                    } else if (n.mA(this.cgL.getTalkerUserName()) == 0) {
                        M(this.cgL.yTx.getContext().getString(R.string.ao1));
                        AppMethodBeat.o(31506);
                        return;
                    } else {
                        M(this.cgL.yTx.getContext().getString(R.string.bwu, new Object[]{this.cgL.yTx.getContext().getString(R.string.ao1), Integer.valueOf(n.mA(this.cgL.getTalkerUserName()))}));
                        AppMethodBeat.o(31506);
                        return;
                    }
                } else if (com.tencent.mm.model.t.mP(this.cgL.getTalkerUserName())) {
                    CharSequence string;
                    if (!bo.isNullOrNil(this.cgL.sRl.field_nickname)) {
                        string = this.cgL.yTx.getContext().getString(R.string.bwu, new Object[]{this.cgL.sRl.Oi(), Integer.valueOf(n.mA(this.cgL.getTalkerUserName()))});
                    } else if (n.mA(this.cgL.getTalkerUserName()) == 0) {
                        string = this.cgL.yTx.getContext().getString(R.string.ao1);
                    } else {
                        string = this.cgL.yTx.getContext().getString(R.string.bwu, new Object[]{this.cgL.yTx.getContext().getString(R.string.ao1), Integer.valueOf(n.mA(this.cgL.getTalkerUserName()))});
                    }
                    M(j.c(this.cgL.yTx.getContext(), j.b(this.cgL.yTx.getContext(), string, com.tencent.mm.bz.a.al(this.cgL.yTx.getContext(), R.dimen.dt))));
                    AppMethodBeat.o(31506);
                    return;
                }
            } else if (((com.tencent.mm.ui.chatting.c.b.d) this.cgL.aF(com.tencent.mm.ui.chatting.c.b.d.class)).dDo()) {
                AppMethodBeat.o(31506);
                return;
            } else {
                this.yQo.pw(ad.aow(this.cgL.getTalkerUserName()));
                this.cgL.yTx.setMMTitle(this.cgL.sRl.Oj());
                this.yQo.pw(ad.aow(this.cgL.getTalkerUserName()));
                if (ad.aox(this.cgL.getTalkerUserName())) {
                    this.cgL.yTx.setMMSubTitle(((com.tencent.mm.openim.a.b) g.K(com.tencent.mm.openim.a.b.class)).ba(this.cgL.sRl.field_openImAppid, this.cgL.sRl.field_descWordingId));
                }
            }
            AppMethodBeat.o(31506);
        }
    }

    public final void setMMTitle(int i) {
        AppMethodBeat.i(31507);
        M(this.cgL.yTx.getMMResources().getString(i));
        AppMethodBeat.o(31507);
    }

    private String b(ad adVar) {
        AppMethodBeat.i(31508);
        String string;
        if (adVar == null) {
            string = this.cgL.yTx.getContext().getString(R.string.ab0);
            AppMethodBeat.o(31508);
            return string;
        } else if (RegionCodeDecoder.apQ(adVar.getCountryCode())) {
            string = adVar.getCity();
            if (bo.isNullOrNil(string)) {
                string = s.mL(adVar.getProvince());
                if (bo.isNullOrNil(string)) {
                    RegionCodeDecoder.duj();
                    string = RegionCodeDecoder.getLocName(adVar.getCountryCode());
                    AppMethodBeat.o(31508);
                    return string;
                }
                AppMethodBeat.o(31508);
                return string;
            }
            AppMethodBeat.o(31508);
            return string;
        } else {
            string = s.mL(adVar.getProvince());
            if (bo.isNullOrNil(string)) {
                string = this.cgL.yTx.getContext().getString(R.string.ab0);
                AppMethodBeat.o(31508);
                return string;
            }
            AppMethodBeat.o(31508);
            return string;
        }
    }

    private boolean isSupportCustomActionBar() {
        AppMethodBeat.i(31509);
        boolean isSupportNavigationSwipeBack = this.cgL.yTx.isSupportNavigationSwipeBack();
        AppMethodBeat.o(31509);
        return isSupportNavigationSwipeBack;
    }

    public final void eM(View view) {
        AppMethodBeat.i(31510);
        ab.d("MicroMsg.ChattingUI.HeaderComponent", "dealContentView");
        if (isSupportCustomActionBar()) {
            if (this.yQm == null) {
                this.yQm = (ActionBarContainer) ((ViewStub) view.findViewById(R.id.alg)).inflate();
            }
            this.yQn.ymW.SW = (ViewGroup) view;
        }
        AppMethodBeat.o(31510);
    }

    private View w(ViewGroup viewGroup) {
        AppMethodBeat.i(31511);
        View view;
        if (this.yQp == null) {
            if (viewGroup == null) {
                this.yQp = v.hu(this.cgL.yTx.getContext()).inflate(R.layout.a_, null);
            } else {
                this.yQp = v.hu(this.cgL.yTx.getContext()).inflate(R.layout.a_, viewGroup, false);
            }
            view = this.yQp;
            AppMethodBeat.o(31511);
            return view;
        } else if (this.yQp.getParent() == null) {
            view = this.yQp;
            AppMethodBeat.o(31511);
            return view;
        } else if (this.yQp.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.yQp.getParent()).removeView(this.yQp);
            view = this.yQp;
            AppMethodBeat.o(31511);
            return view;
        } else {
            if (viewGroup == null) {
                this.yQp = v.hu(this.cgL.yTx.getContext()).inflate(R.layout.a_, null);
            } else {
                this.yQp = v.hu(this.cgL.yTx.getContext()).inflate(R.layout.a_, viewGroup, false);
            }
            view = this.yQp;
            AppMethodBeat.o(31511);
            return view;
        }
    }

    public final void dEn() {
        ActionBar supportActionBar;
        AppMethodBeat.i(31512);
        if (this.cgL.yTx.isCurrentActivity || !isSupportCustomActionBar()) {
            supportActionBar = ((AppCompatActivity) this.cgL.yTx.getContext()).getSupportActionBar();
            View w = w(null);
            supportActionBar.setCustomView(w);
            this.yQo = new com.tencent.mm.ui.a(w);
        } else {
            ViewGroup viewGroup = (ViewGroup) this.yQm.findViewById(R.id.k1);
            ab.i("MicroMsg.ChattingUI.HeaderComponent", "mActionBarContainer %s", this.yQm);
            ab.i("MicroMsg.ChattingUI.HeaderComponent", "ctxView %s", this.yQm.findViewById(R.id.k2));
            viewGroup.setVisibility(0);
            ActionBar supportActionBar2 = this.yQn.getSupportActionBar();
            View w2 = w(viewGroup);
            supportActionBar2.setCustomView(w2);
            this.yQo = new com.tencent.mm.ui.a(w2);
            int height = supportActionBar2.getHeight();
            if (height == 0) {
                DisplayMetrics displayMetrics = this.cgL.yTx.getMMResources().getDisplayMetrics();
                if (displayMetrics.widthPixels > displayMetrics.heightPixels) {
                    height = this.cgL.yTx.getMMResources().getDimensionPixelSize(R.dimen.fc);
                } else {
                    height = this.cgL.yTx.getMMResources().getDimensionPixelSize(R.dimen.fd);
                }
            }
            w2.setMinimumHeight(height);
            LayoutParams layoutParams = w2.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new LayoutParams(-1, -1);
            }
            layoutParams.height = height;
            w2.setLayoutParams(layoutParams);
            supportActionBar = supportActionBar2;
        }
        a(supportActionBar);
        this.yQo.pw(false);
        supportActionBar.setDisplayOptions((((supportActionBar.getDisplayOptions() | 16) & -5) & -3) & -9);
        dEo();
        setBackBtn(this.yQu);
        AppMethodBeat.o(31512);
    }

    private static void a(ActionBar actionBar) {
        AppMethodBeat.i(31513);
        if (actionBar.getCustomView() != null) {
            actionBar.getCustomView().findViewById(R.id.kn);
            actionBar.getCustomView().findViewById(R.id.ko);
            actionBar.getCustomView().findViewById(R.id.kp);
            actionBar.getCustomView().findViewById(R.id.kr);
            actionBar.getCustomView().findViewById(R.id.ks);
        }
        AppMethodBeat.o(31513);
    }

    private void dEo() {
        AppMethodBeat.i(31514);
        this.yQk.clear();
        this.yQk.add(this.cgL.yTx.getStringExtra("Chat_User"));
        AppMethodBeat.o(31514);
    }

    public final void dEp() {
        AppMethodBeat.i(31515);
        z zVar = (z) this.cgL.aF(z.class);
        if (zVar.dET() || zVar.dES()) {
            this.cgL.showOptionMenu(false);
            AppMethodBeat.o(31515);
        } else if (((com.tencent.mm.ui.chatting.c.b.n) this.cgL.aF(com.tencent.mm.ui.chatting.c.b.n.class)).dDW()) {
            AppMethodBeat.o(31515);
        } else {
            if (com.tencent.mm.model.t.mU(this.cgL.getTalkerUserName())) {
                com.tencent.mm.plugin.r.a.bVv();
                this.cgL.yTx.addIconOptionMenu(0, (int) R.string.cg, (int) R.raw.actionbar_setting_icon, Boolean.valueOf(c.lQ(com.tencent.mm.ax.b.fKF)).booleanValue(), this.yQq);
            } else if (com.tencent.mm.model.t.mV(this.cgL.getTalkerUserName())) {
                a(R.string.cg, R.raw.actionbar_setting_icon, this.yQq);
            } else if (com.tencent.mm.model.t.nc(this.cgL.getTalkerUserName())) {
                a(R.string.cg, R.raw.actionbar_setting_icon, this.yQq);
                h.pYm.X(10071, "1");
            } else if (com.tencent.mm.model.t.nd(this.cgL.getTalkerUserName())) {
                a(R.string.cg, R.raw.actionbar_setting_icon, this.yQq);
            } else if (com.tencent.mm.model.t.nD(this.cgL.getTalkerUserName())) {
                a(R.string.cg, R.raw.actionbar_setting_icon, this.yQq);
            } else if (com.tencent.mm.model.t.nI(this.cgL.getTalkerUserName())) {
                if (com.tencent.mm.model.t.no(this.cgL.getTalkerUserName())) {
                    this.cgL.showOptionMenu(false);
                    AppMethodBeat.o(31515);
                    return;
                }
                a(R.string.cg, R.raw.actionbar_setting_icon, this.yQq);
            } else if (ad.aou(this.cgL.getTalkerUserName()) || ad.aow(this.cgL.getTalkerUserName()) || ad.mR(this.cgL.getTalkerUserName())) {
                a(R.string.anl, R.raw.actionbar_icon_dark_more, this.yQq);
            } else if (ad.mg(this.cgL.getTalkerUserName())) {
                if (this.cgL.aF(com.tencent.mm.ui.chatting.c.b.a.class) != null) {
                    ((com.tencent.mm.ui.chatting.c.b.a) this.cgL.aF(com.tencent.mm.ui.chatting.c.b.a.class)).dFq();
                }
            } else if (((com.tencent.mm.ui.chatting.c.b.v) this.cgL.aF(com.tencent.mm.ui.chatting.c.b.v.class)).dEL() && i.arl(this.cgL.getTalkerUserName())) {
                a(R.string.anl, R.raw.ofm_add_icon, this.yQq);
            } else {
                ((x) this.cgL.aF(x.class)).dEE();
                com.tencent.mm.ui.chatting.c.b.d dVar = (com.tencent.mm.ui.chatting.c.b.d) this.cgL.aF(com.tencent.mm.ui.chatting.c.b.d.class);
                if (!com.tencent.mm.model.t.mN(this.cgL.getTalkerUserName()) && !dVar.dDm()) {
                    a(R.string.anl, R.raw.actionbar_icon_dark_more, this.yQq);
                } else if (((f) this.cgL.aF(f.class)).dDF()) {
                    ab.i("MicroMsg.ChattingUI.HeaderComponent", "cpan show chatroom right btn");
                    a(R.string.anl, R.raw.actionbar_icon_dark_more, this.yQq);
                    this.cgL.showOptionMenu(true);
                } else if (!dVar.dDm() || dVar.dDn()) {
                    this.cgL.showOptionMenu(false);
                    AppMethodBeat.o(31515);
                    return;
                } else {
                    a(R.string.anl, R.raw.actionbar_particular_icon, this.yQq);
                    this.cgL.showOptionMenu(true);
                }
            }
            if (ad.mR(this.cgL.getTalkerUserName())) {
                this.cgL.qv(true);
                AppMethodBeat.o(31515);
                return;
            }
            this.cgL.showOptionMenu(true);
            AppMethodBeat.o(31515);
        }
    }

    private void a(int i, int i2, OnMenuItemClickListener onMenuItemClickListener) {
        AppMethodBeat.i(31516);
        if (this.cgL.yTx.findMenuInfo(0) == null) {
            this.cgL.yTx.addIconOptionMenu(0, i, i2, onMenuItemClickListener);
            AppMethodBeat.o(31516);
            return;
        }
        this.cgL.yTx.updateOptionMenu(0, i, i2, onMenuItemClickListener);
        AppMethodBeat.o(31516);
    }

    public final void qr(boolean z) {
        AppMethodBeat.i(31517);
        if (this.cgL == null) {
            ab.e("MicroMsg.ChattingUI.HeaderComponent", "[updateBannerStatus] mChattingContext == null!");
            AppMethodBeat.o(31517);
            return;
        }
        if (this.cgL.dFx()) {
            this.yQl = i.ark(this.cgL.getTalkerUserName());
            if (bo.isNullOrNil(this.yQl) || !(((f) this.cgL.aF(f.class)).dDF() || ((com.tencent.mm.ui.chatting.c.b.d) this.cgL.aF(com.tencent.mm.ui.chatting.c.b.d.class)).dDs())) {
                dEt();
            } else {
                dEr();
            }
        } else if (i.arl(this.cgL.getTalkerUserName()) && !((com.tencent.mm.ui.chatting.c.b.v) this.cgL.aF(com.tencent.mm.ui.chatting.c.b.v.class)).dEL()) {
            this.yQl = this.cgL.getTalkerUserName();
            dEr();
        } else if (!((com.tencent.mm.ui.chatting.c.b.t) this.cgL.aF(com.tencent.mm.ui.chatting.c.b.t.class)).dEG()) {
            dEs();
        }
        if (z) {
            dEu();
            dEq();
        }
        AppMethodBeat.o(31517);
    }

    private void dEq() {
        AppMethodBeat.i(31518);
        if (this.cgL.yTx.getContext() == null) {
            ab.w("MicroMsg.ChattingUI.HeaderComponent", "getActivity is null");
            AppMethodBeat.o(31518);
            return;
        }
        dEw();
        ViewGroup viewGroup = (ViewGroup) this.cgL.yTx.getContext().findViewById(R.id.alv);
        com.tencent.mm.pluginsdk.ui.b.a a = e.a(this.cgL.yTx.getContext(), com.tencent.mm.ui.conversation.a.e.a.CHATTING_MONITORED_HINT, new Object[]{b.b.Chatting});
        if (!(viewGroup == null || a == null || a.getView() == null || this.yQz != null)) {
            this.yQz = a.getView();
            viewGroup.addView(this.yQz, new LayoutParams(-1, -2));
        }
        AppMethodBeat.o(31518);
    }

    @SuppressLint({"ResourceType"})
    public final void dEr() {
        LinearLayout linearLayout;
        AppMethodBeat.i(31519);
        dEt();
        if (this.yQj == null) {
            i.a(this.cgL.yTx, R.id.alh);
            this.yQj = (LinearLayout) this.cgL.yTx.getContext().findViewById(R.id.amb);
            LinearLayout linearLayout2 = (LinearLayout) this.cgL.yTx.getContext().getLayoutInflater().inflate(R.layout.nu, null);
            this.yQj.addView(linearLayout2, new LayoutParams(-1, -2));
            linearLayout = linearLayout2;
        } else {
            linearLayout = (LinearLayout) this.yQj.findViewById(R.id.atw);
        }
        this.yQj.setVisibility(0);
        linearLayout.setVisibility(0);
        ImageView imageView = (ImageView) linearLayout.findViewById(R.id.atx);
        String str = this.yQl;
        if (bo.isNullOrNil(str)) {
            str = this.cgL.sRl.field_username;
        }
        Bitmap a = com.tencent.mm.ah.b.a(str, false, -1);
        if (a == null) {
            imageView.setImageResource(R.raw.default_avatar);
        } else {
            imageView.setImageBitmap(a);
        }
        Button button = (Button) linearLayout.findViewById(R.id.atz);
        if (((com.tencent.mm.ui.chatting.c.b.t) this.cgL.aF(com.tencent.mm.ui.chatting.c.b.t.class)).dEF()) {
            ((com.tencent.mm.ui.chatting.c.b.t) this.cgL.aF(com.tencent.mm.ui.chatting.c.b.t.class)).a(button, linearLayout, this.yQj);
        }
        imageView.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(31487);
                t.a(t.this);
                AppMethodBeat.o(31487);
            }
        });
        button.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(31491);
                if (((com.tencent.mm.ui.chatting.c.b.t) t.this.cgL.aF(com.tencent.mm.ui.chatting.c.b.t.class)).dEF()) {
                    ((com.tencent.mm.ui.chatting.c.b.t) t.this.cgL.aF(com.tencent.mm.ui.chatting.c.b.t.class)).OC(t.this.qvb);
                    AppMethodBeat.o(31491);
                    return;
                }
                CharSequence charSequence;
                if (((int) t.this.cgL.sRl.ewQ) == 0) {
                    aw.ZK();
                    if (com.tencent.mm.model.c.XM().aa(t.this.cgL.sRl) != -1) {
                        ab.e("MicroMsg.ChattingUI.HeaderComponent", "[insertRetId] successfully! username:%s", t.this.cgL.sRl);
                    }
                }
                if (com.tencent.mm.model.t.kH(t.this.cgL.sRl.field_username)) {
                    charSequence = t.this.cgL.sRl.field_username;
                } else {
                    charSequence = "";
                }
                aw.ZK();
                ad aoO = com.tencent.mm.model.c.XM().aoO(t.this.yQl);
                CharSequence bc = aoO != null ? bo.bc(aoO.dus, "") : "";
                ab.i("MicroMsg.ChattingUI.HeaderComponent", "dkverify banner add:%s chat:%s ticket", t.this.yQl, charSequence, bc);
                if ((TextUtils.isEmpty(charSequence) || !TextUtils.isEmpty(bc)) && !ad.aox(aoO.field_username)) {
                    com.tencent.mm.pluginsdk.ui.applet.a aVar = new com.tencent.mm.pluginsdk.ui.applet.a(t.this.cgL.yTx.getContext(), new com.tencent.mm.pluginsdk.ui.applet.a.a() {
                        public final void a(boolean z, boolean z2, String str, String str2) {
                            AppMethodBeat.i(31488);
                            if (z) {
                                com.tencent.mm.model.t.q(t.this.cgL.sRl);
                                linearLayout.setVisibility(8);
                            }
                            AppMethodBeat.o(31488);
                        }
                    });
                    LinkedList linkedList = new LinkedList();
                    linkedList.add(Integer.valueOf(3));
                    aVar.ajw(bc);
                    aVar.c(t.this.yQl, charSequence, linkedList);
                } else {
                    com.tencent.mm.model.ao.a.flu.a(t.this.yQl, charSequence, new com.tencent.mm.model.ao.b.a() {
                        public final void o(String str, boolean z) {
                            AppMethodBeat.i(31490);
                            com.tencent.mm.pluginsdk.ui.applet.a aVar = new com.tencent.mm.pluginsdk.ui.applet.a(t.this.cgL.yTx.getContext(), new com.tencent.mm.pluginsdk.ui.applet.a.a() {
                                public final void a(boolean z, boolean z2, String str, String str2) {
                                    AppMethodBeat.i(31489);
                                    if (z) {
                                        com.tencent.mm.model.t.q(t.this.cgL.sRl);
                                        linearLayout.setVisibility(8);
                                    }
                                    AppMethodBeat.o(31489);
                                }
                            });
                            LinkedList linkedList = new LinkedList();
                            linkedList.add(Integer.valueOf(3));
                            aw.ZK();
                            ad aoO = com.tencent.mm.model.c.XM().aoO(t.this.yQl);
                            aVar.ajw(aoO != null ? bo.bc(aoO.dus, "") : "");
                            aVar.c(t.this.yQl, charSequence, linkedList);
                            AppMethodBeat.o(31490);
                        }
                    });
                }
                h.pYm.e(11004, t.this.yQl, Integer.valueOf(3));
                AppMethodBeat.o(31491);
            }
        });
        h.pYm.e(11004, this.yQl, Integer.valueOf(1));
        AppMethodBeat.o(31519);
    }

    private void dEs() {
        AppMethodBeat.i(31520);
        if (this.cgL.dFx() || this.yQi == null) {
            dEt();
            AppMethodBeat.o(31520);
            return;
        }
        Object a;
        dEt();
        if (this.yQi.getTag() == null) {
            a = e.a(this.cgL.yTx.getContext(), com.tencent.mm.ui.conversation.a.e.a.CHATTING_RECOMMEND_BANNER, new Object[]{this.cgL.getTalkerUserName(), this.cgL.dDw()});
            if (!(a == null || a.getView() == null)) {
                this.yQi.addView(a.getView(), new LayoutParams(-1, -2));
            }
        } else {
            com.tencent.mm.pluginsdk.ui.b.a a2 = (com.tencent.mm.pluginsdk.ui.b.a) this.yQi.getTag();
        }
        if (a2 != null) {
            this.yQi.setVisibility(0);
            this.yQi.setTag(a2);
        }
        h.pYm.e(TXCStreamUploader.TXE_UPLOAD_INFO_NET_BUSY, this.cgL.getTalkerUserName(), Integer.valueOf(1), Integer.valueOf(0));
        AppMethodBeat.o(31520);
    }

    private void dEt() {
        AppMethodBeat.i(31521);
        this.yQi.setVisibility(8);
        if (this.yQj != null) {
            this.yQj.setVisibility(8);
        }
        AppMethodBeat.o(31521);
    }

    private void dEu() {
        AppMethodBeat.i(31522);
        if (this.cgL.yTx.getContext() == null) {
            ab.w("MicroMsg.ChattingUI.HeaderComponent", "getActivity is null");
            AppMethodBeat.o(31522);
            return;
        }
        dEv();
        ViewGroup viewGroup = (ViewGroup) this.cgL.yTx.getContext().findViewById(R.id.ali);
        com.tencent.mm.pluginsdk.ui.b.a a = e.a(this.cgL.yTx.getContext(), com.tencent.mm.ui.conversation.a.e.a.CHATTING_SECURITY_BANNER, new Object[]{this.cgL.getTalkerUserName(), this.cgL.dDw(), Boolean.valueOf(this.cgL.dFx())});
        if (!(viewGroup == null || a == null || a.getView() == null || this.yQy != null)) {
            this.yQy = a.getView();
            viewGroup.addView(this.yQy, new LayoutParams(-1, -2));
        }
        AppMethodBeat.o(31522);
    }

    private void dEv() {
        AppMethodBeat.i(31523);
        ViewGroup viewGroup = (ViewGroup) this.cgL.yTx.getContext().findViewById(R.id.ali);
        if (!(viewGroup == null || this.yQy == null)) {
            viewGroup.removeView(this.yQy);
            this.yQy = null;
        }
        AppMethodBeat.o(31523);
    }

    private void dEw() {
        AppMethodBeat.i(31524);
        ViewGroup viewGroup = (ViewGroup) this.cgL.yTx.getContext().findViewById(R.id.alv);
        if (!(viewGroup == null || this.yQz == null)) {
            viewGroup.removeView(this.yQz);
            this.yQz = null;
        }
        AppMethodBeat.o(31524);
    }

    public final int dEx() {
        AppMethodBeat.i(31525);
        int i = 0;
        if (this.yQi != null && this.yQi.isShown()) {
            i = this.yQi.getHeight() + 0;
        }
        AppMethodBeat.o(31525);
        return i;
    }

    public final void M(CharSequence charSequence) {
        AppMethodBeat.i(31526);
        if (com.tencent.mm.model.t.mP(this.cgL.getTalkerUserName())) {
            this.yQo.setTitle(charSequence);
            this.cgL.yTx.updateDescription(this.cgL.yTx.getContext().getString(R.string.ak0, new Object[]{charSequence}));
            AppMethodBeat.o(31526);
        } else if (ad.aox(this.cgL.sRl.field_username)) {
            this.yQo.setTitle(((com.tencent.mm.openim.a.b) g.K(com.tencent.mm.openim.a.b.class)).e(ah.getContext(), charSequence.toString(), com.tencent.mm.bz.a.al(ah.getContext(), R.dimen.dt)));
            this.cgL.yTx.updateDescription(this.cgL.yTx.getContext().getString(R.string.ak0, new Object[]{r0}));
            AppMethodBeat.o(31526);
        } else {
            this.yQo.setTitle(j.b(this.cgL.yTx.getContext(), charSequence, com.tencent.mm.bz.a.al(this.cgL.yTx.getContext(), R.dimen.dt)));
            this.cgL.yTx.updateDescription(this.cgL.yTx.getContext().getString(R.string.ak0, new Object[]{r0}));
            AppMethodBeat.o(31526);
        }
    }

    public final void setMMSubTitle(String str) {
        AppMethodBeat.i(31527);
        SpannableString b = j.b(this.cgL.yTx.getContext(), (CharSequence) str, com.tencent.mm.bz.a.al(this.cgL.yTx.getContext(), R.dimen.kr));
        com.tencent.mm.ui.a aVar = this.yQo;
        if (b == null || bo.isNullOrNil(b.toString())) {
            aVar.yeg.setVisibility(8);
            AppMethodBeat.o(31527);
            return;
        }
        aVar.yeg.setVisibility(0);
        aVar.yeg.setText(b);
        if (com.tencent.mm.bz.a.ga(aVar.yeg.getContext())) {
            aVar.yeg.setTextSize(1, 14.0f);
            aVar.gnB.setTextSize(1, 18.0f);
        }
        AppMethodBeat.o(31527);
    }

    public final void setBackBtn(final OnMenuItemClickListener onMenuItemClickListener) {
        AppMethodBeat.i(31528);
        this.yQo.b(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(31475);
                if (t.this.cgL.yTx.isScreenEnable()) {
                    view.setSelected(false);
                    view.setPressed(false);
                    view.clearFocus();
                    view.invalidate();
                    view.post(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(31474);
                            if (onMenuItemClickListener != null) {
                                onMenuItemClickListener.onMenuItemClick(null);
                            }
                            AppMethodBeat.o(31474);
                        }
                    });
                    AppMethodBeat.o(31475);
                    return;
                }
                ab.w("MicroMsg.ChattingUI.HeaderComponent", "Actionbar customView onclick screen not enable");
                AppMethodBeat.o(31475);
            }
        });
        AppMethodBeat.o(31528);
    }

    public final void setTitlePhoneIconVisibility(int i) {
        int i2;
        int i3 = 0;
        AppMethodBeat.i(31529);
        com.tencent.mm.ui.a aVar = this.yQo;
        if (i == 0) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        ImageView imageView = aVar.yei;
        if (i2 == 0) {
            i3 = 8;
        }
        imageView.setVisibility(i3);
        AppMethodBeat.o(31529);
    }

    public final void Nd(int i) {
        int i2;
        int i3 = 0;
        AppMethodBeat.i(31530);
        com.tencent.mm.ui.a aVar = this.yQo;
        if (i == 0) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        ImageView imageView = aVar.yeh;
        if (i2 == 0) {
            i3 = 8;
        }
        imageView.setVisibility(i3);
        AppMethodBeat.o(31530);
    }

    public final void setTitleMuteIconVisibility(int i) {
        boolean z = false;
        AppMethodBeat.i(31531);
        if (com.tencent.mm.model.t.nD(this.cgL.getTalkerUserName())) {
            this.yQo.pv(false);
            AppMethodBeat.o(31531);
            return;
        }
        com.tencent.mm.ui.a aVar = this.yQo;
        if (i == 0) {
            z = true;
        }
        aVar.pv(z);
        AppMethodBeat.o(31531);
    }

    public final void OA(int i) {
        int i2;
        int i3 = 0;
        AppMethodBeat.i(31532);
        com.tencent.mm.ui.a aVar = this.yQo;
        if (i == 0) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        ImageView imageView = aVar.yek;
        if (i2 == 0) {
            i3 = 8;
        }
        imageView.setVisibility(i3);
        AppMethodBeat.o(31532);
    }

    public final com.tencent.mm.ui.r dBO() {
        return this.yQn;
    }

    public final void dxy() {
        AppMethodBeat.i(31497);
        this.qvb = this.cgL.yTx.getIntExtra("add_scene", 0);
        com.tencent.mm.ah.o.acd().a(this.yQt);
        aw.ZK();
        com.tencent.mm.model.c.XV().c(this.yOu);
        setBackBtn(this.yQu);
        dBr();
        dEm();
        dEp();
        dEt();
        this.yOx = true;
        AppMethodBeat.o(31497);
    }

    public final void dxA() {
        AppMethodBeat.i(31499);
        aw.ZK().Yk().a(new com.tencent.mm.model.b.e.a() {
            public final void aaX() {
                AppMethodBeat.i(31480);
                com.tencent.mm.ui.chatting.d.a.dFz().post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(31479);
                        t.f(t.this);
                        AppMethodBeat.o(31479);
                    }
                });
                AppMethodBeat.o(31480);
            }

            public final void aaY() {
                AppMethodBeat.i(31481);
                t.g(t.this);
                AppMethodBeat.o(31481);
            }
        });
        aw.ZK().Yl().a(new com.tencent.mm.model.b.e.a() {
            public final void aaX() {
                AppMethodBeat.i(31483);
                com.tencent.mm.ui.chatting.d.a.dFz().post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(31482);
                        t.h(t.this);
                        AppMethodBeat.o(31482);
                    }
                });
                AppMethodBeat.o(31483);
            }

            public final void aaY() {
                AppMethodBeat.i(31484);
                t.i(t.this);
                AppMethodBeat.o(31484);
            }
        });
        b Ym = aw.ZK().Ym();
        com.tencent.mm.model.b.b.a aVar = this.yQr;
        synchronized (b.class) {
            try {
                Ym.mListeners.add(aVar);
            } catch (Throwable th) {
                while (true) {
                    AppMethodBeat.o(31499);
                }
            }
        }
        if (!this.yOx) {
            dBr();
        }
        this.yOx = false;
        AppMethodBeat.o(31499);
    }

    public final void dxB() {
        AppMethodBeat.i(31500);
        if (g.RN().QY()) {
            aw.ZK().Yk().a(null);
            aw.ZK().Yl().a(null);
            b Ym = aw.ZK().Ym();
            com.tencent.mm.model.b.b.a aVar = this.yQr;
            synchronized (b.class) {
                try {
                    Ym.mListeners.remove(aVar);
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.o(31500);
                }
            }
            return;
        }
        AppMethodBeat.o(31500);
    }
}
