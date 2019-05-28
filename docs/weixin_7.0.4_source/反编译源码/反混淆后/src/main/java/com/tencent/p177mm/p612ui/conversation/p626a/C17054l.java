package com.tencent.p177mm.p612ui.conversation.p626a;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.google.android.gms.common.Scopes;
import com.tencent.liteav.network.TXCStreamUploader;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C32776be;
import com.tencent.p177mm.model.C32782bp;
import com.tencent.p177mm.model.C37903bd;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.model.p1207a.C18608f;
import com.tencent.p177mm.model.p1207a.C26407g;
import com.tencent.p177mm.model.p1207a.C42183e;
import com.tencent.p177mm.p612ui.LauncherUI;
import com.tencent.p177mm.p612ui.MMWizardActivity;
import com.tencent.p177mm.p612ui.base.C23639t;
import com.tencent.p177mm.p612ui.widget.imageview.WeImageView;
import com.tencent.p177mm.p840bn.C9089a;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.account.bind.p271ui.BindMContactIntroUI;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.sns.p1024b.C21877n;
import com.tencent.p177mm.pluginsdk.p597ui.p1083b.C14933b;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.ui.conversation.a.l */
public final class C17054l extends C14933b {
    private View jyC;
    private View jyD;
    protected C37903bd zwA = null;
    private TextView zwB;

    public C17054l(Context context, C37903bd c37903bd) {
        super(context);
        AppMethodBeat.m2504i(34685);
        this.zwA = c37903bd;
        if (this.view != null) {
            OnClickListener c170583;
            this.jyC = this.view.findViewById(2131824110);
            this.jyD = this.view.findViewById(2131821629);
            WeImageView weImageView = (WeImageView) this.view.findViewById(2131825736);
            weImageView.setIconColor(((Context) this.vlu.get()).getResources().getColor(C25738R.color.a3_));
            this.zwB = (TextView) this.view.findViewById(2131825737);
            switch (this.zwA.type) {
                case 1:
                    weImageView.setImageResource(C1318a.icons_outlined_cellphone);
                    this.zwB.setText(C25738R.string.a5e);
                    break;
                case 2:
                    weImageView.setImageResource(C1318a.icons_outlined_contacts);
                    this.zwB.setText(C25738R.string.bu4);
                    break;
                case 3:
                    weImageView.setImageResource(C1318a.icons_outlined_avatar);
                    this.zwB.setText(C25738R.string.a5n);
                    break;
                case 4:
                    weImageView.setImageResource(C1318a.userguide_nearfriends_icon);
                    this.zwB.setText(C25738R.string.a5h);
                    break;
                case 6:
                    weImageView.setImageResource(C1318a.userguide_emostore_icon);
                    this.zwB.setText(C25738R.string.a5l);
                    break;
                case 7:
                    weImageView.setImageResource(C1318a.userguide_gamecenter_icon);
                    this.zwB.setText(C25738R.string.a5k);
                    break;
                case 8:
                    weImageView.setImageResource(C1318a.userguide_grounpmessage_icon);
                    this.zwB.setText(C25738R.string.a5m);
                    break;
                case 9:
                    weImageView.setImageResource(C1318a.userguide_moments_icon);
                    this.zwB.setText(C25738R.string.a5i);
                    break;
                case 10:
                    weImageView.setImageResource(C1318a.userguide_autoadd_icon);
                    this.zwB.setText(C25738R.string.a5b);
                    break;
            }
            View view = this.view;
            final int i = this.zwA.type;
            final int i2 = this.zwA.showType;
            switch (i) {
                case 1:
                    c170583 = new OnClickListener() {
                        public final void onClick(View view) {
                            AppMethodBeat.m2504i(34678);
                            C32776be.m53537ZV().mo53322co(i, i2);
                            C17054l.m26377D((Context) C17054l.this.vlu.get(), false);
                            AppMethodBeat.m2505o(34678);
                        }
                    };
                    break;
                case 2:
                    c170583 = new OnClickListener() {
                        public final void onClick(View view) {
                            AppMethodBeat.m2504i(34679);
                            C32776be.m53537ZV().mo53322co(i, i2);
                            C17054l.m26377D((Context) C17054l.this.vlu.get(), true);
                            AppMethodBeat.m2505o(34679);
                        }
                    };
                    break;
                case 3:
                    c170583 = new OnClickListener() {
                        public final void onClick(View view) {
                            AppMethodBeat.m2504i(34677);
                            C32776be.m53537ZV().mo53322co(i, i2);
                            Context context = (Context) C17054l.this.vlu.get();
                            if (context != null) {
                                C9638aw.m17190ZK();
                                if (C18628c.isSDCardAvailable()) {
                                    Intent intent = new Intent();
                                    intent.putExtra("intent_set_avatar", true);
                                    intent.putExtra("KEnterFromBanner", true);
                                    C25985d.m41467b(context, "setting", ".ui.setting.SettingsPersonalInfoUI", intent);
                                    C7060h.pYm.mo8381e(TXCStreamUploader.TXE_UPLOAD_INFO_PUSH_BEGIN, Integer.valueOf(4), Integer.valueOf(1));
                                } else {
                                    C23639t.m36492hO(context);
                                    AppMethodBeat.m2505o(34677);
                                    return;
                                }
                            }
                            AppMethodBeat.m2505o(34677);
                        }
                    };
                    break;
                case 4:
                    c170583 = new OnClickListener() {
                        public final void onClick(View view) {
                            AppMethodBeat.m2504i(34676);
                            C32776be.m53537ZV().mo53322co(i, i2);
                            Context context = (Context) C17054l.this.vlu.get();
                            if (context != null) {
                                C7060h.pYm.mo8381e(TXCStreamUploader.TXE_UPLOAD_INFO_PUSH_BEGIN, Integer.valueOf(5), Integer.valueOf(1));
                                C9638aw.m17190ZK();
                                boolean e = C5046bo.m7546e((Boolean) C18628c.m29072Ry().get(4103, null));
                                new Intent().putExtra("KEnterFromBanner", true);
                                if (e) {
                                    C32782bp aap = C32782bp.aap();
                                    if (aap == null) {
                                        C25985d.m41448H(context, "nearby", ".ui.NearbyPersonalInfoUI");
                                        AppMethodBeat.m2505o(34676);
                                        return;
                                    }
                                    String nullAsNil = C5046bo.nullAsNil(aap.getProvince());
                                    int a = C5046bo.m7512a(Integer.valueOf(aap.dtS), 0);
                                    if (C5046bo.isNullOrNil(nullAsNil) || a == 0) {
                                        C25985d.m41448H(context, "nearby", ".ui.NearbyPersonalInfoUI");
                                        AppMethodBeat.m2505o(34676);
                                        return;
                                    }
                                    LauncherUI instance = LauncherUI.getInstance();
                                    if (instance != null) {
                                        instance.yjJ.getMainTabUI().aqG("tab_find_friend");
                                    }
                                    C9089a.m16479fy(context);
                                } else {
                                    C25985d.m41448H(context, "nearby", ".ui.NearbyFriendsIntroUI");
                                    AppMethodBeat.m2505o(34676);
                                    return;
                                }
                            }
                            AppMethodBeat.m2505o(34676);
                        }
                    };
                    break;
                case 6:
                    c170583 = new OnClickListener() {
                        public final void onClick(View view) {
                            AppMethodBeat.m2504i(34680);
                            C32776be.m53537ZV().mo53322co(i, i2);
                            Context context = (Context) C17054l.this.vlu.get();
                            Intent intent = new Intent();
                            intent.putExtra("preceding_scence", 17);
                            C25985d.m41467b(context, "emoji", ".ui.v2.EmojiStoreV2UI", intent);
                            C7060h.pYm.mo8381e(TXCStreamUploader.TXE_UPLOAD_INFO_PUSH_BEGIN, Integer.valueOf(10), Integer.valueOf(1));
                            C7060h.pYm.mo8381e(12065, Integer.valueOf(2));
                            AppMethodBeat.m2505o(34680);
                        }
                    };
                    break;
                case 7:
                    c170583 = new OnClickListener() {
                        public final void onClick(View view) {
                            AppMethodBeat.m2504i(34681);
                            C32776be.m53537ZV().mo53322co(i, i2);
                            C25985d.m41448H((Context) C17054l.this.vlu.get(), "game", ".ui.GameCenterUI");
                            C7060h.pYm.mo8381e(TXCStreamUploader.TXE_UPLOAD_INFO_PUSH_BEGIN, Integer.valueOf(9), Integer.valueOf(1));
                            AppMethodBeat.m2505o(34681);
                        }
                    };
                    break;
                case 8:
                    c170583 = new OnClickListener() {
                        public final void onClick(View view) {
                            AppMethodBeat.m2504i(34682);
                            C32776be.m53537ZV().mo53322co(i, i2);
                            Context context = (Context) C17054l.this.vlu.get();
                            if (((C1853r.m3829YK() & 65536) == 0 ? 1 : 0) != 0) {
                                C25985d.m41448H(context, "masssend", ".ui.MassSendHistoryUI");
                            } else {
                                C25985d.m41467b(context, Scopes.PROFILE, ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", "masssendapp"));
                            }
                            C7060h.pYm.mo8381e(TXCStreamUploader.TXE_UPLOAD_INFO_PUSH_BEGIN, Integer.valueOf(11), Integer.valueOf(1));
                            AppMethodBeat.m2505o(34682);
                        }
                    };
                    break;
                case 9:
                    c170583 = new OnClickListener() {
                        public final void onClick(View view) {
                            boolean z;
                            AppMethodBeat.m2504i(34683);
                            C32776be.m53537ZV().mo53322co(i, i2);
                            Context context = (Context) C17054l.this.vlu.get();
                            C9638aw.m17190ZK();
                            String str = (String) C18628c.m29072Ry().get(68377, null);
                            C9638aw.m17190ZK();
                            C18628c.m29072Ry().set(68377, (Object) "");
                            Intent intent = new Intent();
                            intent.putExtra("sns_timeline_NeedFirstLoadint", true);
                            if (C5046bo.isNullOrNil(str)) {
                                z = true;
                            } else {
                                z = false;
                            }
                            if (C21877n.qFz != null && C21877n.qFz.baS() > 0) {
                                z = false;
                            }
                            intent.putExtra("sns_resume_state", z);
                            C25985d.m41467b(context, "sns", ".ui.SnsTimeLineUI", intent);
                            C7060h.pYm.mo8381e(TXCStreamUploader.TXE_UPLOAD_INFO_PUSH_BEGIN, Integer.valueOf(8), Integer.valueOf(1));
                            AppMethodBeat.m2505o(34683);
                        }
                    };
                    break;
                case 10:
                    c170583 = new OnClickListener() {
                        public final void onClick(View view) {
                            AppMethodBeat.m2504i(34684);
                            C32776be.m53537ZV().mo53322co(i, i2);
                            C25985d.m41467b((Context) C17054l.this.vlu.get(), "subapp", ".ui.autoadd.AutoAddFriendUI", new Intent());
                            AppMethodBeat.m2505o(34684);
                        }
                    };
                    break;
                default:
                    c170583 = null;
                    break;
            }
            view.setOnClickListener(c170583);
        }
        AppMethodBeat.m2505o(34685);
    }

    public final int getLayoutId() {
        return 2130970023;
    }

    public final void destroy() {
    }

    public final void setVisibility(int i) {
        AppMethodBeat.m2504i(34687);
        if (this.jyC != null) {
            this.jyC.setVisibility(i);
        }
        AppMethodBeat.m2505o(34687);
    }

    public final boolean aMN() {
        AppMethodBeat.m2504i(34686);
        if (this.nfA && this.eVH) {
            this.jyD.setBackgroundResource(C25738R.drawable.a3h);
            this.jyC.setBackground(null);
            this.zwB.setBackground(null);
        } else if (this.nfA) {
            this.jyD.setBackgroundResource(C25738R.drawable.f6802r9);
            this.jyC.setBackgroundResource(C25738R.drawable.b7t);
            this.zwB.setBackgroundResource(C25738R.drawable.a_q);
        } else if (this.eVH) {
            this.jyD.setBackgroundResource(C25738R.drawable.f6802r9);
            this.jyC.setBackgroundResource(C25738R.drawable.a_q);
            this.zwB.setBackground(null);
        } else {
            this.jyD.setBackgroundResource(C25738R.drawable.f6802r9);
            this.jyC.setBackground(null);
            this.zwB.setBackgroundResource(C25738R.drawable.a_q);
        }
        boolean aMN = super.aMN();
        AppMethodBeat.m2505o(34686);
        return aMN;
    }

    /* renamed from: D */
    static /* synthetic */ void m26377D(Context context, boolean z) {
        AppMethodBeat.m2504i(34688);
        if (context != null) {
            Intent intent = new Intent();
            intent.setClass(context, BindMContactIntroUI.class);
            intent.putExtra("key_upload_scene", 8);
            if (z) {
                intent.putExtra("bind_scene", 2);
            }
            intent.putExtra("KEnterFromBanner", true);
            MMWizardActivity.m23791J(context, intent);
            C42183e oP = C26407g.aaK().mo60654oP("4");
            if (oP != null && !C5046bo.isNullOrNil(oP.value) && (oP.value.equals("1") || oP.value.equals("2"))) {
                C26407g.aaK().mo60654oP("4").result = "1";
                C18608f.m29045oU("4");
                if (oP.value.equals("1")) {
                    C9638aw.m17190ZK();
                    C18628c.m29072Ry().set(328195, Boolean.TRUE);
                    AppMethodBeat.m2505o(34688);
                    return;
                }
                C9638aw.m17190ZK();
                C18628c.m29072Ry().set(328196, Boolean.TRUE);
                AppMethodBeat.m2505o(34688);
                return;
            } else if (z) {
                C7060h.pYm.mo8381e(TXCStreamUploader.TXE_UPLOAD_INFO_PUSH_BEGIN, Integer.valueOf(3), Integer.valueOf(1));
                AppMethodBeat.m2505o(34688);
                return;
            } else {
                C7060h.pYm.mo8381e(TXCStreamUploader.TXE_UPLOAD_INFO_PUSH_BEGIN, Integer.valueOf(1), Integer.valueOf(1));
            }
        }
        AppMethodBeat.m2505o(34688);
    }
}
