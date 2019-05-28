package com.tencent.p177mm.plugin.sns.p520ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.modelsns.C37952b;
import com.tencent.p177mm.p707ba.C41787r;
import com.tencent.p177mm.p707ba.C9067n;
import com.tencent.p177mm.plugin.sns.data.C29036i;
import com.tencent.p177mm.plugin.sns.model.C13373af;
import com.tencent.p177mm.plugin.sns.model.C29050aw;
import com.tencent.p177mm.plugin.sns.model.C29054ax;
import com.tencent.p177mm.plugin.sns.model.C34955aj;
import com.tencent.p177mm.plugin.sns.model.C3892an;
import com.tencent.p177mm.plugin.sns.p520ui.C22140r.C4097a;
import com.tencent.p177mm.plugin.sns.p520ui.C29238s.C29239a;
import com.tencent.p177mm.plugin.sns.storage.C29097l;
import com.tencent.p177mm.plugin.sns.storage.C43573m;
import com.tencent.p177mm.protocal.protobuf.bau;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.vfs.C5730e;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.sns.ui.ArtistBrowseUI */
public class ArtistBrowseUI extends SnsBaseGalleryUI implements C29239a {
    private String nJy = "";
    private String rgC = "";

    /* renamed from: com.tencent.mm.plugin.sns.ui.ArtistBrowseUI$2 */
    class C39582 implements C4097a {
        C39582() {
        }

        public final void cry() {
            AppMethodBeat.m2504i(38096);
            bau cntMedia = ArtistBrowseUI.this.rpp.getCntMedia();
            if (cntMedia == null) {
                AppMethodBeat.m2505o(38096);
                return;
            }
            C4990ab.m7410d("MicroMsg.ArtistBrowseUI", "set bg the meida id " + cntMedia.f17915Id);
            C37952b lY = C37952b.m64170lY(723);
            lY.mo60722tx(cntMedia.Url);
            lY.ajK();
            if (C5730e.m8628ct(C3892an.m6198fZ(C13373af.getAccSnsPath(), cntMedia.f17915Id) + C29036i.m46121l(cntMedia))) {
                C29050aw cnB = C13373af.cnB();
                if (!(cnB.cnk() == null || cnB.cnk().equals(""))) {
                    String str = C3892an.m6198fZ(C13373af.getAccSnsPath(), cntMedia.f17915Id) + C29036i.m46121l(cntMedia);
                    String fZ = C3892an.m6198fZ(C13373af.getAccSnsPath(), cnB.cnk());
                    if (C5730e.m8628ct(str)) {
                        C4990ab.m7410d("MicroMsg.UploadManager", "bg file is exist!'");
                        C5730e.m8643tf(fZ);
                        C5730e.deleteFile(fZ + cnB.cnk() + "bg_");
                        C5730e.deleteFile(fZ + cnB.cnk() + "tbg_");
                        C5730e.m8644y(str, fZ + cnB.cnk() + "bg_");
                    } else {
                        C5730e.deleteFile(fZ + cnB.cnk() + "bg_");
                        C5730e.deleteFile(fZ + cnB.cnk() + "tbg_");
                        C4990ab.m7412e("MicroMsg.UploadManager", "bg file is not exist! wait to down it");
                    }
                    C43573m cnJ = C13373af.cnJ();
                    fZ = cnB.cnk();
                    String str2 = cntMedia.f17915Id;
                    C29097l YX = cnJ.mo69179YX(fZ);
                    YX.field_bgId = str2;
                    cnJ.mo69182c(YX);
                }
                cnB.con();
                C29054ax c29054ax = new C29054ax(7);
                cntMedia.wEN = 1;
                c29054ax.qNK.xfI.wbK.add(cntMedia);
                c29054ax.mo47139De(2);
                c29054ax.commit();
                Intent intent = new Intent();
                intent.setClass(ArtistBrowseUI.this, SettingSnsBackgroundUI.class);
                intent.setFlags(536870912);
                intent.addFlags(67108864);
                ArtistBrowseUI.this.startActivity(intent);
                ArtistBrowseUI.this.finish();
                AppMethodBeat.m2505o(38096);
                return;
            }
            AppMethodBeat.m2505o(38096);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.ArtistBrowseUI$1 */
    class C39591 implements OnMenuItemClickListener {
        C39591() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(38095);
            ArtistBrowseUI.this.rpl.crL();
            AppMethodBeat.m2505o(38095);
            return true;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(38097);
        super.onCreate(bundle);
        initView();
        AppMethodBeat.m2505o(38097);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(38098);
        if (this.rpp != null) {
            this.rpp.ctm();
            this.rpp.onDestroy();
        }
        C13373af.cnC().mo37452ab(this);
        super.onDestroy();
        AppMethodBeat.m2505o(38098);
    }

    public void onResume() {
        AppMethodBeat.m2504i(38099);
        super.onResume();
        if (this.rpp != null) {
            this.rpp.btt();
        }
        AppMethodBeat.m2505o(38099);
    }

    public final int getLayoutId() {
        return 2130970761;
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        AppMethodBeat.m2504i(38100);
        if (keyEvent.getKeyCode() == 4 && keyEvent.getAction() == 0) {
            C4990ab.m7410d("MicroMsg.ArtistBrowseUI", "dispatchKeyEvent");
            Intent intent = new Intent();
            intent.putExtra("sns_cmd_list", this.rpl.rjk);
            setResult(-1, intent);
            finish();
            AppMethodBeat.m2505o(38100);
            return true;
        }
        boolean dispatchKeyEvent = super.dispatchKeyEvent(keyEvent);
        AppMethodBeat.m2505o(38100);
        return dispatchKeyEvent;
    }

    public final void initView() {
        AppMethodBeat.m2504i(38101);
        this.nJy = getIntent().getStringExtra("sns_gallery_artist_lan");
        int intExtra = getIntent().getIntExtra("sns_gallery_position", 0);
        C41787r.aix();
        this.rgC = C9067n.aiu();
        mo69187D(false, 2);
        this.rpp = new SnsInfoFlip(this);
        List fY = C34955aj.m57407fY(this.nJy, this.rgC);
        this.rpp.setShowTitle(true);
        this.rpp.mo8770a(fY, "", intExtra, this.rpk, this);
        addView(this.rpp);
        setBackBtn(new C39591());
        setMMTitle((int) C25738R.string.eq_);
        showOptionMenu(false);
        this.rpk.setCallBack(new C39582());
        AppMethodBeat.m2505o(38101);
    }

    public void onPause() {
        AppMethodBeat.m2504i(38102);
        if (this.rpp != null) {
            this.rpp.onPause();
        }
        super.onPause();
        AppMethodBeat.m2505o(38102);
    }

    /* renamed from: dg */
    public final void mo8727dg(String str, int i) {
        AppMethodBeat.m2504i(38103);
        if (this.rpp != null) {
            this.rpp.btt();
        }
        AppMethodBeat.m2505o(38103);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(38104);
        C4990ab.m7416i("MicroMsg.ArtistBrowseUI", "onAcvityResult requestCode:".concat(String.valueOf(i)));
        if (i2 != -1) {
            AppMethodBeat.m2505o(38104);
            return;
        }
        this.rpl.mo47401DN(intent.getIntExtra("sns_gallery_op_id", 0));
        AppMethodBeat.m2505o(38104);
    }

    /* renamed from: dh */
    public final void mo8728dh(String str, int i) {
    }
}
