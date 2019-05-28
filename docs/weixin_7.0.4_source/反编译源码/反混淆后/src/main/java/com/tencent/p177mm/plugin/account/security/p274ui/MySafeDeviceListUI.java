package com.tencent.p177mm.plugin.account.security.p274ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import android.os.Message;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C30379h.C30387b;
import com.tencent.p177mm.p612ui.base.preference.C15541f;
import com.tencent.p177mm.p612ui.base.preference.MMPreference;
import com.tencent.p177mm.p612ui.base.preference.Preference;
import com.tencent.p177mm.plugin.account.p765a.C24679a;
import com.tencent.p177mm.plugin.account.security.p274ui.SafeDeviceListPreference.C26608b;
import com.tencent.p177mm.plugin.account.security.p274ui.SafeDeviceListPreference.C9910a;
import com.tencent.p177mm.plugin.account.security.p880a.C18846b;
import com.tencent.p177mm.plugin.account.security.p880a.C18847c;
import com.tencent.p177mm.plugin.account.security.p880a.C18848d;
import com.tencent.p177mm.plugin.account.security.p880a.C45501g;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.protocal.protobuf.aza;
import com.tencent.p177mm.sdk.p603e.C4935m;
import com.tencent.p177mm.sdk.p603e.C7296k.C4931a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.account.security.ui.MySafeDeviceListUI */
public class MySafeDeviceListUI extends MMPreference implements C1202f, C4931a {
    private ProgressDialog ehJ = null;
    private C15541f ehK;
    private List<C18848d> gzA;
    private OnMenuItemClickListener gzB = new C188601();
    private int gzx = -2;
    private List<SafeDeviceListPreference> gzy;
    private C18858a gzz;
    private C7306ak handler = new C188623();

    /* renamed from: com.tencent.mm.plugin.account.security.ui.MySafeDeviceListUI$5 */
    class C188565 implements OnMenuItemClickListener {
        C188565() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(69877);
            MySafeDeviceListUI.this.finish();
            AppMethodBeat.m2505o(69877);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.security.ui.MySafeDeviceListUI$6 */
    class C188576 implements Runnable {
        C188576() {
        }

        public final void run() {
            AppMethodBeat.m2504i(69878);
            MySafeDeviceListUI.m29460g(MySafeDeviceListUI.this);
            AppMethodBeat.m2505o(69878);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.security.ui.MySafeDeviceListUI$a */
    class C18858a implements C9910a, C26608b {
        private C18858a() {
        }

        /* synthetic */ C18858a(MySafeDeviceListUI mySafeDeviceListUI, byte b) {
            this();
        }

        /* renamed from: wq */
        public final void mo34130wq(String str) {
            AppMethodBeat.m2504i(69879);
            MySafeDeviceListUI.this.ehK.aqP(str);
            MySafeDeviceListUI.this.handler.sendEmptyMessage(0);
            MySafeDeviceListUI.this.addTextOptionMenu(0, MySafeDeviceListUI.this.getString(C25738R.string.dw_), MySafeDeviceListUI.this.gzB);
            MySafeDeviceListUI.this.gzx = MySafeDeviceListUI.this.gzx ^ -1;
            MySafeDeviceListUI.m29460g(MySafeDeviceListUI.this);
            AppMethodBeat.m2505o(69879);
        }

        public final void onFailed(String str) {
            AppMethodBeat.m2504i(69880);
            C4990ab.m7412e("MicroMsg.MySafeDeviceListUI", "delete safedevice failed".concat(String.valueOf(str)));
            AppMethodBeat.m2505o(69880);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.security.ui.MySafeDeviceListUI$1 */
    class C188601 implements OnMenuItemClickListener {
        C188601() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(69872);
            MySafeDeviceListUI.m29454a(MySafeDeviceListUI.this);
            AppMethodBeat.m2505o(69872);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.security.ui.MySafeDeviceListUI$3 */
    class C188623 extends C7306ak {
        C188623() {
        }

        public final void handleMessage(Message message) {
            AppMethodBeat.m2504i(69874);
            MySafeDeviceListUI.this.ehK.notifyDataSetChanged();
            super.handleMessage(message);
            AppMethodBeat.m2505o(69874);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public MySafeDeviceListUI() {
        AppMethodBeat.m2504i(69881);
        AppMethodBeat.m2505o(69881);
    }

    /* renamed from: g */
    static /* synthetic */ void m29460g(MySafeDeviceListUI mySafeDeviceListUI) {
        AppMethodBeat.m2504i(69891);
        mySafeDeviceListUI.aqI();
        AppMethodBeat.m2505o(69891);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(69882);
        super.onCreate(bundle);
        C1720g.m3540Rg().mo14539a(850, (C1202f) this);
        C1720g.m3540Rg().mo14539a(361, (C1202f) this);
        C45501g.aqG().mo10116c(this);
        initView();
        final C1207m c18846b = new C18846b();
        C1720g.m3540Rg().mo14541a(c18846b, 0);
        getString(C25738R.string.f9238tz);
        this.ehJ = C30379h.m48458b((Context) this, getString(C25738R.string.f9260un), true, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.m2504i(69873);
                C1720g.m3540Rg().mo14547c(c18846b);
                AppMethodBeat.m2505o(69873);
            }
        });
        AppMethodBeat.m2505o(69882);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(69883);
        super.onDestroy();
        C1720g.m3540Rg().mo14546b(850, (C1202f) this);
        C1720g.m3540Rg().mo14546b(361, (C1202f) this);
        C45501g.aqG().mo10117d(this);
        AppMethodBeat.m2505o(69883);
    }

    public void onResume() {
        AppMethodBeat.m2504i(69884);
        super.onResume();
        aqI();
        AppMethodBeat.m2505o(69884);
    }

    /* renamed from: JC */
    public final int mo8452JC() {
        return -1;
    }

    public final void initView() {
        AppMethodBeat.m2504i(69886);
        setBackBtn(new C188565());
        this.ehK = this.yCw;
        this.gzy = new LinkedList();
        this.gzz = new C18858a(this, (byte) 0);
        addTextOptionMenu(0, getString(C25738R.string.dw_), this.gzB);
        setMMTitle((int) C25738R.string.e87);
        AppMethodBeat.m2505o(69886);
    }

    private void aqI() {
        AppMethodBeat.m2504i(69887);
        this.gzy.clear();
        this.gzA = C45501g.aqG().aqD();
        this.ehK.removeAll();
        this.ehK.addPreferencesFromResource(C25738R.xml.f8534bi);
        if (this.gzA.size() == 0) {
            this.ehK.aqP("my_safe_device_list_tip");
            showOptionMenu(false);
            AppMethodBeat.m2505o(69887);
            return;
        }
        if (this.gzx == 1) {
            addTextOptionMenu(0, getString(C25738R.string.dw_), this.gzB);
            this.gzx ^= -1;
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yy-MM-dd HH:mm:ss");
        for (C18848d c18848d : this.gzA) {
            SafeDeviceListPreference safeDeviceListPreference = new SafeDeviceListPreference(this);
            safeDeviceListPreference.setKey("mysafedevice_" + c18848d.field_uid);
            safeDeviceListPreference.setTitle((CharSequence) C44089j.m79292b((Context) this, c18848d.field_name));
            safeDeviceListPreference.setSummary((CharSequence) simpleDateFormat.format(new Date(c18848d.field_createtime * 1000)));
            safeDeviceListPreference.gzJ = this.gzz;
            safeDeviceListPreference.gzK = this.gzz;
            safeDeviceListPreference.gzG = c18848d;
            this.ehK.mo27708a(safeDeviceListPreference, -1);
            this.gzy.add(safeDeviceListPreference);
        }
        showOptionMenu(true);
        AppMethodBeat.m2505o(69887);
    }

    /* renamed from: a */
    public final void mo5248a(String str, C4935m c4935m) {
        AppMethodBeat.m2504i(69888);
        C4990ab.m7416i("MicroMsg.MySafeDeviceListUI", "notify ".concat(String.valueOf(str)));
        this.handler.post(new C188576());
        AppMethodBeat.m2505o(69888);
    }

    public void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        List list = null;
        AppMethodBeat.m2504i(69889);
        C4990ab.m7417i("MicroMsg.MySafeDeviceListUI", "errorCode %d, errorMsg %s, scene %s", Integer.valueOf(i2), str, c1207m);
        if (this.ehJ != null && this.ehJ.isShowing()) {
            this.ehJ.dismiss();
            this.ehJ = null;
        }
        if (c1207m.getType() == 850) {
            if (i == 0 && i2 == 0) {
                C18846b c18846b = (C18846b) c1207m;
                if (!(c18846b.gzh == null || c18846b.gzh.wsr == null || c18846b.gzh.wsr.wVM == null)) {
                    list = c18846b.gzh.wsr.wVM;
                }
                if (!(list == null || list == null)) {
                    C45501g.aqG().mo16768hY("SafeDeviceInfo", "delete from SafeDeviceInfo");
                    for (aza c18848d : list) {
                        C45501g.aqG().mo34121a(new C18848d(c18848d));
                    }
                }
                AppMethodBeat.m2505o(69889);
                return;
            }
        } else if (c1207m.getType() == 361) {
            if (i == 0 && i2 == 0) {
                C18847c c18847c = (C18847c) c1207m;
                C18848d c18848d2 = new C18848d();
                c18848d2.field_devicetype = c18847c.cws;
                c18848d2.field_name = c18847c.deviceName;
                c18848d2.field_uid = c18847c.ceI;
                c18848d2.field_createtime = 0;
                C45501g.aqG().mo10103c(c18848d2, new String[0]);
                C30379h.m48465bQ(this, C1338a.m2858an(this, C25738R.string.dwf));
                AppMethodBeat.m2505o(69889);
                return;
            } else if (C24679a.gkF.mo38859a((Context) this, i, i2, str)) {
                AppMethodBeat.m2505o(69889);
                return;
            }
        }
        AppMethodBeat.m2505o(69889);
    }

    /* renamed from: a */
    public final boolean mo8453a(C15541f c15541f, Preference preference) {
        AppMethodBeat.m2504i(69885);
        String str = preference.mKey;
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7412e("MicroMsg.MySafeDeviceListUI", "null key");
            AppMethodBeat.m2505o(69885);
            return false;
        }
        if (str.startsWith("mysafedevice_")) {
            SafeDeviceListPreference safeDeviceListPreference = (SafeDeviceListPreference) preference;
            if (safeDeviceListPreference != null) {
                final C18848d c18848d = safeDeviceListPreference.gzG;
                C30379h.m48442a(this.mController.ylL, getString(C25738R.string.dwb), c18848d.field_name, getString(C25738R.string.dwe), -1, new C30387b() {
                    /* renamed from: s */
                    public final boolean mo4760s(CharSequence charSequence) {
                        AppMethodBeat.m2504i(69876);
                        String trim = charSequence == null ? "" : charSequence.toString().trim();
                        if (trim.equals(c18848d.field_name)) {
                            AppMethodBeat.m2505o(69876);
                            return true;
                        } else if (trim.length() <= 0) {
                            C30379h.m48465bQ(MySafeDeviceListUI.this.mController.ylL, MySafeDeviceListUI.this.getString(C25738R.string.dwa));
                            AppMethodBeat.m2505o(69876);
                            return false;
                        } else {
                            final C1207m c18847c = new C18847c(c18848d.field_uid, trim, c18848d.field_devicetype);
                            C1720g.m3540Rg().mo14541a(c18847c, 0);
                            if (MySafeDeviceListUI.this.ehJ != null) {
                                MySafeDeviceListUI.this.ehJ.dismiss();
                            }
                            MySafeDeviceListUI.this.ehJ = C30379h.m48458b(MySafeDeviceListUI.this, C1338a.m2858an(MySafeDeviceListUI.this, C25738R.string.f9260un), true, new OnCancelListener() {
                                public final void onCancel(DialogInterface dialogInterface) {
                                    AppMethodBeat.m2504i(69875);
                                    C1720g.m3540Rg().mo14547c(c18847c);
                                    AppMethodBeat.m2505o(69875);
                                }
                            });
                            AppMethodBeat.m2505o(69876);
                            return true;
                        }
                    }
                });
            }
        }
        AppMethodBeat.m2505o(69885);
        return true;
    }

    /* renamed from: a */
    static /* synthetic */ void m29454a(MySafeDeviceListUI mySafeDeviceListUI) {
        AppMethodBeat.m2504i(69890);
        if (mySafeDeviceListUI.gzy != null && mySafeDeviceListUI.gzy.size() > 0) {
            mySafeDeviceListUI.gzx ^= -1;
            for (SafeDeviceListPreference safeDeviceListPreference : mySafeDeviceListUI.gzy) {
                safeDeviceListPreference.mode = mySafeDeviceListUI.gzx;
                safeDeviceListPreference.initView();
            }
            mySafeDeviceListUI.ehK.notifyDataSetChanged();
        }
        if (mySafeDeviceListUI.gzx == 1) {
            mySafeDeviceListUI.addTextOptionMenu(0, mySafeDeviceListUI.getString(C25738R.string.f9142qt), mySafeDeviceListUI.gzB);
            AppMethodBeat.m2505o(69890);
            return;
        }
        mySafeDeviceListUI.addTextOptionMenu(0, mySafeDeviceListUI.getString(C25738R.string.dw_), mySafeDeviceListUI.gzB);
        AppMethodBeat.m2505o(69890);
    }
}
