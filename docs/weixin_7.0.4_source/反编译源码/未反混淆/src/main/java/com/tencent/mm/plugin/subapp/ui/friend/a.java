package com.tencent.mm.plugin.subapp.ui.friend;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.google.android.gms.common.Scopes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.bi.d;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.subapp.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.av;
import com.tencent.mm.storage.ax;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.u;
import junit.framework.Assert;

public final class a implements OnItemClickListener {
    private Context context;
    private boolean fsN = false;
    private b stw;

    public a(Context context, b bVar, boolean z) {
        this.context = context;
        this.stw = bVar;
        this.fsN = z;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        AppMethodBeat.i(25341);
        if (this.fsN) {
            i -= 2;
        }
        av avVar = (av) this.stw.getItem(i);
        if (avVar == null) {
            ab.e("MicroMsg.FConversationOnItemClickListener", "onItemClick, item is null, pos = ".concat(String.valueOf(i)));
            AppMethodBeat.o(25341);
            return;
        }
        h(this.context, avVar.field_talker, false);
        AppMethodBeat.o(25341);
    }

    public static void h(Context context, String str, boolean z) {
        AppMethodBeat.i(25342);
        if (str == null || str.length() == 0) {
            ab.e("MicroMsg.FConversationOnItemClickListener", "dealOnClick fail, talker is null");
            AppMethodBeat.o(25342);
            return;
        }
        ab.d("MicroMsg.FConversationOnItemClickListener", "dealOnClick, talker = ".concat(String.valueOf(str)));
        d.akP().apt(str);
        ax apx = d.akO().apx(str);
        if (apx == null) {
            ab.e("MicroMsg.FConversationOnItemClickListener", "onItemClick, lastRecvFmsg is null, talker = ".concat(String.valueOf(str)));
            AppMethodBeat.o(25342);
        } else if (apx.field_type == 0) {
            a(context, apx);
            AppMethodBeat.o(25342);
        } else {
            a(context, apx, z);
            AppMethodBeat.o(25342);
        }
    }

    private static void a(Context context, ax axVar) {
        AppMethodBeat.i(25343);
        aw.ZK();
        com.tencent.mm.storage.bi.a Rn = c.XO().Rn(axVar.field_msgContent);
        if (Rn == null) {
            AppMethodBeat.o(25343);
        } else if (Rn.svN.length() <= 0) {
            AppMethodBeat.o(25343);
        } else {
            Bundle bundle = new Bundle();
            bundle.putBoolean("Contact_ShowFMessageList", true);
            bundle.putInt("Contact_Source_FMessage", Rn.scene);
            aw.ZK();
            ad aoO = c.XM().aoO(Rn.svN);
            if (aoO != null && ((int) aoO.ewQ) > 0 && com.tencent.mm.n.a.jh(aoO.field_type)) {
                b.gkF.a(context, aoO, Rn, bundle, "");
                AppMethodBeat.o(25343);
            } else if (Rn.pnz > 0) {
                if (bo.isNullOrNil(Rn.gwK) && bo.isNullOrNil(Rn.gwH) && !bo.isNullOrNil(Rn.nickname)) {
                    bundle.putString("Contact_QQNick", Rn.nickname);
                }
                b.gkF.a(context, Rn, bundle);
                AppMethodBeat.o(25343);
            } else if (bo.isNullOrNil(Rn.xZi) && bo.isNullOrNil(Rn.xZj)) {
                b.gkF.a(context, Rn, bundle);
                AppMethodBeat.o(25343);
            } else {
                com.tencent.mm.plugin.account.friend.a.a vW = com.tencent.mm.plugin.account.a.getAddrUploadStg().vW(Rn.xZi);
                if (vW == null || vW.Aq() == null || vW.Aq().length() <= 0) {
                    vW = com.tencent.mm.plugin.account.a.getAddrUploadStg().vW(Rn.xZj);
                    if (vW == null || vW.Aq() == null || vW.Aq().length() <= 0) {
                        if (aoO == null || ((int) aoO.ewQ) <= 0) {
                            b.gkF.a(context, Rn, bundle);
                        } else {
                            b.gkF.a(context, aoO, Rn, bundle, "");
                        }
                        ab.e("MicroMsg.FConversationOnItemClickListener", "error : this is not the mobile contact, MD5 = " + Rn.xZi + " fullMD5:" + Rn.xZj);
                        AppMethodBeat.o(25343);
                        return;
                    }
                }
                if (vW.getUsername() == null || vW.getUsername().length() <= 0) {
                    vW.username = Rn.svN;
                    vW.bJt = 128;
                    if (com.tencent.mm.plugin.account.a.getAddrUploadStg().a(vW.Aq(), vW) == -1) {
                        ab.e("MicroMsg.FConversationOnItemClickListener", "update mobile contact username failed");
                        AppMethodBeat.o(25343);
                        return;
                    }
                }
                b.gkF.a(context, Rn, bundle);
                AppMethodBeat.o(25343);
            }
        }
    }

    public static void a(Context context, ax axVar, boolean z) {
        AppMethodBeat.i(25344);
        String str = axVar.field_msgContent;
        ab.w("MicroMsg.FConversationOnItemClickListener", "dealClickVerifyMsgEvent : ".concat(String.valueOf(str)));
        if (str == null || str.length() <= 0) {
            AppMethodBeat.o(25344);
            return;
        }
        aw.ZK();
        bi.d Rm = c.XO().Rm(str);
        if (!(Rm == null || bo.isNullOrNil(Rm.svN))) {
            Assert.assertTrue(Rm.svN.length() > 0);
            aw.ZK();
            ad aoO = c.XM().aoO(Rm.svN);
            Intent intent = new Intent();
            if (z) {
                intent.putExtra("Accept_NewFriend_FromOutside", true);
            }
            intent.putExtra("Contact_ShowUserName", false);
            intent.putExtra("Contact_ShowFMessageList", true);
            intent.putExtra("Contact_Scene", Rm.scene);
            intent.putExtra("Verify_ticket", Rm.mGZ);
            intent.putExtra("Contact_Source_FMessage", Rm.scene);
            if (aoO == null || ((int) aoO.ewQ) <= 0 || !com.tencent.mm.n.a.jh(aoO.field_type)) {
                if (axVar.field_type == 1 || axVar.field_type == 2) {
                    intent.putExtra("User_Verify", true);
                }
                intent.putExtra("Contact_User", Rm.svN);
                intent.putExtra("Contact_Alias", Rm.dFl);
                intent.putExtra("Contact_Nick", Rm.nickname);
                intent.putExtra("Contact_QuanPin", Rm.gwG);
                intent.putExtra("Contact_PyInitial", Rm.gwF);
                intent.putExtra("Contact_Sex", Rm.dtS);
                intent.putExtra("Contact_Signature", Rm.signature);
                intent.putExtra("Contact_FMessageCard", true);
                intent.putExtra("Contact_City", Rm.getCity());
                intent.putExtra("Contact_Province", Rm.getProvince());
                intent.putExtra("Contact_Mobile_MD5", Rm.xZi);
                intent.putExtra("Contact_full_Mobile_MD5", Rm.xZj);
                intent.putExtra("Contact_KSnsBgUrl", Rm.xZw);
            } else {
                intent.putExtra("Contact_User", aoO.field_username);
                b.gkF.a(intent, aoO.field_username);
            }
            str = Rm.content;
            if (bo.nullAsNil(str).length() <= 0) {
                switch (Rm.scene) {
                    case 18:
                    case 22:
                    case 23:
                    case 24:
                    case 25:
                    case 26:
                    case 27:
                    case com.tencent.view.d.MIC_BASE_CHANNELSHARPEN /*28*/:
                    case 29:
                        str = context.getString(R.string.al3);
                        break;
                    default:
                        str = context.getString(R.string.akz);
                        break;
                }
            }
            intent.putExtra("Contact_Content", str);
            if (Rm.xZy == 1 && !bo.isNullOrNil(Rm.xZA)) {
                intent.putExtra("Safety_Warning_Detail", Rm.xZA);
            }
            intent.putExtra("Contact_verify_Scene", Rm.scene);
            if ((Rm.scene == 14 || Rm.scene == 8) && !bo.isNullOrNil(Rm.chatroomName)) {
                aw.ZK();
                u oa = c.XV().oa(Rm.chatroomName);
                if (oa != null) {
                    intent.putExtra("Contact_RoomNickname", oa.mJ(Rm.svN));
                }
            }
            intent.putExtra("Contact_Uin", Rm.pnz);
            intent.putExtra("Contact_QQNick", Rm.gwH);
            intent.putExtra("Contact_Mobile_MD5", Rm.xZi);
            intent.putExtra("User_From_Fmessage", true);
            intent.putExtra("Contact_from_msgType", 37);
            if (aoO == null || !com.tencent.mm.n.a.jh(aoO.field_type)) {
                intent.putExtra("Contact_KSnsIFlag", 0);
            }
            intent.putExtra("Contact_KSnsBgUrl", Rm.xZw);
            intent.putExtra("verify_gmail", Rm.gta);
            intent.putExtra("source_from_user_name", Rm.ijx);
            intent.putExtra("source_from_nick_name", Rm.vjM);
            com.tencent.mm.bp.d.b(context, Scopes.PROFILE, ".ui.ContactInfoUI", intent);
        }
        AppMethodBeat.o(25344);
    }
}
