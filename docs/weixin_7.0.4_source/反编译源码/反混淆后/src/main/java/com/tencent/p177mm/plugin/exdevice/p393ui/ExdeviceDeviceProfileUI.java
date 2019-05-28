package com.tencent.p177mm.plugin.exdevice.p393ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.google.android.gms.common.Scopes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p184aj.C41747z;
import com.tencent.p177mm.p230g.p231a.C9315dc;
import com.tencent.p177mm.p264n.C7486a;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C30379h.C30387b;
import com.tencent.p177mm.p612ui.base.C44275p;
import com.tencent.p177mm.p612ui.base.preference.C15541f;
import com.tencent.p177mm.p612ui.base.preference.C40675h;
import com.tencent.p177mm.p612ui.base.preference.KeyValuePreference;
import com.tencent.p177mm.p612ui.base.preference.MMPreference;
import com.tencent.p177mm.p612ui.base.preference.Preference;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.exdevice.C45875a;
import com.tencent.p177mm.plugin.exdevice.model.C20540x;
import com.tencent.p177mm.plugin.exdevice.model.C20541y;
import com.tencent.p177mm.plugin.exdevice.model.C27852f;
import com.tencent.p177mm.plugin.exdevice.model.C27853m;
import com.tencent.p177mm.plugin.exdevice.model.C38957l;
import com.tencent.p177mm.plugin.exdevice.model.C45891ad;
import com.tencent.p177mm.plugin.exdevice.p1611j.C42992b;
import com.tencent.p177mm.plugin.exdevice.p956h.C11648b;
import com.tencent.p177mm.protocal.protobuf.asq;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7564ap;
import com.tencent.p177mm.sdk.platformtools.C7564ap.C5015a;
import com.tencent.p177mm.storage.C7616ad;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;

/* renamed from: com.tencent.mm.plugin.exdevice.ui.ExdeviceDeviceProfileUI */
public class ExdeviceDeviceProfileUI extends MMPreference implements C1202f {
    private String cbq;
    private C44275p ejZ;
    private String lAF;
    private String lAG;
    private boolean lAH;
    private String lAI;
    private boolean lAJ;
    private String lAK;
    private C30387b lAL;
    private String lst;
    private String lsu;
    private long ltD;
    private String lxI;
    private String lyF;
    private String lyG;
    private String lya;
    private int lzD;
    private C44275p lzK = null;

    /* renamed from: com.tencent.mm.plugin.exdevice.ui.ExdeviceDeviceProfileUI$13 */
    class C299513 implements Runnable {
        C299513() {
        }

        public final void run() {
            AppMethodBeat.m2504i(19950);
            ExdeviceDeviceProfileUI.m11337a(ExdeviceDeviceProfileUI.this, (DeviceProfileHeaderPreference) ExdeviceDeviceProfileUI.this.yCw.aqO("device_profile_header"));
            AppMethodBeat.m2505o(19950);
        }
    }

    /* renamed from: com.tencent.mm.plugin.exdevice.ui.ExdeviceDeviceProfileUI$14 */
    class C299614 implements Runnable {
        C299614() {
        }

        public final void run() {
            AppMethodBeat.m2504i(19951);
            ExdeviceDeviceProfileUI.this.lAG = null;
            ExdeviceDeviceProfileUI.this.lAH = false;
            ExdeviceDeviceProfileUI.m11345f(ExdeviceDeviceProfileUI.this);
            ExdeviceDeviceProfileUI.this.yCw.notifyDataSetChanged();
            AppMethodBeat.m2505o(19951);
        }
    }

    /* renamed from: com.tencent.mm.plugin.exdevice.ui.ExdeviceDeviceProfileUI$2 */
    class C68572 implements Runnable {
        C68572() {
        }

        public final void run() {
            AppMethodBeat.m2504i(19935);
            if (ExdeviceDeviceProfileUI.this.ejZ != null && ExdeviceDeviceProfileUI.this.ejZ.isShowing()) {
                ExdeviceDeviceProfileUI.this.ejZ.dismiss();
            }
            if (ExdeviceDeviceProfileUI.this.lzK != null && ExdeviceDeviceProfileUI.this.lzK.isShowing()) {
                ExdeviceDeviceProfileUI.this.lzK.dismiss();
            }
            AppMethodBeat.m2505o(19935);
        }
    }

    /* renamed from: com.tencent.mm.plugin.exdevice.ui.ExdeviceDeviceProfileUI$3 */
    class C68583 implements Runnable {
        C68583() {
        }

        public final void run() {
            AppMethodBeat.m2504i(19936);
            C30379h.m48461b(ExdeviceDeviceProfileUI.this, ExdeviceDeviceProfileUI.this.getString(C25738R.string.bes), ExdeviceDeviceProfileUI.this.getString(C25738R.string.f9238tz), true);
            AppMethodBeat.m2505o(19936);
        }
    }

    /* renamed from: com.tencent.mm.plugin.exdevice.ui.ExdeviceDeviceProfileUI$4 */
    class C68614 implements Runnable {
        C68614() {
        }

        public final void run() {
            AppMethodBeat.m2504i(19939);
            Context context = ExdeviceDeviceProfileUI.this;
            ExdeviceDeviceProfileUI.this.getString(C25738R.string.f9238tz);
            final C44275p b = C30379h.m48458b(context, ExdeviceDeviceProfileUI.this.getString(C25738R.string.bf6), false, null);
            new C7564ap(new C5015a() {

                /* renamed from: com.tencent.mm.plugin.exdevice.ui.ExdeviceDeviceProfileUI$4$1$1 */
                class C68561 implements Runnable {
                    C68561() {
                    }

                    public final void run() {
                        AppMethodBeat.m2504i(19937);
                        b.dismiss();
                        AppMethodBeat.m2505o(19937);
                    }
                }

                /* renamed from: BI */
                public final boolean mo4499BI() {
                    AppMethodBeat.m2504i(19938);
                    ExdeviceDeviceProfileUI.this.runOnUiThread(new C68561());
                    AppMethodBeat.m2505o(19938);
                    return true;
                }
            }, false).mo16770ae(1000, 1000);
            AppMethodBeat.m2505o(19939);
        }
    }

    /* renamed from: com.tencent.mm.plugin.exdevice.ui.ExdeviceDeviceProfileUI$12 */
    class C686212 implements Runnable {
        C686212() {
        }

        public final void run() {
            AppMethodBeat.m2504i(19949);
            ExdeviceDeviceProfileUI.this.lAH = true;
            ExdeviceDeviceProfileUI.m11345f(ExdeviceDeviceProfileUI.this);
            ExdeviceDeviceProfileUI.this.yCw.notifyDataSetChanged();
            AppMethodBeat.m2505o(19949);
        }
    }

    /* renamed from: com.tencent.mm.plugin.exdevice.ui.ExdeviceDeviceProfileUI$11 */
    class C686311 implements Runnable {
        C686311() {
        }

        public final void run() {
            AppMethodBeat.m2504i(19948);
            ExdeviceDeviceProfileUI.this.lAH = true;
            ExdeviceDeviceProfileUI.m11345f(ExdeviceDeviceProfileUI.this);
            ExdeviceDeviceProfileUI.this.yCw.notifyDataSetChanged();
            AppMethodBeat.m2505o(19948);
        }
    }

    /* renamed from: com.tencent.mm.plugin.exdevice.ui.ExdeviceDeviceProfileUI$1 */
    class C68641 implements OnMenuItemClickListener {
        C68641() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(19934);
            ExdeviceDeviceProfileUI.this.finish();
            AppMethodBeat.m2505o(19934);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.exdevice.ui.ExdeviceDeviceProfileUI$7 */
    class C68657 implements C30387b {

        /* renamed from: com.tencent.mm.plugin.exdevice.ui.ExdeviceDeviceProfileUI$7$1 */
        class C68661 implements Runnable {
            C68661() {
            }

            public final void run() {
                AppMethodBeat.m2504i(19943);
                ExdeviceDeviceProfileUI.m11337a(ExdeviceDeviceProfileUI.this, (DeviceProfileHeaderPreference) ExdeviceDeviceProfileUI.this.yCw.aqO("device_profile_header"));
                AppMethodBeat.m2505o(19943);
            }
        }

        C68657() {
        }

        /* renamed from: s */
        public final boolean mo4760s(CharSequence charSequence) {
            AppMethodBeat.m2504i(19944);
            C4990ab.m7411d("MicroMsg.ExdeviceDeviceProfileUI", "result : %s.", charSequence);
            String str = "";
            if (charSequence != null) {
                str = charSequence.toString();
            }
            if (ExdeviceDeviceProfileUI.this.lAJ) {
                ExdeviceDeviceProfileUI.this.lAG = str;
                ExdeviceDeviceProfileUI.this.runOnUiThread(new C68661());
                C11648b dS = C45891ad.boW().mo45706dS(ExdeviceDeviceProfileUI.this.lsu, ExdeviceDeviceProfileUI.this.lxI);
                if (dS == null) {
                    C4990ab.m7417i("MicroMsg.ExdeviceDeviceProfileUI", "hard device info is null.(deviceId:%s, deviceType:%s)", ExdeviceDeviceProfileUI.this.lsu, ExdeviceDeviceProfileUI.this.lxI);
                    AppMethodBeat.m2505o(19944);
                    return false;
                }
                dS.mo60557iy(ExdeviceDeviceProfileUI.this.lAG);
                C45891ad.boW().mo10103c(dS, new String[0]);
            } else {
                C1207m c20541y = new C20541y(ExdeviceDeviceProfileUI.this.lsu, ExdeviceDeviceProfileUI.this.lxI, str);
                ExdeviceDeviceProfileUI.m11336a(ExdeviceDeviceProfileUI.this, c20541y);
                C9638aw.m17182Rg().mo14539a(1263, ExdeviceDeviceProfileUI.this);
                C9638aw.m17182Rg().mo14541a(c20541y, 0);
            }
            AppMethodBeat.m2505o(19944);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.exdevice.ui.ExdeviceDeviceProfileUI$9 */
    class C68679 implements OnClickListener {
        C68679() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(19946);
            C30379h.m48442a(ExdeviceDeviceProfileUI.this, ExdeviceDeviceProfileUI.this.getString(C25738R.string.bgd), ExdeviceDeviceProfileUI.this.lAG, "", 50, ExdeviceDeviceProfileUI.this.lAL);
            AppMethodBeat.m2505o(19946);
        }
    }

    /* renamed from: com.tencent.mm.plugin.exdevice.ui.ExdeviceDeviceProfileUI$6 */
    class C68696 implements Runnable {
        C68696() {
        }

        public final void run() {
            AppMethodBeat.m2504i(19942);
            Toast.makeText(ExdeviceDeviceProfileUI.this.mController.ylL, C25738R.string.bie, 1).show();
            AppMethodBeat.m2505o(19942);
        }
    }

    /* renamed from: com.tencent.mm.plugin.exdevice.ui.ExdeviceDeviceProfileUI$8 */
    class C68708 implements OnClickListener {
        C68708() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(19945);
            C30379h.m48442a(ExdeviceDeviceProfileUI.this, ExdeviceDeviceProfileUI.this.getString(C25738R.string.bgd), "", "", 50, ExdeviceDeviceProfileUI.this.lAL);
            AppMethodBeat.m2505o(19945);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    /* JADX WARNING: Missing block: B:50:0x01cb, code skipped:
            if (com.tencent.p177mm.sdk.platformtools.C5046bo.isNullOrNil(r11.lyG) == false) goto L_0x01cd;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onCreate(Bundle bundle) {
        int i = 0;
        AppMethodBeat.m2504i(19952);
        super.onCreate(bundle);
        setBackBtn(new C68641());
        setMMTitle((int) C25738R.string.bf0);
        mo17446xE(this.mController.ylL.getResources().getColor(C25738R.color.f11677d4));
        this.lAL = new C68657();
        Intent intent = getIntent();
        this.cbq = intent.getStringExtra("device_mac");
        this.ltD = intent.getLongExtra("device_ble_simple_proto", 0);
        this.lAF = intent.getStringExtra("device_jump_url");
        this.lst = intent.getStringExtra("device_brand_name");
        this.lsu = intent.getStringExtra("device_id");
        this.lxI = intent.getStringExtra("device_type");
        this.lyG = intent.getStringExtra("bind_ticket");
        this.lzD = intent.getIntExtra("subscribe_flag", 0);
        this.lAH = intent.getBooleanExtra("device_has_bound", false);
        this.lyF = intent.getStringExtra("device_title");
        this.lAG = intent.getStringExtra("device_alias");
        this.lya = intent.getStringExtra("device_desc");
        this.lAI = intent.getStringExtra("device_icon_url");
        if (C5046bo.isNullOrNil(this.lsu) || C5046bo.isNullOrNil(this.lxI)) {
            C4990ab.m7413e("MicroMsg.ExdeviceDeviceProfileUI", "deviceId or deviceType is null.", this.lsu, this.lxI);
        } else {
            C11648b dS = C45891ad.boW().mo45706dS(this.lsu, this.lxI);
            if (dS != null) {
                this.lAH = true;
                if (C5046bo.isNullOrNil(this.lAG)) {
                    this.lAG = C5046bo.nullAsNil(dS.dFl);
                }
                if (C5046bo.isNullOrNil(this.lyF)) {
                    this.lyF = C5046bo.nullAsNil(dS.dFm);
                }
                if (C5046bo.isNullOrNil(this.lst)) {
                    this.lst = C5046bo.nullAsNil(dS.field_brandName);
                }
                if (C5046bo.isNullOrNil(this.lya)) {
                    this.lya = C5046bo.nullAsNil(dS.dFn);
                }
                if (C5046bo.isNullOrNil(this.lAI)) {
                    this.lAI = C5046bo.nullAsNil(dS.iconUrl);
                }
                if (C5046bo.isNullOrNil(this.lAF)) {
                    this.lAF = C5046bo.nullAsNil(dS.jumpUrl);
                }
                if (dS.dFp == 2) {
                    this.lAJ = true;
                    this.lAK = this.lyF;
                    for (C11648b dS2 : C45891ad.boW().bpB()) {
                        if (dS2.field_deviceType.equals(this.lxI)) {
                            String str = dS2.dFu;
                            if (str != null && str.length() > 0) {
                                String[] split = str.split(",");
                                for (String equals : split) {
                                    if (equals.equals(this.lsu)) {
                                        if (C5046bo.isNullOrNil(dS2.dFl)) {
                                            this.lAK = dS2.dFm;
                                        } else {
                                            this.lAK = dS2.dFl;
                                        }
                                        C4990ab.m7417i("MicroMsg.ExdeviceDeviceProfileUI", "mGateWayTitle %s", this.lAK);
                                    }
                                }
                            }
                        }
                    }
                }
            }
            i = 1;
        }
        if (i == 0) {
            Toast.makeText(this.mController.ylL, C25738R.string.bgl, 1).show();
            finish();
            AppMethodBeat.m2505o(19952);
            return;
        }
        bcb();
        AppMethodBeat.m2505o(19952);
    }

    /* renamed from: a */
    private void m11335a(DeviceProfileHeaderPreference deviceProfileHeaderPreference) {
        AppMethodBeat.m2504i(19954);
        CharSequence charSequence = C5046bo.isNullOrNil(this.lyF) ? this.lst : this.lyF;
        if (C5046bo.isNullOrNil(this.lAG)) {
            deviceProfileHeaderPreference.setName(charSequence);
            deviceProfileHeaderPreference.mo68539Ky("");
            deviceProfileHeaderPreference.mo68540Q(3, false);
            deviceProfileHeaderPreference.mo68540Q(4, false);
            deviceProfileHeaderPreference.mo68540Q(1, this.lAH);
        } else {
            deviceProfileHeaderPreference.setName(this.lAG);
            deviceProfileHeaderPreference.mo68539Ky(getString(C25738R.string.bg7, new Object[]{charSequence}));
            deviceProfileHeaderPreference.mo68540Q(3, true);
            deviceProfileHeaderPreference.mo68540Q(4, true);
            deviceProfileHeaderPreference.mo68540Q(1, false);
        }
        deviceProfileHeaderPreference.mo68543jo(this.lya);
        AppMethodBeat.m2505o(19954);
    }

    /* renamed from: JC */
    public final int mo8452JC() {
        return C25738R.xml.f8503an;
    }

    /* renamed from: a */
    public final boolean mo8453a(C15541f c15541f, Preference preference) {
        AppMethodBeat.m2504i(19955);
        C4990ab.m7411d("MicroMsg.ExdeviceDeviceProfileUI", "onPreferenceTreeClcik.(key : %s)", preference.mKey);
        String str;
        final C1207m c1207m;
        if ("bind_device".equals(preference.mKey)) {
            if (C5046bo.isNullOrNil(this.lyG)) {
                C4990ab.m7416i("MicroMsg.ExdeviceDeviceProfileUI", "Do unauth bind device.");
                C1207m c27853m = new C27853m(C42992b.m76346KK(this.cbq), this.lst, TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL, this.ltD);
                m11348k(c27853m);
                C9638aw.m17182Rg().mo14539a(1262, (C1202f) this);
                C9638aw.m17182Rg().mo14541a(c27853m, 0);
            } else {
                C4990ab.m7416i("MicroMsg.ExdeviceDeviceProfileUI", "Do normal bind device.");
                str = this.lyG;
                int i = this.lzD;
                C9638aw.m17182Rg().mo14539a(536, (C1202f) this);
                C9315dc c9315dc = new C9315dc();
                c9315dc.cwj.cwl = str;
                c9315dc.cwj.opType = 1;
                c9315dc.cwj.cwm = i;
                C4879a.xxA.mo10055m(c9315dc);
                c1207m = c9315dc.cwk.cwn;
                getString(C25738R.string.f9238tz);
                this.lzK = C30379h.m48458b((Context) this, getString(C25738R.string.bf3), true, new OnCancelListener() {
                    public final void onCancel(DialogInterface dialogInterface) {
                        AppMethodBeat.m2504i(19947);
                        C9638aw.m17182Rg().mo14546b(536, ExdeviceDeviceProfileUI.this);
                        C9315dc c9315dc = new C9315dc();
                        c9315dc.cwj.opType = 2;
                        c9315dc.cwj.cwn = c1207m;
                        C4879a.xxA.mo10055m(c9315dc);
                        AppMethodBeat.m2505o(19947);
                    }
                });
            }
        } else if ("unbind_device".equals(preference.mKey)) {
            asq asq = new asq();
            asq.jBE = this.lsu;
            asq.vIk = this.lxI;
            C11648b dS = C45891ad.boW().mo45706dS(this.lsu, this.lxI);
            if (dS != null) {
                str = dS.dFu;
                if (str != null && str.length() > 0) {
                    String[] split = str.split(",");
                    for (String dU : split) {
                        C45891ad.boW().mo45708dU(dU, this.lxI);
                    }
                }
            }
            c1207m = new C20540x(asq, 2);
            m11348k(c1207m);
            C9638aw.m17182Rg().mo14539a(537, (C1202f) this);
            C9638aw.m17182Rg().mo14541a(c1207m, 0);
        } else if ("open_device_panel".equals(preference.mKey)) {
            C27852f.m44278ao(this.mController.ylL, this.lAF);
        } else if ("contact_info_biz_go_chatting".equals(preference.mKey)) {
            C9638aw.m17190ZK();
            C7616ad aoO = C18628c.m29078XM().aoO(this.lst);
            Intent intent = new Intent();
            intent.putExtra("device_id", this.lsu);
            intent.putExtra("device_type", this.lxI);
            intent.putExtra("KIsHardDevice", true);
            intent.putExtra("KHardDeviceBindTicket", this.lyG);
            if (aoO != null) {
                if (C7486a.m12942jh(aoO.field_type) && aoO.dsf()) {
                    C41747z.aeR().mo43729qP(aoO.field_username);
                    intent.putExtra("Chat_User", this.lst);
                    intent.putExtra("finish_direct", true);
                    C45875a.lqt.mo38915d(intent, this.mController.ylL);
                } else {
                    intent.putExtra("Contact_User", this.lst);
                    intent.putExtra("force_get_contact", true);
                    C25985d.m41467b(this.mController.ylL, Scopes.PROFILE, ".ui.ContactInfoUI", intent);
                }
            }
        } else if (!("message_manage".equals(preference.mKey) || "connect_setting".equals(preference.mKey) || "user_list".equals(preference.mKey))) {
            AppMethodBeat.m2505o(19955);
            return false;
        }
        AppMethodBeat.m2505o(19955);
        return true;
    }

    public void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(19956);
        C4990ab.m7411d("MicroMsg.ExdeviceDeviceProfileUI", "onSceneEnd errType = %d, errCode = %d ,errMsg = %s", Integer.valueOf(i), Integer.valueOf(i2), str);
        if (c1207m == null) {
            C4990ab.m7412e("MicroMsg.ExdeviceDeviceProfileUI", "scene is null.");
            AppMethodBeat.m2505o(19956);
            return;
        }
        C4990ab.m7411d("MicroMsg.ExdeviceDeviceProfileUI", "type = %s", Integer.valueOf(c1207m.getType()));
        C11648b id;
        if (c1207m instanceof C38957l) {
            bpD();
            C9638aw.m17182Rg().mo14546b(c1207m.getType(), (C1202f) this);
            if (i == 0 && i2 == 0) {
                bpK();
                m11344f(C45891ad.boW().mo45706dS(this.lsu, this.lxI));
                runOnUiThread(new C686311());
                AppMethodBeat.m2505o(19956);
                return;
            }
            C4990ab.m7413e("MicroMsg.ExdeviceDeviceProfileUI", "onSceneEnd error(%d, %d, %s).(type : %d)", Integer.valueOf(i2), Integer.valueOf(i), str, Integer.valueOf(c1207m.getType()));
            bpJ();
            AppMethodBeat.m2505o(19956);
        } else if (c1207m instanceof C27853m) {
            bpD();
            C9638aw.m17182Rg().mo14546b(c1207m.getType(), (C1202f) this);
            id = C45891ad.boW().mo45710id(C42992b.m76346KK(this.cbq));
            if (i == 0 && i2 == 0 && id != null) {
                m11344f(id);
                runOnUiThread(new C686212());
                bpK();
                AppMethodBeat.m2505o(19956);
                return;
            }
            C4990ab.m7413e("MicroMsg.ExdeviceDeviceProfileUI", "onSceneEnd error(%d, %d, %s).(type : %d)", Integer.valueOf(i2), Integer.valueOf(i), str, Integer.valueOf(c1207m.getType()));
            bpJ();
            AppMethodBeat.m2505o(19956);
        } else if (c1207m instanceof C20541y) {
            bpD();
            C9638aw.m17182Rg().mo14546b(1263, (C1202f) this);
            if (i == 0 && i2 == 0) {
                this.lAG = ((C20541y) c1207m).dFl;
                runOnUiThread(new C299513());
                id = C45891ad.boW().mo45706dS(this.lsu, this.lxI);
                if (id == null) {
                    C4990ab.m7417i("MicroMsg.ExdeviceDeviceProfileUI", "hard device info is null.(deviceId:%s, deviceType:%s)", this.lsu, this.lxI);
                    AppMethodBeat.m2505o(19956);
                    return;
                }
                id.mo60557iy(this.lAG);
                C45891ad.boW().mo10103c(id, new String[0]);
                AppMethodBeat.m2505o(19956);
                return;
            }
            C4990ab.m7413e("MicroMsg.ExdeviceDeviceProfileUI", "onSceneEnd error(%d, %d, %s).(type : %d)", Integer.valueOf(i2), Integer.valueOf(i), str, Integer.valueOf(c1207m.getType()));
            Toast.makeText(this.mController.ylL, getString(C25738R.string.bgb), 1).show();
            AppMethodBeat.m2505o(19956);
        } else {
            if (c1207m instanceof C20540x) {
                bpD();
                if (i == 0 && i2 == 0) {
                    runOnUiThread(new C299614());
                    finish();
                } else {
                    C4990ab.m7413e("MicroMsg.ExdeviceDeviceProfileUI", "onSceneEnd, unbind failed (%d, %d, %s).(type : %d)", Integer.valueOf(i2), Integer.valueOf(i), str, Integer.valueOf(c1207m.getType()));
                    runOnUiThread(new C68696());
                    AppMethodBeat.m2505o(19956);
                    return;
                }
            }
            AppMethodBeat.m2505o(19956);
        }
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(19957);
        C9638aw.m17182Rg().mo14546b(537, (C1202f) this);
        super.onDestroy();
        AppMethodBeat.m2505o(19957);
    }

    /* renamed from: f */
    private void m11344f(C11648b c11648b) {
        AppMethodBeat.m2504i(19958);
        if (c11648b != null) {
            this.lsu = c11648b.field_deviceID;
            this.lxI = c11648b.field_deviceType;
            this.lAG = C5046bo.nullAsNil(c11648b.dFl);
            this.lyF = C5046bo.nullAsNil(c11648b.dFm);
            this.lst = C5046bo.nullAsNil(c11648b.field_brandName);
            this.lya = C5046bo.nullAsNil(c11648b.dFn);
            this.lAI = C5046bo.nullAsNil(c11648b.iconUrl);
            this.lAF = C5046bo.nullAsNil(c11648b.jumpUrl);
        }
        AppMethodBeat.m2505o(19958);
    }

    private void bpD() {
        AppMethodBeat.m2504i(19959);
        runOnUiThread(new C68572());
        AppMethodBeat.m2505o(19959);
    }

    private void bpJ() {
        AppMethodBeat.m2504i(19960);
        runOnUiThread(new C68583());
        AppMethodBeat.m2505o(19960);
    }

    private void bpK() {
        AppMethodBeat.m2504i(19961);
        runOnUiThread(new C68614());
        AppMethodBeat.m2505o(19961);
    }

    /* renamed from: k */
    private void m11348k(final C1207m c1207m) {
        AppMethodBeat.m2504i(19962);
        runOnUiThread(new Runnable() {

            /* renamed from: com.tencent.mm.plugin.exdevice.ui.ExdeviceDeviceProfileUI$5$1 */
            class C68601 implements OnCancelListener {
                C68601() {
                }

                public final void onCancel(DialogInterface dialogInterface) {
                    AppMethodBeat.m2504i(19940);
                    C9638aw.m17182Rg().mo14547c(c1207m);
                    AppMethodBeat.m2505o(19940);
                }
            }

            public final void run() {
                AppMethodBeat.m2504i(19941);
                ExdeviceDeviceProfileUI.this.ejZ = C30379h.m48458b(ExdeviceDeviceProfileUI.this.mController.ylL, ExdeviceDeviceProfileUI.this.getString(C25738R.string.f9260un), true, new C68601());
                AppMethodBeat.m2505o(19941);
            }
        });
        AppMethodBeat.m2505o(19962);
    }

    private void bcb() {
        String str;
        boolean z;
        C15541f c15541f;
        AppMethodBeat.m2504i(19953);
        C40675h c40675h = this.yCw;
        DeviceProfileHeaderPreference deviceProfileHeaderPreference = (DeviceProfileHeaderPreference) c40675h.aqO("device_profile_header");
        deviceProfileHeaderPreference.mo68541a(1, new C68708());
        deviceProfileHeaderPreference.mo68541a(4, new C68679());
        m11335a(deviceProfileHeaderPreference);
        deviceProfileHeaderPreference.mo68542jl(this.lAI);
        KeyValuePreference keyValuePreference = (KeyValuePreference) c40675h.aqO("connect_setting");
        KeyValuePreference keyValuePreference2 = (KeyValuePreference) c40675h.aqO("user_list");
        ((KeyValuePreference) c40675h.aqO("message_manage")).mo41844qi(true);
        keyValuePreference.mo41844qi(true);
        keyValuePreference2.mo41844qi(true);
        c40675h.mo27715ce("message_manage", true);
        c40675h.mo27715ce("connect_setting", true);
        c40675h.mo27715ce("user_list", true);
        if (this.lAJ) {
            c40675h.mo27715ce("sub_device_desc", false);
            c40675h.aqO("sub_device_desc").setTitle(getResources().getString(C25738R.string.bib, new Object[]{this.lAK}));
            c40675h.mo27715ce("bind_device", true);
            str = "unbind_device";
            z = true;
            c15541f = c40675h;
        } else {
            c40675h.mo27715ce("sub_device_desc", true);
            c40675h.mo27715ce("bind_device", this.lAH);
            str = "unbind_device";
            Object c15541f2;
            if (this.lAH) {
                z = false;
                c15541f2 = c40675h;
            } else {
                z = true;
                c15541f2 = c40675h;
            }
        }
        c15541f2.mo27715ce(str, z);
        if (C5046bo.isNullOrNil(this.lAF)) {
            c40675h.mo27715ce("open_device_panel", true);
        }
        AppMethodBeat.m2505o(19953);
    }
}
