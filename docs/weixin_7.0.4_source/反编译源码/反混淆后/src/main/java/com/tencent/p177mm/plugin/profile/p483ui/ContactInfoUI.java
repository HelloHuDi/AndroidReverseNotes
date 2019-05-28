package com.tencent.p177mm.plugin.profile.p483ui;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.compatible.util.C1443d;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.kernel.C18524i;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C26415ao.C26417a;
import com.tencent.p177mm.model.C26415ao.C9635b;
import com.tencent.p177mm.model.C32782bp;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.modelstat.C26483d;
import com.tencent.p177mm.openim.p716b.C32877h;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.p1099x.C16112c;
import com.tencent.p177mm.p182ah.C17884o;
import com.tencent.p177mm.p182ah.C41730b;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C6300p;
import com.tencent.p177mm.p184aj.C16527d;
import com.tencent.p177mm.p184aj.C17903f;
import com.tencent.p177mm.p184aj.C32237a;
import com.tencent.p177mm.p184aj.C41747z;
import com.tencent.p177mm.p199ax.C32321b;
import com.tencent.p177mm.p199ax.C6328d;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p264n.C7486a;
import com.tencent.p177mm.p612ui.C5230ak;
import com.tencent.p177mm.p612ui.C5510e.C5495b;
import com.tencent.p177mm.p612ui.base.C23639t;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.preference.C15541f;
import com.tencent.p177mm.p612ui.base.preference.MMPreference;
import com.tencent.p177mm.p612ui.base.preference.Preference;
import com.tencent.p177mm.p612ui.statusbar.C5544c;
import com.tencent.p177mm.p612ui.statusbar.C5544c.C5543a;
import com.tencent.p177mm.p612ui.statusbar.C5546d;
import com.tencent.p177mm.p612ui.widget.listview.PullDownListView;
import com.tencent.p177mm.p612ui.widget.listview.PullDownListView.C30804a;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.account.C32923a;
import com.tencent.p177mm.plugin.account.friend.p272a.C18817a;
import com.tencent.p177mm.plugin.appbrand.jsapi.wifi.C38405e;
import com.tencent.p177mm.plugin.downloader_app.p379e.C2910a;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.p455a.C6980m.C3466a;
import com.tencent.p177mm.plugin.p1140r.C16841a;
import com.tencent.p177mm.plugin.profile.C34687a;
import com.tencent.p177mm.plugin.profile.C34696c;
import com.tencent.p177mm.plugin.profile.C39503b;
import com.tencent.p177mm.plugin.profile.p483ui.newbizinfo.C43392b;
import com.tencent.p177mm.plugin.profile.p483ui.newbizinfo.p484c.C3642a;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.sns.p1024b.C21877n;
import com.tencent.p177mm.plugin.story.api.AbsStoryGallery;
import com.tencent.p177mm.plugin.story.api.AbsStoryMuteView;
import com.tencent.p177mm.plugin.story.api.C35168e;
import com.tencent.p177mm.plugin.story.api.C35171g;
import com.tencent.p177mm.plugin.story.api.C46269m.C29273a;
import com.tencent.p177mm.plugin.story.model.p744a.C35194j;
import com.tencent.p177mm.plugin.story.p531g.C22212h;
import com.tencent.p177mm.plugin.story.p532h.C35183a;
import com.tencent.p177mm.plugin.story.p532h.C35183a.C35184a;
import com.tencent.p177mm.plugin.topstory.p541ui.widget.C40001a;
import com.tencent.p177mm.pluginsdk.p1337b.C23233a;
import com.tencent.p177mm.protocal.protobuf.C7285uy;
import com.tencent.p177mm.sdk.p603e.C4935m;
import com.tencent.p177mm.sdk.p603e.C7296k.C4931a;
import com.tencent.p177mm.sdk.p603e.C7298n;
import com.tencent.p177mm.sdk.p603e.C7298n.C4937b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.p177mm.storage.C7575bv;
import com.tencent.p177mm.storage.C7616ad;
import com.tencent.p177mm.storage.RegionCodeDecoder;
import java.io.IOException;

@C18524i
/* renamed from: com.tencent.mm.plugin.profile.ui.ContactInfoUI */
public class ContactInfoUI extends MMPreference implements C1202f, C3466a, C35171g, C4931a, C4937b {
    private C15541f ehK;
    private C7616ad ehM;
    private String ehq = "";
    private boolean fdb = false;
    private int gwP;
    private String mGZ;
    private C23233a plh;
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
    private C30804a plu = new C214581();
    private View plv;
    private View plw;
    private C5543a plx;
    private boolean ply = false;
    private boolean sjn = false;

    /* renamed from: com.tencent.mm.plugin.profile.ui.ContactInfoUI$11 */
    class C2145711 implements DialogInterface.OnClickListener {
        C2145711() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(23357);
            ContactInfoUI.this.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
            AppMethodBeat.m2505o(23357);
        }
    }

    /* renamed from: com.tencent.mm.plugin.profile.ui.ContactInfoUI$1 */
    class C214581 implements C30804a {
        C214581() {
        }

        /* renamed from: jM */
        public final void mo36936jM(boolean z) {
            AppMethodBeat.m2504i(23340);
            if (ContactInfoUI.this.plq != null) {
                C4990ab.m7416i("MicroMsg.ContactInfoUI", "story_cat onPostOpen");
                ContactInfoUI.this.plq.mo55932K(z, true);
                ContactInfoUI.this.mController.hideTitleView();
                ContactInfoUI.m32916b(ContactInfoUI.this);
            }
            AppMethodBeat.m2505o(23340);
        }

        public final void caI() {
            AppMethodBeat.m2504i(23341);
            if (ContactInfoUI.this.plq != null) {
                C4990ab.m7416i("MicroMsg.ContactInfoUI", "story_cat onPostClose");
                ContactInfoUI.this.plq.mo55945lr(true);
                ContactInfoUI.this.mController.showTitleView();
                ContactInfoUI.m32917c(ContactInfoUI.this);
            }
            AppMethodBeat.m2505o(23341);
        }

        public final void caJ() {
            AppMethodBeat.m2504i(23342);
            if (ContactInfoUI.this.plq != null) {
                ContactInfoUI.this.plq.cwK();
            }
            AppMethodBeat.m2505o(23342);
        }

        public final void caK() {
            AppMethodBeat.m2504i(23343);
            if (ContactInfoUI.this.plq != null) {
                ContactInfoUI.this.plq.cwL();
            }
            AppMethodBeat.m2505o(23343);
        }

        public final void caL() {
            AppMethodBeat.m2504i(23344);
            C4990ab.m7416i("MicroMsg.ContactInfoUI", "story_cat onMuteIn");
            ContactInfoUI.this.plr.cwM();
            AppMethodBeat.m2505o(23344);
        }

        public final void caM() {
            AppMethodBeat.m2504i(23345);
            ContactInfoUI.this.plr.cwN();
            AppMethodBeat.m2505o(23345);
        }

        /* renamed from: AU */
        public final void mo36928AU(int i) {
            AppMethodBeat.m2504i(23346);
            if (ContactInfoUI.this.plq != null) {
                ContactInfoUI.this.plq.mo55929EF(i);
            }
            AppMethodBeat.m2505o(23346);
        }

        /* renamed from: AV */
        public final void mo36929AV(int i) {
            AppMethodBeat.m2504i(23347);
            if (ContactInfoUI.this.plq != null) {
                ContactInfoUI.this.plq.mo55930EG(i);
            }
            AppMethodBeat.m2505o(23347);
        }

        /* renamed from: AW */
        public final void mo36930AW(int i) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.profile.ui.ContactInfoUI$2 */
    class C214592 implements OnClickListener {
        C214592() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(23348);
            C4990ab.m7416i("MicroMsg.ContactInfoUI", "onClick: NormalProfileHeaderPreference");
            ContactInfoUI.m32925j(ContactInfoUI.this);
            AppMethodBeat.m2505o(23348);
        }
    }

    /* renamed from: com.tencent.mm.plugin.profile.ui.ContactInfoUI$3 */
    class C214603 implements OnClickListener {
        C214603() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(23349);
            C4990ab.m7416i("MicroMsg.ContactInfoUI", "onClick: actionBarClick action_bar_root");
            ContactInfoUI.m32925j(ContactInfoUI.this);
            AppMethodBeat.m2505o(23349);
        }
    }

    /* renamed from: com.tencent.mm.plugin.profile.ui.ContactInfoUI$4 */
    class C214614 implements C5543a {
        C214614() {
        }

        /* renamed from: pO */
        public final void mo11252pO(int i) {
            AppMethodBeat.m2504i(23350);
            ContactInfoUI.this.plv.setPadding(0, i, 0, 0);
            C5546d.m8368a(ContactInfoUI.this.getWindow());
            AppMethodBeat.m2505o(23350);
        }
    }

    /* renamed from: com.tencent.mm.plugin.profile.ui.ContactInfoUI$10 */
    class C2146210 implements DialogInterface.OnClickListener {
        C2146210() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(23356);
            dialogInterface.dismiss();
            AppMethodBeat.m2505o(23356);
        }
    }

    /* renamed from: com.tencent.mm.plugin.profile.ui.ContactInfoUI$5 */
    class C214635 implements Runnable {
        C214635() {
        }

        public final void run() {
            AppMethodBeat.m2504i(23351);
            C9638aw.m17190ZK();
            C18628c.m29072Ry().dsb();
            AppMethodBeat.m2505o(23351);
        }
    }

    /* renamed from: com.tencent.mm.plugin.profile.ui.ContactInfoUI$6 */
    class C214646 implements OnMenuItemClickListener {
        C214646() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(23352);
            if ((C1855t.m3946no(ContactInfoUI.this.ehM.field_username) && !C1853r.m3838YT()) || ((C1855t.m3938ng(ContactInfoUI.this.ehM.field_username) && !C1853r.m3834YP()) || ((C1855t.m3940ni(ContactInfoUI.this.ehM.field_username) && !C1853r.m3843YY()) || (C1855t.m3934nc(ContactInfoUI.this.ehM.field_username) && !C1853r.m3848Zb())))) {
                Intent intent = new Intent();
                intent.addFlags(67108864);
                C39503b.gkE.mo38931p(intent, ContactInfoUI.this);
            }
            ContactInfoUI.this.finish();
            AppMethodBeat.m2505o(23352);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.profile.ui.ContactInfoUI$9 */
    class C214679 implements DialogInterface.OnClickListener {
        C214679() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(23355);
            dialogInterface.dismiss();
            ContactInfoUI.this.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
            AppMethodBeat.m2505o(23355);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public ContactInfoUI() {
        AppMethodBeat.m2504i(23358);
        AppMethodBeat.m2505o(23358);
    }

    /* renamed from: c */
    static /* synthetic */ void m32917c(ContactInfoUI contactInfoUI) {
        AppMethodBeat.m2504i(23390);
        contactInfoUI.caE();
        AppMethodBeat.m2505o(23390);
    }

    /* renamed from: j */
    static /* synthetic */ void m32925j(ContactInfoUI contactInfoUI) {
        AppMethodBeat.m2504i(23391);
        contactInfoUI.caG();
        AppMethodBeat.m2505o(23391);
    }

    public final void caA() {
        AppMethodBeat.m2504i(23359);
        C4990ab.m7416i("MicroMsg.ContactInfoUI", "story_cat storyUINoStory");
        this.pls = false;
        if (!(this.plo == null || this.plo.isVisible)) {
            this.mController.showTitleView();
            caE();
            this.plo.dLf();
        }
        caH();
        AppMethodBeat.m2505o(23359);
    }

    public final void caB() {
        AppMethodBeat.m2504i(23360);
        C4990ab.m7416i("MicroMsg.ContactInfoUI", "story_cat storyUIHasStory");
        this.pls = true;
        if (this.plo != null && this.plo.isVisible) {
            caH();
        }
        AppMethodBeat.m2505o(23360);
    }

    public final void caC() {
        AppMethodBeat.m2504i(23361);
        C4990ab.m7416i("MicroMsg.ContactInfoUI", "story_cat storyUIBackPressed");
        this.plo.dLf();
        AppMethodBeat.m2505o(23361);
    }

    /* renamed from: JC */
    public final int mo8452JC() {
        return C25738R.xml.f8498ai;
    }

    private void caD() {
        AppMethodBeat.m2504i(23363);
        if (this.plv == null || !C5544c.zzP) {
            AppMethodBeat.m2505o(23363);
            return;
        }
        C5544c az = C5544c.m8364az(this);
        C214614 c214614 = new C214614();
        this.plx = c214614;
        az.mo11253a(c214614);
        getWindow().getDecorView().requestApplyInsets();
        C5546d.m8368a(getWindow());
        AppMethodBeat.m2505o(23363);
    }

    public void onConfigurationChanged(Configuration configuration) {
        AppMethodBeat.m2504i(23364);
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
        AppMethodBeat.m2505o(23364);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(23365);
        C22212h c22212h = C22212h.scu;
        C22212h.cAs().cZK = 0;
        if (C1720g.m3534RN().mo5161QY()) {
            C9638aw.m17190ZK();
            C18628c.m29078XM().mo10121b(this);
            C9638aw.m17190ZK();
            C18628c.m29079XN().mo15367b(this);
        }
        if (this.plh != null) {
            this.plh.biV();
        }
        if (this.plh instanceof C43392b) {
            C43392b c43392b = (C43392b) this.plh;
            if (c43392b.ehM == null || c43392b.pkW == null || c43392b.ppN == null) {
                C4990ab.m7420w("MicroMsg.ContactWidgetNewBizInfo", "reportEnd fail, err");
            } else {
                int i;
                c43392b.endTime = System.currentTimeMillis();
                String str = c43392b.ehM.field_username;
                int i2 = c43392b.gwP;
                int i3 = c43392b.pkW.field_type;
                long j = c43392b.edh;
                long j2 = c43392b.endTime;
                if (C7486a.m12942jh(c43392b.ehM.field_type)) {
                    i = 1;
                } else {
                    i = 0;
                }
                C3642a.m5976a(str, i2, i3, j, j2, i, c43392b.ppN.field_originalArticleCount, c43392b.ppN.field_friendSubscribeCount, c43392b.pmy != null ? c43392b.pmy.size() : 0, C3642a.m5977cE(c43392b.ppN.cbL()), C3642a.m5978cF(c43392b.ppN.cbM()), c43392b.ppN.field_decryptUserName);
            }
        }
        if (C21877n.qFx != null) {
            C21877n.qFx.mo37452ab(this);
        }
        super.onDestroy();
        C1720g.m3537RQ();
        C1720g.m3535RO().eJo.mo14546b(273, (C1202f) this);
        if (this.plq != null) {
            this.plq.onDestroy();
        }
        C7060h.pYm.mo8381e(17283, Integer.valueOf(C34696c.m56965am(getIntent())), this.ehM.field_username, Integer.valueOf(this.ehM.uin), Boolean.valueOf(this.pls), Boolean.valueOf(this.sjn));
        AppMethodBeat.m2505o(23365);
    }

    public void onResume() {
        AppMethodBeat.m2504i(23366);
        C26483d.m42196b(3, "ContactInfoUI" + bJj(), hashCode());
        C41747z.aeR().mo10116c(this);
        super.onResume();
        View focusedChild = ((ViewGroup) this.mController.contentView).getFocusedChild();
        if (focusedChild != null) {
            focusedChild.clearFocus();
            C4990ab.m7417i("MicroMsg.ContactInfoUI", "try to clear focus. id:%s", Integer.valueOf(focusedChild.getId()));
        }
        this.plo = (PullDownListView) this.nDp;
        if (this.plq != null) {
            this.plq.onResume();
        }
        if (this.ehK != null) {
            NormalProfileHeaderPreference normalProfileHeaderPreference = (NormalProfileHeaderPreference) this.ehK.aqO("contact_profile_header_normal");
            if (normalProfileHeaderPreference != null) {
                normalProfileHeaderPreference.mo8201A(this.pls, this.plw.getHeight());
            }
        }
        if ((this.plh instanceof C39514c) || (this.plh instanceof C43392b)) {
            this.plh.mo7078a(this.ehK, this.ehM, this.pli, this.gwP);
        }
        AppMethodBeat.m2505o(23366);
    }

    public void onStart() {
        AppMethodBeat.m2504i(23367);
        super.onStart();
        if (this.plq != null) {
            this.plq.onStart();
        }
        AppMethodBeat.m2505o(23367);
    }

    /* Access modifiers changed, original: protected */
    public void onRestart() {
        AppMethodBeat.m2504i(23368);
        super.onRestart();
        this.ply = false;
        AppMethodBeat.m2505o(23368);
    }

    public void onPause() {
        AppMethodBeat.m2504i(23369);
        C26483d.m42196b(4, "ContactInfoUI" + bJj(), hashCode());
        C41747z.aeR().mo10117d(this);
        super.onPause();
        C9638aw.m17180RS().mo10303ae(new C214635());
        if (getIntent().getBooleanExtra("key_from_wesport_right_newtips", false)) {
            C16841a.bVt();
            C6328d.m10413u(C32321b.fKF, dyi());
        } else if (getIntent().getBooleanExtra("key_from_wesport_plugin_newtips", false)) {
            C16841a.bVt();
            C6328d.m10413u(C32321b.fKD, dyi());
        }
        caE();
        if (this.plq != null) {
            this.plq.onPause();
        }
        if ((this.plh instanceof C39514c) || (this.plh instanceof C43392b)) {
            this.plh.biV();
        }
        AppMethodBeat.m2505o(23369);
    }

    public void onStop() {
        AppMethodBeat.m2504i(23370);
        super.onStop();
        if (this.plq != null) {
            this.plq.onStop();
        }
        AppMethodBeat.m2505o(23370);
    }

    public final String bJj() {
        AppMethodBeat.m2504i(23371);
        String str;
        if (this.ehM == null || ((int) this.ehM.ewQ) == 0 || C5046bo.isNullOrNil(this.ehM.field_username)) {
            str = "";
            AppMethodBeat.m2505o(23371);
            return str;
        }
        C4990ab.m7417i("MicroMsg.ContactInfoUI", "getIdentityString %s", this.ehM.field_username);
        if (C17903f.m28103kq(this.ehM.field_username)) {
            str = "_EnterpriseChat";
            AppMethodBeat.m2505o(23371);
            return str;
        } else if (C17903f.m28109rc(this.ehM.field_username)) {
            str = "_EnterpriseFatherBiz";
            AppMethodBeat.m2505o(23371);
            return str;
        } else if (C17903f.m28108rb(this.ehM.field_username)) {
            str = "_EnterpriseChildBiz";
            AppMethodBeat.m2505o(23371);
            return str;
        } else if (this.ehM.dsf()) {
            str = "_bizContact";
            AppMethodBeat.m2505o(23371);
            return str;
        } else if (C1855t.m3896kH(this.ehM.field_username)) {
            str = "_chatroom";
            AppMethodBeat.m2505o(23371);
            return str;
        } else if (C1855t.m3905mR(this.ehM.field_username)) {
            str = "_bottle";
            AppMethodBeat.m2505o(23371);
            return str;
        } else if (C1855t.m3906mS(this.ehM.field_username)) {
            str = "_QQ";
            AppMethodBeat.m2505o(23371);
            return str;
        } else if (C1855t.m3923nI(this.ehM.field_username)) {
            str = "_" + this.ehM.field_username;
            AppMethodBeat.m2505o(23371);
            return str;
        } else {
            str = "";
            AppMethodBeat.m2505o(23371);
            return str;
        }
    }

    /* renamed from: UO */
    private void m32913UO(String str) {
        AppMethodBeat.m2504i(23373);
        if (C1855t.m3908mU(this.ehM.field_username)) {
            this.plh = C25985d.m41465ac(this, "sport");
        } else if (C1855t.m3934nc(this.ehM.field_username)) {
            this.plh = C25985d.m41465ac(this, "qqmail");
        } else if (C1855t.m3935nd(this.ehM.field_username)) {
            this.plh = new C46137e(this);
        } else if (C1855t.m3936ne(this.ehM.field_username)) {
            this.plh = C25985d.m41465ac(this, "tmessage");
        } else if (C1855t.m3948nq(this.ehM.field_username)) {
            this.plh = new C40001a(this);
        } else if (C1855t.m3910mW(this.ehM.field_username)) {
            this.plh = new C12849h(this);
        } else if (C1855t.m3942nk(this.ehM.field_username)) {
            this.plh = new C39526m(this);
        } else if (C7616ad.m13548mR(this.ehM.field_username)) {
            this.plh = new C34726d(this);
        } else if (C1855t.m3944nm(this.ehM.field_username)) {
            this.plh = C25985d.m41465ac(this, "nearby");
        } else if (C1855t.m3945nn(this.ehM.field_username)) {
            this.plh = C25985d.m41465ac(this, "shake");
        } else if (C1855t.m3946no(this.ehM.field_username)) {
            this.plh = new C12852j(this);
        } else if (C1855t.m3947np(this.ehM.field_username)) {
            this.plh = C25985d.m41449I(this, "readerapp", "widget_type_news");
        } else if (C1855t.m3955nx(this.ehM.field_username)) {
            this.plh = C25985d.m41449I(this, "readerapp", "widget_type_weibo");
        } else if (C1855t.m3939nh(this.ehM.field_username)) {
            this.plh = new C39522f(this);
        } else if (C1855t.m3940ni(this.ehM.field_username)) {
            this.plh = C25985d.m41465ac(this, "masssend");
        } else if (C1855t.m3941nj(this.ehM.field_username)) {
            this.plh = new C34727g(this);
        } else if (this.ehM.dsf() || getIntent().getBooleanExtra("key_use_new_contact_profile", false)) {
            C7285uy c7285uy;
            try {
                c7285uy = this.plk == null ? null : (C7285uy) new C7285uy().parseFrom(this.plk);
            } catch (IOException e) {
                C4990ab.printErrStackTrace("MicroMsg.ContactInfoUI", e, "", new Object[0]);
                c7285uy = null;
            }
            C4990ab.m7417i("MicroMsg.ContactInfoUI", "username:%s, isUseNewProfileUI:%b", this.ehM.field_username, Boolean.valueOf(m32915a(this.ehM.field_username, c7285uy)));
            if (m32915a(this.ehM.field_username, c7285uy)) {
                C43392b c43392b = new C43392b(this, str, c7285uy);
                if (!C5046bo.isNullOrNil(this.mGZ)) {
                    c43392b.mGZ = this.mGZ;
                }
                this.plh = c43392b;
            } else {
                C39514c c39514c = new C39514c(this, str, c7285uy);
                if (!C5046bo.isNullOrNil(this.mGZ)) {
                    c39514c.mGZ = this.mGZ;
                }
                this.plh = c39514c;
            }
        } else if (C1855t.m3951nt(this.ehM.field_username)) {
            this.plh = new C46138n(this);
        } else if (C1855t.m3952nu(this.ehM.field_username)) {
            this.plh = new C28697i(this);
        } else if (C1855t.m3909mV(this.ehM.field_username)) {
            this.plh = new C2910a(this);
        } else {
            this.plh = new C34687a(this);
            caF();
        }
        if (this.plh != null) {
            this.plh.mo7078a(this.ehK, this.ehM, this.pli, this.gwP);
            C18817a vT = C32923a.getAddrUploadStg().mo34089vT(this.ehM.field_username);
            String str2 = "";
            if (vT != null) {
                str2 = C5046bo.nullAsNil(vT.apG()).replace(" ", "");
            }
            if (!this.ply && C7486a.m12942jh(this.ehM.field_type) && (this.plh instanceof C44753k)) {
                int i;
                int length = (C5046bo.isNullOrNil(this.ehM.dur) ? 0 : this.ehM.dur.split(",").length) + (C5046bo.isNullOrNil(str2) ? 0 : 1);
                C7060h c7060h = C7060h.pYm;
                Object[] objArr = new Object[4];
                objArr[0] = this.ehM.field_username;
                objArr[1] = Integer.valueOf(1);
                if (C5046bo.isNullOrNil(str2)) {
                    i = 0;
                } else {
                    i = 1;
                }
                objArr[2] = Integer.valueOf(i);
                objArr[3] = Integer.valueOf(length >= 5 ? 5 : length);
                c7060h.mo8381e(12040, objArr);
                this.ply = true;
            }
            if (!((this.plh instanceof C44753k) || (this.plh instanceof C39514c) || (this.plh instanceof C43392b))) {
                C9638aw.m17190ZK();
                str2 = (String) C18628c.m29072Ry().get(C5127a.USERINFO_SETTING_PLUGIN_SWITCH_NAMES_STRING, (Object) "");
                if (str2.contains(this.ehM.field_username)) {
                    Object replaceAll = str2.replaceAll(this.ehM.field_username + ",*", "");
                    C9638aw.m17190ZK();
                    C18628c.m29072Ry().set(C5127a.USERINFO_SETTING_PLUGIN_SWITCH_NAMES_STRING, replaceAll);
                    C4990ab.m7417i("MicroMsg.ContactInfoUI", "mark plugin read, userName:%s, newVal:%s", this.ehM.field_username, replaceAll);
                    if (C5046bo.isNullOrNil(replaceAll)) {
                        C16112c.m24429PK().mo28557y(262158, false);
                    }
                }
            }
        }
        if (this.ehK != null) {
            NormalProfileHeaderPreference normalProfileHeaderPreference = (NormalProfileHeaderPreference) this.ehK.aqO("contact_profile_header_normal");
            if (normalProfileHeaderPreference != null) {
                normalProfileHeaderPreference.mo8201A(this.pls, this.plw.getHeight());
            }
        }
        AppMethodBeat.m2505o(23373);
    }

    /* renamed from: a */
    private boolean m32915a(String str, C7285uy c7285uy) {
        AppMethodBeat.m2504i(23374);
        if (!C4996ah.doB().getBoolean("use_new_profile", true)) {
            AppMethodBeat.m2505o(23374);
            return false;
        } else if (C1855t.m3931nQ(str)) {
            AppMethodBeat.m2505o(23374);
            return false;
        } else if (C1855t.m3943nl(str)) {
            AppMethodBeat.m2505o(23374);
            return false;
        } else if (C1855t.m3954nw(str)) {
            AppMethodBeat.m2505o(23374);
            return false;
        } else if (C17903f.m28105qY(str)) {
            AppMethodBeat.m2505o(23374);
            return true;
        } else if (C17903f.m28106qZ(str)) {
            AppMethodBeat.m2505o(23374);
            return true;
        } else {
            if (c7285uy != null) {
                C16527d c16527d = new C16527d();
                c16527d.field_extInfo = c7285uy.gvc;
                c16527d.field_type = c16527d.mo30481cJ(false).getServiceType();
                if (c16527d.adN()) {
                    AppMethodBeat.m2505o(23374);
                    return true;
                } else if (c16527d.adM()) {
                    AppMethodBeat.m2505o(23374);
                    return true;
                }
            }
            if (getIntent().getBooleanExtra("key_use_new_contact_profile", false)) {
                AppMethodBeat.m2505o(23374);
                return true;
            } else if (C17903f.m28109rc(this.ehM.field_username)) {
                AppMethodBeat.m2505o(23374);
                return false;
            } else if (C17903f.m28108rb(this.ehM.field_username)) {
                AppMethodBeat.m2505o(23374);
                return false;
            } else if (((int) this.ehM.ewQ) <= 0 && this.ehM.dsf() && (this.gwP == 17 || this.gwP == 41)) {
                AppMethodBeat.m2505o(23374);
                return true;
            } else {
                AppMethodBeat.m2505o(23374);
                return false;
            }
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(23375);
        super.onActivityResult(i, i2, intent);
        if (intent != null) {
            getIntent().putExtra("CONTACT_INFO_UI_SOURCE", intent.getIntExtra("CONTACT_INFO_UI_SOURCE", -1));
        }
        if (this.plh != null) {
            this.plh.onActivityResult(i, i2, intent);
        }
        AppMethodBeat.m2505o(23375);
    }

    /* renamed from: a */
    public final void mo10136a(int i, C7298n c7298n, Object obj) {
        AppMethodBeat.m2504i(23377);
        if (obj == null || !(obj instanceof String)) {
            C4990ab.m7417i("MicroMsg.ContactInfoUI", "onNotifyChange obj not String event:%d stg:%s obj:%s", Integer.valueOf(i), c7298n, obj);
            AppMethodBeat.m2505o(23377);
            return;
        }
        mo5248a((String) obj, null);
        AppMethodBeat.m2505o(23377);
    }

    /* renamed from: a */
    public final void mo5248a(final String str, C4935m c4935m) {
        AppMethodBeat.m2504i(23378);
        new C7306ak().post(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(23353);
                C4990ab.m7417i("MicroMsg.ContactInfoUI", "onNotifyChange verify:%b, contact.user:%s, notify.user:%s", Boolean.valueOf(ContactInfoUI.this.plj), ContactInfoUI.this.ehM.field_username, str);
                if (!(ContactInfoUI.this.ehM == null || C5046bo.isNullOrNil(ContactInfoUI.this.ehM.field_username) || (!ContactInfoUI.this.ehM.field_username.equals(str) && !ContactInfoUI.this.ehM.field_username.equals(C7616ad.aoC(str))))) {
                    if (ContactInfoUI.this.plh != null) {
                        ContactInfoUI.this.plh.biV();
                        ContactInfoUI.this.ehK.removeAll();
                    }
                    ContactInfoUI.this.initView();
                }
                AppMethodBeat.m2505o(23353);
            }
        });
        AppMethodBeat.m2505o(23378);
    }

    /* renamed from: a */
    public final void mo7925a(final C7575bv c7575bv) {
        AppMethodBeat.m2504i(23379);
        C5004al.m7441d(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(23354);
                if (!(ContactInfoUI.this.ehM == null || c7575bv == null || C5046bo.isNullOrNil(ContactInfoUI.this.ehM.field_username) || !ContactInfoUI.this.ehM.field_username.equals(c7575bv.field_encryptUsername) || C1855t.m3924nJ(ContactInfoUI.this.ehM.field_username))) {
                    ContactInfoUI.this.ehM.mo14729iz(c7575bv.field_conRemark);
                    ContactInfoUI.this.getIntent().putExtra("Contact_User", ContactInfoUI.this.ehM.field_username);
                    if (ContactInfoUI.this.plh != null) {
                        ContactInfoUI.this.plh.biV();
                        ContactInfoUI.this.ehK.removeAll();
                    }
                    ContactInfoUI.this.initView();
                }
                AppMethodBeat.m2505o(23354);
            }
        });
        AppMethodBeat.m2505o(23379);
    }

    /* renamed from: fD */
    private void m32921fD(String str, String str2) {
        AppMethodBeat.m2504i(23380);
        if (this.ehM == null) {
            C4990ab.m7412e("MicroMsg.ContactInfoUI", "contact = null");
            AppMethodBeat.m2505o(23380);
            return;
        }
        C7575bv RB;
        if (!C5046bo.isNullOrNil(str2)) {
            C9638aw.m17190ZK();
            RB = C18628c.m29079XN().mo15364RB(str2);
            if (!(RB == null || C5046bo.isNullOrNil(RB.field_encryptUsername))) {
                this.ehM.mo14729iz(RB.field_conRemark);
                AppMethodBeat.m2505o(23380);
                return;
            }
        }
        if (!C5046bo.isNullOrNil(str)) {
            C9638aw.m17190ZK();
            RB = C18628c.m29079XN().mo15364RB(str);
            if (!(RB == null || C5046bo.isNullOrNil(RB.field_encryptUsername))) {
                this.ehM.mo14729iz(RB.field_conRemark);
                AppMethodBeat.m2505o(23380);
                return;
            }
        }
        AppMethodBeat.m2505o(23380);
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        AppMethodBeat.m2504i(23381);
        if (iArr == null || iArr.length <= 0) {
            C4990ab.m7417i("MicroMsg.ContactInfoUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", Integer.valueOf(i), Long.valueOf(Thread.currentThread().getId()));
            AppMethodBeat.m2505o(23381);
            return;
        }
        C4990ab.m7417i("MicroMsg.ContactInfoUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId()));
        NormalUserFooterPreference normalUserFooterPreference;
        switch (i) {
            case 19:
                if (iArr[0] == 0) {
                    normalUserFooterPreference = (NormalUserFooterPreference) this.ehK.aqO("contact_info_footer_normal");
                    if (normalUserFooterPreference != null) {
                        normalUserFooterPreference.cbm();
                    }
                    AppMethodBeat.m2505o(23381);
                    return;
                }
                int i2 = "android.permission.CAMERA".equals(strArr[0]) ? C25738R.string.dbs : C25738R.string.dc0;
                if (iArr[0] != 0) {
                    C30379h.m48445a((Context) this, getString(i2), getString(C25738R.string.dc8), getString(C25738R.string.ckr), getString(C25738R.string.abx), false, new C214679(), new C2146210());
                }
                AppMethodBeat.m2505o(23381);
                return;
            case 82:
                if (iArr[0] != 0) {
                    C30379h.m48445a((Context) this, getString(C25738R.string.dby), getString(C25738R.string.dc8), getString(C25738R.string.ckr), getString(C25738R.string.abx), false, new C2145711(), null);
                    break;
                }
                normalUserFooterPreference = (NormalUserFooterPreference) this.ehK.aqO("contact_info_footer_normal");
                if (normalUserFooterPreference != null) {
                    normalUserFooterPreference.cbl();
                }
                AppMethodBeat.m2505o(23381);
                return;
        }
        AppMethodBeat.m2505o(23381);
    }

    private void caE() {
        AppMethodBeat.m2504i(23382);
        if (C1443d.m3068iW(19)) {
            getWindow().clearFlags(201327616);
            AppMethodBeat.m2505o(23382);
            return;
        }
        getWindow().clearFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
        AppMethodBeat.m2505o(23382);
    }

    private void caF() {
        AppMethodBeat.m2504i(23383);
        if (!((C35168e) C1720g.m3530M(C35168e.class)).isShowStoryCheck()) {
            AppMethodBeat.m2505o(23383);
        } else if (this.plp) {
            AppMethodBeat.m2505o(23383);
        } else {
            C4990ab.m7417i("MicroMsg.ContactInfoUI", "setupStory %s stack %s", this, C5046bo.dpG().toString());
            this.plp = true;
            this.plo = (PullDownListView) this.nDp;
            this.plo.setBackgroundResource(C25738R.drawable.f6877u3);
            this.plo.zRr = this.plu;
            int i = (-C5230ak.m7993hy(this.mController.ylL).y) / 10;
            RelativeLayout relativeLayout = (RelativeLayout) findViewById(2131826068);
            LayoutParams layoutParams = new LayoutParams(-1, C5230ak.m7993hy(this.mController.ylL).y);
            layoutParams.topMargin = i;
            layoutParams.bottomMargin = -C5230ak.m7988fr(this.mController.ylL);
            if (this.ehM.field_username.equals(C1853r.m3846Yz())) {
                this.plq = ((C35168e) C1720g.m3530M(C35168e.class)).getStoryUIFactory().mo69256a(this, C29273a.SelfGallery, this.ehq);
            } else {
                this.plq = ((C35168e) C1720g.m3530M(C35168e.class)).getStoryUIFactory().mo69256a(this, C29273a.ProfileGallery, this.ehq);
            }
            this.plo.mo49263x(this.plq, C1338a.m2857am(this.mController.ylL, C25738R.dimen.a7h), i);
            this.plq.setStoryBrowseUIListener(this);
            this.plq.setDataSeed(this.ehM.field_username);
            this.plq.mo55934a(this.plo);
            relativeLayout.addView(this.plq, 0, layoutParams);
            C1720g.m3537RQ();
            this.plr = ((C35168e) C1720g.m3530M(C35168e.class)).getStoryUIFactory().mo69258eV(this);
            LayoutParams layoutParams2 = new LayoutParams(C1338a.m2857am(this.mController.ylL, C25738R.dimen.a7g), C1338a.m2857am(this.mController.ylL, C25738R.dimen.a7g));
            layoutParams2.addRule(9);
            layoutParams2.addRule(12);
            relativeLayout.addView(this.plr, 0, layoutParams2);
            this.plo.setMuteView(this.plr);
            this.plo.setNavigationBarHeight(C5230ak.m7988fr(this.mController.ylL));
            this.plt = new C214592();
            C22212h c22212h = C22212h.scu;
            C22212h.cAs().cYQ = 3;
            AppMethodBeat.m2505o(23383);
        }
    }

    public void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(23384);
        C4990ab.m7411d("MicroMsg.ContactInfoUI", "onSceneEnd errType[%s] errCode[%s] errMsg[%s] sceneType[%s]", Integer.valueOf(i), Integer.valueOf(i2), str, Integer.valueOf(c1207m.getType()));
        if (273 == c1207m.getType() && this.ehM != null && (this.plh instanceof C34687a) && C5046bo.isEqual(this.ehM.field_username, ((C35194j) c1207m).userName)) {
            int i3 = ((C35194j) c1207m).cvd;
            C35184a c35184a = C35183a.sdm;
            if (i3 == C35183a.sdl) {
                i3 = 1;
            } else {
                i3 = 0;
            }
            if (i3 != 0) {
                boolean z = (i == 0 || i == 4) && i2 != C38405e.CTRL_INDEX;
                this.sjn = z;
            }
        }
        AppMethodBeat.m2505o(23384);
    }

    public void onBackPressed() {
        AppMethodBeat.m2504i(23385);
        if ((this.plq == null || !this.plq.mo55964wY()) && !getSupportFragmentManager().isDestroyed()) {
            super.onBackPressed();
        }
        AppMethodBeat.m2505o(23385);
    }

    private void caG() {
        AppMethodBeat.m2504i(23386);
        if (this.fdb) {
            C23639t.makeText(this.mController.ylL, getResources().getString(C25738R.string.et4), 0).show();
            AppMethodBeat.m2505o(23386);
            return;
        }
        if (this.pls && this.plo != null) {
            this.plo.dLg();
        }
        AppMethodBeat.m2505o(23386);
    }

    private void caH() {
        boolean z = true;
        AppMethodBeat.m2504i(23387);
        C4990ab.m7417i("MicroMsg.ContactInfoUI", "updateUIByStory: %s %s", Boolean.valueOf(this.plp), Boolean.valueOf(this.pls));
        if (!this.pls || this.fdb) {
            mo17446xE(this.mController.ylL.getResources().getColor(C25738R.color.f11677d4));
            setMMTitle("");
            if (this.plo != null) {
                this.plo.setBackgroundResource(C25738R.drawable.f6879u6);
                this.plo.setSupportOverscroll(false);
            }
        } else {
            caD();
            mo17446xE(this.mController.ylL.getResources().getColor(C25738R.color.a3p));
            setMMTitle("");
            if (this.plo != null) {
                this.plo.setBackgroundResource(C25738R.drawable.f6878u4);
                this.plo.setSupportOverscroll(true);
            }
            if (this.plw != null) {
                this.plw.setOnClickListener(new C214603());
            }
        }
        if (this.ehK != null) {
            NormalProfileHeaderPreference normalProfileHeaderPreference = (NormalProfileHeaderPreference) this.ehK.aqO("contact_profile_header_normal");
            if (normalProfileHeaderPreference != null) {
                if (!this.pls || this.fdb) {
                    z = false;
                }
                normalProfileHeaderPreference.mo8201A(z, this.plw.getHeight());
            }
        }
        AppMethodBeat.m2505o(23387);
    }

    public void finish() {
        AppMethodBeat.m2504i(23388);
        C22212h c22212h = C22212h.scu;
        C22212h.cAs().cYQ = 0;
        super.finish();
        AppMethodBeat.m2505o(23388);
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
        AppMethodBeat.m2504i(23362);
        C9638aw.m17190ZK();
        C7616ad aoO = C18628c.m29078XM().aoO(C5046bo.nullAsNil(getIntent().getStringExtra("Contact_User")));
        if (aoO != null) {
            C1720g.m3537RQ();
            if (((C35168e) C1720g.m3530M(C35168e.class)).isStoryExist(aoO.field_username)) {
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
                this.plv = findViewById(2131820940);
                this.plw = this.plv.findViewById(2131820936);
                caH();
                decorView = getWindow().getDecorView();
                decorView.setSystemUiVisibility((decorView.getSystemUiVisibility() | WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) | 256);
                C4990ab.m7417i("MicroMsg.ContactInfoUI", "onCreate MMCore.accHasReady[%b]", Boolean.valueOf(C9638aw.m17179RK()));
                this.plm = getIntent().getStringExtra("Contact_Search_Mobile");
                if (C1720g.m3534RN().mo5161QY()) {
                    finish();
                    AppMethodBeat.m2505o(23362);
                    return;
                }
                C9638aw.m17190ZK();
                C18628c.m29078XM().mo10118a(this);
                C9638aw.m17190ZK();
                C18628c.m29079XN().mo15366a(this);
                initView();
                dyb();
                if (this.plh instanceof C43392b) {
                    C43392b c43392b = (C43392b) this.plh;
                    if (c43392b.ehM == null || c43392b.pkW == null) {
                        C4990ab.m7420w("MicroMsg.ContactWidgetNewBizInfo", "reportStart fail, err");
                    } else {
                        c43392b.edh = System.currentTimeMillis();
                        C3642a.m5974a(c43392b.ehM.field_username, c43392b.gwP, c43392b.pkW.field_type, c43392b.edh, C7486a.m12942jh(c43392b.ehM.field_type) ? 1 : 0);
                    }
                }
                C7060h.pYm.mo8381e(16055, Integer.valueOf(C34696c.m56965am(getIntent())), Integer.valueOf(1));
                C22212h c22212h = C22212h.scu;
                C22212h.cAs().cZK = (long) C34696c.m56965am(getIntent());
                C1720g.m3537RQ();
                C1720g.m3535RO().eJo.mo14539a(273, (C1202f) this);
                AppMethodBeat.m2505o(23362);
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
        this.plv = findViewById(2131820940);
        this.plw = this.plv.findViewById(2131820936);
        caH();
        decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility((decorView.getSystemUiVisibility() | WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) | 256);
        C4990ab.m7417i("MicroMsg.ContactInfoUI", "onCreate MMCore.accHasReady[%b]", Boolean.valueOf(C9638aw.m17179RK()));
        this.plm = getIntent().getStringExtra("Contact_Search_Mobile");
        if (C1720g.m3534RN().mo5161QY()) {
        }
    }

    public final void initView() {
        String nullAsNil;
        String str;
        Object obj;
        boolean z;
        int i;
        AppMethodBeat.m2504i(23372);
        this.ehK = this.yCw;
        this.ehK.removeAll();
        this.gwP = getIntent().getIntExtra("Contact_Scene", 9);
        this.mGZ = getIntent().getStringExtra("Verify_ticket");
        this.pli = getIntent().getBooleanExtra("Chat_Readonly", false);
        this.plj = getIntent().getBooleanExtra("User_Verify", false);
        this.ehq = getIntent().getStringExtra("Contact_ChatRoomId");
        String nullAsNil2 = C5046bo.nullAsNil(getIntent().getStringExtra("Contact_User"));
        String nullAsNil3 = C5046bo.nullAsNil(getIntent().getStringExtra("Contact_Alias"));
        String nullAsNil4 = C5046bo.nullAsNil(getIntent().getStringExtra("Contact_Encryptusername"));
        if (nullAsNil2.endsWith("@stranger")) {
            nullAsNil4 = nullAsNil2;
        }
        C9638aw.m17190ZK();
        this.ehM = C18628c.m29078XM().aoO(nullAsNil2);
        if (this.ehM != null) {
            this.ehM.xXc = nullAsNil2;
        }
        C39503b.gkF.mo38860a(this.ehM);
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
        C4990ab.m7417i("MicroMsg.ContactInfoUI", "dkverify forceAddContact:%s  user:%s  roomid:%s ", Boolean.valueOf(booleanExtra), nullAsNil2, this.ehq);
        if (booleanExtra) {
            C4990ab.m7410d("MicroMsg.ContactInfoUI", "initView, forceAddContact, user = ".concat(String.valueOf(nullAsNil2)));
            if (this.ehM == null || !C7486a.m12942jh(this.ehM.field_type)) {
                C26417a.flu.mo20967ai(nullAsNil2, "");
            } else {
                C26417a.flu.mo20967ai(nullAsNil2, this.ehq);
            }
        }
        if ((this.ehM == null || ((int) this.ehM.ewQ) == 0) && C7616ad.aox(nullAsNil2) && this.gwP != 15) {
            nullAsNil = C5046bo.nullAsNil(getIntent().getStringExtra(C5495b.yfT));
            if (C5046bo.isNullOrNil(nullAsNil)) {
                nullAsNil = this.mGZ;
            }
            C1720g.m3535RO().eJo.mo14541a(new C32877h(nullAsNil2, C5046bo.nullAsNil(this.ehq), nullAsNil), 0);
        }
        if (this.ehM != null && ((int) this.ehM.ewQ) > 0 && (!C1855t.m3924nJ(this.ehM.field_username) || (C7616ad.aow(this.ehM.field_username) && !C1855t.m3911mX(this.ehM.field_username)))) {
            if (this.ehM.dsi() && C7616ad.aox(this.ehM.field_username)) {
                nullAsNil = C5046bo.nullAsNil(getIntent().getStringExtra(C5495b.yfT));
                if (C5046bo.isNullOrNil(nullAsNil)) {
                    nullAsNil = this.mGZ;
                }
                C6300p c6300p = C1720g.m3535RO().eJo;
                String str2 = this.ehM.field_username;
                if (C7486a.m12942jh(this.ehM.field_type)) {
                    str = "";
                } else {
                    str = C5046bo.nullAsNil(this.ehq);
                }
                c6300p.mo14541a(new C32877h(str2, str, nullAsNil), 0);
            } else {
                C16527d qX = C17903f.m28104qX(this.ehM.field_username);
                obj = (this.ehM.dsf() && C32237a.adG()) ? 1 : null;
                if (qX == null || (qX.adJ() && obj == null)) {
                    C4990ab.m7411d("MicroMsg.ContactInfoUI", "update contact, verifyFlag %d.", Integer.valueOf(intExtra2));
                    C26417a.flu.mo20967ai(this.ehM.field_username, C7486a.m12942jh(this.ehM.field_type) ? "" : this.ehq);
                    C41730b.m73506pY(this.ehM.field_username);
                } else if (this.ehM.dsi() && obj == null) {
                    C4990ab.m7411d("MicroMsg.ContactInfoUI", "update contact, last check time=%d", Integer.valueOf(this.ehM.duj));
                    C9635b c9635b = C26417a.flu;
                    String str3 = this.ehM.field_username;
                    if (C7486a.m12942jh(this.ehM.field_type)) {
                        nullAsNil = "";
                    } else {
                        nullAsNil = this.ehq;
                    }
                    c9635b.mo20967ai(str3, nullAsNil);
                    C41730b.m73506pY(this.ehM.field_username);
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
        if (this.ehM == null || ((int) this.ehM.ewQ) == 0 || C5046bo.nullAsNil(this.ehM.field_username).length() <= 0) {
            this.ehM = new C7616ad();
            this.ehM.setUsername(nullAsNil2);
            this.ehM.mo14728iy(nullAsNil3);
            this.ehM.mo14703iB(stringExtra);
            this.ehM.mo14704iC(getIntent().getStringExtra("Contact_PyInitial"));
            this.ehM.mo14705iD(getIntent().getStringExtra("Contact_QuanPin"));
            this.ehM.mo14685hA(intExtra);
            this.ehM.mo14719iR(stringExtra2);
            this.ehM.mo14720iS(stringExtra3);
            this.ehM.mo14718iQ(stringExtra4);
            this.ehM.mo14698hw(intExtra2);
            this.ehM.mo14723iV(stringExtra5);
            this.ehM.mo14721iT(stringExtra6);
            this.ehM.mo14691hG(intExtra5);
            this.ehM.mo14722iU(stringExtra7);
            this.ehM.mo14697hv(intExtra3);
            this.ehM.mo14706iE(stringExtra8);
            this.ehM.mo14680eC(longExtra);
            this.ehM.mo14713iL(stringExtra9);
            this.ehM.mo14724iW(stringExtra10);
            this.ehM.mo14694hJ(intExtra4);
            if (!C5046bo.isNullOrNil(this.plm) && this.gwP == 15) {
                C9638aw.m17190ZK();
                C7575bv RB = C18628c.m29079XN().mo15364RB(nullAsNil2);
                C7575bv c7575bv = new C7575bv(nullAsNil2);
                c7575bv.field_conRemark = RB.field_conRemark;
                c7575bv.field_conDescription = RB.field_conDescription;
                c7575bv.field_contactLabels = RB.field_contactLabels;
                c7575bv.field_conPhone = this.plm;
                C9638aw.m17190ZK();
                C18628c.m29079XN().mo10099a(c7575bv);
                this.plm = null;
            }
            this.ehM.mo14735jf(stringExtra12);
            this.ehM.mo14695hK(intExtra6);
            this.ehM.mo14712iK(stringExtra11);
        } else {
            if (this.ehM.dtS == 0) {
                this.ehM.mo14685hA(intExtra);
            }
            if (!(stringExtra2 == null || stringExtra2.equals(""))) {
                this.ehM.mo14719iR(stringExtra2);
            }
            if (!(stringExtra3 == null || stringExtra3.equals(""))) {
                this.ehM.mo14720iS(stringExtra3);
            }
            if (stringExtra10 != null) {
                if (!stringExtra10.equals("")) {
                    this.ehM.mo14724iW(stringExtra10);
                }
            }
            if (!(!C5046bo.isNullOrNil(this.ehM.signature) || stringExtra4 == null || stringExtra4.equals(""))) {
                this.ehM.mo14718iQ(stringExtra4);
            }
            if (intExtra2 != 0) {
                this.ehM.mo14698hw(intExtra2);
            }
            if (!(!C5046bo.isNullOrNil(this.ehM.duh) || stringExtra5 == null || stringExtra5.equals(""))) {
                this.ehM.mo14723iV(stringExtra5);
            }
            if (!(!C5046bo.isNullOrNil(this.ehM.field_nickname) || stringExtra == null || stringExtra.equals(""))) {
                this.ehM.mo14703iB(stringExtra);
            }
            C4990ab.m7417i("MicroMsg.ContactInfoUI", "searchMobilePhone:%s", C5046bo.nullAsNil(this.plm));
            if (!C5046bo.isNullOrNil(this.plm) && this.gwP == 15) {
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
                    this.ehM.mo14733jd(str4 + this.plm + ",");
                    this.plm = null;
                }
                C4990ab.m7417i("MicroMsg.ContactInfoUI", "contact PhoneList:%s", C5046bo.nullAsNil(this.ehM.dur));
                this.ehM.setSource(15);
            }
            this.ehM.mo14721iT(stringExtra6);
            this.ehM.mo14691hG(intExtra5);
            this.ehM.mo14680eC(longExtra);
            this.ehM.mo14713iL(stringExtra9);
            if (!C7486a.m12942jh(this.ehM.field_type)) {
                if (!C5046bo.isNullOrNil(nullAsNil3)) {
                    this.ehM.mo14728iy(nullAsNil3);
                }
                if (!C5046bo.isNullOrNil(stringExtra)) {
                    this.ehM.mo14703iB(stringExtra);
                }
                nullAsNil5 = getIntent().getStringExtra("Contact_PyInitial");
                if (!C5046bo.isNullOrNil(nullAsNil5)) {
                    this.ehM.mo14704iC(nullAsNil5);
                }
                nullAsNil5 = getIntent().getStringExtra("Contact_QuanPin");
                if (!C5046bo.isNullOrNil(nullAsNil5)) {
                    this.ehM.mo14705iD(nullAsNil5);
                }
            }
            if (!(C7486a.m12942jh(this.ehM.field_type) || C5046bo.isNullOrNil(stringExtra12))) {
                this.ehM.mo14735jf(stringExtra12);
            }
            if (!(C7486a.m12942jh(this.ehM.field_type) || intExtra6 == 0)) {
                this.ehM.mo14695hK(intExtra6);
            }
            if (!C5046bo.isNullOrNil(stringExtra11)) {
                this.ehM.mo14712iK(stringExtra11);
            }
        }
        if (C7616ad.aox(this.ehM.field_username) && (this.gwP == 30 || this.gwP == 45 || this.gwP == 17)) {
            C7060h c7060h = C7060h.pYm;
            Object[] objArr = new Object[2];
            objArr[0] = this.ehM.field_openImAppid;
            objArr[1] = Integer.valueOf(this.gwP == 17 ? 2 : 1);
            c7060h.mo8381e(15320, objArr);
        }
        if (!C5046bo.isNullOrNil(nullAsNil4)) {
            this.ehM.mo14709iH(nullAsNil4);
        }
        m32921fD(nullAsNil2, nullAsNil4);
        getIntent().putExtra("Contact_User", this.ehM.field_username);
        if (!booleanExtra && ((int) this.ehM.ewQ) <= 0 && this.ehM.dsf() && (this.gwP == 17 || this.gwP == 41)) {
            C4990ab.m7411d("MicroMsg.ContactInfoUI", "come from card, getContact %s", this.ehM.field_username);
            C26417a.flu.mo20967ai(this.ehM.field_username, "");
            C41730b.m73506pY(this.ehM.field_username);
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
        objArr2[2] = this.ehM.dul == null ? "" : C5046bo.anv(this.ehM.dul);
        C4990ab.m7417i(nullAsNil5, str, objArr2);
        if (!booleanExtra && ((int) this.ehM.ewQ) <= 0 && this.gwP == 96) {
            C4990ab.m7417i("MicroMsg.ContactInfoUI", "come from chatroom accessverify, getContact %s", this.ehM.field_username);
            C26417a.flu.mo20968aj(this.ehM.field_username, getIntent().getStringExtra("key_add_contact_verify_ticket"));
            C41730b.m73489U(this.ehM.field_username, 3);
        }
        if (this.ehM.field_username.equals(C1853r.m3846Yz())) {
            C7616ad c7616ad;
            C9638aw.m17190ZK();
            long j = C5046bo.getLong((String) C18628c.m29072Ry().get(65825, null), 0);
            if (j > 0) {
                this.ehM.mo14680eC(j);
                c7616ad = this.ehM;
                C9638aw.m17190ZK();
                c7616ad.mo14713iL((String) C18628c.m29072Ry().get(65826, null));
            }
            c7616ad = this.ehM;
            C9638aw.m17190ZK();
            c7616ad.mo14727iZ((String) C18628c.m29072Ry().get(286721, null));
            c7616ad = this.ehM;
            C9638aw.m17190ZK();
            c7616ad.mo14730ja((String) C18628c.m29072Ry().get(286722, null));
            c7616ad = this.ehM;
            C9638aw.m17190ZK();
            c7616ad.mo14731jb((String) C18628c.m29072Ry().get(286723, null));
        }
        if (this.ehM.field_username != null && this.ehM.field_username.equals(C7616ad.aoC(C1853r.m3846Yz()))) {
            C32782bp aao = C32782bp.aao();
            nullAsNil5 = C5046bo.nullAsNil(aao.getProvince());
            str = C5046bo.nullAsNil(aao.getCity());
            if (!C5046bo.isNullOrNil(nullAsNil5)) {
                this.ehM.mo14719iR(nullAsNil5);
            }
            if (!C5046bo.isNullOrNil(str)) {
                this.ehM.mo14720iS(str);
            }
            if (!C5046bo.isNullOrNil(aao.countryCode)) {
                this.ehM.mo14724iW(RegionCodeDecoder.m7796aC(aao.countryCode, aao.fnp, aao.fno));
            }
            int a = C5046bo.m7512a(Integer.valueOf(aao.dtS), 0);
            nullAsNil4 = C5046bo.nullAsNil(aao.signature);
            this.ehM.mo14685hA(a);
            this.ehM.mo14718iQ(nullAsNil4);
        }
        if (C5046bo.isNullOrNil(this.ehM.field_username)) {
            C4990ab.m7413e("MicroMsg.ContactInfoUI", "username is null %s", nullAsNil2);
            finish();
            AppMethodBeat.m2505o(23372);
            return;
        }
        setMMTitle("");
        m32913UO(this.pln);
        setBackBtn(new C214646());
        C17884o.acv().mo67496qa(this.ehM.field_username);
        if ((C1855t.m3946no(this.ehM.field_username) && C1853r.m3838YT()) || ((C1855t.m3938ng(this.ehM.field_username) && C1853r.m3834YP()) || ((C1855t.m3940ni(this.ehM.field_username) && C1853r.m3843YY()) || (C1855t.m3934nc(this.ehM.field_username) && C1853r.m3848Zb())))) {
            this.pll = true;
            AppMethodBeat.m2505o(23372);
            return;
        }
        this.pll = false;
        AppMethodBeat.m2505o(23372);
    }

    /* renamed from: a */
    public final boolean mo8453a(C15541f c15541f, Preference preference) {
        AppMethodBeat.m2504i(23376);
        String str = preference.mKey;
        C4990ab.m7416i("MicroMsg.ContactInfoUI", str + " item has been clicked!");
        if (this.plh != null) {
            this.plh.mo7077IO(str);
        }
        if (preference != null) {
            if (preference.mKey.equals("contact_info_sns")) {
                C7060h.pYm.mo8381e(16055, Integer.valueOf(C34696c.m56965am(getIntent())), Integer.valueOf(3));
            } else if (preference.mKey.equals("contact_info_more")) {
                C7060h.pYm.mo8381e(16055, Integer.valueOf(C34696c.m56965am(getIntent())), Integer.valueOf(6));
            }
        }
        if (preference instanceof NormalProfileHeaderPreference) {
            caG();
        }
        AppMethodBeat.m2505o(23376);
        return false;
    }

    /* renamed from: b */
    static /* synthetic */ void m32916b(ContactInfoUI contactInfoUI) {
        AppMethodBeat.m2504i(23389);
        if (C1443d.m3068iW(19)) {
            contactInfoUI.getWindow().setFlags(201327616, 201327616);
            AppMethodBeat.m2505o(23389);
            return;
        }
        contactInfoUI.getWindow().setFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
        AppMethodBeat.m2505o(23389);
    }
}
