package com.tencent.mm.plugin.fav.ui;

import android.annotation.SuppressLint;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.Pair;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnCreateContextMenuListener;
import android.view.View.OnTouchListener;
import android.view.ViewStub;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ImageButton;
import android.widget.Toast;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.g.a.ld;
import com.tencent.mm.g.a.le;
import com.tencent.mm.m.b;
import com.tencent.mm.model.n;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.fav.a.ae;
import com.tencent.mm.plugin.fav.a.d;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.fav.a.i;
import com.tencent.mm.plugin.fav.a.k;
import com.tencent.mm.plugin.fav.a.y;
import com.tencent.mm.plugin.fav.ui.d.a.c;
import com.tencent.mm.plugin.fav.ui.widget.c.a;
import com.tencent.mm.protocal.protobuf.aar;
import com.tencent.mm.protocal.protobuf.aay;
import com.tencent.mm.protocal.protobuf.abh;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.tools.j;
import com.tencent.mm.vfs.e;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class FavoriteIndexUI extends FavBaseUI implements c, a {
    private static final long mky = ((long) b.Nc());
    private j contextMenuHelper;
    private OnClickListener mjE = new OnClickListener() {
        public final void onClick(View view) {
            AppMethodBeat.i(74222);
            int intValue = ((Integer) view.getTag()).intValue();
            Intent intent = new Intent();
            intent.putExtra("key_enter_fav_search_from", 0);
            intent.putExtra("key_preset_search_type", intValue);
            FavoriteIndexUI.a(FavoriteIndexUI.this, intent);
            AppMethodBeat.o(74222);
        }
    };
    private com.tencent.mm.plugin.fav.ui.a.b mkA;
    private com.tencent.mm.plugin.fav.ui.widget.b mkB;
    private g mkC;
    private int[] mkD = new int[2];
    private f mkE = new f() {
        public final void onSceneEnd(int i, int i2, String str, m mVar) {
            AppMethodBeat.i(74245);
            ab.i("MicroMsg.FavoriteIndexUI", "onUsedCapacityChanged");
            FavoriteIndexUI.this.mhw.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(74244);
                    FavoriteIndexUI.this.mhw.bwA();
                    AppMethodBeat.o(74244);
                }
            });
            AppMethodBeat.o(74245);
        }
    };
    private OnItemLongClickListener mkF = new OnItemLongClickListener() {
        public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
            AppMethodBeat.i(74246);
            if (i < FavoriteIndexUI.this.mhs.getHeaderViewsCount()) {
                ab.w("MicroMsg.FavoriteIndexUI", "on header view long click, ignore");
                AppMethodBeat.o(74246);
            } else {
                FavoriteIndexUI.a(FavoriteIndexUI.this, view, i, j, FavoriteIndexUI.this.mkD);
                AppMethodBeat.o(74246);
            }
            return true;
        }
    };
    private g mkG;
    private int mkz = 0;
    private long startTime = 0;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public FavoriteIndexUI() {
        AppMethodBeat.i(74252);
        AppMethodBeat.o(74252);
    }

    static /* synthetic */ void b(FavoriteIndexUI favoriteIndexUI) {
        AppMethodBeat.i(74276);
        favoriteIndexUI.bvQ();
        AppMethodBeat.o(74276);
    }

    static {
        AppMethodBeat.i(74283);
        AppMethodBeat.o(74283);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(74253);
        this.mhz = this;
        ab.i("MicroMsg.FavoriteIndexUI", "onCreate favoriteindex");
        super.onCreate(bundle);
        if (((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavItemInfoStorage().buR() == null) {
            ab.e("MicroMsg.FavoriteIndexUI", "onCreate favoriteindex, but favorite db is null ,return");
            finish();
            AppMethodBeat.o(74253);
            return;
        }
        ((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavCdnService().hf(false);
        setMMTitle((int) R.string.bp8);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(74219);
                if (FavoriteIndexUI.this.mkA.mlh) {
                    FavoriteIndexUI.b(FavoriteIndexUI.this);
                    AppMethodBeat.o(74219);
                } else {
                    FavoriteIndexUI.this.finish();
                    AppMethodBeat.o(74219);
                }
                return true;
            }
        });
        this.mhs.setOnItemLongClickListener(this.mkF);
        this.mhs.setOnTouchListener(new OnTouchListener() {
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(74238);
                switch (motionEvent.getAction()) {
                    case 0:
                        FavoriteIndexUI.this.mkD[0] = (int) motionEvent.getRawX();
                        FavoriteIndexUI.this.mkD[1] = (int) motionEvent.getRawY();
                        break;
                }
                AppMethodBeat.o(74238);
                return false;
            }
        });
        com.tencent.mm.kernel.g.Rg().a(438, this.mkE);
        com.tencent.mm.kernel.g.Rg().a(401, this.mkE);
        this.contextMenuHelper = new j(this);
        addIconOptionMenu(11, R.string.bn2, R.raw.actionbar_icon_dark_add, new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(74221);
                FavoriteIndexUI.g(FavoriteIndexUI.this);
                AppMethodBeat.o(74221);
                return true;
            }
        });
        this.mkB = new com.tencent.mm.plugin.fav.ui.widget.b();
        com.tencent.mm.plugin.fav.ui.widget.b bVar = this.mkB;
        View findViewById = findViewById(R.id.bpd);
        bVar.mpz = false;
        bVar.mpA = findViewById;
        this.mkB.mpH = new com.tencent.mm.plugin.fav.ui.widget.b.a() {
            public final void bvS() {
                AppMethodBeat.i(74225);
                if (FavoriteIndexUI.a(FavoriteIndexUI.this.mkA.hk(false), FavoriteIndexUI.this, new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.i(74223);
                        FavoriteIndexUI.a(FavoriteIndexUI.this, 4105);
                        AppMethodBeat.o(74223);
                    }
                })) {
                    FavoriteIndexUI.a(FavoriteIndexUI.this, 4105);
                    AppMethodBeat.o(74225);
                    return;
                }
                AppMethodBeat.o(74225);
            }

            public final void bvB() {
                AppMethodBeat.i(74226);
                h.a(FavoriteIndexUI.this.mController.ylL, FavoriteIndexUI.this.getString(R.string.bnq), "", new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.i(74224);
                        FavoriteIndexUI.a(FavoriteIndexUI.this, FavoriteIndexUI.this.mkA.hk(true));
                        com.tencent.mm.plugin.report.service.h.pYm.e(11125, Integer.valueOf(r0.size()), Integer.valueOf(3));
                        if (FavoriteIndexUI.this.mkA.mlh) {
                            FavoriteIndexUI.b(FavoriteIndexUI.this);
                        }
                        AppMethodBeat.o(74224);
                    }
                }, null);
                AppMethodBeat.o(74226);
            }

            public final void bvT() {
                AppMethodBeat.i(74227);
                if (FavoriteIndexUI.this.mkA.bwb() <= 0) {
                    AppMethodBeat.o(74227);
                } else if (FavoriteIndexUI.this.mkA.bwb() > 1) {
                    Intent intent = new Intent();
                    intent.putExtra("key_fav_scene", 3);
                    com.tencent.mm.plugin.fav.a.b.a(FavoriteIndexUI.this.mController.ylL, ".ui.FavTagEditUI", intent, 4104);
                    i.LK("FavTagEditUI");
                    AppMethodBeat.o(74227);
                } else {
                    g gVar = (g) FavoriteIndexUI.this.mkA.hk(false).get(0);
                    Intent intent2 = new Intent();
                    intent2.putExtra("key_fav_scene", 3);
                    intent2.putExtra("key_fav_item_id", gVar.field_localId);
                    com.tencent.mm.plugin.fav.a.b.b(FavoriteIndexUI.this.mController.ylL, ".ui.FavTagEditUI", intent2);
                    i.LK("FavTagEditUI");
                    if (FavoriteIndexUI.this.mkA.mlh) {
                        FavoriteIndexUI.b(FavoriteIndexUI.this);
                    }
                    AppMethodBeat.o(74227);
                }
            }
        };
        com.tencent.mm.kernel.g.RS().aa(new Runnable() {
            public final void run() {
                AppMethodBeat.i(74243);
                long currentTimeMillis = System.currentTimeMillis();
                List buY = ((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavItemInfoStorage().buY();
                if (buY != null) {
                    ab.i("MicroMsg.FavoriteIndexUI", "initInvalidFavItem getInvalid favitems , size = %d,start time = %s", Integer.valueOf(buY.size()), Long.valueOf(currentTimeMillis));
                    if (buY.size() == 0) {
                        AppMethodBeat.o(74243);
                        return;
                    }
                    int size = buY.size();
                    for (int i = 0; i < size; i++) {
                        ((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavItemInfoStorage().z((g) buY.get(i));
                    }
                    ab.i("MicroMsg.FavoriteIndexUI", "initInvalidFavItem  cost time = %s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                }
                AppMethodBeat.o(74243);
            }
        });
        d.bur().a(null);
        c.bvD();
        i.start();
        AppMethodBeat.o(74253);
    }

    /* Access modifiers changed, original: protected|final */
    public final void bvz() {
        AppMethodBeat.i(74254);
        super.bvz();
        this.fbD.post(new Runnable() {
            public final void run() {
            }
        });
        AppMethodBeat.o(74254);
    }

    public void onDestroy() {
        AppMethodBeat.i(74255);
        super.onDestroy();
        if (((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavItemInfoStorage().buR() == null) {
            AppMethodBeat.o(74255);
            return;
        }
        ((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavCdnService().hf(true);
        if (this.mkA != null) {
            this.mkA.finish();
        }
        ld ldVar = new ld();
        ldVar.cGU.type = 12;
        com.tencent.mm.sdk.b.a.xxA.m(ldVar);
        com.tencent.mm.kernel.g.Rg().b(438, this.mkE);
        com.tencent.mm.kernel.g.Rg().b(401, this.mkE);
        i.end();
        c.bvC();
        AppMethodBeat.o(74255);
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        AppMethodBeat.i(74256);
        if (4 == i && this.mkA.mlh) {
            bvQ();
            AppMethodBeat.o(74256);
            return true;
        }
        boolean onKeyUp = super.onKeyUp(i, keyEvent);
        AppMethodBeat.o(74256);
        return onKeyUp;
    }

    private void bvQ() {
        AppMethodBeat.i(74257);
        this.mkA.a(false, null);
        this.mhs.setOnItemLongClickListener(this.mkF);
        showOptionMenu(11, true);
        this.mkB.hide();
        AppMethodBeat.o(74257);
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        AppMethodBeat.i(74258);
        switch (this.mkz) {
            case 0:
                if (this.mkA != null) {
                    this.mkA.onItemClick(adapterView, view, i, j);
                    com.tencent.mm.plugin.fav.ui.d.a.b bVar = (com.tencent.mm.plugin.fav.ui.d.a.b) view.getTag();
                    if (bVar != null) {
                        if (bVar.mgf != null) {
                            ab.i("MicroMsg.FavoriteIndexUI", "click type is %d", Integer.valueOf(bVar.mgf.field_type));
                            com.tencent.mm.plugin.report.service.h.pYm.e(12746, Integer.valueOf(bVar.mgf.field_type), Integer.valueOf(0), Integer.valueOf(i - 1));
                            break;
                        }
                        ab.w("MicroMsg.FavoriteIndexUI", "on item click, info is null..");
                        AppMethodBeat.o(74258);
                        return;
                    }
                    ab.w("MicroMsg.FavoriteIndexUI", "on item click, holder is null..");
                    AppMethodBeat.o(74258);
                    return;
                }
                break;
        }
        AppMethodBeat.o(74258);
    }

    public final com.tencent.mm.plugin.fav.ui.a.a bvu() {
        AppMethodBeat.i(74259);
        if (this.mkA == null) {
            this.mkA = new com.tencent.mm.plugin.fav.ui.a.b(this.mhy, false);
            this.mkA.a((com.tencent.mm.plugin.fav.ui.a.a.a) new com.tencent.mm.plugin.fav.ui.a.a.a() {
                public final void bvU() {
                    AppMethodBeat.i(74250);
                    FavoriteIndexUI.this.mhw.hn(true);
                    AppMethodBeat.o(74250);
                }
            });
            this.mkA.mlo = this;
            this.mkA.scene = 1;
            this.mkA.mlr = this.mhs;
        }
        com.tencent.mm.plugin.fav.ui.a.b bVar = this.mkA;
        AppMethodBeat.o(74259);
        return bVar;
    }

    /* Access modifiers changed, original: protected|final */
    public final void bvv() {
        AppMethodBeat.i(74260);
        this.mhw.post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(74251);
                FavoriteIndexUI.this.mhw.bwA();
                AppMethodBeat.o(74251);
            }
        });
        AppMethodBeat.o(74260);
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean bvw() {
        int buS;
        AppMethodBeat.i(74261);
        switch (this.mkz) {
            case 3:
                buS = ((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavItemInfoStorage().buS();
                break;
            default:
                buS = ((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavItemInfoStorage().getCount();
                break;
        }
        if (buS > 0) {
            AppMethodBeat.o(74261);
            return true;
        }
        AppMethodBeat.o(74261);
        return false;
    }

    /* Access modifiers changed, original: protected|final */
    @SuppressLint({"ResourceType"})
    public final void bvx() {
        AppMethodBeat.i(74262);
        switch (this.mkz) {
            case 3:
                this.mht.setCompoundDrawablesWithIntrinsicBounds(0, R.raw.fav_list_img_default, 0, 0);
                this.mht.setCompoundDrawablePadding(com.tencent.mm.bz.a.fromDPToPix(this.mController.ylL, 10));
                this.mht.setText(R.string.bob);
                AppMethodBeat.o(74262);
                return;
            default:
                this.mht.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.adw, 0, 0);
                this.mht.setCompoundDrawablePadding(com.tencent.mm.bz.a.fromDPToPix(this.mController.ylL, 10));
                this.mht.setText(R.string.boa);
                AppMethodBeat.o(74262);
                return;
        }
    }

    public void onResume() {
        AppMethodBeat.i(74263);
        long currentTimeMillis = System.currentTimeMillis();
        super.onResume();
        this.fbD.post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(74220);
                FavoriteIndexUI.this.mhw.bwA();
                AppMethodBeat.o(74220);
            }
        });
        ab.d("MicroMsg.FavoriteIndexUI", "on resume use %d ms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        i.LK(getClass().getSimpleName());
        AppMethodBeat.o(74263);
    }

    public void onPause() {
        AppMethodBeat.i(74264);
        super.onPause();
        i.LL(getClass().getSimpleName());
        AppMethodBeat.o(74264);
    }

    /* Access modifiers changed, original: protected|final */
    public final OnClickListener bvy() {
        return this.mjE;
    }

    /* Access modifiers changed, original: protected|final */
    public final void initHeaderView() {
        AppMethodBeat.i(74265);
        super.initHeaderView();
        this.mhw.hn(false);
        AppMethodBeat.o(74265);
    }

    private void a(List<g> list, String str, String str2) {
        AppMethodBeat.i(74266);
        if (list == null || list.isEmpty()) {
            AppMethodBeat.o(74266);
        } else if (bo.isNullOrNil(str2)) {
            AppMethodBeat.o(74266);
        } else {
            boolean kH = t.kH(str2);
            k kVar = new k();
            List<g> linkedList = new LinkedList();
            for (g gVar : list) {
                if (!kVar.t(gVar)) {
                    com.tencent.mm.plugin.fav.a.h.j(gVar.field_localId, 1, 0);
                    linkedList.add(gVar);
                    com.tencent.mm.plugin.fav.a.m.a(kH ? com.tencent.mm.plugin.fav.a.m.c.Chatroom : com.tencent.mm.plugin.fav.a.m.c.Chat, gVar, com.tencent.mm.plugin.fav.a.m.d.Samll, kH ? n.mA(str2) : 0);
                }
            }
            if (linkedList.isEmpty()) {
                ab.i("MicroMsg.FavoriteIndexUI", "after filter, nothing");
                h.bQ(getApplicationContext(), getString(R.string.br6));
                AppMethodBeat.o(74266);
                return;
            }
            final p b = h.b(this.mController.ylL, getString(R.string.bp2), false, null);
            i.a(this.mController.ylL, str2, str, (List) linkedList, new Runnable() {
                public final void run() {
                    AppMethodBeat.i(74234);
                    b.dismiss();
                    com.tencent.mm.ui.widget.snackbar.b.i(FavoriteIndexUI.this, FavoriteIndexUI.this.getString(R.string.bnf));
                    AppMethodBeat.o(74234);
                }
            });
            for (g gVar2 : linkedList) {
                if (gVar2 != null && gVar2.field_type == 5) {
                    String str3 = "";
                    if (gVar2.field_favProto.whA != null) {
                        str3 = gVar2.field_favProto.whA.wiY;
                    }
                    if (gVar2.field_favProto.wit != null && bo.isNullOrNil(r1)) {
                        str3 = gVar2.field_favProto.wit.link;
                    }
                    if (!bo.isNullOrNil(str3)) {
                        ab.d("MicroMsg.FavoriteIndexUI", "report(%s), url : %s, clickTimestamp : %d, scene : %d, actionType : %d, flag : %d", Integer.valueOf(13378), str3, Long.valueOf(this.startTime), Integer.valueOf(4), Integer.valueOf(1), Integer.valueOf(1));
                        String str4 = "";
                        try {
                            str4 = URLEncoder.encode(str3, "UTF-8");
                        } catch (UnsupportedEncodingException e) {
                            ab.printErrStackTrace("MicroMsg.FavoriteIndexUI", e, "", new Object[0]);
                        }
                        com.tencent.mm.plugin.report.service.h.pYm.e(13378, str4, Long.valueOf(this.startTime), Integer.valueOf(4), Integer.valueOf(1), Integer.valueOf(1));
                    }
                }
            }
            com.tencent.mm.plugin.report.service.h.pYm.e(11125, Integer.valueOf(linkedList.size()), Integer.valueOf(1));
            AppMethodBeat.o(74266);
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        String str;
        AppMethodBeat.i(74267);
        super.onActivityResult(i, i2, intent);
        switch (i) {
            case 4105:
            case 4106:
                i.LL(".ui.transmit.SelectConversationUI");
                break;
        }
        ab.i("MicroMsg.FavoriteIndexUI", "onActivityResult reqCode: %d, retCod: %d", Integer.valueOf(i), Integer.valueOf(i2));
        String str2;
        if (i2 != -1) {
            if ((this.mkG != null && this.mkG.field_type == 5) || (this.mkC != null && this.mkC.field_type == 5)) {
                str2 = "";
                if (this.mkC == null || this.mkC.field_favProto.wit == null) {
                    if (this.mkG.field_favProto.whA != null) {
                        str2 = this.mkG.field_favProto.whA.wiY;
                    }
                    if (this.mkG.field_favProto.wit != null && bo.isNullOrNil(str2)) {
                        str2 = this.mkG.field_favProto.wit.link;
                    }
                } else {
                    str2 = this.mkC.field_favProto.wit.link;
                }
                if (!bo.isNullOrNil(str2)) {
                    ab.d("MicroMsg.FavoriteIndexUI", "report(%s), url : %s, clickTimestamp : %d, scene : %d, actionType : %d, flag : %d", Integer.valueOf(13378), str2, Long.valueOf(this.startTime), Integer.valueOf(4), Integer.valueOf(1), Integer.valueOf(3));
                    str = "";
                    try {
                        str2 = URLEncoder.encode(str2, "UTF-8");
                    } catch (UnsupportedEncodingException e) {
                        ab.printErrStackTrace("MicroMsg.FavoriteIndexUI", e, "", new Object[0]);
                        str2 = str;
                    }
                    com.tencent.mm.plugin.report.service.h.pYm.e(13378, str2, Long.valueOf(this.startTime), Integer.valueOf(4), Integer.valueOf(1), Integer.valueOf(3));
                }
            }
            AppMethodBeat.o(74267);
            return;
        }
        int i3 = 2;
        str = intent.getStringExtra("custom_send_text");
        switch (i) {
            case 4096:
                final ArrayList stringArrayListExtra = intent.getStringArrayListExtra("CropImage_OutputPath_List");
                if (stringArrayListExtra != null && stringArrayListExtra.size() != 0) {
                    i3 = 0;
                    this.mcy.post(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(74236);
                            FavoriteIndexUI.this.mhp = true;
                            h.bO(stringArrayListExtra);
                            AppMethodBeat.o(74236);
                        }
                    });
                    break;
                }
                ab.e("MicroMsg.FavoriteIndexUI", "onActivityResult pathList is null or nil");
                AppMethodBeat.o(74267);
                return;
                break;
            case 4097:
                final double doubleExtra = intent.getDoubleExtra("kwebmap_slat", 0.0d);
                final double doubleExtra2 = intent.getDoubleExtra("kwebmap_lng", 0.0d);
                final int intExtra = intent.getIntExtra("kwebmap_scale", 0);
                final String bc = bo.bc(intent.getStringExtra("Kwebmap_locaion"), "");
                final CharSequence charSequenceExtra = intent.getCharSequenceExtra("kRemark");
                final String stringExtra = intent.getStringExtra("kPoiName");
                final ArrayList stringArrayListExtra2 = intent.getStringArrayListExtra("kTags");
                this.mcy.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(74237);
                        FavoriteIndexUI.this.mhp = true;
                        double d = doubleExtra;
                        double d2 = doubleExtra2;
                        int i = intExtra;
                        String str = bc;
                        CharSequence charSequence = charSequenceExtra;
                        String str2 = stringExtra;
                        ArrayList<String> arrayList = stringArrayListExtra2;
                        aay aay = new aay();
                        aay.alu(str);
                        aay.E(d);
                        aay.D(d2);
                        aay.LJ(i);
                        aay.alv(str2);
                        g gVar = new g();
                        gVar.field_type = 6;
                        gVar.field_sourceType = 6;
                        gVar.field_favProto.b(aay);
                        if (!(charSequence == null || bo.isNullOrNil(charSequence.toString()))) {
                            gVar.field_favProto.alA(charSequence.toString());
                            gVar.field_favProto.mj(bo.anU());
                            com.tencent.mm.plugin.report.service.h.pYm.e(10873, Integer.valueOf(6));
                        }
                        h.E(gVar);
                        if (!(arrayList == null || arrayList.isEmpty())) {
                            for (String LJ : arrayList) {
                                gVar.LJ(LJ);
                            }
                        }
                        b.B(gVar);
                        com.tencent.mm.plugin.report.service.h.pYm.e(10648, Integer.valueOf(3), Integer.valueOf(0));
                        com.tencent.mm.plugin.fav.a.b.it(gVar.field_localId);
                        long j = gVar.field_localId;
                        g iE = ((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavItemInfoStorage().iE(j);
                        if (!(iE == null || iE.field_favProto.why == null)) {
                            com.tencent.mm.plugin.fav.a.b.a(j, iE.field_favProto.why, "", "", new ArrayList(), FavoriteIndexUI.this.mController.ylL);
                        }
                        AppMethodBeat.o(74237);
                    }
                });
                i3 = 0;
                break;
            case 4098:
                str = com.tencent.mm.pluginsdk.ui.tools.n.h(getApplicationContext(), intent, com.tencent.mm.plugin.i.c.XW());
                if (str != null) {
                    Intent intent2 = new Intent();
                    intent2.putExtra("CropImageMode", 4);
                    intent2.putExtra("CropImage_Filter", true);
                    intent2.putExtra("CropImage_ImgPath", str);
                    intent2.setClassName(this.mController.ylL, "com.tencent.mm.ui.tools.CropImageNewUI");
                    startActivityForResult(intent2, 4099);
                    break;
                }
                ab.w("MicroMsg.FavoriteIndexUI", "take picture result path is null");
                AppMethodBeat.o(74267);
                return;
            case 4099:
                str = intent.getStringExtra("CropImage_OutputPath");
                if (str != null) {
                    i3 = 0;
                    final ArrayList arrayList = new ArrayList();
                    arrayList.add(str);
                    this.mcy.post(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(74235);
                            FavoriteIndexUI.this.mhp = true;
                            h.bO(arrayList);
                            AppMethodBeat.o(74235);
                        }
                    });
                    break;
                }
                ab.w("MicroMsg.FavoriteIndexUI", "crop picture resutl path is null");
                AppMethodBeat.o(74267);
                return;
            case 4100:
                str2 = intent.getStringExtra("choosed_file_path");
                if (!bo.isNullOrNil(str2)) {
                    com.tencent.mm.vfs.b bVar = new com.tencent.mm.vfs.b(str2);
                    if (bVar.exists()) {
                        if (bVar.length() < mky) {
                            Object obj;
                            if (bo.isNullOrNil(str2)) {
                                obj = null;
                            } else {
                                bVar = new com.tencent.mm.vfs.b(str2);
                                if (bVar.exists()) {
                                    g gVar = new g();
                                    gVar.field_type = 8;
                                    gVar.field_sourceType = 6;
                                    h.E(gVar);
                                    gVar.field_favProto.alB(bVar.getName());
                                    aar aar = new aar();
                                    aar.akV(str2);
                                    aar.oY(true);
                                    aar.akH(bVar.getName());
                                    aar.LE(gVar.field_type);
                                    aar.akR(e.cv(str2));
                                    gVar.field_favProto.wiv.add(aar);
                                    b.B(gVar);
                                    com.tencent.mm.plugin.report.service.h.pYm.e(10648, Integer.valueOf(5), Integer.valueOf(0));
                                    obj = 1;
                                } else {
                                    obj = null;
                                }
                            }
                            if (obj == null) {
                                i3 = 1;
                                break;
                            }
                            i3 = 0;
                            this.mhp = true;
                            break;
                        }
                        i3 = 3;
                        break;
                    }
                    i3 = 1;
                    break;
                }
                i3 = 1;
                break;
            case 4101:
            case 4102:
                i3 = 0;
                this.mhp = true;
                break;
            case 4103:
                long longExtra = intent.getLongExtra("key_fav_result_local_id", -1);
                if (-1 == longExtra) {
                    AppMethodBeat.o(74267);
                    return;
                }
                i3 = this.mkA.iK(longExtra);
                if (-1 == i3) {
                    AppMethodBeat.o(74267);
                    return;
                }
                this.mhs.removeFooterView(this.mhu);
                this.mhs.setSelection(i3);
                AppMethodBeat.o(74267);
                return;
            case 4104:
                final List hk = this.mkA.hk(false);
                final String[] stringArrayExtra = intent.getStringArrayExtra("key_fav_result_array");
                if (!(hk.isEmpty() || stringArrayExtra == null || stringArrayExtra.length <= 0)) {
                    final p b = h.b(this.mController.ylL, "", false, null);
                    com.tencent.mm.kernel.g.RS().aa(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(74233);
                            FavoriteIndexUI.a(hk, stringArrayExtra);
                            al.d(new Runnable() {
                                public final void run() {
                                    AppMethodBeat.i(74231);
                                    b.dismiss();
                                    AppMethodBeat.o(74231);
                                }

                                public final String toString() {
                                    AppMethodBeat.i(74232);
                                    String str = super.toString() + "|batchAddFavTags";
                                    AppMethodBeat.o(74232);
                                    return str;
                                }
                            });
                            AppMethodBeat.o(74233);
                        }
                    });
                    com.tencent.mm.plugin.report.service.h.pYm.e(11125, Integer.valueOf(stringArrayExtra.length), Integer.valueOf(2));
                    break;
                }
            case 4105:
                ab.d("MicroMsg.FavoriteIndexUI", "select %s for sending", intent.getStringExtra("Select_Conv_User"));
                a(this.mkA.hk(false), str, r4);
                break;
            case 4106:
                ab.d("MicroMsg.FavoriteIndexUI", "select %s for sending", intent.getStringExtra("Select_Conv_User"));
                List arrayList2 = new ArrayList();
                arrayList2.add(this.mkG);
                a(arrayList2, str, r4);
                break;
        }
        if (i3 == 0) {
            h.bQ(this.mController.ylL, getString(R.string.bpv));
            AppMethodBeat.o(74267);
        } else if (1 == i3) {
            h.bQ(this.mController.ylL, getString(R.string.bog));
            AppMethodBeat.o(74267);
        } else if (3 == i3) {
            Toast.makeText(this.mController.ylL, getString(R.string.bs4), 1).show();
            AppMethodBeat.o(74267);
        } else {
            if (this.mkA.mlh) {
                bvQ();
            }
            AppMethodBeat.o(74267);
        }
    }

    public final void iI(long j) {
        AppMethodBeat.i(74268);
        if (this.mkA.mlh) {
            boolean z;
            com.tencent.mm.plugin.fav.ui.widget.b bVar = this.mkB;
            if (this.mkA.bwb() > 0) {
                z = true;
            } else {
                z = false;
            }
            if (bVar.mpz) {
                bVar.mpE.setEnabled(z);
                bVar.mpF.setEnabled(z);
                bVar.mpG.setEnabled(z);
            }
        }
        AppMethodBeat.o(74268);
    }

    @SuppressLint({"ResourceType"})
    public boolean onCreateOptionsMenu(Menu menu) {
        AppMethodBeat.i(74269);
        MenuItem add = menu.add(0, 10, 0, R.string.ewn);
        add.setIcon(R.raw.actionbar_icon_dark_search);
        android.support.v4.view.g.a(add, 2);
        boolean onCreateOptionsMenu = super.onCreateOptionsMenu(menu);
        AppMethodBeat.o(74269);
        return onCreateOptionsMenu;
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        AppMethodBeat.i(74270);
        if (menuItem.getItemId() == 10) {
            Intent intent = new Intent();
            intent.putExtra("key_enter_fav_search_from", 0);
            T(intent);
            AppMethodBeat.o(74270);
            return true;
        }
        boolean onOptionsItemSelected = super.onOptionsItemSelected(menuItem);
        AppMethodBeat.o(74270);
        return onOptionsItemSelected;
    }

    private void T(Intent intent) {
        AppMethodBeat.i(74271);
        Bundle bundle = null;
        if (VERSION.SDK_INT >= 21) {
            bundle = ActivityOptions.makeSceneTransitionAnimation(this, new Pair[0]).toBundle();
        }
        if (this.mkA.mlh) {
            intent.putExtra("key_search_type", 2);
            com.tencent.mm.plugin.fav.a.b.a(this, ".ui.FavSearchUI", intent, 4103, bundle);
            AppMethodBeat.o(74271);
            return;
        }
        com.tencent.mm.plugin.fav.a.b.a((Context) this, ".ui.FavSearchUI", intent, bundle);
        AppMethodBeat.o(74271);
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        AppMethodBeat.i(74272);
        if (iArr == null || iArr.length <= 0) {
            ab.i("MicroMsg.FavoriteIndexUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", Integer.valueOf(i), Long.valueOf(Thread.currentThread().getId()));
            AppMethodBeat.o(74272);
            return;
        }
        ab.i("MicroMsg.FavoriteIndexUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId()));
        switch (i) {
            case 64:
                if (iArr[0] != 0) {
                    h.a((Context) this, getString(R.string.dby), "", getString(R.string.ckr), getString(R.string.or), false, new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.i(74241);
                            dialogInterface.dismiss();
                            FavoriteIndexUI.this.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                            AppMethodBeat.o(74241);
                        }
                    }, new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.i(74242);
                            dialogInterface.dismiss();
                            AppMethodBeat.o(74242);
                        }
                    });
                    break;
                }
                Intent intent = new Intent();
                intent.putExtra(MMFragment.FLAG_OVERRIDE_EXIT_ANIMATION, R.anim.ce);
                intent.putExtra(MMFragment.FLAG_OVERRIDE_ENTER_ANIMATION, R.anim.b5);
                intent.putExtra("map_view_type", 3);
                com.tencent.mm.bp.d.b((Context) this, FirebaseAnalytics.b.LOCATION, ".ui.RedirectUI", intent, 4097);
                AppMethodBeat.o(74272);
                return;
            case 80:
                if (iArr[0] == 0) {
                    com.tencent.mm.plugin.fav.a.b.a((Context) this, ".ui.FavPostVoiceUI", new Intent(), 4102);
                    overridePendingTransition(0, 0);
                    AppMethodBeat.o(74272);
                    return;
                }
                h.a((Context) this, getString(R.string.dc0), "", getString(R.string.ckr), getString(R.string.or), false, new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.i(74239);
                        dialogInterface.dismiss();
                        FavoriteIndexUI.this.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                        AppMethodBeat.o(74239);
                    }
                }, new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.i(74240);
                        dialogInterface.dismiss();
                        AppMethodBeat.o(74240);
                    }
                });
                AppMethodBeat.o(74272);
                return;
        }
        AppMethodBeat.o(74272);
    }

    public final void bvR() {
        AppMethodBeat.i(74273);
        Intent intent = new Intent();
        intent.putExtra("key_enter_fav_cleanui_from", 0);
        com.tencent.mm.plugin.fav.a.b.b(this.mController.ylL, ".ui.FavCleanUI", intent);
        AppMethodBeat.o(74273);
    }

    public static void a(List<g> list, String[] strArr) {
        AppMethodBeat.i(74274);
        if (list == null || list.isEmpty()) {
            AppMethodBeat.o(74274);
        } else if (strArr == null || strArr.length <= 0) {
            AppMethodBeat.o(74274);
        } else {
            LinkedList<g> linkedList = new LinkedList();
            for (g gVar : list) {
                int i = 0;
                for (String LJ : strArr) {
                    i |= gVar.LJ(LJ);
                }
                if (i != 0) {
                    ((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavItemInfoStorage().a(gVar, "localId");
                    com.tencent.mm.plugin.fav.a.b.p(gVar);
                    linkedList.add(gVar);
                }
            }
            for (g a : linkedList) {
                com.tencent.mm.plugin.fav.a.b.a(a, 3);
            }
            AppMethodBeat.o(74274);
        }
    }

    public static boolean a(List<g> list, Context context, DialogInterface.OnClickListener onClickListener) {
        AppMethodBeat.i(74275);
        if (list == null || list.isEmpty()) {
            AppMethodBeat.o(74275);
            return true;
        }
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        k kVar = new k();
        Object obj = null;
        int i4 = 0;
        for (g gVar : list) {
            if (!(gVar == null || gVar.field_favProto == null || gVar.field_favProto.wiv == null)) {
                if (gVar.field_type == 3) {
                    i3++;
                } else {
                    int i5;
                    Iterator it = gVar.field_favProto.wiv.iterator();
                    int i6 = 0;
                    while (it.hasNext()) {
                        aar aar = (aar) it.next();
                        if (aar.whh == 2) {
                            i++;
                        } else if (aar.whh == 1) {
                            i2++;
                        } else {
                            i6++;
                        }
                    }
                    if (k.u(gVar)) {
                        i5 = i4 + 1;
                        if (i6 > 0) {
                            i6--;
                        }
                    } else {
                        i5 = i4;
                    }
                    if (obj == null && r7 == gVar.field_favProto.wiv.size()) {
                        obj = 1;
                    }
                    obj = obj;
                    i4 = i5;
                }
            }
        }
        if (1 == list.size()) {
            if (((g) list.get(0)).field_type == 14 && (i > 0 || i2 > 0)) {
                h.bQ(context, context.getString(R.string.bny));
                AppMethodBeat.o(74275);
                return false;
            } else if (i > 0) {
                h.bQ(context, context.getString(R.string.bnz));
                AppMethodBeat.o(74275);
                return false;
            } else if (i2 > 0) {
                switch (((g) list.get(0)).field_type) {
                    case 2:
                        h.bQ(context, context.getString(R.string.bo1));
                        break;
                    case 4:
                    case 16:
                        h.bQ(context, context.getString(R.string.bo2));
                        break;
                    case 8:
                        h.bQ(context, context.getString(R.string.bo0));
                        break;
                }
                AppMethodBeat.o(74275);
                return false;
            } else if (i4 > 0) {
                h.bQ(context, context.getString(R.string.ah));
                AppMethodBeat.o(74275);
                return false;
            } else if (i3 > 0) {
                h.bQ(context, context.getString(R.string.ai));
                AppMethodBeat.o(74275);
                return false;
            }
        } else if (i > 0 || i2 > 0 || i4 > 0 || i3 > 0) {
            if (obj != null) {
                h.a(context, context.getString(R.string.bo4), "", context.getString(R.string.atd), context.getString(R.string.atb), onClickListener, null, (int) R.color.a61);
            } else {
                h.bQ(context, context.getString(R.string.bo3));
            }
            AppMethodBeat.o(74275);
            return false;
        }
        AppMethodBeat.o(74275);
        return true;
    }

    static /* synthetic */ void a(FavoriteIndexUI favoriteIndexUI, View view, final int i, long j, int[] iArr) {
        AppMethodBeat.i(74277);
        new com.tencent.mm.ui.widget.b.a(favoriteIndexUI.mController.ylL, view).a(view, i, j, new OnCreateContextMenuListener() {
            public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
                AppMethodBeat.i(74247);
                k kVar = new k();
                g vE = FavoriteIndexUI.this.mkA.vE((i - FavoriteIndexUI.this.mhs.getHeaderViewsCount()) - 1);
                boolean t = kVar.t(vE);
                if (!t) {
                    contextMenu.add(0, 3, 0, R.string.br5);
                }
                if (t && com.tencent.mm.plugin.fav.a.b.g(vE)) {
                    contextMenu.add(0, 3, 0, R.string.br5);
                }
                if (vE.field_type == 8) {
                    aar c = com.tencent.mm.plugin.fav.a.b.c(vE);
                    if (com.tencent.mm.plugin.fav.a.b.f(c) && !com.tencent.mm.plugin.fav.a.b.g(c)) {
                        contextMenu.add(0, 4, 0, R.string.bpy);
                    }
                }
                contextMenu.add(0, 2, 0, R.string.bo8);
                contextMenu.add(0, 0, 0, R.string.bnp);
                contextMenu.add(0, 1, 0, R.string.bpn);
                AppMethodBeat.o(74247);
            }
        }, new com.tencent.mm.ui.base.n.d() {
            public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                AppMethodBeat.i(74249);
                switch (FavoriteIndexUI.this.mkz) {
                    case 0:
                        if (menuItem == null) {
                            AppMethodBeat.o(74249);
                            return;
                        }
                        switch (menuItem.getItemId()) {
                            case 0:
                                if (i < FavoriteIndexUI.this.mhs.getHeaderViewsCount()) {
                                    AppMethodBeat.o(74249);
                                    return;
                                }
                                ab.i("MicroMsg.FavoriteIndexUI", "do delete, long click info is %s", Integer.valueOf(i));
                                com.tencent.mm.plugin.fav.a.b.i(FavoriteIndexUI.this.mkA.vE((i - FavoriteIndexUI.this.mhs.getHeaderViewsCount()) - 1));
                                AppMethodBeat.o(74249);
                                return;
                            case 1:
                                FavoriteIndexUI.this.startTime = bo.anT();
                                ab.i("MicroMsg.FavoriteIndexUI", "do edit, long click info is %s", Integer.valueOf(i));
                                FavoriteIndexUI.this.mkC = FavoriteIndexUI.this.mkA.vE((i - FavoriteIndexUI.this.mhs.getHeaderViewsCount()) - 1);
                                FavoriteIndexUI.b(FavoriteIndexUI.this, FavoriteIndexUI.this.mkC);
                                AppMethodBeat.o(74249);
                                return;
                            case 2:
                                ab.i("MicroMsg.FavoriteIndexUI", "do tag, long click info is %s", Integer.valueOf(i));
                                g vE = FavoriteIndexUI.this.mkA.vE((i - FavoriteIndexUI.this.mhs.getHeaderViewsCount()) - 1);
                                Intent intent = new Intent();
                                intent.putExtra("key_fav_scene", 4);
                                intent.putExtra("key_fav_item_id", vE.field_localId);
                                com.tencent.mm.plugin.fav.a.b.b(FavoriteIndexUI.this.mController.ylL, ".ui.FavTagEditUI", intent);
                                i.LK("FavTagEditUI");
                                AppMethodBeat.o(74249);
                                return;
                            case 3:
                                FavoriteIndexUI.this.startTime = bo.anT();
                                ab.i("MicroMsg.FavoriteIndexUI", "do transmit, long click info is %s", Integer.valueOf(i));
                                FavoriteIndexUI.this.mkG = FavoriteIndexUI.this.mkA.vE((i - FavoriteIndexUI.this.mhs.getHeaderViewsCount()) - 1);
                                FavoriteIndexUI.this.mkG = FavoriteIndexUI.this.mkG.buB();
                                if (FavoriteIndexUI.this.mkG == null) {
                                    AppMethodBeat.o(74249);
                                    return;
                                }
                                List linkedList = new LinkedList();
                                linkedList.add(FavoriteIndexUI.this.mkG);
                                if (FavoriteIndexUI.a(linkedList, FavoriteIndexUI.this, new DialogInterface.OnClickListener() {
                                    public final void onClick(DialogInterface dialogInterface, int i) {
                                        AppMethodBeat.i(74248);
                                        FavoriteIndexUI.a(FavoriteIndexUI.this, 4106);
                                        AppMethodBeat.o(74248);
                                    }
                                })) {
                                    FavoriteIndexUI.a(FavoriteIndexUI.this, 4106);
                                    AppMethodBeat.o(74249);
                                    return;
                                }
                                AppMethodBeat.o(74249);
                                return;
                            case 4:
                                g vE2 = FavoriteIndexUI.this.mkA.vE((i - FavoriteIndexUI.this.mhs.getHeaderViewsCount()) - 1);
                                abh abh = new abh();
                                abh.cOi = 1;
                                ((y) com.tencent.mm.kernel.g.K(y.class)).a(FavoriteIndexUI.this.mController.ylL, vE2, abh);
                                break;
                        }
                        AppMethodBeat.o(74249);
                        return;
                    default:
                        AppMethodBeat.o(74249);
                        return;
                }
            }
        }, iArr[0], iArr[1]);
        AppMethodBeat.o(74277);
    }

    static /* synthetic */ void b(FavoriteIndexUI favoriteIndexUI, g gVar) {
        AppMethodBeat.i(74278);
        favoriteIndexUI.mkA.a(true, gVar);
        favoriteIndexUI.mhs.setOnItemLongClickListener(null);
        favoriteIndexUI.showOptionMenu(11, false);
        com.tencent.mm.plugin.fav.ui.widget.b bVar = favoriteIndexUI.mkB;
        if (!bVar.mpz) {
            if (bVar.mpA == null) {
                AppMethodBeat.o(74278);
                return;
            }
            if (bVar.mpA instanceof ViewStub) {
                bVar.mpA = ((ViewStub) bVar.mpA).inflate();
            }
            bVar.mpE = (ImageButton) bVar.mpA.findViewById(R.id.bpe);
            bVar.mpE.setEnabled(false);
            bVar.mpE.setContentDescription(bVar.mpE.getContext().getString(R.string.exz));
            bVar.mpE.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(74672);
                    if (b.this.mpH == null) {
                        AppMethodBeat.o(74672);
                        return;
                    }
                    b.this.mpH.bvS();
                    AppMethodBeat.o(74672);
                }
            });
            bVar.mpF = (ImageButton) bVar.mpA.findViewById(R.id.bpf);
            bVar.mpF.setEnabled(false);
            bVar.mpF.setContentDescription(bVar.mpF.getContext().getString(R.string.b8h));
            bVar.mpF.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(74673);
                    if (b.this.mpH == null) {
                        AppMethodBeat.o(74673);
                        return;
                    }
                    b.this.mpH.bvT();
                    AppMethodBeat.o(74673);
                }
            });
            bVar.mpG = (ImageButton) bVar.mpA.findViewById(R.id.bpg);
            bVar.mpG.setEnabled(false);
            bVar.mpG.setContentDescription(bVar.mpG.getContext().getString(R.string.b54));
            bVar.mpG.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(74674);
                    if (b.this.mpH == null) {
                        AppMethodBeat.o(74674);
                        return;
                    }
                    b.this.mpH.bvB();
                    AppMethodBeat.o(74674);
                }
            });
            bVar.mpz = true;
        }
        if (bVar.mpA.getVisibility() != 0) {
            bVar.mpA.setVisibility(0);
            bVar.mpA.startAnimation(AnimationUtils.loadAnimation(bVar.mpA.getContext(), R.anim.b5));
        }
        AppMethodBeat.o(74278);
    }

    static /* synthetic */ void g(FavoriteIndexUI favoriteIndexUI) {
        AppMethodBeat.i(74280);
        long currentTimeMillis = System.currentTimeMillis();
        ld ldVar = new ld();
        ldVar.cGU.field_localId = currentTimeMillis;
        ldVar.cGU.context = favoriteIndexUI.mController.ylL;
        ldVar.cGU.type = 9;
        com.tencent.mm.sdk.b.a.xxA.m(ldVar);
        le leVar = new le();
        leVar.cHe.context = favoriteIndexUI.mController.ylL;
        leVar.cHe.type = 3;
        leVar.cHe.itemType = 1;
        com.tencent.mm.sdk.b.a.xxA.m(leVar);
        AppMethodBeat.o(74280);
    }
}
