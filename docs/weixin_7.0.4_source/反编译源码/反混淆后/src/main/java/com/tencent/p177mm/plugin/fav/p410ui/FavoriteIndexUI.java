package com.tencent.p177mm.plugin.fav.p410ui;

import android.annotation.SuppressLint;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.p057v4.view.C0464g;
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
import com.google.firebase.analytics.FirebaseAnalytics.C8741b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.model.C37921n;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p230g.p231a.C18313ld;
import com.tencent.p177mm.p230g.p231a.C26189le;
import com.tencent.p177mm.p249m.C42164b;
import com.tencent.p177mm.p612ui.MMFragment;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C40671n.C5279d;
import com.tencent.p177mm.p612ui.base.C44275p;
import com.tencent.p177mm.p612ui.tools.C46696j;
import com.tencent.p177mm.p612ui.widget.p1095b.C24088a;
import com.tencent.p177mm.p612ui.widget.snackbar.C5670b;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.fav.p407a.C11853i;
import com.tencent.p177mm.plugin.fav.p407a.C20679y;
import com.tencent.p177mm.plugin.fav.p407a.C27966g;
import com.tencent.p177mm.plugin.fav.p407a.C27968h;
import com.tencent.p177mm.plugin.fav.p407a.C39037b;
import com.tencent.p177mm.plugin.fav.p407a.C39038m;
import com.tencent.p177mm.plugin.fav.p407a.C39038m.C20677d;
import com.tencent.p177mm.plugin.fav.p407a.C39038m.C27972c;
import com.tencent.p177mm.plugin.fav.p407a.C41268k;
import com.tencent.p177mm.plugin.fav.p407a.C43054d;
import com.tencent.p177mm.plugin.fav.p407a.C7604ae;
import com.tencent.p177mm.plugin.fav.p410ui.p1260a.C34148a;
import com.tencent.p177mm.plugin.fav.p410ui.p1260a.C34148a.C20713a;
import com.tencent.p177mm.plugin.fav.p410ui.p1260a.C39056b;
import com.tencent.p177mm.plugin.fav.p410ui.p412d.C20714a.C20717c;
import com.tencent.p177mm.plugin.fav.p410ui.p412d.C20714a.C3084b;
import com.tencent.p177mm.plugin.fav.p410ui.widget.C11919c.C11922a;
import com.tencent.p177mm.plugin.fav.p410ui.widget.C43088b;
import com.tencent.p177mm.plugin.fav.p410ui.widget.C43088b.C119181;
import com.tencent.p177mm.plugin.fav.p410ui.widget.C43088b.C280352;
import com.tencent.p177mm.plugin.fav.p410ui.widget.C43088b.C280363;
import com.tencent.p177mm.plugin.fav.p410ui.widget.C43088b.C39083a;
import com.tencent.p177mm.plugin.p1614i.C43217c;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.pluginsdk.p597ui.tools.C14987n;
import com.tencent.p177mm.protocal.protobuf.aar;
import com.tencent.p177mm.protocal.protobuf.aay;
import com.tencent.p177mm.protocal.protobuf.abh;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.vfs.C5728b;
import com.tencent.p177mm.vfs.C5730e;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.fav.ui.FavoriteIndexUI */
public class FavoriteIndexUI extends FavBaseUI implements C20717c, C11922a {
    private static final long mky = ((long) C42164b.m74341Nc());
    private C46696j contextMenuHelper;
    private OnClickListener mjE = new C341474();
    private C39056b mkA;
    private C43088b mkB;
    private C27966g mkC;
    private int[] mkD = new int[2];
    private C1202f mkE = new C3905318();
    private OnItemLongClickListener mkF = new C2070720();
    private C27966g mkG;
    private int mkz = 0;
    private long startTime = 0;

    /* renamed from: com.tencent.mm.plugin.fav.ui.FavoriteIndexUI$16 */
    class C1187616 implements DialogInterface.OnClickListener {
        C1187616() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(74242);
            dialogInterface.dismiss();
            AppMethodBeat.m2505o(74242);
        }
    }

    /* renamed from: com.tencent.mm.plugin.fav.ui.FavoriteIndexUI$20 */
    class C2070720 implements OnItemLongClickListener {
        C2070720() {
        }

        public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
            AppMethodBeat.m2504i(74246);
            if (i < FavoriteIndexUI.this.mhs.getHeaderViewsCount()) {
                C4990ab.m7420w("MicroMsg.FavoriteIndexUI", "on header view long click, ignore");
                AppMethodBeat.m2505o(74246);
            } else {
                FavoriteIndexUI.m71877a(FavoriteIndexUI.this, view, i, j, FavoriteIndexUI.this.mkD);
                AppMethodBeat.m2505o(74246);
            }
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.fav.ui.FavoriteIndexUI$5 */
    class C207105 implements C39083a {

        /* renamed from: com.tencent.mm.plugin.fav.ui.FavoriteIndexUI$5$2 */
        class C207112 implements DialogInterface.OnClickListener {
            C207112() {
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.m2504i(74224);
                FavoriteIndexUI.m71878a(FavoriteIndexUI.this, FavoriteIndexUI.this.mkA.mo61970hk(true));
                C7060h.pYm.mo8381e(11125, Integer.valueOf(r0.size()), Integer.valueOf(3));
                if (FavoriteIndexUI.this.mkA.mlh) {
                    FavoriteIndexUI.m71882b(FavoriteIndexUI.this);
                }
                AppMethodBeat.m2505o(74224);
            }
        }

        /* renamed from: com.tencent.mm.plugin.fav.ui.FavoriteIndexUI$5$1 */
        class C207121 implements DialogInterface.OnClickListener {
            C207121() {
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.m2504i(74223);
                FavoriteIndexUI.m71875a(FavoriteIndexUI.this, 4105);
                AppMethodBeat.m2505o(74223);
            }
        }

        C207105() {
        }

        public final void bvS() {
            AppMethodBeat.m2504i(74225);
            if (FavoriteIndexUI.m71881a(FavoriteIndexUI.this.mkA.mo61970hk(false), FavoriteIndexUI.this, new C207121())) {
                FavoriteIndexUI.m71875a(FavoriteIndexUI.this, 4105);
                AppMethodBeat.m2505o(74225);
                return;
            }
            AppMethodBeat.m2505o(74225);
        }

        public final void bvB() {
            AppMethodBeat.m2504i(74226);
            C30379h.m48440a(FavoriteIndexUI.this.mController.ylL, FavoriteIndexUI.this.getString(C25738R.string.bnq), "", new C207112(), null);
            AppMethodBeat.m2505o(74226);
        }

        public final void bvT() {
            AppMethodBeat.m2504i(74227);
            if (FavoriteIndexUI.this.mkA.bwb() <= 0) {
                AppMethodBeat.m2505o(74227);
            } else if (FavoriteIndexUI.this.mkA.bwb() > 1) {
                Intent intent = new Intent();
                intent.putExtra("key_fav_scene", 3);
                C39037b.m66352a(FavoriteIndexUI.this.mController.ylL, ".ui.FavTagEditUI", intent, 4104);
                C11853i.m19718LK("FavTagEditUI");
                AppMethodBeat.m2505o(74227);
            } else {
                C27966g c27966g = (C27966g) FavoriteIndexUI.this.mkA.mo61970hk(false).get(0);
                Intent intent2 = new Intent();
                intent2.putExtra("key_fav_scene", 3);
                intent2.putExtra("key_fav_item_id", c27966g.field_localId);
                C39037b.m66371b(FavoriteIndexUI.this.mController.ylL, ".ui.FavTagEditUI", intent2);
                C11853i.m19718LK("FavTagEditUI");
                if (FavoriteIndexUI.this.mkA.mlh) {
                    FavoriteIndexUI.m71882b(FavoriteIndexUI.this);
                }
                AppMethodBeat.m2505o(74227);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.fav.ui.FavoriteIndexUI$14 */
    class C2800114 implements DialogInterface.OnClickListener {
        C2800114() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(74240);
            dialogInterface.dismiss();
            AppMethodBeat.m2505o(74240);
        }
    }

    /* renamed from: com.tencent.mm.plugin.fav.ui.FavoriteIndexUI$15 */
    class C2800215 implements DialogInterface.OnClickListener {
        C2800215() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(74241);
            dialogInterface.dismiss();
            FavoriteIndexUI.this.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
            AppMethodBeat.m2505o(74241);
        }
    }

    /* renamed from: com.tencent.mm.plugin.fav.ui.FavoriteIndexUI$17 */
    class C2800317 implements Runnable {
        C2800317() {
        }

        public final void run() {
            AppMethodBeat.m2504i(74243);
            long currentTimeMillis = System.currentTimeMillis();
            List buY = ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavItemInfoStorage().buY();
            if (buY != null) {
                C4990ab.m7417i("MicroMsg.FavoriteIndexUI", "initInvalidFavItem getInvalid favitems , size = %d,start time = %s", Integer.valueOf(buY.size()), Long.valueOf(currentTimeMillis));
                if (buY.size() == 0) {
                    AppMethodBeat.m2505o(74243);
                    return;
                }
                int size = buY.size();
                for (int i = 0; i < size; i++) {
                    ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavItemInfoStorage().mo23701z((C27966g) buY.get(i));
                }
                C4990ab.m7417i("MicroMsg.FavoriteIndexUI", "initInvalidFavItem  cost time = %s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            }
            AppMethodBeat.m2505o(74243);
        }
    }

    /* renamed from: com.tencent.mm.plugin.fav.ui.FavoriteIndexUI$1 */
    class C341441 implements OnMenuItemClickListener {
        C341441() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(74219);
            if (FavoriteIndexUI.this.mkA.mlh) {
                FavoriteIndexUI.m71882b(FavoriteIndexUI.this);
                AppMethodBeat.m2505o(74219);
            } else {
                FavoriteIndexUI.this.finish();
                AppMethodBeat.m2505o(74219);
            }
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.fav.ui.FavoriteIndexUI$2 */
    class C341452 implements Runnable {
        C341452() {
        }

        public final void run() {
            AppMethodBeat.m2504i(74220);
            FavoriteIndexUI.this.mhw.bwA();
            AppMethodBeat.m2505o(74220);
        }
    }

    /* renamed from: com.tencent.mm.plugin.fav.ui.FavoriteIndexUI$3 */
    class C341463 implements OnMenuItemClickListener {
        C341463() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(74221);
            FavoriteIndexUI.m71889g(FavoriteIndexUI.this);
            AppMethodBeat.m2505o(74221);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.fav.ui.FavoriteIndexUI$4 */
    class C341474 implements OnClickListener {
        C341474() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(74222);
            int intValue = ((Integer) view.getTag()).intValue();
            Intent intent = new Intent();
            intent.putExtra("key_enter_fav_search_from", 0);
            intent.putExtra("key_preset_search_type", intValue);
            FavoriteIndexUI.m71876a(FavoriteIndexUI.this, intent);
            AppMethodBeat.m2505o(74222);
        }
    }

    /* renamed from: com.tencent.mm.plugin.fav.ui.FavoriteIndexUI$18 */
    class C3905318 implements C1202f {

        /* renamed from: com.tencent.mm.plugin.fav.ui.FavoriteIndexUI$18$1 */
        class C341431 implements Runnable {
            C341431() {
            }

            public final void run() {
                AppMethodBeat.m2504i(74244);
                FavoriteIndexUI.this.mhw.bwA();
                AppMethodBeat.m2505o(74244);
            }
        }

        C3905318() {
        }

        public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
            AppMethodBeat.m2504i(74245);
            C4990ab.m7416i("MicroMsg.FavoriteIndexUI", "onUsedCapacityChanged");
            FavoriteIndexUI.this.mhw.post(new C341431());
            AppMethodBeat.m2505o(74245);
        }
    }

    /* renamed from: com.tencent.mm.plugin.fav.ui.FavoriteIndexUI$13 */
    class C4126913 implements DialogInterface.OnClickListener {
        C4126913() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(74239);
            dialogInterface.dismiss();
            FavoriteIndexUI.this.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
            AppMethodBeat.m2505o(74239);
        }
    }

    /* renamed from: com.tencent.mm.plugin.fav.ui.FavoriteIndexUI$23 */
    class C4127023 implements C20713a {
        C4127023() {
        }

        public final void bvU() {
            AppMethodBeat.m2504i(74250);
            FavoriteIndexUI.this.mhw.mo23770hn(true);
            AppMethodBeat.m2505o(74250);
        }
    }

    /* renamed from: com.tencent.mm.plugin.fav.ui.FavoriteIndexUI$24 */
    class C4127124 implements Runnable {
        C4127124() {
        }

        public final void run() {
            AppMethodBeat.m2504i(74251);
            FavoriteIndexUI.this.mhw.bwA();
            AppMethodBeat.m2505o(74251);
        }
    }

    /* renamed from: com.tencent.mm.plugin.fav.ui.FavoriteIndexUI$12 */
    class C4127312 implements OnTouchListener {
        C4127312() {
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            AppMethodBeat.m2504i(74238);
            switch (motionEvent.getAction()) {
                case 0:
                    FavoriteIndexUI.this.mkD[0] = (int) motionEvent.getRawX();
                    FavoriteIndexUI.this.mkD[1] = (int) motionEvent.getRawY();
                    break;
            }
            AppMethodBeat.m2505o(74238);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.fav.ui.FavoriteIndexUI$19 */
    class C4127419 implements Runnable {
        C4127419() {
        }

        public final void run() {
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public FavoriteIndexUI() {
        AppMethodBeat.m2504i(74252);
        AppMethodBeat.m2505o(74252);
    }

    /* renamed from: b */
    static /* synthetic */ void m71882b(FavoriteIndexUI favoriteIndexUI) {
        AppMethodBeat.m2504i(74276);
        favoriteIndexUI.bvQ();
        AppMethodBeat.m2505o(74276);
    }

    static {
        AppMethodBeat.m2504i(74283);
        AppMethodBeat.m2505o(74283);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(74253);
        this.mhz = this;
        C4990ab.m7416i("MicroMsg.FavoriteIndexUI", "onCreate favoriteindex");
        super.onCreate(bundle);
        if (((C7604ae) C1720g.m3530M(C7604ae.class)).getFavItemInfoStorage().buR() == null) {
            C4990ab.m7412e("MicroMsg.FavoriteIndexUI", "onCreate favoriteindex, but favorite db is null ,return");
            finish();
            AppMethodBeat.m2505o(74253);
            return;
        }
        ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavCdnService().mo7318hf(false);
        setMMTitle((int) C25738R.string.bp8);
        setBackBtn(new C341441());
        this.mhs.setOnItemLongClickListener(this.mkF);
        this.mhs.setOnTouchListener(new C4127312());
        C1720g.m3540Rg().mo14539a(438, this.mkE);
        C1720g.m3540Rg().mo14539a(401, this.mkE);
        this.contextMenuHelper = new C46696j(this);
        addIconOptionMenu(11, C25738R.string.bn2, C1318a.actionbar_icon_dark_add, new C341463());
        this.mkB = new C43088b();
        C43088b c43088b = this.mkB;
        View findViewById = findViewById(2131823888);
        c43088b.mpz = false;
        c43088b.mpA = findViewById;
        this.mkB.mpH = new C207105();
        C1720g.m3539RS().mo10302aa(new C2800317());
        C43054d.bur().mo68585a(null);
        C45932c.bvD();
        C11853i.start();
        AppMethodBeat.m2505o(74253);
    }

    /* Access modifiers changed, original: protected|final */
    public final void bvz() {
        AppMethodBeat.m2504i(74254);
        super.bvz();
        this.fbD.post(new C4127419());
        AppMethodBeat.m2505o(74254);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(74255);
        super.onDestroy();
        if (((C7604ae) C1720g.m3530M(C7604ae.class)).getFavItemInfoStorage().buR() == null) {
            AppMethodBeat.m2505o(74255);
            return;
        }
        ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavCdnService().mo7318hf(true);
        if (this.mkA != null) {
            this.mkA.finish();
        }
        C18313ld c18313ld = new C18313ld();
        c18313ld.cGU.type = 12;
        C4879a.xxA.mo10055m(c18313ld);
        C1720g.m3540Rg().mo14546b(438, this.mkE);
        C1720g.m3540Rg().mo14546b(401, this.mkE);
        C11853i.end();
        C45932c.bvC();
        AppMethodBeat.m2505o(74255);
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        AppMethodBeat.m2504i(74256);
        if (4 == i && this.mkA.mlh) {
            bvQ();
            AppMethodBeat.m2505o(74256);
            return true;
        }
        boolean onKeyUp = super.onKeyUp(i, keyEvent);
        AppMethodBeat.m2505o(74256);
        return onKeyUp;
    }

    private void bvQ() {
        AppMethodBeat.m2504i(74257);
        this.mkA.mo61959a(false, null);
        this.mhs.setOnItemLongClickListener(this.mkF);
        showOptionMenu(11, true);
        this.mkB.hide();
        AppMethodBeat.m2505o(74257);
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        AppMethodBeat.m2504i(74258);
        switch (this.mkz) {
            case 0:
                if (this.mkA != null) {
                    this.mkA.onItemClick(adapterView, view, i, j);
                    C3084b c3084b = (C3084b) view.getTag();
                    if (c3084b != null) {
                        if (c3084b.mgf != null) {
                            C4990ab.m7417i("MicroMsg.FavoriteIndexUI", "click type is %d", Integer.valueOf(c3084b.mgf.field_type));
                            C7060h.pYm.mo8381e(12746, Integer.valueOf(c3084b.mgf.field_type), Integer.valueOf(0), Integer.valueOf(i - 1));
                            break;
                        }
                        C4990ab.m7420w("MicroMsg.FavoriteIndexUI", "on item click, info is null..");
                        AppMethodBeat.m2505o(74258);
                        return;
                    }
                    C4990ab.m7420w("MicroMsg.FavoriteIndexUI", "on item click, holder is null..");
                    AppMethodBeat.m2505o(74258);
                    return;
                }
                break;
        }
        AppMethodBeat.m2505o(74258);
    }

    public final C34148a bvu() {
        AppMethodBeat.m2504i(74259);
        if (this.mkA == null) {
            this.mkA = new C39056b(this.mhy, false);
            this.mkA.mo54720a((C20713a) new C4127023());
            this.mkA.mlo = this;
            this.mkA.scene = 1;
            this.mkA.mlr = this.mhs;
        }
        C39056b c39056b = this.mkA;
        AppMethodBeat.m2505o(74259);
        return c39056b;
    }

    /* Access modifiers changed, original: protected|final */
    public final void bvv() {
        AppMethodBeat.m2504i(74260);
        this.mhw.post(new C4127124());
        AppMethodBeat.m2505o(74260);
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean bvw() {
        int buS;
        AppMethodBeat.m2504i(74261);
        switch (this.mkz) {
            case 3:
                buS = ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavItemInfoStorage().buS();
                break;
            default:
                buS = ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavItemInfoStorage().getCount();
                break;
        }
        if (buS > 0) {
            AppMethodBeat.m2505o(74261);
            return true;
        }
        AppMethodBeat.m2505o(74261);
        return false;
    }

    /* Access modifiers changed, original: protected|final */
    @SuppressLint({"ResourceType"})
    public final void bvx() {
        AppMethodBeat.m2504i(74262);
        switch (this.mkz) {
            case 3:
                this.mht.setCompoundDrawablesWithIntrinsicBounds(0, C1318a.fav_list_img_default, 0, 0);
                this.mht.setCompoundDrawablePadding(C1338a.fromDPToPix(this.mController.ylL, 10));
                this.mht.setText(C25738R.string.bob);
                AppMethodBeat.m2505o(74262);
                return;
            default:
                this.mht.setCompoundDrawablesWithIntrinsicBounds(0, C25738R.drawable.adw, 0, 0);
                this.mht.setCompoundDrawablePadding(C1338a.fromDPToPix(this.mController.ylL, 10));
                this.mht.setText(C25738R.string.boa);
                AppMethodBeat.m2505o(74262);
                return;
        }
    }

    public void onResume() {
        AppMethodBeat.m2504i(74263);
        long currentTimeMillis = System.currentTimeMillis();
        super.onResume();
        this.fbD.post(new C341452());
        C4990ab.m7411d("MicroMsg.FavoriteIndexUI", "on resume use %d ms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        C11853i.m19718LK(getClass().getSimpleName());
        AppMethodBeat.m2505o(74263);
    }

    public void onPause() {
        AppMethodBeat.m2504i(74264);
        super.onPause();
        C11853i.m19719LL(getClass().getSimpleName());
        AppMethodBeat.m2505o(74264);
    }

    /* Access modifiers changed, original: protected|final */
    public final OnClickListener bvy() {
        return this.mjE;
    }

    /* Access modifiers changed, original: protected|final */
    public final void initHeaderView() {
        AppMethodBeat.m2504i(74265);
        super.initHeaderView();
        this.mhw.mo23770hn(false);
        AppMethodBeat.m2505o(74265);
    }

    /* renamed from: a */
    private void m71879a(List<C27966g> list, String str, String str2) {
        AppMethodBeat.m2504i(74266);
        if (list == null || list.isEmpty()) {
            AppMethodBeat.m2505o(74266);
        } else if (C5046bo.isNullOrNil(str2)) {
            AppMethodBeat.m2505o(74266);
        } else {
            boolean kH = C1855t.m3896kH(str2);
            C41268k c41268k = new C41268k();
            List<C27966g> linkedList = new LinkedList();
            for (C27966g c27966g : list) {
                if (!c41268k.mo61948t(c27966g)) {
                    C27968h.m44531j(c27966g.field_localId, 1, 0);
                    linkedList.add(c27966g);
                    C39038m.m66422a(kH ? C27972c.Chatroom : C27972c.Chat, c27966g, C20677d.Samll, kH ? C37921n.m64060mA(str2) : 0);
                }
            }
            if (linkedList.isEmpty()) {
                C4990ab.m7416i("MicroMsg.FavoriteIndexUI", "after filter, nothing");
                C30379h.m48465bQ(getApplicationContext(), getString(C25738R.string.br6));
                AppMethodBeat.m2505o(74266);
                return;
            }
            final C44275p b = C30379h.m48458b(this.mController.ylL, getString(C25738R.string.bp2), false, null);
            C11909i.m19792a(this.mController.ylL, str2, str, (List) linkedList, new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(74234);
                    b.dismiss();
                    C5670b.m8523i(FavoriteIndexUI.this, FavoriteIndexUI.this.getString(C25738R.string.bnf));
                    AppMethodBeat.m2505o(74234);
                }
            });
            for (C27966g c27966g2 : linkedList) {
                if (c27966g2 != null && c27966g2.field_type == 5) {
                    String str3 = "";
                    if (c27966g2.field_favProto.whA != null) {
                        str3 = c27966g2.field_favProto.whA.wiY;
                    }
                    if (c27966g2.field_favProto.wit != null && C5046bo.isNullOrNil(r1)) {
                        str3 = c27966g2.field_favProto.wit.link;
                    }
                    if (!C5046bo.isNullOrNil(str3)) {
                        C4990ab.m7411d("MicroMsg.FavoriteIndexUI", "report(%s), url : %s, clickTimestamp : %d, scene : %d, actionType : %d, flag : %d", Integer.valueOf(13378), str3, Long.valueOf(this.startTime), Integer.valueOf(4), Integer.valueOf(1), Integer.valueOf(1));
                        String str4 = "";
                        try {
                            str4 = URLEncoder.encode(str3, "UTF-8");
                        } catch (UnsupportedEncodingException e) {
                            C4990ab.printErrStackTrace("MicroMsg.FavoriteIndexUI", e, "", new Object[0]);
                        }
                        C7060h.pYm.mo8381e(13378, str4, Long.valueOf(this.startTime), Integer.valueOf(4), Integer.valueOf(1), Integer.valueOf(1));
                    }
                }
            }
            C7060h.pYm.mo8381e(11125, Integer.valueOf(linkedList.size()), Integer.valueOf(1));
            AppMethodBeat.m2505o(74266);
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        String str;
        AppMethodBeat.m2504i(74267);
        super.onActivityResult(i, i2, intent);
        switch (i) {
            case 4105:
            case 4106:
                C11853i.m19719LL(".ui.transmit.SelectConversationUI");
                break;
        }
        C4990ab.m7417i("MicroMsg.FavoriteIndexUI", "onActivityResult reqCode: %d, retCod: %d", Integer.valueOf(i), Integer.valueOf(i2));
        String str2;
        if (i2 != -1) {
            if ((this.mkG != null && this.mkG.field_type == 5) || (this.mkC != null && this.mkC.field_type == 5)) {
                str2 = "";
                if (this.mkC == null || this.mkC.field_favProto.wit == null) {
                    if (this.mkG.field_favProto.whA != null) {
                        str2 = this.mkG.field_favProto.whA.wiY;
                    }
                    if (this.mkG.field_favProto.wit != null && C5046bo.isNullOrNil(str2)) {
                        str2 = this.mkG.field_favProto.wit.link;
                    }
                } else {
                    str2 = this.mkC.field_favProto.wit.link;
                }
                if (!C5046bo.isNullOrNil(str2)) {
                    C4990ab.m7411d("MicroMsg.FavoriteIndexUI", "report(%s), url : %s, clickTimestamp : %d, scene : %d, actionType : %d, flag : %d", Integer.valueOf(13378), str2, Long.valueOf(this.startTime), Integer.valueOf(4), Integer.valueOf(1), Integer.valueOf(3));
                    str = "";
                    try {
                        str2 = URLEncoder.encode(str2, "UTF-8");
                    } catch (UnsupportedEncodingException e) {
                        C4990ab.printErrStackTrace("MicroMsg.FavoriteIndexUI", e, "", new Object[0]);
                        str2 = str;
                    }
                    C7060h.pYm.mo8381e(13378, str2, Long.valueOf(this.startTime), Integer.valueOf(4), Integer.valueOf(1), Integer.valueOf(3));
                }
            }
            AppMethodBeat.m2505o(74267);
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
                            AppMethodBeat.m2504i(74236);
                            FavoriteIndexUI.this.mhp = true;
                            C3109h.m5352bO(stringArrayListExtra);
                            AppMethodBeat.m2505o(74236);
                        }
                    });
                    break;
                }
                C4990ab.m7412e("MicroMsg.FavoriteIndexUI", "onActivityResult pathList is null or nil");
                AppMethodBeat.m2505o(74267);
                return;
                break;
            case 4097:
                final double doubleExtra = intent.getDoubleExtra("kwebmap_slat", 0.0d);
                final double doubleExtra2 = intent.getDoubleExtra("kwebmap_lng", 0.0d);
                final int intExtra = intent.getIntExtra("kwebmap_scale", 0);
                final String bc = C5046bo.m7532bc(intent.getStringExtra("Kwebmap_locaion"), "");
                final CharSequence charSequenceExtra = intent.getCharSequenceExtra("kRemark");
                final String stringExtra = intent.getStringExtra("kPoiName");
                final ArrayList stringArrayListExtra2 = intent.getStringArrayListExtra("kTags");
                this.mcy.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(74237);
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
                        aay.mo15621E(d);
                        aay.mo15620D(d2);
                        aay.mo15622LJ(i);
                        aay.alv(str2);
                        C27966g c27966g = new C27966g();
                        c27966g.field_type = 6;
                        c27966g.field_sourceType = 6;
                        c27966g.field_favProto.mo74743b(aay);
                        if (!(charSequence == null || C5046bo.isNullOrNil(charSequence.toString()))) {
                            c27966g.field_favProto.alA(charSequence.toString());
                            c27966g.field_favProto.mo74747mj(C5046bo.anU());
                            C7060h.pYm.mo8381e(10873, Integer.valueOf(6));
                        }
                        C3109h.m5348E(c27966g);
                        if (!(arrayList == null || arrayList.isEmpty())) {
                            for (String LJ : arrayList) {
                                c27966g.mo45883LJ(LJ);
                            }
                        }
                        C34157b.m56005B(c27966g);
                        C7060h.pYm.mo8381e(10648, Integer.valueOf(3), Integer.valueOf(0));
                        C39037b.m66405it(c27966g.field_localId);
                        long j = c27966g.field_localId;
                        C27966g iE = ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavItemInfoStorage().mo23693iE(j);
                        if (!(iE == null || iE.field_favProto.why == null)) {
                            C39037b.m66351a(j, iE.field_favProto.why, "", "", new ArrayList(), FavoriteIndexUI.this.mController.ylL);
                        }
                        AppMethodBeat.m2505o(74237);
                    }
                });
                i3 = 0;
                break;
            case 4098:
                str = C14987n.m23320h(getApplicationContext(), intent, C43217c.m76863XW());
                if (str != null) {
                    Intent intent2 = new Intent();
                    intent2.putExtra("CropImageMode", 4);
                    intent2.putExtra("CropImage_Filter", true);
                    intent2.putExtra("CropImage_ImgPath", str);
                    intent2.setClassName(this.mController.ylL, "com.tencent.mm.ui.tools.CropImageNewUI");
                    startActivityForResult(intent2, 4099);
                    break;
                }
                C4990ab.m7420w("MicroMsg.FavoriteIndexUI", "take picture result path is null");
                AppMethodBeat.m2505o(74267);
                return;
            case 4099:
                str = intent.getStringExtra("CropImage_OutputPath");
                if (str != null) {
                    i3 = 0;
                    final ArrayList arrayList = new ArrayList();
                    arrayList.add(str);
                    this.mcy.post(new Runnable() {
                        public final void run() {
                            AppMethodBeat.m2504i(74235);
                            FavoriteIndexUI.this.mhp = true;
                            C3109h.m5352bO(arrayList);
                            AppMethodBeat.m2505o(74235);
                        }
                    });
                    break;
                }
                C4990ab.m7420w("MicroMsg.FavoriteIndexUI", "crop picture resutl path is null");
                AppMethodBeat.m2505o(74267);
                return;
            case 4100:
                str2 = intent.getStringExtra("choosed_file_path");
                if (!C5046bo.isNullOrNil(str2)) {
                    C5728b c5728b = new C5728b(str2);
                    if (c5728b.exists()) {
                        if (c5728b.length() < mky) {
                            Object obj;
                            if (C5046bo.isNullOrNil(str2)) {
                                obj = null;
                            } else {
                                c5728b = new C5728b(str2);
                                if (c5728b.exists()) {
                                    C27966g c27966g = new C27966g();
                                    c27966g.field_type = 8;
                                    c27966g.field_sourceType = 6;
                                    C3109h.m5348E(c27966g);
                                    c27966g.field_favProto.alB(c5728b.getName());
                                    aar aar = new aar();
                                    aar.akV(str2);
                                    aar.mo27435oY(true);
                                    aar.akH(c5728b.getName());
                                    aar.mo27394LE(c27966g.field_type);
                                    aar.akR(C5730e.m8630cv(str2));
                                    c27966g.field_favProto.wiv.add(aar);
                                    C34157b.m56005B(c27966g);
                                    C7060h.pYm.mo8381e(10648, Integer.valueOf(5), Integer.valueOf(0));
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
                    AppMethodBeat.m2505o(74267);
                    return;
                }
                i3 = this.mkA.mo61971iK(longExtra);
                if (-1 == i3) {
                    AppMethodBeat.m2505o(74267);
                    return;
                }
                this.mhs.removeFooterView(this.mhu);
                this.mhs.setSelection(i3);
                AppMethodBeat.m2505o(74267);
                return;
            case 4104:
                final List hk = this.mkA.mo61970hk(false);
                final String[] stringArrayExtra = intent.getStringArrayExtra("key_fav_result_array");
                if (!(hk.isEmpty() || stringArrayExtra == null || stringArrayExtra.length <= 0)) {
                    final C44275p b = C30379h.m48458b(this.mController.ylL, "", false, null);
                    C1720g.m3539RS().mo10302aa(new Runnable() {

                        /* renamed from: com.tencent.mm.plugin.fav.ui.FavoriteIndexUI$7$1 */
                        class C118781 implements Runnable {
                            C118781() {
                            }

                            public final void run() {
                                AppMethodBeat.m2504i(74231);
                                b.dismiss();
                                AppMethodBeat.m2505o(74231);
                            }

                            public final String toString() {
                                AppMethodBeat.m2504i(74232);
                                String str = super.toString() + "|batchAddFavTags";
                                AppMethodBeat.m2505o(74232);
                                return str;
                            }
                        }

                        public final void run() {
                            AppMethodBeat.m2504i(74233);
                            FavoriteIndexUI.m71880a(hk, stringArrayExtra);
                            C5004al.m7441d(new C118781());
                            AppMethodBeat.m2505o(74233);
                        }
                    });
                    C7060h.pYm.mo8381e(11125, Integer.valueOf(stringArrayExtra.length), Integer.valueOf(2));
                    break;
                }
            case 4105:
                C4990ab.m7411d("MicroMsg.FavoriteIndexUI", "select %s for sending", intent.getStringExtra("Select_Conv_User"));
                m71879a(this.mkA.mo61970hk(false), str, r4);
                break;
            case 4106:
                C4990ab.m7411d("MicroMsg.FavoriteIndexUI", "select %s for sending", intent.getStringExtra("Select_Conv_User"));
                List arrayList2 = new ArrayList();
                arrayList2.add(this.mkG);
                m71879a(arrayList2, str, r4);
                break;
        }
        if (i3 == 0) {
            C30379h.m48465bQ(this.mController.ylL, getString(C25738R.string.bpv));
            AppMethodBeat.m2505o(74267);
        } else if (1 == i3) {
            C30379h.m48465bQ(this.mController.ylL, getString(C25738R.string.bog));
            AppMethodBeat.m2505o(74267);
        } else if (3 == i3) {
            Toast.makeText(this.mController.ylL, getString(C25738R.string.bs4), 1).show();
            AppMethodBeat.m2505o(74267);
        } else {
            if (this.mkA.mlh) {
                bvQ();
            }
            AppMethodBeat.m2505o(74267);
        }
    }

    /* renamed from: iI */
    public final void mo36019iI(long j) {
        AppMethodBeat.m2504i(74268);
        if (this.mkA.mlh) {
            boolean z;
            C43088b c43088b = this.mkB;
            if (this.mkA.bwb() > 0) {
                z = true;
            } else {
                z = false;
            }
            if (c43088b.mpz) {
                c43088b.mpE.setEnabled(z);
                c43088b.mpF.setEnabled(z);
                c43088b.mpG.setEnabled(z);
            }
        }
        AppMethodBeat.m2505o(74268);
    }

    @SuppressLint({"ResourceType"})
    public boolean onCreateOptionsMenu(Menu menu) {
        AppMethodBeat.m2504i(74269);
        MenuItem add = menu.add(0, 10, 0, C25738R.string.ewn);
        add.setIcon(C1318a.actionbar_icon_dark_search);
        C0464g.m806a(add, 2);
        boolean onCreateOptionsMenu = super.onCreateOptionsMenu(menu);
        AppMethodBeat.m2505o(74269);
        return onCreateOptionsMenu;
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        AppMethodBeat.m2504i(74270);
        if (menuItem.getItemId() == 10) {
            Intent intent = new Intent();
            intent.putExtra("key_enter_fav_search_from", 0);
            m71871T(intent);
            AppMethodBeat.m2505o(74270);
            return true;
        }
        boolean onOptionsItemSelected = super.onOptionsItemSelected(menuItem);
        AppMethodBeat.m2505o(74270);
        return onOptionsItemSelected;
    }

    /* renamed from: T */
    private void m71871T(Intent intent) {
        AppMethodBeat.m2504i(74271);
        Bundle bundle = null;
        if (VERSION.SDK_INT >= 21) {
            bundle = ActivityOptions.makeSceneTransitionAnimation(this, new Pair[0]).toBundle();
        }
        if (this.mkA.mlh) {
            intent.putExtra("key_search_type", 2);
            C39037b.m66353a(this, ".ui.FavSearchUI", intent, 4103, bundle);
            AppMethodBeat.m2505o(74271);
            return;
        }
        C39037b.m66354a((Context) this, ".ui.FavSearchUI", intent, bundle);
        AppMethodBeat.m2505o(74271);
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        AppMethodBeat.m2504i(74272);
        if (iArr == null || iArr.length <= 0) {
            C4990ab.m7417i("MicroMsg.FavoriteIndexUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", Integer.valueOf(i), Long.valueOf(Thread.currentThread().getId()));
            AppMethodBeat.m2505o(74272);
            return;
        }
        C4990ab.m7417i("MicroMsg.FavoriteIndexUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId()));
        switch (i) {
            case 64:
                if (iArr[0] != 0) {
                    C30379h.m48445a((Context) this, getString(C25738R.string.dby), "", getString(C25738R.string.ckr), getString(C25738R.string.f9076or), false, new C2800215(), new C1187616());
                    break;
                }
                Intent intent = new Intent();
                intent.putExtra(MMFragment.FLAG_OVERRIDE_EXIT_ANIMATION, C25738R.anim.f8373ce);
                intent.putExtra(MMFragment.FLAG_OVERRIDE_ENTER_ANIMATION, C25738R.anim.f8332b5);
                intent.putExtra("map_view_type", 3);
                C25985d.m41468b((Context) this, C8741b.LOCATION, ".ui.RedirectUI", intent, 4097);
                AppMethodBeat.m2505o(74272);
                return;
            case 80:
                if (iArr[0] == 0) {
                    C39037b.m66352a((Context) this, ".ui.FavPostVoiceUI", new Intent(), 4102);
                    overridePendingTransition(0, 0);
                    AppMethodBeat.m2505o(74272);
                    return;
                }
                C30379h.m48445a((Context) this, getString(C25738R.string.dc0), "", getString(C25738R.string.ckr), getString(C25738R.string.f9076or), false, new C4126913(), new C2800114());
                AppMethodBeat.m2505o(74272);
                return;
        }
        AppMethodBeat.m2505o(74272);
    }

    public final void bvR() {
        AppMethodBeat.m2504i(74273);
        Intent intent = new Intent();
        intent.putExtra("key_enter_fav_cleanui_from", 0);
        C39037b.m66371b(this.mController.ylL, ".ui.FavCleanUI", intent);
        AppMethodBeat.m2505o(74273);
    }

    /* renamed from: a */
    public static void m71880a(List<C27966g> list, String[] strArr) {
        AppMethodBeat.m2504i(74274);
        if (list == null || list.isEmpty()) {
            AppMethodBeat.m2505o(74274);
        } else if (strArr == null || strArr.length <= 0) {
            AppMethodBeat.m2505o(74274);
        } else {
            LinkedList<C27966g> linkedList = new LinkedList();
            for (C27966g c27966g : list) {
                int i = 0;
                for (String LJ : strArr) {
                    i |= c27966g.mo45883LJ(LJ);
                }
                if (i != 0) {
                    ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavItemInfoStorage().mo23678a(c27966g, "localId");
                    C39037b.m66415p(c27966g);
                    linkedList.add(c27966g);
                }
            }
            for (C27966g a : linkedList) {
                C39037b.m66358a(a, 3);
            }
            AppMethodBeat.m2505o(74274);
        }
    }

    /* renamed from: a */
    public static boolean m71881a(List<C27966g> list, Context context, DialogInterface.OnClickListener onClickListener) {
        AppMethodBeat.m2504i(74275);
        if (list == null || list.isEmpty()) {
            AppMethodBeat.m2505o(74275);
            return true;
        }
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        C41268k c41268k = new C41268k();
        Object obj = null;
        int i4 = 0;
        for (C27966g c27966g : list) {
            if (!(c27966g == null || c27966g.field_favProto == null || c27966g.field_favProto.wiv == null)) {
                if (c27966g.field_type == 3) {
                    i3++;
                } else {
                    int i5;
                    Iterator it = c27966g.field_favProto.wiv.iterator();
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
                    if (C41268k.m71869u(c27966g)) {
                        i5 = i4 + 1;
                        if (i6 > 0) {
                            i6--;
                        }
                    } else {
                        i5 = i4;
                    }
                    if (obj == null && r7 == c27966g.field_favProto.wiv.size()) {
                        obj = 1;
                    }
                    obj = obj;
                    i4 = i5;
                }
            }
        }
        if (1 == list.size()) {
            if (((C27966g) list.get(0)).field_type == 14 && (i > 0 || i2 > 0)) {
                C30379h.m48465bQ(context, context.getString(C25738R.string.bny));
                AppMethodBeat.m2505o(74275);
                return false;
            } else if (i > 0) {
                C30379h.m48465bQ(context, context.getString(C25738R.string.bnz));
                AppMethodBeat.m2505o(74275);
                return false;
            } else if (i2 > 0) {
                switch (((C27966g) list.get(0)).field_type) {
                    case 2:
                        C30379h.m48465bQ(context, context.getString(C25738R.string.bo1));
                        break;
                    case 4:
                    case 16:
                        C30379h.m48465bQ(context, context.getString(C25738R.string.bo2));
                        break;
                    case 8:
                        C30379h.m48465bQ(context, context.getString(C25738R.string.bo0));
                        break;
                }
                AppMethodBeat.m2505o(74275);
                return false;
            } else if (i4 > 0) {
                C30379h.m48465bQ(context, context.getString(C25738R.string.f8634ah));
                AppMethodBeat.m2505o(74275);
                return false;
            } else if (i3 > 0) {
                C30379h.m48465bQ(context, context.getString(C25738R.string.f8635ai));
                AppMethodBeat.m2505o(74275);
                return false;
            }
        } else if (i > 0 || i2 > 0 || i4 > 0 || i3 > 0) {
            if (obj != null) {
                C30379h.m48444a(context, context.getString(C25738R.string.bo4), "", context.getString(C25738R.string.atd), context.getString(C25738R.string.atb), onClickListener, null, (int) C25738R.color.a61);
            } else {
                C30379h.m48465bQ(context, context.getString(C25738R.string.bo3));
            }
            AppMethodBeat.m2505o(74275);
            return false;
        }
        AppMethodBeat.m2505o(74275);
        return true;
    }

    /* renamed from: a */
    static /* synthetic */ void m71877a(FavoriteIndexUI favoriteIndexUI, View view, final int i, long j, int[] iArr) {
        AppMethodBeat.m2504i(74277);
        new C24088a(favoriteIndexUI.mController.ylL, view).mo39885a(view, i, j, new OnCreateContextMenuListener() {
            public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
                AppMethodBeat.m2504i(74247);
                C41268k c41268k = new C41268k();
                C27966g vE = FavoriteIndexUI.this.mkA.mo61974vE((i - FavoriteIndexUI.this.mhs.getHeaderViewsCount()) - 1);
                boolean t = c41268k.mo61948t(vE);
                if (!t) {
                    contextMenu.add(0, 3, 0, C25738R.string.br5);
                }
                if (t && C39037b.m66395g(vE)) {
                    contextMenu.add(0, 3, 0, C25738R.string.br5);
                }
                if (vE.field_type == 8) {
                    aar c = C39037b.m66378c(vE);
                    if (C39037b.m66393f(c) && !C39037b.m66396g(c)) {
                        contextMenu.add(0, 4, 0, C25738R.string.bpy);
                    }
                }
                contextMenu.add(0, 2, 0, C25738R.string.bo8);
                contextMenu.add(0, 0, 0, C25738R.string.bnp);
                contextMenu.add(0, 1, 0, C25738R.string.bpn);
                AppMethodBeat.m2505o(74247);
            }
        }, new C5279d() {

            /* renamed from: com.tencent.mm.plugin.fav.ui.FavoriteIndexUI$22$1 */
            class C207091 implements DialogInterface.OnClickListener {
                C207091() {
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.m2504i(74248);
                    FavoriteIndexUI.m71875a(FavoriteIndexUI.this, 4106);
                    AppMethodBeat.m2505o(74248);
                }
            }

            public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                AppMethodBeat.m2504i(74249);
                switch (FavoriteIndexUI.this.mkz) {
                    case 0:
                        if (menuItem == null) {
                            AppMethodBeat.m2505o(74249);
                            return;
                        }
                        switch (menuItem.getItemId()) {
                            case 0:
                                if (i < FavoriteIndexUI.this.mhs.getHeaderViewsCount()) {
                                    AppMethodBeat.m2505o(74249);
                                    return;
                                }
                                C4990ab.m7417i("MicroMsg.FavoriteIndexUI", "do delete, long click info is %s", Integer.valueOf(i));
                                C39037b.m66398i(FavoriteIndexUI.this.mkA.mo61974vE((i - FavoriteIndexUI.this.mhs.getHeaderViewsCount()) - 1));
                                AppMethodBeat.m2505o(74249);
                                return;
                            case 1:
                                FavoriteIndexUI.this.startTime = C5046bo.anT();
                                C4990ab.m7417i("MicroMsg.FavoriteIndexUI", "do edit, long click info is %s", Integer.valueOf(i));
                                FavoriteIndexUI.this.mkC = FavoriteIndexUI.this.mkA.mo61974vE((i - FavoriteIndexUI.this.mhs.getHeaderViewsCount()) - 1);
                                FavoriteIndexUI.m71883b(FavoriteIndexUI.this, FavoriteIndexUI.this.mkC);
                                AppMethodBeat.m2505o(74249);
                                return;
                            case 2:
                                C4990ab.m7417i("MicroMsg.FavoriteIndexUI", "do tag, long click info is %s", Integer.valueOf(i));
                                C27966g vE = FavoriteIndexUI.this.mkA.mo61974vE((i - FavoriteIndexUI.this.mhs.getHeaderViewsCount()) - 1);
                                Intent intent = new Intent();
                                intent.putExtra("key_fav_scene", 4);
                                intent.putExtra("key_fav_item_id", vE.field_localId);
                                C39037b.m66371b(FavoriteIndexUI.this.mController.ylL, ".ui.FavTagEditUI", intent);
                                C11853i.m19718LK("FavTagEditUI");
                                AppMethodBeat.m2505o(74249);
                                return;
                            case 3:
                                FavoriteIndexUI.this.startTime = C5046bo.anT();
                                C4990ab.m7417i("MicroMsg.FavoriteIndexUI", "do transmit, long click info is %s", Integer.valueOf(i));
                                FavoriteIndexUI.this.mkG = FavoriteIndexUI.this.mkA.mo61974vE((i - FavoriteIndexUI.this.mhs.getHeaderViewsCount()) - 1);
                                FavoriteIndexUI.this.mkG = FavoriteIndexUI.this.mkG.buB();
                                if (FavoriteIndexUI.this.mkG == null) {
                                    AppMethodBeat.m2505o(74249);
                                    return;
                                }
                                List linkedList = new LinkedList();
                                linkedList.add(FavoriteIndexUI.this.mkG);
                                if (FavoriteIndexUI.m71881a(linkedList, FavoriteIndexUI.this, new C207091())) {
                                    FavoriteIndexUI.m71875a(FavoriteIndexUI.this, 4106);
                                    AppMethodBeat.m2505o(74249);
                                    return;
                                }
                                AppMethodBeat.m2505o(74249);
                                return;
                            case 4:
                                C27966g vE2 = FavoriteIndexUI.this.mkA.mo61974vE((i - FavoriteIndexUI.this.mhs.getHeaderViewsCount()) - 1);
                                abh abh = new abh();
                                abh.cOi = 1;
                                ((C20679y) C1720g.m3528K(C20679y.class)).mo35978a(FavoriteIndexUI.this.mController.ylL, vE2, abh);
                                break;
                        }
                        AppMethodBeat.m2505o(74249);
                        return;
                    default:
                        AppMethodBeat.m2505o(74249);
                        return;
                }
            }
        }, iArr[0], iArr[1]);
        AppMethodBeat.m2505o(74277);
    }

    /* renamed from: b */
    static /* synthetic */ void m71883b(FavoriteIndexUI favoriteIndexUI, C27966g c27966g) {
        AppMethodBeat.m2504i(74278);
        favoriteIndexUI.mkA.mo61959a(true, c27966g);
        favoriteIndexUI.mhs.setOnItemLongClickListener(null);
        favoriteIndexUI.showOptionMenu(11, false);
        C43088b c43088b = favoriteIndexUI.mkB;
        if (!c43088b.mpz) {
            if (c43088b.mpA == null) {
                AppMethodBeat.m2505o(74278);
                return;
            }
            if (c43088b.mpA instanceof ViewStub) {
                c43088b.mpA = ((ViewStub) c43088b.mpA).inflate();
            }
            c43088b.mpE = (ImageButton) c43088b.mpA.findViewById(2131823889);
            c43088b.mpE.setEnabled(false);
            c43088b.mpE.setContentDescription(c43088b.mpE.getContext().getString(C25738R.string.exz));
            c43088b.mpE.setOnClickListener(new C119181());
            c43088b.mpF = (ImageButton) c43088b.mpA.findViewById(2131823890);
            c43088b.mpF.setEnabled(false);
            c43088b.mpF.setContentDescription(c43088b.mpF.getContext().getString(C25738R.string.b8h));
            c43088b.mpF.setOnClickListener(new C280352());
            c43088b.mpG = (ImageButton) c43088b.mpA.findViewById(2131823891);
            c43088b.mpG.setEnabled(false);
            c43088b.mpG.setContentDescription(c43088b.mpG.getContext().getString(C25738R.string.b54));
            c43088b.mpG.setOnClickListener(new C280363());
            c43088b.mpz = true;
        }
        if (c43088b.mpA.getVisibility() != 0) {
            c43088b.mpA.setVisibility(0);
            c43088b.mpA.startAnimation(AnimationUtils.loadAnimation(c43088b.mpA.getContext(), C25738R.anim.f8332b5));
        }
        AppMethodBeat.m2505o(74278);
    }

    /* renamed from: g */
    static /* synthetic */ void m71889g(FavoriteIndexUI favoriteIndexUI) {
        AppMethodBeat.m2504i(74280);
        long currentTimeMillis = System.currentTimeMillis();
        C18313ld c18313ld = new C18313ld();
        c18313ld.cGU.field_localId = currentTimeMillis;
        c18313ld.cGU.context = favoriteIndexUI.mController.ylL;
        c18313ld.cGU.type = 9;
        C4879a.xxA.mo10055m(c18313ld);
        C26189le c26189le = new C26189le();
        c26189le.cHe.context = favoriteIndexUI.mController.ylL;
        c26189le.cHe.type = 3;
        c26189le.cHe.itemType = 1;
        C4879a.xxA.mo10055m(c26189le);
        AppMethodBeat.m2505o(74280);
    }
}
