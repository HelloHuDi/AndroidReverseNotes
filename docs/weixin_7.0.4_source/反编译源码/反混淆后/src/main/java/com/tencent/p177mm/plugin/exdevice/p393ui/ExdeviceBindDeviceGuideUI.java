package com.tencent.p177mm.plugin.exdevice.p393ui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.location.LocationManager;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;
import com.google.firebase.analytics.FirebaseAnalytics.C8741b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.compatible.util.C1443d;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.p369d.p370a.p1606e.C42904a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5023at;
import java.util.ArrayList;
import junit.framework.Assert;

/* renamed from: com.tencent.mm.plugin.exdevice.ui.ExdeviceBindDeviceGuideUI */
public class ExdeviceBindDeviceGuideUI extends MMActivity implements C1202f {
    /* renamed from: Fd */
    private String f16169Fd;
    private Button gHn;
    BroadcastReceiver jIA = new C340554();
    private String kWC;
    private String lst;
    private String lsu;
    private String lxI;
    private ScrollView lyA;
    private ImageView lyB;
    private TextView lyC;
    private String lyD;
    private String lyE;
    private String lyF;
    private String lyG;
    private long lyH;
    private ArrayList<String> lyI;
    private String lyJ;
    private boolean lyK = false;
    private boolean lyL = false;
    private String lya;
    private TextView lyf;
    private LocationManager lyi;
    private boolean lyj = false;
    private C38974a lyx;
    private Button lyy;
    private TextView lyz;
    private ListView mListView;
    private String mTitle;

    /* renamed from: com.tencent.mm.plugin.exdevice.ui.ExdeviceBindDeviceGuideUI$1 */
    class C29911 implements OnMenuItemClickListener {
        C29911() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(19811);
            ExdeviceBindDeviceGuideUI.this.finish();
            AppMethodBeat.m2505o(19811);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.exdevice.ui.ExdeviceBindDeviceGuideUI$2 */
    class C29922 implements OnClickListener {
        C29922() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(19812);
            Intent intent = new Intent();
            intent.putExtra("device_scan_mode", ExdeviceBindDeviceGuideUI.this.lyD);
            intent.putExtra("device_scan_conn_proto", ExdeviceBindDeviceGuideUI.this.lyE);
            intent.putExtra("device_id", ExdeviceBindDeviceGuideUI.this.lsu);
            intent.putExtra("device_type", ExdeviceBindDeviceGuideUI.this.lxI);
            intent.putExtra("device_title", ExdeviceBindDeviceGuideUI.this.lyF);
            intent.putExtra("device_desc", ExdeviceBindDeviceGuideUI.this.lya);
            intent.putExtra("device_icon_url", ExdeviceBindDeviceGuideUI.this.kWC);
            intent.putExtra("device_category_id", ExdeviceBindDeviceGuideUI.this.f16169Fd);
            intent.putExtra("device_brand_name", ExdeviceBindDeviceGuideUI.this.lst);
            intent.putExtra("bind_ticket", ExdeviceBindDeviceGuideUI.this.lyG);
            intent.putExtra("device_ble_simple_proto", ExdeviceBindDeviceGuideUI.this.lyH);
            intent.putExtra("encryptKey", ExdeviceBindDeviceGuideUI.this.lyJ);
            intent.putExtra("jumpToBindDevice", true);
            if (!ExdeviceBindDeviceGuideUI.this.lyL || ExdeviceBindDeviceGuideUI.this.lyK) {
                if (ExdeviceBindDeviceGuideUI.this.lyK && !ExdeviceBindDeviceGuideUI.this.lyL) {
                    intent.putExtra("exdevice_airkiss_open_type", 2);
                    C25985d.m41467b(ExdeviceBindDeviceGuideUI.this.mController.ylL, "exdevice", ".ui.ExdeviceConnectWifiUI", intent);
                }
                AppMethodBeat.m2505o(19812);
                return;
            }
            C25985d.m41467b(ExdeviceBindDeviceGuideUI.this.mController.ylL, "exdevice", ".ui.ExdeviceBindDeviceUI", intent);
            AppMethodBeat.m2505o(19812);
        }
    }

    /* renamed from: com.tencent.mm.plugin.exdevice.ui.ExdeviceBindDeviceGuideUI$4 */
    class C340554 extends BroadcastReceiver {
        C340554() {
        }

        public final void onReceive(Context context, Intent intent) {
            AppMethodBeat.m2504i(19814);
            C4990ab.m7416i("MicroMsg.ExdeviceBindDeviceGuideUI", "Action broadcast receive...");
            if (intent == null) {
                AppMethodBeat.m2505o(19814);
                return;
            }
            String action = intent.getAction();
            C4990ab.m7411d("MicroMsg.ExdeviceBindDeviceGuideUI", "Receiver action(%s)", action);
            int intExtra;
            if ("android.bluetooth.adapter.action.STATE_CHANGED".equals(action) && ExdeviceBindDeviceGuideUI.this.lyL) {
                intExtra = intent.getIntExtra("android.bluetooth.adapter.extra.STATE", -1);
                if (intExtra != 12) {
                    if (intExtra == 10) {
                        ExdeviceBindDeviceGuideUI.m66189a(ExdeviceBindDeviceGuideUI.this, 3);
                    }
                    AppMethodBeat.m2505o(19814);
                    return;
                } else if (!ExdeviceBindDeviceGuideUI.this.lyj || ExdeviceBindDeviceGuideUI.this.lyi.isProviderEnabled("gps")) {
                    ExdeviceBindDeviceGuideUI.m66189a(ExdeviceBindDeviceGuideUI.this, 2);
                    AppMethodBeat.m2505o(19814);
                    return;
                }
            } else if ("android.net.wifi.WIFI_STATE_CHANGED".equals(action) && ExdeviceBindDeviceGuideUI.this.lyK) {
                intExtra = intent.getIntExtra("wifi_state", -1);
                C4990ab.m7417i("MicroMsg.ExdeviceBindDeviceGuideUI", "Wifi state changed action: wifiState(%d)", Integer.valueOf(intExtra));
                if (intExtra == 3) {
                    ExdeviceBindDeviceGuideUI.m66189a(ExdeviceBindDeviceGuideUI.this, 1);
                    AppMethodBeat.m2505o(19814);
                    return;
                }
                if (intExtra == 1) {
                    ExdeviceBindDeviceGuideUI.m66189a(ExdeviceBindDeviceGuideUI.this, 5);
                }
                AppMethodBeat.m2505o(19814);
                return;
            } else {
                if (ExdeviceBindDeviceGuideUI.this.lyj && "android.location.MODE_CHANGED".equals(action)) {
                    if (ExdeviceBindDeviceGuideUI.this.lyi.isProviderEnabled("gps")) {
                        if (C42904a.aVH()) {
                            ExdeviceBindDeviceGuideUI.m66189a(ExdeviceBindDeviceGuideUI.this, 2);
                            AppMethodBeat.m2505o(19814);
                            return;
                        }
                        ExdeviceBindDeviceGuideUI.m66189a(ExdeviceBindDeviceGuideUI.this, 3);
                        AppMethodBeat.m2505o(19814);
                        return;
                    }
                }
                AppMethodBeat.m2505o(19814);
            }
            ExdeviceBindDeviceGuideUI.m66189a(ExdeviceBindDeviceGuideUI.this, 6);
            AppMethodBeat.m2505o(19814);
        }
    }

    /* renamed from: com.tencent.mm.plugin.exdevice.ui.ExdeviceBindDeviceGuideUI$3 */
    class C389733 implements OnClickListener {
        C389733() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(19813);
            if (ExdeviceBindDeviceGuideUI.this.lyK && !ExdeviceBindDeviceGuideUI.this.lyL) {
                Intent intent = new Intent();
                intent.putExtra("device_scan_mode", ExdeviceBindDeviceGuideUI.this.lyD);
                intent.putExtra("device_scan_conn_proto", ExdeviceBindDeviceGuideUI.this.lyE);
                intent.putExtra("device_id", ExdeviceBindDeviceGuideUI.this.lsu);
                intent.putExtra("device_type", ExdeviceBindDeviceGuideUI.this.lxI);
                intent.putExtra("device_title", ExdeviceBindDeviceGuideUI.this.lyF);
                intent.putExtra("device_desc", ExdeviceBindDeviceGuideUI.this.lya);
                intent.putExtra("device_icon_url", ExdeviceBindDeviceGuideUI.this.kWC);
                intent.putExtra("device_category_id", ExdeviceBindDeviceGuideUI.this.f16169Fd);
                intent.putExtra("device_brand_name", ExdeviceBindDeviceGuideUI.this.lst);
                intent.putExtra("bind_ticket", ExdeviceBindDeviceGuideUI.this.lyG);
                C25985d.m41467b(ExdeviceBindDeviceGuideUI.this.mController.ylL, "exdevice", ".ui.ExdeviceBindDeviceUI", intent);
            }
            AppMethodBeat.m2505o(19813);
        }
    }

    /* renamed from: com.tencent.mm.plugin.exdevice.ui.ExdeviceBindDeviceGuideUI$a */
    static final class C38974a extends BaseAdapter {
        private ArrayList<String> lyN;

        /* renamed from: com.tencent.mm.plugin.exdevice.ui.ExdeviceBindDeviceGuideUI$a$a */
        static class C11667a {
            TextView lyO;
            TextView lyP;
            View lyQ;
            View lyR;

            private C11667a() {
            }

            /* synthetic */ C11667a(byte b) {
                this();
            }
        }

        public C38974a(ArrayList<String> arrayList) {
            this.lyN = arrayList;
        }

        public final int getCount() {
            AppMethodBeat.m2504i(19815);
            if (this.lyN != null) {
                int size = this.lyN.size();
                AppMethodBeat.m2505o(19815);
                return size;
            }
            AppMethodBeat.m2505o(19815);
            return 0;
        }

        private String getItem(int i) {
            AppMethodBeat.m2504i(19816);
            if (this.lyN == null || this.lyN.size() <= 0) {
                AppMethodBeat.m2505o(19816);
                return null;
            }
            String str = (String) this.lyN.get(i);
            AppMethodBeat.m2505o(19816);
            return str;
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            AppMethodBeat.m2504i(19817);
            if (this.lyN == null || this.lyN.size() <= 0) {
                AppMethodBeat.m2505o(19817);
                return null;
            }
            C11667a c11667a;
            String item = getItem(i);
            if (view == null) {
                C11667a c11667a2 = new C11667a();
                view = View.inflate(viewGroup.getContext(), 2130969410, null);
                c11667a2.lyP = (TextView) view.findViewById(2131823636);
                c11667a2.lyO = (TextView) view.findViewById(2131823634);
                c11667a2.lyQ = view.findViewById(2131823633);
                c11667a2.lyR = view.findViewById(2131823635);
                view.setTag(c11667a2);
                c11667a = c11667a2;
            } else {
                c11667a = (C11667a) view.getTag();
            }
            c11667a.lyO.setText(Integer.toString(i + 1));
            c11667a.lyP.setText(item);
            if (i == 0 && this.lyN.size() == 1) {
                c11667a.lyQ.setVisibility(4);
                c11667a.lyR.setVisibility(4);
            } else if (i == 0) {
                c11667a.lyQ.setVisibility(4);
                c11667a.lyR.setVisibility(0);
            } else if (i == this.lyN.size() - 1) {
                c11667a.lyR.setVisibility(4);
                c11667a.lyQ.setVisibility(0);
            }
            AppMethodBeat.m2505o(19817);
            return view;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public ExdeviceBindDeviceGuideUI() {
        AppMethodBeat.m2504i(19819);
        AppMethodBeat.m2505o(19819);
    }

    /* renamed from: a */
    static /* synthetic */ void m66189a(ExdeviceBindDeviceGuideUI exdeviceBindDeviceGuideUI, int i) {
        AppMethodBeat.m2504i(19823);
        exdeviceBindDeviceGuideUI.m66205uM(i);
        AppMethodBeat.m2505o(19823);
    }

    public final int getLayoutId() {
        return 2130969411;
    }

    public void onCreate(Bundle bundle) {
        IntentFilter intentFilter;
        AppMethodBeat.m2504i(19820);
        super.onCreate(bundle);
        setBackBtn(new C29911());
        if (!(!C1443d.m3068iW(23) || VERSION.RELEASE.equalsIgnoreCase("6.0") || VERSION.RELEASE.equalsIgnoreCase("6.0.0"))) {
            C4990ab.m7417i("MicroMsg.ExdeviceBindDeviceGuideUI", "Bluetooth limited version(%s)", VERSION.RELEASE);
            this.lyj = true;
        }
        Intent intent = getIntent();
        this.lyD = intent.getStringExtra("device_scan_mode");
        this.lyE = intent.getStringExtra("device_scan_conn_proto");
        this.lsu = intent.getStringExtra("device_id");
        this.lxI = intent.getStringExtra("device_type");
        this.lyF = intent.getStringExtra("device_title");
        this.lya = intent.getStringExtra("device_desc");
        this.kWC = intent.getStringExtra("device_icon_url");
        this.f16169Fd = intent.getStringExtra("device_category_id");
        this.lst = intent.getStringExtra("device_brand_name");
        this.lyG = intent.getStringExtra("bind_ticket");
        this.lyH = intent.getLongExtra("device_ble_simple_proto", -1);
        this.lyI = intent.getStringArrayListExtra("device_airkiss_steps");
        this.lyJ = intent.getStringExtra("device_airkiss_key");
        this.mTitle = intent.getStringExtra("device_airkiss_title");
        C4990ab.m7417i("MicroMsg.ExdeviceBindDeviceGuideUI", "Category config guide steps(%d)", Integer.valueOf(this.lyI.size()));
        this.lyi = (LocationManager) this.mController.ylL.getSystemService(C8741b.LOCATION);
        this.mListView = (ListView) findViewById(2131823638);
        View inflate = View.inflate(this, 2130969405, null);
        this.lyz = (TextView) inflate.findViewById(2131823623);
        this.lyx = new C38974a(this.lyI);
        this.mListView.addHeaderView(inflate);
        this.mListView.setDividerHeight(0);
        this.mListView.setClickable(false);
        this.mListView.setFooterDividersEnabled(false);
        this.mListView.setAdapter(this.lyx);
        this.lyB = (ImageView) findViewById(2131823626);
        this.lyA = (ScrollView) findViewById(2131823637);
        this.lyy = (Button) findViewById(2131823639);
        this.gHn = (Button) findViewById(2131823640);
        this.lyf = (TextView) findViewById(2131823627);
        this.lyC = (TextView) findViewById(2131823628);
        String str = "";
        if (this.lyD.compareTo("SCAN_CATALOG") != 0) {
            Assert.assertTrue(false);
        } else if (this.lyE.contains("wifi")) {
            this.lyK = true;
            str = this.mController.ylL.getString(C25738R.string.bfr);
        } else if (this.lyE.contains("blue")) {
            this.lyL = true;
            str = this.mController.ylL.getString(C25738R.string.bev);
        } else {
            Assert.assertTrue(false);
        }
        setMMTitle(str);
        if (this.lyL && !this.lyK) {
            if (!C42904a.m76178dv(this.mController.ylL)) {
                C4990ab.m7417i("MicroMsg.ExdeviceBindDeviceGuideUI", "now sdk version not support ble device : %d", Integer.valueOf(VERSION.SDK_INT));
                m66205uM(4);
            } else if (!C42904a.aVH()) {
                C4990ab.m7416i("MicroMsg.ExdeviceBindDeviceGuideUI", "Bluetooth is not open, Just leave");
                m66205uM(3);
            } else if (!(this.lyi == null || !this.lyj || this.lyi.isProviderEnabled("gps"))) {
                C4990ab.m7416i("MicroMsg.ExdeviceBindDeviceGuideUI", "BLE limited version, GPS do not open");
                m66205uM(6);
            }
            this.lyy.setOnClickListener(new C29922());
            this.gHn.setOnClickListener(new C389733());
            intentFilter = new IntentFilter();
            intentFilter.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
            intentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
            intentFilter.addAction("android.location.MODE_CHANGED");
            this.mController.ylL.registerReceiver(this.jIA, intentFilter);
            AppMethodBeat.m2505o(19820);
        }
        if (!this.lyL && this.lyK && !C5023at.isWifi(this.mController.ylL)) {
            C4990ab.m7416i("MicroMsg.ExdeviceBindDeviceGuideUI", "wifi is not open, Just leave");
            m66205uM(5);
            this.lyy.setOnClickListener(new C29922());
            this.gHn.setOnClickListener(new C389733());
            intentFilter = new IntentFilter();
            intentFilter.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
            intentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
            intentFilter.addAction("android.location.MODE_CHANGED");
            this.mController.ylL.registerReceiver(this.jIA, intentFilter);
            AppMethodBeat.m2505o(19820);
        } else if (!this.lyK || this.lyL) {
            if (this.lyL && !this.lyK) {
                m66205uM(2);
            }
            this.lyy.setOnClickListener(new C29922());
            this.gHn.setOnClickListener(new C389733());
            intentFilter = new IntentFilter();
            intentFilter.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
            intentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
            intentFilter.addAction("android.location.MODE_CHANGED");
            this.mController.ylL.registerReceiver(this.jIA, intentFilter);
            AppMethodBeat.m2505o(19820);
        } else {
            m66205uM(1);
            this.lyy.setOnClickListener(new C29922());
            this.gHn.setOnClickListener(new C389733());
            intentFilter = new IntentFilter();
            intentFilter.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
            intentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
            intentFilter.addAction("android.location.MODE_CHANGED");
            this.mController.ylL.registerReceiver(this.jIA, intentFilter);
            AppMethodBeat.m2505o(19820);
        }
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(19821);
        super.onDestroy();
        this.mController.ylL.unregisterReceiver(this.jIA);
        AppMethodBeat.m2505o(19821);
    }

    public void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
    }

    /* renamed from: uM */
    private void m66205uM(int i) {
        AppMethodBeat.m2504i(19822);
        switch (i) {
            case 1:
                this.lyy.setText(this.mController.ylL.getString(C25738R.string.bfr));
                this.gHn.setText(this.mController.ylL.getString(C25738R.string.ben));
                this.lyz.setText(this.mController.ylL.getString(C25738R.string.bfs));
                break;
            case 2:
                this.lyy.setText(this.mController.ylL.getString(C25738R.string.bfj));
                this.gHn.setVisibility(8);
                this.lyz.setText(this.mController.ylL.getString(C25738R.string.bfi));
                break;
            case 3:
                this.lyB.setImageResource(C1318a.bluetooth_logo);
                this.lyf.setText(C25738R.string.bf7);
                this.lyC.setText(C25738R.string.ber);
                break;
            case 4:
                this.lyB.setImageResource(C1318a.bluetooth_logo);
                this.lyf.setText(C25738R.string.bf5);
                this.lyC.setText("");
                break;
            case 5:
                this.lyB.setImageResource(C1318a.wifi_logo);
                this.lyf.setText(C25738R.string.bf7);
                this.lyC.setText(C25738R.string.bf2);
                break;
            case 6:
                this.lyB.setImageResource(C1318a.bluetooth_logo);
                this.lyf.setText(C25738R.string.bf7);
                this.lyC.setText(C25738R.string.bgh);
                break;
        }
        switch (i) {
            case 1:
            case 2:
                this.lyB.setVisibility(8);
                this.lyf.setVisibility(8);
                this.lyC.setVisibility(8);
                this.mListView.setVisibility(0);
                this.lyA.setVisibility(0);
                AppMethodBeat.m2505o(19822);
                return;
            case 3:
            case 4:
            case 5:
            case 6:
                this.lyB.setVisibility(0);
                this.lyf.setVisibility(0);
                this.mListView.setVisibility(8);
                this.lyA.setVisibility(8);
                if (i != 4) {
                    this.lyC.setVisibility(0);
                    break;
                }
                this.lyC.setVisibility(8);
                AppMethodBeat.m2505o(19822);
                return;
        }
        AppMethodBeat.m2505o(19822);
    }
}
