package com.tencent.mm.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
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
import com.tencent.mm.R;
import com.tencent.mm.bg.e;
import com.tencent.mm.g.a.oh;
import com.tencent.mm.g.a.sz;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bp;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.b.n;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.contact.SelectContactUI;
import com.tencent.mm.ui.contact.VoipAddressUI;
import com.tencent.mm.ui.contact.s;
import com.tencent.mm.ui.tools.p;
import com.tencent.mm.ui.tools.r;

public final class aa extends p {
    private static final int[] ypK = new int[]{2, 1, 4, 10, 3, BaseClientBuilder.API_PRIORITY_OTHER};
    private Context mContext;
    private LayoutInflater mInflater;
    private SparseArray<c> ypG;
    private a ypI;
    z ypJ = null;

    public static class b {
        int fQi;
        int id;
        int order;
        int ypM;

        public b(int i, int i2, int i3) {
            this(i, i2, i3, 0);
        }

        public b(int i, int i2, int i3, int i4) {
            this.id = i;
            this.ypM = i2;
            this.fQi = i3;
            this.order = i4;
        }
    }

    class a extends BaseAdapter {
        private a() {
        }

        /* synthetic */ a(aa aaVar, byte b) {
            this();
        }

        public final int getCount() {
            AppMethodBeat.i(29843);
            int size = aa.this.ypG.size();
            AppMethodBeat.o(29843);
            return size;
        }

        public final Object getItem(int i) {
            return null;
        }

        public final long getItemId(int i) {
            return 0;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            AppMethodBeat.i(29844);
            c cVar = (c) aa.this.ypG.get(i);
            View inflate = aa.this.mInflater.inflate(R.layout.agm, viewGroup, false);
            TextView textView = (TextView) inflate.findViewById(R.id.cx);
            if (!bo.isNullOrNil(cVar.ypP.ypQ)) {
                textView.setText(cVar.ypP.ypQ);
            }
            if (cVar.ypP.textColor > 0) {
                textView.setTextColor(com.tencent.mm.bz.a.i(ah.getContext(), cVar.ypP.textColor));
            }
            ImageView imageView = (ImageView) inflate.findViewById(R.id.jb);
            if (cVar.ypP.icon > 0) {
                imageView.setVisibility(0);
                imageView.setImageResource(((c) aa.this.ypG.get(i)).ypP.icon);
            } else {
                imageView.setVisibility(8);
            }
            if (!bo.isNullOrNil(cVar.ypP.ypR)) {
                imageView.setContentDescription(cVar.ypP.ypR);
            }
            View findViewById = inflate.findViewById(R.id.bg8);
            textView = (TextView) inflate.findViewById(R.id.db7);
            textView.setBackgroundResource(r.ik(aa.this.mContext));
            View findViewById2 = inflate.findViewById(R.id.ckb);
            if (cVar.ypN) {
                findViewById.setVisibility(0);
            } else if (cVar.csm > 0) {
                textView.setVisibility(0);
                if (cVar.csm > 99) {
                    textView.setText("");
                    textView.setBackgroundResource(R.raw.badge_count_more);
                } else {
                    textView.setText(cVar.csm);
                    textView.setBackgroundResource(r.ik(aa.this.mContext));
                }
            } else if (cVar.ypO) {
                findViewById2.setVisibility(0);
            } else {
                findViewById.setVisibility(8);
                textView.setVisibility(8);
                findViewById2.setVisibility(8);
            }
            if (i == getCount() - 1) {
                inflate.setBackgroundResource(R.drawable.a2r);
            } else {
                inflate.setBackgroundResource(R.drawable.a2q);
            }
            AppMethodBeat.o(29844);
            return inflate;
        }
    }

    public static class c {
        int csm = 0;
        boolean ypN = false;
        boolean ypO = false;
        d ypP;

        public c(d dVar) {
            this.ypP = dVar;
        }
    }

    public static class d {
        int icon;
        int textColor;
        String ypQ;
        String ypR;
        int ypS;

        public d(int i, String str, String str2, int i2, int i3) {
            this.ypQ = str;
            this.ypR = str2;
            this.icon = i2;
            this.ypS = i;
            this.textColor = i3;
        }
    }

    public aa(AppCompatActivity appCompatActivity) {
        super(appCompatActivity);
        AppMethodBeat.i(29845);
        this.mContext = appCompatActivity;
        this.mInflater = LayoutInflater.from(appCompatActivity);
        qR(false);
        this.ypJ = z.dyZ();
        AppMethodBeat.o(29845);
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        int i2 = 1;
        boolean z = false;
        AppMethodBeat.i(29847);
        if (this.mContext instanceof AppCompatActivity) {
            ((AppCompatActivity) this.mContext).supportInvalidateOptionsMenu();
        }
        int i3 = ((c) this.ypG.get(i)).ypP.ypS;
        h.pYm.e(11104, Integer.valueOf(i3));
        if (g.K(com.tencent.mm.plugin.appbrand.widget.recentview.d.class) != null) {
            ((com.tencent.mm.plugin.appbrand.widget.recentview.d) g.K(com.tencent.mm.plugin.appbrand.widget.recentview.d.class)).aOC();
        }
        Intent intent;
        String str;
        Intent intent2;
        int a;
        switch (i3) {
            case 1:
                new Intent().putExtra("invite_friend_scene", 2);
                com.tencent.mm.bp.d.b(this.mContext, "subapp", ".ui.pluginapp.AddMoreFriendsUI", new Intent());
                break;
            case 2:
                intent = new Intent(this.mContext, SelectContactUI.class);
                intent.putExtra("titile", this.mContext.getString(R.string.es));
                intent.putExtra("list_type", 0);
                intent.putExtra("list_attr", s.C(s.znG, 256, 512));
                intent.putExtra("scene", 7);
                this.mContext.startActivity(intent);
                break;
            case 3:
                intent = new Intent();
                intent.setClassName(this.mContext, "com.tencent.mm.ui.tools.ShareImageRedirectUI");
                this.mContext.startActivity(intent);
                break;
            case 4:
                sz szVar = new sz();
                szVar.cPf.cPh = true;
                com.tencent.mm.sdk.b.a.xxA.m(szVar);
                str = szVar.cPg.cPj;
                if (!bo.isNullOrNil(str)) {
                    ab.v("MicroMsg.PlusSubMenuHelper", "Talkroom is on: ".concat(String.valueOf(str)));
                    com.tencent.mm.ui.base.h.d(this.mContext, this.mContext.getString(R.string.euf), "", this.mContext.getString(R.string.s6), this.mContext.getString(R.string.or), new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.i(29839);
                            sz szVar = new sz();
                            szVar.cPf.cPi = true;
                            com.tencent.mm.sdk.b.a.xxA.m(szVar);
                            VoipAddressUI.hX(aa.this.mContext);
                            dialogInterface.dismiss();
                            AppMethodBeat.o(29839);
                        }
                    }, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.i(29840);
                            dialogInterface.dismiss();
                            AppMethodBeat.o(29840);
                        }
                    });
                    break;
                }
                VoipAddressUI.hX(this.mContext);
                break;
            case 5:
                aw.ZK();
                if (!com.tencent.mm.model.c.isSDCardAvailable()) {
                    t.hO(this.mContext);
                    break;
                }
                aw.ZK();
                str = (String) com.tencent.mm.model.c.Ry().get(2, null);
                intent2 = new Intent();
                intent2.putExtra("sns_userName", str);
                intent2.setFlags(536870912);
                intent2.addFlags(67108864);
                aw.ZK();
                a = bo.a((Integer) com.tencent.mm.model.c.Ry().get(68389, null), 0);
                aw.ZK();
                com.tencent.mm.model.c.Ry().set(68389, Integer.valueOf(a + 1));
                intent2.putExtra("sns_adapter_type", 1);
                com.tencent.mm.bp.d.b(this.mContext, "sns", ".ui.SnsTimeLineUserPagerUI", intent2);
                break;
            case 6:
                com.tencent.mm.plugin.fav.a.b.b(this.mContext, ".ui.FavoriteIndexUI", new Intent());
                break;
            case 7:
                com.tencent.mm.bp.d.b(this.mContext, "mall", ".ui.MallIndexUI", new Intent());
                break;
            case 8:
                intent = new Intent();
                intent.putExtra("preceding_scence", 2);
                com.tencent.mm.bp.d.b(this.mContext, "emoji", ".ui.v2.EmojiStoreV2UI", intent);
                break;
            case 9:
                com.tencent.mm.bp.d.b(this.mContext, "setting", ".ui.setting.SelfQRCodeUI", new Intent());
                break;
            case 10:
                h.pYm.e(11265, Integer.valueOf(3));
                if (!(com.tencent.mm.r.a.bI(this.mContext) || e.akI())) {
                    com.tencent.mm.bp.d.H(this.mContext, "scanner", ".ui.BaseScanUI");
                    break;
                }
            case 11:
                aw.ZK();
                if (!com.tencent.mm.model.c.isSDCardAvailable()) {
                    t.hO(this.mContext);
                    break;
                }
                boolean z2;
                com.tencent.mm.plugin.report.service.g.BN(10);
                aw.ZK();
                str = (String) com.tencent.mm.model.c.Ry().get(68377, null);
                aw.ZK();
                com.tencent.mm.model.c.Ry().set(68377, (Object) "");
                intent2 = new Intent();
                intent2.putExtra("sns_timeline_NeedFirstLoadint", true);
                if (bo.isNullOrNil(str)) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (n.qFz == null) {
                    z = z2;
                } else if (n.qFz.baS() <= 0) {
                    z = z2;
                }
                intent2.putExtra("sns_resume_state", z);
                com.tencent.mm.bp.d.b(this.mContext, "sns", ".ui.SnsTimeLineUI", intent2);
                break;
            case 12:
                aw.ZK();
                if (!com.tencent.mm.model.c.isSDCardAvailable()) {
                    t.hO(this.mContext);
                    break;
                }
                com.tencent.mm.bp.d.H(this.mContext, "game", ".ui.GameCenterUI");
                new ak().postDelayed(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(29841);
                        com.tencent.mm.cj.c.aNX();
                        AppMethodBeat.o(29841);
                    }
                }, 100);
                break;
            case 13:
                com.tencent.mm.sdk.b.a.xxA.m(new oh());
                com.tencent.mm.bp.d.H(this.mContext, "shake", ".ui.ShakeReportUI");
                break;
            case 14:
                aw.ZK();
                if (!bo.e((Boolean) com.tencent.mm.model.c.Ry().get(4103, null))) {
                    com.tencent.mm.bp.d.H(this.mContext, "nearby", ".ui.NearbyFriendsIntroUI");
                    break;
                }
                bp aap = bp.aap();
                if (aap != null) {
                    String nullAsNil = bo.nullAsNil(aap.getProvince());
                    a = bo.a(Integer.valueOf(aap.dtS), 0);
                    if (!bo.isNullOrNil(nullAsNil) && a != 0) {
                        aw.ZK();
                        Boolean bool = (Boolean) com.tencent.mm.model.c.Ry().get(4104, null);
                        if (bool != null && bool.booleanValue()) {
                            View inflate = View.inflate(this.mContext, R.layout.a9s, null);
                            final CheckBox checkBox = (CheckBox) inflate.findViewById(R.id.cp8);
                            checkBox.setChecked(false);
                            com.tencent.mm.ui.base.h.a(this.mContext, this.mContext.getString(R.string.tz), inflate, new OnClickListener() {
                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    AppMethodBeat.i(29842);
                                    if (checkBox != null) {
                                        aw.ZK();
                                        com.tencent.mm.model.c.Ry().set(4104, Boolean.valueOf(!checkBox.isChecked()));
                                    }
                                    LauncherUI instance = LauncherUI.getInstance();
                                    if (instance != null) {
                                        instance.yjJ.getMainTabUI().aqG("tab_find_friend");
                                    }
                                    com.tencent.mm.bn.a.fy(aa.this.mContext);
                                    AppMethodBeat.o(29842);
                                }
                            }, null);
                            break;
                        }
                        LauncherUI instance = LauncherUI.getInstance();
                        if (instance != null) {
                            instance.yjJ.getMainTabUI().aqG("tab_find_friend");
                        }
                        com.tencent.mm.bn.a.fy(this.mContext);
                        break;
                    }
                    com.tencent.mm.bp.d.H(this.mContext, "nearby", ".ui.NearbyPersonalInfoUI");
                    break;
                }
                com.tencent.mm.bp.d.H(this.mContext, "nearby", ".ui.NearbyPersonalInfoUI");
                break;
                break;
            case 16:
                aw.ZK();
                if (!com.tencent.mm.model.c.XI()) {
                    com.tencent.mm.bp.d.H(this.mContext, "webwx", ".ui.WebWeiXinIntroductionUI");
                    break;
                } else {
                    com.tencent.mm.bp.d.H(this.mContext, "webwx", ".ui.WebWXLogoutUI");
                    break;
                }
            case 17:
                if ((com.tencent.mm.model.r.YK() & 65536) != 0) {
                    i2 = 0;
                }
                if (i2 == 0) {
                    com.tencent.mm.bp.d.b(this.mContext, Scopes.PROFILE, ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", "masssendapp"));
                    break;
                } else {
                    com.tencent.mm.bp.d.H(this.mContext, "masssend", ".ui.MassSendHistoryUI");
                    break;
                }
            case 18:
                com.tencent.mm.bp.d.H(this.mContext, "radar", ".ui.RadarSearchUI");
                break;
            case 19:
                com.tencent.mm.bp.d.H(this.mContext, "pwdgroup", ".ui.FacingCreateChatRoomAllInOneUI");
                break;
            case 20:
                Context context = this.mContext;
                intent2 = new Intent();
                intent2.putExtra("key_from_scene", 2);
                com.tencent.mm.bp.d.b(context, "offline", ".ui.WalletOfflineEntranceUI", intent2);
                if (com.tencent.mm.x.c.PK().bY(262159, 266248)) {
                    com.tencent.mm.x.c.PK().bZ(262159, 266248);
                    h.pYm.e(14396, Integer.valueOf(2));
                    break;
                }
                break;
            case 22:
                com.tencent.mm.pluginsdk.wallet.h.ai(this.mContext, 1);
                break;
            case 2147483645:
                intent2 = new Intent();
                aw.ZK();
                str = (String) com.tencent.mm.model.c.Ry().get(com.tencent.mm.storage.ac.a.USERINFO_CROWDTEST_FEEDBACK_LINK_STRING, (Object) "");
                if (!bo.isNullOrNil(str)) {
                    intent2.putExtra("rawUrl", str);
                    intent2.putExtra("showShare", true);
                    intent2.putExtra("show_bottom", false);
                    com.tencent.mm.bp.d.b(this.mContext, "webview", ".ui.tools.WebViewUI", intent2);
                    break;
                }
                com.tencent.mm.pluginsdk.e.fC(this.mContext);
                break;
            case 2147483646:
                intent = new Intent();
                intent.putExtra("key_from_scene", 2);
                com.tencent.mm.bp.d.b(this.mContext, "offline", ".ui.WalletOfflineEntranceUI", intent);
                break;
            case BaseClientBuilder.API_PRIORITY_OTHER /*2147483647*/:
                h.pYm.X(10919, "1-6");
                com.tencent.mm.pluginsdk.e.fC(this.mContext);
                break;
        }
        this.ypJ.Nt(i3);
        dismiss();
        AppMethodBeat.o(29847);
    }

    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static d Nu(int i) {
        d dVar;
        AppMethodBeat.i(29848);
        Context context = ah.getContext();
        switch (i) {
            case 1:
                if (!HomeUI.yiE.booleanValue()) {
                    dVar = new d(1, context.getString(R.string.cze), "", R.raw.ofm_add_icon, 0);
                    break;
                }
                dVar = new d(1, context.getString(R.string.cze), "", R.raw.ofm_add_green_icon, R.color.a61);
                break;
            case 2:
                if (!HomeUI.yiF.booleanValue()) {
                    dVar = new d(2, context.getString(R.string.czh), "", R.raw.ofm_group_chat_icon, 0);
                    break;
                }
                dVar = new d(2, context.getString(R.string.czh), "", R.raw.ofm_group_chat_green_icon, R.color.a61);
                break;
            case 3:
                dVar = new d(3, context.getString(R.string.czi), "", R.raw.camera, 0);
                break;
            case 4:
                if (1 != bo.getInt(com.tencent.mm.m.g.Nu().getValue("VOIPCallType"), 0)) {
                    dVar = new d(4, context.getString(R.string.czf), "", R.raw.ofm_audio_icon, 0);
                    break;
                }
                dVar = new d(4, context.getString(R.string.czj), "", R.raw.ofm_video_icon, 0);
                break;
            case 5:
                dVar = new d(5, context.getString(R.string.e8x), "", R.raw.ofm_pic_icon, 0);
                break;
            case 6:
                dVar = new d(6, context.getString(R.string.e8c), "", R.raw.ofm_favourite_icon, 0);
                break;
            case 7:
                dVar = new d(7, context.getString(R.string.e8e), "", R.raw.ofm_card_icon, 0);
                break;
            case 8:
                dVar = new d(8, context.getString(R.string.ba7), "", R.raw.ofm_emostore_icon, 0);
                break;
            case 9:
                dVar = new d(9, context.getString(R.string.e91), "", R.raw.ofm_myqrcode_icon, 0);
                break;
            case 10:
                dVar = new d(10, context.getString(R.string.btn), "", R.raw.ofm_qrcode_icon, 0);
                break;
            case 11:
                dVar = new d(11, context.getString(R.string.ekb), "", R.raw.ofm_moment_icon, 0);
                break;
            case 12:
                dVar = new d(12, context.getString(R.string.c7m), "", R.raw.ofm_gamecenter_icon, 0);
                break;
            case 13:
                dVar = new d(13, context.getString(R.string.efr), "", R.raw.ofm_shake_icon, 0);
                break;
            case 14:
                dVar = new d(14, context.getString(R.string.d57), "", R.raw.ofm_nearby_icon, 0);
                break;
            case 16:
                dVar = new d(16, context.getString(R.string.e56), "", R.raw.ofm_webwechat_icon, 0);
                break;
            case 17:
                dVar = new d(17, context.getString(R.string.cyx), "", R.raw.ofm_groupmessage_icon, 0);
                break;
            case 18:
                dVar = new d(18, context.getString(R.string.btp), "", R.raw.ofm_radar_icon, 0);
                break;
            case 19:
                dVar = new d(19, context.getString(R.string.bts), "", R.raw.actionbar_facefriend_icon, 0);
                break;
            case 20:
                aw.ZK();
                if (((Integer) com.tencent.mm.model.c.Ry().get(com.tencent.mm.storage.ac.a.USERINFO_WALLET_REGION_TYPE_INT_SYNC, Integer.valueOf(0))).intValue() <= 1) {
                    dVar = new d(20, context.getString(R.string.er), "", R.raw.receipt_payment_icon, 0);
                    break;
                }
            case 22:
                aw.ZK();
                if (((Integer) com.tencent.mm.model.c.Ry().get(com.tencent.mm.storage.ac.a.USERINFO_WALLET_REGION_TYPE_INT_SYNC, Integer.valueOf(0))).intValue() == 8) {
                    dVar = new d(22, context.getString(R.string.de_), "", R.raw.offline_entrance_f2f_collect, 0);
                    break;
                }
            case 2147483645:
                dVar = new d(2147483645, context.getString(R.string.e6h), "", R.raw.ofm_feedback_icon, 0);
                break;
            case 2147483646:
                dVar = new d(2147483646, "TIT", "", R.raw.ofm_card_icon, 0);
                break;
            case BaseClientBuilder.API_PRIORITY_OTHER /*2147483647*/:
                dVar = new d(BaseClientBuilder.API_PRIORITY_OTHER, context.getString(R.string.e72), "", R.raw.ofm_feedback_icon, 0);
                break;
            default:
                dVar = null;
                break;
        }
        AppMethodBeat.o(29848);
        return dVar;
    }

    public final BaseAdapter Kw() {
        AppMethodBeat.i(29849);
        if (this.ypI == null) {
            this.ypI = new a(this, (byte) 0);
        }
        a aVar = this.ypI;
        AppMethodBeat.o(29849);
        return aVar;
    }

    public final boolean gP() {
        int i = 0;
        AppMethodBeat.i(29846);
        this.ypJ.pY(false);
        if (this.ypJ.ypG.size() != 0) {
            this.ypG = this.ypJ.ypG;
        } else {
            ab.d("MicroMsg.PlusSubMenuHelper", "dyna plus config is null, we use default one");
            if (this.ypG != null) {
                this.ypG.clear();
            } else {
                this.ypG = new SparseArray();
            }
            for (int i2 = 0; i2 < ypK.length; i2++) {
                this.ypG.put(i2, new c(Nu(ypK[i2])));
            }
        }
        try {
            aw.ZK();
            if (((Boolean) com.tencent.mm.model.c.Ry().get(com.tencent.mm.storage.ac.a.USERINFO_SUBMENU_SHOW_TIT_BOOLEAN, Boolean.FALSE)).booleanValue()) {
                while (i < this.ypG.size() && ((c) this.ypG.get(i)).ypP.ypS != 2147483646) {
                    i++;
                }
                if (i == this.ypG.size()) {
                    this.ypG.put(this.ypG.size(), new c(Nu(2147483646)));
                }
            }
        } catch (Exception e) {
        }
        if (this.ypI != null) {
            this.ypI.notifyDataSetChanged();
        }
        boolean gP = super.gP();
        AppMethodBeat.o(29846);
        return gP;
    }
}
