package com.tencent.p177mm.p612ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.support.p069v7.app.AppCompatActivity;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C32782bp;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p1099x.C16112c;
import com.tencent.p177mm.p1510r.C35973a;
import com.tencent.p177mm.p203bg.C17981e;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p218cj.C45287c;
import com.tencent.p177mm.p230g.p231a.C32604oh;
import com.tencent.p177mm.p230g.p231a.C42062sz;
import com.tencent.p177mm.p249m.C26373g;
import com.tencent.p177mm.p612ui.base.C23639t;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.contact.C15830s;
import com.tencent.p177mm.p612ui.contact.SelectContactUI;
import com.tencent.p177mm.p612ui.contact.VoipAddressUI;
import com.tencent.p177mm.p612ui.tools.C30763p;
import com.tencent.p177mm.p612ui.tools.C44385r;
import com.tencent.p177mm.p840bn.C9089a;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.appbrand.widget.recentview.C11048d;
import com.tencent.p177mm.plugin.fav.p407a.C39037b;
import com.tencent.p177mm.plugin.report.service.C34830g;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.sns.p1024b.C21877n;
import com.tencent.p177mm.pluginsdk.C14827e;
import com.tencent.p177mm.pluginsdk.wallet.C35899h;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.storage.C5128ac.C5127a;

/* renamed from: com.tencent.mm.ui.aa */
public final class C46630aa extends C30763p {
    private static final int[] ypK = new int[]{2, 1, 4, 10, 3, BaseClientBuilder.API_PRIORITY_OTHER};
    private Context mContext;
    private LayoutInflater mInflater;
    private SparseArray<C30356c> ypG;
    private C30355a ypI;
    C44408z ypJ = null;

    /* renamed from: com.tencent.mm.ui.aa$b */
    public static class C23573b {
        int fQi;
        /* renamed from: id */
        int f4422id;
        int order;
        int ypM;

        public C23573b(int i, int i2, int i3) {
            this(i, i2, i3, 0);
        }

        public C23573b(int i, int i2, int i3, int i4) {
            this.f4422id = i;
            this.ypM = i2;
            this.fQi = i3;
            this.order = i4;
        }
    }

    /* renamed from: com.tencent.mm.ui.aa$a */
    class C30355a extends BaseAdapter {
        private C30355a() {
        }

        /* synthetic */ C30355a(C46630aa c46630aa, byte b) {
            this();
        }

        public final int getCount() {
            AppMethodBeat.m2504i(29843);
            int size = C46630aa.this.ypG.size();
            AppMethodBeat.m2505o(29843);
            return size;
        }

        public final Object getItem(int i) {
            return null;
        }

        public final long getItemId(int i) {
            return 0;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            AppMethodBeat.m2504i(29844);
            C30356c c30356c = (C30356c) C46630aa.this.ypG.get(i);
            View inflate = C46630aa.this.mInflater.inflate(2130970220, viewGroup, false);
            TextView textView = (TextView) inflate.findViewById(2131820678);
            if (!C5046bo.isNullOrNil(c30356c.ypP.ypQ)) {
                textView.setText(c30356c.ypP.ypQ);
            }
            if (c30356c.ypP.textColor > 0) {
                textView.setTextColor(C1338a.m2872i(C4996ah.getContext(), c30356c.ypP.textColor));
            }
            ImageView imageView = (ImageView) inflate.findViewById(2131820915);
            if (c30356c.ypP.icon > 0) {
                imageView.setVisibility(0);
                imageView.setImageResource(((C30356c) C46630aa.this.ypG.get(i)).ypP.icon);
            } else {
                imageView.setVisibility(8);
            }
            if (!C5046bo.isNullOrNil(c30356c.ypP.ypR)) {
                imageView.setContentDescription(c30356c.ypP.ypR);
            }
            View findViewById = inflate.findViewById(2131823549);
            textView = (TextView) inflate.findViewById(2131826100);
            textView.setBackgroundResource(C44385r.m80243ik(C46630aa.this.mContext));
            View findViewById2 = inflate.findViewById(2131825070);
            if (c30356c.ypN) {
                findViewById.setVisibility(0);
            } else if (c30356c.csm > 0) {
                textView.setVisibility(0);
                if (c30356c.csm > 99) {
                    textView.setText("");
                    textView.setBackgroundResource(C1318a.badge_count_more);
                } else {
                    textView.setText(c30356c.csm);
                    textView.setBackgroundResource(C44385r.m80243ik(C46630aa.this.mContext));
                }
            } else if (c30356c.ypO) {
                findViewById2.setVisibility(0);
            } else {
                findViewById.setVisibility(8);
                textView.setVisibility(8);
                findViewById2.setVisibility(8);
            }
            if (i == getCount() - 1) {
                inflate.setBackgroundResource(C25738R.drawable.a2r);
            } else {
                inflate.setBackgroundResource(C25738R.drawable.a2q);
            }
            AppMethodBeat.m2505o(29844);
            return inflate;
        }
    }

    /* renamed from: com.tencent.mm.ui.aa$c */
    public static class C30356c {
        int csm = 0;
        boolean ypN = false;
        boolean ypO = false;
        C40658d ypP;

        public C30356c(C40658d c40658d) {
            this.ypP = c40658d;
        }
    }

    /* renamed from: com.tencent.mm.ui.aa$d */
    public static class C40658d {
        int icon;
        int textColor;
        String ypQ;
        String ypR;
        int ypS;

        public C40658d(int i, String str, String str2, int i2, int i3) {
            this.ypQ = str;
            this.ypR = str2;
            this.icon = i2;
            this.ypS = i;
            this.textColor = i3;
        }
    }

    /* renamed from: com.tencent.mm.ui.aa$1 */
    class C442531 implements OnClickListener {
        C442531() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(29839);
            C42062sz c42062sz = new C42062sz();
            c42062sz.cPf.cPi = true;
            C4879a.xxA.mo10055m(c42062sz);
            VoipAddressUI.m24164hX(C46630aa.this.mContext);
            dialogInterface.dismiss();
            AppMethodBeat.m2505o(29839);
        }
    }

    /* renamed from: com.tencent.mm.ui.aa$2 */
    class C442542 implements OnClickListener {
        C442542() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(29840);
            dialogInterface.dismiss();
            AppMethodBeat.m2505o(29840);
        }
    }

    /* renamed from: com.tencent.mm.ui.aa$3 */
    class C466293 implements Runnable {
        C466293() {
        }

        public final void run() {
            AppMethodBeat.m2504i(29841);
            C45287c.aNX();
            AppMethodBeat.m2505o(29841);
        }
    }

    public C46630aa(AppCompatActivity appCompatActivity) {
        super(appCompatActivity);
        AppMethodBeat.m2504i(29845);
        this.mContext = appCompatActivity;
        this.mInflater = LayoutInflater.from(appCompatActivity);
        mo49188qR(false);
        this.ypJ = C44408z.dyZ();
        AppMethodBeat.m2505o(29845);
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        int i2 = 1;
        boolean z = false;
        AppMethodBeat.m2504i(29847);
        if (this.mContext instanceof AppCompatActivity) {
            ((AppCompatActivity) this.mContext).supportInvalidateOptionsMenu();
        }
        int i3 = ((C30356c) this.ypG.get(i)).ypP.ypS;
        C7060h.pYm.mo8381e(11104, Integer.valueOf(i3));
        if (C1720g.m3528K(C11048d.class) != null) {
            ((C11048d) C1720g.m3528K(C11048d.class)).aOC();
        }
        Intent intent;
        String str;
        Intent intent2;
        int a;
        switch (i3) {
            case 1:
                new Intent().putExtra("invite_friend_scene", 2);
                C25985d.m41467b(this.mContext, "subapp", ".ui.pluginapp.AddMoreFriendsUI", new Intent());
                break;
            case 2:
                intent = new Intent(this.mContext, SelectContactUI.class);
                intent.putExtra("titile", this.mContext.getString(C25738R.string.f8781es));
                intent.putExtra("list_type", 0);
                intent.putExtra("list_attr", C15830s.m24190C(C15830s.znG, 256, 512));
                intent.putExtra("scene", 7);
                this.mContext.startActivity(intent);
                break;
            case 3:
                intent = new Intent();
                intent.setClassName(this.mContext, "com.tencent.mm.ui.tools.ShareImageRedirectUI");
                this.mContext.startActivity(intent);
                break;
            case 4:
                C42062sz c42062sz = new C42062sz();
                c42062sz.cPf.cPh = true;
                C4879a.xxA.mo10055m(c42062sz);
                str = c42062sz.cPg.cPj;
                if (!C5046bo.isNullOrNil(str)) {
                    C4990ab.m7418v("MicroMsg.PlusSubMenuHelper", "Talkroom is on: ".concat(String.valueOf(str)));
                    C30379h.m48466d(this.mContext, this.mContext.getString(C25738R.string.euf), "", this.mContext.getString(C25738R.string.f9187s6), this.mContext.getString(C25738R.string.f9076or), new C442531(), new C442542());
                    break;
                }
                VoipAddressUI.m24164hX(this.mContext);
                break;
            case 5:
                C9638aw.m17190ZK();
                if (!C18628c.isSDCardAvailable()) {
                    C23639t.m36492hO(this.mContext);
                    break;
                }
                C9638aw.m17190ZK();
                str = (String) C18628c.m29072Ry().get(2, null);
                intent2 = new Intent();
                intent2.putExtra("sns_userName", str);
                intent2.setFlags(536870912);
                intent2.addFlags(67108864);
                C9638aw.m17190ZK();
                a = C5046bo.m7512a((Integer) C18628c.m29072Ry().get(68389, null), 0);
                C9638aw.m17190ZK();
                C18628c.m29072Ry().set(68389, Integer.valueOf(a + 1));
                intent2.putExtra("sns_adapter_type", 1);
                C25985d.m41467b(this.mContext, "sns", ".ui.SnsTimeLineUserPagerUI", intent2);
                break;
            case 6:
                C39037b.m66371b(this.mContext, ".ui.FavoriteIndexUI", new Intent());
                break;
            case 7:
                C25985d.m41467b(this.mContext, "mall", ".ui.MallIndexUI", new Intent());
                break;
            case 8:
                intent = new Intent();
                intent.putExtra("preceding_scence", 2);
                C25985d.m41467b(this.mContext, "emoji", ".ui.v2.EmojiStoreV2UI", intent);
                break;
            case 9:
                C25985d.m41467b(this.mContext, "setting", ".ui.setting.SelfQRCodeUI", new Intent());
                break;
            case 10:
                C7060h.pYm.mo8381e(11265, Integer.valueOf(3));
                if (!(C35973a.m59178bI(this.mContext) || C17981e.akI())) {
                    C25985d.m41448H(this.mContext, "scanner", ".ui.BaseScanUI");
                    break;
                }
            case 11:
                C9638aw.m17190ZK();
                if (!C18628c.isSDCardAvailable()) {
                    C23639t.m36492hO(this.mContext);
                    break;
                }
                boolean z2;
                C34830g.m57194BN(10);
                C9638aw.m17190ZK();
                str = (String) C18628c.m29072Ry().get(68377, null);
                C9638aw.m17190ZK();
                C18628c.m29072Ry().set(68377, (Object) "");
                intent2 = new Intent();
                intent2.putExtra("sns_timeline_NeedFirstLoadint", true);
                if (C5046bo.isNullOrNil(str)) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (C21877n.qFz == null) {
                    z = z2;
                } else if (C21877n.qFz.baS() <= 0) {
                    z = z2;
                }
                intent2.putExtra("sns_resume_state", z);
                C25985d.m41467b(this.mContext, "sns", ".ui.SnsTimeLineUI", intent2);
                break;
            case 12:
                C9638aw.m17190ZK();
                if (!C18628c.isSDCardAvailable()) {
                    C23639t.m36492hO(this.mContext);
                    break;
                }
                C25985d.m41448H(this.mContext, "game", ".ui.GameCenterUI");
                new C7306ak().postDelayed(new C466293(), 100);
                break;
            case 13:
                C4879a.xxA.mo10055m(new C32604oh());
                C25985d.m41448H(this.mContext, "shake", ".ui.ShakeReportUI");
                break;
            case 14:
                C9638aw.m17190ZK();
                if (!C5046bo.m7546e((Boolean) C18628c.m29072Ry().get(4103, null))) {
                    C25985d.m41448H(this.mContext, "nearby", ".ui.NearbyFriendsIntroUI");
                    break;
                }
                C32782bp aap = C32782bp.aap();
                if (aap != null) {
                    String nullAsNil = C5046bo.nullAsNil(aap.getProvince());
                    a = C5046bo.m7512a(Integer.valueOf(aap.dtS), 0);
                    if (!C5046bo.isNullOrNil(nullAsNil) && a != 0) {
                        C9638aw.m17190ZK();
                        Boolean bool = (Boolean) C18628c.m29072Ry().get(4104, null);
                        if (bool != null && bool.booleanValue()) {
                            View inflate = View.inflate(this.mContext, 2130969930, null);
                            final CheckBox checkBox = (CheckBox) inflate.findViewById(2131825250);
                            checkBox.setChecked(false);
                            C30379h.m48436a(this.mContext, this.mContext.getString(C25738R.string.f9238tz), inflate, new OnClickListener() {
                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    AppMethodBeat.m2504i(29842);
                                    if (checkBox != null) {
                                        C9638aw.m17190ZK();
                                        C18628c.m29072Ry().set(4104, Boolean.valueOf(!checkBox.isChecked()));
                                    }
                                    LauncherUI instance = LauncherUI.getInstance();
                                    if (instance != null) {
                                        instance.yjJ.getMainTabUI().aqG("tab_find_friend");
                                    }
                                    C9089a.m16479fy(C46630aa.this.mContext);
                                    AppMethodBeat.m2505o(29842);
                                }
                            }, null);
                            break;
                        }
                        LauncherUI instance = LauncherUI.getInstance();
                        if (instance != null) {
                            instance.yjJ.getMainTabUI().aqG("tab_find_friend");
                        }
                        C9089a.m16479fy(this.mContext);
                        break;
                    }
                    C25985d.m41448H(this.mContext, "nearby", ".ui.NearbyPersonalInfoUI");
                    break;
                }
                C25985d.m41448H(this.mContext, "nearby", ".ui.NearbyPersonalInfoUI");
                break;
                break;
            case 16:
                C9638aw.m17190ZK();
                if (!C18628c.m29074XI()) {
                    C25985d.m41448H(this.mContext, "webwx", ".ui.WebWeiXinIntroductionUI");
                    break;
                } else {
                    C25985d.m41448H(this.mContext, "webwx", ".ui.WebWXLogoutUI");
                    break;
                }
            case 17:
                if ((C1853r.m3829YK() & 65536) != 0) {
                    i2 = 0;
                }
                if (i2 == 0) {
                    C25985d.m41467b(this.mContext, Scopes.PROFILE, ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", "masssendapp"));
                    break;
                } else {
                    C25985d.m41448H(this.mContext, "masssend", ".ui.MassSendHistoryUI");
                    break;
                }
            case 18:
                C25985d.m41448H(this.mContext, "radar", ".ui.RadarSearchUI");
                break;
            case 19:
                C25985d.m41448H(this.mContext, "pwdgroup", ".ui.FacingCreateChatRoomAllInOneUI");
                break;
            case 20:
                Context context = this.mContext;
                intent2 = new Intent();
                intent2.putExtra("key_from_scene", 2);
                C25985d.m41467b(context, "offline", ".ui.WalletOfflineEntranceUI", intent2);
                if (C16112c.m24429PK().mo28552bY(262159, 266248)) {
                    C16112c.m24429PK().mo28553bZ(262159, 266248);
                    C7060h.pYm.mo8381e(14396, Integer.valueOf(2));
                    break;
                }
                break;
            case 22:
                C35899h.m58860ai(this.mContext, 1);
                break;
            case 2147483645:
                intent2 = new Intent();
                C9638aw.m17190ZK();
                str = (String) C18628c.m29072Ry().get(C5127a.USERINFO_CROWDTEST_FEEDBACK_LINK_STRING, (Object) "");
                if (!C5046bo.isNullOrNil(str)) {
                    intent2.putExtra("rawUrl", str);
                    intent2.putExtra("showShare", true);
                    intent2.putExtra("show_bottom", false);
                    C25985d.m41467b(this.mContext, "webview", ".ui.tools.WebViewUI", intent2);
                    break;
                }
                C14827e.m23078fC(this.mContext);
                break;
            case 2147483646:
                intent = new Intent();
                intent.putExtra("key_from_scene", 2);
                C25985d.m41467b(this.mContext, "offline", ".ui.WalletOfflineEntranceUI", intent);
                break;
            case BaseClientBuilder.API_PRIORITY_OTHER /*2147483647*/:
                C7060h.pYm.mo8374X(10919, "1-6");
                C14827e.m23078fC(this.mContext);
                break;
        }
        this.ypJ.mo70295Nt(i3);
        dismiss();
        AppMethodBeat.m2505o(29847);
    }

    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: Nu */
    public static C40658d m88223Nu(int i) {
        C40658d c40658d;
        AppMethodBeat.m2504i(29848);
        Context context = C4996ah.getContext();
        switch (i) {
            case 1:
                if (!HomeUI.yiE.booleanValue()) {
                    c40658d = new C40658d(1, context.getString(C25738R.string.cze), "", C1318a.ofm_add_icon, 0);
                    break;
                }
                c40658d = new C40658d(1, context.getString(C25738R.string.cze), "", C1318a.ofm_add_green_icon, C25738R.color.a61);
                break;
            case 2:
                if (!HomeUI.yiF.booleanValue()) {
                    c40658d = new C40658d(2, context.getString(C25738R.string.czh), "", C1318a.ofm_group_chat_icon, 0);
                    break;
                }
                c40658d = new C40658d(2, context.getString(C25738R.string.czh), "", C1318a.ofm_group_chat_green_icon, C25738R.color.a61);
                break;
            case 3:
                c40658d = new C40658d(3, context.getString(C25738R.string.czi), "", C1318a.camera, 0);
                break;
            case 4:
                if (1 != C5046bo.getInt(C26373g.m41964Nu().getValue("VOIPCallType"), 0)) {
                    c40658d = new C40658d(4, context.getString(C25738R.string.czf), "", C1318a.ofm_audio_icon, 0);
                    break;
                }
                c40658d = new C40658d(4, context.getString(C25738R.string.czj), "", C1318a.ofm_video_icon, 0);
                break;
            case 5:
                c40658d = new C40658d(5, context.getString(C25738R.string.e8x), "", C1318a.ofm_pic_icon, 0);
                break;
            case 6:
                c40658d = new C40658d(6, context.getString(C25738R.string.e8c), "", C1318a.ofm_favourite_icon, 0);
                break;
            case 7:
                c40658d = new C40658d(7, context.getString(C25738R.string.e8e), "", C1318a.ofm_card_icon, 0);
                break;
            case 8:
                c40658d = new C40658d(8, context.getString(C25738R.string.ba7), "", C1318a.ofm_emostore_icon, 0);
                break;
            case 9:
                c40658d = new C40658d(9, context.getString(C25738R.string.e91), "", C1318a.ofm_myqrcode_icon, 0);
                break;
            case 10:
                c40658d = new C40658d(10, context.getString(C25738R.string.btn), "", C1318a.ofm_qrcode_icon, 0);
                break;
            case 11:
                c40658d = new C40658d(11, context.getString(C25738R.string.ekb), "", C1318a.ofm_moment_icon, 0);
                break;
            case 12:
                c40658d = new C40658d(12, context.getString(C25738R.string.c7m), "", C1318a.ofm_gamecenter_icon, 0);
                break;
            case 13:
                c40658d = new C40658d(13, context.getString(C25738R.string.efr), "", C1318a.ofm_shake_icon, 0);
                break;
            case 14:
                c40658d = new C40658d(14, context.getString(C25738R.string.d57), "", C1318a.ofm_nearby_icon, 0);
                break;
            case 16:
                c40658d = new C40658d(16, context.getString(C25738R.string.e56), "", C1318a.ofm_webwechat_icon, 0);
                break;
            case 17:
                c40658d = new C40658d(17, context.getString(C25738R.string.cyx), "", C1318a.ofm_groupmessage_icon, 0);
                break;
            case 18:
                c40658d = new C40658d(18, context.getString(C25738R.string.btp), "", C1318a.ofm_radar_icon, 0);
                break;
            case 19:
                c40658d = new C40658d(19, context.getString(C25738R.string.bts), "", C1318a.actionbar_facefriend_icon, 0);
                break;
            case 20:
                C9638aw.m17190ZK();
                if (((Integer) C18628c.m29072Ry().get(C5127a.USERINFO_WALLET_REGION_TYPE_INT_SYNC, Integer.valueOf(0))).intValue() <= 1) {
                    c40658d = new C40658d(20, context.getString(C25738R.string.f8780er), "", C1318a.receipt_payment_icon, 0);
                    break;
                }
            case 22:
                C9638aw.m17190ZK();
                if (((Integer) C18628c.m29072Ry().get(C5127a.USERINFO_WALLET_REGION_TYPE_INT_SYNC, Integer.valueOf(0))).intValue() == 8) {
                    c40658d = new C40658d(22, context.getString(C25738R.string.de_), "", C1318a.offline_entrance_f2f_collect, 0);
                    break;
                }
            case 2147483645:
                c40658d = new C40658d(2147483645, context.getString(C25738R.string.e6h), "", C1318a.ofm_feedback_icon, 0);
                break;
            case 2147483646:
                c40658d = new C40658d(2147483646, "TIT", "", C1318a.ofm_card_icon, 0);
                break;
            case BaseClientBuilder.API_PRIORITY_OTHER /*2147483647*/:
                c40658d = new C40658d(BaseClientBuilder.API_PRIORITY_OTHER, context.getString(C25738R.string.e72), "", C1318a.ofm_feedback_icon, 0);
                break;
            default:
                c40658d = null;
                break;
        }
        AppMethodBeat.m2505o(29848);
        return c40658d;
    }

    /* renamed from: Kw */
    public final BaseAdapter mo49180Kw() {
        AppMethodBeat.m2504i(29849);
        if (this.ypI == null) {
            this.ypI = new C30355a(this, (byte) 0);
        }
        C30355a c30355a = this.ypI;
        AppMethodBeat.m2505o(29849);
        return c30355a;
    }

    /* renamed from: gP */
    public final boolean mo49182gP() {
        int i = 0;
        AppMethodBeat.m2504i(29846);
        this.ypJ.mo70296pY(false);
        if (this.ypJ.ypG.size() != 0) {
            this.ypG = this.ypJ.ypG;
        } else {
            C4990ab.m7410d("MicroMsg.PlusSubMenuHelper", "dyna plus config is null, we use default one");
            if (this.ypG != null) {
                this.ypG.clear();
            } else {
                this.ypG = new SparseArray();
            }
            for (int i2 = 0; i2 < ypK.length; i2++) {
                this.ypG.put(i2, new C30356c(C46630aa.m88223Nu(ypK[i2])));
            }
        }
        try {
            C9638aw.m17190ZK();
            if (((Boolean) C18628c.m29072Ry().get(C5127a.USERINFO_SUBMENU_SHOW_TIT_BOOLEAN, Boolean.FALSE)).booleanValue()) {
                while (i < this.ypG.size() && ((C30356c) this.ypG.get(i)).ypP.ypS != 2147483646) {
                    i++;
                }
                if (i == this.ypG.size()) {
                    this.ypG.put(this.ypG.size(), new C30356c(C46630aa.m88223Nu(2147483646)));
                }
            }
        } catch (Exception e) {
        }
        if (this.ypI != null) {
            this.ypI.notifyDataSetChanged();
        }
        boolean gP = super.mo49182gP();
        AppMethodBeat.m2505o(29846);
        return gP;
    }
}
