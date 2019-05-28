package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ba.n;
import com.tencent.mm.ba.r;
import com.tencent.mm.modelsns.b;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.an;
import com.tencent.mm.plugin.sns.model.aw;
import com.tencent.mm.plugin.sns.model.ax;
import com.tencent.mm.plugin.sns.storage.l;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.plugin.sns.ui.s.a;
import com.tencent.mm.protocal.protobuf.bau;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.vfs.e;
import java.util.List;

public class ArtistBrowseUI extends SnsBaseGalleryUI implements a {
    private String nJy = "";
    private String rgC = "";

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(38097);
        super.onCreate(bundle);
        initView();
        AppMethodBeat.o(38097);
    }

    public void onDestroy() {
        AppMethodBeat.i(38098);
        if (this.rpp != null) {
            this.rpp.ctm();
            this.rpp.onDestroy();
        }
        af.cnC().ab(this);
        super.onDestroy();
        AppMethodBeat.o(38098);
    }

    public void onResume() {
        AppMethodBeat.i(38099);
        super.onResume();
        if (this.rpp != null) {
            this.rpp.btt();
        }
        AppMethodBeat.o(38099);
    }

    public final int getLayoutId() {
        return R.layout.av9;
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        AppMethodBeat.i(38100);
        if (keyEvent.getKeyCode() == 4 && keyEvent.getAction() == 0) {
            ab.d("MicroMsg.ArtistBrowseUI", "dispatchKeyEvent");
            Intent intent = new Intent();
            intent.putExtra("sns_cmd_list", this.rpl.rjk);
            setResult(-1, intent);
            finish();
            AppMethodBeat.o(38100);
            return true;
        }
        boolean dispatchKeyEvent = super.dispatchKeyEvent(keyEvent);
        AppMethodBeat.o(38100);
        return dispatchKeyEvent;
    }

    public final void initView() {
        AppMethodBeat.i(38101);
        this.nJy = getIntent().getStringExtra("sns_gallery_artist_lan");
        int intExtra = getIntent().getIntExtra("sns_gallery_position", 0);
        r.aix();
        this.rgC = n.aiu();
        D(false, 2);
        this.rpp = new SnsInfoFlip(this);
        List fY = aj.fY(this.nJy, this.rgC);
        this.rpp.setShowTitle(true);
        this.rpp.a(fY, "", intExtra, this.rpk, this);
        addView(this.rpp);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(38095);
                ArtistBrowseUI.this.rpl.crL();
                AppMethodBeat.o(38095);
                return true;
            }
        });
        setMMTitle((int) R.string.eq_);
        showOptionMenu(false);
        this.rpk.setCallBack(new r.a() {
            public final void cry() {
                AppMethodBeat.i(38096);
                bau cntMedia = ArtistBrowseUI.this.rpp.getCntMedia();
                if (cntMedia == null) {
                    AppMethodBeat.o(38096);
                    return;
                }
                ab.d("MicroMsg.ArtistBrowseUI", "set bg the meida id " + cntMedia.Id);
                b lY = b.lY(723);
                lY.tx(cntMedia.Url);
                lY.ajK();
                if (e.ct(an.fZ(af.getAccSnsPath(), cntMedia.Id) + i.l(cntMedia))) {
                    aw cnB = af.cnB();
                    if (!(cnB.cnk() == null || cnB.cnk().equals(""))) {
                        String str = an.fZ(af.getAccSnsPath(), cntMedia.Id) + i.l(cntMedia);
                        String fZ = an.fZ(af.getAccSnsPath(), cnB.cnk());
                        if (e.ct(str)) {
                            ab.d("MicroMsg.UploadManager", "bg file is exist!'");
                            e.tf(fZ);
                            e.deleteFile(fZ + cnB.cnk() + "bg_");
                            e.deleteFile(fZ + cnB.cnk() + "tbg_");
                            e.y(str, fZ + cnB.cnk() + "bg_");
                        } else {
                            e.deleteFile(fZ + cnB.cnk() + "bg_");
                            e.deleteFile(fZ + cnB.cnk() + "tbg_");
                            ab.e("MicroMsg.UploadManager", "bg file is not exist! wait to down it");
                        }
                        m cnJ = af.cnJ();
                        fZ = cnB.cnk();
                        String str2 = cntMedia.Id;
                        l YX = cnJ.YX(fZ);
                        YX.field_bgId = str2;
                        cnJ.c(YX);
                    }
                    cnB.con();
                    ax axVar = new ax(7);
                    cntMedia.wEN = 1;
                    axVar.qNK.xfI.wbK.add(cntMedia);
                    axVar.De(2);
                    axVar.commit();
                    Intent intent = new Intent();
                    intent.setClass(ArtistBrowseUI.this, SettingSnsBackgroundUI.class);
                    intent.setFlags(536870912);
                    intent.addFlags(67108864);
                    ArtistBrowseUI.this.startActivity(intent);
                    ArtistBrowseUI.this.finish();
                    AppMethodBeat.o(38096);
                    return;
                }
                AppMethodBeat.o(38096);
            }
        });
        AppMethodBeat.o(38101);
    }

    public void onPause() {
        AppMethodBeat.i(38102);
        if (this.rpp != null) {
            this.rpp.onPause();
        }
        super.onPause();
        AppMethodBeat.o(38102);
    }

    public final void dg(String str, int i) {
        AppMethodBeat.i(38103);
        if (this.rpp != null) {
            this.rpp.btt();
        }
        AppMethodBeat.o(38103);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(38104);
        ab.i("MicroMsg.ArtistBrowseUI", "onAcvityResult requestCode:".concat(String.valueOf(i)));
        if (i2 != -1) {
            AppMethodBeat.o(38104);
            return;
        }
        this.rpl.DN(intent.getIntExtra("sns_gallery_op_id", 0));
        AppMethodBeat.o(38104);
    }

    public final void dh(String str, int i) {
    }
}
