package com.tencent.p177mm.plugin.sns.p520ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.kernel.C18524i;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.p264n.C7486a;
import com.tencent.p177mm.p612ui.widget.snackbar.C5670b;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.messenger.p993a.C12519g;
import com.tencent.p177mm.plugin.sns.data.C29036i;
import com.tencent.p177mm.plugin.sns.model.C13373af;
import com.tencent.p177mm.plugin.sns.model.C3889am.C3890a;
import com.tencent.p177mm.plugin.sns.model.C3892an;
import com.tencent.p177mm.plugin.sns.p1025h.C34937b;
import com.tencent.p177mm.plugin.sns.p520ui.C29238s.C29239a;
import com.tencent.p177mm.plugin.sns.storage.C35002v;
import com.tencent.p177mm.plugin.sns.storage.C46236n;
import com.tencent.p177mm.plugin.webview.p580ui.tools.widget.C29970o;
import com.tencent.p177mm.protocal.protobuf.bau;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C44222az;
import com.tencent.p177mm.storage.C7616ad;
import com.tencent.p177mm.vfs.C5730e;
import java.util.ArrayList;
import java.util.List;

@C18524i
/* renamed from: com.tencent.mm.plugin.sns.ui.SnsGalleryUI */
public class SnsGalleryUI extends SnsBaseGalleryUI implements C29239a {
    private int rpr = 0;
    private String userName = "";

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsGalleryUI$2 */
    class C135322 implements OnMenuItemClickListener {
        C135322() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(38936);
            SnsGalleryUI.this.rpl.crL();
            AppMethodBeat.m2505o(38936);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsGalleryUI$1 */
    class C135331 implements Runnable {
        C135331() {
        }

        public final void run() {
            AppMethodBeat.m2504i(38935);
            SnsGalleryUI.this.rpl.crL();
            AppMethodBeat.m2505o(38935);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(38938);
        super.onCreate(bundle);
        getWindow().addFlags(128);
        mo17446xE(this.mController.ylL.getResources().getColor(C25738R.color.f11906l8));
        mo17372Nb(this.mController.ylL.getResources().getColor(C25738R.color.f11906l8));
        initView();
        AppMethodBeat.m2505o(38938);
    }

    public void onDestroy() {
        int max;
        AppMethodBeat.m2504i(38939);
        if (this.rpp != null) {
            this.rpp.ctm();
            this.rpp.onDestroy();
        }
        getWindow().clearFlags(128);
        C3890a cnv = C13373af.cnv();
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
        C13373af.cnC().mo37452ab(this);
        super.onDestroy();
        AppMethodBeat.m2505o(38939);
    }

    public void onPause() {
        AppMethodBeat.m2504i(38940);
        super.onPause();
        C29970o.m47417JV(2);
        AppMethodBeat.m2505o(38940);
    }

    public void onResume() {
        AppMethodBeat.m2504i(38941);
        super.onResume();
        if (this.rpp != null) {
            this.rpp.btt();
        }
        C29970o.m47417JV(1);
        AppMethodBeat.m2505o(38941);
    }

    public final int getLayoutId() {
        return 2130970761;
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        AppMethodBeat.m2504i(38942);
        if (keyEvent.getKeyCode() == 4 && keyEvent.getAction() == 0) {
            C4990ab.m7410d("MicroMsg.SnsGalleryUI", "dispatchKeyEvent");
            Intent intent = new Intent();
            intent.putExtra("sns_cmd_list", this.rpl.rjk);
            setResult(-1, intent);
            finish();
            AppMethodBeat.m2505o(38942);
            return true;
        }
        boolean dispatchKeyEvent = super.dispatchKeyEvent(keyEvent);
        AppMethodBeat.m2505o(38942);
        return dispatchKeyEvent;
    }

    public final void initView() {
        C44222az dti;
        AppMethodBeat.m2504i(38943);
        this.userName = getIntent().getStringExtra("sns_gallery_userName");
        int intExtra = getIntent().getIntExtra("sns_gallery_localId", 0);
        final boolean booleanExtra = getIntent().getBooleanExtra("sns_gallery_is_self", false);
        this.rpr = getIntent().getIntExtra("sns_gallery_position", 0);
        C4990ab.m7417i("MicroMsg.SnsGalleryUI", "initView localId:%s, pos:%d", C35002v.m57490ap("sns_table_", (long) intExtra), Integer.valueOf(this.rpr));
        mo8728dh(r0, this.rpr);
        mo69187D(booleanExtra, 1);
        this.rpp = new SnsInfoFlip(this);
        this.rpp.setNeedScanImage(true);
        List Yb = C13373af.cnv().mo8615Yb(this.userName);
        if (Yb == null) {
            Yb = new ArrayList();
        }
        this.rpp.setDoubleClick(true);
        this.rpp.setShowTitle(true);
        this.rpp.setEnableHorLongBmpMode(false);
        this.rpp.mo8770a(Yb, this.userName, this.rpr, this.rpk, this);
        this.rpp.setOnDeleteAllAction(new C135331());
        C1720g.m3537RQ();
        C7616ad aoO = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(this.userName);
        if (aoO == null || ((int) aoO.ewQ) <= 0 || !C7486a.m12942jh(aoO.field_type)) {
            if (this.userName.equals(C1853r.m3846Yz())) {
                dti = C44222az.dti();
            } else {
                dti = C44222az.dtj();
            }
        } else {
            dti = C44222az.dth();
        }
        this.rpp.setFromScene(dti);
        this.rpp.username = this.userName;
        addView(this.rpp);
        setBackBtn(new C135322());
        addIconOptionMenu(0, C25738R.drawable.f6899uu, new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.m2504i(38937);
                String selectId = SnsGalleryUI.this.rpp.getSelectId();
                String selectedMediaId = SnsGalleryUI.this.rpp.getSelectedMediaId();
                C34937b selectItem = SnsGalleryUI.this.rpp.getSelectItem();
                C4990ab.m7410d("MicroMsg.SnsGalleryUI", "click selectLocalId ".concat(String.valueOf(selectId)));
                C4990ab.m7410d("MicroMsg.SnsGalleryUI", "click position ".concat(String.valueOf(selectedMediaId)));
                C46236n YT = C13373af.cnF().mo62918YT(selectId);
                try {
                    int i;
                    int position = SnsGalleryUI.this.rpp.getPosition();
                    int size = YT.cqu().xfI.wbK.size();
                    if (size <= 1 || position <= 1 || position > size) {
                        i = 0;
                    } else {
                        i = position - 1;
                    }
                    SnsGalleryUI.this.rpl.mo47403a(booleanExtra, YT, selectItem.cNr, true, i);
                } catch (Exception e) {
                    C4990ab.printErrStackTrace("MicroMsg.SnsGalleryUI", e, "", new Object[0]);
                }
                AppMethodBeat.m2505o(38937);
                return true;
            }
        });
        AppMethodBeat.m2505o(38943);
    }

    /* renamed from: dg */
    public final void mo8727dg(String str, int i) {
        AppMethodBeat.m2504i(38944);
        if (this.rpp != null) {
            if (!(C5046bo.isNullOrNil(str) || i == 3)) {
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
                            C34937b c34937b = (C34937b) snsInfoFlip.items.get(i3);
                            if (!C5046bo.isNullOrNil(c34937b.qQd) && c34937b.qQd.equals(str)) {
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
        AppMethodBeat.m2505o(38944);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(38945);
        C4990ab.m7416i("MicroMsg.SnsGalleryUI", "onAcvityResult requestCode:".concat(String.valueOf(i)));
        if (i2 != -1) {
            AppMethodBeat.m2505o(38945);
            return;
        }
        String str;
        if (2 == i) {
            if (-1 == i2) {
                bau bau;
                String stringExtra = intent.getStringExtra("Select_Conv_User");
                String stringExtra2 = intent.getStringExtra("custom_send_text");
                if (this.rpp != null) {
                    C34937b selectItem = this.rpp.getSelectItem();
                    if (selectItem.cNr.jCt != 6) {
                        AppMethodBeat.m2505o(38945);
                        return;
                    }
                    bau = selectItem.cNr;
                } else {
                    bau = null;
                }
                if (bau == null) {
                    AppMethodBeat.m2505o(38945);
                    return;
                }
                String fZ = C3892an.m6198fZ(C13373af.getAccSnsPath(), bau.f17915Id);
                str = "";
                String str2 = "";
                String j = C29036i.m46116j(bau);
                if (C5730e.m8628ct(fZ + j)) {
                    str2 = fZ + j;
                    str = fZ + C29036i.m46108e(bau);
                }
                if (C5730e.m8628ct(fZ + C29036i.m46126p(bau))) {
                    j = fZ + C29036i.m46126p(bau);
                    fZ = fZ + C29036i.m46123n(bau);
                } else {
                    j = str2;
                    fZ = str;
                }
                ArrayList<String> P = C5046bo.m7508P(stringExtra.split(","));
                int Xr = C29036i.m46095Xr(j);
                for (String str3 : P) {
                    C4990ab.m7417i("MicroMsg.SnsGalleryUI", "send sight to %s, videopath %s, thumbpath %s duration %d", str3, j, fZ, Integer.valueOf(Xr));
                    C12519g.bOk().mo46459a(this, str3, j, fZ, 62, Xr, "");
                    C12519g.bOk().mo46461eZ(stringExtra2, str3);
                }
                C5670b.m8523i(this, getString(C25738R.string.cbn));
                AppMethodBeat.m2505o(38945);
                return;
            }
        } else if (1 == i) {
            int intExtra = intent.getIntExtra("sns_gallery_op_id", 0);
            str = C35002v.m57490ap("sns_table_", (long) intent.getIntExtra("sns_gallery_op_id", 0));
            this.rpl.mo47401DN(intExtra);
            mo8727dg(str, 1);
            if (intent.getBooleanExtra("sns_gallery_force_finish", false)) {
                Intent intent2 = new Intent();
                intent2.putExtra("sns_cmd_list", this.rpl.rjk);
                setResult(-1, intent2);
                finish();
            }
        }
        AppMethodBeat.m2505o(38945);
    }
}
