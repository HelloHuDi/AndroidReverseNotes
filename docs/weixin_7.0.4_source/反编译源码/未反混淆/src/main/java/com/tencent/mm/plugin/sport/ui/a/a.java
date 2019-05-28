package com.tencent.mm.plugin.sport.ui.a;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.aj.z;
import com.tencent.mm.g.a.qb;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.model.r;
import com.tencent.mm.model.t;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.exdevice.ui.ExdeviceRankDataSourceUI;
import com.tencent.mm.plugin.sport.a.b;
import com.tencent.mm.plugin.sport.a.d;
import com.tencent.mm.pluginsdk.model.m;
import com.tencent.mm.pluginsdk.ui.preference.HelperHeaderPreference;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import java.util.ArrayList;
import java.util.LinkedList;

public final class a implements f, com.tencent.mm.pluginsdk.b.a {
    Context context;
    private com.tencent.mm.ui.base.preference.f ehK;
    ad ehM;
    private p iGY;
    private CheckBoxPreference kRm;
    private CheckBoxPreference rQo;

    public a(Context context) {
        this.context = context;
    }

    public final boolean a(com.tencent.mm.ui.base.preference.f fVar, ad adVar, boolean z, int i) {
        AppMethodBeat.i(25147);
        this.ehK = fVar;
        this.ehM = adVar;
        fVar.addPreferencesFromResource(R.xml.ac);
        this.rQo = (CheckBoxPreference) fVar.aqO("contact_info_top_sport");
        this.kRm = (CheckBoxPreference) fVar.aqO("contact_info_not_disturb");
        biW();
        AppMethodBeat.o(25147);
        return true;
    }

    public final boolean biV() {
        return true;
    }

    public final boolean IO(String str) {
        AppMethodBeat.i(25148);
        Intent intent;
        if ("contact_info_record_data".equals(str)) {
            this.context.startActivity(new Intent(this.context, ExdeviceRankDataSourceUI.class));
        } else if ("contact_info_top_sport".equals(str)) {
            if (this.rQo.isChecked()) {
                d.kT(20);
                t.w(this.ehM.field_username, true);
            } else {
                d.kT(21);
                t.x(this.ehM.field_username, true);
            }
        } else if ("contact_info_not_disturb".equals(str)) {
            if (this.kRm.isChecked()) {
                d.kT(22);
                t.o(this.ehM);
            } else {
                d.kT(23);
                t.p(this.ehM);
            }
        } else if ("contact_info_go_to_sport".equals(str)) {
            intent = new Intent();
            intent.putExtra("Chat_User", this.ehM.field_username);
            intent.putExtra("finish_direct", true);
            com.tencent.mm.bp.d.f(this.context, ".ui.chatting.ChattingUI", intent);
            d.kT(19);
        } else if ("contact_info_go_to_my_profile".equals(str)) {
            String Yz = r.Yz();
            if (bo.isNullOrNil(Yz)) {
                ab.e("MicroMsg.Sport.ContactWidgetSport", "Get username from UserInfo return null or nil.");
                AppMethodBeat.o(25148);
                return false;
            }
            Intent intent2 = new Intent();
            intent2.putExtra("username", Yz);
            com.tencent.mm.bp.d.b(this.context, "exdevice", ".ui.ExdeviceProfileUI", intent2);
            d.kT(3);
        } else if ("contact_info_invite_friend".equals(str)) {
            intent = new Intent();
            intent.putExtra("Select_Talker_Name", this.ehM.field_username);
            intent.putExtra("Select_block_List", this.ehM.field_username);
            intent.putExtra("Select_Conv_Type", 3);
            intent.putExtra("Select_Send_Card", true);
            intent.putExtra("mutil_select_is_ret", true);
            com.tencent.mm.bp.d.b(this.context, ".ui.transmit.SelectConversationUI", intent, 1);
            d.kT(4);
        } else if ("contact_info_common_problem".equals(str)) {
            intent = new Intent();
            intent.putExtra("KPublisherId", "custom_menu");
            intent.putExtra("pre_username", this.ehM.field_username);
            intent.putExtra("prePublishId", "custom_menu");
            intent.putExtra("preUsername", this.ehM.field_username);
            intent.putExtra("preChatName", this.ehM.field_username);
            intent.putExtra("preChatTYPE", u.ad(this.ehM.field_username, this.ehM.field_username));
            intent.putExtra("rawUrl", "https://support.weixin.qq.com/cgi-bin/mmsupport-bin/readtemplate?t=wechat_movement_faq/index");
            intent.putExtra("geta8key_username", this.ehM.field_username);
            intent.putExtra("from_scence", 1);
            com.tencent.mm.bp.d.b(this.context, "webview", ".ui.tools.WebViewUI", intent);
            d.kT(5);
        } else if ("contact_info_privacy_and_notification".equals(str)) {
            com.tencent.mm.bp.d.H(this.context, "exdevice", ".ui.ExdeviceSettingUI");
        } else if ("contact_info_sport_install".equals(str)) {
            d.kT(13);
            Context context = this.context;
            this.context.getString(R.string.tz);
            this.iGY = h.b(context, this.context.getString(R.string.e_c), true, null);
            this.iGY.show();
            aw.Rg().a(30, (f) this);
            LinkedList linkedList = new LinkedList();
            linkedList.add("gh_43f2581f6fd6");
            LinkedList linkedList2 = new LinkedList();
            linkedList2.add(Integer.valueOf(1));
            aw.Rg().a(new m(1, linkedList, linkedList2, "", ""), 0);
            com.tencent.mm.plugin.sport.model.h.lp(true);
        } else if ("contact_info_sport_uninstall".equals(str)) {
            d.kT(14);
            h.d(this.context, this.context.getString(R.string.e_g), "", this.context.getString(R.string.ou), this.context.getString(R.string.or), new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(25146);
                    ((com.tencent.mm.pluginsdk.h) g.K(com.tencent.mm.pluginsdk.h.class)).a(com.tencent.mm.aj.f.qX(a.this.ehM.field_username), (Activity) a.this.context, a.this.ehM);
                    a.this.biW();
                    ((b) g.K(b.class)).cwc();
                    com.tencent.mm.plugin.sport.model.h.lp(false);
                    AppMethodBeat.o(25146);
                }
            }, null);
        } else if ("contact_info_clear_data".equals(str)) {
            h.d(this.context, this.context.getString(R.string.av9), "", this.context.getString(R.string.ou), this.context.getString(R.string.or), new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(25145);
                    d.kT(25);
                    aw.ZK();
                    c.XO().Rh("gh_43f2581f6fd6");
                    ((b) g.K(b.class)).cwc();
                    AppMethodBeat.o(25145);
                }
            }, null);
        }
        AppMethodBeat.o(25148);
        return false;
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(25149);
        if (i2 == -1) {
            switch (i) {
                case 1:
                    if (intent != null) {
                        ArrayList<String> P = bo.P(intent.getStringExtra("received_card_name").split(","));
                        String stringExtra = intent.getStringExtra("custom_send_text");
                        for (String str : P) {
                            com.tencent.mm.plugin.messenger.a.g.bOk().q("gh_43f2581f6fd6", str, t.kH(str));
                            if (!bo.isNullOrNil(stringExtra)) {
                                qb qbVar = new qb();
                                qbVar.cMq.cMr = str;
                                qbVar.cMq.content = stringExtra;
                                qbVar.cMq.type = t.nK(str);
                                qbVar.cMq.flags = 0;
                                com.tencent.mm.sdk.b.a.xxA.m(qbVar);
                            }
                        }
                        break;
                    }
                    break;
            }
        }
        AppMethodBeat.o(25149);
    }

    /* Access modifiers changed, original: final */
    public final void biW() {
        AppMethodBeat.i(25150);
        HelperHeaderPreference helperHeaderPreference = (HelperHeaderPreference) this.ehK.aqO("contact_info_header_helper");
        helperHeaderPreference.ay(this.ehM.field_username, this.ehM.Oj(), this.context.getString(R.string.b1q));
        if (com.tencent.mm.n.a.jh(this.ehM.field_type)) {
            helperHeaderPreference.sd(1);
            this.ehK.ce("contact_info_sport_install", true);
            this.ehK.ce("contact_info_sport_uninstall", false);
            this.ehK.ce("contact_info_go_to_sport", false);
            this.ehK.ce("contact_info_go_to_my_profile", false);
            this.ehK.ce("contact_info_invite_friend", false);
            this.ehK.ce("contact_info_common_problem", false);
            this.ehK.ce("contact_info_record_data", false);
            this.ehK.ce("contact_info_privacy_and_notification", false);
            this.ehK.ce("contact_info_top_sport", false);
            this.ehK.ce("contact_info_not_disturb", false);
            aw.ZK();
            if (c.XR().aph(this.ehM.field_username)) {
                this.rQo.uOT = true;
            } else {
                this.rQo.uOT = false;
            }
            if (this.ehM.DX()) {
                this.kRm.uOT = true;
                AppMethodBeat.o(25150);
                return;
            }
            this.kRm.uOT = false;
            AppMethodBeat.o(25150);
            return;
        }
        helperHeaderPreference.sd(0);
        this.ehK.ce("contact_info_sport_install", false);
        this.ehK.ce("contact_info_sport_uninstall", true);
        this.ehK.ce("contact_info_go_to_sport", true);
        this.ehK.ce("contact_info_go_to_my_profile", true);
        this.ehK.ce("contact_info_invite_friend", true);
        this.ehK.ce("contact_info_common_problem", true);
        this.ehK.ce("contact_info_record_data", true);
        this.ehK.ce("contact_info_privacy_and_notification", true);
        this.ehK.ce("contact_info_top_sport", true);
        this.ehK.ce("contact_info_not_disturb", true);
        AppMethodBeat.o(25150);
    }

    public final void onSceneEnd(int i, int i2, String str, com.tencent.mm.ai.m mVar) {
        AppMethodBeat.i(25151);
        if (mVar instanceof m) {
            aw.Rg().b(30, (f) this);
            if (i == 0 && i2 == 0) {
                String dhl = ((m) mVar).dhl();
                ab.i("MicroMsg.Sport.ContactWidgetSport", "bind fitness contact %s success", dhl);
                aw.ZK();
                ad aoO = c.XM().aoO("gh_43f2581f6fd6");
                if (aoO == null || bo.isNullOrNil(dhl)) {
                    ab.e("MicroMsg.Sport.ContactWidgetSport", "respUsername == " + dhl + ", contact = " + aoO);
                } else {
                    com.tencent.mm.aj.d dVar = null;
                    if (t.mX(aoO.field_username)) {
                        String nullAsNil = bo.nullAsNil(aoO.field_username);
                        dVar = com.tencent.mm.aj.f.qX(nullAsNil);
                        if (dVar != null) {
                            dVar.field_username = dhl;
                        }
                        z.aeR().delete(nullAsNil);
                        aoO.iH(nullAsNil);
                    }
                    aoO.setUsername(dhl);
                    if (((int) aoO.ewQ) == 0) {
                        aw.ZK();
                        c.XM().aa(aoO);
                    }
                    if (((int) aoO.ewQ) <= 0) {
                        ab.e("MicroMsg.Sport.ContactWidgetSport", "addContact : insert contact failed");
                    } else {
                        t.q(aoO);
                        aw.ZK();
                        ad aoO2 = c.XM().aoO(aoO.field_username);
                        if (dVar != null) {
                            z.aeR().d(dVar);
                        } else {
                            dVar = com.tencent.mm.aj.f.qX(aoO2.field_username);
                            if (dVar == null || dVar.adJ()) {
                                ab.d("MicroMsg.Sport.ContactWidgetSport", "shouldUpdate");
                                com.tencent.mm.model.ao.a.flu.ai(aoO2.field_username, "");
                                com.tencent.mm.ah.b.pY(aoO2.field_username);
                            } else if (aoO2.dsi()) {
                                ab.d("MicroMsg.Sport.ContactWidgetSport", "update contact, last check time=%d", Integer.valueOf(aoO2.duj));
                                com.tencent.mm.model.ao.a.flu.ai(aoO2.field_username, "");
                                com.tencent.mm.ah.b.pY(aoO2.field_username);
                            }
                        }
                    }
                }
                z.aeR().e(z.aeR().qP(aoO.field_username));
                aw.ZK();
                c.Ry().set(327825, Boolean.TRUE);
                com.tencent.mm.plugin.r.a.bVt();
                com.tencent.mm.ax.d.b(com.tencent.mm.ax.b.fKF, com.tencent.mm.ax.b.fKB, "", null);
                ab.i("MicroMsg.NewTipsManager", "dancy register local newtips, tipsId:%s, tipsVersion:%s, key:%s", Integer.valueOf(r0), Integer.valueOf(1), "");
            } else {
                ab.e("MicroMsg.Sport.ContactWidgetSport", "errType %d | errCode %d | errMsg %s", Integer.valueOf(i), Integer.valueOf(i2), str);
                if (i == 4 && i2 == -24 && !bo.isNullOrNil(str)) {
                    Toast.makeText(ah.getContext(), str, 1).show();
                }
            }
            if (this.iGY != null) {
                this.iGY.dismiss();
            }
            biW();
        }
        AppMethodBeat.o(25151);
    }
}
