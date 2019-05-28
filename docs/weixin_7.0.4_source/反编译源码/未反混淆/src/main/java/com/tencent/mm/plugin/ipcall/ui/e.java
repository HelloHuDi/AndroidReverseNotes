package com.tencent.mm.plugin.ipcall.ui;

import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.ipcall.a.g.k;
import com.tencent.mm.plugin.ipcall.a.g.l;
import com.tencent.mm.plugin.ipcall.a.i;
import com.tencent.mm.protocal.protobuf.aqq;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.ui.base.n.d;

public final class e {
    ListView nAS;
    h nAT;
    View nAU;
    IPCallAddressUI nAV;
    boolean nAW = false;
    TextView nAX = null;
    TextView nAY = null;
    LinearLayout nAZ = null;
    TextView nBa = null;
    ImageView nBb = null;

    /* renamed from: com.tencent.mm.plugin.ipcall.ui.e$9 */
    class AnonymousClass9 implements d {
        final /* synthetic */ k nBd;
        final /* synthetic */ int nBe;

        AnonymousClass9(k kVar, int i) {
            this.nBd = kVar;
            this.nBe = i;
        }

        public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
            AppMethodBeat.i(22041);
            if (i == 0) {
                e eVar = e.this;
                k kVar = this.nBd;
                int i2 = this.nBe;
                l bHx;
                if (kVar.field_addressId > 0) {
                    bHx = i.bHx();
                    if (kVar.field_addressId > 0 && bHx.bSd.delete("IPCallRecord", "addressId=?", new String[]{String.valueOf(kVar.field_addressId)}) < 0) {
                        ab.d("MicroMsg.IPCallRecordStorage", "deleteByAddressId failed, ret: %d, addressId: %d", Integer.valueOf(bHx.bSd.delete("IPCallRecord", "addressId=?", new String[]{String.valueOf(kVar.field_addressId)})), Long.valueOf(r4));
                    }
                } else {
                    bHx = i.bHx();
                    if (!bo.isNullOrNil(kVar.field_phonenumber) && bHx.bSd.delete("IPCallRecord", "phonenumber=?", new String[]{kVar.field_phonenumber}) < 0) {
                        ab.d("MicroMsg.IPCallRecordStorage", "deleteByCallPhoneNumber failed, ret: %d, phoneNumber: %s", Integer.valueOf(bHx.bSd.delete("IPCallRecord", "phonenumber=?", new String[]{kVar.field_phonenumber})), r1);
                    }
                }
                h hVar = eVar.nAT;
                hVar.nDZ.remove(i2);
                hVar.notifyDataSetChanged();
                if (eVar.nAT.getCount() > 0) {
                    eVar.nAU.setVisibility(8);
                    AppMethodBeat.o(22041);
                    return;
                }
                eVar.nAU.setVisibility(0);
            }
            AppMethodBeat.o(22041);
        }
    }

    public e(IPCallAddressUI iPCallAddressUI, ListView listView, View view) {
        this.nAS = listView;
        this.nAV = iPCallAddressUI;
        this.nAU = view;
    }

    public final void bIh() {
        AppMethodBeat.i(22042);
        al.d(new Runnable() {
            public final void run() {
                AppMethodBeat.i(22038);
                aw.ZK();
                if (((Boolean) c.Ry().get(a.USERINFO_IPCALL_ADDRESS_ACCOUNT_SHOW_REDDOT_BOOLEAN, Boolean.FALSE)).booleanValue()) {
                    e.this.nBb.setVisibility(0);
                } else {
                    e.this.nBb.setVisibility(8);
                }
                aw.ZK();
                String str = (String) c.Ry().get(a.USERFINO_IPCALL_ADDRESS_ACCOUNT_STRING, (Object) "");
                aw.ZK();
                String str2 = (String) c.Ry().get(a.USERFINO_IPCALL_ADDRESS_ACCOUNT_ACTIVITY_STRING, (Object) "");
                if (!bo.isNullOrNil(str)) {
                    e.this.nBa.setText(str);
                    e.this.nAZ.setVisibility(0);
                    AppMethodBeat.o(22038);
                } else if (bo.isNullOrNil(str2)) {
                    e.this.nBa.setText("");
                    e.this.nAZ.setVisibility(8);
                    AppMethodBeat.o(22038);
                } else {
                    e.this.nBa.setText(str2);
                    e.this.nAZ.setVisibility(0);
                    AppMethodBeat.o(22038);
                }
            }
        });
        AppMethodBeat.o(22042);
    }

    public final void bIi() {
        AppMethodBeat.i(22043);
        al.d(new Runnable() {
            public final void run() {
                AppMethodBeat.i(22039);
                aqq bIU = com.tencent.mm.plugin.ipcall.b.c.bIU();
                if (bIU != null) {
                    e.this.nAX.setText(bIU.wuw);
                    if (bo.isNullOrNil(bIU.wuE)) {
                        e.this.nAY.setText("");
                        e.this.nAY.setVisibility(8);
                        AppMethodBeat.o(22039);
                        return;
                    }
                    e.this.nAY.setText(bIU.wuE);
                    e.this.nAY.setVisibility(0);
                    AppMethodBeat.o(22039);
                    return;
                }
                e.this.nAX.setText("");
                e.this.nAY.setText("");
                e.this.nAY.setVisibility(8);
                AppMethodBeat.o(22039);
            }
        });
        AppMethodBeat.o(22043);
    }
}
