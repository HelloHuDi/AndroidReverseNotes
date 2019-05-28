package com.tencent.mm.plugin.fav.ui.detail;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.text.ClipboardManager;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.m.b;
import com.tencent.mm.plugin.fav.a.ae;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.fav.a.h.a;
import com.tencent.mm.pluginsdk.wallet.i;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.tools.j;
import com.tencent.mm.ui.widget.MMLoadScrollView;

public class FavoriteTextDetailUI extends BaseFavDetailReportUI {
    private static final int mmM = b.MY();
    private j contextMenuHelper;
    private long mmC;
    private TextView mmN;
    private ClipboardManager mmO;
    private g mmP;
    private d mmQ = new d() {
        public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
            AppMethodBeat.i(74443);
            switch (menuItem.getItemId()) {
                case 1:
                    if (!(FavoriteTextDetailUI.this.mmO == null || FavoriteTextDetailUI.this.mmj == null || FavoriteTextDetailUI.this.mmj.field_favProto == null)) {
                        FavoriteTextDetailUI.this.mmO.setText(FavoriteTextDetailUI.this.mmj.field_favProto.desc);
                        h.bQ(FavoriteTextDetailUI.this.mController.ylL, FavoriteTextDetailUI.this.mController.ylL.getString(R.string.oz));
                        break;
                    }
            }
            AppMethodBeat.o(74443);
        }
    };
    private g mmj;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public FavoriteTextDetailUI() {
        AppMethodBeat.i(74445);
        AppMethodBeat.o(74445);
    }

    static /* synthetic */ void d(FavoriteTextDetailUI favoriteTextDetailUI) {
        AppMethodBeat.i(74454);
        favoriteTextDetailUI.bwp();
        AppMethodBeat.o(74454);
    }

    static {
        AppMethodBeat.i(74455);
        AppMethodBeat.o(74455);
    }

    public final int getLayoutId() {
        return R.layout.zb;
    }

    /* Access modifiers changed, original: protected|final */
    public final MMLoadScrollView bwd() {
        AppMethodBeat.i(74446);
        MMLoadScrollView mMLoadScrollView = (MMLoadScrollView) findViewById(R.id.bsd);
        AppMethodBeat.o(74446);
        return mMLoadScrollView;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(74447);
        super.onCreate(bundle);
        this.mmN = (TextView) findViewById(R.id.bsi);
        this.mmO = (ClipboardManager) ah.getContext().getSystemService("clipboard");
        this.mmC = getIntent().getLongExtra("key_detail_info_id", -1);
        i.Lt(5);
        this.contextMenuHelper = new j(this.mController.ylL);
        this.contextMenuHelper.a(this.mmN, this, this.mmQ);
        setMMTitle(getString(R.string.bns));
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(74437);
                FavoriteTextDetailUI.this.finish();
                AppMethodBeat.o(74437);
                return true;
            }
        });
        addIconOptionMenu(0, R.string.ewm, R.drawable.uu, new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(74442);
                com.tencent.mm.ui.widget.a.d dVar = new com.tencent.mm.ui.widget.a.d(FavoriteTextDetailUI.this.mController.ylL, 1, false);
                dVar.rBl = new c() {
                    public final void a(l lVar) {
                        AppMethodBeat.i(74438);
                        if (FavoriteTextDetailUI.this.getIntent().getBooleanExtra("key_detail_can_share_to_friend", true)) {
                            lVar.e(2, FavoriteTextDetailUI.this.getString(R.string.bri));
                        }
                        lVar.e(0, FavoriteTextDetailUI.this.getString(R.string.bo6));
                        lVar.e(1, FavoriteTextDetailUI.this.getString(R.string.br7));
                        lVar.e(3, FavoriteTextDetailUI.this.getString(R.string.bo8));
                        lVar.e(4, FavoriteTextDetailUI.this.getString(R.string.p4));
                        AppMethodBeat.o(74438);
                    }
                };
                dVar.rBm = new d() {
                    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                        AppMethodBeat.i(74441);
                        Intent intent;
                        a aVar;
                        switch (menuItem.getItemId()) {
                            case 0:
                                if (!(FavoriteTextDetailUI.this.mmj == null || FavoriteTextDetailUI.this.mmj.field_favProto == null)) {
                                    intent = new Intent();
                                    intent.putExtra("key_value", FavoriteTextDetailUI.this.mmj.field_favProto.desc);
                                    intent.putExtra("key_max_count", FavoriteTextDetailUI.mmM);
                                    intent.putExtra("key_show_confirm", true);
                                    intent.putExtra("key_fav_item_id", FavoriteTextDetailUI.this.mmj.field_id);
                                    com.tencent.mm.plugin.fav.a.b.a(FavoriteTextDetailUI.this, ".ui.FavTextEditUI", intent, 1);
                                    aVar = FavoriteTextDetailUI.this.mlz;
                                    aVar.mfb++;
                                    AppMethodBeat.o(74441);
                                    return;
                                }
                            case 1:
                                com.tencent.mm.plugin.fav.ui.g.a(FavoriteTextDetailUI.this, FavoriteTextDetailUI.this.mmC, FavoriteTextDetailUI.this.mlz);
                                AppMethodBeat.o(74441);
                                return;
                            case 2:
                                if (!(FavoriteTextDetailUI.this.mmj == null || FavoriteTextDetailUI.this.mmj.field_favProto == null)) {
                                    aVar = FavoriteTextDetailUI.this.mlz;
                                    aVar.meZ++;
                                    com.tencent.mm.plugin.fav.a.b.e(FavoriteTextDetailUI.this.mmj.field_favProto.desc, FavoriteTextDetailUI.this);
                                    com.tencent.mm.plugin.fav.a.h.j(FavoriteTextDetailUI.this.mmj.field_localId, 1, 0);
                                    AppMethodBeat.o(74441);
                                    return;
                                }
                            case 3:
                                intent = new Intent();
                                intent.putExtra("key_fav_scene", 2);
                                intent.putExtra("key_fav_item_id", FavoriteTextDetailUI.this.mmj.field_localId);
                                com.tencent.mm.plugin.fav.a.b.b(FavoriteTextDetailUI.this.mController.ylL, ".ui.FavTagEditUI", intent);
                                aVar = FavoriteTextDetailUI.this.mlz;
                                aVar.mfc++;
                                AppMethodBeat.o(74441);
                                return;
                            case 4:
                                h.a(FavoriteTextDetailUI.this.mController.ylL, FavoriteTextDetailUI.this.getString(R.string.p5), "", new OnClickListener() {
                                    public final void onClick(DialogInterface dialogInterface, int i) {
                                        AppMethodBeat.i(74440);
                                        final p b = h.b(FavoriteTextDetailUI.this.mController.ylL, FavoriteTextDetailUI.this.getString(R.string.p5), false, null);
                                        com.tencent.mm.plugin.fav.a.b.a(FavoriteTextDetailUI.this.mmC, new Runnable() {
                                            public final void run() {
                                                AppMethodBeat.i(74439);
                                                FavoriteTextDetailUI.this.mlz.mfd = true;
                                                b.dismiss();
                                                ab.d("MicroMsg.FavoriteTextDetailUI", "do del, local id %d", Long.valueOf(FavoriteTextDetailUI.this.mmC));
                                                FavoriteTextDetailUI.this.finish();
                                                AppMethodBeat.o(74439);
                                            }
                                        });
                                        AppMethodBeat.o(74440);
                                    }
                                }, null);
                                break;
                        }
                        AppMethodBeat.o(74441);
                    }
                };
                dVar.cpD();
                AppMethodBeat.o(74442);
                return true;
            }
        });
        AppMethodBeat.o(74447);
    }

    public void onDestroy() {
        AppMethodBeat.i(74448);
        super.onDestroy();
        AppMethodBeat.o(74448);
    }

    public void onResume() {
        AppMethodBeat.i(74449);
        super.onResume();
        bwp();
        AppMethodBeat.o(74449);
    }

    public void onPause() {
        AppMethodBeat.i(74450);
        super.onPause();
        AppMethodBeat.o(74450);
    }

    private void bwp() {
        AppMethodBeat.i(74451);
        this.mmj = ((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavItemInfoStorage().iE(this.mmC);
        F(this.mmj);
        if (this.mmj == null || this.mmj.field_favProto == null) {
            ab.w("MicroMsg.FavoriteTextDetailUI", "id[%d] info is null, return", Long.valueOf(this.mmC));
            AppMethodBeat.o(74451);
            return;
        }
        a.a(this, this.mmj);
        if (this.mmP == null || this.mmP.field_edittime != this.mmj.field_edittime) {
            this.mmP = this.mmj;
            this.mmN.setText(this.mmj.field_favProto.desc);
            com.tencent.mm.pluginsdk.ui.e.j.h(this.mmN, 1);
            AppMethodBeat.o(74451);
            return;
        }
        ab.w("MicroMsg.FavoriteTextDetailUI", "not change, return");
        AppMethodBeat.o(74451);
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        AppMethodBeat.i(74452);
        contextMenu.add(0, 1, 0, getString(R.string.oy));
        AppMethodBeat.o(74452);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(74453);
        if (1 == i && -1 == i2) {
            h.bQ(this.mController.ylL, getString(R.string.td));
            new ak().postDelayed(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(74444);
                    FavoriteTextDetailUI.d(FavoriteTextDetailUI.this);
                    AppMethodBeat.o(74444);
                }
            }, 250);
            AppMethodBeat.o(74453);
            return;
        }
        super.onActivityResult(i, i2, intent);
        AppMethodBeat.o(74453);
    }
}
