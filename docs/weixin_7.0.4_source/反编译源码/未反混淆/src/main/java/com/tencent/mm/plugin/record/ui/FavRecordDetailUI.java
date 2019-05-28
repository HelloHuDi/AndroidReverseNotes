package com.tencent.mm.plugin.record.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.gh;
import com.tencent.mm.model.r;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.fav.a.ae;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.fav.a.h;
import com.tencent.mm.plugin.record.b.n;
import com.tencent.mm.protocal.protobuf.aar;
import com.tencent.mm.protocal.protobuf.abl;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.p;
import java.util.LinkedList;
import java.util.List;

public class FavRecordDetailUI extends RecordMsgBaseUI {
    private boolean cHc = true;
    private a mgG = new a() {
        public final void a(String str, m mVar) {
            AppMethodBeat.i(24202);
            if (mVar == null) {
                AppMethodBeat.o(24202);
            } else if (mVar.obj == null) {
                AppMethodBeat.o(24202);
            } else {
                long longValue = ((Long) mVar.obj).longValue();
                if (longValue < 0) {
                    AppMethodBeat.o(24202);
                    return;
                }
                if (FavRecordDetailUI.this.pKf == longValue) {
                    g jD = com.tencent.mm.plugin.record.b.g.jD(FavRecordDetailUI.this.pKf);
                    final b bVar = new b();
                    bVar.mnW = jD;
                    if (!(jD == null || jD.field_favProto == null)) {
                        bVar.pJZ = jD.field_favProto.wiv;
                        al.d(new Runnable() {
                            public final void run() {
                                AppMethodBeat.i(24201);
                                FavRecordDetailUI.this.pKw.a(bVar);
                                AppMethodBeat.o(24201);
                            }
                        });
                    }
                }
                AppMethodBeat.o(24202);
            }
        }
    };
    private g mjP;
    private long pKf = -1;
    private boolean pKg = true;
    private boolean pKh = false;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public FavRecordDetailUI() {
        AppMethodBeat.i(24210);
        AppMethodBeat.o(24210);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(24211);
        super.onCreate(bundle);
        AppMethodBeat.o(24211);
    }

    /* Access modifiers changed, original: protected|final */
    public final void ceI() {
        AppMethodBeat.i(24212);
        this.pKf = getIntent().getLongExtra("key_detail_info_id", -1);
        this.cHc = getIntent().getBooleanExtra("show_share", true);
        this.mjP = com.tencent.mm.plugin.record.b.g.jD(this.pKf);
        if (this.mjP == null) {
            finish();
            AppMethodBeat.o(24212);
            return;
        }
        F(this.mjP);
        b bVar = new b();
        bVar.mnW = this.mjP;
        bVar.pJZ = this.mjP.field_favProto.wiv;
        List<aar> list = bVar.pJZ;
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
        this.pKw.a(bVar);
        final List list2 = bVar.pJZ;
        if (list2 != null) {
            d.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(24209);
                    if (list2 == null) {
                        AppMethodBeat.o(24209);
                        return;
                    }
                    ab.i("MicroMsg.FavRecordDetailUI", "start calc");
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
                    ab.v("MicroMsg.FavRecordDetailUI", "start calc finish %s", r0);
                    AppMethodBeat.o(24209);
                }
            }, "calc_fav_record_info");
        }
        ((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavItemInfoStorage().c(this.mgG);
        ((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavCdnStorage().a(((d) this.pKw).pKb);
        AppMethodBeat.o(24212);
    }

    /* Access modifiers changed, original: protected|final */
    public final h ceJ() {
        AppMethodBeat.i(24213);
        d dVar = new d(this, new c(this));
        AppMethodBeat.o(24213);
        return dVar;
    }

    public void onResume() {
        AppMethodBeat.i(24214);
        super.onResume();
        b bVar = (b) ((d) this.pKw).pKs;
        if (bVar.mnW != null) {
            g jD = com.tencent.mm.plugin.record.b.g.jD(bVar.mnW.field_localId);
            if (jD == null || jD.field_favProto == null) {
                AppMethodBeat.o(24214);
                return;
            }
            Object obj;
            LinkedList linkedList = jD.field_favProto.wiv;
            for (aar contains : bVar.pJZ) {
                if (!linkedList.contains(contains)) {
                    obj = 1;
                    break;
                }
            }
            obj = null;
            if (obj != null) {
                bVar = new b();
                bVar.mnW = jD;
                bVar.pJZ = jD.field_favProto.wiv;
                this.pKw.a(bVar);
            }
        }
        AppMethodBeat.o(24214);
    }

    public void onStop() {
        AppMethodBeat.i(24215);
        super.onStop();
        AppMethodBeat.o(24215);
    }

    public void onDestroy() {
        AppMethodBeat.i(24216);
        ((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavItemInfoStorage().d(this.mgG);
        if (this.pKw != null) {
            ((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavCdnStorage().b(((d) this.pKw).pKb);
        }
        this.pKh = true;
        super.onDestroy();
        AppMethodBeat.o(24216);
    }

    /* Access modifiers changed, original: protected|final */
    public final String ceK() {
        String mK;
        AppMethodBeat.i(24217);
        if (14 != this.mjP.field_type || bo.isNullOrNil(this.mjP.field_favProto.title)) {
            abl abl = this.mjP.field_favProto.wit;
            if (abl == null || bo.isNullOrNil(abl.whU)) {
                ab.v("MicroMsg.FavRecordDetailUI", "display name, from item info user[%s]", this.mjP.field_fromUser);
                mK = n.mK(this.mjP.field_fromUser);
            } else {
                mK = s.mJ(abl.whU);
                String mK2;
                if (r.Yz().equals(abl.cEV)) {
                    mK2 = n.mK(abl.toUser);
                    if (!bo.bc(mK2, "").equals(abl.toUser)) {
                        mK = mK + " - " + mK2;
                    }
                } else {
                    mK2 = n.mK(abl.cEV);
                    if (!bo.bc(mK2, "").equals(abl.cEV)) {
                        mK = mK + " - " + mK2;
                    }
                }
                ab.v("MicroMsg.FavRecordDetailUI", "display name, source from[%s] to[%s]", abl.cEV, abl.toUser);
            }
        } else {
            mK = this.mjP.field_favProto.title;
        }
        AppMethodBeat.o(24217);
        return mK;
    }

    /* Access modifiers changed, original: protected|final */
    public final String ceL() {
        AppMethodBeat.i(24218);
        LinkedList linkedList = this.mjP.field_favProto.wiv;
        if (linkedList.size() > 0) {
            String str = ((aar) linkedList.getFirst()).wgX;
            AppMethodBeat.o(24218);
            return str;
        }
        AppMethodBeat.o(24218);
        return null;
    }

    /* Access modifiers changed, original: protected|final */
    public final String ceM() {
        AppMethodBeat.i(24219);
        LinkedList linkedList = this.mjP.field_favProto.wiv;
        if (linkedList.size() > 0) {
            String str = ((aar) linkedList.getLast()).wgX;
            AppMethodBeat.o(24219);
            return str;
        }
        AppMethodBeat.o(24219);
        return null;
    }

    /* Access modifiers changed, original: protected|final */
    public final void ceN() {
        AppMethodBeat.i(24220);
        if (this.cHc) {
            addIconOptionMenu(0, R.string.ewm, R.drawable.uu, new OnMenuItemClickListener() {
                public final boolean onMenuItemClick(MenuItem menuItem) {
                    AppMethodBeat.i(24207);
                    com.tencent.mm.ui.widget.a.d dVar = new com.tencent.mm.ui.widget.a.d(FavRecordDetailUI.this.mController.ylL, 1, false);
                    dVar.rBl = new c() {
                        public final void a(l lVar) {
                            AppMethodBeat.i(24203);
                            ab.i("MicroMsg.FavRecordDetailUI", "favItemInfo: id %d, status %d", Integer.valueOf(FavRecordDetailUI.this.mjP.field_id), Integer.valueOf(FavRecordDetailUI.this.mjP.field_itemStatus));
                            if (FavRecordDetailUI.this.mjP.field_id > 0 && !FavRecordDetailUI.this.mjP.buw() && !FavRecordDetailUI.this.mjP.bux() && FavRecordDetailUI.this.pKg) {
                                lVar.e(0, FavRecordDetailUI.this.getString(R.string.bri));
                            }
                            lVar.e(5, FavRecordDetailUI.this.getString(R.string.br7));
                            lVar.e(3, FavRecordDetailUI.this.getString(R.string.bo8));
                            lVar.e(2, FavRecordDetailUI.this.getString(R.string.p4));
                            AppMethodBeat.o(24203);
                        }
                    };
                    dVar.rBm = new com.tencent.mm.ui.base.n.d() {
                        public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                            AppMethodBeat.i(24206);
                            Intent intent;
                            switch (menuItem.getItemId()) {
                                case 0:
                                    intent = new Intent();
                                    intent.putExtra("Select_Conv_Type", 3);
                                    intent.putExtra("scene_from", 1);
                                    intent.putExtra("mutil_select_is_ret", true);
                                    intent.putExtra("select_fav_local_id", FavRecordDetailUI.this.mjP.field_localId);
                                    com.tencent.mm.bp.d.b(FavRecordDetailUI.this, ".ui.transmit.SelectConversationUI", intent, 4097);
                                    h.j(FavRecordDetailUI.this.mjP.field_localId, 1, 0);
                                    AppMethodBeat.o(24206);
                                    return;
                                case 2:
                                    com.tencent.mm.ui.base.h.a(FavRecordDetailUI.this.mController.ylL, FavRecordDetailUI.this.getString(R.string.p5), "", new OnClickListener() {
                                        public final void onClick(DialogInterface dialogInterface, int i) {
                                            AppMethodBeat.i(24205);
                                            final p b = com.tencent.mm.ui.base.h.b(FavRecordDetailUI.this.mController.ylL, FavRecordDetailUI.this.getString(R.string.p5), false, null);
                                            gh ghVar = new gh();
                                            ghVar.cAH.type = 12;
                                            ghVar.cAH.cvv = FavRecordDetailUI.this.pKf;
                                            ghVar.cAH.cAM = new Runnable() {
                                                public final void run() {
                                                    AppMethodBeat.i(24204);
                                                    b.dismiss();
                                                    ab.d("MicroMsg.FavRecordDetailUI", "do del, local id %d", Long.valueOf(FavRecordDetailUI.this.pKf));
                                                    FavRecordDetailUI.this.finish();
                                                    AppMethodBeat.o(24204);
                                                }
                                            };
                                            com.tencent.mm.sdk.b.a.xxA.m(ghVar);
                                            AppMethodBeat.o(24205);
                                        }
                                    }, null);
                                    AppMethodBeat.o(24206);
                                    return;
                                case 3:
                                    intent = new Intent();
                                    intent.putExtra("key_fav_scene", 2);
                                    intent.putExtra("key_fav_item_id", FavRecordDetailUI.this.pKf);
                                    b.b(FavRecordDetailUI.this.mController.ylL, ".ui.FavTagEditUI", intent);
                                    AppMethodBeat.o(24206);
                                    return;
                                case 4:
                                    intent = new Intent();
                                    intent.putExtra("key_fav_scene", 1);
                                    intent.putExtra("key_fav_item_id", FavRecordDetailUI.this.mjP.field_localId);
                                    b.b(FavRecordDetailUI.this.mController.ylL, ".ui.FavTagEditUI", intent);
                                    AppMethodBeat.o(24206);
                                    return;
                                case 5:
                                    com.tencent.mm.plugin.fav.ui.g.a(FavRecordDetailUI.this, FavRecordDetailUI.this.pKf, FavRecordDetailUI.this.mlz);
                                    break;
                            }
                            AppMethodBeat.o(24206);
                        }
                    };
                    dVar.cpD();
                    AppMethodBeat.o(24207);
                    return true;
                }
            });
            AppMethodBeat.o(24220);
            return;
        }
        AppMethodBeat.o(24220);
    }

    /* Access modifiers changed, original: protected|final */
    public final void d(int i, int i2, Intent intent) {
        AppMethodBeat.i(24221);
        if (4097 == i && -1 == i2) {
            gh ghVar = new gh();
            ghVar.cAH.type = 32;
            ghVar.cAH.cvv = this.pKf;
            com.tencent.mm.sdk.b.a.xxA.m(ghVar);
            if (ghVar.cAI.cAY) {
                com.tencent.mm.ui.base.h.bQ(this.mController.ylL, getString(R.string.ah));
                AppMethodBeat.o(24221);
                return;
            }
            String str;
            String stringExtra = intent == null ? null : intent.getStringExtra("Select_Conv_User");
            if (intent == null) {
                str = null;
            } else {
                str = intent.getStringExtra("custom_send_text");
            }
            final p b = com.tencent.mm.ui.base.h.b(this.mController.ylL, getString(R.string.bp2), false, null);
            gh ghVar2 = new gh();
            ghVar2.cAH.type = 13;
            ghVar2.cAH.context = this.mController.ylL;
            ghVar2.cAH.toUser = stringExtra;
            ghVar2.cAH.cAN = str;
            ghVar2.cAH.cvv = this.pKf;
            ghVar2.cAH.cAM = new Runnable() {
                public final void run() {
                    AppMethodBeat.i(24208);
                    b.dismiss();
                    com.tencent.mm.ui.widget.snackbar.b.i(FavRecordDetailUI.this, FavRecordDetailUI.this.getString(R.string.bvk));
                    AppMethodBeat.o(24208);
                }
            };
            com.tencent.mm.sdk.b.a.xxA.m(ghVar2);
            AppMethodBeat.o(24221);
            return;
        }
        AppMethodBeat.o(24221);
    }
}
