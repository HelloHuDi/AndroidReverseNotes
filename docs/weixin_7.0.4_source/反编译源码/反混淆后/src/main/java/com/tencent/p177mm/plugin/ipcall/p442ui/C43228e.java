package com.tencent.p177mm.plugin.ipcall.p442ui;

import android.content.Intent;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p612ui.base.C40671n.C36073c;
import com.tencent.p177mm.p612ui.base.C40671n.C5279d;
import com.tencent.p177mm.p612ui.base.C44273l;
import com.tencent.p177mm.p612ui.tools.C46696j;
import com.tencent.p177mm.plugin.ipcall.p1275b.C34382c;
import com.tencent.p177mm.plugin.ipcall.p438a.C21088i;
import com.tencent.p177mm.plugin.ipcall.p438a.p441e.C3307i;
import com.tencent.p177mm.plugin.ipcall.p438a.p983g.C12256m;
import com.tencent.p177mm.plugin.ipcall.p438a.p983g.C21083c;
import com.tencent.p177mm.plugin.ipcall.p438a.p983g.C28332k;
import com.tencent.p177mm.plugin.ipcall.p438a.p983g.C28333l;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.protocal.protobuf.aqq;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5128ac.C5127a;

/* renamed from: com.tencent.mm.plugin.ipcall.ui.e */
public final class C43228e {
    ListView nAS;
    C46913h nAT;
    View nAU;
    IPCallAddressUI nAV;
    boolean nAW = false;
    TextView nAX = null;
    TextView nAY = null;
    LinearLayout nAZ = null;
    TextView nBa = null;
    ImageView nBb = null;

    /* renamed from: com.tencent.mm.plugin.ipcall.ui.e$3 */
    class C211383 implements OnClickListener {
        C211383() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(22035);
            Intent intent = new Intent(C43228e.this.nAV, IPCallDialUI.class);
            intent.putExtra("IPCallTalkUI_dialScene", 1);
            C43228e.this.nAV.startActivityForResult(intent, 1001);
            AppMethodBeat.m2505o(22035);
        }
    }

    /* renamed from: com.tencent.mm.plugin.ipcall.ui.e$4 */
    class C211394 implements OnItemClickListener {
        C211394() {
        }

        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            AppMethodBeat.m2504i(22036);
            if (C43228e.this.nAT.mo10892wK(i)) {
                AppMethodBeat.m2505o(22036);
                return;
            }
            if (adapterView instanceof ListView) {
                C28332k xt = C43228e.this.nAT.mo76123xt(i - ((ListView) adapterView).getHeaderViewsCount());
                if (xt == null) {
                    AppMethodBeat.m2505o(22036);
                    return;
                }
                C21083c c21083c = null;
                if (xt.field_addressId > 0) {
                    c21083c = C21088i.bHw().mo36409iU(xt.field_addressId);
                }
                Intent intent = new Intent(C43228e.this.nAV, IPCallUserProfileUI.class);
                if (c21083c != null) {
                    intent.putExtra("IPCallProfileUI_contactid", c21083c.field_contactId);
                    intent.putExtra("IPCallProfileUI_systemUsername", c21083c.field_systemAddressBookUsername);
                    intent.putExtra("IPCallProfileUI_wechatUsername", c21083c.field_wechatUsername);
                } else {
                    intent.putExtra("IPCallProfileUI_phonenumber", xt.field_phonenumber);
                }
                intent.putExtra("IPCallProfileUI_isNeedShowRecord", true);
                C43228e.this.nAV.startActivity(intent);
            }
            AppMethodBeat.m2505o(22036);
        }
    }

    /* renamed from: com.tencent.mm.plugin.ipcall.ui.e$5 */
    class C211405 implements OnItemLongClickListener {
        C211405() {
        }

        public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
            AppMethodBeat.m2504i(22037);
            C46913h c46913h = C43228e.this.nAT;
            if (c46913h.nDZ == null) {
                c46913h.nDZ = C12256m.bIb();
            }
            C28332k xt = C43228e.this.nAT.mo76123xt(i - ((ListView) adapterView).getHeaderViewsCount());
            C43228e c43228e = C43228e.this;
            int headerViewsCount = i - ((ListView) adapterView).getHeaderViewsCount();
            if (xt != null) {
                C46696j c46696j = new C46696j(c43228e.nAV);
                c46696j.rBl = new C432278();
                c46696j.rBm = new C392709(xt, headerViewsCount);
                c46696j.cuu();
            }
            AppMethodBeat.m2505o(22037);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.ipcall.ui.e$6 */
    class C211416 implements Runnable {
        C211416() {
        }

        public final void run() {
            AppMethodBeat.m2504i(22038);
            C9638aw.m17190ZK();
            if (((Boolean) C18628c.m29072Ry().get(C5127a.USERINFO_IPCALL_ADDRESS_ACCOUNT_SHOW_REDDOT_BOOLEAN, Boolean.FALSE)).booleanValue()) {
                C43228e.this.nBb.setVisibility(0);
            } else {
                C43228e.this.nBb.setVisibility(8);
            }
            C9638aw.m17190ZK();
            String str = (String) C18628c.m29072Ry().get(C5127a.USERFINO_IPCALL_ADDRESS_ACCOUNT_STRING, (Object) "");
            C9638aw.m17190ZK();
            String str2 = (String) C18628c.m29072Ry().get(C5127a.USERFINO_IPCALL_ADDRESS_ACCOUNT_ACTIVITY_STRING, (Object) "");
            if (!C5046bo.isNullOrNil(str)) {
                C43228e.this.nBa.setText(str);
                C43228e.this.nAZ.setVisibility(0);
                AppMethodBeat.m2505o(22038);
            } else if (C5046bo.isNullOrNil(str2)) {
                C43228e.this.nBa.setText("");
                C43228e.this.nAZ.setVisibility(8);
                AppMethodBeat.m2505o(22038);
            } else {
                C43228e.this.nBa.setText(str2);
                C43228e.this.nAZ.setVisibility(0);
                AppMethodBeat.m2505o(22038);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.ipcall.ui.e$2 */
    class C392692 implements OnClickListener {
        C392692() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(22034);
            Intent intent = new Intent();
            intent.setClass(C43228e.this.nAV, IPCallContactUI.class);
            C43228e.this.nAV.startActivity(intent);
            AppMethodBeat.m2505o(22034);
        }
    }

    /* renamed from: com.tencent.mm.plugin.ipcall.ui.e$9 */
    class C392709 implements C5279d {
        final /* synthetic */ C28332k nBd;
        final /* synthetic */ int nBe;

        C392709(C28332k c28332k, int i) {
            this.nBd = c28332k;
            this.nBe = i;
        }

        public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
            AppMethodBeat.m2504i(22041);
            if (i == 0) {
                C43228e c43228e = C43228e.this;
                C28332k c28332k = this.nBd;
                int i2 = this.nBe;
                C28333l bHx;
                if (c28332k.field_addressId > 0) {
                    bHx = C21088i.bHx();
                    if (c28332k.field_addressId > 0 && bHx.bSd.delete("IPCallRecord", "addressId=?", new String[]{String.valueOf(c28332k.field_addressId)}) < 0) {
                        C4990ab.m7411d("MicroMsg.IPCallRecordStorage", "deleteByAddressId failed, ret: %d, addressId: %d", Integer.valueOf(bHx.bSd.delete("IPCallRecord", "addressId=?", new String[]{String.valueOf(c28332k.field_addressId)})), Long.valueOf(r4));
                    }
                } else {
                    bHx = C21088i.bHx();
                    if (!C5046bo.isNullOrNil(c28332k.field_phonenumber) && bHx.bSd.delete("IPCallRecord", "phonenumber=?", new String[]{c28332k.field_phonenumber}) < 0) {
                        C4990ab.m7411d("MicroMsg.IPCallRecordStorage", "deleteByCallPhoneNumber failed, ret: %d, phoneNumber: %s", Integer.valueOf(bHx.bSd.delete("IPCallRecord", "phonenumber=?", new String[]{c28332k.field_phonenumber})), r1);
                    }
                }
                C46913h c46913h = c43228e.nAT;
                c46913h.nDZ.remove(i2);
                c46913h.notifyDataSetChanged();
                if (c43228e.nAT.getCount() > 0) {
                    c43228e.nAU.setVisibility(8);
                    AppMethodBeat.m2505o(22041);
                    return;
                }
                c43228e.nAU.setVisibility(0);
            }
            AppMethodBeat.m2505o(22041);
        }
    }

    /* renamed from: com.tencent.mm.plugin.ipcall.ui.e$7 */
    class C432267 implements Runnable {
        C432267() {
        }

        public final void run() {
            AppMethodBeat.m2504i(22039);
            aqq bIU = C34382c.bIU();
            if (bIU != null) {
                C43228e.this.nAX.setText(bIU.wuw);
                if (C5046bo.isNullOrNil(bIU.wuE)) {
                    C43228e.this.nAY.setText("");
                    C43228e.this.nAY.setVisibility(8);
                    AppMethodBeat.m2505o(22039);
                    return;
                }
                C43228e.this.nAY.setText(bIU.wuE);
                C43228e.this.nAY.setVisibility(0);
                AppMethodBeat.m2505o(22039);
                return;
            }
            C43228e.this.nAX.setText("");
            C43228e.this.nAY.setText("");
            C43228e.this.nAY.setVisibility(8);
            AppMethodBeat.m2505o(22039);
        }
    }

    /* renamed from: com.tencent.mm.plugin.ipcall.ui.e$8 */
    class C432278 implements C36073c {
        C432278() {
        }

        /* renamed from: a */
        public final void mo5746a(C44273l c44273l) {
            AppMethodBeat.m2504i(22040);
            c44273l.add((int) C25738R.string.f9088p4);
            AppMethodBeat.m2505o(22040);
        }
    }

    /* renamed from: com.tencent.mm.plugin.ipcall.ui.e$1 */
    class C432291 implements OnClickListener {
        C432291() {
        }

        public final void onClick(View view) {
            int i;
            Object obj;
            AppMethodBeat.m2504i(22033);
            C9638aw.m17190ZK();
            boolean booleanValue = ((Boolean) C18628c.m29072Ry().get(C5127a.USERINFO_IPCALL_ADDRESS_ACCOUNT_SHOW_REDDOT_BOOLEAN, Boolean.FALSE)).booleanValue();
            if (booleanValue) {
                C9638aw.m17190ZK();
                C3307i.m5626Z(2, ((Integer) C18628c.m29072Ry().get(C5127a.USERFINO_IPCALL_ADDRESS_ACCOUNT_SHOW_REDDOT_TYPE_INT, Integer.valueOf(-1))).intValue(), -1);
                C9638aw.m17190ZK();
                C18628c.m29072Ry().set(C5127a.USERFINO_IPCALL_ADDRESS_ACCOUNT_SHOW_REDDOT_TYPE_INT, Integer.valueOf(-1));
                C4990ab.m7417i("MicroMsg.IPCallAddressController", "set red dot type from %d to -1", Integer.valueOf(i));
            }
            if (booleanValue) {
                obj = "true";
            } else {
                String obj2 = "false";
            }
            C9638aw.m17190ZK();
            String str = (String) C18628c.m29072Ry().get(C5127a.USERFINO_IPCALL_ADDRESS_ACCOUNT_STRING, (Object) "");
            C4990ab.m7417i("MicroMsg.IPCallAddressController", "set show red dot from %s to false, set account string from %s to null", obj2, str);
            C9638aw.m17190ZK();
            C18628c.m29072Ry().set(C5127a.USERINFO_IPCALL_ADDRESS_ACCOUNT_SHOW_REDDOT_BOOLEAN, Boolean.FALSE);
            C9638aw.m17190ZK();
            C18628c.m29072Ry().set(C5127a.USERFINO_IPCALL_ADDRESS_ACCOUNT_STRING, (Object) "");
            C9638aw.m17190ZK();
            if (((Integer) C18628c.m29072Ry().get(C5127a.USERINFO_IPCALL_ADDRESS_ACCOUNT_ACTIVITY_CLEAR_TYPE_INT, Integer.valueOf(0))).intValue() == 1) {
                i = 0;
            } else {
                i = 1;
            }
            if (i != 0) {
                C9638aw.m17190ZK();
                C4990ab.m7417i("MicroMsg.IPCallAddressController", "set account activity string from %s to null", (String) C18628c.m29072Ry().get(C5127a.USERFINO_IPCALL_ADDRESS_ACCOUNT_ACTIVITY_STRING, (Object) ""));
                C9638aw.m17190ZK();
                C18628c.m29072Ry().set(C5127a.USERFINO_IPCALL_ADDRESS_ACCOUNT_ACTIVITY_STRING, (Object) "");
            }
            C7060h.pYm.mo8381e(12061, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0));
            C43228e.this.bIh();
            Intent intent = new Intent();
            intent.setClass(C43228e.this.nAV, IPCallShareCouponUI.class);
            C43228e.this.nAV.startActivity(intent);
            AppMethodBeat.m2505o(22033);
        }
    }

    public C43228e(IPCallAddressUI iPCallAddressUI, ListView listView, View view) {
        this.nAS = listView;
        this.nAV = iPCallAddressUI;
        this.nAU = view;
    }

    public final void bIh() {
        AppMethodBeat.m2504i(22042);
        C5004al.m7441d(new C211416());
        AppMethodBeat.m2505o(22042);
    }

    public final void bIi() {
        AppMethodBeat.m2504i(22043);
        C5004al.m7441d(new C432267());
        AppMethodBeat.m2505o(22043);
    }
}
