package com.tencent.mm.plugin.welab.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.widget.j;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.v;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.bp.d;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.welab.f;
import com.tencent.mm.plugin.welab.ui.widget.WelabRoundCornerImageView;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.protobuf.axk;
import com.tencent.mm.protocal.protobuf.axl;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class WelabAppInfoUI extends MMActivity {
    private String csB;
    private TextView gne;
    private TextView iKo;
    private MMSwitchBtn ixT;
    private Button mlE;
    private TextView pnu;
    private com.tencent.mm.plugin.welab.d.a.a uMg;
    private int uMh;
    private boolean uMi;
    private WelabRoundCornerImageView uMj;
    private RecyclerView uMk;
    private View uMl;
    private View uMm;
    private View uMn;
    private View uMo;
    private a uMp;
    private OnClickListener uMq = new OnClickListener() {
        public final void onClick(View view) {
            AppMethodBeat.i(80603);
            String obj = view.getTag().toString();
            Intent intent = new Intent();
            intent.putExtra("nowUrl", obj);
            intent.putExtra("urlList", (String[]) ((a) WelabAppInfoUI.this.uMk.getAdapter()).kFl.toArray(new String[0]));
            Context context = WelabAppInfoUI.this;
            Intent intent2 = new Intent();
            intent2.putExtras(intent.getExtras());
            if (intent.getFlags() != 0) {
                intent2.addFlags(intent.getFlags());
            }
            d.b(context, "subapp", ".ui.gallery.GestureGalleryUI", intent2);
            AppMethodBeat.o(80603);
        }
    };

    class a extends android.support.v7.widget.RecyclerView.a<b> {
        public List<String> kFl;

        public final int getItemCount() {
            AppMethodBeat.i(80604);
            int size = this.kFl.size();
            AppMethodBeat.o(80604);
            return size;
        }
    }

    class b extends v {
        public ImageView uMs;

        public b(View view) {
            super(view);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public WelabAppInfoUI() {
        AppMethodBeat.i(80607);
        AppMethodBeat.o(80607);
    }

    public void onCreate(Bundle bundle) {
        boolean z = true;
        AppMethodBeat.i(80608);
        super.onCreate(bundle);
        pO(true);
        dyb();
        Intent intent = getIntent();
        if (intent != null) {
            this.csB = intent.getStringExtra("para_appid");
            this.uMg = com.tencent.mm.plugin.welab.a.ddj().agI(this.csB);
            this.uMh = this.uMg.field_Switch;
            if (getIntent().getIntExtra("para_from_with_red_point", 0) != 1) {
                z = false;
            }
            this.uMi = z;
        }
        initView();
        com.tencent.mm.plugin.welab.d.t(this.csB, 2, this.uMi);
        AppMethodBeat.o(80608);
    }

    public final int getLayoutId() {
        return R.layout.b7o;
    }

    @TargetApi(21)
    private void ddy() {
        AppMethodBeat.i(80609);
        if (VERSION.SDK_INT >= 21) {
            Window window = getWindow();
            window.clearFlags(201326592);
            window.addFlags(j.INVALID_ID);
            window.setStatusBarColor(getResources().getColor(R.color.a68));
        }
        AppMethodBeat.o(80609);
    }

    public final void initView() {
        AppMethodBeat.i(80610);
        super.initView();
        if (this.uMg == null) {
            ab.e("WelabAppInfoUI", "info is null");
            AppMethodBeat.o(80610);
            return;
        }
        MY(8);
        ddy();
        if (getSupportActionBar() != null) {
            getSupportActionBar().getCustomView().setBackgroundColor(getResources().getColor(R.color.a68));
        }
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(80599);
                WelabAppInfoUI.this.aqX();
                WelabAppInfoUI.this.finish();
                AppMethodBeat.o(80599);
                return true;
            }
        });
        this.uMj = (WelabRoundCornerImageView) findViewById(R.id.fkz);
        this.gne = (TextView) findViewById(R.id.cx);
        this.pnu = (TextView) findViewById(R.id.a81);
        this.uMk = (RecyclerView) findViewById(R.id.fl3);
        this.uMl = findViewById(R.id.fl4);
        this.mlE = (Button) findViewById(R.id.bsc);
        this.uMm = findViewById(R.id.fl6);
        this.ixT = (MMSwitchBtn) findViewById(R.id.js);
        this.iKo = (TextView) findViewById(R.id.fl5);
        this.uMn = findViewById(R.id.fl1);
        this.uMo = findViewById(R.id.fl2);
        this.uMk.setLayoutManager(new LinearLayoutManager(0));
        this.uMk.setOverScrollMode(2);
        this.uMp = new a();
        this.uMk.setAdapter(this.uMp);
        AppMethodBeat.o(80610);
    }

    public void onPause() {
        int i = 0;
        AppMethodBeat.i(80611);
        super.onPause();
        if (this.uMh != this.uMg.field_Switch) {
            boolean c = com.tencent.mm.plugin.welab.a.ddj().uLQ.c(this.uMg, new String[0]);
            ab.i("WelabAppInfoUI", "update welab info [%b] originSwitch[%d] newSwitch[%d]", Boolean.valueOf(c), Integer.valueOf(this.uMh), Integer.valueOf(this.uMg.field_Switch));
            this.uMh = this.uMg.field_Switch;
            axl axl = new axl();
            axk axk = new axk();
            if (!this.uMg.ddw()) {
                i = bo.ank(this.uMg.field_expId);
            }
            axk.wBs = i;
            axk.wBt = this.uMg.field_LabsAppId;
            if (this.uMg.field_Switch == 2) {
                i = 1;
            } else {
                i = 2;
            }
            axk.wkB = i;
            axl.eow.add(axk);
            ((com.tencent.mm.plugin.messenger.foundation.a.j) g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).XL().c(new com.tencent.mm.plugin.messenger.foundation.a.a.j.a(207, axl));
            com.tencent.mm.plugin.welab.d.t(this.csB, this.uMg.field_Switch == 2 ? 4 : 5, this.uMi);
            if (this.uMg.field_Switch == 2) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(this.uMg);
                com.tencent.mm.plugin.welab.a.ddj();
                com.tencent.mm.plugin.welab.a.ed(arrayList);
            }
        }
        AppMethodBeat.o(80611);
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0166  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x00fb  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x016c  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0112  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onResume() {
        TextView textView;
        com.tencent.mm.at.a.a ahv;
        AppMethodBeat.i(80612);
        super.onResume();
        if (this.uMg.ddu() && this.uMg.field_Type == 1) {
            this.uMl.setVisibility(0);
            this.iKo.setText(getResources().getString(R.string.g0v) + this.uMg.agR("field_Title"));
            SharedPreferences sharedPreferences = getSharedPreferences(getPackageName() + "_preferences", 0);
            this.ixT.setEnabled(true);
            if (this.uMg.field_Switch == 2) {
                sharedPreferences.edit().putBoolean(ddz(), true).commit();
                this.ixT.setCheck(true);
            } else {
                sharedPreferences.edit().putBoolean(ddz(), false).commit();
                this.ixT.setCheck(false);
            }
            this.ixT.setSwitchListener(new com.tencent.mm.ui.widget.MMSwitchBtn.a() {
                public final void di(boolean z) {
                    AppMethodBeat.i(80600);
                    if (WelabAppInfoUI.this.uMg.field_Switch == 2) {
                        WelabAppInfoUI.this.uMg.field_Switch = 1;
                        AppMethodBeat.o(80600);
                        return;
                    }
                    if (WelabAppInfoUI.this.uMg.field_Switch == 1) {
                        WelabAppInfoUI.this.uMg.field_Switch = 2;
                    }
                    AppMethodBeat.o(80600);
                }
            });
        } else {
            this.uMl.setVisibility(8);
        }
        if (this.uMg.ddu()) {
            this.mlE.setText(getResources().getString(R.string.g0t) + this.uMg.agR("field_Title"));
            if (this.uMg.field_Type != 1) {
                this.mlE.setVisibility(0);
                this.mlE.setOnClickListener(new OnClickListener() {
                    public final void onClick(View view) {
                        AppMethodBeat.i(80601);
                        ab.i("WelabAppInfoUI", "open func " + WelabAppInfoUI.this.csB);
                        com.tencent.mm.plugin.welab.a ddj = com.tencent.mm.plugin.welab.a.ddj();
                        WelabAppInfoUI welabAppInfoUI = WelabAppInfoUI.this;
                        String b = WelabAppInfoUI.this.csB;
                        com.tencent.mm.plugin.welab.a.a.b bVar = (com.tencent.mm.plugin.welab.a.a.b) ddj.uLR.get(b);
                        if (bVar != null) {
                            ab.i("WelabMgr", "use custome opener to open ".concat(String.valueOf(b)));
                            bVar.f(welabAppInfoUI, b);
                        } else {
                            ab.i("WelabMgr", "use default opener open ".concat(String.valueOf(b)));
                            if (ddj.agI(b).field_Type != 2) {
                                ab.e("WelabMgr", "can not find opener for ".concat(String.valueOf(b)));
                            } else if (ddj.uLS != null) {
                                ddj.uLS.f(welabAppInfoUI, b);
                            } else {
                                ab.e("WelabMgr", "defaultWeAppOpener is null!");
                            }
                        }
                        com.tencent.mm.plugin.welab.d.t(WelabAppInfoUI.this.csB, 7, WelabAppInfoUI.this.uMi);
                        AppMethodBeat.o(80601);
                    }
                });
                textView = this.gne;
                com.tencent.mm.plugin.welab.a.ddj();
                textView.setText(com.tencent.mm.plugin.welab.a.a(this.uMg));
                this.pnu.setText(this.uMg.agR("field_Introduce"));
                if (this.uMg.ddu()) {
                    this.uMm.setVisibility(8);
                } else {
                    this.uMm.setVisibility(0);
                    this.uMm.setOnClickListener(new OnClickListener() {
                        public final void onClick(View view) {
                            AppMethodBeat.i(80602);
                            try {
                                String str = "";
                                g.RN();
                                int QF = com.tencent.mm.kernel.a.QF();
                                String encode = URLEncoder.encode(com.tencent.mm.protocal.d.DEVICE_NAME, ProtocolPackage.ServerEncoding);
                                String encode2 = URLEncoder.encode(bo.dpA(), ProtocolPackage.ServerEncoding);
                                String encode3 = URLEncoder.encode(q.LK(), ProtocolPackage.ServerEncoding);
                                String encode4 = URLEncoder.encode(com.tencent.mm.protocal.d.vxi, ProtocolPackage.ServerEncoding);
                                String encode5 = URLEncoder.encode(com.tencent.mm.protocal.d.vxj, ProtocolPackage.ServerEncoding);
                                String encode6 = URLEncoder.encode(com.tencent.mm.protocal.d.vxk, ProtocolPackage.ServerEncoding);
                                g.RN();
                                String str2 = ("https://support.weixin.qq.com/cgi-bin/mmsupport-bin/readtemplate?t=feedback/index" + "&from=" + URLEncoder.encode(WelabAppInfoUI.this.uMg.field_expId + "|" + WelabAppInfoUI.this.csB) + "&version=" + com.tencent.mm.protocal.d.vxo + "&lang=" + aa.gw(ah.getContext()) + "&" + bo.nullAsNil(str) + ("&uin=" + QF + "&deviceName=" + encode + "&timeZone=" + encode2 + "&imei=" + encode3 + "&deviceBrand=" + encode4 + "&deviceModel=" + encode5 + "&ostype=" + encode6 + "&clientSeqID=" + URLEncoder.encode(com.tencent.mm.kernel.a.Rb(), ProtocolPackage.ServerEncoding) + "&signature=" + URLEncoder.encode(bo.gS(ah.getContext()), ProtocolPackage.ServerEncoding) + "&scene=" + (bo.isNullOrNil(str) ? 0 : 1))) + "#/comment/4134";
                                Intent intent = new Intent();
                                intent.putExtra("showShare", false);
                                intent.putExtra("rawUrl", str2);
                                intent.putExtra("title", "意见反馈");
                                intent.putExtra("neverGetA8Key", true);
                                intent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.vxI);
                                intent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.vxE);
                                d.b(WelabAppInfoUI.this, "webview", ".ui.tools.WebViewUI", intent);
                                AppMethodBeat.o(80602);
                            } catch (UnsupportedEncodingException e) {
                                ab.e("WelabAppInfoUI", "[oneliang]UnsupportedEncodingException:%s", e.getMessage());
                                AppMethodBeat.o(80602);
                            }
                        }
                    });
                }
                if (this.uMg.ddu()) {
                    this.uMn.setVisibility(0);
                    this.uMo.setVisibility(8);
                } else {
                    this.uMn.setVisibility(8);
                    this.uMo.setVisibility(0);
                }
                ddA();
                this.uMj.setCornerRadiusPercent(0.5f);
                ahv = com.tencent.mm.at.a.a.ahv();
                com.tencent.mm.plugin.welab.a.ddj();
                ahv.a(com.tencent.mm.plugin.welab.a.b(this.uMg), this.uMj, com.tencent.mm.plugin.welab.a.ddj().udB);
                AppMethodBeat.o(80612);
            }
        }
        this.mlE.setVisibility(8);
        textView = this.gne;
        com.tencent.mm.plugin.welab.a.ddj();
        textView.setText(com.tencent.mm.plugin.welab.a.a(this.uMg));
        this.pnu.setText(this.uMg.agR("field_Introduce"));
        if (this.uMg.ddu()) {
        }
        if (this.uMg.ddu()) {
        }
        ddA();
        this.uMj.setCornerRadiusPercent(0.5f);
        ahv = com.tencent.mm.at.a.a.ahv();
        com.tencent.mm.plugin.welab.a.ddj();
        ahv.a(com.tencent.mm.plugin.welab.a.b(this.uMg), this.uMj, com.tencent.mm.plugin.welab.a.ddj().udB);
        AppMethodBeat.o(80612);
    }

    private String ddz() {
        AppMethodBeat.i(80613);
        String str = "switch_" + this.uMg.field_LabsAppId;
        AppMethodBeat.o(80613);
        return str;
    }

    private void ddA() {
        AppMethodBeat.i(80614);
        String agR = this.uMg.agR("field_ImgUrl_android");
        if (TextUtils.isEmpty(agR)) {
            agR = this.uMg.agR("field_ImgUrl");
        }
        List agL = f.agL(agR);
        Iterator it = agL.iterator();
        while (it.hasNext()) {
            if (TextUtils.isEmpty((String) it.next())) {
                it.remove();
            }
        }
        if (agL.isEmpty()) {
            this.uMk.setVisibility(8);
            AppMethodBeat.o(80614);
            return;
        }
        this.uMk.setVisibility(0);
        this.uMp.kFl = agL;
        this.uMp.aop.notifyChanged();
        AppMethodBeat.o(80614);
    }
}
