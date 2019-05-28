package com.tencent.mm.ui;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.text.Spannable.Factory;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.facebook.internal.Utility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.m;
import com.tencent.mm.at.o;
import com.tencent.mm.bp.d;
import com.tencent.mm.g.a.ik;
import com.tencent.mm.g.a.on;
import com.tencent.mm.g.a.sp;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.r;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.platformtools.ah;
import com.tencent.mm.plugin.setting.ui.setting.SelfQRCodeUI;
import com.tencent.mm.plugin.story.api.AbsStoryGallery;
import com.tencent.mm.plugin.story.api.AbsStoryMuteView;
import com.tencent.mm.plugin.story.api.e;
import com.tencent.mm.plugin.story.api.g;
import com.tencent.mm.plugin.story.api.n;
import com.tencent.mm.plugin.story.g.h;
import com.tencent.mm.pluginsdk.ui.e.j;
import com.tencent.mm.pluginsdk.ui.preference.AccountInfoPreference;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.bp;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bm;
import com.tencent.mm.ui.base.preference.IconPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.contact.AddressUI;
import com.tencent.mm.ui.widget.listview.PullDownListView;
import com.tencent.mm.x.c;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import java.util.UUID;

public class MoreTabUI extends AbstractTabChildPreference implements g, com.tencent.mm.sdk.e.n.b {
    private View contentView;
    private f ehK;
    private boolean lZa = false;
    private RelativeLayout oZf = null;
    private AbsStoryGallery plq = null;
    private AbsStoryMuteView plr = null;
    private View plw;
    private boolean pnR = false;
    private byte[] qkE = null;
    private com.tencent.mm.x.a.a qpv = new com.tencent.mm.x.a.a() {
        public final void p(int i, String str) {
            AppMethodBeat.i(29688);
            if (i == 262145 || i == 266260 || i == 262157 || i == 266267 || i == 262158) {
                MoreTabUI.a(MoreTabUI.this);
                MoreTabUI.b(MoreTabUI.this);
            } else if (i == 262147) {
                MoreTabUI.c(MoreTabUI.this);
            } else if (i == 262156) {
                MoreTabUI.d(MoreTabUI.this);
            } else if (i == 262152) {
                MoreTabUI.e(MoreTabUI.this);
            } else if (i == 352279) {
                MoreTabUI.a(MoreTabUI.this, str);
            }
            MoreTabUI.this.ehK.notifyDataSetChanged();
            AppMethodBeat.o(29688);
        }

        public final void b(com.tencent.mm.storage.ac.a aVar) {
            AppMethodBeat.i(29689);
            if (aVar == com.tencent.mm.storage.ac.a.NEW_BANDAGE_DATASOURCE_NEW_CARD_REDDOT_WORDING_STRING_SYNC) {
                MoreTabUI.e(MoreTabUI.this);
            } else if (aVar == com.tencent.mm.storage.ac.a.NEW_BANDAGE_DATASOURCE_NEW_CARD_ICON_STRING_SYNC) {
                MoreTabUI.e(MoreTabUI.this);
            } else if (aVar == com.tencent.mm.storage.ac.a.NEW_BANDAGE_DATASOURCE_WALLET_MORE_TAB_STRING_SYNC || aVar == com.tencent.mm.storage.ac.a.USERINFO_WALLET_New_MY_ENTRY_TAB_REDDOT_STRING_SYNC) {
                MoreTabUI.d(MoreTabUI.this);
            } else if (aVar == com.tencent.mm.storage.ac.a.NEW_BANDAGE_DATASOURCE_DEVICE_PROTECT_STRING_SYNC) {
                MoreTabUI.a(MoreTabUI.this);
            }
            MoreTabUI.this.ehK.notifyDataSetChanged();
            AppMethodBeat.o(29689);
        }
    };
    private Bitmap svw = null;
    private int yoA = com.tencent.mm.bz.a.fromDPToPix(getContext(), 120);
    public com.tencent.mm.ui.widget.listview.PullDownListView.a yoB = new com.tencent.mm.ui.widget.listview.PullDownListView.a() {
        public final void jM(boolean z) {
            AppMethodBeat.i(29704);
            String str = "MicroMsg.MoreTabUI";
            String str2 = "story_cat onPostOpen, storyGallery is null?:%s";
            Object[] objArr = new Object[1];
            objArr[0] = Boolean.valueOf(MoreTabUI.this.plq == null);
            ab.i(str, str2, objArr);
            if (MoreTabUI.this.plq != null) {
                h hVar = h.scu;
                h.cAs().cYQ = 1;
                hVar = h.scu;
                h.cAs().cZT = 1;
                MoreTabUI.this.plq.K(z, true);
                MoreTabUI.a(MoreTabUI.this, 8);
                MoreTabUI.j(MoreTabUI.this);
                MoreTabUI.k(MoreTabUI.this);
            }
            MoreTabUI.this.yok = true;
            MoreTabUI.l(MoreTabUI.this);
            if (!(MoreTabUI.this.pnR || MoreTabUI.this.yot)) {
                com.tencent.mm.kernel.g.RP().Ry().set(com.tencent.mm.storage.ac.a.USERINFO_STORY_PULL_DOWN_COUNT_INT, Integer.valueOf(com.tencent.mm.kernel.g.RP().Ry().getInt(com.tencent.mm.storage.ac.a.USERINFO_STORY_PULL_DOWN_COUNT_INT, 0) + 1));
                MoreTabUI.o(MoreTabUI.this);
            }
            AppMethodBeat.o(29704);
        }

        public final void caI() {
            AppMethodBeat.i(29705);
            String str = "MicroMsg.MoreTabUI";
            String str2 = "story_cat onPostClose, storyGallery is null?:%s";
            Object[] objArr = new Object[1];
            objArr[0] = Boolean.valueOf(MoreTabUI.this.plq == null);
            ab.i(str, str2, objArr);
            if (MoreTabUI.this.plq != null) {
                MoreTabUI.this.plq.lr(true);
                MoreTabUI.this.plq.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(29703);
                        MoreTabUI.p(MoreTabUI.this);
                        MoreTabUI.a(MoreTabUI.this, 0);
                        MoreTabUI.b(MoreTabUI.this, MoreTabUI.this.pnR);
                        if (MoreTabUI.this.yoi != null) {
                            MoreTabUI.this.yoi.setTranslationY(0.0f);
                        }
                        AppMethodBeat.o(29703);
                    }
                });
            }
            MoreTabUI.this.yok = false;
            MoreTabUI.r(MoreTabUI.this);
            MoreTabUI.this.yoj.caH();
            if (MoreTabUI.this.you && !MoreTabUI.this.pnR) {
                long currentTimeMillis = System.currentTimeMillis();
                h hVar = h.scu;
                h.lq(currentTimeMillis);
                hVar = h.scu;
                h.cAJ().cZm = currentTimeMillis;
            }
            AppMethodBeat.o(29705);
        }

        public final void caJ() {
            AppMethodBeat.i(29706);
            if (MoreTabUI.this.plq != null) {
                MoreTabUI.this.plq.cwK();
            }
            if (MoreTabUI.this.you && !MoreTabUI.this.pnR) {
                h hVar = h.scu;
                h.cAJ().cZY = System.currentTimeMillis();
                hVar = h.scu;
                h.cAK();
            }
            AppMethodBeat.o(29706);
        }

        public final void caK() {
            AppMethodBeat.i(29707);
            if (MoreTabUI.this.plq != null) {
                MoreTabUI.this.plq.cwL();
            }
            AppMethodBeat.o(29707);
        }

        public final void caL() {
            AppMethodBeat.i(29708);
            ab.i("MicroMsg.MoreTabUI", "story_cat onMuteIn");
            MoreTabUI.this.plr.cwM();
            AppMethodBeat.o(29708);
        }

        public final void caM() {
            AppMethodBeat.i(29709);
            MoreTabUI.this.plr.cwN();
            AppMethodBeat.o(29709);
        }

        public final void AU(int i) {
            AppMethodBeat.i(29710);
            if (MoreTabUI.this.plq != null) {
                MoreTabUI.this.plq.EF(i);
            }
            AppMethodBeat.o(29710);
        }

        public final void AV(int i) {
            AppMethodBeat.i(29711);
            if (MoreTabUI.this.plq != null) {
                MoreTabUI.this.plq.EG(i);
            }
            AppMethodBeat.o(29711);
        }

        public final void AW(int i) {
            AppMethodBeat.i(29712);
            if (MoreTabUI.this.plq != null) {
                MoreTabUI.this.plq.AW(i);
            }
            AppMethodBeat.o(29712);
        }
    };
    private a yoC = new a();
    private ImageView yog;
    PullDownListView yoh;
    private View yoi = null;
    private b yoj = new b(this, (byte) 0);
    private boolean yok = false;
    private AccountInfoPreference yol = null;
    private boolean yom = false;
    private RelativeLayout yon = null;
    private FrameLayout yoo = null;
    private int yop = 0;
    private int yoq = 0;
    private int yor = 0;
    private int yos = 0;
    private boolean yot = false;
    private boolean you = false;
    private boolean yov = false;
    public boolean yow = true;
    private boolean yox = true;
    public boolean yoy = true;
    private int yoz = com.tencent.mm.bz.a.fromDPToPix(getContext(), 48);

    class a implements com.tencent.mm.ai.f {
        a() {
        }

        public final void onSceneEnd(int i, int i2, String str, m mVar) {
        }
    }

    class b {
        private int status;

        private b() {
            this.status = 2;
        }

        /* synthetic */ b(MoreTabUI moreTabUI, byte b) {
            this();
        }

        public final void caH() {
            AppMethodBeat.i(29714);
            if (MoreTabUI.this.getActivity() == null) {
                AppMethodBeat.o(29714);
                return;
            }
            switch (this.status) {
                case 0:
                    MoreTabUI.this.yoh.setBackgroundResource(R.drawable.u4);
                    MoreTabUI.this.yoh.setSupportOverscroll(MoreTabUI.this.pnR);
                    MoreTabUI.this.yot = false;
                    MoreTabUI.this.yor = com.tencent.mm.bz.a.am(MoreTabUI.this.getContext(), R.dimen.a7h);
                    if (MoreTabUI.this.plq != null) {
                        ((LayoutParams) MoreTabUI.this.plq.getLayoutParams()).topMargin = MoreTabUI.this.yos;
                        MoreTabUI.this.yoh.x(MoreTabUI.this.plq, MoreTabUI.this.yor, MoreTabUI.this.yos);
                    }
                    MoreTabUI.this.yoh.setMuteView(MoreTabUI.this.plr);
                    MoreTabUI.c(MoreTabUI.this, MoreTabUI.this.pnR);
                    MoreTabUI.a(MoreTabUI.this, 0);
                    MoreTabUI.b(MoreTabUI.this, MoreTabUI.this.pnR);
                    if (MoreTabUI.this.yol != null) {
                        MoreTabUI.this.yol.ad(MoreTabUI.this.pnR, MoreTabUI.this.yot);
                        AppMethodBeat.o(29714);
                        return;
                    }
                    break;
                case 1:
                    MoreTabUI.this.yoh.setSupportOverscroll(true);
                    MoreTabUI.o(MoreTabUI.this);
                    if (MoreTabUI.this.yot) {
                        MoreTabUI.this.yoh.setBackgroundResource(R.drawable.u6);
                    } else {
                        MoreTabUI.this.yoh.setBackgroundResource(R.drawable.u4);
                    }
                    if (MoreTabUI.this.plq != null) {
                        ((LayoutParams) MoreTabUI.this.plq.getLayoutParams()).topMargin = MoreTabUI.this.yoq;
                        MoreTabUI.this.yoh.x(MoreTabUI.this.plq, MoreTabUI.this.yor, MoreTabUI.this.yoq);
                    }
                    MoreTabUI.this.yoh.setMuteView(null);
                    MoreTabUI.c(MoreTabUI.this, MoreTabUI.this.pnR);
                    MoreTabUI.a(MoreTabUI.this, 0);
                    MoreTabUI.b(MoreTabUI.this, MoreTabUI.this.pnR);
                    if (MoreTabUI.this.yol != null) {
                        MoreTabUI.this.yol.ad(MoreTabUI.this.pnR, MoreTabUI.this.yot);
                        AppMethodBeat.o(29714);
                        return;
                    }
                    break;
                case 2:
                    MoreTabUI.this.yoh.setBackgroundResource(R.drawable.u6);
                    MoreTabUI.this.yoh.setSupportOverscroll(MoreTabUI.this.pnR);
                    MoreTabUI.c(MoreTabUI.this, MoreTabUI.this.pnR);
                    MoreTabUI.j(MoreTabUI.this);
                    if (MoreTabUI.this.yol != null) {
                        MoreTabUI.this.yol.ad(MoreTabUI.this.pnR, MoreTabUI.this.yot);
                        break;
                    }
                    break;
            }
            AppMethodBeat.o(29714);
        }

        public final void dyU() {
            AppMethodBeat.i(29715);
            if (!n.isShowStoryCheck() || MoreTabUI.this.lZa) {
                MoreTabUI.this.pnR = false;
                this.status = 2;
            } else if (((e) com.tencent.mm.kernel.g.M(e.class)).isStoryExist(r.Yz())) {
                MoreTabUI.this.pnR = true;
                this.status = 0;
            } else {
                MoreTabUI.this.pnR = false;
                this.status = 1;
            }
            ab.i("MicroMsg.MoreTabUI", "checkStoryStatus status=%s", Integer.valueOf(this.status));
            caH();
            AppMethodBeat.o(29715);
        }

        public final void Nr(int i) {
            AppMethodBeat.i(29716);
            ab.i("MicroMsg.MoreTabUI", "forceToStatus %s", Integer.valueOf(i));
            if (i == 0) {
                MoreTabUI.this.pnR = true;
            } else {
                MoreTabUI.this.pnR = false;
            }
            this.status = i;
            caH();
            AppMethodBeat.o(29716);
        }
    }

    public MoreTabUI() {
        AppMethodBeat.i(29717);
        AppMethodBeat.o(29717);
    }

    static /* synthetic */ void a(MoreTabUI moreTabUI) {
        AppMethodBeat.i(29754);
        moreTabUI.dyN();
        AppMethodBeat.o(29754);
    }

    static /* synthetic */ void b(MoreTabUI moreTabUI) {
        AppMethodBeat.i(29755);
        moreTabUI.dyL();
        AppMethodBeat.o(29755);
    }

    static /* synthetic */ void c(MoreTabUI moreTabUI) {
        AppMethodBeat.i(29756);
        moreTabUI.dyO();
        AppMethodBeat.o(29756);
    }

    static /* synthetic */ void d(MoreTabUI moreTabUI) {
        AppMethodBeat.i(29757);
        moreTabUI.dyQ();
        AppMethodBeat.o(29757);
    }

    static /* synthetic */ void e(MoreTabUI moreTabUI) {
        AppMethodBeat.i(29758);
        moreTabUI.dyM();
        AppMethodBeat.o(29758);
    }

    static /* synthetic */ void l(MoreTabUI moreTabUI) {
        AppMethodBeat.i(29763);
        moreTabUI.dyS();
        AppMethodBeat.o(29763);
    }

    static /* synthetic */ void o(MoreTabUI moreTabUI) {
        AppMethodBeat.i(29764);
        moreTabUI.dyK();
        AppMethodBeat.o(29764);
    }

    static /* synthetic */ void p(MoreTabUI moreTabUI) {
        AppMethodBeat.i(29765);
        moreTabUI.caE();
        AppMethodBeat.o(29765);
    }

    static /* synthetic */ void r(MoreTabUI moreTabUI) {
        AppMethodBeat.i(29767);
        moreTabUI.dyT();
        AppMethodBeat.o(29767);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(29718);
        super.onCreate(bundle);
        if (!aw.RK() || aw.QT()) {
            ab.e("MicroMsg.MoreTabUI", "Create MoreTabUI when accready:%b ishold:%b", Boolean.valueOf(aw.RK()), Boolean.valueOf(aw.QT()));
            AppMethodBeat.o(29718);
            return;
        }
        dyK();
        pT(false);
        AppMethodBeat.o(29718);
    }

    public void onResume() {
        AppMethodBeat.i(29719);
        super.onResume();
        ab.i("MicroMsg.MoreTabUI", "onResume: ");
        dyK();
        if (this.you) {
            long currentTimeMillis = System.currentTimeMillis();
            h hVar = h.scu;
            h.lq(currentTimeMillis);
            hVar = h.scu;
            h.cAJ().cZm = currentTimeMillis;
        }
        AppMethodBeat.o(29719);
    }

    public void onPause() {
        AppMethodBeat.i(29720);
        super.onPause();
        ab.i("MicroMsg.MoreTabUI", "onPause: ");
        if (this.you) {
            h hVar = h.scu;
            h.cAK();
        }
        AppMethodBeat.o(29720);
    }

    private void dyK() {
        AppMethodBeat.i(29721);
        if (!this.yot) {
            int i = com.tencent.mm.kernel.g.RP().Ry().getInt(com.tencent.mm.storage.ac.a.USERINFO_STORY_PULL_DOWN_COUNT_INT, 0);
            boolean z = com.tencent.mm.kernel.g.RP().Ry().getBoolean(com.tencent.mm.storage.ac.a.USERINFO_STORY_CAPTURE_FIRST_BOOLEAN_SYNC, false);
            ab.i("MicroMsg.MoreTabUI", "checkSmallHead: %s", Integer.valueOf(i));
            if (!this.pnR && (z || i > 0)) {
                this.yot = true;
                if (this.yol != null) {
                    this.yol.ad(this.pnR, this.yot);
                }
                if (this.yot) {
                    i = com.tencent.mm.bz.a.am(getContext(), R.dimen.a7i);
                } else {
                    i = com.tencent.mm.bz.a.am(getContext(), R.dimen.a7h);
                }
                this.yor = i;
            }
        }
        AppMethodBeat.o(29721);
    }

    public final int JC() {
        return R.xml.b3;
    }

    public boolean supportNavigationSwipeBack() {
        return false;
    }

    public boolean noActionBar() {
        return true;
    }

    public void onDestroy() {
        AppMethodBeat.i(29722);
        super.onDestroy();
        AppMethodBeat.o(29722);
    }

    public void onActivityCreated(Bundle bundle) {
        AppMethodBeat.i(29723);
        ab.i("MicroMsg.MoreTabUI", "onActivityCreated");
        super.onActivityCreated(bundle);
        this.ehK = this.yCw;
        this.ehK.ce("more_setting", true);
        this.ehK.ce("settings_emoji_store", true);
        this.ehK.ce("settings_mm_wallet", true);
        this.ehK.ce("settings_mm_cardpackage", true);
        this.ehK.ce("settings_mm_favorite", true);
        this.ehK.ce("settings_my_album", true);
        this.ehK.ce("settings_my_address", true);
        this.ehK.ce("more_tab_setting_personal_info", true);
        this.ehK.ce("more_uishow", true);
        this.ehK.ce("settings_privacy_agreements", true);
        this.yoi = getView().getRootView().findViewById(R.id.bq);
        this.oZf = (RelativeLayout) findViewById(R.id.da2);
        this.yog = (ImageView) findViewById(R.id.da5);
        this.yon = (RelativeLayout) findViewById(R.id.da3);
        this.yoo = (FrameLayout) findViewById(R.id.da4);
        this.yoh = (PullDownListView) this.nDp;
        this.yoh.setTabView(this.yoi);
        this.yoh.setBackgroundResource(R.drawable.u4);
        this.yoh.setOnScrollListener(new OnScrollListener() {
            public final void onScrollStateChanged(AbsListView absListView, int i) {
            }

            public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }
        });
        AppMethodBeat.o(29723);
    }

    public final boolean a(f fVar, Preference preference, View view) {
        AppMethodBeat.i(29724);
        if (com.tencent.mm.kernel.g.RK()) {
            boolean pS;
            try {
                if (bp.dnM() || bp.dpJ() || bp.dpL() || com.tencent.mm.sdk.platformtools.f.IS_FLAVOR_RED) {
                    if (bo.nullAsNil(preference.mKey).equals("settings_emoji_store")) {
                        pS = pS(true);
                        AppMethodBeat.o(29724);
                        return pS;
                    } else if (bo.nullAsNil(preference.mKey).equals("more_setting")) {
                        pS = pS(false);
                        AppMethodBeat.o(29724);
                        return pS;
                    }
                }
            } catch (ActivityNotFoundException e) {
            }
            pS = super.a(fVar, preference, view);
            AppMethodBeat.o(29724);
            return pS;
        }
        ab.w("MicroMsg.MoreTabUI", "account has not already!");
        AppMethodBeat.o(29724);
        return true;
    }

    public final boolean a(f fVar, Preference preference) {
        String str;
        AppMethodBeat.i(29725);
        String str2 = "MicroMsg.MoreTabUI";
        StringBuilder stringBuilder = new StringBuilder();
        if (preference == null) {
            str = BuildConfig.COMMAND;
        } else {
            str = preference.mKey;
        }
        ab.i(str2, stringBuilder.append(str).append(" item has been clicked!").toString());
        Intent intent;
        boolean bY;
        int i;
        if (!com.tencent.mm.kernel.g.RK()) {
            ab.w("MicroMsg.MoreTabUI", "account has not already!");
            AppMethodBeat.o(29725);
            return true;
        } else if (preference.mKey.equals("settings_my_address")) {
            intent = new Intent(getContext(), AddressUI.class);
            intent.putExtra("Contact_GroupFilter_Type", "@biz.contact");
            startActivity(intent);
            AppMethodBeat.o(29725);
            return true;
        } else if (preference.mKey.equals("settings_my_add_contact")) {
            d.b(getContext(), "subapp", ".ui.pluginapp.AddMoreFriendsUI", new Intent());
            AppMethodBeat.o(29725);
            return true;
        } else if (preference.mKey.equals("settings_mm_wallet")) {
            boolean bX = c.PK().bX(262156, 266248);
            bY = c.PK().bY(262156, 266248);
            com.tencent.mm.plugin.report.service.h.pYm.X(10958, "9");
            com.tencent.mm.plugin.report.service.h hVar = com.tencent.mm.plugin.report.service.h.pYm;
            Object[] objArr = new Object[1];
            i = (bX || bY) ? 1 : 0;
            objArr[0] = Integer.valueOf(i);
            hVar.e(13341, objArr);
            com.tencent.mm.plugin.report.service.h.pYm.e(14419, UUID.randomUUID().toString(), Integer.valueOf(0));
            on onVar = new on();
            onVar.cKQ.context = getContext();
            Intent intent2 = new Intent();
            intent2.putExtra("key_wallet_has_red", bY);
            intent2.putExtra("key_uuid", str);
            onVar.cKQ.intent = intent2;
            com.tencent.mm.sdk.b.a.xxA.m(onVar);
            c.PK().bZ(262156, 266248);
            c.PK().c(com.tencent.mm.storage.ac.a.NEW_BANDAGE_DATASOURCE_WALLET_MORE_TAB_STRING_SYNC, com.tencent.mm.storage.ac.a.NEW_BANDAGE_WATCHER_WALLET_COMMON_STRING_SYNC);
            aw.ZK();
            com.tencent.mm.model.c.Ry().set(com.tencent.mm.storage.ac.a.USERINFO_LQT_WALLET_RED_DOT_WORDING_STRING, (Object) "");
            aw.ZK();
            com.tencent.mm.model.c.Ry().set(com.tencent.mm.storage.ac.a.USERINFO_LQT_WALLET_RED_DOT_INT, Integer.valueOf(-1));
            com.tencent.mm.kernel.g.RQ();
            com.tencent.mm.kernel.g.RP().Ry().set(com.tencent.mm.storage.ac.a.USERINFO_WALLET_MY_ENTRY_REDDOT_BOOLEAN_SYNC, Boolean.FALSE);
            com.tencent.mm.kernel.g.RQ();
            com.tencent.mm.kernel.g.RP().Ry().set(com.tencent.mm.storage.ac.a.USERINFO_WALLET_ENTRY_WORDING_STRING_SYNC, (Object) "");
            com.tencent.mm.kernel.g.RQ();
            com.tencent.mm.kernel.g.RP().Ry().set(com.tencent.mm.storage.ac.a.USERINFO_WALLET_MY_ENTRY_TAB_REDDOT_BOOLEAN_SYNC, Boolean.FALSE);
            c.PK().c(com.tencent.mm.storage.ac.a.USERINFO_WALLET_New_MY_ENTRY_TAB_REDDOT_STRING_SYNC, com.tencent.mm.storage.ac.a.USERINFO_NEW_BANDAGE_WATCHER_PAY_ENTRANCE_STRING_SYNC);
            com.tencent.mm.kernel.g.RQ();
            com.tencent.mm.kernel.g.RP().Ry().set(com.tencent.mm.storage.ac.a.USERINFO_WALLET_New_MY_ENTRY_WORDING_STRING_SYNC, (Object) "");
            hVar = com.tencent.mm.plugin.report.service.h.pYm;
            objArr = new Object[5];
            objArr[0] = Integer.valueOf(6);
            objArr[1] = Integer.valueOf(bY ? 1 : 0);
            objArr[2] = "";
            objArr[3] = "";
            objArr[4] = Integer.valueOf(0);
            hVar.e(14872, objArr);
            AppMethodBeat.o(29725);
            return true;
        } else if (preference.mKey.equals("settings_mm_cardpackage")) {
            aw.ZK();
            com.tencent.mm.model.c.Ry().set(com.tencent.mm.storage.ac.a.USERINFO_CARD_REDOT_WORDING_STRING_SYNC, (Object) "");
            new Intent().putExtra("key_from_scene", 22);
            ab.i("MicroMsg.MoreTabUI", "enter to cardhome");
            ik ikVar = new ik();
            ikVar.cDz.context = getContext();
            ikVar.cDz.cDB = 1;
            com.tencent.mm.sdk.b.a.xxA.m(ikVar);
            AppMethodBeat.o(29725);
            return true;
        } else if (preference.mKey.equals("settings_my_album")) {
            aw.ZK();
            if (com.tencent.mm.model.c.isSDCardAvailable()) {
                aw.ZK();
                str = (String) com.tencent.mm.model.c.Ry().get(2, null);
                Intent intent3 = new Intent(getContext(), AlbumUI.class);
                intent3.putExtra("sns_userName", str);
                intent3.putExtra("username", str);
                intent3.putExtra("story_dot", this.yov);
                intent3.setFlags(536870912);
                intent3.addFlags(67108864);
                aw.ZK();
                i = ah.i((Integer) com.tencent.mm.model.c.Ry().get(68389, null));
                aw.ZK();
                com.tencent.mm.model.c.Ry().set(68389, Integer.valueOf(i + 1));
                startActivity(intent3);
                AppMethodBeat.o(29725);
                return true;
            }
            t.hO(getContext());
            AppMethodBeat.o(29725);
            return true;
        } else if (preference.mKey.equals("settings_mm_favorite")) {
            com.tencent.mm.plugin.report.service.h.pYm.X(10958, "8");
            com.tencent.mm.plugin.report.service.h.pYm.e(14103, Integer.valueOf(0));
            com.tencent.mm.plugin.fav.a.b.b(getContext(), ".ui.FavoriteIndexUI", new Intent());
            com.tencent.mm.cj.c.aNX();
            AppMethodBeat.o(29725);
            return true;
        } else if (preference.mKey.equals("settings_emoji_store")) {
            com.tencent.mm.plugin.report.service.h.pYm.X(10958, "7");
            c.PK().bZ(262147, 266244);
            c.PK().bZ(262149, 266244);
            intent = new Intent();
            intent.putExtra("preceding_scence", 2);
            d.b(getContext(), "emoji", ".ui.v2.EmojiStoreV2UI", intent);
            com.tencent.mm.plugin.report.service.h.pYm.e(12065, Integer.valueOf(1));
            ((com.tencent.mm.plugin.boots.a.c) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.boots.a.c.class)).dC(com.tencent.mm.plugin.boots.a.b.jJo, 881);
            AppMethodBeat.o(29725);
            return true;
        } else if (preference.mKey.equals("more_setting")) {
            bY = c.PK().bX(262145, 266242);
            c.PK().bZ(262145, 266242);
            c.PK().bZ(262157, 266261);
            c.PK().bZ(262158, 266264);
            c.PK().b(com.tencent.mm.storage.ac.a.NEW_BANDAGE_DATASOURCE_DEVICE_PROTECT_STRING_SYNC, 266242);
            d.b(getContext(), "setting", ".ui.setting.SettingsUI", new Intent());
            aw.ZK();
            int intValue = ((Integer) com.tencent.mm.model.c.Ry().get(com.tencent.mm.storage.ac.a.USERINFO_SETTING_RED_DOT_WILL_SHOW_ID_INT, Integer.valueOf(0))).intValue();
            aw.ZK();
            i = ((Integer) com.tencent.mm.model.c.Ry().get(com.tencent.mm.storage.ac.a.USERINFO_SETTING_RED_DOT_DID_SHOW_ID_INT, Integer.valueOf(0))).intValue();
            if (!bY && intValue > i) {
                aw.ZK();
                com.tencent.mm.model.c.Ry().set(com.tencent.mm.storage.ac.a.USERINFO_SETTING_RED_DOT_DID_SHOW_ID_INT, Integer.valueOf(intValue));
                IconPreference iconPreference = (IconPreference) fVar.aqO("more_setting");
                if (iconPreference != null) {
                    iconPreference.NN(8);
                }
                c.PK().bZ(266260, 266241);
            }
            AppMethodBeat.o(29725);
            return true;
        } else if (preference.mKey.equals("more_uishow")) {
            com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.x.a.a.a.class);
            getContext();
            intent = new Intent();
            AppMethodBeat.o(29725);
            return true;
        } else if (preference.mKey.equals("settings_privacy_agreements")) {
            com.tencent.mm.plugin.account.a.b.a.b(getActivity(), getString(R.string.g7o, aa.dor(), com.tencent.mm.kernel.g.RP().Ry().get(274436, null), "setting", Integer.valueOf(0), Integer.valueOf(0)), 0, true);
            AppMethodBeat.o(29725);
            return true;
        } else {
            AppMethodBeat.o(29725);
            return false;
        }
    }

    private void dyL() {
        AppMethodBeat.i(29726);
        if (d.afj("sns")) {
            this.ehK.ce("settings_my_album", false);
            IconPreference iconPreference = (IconPreference) this.ehK.aqO("settings_my_album");
            if (iconPreference != null) {
                if (com.tencent.mm.kernel.g.RP().Ry().getBoolean(com.tencent.mm.storage.ac.a.USERINFO_STORY_NEED_DISPLAY_ALBUM_GUIDE_BOOLEAN_SYNC, true) && this.yov) {
                    iconPreference.NN(0);
                    AppMethodBeat.o(29726);
                    return;
                }
                this.yov = false;
                iconPreference.NN(8);
            }
            AppMethodBeat.o(29726);
            return;
        }
        this.ehK.ce("settings_my_album", true);
        AppMethodBeat.o(29726);
    }

    private void dyM() {
        AppMethodBeat.i(29727);
        com.tencent.mm.plugin.card.c.b bVar = (com.tencent.mm.plugin.card.c.b) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.card.c.b.class);
        if (bVar == null || !((bVar.bbn() || bVar.bbo()) && d.afj("card"))) {
            this.ehK.ce("settings_mm_cardpackage", true);
            AppMethodBeat.o(29727);
            return;
        }
        String bbp;
        String str = "";
        if (bVar != null) {
            bbp = bVar.bbp();
        } else {
            bbp = str;
        }
        boolean bY = c.PK().bY(262152, 266256);
        boolean bX = c.PK().bX(262152, 266256);
        boolean a = c.PK().a(com.tencent.mm.storage.ac.a.NEW_BANDAGE_DATASOURCE_NEW_CARD_REDDOT_WORDING_STRING_SYNC, com.tencent.mm.storage.ac.a.NEW_BANDAGE_WATCHER_SETTING_CARD_ENTRY_REDDOT_WORDING_STRING_SYNC);
        boolean a2 = c.PK().a(com.tencent.mm.storage.ac.a.NEW_BANDAGE_DATASOURCE_NEW_CARD_ICON_STRING_SYNC, com.tencent.mm.storage.ac.a.NEW_BANDAGE_WATCHER_SETTING_CARD_ENTRY_ICON_STRING_SYNC);
        this.ehK.ce("settings_mm_cardpackage", false);
        final IconPreference iconPreference = (IconPreference) this.ehK.aqO("settings_mm_cardpackage");
        if (iconPreference == null) {
            AppMethodBeat.o(29727);
            return;
        }
        iconPreference.setTitle((int) R.string.e8b);
        if (bX) {
            iconPreference.NL(0);
            iconPreference.ey(getString(R.string.s0), R.drawable.w3);
            iconPreference.NN(8);
            iconPreference.setSummary(null);
            iconPreference.ap(null);
            iconPreference.NP(8);
            iconPreference.ez("", -1);
            iconPreference.NM(8);
            AppMethodBeat.o(29727);
            return;
        }
        aw.ZK();
        str = (String) com.tencent.mm.model.c.Ry().get(com.tencent.mm.storage.ac.a.USERINFO_CARD_REDOT_ICON_URL_STRING_SYNC, (Object) "");
        if (!a2 || TextUtils.isEmpty(str)) {
            iconPreference.ap(null);
            iconPreference.NP(8);
        } else {
            int dimensionPixelOffset = getResources().getDimensionPixelOffset(R.dimen.vj);
            com.tencent.mm.at.a.a.c.a aVar = new com.tencent.mm.at.a.a.c.a();
            aVar.ePK = com.tencent.mm.compatible.util.e.eSn;
            o.ahq();
            aVar.ePY = null;
            aVar.ePH = true;
            aVar.eQf = true;
            aVar.ePF = true;
            aVar.ePO = dimensionPixelOffset;
            aVar.ePN = dimensionPixelOffset;
            o.ahp().a(str, iconPreference.dAz(), aVar.ahG(), new com.tencent.mm.at.a.c.g() {
                public final void sH(String str) {
                    AppMethodBeat.i(29695);
                    al.d(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(29692);
                            iconPreference.NP(0);
                            iconPreference.NO(R.drawable.bcm);
                            AppMethodBeat.o(29692);
                        }
                    });
                    AppMethodBeat.o(29695);
                }

                public final Bitmap a(String str, View view, com.tencent.mm.at.a.d.b bVar) {
                    return null;
                }

                public final void b(String str, View view, com.tencent.mm.at.a.d.b bVar) {
                    AppMethodBeat.i(29696);
                    if (bVar.bitmap != null) {
                        final Bitmap bitmap = bVar.bitmap;
                        al.d(new Runnable() {
                            public final void run() {
                                AppMethodBeat.i(29693);
                                iconPreference.ap(bitmap);
                                iconPreference.NP(0);
                                AppMethodBeat.o(29693);
                            }
                        });
                        AppMethodBeat.o(29696);
                        return;
                    }
                    al.d(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(29694);
                            iconPreference.ap(null);
                            iconPreference.NP(8);
                            AppMethodBeat.o(29694);
                        }
                    });
                    AppMethodBeat.o(29696);
                }
            });
        }
        if (bY) {
            iconPreference.NN(0);
        } else {
            iconPreference.NN(8);
        }
        if (a) {
            iconPreference.ey("", -1);
            iconPreference.NL(8);
            if (a2) {
                iconPreference.setSummary(null);
                if (ah.isNullOrNil(bbp)) {
                    iconPreference.ez("", -1);
                    iconPreference.NM(8);
                } else {
                    iconPreference.av(bbp, -1, getResources().getColor(R.color.s0));
                    iconPreference.NM(0);
                }
            } else {
                iconPreference.ez("", -1);
                iconPreference.NM(8);
                if (ah.isNullOrNil(bbp)) {
                    iconPreference.setSummary(null);
                } else {
                    iconPreference.setSummary((CharSequence) bbp);
                }
            }
        } else {
            iconPreference.NM(8);
            iconPreference.NL(8);
            iconPreference.setSummary(null);
        }
        com.tencent.mm.plugin.report.service.h.pYm.e(16322, Integer.valueOf(1));
        AppMethodBeat.o(29727);
    }

    private void dyN() {
        AppMethodBeat.i(29728);
        this.ehK.ce("more_setting", false);
        final IconPreference iconPreference = (IconPreference) this.ehK.aqO("more_setting");
        if (iconPreference != null) {
            iconPreference.NQ(8);
            boolean bX = c.PK().bX(262145, 266242);
            if (bX) {
                iconPreference.NL(0);
                iconPreference.ey(getString(R.string.s0), R.drawable.w3);
            } else {
                iconPreference.NL(8);
                iconPreference.ey("", -1);
            }
            aw.ZK();
            if (((Integer) com.tencent.mm.model.c.Ry().get(9, Integer.valueOf(0))).intValue() != 0) {
                if (r.YH()) {
                    iconPreference.setSummary((CharSequence) "");
                } else {
                    iconPreference.setSummary((int) R.string.dw0);
                }
            }
            iconPreference.NN(8);
            if (bX) {
                AppMethodBeat.o(29728);
                return;
            }
            aw.ZK();
            int intValue = ((Integer) com.tencent.mm.model.c.Ry().get(com.tencent.mm.storage.ac.a.USERINFO_SETTING_RED_DOT_WILL_SHOW_ID_INT, Integer.valueOf(0))).intValue();
            aw.ZK();
            int intValue2 = ((Integer) com.tencent.mm.model.c.Ry().get(com.tencent.mm.storage.ac.a.USERINFO_SETTING_RED_DOT_DID_SHOW_ID_INT, Integer.valueOf(0))).intValue();
            if ((((com.tencent.mm.plugin.welab.a.a.c) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.welab.a.a.c.class)).ddn() || ((com.tencent.mm.plugin.welab.a.a.c) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.welab.a.a.c.class)).ddo() || intValue > intValue2) && !bX) {
                iconPreference.NN(0);
                iconPreference.NL(8);
                iconPreference.ey("", -1);
                AppMethodBeat.o(29728);
                return;
            }
            iconPreference.NN(8);
            if (c.PK().bY(262157, 266261)) {
                iconPreference.NN(0);
                iconPreference.NL(8);
                iconPreference.ey("", -1);
                AppMethodBeat.o(29728);
                return;
            }
            iconPreference.NN(8);
            if (c.PK().bY(262158, 266264)) {
                iconPreference.NN(0);
                iconPreference.NL(8);
                iconPreference.ey("", -1);
                AppMethodBeat.o(29728);
                return;
            } else if (c.PK().a(com.tencent.mm.storage.ac.a.NEW_BANDAGE_DATASOURCE_DEVICE_PROTECT_STRING_SYNC, 266242)) {
                iconPreference.NN(0);
                AppMethodBeat.o(29728);
                return;
            } else {
                boolean booleanValue;
                iconPreference.NN(8);
                aw.ZK();
                if ((com.tencent.mm.model.c.Ry().getInt(40, 0) & WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT) == 0) {
                    bX = true;
                } else {
                    bX = false;
                }
                if (bo.getInt(com.tencent.mm.m.g.Nu().getValue("VoiceprintEntry"), 0) == 1) {
                    aw.ZK();
                    booleanValue = ((Boolean) com.tencent.mm.model.c.Ry().get(com.tencent.mm.storage.ac.a.USERINFO_VOICEPRINT_MORE_TAB_DOT_SHOW_BOOLEAN, Boolean.TRUE)).booleanValue();
                } else {
                    booleanValue = false;
                }
                if (booleanValue && r2) {
                    ab.i("MicroMsg.MoreTabUI", "show voiceprint dot");
                    iconPreference.NN(0);
                    AppMethodBeat.o(29728);
                    return;
                }
                iconPreference.NN(8);
                bm Ms = com.tencent.mm.plugin.r.a.bVu().Ms(com.tencent.mm.ax.b.fKD);
                if (Ms == null || Ms.field_isExit) {
                    com.tencent.mm.plugin.r.a.bVv();
                    if (com.tencent.mm.ax.c.lQ(com.tencent.mm.ax.b.fKD)) {
                        iconPreference.NN(0);
                        iconPreference.NL(8);
                        iconPreference.ey("", -1);
                        AppMethodBeat.o(29728);
                        return;
                    }
                }
                com.tencent.mm.plugin.r.a.bVt().fKT = new com.tencent.mm.ax.d.a() {
                    public final void e(bm bmVar) {
                        AppMethodBeat.i(29697);
                        if (bmVar.field_tipId == com.tencent.mm.ax.b.fKD) {
                            com.tencent.mm.plugin.r.a.bVv();
                            if (com.tencent.mm.ax.c.lQ(com.tencent.mm.ax.b.fKD)) {
                                iconPreference.NN(0);
                                iconPreference.NL(8);
                                iconPreference.ey("", -1);
                                AppMethodBeat.o(29697);
                                return;
                            }
                        }
                        AppMethodBeat.o(29697);
                    }
                };
                AppMethodBeat.o(29728);
                return;
            }
        }
        AppMethodBeat.o(29728);
    }

    private void dyO() {
        AppMethodBeat.i(29729);
        if (d.afj("emoji")) {
            d.dlL();
            this.ehK.ce("settings_emoji_store", false);
            boolean bX = c.PK().bX(262147, 266244);
            boolean bX2 = c.PK().bX(262149, 266244);
            final IconPreference iconPreference = (IconPreference) this.ehK.aqO("settings_emoji_store");
            if (iconPreference == null) {
                AppMethodBeat.o(29729);
                return;
            }
            if (bX) {
                iconPreference.NL(0);
                iconPreference.ey(getString(R.string.s0), R.drawable.w3);
            } else if (bX2) {
                iconPreference.NL(0);
                iconPreference.ey(getString(R.string.qv), R.drawable.w3);
            } else {
                iconPreference.NL(8);
                iconPreference.ey("", -1);
            }
            if (bX2 || bX) {
                aw.ZK();
                o.ahp().a((String) com.tencent.mm.model.c.Ry().get(229633, null), iconPreference.dAz(), new com.tencent.mm.at.a.c.g() {
                    public final void sH(String str) {
                    }

                    public final Bitmap a(String str, View view, com.tencent.mm.at.a.d.b bVar) {
                        return null;
                    }

                    public final void b(String str, View view, com.tencent.mm.at.a.d.b bVar) {
                        AppMethodBeat.i(29702);
                        if (bVar.status != 0 || bVar.bitmap == null) {
                            al.d(new Runnable() {
                                public final void run() {
                                    AppMethodBeat.i(29701);
                                    iconPreference.NP(8);
                                    AppMethodBeat.o(29701);
                                }
                            });
                            AppMethodBeat.o(29702);
                            return;
                        }
                        final Bitmap bitmap = bVar.bitmap;
                        al.d(new Runnable() {
                            public final void run() {
                                AppMethodBeat.i(29700);
                                iconPreference.ap(bitmap);
                                iconPreference.NP(0);
                                AppMethodBeat.o(29700);
                            }
                        });
                        AppMethodBeat.o(29702);
                    }
                });
                AppMethodBeat.o(29729);
                return;
            }
            iconPreference.NP(8);
            AppMethodBeat.o(29729);
            return;
        }
        this.ehK.ce("settings_emoji_store", false);
        AppMethodBeat.o(29729);
    }

    private void dyP() {
        AppMethodBeat.i(29730);
        boolean YI = r.YI();
        ab.d("MicroMsg.MoreTabUI", "wallet status: is open".concat(String.valueOf(YI)));
        f fVar = this.ehK;
        String str = "settings_mm_wallet";
        if (YI) {
            YI = false;
        } else {
            YI = true;
        }
        fVar.ce(str, YI);
        this.yCw.notifyDataSetChanged();
        AppMethodBeat.o(29730);
    }

    private void dyQ() {
        AppMethodBeat.i(29731);
        aw.ZK();
        int i = ah.i((Integer) com.tencent.mm.model.c.Ry().get(204820, null));
        aw.ZK();
        int i2 = i + ah.i((Integer) com.tencent.mm.model.c.Ry().get(204817, null));
        boolean bX = c.PK().bX(262156, 266248);
        int bY = c.PK().bY(262156, 266248);
        boolean b = c.PK().b(com.tencent.mm.storage.ac.a.NEW_BANDAGE_DATASOURCE_WALLET_MORE_TAB_STRING_SYNC, com.tencent.mm.storage.ac.a.NEW_BANDAGE_WATCHER_WALLET_COMMON_STRING_SYNC);
        aw.ZK();
        String str = (String) com.tencent.mm.model.c.Ry().get(com.tencent.mm.storage.ac.a.USERINFO_WALLET_MORE_TAB_REDDOT_WORDING_STRING_SYNC, (Object) "");
        IconPreference iconPreference = (IconPreference) this.ehK.aqO("settings_mm_wallet");
        if (iconPreference == null) {
            AppMethodBeat.o(29731);
            return;
        }
        long longValue;
        long lb;
        int i3;
        ab.d("MicroMsg.MoreTabUI", "isShowNew : ".concat(String.valueOf(bX)));
        ab.d("MicroMsg.MoreTabUI", "isShowDot : ".concat(String.valueOf(bY)));
        aw.ZK();
        String str2 = (String) com.tencent.mm.model.c.Ry().get(com.tencent.mm.storage.ac.a.USERINFO_LQT_WALLET_RED_DOT_WORDING_STRING, (Object) "");
        aw.ZK();
        int intValue = ((Integer) com.tencent.mm.model.c.Ry().get(com.tencent.mm.storage.ac.a.USERINFO_LQT_WALLET_RED_DOT_INT, Integer.valueOf(-1))).intValue();
        if (bX || bY != 0) {
            aw.ZK();
            longValue = ((Long) com.tencent.mm.model.c.Ry().get(com.tencent.mm.storage.ac.a.USERINFO_WALLET_ENTRY_REDDOT_PUSH_DATE_LONG_SYNC, Long.valueOf(-1))).longValue();
            lb = ah.lb(com.tencent.mm.m.g.Nu().getValue("PayWalletRedDotExpire"));
            long j = 86400000 * lb;
            ab.i("MicroMsg.MoreTabUI", "pushTick: %s, expireTime: %s, expireTick: %s, currentTick: %s, passDay: %s", Long.valueOf(longValue), Long.valueOf(lb), Long.valueOf(j), Long.valueOf(System.currentTimeMillis()), Double.valueOf((((double) System.currentTimeMillis()) - ((double) longValue)) / 8.64E7d));
            if (longValue > 0 && lb > 0 && r20 >= ((double) lb)) {
                bX = false;
                c.PK().x(262156, false);
                bY = 0;
            }
        }
        com.tencent.mm.kernel.g.RQ();
        boolean booleanValue = ((Boolean) com.tencent.mm.kernel.g.RP().Ry().get(com.tencent.mm.storage.ac.a.USERINFO_WALLET_MY_ENTRY_REDDOT_BOOLEAN_SYNC, Boolean.FALSE)).booleanValue();
        com.tencent.mm.kernel.g.RQ();
        longValue = ((Long) com.tencent.mm.kernel.g.RP().Ry().get(com.tencent.mm.storage.ac.a.USERINFO_WALLET_MY_ENTRY_REDDOT_EXPIRETIME_LONG_SYNC, Long.valueOf(0))).longValue();
        if (!booleanValue || longValue <= 0 || System.currentTimeMillis() <= longValue) {
            boolean i32 = booleanValue;
        } else {
            ab.i("MicroMsg.MoreTabUI", "walletMyEntryRedDot expire, ignore redDot");
            i32 = 0;
            com.tencent.mm.kernel.g.RQ();
            com.tencent.mm.kernel.g.RP().Ry().set(com.tencent.mm.storage.ac.a.USERINFO_WALLET_MY_ENTRY_REDDOT_BOOLEAN_SYNC, Boolean.FALSE);
            com.tencent.mm.kernel.g.RQ();
            com.tencent.mm.kernel.g.RP().Ry().set(com.tencent.mm.storage.ac.a.USERINFO_WALLET_MY_ENTRY_REDDOT_EXPIRETIME_LONG_SYNC, Long.valueOf(0));
        }
        int i4 = bY | i32;
        com.tencent.mm.kernel.g.RQ();
        ab.i("MicroMsg.MoreTabUI", "after check, isShowNew: %s, isShowDot: %s, walletEntryWording: %s", Boolean.valueOf(bX), Boolean.valueOf(i4), (String) com.tencent.mm.kernel.g.RP().Ry().get(com.tencent.mm.storage.ac.a.USERINFO_WALLET_ENTRY_WORDING_STRING_SYNC, (Object) ""));
        booleanValue = c.PK().b(com.tencent.mm.storage.ac.a.USERINFO_WALLET_New_MY_ENTRY_TAB_REDDOT_STRING_SYNC, com.tencent.mm.storage.ac.a.USERINFO_NEW_BANDAGE_WATCHER_PAY_ENTRANCE_STRING_SYNC);
        com.tencent.mm.kernel.g.RQ();
        lb = ((Long) com.tencent.mm.kernel.g.RP().Ry().get(com.tencent.mm.storage.ac.a.USERINFO_WALLET_New_MY_ENTRY_REDDOT_EXPIRETIME_LONG_SYNC, Long.valueOf(0))).longValue();
        if (!booleanValue || lb <= 0 || System.currentTimeMillis() <= lb) {
            boolean z = booleanValue;
        } else {
            ab.i("MicroMsg.MoreTabUI", "walletMyEntryRedDot expire, ignore redDot");
            bY = 0;
            c.PK().c(com.tencent.mm.storage.ac.a.USERINFO_WALLET_New_MY_ENTRY_TAB_REDDOT_STRING_SYNC, com.tencent.mm.storage.ac.a.USERINFO_NEW_BANDAGE_WATCHER_PAY_ENTRANCE_STRING_SYNC);
            com.tencent.mm.kernel.g.RQ();
            com.tencent.mm.kernel.g.RP().Ry().set(com.tencent.mm.storage.ac.a.USERINFO_WALLET_New_MY_ENTRY_REDDOT_EXPIRETIME_LONG_SYNC, Long.valueOf(0));
        }
        int i5 = i4 | bY;
        com.tencent.mm.kernel.g.RQ();
        String str3 = (String) com.tencent.mm.kernel.g.RP().Ry().get(com.tencent.mm.storage.ac.a.USERINFO_WALLET_New_MY_ENTRY_WORDING_STRING_SYNC, (Object) "");
        ab.i("MicroMsg.MoreTabUI", "after check, isShowNew: %s, isShowDot: %s, walletEntryWording: %s", Boolean.valueOf(bX), Boolean.valueOf(i5), str3);
        ab.d("MicroMsg.MoreTabUI", "bankcardDot : ".concat(String.valueOf(b)));
        if (b) {
            if (bo.isNullOrNil(str)) {
                iconPreference.ez("", -1);
                iconPreference.NM(8);
                iconPreference.NN(0);
            } else {
                iconPreference.NM(0);
                iconPreference.av(str, -1, -7566196);
                iconPreference.qh(true);
                iconPreference.NN(8);
            }
        } else if (bX) {
            iconPreference.NL(0);
            iconPreference.ey(getString(R.string.s0), R.drawable.w3);
            iconPreference.NN(8);
        } else if (i2 > 99) {
            iconPreference.NL(0);
            iconPreference.ey(getString(R.string.eu9), com.tencent.mm.ui.tools.r.ik(getContext()));
            iconPreference.NN(8);
        } else if (i2 > 0) {
            iconPreference.NL(0);
            iconPreference.ey(String.valueOf(i2), com.tencent.mm.ui.tools.r.ik(getContext()));
            iconPreference.NN(8);
        } else if (i5 != 0) {
            iconPreference.ey("", -1);
            iconPreference.NL(8);
            iconPreference.NN(0);
        } else if (intValue == 1) {
            iconPreference.ey("", -1);
            iconPreference.NL(8);
            iconPreference.NM(0);
            iconPreference.qh(true);
            if (!ah.isNullOrNil(str2)) {
                iconPreference.av(str2, -1, Color.parseColor("#888888"));
            }
            iconPreference.NQ(8);
        } else {
            iconPreference.ey("", -1);
            iconPreference.NL(8);
            iconPreference.NN(8);
            iconPreference.NM(8);
            iconPreference.ez("", -1);
        }
        if (bo.isNullOrNil(str3)) {
            str3 = r5;
        }
        if (ah.isNullOrNil(str3) || i5 == 0) {
            iconPreference.setSummary((CharSequence) "");
        } else {
            iconPreference.setSummary((CharSequence) str3);
        }
        com.tencent.mm.plugin.report.service.h hVar = com.tencent.mm.plugin.report.service.h.pYm;
        Object[] objArr = new Object[5];
        objArr[0] = Integer.valueOf(6);
        objArr[1] = Integer.valueOf(i5 != 0 ? 1 : 0);
        objArr[2] = "";
        objArr[3] = "";
        objArr[4] = Integer.valueOf(1);
        hVar.e(14872, objArr);
        AppMethodBeat.o(29731);
    }

    public final void a(int i, com.tencent.mm.sdk.e.n nVar, Object obj) {
        AppMethodBeat.i(29732);
        int bh = ah.bh(obj);
        ab.d("MicroMsg.MoreTabUI", "onNotifyChange event:%d obj:%d stg:%s", Integer.valueOf(i), Integer.valueOf(bh), nVar);
        aw.ZK();
        if (nVar != com.tencent.mm.model.c.Ry() || bh <= 0) {
            ab.e("MicroMsg.MoreTabUI", "onNotifyChange error obj:%d stg:%s", Integer.valueOf(bh), nVar);
            AppMethodBeat.o(29732);
        } else if (204817 == bh || 204820 == bh) {
            dyQ();
            AppMethodBeat.o(29732);
        } else if (40 == bh) {
            dyP();
            AppMethodBeat.o(29732);
        } else {
            if ("208899".equals(Integer.valueOf(i))) {
                dyO();
            }
            AppMethodBeat.o(29732);
        }
    }

    private boolean pS(boolean z) {
        AppMethodBeat.i(29733);
        com.tencent.mm.plugin.appbrand.n.c.izk.a(com.tencent.mm.plugin.appbrand.n.c.a.izo);
        com.tencent.mm.plugin.appbrand.n.c.izk.a(com.tencent.mm.plugin.appbrand.n.c.a.izA);
        Intent intent = new Intent();
        intent.putExtra("preceding_scence", 2);
        intent.putExtra("isNativeView", z);
        d.b(getContext(), "appbrand", ".functions.emojistore.LFEmojiStoreContainerActivity", intent);
        AppMethodBeat.o(29733);
        return true;
    }

    public void onConfigurationChanged(Configuration configuration) {
        AppMethodBeat.i(29734);
        super.onConfigurationChanged(configuration);
        ab.d("MicroMsg.MoreTabUI", "onConfigurationChanged");
        if (configuration.orientation == 1) {
            this.lZa = false;
            if (this.yoh != null) {
                this.yoj.dyU();
                AppMethodBeat.o(29734);
                return;
            }
        } else if (configuration.orientation == 2) {
            this.lZa = true;
            if (this.yoh != null) {
                if (!this.yoh.isVisible) {
                    this.yoh.dLf();
                }
                this.yoj.Nr(2);
            }
        }
        AppMethodBeat.o(29734);
    }

    /* Access modifiers changed, original: protected|final */
    public final void dvY() {
        boolean z;
        AppMethodBeat.i(29735);
        if (getResources().getConfiguration().orientation == 2) {
            z = true;
        } else {
            z = false;
        }
        this.lZa = z;
        this.ehK = this.yCw;
        this.contentView = getContentView();
        com.tencent.mm.compatible.util.a.bG(getContext());
        com.tencent.mm.kernel.g.RQ();
        this.plr = ((e) com.tencent.mm.kernel.g.M(e.class)).getStoryUIFactory().eV(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(com.tencent.mm.bz.a.am(getContext(), R.dimen.a7g), com.tencent.mm.bz.a.am(getContext(), R.dimen.a7g));
        layoutParams.gravity = 83;
        ((ViewGroup) getContext().findViewById(R.id.bns).getParent()).addView(this.plr, 0, layoutParams);
        this.yoh.zRr = this.yoB;
        this.yoh.setPadding(this.yoh.getPaddingLeft(), this.yoh.getPaddingTop(), this.yoh.getPaddingRight(), this.yoi.getHeight());
        if (this.oZf != null) {
            ab.d("MicroMsg.MoreTabUI", "dancy test add view !");
            this.plq = ((e) com.tencent.mm.kernel.g.M(e.class)).getStoryUIFactory().a(getContext(), com.tencent.mm.plugin.story.api.m.a.SelfTabGallery, null);
            if (this.plq != null) {
                int am;
                this.yos = -(ak.hy(getContext()).y / 10);
                if (this.yot) {
                    am = com.tencent.mm.bz.a.am(getContext(), R.dimen.a7i);
                } else {
                    am = com.tencent.mm.bz.a.am(getContext(), R.dimen.a7h);
                }
                this.yor = am;
                this.yoq = -com.tencent.mm.bz.a.fromDPToPix(getContext(), ErrorCode.ERROR_QBSDK_INIT_ERROR_RET_TYPE_NOT_BUNDLE);
                this.yop = 0;
                LayoutParams layoutParams2 = new LayoutParams(-1, ak.hy(getContext()).y);
                layoutParams2.topMargin = this.yos;
                layoutParams2.bottomMargin = -ak.fr(getContext());
                this.oZf.addView(this.plq, 0, layoutParams2);
                this.yoh.x(this.plq, this.yor, this.yos);
                this.yoh.setNavigationBarHeight(ak.fr(getActivity()));
                this.plq.setDataSeed(r.Yz());
                this.plq.a(this.yoh);
                this.plq.setStoryBrowseUIListener(this);
            }
            ((e) com.tencent.mm.kernel.g.M(e.class)).getStoryUIFactory().d(this.yoo, this.yog);
            this.yoj.dyU();
        }
        AppMethodBeat.o(29735);
    }

    private void Nq(int i) {
        AppMethodBeat.i(29736);
        View findViewById = findViewById(R.id.k0);
        if (findViewById != null) {
            findViewById.setVisibility(i);
            ab.i("MicroMsg.MoreTabUI", "setActionbarContainer type:%s", Integer.valueOf(i));
            AppMethodBeat.o(29736);
            return;
        }
        ab.i("MicroMsg.MoreTabUI", "setActionbarContainer is null!!");
        AppMethodBeat.o(29736);
    }

    /* Access modifiers changed, original: protected|final */
    public final void dvZ() {
        AppMethodBeat.i(29737);
        long currentTimeMillis = System.currentTimeMillis();
        this.ehK = this.yCw;
        aw.ZK();
        com.tencent.mm.model.c.Ry().a(this);
        c.PK().a(this.qpv);
        this.ehK.ce("more_tab_setting_personal_info", false);
        this.yol = (AccountInfoPreference) this.yCw.aqO("more_tab_setting_personal_info");
        String YA = r.YA();
        if (ah.isNullOrNil(YA)) {
            YA = r.Yz();
            if (ad.aoA(YA)) {
                this.yol.vpX = null;
            } else {
                this.yol.vpX = YA;
            }
        } else {
            this.yol.vpX = YA;
        }
        this.yol.userName = r.Yz();
        CharSequence YB = r.YB();
        if (ah.isNullOrNil(YB)) {
            YB = r.Yz();
        }
        this.yol.vpW = j.b(getContext(), YB);
        this.yol.ad(this.pnR, this.yot);
        this.yol.vqe = new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(29698);
                if (MoreTabUI.this.lZa) {
                    t.makeText(MoreTabUI.this.getContext(), MoreTabUI.this.getResources().getString(R.string.et4), 0).show();
                    AppMethodBeat.o(29698);
                    return;
                }
                if (MoreTabUI.this.yoh != null) {
                    MoreTabUI.this.yoh.dLg();
                }
                AppMethodBeat.o(29698);
            }
        };
        ((AccountInfoPreference) this.ehK.aqO("more_tab_setting_personal_info")).vqd = new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(29699);
                com.tencent.mm.plugin.report.service.h.pYm.e(11264, Integer.valueOf(1));
                MoreTabUI.this.startActivity(new Intent(MoreTabUI.this.getContext(), SelfQRCodeUI.class));
                AppMethodBeat.o(29699);
            }
        };
        IconPreference iconPreference = (IconPreference) this.ehK.aqO("settings_my_address");
        if (iconPreference != null) {
            int dtd = com.tencent.mm.bi.d.akP().dtd();
            if (dtd > 0) {
                iconPreference.NL(0);
                iconPreference.ey(String.valueOf(dtd), R.drawable.w3);
            } else {
                iconPreference.NL(8);
                iconPreference.ey("", -1);
            }
        }
        dyL();
        dyO();
        dyN();
        if (d.afj("favorite")) {
            this.ehK.ce("settings_mm_favorite", false);
        } else {
            this.ehK.ce("settings_mm_favorite", true);
        }
        dyQ();
        dyP();
        dyM();
        if (com.tencent.mm.kernel.g.RL().J(com.tencent.mm.plugin.x.a.a.class)) {
            this.ehK.ce("more_uishow", false);
        } else {
            this.ehK.ce("more_uishow", true);
        }
        Preference aqO = this.ehK.aqO("settings_privacy_agreements");
        if (com.tencent.mm.au.b.sO((String) com.tencent.mm.kernel.g.RP().Ry().get(274436, null))) {
            YA = getString(R.string.dei);
            CharSequence newSpannable = Factory.getInstance().newSpannable(YA);
            newSpannable.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.t7)), newSpannable.length() - YA.length(), newSpannable.length(), 33);
            aqO.setTitle(newSpannable);
            this.ehK.ce("settings_privacy_agreements", false);
        } else {
            this.ehK.ce("settings_privacy_agreements", true);
        }
        thisActivity().supportInvalidateOptionsMenu();
        this.ehK.notifyDataSetChanged();
        final View findViewById = findViewById(R.id.ev4);
        if (!(findViewById == null || findViewById.getVisibility() == 8)) {
            new ak(Looper.getMainLooper()).post(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(29713);
                    findViewById.setVisibility(8);
                    findViewById.startAnimation(AnimationUtils.loadAnimation(MoreTabUI.this.getContext(), R.anim.b6));
                    AppMethodBeat.o(29713);
                }
            });
        }
        if (this.yoh != null && this.yoh.isVisible) {
            Nq(0);
            ab.i("MicroMsg.MoreTabUI", "onTabResume force set actionbar visible!!");
        }
        if (this.plq != null) {
            this.plq.onResume();
            this.plq.Pb();
        }
        boolean z = ((e) com.tencent.mm.kernel.g.M(e.class)).isShowStoryCheck() && c.PK().bX(352279, 266241);
        this.yom = z;
        dyT();
        ab.i("MicroMsg.MoreTabUI", "[onTabResume] cost:%s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        AppMethodBeat.o(29737);
    }

    /* Access modifiers changed, original: protected|final */
    public final void dwa() {
        AppMethodBeat.i(29738);
        if (this.plq != null) {
            this.plq.onStart();
        }
        AppMethodBeat.o(29738);
    }

    /* Access modifiers changed, original: protected|final */
    public final void dwb() {
        AppMethodBeat.i(29739);
        ab.d("MicroMsg.MoreTabUI", "onTabPause");
        c.PK().b(this.qpv);
        aw.ZK();
        com.tencent.mm.model.c.Ry().b(this);
        if (this.plq != null) {
            this.plq.onPause();
        }
        if (this.yoh != null) {
            if (!this.yoh.isVisible && !this.pnR) {
                this.yoh.postDelayed(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(29690);
                        MoreTabUI.this.yoh.dLf();
                        AppMethodBeat.o(29690);
                    }
                }, 200);
            } else if (this.yoh.isVisible && this.yoh.getTranslationY() != 0.0f) {
                this.yoh.setTranslationY(0.0f);
            }
        }
        dyS();
        AppMethodBeat.o(29739);
    }

    /* Access modifiers changed, original: protected|final */
    public final void dwc() {
        AppMethodBeat.i(29740);
        if (this.plq != null) {
            this.plq.onStop();
        }
        AppMethodBeat.o(29740);
    }

    /* Access modifiers changed, original: protected|final */
    public final void dwd() {
        AppMethodBeat.i(29741);
        if (this.plq != null) {
            this.plq.onDestroy();
        }
        ((e) com.tencent.mm.kernel.g.M(e.class)).getStoryUIFactory().ee(this.yog);
        AppMethodBeat.o(29741);
    }

    public final void dwf() {
    }

    public final void dwg() {
    }

    public final void dwi() {
    }

    public final void dxc() {
        AppMethodBeat.i(29742);
        ab.d("MicroMsg.MoreTabUI", "onTabSwitchIn");
        this.you = true;
        if (getContext() != null) {
            this.lZa = getResources().getConfiguration().orientation == 2;
        }
        if (this.yoh != null) {
            PullDownListView pullDownListView = this.yoh;
            ai.i("MicroMsg.PullDownListView", "onResume", new Object[0]);
            pullDownListView.zRn = true;
            if (this.yoh.isVisible && this.yoh.getTranslationY() != 0.0f) {
                this.yoh.setTranslationY(0.0f);
            } else if (!this.yoh.isVisible) {
                this.yoh.dLf();
            }
        }
        if (this.plq != null) {
            this.plq.Pb();
        }
        pT(true);
        long currentTimeMillis = System.currentTimeMillis();
        h hVar = h.scu;
        h.lq(currentTimeMillis);
        hVar = h.scu;
        h.cAJ().cZm = currentTimeMillis;
        h hVar2 = h.scu;
        h.cAJ().cZW = System.currentTimeMillis();
        AppMethodBeat.o(29742);
    }

    public final void dxd() {
        AppMethodBeat.i(29743);
        this.you = false;
        if (this.yoh != null) {
            PullDownListView pullDownListView = this.yoh;
            ai.i("MicroMsg.PullDownListView", "onPause", new Object[0]);
            pullDownListView.zRn = false;
            if (!this.yoh.isVisible) {
                this.yoh.dLf();
            }
        }
        if (this.plr != null) {
            this.plr.setVisibility(8);
        }
        com.tencent.mm.sdk.b.a.xxA.m(new sp());
        pT(false);
        h hVar = h.scu;
        h.cAK();
        AppMethodBeat.o(29743);
    }

    public final void caA() {
        AppMethodBeat.i(29744);
        ab.i("MicroMsg.MoreTabUI", "story_cat storyUINoStory");
        if (!(this.yoh == null || this.yoh.isVisible)) {
            this.yoh.dLf();
        }
        if (!n.isShowStoryCheck() || this.lZa) {
            this.yoj.Nr(2);
            AppMethodBeat.o(29744);
            return;
        }
        this.yoj.Nr(1);
        AppMethodBeat.o(29744);
    }

    public final void caB() {
        AppMethodBeat.i(29745);
        ab.i("MicroMsg.MoreTabUI", "story_cat storyUIHasStory");
        if (this.yoh != null && this.yoh.isVisible) {
            if (this.lZa) {
                this.yoj.Nr(2);
            } else {
                this.yoj.Nr(0);
            }
        }
        IconPreference iconPreference = (IconPreference) this.ehK.aqO("settings_my_album");
        if (iconPreference != null) {
            if (com.tencent.mm.kernel.g.RP().Ry().getBoolean(com.tencent.mm.storage.ac.a.USERINFO_STORY_NEED_DISPLAY_ALBUM_GUIDE_BOOLEAN_SYNC, true)) {
                this.yov = true;
                iconPreference.NN(0);
                AppMethodBeat.o(29745);
                return;
            }
            this.yov = false;
            iconPreference.NN(8);
        }
        AppMethodBeat.o(29745);
    }

    public final void caC() {
        AppMethodBeat.i(29746);
        ab.i("MicroMsg.MoreTabUI", "story_cat storyUIBackPressed");
        if (!(this.yoh == null || this.yoh.isVisible)) {
            this.yoh.dLf();
        }
        Nq(0);
        pU(this.pnR);
        AppMethodBeat.o(29746);
    }

    private void pT(boolean z) {
        boolean z2 = true;
        AppMethodBeat.i(29747);
        if (getActivity() != null) {
            if (this.plw == null) {
                View findViewById = findViewById(R.id.k0);
                if (findViewById != null) {
                    this.plw = findViewById.findViewById(R.id.k1);
                }
                String str = "MicroMsg.MoreTabUI";
                String str2 = "checkActionBarClick: findActionBar %s";
                Object[] objArr = new Object[1];
                if (this.plw == null) {
                    z2 = false;
                }
                objArr[0] = Boolean.valueOf(z2);
                ab.i(str, str2, objArr);
            }
            if (this.plw != null) {
                if (z) {
                    this.plw.setOnClickListener(new OnClickListener() {
                        public final void onClick(View view) {
                            AppMethodBeat.i(29691);
                            ab.i("MicroMsg.MoreTabUI", "onClick: mActionBarRoot");
                            if (MoreTabUI.this.lZa) {
                                t.makeText(MoreTabUI.this.getContext(), MoreTabUI.this.getResources().getString(R.string.et4), 0).show();
                                AppMethodBeat.o(29691);
                                return;
                            }
                            if (MoreTabUI.this.yoh != null && MoreTabUI.this.yoh.isVisible) {
                                MoreTabUI.this.yoh.dLg();
                            }
                            AppMethodBeat.o(29691);
                        }
                    });
                    AppMethodBeat.o(29747);
                    return;
                }
                this.plw.setOnClickListener(null);
            }
        }
        AppMethodBeat.o(29747);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        boolean wY;
        AppMethodBeat.i(29748);
        if (i == 4 && keyEvent.getAction() == 0 && this.plq != null) {
            wY = this.plq.wY();
        } else {
            wY = false;
        }
        ab.d("MicroMsg.MoreTabUI", "onBackPressed: %b", Boolean.valueOf(wY));
        if (wY || super.onKeyDown(i, keyEvent)) {
            AppMethodBeat.o(29748);
            return true;
        }
        AppMethodBeat.o(29748);
        return false;
    }

    private void pU(boolean z) {
        AppMethodBeat.i(29749);
        if ((getContext() instanceof LauncherUI) && this.yoh != null && this.yoh.isVisible) {
            ((LauncherUI) getContext()).getHomeUI().pK(z);
        }
        AppMethodBeat.o(29749);
    }

    /* Access modifiers changed, original: final */
    public final void caE() {
        AppMethodBeat.i(29750);
        if (com.tencent.mm.compatible.util.d.iW(19)) {
            getWindow().clearFlags(201327616);
            AppMethodBeat.o(29750);
            return;
        }
        getWindow().clearFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
        AppMethodBeat.o(29750);
    }

    private void dyR() {
        AppMethodBeat.i(29751);
        ab.c("MicroMsg.MoreTabUI", "activeBubbleTip", new Object[0]);
        this.yon.setVisibility(0);
        ((e) com.tencent.mm.kernel.g.M(e.class)).getStoryUIFactory().ef(this.yog);
        AppMethodBeat.o(29751);
    }

    private void dyS() {
        AppMethodBeat.i(29752);
        ab.c("MicroMsg.MoreTabUI", "forceStopBubbleTip", new Object[0]);
        this.yon.setVisibility(4);
        ((e) com.tencent.mm.kernel.g.M(e.class)).getStoryUIFactory().eg(this.yog);
        AppMethodBeat.o(29752);
    }

    private void dyT() {
        AppMethodBeat.i(29753);
        if (this.yom && this.yoh.isVisible) {
            dyR();
            AppMethodBeat.o(29753);
            return;
        }
        dyS();
        AppMethodBeat.o(29753);
    }

    static /* synthetic */ void j(MoreTabUI moreTabUI) {
        AppMethodBeat.i(29761);
        if (moreTabUI.getContext() instanceof LauncherUI) {
            HomeUI homeUI = ((LauncherUI) moreTabUI.getContext()).getHomeUI();
            if (homeUI.yje != null) {
                homeUI.yje.setVisible(false);
                homeUI.yje.setEnabled(false);
            }
        }
        AppMethodBeat.o(29761);
    }

    static /* synthetic */ void k(MoreTabUI moreTabUI) {
        AppMethodBeat.i(29762);
        if (com.tencent.mm.compatible.util.d.iW(19)) {
            moreTabUI.getWindow().setFlags(201327616, 201327616);
            AppMethodBeat.o(29762);
            return;
        }
        moreTabUI.getWindow().setFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
        AppMethodBeat.o(29762);
    }

    static /* synthetic */ void c(MoreTabUI moreTabUI, boolean z) {
        AppMethodBeat.i(29768);
        ab.i("MicroMsg.MoreTabUI", "updateStatusBarCell %s stack: %s", Boolean.valueOf(z), ah.anW().toString());
        if (VERSION.SDK_INT >= 23) {
            View decorView = moreTabUI.getActivity().getWindow().getDecorView();
            if (decorView != null) {
                int systemUiVisibility = decorView.getSystemUiVisibility();
                if (z) {
                    systemUiVisibility &= -8193;
                } else {
                    systemUiVisibility |= Utility.DEFAULT_STREAM_BUFFER_SIZE;
                }
                decorView.setSystemUiVisibility(systemUiVisibility);
            }
        }
        AppMethodBeat.o(29768);
    }
}
