package com.tencent.p177mm.chatroom.p216ui;

import android.app.ProgressDialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.text.SpannableStringBuilder;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import com.google.android.gms.common.Scopes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.chatroom.p1596e.C41924a;
import com.tencent.p177mm.chatroom.p216ui.preference.RoomCardPreference;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.kernel.C18524i;
import com.tencent.p177mm.model.C1829bf;
import com.tencent.p177mm.model.C1829bf.C1827a;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.model.C26415ao.C26417a;
import com.tencent.p177mm.model.C26415ao.C9635b.C9636a;
import com.tencent.p177mm.model.C32794m;
import com.tencent.p177mm.model.C37921n;
import com.tencent.p177mm.modelstat.C45457b;
import com.tencent.p177mm.p1192h.C42124a;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p203bg.C32335a;
import com.tencent.p177mm.p203bg.C32337g;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p230g.p231a.C26245tv;
import com.tencent.p177mm.p230g.p231a.C32589ko;
import com.tencent.p177mm.p230g.p231a.C42041qh;
import com.tencent.p177mm.p230g.p231a.C42062sz;
import com.tencent.p177mm.p230g.p231a.C45332hj;
import com.tencent.p177mm.p230g.p232b.p233a.C32677t;
import com.tencent.p177mm.p249m.C26373g;
import com.tencent.p177mm.p249m.C42164b;
import com.tencent.p177mm.p264n.C7486a;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C30379h.C30387b;
import com.tencent.p177mm.p612ui.base.C30379h.C30391c;
import com.tencent.p177mm.p612ui.base.C44275p;
import com.tencent.p177mm.p612ui.base.preference.C15541f;
import com.tencent.p177mm.p612ui.base.preference.C40675h;
import com.tencent.p177mm.p612ui.base.preference.C41341a;
import com.tencent.p177mm.p612ui.base.preference.CheckBoxPreference;
import com.tencent.p177mm.p612ui.base.preference.KeyValuePreference;
import com.tencent.p177mm.p612ui.base.preference.MMPreference;
import com.tencent.p177mm.p612ui.base.preference.NormalIconPreference;
import com.tencent.p177mm.p612ui.base.preference.Preference;
import com.tencent.p177mm.p612ui.base.preference.PreferenceCategory;
import com.tencent.p177mm.p612ui.contact.C15830s;
import com.tencent.p177mm.p612ui.p1347g.C40871a;
import com.tencent.p177mm.p612ui.widget.p633a.C5663e.C5659a;
import com.tencent.p177mm.p612ui.widget.p633a.C5663e.C5662c;
import com.tencent.p177mm.p712j.p713a.p714a.C6592a;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.chatroom.p721a.C6822c;
import com.tencent.p177mm.plugin.fts.p419a.C3161d;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.p455a.C3464j.C3465a;
import com.tencent.p177mm.plugin.messenger.p993a.C34529a;
import com.tencent.p177mm.plugin.multitalk.model.C39419a;
import com.tencent.p177mm.plugin.report.kvdata.IMBehavior;
import com.tencent.p177mm.plugin.report.kvdata.IMBehaviorChattingOP;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.zero.p757b.C35779b;
import com.tencent.p177mm.pluginsdk.p1077c.C46483b;
import com.tencent.p177mm.pluginsdk.p597ui.C14943d;
import com.tencent.p177mm.pluginsdk.p597ui.applet.C14926j;
import com.tencent.p177mm.pluginsdk.p597ui.applet.C30106k.C14929b;
import com.tencent.p177mm.pluginsdk.p597ui.applet.ContactListExpandPreference;
import com.tencent.p177mm.pluginsdk.p597ui.applet.ContactListExpandPreference.C30100a;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.pluginsdk.wallet.C40492e;
import com.tencent.p177mm.protocal.protobuf.C40580vo;
import com.tencent.p177mm.protocal.protobuf.ayb;
import com.tencent.p177mm.protocal.protobuf.bts;
import com.tencent.p177mm.roomsdk.p1086a.C30262b;
import com.tencent.p177mm.roomsdk.p1086a.p1341b.C44204b;
import com.tencent.p177mm.roomsdk.p1086a.p1341b.C44205c;
import com.tencent.p177mm.roomsdk.p1086a.p1341b.C46609a;
import com.tencent.p177mm.roomsdk.p1086a.p1342c.C46610a;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.p603e.C4935m;
import com.tencent.p177mm.sdk.p603e.C7296k.C4931a;
import com.tencent.p177mm.sdk.p603e.C7298n;
import com.tencent.p177mm.sdk.p603e.C7298n.C4937b;
import com.tencent.p177mm.sdk.platformtools.C4988aa;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.sdk.platformtools.C7564ap;
import com.tencent.p177mm.storage.C7575bv;
import com.tencent.p177mm.storage.C7577u;
import com.tencent.p177mm.storage.C7616ad;
import com.tencent.p177mm.vending.p636b.C7358b;
import com.tencent.ttpic.baseutils.IOUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

@C18524i
/* renamed from: com.tencent.mm.chatroom.ui.ChatroomInfoUI */
public class ChatroomInfoUI extends MMPreference implements C1202f, C32335a, C4931a, C4937b {
    private static boolean eiu = false;
    private boolean cEH;
    private ProgressDialog ehJ = null;
    private C15541f ehK;
    private boolean ehL;
    private C7616ad ehM;
    private RoomCardPreference ehN;
    private Preference ehO;
    private Preference ehP;
    private NormalIconPreference ehQ;
    private NormalIconPreference ehR;
    private ContactListExpandPreference ehS;
    private CheckBoxPreference ehT;
    private CheckBoxPreference ehU;
    private CheckBoxPreference ehV;
    private KeyValuePreference ehW;
    private CheckBoxPreference ehX;
    private Preference ehY;
    private SharedPreferences ehZ = null;
    private String ehq;
    private boolean eia;
    private boolean eib;
    private boolean eic = false;
    private boolean eid = false;
    private int eie;
    private boolean eif;
    private boolean eig = false;
    private C7577u eih = null;
    private int eii = -1;
    private boolean eij = true;
    private boolean eik = false;
    private boolean eil = false;
    private boolean eim = false;
    private C14943d ein = new C14943d(new C644111());
    boolean eio = false;
    private C4884c eip = new C642742();
    int eiq = -1;
    private C44275p eir = null;
    private String eis = "";
    private String eit;
    private String eiv = null;
    private C46483b eiw = new C641034();
    private C7564ap eix = null;
    private int eiy = 0;
    private C7306ak handler = new C7306ak(Looper.getMainLooper()) {
        public final void handleMessage(Message message) {
            AppMethodBeat.m2504i(103962);
            ChatroomInfoUI.m10592a(ChatroomInfoUI.this);
            AppMethodBeat.m2505o(103962);
        }
    };
    private boolean isDeleteCancel = false;

    /* renamed from: com.tencent.mm.chatroom.ui.ChatroomInfoUI$5 */
    class C13735 extends C34529a {
        C13735() {
        }

        public final void onClickImp(View view) {
            AppMethodBeat.m2504i(103968);
            Intent intent = new Intent();
            intent.setFlags(268435456);
            intent.setClassName(C4996ah.getContext(), "com.tencent.mm.plugin.webview.ui.tools.WebViewUI");
            intent.putExtra("rawUrl", "https://weixin.qq.com/cgi-bin/newreadtemplate?t=work_wechat/about_group");
            C4996ah.getContext().startActivity(intent);
            AppMethodBeat.m2505o(103968);
        }
    }

    /* renamed from: com.tencent.mm.chatroom.ui.ChatroomInfoUI$6 */
    class C13746 implements C14929b {
        C13746() {
        }

        /* renamed from: iD */
        public final boolean mo4758iD(int i) {
            return true;
        }
    }

    /* renamed from: com.tencent.mm.chatroom.ui.ChatroomInfoUI$7 */
    class C13757 implements OnClickListener {
        C13757() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* renamed from: com.tencent.mm.chatroom.ui.ChatroomInfoUI$a */
    static class C1377a implements OnCancelListener {
        C1377a() {
        }

        public final void onCancel(DialogInterface dialogInterface) {
            AppMethodBeat.m2504i(104015);
            ChatroomInfoUI.eiu = true;
            AppMethodBeat.m2505o(104015);
        }
    }

    /* renamed from: com.tencent.mm.chatroom.ui.ChatroomInfoUI$22 */
    class C640722 implements C9636a {
        C640722() {
        }

        /* renamed from: o */
        public final void mo6218o(final String str, boolean z) {
            AppMethodBeat.m2504i(103988);
            if (z && ChatroomInfoUI.this.ehq.equals(str)) {
                C1720g.m3539RS().mo10302aa(new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(103986);
                        ((C6822c) C1720g.m3528K(C6822c.class)).mo15090XV().mo14884n(str, System.currentTimeMillis());
                        AppMethodBeat.m2505o(103986);
                    }

                    public final String toString() {
                        AppMethodBeat.m2504i(103987);
                        String str = super.toString() + "|getContactCallBack";
                        AppMethodBeat.m2505o(103987);
                        return str;
                    }
                });
            }
            AppMethodBeat.m2505o(103988);
        }
    }

    /* renamed from: com.tencent.mm.chatroom.ui.ChatroomInfoUI$34 */
    class C641034 extends C46483b {

        /* renamed from: com.tencent.mm.chatroom.ui.ChatroomInfoUI$34$1 */
        class C64111 implements OnClickListener {
            C64111() {
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.m2504i(104001);
                ChatroomInfoUI.this.finish();
                AppMethodBeat.m2505o(104001);
            }
        }

        C641034() {
        }

        /* renamed from: a */
        public final void mo14634a(int i, int i2, String str, C4883b c4883b) {
            AppMethodBeat.m2504i(104002);
            if (c4883b instanceof C32589ko) {
                C32589ko c32589ko = (C32589ko) c4883b;
                C4990ab.m7416i("MicroMsg.ChatroomInfoUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
                if (ChatroomInfoUI.this.ehJ != null) {
                    ChatroomInfoUI.this.ehJ.dismiss();
                }
                if (i == 0 && i2 == 0) {
                    if (i == 0 && i2 == 0 && ChatroomInfoUI.this.ehS != null) {
                        ArrayList N = ChatroomInfoUI.m10588N(c32589ko.cGv.cGh);
                        ContactListExpandPreference m = ChatroomInfoUI.this.ehS;
                        if (m.vld != null) {
                            C14926j c14926j = m.vld.vkt;
                            c14926j.mo27254ah(N);
                            c14926j.mo27253Kh();
                        }
                        if (ChatroomInfoUI.this.ehK != null) {
                            ChatroomInfoUI.this.ehK.notifyDataSetChanged();
                        }
                        ChatroomInfoUI.this.setMMTitle(ChatroomInfoUI.this.getResources().getQuantityString(C25738R.plurals.f9613z, N.size(), new Object[]{Integer.valueOf(N.size())}));
                    }
                    ChatroomInfoUI.m10622j(ChatroomInfoUI.this);
                } else if (i2 == -21) {
                    C30379h.m48438a(ChatroomInfoUI.this, ChatroomInfoUI.this.getString(C25738R.string.dsr), ChatroomInfoUI.this.getString(C25738R.string.f9238tz), new C64111());
                    AppMethodBeat.m2505o(104002);
                    return;
                } else {
                    C30379h.m48461b(ChatroomInfoUI.this, ChatroomInfoUI.this.getString(C25738R.string.dst), ChatroomInfoUI.this.getString(C25738R.string.f9238tz), true);
                    AppMethodBeat.m2505o(104002);
                    return;
                }
            }
            AppMethodBeat.m2505o(104002);
        }
    }

    /* renamed from: com.tencent.mm.chatroom.ui.ChatroomInfoUI$41 */
    class C641241 implements C44204b {
        C641241() {
        }

        /* renamed from: a */
        public final /* synthetic */ void mo11081a(int i, int i2, String str, C46609a c46609a) {
            AppMethodBeat.m2504i(104010);
            if (ChatroomInfoUI.this.eih != null) {
                ChatroomInfoUI.this.eie = ChatroomInfoUI.this.eih.afg().size();
            }
            if ((!ChatroomInfoUI.m10614d(ChatroomInfoUI.this) && ChatroomInfoUI.this.eie >= C14926j.MAX_COUNT) || (ChatroomInfoUI.m10614d(ChatroomInfoUI.this) && ChatroomInfoUI.this.eie >= C14926j.MAX_COUNT - 1)) {
                ChatroomInfoUI.this.ehK.mo27715ce("see_room_member", false);
                ChatroomInfoUI.this.ehP.setTitle(ChatroomInfoUI.this.getString(C25738R.string.e14));
            }
            ChatroomInfoUI.m10619h(ChatroomInfoUI.this);
            ChatroomInfoUI.m10620i(ChatroomInfoUI.this);
            ChatroomInfoUI.m10622j(ChatroomInfoUI.this);
            AppMethodBeat.m2505o(104010);
        }
    }

    /* renamed from: com.tencent.mm.chatroom.ui.ChatroomInfoUI$15 */
    class C641315 implements OnCancelListener {
        C641315() {
        }

        public final void onCancel(DialogInterface dialogInterface) {
            AppMethodBeat.m2504i(103978);
            ChatroomInfoUI.this.isDeleteCancel = true;
            AppMethodBeat.m2505o(103978);
        }
    }

    /* renamed from: com.tencent.mm.chatroom.ui.ChatroomInfoUI$16 */
    class C641416 implements OnClickListener {
        C641416() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(103979);
            C7060h.pYm.mo8381e(14553, Integer.valueOf(4), Integer.valueOf(4), ChatroomInfoUI.this.ehq);
            ChatroomInfoUI.this.isDeleteCancel = true;
            if (ChatroomInfoUI.this.eik) {
                ChatroomInfoUI.this.finish();
                AppMethodBeat.m2505o(103979);
                return;
            }
            Intent intent = new Intent();
            intent.putExtra("Chat_User", ChatroomInfoUI.this.ehM.field_username);
            intent.addFlags(67108864);
            C25985d.m41473f(ChatroomInfoUI.this, ".ui.chatting.ChattingUI", intent);
            AppMethodBeat.m2505o(103979);
        }
    }

    /* renamed from: com.tencent.mm.chatroom.ui.ChatroomInfoUI$18 */
    class C641618 implements C1827a {
        C641618() {
        }

        /* renamed from: JU */
        public final boolean mo5405JU() {
            AppMethodBeat.m2504i(103981);
            boolean w = ChatroomInfoUI.this.isDeleteCancel;
            AppMethodBeat.m2505o(103981);
            return w;
        }

        /* renamed from: JV */
        public final void mo5406JV() {
            AppMethodBeat.m2504i(103982);
            if (ChatroomInfoUI.this.ehJ != null) {
                ChatroomInfoUI.this.ehJ.dismiss();
            }
            AppMethodBeat.m2505o(103982);
        }
    }

    /* renamed from: com.tencent.mm.chatroom.ui.ChatroomInfoUI$37 */
    class C641737 implements Runnable {
        C641737() {
        }

        public final void run() {
            AppMethodBeat.m2504i(104005);
            ChatroomInfoUI.this.eih = ((C6822c) C1720g.m3528K(C6822c.class)).mo15090XV().mo14885oa(ChatroomInfoUI.this.ehq);
            if (ChatroomInfoUI.this.eih == null) {
                C4990ab.m7412e("MicroMsg.ChatroomInfoUI", "member is null");
                AppMethodBeat.m2505o(104005);
            } else if (C5046bo.isNullOrNil(ChatroomInfoUI.this.eih.field_roomowner)) {
                C4990ab.m7412e("MicroMsg.ChatroomInfoUI", "roomowner is null");
                AppMethodBeat.m2505o(104005);
            } else {
                ChatroomInfoUI.this.handler.sendEmptyMessage(0);
                ChatroomInfoUI.this.eic = ChatroomInfoUI.this.eih.field_roomowner.equals(C1853r.m3846Yz());
                ChatroomInfoUI.this.eid = ChatroomInfoUI.this.eih.aoo(C1853r.m3846Yz());
                ChatroomInfoUI.this.ehS.ajF(ChatroomInfoUI.this.eih.field_roomowner);
                AppMethodBeat.m2505o(104005);
            }
        }

        public final String toString() {
            AppMethodBeat.m2504i(104006);
            String str = super.toString() + "|onNotifyChange";
            AppMethodBeat.m2505o(104006);
            return str;
        }
    }

    /* renamed from: com.tencent.mm.chatroom.ui.ChatroomInfoUI$10 */
    class C641810 implements OnClickListener {

        /* renamed from: com.tencent.mm.chatroom.ui.ChatroomInfoUI$10$1 */
        class C64201 implements OnClickListener {
            C64201() {
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.m2504i(103971);
                C7060h.pYm.mo8381e(14553, Integer.valueOf(3), Integer.valueOf(4), ChatroomInfoUI.this.ehq);
                ChatroomInfoUI.this.isDeleteCancel = true;
                if (ChatroomInfoUI.this.eik) {
                    ChatroomInfoUI.this.finish();
                    AppMethodBeat.m2505o(103971);
                    return;
                }
                Intent intent = new Intent();
                intent.putExtra("Chat_User", ChatroomInfoUI.this.ehM.field_username);
                intent.addFlags(67108864);
                C25985d.m41473f(ChatroomInfoUI.this, ".ui.chatting.ChattingUI", intent);
                AppMethodBeat.m2505o(103971);
            }
        }

        C641810() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            String str;
            AppMethodBeat.m2504i(103973);
            C7060h.pYm.mo8381e(14553, Integer.valueOf(3), Integer.valueOf(2), ChatroomInfoUI.this.ehq);
            ChatroomInfoUI.eiu = false;
            Context context = ChatroomInfoUI.this;
            ChatroomInfoUI.this.getString(C25738R.string.f9238tz);
            final ProgressDialog b = C30379h.m48458b(context, ChatroomInfoUI.this.getString(C25738R.string.f9260un), true, new C1377a());
            if (ChatroomInfoUI.eiu) {
                str = null;
            } else {
                str = C40492e.akq(ChatroomInfoUI.this.ehM.field_username);
            }
            if (C5046bo.isNullOrNil(str)) {
                ChatroomInfoUI.m10595a(ChatroomInfoUI.this, b);
                AppMethodBeat.m2505o(103973);
                return;
            }
            b.dismiss();
            C30379h.m48454a(ChatroomInfoUI.this, false, ChatroomInfoUI.this.getString(C25738R.string.fdk, new Object[]{str}), null, ChatroomInfoUI.this.getString(C25738R.string.c9y), ChatroomInfoUI.this.getString(C25738R.string.ar1), new C64201(), new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.m2504i(103972);
                    C7060h.pYm.mo8381e(14553, Integer.valueOf(3), Integer.valueOf(3), ChatroomInfoUI.this.ehq);
                    b.show();
                    ChatroomInfoUI.this.isDeleteCancel = false;
                    ChatroomInfoUI.m10595a(ChatroomInfoUI.this, b);
                    AppMethodBeat.m2505o(103972);
                }
            }, -1, C25738R.color.f11717ei);
            AppMethodBeat.m2505o(103973);
        }
    }

    /* renamed from: com.tencent.mm.chatroom.ui.ChatroomInfoUI$19 */
    class C642119 implements C44204b {
        C642119() {
        }

        /* renamed from: a */
        public final /* synthetic */ void mo11081a(int i, int i2, String str, C46609a c46609a) {
            AppMethodBeat.m2504i(103983);
            ChatroomInfoUI.m10640y(ChatroomInfoUI.this);
            ChatroomInfoUI.m10641z(ChatroomInfoUI.this);
            AppMethodBeat.m2505o(103983);
        }
    }

    /* renamed from: com.tencent.mm.chatroom.ui.ChatroomInfoUI$20 */
    class C642220 implements C44204b {
        C642220() {
        }

        /* renamed from: a */
        public final /* synthetic */ void mo11081a(int i, int i2, String str, C46609a c46609a) {
            AppMethodBeat.m2504i(103984);
            C42124a jY = C42124a.m74268jY(str);
            if (jY != null) {
                jY.mo67668a(ChatroomInfoUI.this, null, null);
                AppMethodBeat.m2505o(103984);
                return;
            }
            if (i2 == -66) {
                C30379h.m48461b(ChatroomInfoUI.this, ChatroomInfoUI.this.getString(C25738R.string.b50), ChatroomInfoUI.this.getString(C25738R.string.f9238tz), true);
            } else {
                C30379h.m48461b(ChatroomInfoUI.this, C5046bo.m7532bc(str, ChatroomInfoUI.this.getString(C25738R.string.b51)), ChatroomInfoUI.this.getString(C25738R.string.f9238tz), true);
            }
            ChatroomInfoUI.m10640y(ChatroomInfoUI.this);
            ChatroomInfoUI.m10641z(ChatroomInfoUI.this);
            C4990ab.m7417i("MicroMsg.ActionCallbackFunc", "[delChatroomMember] onResult errType:%s errCode:%s", Integer.valueOf(i), Integer.valueOf(i2));
            AppMethodBeat.m2505o(103984);
        }
    }

    /* renamed from: com.tencent.mm.chatroom.ui.ChatroomInfoUI$23 */
    class C642323 extends C44205c {
        C642323() {
        }

        /* renamed from: a */
        public final /* synthetic */ void mo11081a(int i, int i2, String str, C46609a c46609a) {
            AppMethodBeat.m2504i(103989);
            C44205c c44205c = (C44205c) c46609a;
            C42124a jY = C42124a.m74268jY(str);
            if (jY != null) {
                jY.mo67668a(ChatroomInfoUI.this, null, null);
                AppMethodBeat.m2505o(103989);
            } else if (i == 0 && i2 == 0) {
                if (i == 0 && i2 == 0) {
                    ChatroomInfoUI.m10594a(ChatroomInfoUI.this, i2, c44205c, str);
                    ChatroomInfoUI.m10640y(ChatroomInfoUI.this);
                }
                ChatroomInfoUI.m10641z(ChatroomInfoUI.this);
                AppMethodBeat.m2505o(103989);
            } else {
                ChatroomInfoUI.m10594a(ChatroomInfoUI.this, i2, c44205c, str);
                ChatroomInfoUI.m10640y(ChatroomInfoUI.this);
                AppMethodBeat.m2505o(103989);
            }
        }
    }

    /* renamed from: com.tencent.mm.chatroom.ui.ChatroomInfoUI$29 */
    class C642429 implements OnClickListener {
        C642429() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* renamed from: com.tencent.mm.chatroom.ui.ChatroomInfoUI$36 */
    class C642536 implements Runnable {
        C642536() {
        }

        public final void run() {
            AppMethodBeat.m2504i(104004);
            ((C35779b) C1720g.m3528K(C35779b.class)).ahW().mo44216lN(7);
            AppMethodBeat.m2505o(104004);
        }
    }

    /* renamed from: com.tencent.mm.chatroom.ui.ChatroomInfoUI$42 */
    class C642742 extends C4884c<C45332hj> {
        C642742() {
            AppMethodBeat.m2504i(104011);
            this.xxI = C45332hj.class.getName().hashCode();
            AppMethodBeat.m2505o(104011);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(104012);
            if (((C45332hj) c4883b) instanceof C45332hj) {
                ChatroomInfoUI.m10623k(ChatroomInfoUI.this);
            }
            AppMethodBeat.m2505o(104012);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.chatroom.ui.ChatroomInfoUI$30 */
    class C642830 implements OnClickListener {
        C642830() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(103995);
            ChatroomInfoUI chatroomInfoUI = ChatroomInfoUI.this;
            Context context = ChatroomInfoUI.this;
            ChatroomInfoUI.this.ehq;
            ChatroomInfoUI.m10596a(chatroomInfoUI, context);
            AppMethodBeat.m2505o(103995);
        }
    }

    /* renamed from: com.tencent.mm.chatroom.ui.ChatroomInfoUI$31 */
    class C642931 implements OnClickListener {
        C642931() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(103996);
            ChatroomInfoUI.m10640y(ChatroomInfoUI.this);
            AppMethodBeat.m2505o(103996);
        }
    }

    /* renamed from: com.tencent.mm.chatroom.ui.ChatroomInfoUI$3 */
    class C64313 implements C30100a {
        C64313() {
        }

        /* renamed from: iA */
        public final void mo14654iA(int i) {
            AppMethodBeat.m2504i(103963);
            ChatroomInfoUI.m10627l(ChatroomInfoUI.this);
            AppMethodBeat.m2505o(103963);
        }

        /* JADX WARNING: Removed duplicated region for block: B:10:0x004e  */
        /* JADX WARNING: Removed duplicated region for block: B:9:0x004a  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        /* renamed from: iB */
        public final void mo14655iB(int i) {
            String str;
            AppMethodBeat.m2504i(103964);
            String KX = ChatroomInfoUI.this.ehS.mo48351KX(i);
            String nullAsNil = C5046bo.nullAsNil(ChatroomInfoUI.this.ehS.mo48353KZ(i));
            if (C5046bo.isNullOrNil(nullAsNil)) {
                C1720g.m3537RQ();
                C7575bv RB = ((C6982j) C1720g.m3528K(C6982j.class)).mo15370XN().mo15364RB(KX);
                if (!(RB == null || C5046bo.isNullOrNil(RB.field_encryptUsername))) {
                    str = RB.field_conRemark;
                    if (C5046bo.isNullOrNil(KX)) {
                        Intent intent = new Intent();
                        intent.putExtra("Contact_User", KX);
                        intent.putExtra("Contact_RemarkName", str);
                        if (ChatroomInfoUI.this.cEH && ChatroomInfoUI.this.eih != null) {
                            intent.putExtra("Contact_RoomNickname", ChatroomInfoUI.this.eih.mo16807mJ(KX));
                        }
                        intent.putExtra("Contact_Nick", C5046bo.nullAsNil(ChatroomInfoUI.this.ehS.mo48352KY(i)));
                        intent.putExtra("Contact_RoomMember", true);
                        intent.putExtra("room_name", ChatroomInfoUI.this.ehM.field_username);
                        C7616ad aoO = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(KX);
                        if (aoO != null && ((int) aoO.ewQ) > 0 && C7486a.m12942jh(aoO.field_type)) {
                            C42041qh c42041qh = new C42041qh();
                            c42041qh.cMw.intent = intent;
                            c42041qh.cMw.username = KX;
                            C4879a.xxA.mo10055m(c42041qh);
                        }
                        if (ChatroomInfoUI.this.cEH) {
                            C7060h.pYm.mo8378a(219, 9, 1, true);
                            if (aoO != null && aoO.dsf()) {
                                C7060h.pYm.mo8374X(10298, aoO.field_username + ",14");
                            }
                            intent.putExtra("Contact_Scene", 14);
                        } else if (ChatroomInfoUI.this.ehL) {
                            intent.putExtra("Contact_Scene", 44);
                            if (!C1853r.m3858mG(aoO.field_username)) {
                                intent.putExtra("Contact_IsLBSFriend", true);
                            }
                        }
                        intent.putExtra("Is_RoomOwner", ChatroomInfoUI.this.eic);
                        intent.putExtra("Contact_ChatRoomId", ChatroomInfoUI.this.ehq);
                        if (C1855t.m3903mP(ChatroomInfoUI.this.ehq)) {
                            C32677t c32677t = new C32677t();
                            c32677t.mo53208eO(ChatroomInfoUI.this.ehq);
                            c32677t.cXP = 12;
                            c32677t.ajK();
                        }
                        intent.putExtra("CONTACT_INFO_UI_SOURCE", 8);
                        C25985d.m41467b(ChatroomInfoUI.this, Scopes.PROFILE, ".ui.ContactInfoUI", intent);
                        AppMethodBeat.m2505o(103964);
                        return;
                    }
                    AppMethodBeat.m2505o(103964);
                    return;
                }
            }
            str = nullAsNil;
            if (C5046bo.isNullOrNil(KX)) {
            }
        }

        /* renamed from: JT */
        public final void mo14653JT() {
            AppMethodBeat.m2504i(103965);
            if (ChatroomInfoUI.this.ehS != null) {
                ChatroomInfoUI.this.ehS.djD();
            }
            AppMethodBeat.m2505o(103965);
        }

        /* renamed from: iC */
        public final void mo14656iC(int i) {
            AppMethodBeat.m2504i(103966);
            ChatroomInfoUI.m10633r(ChatroomInfoUI.this);
            AppMethodBeat.m2505o(103966);
        }
    }

    /* renamed from: com.tencent.mm.chatroom.ui.ChatroomInfoUI$45 */
    class C643245 implements C14929b {
        C643245() {
        }

        /* renamed from: iD */
        public final boolean mo4758iD(int i) {
            return true;
        }
    }

    /* renamed from: com.tencent.mm.chatroom.ui.ChatroomInfoUI$4 */
    class C64334 implements OnMenuItemClickListener {
        C64334() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(103967);
            ChatroomInfoUI.this.finish();
            AppMethodBeat.m2505o(103967);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.chatroom.ui.ChatroomInfoUI$26 */
    class C643526 implements C44204b {
        C643526() {
        }

        /* renamed from: a */
        public final /* synthetic */ void mo11081a(int i, int i2, String str, C46609a c46609a) {
            AppMethodBeat.m2504i(103992);
            ChatroomInfoUI.m10640y(ChatroomInfoUI.this);
            ChatroomInfoUI.m10641z(ChatroomInfoUI.this);
            AppMethodBeat.m2505o(103992);
        }
    }

    /* renamed from: com.tencent.mm.chatroom.ui.ChatroomInfoUI$33 */
    class C643633 implements Runnable {
        C643633() {
        }

        public final void run() {
            AppMethodBeat.m2504i(104000);
            if (ChatroomInfoUI.this.eih == null) {
                C4990ab.m7420w("MicroMsg.ChatroomInfoUI", "[updateRoomPref] member == null");
                AppMethodBeat.m2505o(104000);
                return;
            }
            List list;
            String str;
            ChatroomInfoUI.this.eiv = ((C6822c) C1720g.m3528K(C6822c.class)).mo15090XV().mo14888od(ChatroomInfoUI.this.ehq);
            List my = C37921n.m64074my(ChatroomInfoUI.this.ehq);
            if (my != null) {
                ChatroomInfoUI.this.eie = my.size();
                list = my;
            } else {
                LinkedList linkedList = new LinkedList();
                ChatroomInfoUI.this.eie = 0;
                Object list2 = linkedList;
            }
            LinkedList linkedList2 = new LinkedList();
            for (String str2 : r1) {
                if (ChatroomInfoUI.this.eih.aoo(str2) || ChatroomInfoUI.this.eih.aos(str2)) {
                    linkedList2.add(str2);
                }
            }
            if (ChatroomInfoUI.this.eie > C14926j.MAX_COUNT + 1 && r1 != null) {
                list2 = r1.subList(0, C14926j.MAX_COUNT + 1);
                Iterator it = linkedList2.iterator();
                while (it.hasNext()) {
                    str2 = (String) it.next();
                    if (!list2.contains(str2)) {
                        list2.add(0, str2);
                    }
                }
            }
            C5004al.m7441d(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(103999);
                    if (ChatroomInfoUI.this.eie <= 1) {
                        ChatroomInfoUI.this.ehK.mo27715ce("del_selector_btn", true);
                        ChatroomInfoUI.this.ehS.mo48368oD(true).mo48369oE(false).djG();
                    } else {
                        ChatroomInfoUI.this.ehS.mo48368oD(true).mo48369oE(ChatroomInfoUI.m10614d(ChatroomInfoUI.this)).djG();
                    }
                    ChatroomInfoUI.this.ehS.mo48371u(ChatroomInfoUI.this.ehq, list2);
                    AppMethodBeat.m2505o(103999);
                }
            });
            AppMethodBeat.m2505o(104000);
        }
    }

    /* renamed from: com.tencent.mm.chatroom.ui.ChatroomInfoUI$11 */
    class C644111 implements OnScrollListener {
        C644111() {
        }

        public final void onScrollStateChanged(AbsListView absListView, int i) {
        }

        public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }
    }

    /* renamed from: com.tencent.mm.chatroom.ui.ChatroomInfoUI$13 */
    class C644313 implements C30391c {
        C644313() {
        }

        /* renamed from: iE */
        public final void mo7700iE(int i) {
            AppMethodBeat.m2504i(103976);
            switch (i) {
                case 0:
                    C4990ab.m7410d("MicroMsg.ChatroomInfoUI", "dz[dealQuitChatRoom owner click room_owner_delete_direct]");
                    ChatroomInfoUI.m10637v(ChatroomInfoUI.this);
                    ((C39419a) C1720g.m3528K(C39419a.class)).mo55109RU(ChatroomInfoUI.this.ehq);
                    AppMethodBeat.m2505o(103976);
                    return;
                default:
                    C4990ab.m7410d("MicroMsg.ChatroomInfoUI", "dz[dealQuitChatRoom owner click cancel]");
                    AppMethodBeat.m2505o(103976);
                    return;
            }
        }
    }

    /* renamed from: com.tencent.mm.chatroom.ui.ChatroomInfoUI$25 */
    class C644625 implements C44204b {
        C644625() {
        }

        /* renamed from: a */
        public final /* synthetic */ void mo11081a(int i, int i2, String str, C46609a c46609a) {
            AppMethodBeat.m2504i(103991);
            C42124a jY = C42124a.m74268jY(str);
            if (jY != null) {
                jY.mo67668a(ChatroomInfoUI.this, null, null);
                AppMethodBeat.m2505o(103991);
                return;
            }
            C30379h.m48461b(ChatroomInfoUI.this, ChatroomInfoUI.this.getString(C25738R.string.cen), ChatroomInfoUI.this.getString(C25738R.string.f9238tz), true);
            ChatroomInfoUI.m10641z(ChatroomInfoUI.this);
            AppMethodBeat.m2505o(103991);
        }
    }

    /* renamed from: com.tencent.mm.chatroom.ui.ChatroomInfoUI$2 */
    class C64482 implements View.OnClickListener {
        C64482() {
        }

        public final void onClick(View view) {
        }
    }

    /* renamed from: com.tencent.mm.chatroom.ui.ChatroomInfoUI$38 */
    class C644938 implements Runnable {
        C644938() {
        }

        public final void run() {
            AppMethodBeat.m2504i(104007);
            ChatroomInfoUI.m10611c(ChatroomInfoUI.this, "room_notify_new_msg");
            ChatroomInfoUI.this.eim = true;
            AppMethodBeat.m2505o(104007);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public ChatroomInfoUI() {
        AppMethodBeat.m2504i(104016);
        AppMethodBeat.m2505o(104016);
    }

    /* renamed from: d */
    static /* synthetic */ boolean m10614d(ChatroomInfoUI chatroomInfoUI) {
        AppMethodBeat.m2504i(104057);
        boolean JR = chatroomInfoUI.m10586JR();
        AppMethodBeat.m2505o(104057);
        return JR;
    }

    /* renamed from: h */
    static /* synthetic */ void m10619h(ChatroomInfoUI chatroomInfoUI) {
        AppMethodBeat.m2504i(104058);
        chatroomInfoUI.m10581JM();
        AppMethodBeat.m2505o(104058);
    }

    /* renamed from: i */
    static /* synthetic */ void m10620i(ChatroomInfoUI chatroomInfoUI) {
        AppMethodBeat.m2504i(104059);
        chatroomInfoUI.m10582JN();
        AppMethodBeat.m2505o(104059);
    }

    /* renamed from: j */
    static /* synthetic */ void m10622j(ChatroomInfoUI chatroomInfoUI) {
        AppMethodBeat.m2504i(104060);
        chatroomInfoUI.updateTitle();
        AppMethodBeat.m2505o(104060);
    }

    /* renamed from: k */
    static /* synthetic */ void m10623k(ChatroomInfoUI chatroomInfoUI) {
        AppMethodBeat.m2504i(104061);
        chatroomInfoUI.m10571JB();
        AppMethodBeat.m2505o(104061);
    }

    /* renamed from: l */
    static /* synthetic */ void m10627l(ChatroomInfoUI chatroomInfoUI) {
        AppMethodBeat.m2504i(104063);
        chatroomInfoUI.m10575JG();
        AppMethodBeat.m2505o(104063);
    }

    /* renamed from: r */
    static /* synthetic */ void m10633r(ChatroomInfoUI chatroomInfoUI) {
        AppMethodBeat.m2504i(104064);
        chatroomInfoUI.m10574JF();
        AppMethodBeat.m2505o(104064);
    }

    /* renamed from: t */
    static /* synthetic */ void m10635t(ChatroomInfoUI chatroomInfoUI) {
        AppMethodBeat.m2504i(104066);
        chatroomInfoUI.m10579JK();
        AppMethodBeat.m2505o(104066);
    }

    /* renamed from: y */
    static /* synthetic */ void m10640y(ChatroomInfoUI chatroomInfoUI) {
        AppMethodBeat.m2504i(104070);
        chatroomInfoUI.m10585JQ();
        AppMethodBeat.m2505o(104070);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(104017);
        super.onCreate(bundle);
        C1720g.m3535RO().eJo.mo14539a(480, (C1202f) this);
        C46483b.m87699a(C32589ko.class.getName(), this.eiw);
        C7358b dnU = this.eip.dnU();
        Assert.assertNotNull(this);
        keep(dnU);
        C1720g.m3536RP().mo5239Ry().mo10118a(this);
        ((C6822c) C1720g.m3528K(C6822c.class)).mo15090XV().mo10116c(this);
        if (C32337g.fUs != null) {
            C32337g.fUs.mo4620a(this);
        }
        this.ehq = getIntent().getStringExtra("RoomInfo_Id");
        this.ehM = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(this.ehq);
        this.eij = true;
        this.cEH = getIntent().getBooleanExtra("Is_Chatroom", true);
        this.ehL = getIntent().getBooleanExtra("Is_Lbsroom", false);
        this.eik = getIntent().getBooleanExtra("fromChatting", false);
        this.eil = getIntent().getBooleanExtra("isShowSetMuteAnimation", false);
        this.eis = getPackageName() + "_preferences";
        if (this.cEH) {
            this.eih = ((C6822c) C1720g.m3528K(C6822c.class)).mo15090XV().mo14885oa(this.ehq);
            if (this.eih != null) {
                this.eid = this.eih.aoo(C1853r.m3846Yz());
            }
        }
        initView();
        if (this.cEH) {
            final C640722 c640722 = new C640722();
            if (this.eih == null) {
                C26417a.flu.mo20966a(this.ehq, "", c640722);
                AppMethodBeat.m2505o(104017);
                return;
            } else if (System.currentTimeMillis() - this.eih.field_modifytime >= 86400000) {
                C1720g.m3539RS().mo10302aa(new Runnable() {
                    public final String toString() {
                        AppMethodBeat.m2504i(103998);
                        String str = super.toString() + "|getContactCallBack2";
                        AppMethodBeat.m2505o(103998);
                        return str;
                    }

                    public final void run() {
                        AppMethodBeat.m2504i(103997);
                        C26417a.flu.mo20966a(ChatroomInfoUI.this.eih.field_chatroomname, "", c640722);
                        AppMethodBeat.m2505o(103997);
                    }
                });
            }
        }
        AppMethodBeat.m2505o(104017);
    }

    /* renamed from: JB */
    private void m10571JB() {
        AppMethodBeat.m2504i(104018);
        C4990ab.m7417i("MicroMsg.ChatroomInfoUI", "[doChatroomDetailCgi] :%s", this.ehq);
        C46610a kd = C30262b.alY(this.ehq).mo20640kd(this.ehq);
        kd.mo74753b(new C641241());
        kd.dmX();
        AppMethodBeat.m2505o(104018);
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0076  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x008a  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00c7  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onResume() {
        boolean N;
        String stringExtra;
        AppMethodBeat.m2504i(104019);
        super.onResume();
        this.ehK.notifyDataSetChanged();
        if (this.eih != null) {
            C6592a drY = this.eih.drY();
            if (drY != null) {
                N = C37921n.m64043N(this.eih.field_chatroomname, drY.eoy);
                C4990ab.m7417i("MicroMsg.ChatroomInfoUI", "roomId:%s newVer:%s localVer:%s owner:%s", this.eih.field_chatroomname, Integer.valueOf(drY.eoy), Integer.valueOf(this.eih.field_chatroomVersion), this.eih.field_roomowner);
                if (C37921n.m64069mt(this.ehq) || N) {
                    m10571JB();
                }
                m10581JM();
                updateTitle();
                m10580JL();
                if (this.cEH) {
                    m10582JN();
                    m10579JK();
                }
                if (this.eij) {
                    m10578JJ();
                    this.eij = false;
                }
                stringExtra = getIntent().getStringExtra("need_matte_high_light_item");
                if (!this.eio) {
                    if (!C5046bo.isNullOrNil(stringExtra)) {
                        m10624kf(stringExtra);
                    }
                    this.eio = true;
                }
                if (!(C5046bo.isNullOrNil(stringExtra) || !stringExtra.equals("room_notify_new_notice") || this.eio)) {
                    m10624kf("room_card");
                    this.eio = true;
                }
                C4990ab.m7411d("MicroMsg.ChatroomInfoUI", "showSetMuteAnimation isShowSetMuteAnimation[%b]", Boolean.valueOf(this.eil));
                if (this.eil) {
                    this.eil = false;
                    C5004al.m7442n(new C644938(), 50);
                }
                AppMethodBeat.m2505o(104019);
            }
        }
        N = false;
        m10571JB();
        m10581JM();
        updateTitle();
        m10580JL();
        if (this.cEH) {
        }
        if (this.eij) {
        }
        stringExtra = getIntent().getStringExtra("need_matte_high_light_item");
        if (this.eio) {
        }
        m10624kf("room_card");
        this.eio = true;
        C4990ab.m7411d("MicroMsg.ChatroomInfoUI", "showSetMuteAnimation isShowSetMuteAnimation[%b]", Boolean.valueOf(this.eil));
        if (this.eil) {
        }
        AppMethodBeat.m2505o(104019);
    }

    public void onConfigurationChanged(Configuration configuration) {
        AppMethodBeat.m2504i(104020);
        super.onConfigurationChanged(configuration);
        this.ehS.notifyChanged();
        AppMethodBeat.m2505o(104020);
    }

    /* renamed from: kf */
    private void m10624kf(String str) {
        AppMethodBeat.m2504i(104021);
        final int aqQ = this.ehK.aqQ(str);
        this.nDp.smoothScrollToPosition(aqQ);
        new C7306ak().postDelayed(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(104013);
                View a = ((C41341a) ChatroomInfoUI.this.ehK).mo65995a(aqQ, ChatroomInfoUI.this.nDp);
                if (a != null) {
                    C40871a.m70821a(ChatroomInfoUI.this.mController.ylL, a);
                }
                AppMethodBeat.m2505o(104013);
            }
        }, 10);
        AppMethodBeat.m2505o(104021);
    }

    public void onPause() {
        AppMethodBeat.m2504i(104022);
        super.onPause();
        if (this.eig && this.cEH) {
            if (this.eih == null) {
                AppMethodBeat.m2505o(104022);
                return;
            }
            C37921n.m64048a(this.ehq, this.eih, this.eia);
        }
        AppMethodBeat.m2505o(104022);
    }

    /* JADX WARNING: Missing block: B:2:0x000e, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(104024);
     */
    /* JADX WARNING: Missing block: B:33:0x0146, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(104024);
     */
    /* JADX WARNING: Missing block: B:34:?, code skipped:
            return;
     */
    /* JADX WARNING: Missing block: B:44:?, code skipped:
            return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(104024);
        super.onActivityResult(i, i2, intent);
        String stringExtra;
        switch (i) {
            case 1:
                if (intent == null) {
                    AppMethodBeat.m2505o(104024);
                    return;
                }
                final String stringExtra2 = intent.getStringExtra("Select_Contact");
                C7577u oa = ((C6822c) C1720g.m3528K(C6822c.class)).mo15090XV().mo14885oa(this.ehq);
                if (oa != null) {
                    int drV = oa.drV();
                    if ((drV == 2 || drV == 1) && !m10586JR()) {
                        C5659a asL = new C5659a(this).asL(getString(C25738R.string.dqy));
                        asL.zQJ = getString(C25738R.string.f9221tf);
                        asL = asL.mo11526re(true).mo11525m(Boolean.TRUE);
                        asL.zQK = getString(C25738R.string.f9076or);
                        asL.asN(getString(C25738R.string.dip)).mo11523c(new C5662c() {
                            /* renamed from: d */
                            public final void mo5699d(boolean z, String str) {
                                AppMethodBeat.m2504i(104014);
                                if (z) {
                                    ChatroomInfoUI.m10598a(ChatroomInfoUI.this, stringExtra2, str);
                                }
                                AppMethodBeat.m2505o(104014);
                            }
                        }).show();
                        AppMethodBeat.m2505o(104024);
                        return;
                    }
                    m10606b(stringExtra2, null, C25738R.string.f8728db);
                    AppMethodBeat.m2505o(104024);
                    return;
                }
                break;
            case 2:
                if (i2 == -1) {
                    finish();
                    AppMethodBeat.m2505o(104024);
                    return;
                }
                break;
            case 4:
                if (i2 == -1) {
                    stringExtra = intent.getStringExtra("room_name");
                    if (!C5046bo.isNullOrNil(stringExtra)) {
                        C4879a.xxA.mo10055m(new C26245tv());
                        this.ehM.mo14703iB(stringExtra);
                        ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().mo15701Y(this.ehM);
                        m10582JN();
                    }
                    AppMethodBeat.m2505o(104024);
                    return;
                }
                break;
            case 5:
                if (i2 == 0) {
                    this.eiq = -1;
                    AppMethodBeat.m2505o(104024);
                    return;
                }
                break;
            case 6:
                if (i2 == -1) {
                    m10581JM();
                    break;
                }
                break;
            case 7:
                if (intent == null) {
                    AppMethodBeat.m2505o(104024);
                    return;
                }
                stringExtra = intent.getStringExtra("Select_Contact");
                if (stringExtra == null || stringExtra.equals("")) {
                    AppMethodBeat.m2505o(104024);
                    return;
                }
                final C46610a a = C30262b.alY(this.ehq).mo20632a(this.ehq, C5046bo.m7508P(stringExtra.split(",")), 0);
                a.mo74753b(new C642119());
                a.mo74754c(new C642220());
                getString(C25738R.string.f9238tz);
                a.mo48450a(this, getString(C25738R.string.drx), true, new OnCancelListener() {
                    public final void onCancel(DialogInterface dialogInterface) {
                        AppMethodBeat.m2504i(103985);
                        a.cancel();
                        AppMethodBeat.m2505o(103985);
                    }
                });
                AppMethodBeat.m2505o(104024);
                return;
        }
    }

    /* renamed from: JC */
    public final int mo8452JC() {
        return C25738R.xml.f8531bf;
    }

    /* renamed from: JD */
    private String m10572JD() {
        if (this.eih == null) {
            return "";
        }
        return this.eih.field_selfDisplayName;
    }

    /* renamed from: bB */
    private void m10607bB(boolean z) {
        AppMethodBeat.m2504i(104027);
        C1829bf.m3741a(this.ehq, new C641618());
        ((C6982j) C1720g.m3528K(C6982j.class)).mo15368XL().mo7920c(new C41924a(this.ehq));
        ((C6982j) C1720g.m3528K(C6982j.class)).mo15371XR().aoX(this.ehq);
        C30262b.alY(this.ehq).mo20641ke(this.ehq).dmX();
        C37921n.m64072mw(this.ehq);
        if (!z) {
            this.handler.post(new C642536());
        }
        Intent intent = new Intent();
        intent.addFlags(67108864);
        intent.setComponent(new ComponentName(getPackageName(), C4996ah.doz() + ".ui.LauncherUI"));
        startActivity(intent);
        finish();
        AppMethodBeat.m2505o(104027);
    }

    /* renamed from: JE */
    private void m10573JE() {
        AppMethodBeat.m2504i(104028);
        C7060h.pYm.mo8378a(219, 7, 1, true);
        List my = C37921n.m64074my(this.ehq);
        String c = C5046bo.m7536c(my, ",");
        if (my != null) {
            this.eie = my.size();
        }
        Intent intent = new Intent();
        intent.putExtra("titile", getString(C25738R.string.f8782eu));
        intent.putExtra("list_type", 1);
        intent.putExtra("list_attr", m10621iz(C15830s.znF));
        intent.putExtra("always_select_contact", c);
        intent.putExtra("scene", 3);
        if (!C7616ad.aoy(this.ehM.field_username)) {
            intent.putExtra("without_openim", true);
        }
        intent.putExtra("KBlockOpenImFav", C1855t.m3902mO(this.ehq));
        C25985d.m41466b((Context) this, ".ui.contact.SelectContactUI", intent, 1);
        AppMethodBeat.m2505o(104028);
    }

    /* renamed from: JF */
    private void m10574JF() {
        AppMethodBeat.m2504i(104029);
        if (this.cEH) {
            m10573JE();
            AppMethodBeat.m2505o(104029);
            return;
        }
        m10584JP();
        AppMethodBeat.m2505o(104029);
    }

    /* renamed from: iz */
    private int m10621iz(int i) {
        AppMethodBeat.m2504i(104030);
        if (!C15830s.dIh()) {
            AppMethodBeat.m2505o(104030);
            return i;
        } else if (this.ehM != null) {
            String str = this.ehM.field_username;
            if (C7616ad.aox(str) || C7616ad.aoy(str)) {
                i |= 16777216;
                AppMethodBeat.m2505o(104030);
                return i;
            }
            i &= -16777217;
            AppMethodBeat.m2505o(104030);
            return i;
        } else {
            AppMethodBeat.m2505o(104030);
            return i;
        }
    }

    /* renamed from: JG */
    private void m10575JG() {
        AppMethodBeat.m2504i(104031);
        C7060h.pYm.mo8378a(219, 8, 1, true);
        List my = C37921n.m64074my(this.ehq);
        String c = C5046bo.m7536c(my, ",");
        this.eie = my.size();
        Intent intent = new Intent();
        intent.putExtra("RoomInfo_Id", this.ehq);
        intent.putExtra("Is_Chatroom", true);
        intent.putExtra("Chatroom_member_list", c);
        intent.putExtra("room_member_count", this.eie);
        intent.putExtra("Is_RoomOwner", this.eic);
        intent.putExtra("list_attr", C15830s.znF);
        intent.putExtra("room_name", this.ehM.field_username);
        intent.putExtra("room_owner_name", this.eih.field_roomowner);
        intent.setClass(this, SelectDelMemberUI.class);
        startActivityForResult(intent, 7);
        AppMethodBeat.m2505o(104031);
    }

    /* renamed from: b */
    private void m10606b(String str, String str2, int i) {
        AppMethodBeat.m2504i(104032);
        if (C1855t.m3902mO(this.ehq) && !C32794m.m53575mo(str)) {
            C30379h.m48461b((Context) this, getString(C25738R.string.dt9), getString(C25738R.string.f9238tz), true);
            AppMethodBeat.m2505o(104032);
        } else if (m10626kh(str)) {
            C30379h.m48461b((Context) this, getString(C25738R.string.f8716cy), getString(C25738R.string.f9238tz), true);
            AppMethodBeat.m2505o(104032);
        } else {
            List P = C5046bo.m7508P(str.split(","));
            if (P == null) {
                AppMethodBeat.m2505o(104032);
                return;
            }
            final C46610a a = C30262b.alY(this.ehq).mo20633a(this.ehq, P, str2);
            a.mo74755d(new C642323());
            getString(C25738R.string.f9238tz);
            a.mo48450a(this, getString(i), true, new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                    AppMethodBeat.m2504i(103990);
                    a.cancel();
                    AppMethodBeat.m2505o(103990);
                }
            });
            AppMethodBeat.m2505o(104032);
        }
    }

    /* renamed from: kg */
    private String m10625kg(String str) {
        AppMethodBeat.m2504i(104033);
        if (this.eih == null) {
            AppMethodBeat.m2505o(104033);
            return null;
        }
        String mJ = this.eih.mo16807mJ(str);
        AppMethodBeat.m2505o(104033);
        return mJ;
    }

    /* renamed from: JH */
    private String m10576JH() {
        String str;
        AppMethodBeat.m2504i(104034);
        C7616ad aoO = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(this.eih.field_roomowner);
        if (aoO == null || ((int) aoO.ewQ) <= 0) {
            str = null;
        } else {
            str = aoO.field_conRemark;
        }
        if (C5046bo.isNullOrNil(str)) {
            str = m10625kg(this.eih.field_roomowner);
        }
        if (C5046bo.isNullOrNil(str) && aoO != null && ((int) aoO.ewQ) > 0) {
            str = aoO.mo16706Oi();
        }
        if (C5046bo.isNullOrNil(str)) {
            str = this.eih.field_roomowner;
        }
        AppMethodBeat.m2505o(104034);
        return str;
    }

    /* renamed from: JI */
    private static boolean m10577JI() {
        AppMethodBeat.m2504i(104035);
        if (C5046bo.getInt(C26373g.m41964Nu().getValue("ChatroomGlobalSwitch"), 1) == 1) {
            AppMethodBeat.m2505o(104035);
            return true;
        }
        AppMethodBeat.m2505o(104035);
        return false;
    }

    /* renamed from: by */
    private void m10609by(Context context) {
        AppMethodBeat.m2504i(104036);
        if (context == null) {
            AppMethodBeat.m2505o(104036);
            return;
        }
        if (ChatroomInfoUI.m10577JI()) {
            Intent intent = new Intent();
            intent.putExtra("rawUrl", getString(C25738R.string.ajo, new Object[]{C4988aa.dor()}));
            intent.putExtra("geta8key_username", C1853r.m3846Yz());
            intent.putExtra("showShare", false);
            C25985d.m41467b((Context) this, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
        }
        AppMethodBeat.m2505o(104036);
    }

    /* renamed from: d */
    private void m10613d(String str, List<String> list) {
        AppMethodBeat.m2504i(104037);
        if (list != null && list.size() > 0) {
            LinkedList linkedList = new LinkedList();
            for (int i = 0; i < list.size(); i++) {
                linkedList.add(list.get(i));
            }
            C32794m.m53572a(str, linkedList, getString(C25738R.string.ajv), true, "weixin://findfriend/verifycontact/" + str + "/");
        }
        AppMethodBeat.m2505o(104037);
    }

    private void updateTitle() {
        AppMethodBeat.m2504i(104038);
        if (this.cEH) {
            this.eie = C37921n.m64060mA(this.ehq);
            if (this.eie == 0) {
                setMMTitle(getString(C25738R.string.dvi));
                AppMethodBeat.m2505o(104038);
                return;
            }
            setMMTitle(getString(C25738R.string.bwu, new Object[]{getString(C25738R.string.dvi), Integer.valueOf(this.eie)}));
        }
        AppMethodBeat.m2505o(104038);
    }

    /* renamed from: JJ */
    private void m10578JJ() {
        AppMethodBeat.m2504i(104039);
        if (this.ehS != null) {
            if (this.cEH) {
                C1720g.m3539RS().mo10302aa(new C643633());
                AppMethodBeat.m2505o(104039);
                return;
            }
            LinkedList linkedList = new LinkedList();
            linkedList.add(this.ehq);
            this.ehS.mo48371u(this.ehq, linkedList);
        }
        AppMethodBeat.m2505o(104039);
    }

    /* renamed from: JK */
    private void m10579JK() {
        AppMethodBeat.m2504i(104040);
        if (this.ehM != null) {
            CharSequence JD = m10572JD();
            if (C5046bo.isNullOrNil(JD)) {
                JD = C1853r.m3820YB();
            }
            if (C5046bo.isNullOrNil(JD)) {
                this.ehW.setSummary((CharSequence) "");
            } else {
                this.ehW.dAB();
                this.ehW.yCt = C1338a.m2856al(this.mController.ylL, C25738R.dimen.f10029nv);
                KeyValuePreference keyValuePreference = this.ehW;
                if (JD.length() <= 0) {
                    JD = getString(C25738R.string.eal);
                }
                keyValuePreference.setSummary((CharSequence) C44089j.m79292b((Context) this, JD));
            }
            if (this.ehK != null) {
                this.ehK.notifyDataSetChanged();
            }
        }
        AppMethodBeat.m2505o(104040);
    }

    /* renamed from: JL */
    private void m10580JL() {
        AppMethodBeat.m2504i(104041);
        if (this.ehZ == null) {
            this.ehZ = getSharedPreferences(getPackageName() + "_preferences", 0);
        }
        if (this.cEH) {
            this.eif = this.ehM.dua == 0;
        } else if (!this.ehL) {
            this.eif = this.ehM.mo16673DX();
        }
        if (this.eif) {
            setTitleMuteIconVisibility(0);
            if (this.ehT != null) {
                this.ehZ.edit().putBoolean("room_notify_new_msg", true).commit();
            }
        } else {
            setTitleMuteIconVisibility(8);
            if (this.ehT != null) {
                this.ehZ.edit().putBoolean("room_notify_new_msg", false).commit();
            }
        }
        this.ehK.notifyDataSetChanged();
        AppMethodBeat.m2505o(104041);
    }

    /* renamed from: JM */
    private void m10581JM() {
        AppMethodBeat.m2504i(104042);
        if (!(this.ehM == null || this.ehN == null)) {
            CharSequence mC = C37921n.m64062mC(this.ehq);
            if (mC == null || mC.length() <= 0) {
                this.ehN.cui = false;
            } else {
                this.ehN.cui = true;
                this.ehN.eok = C44089j.m79292b((Context) this, mC);
            }
            this.ehM = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(this.ehq);
            if (m10583JO()) {
                mC = this.ehM.mo16707Oj();
                RoomCardPreference roomCardPreference = this.ehN;
                if (mC.length() <= 0) {
                    mC = getString(C25738R.string.eal);
                }
                roomCardPreference.eoj = C44089j.m79292b((Context) this, mC);
            } else {
                this.ehN.eoj = getString(C25738R.string.dsn);
            }
            this.ehK.notifyDataSetChanged();
        }
        AppMethodBeat.m2505o(104042);
    }

    /* renamed from: JN */
    private void m10582JN() {
        AppMethodBeat.m2504i(104043);
        if (!(this.ehM == null || this.ehO == null)) {
            this.ehM = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(this.ehq);
            if (m10583JO()) {
                CharSequence Oj = this.ehM.mo16707Oj();
                Preference preference = this.ehO;
                if (Oj.length() <= 0) {
                    Oj = getString(C25738R.string.eal);
                }
                preference.setSummary(C44089j.m79292b((Context) this, Oj));
                if (this.ehK != null) {
                    this.ehK.notifyDataSetChanged();
                }
                AppMethodBeat.m2505o(104043);
                return;
            }
            this.ehO.setSummary(getString(C25738R.string.dsn));
        }
        AppMethodBeat.m2505o(104043);
    }

    /* renamed from: JO */
    private boolean m10583JO() {
        AppMethodBeat.m2504i(104044);
        String str = this.ehM.field_nickname;
        if (C5046bo.isNullOrNil(str) || str.length() > 50) {
            AppMethodBeat.m2505o(104044);
            return false;
        }
        AppMethodBeat.m2505o(104044);
        return true;
    }

    /* renamed from: N */
    public static ArrayList<C7616ad> m10588N(List<ayb> list) {
        AppMethodBeat.m2504i(104045);
        ArrayList<C7616ad> arrayList = new ArrayList();
        if (list == null) {
            AppMethodBeat.m2505o(104045);
            return arrayList;
        }
        for (ayb ayb : list) {
            C7616ad c7616ad = new C7616ad();
            c7616ad.setUsername(ayb.jBB);
            c7616ad.mo14703iB(ayb.jCH);
            arrayList.add(c7616ad);
        }
        AppMethodBeat.m2505o(104045);
        return arrayList;
    }

    /* renamed from: JP */
    private void m10584JP() {
        AppMethodBeat.m2504i(104046);
        C7060h.pYm.mo8374X(10170, "1");
        List linkedList = new LinkedList();
        linkedList.add(this.ehq);
        linkedList.add(C1853r.m3846Yz());
        String c = C5046bo.m7536c(linkedList, ",");
        Intent intent = new Intent();
        intent.putExtra("titile", getString(C25738R.string.f8781es));
        intent.putExtra("list_type", 0);
        intent.putExtra("list_attr", m10621iz(C15830s.znG));
        intent.putExtra("always_select_contact", c);
        C25985d.m41473f(this, ".ui.contact.SelectContactUI", intent);
        AppMethodBeat.m2505o(104046);
    }

    /* renamed from: kh */
    private boolean m10626kh(String str) {
        boolean z = false;
        AppMethodBeat.m2504i(104047);
        if (C5046bo.nullAsNil(C1853r.m3846Yz()).equals(str)) {
            AppMethodBeat.m2505o(104047);
            return true;
        }
        List my = C37921n.m64074my(this.ehq);
        if (my == null) {
            AppMethodBeat.m2505o(104047);
            return false;
        }
        Iterator it = my.iterator();
        while (true) {
            boolean z2 = z;
            if (!it.hasNext()) {
                AppMethodBeat.m2505o(104047);
                return z2;
            } else if (((String) it.next()).equals(str)) {
                z = true;
            } else {
                z = z2;
            }
        }
    }

    /* renamed from: O */
    private static List<String> m10589O(List<String> list) {
        AppMethodBeat.m2504i(104048);
        LinkedList linkedList = new LinkedList();
        if (!C1720g.m3531RK()) {
            AppMethodBeat.m2505o(104048);
            return linkedList;
        } else if (list == null) {
            AppMethodBeat.m2505o(104048);
            return linkedList;
        } else {
            for (Object obj : list) {
                Object obj2;
                C7616ad aoO = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(obj2);
                if (!(aoO == null || ((int) aoO.ewQ) == 0)) {
                    obj2 = aoO.mo16707Oj();
                }
                linkedList.add(obj2);
            }
            AppMethodBeat.m2505o(104048);
            return linkedList;
        }
    }

    public void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(104049);
        C4990ab.m7416i("MicroMsg.ChatroomInfoUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        C4990ab.m7410d("MicroMsg.ChatroomInfoUI", "pre is " + this.eie);
        this.eie = C37921n.m64060mA(this.ehq);
        C4990ab.m7410d("MicroMsg.ChatroomInfoUI", "now is " + this.eie);
        if (this.ehJ != null) {
            this.ehJ.dismiss();
        }
        AppMethodBeat.m2505o(104049);
    }

    /* renamed from: JQ */
    private void m10585JQ() {
        AppMethodBeat.m2504i(104050);
        if (this.ehS != null) {
            if (this.cEH) {
                m10578JJ();
            } else if (!this.ehL) {
                LinkedList linkedList = new LinkedList();
                linkedList.add(this.ehq);
                this.ehS.mo48371u(this.ehq, linkedList);
            }
            this.ehS.notifyChanged();
        }
        boolean HH = ((C6822c) C1720g.m3528K(C6822c.class)).mo15089HH(this.ehq);
        if (m10586JR()) {
            this.ehK.mo27715ce("room_manager_view", true);
            if (C37921n.m64060mA(this.ehq) > 2) {
                this.ehK.mo27715ce("manage_room", false);
            } else {
                this.ehK.mo27715ce("manage_room", true);
            }
        } else {
            this.ehK.mo27715ce("manage_room", true);
            C15541f c15541f = this.ehK;
            String str = "room_manager_view";
            if (HH) {
                HH = false;
            } else {
                HH = true;
            }
            c15541f.mo27715ce(str, HH);
        }
        if ((m10586JR() || this.eie < C14926j.MAX_COUNT) && (!m10586JR() || this.eie < C14926j.MAX_COUNT - 1)) {
            this.ehK.mo27715ce("see_room_member", true);
        } else {
            this.ehK.mo27715ce("see_room_member", false);
            this.ehP.setTitle(getString(C25738R.string.e14));
        }
        if (C1855t.m3903mP(this.ehq)) {
            if (m10586JR()) {
                this.ehK.mo27715ce("manage_room", false);
            } else {
                this.ehK.mo27715ce("manage_room", true);
            }
            this.ehK.mo27715ce("room_manager_view", true);
        }
        this.ehK.notifyDataSetChanged();
        AppMethodBeat.m2505o(104050);
    }

    /* renamed from: a */
    public final void mo10136a(int i, C7298n c7298n, Object obj) {
        AppMethodBeat.m2504i(104051);
        if (obj == null || !(obj instanceof String)) {
            C4990ab.m7411d("MicroMsg.ChatroomInfoUI", "onNotifyChange obj not String event:%d stg:%s obj:%s", Integer.valueOf(i), c7298n, obj);
            AppMethodBeat.m2505o(104051);
            return;
        }
        mo5248a((String) obj, null);
        AppMethodBeat.m2505o(104051);
    }

    /* renamed from: a */
    public final void mo5248a(String str, C4935m c4935m) {
        AppMethodBeat.m2504i(104052);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(104052);
        } else if (C1855t.m3896kH(str)) {
            C4990ab.m7410d("MicroMsg.ChatroomInfoUI", "event:".concat(String.valueOf(str)));
            if (this.cEH && str.equals(this.ehq)) {
                C1720g.m3539RS().mo10302aa(new C641737());
            }
            m10585JQ();
            AppMethodBeat.m2505o(104052);
        } else {
            C4990ab.m7410d("MicroMsg.ChatroomInfoUI", "event:" + str + " cancel");
            AppMethodBeat.m2505o(104052);
        }
    }

    /* renamed from: k */
    public final void mo14628k(String str, String str2, String str3) {
        AppMethodBeat.m2504i(104053);
        if (str.equals(this.ehq) && this.ehS != null) {
            this.ehS.notifyChanged();
        }
        AppMethodBeat.m2505o(104053);
    }

    /* renamed from: a */
    public final C40675h mo14627a(SharedPreferences sharedPreferences) {
        AppMethodBeat.m2504i(104054);
        C41341a c41341a = new C41341a(this, this.nDp, sharedPreferences);
        AppMethodBeat.m2505o(104054);
        return c41341a;
    }

    /* renamed from: JR */
    private boolean m10586JR() {
        AppMethodBeat.m2504i(104055);
        if (this.eih == null || !this.eih.mo16786JR()) {
            AppMethodBeat.m2505o(104055);
            return false;
        }
        AppMethodBeat.m2505o(104055);
        return true;
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(104023);
        if (C32337g.fUs != null) {
            C32337g.fUs.mo4620a(this);
        }
        C1720g.m3536RP().mo5239Ry().mo10121b(this);
        C40871a.dismiss();
        C1720g.m3535RO().eJo.mo14546b(480, (C1202f) this);
        C4879a.xxA.mo10053d(this.eip);
        C46483b.m87700b(C32589ko.class.getName(), this.eiw);
        if (C1720g.m3531RK()) {
            ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().mo10121b(this);
            ((C6822c) C1720g.m3528K(C6822c.class)).mo15090XV().mo10117d(this);
        }
        if (C32337g.fUs != null) {
            C32337g.fUs.mo4623b(this);
        }
        if (this.eix != null) {
            this.eix.stopTimer();
        }
        super.onDestroy();
        AppMethodBeat.m2505o(104023);
    }

    /* JADX WARNING: Removed duplicated region for block: B:57:0x0283  */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x0423  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x02b5  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void initView() {
        AppMethodBeat.m2504i(104025);
        this.ehK = this.yCw;
        String str;
        if (this.cEH) {
            C7577u oa;
            if (this.eie == 0) {
                setMMTitle(getString(C25738R.string.dvi));
            } else {
                if (this.eih != null) {
                    this.eie = this.eih.afg().size();
                }
                setMMTitle(getString(C25738R.string.bwu, new Object[]{getString(C25738R.string.dvi), Integer.valueOf(this.eie)}));
            }
            str = null;
            if (this.eih != null) {
                str = this.eih.field_roomowner;
                this.eie = this.eih.afg().size();
            }
            if (C5046bo.isNullOrNil(str)) {
                this.eib = false;
                this.eic = false;
                this.eid = false;
            } else {
                this.eib = true;
                this.eic = str.equals(C1853r.m3846Yz());
            }
            C4990ab.m7410d("MicroMsg.ChatroomInfoUI", "initBaseChatRoomView()");
            this.ehS = (ContactListExpandPreference) this.ehK.aqO("roominfo_contact_anchor");
            this.ehS.mo48357a(this.ehK, this.ehS.mKey);
            this.ehR = (NormalIconPreference) this.ehK.aqO("del_selector_btn");
            this.ehQ = (NormalIconPreference) this.ehK.aqO("add_selector_btn");
            this.ehO = this.ehK.aqO("room_name");
            this.ehN = (RoomCardPreference) this.ehK.aqO("room_card");
            this.ehP = this.ehK.aqO("see_room_member");
            this.ehT = (CheckBoxPreference) this.ehK.aqO("room_notify_new_msg");
            this.ehU = (CheckBoxPreference) this.ehK.aqO("room_save_to_contact");
            this.ehV = (CheckBoxPreference) this.ehK.aqO("room_placed_to_the_top");
            this.ehW = (KeyValuePreference) this.ehK.aqO("room_nickname");
            this.ehY = this.ehK.aqO("manage_room");
            this.ehS.mo48368oD(true).mo48369oE(true).djG();
            boolean HH = ((C6822c) C1720g.m3528K(C6822c.class)).mo15089HH(this.ehq);
            if (m10586JR()) {
                this.ehK.mo27715ce("room_manager_view", true);
                if (C37921n.m64060mA(this.ehq) > 2) {
                    this.ehK.mo27715ce("manage_room", false);
                } else {
                    this.ehK.mo27715ce("manage_room", true);
                }
            } else {
                this.ehK.mo27715ce("manage_room", true);
                C15541f c15541f = this.ehK;
                String str2 = "room_manager_view";
                if (HH) {
                    HH = false;
                } else {
                    HH = true;
                }
                c15541f.mo27715ce(str2, HH);
            }
            if (C1855t.m3903mP(this.ehq)) {
                if (m10586JR()) {
                    this.ehK.mo27715ce("manage_room", false);
                } else {
                    this.ehK.mo27715ce("manage_room", true);
                }
            }
            if (this.eih != null) {
                this.ehS.ajF(this.eih.field_roomowner);
                if (!C5046bo.isNullOrNil(this.eih.field_roomowner)) {
                    this.ehS.vld.vkt.vkT = true;
                }
            }
            this.ehS.djF();
            this.ehS.djz();
            this.ehK.mo27715ce("add_selector_btn", true);
            this.ehK.mo27715ce("del_selector_btn", true);
            this.ehK.mo27715ce("room_name", false);
            this.ehK.mo27715ce("room_qr_code", false);
            this.ehK.mo27715ce("chatroom_info_chexboxes", true);
            this.ehK.mo27715ce("room_card", false);
            this.ehK.mo27715ce("room_upgrade_entry", true);
            this.ehK.mo27715ce("chat_room_story_videos", true);
            if ((m10586JR() || this.eie < C14926j.MAX_COUNT) && (!m10586JR() || this.eie < C14926j.MAX_COUNT - 1)) {
                this.ehK.mo27715ce("see_room_member", true);
            } else {
                this.ehK.mo27715ce("see_room_member", false);
                this.ehP.setTitle(getString(C25738R.string.e14));
            }
            if (C7616ad.aoy(this.ehq)) {
                this.ehK.mo27715ce("chatroom_bottom_pc", true);
                this.ehK.mo27715ce("room_openim_about", false);
                str = getString(C25738R.string.dtr);
                String string = getString(C25738R.string.dts);
                int lastIndexOf = str.lastIndexOf(string);
                if (lastIndexOf >= 0) {
                    int length = string.length() + lastIndexOf;
                    CharSequence spannableStringBuilder = new SpannableStringBuilder(str);
                    spannableStringBuilder.setSpan(new C13735(), lastIndexOf, length, 18);
                    this.ehK.aqO("room_openim_about").setTitle(spannableStringBuilder);
                }
            } else {
                this.ehK.mo27715ce("room_openim_about", true);
            }
            C4990ab.m7410d("MicroMsg.ChatroomInfoUI", "updatePlaceTop()");
            if (this.ehZ == null) {
                this.ehZ = getSharedPreferences(getPackageName() + "_preferences", 0);
            }
            if (this.ehV != null) {
                if (this.ehM != null) {
                    this.ehZ.edit().putBoolean("room_placed_to_the_top", ((C6982j) C1720g.m3528K(C6982j.class)).mo15371XR().aph(this.ehM.field_username)).commit();
                } else {
                    this.ehZ.edit().putBoolean("room_placed_to_the_top", false).commit();
                }
            }
            this.ehK.notifyDataSetChanged();
            C4990ab.m7410d("MicroMsg.ChatroomInfoUI", "updateSaveToContact()");
            if (this.ehZ == null) {
                this.ehZ = getSharedPreferences(getPackageName() + "_preferences", 0);
            }
            if (this.ehU != null) {
                C7616ad aoO = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(this.ehq);
                if (aoO == null) {
                    C4990ab.m7412e("MicroMsg.ChatroomInfoUI", "contact == null !!!");
                    C4990ab.m7410d("MicroMsg.ChatroomInfoUI", "updateDisplayNickname()");
                    if (this.ehZ == null) {
                        this.ehZ = getSharedPreferences(getPackageName() + "_preferences", 0);
                    }
                    oa = ((C6822c) C1720g.m3528K(C6822c.class)).mo15090XV().mo14885oa(this.ehq);
                    if (oa != null) {
                        C4990ab.m7412e("MicroMsg.ChatroomInfoUI", "members == null !!!");
                    } else {
                        this.eia = oa.drX();
                        this.ehX = (CheckBoxPreference) this.ehK.aqO("room_msg_show_username");
                        if (this.ehX != null) {
                            this.ehZ.edit().putBoolean("room_msg_show_username", this.eia).commit();
                        }
                        this.ehK.notifyDataSetChanged();
                    }
                    this.eii = ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15263Rq(this.ehq);
                    this.eii = ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15263Rq(this.ehq);
                } else {
                    this.ehZ.edit().putBoolean("room_save_to_contact", C7486a.m12942jh(aoO.field_type)).commit();
                }
            }
            this.ehK.notifyDataSetChanged();
            C4990ab.m7410d("MicroMsg.ChatroomInfoUI", "updateDisplayNickname()");
            if (this.ehZ == null) {
            }
            oa = ((C6822c) C1720g.m3528K(C6822c.class)).mo15090XV().mo14885oa(this.ehq);
            if (oa != null) {
            }
            this.eii = ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15263Rq(this.ehq);
            this.eii = ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15263Rq(this.ehq);
        } else if (this.ehL) {
            this.eic = false;
            this.eid = false;
            setMMTitle(getString(C25738R.string.dsu));
            this.ehS = (ContactListExpandPreference) this.ehK.aqO("roominfo_contact_anchor");
            this.ehS.mo48357a(this.ehK, this.ehS.mKey);
            this.ehS.mo48368oD(false).mo48369oE(false);
            this.ehS.mo48355a(new C13746());
            this.ehK.removeAll();
            this.ehK.mo27713b(new PreferenceCategory(this));
            this.ehK.mo27713b(this.ehS);
            str = this.ehq;
            final C32589ko c32589ko = new C32589ko();
            c32589ko.cGu.cEw = str;
            C4879a.xxA.mo10055m(c32589ko);
            getString(C25738R.string.f9238tz);
            this.ehJ = C30379h.m48458b((Context) this, getString(C25738R.string.dss), true, new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                    AppMethodBeat.m2504i(104003);
                    ChatroomInfoUI.m10601a(c32589ko);
                    AppMethodBeat.m2505o(104003);
                }
            });
            this.ehK.notifyDataSetChanged();
        }
        if (this.ehS != null) {
            if (!this.cEH && this.ehL) {
                this.ehS.mo48358ag(new ArrayList());
            }
            this.nDp.setOnScrollListener(this.ein);
            this.ehS.mo48356a(this.ein);
            this.ehS.mo48355a(new C643245());
            ContactListExpandPreference contactListExpandPreference = this.ehS;
            C64482 c64482 = new C64482();
            if (contactListExpandPreference.vld != null) {
                contactListExpandPreference.vld.pLd = c64482;
            }
            this.ehS.mo48354a(new C64313());
        }
        setBackBtn(new C64334());
        AppMethodBeat.m2505o(104025);
    }

    /* renamed from: a */
    public final boolean mo8453a(C15541f c15541f, Preference preference) {
        int i = 1;
        AppMethodBeat.m2504i(104026);
        String str = preference.mKey;
        int i2;
        Intent intent;
        C32677t c32677t;
        Intent intent2;
        boolean aoo;
        C45457b c45457b;
        String str2;
        boolean z;
        IMBehavior iMBehavior;
        String JD;
        if (str.equals("room_name")) {
            str = C26373g.m41964Nu().getValue("ChatRoomOwnerModTopic");
            if (C5046bo.isNullOrNil(str)) {
                i2 = 0;
            } else {
                i2 = C5046bo.ank(str);
            }
            if (C5046bo.isNullOrNil(this.eih.field_roomowner) || i2 <= 0 || m10586JR() || i2 >= this.eie) {
                str = "";
                if (m10583JO()) {
                    str = this.ehM.mo16707Oj();
                }
                intent = new Intent();
                intent.setClass(this, ModRemarkRoomNameUI.class);
                intent.putExtra("room_name", str);
                intent.putExtra("RoomInfo_Id", this.ehq);
                startActivityForResult(intent, 4);
                C7060h.pYm.mo8378a(219, 3, 1, true);
            } else {
                C30379h.m48443a((Context) this, getString(C25738R.string.duw, new Object[]{m10576JH()}), null, getString(C25738R.string.f9151r4), new C13757());
            }
        } else if (str.equals("room_upgrade_entry")) {
            m10609by(this);
        } else if (str.equals("room_qr_code")) {
            if (C1855t.m3903mP(this.ehq)) {
                c32677t = new C32677t();
                c32677t.mo53208eO(this.ehq);
                c32677t.cXP = 6;
                c32677t.ajK();
            }
            C7060h.pYm.mo8378a(219, 5, 1, true);
            intent2 = new Intent();
            intent2.putExtra("from_userName", this.ehq);
            C25985d.m41467b((Context) this, "setting", ".ui.setting.SelfQRCodeUI", intent2);
        } else if (str.equals("room_card")) {
            aoo = this.eih.aoo(C1853r.m3846Yz());
            if (!C5046bo.isNullOrNil(C37921n.m64062mC(this.ehq)) || m10586JR()) {
                intent = new Intent();
                intent.setClass(this, RoomCardUI.class);
                intent.putExtra("RoomInfo_Id", this.ehq);
                intent.putExtra("room_name", this.ehN.eoj.toString());
                this.eie = C37921n.m64074my(this.ehq).size();
                intent.putExtra("room_member_count", this.eie);
                intent.putExtra("room_owner_name", m10576JH());
                intent.putExtra("room_notice", C37921n.m64062mC(this.ehq));
                intent.putExtra("room_notice_publish_time", C37921n.m64064mE(this.ehq));
                intent.putExtra("room_notice_editor", C37921n.m64063mD(this.ehq));
                intent.putExtra("Is_RoomOwner", this.eic);
                intent.putExtra("Is_RoomManager", aoo);
                startActivityForResult(intent, 6);
            } else {
                C30379h.m48466d(this, getString(C25738R.string.drl), null, getString(C25738R.string.drm), null, null, null);
            }
        } else if (str.equals("room_notify_new_msg")) {
            this.eif = !this.eif;
            if (this.cEH) {
                int i3;
                if (this.eif) {
                    i3 = 0;
                } else {
                    i3 = 1;
                }
                C30262b.alY(this.ehq).mo20627E(this.ehq, i3).dmX();
                this.ehM = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(this.ehq);
                this.ehM.mo14689hE(i3);
                ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().mo15724b(this.ehq, this.ehM);
                if (this.eim) {
                    long j;
                    C7060h c7060h = C7060h.pYm;
                    if (this.eif) {
                        j = 14;
                    } else {
                        j = 15;
                    }
                    c7060h.mo15419k(869, j, 1);
                }
            }
            c45457b = C45457b.fRa;
            str2 = this.ehq;
            z = this.eif;
            if (c45457b.aka() && c45457b.mo73264cM(str2)) {
                iMBehavior = new IMBehavior();
                iMBehavior.opType = 1;
                iMBehavior.chattingOp = new IMBehaviorChattingOP();
                IMBehaviorChattingOP iMBehaviorChattingOP = iMBehavior.chattingOp;
                if (!z) {
                    i = 2;
                }
                iMBehaviorChattingOP.changeNotifyStatus = i;
                synchronized (c45457b.lock) {
                    try {
                        c45457b.fQZ.oplist_.add(iMBehavior);
                    } catch (Throwable th) {
                        while (true) {
                            AppMethodBeat.m2505o(104026);
                        }
                    }
                }
            }
            m10580JL();
        } else if (str.equals("room_save_to_contact")) {
            if (this.ehZ == null) {
                this.ehZ = getSharedPreferences(getPackageName() + "_preferences", 0);
            }
            C7616ad aoO = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(this.ehq);
            if (aoO != null) {
                z = C7486a.m12942jh(aoO.field_type);
                this.ehZ.edit().putBoolean("room_save_to_contact", !z).commit();
                if (z) {
                    aoO.mo16677NC();
                    C30262b.alY(this.ehq).mo20635a(aoO, false);
                    C30379h.m48465bQ(this, getString(C25738R.string.du4));
                    C45457b.fRa.mo73255R(this.ehq, false);
                } else {
                    C30262b.alY(this.ehq).mo20635a(aoO, true);
                    C30379h.m48465bQ(this, getString(C25738R.string.duj));
                    C45457b.fRa.mo73255R(this.ehq, true);
                }
                this.ehK.notifyDataSetChanged();
            }
        } else if (str.equals("room_placed_to_the_top")) {
            SharedPreferences sharedPreferences = getSharedPreferences(this.eis, 0);
            if (this.ehM != null) {
                if (((C6982j) C1720g.m3528K(C6982j.class)).mo15371XR().aph(this.ehM.field_username)) {
                    C1855t.m3969x(this.ehM.field_username, true);
                    C45457b.fRa.mo73263c(false, this.ehq, false);
                } else {
                    C1855t.m3967w(this.ehM.field_username, true);
                    C45457b.fRa.mo73263c(false, this.ehq, true);
                }
                sharedPreferences.edit().putBoolean("room_placed_to_the_top", ((C6982j) C1720g.m3528K(C6982j.class)).mo15371XR().aph(this.ehM.field_username)).commit();
            }
        } else if (str.equals("room_nickname")) {
            JD = m10572JD();
            if (C5046bo.isNullOrNil(JD)) {
                JD = C1853r.m3820YB();
            }
            C30379h.m48442a(this.mController.ylL, getString(C25738R.string.dtf), JD, getString(C25738R.string.dsg), 32, new C30387b() {
                /* renamed from: s */
                public final boolean mo4760s(CharSequence charSequence) {
                    AppMethodBeat.m2504i(103969);
                    String charSequence2 = charSequence == null ? "" : charSequence.toString();
                    String Ne = C42164b.m74343Ne();
                    if (C5046bo.isNullOrNil(Ne) || !charSequence2.matches(".*[" + Ne + "].*")) {
                        if (!(charSequence2 == null || charSequence2.equals(JD))) {
                            ChatroomInfoUI.m10597a(ChatroomInfoUI.this, charSequence2);
                        }
                        AppMethodBeat.m2505o(103969);
                        return true;
                    }
                    C30379h.m48465bQ(ChatroomInfoUI.this.mController.ylL, ChatroomInfoUI.this.getString(C25738R.string.ce4, new Object[]{Ne}));
                    AppMethodBeat.m2505o(103969);
                    return false;
                }
            });
        } else if (str.equals("room_msg_show_username")) {
            Editor edit = getSharedPreferences(this.eis, 0).edit();
            JD = "room_msg_show_username";
            if (this.eia) {
                aoo = false;
            } else {
                aoo = true;
            }
            edit.putBoolean(JD, aoo).commit();
            if (this.eia) {
                aoo = false;
            } else {
                aoo = true;
            }
            this.eia = aoo;
            this.eig = true;
        } else if (str.equals("room_set_chatting_background")) {
            if (C1855t.m3903mP(this.ehq)) {
                c32677t = new C32677t();
                c32677t.mo53208eO(this.ehq);
                c32677t.cXP = 9;
                c32677t.ajK();
            }
            intent2 = new Intent();
            intent2.putExtra("isApplyToAll", false);
            intent2.putExtra("username", this.ehM.field_username);
            C25985d.m41468b((Context) this, "setting", ".ui.setting.SettingsChattingBackgroundUI", intent2, 2);
        } else if (str.equals("room_search_chatting_content")) {
            if (C1855t.m3903mP(this.ehq)) {
                c32677t = new C32677t();
                c32677t.mo53208eO(this.ehq);
                c32677t.cXP = 8;
                c32677t.ajK();
            }
            intent2 = new Intent();
            intent2.putExtra("detail_username", this.ehq);
            C3161d.m5413c(this, ".ui.FTSChattingConvUI", intent2);
            if (this.eih == null || this.eih.afg() == null) {
                i2 = 0;
            } else {
                i2 = this.eih.afg().size();
            }
            C7060h.pYm.mo8381e(14569, Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(i2), Integer.valueOf(1));
        } else if (str.equals("room_clear_chatting_history")) {
            if (C1855t.m3903mP(this.ehq)) {
                c32677t = new C32677t();
                c32677t.mo53208eO(this.ehq);
                c32677t.cXP = 11;
                c32677t.ajK();
            }
            C30379h.m48444a(this.mController.ylL, getString(C25738R.string.bx2), "", getString(C25738R.string.f9078ou), getString(C25738R.string.f9076or), new C641810(), null, (int) C25738R.color.f11717ei);
        } else if (str.equals("room_report_it")) {
            if (C1855t.m3903mP(this.ehq)) {
                c32677t = new C32677t();
                c32677t.mo53208eO(this.ehq);
                c32677t.cXP = 10;
                c32677t.ajK();
            }
            intent2 = new Intent();
            intent2.putExtra("k_username", this.ehq);
            intent2.putExtra("showShare", false);
            intent2.putExtra("rawUrl", String.format("https://weixin110.qq.com/security/readtemplate?t=weixin_report/w_type&scene=%d#wechat_redirect", new Object[]{Integer.valueOf(36)}));
            C25985d.m41467b((Context) this, "webview", ".ui.tools.WebViewUI", intent2);
            c45457b = C45457b.fRa;
            str2 = this.ehq;
            if (c45457b.aka() && c45457b.mo73264cM(str2)) {
                iMBehavior = new IMBehavior();
                iMBehavior.opType = 1;
                iMBehavior.chattingOp = new IMBehaviorChattingOP();
                iMBehavior.chattingOp.expose = 1;
                synchronized (c45457b.lock) {
                    try {
                        c45457b.fQZ.oplist_.add(iMBehavior);
                    } catch (Throwable th2) {
                        AppMethodBeat.m2505o(104026);
                    }
                }
            }
        } else if (str.equals("room_del_quit")) {
            C4990ab.m7410d("MicroMsg.ChatroomInfoUI", " quit " + this.ehq);
            C42062sz c42062sz = new C42062sz();
            c42062sz.cPf.cPh = true;
            C4879a.xxA.mo10055m(c42062sz);
            aoo = !C5046bo.isNullOrNil(this.ehq) && this.ehq.equals(c42062sz.cPg.cPj);
            if (aoo) {
                C4990ab.m7410d("MicroMsg.ChatroomInfoUI", " quit talkroom" + this.ehq);
            } else if (this.eic && this.eih.afg().size() > 2) {
                C30379h.m48422a((Context) this, "", new String[]{getString(C25738R.string.dtt)}, getString(C25738R.string.f9076or), new C644313());
            }
            C30379h.m48444a(this.mController.ylL, getString(C25738R.string.b4z), "", getString(C25738R.string.f9187s6), getString(C25738R.string.f9076or), new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.m2504i(103977);
                    if (ChatroomInfoUI.this.ehq == null || ChatroomInfoUI.this.ehq.length() <= 0) {
                        C4990ab.m7412e("MicroMsg.ChatroomInfoUI", "quitChatRoom : invalid args");
                        AppMethodBeat.m2505o(103977);
                        return;
                    }
                    if (aoo) {
                        C42062sz c42062sz = new C42062sz();
                        c42062sz.cPf.cPi = true;
                        C4879a.xxA.mo10055m(c42062sz);
                    }
                    if (((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoQ(ChatroomInfoUI.this.ehq)) {
                        ChatroomInfoUI.m10637v(ChatroomInfoUI.this);
                        ((C39419a) C1720g.m3528K(C39419a.class)).mo55109RU(ChatroomInfoUI.this.ehq);
                        AppMethodBeat.m2505o(103977);
                        return;
                    }
                    C4990ab.m7412e("MicroMsg.ChatroomInfoUI", "quitChatRoom : room[" + ChatroomInfoUI.this.ehq + "] is not exist");
                    AppMethodBeat.m2505o(103977);
                }
            }, null, (int) C25738R.color.f11717ei);
        } else if (str.equals("add_selector_btn")) {
            m10574JF();
        } else if (str.equals("del_selector_btn")) {
            m10575JG();
        } else if (str.equals("see_room_member")) {
            intent = new Intent();
            intent.setClass(this.mController.ylL, SeeRoomMemberUI.class);
            intent.putExtra("Block_list", C1853r.m3846Yz());
            List my = C37921n.m64074my(this.ehq);
            if (my != null) {
                this.eie = my.size();
            }
            intent.putExtra("Chatroom_member_list", C5046bo.m7536c(my, ","));
            intent.putExtra("RoomInfo_Id", this.ehq);
            intent.putExtra("room_owner_name", this.eih.field_roomowner);
            intent.putExtra("Is_RoomOwner", this.eic);
            intent.putExtra("room_member_count", this.eie);
            intent.putExtra("Add_address_titile", getString(C25738R.string.dun));
            if (this.cEH) {
                intent.putExtra("Contact_Scene", 14);
            } else if (this.ehL) {
                intent.putExtra("Contact_Scene", 44);
                if (!C1853r.m3858mG(this.ehM.field_username)) {
                    intent.putExtra("Contact_IsLBSFriend", true);
                }
            }
            JD = "offset";
            View childAt = this.nDp.getChildAt(0);
            if (childAt == null) {
                i2 = 0;
            } else {
                i2 = -childAt.getTop();
            }
            intent.putExtra(JD, i2);
            intent.putExtra("first_pos", this.nDp.getFirstVisiblePosition());
            intent.putExtra("room_name", this.ehM.field_username);
            startActivityForResult(intent, 5);
            this.eiq = 5;
        } else if (str.equals("manage_room")) {
            intent2 = new Intent();
            intent2.setClass(this.mController.ylL, ManageChatroomUI.class);
            intent2.putExtra("RoomInfo_Id", this.ehq);
            intent2.putExtra("room_owner_name", this.eih.field_roomowner);
            startActivity(intent2);
        } else if (str.equals("chat_room_app_brand")) {
            if (C1855t.m3903mP(this.ehq)) {
                c32677t = new C32677t();
                c32677t.mo53208eO(this.ehq);
                c32677t.cXP = 7;
                c32677t.ajK();
            }
            intent2 = new Intent();
            intent2.putExtra("Chat_User", this.ehq);
            C25985d.m41473f(this, ".ui.chatting.gallery.AppBrandHistoryListUI", intent2);
            C7060h.pYm.mo8378a(219, 25, 1, true);
        } else if (str.equals("room_manager_view")) {
            intent2 = new Intent();
            intent2.setClass(this.mController.ylL, SeeRoomOwnerManagerUI.class);
            intent2.putExtra("RoomInfo_Id", this.ehq);
            intent2.putExtra("room_owner_name", this.eih.field_roomowner);
            startActivity(intent2);
        } else {
            str.equals("chat_room_story_videos");
        }
        AppMethodBeat.m2505o(104026);
        return false;
    }

    /* renamed from: v */
    static /* synthetic */ void m10637v(ChatroomInfoUI chatroomInfoUI) {
        String str;
        AppMethodBeat.m2504i(104068);
        C7060h.pYm.mo8381e(14553, Integer.valueOf(4), Integer.valueOf(2), chatroomInfoUI.ehq);
        long j = ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15247Ra(chatroomInfoUI.ehq).field_msgSvrId;
        C40580vo c40580vo = new C40580vo();
        c40580vo.wcB = new bts().alV(C5046bo.nullAsNil(chatroomInfoUI.ehq));
        c40580vo.ptF = j;
        ((C6982j) C1720g.m3528K(C6982j.class)).mo15368XL().mo7920c(new C3465a(8, c40580vo));
        chatroomInfoUI.isDeleteCancel = false;
        chatroomInfoUI.getString(C25738R.string.f9238tz);
        final C44275p b = C30379h.m48458b((Context) chatroomInfoUI, chatroomInfoUI.getString(C25738R.string.f9260un), true, new C641315());
        if (chatroomInfoUI.isDeleteCancel) {
            str = null;
        } else {
            str = C40492e.akq(chatroomInfoUI.ehM.field_username);
        }
        if (C5046bo.isNullOrNil(str)) {
            chatroomInfoUI.m10607bB(true);
            AppMethodBeat.m2505o(104068);
            return;
        }
        b.dismiss();
        Object[] objArr = new Object[]{str};
        C30379h.m48454a(chatroomInfoUI, false, chatroomInfoUI.getString(C25738R.string.fdl, objArr), null, chatroomInfoUI.getString(C25738R.string.c9y), chatroomInfoUI.getString(C25738R.string.dry), new C641416(), new OnClickListener() {
            final /* synthetic */ boolean eiF = true;

            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.m2504i(103980);
                C7060h.pYm.mo8381e(14553, Integer.valueOf(4), Integer.valueOf(3), ChatroomInfoUI.this.ehq);
                b.show();
                ChatroomInfoUI.this.isDeleteCancel = false;
                ChatroomInfoUI.m10605b(ChatroomInfoUI.this, this.eiF);
                AppMethodBeat.m2505o(103980);
            }
        }, -1, C25738R.color.f11717ei);
        AppMethodBeat.m2505o(104068);
    }

    /* renamed from: z */
    static /* synthetic */ void m10641z(ChatroomInfoUI chatroomInfoUI) {
        AppMethodBeat.m2504i(104071);
        chatroomInfoUI.updateTitle();
        if (chatroomInfoUI.eih != null) {
            chatroomInfoUI.eie = chatroomInfoUI.eih.afg().size();
        }
        if ((!chatroomInfoUI.eic && chatroomInfoUI.eie >= C14926j.MAX_COUNT) || (chatroomInfoUI.eic && chatroomInfoUI.eie >= C14926j.MAX_COUNT - 1)) {
            chatroomInfoUI.ehK.mo27715ce("see_room_member", false);
            chatroomInfoUI.ehP.setTitle(chatroomInfoUI.getString(C25738R.string.e14));
        }
        AppMethodBeat.m2505o(104071);
    }

    /* renamed from: a */
    static /* synthetic */ void m10594a(ChatroomInfoUI chatroomInfoUI, int i, C44205c c44205c, String str) {
        AppMethodBeat.m2504i(104072);
        String str2 = "";
        String str3 = "";
        String string = C4996ah.getContext().getString(C25738R.string.ajw);
        final List list = c44205c.ehj;
        final List list2 = c44205c.ehl;
        final List list3 = c44205c.cGd;
        if (i != -2012 || ((list == null || list.isEmpty()) && (list2 == null || list2.isEmpty()))) {
            String string2;
            Object obj;
            C7577u ob = ((C6822c) C1720g.m3528K(C6822c.class)).mo15090XV().mo14886ob(chatroomInfoUI.ehq);
            if (i == -116 && ChatroomInfoUI.m10577JI() && !C5046bo.isNullOrNil(ob.field_roomowner)) {
                str2 = chatroomInfoUI.getString(C25738R.string.dt5);
                string2 = chatroomInfoUI.getString(C25738R.string.dt4);
                obj = 1;
            } else {
                string2 = str3;
                obj = null;
            }
            if (i == -23) {
                str2 = chatroomInfoUI.getString(C25738R.string.dtb);
                string2 = chatroomInfoUI.getString(C25738R.string.dta);
            }
            if (i == -109) {
                str2 = chatroomInfoUI.getString(C25738R.string.dt7);
                string2 = chatroomInfoUI.getString(C25738R.string.dt6);
            }
            if (i == -122) {
                str2 = chatroomInfoUI.getString(C25738R.string.dtb);
                string2 = chatroomInfoUI.getString(C25738R.string.dt_, new Object[]{chatroomInfoUI.m10576JH(), Integer.valueOf(ob.drW())});
            }
            List list4 = c44205c.ehk;
            if (list3 == null || list3.size() <= 0 || (list3.size() != c44205c.cEX && (list4 == null || list4.size() <= 0 || c44205c.cEX != list3.size() + list4.size()))) {
                list4 = c44205c.ehk;
                if (list4 != null && list4.size() > 0) {
                    string2 = string2 + chatroomInfoUI.getString(C25738R.string.bx_, new Object[]{C5046bo.m7536c(ChatroomInfoUI.m10589O(list4), string)});
                }
                list4 = c44205c.cGc;
                if (list4 == null || list4.size() <= 0) {
                    str3 = string2;
                } else {
                    str2 = chatroomInfoUI.getString(C25738R.string.f8714cw);
                    str3 = string2 + chatroomInfoUI.getString(C25738R.string.bxn, new Object[]{C5046bo.m7536c(ChatroomInfoUI.m10589O(list4), string)});
                }
                List<String> list5 = c44205c.cGa;
                if (list5 != null && list5.size() > 0) {
                    Object obj2;
                    for (String string22 : list5) {
                        if (C7616ad.aox(string22)) {
                            str2 = chatroomInfoUI.getString(C25738R.string.cm_);
                            str3 = chatroomInfoUI.getString(C25738R.string.cma);
                            obj2 = 1;
                            break;
                        }
                    }
                    obj2 = null;
                    if (obj2 == null) {
                        str2 = chatroomInfoUI.getString(C25738R.string.f8714cw);
                        str3 = str3 + chatroomInfoUI.getString(C25738R.string.bxc, new Object[]{C5046bo.m7536c(ChatroomInfoUI.m10589O(list5), string)});
                    }
                }
                List list6 = c44205c.ehl;
                ArrayList arrayList = new ArrayList();
                if (!(list3 == null || list3.isEmpty())) {
                    arrayList.addAll(list3);
                }
                if (list6 != null && list6.size() > 0) {
                    arrayList.addAll(list6);
                }
                if (i != -2028 && C1855t.m3902mO(chatroomInfoUI.ehq)) {
                    chatroomInfoUI.m10613d(c44205c.chatroomName, list3);
                }
                string22 = str3 + chatroomInfoUI.getString(C25738R.string.bwt, new Object[]{C5046bo.m7536c(ChatroomInfoUI.m10589O(arrayList), string)});
                if (list3 != null && list3.isEmpty()) {
                    string22 = null;
                }
                if (C1855t.m3903mP(chatroomInfoUI.ehq)) {
                    if (c44205c != null && !C5046bo.isNullOrNil(c44205c.vEO)) {
                        C30379h.m48461b((Context) chatroomInfoUI, c44205c.vEO, "", true);
                        AppMethodBeat.m2505o(104072);
                        return;
                    } else if (C1855t.m3903mP(chatroomInfoUI.ehq) && !C5046bo.isNullOrNil(str)) {
                        C30379h.m48461b((Context) chatroomInfoUI, str, "", true);
                        AppMethodBeat.m2505o(104072);
                        return;
                    }
                }
                if (string22 == null || string22.length() <= 0) {
                    if (c44205c == null || C5046bo.isNullOrNil(c44205c.vEO)) {
                        if (C1855t.m3903mP(chatroomInfoUI.ehq) && !C5046bo.isNullOrNil(str)) {
                            C30379h.m48461b((Context) chatroomInfoUI, str, "", true);
                        }
                        AppMethodBeat.m2505o(104072);
                        return;
                    }
                    C30379h.m48461b((Context) chatroomInfoUI, c44205c.vEO, "", true);
                    AppMethodBeat.m2505o(104072);
                    return;
                } else if (c44205c != null && !C5046bo.isNullOrNil(c44205c.vEO)) {
                    C30379h.m48461b((Context) chatroomInfoUI, c44205c.vEO, "", true);
                    AppMethodBeat.m2505o(104072);
                    return;
                } else if (C1855t.m3903mP(chatroomInfoUI.ehq) && !C5046bo.isNullOrNil(str)) {
                    C30379h.m48461b((Context) chatroomInfoUI, str, "", true);
                    AppMethodBeat.m2505o(104072);
                    return;
                } else if (obj != null) {
                    C30379h.m48440a((Context) chatroomInfoUI, string22, str2, new C642830(), null);
                    AppMethodBeat.m2505o(104072);
                    return;
                } else {
                    C30379h.m48461b((Context) chatroomInfoUI, string22, str2, true);
                    AppMethodBeat.m2505o(104072);
                    return;
                }
            }
            List linkedList = new LinkedList();
            for (int i2 = 0; i2 < list3.size(); i2++) {
                linkedList.add(list3.get(i2));
            }
            string22 = "";
            String string3 = C4996ah.getContext().getString(C25738R.string.ajw);
            if (!(list4 == null || list4.isEmpty())) {
                string22 = chatroomInfoUI.getString(C25738R.string.bws, new Object[]{C5046bo.m7536c(ChatroomInfoUI.m10589O(list4), string3)}) + IOUtils.LINE_SEPARATOR_UNIX;
            }
            if (!linkedList.isEmpty()) {
                string22 = string22 + chatroomInfoUI.getString(C25738R.string.bwt, new Object[]{C5046bo.m7536c(ChatroomInfoUI.m10589O(linkedList), string3)});
            }
            C30379h.m48443a((Context) chatroomInfoUI, string22, "", chatroomInfoUI.getString(C25738R.string.bwl), new C642931());
            if (C1855t.m3902mO(chatroomInfoUI.ehq)) {
                chatroomInfoUI.m10613d(c44205c.chatroomName, linkedList);
            }
            AppMethodBeat.m2505o(104072);
            return;
        }
        String string4 = chatroomInfoUI.getString(C25738R.string.f8715cx);
        String string5 = chatroomInfoUI.getString(C25738R.string.ce5);
        String string6 = chatroomInfoUI.getString(C25738R.string.f9076or);
        final C44205c c44205c2 = c44205c;
        C644428 c644428 = new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.m2504i(103994);
                if (C1855t.m3902mO(ChatroomInfoUI.this.ehq)) {
                    ChatroomInfoUI.m10599a(ChatroomInfoUI.this, c44205c2.chatroomName, list3);
                }
                List arrayList = new ArrayList();
                arrayList.addAll(list);
                arrayList.addAll(list2);
                ChatroomInfoUI.m10600a(ChatroomInfoUI.this, arrayList);
                AppMethodBeat.m2505o(103994);
            }
        };
        C30379h.m48466d(chatroomInfoUI, string4, null, string5, string6, c644428, new C642429());
        AppMethodBeat.m2505o(104072);
    }
}
