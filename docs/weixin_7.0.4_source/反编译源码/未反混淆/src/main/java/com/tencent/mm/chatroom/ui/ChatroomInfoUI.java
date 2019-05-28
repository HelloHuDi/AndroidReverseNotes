package com.tencent.mm.chatroom.ui;

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
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.chatroom.ui.preference.RoomCardPreference;
import com.tencent.mm.g.a.hj;
import com.tencent.mm.g.a.ko;
import com.tencent.mm.g.a.qh;
import com.tencent.mm.g.a.sz;
import com.tencent.mm.g.a.tv;
import com.tencent.mm.kernel.g;
import com.tencent.mm.kernel.i;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.m;
import com.tencent.mm.model.n;
import com.tencent.mm.model.r;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.report.kvdata.IMBehavior;
import com.tencent.mm.plugin.report.kvdata.IMBehaviorChattingOP;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference;
import com.tencent.mm.pluginsdk.ui.applet.j;
import com.tencent.mm.pluginsdk.ui.applet.k;
import com.tencent.mm.pluginsdk.ui.d;
import com.tencent.mm.protocal.protobuf.ayb;
import com.tencent.mm.protocal.protobuf.bts;
import com.tencent.mm.protocal.protobuf.vo;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.KeyValuePreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.NormalIconPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceCategory;
import com.tencent.mm.ui.contact.s;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.ttpic.baseutils.IOUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

@i
public class ChatroomInfoUI extends MMPreference implements f, com.tencent.mm.bg.a, com.tencent.mm.sdk.e.k.a, b {
    private static boolean eiu = false;
    private boolean cEH;
    private ProgressDialog ehJ = null;
    private com.tencent.mm.ui.base.preference.f ehK;
    private boolean ehL;
    private ad ehM;
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
    private u eih = null;
    private int eii = -1;
    private boolean eij = true;
    private boolean eik = false;
    private boolean eil = false;
    private boolean eim = false;
    private d ein = new d(new OnScrollListener() {
        public final void onScrollStateChanged(AbsListView absListView, int i) {
        }

        public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }
    });
    boolean eio = false;
    private c eip = new c<hj>() {
        {
            AppMethodBeat.i(104011);
            this.xxI = hj.class.getName().hashCode();
            AppMethodBeat.o(104011);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(104012);
            if (((hj) bVar) instanceof hj) {
                ChatroomInfoUI.k(ChatroomInfoUI.this);
            }
            AppMethodBeat.o(104012);
            return false;
        }
    };
    int eiq = -1;
    private p eir = null;
    private String eis = "";
    private String eit;
    private String eiv = null;
    private com.tencent.mm.pluginsdk.c.b eiw = new com.tencent.mm.pluginsdk.c.b() {
        public final void a(int i, int i2, String str, com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(104002);
            if (bVar instanceof ko) {
                ko koVar = (ko) bVar;
                ab.i("MicroMsg.ChatroomInfoUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
                if (ChatroomInfoUI.this.ehJ != null) {
                    ChatroomInfoUI.this.ehJ.dismiss();
                }
                if (i == 0 && i2 == 0) {
                    if (i == 0 && i2 == 0 && ChatroomInfoUI.this.ehS != null) {
                        ArrayList N = ChatroomInfoUI.N(koVar.cGv.cGh);
                        ContactListExpandPreference m = ChatroomInfoUI.this.ehS;
                        if (m.vld != null) {
                            j jVar = m.vld.vkt;
                            jVar.ah(N);
                            jVar.Kh();
                        }
                        if (ChatroomInfoUI.this.ehK != null) {
                            ChatroomInfoUI.this.ehK.notifyDataSetChanged();
                        }
                        ChatroomInfoUI.this.setMMTitle(ChatroomInfoUI.this.getResources().getQuantityString(R.plurals.z, N.size(), new Object[]{Integer.valueOf(N.size())}));
                    }
                    ChatroomInfoUI.j(ChatroomInfoUI.this);
                } else if (i2 == -21) {
                    h.a(ChatroomInfoUI.this, ChatroomInfoUI.this.getString(R.string.dsr), ChatroomInfoUI.this.getString(R.string.tz), new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.i(104001);
                            ChatroomInfoUI.this.finish();
                            AppMethodBeat.o(104001);
                        }
                    });
                    AppMethodBeat.o(104002);
                    return;
                } else {
                    h.b(ChatroomInfoUI.this, ChatroomInfoUI.this.getString(R.string.dst), ChatroomInfoUI.this.getString(R.string.tz), true);
                    AppMethodBeat.o(104002);
                    return;
                }
            }
            AppMethodBeat.o(104002);
        }
    };
    private ap eix = null;
    private int eiy = 0;
    private ak handler = new ak(Looper.getMainLooper()) {
        public final void handleMessage(Message message) {
            AppMethodBeat.i(103962);
            ChatroomInfoUI.a(ChatroomInfoUI.this);
            AppMethodBeat.o(103962);
        }
    };
    private boolean isDeleteCancel = false;

    static class a implements OnCancelListener {
        a() {
        }

        public final void onCancel(DialogInterface dialogInterface) {
            AppMethodBeat.i(104015);
            ChatroomInfoUI.eiu = true;
            AppMethodBeat.o(104015);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public ChatroomInfoUI() {
        AppMethodBeat.i(104016);
        AppMethodBeat.o(104016);
    }

    static /* synthetic */ boolean d(ChatroomInfoUI chatroomInfoUI) {
        AppMethodBeat.i(104057);
        boolean JR = chatroomInfoUI.JR();
        AppMethodBeat.o(104057);
        return JR;
    }

    static /* synthetic */ void h(ChatroomInfoUI chatroomInfoUI) {
        AppMethodBeat.i(104058);
        chatroomInfoUI.JM();
        AppMethodBeat.o(104058);
    }

    static /* synthetic */ void i(ChatroomInfoUI chatroomInfoUI) {
        AppMethodBeat.i(104059);
        chatroomInfoUI.JN();
        AppMethodBeat.o(104059);
    }

    static /* synthetic */ void j(ChatroomInfoUI chatroomInfoUI) {
        AppMethodBeat.i(104060);
        chatroomInfoUI.updateTitle();
        AppMethodBeat.o(104060);
    }

    static /* synthetic */ void k(ChatroomInfoUI chatroomInfoUI) {
        AppMethodBeat.i(104061);
        chatroomInfoUI.JB();
        AppMethodBeat.o(104061);
    }

    static /* synthetic */ void l(ChatroomInfoUI chatroomInfoUI) {
        AppMethodBeat.i(104063);
        chatroomInfoUI.JG();
        AppMethodBeat.o(104063);
    }

    static /* synthetic */ void r(ChatroomInfoUI chatroomInfoUI) {
        AppMethodBeat.i(104064);
        chatroomInfoUI.JF();
        AppMethodBeat.o(104064);
    }

    static /* synthetic */ void t(ChatroomInfoUI chatroomInfoUI) {
        AppMethodBeat.i(104066);
        chatroomInfoUI.JK();
        AppMethodBeat.o(104066);
    }

    static /* synthetic */ void y(ChatroomInfoUI chatroomInfoUI) {
        AppMethodBeat.i(104070);
        chatroomInfoUI.JQ();
        AppMethodBeat.o(104070);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(104017);
        super.onCreate(bundle);
        g.RO().eJo.a(480, (f) this);
        com.tencent.mm.pluginsdk.c.b.a(ko.class.getName(), this.eiw);
        com.tencent.mm.vending.b.b dnU = this.eip.dnU();
        Assert.assertNotNull(this);
        keep(dnU);
        g.RP().Ry().a(this);
        ((com.tencent.mm.plugin.chatroom.a.c) g.K(com.tencent.mm.plugin.chatroom.a.c.class)).XV().c(this);
        if (com.tencent.mm.bg.g.fUs != null) {
            com.tencent.mm.bg.g.fUs.a(this);
        }
        this.ehq = getIntent().getStringExtra("RoomInfo_Id");
        this.ehM = ((com.tencent.mm.plugin.messenger.foundation.a.j) g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).XM().aoO(this.ehq);
        this.eij = true;
        this.cEH = getIntent().getBooleanExtra("Is_Chatroom", true);
        this.ehL = getIntent().getBooleanExtra("Is_Lbsroom", false);
        this.eik = getIntent().getBooleanExtra("fromChatting", false);
        this.eil = getIntent().getBooleanExtra("isShowSetMuteAnimation", false);
        this.eis = getPackageName() + "_preferences";
        if (this.cEH) {
            this.eih = ((com.tencent.mm.plugin.chatroom.a.c) g.K(com.tencent.mm.plugin.chatroom.a.c.class)).XV().oa(this.ehq);
            if (this.eih != null) {
                this.eid = this.eih.aoo(r.Yz());
            }
        }
        initView();
        if (this.cEH) {
            final AnonymousClass22 anonymousClass22 = new com.tencent.mm.model.ao.b.a() {
                public final void o(final String str, boolean z) {
                    AppMethodBeat.i(103988);
                    if (z && ChatroomInfoUI.this.ehq.equals(str)) {
                        g.RS().aa(new Runnable() {
                            public final void run() {
                                AppMethodBeat.i(103986);
                                ((com.tencent.mm.plugin.chatroom.a.c) g.K(com.tencent.mm.plugin.chatroom.a.c.class)).XV().n(str, System.currentTimeMillis());
                                AppMethodBeat.o(103986);
                            }

                            public final String toString() {
                                AppMethodBeat.i(103987);
                                String str = super.toString() + "|getContactCallBack";
                                AppMethodBeat.o(103987);
                                return str;
                            }
                        });
                    }
                    AppMethodBeat.o(103988);
                }
            };
            if (this.eih == null) {
                com.tencent.mm.model.ao.a.flu.a(this.ehq, "", anonymousClass22);
                AppMethodBeat.o(104017);
                return;
            } else if (System.currentTimeMillis() - this.eih.field_modifytime >= 86400000) {
                g.RS().aa(new Runnable() {
                    public final String toString() {
                        AppMethodBeat.i(103998);
                        String str = super.toString() + "|getContactCallBack2";
                        AppMethodBeat.o(103998);
                        return str;
                    }

                    public final void run() {
                        AppMethodBeat.i(103997);
                        com.tencent.mm.model.ao.a.flu.a(ChatroomInfoUI.this.eih.field_chatroomname, "", anonymousClass22);
                        AppMethodBeat.o(103997);
                    }
                });
            }
        }
        AppMethodBeat.o(104017);
    }

    private void JB() {
        AppMethodBeat.i(104018);
        ab.i("MicroMsg.ChatroomInfoUI", "[doChatroomDetailCgi] :%s", this.ehq);
        com.tencent.mm.roomsdk.a.c.a kd = com.tencent.mm.roomsdk.a.b.alY(this.ehq).kd(this.ehq);
        kd.b(new com.tencent.mm.roomsdk.a.b.b() {
            public final /* synthetic */ void a(int i, int i2, String str, com.tencent.mm.roomsdk.a.b.a aVar) {
                AppMethodBeat.i(104010);
                if (ChatroomInfoUI.this.eih != null) {
                    ChatroomInfoUI.this.eie = ChatroomInfoUI.this.eih.afg().size();
                }
                if ((!ChatroomInfoUI.d(ChatroomInfoUI.this) && ChatroomInfoUI.this.eie >= j.MAX_COUNT) || (ChatroomInfoUI.d(ChatroomInfoUI.this) && ChatroomInfoUI.this.eie >= j.MAX_COUNT - 1)) {
                    ChatroomInfoUI.this.ehK.ce("see_room_member", false);
                    ChatroomInfoUI.this.ehP.setTitle(ChatroomInfoUI.this.getString(R.string.e14));
                }
                ChatroomInfoUI.h(ChatroomInfoUI.this);
                ChatroomInfoUI.i(ChatroomInfoUI.this);
                ChatroomInfoUI.j(ChatroomInfoUI.this);
                AppMethodBeat.o(104010);
            }
        });
        kd.dmX();
        AppMethodBeat.o(104018);
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0076  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x008a  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00c7  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onResume() {
        boolean N;
        String stringExtra;
        AppMethodBeat.i(104019);
        super.onResume();
        this.ehK.notifyDataSetChanged();
        if (this.eih != null) {
            com.tencent.mm.j.a.a.a drY = this.eih.drY();
            if (drY != null) {
                N = n.N(this.eih.field_chatroomname, drY.eoy);
                ab.i("MicroMsg.ChatroomInfoUI", "roomId:%s newVer:%s localVer:%s owner:%s", this.eih.field_chatroomname, Integer.valueOf(drY.eoy), Integer.valueOf(this.eih.field_chatroomVersion), this.eih.field_roomowner);
                if (n.mt(this.ehq) || N) {
                    JB();
                }
                JM();
                updateTitle();
                JL();
                if (this.cEH) {
                    JN();
                    JK();
                }
                if (this.eij) {
                    JJ();
                    this.eij = false;
                }
                stringExtra = getIntent().getStringExtra("need_matte_high_light_item");
                if (!this.eio) {
                    if (!bo.isNullOrNil(stringExtra)) {
                        kf(stringExtra);
                    }
                    this.eio = true;
                }
                if (!(bo.isNullOrNil(stringExtra) || !stringExtra.equals("room_notify_new_notice") || this.eio)) {
                    kf("room_card");
                    this.eio = true;
                }
                ab.d("MicroMsg.ChatroomInfoUI", "showSetMuteAnimation isShowSetMuteAnimation[%b]", Boolean.valueOf(this.eil));
                if (this.eil) {
                    this.eil = false;
                    al.n(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(104007);
                            ChatroomInfoUI.c(ChatroomInfoUI.this, "room_notify_new_msg");
                            ChatroomInfoUI.this.eim = true;
                            AppMethodBeat.o(104007);
                        }
                    }, 50);
                }
                AppMethodBeat.o(104019);
            }
        }
        N = false;
        JB();
        JM();
        updateTitle();
        JL();
        if (this.cEH) {
        }
        if (this.eij) {
        }
        stringExtra = getIntent().getStringExtra("need_matte_high_light_item");
        if (this.eio) {
        }
        kf("room_card");
        this.eio = true;
        ab.d("MicroMsg.ChatroomInfoUI", "showSetMuteAnimation isShowSetMuteAnimation[%b]", Boolean.valueOf(this.eil));
        if (this.eil) {
        }
        AppMethodBeat.o(104019);
    }

    public void onConfigurationChanged(Configuration configuration) {
        AppMethodBeat.i(104020);
        super.onConfigurationChanged(configuration);
        this.ehS.notifyChanged();
        AppMethodBeat.o(104020);
    }

    private void kf(String str) {
        AppMethodBeat.i(104021);
        final int aqQ = this.ehK.aqQ(str);
        this.nDp.smoothScrollToPosition(aqQ);
        new ak().postDelayed(new Runnable() {
            public final void run() {
                AppMethodBeat.i(104013);
                View a = ((com.tencent.mm.ui.base.preference.a) ChatroomInfoUI.this.ehK).a(aqQ, ChatroomInfoUI.this.nDp);
                if (a != null) {
                    com.tencent.mm.ui.g.a.a(ChatroomInfoUI.this.mController.ylL, a);
                }
                AppMethodBeat.o(104013);
            }
        }, 10);
        AppMethodBeat.o(104021);
    }

    public void onPause() {
        AppMethodBeat.i(104022);
        super.onPause();
        if (this.eig && this.cEH) {
            if (this.eih == null) {
                AppMethodBeat.o(104022);
                return;
            }
            n.a(this.ehq, this.eih, this.eia);
        }
        AppMethodBeat.o(104022);
    }

    /* JADX WARNING: Missing block: B:2:0x000e, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.o(104024);
     */
    /* JADX WARNING: Missing block: B:33:0x0146, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.o(104024);
     */
    /* JADX WARNING: Missing block: B:34:?, code skipped:
            return;
     */
    /* JADX WARNING: Missing block: B:44:?, code skipped:
            return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(104024);
        super.onActivityResult(i, i2, intent);
        String stringExtra;
        switch (i) {
            case 1:
                if (intent == null) {
                    AppMethodBeat.o(104024);
                    return;
                }
                final String stringExtra2 = intent.getStringExtra("Select_Contact");
                u oa = ((com.tencent.mm.plugin.chatroom.a.c) g.K(com.tencent.mm.plugin.chatroom.a.c.class)).XV().oa(this.ehq);
                if (oa != null) {
                    int drV = oa.drV();
                    if ((drV == 2 || drV == 1) && !JR()) {
                        com.tencent.mm.ui.widget.a.e.a asL = new com.tencent.mm.ui.widget.a.e.a(this).asL(getString(R.string.dqy));
                        asL.zQJ = getString(R.string.tf);
                        asL = asL.re(true).m(Boolean.TRUE);
                        asL.zQK = getString(R.string.or);
                        asL.asN(getString(R.string.dip)).c(new e.c() {
                            public final void d(boolean z, String str) {
                                AppMethodBeat.i(104014);
                                if (z) {
                                    ChatroomInfoUI.a(ChatroomInfoUI.this, stringExtra2, str);
                                }
                                AppMethodBeat.o(104014);
                            }
                        }).show();
                        AppMethodBeat.o(104024);
                        return;
                    }
                    b(stringExtra2, null, R.string.db);
                    AppMethodBeat.o(104024);
                    return;
                }
                break;
            case 2:
                if (i2 == -1) {
                    finish();
                    AppMethodBeat.o(104024);
                    return;
                }
                break;
            case 4:
                if (i2 == -1) {
                    stringExtra = intent.getStringExtra("room_name");
                    if (!bo.isNullOrNil(stringExtra)) {
                        com.tencent.mm.sdk.b.a.xxA.m(new tv());
                        this.ehM.iB(stringExtra);
                        ((com.tencent.mm.plugin.messenger.foundation.a.j) g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).XM().Y(this.ehM);
                        JN();
                    }
                    AppMethodBeat.o(104024);
                    return;
                }
                break;
            case 5:
                if (i2 == 0) {
                    this.eiq = -1;
                    AppMethodBeat.o(104024);
                    return;
                }
                break;
            case 6:
                if (i2 == -1) {
                    JM();
                    break;
                }
                break;
            case 7:
                if (intent == null) {
                    AppMethodBeat.o(104024);
                    return;
                }
                stringExtra = intent.getStringExtra("Select_Contact");
                if (stringExtra == null || stringExtra.equals("")) {
                    AppMethodBeat.o(104024);
                    return;
                }
                final com.tencent.mm.roomsdk.a.c.a a = com.tencent.mm.roomsdk.a.b.alY(this.ehq).a(this.ehq, bo.P(stringExtra.split(",")), 0);
                a.b(new com.tencent.mm.roomsdk.a.b.b() {
                    public final /* synthetic */ void a(int i, int i2, String str, com.tencent.mm.roomsdk.a.b.a aVar) {
                        AppMethodBeat.i(103983);
                        ChatroomInfoUI.y(ChatroomInfoUI.this);
                        ChatroomInfoUI.z(ChatroomInfoUI.this);
                        AppMethodBeat.o(103983);
                    }
                });
                a.c(new com.tencent.mm.roomsdk.a.b.b() {
                    public final /* synthetic */ void a(int i, int i2, String str, com.tencent.mm.roomsdk.a.b.a aVar) {
                        AppMethodBeat.i(103984);
                        com.tencent.mm.h.a jY = com.tencent.mm.h.a.jY(str);
                        if (jY != null) {
                            jY.a(ChatroomInfoUI.this, null, null);
                            AppMethodBeat.o(103984);
                            return;
                        }
                        if (i2 == -66) {
                            h.b(ChatroomInfoUI.this, ChatroomInfoUI.this.getString(R.string.b50), ChatroomInfoUI.this.getString(R.string.tz), true);
                        } else {
                            h.b(ChatroomInfoUI.this, bo.bc(str, ChatroomInfoUI.this.getString(R.string.b51)), ChatroomInfoUI.this.getString(R.string.tz), true);
                        }
                        ChatroomInfoUI.y(ChatroomInfoUI.this);
                        ChatroomInfoUI.z(ChatroomInfoUI.this);
                        ab.i("MicroMsg.ActionCallbackFunc", "[delChatroomMember] onResult errType:%s errCode:%s", Integer.valueOf(i), Integer.valueOf(i2));
                        AppMethodBeat.o(103984);
                    }
                });
                getString(R.string.tz);
                a.a(this, getString(R.string.drx), true, new OnCancelListener() {
                    public final void onCancel(DialogInterface dialogInterface) {
                        AppMethodBeat.i(103985);
                        a.cancel();
                        AppMethodBeat.o(103985);
                    }
                });
                AppMethodBeat.o(104024);
                return;
        }
    }

    public final int JC() {
        return R.xml.bf;
    }

    private String JD() {
        if (this.eih == null) {
            return "";
        }
        return this.eih.field_selfDisplayName;
    }

    private void bB(boolean z) {
        AppMethodBeat.i(104027);
        bf.a(this.ehq, new com.tencent.mm.model.bf.a() {
            public final boolean JU() {
                AppMethodBeat.i(103981);
                boolean w = ChatroomInfoUI.this.isDeleteCancel;
                AppMethodBeat.o(103981);
                return w;
            }

            public final void JV() {
                AppMethodBeat.i(103982);
                if (ChatroomInfoUI.this.ehJ != null) {
                    ChatroomInfoUI.this.ehJ.dismiss();
                }
                AppMethodBeat.o(103982);
            }
        });
        ((com.tencent.mm.plugin.messenger.foundation.a.j) g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).XL().c(new com.tencent.mm.chatroom.e.a(this.ehq));
        ((com.tencent.mm.plugin.messenger.foundation.a.j) g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).XR().aoX(this.ehq);
        com.tencent.mm.roomsdk.a.b.alY(this.ehq).ke(this.ehq).dmX();
        n.mw(this.ehq);
        if (!z) {
            this.handler.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(104004);
                    ((com.tencent.mm.plugin.zero.b.b) g.K(com.tencent.mm.plugin.zero.b.b.class)).ahW().lN(7);
                    AppMethodBeat.o(104004);
                }
            });
        }
        Intent intent = new Intent();
        intent.addFlags(67108864);
        intent.setComponent(new ComponentName(getPackageName(), ah.doz() + ".ui.LauncherUI"));
        startActivity(intent);
        finish();
        AppMethodBeat.o(104027);
    }

    private void JE() {
        AppMethodBeat.i(104028);
        com.tencent.mm.plugin.report.service.h.pYm.a(219, 7, 1, true);
        List my = n.my(this.ehq);
        String c = bo.c(my, ",");
        if (my != null) {
            this.eie = my.size();
        }
        Intent intent = new Intent();
        intent.putExtra("titile", getString(R.string.eu));
        intent.putExtra("list_type", 1);
        intent.putExtra("list_attr", iz(s.znF));
        intent.putExtra("always_select_contact", c);
        intent.putExtra("scene", 3);
        if (!ad.aoy(this.ehM.field_username)) {
            intent.putExtra("without_openim", true);
        }
        intent.putExtra("KBlockOpenImFav", t.mO(this.ehq));
        com.tencent.mm.bp.d.b((Context) this, ".ui.contact.SelectContactUI", intent, 1);
        AppMethodBeat.o(104028);
    }

    private void JF() {
        AppMethodBeat.i(104029);
        if (this.cEH) {
            JE();
            AppMethodBeat.o(104029);
            return;
        }
        JP();
        AppMethodBeat.o(104029);
    }

    private int iz(int i) {
        AppMethodBeat.i(104030);
        if (!s.dIh()) {
            AppMethodBeat.o(104030);
            return i;
        } else if (this.ehM != null) {
            String str = this.ehM.field_username;
            if (ad.aox(str) || ad.aoy(str)) {
                i |= 16777216;
                AppMethodBeat.o(104030);
                return i;
            }
            i &= -16777217;
            AppMethodBeat.o(104030);
            return i;
        } else {
            AppMethodBeat.o(104030);
            return i;
        }
    }

    private void JG() {
        AppMethodBeat.i(104031);
        com.tencent.mm.plugin.report.service.h.pYm.a(219, 8, 1, true);
        List my = n.my(this.ehq);
        String c = bo.c(my, ",");
        this.eie = my.size();
        Intent intent = new Intent();
        intent.putExtra("RoomInfo_Id", this.ehq);
        intent.putExtra("Is_Chatroom", true);
        intent.putExtra("Chatroom_member_list", c);
        intent.putExtra("room_member_count", this.eie);
        intent.putExtra("Is_RoomOwner", this.eic);
        intent.putExtra("list_attr", s.znF);
        intent.putExtra("room_name", this.ehM.field_username);
        intent.putExtra("room_owner_name", this.eih.field_roomowner);
        intent.setClass(this, SelectDelMemberUI.class);
        startActivityForResult(intent, 7);
        AppMethodBeat.o(104031);
    }

    private void b(String str, String str2, int i) {
        AppMethodBeat.i(104032);
        if (t.mO(this.ehq) && !m.mo(str)) {
            h.b((Context) this, getString(R.string.dt9), getString(R.string.tz), true);
            AppMethodBeat.o(104032);
        } else if (kh(str)) {
            h.b((Context) this, getString(R.string.cy), getString(R.string.tz), true);
            AppMethodBeat.o(104032);
        } else {
            List P = bo.P(str.split(","));
            if (P == null) {
                AppMethodBeat.o(104032);
                return;
            }
            final com.tencent.mm.roomsdk.a.c.a a = com.tencent.mm.roomsdk.a.b.alY(this.ehq).a(this.ehq, P, str2);
            a.d(new com.tencent.mm.roomsdk.a.b.c() {
                public final /* synthetic */ void a(int i, int i2, String str, com.tencent.mm.roomsdk.a.b.a aVar) {
                    AppMethodBeat.i(103989);
                    com.tencent.mm.roomsdk.a.b.c cVar = (com.tencent.mm.roomsdk.a.b.c) aVar;
                    com.tencent.mm.h.a jY = com.tencent.mm.h.a.jY(str);
                    if (jY != null) {
                        jY.a(ChatroomInfoUI.this, null, null);
                        AppMethodBeat.o(103989);
                    } else if (i == 0 && i2 == 0) {
                        if (i == 0 && i2 == 0) {
                            ChatroomInfoUI.a(ChatroomInfoUI.this, i2, cVar, str);
                            ChatroomInfoUI.y(ChatroomInfoUI.this);
                        }
                        ChatroomInfoUI.z(ChatroomInfoUI.this);
                        AppMethodBeat.o(103989);
                    } else {
                        ChatroomInfoUI.a(ChatroomInfoUI.this, i2, cVar, str);
                        ChatroomInfoUI.y(ChatroomInfoUI.this);
                        AppMethodBeat.o(103989);
                    }
                }
            });
            getString(R.string.tz);
            a.a(this, getString(i), true, new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                    AppMethodBeat.i(103990);
                    a.cancel();
                    AppMethodBeat.o(103990);
                }
            });
            AppMethodBeat.o(104032);
        }
    }

    private String kg(String str) {
        AppMethodBeat.i(104033);
        if (this.eih == null) {
            AppMethodBeat.o(104033);
            return null;
        }
        String mJ = this.eih.mJ(str);
        AppMethodBeat.o(104033);
        return mJ;
    }

    private String JH() {
        String str;
        AppMethodBeat.i(104034);
        ad aoO = ((com.tencent.mm.plugin.messenger.foundation.a.j) g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).XM().aoO(this.eih.field_roomowner);
        if (aoO == null || ((int) aoO.ewQ) <= 0) {
            str = null;
        } else {
            str = aoO.field_conRemark;
        }
        if (bo.isNullOrNil(str)) {
            str = kg(this.eih.field_roomowner);
        }
        if (bo.isNullOrNil(str) && aoO != null && ((int) aoO.ewQ) > 0) {
            str = aoO.Oi();
        }
        if (bo.isNullOrNil(str)) {
            str = this.eih.field_roomowner;
        }
        AppMethodBeat.o(104034);
        return str;
    }

    private static boolean JI() {
        AppMethodBeat.i(104035);
        if (bo.getInt(com.tencent.mm.m.g.Nu().getValue("ChatroomGlobalSwitch"), 1) == 1) {
            AppMethodBeat.o(104035);
            return true;
        }
        AppMethodBeat.o(104035);
        return false;
    }

    private void by(Context context) {
        AppMethodBeat.i(104036);
        if (context == null) {
            AppMethodBeat.o(104036);
            return;
        }
        if (JI()) {
            Intent intent = new Intent();
            intent.putExtra("rawUrl", getString(R.string.ajo, new Object[]{aa.dor()}));
            intent.putExtra("geta8key_username", r.Yz());
            intent.putExtra("showShare", false);
            com.tencent.mm.bp.d.b((Context) this, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
        }
        AppMethodBeat.o(104036);
    }

    private void d(String str, List<String> list) {
        AppMethodBeat.i(104037);
        if (list != null && list.size() > 0) {
            LinkedList linkedList = new LinkedList();
            for (int i = 0; i < list.size(); i++) {
                linkedList.add(list.get(i));
            }
            m.a(str, linkedList, getString(R.string.ajv), true, "weixin://findfriend/verifycontact/" + str + "/");
        }
        AppMethodBeat.o(104037);
    }

    private void updateTitle() {
        AppMethodBeat.i(104038);
        if (this.cEH) {
            this.eie = n.mA(this.ehq);
            if (this.eie == 0) {
                setMMTitle(getString(R.string.dvi));
                AppMethodBeat.o(104038);
                return;
            }
            setMMTitle(getString(R.string.bwu, new Object[]{getString(R.string.dvi), Integer.valueOf(this.eie)}));
        }
        AppMethodBeat.o(104038);
    }

    private void JJ() {
        AppMethodBeat.i(104039);
        if (this.ehS != null) {
            if (this.cEH) {
                g.RS().aa(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(104000);
                        if (ChatroomInfoUI.this.eih == null) {
                            ab.w("MicroMsg.ChatroomInfoUI", "[updateRoomPref] member == null");
                            AppMethodBeat.o(104000);
                            return;
                        }
                        List list;
                        String str;
                        ChatroomInfoUI.this.eiv = ((com.tencent.mm.plugin.chatroom.a.c) g.K(com.tencent.mm.plugin.chatroom.a.c.class)).XV().od(ChatroomInfoUI.this.ehq);
                        List my = n.my(ChatroomInfoUI.this.ehq);
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
                        if (ChatroomInfoUI.this.eie > j.MAX_COUNT + 1 && r1 != null) {
                            list2 = r1.subList(0, j.MAX_COUNT + 1);
                            Iterator it = linkedList2.iterator();
                            while (it.hasNext()) {
                                str2 = (String) it.next();
                                if (!list2.contains(str2)) {
                                    list2.add(0, str2);
                                }
                            }
                        }
                        al.d(new Runnable() {
                            public final void run() {
                                AppMethodBeat.i(103999);
                                if (ChatroomInfoUI.this.eie <= 1) {
                                    ChatroomInfoUI.this.ehK.ce("del_selector_btn", true);
                                    ChatroomInfoUI.this.ehS.oD(true).oE(false).djG();
                                } else {
                                    ChatroomInfoUI.this.ehS.oD(true).oE(ChatroomInfoUI.d(ChatroomInfoUI.this)).djG();
                                }
                                ChatroomInfoUI.this.ehS.u(ChatroomInfoUI.this.ehq, list2);
                                AppMethodBeat.o(103999);
                            }
                        });
                        AppMethodBeat.o(104000);
                    }
                });
                AppMethodBeat.o(104039);
                return;
            }
            LinkedList linkedList = new LinkedList();
            linkedList.add(this.ehq);
            this.ehS.u(this.ehq, linkedList);
        }
        AppMethodBeat.o(104039);
    }

    private void JK() {
        AppMethodBeat.i(104040);
        if (this.ehM != null) {
            CharSequence JD = JD();
            if (bo.isNullOrNil(JD)) {
                JD = r.YB();
            }
            if (bo.isNullOrNil(JD)) {
                this.ehW.setSummary((CharSequence) "");
            } else {
                this.ehW.dAB();
                this.ehW.yCt = com.tencent.mm.bz.a.al(this.mController.ylL, R.dimen.nv);
                KeyValuePreference keyValuePreference = this.ehW;
                if (JD.length() <= 0) {
                    JD = getString(R.string.eal);
                }
                keyValuePreference.setSummary((CharSequence) com.tencent.mm.pluginsdk.ui.e.j.b((Context) this, JD));
            }
            if (this.ehK != null) {
                this.ehK.notifyDataSetChanged();
            }
        }
        AppMethodBeat.o(104040);
    }

    private void JL() {
        AppMethodBeat.i(104041);
        if (this.ehZ == null) {
            this.ehZ = getSharedPreferences(getPackageName() + "_preferences", 0);
        }
        if (this.cEH) {
            this.eif = this.ehM.dua == 0;
        } else if (!this.ehL) {
            this.eif = this.ehM.DX();
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
        AppMethodBeat.o(104041);
    }

    private void JM() {
        AppMethodBeat.i(104042);
        if (!(this.ehM == null || this.ehN == null)) {
            CharSequence mC = n.mC(this.ehq);
            if (mC == null || mC.length() <= 0) {
                this.ehN.cui = false;
            } else {
                this.ehN.cui = true;
                this.ehN.eok = com.tencent.mm.pluginsdk.ui.e.j.b((Context) this, mC);
            }
            this.ehM = ((com.tencent.mm.plugin.messenger.foundation.a.j) g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).XM().aoO(this.ehq);
            if (JO()) {
                mC = this.ehM.Oj();
                RoomCardPreference roomCardPreference = this.ehN;
                if (mC.length() <= 0) {
                    mC = getString(R.string.eal);
                }
                roomCardPreference.eoj = com.tencent.mm.pluginsdk.ui.e.j.b((Context) this, mC);
            } else {
                this.ehN.eoj = getString(R.string.dsn);
            }
            this.ehK.notifyDataSetChanged();
        }
        AppMethodBeat.o(104042);
    }

    private void JN() {
        AppMethodBeat.i(104043);
        if (!(this.ehM == null || this.ehO == null)) {
            this.ehM = ((com.tencent.mm.plugin.messenger.foundation.a.j) g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).XM().aoO(this.ehq);
            if (JO()) {
                CharSequence Oj = this.ehM.Oj();
                Preference preference = this.ehO;
                if (Oj.length() <= 0) {
                    Oj = getString(R.string.eal);
                }
                preference.setSummary(com.tencent.mm.pluginsdk.ui.e.j.b((Context) this, Oj));
                if (this.ehK != null) {
                    this.ehK.notifyDataSetChanged();
                }
                AppMethodBeat.o(104043);
                return;
            }
            this.ehO.setSummary(getString(R.string.dsn));
        }
        AppMethodBeat.o(104043);
    }

    private boolean JO() {
        AppMethodBeat.i(104044);
        String str = this.ehM.field_nickname;
        if (bo.isNullOrNil(str) || str.length() > 50) {
            AppMethodBeat.o(104044);
            return false;
        }
        AppMethodBeat.o(104044);
        return true;
    }

    public static ArrayList<ad> N(List<ayb> list) {
        AppMethodBeat.i(104045);
        ArrayList<ad> arrayList = new ArrayList();
        if (list == null) {
            AppMethodBeat.o(104045);
            return arrayList;
        }
        for (ayb ayb : list) {
            ad adVar = new ad();
            adVar.setUsername(ayb.jBB);
            adVar.iB(ayb.jCH);
            arrayList.add(adVar);
        }
        AppMethodBeat.o(104045);
        return arrayList;
    }

    private void JP() {
        AppMethodBeat.i(104046);
        com.tencent.mm.plugin.report.service.h.pYm.X(10170, "1");
        List linkedList = new LinkedList();
        linkedList.add(this.ehq);
        linkedList.add(r.Yz());
        String c = bo.c(linkedList, ",");
        Intent intent = new Intent();
        intent.putExtra("titile", getString(R.string.es));
        intent.putExtra("list_type", 0);
        intent.putExtra("list_attr", iz(s.znG));
        intent.putExtra("always_select_contact", c);
        com.tencent.mm.bp.d.f(this, ".ui.contact.SelectContactUI", intent);
        AppMethodBeat.o(104046);
    }

    private boolean kh(String str) {
        boolean z = false;
        AppMethodBeat.i(104047);
        if (bo.nullAsNil(r.Yz()).equals(str)) {
            AppMethodBeat.o(104047);
            return true;
        }
        List my = n.my(this.ehq);
        if (my == null) {
            AppMethodBeat.o(104047);
            return false;
        }
        Iterator it = my.iterator();
        while (true) {
            boolean z2 = z;
            if (!it.hasNext()) {
                AppMethodBeat.o(104047);
                return z2;
            } else if (((String) it.next()).equals(str)) {
                z = true;
            } else {
                z = z2;
            }
        }
    }

    private static List<String> O(List<String> list) {
        AppMethodBeat.i(104048);
        LinkedList linkedList = new LinkedList();
        if (!g.RK()) {
            AppMethodBeat.o(104048);
            return linkedList;
        } else if (list == null) {
            AppMethodBeat.o(104048);
            return linkedList;
        } else {
            for (Object obj : list) {
                Object obj2;
                ad aoO = ((com.tencent.mm.plugin.messenger.foundation.a.j) g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).XM().aoO(obj2);
                if (!(aoO == null || ((int) aoO.ewQ) == 0)) {
                    obj2 = aoO.Oj();
                }
                linkedList.add(obj2);
            }
            AppMethodBeat.o(104048);
            return linkedList;
        }
    }

    public void onSceneEnd(int i, int i2, String str, com.tencent.mm.ai.m mVar) {
        AppMethodBeat.i(104049);
        ab.i("MicroMsg.ChatroomInfoUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        ab.d("MicroMsg.ChatroomInfoUI", "pre is " + this.eie);
        this.eie = n.mA(this.ehq);
        ab.d("MicroMsg.ChatroomInfoUI", "now is " + this.eie);
        if (this.ehJ != null) {
            this.ehJ.dismiss();
        }
        AppMethodBeat.o(104049);
    }

    private void JQ() {
        AppMethodBeat.i(104050);
        if (this.ehS != null) {
            if (this.cEH) {
                JJ();
            } else if (!this.ehL) {
                LinkedList linkedList = new LinkedList();
                linkedList.add(this.ehq);
                this.ehS.u(this.ehq, linkedList);
            }
            this.ehS.notifyChanged();
        }
        boolean HH = ((com.tencent.mm.plugin.chatroom.a.c) g.K(com.tencent.mm.plugin.chatroom.a.c.class)).HH(this.ehq);
        if (JR()) {
            this.ehK.ce("room_manager_view", true);
            if (n.mA(this.ehq) > 2) {
                this.ehK.ce("manage_room", false);
            } else {
                this.ehK.ce("manage_room", true);
            }
        } else {
            this.ehK.ce("manage_room", true);
            com.tencent.mm.ui.base.preference.f fVar = this.ehK;
            String str = "room_manager_view";
            if (HH) {
                HH = false;
            } else {
                HH = true;
            }
            fVar.ce(str, HH);
        }
        if ((JR() || this.eie < j.MAX_COUNT) && (!JR() || this.eie < j.MAX_COUNT - 1)) {
            this.ehK.ce("see_room_member", true);
        } else {
            this.ehK.ce("see_room_member", false);
            this.ehP.setTitle(getString(R.string.e14));
        }
        if (t.mP(this.ehq)) {
            if (JR()) {
                this.ehK.ce("manage_room", false);
            } else {
                this.ehK.ce("manage_room", true);
            }
            this.ehK.ce("room_manager_view", true);
        }
        this.ehK.notifyDataSetChanged();
        AppMethodBeat.o(104050);
    }

    public final void a(int i, com.tencent.mm.sdk.e.n nVar, Object obj) {
        AppMethodBeat.i(104051);
        if (obj == null || !(obj instanceof String)) {
            ab.d("MicroMsg.ChatroomInfoUI", "onNotifyChange obj not String event:%d stg:%s obj:%s", Integer.valueOf(i), nVar, obj);
            AppMethodBeat.o(104051);
            return;
        }
        a((String) obj, null);
        AppMethodBeat.o(104051);
    }

    public final void a(String str, com.tencent.mm.sdk.e.m mVar) {
        AppMethodBeat.i(104052);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(104052);
        } else if (t.kH(str)) {
            ab.d("MicroMsg.ChatroomInfoUI", "event:".concat(String.valueOf(str)));
            if (this.cEH && str.equals(this.ehq)) {
                g.RS().aa(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(104005);
                        ChatroomInfoUI.this.eih = ((com.tencent.mm.plugin.chatroom.a.c) g.K(com.tencent.mm.plugin.chatroom.a.c.class)).XV().oa(ChatroomInfoUI.this.ehq);
                        if (ChatroomInfoUI.this.eih == null) {
                            ab.e("MicroMsg.ChatroomInfoUI", "member is null");
                            AppMethodBeat.o(104005);
                        } else if (bo.isNullOrNil(ChatroomInfoUI.this.eih.field_roomowner)) {
                            ab.e("MicroMsg.ChatroomInfoUI", "roomowner is null");
                            AppMethodBeat.o(104005);
                        } else {
                            ChatroomInfoUI.this.handler.sendEmptyMessage(0);
                            ChatroomInfoUI.this.eic = ChatroomInfoUI.this.eih.field_roomowner.equals(r.Yz());
                            ChatroomInfoUI.this.eid = ChatroomInfoUI.this.eih.aoo(r.Yz());
                            ChatroomInfoUI.this.ehS.ajF(ChatroomInfoUI.this.eih.field_roomowner);
                            AppMethodBeat.o(104005);
                        }
                    }

                    public final String toString() {
                        AppMethodBeat.i(104006);
                        String str = super.toString() + "|onNotifyChange";
                        AppMethodBeat.o(104006);
                        return str;
                    }
                });
            }
            JQ();
            AppMethodBeat.o(104052);
        } else {
            ab.d("MicroMsg.ChatroomInfoUI", "event:" + str + " cancel");
            AppMethodBeat.o(104052);
        }
    }

    public final void k(String str, String str2, String str3) {
        AppMethodBeat.i(104053);
        if (str.equals(this.ehq) && this.ehS != null) {
            this.ehS.notifyChanged();
        }
        AppMethodBeat.o(104053);
    }

    public final com.tencent.mm.ui.base.preference.h a(SharedPreferences sharedPreferences) {
        AppMethodBeat.i(104054);
        com.tencent.mm.ui.base.preference.a aVar = new com.tencent.mm.ui.base.preference.a(this, this.nDp, sharedPreferences);
        AppMethodBeat.o(104054);
        return aVar;
    }

    private boolean JR() {
        AppMethodBeat.i(104055);
        if (this.eih == null || !this.eih.JR()) {
            AppMethodBeat.o(104055);
            return false;
        }
        AppMethodBeat.o(104055);
        return true;
    }

    public void onDestroy() {
        AppMethodBeat.i(104023);
        if (com.tencent.mm.bg.g.fUs != null) {
            com.tencent.mm.bg.g.fUs.a(this);
        }
        g.RP().Ry().b(this);
        com.tencent.mm.ui.g.a.dismiss();
        g.RO().eJo.b(480, (f) this);
        com.tencent.mm.sdk.b.a.xxA.d(this.eip);
        com.tencent.mm.pluginsdk.c.b.b(ko.class.getName(), this.eiw);
        if (g.RK()) {
            ((com.tencent.mm.plugin.messenger.foundation.a.j) g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).XM().b(this);
            ((com.tencent.mm.plugin.chatroom.a.c) g.K(com.tencent.mm.plugin.chatroom.a.c.class)).XV().d(this);
        }
        if (com.tencent.mm.bg.g.fUs != null) {
            com.tencent.mm.bg.g.fUs.b(this);
        }
        if (this.eix != null) {
            this.eix.stopTimer();
        }
        super.onDestroy();
        AppMethodBeat.o(104023);
    }

    /* JADX WARNING: Removed duplicated region for block: B:57:0x0283  */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x0423  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x02b5  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void initView() {
        AppMethodBeat.i(104025);
        this.ehK = this.yCw;
        String str;
        if (this.cEH) {
            u oa;
            if (this.eie == 0) {
                setMMTitle(getString(R.string.dvi));
            } else {
                if (this.eih != null) {
                    this.eie = this.eih.afg().size();
                }
                setMMTitle(getString(R.string.bwu, new Object[]{getString(R.string.dvi), Integer.valueOf(this.eie)}));
            }
            str = null;
            if (this.eih != null) {
                str = this.eih.field_roomowner;
                this.eie = this.eih.afg().size();
            }
            if (bo.isNullOrNil(str)) {
                this.eib = false;
                this.eic = false;
                this.eid = false;
            } else {
                this.eib = true;
                this.eic = str.equals(r.Yz());
            }
            ab.d("MicroMsg.ChatroomInfoUI", "initBaseChatRoomView()");
            this.ehS = (ContactListExpandPreference) this.ehK.aqO("roominfo_contact_anchor");
            this.ehS.a(this.ehK, this.ehS.mKey);
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
            this.ehS.oD(true).oE(true).djG();
            boolean HH = ((com.tencent.mm.plugin.chatroom.a.c) g.K(com.tencent.mm.plugin.chatroom.a.c.class)).HH(this.ehq);
            if (JR()) {
                this.ehK.ce("room_manager_view", true);
                if (n.mA(this.ehq) > 2) {
                    this.ehK.ce("manage_room", false);
                } else {
                    this.ehK.ce("manage_room", true);
                }
            } else {
                this.ehK.ce("manage_room", true);
                com.tencent.mm.ui.base.preference.f fVar = this.ehK;
                String str2 = "room_manager_view";
                if (HH) {
                    HH = false;
                } else {
                    HH = true;
                }
                fVar.ce(str2, HH);
            }
            if (t.mP(this.ehq)) {
                if (JR()) {
                    this.ehK.ce("manage_room", false);
                } else {
                    this.ehK.ce("manage_room", true);
                }
            }
            if (this.eih != null) {
                this.ehS.ajF(this.eih.field_roomowner);
                if (!bo.isNullOrNil(this.eih.field_roomowner)) {
                    this.ehS.vld.vkt.vkT = true;
                }
            }
            this.ehS.djF();
            this.ehS.djz();
            this.ehK.ce("add_selector_btn", true);
            this.ehK.ce("del_selector_btn", true);
            this.ehK.ce("room_name", false);
            this.ehK.ce("room_qr_code", false);
            this.ehK.ce("chatroom_info_chexboxes", true);
            this.ehK.ce("room_card", false);
            this.ehK.ce("room_upgrade_entry", true);
            this.ehK.ce("chat_room_story_videos", true);
            if ((JR() || this.eie < j.MAX_COUNT) && (!JR() || this.eie < j.MAX_COUNT - 1)) {
                this.ehK.ce("see_room_member", true);
            } else {
                this.ehK.ce("see_room_member", false);
                this.ehP.setTitle(getString(R.string.e14));
            }
            if (ad.aoy(this.ehq)) {
                this.ehK.ce("chatroom_bottom_pc", true);
                this.ehK.ce("room_openim_about", false);
                str = getString(R.string.dtr);
                String string = getString(R.string.dts);
                int lastIndexOf = str.lastIndexOf(string);
                if (lastIndexOf >= 0) {
                    int length = string.length() + lastIndexOf;
                    CharSequence spannableStringBuilder = new SpannableStringBuilder(str);
                    spannableStringBuilder.setSpan(new com.tencent.mm.plugin.messenger.a.a() {
                        public final void onClickImp(View view) {
                            AppMethodBeat.i(103968);
                            Intent intent = new Intent();
                            intent.setFlags(268435456);
                            intent.setClassName(ah.getContext(), "com.tencent.mm.plugin.webview.ui.tools.WebViewUI");
                            intent.putExtra("rawUrl", "https://weixin.qq.com/cgi-bin/newreadtemplate?t=work_wechat/about_group");
                            ah.getContext().startActivity(intent);
                            AppMethodBeat.o(103968);
                        }
                    }, lastIndexOf, length, 18);
                    this.ehK.aqO("room_openim_about").setTitle(spannableStringBuilder);
                }
            } else {
                this.ehK.ce("room_openim_about", true);
            }
            ab.d("MicroMsg.ChatroomInfoUI", "updatePlaceTop()");
            if (this.ehZ == null) {
                this.ehZ = getSharedPreferences(getPackageName() + "_preferences", 0);
            }
            if (this.ehV != null) {
                if (this.ehM != null) {
                    this.ehZ.edit().putBoolean("room_placed_to_the_top", ((com.tencent.mm.plugin.messenger.foundation.a.j) g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).XR().aph(this.ehM.field_username)).commit();
                } else {
                    this.ehZ.edit().putBoolean("room_placed_to_the_top", false).commit();
                }
            }
            this.ehK.notifyDataSetChanged();
            ab.d("MicroMsg.ChatroomInfoUI", "updateSaveToContact()");
            if (this.ehZ == null) {
                this.ehZ = getSharedPreferences(getPackageName() + "_preferences", 0);
            }
            if (this.ehU != null) {
                ad aoO = ((com.tencent.mm.plugin.messenger.foundation.a.j) g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).XM().aoO(this.ehq);
                if (aoO == null) {
                    ab.e("MicroMsg.ChatroomInfoUI", "contact == null !!!");
                    ab.d("MicroMsg.ChatroomInfoUI", "updateDisplayNickname()");
                    if (this.ehZ == null) {
                        this.ehZ = getSharedPreferences(getPackageName() + "_preferences", 0);
                    }
                    oa = ((com.tencent.mm.plugin.chatroom.a.c) g.K(com.tencent.mm.plugin.chatroom.a.c.class)).XV().oa(this.ehq);
                    if (oa != null) {
                        ab.e("MicroMsg.ChatroomInfoUI", "members == null !!!");
                    } else {
                        this.eia = oa.drX();
                        this.ehX = (CheckBoxPreference) this.ehK.aqO("room_msg_show_username");
                        if (this.ehX != null) {
                            this.ehZ.edit().putBoolean("room_msg_show_username", this.eia).commit();
                        }
                        this.ehK.notifyDataSetChanged();
                    }
                    this.eii = ((com.tencent.mm.plugin.messenger.foundation.a.j) g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bOr().Rq(this.ehq);
                    this.eii = ((com.tencent.mm.plugin.messenger.foundation.a.j) g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bOr().Rq(this.ehq);
                } else {
                    this.ehZ.edit().putBoolean("room_save_to_contact", com.tencent.mm.n.a.jh(aoO.field_type)).commit();
                }
            }
            this.ehK.notifyDataSetChanged();
            ab.d("MicroMsg.ChatroomInfoUI", "updateDisplayNickname()");
            if (this.ehZ == null) {
            }
            oa = ((com.tencent.mm.plugin.chatroom.a.c) g.K(com.tencent.mm.plugin.chatroom.a.c.class)).XV().oa(this.ehq);
            if (oa != null) {
            }
            this.eii = ((com.tencent.mm.plugin.messenger.foundation.a.j) g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bOr().Rq(this.ehq);
            this.eii = ((com.tencent.mm.plugin.messenger.foundation.a.j) g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bOr().Rq(this.ehq);
        } else if (this.ehL) {
            this.eic = false;
            this.eid = false;
            setMMTitle(getString(R.string.dsu));
            this.ehS = (ContactListExpandPreference) this.ehK.aqO("roominfo_contact_anchor");
            this.ehS.a(this.ehK, this.ehS.mKey);
            this.ehS.oD(false).oE(false);
            this.ehS.a(new k.b() {
                public final boolean iD(int i) {
                    return true;
                }
            });
            this.ehK.removeAll();
            this.ehK.b(new PreferenceCategory(this));
            this.ehK.b(this.ehS);
            str = this.ehq;
            final ko koVar = new ko();
            koVar.cGu.cEw = str;
            com.tencent.mm.sdk.b.a.xxA.m(koVar);
            getString(R.string.tz);
            this.ehJ = h.b((Context) this, getString(R.string.dss), true, new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                    AppMethodBeat.i(104003);
                    ChatroomInfoUI.a(koVar);
                    AppMethodBeat.o(104003);
                }
            });
            this.ehK.notifyDataSetChanged();
        }
        if (this.ehS != null) {
            if (!this.cEH && this.ehL) {
                this.ehS.ag(new ArrayList());
            }
            this.nDp.setOnScrollListener(this.ein);
            this.ehS.a(this.ein);
            this.ehS.a(new k.b() {
                public final boolean iD(int i) {
                    return true;
                }
            });
            ContactListExpandPreference contactListExpandPreference = this.ehS;
            AnonymousClass2 anonymousClass2 = new View.OnClickListener() {
                public final void onClick(View view) {
                }
            };
            if (contactListExpandPreference.vld != null) {
                contactListExpandPreference.vld.pLd = anonymousClass2;
            }
            this.ehS.a(new com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference.a() {
                public final void iA(int i) {
                    AppMethodBeat.i(103963);
                    ChatroomInfoUI.l(ChatroomInfoUI.this);
                    AppMethodBeat.o(103963);
                }

                /* JADX WARNING: Removed duplicated region for block: B:10:0x004e  */
                /* JADX WARNING: Removed duplicated region for block: B:9:0x004a  */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public final void iB(int i) {
                    String str;
                    AppMethodBeat.i(103964);
                    String KX = ChatroomInfoUI.this.ehS.KX(i);
                    String nullAsNil = bo.nullAsNil(ChatroomInfoUI.this.ehS.KZ(i));
                    if (bo.isNullOrNil(nullAsNil)) {
                        g.RQ();
                        bv RB = ((com.tencent.mm.plugin.messenger.foundation.a.j) g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).XN().RB(KX);
                        if (!(RB == null || bo.isNullOrNil(RB.field_encryptUsername))) {
                            str = RB.field_conRemark;
                            if (bo.isNullOrNil(KX)) {
                                Intent intent = new Intent();
                                intent.putExtra("Contact_User", KX);
                                intent.putExtra("Contact_RemarkName", str);
                                if (ChatroomInfoUI.this.cEH && ChatroomInfoUI.this.eih != null) {
                                    intent.putExtra("Contact_RoomNickname", ChatroomInfoUI.this.eih.mJ(KX));
                                }
                                intent.putExtra("Contact_Nick", bo.nullAsNil(ChatroomInfoUI.this.ehS.KY(i)));
                                intent.putExtra("Contact_RoomMember", true);
                                intent.putExtra("room_name", ChatroomInfoUI.this.ehM.field_username);
                                ad aoO = ((com.tencent.mm.plugin.messenger.foundation.a.j) g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).XM().aoO(KX);
                                if (aoO != null && ((int) aoO.ewQ) > 0 && com.tencent.mm.n.a.jh(aoO.field_type)) {
                                    qh qhVar = new qh();
                                    qhVar.cMw.intent = intent;
                                    qhVar.cMw.username = KX;
                                    com.tencent.mm.sdk.b.a.xxA.m(qhVar);
                                }
                                if (ChatroomInfoUI.this.cEH) {
                                    com.tencent.mm.plugin.report.service.h.pYm.a(219, 9, 1, true);
                                    if (aoO != null && aoO.dsf()) {
                                        com.tencent.mm.plugin.report.service.h.pYm.X(10298, aoO.field_username + ",14");
                                    }
                                    intent.putExtra("Contact_Scene", 14);
                                } else if (ChatroomInfoUI.this.ehL) {
                                    intent.putExtra("Contact_Scene", 44);
                                    if (!r.mG(aoO.field_username)) {
                                        intent.putExtra("Contact_IsLBSFriend", true);
                                    }
                                }
                                intent.putExtra("Is_RoomOwner", ChatroomInfoUI.this.eic);
                                intent.putExtra("Contact_ChatRoomId", ChatroomInfoUI.this.ehq);
                                if (t.mP(ChatroomInfoUI.this.ehq)) {
                                    com.tencent.mm.g.b.a.t tVar = new com.tencent.mm.g.b.a.t();
                                    tVar.eO(ChatroomInfoUI.this.ehq);
                                    tVar.cXP = 12;
                                    tVar.ajK();
                                }
                                intent.putExtra("CONTACT_INFO_UI_SOURCE", 8);
                                com.tencent.mm.bp.d.b(ChatroomInfoUI.this, Scopes.PROFILE, ".ui.ContactInfoUI", intent);
                                AppMethodBeat.o(103964);
                                return;
                            }
                            AppMethodBeat.o(103964);
                            return;
                        }
                    }
                    str = nullAsNil;
                    if (bo.isNullOrNil(KX)) {
                    }
                }

                public final void JT() {
                    AppMethodBeat.i(103965);
                    if (ChatroomInfoUI.this.ehS != null) {
                        ChatroomInfoUI.this.ehS.djD();
                    }
                    AppMethodBeat.o(103965);
                }

                public final void iC(int i) {
                    AppMethodBeat.i(103966);
                    ChatroomInfoUI.r(ChatroomInfoUI.this);
                    AppMethodBeat.o(103966);
                }
            });
        }
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(103967);
                ChatroomInfoUI.this.finish();
                AppMethodBeat.o(103967);
                return true;
            }
        });
        AppMethodBeat.o(104025);
    }

    public final boolean a(com.tencent.mm.ui.base.preference.f fVar, Preference preference) {
        int i = 1;
        AppMethodBeat.i(104026);
        String str = preference.mKey;
        int i2;
        Intent intent;
        com.tencent.mm.g.b.a.t tVar;
        Intent intent2;
        boolean aoo;
        com.tencent.mm.modelstat.b bVar;
        String str2;
        boolean z;
        IMBehavior iMBehavior;
        String JD;
        if (str.equals("room_name")) {
            str = com.tencent.mm.m.g.Nu().getValue("ChatRoomOwnerModTopic");
            if (bo.isNullOrNil(str)) {
                i2 = 0;
            } else {
                i2 = bo.ank(str);
            }
            if (bo.isNullOrNil(this.eih.field_roomowner) || i2 <= 0 || JR() || i2 >= this.eie) {
                str = "";
                if (JO()) {
                    str = this.ehM.Oj();
                }
                intent = new Intent();
                intent.setClass(this, ModRemarkRoomNameUI.class);
                intent.putExtra("room_name", str);
                intent.putExtra("RoomInfo_Id", this.ehq);
                startActivityForResult(intent, 4);
                com.tencent.mm.plugin.report.service.h.pYm.a(219, 3, 1, true);
            } else {
                h.a((Context) this, getString(R.string.duw, new Object[]{JH()}), null, getString(R.string.r4), new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
            }
        } else if (str.equals("room_upgrade_entry")) {
            by(this);
        } else if (str.equals("room_qr_code")) {
            if (t.mP(this.ehq)) {
                tVar = new com.tencent.mm.g.b.a.t();
                tVar.eO(this.ehq);
                tVar.cXP = 6;
                tVar.ajK();
            }
            com.tencent.mm.plugin.report.service.h.pYm.a(219, 5, 1, true);
            intent2 = new Intent();
            intent2.putExtra("from_userName", this.ehq);
            com.tencent.mm.bp.d.b((Context) this, "setting", ".ui.setting.SelfQRCodeUI", intent2);
        } else if (str.equals("room_card")) {
            aoo = this.eih.aoo(r.Yz());
            if (!bo.isNullOrNil(n.mC(this.ehq)) || JR()) {
                intent = new Intent();
                intent.setClass(this, RoomCardUI.class);
                intent.putExtra("RoomInfo_Id", this.ehq);
                intent.putExtra("room_name", this.ehN.eoj.toString());
                this.eie = n.my(this.ehq).size();
                intent.putExtra("room_member_count", this.eie);
                intent.putExtra("room_owner_name", JH());
                intent.putExtra("room_notice", n.mC(this.ehq));
                intent.putExtra("room_notice_publish_time", n.mE(this.ehq));
                intent.putExtra("room_notice_editor", n.mD(this.ehq));
                intent.putExtra("Is_RoomOwner", this.eic);
                intent.putExtra("Is_RoomManager", aoo);
                startActivityForResult(intent, 6);
            } else {
                h.d(this, getString(R.string.drl), null, getString(R.string.drm), null, null, null);
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
                com.tencent.mm.roomsdk.a.b.alY(this.ehq).E(this.ehq, i3).dmX();
                this.ehM = ((com.tencent.mm.plugin.messenger.foundation.a.j) g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).XM().aoO(this.ehq);
                this.ehM.hE(i3);
                ((com.tencent.mm.plugin.messenger.foundation.a.j) g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).XM().b(this.ehq, this.ehM);
                if (this.eim) {
                    long j;
                    com.tencent.mm.plugin.report.service.h hVar = com.tencent.mm.plugin.report.service.h.pYm;
                    if (this.eif) {
                        j = 14;
                    } else {
                        j = 15;
                    }
                    hVar.k(869, j, 1);
                }
            }
            bVar = com.tencent.mm.modelstat.b.fRa;
            str2 = this.ehq;
            z = this.eif;
            if (bVar.aka() && bVar.cM(str2)) {
                iMBehavior = new IMBehavior();
                iMBehavior.opType = 1;
                iMBehavior.chattingOp = new IMBehaviorChattingOP();
                IMBehaviorChattingOP iMBehaviorChattingOP = iMBehavior.chattingOp;
                if (!z) {
                    i = 2;
                }
                iMBehaviorChattingOP.changeNotifyStatus = i;
                synchronized (bVar.lock) {
                    try {
                        bVar.fQZ.oplist_.add(iMBehavior);
                    } catch (Throwable th) {
                        while (true) {
                            AppMethodBeat.o(104026);
                        }
                    }
                }
            }
            JL();
        } else if (str.equals("room_save_to_contact")) {
            if (this.ehZ == null) {
                this.ehZ = getSharedPreferences(getPackageName() + "_preferences", 0);
            }
            ad aoO = ((com.tencent.mm.plugin.messenger.foundation.a.j) g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).XM().aoO(this.ehq);
            if (aoO != null) {
                z = com.tencent.mm.n.a.jh(aoO.field_type);
                this.ehZ.edit().putBoolean("room_save_to_contact", !z).commit();
                if (z) {
                    aoO.NC();
                    com.tencent.mm.roomsdk.a.b.alY(this.ehq).a(aoO, false);
                    h.bQ(this, getString(R.string.du4));
                    com.tencent.mm.modelstat.b.fRa.R(this.ehq, false);
                } else {
                    com.tencent.mm.roomsdk.a.b.alY(this.ehq).a(aoO, true);
                    h.bQ(this, getString(R.string.duj));
                    com.tencent.mm.modelstat.b.fRa.R(this.ehq, true);
                }
                this.ehK.notifyDataSetChanged();
            }
        } else if (str.equals("room_placed_to_the_top")) {
            SharedPreferences sharedPreferences = getSharedPreferences(this.eis, 0);
            if (this.ehM != null) {
                if (((com.tencent.mm.plugin.messenger.foundation.a.j) g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).XR().aph(this.ehM.field_username)) {
                    t.x(this.ehM.field_username, true);
                    com.tencent.mm.modelstat.b.fRa.c(false, this.ehq, false);
                } else {
                    t.w(this.ehM.field_username, true);
                    com.tencent.mm.modelstat.b.fRa.c(false, this.ehq, true);
                }
                sharedPreferences.edit().putBoolean("room_placed_to_the_top", ((com.tencent.mm.plugin.messenger.foundation.a.j) g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).XR().aph(this.ehM.field_username)).commit();
            }
        } else if (str.equals("room_nickname")) {
            JD = JD();
            if (bo.isNullOrNil(JD)) {
                JD = r.YB();
            }
            h.a(this.mController.ylL, getString(R.string.dtf), JD, getString(R.string.dsg), 32, new h.b() {
                public final boolean s(CharSequence charSequence) {
                    AppMethodBeat.i(103969);
                    String charSequence2 = charSequence == null ? "" : charSequence.toString();
                    String Ne = com.tencent.mm.m.b.Ne();
                    if (bo.isNullOrNil(Ne) || !charSequence2.matches(".*[" + Ne + "].*")) {
                        if (!(charSequence2 == null || charSequence2.equals(JD))) {
                            ChatroomInfoUI.a(ChatroomInfoUI.this, charSequence2);
                        }
                        AppMethodBeat.o(103969);
                        return true;
                    }
                    h.bQ(ChatroomInfoUI.this.mController.ylL, ChatroomInfoUI.this.getString(R.string.ce4, new Object[]{Ne}));
                    AppMethodBeat.o(103969);
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
            if (t.mP(this.ehq)) {
                tVar = new com.tencent.mm.g.b.a.t();
                tVar.eO(this.ehq);
                tVar.cXP = 9;
                tVar.ajK();
            }
            intent2 = new Intent();
            intent2.putExtra("isApplyToAll", false);
            intent2.putExtra("username", this.ehM.field_username);
            com.tencent.mm.bp.d.b((Context) this, "setting", ".ui.setting.SettingsChattingBackgroundUI", intent2, 2);
        } else if (str.equals("room_search_chatting_content")) {
            if (t.mP(this.ehq)) {
                tVar = new com.tencent.mm.g.b.a.t();
                tVar.eO(this.ehq);
                tVar.cXP = 8;
                tVar.ajK();
            }
            intent2 = new Intent();
            intent2.putExtra("detail_username", this.ehq);
            com.tencent.mm.plugin.fts.a.d.c(this, ".ui.FTSChattingConvUI", intent2);
            if (this.eih == null || this.eih.afg() == null) {
                i2 = 0;
            } else {
                i2 = this.eih.afg().size();
            }
            com.tencent.mm.plugin.report.service.h.pYm.e(14569, Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(i2), Integer.valueOf(1));
        } else if (str.equals("room_clear_chatting_history")) {
            if (t.mP(this.ehq)) {
                tVar = new com.tencent.mm.g.b.a.t();
                tVar.eO(this.ehq);
                tVar.cXP = 11;
                tVar.ajK();
            }
            h.a(this.mController.ylL, getString(R.string.bx2), "", getString(R.string.ou), getString(R.string.or), new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    String str;
                    AppMethodBeat.i(103973);
                    com.tencent.mm.plugin.report.service.h.pYm.e(14553, Integer.valueOf(3), Integer.valueOf(2), ChatroomInfoUI.this.ehq);
                    ChatroomInfoUI.eiu = false;
                    Context context = ChatroomInfoUI.this;
                    ChatroomInfoUI.this.getString(R.string.tz);
                    final ProgressDialog b = h.b(context, ChatroomInfoUI.this.getString(R.string.un), true, new a());
                    if (ChatroomInfoUI.eiu) {
                        str = null;
                    } else {
                        str = com.tencent.mm.pluginsdk.wallet.e.akq(ChatroomInfoUI.this.ehM.field_username);
                    }
                    if (bo.isNullOrNil(str)) {
                        ChatroomInfoUI.a(ChatroomInfoUI.this, b);
                        AppMethodBeat.o(103973);
                        return;
                    }
                    b.dismiss();
                    h.a(ChatroomInfoUI.this, false, ChatroomInfoUI.this.getString(R.string.fdk, new Object[]{str}), null, ChatroomInfoUI.this.getString(R.string.c9y), ChatroomInfoUI.this.getString(R.string.ar1), new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.i(103971);
                            com.tencent.mm.plugin.report.service.h.pYm.e(14553, Integer.valueOf(3), Integer.valueOf(4), ChatroomInfoUI.this.ehq);
                            ChatroomInfoUI.this.isDeleteCancel = true;
                            if (ChatroomInfoUI.this.eik) {
                                ChatroomInfoUI.this.finish();
                                AppMethodBeat.o(103971);
                                return;
                            }
                            Intent intent = new Intent();
                            intent.putExtra("Chat_User", ChatroomInfoUI.this.ehM.field_username);
                            intent.addFlags(67108864);
                            com.tencent.mm.bp.d.f(ChatroomInfoUI.this, ".ui.chatting.ChattingUI", intent);
                            AppMethodBeat.o(103971);
                        }
                    }, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.i(103972);
                            com.tencent.mm.plugin.report.service.h.pYm.e(14553, Integer.valueOf(3), Integer.valueOf(3), ChatroomInfoUI.this.ehq);
                            b.show();
                            ChatroomInfoUI.this.isDeleteCancel = false;
                            ChatroomInfoUI.a(ChatroomInfoUI.this, b);
                            AppMethodBeat.o(103972);
                        }
                    }, -1, R.color.ei);
                    AppMethodBeat.o(103973);
                }
            }, null, (int) R.color.ei);
        } else if (str.equals("room_report_it")) {
            if (t.mP(this.ehq)) {
                tVar = new com.tencent.mm.g.b.a.t();
                tVar.eO(this.ehq);
                tVar.cXP = 10;
                tVar.ajK();
            }
            intent2 = new Intent();
            intent2.putExtra("k_username", this.ehq);
            intent2.putExtra("showShare", false);
            intent2.putExtra("rawUrl", String.format("https://weixin110.qq.com/security/readtemplate?t=weixin_report/w_type&scene=%d#wechat_redirect", new Object[]{Integer.valueOf(36)}));
            com.tencent.mm.bp.d.b((Context) this, "webview", ".ui.tools.WebViewUI", intent2);
            bVar = com.tencent.mm.modelstat.b.fRa;
            str2 = this.ehq;
            if (bVar.aka() && bVar.cM(str2)) {
                iMBehavior = new IMBehavior();
                iMBehavior.opType = 1;
                iMBehavior.chattingOp = new IMBehaviorChattingOP();
                iMBehavior.chattingOp.expose = 1;
                synchronized (bVar.lock) {
                    try {
                        bVar.fQZ.oplist_.add(iMBehavior);
                    } catch (Throwable th2) {
                        AppMethodBeat.o(104026);
                    }
                }
            }
        } else if (str.equals("room_del_quit")) {
            ab.d("MicroMsg.ChatroomInfoUI", " quit " + this.ehq);
            sz szVar = new sz();
            szVar.cPf.cPh = true;
            com.tencent.mm.sdk.b.a.xxA.m(szVar);
            aoo = !bo.isNullOrNil(this.ehq) && this.ehq.equals(szVar.cPg.cPj);
            if (aoo) {
                ab.d("MicroMsg.ChatroomInfoUI", " quit talkroom" + this.ehq);
            } else if (this.eic && this.eih.afg().size() > 2) {
                h.a((Context) this, "", new String[]{getString(R.string.dtt)}, getString(R.string.or), new h.c() {
                    public final void iE(int i) {
                        AppMethodBeat.i(103976);
                        switch (i) {
                            case 0:
                                ab.d("MicroMsg.ChatroomInfoUI", "dz[dealQuitChatRoom owner click room_owner_delete_direct]");
                                ChatroomInfoUI.v(ChatroomInfoUI.this);
                                ((com.tencent.mm.plugin.multitalk.model.a) g.K(com.tencent.mm.plugin.multitalk.model.a.class)).RU(ChatroomInfoUI.this.ehq);
                                AppMethodBeat.o(103976);
                                return;
                            default:
                                ab.d("MicroMsg.ChatroomInfoUI", "dz[dealQuitChatRoom owner click cancel]");
                                AppMethodBeat.o(103976);
                                return;
                        }
                    }
                });
            }
            h.a(this.mController.ylL, getString(R.string.b4z), "", getString(R.string.s6), getString(R.string.or), new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(103977);
                    if (ChatroomInfoUI.this.ehq == null || ChatroomInfoUI.this.ehq.length() <= 0) {
                        ab.e("MicroMsg.ChatroomInfoUI", "quitChatRoom : invalid args");
                        AppMethodBeat.o(103977);
                        return;
                    }
                    if (aoo) {
                        sz szVar = new sz();
                        szVar.cPf.cPi = true;
                        com.tencent.mm.sdk.b.a.xxA.m(szVar);
                    }
                    if (((com.tencent.mm.plugin.messenger.foundation.a.j) g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).XM().aoQ(ChatroomInfoUI.this.ehq)) {
                        ChatroomInfoUI.v(ChatroomInfoUI.this);
                        ((com.tencent.mm.plugin.multitalk.model.a) g.K(com.tencent.mm.plugin.multitalk.model.a.class)).RU(ChatroomInfoUI.this.ehq);
                        AppMethodBeat.o(103977);
                        return;
                    }
                    ab.e("MicroMsg.ChatroomInfoUI", "quitChatRoom : room[" + ChatroomInfoUI.this.ehq + "] is not exist");
                    AppMethodBeat.o(103977);
                }
            }, null, (int) R.color.ei);
        } else if (str.equals("add_selector_btn")) {
            JF();
        } else if (str.equals("del_selector_btn")) {
            JG();
        } else if (str.equals("see_room_member")) {
            intent = new Intent();
            intent.setClass(this.mController.ylL, SeeRoomMemberUI.class);
            intent.putExtra("Block_list", r.Yz());
            List my = n.my(this.ehq);
            if (my != null) {
                this.eie = my.size();
            }
            intent.putExtra("Chatroom_member_list", bo.c(my, ","));
            intent.putExtra("RoomInfo_Id", this.ehq);
            intent.putExtra("room_owner_name", this.eih.field_roomowner);
            intent.putExtra("Is_RoomOwner", this.eic);
            intent.putExtra("room_member_count", this.eie);
            intent.putExtra("Add_address_titile", getString(R.string.dun));
            if (this.cEH) {
                intent.putExtra("Contact_Scene", 14);
            } else if (this.ehL) {
                intent.putExtra("Contact_Scene", 44);
                if (!r.mG(this.ehM.field_username)) {
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
            if (t.mP(this.ehq)) {
                tVar = new com.tencent.mm.g.b.a.t();
                tVar.eO(this.ehq);
                tVar.cXP = 7;
                tVar.ajK();
            }
            intent2 = new Intent();
            intent2.putExtra("Chat_User", this.ehq);
            com.tencent.mm.bp.d.f(this, ".ui.chatting.gallery.AppBrandHistoryListUI", intent2);
            com.tencent.mm.plugin.report.service.h.pYm.a(219, 25, 1, true);
        } else if (str.equals("room_manager_view")) {
            intent2 = new Intent();
            intent2.setClass(this.mController.ylL, SeeRoomOwnerManagerUI.class);
            intent2.putExtra("RoomInfo_Id", this.ehq);
            intent2.putExtra("room_owner_name", this.eih.field_roomowner);
            startActivity(intent2);
        } else {
            str.equals("chat_room_story_videos");
        }
        AppMethodBeat.o(104026);
        return false;
    }

    static /* synthetic */ void v(ChatroomInfoUI chatroomInfoUI) {
        String str;
        AppMethodBeat.i(104068);
        com.tencent.mm.plugin.report.service.h.pYm.e(14553, Integer.valueOf(4), Integer.valueOf(2), chatroomInfoUI.ehq);
        long j = ((com.tencent.mm.plugin.messenger.foundation.a.j) g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bOr().Ra(chatroomInfoUI.ehq).field_msgSvrId;
        vo voVar = new vo();
        voVar.wcB = new bts().alV(bo.nullAsNil(chatroomInfoUI.ehq));
        voVar.ptF = j;
        ((com.tencent.mm.plugin.messenger.foundation.a.j) g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).XL().c(new com.tencent.mm.plugin.messenger.foundation.a.a.j.a(8, voVar));
        chatroomInfoUI.isDeleteCancel = false;
        chatroomInfoUI.getString(R.string.tz);
        final p b = h.b((Context) chatroomInfoUI, chatroomInfoUI.getString(R.string.un), true, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(103978);
                ChatroomInfoUI.this.isDeleteCancel = true;
                AppMethodBeat.o(103978);
            }
        });
        if (chatroomInfoUI.isDeleteCancel) {
            str = null;
        } else {
            str = com.tencent.mm.pluginsdk.wallet.e.akq(chatroomInfoUI.ehM.field_username);
        }
        if (bo.isNullOrNil(str)) {
            chatroomInfoUI.bB(true);
            AppMethodBeat.o(104068);
            return;
        }
        b.dismiss();
        Object[] objArr = new Object[]{str};
        h.a(chatroomInfoUI, false, chatroomInfoUI.getString(R.string.fdl, objArr), null, chatroomInfoUI.getString(R.string.c9y), chatroomInfoUI.getString(R.string.dry), new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.i(103979);
                com.tencent.mm.plugin.report.service.h.pYm.e(14553, Integer.valueOf(4), Integer.valueOf(4), ChatroomInfoUI.this.ehq);
                ChatroomInfoUI.this.isDeleteCancel = true;
                if (ChatroomInfoUI.this.eik) {
                    ChatroomInfoUI.this.finish();
                    AppMethodBeat.o(103979);
                    return;
                }
                Intent intent = new Intent();
                intent.putExtra("Chat_User", ChatroomInfoUI.this.ehM.field_username);
                intent.addFlags(67108864);
                com.tencent.mm.bp.d.f(ChatroomInfoUI.this, ".ui.chatting.ChattingUI", intent);
                AppMethodBeat.o(103979);
            }
        }, new OnClickListener() {
            final /* synthetic */ boolean eiF = true;

            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.i(103980);
                com.tencent.mm.plugin.report.service.h.pYm.e(14553, Integer.valueOf(4), Integer.valueOf(3), ChatroomInfoUI.this.ehq);
                b.show();
                ChatroomInfoUI.this.isDeleteCancel = false;
                ChatroomInfoUI.b(ChatroomInfoUI.this, this.eiF);
                AppMethodBeat.o(103980);
            }
        }, -1, R.color.ei);
        AppMethodBeat.o(104068);
    }

    static /* synthetic */ void z(ChatroomInfoUI chatroomInfoUI) {
        AppMethodBeat.i(104071);
        chatroomInfoUI.updateTitle();
        if (chatroomInfoUI.eih != null) {
            chatroomInfoUI.eie = chatroomInfoUI.eih.afg().size();
        }
        if ((!chatroomInfoUI.eic && chatroomInfoUI.eie >= j.MAX_COUNT) || (chatroomInfoUI.eic && chatroomInfoUI.eie >= j.MAX_COUNT - 1)) {
            chatroomInfoUI.ehK.ce("see_room_member", false);
            chatroomInfoUI.ehP.setTitle(chatroomInfoUI.getString(R.string.e14));
        }
        AppMethodBeat.o(104071);
    }

    static /* synthetic */ void a(ChatroomInfoUI chatroomInfoUI, int i, com.tencent.mm.roomsdk.a.b.c cVar, String str) {
        AppMethodBeat.i(104072);
        String str2 = "";
        String str3 = "";
        String string = ah.getContext().getString(R.string.ajw);
        final List list = cVar.ehj;
        final List list2 = cVar.ehl;
        final List list3 = cVar.cGd;
        if (i != -2012 || ((list == null || list.isEmpty()) && (list2 == null || list2.isEmpty()))) {
            String string2;
            Object obj;
            u ob = ((com.tencent.mm.plugin.chatroom.a.c) g.K(com.tencent.mm.plugin.chatroom.a.c.class)).XV().ob(chatroomInfoUI.ehq);
            if (i == -116 && JI() && !bo.isNullOrNil(ob.field_roomowner)) {
                str2 = chatroomInfoUI.getString(R.string.dt5);
                string2 = chatroomInfoUI.getString(R.string.dt4);
                obj = 1;
            } else {
                string2 = str3;
                obj = null;
            }
            if (i == -23) {
                str2 = chatroomInfoUI.getString(R.string.dtb);
                string2 = chatroomInfoUI.getString(R.string.dta);
            }
            if (i == -109) {
                str2 = chatroomInfoUI.getString(R.string.dt7);
                string2 = chatroomInfoUI.getString(R.string.dt6);
            }
            if (i == -122) {
                str2 = chatroomInfoUI.getString(R.string.dtb);
                string2 = chatroomInfoUI.getString(R.string.dt_, new Object[]{chatroomInfoUI.JH(), Integer.valueOf(ob.drW())});
            }
            List list4 = cVar.ehk;
            if (list3 == null || list3.size() <= 0 || (list3.size() != cVar.cEX && (list4 == null || list4.size() <= 0 || cVar.cEX != list3.size() + list4.size()))) {
                list4 = cVar.ehk;
                if (list4 != null && list4.size() > 0) {
                    string2 = string2 + chatroomInfoUI.getString(R.string.bx_, new Object[]{bo.c(O(list4), string)});
                }
                list4 = cVar.cGc;
                if (list4 == null || list4.size() <= 0) {
                    str3 = string2;
                } else {
                    str2 = chatroomInfoUI.getString(R.string.cw);
                    str3 = string2 + chatroomInfoUI.getString(R.string.bxn, new Object[]{bo.c(O(list4), string)});
                }
                List<String> list5 = cVar.cGa;
                if (list5 != null && list5.size() > 0) {
                    Object obj2;
                    for (String string22 : list5) {
                        if (ad.aox(string22)) {
                            str2 = chatroomInfoUI.getString(R.string.cm_);
                            str3 = chatroomInfoUI.getString(R.string.cma);
                            obj2 = 1;
                            break;
                        }
                    }
                    obj2 = null;
                    if (obj2 == null) {
                        str2 = chatroomInfoUI.getString(R.string.cw);
                        str3 = str3 + chatroomInfoUI.getString(R.string.bxc, new Object[]{bo.c(O(list5), string)});
                    }
                }
                List list6 = cVar.ehl;
                ArrayList arrayList = new ArrayList();
                if (!(list3 == null || list3.isEmpty())) {
                    arrayList.addAll(list3);
                }
                if (list6 != null && list6.size() > 0) {
                    arrayList.addAll(list6);
                }
                if (i != -2028 && t.mO(chatroomInfoUI.ehq)) {
                    chatroomInfoUI.d(cVar.chatroomName, list3);
                }
                string22 = str3 + chatroomInfoUI.getString(R.string.bwt, new Object[]{bo.c(O(arrayList), string)});
                if (list3 != null && list3.isEmpty()) {
                    string22 = null;
                }
                if (t.mP(chatroomInfoUI.ehq)) {
                    if (cVar != null && !bo.isNullOrNil(cVar.vEO)) {
                        h.b((Context) chatroomInfoUI, cVar.vEO, "", true);
                        AppMethodBeat.o(104072);
                        return;
                    } else if (t.mP(chatroomInfoUI.ehq) && !bo.isNullOrNil(str)) {
                        h.b((Context) chatroomInfoUI, str, "", true);
                        AppMethodBeat.o(104072);
                        return;
                    }
                }
                if (string22 == null || string22.length() <= 0) {
                    if (cVar == null || bo.isNullOrNil(cVar.vEO)) {
                        if (t.mP(chatroomInfoUI.ehq) && !bo.isNullOrNil(str)) {
                            h.b((Context) chatroomInfoUI, str, "", true);
                        }
                        AppMethodBeat.o(104072);
                        return;
                    }
                    h.b((Context) chatroomInfoUI, cVar.vEO, "", true);
                    AppMethodBeat.o(104072);
                    return;
                } else if (cVar != null && !bo.isNullOrNil(cVar.vEO)) {
                    h.b((Context) chatroomInfoUI, cVar.vEO, "", true);
                    AppMethodBeat.o(104072);
                    return;
                } else if (t.mP(chatroomInfoUI.ehq) && !bo.isNullOrNil(str)) {
                    h.b((Context) chatroomInfoUI, str, "", true);
                    AppMethodBeat.o(104072);
                    return;
                } else if (obj != null) {
                    h.a((Context) chatroomInfoUI, string22, str2, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.i(103995);
                            ChatroomInfoUI chatroomInfoUI = ChatroomInfoUI.this;
                            Context context = ChatroomInfoUI.this;
                            ChatroomInfoUI.this.ehq;
                            ChatroomInfoUI.a(chatroomInfoUI, context);
                            AppMethodBeat.o(103995);
                        }
                    }, null);
                    AppMethodBeat.o(104072);
                    return;
                } else {
                    h.b((Context) chatroomInfoUI, string22, str2, true);
                    AppMethodBeat.o(104072);
                    return;
                }
            }
            List linkedList = new LinkedList();
            for (int i2 = 0; i2 < list3.size(); i2++) {
                linkedList.add(list3.get(i2));
            }
            string22 = "";
            String string3 = ah.getContext().getString(R.string.ajw);
            if (!(list4 == null || list4.isEmpty())) {
                string22 = chatroomInfoUI.getString(R.string.bws, new Object[]{bo.c(O(list4), string3)}) + IOUtils.LINE_SEPARATOR_UNIX;
            }
            if (!linkedList.isEmpty()) {
                string22 = string22 + chatroomInfoUI.getString(R.string.bwt, new Object[]{bo.c(O(linkedList), string3)});
            }
            h.a((Context) chatroomInfoUI, string22, "", chatroomInfoUI.getString(R.string.bwl), new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(103996);
                    ChatroomInfoUI.y(ChatroomInfoUI.this);
                    AppMethodBeat.o(103996);
                }
            });
            if (t.mO(chatroomInfoUI.ehq)) {
                chatroomInfoUI.d(cVar.chatroomName, linkedList);
            }
            AppMethodBeat.o(104072);
            return;
        }
        String string4 = chatroomInfoUI.getString(R.string.cx);
        String string5 = chatroomInfoUI.getString(R.string.ce5);
        String string6 = chatroomInfoUI.getString(R.string.or);
        final com.tencent.mm.roomsdk.a.b.c cVar2 = cVar;
        AnonymousClass28 anonymousClass28 = new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.i(103994);
                if (t.mO(ChatroomInfoUI.this.ehq)) {
                    ChatroomInfoUI.a(ChatroomInfoUI.this, cVar2.chatroomName, list3);
                }
                List arrayList = new ArrayList();
                arrayList.addAll(list);
                arrayList.addAll(list2);
                ChatroomInfoUI.a(ChatroomInfoUI.this, arrayList);
                AppMethodBeat.o(103994);
            }
        };
        h.d(chatroomInfoUI, string4, null, string5, string6, anonymousClass28, new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
            }
        });
        AppMethodBeat.o(104072);
    }
}
