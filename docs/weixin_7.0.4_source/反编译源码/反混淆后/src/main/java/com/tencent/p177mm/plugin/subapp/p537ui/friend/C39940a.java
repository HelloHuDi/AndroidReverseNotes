package com.tencent.p177mm.plugin.subapp.p537ui.friend;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.google.android.gms.common.Scopes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p1374bi.C41789d;
import com.tencent.p177mm.p264n.C7486a;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.account.C32923a;
import com.tencent.p177mm.plugin.account.friend.p272a.C18817a;
import com.tencent.p177mm.plugin.subapp.C24837b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7568av;
import com.tencent.p177mm.storage.C7569ax;
import com.tencent.p177mm.storage.C7577u;
import com.tencent.p177mm.storage.C7616ad;
import com.tencent.p177mm.storage.C7620bi.C5135a;
import com.tencent.p177mm.storage.C7620bi.C5138d;
import com.tencent.view.C31128d;
import junit.framework.Assert;

/* renamed from: com.tencent.mm.plugin.subapp.ui.friend.a */
public final class C39940a implements OnItemClickListener {
    private Context context;
    private boolean fsN = false;
    private C29396b stw;

    public C39940a(Context context, C29396b c29396b, boolean z) {
        this.context = context;
        this.stw = c29396b;
        this.fsN = z;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        AppMethodBeat.m2504i(25341);
        if (this.fsN) {
            i -= 2;
        }
        C7568av c7568av = (C7568av) this.stw.getItem(i);
        if (c7568av == null) {
            C4990ab.m7412e("MicroMsg.FConversationOnItemClickListener", "onItemClick, item is null, pos = ".concat(String.valueOf(i)));
            AppMethodBeat.m2505o(25341);
            return;
        }
        C39940a.m68403h(this.context, c7568av.field_talker, false);
        AppMethodBeat.m2505o(25341);
    }

    /* renamed from: h */
    public static void m68403h(Context context, String str, boolean z) {
        AppMethodBeat.m2504i(25342);
        if (str == null || str.length() == 0) {
            C4990ab.m7412e("MicroMsg.FConversationOnItemClickListener", "dealOnClick fail, talker is null");
            AppMethodBeat.m2505o(25342);
            return;
        }
        C4990ab.m7410d("MicroMsg.FConversationOnItemClickListener", "dealOnClick, talker = ".concat(String.valueOf(str)));
        C41789d.akP().apt(str);
        C7569ax apx = C41789d.akO().apx(str);
        if (apx == null) {
            C4990ab.m7412e("MicroMsg.FConversationOnItemClickListener", "onItemClick, lastRecvFmsg is null, talker = ".concat(String.valueOf(str)));
            AppMethodBeat.m2505o(25342);
        } else if (apx.field_type == 0) {
            C39940a.m68401a(context, apx);
            AppMethodBeat.m2505o(25342);
        } else {
            C39940a.m68402a(context, apx, z);
            AppMethodBeat.m2505o(25342);
        }
    }

    /* renamed from: a */
    private static void m68401a(Context context, C7569ax c7569ax) {
        AppMethodBeat.m2504i(25343);
        C9638aw.m17190ZK();
        C5135a Rn = C18628c.m29080XO().mo15260Rn(c7569ax.field_msgContent);
        if (Rn == null) {
            AppMethodBeat.m2505o(25343);
        } else if (Rn.svN.length() <= 0) {
            AppMethodBeat.m2505o(25343);
        } else {
            Bundle bundle = new Bundle();
            bundle.putBoolean("Contact_ShowFMessageList", true);
            bundle.putInt("Contact_Source_FMessage", Rn.scene);
            C9638aw.m17190ZK();
            C7616ad aoO = C18628c.m29078XM().aoO(Rn.svN);
            if (aoO != null && ((int) aoO.ewQ) > 0 && C7486a.m12942jh(aoO.field_type)) {
                C24837b.gkF.mo38853a(context, aoO, Rn, bundle, "");
                AppMethodBeat.m2505o(25343);
            } else if (Rn.pnz > 0) {
                if (C5046bo.isNullOrNil(Rn.gwK) && C5046bo.isNullOrNil(Rn.gwH) && !C5046bo.isNullOrNil(Rn.nickname)) {
                    bundle.putString("Contact_QQNick", Rn.nickname);
                }
                C24837b.gkF.mo38854a(context, Rn, bundle);
                AppMethodBeat.m2505o(25343);
            } else if (C5046bo.isNullOrNil(Rn.xZi) && C5046bo.isNullOrNil(Rn.xZj)) {
                C24837b.gkF.mo38854a(context, Rn, bundle);
                AppMethodBeat.m2505o(25343);
            } else {
                C18817a vW = C32923a.getAddrUploadStg().mo34092vW(Rn.xZi);
                if (vW == null || vW.mo34067Aq() == null || vW.mo34067Aq().length() <= 0) {
                    vW = C32923a.getAddrUploadStg().mo34092vW(Rn.xZj);
                    if (vW == null || vW.mo34067Aq() == null || vW.mo34067Aq().length() <= 0) {
                        if (aoO == null || ((int) aoO.ewQ) <= 0) {
                            C24837b.gkF.mo38854a(context, Rn, bundle);
                        } else {
                            C24837b.gkF.mo38853a(context, aoO, Rn, bundle, "");
                        }
                        C4990ab.m7412e("MicroMsg.FConversationOnItemClickListener", "error : this is not the mobile contact, MD5 = " + Rn.xZi + " fullMD5:" + Rn.xZj);
                        AppMethodBeat.m2505o(25343);
                        return;
                    }
                }
                if (vW.getUsername() == null || vW.getUsername().length() <= 0) {
                    vW.username = Rn.svN;
                    vW.bJt = 128;
                    if (C32923a.getAddrUploadStg().mo34084a(vW.mo34067Aq(), vW) == -1) {
                        C4990ab.m7412e("MicroMsg.FConversationOnItemClickListener", "update mobile contact username failed");
                        AppMethodBeat.m2505o(25343);
                        return;
                    }
                }
                C24837b.gkF.mo38854a(context, Rn, bundle);
                AppMethodBeat.m2505o(25343);
            }
        }
    }

    /* renamed from: a */
    public static void m68402a(Context context, C7569ax c7569ax, boolean z) {
        AppMethodBeat.m2504i(25344);
        String str = c7569ax.field_msgContent;
        C4990ab.m7420w("MicroMsg.FConversationOnItemClickListener", "dealClickVerifyMsgEvent : ".concat(String.valueOf(str)));
        if (str == null || str.length() <= 0) {
            AppMethodBeat.m2505o(25344);
            return;
        }
        C9638aw.m17190ZK();
        C5138d Rm = C18628c.m29080XO().mo15259Rm(str);
        if (!(Rm == null || C5046bo.isNullOrNil(Rm.svN))) {
            Assert.assertTrue(Rm.svN.length() > 0);
            C9638aw.m17190ZK();
            C7616ad aoO = C18628c.m29078XM().aoO(Rm.svN);
            Intent intent = new Intent();
            if (z) {
                intent.putExtra("Accept_NewFriend_FromOutside", true);
            }
            intent.putExtra("Contact_ShowUserName", false);
            intent.putExtra("Contact_ShowFMessageList", true);
            intent.putExtra("Contact_Scene", Rm.scene);
            intent.putExtra("Verify_ticket", Rm.mGZ);
            intent.putExtra("Contact_Source_FMessage", Rm.scene);
            if (aoO == null || ((int) aoO.ewQ) <= 0 || !C7486a.m12942jh(aoO.field_type)) {
                if (c7569ax.field_type == 1 || c7569ax.field_type == 2) {
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
                C24837b.gkF.mo38856a(intent, aoO.field_username);
            }
            str = Rm.content;
            if (C5046bo.nullAsNil(str).length() <= 0) {
                switch (Rm.scene) {
                    case 18:
                    case 22:
                    case 23:
                    case 24:
                    case 25:
                    case 26:
                    case 27:
                    case C31128d.MIC_BASE_CHANNELSHARPEN /*28*/:
                    case 29:
                        str = context.getString(C25738R.string.al3);
                        break;
                    default:
                        str = context.getString(C25738R.string.akz);
                        break;
                }
            }
            intent.putExtra("Contact_Content", str);
            if (Rm.xZy == 1 && !C5046bo.isNullOrNil(Rm.xZA)) {
                intent.putExtra("Safety_Warning_Detail", Rm.xZA);
            }
            intent.putExtra("Contact_verify_Scene", Rm.scene);
            if ((Rm.scene == 14 || Rm.scene == 8) && !C5046bo.isNullOrNil(Rm.chatroomName)) {
                C9638aw.m17190ZK();
                C7577u oa = C18628c.m29087XV().mo14885oa(Rm.chatroomName);
                if (oa != null) {
                    intent.putExtra("Contact_RoomNickname", oa.mo16807mJ(Rm.svN));
                }
            }
            intent.putExtra("Contact_Uin", Rm.pnz);
            intent.putExtra("Contact_QQNick", Rm.gwH);
            intent.putExtra("Contact_Mobile_MD5", Rm.xZi);
            intent.putExtra("User_From_Fmessage", true);
            intent.putExtra("Contact_from_msgType", 37);
            if (aoO == null || !C7486a.m12942jh(aoO.field_type)) {
                intent.putExtra("Contact_KSnsIFlag", 0);
            }
            intent.putExtra("Contact_KSnsBgUrl", Rm.xZw);
            intent.putExtra("verify_gmail", Rm.gta);
            intent.putExtra("source_from_user_name", Rm.ijx);
            intent.putExtra("source_from_nick_name", Rm.vjM);
            C25985d.m41467b(context, Scopes.PROFILE, ".ui.ContactInfoUI", intent);
        }
        AppMethodBeat.m2505o(25344);
    }
}
