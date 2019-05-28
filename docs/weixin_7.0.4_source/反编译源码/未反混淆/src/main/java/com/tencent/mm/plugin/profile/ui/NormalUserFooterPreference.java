package com.tencent.mm.plugin.profile.ui;

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
import com.tencent.mm.R;
import com.tencent.mm.ai.m;
import com.tencent.mm.g.a.sz;
import com.tencent.mm.g.a.uh;
import com.tencent.mm.g.a.ui;
import com.tencent.mm.g.b.a.u;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.r;
import com.tencent.mm.model.t;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.plugin.account.friend.a.ao;
import com.tencent.mm.plugin.appbrand.jsapi.aa;
import com.tencent.mm.plugin.appbrand.jsapi.au;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.preference.Preference;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

public class NormalUserFooterPreference extends Preference implements com.tencent.mm.sdk.e.k.a {
    private MMActivity crP;
    public ProgressDialog ehJ = null;
    private ad ehM;
    protected l<e, String> fry = new l<e, String>() {
        public final /* synthetic */ void a(Object obj, Looper looper) {
            AppMethodBeat.i(23670);
            e eVar = (e) obj;
            if (looper == null) {
                looper = Looper.getMainLooper();
            }
            super.a(eVar, looper);
            AppMethodBeat.o(23670);
        }

        public final /* synthetic */ void w(Object obj, Object obj2) {
            AppMethodBeat.i(23669);
            String str = (String) obj2;
            if (str.equals("show_btn")) {
                NormalUserFooterPreference.this.ehM;
                AppMethodBeat.o(23669);
                return;
            }
            if (str.equals("hide_btn")) {
                NormalUserFooterPreference.this.ehM;
            }
            AppMethodBeat.o(23669);
        }
    };
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
    private a poz;

    public interface e {
    }

    class f extends a {
        public f() {
            super();
        }

        /* Access modifiers changed, original: protected|final */
        public final void cbp() {
            AppMethodBeat.i(23712);
            if (NormalUserFooterPreference.this.ehM == null || !com.tencent.mm.n.a.jh(NormalUserFooterPreference.this.ehM.field_type)) {
                F(false, true);
                AppMethodBeat.o(23712);
                return;
            }
            cbo();
            AppMethodBeat.o(23712);
        }

        /* Access modifiers changed, original: protected|final */
        public final void cbn() {
            AppMethodBeat.i(23713);
            NormalUserFooterPreference.this.poA.setVisibility(8);
            NormalUserFooterPreference.this.poH.setVisibility(0);
            NormalUserFooterPreference.this.poK.setVisibility(8);
            NormalUserFooterPreference.this.oik.setVisibility(8);
            NormalUserFooterPreference.this.poN.setVisibility(8);
            NormalUserFooterPreference.this.poL.setVisibility(8);
            NormalUserFooterPreference.this.poM.setVisibility(8);
            NormalUserFooterPreference.this.poO.setVisibility(8);
            NormalUserFooterPreference.this.poJ.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(23711);
                    com.tencent.mm.plugin.normsg.a.b.oTO.ae(1, 1, 5);
                    Intent intent = new Intent();
                    intent.putExtra("Contact_User", NormalUserFooterPreference.this.ehM.field_username);
                    intent.putExtra("Contact_Scene", NormalUserFooterPreference.this.gwP);
                    intent.putExtra(com.tencent.mm.ui.e.b.yfT, NormalUserFooterPreference.this.ehM.dus);
                    com.tencent.mm.plugin.profile.b.gkE.a(intent, NormalUserFooterPreference.this.mContext);
                    AppMethodBeat.o(23711);
                }
            });
            AppMethodBeat.o(23713);
        }
    }

    class c extends a {
        public c() {
            super();
        }

        /* Access modifiers changed, original: protected|final */
        public final void Xy() {
            AppMethodBeat.i(23704);
            super.Xy();
            AppMethodBeat.o(23704);
        }

        /* Access modifiers changed, original: protected */
        public void onDetach() {
            AppMethodBeat.i(23705);
            super.onDetach();
            AppMethodBeat.o(23705);
        }

        /* Access modifiers changed, original: protected */
        public void cbn() {
            AppMethodBeat.i(23706);
            Assert.assertTrue(!t.nI(NormalUserFooterPreference.this.ehM.field_username));
            NormalUserFooterPreference.this.poA.setVisibility(8);
            NormalUserFooterPreference.this.poH.setVisibility(8);
            if (NormalUserFooterPreference.this.pni) {
                NormalUserFooterPreference.this.poC.setOnClickListener(new OnClickListener() {
                    public final void onClick(View view) {
                        AppMethodBeat.i(23699);
                        c.this.cbr();
                        AppMethodBeat.o(23699);
                    }
                });
                if (com.tencent.mm.n.a.jh(NormalUserFooterPreference.this.ehM.field_type)) {
                    NormalUserFooterPreference.this.poC.setVisibility(0);
                } else {
                    NormalUserFooterPreference.this.poC.setVisibility(8);
                }
                NormalUserFooterPreference.this.poK.setVisibility(8);
                NormalUserFooterPreference.this.oik.setVisibility(8);
                NormalUserFooterPreference.this.poN.setVisibility(8);
                NormalUserFooterPreference.this.poL.setVisibility(8);
                NormalUserFooterPreference.this.poO.setVisibility(8);
                AppMethodBeat.o(23706);
                return;
            }
            NormalUserFooterPreference.this.poK.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(23700);
                    if (NormalUserFooterPreference.this.crP.getIntent() != null) {
                        String stringExtra = NormalUserFooterPreference.this.crP.getIntent().getStringExtra("key_ww_add_session_id");
                        if (!bo.isNullOrNil(stringExtra)) {
                            u uVar = new u();
                            uVar.eP(stringExtra);
                            uVar.cXR = 0;
                            uVar.cXT = 1;
                            uVar.ajK();
                        }
                    }
                    c.this.cbs();
                    if (NormalUserFooterPreference.this.pmD != 0) {
                        com.tencent.mm.plugin.report.service.h.pYm.e(11263, Integer.valueOf(NormalUserFooterPreference.this.pmD), NormalUserFooterPreference.this.ehM.field_username);
                    }
                    AppMethodBeat.o(23700);
                }
            });
            if (com.tencent.mm.n.a.jh(NormalUserFooterPreference.this.ehM.field_type)) {
                NormalUserFooterPreference.this.poK.setVisibility(8);
                NormalUserFooterPreference.this.oik.setVisibility(0);
                if (NormalUserFooterPreference.this.cbk() || NormalUserFooterPreference.this.ehM.field_username.equals(r.Yz()) || t.nI(NormalUserFooterPreference.this.ehM.field_username) || t.nB(NormalUserFooterPreference.this.ehM.field_username) || ad.aox(NormalUserFooterPreference.this.ehM.field_username) || t.mX(NormalUserFooterPreference.this.ehM.field_username)) {
                    NormalUserFooterPreference.this.poL.setVisibility(8);
                } else {
                    NormalUserFooterPreference.this.poL.setVisibility(0);
                }
                aw.ZK();
                if (com.tencent.mm.model.c.XM().aoR(NormalUserFooterPreference.this.ehM.field_username)) {
                    NormalUserFooterPreference.this.poM.setVisibility(0);
                    NormalUserFooterPreference.this.gwP = NormalUserFooterPreference.this.ehM.getSource();
                }
            } else {
                NormalUserFooterPreference.this.poK.setVisibility(0);
                NormalUserFooterPreference.this.oik.setVisibility(8);
                NormalUserFooterPreference.this.poN.setVisibility(8);
                NormalUserFooterPreference.this.poL.setVisibility(8);
            }
            if (NormalUserFooterPreference.this.ehM.Oa()) {
                NormalUserFooterPreference.this.poO.setVisibility(0);
                AppMethodBeat.o(23706);
                return;
            }
            NormalUserFooterPreference.this.poO.setVisibility(8);
            AppMethodBeat.o(23706);
        }

        /* Access modifiers changed, original: protected|final */
        public final void cbs() {
            AppMethodBeat.i(23707);
            if (((int) NormalUserFooterPreference.this.ehM.ewQ) == 0) {
                aw.ZK();
                if (com.tencent.mm.model.c.XM().aa(NormalUserFooterPreference.this.ehM) != -1) {
                    NormalUserFooterPreference normalUserFooterPreference = NormalUserFooterPreference.this;
                    aw.ZK();
                    normalUserFooterPreference.ehM = com.tencent.mm.model.c.XM().aoO(NormalUserFooterPreference.this.ehM.field_username);
                }
            }
            if (NormalUserFooterPreference.this.pov || NormalUserFooterPreference.this.gwP == 12) {
                ab.d("MicroMsg.NormalUserFooterPreference", "qqNum " + NormalUserFooterPreference.this.pnz + " qqReamrk " + NormalUserFooterPreference.this.pnd);
                if (!(NormalUserFooterPreference.this.pnz == 0 || NormalUserFooterPreference.this.pnd == null || NormalUserFooterPreference.this.pnd.equals(""))) {
                    ao ge = com.tencent.mm.plugin.account.a.getQQListStg().ge(NormalUserFooterPreference.this.pnz);
                    if (ge == null) {
                        ge = new ao();
                        ge.nickname = "";
                        ge.gwC = NormalUserFooterPreference.this.pnz;
                        ge.gwK = NormalUserFooterPreference.this.pnd;
                        ge.username = NormalUserFooterPreference.this.ehM.field_username;
                        ge.aqu();
                        com.tencent.mm.plugin.account.a.getQQListStg().a(ge);
                    } else {
                        ge.gwC = NormalUserFooterPreference.this.pnz;
                        ge.gwK = NormalUserFooterPreference.this.pnd;
                        ge.username = NormalUserFooterPreference.this.ehM.field_username;
                        ge.aqu();
                        com.tencent.mm.plugin.account.a.getQQListStg().a(NormalUserFooterPreference.this.pnz, ge);
                    }
                }
            } else if (NormalUserFooterPreference.this.gwP == 58 || NormalUserFooterPreference.this.gwP == 59 || NormalUserFooterPreference.this.gwP == 60) {
                com.tencent.mm.plugin.account.a.getGoogleFriendStorage().ak(NormalUserFooterPreference.this.ehM.field_username, 1);
            }
            cbt();
            final com.tencent.mm.pluginsdk.ui.applet.a aVar = new com.tencent.mm.pluginsdk.ui.applet.a(NormalUserFooterPreference.this.mContext, new com.tencent.mm.pluginsdk.ui.applet.a.a() {
                public final void a(boolean z, boolean z2, String str, String str2) {
                    AppMethodBeat.i(23701);
                    if (z) {
                        NormalUserFooterPreference.this.fry.cF("hide_btn");
                        NormalUserFooterPreference.this.fry.doNotify();
                        NormalUserFooterPreference.this.poP = true;
                        c.a(c.this);
                    } else if (z2) {
                        com.tencent.mm.bi.d.akP().ep(str, 2);
                    } else {
                        ab.e("MicroMsg.NormalUserFooterPreference", "canAddContact fail, maybe interrupt by IOnNeedSentVerify, username = ".concat(String.valueOf(str)));
                    }
                    if (z || z2) {
                        Intent intent = NormalUserFooterPreference.this.crP.getIntent();
                        int intExtra = intent.getIntExtra("search_kvstat_scene", 0);
                        int intExtra2 = intent.getIntExtra("search_kvstat_position", 0);
                        if (intExtra > 0 && intExtra2 > 0) {
                            com.tencent.mm.plugin.report.service.h.pYm.e(10991, Integer.valueOf(intExtra), Integer.valueOf(6), Integer.valueOf(intExtra2));
                        }
                    }
                    AppMethodBeat.o(23701);
                }
            });
            final LinkedList linkedList = new LinkedList();
            linkedList.add(Integer.valueOf(NormalUserFooterPreference.this.gwP));
            final String stringExtra = NormalUserFooterPreference.this.crP.getIntent().getStringExtra("source_from_user_name");
            final String stringExtra2 = NormalUserFooterPreference.this.crP.getIntent().getStringExtra("source_from_nick_name");
            aVar.hH(stringExtra, stringExtra2);
            aVar.vjI = new com.tencent.mm.pluginsdk.ui.applet.a.b() {
                public final boolean vQ(String str) {
                    AppMethodBeat.i(23702);
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
                    intent.putExtra(com.tencent.mm.ui.e.b.yfT, str);
                    NormalUserFooterPreference.this.crP.startActivityForResult(intent, 0);
                    AppMethodBeat.o(23702);
                    return true;
                }
            };
            stringExtra2 = NormalUserFooterPreference.this.crP.getIntent().getStringExtra("room_name");
            stringExtra = NormalUserFooterPreference.this.crP.getIntent().getStringExtra(com.tencent.mm.ui.e.b.yfT);
            if (!TextUtils.isEmpty(stringExtra)) {
                ab.i("MicroMsg.NormalUserFooterPreference", "add contact case 1:%s", stringExtra);
                aVar.ajw(stringExtra);
                aVar.c(NormalUserFooterPreference.this.ehM.field_username, "", linkedList);
                AppMethodBeat.o(23707);
            } else if (TextUtils.isEmpty(stringExtra2)) {
                ab.i("MicroMsg.NormalUserFooterPreference", "add contact case 2, %s", NormalUserFooterPreference.this.ehM.dus);
                aVar.ajw(NormalUserFooterPreference.this.ehM.dus);
                aVar.e(NormalUserFooterPreference.this.ehM.field_username, linkedList);
                AppMethodBeat.o(23707);
            } else if (TextUtils.isEmpty(aVar.mGZ)) {
                aw.ZK();
                ad aoO = com.tencent.mm.model.c.XM().aoO(NormalUserFooterPreference.this.ehM.field_username);
                CharSequence bc = aoO != null ? bo.bc(aoO.dus, "") : "";
                ab.i("MicroMsg.NormalUserFooterPreference", "dkverify footer add:%s chat:%s ticket:%s", NormalUserFooterPreference.this.ehM.field_username, stringExtra2, bc);
                if (TextUtils.isEmpty(bc)) {
                    com.tencent.mm.model.ao.a.flu.a(NormalUserFooterPreference.this.ehM.field_username, stringExtra2, new com.tencent.mm.model.ao.b.a() {
                        public final void o(String str, boolean z) {
                            AppMethodBeat.i(23703);
                            aw.ZK();
                            ad aoO = com.tencent.mm.model.c.XM().aoO(NormalUserFooterPreference.this.ehM.field_username);
                            aVar.ajw(aoO != null ? bo.bc(aoO.dus, "") : "");
                            aVar.c(NormalUserFooterPreference.this.ehM.field_username, stringExtra2, linkedList);
                            AppMethodBeat.o(23703);
                        }
                    });
                    AppMethodBeat.o(23707);
                    return;
                }
                aVar.ajw(bc);
                aVar.c(NormalUserFooterPreference.this.ehM.field_username, stringExtra2, linkedList);
                AppMethodBeat.o(23707);
            } else {
                ab.i("MicroMsg.NormalUserFooterPreference", "add contact case 3, %s", NormalUserFooterPreference.this.ehM.dus);
                aVar.ajw(NormalUserFooterPreference.this.ehM.dus);
                aVar.c(NormalUserFooterPreference.this.ehM.field_username, stringExtra2, linkedList);
                AppMethodBeat.o(23707);
            }
        }

        private void cbt() {
            AppMethodBeat.i(23708);
            String stringExtra = NormalUserFooterPreference.this.crP.getIntent().getStringExtra("Contact_Mobile_MD5");
            String stringExtra2 = NormalUserFooterPreference.this.crP.getIntent().getStringExtra("Contact_full_Mobile_MD5");
            String nullAsNil = bo.nullAsNil(stringExtra);
            stringExtra = bo.nullAsNil(stringExtra2);
            if (!(nullAsNil.equals("") && stringExtra.equals(""))) {
                com.tencent.mm.plugin.account.friend.a.a vW = com.tencent.mm.plugin.account.a.getAddrUploadStg().vW(nullAsNil);
                if (vW == null) {
                    vW = com.tencent.mm.plugin.account.a.getAddrUploadStg().vW(stringExtra);
                } else {
                    stringExtra = nullAsNil;
                }
                if (vW == null) {
                    AppMethodBeat.o(23708);
                    return;
                }
                com.tencent.mm.plugin.account.a.getAddrUploadStg().a(stringExtra, vW);
            }
            AppMethodBeat.o(23708);
        }

        static /* synthetic */ void a(c cVar) {
            int i = 0;
            AppMethodBeat.i(23709);
            if (((int) NormalUserFooterPreference.this.ehM.ewQ) == 0) {
                aw.ZK();
                com.tencent.mm.model.c.XM().aa(NormalUserFooterPreference.this.ehM);
                aw.ZK();
                com.tencent.mm.model.c.XM().aoO(NormalUserFooterPreference.this.ehM.field_username);
            }
            if (((int) NormalUserFooterPreference.this.ehM.ewQ) <= 0) {
                ab.e("MicroMsg.NormalUserFooterPreference", "addContact : insert contact failed");
                AppMethodBeat.o(23709);
                return;
            }
            if (!com.tencent.mm.n.a.jh(NormalUserFooterPreference.this.ehM.field_type) && NormalUserFooterPreference.this.gwP == 15) {
                com.tencent.mm.plugin.account.friend.a.a vT = com.tencent.mm.plugin.account.a.getAddrUploadStg().vT(NormalUserFooterPreference.this.ehM.field_username);
                if (vT != null) {
                    com.tencent.mm.plugin.report.service.h hVar = com.tencent.mm.plugin.report.service.h.pYm;
                    Object[] objArr = new Object[4];
                    objArr[0] = NormalUserFooterPreference.this.ehM.field_username;
                    objArr[1] = Integer.valueOf(3);
                    if (!bo.isNullOrNil(vT.Aq())) {
                        i = 1;
                    }
                    objArr[2] = Integer.valueOf(i);
                    objArr[3] = Integer.valueOf(NormalUserFooterPreference.this.ehM.dur.toString().split(",").length >= 5 ? 5 : NormalUserFooterPreference.this.ehM.dur.toString().split(",").length);
                    hVar.e(12040, objArr);
                }
            }
            t.q(NormalUserFooterPreference.this.ehM);
            NormalUserFooterPreference normalUserFooterPreference = NormalUserFooterPreference.this;
            aw.ZK();
            normalUserFooterPreference.ehM = com.tencent.mm.model.c.XM().aoO(NormalUserFooterPreference.this.ehM.field_username);
            cVar.cbn();
            AppMethodBeat.o(23709);
        }
    }

    class d extends a {
        public d() {
            super();
        }

        /* Access modifiers changed, original: protected|final */
        public final void cbp() {
        }

        /* Access modifiers changed, original: protected|final */
        public final void cbn() {
            AppMethodBeat.i(23710);
            Assert.assertTrue(t.nl(NormalUserFooterPreference.this.ehM.field_username));
            NormalUserFooterPreference.this.poA.setVisibility(8);
            NormalUserFooterPreference.this.poH.setVisibility(8);
            NormalUserFooterPreference.this.poK.setVisibility(8);
            NormalUserFooterPreference.this.oik.setVisibility(0);
            NormalUserFooterPreference.this.poN.setVisibility(8);
            NormalUserFooterPreference.this.poL.setVisibility(8);
            NormalUserFooterPreference.this.poM.setVisibility(8);
            NormalUserFooterPreference.this.poO.setVisibility(8);
            AppMethodBeat.o(23710);
        }
    }

    class g extends a {
        public g() {
            super();
        }

        public final void cbp() {
        }

        /* Access modifiers changed, original: protected|final */
        public final void cbn() {
            boolean z = true;
            AppMethodBeat.i(23714);
            Assert.assertTrue(!r.mG(NormalUserFooterPreference.this.ehM.field_username));
            if (t.nI(NormalUserFooterPreference.this.ehM.field_username)) {
                z = false;
            }
            Assert.assertTrue(z);
            NormalUserFooterPreference.this.poA.setVisibility(8);
            NormalUserFooterPreference.this.poH.setVisibility(8);
            NormalUserFooterPreference.this.oik.setText(R.string.b02);
            NormalUserFooterPreference.this.oik.setVisibility(0);
            NormalUserFooterPreference.this.poL.setVisibility(8);
            NormalUserFooterPreference.this.poK.setVisibility(8);
            NormalUserFooterPreference.this.poO.setVisibility(8);
            AppMethodBeat.o(23714);
        }
    }

    class h extends a {
        public h() {
            super();
        }

        /* Access modifiers changed, original: protected|final */
        public final void cbp() {
        }

        /* Access modifiers changed, original: protected|final */
        public final void cbn() {
            AppMethodBeat.i(23715);
            NormalUserFooterPreference.this.poA.setVisibility(8);
            NormalUserFooterPreference.this.oik.setVisibility(0);
            if (NormalUserFooterPreference.this.cbk() || NormalUserFooterPreference.this.ehM.field_username.equals(r.Yz()) || t.nI(NormalUserFooterPreference.this.ehM.field_username) || t.nB(NormalUserFooterPreference.this.ehM.field_username)) {
                NormalUserFooterPreference.this.poL.setVisibility(8);
            } else {
                NormalUserFooterPreference.this.poL.setVisibility(0);
            }
            NormalUserFooterPreference.this.oik.setText(R.string.azy);
            NormalUserFooterPreference.this.poK.setVisibility(8);
            NormalUserFooterPreference.this.poH.setVisibility(8);
            NormalUserFooterPreference.this.poO.setVisibility(8);
            AppMethodBeat.o(23715);
        }
    }

    class i extends c implements com.tencent.mm.ai.f {
        private ProgressDialog ehJ;

        public i() {
            super();
        }

        /* Access modifiers changed, original: protected */
        public void cbn() {
            AppMethodBeat.i(23719);
            onDetach();
            onStop();
            aw.Rg().a(30, (com.tencent.mm.ai.f) this);
            aw.Rg().a(667, (com.tencent.mm.ai.f) this);
            aw.Rg().a(853, (com.tencent.mm.ai.f) this);
            super.cbn();
            AppMethodBeat.o(23719);
        }

        /* Access modifiers changed, original: final */
        public final void onStop() {
            AppMethodBeat.i(23720);
            aw.Rg().b(30, (com.tencent.mm.ai.f) this);
            aw.Rg().b(667, (com.tencent.mm.ai.f) this);
            aw.Rg().b(853, (com.tencent.mm.ai.f) this);
            AppMethodBeat.o(23720);
        }

        /* Access modifiers changed, original: protected */
        public void onDetach() {
            AppMethodBeat.i(23721);
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
            AppMethodBeat.o(23721);
        }

        private void NB() {
            AppMethodBeat.i(23722);
            NormalUserFooterPreference normalUserFooterPreference = NormalUserFooterPreference.this;
            aw.ZK();
            ad aoO = com.tencent.mm.model.c.XM().aoO(NormalUserFooterPreference.this.ehM.field_username);
            if (aoO == null || ((int) aoO.ewQ) == 0) {
                aoO = NormalUserFooterPreference.this.ehM;
                aw.ZK();
                if (com.tencent.mm.model.c.XM().Y(aoO)) {
                    aw.ZK();
                    aoO = com.tencent.mm.model.c.XM().aoO(NormalUserFooterPreference.this.ehM.field_username);
                } else {
                    ab.e("MicroMsg.NormalUserFooterPreference", "insert contact failed, username = " + aoO.field_username);
                    aoO = null;
                }
            }
            normalUserFooterPreference.ehM = aoO;
            if (NormalUserFooterPreference.this.ehM != null) {
                t.q(NormalUserFooterPreference.this.ehM);
            }
            AppMethodBeat.o(23722);
        }

        /* Access modifiers changed, original: protected */
        public void cbu() {
            AppMethodBeat.i(23723);
            if (NormalUserFooterPreference.this.poz != null) {
                NormalUserFooterPreference.this.poz.onDetach();
            }
            NormalUserFooterPreference.this.poz = new c();
            NormalUserFooterPreference.this.poz.Xy();
            AppMethodBeat.o(23723);
        }

        public void onSceneEnd(int i, int i2, String str, m mVar) {
            int i3 = 0;
            AppMethodBeat.i(23724);
            ab.d("MicroMsg.NormalUserFooterPreference", "onSceneEnd, errType = " + i + ", errCode = " + i2);
            if (mVar.getType() == 30 || mVar.getType() == 667 || mVar.getType() == 853) {
                onStop();
                if (this.ehJ != null) {
                    this.ehJ.dismiss();
                    this.ehJ = null;
                }
                if (bo.cv(NormalUserFooterPreference.this.mContext)) {
                    int i4;
                    if (i == 0 && i2 == 0) {
                        if (mVar.getType() == 30) {
                            i4 = ((com.tencent.mm.pluginsdk.model.m) mVar).cAd;
                            ab.d("MicroMsg.NormalUserFooterPreference", "VerifyBaseHandler onSceneEnd, opCode = ".concat(String.valueOf(i4)));
                            if (i4 == 1 || i4 == 3) {
                                List<String> list = ((com.tencent.mm.pluginsdk.model.m) mVar).vbm;
                                if (list != null && list.contains(NormalUserFooterPreference.this.ehM.field_username)) {
                                    NormalUserFooterPreference.this.poP = true;
                                    NB();
                                    cbu();
                                    for (String bG : list) {
                                        com.tencent.mm.pluginsdk.ui.preference.b.bG(bG, NormalUserFooterPreference.this.gwP);
                                    }
                                    aw.getNotification().IH();
                                }
                            }
                            AppMethodBeat.o(23724);
                            return;
                        } else if (mVar.getType() == 667 || mVar.getType() == 853) {
                            NormalUserFooterPreference.this.poP = true;
                            NB();
                            cbu();
                            com.tencent.mm.pluginsdk.ui.preference.b.bG(NormalUserFooterPreference.this.ehM.field_username, NormalUserFooterPreference.this.gwP);
                            aw.getNotification().IH();
                            AppMethodBeat.o(23724);
                            return;
                        }
                    }
                    if (i == 4 && i2 == -302) {
                        if (mVar.getType() == 30) {
                            i4 = ((com.tencent.mm.pluginsdk.model.m) mVar).cAd;
                        } else {
                            i4 = 0;
                        }
                        ab.w("MicroMsg.NormalUserFooterPreference", "VerifyBaseHandler onSceneEnd, verify relation out of date, opCode = %d", Integer.valueOf(i4));
                        if (i4 == 3 || mVar.getType() == 853) {
                            com.tencent.mm.ui.base.h.d(NormalUserFooterPreference.this.crP, NormalUserFooterPreference.this.crP.getString(R.string.b23), NormalUserFooterPreference.this.crP.getString(R.string.tz), NormalUserFooterPreference.this.crP.getString(R.string.fs), NormalUserFooterPreference.this.crP.getString(R.string.or), new DialogInterface.OnClickListener() {
                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    AppMethodBeat.i(23718);
                                    i.this.cbs();
                                    AppMethodBeat.o(23718);
                                }
                            }, null);
                        }
                        AppMethodBeat.o(23724);
                        return;
                    } else if (i == 4 && i2 == -24 && !bo.isNullOrNil(str)) {
                        Toast.makeText(NormalUserFooterPreference.this.crP, str, 1).show();
                        AppMethodBeat.o(23724);
                        return;
                    } else {
                        switch (i) {
                            case 1:
                                if (!aw.Rg().acT()) {
                                    if (com.tencent.mm.network.ab.ch(NormalUserFooterPreference.this.mContext)) {
                                        com.tencent.mm.pluginsdk.ui.tools.h.fR(NormalUserFooterPreference.this.mContext);
                                        i3 = 1;
                                        break;
                                    }
                                }
                                aw.Rg().getNetworkServerIp();
                                new StringBuilder().append(i2);
                                i3 = 1;
                                break;
                                break;
                            case 2:
                                Toast.makeText(NormalUserFooterPreference.this.mContext, NormalUserFooterPreference.this.mContext.getString(R.string.bx9, new Object[]{Integer.valueOf(2), Integer.valueOf(i2)}), AuthApiStatusCodes.AUTH_API_INVALID_CREDENTIALS).show();
                                i3 = 1;
                                break;
                            case 4:
                                if (i2 != -100) {
                                    CharSequence str2;
                                    if (i == 4 && i2 == -34) {
                                        str2 = NormalUserFooterPreference.this.crP.getString(R.string.bwe);
                                    } else if (i == 4 && i2 == -94) {
                                        str2 = NormalUserFooterPreference.this.crP.getString(R.string.bwh);
                                    } else if (i != 4 || bo.isNullOrNil(str2)) {
                                        str2 = NormalUserFooterPreference.this.crP.getString(R.string.e3n);
                                    }
                                    Toast.makeText(NormalUserFooterPreference.this.crP, str2, 1).show();
                                    break;
                                }
                                com.tencent.mm.ui.base.h.a(NormalUserFooterPreference.this.mContext, aw.QH(), com.tencent.mm.bz.a.an(NormalUserFooterPreference.this.mContext, R.string.tz), new DialogInterface.OnClickListener() {
                                    public final void onClick(DialogInterface dialogInterface, int i) {
                                        AppMethodBeat.i(23716);
                                        i.this.onStop();
                                        Intent intent = new Intent();
                                        intent.putExtra("Intro_Switch", true).addFlags(67108864);
                                        com.tencent.mm.plugin.profile.b.gkE.p(intent, NormalUserFooterPreference.this.mContext);
                                        AppMethodBeat.o(23716);
                                    }
                                }, new OnCancelListener() {
                                    public final void onCancel(DialogInterface dialogInterface) {
                                        AppMethodBeat.i(23717);
                                        i.this.onStop();
                                        Intent intent = new Intent();
                                        intent.putExtra("Intro_Switch", true).addFlags(67108864);
                                        com.tencent.mm.plugin.profile.b.gkE.p(intent, NormalUserFooterPreference.this.mContext);
                                        AppMethodBeat.o(23717);
                                    }
                                });
                                i3 = 1;
                                break;
                                break;
                        }
                        if (i3 != 0) {
                            AppMethodBeat.o(23724);
                            return;
                        } else {
                            AppMethodBeat.o(23724);
                            return;
                        }
                    }
                }
                AppMethodBeat.o(23724);
                return;
            }
            AppMethodBeat.o(23724);
        }
    }

    class j extends i implements com.tencent.mm.ai.f {
        public j() {
            super();
        }

        /* Access modifiers changed, original: protected|final */
        public final void cbp() {
            AppMethodBeat.i(23728);
            if (NormalUserFooterPreference.this.ehM == null || !com.tencent.mm.n.a.jh(NormalUserFooterPreference.this.ehM.field_type)) {
                F(false, true);
                AppMethodBeat.o(23728);
                return;
            }
            cbo();
            AppMethodBeat.o(23728);
        }

        /* Access modifiers changed, original: protected|final */
        public final void cbn() {
            AppMethodBeat.i(23729);
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
            if (NormalUserFooterPreference.this.ehM.Oa()) {
                NormalUserFooterPreference.this.poD.setText(NormalUserFooterPreference.this.crP.getString(R.string.ay6));
                NormalUserFooterPreference.this.poO.setVisibility(0);
            } else {
                NormalUserFooterPreference.this.poD.setText(NormalUserFooterPreference.this.crP.getString(R.string.ay1));
            }
            NormalUserFooterPreference.this.poB.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(23725);
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
                    AppMethodBeat.o(23725);
                }
            });
            NormalUserFooterPreference.this.poD.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(23727);
                    if (NormalUserFooterPreference.this.ehM.Oa()) {
                        t.j(NormalUserFooterPreference.this.ehM);
                        NormalUserFooterPreference.this.ehM.NE();
                        j.this.cbn();
                        AppMethodBeat.o(23727);
                        return;
                    }
                    int i;
                    Context context = NormalUserFooterPreference.this.mContext;
                    Context context2 = NormalUserFooterPreference.this.mContext;
                    if (ad.aox(NormalUserFooterPreference.this.ehM.field_username)) {
                        i = R.string.ay3;
                    } else {
                        i = R.string.ay2;
                    }
                    com.tencent.mm.ui.base.h.a(context, context2.getString(i), NormalUserFooterPreference.this.mContext.getString(R.string.ay1), new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.i(23726);
                            t.i(NormalUserFooterPreference.this.ehM);
                            NormalUserFooterPreference.this.ehM.ND();
                            j.this.cbn();
                            AppMethodBeat.o(23726);
                        }
                    }, null);
                    AppMethodBeat.o(23727);
                }
            });
            AppMethodBeat.o(23729);
        }

        /* Access modifiers changed, original: protected|final */
        public final void onDetach() {
            AppMethodBeat.i(23730);
            super.onDetach();
            AppMethodBeat.o(23730);
        }

        /* Access modifiers changed, original: protected|final */
        public final void cbu() {
            AppMethodBeat.i(23731);
            super.cbu();
            AppMethodBeat.o(23731);
        }

        public final void onSceneEnd(int i, int i2, String str, m mVar) {
            AppMethodBeat.i(23732);
            super.onSceneEnd(i, i2, str, mVar);
            AppMethodBeat.o(23732);
        }
    }

    abstract class a implements com.tencent.mm.ai.f {
        boolean isDeleteCancel = false;
        private com.tencent.mm.ui.widget.a.d pki = null;

        public abstract void cbn();

        /* Access modifiers changed, original: protected */
        public void Xy() {
            cbn();
            cbp();
            NormalUserFooterPreference.this.oik.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(23689);
                    ab.i("MicroMsg.NormalUserFooterPreference", "sendButton onClick %s", NormalUserFooterPreference.this.ehM.field_username);
                    a aVar;
                    if (NormalUserFooterPreference.this.pow) {
                        aVar = a.this;
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
                            com.tencent.mm.plugin.profile.b.gkE.d(intent, NormalUserFooterPreference.this.mContext);
                        }
                    } else {
                        aVar = a.this;
                        Intent intent2 = new Intent();
                        intent2.addFlags(67108864);
                        if (NormalUserFooterPreference.this.pli) {
                            intent2.putExtra("Chat_User", NormalUserFooterPreference.this.ehM.field_username);
                            intent2.putExtra("Chat_Mode", 1);
                            ((Activity) NormalUserFooterPreference.this.mContext).setResult(-1, intent2);
                        } else {
                            intent2.putExtra("Chat_User", NormalUserFooterPreference.this.ehM.field_username);
                            intent2.putExtra("Chat_Mode", 1);
                            com.tencent.mm.plugin.profile.b.gkE.d(intent2, NormalUserFooterPreference.this.mContext);
                        }
                    }
                    com.tencent.mm.plugin.report.service.h.pYm.e(16055, Integer.valueOf(com.tencent.mm.plugin.profile.c.am(NormalUserFooterPreference.this.crP.getIntent())), Integer.valueOf(4));
                    AppMethodBeat.o(23689);
                }
            });
            NormalUserFooterPreference.this.poN.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(23690);
                    Intent intent = new Intent();
                    intent.putExtra("sns_permission_userName", NormalUserFooterPreference.this.ehM.field_username);
                    intent.putExtra("sns_permission_anim", true);
                    intent.putExtra("sns_permission_block_scene", 4);
                    com.tencent.mm.bp.d.b(NormalUserFooterPreference.this.crP, "sns", ".ui.SnsPermissionUI", intent);
                    AppMethodBeat.o(23690);
                }
            });
            NormalUserFooterPreference.this.poL.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(23691);
                    a aVar = a.this;
                    uh uhVar = new uh();
                    com.tencent.mm.sdk.b.a.xxA.m(uhVar);
                    if (!NormalUserFooterPreference.this.ehM.field_username.equals(uhVar.cQt.talker) && (uhVar.cQt.cQv || uhVar.cQt.cQw)) {
                        Toast.makeText(NormalUserFooterPreference.this.crP.mController.ylL, uhVar.cQt.cQu ? R.string.ac6 : R.string.ac7, 0).show();
                        ab.i("MicroMsg.NormalUserFooterPreference", "voip is running, can't do this");
                    } else if (!com.tencent.mm.r.a.bH(NormalUserFooterPreference.this.crP)) {
                        sz szVar = new sz();
                        szVar.cPf.cPh = true;
                        com.tencent.mm.sdk.b.a.xxA.m(szVar);
                        String str = szVar.cPg.cPj;
                        if (bo.isNullOrNil(str)) {
                            aVar.cbq();
                        } else {
                            ab.v("MicroMsg.NormalUserFooterPreference", "Talkroom is on: ".concat(String.valueOf(str)));
                            com.tencent.mm.ui.base.h.d(NormalUserFooterPreference.this.crP, NormalUserFooterPreference.this.crP.getString(R.string.euf), "", NormalUserFooterPreference.this.crP.getString(R.string.s6), NormalUserFooterPreference.this.crP.getString(R.string.or), new DialogInterface.OnClickListener() {
                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    AppMethodBeat.i(23677);
                                    sz szVar = new sz();
                                    szVar.cPf.cPi = true;
                                    com.tencent.mm.sdk.b.a.xxA.m(szVar);
                                    a.this.cbq();
                                    dialogInterface.dismiss();
                                    AppMethodBeat.o(23677);
                                }
                            }, new DialogInterface.OnClickListener() {
                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    AppMethodBeat.i(23678);
                                    dialogInterface.dismiss();
                                    AppMethodBeat.o(23678);
                                }
                            });
                        }
                    }
                    com.tencent.mm.plugin.report.service.h.pYm.e(16055, Integer.valueOf(com.tencent.mm.plugin.profile.c.am(NormalUserFooterPreference.this.crP.getIntent())), Integer.valueOf(5));
                    AppMethodBeat.o(23691);
                }
            });
            NormalUserFooterPreference.this.poF.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(23692);
                    a.c(a.this);
                    AppMethodBeat.o(23692);
                }
            });
            NormalUserFooterPreference.this.poI.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(23693);
                    a.c(a.this);
                    AppMethodBeat.o(23693);
                }
            });
            NormalUserFooterPreference.this.poM.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(23694);
                    a.c(a.this);
                    AppMethodBeat.o(23694);
                }
            });
        }

        /* Access modifiers changed, original: protected */
        public void onDetach() {
        }

        public void onSceneEnd(int i, int i2, String str, m mVar) {
            ab.i("MicroMsg.NormalUserFooterPreference", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str + " " + mVar.getType());
        }

        /* Access modifiers changed, original: protected|final */
        public final void cbo() {
            NormalUserFooterPreference.this.crP.addIconOptionMenu(0, R.drawable.uu, new OnMenuItemClickListener() {
                public final boolean onMenuItemClick(MenuItem menuItem) {
                    AppMethodBeat.i(23676);
                    com.tencent.mm.ui.widget.a.d dVar = new com.tencent.mm.ui.widget.a.d(NormalUserFooterPreference.this.crP, 1, false);
                    dVar.rBm = new com.tencent.mm.ui.base.n.d() {
                        public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                            com.tencent.mm.plugin.account.friend.a.a aVar = null;
                            AppMethodBeat.i(23674);
                            NormalUserFooterPreference normalUserFooterPreference;
                            Intent intent;
                            a aVar2;
                            View inflate;
                            TextView textView;
                            final CheckBox checkBox;
                            switch (menuItem.getItemId()) {
                                case 1:
                                    NormalUserFooterPreference.this.fry.cF("hide_btn");
                                    NormalUserFooterPreference.this.fry.doNotify();
                                    a aVar3 = a.this;
                                    normalUserFooterPreference = NormalUserFooterPreference.this;
                                    aw.ZK();
                                    normalUserFooterPreference.ehM = com.tencent.mm.model.c.XM().aoO(NormalUserFooterPreference.this.ehM.field_username);
                                    if (com.tencent.mm.n.a.jh(NormalUserFooterPreference.this.ehM.field_type)) {
                                        intent = new Intent();
                                        intent.putExtra("Contact_Scene", NormalUserFooterPreference.this.gwP);
                                        intent.putExtra("Contact_User", NormalUserFooterPreference.this.ehM.field_username);
                                        intent.putExtra("Contact_RoomNickname", NormalUserFooterPreference.this.crP.getIntent().getStringExtra("Contact_RoomNickname"));
                                        intent.putExtra("contact_phone_number_list", NormalUserFooterPreference.this.ehM.dur);
                                        String str = "";
                                        if (!NormalUserFooterPreference.this.ehM.Of()) {
                                            String stringExtra = NormalUserFooterPreference.this.crP.getIntent().getStringExtra("Contact_Mobile_MD5");
                                            String stringExtra2 = NormalUserFooterPreference.this.crP.getIntent().getStringExtra("Contact_full_Mobile_MD5");
                                            if (bo.isNullOrNil(stringExtra) && bo.isNullOrNil(stringExtra2)) {
                                                if (!bo.isNullOrNil(NormalUserFooterPreference.this.ehM.field_username)) {
                                                    aVar = com.tencent.mm.plugin.account.a.getAddrUploadStg().vT(NormalUserFooterPreference.this.ehM.field_username);
                                                }
                                            } else if (!(bo.isNullOrNil(stringExtra) && bo.isNullOrNil(stringExtra2))) {
                                                aVar = com.tencent.mm.plugin.account.a.getAddrUploadStg().vW(stringExtra);
                                                if (aVar == null || bo.isNullOrNil(aVar.Aq())) {
                                                    aVar = com.tencent.mm.plugin.account.a.getAddrUploadStg().vW(stringExtra2);
                                                }
                                            }
                                            if (!(aVar == null || bo.isNullOrNil(aVar.Aq()))) {
                                                str = bo.nullAsNil(aVar.apG()).replace(" ", "");
                                            }
                                        }
                                        intent.putExtra("contact_phone_number_by_md5", str);
                                        com.tencent.mm.plugin.profile.b.gkE.m(intent, NormalUserFooterPreference.this.mContext);
                                        AppMethodBeat.o(23674);
                                        return;
                                    }
                                    aVar3.UU(NormalUserFooterPreference.this.ehM.field_username);
                                    AppMethodBeat.o(23674);
                                    return;
                                case 2:
                                    if (NormalUserFooterPreference.this.ehM.Oc()) {
                                        t.n(NormalUserFooterPreference.this.ehM);
                                        com.tencent.mm.ui.base.h.bQ(NormalUserFooterPreference.this.crP, NormalUserFooterPreference.this.crP.getString(R.string.b20));
                                    } else {
                                        t.m(NormalUserFooterPreference.this.ehM);
                                        com.tencent.mm.ui.base.h.bQ(NormalUserFooterPreference.this.crP, NormalUserFooterPreference.this.crP.getString(R.string.aw6));
                                    }
                                    normalUserFooterPreference = NormalUserFooterPreference.this;
                                    aw.ZK();
                                    normalUserFooterPreference.ehM = com.tencent.mm.model.c.XM().aoO(NormalUserFooterPreference.this.ehM.field_username);
                                    AppMethodBeat.o(23674);
                                    return;
                                case 3:
                                    Intent intent2 = new Intent();
                                    intent2.putExtra("sns_permission_userName", NormalUserFooterPreference.this.ehM.field_username);
                                    intent2.putExtra("sns_permission_anim", true);
                                    intent2.putExtra("sns_permission_block_scene", 1);
                                    com.tencent.mm.bp.d.b(NormalUserFooterPreference.this.crP, "sns", ".ui.SnsPermissionUI", intent2);
                                    AppMethodBeat.o(23674);
                                    return;
                                case 4:
                                    aVar2 = a.this;
                                    intent = new Intent();
                                    intent.putExtra("Select_Talker_Name", NormalUserFooterPreference.this.ehM.field_username);
                                    intent.putExtra("Select_block_List", NormalUserFooterPreference.this.ehM.field_username);
                                    intent.putExtra("Select_Conv_Type", 3);
                                    intent.putExtra("Select_Send_Card", true);
                                    intent.putExtra("mutil_select_is_ret", true);
                                    com.tencent.mm.plugin.profile.b.gkE.a(intent, NormalUserFooterPreference.this.crP);
                                    AppMethodBeat.o(23674);
                                    return;
                                case 5:
                                    if (NormalUserFooterPreference.this.ehM.Oa()) {
                                        a.a(a.this);
                                        AppMethodBeat.o(23674);
                                        return;
                                    }
                                    inflate = View.inflate(NormalUserFooterPreference.this.mContext, R.layout.ad4, null);
                                    inflate.setPadding(0, 0, 0, 0);
                                    textView = (TextView) inflate.findViewById(R.id.d8n);
                                    textView.setPadding(0, 0, 0, 0);
                                    textView.setText(ad.aox(NormalUserFooterPreference.this.ehM.field_username) ? R.string.ay3 : R.string.ay2);
                                    checkBox = (CheckBox) inflate.findViewById(R.id.d8o);
                                    checkBox.setChecked(false);
                                    textView = (TextView) inflate.findViewById(R.id.d8p);
                                    textView.setText(R.string.ay4);
                                    if (NormalUserFooterPreference.this.ehM.getSource() == 18) {
                                        checkBox.setVisibility(0);
                                        textView.setVisibility(0);
                                    } else {
                                        checkBox.setVisibility(8);
                                        textView.setVisibility(8);
                                    }
                                    com.tencent.mm.ui.base.h.a(NormalUserFooterPreference.this.mContext, true, NormalUserFooterPreference.this.mContext.getString(R.string.ay1), inflate, NormalUserFooterPreference.this.mContext.getString(R.string.s6), NormalUserFooterPreference.this.mContext.getString(R.string.or), new DialogInterface.OnClickListener() {
                                        public final void onClick(DialogInterface dialogInterface, int i) {
                                            AppMethodBeat.i(23672);
                                            a.b(a.this);
                                            if (NormalUserFooterPreference.this.ehM.getSource() == 18) {
                                                NormalUserFooterPreference.this.gwP = 9;
                                                if (checkBox.isChecked()) {
                                                    a.c(a.this);
                                                }
                                            }
                                            AppMethodBeat.o(23672);
                                        }
                                    }, null);
                                    AppMethodBeat.o(23674);
                                    return;
                                case 6:
                                    inflate = View.inflate(NormalUserFooterPreference.this.mContext, R.layout.ad4, null);
                                    inflate.setPadding(0, 0, 0, 0);
                                    textView = (TextView) inflate.findViewById(R.id.d8n);
                                    textView.setPadding(0, 0, 0, 0);
                                    textView.setText(t.mW(NormalUserFooterPreference.this.ehM.field_username) ? NormalUserFooterPreference.this.mContext.getString(R.string.b4w, new Object[]{NormalUserFooterPreference.this.ehM.Oj()}) : NormalUserFooterPreference.this.mContext.getString(R.string.b4u, new Object[]{NormalUserFooterPreference.this.ehM.Oj()}));
                                    checkBox = (CheckBox) inflate.findViewById(R.id.d8o);
                                    checkBox.setChecked(false);
                                    textView = (TextView) inflate.findViewById(R.id.d8p);
                                    textView.setText(R.string.ay4);
                                    if (NormalUserFooterPreference.this.ehM.getSource() == 18) {
                                        checkBox.setVisibility(0);
                                        textView.setVisibility(0);
                                    } else {
                                        checkBox.setVisibility(8);
                                        textView.setVisibility(8);
                                    }
                                    com.tencent.mm.ui.base.h.a(NormalUserFooterPreference.this.mContext, true, NormalUserFooterPreference.this.mContext.getString(R.string.avj), inflate, NormalUserFooterPreference.this.mContext.getString(R.string.p4), NormalUserFooterPreference.this.mContext.getString(R.string.or), new DialogInterface.OnClickListener() {
                                        public final void onClick(DialogInterface dialogInterface, int i) {
                                            AppMethodBeat.i(23673);
                                            a.this.cbr();
                                            if (NormalUserFooterPreference.this.ehM.getSource() == 18) {
                                                NormalUserFooterPreference.this.gwP = 9;
                                                if (checkBox.isChecked()) {
                                                    a.c(a.this);
                                                }
                                            }
                                            AppMethodBeat.o(23673);
                                        }
                                    }, null, (int) R.color.ei);
                                    AppMethodBeat.o(23674);
                                    return;
                                case 7:
                                    aVar2 = a.this;
                                    ab.d("MicroMsg.NormalUserFooterPreference", "dealAddShortcut, username = " + NormalUserFooterPreference.this.ehM.field_username);
                                    com.tencent.mm.plugin.base.model.b.aa(NormalUserFooterPreference.this.crP, NormalUserFooterPreference.this.ehM.field_username);
                                    al.n(new Runnable() {
                                        public final void run() {
                                            AppMethodBeat.i(23684);
                                            if (NormalUserFooterPreference.this.crP.isFinishing()) {
                                                AppMethodBeat.o(23684);
                                                return;
                                            }
                                            com.tencent.mm.plugin.base.model.b.Z(NormalUserFooterPreference.this.crP, NormalUserFooterPreference.this.ehM.field_username);
                                            com.tencent.mm.plugin.base.model.b.x(NormalUserFooterPreference.this.crP);
                                            AppMethodBeat.o(23684);
                                        }
                                    }, 1000);
                                    AppMethodBeat.o(23674);
                                    return;
                                case 9:
                                    a.c(a.this);
                                    break;
                            }
                            AppMethodBeat.o(23674);
                        }
                    };
                    dVar.rBl = new com.tencent.mm.ui.base.n.c() {
                        public final void a(com.tencent.mm.ui.base.l lVar) {
                            CharSequence string;
                            AppMethodBeat.i(23675);
                            com.tencent.mm.plugin.report.service.h.pYm.e(16055, Integer.valueOf(com.tencent.mm.plugin.profile.c.am(NormalUserFooterPreference.this.crP.getIntent())), Integer.valueOf(7));
                            if (ad.aox(NormalUserFooterPreference.this.ehM.field_username)) {
                                lVar.ax(1, R.string.b2o, R.raw.bottomsheet_icon_remarks);
                            } else {
                                lVar.ax(1, R.string.axw, R.raw.bottomsheet_icon_remarks);
                            }
                            if (NormalUserFooterPreference.this.ehM.Oc()) {
                                string = NormalUserFooterPreference.this.crP.getResources().getString(R.string.b1z);
                            } else {
                                string = NormalUserFooterPreference.this.crP.getResources().getString(R.string.aw5);
                            }
                            lVar.a(2, string, (int) R.raw.bottomsheet_icon_star);
                            if (!ad.aox(NormalUserFooterPreference.this.ehM.field_username)) {
                                lVar.ax(3, R.string.aya, R.raw.bottomsheet_icon_moment);
                            }
                            lVar.ax(4, R.string.azx, R.raw.bottomsheet_icon_transmit);
                            lVar.ax(9, R.string.a9n, R.raw.bottomsheet_icon_complain);
                            if (NormalUserFooterPreference.this.ehM.Oa()) {
                                string = NormalUserFooterPreference.this.crP.getString(R.string.ay6);
                            } else {
                                string = NormalUserFooterPreference.this.crP.getString(R.string.ay1);
                            }
                            lVar.a(5, string, (int) R.raw.bottomsheet_icon_blacklist);
                            if (!NormalUserFooterPreference.this.poy) {
                                lVar.ax(6, R.string.a6f, R.raw.bottomsheet_icon_del);
                            }
                            lVar.ax(7, R.string.atv, R.raw.bottomsheet_icon_desktop);
                            AppMethodBeat.o(23675);
                        }
                    };
                    dVar.cpD();
                    AppMethodBeat.o(23676);
                    return true;
                }
            });
        }

        /* Access modifiers changed, original: protected|final */
        public final void F(final boolean z, final boolean z2) {
            if (!z || !z2) {
                NormalUserFooterPreference.this.crP.addIconOptionMenu(0, R.drawable.uu, new OnMenuItemClickListener() {
                    public final boolean onMenuItemClick(MenuItem menuItem) {
                        AppMethodBeat.i(23688);
                        com.tencent.mm.ui.widget.a.d dVar = new com.tencent.mm.ui.widget.a.d(NormalUserFooterPreference.this.crP, 1, false);
                        dVar.rBm = new com.tencent.mm.ui.base.n.d() {
                            public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                                AppMethodBeat.i(23686);
                                switch (menuItem.getItemId()) {
                                    case 1:
                                        a.this.UU(NormalUserFooterPreference.this.ehM.field_username);
                                        AppMethodBeat.o(23686);
                                        return;
                                    case 5:
                                        int i2;
                                        Context context = NormalUserFooterPreference.this.mContext;
                                        Context context2 = NormalUserFooterPreference.this.mContext;
                                        if (ad.aox(NormalUserFooterPreference.this.ehM.field_username)) {
                                            i2 = R.string.ay3;
                                        } else {
                                            i2 = R.string.ay2;
                                        }
                                        com.tencent.mm.ui.base.h.a(context, context2.getString(i2), NormalUserFooterPreference.this.mContext.getString(R.string.ay1), new DialogInterface.OnClickListener() {
                                            public final void onClick(DialogInterface dialogInterface, int i) {
                                                AppMethodBeat.i(23685);
                                                a.b(a.this);
                                                AppMethodBeat.o(23685);
                                            }
                                        }, null);
                                        break;
                                    case 8:
                                        a.a(a.this);
                                        AppMethodBeat.o(23686);
                                        return;
                                }
                                AppMethodBeat.o(23686);
                            }
                        };
                        dVar.rBl = new com.tencent.mm.ui.base.n.c() {
                            public final void a(com.tencent.mm.ui.base.l lVar) {
                                AppMethodBeat.i(23687);
                                if (!z) {
                                    if (ad.aox(NormalUserFooterPreference.this.ehM.field_username)) {
                                        lVar.ax(1, R.string.b2o, R.raw.bottomsheet_icon_remarks);
                                    } else {
                                        lVar.ax(1, R.string.axw, R.raw.bottomsheet_icon_remarks);
                                    }
                                }
                                if (!z2) {
                                    if (NormalUserFooterPreference.this.ehM.Oa()) {
                                        lVar.ax(8, R.string.ay6, R.raw.bottomsheet_icon_blacklist);
                                        AppMethodBeat.o(23687);
                                        return;
                                    } else if (!t.mX(NormalUserFooterPreference.this.ehM.field_username)) {
                                        lVar.ax(5, R.string.ay1, R.raw.bottomsheet_icon_blacklist);
                                    }
                                }
                                AppMethodBeat.o(23687);
                            }
                        };
                        dVar.cpD();
                        AppMethodBeat.o(23688);
                        return true;
                    }
                });
            }
        }

        /* Access modifiers changed, original: protected */
        public void cbp() {
            if (NormalUserFooterPreference.this.pni) {
                NormalUserFooterPreference.this.crP.showOptionMenu(false);
            } else if (!r.Yz().equals(NormalUserFooterPreference.this.ehM.field_username)) {
                if (!com.tencent.mm.n.a.jh(NormalUserFooterPreference.this.ehM.field_type)) {
                    F(false, false);
                } else if (!t.nB(NormalUserFooterPreference.this.ehM.field_username)) {
                    cbo();
                }
            }
        }

        /* Access modifiers changed, original: final */
        public final void cbq() {
            this.pki = new com.tencent.mm.ui.widget.a.d(NormalUserFooterPreference.this.crP, 1, false);
            this.pki.rBl = new com.tencent.mm.ui.base.n.c() {
                public final void a(com.tencent.mm.ui.base.l lVar) {
                    AppMethodBeat.i(23679);
                    lVar.ax(2, R.string.qh, R.raw.sharemore_videovoip);
                    lVar.ax(1, R.string.qj, R.raw.sharemore_voipvoice);
                    AppMethodBeat.o(23679);
                }
            };
            this.pki.rBm = new com.tencent.mm.ui.base.n.d() {
                public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                    AppMethodBeat.i(23680);
                    switch (menuItem.getItemId()) {
                        case 1:
                            NormalUserFooterPreference.this.cbl();
                            AppMethodBeat.o(23680);
                            return;
                        case 2:
                            NormalUserFooterPreference.this.cbm();
                            break;
                    }
                    AppMethodBeat.o(23680);
                }
            };
            this.pki.cpD();
        }

        /* Access modifiers changed, original: final */
        public final void UU(String str) {
            if (bo.isNullOrNil(str)) {
                ab.w("MicroMsg.NormalUserFooterPreference", "mod stranger remark, username is null");
                return;
            }
            Intent intent = new Intent();
            intent.putExtra("Contact_Scene", NormalUserFooterPreference.this.gwP);
            intent.putExtra("Contact_mode_name_type", 0);
            intent.putExtra("Contact_ModStrangerRemark", true);
            intent.putExtra("Contact_User", NormalUserFooterPreference.this.ehM.field_username);
            intent.putExtra("Contact_Nick", NormalUserFooterPreference.this.ehM.field_nickname);
            intent.putExtra("Contact_RemarkName", NormalUserFooterPreference.this.ehM.field_conRemark);
            com.tencent.mm.plugin.profile.b.gkE.n(intent, NormalUserFooterPreference.this.mContext);
        }

        /* Access modifiers changed, original: protected|final */
        public final void cbr() {
            com.tencent.mm.plugin.report.service.h.pYm.e(14553, Integer.valueOf(2), Integer.valueOf(2), NormalUserFooterPreference.this.ehM.field_username);
            final String str = NormalUserFooterPreference.this.ehM.field_username;
            if (t.mW(str)) {
                NormalUserFooterPreference.this.ehM.NC();
                aw.ZK();
                com.tencent.mm.model.c.XL().c(new com.tencent.mm.az.c(str));
                aw.ZK();
                com.tencent.mm.model.c.XM().aoU(str);
                aw.ZK();
                com.tencent.mm.model.c.XV().og(str);
                return;
            }
            String str2;
            this.isDeleteCancel = false;
            Context context = NormalUserFooterPreference.this.mContext;
            NormalUserFooterPreference.this.mContext.getString(R.string.tz);
            final p b = com.tencent.mm.ui.base.h.b(context, NormalUserFooterPreference.this.mContext.getString(R.string.un), true, new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                    a.this.isDeleteCancel = true;
                }
            });
            if (this.isDeleteCancel) {
                str2 = null;
            } else {
                str2 = com.tencent.mm.pluginsdk.wallet.e.akq(NormalUserFooterPreference.this.ehM.field_username);
            }
            if (bo.isNullOrNil(str2)) {
                zq(str);
                return;
            }
            b.dismiss();
            com.tencent.mm.ui.base.h.a(NormalUserFooterPreference.this.mContext, false, NormalUserFooterPreference.this.mContext.getString(R.string.fe9, new Object[]{str2}), null, NormalUserFooterPreference.this.mContext.getString(R.string.c9y), NormalUserFooterPreference.this.mContext.getString(R.string.b57), new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(23681);
                    com.tencent.mm.plugin.report.service.h.pYm.e(14553, Integer.valueOf(2), Integer.valueOf(4), NormalUserFooterPreference.this.ehM.field_username);
                    a.this.isDeleteCancel = true;
                    Intent intent = new Intent();
                    intent.putExtra("Chat_User", NormalUserFooterPreference.this.ehM.field_username);
                    intent.addFlags(67108864);
                    com.tencent.mm.bp.d.f(NormalUserFooterPreference.this.mContext, ".ui.chatting.ChattingUI", intent);
                    AppMethodBeat.o(23681);
                }
            }, new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(23682);
                    com.tencent.mm.plugin.report.service.h.pYm.e(14553, Integer.valueOf(2), Integer.valueOf(3), NormalUserFooterPreference.this.ehM.field_username);
                    b.show();
                    a.this.isDeleteCancel = false;
                    a.this.zq(str);
                    AppMethodBeat.o(23682);
                }
            }, -1, R.color.ei);
        }

        /* Access modifiers changed, original: final */
        public final void zq(String str) {
            NormalUserFooterPreference.this.ehM.NC();
            if (ad.aox(str)) {
                ((com.tencent.mm.openim.a.a) com.tencent.mm.kernel.g.K(com.tencent.mm.openim.a.a.class)).ve(str);
                com.tencent.mm.model.ao.a.flu.os(str);
            } else {
                aw.ZK();
                com.tencent.mm.model.c.XL().c(new com.tencent.mm.az.c(str));
            }
            bf.a(str, new com.tencent.mm.model.bf.a() {
                public final boolean JU() {
                    return a.this.isDeleteCancel;
                }

                public final void JV() {
                    AppMethodBeat.i(23683);
                    if (NormalUserFooterPreference.this.ehJ != null) {
                        NormalUserFooterPreference.this.ehJ.dismiss();
                    }
                    AppMethodBeat.o(23683);
                }
            });
            aw.ZK();
            com.tencent.mm.model.c.XM().b(str, NormalUserFooterPreference.this.ehM);
            aw.ZK();
            com.tencent.mm.model.c.XR().aoX(str);
            com.tencent.mm.bi.c.e(0, str);
            com.tencent.mm.bi.c.e(0, NormalUserFooterPreference.this.ehM.field_encryptUsername);
            switch (NormalUserFooterPreference.this.gwP) {
                case 10:
                    w.J(NormalUserFooterPreference.this.mContext, str);
                    break;
                case 12:
                    ao wj = com.tencent.mm.plugin.account.a.getQQListStg().wj(str);
                    if (wj != null) {
                        wj.gwD = 1;
                        com.tencent.mm.plugin.account.a.getQQListStg().a(wj.gwC, wj);
                        break;
                    }
                    break;
                case 13:
                    com.tencent.mm.plugin.account.friend.a.a vT = com.tencent.mm.plugin.account.a.getAddrUploadStg().vT(str);
                    if (!(vT == null || bo.isNullOrNil(vT.guM))) {
                        vT.status = 1;
                        com.tencent.mm.plugin.account.a.getAddrUploadStg().a(vT.Aq(), vT);
                    }
                    w.J(NormalUserFooterPreference.this.mContext, str);
                    break;
                case 31:
                    com.tencent.mm.plugin.account.friend.a.g wb = com.tencent.mm.plugin.account.a.getFacebookFrdStg().wb(str);
                    if (wb != null) {
                        wb.status = 100;
                        com.tencent.mm.plugin.account.a.getFacebookFrdStg().a(wb);
                        break;
                    }
                    break;
                case aa.CTRL_INDEX /*58*/:
                case au.CTRL_INDEX /*59*/:
                case 60:
                    com.tencent.mm.plugin.account.a.getGoogleFriendStorage().ak(str, 2);
                    break;
            }
            if (NormalUserFooterPreference.this.gwP == 9) {
                ab.i("MicroMsg.NormalUserFooterPreference", "add scene unkown, check the contact getsource: " + NormalUserFooterPreference.this.ehM.getSource());
                switch (NormalUserFooterPreference.this.ehM.getSource()) {
                    case 10:
                    case 13:
                        ab.i("MicroMsg.NormalUserFooterPreference", "delete the system contact info added by wechat");
                        w.J(NormalUserFooterPreference.this.mContext, str);
                        break;
                }
            }
            if (NormalUserFooterPreference.this.pmV == 0) {
                Intent intent = new Intent();
                intent.addFlags(67108864);
                com.tencent.mm.plugin.profile.b.gkE.p(intent, NormalUserFooterPreference.this.mContext);
                return;
            }
            NormalUserFooterPreference.this.crP.setResult(-1, NormalUserFooterPreference.this.crP.getIntent().putExtra("_delete_ok_", true));
            ((Activity) NormalUserFooterPreference.this.mContext).finish();
        }

        static /* synthetic */ void a(a aVar) {
            t.j(NormalUserFooterPreference.this.ehM);
            NormalUserFooterPreference.this.ehM.NE();
            if (NormalUserFooterPreference.this.lyb) {
                NormalUserFooterPreference.this.poO.setVisibility(8);
                aVar.cbn();
            }
        }

        static /* synthetic */ void b(a aVar) {
            t.i(NormalUserFooterPreference.this.ehM);
            NormalUserFooterPreference.this.ehM.ND();
            if (NormalUserFooterPreference.this.lyb) {
                NormalUserFooterPreference.this.poO.setVisibility(0);
                aVar.cbn();
            }
        }

        static /* synthetic */ void c(a aVar) {
            int i = 7;
            Intent intent = new Intent();
            switch (NormalUserFooterPreference.this.gwP) {
                case 1:
                case 2:
                case 3:
                case 12:
                case 13:
                case aa.CTRL_INDEX /*58*/:
                case au.CTRL_INDEX /*59*/:
                case 60:
                    intent.putExtra("k_outside_expose_proof_item_list", com.tencent.mm.bi.a.z(45, NormalUserFooterPreference.this.ehM.field_username));
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
                    intent.putStringArrayListExtra("k_outside_expose_proof_item_list", com.tencent.mm.bi.a.tS(NormalUserFooterPreference.this.ehM.field_username));
                    break;
                case 22:
                case 23:
                case 24:
                case 26:
                case 27:
                case com.tencent.view.d.MIC_BASE_CHANNELSHARPEN /*28*/:
                case 29:
                    i = NormalUserFooterPreference.this.pkC ? 4 : 3;
                    intent.putStringArrayListExtra("k_outside_expose_proof_item_list", com.tencent.mm.bi.a.tT(NormalUserFooterPreference.this.ehM.field_username));
                    break;
                case 25:
                    i = NormalUserFooterPreference.this.pkC ? 6 : 5;
                    if (!NormalUserFooterPreference.this.pkC) {
                        String str;
                        String str2 = "k_outside_expose_proof_item_list";
                        if (bo.isNullOrNil(NormalUserFooterPreference.this.ehM.xXc)) {
                            str = NormalUserFooterPreference.this.ehM.field_username;
                        } else {
                            str = NormalUserFooterPreference.this.ehM.xXc;
                        }
                        intent.putExtra(str2, com.tencent.mm.bi.a.tU(str));
                        break;
                    }
                    intent.putExtra("k_outside_expose_proof_item_list", com.tencent.mm.bi.a.z(i, NormalUserFooterPreference.this.ehM.field_username));
                    break;
                case 30:
                    intent.putStringArrayListExtra("k_outside_expose_proof_item_list", com.tencent.mm.bi.a.z(7, NormalUserFooterPreference.this.ehM.field_username));
                    break;
                default:
                    i = 999;
                    break;
            }
            intent.putExtra("k_username", NormalUserFooterPreference.this.ehM.field_username);
            intent.putExtra("showShare", false);
            intent.putExtra("rawUrl", String.format("https://weixin110.qq.com/security/readtemplate?t=weixin_report/w_type&scene=%d#wechat_redirect", new Object[]{Integer.valueOf(i)}));
            com.tencent.mm.bp.d.b(NormalUserFooterPreference.this.crP, "webview", ".ui.tools.WebViewUI", intent);
        }
    }

    class b extends c {
        public b() {
            super();
        }

        /* Access modifiers changed, original: protected|final */
        public final void cbp() {
            AppMethodBeat.i(23697);
            if (NormalUserFooterPreference.this.ehM == null) {
                ab.e("MicroMsg.NormalUserFooterPreference", "contact is null in NearByFriendHandler");
                AppMethodBeat.o(23697);
            } else if (com.tencent.mm.n.a.jh(NormalUserFooterPreference.this.ehM.field_type) && (!com.tencent.mm.n.a.jh(NormalUserFooterPreference.this.ehM.field_type) || !ad.mR(NormalUserFooterPreference.this.ehM.field_username))) {
                cbo();
                AppMethodBeat.o(23697);
            } else if (ad.mR(NormalUserFooterPreference.this.ehM.field_username)) {
                F(true, true);
                AppMethodBeat.o(23697);
            } else {
                F(false, true);
                AppMethodBeat.o(23697);
            }
        }

        /* Access modifiers changed, original: protected|final */
        /* JADX WARNING: Removed duplicated region for block: B:10:0x0082  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void cbn() {
            AppMethodBeat.i(23698);
            NormalUserFooterPreference.this.poA.setVisibility(8);
            if (!com.tencent.mm.n.a.jh(NormalUserFooterPreference.this.ehM.field_type) || (com.tencent.mm.n.a.jh(NormalUserFooterPreference.this.ehM.field_type) && ad.mR(NormalUserFooterPreference.this.ehM.field_username))) {
                NormalUserFooterPreference.this.poH.setVisibility(0);
                NormalUserFooterPreference.this.oik.setVisibility(8);
                NormalUserFooterPreference.this.poN.setVisibility(8);
            } else {
                NormalUserFooterPreference.this.poH.setVisibility(8);
                NormalUserFooterPreference.this.oik.setVisibility(0);
                if (!(NormalUserFooterPreference.this.cbk() || NormalUserFooterPreference.this.ehM.field_username.equals(r.Yz()))) {
                    NormalUserFooterPreference.this.poL.setVisibility(0);
                    NormalUserFooterPreference.this.poK.setVisibility(8);
                    NormalUserFooterPreference.this.poM.setVisibility(8);
                    NormalUserFooterPreference.this.poO.setVisibility(8);
                    if (NormalUserFooterPreference.this.pox) {
                        NormalUserFooterPreference.this.poH.setVisibility(8);
                        NormalUserFooterPreference.this.poK.setVisibility(0);
                        NormalUserFooterPreference.this.poK.setOnClickListener(new OnClickListener() {
                            public final void onClick(View view) {
                                AppMethodBeat.i(23695);
                                b.this.cbs();
                                AppMethodBeat.o(23695);
                            }
                        });
                    }
                    NormalUserFooterPreference.this.poJ.setOnClickListener(new OnClickListener() {
                        public final void onClick(View view) {
                            AppMethodBeat.i(23696);
                            Intent intent;
                            if (NormalUserFooterPreference.this.poy && com.tencent.mm.bn.a.dgL()) {
                                intent = new Intent();
                                intent.putExtra("Chat_User", NormalUserFooterPreference.this.ehM.field_encryptUsername);
                                intent.putExtra("lbs_mode", true);
                                intent.putExtra("lbs_ticket", NormalUserFooterPreference.this.jEs);
                                intent.putExtra("add_scene", NormalUserFooterPreference.this.gwP);
                                com.tencent.mm.plugin.profile.b.gkE.d(intent, NormalUserFooterPreference.this.crP);
                                AppMethodBeat.o(23696);
                                return;
                            }
                            intent = new Intent();
                            intent.putExtra("Contact_User", NormalUserFooterPreference.this.ehM.field_username);
                            intent.putExtra("Contact_Scene", NormalUserFooterPreference.this.gwP);
                            intent.putExtra(com.tencent.mm.ui.e.b.yfT, NormalUserFooterPreference.this.ehM.dus);
                            com.tencent.mm.plugin.profile.b.gkE.a(intent, NormalUserFooterPreference.this.mContext);
                            AppMethodBeat.o(23696);
                        }
                    });
                    AppMethodBeat.o(23698);
                }
            }
            NormalUserFooterPreference.this.poL.setVisibility(8);
            NormalUserFooterPreference.this.poK.setVisibility(8);
            NormalUserFooterPreference.this.poM.setVisibility(8);
            NormalUserFooterPreference.this.poO.setVisibility(8);
            if (NormalUserFooterPreference.this.pox) {
            }
            NormalUserFooterPreference.this.poJ.setOnClickListener(/* anonymous class already generated */);
            AppMethodBeat.o(23698);
        }
    }

    public NormalUserFooterPreference(Context context) {
        super(context);
        AppMethodBeat.i(23733);
        this.crP = (MMActivity) context;
        init();
        AppMethodBeat.o(23733);
    }

    public NormalUserFooterPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(23734);
        this.crP = (MMActivity) context;
        init();
        AppMethodBeat.o(23734);
    }

    public NormalUserFooterPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(23735);
        this.crP = (MMActivity) context;
        init();
        AppMethodBeat.o(23735);
    }

    private void init() {
        this.lyb = false;
        this.poz = null;
    }

    private void initView() {
        AppMethodBeat.i(23736);
        if (!this.lyb || this.ehM == null) {
            ab.w("MicroMsg.NormalUserFooterPreference", "iniView : bindView = " + this.lyb + " contact = " + this.ehM);
            if (this.poz != null) {
                try {
                    this.poz.cbp();
                    AppMethodBeat.o(23736);
                    return;
                } catch (Throwable th) {
                }
            }
            AppMethodBeat.o(23736);
            return;
        }
        if (this.poz != null) {
            this.poz.Xy();
        }
        cbk();
        AppMethodBeat.o(23736);
    }

    public final void onBindView(View view) {
        AppMethodBeat.i(23737);
        ab.d("MicroMsg.NormalUserFooterPreference", "on bindView " + view.toString());
        this.poA = view.findViewById(R.id.b1s);
        this.poB = (Button) view.findViewById(R.id.b1t);
        this.poC = (Button) view.findViewById(R.id.b20);
        this.poF = (Button) view.findViewById(R.id.b1w);
        this.poG = (TextView) view.findViewById(R.id.b27);
        this.poE = view.findViewById(R.id.b1v);
        this.poD = (Button) view.findViewById(R.id.b1u);
        this.poK = (Button) view.findViewById(R.id.b21);
        this.poH = view.findViewById(R.id.b1x);
        this.poI = (Button) view.findViewById(R.id.b1z);
        this.poJ = (Button) view.findViewById(R.id.b1y);
        this.oik = (Button) view.findViewById(R.id.b22);
        this.poN = (Button) view.findViewById(R.id.b25);
        this.poL = (Button) view.findViewById(R.id.b23);
        this.poM = (Button) view.findViewById(R.id.b24);
        this.poO = (TextView) view.findViewById(R.id.b26);
        this.lyb = true;
        initView();
        super.onBindView(view);
        if (this.crP.getIntent().getBooleanExtra("Accept_NewFriend_FromOutside", false) && this.poB != null) {
            this.poB.performClick();
        }
        AppMethodBeat.o(23737);
    }

    public final boolean a(ad adVar, String str, boolean z, boolean z2, boolean z3, int i, int i2, boolean z4, boolean z5, long j, String str2) {
        boolean z6;
        AppMethodBeat.i(23738);
        biV();
        if (adVar != null) {
            z6 = true;
        } else {
            z6 = false;
        }
        Assert.assertTrue(z6);
        Assert.assertTrue(bo.nullAsNil(adVar.field_username).length() > 0);
        if (ad.aoC(r.Yz()).equals(adVar.field_username)) {
            AppMethodBeat.o(23738);
            return false;
        }
        this.ehM = adVar;
        this.mGZ = str;
        this.pli = z;
        this.gwP = i;
        this.pmV = i2;
        this.pow = bo.a(Boolean.valueOf(t.mW(adVar.field_username)), false);
        this.pkC = z4;
        this.pov = z5;
        this.pnz = j;
        this.pnd = str2;
        this.poQ = false;
        this.pni = adVar.field_deleteFlag == 1;
        this.poP = this.crP.getIntent().getBooleanExtra("Contact_AlwaysShowSnsPreBtn", false);
        this.pmD = this.crP.getIntent().getIntExtra("add_more_friend_search_scene", 0);
        this.pox = this.crP.getIntent().getBooleanExtra("Contact_IsLbsChattingProfile", false);
        this.poy = this.crP.getIntent().getBooleanExtra("Contact_IsLbsGotoChatting", false);
        this.jEs = this.crP.getIntent().getStringExtra("lbs_ticket");
        if (!r.mG(adVar.field_username)) {
            aw.ZK();
            if (!com.tencent.mm.model.c.XU().has(adVar.field_username)) {
                if (ad.aou(adVar.field_username)) {
                    this.poz = new h();
                } else if (t.nl(adVar.field_username)) {
                    this.poz = new d();
                } else if (t.mW(adVar.field_username)) {
                    this.poz = new g();
                } else if (ad.aov(adVar.field_username)) {
                    this.poz = new f();
                } else if (com.tencent.mm.n.a.jh(adVar.field_type) && !ad.mR(adVar.field_username)) {
                    this.poz = new c();
                    this.poQ = true;
                } else if (z2) {
                    this.poz = new j();
                    this.poQ = true;
                } else if (z3 || ad.mR(adVar.field_username)) {
                    this.poz = new b();
                } else {
                    this.poz = new c();
                    this.poQ = true;
                }
                initView();
                AppMethodBeat.o(23738);
                return true;
            }
        }
        this.poz = new c();
        this.poQ = true;
        initView();
        AppMethodBeat.o(23738);
        return true;
    }

    public final boolean cbk() {
        AppMethodBeat.i(23739);
        if (this.poP && com.tencent.mm.n.a.jh(this.ehM.field_type)) {
            this.poN.setVisibility(0);
            AppMethodBeat.o(23739);
            return true;
        }
        this.poN.setVisibility(8);
        AppMethodBeat.o(23739);
        return false;
    }

    public final boolean biV() {
        AppMethodBeat.i(23740);
        if (this.poz != null) {
            this.poz.onDetach();
        }
        this.fry.removeAll();
        if (this.ehJ != null) {
            this.ehJ.dismiss();
            this.ehJ = null;
        }
        AppMethodBeat.o(23740);
        return true;
    }

    public final void a(String str, com.tencent.mm.sdk.e.m mVar) {
        AppMethodBeat.i(23741);
        if (bo.nullAsNil(str).length() <= 0) {
            AppMethodBeat.o(23741);
            return;
        }
        if (this.ehM != null && (str.equals(this.ehM.field_username) || str.equals(this.ehM.field_encryptUsername))) {
            aw.ZK();
            this.ehM = com.tencent.mm.model.c.XM().aoO(this.ehM.field_username);
            al.d(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(23671);
                    NormalUserFooterPreference.this.cbk();
                    AppMethodBeat.o(23671);
                }
            });
        }
        AppMethodBeat.o(23741);
    }

    public final void cbl() {
        AppMethodBeat.i(23742);
        ab.i("MicroMsg.NormalUserFooterPreference", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", Boolean.valueOf(com.tencent.mm.pluginsdk.permission.b.a(this.crP, "android.permission.RECORD_AUDIO", 82, "", "")), bo.dpG(), this.crP);
        if (com.tencent.mm.pluginsdk.permission.b.a(this.crP, "android.permission.RECORD_AUDIO", 82, "", "")) {
            ui uiVar = new ui();
            uiVar.cQx.cAd = 5;
            uiVar.cQx.talker = this.ehM.field_username;
            uiVar.cQx.context = this.crP;
            uiVar.cQx.cQs = 4;
            com.tencent.mm.sdk.b.a.xxA.m(uiVar);
            AppMethodBeat.o(23742);
            return;
        }
        AppMethodBeat.o(23742);
    }

    public final void cbm() {
        AppMethodBeat.i(23743);
        ab.i("MicroMsg.NormalUserFooterPreference", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", Boolean.valueOf(com.tencent.mm.pluginsdk.permission.b.a(this.crP, "android.permission.CAMERA", 19, "", "")), bo.dpG(), this.crP);
        if (com.tencent.mm.pluginsdk.permission.b.a(this.crP, "android.permission.CAMERA", 19, "", "")) {
            ab.i("MicroMsg.NormalUserFooterPreference", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", Boolean.valueOf(com.tencent.mm.pluginsdk.permission.b.a(this.crP, "android.permission.RECORD_AUDIO", 19, "", "")), bo.dpG(), this.crP);
            if (com.tencent.mm.pluginsdk.permission.b.a(this.crP, "android.permission.RECORD_AUDIO", 19, "", "")) {
                ui uiVar = new ui();
                uiVar.cQx.cAd = 5;
                uiVar.cQx.talker = this.ehM.field_username;
                uiVar.cQx.context = this.crP;
                uiVar.cQx.cQs = 2;
                com.tencent.mm.sdk.b.a.xxA.m(uiVar);
                AppMethodBeat.o(23743);
                return;
            }
            AppMethodBeat.o(23743);
            return;
        }
        AppMethodBeat.o(23743);
    }
}
