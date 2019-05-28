package com.tencent.mm.plugin.fav.ui;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.Pair;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.fav.a.ae;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.fav.a.h;
import com.tencent.mm.plugin.fav.a.k;
import com.tencent.mm.plugin.fav.a.w;
import com.tencent.mm.plugin.fav.ui.a.b;
import com.tencent.mm.plugin.fav.ui.d.a;
import com.tencent.mm.pluginsdk.ui.applet.q;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.p;
import java.util.HashSet;
import java.util.Set;

public class FavSelectUI extends FavBaseUI {
    private String mjA;
    private b mjB = null;
    private Set<Integer> mjC = new HashSet();
    private k mjD = new k();
    private OnClickListener mjE = new OnClickListener() {
        public final void onClick(View view) {
            AppMethodBeat.i(74107);
            int intValue = ((Integer) view.getTag()).intValue();
            Intent intent = new Intent();
            intent.putExtra("key_preset_search_type", intValue);
            FavSelectUI.a(FavSelectUI.this, intent);
            AppMethodBeat.o(74107);
        }
    };
    private String toUser;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public FavSelectUI() {
        AppMethodBeat.i(74108);
        AppMethodBeat.o(74108);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(74109);
        super.onCreate(bundle);
        this.toUser = getIntent().getStringExtra("key_to_user");
        this.mjA = getIntent().getStringExtra("key_fav_item_id");
        if (this.mjA != null) {
            for (String str : this.mjA.split(",")) {
                int i = bo.getInt(str, BaseClientBuilder.API_PRIORITY_OTHER);
                if (BaseClientBuilder.API_PRIORITY_OTHER != i) {
                    this.mjC.add(Integer.valueOf(i));
                }
            }
        }
        this.mjC.remove(Integer.valueOf(3));
        this.mjB.f(this.mjC);
        this.mjD.mfm = false;
        this.mjB.a((w) this.mjD);
        this.mcy.post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(74101);
                FavSelectUI.this.mjB.bvY();
                FavSelectUI.this.bvz();
                AppMethodBeat.o(74101);
            }
        });
        addIconOptionMenu(0, R.raw.actionbar_icon_dark_search, new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(74102);
                FavSelectUI.a(FavSelectUI.this, new Intent());
                AppMethodBeat.o(74102);
                return true;
            }
        });
        setMMTitle((int) R.string.brf);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(74103);
                FavSelectUI.this.finish();
                AppMethodBeat.o(74103);
                return true;
            }
        });
        AppMethodBeat.o(74109);
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        AppMethodBeat.i(74110);
        final a.b bVar = (a.b) view.getTag();
        if (bVar == null) {
            ab.w("MicroMsg.FavSelectUI", "on item click, holder is null");
            AppMethodBeat.o(74110);
        } else if (bVar.mgf == null) {
            ab.w("MicroMsg.FavSelectUI", "on item click, info is null");
            AppMethodBeat.o(74110);
        } else {
            g gVar = bVar.mgf;
            h.j(gVar.field_localId, 1, 1);
            if (gVar.field_type == 3) {
                com.tencent.mm.ui.widget.snackbar.b.i(this, getString(R.string.ai));
                AppMethodBeat.o(74110);
            } else if (gVar.field_type == 8 && t.mZ(this.toUser)) {
                com.tencent.mm.ui.widget.snackbar.b.i(this, getString(R.string.ag));
                AppMethodBeat.o(74110);
            } else {
                ((com.tencent.mm.plugin.fav.a.ab) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.fav.a.ab.class)).a(this.mController.ylL, this.toUser, bVar.mgf, true, new q.a() {
                    public final void a(boolean z, String str, int i) {
                        AppMethodBeat.i(74106);
                        FavSelectUI.this.aqX();
                        if (z) {
                            final p b = com.tencent.mm.ui.base.h.b(FavSelectUI.this.mController.ylL, FavSelectUI.this.getString(R.string.bp2), false, null);
                            i.a(FavSelectUI.this.mController.ylL, FavSelectUI.this.toUser, str, bVar.mgf, new Runnable() {
                                public final void run() {
                                    AppMethodBeat.i(74105);
                                    if (b != null) {
                                        b.dismiss();
                                    }
                                    com.tencent.mm.ui.widget.snackbar.b.i(FavSelectUI.this, FavSelectUI.this.getString(R.string.bnf));
                                    al.n(new Runnable() {
                                        public final void run() {
                                            AppMethodBeat.i(74104);
                                            FavSelectUI.this.finish();
                                            AppMethodBeat.o(74104);
                                        }
                                    }, 1800);
                                    AppMethodBeat.o(74105);
                                }
                            });
                        }
                        AppMethodBeat.o(74106);
                    }
                });
                AppMethodBeat.o(74110);
            }
        }
    }

    public final com.tencent.mm.plugin.fav.ui.a.a bvu() {
        AppMethodBeat.i(74111);
        if (this.mjB == null) {
            this.mjB = new b(this.mhy, false);
        }
        b bVar = this.mjB;
        AppMethodBeat.o(74111);
        return bVar;
    }

    /* Access modifiers changed, original: protected|final */
    public final void bvv() {
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean bvw() {
        AppMethodBeat.i(74112);
        if (((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavItemInfoStorage().getCount() > 0) {
            AppMethodBeat.o(74112);
            return true;
        }
        AppMethodBeat.o(74112);
        return false;
    }

    /* Access modifiers changed, original: protected|final */
    public final void bvx() {
        AppMethodBeat.i(74113);
        this.mht.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.adw, 0, 0);
        this.mht.setCompoundDrawablePadding(com.tencent.mm.bz.a.fromDPToPix(this.mController.ylL, 10));
        this.mht.setText(R.string.boa);
        AppMethodBeat.o(74113);
    }

    /* Access modifiers changed, original: protected|final */
    public final OnClickListener bvy() {
        return this.mjE;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(74114);
        if (i == 0 && -1 == i2) {
            finish();
            AppMethodBeat.o(74114);
            return;
        }
        super.onActivityResult(i, i2, intent);
        AppMethodBeat.o(74114);
    }

    public void onDestroy() {
        AppMethodBeat.i(74115);
        super.onDestroy();
        if (this.mjB != null) {
            this.mjB.finish();
        }
        AppMethodBeat.o(74115);
    }

    static /* synthetic */ void a(FavSelectUI favSelectUI, Intent intent) {
        AppMethodBeat.i(74116);
        intent.putExtra("key_to_user", favSelectUI.toUser);
        intent.putExtra("key_fav_item_id", favSelectUI.mjA);
        intent.putExtra("key_search_type", 1);
        intent.putExtra("key_enter_fav_search_from", 1);
        Bundle bundle = null;
        if (VERSION.SDK_INT >= 21) {
            bundle = ActivityOptions.makeSceneTransitionAnimation(favSelectUI, new Pair[0]).toBundle();
        }
        com.tencent.mm.plugin.fav.a.b.a(favSelectUI.mController.ylL, ".ui.FavSearchUI", intent, 0, bundle);
        AppMethodBeat.o(74116);
    }
}
