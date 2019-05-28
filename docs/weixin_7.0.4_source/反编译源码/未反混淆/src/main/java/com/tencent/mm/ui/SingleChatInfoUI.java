package com.tencent.mm.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Looper;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import com.google.android.gms.common.Scopes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.kernel.i;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.c;
import com.tencent.mm.model.cb;
import com.tencent.mm.model.r;
import com.tencent.mm.model.t;
import com.tencent.mm.modelmulti.n;
import com.tencent.mm.platformtools.ah;
import com.tencent.mm.plugin.forcenotify.a.b;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference;
import com.tencent.mm.pluginsdk.ui.d;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.base.preference.h;
import com.tencent.mm.ui.contact.SelectContactUI;
import com.tencent.mm.ui.contact.e;
import com.tencent.mm.ui.contact.s;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;

@i
public class SingleChatInfoUI extends MMPreference implements com.tencent.mm.bg.a {
    private static boolean isDeleteCancel = false;
    private f ehK;
    private ad ehM;
    private ContactListExpandPreference ehS;
    private CheckBoxPreference ehT;
    private CheckBoxPreference ehV;
    private SharedPreferences ehZ = null;
    private boolean eif;
    private int eii = -1;
    private boolean eik = false;
    private d ein = new d(new OnScrollListener() {
        public final void onScrollStateChanged(AbsListView absListView, int i) {
        }

        public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }
    });
    boolean eio = false;
    private String eis = "";
    private ak handler = new ak(Looper.getMainLooper());
    private String talker;
    private CheckBoxPreference yqk;
    private com.tencent.mm.sdk.e.k.a yql = new com.tencent.mm.sdk.e.k.a() {
        public final void a(String str, m mVar) {
            AppMethodBeat.i(29868);
            SingleChatInfoUI.a(SingleChatInfoUI.this);
            AppMethodBeat.o(29868);
        }
    };

    static class a implements OnCancelListener {
        private a() {
        }

        /* synthetic */ a(byte b) {
            this();
        }

        public final void onCancel(DialogInterface dialogInterface) {
            AppMethodBeat.i(29879);
            SingleChatInfoUI.isDeleteCancel = true;
            AppMethodBeat.o(29879);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public SingleChatInfoUI() {
        AppMethodBeat.i(29880);
        AppMethodBeat.o(29880);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(29881);
        super.onCreate(bundle);
        ((b) g.K(b.class)).bxV().c(this.yql);
        if (com.tencent.mm.bg.g.fUs != null) {
            com.tencent.mm.bg.g.fUs.a(this);
        }
        this.talker = getIntent().getStringExtra("Single_Chat_Talker");
        this.eik = getIntent().getBooleanExtra("fromChatting", false);
        this.ehM = ((j) g.K(j.class)).XM().aoO(this.talker);
        if (this.ehM == null) {
            ab.e("MicroMsg.SingleChatInfoUI", "contact is null! talker:%s", this.talker);
            finish();
            AppMethodBeat.o(29881);
            return;
        }
        this.eis = getPackageName() + "_preferences";
        initView();
        ((com.tencent.mm.plugin.forcenotify.a.a) g.K(com.tencent.mm.plugin.forcenotify.a.a.class)).e(this.ehM.field_username, 3, cb.aaE() / 1000);
        AppMethodBeat.o(29881);
    }

    public void onResume() {
        AppMethodBeat.i(29882);
        JL();
        if (this.ehS != null) {
            LinkedList linkedList = new LinkedList();
            linkedList.add(this.talker);
            this.ehS.u(this.talker, linkedList);
        }
        dzc();
        this.ehK.notifyDataSetChanged();
        super.onResume();
        if (!this.eio) {
            String stringExtra = getIntent().getStringExtra("need_matte_high_light_item");
            if (!ah.isNullOrNil(stringExtra)) {
                final int aqQ = this.ehK.aqQ(stringExtra);
                setSelection(aqQ - 3);
                new ak().postDelayed(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(29869);
                        View a = ((com.tencent.mm.ui.base.preference.a) SingleChatInfoUI.this.ehK).a(aqQ, SingleChatInfoUI.this.nDp);
                        if (a != null) {
                            com.tencent.mm.ui.g.a.a(SingleChatInfoUI.this.mController.ylL, a);
                        }
                        AppMethodBeat.o(29869);
                    }
                }, 10);
            }
            this.eio = true;
        }
        AppMethodBeat.o(29882);
    }

    public void onPause() {
        AppMethodBeat.i(29883);
        super.onPause();
        AppMethodBeat.o(29883);
    }

    public void onDestroy() {
        AppMethodBeat.i(29884);
        ((b) g.K(b.class)).bxV().d(this.yql);
        com.tencent.mm.ui.g.a.dismiss();
        if (com.tencent.mm.bg.g.fUs != null) {
            com.tencent.mm.bg.g.fUs.b(this);
        }
        super.onDestroy();
        AppMethodBeat.o(29884);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(29885);
        super.onActivityResult(i, i2, intent);
        if (i2 != -1) {
            AppMethodBeat.o(29885);
            return;
        }
        switch (i) {
            case 2:
                if (i2 == -1) {
                    finish();
                    AppMethodBeat.o(29885);
                    return;
                }
                AppMethodBeat.o(29885);
                return;
            default:
                AppMethodBeat.o(29885);
                return;
        }
    }

    public final int JC() {
        return R.xml.bg;
    }

    /* Access modifiers changed, original: protected|final */
    public final void initView() {
        AppMethodBeat.i(29886);
        if (this.ehM == null) {
            ab.e("MicroMsg.SingleChatInfoUI", "[initView] contact is null!");
            finish();
        }
        this.ehK = this.yCw;
        setMMTitle(getString(R.string.dvi));
        this.ehS = (ContactListExpandPreference) this.ehK.aqO("roominfo_contact_anchor");
        this.ehS.a(this.ehK, this.ehS.mKey);
        this.ehS.oD(true).oE(false);
        if (this.ehM != null && this.ehM.field_deleteFlag == 1) {
            this.ehS.oD(false);
        }
        if (!(s.dIh() || this.ehM == null || !ad.aox(this.ehM.field_username))) {
            this.ehS.oD(false);
        }
        this.ehT = (CheckBoxPreference) this.ehK.aqO("room_notify_new_msg");
        this.ehV = (CheckBoxPreference) this.ehK.aqO("room_placed_to_the_top");
        this.ehK.ce("force_notify", !com.tencent.mm.n.a.jh(this.ehM.field_type));
        if (this.ehZ == null) {
            this.ehZ = getSharedPreferences(getPackageName() + "_preferences", 0);
        }
        if (this.ehM != null) {
            aw.ZK();
            this.ehZ.edit().putBoolean("room_placed_to_the_top", c.XR().aph(this.ehM.field_username)).commit();
            this.eif = this.ehM.DX();
            this.ehZ.edit().putBoolean("room_notify_new_msg", this.eif).commit();
        } else {
            this.ehZ.edit().putBoolean("room_notify_new_msg", false).commit();
            this.eif = false;
        }
        aw.ZK();
        this.eii = c.XO().Rq(this.talker);
        this.ehK.notifyDataSetChanged();
        if (this.ehS != null) {
            LinkedList linkedList = new LinkedList();
            linkedList.add(this.talker);
            this.ehS.u(this.talker, linkedList);
            this.nDp.setOnScrollListener(this.ein);
            this.ehS.a(this.ein);
            this.ehS.a(new com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference.a() {
                public final void iA(int i) {
                }

                public final void iB(int i) {
                    AppMethodBeat.i(29870);
                    String KX = SingleChatInfoUI.this.ehS.KX(i);
                    String nullAsNil = ah.nullAsNil(SingleChatInfoUI.this.ehS.KZ(i));
                    if (ah.isNullOrNil(nullAsNil)) {
                        aw.ZK();
                        bv RB = c.XN().RB(KX);
                        if (!(RB == null || ah.isNullOrNil(RB.field_encryptUsername))) {
                            nullAsNil = RB.field_conRemark;
                        }
                    }
                    if (ah.isNullOrNil(KX)) {
                        AppMethodBeat.o(29870);
                        return;
                    }
                    Intent intent = new Intent();
                    intent.putExtra("Contact_User", KX);
                    intent.putExtra("Contact_RemarkName", nullAsNil);
                    intent.putExtra("Contact_Nick", ah.nullAsNil(SingleChatInfoUI.this.ehS.KY(i)));
                    intent.putExtra("Contact_RoomMember", true);
                    intent.putExtra("CONTACT_INFO_UI_SOURCE", 2);
                    ad aoO = ((j) g.K(j.class)).XM().aoO(KX);
                    if (aoO != null && ((int) aoO.ewQ) > 0 && com.tencent.mm.n.a.jh(aoO.field_type)) {
                        e.a(intent, KX);
                    }
                    intent.putExtra("Kdel_from", 0);
                    intent.putExtra("CONTACT_INFO_UI_SOURCE", 2);
                    com.tencent.mm.bp.d.b(SingleChatInfoUI.this, Scopes.PROFILE, ".ui.ContactInfoUI", intent, 0);
                    AppMethodBeat.o(29870);
                }

                public final void JT() {
                    AppMethodBeat.i(29871);
                    if (SingleChatInfoUI.this.ehS != null) {
                        SingleChatInfoUI.this.ehS.djD();
                    }
                    AppMethodBeat.o(29871);
                }

                public final void iC(int i) {
                    AppMethodBeat.i(29872);
                    SingleChatInfoUI.d(SingleChatInfoUI.this);
                    AppMethodBeat.o(29872);
                }
            });
        }
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(29873);
                SingleChatInfoUI.this.finish();
                AppMethodBeat.o(29873);
                return true;
            }
        });
        AppMethodBeat.o(29886);
    }

    private void dzc() {
        int i = 0;
        AppMethodBeat.i(29887);
        this.yqk = (CheckBoxPreference) this.ehK.aqO("force_notify");
        if (ad.aox(this.ehM.field_username) || r.mG(this.ehM.field_username)) {
            this.ehK.ce("force_notify", true);
            AppMethodBeat.o(29887);
            return;
        }
        long Mo = ((b) g.K(b.class)).Mo(this.ehM.field_username);
        boolean Mp = ((b) g.K(b.class)).Mp(this.ehM.field_username);
        this.yqk.uOT = Mp;
        this.yqk.qg(Mp);
        if (this.yqk.isChecked()) {
            this.yqk.setSummary((CharSequence) getResources().getString(R.string.bzd, new Object[]{new SimpleDateFormat("HH:mm").format(new Date(Mo))}));
        } else {
            this.yqk.setSummary(null);
            setTitleMuteIconVisibility(this.ehM.DX() ? 0 : 8);
        }
        if (this.ehZ == null) {
            this.ehZ = getSharedPreferences(getPackageName() + "_preferences", 0);
        }
        this.ehZ.edit().putBoolean("force_notify", this.yqk.isChecked()).commit();
        if (!this.yqk.isChecked()) {
            i = 8;
        }
        Nd(i);
        this.ehK.notifyDataSetChanged();
        AppMethodBeat.o(29887);
    }

    private void b(final ProgressDialog progressDialog) {
        AppMethodBeat.i(29889);
        bf.a(this.ehM.field_username, new com.tencent.mm.model.bf.a() {
            public final boolean JU() {
                AppMethodBeat.i(29876);
                boolean cXE = SingleChatInfoUI.isDeleteCancel;
                AppMethodBeat.o(29876);
                return cXE;
            }

            public final void JV() {
                AppMethodBeat.i(29877);
                if (progressDialog != null) {
                    progressDialog.dismiss();
                }
                AppMethodBeat.o(29877);
            }
        });
        this.handler.post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(29867);
                n.ahW().lN(7);
                AppMethodBeat.o(29867);
            }
        });
        AppMethodBeat.o(29889);
    }

    private void JL() {
        AppMethodBeat.i(29890);
        if (this.ehZ == null) {
            this.ehZ = getSharedPreferences(getPackageName() + "_preferences", 0);
        }
        this.eif = this.ehM.DX();
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
        AppMethodBeat.o(29890);
    }

    public final void k(String str, String str2, String str3) {
        AppMethodBeat.i(29891);
        if (str.equals(this.talker) && this.ehS != null) {
            this.ehS.notifyChanged();
        }
        AppMethodBeat.o(29891);
    }

    public final h a(SharedPreferences sharedPreferences) {
        AppMethodBeat.i(29892);
        com.tencent.mm.ui.base.preference.a aVar = new com.tencent.mm.ui.base.preference.a(this, this.nDp, sharedPreferences);
        AppMethodBeat.o(29892);
        return aVar;
    }

    public final boolean a(f fVar, Preference preference) {
        boolean z = true;
        AppMethodBeat.i(29888);
        String str = preference.mKey;
        Intent intent;
        if (str.equals("room_notify_new_msg")) {
            if (this.eif) {
                z = false;
            }
            this.eif = z;
            if (this.eif) {
                t.o(this.ehM);
            } else {
                t.p(this.ehM);
            }
            this.ehM = ((j) g.K(j.class)).XM().aoO(this.talker);
            if (this.ehZ == null) {
                this.ehZ = getSharedPreferences(getPackageName() + "_preferences", 0);
            }
            this.ehZ.edit().putBoolean("room_notify_new_msg", this.eif).commit();
            JL();
        } else if (str.equals("room_placed_to_the_top")) {
            SharedPreferences sharedPreferences = getSharedPreferences(this.eis, 0);
            if (this.ehM != null) {
                aw.ZK();
                if (c.XR().aph(this.ehM.field_username)) {
                    t.x(this.ehM.field_username, true);
                } else {
                    t.w(this.ehM.field_username, true);
                }
                aw.ZK();
                sharedPreferences.edit().putBoolean("room_placed_to_the_top", c.XR().aph(this.ehM.field_username)).commit();
            }
        } else if (str.equals("force_notify")) {
            if (this.yqk.isChecked()) {
                ((b) g.K(b.class)).Mn(this.ehM.field_username);
                long Mo = ((b) g.K(b.class)).Mo(this.ehM.field_username);
                this.yqk.setSummary((CharSequence) getResources().getString(R.string.bzd, new Object[]{new SimpleDateFormat("HH:mm").format(new Date(Mo))}));
            } else {
                ((b) g.K(b.class)).am(this.ehM.field_username, 3);
                this.yqk.setSummary(null);
            }
        } else if (str.equals("room_set_chatting_background")) {
            intent = new Intent();
            intent.putExtra("isApplyToAll", false);
            intent.putExtra("username", this.ehM.field_username);
            com.tencent.mm.bp.d.b((Context) this, "setting", ".ui.setting.SettingsChattingBackgroundUI", intent, 2);
        } else if (str.equals("room_search_chatting_content")) {
            intent = new Intent();
            intent.putExtra("detail_username", this.talker);
            com.tencent.mm.plugin.fts.a.d.c(this, ".ui.FTSChattingConvUI", intent);
            com.tencent.mm.plugin.report.service.h.pYm.e(14569, Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0));
        } else if (str.equals("room_clear_chatting_history")) {
            com.tencent.mm.ui.base.h.a(this.mController.ylL, getString(R.string.bx1, new Object[]{this.ehM.Oj()}), "", getString(R.string.ou), getString(R.string.or), new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(29878);
                    SingleChatInfoUI.h(SingleChatInfoUI.this);
                    AppMethodBeat.o(29878);
                }
            }, null, (int) R.color.ei);
        } else if (str.equals("room_expose")) {
            intent = new Intent();
            intent.putExtra("k_username", this.talker);
            intent.putExtra("showShare", false);
            intent.putExtra("rawUrl", String.format("https://weixin110.qq.com/security/readtemplate?t=weixin_report/w_type&scene=%d#wechat_redirect", new Object[]{Integer.valueOf(39)}));
            com.tencent.mm.bp.d.b((Context) this, "webview", ".ui.tools.WebViewUI", intent);
        } else if (str.equals("chat_app_brand")) {
            intent = new Intent();
            intent.putExtra("Chat_User", this.talker);
            com.tencent.mm.bp.d.f(this, ".ui.chatting.gallery.AppBrandHistoryListUI", intent);
            com.tencent.mm.plugin.report.service.h.pYm.a(219, 25, 1, true);
        }
        AppMethodBeat.o(29888);
        return false;
    }

    static /* synthetic */ void d(SingleChatInfoUI singleChatInfoUI) {
        AppMethodBeat.i(29894);
        com.tencent.mm.plugin.report.service.h.pYm.X(10170, "1");
        LinkedList linkedList = new LinkedList();
        linkedList.add(singleChatInfoUI.talker);
        linkedList.add(r.Yz());
        String c = ah.c(linkedList, ",");
        Intent intent = new Intent();
        intent.setClass(singleChatInfoUI, SelectContactUI.class);
        intent.putExtra("titile", singleChatInfoUI.getString(R.string.es));
        intent.putExtra("list_type", 0);
        intent.putExtra("list_attr", s.znG);
        intent.putExtra("always_select_contact", c);
        intent.putExtra("scene", 2);
        singleChatInfoUI.startActivity(intent);
        AppMethodBeat.o(29894);
    }

    static /* synthetic */ void h(SingleChatInfoUI singleChatInfoUI) {
        String str;
        AppMethodBeat.i(29896);
        com.tencent.mm.plugin.report.service.h.pYm.e(14553, Integer.valueOf(6), Integer.valueOf(2), singleChatInfoUI.talker);
        isDeleteCancel = false;
        singleChatInfoUI.getString(R.string.tz);
        final ProgressDialog b = com.tencent.mm.ui.base.h.b((Context) singleChatInfoUI, singleChatInfoUI.getString(R.string.un), true, new a());
        if (isDeleteCancel) {
            str = null;
        } else {
            str = com.tencent.mm.pluginsdk.wallet.e.akq(singleChatInfoUI.ehM.field_username);
        }
        if (ah.isNullOrNil(str)) {
            singleChatInfoUI.b(b);
            AppMethodBeat.o(29896);
            return;
        }
        b.dismiss();
        Object[] objArr = new Object[]{str};
        com.tencent.mm.ui.base.h.a(singleChatInfoUI, false, singleChatInfoUI.getString(R.string.fdk, objArr), null, singleChatInfoUI.getString(R.string.c9y), singleChatInfoUI.getString(R.string.ar1), new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.i(29874);
                com.tencent.mm.plugin.report.service.h.pYm.e(14553, Integer.valueOf(6), Integer.valueOf(4), SingleChatInfoUI.this.talker);
                SingleChatInfoUI.isDeleteCancel = true;
                if (SingleChatInfoUI.this.eik) {
                    SingleChatInfoUI.this.finish();
                    AppMethodBeat.o(29874);
                    return;
                }
                LauncherUI instance = LauncherUI.getInstance();
                if (instance != null) {
                    instance.startChatting(SingleChatInfoUI.this.ehM.field_username, null, true);
                }
                AppMethodBeat.o(29874);
            }
        }, new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.i(29875);
                com.tencent.mm.plugin.report.service.h.pYm.e(14553, Integer.valueOf(6), Integer.valueOf(3), SingleChatInfoUI.this.talker);
                b.show();
                SingleChatInfoUI.isDeleteCancel = false;
                SingleChatInfoUI.a(SingleChatInfoUI.this, b);
                AppMethodBeat.o(29875);
            }
        }, -1, R.color.ei);
        AppMethodBeat.o(29896);
    }
}
