package com.tencent.mm.plugin.fav.ui.detail;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.nr;
import com.tencent.mm.model.v;
import com.tencent.mm.platformtools.q;
import com.tencent.mm.plugin.fav.a.ae;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.fav.a.k;
import com.tencent.mm.plugin.fav.a.p;
import com.tencent.mm.plugin.fav.ui.i;
import com.tencent.mm.pluginsdk.f;
import com.tencent.mm.protocal.protobuf.aar;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.tools.j;
import com.tencent.mm.ui.widget.MMLoadScrollView;
import com.tencent.mm.ui.widget.a.d;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

public class FavoriteImgDetailUI extends BaseFavDetailReportUI implements p {
    private int aUQ = 0;
    private c mip = new c<nr>() {
        {
            AppMethodBeat.i(74375);
            this.xxI = nr.class.getName().hashCode();
            AppMethodBeat.o(74375);
        }

        public final /* synthetic */ boolean a(b bVar) {
            AppMethodBeat.i(74376);
            nr nrVar = (nr) bVar;
            String str = nrVar.cJX.filePath;
            a aVar = null;
            for (a aVar2 : FavoriteImgDetailUI.this.mmk.values()) {
                a aVar22;
                if (!str.equals(com.tencent.mm.plugin.fav.a.b.b(aVar22.cAv))) {
                    aVar22 = aVar;
                }
                aVar = aVar22;
            }
            if (aVar != null) {
                aVar.mmw = bo.bc(nrVar.cJX.result, "");
                aVar.cvn = nrVar.cJX.cvn;
                aVar.cvo = nrVar.cJX.cvo;
                if (!bo.isNullOrNil(aVar.mmw) && aVar.hPs.rBk.isShowing()) {
                    FavoriteImgDetailUI.a(FavoriteImgDetailUI.this, aVar);
                }
            }
            AppMethodBeat.o(74376);
            return true;
        }
    };
    private OnClickListener mjE = new OnClickListener() {
        public final void onClick(View view) {
            AppMethodBeat.i(74385);
            Intent intent = new Intent();
            intent.putExtra("key_detail_info_id", FavoriteImgDetailUI.this.mmj.field_localId);
            intent.putExtra("key_detail_data_id", ((aar) view.getTag()).mnd);
            com.tencent.mm.plugin.fav.a.b.b(FavoriteImgDetailUI.this.mController.ylL, ".ui.FavImgGalleryUI", intent);
            com.tencent.mm.plugin.fav.a.h.a aVar = FavoriteImgDetailUI.this.mlz;
            aVar.meY++;
            AppMethodBeat.o(74385);
        }
    };
    private OnLongClickListener mlV = new OnLongClickListener() {
        public final boolean onLongClick(View view) {
            AppMethodBeat.i(74386);
            a aVar = (a) FavoriteImgDetailUI.this.mmk.get(((aar) view.getTag()).mnd);
            FavoriteImgDetailUI.a(FavoriteImgDetailUI.this, aVar);
            if (!aVar.mmv) {
                FavoriteImgDetailUI.b(aVar);
            }
            AppMethodBeat.o(74386);
            return true;
        }
    };
    private LinearLayout mmi;
    private g mmj;
    private HashMap<String, a> mmk = new HashMap();
    private Bitmap mml;
    private boolean mmm = true;

    class a {
        aar cAv;
        ImageView cAw;
        int cvn;
        int cvo;
        j hPs;
        boolean mmv;
        String mmw;

        private a() {
            AppMethodBeat.i(74391);
            this.hPs = new j(FavoriteImgDetailUI.this.mController.ylL);
            this.mmv = false;
            this.mmw = null;
            this.cvn = 0;
            this.cvo = 0;
            AppMethodBeat.o(74391);
        }

        /* synthetic */ a(FavoriteImgDetailUI favoriteImgDetailUI, byte b) {
            this();
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public FavoriteImgDetailUI() {
        AppMethodBeat.i(74392);
        AppMethodBeat.o(74392);
    }

    /* Access modifiers changed, original: protected|final */
    public final MMLoadScrollView bwd() {
        AppMethodBeat.i(74393);
        MMLoadScrollView mMLoadScrollView = (MMLoadScrollView) findViewById(R.id.bsd);
        AppMethodBeat.o(74393);
        return mMLoadScrollView;
    }

    public final int getLayoutId() {
        return R.layout.z8;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(74394);
        f.m(this);
        super.onCreate(bundle);
        bwn();
        this.mmi = (LinearLayout) findViewById(R.id.bse);
        final long longExtra = getIntent().getLongExtra("key_detail_info_id", -1);
        this.mmj = ((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavItemInfoStorage().iE(longExtra);
        if (this.mmj == null) {
            finish();
            AppMethodBeat.o(74394);
            return;
        }
        F(this.mmj);
        Iterator it = this.mmj.field_favProto.wiv.iterator();
        int i = 0;
        while (it.hasNext()) {
            aar aar = (aar) it.next();
            ab.d("MicroMsg.FavoriteImgDetailUI", "index[%d], dataid[%s]", Integer.valueOf(i), aar.mnd);
            a aVar = new a(this, (byte) 0);
            aVar.cAv = aar;
            int i2 = i + 1;
            ImageView imageView = new ImageView(this.mController.ylL);
            int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.nc);
            LayoutParams layoutParams = new LayoutParams(-1, -2);
            if (i > 0) {
                layoutParams.topMargin = dimensionPixelSize;
            }
            this.mmi.addView(imageView, layoutParams);
            imageView.setTag(aar);
            i = dimensionPixelSize / 2;
            imageView.setScaleType(ScaleType.CENTER_INSIDE);
            imageView.setPadding(i, i, i, i);
            imageView.setMinimumWidth(com.tencent.mm.bz.a.fromDPToPix(this.mController.ylL, 50));
            imageView.setMinimumHeight(com.tencent.mm.bz.a.fromDPToPix(this.mController.ylL, 50));
            imageView.setImageResource(R.raw.fav_list_img_default);
            imageView.setOnClickListener(this.mjE);
            imageView.setOnLongClickListener(this.mlV);
            imageView.setOnTouchListener(new OnTouchListener() {
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    AppMethodBeat.i(74389);
                    switch (motionEvent.getAction()) {
                        case 0:
                            v.b y = v.Zp().y("basescanui@datacenter", true);
                            y.j("key_basescanui_screen_x", Integer.valueOf((int) motionEvent.getRawX()));
                            y.j("key_basescanui_screen_y", Integer.valueOf((int) motionEvent.getRawY()));
                            break;
                    }
                    AppMethodBeat.o(74389);
                    return false;
                }
            });
            aVar.cAw = imageView;
            this.mmk.put(aar.mnd, aVar);
            a(aVar);
            if (aar.whh != 0) {
                this.mmm = false;
            }
            i = i2;
        }
        setMMTitle(getString(R.string.bns));
        a.a(this, this.mmj);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(74374);
                FavoriteImgDetailUI.this.finish();
                AppMethodBeat.o(74374);
                return true;
            }
        });
        addIconOptionMenu(0, R.string.ewm, R.raw.actionbar_icon_dark_more, new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(74381);
                d dVar = new d(FavoriteImgDetailUI.this.mController.ylL, 1, false);
                dVar.rBl = new n.c() {
                    public final void a(l lVar) {
                        AppMethodBeat.i(74377);
                        if (FavoriteImgDetailUI.this.mmm) {
                            lVar.e(2, FavoriteImgDetailUI.this.getString(R.string.bri));
                        }
                        lVar.e(3, FavoriteImgDetailUI.this.getString(R.string.br7));
                        lVar.e(0, FavoriteImgDetailUI.this.getString(R.string.bo8));
                        lVar.e(1, FavoriteImgDetailUI.this.mController.ylL.getString(R.string.p4));
                        AppMethodBeat.o(74377);
                    }
                };
                dVar.rBm = new n.d() {
                    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                        AppMethodBeat.i(74380);
                        Intent intent;
                        com.tencent.mm.plugin.fav.a.h.a aVar;
                        switch (menuItem.getItemId()) {
                            case 0:
                                intent = new Intent();
                                intent.putExtra("key_fav_scene", 2);
                                intent.putExtra("key_fav_item_id", FavoriteImgDetailUI.this.mmj.field_localId);
                                com.tencent.mm.plugin.fav.a.b.b(FavoriteImgDetailUI.this.mController.ylL, ".ui.FavTagEditUI", intent);
                                aVar = FavoriteImgDetailUI.this.mlz;
                                aVar.mfc++;
                                AppMethodBeat.o(74380);
                                return;
                            case 1:
                                h.a(FavoriteImgDetailUI.this.mController.ylL, FavoriteImgDetailUI.this.getString(R.string.p5), "", new DialogInterface.OnClickListener() {
                                    public final void onClick(DialogInterface dialogInterface, int i) {
                                        AppMethodBeat.i(74379);
                                        final com.tencent.mm.ui.base.p b = h.b(FavoriteImgDetailUI.this.mController.ylL, FavoriteImgDetailUI.this.getString(R.string.p5), false, null);
                                        com.tencent.mm.plugin.fav.a.b.a(FavoriteImgDetailUI.this.mmj.field_localId, new Runnable() {
                                            public final void run() {
                                                AppMethodBeat.i(74378);
                                                FavoriteImgDetailUI.this.mlz.mfd = true;
                                                b.dismiss();
                                                ab.d("MicroMsg.FavoriteImgDetailUI", "do del, local id %d", Long.valueOf(FavoriteImgDetailUI.this.mmj.field_localId));
                                                FavoriteImgDetailUI.this.finish();
                                                AppMethodBeat.o(74378);
                                            }
                                        });
                                        AppMethodBeat.o(74379);
                                    }
                                }, null);
                                AppMethodBeat.o(74380);
                                return;
                            case 2:
                                intent = new Intent();
                                intent.putExtra("Select_Conv_Type", 3);
                                intent.putExtra("scene_from", 1);
                                intent.putExtra("mutil_select_is_ret", true);
                                intent.putExtra("select_fav_local_id", FavoriteImgDetailUI.this.mmj.field_localId);
                                com.tencent.mm.bp.d.b(FavoriteImgDetailUI.this, ".ui.transmit.SelectConversationUI", intent, 1);
                                com.tencent.mm.plugin.fav.a.h.j(FavoriteImgDetailUI.this.mmj.field_localId, 1, 0);
                                aVar = FavoriteImgDetailUI.this.mlz;
                                aVar.meZ++;
                                AppMethodBeat.o(74380);
                                return;
                            case 3:
                                com.tencent.mm.plugin.fav.ui.g.a(FavoriteImgDetailUI.this, longExtra, FavoriteImgDetailUI.this.mlz);
                                break;
                        }
                        AppMethodBeat.o(74380);
                    }
                };
                dVar.cpD();
                AppMethodBeat.o(74381);
                return true;
            }
        });
        f.n(this);
        ((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavCdnStorage().a(this);
        com.tencent.mm.sdk.b.a.xxA.c(this.mip);
        AppMethodBeat.o(74394);
    }

    public void onResume() {
        AppMethodBeat.i(74395);
        super.onResume();
        for (Entry value : this.mmk.entrySet()) {
            a((a) value.getValue());
        }
        AppMethodBeat.o(74395);
    }

    public void onDestroy() {
        AppMethodBeat.i(74396);
        ((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavCdnStorage().b(this);
        com.tencent.mm.sdk.b.a.xxA.d(this.mip);
        super.onDestroy();
        AppMethodBeat.o(74396);
    }

    private void bwn() {
        DisplayMetrics displayMetrics;
        AppMethodBeat.i(74397);
        if (ah.getResources() != null) {
            displayMetrics = ah.getResources().getDisplayMetrics();
        } else {
            displayMetrics = getResources().getDisplayMetrics();
        }
        this.aUQ = displayMetrics.widthPixels - (getResources().getDimensionPixelOffset(R.dimen.hs) * 2);
        this.aUQ = Math.max(this.aUQ, 0);
        ab.d("MicroMsg.FavoriteImgDetailUI", "update display width %d", Integer.valueOf(this.aUQ));
        AppMethodBeat.o(74397);
    }

    public void onConfigurationChanged(Configuration configuration) {
        AppMethodBeat.i(74398);
        super.onConfigurationChanged(configuration);
        bwn();
        for (Entry value : this.mmk.entrySet()) {
            a((a) value.getValue());
        }
        AppMethodBeat.o(74398);
    }

    private void a(final a aVar) {
        AppMethodBeat.i(74399);
        com.tencent.mm.kernel.g.RS().aa(new Runnable() {
            public final void run() {
                AppMethodBeat.i(74384);
                Bitmap a = com.tencent.mm.plugin.fav.ui.l.a(aVar.cAv, FavoriteImgDetailUI.this.mmj, false);
                if (a == null) {
                    ab.d("MicroMsg.FavoriteImgDetailUI", "get big img fail");
                    a = FavoriteImgDetailUI.a(FavoriteImgDetailUI.this, aVar.cAv);
                }
                al.d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(74382);
                        FavoriteImgDetailUI.a(FavoriteImgDetailUI.this, aVar, a);
                        AppMethodBeat.o(74382);
                    }

                    public final String toString() {
                        AppMethodBeat.i(74383);
                        String str = super.toString() + "|renderView";
                        AppMethodBeat.o(74383);
                        return str;
                    }
                });
                AppMethodBeat.o(74384);
            }
        });
        AppMethodBeat.o(74399);
    }

    public static void a(String str, String str2, Context context) {
        AppMethodBeat.i(74400);
        if (bo.isNullOrNil(str)) {
            ab.w("MicroMsg.FavoriteImgDetailUI", "save image fail, path is null");
            AppMethodBeat.o(74400);
            return;
        }
        if (!q.a(str, context, R.string.b3r)) {
            Toast.makeText(context, str2, 1).show();
        }
        AppMethodBeat.o(74400);
    }

    private Bitmap l(aar aar) {
        boolean z = true;
        AppMethodBeat.i(74401);
        Bitmap a = com.tencent.mm.plugin.fav.ui.l.a(aar, this.mmj);
        String str = "MicroMsg.FavoriteImgDetailUI";
        String str2 = "get thumb ok ? %B";
        Object[] objArr = new Object[1];
        if (a == null) {
            z = false;
        }
        objArr[0] = Boolean.valueOf(z);
        ab.d(str, str2, objArr);
        if (a != null) {
            AppMethodBeat.o(74401);
            return a;
        }
        if (this.mml == null) {
            this.mml = com.tencent.mm.compatible.g.a.decodeResource(getResources(), R.raw.fav_list_img_default);
        }
        Bitmap bitmap = this.mml;
        AppMethodBeat.o(74401);
        return bitmap;
    }

    public final void d(com.tencent.mm.plugin.fav.a.c cVar) {
        AppMethodBeat.i(74402);
        if (cVar == null || !cVar.isFinished()) {
            AppMethodBeat.o(74402);
            return;
        }
        ab.d("MicroMsg.FavoriteImgDetailUI", "on cdn status change, dataid[%s]", cVar.field_dataId);
        a aVar = (a) this.mmk.get(cVar.field_dataId);
        if (aVar != null) {
            a(aVar);
        }
        AppMethodBeat.o(74402);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(74403);
        if (1 == i) {
            if (-1 != i2) {
                AppMethodBeat.o(74403);
                return;
            }
            k kVar = new k();
            if (k.u(this.mmj)) {
                h.bQ(this.mController.ylL, getString(R.string.ah));
                AppMethodBeat.o(74403);
                return;
            }
            String stringExtra = intent.getStringExtra("Select_Conv_User");
            String stringExtra2 = intent.getStringExtra("custom_send_text");
            ab.d("MicroMsg.FavoriteImgDetailUI", "select %s for sending", stringExtra);
            final com.tencent.mm.ui.base.p b = h.b(this.mController.ylL, getString(R.string.bp2), false, null);
            i.a(this.mController.ylL, stringExtra, stringExtra2, this.mmj, new Runnable() {
                public final void run() {
                    AppMethodBeat.i(74390);
                    b.dismiss();
                    com.tencent.mm.ui.widget.snackbar.b.i(FavoriteImgDetailUI.this, FavoriteImgDetailUI.this.getString(R.string.bnf));
                    AppMethodBeat.o(74390);
                }
            });
        }
        super.onActivityResult(i, i2, intent);
        AppMethodBeat.o(74403);
    }
}
