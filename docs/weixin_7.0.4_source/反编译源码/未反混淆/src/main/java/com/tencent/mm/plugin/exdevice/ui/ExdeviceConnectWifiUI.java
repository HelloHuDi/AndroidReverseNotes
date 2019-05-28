package com.tencent.mm.plugin.exdevice.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.wifi.WifiManager;
import android.net.wifi.WifiManager.MulticastLock;
import android.os.Bundle;
import android.text.Editable;
import android.text.Selection;
import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.util.Base64;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import android.view.View.OnTouchListener;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import android.widget.Toast;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.bp.d;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.network.n;
import com.tencent.mm.plugin.exdevice.jni.Java2CExDevice;
import com.tencent.mm.plugin.exdevice.model.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.vfs.e;
import java.io.IOException;

public class ExdeviceConnectWifiUI extends MMActivity {
    private TextWatcher arx;
    private EditText gBJ;
    private String kWl = "";
    private b lAa;
    private n lAb;
    private com.tencent.mm.plugin.exdevice.model.j.a lAc;
    private MulticastLock lAd;
    private Runnable lAe = new Runnable() {
        public final void run() {
            AppMethodBeat.i(19871);
            if (bo.isNullOrNil(ExdeviceConnectWifiUI.a(ExdeviceConnectWifiUI.this))) {
                ExdeviceConnectWifiUI.this.gBJ.setText(ExdeviceConnectWifiUI.this.lzM.luH);
                Editable text = ExdeviceConnectWifiUI.this.gBJ.getText();
                if (text != null) {
                    Selection.setSelection(text, text.length());
                }
                AppMethodBeat.o(19871);
                return;
            }
            ab.i("MicroMsg.exdevice.ExdeviceConnectWifiUI", "User has input password.");
            AppMethodBeat.o(19871);
        }
    };
    private View lzG;
    private TextView lzH;
    private View lzI;
    private View lzJ;
    private p lzK;
    private String lzL;
    private com.tencent.mm.plugin.exdevice.d.a lzM;
    private boolean lzN;
    private boolean lzO;
    private boolean lzP;
    private int lzQ;
    private byte[] lzR;
    private int lzS;
    private int lzT;
    private int lzU;
    private String lzV = "";
    private int lzW;
    private long lzX;
    boolean lzY = false;
    private com.tencent.mm.plugin.exdevice.d.b lzZ;

    static class a {
        public static String av(int i, String str) {
            AppMethodBeat.i(19892);
            if (bo.isNullOrNil(str)) {
                AppMethodBeat.o(19892);
                return null;
            }
            String str2 = i + "@" + str.hashCode();
            AppMethodBeat.o(19892);
            return str2;
        }
    }

    public enum b {
        NORMAL,
        NO_WIFI_CONNECTED,
        SETTING,
        FINISH,
        TIMEOUT;

        static {
            AppMethodBeat.o(19895);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public ExdeviceConnectWifiUI() {
        AppMethodBeat.i(19896);
        AppMethodBeat.o(19896);
    }

    static /* synthetic */ void e(ExdeviceConnectWifiUI exdeviceConnectWifiUI) {
        AppMethodBeat.i(19912);
        exdeviceConnectWifiUI.gO(true);
        AppMethodBeat.o(19912);
    }

    static /* synthetic */ void p(ExdeviceConnectWifiUI exdeviceConnectWifiUI) {
        AppMethodBeat.i(19914);
        exdeviceConnectWifiUI.bpG();
        AppMethodBeat.o(19914);
    }

    public final int getLayoutId() {
        return R.layout.vy;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(19897);
        super.onCreate(bundle);
        this.lAb = new com.tencent.mm.network.n.a() {
            public final void gl(int i) {
                AppMethodBeat.i(19881);
                al.d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(19880);
                        if (ExdeviceConnectWifiUI.this.lAa != b.FINISH) {
                            ExdeviceConnectWifiUI.e(ExdeviceConnectWifiUI.this);
                        }
                        AppMethodBeat.o(19880);
                    }
                });
                AppMethodBeat.o(19881);
            }
        };
        this.lAa = b.NORMAL;
        if (aw.RK()) {
            this.lzZ = new com.tencent.mm.plugin.exdevice.d.b();
            this.lzM = new com.tencent.mm.plugin.exdevice.d.a();
            aw.ZK();
            this.lzQ = c.QF();
            String stringExtra = getIntent().getStringExtra("encryptKey");
            this.lzS = getIntent().getIntExtra("procInterval", 0);
            this.lzT = getIntent().getIntExtra("dataInterval", 0);
            ab.d("MicroMsg.exdevice.ExdeviceConnectWifiUI", "Process interval:" + this.lzS + " Data interval:" + this.lzT);
            if (!bo.isNullOrNil(stringExtra)) {
                this.lzR = Base64.decode(stringExtra, 0);
                this.lzW = 1;
            }
            this.lzY = false;
            this.lzU = getIntent().getExtras().getInt("exdevice_airkiss_open_type");
            if (this.lzU == 2) {
                this.lzV = getIntent().getStringExtra("device_brand_name");
                this.kWl = getIntent().getStringExtra("device_category_id");
            }
            this.lAc = new com.tencent.mm.plugin.exdevice.model.j.a() {
                public final void g(int i, Object... objArr) {
                    AppMethodBeat.i(19885);
                    if (i == 0 && objArr != null && objArr.length >= 2 && (objArr[0] instanceof Integer) && (objArr[1] instanceof Integer)) {
                        int intValue = ((Integer) objArr[0]).intValue();
                        int intValue2 = ((Integer) objArr[1]).intValue();
                        if (ExdeviceConnectWifiUI.this.lAd.isHeld()) {
                            ExdeviceConnectWifiUI.this.lAd.release();
                        }
                        ab.i("MicroMsg.exdevice.ExdeviceConnectWifiUI", "AirKiss jni callback (%d, %d)", Integer.valueOf(intValue), Integer.valueOf(intValue2));
                        if (intValue == 0 && intValue2 == 0) {
                            al.d(new Runnable() {
                                public final void run() {
                                    AppMethodBeat.i(19882);
                                    ExdeviceConnectWifiUI.this.a(b.FINISH);
                                    AppMethodBeat.o(19882);
                                }
                            });
                            AppMethodBeat.o(19885);
                            return;
                        }
                        ExdeviceConnectWifiUI.this.runOnUiThread(new Runnable() {
                            public final void run() {
                                AppMethodBeat.i(19884);
                                ExdeviceConnectWifiUI.this.lzK.dismiss();
                                h.a(ExdeviceConnectWifiUI.this.mController.ylL, ExdeviceConnectWifiUI.this.mController.ylL.getString(R.string.bec), "", ExdeviceConnectWifiUI.this.mController.ylL.getString(R.string.bfn), "", false, new OnClickListener() {
                                    public final void onClick(DialogInterface dialogInterface, int i) {
                                        AppMethodBeat.i(19883);
                                        ExdeviceConnectWifiUI.this.a(b.TIMEOUT);
                                        AppMethodBeat.o(19883);
                                    }
                                }, null).show();
                                AppMethodBeat.o(19884);
                            }
                        });
                        AppMethodBeat.o(19885);
                        return;
                    }
                    AppMethodBeat.o(19885);
                }
            };
            j.boN().a(0, this.lAc);
            initView();
            aw.RS().aa(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(19874);
                    try {
                        StringBuilder stringBuilder = new StringBuilder();
                        aw.ZK();
                        byte[] e = e.e(stringBuilder.append(c.getAccPath()).append("exdevice_wifi_infos").toString(), 0, BaseClientBuilder.API_PRIORITY_OTHER);
                        if (e != null) {
                            ExdeviceConnectWifiUI.this.lzZ.parseFrom(e);
                            ExdeviceConnectWifiUI.p(ExdeviceConnectWifiUI.this);
                        }
                    } catch (Exception e2) {
                        ab.d("MicroMsg.exdevice.ExdeviceConnectWifiUI", e2.getMessage());
                        ab.printErrStackTrace("MicroMsg.exdevice.ExdeviceConnectWifiUI", e2, "", new Object[0]);
                    }
                    al.n(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(19873);
                            ExdeviceConnectWifiUI.this.showVKB();
                            AppMethodBeat.o(19873);
                        }
                    }, 500);
                    AppMethodBeat.o(19874);
                }
            });
            uP(1);
            this.lAd = ((WifiManager) getApplicationContext().getSystemService("wifi")).createMulticastLock("localWifi");
            AppMethodBeat.o(19897);
            return;
        }
        finish();
        AppMethodBeat.o(19897);
    }

    public void onResume() {
        AppMethodBeat.i(19898);
        super.onResume();
        gO(false);
        aw.a(this.lAb);
        if (this.lzO) {
            bpG();
            this.lzO = false;
        }
        AppMethodBeat.o(19898);
    }

    public void onDestroy() {
        AppMethodBeat.i(19899);
        super.onDestroy();
        if (!this.lzY) {
            uP(2);
        }
        j.boN().b(0, this.lAc);
        AppMethodBeat.o(19899);
    }

    public void onStop() {
        AppMethodBeat.i(19900);
        super.onStop();
        aw.b(this.lAb);
        AppMethodBeat.o(19900);
    }

    public final void initView() {
        AppMethodBeat.i(19901);
        setMMTitle((int) R.string.bfr);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(19886);
                if (!ExdeviceConnectWifiUI.this.lzP) {
                    boolean z;
                    Intent intent = new Intent();
                    String str = "is_wifi_connected";
                    if (ExdeviceConnectWifiUI.this.lAa != b.NO_WIFI_CONNECTED) {
                        z = true;
                    } else {
                        z = false;
                    }
                    intent.putExtra(str, z);
                    ExdeviceConnectWifiUI.this.setResult(0, intent);
                    ExdeviceConnectWifiUI.this.finish();
                }
                AppMethodBeat.o(19886);
                return false;
            }
        });
        this.lzG = findViewById(R.id.bir);
        this.lzH = (TextView) findViewById(R.id.bi_);
        this.lzI = findViewById(R.id.bit);
        this.gBJ = (EditText) findViewById(R.id.bis);
        this.lzJ = findViewById(R.id.biw);
        this.arx = new TextWatcher() {
            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void afterTextChanged(Editable editable) {
                AppMethodBeat.i(19887);
                if (editable.length() > 31) {
                    ExdeviceConnectWifiUI.this.lzI.setVisibility(0);
                    ExdeviceConnectWifiUI.this.lzJ.setEnabled(false);
                    AppMethodBeat.o(19887);
                    return;
                }
                ExdeviceConnectWifiUI.this.lzI.setVisibility(8);
                ExdeviceConnectWifiUI.this.lzJ.setEnabled(true);
                AppMethodBeat.o(19887);
            }
        };
        this.lzG.setOnTouchListener(new OnTouchListener() {
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(19888);
                ExdeviceConnectWifiUI.this.gBJ.clearFocus();
                ExdeviceConnectWifiUI.this.aqX();
                AppMethodBeat.o(19888);
                return false;
            }
        });
        this.lzJ.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(19889);
                ab.i("MicroMsg.exdevice.ExdeviceConnectWifiUI", "onClick connectBtn.");
                ExdeviceConnectWifiUI.k(ExdeviceConnectWifiUI.this);
                AppMethodBeat.o(19889);
            }
        });
        this.gBJ.setTransformationMethod(new PasswordTransformationMethod());
        this.gBJ.addTextChangedListener(this.arx);
        this.gBJ.setOnEditorActionListener(new OnEditorActionListener() {
            public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                AppMethodBeat.i(19890);
                if (i == 6 || i == 5) {
                    ab.i("MicroMsg.exdevice.ExdeviceConnectWifiUI", "on next Key down.");
                    ExdeviceConnectWifiUI.k(ExdeviceConnectWifiUI.this);
                    AppMethodBeat.o(19890);
                    return true;
                }
                AppMethodBeat.o(19890);
                return false;
            }
        });
        this.gBJ.setOnKeyListener(new OnKeyListener() {
            public final boolean onKey(View view, int i, KeyEvent keyEvent) {
                AppMethodBeat.i(19891);
                if (66 == i && keyEvent.getAction() == 0) {
                    ExdeviceConnectWifiUI.k(ExdeviceConnectWifiUI.this);
                    AppMethodBeat.o(19891);
                    return true;
                }
                AppMethodBeat.o(19891);
                return false;
            }
        });
        this.gBJ.requestFocus();
        AppMethodBeat.o(19901);
    }

    private void uP(int i) {
        AppMethodBeat.i(19902);
        long j = 0;
        if (i == 4) {
            j = System.currentTimeMillis() - this.lzX;
        }
        com.tencent.mm.plugin.report.service.h.pYm.e(13503, Integer.valueOf(i), Integer.valueOf(this.lzU), Long.valueOf(j), this.lzV, this.kWl, Integer.valueOf(this.lzW));
        AppMethodBeat.o(19902);
    }

    private com.tencent.mm.plugin.exdevice.d.a au(int i, String str) {
        AppMethodBeat.i(19903);
        if (bo.isNullOrNil(str) || this.lzZ == null) {
            ab.i("MicroMsg.exdevice.ExdeviceConnectWifiUI", "ssid or wifiInfoList is null or nil.");
            AppMethodBeat.o(19903);
            return null;
        }
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.lzZ.luI.size()) {
                com.tencent.mm.plugin.exdevice.d.a aVar = (com.tencent.mm.plugin.exdevice.d.a) this.lzZ.luI.get(i3);
                if (aVar == null) {
                    i2 = i3 - 1;
                    this.lzZ.luI.remove(i3);
                    this.lzN = true;
                    i3 = i2;
                } else if (aVar.luF == i && str.equals(aVar.luG)) {
                    AppMethodBeat.o(19903);
                    return aVar;
                }
                i2 = i3 + 1;
            } else {
                AppMethodBeat.o(19903);
                return null;
            }
        }
    }

    private void bpG() {
        AppMethodBeat.i(19904);
        this.lzM.luH = "";
        this.lzM.luG = "";
        String str = this.lzL;
        com.tencent.mm.plugin.exdevice.d.a au = au(this.lzQ, str);
        if (au == null || bo.isNullOrNil(str)) {
            AppMethodBeat.o(19904);
        } else if (bo.isNullOrNil(au.luH)) {
            ab.i("MicroMsg.exdevice.ExdeviceConnectWifiUI", "Do not have a local password to fill for the current wifi.");
            this.lzZ.luI.remove(au);
            this.lzN = true;
            AppMethodBeat.o(19904);
        } else {
            this.lzM.luH = com.tencent.mm.plugin.base.model.b.da(au.luH, a.av(this.lzQ, au.luG));
            this.lzM.luG = au.luG;
            al.d(this.lAe);
            AppMethodBeat.o(19904);
        }
    }

    private String getPassword() {
        AppMethodBeat.i(19905);
        if (this.gBJ.getText() != null) {
            String obj = this.gBJ.getText().toString();
            AppMethodBeat.o(19905);
            return obj;
        }
        AppMethodBeat.o(19905);
        return null;
    }

    private void gO(boolean z) {
        AppMethodBeat.i(19906);
        b bVar = z ? b.NORMAL : this.lAa;
        if (at.getNetType(this) != 0) {
            bVar = b.NO_WIFI_CONNECTED;
        } else {
            this.lzL = at.gE(ah.getContext());
            ab.i("MicroMsg.exdevice.ExdeviceConnectWifiUI", "Get SSID(%s)", this.lzL);
            if (bo.isNullOrNil(this.lzL)) {
                this.lzH.setText("");
            } else {
                this.lzH.setText(this.lzL);
            }
        }
        a(bVar);
        AppMethodBeat.o(19906);
    }

    public final synchronized void a(b bVar) {
        AppMethodBeat.i(19907);
        if (bVar == null) {
            ab.e("MicroMsg.exdevice.ExdeviceConnectWifiUI", "Status is null.");
            AppMethodBeat.o(19907);
        } else {
            this.lAa = bVar;
            switch (bVar) {
                case NORMAL:
                    g(true, false, false);
                    break;
                case SETTING:
                    g(true, true, false);
                    break;
                case NO_WIFI_CONNECTED:
                    g(false, false, false);
                    break;
                case TIMEOUT:
                    uP(5);
                    this.lzP = true;
                    setResult(1);
                    break;
                case FINISH:
                    uP(4);
                    g(true, false, true);
                    this.lzP = true;
                    setResult(-1);
                    aw.RS().aa(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(19875);
                            ExdeviceConnectWifiUI.q(ExdeviceConnectWifiUI.this);
                            AppMethodBeat.o(19875);
                        }
                    });
                    if (getIntent().getBooleanExtra("jumpToBindDevice", false)) {
                        Intent intent = new Intent();
                        intent.putExtra("device_scan_mode", getIntent().getStringExtra("device_scan_mode"));
                        intent.putExtra("device_scan_conn_proto", getIntent().getStringExtra("device_scan_conn_proto"));
                        intent.putExtra("device_id", getIntent().getStringExtra("device_id"));
                        intent.putExtra("device_type", getIntent().getStringExtra("device_type"));
                        intent.putExtra("device_title", getIntent().getStringExtra("device_title"));
                        intent.putExtra("device_desc", getIntent().getStringExtra("device_desc"));
                        intent.putExtra("device_icon_url", getIntent().getStringExtra("device_icon_url"));
                        intent.putExtra("device_category_id", getIntent().getStringExtra("device_category_id"));
                        intent.putExtra("device_brand_name", getIntent().getStringExtra("device_brand_name"));
                        intent.putExtra("bind_ticket", getIntent().getStringExtra("bind_ticket"));
                        d.b(this.mController.ylL, "exdevice", ".ui.ExdeviceBindDeviceUI", intent);
                        break;
                    }
                    break;
            }
            finish();
            if (bVar != b.NORMAL) {
                this.gBJ.clearFocus();
                aqX();
            }
            AppMethodBeat.o(19907);
        }
    }

    private void bpH() {
        AppMethodBeat.i(19908);
        runOnUiThread(new Runnable() {
            public final void run() {
                AppMethodBeat.i(19877);
                ExdeviceConnectWifiUI exdeviceConnectWifiUI = ExdeviceConnectWifiUI.this;
                Context context = ExdeviceConnectWifiUI.this.mController.ylL;
                ExdeviceConnectWifiUI.this.getString(R.string.tz);
                exdeviceConnectWifiUI.lzK = h.b(context, ExdeviceConnectWifiUI.this.getString(R.string.bi4), true, new OnCancelListener() {
                    public final void onCancel(DialogInterface dialogInterface) {
                        AppMethodBeat.i(19876);
                        ab.i("MicroMsg.exdevice.ExdeviceConnectWifiUI", "On progress cancel, stop airkiss");
                        if (ExdeviceConnectWifiUI.this.lAa != b.FINISH) {
                            ExdeviceConnectWifiUI.r(ExdeviceConnectWifiUI.this);
                        }
                        AppMethodBeat.o(19876);
                    }
                });
                AppMethodBeat.o(19877);
            }
        });
        AppMethodBeat.o(19908);
    }

    private void bpD() {
        AppMethodBeat.i(19909);
        runOnUiThread(new Runnable() {
            public final void run() {
                AppMethodBeat.i(19878);
                if (ExdeviceConnectWifiUI.this.lzK != null && ExdeviceConnectWifiUI.this.lzK.isShowing()) {
                    ExdeviceConnectWifiUI.this.lzK.dismiss();
                }
                AppMethodBeat.o(19878);
            }
        });
        if (this.lAd.isHeld()) {
            this.lAd.release();
        }
        AppMethodBeat.o(19909);
    }

    private void g(boolean z, boolean z2, boolean z3) {
        AppMethodBeat.i(19910);
        this.lzG.setVisibility(z ? 0 : 8);
        if (z2) {
            bpH();
        } else {
            bpD();
        }
        if (z3) {
            Toast.makeText(this.mController.ylL, R.string.bfu, 0).show();
        }
        AppMethodBeat.o(19910);
    }

    static /* synthetic */ void k(ExdeviceConnectWifiUI exdeviceConnectWifiUI) {
        AppMethodBeat.i(19913);
        exdeviceConnectWifiUI.lzY = true;
        exdeviceConnectWifiUI.lzX = System.currentTimeMillis();
        exdeviceConnectWifiUI.uP(3);
        final String password = exdeviceConnectWifiUI.getPassword();
        final String str = exdeviceConnectWifiUI.lzL;
        ab.i("MicroMsg.exdevice.ExdeviceConnectWifiUI", "do start AirKiss, ssid(%s).", str);
        if (bo.isNullOrNil(str)) {
            ab.e("MicroMsg.exdevice.ExdeviceConnectWifiUI", "ssid is invalid");
            Toast.makeText(exdeviceConnectWifiUI.mController.ylL, "SSID is invalid", 0).show();
            AppMethodBeat.o(19913);
            return;
        }
        exdeviceConnectWifiUI.a(b.SETTING);
        aw.RS().aa(new Runnable() {
            public final void run() {
                AppMethodBeat.i(19872);
                ExdeviceConnectWifiUI.this.lAd.acquire();
                int startAirKissWithInter = Java2CExDevice.startAirKissWithInter(password, str, ExdeviceConnectWifiUI.this.lzR, 60000, ExdeviceConnectWifiUI.this.lzS, ExdeviceConnectWifiUI.this.lzT);
                ab.i("MicroMsg.exdevice.ExdeviceConnectWifiUI", "Start AirKiss result (%d). input ssid = %s", Integer.valueOf(startAirKissWithInter), str);
                AppMethodBeat.o(19872);
            }
        });
        AppMethodBeat.o(19913);
    }

    static /* synthetic */ void q(ExdeviceConnectWifiUI exdeviceConnectWifiUI) {
        AppMethodBeat.i(19915);
        String str = exdeviceConnectWifiUI.lzL;
        String nullAsNil = bo.nullAsNil(exdeviceConnectWifiUI.getPassword());
        if (bo.isNullOrNil(str)) {
            ab.i("MicroMsg.exdevice.ExdeviceConnectWifiUI", "ssid is null or nil.");
            AppMethodBeat.o(19915);
            return;
        }
        if (bo.isNullOrNil(exdeviceConnectWifiUI.lzM.luG) || (str.equals(exdeviceConnectWifiUI.lzM.luG) && !nullAsNil.equals(exdeviceConnectWifiUI.lzM.luH))) {
            com.tencent.mm.plugin.exdevice.d.a au = exdeviceConnectWifiUI.au(exdeviceConnectWifiUI.lzQ, str);
            if (au == null) {
                au = new com.tencent.mm.plugin.exdevice.d.a();
                au.luG = str;
                au.luF = exdeviceConnectWifiUI.lzQ;
                exdeviceConnectWifiUI.lzZ.luI.add(au);
            }
            au.luH = com.tencent.mm.plugin.base.model.b.da(nullAsNil, a.av(exdeviceConnectWifiUI.lzQ, str));
        } else if (!exdeviceConnectWifiUI.lzN) {
            ab.i("MicroMsg.exdevice.ExdeviceConnectWifiUI", "password hasn't changed, so do not need to save.");
            AppMethodBeat.o(19915);
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        aw.ZK();
        str = stringBuilder.append(c.getAccPath()).append("exdevice_wifi_infos").toString();
        try {
            byte[] toByteArray = exdeviceConnectWifiUI.lzZ.toByteArray();
            e.b(str, toByteArray, toByteArray.length);
        } catch (IOException e) {
            ab.d("MicroMsg.exdevice.ExdeviceConnectWifiUI", e.getMessage());
            ab.printErrStackTrace("MicroMsg.exdevice.ExdeviceConnectWifiUI", e, "", new Object[0]);
        }
        ab.v("MicroMsg.exdevice.ExdeviceConnectWifiUI", "Current wifiInfo was save to file(%s).", str);
        AppMethodBeat.o(19915);
    }

    static /* synthetic */ void r(ExdeviceConnectWifiUI exdeviceConnectWifiUI) {
        AppMethodBeat.i(19916);
        Java2CExDevice.stopAirKiss();
        exdeviceConnectWifiUI.gO(true);
        if (exdeviceConnectWifiUI.lAd.isHeld()) {
            exdeviceConnectWifiUI.lAd.release();
        }
        AppMethodBeat.o(19916);
    }
}
