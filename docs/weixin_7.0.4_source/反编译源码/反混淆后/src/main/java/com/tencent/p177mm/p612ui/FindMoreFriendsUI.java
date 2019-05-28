package com.tencent.p177mm.p612ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
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
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.CheckBox;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.facebook.appevents.AppEventsConstants;
import com.google.firebase.analytics.FirebaseAnalytics.C8740a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.app.plugin.C32266b;
import com.tencent.p177mm.blink.C1314b;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1815as;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C32782bp;
import com.tencent.p177mm.model.C42185ar;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.modelsns.C37952b;
import com.tencent.p177mm.p1099x.C16112c;
import com.tencent.p177mm.p1179au.C17950b;
import com.tencent.p177mm.p1374bi.C41789d;
import com.tencent.p177mm.p1510r.C35973a;
import com.tencent.p177mm.p178a.C1178g;
import com.tencent.p177mm.p183ai.C1201e.C1197a;
import com.tencent.p177mm.p190at.C17937c;
import com.tencent.p177mm.p190at.C32291o;
import com.tencent.p177mm.p190at.C32292p.C32293a;
import com.tencent.p177mm.p190at.p191a.p1527d.C37477b;
import com.tencent.p177mm.p190at.p191a.p193c.C1282i;
import com.tencent.p177mm.p190at.p191a.p193c.C9014g;
import com.tencent.p177mm.p190at.p191a.p827a.C25814c;
import com.tencent.p177mm.p190at.p191a.p827a.C25814c.C17927a;
import com.tencent.p177mm.p203bg.C17981e;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p218cj.C45287c;
import com.tencent.p177mm.p230g.p231a.C18296ik;
import com.tencent.p177mm.p230g.p231a.C18377qm;
import com.tencent.p177mm.p230g.p231a.C18427vl;
import com.tencent.p177mm.p230g.p231a.C26156ho;
import com.tencent.p177mm.p230g.p231a.C26190ll;
import com.tencent.p177mm.p230g.p231a.C26219ql;
import com.tencent.p177mm.p230g.p231a.C32572ib;
import com.tencent.p177mm.p230g.p231a.C32578jb;
import com.tencent.p177mm.p230g.p231a.C32604oh;
import com.tencent.p177mm.p230g.p231a.C32622px;
import com.tencent.p177mm.p230g.p231a.C37725gz;
import com.tencent.p177mm.p230g.p231a.C42012iw;
import com.tencent.p177mm.p230g.p231a.C45329gy;
import com.tencent.p177mm.p230g.p231a.C45351oj;
import com.tencent.p177mm.p230g.p231a.C45360qp;
import com.tencent.p177mm.p230g.p231a.C6471cq;
import com.tencent.p177mm.p230g.p231a.C6552to;
import com.tencent.p177mm.p230g.p231a.C9419mz;
import com.tencent.p177mm.p230g.p231a.C9447pz;
import com.tencent.p177mm.p230g.p231a.C9470sk;
import com.tencent.p177mm.p249m.C26373g;
import com.tencent.p177mm.p612ui.base.C23639t;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.preference.C15541f;
import com.tencent.p177mm.p612ui.base.preference.C40675h;
import com.tencent.p177mm.p612ui.base.preference.IconPreference;
import com.tencent.p177mm.p612ui.base.preference.NormalIconPreference;
import com.tencent.p177mm.p612ui.base.preference.Preference;
import com.tencent.p177mm.p612ui.base.preference.PreferenceSmallCategory;
import com.tencent.p177mm.p612ui.tools.C44385r;
import com.tencent.p177mm.p612ui.widget.p633a.C5653c;
import com.tencent.p177mm.p840bn.C9089a;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.account.bind.p271ui.BindMContactIntroUI;
import com.tencent.p177mm.plugin.account.bind.p271ui.MobileFriendUI;
import com.tencent.p177mm.plugin.account.friend.p272a.C38033l;
import com.tencent.p177mm.plugin.account.friend.p272a.C38033l.C38034a;
import com.tencent.p177mm.plugin.account.p275ui.FacebookFriendUI;
import com.tencent.p177mm.plugin.account.p765a.p1216b.C32921a;
import com.tencent.p177mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.p177mm.plugin.appbrand.service.C19731g;
import com.tencent.p177mm.plugin.appbrand.service.C45691e;
import com.tencent.p177mm.plugin.boots.p348a.C20015c;
import com.tencent.p177mm.plugin.boots.p348a.C27502b;
import com.tencent.p177mm.plugin.game.p1268a.C43155a;
import com.tencent.p177mm.plugin.game.p1268a.C43155a.C20928a;
import com.tencent.p177mm.plugin.ipcall.C21098d;
import com.tencent.p177mm.plugin.ipcall.p438a.p441e.C3307i;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C3473o;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6983p;
import com.tencent.p177mm.plugin.report.service.C34830g;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.setting.p505ui.setting.SettingsManageFindMoreUI;
import com.tencent.p177mm.plugin.sns.p1024b.C21877n;
import com.tencent.p177mm.plugin.sns.p1024b.C29034m;
import com.tencent.p177mm.plugin.sns.p517i.C21902f;
import com.tencent.p177mm.plugin.subapp.jdbiz.C22336b;
import com.tencent.p177mm.plugin.topstory.p539a.C13943b;
import com.tencent.p177mm.plugin.topstory.p541ui.C4210c;
import com.tencent.p177mm.plugin.topstory.p541ui.C7612a;
import com.tencent.p177mm.plugin.websearch.api.C14423an;
import com.tencent.p177mm.plugin.websearch.api.C22757j;
import com.tencent.p177mm.plugin.websearch.api.C29736ac;
import com.tencent.p177mm.plugin.websearch.api.C4514am;
import com.tencent.p177mm.plugin.websearch.api.C4514am.C4515a;
import com.tencent.p177mm.plugin.websearch.api.C46400aa;
import com.tencent.p177mm.plugin.webview.modeltools.C29833g;
import com.tencent.p177mm.plugin.welab.p1072a.p1073a.C23167a;
import com.tencent.p177mm.pluginsdk.C44068p.C14896a;
import com.tencent.p177mm.pluginsdk.model.app.C46494g;
import com.tencent.p177mm.pluginsdk.p1077c.C40418a;
import com.tencent.p177mm.pluginsdk.p1079f.C44044f;
import com.tencent.p177mm.pluginsdk.p1079f.C44044f.C14833a;
import com.tencent.p177mm.pluginsdk.p1079f.C44044f.C14834b;
import com.tencent.p177mm.pluginsdk.permission.C35805b;
import com.tencent.p177mm.pluginsdk.wallet.C14991i;
import com.tencent.p177mm.protocal.protobuf.cht;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.p603e.C4935m;
import com.tencent.p177mm.sdk.p603e.C7296k.C4931a;
import com.tencent.p177mm.sdk.p603e.C7298n;
import com.tencent.p177mm.sdk.p603e.C7298n.C4937b;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4988aa;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5056d;
import com.tencent.p177mm.sdk.platformtools.C5058f;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.storage.C15433al;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.soter.core.biometric.FaceManager;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.ui.FindMoreFriendsUI */
public class FindMoreFriendsUI extends AbstractTabChildPreference implements C42185ar, C1815as, C4931a, C4937b {
    private boolean cCt = false;
    private long kFU;
    private C7306ak mHandler = new C7306ak(Looper.getMainLooper()) {
        public final void handleMessage(Message message) {
            AppMethodBeat.m2504i(29207);
            switch (message.what) {
                case 1:
                    if (FindMoreFriendsUI.this.yhb != null) {
                        FindMoreFriendsUI.m59250b(FindMoreFriendsUI.this);
                        break;
                    }
                    break;
            }
            AppMethodBeat.m2505o(29207);
        }
    };
    private C4884c<C18427vl> mJI = new C235336();
    private CheckBox oPS;
    private C5653c oPU = null;
    C4884c qLL = new C3602321();
    private int qnE;
    private int status;
    private C40418a vqt = new C3601620();
    C32293a yhA = new C360149();
    private long yha;
    private C40675h yhb;
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
    private C4884c<C32622px> yhq = new C3032412();
    C4884c yhr = new C3601822();
    C4884c yhs = new C2353023();
    private C40418a yht = new C2353124();
    private C40418a yhu = new C2353225();
    private C4884c yhv = new C3032726();
    private String yhw;
    private C30330a yhx = C30330a.TYPE_NONE;
    private C3473o yhy = new C360192();
    private C4884c<C26156ho> yhz = new C154607();

    /* renamed from: com.tencent.mm.ui.FindMoreFriendsUI$18 */
    class C517718 implements Runnable {
        C517718() {
        }

        public final void run() {
            AppMethodBeat.m2504i(29234);
            FindMoreFriendsUI.this.status = C1853r.m3822YD();
            FindMoreFriendsUI.this.qnE = C1853r.m3829YK();
            FindMoreFriendsUI.this.kFU = C1853r.m3823YE();
            long currentTimeMillis = System.currentTimeMillis();
            FindMoreFriendsUI.m59280y(FindMoreFriendsUI.this);
            C4990ab.m7417i("MicroMsg.FindMoreFriendsUI", "[updateStatus] cost:%sms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            AppMethodBeat.m2505o(29234);
        }
    }

    /* renamed from: com.tencent.mm.ui.FindMoreFriendsUI$11 */
    class C1545711 implements OnClickListener {
        C1545711() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(29221);
            if (FindMoreFriendsUI.this.oPS != null) {
                C9638aw.m17190ZK();
                C18628c.m29072Ry().set(4104, Boolean.valueOf(!FindMoreFriendsUI.this.oPS.isChecked()));
            }
            LauncherUI launcherUI = (LauncherUI) FindMoreFriendsUI.this.getContext();
            if (launcherUI != null) {
                launcherUI.yjJ.getMainTabUI().aqG("tab_find_friend");
            }
            C9089a.m16479fy(FindMoreFriendsUI.this.getContext());
            AppMethodBeat.m2505o(29221);
        }
    }

    /* renamed from: com.tencent.mm.ui.FindMoreFriendsUI$7 */
    class C154607 extends C4884c<C26156ho> {
        C154607() {
            AppMethodBeat.m2504i(29215);
            this.xxI = C26156ho.class.getName().hashCode();
            AppMethodBeat.m2505o(29215);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(29216);
            ((C26156ho) c4883b).cCs.cCt = FindMoreFriendsUI.this.cCt;
            AppMethodBeat.m2505o(29216);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.ui.FindMoreFriendsUI$23 */
    class C2353023 extends C4884c<C6471cq> {
        C2353023() {
            super(1);
            AppMethodBeat.m2504i(29242);
            this.xxI = C6471cq.class.getName().hashCode();
            AppMethodBeat.m2505o(29242);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(29243);
            C4990ab.m7416i("MicroMsg.FindMoreFriendsUI", "dynamic config file change");
            FindMoreFriendsUI.this.mHandler.sendEmptyMessage(1);
            AppMethodBeat.m2505o(29243);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.ui.FindMoreFriendsUI$24 */
    class C2353124 extends C40418a {
        C2353124() {
        }

        /* renamed from: j */
        public final void mo39062j(C4883b c4883b) {
            AppMethodBeat.m2504i(29244);
            if (c4883b instanceof C45329gy) {
                FindMoreFriendsUI.m59258g(FindMoreFriendsUI.this);
                FindMoreFriendsUI.this.yhb.notifyDataSetChanged();
            }
            AppMethodBeat.m2505o(29244);
        }
    }

    /* renamed from: com.tencent.mm.ui.FindMoreFriendsUI$25 */
    class C2353225 extends C40418a {
        C2353225() {
        }

        /* renamed from: j */
        public final void mo39062j(C4883b c4883b) {
            AppMethodBeat.m2504i(29245);
            if (c4883b instanceof C18377qm) {
                FindMoreFriendsUI.m59259h(FindMoreFriendsUI.this);
                FindMoreFriendsUI.this.yhb.notifyDataSetChanged();
            }
            AppMethodBeat.m2505o(29245);
        }
    }

    /* renamed from: com.tencent.mm.ui.FindMoreFriendsUI$6 */
    class C235336 extends C4884c<C18427vl> {

        /* renamed from: com.tencent.mm.ui.FindMoreFriendsUI$6$1 */
        class C51791 implements Runnable {
            C51791() {
            }

            public final void run() {
                AppMethodBeat.m2504i(29212);
                if (FindMoreFriendsUI.this.isAdded()) {
                    FindMoreFriendsUI.m59255d(FindMoreFriendsUI.this);
                }
                AppMethodBeat.m2505o(29212);
            }
        }

        C235336() {
            AppMethodBeat.m2504i(29213);
            this.xxI = C18427vl.class.getName().hashCode();
            AppMethodBeat.m2505o(29213);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(29214);
            FindMoreFriendsUI.this.getContentView().post(new C51791());
            AppMethodBeat.m2505o(29214);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.ui.FindMoreFriendsUI$10 */
    class C3032310 implements Runnable {
        C3032310() {
        }

        public final void run() {
            AppMethodBeat.m2504i(29220);
            C45287c.aNX();
            AppMethodBeat.m2505o(29220);
        }
    }

    /* renamed from: com.tencent.mm.ui.FindMoreFriendsUI$12 */
    class C3032412 extends C4884c<C32622px> {
        C3032412() {
            AppMethodBeat.m2504i(29222);
            this.xxI = C32622px.class.getName().hashCode();
            AppMethodBeat.m2505o(29222);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(29223);
            FindMoreFriendsUI.m59253c(FindMoreFriendsUI.this);
            FindMoreFriendsUI.m59255d(FindMoreFriendsUI.this);
            AppMethodBeat.m2505o(29223);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.ui.FindMoreFriendsUI$26 */
    class C3032726 extends C4884c<C26219ql> {
        C3032726() {
            AppMethodBeat.m2504i(29246);
            this.xxI = C26219ql.class.getName().hashCode();
            AppMethodBeat.m2505o(29246);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(29247);
            if (((C26219ql) c4883b) instanceof C26219ql) {
                FindMoreFriendsUI.m59259h(FindMoreFriendsUI.this);
                FindMoreFriendsUI.this.yhb.notifyDataSetChanged();
            }
            AppMethodBeat.m2505o(29247);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.ui.FindMoreFriendsUI$8 */
    class C303298 implements View.OnClickListener {
        C303298() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(29217);
            FindMoreFriendsUI.this.startActivity(new Intent(FindMoreFriendsUI.this.getContext(), SettingsManageFindMoreUI.class));
            AppMethodBeat.m2505o(29217);
        }
    }

    /* renamed from: com.tencent.mm.ui.FindMoreFriendsUI$a */
    enum C30330a {
        TYPE_NONE,
        TYPE_NORMAL,
        TYPE_TEXT,
        TYPE_IMG,
        TYPE_IMG_TEXT,
        TYPE_NEW_HINT;

        static {
            AppMethodBeat.m2505o(29250);
        }
    }

    /* renamed from: com.tencent.mm.ui.FindMoreFriendsUI$13 */
    class C3601213 implements Runnable {
        C3601213() {
        }

        public final void run() {
            AppMethodBeat.m2504i(29225);
            final C9419mz c9419mz = new C9419mz();
            C4879a.xxA.mo10055m(c9419mz);
            C5004al.m7441d(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(29224);
                    FindMoreFriendsUI.m59244a(FindMoreFriendsUI.this, c9419mz);
                    AppMethodBeat.m2505o(29224);
                }
            });
            AppMethodBeat.m2505o(29225);
        }
    }

    /* renamed from: com.tencent.mm.ui.FindMoreFriendsUI$9 */
    class C360149 implements C32293a {
        C360149() {
        }

        /* renamed from: i */
        public final void mo11044i(final String str, final Bitmap bitmap) {
            AppMethodBeat.m2504i(29219);
            C5004al.m7441d(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(29218);
                    C4990ab.m7416i("MicroMsg.FindMoreFriendsUI", "download url " + str + " , result " + (bitmap == null));
                    IconPreference iconPreference = (IconPreference) FindMoreFriendsUI.this.yhb.aqO("jd_market_entrance");
                    if (iconPreference != null) {
                        if (str.equals(FindMoreFriendsUI.this.yhf)) {
                            FindMoreFriendsUI.this.yhf = null;
                        } else if (str.equals(FindMoreFriendsUI.this.yhj)) {
                            iconPreference.mo48770ap(bitmap);
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
                        ((IconPreference) FindMoreFriendsUI.this.yhb.aqO("find_friends_by_look")).mo48770ap(bitmap);
                        FindMoreFriendsUI.this.yhi = null;
                        FindMoreFriendsUI.this.yhb.notifyDataSetChanged();
                    }
                    if (str.equals(FindMoreFriendsUI.this.yhw)) {
                        ((IconPreference) FindMoreFriendsUI.this.yhb.aqO("my_life_around")).mo48770ap(C5056d.m7616a(bitmap, false, ((float) bitmap.getWidth()) * 0.1f));
                        FindMoreFriendsUI.this.yhw = null;
                        FindMoreFriendsUI.this.yhb.notifyDataSetChanged();
                    }
                    AppMethodBeat.m2505o(29218);
                }
            });
            AppMethodBeat.m2505o(29219);
        }
    }

    /* renamed from: com.tencent.mm.ui.FindMoreFriendsUI$20 */
    class C3601620 extends C40418a {
        C3601620() {
        }

        /* renamed from: j */
        public final void mo39062j(C4883b c4883b) {
            AppMethodBeat.m2504i(29236);
            C4990ab.m7411d("MicroMsg.FindMoreFriendsUI", "onMStorageNotifyEvent, %s ", c4883b);
            if (c4883b instanceof C32578jb) {
                FindMoreFriendsUI.m59256e(FindMoreFriendsUI.this);
                if (FindMoreFriendsUI.this.yhb != null) {
                    FindMoreFriendsUI.this.yhb.notifyDataSetChanged();
                }
            }
            AppMethodBeat.m2505o(29236);
        }
    }

    /* renamed from: com.tencent.mm.ui.FindMoreFriendsUI$22 */
    class C3601822 extends C4884c<C42012iw> {
        C3601822() {
            AppMethodBeat.m2504i(29240);
            this.xxI = C42012iw.class.getName().hashCode();
            AppMethodBeat.m2505o(29240);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(29241);
            if (C44044f.vdy != null) {
                C7060h.pYm.mo8381e(11178, C5046bo.nullAsNil(r0.cDA()), r0.cDB().cDm(), Integer.valueOf(FindMoreFriendsUI.dxe()));
            }
            FindMoreFriendsUI.m59250b(FindMoreFriendsUI.this);
            FindMoreFriendsUI.this.yhb.notifyDataSetChanged();
            AppMethodBeat.m2505o(29241);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.ui.FindMoreFriendsUI$2 */
    class C360192 implements C3473o {
        C360192() {
        }

        public final void onNewXmlReceived(String str, Map<String, String> map, C1197a c1197a) {
            AppMethodBeat.m2504i(29208);
            if (C5046bo.nullAsNil(str).equals("lifeappreddot") && map != null) {
                boolean equals = "1".equals(map.get(".sysmsg.lifeappreddot"));
                C4990ab.m7411d("MicroMsg.FindMoreFriendsUI", "life around xml msg content, showRedDot: %s.", Boolean.valueOf(equals));
                C1720g.m3536RP().mo5239Ry().set(C5127a.MY_LIFE_AROUND_APP_RED_DOT_TAG_BOOLEAN, Boolean.valueOf(equals));
                if (equals) {
                    Object obj = (String) map.get(".sysmsg.lifeappreddot.$text");
                    Object obj2 = (String) map.get(".sysmsg.lifeappreddot.$imageurl");
                    C4990ab.m7411d("MicroMsg.FindMoreFriendsUI", "life around xml msg content, type: %s, text: %s, imgUrl: %s.", (String) map.get(".sysmsg.lifeappreddot.$type"), obj, obj2);
                    if (FindMoreFriendsUI.m59247a(FindMoreFriendsUI.this, (String) obj, (String) obj2)) {
                        C1720g.m3536RP().mo5239Ry().set(C5127a.MY_LIFE_AROUND_APP_RED_DOT_TYPE_STRING, r0);
                        C1720g.m3536RP().mo5239Ry().set(C5127a.MY_LIFE_AROUND_APP_RED_DOT_TEXT_STRING, obj);
                        C1720g.m3536RP().mo5239Ry().set(C5127a.MY_LIFE_AROUND_APP_RED_DOT_IMG_URL_STRING, obj2);
                    }
                    AppMethodBeat.m2505o(29208);
                    return;
                }
                FindMoreFriendsUI.this.yhx = C30330a.TYPE_NONE;
                C1720g.m3536RP().mo5239Ry().set(C5127a.MY_LIFE_AROUND_APP_RED_DOT_TYPE_STRING, AppEventsConstants.EVENT_PARAM_VALUE_NO);
                C1720g.m3536RP().mo5239Ry().set(C5127a.MY_LIFE_AROUND_APP_RED_DOT_TEXT_STRING, (Object) "");
                C1720g.m3536RP().mo5239Ry().set(C5127a.MY_LIFE_AROUND_APP_RED_DOT_IMG_URL_STRING, (Object) "");
            }
            AppMethodBeat.m2505o(29208);
        }
    }

    /* renamed from: com.tencent.mm.ui.FindMoreFriendsUI$17 */
    class C3602217 implements Runnable {
        C3602217() {
        }

        public final void run() {
            AppMethodBeat.m2504i(29233);
            C4990ab.m7417i("MicroMsg.FindMoreFriendsUI", "status %d (%d), extStatus %d (%d), pluginFlag %d (%d)", Integer.valueOf(FindMoreFriendsUI.this.status), Integer.valueOf(C1853r.m3822YD()), Long.valueOf(FindMoreFriendsUI.this.kFU), Long.valueOf(C1853r.m3823YE()), Integer.valueOf(FindMoreFriendsUI.this.qnE), Integer.valueOf(C1853r.m3829YK()));
            FindMoreFriendsUI.this.kFU = C1853r.m3823YE();
            FindMoreFriendsUI.this.status = C1853r.m3822YD();
            FindMoreFriendsUI.this.qnE = C1853r.m3829YK();
            FindMoreFriendsUI.m59280y(FindMoreFriendsUI.this);
            AppMethodBeat.m2505o(29233);
        }
    }

    /* renamed from: com.tencent.mm.ui.FindMoreFriendsUI$21 */
    class C3602321 extends C4884c<C9470sk> {

        /* renamed from: com.tencent.mm.ui.FindMoreFriendsUI$21$1 */
        class C154591 implements Runnable {
            C154591() {
            }

            public final void run() {
                AppMethodBeat.m2504i(29237);
                C9638aw.m17190ZK();
                C18628c.m29072Ry().set(68377, (Object) "");
                if (FindMoreFriendsUI.this.yhb != null) {
                    FindMoreFriendsUI.this.yhb.notifyDataSetChanged();
                }
                AppMethodBeat.m2505o(29237);
            }
        }

        C3602321() {
            AppMethodBeat.m2504i(29238);
            this.xxI = C9470sk.class.getName().hashCode();
            AppMethodBeat.m2505o(29238);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(29239);
            C4990ab.m7417i("MicroMsg.FindMoreFriendsUI", "mark sns read %d", Integer.valueOf(((C9470sk) c4883b).cOH.czE));
            if (((C9470sk) c4883b).cOH.czE == 9) {
                new C7306ak(Looper.getMainLooper()).post(new C154591());
            }
            AppMethodBeat.m2505o(29239);
            return true;
        }
    }

    public FindMoreFriendsUI() {
        AppMethodBeat.m2504i(29251);
        AppMethodBeat.m2505o(29251);
    }

    /* renamed from: b */
    static /* synthetic */ void m59250b(FindMoreFriendsUI findMoreFriendsUI) {
        AppMethodBeat.m2504i(29291);
        findMoreFriendsUI.m59270pD(true);
        AppMethodBeat.m2505o(29291);
    }

    /* renamed from: b */
    static /* synthetic */ void m59251b(IconPreference iconPreference, int i, int i2, boolean z, int i3, int i4, int i5) {
        AppMethodBeat.m2504i(138185);
        FindMoreFriendsUI.m59245a(iconPreference, i, 8, i2, z, i3, i4, i5);
        AppMethodBeat.m2505o(138185);
    }

    /* renamed from: c */
    static /* synthetic */ void m59253c(FindMoreFriendsUI findMoreFriendsUI) {
        AppMethodBeat.m2504i(29292);
        findMoreFriendsUI.dwZ();
        AppMethodBeat.m2505o(29292);
    }

    /* renamed from: c */
    static /* synthetic */ void m59254c(String str, int i, String str2, String str3, int i2) {
        AppMethodBeat.m2504i(138186);
        FindMoreFriendsUI.m59252b(str, i, str2, str3, i2);
        AppMethodBeat.m2505o(138186);
    }

    /* renamed from: d */
    static /* synthetic */ void m59255d(FindMoreFriendsUI findMoreFriendsUI) {
        AppMethodBeat.m2504i(29293);
        findMoreFriendsUI.dwS();
        AppMethodBeat.m2505o(29293);
    }

    static /* synthetic */ int dxe() {
        AppMethodBeat.m2504i(138180);
        int dwT = FindMoreFriendsUI.dwT();
        AppMethodBeat.m2505o(138180);
        return dwT;
    }

    /* renamed from: e */
    static /* synthetic */ void m59256e(FindMoreFriendsUI findMoreFriendsUI) {
        AppMethodBeat.m2504i(138179);
        findMoreFriendsUI.dxa();
        AppMethodBeat.m2505o(138179);
    }

    /* renamed from: h */
    static /* synthetic */ void m59259h(FindMoreFriendsUI findMoreFriendsUI) {
        AppMethodBeat.m2504i(138182);
        findMoreFriendsUI.dwY();
        AppMethodBeat.m2505o(138182);
    }

    /* renamed from: y */
    static /* synthetic */ void m59280y(FindMoreFriendsUI findMoreFriendsUI) {
        AppMethodBeat.m2504i(138187);
        findMoreFriendsUI.aMk();
        AppMethodBeat.m2505o(138187);
    }

    /* renamed from: JC */
    public final int mo48647JC() {
        return C25738R.xml.f8509at;
    }

    public boolean supportNavigationSwipeBack() {
        return false;
    }

    public boolean noActionBar() {
        return true;
    }

    private boolean dwR() {
        AppMethodBeat.m2504i(29252);
        if (C5046bo.m7505L(C1720g.m3536RP().mo5239Ry().mo16814a(C5127a.FIND_MORE_UI_ENTRY_LAST_REPORT_TIME_LONG_SYNC, 0), this.yha)) {
            AppMethodBeat.m2505o(29252);
            return true;
        }
        AppMethodBeat.m2505o(29252);
        return false;
    }

    private void dwS() {
        AppMethodBeat.m2504i(29253);
        C4990ab.m7416i("MicroMsg.FindMoreFriendsUI", "checkLookVisibility");
        if (this.yCQ && isAdded()) {
            try {
                Object obj;
                boolean z;
                boolean z2;
                JSONObject adL = C29736ac.adL("discoverRecommendEntry");
                if (m59236Cn(67108864)) {
                    C4990ab.m7416i("MicroMsg.FindMoreFriendsUI", "checkLookVisibility in experiment but not open");
                    obj = null;
                    z = false;
                } else if (((C23167a) C1720g.m3528K(C23167a.class)).agN("labs_browse")) {
                    obj = 1;
                    z = true;
                } else {
                    obj = null;
                    z = true;
                }
                if (C17950b.m28216sO((String) C1720g.m3536RP().mo5239Ry().get(274436, null))) {
                    C4990ab.m7416i("MicroMsg.FindMoreFriendsUI", "checkLookVisibility EuropeanUnionCountry");
                    z2 = false;
                } else {
                    z2 = z;
                }
                C4990ab.m7417i("MicroMsg.FindMoreFriendsUI", "showLookEntry %s", Boolean.valueOf(z2));
                if (z2) {
                    String optString = adL.optString("wording");
                    final IconPreference iconPreference = (IconPreference) this.yhb.aqO("find_friends_by_look");
                    if (C5046bo.isNullOrNil(optString)) {
                        iconPreference.setTitle((CharSequence) getString(C25738R.string.btu));
                    } else {
                        iconPreference.setTitle((CharSequence) optString);
                    }
                    this.yhn++;
                    this.yhb.mo27715ce("find_friends_by_look", false);
                    if (obj != null) {
                        iconPreference.mo48763NL(0);
                        iconPreference.mo48774ey(getString(C25738R.string.f9181s0), C25738R.drawable.f6940w3);
                    } else {
                        C5004al.m7441d(new Runnable() {
                            public final void run() {
                                AppMethodBeat.m2504i(29209);
                                if (iconPreference == null) {
                                    AppMethodBeat.m2505o(29209);
                                    return;
                                }
                                boolean cEN = ((C13943b) C1720g.m3530M(C13943b.class)).getRedDotMgr().cEN();
                                int cEU = ((C13943b) C1720g.m3530M(C13943b.class)).getRedDotMgr().cEU();
                                iconPreference.mo48765NN(8);
                                iconPreference.mo48764NM(8);
                                iconPreference.mo48768NQ(8);
                                iconPreference.mo48763NL(8);
                                if (cEU <= 0 || !((C13943b) C1720g.m3530M(C13943b.class)).getRedDotMgr().cEO()) {
                                    if (cEN) {
                                        if (LauncherUI.dxE() == 2) {
                                            ((C13943b) C1720g.m3530M(C13943b.class)).getRedDotMgr().cEQ();
                                        }
                                        cht cEP = ((C13943b) C1720g.m3530M(C13943b.class)).getRedDotMgr().cEP();
                                        Bitmap kR;
                                        switch (cEP.type) {
                                            case 1:
                                                iconPreference.mo48765NN(0);
                                                break;
                                            case 2:
                                                iconPreference.mo48765NN(8);
                                                iconPreference.mo48764NM(0);
                                                iconPreference.mo48771av(cEP.text, -1, Color.parseColor("#8c8c8c"));
                                                iconPreference.mo48778qh(true);
                                                iconPreference.mo48768NQ(8);
                                                break;
                                            case 3:
                                                iconPreference.mo48765NN(8);
                                                iconPreference.mo48768NQ(0);
                                                iconPreference.mo48767NP(0);
                                                iconPreference.mo48769NR(0);
                                                iconPreference.mo48778qh(false);
                                                C32291o.ahk();
                                                kR = C17937c.m28186kR(cEP.cIY);
                                                if (kR == null) {
                                                    C32291o.aho().mo53003a(cEP.cIY, FindMoreFriendsUI.this.yhA);
                                                    FindMoreFriendsUI.this.yhi = cEP.cIY;
                                                    break;
                                                }
                                                FindMoreFriendsUI.this.yhi = null;
                                                iconPreference.mo48770ap(kR);
                                                break;
                                            case 4:
                                                iconPreference.mo48765NN(8);
                                                iconPreference.mo48768NQ(0);
                                                iconPreference.mo48767NP(0);
                                                iconPreference.mo48769NR(0);
                                                iconPreference.mo48764NM(0);
                                                iconPreference.mo48778qh(false);
                                                iconPreference.mo48771av(cEP.text, -1, Color.parseColor("#8c8c8c"));
                                                C32291o.ahk();
                                                kR = C17937c.m28186kR(cEP.cIY);
                                                if (kR == null) {
                                                    C32291o.aho().mo53003a(cEP.cIY, FindMoreFriendsUI.this.yhA);
                                                    FindMoreFriendsUI.this.yhi = cEP.cIY;
                                                    break;
                                                }
                                                FindMoreFriendsUI.this.yhi = null;
                                                iconPreference.mo48770ap(kR);
                                                break;
                                            default:
                                                C4990ab.m7413e("MicroMsg.FindMoreFriendsUI", "search unknown red type %d", Integer.valueOf(cEP.type));
                                                break;
                                        }
                                    }
                                }
                                iconPreference.mo48763NL(0);
                                String valueOf = String.valueOf(cEU);
                                if (cEU > 99) {
                                    valueOf = "99+";
                                }
                                iconPreference.mo48774ey(valueOf, C44385r.m80243ik(FindMoreFriendsUI.this.getContext()));
                                ((C13943b) C1720g.m3530M(C13943b.class)).getRedDotMgr().mo56013Fy(cEU);
                                FindMoreFriendsUI.this.yhb.notifyDataSetChanged();
                                AppMethodBeat.m2505o(29209);
                            }
                        });
                    }
                    ((C7612a) C1720g.m3530M(C7612a.class)).tryToCreateTopStoryWebView();
                    AppMethodBeat.m2505o(29253);
                    return;
                }
                this.yhb.mo27715ce("find_friends_by_look", true);
                if (!dwR()) {
                    C7060h.pYm.mo15419k(953, 3, 1);
                }
                AppMethodBeat.m2505o(29253);
                return;
            } catch (Exception e) {
                C4990ab.m7412e("MicroMsg.FindMoreFriendsUI", C5046bo.m7574l(e));
                AppMethodBeat.m2505o(29253);
                return;
            }
        }
        C4990ab.m7416i("MicroMsg.FindMoreFriendsUI", "checkLookVisibility preference not add");
        AppMethodBeat.m2505o(29253);
    }

    /* renamed from: ij */
    private boolean m59261ij(String str, String str2) {
        int i;
        C30330a c30330a;
        AppMethodBeat.m2504i(29254);
        int i2 = !C5046bo.isNullOrNil(str) ? 1 : 0;
        if (C5046bo.isNullOrNil(str2)) {
            i = 0;
        } else {
            i = 1;
        }
        if (i2 != 0 && i != 0) {
            c30330a = C30330a.TYPE_IMG_TEXT;
        } else if (i != 0) {
            c30330a = C30330a.TYPE_IMG;
        } else if (i2 != 0) {
            c30330a = C30330a.TYPE_TEXT;
        } else {
            c30330a = C30330a.TYPE_NORMAL;
        }
        C4990ab.m7411d("MicroMsg.FindMoreFriendsUI", "new type: %s, now type: %s.", c30330a, this.yhx);
        if (c30330a.compareTo(this.yhx) >= 0) {
            this.yhx = c30330a;
            AppMethodBeat.m2505o(29254);
            return true;
        }
        AppMethodBeat.m2505o(29254);
        return false;
    }

    /* renamed from: a */
    private static void m59246a(IconPreference iconPreference, int i, int i2, boolean z, int i3, int i4, int i5) {
        AppMethodBeat.m2504i(29255);
        iconPreference.mo48765NN(i);
        iconPreference.mo48764NM(i2);
        iconPreference.mo48778qh(z);
        iconPreference.mo48768NQ(i3);
        iconPreference.mo48767NP(i4);
        iconPreference.mo48769NR(i5);
        AppMethodBeat.m2505o(29255);
    }

    /* renamed from: a */
    private void m59243a(final C4515a c4515a, final IconPreference iconPreference) {
        AppMethodBeat.m2504i(138177);
        C5004al.m7441d(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(29210);
                if (iconPreference == null) {
                    AppMethodBeat.m2505o(29210);
                } else if (c4515a == null) {
                    iconPreference.mo48765NN(8);
                    AppMethodBeat.m2505o(29210);
                } else {
                    if (c4515a.isValid()) {
                        C4990ab.m7417i("MicroMsg.FindMoreFriendsUI", "show red %s", iconPreference.getTitle());
                        Bitmap kR;
                        switch (c4515a.type) {
                            case 1:
                                iconPreference.mo48765NN(0);
                                iconPreference.mo48764NM(8);
                                break;
                            case 2:
                                iconPreference.mo48765NN(8);
                                iconPreference.mo48764NM(0);
                                iconPreference.mo48771av(c4515a.text, -1, Color.parseColor("#8c8c8c"));
                                iconPreference.mo48778qh(true);
                                iconPreference.mo48768NQ(8);
                                break;
                            case 3:
                                iconPreference.mo48768NQ(0);
                                iconPreference.mo48767NP(0);
                                iconPreference.mo48769NR(0);
                                iconPreference.mo48778qh(false);
                                C32291o.ahk();
                                kR = C17937c.m28186kR(c4515a.cIY);
                                if (kR == null) {
                                    C32291o.aho().mo53003a(c4515a.cIY, FindMoreFriendsUI.this.yhA);
                                    FindMoreFriendsUI.this.yhi = c4515a.cIY;
                                    break;
                                }
                                FindMoreFriendsUI.this.yhi = null;
                                iconPreference.mo48770ap(kR);
                                break;
                            case 4:
                                iconPreference.mo48768NQ(0);
                                iconPreference.mo48767NP(0);
                                iconPreference.mo48769NR(0);
                                iconPreference.mo48764NM(0);
                                iconPreference.mo48778qh(false);
                                iconPreference.mo48771av(c4515a.text, -1, Color.parseColor("#8c8c8c"));
                                C32291o.ahk();
                                kR = C17937c.m28186kR(c4515a.cIY);
                                if (kR == null) {
                                    C32291o.aho().mo53003a(c4515a.cIY, FindMoreFriendsUI.this.yhA);
                                    FindMoreFriendsUI.this.yhi = c4515a.cIY;
                                    break;
                                }
                                FindMoreFriendsUI.this.yhi = null;
                                iconPreference.mo48770ap(kR);
                                break;
                            default:
                                C4990ab.m7413e("MicroMsg.FindMoreFriendsUI", "search unknown red type %d", Integer.valueOf(c4515a.type));
                                break;
                        }
                    }
                    C4990ab.m7417i("MicroMsg.FindMoreFriendsUI", "hide red %s", iconPreference.getTitle());
                    iconPreference.mo48765NN(8);
                    iconPreference.mo48764NM(8);
                    iconPreference.mo48768NQ(8);
                    iconPreference.mo39406NW(0);
                    FindMoreFriendsUI.this.yhb.notifyDataSetChanged();
                    AppMethodBeat.m2505o(29210);
                }
            }
        });
        AppMethodBeat.m2505o(138177);
    }

    public void onActivityCreated(Bundle bundle) {
        AppMethodBeat.m2504i(29256);
        super.onActivityCreated(bundle);
        C4990ab.m7416i("MicroMsg.FindMoreFriendsUI", "onActivityCreated");
        AppMethodBeat.m2505o(29256);
    }

    /* JADX WARNING: Removed duplicated region for block: B:130:0x05c4  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x02bb  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x03b6  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x0405  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void aMk() {
        AppMethodBeat.m2504i(29257);
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
            C4990ab.m7417i("MicroMsg.FindMoreFriendsUI", "status %d (%d), extStatus %d (%d), pluginFlag %d (%d)", Integer.valueOf(this.status), Integer.valueOf(C1853r.m3822YD()), Long.valueOf(this.kFU), Long.valueOf(C1853r.m3823YE()), Integer.valueOf(this.qnE), Integer.valueOf(C1853r.m3829YK()));
            dwX();
            boolean Cn = m59236Cn(1048576);
            boolean afj = C25985d.afj("scanner");
            String str2 = "MicroMsg.FindMoreFriendsUI";
            String str3 = "openScan %s, plugin installed %s";
            Object[] objArr = new Object[2];
            objArr[0] = Boolean.valueOf(!Cn);
            objArr[1] = Boolean.valueOf(afj);
            C4990ab.m7417i(str2, str3, objArr);
            if (Cn || !afj) {
                this.yhb.mo27715ce("find_friends_by_qrcode", true);
                if (!dwR()) {
                    C7060h.pYm.mo15419k(953, 1, 1);
                }
            } else {
                this.yhb.mo27715ce("find_friends_by_qrcode", false);
                this.yhn++;
                if (C16112c.m24429PK().mo28550b(C5127a.NEW_BANDAGE_DATASOURCE_TRANSLATION_RED_DOT_STRING_SYNC, C5127a.NEW_BANDAGE_WATCHER_SCAN_ENTRY_RED_DOT_STRING_SYNC)) {
                    ((NormalIconPreference) this.yhb.aqO("find_friends_by_qrcode")).mo48765NN(0);
                } else {
                    ((NormalIconPreference) this.yhb.aqO("find_friends_by_qrcode")).mo48765NN(4);
                }
            }
            dwY();
            dwZ();
            dxa();
            Cn = m59236Cn(4194304);
            String str4 = "MicroMsg.FindMoreFriendsUI";
            str2 = "openShoppingEntry %s";
            Object[] objArr2 = new Object[1];
            objArr2[0] = Boolean.valueOf(!Cn);
            C4990ab.m7417i(str4, str2, objArr2);
            if (Cn) {
                this.yhb.mo27715ce("jd_market_entrance", true);
                if (!dwR()) {
                    C7060h.pYm.mo15419k(953, 7, 1);
                }
            } else {
                m59270pD(false);
            }
            C43155a bDb = C20928a.bDb();
            if (bDb != null) {
                getContext();
                bCS = bDb.bCS();
            } else {
                bCS = false;
            }
            afj = m59236Cn(8388608);
            str2 = "MicroMsg.FindMoreFriendsUI";
            str3 = "shouldShowGame %s, openGameEntry %s";
            objArr = new Object[2];
            objArr[0] = Boolean.valueOf(bCS);
            objArr[1] = Boolean.valueOf(!afj);
            C4990ab.m7417i(str2, str3, objArr);
            if (!bCS || afj) {
                this.yhb.mo27715ce("more_tab_game_recommend", true);
                if (!dwR()) {
                    C7060h.pYm.mo15419k(953, 8, 1);
                }
            } else {
                this.yhb.mo27715ce("more_tab_game_recommend", false);
                dwW();
                this.yhn++;
            }
            C45360qp c45360qp = new C45360qp();
            c45360qp.cMH.cMJ = true;
            C4879a.xxA.mo10055m(c45360qp);
            Cn = c45360qp.cMI.cMK;
            boolean Cn2 = m59236Cn(16777216);
            str3 = "MicroMsg.FindMoreFriendsUI";
            String str5 = "shouldShowMiniProgram %s, openMiniProgramEntry %s";
            Object[] objArr3 = new Object[2];
            objArr3[0] = Boolean.valueOf(Cn);
            objArr3[1] = Boolean.valueOf(!Cn2);
            C4990ab.m7417i(str3, str5, objArr3);
            if (!Cn || Cn2) {
                this.yhb.mo27715ce("app_brand_entrance", true);
                if (!dwR()) {
                    C7060h.pYm.mo15419k(953, 9, 1);
                }
            } else {
                int i2;
                this.yhn++;
                this.yhb.mo27715ce("app_brand_entrance", false);
                iconPreference = (IconPreference) this.yhb.aqO("app_brand_entrance");
                if (c45360qp.cMI.cMM) {
                    i2 = 0;
                } else {
                    i2 = 8;
                }
                iconPreference.mo48763NL(i2);
                iconPreference.mo48774ey(getString(C25738R.string.f9181s0), C25738R.drawable.f6940w3);
                if (c45360qp.cMI.cML) {
                    i2 = 0;
                } else {
                    i2 = 8;
                }
                iconPreference.mo48765NN(i2);
            }
            Cn = C21098d.bGW();
            afj = m59236Cn(33554432);
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
            C4990ab.m7417i(str2, str3, objArr);
            if (!Cn || afj) {
                this.yhb.mo27715ce("ip_call_entrance", true);
            } else {
                int i3;
                this.yhn++;
                this.yhb.mo27715ce("ip_call_entrance", false);
                iconPreference = (IconPreference) this.yhb.aqO("ip_call_entrance");
                C9638aw.m17190ZK();
                if (((Integer) C18628c.m29072Ry().get(C5127a.USERFINO_IPCALL_HAS_ENTRY_FIND_REDDOT_INT, Integer.valueOf(0))).intValue() < C26373g.m41964Nu().getInt("WCOEntranceRedDot", 0)) {
                    iconPreference.mo48763NL(0);
                    iconPreference.mo48774ey(getString(C25738R.string.f9181s0), C25738R.drawable.f6940w3);
                } else {
                    iconPreference.mo48763NL(8);
                }
                iconPreference.mo48768NQ(8);
                C9638aw.m17190ZK();
                if (((Boolean) C18628c.m29072Ry().get(C5127a.USERFINO_IPCALL_HAS_ENTRY_FIND_REDDOT_NEWXML_BOOLEAN, Boolean.FALSE)).booleanValue()) {
                    iconPreference.mo48778qh(true);
                    iconPreference.mo48763NL(8);
                    i3 = 1;
                } else {
                    iconPreference.mo48778qh(false);
                    i3 = 0;
                }
                C9638aw.m17190ZK();
                str = (String) C18628c.m29072Ry().get(C5127a.USERFINO_IPCALL_HAS_ENTRY_FIND_WORDING_STRING, (Object) "");
                iconPreference.mo48771av(str, -1, -7566196);
                if (!C5046bo.isNullOrNil(str)) {
                    i3 = 1;
                }
                if (i3 != 0) {
                    iconPreference.mo48764NM(0);
                } else {
                    iconPreference.mo48764NM(8);
                }
                this.yhb.mo27708a(new PreferenceSmallCategory(getContext()), -1);
            }
            dwS();
            Cn = ((Boolean) C1720g.m3536RP().mo5239Ry().get(C5127a.MY_LIFE_AROUND_APP_FIND_MORE_PAGE_FIRST_EXPOSE_BOOLEAN, Boolean.TRUE)).booleanValue();
            C4990ab.m7411d("MicroMsg.FindMoreFriendsUI", "firstExposeFindMorePage: %s.", Boolean.valueOf(Cn));
            if (Cn) {
                C1720g.m3536RP().mo5239Ry().set(C5127a.MY_LIFE_AROUND_APP_FIND_MORE_PAGE_FIRST_EXPOSE_BOOLEAN, Boolean.FALSE);
            }
            bCS = ((C23167a) C1720g.m3528K(C23167a.class)).agO("labs_nearbylife");
            C4990ab.m7416i("MicroMsg.FindMoreFriendsUI", "updateMyLifeAroundEntrance isInExperiment: ".concat(String.valueOf(bCS)));
            if (bCS) {
                bCS = ((C23167a) C1720g.m3528K(C23167a.class)).mo38786xj("labs_nearbylife");
                C4990ab.m7416i("MicroMsg.FindMoreFriendsUI", "updateMyLifeAroundEntrance isOpen: ".concat(String.valueOf(bCS)));
                if (bCS) {
                    i = 1;
                    if (i == 0) {
                        iconPreference = (IconPreference) this.yhb.aqO("my_life_around");
                        iconPreference.setTitle((CharSequence) getString(C25738R.string.FF_Entry_Nearby));
                        this.yhn++;
                        if (Cn) {
                            C1720g.m3536RP().mo5239Ry().set(C5127a.MY_LIFE_AROUND_APP_NEW_RED_DOT_TAG_BOOLEAN, Boolean.FALSE);
                        } else if (((Boolean) C1720g.m3536RP().mo5239Ry().get(C5127a.MY_LIFE_AROUND_APP_NEW_RED_DOT_TAG_BOOLEAN, Boolean.TRUE)).booleanValue()) {
                            this.yhx = C30330a.TYPE_NEW_HINT;
                            iconPreference.mo48763NL(0);
                            iconPreference.mo48774ey(getString(C25738R.string.f9181s0), C25738R.drawable.f6940w3);
                        }
                        if (((Boolean) C1720g.m3536RP().mo5239Ry().get(C5127a.MY_LIFE_AROUND_APP_RED_DOT_TAG_BOOLEAN, Boolean.FALSE)).booleanValue()) {
                            str = (String) C1720g.m3536RP().mo5239Ry().get(C5127a.MY_LIFE_AROUND_APP_RED_DOT_TEXT_STRING, (Object) "");
                            str4 = (String) C1720g.m3536RP().mo5239Ry().get(C5127a.MY_LIFE_AROUND_APP_RED_DOT_IMG_URL_STRING, (Object) "");
                            m59261ij(str, str4);
                            switch (this.yhx) {
                                case TYPE_IMG_TEXT:
                                    C32291o.ahk();
                                    Bitmap kR = C17937c.m28186kR(str4);
                                    if (kR != null) {
                                        this.yhw = null;
                                        iconPreference.mo48770ap(C5056d.m7616a(kR, false, ((float) kR.getWidth()) * 0.1f));
                                    } else {
                                        this.yhw = str4;
                                        C32291o.aho().mo53003a(str4, this.yhA);
                                    }
                                    iconPreference.mo48771av(str, -1, Color.parseColor("#8c8c8c"));
                                    FindMoreFriendsUI.m59246a(iconPreference, 8, 0, false, 0, 0, 0);
                                    break;
                                case TYPE_IMG:
                                    C32291o.ahk();
                                    Bitmap kR2 = C17937c.m28186kR(str4);
                                    if (kR2 != null) {
                                        this.yhw = null;
                                        iconPreference.mo48770ap(C5056d.m7616a(kR2, false, ((float) kR2.getWidth()) * 0.1f));
                                    } else {
                                        this.yhw = str4;
                                        C32291o.aho().mo53003a(str4, this.yhA);
                                    }
                                    FindMoreFriendsUI.m59246a(iconPreference, 8, 8, false, 0, 0, 0);
                                    break;
                                case TYPE_TEXT:
                                    iconPreference.mo48771av(str, -1, Color.parseColor("#8c8c8c"));
                                    FindMoreFriendsUI.m59246a(iconPreference, 8, 0, true, 8, 8, 8);
                                    break;
                                case TYPE_NORMAL:
                                    FindMoreFriendsUI.m59246a(iconPreference, 0, 8, false, 8, 8, 8);
                                    break;
                            }
                        }
                        FindMoreFriendsUI.m59246a(iconPreference, 8, 8, false, 8, 8, 8);
                        this.yhb.mo27715ce("my_life_around", false);
                        C7060h.pYm.mo8381e(17065, Integer.valueOf(0), Long.valueOf(C5046bo.anT()), Integer.valueOf(this.yhx.ordinal()), C1720g.m3536RP().mo5239Ry().get(C5127a.MY_LIFE_AROUND_APP_RED_DOT_IMG_URL_STRING, (Object) ""), C1720g.m3536RP().mo5239Ry().get(C5127a.MY_LIFE_AROUND_APP_RED_DOT_TEXT_STRING, (Object) ""), C1720g.m3536RP().mo5239Ry().get(C5127a.MY_LIFE_AROUND_APP_RED_DOT_TYPE_STRING, AppEventsConstants.EVENT_PARAM_VALUE_NO));
                    } else {
                        this.yhb.mo27715ce("my_life_around", true);
                    }
                    C17950b.ahN();
                    this.yhb.mo27715ce("find_friends_by_facebook", true);
                    this.yhb.mo27715ce("settings_emoji_store", true);
                    if (this.yhn == 0) {
                        ViewGroup viewGroup = (ViewGroup) findViewById(16908298).getParent();
                        if (this.yho == null) {
                            this.yho = getContext().getLayoutInflater().inflate(2130969558, null);
                            this.yhp = (TextView) this.yho.findViewById(2131824038);
                            this.yhp.setOnClickListener(new C303298());
                            viewGroup.addView(this.yho, new LayoutParams(-1, -1));
                        } else {
                            this.yho.setVisibility(0);
                        }
                    }
                    this.yhb.notifyDataSetChanged();
                    if (!dwR()) {
                        C1720g.m3536RP().mo5239Ry().set(C5127a.FIND_MORE_UI_ENTRY_LAST_REPORT_TIME_LONG_SYNC, Long.valueOf(this.yha));
                    }
                    AppMethodBeat.m2505o(29257);
                    return;
                }
            }
            i = 0;
            if (i == 0) {
            }
            C17950b.ahN();
            this.yhb.mo27715ce("find_friends_by_facebook", true);
            this.yhb.mo27715ce("settings_emoji_store", true);
            if (this.yhn == 0) {
            }
            this.yhb.notifyDataSetChanged();
            if (dwR()) {
            }
            AppMethodBeat.m2505o(29257);
            return;
        }
        AppMethodBeat.m2505o(29257);
    }

    /* renamed from: pD */
    private void m59270pD(boolean z) {
        String value;
        boolean z2;
        AppMethodBeat.m2504i(29258);
        if (C4988aa.doo()) {
            value = C26373g.m41964Nu().getValue("JDEntranceConfigName");
        } else if (C4988aa.dop()) {
            value = C26373g.m41964Nu().getValue("JDEntranceConfigNameHKTW");
        } else {
            value = C26373g.m41964Nu().getValue("JDEntranceConfigNameEN");
        }
        String value2 = C26373g.m41964Nu().getValue("JDEntranceConfigIconUrl");
        C14834b c14834b = C44044f.vdy;
        if (c14834b != null) {
            String cDA = c14834b.cDA();
            if (!C5046bo.isNullOrNil(value) && !C5046bo.isNullOrNil(value2) && !C5046bo.isNullOrNil(cDA)) {
                String str;
                CharSequence charSequence;
                this.yhn++;
                C22336b c22336b = (C22336b) c14834b.cDB();
                Object charSequence2;
                if (!c22336b.cDk() || c22336b.cDl()) {
                    str = value2;
                    charSequence2 = value;
                } else {
                    if (C5046bo.isNullOrNil(c22336b.iconUrl)) {
                        str = value2;
                    } else {
                        str = c22336b.iconUrl;
                    }
                    if (C5046bo.isNullOrNil(c22336b.title)) {
                        charSequence2 = value;
                    } else {
                        charSequence2 = c22336b.title;
                    }
                }
                IconPreference iconPreference = (IconPreference) this.yhb.aqO("jd_market_entrance");
                C32291o.ahk();
                C17937c.m28186kR(str);
                iconPreference.setTitle(charSequence2);
                iconPreference.mo48763NL(8);
                iconPreference.mo48765NN(8);
                iconPreference.mo48764NM(8);
                iconPreference.mo48778qh(false);
                iconPreference.mo48768NQ(8);
                if (c14834b.cDs() && c22336b.isStart() && !c22336b.bxX()) {
                    if (!C5046bo.isNullOrNil(c22336b.ssu)) {
                        iconPreference.mo48763NL(8);
                        iconPreference.mo48765NN(8);
                        iconPreference.mo48771av(c22336b.ssu, -1, -7566196);
                        iconPreference.mo48764NM(0);
                    }
                    if (!C5046bo.isNullOrNil(c22336b.ssv)) {
                        C32291o.ahk();
                        Bitmap kR = C17937c.m28186kR(c22336b.ssv);
                        iconPreference.mo48768NQ(0);
                        iconPreference.mo48767NP(0);
                        iconPreference.mo48769NR(0);
                        iconPreference.mo48778qh(false);
                        if (kR != null) {
                            this.yhj = null;
                            iconPreference.mo48770ap(kR);
                        } else {
                            C32291o.aho().mo53003a(c22336b.ssv, this.yhA);
                            this.yhj = c22336b.ssv;
                        }
                    } else if (!C5046bo.isNullOrNil(c22336b.ssu)) {
                        iconPreference.mo48778qh(true);
                    } else if (c22336b.sst) {
                        iconPreference.mo48765NN(0);
                        iconPreference.mo48774ey("", -1);
                        iconPreference.mo48763NL(8);
                    }
                }
                if (z) {
                    this.yhb.notifyDataSetChanged();
                }
                if (!dwR()) {
                    C7060h.pYm.mo15419k(931, 12, 1);
                    C7060h.pYm.mo8381e(11178, cDA, c14834b.cDB().cDm(), Integer.valueOf(FindMoreFriendsUI.dwT()));
                }
                z2 = false;
                this.yhb.mo27715ce("jd_market_entrance", z2);
                AppMethodBeat.m2505o(29258);
            } else if (!dwR() && C4988aa.doo()) {
                if (C5046bo.isNullOrNil(value)) {
                    C7060h.pYm.mo15419k(931, 2, 1);
                }
                if (C5046bo.isNullOrNil(value2)) {
                    C7060h.pYm.mo15419k(931, 3, 1);
                }
                if (C5046bo.isNullOrNil(cDA)) {
                    C7060h.pYm.mo15419k(931, 4, 1);
                }
            }
        }
        z2 = true;
        this.yhb.mo27715ce("jd_market_entrance", z2);
        AppMethodBeat.m2505o(29258);
    }

    private static int dwT() {
        AppMethodBeat.m2504i(29259);
        int i = 1;
        C14834b c14834b = C44044f.vdy;
        if (c14834b != null) {
            C14833a cDB = c14834b.cDB();
            if (c14834b.cDs() && cDB.isStart() && !cDB.bxX()) {
                if (TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL.equals(cDB.cDp()) && !C5046bo.isNullOrNil(cDB.cDq())) {
                    i = 6;
                } else if (!C5046bo.isNullOrNil(cDB.cDn())) {
                    i = 3;
                } else if (cDB.cDo()) {
                    i = 2;
                }
            }
        }
        AppMethodBeat.m2505o(29259);
        return i;
    }

    /* renamed from: a */
    public final boolean mo48649a(C15541f c15541f, Preference preference, View view) {
        AppMethodBeat.m2504i(29260);
        if (C5058f.IS_FLAVOR_RED && "app_brand_entrance".equals(preference.mKey)) {
            ((C19731g) C1720g.m3528K(C19731g.class)).mo34964b(getContext(), 1, true);
            AppMethodBeat.m2505o(29260);
            return true;
        }
        boolean a = super.mo48649a(c15541f, preference, view);
        AppMethodBeat.m2505o(29260);
        return a;
    }

    /* renamed from: a */
    public final boolean mo48648a(C15541f c15541f, Preference preference) {
        AppMethodBeat.m2504i(29261);
        Intent intent;
        IconPreference iconPreference;
        String bc;
        Intent intent2;
        String str;
        String optString;
        if ("album_dyna_photo_ui_title".equals(preference.mKey)) {
            C34830g.m57194BN(10);
            C9638aw.m17190ZK();
            this.yhd = (String) C18628c.m29072Ry().get(68377, null);
            intent = new Intent();
            C37952b c37952b = new C37952b(701, 1);
            c37952b.mo60718cS(!C5046bo.isNullOrNil(this.yhd));
            c37952b.mo60722tx(this.yhe);
            intent.putExtra("sns_timeline_NeedFirstLoadint", true);
            intent.putExtra("is_from_find_more", true);
            String str2 = "enter_by_red";
            boolean z = !C5046bo.isNullOrNil(this.yhd) || this.yhe > 0;
            intent.putExtra(str2, z);
            C9638aw.m17190ZK();
            intent.putExtra("is_sns_notify_open", C5046bo.m7517a((Boolean) C18628c.m29072Ry().get(68384, null), true));
            intent.putExtra("sns_unread_count", C21877n.qFz.baS());
            if (!C5046bo.isNullOrNil(this.yhd)) {
                C9638aw.m17190ZK();
                intent.putExtra("new_feed_id", C5046bo.m7532bc((String) C18628c.m29072Ry().get(68418, null), ""));
                C9638aw.m17190ZK();
                C21902f.m33470k(3, (String) C18628c.m29072Ry().get(68418, (Object) ""), this.yhe);
            }
            c37952b.mo60717b(intent, "enter_log");
            C32572ib c32572ib = new C32572ib();
            C4879a.xxA.mo10055m(c32572ib);
            z = true;
            if (!c32572ib.cDa.isResume) {
                if (!C5046bo.isNullOrNil(this.yhd)) {
                    z = false;
                }
                if (C21877n.qFz != null) {
                    this.yhe = C21877n.qFz.baS();
                    if (this.yhe > 0) {
                        z = false;
                    }
                }
                C9638aw.m17190ZK();
                C18628c.m29072Ry().set(68377, (Object) "");
            }
            C9638aw.m17190ZK();
            C18628c.m29072Ry().set(589825, Boolean.FALSE);
            intent.putExtra("sns_resume_state", z);
            C25985d.m41467b(getContext(), "sns", ".ui.SnsTimeLineUI", intent);
            C7060h.pYm.mo8374X(10958, "1");
            new C7306ak().postDelayed(new C3032310(), 500);
            AppMethodBeat.m2505o(29261);
            return true;
        } else if ("find_friends_by_near".equals(preference.mKey)) {
            if (!C17950b.m28216sO((String) C1720g.m3536RP().mo5239Ry().get(274436, null))) {
                C4990ab.m7417i("MicroMsg.FindMoreFriendsUI", "summerper checkPermission checkLocation[%b]", Boolean.valueOf(C35805b.m58707a(thisActivity(), "android.permission.ACCESS_COARSE_LOCATION", 66, null, null)));
                if (!C35805b.m58707a(thisActivity(), "android.permission.ACCESS_COARSE_LOCATION", 66, null, null)) {
                    AppMethodBeat.m2505o(29261);
                    return true;
                }
            } else if (!C35805b.m58714o(thisActivity(), "android.permission.ACCESS_COARSE_LOCATION")) {
                if (((Boolean) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_GDPR_LOCATION_PERMISSION_DESCRIBE_CONFIRM_BOOLEAN_SYNC, Boolean.FALSE)).booleanValue()) {
                    C35805b.m58709b(getActivity(), "android.permission.ACCESS_COARSE_LOCATION", 66);
                } else {
                    C32921a.m53856b(thisActivity(), getString(C25738R.string.g7p, C4988aa.dor()), 30764, true);
                }
                AppMethodBeat.m2505o(29261);
                return true;
            }
            dwU();
            AppMethodBeat.m2505o(29261);
            return true;
        } else if ("find_friends_by_shake".equals(preference.mKey)) {
            Boolean bool;
            if (!this.yhk && C1853r.m3852Zf().booleanValue()) {
                iconPreference = (IconPreference) c15541f.aqO("find_friends_by_shake");
                if (iconPreference != null) {
                    iconPreference.mo48765NN(8);
                    C9638aw.m17190ZK();
                    C18628c.m29072Ry().set(340231, Boolean.TRUE);
                    C9638aw.m17190ZK();
                    C18628c.m29072Ry().dsb();
                    C7060h.pYm.mo8378a(232, 4, 1, false);
                }
            }
            C7060h.pYm.mo8374X(10958, TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL);
            C9638aw.m17190ZK();
            bc = C5046bo.m7532bc((String) C18628c.m29072Ry().get(C5127a.USERINFO_IBEACON_PUSH_BEACONINFO_STRING, null), "");
            C9638aw.m17190ZK();
            if (!C5046bo.m7517a((Boolean) C18628c.m29072Ry().get(C5127a.USERINFO_IBEACON_PUSH_IS_OPEN_BOOLEAN, null), false) || bc == null || bc.equals("")) {
                bool = Boolean.FALSE;
            } else {
                bool = Boolean.TRUE;
            }
            if (bool.booleanValue()) {
                C7060h.pYm.mo8381e(12653, Integer.valueOf(2), Integer.valueOf(2));
            }
            C4879a.xxA.mo10055m(new C32604oh());
            C25985d.m41448H(getContext(), "shake", ".ui.ShakeReportUI");
            AppMethodBeat.m2505o(29261);
            return true;
        } else if ("find_friends_by_qrcode".equals(preference.mKey)) {
            C16112c.m24429PK().mo28554c(C5127a.NEW_BANDAGE_DATASOURCE_TRANSLATION_RED_DOT_STRING_SYNC, C5127a.NEW_BANDAGE_WATCHER_SCAN_ENTRY_RED_DOT_STRING_SYNC);
            if (!C35973a.m59178bI(getContext())) {
                getContext();
                if (!C17981e.akI()) {
                    C7060h.pYm.mo8374X(10958, "2");
                    intent2 = new Intent();
                    intent2.putExtra("BaseScanUI_qrcode_right_btn_direct_album", true);
                    C7060h.pYm.mo8381e(11265, Integer.valueOf(2));
                    C25985d.m41467b(getContext(), "scanner", ".ui.BaseScanUI", intent2);
                    AppMethodBeat.m2505o(29261);
                    return true;
                }
            }
            AppMethodBeat.m2505o(29261);
            return true;
        } else if (preference.mKey.equals("more_tab_game_recommend")) {
            C7060h.pYm.mo8374X(10958, "6");
            C7060h.pYm.mo8378a(848, 2, 1, false);
            C9638aw.m17190ZK();
            if (C18628c.isSDCardAvailable()) {
                intent = new Intent();
                intent.putExtra("from_find_more_friend", this.yhm);
                intent.putExtra("game_report_from_scene", 901);
                if (this.yhm) {
                    C9419mz c9419mz = new C9419mz();
                    C4879a.xxA.mo10055m(c9419mz);
                    iconPreference = (IconPreference) c15541f.aqO("more_tab_game_recommend");
                    if (!(c9419mz.cIX.cIY == null || iconPreference == null)) {
                        C32291o.ahp().mo43772b(c9419mz.cIX.cIY, iconPreference.dAz());
                    }
                }
                C4990ab.m7416i("MicroMsg.FindMoreFriendsUI", "start game center index, time : " + System.currentTimeMillis());
                intent.putExtra("start_time", System.currentTimeMillis());
                C25985d.m41467b(getContext(), "game", ".ui.GameCenterUI", intent);
                AppMethodBeat.m2505o(29261);
                return true;
            }
            C23639t.m36492hO(getContext());
            AppMethodBeat.m2505o(29261);
            return true;
        } else if ("find_friends_by_micromsg".equals(preference.mKey)) {
            C25985d.m41467b(getContext(), "subapp", ".ui.pluginapp.ContactSearchUI", new Intent());
            AppMethodBeat.m2505o(29261);
            return true;
        } else if ("find_friends_by_mobile".equals(preference.mKey)) {
            if (C38033l.apS() != C38034a.SUCC) {
                intent2 = new Intent(getContext(), BindMContactIntroUI.class);
                intent2.putExtra("key_upload_scene", 6);
                MMWizardActivity.m23791J(getContext(), intent2);
                AppMethodBeat.m2505o(29261);
                return true;
            }
            startActivity(new Intent(getContext(), MobileFriendUI.class));
            AppMethodBeat.m2505o(29261);
            return true;
        } else if ("find_friends_by_facebook".equals(preference.mKey)) {
            startActivity(new Intent(getContext(), FacebookFriendUI.class));
            AppMethodBeat.m2505o(29261);
            return true;
        } else if ("settings_mm_card_package".equals(preference.mKey)) {
            C4990ab.m7416i("MicroMsg.FindMoreFriendsUI", "enter to cardhome");
            C18296ik c18296ik = new C18296ik();
            c18296ik.cDz.context = getContext();
            C4879a.xxA.mo10055m(c18296ik);
            AppMethodBeat.m2505o(29261);
            return true;
        } else if (preference.mKey.equals("jd_market_entrance")) {
            Object obj = null;
            C14991i.m23324Lt(9);
            C14834b c14834b = C44044f.vdy;
            if (c14834b != null) {
                obj = C44044f.vdy.cDA();
                C7060h.pYm.mo8381e(11179, obj, c14834b.cDB().cDm(), Integer.valueOf(FindMoreFriendsUI.dwT()));
                c14834b.cDv();
                c14834b.cDu();
                ((IconPreference) preference).mo48774ey("", -1);
                if (!C5046bo.isNullOrNil(obj)) {
                    intent = new Intent();
                    intent.putExtra("rawUrl", obj);
                    intent.putExtra("useJs", true);
                    intent.putExtra("vertical_scroll", true);
                    intent.putExtra("minimize_secene", 1);
                    intent.putExtra("KPublisherId", "jd_store");
                    C25985d.m41467b(getContext(), "webview", ".ui.tools.WebViewUI", intent);
                }
            }
            C4990ab.m7416i("MicroMsg.FindMoreFriendsUI", "jump to url: ".concat(String.valueOf(obj)));
            AppMethodBeat.m2505o(29261);
            return true;
        } else if ("ip_call_entrance".equals(preference.mKey)) {
            iconPreference = (IconPreference) c15541f.aqO("ip_call_entrance");
            iconPreference.mo48765NN(8);
            iconPreference.mo48764NM(8);
            iconPreference.mo48778qh(false);
            iconPreference.mo48768NQ(8);
            Object obj2 = null;
            C9638aw.m17190ZK();
            str = (String) C18628c.m29072Ry().get(C5127a.USERFINO_IPCALL_HAS_ENTRY_FIND_WORDING_STRING, (Object) "");
            C9638aw.m17190ZK();
            if (((Boolean) C18628c.m29072Ry().get(C5127a.USERFINO_IPCALL_HAS_ENTRY_FIND_REDDOT_NEWXML_BOOLEAN, Boolean.FALSE)).booleanValue()) {
                C3307i.m5626Z(1, -1, -1);
                C9638aw.m17190ZK();
                C18628c.m29072Ry().set(C5127a.USERFINO_IPCALL_HAS_ENTRY_FIND_REDDOT_NEWXML_BOOLEAN, Boolean.FALSE);
                obj2 = 1;
            }
            C9638aw.m17190ZK();
            if (((Integer) C18628c.m29072Ry().get(C5127a.USERFINO_IPCALL_HAS_ENTRY_FIND_REDDOT_INT, Integer.valueOf(0))).intValue() < C26373g.m41964Nu().getInt("WCOEntranceRedDot", 0)) {
                obj2 = 1;
                C7060h.pYm.mo8381e(13254, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(-1), Integer.valueOf(-1), Integer.valueOf(-1));
                C9638aw.m17190ZK();
                C18628c.m29072Ry().set(C5127a.USERFINO_IPCALL_HAS_ENTRY_FIND_REDDOT_INT, Integer.valueOf(C26373g.m41964Nu().getInt("WCOEntranceRedDot", 0)));
            }
            if (!C5046bo.isNullOrNil(str)) {
                C9638aw.m17190ZK();
                C18628c.m29072Ry().set(C5127a.USERFINO_IPCALL_HAS_ENTRY_FIND_WORDING_STRING, (Object) "");
            }
            if (obj2 != null) {
                C4879a.xxA.mo10055m(new C6552to());
            }
            if (C35973a.m59176Oo()) {
                C30379h.m48432a(getContext(), (int) C25738R.string.d2o, 0, null, null);
            } else {
                C7060h.pYm.mo8381e(12061, Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0));
                C25985d.m41467b(getContext(), "ipcall", ".ui.IPCallAddressUI", new Intent());
            }
            AppMethodBeat.m2505o(29261);
            return true;
        } else if ("app_brand_entrance".equals(preference.mKey)) {
            ((C19731g) C1720g.m3528K(C19731g.class)).mo34964b(getContext(), 1, false);
            AppMethodBeat.m2505o(29261);
            return true;
        } else if ("find_friends_by_search".equals(preference.mKey)) {
            if (C46400aa.m87304HU(0)) {
                optString = C29736ac.adL("discoverSearchEntry").optString("wording");
                if (C5046bo.isNullOrNil(optString)) {
                    C4990ab.m7412e("MicroMsg.FindMoreFriendsUI", "empty title");
                } else {
                    C4514am cVt = C4514am.cVt();
                    cVt.uaS = new C4515a();
                    cVt.save();
                    ((C23167a) C1720g.m3528K(C23167a.class)).open("labs1de6f3");
                    C14423an.m22656l("", 0, 0, 20);
                    String HP = C46400aa.m87299HP(20);
                    str = C29833g.cYC().cWl();
                    HashMap hashMap = new HashMap();
                    hashMap.put("sessionId", HP);
                    hashMap.put("inputMarginTop", "32");
                    hashMap.put("inputMarginLeftRight", "24");
                    hashMap.put("inputHeight", "48");
                    if (!(str == null || str.isEmpty())) {
                        hashMap.put("educationTab", Uri.encode(str));
                    }
                    hashMap.put("clickType", "15");
                    ((C22757j) C1720g.m3528K(C22757j.class)).mo38339b(getContext(), 20, "", HP, hashMap, optString);
                    ((C20015c) C1720g.m3528K(C20015c.class)).mo6743rT(C27502b.jJt);
                }
            } else {
                C4990ab.m7412e("MicroMsg.FindMoreFriendsUI", "fts h5 template not avail");
            }
            AppMethodBeat.m2505o(29261);
            return true;
        } else if ("find_friends_by_look".equals(preference.mKey)) {
            if (C46400aa.m87304HU(1)) {
                bc = C29736ac.adL("discoverRecommendEntry").optString("wording");
                if (C5046bo.isNullOrNil(bc)) {
                    C4990ab.m7412e("MicroMsg.FindMoreFriendsUI", "empty query");
                } else {
                    C4990ab.m7416i("MicroMsg.FindMoreFriendsUI", "look one look clikced");
                    C4210c.m6554W(getContext(), 21);
                    ((C23167a) C1720g.m3528K(C23167a.class)).open("labs_browse");
                    C26190ll c26190ll = new C26190ll();
                    c26190ll.cHk.scene = 0;
                    C4879a.xxA.mo10055m(c26190ll);
                    C14423an.m22652bz(21, bc);
                    C14423an.reportIdKey649ForLook(21, 0);
                    if (C46400aa.m87305HV(1) > C46400aa.m87303HT(1)) {
                        C14423an.reportIdKey649ForLook(21, 15);
                    } else {
                        C14423an.reportIdKey649ForLook(21, 14);
                    }
                }
            } else {
                C4990ab.m7412e("MicroMsg.FindMoreFriendsUI", "fts h5 template not avail");
            }
            AppMethodBeat.m2505o(29261);
            return true;
        } else if ("my_life_around".equals(preference.mKey)) {
            C7060h.pYm.mo8381e(17065, Integer.valueOf(1), Long.valueOf(C5046bo.anT()), Integer.valueOf(this.yhx.ordinal()), C1720g.m3536RP().mo5239Ry().get(C5127a.MY_LIFE_AROUND_APP_RED_DOT_IMG_URL_STRING, (Object) ""), C1720g.m3536RP().mo5239Ry().get(C5127a.MY_LIFE_AROUND_APP_RED_DOT_TEXT_STRING, (Object) ""), C1720g.m3536RP().mo5239Ry().get(C5127a.MY_LIFE_AROUND_APP_RED_DOT_TYPE_STRING, AppEventsConstants.EVENT_PARAM_VALUE_NO));
            if (this.yhx.equals(C30330a.TYPE_NEW_HINT)) {
                C1720g.m3536RP().mo5239Ry().set(C5127a.MY_LIFE_AROUND_APP_NEW_RED_DOT_TAG_BOOLEAN, Boolean.FALSE);
                this.yhx = C30330a.TYPE_NONE;
                iconPreference = (IconPreference) this.yhb.aqO("my_life_around");
                iconPreference.mo48763NL(8);
                iconPreference.mo48774ey("", -1);
            }
            boolean booleanValue = ((Boolean) C1720g.m3536RP().mo5239Ry().get(C5127a.MY_LIFE_AROUND_APP_RED_DOT_TAG_BOOLEAN, Boolean.FALSE)).booleanValue();
            ((C23167a) C1720g.m3528K(C23167a.class)).open("labs_nearbylife");
            String agP = ((C23167a) C1720g.m3528K(C23167a.class)).agP("labs_nearbylife");
            int agQ = ((C23167a) C1720g.m3528K(C23167a.class)).agQ("labs_nearbylife");
            AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
            appBrandStatObject.scene = FaceManager.FACE_ACQUIRED_BRIGHT;
            optString = null;
            C4990ab.m7411d("MicroMsg.FindMoreFriendsUI", "withRedTag: %d.", Integer.valueOf(C26373g.m41964Nu().getInt("LifeAppEntranceBringRedDot", 0)));
            if (C26373g.m41964Nu().getInt("LifeAppEntranceBringRedDot", 0) != 0 && booleanValue) {
                optString = "?hasRedDot=true";
            }
            ((C45691e) C1720g.m3528K(C45691e.class)).mo68045a(getContext(), agP, null, agQ, 0, optString, appBrandStatObject);
            AppMethodBeat.m2505o(29261);
            return true;
        } else {
            AppMethodBeat.m2505o(29261);
            return false;
        }
    }

    public final void dwU() {
        AppMethodBeat.m2504i(29262);
        C7060h.pYm.mo8374X(10958, "4");
        C9638aw.m17190ZK();
        if (C5046bo.m7546e((Boolean) C18628c.m29072Ry().get(4103, null))) {
            C32782bp aap = C32782bp.aap();
            if (aap == null) {
                C25985d.m41448H(getContext(), "nearby", ".ui.NearbyPersonalInfoUI");
                AppMethodBeat.m2505o(29262);
                return;
            }
            String nullAsNil = C5046bo.nullAsNil(aap.getProvince());
            int a = C5046bo.m7512a(Integer.valueOf(aap.dtS), 0);
            if (C5046bo.isNullOrNil(nullAsNil) || a == 0) {
                C25985d.m41448H(getContext(), "nearby", ".ui.NearbyPersonalInfoUI");
                AppMethodBeat.m2505o(29262);
                return;
            }
            C9638aw.m17190ZK();
            Boolean bool = (Boolean) C18628c.m29072Ry().get(4104, null);
            if (bool == null || !bool.booleanValue()) {
                LauncherUI launcherUI = (LauncherUI) getContext();
                if (launcherUI != null) {
                    launcherUI.yjJ.getMainTabUI().aqG("tab_find_friend");
                }
                C9089a.m16479fy(getContext());
                AppMethodBeat.m2505o(29262);
                return;
            }
            dwV();
            AppMethodBeat.m2505o(29262);
            return;
        }
        C25985d.m41448H(getContext(), "nearby", ".ui.NearbyFriendsIntroUI");
        AppMethodBeat.m2505o(29262);
    }

    private void dwV() {
        AppMethodBeat.m2504i(29263);
        if (this.yhc == null) {
            this.yhc = View.inflate(getContext(), 2130969930, null);
            this.oPS = (CheckBox) this.yhc.findViewById(2131825250);
            this.oPS.setChecked(false);
        }
        if (this.oPU == null) {
            this.oPU = C30379h.m48436a(getContext(), getString(C25738R.string.f9238tz), this.yhc, new C1545711(), null);
            AppMethodBeat.m2505o(29263);
            return;
        }
        this.oPU.show();
        AppMethodBeat.m2505o(29263);
    }

    private void dwW() {
        AppMethodBeat.m2504i(29264);
        if (((IconPreference) this.yhb.aqO("more_tab_game_recommend")) == null) {
            AppMethodBeat.m2505o(29264);
            return;
        }
        C7305d.post(new C3601213(), "updateGame");
        AppMethodBeat.m2505o(29264);
    }

    /* renamed from: a */
    private synchronized void m59242a(C9419mz c9419mz, IconPreference iconPreference, C9419mz c9419mz2, String str) {
        AppMethodBeat.m2504i(29265);
        String str2 = c9419mz.cIX.cIY;
        int i = c9419mz.cIX.cIZ;
        int i2 = c9419mz.cIX.cJa;
        if (C5046bo.isNullOrNil(str2) || iconPreference == null || iconPreference.dAz() == null) {
            AppMethodBeat.m2505o(29265);
        } else {
            C4990ab.m7417i("MicroMsg.FindMoreFriendsUI", "download entrance image : %s, width: %d, height: %d", str2, Integer.valueOf(i), Integer.valueOf(i2));
            if (i > 0 && i2 > 0) {
                iconPreference.mo48777hn(C1338a.fromDPToPix(C4996ah.getContext(), i), C1338a.fromDPToPix(C4996ah.getContext(), i));
            }
            final String str3 = c9419mz2.cIX.cJb;
            final String str4 = c9419mz2.cIX.appId;
            final int i3 = c9419mz2.cIX.msgType;
            final String str5 = c9419mz2.cIX.ctu;
            final int i4 = c9419mz2.cIX.showType;
            final C37725gz c37725gz = new C37725gz();
            c37725gz.cBH.f13665Cn = 1;
            c37725gz.cBH.url = str2;
            C4879a.xxA.mo10055m(c37725gz);
            if (c37725gz.cBI.cBK) {
                String str6 = c37725gz.cBI.cBJ + C1178g.m2591x(str2.getBytes());
                C17927a c17927a = new C17927a();
                c17927a.ePH = true;
                c17927a.ePJ = str6;
                C25814c ahG = c17927a.ahG();
                final IconPreference iconPreference2 = iconPreference;
                final String str7 = str;
                C32291o.ahp().mo43769a(str2, iconPreference.dAz(), ahG, new C1282i() {
                    /* renamed from: a */
                    public final void mo4581a(String str, View view, Bitmap bitmap, Object... objArr) {
                        AppMethodBeat.m2504i(29226);
                        c37725gz.cBH.f13665Cn = 2;
                        c37725gz.cBH.url = str;
                        C4879a.xxA.mo10055m(c37725gz);
                        AppMethodBeat.m2505o(29226);
                    }
                }, new C9014g() {

                    /* renamed from: com.tencent.mm.ui.FindMoreFriendsUI$15$1 */
                    class C303251 implements Runnable {
                        C303251() {
                        }

                        public final void run() {
                            AppMethodBeat.m2504i(29227);
                            FindMoreFriendsUI.this.yhm = false;
                            FindMoreFriendsUI.m59251b((IconPreference) FindMoreFriendsUI.this.yhb.aqO("more_tab_game_recommend"), 8, 8, false, 8, 8, 8);
                            AppMethodBeat.m2505o(29227);
                        }
                    }

                    /* renamed from: sH */
                    public final void mo7596sH(String str) {
                        AppMethodBeat.m2504i(29230);
                        C5004al.m7441d(new C303251());
                        AppMethodBeat.m2505o(29230);
                    }

                    /* renamed from: a */
                    public final Bitmap mo7594a(String str, View view, C37477b c37477b) {
                        return null;
                    }

                    /* renamed from: b */
                    public final void mo7595b(String str, View view, C37477b c37477b) {
                        AppMethodBeat.m2504i(29231);
                        c37725gz.cBH.f13665Cn = 2;
                        c37725gz.cBH.url = str;
                        C4879a.xxA.mo10055m(c37725gz);
                        if (c37477b == null) {
                            AppMethodBeat.m2505o(29231);
                            return;
                        }
                        final int i = c37477b.from;
                        if (c37477b.status != 0 || c37477b.bitmap == null) {
                            C5004al.m7441d(new Runnable() {
                                public final void run() {
                                    AppMethodBeat.m2504i(29229);
                                    FindMoreFriendsUI.this.yhm = true;
                                    IconPreference iconPreference = (IconPreference) FindMoreFriendsUI.this.yhb.aqO("more_tab_game_recommend");
                                    if (i4 == 3) {
                                        iconPreference.mo48774ey(FindMoreFriendsUI.this.getString(C25738R.string.f9181s0), C25738R.drawable.f6940w3);
                                        FindMoreFriendsUI.m59251b(iconPreference, 0, 8, false, 8, 8, 8);
                                        FindMoreFriendsUI.m59254c(str4, i3, str3, str5, 1);
                                    } else if (i4 == 4) {
                                        iconPreference.mo48771av(str7, -1, Color.parseColor("#8c8c8c"));
                                        FindMoreFriendsUI.m59251b(iconPreference, 8, 0, true, 8, 8, 8);
                                        FindMoreFriendsUI.m59254c(str4, i3, str3, str5, 2);
                                    }
                                    C7060h.pYm.mo8378a(858, 12, 1, false);
                                    if (i == 2) {
                                        C7060h.pYm.mo8378a(858, 14, 1, false);
                                    }
                                    AppMethodBeat.m2505o(29229);
                                }
                            });
                            AppMethodBeat.m2505o(29231);
                            return;
                        }
                        final Bitmap bitmap = c37477b.bitmap;
                        C5004al.m7441d(new Runnable() {
                            public final void run() {
                                AppMethodBeat.m2504i(29228);
                                FindMoreFriendsUI.this.yhm = true;
                                iconPreference2.mo48770ap(bitmap);
                                if (i4 == 3) {
                                    FindMoreFriendsUI.m59251b(iconPreference2, 8, 8, false, 0, 0, 0);
                                } else if (i4 == 4) {
                                    FindMoreFriendsUI.m59251b(iconPreference2, 8, 0, false, 0, 0, 0);
                                }
                                FindMoreFriendsUI.m59254c(str4, i3, str3, str5, i4);
                                if (i == 2) {
                                    C7060h.pYm.mo8378a(858, 13, 1, false);
                                }
                                AppMethodBeat.m2505o(29228);
                            }
                        });
                        AppMethodBeat.m2505o(29231);
                    }
                });
            }
            AppMethodBeat.m2505o(29265);
        }
    }

    /* renamed from: b */
    private static void m59252b(String str, int i, String str2, String str3, int i2) {
        AppMethodBeat.m2504i(29266);
        C1720g.m3537RQ();
        String str4 = (String) C1720g.m3536RP().mo5239Ry().get(C5127a.GAME_FIND_MORE_FRIEND_MSG_ID_STRING_SYNC, (Object) "");
        if (!(str2 == null || str2.equals(str4))) {
            C1720g.m3537RQ();
            C1720g.m3536RP().mo5239Ry().set(C5127a.GAME_FIND_MORE_FRIEND_MSG_ID_STRING_SYNC, (Object) str2);
            C45351oj c45351oj = new C45351oj();
            c45351oj.cKF.scene = 9;
            c45351oj.cKF.cKG = 901;
            c45351oj.cKF.action = 1;
            c45351oj.cKF.appId = str;
            c45351oj.cKF.msgType = i;
            c45351oj.cKF.cJb = str2;
            c45351oj.cKF.ctu = str3;
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("function_type", "resource");
                jSONObject.put("function_value", String.valueOf(i2));
            } catch (JSONException e) {
                C4990ab.m7412e("MicroMsg.FindMoreFriendsUI", e.getMessage());
            }
            try {
                str4 = URLEncoder.encode(jSONObject.toString(), ProtocolPackage.ServerEncoding);
            } catch (UnsupportedEncodingException e2) {
                UnsupportedEncodingException unsupportedEncodingException = e2;
                str4 = "";
                C4990ab.m7412e("MicroMsg.FindMoreFriendsUI", unsupportedEncodingException.getMessage());
            }
            c45351oj.cKF.cKH = str4;
            C4879a.xxA.mo10055m(c45351oj);
            C7060h.pYm.mo8378a(858, 2, 1, false);
        }
        AppMethodBeat.m2505o(29266);
    }

    /* renamed from: pE */
    private static void m59271pE(boolean z) {
        AppMethodBeat.m2504i(29267);
        C20928a.bDb().mo36280hH(z);
        AppMethodBeat.m2505o(29267);
    }

    /* renamed from: ik */
    private String m59262ik(String str, String str2) {
        AppMethodBeat.m2504i(29268);
        if (C5046bo.isNullOrNil(str)) {
            str = C46494g.m87756t(getContext(), str2);
            AppMethodBeat.m2505o(29268);
            return str;
        }
        AppMethodBeat.m2505o(29268);
        return str;
    }

    /* renamed from: a */
    private static void m59245a(IconPreference iconPreference, int i, int i2, int i3, boolean z, int i4, int i5, int i6) {
        AppMethodBeat.m2504i(29269);
        iconPreference.mo48763NL(i);
        iconPreference.mo48765NN(i2);
        iconPreference.mo48764NM(i3);
        iconPreference.mo48778qh(z);
        iconPreference.mo48768NQ(i4);
        iconPreference.mo48767NP(i5);
        iconPreference.mo48769NR(i6);
        AppMethodBeat.m2505o(29269);
    }

    /* renamed from: Zx */
    public final void mo55684Zx() {
        AppMethodBeat.m2504i(29270);
        if ((C1853r.m3829YK() & 32768) != 0) {
            AppMethodBeat.m2505o(29270);
            return;
        }
        this.yhe++;
        dwX();
        this.yhb.notifyDataSetChanged();
        AppMethodBeat.m2505o(29270);
    }

    /* renamed from: Zy */
    public final void mo55685Zy() {
        AppMethodBeat.m2504i(29271);
        if ((C1853r.m3829YK() & 32768) != 0) {
            AppMethodBeat.m2505o(29271);
            return;
        }
        dwX();
        this.yhb.notifyDataSetChanged();
        AppMethodBeat.m2505o(29271);
    }

    /* renamed from: Zz */
    public final void mo55686Zz() {
    }

    /* renamed from: ZB */
    public final void mo5390ZB() {
        AppMethodBeat.m2504i(29272);
        if (this.yhb == null) {
            AppMethodBeat.m2505o(29272);
            return;
        }
        this.status = C1853r.m3822YD();
        aMk();
        AppMethodBeat.m2505o(29272);
    }

    /* Access modifiers changed, original: protected|final */
    public final void dvY() {
        AppMethodBeat.m2504i(29273);
        C4990ab.m7416i("MicroMsg.FindMoreFriendsUI", "on tab create");
        this.yhb = this.yCw;
        this.status = C1853r.m3822YD();
        this.qnE = C1853r.m3829YK();
        this.kFU = C1853r.m3823YE();
        final View findViewById = getView().getRootView().findViewById(2131820634);
        int de = C5230ak.m7987de(getContext());
        int J = C5230ak.m7984J(getContext(), -1);
        C303285 c303285 = new Runnable() {
            int eRu = 0;

            public final void run() {
                AppMethodBeat.m2504i(29211);
                if (FindMoreFriendsUI.this.getView() == null) {
                    AppMethodBeat.m2505o(29211);
                    return;
                }
                int de = C5230ak.m7987de(FindMoreFriendsUI.this.getContext());
                int J = C5230ak.m7984J(FindMoreFriendsUI.this.getContext(), -1);
                if (J <= 0) {
                    if (this.eRu < 2) {
                        C4990ab.m7416i("MicroMsg.FindMoreFriendsUI", "[trySetParentViewPadding] try getStatusHeight again!");
                        FindMoreFriendsUI.this.getView().post(this);
                    } else {
                        C4990ab.m7412e("MicroMsg.FindMoreFriendsUI", "[trySetParentViewPadding] try getStatusHeight finally!");
                    }
                    this.eRu++;
                } else {
                    int i = de + J;
                    if (i != FindMoreFriendsUI.this.getView().getPaddingTop()) {
                        C4990ab.m7417i("MicroMsg.FindMoreFriendsUI", "[trySetParentViewPadding] now:%s old:%s", Integer.valueOf(i), Integer.valueOf(FindMoreFriendsUI.this.getView().getPaddingTop()));
                        FindMoreFriendsUI.this.getView().setPadding(0, i, 0, findViewById.getHeight());
                    } else {
                        C4990ab.m7417i("MicroMsg.FindMoreFriendsUI", "[trySetParentViewPadding] has try more once! it's right! actionBarHeight:%s actionBarHeight:%s", Integer.valueOf(J), Integer.valueOf(de));
                    }
                }
                C4990ab.m7417i("MicroMsg.FindMoreFriendsUI", "[trySetParentViewPadding] tryCount:%s actionBarHeight:%s actionBarHeight:%s", Integer.valueOf(this.eRu), Integer.valueOf(J), Integer.valueOf(de));
                AppMethodBeat.m2505o(29211);
            }
        };
        if (J <= 0) {
            getView().post(c303285);
        } else {
            getView().setPadding(0, de + J, 0, findViewById.getHeight());
            C4990ab.m7417i("MicroMsg.FindMoreFriendsUI", "[trySetParentViewPadding] actionBarHeight:%s actionBarHeight:%s", Integer.valueOf(J), Integer.valueOf(de));
            getView().postDelayed(c303285, 100);
        }
        C4990ab.m7416i("MicroMsg.FindMoreFriendsUI", "on tab create end");
        AppMethodBeat.m2505o(29273);
    }

    /* Access modifiers changed, original: protected|final */
    public final void dvZ() {
        AppMethodBeat.m2504i(29274);
        C4990ab.m7416i("MicroMsg.FindMoreFriendsUI", "on tab resume");
        this.cCt = true;
        dxb();
        C40418a.m69321a(C32578jb.class.getName(), this.vqt);
        C40418a.m69321a(C45329gy.class.getName(), this.yht);
        C40418a.m69321a(C18377qm.class.getName(), this.yhu);
        C4879a.xxA.mo10052c(this.yhr);
        C4879a.xxA.mo10052c(this.yhq);
        C4879a.xxA.mo10052c(this.yhs);
        C4879a.xxA.mo10052c(this.qLL);
        C4879a.xxA.mo10052c(this.yhv);
        C4879a.xxA.mo10051b(this.mJI);
        C4879a.xxA.mo10052c(this.yhz);
        C41789d.akR().mo10116c(this);
        C9638aw.m17190ZK();
        C18628c.m29083XR().mo10118a(this);
        C9638aw.m17190ZK();
        C18628c.m29103a(this);
        C9638aw.m17190ZK();
        C18628c.m29072Ry().mo10118a(this);
        if (C21877n.qFB != null) {
            C21877n.qFB.mo25483a(this);
        }
        final View findViewById = findViewById(2131828206);
        if (!(findViewById == null || findViewById.getVisibility() == 8)) {
            new C7306ak(Looper.getMainLooper()).post(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(29232);
                    findViewById.setVisibility(8);
                    findViewById.startAnimation(AnimationUtils.loadAnimation(FindMoreFriendsUI.this.getContext(), C25738R.anim.f8333b6));
                    AppMethodBeat.m2505o(29232);
                }
            });
        }
        if (isAdded()) {
            C1314b.m2812HQ().mo4642o(new C3602217());
        }
        C4990ab.m7416i("MicroMsg.FindMoreFriendsUI", "on tab resume end");
        AppMethodBeat.m2505o(29274);
    }

    /* renamed from: Cn */
    private boolean m59236Cn(int i) {
        return (this.kFU & ((long) i)) != 0;
    }

    private void dwX() {
        AppMethodBeat.m2504i(29275);
        boolean z = (this.qnE & 32768) == 0;
        C4990ab.m7417i("MicroMsg.FindMoreFriendsUI", "openSns %s, plugin installed %s", Boolean.valueOf(z), Boolean.valueOf(C25985d.afj("sns")));
        if (!z) {
            if (C1720g.m3536RP().mo5239Ry().getInt(C5127a.USERINFO_SNS_ENTRY_SWITCH_INT, 0) == 1) {
                C4990ab.m7420w("MicroMsg.FindMoreFriendsUI", "opened sns entry recently");
                C7060h.pYm.mo15419k(150, 71, 1);
            } else if (C1720g.m3536RP().mo5239Ry().getInt(C5127a.USERINFO_SNS_ENTRY_SWITCH_INT, 0) == -1) {
                C4990ab.m7416i("MicroMsg.FindMoreFriendsUI", "closed sns entry recently");
                C7060h.pYm.mo15419k(150, 70, 1);
            }
        }
        if (z && r11) {
            this.yhn++;
            this.yhb.mo27715ce("album_dyna_photo_ui_title", false);
            FriendSnsPreference friendSnsPreference = (FriendSnsPreference) this.yhb.aqO("album_dyna_photo_ui_title");
            friendSnsPreference.drawable = C1338a.m2864g(getContext(), C1318a.icons_outlined_colorful_moment);
            C9638aw.m17190ZK();
            boolean e = C5046bo.m7546e((Boolean) C18628c.m29072Ry().get(48, null));
            friendSnsPreference.mo48763NL(8);
            friendSnsPreference.mo48769NR(8);
            if (e) {
                friendSnsPreference.mo48763NL(0);
                friendSnsPreference.mo48774ey(getString(C25738R.string.f9181s0), C25738R.drawable.f6940w3);
            }
            C9638aw.m17190ZK();
            this.yhd = (String) C18628c.m29072Ry().get(68377, null);
            if (!C5046bo.isNullOrNil(this.yhd) && LauncherUI.dxE() == 2) {
                C9638aw.m17190ZK();
                if (C18628c.m29072Ry().getInt(68419, 0) == 0) {
                    C1720g.m3537RQ();
                    C21902f.m33470k(2, (String) C1720g.m3536RP().mo5239Ry().get(68418, (Object) ""), this.yhe);
                    C9638aw.m17190ZK();
                    C18628c.m29072Ry().set(68419, Integer.valueOf(1));
                }
            }
            Object obj = C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_SNS_MEDIA_COLLAPSE_SNS_ID_LONG, null);
            long longValue = obj == null ? 0 : ((Long) obj).longValue();
            C4990ab.m7417i("MicroMsg.FindMoreFriendsUI", "newer snsobj %s", C5046bo.m7532bc(this.yhd, ""));
            friendSnsPreference.mo48768NQ(0);
            if (C5046bo.isNullOrNil(this.yhd)) {
                C9638aw.m17190ZK();
                if (((Boolean) C18628c.m29072Ry().get(589825, Boolean.FALSE)).booleanValue()) {
                    friendSnsPreference.mo48766NO(C1318a.net_warn_icon);
                    friendSnsPreference.mo48767NP(0);
                    friendSnsPreference.mo48769NR(8);
                } else if (longValue == 0 || !((C29034m) C1720g.m3528K(C29034m.class)).mo47121jM(longValue)) {
                    friendSnsPreference.mo48767NP(8);
                } else {
                    friendSnsPreference.mo48767NP(0);
                    friendSnsPreference.mo48769NR(0);
                    friendSnsPreference.mo10655mX(longValue);
                }
            } else {
                int i;
                friendSnsPreference.mo48767NP(0);
                C9638aw.m17190ZK();
                if (C5046bo.m7517a((Boolean) C18628c.m29072Ry().get(68384, null), true)) {
                    i = 0;
                } else {
                    i = 8;
                }
                friendSnsPreference.mo48769NR(i);
                friendSnsPreference.aqD(this.yhd);
            }
            if (C21877n.qFz != null) {
                this.yhe = C21877n.qFz.baS();
            }
            if (this.yhe != 0) {
                friendSnsPreference.mo48763NL(0);
                friendSnsPreference.mo48774ey(this.yhe, C44385r.m80243ik(getContext()));
            }
            friendSnsPreference.mo48765NN(8);
            friendSnsPreference.mo48764NM(8);
            C4879a.xxA.mo10055m(new C6552to());
            AppMethodBeat.m2505o(29275);
            return;
        }
        this.yhb.mo27715ce("album_dyna_photo_ui_title", true);
        if (!dwR()) {
            C7060h.pYm.mo15419k(953, 0, 1);
        }
        AppMethodBeat.m2505o(29275);
    }

    private void dwY() {
        AppMethodBeat.m2504i(29276);
        C4990ab.m7417i("MicroMsg.FindMoreFriendsUI", "openShake %s, plugin installed %s", Boolean.valueOf((this.qnE & 256) == 0), Boolean.valueOf(C25985d.afj("shake")));
        if (((this.qnE & 256) == 0) && r1) {
            boolean bY;
            this.yhn++;
            this.yhb.mo27715ce("find_friends_by_shake", false);
            IconPreference iconPreference = (IconPreference) this.yhb.aqO("find_friends_by_shake");
            int baS = C41789d.akR().baS() + C14896a.dgQ().cjL();
            if (baS > 0) {
                iconPreference.mo48763NL(0);
                iconPreference.mo48774ey(String.valueOf(baS), C25738R.drawable.a4f);
            } else {
                iconPreference.mo48763NL(8);
                iconPreference.mo48774ey("", -1);
            }
            iconPreference.mo48767NP(8);
            C14896a.dgQ().cjM();
            if (C14896a.dgQ().cjN()) {
                bY = C16112c.m24429PK().mo28552bY(262154, 266258);
            } else {
                bY = false;
            }
            if (bY) {
                C9638aw.m17190ZK();
                String str = (String) C18628c.m29072Ry().get(C5127a.USERINFO_SHAKE_CARD_ENTRANCE_RED_DOT_TEXT_STRING_SYNC, (Object) "");
                if (!TextUtils.isEmpty(str)) {
                    iconPreference.mo48765NN(8);
                    iconPreference.mo48763NL(0);
                    iconPreference.mo48774ey(String.valueOf(str), C25738R.drawable.a4f);
                } else if (baS > 0) {
                    iconPreference.mo48765NN(0);
                } else {
                    iconPreference.mo48765NN(0);
                    iconPreference.mo48763NL(8);
                    iconPreference.mo48774ey("", -1);
                }
            } else {
                iconPreference.mo48765NN(8);
            }
            C9638aw.m17190ZK();
            String bc = C5046bo.m7532bc((String) C18628c.m29072Ry().get(C5127a.USERINFO_IBEACON_PUSH_BEACONINFO_STRING, null), "");
            C9638aw.m17190ZK();
            Boolean valueOf = Boolean.valueOf(C5046bo.m7517a((Boolean) C18628c.m29072Ry().get(C5127a.USERINFO_IBEACON_PUSH_IS_OPEN_BOOLEAN, null), false));
            C9638aw.m17190ZK();
            int intValue = ((Integer) C18628c.m29072Ry().get(C5127a.USERINFO_IBEACON_SHAKE_TAB_DISPLAY_INT, Integer.valueOf(0))).intValue();
            if (!valueOf.booleanValue() || bc == null || bc.equals("") || baS > 0 || bY) {
                iconPreference.mo48764NM(8);
            } else if (intValue == 0) {
                iconPreference.mo48765NN(8);
                iconPreference.mo48764NM(0);
                String[] split = bc.split(",");
                if (split.length > 0) {
                    iconPreference.mo48771av(split[0], -1, Color.parseColor("#8c8c8c"));
                }
                iconPreference.mo48778qh(true);
                iconPreference.mo48768NQ(8);
                AppMethodBeat.m2505o(29276);
                return;
            } else if (intValue == 1) {
                iconPreference.mo48764NM(8);
                iconPreference.mo48763NL(0);
                iconPreference.yBX = true;
                AppMethodBeat.m2505o(29276);
                return;
            }
            AppMethodBeat.m2505o(29276);
            return;
        }
        this.yhb.mo27715ce("find_friends_by_shake", true);
        if (!dwR()) {
            C7060h.pYm.mo15419k(953, 2, 1);
        }
        AppMethodBeat.m2505o(29276);
    }

    private void dwZ() {
        AppMethodBeat.m2504i(138178);
        boolean Cn = m59236Cn(2097152);
        boolean afj = C25985d.afj(C8740a.SEARCH);
        String str = "MicroMsg.FindMoreFriendsUI";
        String str2 = "openSearch %s, plugin installed %s";
        Object[] objArr = new Object[2];
        objArr[0] = Boolean.valueOf(!Cn);
        objArr[1] = Boolean.valueOf(afj);
        C4990ab.m7417i(str, str2, objArr);
        if (Cn || !afj) {
            this.yhb.mo27715ce("find_friends_by_search", true);
            if (!dwR()) {
                C7060h.pYm.mo15419k(953, 4, 1);
            }
            AppMethodBeat.m2505o(138178);
            return;
        }
        this.yhn++;
        this.yhb.mo27715ce("find_friends_by_search", false);
        try {
            JSONObject adL = C29736ac.adL("discoverSearchEntry");
            String optString = adL.optString("wording");
            adL.optString("androidIcon");
            IconPreference iconPreference = (IconPreference) this.yhb.aqO("find_friends_by_search");
            if (C5046bo.isNullOrNil(optString)) {
                iconPreference.setTitle((CharSequence) getString(C25738R.string.bty));
            } else {
                iconPreference.setTitle((CharSequence) optString);
            }
            iconPreference.mo48763NL(8);
            m59243a(C4514am.cVt().uaS, iconPreference);
            C46400aa.cVe();
            AppMethodBeat.m2505o(138178);
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.FindMoreFriendsUI", e, "update search entry exception!", new Object[0]);
            AppMethodBeat.m2505o(138178);
        }
    }

    private void dxa() {
        AppMethodBeat.m2504i(29277);
        C4990ab.m7417i("MicroMsg.FindMoreFriendsUI", "openNearby %s, plugin installed %s", Boolean.valueOf((this.qnE & 512) == 0), Boolean.valueOf(C25985d.afj("nearby")));
        if (((this.qnE & 512) == 0) && r3) {
            this.yhn++;
            this.yhb.mo27715ce("find_friends_by_near", false);
            IconPreference iconPreference = (IconPreference) this.yhb.aqO("find_friends_by_near");
            if (iconPreference != null) {
                if (C32266b.m52686Ci()) {
                    iconPreference.mo48767NP(8);
                } else {
                    iconPreference.mo48767NP(0);
                    iconPreference.mo48766NO(C25738R.drawable.ais);
                    iconPreference.mo48777hn(-2, -2);
                }
                int baS = C41789d.akQ().baS();
                if (C9089a.dgL()) {
                    if (baS > 0) {
                        iconPreference.mo48765NN(0);
                        AppMethodBeat.m2505o(29277);
                        return;
                    }
                    iconPreference.mo48765NN(8);
                    AppMethodBeat.m2505o(29277);
                    return;
                } else if (baS > 0) {
                    iconPreference.mo48763NL(0);
                    iconPreference.mo48774ey(String.valueOf(baS), C44385r.m80243ik(getContext()));
                    AppMethodBeat.m2505o(29277);
                    return;
                } else {
                    iconPreference.mo48763NL(8);
                    iconPreference.mo48774ey("", -1);
                }
            }
            AppMethodBeat.m2505o(29277);
            return;
        }
        this.yhb.mo27715ce("find_friends_by_near", true);
        if (!dwR()) {
            C7060h.pYm.mo15419k(953, 5, 1);
        }
        AppMethodBeat.m2505o(29277);
    }

    private void dxb() {
        AppMethodBeat.m2504i(29278);
        C9447pz c9447pz = new C9447pz();
        c9447pz.cMo.cCt = this.cCt;
        C4879a.xxA.mo10055m(c9447pz);
        AppMethodBeat.m2505o(29278);
    }

    /* Access modifiers changed, original: protected|final */
    public final void dwa() {
        AppMethodBeat.m2504i(29279);
        C4990ab.m7416i("MicroMsg.FindMoreFriendsUI", "on tab start");
        ((C6983p) C1720g.m3530M(C6983p.class)).getSysCmdMsgExtension().mo14902a("lifeappreddot", this.yhy);
        AppMethodBeat.m2505o(29279);
    }

    /* Access modifiers changed, original: protected|final */
    public final void dwb() {
        AppMethodBeat.m2504i(29280);
        C4990ab.m7416i("MicroMsg.FindMoreFriendsUI", "on tab pause");
        this.cCt = false;
        dxb();
        if (C9638aw.m17179RK()) {
            C40418a.m69322b(C32578jb.class.getName(), this.vqt);
            C40418a.m69322b(C45329gy.class.getName(), this.yht);
            C40418a.m69322b(C18377qm.class.getName(), this.yhu);
            C4879a.xxA.mo10053d(this.yhr);
            C4879a.xxA.mo10053d(this.yhq);
            C4879a.xxA.mo10053d(this.yhs);
            C4879a.xxA.mo10053d(this.qLL);
            C4879a.xxA.mo10053d(this.yhv);
            C4879a.xxA.mo10053d(this.mJI);
            C4879a.xxA.mo10053d(this.yhz);
            C41789d.akR().mo10117d(this);
            C9638aw.m17190ZK();
            C18628c.m29083XR().mo10121b(this);
            C9638aw.m17190ZK();
            C18628c.m29104b(this);
            C9638aw.m17190ZK();
            C18628c.m29072Ry().mo10121b(this);
            if (this.yhf != null) {
                C32291o.ahk().mo33460rZ(this.yhf);
            }
            if (this.yhj != null) {
                C32291o.ahk().mo33460rZ(this.yhj);
            }
        }
        if (C21877n.qFB != null) {
            C21877n.qFB.mo25484b(this);
        }
        AppMethodBeat.m2505o(29280);
    }

    /* Access modifiers changed, original: protected|final */
    public final void dwc() {
        AppMethodBeat.m2504i(29281);
        C4990ab.m7416i("MicroMsg.FindMoreFriendsUI", "on tab stop");
        AppMethodBeat.m2505o(29281);
    }

    /* Access modifiers changed, original: protected|final */
    public final void dwd() {
        AppMethodBeat.m2504i(29282);
        C4990ab.m7416i("MicroMsg.FindMoreFriendsUI", "on tab destroy");
        ((C6983p) C1720g.m3530M(C6983p.class)).getSysCmdMsgExtension().mo14905b("lifeappreddot", this.yhy);
        AppMethodBeat.m2505o(29282);
    }

    public final void dwf() {
        AppMethodBeat.m2504i(29283);
        C4990ab.m7416i("MicroMsg.FindMoreFriendsUI", "turn to bg");
        AppMethodBeat.m2505o(29283);
    }

    public final void dwg() {
        AppMethodBeat.m2504i(29284);
        C4990ab.m7416i("MicroMsg.FindMoreFriendsUI", "turn to fg");
        AppMethodBeat.m2505o(29284);
    }

    public final void dwi() {
        AppMethodBeat.m2504i(29285);
        C4990ab.m7416i("MicroMsg.FindMoreFriendsUI", "on tab recreate ui");
        AppMethodBeat.m2505o(29285);
    }

    /* renamed from: a */
    public final void mo5248a(String str, C4935m c4935m) {
        Object obj = 1;
        AppMethodBeat.m2504i(29286);
        C4990ab.m7416i("MicroMsg.FindMoreFriendsUI", "onNotifyChange(MStorage)");
        if (LauncherUI.dxE() == 2) {
            Object obj2 = null;
            if (this.status != C1853r.m3822YD()) {
                this.status = C1853r.m3822YD();
                obj2 = 1;
            }
            if (this.kFU != C1853r.m3823YE()) {
                this.kFU = C1853r.m3823YE();
                obj2 = 1;
            }
            if (this.qnE != C1853r.m3829YK()) {
                this.qnE = C1853r.m3829YK();
            } else {
                obj = obj2;
            }
            if (obj != null) {
                aMk();
            }
        }
        AppMethodBeat.m2505o(29286);
    }

    /* renamed from: a */
    public final void mo10136a(int i, C7298n c7298n, Object obj) {
        Object obj2 = 1;
        AppMethodBeat.m2504i(29287);
        C4990ab.m7416i("MicroMsg.FindMoreFriendsUI", "onNotifyChange(MStorageEx)");
        if (LauncherUI.dxE() == 2) {
            Object obj3 = null;
            if (this.status != C1853r.m3822YD()) {
                this.status = C1853r.m3822YD();
                obj3 = 1;
            }
            if (this.kFU != C1853r.m3823YE()) {
                this.kFU = C1853r.m3823YE();
                obj3 = 1;
            }
            if (this.qnE != C1853r.m3829YK()) {
                this.qnE = C1853r.m3829YK();
            } else {
                obj2 = obj3;
            }
            if (obj2 != null) {
                aMk();
            }
            if (c7298n instanceof C15433al) {
                this.yhb.notifyDataSetChanged();
            }
        }
        AppMethodBeat.m2505o(29287);
    }

    public final void dxc() {
        AppMethodBeat.m2504i(29288);
        C4990ab.m7418v("MicroMsg.FindMoreFriendsUI", "on tab switch in");
        this.cCt = true;
        dxb();
        C1314b.m2812HQ().mo4642o(new C517718());
        C29736ac.m47143Ig(20);
        AppMethodBeat.m2505o(29288);
    }

    public final void dxd() {
        AppMethodBeat.m2504i(29289);
        C4990ab.m7418v("MicroMsg.FindMoreFriendsUI", "on tab switch out");
        this.cCt = false;
        dxb();
        AppMethodBeat.m2505o(29289);
    }

    /* renamed from: ZA */
    public final void mo55683ZA() {
        AppMethodBeat.m2504i(29290);
        C4990ab.m7416i("MicroMsg.FindMoreFriendsUI", "notify comment change");
        if ((C1853r.m3829YK() & 32768) != 0) {
            AppMethodBeat.m2505o(29290);
            return;
        }
        if (C21877n.qFz != null) {
            this.yhe = C21877n.qFz.baS();
        }
        dwX();
        this.yhb.notifyDataSetChanged();
        AppMethodBeat.m2505o(29290);
    }

    /* renamed from: g */
    static /* synthetic */ void m59258g(FindMoreFriendsUI findMoreFriendsUI) {
        AppMethodBeat.m2504i(138181);
        findMoreFriendsUI.dwW();
        findMoreFriendsUI.yhb.notifyDataSetChanged();
        AppMethodBeat.m2505o(138181);
    }
}
