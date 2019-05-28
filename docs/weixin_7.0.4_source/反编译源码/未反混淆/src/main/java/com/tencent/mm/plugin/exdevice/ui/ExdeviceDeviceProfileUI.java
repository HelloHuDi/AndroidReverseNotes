package com.tencent.mm.plugin.exdevice.ui;

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
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.aj.z;
import com.tencent.mm.bp.d;
import com.tencent.mm.g.a.dc;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.plugin.exdevice.model.l;
import com.tencent.mm.plugin.exdevice.model.x;
import com.tencent.mm.plugin.exdevice.model.y;
import com.tencent.mm.protocal.protobuf.asq;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.h.b;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.preference.KeyValuePreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;

public class ExdeviceDeviceProfileUI extends MMPreference implements f {
    private String cbq;
    private p ejZ;
    private String lAF;
    private String lAG;
    private boolean lAH;
    private String lAI;
    private boolean lAJ;
    private String lAK;
    private b lAL;
    private String lst;
    private String lsu;
    private long ltD;
    private String lxI;
    private String lyF;
    private String lyG;
    private String lya;
    private int lzD;
    private p lzK = null;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    /* JADX WARNING: Missing block: B:50:0x01cb, code skipped:
            if (com.tencent.mm.sdk.platformtools.bo.isNullOrNil(r11.lyG) == false) goto L_0x01cd;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onCreate(Bundle bundle) {
        int i = 0;
        AppMethodBeat.i(19952);
        super.onCreate(bundle);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(19934);
                ExdeviceDeviceProfileUI.this.finish();
                AppMethodBeat.o(19934);
                return false;
            }
        });
        setMMTitle((int) R.string.bf0);
        xE(this.mController.ylL.getResources().getColor(R.color.d4));
        this.lAL = new b() {
            public final boolean s(CharSequence charSequence) {
                AppMethodBeat.i(19944);
                ab.d("MicroMsg.ExdeviceDeviceProfileUI", "result : %s.", charSequence);
                String str = "";
                if (charSequence != null) {
                    str = charSequence.toString();
                }
                if (ExdeviceDeviceProfileUI.this.lAJ) {
                    ExdeviceDeviceProfileUI.this.lAG = str;
                    ExdeviceDeviceProfileUI.this.runOnUiThread(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(19943);
                            ExdeviceDeviceProfileUI.a(ExdeviceDeviceProfileUI.this, (DeviceProfileHeaderPreference) ExdeviceDeviceProfileUI.this.yCw.aqO("device_profile_header"));
                            AppMethodBeat.o(19943);
                        }
                    });
                    com.tencent.mm.plugin.exdevice.h.b dS = ad.boW().dS(ExdeviceDeviceProfileUI.this.lsu, ExdeviceDeviceProfileUI.this.lxI);
                    if (dS == null) {
                        ab.i("MicroMsg.ExdeviceDeviceProfileUI", "hard device info is null.(deviceId:%s, deviceType:%s)", ExdeviceDeviceProfileUI.this.lsu, ExdeviceDeviceProfileUI.this.lxI);
                        AppMethodBeat.o(19944);
                        return false;
                    }
                    dS.iy(ExdeviceDeviceProfileUI.this.lAG);
                    ad.boW().c(dS, new String[0]);
                } else {
                    m yVar = new y(ExdeviceDeviceProfileUI.this.lsu, ExdeviceDeviceProfileUI.this.lxI, str);
                    ExdeviceDeviceProfileUI.a(ExdeviceDeviceProfileUI.this, yVar);
                    aw.Rg().a(1263, ExdeviceDeviceProfileUI.this);
                    aw.Rg().a(yVar, 0);
                }
                AppMethodBeat.o(19944);
                return true;
            }
        };
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
        if (bo.isNullOrNil(this.lsu) || bo.isNullOrNil(this.lxI)) {
            ab.e("MicroMsg.ExdeviceDeviceProfileUI", "deviceId or deviceType is null.", this.lsu, this.lxI);
        } else {
            com.tencent.mm.plugin.exdevice.h.b dS = ad.boW().dS(this.lsu, this.lxI);
            if (dS != null) {
                this.lAH = true;
                if (bo.isNullOrNil(this.lAG)) {
                    this.lAG = bo.nullAsNil(dS.dFl);
                }
                if (bo.isNullOrNil(this.lyF)) {
                    this.lyF = bo.nullAsNil(dS.dFm);
                }
                if (bo.isNullOrNil(this.lst)) {
                    this.lst = bo.nullAsNil(dS.field_brandName);
                }
                if (bo.isNullOrNil(this.lya)) {
                    this.lya = bo.nullAsNil(dS.dFn);
                }
                if (bo.isNullOrNil(this.lAI)) {
                    this.lAI = bo.nullAsNil(dS.iconUrl);
                }
                if (bo.isNullOrNil(this.lAF)) {
                    this.lAF = bo.nullAsNil(dS.jumpUrl);
                }
                if (dS.dFp == 2) {
                    this.lAJ = true;
                    this.lAK = this.lyF;
                    for (com.tencent.mm.plugin.exdevice.h.b dS2 : ad.boW().bpB()) {
                        if (dS2.field_deviceType.equals(this.lxI)) {
                            String str = dS2.dFu;
                            if (str != null && str.length() > 0) {
                                String[] split = str.split(",");
                                for (String equals : split) {
                                    if (equals.equals(this.lsu)) {
                                        if (bo.isNullOrNil(dS2.dFl)) {
                                            this.lAK = dS2.dFm;
                                        } else {
                                            this.lAK = dS2.dFl;
                                        }
                                        ab.i("MicroMsg.ExdeviceDeviceProfileUI", "mGateWayTitle %s", this.lAK);
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
            Toast.makeText(this.mController.ylL, R.string.bgl, 1).show();
            finish();
            AppMethodBeat.o(19952);
            return;
        }
        bcb();
        AppMethodBeat.o(19952);
    }

    private void a(DeviceProfileHeaderPreference deviceProfileHeaderPreference) {
        AppMethodBeat.i(19954);
        CharSequence charSequence = bo.isNullOrNil(this.lyF) ? this.lst : this.lyF;
        if (bo.isNullOrNil(this.lAG)) {
            deviceProfileHeaderPreference.setName(charSequence);
            deviceProfileHeaderPreference.Ky("");
            deviceProfileHeaderPreference.Q(3, false);
            deviceProfileHeaderPreference.Q(4, false);
            deviceProfileHeaderPreference.Q(1, this.lAH);
        } else {
            deviceProfileHeaderPreference.setName(this.lAG);
            deviceProfileHeaderPreference.Ky(getString(R.string.bg7, new Object[]{charSequence}));
            deviceProfileHeaderPreference.Q(3, true);
            deviceProfileHeaderPreference.Q(4, true);
            deviceProfileHeaderPreference.Q(1, false);
        }
        deviceProfileHeaderPreference.jo(this.lya);
        AppMethodBeat.o(19954);
    }

    public final int JC() {
        return R.xml.an;
    }

    public final boolean a(com.tencent.mm.ui.base.preference.f fVar, Preference preference) {
        AppMethodBeat.i(19955);
        ab.d("MicroMsg.ExdeviceDeviceProfileUI", "onPreferenceTreeClcik.(key : %s)", preference.mKey);
        String str;
        final m mVar;
        if ("bind_device".equals(preference.mKey)) {
            if (bo.isNullOrNil(this.lyG)) {
                ab.i("MicroMsg.ExdeviceDeviceProfileUI", "Do unauth bind device.");
                m mVar2 = new com.tencent.mm.plugin.exdevice.model.m(com.tencent.mm.plugin.exdevice.j.b.KK(this.cbq), this.lst, TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL, this.ltD);
                k(mVar2);
                aw.Rg().a(1262, (f) this);
                aw.Rg().a(mVar2, 0);
            } else {
                ab.i("MicroMsg.ExdeviceDeviceProfileUI", "Do normal bind device.");
                str = this.lyG;
                int i = this.lzD;
                aw.Rg().a(536, (f) this);
                dc dcVar = new dc();
                dcVar.cwj.cwl = str;
                dcVar.cwj.opType = 1;
                dcVar.cwj.cwm = i;
                a.xxA.m(dcVar);
                mVar = dcVar.cwk.cwn;
                getString(R.string.tz);
                this.lzK = h.b((Context) this, getString(R.string.bf3), true, new OnCancelListener() {
                    public final void onCancel(DialogInterface dialogInterface) {
                        AppMethodBeat.i(19947);
                        aw.Rg().b(536, ExdeviceDeviceProfileUI.this);
                        dc dcVar = new dc();
                        dcVar.cwj.opType = 2;
                        dcVar.cwj.cwn = mVar;
                        a.xxA.m(dcVar);
                        AppMethodBeat.o(19947);
                    }
                });
            }
        } else if ("unbind_device".equals(preference.mKey)) {
            asq asq = new asq();
            asq.jBE = this.lsu;
            asq.vIk = this.lxI;
            com.tencent.mm.plugin.exdevice.h.b dS = ad.boW().dS(this.lsu, this.lxI);
            if (dS != null) {
                str = dS.dFu;
                if (str != null && str.length() > 0) {
                    String[] split = str.split(",");
                    for (String dU : split) {
                        ad.boW().dU(dU, this.lxI);
                    }
                }
            }
            mVar = new x(asq, 2);
            k(mVar);
            aw.Rg().a(537, (f) this);
            aw.Rg().a(mVar, 0);
        } else if ("open_device_panel".equals(preference.mKey)) {
            com.tencent.mm.plugin.exdevice.model.f.ao(this.mController.ylL, this.lAF);
        } else if ("contact_info_biz_go_chatting".equals(preference.mKey)) {
            aw.ZK();
            com.tencent.mm.storage.ad aoO = c.XM().aoO(this.lst);
            Intent intent = new Intent();
            intent.putExtra("device_id", this.lsu);
            intent.putExtra("device_type", this.lxI);
            intent.putExtra("KIsHardDevice", true);
            intent.putExtra("KHardDeviceBindTicket", this.lyG);
            if (aoO != null) {
                if (com.tencent.mm.n.a.jh(aoO.field_type) && aoO.dsf()) {
                    z.aeR().qP(aoO.field_username);
                    intent.putExtra("Chat_User", this.lst);
                    intent.putExtra("finish_direct", true);
                    com.tencent.mm.plugin.exdevice.a.lqt.d(intent, this.mController.ylL);
                } else {
                    intent.putExtra("Contact_User", this.lst);
                    intent.putExtra("force_get_contact", true);
                    d.b(this.mController.ylL, Scopes.PROFILE, ".ui.ContactInfoUI", intent);
                }
            }
        } else if (!("message_manage".equals(preference.mKey) || "connect_setting".equals(preference.mKey) || "user_list".equals(preference.mKey))) {
            AppMethodBeat.o(19955);
            return false;
        }
        AppMethodBeat.o(19955);
        return true;
    }

    public void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(19956);
        ab.d("MicroMsg.ExdeviceDeviceProfileUI", "onSceneEnd errType = %d, errCode = %d ,errMsg = %s", Integer.valueOf(i), Integer.valueOf(i2), str);
        if (mVar == null) {
            ab.e("MicroMsg.ExdeviceDeviceProfileUI", "scene is null.");
            AppMethodBeat.o(19956);
            return;
        }
        ab.d("MicroMsg.ExdeviceDeviceProfileUI", "type = %s", Integer.valueOf(mVar.getType()));
        com.tencent.mm.plugin.exdevice.h.b id;
        if (mVar instanceof l) {
            bpD();
            aw.Rg().b(mVar.getType(), (f) this);
            if (i == 0 && i2 == 0) {
                bpK();
                f(ad.boW().dS(this.lsu, this.lxI));
                runOnUiThread(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(19948);
                        ExdeviceDeviceProfileUI.this.lAH = true;
                        ExdeviceDeviceProfileUI.f(ExdeviceDeviceProfileUI.this);
                        ExdeviceDeviceProfileUI.this.yCw.notifyDataSetChanged();
                        AppMethodBeat.o(19948);
                    }
                });
                AppMethodBeat.o(19956);
                return;
            }
            ab.e("MicroMsg.ExdeviceDeviceProfileUI", "onSceneEnd error(%d, %d, %s).(type : %d)", Integer.valueOf(i2), Integer.valueOf(i), str, Integer.valueOf(mVar.getType()));
            bpJ();
            AppMethodBeat.o(19956);
        } else if (mVar instanceof com.tencent.mm.plugin.exdevice.model.m) {
            bpD();
            aw.Rg().b(mVar.getType(), (f) this);
            id = ad.boW().id(com.tencent.mm.plugin.exdevice.j.b.KK(this.cbq));
            if (i == 0 && i2 == 0 && id != null) {
                f(id);
                runOnUiThread(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(19949);
                        ExdeviceDeviceProfileUI.this.lAH = true;
                        ExdeviceDeviceProfileUI.f(ExdeviceDeviceProfileUI.this);
                        ExdeviceDeviceProfileUI.this.yCw.notifyDataSetChanged();
                        AppMethodBeat.o(19949);
                    }
                });
                bpK();
                AppMethodBeat.o(19956);
                return;
            }
            ab.e("MicroMsg.ExdeviceDeviceProfileUI", "onSceneEnd error(%d, %d, %s).(type : %d)", Integer.valueOf(i2), Integer.valueOf(i), str, Integer.valueOf(mVar.getType()));
            bpJ();
            AppMethodBeat.o(19956);
        } else if (mVar instanceof y) {
            bpD();
            aw.Rg().b(1263, (f) this);
            if (i == 0 && i2 == 0) {
                this.lAG = ((y) mVar).dFl;
                runOnUiThread(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(19950);
                        ExdeviceDeviceProfileUI.a(ExdeviceDeviceProfileUI.this, (DeviceProfileHeaderPreference) ExdeviceDeviceProfileUI.this.yCw.aqO("device_profile_header"));
                        AppMethodBeat.o(19950);
                    }
                });
                id = ad.boW().dS(this.lsu, this.lxI);
                if (id == null) {
                    ab.i("MicroMsg.ExdeviceDeviceProfileUI", "hard device info is null.(deviceId:%s, deviceType:%s)", this.lsu, this.lxI);
                    AppMethodBeat.o(19956);
                    return;
                }
                id.iy(this.lAG);
                ad.boW().c(id, new String[0]);
                AppMethodBeat.o(19956);
                return;
            }
            ab.e("MicroMsg.ExdeviceDeviceProfileUI", "onSceneEnd error(%d, %d, %s).(type : %d)", Integer.valueOf(i2), Integer.valueOf(i), str, Integer.valueOf(mVar.getType()));
            Toast.makeText(this.mController.ylL, getString(R.string.bgb), 1).show();
            AppMethodBeat.o(19956);
        } else {
            if (mVar instanceof x) {
                bpD();
                if (i == 0 && i2 == 0) {
                    runOnUiThread(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(19951);
                            ExdeviceDeviceProfileUI.this.lAG = null;
                            ExdeviceDeviceProfileUI.this.lAH = false;
                            ExdeviceDeviceProfileUI.f(ExdeviceDeviceProfileUI.this);
                            ExdeviceDeviceProfileUI.this.yCw.notifyDataSetChanged();
                            AppMethodBeat.o(19951);
                        }
                    });
                    finish();
                } else {
                    ab.e("MicroMsg.ExdeviceDeviceProfileUI", "onSceneEnd, unbind failed (%d, %d, %s).(type : %d)", Integer.valueOf(i2), Integer.valueOf(i), str, Integer.valueOf(mVar.getType()));
                    runOnUiThread(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(19942);
                            Toast.makeText(ExdeviceDeviceProfileUI.this.mController.ylL, R.string.bie, 1).show();
                            AppMethodBeat.o(19942);
                        }
                    });
                    AppMethodBeat.o(19956);
                    return;
                }
            }
            AppMethodBeat.o(19956);
        }
    }

    public void onDestroy() {
        AppMethodBeat.i(19957);
        aw.Rg().b(537, (f) this);
        super.onDestroy();
        AppMethodBeat.o(19957);
    }

    private void f(com.tencent.mm.plugin.exdevice.h.b bVar) {
        AppMethodBeat.i(19958);
        if (bVar != null) {
            this.lsu = bVar.field_deviceID;
            this.lxI = bVar.field_deviceType;
            this.lAG = bo.nullAsNil(bVar.dFl);
            this.lyF = bo.nullAsNil(bVar.dFm);
            this.lst = bo.nullAsNil(bVar.field_brandName);
            this.lya = bo.nullAsNil(bVar.dFn);
            this.lAI = bo.nullAsNil(bVar.iconUrl);
            this.lAF = bo.nullAsNil(bVar.jumpUrl);
        }
        AppMethodBeat.o(19958);
    }

    private void bpD() {
        AppMethodBeat.i(19959);
        runOnUiThread(new Runnable() {
            public final void run() {
                AppMethodBeat.i(19935);
                if (ExdeviceDeviceProfileUI.this.ejZ != null && ExdeviceDeviceProfileUI.this.ejZ.isShowing()) {
                    ExdeviceDeviceProfileUI.this.ejZ.dismiss();
                }
                if (ExdeviceDeviceProfileUI.this.lzK != null && ExdeviceDeviceProfileUI.this.lzK.isShowing()) {
                    ExdeviceDeviceProfileUI.this.lzK.dismiss();
                }
                AppMethodBeat.o(19935);
            }
        });
        AppMethodBeat.o(19959);
    }

    private void bpJ() {
        AppMethodBeat.i(19960);
        runOnUiThread(new Runnable() {
            public final void run() {
                AppMethodBeat.i(19936);
                h.b(ExdeviceDeviceProfileUI.this, ExdeviceDeviceProfileUI.this.getString(R.string.bes), ExdeviceDeviceProfileUI.this.getString(R.string.tz), true);
                AppMethodBeat.o(19936);
            }
        });
        AppMethodBeat.o(19960);
    }

    private void bpK() {
        AppMethodBeat.i(19961);
        runOnUiThread(new Runnable() {
            public final void run() {
                AppMethodBeat.i(19939);
                Context context = ExdeviceDeviceProfileUI.this;
                ExdeviceDeviceProfileUI.this.getString(R.string.tz);
                final p b = h.b(context, ExdeviceDeviceProfileUI.this.getString(R.string.bf6), false, null);
                new ap(new ap.a() {
                    public final boolean BI() {
                        AppMethodBeat.i(19938);
                        ExdeviceDeviceProfileUI.this.runOnUiThread(new Runnable() {
                            public final void run() {
                                AppMethodBeat.i(19937);
                                b.dismiss();
                                AppMethodBeat.o(19937);
                            }
                        });
                        AppMethodBeat.o(19938);
                        return true;
                    }
                }, false).ae(1000, 1000);
                AppMethodBeat.o(19939);
            }
        });
        AppMethodBeat.o(19961);
    }

    private void k(final m mVar) {
        AppMethodBeat.i(19962);
        runOnUiThread(new Runnable() {
            public final void run() {
                AppMethodBeat.i(19941);
                ExdeviceDeviceProfileUI.this.ejZ = h.b(ExdeviceDeviceProfileUI.this.mController.ylL, ExdeviceDeviceProfileUI.this.getString(R.string.un), true, new OnCancelListener() {
                    public final void onCancel(DialogInterface dialogInterface) {
                        AppMethodBeat.i(19940);
                        aw.Rg().c(mVar);
                        AppMethodBeat.o(19940);
                    }
                });
                AppMethodBeat.o(19941);
            }
        });
        AppMethodBeat.o(19962);
    }

    private void bcb() {
        String str;
        boolean z;
        com.tencent.mm.ui.base.preference.f fVar;
        AppMethodBeat.i(19953);
        com.tencent.mm.ui.base.preference.h hVar = this.yCw;
        DeviceProfileHeaderPreference deviceProfileHeaderPreference = (DeviceProfileHeaderPreference) hVar.aqO("device_profile_header");
        deviceProfileHeaderPreference.a(1, new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(19945);
                h.a(ExdeviceDeviceProfileUI.this, ExdeviceDeviceProfileUI.this.getString(R.string.bgd), "", "", 50, ExdeviceDeviceProfileUI.this.lAL);
                AppMethodBeat.o(19945);
            }
        });
        deviceProfileHeaderPreference.a(4, new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(19946);
                h.a(ExdeviceDeviceProfileUI.this, ExdeviceDeviceProfileUI.this.getString(R.string.bgd), ExdeviceDeviceProfileUI.this.lAG, "", 50, ExdeviceDeviceProfileUI.this.lAL);
                AppMethodBeat.o(19946);
            }
        });
        a(deviceProfileHeaderPreference);
        deviceProfileHeaderPreference.jl(this.lAI);
        KeyValuePreference keyValuePreference = (KeyValuePreference) hVar.aqO("connect_setting");
        KeyValuePreference keyValuePreference2 = (KeyValuePreference) hVar.aqO("user_list");
        ((KeyValuePreference) hVar.aqO("message_manage")).qi(true);
        keyValuePreference.qi(true);
        keyValuePreference2.qi(true);
        hVar.ce("message_manage", true);
        hVar.ce("connect_setting", true);
        hVar.ce("user_list", true);
        if (this.lAJ) {
            hVar.ce("sub_device_desc", false);
            hVar.aqO("sub_device_desc").setTitle(getResources().getString(R.string.bib, new Object[]{this.lAK}));
            hVar.ce("bind_device", true);
            str = "unbind_device";
            z = true;
            fVar = hVar;
        } else {
            hVar.ce("sub_device_desc", true);
            hVar.ce("bind_device", this.lAH);
            str = "unbind_device";
            Object fVar2;
            if (this.lAH) {
                z = false;
                fVar2 = hVar;
            } else {
                z = true;
                fVar2 = hVar;
            }
        }
        fVar2.ce(str, z);
        if (bo.isNullOrNil(this.lAF)) {
            hVar.ce("open_device_panel", true);
        }
        AppMethodBeat.o(19953);
    }
}
