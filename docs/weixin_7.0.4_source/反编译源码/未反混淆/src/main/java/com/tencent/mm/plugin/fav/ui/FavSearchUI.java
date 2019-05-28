package com.tencent.mm.plugin.fav.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.view.g.d;
import android.support.v7.widget.Toolbar.LayoutParams;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.at.o;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.r;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.fav.a.ae;
import com.tencent.mm.plugin.fav.a.i;
import com.tencent.mm.plugin.fav.a.k;
import com.tencent.mm.plugin.fav.a.w;
import com.tencent.mm.plugin.fav.ui.a.b;
import com.tencent.mm.plugin.fav.ui.a.c;
import com.tencent.mm.plugin.fav.ui.widget.FavCapacityPanel;
import com.tencent.mm.plugin.fav.ui.widget.FavSearchActionView;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.p;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

@com.tencent.mm.ui.base.a(3)
public class FavSearchUI extends MMActivity {
    private String cqz;
    private int gaL;
    private ListView jLm;
    private long kGM;
    private ak mHandler;
    private l mhN;
    private b mhO;
    private int miT = -1;
    private String miU;
    private Set<Integer> miV;
    private w miW;
    private c miX;
    private FavSearchActionView miY;
    private ListView miZ;
    private View mja;
    private FavCapacityPanel mjb;
    private Animation mjc;
    private Animation mjd;
    private List<Integer> mje;
    private List<String> mjf;
    private List<String> mjg;
    private Set<String> mjh = new HashSet();
    private View mji;
    private ImageButton mjj;
    private MenuItem mjk;
    private List<Long> mjl = new ArrayList();
    a mjm;
    private com.tencent.mm.plugin.fav.ui.gallery.c mjn;
    private String query = "";

    static class a {
        int actionType;
        int jSW;
        long meT;
        int mjx;
        int mjy;
        boolean mjz = false;
        int position;
        String query;
        int scene;

        a() {
        }

        public final void IF() {
            AppMethodBeat.i(74084);
            h.pYm.e(15488, Integer.valueOf(this.actionType), Integer.valueOf(this.jSW), Integer.valueOf(this.scene), Integer.valueOf(this.position), Integer.valueOf(this.mjx), this.query, Long.valueOf(this.meT), Integer.valueOf(this.mjy));
            AppMethodBeat.o(74084);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public FavSearchUI() {
        AppMethodBeat.i(74085);
        AppMethodBeat.o(74085);
    }

    static /* synthetic */ boolean e(FavSearchUI favSearchUI) {
        AppMethodBeat.i(74095);
        boolean bvL = favSearchUI.bvL();
        AppMethodBeat.o(74095);
        return bvL;
    }

    public final int getLayoutId() {
        return R.layout.yw;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(74086);
        super.onCreate(bundle);
        if (VERSION.SDK_INT >= 21) {
            Transition inflateTransition = TransitionInflater.from(this).inflateTransition(17760258);
            inflateTransition.excludeTarget(getWindow().getDecorView().findViewById(R.id.k0), true);
            inflateTransition.excludeTarget(16908335, true);
            getWindow().setEnterTransition(inflateTransition);
        }
        this.mHandler = new ak();
        setMMTitle("");
        xE(this.mController.ylL.getResources().getColor(R.color.vy));
        this.gaL = getIntent().getIntExtra("key_search_type", 0);
        if (1 == this.gaL) {
            this.cqz = getIntent().getStringExtra("key_to_user");
            this.miU = getIntent().getStringExtra("key_fav_item_id");
        }
        this.miT = getIntent().getIntExtra("key_preset_search_type", -1);
        this.miZ = (ListView) findViewById(R.id.brj);
        this.jLm = (ListView) findViewById(R.id.brk);
        this.mja = findViewById(R.id.brm);
        this.mjc = AnimationUtils.loadAnimation(this.mController.ylL, R.anim.c2);
        this.mjd = AnimationUtils.loadAnimation(this.mController.ylL, R.anim.c3);
        this.mjn = new com.tencent.mm.plugin.fav.ui.gallery.c(this, findViewById(R.id.brl));
        bvM();
        this.mjb = (FavCapacityPanel) View.inflate(this.mController.ylL, R.layout.xz, null);
        this.mjb.mpw = getIntent().getIntExtra("key_enter_fav_search_from", 0);
        this.miX = new c(this.mController.ylL) {
            public final void Ma(String str) {
                AppMethodBeat.i(74076);
                FavSearchActionView b = FavSearchUI.this.miY;
                b.mpS.add(str);
                if (b.mjS == null) {
                    AppMethodBeat.o(74076);
                    return;
                }
                b.mjS.setEditHint("");
                b.mjS.cc(str, true);
                if (b.mpU == null) {
                    AppMethodBeat.o(74076);
                    return;
                }
                b.Mh(b.mjS.getEditText());
                b.mpU.a(b.mlj, b.mpT, b.mpS, false);
                h.pYm.e(11126, Integer.valueOf(2));
                AppMethodBeat.o(74076);
            }

            public final void Mb(String str) {
                AppMethodBeat.i(74077);
                FavSearchActionView b = FavSearchUI.this.miY;
                b.mpS.remove(str);
                if (b.mjS == null) {
                    AppMethodBeat.o(74077);
                    return;
                }
                if (b.mpS.isEmpty()) {
                    b.mjS.setEditHint(b.getResources().getString(R.string.te));
                }
                b.mjS.removeTag(str);
                if (b.mpU == null) {
                    AppMethodBeat.o(74077);
                    return;
                }
                b.Mh(b.mjS.getEditText());
                b.mpU.a(b.mlj, b.mpT, b.mpS, true);
                AppMethodBeat.o(74077);
            }
        };
        if (((ae) g.M(ae.class)).getFavTagSetMgr().buE() > 0) {
            this.miZ.addHeaderView((TextView) View.inflate(this.mController.ylL, R.layout.z0, null));
        }
        this.miZ.addFooterView(this.mjb);
        this.miZ.setAdapter(this.miX);
        this.miZ.setOnTouchListener(new OnTouchListener() {
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(74078);
                switch (motionEvent.getAction()) {
                    case 0:
                        FavSearchUI.this.aqX();
                        break;
                }
                AppMethodBeat.o(74078);
                return false;
            }
        });
        this.mhN = new l(this.mController.ylL, 16);
        this.mhO = new b(this.mhN, false);
        this.mhO.scene = 2;
        this.mhO.mlr = this.jLm;
        if (1 == this.gaL) {
            this.miV = new HashSet();
            this.miW = new k();
            if (!bo.isNullOrNil(this.miU)) {
                for (String str : this.miU.split(",")) {
                    int i = bo.getInt(str, BaseClientBuilder.API_PRIORITY_OTHER);
                    if (BaseClientBuilder.API_PRIORITY_OTHER != i) {
                        this.miV.add(Integer.valueOf(i));
                    }
                }
            }
            this.mhO.f(this.miV);
            this.mhO.a(this.miW);
        }
        this.jLm.setAdapter(this.mhO);
        this.jLm.setOnItemClickListener(new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, final int i, long j) {
                AppMethodBeat.i(74083);
                final com.tencent.mm.plugin.fav.ui.d.a.b bVar = (com.tencent.mm.plugin.fav.ui.d.a.b) view.getTag();
                if (!(bVar == null || bVar.mgf == null)) {
                    FavSearchUI.this.mjm.mjz = true;
                    FavSearchUI.a(FavSearchUI.this, i, bVar.mgf.field_id);
                }
                if (1 == FavSearchUI.this.gaL) {
                    if (bVar == null) {
                        ab.w("MicroMsg.FavSearchUI", "on item click, holder is null");
                        AppMethodBeat.o(74083);
                    } else if (bVar.mgf == null) {
                        ab.w("MicroMsg.FavSearchUI", "on item click, info is null");
                        AppMethodBeat.o(74083);
                    } else {
                        ((com.tencent.mm.plugin.fav.a.ab) g.K(com.tencent.mm.plugin.fav.a.ab.class)).a(FavSearchUI.this.mController.ylL, FavSearchUI.this.cqz, bVar.mgf, false, new com.tencent.mm.pluginsdk.ui.applet.q.a() {
                            public final void a(boolean z, String str, int i) {
                                AppMethodBeat.i(74081);
                                FavSearchUI.this.aqX();
                                if (z) {
                                    final p b = com.tencent.mm.ui.base.h.b(FavSearchUI.this.mController.ylL, FavSearchUI.this.getString(R.string.bp2), false, null);
                                    i.a(FavSearchUI.this.mController.ylL, FavSearchUI.this.cqz, str, bVar.mgf, new Runnable() {
                                        public final void run() {
                                            AppMethodBeat.i(74080);
                                            if (b != null) {
                                                b.dismiss();
                                            }
                                            com.tencent.mm.ui.widget.snackbar.b.i(FavSearchUI.this, FavSearchUI.this.getString(R.string.bnf));
                                            al.n(new Runnable() {
                                                public final void run() {
                                                    AppMethodBeat.i(74079);
                                                    FavSearchUI.this.finish();
                                                    AppMethodBeat.o(74079);
                                                }
                                            }, 1800);
                                            AppMethodBeat.o(74080);
                                        }
                                    });
                                }
                                AppMethodBeat.o(74081);
                            }
                        });
                        AppMethodBeat.o(74083);
                    }
                } else if (2 != FavSearchUI.this.gaL) {
                    FavSearchUI.this.mhO.onItemClick(adapterView, view, i, j);
                    if (bVar.mgf != null) {
                        g.RS().aa(new Runnable() {
                            public final void run() {
                                int i;
                                AppMethodBeat.i(74082);
                                ab.d("MicroMsg.FavSearchUI", "type %s", Integer.valueOf(bVar.mgf.field_type));
                                long j = bVar.mgf.field_localId;
                                if (FavSearchUI.this.mjl.size() == 0) {
                                    FavSearchUI.this.mjl = ((ae) g.M(ae.class)).getFavItemInfoStorage().bvb();
                                }
                                if (FavSearchUI.this.mjl.size() != 0) {
                                    Iterator it = FavSearchUI.this.mjl.iterator();
                                    i = 1;
                                    while (it.hasNext() && ((Long) it.next()).longValue() != j) {
                                        i++;
                                    }
                                } else {
                                    i = 1;
                                }
                                h hVar = h.pYm;
                                Object[] objArr = new Object[3];
                                objArr[0] = Integer.valueOf(bVar.mgf.field_type);
                                objArr[1] = Integer.valueOf(FavSearchUI.l(FavSearchUI.this));
                                if (FavSearchUI.this.mjl.size() == 0) {
                                    i = i;
                                }
                                objArr[2] = Integer.valueOf(i);
                                hVar.e(12746, objArr);
                                AppMethodBeat.o(74082);
                            }
                        });
                    }
                    AppMethodBeat.o(74083);
                } else if (bVar == null) {
                    ab.w("MicroMsg.FavSearchUI", "on item click, holder is null");
                    AppMethodBeat.o(74083);
                } else if (bVar.mgf == null) {
                    ab.w("MicroMsg.FavSearchUI", "on item click, info is null");
                    AppMethodBeat.o(74083);
                } else {
                    Intent intent = new Intent();
                    intent.putExtra("key_fav_result_local_id", bVar.mgf.field_localId);
                    FavSearchUI.this.setResult(-1, intent);
                    FavSearchUI.this.finish();
                    AppMethodBeat.o(74083);
                }
            }
        });
        this.jLm.setOnTouchListener(new OnTouchListener() {
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(74066);
                switch (motionEvent.getAction()) {
                    case 0:
                        FavSearchUI.this.aqX();
                        break;
                }
                AppMethodBeat.o(74066);
                return false;
            }
        });
        ((ae) g.M(ae.class)).getFavTagSetMgr().a(this.miX);
        g.RS().m(new Runnable() {
            public final void run() {
                AppMethodBeat.i(74065);
                FavSearchUI.this.mjl = ((ae) g.M(ae.class)).getFavItemInfoStorage().bvb();
                AppMethodBeat.o(74065);
            }
        }, 1000);
        this.mjm = new a();
        this.kGM = System.currentTimeMillis();
        if (bvL()) {
            this.miY.S(this.miT, false);
            this.jLm.setVisibility(8);
            this.miZ.setVisibility(8);
            this.mjn.setVisibility(0);
            com.tencent.mm.plugin.fav.ui.gallery.c cVar = this.mjn;
            cVar.mnI.s(true, cVar.mnL);
            AppMethodBeat.o(74086);
            return;
        }
        if (this.miT > 0) {
            this.miY.S(this.miT, true);
            this.mjn.setVisibility(8);
            this.jLm.setVisibility(0);
        }
        AppMethodBeat.o(74086);
    }

    private boolean bvL() {
        return this.miT == 21;
    }

    public void onDestroy() {
        AppMethodBeat.i(74087);
        if (!this.mjm.mjz) {
            if (this.mhO.isEmpty() || this.jLm.getVisibility() != 0) {
                U(1, 0, 0);
            } else {
                U(2, 0, 0);
            }
        }
        this.mjn.mnI.onDetach();
        super.onDestroy();
        this.mhN.destory();
        this.mhN = null;
        ((ae) g.M(ae.class)).getFavTagSetMgr().a(this.miX);
        ((ae) g.M(ae.class)).getFavTagSetMgr().e(this.mjh);
        if (this.mhO != null) {
            this.mhO.finish();
        }
        AppMethodBeat.o(74087);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        AppMethodBeat.i(74088);
        ab.d("MicroMsg.FavSearchUI", "on create options menu");
        bvM();
        this.mjk = menu.add(0, R.id.c1, 0, R.string.pl);
        android.support.v4.view.g.a(this.mjk, this.miY);
        android.support.v4.view.g.a(this.mjk, 9);
        this.miY.post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(74068);
                if (FavSearchUI.this.miT <= 0) {
                    FavSearchActionView b = FavSearchUI.this.miY;
                    if (b.mjS != null) {
                        b.mjS.dAc();
                    }
                    FavSearchUI.this.showVKB();
                }
                AppMethodBeat.o(74068);
            }
        });
        android.support.v4.view.g.a(this.mjk, new d() {
            public final boolean eo() {
                return true;
            }

            public final boolean ep() {
                AppMethodBeat.i(74069);
                FavSearchUI.this.finish();
                AppMethodBeat.o(74069);
                return true;
            }
        });
        this.mHandler.post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(74070);
                if (FavSearchUI.this.mjk != null) {
                    android.support.v4.view.g.b(FavSearchUI.this.mjk);
                    LayoutParams layoutParams = (LayoutParams) FavSearchUI.this.miY.getLayoutParams();
                    if (layoutParams != null) {
                        layoutParams.height = -1;
                        layoutParams.width = -1;
                    }
                    FavSearchUI.this.miY.setLayoutParams(layoutParams);
                }
                AppMethodBeat.o(74070);
            }
        });
        AppMethodBeat.o(74088);
        return true;
    }

    private void bvM() {
        AppMethodBeat.i(74089);
        if (this.miY != null) {
            AppMethodBeat.o(74089);
            return;
        }
        this.miY = (FavSearchActionView) View.inflate(this.mController.ylL, R.layout.yv, null);
        this.mji = this.miY.findViewById(R.id.l0);
        this.mji.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(74071);
                FavSearchUI.this.finish();
                AppMethodBeat.o(74071);
            }
        });
        this.mjj = (ImageButton) this.miY.findViewById(R.id.bri);
        this.mjj.setVisibility(8);
        this.miY.setOnSearchChangedListener(new com.tencent.mm.plugin.fav.ui.widget.FavSearchActionView.a() {
            public final void app() {
                AppMethodBeat.i(74073);
                ab.d("MicroMsg.FavSearchUI", "on enter search, show tag panel");
                FavSearchUI.d(FavSearchUI.this);
                AppMethodBeat.o(74073);
            }

            public final void a(List<Integer> list, List<String> list2, List<String> list3, boolean z) {
                AppMethodBeat.i(74074);
                if (list2.isEmpty() && list3.isEmpty() && FavSearchUI.e(FavSearchUI.this)) {
                    FavSearchUI.a(FavSearchUI.this, true);
                    FavSearchUI.a(FavSearchUI.this, (List) list2, (List) list3);
                    AppMethodBeat.o(74074);
                    return;
                }
                ab.d("MicroMsg.FavSearchUI", "on search, types %s keys %s tags %s", list, list2, list3);
                FavSearchUI.this.mjf = list2;
                FavSearchUI.this.mjg = list3;
                FavSearchUI.this.mje = list;
                FavSearchUI.this.miX.bQ(list3);
                if (z) {
                    FavSearchUI.d(FavSearchUI.this);
                    FavSearchUI.a(FavSearchUI.this, (List) list2, (List) list3);
                    AppMethodBeat.o(74074);
                    return;
                }
                FavSearchUI.this.mhO.c(list, list2, list3);
                FavSearchUI.b(FavSearchUI.this, true);
                FavSearchUI.a(FavSearchUI.this, (List) list2, (List) list3);
                AppMethodBeat.o(74074);
            }

            public final void a(String str, final List<Integer> list, final List<String> list2, final List<String> list3) {
                AppMethodBeat.i(74075);
                FavSearchUI.this.miY.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(74072);
                        if (list2.isEmpty() && list3.isEmpty() && FavSearchUI.e(FavSearchUI.this)) {
                            FavSearchUI.a(FavSearchUI.this, false);
                            FavSearchUI.a(FavSearchUI.this, list2, list3);
                            AppMethodBeat.o(74072);
                            return;
                        }
                        FavSearchUI.a(FavSearchUI.this, list2, list3);
                        ab.d("MicroMsg.FavSearchUI", "on text changed, types %s keys %s tags %s", list, list2, list3);
                        FavSearchUI.this.mjf = list2;
                        FavSearchUI.this.mjg = list3;
                        FavSearchUI.this.mje = list;
                        FavSearchUI.this.miX.bQ(list3);
                        FavSearchUI.this.mhO.c(list, list2, list3);
                        FavSearchUI.b(FavSearchUI.this, false);
                        AppMethodBeat.o(74072);
                    }
                });
                if (str != null) {
                    FavSearchUI.this.query = str;
                } else {
                    FavSearchUI.this.query = "";
                }
                if (FavSearchUI.this.mhO != null) {
                    b g = FavSearchUI.this.mhO;
                    String h = FavSearchUI.this.query;
                    if (h != null) {
                        g.query = h;
                        AppMethodBeat.o(74075);
                        return;
                    }
                    g.query = "";
                }
                AppMethodBeat.o(74075);
            }
        });
        AppMethodBeat.o(74089);
    }

    private void U(int i, int i2, int i3) {
        AppMethodBeat.i(74090);
        this.mjm.actionType = i;
        if (this.mhO != null) {
            this.mjm.jSW = this.mhO.jSW;
        }
        switch (this.gaL) {
            case 0:
                this.mjm.scene = 1;
                break;
            case 1:
                this.mjm.scene = 2;
                break;
            case 2:
                this.mjm.scene = 3;
                break;
            default:
                this.mjm.scene = 0;
                break;
        }
        this.mjm.position = i2;
        this.mjm.mjx = ((int) (System.currentTimeMillis() - this.kGM)) / 1000;
        this.mjm.query = this.query;
        this.mjm.meT = (long) i3;
        if (this.mje != null) {
            if (this.mje.size() > 0) {
                switch (((Integer) this.mje.get(0)).intValue()) {
                    case 3:
                        this.mjm.mjy = 6;
                        break;
                    case 5:
                        this.mjm.mjy = 2;
                        break;
                    case 6:
                        this.mjm.mjy = 8;
                        break;
                    case 7:
                        this.mjm.mjy = 4;
                        break;
                    case 8:
                        this.mjm.mjy = 3;
                        break;
                    case 17:
                        this.mjm.mjy = 5;
                        break;
                    case 18:
                        this.mjm.mjy = 7;
                        break;
                    case 21:
                        this.mjm.mjy = 1;
                        break;
                    default:
                        this.mjm.mjy = 0;
                        break;
                }
            }
            this.mjm.mjy = 0;
        }
        this.mjm.IF();
        AppMethodBeat.o(74090);
    }

    public void onResume() {
        long j = 0;
        AppMethodBeat.i(74091);
        this.mhO.bvY();
        this.mhO.notifyDataSetChanged();
        FavCapacityPanel favCapacityPanel = this.mjb;
        if (favCapacityPanel.mpu != com.tencent.mm.plugin.fav.a.b.buh() / 1048576) {
            favCapacityPanel.mpu = com.tencent.mm.plugin.fav.a.b.buh() / 1048576;
            TextView textView = favCapacityPanel.mpv;
            Context context = favCapacityPanel.mpv.getContext();
            Object[] objArr = new Object[2];
            if (favCapacityPanel.mpx - favCapacityPanel.mpu > 0) {
                j = favCapacityPanel.mpx - favCapacityPanel.mpu;
            }
            objArr[0] = Long.valueOf(j);
            objArr[1] = Long.valueOf(favCapacityPanel.mpu);
            textView.setText(context.getString(R.string.bn3, objArr));
        }
        i.LK(getClass().getSimpleName());
        if (bvL()) {
            com.tencent.mm.plugin.fav.ui.gallery.c cVar = this.mjn;
            cVar.fAq = bo.anT();
            if (com.tencent.matrix.a.isInstalled() && com.tencent.matrix.a.yK().F(com.tencent.matrix.trace.a.class) != null) {
                com.tencent.matrix.trace.f.c cVar2 = ((com.tencent.matrix.trace.a) com.tencent.matrix.a.yK().F(com.tencent.matrix.trace.a.class)).bYx;
                if (cVar2 != null) {
                    cVar2.a(cVar.mnM);
                }
            }
            cVar.mnI.onResume();
            if (cVar.mnK) {
                if (cVar.mnI.bwy()) {
                    cVar.bwq();
                } else {
                    cVar.bwr();
                }
            }
            cVar.mnK = false;
        }
        super.onResume();
        AppMethodBeat.o(74091);
    }

    public void onPause() {
        AppMethodBeat.i(74092);
        i.LL(getClass().getSimpleName());
        if (bvL()) {
            com.tencent.mm.plugin.fav.ui.gallery.c cVar = this.mjn;
            WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcMediaGalleryScrollEnable, cVar.ehv);
            cVar.ehv = 0;
            if (com.tencent.matrix.a.isInstalled() && com.tencent.matrix.a.yK().F(com.tencent.matrix.trace.a.class) != null) {
                com.tencent.matrix.trace.f.c cVar2 = ((com.tencent.matrix.trace.a) com.tencent.matrix.a.yK().F(com.tencent.matrix.trace.a.class)).bYx;
                if (cVar2 != null) {
                    cVar2.b(cVar.mnM);
                }
            }
            cVar.fAq = bo.anT() > cVar.fAq ? bo.anT() - cVar.fAq : 1;
            WXHardCoderJNI.reportFPS(703, WXHardCoderJNI.hcMediaGalleryScrollAction, 1, cVar.eEO, cVar.fAq);
            cVar.eEO = 0;
            cVar.fAq = 0;
        }
        super.onPause();
        AppMethodBeat.o(74092);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(74093);
        if (i == 1) {
            if (i2 != -1) {
                AppMethodBeat.o(74093);
                return;
            }
            List<com.tencent.mm.plugin.fav.ui.gallery.d> list = this.mjn.mnS;
            String stringExtra = intent.getStringExtra("Select_Conv_User");
            if (bo.isNullOrNil(stringExtra)) {
                AppMethodBeat.o(74093);
                return;
            }
            ArrayList<String> P = bo.P(stringExtra.split(","));
            String stringExtra2 = intent.getStringExtra("custom_send_text");
            for (com.tencent.mm.plugin.fav.ui.gallery.d dVar : list) {
                if (dVar == null) {
                    ab.d("MicroMsg.FavSearchUI", "select %s, send item null, continute", stringExtra);
                } else {
                    k kVar = new k();
                    if (k.u(dVar.mnW)) {
                        com.tencent.mm.ui.base.h.bQ(this.mController.ylL, getString(R.string.ah));
                        AppMethodBeat.o(74093);
                        return;
                    }
                    ab.d("MicroMsg.FavSearchUI", "select %s for sending", stringExtra);
                    if (dVar.bws() || dVar.bwt()) {
                        final p b = com.tencent.mm.ui.base.h.b(this.mController.ylL, getString(R.string.bp2), false, null);
                        AnonymousClass3 anonymousClass3 = new Runnable() {
                            public final void run() {
                                AppMethodBeat.i(74067);
                                b.dismiss();
                                AppMethodBeat.o(74067);
                            }
                        };
                        for (String a : P) {
                            i.a(this, a, dVar.cAJ, anonymousClass3);
                        }
                    } else {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(com.tencent.mm.plugin.fav.a.b.b(dVar.cAJ));
                        for (String a2 : P) {
                            o.ahj().a(r.Yz(), a2, arrayList, 0, false);
                        }
                    }
                }
            }
            if (!bo.isNullOrNil(stringExtra2)) {
                for (String str : P) {
                    com.tencent.mm.plugin.messenger.a.g.bOk().F(str, stringExtra2, t.nK(str));
                }
            }
        }
        AppMethodBeat.o(74093);
    }

    static /* synthetic */ void d(FavSearchUI favSearchUI) {
        AppMethodBeat.i(74094);
        favSearchUI.miX.notifyDataSetChanged();
        if (8 != favSearchUI.mjn.jWH.getVisibility()) {
            favSearchUI.mjn.setVisibility(8);
        }
        if (favSearchUI.miZ.getVisibility() != 0) {
            favSearchUI.miZ.setVisibility(0);
            favSearchUI.miZ.startAnimation(favSearchUI.mjc);
        }
        if (8 != favSearchUI.jLm.getVisibility()) {
            favSearchUI.jLm.setVisibility(8);
            favSearchUI.jLm.startAnimation(favSearchUI.mjd);
        }
        if (8 != favSearchUI.mja.getVisibility()) {
            favSearchUI.mja.setVisibility(8);
            favSearchUI.mja.startAnimation(favSearchUI.mjd);
        }
        AppMethodBeat.o(74094);
    }

    static /* synthetic */ int l(FavSearchUI favSearchUI) {
        AppMethodBeat.i(74100);
        int size = favSearchUI.mje.size();
        int size2 = favSearchUI.mjf.size();
        int size3 = favSearchUI.mjg.size();
        if (size == 0 && size2 == 0 && size3 > 0) {
            AppMethodBeat.o(74100);
            return 2;
        } else if (size == 0 && size2 > 0 && size3 == 0) {
            AppMethodBeat.o(74100);
            return 3;
        } else if (size > 0 && size2 == 0 && size3 == 0) {
            AppMethodBeat.o(74100);
            return 1;
        } else {
            AppMethodBeat.o(74100);
            return 4;
        }
    }
}
