package com.tencent.p177mm.plugin.record.p493ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C1854s;
import com.tencent.p177mm.p230g.p231a.C37721gh;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C40671n.C36073c;
import com.tencent.p177mm.p612ui.base.C40671n.C5279d;
import com.tencent.p177mm.p612ui.base.C44273l;
import com.tencent.p177mm.p612ui.base.C44275p;
import com.tencent.p177mm.p612ui.widget.p633a.C36356d;
import com.tencent.p177mm.p612ui.widget.snackbar.C5670b;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.fav.p407a.C27966g;
import com.tencent.p177mm.plugin.fav.p407a.C27968h;
import com.tencent.p177mm.plugin.fav.p407a.C39037b;
import com.tencent.p177mm.plugin.fav.p407a.C7604ae;
import com.tencent.p177mm.plugin.fav.p410ui.C3105g;
import com.tencent.p177mm.plugin.record.p492b.C21601g;
import com.tencent.p177mm.plugin.record.p492b.C43436n;
import com.tencent.p177mm.protocal.protobuf.aar;
import com.tencent.p177mm.protocal.protobuf.abl;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p603e.C4935m;
import com.tencent.p177mm.sdk.p603e.C7296k.C4931a;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.record.ui.FavRecordDetailUI */
public class FavRecordDetailUI extends RecordMsgBaseUI {
    private boolean cHc = true;
    private C4931a mgG = new C248191();
    private C27966g mjP;
    private long pKf = -1;
    private boolean pKg = true;
    private boolean pKh = false;

    /* renamed from: com.tencent.mm.plugin.record.ui.FavRecordDetailUI$2 */
    class C248182 implements OnMenuItemClickListener {

        /* renamed from: com.tencent.mm.plugin.record.ui.FavRecordDetailUI$2$1 */
        class C129881 implements C36073c {
            C129881() {
            }

            /* renamed from: a */
            public final void mo5746a(C44273l c44273l) {
                AppMethodBeat.m2504i(24203);
                C4990ab.m7417i("MicroMsg.FavRecordDetailUI", "favItemInfo: id %d, status %d", Integer.valueOf(FavRecordDetailUI.this.mjP.field_id), Integer.valueOf(FavRecordDetailUI.this.mjP.field_itemStatus));
                if (FavRecordDetailUI.this.mjP.field_id > 0 && !FavRecordDetailUI.this.mjP.buw() && !FavRecordDetailUI.this.mjP.bux() && FavRecordDetailUI.this.pKg) {
                    c44273l.mo70068e(0, FavRecordDetailUI.this.getString(C25738R.string.bri));
                }
                c44273l.mo70068e(5, FavRecordDetailUI.this.getString(C25738R.string.br7));
                c44273l.mo70068e(3, FavRecordDetailUI.this.getString(C25738R.string.bo8));
                c44273l.mo70068e(2, FavRecordDetailUI.this.getString(C25738R.string.f9088p4));
                AppMethodBeat.m2505o(24203);
            }
        }

        /* renamed from: com.tencent.mm.plugin.record.ui.FavRecordDetailUI$2$2 */
        class C129892 implements C5279d {

            /* renamed from: com.tencent.mm.plugin.record.ui.FavRecordDetailUI$2$2$1 */
            class C129901 implements OnClickListener {
                C129901() {
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.m2504i(24205);
                    final C44275p b = C30379h.m48458b(FavRecordDetailUI.this.mController.ylL, FavRecordDetailUI.this.getString(C25738R.string.f9089p5), false, null);
                    C37721gh c37721gh = new C37721gh();
                    c37721gh.cAH.type = 12;
                    c37721gh.cAH.cvv = FavRecordDetailUI.this.pKf;
                    c37721gh.cAH.cAM = new Runnable() {
                        public final void run() {
                            AppMethodBeat.m2504i(24204);
                            b.dismiss();
                            C4990ab.m7411d("MicroMsg.FavRecordDetailUI", "do del, local id %d", Long.valueOf(FavRecordDetailUI.this.pKf));
                            FavRecordDetailUI.this.finish();
                            AppMethodBeat.m2505o(24204);
                        }
                    };
                    C4879a.xxA.mo10055m(c37721gh);
                    AppMethodBeat.m2505o(24205);
                }
            }

            C129892() {
            }

            public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                AppMethodBeat.m2504i(24206);
                Intent intent;
                switch (menuItem.getItemId()) {
                    case 0:
                        intent = new Intent();
                        intent.putExtra("Select_Conv_Type", 3);
                        intent.putExtra("scene_from", 1);
                        intent.putExtra("mutil_select_is_ret", true);
                        intent.putExtra("select_fav_local_id", FavRecordDetailUI.this.mjP.field_localId);
                        C25985d.m41466b(FavRecordDetailUI.this, ".ui.transmit.SelectConversationUI", intent, 4097);
                        C27968h.m44531j(FavRecordDetailUI.this.mjP.field_localId, 1, 0);
                        AppMethodBeat.m2505o(24206);
                        return;
                    case 2:
                        C30379h.m48440a(FavRecordDetailUI.this.mController.ylL, FavRecordDetailUI.this.getString(C25738R.string.f9089p5), "", new C129901(), null);
                        AppMethodBeat.m2505o(24206);
                        return;
                    case 3:
                        intent = new Intent();
                        intent.putExtra("key_fav_scene", 2);
                        intent.putExtra("key_fav_item_id", FavRecordDetailUI.this.pKf);
                        C39037b.m66371b(FavRecordDetailUI.this.mController.ylL, ".ui.FavTagEditUI", intent);
                        AppMethodBeat.m2505o(24206);
                        return;
                    case 4:
                        intent = new Intent();
                        intent.putExtra("key_fav_scene", 1);
                        intent.putExtra("key_fav_item_id", FavRecordDetailUI.this.mjP.field_localId);
                        C39037b.m66371b(FavRecordDetailUI.this.mController.ylL, ".ui.FavTagEditUI", intent);
                        AppMethodBeat.m2505o(24206);
                        return;
                    case 5:
                        C3105g.m5347a(FavRecordDetailUI.this, FavRecordDetailUI.this.pKf, FavRecordDetailUI.this.mlz);
                        break;
                }
                AppMethodBeat.m2505o(24206);
            }
        }

        C248182() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(24207);
            C36356d c36356d = new C36356d(FavRecordDetailUI.this.mController.ylL, 1, false);
            c36356d.rBl = new C129881();
            c36356d.rBm = new C129892();
            c36356d.cpD();
            AppMethodBeat.m2505o(24207);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.record.ui.FavRecordDetailUI$1 */
    class C248191 implements C4931a {
        C248191() {
        }

        /* renamed from: a */
        public final void mo5248a(String str, C4935m c4935m) {
            AppMethodBeat.m2504i(24202);
            if (c4935m == null) {
                AppMethodBeat.m2505o(24202);
            } else if (c4935m.obj == null) {
                AppMethodBeat.m2505o(24202);
            } else {
                long longValue = ((Long) c4935m.obj).longValue();
                if (longValue < 0) {
                    AppMethodBeat.m2505o(24202);
                    return;
                }
                if (FavRecordDetailUI.this.pKf == longValue) {
                    C27966g jD = C21601g.m33080jD(FavRecordDetailUI.this.pKf);
                    final C13017b c13017b = new C13017b();
                    c13017b.mnW = jD;
                    if (!(jD == null || jD.field_favProto == null)) {
                        c13017b.pJZ = jD.field_favProto.wiv;
                        C5004al.m7441d(new Runnable() {
                            public final void run() {
                                AppMethodBeat.m2504i(24201);
                                FavRecordDetailUI.this.pKw.mo8328a(c13017b);
                                AppMethodBeat.m2505o(24201);
                            }
                        });
                    }
                }
                AppMethodBeat.m2505o(24202);
            }
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public FavRecordDetailUI() {
        AppMethodBeat.m2504i(24210);
        AppMethodBeat.m2505o(24210);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(24211);
        super.onCreate(bundle);
        AppMethodBeat.m2505o(24211);
    }

    /* Access modifiers changed, original: protected|final */
    public final void ceI() {
        AppMethodBeat.m2504i(24212);
        this.pKf = getIntent().getLongExtra("key_detail_info_id", -1);
        this.cHc = getIntent().getBooleanExtra("show_share", true);
        this.mjP = C21601g.m33080jD(this.pKf);
        if (this.mjP == null) {
            finish();
            AppMethodBeat.m2505o(24212);
            return;
        }
        mo54744F(this.mjP);
        C13017b c13017b = new C13017b();
        c13017b.mnW = this.mjP;
        c13017b.pJZ = this.mjP.field_favProto.wiv;
        List<aar> list = c13017b.pJZ;
        if (list == null) {
            this.pKg = false;
        } else if (list.size() == 0) {
            this.pKg = false;
        } else {
            for (aar aar : list) {
                if (aar.whh != 0) {
                    this.pKg = false;
                    break;
                }
            }
            this.pKg = true;
        }
        super.ceI();
        this.pKw.mo8328a(c13017b);
        final List list2 = c13017b.pJZ;
        if (list2 != null) {
            C7305d.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(24209);
                    if (list2 == null) {
                        AppMethodBeat.m2505o(24209);
                        return;
                    }
                    C4990ab.m7416i("MicroMsg.FavRecordDetailUI", "start calc");
                    long j = 0;
                    int i = 0;
                    int i2 = 0;
                    int i3 = 0;
                    int i4 = 0;
                    for (aar aar : list2) {
                        if (!(aar == null || FavRecordDetailUI.this.pKh)) {
                            switch (aar.dataType) {
                                case 1:
                                    i4++;
                                    j = ((long) aar.desc.getBytes().length) + j;
                                    break;
                                case 2:
                                    i3++;
                                    break;
                                case 4:
                                case 15:
                                    i2++;
                                    break;
                                default:
                                    i++;
                                    break;
                            }
                        }
                    }
                    FavRecordDetailUI.this.mlz.meU = String.format("%s:%s:%s:%s:%s", new Object[]{Integer.valueOf(i4), Long.valueOf(j), Integer.valueOf(i3), Integer.valueOf(i2), Integer.valueOf(i)});
                    C4990ab.m7419v("MicroMsg.FavRecordDetailUI", "start calc finish %s", r0);
                    AppMethodBeat.m2505o(24209);
                }
            }, "calc_fav_record_info");
        }
        ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavItemInfoStorage().mo10116c(this.mgG);
        ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavCdnStorage().mo15157a(((C39579d) this.pKw).pKb);
        AppMethodBeat.m2505o(24212);
    }

    /* Access modifiers changed, original: protected|final */
    public final C3706h ceJ() {
        AppMethodBeat.m2504i(24213);
        C39579d c39579d = new C39579d(this, new C28845c(this));
        AppMethodBeat.m2505o(24213);
        return c39579d;
    }

    public void onResume() {
        AppMethodBeat.m2504i(24214);
        super.onResume();
        C13017b c13017b = (C13017b) ((C39579d) this.pKw).pKs;
        if (c13017b.mnW != null) {
            C27966g jD = C21601g.m33080jD(c13017b.mnW.field_localId);
            if (jD == null || jD.field_favProto == null) {
                AppMethodBeat.m2505o(24214);
                return;
            }
            Object obj;
            LinkedList linkedList = jD.field_favProto.wiv;
            for (aar contains : c13017b.pJZ) {
                if (!linkedList.contains(contains)) {
                    obj = 1;
                    break;
                }
            }
            obj = null;
            if (obj != null) {
                c13017b = new C13017b();
                c13017b.mnW = jD;
                c13017b.pJZ = jD.field_favProto.wiv;
                this.pKw.mo8328a(c13017b);
            }
        }
        AppMethodBeat.m2505o(24214);
    }

    public void onStop() {
        AppMethodBeat.m2504i(24215);
        super.onStop();
        AppMethodBeat.m2505o(24215);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(24216);
        ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavItemInfoStorage().mo10117d(this.mgG);
        if (this.pKw != null) {
            ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavCdnStorage().mo15159b(((C39579d) this.pKw).pKb);
        }
        this.pKh = true;
        super.onDestroy();
        AppMethodBeat.m2505o(24216);
    }

    /* Access modifiers changed, original: protected|final */
    public final String ceK() {
        String mK;
        AppMethodBeat.m2504i(24217);
        if (14 != this.mjP.field_type || C5046bo.isNullOrNil(this.mjP.field_favProto.title)) {
            abl abl = this.mjP.field_favProto.wit;
            if (abl == null || C5046bo.isNullOrNil(abl.whU)) {
                C4990ab.m7419v("MicroMsg.FavRecordDetailUI", "display name, from item info user[%s]", this.mjP.field_fromUser);
                mK = C43436n.m77568mK(this.mjP.field_fromUser);
            } else {
                mK = C1854s.m3866mJ(abl.whU);
                String mK2;
                if (C1853r.m3846Yz().equals(abl.cEV)) {
                    mK2 = C43436n.m77568mK(abl.toUser);
                    if (!C5046bo.m7532bc(mK2, "").equals(abl.toUser)) {
                        mK = mK + " - " + mK2;
                    }
                } else {
                    mK2 = C43436n.m77568mK(abl.cEV);
                    if (!C5046bo.m7532bc(mK2, "").equals(abl.cEV)) {
                        mK = mK + " - " + mK2;
                    }
                }
                C4990ab.m7419v("MicroMsg.FavRecordDetailUI", "display name, source from[%s] to[%s]", abl.cEV, abl.toUser);
            }
        } else {
            mK = this.mjP.field_favProto.title;
        }
        AppMethodBeat.m2505o(24217);
        return mK;
    }

    /* Access modifiers changed, original: protected|final */
    public final String ceL() {
        AppMethodBeat.m2504i(24218);
        LinkedList linkedList = this.mjP.field_favProto.wiv;
        if (linkedList.size() > 0) {
            String str = ((aar) linkedList.getFirst()).wgX;
            AppMethodBeat.m2505o(24218);
            return str;
        }
        AppMethodBeat.m2505o(24218);
        return null;
    }

    /* Access modifiers changed, original: protected|final */
    public final String ceM() {
        AppMethodBeat.m2504i(24219);
        LinkedList linkedList = this.mjP.field_favProto.wiv;
        if (linkedList.size() > 0) {
            String str = ((aar) linkedList.getLast()).wgX;
            AppMethodBeat.m2505o(24219);
            return str;
        }
        AppMethodBeat.m2505o(24219);
        return null;
    }

    /* Access modifiers changed, original: protected|final */
    public final void ceN() {
        AppMethodBeat.m2504i(24220);
        if (this.cHc) {
            addIconOptionMenu(0, C25738R.string.ewm, C25738R.drawable.f6899uu, new C248182());
            AppMethodBeat.m2505o(24220);
            return;
        }
        AppMethodBeat.m2505o(24220);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: d */
    public final void mo37104d(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(24221);
        if (4097 == i && -1 == i2) {
            C37721gh c37721gh = new C37721gh();
            c37721gh.cAH.type = 32;
            c37721gh.cAH.cvv = this.pKf;
            C4879a.xxA.mo10055m(c37721gh);
            if (c37721gh.cAI.cAY) {
                C30379h.m48465bQ(this.mController.ylL, getString(C25738R.string.f8634ah));
                AppMethodBeat.m2505o(24221);
                return;
            }
            String str;
            String stringExtra = intent == null ? null : intent.getStringExtra("Select_Conv_User");
            if (intent == null) {
                str = null;
            } else {
                str = intent.getStringExtra("custom_send_text");
            }
            final C44275p b = C30379h.m48458b(this.mController.ylL, getString(C25738R.string.bp2), false, null);
            C37721gh c37721gh2 = new C37721gh();
            c37721gh2.cAH.type = 13;
            c37721gh2.cAH.context = this.mController.ylL;
            c37721gh2.cAH.toUser = stringExtra;
            c37721gh2.cAH.cAN = str;
            c37721gh2.cAH.cvv = this.pKf;
            c37721gh2.cAH.cAM = new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(24208);
                    b.dismiss();
                    C5670b.m8523i(FavRecordDetailUI.this, FavRecordDetailUI.this.getString(C25738R.string.bvk));
                    AppMethodBeat.m2505o(24208);
                }
            };
            C4879a.xxA.mo10055m(c37721gh2);
            AppMethodBeat.m2505o(24221);
            return;
        }
        AppMethodBeat.m2505o(24221);
    }
}
