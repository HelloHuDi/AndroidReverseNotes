package com.tencent.p177mm.plugin.fav.p410ui.detail;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C40671n.C36073c;
import com.tencent.p177mm.p612ui.base.C40671n.C5279d;
import com.tencent.p177mm.p612ui.base.C44273l;
import com.tencent.p177mm.p612ui.base.C44275p;
import com.tencent.p177mm.p612ui.widget.p633a.C36356d;
import com.tencent.p177mm.plugin.fav.p407a.C27966g;
import com.tencent.p177mm.plugin.fav.p407a.C27968h.C27969a;
import com.tencent.p177mm.plugin.fav.p407a.C36764n;
import com.tencent.p177mm.plugin.fav.p407a.C39037b;
import com.tencent.p177mm.plugin.fav.p407a.C7604ae;
import com.tencent.p177mm.plugin.fav.p410ui.C3105g;
import com.tencent.p177mm.plugin.fav.p410ui.C34171j;
import com.tencent.p177mm.plugin.fav.p410ui.FavChatVoiceView;
import com.tencent.p177mm.protocal.protobuf.aar;
import com.tencent.p177mm.sdk.p603e.C4935m;
import com.tencent.p177mm.sdk.p603e.C7296k.C4931a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.vfs.C5730e;

/* renamed from: com.tencent.mm.plugin.fav.ui.detail.FavoriteVoiceDetailUI */
public class FavoriteVoiceDetailUI extends BaseFavDetailReportUI implements C4931a {
    private C36764n mgA;
    private C27966g mgf;
    private long mmC;
    private FavChatVoiceView mni;

    /* renamed from: com.tencent.mm.plugin.fav.ui.detail.FavoriteVoiceDetailUI$1 */
    class C207251 implements OnMenuItemClickListener {
        C207251() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(74478);
            FavoriteVoiceDetailUI.this.finish();
            AppMethodBeat.m2505o(74478);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.fav.ui.detail.FavoriteVoiceDetailUI$2 */
    class C430782 implements OnMenuItemClickListener {

        /* renamed from: com.tencent.mm.plugin.fav.ui.detail.FavoriteVoiceDetailUI$2$1 */
        class C119051 implements C36073c {
            C119051() {
            }

            /* renamed from: a */
            public final void mo5746a(C44273l c44273l) {
                AppMethodBeat.m2504i(74479);
                c44273l.mo70068e(0, FavoriteVoiceDetailUI.this.getString(C25738R.string.bo8));
                c44273l.mo70072hi(2, C25738R.string.br7);
                c44273l.mo70068e(1, FavoriteVoiceDetailUI.this.mController.ylL.getString(C25738R.string.f9088p4));
                AppMethodBeat.m2505o(74479);
            }
        }

        /* renamed from: com.tencent.mm.plugin.fav.ui.detail.FavoriteVoiceDetailUI$2$2 */
        class C280212 implements C5279d {

            /* renamed from: com.tencent.mm.plugin.fav.ui.detail.FavoriteVoiceDetailUI$2$2$1 */
            class C207261 implements OnClickListener {
                C207261() {
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.m2504i(74481);
                    final C44275p b = C30379h.m48458b(FavoriteVoiceDetailUI.this.mController.ylL, FavoriteVoiceDetailUI.this.getString(C25738R.string.f9089p5), false, null);
                    final long j = FavoriteVoiceDetailUI.this.mgf.field_localId;
                    final long j2 = (long) FavoriteVoiceDetailUI.this.mgf.field_id;
                    C39037b.m66365a(FavoriteVoiceDetailUI.this.mgf.field_localId, new Runnable() {
                        public final void run() {
                            AppMethodBeat.m2504i(74480);
                            FavoriteVoiceDetailUI.this.mlz.mfd = true;
                            b.dismiss();
                            C4990ab.m7411d("MicroMsg.FavoriteDetailUI", "do del fav voice, local id %d, fav id %d", Long.valueOf(j), Long.valueOf(j2));
                            FavoriteVoiceDetailUI.this.finish();
                            AppMethodBeat.m2505o(74480);
                        }
                    });
                    AppMethodBeat.m2505o(74481);
                }
            }

            C280212() {
            }

            public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                AppMethodBeat.m2504i(74482);
                switch (menuItem.getItemId()) {
                    case 0:
                        Intent intent = new Intent();
                        intent.putExtra("key_fav_scene", 2);
                        intent.putExtra("key_fav_item_id", FavoriteVoiceDetailUI.this.mgf.field_localId);
                        C39037b.m66371b(FavoriteVoiceDetailUI.this.mController.ylL, ".ui.FavTagEditUI", intent);
                        C27969a c27969a = FavoriteVoiceDetailUI.this.mlz;
                        c27969a.mfc++;
                        AppMethodBeat.m2505o(74482);
                        return;
                    case 1:
                        C30379h.m48440a(FavoriteVoiceDetailUI.this.mController.ylL, FavoriteVoiceDetailUI.this.getString(C25738R.string.f9089p5), "", new C207261(), null);
                        AppMethodBeat.m2505o(74482);
                        return;
                    case 2:
                        C3105g.m5347a(FavoriteVoiceDetailUI.this, FavoriteVoiceDetailUI.this.mmC, FavoriteVoiceDetailUI.this.mlz);
                        break;
                }
                AppMethodBeat.m2505o(74482);
            }
        }

        C430782() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(74483);
            C36356d c36356d = new C36356d(FavoriteVoiceDetailUI.this.mController.ylL, 1, false);
            c36356d.rBl = new C119051();
            c36356d.rBm = new C280212();
            c36356d.cpD();
            AppMethodBeat.m2505o(74483);
            return true;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public final int getLayoutId() {
        return 2130969543;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(74484);
        super.onCreate(bundle);
        setMMTitle(getString(C25738R.string.bns));
        this.mmC = getIntent().getLongExtra("key_detail_info_id", -1);
        this.mgf = ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavItemInfoStorage().mo23693iE(this.mmC);
        if (this.mgf == null) {
            C4990ab.m7420w("MicroMsg.FavoriteDetailUI", "get fav item info error");
            finish();
        } else {
            mo54744F(this.mgf);
            this.mgA = new C36764n();
            this.mni = (FavChatVoiceView) findViewById(2131824005);
            this.mni.setVoiceHelper(this.mgA);
            C20728a.m31955a(this, this.mgf);
            aar c = C39037b.m66378c(this.mgf);
            String b = C39037b.m66370b(c);
            int LE = C39037b.m66340LE(c.wgo);
            if (!C5730e.m8628ct(b)) {
                C39037b.m66411m(this.mgf);
            }
            this.mni.mo54711t(b, LE, C34171j.m56018B(this, (int) C39037b.m66406iu((long) c.duration)).toString());
            setBackBtn(new C207251());
            addIconOptionMenu(0, C25738R.string.ewm, C25738R.drawable.f6899uu, new C430782());
        }
        ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavItemInfoStorage().mo10116c(this);
        AppMethodBeat.m2505o(74484);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(74485);
        super.onDestroy();
        if (this.mni != null) {
            this.mni.stopPlay();
        }
        if (this.mgA != null) {
            this.mgA.destroy();
        }
        ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavItemInfoStorage().mo10117d(this);
        AppMethodBeat.m2505o(74485);
    }

    public void onResume() {
        AppMethodBeat.m2504i(74486);
        super.onResume();
        AppMethodBeat.m2505o(74486);
    }

    public void onPause() {
        AppMethodBeat.m2504i(74487);
        super.onPause();
        this.mgA.pause();
        AppMethodBeat.m2505o(74487);
    }

    /* renamed from: a */
    public final void mo5248a(String str, C4935m c4935m) {
        AppMethodBeat.m2504i(74488);
        this.mgf = ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavItemInfoStorage().mo23693iE(this.mmC);
        if (this.mgf == null) {
            C4990ab.m7420w("MicroMsg.FavoriteDetailUI", "on notify changed, get fav item info error");
            finish();
            AppMethodBeat.m2505o(74488);
        } else if (this.mgf.field_itemStatus != 10) {
            AppMethodBeat.m2505o(74488);
        } else if (c4935m == null || c4935m.xDr == null) {
            AppMethodBeat.m2505o(74488);
        } else {
            if (this.mgf.field_favProto.wiv.size() > 0) {
                aar c = C39037b.m66378c(this.mgf);
                String b = C39037b.m66370b(c);
                int LE = C39037b.m66340LE(c.wgo);
                C4990ab.m7416i("MicroMsg.FavoriteDetailUI", "on notify changed, favVoiceView.updateInfo");
                this.mni.mo54711t(b, LE, C34171j.m56018B(this, (int) C39037b.m66406iu((long) c.duration)).toString());
            }
            AppMethodBeat.m2505o(74488);
        }
    }
}
