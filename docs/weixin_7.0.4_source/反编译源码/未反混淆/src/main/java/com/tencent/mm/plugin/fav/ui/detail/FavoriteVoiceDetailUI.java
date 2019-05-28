package com.tencent.mm.plugin.fav.ui.detail;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.fav.a.ae;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.fav.a.h;
import com.tencent.mm.plugin.fav.a.n;
import com.tencent.mm.plugin.fav.ui.FavChatVoiceView;
import com.tencent.mm.plugin.fav.ui.j;
import com.tencent.mm.protocal.protobuf.aar;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.vfs.e;

public class FavoriteVoiceDetailUI extends BaseFavDetailReportUI implements a {
    private n mgA;
    private g mgf;
    private long mmC;
    private FavChatVoiceView mni;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public final int getLayoutId() {
        return R.layout.zc;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(74484);
        super.onCreate(bundle);
        setMMTitle(getString(R.string.bns));
        this.mmC = getIntent().getLongExtra("key_detail_info_id", -1);
        this.mgf = ((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavItemInfoStorage().iE(this.mmC);
        if (this.mgf == null) {
            ab.w("MicroMsg.FavoriteDetailUI", "get fav item info error");
            finish();
        } else {
            F(this.mgf);
            this.mgA = new n();
            this.mni = (FavChatVoiceView) findViewById(R.id.bsj);
            this.mni.setVoiceHelper(this.mgA);
            a.a(this, this.mgf);
            aar c = b.c(this.mgf);
            String b = b.b(c);
            int LE = b.LE(c.wgo);
            if (!e.ct(b)) {
                b.m(this.mgf);
            }
            this.mni.t(b, LE, j.B(this, (int) b.iu((long) c.duration)).toString());
            setBackBtn(new OnMenuItemClickListener() {
                public final boolean onMenuItemClick(MenuItem menuItem) {
                    AppMethodBeat.i(74478);
                    FavoriteVoiceDetailUI.this.finish();
                    AppMethodBeat.o(74478);
                    return true;
                }
            });
            addIconOptionMenu(0, R.string.ewm, R.drawable.uu, new OnMenuItemClickListener() {
                public final boolean onMenuItemClick(MenuItem menuItem) {
                    AppMethodBeat.i(74483);
                    d dVar = new d(FavoriteVoiceDetailUI.this.mController.ylL, 1, false);
                    dVar.rBl = new c() {
                        public final void a(l lVar) {
                            AppMethodBeat.i(74479);
                            lVar.e(0, FavoriteVoiceDetailUI.this.getString(R.string.bo8));
                            lVar.hi(2, R.string.br7);
                            lVar.e(1, FavoriteVoiceDetailUI.this.mController.ylL.getString(R.string.p4));
                            AppMethodBeat.o(74479);
                        }
                    };
                    dVar.rBm = new com.tencent.mm.ui.base.n.d() {
                        public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                            AppMethodBeat.i(74482);
                            switch (menuItem.getItemId()) {
                                case 0:
                                    Intent intent = new Intent();
                                    intent.putExtra("key_fav_scene", 2);
                                    intent.putExtra("key_fav_item_id", FavoriteVoiceDetailUI.this.mgf.field_localId);
                                    b.b(FavoriteVoiceDetailUI.this.mController.ylL, ".ui.FavTagEditUI", intent);
                                    h.a aVar = FavoriteVoiceDetailUI.this.mlz;
                                    aVar.mfc++;
                                    AppMethodBeat.o(74482);
                                    return;
                                case 1:
                                    com.tencent.mm.ui.base.h.a(FavoriteVoiceDetailUI.this.mController.ylL, FavoriteVoiceDetailUI.this.getString(R.string.p5), "", new OnClickListener() {
                                        public final void onClick(DialogInterface dialogInterface, int i) {
                                            AppMethodBeat.i(74481);
                                            final p b = com.tencent.mm.ui.base.h.b(FavoriteVoiceDetailUI.this.mController.ylL, FavoriteVoiceDetailUI.this.getString(R.string.p5), false, null);
                                            final long j = FavoriteVoiceDetailUI.this.mgf.field_localId;
                                            final long j2 = (long) FavoriteVoiceDetailUI.this.mgf.field_id;
                                            b.a(FavoriteVoiceDetailUI.this.mgf.field_localId, new Runnable() {
                                                public final void run() {
                                                    AppMethodBeat.i(74480);
                                                    FavoriteVoiceDetailUI.this.mlz.mfd = true;
                                                    b.dismiss();
                                                    ab.d("MicroMsg.FavoriteDetailUI", "do del fav voice, local id %d, fav id %d", Long.valueOf(j), Long.valueOf(j2));
                                                    FavoriteVoiceDetailUI.this.finish();
                                                    AppMethodBeat.o(74480);
                                                }
                                            });
                                            AppMethodBeat.o(74481);
                                        }
                                    }, null);
                                    AppMethodBeat.o(74482);
                                    return;
                                case 2:
                                    com.tencent.mm.plugin.fav.ui.g.a(FavoriteVoiceDetailUI.this, FavoriteVoiceDetailUI.this.mmC, FavoriteVoiceDetailUI.this.mlz);
                                    break;
                            }
                            AppMethodBeat.o(74482);
                        }
                    };
                    dVar.cpD();
                    AppMethodBeat.o(74483);
                    return true;
                }
            });
        }
        ((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavItemInfoStorage().c(this);
        AppMethodBeat.o(74484);
    }

    public void onDestroy() {
        AppMethodBeat.i(74485);
        super.onDestroy();
        if (this.mni != null) {
            this.mni.stopPlay();
        }
        if (this.mgA != null) {
            this.mgA.destroy();
        }
        ((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavItemInfoStorage().d(this);
        AppMethodBeat.o(74485);
    }

    public void onResume() {
        AppMethodBeat.i(74486);
        super.onResume();
        AppMethodBeat.o(74486);
    }

    public void onPause() {
        AppMethodBeat.i(74487);
        super.onPause();
        this.mgA.pause();
        AppMethodBeat.o(74487);
    }

    public final void a(String str, m mVar) {
        AppMethodBeat.i(74488);
        this.mgf = ((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavItemInfoStorage().iE(this.mmC);
        if (this.mgf == null) {
            ab.w("MicroMsg.FavoriteDetailUI", "on notify changed, get fav item info error");
            finish();
            AppMethodBeat.o(74488);
        } else if (this.mgf.field_itemStatus != 10) {
            AppMethodBeat.o(74488);
        } else if (mVar == null || mVar.xDr == null) {
            AppMethodBeat.o(74488);
        } else {
            if (this.mgf.field_favProto.wiv.size() > 0) {
                aar c = b.c(this.mgf);
                String b = b.b(c);
                int LE = b.LE(c.wgo);
                ab.i("MicroMsg.FavoriteDetailUI", "on notify changed, favVoiceView.updateInfo");
                this.mni.t(b, LE, j.B(this, (int) b.iu((long) c.duration)).toString());
            }
            AppMethodBeat.o(74488);
        }
    }
}
