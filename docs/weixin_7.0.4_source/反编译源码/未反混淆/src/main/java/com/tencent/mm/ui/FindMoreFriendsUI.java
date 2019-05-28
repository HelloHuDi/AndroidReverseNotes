package com.tencent.mm.ui;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.CheckBox;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.bg.e;
import com.tencent.mm.g.a.cq;
import com.tencent.mm.g.a.gy;
import com.tencent.mm.g.a.gz;
import com.tencent.mm.g.a.ho;
import com.tencent.mm.g.a.ib;
import com.tencent.mm.g.a.ik;
import com.tencent.mm.g.a.iw;
import com.tencent.mm.g.a.jb;
import com.tencent.mm.g.a.ll;
import com.tencent.mm.g.a.mz;
import com.tencent.mm.g.a.oh;
import com.tencent.mm.g.a.oj;
import com.tencent.mm.g.a.px;
import com.tencent.mm.g.a.pz;
import com.tencent.mm.g.a.ql;
import com.tencent.mm.g.a.qm;
import com.tencent.mm.g.a.qp;
import com.tencent.mm.g.a.sk;
import com.tencent.mm.g.a.to;
import com.tencent.mm.g.a.vl;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ar;
import com.tencent.mm.model.as;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bp;
import com.tencent.mm.plugin.account.bind.ui.BindMContactIntroUI;
import com.tencent.mm.plugin.account.bind.ui.MobileFriendUI;
import com.tencent.mm.plugin.account.friend.a.l;
import com.tencent.mm.plugin.account.ui.FacebookFriendUI;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.messenger.foundation.a.o;
import com.tencent.mm.plugin.messenger.foundation.a.p;
import com.tencent.mm.plugin.setting.ui.setting.SettingsManageFindMoreUI;
import com.tencent.mm.plugin.sns.b.m;
import com.tencent.mm.plugin.sns.b.n;
import com.tencent.mm.plugin.websearch.api.ac;
import com.tencent.mm.plugin.websearch.api.am;
import com.tencent.mm.plugin.websearch.api.an;
import com.tencent.mm.plugin.websearch.api.j;
import com.tencent.mm.pluginsdk.f.f;
import com.tencent.mm.pluginsdk.wallet.i;
import com.tencent.mm.protocal.protobuf.cht;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.ui.base.preference.IconPreference;
import com.tencent.mm.ui.base.preference.NormalIconPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceSmallCategory;
import com.tencent.mm.ui.base.preference.h;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.tools.r;
import com.tencent.soter.core.biometric.FaceManager;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class FindMoreFriendsUI extends AbstractTabChildPreference implements ar, as, com.tencent.mm.sdk.e.k.a, b {
    private boolean cCt = false;
    private long kFU;
    private ak mHandler = new ak(Looper.getMainLooper()) {
        public final void handleMessage(Message message) {
            AppMethodBeat.i(29207);
            switch (message.what) {
                case 1:
                    if (FindMoreFriendsUI.this.yhb != null) {
                        FindMoreFriendsUI.b(FindMoreFriendsUI.this);
                        break;
                    }
                    break;
            }
            AppMethodBeat.o(29207);
        }
    };
    private c<vl> mJI = new c<vl>() {
        {
            AppMethodBeat.i(29213);
            this.xxI = vl.class.getName().hashCode();
            AppMethodBeat.o(29213);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(29214);
            FindMoreFriendsUI.this.getContentView().post(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(29212);
                    if (FindMoreFriendsUI.this.isAdded()) {
                        FindMoreFriendsUI.d(FindMoreFriendsUI.this);
                    }
                    AppMethodBeat.o(29212);
                }
            });
            AppMethodBeat.o(29214);
            return false;
        }
    };
    private CheckBox oPS;
    private com.tencent.mm.ui.widget.a.c oPU = null;
    c qLL = new c<sk>() {
        {
            AppMethodBeat.i(29238);
            this.xxI = sk.class.getName().hashCode();
            AppMethodBeat.o(29238);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(29239);
            ab.i("MicroMsg.FindMoreFriendsUI", "mark sns read %d", Integer.valueOf(((sk) bVar).cOH.czE));
            if (((sk) bVar).cOH.czE == 9) {
                new ak(Looper.getMainLooper()).post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(29237);
                        aw.ZK();
                        com.tencent.mm.model.c.Ry().set(68377, (Object) "");
                        if (FindMoreFriendsUI.this.yhb != null) {
                            FindMoreFriendsUI.this.yhb.notifyDataSetChanged();
                        }
                        AppMethodBeat.o(29237);
                    }
                });
            }
            AppMethodBeat.o(29239);
            return true;
        }
    };
    private int qnE;
    private int status;
    private com.tencent.mm.pluginsdk.c.a vqt = new com.tencent.mm.pluginsdk.c.a() {
        public final void j(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(29236);
            ab.d("MicroMsg.FindMoreFriendsUI", "onMStorageNotifyEvent, %s ", bVar);
            if (bVar instanceof jb) {
                FindMoreFriendsUI.e(FindMoreFriendsUI.this);
                if (FindMoreFriendsUI.this.yhb != null) {
                    FindMoreFriendsUI.this.yhb.notifyDataSetChanged();
                }
            }
            AppMethodBeat.o(29236);
        }
    };
    com.tencent.mm.at.p.a yhA = new com.tencent.mm.at.p.a() {
        public final void i(final String str, final Bitmap bitmap) {
            AppMethodBeat.i(29219);
            al.d(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(29218);
                    ab.i("MicroMsg.FindMoreFriendsUI", "download url " + str + " , result " + (bitmap == null));
                    IconPreference iconPreference = (IconPreference) FindMoreFriendsUI.this.yhb.aqO("jd_market_entrance");
                    if (iconPreference != null) {
                        if (str.equals(FindMoreFriendsUI.this.yhf)) {
                            FindMoreFriendsUI.this.yhf = null;
                        } else if (str.equals(FindMoreFriendsUI.this.yhj)) {
                            iconPreference.ap(bitmap);
                            FindMoreFriendsUI.this.yhj = null;
                        }
                        FindMoreFriendsUI.this.yhb.notifyDataSetChanged();
                    }
                    if (str.equals(FindMoreFriendsUI.this.yhg)) {
                        ((IconPreference) FindMoreFriendsUI.this.yhb.aqO("find_friends_by_look")).drawable = new BitmapDrawable(FindMoreFriendsUI.this.getContext().getResources(), bitmap);
                        FindMoreFriendsUI.this.yhg = null;
                        FindMoreFriendsUI.this.yhb.notifyDataSetChanged();
                    }
                    if (str.equals(FindMoreFriendsUI.this.yhh)) {
                        ((IconPreference) FindMoreFriendsUI.this.yhb.aqO("find_friends_by_search")).drawable = new BitmapDrawable(FindMoreFriendsUI.this.getContext().getResources(), bitmap);
                        FindMoreFriendsUI.this.yhh = null;
                        FindMoreFriendsUI.this.yhb.notifyDataSetChanged();
                    }
                    if (str.equals(FindMoreFriendsUI.this.yhi)) {
                        ((IconPreference) FindMoreFriendsUI.this.yhb.aqO("find_friends_by_look")).ap(bitmap);
                        FindMoreFriendsUI.this.yhi = null;
                        FindMoreFriendsUI.this.yhb.notifyDataSetChanged();
                    }
                    if (str.equals(FindMoreFriendsUI.this.yhw)) {
                        ((IconPreference) FindMoreFriendsUI.this.yhb.aqO("my_life_around")).ap(d.a(bitmap, false, ((float) bitmap.getWidth()) * 0.1f));
                        FindMoreFriendsUI.this.yhw = null;
                        FindMoreFriendsUI.this.yhb.notifyDataSetChanged();
                    }
                    AppMethodBeat.o(29218);
                }
            });
            AppMethodBeat.o(29219);
        }
    };
    private long yha;
    private h yhb;
    private View yhc;
    private String yhd = "";
    private int yhe = 0;
    private String yhf = null;
    private String yhg = null;
    private String yhh = null;
    private String yhi = null;
    private String yhj = null;
    private boolean yhk = false;
    private boolean yhl = false;
    private boolean yhm = true;
    private int yhn;
    private View yho;
    private TextView yhp;
    private c<px> yhq = new c<px>() {
        {
            AppMethodBeat.i(29222);
            this.xxI = px.class.getName().hashCode();
            AppMethodBeat.o(29222);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(29223);
            FindMoreFriendsUI.c(FindMoreFriendsUI.this);
            FindMoreFriendsUI.d(FindMoreFriendsUI.this);
            AppMethodBeat.o(29223);
            return false;
        }
    };
    c yhr = new c<iw>() {
        {
            AppMethodBeat.i(29240);
            this.xxI = iw.class.getName().hashCode();
            AppMethodBeat.o(29240);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(29241);
            if (f.vdy != null) {
                com.tencent.mm.plugin.report.service.h.pYm.e(11178, bo.nullAsNil(r0.cDA()), r0.cDB().cDm(), Integer.valueOf(FindMoreFriendsUI.dxe()));
            }
            FindMoreFriendsUI.b(FindMoreFriendsUI.this);
            FindMoreFriendsUI.this.yhb.notifyDataSetChanged();
            AppMethodBeat.o(29241);
            return true;
        }
    };
    c yhs = new c<cq>() {
        {
            AppMethodBeat.i(29242);
            this.xxI = cq.class.getName().hashCode();
            AppMethodBeat.o(29242);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(29243);
            ab.i("MicroMsg.FindMoreFriendsUI", "dynamic config file change");
            FindMoreFriendsUI.this.mHandler.sendEmptyMessage(1);
            AppMethodBeat.o(29243);
            return true;
        }
    };
    private com.tencent.mm.pluginsdk.c.a yht = new com.tencent.mm.pluginsdk.c.a() {
        public final void j(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(29244);
            if (bVar instanceof gy) {
                FindMoreFriendsUI.g(FindMoreFriendsUI.this);
                FindMoreFriendsUI.this.yhb.notifyDataSetChanged();
            }
            AppMethodBeat.o(29244);
        }
    };
    private com.tencent.mm.pluginsdk.c.a yhu = new com.tencent.mm.pluginsdk.c.a() {
        public final void j(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(29245);
            if (bVar instanceof qm) {
                FindMoreFriendsUI.h(FindMoreFriendsUI.this);
                FindMoreFriendsUI.this.yhb.notifyDataSetChanged();
            }
            AppMethodBeat.o(29245);
        }
    };
    private c yhv = new c<ql>() {
        {
            AppMethodBeat.i(29246);
            this.xxI = ql.class.getName().hashCode();
            AppMethodBeat.o(29246);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(29247);
            if (((ql) bVar) instanceof ql) {
                FindMoreFriendsUI.h(FindMoreFriendsUI.this);
                FindMoreFriendsUI.this.yhb.notifyDataSetChanged();
            }
            AppMethodBeat.o(29247);
            return false;
        }
    };
    private String yhw;
    private a yhx = a.TYPE_NONE;
    private o yhy = new o() {
        public final void onNewXmlReceived(String str, Map<String, String> map, com.tencent.mm.ai.e.a aVar) {
            AppMethodBeat.i(29208);
            if (bo.nullAsNil(str).equals("lifeappreddot") && map != null) {
                boolean equals = "1".equals(map.get(".sysmsg.lifeappreddot"));
                ab.d("MicroMsg.FindMoreFriendsUI", "life around xml msg content, showRedDot: %s.", Boolean.valueOf(equals));
                g.RP().Ry().set(com.tencent.mm.storage.ac.a.MY_LIFE_AROUND_APP_RED_DOT_TAG_BOOLEAN, Boolean.valueOf(equals));
                if (equals) {
                    Object obj = (String) map.get(".sysmsg.lifeappreddot.$text");
                    Object obj2 = (String) map.get(".sysmsg.lifeappreddot.$imageurl");
                    ab.d("MicroMsg.FindMoreFriendsUI", "life around xml msg content, type: %s, text: %s, imgUrl: %s.", (String) map.get(".sysmsg.lifeappreddot.$type"), obj, obj2);
                    if (FindMoreFriendsUI.a(FindMoreFriendsUI.this, (String) obj, (String) obj2)) {
                        g.RP().Ry().set(com.tencent.mm.storage.ac.a.MY_LIFE_AROUND_APP_RED_DOT_TYPE_STRING, r0);
                        g.RP().Ry().set(com.tencent.mm.storage.ac.a.MY_LIFE_AROUND_APP_RED_DOT_TEXT_STRING, obj);
                        g.RP().Ry().set(com.tencent.mm.storage.ac.a.MY_LIFE_AROUND_APP_RED_DOT_IMG_URL_STRING, obj2);
                    }
                    AppMethodBeat.o(29208);
                    return;
                }
                FindMoreFriendsUI.this.yhx = a.TYPE_NONE;
                g.RP().Ry().set(com.tencent.mm.storage.ac.a.MY_LIFE_AROUND_APP_RED_DOT_TYPE_STRING, AppEventsConstants.EVENT_PARAM_VALUE_NO);
                g.RP().Ry().set(com.tencent.mm.storage.ac.a.MY_LIFE_AROUND_APP_RED_DOT_TEXT_STRING, (Object) "");
                g.RP().Ry().set(com.tencent.mm.storage.ac.a.MY_LIFE_AROUND_APP_RED_DOT_IMG_URL_STRING, (Object) "");
            }
            AppMethodBeat.o(29208);
        }
    };
    private c<ho> yhz = new c<ho>() {
        {
            AppMethodBeat.i(29215);
            this.xxI = ho.class.getName().hashCode();
            AppMethodBeat.o(29215);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(29216);
            ((ho) bVar).cCs.cCt = FindMoreFriendsUI.this.cCt;
            AppMethodBeat.o(29216);
            return false;
        }
    };

    enum a {
        TYPE_NONE,
        TYPE_NORMAL,
        TYPE_TEXT,
        TYPE_IMG,
        TYPE_IMG_TEXT,
        TYPE_NEW_HINT;

        static {
            AppMethodBeat.o(29250);
        }
    }

    public FindMoreFriendsUI() {
        AppMethodBeat.i(29251);
        AppMethodBeat.o(29251);
    }

    static /* synthetic */ void b(FindMoreFriendsUI findMoreFriendsUI) {
        AppMethodBeat.i(29291);
        findMoreFriendsUI.pD(true);
        AppMethodBeat.o(29291);
    }

    static /* synthetic */ void b(IconPreference iconPreference, int i, int i2, boolean z, int i3, int i4, int i5) {
        AppMethodBeat.i(138185);
        a(iconPreference, i, 8, i2, z, i3, i4, i5);
        AppMethodBeat.o(138185);
    }

    static /* synthetic */ void c(FindMoreFriendsUI findMoreFriendsUI) {
        AppMethodBeat.i(29292);
        findMoreFriendsUI.dwZ();
        AppMethodBeat.o(29292);
    }

    static /* synthetic */ void c(String str, int i, String str2, String str3, int i2) {
        AppMethodBeat.i(138186);
        b(str, i, str2, str3, i2);
        AppMethodBeat.o(138186);
    }

    static /* synthetic */ void d(FindMoreFriendsUI findMoreFriendsUI) {
        AppMethodBeat.i(29293);
        findMoreFriendsUI.dwS();
        AppMethodBeat.o(29293);
    }

    static /* synthetic */ int dxe() {
        AppMethodBeat.i(138180);
        int dwT = dwT();
        AppMethodBeat.o(138180);
        return dwT;
    }

    static /* synthetic */ void e(FindMoreFriendsUI findMoreFriendsUI) {
        AppMethodBeat.i(138179);
        findMoreFriendsUI.dxa();
        AppMethodBeat.o(138179);
    }

    static /* synthetic */ void h(FindMoreFriendsUI findMoreFriendsUI) {
        AppMethodBeat.i(138182);
        findMoreFriendsUI.dwY();
        AppMethodBeat.o(138182);
    }

    static /* synthetic */ void y(FindMoreFriendsUI findMoreFriendsUI) {
        AppMethodBeat.i(138187);
        findMoreFriendsUI.aMk();
        AppMethodBeat.o(138187);
    }

    public final int JC() {
        return R.xml.at;
    }

    public boolean supportNavigationSwipeBack() {
        return false;
    }

    public boolean noActionBar() {
        return true;
    }

    private boolean dwR() {
        AppMethodBeat.i(29252);
        if (bo.L(g.RP().Ry().a(com.tencent.mm.storage.ac.a.FIND_MORE_UI_ENTRY_LAST_REPORT_TIME_LONG_SYNC, 0), this.yha)) {
            AppMethodBeat.o(29252);
            return true;
        }
        AppMethodBeat.o(29252);
        return false;
    }

    private void dwS() {
        AppMethodBeat.i(29253);
        ab.i("MicroMsg.FindMoreFriendsUI", "checkLookVisibility");
        if (this.yCQ && isAdded()) {
            try {
                Object obj;
                boolean z;
                boolean z2;
                JSONObject adL = ac.adL("discoverRecommendEntry");
                if (Cn(67108864)) {
                    ab.i("MicroMsg.FindMoreFriendsUI", "checkLookVisibility in experiment but not open");
                    obj = null;
                    z = false;
                } else if (((com.tencent.mm.plugin.welab.a.a.a) g.K(com.tencent.mm.plugin.welab.a.a.a.class)).agN("labs_browse")) {
                    obj = 1;
                    z = true;
                } else {
                    obj = null;
                    z = true;
                }
                if (com.tencent.mm.au.b.sO((String) g.RP().Ry().get(274436, null))) {
                    ab.i("MicroMsg.FindMoreFriendsUI", "checkLookVisibility EuropeanUnionCountry");
                    z2 = false;
                } else {
                    z2 = z;
                }
                ab.i("MicroMsg.FindMoreFriendsUI", "showLookEntry %s", Boolean.valueOf(z2));
                if (z2) {
                    String optString = adL.optString("wording");
                    final IconPreference iconPreference = (IconPreference) this.yhb.aqO("find_friends_by_look");
                    if (bo.isNullOrNil(optString)) {
                        iconPreference.setTitle((CharSequence) getString(R.string.btu));
                    } else {
                        iconPreference.setTitle((CharSequence) optString);
                    }
                    this.yhn++;
                    this.yhb.ce("find_friends_by_look", false);
                    if (obj != null) {
                        iconPreference.NL(0);
                        iconPreference.ey(getString(R.string.s0), R.drawable.w3);
                    } else {
                        al.d(new Runnable() {
                            public final void run() {
                                AppMethodBeat.i(29209);
                                if (iconPreference == null) {
                                    AppMethodBeat.o(29209);
                                    return;
                                }
                                boolean cEN = ((com.tencent.mm.plugin.topstory.a.b) g.M(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().cEN();
                                int cEU = ((com.tencent.mm.plugin.topstory.a.b) g.M(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().cEU();
                                iconPreference.NN(8);
                                iconPreference.NM(8);
                                iconPreference.NQ(8);
                                iconPreference.NL(8);
                                if (cEU <= 0 || !((com.tencent.mm.plugin.topstory.a.b) g.M(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().cEO()) {
                                    if (cEN) {
                                        if (LauncherUI.dxE() == 2) {
                                            ((com.tencent.mm.plugin.topstory.a.b) g.M(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().cEQ();
                                        }
                                        cht cEP = ((com.tencent.mm.plugin.topstory.a.b) g.M(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().cEP();
                                        Bitmap kR;
                                        switch (cEP.type) {
                                            case 1:
                                                iconPreference.NN(0);
                                                break;
                                            case 2:
                                                iconPreference.NN(8);
                                                iconPreference.NM(0);
                                                iconPreference.av(cEP.text, -1, Color.parseColor("#8c8c8c"));
                                                iconPreference.qh(true);
                                                iconPreference.NQ(8);
                                                break;
                                            case 3:
                                                iconPreference.NN(8);
                                                iconPreference.NQ(0);
                                                iconPreference.NP(0);
                                                iconPreference.NR(0);
                                                iconPreference.qh(false);
                                                com.tencent.mm.at.o.ahk();
                                                kR = com.tencent.mm.at.c.kR(cEP.cIY);
                                                if (kR == null) {
                                                    com.tencent.mm.at.o.aho().a(cEP.cIY, FindMoreFriendsUI.this.yhA);
                                                    FindMoreFriendsUI.this.yhi = cEP.cIY;
                                                    break;
                                                }
                                                FindMoreFriendsUI.this.yhi = null;
                                                iconPreference.ap(kR);
                                                break;
                                            case 4:
                                                iconPreference.NN(8);
                                                iconPreference.NQ(0);
                                                iconPreference.NP(0);
                                                iconPreference.NR(0);
                                                iconPreference.NM(0);
                                                iconPreference.qh(false);
                                                iconPreference.av(cEP.text, -1, Color.parseColor("#8c8c8c"));
                                                com.tencent.mm.at.o.ahk();
                                                kR = com.tencent.mm.at.c.kR(cEP.cIY);
                                                if (kR == null) {
                                                    com.tencent.mm.at.o.aho().a(cEP.cIY, FindMoreFriendsUI.this.yhA);
                                                    FindMoreFriendsUI.this.yhi = cEP.cIY;
                                                    break;
                                                }
                                                FindMoreFriendsUI.this.yhi = null;
                                                iconPreference.ap(kR);
                                                break;
                                            default:
                                                ab.e("MicroMsg.FindMoreFriendsUI", "search unknown red type %d", Integer.valueOf(cEP.type));
                                                break;
                                        }
                                    }
                                }
                                iconPreference.NL(0);
                                String valueOf = String.valueOf(cEU);
                                if (cEU > 99) {
                                    valueOf = "99+";
                                }
                                iconPreference.ey(valueOf, r.ik(FindMoreFriendsUI.this.getContext()));
                                ((com.tencent.mm.plugin.topstory.a.b) g.M(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().Fy(cEU);
                                FindMoreFriendsUI.this.yhb.notifyDataSetChanged();
                                AppMethodBeat.o(29209);
                            }
                        });
                    }
                    ((com.tencent.mm.plugin.topstory.ui.a) g.M(com.tencent.mm.plugin.topstory.ui.a.class)).tryToCreateTopStoryWebView();
                    AppMethodBeat.o(29253);
                    return;
                }
                this.yhb.ce("find_friends_by_look", true);
                if (!dwR()) {
                    com.tencent.mm.plugin.report.service.h.pYm.k(953, 3, 1);
                }
                AppMethodBeat.o(29253);
                return;
            } catch (Exception e) {
                ab.e("MicroMsg.FindMoreFriendsUI", bo.l(e));
                AppMethodBeat.o(29253);
                return;
            }
        }
        ab.i("MicroMsg.FindMoreFriendsUI", "checkLookVisibility preference not add");
        AppMethodBeat.o(29253);
    }

    private boolean ij(String str, String str2) {
        int i;
        a aVar;
        AppMethodBeat.i(29254);
        int i2 = !bo.isNullOrNil(str) ? 1 : 0;
        if (bo.isNullOrNil(str2)) {
            i = 0;
        } else {
            i = 1;
        }
        if (i2 != 0 && i != 0) {
            aVar = a.TYPE_IMG_TEXT;
        } else if (i != 0) {
            aVar = a.TYPE_IMG;
        } else if (i2 != 0) {
            aVar = a.TYPE_TEXT;
        } else {
            aVar = a.TYPE_NORMAL;
        }
        ab.d("MicroMsg.FindMoreFriendsUI", "new type: %s, now type: %s.", aVar, this.yhx);
        if (aVar.compareTo(this.yhx) >= 0) {
            this.yhx = aVar;
            AppMethodBeat.o(29254);
            return true;
        }
        AppMethodBeat.o(29254);
        return false;
    }

    private static void a(IconPreference iconPreference, int i, int i2, boolean z, int i3, int i4, int i5) {
        AppMethodBeat.i(29255);
        iconPreference.NN(i);
        iconPreference.NM(i2);
        iconPreference.qh(z);
        iconPreference.NQ(i3);
        iconPreference.NP(i4);
        iconPreference.NR(i5);
        AppMethodBeat.o(29255);
    }

    private void a(final com.tencent.mm.plugin.websearch.api.am.a aVar, final IconPreference iconPreference) {
        AppMethodBeat.i(138177);
        al.d(new Runnable() {
            public final void run() {
                AppMethodBeat.i(29210);
                if (iconPreference == null) {
                    AppMethodBeat.o(29210);
                } else if (aVar == null) {
                    iconPreference.NN(8);
                    AppMethodBeat.o(29210);
                } else {
                    if (aVar.isValid()) {
                        ab.i("MicroMsg.FindMoreFriendsUI", "show red %s", iconPreference.getTitle());
                        Bitmap kR;
                        switch (aVar.type) {
                            case 1:
                                iconPreference.NN(0);
                                iconPreference.NM(8);
                                break;
                            case 2:
                                iconPreference.NN(8);
                                iconPreference.NM(0);
                                iconPreference.av(aVar.text, -1, Color.parseColor("#8c8c8c"));
                                iconPreference.qh(true);
                                iconPreference.NQ(8);
                                break;
                            case 3:
                                iconPreference.NQ(0);
                                iconPreference.NP(0);
                                iconPreference.NR(0);
                                iconPreference.qh(false);
                                com.tencent.mm.at.o.ahk();
                                kR = com.tencent.mm.at.c.kR(aVar.cIY);
                                if (kR == null) {
                                    com.tencent.mm.at.o.aho().a(aVar.cIY, FindMoreFriendsUI.this.yhA);
                                    FindMoreFriendsUI.this.yhi = aVar.cIY;
                                    break;
                                }
                                FindMoreFriendsUI.this.yhi = null;
                                iconPreference.ap(kR);
                                break;
                            case 4:
                                iconPreference.NQ(0);
                                iconPreference.NP(0);
                                iconPreference.NR(0);
                                iconPreference.NM(0);
                                iconPreference.qh(false);
                                iconPreference.av(aVar.text, -1, Color.parseColor("#8c8c8c"));
                                com.tencent.mm.at.o.ahk();
                                kR = com.tencent.mm.at.c.kR(aVar.cIY);
                                if (kR == null) {
                                    com.tencent.mm.at.o.aho().a(aVar.cIY, FindMoreFriendsUI.this.yhA);
                                    FindMoreFriendsUI.this.yhi = aVar.cIY;
                                    break;
                                }
                                FindMoreFriendsUI.this.yhi = null;
                                iconPreference.ap(kR);
                                break;
                            default:
                                ab.e("MicroMsg.FindMoreFriendsUI", "search unknown red type %d", Integer.valueOf(aVar.type));
                                break;
                        }
                    }
                    ab.i("MicroMsg.FindMoreFriendsUI", "hide red %s", iconPreference.getTitle());
                    iconPreference.NN(8);
                    iconPreference.NM(8);
                    iconPreference.NQ(8);
                    iconPreference.NW(0);
                    FindMoreFriendsUI.this.yhb.notifyDataSetChanged();
                    AppMethodBeat.o(29210);
                }
            }
        });
        AppMethodBeat.o(138177);
    }

    public void onActivityCreated(Bundle bundle) {
        AppMethodBeat.i(29256);
        super.onActivityCreated(bundle);
        ab.i("MicroMsg.FindMoreFriendsUI", "onActivityCreated");
        AppMethodBeat.o(29256);
    }

    /* JADX WARNING: Removed duplicated region for block: B:130:0x05c4  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x02bb  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x03b6  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x0405  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void aMk() {
        AppMethodBeat.i(29257);
        this.yhn = 0;
        this.yha = System.currentTimeMillis();
        if (this.yho != null) {
            this.yho.setVisibility(8);
        }
        if (this.yCQ && isAdded()) {
            boolean bCS;
            IconPreference iconPreference;
            String str;
            int i;
            ab.i("MicroMsg.FindMoreFriendsUI", "status %d (%d), extStatus %d (%d), pluginFlag %d (%d)", Integer.valueOf(this.status), Integer.valueOf(com.tencent.mm.model.r.YD()), Long.valueOf(this.kFU), Long.valueOf(com.tencent.mm.model.r.YE()), Integer.valueOf(this.qnE), Integer.valueOf(com.tencent.mm.model.r.YK()));
            dwX();
            boolean Cn = Cn(1048576);
            boolean afj = com.tencent.mm.bp.d.afj("scanner");
            String str2 = "MicroMsg.FindMoreFriendsUI";
            String str3 = "openScan %s, plugin installed %s";
            Object[] objArr = new Object[2];
            objArr[0] = Boolean.valueOf(!Cn);
            objArr[1] = Boolean.valueOf(afj);
            ab.i(str2, str3, objArr);
            if (Cn || !afj) {
                this.yhb.ce("find_friends_by_qrcode", true);
                if (!dwR()) {
                    com.tencent.mm.plugin.report.service.h.pYm.k(953, 1, 1);
                }
            } else {
                this.yhb.ce("find_friends_by_qrcode", false);
                this.yhn++;
                if (com.tencent.mm.x.c.PK().b(com.tencent.mm.storage.ac.a.NEW_BANDAGE_DATASOURCE_TRANSLATION_RED_DOT_STRING_SYNC, com.tencent.mm.storage.ac.a.NEW_BANDAGE_WATCHER_SCAN_ENTRY_RED_DOT_STRING_SYNC)) {
                    ((NormalIconPreference) this.yhb.aqO("find_friends_by_qrcode")).NN(0);
                } else {
                    ((NormalIconPreference) this.yhb.aqO("find_friends_by_qrcode")).NN(4);
                }
            }
            dwY();
            dwZ();
            dxa();
            Cn = Cn(4194304);
            String str4 = "MicroMsg.FindMoreFriendsUI";
            str2 = "openShoppingEntry %s";
            Object[] objArr2 = new Object[1];
            objArr2[0] = Boolean.valueOf(!Cn);
            ab.i(str4, str2, objArr2);
            if (Cn) {
                this.yhb.ce("jd_market_entrance", true);
                if (!dwR()) {
                    com.tencent.mm.plugin.report.service.h.pYm.k(953, 7, 1);
                }
            } else {
                pD(false);
            }
            com.tencent.mm.plugin.game.a.a bDb = com.tencent.mm.plugin.game.a.a.a.bDb();
            if (bDb != null) {
                getContext();
                bCS = bDb.bCS();
            } else {
                bCS = false;
            }
            afj = Cn(8388608);
            str2 = "MicroMsg.FindMoreFriendsUI";
            str3 = "shouldShowGame %s, openGameEntry %s";
            objArr = new Object[2];
            objArr[0] = Boolean.valueOf(bCS);
            objArr[1] = Boolean.valueOf(!afj);
            ab.i(str2, str3, objArr);
            if (!bCS || afj) {
                this.yhb.ce("more_tab_game_recommend", true);
                if (!dwR()) {
                    com.tencent.mm.plugin.report.service.h.pYm.k(953, 8, 1);
                }
            } else {
                this.yhb.ce("more_tab_game_recommend", false);
                dwW();
                this.yhn++;
            }
            qp qpVar = new qp();
            qpVar.cMH.cMJ = true;
            com.tencent.mm.sdk.b.a.xxA.m(qpVar);
            Cn = qpVar.cMI.cMK;
            boolean Cn2 = Cn(16777216);
            str3 = "MicroMsg.FindMoreFriendsUI";
            String str5 = "shouldShowMiniProgram %s, openMiniProgramEntry %s";
            Object[] objArr3 = new Object[2];
            objArr3[0] = Boolean.valueOf(Cn);
            objArr3[1] = Boolean.valueOf(!Cn2);
            ab.i(str3, str5, objArr3);
            if (!Cn || Cn2) {
                this.yhb.ce("app_brand_entrance", true);
                if (!dwR()) {
                    com.tencent.mm.plugin.report.service.h.pYm.k(953, 9, 1);
                }
            } else {
                int i2;
                this.yhn++;
                this.yhb.ce("app_brand_entrance", false);
                iconPreference = (IconPreference) this.yhb.aqO("app_brand_entrance");
                if (qpVar.cMI.cMM) {
                    i2 = 0;
                } else {
                    i2 = 8;
                }
                iconPreference.NL(i2);
                iconPreference.ey(getString(R.string.s0), R.drawable.w3);
                if (qpVar.cMI.cML) {
                    i2 = 0;
                } else {
                    i2 = 8;
                }
                iconPreference.NN(i2);
            }
            Cn = com.tencent.mm.plugin.ipcall.d.bGW();
            afj = Cn(33554432);
            str2 = "MicroMsg.FindMoreFriendsUI";
            str3 = "showShowWeChatOut %s, openWeChatOutEntry %s";
            objArr = new Object[2];
            objArr[0] = Boolean.valueOf(Cn);
            if (afj) {
                bCS = false;
            } else {
                bCS = true;
            }
            objArr[1] = Boolean.valueOf(bCS);
            ab.i(str2, str3, objArr);
            if (!Cn || afj) {
                this.yhb.ce("ip_call_entrance", true);
            } else {
                int i3;
                this.yhn++;
                this.yhb.ce("ip_call_entrance", false);
                iconPreference = (IconPreference) this.yhb.aqO("ip_call_entrance");
                aw.ZK();
                if (((Integer) com.tencent.mm.model.c.Ry().get(com.tencent.mm.storage.ac.a.USERFINO_IPCALL_HAS_ENTRY_FIND_REDDOT_INT, Integer.valueOf(0))).intValue() < com.tencent.mm.m.g.Nu().getInt("WCOEntranceRedDot", 0)) {
                    iconPreference.NL(0);
                    iconPreference.ey(getString(R.string.s0), R.drawable.w3);
                } else {
                    iconPreference.NL(8);
                }
                iconPreference.NQ(8);
                aw.ZK();
                if (((Boolean) com.tencent.mm.model.c.Ry().get(com.tencent.mm.storage.ac.a.USERFINO_IPCALL_HAS_ENTRY_FIND_REDDOT_NEWXML_BOOLEAN, Boolean.FALSE)).booleanValue()) {
                    iconPreference.qh(true);
                    iconPreference.NL(8);
                    i3 = 1;
                } else {
                    iconPreference.qh(false);
                    i3 = 0;
                }
                aw.ZK();
                str = (String) com.tencent.mm.model.c.Ry().get(com.tencent.mm.storage.ac.a.USERFINO_IPCALL_HAS_ENTRY_FIND_WORDING_STRING, (Object) "");
                iconPreference.av(str, -1, -7566196);
                if (!bo.isNullOrNil(str)) {
                    i3 = 1;
                }
                if (i3 != 0) {
                    iconPreference.NM(0);
                } else {
                    iconPreference.NM(8);
                }
                this.yhb.a(new PreferenceSmallCategory(getContext()), -1);
            }
            dwS();
            Cn = ((Boolean) g.RP().Ry().get(com.tencent.mm.storage.ac.a.MY_LIFE_AROUND_APP_FIND_MORE_PAGE_FIRST_EXPOSE_BOOLEAN, Boolean.TRUE)).booleanValue();
            ab.d("MicroMsg.FindMoreFriendsUI", "firstExposeFindMorePage: %s.", Boolean.valueOf(Cn));
            if (Cn) {
                g.RP().Ry().set(com.tencent.mm.storage.ac.a.MY_LIFE_AROUND_APP_FIND_MORE_PAGE_FIRST_EXPOSE_BOOLEAN, Boolean.FALSE);
            }
            bCS = ((com.tencent.mm.plugin.welab.a.a.a) g.K(com.tencent.mm.plugin.welab.a.a.a.class)).agO("labs_nearbylife");
            ab.i("MicroMsg.FindMoreFriendsUI", "updateMyLifeAroundEntrance isInExperiment: ".concat(String.valueOf(bCS)));
            if (bCS) {
                bCS = ((com.tencent.mm.plugin.welab.a.a.a) g.K(com.tencent.mm.plugin.welab.a.a.a.class)).xj("labs_nearbylife");
                ab.i("MicroMsg.FindMoreFriendsUI", "updateMyLifeAroundEntrance isOpen: ".concat(String.valueOf(bCS)));
                if (bCS) {
                    i = 1;
                    if (i == 0) {
                        iconPreference = (IconPreference) this.yhb.aqO("my_life_around");
                        iconPreference.setTitle((CharSequence) getString(R.string.FF_Entry_Nearby));
                        this.yhn++;
                        if (Cn) {
                            g.RP().Ry().set(com.tencent.mm.storage.ac.a.MY_LIFE_AROUND_APP_NEW_RED_DOT_TAG_BOOLEAN, Boolean.FALSE);
                        } else if (((Boolean) g.RP().Ry().get(com.tencent.mm.storage.ac.a.MY_LIFE_AROUND_APP_NEW_RED_DOT_TAG_BOOLEAN, Boolean.TRUE)).booleanValue()) {
                            this.yhx = a.TYPE_NEW_HINT;
                            iconPreference.NL(0);
                            iconPreference.ey(getString(R.string.s0), R.drawable.w3);
                        }
                        if (((Boolean) g.RP().Ry().get(com.tencent.mm.storage.ac.a.MY_LIFE_AROUND_APP_RED_DOT_TAG_BOOLEAN, Boolean.FALSE)).booleanValue()) {
                            str = (String) g.RP().Ry().get(com.tencent.mm.storage.ac.a.MY_LIFE_AROUND_APP_RED_DOT_TEXT_STRING, (Object) "");
                            str4 = (String) g.RP().Ry().get(com.tencent.mm.storage.ac.a.MY_LIFE_AROUND_APP_RED_DOT_IMG_URL_STRING, (Object) "");
                            ij(str, str4);
                            switch (this.yhx) {
                                case TYPE_IMG_TEXT:
                                    com.tencent.mm.at.o.ahk();
                                    Bitmap kR = com.tencent.mm.at.c.kR(str4);
                                    if (kR != null) {
                                        this.yhw = null;
                                        iconPreference.ap(d.a(kR, false, ((float) kR.getWidth()) * 0.1f));
                                    } else {
                                        this.yhw = str4;
                                        com.tencent.mm.at.o.aho().a(str4, this.yhA);
                                    }
                                    iconPreference.av(str, -1, Color.parseColor("#8c8c8c"));
                                    a(iconPreference, 8, 0, false, 0, 0, 0);
                                    break;
                                case TYPE_IMG:
                                    com.tencent.mm.at.o.ahk();
                                    Bitmap kR2 = com.tencent.mm.at.c.kR(str4);
                                    if (kR2 != null) {
                                        this.yhw = null;
                                        iconPreference.ap(d.a(kR2, false, ((float) kR2.getWidth()) * 0.1f));
                                    } else {
                                        this.yhw = str4;
                                        com.tencent.mm.at.o.aho().a(str4, this.yhA);
                                    }
                                    a(iconPreference, 8, 8, false, 0, 0, 0);
                                    break;
                                case TYPE_TEXT:
                                    iconPreference.av(str, -1, Color.parseColor("#8c8c8c"));
                                    a(iconPreference, 8, 0, true, 8, 8, 8);
                                    break;
                                case TYPE_NORMAL:
                                    a(iconPreference, 0, 8, false, 8, 8, 8);
                                    break;
                            }
                        }
                        a(iconPreference, 8, 8, false, 8, 8, 8);
                        this.yhb.ce("my_life_around", false);
                        com.tencent.mm.plugin.report.service.h.pYm.e(17065, Integer.valueOf(0), Long.valueOf(bo.anT()), Integer.valueOf(this.yhx.ordinal()), g.RP().Ry().get(com.tencent.mm.storage.ac.a.MY_LIFE_AROUND_APP_RED_DOT_IMG_URL_STRING, (Object) ""), g.RP().Ry().get(com.tencent.mm.storage.ac.a.MY_LIFE_AROUND_APP_RED_DOT_TEXT_STRING, (Object) ""), g.RP().Ry().get(com.tencent.mm.storage.ac.a.MY_LIFE_AROUND_APP_RED_DOT_TYPE_STRING, AppEventsConstants.EVENT_PARAM_VALUE_NO));
                    } else {
                        this.yhb.ce("my_life_around", true);
                    }
                    com.tencent.mm.au.b.ahN();
                    this.yhb.ce("find_friends_by_facebook", true);
                    this.yhb.ce("settings_emoji_store", true);
                    if (this.yhn == 0) {
                        ViewGroup viewGroup = (ViewGroup) findViewById(16908298).getParent();
                        if (this.yho == null) {
                            this.yho = getContext().getLayoutInflater().inflate(R.layout.zr, null);
                            this.yhp = (TextView) this.yho.findViewById(R.id.btf);
                            this.yhp.setOnClickListener(new OnClickListener() {
                                public final void onClick(View view) {
                                    AppMethodBeat.i(29217);
                                    FindMoreFriendsUI.this.startActivity(new Intent(FindMoreFriendsUI.this.getContext(), SettingsManageFindMoreUI.class));
                                    AppMethodBeat.o(29217);
                                }
                            });
                            viewGroup.addView(this.yho, new LayoutParams(-1, -1));
                        } else {
                            this.yho.setVisibility(0);
                        }
                    }
                    this.yhb.notifyDataSetChanged();
                    if (!dwR()) {
                        g.RP().Ry().set(com.tencent.mm.storage.ac.a.FIND_MORE_UI_ENTRY_LAST_REPORT_TIME_LONG_SYNC, Long.valueOf(this.yha));
                    }
                    AppMethodBeat.o(29257);
                    return;
                }
            }
            i = 0;
            if (i == 0) {
            }
            com.tencent.mm.au.b.ahN();
            this.yhb.ce("find_friends_by_facebook", true);
            this.yhb.ce("settings_emoji_store", true);
            if (this.yhn == 0) {
            }
            this.yhb.notifyDataSetChanged();
            if (dwR()) {
            }
            AppMethodBeat.o(29257);
            return;
        }
        AppMethodBeat.o(29257);
    }

    private void pD(boolean z) {
        String value;
        boolean z2;
        AppMethodBeat.i(29258);
        if (aa.doo()) {
            value = com.tencent.mm.m.g.Nu().getValue("JDEntranceConfigName");
        } else if (aa.dop()) {
            value = com.tencent.mm.m.g.Nu().getValue("JDEntranceConfigNameHKTW");
        } else {
            value = com.tencent.mm.m.g.Nu().getValue("JDEntranceConfigNameEN");
        }
        String value2 = com.tencent.mm.m.g.Nu().getValue("JDEntranceConfigIconUrl");
        f.b bVar = f.vdy;
        if (bVar != null) {
            String cDA = bVar.cDA();
            if (!bo.isNullOrNil(value) && !bo.isNullOrNil(value2) && !bo.isNullOrNil(cDA)) {
                String str;
                CharSequence charSequence;
                this.yhn++;
                com.tencent.mm.plugin.subapp.jdbiz.b bVar2 = (com.tencent.mm.plugin.subapp.jdbiz.b) bVar.cDB();
                Object charSequence2;
                if (!bVar2.cDk() || bVar2.cDl()) {
                    str = value2;
                    charSequence2 = value;
                } else {
                    if (bo.isNullOrNil(bVar2.iconUrl)) {
                        str = value2;
                    } else {
                        str = bVar2.iconUrl;
                    }
                    if (bo.isNullOrNil(bVar2.title)) {
                        charSequence2 = value;
                    } else {
                        charSequence2 = bVar2.title;
                    }
                }
                IconPreference iconPreference = (IconPreference) this.yhb.aqO("jd_market_entrance");
                com.tencent.mm.at.o.ahk();
                com.tencent.mm.at.c.kR(str);
                iconPreference.setTitle(charSequence2);
                iconPreference.NL(8);
                iconPreference.NN(8);
                iconPreference.NM(8);
                iconPreference.qh(false);
                iconPreference.NQ(8);
                if (bVar.cDs() && bVar2.isStart() && !bVar2.bxX()) {
                    if (!bo.isNullOrNil(bVar2.ssu)) {
                        iconPreference.NL(8);
                        iconPreference.NN(8);
                        iconPreference.av(bVar2.ssu, -1, -7566196);
                        iconPreference.NM(0);
                    }
                    if (!bo.isNullOrNil(bVar2.ssv)) {
                        com.tencent.mm.at.o.ahk();
                        Bitmap kR = com.tencent.mm.at.c.kR(bVar2.ssv);
                        iconPreference.NQ(0);
                        iconPreference.NP(0);
                        iconPreference.NR(0);
                        iconPreference.qh(false);
                        if (kR != null) {
                            this.yhj = null;
                            iconPreference.ap(kR);
                        } else {
                            com.tencent.mm.at.o.aho().a(bVar2.ssv, this.yhA);
                            this.yhj = bVar2.ssv;
                        }
                    } else if (!bo.isNullOrNil(bVar2.ssu)) {
                        iconPreference.qh(true);
                    } else if (bVar2.sst) {
                        iconPreference.NN(0);
                        iconPreference.ey("", -1);
                        iconPreference.NL(8);
                    }
                }
                if (z) {
                    this.yhb.notifyDataSetChanged();
                }
                if (!dwR()) {
                    com.tencent.mm.plugin.report.service.h.pYm.k(931, 12, 1);
                    com.tencent.mm.plugin.report.service.h.pYm.e(11178, cDA, bVar.cDB().cDm(), Integer.valueOf(dwT()));
                }
                z2 = false;
                this.yhb.ce("jd_market_entrance", z2);
                AppMethodBeat.o(29258);
            } else if (!dwR() && aa.doo()) {
                if (bo.isNullOrNil(value)) {
                    com.tencent.mm.plugin.report.service.h.pYm.k(931, 2, 1);
                }
                if (bo.isNullOrNil(value2)) {
                    com.tencent.mm.plugin.report.service.h.pYm.k(931, 3, 1);
                }
                if (bo.isNullOrNil(cDA)) {
                    com.tencent.mm.plugin.report.service.h.pYm.k(931, 4, 1);
                }
            }
        }
        z2 = true;
        this.yhb.ce("jd_market_entrance", z2);
        AppMethodBeat.o(29258);
    }

    private static int dwT() {
        AppMethodBeat.i(29259);
        int i = 1;
        f.b bVar = f.vdy;
        if (bVar != null) {
            com.tencent.mm.pluginsdk.f.f.a cDB = bVar.cDB();
            if (bVar.cDs() && cDB.isStart() && !cDB.bxX()) {
                if (TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL.equals(cDB.cDp()) && !bo.isNullOrNil(cDB.cDq())) {
                    i = 6;
                } else if (!bo.isNullOrNil(cDB.cDn())) {
                    i = 3;
                } else if (cDB.cDo()) {
                    i = 2;
                }
            }
        }
        AppMethodBeat.o(29259);
        return i;
    }

    public final boolean a(com.tencent.mm.ui.base.preference.f fVar, Preference preference, View view) {
        AppMethodBeat.i(29260);
        if (com.tencent.mm.sdk.platformtools.f.IS_FLAVOR_RED && "app_brand_entrance".equals(preference.mKey)) {
            ((com.tencent.mm.plugin.appbrand.service.g) g.K(com.tencent.mm.plugin.appbrand.service.g.class)).b(getContext(), 1, true);
            AppMethodBeat.o(29260);
            return true;
        }
        boolean a = super.a(fVar, preference, view);
        AppMethodBeat.o(29260);
        return a;
    }

    public final boolean a(com.tencent.mm.ui.base.preference.f fVar, Preference preference) {
        AppMethodBeat.i(29261);
        Intent intent;
        IconPreference iconPreference;
        String bc;
        Intent intent2;
        String str;
        String optString;
        if ("album_dyna_photo_ui_title".equals(preference.mKey)) {
            com.tencent.mm.plugin.report.service.g.BN(10);
            aw.ZK();
            this.yhd = (String) com.tencent.mm.model.c.Ry().get(68377, null);
            intent = new Intent();
            com.tencent.mm.modelsns.b bVar = new com.tencent.mm.modelsns.b(701, 1);
            bVar.cS(!bo.isNullOrNil(this.yhd));
            bVar.tx(this.yhe);
            intent.putExtra("sns_timeline_NeedFirstLoadint", true);
            intent.putExtra("is_from_find_more", true);
            String str2 = "enter_by_red";
            boolean z = !bo.isNullOrNil(this.yhd) || this.yhe > 0;
            intent.putExtra(str2, z);
            aw.ZK();
            intent.putExtra("is_sns_notify_open", bo.a((Boolean) com.tencent.mm.model.c.Ry().get(68384, null), true));
            intent.putExtra("sns_unread_count", n.qFz.baS());
            if (!bo.isNullOrNil(this.yhd)) {
                aw.ZK();
                intent.putExtra("new_feed_id", bo.bc((String) com.tencent.mm.model.c.Ry().get(68418, null), ""));
                aw.ZK();
                com.tencent.mm.plugin.sns.i.f.k(3, (String) com.tencent.mm.model.c.Ry().get(68418, (Object) ""), this.yhe);
            }
            bVar.b(intent, "enter_log");
            ib ibVar = new ib();
            com.tencent.mm.sdk.b.a.xxA.m(ibVar);
            z = true;
            if (!ibVar.cDa.isResume) {
                if (!bo.isNullOrNil(this.yhd)) {
                    z = false;
                }
                if (n.qFz != null) {
                    this.yhe = n.qFz.baS();
                    if (this.yhe > 0) {
                        z = false;
                    }
                }
                aw.ZK();
                com.tencent.mm.model.c.Ry().set(68377, (Object) "");
            }
            aw.ZK();
            com.tencent.mm.model.c.Ry().set(589825, Boolean.FALSE);
            intent.putExtra("sns_resume_state", z);
            com.tencent.mm.bp.d.b(getContext(), "sns", ".ui.SnsTimeLineUI", intent);
            com.tencent.mm.plugin.report.service.h.pYm.X(10958, "1");
            new ak().postDelayed(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(29220);
                    com.tencent.mm.cj.c.aNX();
                    AppMethodBeat.o(29220);
                }
            }, 500);
            AppMethodBeat.o(29261);
            return true;
        } else if ("find_friends_by_near".equals(preference.mKey)) {
            if (!com.tencent.mm.au.b.sO((String) g.RP().Ry().get(274436, null))) {
                ab.i("MicroMsg.FindMoreFriendsUI", "summerper checkPermission checkLocation[%b]", Boolean.valueOf(com.tencent.mm.pluginsdk.permission.b.a(thisActivity(), "android.permission.ACCESS_COARSE_LOCATION", 66, null, null)));
                if (!com.tencent.mm.pluginsdk.permission.b.a(thisActivity(), "android.permission.ACCESS_COARSE_LOCATION", 66, null, null)) {
                    AppMethodBeat.o(29261);
                    return true;
                }
            } else if (!com.tencent.mm.pluginsdk.permission.b.o(thisActivity(), "android.permission.ACCESS_COARSE_LOCATION")) {
                if (((Boolean) g.RP().Ry().get(com.tencent.mm.storage.ac.a.USERINFO_GDPR_LOCATION_PERMISSION_DESCRIBE_CONFIRM_BOOLEAN_SYNC, Boolean.FALSE)).booleanValue()) {
                    com.tencent.mm.pluginsdk.permission.b.b(getActivity(), "android.permission.ACCESS_COARSE_LOCATION", 66);
                } else {
                    com.tencent.mm.plugin.account.a.b.a.b(thisActivity(), getString(R.string.g7p, aa.dor()), 30764, true);
                }
                AppMethodBeat.o(29261);
                return true;
            }
            dwU();
            AppMethodBeat.o(29261);
            return true;
        } else if ("find_friends_by_shake".equals(preference.mKey)) {
            Boolean bool;
            if (!this.yhk && com.tencent.mm.model.r.Zf().booleanValue()) {
                iconPreference = (IconPreference) fVar.aqO("find_friends_by_shake");
                if (iconPreference != null) {
                    iconPreference.NN(8);
                    aw.ZK();
                    com.tencent.mm.model.c.Ry().set(340231, Boolean.TRUE);
                    aw.ZK();
                    com.tencent.mm.model.c.Ry().dsb();
                    com.tencent.mm.plugin.report.service.h.pYm.a(232, 4, 1, false);
                }
            }
            com.tencent.mm.plugin.report.service.h.pYm.X(10958, TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL);
            aw.ZK();
            bc = bo.bc((String) com.tencent.mm.model.c.Ry().get(com.tencent.mm.storage.ac.a.USERINFO_IBEACON_PUSH_BEACONINFO_STRING, null), "");
            aw.ZK();
            if (!bo.a((Boolean) com.tencent.mm.model.c.Ry().get(com.tencent.mm.storage.ac.a.USERINFO_IBEACON_PUSH_IS_OPEN_BOOLEAN, null), false) || bc == null || bc.equals("")) {
                bool = Boolean.FALSE;
            } else {
                bool = Boolean.TRUE;
            }
            if (bool.booleanValue()) {
                com.tencent.mm.plugin.report.service.h.pYm.e(12653, Integer.valueOf(2), Integer.valueOf(2));
            }
            com.tencent.mm.sdk.b.a.xxA.m(new oh());
            com.tencent.mm.bp.d.H(getContext(), "shake", ".ui.ShakeReportUI");
            AppMethodBeat.o(29261);
            return true;
        } else if ("find_friends_by_qrcode".equals(preference.mKey)) {
            com.tencent.mm.x.c.PK().c(com.tencent.mm.storage.ac.a.NEW_BANDAGE_DATASOURCE_TRANSLATION_RED_DOT_STRING_SYNC, com.tencent.mm.storage.ac.a.NEW_BANDAGE_WATCHER_SCAN_ENTRY_RED_DOT_STRING_SYNC);
            if (!com.tencent.mm.r.a.bI(getContext())) {
                getContext();
                if (!e.akI()) {
                    com.tencent.mm.plugin.report.service.h.pYm.X(10958, "2");
                    intent2 = new Intent();
                    intent2.putExtra("BaseScanUI_qrcode_right_btn_direct_album", true);
                    com.tencent.mm.plugin.report.service.h.pYm.e(11265, Integer.valueOf(2));
                    com.tencent.mm.bp.d.b(getContext(), "scanner", ".ui.BaseScanUI", intent2);
                    AppMethodBeat.o(29261);
                    return true;
                }
            }
            AppMethodBeat.o(29261);
            return true;
        } else if (preference.mKey.equals("more_tab_game_recommend")) {
            com.tencent.mm.plugin.report.service.h.pYm.X(10958, "6");
            com.tencent.mm.plugin.report.service.h.pYm.a(848, 2, 1, false);
            aw.ZK();
            if (com.tencent.mm.model.c.isSDCardAvailable()) {
                intent = new Intent();
                intent.putExtra("from_find_more_friend", this.yhm);
                intent.putExtra("game_report_from_scene", 901);
                if (this.yhm) {
                    mz mzVar = new mz();
                    com.tencent.mm.sdk.b.a.xxA.m(mzVar);
                    iconPreference = (IconPreference) fVar.aqO("more_tab_game_recommend");
                    if (!(mzVar.cIX.cIY == null || iconPreference == null)) {
                        com.tencent.mm.at.o.ahp().b(mzVar.cIX.cIY, iconPreference.dAz());
                    }
                }
                ab.i("MicroMsg.FindMoreFriendsUI", "start game center index, time : " + System.currentTimeMillis());
                intent.putExtra("start_time", System.currentTimeMillis());
                com.tencent.mm.bp.d.b(getContext(), "game", ".ui.GameCenterUI", intent);
                AppMethodBeat.o(29261);
                return true;
            }
            t.hO(getContext());
            AppMethodBeat.o(29261);
            return true;
        } else if ("find_friends_by_micromsg".equals(preference.mKey)) {
            com.tencent.mm.bp.d.b(getContext(), "subapp", ".ui.pluginapp.ContactSearchUI", new Intent());
            AppMethodBeat.o(29261);
            return true;
        } else if ("find_friends_by_mobile".equals(preference.mKey)) {
            if (l.apS() != com.tencent.mm.plugin.account.friend.a.l.a.SUCC) {
                intent2 = new Intent(getContext(), BindMContactIntroUI.class);
                intent2.putExtra("key_upload_scene", 6);
                MMWizardActivity.J(getContext(), intent2);
                AppMethodBeat.o(29261);
                return true;
            }
            startActivity(new Intent(getContext(), MobileFriendUI.class));
            AppMethodBeat.o(29261);
            return true;
        } else if ("find_friends_by_facebook".equals(preference.mKey)) {
            startActivity(new Intent(getContext(), FacebookFriendUI.class));
            AppMethodBeat.o(29261);
            return true;
        } else if ("settings_mm_card_package".equals(preference.mKey)) {
            ab.i("MicroMsg.FindMoreFriendsUI", "enter to cardhome");
            ik ikVar = new ik();
            ikVar.cDz.context = getContext();
            com.tencent.mm.sdk.b.a.xxA.m(ikVar);
            AppMethodBeat.o(29261);
            return true;
        } else if (preference.mKey.equals("jd_market_entrance")) {
            Object obj = null;
            i.Lt(9);
            f.b bVar2 = f.vdy;
            if (bVar2 != null) {
                obj = f.vdy.cDA();
                com.tencent.mm.plugin.report.service.h.pYm.e(11179, obj, bVar2.cDB().cDm(), Integer.valueOf(dwT()));
                bVar2.cDv();
                bVar2.cDu();
                ((IconPreference) preference).ey("", -1);
                if (!bo.isNullOrNil(obj)) {
                    intent = new Intent();
                    intent.putExtra("rawUrl", obj);
                    intent.putExtra("useJs", true);
                    intent.putExtra("vertical_scroll", true);
                    intent.putExtra("minimize_secene", 1);
                    intent.putExtra("KPublisherId", "jd_store");
                    com.tencent.mm.bp.d.b(getContext(), "webview", ".ui.tools.WebViewUI", intent);
                }
            }
            ab.i("MicroMsg.FindMoreFriendsUI", "jump to url: ".concat(String.valueOf(obj)));
            AppMethodBeat.o(29261);
            return true;
        } else if ("ip_call_entrance".equals(preference.mKey)) {
            iconPreference = (IconPreference) fVar.aqO("ip_call_entrance");
            iconPreference.NN(8);
            iconPreference.NM(8);
            iconPreference.qh(false);
            iconPreference.NQ(8);
            Object obj2 = null;
            aw.ZK();
            str = (String) com.tencent.mm.model.c.Ry().get(com.tencent.mm.storage.ac.a.USERFINO_IPCALL_HAS_ENTRY_FIND_WORDING_STRING, (Object) "");
            aw.ZK();
            if (((Boolean) com.tencent.mm.model.c.Ry().get(com.tencent.mm.storage.ac.a.USERFINO_IPCALL_HAS_ENTRY_FIND_REDDOT_NEWXML_BOOLEAN, Boolean.FALSE)).booleanValue()) {
                com.tencent.mm.plugin.ipcall.a.e.i.Z(1, -1, -1);
                aw.ZK();
                com.tencent.mm.model.c.Ry().set(com.tencent.mm.storage.ac.a.USERFINO_IPCALL_HAS_ENTRY_FIND_REDDOT_NEWXML_BOOLEAN, Boolean.FALSE);
                obj2 = 1;
            }
            aw.ZK();
            if (((Integer) com.tencent.mm.model.c.Ry().get(com.tencent.mm.storage.ac.a.USERFINO_IPCALL_HAS_ENTRY_FIND_REDDOT_INT, Integer.valueOf(0))).intValue() < com.tencent.mm.m.g.Nu().getInt("WCOEntranceRedDot", 0)) {
                obj2 = 1;
                com.tencent.mm.plugin.report.service.h.pYm.e(13254, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(-1), Integer.valueOf(-1), Integer.valueOf(-1));
                aw.ZK();
                com.tencent.mm.model.c.Ry().set(com.tencent.mm.storage.ac.a.USERFINO_IPCALL_HAS_ENTRY_FIND_REDDOT_INT, Integer.valueOf(com.tencent.mm.m.g.Nu().getInt("WCOEntranceRedDot", 0)));
            }
            if (!bo.isNullOrNil(str)) {
                aw.ZK();
                com.tencent.mm.model.c.Ry().set(com.tencent.mm.storage.ac.a.USERFINO_IPCALL_HAS_ENTRY_FIND_WORDING_STRING, (Object) "");
            }
            if (obj2 != null) {
                com.tencent.mm.sdk.b.a.xxA.m(new to());
            }
            if (com.tencent.mm.r.a.Oo()) {
                com.tencent.mm.ui.base.h.a(getContext(), (int) R.string.d2o, 0, null, null);
            } else {
                com.tencent.mm.plugin.report.service.h.pYm.e(12061, Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0));
                com.tencent.mm.bp.d.b(getContext(), "ipcall", ".ui.IPCallAddressUI", new Intent());
            }
            AppMethodBeat.o(29261);
            return true;
        } else if ("app_brand_entrance".equals(preference.mKey)) {
            ((com.tencent.mm.plugin.appbrand.service.g) g.K(com.tencent.mm.plugin.appbrand.service.g.class)).b(getContext(), 1, false);
            AppMethodBeat.o(29261);
            return true;
        } else if ("find_friends_by_search".equals(preference.mKey)) {
            if (com.tencent.mm.plugin.websearch.api.aa.HU(0)) {
                optString = ac.adL("discoverSearchEntry").optString("wording");
                if (bo.isNullOrNil(optString)) {
                    ab.e("MicroMsg.FindMoreFriendsUI", "empty title");
                } else {
                    am cVt = am.cVt();
                    cVt.uaS = new com.tencent.mm.plugin.websearch.api.am.a();
                    cVt.save();
                    ((com.tencent.mm.plugin.welab.a.a.a) g.K(com.tencent.mm.plugin.welab.a.a.a.class)).open("labs1de6f3");
                    an.l("", 0, 0, 20);
                    String HP = com.tencent.mm.plugin.websearch.api.aa.HP(20);
                    str = com.tencent.mm.plugin.webview.modeltools.g.cYC().cWl();
                    HashMap hashMap = new HashMap();
                    hashMap.put("sessionId", HP);
                    hashMap.put("inputMarginTop", "32");
                    hashMap.put("inputMarginLeftRight", "24");
                    hashMap.put("inputHeight", "48");
                    if (!(str == null || str.isEmpty())) {
                        hashMap.put("educationTab", Uri.encode(str));
                    }
                    hashMap.put("clickType", "15");
                    ((j) g.K(j.class)).b(getContext(), 20, "", HP, hashMap, optString);
                    ((com.tencent.mm.plugin.boots.a.c) g.K(com.tencent.mm.plugin.boots.a.c.class)).rT(com.tencent.mm.plugin.boots.a.b.jJt);
                }
            } else {
                ab.e("MicroMsg.FindMoreFriendsUI", "fts h5 template not avail");
            }
            AppMethodBeat.o(29261);
            return true;
        } else if ("find_friends_by_look".equals(preference.mKey)) {
            if (com.tencent.mm.plugin.websearch.api.aa.HU(1)) {
                bc = ac.adL("discoverRecommendEntry").optString("wording");
                if (bo.isNullOrNil(bc)) {
                    ab.e("MicroMsg.FindMoreFriendsUI", "empty query");
                } else {
                    ab.i("MicroMsg.FindMoreFriendsUI", "look one look clikced");
                    com.tencent.mm.plugin.topstory.ui.c.W(getContext(), 21);
                    ((com.tencent.mm.plugin.welab.a.a.a) g.K(com.tencent.mm.plugin.welab.a.a.a.class)).open("labs_browse");
                    ll llVar = new ll();
                    llVar.cHk.scene = 0;
                    com.tencent.mm.sdk.b.a.xxA.m(llVar);
                    an.bz(21, bc);
                    an.reportIdKey649ForLook(21, 0);
                    if (com.tencent.mm.plugin.websearch.api.aa.HV(1) > com.tencent.mm.plugin.websearch.api.aa.HT(1)) {
                        an.reportIdKey649ForLook(21, 15);
                    } else {
                        an.reportIdKey649ForLook(21, 14);
                    }
                }
            } else {
                ab.e("MicroMsg.FindMoreFriendsUI", "fts h5 template not avail");
            }
            AppMethodBeat.o(29261);
            return true;
        } else if ("my_life_around".equals(preference.mKey)) {
            com.tencent.mm.plugin.report.service.h.pYm.e(17065, Integer.valueOf(1), Long.valueOf(bo.anT()), Integer.valueOf(this.yhx.ordinal()), g.RP().Ry().get(com.tencent.mm.storage.ac.a.MY_LIFE_AROUND_APP_RED_DOT_IMG_URL_STRING, (Object) ""), g.RP().Ry().get(com.tencent.mm.storage.ac.a.MY_LIFE_AROUND_APP_RED_DOT_TEXT_STRING, (Object) ""), g.RP().Ry().get(com.tencent.mm.storage.ac.a.MY_LIFE_AROUND_APP_RED_DOT_TYPE_STRING, AppEventsConstants.EVENT_PARAM_VALUE_NO));
            if (this.yhx.equals(a.TYPE_NEW_HINT)) {
                g.RP().Ry().set(com.tencent.mm.storage.ac.a.MY_LIFE_AROUND_APP_NEW_RED_DOT_TAG_BOOLEAN, Boolean.FALSE);
                this.yhx = a.TYPE_NONE;
                iconPreference = (IconPreference) this.yhb.aqO("my_life_around");
                iconPreference.NL(8);
                iconPreference.ey("", -1);
            }
            boolean booleanValue = ((Boolean) g.RP().Ry().get(com.tencent.mm.storage.ac.a.MY_LIFE_AROUND_APP_RED_DOT_TAG_BOOLEAN, Boolean.FALSE)).booleanValue();
            ((com.tencent.mm.plugin.welab.a.a.a) g.K(com.tencent.mm.plugin.welab.a.a.a.class)).open("labs_nearbylife");
            String agP = ((com.tencent.mm.plugin.welab.a.a.a) g.K(com.tencent.mm.plugin.welab.a.a.a.class)).agP("labs_nearbylife");
            int agQ = ((com.tencent.mm.plugin.welab.a.a.a) g.K(com.tencent.mm.plugin.welab.a.a.a.class)).agQ("labs_nearbylife");
            AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
            appBrandStatObject.scene = FaceManager.FACE_ACQUIRED_BRIGHT;
            optString = null;
            ab.d("MicroMsg.FindMoreFriendsUI", "withRedTag: %d.", Integer.valueOf(com.tencent.mm.m.g.Nu().getInt("LifeAppEntranceBringRedDot", 0)));
            if (com.tencent.mm.m.g.Nu().getInt("LifeAppEntranceBringRedDot", 0) != 0 && booleanValue) {
                optString = "?hasRedDot=true";
            }
            ((com.tencent.mm.plugin.appbrand.service.e) g.K(com.tencent.mm.plugin.appbrand.service.e.class)).a(getContext(), agP, null, agQ, 0, optString, appBrandStatObject);
            AppMethodBeat.o(29261);
            return true;
        } else {
            AppMethodBeat.o(29261);
            return false;
        }
    }

    public final void dwU() {
        AppMethodBeat.i(29262);
        com.tencent.mm.plugin.report.service.h.pYm.X(10958, "4");
        aw.ZK();
        if (bo.e((Boolean) com.tencent.mm.model.c.Ry().get(4103, null))) {
            bp aap = bp.aap();
            if (aap == null) {
                com.tencent.mm.bp.d.H(getContext(), "nearby", ".ui.NearbyPersonalInfoUI");
                AppMethodBeat.o(29262);
                return;
            }
            String nullAsNil = bo.nullAsNil(aap.getProvince());
            int a = bo.a(Integer.valueOf(aap.dtS), 0);
            if (bo.isNullOrNil(nullAsNil) || a == 0) {
                com.tencent.mm.bp.d.H(getContext(), "nearby", ".ui.NearbyPersonalInfoUI");
                AppMethodBeat.o(29262);
                return;
            }
            aw.ZK();
            Boolean bool = (Boolean) com.tencent.mm.model.c.Ry().get(4104, null);
            if (bool == null || !bool.booleanValue()) {
                LauncherUI launcherUI = (LauncherUI) getContext();
                if (launcherUI != null) {
                    launcherUI.yjJ.getMainTabUI().aqG("tab_find_friend");
                }
                com.tencent.mm.bn.a.fy(getContext());
                AppMethodBeat.o(29262);
                return;
            }
            dwV();
            AppMethodBeat.o(29262);
            return;
        }
        com.tencent.mm.bp.d.H(getContext(), "nearby", ".ui.NearbyFriendsIntroUI");
        AppMethodBeat.o(29262);
    }

    private void dwV() {
        AppMethodBeat.i(29263);
        if (this.yhc == null) {
            this.yhc = View.inflate(getContext(), R.layout.a9s, null);
            this.oPS = (CheckBox) this.yhc.findViewById(R.id.cp8);
            this.oPS.setChecked(false);
        }
        if (this.oPU == null) {
            this.oPU = com.tencent.mm.ui.base.h.a(getContext(), getString(R.string.tz), this.yhc, new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(29221);
                    if (FindMoreFriendsUI.this.oPS != null) {
                        aw.ZK();
                        com.tencent.mm.model.c.Ry().set(4104, Boolean.valueOf(!FindMoreFriendsUI.this.oPS.isChecked()));
                    }
                    LauncherUI launcherUI = (LauncherUI) FindMoreFriendsUI.this.getContext();
                    if (launcherUI != null) {
                        launcherUI.yjJ.getMainTabUI().aqG("tab_find_friend");
                    }
                    com.tencent.mm.bn.a.fy(FindMoreFriendsUI.this.getContext());
                    AppMethodBeat.o(29221);
                }
            }, null);
            AppMethodBeat.o(29263);
            return;
        }
        this.oPU.show();
        AppMethodBeat.o(29263);
    }

    private void dwW() {
        AppMethodBeat.i(29264);
        if (((IconPreference) this.yhb.aqO("more_tab_game_recommend")) == null) {
            AppMethodBeat.o(29264);
            return;
        }
        com.tencent.mm.sdk.g.d.post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(29225);
                final mz mzVar = new mz();
                com.tencent.mm.sdk.b.a.xxA.m(mzVar);
                al.d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(29224);
                        FindMoreFriendsUI.a(FindMoreFriendsUI.this, mzVar);
                        AppMethodBeat.o(29224);
                    }
                });
                AppMethodBeat.o(29225);
            }
        }, "updateGame");
        AppMethodBeat.o(29264);
    }

    private synchronized void a(mz mzVar, IconPreference iconPreference, mz mzVar2, String str) {
        AppMethodBeat.i(29265);
        String str2 = mzVar.cIX.cIY;
        int i = mzVar.cIX.cIZ;
        int i2 = mzVar.cIX.cJa;
        if (bo.isNullOrNil(str2) || iconPreference == null || iconPreference.dAz() == null) {
            AppMethodBeat.o(29265);
        } else {
            ab.i("MicroMsg.FindMoreFriendsUI", "download entrance image : %s, width: %d, height: %d", str2, Integer.valueOf(i), Integer.valueOf(i2));
            if (i > 0 && i2 > 0) {
                iconPreference.hn(com.tencent.mm.bz.a.fromDPToPix(ah.getContext(), i), com.tencent.mm.bz.a.fromDPToPix(ah.getContext(), i));
            }
            final String str3 = mzVar2.cIX.cJb;
            final String str4 = mzVar2.cIX.appId;
            final int i3 = mzVar2.cIX.msgType;
            final String str5 = mzVar2.cIX.ctu;
            final int i4 = mzVar2.cIX.showType;
            final gz gzVar = new gz();
            gzVar.cBH.Cn = 1;
            gzVar.cBH.url = str2;
            com.tencent.mm.sdk.b.a.xxA.m(gzVar);
            if (gzVar.cBI.cBK) {
                String str6 = gzVar.cBI.cBJ + com.tencent.mm.a.g.x(str2.getBytes());
                com.tencent.mm.at.a.a.c.a aVar = new com.tencent.mm.at.a.a.c.a();
                aVar.ePH = true;
                aVar.ePJ = str6;
                com.tencent.mm.at.a.a.c ahG = aVar.ahG();
                final IconPreference iconPreference2 = iconPreference;
                final String str7 = str;
                com.tencent.mm.at.o.ahp().a(str2, iconPreference.dAz(), ahG, new com.tencent.mm.at.a.c.i() {
                    public final void a(String str, View view, Bitmap bitmap, Object... objArr) {
                        AppMethodBeat.i(29226);
                        gzVar.cBH.Cn = 2;
                        gzVar.cBH.url = str;
                        com.tencent.mm.sdk.b.a.xxA.m(gzVar);
                        AppMethodBeat.o(29226);
                    }
                }, new com.tencent.mm.at.a.c.g() {
                    public final void sH(String str) {
                        AppMethodBeat.i(29230);
                        al.d(new Runnable() {
                            public final void run() {
                                AppMethodBeat.i(29227);
                                FindMoreFriendsUI.this.yhm = false;
                                FindMoreFriendsUI.b((IconPreference) FindMoreFriendsUI.this.yhb.aqO("more_tab_game_recommend"), 8, 8, false, 8, 8, 8);
                                AppMethodBeat.o(29227);
                            }
                        });
                        AppMethodBeat.o(29230);
                    }

                    public final Bitmap a(String str, View view, com.tencent.mm.at.a.d.b bVar) {
                        return null;
                    }

                    public final void b(String str, View view, com.tencent.mm.at.a.d.b bVar) {
                        AppMethodBeat.i(29231);
                        gzVar.cBH.Cn = 2;
                        gzVar.cBH.url = str;
                        com.tencent.mm.sdk.b.a.xxA.m(gzVar);
                        if (bVar == null) {
                            AppMethodBeat.o(29231);
                            return;
                        }
                        final int i = bVar.from;
                        if (bVar.status != 0 || bVar.bitmap == null) {
                            al.d(new Runnable() {
                                public final void run() {
                                    AppMethodBeat.i(29229);
                                    FindMoreFriendsUI.this.yhm = true;
                                    IconPreference iconPreference = (IconPreference) FindMoreFriendsUI.this.yhb.aqO("more_tab_game_recommend");
                                    if (i4 == 3) {
                                        iconPreference.ey(FindMoreFriendsUI.this.getString(R.string.s0), R.drawable.w3);
                                        FindMoreFriendsUI.b(iconPreference, 0, 8, false, 8, 8, 8);
                                        FindMoreFriendsUI.c(str4, i3, str3, str5, 1);
                                    } else if (i4 == 4) {
                                        iconPreference.av(str7, -1, Color.parseColor("#8c8c8c"));
                                        FindMoreFriendsUI.b(iconPreference, 8, 0, true, 8, 8, 8);
                                        FindMoreFriendsUI.c(str4, i3, str3, str5, 2);
                                    }
                                    com.tencent.mm.plugin.report.service.h.pYm.a(858, 12, 1, false);
                                    if (i == 2) {
                                        com.tencent.mm.plugin.report.service.h.pYm.a(858, 14, 1, false);
                                    }
                                    AppMethodBeat.o(29229);
                                }
                            });
                            AppMethodBeat.o(29231);
                            return;
                        }
                        final Bitmap bitmap = bVar.bitmap;
                        al.d(new Runnable() {
                            public final void run() {
                                AppMethodBeat.i(29228);
                                FindMoreFriendsUI.this.yhm = true;
                                iconPreference2.ap(bitmap);
                                if (i4 == 3) {
                                    FindMoreFriendsUI.b(iconPreference2, 8, 8, false, 0, 0, 0);
                                } else if (i4 == 4) {
                                    FindMoreFriendsUI.b(iconPreference2, 8, 0, false, 0, 0, 0);
                                }
                                FindMoreFriendsUI.c(str4, i3, str3, str5, i4);
                                if (i == 2) {
                                    com.tencent.mm.plugin.report.service.h.pYm.a(858, 13, 1, false);
                                }
                                AppMethodBeat.o(29228);
                            }
                        });
                        AppMethodBeat.o(29231);
                    }
                });
            }
            AppMethodBeat.o(29265);
        }
    }

    private static void b(String str, int i, String str2, String str3, int i2) {
        AppMethodBeat.i(29266);
        g.RQ();
        String str4 = (String) g.RP().Ry().get(com.tencent.mm.storage.ac.a.GAME_FIND_MORE_FRIEND_MSG_ID_STRING_SYNC, (Object) "");
        if (!(str2 == null || str2.equals(str4))) {
            g.RQ();
            g.RP().Ry().set(com.tencent.mm.storage.ac.a.GAME_FIND_MORE_FRIEND_MSG_ID_STRING_SYNC, (Object) str2);
            oj ojVar = new oj();
            ojVar.cKF.scene = 9;
            ojVar.cKF.cKG = 901;
            ojVar.cKF.action = 1;
            ojVar.cKF.appId = str;
            ojVar.cKF.msgType = i;
            ojVar.cKF.cJb = str2;
            ojVar.cKF.ctu = str3;
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("function_type", "resource");
                jSONObject.put("function_value", String.valueOf(i2));
            } catch (JSONException e) {
                ab.e("MicroMsg.FindMoreFriendsUI", e.getMessage());
            }
            try {
                str4 = URLEncoder.encode(jSONObject.toString(), ProtocolPackage.ServerEncoding);
            } catch (UnsupportedEncodingException e2) {
                UnsupportedEncodingException unsupportedEncodingException = e2;
                str4 = "";
                ab.e("MicroMsg.FindMoreFriendsUI", unsupportedEncodingException.getMessage());
            }
            ojVar.cKF.cKH = str4;
            com.tencent.mm.sdk.b.a.xxA.m(ojVar);
            com.tencent.mm.plugin.report.service.h.pYm.a(858, 2, 1, false);
        }
        AppMethodBeat.o(29266);
    }

    private static void pE(boolean z) {
        AppMethodBeat.i(29267);
        com.tencent.mm.plugin.game.a.a.a.bDb().hH(z);
        AppMethodBeat.o(29267);
    }

    private String ik(String str, String str2) {
        AppMethodBeat.i(29268);
        if (bo.isNullOrNil(str)) {
            str = com.tencent.mm.pluginsdk.model.app.g.t(getContext(), str2);
            AppMethodBeat.o(29268);
            return str;
        }
        AppMethodBeat.o(29268);
        return str;
    }

    private static void a(IconPreference iconPreference, int i, int i2, int i3, boolean z, int i4, int i5, int i6) {
        AppMethodBeat.i(29269);
        iconPreference.NL(i);
        iconPreference.NN(i2);
        iconPreference.NM(i3);
        iconPreference.qh(z);
        iconPreference.NQ(i4);
        iconPreference.NP(i5);
        iconPreference.NR(i6);
        AppMethodBeat.o(29269);
    }

    public final void Zx() {
        AppMethodBeat.i(29270);
        if ((com.tencent.mm.model.r.YK() & 32768) != 0) {
            AppMethodBeat.o(29270);
            return;
        }
        this.yhe++;
        dwX();
        this.yhb.notifyDataSetChanged();
        AppMethodBeat.o(29270);
    }

    public final void Zy() {
        AppMethodBeat.i(29271);
        if ((com.tencent.mm.model.r.YK() & 32768) != 0) {
            AppMethodBeat.o(29271);
            return;
        }
        dwX();
        this.yhb.notifyDataSetChanged();
        AppMethodBeat.o(29271);
    }

    public final void Zz() {
    }

    public final void ZB() {
        AppMethodBeat.i(29272);
        if (this.yhb == null) {
            AppMethodBeat.o(29272);
            return;
        }
        this.status = com.tencent.mm.model.r.YD();
        aMk();
        AppMethodBeat.o(29272);
    }

    /* Access modifiers changed, original: protected|final */
    public final void dvY() {
        AppMethodBeat.i(29273);
        ab.i("MicroMsg.FindMoreFriendsUI", "on tab create");
        this.yhb = this.yCw;
        this.status = com.tencent.mm.model.r.YD();
        this.qnE = com.tencent.mm.model.r.YK();
        this.kFU = com.tencent.mm.model.r.YE();
        final View findViewById = getView().getRootView().findViewById(R.id.bq);
        int de = ak.de(getContext());
        int J = ak.J(getContext(), -1);
        AnonymousClass5 anonymousClass5 = new Runnable() {
            int eRu = 0;

            public final void run() {
                AppMethodBeat.i(29211);
                if (FindMoreFriendsUI.this.getView() == null) {
                    AppMethodBeat.o(29211);
                    return;
                }
                int de = ak.de(FindMoreFriendsUI.this.getContext());
                int J = ak.J(FindMoreFriendsUI.this.getContext(), -1);
                if (J <= 0) {
                    if (this.eRu < 2) {
                        ab.i("MicroMsg.FindMoreFriendsUI", "[trySetParentViewPadding] try getStatusHeight again!");
                        FindMoreFriendsUI.this.getView().post(this);
                    } else {
                        ab.e("MicroMsg.FindMoreFriendsUI", "[trySetParentViewPadding] try getStatusHeight finally!");
                    }
                    this.eRu++;
                } else {
                    int i = de + J;
                    if (i != FindMoreFriendsUI.this.getView().getPaddingTop()) {
                        ab.i("MicroMsg.FindMoreFriendsUI", "[trySetParentViewPadding] now:%s old:%s", Integer.valueOf(i), Integer.valueOf(FindMoreFriendsUI.this.getView().getPaddingTop()));
                        FindMoreFriendsUI.this.getView().setPadding(0, i, 0, findViewById.getHeight());
                    } else {
                        ab.i("MicroMsg.FindMoreFriendsUI", "[trySetParentViewPadding] has try more once! it's right! actionBarHeight:%s actionBarHeight:%s", Integer.valueOf(J), Integer.valueOf(de));
                    }
                }
                ab.i("MicroMsg.FindMoreFriendsUI", "[trySetParentViewPadding] tryCount:%s actionBarHeight:%s actionBarHeight:%s", Integer.valueOf(this.eRu), Integer.valueOf(J), Integer.valueOf(de));
                AppMethodBeat.o(29211);
            }
        };
        if (J <= 0) {
            getView().post(anonymousClass5);
        } else {
            getView().setPadding(0, de + J, 0, findViewById.getHeight());
            ab.i("MicroMsg.FindMoreFriendsUI", "[trySetParentViewPadding] actionBarHeight:%s actionBarHeight:%s", Integer.valueOf(J), Integer.valueOf(de));
            getView().postDelayed(anonymousClass5, 100);
        }
        ab.i("MicroMsg.FindMoreFriendsUI", "on tab create end");
        AppMethodBeat.o(29273);
    }

    /* Access modifiers changed, original: protected|final */
    public final void dvZ() {
        AppMethodBeat.i(29274);
        ab.i("MicroMsg.FindMoreFriendsUI", "on tab resume");
        this.cCt = true;
        dxb();
        com.tencent.mm.pluginsdk.c.a.a(jb.class.getName(), this.vqt);
        com.tencent.mm.pluginsdk.c.a.a(gy.class.getName(), this.yht);
        com.tencent.mm.pluginsdk.c.a.a(qm.class.getName(), this.yhu);
        com.tencent.mm.sdk.b.a.xxA.c(this.yhr);
        com.tencent.mm.sdk.b.a.xxA.c(this.yhq);
        com.tencent.mm.sdk.b.a.xxA.c(this.yhs);
        com.tencent.mm.sdk.b.a.xxA.c(this.qLL);
        com.tencent.mm.sdk.b.a.xxA.c(this.yhv);
        com.tencent.mm.sdk.b.a.xxA.b(this.mJI);
        com.tencent.mm.sdk.b.a.xxA.c(this.yhz);
        com.tencent.mm.bi.d.akR().c(this);
        aw.ZK();
        com.tencent.mm.model.c.XR().a(this);
        aw.ZK();
        com.tencent.mm.model.c.a(this);
        aw.ZK();
        com.tencent.mm.model.c.Ry().a(this);
        if (n.qFB != null) {
            n.qFB.a(this);
        }
        final View findViewById = findViewById(R.id.ev4);
        if (!(findViewById == null || findViewById.getVisibility() == 8)) {
            new ak(Looper.getMainLooper()).post(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(29232);
                    findViewById.setVisibility(8);
                    findViewById.startAnimation(AnimationUtils.loadAnimation(FindMoreFriendsUI.this.getContext(), R.anim.b6));
                    AppMethodBeat.o(29232);
                }
            });
        }
        if (isAdded()) {
            com.tencent.mm.blink.b.HQ().o(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(29233);
                    ab.i("MicroMsg.FindMoreFriendsUI", "status %d (%d), extStatus %d (%d), pluginFlag %d (%d)", Integer.valueOf(FindMoreFriendsUI.this.status), Integer.valueOf(com.tencent.mm.model.r.YD()), Long.valueOf(FindMoreFriendsUI.this.kFU), Long.valueOf(com.tencent.mm.model.r.YE()), Integer.valueOf(FindMoreFriendsUI.this.qnE), Integer.valueOf(com.tencent.mm.model.r.YK()));
                    FindMoreFriendsUI.this.kFU = com.tencent.mm.model.r.YE();
                    FindMoreFriendsUI.this.status = com.tencent.mm.model.r.YD();
                    FindMoreFriendsUI.this.qnE = com.tencent.mm.model.r.YK();
                    FindMoreFriendsUI.y(FindMoreFriendsUI.this);
                    AppMethodBeat.o(29233);
                }
            });
        }
        ab.i("MicroMsg.FindMoreFriendsUI", "on tab resume end");
        AppMethodBeat.o(29274);
    }

    private boolean Cn(int i) {
        return (this.kFU & ((long) i)) != 0;
    }

    private void dwX() {
        AppMethodBeat.i(29275);
        boolean z = (this.qnE & 32768) == 0;
        ab.i("MicroMsg.FindMoreFriendsUI", "openSns %s, plugin installed %s", Boolean.valueOf(z), Boolean.valueOf(com.tencent.mm.bp.d.afj("sns")));
        if (!z) {
            if (g.RP().Ry().getInt(com.tencent.mm.storage.ac.a.USERINFO_SNS_ENTRY_SWITCH_INT, 0) == 1) {
                ab.w("MicroMsg.FindMoreFriendsUI", "opened sns entry recently");
                com.tencent.mm.plugin.report.service.h.pYm.k(150, 71, 1);
            } else if (g.RP().Ry().getInt(com.tencent.mm.storage.ac.a.USERINFO_SNS_ENTRY_SWITCH_INT, 0) == -1) {
                ab.i("MicroMsg.FindMoreFriendsUI", "closed sns entry recently");
                com.tencent.mm.plugin.report.service.h.pYm.k(150, 70, 1);
            }
        }
        if (z && r11) {
            this.yhn++;
            this.yhb.ce("album_dyna_photo_ui_title", false);
            FriendSnsPreference friendSnsPreference = (FriendSnsPreference) this.yhb.aqO("album_dyna_photo_ui_title");
            friendSnsPreference.drawable = com.tencent.mm.bz.a.g(getContext(), R.raw.icons_outlined_colorful_moment);
            aw.ZK();
            boolean e = bo.e((Boolean) com.tencent.mm.model.c.Ry().get(48, null));
            friendSnsPreference.NL(8);
            friendSnsPreference.NR(8);
            if (e) {
                friendSnsPreference.NL(0);
                friendSnsPreference.ey(getString(R.string.s0), R.drawable.w3);
            }
            aw.ZK();
            this.yhd = (String) com.tencent.mm.model.c.Ry().get(68377, null);
            if (!bo.isNullOrNil(this.yhd) && LauncherUI.dxE() == 2) {
                aw.ZK();
                if (com.tencent.mm.model.c.Ry().getInt(68419, 0) == 0) {
                    g.RQ();
                    com.tencent.mm.plugin.sns.i.f.k(2, (String) g.RP().Ry().get(68418, (Object) ""), this.yhe);
                    aw.ZK();
                    com.tencent.mm.model.c.Ry().set(68419, Integer.valueOf(1));
                }
            }
            Object obj = g.RP().Ry().get(com.tencent.mm.storage.ac.a.USERINFO_SNS_MEDIA_COLLAPSE_SNS_ID_LONG, null);
            long longValue = obj == null ? 0 : ((Long) obj).longValue();
            ab.i("MicroMsg.FindMoreFriendsUI", "newer snsobj %s", bo.bc(this.yhd, ""));
            friendSnsPreference.NQ(0);
            if (bo.isNullOrNil(this.yhd)) {
                aw.ZK();
                if (((Boolean) com.tencent.mm.model.c.Ry().get(589825, Boolean.FALSE)).booleanValue()) {
                    friendSnsPreference.NO(R.raw.net_warn_icon);
                    friendSnsPreference.NP(0);
                    friendSnsPreference.NR(8);
                } else if (longValue == 0 || !((m) g.K(m.class)).jM(longValue)) {
                    friendSnsPreference.NP(8);
                } else {
                    friendSnsPreference.NP(0);
                    friendSnsPreference.NR(0);
                    friendSnsPreference.mX(longValue);
                }
            } else {
                int i;
                friendSnsPreference.NP(0);
                aw.ZK();
                if (bo.a((Boolean) com.tencent.mm.model.c.Ry().get(68384, null), true)) {
                    i = 0;
                } else {
                    i = 8;
                }
                friendSnsPreference.NR(i);
                friendSnsPreference.aqD(this.yhd);
            }
            if (n.qFz != null) {
                this.yhe = n.qFz.baS();
            }
            if (this.yhe != 0) {
                friendSnsPreference.NL(0);
                friendSnsPreference.ey(this.yhe, r.ik(getContext()));
            }
            friendSnsPreference.NN(8);
            friendSnsPreference.NM(8);
            com.tencent.mm.sdk.b.a.xxA.m(new to());
            AppMethodBeat.o(29275);
            return;
        }
        this.yhb.ce("album_dyna_photo_ui_title", true);
        if (!dwR()) {
            com.tencent.mm.plugin.report.service.h.pYm.k(953, 0, 1);
        }
        AppMethodBeat.o(29275);
    }

    private void dwY() {
        AppMethodBeat.i(29276);
        ab.i("MicroMsg.FindMoreFriendsUI", "openShake %s, plugin installed %s", Boolean.valueOf((this.qnE & 256) == 0), Boolean.valueOf(com.tencent.mm.bp.d.afj("shake")));
        if (((this.qnE & 256) == 0) && r1) {
            boolean bY;
            this.yhn++;
            this.yhb.ce("find_friends_by_shake", false);
            IconPreference iconPreference = (IconPreference) this.yhb.aqO("find_friends_by_shake");
            int baS = com.tencent.mm.bi.d.akR().baS() + com.tencent.mm.pluginsdk.p.a.dgQ().cjL();
            if (baS > 0) {
                iconPreference.NL(0);
                iconPreference.ey(String.valueOf(baS), R.drawable.a4f);
            } else {
                iconPreference.NL(8);
                iconPreference.ey("", -1);
            }
            iconPreference.NP(8);
            com.tencent.mm.pluginsdk.p.a.dgQ().cjM();
            if (com.tencent.mm.pluginsdk.p.a.dgQ().cjN()) {
                bY = com.tencent.mm.x.c.PK().bY(262154, 266258);
            } else {
                bY = false;
            }
            if (bY) {
                aw.ZK();
                String str = (String) com.tencent.mm.model.c.Ry().get(com.tencent.mm.storage.ac.a.USERINFO_SHAKE_CARD_ENTRANCE_RED_DOT_TEXT_STRING_SYNC, (Object) "");
                if (!TextUtils.isEmpty(str)) {
                    iconPreference.NN(8);
                    iconPreference.NL(0);
                    iconPreference.ey(String.valueOf(str), R.drawable.a4f);
                } else if (baS > 0) {
                    iconPreference.NN(0);
                } else {
                    iconPreference.NN(0);
                    iconPreference.NL(8);
                    iconPreference.ey("", -1);
                }
            } else {
                iconPreference.NN(8);
            }
            aw.ZK();
            String bc = bo.bc((String) com.tencent.mm.model.c.Ry().get(com.tencent.mm.storage.ac.a.USERINFO_IBEACON_PUSH_BEACONINFO_STRING, null), "");
            aw.ZK();
            Boolean valueOf = Boolean.valueOf(bo.a((Boolean) com.tencent.mm.model.c.Ry().get(com.tencent.mm.storage.ac.a.USERINFO_IBEACON_PUSH_IS_OPEN_BOOLEAN, null), false));
            aw.ZK();
            int intValue = ((Integer) com.tencent.mm.model.c.Ry().get(com.tencent.mm.storage.ac.a.USERINFO_IBEACON_SHAKE_TAB_DISPLAY_INT, Integer.valueOf(0))).intValue();
            if (!valueOf.booleanValue() || bc == null || bc.equals("") || baS > 0 || bY) {
                iconPreference.NM(8);
            } else if (intValue == 0) {
                iconPreference.NN(8);
                iconPreference.NM(0);
                String[] split = bc.split(",");
                if (split.length > 0) {
                    iconPreference.av(split[0], -1, Color.parseColor("#8c8c8c"));
                }
                iconPreference.qh(true);
                iconPreference.NQ(8);
                AppMethodBeat.o(29276);
                return;
            } else if (intValue == 1) {
                iconPreference.NM(8);
                iconPreference.NL(0);
                iconPreference.yBX = true;
                AppMethodBeat.o(29276);
                return;
            }
            AppMethodBeat.o(29276);
            return;
        }
        this.yhb.ce("find_friends_by_shake", true);
        if (!dwR()) {
            com.tencent.mm.plugin.report.service.h.pYm.k(953, 2, 1);
        }
        AppMethodBeat.o(29276);
    }

    private void dwZ() {
        AppMethodBeat.i(138178);
        boolean Cn = Cn(2097152);
        boolean afj = com.tencent.mm.bp.d.afj(com.google.firebase.analytics.FirebaseAnalytics.a.SEARCH);
        String str = "MicroMsg.FindMoreFriendsUI";
        String str2 = "openSearch %s, plugin installed %s";
        Object[] objArr = new Object[2];
        objArr[0] = Boolean.valueOf(!Cn);
        objArr[1] = Boolean.valueOf(afj);
        ab.i(str, str2, objArr);
        if (Cn || !afj) {
            this.yhb.ce("find_friends_by_search", true);
            if (!dwR()) {
                com.tencent.mm.plugin.report.service.h.pYm.k(953, 4, 1);
            }
            AppMethodBeat.o(138178);
            return;
        }
        this.yhn++;
        this.yhb.ce("find_friends_by_search", false);
        try {
            JSONObject adL = ac.adL("discoverSearchEntry");
            String optString = adL.optString("wording");
            adL.optString("androidIcon");
            IconPreference iconPreference = (IconPreference) this.yhb.aqO("find_friends_by_search");
            if (bo.isNullOrNil(optString)) {
                iconPreference.setTitle((CharSequence) getString(R.string.bty));
            } else {
                iconPreference.setTitle((CharSequence) optString);
            }
            iconPreference.NL(8);
            a(am.cVt().uaS, iconPreference);
            com.tencent.mm.plugin.websearch.api.aa.cVe();
            AppMethodBeat.o(138178);
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.FindMoreFriendsUI", e, "update search entry exception!", new Object[0]);
            AppMethodBeat.o(138178);
        }
    }

    private void dxa() {
        AppMethodBeat.i(29277);
        ab.i("MicroMsg.FindMoreFriendsUI", "openNearby %s, plugin installed %s", Boolean.valueOf((this.qnE & 512) == 0), Boolean.valueOf(com.tencent.mm.bp.d.afj("nearby")));
        if (((this.qnE & 512) == 0) && r3) {
            this.yhn++;
            this.yhb.ce("find_friends_by_near", false);
            IconPreference iconPreference = (IconPreference) this.yhb.aqO("find_friends_by_near");
            if (iconPreference != null) {
                if (com.tencent.mm.app.plugin.b.Ci()) {
                    iconPreference.NP(8);
                } else {
                    iconPreference.NP(0);
                    iconPreference.NO(R.drawable.ais);
                    iconPreference.hn(-2, -2);
                }
                int baS = com.tencent.mm.bi.d.akQ().baS();
                if (com.tencent.mm.bn.a.dgL()) {
                    if (baS > 0) {
                        iconPreference.NN(0);
                        AppMethodBeat.o(29277);
                        return;
                    }
                    iconPreference.NN(8);
                    AppMethodBeat.o(29277);
                    return;
                } else if (baS > 0) {
                    iconPreference.NL(0);
                    iconPreference.ey(String.valueOf(baS), r.ik(getContext()));
                    AppMethodBeat.o(29277);
                    return;
                } else {
                    iconPreference.NL(8);
                    iconPreference.ey("", -1);
                }
            }
            AppMethodBeat.o(29277);
            return;
        }
        this.yhb.ce("find_friends_by_near", true);
        if (!dwR()) {
            com.tencent.mm.plugin.report.service.h.pYm.k(953, 5, 1);
        }
        AppMethodBeat.o(29277);
    }

    private void dxb() {
        AppMethodBeat.i(29278);
        pz pzVar = new pz();
        pzVar.cMo.cCt = this.cCt;
        com.tencent.mm.sdk.b.a.xxA.m(pzVar);
        AppMethodBeat.o(29278);
    }

    /* Access modifiers changed, original: protected|final */
    public final void dwa() {
        AppMethodBeat.i(29279);
        ab.i("MicroMsg.FindMoreFriendsUI", "on tab start");
        ((p) g.M(p.class)).getSysCmdMsgExtension().a("lifeappreddot", this.yhy);
        AppMethodBeat.o(29279);
    }

    /* Access modifiers changed, original: protected|final */
    public final void dwb() {
        AppMethodBeat.i(29280);
        ab.i("MicroMsg.FindMoreFriendsUI", "on tab pause");
        this.cCt = false;
        dxb();
        if (aw.RK()) {
            com.tencent.mm.pluginsdk.c.a.b(jb.class.getName(), this.vqt);
            com.tencent.mm.pluginsdk.c.a.b(gy.class.getName(), this.yht);
            com.tencent.mm.pluginsdk.c.a.b(qm.class.getName(), this.yhu);
            com.tencent.mm.sdk.b.a.xxA.d(this.yhr);
            com.tencent.mm.sdk.b.a.xxA.d(this.yhq);
            com.tencent.mm.sdk.b.a.xxA.d(this.yhs);
            com.tencent.mm.sdk.b.a.xxA.d(this.qLL);
            com.tencent.mm.sdk.b.a.xxA.d(this.yhv);
            com.tencent.mm.sdk.b.a.xxA.d(this.mJI);
            com.tencent.mm.sdk.b.a.xxA.d(this.yhz);
            com.tencent.mm.bi.d.akR().d(this);
            aw.ZK();
            com.tencent.mm.model.c.XR().b(this);
            aw.ZK();
            com.tencent.mm.model.c.b(this);
            aw.ZK();
            com.tencent.mm.model.c.Ry().b(this);
            if (this.yhf != null) {
                com.tencent.mm.at.o.ahk().rZ(this.yhf);
            }
            if (this.yhj != null) {
                com.tencent.mm.at.o.ahk().rZ(this.yhj);
            }
        }
        if (n.qFB != null) {
            n.qFB.b(this);
        }
        AppMethodBeat.o(29280);
    }

    /* Access modifiers changed, original: protected|final */
    public final void dwc() {
        AppMethodBeat.i(29281);
        ab.i("MicroMsg.FindMoreFriendsUI", "on tab stop");
        AppMethodBeat.o(29281);
    }

    /* Access modifiers changed, original: protected|final */
    public final void dwd() {
        AppMethodBeat.i(29282);
        ab.i("MicroMsg.FindMoreFriendsUI", "on tab destroy");
        ((p) g.M(p.class)).getSysCmdMsgExtension().b("lifeappreddot", this.yhy);
        AppMethodBeat.o(29282);
    }

    public final void dwf() {
        AppMethodBeat.i(29283);
        ab.i("MicroMsg.FindMoreFriendsUI", "turn to bg");
        AppMethodBeat.o(29283);
    }

    public final void dwg() {
        AppMethodBeat.i(29284);
        ab.i("MicroMsg.FindMoreFriendsUI", "turn to fg");
        AppMethodBeat.o(29284);
    }

    public final void dwi() {
        AppMethodBeat.i(29285);
        ab.i("MicroMsg.FindMoreFriendsUI", "on tab recreate ui");
        AppMethodBeat.o(29285);
    }

    public final void a(String str, com.tencent.mm.sdk.e.m mVar) {
        Object obj = 1;
        AppMethodBeat.i(29286);
        ab.i("MicroMsg.FindMoreFriendsUI", "onNotifyChange(MStorage)");
        if (LauncherUI.dxE() == 2) {
            Object obj2 = null;
            if (this.status != com.tencent.mm.model.r.YD()) {
                this.status = com.tencent.mm.model.r.YD();
                obj2 = 1;
            }
            if (this.kFU != com.tencent.mm.model.r.YE()) {
                this.kFU = com.tencent.mm.model.r.YE();
                obj2 = 1;
            }
            if (this.qnE != com.tencent.mm.model.r.YK()) {
                this.qnE = com.tencent.mm.model.r.YK();
            } else {
                obj = obj2;
            }
            if (obj != null) {
                aMk();
            }
        }
        AppMethodBeat.o(29286);
    }

    public final void a(int i, com.tencent.mm.sdk.e.n nVar, Object obj) {
        Object obj2 = 1;
        AppMethodBeat.i(29287);
        ab.i("MicroMsg.FindMoreFriendsUI", "onNotifyChange(MStorageEx)");
        if (LauncherUI.dxE() == 2) {
            Object obj3 = null;
            if (this.status != com.tencent.mm.model.r.YD()) {
                this.status = com.tencent.mm.model.r.YD();
                obj3 = 1;
            }
            if (this.kFU != com.tencent.mm.model.r.YE()) {
                this.kFU = com.tencent.mm.model.r.YE();
                obj3 = 1;
            }
            if (this.qnE != com.tencent.mm.model.r.YK()) {
                this.qnE = com.tencent.mm.model.r.YK();
            } else {
                obj2 = obj3;
            }
            if (obj2 != null) {
                aMk();
            }
            if (nVar instanceof com.tencent.mm.storage.al) {
                this.yhb.notifyDataSetChanged();
            }
        }
        AppMethodBeat.o(29287);
    }

    public final void dxc() {
        AppMethodBeat.i(29288);
        ab.v("MicroMsg.FindMoreFriendsUI", "on tab switch in");
        this.cCt = true;
        dxb();
        com.tencent.mm.blink.b.HQ().o(new Runnable() {
            public final void run() {
                AppMethodBeat.i(29234);
                FindMoreFriendsUI.this.status = com.tencent.mm.model.r.YD();
                FindMoreFriendsUI.this.qnE = com.tencent.mm.model.r.YK();
                FindMoreFriendsUI.this.kFU = com.tencent.mm.model.r.YE();
                long currentTimeMillis = System.currentTimeMillis();
                FindMoreFriendsUI.y(FindMoreFriendsUI.this);
                ab.i("MicroMsg.FindMoreFriendsUI", "[updateStatus] cost:%sms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                AppMethodBeat.o(29234);
            }
        });
        ac.Ig(20);
        AppMethodBeat.o(29288);
    }

    public final void dxd() {
        AppMethodBeat.i(29289);
        ab.v("MicroMsg.FindMoreFriendsUI", "on tab switch out");
        this.cCt = false;
        dxb();
        AppMethodBeat.o(29289);
    }

    public final void ZA() {
        AppMethodBeat.i(29290);
        ab.i("MicroMsg.FindMoreFriendsUI", "notify comment change");
        if ((com.tencent.mm.model.r.YK() & 32768) != 0) {
            AppMethodBeat.o(29290);
            return;
        }
        if (n.qFz != null) {
            this.yhe = n.qFz.baS();
        }
        dwX();
        this.yhb.notifyDataSetChanged();
        AppMethodBeat.o(29290);
    }

    static /* synthetic */ void g(FindMoreFriendsUI findMoreFriendsUI) {
        AppMethodBeat.i(138181);
        findMoreFriendsUI.dwW();
        findMoreFriendsUI.yhb.notifyDataSetChanged();
        AppMethodBeat.o(138181);
    }
}
