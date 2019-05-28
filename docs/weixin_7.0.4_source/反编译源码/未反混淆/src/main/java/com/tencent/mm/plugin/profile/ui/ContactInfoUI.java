package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ah.o;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.p;
import com.tencent.mm.aj.z;
import com.tencent.mm.kernel.i;
import com.tencent.mm.model.ao;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bp;
import com.tencent.mm.model.r;
import com.tencent.mm.model.t;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.messenger.foundation.a.a.m.a;
import com.tencent.mm.plugin.sns.b.n;
import com.tencent.mm.plugin.story.api.AbsStoryGallery;
import com.tencent.mm.plugin.story.api.AbsStoryMuteView;
import com.tencent.mm.plugin.story.api.e;
import com.tencent.mm.plugin.story.api.g;
import com.tencent.mm.plugin.story.g.h;
import com.tencent.mm.plugin.story.model.a.j;
import com.tencent.mm.protocal.protobuf.uy;
import com.tencent.mm.sdk.e.k;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.ac;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.statusbar.c;
import com.tencent.mm.ui.statusbar.d;
import com.tencent.mm.ui.widget.listview.PullDownListView;
import java.io.IOException;

@i
public class ContactInfoUI extends MMPreference implements f, a, g, k.a, b {
    private com.tencent.mm.ui.base.preference.f ehK;
    private ad ehM;
    private String ehq = "";
    private boolean fdb = false;
    private int gwP;
    private String mGZ;
    private com.tencent.mm.pluginsdk.b.a plh;
    private boolean pli;
    private boolean plj;
    private byte[] plk;
    private boolean pll = false;
    String plm = null;
    private String pln = "";
    private PullDownListView plo = null;
    private boolean plp = false;
    private AbsStoryGallery plq = null;
    private AbsStoryMuteView plr = null;
    private boolean pls = false;
    private OnClickListener plt = null;
    private PullDownListView.a plu = new PullDownListView.a() {
        public final void jM(boolean z) {
            AppMethodBeat.i(23340);
            if (ContactInfoUI.this.plq != null) {
                ab.i("MicroMsg.ContactInfoUI", "story_cat onPostOpen");
                ContactInfoUI.this.plq.K(z, true);
                ContactInfoUI.this.mController.hideTitleView();
                ContactInfoUI.b(ContactInfoUI.this);
            }
            AppMethodBeat.o(23340);
        }

        public final void caI() {
            AppMethodBeat.i(23341);
            if (ContactInfoUI.this.plq != null) {
                ab.i("MicroMsg.ContactInfoUI", "story_cat onPostClose");
                ContactInfoUI.this.plq.lr(true);
                ContactInfoUI.this.mController.showTitleView();
                ContactInfoUI.c(ContactInfoUI.this);
            }
            AppMethodBeat.o(23341);
        }

        public final void caJ() {
            AppMethodBeat.i(23342);
            if (ContactInfoUI.this.plq != null) {
                ContactInfoUI.this.plq.cwK();
            }
            AppMethodBeat.o(23342);
        }

        public final void caK() {
            AppMethodBeat.i(23343);
            if (ContactInfoUI.this.plq != null) {
                ContactInfoUI.this.plq.cwL();
            }
            AppMethodBeat.o(23343);
        }

        public final void caL() {
            AppMethodBeat.i(23344);
            ab.i("MicroMsg.ContactInfoUI", "story_cat onMuteIn");
            ContactInfoUI.this.plr.cwM();
            AppMethodBeat.o(23344);
        }

        public final void caM() {
            AppMethodBeat.i(23345);
            ContactInfoUI.this.plr.cwN();
            AppMethodBeat.o(23345);
        }

        public final void AU(int i) {
            AppMethodBeat.i(23346);
            if (ContactInfoUI.this.plq != null) {
                ContactInfoUI.this.plq.EF(i);
            }
            AppMethodBeat.o(23346);
        }

        public final void AV(int i) {
            AppMethodBeat.i(23347);
            if (ContactInfoUI.this.plq != null) {
                ContactInfoUI.this.plq.EG(i);
            }
            AppMethodBeat.o(23347);
        }

        public final void AW(int i) {
        }
    };
    private View plv;
    private View plw;
    private c.a plx;
    private boolean ply = false;
    private boolean sjn = false;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public ContactInfoUI() {
        AppMethodBeat.i(23358);
        AppMethodBeat.o(23358);
    }

    static /* synthetic */ void c(ContactInfoUI contactInfoUI) {
        AppMethodBeat.i(23390);
        contactInfoUI.caE();
        AppMethodBeat.o(23390);
    }

    static /* synthetic */ void j(ContactInfoUI contactInfoUI) {
        AppMethodBeat.i(23391);
        contactInfoUI.caG();
        AppMethodBeat.o(23391);
    }

    public final void caA() {
        AppMethodBeat.i(23359);
        ab.i("MicroMsg.ContactInfoUI", "story_cat storyUINoStory");
        this.pls = false;
        if (!(this.plo == null || this.plo.isVisible)) {
            this.mController.showTitleView();
            caE();
            this.plo.dLf();
        }
        caH();
        AppMethodBeat.o(23359);
    }

    public final void caB() {
        AppMethodBeat.i(23360);
        ab.i("MicroMsg.ContactInfoUI", "story_cat storyUIHasStory");
        this.pls = true;
        if (this.plo != null && this.plo.isVisible) {
            caH();
        }
        AppMethodBeat.o(23360);
    }

    public final void caC() {
        AppMethodBeat.i(23361);
        ab.i("MicroMsg.ContactInfoUI", "story_cat storyUIBackPressed");
        this.plo.dLf();
        AppMethodBeat.o(23361);
    }

    public final int JC() {
        return R.xml.ai;
    }

    private void caD() {
        AppMethodBeat.i(23363);
        if (this.plv == null || !c.zzP) {
            AppMethodBeat.o(23363);
            return;
        }
        c az = c.az(this);
        AnonymousClass4 anonymousClass4 = new c.a() {
            public final void pO(int i) {
                AppMethodBeat.i(23350);
                ContactInfoUI.this.plv.setPadding(0, i, 0, 0);
                d.a(ContactInfoUI.this.getWindow());
                AppMethodBeat.o(23350);
            }
        };
        this.plx = anonymousClass4;
        az.a(anonymousClass4);
        getWindow().getDecorView().requestApplyInsets();
        d.a(getWindow());
        AppMethodBeat.o(23363);
    }

    public void onConfigurationChanged(Configuration configuration) {
        AppMethodBeat.i(23364);
        super.onConfigurationChanged(configuration);
        if (configuration.orientation == 1) {
            this.fdb = false;
        } else if (configuration.orientation == 2) {
            this.fdb = true;
        }
        if (!(this.plo == null || this.plo.isVisible)) {
            this.plo.dLf();
        }
        caH();
        AppMethodBeat.o(23364);
    }

    public void onDestroy() {
        AppMethodBeat.i(23365);
        h hVar = h.scu;
        h.cAs().cZK = 0;
        if (com.tencent.mm.kernel.g.RN().QY()) {
            aw.ZK();
            com.tencent.mm.model.c.XM().b(this);
            aw.ZK();
            com.tencent.mm.model.c.XN().b(this);
        }
        if (this.plh != null) {
            this.plh.biV();
        }
        if (this.plh instanceof com.tencent.mm.plugin.profile.ui.newbizinfo.b) {
            com.tencent.mm.plugin.profile.ui.newbizinfo.b bVar = (com.tencent.mm.plugin.profile.ui.newbizinfo.b) this.plh;
            if (bVar.ehM == null || bVar.pkW == null || bVar.ppN == null) {
                ab.w("MicroMsg.ContactWidgetNewBizInfo", "reportEnd fail, err");
            } else {
                int i;
                bVar.endTime = System.currentTimeMillis();
                String str = bVar.ehM.field_username;
                int i2 = bVar.gwP;
                int i3 = bVar.pkW.field_type;
                long j = bVar.edh;
                long j2 = bVar.endTime;
                if (com.tencent.mm.n.a.jh(bVar.ehM.field_type)) {
                    i = 1;
                } else {
                    i = 0;
                }
                com.tencent.mm.plugin.profile.ui.newbizinfo.c.a.a(str, i2, i3, j, j2, i, bVar.ppN.field_originalArticleCount, bVar.ppN.field_friendSubscribeCount, bVar.pmy != null ? bVar.pmy.size() : 0, com.tencent.mm.plugin.profile.ui.newbizinfo.c.a.cE(bVar.ppN.cbL()), com.tencent.mm.plugin.profile.ui.newbizinfo.c.a.cF(bVar.ppN.cbM()), bVar.ppN.field_decryptUserName);
            }
        }
        if (n.qFx != null) {
            n.qFx.ab(this);
        }
        super.onDestroy();
        com.tencent.mm.kernel.g.RQ();
        com.tencent.mm.kernel.g.RO().eJo.b(273, (f) this);
        if (this.plq != null) {
            this.plq.onDestroy();
        }
        com.tencent.mm.plugin.report.service.h.pYm.e(17283, Integer.valueOf(com.tencent.mm.plugin.profile.c.am(getIntent())), this.ehM.field_username, Integer.valueOf(this.ehM.uin), Boolean.valueOf(this.pls), Boolean.valueOf(this.sjn));
        AppMethodBeat.o(23365);
    }

    public void onResume() {
        AppMethodBeat.i(23366);
        com.tencent.mm.modelstat.d.b(3, "ContactInfoUI" + bJj(), hashCode());
        z.aeR().c(this);
        super.onResume();
        View focusedChild = ((ViewGroup) this.mController.contentView).getFocusedChild();
        if (focusedChild != null) {
            focusedChild.clearFocus();
            ab.i("MicroMsg.ContactInfoUI", "try to clear focus. id:%s", Integer.valueOf(focusedChild.getId()));
        }
        this.plo = (PullDownListView) this.nDp;
        if (this.plq != null) {
            this.plq.onResume();
        }
        if (this.ehK != null) {
            NormalProfileHeaderPreference normalProfileHeaderPreference = (NormalProfileHeaderPreference) this.ehK.aqO("contact_profile_header_normal");
            if (normalProfileHeaderPreference != null) {
                normalProfileHeaderPreference.A(this.pls, this.plw.getHeight());
            }
        }
        if ((this.plh instanceof c) || (this.plh instanceof com.tencent.mm.plugin.profile.ui.newbizinfo.b)) {
            this.plh.a(this.ehK, this.ehM, this.pli, this.gwP);
        }
        AppMethodBeat.o(23366);
    }

    public void onStart() {
        AppMethodBeat.i(23367);
        super.onStart();
        if (this.plq != null) {
            this.plq.onStart();
        }
        AppMethodBeat.o(23367);
    }

    /* Access modifiers changed, original: protected */
    public void onRestart() {
        AppMethodBeat.i(23368);
        super.onRestart();
        this.ply = false;
        AppMethodBeat.o(23368);
    }

    public void onPause() {
        AppMethodBeat.i(23369);
        com.tencent.mm.modelstat.d.b(4, "ContactInfoUI" + bJj(), hashCode());
        z.aeR().d(this);
        super.onPause();
        aw.RS().ae(new Runnable() {
            public final void run() {
                AppMethodBeat.i(23351);
                aw.ZK();
                com.tencent.mm.model.c.Ry().dsb();
                AppMethodBeat.o(23351);
            }
        });
        if (getIntent().getBooleanExtra("key_from_wesport_right_newtips", false)) {
            com.tencent.mm.plugin.r.a.bVt();
            com.tencent.mm.ax.d.u(com.tencent.mm.ax.b.fKF, dyi());
        } else if (getIntent().getBooleanExtra("key_from_wesport_plugin_newtips", false)) {
            com.tencent.mm.plugin.r.a.bVt();
            com.tencent.mm.ax.d.u(com.tencent.mm.ax.b.fKD, dyi());
        }
        caE();
        if (this.plq != null) {
            this.plq.onPause();
        }
        if ((this.plh instanceof c) || (this.plh instanceof com.tencent.mm.plugin.profile.ui.newbizinfo.b)) {
            this.plh.biV();
        }
        AppMethodBeat.o(23369);
    }

    public void onStop() {
        AppMethodBeat.i(23370);
        super.onStop();
        if (this.plq != null) {
            this.plq.onStop();
        }
        AppMethodBeat.o(23370);
    }

    public final String bJj() {
        AppMethodBeat.i(23371);
        String str;
        if (this.ehM == null || ((int) this.ehM.ewQ) == 0 || bo.isNullOrNil(this.ehM.field_username)) {
            str = "";
            AppMethodBeat.o(23371);
            return str;
        }
        ab.i("MicroMsg.ContactInfoUI", "getIdentityString %s", this.ehM.field_username);
        if (com.tencent.mm.aj.f.kq(this.ehM.field_username)) {
            str = "_EnterpriseChat";
            AppMethodBeat.o(23371);
            return str;
        } else if (com.tencent.mm.aj.f.rc(this.ehM.field_username)) {
            str = "_EnterpriseFatherBiz";
            AppMethodBeat.o(23371);
            return str;
        } else if (com.tencent.mm.aj.f.rb(this.ehM.field_username)) {
            str = "_EnterpriseChildBiz";
            AppMethodBeat.o(23371);
            return str;
        } else if (this.ehM.dsf()) {
            str = "_bizContact";
            AppMethodBeat.o(23371);
            return str;
        } else if (t.kH(this.ehM.field_username)) {
            str = "_chatroom";
            AppMethodBeat.o(23371);
            return str;
        } else if (t.mR(this.ehM.field_username)) {
            str = "_bottle";
            AppMethodBeat.o(23371);
            return str;
        } else if (t.mS(this.ehM.field_username)) {
            str = "_QQ";
            AppMethodBeat.o(23371);
            return str;
        } else if (t.nI(this.ehM.field_username)) {
            str = "_" + this.ehM.field_username;
            AppMethodBeat.o(23371);
            return str;
        } else {
            str = "";
            AppMethodBeat.o(23371);
            return str;
        }
    }

    private void UO(String str) {
        AppMethodBeat.i(23373);
        if (t.mU(this.ehM.field_username)) {
            this.plh = com.tencent.mm.bp.d.ac(this, "sport");
        } else if (t.nc(this.ehM.field_username)) {
            this.plh = com.tencent.mm.bp.d.ac(this, "qqmail");
        } else if (t.nd(this.ehM.field_username)) {
            this.plh = new e(this);
        } else if (t.ne(this.ehM.field_username)) {
            this.plh = com.tencent.mm.bp.d.ac(this, "tmessage");
        } else if (t.nq(this.ehM.field_username)) {
            this.plh = new com.tencent.mm.plugin.topstory.ui.widget.a(this);
        } else if (t.mW(this.ehM.field_username)) {
            this.plh = new h(this);
        } else if (t.nk(this.ehM.field_username)) {
            this.plh = new m(this);
        } else if (ad.mR(this.ehM.field_username)) {
            this.plh = new d(this);
        } else if (t.nm(this.ehM.field_username)) {
            this.plh = com.tencent.mm.bp.d.ac(this, "nearby");
        } else if (t.nn(this.ehM.field_username)) {
            this.plh = com.tencent.mm.bp.d.ac(this, "shake");
        } else if (t.no(this.ehM.field_username)) {
            this.plh = new j(this);
        } else if (t.np(this.ehM.field_username)) {
            this.plh = com.tencent.mm.bp.d.I(this, "readerapp", "widget_type_news");
        } else if (t.nx(this.ehM.field_username)) {
            this.plh = com.tencent.mm.bp.d.I(this, "readerapp", "widget_type_weibo");
        } else if (t.nh(this.ehM.field_username)) {
            this.plh = new f(this);
        } else if (t.ni(this.ehM.field_username)) {
            this.plh = com.tencent.mm.bp.d.ac(this, "masssend");
        } else if (t.nj(this.ehM.field_username)) {
            this.plh = new g(this);
        } else if (this.ehM.dsf() || getIntent().getBooleanExtra("key_use_new_contact_profile", false)) {
            uy uyVar;
            try {
                uyVar = this.plk == null ? null : (uy) new uy().parseFrom(this.plk);
            } catch (IOException e) {
                ab.printErrStackTrace("MicroMsg.ContactInfoUI", e, "", new Object[0]);
                uyVar = null;
            }
            ab.i("MicroMsg.ContactInfoUI", "username:%s, isUseNewProfileUI:%b", this.ehM.field_username, Boolean.valueOf(a(this.ehM.field_username, uyVar)));
            if (a(this.ehM.field_username, uyVar)) {
                com.tencent.mm.plugin.profile.ui.newbizinfo.b bVar = new com.tencent.mm.plugin.profile.ui.newbizinfo.b(this, str, uyVar);
                if (!bo.isNullOrNil(this.mGZ)) {
                    bVar.mGZ = this.mGZ;
                }
                this.plh = bVar;
            } else {
                c cVar = new c(this, str, uyVar);
                if (!bo.isNullOrNil(this.mGZ)) {
                    cVar.mGZ = this.mGZ;
                }
                this.plh = cVar;
            }
        } else if (t.nt(this.ehM.field_username)) {
            this.plh = new n(this);
        } else if (t.nu(this.ehM.field_username)) {
            this.plh = new i(this);
        } else if (t.mV(this.ehM.field_username)) {
            this.plh = new com.tencent.mm.plugin.downloader_app.e.a(this);
        } else {
            this.plh = new com.tencent.mm.plugin.profile.a(this);
            caF();
        }
        if (this.plh != null) {
            this.plh.a(this.ehK, this.ehM, this.pli, this.gwP);
            com.tencent.mm.plugin.account.friend.a.a vT = com.tencent.mm.plugin.account.a.getAddrUploadStg().vT(this.ehM.field_username);
            String str2 = "";
            if (vT != null) {
                str2 = bo.nullAsNil(vT.apG()).replace(" ", "");
            }
            if (!this.ply && com.tencent.mm.n.a.jh(this.ehM.field_type) && (this.plh instanceof k)) {
                int i;
                int length = (bo.isNullOrNil(this.ehM.dur) ? 0 : this.ehM.dur.split(",").length) + (bo.isNullOrNil(str2) ? 0 : 1);
                com.tencent.mm.plugin.report.service.h hVar = com.tencent.mm.plugin.report.service.h.pYm;
                Object[] objArr = new Object[4];
                objArr[0] = this.ehM.field_username;
                objArr[1] = Integer.valueOf(1);
                if (bo.isNullOrNil(str2)) {
                    i = 0;
                } else {
                    i = 1;
                }
                objArr[2] = Integer.valueOf(i);
                objArr[3] = Integer.valueOf(length >= 5 ? 5 : length);
                hVar.e(12040, objArr);
                this.ply = true;
            }
            if (!((this.plh instanceof k) || (this.plh instanceof c) || (this.plh instanceof com.tencent.mm.plugin.profile.ui.newbizinfo.b))) {
                aw.ZK();
                str2 = (String) com.tencent.mm.model.c.Ry().get(ac.a.USERINFO_SETTING_PLUGIN_SWITCH_NAMES_STRING, (Object) "");
                if (str2.contains(this.ehM.field_username)) {
                    Object replaceAll = str2.replaceAll(this.ehM.field_username + ",*", "");
                    aw.ZK();
                    com.tencent.mm.model.c.Ry().set(ac.a.USERINFO_SETTING_PLUGIN_SWITCH_NAMES_STRING, replaceAll);
                    ab.i("MicroMsg.ContactInfoUI", "mark plugin read, userName:%s, newVal:%s", this.ehM.field_username, replaceAll);
                    if (bo.isNullOrNil(replaceAll)) {
                        com.tencent.mm.x.c.PK().y(262158, false);
                    }
                }
            }
        }
        if (this.ehK != null) {
            NormalProfileHeaderPreference normalProfileHeaderPreference = (NormalProfileHeaderPreference) this.ehK.aqO("contact_profile_header_normal");
            if (normalProfileHeaderPreference != null) {
                normalProfileHeaderPreference.A(this.pls, this.plw.getHeight());
            }
        }
        AppMethodBeat.o(23373);
    }

    private boolean a(String str, uy uyVar) {
        AppMethodBeat.i(23374);
        if (!ah.doB().getBoolean("use_new_profile", true)) {
            AppMethodBeat.o(23374);
            return false;
        } else if (t.nQ(str)) {
            AppMethodBeat.o(23374);
            return false;
        } else if (t.nl(str)) {
            AppMethodBeat.o(23374);
            return false;
        } else if (t.nw(str)) {
            AppMethodBeat.o(23374);
            return false;
        } else if (com.tencent.mm.aj.f.qY(str)) {
            AppMethodBeat.o(23374);
            return true;
        } else if (com.tencent.mm.aj.f.qZ(str)) {
            AppMethodBeat.o(23374);
            return true;
        } else {
            if (uyVar != null) {
                com.tencent.mm.aj.d dVar = new com.tencent.mm.aj.d();
                dVar.field_extInfo = uyVar.gvc;
                dVar.field_type = dVar.cJ(false).getServiceType();
                if (dVar.adN()) {
                    AppMethodBeat.o(23374);
                    return true;
                } else if (dVar.adM()) {
                    AppMethodBeat.o(23374);
                    return true;
                }
            }
            if (getIntent().getBooleanExtra("key_use_new_contact_profile", false)) {
                AppMethodBeat.o(23374);
                return true;
            } else if (com.tencent.mm.aj.f.rc(this.ehM.field_username)) {
                AppMethodBeat.o(23374);
                return false;
            } else if (com.tencent.mm.aj.f.rb(this.ehM.field_username)) {
                AppMethodBeat.o(23374);
                return false;
            } else if (((int) this.ehM.ewQ) <= 0 && this.ehM.dsf() && (this.gwP == 17 || this.gwP == 41)) {
                AppMethodBeat.o(23374);
                return true;
            } else {
                AppMethodBeat.o(23374);
                return false;
            }
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(23375);
        super.onActivityResult(i, i2, intent);
        if (intent != null) {
            getIntent().putExtra("CONTACT_INFO_UI_SOURCE", intent.getIntExtra("CONTACT_INFO_UI_SOURCE", -1));
        }
        if (this.plh != null) {
            this.plh.onActivityResult(i, i2, intent);
        }
        AppMethodBeat.o(23375);
    }

    public final void a(int i, com.tencent.mm.sdk.e.n nVar, Object obj) {
        AppMethodBeat.i(23377);
        if (obj == null || !(obj instanceof String)) {
            ab.i("MicroMsg.ContactInfoUI", "onNotifyChange obj not String event:%d stg:%s obj:%s", Integer.valueOf(i), nVar, obj);
            AppMethodBeat.o(23377);
            return;
        }
        a((String) obj, null);
        AppMethodBeat.o(23377);
    }

    public final void a(final String str, m mVar) {
        AppMethodBeat.i(23378);
        new ak().post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(23353);
                ab.i("MicroMsg.ContactInfoUI", "onNotifyChange verify:%b, contact.user:%s, notify.user:%s", Boolean.valueOf(ContactInfoUI.this.plj), ContactInfoUI.this.ehM.field_username, str);
                if (!(ContactInfoUI.this.ehM == null || bo.isNullOrNil(ContactInfoUI.this.ehM.field_username) || (!ContactInfoUI.this.ehM.field_username.equals(str) && !ContactInfoUI.this.ehM.field_username.equals(ad.aoC(str))))) {
                    if (ContactInfoUI.this.plh != null) {
                        ContactInfoUI.this.plh.biV();
                        ContactInfoUI.this.ehK.removeAll();
                    }
                    ContactInfoUI.this.initView();
                }
                AppMethodBeat.o(23353);
            }
        });
        AppMethodBeat.o(23378);
    }

    public final void a(final bv bvVar) {
        AppMethodBeat.i(23379);
        al.d(new Runnable() {
            public final void run() {
                AppMethodBeat.i(23354);
                if (!(ContactInfoUI.this.ehM == null || bvVar == null || bo.isNullOrNil(ContactInfoUI.this.ehM.field_username) || !ContactInfoUI.this.ehM.field_username.equals(bvVar.field_encryptUsername) || t.nJ(ContactInfoUI.this.ehM.field_username))) {
                    ContactInfoUI.this.ehM.iz(bvVar.field_conRemark);
                    ContactInfoUI.this.getIntent().putExtra("Contact_User", ContactInfoUI.this.ehM.field_username);
                    if (ContactInfoUI.this.plh != null) {
                        ContactInfoUI.this.plh.biV();
                        ContactInfoUI.this.ehK.removeAll();
                    }
                    ContactInfoUI.this.initView();
                }
                AppMethodBeat.o(23354);
            }
        });
        AppMethodBeat.o(23379);
    }

    private void fD(String str, String str2) {
        AppMethodBeat.i(23380);
        if (this.ehM == null) {
            ab.e("MicroMsg.ContactInfoUI", "contact = null");
            AppMethodBeat.o(23380);
            return;
        }
        bv RB;
        if (!bo.isNullOrNil(str2)) {
            aw.ZK();
            RB = com.tencent.mm.model.c.XN().RB(str2);
            if (!(RB == null || bo.isNullOrNil(RB.field_encryptUsername))) {
                this.ehM.iz(RB.field_conRemark);
                AppMethodBeat.o(23380);
                return;
            }
        }
        if (!bo.isNullOrNil(str)) {
            aw.ZK();
            RB = com.tencent.mm.model.c.XN().RB(str);
            if (!(RB == null || bo.isNullOrNil(RB.field_encryptUsername))) {
                this.ehM.iz(RB.field_conRemark);
                AppMethodBeat.o(23380);
                return;
            }
        }
        AppMethodBeat.o(23380);
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        AppMethodBeat.i(23381);
        if (iArr == null || iArr.length <= 0) {
            ab.i("MicroMsg.ContactInfoUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", Integer.valueOf(i), Long.valueOf(Thread.currentThread().getId()));
            AppMethodBeat.o(23381);
            return;
        }
        ab.i("MicroMsg.ContactInfoUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId()));
        NormalUserFooterPreference normalUserFooterPreference;
        switch (i) {
            case 19:
                if (iArr[0] == 0) {
                    normalUserFooterPreference = (NormalUserFooterPreference) this.ehK.aqO("contact_info_footer_normal");
                    if (normalUserFooterPreference != null) {
                        normalUserFooterPreference.cbm();
                    }
                    AppMethodBeat.o(23381);
                    return;
                }
                int i2 = "android.permission.CAMERA".equals(strArr[0]) ? R.string.dbs : R.string.dc0;
                if (iArr[0] != 0) {
                    com.tencent.mm.ui.base.h.a((Context) this, getString(i2), getString(R.string.dc8), getString(R.string.ckr), getString(R.string.abx), false, new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.i(23355);
                            dialogInterface.dismiss();
                            ContactInfoUI.this.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                            AppMethodBeat.o(23355);
                        }
                    }, new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.i(23356);
                            dialogInterface.dismiss();
                            AppMethodBeat.o(23356);
                        }
                    });
                }
                AppMethodBeat.o(23381);
                return;
            case 82:
                if (iArr[0] != 0) {
                    com.tencent.mm.ui.base.h.a((Context) this, getString(R.string.dby), getString(R.string.dc8), getString(R.string.ckr), getString(R.string.abx), false, new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.i(23357);
                            ContactInfoUI.this.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                            AppMethodBeat.o(23357);
                        }
                    }, null);
                    break;
                }
                normalUserFooterPreference = (NormalUserFooterPreference) this.ehK.aqO("contact_info_footer_normal");
                if (normalUserFooterPreference != null) {
                    normalUserFooterPreference.cbl();
                }
                AppMethodBeat.o(23381);
                return;
        }
        AppMethodBeat.o(23381);
    }

    private void caE() {
        AppMethodBeat.i(23382);
        if (com.tencent.mm.compatible.util.d.iW(19)) {
            getWindow().clearFlags(201327616);
            AppMethodBeat.o(23382);
            return;
        }
        getWindow().clearFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
        AppMethodBeat.o(23382);
    }

    private void caF() {
        AppMethodBeat.i(23383);
        if (!((e) com.tencent.mm.kernel.g.M(e.class)).isShowStoryCheck()) {
            AppMethodBeat.o(23383);
        } else if (this.plp) {
            AppMethodBeat.o(23383);
        } else {
            ab.i("MicroMsg.ContactInfoUI", "setupStory %s stack %s", this, bo.dpG().toString());
            this.plp = true;
            this.plo = (PullDownListView) this.nDp;
            this.plo.setBackgroundResource(R.drawable.u3);
            this.plo.zRr = this.plu;
            int i = (-com.tencent.mm.ui.ak.hy(this.mController.ylL).y) / 10;
            RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.dab);
            LayoutParams layoutParams = new LayoutParams(-1, com.tencent.mm.ui.ak.hy(this.mController.ylL).y);
            layoutParams.topMargin = i;
            layoutParams.bottomMargin = -com.tencent.mm.ui.ak.fr(this.mController.ylL);
            if (this.ehM.field_username.equals(r.Yz())) {
                this.plq = ((e) com.tencent.mm.kernel.g.M(e.class)).getStoryUIFactory().a(this, com.tencent.mm.plugin.story.api.m.a.SelfGallery, this.ehq);
            } else {
                this.plq = ((e) com.tencent.mm.kernel.g.M(e.class)).getStoryUIFactory().a(this, com.tencent.mm.plugin.story.api.m.a.ProfileGallery, this.ehq);
            }
            this.plo.x(this.plq, com.tencent.mm.bz.a.am(this.mController.ylL, R.dimen.a7h), i);
            this.plq.setStoryBrowseUIListener(this);
            this.plq.setDataSeed(this.ehM.field_username);
            this.plq.a(this.plo);
            relativeLayout.addView(this.plq, 0, layoutParams);
            com.tencent.mm.kernel.g.RQ();
            this.plr = ((e) com.tencent.mm.kernel.g.M(e.class)).getStoryUIFactory().eV(this);
            LayoutParams layoutParams2 = new LayoutParams(com.tencent.mm.bz.a.am(this.mController.ylL, R.dimen.a7g), com.tencent.mm.bz.a.am(this.mController.ylL, R.dimen.a7g));
            layoutParams2.addRule(9);
            layoutParams2.addRule(12);
            relativeLayout.addView(this.plr, 0, layoutParams2);
            this.plo.setMuteView(this.plr);
            this.plo.setNavigationBarHeight(com.tencent.mm.ui.ak.fr(this.mController.ylL));
            this.plt = new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(23348);
                    ab.i("MicroMsg.ContactInfoUI", "onClick: NormalProfileHeaderPreference");
                    ContactInfoUI.j(ContactInfoUI.this);
                    AppMethodBeat.o(23348);
                }
            };
            h hVar = h.scu;
            h.cAs().cYQ = 3;
            AppMethodBeat.o(23383);
        }
    }

    public void onSceneEnd(int i, int i2, String str, com.tencent.mm.ai.m mVar) {
        AppMethodBeat.i(23384);
        ab.d("MicroMsg.ContactInfoUI", "onSceneEnd errType[%s] errCode[%s] errMsg[%s] sceneType[%s]", Integer.valueOf(i), Integer.valueOf(i2), str, Integer.valueOf(mVar.getType()));
        if (273 == mVar.getType() && this.ehM != null && (this.plh instanceof com.tencent.mm.plugin.profile.a) && bo.isEqual(this.ehM.field_username, ((j) mVar).userName)) {
            int i3 = ((j) mVar).cvd;
            com.tencent.mm.plugin.story.h.a.a aVar = com.tencent.mm.plugin.story.h.a.sdm;
            if (i3 == com.tencent.mm.plugin.story.h.a.sdl) {
                i3 = 1;
            } else {
                i3 = 0;
            }
            if (i3 != 0) {
                boolean z = (i == 0 || i == 4) && i2 != com.tencent.mm.plugin.appbrand.jsapi.wifi.e.CTRL_INDEX;
                this.sjn = z;
            }
        }
        AppMethodBeat.o(23384);
    }

    public void onBackPressed() {
        AppMethodBeat.i(23385);
        if ((this.plq == null || !this.plq.wY()) && !getSupportFragmentManager().isDestroyed()) {
            super.onBackPressed();
        }
        AppMethodBeat.o(23385);
    }

    private void caG() {
        AppMethodBeat.i(23386);
        if (this.fdb) {
            com.tencent.mm.ui.base.t.makeText(this.mController.ylL, getResources().getString(R.string.et4), 0).show();
            AppMethodBeat.o(23386);
            return;
        }
        if (this.pls && this.plo != null) {
            this.plo.dLg();
        }
        AppMethodBeat.o(23386);
    }

    private void caH() {
        boolean z = true;
        AppMethodBeat.i(23387);
        ab.i("MicroMsg.ContactInfoUI", "updateUIByStory: %s %s", Boolean.valueOf(this.plp), Boolean.valueOf(this.pls));
        if (!this.pls || this.fdb) {
            xE(this.mController.ylL.getResources().getColor(R.color.d4));
            setMMTitle("");
            if (this.plo != null) {
                this.plo.setBackgroundResource(R.drawable.u6);
                this.plo.setSupportOverscroll(false);
            }
        } else {
            caD();
            xE(this.mController.ylL.getResources().getColor(R.color.a3p));
            setMMTitle("");
            if (this.plo != null) {
                this.plo.setBackgroundResource(R.drawable.u4);
                this.plo.setSupportOverscroll(true);
            }
            if (this.plw != null) {
                this.plw.setOnClickListener(new OnClickListener() {
                    public final void onClick(View view) {
                        AppMethodBeat.i(23349);
                        ab.i("MicroMsg.ContactInfoUI", "onClick: actionBarClick action_bar_root");
                        ContactInfoUI.j(ContactInfoUI.this);
                        AppMethodBeat.o(23349);
                    }
                });
            }
        }
        if (this.ehK != null) {
            NormalProfileHeaderPreference normalProfileHeaderPreference = (NormalProfileHeaderPreference) this.ehK.aqO("contact_profile_header_normal");
            if (normalProfileHeaderPreference != null) {
                if (!this.pls || this.fdb) {
                    z = false;
                }
                normalProfileHeaderPreference.A(z, this.plw.getHeight());
            }
        }
        AppMethodBeat.o(23387);
    }

    public void finish() {
        AppMethodBeat.i(23388);
        h hVar = h.scu;
        h.cAs().cYQ = 0;
        super.finish();
        AppMethodBeat.o(23388);
    }

    /* JADX WARNING: Removed duplicated region for block: B:7:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x00b1  */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x004e  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x00b3  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x00a7  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onCreate(Bundle bundle) {
        boolean z;
        View decorView;
        AppMethodBeat.i(23362);
        aw.ZK();
        ad aoO = com.tencent.mm.model.c.XM().aoO(bo.nullAsNil(getIntent().getStringExtra("Contact_User")));
        if (aoO != null) {
            com.tencent.mm.kernel.g.RQ();
            if (((e) com.tencent.mm.kernel.g.M(e.class)).isStoryExist(aoO.field_username)) {
                this.pls = true;
                if (this.pls) {
                    this.ylm = true;
                }
                super.onCreate(bundle);
                if (getResources().getConfiguration().orientation != 2) {
                    z = true;
                } else {
                    z = false;
                }
                this.fdb = z;
                this.plv = findViewById(R.id.k0);
                this.plw = this.plv.findViewById(R.id.jw);
                caH();
                decorView = getWindow().getDecorView();
                decorView.setSystemUiVisibility((decorView.getSystemUiVisibility() | WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) | 256);
                ab.i("MicroMsg.ContactInfoUI", "onCreate MMCore.accHasReady[%b]", Boolean.valueOf(aw.RK()));
                this.plm = getIntent().getStringExtra("Contact_Search_Mobile");
                if (com.tencent.mm.kernel.g.RN().QY()) {
                    finish();
                    AppMethodBeat.o(23362);
                    return;
                }
                aw.ZK();
                com.tencent.mm.model.c.XM().a(this);
                aw.ZK();
                com.tencent.mm.model.c.XN().a(this);
                initView();
                dyb();
                if (this.plh instanceof com.tencent.mm.plugin.profile.ui.newbizinfo.b) {
                    com.tencent.mm.plugin.profile.ui.newbizinfo.b bVar = (com.tencent.mm.plugin.profile.ui.newbizinfo.b) this.plh;
                    if (bVar.ehM == null || bVar.pkW == null) {
                        ab.w("MicroMsg.ContactWidgetNewBizInfo", "reportStart fail, err");
                    } else {
                        bVar.edh = System.currentTimeMillis();
                        com.tencent.mm.plugin.profile.ui.newbizinfo.c.a.a(bVar.ehM.field_username, bVar.gwP, bVar.pkW.field_type, bVar.edh, com.tencent.mm.n.a.jh(bVar.ehM.field_type) ? 1 : 0);
                    }
                }
                com.tencent.mm.plugin.report.service.h.pYm.e(16055, Integer.valueOf(com.tencent.mm.plugin.profile.c.am(getIntent())), Integer.valueOf(1));
                h hVar = h.scu;
                h.cAs().cZK = (long) com.tencent.mm.plugin.profile.c.am(getIntent());
                com.tencent.mm.kernel.g.RQ();
                com.tencent.mm.kernel.g.RO().eJo.a(273, (f) this);
                AppMethodBeat.o(23362);
                return;
            }
        }
        this.pls = false;
        if (this.pls) {
        }
        super.onCreate(bundle);
        if (getResources().getConfiguration().orientation != 2) {
        }
        this.fdb = z;
        this.plv = findViewById(R.id.k0);
        this.plw = this.plv.findViewById(R.id.jw);
        caH();
        decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility((decorView.getSystemUiVisibility() | WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) | 256);
        ab.i("MicroMsg.ContactInfoUI", "onCreate MMCore.accHasReady[%b]", Boolean.valueOf(aw.RK()));
        this.plm = getIntent().getStringExtra("Contact_Search_Mobile");
        if (com.tencent.mm.kernel.g.RN().QY()) {
        }
    }

    public final void initView() {
        String nullAsNil;
        String str;
        Object obj;
        boolean z;
        int i;
        AppMethodBeat.i(23372);
        this.ehK = this.yCw;
        this.ehK.removeAll();
        this.gwP = getIntent().getIntExtra("Contact_Scene", 9);
        this.mGZ = getIntent().getStringExtra("Verify_ticket");
        this.pli = getIntent().getBooleanExtra("Chat_Readonly", false);
        this.plj = getIntent().getBooleanExtra("User_Verify", false);
        this.ehq = getIntent().getStringExtra("Contact_ChatRoomId");
        String nullAsNil2 = bo.nullAsNil(getIntent().getStringExtra("Contact_User"));
        String nullAsNil3 = bo.nullAsNil(getIntent().getStringExtra("Contact_Alias"));
        String nullAsNil4 = bo.nullAsNil(getIntent().getStringExtra("Contact_Encryptusername"));
        if (nullAsNil2.endsWith("@stranger")) {
            nullAsNil4 = nullAsNil2;
        }
        aw.ZK();
        this.ehM = com.tencent.mm.model.c.XM().aoO(nullAsNil2);
        if (this.ehM != null) {
            this.ehM.xXc = nullAsNil2;
        }
        com.tencent.mm.plugin.profile.b.gkF.a(this.ehM);
        String stringExtra = getIntent().getStringExtra("Contact_Nick");
        int intExtra = getIntent().getIntExtra("Contact_Sex", 0);
        String stringExtra2 = getIntent().getStringExtra("Contact_Province");
        String stringExtra3 = getIntent().getStringExtra("Contact_City");
        String stringExtra4 = getIntent().getStringExtra("Contact_Signature");
        int intExtra2 = getIntent().getIntExtra("Contact_VUser_Info_Flag", 0);
        String stringExtra5 = getIntent().getStringExtra("Contact_VUser_Info");
        String stringExtra6 = getIntent().getStringExtra("Contact_Distance");
        int intExtra3 = getIntent().getIntExtra("Contact_KWeibo_flag", 0);
        String stringExtra7 = getIntent().getStringExtra("Contact_KWeibo");
        String stringExtra8 = getIntent().getStringExtra("Contact_KWeiboNick");
        String stringExtra9 = getIntent().getStringExtra("Contact_KFacebookName");
        long longExtra = getIntent().getLongExtra("Contact_KFacebookId", 0);
        this.pln = getIntent().getStringExtra("Contact_BrandIconURL");
        String stringExtra10 = getIntent().getStringExtra("Contact_RegionCode");
        this.plk = getIntent().getByteArrayExtra("Contact_customInfo");
        int intExtra4 = getIntent().getIntExtra("Contact_Ext_Flag", 0);
        boolean booleanExtra = getIntent().getBooleanExtra("force_get_contact", false);
        ab.i("MicroMsg.ContactInfoUI", "dkverify forceAddContact:%s  user:%s  roomid:%s ", Boolean.valueOf(booleanExtra), nullAsNil2, this.ehq);
        if (booleanExtra) {
            ab.d("MicroMsg.ContactInfoUI", "initView, forceAddContact, user = ".concat(String.valueOf(nullAsNil2)));
            if (this.ehM == null || !com.tencent.mm.n.a.jh(this.ehM.field_type)) {
                ao.a.flu.ai(nullAsNil2, "");
            } else {
                ao.a.flu.ai(nullAsNil2, this.ehq);
            }
        }
        if ((this.ehM == null || ((int) this.ehM.ewQ) == 0) && ad.aox(nullAsNil2) && this.gwP != 15) {
            nullAsNil = bo.nullAsNil(getIntent().getStringExtra(com.tencent.mm.ui.e.b.yfT));
            if (bo.isNullOrNil(nullAsNil)) {
                nullAsNil = this.mGZ;
            }
            com.tencent.mm.kernel.g.RO().eJo.a(new com.tencent.mm.openim.b.h(nullAsNil2, bo.nullAsNil(this.ehq), nullAsNil), 0);
        }
        if (this.ehM != null && ((int) this.ehM.ewQ) > 0 && (!t.nJ(this.ehM.field_username) || (ad.aow(this.ehM.field_username) && !t.mX(this.ehM.field_username)))) {
            if (this.ehM.dsi() && ad.aox(this.ehM.field_username)) {
                nullAsNil = bo.nullAsNil(getIntent().getStringExtra(com.tencent.mm.ui.e.b.yfT));
                if (bo.isNullOrNil(nullAsNil)) {
                    nullAsNil = this.mGZ;
                }
                p pVar = com.tencent.mm.kernel.g.RO().eJo;
                String str2 = this.ehM.field_username;
                if (com.tencent.mm.n.a.jh(this.ehM.field_type)) {
                    str = "";
                } else {
                    str = bo.nullAsNil(this.ehq);
                }
                pVar.a(new com.tencent.mm.openim.b.h(str2, str, nullAsNil), 0);
            } else {
                com.tencent.mm.aj.d qX = com.tencent.mm.aj.f.qX(this.ehM.field_username);
                obj = (this.ehM.dsf() && com.tencent.mm.aj.a.adG()) ? 1 : null;
                if (qX == null || (qX.adJ() && obj == null)) {
                    ab.d("MicroMsg.ContactInfoUI", "update contact, verifyFlag %d.", Integer.valueOf(intExtra2));
                    ao.a.flu.ai(this.ehM.field_username, com.tencent.mm.n.a.jh(this.ehM.field_type) ? "" : this.ehq);
                    com.tencent.mm.ah.b.pY(this.ehM.field_username);
                } else if (this.ehM.dsi() && obj == null) {
                    ab.d("MicroMsg.ContactInfoUI", "update contact, last check time=%d", Integer.valueOf(this.ehM.duj));
                    ao.b bVar = ao.a.flu;
                    String str3 = this.ehM.field_username;
                    if (com.tencent.mm.n.a.jh(this.ehM.field_type)) {
                        nullAsNil = "";
                    } else {
                        nullAsNil = this.ehq;
                    }
                    bVar.ai(str3, nullAsNil);
                    com.tencent.mm.ah.b.pY(this.ehM.field_username);
                }
            }
        }
        int intExtra5 = getIntent().getIntExtra("Contact_verify_Scene", 9);
        getIntent().getIntExtra("key_add_contact_match_type", 0);
        String stringExtra11 = getIntent().getStringExtra("key_add_contact_openim_appid");
        int intExtra6 = getIntent().getIntExtra("key_add_contact_custom_detail_visible", 0);
        String stringExtra12 = getIntent().getStringExtra("key_add_contact_custom_detail");
        getIntent().getStringExtra("key_add_contact_desc_wording_id");
        getIntent().getStringExtra("key_add_contact_desc_icon");
        if (this.ehM == null || ((int) this.ehM.ewQ) == 0 || bo.nullAsNil(this.ehM.field_username).length() <= 0) {
            this.ehM = new ad();
            this.ehM.setUsername(nullAsNil2);
            this.ehM.iy(nullAsNil3);
            this.ehM.iB(stringExtra);
            this.ehM.iC(getIntent().getStringExtra("Contact_PyInitial"));
            this.ehM.iD(getIntent().getStringExtra("Contact_QuanPin"));
            this.ehM.hA(intExtra);
            this.ehM.iR(stringExtra2);
            this.ehM.iS(stringExtra3);
            this.ehM.iQ(stringExtra4);
            this.ehM.hw(intExtra2);
            this.ehM.iV(stringExtra5);
            this.ehM.iT(stringExtra6);
            this.ehM.hG(intExtra5);
            this.ehM.iU(stringExtra7);
            this.ehM.hv(intExtra3);
            this.ehM.iE(stringExtra8);
            this.ehM.eC(longExtra);
            this.ehM.iL(stringExtra9);
            this.ehM.iW(stringExtra10);
            this.ehM.hJ(intExtra4);
            if (!bo.isNullOrNil(this.plm) && this.gwP == 15) {
                aw.ZK();
                bv RB = com.tencent.mm.model.c.XN().RB(nullAsNil2);
                bv bvVar = new bv(nullAsNil2);
                bvVar.field_conRemark = RB.field_conRemark;
                bvVar.field_conDescription = RB.field_conDescription;
                bvVar.field_contactLabels = RB.field_contactLabels;
                bvVar.field_conPhone = this.plm;
                aw.ZK();
                com.tencent.mm.model.c.XN().a(bvVar);
                this.plm = null;
            }
            this.ehM.jf(stringExtra12);
            this.ehM.hK(intExtra6);
            this.ehM.iK(stringExtra11);
        } else {
            if (this.ehM.dtS == 0) {
                this.ehM.hA(intExtra);
            }
            if (!(stringExtra2 == null || stringExtra2.equals(""))) {
                this.ehM.iR(stringExtra2);
            }
            if (!(stringExtra3 == null || stringExtra3.equals(""))) {
                this.ehM.iS(stringExtra3);
            }
            if (stringExtra10 != null) {
                if (!stringExtra10.equals("")) {
                    this.ehM.iW(stringExtra10);
                }
            }
            if (!(!bo.isNullOrNil(this.ehM.signature) || stringExtra4 == null || stringExtra4.equals(""))) {
                this.ehM.iQ(stringExtra4);
            }
            if (intExtra2 != 0) {
                this.ehM.hw(intExtra2);
            }
            if (!(!bo.isNullOrNil(this.ehM.duh) || stringExtra5 == null || stringExtra5.equals(""))) {
                this.ehM.iV(stringExtra5);
            }
            if (!(!bo.isNullOrNil(this.ehM.field_nickname) || stringExtra == null || stringExtra.equals(""))) {
                this.ehM.iB(stringExtra);
            }
            ab.i("MicroMsg.ContactInfoUI", "searchMobilePhone:%s", bo.nullAsNil(this.plm));
            if (!bo.isNullOrNil(this.plm) && this.gwP == 15) {
                obj = 1;
                String str4 = this.ehM.dur;
                if (str4 != null) {
                    for (String nullAsNil5 : this.ehM.dur.split(",")) {
                        if (nullAsNil5.equals(this.plm)) {
                            obj = null;
                        } else {
                            obj = 1;
                        }
                    }
                }
                if (obj != null) {
                    this.ehM.jd(str4 + this.plm + ",");
                    this.plm = null;
                }
                ab.i("MicroMsg.ContactInfoUI", "contact PhoneList:%s", bo.nullAsNil(this.ehM.dur));
                this.ehM.setSource(15);
            }
            this.ehM.iT(stringExtra6);
            this.ehM.hG(intExtra5);
            this.ehM.eC(longExtra);
            this.ehM.iL(stringExtra9);
            if (!com.tencent.mm.n.a.jh(this.ehM.field_type)) {
                if (!bo.isNullOrNil(nullAsNil3)) {
                    this.ehM.iy(nullAsNil3);
                }
                if (!bo.isNullOrNil(stringExtra)) {
                    this.ehM.iB(stringExtra);
                }
                nullAsNil5 = getIntent().getStringExtra("Contact_PyInitial");
                if (!bo.isNullOrNil(nullAsNil5)) {
                    this.ehM.iC(nullAsNil5);
                }
                nullAsNil5 = getIntent().getStringExtra("Contact_QuanPin");
                if (!bo.isNullOrNil(nullAsNil5)) {
                    this.ehM.iD(nullAsNil5);
                }
            }
            if (!(com.tencent.mm.n.a.jh(this.ehM.field_type) || bo.isNullOrNil(stringExtra12))) {
                this.ehM.jf(stringExtra12);
            }
            if (!(com.tencent.mm.n.a.jh(this.ehM.field_type) || intExtra6 == 0)) {
                this.ehM.hK(intExtra6);
            }
            if (!bo.isNullOrNil(stringExtra11)) {
                this.ehM.iK(stringExtra11);
            }
        }
        if (ad.aox(this.ehM.field_username) && (this.gwP == 30 || this.gwP == 45 || this.gwP == 17)) {
            com.tencent.mm.plugin.report.service.h hVar = com.tencent.mm.plugin.report.service.h.pYm;
            Object[] objArr = new Object[2];
            objArr[0] = this.ehM.field_openImAppid;
            objArr[1] = Integer.valueOf(this.gwP == 17 ? 2 : 1);
            hVar.e(15320, objArr);
        }
        if (!bo.isNullOrNil(nullAsNil4)) {
            this.ehM.iH(nullAsNil4);
        }
        fD(nullAsNil2, nullAsNil4);
        getIntent().putExtra("Contact_User", this.ehM.field_username);
        if (!booleanExtra && ((int) this.ehM.ewQ) <= 0 && this.ehM.dsf() && (this.gwP == 17 || this.gwP == 41)) {
            ab.d("MicroMsg.ContactInfoUI", "come from card, getContact %s", this.ehM.field_username);
            ao.a.flu.ai(this.ehM.field_username, "");
            com.tencent.mm.ah.b.pY(this.ehM.field_username);
        }
        nullAsNil5 = "MicroMsg.ContactInfoUI";
        str = "contact.getRemarkDesc() (%s, %s, %s)";
        Object[] objArr2 = new Object[3];
        if (this.ehM.dul == null) {
            z = true;
        } else {
            z = false;
        }
        objArr2[0] = Boolean.valueOf(z);
        if (this.ehM.dul == null) {
            i = 0;
        } else {
            i = this.ehM.dul.length();
        }
        objArr2[1] = Integer.valueOf(i);
        objArr2[2] = this.ehM.dul == null ? "" : bo.anv(this.ehM.dul);
        ab.i(nullAsNil5, str, objArr2);
        if (!booleanExtra && ((int) this.ehM.ewQ) <= 0 && this.gwP == 96) {
            ab.i("MicroMsg.ContactInfoUI", "come from chatroom accessverify, getContact %s", this.ehM.field_username);
            ao.a.flu.aj(this.ehM.field_username, getIntent().getStringExtra("key_add_contact_verify_ticket"));
            com.tencent.mm.ah.b.U(this.ehM.field_username, 3);
        }
        if (this.ehM.field_username.equals(r.Yz())) {
            ad adVar;
            aw.ZK();
            long j = bo.getLong((String) com.tencent.mm.model.c.Ry().get(65825, null), 0);
            if (j > 0) {
                this.ehM.eC(j);
                adVar = this.ehM;
                aw.ZK();
                adVar.iL((String) com.tencent.mm.model.c.Ry().get(65826, null));
            }
            adVar = this.ehM;
            aw.ZK();
            adVar.iZ((String) com.tencent.mm.model.c.Ry().get(286721, null));
            adVar = this.ehM;
            aw.ZK();
            adVar.ja((String) com.tencent.mm.model.c.Ry().get(286722, null));
            adVar = this.ehM;
            aw.ZK();
            adVar.jb((String) com.tencent.mm.model.c.Ry().get(286723, null));
        }
        if (this.ehM.field_username != null && this.ehM.field_username.equals(ad.aoC(r.Yz()))) {
            bp aao = bp.aao();
            nullAsNil5 = bo.nullAsNil(aao.getProvince());
            str = bo.nullAsNil(aao.getCity());
            if (!bo.isNullOrNil(nullAsNil5)) {
                this.ehM.iR(nullAsNil5);
            }
            if (!bo.isNullOrNil(str)) {
                this.ehM.iS(str);
            }
            if (!bo.isNullOrNil(aao.countryCode)) {
                this.ehM.iW(RegionCodeDecoder.aC(aao.countryCode, aao.fnp, aao.fno));
            }
            int a = bo.a(Integer.valueOf(aao.dtS), 0);
            nullAsNil4 = bo.nullAsNil(aao.signature);
            this.ehM.hA(a);
            this.ehM.iQ(nullAsNil4);
        }
        if (bo.isNullOrNil(this.ehM.field_username)) {
            ab.e("MicroMsg.ContactInfoUI", "username is null %s", nullAsNil2);
            finish();
            AppMethodBeat.o(23372);
            return;
        }
        setMMTitle("");
        UO(this.pln);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(23352);
                if ((t.no(ContactInfoUI.this.ehM.field_username) && !r.YT()) || ((t.ng(ContactInfoUI.this.ehM.field_username) && !r.YP()) || ((t.ni(ContactInfoUI.this.ehM.field_username) && !r.YY()) || (t.nc(ContactInfoUI.this.ehM.field_username) && !r.Zb())))) {
                    Intent intent = new Intent();
                    intent.addFlags(67108864);
                    com.tencent.mm.plugin.profile.b.gkE.p(intent, ContactInfoUI.this);
                }
                ContactInfoUI.this.finish();
                AppMethodBeat.o(23352);
                return true;
            }
        });
        o.acv().qa(this.ehM.field_username);
        if ((t.no(this.ehM.field_username) && r.YT()) || ((t.ng(this.ehM.field_username) && r.YP()) || ((t.ni(this.ehM.field_username) && r.YY()) || (t.nc(this.ehM.field_username) && r.Zb())))) {
            this.pll = true;
            AppMethodBeat.o(23372);
            return;
        }
        this.pll = false;
        AppMethodBeat.o(23372);
    }

    public final boolean a(com.tencent.mm.ui.base.preference.f fVar, Preference preference) {
        AppMethodBeat.i(23376);
        String str = preference.mKey;
        ab.i("MicroMsg.ContactInfoUI", str + " item has been clicked!");
        if (this.plh != null) {
            this.plh.IO(str);
        }
        if (preference != null) {
            if (preference.mKey.equals("contact_info_sns")) {
                com.tencent.mm.plugin.report.service.h.pYm.e(16055, Integer.valueOf(com.tencent.mm.plugin.profile.c.am(getIntent())), Integer.valueOf(3));
            } else if (preference.mKey.equals("contact_info_more")) {
                com.tencent.mm.plugin.report.service.h.pYm.e(16055, Integer.valueOf(com.tencent.mm.plugin.profile.c.am(getIntent())), Integer.valueOf(6));
            }
        }
        if (preference instanceof NormalProfileHeaderPreference) {
            caG();
        }
        AppMethodBeat.o(23376);
        return false;
    }

    static /* synthetic */ void b(ContactInfoUI contactInfoUI) {
        AppMethodBeat.i(23389);
        if (com.tencent.mm.compatible.util.d.iW(19)) {
            contactInfoUI.getWindow().setFlags(201327616, 201327616);
            AppMethodBeat.o(23389);
            return;
        }
        contactInfoUI.getWindow().setFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
        AppMethodBeat.o(23389);
    }
}
