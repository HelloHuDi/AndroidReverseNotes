package com.tencent.p177mm.plugin.fav.p410ui;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C44275p;
import com.tencent.p177mm.p612ui.widget.snackbar.C5670b;
import com.tencent.p177mm.plugin.fav.p407a.C27966g;
import com.tencent.p177mm.plugin.fav.p407a.C27968h;
import com.tencent.p177mm.plugin.fav.p407a.C39037b;
import com.tencent.p177mm.plugin.fav.p407a.C39039w;
import com.tencent.p177mm.plugin.fav.p407a.C41268k;
import com.tencent.p177mm.plugin.fav.p407a.C6892ab;
import com.tencent.p177mm.plugin.fav.p407a.C7604ae;
import com.tencent.p177mm.plugin.fav.p410ui.p1260a.C34148a;
import com.tencent.p177mm.plugin.fav.p410ui.p1260a.C39056b;
import com.tencent.p177mm.plugin.fav.p410ui.p412d.C20714a.C3084b;
import com.tencent.p177mm.pluginsdk.p597ui.applet.C40463q.C30111a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.HashSet;
import java.util.Set;

/* renamed from: com.tencent.mm.plugin.fav.ui.FavSelectUI */
public class FavSelectUI extends FavBaseUI {
    private String mjA;
    private C39056b mjB = null;
    private Set<Integer> mjC = new HashSet();
    private C41268k mjD = new C41268k();
    private OnClickListener mjE = new C118725();
    private String toUser;

    /* renamed from: com.tencent.mm.plugin.fav.ui.FavSelectUI$5 */
    class C118725 implements OnClickListener {
        C118725() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(74107);
            int intValue = ((Integer) view.getTag()).intValue();
            Intent intent = new Intent();
            intent.putExtra("key_preset_search_type", intValue);
            FavSelectUI.m44568a(FavSelectUI.this, intent);
            AppMethodBeat.m2505o(74107);
        }
    }

    /* renamed from: com.tencent.mm.plugin.fav.ui.FavSelectUI$3 */
    class C207033 implements OnMenuItemClickListener {
        C207033() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(74103);
            FavSelectUI.this.finish();
            AppMethodBeat.m2505o(74103);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.fav.ui.FavSelectUI$1 */
    class C279971 implements Runnable {
        C279971() {
        }

        public final void run() {
            AppMethodBeat.m2504i(74101);
            FavSelectUI.this.mjB.bvY();
            FavSelectUI.this.bvz();
            AppMethodBeat.m2505o(74101);
        }
    }

    /* renamed from: com.tencent.mm.plugin.fav.ui.FavSelectUI$2 */
    class C279982 implements OnMenuItemClickListener {
        C279982() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(74102);
            FavSelectUI.m44568a(FavSelectUI.this, new Intent());
            AppMethodBeat.m2505o(74102);
            return true;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public FavSelectUI() {
        AppMethodBeat.m2504i(74108);
        AppMethodBeat.m2505o(74108);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(74109);
        super.onCreate(bundle);
        this.toUser = getIntent().getStringExtra("key_to_user");
        this.mjA = getIntent().getStringExtra("key_fav_item_id");
        if (this.mjA != null) {
            for (String str : this.mjA.split(",")) {
                int i = C5046bo.getInt(str, BaseClientBuilder.API_PRIORITY_OTHER);
                if (BaseClientBuilder.API_PRIORITY_OTHER != i) {
                    this.mjC.add(Integer.valueOf(i));
                }
            }
        }
        this.mjC.remove(Integer.valueOf(3));
        this.mjB.mo54725f(this.mjC);
        this.mjD.mfm = false;
        this.mjB.mo54719a((C39039w) this.mjD);
        this.mcy.post(new C279971());
        addIconOptionMenu(0, C1318a.actionbar_icon_dark_search, new C279982());
        setMMTitle((int) C25738R.string.brf);
        setBackBtn(new C207033());
        AppMethodBeat.m2505o(74109);
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        AppMethodBeat.m2504i(74110);
        final C3084b c3084b = (C3084b) view.getTag();
        if (c3084b == null) {
            C4990ab.m7420w("MicroMsg.FavSelectUI", "on item click, holder is null");
            AppMethodBeat.m2505o(74110);
        } else if (c3084b.mgf == null) {
            C4990ab.m7420w("MicroMsg.FavSelectUI", "on item click, info is null");
            AppMethodBeat.m2505o(74110);
        } else {
            C27966g c27966g = c3084b.mgf;
            C27968h.m44531j(c27966g.field_localId, 1, 1);
            if (c27966g.field_type == 3) {
                C5670b.m8523i(this, getString(C25738R.string.f8635ai));
                AppMethodBeat.m2505o(74110);
            } else if (c27966g.field_type == 8 && C1855t.m3913mZ(this.toUser)) {
                C5670b.m8523i(this, getString(C25738R.string.f8633ag));
                AppMethodBeat.m2505o(74110);
            } else {
                ((C6892ab) C1720g.m3528K(C6892ab.class)).mo15149a(this.mController.ylL, this.toUser, c3084b.mgf, true, new C30111a() {
                    /* renamed from: a */
                    public final void mo6399a(boolean z, String str, int i) {
                        AppMethodBeat.m2504i(74106);
                        FavSelectUI.this.aqX();
                        if (z) {
                            final C44275p b = C30379h.m48458b(FavSelectUI.this.mController.ylL, FavSelectUI.this.getString(C25738R.string.bp2), false, null);
                            C11909i.m19791a(FavSelectUI.this.mController.ylL, FavSelectUI.this.toUser, str, c3084b.mgf, new Runnable() {

                                /* renamed from: com.tencent.mm.plugin.fav.ui.FavSelectUI$4$1$1 */
                                class C30781 implements Runnable {
                                    C30781() {
                                    }

                                    public final void run() {
                                        AppMethodBeat.m2504i(74104);
                                        FavSelectUI.this.finish();
                                        AppMethodBeat.m2505o(74104);
                                    }
                                }

                                public final void run() {
                                    AppMethodBeat.m2504i(74105);
                                    if (b != null) {
                                        b.dismiss();
                                    }
                                    C5670b.m8523i(FavSelectUI.this, FavSelectUI.this.getString(C25738R.string.bnf));
                                    C5004al.m7442n(new C30781(), 1800);
                                    AppMethodBeat.m2505o(74105);
                                }
                            });
                        }
                        AppMethodBeat.m2505o(74106);
                    }
                });
                AppMethodBeat.m2505o(74110);
            }
        }
    }

    public final C34148a bvu() {
        AppMethodBeat.m2504i(74111);
        if (this.mjB == null) {
            this.mjB = new C39056b(this.mhy, false);
        }
        C39056b c39056b = this.mjB;
        AppMethodBeat.m2505o(74111);
        return c39056b;
    }

    /* Access modifiers changed, original: protected|final */
    public final void bvv() {
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean bvw() {
        AppMethodBeat.m2504i(74112);
        if (((C7604ae) C1720g.m3530M(C7604ae.class)).getFavItemInfoStorage().getCount() > 0) {
            AppMethodBeat.m2505o(74112);
            return true;
        }
        AppMethodBeat.m2505o(74112);
        return false;
    }

    /* Access modifiers changed, original: protected|final */
    public final void bvx() {
        AppMethodBeat.m2504i(74113);
        this.mht.setCompoundDrawablesWithIntrinsicBounds(0, C25738R.drawable.adw, 0, 0);
        this.mht.setCompoundDrawablePadding(C1338a.fromDPToPix(this.mController.ylL, 10));
        this.mht.setText(C25738R.string.boa);
        AppMethodBeat.m2505o(74113);
    }

    /* Access modifiers changed, original: protected|final */
    public final OnClickListener bvy() {
        return this.mjE;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(74114);
        if (i == 0 && -1 == i2) {
            finish();
            AppMethodBeat.m2505o(74114);
            return;
        }
        super.onActivityResult(i, i2, intent);
        AppMethodBeat.m2505o(74114);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(74115);
        super.onDestroy();
        if (this.mjB != null) {
            this.mjB.finish();
        }
        AppMethodBeat.m2505o(74115);
    }

    /* renamed from: a */
    static /* synthetic */ void m44568a(FavSelectUI favSelectUI, Intent intent) {
        AppMethodBeat.m2504i(74116);
        intent.putExtra("key_to_user", favSelectUI.toUser);
        intent.putExtra("key_fav_item_id", favSelectUI.mjA);
        intent.putExtra("key_search_type", 1);
        intent.putExtra("key_enter_fav_search_from", 1);
        Bundle bundle = null;
        if (VERSION.SDK_INT >= 21) {
            bundle = ActivityOptions.makeSceneTransitionAnimation(favSelectUI, new Pair[0]).toBundle();
        }
        C39037b.m66353a(favSelectUI.mController.ylL, ".ui.FavSearchUI", intent, 0, bundle);
        AppMethodBeat.m2505o(74116);
    }
}
