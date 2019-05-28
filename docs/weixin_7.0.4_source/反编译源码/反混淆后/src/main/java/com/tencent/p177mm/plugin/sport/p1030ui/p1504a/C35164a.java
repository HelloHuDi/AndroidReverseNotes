package com.tencent.p177mm.plugin.sport.p1030ui.p1504a;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C26415ao.C26417a;
import com.tencent.p177mm.model.C32798u;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p182ah.C41730b;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p184aj.C16527d;
import com.tencent.p177mm.p184aj.C17903f;
import com.tencent.p177mm.p184aj.C41747z;
import com.tencent.p177mm.p199ax.C32321b;
import com.tencent.p177mm.p199ax.C6328d;
import com.tencent.p177mm.p230g.p231a.C18372qb;
import com.tencent.p177mm.p264n.C7486a;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C44275p;
import com.tencent.p177mm.p612ui.base.preference.C15541f;
import com.tencent.p177mm.p612ui.base.preference.CheckBoxPreference;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.exdevice.p393ui.ExdeviceRankDataSourceUI;
import com.tencent.p177mm.plugin.messenger.p993a.C12519g;
import com.tencent.p177mm.plugin.p1140r.C16841a;
import com.tencent.p177mm.plugin.sport.model.C22168h;
import com.tencent.p177mm.plugin.sport.p1302a.C22162d;
import com.tencent.p177mm.plugin.sport.p1302a.C39858b;
import com.tencent.p177mm.pluginsdk.C46490h;
import com.tencent.p177mm.pluginsdk.model.C46498m;
import com.tencent.p177mm.pluginsdk.p1337b.C23233a;
import com.tencent.p177mm.pluginsdk.p597ui.preference.HelperHeaderPreference;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7616ad;
import java.util.ArrayList;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.sport.ui.a.a */
public final class C35164a implements C1202f, C23233a {
    Context context;
    private C15541f ehK;
    C7616ad ehM;
    private C44275p iGY;
    private CheckBoxPreference kRm;
    private CheckBoxPreference rQo;

    /* renamed from: com.tencent.mm.plugin.sport.ui.a.a$2 */
    class C351652 implements OnClickListener {
        C351652() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(25146);
            ((C46490h) C1720g.m3528K(C46490h.class)).mo41538a(C17903f.m28104qX(C35164a.this.ehM.field_username), (Activity) C35164a.this.context, C35164a.this.ehM);
            C35164a.this.biW();
            ((C39858b) C1720g.m3528K(C39858b.class)).cwc();
            C22168h.m33794lp(false);
            AppMethodBeat.m2505o(25146);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sport.ui.a.a$1 */
    class C351661 implements OnClickListener {
        C351661() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(25145);
            C22162d.m33785kT(25);
            C9638aw.m17190ZK();
            C18628c.m29080XO().mo15254Rh("gh_43f2581f6fd6");
            ((C39858b) C1720g.m3528K(C39858b.class)).cwc();
            AppMethodBeat.m2505o(25145);
        }
    }

    public C35164a(Context context) {
        this.context = context;
    }

    /* renamed from: a */
    public final boolean mo7078a(C15541f c15541f, C7616ad c7616ad, boolean z, int i) {
        AppMethodBeat.m2504i(25147);
        this.ehK = c15541f;
        this.ehM = c7616ad;
        c15541f.addPreferencesFromResource(C25738R.xml.f8495ac);
        this.rQo = (CheckBoxPreference) c15541f.aqO("contact_info_top_sport");
        this.kRm = (CheckBoxPreference) c15541f.aqO("contact_info_not_disturb");
        biW();
        AppMethodBeat.m2505o(25147);
        return true;
    }

    public final boolean biV() {
        return true;
    }

    /* renamed from: IO */
    public final boolean mo7077IO(String str) {
        AppMethodBeat.m2504i(25148);
        Intent intent;
        if ("contact_info_record_data".equals(str)) {
            this.context.startActivity(new Intent(this.context, ExdeviceRankDataSourceUI.class));
        } else if ("contact_info_top_sport".equals(str)) {
            if (this.rQo.isChecked()) {
                C22162d.m33785kT(20);
                C1855t.m3967w(this.ehM.field_username, true);
            } else {
                C22162d.m33785kT(21);
                C1855t.m3969x(this.ehM.field_username, true);
            }
        } else if ("contact_info_not_disturb".equals(str)) {
            if (this.kRm.isChecked()) {
                C22162d.m33785kT(22);
                C1855t.m3958o(this.ehM);
            } else {
                C22162d.m33785kT(23);
                C1855t.m3959p(this.ehM);
            }
        } else if ("contact_info_go_to_sport".equals(str)) {
            intent = new Intent();
            intent.putExtra("Chat_User", this.ehM.field_username);
            intent.putExtra("finish_direct", true);
            C25985d.m41473f(this.context, ".ui.chatting.ChattingUI", intent);
            C22162d.m33785kT(19);
        } else if ("contact_info_go_to_my_profile".equals(str)) {
            String Yz = C1853r.m3846Yz();
            if (C5046bo.isNullOrNil(Yz)) {
                C4990ab.m7412e("MicroMsg.Sport.ContactWidgetSport", "Get username from UserInfo return null or nil.");
                AppMethodBeat.m2505o(25148);
                return false;
            }
            Intent intent2 = new Intent();
            intent2.putExtra("username", Yz);
            C25985d.m41467b(this.context, "exdevice", ".ui.ExdeviceProfileUI", intent2);
            C22162d.m33785kT(3);
        } else if ("contact_info_invite_friend".equals(str)) {
            intent = new Intent();
            intent.putExtra("Select_Talker_Name", this.ehM.field_username);
            intent.putExtra("Select_block_List", this.ehM.field_username);
            intent.putExtra("Select_Conv_Type", 3);
            intent.putExtra("Select_Send_Card", true);
            intent.putExtra("mutil_select_is_ret", true);
            C25985d.m41466b(this.context, ".ui.transmit.SelectConversationUI", intent, 1);
            C22162d.m33785kT(4);
        } else if ("contact_info_common_problem".equals(str)) {
            intent = new Intent();
            intent.putExtra("KPublisherId", "custom_menu");
            intent.putExtra("pre_username", this.ehM.field_username);
            intent.putExtra("prePublishId", "custom_menu");
            intent.putExtra("preUsername", this.ehM.field_username);
            intent.putExtra("preChatName", this.ehM.field_username);
            intent.putExtra("preChatTYPE", C32798u.m53583ad(this.ehM.field_username, this.ehM.field_username));
            intent.putExtra("rawUrl", "https://support.weixin.qq.com/cgi-bin/mmsupport-bin/readtemplate?t=wechat_movement_faq/index");
            intent.putExtra("geta8key_username", this.ehM.field_username);
            intent.putExtra("from_scence", 1);
            C25985d.m41467b(this.context, "webview", ".ui.tools.WebViewUI", intent);
            C22162d.m33785kT(5);
        } else if ("contact_info_privacy_and_notification".equals(str)) {
            C25985d.m41448H(this.context, "exdevice", ".ui.ExdeviceSettingUI");
        } else if ("contact_info_sport_install".equals(str)) {
            C22162d.m33785kT(13);
            Context context = this.context;
            this.context.getString(C25738R.string.f9238tz);
            this.iGY = C30379h.m48458b(context, this.context.getString(C25738R.string.e_c), true, null);
            this.iGY.show();
            C9638aw.m17182Rg().mo14539a(30, (C1202f) this);
            LinkedList linkedList = new LinkedList();
            linkedList.add("gh_43f2581f6fd6");
            LinkedList linkedList2 = new LinkedList();
            linkedList2.add(Integer.valueOf(1));
            C9638aw.m17182Rg().mo14541a(new C46498m(1, linkedList, linkedList2, "", ""), 0);
            C22168h.m33794lp(true);
        } else if ("contact_info_sport_uninstall".equals(str)) {
            C22162d.m33785kT(14);
            C30379h.m48466d(this.context, this.context.getString(C25738R.string.e_g), "", this.context.getString(C25738R.string.f9078ou), this.context.getString(C25738R.string.f9076or), new C351652(), null);
        } else if ("contact_info_clear_data".equals(str)) {
            C30379h.m48466d(this.context, this.context.getString(C25738R.string.av9), "", this.context.getString(C25738R.string.f9078ou), this.context.getString(C25738R.string.f9076or), new C351661(), null);
        }
        AppMethodBeat.m2505o(25148);
        return false;
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(25149);
        if (i2 == -1) {
            switch (i) {
                case 1:
                    if (intent != null) {
                        ArrayList<String> P = C5046bo.m7508P(intent.getStringExtra("received_card_name").split(","));
                        String stringExtra = intent.getStringExtra("custom_send_text");
                        for (String str : P) {
                            C12519g.bOk().mo46462q("gh_43f2581f6fd6", str, C1855t.m3896kH(str));
                            if (!C5046bo.isNullOrNil(stringExtra)) {
                                C18372qb c18372qb = new C18372qb();
                                c18372qb.cMq.cMr = str;
                                c18372qb.cMq.content = stringExtra;
                                c18372qb.cMq.type = C1855t.m3925nK(str);
                                c18372qb.cMq.flags = 0;
                                C4879a.xxA.mo10055m(c18372qb);
                            }
                        }
                        break;
                    }
                    break;
            }
        }
        AppMethodBeat.m2505o(25149);
    }

    /* Access modifiers changed, original: final */
    public final void biW() {
        AppMethodBeat.m2504i(25150);
        HelperHeaderPreference helperHeaderPreference = (HelperHeaderPreference) this.ehK.aqO("contact_info_header_helper");
        helperHeaderPreference.mo74731ay(this.ehM.field_username, this.ehM.mo16707Oj(), this.context.getString(C25738R.string.b1q));
        if (C7486a.m12942jh(this.ehM.field_type)) {
            helperHeaderPreference.mo74732sd(1);
            this.ehK.mo27715ce("contact_info_sport_install", true);
            this.ehK.mo27715ce("contact_info_sport_uninstall", false);
            this.ehK.mo27715ce("contact_info_go_to_sport", false);
            this.ehK.mo27715ce("contact_info_go_to_my_profile", false);
            this.ehK.mo27715ce("contact_info_invite_friend", false);
            this.ehK.mo27715ce("contact_info_common_problem", false);
            this.ehK.mo27715ce("contact_info_record_data", false);
            this.ehK.mo27715ce("contact_info_privacy_and_notification", false);
            this.ehK.mo27715ce("contact_info_top_sport", false);
            this.ehK.mo27715ce("contact_info_not_disturb", false);
            C9638aw.m17190ZK();
            if (C18628c.m29083XR().aph(this.ehM.field_username)) {
                this.rQo.uOT = true;
            } else {
                this.rQo.uOT = false;
            }
            if (this.ehM.mo16673DX()) {
                this.kRm.uOT = true;
                AppMethodBeat.m2505o(25150);
                return;
            }
            this.kRm.uOT = false;
            AppMethodBeat.m2505o(25150);
            return;
        }
        helperHeaderPreference.mo74732sd(0);
        this.ehK.mo27715ce("contact_info_sport_install", false);
        this.ehK.mo27715ce("contact_info_sport_uninstall", true);
        this.ehK.mo27715ce("contact_info_go_to_sport", true);
        this.ehK.mo27715ce("contact_info_go_to_my_profile", true);
        this.ehK.mo27715ce("contact_info_invite_friend", true);
        this.ehK.mo27715ce("contact_info_common_problem", true);
        this.ehK.mo27715ce("contact_info_record_data", true);
        this.ehK.mo27715ce("contact_info_privacy_and_notification", true);
        this.ehK.mo27715ce("contact_info_top_sport", true);
        this.ehK.mo27715ce("contact_info_not_disturb", true);
        AppMethodBeat.m2505o(25150);
    }

    public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(25151);
        if (c1207m instanceof C46498m) {
            C9638aw.m17182Rg().mo14546b(30, (C1202f) this);
            if (i == 0 && i2 == 0) {
                String dhl = ((C46498m) c1207m).dhl();
                C4990ab.m7417i("MicroMsg.Sport.ContactWidgetSport", "bind fitness contact %s success", dhl);
                C9638aw.m17190ZK();
                C7616ad aoO = C18628c.m29078XM().aoO("gh_43f2581f6fd6");
                if (aoO == null || C5046bo.isNullOrNil(dhl)) {
                    C4990ab.m7412e("MicroMsg.Sport.ContactWidgetSport", "respUsername == " + dhl + ", contact = " + aoO);
                } else {
                    C16527d c16527d = null;
                    if (C1855t.m3911mX(aoO.field_username)) {
                        String nullAsNil = C5046bo.nullAsNil(aoO.field_username);
                        c16527d = C17903f.m28104qX(nullAsNil);
                        if (c16527d != null) {
                            c16527d.field_username = dhl;
                        }
                        C41747z.aeR().delete(nullAsNil);
                        aoO.mo14709iH(nullAsNil);
                    }
                    aoO.setUsername(dhl);
                    if (((int) aoO.ewQ) == 0) {
                        C9638aw.m17190ZK();
                        C18628c.m29078XM().mo15708aa(aoO);
                    }
                    if (((int) aoO.ewQ) <= 0) {
                        C4990ab.m7412e("MicroMsg.Sport.ContactWidgetSport", "addContact : insert contact failed");
                    } else {
                        C1855t.m3960q(aoO);
                        C9638aw.m17190ZK();
                        C7616ad aoO2 = C18628c.m29078XM().aoO(aoO.field_username);
                        if (c16527d != null) {
                            C41747z.aeR().mo43724d(c16527d);
                        } else {
                            c16527d = C17903f.m28104qX(aoO2.field_username);
                            if (c16527d == null || c16527d.adJ()) {
                                C4990ab.m7410d("MicroMsg.Sport.ContactWidgetSport", "shouldUpdate");
                                C26417a.flu.mo20967ai(aoO2.field_username, "");
                                C41730b.m73506pY(aoO2.field_username);
                            } else if (aoO2.dsi()) {
                                C4990ab.m7411d("MicroMsg.Sport.ContactWidgetSport", "update contact, last check time=%d", Integer.valueOf(aoO2.duj));
                                C26417a.flu.mo20967ai(aoO2.field_username, "");
                                C41730b.m73506pY(aoO2.field_username);
                            }
                        }
                    }
                }
                C41747z.aeR().mo43726e(C41747z.aeR().mo43729qP(aoO.field_username));
                C9638aw.m17190ZK();
                C18628c.m29072Ry().set(327825, Boolean.TRUE);
                C16841a.bVt();
                C6328d.m10411b(C32321b.fKF, C32321b.fKB, "", null);
                C4990ab.m7417i("MicroMsg.NewTipsManager", "dancy register local newtips, tipsId:%s, tipsVersion:%s, key:%s", Integer.valueOf(r0), Integer.valueOf(1), "");
            } else {
                C4990ab.m7413e("MicroMsg.Sport.ContactWidgetSport", "errType %d | errCode %d | errMsg %s", Integer.valueOf(i), Integer.valueOf(i2), str);
                if (i == 4 && i2 == -24 && !C5046bo.isNullOrNil(str)) {
                    Toast.makeText(C4996ah.getContext(), str, 1).show();
                }
            }
            if (this.iGY != null) {
                this.iGY.dismiss();
            }
            biW();
        }
        AppMethodBeat.m2505o(25151);
    }
}
