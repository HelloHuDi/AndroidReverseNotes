package com.tencent.p177mm.plugin.fav.p410ui;

import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.p057v4.view.C0464g;
import android.support.p057v4.view.C0464g.C0463d;
import android.support.p069v7.widget.Toolbar.LayoutParams;
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
import com.tencent.matrix.C1060a;
import com.tencent.matrix.trace.C7466a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.matrix.trace.p175f.C7469c;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.hardcoder.WXHardCoderJNI;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.p190at.C32291o;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C44275p;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.p612ui.widget.snackbar.C5670b;
import com.tencent.p177mm.plugin.fav.p407a.C11853i;
import com.tencent.p177mm.plugin.fav.p407a.C39037b;
import com.tencent.p177mm.plugin.fav.p407a.C39039w;
import com.tencent.p177mm.plugin.fav.p407a.C41268k;
import com.tencent.p177mm.plugin.fav.p407a.C6892ab;
import com.tencent.p177mm.plugin.fav.p407a.C7604ae;
import com.tencent.p177mm.plugin.fav.p410ui.gallery.C20742d;
import com.tencent.p177mm.plugin.fav.p410ui.gallery.C28023c;
import com.tencent.p177mm.plugin.fav.p410ui.p1260a.C34149c;
import com.tencent.p177mm.plugin.fav.p410ui.p1260a.C39056b;
import com.tencent.p177mm.plugin.fav.p410ui.p412d.C20714a.C3084b;
import com.tencent.p177mm.plugin.fav.p410ui.widget.FavCapacityPanel;
import com.tencent.p177mm.plugin.fav.p410ui.widget.FavSearchActionView;
import com.tencent.p177mm.plugin.fav.p410ui.widget.FavSearchActionView.C28034a;
import com.tencent.p177mm.plugin.messenger.p993a.C12519g;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.pluginsdk.p597ui.applet.C40463q.C30111a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

@C5271a(3)
/* renamed from: com.tencent.mm.plugin.fav.ui.FavSearchUI */
public class FavSearchUI extends MMActivity {
    private String cqz;
    private int gaL;
    private ListView jLm;
    private long kGM;
    private C7306ak mHandler;
    private C45939l mhN;
    private C39056b mhO;
    private int miT = -1;
    private String miU;
    private Set<Integer> miV;
    private C39039w miW;
    private C34149c miX;
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
    C11871a mjm;
    private C28023c mjn;
    private String query = "";

    /* renamed from: com.tencent.mm.plugin.fav.ui.FavSearchUI$6 */
    class C30736 implements Runnable {
        C30736() {
        }

        public final void run() {
            AppMethodBeat.m2504i(74070);
            if (FavSearchUI.this.mjk != null) {
                C0464g.m812b(FavSearchUI.this.mjk);
                LayoutParams layoutParams = (LayoutParams) FavSearchUI.this.miY.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = -1;
                    layoutParams.width = -1;
                }
                FavSearchUI.this.miY.setLayoutParams(layoutParams);
            }
            AppMethodBeat.m2505o(74070);
        }
    }

    /* renamed from: com.tencent.mm.plugin.fav.ui.FavSearchUI$7 */
    class C30747 implements OnClickListener {
        C30747() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(74071);
            FavSearchUI.this.finish();
            AppMethodBeat.m2505o(74071);
        }
    }

    /* renamed from: com.tencent.mm.plugin.fav.ui.FavSearchUI$8 */
    class C30758 implements C28034a {
        C30758() {
        }

        public final void app() {
            AppMethodBeat.m2504i(74073);
            C4990ab.m7410d("MicroMsg.FavSearchUI", "on enter search, show tag panel");
            FavSearchUI.m44558d(FavSearchUI.this);
            AppMethodBeat.m2505o(74073);
        }

        /* renamed from: a */
        public final void mo7325a(List<Integer> list, List<String> list2, List<String> list3, boolean z) {
            AppMethodBeat.m2504i(74074);
            if (list2.isEmpty() && list3.isEmpty() && FavSearchUI.m44559e(FavSearchUI.this)) {
                FavSearchUI.m44551a(FavSearchUI.this, true);
                FavSearchUI.m44550a(FavSearchUI.this, (List) list2, (List) list3);
                AppMethodBeat.m2505o(74074);
                return;
            }
            C4990ab.m7411d("MicroMsg.FavSearchUI", "on search, types %s keys %s tags %s", list, list2, list3);
            FavSearchUI.this.mjf = list2;
            FavSearchUI.this.mjg = list3;
            FavSearchUI.this.mje = list;
            FavSearchUI.this.miX.mo54730bQ(list3);
            if (z) {
                FavSearchUI.m44558d(FavSearchUI.this);
                FavSearchUI.m44550a(FavSearchUI.this, (List) list2, (List) list3);
                AppMethodBeat.m2505o(74074);
                return;
            }
            FavSearchUI.this.mhO.mo61962c(list, list2, list3);
            FavSearchUI.m44554b(FavSearchUI.this, true);
            FavSearchUI.m44550a(FavSearchUI.this, (List) list2, (List) list3);
            AppMethodBeat.m2505o(74074);
        }

        /* renamed from: a */
        public final void mo7324a(String str, final List<Integer> list, final List<String> list2, final List<String> list3) {
            AppMethodBeat.m2504i(74075);
            FavSearchUI.this.miY.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(74072);
                    if (list2.isEmpty() && list3.isEmpty() && FavSearchUI.m44559e(FavSearchUI.this)) {
                        FavSearchUI.m44551a(FavSearchUI.this, false);
                        FavSearchUI.m44550a(FavSearchUI.this, list2, list3);
                        AppMethodBeat.m2505o(74072);
                        return;
                    }
                    FavSearchUI.m44550a(FavSearchUI.this, list2, list3);
                    C4990ab.m7411d("MicroMsg.FavSearchUI", "on text changed, types %s keys %s tags %s", list, list2, list3);
                    FavSearchUI.this.mjf = list2;
                    FavSearchUI.this.mjg = list3;
                    FavSearchUI.this.mje = list;
                    FavSearchUI.this.miX.mo54730bQ(list3);
                    FavSearchUI.this.mhO.mo61962c(list, list2, list3);
                    FavSearchUI.m44554b(FavSearchUI.this, false);
                    AppMethodBeat.m2505o(74072);
                }
            });
            if (str != null) {
                FavSearchUI.this.query = str;
            } else {
                FavSearchUI.this.query = "";
            }
            if (FavSearchUI.this.mhO != null) {
                C39056b g = FavSearchUI.this.mhO;
                String h = FavSearchUI.this.query;
                if (h != null) {
                    g.query = h;
                    AppMethodBeat.m2505o(74075);
                    return;
                }
                g.query = "";
            }
            AppMethodBeat.m2505o(74075);
        }
    }

    /* renamed from: com.tencent.mm.plugin.fav.ui.FavSearchUI$5 */
    class C69085 implements C0463d {
        C69085() {
        }

        /* renamed from: eo */
        public final boolean mo1062eo() {
            return true;
        }

        /* renamed from: ep */
        public final boolean mo1063ep() {
            AppMethodBeat.m2504i(74069);
            FavSearchUI.this.finish();
            AppMethodBeat.m2505o(74069);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.fav.ui.FavSearchUI$a */
    static class C11871a {
        int actionType;
        int jSW;
        long meT;
        int mjx;
        int mjy;
        boolean mjz = false;
        int position;
        String query;
        int scene;

        C11871a() {
        }

        /* renamed from: IF */
        public final void mo23720IF() {
            AppMethodBeat.m2504i(74084);
            C7060h.pYm.mo8381e(15488, Integer.valueOf(this.actionType), Integer.valueOf(this.jSW), Integer.valueOf(this.scene), Integer.valueOf(this.position), Integer.valueOf(this.mjx), this.query, Long.valueOf(this.meT), Integer.valueOf(this.mjy));
            AppMethodBeat.m2505o(74084);
        }
    }

    /* renamed from: com.tencent.mm.plugin.fav.ui.FavSearchUI$4 */
    class C279914 implements Runnable {
        C279914() {
        }

        public final void run() {
            AppMethodBeat.m2504i(74068);
            if (FavSearchUI.this.miT <= 0) {
                FavSearchActionView b = FavSearchUI.this.miY;
                if (b.mjS != null) {
                    b.mjS.dAc();
                }
                FavSearchUI.this.showVKB();
            }
            AppMethodBeat.m2505o(74068);
        }
    }

    /* renamed from: com.tencent.mm.plugin.fav.ui.FavSearchUI$1 */
    class C279921 implements Runnable {
        C279921() {
        }

        public final void run() {
            AppMethodBeat.m2504i(74065);
            FavSearchUI.this.mjl = ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavItemInfoStorage().bvb();
            AppMethodBeat.m2505o(74065);
        }
    }

    /* renamed from: com.tencent.mm.plugin.fav.ui.FavSearchUI$2 */
    class C279932 implements OnTouchListener {
        C279932() {
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            AppMethodBeat.m2504i(74066);
            switch (motionEvent.getAction()) {
                case 0:
                    FavSearchUI.this.aqX();
                    break;
            }
            AppMethodBeat.m2505o(74066);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.fav.ui.FavSearchUI$10 */
    class C2799410 implements OnTouchListener {
        C2799410() {
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            AppMethodBeat.m2504i(74078);
            switch (motionEvent.getAction()) {
                case 0:
                    FavSearchUI.this.aqX();
                    break;
            }
            AppMethodBeat.m2505o(74078);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.fav.ui.FavSearchUI$11 */
    class C2799511 implements OnItemClickListener {
        C2799511() {
        }

        public final void onItemClick(AdapterView<?> adapterView, View view, final int i, long j) {
            AppMethodBeat.m2504i(74083);
            final C3084b c3084b = (C3084b) view.getTag();
            if (!(c3084b == null || c3084b.mgf == null)) {
                FavSearchUI.this.mjm.mjz = true;
                FavSearchUI.m44549a(FavSearchUI.this, i, c3084b.mgf.field_id);
            }
            if (1 == FavSearchUI.this.gaL) {
                if (c3084b == null) {
                    C4990ab.m7420w("MicroMsg.FavSearchUI", "on item click, holder is null");
                    AppMethodBeat.m2505o(74083);
                } else if (c3084b.mgf == null) {
                    C4990ab.m7420w("MicroMsg.FavSearchUI", "on item click, info is null");
                    AppMethodBeat.m2505o(74083);
                } else {
                    ((C6892ab) C1720g.m3528K(C6892ab.class)).mo15149a(FavSearchUI.this.mController.ylL, FavSearchUI.this.cqz, c3084b.mgf, false, new C30111a() {
                        /* renamed from: a */
                        public final void mo6399a(boolean z, String str, int i) {
                            AppMethodBeat.m2504i(74081);
                            FavSearchUI.this.aqX();
                            if (z) {
                                final C44275p b = C30379h.m48458b(FavSearchUI.this.mController.ylL, FavSearchUI.this.getString(C25738R.string.bp2), false, null);
                                C11909i.m19791a(FavSearchUI.this.mController.ylL, FavSearchUI.this.cqz, str, c3084b.mgf, new Runnable() {

                                    /* renamed from: com.tencent.mm.plugin.fav.ui.FavSearchUI$11$1$1$1 */
                                    class C118691 implements Runnable {
                                        C118691() {
                                        }

                                        public final void run() {
                                            AppMethodBeat.m2504i(74079);
                                            FavSearchUI.this.finish();
                                            AppMethodBeat.m2505o(74079);
                                        }
                                    }

                                    public final void run() {
                                        AppMethodBeat.m2504i(74080);
                                        if (b != null) {
                                            b.dismiss();
                                        }
                                        C5670b.m8523i(FavSearchUI.this, FavSearchUI.this.getString(C25738R.string.bnf));
                                        C5004al.m7442n(new C118691(), 1800);
                                        AppMethodBeat.m2505o(74080);
                                    }
                                });
                            }
                            AppMethodBeat.m2505o(74081);
                        }
                    });
                    AppMethodBeat.m2505o(74083);
                }
            } else if (2 != FavSearchUI.this.gaL) {
                FavSearchUI.this.mhO.onItemClick(adapterView, view, i, j);
                if (c3084b.mgf != null) {
                    C1720g.m3539RS().mo10302aa(new Runnable() {
                        public final void run() {
                            int i;
                            AppMethodBeat.m2504i(74082);
                            C4990ab.m7411d("MicroMsg.FavSearchUI", "type %s", Integer.valueOf(c3084b.mgf.field_type));
                            long j = c3084b.mgf.field_localId;
                            if (FavSearchUI.this.mjl.size() == 0) {
                                FavSearchUI.this.mjl = ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavItemInfoStorage().bvb();
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
                            C7060h c7060h = C7060h.pYm;
                            Object[] objArr = new Object[3];
                            objArr[0] = Integer.valueOf(c3084b.mgf.field_type);
                            objArr[1] = Integer.valueOf(FavSearchUI.m44566l(FavSearchUI.this));
                            if (FavSearchUI.this.mjl.size() == 0) {
                                i = i;
                            }
                            objArr[2] = Integer.valueOf(i);
                            c7060h.mo8381e(12746, objArr);
                            AppMethodBeat.m2505o(74082);
                        }
                    });
                }
                AppMethodBeat.m2505o(74083);
            } else if (c3084b == null) {
                C4990ab.m7420w("MicroMsg.FavSearchUI", "on item click, holder is null");
                AppMethodBeat.m2505o(74083);
            } else if (c3084b.mgf == null) {
                C4990ab.m7420w("MicroMsg.FavSearchUI", "on item click, info is null");
                AppMethodBeat.m2505o(74083);
            } else {
                Intent intent = new Intent();
                intent.putExtra("key_fav_result_local_id", c3084b.mgf.field_localId);
                FavSearchUI.this.setResult(-1, intent);
                FavSearchUI.this.finish();
                AppMethodBeat.m2505o(74083);
            }
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public FavSearchUI() {
        AppMethodBeat.m2504i(74085);
        AppMethodBeat.m2505o(74085);
    }

    /* renamed from: e */
    static /* synthetic */ boolean m44559e(FavSearchUI favSearchUI) {
        AppMethodBeat.m2504i(74095);
        boolean bvL = favSearchUI.bvL();
        AppMethodBeat.m2505o(74095);
        return bvL;
    }

    public final int getLayoutId() {
        return 2130969525;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(74086);
        super.onCreate(bundle);
        if (VERSION.SDK_INT >= 21) {
            Transition inflateTransition = TransitionInflater.from(this).inflateTransition(17760258);
            inflateTransition.excludeTarget(getWindow().getDecorView().findViewById(2131820940), true);
            inflateTransition.excludeTarget(16908335, true);
            getWindow().setEnterTransition(inflateTransition);
        }
        this.mHandler = new C7306ak();
        setMMTitle("");
        mo17446xE(this.mController.ylL.getResources().getColor(C25738R.color.f12206vy));
        this.gaL = getIntent().getIntExtra("key_search_type", 0);
        if (1 == this.gaL) {
            this.cqz = getIntent().getStringExtra("key_to_user");
            this.miU = getIntent().getStringExtra("key_fav_item_id");
        }
        this.miT = getIntent().getIntExtra("key_preset_search_type", -1);
        this.miZ = (ListView) findViewById(2131823968);
        this.jLm = (ListView) findViewById(2131823969);
        this.mja = findViewById(2131823971);
        this.mjc = AnimationUtils.loadAnimation(this.mController.ylL, C25738R.anim.f8360c2);
        this.mjd = AnimationUtils.loadAnimation(this.mController.ylL, C25738R.anim.f8361c3);
        this.mjn = new C28023c(this, findViewById(2131823970));
        bvM();
        this.mjb = (FavCapacityPanel) View.inflate(this.mController.ylL, 2130969491, null);
        this.mjb.mpw = getIntent().getIntExtra("key_enter_fav_search_from", 0);
        this.miX = new C34149c(this.mController.ylL) {
            /* renamed from: Ma */
            public final void mo23718Ma(String str) {
                AppMethodBeat.m2504i(74076);
                FavSearchActionView b = FavSearchUI.this.miY;
                b.mpS.add(str);
                if (b.mjS == null) {
                    AppMethodBeat.m2505o(74076);
                    return;
                }
                b.mjS.setEditHint("");
                b.mjS.mo71951cc(str, true);
                if (b.mpU == null) {
                    AppMethodBeat.m2505o(74076);
                    return;
                }
                b.mo73790Mh(b.mjS.getEditText());
                b.mpU.mo7325a(b.mlj, b.mpT, b.mpS, false);
                C7060h.pYm.mo8381e(11126, Integer.valueOf(2));
                AppMethodBeat.m2505o(74076);
            }

            /* renamed from: Mb */
            public final void mo23719Mb(String str) {
                AppMethodBeat.m2504i(74077);
                FavSearchActionView b = FavSearchUI.this.miY;
                b.mpS.remove(str);
                if (b.mjS == null) {
                    AppMethodBeat.m2505o(74077);
                    return;
                }
                if (b.mpS.isEmpty()) {
                    b.mjS.setEditHint(b.getResources().getString(C25738R.string.f9220te));
                }
                b.mjS.removeTag(str);
                if (b.mpU == null) {
                    AppMethodBeat.m2505o(74077);
                    return;
                }
                b.mo73790Mh(b.mjS.getEditText());
                b.mpU.mo7325a(b.mlj, b.mpT, b.mpS, true);
                AppMethodBeat.m2505o(74077);
            }
        };
        if (((C7604ae) C1720g.m3530M(C7604ae.class)).getFavTagSetMgr().buE() > 0) {
            this.miZ.addHeaderView((TextView) View.inflate(this.mController.ylL, 2130969529, null));
        }
        this.miZ.addFooterView(this.mjb);
        this.miZ.setAdapter(this.miX);
        this.miZ.setOnTouchListener(new C2799410());
        this.mhN = new C45939l(this.mController.ylL, 16);
        this.mhO = new C39056b(this.mhN, false);
        this.mhO.scene = 2;
        this.mhO.mlr = this.jLm;
        if (1 == this.gaL) {
            this.miV = new HashSet();
            this.miW = new C41268k();
            if (!C5046bo.isNullOrNil(this.miU)) {
                for (String str : this.miU.split(",")) {
                    int i = C5046bo.getInt(str, BaseClientBuilder.API_PRIORITY_OTHER);
                    if (BaseClientBuilder.API_PRIORITY_OTHER != i) {
                        this.miV.add(Integer.valueOf(i));
                    }
                }
            }
            this.mhO.mo54725f(this.miV);
            this.mhO.mo54719a(this.miW);
        }
        this.jLm.setAdapter(this.mhO);
        this.jLm.setOnItemClickListener(new C2799511());
        this.jLm.setOnTouchListener(new C279932());
        ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavTagSetMgr().mo73772a(this.miX);
        C1720g.m3539RS().mo10310m(new C279921(), 1000);
        this.mjm = new C11871a();
        this.kGM = System.currentTimeMillis();
        if (bvL()) {
            this.miY.mo73791S(this.miT, false);
            this.jLm.setVisibility(8);
            this.miZ.setVisibility(8);
            this.mjn.setVisibility(0);
            C28023c c28023c = this.mjn;
            c28023c.mnI.mo65944s(true, c28023c.mnL);
            AppMethodBeat.m2505o(74086);
            return;
        }
        if (this.miT > 0) {
            this.miY.mo73791S(this.miT, true);
            this.mjn.setVisibility(8);
            this.jLm.setVisibility(0);
        }
        AppMethodBeat.m2505o(74086);
    }

    private boolean bvL() {
        return this.miT == 21;
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(74087);
        if (!this.mjm.mjz) {
            if (this.mhO.isEmpty() || this.jLm.getVisibility() != 0) {
                m44545U(1, 0, 0);
            } else {
                m44545U(2, 0, 0);
            }
        }
        this.mjn.mnI.onDetach();
        super.onDestroy();
        this.mhN.destory();
        this.mhN = null;
        ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavTagSetMgr().mo73772a(this.miX);
        ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavTagSetMgr().mo73774e(this.mjh);
        if (this.mhO != null) {
            this.mhO.finish();
        }
        AppMethodBeat.m2505o(74087);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        AppMethodBeat.m2504i(74088);
        C4990ab.m7410d("MicroMsg.FavSearchUI", "on create options menu");
        bvM();
        this.mjk = menu.add(0, 2131820645, 0, C25738R.string.f9104pl);
        C0464g.m803a(this.mjk, this.miY);
        C0464g.m806a(this.mjk, 9);
        this.miY.post(new C279914());
        C0464g.m802a(this.mjk, new C69085());
        this.mHandler.post(new C30736());
        AppMethodBeat.m2505o(74088);
        return true;
    }

    private void bvM() {
        AppMethodBeat.m2504i(74089);
        if (this.miY != null) {
            AppMethodBeat.m2505o(74089);
            return;
        }
        this.miY = (FavSearchActionView) View.inflate(this.mController.ylL, 2130969524, null);
        this.mji = this.miY.findViewById(2131820977);
        this.mji.setOnClickListener(new C30747());
        this.mjj = (ImageButton) this.miY.findViewById(2131823967);
        this.mjj.setVisibility(8);
        this.miY.setOnSearchChangedListener(new C30758());
        AppMethodBeat.m2505o(74089);
    }

    /* renamed from: U */
    private void m44545U(int i, int i2, int i3) {
        AppMethodBeat.m2504i(74090);
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
        this.mjm.mo23720IF();
        AppMethodBeat.m2505o(74090);
    }

    public void onResume() {
        long j = 0;
        AppMethodBeat.m2504i(74091);
        this.mhO.bvY();
        this.mhO.notifyDataSetChanged();
        FavCapacityPanel favCapacityPanel = this.mjb;
        if (favCapacityPanel.mpu != C39037b.buh() / 1048576) {
            favCapacityPanel.mpu = C39037b.buh() / 1048576;
            TextView textView = favCapacityPanel.mpv;
            Context context = favCapacityPanel.mpv.getContext();
            Object[] objArr = new Object[2];
            if (favCapacityPanel.mpx - favCapacityPanel.mpu > 0) {
                j = favCapacityPanel.mpx - favCapacityPanel.mpu;
            }
            objArr[0] = Long.valueOf(j);
            objArr[1] = Long.valueOf(favCapacityPanel.mpu);
            textView.setText(context.getString(C25738R.string.bn3, objArr));
        }
        C11853i.m19718LK(getClass().getSimpleName());
        if (bvL()) {
            C28023c c28023c = this.mjn;
            c28023c.fAq = C5046bo.anT();
            if (C1060a.isInstalled() && C1060a.m2339yK().mo4192F(C7466a.class) != null) {
                C7469c c7469c = ((C7466a) C1060a.m2339yK().mo4192F(C7466a.class)).bYx;
                if (c7469c != null) {
                    c7469c.mo16643a(c28023c.mnM);
                }
            }
            c28023c.mnI.onResume();
            if (c28023c.mnK) {
                if (c28023c.mnI.bwy()) {
                    c28023c.bwq();
                } else {
                    c28023c.bwr();
                }
            }
            c28023c.mnK = false;
        }
        super.onResume();
        AppMethodBeat.m2505o(74091);
    }

    public void onPause() {
        AppMethodBeat.m2504i(74092);
        C11853i.m19719LL(getClass().getSimpleName());
        if (bvL()) {
            C28023c c28023c = this.mjn;
            WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcMediaGalleryScrollEnable, c28023c.ehv);
            c28023c.ehv = 0;
            if (C1060a.isInstalled() && C1060a.m2339yK().mo4192F(C7466a.class) != null) {
                C7469c c7469c = ((C7466a) C1060a.m2339yK().mo4192F(C7466a.class)).bYx;
                if (c7469c != null) {
                    c7469c.mo16644b(c28023c.mnM);
                }
            }
            c28023c.fAq = C5046bo.anT() > c28023c.fAq ? C5046bo.anT() - c28023c.fAq : 1;
            WXHardCoderJNI.reportFPS(703, WXHardCoderJNI.hcMediaGalleryScrollAction, 1, c28023c.eEO, c28023c.fAq);
            c28023c.eEO = 0;
            c28023c.fAq = 0;
        }
        super.onPause();
        AppMethodBeat.m2505o(74092);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(74093);
        if (i == 1) {
            if (i2 != -1) {
                AppMethodBeat.m2505o(74093);
                return;
            }
            List<C20742d> list = this.mjn.mnS;
            String stringExtra = intent.getStringExtra("Select_Conv_User");
            if (C5046bo.isNullOrNil(stringExtra)) {
                AppMethodBeat.m2505o(74093);
                return;
            }
            ArrayList<String> P = C5046bo.m7508P(stringExtra.split(","));
            String stringExtra2 = intent.getStringExtra("custom_send_text");
            for (C20742d c20742d : list) {
                if (c20742d == null) {
                    C4990ab.m7411d("MicroMsg.FavSearchUI", "select %s, send item null, continute", stringExtra);
                } else {
                    C41268k c41268k = new C41268k();
                    if (C41268k.m71869u(c20742d.mnW)) {
                        C30379h.m48465bQ(this.mController.ylL, getString(C25738R.string.f8634ah));
                        AppMethodBeat.m2505o(74093);
                        return;
                    }
                    C4990ab.m7411d("MicroMsg.FavSearchUI", "select %s for sending", stringExtra);
                    if (c20742d.bws() || c20742d.bwt()) {
                        final C44275p b = C30379h.m48458b(this.mController.ylL, getString(C25738R.string.bp2), false, null);
                        C279903 c279903 = new Runnable() {
                            public final void run() {
                                AppMethodBeat.m2504i(74067);
                                b.dismiss();
                                AppMethodBeat.m2505o(74067);
                            }
                        };
                        for (String a : P) {
                            C11909i.m19790a(this, a, c20742d.cAJ, c279903);
                        }
                    } else {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(C39037b.m66370b(c20742d.cAJ));
                        for (String a2 : P) {
                            C32291o.ahj().mo73126a(C1853r.m3846Yz(), a2, arrayList, 0, false);
                        }
                    }
                }
            }
            if (!C5046bo.isNullOrNil(stringExtra2)) {
                for (String str : P) {
                    C12519g.bOk().mo46456F(str, stringExtra2, C1855t.m3925nK(str));
                }
            }
        }
        AppMethodBeat.m2505o(74093);
    }

    /* renamed from: d */
    static /* synthetic */ void m44558d(FavSearchUI favSearchUI) {
        AppMethodBeat.m2504i(74094);
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
        AppMethodBeat.m2505o(74094);
    }

    /* renamed from: l */
    static /* synthetic */ int m44566l(FavSearchUI favSearchUI) {
        AppMethodBeat.m2504i(74100);
        int size = favSearchUI.mje.size();
        int size2 = favSearchUI.mjf.size();
        int size3 = favSearchUI.mjg.size();
        if (size == 0 && size2 == 0 && size3 > 0) {
            AppMethodBeat.m2505o(74100);
            return 2;
        } else if (size == 0 && size2 > 0 && size3 == 0) {
            AppMethodBeat.m2505o(74100);
            return 3;
        } else if (size > 0 && size2 == 0 && size3 == 0) {
            AppMethodBeat.m2505o(74100);
            return 1;
        } else {
            AppMethodBeat.m2505o(74100);
            return 4;
        }
    }
}
