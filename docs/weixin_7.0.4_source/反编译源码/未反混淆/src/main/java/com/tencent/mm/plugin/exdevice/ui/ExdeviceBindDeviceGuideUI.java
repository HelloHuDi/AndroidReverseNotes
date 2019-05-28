package com.tencent.mm.plugin.exdevice.ui;

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
import com.google.firebase.analytics.FirebaseAnalytics.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import junit.framework.Assert;

public class ExdeviceBindDeviceGuideUI extends MMActivity implements f {
    private String Fd;
    private Button gHn;
    BroadcastReceiver jIA = new BroadcastReceiver() {
        public final void onReceive(Context context, Intent intent) {
            AppMethodBeat.i(19814);
            ab.i("MicroMsg.ExdeviceBindDeviceGuideUI", "Action broadcast receive...");
            if (intent == null) {
                AppMethodBeat.o(19814);
                return;
            }
            String action = intent.getAction();
            ab.d("MicroMsg.ExdeviceBindDeviceGuideUI", "Receiver action(%s)", action);
            int intExtra;
            if ("android.bluetooth.adapter.action.STATE_CHANGED".equals(action) && ExdeviceBindDeviceGuideUI.this.lyL) {
                intExtra = intent.getIntExtra("android.bluetooth.adapter.extra.STATE", -1);
                if (intExtra != 12) {
                    if (intExtra == 10) {
                        ExdeviceBindDeviceGuideUI.a(ExdeviceBindDeviceGuideUI.this, 3);
                    }
                    AppMethodBeat.o(19814);
                    return;
                } else if (!ExdeviceBindDeviceGuideUI.this.lyj || ExdeviceBindDeviceGuideUI.this.lyi.isProviderEnabled("gps")) {
                    ExdeviceBindDeviceGuideUI.a(ExdeviceBindDeviceGuideUI.this, 2);
                    AppMethodBeat.o(19814);
                    return;
                }
            } else if ("android.net.wifi.WIFI_STATE_CHANGED".equals(action) && ExdeviceBindDeviceGuideUI.this.lyK) {
                intExtra = intent.getIntExtra("wifi_state", -1);
                ab.i("MicroMsg.ExdeviceBindDeviceGuideUI", "Wifi state changed action: wifiState(%d)", Integer.valueOf(intExtra));
                if (intExtra == 3) {
                    ExdeviceBindDeviceGuideUI.a(ExdeviceBindDeviceGuideUI.this, 1);
                    AppMethodBeat.o(19814);
                    return;
                }
                if (intExtra == 1) {
                    ExdeviceBindDeviceGuideUI.a(ExdeviceBindDeviceGuideUI.this, 5);
                }
                AppMethodBeat.o(19814);
                return;
            } else {
                if (ExdeviceBindDeviceGuideUI.this.lyj && "android.location.MODE_CHANGED".equals(action)) {
                    if (ExdeviceBindDeviceGuideUI.this.lyi.isProviderEnabled("gps")) {
                        if (com.tencent.mm.plugin.d.a.e.a.aVH()) {
                            ExdeviceBindDeviceGuideUI.a(ExdeviceBindDeviceGuideUI.this, 2);
                            AppMethodBeat.o(19814);
                            return;
                        }
                        ExdeviceBindDeviceGuideUI.a(ExdeviceBindDeviceGuideUI.this, 3);
                        AppMethodBeat.o(19814);
                        return;
                    }
                }
                AppMethodBeat.o(19814);
            }
            ExdeviceBindDeviceGuideUI.a(ExdeviceBindDeviceGuideUI.this, 6);
            AppMethodBeat.o(19814);
        }
    };
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
    private a lyx;
    private Button lyy;
    private TextView lyz;
    private ListView mListView;
    private String mTitle;

    static final class a extends BaseAdapter {
        private ArrayList<String> lyN;

        static class a {
            TextView lyO;
            TextView lyP;
            View lyQ;
            View lyR;

            private a() {
            }

            /* synthetic */ a(byte b) {
                this();
            }
        }

        public a(ArrayList<String> arrayList) {
            this.lyN = arrayList;
        }

        public final int getCount() {
            AppMethodBeat.i(19815);
            if (this.lyN != null) {
                int size = this.lyN.size();
                AppMethodBeat.o(19815);
                return size;
            }
            AppMethodBeat.o(19815);
            return 0;
        }

        private String getItem(int i) {
            AppMethodBeat.i(19816);
            if (this.lyN == null || this.lyN.size() <= 0) {
                AppMethodBeat.o(19816);
                return null;
            }
            String str = (String) this.lyN.get(i);
            AppMethodBeat.o(19816);
            return str;
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            AppMethodBeat.i(19817);
            if (this.lyN == null || this.lyN.size() <= 0) {
                AppMethodBeat.o(19817);
                return null;
            }
            a aVar;
            String item = getItem(i);
            if (view == null) {
                a aVar2 = new a();
                view = View.inflate(viewGroup.getContext(), R.layout.vs, null);
                aVar2.lyP = (TextView) view.findViewById(R.id.bik);
                aVar2.lyO = (TextView) view.findViewById(R.id.bii);
                aVar2.lyQ = view.findViewById(R.id.bih);
                aVar2.lyR = view.findViewById(R.id.bij);
                view.setTag(aVar2);
                aVar = aVar2;
            } else {
                aVar = (a) view.getTag();
            }
            aVar.lyO.setText(Integer.toString(i + 1));
            aVar.lyP.setText(item);
            if (i == 0 && this.lyN.size() == 1) {
                aVar.lyQ.setVisibility(4);
                aVar.lyR.setVisibility(4);
            } else if (i == 0) {
                aVar.lyQ.setVisibility(4);
                aVar.lyR.setVisibility(0);
            } else if (i == this.lyN.size() - 1) {
                aVar.lyR.setVisibility(4);
                aVar.lyQ.setVisibility(0);
            }
            AppMethodBeat.o(19817);
            return view;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public ExdeviceBindDeviceGuideUI() {
        AppMethodBeat.i(19819);
        AppMethodBeat.o(19819);
    }

    static /* synthetic */ void a(ExdeviceBindDeviceGuideUI exdeviceBindDeviceGuideUI, int i) {
        AppMethodBeat.i(19823);
        exdeviceBindDeviceGuideUI.uM(i);
        AppMethodBeat.o(19823);
    }

    public final int getLayoutId() {
        return R.layout.vt;
    }

    public void onCreate(Bundle bundle) {
        IntentFilter intentFilter;
        AppMethodBeat.i(19820);
        super.onCreate(bundle);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(19811);
                ExdeviceBindDeviceGuideUI.this.finish();
                AppMethodBeat.o(19811);
                return true;
            }
        });
        if (!(!d.iW(23) || VERSION.RELEASE.equalsIgnoreCase("6.0") || VERSION.RELEASE.equalsIgnoreCase("6.0.0"))) {
            ab.i("MicroMsg.ExdeviceBindDeviceGuideUI", "Bluetooth limited version(%s)", VERSION.RELEASE);
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
        this.Fd = intent.getStringExtra("device_category_id");
        this.lst = intent.getStringExtra("device_brand_name");
        this.lyG = intent.getStringExtra("bind_ticket");
        this.lyH = intent.getLongExtra("device_ble_simple_proto", -1);
        this.lyI = intent.getStringArrayListExtra("device_airkiss_steps");
        this.lyJ = intent.getStringExtra("device_airkiss_key");
        this.mTitle = intent.getStringExtra("device_airkiss_title");
        ab.i("MicroMsg.ExdeviceBindDeviceGuideUI", "Category config guide steps(%d)", Integer.valueOf(this.lyI.size()));
        this.lyi = (LocationManager) this.mController.ylL.getSystemService(b.LOCATION);
        this.mListView = (ListView) findViewById(R.id.bim);
        View inflate = View.inflate(this, R.layout.vn, null);
        this.lyz = (TextView) inflate.findViewById(R.id.bi8);
        this.lyx = new a(this.lyI);
        this.mListView.addHeaderView(inflate);
        this.mListView.setDividerHeight(0);
        this.mListView.setClickable(false);
        this.mListView.setFooterDividersEnabled(false);
        this.mListView.setAdapter(this.lyx);
        this.lyB = (ImageView) findViewById(R.id.bia);
        this.lyA = (ScrollView) findViewById(R.id.bil);
        this.lyy = (Button) findViewById(R.id.bin);
        this.gHn = (Button) findViewById(R.id.bio);
        this.lyf = (TextView) findViewById(R.id.bib);
        this.lyC = (TextView) findViewById(R.id.bic);
        String str = "";
        if (this.lyD.compareTo("SCAN_CATALOG") != 0) {
            Assert.assertTrue(false);
        } else if (this.lyE.contains("wifi")) {
            this.lyK = true;
            str = this.mController.ylL.getString(R.string.bfr);
        } else if (this.lyE.contains("blue")) {
            this.lyL = true;
            str = this.mController.ylL.getString(R.string.bev);
        } else {
            Assert.assertTrue(false);
        }
        setMMTitle(str);
        if (this.lyL && !this.lyK) {
            if (!com.tencent.mm.plugin.d.a.e.a.dv(this.mController.ylL)) {
                ab.i("MicroMsg.ExdeviceBindDeviceGuideUI", "now sdk version not support ble device : %d", Integer.valueOf(VERSION.SDK_INT));
                uM(4);
            } else if (!com.tencent.mm.plugin.d.a.e.a.aVH()) {
                ab.i("MicroMsg.ExdeviceBindDeviceGuideUI", "Bluetooth is not open, Just leave");
                uM(3);
            } else if (!(this.lyi == null || !this.lyj || this.lyi.isProviderEnabled("gps"))) {
                ab.i("MicroMsg.ExdeviceBindDeviceGuideUI", "BLE limited version, GPS do not open");
                uM(6);
            }
            this.lyy.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(19812);
                    Intent intent = new Intent();
                    intent.putExtra("device_scan_mode", ExdeviceBindDeviceGuideUI.this.lyD);
                    intent.putExtra("device_scan_conn_proto", ExdeviceBindDeviceGuideUI.this.lyE);
                    intent.putExtra("device_id", ExdeviceBindDeviceGuideUI.this.lsu);
                    intent.putExtra("device_type", ExdeviceBindDeviceGuideUI.this.lxI);
                    intent.putExtra("device_title", ExdeviceBindDeviceGuideUI.this.lyF);
                    intent.putExtra("device_desc", ExdeviceBindDeviceGuideUI.this.lya);
                    intent.putExtra("device_icon_url", ExdeviceBindDeviceGuideUI.this.kWC);
                    intent.putExtra("device_category_id", ExdeviceBindDeviceGuideUI.this.Fd);
                    intent.putExtra("device_brand_name", ExdeviceBindDeviceGuideUI.this.lst);
                    intent.putExtra("bind_ticket", ExdeviceBindDeviceGuideUI.this.lyG);
                    intent.putExtra("device_ble_simple_proto", ExdeviceBindDeviceGuideUI.this.lyH);
                    intent.putExtra("encryptKey", ExdeviceBindDeviceGuideUI.this.lyJ);
                    intent.putExtra("jumpToBindDevice", true);
                    if (!ExdeviceBindDeviceGuideUI.this.lyL || ExdeviceBindDeviceGuideUI.this.lyK) {
                        if (ExdeviceBindDeviceGuideUI.this.lyK && !ExdeviceBindDeviceGuideUI.this.lyL) {
                            intent.putExtra("exdevice_airkiss_open_type", 2);
                            com.tencent.mm.bp.d.b(ExdeviceBindDeviceGuideUI.this.mController.ylL, "exdevice", ".ui.ExdeviceConnectWifiUI", intent);
                        }
                        AppMethodBeat.o(19812);
                        return;
                    }
                    com.tencent.mm.bp.d.b(ExdeviceBindDeviceGuideUI.this.mController.ylL, "exdevice", ".ui.ExdeviceBindDeviceUI", intent);
                    AppMethodBeat.o(19812);
                }
            });
            this.gHn.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(19813);
                    if (ExdeviceBindDeviceGuideUI.this.lyK && !ExdeviceBindDeviceGuideUI.this.lyL) {
                        Intent intent = new Intent();
                        intent.putExtra("device_scan_mode", ExdeviceBindDeviceGuideUI.this.lyD);
                        intent.putExtra("device_scan_conn_proto", ExdeviceBindDeviceGuideUI.this.lyE);
                        intent.putExtra("device_id", ExdeviceBindDeviceGuideUI.this.lsu);
                        intent.putExtra("device_type", ExdeviceBindDeviceGuideUI.this.lxI);
                        intent.putExtra("device_title", ExdeviceBindDeviceGuideUI.this.lyF);
                        intent.putExtra("device_desc", ExdeviceBindDeviceGuideUI.this.lya);
                        intent.putExtra("device_icon_url", ExdeviceBindDeviceGuideUI.this.kWC);
                        intent.putExtra("device_category_id", ExdeviceBindDeviceGuideUI.this.Fd);
                        intent.putExtra("device_brand_name", ExdeviceBindDeviceGuideUI.this.lst);
                        intent.putExtra("bind_ticket", ExdeviceBindDeviceGuideUI.this.lyG);
                        com.tencent.mm.bp.d.b(ExdeviceBindDeviceGuideUI.this.mController.ylL, "exdevice", ".ui.ExdeviceBindDeviceUI", intent);
                    }
                    AppMethodBeat.o(19813);
                }
            });
            intentFilter = new IntentFilter();
            intentFilter.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
            intentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
            intentFilter.addAction("android.location.MODE_CHANGED");
            this.mController.ylL.registerReceiver(this.jIA, intentFilter);
            AppMethodBeat.o(19820);
        }
        if (!this.lyL && this.lyK && !at.isWifi(this.mController.ylL)) {
            ab.i("MicroMsg.ExdeviceBindDeviceGuideUI", "wifi is not open, Just leave");
            uM(5);
            this.lyy.setOnClickListener(/* anonymous class already generated */);
            this.gHn.setOnClickListener(/* anonymous class already generated */);
            intentFilter = new IntentFilter();
            intentFilter.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
            intentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
            intentFilter.addAction("android.location.MODE_CHANGED");
            this.mController.ylL.registerReceiver(this.jIA, intentFilter);
            AppMethodBeat.o(19820);
        } else if (!this.lyK || this.lyL) {
            if (this.lyL && !this.lyK) {
                uM(2);
            }
            this.lyy.setOnClickListener(/* anonymous class already generated */);
            this.gHn.setOnClickListener(/* anonymous class already generated */);
            intentFilter = new IntentFilter();
            intentFilter.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
            intentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
            intentFilter.addAction("android.location.MODE_CHANGED");
            this.mController.ylL.registerReceiver(this.jIA, intentFilter);
            AppMethodBeat.o(19820);
        } else {
            uM(1);
            this.lyy.setOnClickListener(/* anonymous class already generated */);
            this.gHn.setOnClickListener(/* anonymous class already generated */);
            intentFilter = new IntentFilter();
            intentFilter.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
            intentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
            intentFilter.addAction("android.location.MODE_CHANGED");
            this.mController.ylL.registerReceiver(this.jIA, intentFilter);
            AppMethodBeat.o(19820);
        }
    }

    public void onDestroy() {
        AppMethodBeat.i(19821);
        super.onDestroy();
        this.mController.ylL.unregisterReceiver(this.jIA);
        AppMethodBeat.o(19821);
    }

    public void onSceneEnd(int i, int i2, String str, m mVar) {
    }

    private void uM(int i) {
        AppMethodBeat.i(19822);
        switch (i) {
            case 1:
                this.lyy.setText(this.mController.ylL.getString(R.string.bfr));
                this.gHn.setText(this.mController.ylL.getString(R.string.ben));
                this.lyz.setText(this.mController.ylL.getString(R.string.bfs));
                break;
            case 2:
                this.lyy.setText(this.mController.ylL.getString(R.string.bfj));
                this.gHn.setVisibility(8);
                this.lyz.setText(this.mController.ylL.getString(R.string.bfi));
                break;
            case 3:
                this.lyB.setImageResource(R.raw.bluetooth_logo);
                this.lyf.setText(R.string.bf7);
                this.lyC.setText(R.string.ber);
                break;
            case 4:
                this.lyB.setImageResource(R.raw.bluetooth_logo);
                this.lyf.setText(R.string.bf5);
                this.lyC.setText("");
                break;
            case 5:
                this.lyB.setImageResource(R.raw.wifi_logo);
                this.lyf.setText(R.string.bf7);
                this.lyC.setText(R.string.bf2);
                break;
            case 6:
                this.lyB.setImageResource(R.raw.bluetooth_logo);
                this.lyf.setText(R.string.bf7);
                this.lyC.setText(R.string.bgh);
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
                AppMethodBeat.o(19822);
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
                AppMethodBeat.o(19822);
                return;
        }
        AppMethodBeat.o(19822);
    }
}
