package com.tencent.p177mm.plugin.profile.p483ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.gms.auth.api.proxy.AuthApiStatusCodes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1829bf;
import com.tencent.p177mm.model.C1829bf.C1827a;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C26415ao.C26417a;
import com.tencent.p177mm.model.C26415ao.C9635b.C9636a;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.network.C32856ab;
import com.tencent.p177mm.openim.p1210a.C37974a;
import com.tencent.p177mm.p1374bi.C25860a;
import com.tencent.p177mm.p1374bi.C37512c;
import com.tencent.p177mm.p1374bi.C41789d;
import com.tencent.p177mm.p1510r.C35973a;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p201az.C37498c;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p230g.p231a.C18411uh;
import com.tencent.p177mm.p230g.p231a.C26250ui;
import com.tencent.p177mm.p230g.p231a.C42062sz;
import com.tencent.p177mm.p230g.p232b.p233a.C32678u;
import com.tencent.p177mm.p264n.C7486a;
import com.tencent.p177mm.p612ui.C5510e.C5495b;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C40671n.C36073c;
import com.tencent.p177mm.p612ui.base.C40671n.C5279d;
import com.tencent.p177mm.p612ui.base.C44273l;
import com.tencent.p177mm.p612ui.base.C44275p;
import com.tencent.p177mm.p612ui.base.preference.Preference;
import com.tencent.p177mm.p612ui.widget.p633a.C36356d;
import com.tencent.p177mm.p840bn.C9089a;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.platformtools.C26529w;
import com.tencent.p177mm.plugin.account.C32923a;
import com.tencent.p177mm.plugin.account.friend.p272a.C18817a;
import com.tencent.p177mm.plugin.account.friend.p272a.C45497g;
import com.tencent.p177mm.plugin.account.friend.p272a.C9878ao;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2206au;
import com.tencent.p177mm.plugin.appbrand.jsapi.C42464aa;
import com.tencent.p177mm.plugin.base.model.C42781b;
import com.tencent.p177mm.plugin.normsg.p473a.C6998b;
import com.tencent.p177mm.plugin.profile.C34696c;
import com.tencent.p177mm.plugin.profile.C39503b;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.pluginsdk.model.C46498m;
import com.tencent.p177mm.pluginsdk.p597ui.applet.C14916a;
import com.tencent.p177mm.pluginsdk.p597ui.applet.C14916a.C14917a;
import com.tencent.p177mm.pluginsdk.p597ui.applet.C14916a.C14918b;
import com.tencent.p177mm.pluginsdk.p597ui.preference.C14957b;
import com.tencent.p177mm.pluginsdk.p597ui.tools.C35891h;
import com.tencent.p177mm.pluginsdk.permission.C35805b;
import com.tencent.p177mm.pluginsdk.wallet.C40492e;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p603e.C4934l;
import com.tencent.p177mm.sdk.p603e.C4935m;
import com.tencent.p177mm.sdk.p603e.C7296k.C4931a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7616ad;
import com.tencent.view.C31128d;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

/* renamed from: com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference */
public class NormalUserFooterPreference extends Preference implements C4931a {
    private MMActivity crP;
    public ProgressDialog ehJ = null;
    private C7616ad ehM;
    protected C4934l<C12838e, String> fry = new C214711();
    private int gwP;
    private String jEs = null;
    private boolean lyb;
    private String mGZ = "";
    private Button oik;
    private boolean pkC = false;
    private boolean pli;
    private int pmD = 0;
    private int pmV;
    private String pnd = "";
    private boolean pni = false;
    private long pnz = 0;
    private View poA;
    private Button poB;
    private Button poC;
    private Button poD;
    private View poE;
    private Button poF;
    private TextView poG;
    private View poH;
    private Button poI;
    private Button poJ;
    private Button poK;
    private Button poL;
    private Button poM;
    private Button poN;
    private TextView poO;
    private boolean poP = false;
    public boolean poQ = false;
    private boolean pov;
    private boolean pow;
    private boolean pox = false;
    private boolean poy = false;
    private C34717a poz;

    /* renamed from: com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference$e */
    public interface C12838e {
    }

    /* renamed from: com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference$f */
    class C12839f extends C34717a {

        /* renamed from: com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference$f$1 */
        class C128401 implements OnClickListener {
            C128401() {
            }

            public final void onClick(View view) {
                AppMethodBeat.m2504i(23711);
                C6998b.oTO.mo8097ae(1, 1, 5);
                Intent intent = new Intent();
                intent.putExtra("Contact_User", NormalUserFooterPreference.this.ehM.field_username);
                intent.putExtra("Contact_Scene", NormalUserFooterPreference.this.gwP);
                intent.putExtra(C5495b.yfT, NormalUserFooterPreference.this.ehM.dus);
                C39503b.gkE.mo38897a(intent, NormalUserFooterPreference.this.mContext);
                AppMethodBeat.m2505o(23711);
            }
        }

        public C12839f() {
            super();
        }

        /* Access modifiers changed, original: protected|final */
        public final void cbp() {
            AppMethodBeat.m2504i(23712);
            if (NormalUserFooterPreference.this.ehM == null || !C7486a.m12942jh(NormalUserFooterPreference.this.ehM.field_type)) {
                mo55325F(false, true);
                AppMethodBeat.m2505o(23712);
                return;
            }
            cbo();
            AppMethodBeat.m2505o(23712);
        }

        /* Access modifiers changed, original: protected|final */
        public final void cbn() {
            AppMethodBeat.m2504i(23713);
            NormalUserFooterPreference.this.poA.setVisibility(8);
            NormalUserFooterPreference.this.poH.setVisibility(0);
            NormalUserFooterPreference.this.poK.setVisibility(8);
            NormalUserFooterPreference.this.oik.setVisibility(8);
            NormalUserFooterPreference.this.poN.setVisibility(8);
            NormalUserFooterPreference.this.poL.setVisibility(8);
            NormalUserFooterPreference.this.poM.setVisibility(8);
            NormalUserFooterPreference.this.poO.setVisibility(8);
            NormalUserFooterPreference.this.poJ.setOnClickListener(new C128401());
            AppMethodBeat.m2505o(23713);
        }
    }

    /* renamed from: com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference$1 */
    class C214711 extends C4934l<C12838e, String> {
        C214711() {
        }

        /* renamed from: a */
        public final /* synthetic */ void mo10125a(Object obj, Looper looper) {
            AppMethodBeat.m2504i(23670);
            C12838e c12838e = (C12838e) obj;
            if (looper == null) {
                looper = Looper.getMainLooper();
            }
            super.mo10125a(c12838e, looper);
            AppMethodBeat.m2505o(23670);
        }

        /* renamed from: w */
        public final /* synthetic */ void mo10134w(Object obj, Object obj2) {
            AppMethodBeat.m2504i(23669);
            String str = (String) obj2;
            if (str.equals("show_btn")) {
                NormalUserFooterPreference.this.ehM;
                AppMethodBeat.m2505o(23669);
                return;
            }
            if (str.equals("hide_btn")) {
                NormalUserFooterPreference.this.ehM;
            }
            AppMethodBeat.m2505o(23669);
        }
    }

    /* renamed from: com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference$c */
    class C21474c extends C34717a {

        /* renamed from: com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference$c$2 */
        class C128362 implements OnClickListener {
            C128362() {
            }

            public final void onClick(View view) {
                AppMethodBeat.m2504i(23700);
                if (NormalUserFooterPreference.this.crP.getIntent() != null) {
                    String stringExtra = NormalUserFooterPreference.this.crP.getIntent().getStringExtra("key_ww_add_session_id");
                    if (!C5046bo.isNullOrNil(stringExtra)) {
                        C32678u c32678u = new C32678u();
                        c32678u.mo53209eP(stringExtra);
                        c32678u.cXR = 0;
                        c32678u.cXT = 1;
                        c32678u.ajK();
                    }
                }
                C21474c.this.cbs();
                if (NormalUserFooterPreference.this.pmD != 0) {
                    C7060h.pYm.mo8381e(11263, Integer.valueOf(NormalUserFooterPreference.this.pmD), NormalUserFooterPreference.this.ehM.field_username);
                }
                AppMethodBeat.m2505o(23700);
            }
        }

        /* renamed from: com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference$c$3 */
        class C128373 implements C14917a {
            C128373() {
            }

            /* renamed from: a */
            public final void mo5739a(boolean z, boolean z2, String str, String str2) {
                AppMethodBeat.m2504i(23701);
                if (z) {
                    NormalUserFooterPreference.this.fry.mo10126cF("hide_btn");
                    NormalUserFooterPreference.this.fry.doNotify();
                    NormalUserFooterPreference.this.poP = true;
                    C21474c.m32937a(C21474c.this);
                } else if (z2) {
                    C41789d.akP().mo17076ep(str, 2);
                } else {
                    C4990ab.m7412e("MicroMsg.NormalUserFooterPreference", "canAddContact fail, maybe interrupt by IOnNeedSentVerify, username = ".concat(String.valueOf(str)));
                }
                if (z || z2) {
                    Intent intent = NormalUserFooterPreference.this.crP.getIntent();
                    int intExtra = intent.getIntExtra("search_kvstat_scene", 0);
                    int intExtra2 = intent.getIntExtra("search_kvstat_position", 0);
                    if (intExtra > 0 && intExtra2 > 0) {
                        C7060h.pYm.mo8381e(10991, Integer.valueOf(intExtra), Integer.valueOf(6), Integer.valueOf(intExtra2));
                    }
                }
                AppMethodBeat.m2505o(23701);
            }
        }

        /* renamed from: com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference$c$1 */
        class C214751 implements OnClickListener {
            C214751() {
            }

            public final void onClick(View view) {
                AppMethodBeat.m2504i(23699);
                C21474c.this.cbr();
                AppMethodBeat.m2505o(23699);
            }
        }

        public C21474c() {
            super();
        }

        /* Access modifiers changed, original: protected|final */
        /* renamed from: Xy */
        public final void mo36951Xy() {
            AppMethodBeat.m2504i(23704);
            super.mo36951Xy();
            AppMethodBeat.m2505o(23704);
        }

        /* Access modifiers changed, original: protected */
        public void onDetach() {
            AppMethodBeat.m2504i(23705);
            super.onDetach();
            AppMethodBeat.m2505o(23705);
        }

        /* Access modifiers changed, original: protected */
        public void cbn() {
            AppMethodBeat.m2504i(23706);
            Assert.assertTrue(!C1855t.m3923nI(NormalUserFooterPreference.this.ehM.field_username));
            NormalUserFooterPreference.this.poA.setVisibility(8);
            NormalUserFooterPreference.this.poH.setVisibility(8);
            if (NormalUserFooterPreference.this.pni) {
                NormalUserFooterPreference.this.poC.setOnClickListener(new C214751());
                if (C7486a.m12942jh(NormalUserFooterPreference.this.ehM.field_type)) {
                    NormalUserFooterPreference.this.poC.setVisibility(0);
                } else {
                    NormalUserFooterPreference.this.poC.setVisibility(8);
                }
                NormalUserFooterPreference.this.poK.setVisibility(8);
                NormalUserFooterPreference.this.oik.setVisibility(8);
                NormalUserFooterPreference.this.poN.setVisibility(8);
                NormalUserFooterPreference.this.poL.setVisibility(8);
                NormalUserFooterPreference.this.poO.setVisibility(8);
                AppMethodBeat.m2505o(23706);
                return;
            }
            NormalUserFooterPreference.this.poK.setOnClickListener(new C128362());
            if (C7486a.m12942jh(NormalUserFooterPreference.this.ehM.field_type)) {
                NormalUserFooterPreference.this.poK.setVisibility(8);
                NormalUserFooterPreference.this.oik.setVisibility(0);
                if (NormalUserFooterPreference.this.cbk() || NormalUserFooterPreference.this.ehM.field_username.equals(C1853r.m3846Yz()) || C1855t.m3923nI(NormalUserFooterPreference.this.ehM.field_username) || C1855t.m3916nB(NormalUserFooterPreference.this.ehM.field_username) || C7616ad.aox(NormalUserFooterPreference.this.ehM.field_username) || C1855t.m3911mX(NormalUserFooterPreference.this.ehM.field_username)) {
                    NormalUserFooterPreference.this.poL.setVisibility(8);
                } else {
                    NormalUserFooterPreference.this.poL.setVisibility(0);
                }
                C9638aw.m17190ZK();
                if (C18628c.m29078XM().aoR(NormalUserFooterPreference.this.ehM.field_username)) {
                    NormalUserFooterPreference.this.poM.setVisibility(0);
                    NormalUserFooterPreference.this.gwP = NormalUserFooterPreference.this.ehM.getSource();
                }
            } else {
                NormalUserFooterPreference.this.poK.setVisibility(0);
                NormalUserFooterPreference.this.oik.setVisibility(8);
                NormalUserFooterPreference.this.poN.setVisibility(8);
                NormalUserFooterPreference.this.poL.setVisibility(8);
            }
            if (NormalUserFooterPreference.this.ehM.mo16698Oa()) {
                NormalUserFooterPreference.this.poO.setVisibility(0);
                AppMethodBeat.m2505o(23706);
                return;
            }
            NormalUserFooterPreference.this.poO.setVisibility(8);
            AppMethodBeat.m2505o(23706);
        }

        /* Access modifiers changed, original: protected|final */
        public final void cbs() {
            AppMethodBeat.m2504i(23707);
            if (((int) NormalUserFooterPreference.this.ehM.ewQ) == 0) {
                C9638aw.m17190ZK();
                if (C18628c.m29078XM().mo15708aa(NormalUserFooterPreference.this.ehM) != -1) {
                    NormalUserFooterPreference normalUserFooterPreference = NormalUserFooterPreference.this;
                    C9638aw.m17190ZK();
                    normalUserFooterPreference.ehM = C18628c.m29078XM().aoO(NormalUserFooterPreference.this.ehM.field_username);
                }
            }
            if (NormalUserFooterPreference.this.pov || NormalUserFooterPreference.this.gwP == 12) {
                C4990ab.m7410d("MicroMsg.NormalUserFooterPreference", "qqNum " + NormalUserFooterPreference.this.pnz + " qqReamrk " + NormalUserFooterPreference.this.pnd);
                if (!(NormalUserFooterPreference.this.pnz == 0 || NormalUserFooterPreference.this.pnd == null || NormalUserFooterPreference.this.pnd.equals(""))) {
                    C9878ao ge = C32923a.getQQListStg().mo73284ge(NormalUserFooterPreference.this.pnz);
                    if (ge == null) {
                        ge = new C9878ao();
                        ge.nickname = "";
                        ge.gwC = NormalUserFooterPreference.this.pnz;
                        ge.gwK = NormalUserFooterPreference.this.pnd;
                        ge.username = NormalUserFooterPreference.this.ehM.field_username;
                        ge.aqu();
                        C32923a.getQQListStg().mo73282a(ge);
                    } else {
                        ge.gwC = NormalUserFooterPreference.this.pnz;
                        ge.gwK = NormalUserFooterPreference.this.pnd;
                        ge.username = NormalUserFooterPreference.this.ehM.field_username;
                        ge.aqu();
                        C32923a.getQQListStg().mo73281a(NormalUserFooterPreference.this.pnz, ge);
                    }
                }
            } else if (NormalUserFooterPreference.this.gwP == 58 || NormalUserFooterPreference.this.gwP == 59 || NormalUserFooterPreference.this.gwP == 60) {
                C32923a.getGoogleFriendStorage().mo60780ak(NormalUserFooterPreference.this.ehM.field_username, 1);
            }
            cbt();
            final C14916a c14916a = new C14916a(NormalUserFooterPreference.this.mContext, new C128373());
            final LinkedList linkedList = new LinkedList();
            linkedList.add(Integer.valueOf(NormalUserFooterPreference.this.gwP));
            final String stringExtra = NormalUserFooterPreference.this.crP.getIntent().getStringExtra("source_from_user_name");
            final String stringExtra2 = NormalUserFooterPreference.this.crP.getIntent().getStringExtra("source_from_nick_name");
            c14916a.mo27245hH(stringExtra, stringExtra2);
            c14916a.vjI = new C14918b() {
                /* renamed from: vQ */
                public final boolean mo8211vQ(String str) {
                    AppMethodBeat.m2504i(23702);
                    String stringExtra = NormalUserFooterPreference.this.crP.getIntent().getStringExtra("room_name");
                    Intent intent = new Intent(NormalUserFooterPreference.this.crP, SayHiWithSnsPermissionUI.class);
                    intent.putExtra("Contact_User", NormalUserFooterPreference.this.ehM.field_username);
                    intent.putExtra("Contact_Nick", NormalUserFooterPreference.this.ehM.field_nickname);
                    intent.putExtra("Contact_RemarkName", NormalUserFooterPreference.this.ehM.field_conRemark);
                    if (NormalUserFooterPreference.this.gwP == 14 || NormalUserFooterPreference.this.gwP == 8) {
                        intent.putExtra("Contact_RoomNickname", NormalUserFooterPreference.this.crP.getIntent().getStringExtra("Contact_RoomNickname"));
                    }
                    intent.putExtra("Contact_Scene", NormalUserFooterPreference.this.gwP);
                    intent.putExtra("room_name", stringExtra);
                    intent.putExtra("source_from_user_name", stringExtra);
                    intent.putExtra("source_from_nick_name", stringExtra2);
                    intent.putExtra("sayhi_with_sns_perm_send_verify", true);
                    intent.putExtra("sayhi_with_sns_perm_add_remark", true);
                    intent.putExtra("sayhi_with_sns_perm_set_label", false);
                    intent.putExtra(C5495b.yfT, str);
                    NormalUserFooterPreference.this.crP.startActivityForResult(intent, 0);
                    AppMethodBeat.m2505o(23702);
                    return true;
                }
            };
            stringExtra2 = NormalUserFooterPreference.this.crP.getIntent().getStringExtra("room_name");
            stringExtra = NormalUserFooterPreference.this.crP.getIntent().getStringExtra(C5495b.yfT);
            if (!TextUtils.isEmpty(stringExtra)) {
                C4990ab.m7417i("MicroMsg.NormalUserFooterPreference", "add contact case 1:%s", stringExtra);
                c14916a.ajw(stringExtra);
                c14916a.mo27243c(NormalUserFooterPreference.this.ehM.field_username, "", linkedList);
                AppMethodBeat.m2505o(23707);
            } else if (TextUtils.isEmpty(stringExtra2)) {
                C4990ab.m7417i("MicroMsg.NormalUserFooterPreference", "add contact case 2, %s", NormalUserFooterPreference.this.ehM.dus);
                c14916a.ajw(NormalUserFooterPreference.this.ehM.dus);
                c14916a.mo27244e(NormalUserFooterPreference.this.ehM.field_username, linkedList);
                AppMethodBeat.m2505o(23707);
            } else if (TextUtils.isEmpty(c14916a.mGZ)) {
                C9638aw.m17190ZK();
                C7616ad aoO = C18628c.m29078XM().aoO(NormalUserFooterPreference.this.ehM.field_username);
                CharSequence bc = aoO != null ? C5046bo.m7532bc(aoO.dus, "") : "";
                C4990ab.m7417i("MicroMsg.NormalUserFooterPreference", "dkverify footer add:%s chat:%s ticket:%s", NormalUserFooterPreference.this.ehM.field_username, stringExtra2, bc);
                if (TextUtils.isEmpty(bc)) {
                    C26417a.flu.mo20966a(NormalUserFooterPreference.this.ehM.field_username, stringExtra2, new C9636a() {
                        /* renamed from: o */
                        public final void mo6218o(String str, boolean z) {
                            AppMethodBeat.m2504i(23703);
                            C9638aw.m17190ZK();
                            C7616ad aoO = C18628c.m29078XM().aoO(NormalUserFooterPreference.this.ehM.field_username);
                            c14916a.ajw(aoO != null ? C5046bo.m7532bc(aoO.dus, "") : "");
                            c14916a.mo27243c(NormalUserFooterPreference.this.ehM.field_username, stringExtra2, linkedList);
                            AppMethodBeat.m2505o(23703);
                        }
                    });
                    AppMethodBeat.m2505o(23707);
                    return;
                }
                c14916a.ajw(bc);
                c14916a.mo27243c(NormalUserFooterPreference.this.ehM.field_username, stringExtra2, linkedList);
                AppMethodBeat.m2505o(23707);
            } else {
                C4990ab.m7417i("MicroMsg.NormalUserFooterPreference", "add contact case 3, %s", NormalUserFooterPreference.this.ehM.dus);
                c14916a.ajw(NormalUserFooterPreference.this.ehM.dus);
                c14916a.mo27243c(NormalUserFooterPreference.this.ehM.field_username, stringExtra2, linkedList);
                AppMethodBeat.m2505o(23707);
            }
        }

        private void cbt() {
            AppMethodBeat.m2504i(23708);
            String stringExtra = NormalUserFooterPreference.this.crP.getIntent().getStringExtra("Contact_Mobile_MD5");
            String stringExtra2 = NormalUserFooterPreference.this.crP.getIntent().getStringExtra("Contact_full_Mobile_MD5");
            String nullAsNil = C5046bo.nullAsNil(stringExtra);
            stringExtra = C5046bo.nullAsNil(stringExtra2);
            if (!(nullAsNil.equals("") && stringExtra.equals(""))) {
                C18817a vW = C32923a.getAddrUploadStg().mo34092vW(nullAsNil);
                if (vW == null) {
                    vW = C32923a.getAddrUploadStg().mo34092vW(stringExtra);
                } else {
                    stringExtra = nullAsNil;
                }
                if (vW == null) {
                    AppMethodBeat.m2505o(23708);
                    return;
                }
                C32923a.getAddrUploadStg().mo34084a(stringExtra, vW);
            }
            AppMethodBeat.m2505o(23708);
        }

        /* renamed from: a */
        static /* synthetic */ void m32937a(C21474c c21474c) {
            int i = 0;
            AppMethodBeat.m2504i(23709);
            if (((int) NormalUserFooterPreference.this.ehM.ewQ) == 0) {
                C9638aw.m17190ZK();
                C18628c.m29078XM().mo15708aa(NormalUserFooterPreference.this.ehM);
                C9638aw.m17190ZK();
                C18628c.m29078XM().aoO(NormalUserFooterPreference.this.ehM.field_username);
            }
            if (((int) NormalUserFooterPreference.this.ehM.ewQ) <= 0) {
                C4990ab.m7412e("MicroMsg.NormalUserFooterPreference", "addContact : insert contact failed");
                AppMethodBeat.m2505o(23709);
                return;
            }
            if (!C7486a.m12942jh(NormalUserFooterPreference.this.ehM.field_type) && NormalUserFooterPreference.this.gwP == 15) {
                C18817a vT = C32923a.getAddrUploadStg().mo34089vT(NormalUserFooterPreference.this.ehM.field_username);
                if (vT != null) {
                    C7060h c7060h = C7060h.pYm;
                    Object[] objArr = new Object[4];
                    objArr[0] = NormalUserFooterPreference.this.ehM.field_username;
                    objArr[1] = Integer.valueOf(3);
                    if (!C5046bo.isNullOrNil(vT.mo34067Aq())) {
                        i = 1;
                    }
                    objArr[2] = Integer.valueOf(i);
                    objArr[3] = Integer.valueOf(NormalUserFooterPreference.this.ehM.dur.toString().split(",").length >= 5 ? 5 : NormalUserFooterPreference.this.ehM.dur.toString().split(",").length);
                    c7060h.mo8381e(12040, objArr);
                }
            }
            C1855t.m3960q(NormalUserFooterPreference.this.ehM);
            NormalUserFooterPreference normalUserFooterPreference = NormalUserFooterPreference.this;
            C9638aw.m17190ZK();
            normalUserFooterPreference.ehM = C18628c.m29078XM().aoO(NormalUserFooterPreference.this.ehM.field_username);
            c21474c.cbn();
            AppMethodBeat.m2505o(23709);
        }
    }

    /* renamed from: com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference$2 */
    class C286862 implements Runnable {
        C286862() {
        }

        public final void run() {
            AppMethodBeat.m2504i(23671);
            NormalUserFooterPreference.this.cbk();
            AppMethodBeat.m2505o(23671);
        }
    }

    /* renamed from: com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference$d */
    class C28691d extends C34717a {
        public C28691d() {
            super();
        }

        /* Access modifiers changed, original: protected|final */
        public final void cbp() {
        }

        /* Access modifiers changed, original: protected|final */
        public final void cbn() {
            AppMethodBeat.m2504i(23710);
            Assert.assertTrue(C1855t.m3943nl(NormalUserFooterPreference.this.ehM.field_username));
            NormalUserFooterPreference.this.poA.setVisibility(8);
            NormalUserFooterPreference.this.poH.setVisibility(8);
            NormalUserFooterPreference.this.poK.setVisibility(8);
            NormalUserFooterPreference.this.oik.setVisibility(0);
            NormalUserFooterPreference.this.poN.setVisibility(8);
            NormalUserFooterPreference.this.poL.setVisibility(8);
            NormalUserFooterPreference.this.poM.setVisibility(8);
            NormalUserFooterPreference.this.poO.setVisibility(8);
            AppMethodBeat.m2505o(23710);
        }
    }

    /* renamed from: com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference$g */
    class C34710g extends C34717a {
        public C34710g() {
            super();
        }

        public final void cbp() {
        }

        /* Access modifiers changed, original: protected|final */
        public final void cbn() {
            boolean z = true;
            AppMethodBeat.m2504i(23714);
            Assert.assertTrue(!C1853r.m3858mG(NormalUserFooterPreference.this.ehM.field_username));
            if (C1855t.m3923nI(NormalUserFooterPreference.this.ehM.field_username)) {
                z = false;
            }
            Assert.assertTrue(z);
            NormalUserFooterPreference.this.poA.setVisibility(8);
            NormalUserFooterPreference.this.poH.setVisibility(8);
            NormalUserFooterPreference.this.oik.setText(C25738R.string.b02);
            NormalUserFooterPreference.this.oik.setVisibility(0);
            NormalUserFooterPreference.this.poL.setVisibility(8);
            NormalUserFooterPreference.this.poK.setVisibility(8);
            NormalUserFooterPreference.this.poO.setVisibility(8);
            AppMethodBeat.m2505o(23714);
        }
    }

    /* renamed from: com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference$h */
    class C34711h extends C34717a {
        public C34711h() {
            super();
        }

        /* Access modifiers changed, original: protected|final */
        public final void cbp() {
        }

        /* Access modifiers changed, original: protected|final */
        public final void cbn() {
            AppMethodBeat.m2504i(23715);
            NormalUserFooterPreference.this.poA.setVisibility(8);
            NormalUserFooterPreference.this.oik.setVisibility(0);
            if (NormalUserFooterPreference.this.cbk() || NormalUserFooterPreference.this.ehM.field_username.equals(C1853r.m3846Yz()) || C1855t.m3923nI(NormalUserFooterPreference.this.ehM.field_username) || C1855t.m3916nB(NormalUserFooterPreference.this.ehM.field_username)) {
                NormalUserFooterPreference.this.poL.setVisibility(8);
            } else {
                NormalUserFooterPreference.this.poL.setVisibility(0);
            }
            NormalUserFooterPreference.this.oik.setText(C25738R.string.azy);
            NormalUserFooterPreference.this.poK.setVisibility(8);
            NormalUserFooterPreference.this.poH.setVisibility(8);
            NormalUserFooterPreference.this.poO.setVisibility(8);
            AppMethodBeat.m2505o(23715);
        }
    }

    /* renamed from: com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference$i */
    class C34713i extends C21474c implements C1202f {
        private ProgressDialog ehJ;

        /* renamed from: com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference$i$2 */
        class C36262 implements OnCancelListener {
            C36262() {
            }

            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.m2504i(23717);
                C34713i.this.onStop();
                Intent intent = new Intent();
                intent.putExtra("Intro_Switch", true).addFlags(67108864);
                C39503b.gkE.mo38931p(intent, NormalUserFooterPreference.this.mContext);
                AppMethodBeat.m2505o(23717);
            }
        }

        /* renamed from: com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference$i$3 */
        class C36273 implements DialogInterface.OnClickListener {
            C36273() {
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.m2504i(23718);
                C34713i.this.cbs();
                AppMethodBeat.m2505o(23718);
            }
        }

        /* renamed from: com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference$i$1 */
        class C347121 implements DialogInterface.OnClickListener {
            C347121() {
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.m2504i(23716);
                C34713i.this.onStop();
                Intent intent = new Intent();
                intent.putExtra("Intro_Switch", true).addFlags(67108864);
                C39503b.gkE.mo38931p(intent, NormalUserFooterPreference.this.mContext);
                AppMethodBeat.m2505o(23716);
            }
        }

        public C34713i() {
            super();
        }

        /* Access modifiers changed, original: protected */
        public void cbn() {
            AppMethodBeat.m2504i(23719);
            onDetach();
            onStop();
            C9638aw.m17182Rg().mo14539a(30, (C1202f) this);
            C9638aw.m17182Rg().mo14539a(667, (C1202f) this);
            C9638aw.m17182Rg().mo14539a(853, (C1202f) this);
            super.cbn();
            AppMethodBeat.m2505o(23719);
        }

        /* Access modifiers changed, original: final */
        public final void onStop() {
            AppMethodBeat.m2504i(23720);
            C9638aw.m17182Rg().mo14546b(30, (C1202f) this);
            C9638aw.m17182Rg().mo14546b(667, (C1202f) this);
            C9638aw.m17182Rg().mo14546b(853, (C1202f) this);
            AppMethodBeat.m2505o(23720);
        }

        /* Access modifiers changed, original: protected */
        public void onDetach() {
            AppMethodBeat.m2504i(23721);
            if (this.ehJ != null) {
                this.ehJ.dismiss();
                this.ehJ = null;
            }
            if (NormalUserFooterPreference.this.poA != null) {
                NormalUserFooterPreference.this.poA.setVisibility(8);
            }
            if (NormalUserFooterPreference.this.poH != null) {
                NormalUserFooterPreference.this.poH.setVisibility(0);
            }
            if (NormalUserFooterPreference.this.oik != null) {
                NormalUserFooterPreference.this.oik.setVisibility(8);
            }
            if (NormalUserFooterPreference.this.poN != null) {
                NormalUserFooterPreference.this.poN.setVisibility(8);
            }
            if (NormalUserFooterPreference.this.poL != null) {
                NormalUserFooterPreference.this.poL.setVisibility(8);
            }
            if (NormalUserFooterPreference.this.poK != null) {
                NormalUserFooterPreference.this.poK.setVisibility(8);
            }
            if (NormalUserFooterPreference.this.poO != null) {
                NormalUserFooterPreference.this.poO.setVisibility(8);
            }
            onStop();
            AppMethodBeat.m2505o(23721);
        }

        /* renamed from: NB */
        private void m56977NB() {
            AppMethodBeat.m2504i(23722);
            NormalUserFooterPreference normalUserFooterPreference = NormalUserFooterPreference.this;
            C9638aw.m17190ZK();
            C7616ad aoO = C18628c.m29078XM().aoO(NormalUserFooterPreference.this.ehM.field_username);
            if (aoO == null || ((int) aoO.ewQ) == 0) {
                aoO = NormalUserFooterPreference.this.ehM;
                C9638aw.m17190ZK();
                if (C18628c.m29078XM().mo15701Y(aoO)) {
                    C9638aw.m17190ZK();
                    aoO = C18628c.m29078XM().aoO(NormalUserFooterPreference.this.ehM.field_username);
                } else {
                    C4990ab.m7412e("MicroMsg.NormalUserFooterPreference", "insert contact failed, username = " + aoO.field_username);
                    aoO = null;
                }
            }
            normalUserFooterPreference.ehM = aoO;
            if (NormalUserFooterPreference.this.ehM != null) {
                C1855t.m3960q(NormalUserFooterPreference.this.ehM);
            }
            AppMethodBeat.m2505o(23722);
        }

        /* Access modifiers changed, original: protected */
        public void cbu() {
            AppMethodBeat.m2504i(23723);
            if (NormalUserFooterPreference.this.poz != null) {
                NormalUserFooterPreference.this.poz.onDetach();
            }
            NormalUserFooterPreference.this.poz = new C21474c();
            NormalUserFooterPreference.this.poz.mo36951Xy();
            AppMethodBeat.m2505o(23723);
        }

        public void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
            int i3 = 0;
            AppMethodBeat.m2504i(23724);
            C4990ab.m7410d("MicroMsg.NormalUserFooterPreference", "onSceneEnd, errType = " + i + ", errCode = " + i2);
            if (c1207m.getType() == 30 || c1207m.getType() == 667 || c1207m.getType() == 853) {
                onStop();
                if (this.ehJ != null) {
                    this.ehJ.dismiss();
                    this.ehJ = null;
                }
                if (C5046bo.m7544cv(NormalUserFooterPreference.this.mContext)) {
                    int i4;
                    if (i == 0 && i2 == 0) {
                        if (c1207m.getType() == 30) {
                            i4 = ((C46498m) c1207m).cAd;
                            C4990ab.m7410d("MicroMsg.NormalUserFooterPreference", "VerifyBaseHandler onSceneEnd, opCode = ".concat(String.valueOf(i4)));
                            if (i4 == 1 || i4 == 3) {
                                List<String> list = ((C46498m) c1207m).vbm;
                                if (list != null && list.contains(NormalUserFooterPreference.this.ehM.field_username)) {
                                    NormalUserFooterPreference.this.poP = true;
                                    m56977NB();
                                    cbu();
                                    for (String bG : list) {
                                        C14957b.m23245bG(bG, NormalUserFooterPreference.this.gwP);
                                    }
                                    C9638aw.getNotification().mo41568IH();
                                }
                            }
                            AppMethodBeat.m2505o(23724);
                            return;
                        } else if (c1207m.getType() == 667 || c1207m.getType() == 853) {
                            NormalUserFooterPreference.this.poP = true;
                            m56977NB();
                            cbu();
                            C14957b.m23245bG(NormalUserFooterPreference.this.ehM.field_username, NormalUserFooterPreference.this.gwP);
                            C9638aw.getNotification().mo41568IH();
                            AppMethodBeat.m2505o(23724);
                            return;
                        }
                    }
                    if (i == 4 && i2 == -302) {
                        if (c1207m.getType() == 30) {
                            i4 = ((C46498m) c1207m).cAd;
                        } else {
                            i4 = 0;
                        }
                        C4990ab.m7421w("MicroMsg.NormalUserFooterPreference", "VerifyBaseHandler onSceneEnd, verify relation out of date, opCode = %d", Integer.valueOf(i4));
                        if (i4 == 3 || c1207m.getType() == 853) {
                            C30379h.m48466d(NormalUserFooterPreference.this.crP, NormalUserFooterPreference.this.crP.getString(C25738R.string.b23), NormalUserFooterPreference.this.crP.getString(C25738R.string.f9238tz), NormalUserFooterPreference.this.crP.getString(C25738R.string.f8814fs), NormalUserFooterPreference.this.crP.getString(C25738R.string.f9076or), new C36273(), null);
                        }
                        AppMethodBeat.m2505o(23724);
                        return;
                    } else if (i == 4 && i2 == -24 && !C5046bo.isNullOrNil(str)) {
                        Toast.makeText(NormalUserFooterPreference.this.crP, str, 1).show();
                        AppMethodBeat.m2505o(23724);
                        return;
                    } else {
                        switch (i) {
                            case 1:
                                if (!C9638aw.m17182Rg().acT()) {
                                    if (C32856ab.m53750ch(NormalUserFooterPreference.this.mContext)) {
                                        C35891h.m58839fR(NormalUserFooterPreference.this.mContext);
                                        i3 = 1;
                                        break;
                                    }
                                }
                                C9638aw.m17182Rg().getNetworkServerIp();
                                new StringBuilder().append(i2);
                                i3 = 1;
                                break;
                                break;
                            case 2:
                                Toast.makeText(NormalUserFooterPreference.this.mContext, NormalUserFooterPreference.this.mContext.getString(C25738R.string.bx9, new Object[]{Integer.valueOf(2), Integer.valueOf(i2)}), AuthApiStatusCodes.AUTH_API_INVALID_CREDENTIALS).show();
                                i3 = 1;
                                break;
                            case 4:
                                if (i2 != -100) {
                                    CharSequence str2;
                                    if (i == 4 && i2 == -34) {
                                        str2 = NormalUserFooterPreference.this.crP.getString(C25738R.string.bwe);
                                    } else if (i == 4 && i2 == -94) {
                                        str2 = NormalUserFooterPreference.this.crP.getString(C25738R.string.bwh);
                                    } else if (i != 4 || C5046bo.isNullOrNil(str2)) {
                                        str2 = NormalUserFooterPreference.this.crP.getString(C25738R.string.e3n);
                                    }
                                    Toast.makeText(NormalUserFooterPreference.this.crP, str2, 1).show();
                                    break;
                                }
                                C30379h.m48439a(NormalUserFooterPreference.this.mContext, C9638aw.m17177QH(), C1338a.m2858an(NormalUserFooterPreference.this.mContext, C25738R.string.f9238tz), new C347121(), new C36262());
                                i3 = 1;
                                break;
                                break;
                        }
                        if (i3 != 0) {
                            AppMethodBeat.m2505o(23724);
                            return;
                        } else {
                            AppMethodBeat.m2505o(23724);
                            return;
                        }
                    }
                }
                AppMethodBeat.m2505o(23724);
                return;
            }
            AppMethodBeat.m2505o(23724);
        }
    }

    /* renamed from: com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference$j */
    class C34714j extends C34713i implements C1202f {

        /* renamed from: com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference$j$1 */
        class C286921 implements OnClickListener {
            C286921() {
            }

            public final void onClick(View view) {
                AppMethodBeat.m2504i(23725);
                NormalUserFooterPreference.this.crP.getIntent().removeExtra("Accept_NewFriend_FromOutside");
                Intent intent = new Intent(NormalUserFooterPreference.this.crP, SayHiWithSnsPermissionUI.class);
                intent.putExtra("Contact_User", NormalUserFooterPreference.this.ehM.field_username);
                intent.putExtra("Contact_Nick", NormalUserFooterPreference.this.ehM.field_nickname);
                intent.putExtra("Contact_RemarkName", NormalUserFooterPreference.this.ehM.field_conRemark);
                if (NormalUserFooterPreference.this.gwP == 14 || NormalUserFooterPreference.this.gwP == 8) {
                    intent.putExtra("Contact_RoomNickname", NormalUserFooterPreference.this.crP.getIntent().getStringExtra("Contact_RoomNickname"));
                }
                intent.putExtra("Contact_Scene", NormalUserFooterPreference.this.gwP);
                intent.putExtra("Verify_ticket", NormalUserFooterPreference.this.mGZ);
                intent.putExtra("sayhi_with_sns_perm_send_verify", false);
                intent.putExtra("sayhi_with_sns_perm_add_remark", true);
                intent.putExtra("sayhi_with_sns_perm_set_label", true);
                NormalUserFooterPreference.this.crP.startActivityForResult(intent, 0);
                AppMethodBeat.m2505o(23725);
            }
        }

        /* renamed from: com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference$j$2 */
        class C347152 implements OnClickListener {

            /* renamed from: com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference$j$2$1 */
            class C347161 implements DialogInterface.OnClickListener {
                C347161() {
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.m2504i(23726);
                    C1855t.m3893i(NormalUserFooterPreference.this.ehM);
                    NormalUserFooterPreference.this.ehM.mo16678ND();
                    C34714j.this.cbn();
                    AppMethodBeat.m2505o(23726);
                }
            }

            C347152() {
            }

            public final void onClick(View view) {
                AppMethodBeat.m2504i(23727);
                if (NormalUserFooterPreference.this.ehM.mo16698Oa()) {
                    C1855t.m3894j(NormalUserFooterPreference.this.ehM);
                    NormalUserFooterPreference.this.ehM.mo16679NE();
                    C34714j.this.cbn();
                    AppMethodBeat.m2505o(23727);
                    return;
                }
                int i;
                Context context = NormalUserFooterPreference.this.mContext;
                Context context2 = NormalUserFooterPreference.this.mContext;
                if (C7616ad.aox(NormalUserFooterPreference.this.ehM.field_username)) {
                    i = C25738R.string.ay3;
                } else {
                    i = C25738R.string.ay2;
                }
                C30379h.m48440a(context, context2.getString(i), NormalUserFooterPreference.this.mContext.getString(C25738R.string.ay1), new C347161(), null);
                AppMethodBeat.m2505o(23727);
            }
        }

        public C34714j() {
            super();
        }

        /* Access modifiers changed, original: protected|final */
        public final void cbp() {
            AppMethodBeat.m2504i(23728);
            if (NormalUserFooterPreference.this.ehM == null || !C7486a.m12942jh(NormalUserFooterPreference.this.ehM.field_type)) {
                mo55325F(false, true);
                AppMethodBeat.m2505o(23728);
                return;
            }
            cbo();
            AppMethodBeat.m2505o(23728);
        }

        /* Access modifiers changed, original: protected|final */
        public final void cbn() {
            AppMethodBeat.m2504i(23729);
            super.cbn();
            NormalUserFooterPreference.this.poA.setVisibility(0);
            NormalUserFooterPreference.this.poK.setVisibility(8);
            NormalUserFooterPreference.this.oik.setVisibility(8);
            NormalUserFooterPreference.this.poN.setVisibility(8);
            NormalUserFooterPreference.this.poL.setVisibility(8);
            NormalUserFooterPreference.this.poM.setVisibility(8);
            NormalUserFooterPreference.this.poH.setVisibility(8);
            NormalUserFooterPreference.this.poO.setVisibility(8);
            NormalUserFooterPreference.this.poF.setVisibility(0);
            NormalUserFooterPreference.this.poE.setVisibility(0);
            if (NormalUserFooterPreference.this.ehM.mo16698Oa()) {
                NormalUserFooterPreference.this.poD.setText(NormalUserFooterPreference.this.crP.getString(C25738R.string.ay6));
                NormalUserFooterPreference.this.poO.setVisibility(0);
            } else {
                NormalUserFooterPreference.this.poD.setText(NormalUserFooterPreference.this.crP.getString(C25738R.string.ay1));
            }
            NormalUserFooterPreference.this.poB.setOnClickListener(new C286921());
            NormalUserFooterPreference.this.poD.setOnClickListener(new C347152());
            AppMethodBeat.m2505o(23729);
        }

        /* Access modifiers changed, original: protected|final */
        public final void onDetach() {
            AppMethodBeat.m2504i(23730);
            super.onDetach();
            AppMethodBeat.m2505o(23730);
        }

        /* Access modifiers changed, original: protected|final */
        public final void cbu() {
            AppMethodBeat.m2504i(23731);
            super.cbu();
            AppMethodBeat.m2505o(23731);
        }

        public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
            AppMethodBeat.m2504i(23732);
            super.onSceneEnd(i, i2, str, c1207m);
            AppMethodBeat.m2505o(23732);
        }
    }

    /* renamed from: com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference$a */
    abstract class C34717a implements C1202f {
        boolean isDeleteCancel = false;
        private C36356d pki = null;

        /* renamed from: com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference$a$1 */
        class C36191 implements OnMenuItemClickListener {

            /* renamed from: com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference$a$1$1 */
            class C36201 implements C5279d {
                C36201() {
                }

                public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                    C18817a c18817a = null;
                    AppMethodBeat.m2504i(23674);
                    NormalUserFooterPreference normalUserFooterPreference;
                    Intent intent;
                    C34717a c34717a;
                    View inflate;
                    TextView textView;
                    final CheckBox checkBox;
                    switch (menuItem.getItemId()) {
                        case 1:
                            NormalUserFooterPreference.this.fry.mo10126cF("hide_btn");
                            NormalUserFooterPreference.this.fry.doNotify();
                            C34717a c34717a2 = C34717a.this;
                            normalUserFooterPreference = NormalUserFooterPreference.this;
                            C9638aw.m17190ZK();
                            normalUserFooterPreference.ehM = C18628c.m29078XM().aoO(NormalUserFooterPreference.this.ehM.field_username);
                            if (C7486a.m12942jh(NormalUserFooterPreference.this.ehM.field_type)) {
                                intent = new Intent();
                                intent.putExtra("Contact_Scene", NormalUserFooterPreference.this.gwP);
                                intent.putExtra("Contact_User", NormalUserFooterPreference.this.ehM.field_username);
                                intent.putExtra("Contact_RoomNickname", NormalUserFooterPreference.this.crP.getIntent().getStringExtra("Contact_RoomNickname"));
                                intent.putExtra("contact_phone_number_list", NormalUserFooterPreference.this.ehM.dur);
                                String str = "";
                                if (!NormalUserFooterPreference.this.ehM.mo16703Of()) {
                                    String stringExtra = NormalUserFooterPreference.this.crP.getIntent().getStringExtra("Contact_Mobile_MD5");
                                    String stringExtra2 = NormalUserFooterPreference.this.crP.getIntent().getStringExtra("Contact_full_Mobile_MD5");
                                    if (C5046bo.isNullOrNil(stringExtra) && C5046bo.isNullOrNil(stringExtra2)) {
                                        if (!C5046bo.isNullOrNil(NormalUserFooterPreference.this.ehM.field_username)) {
                                            c18817a = C32923a.getAddrUploadStg().mo34089vT(NormalUserFooterPreference.this.ehM.field_username);
                                        }
                                    } else if (!(C5046bo.isNullOrNil(stringExtra) && C5046bo.isNullOrNil(stringExtra2))) {
                                        c18817a = C32923a.getAddrUploadStg().mo34092vW(stringExtra);
                                        if (c18817a == null || C5046bo.isNullOrNil(c18817a.mo34067Aq())) {
                                            c18817a = C32923a.getAddrUploadStg().mo34092vW(stringExtra2);
                                        }
                                    }
                                    if (!(c18817a == null || C5046bo.isNullOrNil(c18817a.mo34067Aq()))) {
                                        str = C5046bo.nullAsNil(c18817a.apG()).replace(" ", "");
                                    }
                                }
                                intent.putExtra("contact_phone_number_by_md5", str);
                                C39503b.gkE.mo38928m(intent, NormalUserFooterPreference.this.mContext);
                                AppMethodBeat.m2505o(23674);
                                return;
                            }
                            c34717a2.mo55326UU(NormalUserFooterPreference.this.ehM.field_username);
                            AppMethodBeat.m2505o(23674);
                            return;
                        case 2:
                            if (NormalUserFooterPreference.this.ehM.mo16700Oc()) {
                                C1855t.m3914n(NormalUserFooterPreference.this.ehM);
                                C30379h.m48465bQ(NormalUserFooterPreference.this.crP, NormalUserFooterPreference.this.crP.getString(C25738R.string.b20));
                            } else {
                                C1855t.m3899m(NormalUserFooterPreference.this.ehM);
                                C30379h.m48465bQ(NormalUserFooterPreference.this.crP, NormalUserFooterPreference.this.crP.getString(C25738R.string.aw6));
                            }
                            normalUserFooterPreference = NormalUserFooterPreference.this;
                            C9638aw.m17190ZK();
                            normalUserFooterPreference.ehM = C18628c.m29078XM().aoO(NormalUserFooterPreference.this.ehM.field_username);
                            AppMethodBeat.m2505o(23674);
                            return;
                        case 3:
                            Intent intent2 = new Intent();
                            intent2.putExtra("sns_permission_userName", NormalUserFooterPreference.this.ehM.field_username);
                            intent2.putExtra("sns_permission_anim", true);
                            intent2.putExtra("sns_permission_block_scene", 1);
                            C25985d.m41467b(NormalUserFooterPreference.this.crP, "sns", ".ui.SnsPermissionUI", intent2);
                            AppMethodBeat.m2505o(23674);
                            return;
                        case 4:
                            c34717a = C34717a.this;
                            intent = new Intent();
                            intent.putExtra("Select_Talker_Name", NormalUserFooterPreference.this.ehM.field_username);
                            intent.putExtra("Select_block_List", NormalUserFooterPreference.this.ehM.field_username);
                            intent.putExtra("Select_Conv_Type", 3);
                            intent.putExtra("Select_Send_Card", true);
                            intent.putExtra("mutil_select_is_ret", true);
                            C39503b.gkE.mo38899a(intent, NormalUserFooterPreference.this.crP);
                            AppMethodBeat.m2505o(23674);
                            return;
                        case 5:
                            if (NormalUserFooterPreference.this.ehM.mo16698Oa()) {
                                C34717a.m57017a(C34717a.this);
                                AppMethodBeat.m2505o(23674);
                                return;
                            }
                            inflate = View.inflate(NormalUserFooterPreference.this.mContext, 2130970090, null);
                            inflate.setPadding(0, 0, 0, 0);
                            textView = (TextView) inflate.findViewById(2131825969);
                            textView.setPadding(0, 0, 0, 0);
                            textView.setText(C7616ad.aox(NormalUserFooterPreference.this.ehM.field_username) ? C25738R.string.ay3 : C25738R.string.ay2);
                            checkBox = (CheckBox) inflate.findViewById(2131825970);
                            checkBox.setChecked(false);
                            textView = (TextView) inflate.findViewById(2131825971);
                            textView.setText(C25738R.string.ay4);
                            if (NormalUserFooterPreference.this.ehM.getSource() == 18) {
                                checkBox.setVisibility(0);
                                textView.setVisibility(0);
                            } else {
                                checkBox.setVisibility(8);
                                textView.setVisibility(8);
                            }
                            C30379h.m48451a(NormalUserFooterPreference.this.mContext, true, NormalUserFooterPreference.this.mContext.getString(C25738R.string.ay1), inflate, NormalUserFooterPreference.this.mContext.getString(C25738R.string.f9187s6), NormalUserFooterPreference.this.mContext.getString(C25738R.string.f9076or), new DialogInterface.OnClickListener() {
                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    AppMethodBeat.m2504i(23672);
                                    C34717a.m57018b(C34717a.this);
                                    if (NormalUserFooterPreference.this.ehM.getSource() == 18) {
                                        NormalUserFooterPreference.this.gwP = 9;
                                        if (checkBox.isChecked()) {
                                            C34717a.m57019c(C34717a.this);
                                        }
                                    }
                                    AppMethodBeat.m2505o(23672);
                                }
                            }, null);
                            AppMethodBeat.m2505o(23674);
                            return;
                        case 6:
                            inflate = View.inflate(NormalUserFooterPreference.this.mContext, 2130970090, null);
                            inflate.setPadding(0, 0, 0, 0);
                            textView = (TextView) inflate.findViewById(2131825969);
                            textView.setPadding(0, 0, 0, 0);
                            textView.setText(C1855t.m3910mW(NormalUserFooterPreference.this.ehM.field_username) ? NormalUserFooterPreference.this.mContext.getString(C25738R.string.b4w, new Object[]{NormalUserFooterPreference.this.ehM.mo16707Oj()}) : NormalUserFooterPreference.this.mContext.getString(C25738R.string.b4u, new Object[]{NormalUserFooterPreference.this.ehM.mo16707Oj()}));
                            checkBox = (CheckBox) inflate.findViewById(2131825970);
                            checkBox.setChecked(false);
                            textView = (TextView) inflate.findViewById(2131825971);
                            textView.setText(C25738R.string.ay4);
                            if (NormalUserFooterPreference.this.ehM.getSource() == 18) {
                                checkBox.setVisibility(0);
                                textView.setVisibility(0);
                            } else {
                                checkBox.setVisibility(8);
                                textView.setVisibility(8);
                            }
                            C30379h.m48452a(NormalUserFooterPreference.this.mContext, true, NormalUserFooterPreference.this.mContext.getString(C25738R.string.avj), inflate, NormalUserFooterPreference.this.mContext.getString(C25738R.string.f9088p4), NormalUserFooterPreference.this.mContext.getString(C25738R.string.f9076or), new DialogInterface.OnClickListener() {
                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    AppMethodBeat.m2504i(23673);
                                    C34717a.this.cbr();
                                    if (NormalUserFooterPreference.this.ehM.getSource() == 18) {
                                        NormalUserFooterPreference.this.gwP = 9;
                                        if (checkBox.isChecked()) {
                                            C34717a.m57019c(C34717a.this);
                                        }
                                    }
                                    AppMethodBeat.m2505o(23673);
                                }
                            }, null, (int) C25738R.color.f11717ei);
                            AppMethodBeat.m2505o(23674);
                            return;
                        case 7:
                            c34717a = C34717a.this;
                            C4990ab.m7410d("MicroMsg.NormalUserFooterPreference", "dealAddShortcut, username = " + NormalUserFooterPreference.this.ehM.field_username);
                            C42781b.m75863aa(NormalUserFooterPreference.this.crP, NormalUserFooterPreference.this.ehM.field_username);
                            C5004al.m7442n(new C3470210(), 1000);
                            AppMethodBeat.m2505o(23674);
                            return;
                        case 9:
                            C34717a.m57019c(C34717a.this);
                            break;
                    }
                    AppMethodBeat.m2505o(23674);
                }
            }

            /* renamed from: com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference$a$1$2 */
            class C36232 implements C36073c {
                C36232() {
                }

                /* renamed from: a */
                public final void mo5746a(C44273l c44273l) {
                    CharSequence string;
                    AppMethodBeat.m2504i(23675);
                    C7060h.pYm.mo8381e(16055, Integer.valueOf(C34696c.m56965am(NormalUserFooterPreference.this.crP.getIntent())), Integer.valueOf(7));
                    if (C7616ad.aox(NormalUserFooterPreference.this.ehM.field_username)) {
                        c44273l.mo70063ax(1, C25738R.string.b2o, C1318a.bottomsheet_icon_remarks);
                    } else {
                        c44273l.mo70063ax(1, C25738R.string.axw, C1318a.bottomsheet_icon_remarks);
                    }
                    if (NormalUserFooterPreference.this.ehM.mo16700Oc()) {
                        string = NormalUserFooterPreference.this.crP.getResources().getString(C25738R.string.b1z);
                    } else {
                        string = NormalUserFooterPreference.this.crP.getResources().getString(C25738R.string.aw5);
                    }
                    c44273l.mo70049a(2, string, (int) C1318a.bottomsheet_icon_star);
                    if (!C7616ad.aox(NormalUserFooterPreference.this.ehM.field_username)) {
                        c44273l.mo70063ax(3, C25738R.string.aya, C1318a.bottomsheet_icon_moment);
                    }
                    c44273l.mo70063ax(4, C25738R.string.azx, C1318a.bottomsheet_icon_transmit);
                    c44273l.mo70063ax(9, C25738R.string.a9n, C1318a.bottomsheet_icon_complain);
                    if (NormalUserFooterPreference.this.ehM.mo16698Oa()) {
                        string = NormalUserFooterPreference.this.crP.getString(C25738R.string.ay6);
                    } else {
                        string = NormalUserFooterPreference.this.crP.getString(C25738R.string.ay1);
                    }
                    c44273l.mo70049a(5, string, (int) C1318a.bottomsheet_icon_blacklist);
                    if (!NormalUserFooterPreference.this.poy) {
                        c44273l.mo70063ax(6, C25738R.string.a6f, C1318a.bottomsheet_icon_del);
                    }
                    c44273l.mo70063ax(7, C25738R.string.atv, C1318a.bottomsheet_icon_desktop);
                    AppMethodBeat.m2505o(23675);
                }
            }

            C36191() {
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.m2504i(23676);
                C36356d c36356d = new C36356d(NormalUserFooterPreference.this.crP, 1, false);
                c36356d.rBm = new C36201();
                c36356d.rBl = new C36232();
                c36356d.cpD();
                AppMethodBeat.m2505o(23676);
                return true;
            }
        }

        /* renamed from: com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference$a$13 */
        class C1283213 implements OnClickListener {
            C1283213() {
            }

            public final void onClick(View view) {
                AppMethodBeat.m2504i(23690);
                Intent intent = new Intent();
                intent.putExtra("sns_permission_userName", NormalUserFooterPreference.this.ehM.field_username);
                intent.putExtra("sns_permission_anim", true);
                intent.putExtra("sns_permission_block_scene", 4);
                C25985d.m41467b(NormalUserFooterPreference.this.crP, "sns", ".ui.SnsPermissionUI", intent);
                AppMethodBeat.m2505o(23690);
            }
        }

        /* renamed from: com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference$a$15 */
        class C1283315 implements OnClickListener {
            C1283315() {
            }

            public final void onClick(View view) {
                AppMethodBeat.m2504i(23692);
                C34717a.m57019c(C34717a.this);
                AppMethodBeat.m2505o(23692);
            }
        }

        /* renamed from: com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference$a$16 */
        class C1283416 implements OnClickListener {
            C1283416() {
            }

            public final void onClick(View view) {
                AppMethodBeat.m2504i(23693);
                C34717a.m57019c(C34717a.this);
                AppMethodBeat.m2505o(23693);
            }
        }

        /* renamed from: com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference$a$9 */
        class C128359 implements C1827a {
            C128359() {
            }

            /* renamed from: JU */
            public final boolean mo5405JU() {
                return C34717a.this.isDeleteCancel;
            }

            /* renamed from: JV */
            public final void mo5406JV() {
                AppMethodBeat.m2504i(23683);
                if (NormalUserFooterPreference.this.ehJ != null) {
                    NormalUserFooterPreference.this.ehJ.dismiss();
                }
                AppMethodBeat.m2505o(23683);
            }
        }

        /* renamed from: com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference$a$7 */
        class C214737 implements DialogInterface.OnClickListener {
            C214737() {
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.m2504i(23681);
                C7060h.pYm.mo8381e(14553, Integer.valueOf(2), Integer.valueOf(4), NormalUserFooterPreference.this.ehM.field_username);
                C34717a.this.isDeleteCancel = true;
                Intent intent = new Intent();
                intent.putExtra("Chat_User", NormalUserFooterPreference.this.ehM.field_username);
                intent.addFlags(67108864);
                C25985d.m41473f(NormalUserFooterPreference.this.mContext, ".ui.chatting.ChattingUI", intent);
                AppMethodBeat.m2505o(23681);
            }
        }

        /* renamed from: com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference$a$14 */
        class C2868814 implements OnClickListener {
            C2868814() {
            }

            public final void onClick(View view) {
                AppMethodBeat.m2504i(23691);
                C34717a c34717a = C34717a.this;
                C18411uh c18411uh = new C18411uh();
                C4879a.xxA.mo10055m(c18411uh);
                if (!NormalUserFooterPreference.this.ehM.field_username.equals(c18411uh.cQt.talker) && (c18411uh.cQt.cQv || c18411uh.cQt.cQw)) {
                    Toast.makeText(NormalUserFooterPreference.this.crP.mController.ylL, c18411uh.cQt.cQu ? C25738R.string.ac6 : C25738R.string.ac7, 0).show();
                    C4990ab.m7416i("MicroMsg.NormalUserFooterPreference", "voip is running, can't do this");
                } else if (!C35973a.m59177bH(NormalUserFooterPreference.this.crP)) {
                    C42062sz c42062sz = new C42062sz();
                    c42062sz.cPf.cPh = true;
                    C4879a.xxA.mo10055m(c42062sz);
                    String str = c42062sz.cPg.cPj;
                    if (C5046bo.isNullOrNil(str)) {
                        c34717a.cbq();
                    } else {
                        C4990ab.m7418v("MicroMsg.NormalUserFooterPreference", "Talkroom is on: ".concat(String.valueOf(str)));
                        C30379h.m48466d(NormalUserFooterPreference.this.crP, NormalUserFooterPreference.this.crP.getString(C25738R.string.euf), "", NormalUserFooterPreference.this.crP.getString(C25738R.string.f9187s6), NormalUserFooterPreference.this.crP.getString(C25738R.string.f9076or), new C347062(), new C347073());
                    }
                }
                C7060h.pYm.mo8381e(16055, Integer.valueOf(C34696c.m56965am(NormalUserFooterPreference.this.crP.getIntent())), Integer.valueOf(5));
                AppMethodBeat.m2505o(23691);
            }
        }

        /* renamed from: com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference$a$6 */
        class C286896 implements OnCancelListener {
            C286896() {
            }

            public final void onCancel(DialogInterface dialogInterface) {
                C34717a.this.isDeleteCancel = true;
            }
        }

        /* renamed from: com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference$a$10 */
        class C3470210 implements Runnable {
            C3470210() {
            }

            public final void run() {
                AppMethodBeat.m2504i(23684);
                if (NormalUserFooterPreference.this.crP.isFinishing()) {
                    AppMethodBeat.m2505o(23684);
                    return;
                }
                C42781b.m75859Z(NormalUserFooterPreference.this.crP, NormalUserFooterPreference.this.ehM.field_username);
                C42781b.m75871x(NormalUserFooterPreference.this.crP);
                AppMethodBeat.m2505o(23684);
            }
        }

        /* renamed from: com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference$a$12 */
        class C3470512 implements OnClickListener {
            C3470512() {
            }

            public final void onClick(View view) {
                AppMethodBeat.m2504i(23689);
                C4990ab.m7417i("MicroMsg.NormalUserFooterPreference", "sendButton onClick %s", NormalUserFooterPreference.this.ehM.field_username);
                C34717a c34717a;
                if (NormalUserFooterPreference.this.pow) {
                    c34717a = C34717a.this;
                    String str = NormalUserFooterPreference.this.ehM.field_username;
                    Intent intent = new Intent();
                    intent.addFlags(67108864);
                    if (NormalUserFooterPreference.this.pli) {
                        intent.putExtra("Chat_User", str);
                        intent.putExtra("Chat_Mode", 1);
                        ((Activity) NormalUserFooterPreference.this.mContext).setResult(-1, intent);
                    } else {
                        intent.putExtra("Chat_User", str);
                        intent.putExtra("Chat_Mode", 1);
                        C39503b.gkE.mo38915d(intent, NormalUserFooterPreference.this.mContext);
                    }
                } else {
                    c34717a = C34717a.this;
                    Intent intent2 = new Intent();
                    intent2.addFlags(67108864);
                    if (NormalUserFooterPreference.this.pli) {
                        intent2.putExtra("Chat_User", NormalUserFooterPreference.this.ehM.field_username);
                        intent2.putExtra("Chat_Mode", 1);
                        ((Activity) NormalUserFooterPreference.this.mContext).setResult(-1, intent2);
                    } else {
                        intent2.putExtra("Chat_User", NormalUserFooterPreference.this.ehM.field_username);
                        intent2.putExtra("Chat_Mode", 1);
                        C39503b.gkE.mo38915d(intent2, NormalUserFooterPreference.this.mContext);
                    }
                }
                C7060h.pYm.mo8381e(16055, Integer.valueOf(C34696c.m56965am(NormalUserFooterPreference.this.crP.getIntent())), Integer.valueOf(4));
                AppMethodBeat.m2505o(23689);
            }
        }

        /* renamed from: com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference$a$2 */
        class C347062 implements DialogInterface.OnClickListener {
            C347062() {
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.m2504i(23677);
                C42062sz c42062sz = new C42062sz();
                c42062sz.cPf.cPi = true;
                C4879a.xxA.mo10055m(c42062sz);
                C34717a.this.cbq();
                dialogInterface.dismiss();
                AppMethodBeat.m2505o(23677);
            }
        }

        /* renamed from: com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference$a$3 */
        class C347073 implements DialogInterface.OnClickListener {
            C347073() {
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.m2504i(23678);
                dialogInterface.dismiss();
                AppMethodBeat.m2505o(23678);
            }
        }

        /* renamed from: com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference$a$4 */
        class C347184 implements C36073c {
            C347184() {
            }

            /* renamed from: a */
            public final void mo5746a(C44273l c44273l) {
                AppMethodBeat.m2504i(23679);
                c44273l.mo70063ax(2, C25738R.string.f9132qh, C1318a.sharemore_videovoip);
                c44273l.mo70063ax(1, C25738R.string.f9134qj, C1318a.sharemore_voipvoice);
                AppMethodBeat.m2505o(23679);
            }
        }

        /* renamed from: com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference$a$17 */
        class C3471917 implements OnClickListener {
            C3471917() {
            }

            public final void onClick(View view) {
                AppMethodBeat.m2504i(23694);
                C34717a.m57019c(C34717a.this);
                AppMethodBeat.m2505o(23694);
            }
        }

        /* renamed from: com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference$a$5 */
        class C347205 implements C5279d {
            C347205() {
            }

            public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                AppMethodBeat.m2504i(23680);
                switch (menuItem.getItemId()) {
                    case 1:
                        NormalUserFooterPreference.this.cbl();
                        AppMethodBeat.m2505o(23680);
                        return;
                    case 2:
                        NormalUserFooterPreference.this.cbm();
                        break;
                }
                AppMethodBeat.m2505o(23680);
            }
        }

        public abstract void cbn();

        /* Access modifiers changed, original: protected */
        /* renamed from: Xy */
        public void mo36951Xy() {
            cbn();
            cbp();
            NormalUserFooterPreference.this.oik.setOnClickListener(new C3470512());
            NormalUserFooterPreference.this.poN.setOnClickListener(new C1283213());
            NormalUserFooterPreference.this.poL.setOnClickListener(new C2868814());
            NormalUserFooterPreference.this.poF.setOnClickListener(new C1283315());
            NormalUserFooterPreference.this.poI.setOnClickListener(new C1283416());
            NormalUserFooterPreference.this.poM.setOnClickListener(new C3471917());
        }

        /* Access modifiers changed, original: protected */
        public void onDetach() {
        }

        public void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
            C4990ab.m7416i("MicroMsg.NormalUserFooterPreference", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str + " " + c1207m.getType());
        }

        /* Access modifiers changed, original: protected|final */
        public final void cbo() {
            NormalUserFooterPreference.this.crP.addIconOptionMenu(0, C25738R.drawable.f6899uu, new C36191());
        }

        /* Access modifiers changed, original: protected|final */
        /* renamed from: F */
        public final void mo55325F(final boolean z, final boolean z2) {
            if (!z || !z2) {
                NormalUserFooterPreference.this.crP.addIconOptionMenu(0, C25738R.drawable.f6899uu, new OnMenuItemClickListener() {

                    /* renamed from: com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference$a$11$2 */
                    class C214722 implements C36073c {
                        C214722() {
                        }

                        /* renamed from: a */
                        public final void mo5746a(C44273l c44273l) {
                            AppMethodBeat.m2504i(23687);
                            if (!z) {
                                if (C7616ad.aox(NormalUserFooterPreference.this.ehM.field_username)) {
                                    c44273l.mo70063ax(1, C25738R.string.b2o, C1318a.bottomsheet_icon_remarks);
                                } else {
                                    c44273l.mo70063ax(1, C25738R.string.axw, C1318a.bottomsheet_icon_remarks);
                                }
                            }
                            if (!z2) {
                                if (NormalUserFooterPreference.this.ehM.mo16698Oa()) {
                                    c44273l.mo70063ax(8, C25738R.string.ay6, C1318a.bottomsheet_icon_blacklist);
                                    AppMethodBeat.m2505o(23687);
                                    return;
                                } else if (!C1855t.m3911mX(NormalUserFooterPreference.this.ehM.field_username)) {
                                    c44273l.mo70063ax(5, C25738R.string.ay1, C1318a.bottomsheet_icon_blacklist);
                                }
                            }
                            AppMethodBeat.m2505o(23687);
                        }
                    }

                    /* renamed from: com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference$a$11$1 */
                    class C347041 implements C5279d {

                        /* renamed from: com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference$a$11$1$1 */
                        class C286871 implements DialogInterface.OnClickListener {
                            C286871() {
                            }

                            public final void onClick(DialogInterface dialogInterface, int i) {
                                AppMethodBeat.m2504i(23685);
                                C34717a.m57018b(C34717a.this);
                                AppMethodBeat.m2505o(23685);
                            }
                        }

                        C347041() {
                        }

                        public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                            AppMethodBeat.m2504i(23686);
                            switch (menuItem.getItemId()) {
                                case 1:
                                    C34717a.this.mo55326UU(NormalUserFooterPreference.this.ehM.field_username);
                                    AppMethodBeat.m2505o(23686);
                                    return;
                                case 5:
                                    int i2;
                                    Context context = NormalUserFooterPreference.this.mContext;
                                    Context context2 = NormalUserFooterPreference.this.mContext;
                                    if (C7616ad.aox(NormalUserFooterPreference.this.ehM.field_username)) {
                                        i2 = C25738R.string.ay3;
                                    } else {
                                        i2 = C25738R.string.ay2;
                                    }
                                    C30379h.m48440a(context, context2.getString(i2), NormalUserFooterPreference.this.mContext.getString(C25738R.string.ay1), new C286871(), null);
                                    break;
                                case 8:
                                    C34717a.m57017a(C34717a.this);
                                    AppMethodBeat.m2505o(23686);
                                    return;
                            }
                            AppMethodBeat.m2505o(23686);
                        }
                    }

                    public final boolean onMenuItemClick(MenuItem menuItem) {
                        AppMethodBeat.m2504i(23688);
                        C36356d c36356d = new C36356d(NormalUserFooterPreference.this.crP, 1, false);
                        c36356d.rBm = new C347041();
                        c36356d.rBl = new C214722();
                        c36356d.cpD();
                        AppMethodBeat.m2505o(23688);
                        return true;
                    }
                });
            }
        }

        /* Access modifiers changed, original: protected */
        public void cbp() {
            if (NormalUserFooterPreference.this.pni) {
                NormalUserFooterPreference.this.crP.showOptionMenu(false);
            } else if (!C1853r.m3846Yz().equals(NormalUserFooterPreference.this.ehM.field_username)) {
                if (!C7486a.m12942jh(NormalUserFooterPreference.this.ehM.field_type)) {
                    mo55325F(false, false);
                } else if (!C1855t.m3916nB(NormalUserFooterPreference.this.ehM.field_username)) {
                    cbo();
                }
            }
        }

        /* Access modifiers changed, original: final */
        public final void cbq() {
            this.pki = new C36356d(NormalUserFooterPreference.this.crP, 1, false);
            this.pki.rBl = new C347184();
            this.pki.rBm = new C347205();
            this.pki.cpD();
        }

        /* Access modifiers changed, original: final */
        /* renamed from: UU */
        public final void mo55326UU(String str) {
            if (C5046bo.isNullOrNil(str)) {
                C4990ab.m7420w("MicroMsg.NormalUserFooterPreference", "mod stranger remark, username is null");
                return;
            }
            Intent intent = new Intent();
            intent.putExtra("Contact_Scene", NormalUserFooterPreference.this.gwP);
            intent.putExtra("Contact_mode_name_type", 0);
            intent.putExtra("Contact_ModStrangerRemark", true);
            intent.putExtra("Contact_User", NormalUserFooterPreference.this.ehM.field_username);
            intent.putExtra("Contact_Nick", NormalUserFooterPreference.this.ehM.field_nickname);
            intent.putExtra("Contact_RemarkName", NormalUserFooterPreference.this.ehM.field_conRemark);
            C39503b.gkE.mo38929n(intent, NormalUserFooterPreference.this.mContext);
        }

        /* Access modifiers changed, original: protected|final */
        public final void cbr() {
            C7060h.pYm.mo8381e(14553, Integer.valueOf(2), Integer.valueOf(2), NormalUserFooterPreference.this.ehM.field_username);
            final String str = NormalUserFooterPreference.this.ehM.field_username;
            if (C1855t.m3910mW(str)) {
                NormalUserFooterPreference.this.ehM.mo16677NC();
                C9638aw.m17190ZK();
                C18628c.m29077XL().mo7920c(new C37498c(str));
                C9638aw.m17190ZK();
                C18628c.m29078XM().aoU(str);
                C9638aw.m17190ZK();
                C18628c.m29087XV().mo14891og(str);
                return;
            }
            String str2;
            this.isDeleteCancel = false;
            Context context = NormalUserFooterPreference.this.mContext;
            NormalUserFooterPreference.this.mContext.getString(C25738R.string.f9238tz);
            final C44275p b = C30379h.m48458b(context, NormalUserFooterPreference.this.mContext.getString(C25738R.string.f9260un), true, new C286896());
            if (this.isDeleteCancel) {
                str2 = null;
            } else {
                str2 = C40492e.akq(NormalUserFooterPreference.this.ehM.field_username);
            }
            if (C5046bo.isNullOrNil(str2)) {
                mo55330zq(str);
                return;
            }
            b.dismiss();
            C30379h.m48454a(NormalUserFooterPreference.this.mContext, false, NormalUserFooterPreference.this.mContext.getString(C25738R.string.fe9, new Object[]{str2}), null, NormalUserFooterPreference.this.mContext.getString(C25738R.string.c9y), NormalUserFooterPreference.this.mContext.getString(C25738R.string.b57), new C214737(), new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.m2504i(23682);
                    C7060h.pYm.mo8381e(14553, Integer.valueOf(2), Integer.valueOf(3), NormalUserFooterPreference.this.ehM.field_username);
                    b.show();
                    C34717a.this.isDeleteCancel = false;
                    C34717a.this.mo55330zq(str);
                    AppMethodBeat.m2505o(23682);
                }
            }, -1, C25738R.color.f11717ei);
        }

        /* Access modifiers changed, original: final */
        /* renamed from: zq */
        public final void mo55330zq(String str) {
            NormalUserFooterPreference.this.ehM.mo16677NC();
            if (C7616ad.aox(str)) {
                ((C37974a) C1720g.m3528K(C37974a.class)).mo60749ve(str);
                C26417a.flu.mo20970os(str);
            } else {
                C9638aw.m17190ZK();
                C18628c.m29077XL().mo7920c(new C37498c(str));
            }
            C1829bf.m3741a(str, new C128359());
            C9638aw.m17190ZK();
            C18628c.m29078XM().mo15724b(str, NormalUserFooterPreference.this.ehM);
            C9638aw.m17190ZK();
            C18628c.m29083XR().aoX(str);
            C37512c.m63302e(0, str);
            C37512c.m63302e(0, NormalUserFooterPreference.this.ehM.field_encryptUsername);
            switch (NormalUserFooterPreference.this.gwP) {
                case 10:
                    C26529w.m42351J(NormalUserFooterPreference.this.mContext, str);
                    break;
                case 12:
                    C9878ao wj = C32923a.getQQListStg().mo73286wj(str);
                    if (wj != null) {
                        wj.gwD = 1;
                        C32923a.getQQListStg().mo73281a(wj.gwC, wj);
                        break;
                    }
                    break;
                case 13:
                    C18817a vT = C32923a.getAddrUploadStg().mo34089vT(str);
                    if (!(vT == null || C5046bo.isNullOrNil(vT.guM))) {
                        vT.status = 1;
                        C32923a.getAddrUploadStg().mo34084a(vT.mo34067Aq(), vT);
                    }
                    C26529w.m42351J(NormalUserFooterPreference.this.mContext, str);
                    break;
                case 31:
                    C45497g wb = C32923a.getFacebookFrdStg().mo34099wb(str);
                    if (wb != null) {
                        wb.status = 100;
                        C32923a.getFacebookFrdStg().mo34096a(wb);
                        break;
                    }
                    break;
                case C42464aa.CTRL_INDEX /*58*/:
                case C2206au.CTRL_INDEX /*59*/:
                case 60:
                    C32923a.getGoogleFriendStorage().mo60780ak(str, 2);
                    break;
            }
            if (NormalUserFooterPreference.this.gwP == 9) {
                C4990ab.m7416i("MicroMsg.NormalUserFooterPreference", "add scene unkown, check the contact getsource: " + NormalUserFooterPreference.this.ehM.getSource());
                switch (NormalUserFooterPreference.this.ehM.getSource()) {
                    case 10:
                    case 13:
                        C4990ab.m7416i("MicroMsg.NormalUserFooterPreference", "delete the system contact info added by wechat");
                        C26529w.m42351J(NormalUserFooterPreference.this.mContext, str);
                        break;
                }
            }
            if (NormalUserFooterPreference.this.pmV == 0) {
                Intent intent = new Intent();
                intent.addFlags(67108864);
                C39503b.gkE.mo38931p(intent, NormalUserFooterPreference.this.mContext);
                return;
            }
            NormalUserFooterPreference.this.crP.setResult(-1, NormalUserFooterPreference.this.crP.getIntent().putExtra("_delete_ok_", true));
            ((Activity) NormalUserFooterPreference.this.mContext).finish();
        }

        /* renamed from: a */
        static /* synthetic */ void m57017a(C34717a c34717a) {
            C1855t.m3894j(NormalUserFooterPreference.this.ehM);
            NormalUserFooterPreference.this.ehM.mo16679NE();
            if (NormalUserFooterPreference.this.lyb) {
                NormalUserFooterPreference.this.poO.setVisibility(8);
                c34717a.cbn();
            }
        }

        /* renamed from: b */
        static /* synthetic */ void m57018b(C34717a c34717a) {
            C1855t.m3893i(NormalUserFooterPreference.this.ehM);
            NormalUserFooterPreference.this.ehM.mo16678ND();
            if (NormalUserFooterPreference.this.lyb) {
                NormalUserFooterPreference.this.poO.setVisibility(0);
                c34717a.cbn();
            }
        }

        /* renamed from: c */
        static /* synthetic */ void m57019c(C34717a c34717a) {
            int i = 7;
            Intent intent = new Intent();
            switch (NormalUserFooterPreference.this.gwP) {
                case 1:
                case 2:
                case 3:
                case 12:
                case 13:
                case C42464aa.CTRL_INDEX /*58*/:
                case C2206au.CTRL_INDEX /*59*/:
                case 60:
                    intent.putExtra("k_outside_expose_proof_item_list", C25860a.m41170z(45, NormalUserFooterPreference.this.ehM.field_username));
                    i = 45;
                    break;
                case 9:
                case 14:
                    i = 35;
                    break;
                case 18:
                    if (NormalUserFooterPreference.this.pkC) {
                        i = 2;
                    } else {
                        i = 1;
                    }
                    intent.putStringArrayListExtra("k_outside_expose_proof_item_list", C25860a.m41167tS(NormalUserFooterPreference.this.ehM.field_username));
                    break;
                case 22:
                case 23:
                case 24:
                case 26:
                case 27:
                case C31128d.MIC_BASE_CHANNELSHARPEN /*28*/:
                case 29:
                    i = NormalUserFooterPreference.this.pkC ? 4 : 3;
                    intent.putStringArrayListExtra("k_outside_expose_proof_item_list", C25860a.m41168tT(NormalUserFooterPreference.this.ehM.field_username));
                    break;
                case 25:
                    i = NormalUserFooterPreference.this.pkC ? 6 : 5;
                    if (!NormalUserFooterPreference.this.pkC) {
                        String str;
                        String str2 = "k_outside_expose_proof_item_list";
                        if (C5046bo.isNullOrNil(NormalUserFooterPreference.this.ehM.xXc)) {
                            str = NormalUserFooterPreference.this.ehM.field_username;
                        } else {
                            str = NormalUserFooterPreference.this.ehM.xXc;
                        }
                        intent.putExtra(str2, C25860a.m41169tU(str));
                        break;
                    }
                    intent.putExtra("k_outside_expose_proof_item_list", C25860a.m41170z(i, NormalUserFooterPreference.this.ehM.field_username));
                    break;
                case 30:
                    intent.putStringArrayListExtra("k_outside_expose_proof_item_list", C25860a.m41170z(7, NormalUserFooterPreference.this.ehM.field_username));
                    break;
                default:
                    i = 999;
                    break;
            }
            intent.putExtra("k_username", NormalUserFooterPreference.this.ehM.field_username);
            intent.putExtra("showShare", false);
            intent.putExtra("rawUrl", String.format("https://weixin110.qq.com/security/readtemplate?t=weixin_report/w_type&scene=%d#wechat_redirect", new Object[]{Integer.valueOf(i)}));
            C25985d.m41467b(NormalUserFooterPreference.this.crP, "webview", ".ui.tools.WebViewUI", intent);
        }
    }

    /* renamed from: com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference$b */
    class C34721b extends C21474c {

        /* renamed from: com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference$b$1 */
        class C347081 implements OnClickListener {
            C347081() {
            }

            public final void onClick(View view) {
                AppMethodBeat.m2504i(23695);
                C34721b.this.cbs();
                AppMethodBeat.m2505o(23695);
            }
        }

        /* renamed from: com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference$b$2 */
        class C347092 implements OnClickListener {
            C347092() {
            }

            public final void onClick(View view) {
                AppMethodBeat.m2504i(23696);
                Intent intent;
                if (NormalUserFooterPreference.this.poy && C9089a.dgL()) {
                    intent = new Intent();
                    intent.putExtra("Chat_User", NormalUserFooterPreference.this.ehM.field_encryptUsername);
                    intent.putExtra("lbs_mode", true);
                    intent.putExtra("lbs_ticket", NormalUserFooterPreference.this.jEs);
                    intent.putExtra("add_scene", NormalUserFooterPreference.this.gwP);
                    C39503b.gkE.mo38915d(intent, NormalUserFooterPreference.this.crP);
                    AppMethodBeat.m2505o(23696);
                    return;
                }
                intent = new Intent();
                intent.putExtra("Contact_User", NormalUserFooterPreference.this.ehM.field_username);
                intent.putExtra("Contact_Scene", NormalUserFooterPreference.this.gwP);
                intent.putExtra(C5495b.yfT, NormalUserFooterPreference.this.ehM.dus);
                C39503b.gkE.mo38897a(intent, NormalUserFooterPreference.this.mContext);
                AppMethodBeat.m2505o(23696);
            }
        }

        public C34721b() {
            super();
        }

        /* Access modifiers changed, original: protected|final */
        public final void cbp() {
            AppMethodBeat.m2504i(23697);
            if (NormalUserFooterPreference.this.ehM == null) {
                C4990ab.m7412e("MicroMsg.NormalUserFooterPreference", "contact is null in NearByFriendHandler");
                AppMethodBeat.m2505o(23697);
            } else if (C7486a.m12942jh(NormalUserFooterPreference.this.ehM.field_type) && (!C7486a.m12942jh(NormalUserFooterPreference.this.ehM.field_type) || !C7616ad.m13548mR(NormalUserFooterPreference.this.ehM.field_username))) {
                cbo();
                AppMethodBeat.m2505o(23697);
            } else if (C7616ad.m13548mR(NormalUserFooterPreference.this.ehM.field_username)) {
                mo55325F(true, true);
                AppMethodBeat.m2505o(23697);
            } else {
                mo55325F(false, true);
                AppMethodBeat.m2505o(23697);
            }
        }

        /* Access modifiers changed, original: protected|final */
        /* JADX WARNING: Removed duplicated region for block: B:10:0x0082  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void cbn() {
            AppMethodBeat.m2504i(23698);
            NormalUserFooterPreference.this.poA.setVisibility(8);
            if (!C7486a.m12942jh(NormalUserFooterPreference.this.ehM.field_type) || (C7486a.m12942jh(NormalUserFooterPreference.this.ehM.field_type) && C7616ad.m13548mR(NormalUserFooterPreference.this.ehM.field_username))) {
                NormalUserFooterPreference.this.poH.setVisibility(0);
                NormalUserFooterPreference.this.oik.setVisibility(8);
                NormalUserFooterPreference.this.poN.setVisibility(8);
            } else {
                NormalUserFooterPreference.this.poH.setVisibility(8);
                NormalUserFooterPreference.this.oik.setVisibility(0);
                if (!(NormalUserFooterPreference.this.cbk() || NormalUserFooterPreference.this.ehM.field_username.equals(C1853r.m3846Yz()))) {
                    NormalUserFooterPreference.this.poL.setVisibility(0);
                    NormalUserFooterPreference.this.poK.setVisibility(8);
                    NormalUserFooterPreference.this.poM.setVisibility(8);
                    NormalUserFooterPreference.this.poO.setVisibility(8);
                    if (NormalUserFooterPreference.this.pox) {
                        NormalUserFooterPreference.this.poH.setVisibility(8);
                        NormalUserFooterPreference.this.poK.setVisibility(0);
                        NormalUserFooterPreference.this.poK.setOnClickListener(new C347081());
                    }
                    NormalUserFooterPreference.this.poJ.setOnClickListener(new C347092());
                    AppMethodBeat.m2505o(23698);
                }
            }
            NormalUserFooterPreference.this.poL.setVisibility(8);
            NormalUserFooterPreference.this.poK.setVisibility(8);
            NormalUserFooterPreference.this.poM.setVisibility(8);
            NormalUserFooterPreference.this.poO.setVisibility(8);
            if (NormalUserFooterPreference.this.pox) {
            }
            NormalUserFooterPreference.this.poJ.setOnClickListener(new C347092());
            AppMethodBeat.m2505o(23698);
        }
    }

    public NormalUserFooterPreference(Context context) {
        super(context);
        AppMethodBeat.m2504i(23733);
        this.crP = (MMActivity) context;
        init();
        AppMethodBeat.m2505o(23733);
    }

    public NormalUserFooterPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(23734);
        this.crP = (MMActivity) context;
        init();
        AppMethodBeat.m2505o(23734);
    }

    public NormalUserFooterPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(23735);
        this.crP = (MMActivity) context;
        init();
        AppMethodBeat.m2505o(23735);
    }

    private void init() {
        this.lyb = false;
        this.poz = null;
    }

    private void initView() {
        AppMethodBeat.m2504i(23736);
        if (!this.lyb || this.ehM == null) {
            C4990ab.m7420w("MicroMsg.NormalUserFooterPreference", "iniView : bindView = " + this.lyb + " contact = " + this.ehM);
            if (this.poz != null) {
                try {
                    this.poz.cbp();
                    AppMethodBeat.m2505o(23736);
                    return;
                } catch (Throwable th) {
                }
            }
            AppMethodBeat.m2505o(23736);
            return;
        }
        if (this.poz != null) {
            this.poz.mo36951Xy();
        }
        cbk();
        AppMethodBeat.m2505o(23736);
    }

    public final void onBindView(View view) {
        AppMethodBeat.m2504i(23737);
        C4990ab.m7410d("MicroMsg.NormalUserFooterPreference", "on bindView " + view.toString());
        this.poA = view.findViewById(2131822978);
        this.poB = (Button) view.findViewById(2131822979);
        this.poC = (Button) view.findViewById(2131822986);
        this.poF = (Button) view.findViewById(2131822982);
        this.poG = (TextView) view.findViewById(2131822993);
        this.poE = view.findViewById(2131822981);
        this.poD = (Button) view.findViewById(2131822980);
        this.poK = (Button) view.findViewById(2131822987);
        this.poH = view.findViewById(2131822983);
        this.poI = (Button) view.findViewById(2131822985);
        this.poJ = (Button) view.findViewById(2131822984);
        this.oik = (Button) view.findViewById(2131822988);
        this.poN = (Button) view.findViewById(2131822991);
        this.poL = (Button) view.findViewById(2131822989);
        this.poM = (Button) view.findViewById(2131822990);
        this.poO = (TextView) view.findViewById(2131822992);
        this.lyb = true;
        initView();
        super.onBindView(view);
        if (this.crP.getIntent().getBooleanExtra("Accept_NewFriend_FromOutside", false) && this.poB != null) {
            this.poB.performClick();
        }
        AppMethodBeat.m2505o(23737);
    }

    /* renamed from: a */
    public final boolean mo55318a(C7616ad c7616ad, String str, boolean z, boolean z2, boolean z3, int i, int i2, boolean z4, boolean z5, long j, String str2) {
        boolean z6;
        AppMethodBeat.m2504i(23738);
        biV();
        if (c7616ad != null) {
            z6 = true;
        } else {
            z6 = false;
        }
        Assert.assertTrue(z6);
        Assert.assertTrue(C5046bo.nullAsNil(c7616ad.field_username).length() > 0);
        if (C7616ad.aoC(C1853r.m3846Yz()).equals(c7616ad.field_username)) {
            AppMethodBeat.m2505o(23738);
            return false;
        }
        this.ehM = c7616ad;
        this.mGZ = str;
        this.pli = z;
        this.gwP = i;
        this.pmV = i2;
        this.pow = C5046bo.m7517a(Boolean.valueOf(C1855t.m3910mW(c7616ad.field_username)), false);
        this.pkC = z4;
        this.pov = z5;
        this.pnz = j;
        this.pnd = str2;
        this.poQ = false;
        this.pni = c7616ad.field_deleteFlag == 1;
        this.poP = this.crP.getIntent().getBooleanExtra("Contact_AlwaysShowSnsPreBtn", false);
        this.pmD = this.crP.getIntent().getIntExtra("add_more_friend_search_scene", 0);
        this.pox = this.crP.getIntent().getBooleanExtra("Contact_IsLbsChattingProfile", false);
        this.poy = this.crP.getIntent().getBooleanExtra("Contact_IsLbsGotoChatting", false);
        this.jEs = this.crP.getIntent().getStringExtra("lbs_ticket");
        if (!C1853r.m3858mG(c7616ad.field_username)) {
            C9638aw.m17190ZK();
            if (!C18628c.m29086XU().has(c7616ad.field_username)) {
                if (C7616ad.aou(c7616ad.field_username)) {
                    this.poz = new C34711h();
                } else if (C1855t.m3943nl(c7616ad.field_username)) {
                    this.poz = new C28691d();
                } else if (C1855t.m3910mW(c7616ad.field_username)) {
                    this.poz = new C34710g();
                } else if (C7616ad.aov(c7616ad.field_username)) {
                    this.poz = new C12839f();
                } else if (C7486a.m12942jh(c7616ad.field_type) && !C7616ad.m13548mR(c7616ad.field_username)) {
                    this.poz = new C21474c();
                    this.poQ = true;
                } else if (z2) {
                    this.poz = new C34714j();
                    this.poQ = true;
                } else if (z3 || C7616ad.m13548mR(c7616ad.field_username)) {
                    this.poz = new C34721b();
                } else {
                    this.poz = new C21474c();
                    this.poQ = true;
                }
                initView();
                AppMethodBeat.m2505o(23738);
                return true;
            }
        }
        this.poz = new C21474c();
        this.poQ = true;
        initView();
        AppMethodBeat.m2505o(23738);
        return true;
    }

    public final boolean cbk() {
        AppMethodBeat.m2504i(23739);
        if (this.poP && C7486a.m12942jh(this.ehM.field_type)) {
            this.poN.setVisibility(0);
            AppMethodBeat.m2505o(23739);
            return true;
        }
        this.poN.setVisibility(8);
        AppMethodBeat.m2505o(23739);
        return false;
    }

    public final boolean biV() {
        AppMethodBeat.m2504i(23740);
        if (this.poz != null) {
            this.poz.onDetach();
        }
        this.fry.removeAll();
        if (this.ehJ != null) {
            this.ehJ.dismiss();
            this.ehJ = null;
        }
        AppMethodBeat.m2505o(23740);
        return true;
    }

    /* renamed from: a */
    public final void mo5248a(String str, C4935m c4935m) {
        AppMethodBeat.m2504i(23741);
        if (C5046bo.nullAsNil(str).length() <= 0) {
            AppMethodBeat.m2505o(23741);
            return;
        }
        if (this.ehM != null && (str.equals(this.ehM.field_username) || str.equals(this.ehM.field_encryptUsername))) {
            C9638aw.m17190ZK();
            this.ehM = C18628c.m29078XM().aoO(this.ehM.field_username);
            C5004al.m7441d(new C286862());
        }
        AppMethodBeat.m2505o(23741);
    }

    public final void cbl() {
        AppMethodBeat.m2504i(23742);
        C4990ab.m7417i("MicroMsg.NormalUserFooterPreference", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", Boolean.valueOf(C35805b.m58707a(this.crP, "android.permission.RECORD_AUDIO", 82, "", "")), C5046bo.dpG(), this.crP);
        if (C35805b.m58707a(this.crP, "android.permission.RECORD_AUDIO", 82, "", "")) {
            C26250ui c26250ui = new C26250ui();
            c26250ui.cQx.cAd = 5;
            c26250ui.cQx.talker = this.ehM.field_username;
            c26250ui.cQx.context = this.crP;
            c26250ui.cQx.cQs = 4;
            C4879a.xxA.mo10055m(c26250ui);
            AppMethodBeat.m2505o(23742);
            return;
        }
        AppMethodBeat.m2505o(23742);
    }

    public final void cbm() {
        AppMethodBeat.m2504i(23743);
        C4990ab.m7417i("MicroMsg.NormalUserFooterPreference", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", Boolean.valueOf(C35805b.m58707a(this.crP, "android.permission.CAMERA", 19, "", "")), C5046bo.dpG(), this.crP);
        if (C35805b.m58707a(this.crP, "android.permission.CAMERA", 19, "", "")) {
            C4990ab.m7417i("MicroMsg.NormalUserFooterPreference", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", Boolean.valueOf(C35805b.m58707a(this.crP, "android.permission.RECORD_AUDIO", 19, "", "")), C5046bo.dpG(), this.crP);
            if (C35805b.m58707a(this.crP, "android.permission.RECORD_AUDIO", 19, "", "")) {
                C26250ui c26250ui = new C26250ui();
                c26250ui.cQx.cAd = 5;
                c26250ui.cQx.talker = this.ehM.field_username;
                c26250ui.cQx.context = this.crP;
                c26250ui.cQx.cQs = 2;
                C4879a.xxA.mo10055m(c26250ui);
                AppMethodBeat.m2505o(23743);
                return;
            }
            AppMethodBeat.m2505o(23743);
            return;
        }
        AppMethodBeat.m2505o(23743);
    }
}
