package com.tencent.mm.plugin.account.security.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import android.os.Message;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.security.a.c;
import com.tencent.mm.plugin.account.security.a.d;
import com.tencent.mm.plugin.account.security.ui.SafeDeviceListPreference.b;
import com.tencent.mm.pluginsdk.ui.e.j;
import com.tencent.mm.protocal.protobuf.aza;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class MySafeDeviceListUI extends MMPreference implements f, com.tencent.mm.sdk.e.k.a {
    private ProgressDialog ehJ = null;
    private com.tencent.mm.ui.base.preference.f ehK;
    private List<d> gzA;
    private OnMenuItemClickListener gzB = new OnMenuItemClickListener() {
        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.i(69872);
            MySafeDeviceListUI.a(MySafeDeviceListUI.this);
            AppMethodBeat.o(69872);
            return true;
        }
    };
    private int gzx = -2;
    private List<SafeDeviceListPreference> gzy;
    private a gzz;
    private ak handler = new ak() {
        public final void handleMessage(Message message) {
            AppMethodBeat.i(69874);
            MySafeDeviceListUI.this.ehK.notifyDataSetChanged();
            super.handleMessage(message);
            AppMethodBeat.o(69874);
        }
    };

    class a implements com.tencent.mm.plugin.account.security.ui.SafeDeviceListPreference.a, b {
        private a() {
        }

        /* synthetic */ a(MySafeDeviceListUI mySafeDeviceListUI, byte b) {
            this();
        }

        public final void wq(String str) {
            AppMethodBeat.i(69879);
            MySafeDeviceListUI.this.ehK.aqP(str);
            MySafeDeviceListUI.this.handler.sendEmptyMessage(0);
            MySafeDeviceListUI.this.addTextOptionMenu(0, MySafeDeviceListUI.this.getString(R.string.dw_), MySafeDeviceListUI.this.gzB);
            MySafeDeviceListUI.this.gzx = MySafeDeviceListUI.this.gzx ^ -1;
            MySafeDeviceListUI.g(MySafeDeviceListUI.this);
            AppMethodBeat.o(69879);
        }

        public final void onFailed(String str) {
            AppMethodBeat.i(69880);
            ab.e("MicroMsg.MySafeDeviceListUI", "delete safedevice failed".concat(String.valueOf(str)));
            AppMethodBeat.o(69880);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public MySafeDeviceListUI() {
        AppMethodBeat.i(69881);
        AppMethodBeat.o(69881);
    }

    static /* synthetic */ void g(MySafeDeviceListUI mySafeDeviceListUI) {
        AppMethodBeat.i(69891);
        mySafeDeviceListUI.aqI();
        AppMethodBeat.o(69891);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(69882);
        super.onCreate(bundle);
        g.Rg().a(850, (f) this);
        g.Rg().a(361, (f) this);
        com.tencent.mm.plugin.account.security.a.g.aqG().c(this);
        initView();
        final m bVar = new com.tencent.mm.plugin.account.security.a.b();
        g.Rg().a(bVar, 0);
        getString(R.string.tz);
        this.ehJ = h.b((Context) this, getString(R.string.un), true, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(69873);
                g.Rg().c(bVar);
                AppMethodBeat.o(69873);
            }
        });
        AppMethodBeat.o(69882);
    }

    public void onDestroy() {
        AppMethodBeat.i(69883);
        super.onDestroy();
        g.Rg().b(850, (f) this);
        g.Rg().b(361, (f) this);
        com.tencent.mm.plugin.account.security.a.g.aqG().d(this);
        AppMethodBeat.o(69883);
    }

    public void onResume() {
        AppMethodBeat.i(69884);
        super.onResume();
        aqI();
        AppMethodBeat.o(69884);
    }

    public final int JC() {
        return -1;
    }

    public final void initView() {
        AppMethodBeat.i(69886);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(69877);
                MySafeDeviceListUI.this.finish();
                AppMethodBeat.o(69877);
                return true;
            }
        });
        this.ehK = this.yCw;
        this.gzy = new LinkedList();
        this.gzz = new a(this, (byte) 0);
        addTextOptionMenu(0, getString(R.string.dw_), this.gzB);
        setMMTitle((int) R.string.e87);
        AppMethodBeat.o(69886);
    }

    private void aqI() {
        AppMethodBeat.i(69887);
        this.gzy.clear();
        this.gzA = com.tencent.mm.plugin.account.security.a.g.aqG().aqD();
        this.ehK.removeAll();
        this.ehK.addPreferencesFromResource(R.xml.bi);
        if (this.gzA.size() == 0) {
            this.ehK.aqP("my_safe_device_list_tip");
            showOptionMenu(false);
            AppMethodBeat.o(69887);
            return;
        }
        if (this.gzx == 1) {
            addTextOptionMenu(0, getString(R.string.dw_), this.gzB);
            this.gzx ^= -1;
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yy-MM-dd HH:mm:ss");
        for (d dVar : this.gzA) {
            SafeDeviceListPreference safeDeviceListPreference = new SafeDeviceListPreference(this);
            safeDeviceListPreference.setKey("mysafedevice_" + dVar.field_uid);
            safeDeviceListPreference.setTitle((CharSequence) j.b((Context) this, dVar.field_name));
            safeDeviceListPreference.setSummary((CharSequence) simpleDateFormat.format(new Date(dVar.field_createtime * 1000)));
            safeDeviceListPreference.gzJ = this.gzz;
            safeDeviceListPreference.gzK = this.gzz;
            safeDeviceListPreference.gzG = dVar;
            this.ehK.a(safeDeviceListPreference, -1);
            this.gzy.add(safeDeviceListPreference);
        }
        showOptionMenu(true);
        AppMethodBeat.o(69887);
    }

    public final void a(String str, com.tencent.mm.sdk.e.m mVar) {
        AppMethodBeat.i(69888);
        ab.i("MicroMsg.MySafeDeviceListUI", "notify ".concat(String.valueOf(str)));
        this.handler.post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(69878);
                MySafeDeviceListUI.g(MySafeDeviceListUI.this);
                AppMethodBeat.o(69878);
            }
        });
        AppMethodBeat.o(69888);
    }

    public void onSceneEnd(int i, int i2, String str, m mVar) {
        List list = null;
        AppMethodBeat.i(69889);
        ab.i("MicroMsg.MySafeDeviceListUI", "errorCode %d, errorMsg %s, scene %s", Integer.valueOf(i2), str, mVar);
        if (this.ehJ != null && this.ehJ.isShowing()) {
            this.ehJ.dismiss();
            this.ehJ = null;
        }
        if (mVar.getType() == 850) {
            if (i == 0 && i2 == 0) {
                com.tencent.mm.plugin.account.security.a.b bVar = (com.tencent.mm.plugin.account.security.a.b) mVar;
                if (!(bVar.gzh == null || bVar.gzh.wsr == null || bVar.gzh.wsr.wVM == null)) {
                    list = bVar.gzh.wsr.wVM;
                }
                if (!(list == null || list == null)) {
                    com.tencent.mm.plugin.account.security.a.g.aqG().hY("SafeDeviceInfo", "delete from SafeDeviceInfo");
                    for (aza dVar : list) {
                        com.tencent.mm.plugin.account.security.a.g.aqG().a(new d(dVar));
                    }
                }
                AppMethodBeat.o(69889);
                return;
            }
        } else if (mVar.getType() == 361) {
            if (i == 0 && i2 == 0) {
                c cVar = (c) mVar;
                d dVar2 = new d();
                dVar2.field_devicetype = cVar.cws;
                dVar2.field_name = cVar.deviceName;
                dVar2.field_uid = cVar.ceI;
                dVar2.field_createtime = 0;
                com.tencent.mm.plugin.account.security.a.g.aqG().c(dVar2, new String[0]);
                h.bQ(this, com.tencent.mm.bz.a.an(this, R.string.dwf));
                AppMethodBeat.o(69889);
                return;
            } else if (com.tencent.mm.plugin.account.a.a.gkF.a((Context) this, i, i2, str)) {
                AppMethodBeat.o(69889);
                return;
            }
        }
        AppMethodBeat.o(69889);
    }

    public final boolean a(com.tencent.mm.ui.base.preference.f fVar, Preference preference) {
        AppMethodBeat.i(69885);
        String str = preference.mKey;
        if (bo.isNullOrNil(str)) {
            ab.e("MicroMsg.MySafeDeviceListUI", "null key");
            AppMethodBeat.o(69885);
            return false;
        }
        if (str.startsWith("mysafedevice_")) {
            SafeDeviceListPreference safeDeviceListPreference = (SafeDeviceListPreference) preference;
            if (safeDeviceListPreference != null) {
                final d dVar = safeDeviceListPreference.gzG;
                h.a(this.mController.ylL, getString(R.string.dwb), dVar.field_name, getString(R.string.dwe), -1, new h.b() {
                    public final boolean s(CharSequence charSequence) {
                        AppMethodBeat.i(69876);
                        String trim = charSequence == null ? "" : charSequence.toString().trim();
                        if (trim.equals(dVar.field_name)) {
                            AppMethodBeat.o(69876);
                            return true;
                        } else if (trim.length() <= 0) {
                            h.bQ(MySafeDeviceListUI.this.mController.ylL, MySafeDeviceListUI.this.getString(R.string.dwa));
                            AppMethodBeat.o(69876);
                            return false;
                        } else {
                            final m cVar = new c(dVar.field_uid, trim, dVar.field_devicetype);
                            g.Rg().a(cVar, 0);
                            if (MySafeDeviceListUI.this.ehJ != null) {
                                MySafeDeviceListUI.this.ehJ.dismiss();
                            }
                            MySafeDeviceListUI.this.ehJ = h.b(MySafeDeviceListUI.this, com.tencent.mm.bz.a.an(MySafeDeviceListUI.this, R.string.un), true, new OnCancelListener() {
                                public final void onCancel(DialogInterface dialogInterface) {
                                    AppMethodBeat.i(69875);
                                    g.Rg().c(cVar);
                                    AppMethodBeat.o(69875);
                                }
                            });
                            AppMethodBeat.o(69876);
                            return true;
                        }
                    }
                });
            }
        }
        AppMethodBeat.o(69885);
        return true;
    }

    static /* synthetic */ void a(MySafeDeviceListUI mySafeDeviceListUI) {
        AppMethodBeat.i(69890);
        if (mySafeDeviceListUI.gzy != null && mySafeDeviceListUI.gzy.size() > 0) {
            mySafeDeviceListUI.gzx ^= -1;
            for (SafeDeviceListPreference safeDeviceListPreference : mySafeDeviceListUI.gzy) {
                safeDeviceListPreference.mode = mySafeDeviceListUI.gzx;
                safeDeviceListPreference.initView();
            }
            mySafeDeviceListUI.ehK.notifyDataSetChanged();
        }
        if (mySafeDeviceListUI.gzx == 1) {
            mySafeDeviceListUI.addTextOptionMenu(0, mySafeDeviceListUI.getString(R.string.qt), mySafeDeviceListUI.gzB);
            AppMethodBeat.o(69890);
            return;
        }
        mySafeDeviceListUI.addTextOptionMenu(0, mySafeDeviceListUI.getString(R.string.dw_), mySafeDeviceListUI.gzB);
        AppMethodBeat.o(69890);
    }
}
