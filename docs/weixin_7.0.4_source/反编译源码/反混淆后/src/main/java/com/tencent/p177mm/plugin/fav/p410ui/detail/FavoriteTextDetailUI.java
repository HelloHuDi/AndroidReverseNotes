package com.tencent.p177mm.plugin.fav.p410ui.detail;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p249m.C42164b;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C40671n.C36073c;
import com.tencent.p177mm.p612ui.base.C40671n.C5279d;
import com.tencent.p177mm.p612ui.base.C44273l;
import com.tencent.p177mm.p612ui.base.C44275p;
import com.tencent.p177mm.p612ui.tools.C46696j;
import com.tencent.p177mm.p612ui.widget.MMLoadScrollView;
import com.tencent.p177mm.p612ui.widget.p633a.C36356d;
import com.tencent.p177mm.plugin.fav.p407a.C27966g;
import com.tencent.p177mm.plugin.fav.p407a.C27968h;
import com.tencent.p177mm.plugin.fav.p407a.C27968h.C27969a;
import com.tencent.p177mm.plugin.fav.p407a.C39037b;
import com.tencent.p177mm.plugin.fav.p407a.C7604ae;
import com.tencent.p177mm.plugin.fav.p410ui.C3105g;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.pluginsdk.wallet.C14991i;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C7306ak;

/* renamed from: com.tencent.mm.plugin.fav.ui.detail.FavoriteTextDetailUI */
public class FavoriteTextDetailUI extends BaseFavDetailReportUI {
    private static final int mmM = C42164b.m74337MY();
    private C46696j contextMenuHelper;
    private long mmC;
    private TextView mmN;
    private ClipboardManager mmO;
    private C27966g mmP;
    private C5279d mmQ = new C280193();
    private C27966g mmj;

    /* renamed from: com.tencent.mm.plugin.fav.ui.detail.FavoriteTextDetailUI$4 */
    class C119034 implements Runnable {
        C119034() {
        }

        public final void run() {
            AppMethodBeat.m2504i(74444);
            FavoriteTextDetailUI.m44575d(FavoriteTextDetailUI.this);
            AppMethodBeat.m2505o(74444);
        }
    }

    /* renamed from: com.tencent.mm.plugin.fav.ui.detail.FavoriteTextDetailUI$1 */
    class C280141 implements OnMenuItemClickListener {
        C280141() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(74437);
            FavoriteTextDetailUI.this.finish();
            AppMethodBeat.m2505o(74437);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.fav.ui.detail.FavoriteTextDetailUI$2 */
    class C280152 implements OnMenuItemClickListener {

        /* renamed from: com.tencent.mm.plugin.fav.ui.detail.FavoriteTextDetailUI$2$1 */
        class C119021 implements C36073c {
            C119021() {
            }

            /* renamed from: a */
            public final void mo5746a(C44273l c44273l) {
                AppMethodBeat.m2504i(74438);
                if (FavoriteTextDetailUI.this.getIntent().getBooleanExtra("key_detail_can_share_to_friend", true)) {
                    c44273l.mo70068e(2, FavoriteTextDetailUI.this.getString(C25738R.string.bri));
                }
                c44273l.mo70068e(0, FavoriteTextDetailUI.this.getString(C25738R.string.bo6));
                c44273l.mo70068e(1, FavoriteTextDetailUI.this.getString(C25738R.string.br7));
                c44273l.mo70068e(3, FavoriteTextDetailUI.this.getString(C25738R.string.bo8));
                c44273l.mo70068e(4, FavoriteTextDetailUI.this.getString(C25738R.string.f9088p4));
                AppMethodBeat.m2505o(74438);
            }
        }

        /* renamed from: com.tencent.mm.plugin.fav.ui.detail.FavoriteTextDetailUI$2$2 */
        class C280162 implements C5279d {

            /* renamed from: com.tencent.mm.plugin.fav.ui.detail.FavoriteTextDetailUI$2$2$1 */
            class C280171 implements OnClickListener {
                C280171() {
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.m2504i(74440);
                    final C44275p b = C30379h.m48458b(FavoriteTextDetailUI.this.mController.ylL, FavoriteTextDetailUI.this.getString(C25738R.string.f9089p5), false, null);
                    C39037b.m66365a(FavoriteTextDetailUI.this.mmC, new Runnable() {
                        public final void run() {
                            AppMethodBeat.m2504i(74439);
                            FavoriteTextDetailUI.this.mlz.mfd = true;
                            b.dismiss();
                            C4990ab.m7411d("MicroMsg.FavoriteTextDetailUI", "do del, local id %d", Long.valueOf(FavoriteTextDetailUI.this.mmC));
                            FavoriteTextDetailUI.this.finish();
                            AppMethodBeat.m2505o(74439);
                        }
                    });
                    AppMethodBeat.m2505o(74440);
                }
            }

            C280162() {
            }

            public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                AppMethodBeat.m2504i(74441);
                Intent intent;
                C27969a c27969a;
                switch (menuItem.getItemId()) {
                    case 0:
                        if (!(FavoriteTextDetailUI.this.mmj == null || FavoriteTextDetailUI.this.mmj.field_favProto == null)) {
                            intent = new Intent();
                            intent.putExtra("key_value", FavoriteTextDetailUI.this.mmj.field_favProto.desc);
                            intent.putExtra("key_max_count", FavoriteTextDetailUI.mmM);
                            intent.putExtra("key_show_confirm", true);
                            intent.putExtra("key_fav_item_id", FavoriteTextDetailUI.this.mmj.field_id);
                            C39037b.m66352a(FavoriteTextDetailUI.this, ".ui.FavTextEditUI", intent, 1);
                            c27969a = FavoriteTextDetailUI.this.mlz;
                            c27969a.mfb++;
                            AppMethodBeat.m2505o(74441);
                            return;
                        }
                    case 1:
                        C3105g.m5347a(FavoriteTextDetailUI.this, FavoriteTextDetailUI.this.mmC, FavoriteTextDetailUI.this.mlz);
                        AppMethodBeat.m2505o(74441);
                        return;
                    case 2:
                        if (!(FavoriteTextDetailUI.this.mmj == null || FavoriteTextDetailUI.this.mmj.field_favProto == null)) {
                            c27969a = FavoriteTextDetailUI.this.mlz;
                            c27969a.meZ++;
                            C39037b.m66388e(FavoriteTextDetailUI.this.mmj.field_favProto.desc, FavoriteTextDetailUI.this);
                            C27968h.m44531j(FavoriteTextDetailUI.this.mmj.field_localId, 1, 0);
                            AppMethodBeat.m2505o(74441);
                            return;
                        }
                    case 3:
                        intent = new Intent();
                        intent.putExtra("key_fav_scene", 2);
                        intent.putExtra("key_fav_item_id", FavoriteTextDetailUI.this.mmj.field_localId);
                        C39037b.m66371b(FavoriteTextDetailUI.this.mController.ylL, ".ui.FavTagEditUI", intent);
                        c27969a = FavoriteTextDetailUI.this.mlz;
                        c27969a.mfc++;
                        AppMethodBeat.m2505o(74441);
                        return;
                    case 4:
                        C30379h.m48440a(FavoriteTextDetailUI.this.mController.ylL, FavoriteTextDetailUI.this.getString(C25738R.string.f9089p5), "", new C280171(), null);
                        break;
                }
                AppMethodBeat.m2505o(74441);
            }
        }

        C280152() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(74442);
            C36356d c36356d = new C36356d(FavoriteTextDetailUI.this.mController.ylL, 1, false);
            c36356d.rBl = new C119021();
            c36356d.rBm = new C280162();
            c36356d.cpD();
            AppMethodBeat.m2505o(74442);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.fav.ui.detail.FavoriteTextDetailUI$3 */
    class C280193 implements C5279d {
        C280193() {
        }

        public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
            AppMethodBeat.m2504i(74443);
            switch (menuItem.getItemId()) {
                case 1:
                    if (!(FavoriteTextDetailUI.this.mmO == null || FavoriteTextDetailUI.this.mmj == null || FavoriteTextDetailUI.this.mmj.field_favProto == null)) {
                        FavoriteTextDetailUI.this.mmO.setText(FavoriteTextDetailUI.this.mmj.field_favProto.desc);
                        C30379h.m48465bQ(FavoriteTextDetailUI.this.mController.ylL, FavoriteTextDetailUI.this.mController.ylL.getString(C25738R.string.f9083oz));
                        break;
                    }
            }
            AppMethodBeat.m2505o(74443);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public FavoriteTextDetailUI() {
        AppMethodBeat.m2504i(74445);
        AppMethodBeat.m2505o(74445);
    }

    /* renamed from: d */
    static /* synthetic */ void m44575d(FavoriteTextDetailUI favoriteTextDetailUI) {
        AppMethodBeat.m2504i(74454);
        favoriteTextDetailUI.bwp();
        AppMethodBeat.m2505o(74454);
    }

    static {
        AppMethodBeat.m2504i(74455);
        AppMethodBeat.m2505o(74455);
    }

    public final int getLayoutId() {
        return 2130969542;
    }

    /* Access modifiers changed, original: protected|final */
    public final MMLoadScrollView bwd() {
        AppMethodBeat.m2504i(74446);
        MMLoadScrollView mMLoadScrollView = (MMLoadScrollView) findViewById(2131823999);
        AppMethodBeat.m2505o(74446);
        return mMLoadScrollView;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(74447);
        super.onCreate(bundle);
        this.mmN = (TextView) findViewById(2131824004);
        this.mmO = (ClipboardManager) C4996ah.getContext().getSystemService("clipboard");
        this.mmC = getIntent().getLongExtra("key_detail_info_id", -1);
        C14991i.m23324Lt(5);
        this.contextMenuHelper = new C46696j(this.mController.ylL);
        this.contextMenuHelper.mo75005a(this.mmN, this, this.mmQ);
        setMMTitle(getString(C25738R.string.bns));
        setBackBtn(new C280141());
        addIconOptionMenu(0, C25738R.string.ewm, C25738R.drawable.f6899uu, new C280152());
        AppMethodBeat.m2505o(74447);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(74448);
        super.onDestroy();
        AppMethodBeat.m2505o(74448);
    }

    public void onResume() {
        AppMethodBeat.m2504i(74449);
        super.onResume();
        bwp();
        AppMethodBeat.m2505o(74449);
    }

    public void onPause() {
        AppMethodBeat.m2504i(74450);
        super.onPause();
        AppMethodBeat.m2505o(74450);
    }

    private void bwp() {
        AppMethodBeat.m2504i(74451);
        this.mmj = ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavItemInfoStorage().mo23693iE(this.mmC);
        mo54744F(this.mmj);
        if (this.mmj == null || this.mmj.field_favProto == null) {
            C4990ab.m7421w("MicroMsg.FavoriteTextDetailUI", "id[%d] info is null, return", Long.valueOf(this.mmC));
            AppMethodBeat.m2505o(74451);
            return;
        }
        C20728a.m31955a(this, this.mmj);
        if (this.mmP == null || this.mmP.field_edittime != this.mmj.field_edittime) {
            this.mmP = this.mmj;
            this.mmN.setText(this.mmj.field_favProto.desc);
            C44089j.m79307h(this.mmN, 1);
            AppMethodBeat.m2505o(74451);
            return;
        }
        C4990ab.m7420w("MicroMsg.FavoriteTextDetailUI", "not change, return");
        AppMethodBeat.m2505o(74451);
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        AppMethodBeat.m2504i(74452);
        contextMenu.add(0, 1, 0, getString(C25738R.string.f9082oy));
        AppMethodBeat.m2505o(74452);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(74453);
        if (1 == i && -1 == i2) {
            C30379h.m48465bQ(this.mController.ylL, getString(C25738R.string.f9219td));
            new C7306ak().postDelayed(new C119034(), 250);
            AppMethodBeat.m2505o(74453);
            return;
        }
        super.onActivityResult(i, i2, intent);
        AppMethodBeat.m2505o(74453);
    }
}
