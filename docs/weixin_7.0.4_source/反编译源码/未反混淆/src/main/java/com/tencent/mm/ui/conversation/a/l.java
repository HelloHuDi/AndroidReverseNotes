package com.tencent.mm.ui.conversation.a;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.google.android.gms.common.Scopes;
import com.tencent.liteav.network.TXCStreamUploader;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.bn.a;
import com.tencent.mm.bp.d;
import com.tencent.mm.model.a.e;
import com.tencent.mm.model.a.f;
import com.tencent.mm.model.a.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.be;
import com.tencent.mm.model.bp;
import com.tencent.mm.model.c;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.account.bind.ui.BindMContactIntroUI;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.b.n;
import com.tencent.mm.pluginsdk.ui.b.b;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.widget.imageview.WeImageView;

public final class l extends b {
    private View jyC;
    private View jyD;
    protected bd zwA = null;
    private TextView zwB;

    public l(Context context, bd bdVar) {
        super(context);
        AppMethodBeat.i(34685);
        this.zwA = bdVar;
        if (this.view != null) {
            OnClickListener anonymousClass3;
            this.jyC = this.view.findViewById(R.id.bvd);
            this.jyD = this.view.findViewById(R.id.a2a);
            WeImageView weImageView = (WeImageView) this.view.findViewById(R.id.d2c);
            weImageView.setIconColor(((Context) this.vlu.get()).getResources().getColor(R.color.a3_));
            this.zwB = (TextView) this.view.findViewById(R.id.d2d);
            switch (this.zwA.type) {
                case 1:
                    weImageView.setImageResource(R.raw.icons_outlined_cellphone);
                    this.zwB.setText(R.string.a5e);
                    break;
                case 2:
                    weImageView.setImageResource(R.raw.icons_outlined_contacts);
                    this.zwB.setText(R.string.bu4);
                    break;
                case 3:
                    weImageView.setImageResource(R.raw.icons_outlined_avatar);
                    this.zwB.setText(R.string.a5n);
                    break;
                case 4:
                    weImageView.setImageResource(R.raw.userguide_nearfriends_icon);
                    this.zwB.setText(R.string.a5h);
                    break;
                case 6:
                    weImageView.setImageResource(R.raw.userguide_emostore_icon);
                    this.zwB.setText(R.string.a5l);
                    break;
                case 7:
                    weImageView.setImageResource(R.raw.userguide_gamecenter_icon);
                    this.zwB.setText(R.string.a5k);
                    break;
                case 8:
                    weImageView.setImageResource(R.raw.userguide_grounpmessage_icon);
                    this.zwB.setText(R.string.a5m);
                    break;
                case 9:
                    weImageView.setImageResource(R.raw.userguide_moments_icon);
                    this.zwB.setText(R.string.a5i);
                    break;
                case 10:
                    weImageView.setImageResource(R.raw.userguide_autoadd_icon);
                    this.zwB.setText(R.string.a5b);
                    break;
            }
            View view = this.view;
            final int i = this.zwA.type;
            final int i2 = this.zwA.showType;
            switch (i) {
                case 1:
                    anonymousClass3 = new OnClickListener() {
                        public final void onClick(View view) {
                            AppMethodBeat.i(34678);
                            be.ZV().co(i, i2);
                            l.D((Context) l.this.vlu.get(), false);
                            AppMethodBeat.o(34678);
                        }
                    };
                    break;
                case 2:
                    anonymousClass3 = new OnClickListener() {
                        public final void onClick(View view) {
                            AppMethodBeat.i(34679);
                            be.ZV().co(i, i2);
                            l.D((Context) l.this.vlu.get(), true);
                            AppMethodBeat.o(34679);
                        }
                    };
                    break;
                case 3:
                    anonymousClass3 = new OnClickListener() {
                        public final void onClick(View view) {
                            AppMethodBeat.i(34677);
                            be.ZV().co(i, i2);
                            Context context = (Context) l.this.vlu.get();
                            if (context != null) {
                                aw.ZK();
                                if (c.isSDCardAvailable()) {
                                    Intent intent = new Intent();
                                    intent.putExtra("intent_set_avatar", true);
                                    intent.putExtra("KEnterFromBanner", true);
                                    d.b(context, "setting", ".ui.setting.SettingsPersonalInfoUI", intent);
                                    h.pYm.e(TXCStreamUploader.TXE_UPLOAD_INFO_PUSH_BEGIN, Integer.valueOf(4), Integer.valueOf(1));
                                } else {
                                    t.hO(context);
                                    AppMethodBeat.o(34677);
                                    return;
                                }
                            }
                            AppMethodBeat.o(34677);
                        }
                    };
                    break;
                case 4:
                    anonymousClass3 = new OnClickListener() {
                        public final void onClick(View view) {
                            AppMethodBeat.i(34676);
                            be.ZV().co(i, i2);
                            Context context = (Context) l.this.vlu.get();
                            if (context != null) {
                                h.pYm.e(TXCStreamUploader.TXE_UPLOAD_INFO_PUSH_BEGIN, Integer.valueOf(5), Integer.valueOf(1));
                                aw.ZK();
                                boolean e = bo.e((Boolean) c.Ry().get(4103, null));
                                new Intent().putExtra("KEnterFromBanner", true);
                                if (e) {
                                    bp aap = bp.aap();
                                    if (aap == null) {
                                        d.H(context, "nearby", ".ui.NearbyPersonalInfoUI");
                                        AppMethodBeat.o(34676);
                                        return;
                                    }
                                    String nullAsNil = bo.nullAsNil(aap.getProvince());
                                    int a = bo.a(Integer.valueOf(aap.dtS), 0);
                                    if (bo.isNullOrNil(nullAsNil) || a == 0) {
                                        d.H(context, "nearby", ".ui.NearbyPersonalInfoUI");
                                        AppMethodBeat.o(34676);
                                        return;
                                    }
                                    LauncherUI instance = LauncherUI.getInstance();
                                    if (instance != null) {
                                        instance.yjJ.getMainTabUI().aqG("tab_find_friend");
                                    }
                                    a.fy(context);
                                } else {
                                    d.H(context, "nearby", ".ui.NearbyFriendsIntroUI");
                                    AppMethodBeat.o(34676);
                                    return;
                                }
                            }
                            AppMethodBeat.o(34676);
                        }
                    };
                    break;
                case 6:
                    anonymousClass3 = new OnClickListener() {
                        public final void onClick(View view) {
                            AppMethodBeat.i(34680);
                            be.ZV().co(i, i2);
                            Context context = (Context) l.this.vlu.get();
                            Intent intent = new Intent();
                            intent.putExtra("preceding_scence", 17);
                            d.b(context, "emoji", ".ui.v2.EmojiStoreV2UI", intent);
                            h.pYm.e(TXCStreamUploader.TXE_UPLOAD_INFO_PUSH_BEGIN, Integer.valueOf(10), Integer.valueOf(1));
                            h.pYm.e(12065, Integer.valueOf(2));
                            AppMethodBeat.o(34680);
                        }
                    };
                    break;
                case 7:
                    anonymousClass3 = new OnClickListener() {
                        public final void onClick(View view) {
                            AppMethodBeat.i(34681);
                            be.ZV().co(i, i2);
                            d.H((Context) l.this.vlu.get(), "game", ".ui.GameCenterUI");
                            h.pYm.e(TXCStreamUploader.TXE_UPLOAD_INFO_PUSH_BEGIN, Integer.valueOf(9), Integer.valueOf(1));
                            AppMethodBeat.o(34681);
                        }
                    };
                    break;
                case 8:
                    anonymousClass3 = new OnClickListener() {
                        public final void onClick(View view) {
                            AppMethodBeat.i(34682);
                            be.ZV().co(i, i2);
                            Context context = (Context) l.this.vlu.get();
                            if (((r.YK() & 65536) == 0 ? 1 : 0) != 0) {
                                d.H(context, "masssend", ".ui.MassSendHistoryUI");
                            } else {
                                d.b(context, Scopes.PROFILE, ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", "masssendapp"));
                            }
                            h.pYm.e(TXCStreamUploader.TXE_UPLOAD_INFO_PUSH_BEGIN, Integer.valueOf(11), Integer.valueOf(1));
                            AppMethodBeat.o(34682);
                        }
                    };
                    break;
                case 9:
                    anonymousClass3 = new OnClickListener() {
                        public final void onClick(View view) {
                            boolean z;
                            AppMethodBeat.i(34683);
                            be.ZV().co(i, i2);
                            Context context = (Context) l.this.vlu.get();
                            aw.ZK();
                            String str = (String) c.Ry().get(68377, null);
                            aw.ZK();
                            c.Ry().set(68377, (Object) "");
                            Intent intent = new Intent();
                            intent.putExtra("sns_timeline_NeedFirstLoadint", true);
                            if (bo.isNullOrNil(str)) {
                                z = true;
                            } else {
                                z = false;
                            }
                            if (n.qFz != null && n.qFz.baS() > 0) {
                                z = false;
                            }
                            intent.putExtra("sns_resume_state", z);
                            d.b(context, "sns", ".ui.SnsTimeLineUI", intent);
                            h.pYm.e(TXCStreamUploader.TXE_UPLOAD_INFO_PUSH_BEGIN, Integer.valueOf(8), Integer.valueOf(1));
                            AppMethodBeat.o(34683);
                        }
                    };
                    break;
                case 10:
                    anonymousClass3 = new OnClickListener() {
                        public final void onClick(View view) {
                            AppMethodBeat.i(34684);
                            be.ZV().co(i, i2);
                            d.b((Context) l.this.vlu.get(), "subapp", ".ui.autoadd.AutoAddFriendUI", new Intent());
                            AppMethodBeat.o(34684);
                        }
                    };
                    break;
                default:
                    anonymousClass3 = null;
                    break;
            }
            view.setOnClickListener(anonymousClass3);
        }
        AppMethodBeat.o(34685);
    }

    public final int getLayoutId() {
        return R.layout.aba;
    }

    public final void destroy() {
    }

    public final void setVisibility(int i) {
        AppMethodBeat.i(34687);
        if (this.jyC != null) {
            this.jyC.setVisibility(i);
        }
        AppMethodBeat.o(34687);
    }

    public final boolean aMN() {
        AppMethodBeat.i(34686);
        if (this.nfA && this.eVH) {
            this.jyD.setBackgroundResource(R.drawable.a3h);
            this.jyC.setBackground(null);
            this.zwB.setBackground(null);
        } else if (this.nfA) {
            this.jyD.setBackgroundResource(R.drawable.r9);
            this.jyC.setBackgroundResource(R.drawable.b7t);
            this.zwB.setBackgroundResource(R.drawable.a_q);
        } else if (this.eVH) {
            this.jyD.setBackgroundResource(R.drawable.r9);
            this.jyC.setBackgroundResource(R.drawable.a_q);
            this.zwB.setBackground(null);
        } else {
            this.jyD.setBackgroundResource(R.drawable.r9);
            this.jyC.setBackground(null);
            this.zwB.setBackgroundResource(R.drawable.a_q);
        }
        boolean aMN = super.aMN();
        AppMethodBeat.o(34686);
        return aMN;
    }

    static /* synthetic */ void D(Context context, boolean z) {
        AppMethodBeat.i(34688);
        if (context != null) {
            Intent intent = new Intent();
            intent.setClass(context, BindMContactIntroUI.class);
            intent.putExtra("key_upload_scene", 8);
            if (z) {
                intent.putExtra("bind_scene", 2);
            }
            intent.putExtra("KEnterFromBanner", true);
            MMWizardActivity.J(context, intent);
            e oP = g.aaK().oP("4");
            if (oP != null && !bo.isNullOrNil(oP.value) && (oP.value.equals("1") || oP.value.equals("2"))) {
                g.aaK().oP("4").result = "1";
                f.oU("4");
                if (oP.value.equals("1")) {
                    aw.ZK();
                    c.Ry().set(328195, Boolean.TRUE);
                    AppMethodBeat.o(34688);
                    return;
                }
                aw.ZK();
                c.Ry().set(328196, Boolean.TRUE);
                AppMethodBeat.o(34688);
                return;
            } else if (z) {
                h.pYm.e(TXCStreamUploader.TXE_UPLOAD_INFO_PUSH_BEGIN, Integer.valueOf(3), Integer.valueOf(1));
                AppMethodBeat.o(34688);
                return;
            } else {
                h.pYm.e(TXCStreamUploader.TXE_UPLOAD_INFO_PUSH_BEGIN, Integer.valueOf(1), Integer.valueOf(1));
            }
        }
        AppMethodBeat.o(34688);
    }
}
