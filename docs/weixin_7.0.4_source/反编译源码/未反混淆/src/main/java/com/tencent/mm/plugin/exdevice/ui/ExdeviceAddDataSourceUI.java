package com.tencent.mm.plugin.exdevice.ui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.IntentFilter;
import android.location.LocationManager;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.widget.j;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.at.o;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.g.a.eo;
import com.tencent.mm.g.a.sl;
import com.tencent.mm.model.aw;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.plugin.exdevice.model.e;
import com.tencent.mm.plugin.exdevice.model.l;
import com.tencent.mm.plugin.exdevice.model.t;
import com.tencent.mm.protocal.protobuf.buq;
import com.tencent.mm.protocal.protobuf.jl;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.util.LinkedList;
import java.util.List;

public class ExdeviceAddDataSourceUI extends MMActivity implements f, com.tencent.mm.plugin.exdevice.model.e.b {
    private p ejZ;
    private final BroadcastReceiver jIA = new BroadcastReceiver() {
        public final void onReceive(Context context, Intent intent) {
            AppMethodBeat.i(19777);
            if (intent == null) {
                ab.i("MicroMsg.ExdeviceAddDataSourceUI", "Receive action broadcast failed...");
                AppMethodBeat.o(19777);
                return;
            }
            String action = intent.getAction();
            if ("android.bluetooth.adapter.action.STATE_CHANGED".equals(action)) {
                if (intent.getIntExtra("android.bluetooth.adapter.extra.STATE", j.INVALID_ID) == 12) {
                    if (com.tencent.mm.plugin.d.a.e.a.aVH()) {
                        ExdeviceAddDataSourceUI.this.runOnUiThread(new Runnable() {
                            public final void run() {
                                AppMethodBeat.i(19773);
                                if (!ExdeviceAddDataSourceUI.this.lyj || ExdeviceAddDataSourceUI.this.lyi.isProviderEnabled("gps")) {
                                    ExdeviceAddDataSourceUI.a(ExdeviceAddDataSourceUI.this, 3);
                                    ab.i("MicroMsg.ExdeviceAddDataSourceUI", "Start scan...");
                                    AppMethodBeat.o(19773);
                                    return;
                                }
                                ExdeviceAddDataSourceUI.a(ExdeviceAddDataSourceUI.this, 4);
                                AppMethodBeat.o(19773);
                            }
                        });
                        if (!ExdeviceAddDataSourceUI.this.lyj || ExdeviceAddDataSourceUI.this.lyi.isProviderEnabled("gps")) {
                            ad.bph();
                            e.boJ();
                        }
                    }
                } else if (intent.getIntExtra("android.bluetooth.adapter.extra.STATE", j.INVALID_ID) == 10 && !com.tencent.mm.plugin.d.a.e.a.aVH()) {
                    ExdeviceAddDataSourceUI.this.runOnUiThread(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(19774);
                            ExdeviceAddDataSourceUI.a(ExdeviceAddDataSourceUI.this, 1);
                            ab.i("MicroMsg.ExdeviceAddDataSourceUI", "Stop scan...");
                            AppMethodBeat.o(19774);
                        }
                    });
                    ad.bpi().stopScan();
                }
            }
            if (ExdeviceAddDataSourceUI.this.lyj && "android.location.MODE_CHANGED".equals(action)) {
                if (ExdeviceAddDataSourceUI.this.lyi.isProviderEnabled("gps")) {
                    ExdeviceAddDataSourceUI.this.runOnUiThread(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(19775);
                            if (com.tencent.mm.plugin.d.a.e.a.aVH()) {
                                ExdeviceAddDataSourceUI.a(ExdeviceAddDataSourceUI.this, 3);
                                ab.i("MicroMsg.ExdeviceAddDataSourceUI", "Start scan...");
                                AppMethodBeat.o(19775);
                                return;
                            }
                            ExdeviceAddDataSourceUI.a(ExdeviceAddDataSourceUI.this, 1);
                            AppMethodBeat.o(19775);
                        }
                    });
                    if (com.tencent.mm.plugin.d.a.e.a.aVH()) {
                        ad.bph();
                        e.boJ();
                        AppMethodBeat.o(19777);
                        return;
                    }
                }
                ExdeviceAddDataSourceUI.this.runOnUiThread(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(19776);
                        ExdeviceAddDataSourceUI.a(ExdeviceAddDataSourceUI.this, 4);
                        ab.i("MicroMsg.ExdeviceAddDataSourceUI", "Stop scan...");
                        AppMethodBeat.o(19776);
                    }
                });
                ad.bpi().stopScan();
            }
            AppMethodBeat.o(19777);
        }
    };
    private View kZq;
    private a lyc;
    private List<b> lyd;
    private TextView lye;
    private TextView lyf;
    private TextView lyg;
    private RelativeLayout lyh;
    private LocationManager lyi;
    private boolean lyj = false;
    private l lyk;
    private ListView mListView;

    static class b {
        String cxb;
        public String iconUrl;
        c lys;
        String mac;
        String name;

        private b() {
            this.lys = c.NORMAL;
        }

        /* synthetic */ b(byte b) {
            this();
        }
    }

    enum c {
        NORMAL,
        ADDING,
        ADDED;

        static {
            AppMethodBeat.o(19797);
        }
    }

    static final class a extends BaseAdapter {
        private List<b> lyd = new LinkedList();
        private com.tencent.mm.at.a.a.c lyr;

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
            AppMethodBeat.i(19794);
            b uN = uN(i);
            AppMethodBeat.o(19794);
            return uN;
        }

        public a() {
            AppMethodBeat.i(19788);
            com.tencent.mm.at.a.a.c.a aVar = new com.tencent.mm.at.a.a.c.a();
            aVar.ePT = R.drawable.b2y;
            this.lyr = aVar.ahG();
            AppMethodBeat.o(19788);
        }

        public final void bw(List<b> list) {
            AppMethodBeat.i(19789);
            this.lyd.clear();
            if (list == null || list.size() == 0) {
                AppMethodBeat.o(19789);
                return;
            }
            this.lyd.addAll(list);
            AppMethodBeat.o(19789);
        }

        public final b KA(String str) {
            AppMethodBeat.i(19790);
            if (!bo.isNullOrNil(str)) {
                for (b bVar : this.lyd) {
                    if (str.equalsIgnoreCase(bVar.mac)) {
                        AppMethodBeat.o(19790);
                        return bVar;
                    }
                }
            }
            AppMethodBeat.o(19790);
            return null;
        }

        public final int getCount() {
            AppMethodBeat.i(19791);
            int size = this.lyd.size();
            AppMethodBeat.o(19791);
            return size;
        }

        public final b uN(int i) {
            AppMethodBeat.i(19792);
            b bVar = (b) this.lyd.get(i);
            AppMethodBeat.o(19792);
            return bVar;
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            a aVar;
            AppMethodBeat.i(19793);
            b uN = uN(i);
            if (view == null) {
                a aVar2 = new a();
                view = View.inflate(viewGroup.getContext(), R.layout.vo, null);
                aVar2.iqT = (ImageView) view.findViewById(R.id.bi9);
                aVar2.gxi = (TextView) view.findViewById(R.id.bi_);
                view.setTag(aVar2);
                aVar = aVar2;
            } else {
                aVar = (a) view.getTag();
            }
            ab.d("MicroMsg.ExdeviceAddDataSourceUI", "position(%s), name(%s), mac(%s).", Integer.valueOf(i), uN.name, uN.mac);
            aVar.gxi.setText(uN.name);
            o.ahp().a(uN.iconUrl, aVar.iqT, this.lyr);
            AppMethodBeat.o(19793);
            return view;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public ExdeviceAddDataSourceUI() {
        AppMethodBeat.i(19798);
        AppMethodBeat.o(19798);
    }

    static /* synthetic */ boolean Kz(String str) {
        AppMethodBeat.i(19809);
        boolean aC = aC(str, true);
        AppMethodBeat.o(19809);
        return aC;
    }

    public final int getLayoutId() {
        return R.layout.vp;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(19799);
        super.onCreate(bundle);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(19769);
                ExdeviceAddDataSourceUI.this.finish();
                AppMethodBeat.o(19769);
                return true;
            }
        });
        setMMTitle((int) R.string.beg);
        if (!(!d.iW(23) || VERSION.RELEASE.equalsIgnoreCase("6.0") || VERSION.RELEASE.equalsIgnoreCase("6.0.0"))) {
            this.lyj = true;
        }
        this.lyd = new LinkedList();
        this.lyi = (LocationManager) this.mController.ylL.getSystemService(com.google.firebase.analytics.FirebaseAnalytics.b.LOCATION);
        initView();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
        intentFilter.addAction("android.location.MODE_CHANGED");
        this.mController.ylL.registerReceiver(this.jIA, intentFilter);
        aw.Rg().a(536, (f) this);
        aw.Rg().a(1706, (f) this);
        ad.bph().a((com.tencent.mm.plugin.exdevice.model.e.b) this);
        if (!com.tencent.mm.plugin.d.a.e.a.dv(this.mController.ylL)) {
            ab.i("MicroMsg.ExdeviceAddDataSourceUI", "now sdk version not support ble device : %d", Integer.valueOf(VERSION.SDK_INT));
            uM(2);
            AppMethodBeat.o(19799);
        } else if (!com.tencent.mm.plugin.d.a.e.a.aVH()) {
            ab.i("MicroMsg.ExdeviceAddDataSourceUI", "Bluetooth is not open, Just leave");
            uM(1);
            AppMethodBeat.o(19799);
        } else if (this.lyi == null || !this.lyj || this.lyi.isProviderEnabled("gps")) {
            ad.bph();
            e.boJ();
            AppMethodBeat.o(19799);
        } else {
            ab.i("MicroMsg.ExdeviceAddDataSourceUI", "Android 6.0.1, gps not open");
            uM(4);
            AppMethodBeat.o(19799);
        }
    }

    private void uM(int i) {
        AppMethodBeat.i(19800);
        switch (i) {
            case 1:
                this.lyh.setVisibility(8);
                this.lyf.setText(R.string.bf7);
                this.lyg.setText(R.string.ber);
                AppMethodBeat.o(19800);
                return;
            case 2:
                this.lyh.setVisibility(8);
                this.lyf.setText(R.string.bf5);
                this.lyg.setText("");
                AppMethodBeat.o(19800);
                return;
            case 3:
                this.lyh.setVisibility(0);
                this.kZq.setVisibility(0);
                break;
            case 4:
                this.lyh.setVisibility(8);
                this.lyf.setText(R.string.bf7);
                this.lyg.setText(R.string.bgh);
                AppMethodBeat.o(19800);
                return;
        }
        AppMethodBeat.o(19800);
    }

    public final void initView() {
        AppMethodBeat.i(19801);
        this.mListView = (ListView) findViewById(R.id.a46);
        View inflate = View.inflate(this, R.layout.vr, null);
        this.lyh = (RelativeLayout) findViewById(R.id.bid);
        this.kZq = View.inflate(this, R.layout.vq, null);
        this.lye = (TextView) findViewById(R.id.bie);
        this.lyf = (TextView) findViewById(R.id.bib);
        this.lyg = (TextView) findViewById(R.id.bic);
        String string = getString(R.string.bhw);
        String string2 = getString(R.string.bfl);
        SpannableString spannableString = new SpannableString(string + string2);
        spannableString.setSpan(new ForegroundColorSpan(R.color.t7), string.length(), string.length() + string2.length(), 33);
        spannableString.setSpan(new ClickableSpan() {
            public final void onClick(View view) {
                AppMethodBeat.i(19778);
                com.tencent.mm.plugin.exdevice.model.f.ao(ExdeviceAddDataSourceUI.this.mController.ylL, "https://hw.weixin.qq.com/steprank/step/connect-help.html");
                AppMethodBeat.o(19778);
            }

            public final void updateDrawState(TextPaint textPaint) {
                AppMethodBeat.i(19779);
                textPaint.setColor(textPaint.linkColor);
                textPaint.setUnderlineText(false);
                AppMethodBeat.o(19779);
            }
        }, string.length(), string.length() + string2.length(), 33);
        this.lye.setMovementMethod(LinkMovementMethod.getInstance());
        this.lye.setText(spannableString);
        this.mListView.addHeaderView(inflate, null, false);
        this.mListView.addFooterView(this.kZq, null, false);
        this.lyc = new a();
        this.mListView.setAdapter(this.lyc);
        this.mListView.setOnItemClickListener(new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                AppMethodBeat.i(19780);
                b uN = ExdeviceAddDataSourceUI.this.lyc.uN(i - ((ListView) adapterView).getHeaderViewsCount());
                if (uN.lys != c.NORMAL) {
                    AppMethodBeat.o(19780);
                } else if (ExdeviceAddDataSourceUI.Kz(uN.mac)) {
                    ExdeviceAddDataSourceUI.a(ExdeviceAddDataSourceUI.this, uN.mac);
                    uN.lys = c.ADDING;
                    ExdeviceAddDataSourceUI.this.lyc.notifyDataSetChanged();
                    AppMethodBeat.o(19780);
                } else {
                    ab.i("MicroMsg.ExdeviceAddDataSourceUI", "try connect device failed.");
                    AppMethodBeat.o(19780);
                }
            }
        });
        AppMethodBeat.o(19801);
    }

    public void onDestroy() {
        AppMethodBeat.i(19802);
        super.onDestroy();
        aw.RS().aa(new Runnable() {
            public final void run() {
                AppMethodBeat.i(19781);
                ab.d("MicroMsg.ExdeviceAddDataSourceUI", "stopAllChannelEvent! ");
                com.tencent.mm.sdk.b.a.xxA.m(new sl());
                AppMethodBeat.o(19781);
            }
        });
        aw.Rg().b(536, (f) this);
        aw.Rg().b(1706, (f) this);
        this.mController.ylL.unregisterReceiver(this.jIA);
        ad.bph().b(this);
        ad.bpi().stopScan();
        AppMethodBeat.o(19802);
    }

    public void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(19803);
        ab.i("MicroMsg.ExdeviceAddDataSourceUI", "errType(%d), errCode(%d), errMsg(%s).", Integer.valueOf(i), Integer.valueOf(i2), str);
        if (mVar == null) {
            ab.e("MicroMsg.ExdeviceAddDataSourceUI", "netscene is null.");
            AppMethodBeat.o(19803);
        } else if (mVar.getType() == 536) {
            bpD();
            this.lyk = null;
            jl boP = ((l) mVar).boP();
            if (i == 0 && i2 == 0) {
                Intent intent = new Intent();
                intent.putExtra("device_mac", com.tencent.mm.plugin.exdevice.j.b.KK(com.tencent.mm.plugin.exdevice.j.b.KL(boP.vLj.vKF)));
                aC(com.tencent.mm.plugin.exdevice.j.b.KL(boP.vLj.vKF), false);
                setResult(-1, intent);
                finish();
                AppMethodBeat.o(19803);
                return;
            }
            b KA = this.lyc.KA(com.tencent.mm.plugin.exdevice.j.b.KL(boP.vLj.vKF));
            if (KA != null) {
                KA.lys = c.NORMAL;
                aC(KA.mac, false);
            }
            ab.e("MicroMsg.ExdeviceAddDataSourceUI", "doScene failed.");
            AppMethodBeat.o(19803);
        } else {
            if (mVar.getType() == 1706) {
                buq boS = ((t) mVar).boS();
                if (i == 0 && i2 == 0) {
                    ab.i("MicroMsg.ExdeviceAddDataSourceUI", "HardDeviceAttr_bleSimpleProtol(%d)", Long.valueOf(boS.vLj.dFq));
                    if (0 != (boS.vLj.dFq & 1)) {
                        if (ad.boW().dS(boS.vLi.jBE, boS.vLi.vIk) != null) {
                            ab.i("MicroMsg.ExdeviceAddDataSourceUI", "(%s)has been bound.", boS.vLj.vKF);
                            AppMethodBeat.o(19803);
                            return;
                        }
                        b bVar = new b();
                        bVar.name = boS.vKL.wyX == null ? "" : aa.a(boS.vKL.wyX);
                        bVar.mac = com.tencent.mm.plugin.exdevice.j.b.KL(boS.vLj.vKF);
                        bVar.cxb = boS.vKK;
                        bVar.iconUrl = boS.vLj.IconUrl;
                        this.lyd.add(bVar);
                        ab.i("MicroMsg.ExdeviceAddDataSourceUI", "Add device, mac(%s), name(%s)", bVar.mac, bVar.name);
                        runOnUiThread(new Runnable() {
                            public final void run() {
                                AppMethodBeat.i(19782);
                                ExdeviceAddDataSourceUI.this.lyc.bw(ExdeviceAddDataSourceUI.this.lyd);
                                ExdeviceAddDataSourceUI.this.lyc.notifyDataSetChanged();
                                AppMethodBeat.o(19782);
                            }
                        });
                    }
                } else {
                    ab.e("MicroMsg.ExdeviceAddDataSourceUI", "NetSceneSearchBLEHardDevice onSceneEnd, errType(%d) errCode(%d) errMsg(%s).", Integer.valueOf(i), Integer.valueOf(i2), str);
                    AppMethodBeat.o(19803);
                    return;
                }
            }
            AppMethodBeat.o(19803);
        }
    }

    public final void p(String str, String str2, boolean z) {
        AppMethodBeat.i(19804);
        ab.d("MicroMsg.ExdeviceAddDataSourceUI", "onScanResult, broadcastName(%s), mac(%s), isCompleted(%b).", str, str2, Boolean.valueOf(z));
        if (z) {
            runOnUiThread(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(19783);
                    ExdeviceAddDataSourceUI.this.kZq.setVisibility(8);
                    ExdeviceAddDataSourceUI.this.lyc.notifyDataSetChanged();
                    AppMethodBeat.o(19783);
                }
            });
        }
        if (bo.isNullOrNil(str2)) {
            ab.e("MicroMsg.ExdeviceAddDataSourceUI", "onScanResult failed, broadcastName(%s), mac(%s), isCompleted(%b).", str, str2, Boolean.valueOf(z));
            AppMethodBeat.o(19804);
            return;
        }
        int i = 0;
        while (i < this.lyd.size()) {
            int i2;
            b bVar = (b) this.lyd.get(i);
            if (bVar == null || bo.isNullOrNil(bVar.mac)) {
                i2 = i - 1;
                this.lyd.remove(i);
            } else if (bVar.mac.equalsIgnoreCase(str2)) {
                ab.i("MicroMsg.ExdeviceAddDataSourceUI", "the device(%s) has added into the list before.", str2);
                AppMethodBeat.o(19804);
                return;
            } else {
                i2 = i;
            }
            i = i2 + 1;
        }
        boolean a = aw.Rg().a(new t(str2.replaceAll(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D, ""), null, null), 0);
        ab.i("MicroMsg.ExdeviceAddDataSourceUI", "SearchBLEHardDevice doScene result(%s), mac(%s)", Boolean.valueOf(a), str2);
        AppMethodBeat.o(19804);
    }

    public final void c(String str, int i, long j) {
        AppMethodBeat.i(19805);
        if (bo.isNullOrNil(str)) {
            ab.e("MicroMsg.ExdeviceAddDataSourceUI", "onConnectStateChanged, mac is null or nil.");
            AppMethodBeat.o(19805);
            return;
        }
        final b KA = this.lyc.KA(str);
        if (KA == null) {
            ab.w("MicroMsg.ExdeviceAddDataSourceUI", "onConnectStateChanged, info is null.(%s)", str);
            AppMethodBeat.o(19805);
            return;
        }
        if (KA.lys == c.ADDING && i == 4) {
            KA.lys = c.NORMAL;
            bpD();
            runOnUiThread(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(19786);
                    h.a(ExdeviceAddDataSourceUI.this, (int) R.string.bfo, (int) R.string.bfm, (int) R.string.bfn, (int) R.string.bfp, false, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.i(19784);
                            ExdeviceAddDataSourceUI.this.lyd.remove(KA);
                            ExdeviceAddDataSourceUI.this.lyc.bw(ExdeviceAddDataSourceUI.this.lyd);
                            ExdeviceAddDataSourceUI.this.lyc.notifyDataSetChanged();
                            AppMethodBeat.o(19784);
                        }
                    }, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.i(19785);
                            com.tencent.mm.plugin.exdevice.model.f.ao(ExdeviceAddDataSourceUI.this.mController.ylL, "https://hw.weixin.qq.com/steprank/step/connect-help.html");
                            AppMethodBeat.o(19785);
                        }
                    }).show();
                    AppMethodBeat.o(19786);
                }
            });
        } else if (i == 2) {
            if (KA.lys == c.ADDING) {
                KA.lys = c.ADDED;
                ab.i("MicroMsg.ExdeviceAddDataSourceUI", "Bind Hard device, mac(%s), name(%s)", KA.mac, KA.name);
                if (KA.cxb != null) {
                    this.lyk = new l(KA.cxb, 0);
                    aw.Rg().a(this.lyk, 0);
                }
            } else {
                ab.i("MicroMsg.ExdeviceAddDataSourceUI", "try to disconnect, mac : %s.", str);
                aC(str, false);
            }
        } else if (i == 1 || i == 2) {
            AppMethodBeat.o(19805);
            return;
        } else {
            KA.lys = c.NORMAL;
        }
        runOnUiThread(new Runnable() {
            public final void run() {
                AppMethodBeat.i(19787);
                ExdeviceAddDataSourceUI.this.lyc.notifyDataSetChanged();
                AppMethodBeat.o(19787);
            }
        });
        AppMethodBeat.o(19805);
    }

    public final void b(String str, byte[] bArr, boolean z) {
    }

    private static boolean aC(String str, boolean z) {
        AppMethodBeat.i(19806);
        eo eoVar = new eo();
        eoVar.cye.mac = str;
        eoVar.cye.cwA = z;
        if (com.tencent.mm.sdk.b.a.xxA.m(eoVar)) {
            AppMethodBeat.o(19806);
            return true;
        }
        ab.i("MicroMsg.ExdeviceAddDataSourceUI", "connect failed, mac(%s).", str);
        AppMethodBeat.o(19806);
        return false;
    }

    private void bpD() {
        AppMethodBeat.i(19807);
        runOnUiThread(new Runnable() {
            public final void run() {
                AppMethodBeat.i(19770);
                if (ExdeviceAddDataSourceUI.this.ejZ != null && ExdeviceAddDataSourceUI.this.ejZ.isShowing()) {
                    ExdeviceAddDataSourceUI.this.ejZ.dismiss();
                }
                AppMethodBeat.o(19770);
            }
        });
        AppMethodBeat.o(19807);
    }
}
