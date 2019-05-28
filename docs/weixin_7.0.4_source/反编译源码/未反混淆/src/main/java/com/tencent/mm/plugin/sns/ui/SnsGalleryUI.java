package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.kernel.i;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.sns.h.b;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.am;
import com.tencent.mm.plugin.sns.model.an;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.v;
import com.tencent.mm.plugin.sns.ui.s.a;
import com.tencent.mm.plugin.webview.ui.tools.widget.o;
import com.tencent.mm.protocal.protobuf.bau;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.az;
import com.tencent.mm.vfs.e;
import java.util.ArrayList;
import java.util.List;

@i
public class SnsGalleryUI extends SnsBaseGalleryUI implements a {
    private int rpr = 0;
    private String userName = "";

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(38938);
        super.onCreate(bundle);
        getWindow().addFlags(128);
        xE(this.mController.ylL.getResources().getColor(R.color.l8));
        Nb(this.mController.ylL.getResources().getColor(R.color.l8));
        initView();
        AppMethodBeat.o(38938);
    }

    public void onDestroy() {
        int max;
        AppMethodBeat.i(38939);
        if (this.rpp != null) {
            this.rpp.ctm();
            this.rpp.onDestroy();
        }
        getWindow().clearFlags(128);
        am.a cnv = af.cnv();
        String str = this.userName;
        if (cnv.qME.containsKey(str)) {
            max = Math.max(((Integer) cnv.qME.get(str)).intValue() - 1, 0);
            cnv.qME.put(str, Integer.valueOf(max));
        } else {
            max = 0;
        }
        if (max <= 0) {
            cnv.qMD.remove(str);
        }
        af.cnC().ab(this);
        super.onDestroy();
        AppMethodBeat.o(38939);
    }

    public void onPause() {
        AppMethodBeat.i(38940);
        super.onPause();
        o.JV(2);
        AppMethodBeat.o(38940);
    }

    public void onResume() {
        AppMethodBeat.i(38941);
        super.onResume();
        if (this.rpp != null) {
            this.rpp.btt();
        }
        o.JV(1);
        AppMethodBeat.o(38941);
    }

    public final int getLayoutId() {
        return R.layout.av9;
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        AppMethodBeat.i(38942);
        if (keyEvent.getKeyCode() == 4 && keyEvent.getAction() == 0) {
            ab.d("MicroMsg.SnsGalleryUI", "dispatchKeyEvent");
            Intent intent = new Intent();
            intent.putExtra("sns_cmd_list", this.rpl.rjk);
            setResult(-1, intent);
            finish();
            AppMethodBeat.o(38942);
            return true;
        }
        boolean dispatchKeyEvent = super.dispatchKeyEvent(keyEvent);
        AppMethodBeat.o(38942);
        return dispatchKeyEvent;
    }

    public final void initView() {
        az dti;
        AppMethodBeat.i(38943);
        this.userName = getIntent().getStringExtra("sns_gallery_userName");
        int intExtra = getIntent().getIntExtra("sns_gallery_localId", 0);
        final boolean booleanExtra = getIntent().getBooleanExtra("sns_gallery_is_self", false);
        this.rpr = getIntent().getIntExtra("sns_gallery_position", 0);
        ab.i("MicroMsg.SnsGalleryUI", "initView localId:%s, pos:%d", v.ap("sns_table_", (long) intExtra), Integer.valueOf(this.rpr));
        dh(r0, this.rpr);
        D(booleanExtra, 1);
        this.rpp = new SnsInfoFlip(this);
        this.rpp.setNeedScanImage(true);
        List Yb = af.cnv().Yb(this.userName);
        if (Yb == null) {
            Yb = new ArrayList();
        }
        this.rpp.setDoubleClick(true);
        this.rpp.setShowTitle(true);
        this.rpp.setEnableHorLongBmpMode(false);
        this.rpp.a(Yb, this.userName, this.rpr, this.rpk, this);
        this.rpp.setOnDeleteAllAction(new Runnable() {
            public final void run() {
                AppMethodBeat.i(38935);
                SnsGalleryUI.this.rpl.crL();
                AppMethodBeat.o(38935);
            }
        });
        g.RQ();
        ad aoO = ((j) g.K(j.class)).XM().aoO(this.userName);
        if (aoO == null || ((int) aoO.ewQ) <= 0 || !com.tencent.mm.n.a.jh(aoO.field_type)) {
            if (this.userName.equals(r.Yz())) {
                dti = az.dti();
            } else {
                dti = az.dtj();
            }
        } else {
            dti = az.dth();
        }
        this.rpp.setFromScene(dti);
        this.rpp.username = this.userName;
        addView(this.rpp);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(38936);
                SnsGalleryUI.this.rpl.crL();
                AppMethodBeat.o(38936);
                return true;
            }
        });
        addIconOptionMenu(0, R.drawable.uu, new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(38937);
                String selectId = SnsGalleryUI.this.rpp.getSelectId();
                String selectedMediaId = SnsGalleryUI.this.rpp.getSelectedMediaId();
                b selectItem = SnsGalleryUI.this.rpp.getSelectItem();
                ab.d("MicroMsg.SnsGalleryUI", "click selectLocalId ".concat(String.valueOf(selectId)));
                ab.d("MicroMsg.SnsGalleryUI", "click position ".concat(String.valueOf(selectedMediaId)));
                n YT = af.cnF().YT(selectId);
                try {
                    int i;
                    int position = SnsGalleryUI.this.rpp.getPosition();
                    int size = YT.cqu().xfI.wbK.size();
                    if (size <= 1 || position <= 1 || position > size) {
                        i = 0;
                    } else {
                        i = position - 1;
                    }
                    SnsGalleryUI.this.rpl.a(booleanExtra, YT, selectItem.cNr, true, i);
                } catch (Exception e) {
                    ab.printErrStackTrace("MicroMsg.SnsGalleryUI", e, "", new Object[0]);
                }
                AppMethodBeat.o(38937);
                return true;
            }
        });
        AppMethodBeat.o(38943);
    }

    public final void dg(String str, int i) {
        AppMethodBeat.i(38944);
        if (this.rpp != null) {
            if (!(bo.isNullOrNil(str) || i == 3)) {
                SnsInfoFlip snsInfoFlip = this.rpp;
                if (snsInfoFlip.items != null) {
                    int i2 = 0;
                    while (i2 >= 0) {
                        int i3;
                        while (true) {
                            i3 = i2;
                            if (i3 >= snsInfoFlip.items.size()) {
                                i3 = -1;
                                break;
                            }
                            b bVar = (b) snsInfoFlip.items.get(i3);
                            if (!bo.isNullOrNil(bVar.qQd) && bVar.qQd.equals(str)) {
                                snsInfoFlip.items.remove(i3);
                                break;
                            }
                            i2 = i3 + 1;
                        }
                        i2 = i3;
                    }
                    snsInfoFlip.rsm.notifyDataSetChanged();
                }
            }
            this.rpp.btt();
        }
        AppMethodBeat.o(38944);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(38945);
        ab.i("MicroMsg.SnsGalleryUI", "onAcvityResult requestCode:".concat(String.valueOf(i)));
        if (i2 != -1) {
            AppMethodBeat.o(38945);
            return;
        }
        String str;
        if (2 == i) {
            if (-1 == i2) {
                bau bau;
                String stringExtra = intent.getStringExtra("Select_Conv_User");
                String stringExtra2 = intent.getStringExtra("custom_send_text");
                if (this.rpp != null) {
                    b selectItem = this.rpp.getSelectItem();
                    if (selectItem.cNr.jCt != 6) {
                        AppMethodBeat.o(38945);
                        return;
                    }
                    bau = selectItem.cNr;
                } else {
                    bau = null;
                }
                if (bau == null) {
                    AppMethodBeat.o(38945);
                    return;
                }
                String fZ = an.fZ(af.getAccSnsPath(), bau.Id);
                str = "";
                String str2 = "";
                String j = com.tencent.mm.plugin.sns.data.i.j(bau);
                if (e.ct(fZ + j)) {
                    str2 = fZ + j;
                    str = fZ + com.tencent.mm.plugin.sns.data.i.e(bau);
                }
                if (e.ct(fZ + com.tencent.mm.plugin.sns.data.i.p(bau))) {
                    j = fZ + com.tencent.mm.plugin.sns.data.i.p(bau);
                    fZ = fZ + com.tencent.mm.plugin.sns.data.i.n(bau);
                } else {
                    j = str2;
                    fZ = str;
                }
                ArrayList<String> P = bo.P(stringExtra.split(","));
                int Xr = com.tencent.mm.plugin.sns.data.i.Xr(j);
                for (String str3 : P) {
                    ab.i("MicroMsg.SnsGalleryUI", "send sight to %s, videopath %s, thumbpath %s duration %d", str3, j, fZ, Integer.valueOf(Xr));
                    com.tencent.mm.plugin.messenger.a.g.bOk().a(this, str3, j, fZ, 62, Xr, "");
                    com.tencent.mm.plugin.messenger.a.g.bOk().eZ(stringExtra2, str3);
                }
                com.tencent.mm.ui.widget.snackbar.b.i(this, getString(R.string.cbn));
                AppMethodBeat.o(38945);
                return;
            }
        } else if (1 == i) {
            int intExtra = intent.getIntExtra("sns_gallery_op_id", 0);
            str = v.ap("sns_table_", (long) intent.getIntExtra("sns_gallery_op_id", 0));
            this.rpl.DN(intExtra);
            dg(str, 1);
            if (intent.getBooleanExtra("sns_gallery_force_finish", false)) {
                Intent intent2 = new Intent();
                intent2.putExtra("sns_cmd_list", this.rpl.rjk);
                setResult(-1, intent2);
                finish();
            }
        }
        AppMethodBeat.o(38945);
    }
}
