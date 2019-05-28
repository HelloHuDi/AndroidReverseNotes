package com.tencent.mm.plugin.exdevice.ui;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.util.Base64;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;
import com.google.android.gms.common.Scopes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.m;
import com.tencent.mm.at.o;
import com.tencent.mm.model.aw;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.exdevice.jni.Java2CExDevice;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.plugin.exdevice.model.j;
import com.tencent.mm.plugin.exdevice.model.p;
import com.tencent.mm.plugin.exdevice.model.t;
import com.tencent.mm.plugin.exdevice.model.v;
import com.tencent.mm.protocal.protobuf.ajl;
import com.tencent.mm.protocal.protobuf.asq;
import com.tencent.mm.protocal.protobuf.asr;
import com.tencent.mm.protocal.protobuf.bbv;
import com.tencent.mm.protocal.protobuf.buq;
import com.tencent.mm.protocal.protobuf.bvu;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.ui.MMActivity;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import junit.framework.Assert;
import org.json.JSONObject;

@SuppressLint({"Assert"})
public class ExdeviceBindDeviceUI extends MMActivity implements com.tencent.mm.ai.f, com.tencent.mm.plugin.exdevice.model.e.b {
    static final /* synthetic */ boolean $assertionsDisabled = (!ExdeviceBindDeviceUI.class.desiredAssertionStatus());
    private ProgressDialog ehJ;
    private ScrollView hJh;
    private TextView klD;
    private String lst;
    private com.tencent.mm.plugin.exdevice.model.j.a ltg;
    private String lxI;
    private a lyS;
    private View lyT;
    private TextView lyU;
    private ImageView lyV;
    private View lyW;
    private e lyX;
    private String lyY;
    private String lyZ;
    private TextView lyf;
    private TextView lyg;
    private boolean lza = false;
    private com.tencent.mm.plugin.exdevice.model.j.a lzb;
    private boolean lzc = false;
    private boolean lzd = false;
    private ListView mListView;

    static final class a extends BaseAdapter {
        private com.tencent.mm.at.a.a.c lyr;
        List<f> lzl = new ArrayList();
        private String lzm;
        private e lzn;
        private String lzo;

        static class a {
            TextView gxi;
            ImageView iqT;

            private a() {
            }

            /* synthetic */ a(byte b) {
                this();
            }
        }

        public final /* synthetic */ Object getItem(int i) {
            AppMethodBeat.i(19849);
            f uO = uO(i);
            AppMethodBeat.o(19849);
            return uO;
        }

        public a(String str, e eVar, String str2) {
            AppMethodBeat.i(19837);
            this.lzm = str;
            this.lzn = eVar;
            this.lzo = str2;
            com.tencent.mm.at.a.a.c.a aVar = new com.tencent.mm.at.a.a.c.a();
            aVar.ePV = R.color.zf;
            this.lyr = aVar.ahG();
            AppMethodBeat.o(19837);
        }

        /* Access modifiers changed, original: final */
        public final void bpE() {
            AppMethodBeat.i(19838);
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.lzl.size()) {
                    f fVar = (f) this.lzl.get(i2);
                    fVar.lzx = c(fVar);
                    i = i2 + 1;
                } else {
                    AppMethodBeat.o(19838);
                    return;
                }
            }
        }

        public final boolean b(f fVar) {
            AppMethodBeat.i(19839);
            if (KD(fVar.getKey()) < 0) {
                AppMethodBeat.o(19839);
                return false;
            }
            fVar.lzx = c(fVar);
            AppMethodBeat.o(19839);
            return true;
        }

        public final boolean KB(String str) {
            AppMethodBeat.i(19840);
            if (KD(str) >= 0) {
                AppMethodBeat.o(19840);
                return true;
            }
            AppMethodBeat.o(19840);
            return false;
        }

        public final f KC(String str) {
            AppMethodBeat.i(19841);
            if (str == null || str.length() == 0) {
                AppMethodBeat.o(19841);
                return null;
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.lzl.size()) {
                    f fVar = (f) this.lzl.get(i2);
                    if (KE(fVar.bpF()) || !str.equalsIgnoreCase(fVar.bpF())) {
                        i = i2 + 1;
                    } else {
                        AppMethodBeat.o(19841);
                        return fVar;
                    }
                }
                AppMethodBeat.o(19841);
                return null;
            }
        }

        public final int getCount() {
            AppMethodBeat.i(19842);
            int i = 0;
            for (int i2 = 0; i2 < this.lzl.size(); i2++) {
                if (((f) this.lzl.get(i2)).lzx) {
                    i++;
                }
            }
            AppMethodBeat.o(19842);
            return i;
        }

        public final f uO(int i) {
            AppMethodBeat.i(19843);
            int i2 = -1;
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 < this.lzl.size()) {
                    if (((f) this.lzl.get(i4)).lzx) {
                        i2++;
                    }
                    if (i2 == i) {
                        f fVar = (f) this.lzl.get(i4);
                        AppMethodBeat.o(19843);
                        return fVar;
                    }
                    i3 = i4 + 1;
                } else {
                    AppMethodBeat.o(19843);
                    return null;
                }
            }
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            a aVar;
            View inflate;
            AppMethodBeat.i(19844);
            f uO = uO(i);
            if (view == null) {
                aVar = new a();
                inflate = View.inflate(viewGroup.getContext(), R.layout.vu, null);
                aVar.gxi = (TextView) inflate.findViewById(R.id.bi_);
                aVar.iqT = (ImageView) inflate.findViewById(R.id.bi9);
                inflate.setTag(aVar);
            } else {
                aVar = (a) view.getTag();
                inflate = view;
            }
            if (uO == null || uO.lzC == null) {
                Assert.assertTrue(false);
                AppMethodBeat.o(19844);
                return inflate;
            }
            String str;
            String str2;
            SpannableString spannableString;
            if (uO.lzy == b.CONNECT_PROTO_TYPE_BLUE) {
                ab.d("MicroMsg.ExdeviceBindDeviceUI", "position(%s), broadcastname(%s), mac(%s), deviceTitle(%s).", Integer.valueOf(i), uO.lzz.lzs, uO.lzz.cbq, uO.lzC.wwt);
                str = "";
                str2 = uO.lzC.dFt;
                if (str2 != null && str2.length() >= 4) {
                    str = str2.substring(str2.length() - 4, str2.length());
                } else if (uO.lzz.cbq != null && uO.lzz.cbq.length() >= 4) {
                    str = uO.lzz.cbq;
                    str = str.substring(str.length() - 4, str.length());
                }
                str = uO.lzC.wwt + " " + str;
                spannableString = new SpannableString(str);
                spannableString.setSpan(new ForegroundColorSpan(viewGroup.getContext().getResources().getColor(R.color.s0)), uO.lzC.wwt.length() + 1, str.length(), 17);
                aVar.gxi.setText(spannableString);
            } else if (uO.lzy == b.CONNECT_PROTO_TYPE_WIFI) {
                str = "";
                str2 = uO.lzC.dFt;
                if (str2 != null && str2.length() >= 4) {
                    str = str2.substring(str2.length() - 4, str2.length());
                } else if (uO.lzC.vKF != null && uO.lzC.vKF.length() >= 4) {
                    str = uO.lzC.vKF;
                    str = str.substring(str.length() - 4, str.length());
                }
                str = uO.lzC.wwt + " " + str;
                spannableString = new SpannableString(str);
                spannableString.setSpan(new ForegroundColorSpan(viewGroup.getContext().getResources().getColor(R.color.s0)), uO.lzC.wwt.length() + 1, str.length(), 17);
                aVar.gxi.setText(spannableString);
            } else {
                Assert.assertTrue(false);
            }
            str = uO.lzC.IconUrl;
            if (!KE(str)) {
                o.ahp().a(str, aVar.iqT, this.lyr);
            }
            AppMethodBeat.o(19844);
            return inflate;
        }

        private int KD(String str) {
            AppMethodBeat.i(19845);
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.lzl.size()) {
                    AppMethodBeat.o(19845);
                    return -1;
                } else if (((f) this.lzl.get(i2)).getKey().compareTo(str) == 0) {
                    AppMethodBeat.o(19845);
                    return i2;
                } else {
                    i = i2 + 1;
                }
            }
        }

        /* Access modifiers changed, original: final */
        public final int dV(String str, String str2) {
            AppMethodBeat.i(19846);
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.lzl.size()) {
                    f fVar = (f) this.lzl.get(i2);
                    String str3 = fVar.lzB != null ? fVar.lzB.vIk : fVar.lzy == b.CONNECT_PROTO_TYPE_WIFI ? fVar.lzA.lxI : null;
                    String str4 = fVar.lzB != null ? fVar.lzB.jBE : fVar.lzy == b.CONNECT_PROTO_TYPE_WIFI ? fVar.lzA.lsu : null;
                    if (KE(str3) || KE(str4) || str.compareTo(str3) != 0 || str2.compareTo(str4) != 0) {
                        i = i2 + 1;
                    } else {
                        AppMethodBeat.o(19846);
                        return i2;
                    }
                }
                AppMethodBeat.o(19846);
                return -1;
            }
        }

        /* Access modifiers changed, original: final */
        public final boolean c(f fVar) {
            AppMethodBeat.i(19847);
            if (fVar.lzC == null) {
                AppMethodBeat.o(19847);
                return false;
            }
            if (this.lzn == e.SCAN_CATALOG) {
                if (fVar.lzC.wwm == null || fVar.lzC.wwm.compareTo(this.lzm) != 0) {
                    AppMethodBeat.o(19847);
                    return false;
                } else if (fVar.lzC.wwv == null || fVar.lzC.wwv.compareTo(this.lzo) != 0) {
                    AppMethodBeat.o(19847);
                    return false;
                }
            } else if (this.lzn != e.SCAN_MY_DEVICE) {
                Assert.assertTrue(false);
                AppMethodBeat.o(19847);
                return false;
            } else if (fVar.lzC.dFp == 0) {
                AppMethodBeat.o(19847);
                return false;
            }
            AppMethodBeat.o(19847);
            return true;
        }

        private static boolean KE(String str) {
            AppMethodBeat.i(19848);
            if (str == null || str.length() == 0) {
                AppMethodBeat.o(19848);
                return true;
            }
            AppMethodBeat.o(19848);
            return false;
        }
    }

    class c {
        public String cbq;
        public String lzs;

        private c() {
        }

        /* synthetic */ c(ExdeviceBindDeviceUI exdeviceBindDeviceUI, byte b) {
            this();
        }
    }

    class d {
        public String lsu;
        public String lxI;

        private d() {
        }

        /* synthetic */ d(ExdeviceBindDeviceUI exdeviceBindDeviceUI, byte b) {
            this();
        }
    }

    enum b {
        CONNECT_PROTO_TYPE_WIFI,
        CONNECT_PROTO_TYPE_BLUE;

        static {
            AppMethodBeat.o(19852);
        }
    }

    enum e {
        SCAN_ALL,
        SCAN_MY_DEVICE,
        SCAN_CATALOG;

        static {
            AppMethodBeat.o(19855);
        }
    }

    class f {
        public String lyG;
        public d lzA;
        public asq lzB;
        public asr lzC;
        public int lzD;
        public bbv lzE;
        public String lzF;
        public boolean lzx;
        public b lzy;
        public c lzz;

        private f() {
            this.lzx = false;
            this.lzy = b.CONNECT_PROTO_TYPE_WIFI;
        }

        /* synthetic */ f(ExdeviceBindDeviceUI exdeviceBindDeviceUI, byte b) {
            this();
        }

        public final String getKey() {
            AppMethodBeat.i(19856);
            String str;
            if (this.lzy == b.CONNECT_PROTO_TYPE_WIFI) {
                str = this.lzA.lxI + this.lzA.lsu;
                AppMethodBeat.o(19856);
                return str;
            }
            str = this.lzz.cbq;
            AppMethodBeat.o(19856);
            return str;
        }

        public final String bpF() {
            if (this.lzy != b.CONNECT_PROTO_TYPE_WIFI) {
                return this.lzz.cbq;
            }
            if (this.lzC == null) {
                return null;
            }
            return this.lzC.vKF;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static {
        AppMethodBeat.i(19870);
        AppMethodBeat.o(19870);
    }

    public final int getLayoutId() {
        return R.layout.vv;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(19857);
        super.onCreate(bundle);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(19824);
                ExdeviceBindDeviceUI.this.finish();
                AppMethodBeat.o(19824);
                return true;
            }
        });
        Intent intent = getIntent();
        this.lyY = intent.getStringExtra("device_category_id");
        this.lst = intent.getStringExtra("device_brand_name");
        this.lxI = intent.getStringExtra("device_type");
        if (this.lxI == null || this.lxI.length() == 0) {
            this.lxI = this.lst;
        }
        String stringExtra = intent.getStringExtra("device_scan_conn_proto");
        String stringExtra2 = intent.getStringExtra("device_scan_mode");
        String str = "";
        String stringExtra3 = intent.getStringExtra("device_title");
        if (bo.isNullOrNil(stringExtra3)) {
            stringExtra3 = this.mController.ylL.getString(R.string.bg6);
        }
        if (stringExtra2.contains("SCAN_MY_DEVICE")) {
            this.lyX = e.SCAN_MY_DEVICE;
            str = this.mController.ylL.getString(R.string.beh);
        } else if (stringExtra2.compareTo("SCAN_CATALOG") == 0) {
            this.lyX = e.SCAN_CATALOG;
            str = this.mController.ylL.getString(R.string.bef);
        } else {
            Assert.assertTrue(false);
        }
        setMMTitle(str);
        if (this.lyX == e.SCAN_CATALOG) {
            this.lzc = stringExtra.contains("wifi");
            this.lzd = stringExtra.contains("blue");
            ab.i("MicroMsg.ExdeviceBindDeviceUI", "mIsScanWifi(%b), mIsScanBlue(%b)", Boolean.valueOf(this.lzc), Boolean.valueOf(this.lzd));
        } else if (this.lyX == e.SCAN_MY_DEVICE) {
            this.lzd = true;
            this.lzc = true;
        }
        this.ltg = new com.tencent.mm.plugin.exdevice.model.j.a() {
            /* JADX WARNING: Removed duplicated region for block: B:14:0x0048 A:{SKIP} */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void g(int i, Object... objArr) {
                Throwable e;
                AppMethodBeat.i(19828);
                if (i != 10 || objArr == null) {
                    AppMethodBeat.o(19828);
                    return;
                }
                String string;
                String string2;
                String string3;
                try {
                    JSONObject jSONObject = new JSONObject(new String((byte[]) objArr[0]));
                    JSONObject jSONObject2 = jSONObject.getJSONObject("deviceInfo");
                    string = jSONObject2.getString("deviceType");
                    try {
                        string3 = jSONObject2.getString("deviceId");
                    } catch (Exception e2) {
                        e = e2;
                        string3 = null;
                    }
                    try {
                        if (!jSONObject.isNull("manufacturerData")) {
                            string2 = jSONObject.getString("manufacturerData");
                            if (string != null || string3 == null) {
                                AppMethodBeat.o(19828);
                            }
                            final f fVar = new f(ExdeviceBindDeviceUI.this, (byte) 0);
                            fVar.lzy = b.CONNECT_PROTO_TYPE_WIFI;
                            fVar.lzA = new d(ExdeviceBindDeviceUI.this, (byte) 0);
                            fVar.lzA.lxI = string;
                            fVar.lzA.lsu = string3;
                            if (bo.isNullOrNil(string2)) {
                                fVar.lzF = null;
                            } else {
                                fVar.lzF = Base64.encodeToString(string2.getBytes(), 2);
                                ab.i("MicroMsg.ExdeviceBindDeviceUI", "device.mManufacturerData: %s", fVar.lzF);
                            }
                            al.d(new Runnable() {
                                public final void run() {
                                    AppMethodBeat.i(19827);
                                    ExdeviceBindDeviceUI.this.a(fVar);
                                    AppMethodBeat.o(19827);
                                }
                            });
                            AppMethodBeat.o(19828);
                            return;
                        }
                    } catch (Exception e3) {
                        e = e3;
                        ab.printErrStackTrace("MicroMsg.ExdeviceBindDeviceUI", e, "", new Object[0]);
                        ab.e("MicroMsg.ExdeviceBindDeviceUI", "json decode failed: deviceInfo decode");
                        string2 = null;
                        if (string != null) {
                        }
                        AppMethodBeat.o(19828);
                    }
                } catch (Exception e4) {
                    e = e4;
                    string3 = null;
                    string = null;
                }
                string2 = null;
                if (string != null) {
                }
                AppMethodBeat.o(19828);
            }
        };
        this.lzb = new com.tencent.mm.plugin.exdevice.model.j.a() {
            public final void g(int i, Object... objArr) {
            }
        };
        initView();
        this.klD.setText(this.mController.ylL.getString(R.string.bhx, new Object[]{stringExtra3}));
        aw.Rg().a(1264, (com.tencent.mm.ai.f) this);
        aw.Rg().a(1706, (com.tencent.mm.ai.f) this);
        aw.Rg().a(1270, (com.tencent.mm.ai.f) this);
        aw.Rg().a(1719, (com.tencent.mm.ai.f) this);
        if (this.lzd) {
            ad.bph().a((com.tencent.mm.plugin.exdevice.model.e.b) this);
        }
        if (this.lzc) {
            j.boN().a(10, this.ltg);
            j.boN().a(11, this.lzb);
            Java2CExDevice.initWCLanDeviceLib();
        }
        AppMethodBeat.o(19857);
    }

    public void onResume() {
        AppMethodBeat.i(19858);
        super.onResume();
        ab.i("MicroMsg.ExdeviceBindDeviceUI", "onResume start scan.");
        if (this.lzd) {
            ad.bph();
            com.tencent.mm.plugin.exdevice.model.e.boJ();
        }
        if (this.lzc) {
            Java2CExDevice.startScanWCLanDevice(new byte[0], 1000);
        }
        this.lyS.bpE();
        this.lyS.notifyDataSetChanged();
        AppMethodBeat.o(19858);
    }

    public final void initView() {
        AppMethodBeat.i(19859);
        this.mListView = (ListView) findViewById(R.id.a46);
        View inflate = View.inflate(this, R.layout.vx, null);
        this.lyW = View.inflate(this, R.layout.wt, null);
        this.lyT = this.lyW.findViewById(R.id.bif);
        this.klD = (TextView) this.lyW.findViewById(R.id.big);
        this.lyU = (TextView) findViewById(R.id.bie);
        this.lyV = (ImageView) findViewById(R.id.bia);
        this.lyf = (TextView) findViewById(R.id.bib);
        this.lyg = (TextView) findViewById(R.id.bic);
        this.hJh = (ScrollView) findViewById(R.id.biq);
        this.mListView.addHeaderView(inflate, null, false);
        this.mListView.addFooterView(this.lyW, null, false);
        this.lyS = new a(this.lst, this.lyX, this.lyY);
        this.mListView.setAdapter(this.lyS);
        this.mListView.setOnItemClickListener(new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                AppMethodBeat.i(19829);
                f uO = ExdeviceBindDeviceUI.this.lyS.uO(i - ((ListView) adapterView).getHeaderViewsCount());
                if (uO.lzC.dFp != 0) {
                    ExdeviceBindDeviceUI.a(ExdeviceBindDeviceUI.this, uO);
                    AppMethodBeat.o(19829);
                    return;
                }
                ExdeviceBindDeviceUI.b(ExdeviceBindDeviceUI.this, uO);
                AppMethodBeat.o(19829);
            }
        });
        if (this.lzd && !this.lzc) {
            if (!com.tencent.mm.plugin.d.a.e.a.dv(this.mController.ylL)) {
                ab.i("MicroMsg.ExdeviceBindDeviceUI", "now sdk version not support ble device : %d", Integer.valueOf(VERSION.SDK_INT));
                uM(4);
                AppMethodBeat.o(19859);
                return;
            } else if (!com.tencent.mm.plugin.d.a.e.a.aVH()) {
                ab.i("MicroMsg.ExdeviceBindDeviceUI", "Bluetooth is not open, Just leave");
                uM(3);
                AppMethodBeat.o(19859);
                return;
            }
        }
        if (!this.lzd && this.lzc && !at.isWifi(this.mController.ylL)) {
            ab.i("MicroMsg.ExdeviceBindDeviceUI", "wifi is not open, Just leave");
            uM(5);
            AppMethodBeat.o(19859);
        } else if (this.lyX == e.SCAN_MY_DEVICE) {
            uM(0);
            AppMethodBeat.o(19859);
        } else {
            if (this.lyX != e.SCAN_CATALOG) {
                e eVar = e.SCAN_ALL;
                Assert.assertTrue(false);
            } else if (this.lzd && this.lzc) {
                Assert.assertTrue(false);
                uM(1);
                AppMethodBeat.o(19859);
                return;
            } else if (this.lzd) {
                uM(2);
                AppMethodBeat.o(19859);
                return;
            } else if (this.lzc) {
                uM(1);
                AppMethodBeat.o(19859);
                return;
            }
            AppMethodBeat.o(19859);
        }
    }

    public void onPause() {
        AppMethodBeat.i(19860);
        super.onPause();
        ab.i("MicroMsg.ExdeviceBindDeviceUI", "onPause stop scan.");
        if (this.lzc) {
            Java2CExDevice.stopScanWCLanDevice();
        }
        if (this.lzd) {
            ad.bpi().stopScan();
        }
        AppMethodBeat.o(19860);
    }

    public void onDestroy() {
        AppMethodBeat.i(19861);
        super.onDestroy();
        if (this.lzc) {
            aw.RS().aa(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(19830);
                    Java2CExDevice.stopScanWCLanDevice();
                    Java2CExDevice.releaseWCLanDeviceLib();
                    AppMethodBeat.o(19830);
                }
            });
            j.boN().b(10, this.ltg);
            j.boN().b(11, this.lzb);
        }
        if (this.lzd) {
            ad.bph().b(this);
            ad.bpi().stopScan();
        }
        aw.Rg().b(1264, (com.tencent.mm.ai.f) this);
        aw.Rg().b(1706, (com.tencent.mm.ai.f) this);
        aw.Rg().b(1270, (com.tencent.mm.ai.f) this);
        aw.Rg().b(1719, (com.tencent.mm.ai.f) this);
        AppMethodBeat.o(19861);
    }

    public final void p(String str, String str2, boolean z) {
        AppMethodBeat.i(19862);
        ab.d("MicroMsg.ExdeviceBindDeviceUI", "onScanResult, broadcastName(%s), mac(%s), isCompleted(%b).", str, str2, Boolean.valueOf(z));
        if (bo.isNullOrNil(str2)) {
            ab.e("MicroMsg.ExdeviceBindDeviceUI", "onScanResult failed, broadcastName(%s), mac(%s), isCompleted(%b).", str, str2, Boolean.valueOf(z));
            AppMethodBeat.o(19862);
            return;
        }
        final f fVar = new f(this, (byte) 0);
        fVar.lzy = b.CONNECT_PROTO_TYPE_BLUE;
        fVar.lzz = new c(this, (byte) 0);
        fVar.lzz.lzs = str;
        fVar.lzz.cbq = com.tencent.mm.plugin.exdevice.j.b.m20if(com.tencent.mm.plugin.exdevice.j.b.KK(str2));
        al.d(new Runnable() {
            public final void run() {
                AppMethodBeat.i(19831);
                ExdeviceBindDeviceUI.this.a(fVar);
                AppMethodBeat.o(19831);
            }
        });
        AppMethodBeat.o(19862);
    }

    public final void c(String str, int i, long j) {
    }

    public final void b(String str, byte[] bArr, boolean z) {
    }

    public void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(19863);
        ab.i("MicroMsg.ExdeviceBindDeviceUI", "onSceneEnd, errType(%d) errCode(%d) errMsg(%s).", Integer.valueOf(i), Integer.valueOf(i2), str);
        if (mVar == null) {
            ab.e("MicroMsg.ExdeviceBindDeviceUI", "onSceneEnd, scene is null.");
            AppMethodBeat.o(19863);
            return;
        }
        final int i3 = i;
        final int i4 = i2;
        final String str2 = str;
        final m mVar2 = mVar;
        al.d(new Runnable() {
            public final void run() {
                AppMethodBeat.i(19832);
                ExdeviceBindDeviceUI.a(ExdeviceBindDeviceUI.this, i3, i4, str2, mVar2);
                AppMethodBeat.o(19832);
            }
        });
        AppMethodBeat.o(19863);
    }

    /* Access modifiers changed, original: final */
    public final void a(f fVar) {
        AppMethodBeat.i(19864);
        if (this.lyS.KB(fVar.getKey())) {
            AppMethodBeat.o(19864);
            return;
        }
        ab.d("MicroMsg.ExdeviceBindDeviceUI", "Add device: " + fVar.bpF());
        a aVar = this.lyS;
        if (!(fVar == null || aVar.KB(fVar.getKey()))) {
            fVar.lzx = aVar.c(fVar);
            aVar.lzl.add(fVar);
        }
        this.lyS.notifyDataSetChanged();
        if (fVar.lzy == b.CONNECT_PROTO_TYPE_BLUE) {
            ab.i("MicroMsg.ExdeviceBindDeviceUI", "NetSceneSearchBLEHardDevice doScene, mac(%s), brandName(%s),categoryId(%s)", fVar.lzz.cbq, this.lst, this.lyY);
            aw.Rg().a(new t(fVar.lzz.cbq, this.lst, this.lyY), 0);
            AppMethodBeat.o(19864);
        } else if (fVar.lzy == b.CONNECT_PROTO_TYPE_WIFI) {
            ab.i("MicroMsg.ExdeviceBindDeviceUI", "NetSceneSearchWiFiHardDevice doScene, deviceType(%s), deviceId(%s)", fVar.lzA.lxI, fVar.lzA.lsu);
            aw.Rg().a(new v(fVar.lzA.lxI, fVar.lzA.lsu, fVar.lzF), 0);
            AppMethodBeat.o(19864);
        } else {
            Assert.assertTrue(false);
            AppMethodBeat.o(19864);
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(19865);
        this.lyS.bpE();
        this.lyS.notifyDataSetChanged();
        AppMethodBeat.o(19865);
    }

    private void uM(int i) {
        AppMethodBeat.i(19866);
        String string;
        String string2;
        SpannableString spannableString;
        switch (i) {
            case 0:
                string = getString(R.string.beu);
                SpannableString spannableString2 = new SpannableString(string);
                spannableString2.setSpan(new ForegroundColorSpan(R.color.t7), 0, string.length(), 33);
                spannableString2.setSpan(new ClickableSpan() {
                    public final void onClick(View view) {
                        AppMethodBeat.i(19833);
                        com.tencent.mm.plugin.exdevice.model.f.ao(ExdeviceBindDeviceUI.this.mController.ylL, "http://o2o.gtimg.com/mydevice/page/deviceHelp.html");
                        AppMethodBeat.o(19833);
                    }

                    public final void updateDrawState(TextPaint textPaint) {
                        AppMethodBeat.i(19834);
                        textPaint.setColor(textPaint.linkColor);
                        textPaint.setUnderlineText(false);
                        AppMethodBeat.o(19834);
                    }
                }, 0, string.length(), 33);
                this.lyU.setMovementMethod(LinkMovementMethod.getInstance());
                this.lyU.setText(spannableString2);
                break;
            case 1:
                string = getString(R.string.bez);
                string2 = getString(R.string.bfr);
                spannableString = new SpannableString(string + string2);
                spannableString.setSpan(new ForegroundColorSpan(R.color.t7), string.length(), string.length() + string2.length(), 33);
                spannableString.setSpan(new ClickableSpan() {
                    public final void onClick(View view) {
                        AppMethodBeat.i(19825);
                        ExdeviceBindDeviceUI.this.finish();
                        AppMethodBeat.o(19825);
                    }

                    public final void updateDrawState(TextPaint textPaint) {
                        AppMethodBeat.i(19826);
                        textPaint.setColor(textPaint.linkColor);
                        textPaint.setUnderlineText(false);
                        AppMethodBeat.o(19826);
                    }
                }, string.length(), string.length() + string2.length(), 33);
                this.lyU.setMovementMethod(LinkMovementMethod.getInstance());
                this.lyU.setText(spannableString);
                break;
            case 2:
                string = getString(R.string.bey);
                string2 = getString(R.string.bev);
                spannableString = new SpannableString(string + string2);
                spannableString.setSpan(new ForegroundColorSpan(R.color.t7), string.length(), string.length() + string2.length(), 33);
                spannableString.setSpan(new ClickableSpan() {
                    public final void onClick(View view) {
                        AppMethodBeat.i(19835);
                        ExdeviceBindDeviceUI.this.finish();
                        AppMethodBeat.o(19835);
                    }

                    public final void updateDrawState(TextPaint textPaint) {
                        AppMethodBeat.i(19836);
                        textPaint.setColor(textPaint.linkColor);
                        textPaint.setUnderlineText(false);
                        AppMethodBeat.o(19836);
                    }
                }, string.length(), string.length() + string2.length(), 33);
                this.lyU.setMovementMethod(LinkMovementMethod.getInstance());
                this.lyU.setText(spannableString);
                break;
        }
        switch (i) {
            case 0:
            case 1:
            case 2:
            case 3:
                this.lyV.setImageResource(R.raw.bluetooth_logo);
                this.lyf.setText(R.string.bf7);
                this.lyg.setText(R.string.ber);
                break;
            case 4:
                this.lyV.setImageResource(R.raw.bluetooth_logo);
                this.lyf.setText(R.string.bf5);
                this.lyg.setText("");
                break;
            case 5:
                this.lyV.setImageResource(R.raw.wifi_logo);
                this.lyf.setText(R.string.bf7);
                this.lyg.setText(R.string.bf2);
                break;
        }
        switch (i) {
            case 0:
            case 1:
            case 2:
                this.lyT.setVisibility(0);
                this.mListView.setVisibility(0);
                this.lyU.setVisibility(0);
                this.lyV.setVisibility(8);
                this.lyf.setVisibility(8);
                this.lyg.setVisibility(8);
                AppMethodBeat.o(19866);
                return;
            case 3:
            case 4:
            case 5:
                this.hJh.setVisibility(8);
                this.lyT.setVisibility(8);
                this.mListView.setVisibility(8);
                this.lyU.setVisibility(8);
                this.lyV.setVisibility(0);
                this.lyf.setVisibility(0);
                if (i != 4) {
                    this.lyg.setVisibility(0);
                    break;
                }
                this.lyg.setVisibility(8);
                AppMethodBeat.o(19866);
                return;
        }
        AppMethodBeat.o(19866);
    }

    static /* synthetic */ void a(ExdeviceBindDeviceUI exdeviceBindDeviceUI, f fVar) {
        AppMethodBeat.i(19867);
        Intent intent = new Intent(exdeviceBindDeviceUI, ExdeviceDeviceProfileUI.class);
        asr asr = fVar.lzC;
        intent.putExtra("device_mac", asr.vKF);
        intent.putExtra("device_brand_name", asr.wwm);
        intent.putExtra("device_desc", asr.wwu);
        intent.putExtra("device_title", asr.wwt);
        intent.putExtra("device_icon_url", asr.IconUrl);
        intent.putExtra("device_alias", asr.guS);
        intent.putExtra("device_jump_url", asr.mZj);
        intent.putExtra("bind_ticket", fVar.lyG);
        intent.putExtra("device_type", fVar.lzB.vIk);
        intent.putExtra("device_id", fVar.lzB.jBE);
        intent.putExtra("hide_device_panel", true);
        intent.putExtra("subscribe_flag", fVar.lzD);
        if (fVar.lzy == b.CONNECT_PROTO_TYPE_BLUE) {
            intent.putExtra("device_ble_simple_proto", asr.dFq);
        } else if (fVar.lzy != b.CONNECT_PROTO_TYPE_WIFI) {
            Assert.assertTrue(false);
            AppMethodBeat.o(19867);
            return;
        }
        exdeviceBindDeviceUI.startActivityForResult(intent, 0);
        AppMethodBeat.o(19867);
    }

    static /* synthetic */ void b(ExdeviceBindDeviceUI exdeviceBindDeviceUI, f fVar) {
        AppMethodBeat.i(19868);
        if (fVar == null) {
            ab.e("MicroMsg.ExdeviceBindDeviceUI", "Device == null");
            AppMethodBeat.o(19868);
        } else if (fVar.lzE == null) {
            ab.e("MicroMsg.ExdeviceBindDeviceUI", "Device.contact == null");
            AppMethodBeat.o(19868);
        } else {
            bbv bbv = fVar.lzE;
            aw.ZK();
            com.tencent.mm.storage.ad aoO = com.tencent.mm.model.c.XM().aoO(aa.a(bbv.wcB));
            Intent intent = new Intent();
            intent.putExtra("device_id", fVar.lzB.jBE);
            intent.putExtra("device_type", fVar.lzB.vIk);
            intent.putExtra("Contact_User", aa.a(bbv.wcB));
            intent.putExtra("Contact_Scene", bbv.wbF);
            intent.putExtra("KIsHardDevice", true);
            intent.putExtra("KHardDeviceBindTicket", fVar.lyG);
            if (aoO != null) {
                if (!com.tencent.mm.n.a.jh(aoO.field_type)) {
                    intent.putExtra("Contact_Alias", bbv.guS);
                    intent.putExtra("Contact_Nick", bbv.wyX.toString());
                    intent.putExtra("Contact_Signature", bbv.guQ);
                    intent.putExtra("Contact_RegionCode", RegionCodeDecoder.aC(bbv.guW, bbv.guO, bbv.guP));
                    intent.putExtra("Contact_Sex", bbv.guN);
                    intent.putExtra("Contact_VUser_Info", bbv.wBU);
                    intent.putExtra("Contact_VUser_Info_Flag", bbv.wBT);
                    intent.putExtra("Contact_KWeibo_flag", bbv.wBX);
                    intent.putExtra("Contact_KWeibo", bbv.wBV);
                    intent.putExtra("Contact_KWeiboNick", bbv.wBW);
                    if (bbv.wCa != null) {
                        try {
                            intent.putExtra("Contact_customInfo", bbv.wCa.toByteArray());
                        } catch (IOException e) {
                            ab.printErrStackTrace("MicroMsg.ExdeviceBindDeviceUI", e, "", new Object[0]);
                        }
                    }
                }
                com.tencent.mm.bp.d.b(exdeviceBindDeviceUI.mController.ylL, Scopes.PROFILE, ".ui.ContactInfoUI", intent);
            }
            AppMethodBeat.o(19868);
        }
    }

    static /* synthetic */ void a(ExdeviceBindDeviceUI exdeviceBindDeviceUI, int i, int i2, String str, m mVar) {
        AppMethodBeat.i(19869);
        f KC;
        if (mVar instanceof p) {
            if (exdeviceBindDeviceUI.ehJ != null && exdeviceBindDeviceUI.ehJ.isShowing()) {
                exdeviceBindDeviceUI.ehJ.dismiss();
            }
            exdeviceBindDeviceUI.lza = false;
            p pVar = (p) mVar;
            if (!(i == 0 && i2 == 0)) {
                ab.e("MicroMsg.ExdeviceBindDeviceUI", "NetSceneGetHardDeviceHelpUrl onSceneEnd, errType(%d) errCode(%d) errMsg(%s).", Integer.valueOf(i), Integer.valueOf(i2), str);
            }
            exdeviceBindDeviceUI.lyZ = ((ajl) pVar.ehh.fsH.fsP).wpj;
            String str2 = exdeviceBindDeviceUI.lyZ;
            if (bo.isNullOrNil(str2)) {
                ab.i("MicroMsg.ExdeviceBindDeviceUI", "Jump to webview failed, url is null or nil.");
                AppMethodBeat.o(19869);
                return;
            }
            Intent intent = new Intent();
            intent.putExtra("rawUrl", str2);
            com.tencent.mm.bp.d.b((Context) exdeviceBindDeviceUI, "webview", ".ui.tools.WebViewUI", intent);
            AppMethodBeat.o(19869);
        } else if (mVar instanceof t) {
            buq boS = ((t) mVar).boS();
            if (i != 0 || i2 != 0) {
                ab.e("MicroMsg.ExdeviceBindDeviceUI", "NetSceneSearchBLEHardDevice onSceneEnd, errType(%d) errCode(%d) errMsg(%s).", Integer.valueOf(i), Integer.valueOf(i2), str);
                AppMethodBeat.o(19869);
            } else if (boS.vLj == null) {
                ab.e("MicroMsg.ExdeviceBindDeviceUI", "HardDeviceAttr is null");
                AppMethodBeat.o(19869);
            } else {
                KC = exdeviceBindDeviceUI.lyS.KC(boS.vLj.vKF);
                if (KC == null) {
                    ab.e("MicroMsg.ExdeviceBindDeviceUI", "DiscoverDevice is null");
                    AppMethodBeat.o(19869);
                } else if (KC.lzB != null) {
                    ab.e("MicroMsg.ExdeviceBindDeviceUI", "DiscoverDevice.mHardDevice is not null");
                    AppMethodBeat.o(19869);
                } else {
                    KC.lzC = boS.vLj;
                    KC.lzB = boS.vLi;
                    KC.lyG = boS.vKK;
                    KC.lzE = boS.vKL;
                    exdeviceBindDeviceUI.lyS.b(KC);
                    exdeviceBindDeviceUI.lyS.notifyDataSetChanged();
                    ab.i("MicroMsg.ExdeviceBindDeviceUI", "NetSceneSearchBLEHardDevice onSceneEnd, deviceType(%s) deviceId(%s), title(%s), mac(%s), isEnterMainDevice(%d).", boS.vLi.vIk, boS.vLi.jBE, boS.vLj.wwt, boS.vLj.vKF, Integer.valueOf(boS.vLj.dFp));
                    AppMethodBeat.o(19869);
                }
            }
        } else {
            if (mVar instanceof v) {
                if (i == 0 && i2 == 0) {
                    bvu bvu = (bvu) ((v) mVar).ehh.fsH.fsP;
                    if (bvu.vLi == null) {
                        ab.e("MicroMsg.ExdeviceBindDeviceUI", "HardDevice info is null");
                        AppMethodBeat.o(19869);
                        return;
                    }
                    a aVar = exdeviceBindDeviceUI.lyS;
                    String str3 = bvu.vLi.vIk;
                    String str4 = bvu.vLi.jBE;
                    if (str3 == null || str3.length() == 0 || str4 == null || str4.length() == 0) {
                        KC = null;
                    } else {
                        int dV = aVar.dV(str3, str4);
                        if (dV < 0) {
                            KC = null;
                        } else {
                            KC = (f) aVar.lzl.get(dV);
                        }
                    }
                    if (KC == null) {
                        ab.e("MicroMsg.ExdeviceBindDeviceUI", "DiscoverDevice is null");
                        AppMethodBeat.o(19869);
                        return;
                    } else if (KC.lzB != null) {
                        ab.e("MicroMsg.ExdeviceBindDeviceUI", "DiscoverDevice.mHardDevice is not null");
                        AppMethodBeat.o(19869);
                        return;
                    } else {
                        KC.lzC = bvu.vLj;
                        KC.lzB = bvu.vLi;
                        KC.lyG = bvu.vKK;
                        KC.lzE = bvu.vKL;
                        exdeviceBindDeviceUI.lyS.b(KC);
                        exdeviceBindDeviceUI.lyS.notifyDataSetChanged();
                        ab.i("MicroMsg.ExdeviceBindDeviceUI", "NetSceneSearchWiFiHardDevice onSceneEnd, deviceType(%s) deviceId(%s), title(%s), isEnterMainDevice(%d).", bvu.vLi.vIk, bvu.vLi.jBE, bvu.vLj.wwt, Integer.valueOf(bvu.vLj.dFp));
                    }
                } else {
                    ab.e("MicroMsg.ExdeviceBindDeviceUI", "NetSceneSearchWiFiHardDevice onSceneEnd, errType(%d) errCode(%d) errMsg(%s).", Integer.valueOf(i), Integer.valueOf(i2), str);
                    AppMethodBeat.o(19869);
                    return;
                }
            }
            AppMethodBeat.o(19869);
        }
    }
}
