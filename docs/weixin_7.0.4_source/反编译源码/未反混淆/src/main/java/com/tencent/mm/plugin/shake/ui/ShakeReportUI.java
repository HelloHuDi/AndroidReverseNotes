package com.tencent.mm.plugin.shake.ui;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.location.LocationManager;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.os.MessageQueue.IdleHandler;
import android.os.Vibrator;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.ds;
import com.tencent.mm.g.a.dt;
import com.tencent.mm.g.a.dz;
import com.tencent.mm.g.a.se;
import com.tencent.mm.m.g;
import com.tencent.mm.model.as;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bp;
import com.tencent.mm.model.c;
import com.tencent.mm.modelgeo.d;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.platformtools.v;
import com.tencent.mm.platformtools.x;
import com.tencent.mm.plugin.shake.b.e;
import com.tencent.mm.plugin.shake.b.l;
import com.tencent.mm.plugin.shake.b.m;
import com.tencent.mm.plugin.shake.d.a.j;
import com.tencent.mm.plugin.shake.d.a.k;
import com.tencent.mm.pluginsdk.ui.ProfileHdHeadImg;
import com.tencent.mm.pluginsdk.ui.f;
import com.tencent.mm.pluginsdk.ui.tools.n;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMImageView;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.i;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.base.y;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import com.tencent.ttpic.FilterEnum4Shaka;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ShakeReportUI extends MMActivity implements as, com.tencent.mm.platformtools.x.a, com.tencent.mm.plugin.shake.b.l.a, com.tencent.mm.plugin.shake.c.a.f.a, com.tencent.mm.sdk.e.k.a, b {
    private static List<com.tencent.mm.plugin.shake.d.a.h.a> ecw = new CopyOnWriteArrayList();
    private d ecr;
    private boolean ecu = false;
    private Map<String, com.tencent.mm.plugin.shake.d.a.h.a> ecv = new ConcurrentHashMap();
    private com.tencent.mm.modelgeo.b.a ecy = new com.tencent.mm.modelgeo.b.a() {
        public final boolean a(boolean z, float f, float f2, int i, double d, double d2, double d3) {
            AppMethodBeat.i(24775);
            if (z) {
                ab.d("MicroMsg.ShakeReportUI", "on location get ok");
                aw.ZK();
                c.Ry().set(com.tencent.mm.storage.ac.a.USERINFO_SHAKE_TV_LATITUDE_STRING, String.valueOf(f2));
                aw.ZK();
                c.Ry().set(com.tencent.mm.storage.ac.a.USERINFO_SHAKE_TV_LONGTITUDE_STRING, String.valueOf(f));
                aw.ZK();
                c.Ry().set(com.tencent.mm.storage.ac.a.USERINFO_SHAKE_TV_ACCURACY_STRING, String.valueOf(d2));
                ShakeReportUI.this.ecu = true;
                if (ShakeReportUI.this.ecr != null) {
                    ShakeReportUI.this.ecr.c(ShakeReportUI.this.ecy);
                }
            } else {
                if (!(ShakeReportUI.this.nPX || d.agA())) {
                    ShakeReportUI.this.nPX = true;
                    h.a(ShakeReportUI.this, ShakeReportUI.this.getString(R.string.c9z), ShakeReportUI.this.getString(R.string.tz), ShakeReportUI.this.getString(R.string.ckr), ShakeReportUI.this.getString(R.string.or), false, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.i(24774);
                            d.bX(ShakeReportUI.this);
                            AppMethodBeat.o(24774);
                        }
                    }, null);
                }
                ab.w("MicroMsg.ShakeReportUI", "getLocation fail");
            }
            AppMethodBeat.o(24775);
            return false;
        }
    };
    private ImageView eks;
    private com.tencent.mm.at.a.a fGv = null;
    private boolean gwZ = true;
    private boolean nPX;
    private com.tencent.mm.pluginsdk.i.d oOS;
    private boolean quU = false;
    private boolean quV = false;
    private boolean quW;
    private boolean quX = false;
    private boolean quY = false;
    private boolean quZ = false;
    private ImageView qvA = null;
    private com.tencent.mm.plugin.shake.b.d qvB = null;
    private ImageView qvC;
    private ImageView qvD;
    private ImageView qvE;
    private ImageView qvF;
    private ImageView qvG;
    private ImageView qvH;
    private TextView qvI;
    private int qvJ = 1;
    private int qvK = 0;
    private View qvL;
    private ImageView qvM;
    private ImageView qvN;
    private ImageView qvO;
    private ImageView qvP;
    private View qvQ;
    private View qvR;
    private View qvS;
    private View qvT;
    private View qvU = null;
    private int qvV = 0;
    private com.tencent.mm.plugin.shake.c.b.a qvW;
    private boolean qvX = false;
    @SuppressLint({"UseSparseArrays"})
    private Map<Integer, Boolean> qvY = new HashMap();
    private boolean qvZ = false;
    private boolean qva = false;
    private int qvb = 22;
    private c qvc;
    private l qvd = new l();
    private f qve;
    private View qvf;
    private View qvg;
    private TextView qvh;
    private TextView qvi;
    private TextView qvj;
    private View qvk;
    private View qvl;
    private View qvm;
    private View qvn;
    private Animation qvo;
    private Animation qvp;
    private Animation qvq;
    private Animation qvr;
    private View qvs = null;
    private View qvt = null;
    private MMImageView qvu = null;
    private TextView qvv = null;
    private ImageView qvw = null;
    private String qvx = "";
    private Bitmap qvy = null;
    private Dialog qvz;
    private boolean qwa = false;
    private boolean qwb = false;
    private boolean qwc = false;
    private int qwd = 1;
    private long qwe = 0;
    private boolean qwf = false;
    private com.tencent.mm.sdk.b.c qwg = new com.tencent.mm.sdk.b.c<dt>() {
        {
            AppMethodBeat.i(24803);
            this.xxI = dt.class.getName().hashCode();
            AppMethodBeat.o(24803);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(24804);
            dt dtVar = (dt) bVar;
            String str = dtVar.cxk.cxi;
            int i = dtVar.cxk.cxl;
            int i2 = dtVar.cxk.cxm;
            String str2 = dtVar.cxk.cxp;
            double d = dtVar.cxk.cxo;
            int i3 = dtVar.cxk.cxq;
            if (!ShakeReportUI.this.ecv.containsKey(str + "," + i + "," + i2)) {
                com.tencent.mm.plugin.shake.d.a.h.a aVar = new com.tencent.mm.plugin.shake.d.a.h.a();
                aVar.eCq = str;
                aVar.fNN = dtVar.cxk.cxn;
                aVar.major = i;
                aVar.minor = i2;
                aVar.qtR = str2;
                aVar.qtS = d;
                aVar.qtT = i3;
                ShakeReportUI.this.ecv.put(str + "," + i + "," + i2, aVar);
                if (dtVar.cxk.cxn >= 0.0d && ShakeReportUI.ecw.size() > 0) {
                    int i4 = 0;
                    while (true) {
                        i3 = i4;
                        if (i3 >= ShakeReportUI.ecw.size()) {
                            break;
                        }
                        com.tencent.mm.plugin.shake.d.a.h.a aVar2 = (com.tencent.mm.plugin.shake.d.a.h.a) ShakeReportUI.ecw.get(i3);
                        if (dtVar.cxk.cxn >= aVar2.fNN) {
                            if (i3 == ShakeReportUI.ecw.size() - 1 && dtVar.cxk.cxn > aVar2.fNN) {
                                ShakeReportUI.ecw.add(aVar);
                                break;
                            }
                            i4 = i3 + 1;
                        } else {
                            ShakeReportUI.ecw.add(i3, aVar);
                            break;
                        }
                    }
                }
                ShakeReportUI.ecw.add(aVar);
                if (ShakeReportUI.this.ecv.size() == 1 && !ShakeReportUI.this.qwf) {
                    ShakeReportUI.this.qwe = System.currentTimeMillis() - ShakeReportUI.this.qwe;
                    com.tencent.mm.plugin.report.service.h.pYm.e(11497, String.valueOf((int) (((double) (ShakeReportUI.this.qwe / 1000)) + 0.5d)), Integer.valueOf(0), Integer.valueOf((int) ShakeReportUI.this.qwe));
                    ShakeReportUI.this.qwe = 0;
                    ShakeReportUI.this.runOnUiThread(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(24802);
                            ShakeReportUI.j(ShakeReportUI.this);
                            AppMethodBeat.o(24802);
                        }
                    });
                }
            }
            ab.i("MicroMsg.ShakeReportUI", "result iBeacon = %s,beaconMap.size:%d", str + "," + i + "," + i2, Integer.valueOf(ShakeReportUI.this.ecv.size()));
            AppMethodBeat.o(24804);
            return false;
        }
    };
    private com.tencent.mm.sdk.b.c qwh = new com.tencent.mm.sdk.b.c<dz>() {
        {
            AppMethodBeat.i(24806);
            this.xxI = dz.class.getName().hashCode();
            AppMethodBeat.o(24806);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(24807);
            dz dzVar = (dz) bVar;
            ab.d("MicroMsg.ShakeReportUI", "ExDeviceOnBluetoothStateChangeEvent = %s", Integer.valueOf(dzVar.cxz.cxA));
            boolean hasSystemFeature = ShakeReportUI.this.mController.ylL.getPackageManager().hasSystemFeature("android.hardware.bluetooth_le");
            if (dzVar.cxz.cxA == 10 && VERSION.SDK_INT >= 18 && hasSystemFeature) {
                ShakeReportUI.k(ShakeReportUI.this);
            } else if (dzVar.cxz.cxA == 12) {
                int i;
                if (VERSION.SDK_INT < 18 || !hasSystemFeature) {
                    ShakeReportUI.this.qwd = 1;
                } else {
                    ShakeReportUI.l(ShakeReportUI.this);
                    ShakeReportUI.this.qwd = 0;
                }
                bp aao = bp.aao();
                String nullAsNil = bo.nullAsNil(aao.fnp);
                String nullAsNil2 = bo.nullAsNil(aao.fno);
                if (hasSystemFeature) {
                    i = 1;
                } else {
                    i = 0;
                }
                if (ShakeReportUI.this.qwa) {
                    com.tencent.mm.plugin.report.service.h.pYm.e(13139, nullAsNil, nullAsNil2, Integer.valueOf(1), Integer.valueOf(ShakeReportUI.this.qwd), Integer.valueOf(1), Integer.valueOf(i));
                } else {
                    com.tencent.mm.plugin.report.service.h.pYm.e(13139, nullAsNil, nullAsNil2, Integer.valueOf(0), Integer.valueOf(ShakeReportUI.this.qwd), Integer.valueOf(1), Integer.valueOf(i));
                }
                if (ShakeReportUI.this.qwb && ShakeReportUI.this.qwa && !ShakeReportUI.this.qwf && ShakeReportUI.this.qvK < 4) {
                    ShakeReportUI.this.runOnUiThread(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(24805);
                            ShakeReportUI.j(ShakeReportUI.this);
                            AppMethodBeat.o(24805);
                        }
                    });
                }
            }
            AppMethodBeat.o(24807);
            return false;
        }
    };
    private View.OnClickListener qwi = new View.OnClickListener() {
        public long quz = 0;

        public final void onClick(View view) {
            AppMethodBeat.i(24796);
            if (bo.isNullOrNil((String) ShakeReportUI.this.qvf.getTag())) {
                AppMethodBeat.o(24796);
            } else if (ShakeReportUI.this.qvB == null) {
                AppMethodBeat.o(24796);
            } else {
                com.tencent.mm.plugin.shake.b.d N = ShakeReportUI.this.qvB;
                String str = N.field_username;
                Intent intent;
                if (11 == N.field_type) {
                    if (System.currentTimeMillis() - this.quz > 3000) {
                        this.quz = System.currentTimeMillis();
                        if (N.field_reserved3 == null || N.field_reserved3.split(",").length != 3 || N.field_reserved3.split(",")[0] == null || N.field_reserved3.split(",")[0].equals("")) {
                            intent = new Intent();
                            intent.putExtra("rawUrl", N.getCity());
                            intent.putExtra("scene", 27);
                            intent.putExtra("stastic_scene", 5);
                            com.tencent.mm.bp.d.b(ah.getContext(), "webview", ".ui.tools.WebViewUI", intent);
                        } else {
                            String[] split = N.field_reserved3.split(",");
                            se seVar = new se();
                            seVar.cOf.userName = split[0];
                            seVar.cOf.cOh = bo.bc(split[1], "");
                            seVar.cOf.cOi = bo.getInt(split[2], 0);
                            seVar.cOf.scene = FilterEnum4Shaka.MIC_WEISHI_HEICHA;
                            com.tencent.mm.sdk.b.a.xxA.m(seVar);
                        }
                        l.b bVar = ShakeReportUI.this.qvd.qrS;
                        if (bVar != null && (bVar instanceof com.tencent.mm.plugin.shake.d.a.h)) {
                            com.tencent.mm.plugin.shake.d.a.h.a(N);
                            com.tencent.mm.plugin.shake.d.a.h.b(N);
                        }
                    }
                    AppMethodBeat.o(24796);
                    return;
                }
                aw.ZK();
                ad aoO = c.XM().aoO(str);
                if (com.tencent.mm.n.a.jh(aoO.field_type)) {
                    Intent intent2 = new Intent();
                    intent2.putExtra("Contact_User", str);
                    intent2.putExtra("Sns_from_Scene", 22);
                    if (str != null && str.length() > 0) {
                        if (aoO.dsf()) {
                            com.tencent.mm.plugin.report.service.h.pYm.X(10298, str + "," + ShakeReportUI.this.qvb);
                            intent2.putExtra("Contact_Scene", ShakeReportUI.this.qvb);
                        }
                        com.tencent.mm.plugin.shake.a.gkE.c(intent2, ShakeReportUI.this);
                    }
                    AppMethodBeat.o(24796);
                    return;
                }
                if ((N.field_reserved1 & 8) > 0) {
                    com.tencent.mm.plugin.report.service.h.pYm.X(10298, N.field_username + "," + ShakeReportUI.this.qvb);
                }
                intent = new Intent();
                intent.putExtra("Contact_User", N.field_username);
                intent.putExtra("Contact_Nick", N.field_nickname);
                intent.putExtra("Contact_Distance", N.field_distance);
                intent.putExtra("Contact_Signature", N.field_signature);
                intent.putExtra("Contact_Province", N.getProvince());
                intent.putExtra("Contact_City", N.getCity());
                intent.putExtra("Contact_Sex", N.field_sex);
                intent.putExtra("Contact_IsLBSFriend", true);
                intent.putExtra("Contact_VUser_Info", N.field_reserved3);
                intent.putExtra("Contact_VUser_Info_Flag", N.field_reserved1);
                intent.putExtra("Contact_KSnsIFlag", N.field_snsFlag);
                intent.putExtra("Contact_KSnsBgUrl", N.field_sns_bgurl);
                intent.putExtra("Contact_Scene", ShakeReportUI.this.qvb);
                intent.putExtra("Sns_from_Scene", 22);
                com.tencent.mm.plugin.shake.a.gkE.c(intent, ShakeReportUI.this);
                AppMethodBeat.o(24796);
            }
        }
    };

    static class a extends com.tencent.mm.pluginsdk.i.d.a {
        private final long[] gjH = new long[]{300, 200, 300, 200};
        private Vibrator kgA;
        private long mfT = bo.yz();
        WeakReference<ShakeReportUI> qwq;

        public a(ShakeReportUI shakeReportUI) {
            AppMethodBeat.i(24812);
            this.qwq = new WeakReference(shakeReportUI);
            AppMethodBeat.o(24812);
        }

        public final void bUT() {
            AppMethodBeat.i(24813);
            ShakeReportUI shakeReportUI = (ShakeReportUI) this.qwq.get();
            if (shakeReportUI == null) {
                AppMethodBeat.o(24813);
            } else if (shakeReportUI.isFinishing()) {
                ab.e("MicroMsg.ShakeReportUI", "ui finished");
                AppMethodBeat.o(24813);
            } else if (shakeReportUI.quZ) {
                ShakeReportUI.w(shakeReportUI);
                long az = bo.az(this.mfT);
                if (az < 1200) {
                    ab.i("MicroMsg.ShakeReportUI", "tryStartShake delay too short:".concat(String.valueOf(az)));
                    AppMethodBeat.o(24813);
                    return;
                }
                ab.w("MicroMsg.ShakeReportUI", "tryStartShake delaytoo enough:".concat(String.valueOf(az)));
                this.mfT = bo.yz();
                if (shakeReportUI.qvc != null) {
                    c x = shakeReportUI.qvc;
                    if (x.view != null) {
                        x.view.setKeepScreenOn(true);
                    }
                    x.che.ae(30000, 30000);
                }
                if (shakeReportUI.qve != null) {
                    f y = shakeReportUI.qve;
                    if (y.vhB != null) {
                        y.vhB.dismiss();
                    }
                }
                ShakeReportUI shakeReportUI2;
                if (shakeReportUI.quW) {
                    shakeReportUI2 = (ShakeReportUI) this.qwq.get();
                    if (shakeReportUI2 != null) {
                        ay.au(shakeReportUI2, R.string.eg4);
                    }
                } else {
                    shakeReportUI2 = (ShakeReportUI) this.qwq.get();
                    if (shakeReportUI2 != null) {
                        if (this.kgA == null) {
                            this.kgA = (Vibrator) shakeReportUI2.getSystemService("vibrator");
                        }
                        if (this.kgA != null) {
                            this.kgA.vibrate(this.gjH, -1);
                        }
                    }
                }
                com.tencent.mm.pluginsdk.i.d.a.reset();
                ShakeReportUI.A(shakeReportUI);
                AppMethodBeat.o(24813);
            } else {
                ab.i("MicroMsg.ShakeReportUI", "tryShake the status is can's shake");
                AppMethodBeat.o(24813);
            }
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public ShakeReportUI() {
        AppMethodBeat.i(24814);
        AppMethodBeat.o(24814);
    }

    static /* synthetic */ void B(ShakeReportUI shakeReportUI) {
        AppMethodBeat.i(24867);
        shakeReportUI.ckR();
        AppMethodBeat.o(24867);
    }

    static /* synthetic */ void D(ShakeReportUI shakeReportUI) {
        AppMethodBeat.i(24868);
        shakeReportUI.ckH();
        AppMethodBeat.o(24868);
    }

    static /* synthetic */ void J(ShakeReportUI shakeReportUI) {
        AppMethodBeat.i(24869);
        shakeReportUI.CD(1);
        AppMethodBeat.o(24869);
    }

    static /* synthetic */ void K(ShakeReportUI shakeReportUI) {
        AppMethodBeat.i(24870);
        shakeReportUI.kx(false);
        AppMethodBeat.o(24870);
    }

    static /* synthetic */ void d(ShakeReportUI shakeReportUI, boolean z) {
        AppMethodBeat.i(24863);
        shakeReportUI.ky(z);
        AppMethodBeat.o(24863);
    }

    static /* synthetic */ void f(ShakeReportUI shakeReportUI, boolean z) {
        AppMethodBeat.i(24866);
        shakeReportUI.ku(z);
        AppMethodBeat.o(24866);
    }

    static /* synthetic */ void k(ShakeReportUI shakeReportUI) {
        AppMethodBeat.i(24860);
        shakeReportUI.ckD();
        AppMethodBeat.o(24860);
    }

    static /* synthetic */ void l(ShakeReportUI shakeReportUI) {
        AppMethodBeat.i(24861);
        shakeReportUI.ckC();
        AppMethodBeat.o(24861);
    }

    static /* synthetic */ void w(ShakeReportUI shakeReportUI) {
        AppMethodBeat.i(24864);
        shakeReportUI.ckL();
        AppMethodBeat.o(24864);
    }

    public final int getLayoutId() {
        return R.layout.asf;
    }

    public final int getForceOrientation() {
        return 1;
    }

    public void onCreate(Bundle bundle) {
        int i;
        int i2;
        AppMethodBeat.i(24815);
        super.onCreate(bundle);
        setMMTitle((int) R.string.efr);
        xE(getResources().getColor(R.color.l8));
        Nb(getResources().getColor(R.color.l8));
        dyb();
        this.ecr = d.agz();
        aw.ZK();
        c.Ry().set(com.tencent.mm.storage.ac.a.USERINFO_SHAKE_TV_LATITUDE_STRING, (Object) "");
        aw.ZK();
        c.Ry().set(com.tencent.mm.storage.ac.a.USERINFO_SHAKE_TV_LONGTITUDE_STRING, (Object) "");
        aw.ZK();
        c.Ry().set(com.tencent.mm.storage.ac.a.USERINFO_SHAKE_TV_ACCURACY_STRING, (Object) "");
        this.qvU = findViewById(R.id.ec8);
        bp aao = bp.aao();
        String nullAsNil = bo.nullAsNil(aao.fnp);
        String nullAsNil2 = bo.nullAsNil(aao.fno);
        String O = g.Nv().O("IBeacon", "GatedLaunch");
        if (bo.isNullOrNil(O)) {
            O = null;
        }
        this.qwa = false;
        this.qwb = false;
        if (O != null) {
            try {
                JSONObject jSONObject = new JSONObject(O);
                i = jSONObject.getInt("gatedlaunch");
                aw.RK();
                if (i != 0) {
                    JSONArray jSONArray;
                    int length;
                    String string;
                    int i3;
                    JSONArray jSONArray2;
                    if (i == 1) {
                        jSONArray = jSONObject.getJSONArray("citylist");
                        length = jSONArray.length();
                        for (i = 0; i < length; i++) {
                            jSONObject = jSONArray.getJSONObject(i);
                            string = jSONObject.getString("province");
                            i3 = jSONObject.getInt("allgatedlaunch");
                            if (string.equals(nullAsNil) && i3 == 1) {
                                this.qwa = true;
                            } else if (string.equals(nullAsNil) && i3 == 0) {
                                jSONArray2 = jSONObject.getJSONArray("cities");
                                i3 = jSONArray2.length();
                                for (i2 = 0; i2 < i3; i2++) {
                                    if (jSONArray2.getString(i2).equals(nullAsNil2)) {
                                        this.qwa = true;
                                    }
                                }
                            }
                        }
                    } else if (i == 2) {
                        jSONArray = jSONObject.getJSONArray("citylist");
                        length = jSONArray.length();
                        for (i = 0; i < length; i++) {
                            jSONObject = jSONArray.getJSONObject(i);
                            string = jSONObject.getString("province");
                            i3 = jSONObject.getInt("allgatedlaunch");
                            if (string.equals(nullAsNil) && i3 == 1) {
                                this.qwb = true;
                                this.qwa = true;
                            } else if (string.equals(nullAsNil) && i3 == 0) {
                                jSONArray2 = jSONObject.getJSONArray("cities");
                                i3 = jSONArray2.length();
                                for (i2 = 0; i2 < i3; i2++) {
                                    if (jSONArray2.getString(i2).equals(nullAsNil2)) {
                                        this.qwb = true;
                                        this.qwa = true;
                                    }
                                }
                            }
                        }
                    } else if (i == 3) {
                        this.qwa = true;
                        this.qwb = false;
                    } else if (i == 4) {
                        this.qwa = true;
                        this.qwb = true;
                    }
                }
            } catch (JSONException e) {
                ab.e("MicroMsg.ShakeReportUI", "[shakezb]parse dymanic setting json fail!!");
                this.qwa = false;
                this.qwb = false;
            }
        }
        if (aw.RK()) {
            aw.ZK();
            if (((Integer) c.Ry().get(com.tencent.mm.storage.ac.a.USERINFO_IBEACON_SHAKE_TAB_IS_UIN_RESIDENT_INT, Integer.valueOf(0))).intValue() == 1) {
                this.qwc = true;
            }
        }
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        boolean hasSystemFeature = ah.getContext().getPackageManager().hasSystemFeature("android.hardware.bluetooth_le");
        if (defaultAdapter == null || !hasSystemFeature || VERSION.SDK_INT < 18 || defaultAdapter.getState() != 12) {
            this.qwd = 1;
        } else {
            this.qwd = 0;
        }
        if (defaultAdapter == null || defaultAdapter.getState() != 12) {
            i2 = 0;
        } else {
            i2 = 1;
        }
        if (hasSystemFeature) {
            i = 1;
        } else {
            i = 0;
        }
        if (this.qwa) {
            com.tencent.mm.plugin.report.service.h.pYm.e(13139, nullAsNil, nullAsNil2, Integer.valueOf(1), Integer.valueOf(this.qwd), Integer.valueOf(i2), Integer.valueOf(i));
        } else {
            com.tencent.mm.plugin.report.service.h.pYm.e(13139, nullAsNil, nullAsNil2, Integer.valueOf(0), Integer.valueOf(this.qwd), Integer.valueOf(i2), Integer.valueOf(i));
        }
        if (this.qwc || this.qwa) {
            this.qvZ = true;
            this.qvU = findViewById(R.id.eck);
            if (this.qwb) {
                if (defaultAdapter == null || defaultAdapter.getState() != 12) {
                    this.qvZ = false;
                } else if (defaultAdapter != null) {
                    defaultAdapter.getState();
                }
            }
        }
        com.tencent.mm.plugin.shake.c.a.f cjX = m.cjX();
        if (cjX.kaD == null) {
            cjX.kaD = new ArrayList();
        }
        cjX.kaD.add(new WeakReference(this));
        Boolean bool = Boolean.FALSE;
        long anT = bo.anT();
        long j = 0;
        long j2 = 0;
        if (aw.RK()) {
            aw.ZK();
            c.Ry().set(com.tencent.mm.storage.ac.a.USERINFO_IBEACON_PUSH_IS_IN_SHAKEUI_BOOLEAN, Boolean.TRUE);
            aw.ZK();
            Boolean valueOf = Boolean.valueOf(bo.a((Boolean) c.Ry().get(com.tencent.mm.storage.ac.a.USERINFO_IBEACON_PUSH_IS_OPEN_BOOLEAN, null), false));
            aw.ZK();
            j = bo.a((Long) c.Ry().get(com.tencent.mm.storage.ac.a.USERINFO_IBEACON_PUSH_OPEN_TIEMSTAMP_LONG, null), 0);
            aw.ZK();
            j2 = bo.a((Long) c.Ry().get(com.tencent.mm.storage.ac.a.USERINFO_IBEACON_PUSH_CHANNEL_OPEN_TIME_LONG, null), 0);
            bool = valueOf;
        }
        if (!bool.booleanValue() || anT - j >= j2) {
            initView();
        } else {
            this.qvJ = 5;
            this.qvZ = true;
            this.quX = true;
            initView();
            ckH();
            aw.ZK();
            String bc = bo.bc((String) c.Ry().get(com.tencent.mm.storage.ac.a.USERINFO_IBEACON_PUSH_LAST_BEACONINFO_STRING, null), "");
            aw.ZK();
            O = bo.bc((String) c.Ry().get(com.tencent.mm.storage.ac.a.USERINFO_IBEACON_PUSH_BEACONINFO_STRING, null), "");
            if (!(O == null || O.equals(""))) {
                String[] split = O.split(",");
                com.tencent.mm.plugin.shake.b.d dVar = new com.tencent.mm.plugin.shake.b.d();
                dVar.field_type = 11;
                dVar.field_username = split[0];
                dVar.field_nickname = split[0];
                dVar.field_signature = split[1];
                dVar.field_province = split[2];
                dVar.field_city = split[3];
                dVar.field_sex = 1;
                try {
                    dVar.field_lvbuffer = (String.valueOf(split[4]) + "," + String.valueOf(split[5]) + "," + String.valueOf(split[6])).getBytes(ProtocolPackage.ServerEncoding);
                } catch (UnsupportedEncodingException e2) {
                    ab.e("MicroMsg.ShakeReportUI", "[kevinkma]parst shakeItem error!");
                }
                dVar.field_insertBatch = 2;
                e cjS = m.cjS();
                cjS.cjI();
                cjS.a(dVar, true);
                List linkedList = new LinkedList();
                linkedList.add(dVar);
                b(linkedList, 1);
                aw.ZK();
                c.Ry().set(com.tencent.mm.storage.ac.a.USERINFO_IBEACON_PUSH_BEACONINFO_STRING, (Object) "");
                Object obj = bc + "," + split[4] + split[5] + split[6];
                aw.ZK();
                c.Ry().set(com.tencent.mm.storage.ac.a.USERINFO_IBEACON_PUSH_LAST_BEACONINFO_STRING, obj);
            }
        }
        this.qvc = new c(this.mController.ylv);
        this.oOS = new com.tencent.mm.pluginsdk.i.d(this);
        if (!this.oOS.diK()) {
            h.a((Context) this, (int) R.string.efi, (int) R.string.tz, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(24790);
                    ShakeReportUI.this.finish();
                    AppMethodBeat.o(24790);
                }
            });
        }
        if (com.tencent.mm.plugin.shake.a.gkF != null) {
            com.tencent.mm.plugin.shake.a.gkF.BS();
        }
        x.b((com.tencent.mm.platformtools.x.a) this);
        ab.i("MicroMsg.ShakeReportUI", "%s", getResources().getDisplayMetrics().toString());
        i = m.cjT().baS();
        com.tencent.mm.plugin.report.service.h.pYm.e(11317, Integer.valueOf(i), e.ckT());
        com.tencent.mm.plugin.report.service.h.pYm.e(11710, Integer.valueOf(1));
        com.tencent.mm.plugin.report.service.h.pYm.k(834, 0, 1);
        AppMethodBeat.o(24815);
    }

    public void onResume() {
        AppMethodBeat.i(24816);
        super.onResume();
        if (this.gwZ) {
            if (!com.tencent.mm.au.b.sO((String) com.tencent.mm.kernel.g.RP().Ry().get(274436, null))) {
                ab.i("MicroMsg.ShakeReportUI", "summerper checkPermission checkposition[%b], stack[%s], activity[%s]", Boolean.valueOf(com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.ACCESS_COARSE_LOCATION", 64, "", "")), bo.dpG(), this);
                if (!com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.ACCESS_COARSE_LOCATION", 64, "", "")) {
                    AppMethodBeat.o(24816);
                    return;
                }
            } else if (!com.tencent.mm.pluginsdk.permission.b.o(this, "android.permission.ACCESS_COARSE_LOCATION")) {
                if (((Boolean) com.tencent.mm.kernel.g.RP().Ry().get(com.tencent.mm.storage.ac.a.USERINFO_GDPR_LOCATION_PERMISSION_DESCRIBE_CONFIRM_BOOLEAN_SYNC, Boolean.FALSE)).booleanValue()) {
                    com.tencent.mm.pluginsdk.permission.b.b(this, "android.permission.ACCESS_COARSE_LOCATION", 64);
                    AppMethodBeat.o(24816);
                    return;
                }
                com.tencent.mm.plugin.account.a.b.a.b(this, getString(R.string.g7p, new Object[]{aa.dor()}), 30764, true);
                AppMethodBeat.o(24816);
                return;
            }
        }
        cdJ();
        AppMethodBeat.o(24816);
    }

    private void cdJ() {
        AppMethodBeat.i(24817);
        ckF();
        aw.ZK();
        c.a(this);
        aw.ZK();
        c.Ry().a(this);
        m.cjS().c(this);
        if (this.qvd.qrS != null) {
            this.qvd.qrS.resume();
        }
        ckG();
        new ak().postDelayed(new Runnable() {
            public final void run() {
                AppMethodBeat.i(24800);
                if (ShakeReportUI.this.oOS != null) {
                    ShakeReportUI.this.oOS.diJ();
                }
                AppMethodBeat.o(24800);
            }
        }, 1000);
        if (this.oOS != null) {
            this.oOS.diJ();
        }
        kx(false);
        ky(false);
        ckI();
        aw.ZK();
        String str = (String) c.Ry().get(327696, (Object) "1");
        if (k.cjQ()) {
            if (this.qvJ == 4) {
                kt(true);
            }
            if (str.equals("4")) {
                dy(findViewById(R.id.eci));
            }
        }
        if (str.equals(TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL)) {
            dy(findViewById(R.id.ecf));
        } else if (str.equals("6") && com.tencent.mm.plugin.shake.c.c.a.cks()) {
            dy(findViewById(R.id.ec_));
        }
        boolean bY = com.tencent.mm.x.c.PK().bY(262154, 266258);
        if (getIntent().getBooleanExtra("shake_music", false) && com.tencent.mm.aw.d.aim() && this.qvd.qrR != 3) {
            getIntent().putExtra("shake_music", false);
            this.qvJ = 3;
        } else if (getIntent().getBooleanExtra("shake_tv", false) && this.qvd.qrR != 4 && k.cjQ()) {
            getIntent().putExtra("shake_tv", false);
            this.qvJ = 4;
        } else if (this.qvd.qrR != 6 && com.tencent.mm.plugin.shake.c.c.a.cks() && (bY || getIntent().getBooleanExtra("shake_card", false))) {
            this.qvV = getIntent().getIntExtra("shake_card", 0);
            getIntent().putExtra("shake_card", false);
            ab.i("MicroMsg.ShakeReportUI", "onresume shake card tab is open, activity type is 0 or open from specialview");
            this.qvJ = 6;
        }
        ckH();
        ku(true);
        ab.d("MicroMsg.ShakeReportUI", "isShakeGetConfigList = %s", Boolean.valueOf(ae.gip));
        if (ae.gip) {
            aw.Rg().a(new com.tencent.mm.ba.k(7), 0);
        }
        ckR();
        ckO();
        ckC();
        AppMethodBeat.o(24817);
    }

    public void onPause() {
        AppMethodBeat.i(24818);
        aw.ZK();
        c.b(this);
        aw.ZK();
        c.Ry().b(this);
        m.cjS().d(this);
        if (this.qvd.qrS != null) {
            this.qvd.qrS.pause();
        }
        this.quZ = false;
        if (this.oOS != null) {
            this.oOS.bgr();
        }
        this.qvc.ckz();
        if (this.qvJ != 5) {
            aw.ZK();
            c.Ry().set(327696, this.qvJ);
        }
        if (this.qvJ == 4) {
            kt(false);
        }
        ckD();
        super.onPause();
        AppMethodBeat.o(24818);
    }

    public void onDestroy() {
        boolean z = false;
        AppMethodBeat.i(24819);
        if (!(this.qvy == null || this.qvy.isRecycled())) {
            this.qvy.recycle();
        }
        if (this.qvz != null && this.qvz.isShowing()) {
            this.qvz.dismiss();
            this.qvz = null;
        }
        if (this.qvd.qrS != null) {
            this.qvd.qrS.cjw();
        }
        if (this.oOS != null) {
            this.oOS.bgr();
            this.oOS = null;
        }
        j a = j.a(null);
        if (j.isInited) {
            j.isInited = false;
            if (!a.qtU.cku()) {
                ab.e("Micromsg.ShakeMusicMgr", "release MusicFingerPrintRecorder error");
            }
        }
        j.qtV = null;
        x.c((com.tencent.mm.platformtools.x.a) this);
        com.tencent.mm.sdk.b.a.xxA.d(this.qwg);
        com.tencent.mm.sdk.b.a.xxA.d(this.qwh);
        aw.ZK();
        c.Ry().set(com.tencent.mm.storage.ac.a.USERINFO_IBEACON_PUSH_IS_IN_SHAKEUI_BOOLEAN, Boolean.FALSE);
        ckD();
        if (com.tencent.mm.plugin.shake.c.c.a.cks()) {
            com.tencent.mm.x.c.PK().y(262154, false);
        }
        ckL();
        com.tencent.mm.plugin.shake.c.a.f cjX = m.cjX();
        if (cjX.kaD != null) {
            while (true) {
                boolean z2 = z;
                if (z2 >= cjX.kaD.size()) {
                    break;
                }
                WeakReference weakReference = (WeakReference) cjX.kaD.get(z2);
                if (weakReference != null) {
                    com.tencent.mm.plugin.shake.c.a.f.a aVar = (com.tencent.mm.plugin.shake.c.a.f.a) weakReference.get();
                    if (aVar != null && aVar.equals(this)) {
                        cjX.kaD.remove(weakReference);
                        break;
                    }
                }
                z = z2 + 1;
            }
        }
        com.tencent.mm.plugin.shake.c.a.d cjY = m.cjY();
        cjY.ecs = -85.0f;
        cjY.ect = -1000.0f;
        if (this.ecr != null) {
            this.ecr.c(this.ecy);
        }
        super.onDestroy();
        AppMethodBeat.o(24819);
    }

    static {
        AppMethodBeat.i(24872);
        AppMethodBeat.o(24872);
    }

    private void ckC() {
        AppMethodBeat.i(24820);
        if (ckQ()) {
            if (BluetoothAdapter.getDefaultAdapter() != null) {
                List<String> Nl = g.Nv().Nl();
                if (Nl != null) {
                    this.qwe = System.currentTimeMillis();
                    for (String str : Nl) {
                        ab.i("MicroMsg.ShakeReportUI", "op=true,iBeacon = %s", str);
                        ds dsVar = new ds();
                        dsVar.cxg.cxi = str;
                        dsVar.cxg.cxf = true;
                        com.tencent.mm.sdk.b.a.xxA.m(dsVar);
                    }
                }
            }
            AppMethodBeat.o(24820);
            return;
        }
        AppMethodBeat.o(24820);
    }

    private void ckD() {
        AppMethodBeat.i(24821);
        aw.ZK();
        if (!bo.a((Boolean) c.Ry().get(com.tencent.mm.storage.ac.a.USERINFO_IBEACON_PUSH_IS_IN_SHAKEUI_BOOLEAN, null), false)) {
            this.ecv.clear();
            ecw = new CopyOnWriteArrayList();
        }
        if (VERSION.SDK_INT >= 18) {
            List<String> Nl = g.Nv().Nl();
            if (Nl != null) {
                for (String str : Nl) {
                    ds dsVar = new ds();
                    ab.i("MicroMsg.ShakeReportUI", "op=false,iBeacon = %s", str);
                    dsVar.cxg.cxi = str;
                    dsVar.cxg.cxf = false;
                    com.tencent.mm.sdk.b.a.xxA.m(dsVar);
                }
            }
        }
        AppMethodBeat.o(24821);
    }

    public final void initView() {
        AppMethodBeat.i(24822);
        com.tencent.mm.plugin.shake.c.c.a.cjM();
        this.qvY.put(Integer.valueOf(1), Boolean.TRUE);
        this.qvY.put(Integer.valueOf(3), Boolean.FALSE);
        this.qvY.put(Integer.valueOf(4), Boolean.FALSE);
        this.qvY.put(Integer.valueOf(5), Boolean.FALSE);
        this.qvY.put(Integer.valueOf(6), Boolean.FALSE);
        this.fGv = new com.tencent.mm.at.a.a((Context) this);
        this.qvh = (TextView) findViewById(R.id.ebv);
        this.qvg = findViewById(R.id.ebw);
        this.qvi = (TextView) findViewById(R.id.eby);
        this.qvj = (TextView) findViewById(R.id.ebx);
        this.qvL = findViewById(R.id.ecm);
        this.qvM = (ImageView) findViewById(R.id.eco);
        this.qvN = (ImageView) findViewById(R.id.ecq);
        this.qvO = (ImageView) findViewById(R.id.ecs);
        this.qvP = (ImageView) findViewById(R.id.ecu);
        this.qvQ = findViewById(R.id.ecn);
        this.qvR = findViewById(R.id.ecp);
        this.qvS = findViewById(R.id.ecr);
        this.qvT = findViewById(R.id.ect);
        this.qvf = findViewById(R.id.ec1);
        this.qvf.setOnClickListener(this.qwi);
        this.eks = (ImageView) this.qvf.findViewById(R.id.ec2);
        this.eks.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(24808);
                if (ShakeReportUI.this.qvJ != 5) {
                    Intent intent = new Intent(ShakeReportUI.this.mController.ylL, ProfileHdHeadImg.class);
                    intent.putExtra("username", (String) ShakeReportUI.this.qvf.getTag());
                    ShakeReportUI.this.startActivity(intent);
                }
                AppMethodBeat.o(24808);
            }
        });
        ckF();
        View inflate = View.inflate(this.mController.ylL, R.layout.asb, null);
        this.qvz = new i(this.mController.ylL, R.style.zt);
        this.qvz.setContentView(inflate);
        this.qvz.setOnCancelListener(new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(24779);
                Looper.myQueue().addIdleHandler(new IdleHandler() {
                    public final boolean queueIdle() {
                        AppMethodBeat.i(24778);
                        t.a(ShakeReportUI.this, 0, ShakeReportUI.this.getString(R.string.eg0));
                        aw.ZK();
                        c.Ry().set(4117, Boolean.TRUE);
                        AppMethodBeat.o(24778);
                        return false;
                    }
                });
                AppMethodBeat.o(24779);
            }
        });
        ((Button) inflate.findViewById(R.id.ebi)).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(24780);
                ShakeReportUI.this.qvz.cancel();
                AppMethodBeat.o(24780);
            }
        });
        aw.ZK();
        boolean e = bo.e((Boolean) c.Ry().get(4108, null));
        aw.ZK();
        boolean e2 = bo.e((Boolean) c.Ry().get(4117, null));
        if (!e) {
            inflate.setVisibility(0);
            this.qvz.show();
            aw.ZK();
            c.Ry().set(4108, Boolean.TRUE);
        } else if (!e2) {
            Looper.myQueue().addIdleHandler(new IdleHandler() {
                public final boolean queueIdle() {
                    AppMethodBeat.i(24781);
                    t.a(ShakeReportUI.this, 0, ShakeReportUI.this.getString(R.string.eg0));
                    aw.ZK();
                    c.Ry().set(4117, Boolean.TRUE);
                    AppMethodBeat.o(24781);
                    return false;
                }
            });
        }
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(24809);
                ShakeReportUI.this.quX = false;
                ShakeReportUI.this.finish();
                AppMethodBeat.o(24809);
                return true;
            }
        });
        addIconOptionMenu(0, R.string.cg, R.raw.actionbar_setting_icon, new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(24810);
                ShakeReportUI.this.quX = false;
                Intent intent = new Intent();
                intent.setClass(ShakeReportUI.this, ShakePersonalInfoUI.class);
                ShakeReportUI.this.startActivityForResult(intent, 3);
                AppMethodBeat.o(24810);
                return true;
            }
        });
        AnonymousClass29 anonymousClass29 = new View.OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(24811);
                ShakeReportUI.a(ShakeReportUI.this, view);
                AppMethodBeat.o(24811);
            }
        };
        if (this.qwc || this.qwa) {
            this.qvA = (ImageView) findViewById(R.id.ecl);
        } else {
            this.qvA = (ImageView) findViewById(R.id.ec9);
        }
        this.qvC = (ImageView) findViewById(R.id.ece);
        this.qvD = (ImageView) findViewById(R.id.ecg);
        this.qvE = (ImageView) findViewById(R.id.ecj);
        this.qvF = (ImageView) findViewById(R.id.eca);
        this.qvI = (TextView) findViewById(R.id.ecc);
        this.qvH = (ImageView) findViewById(R.id.ecb);
        this.qvG = (ImageView) findViewById(R.id.ech);
        ckN();
        this.qvU.setOnClickListener(anonymousClass29);
        findViewById(R.id.eck).setOnClickListener(anonymousClass29);
        findViewById(R.id.ecd).setOnClickListener(anonymousClass29);
        findViewById(R.id.ecf).setOnClickListener(anonymousClass29);
        findViewById(R.id.eci).setOnClickListener(anonymousClass29);
        findViewById(R.id.ec_).setOnClickListener(anonymousClass29);
        com.tencent.mm.sdk.b.a.xxA.c(this.qwg);
        com.tencent.mm.sdk.b.a.xxA.c(this.qwh);
        ckJ();
        ckM();
        ckR();
        AppMethodBeat.o(24822);
    }

    private void ckE() {
        AppMethodBeat.i(24823);
        if (com.tencent.mm.aw.d.ain()) {
            aw.ZK();
            if (c.Ry().getInt(4118, 0) == 0) {
                com.tencent.mm.ui.widget.a.c.a aVar = new com.tencent.mm.ui.widget.a.c.a(this.mController.ylL);
                aVar.PV(R.string.tz);
                aVar.PZ(R.string.eeu);
                aVar.Qc(R.string.eet).a(new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.i(24776);
                        if (ShakeReportUI.this.qvz != null) {
                            ShakeReportUI.this.qvz.cancel();
                        }
                        AppMethodBeat.o(24776);
                    }
                });
                aVar.rc(true);
                aVar.f(new OnCancelListener() {
                    public final void onCancel(DialogInterface dialogInterface) {
                        AppMethodBeat.i(24777);
                        aw.ZK();
                        c.Ry().setInt(4118, 1);
                        ShakeReportUI.this.qvG.setVisibility(8);
                        AppMethodBeat.o(24777);
                    }
                });
                this.qvz = aVar.aMb();
                this.qvz.show();
            }
        }
        AppMethodBeat.o(24823);
    }

    private void ckF() {
        AppMethodBeat.i(24824);
        aw.ZK();
        int a = bo.a((Integer) c.Ry().get(12290, null), 0);
        ImageView imageView = (ImageView) findViewById(R.id.ebp);
        if (!(this.qvy == null || this.qvy.isRecycled())) {
            this.qvy.recycle();
        }
        aw.ZK();
        if (bo.d((Boolean) c.Ry().get(4110, null))) {
            StringBuilder stringBuilder = new StringBuilder();
            aw.ZK();
            String stringBuilder2 = stringBuilder.append(c.XW()).append("default_shake_img_filename.jpg").toString();
            if (com.tencent.mm.vfs.e.ct(stringBuilder2)) {
                this.qvy = x.vv(stringBuilder2);
                imageView.setImageDrawable(new BitmapDrawable(this.qvy));
            } else {
                Drawable bitmapDrawable;
                try {
                    bitmapDrawable = new BitmapDrawable(com.tencent.mm.sdk.platformtools.d.decodeStream(this.mController.ylL.getAssets().open("resource/shakehideimg_man.jpg")));
                } catch (IOException e) {
                    ab.w("MicroMsg.ShakeReportUI", "Bg decode exp:" + e.getLocalizedMessage());
                    bitmapDrawable = null;
                }
                imageView.setImageDrawable(bitmapDrawable);
            }
        } else {
            aw.ZK();
            this.qvy = x.vv((String) c.Ry().get(4111, null));
            imageView.setImageDrawable(new BitmapDrawable(this.qvy));
        }
        imageView = (ImageView) findViewById(R.id.ebr);
        ImageView imageView2 = (ImageView) findViewById(R.id.ebu);
        imageView.setImageResource(a == 2 ? R.drawable.bhg : R.drawable.bhh);
        imageView2.setImageResource(a == 2 ? R.drawable.bhf : R.drawable.bhe);
        AnonymousClass7 anonymousClass7 = new View.OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(24784);
                if (ShakeReportUI.this.quV) {
                    ShakeReportUI.this.quZ = false;
                    ShakeReportUI.this.quU = true;
                    ShakeReportUI.d(ShakeReportUI.this, false);
                    h.a(ShakeReportUI.this.mController.ylL, null, new String[]{ShakeReportUI.this.getString(R.string.eey)}, "", new h.c() {
                        public final void iE(int i) {
                            AppMethodBeat.i(24782);
                            ShakeReportUI.this.quZ = true;
                            switch (i) {
                                case 0:
                                    n.a(ShakeReportUI.this, 1, null);
                                    break;
                            }
                            AppMethodBeat.o(24782);
                        }
                    }, new OnCancelListener() {
                        public final void onCancel(DialogInterface dialogInterface) {
                            AppMethodBeat.i(24783);
                            ShakeReportUI.this.quZ = true;
                            AppMethodBeat.o(24783);
                        }
                    });
                    AppMethodBeat.o(24784);
                    return;
                }
                AppMethodBeat.o(24784);
            }
        };
        imageView.setOnClickListener(anonymousClass7);
        imageView2.setOnClickListener(anonymousClass7);
        if (this.qvm == null) {
            this.qvm = findViewById(R.id.ebz);
        }
        this.qvm.setOnClickListener(anonymousClass7);
        if (this.qvn == null) {
            this.qvn = findViewById(R.id.ebs);
        }
        this.qvn.setOnClickListener(anonymousClass7);
        AppMethodBeat.o(24824);
    }

    private void ckG() {
        AppMethodBeat.i(24825);
        this.quZ = true;
        if (!(this.qvW == null || !this.qvW.isShowing() || this.qvW.qsZ)) {
            this.quZ = false;
        }
        ab.i("MicroMsg.ShakeReportUI", "tryStartShake");
        if (!(this.oOS == null || this.oOS.diI())) {
            this.oOS.a(new a(this));
            if (!this.oOS.diK() || this.qvh == null) {
                this.qvh.setText(getString(R.string.efi));
            } else {
                this.qvh.setText(getString(R.string.edu));
                AppMethodBeat.o(24825);
                return;
            }
        }
        AppMethodBeat.o(24825);
    }

    private void kt(boolean z) {
        AppMethodBeat.i(24826);
        String format = String.format("%1$s-shaketype-%2$d", new Object[]{getClass().getName(), Integer.valueOf(4)});
        ab.d("MicroMsg.ShakeReportUI", "activate change report , class name=" + format + ", isActive=" + z);
        y.d(z, new Intent().putExtra("classname", format));
        AppMethodBeat.o(24826);
    }

    private void ckH() {
        AppMethodBeat.i(24827);
        if (this.qvJ == 3 && com.tencent.mm.aw.d.aim()) {
            this.qvJ = 3;
            this.qvj.setText(R.string.efy);
            this.qvA.setBackgroundResource(R.drawable.bha);
            this.qvC.setBackgroundResource(R.drawable.anv);
            this.qvD.setBackgroundResource(R.drawable.anu);
            this.qvE.setBackgroundResource(R.drawable.anx);
            this.qvF.setBackgroundResource(R.drawable.bh8);
            findViewById(R.id.ec7).setVisibility(0);
            setMMTitle((int) R.string.efu);
            com.tencent.mm.plugin.report.service.h.pYm.e(11720, Integer.valueOf(2));
            com.tencent.mm.plugin.report.service.h.pYm.k(834, 2, 1);
        } else if (this.qvJ == 4 && k.cjQ()) {
            this.qvJ = 4;
            this.qvj.setText(R.string.efz);
            this.qvA.setBackgroundResource(R.drawable.bha);
            this.qvC.setBackgroundResource(R.drawable.anv);
            this.qvD.setBackgroundResource(R.drawable.ant);
            this.qvE.setBackgroundResource(R.drawable.any);
            this.qvF.setBackgroundResource(R.drawable.bh8);
            findViewById(R.id.ec7).setVisibility(0);
            setMMTitle((int) R.string.efv);
            com.tencent.mm.plugin.report.service.h.pYm.e(11720, Integer.valueOf(3));
            com.tencent.mm.plugin.report.service.h.pYm.k(834, 3, 1);
        } else if (this.qvJ == 5 && ckP()) {
            this.qvJ = 5;
            this.qvj.setText(R.string.efx);
            this.qvA.setBackgroundResource(R.drawable.bhb);
            this.qvC.setBackgroundResource(R.drawable.anv);
            this.qvD.setBackgroundResource(R.drawable.ant);
            this.qvE.setBackgroundResource(R.drawable.anx);
            this.qvF.setBackgroundResource(R.drawable.bh8);
            findViewById(R.id.ec7).setVisibility(0);
            setMMTitle((int) R.string.eft);
            com.tencent.mm.plugin.report.service.h.pYm.e(11720, Integer.valueOf(4));
            com.tencent.mm.plugin.report.service.h.pYm.k(834, 4, 1);
        } else if (this.qvJ == 6 && com.tencent.mm.plugin.shake.c.c.a.cks()) {
            this.qvJ = 6;
            this.qvj.setText(R.string.efw);
            this.qvA.setBackgroundResource(R.drawable.bha);
            this.qvC.setBackgroundResource(R.drawable.anv);
            this.qvD.setBackgroundResource(R.drawable.ant);
            this.qvE.setBackgroundResource(R.drawable.anx);
            this.qvF.setBackgroundResource(R.drawable.bh9);
            findViewById(R.id.ec7).setVisibility(0);
            setMMTitle((int) R.string.efs);
            ckK();
            ckN();
            com.tencent.mm.plugin.report.service.h.pYm.e(11720, Integer.valueOf(5));
            com.tencent.mm.plugin.report.service.h.pYm.k(834, 5, 1);
        } else {
            this.qvJ = 1;
            this.qvj.setText(R.string.eed);
            this.qvA.setBackgroundResource(R.drawable.bha);
            this.qvC.setBackgroundResource(R.drawable.anw);
            this.qvD.setBackgroundResource(R.drawable.ant);
            this.qvE.setBackgroundResource(R.drawable.anx);
            this.qvF.setBackgroundResource(R.drawable.bh8);
            if (com.tencent.mm.aw.d.aim()) {
                findViewById(R.id.ec7).setVisibility(0);
            }
            setMMTitle((int) R.string.efr);
            com.tencent.mm.plugin.report.service.h.pYm.e(11720, Integer.valueOf(1));
            com.tencent.mm.plugin.report.service.h.pYm.k(834, 1, 1);
        }
        l.b a = this.qvd.a(this, this.qvJ, this);
        if (!this.quX) {
            ky(false);
        }
        if (com.tencent.mm.plugin.shake.c.c.a.cks() && (a instanceof com.tencent.mm.plugin.shake.c.a.g)) {
            ((com.tencent.mm.plugin.shake.c.a.g) a).setFromScene(this.qvV);
            if (this.qvV == 3) {
                ab.i("MicroMsg.ShakeReportUI", "open shake card from specialview");
                ((com.tencent.mm.plugin.shake.c.a.g) a).Ix(getIntent().getStringExtra("key_shake_card_ext_info"));
            }
        }
        AppMethodBeat.o(24827);
    }

    private void ckI() {
        AppMethodBeat.i(24828);
        aw.ZK();
        this.quW = bo.d((Boolean) c.Ry().get(4112, null));
        if (this.quW) {
            setTitleMuteIconVisibility(8);
            AppMethodBeat.o(24828);
            return;
        }
        setTitleMuteIconVisibility(0);
        AppMethodBeat.o(24828);
    }

    private void ku(boolean z) {
        AppMethodBeat.i(24829);
        kv(z);
        kw(z);
        AppMethodBeat.o(24829);
    }

    private void kv(boolean z) {
        AppMethodBeat.i(24830);
        if (this.qvs == null) {
            this.qvs = findViewById(R.id.c_x);
        }
        if (this.qvd.qrR == 3 || this.qvd.qrR == 4 || this.qvd.qrR == 5 || this.qvd.qrR == 6 || !z) {
            this.qvs.setVisibility(8);
            AppMethodBeat.o(24830);
            return;
        }
        int baS = com.tencent.mm.bi.d.akR().baS();
        if (baS <= 0) {
            this.qvs.setVisibility(8);
            AppMethodBeat.o(24830);
            return;
        }
        this.qvs.setVisibility(0);
        ((TextView) this.qvs.findViewById(R.id.c_z)).setText(getResources().getQuantityString(R.plurals.a1, baS, new Object[]{Integer.valueOf(baS)}));
        this.qvs.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(24785);
                Intent intent = new Intent(ShakeReportUI.this, ShakeSayHiListUI.class);
                intent.putExtra("IntentSayHiType", 1);
                ShakeReportUI.this.startActivity(intent);
                AppMethodBeat.o(24785);
            }
        });
        if (this.qvw == null) {
            this.qvw = (ImageView) findViewById(R.id.c_y);
        }
        bt duu = com.tencent.mm.bi.d.akR().duu();
        if (duu != null) {
            this.qvx = duu.field_sayhiuser;
            com.tencent.mm.pluginsdk.ui.a.b.b(this.qvw, this.qvx);
        }
        AppMethodBeat.o(24830);
    }

    private void kw(boolean z) {
        AppMethodBeat.i(24831);
        if (this.qvt == null) {
            this.qvt = findViewById(R.id.ca0);
        }
        if (z) {
            if (m.cjT().baS() <= 0) {
                this.qvt.setVisibility(8);
                AppMethodBeat.o(24831);
                return;
            }
            if (this.qvv == null) {
                this.qvv = (TextView) this.qvt.findViewById(R.id.ca2);
            }
            this.qvv.setText(getString(R.string.efb, new Object[]{Integer.valueOf(r1)}));
            this.qvt.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(24786);
                    Intent intent = new Intent(ShakeReportUI.this, ShakeMsgListUI.class);
                    intent.putExtra("shake_msg_from", 1);
                    intent.putExtra("shake_msg_list_title", ShakeReportUI.this.getString(R.string.egm));
                    ShakeReportUI.this.startActivity(intent);
                    AppMethodBeat.o(24786);
                }
            });
            if (this.qvu == null) {
                this.qvu = (MMImageView) findViewById(R.id.ca1);
            }
            com.tencent.mm.plugin.shake.b.f cjJ = m.cjT().cjJ();
            if (cjJ != null) {
                String str = cjJ.field_thumburl;
                if (bo.isNullOrNil(str)) {
                    this.qvu.setImageResource(R.raw.app_attach_file_icon_webpage);
                } else {
                    v bVar = new com.tencent.mm.plugin.shake.e.b(str);
                    Bitmap a = x.a(bVar);
                    this.qvu.setTag(bVar.anL());
                    if (a == null || a.isRecycled()) {
                        this.qvu.setImageResource(R.raw.app_attach_file_icon_webpage);
                    } else {
                        this.qvu.setImageBitmap(a);
                    }
                }
            }
            this.qvt.setVisibility(0);
            AppMethodBeat.o(24831);
            return;
        }
        this.qvt.setVisibility(8);
        AppMethodBeat.o(24831);
    }

    private void kx(boolean z) {
        AppMethodBeat.i(24832);
        if (this.qvi != null) {
            if (z) {
                this.qvi.setVisibility(0);
                AppMethodBeat.o(24832);
                return;
            }
            this.qvi.setVisibility(8);
            this.qvi.cancelLongPress();
        }
        AppMethodBeat.o(24832);
    }

    private void ky(boolean z) {
        AppMethodBeat.i(24833);
        if (this.qvg != null) {
            if (z) {
                this.qvg.setVisibility(0);
                AppMethodBeat.o(24833);
                return;
            }
            this.qvg.setVisibility(4);
        }
        AppMethodBeat.o(24833);
    }

    private void CD(int i) {
        AppMethodBeat.i(24834);
        ky(i == 1);
        if (i == 2) {
            kx(true);
            AppMethodBeat.o(24834);
            return;
        }
        kx(false);
        AppMethodBeat.o(24834);
    }

    public final void ZB() {
        AppMethodBeat.i(24835);
        ckH();
        AppMethodBeat.o(24835);
    }

    private void WM(String str) {
        AppMethodBeat.i(24836);
        this.quX = false;
        if (this.quW) {
            ay.au(this.mController.ylL, R.string.efh);
        }
        if (this.qvr == null) {
            this.qvr = AnimationUtils.loadAnimation(this.mController.ylL, R.anim.ay);
        }
        CD(2);
        if (str == null || str.length() <= 1) {
            this.qvi.setText(R.string.eek);
        } else {
            this.qvi.setText(str);
        }
        this.qvi.startAnimation(this.qvr);
        this.qva = true;
        al.n(new Runnable() {
            public final void run() {
                AppMethodBeat.i(24792);
                ShakeReportUI.K(ShakeReportUI.this);
                ShakeReportUI.d(ShakeReportUI.this, false);
                AppMethodBeat.o(24792);
            }
        }, this.qvr.getDuration());
        AppMethodBeat.o(24836);
    }

    public final void b(List<com.tencent.mm.plugin.shake.b.d> list, long j) {
        AppMethodBeat.i(24837);
        ckR();
        if (list == null || !this.quX || j == 6) {
            this.qvB = null;
            if (j == 6) {
                WM(getString(R.string.ees));
                AppMethodBeat.o(24837);
                return;
            } else if (j == 7) {
                WM(getString(R.string.eeq));
                AppMethodBeat.o(24837);
                return;
            } else if (j == 8) {
                WM(getString(R.string.eeo));
                AppMethodBeat.o(24837);
                return;
            } else if (j == 9) {
                WM(getString(R.string.een));
                AppMethodBeat.o(24837);
                return;
            } else if (j == 10) {
                WM(getString(R.string.eer));
                AppMethodBeat.o(24837);
                return;
            } else {
                WM(null);
                AppMethodBeat.o(24837);
                return;
            }
        }
        this.quX = false;
        if (list.size() > 0) {
            this.qvB = (com.tencent.mm.plugin.shake.b.d) list.get(0);
        }
        int size;
        Intent intent;
        if (this.qvd.qrR == 1) {
            if (list.size() <= 0 || ((com.tencent.mm.plugin.shake.b.d) list.get(0)).field_type == 0) {
                this.qvb = ((com.tencent.mm.plugin.shake.b.d) list.get(0)).scene;
                size = list.size();
                if (size == 0) {
                    WM(null);
                    AppMethodBeat.o(24837);
                    return;
                } else if (size == 1) {
                    String str = ((com.tencent.mm.plugin.shake.b.d) list.get(0)).field_username;
                    ab.i("MicroMsg.ShakeReportUI", "1 u:" + str + " n:" + ((com.tencent.mm.plugin.shake.b.d) list.get(0)).field_nickname + " d:" + ((com.tencent.mm.plugin.shake.b.d) list.get(0)).field_distance);
                    if (this.quW) {
                        ay.au(this.mController.ylL, R.string.ef_);
                    }
                    CD(3);
                    c((com.tencent.mm.plugin.shake.b.d) list.get(0));
                    AppMethodBeat.o(24837);
                    return;
                } else {
                    if (this.quW) {
                        ay.au(this.mController.ylL, R.string.ef_);
                    }
                    CD(3);
                    kv(false);
                    intent = new Intent(this, ShakeItemListUI.class);
                    intent.putExtra("_key_show_type_", -1);
                    intent.putExtra("_key_title_", getString(R.string.ef5));
                    startActivity(intent);
                    AppMethodBeat.o(24837);
                    return;
                }
            }
            WM(null);
            AppMethodBeat.o(24837);
        } else if (this.qvd.qrR == 3) {
            size = list.size();
            if (size == 0) {
                WM(getString(R.string.efg));
                AppMethodBeat.o(24837);
                return;
            }
            if (size == 1) {
                if (this.quW) {
                    ay.au(this.mController.ylL, R.string.ef_);
                }
                CD(3);
                if (((com.tencent.mm.plugin.shake.b.d) list.get(0)).field_type == 4) {
                    com.tencent.mm.aw.e d = com.tencent.mm.plugin.shake.d.a.i.d(((com.tencent.mm.plugin.shake.b.d) list.get(0)).field_lvbuffer, j);
                    com.tencent.mm.aw.a.c(d);
                    Intent intent2 = new Intent();
                    intent2.putExtra("key_mode", 1);
                    intent2.putExtra("key_offset", d.fJV);
                    intent2.putExtra("music_player_beg_time", d.fKn);
                    intent2.putExtra("key_scene", 3);
                    if (com.tencent.mm.aw.d.ain()) {
                        intent2.putExtra("KGlobalShakeMusic", true);
                    }
                    com.tencent.mm.bp.d.b((Context) this, "music", ".ui.MusicMainUI", intent2);
                    AppMethodBeat.o(24837);
                    return;
                }
                ab.w("MicroMsg.ShakeReportUI", "Unexpected type, ignore.");
            }
            AppMethodBeat.o(24837);
        } else if (this.qvd.qrR == 4) {
            ckR();
            size = list.size();
            if (size == 0) {
                WM(getString(R.string.egn));
                AppMethodBeat.o(24837);
                return;
            }
            if (size == 1) {
                if (this.quW) {
                    ay.au(this.mController.ylL, R.string.ef_);
                }
                CD(3);
                k.a((com.tencent.mm.plugin.shake.b.d) list.get(0), this);
            }
            AppMethodBeat.o(24837);
        } else {
            if (this.qvd.qrR == 5) {
                switch ((int) j) {
                    case 1:
                        if (list.isEmpty() || ((com.tencent.mm.plugin.shake.b.d) list.get(0)).field_type != 11) {
                            WM(null);
                            AppMethodBeat.o(24837);
                            return;
                        } else if (list.size() == 1) {
                            if (this.quW) {
                                ay.au(this.mController.ylL, R.string.ef_);
                            }
                            CD(3);
                            d((com.tencent.mm.plugin.shake.b.d) list.get(0));
                            AppMethodBeat.o(24837);
                            return;
                        } else {
                            if (this.quW) {
                                ay.au(this.mController.ylL, R.string.ef_);
                            }
                            CD(3);
                            kv(false);
                            intent = new Intent(this, ShakeItemListUI.class);
                            intent.putExtra("_key_show_type_", -12);
                            intent.putExtra("_key_title_", getString(R.string.ef3));
                            intent.putExtra("_key_show_from_shake_", true);
                            intent.putExtra("_ibeacon_new_insert_size", list.size());
                            startActivity(intent);
                            AppMethodBeat.o(24837);
                            return;
                        }
                    case 6:
                        WM(getString(R.string.ees));
                        break;
                }
            }
            AppMethodBeat.o(24837);
        }
    }

    public final void a(int i, final com.tencent.mm.plugin.shake.c.a.e eVar, long j) {
        AppMethodBeat.i(24838);
        this.qvX = true;
        if (i != 1251) {
            if (i == 1250) {
                if (eVar != null) {
                    if ((eVar != null && !this.quX) || this.quX) {
                        this.quX = false;
                        ab.i("MicroMsg.ShakeReportUI", "onShakeCardReturn MMFunc_Biz_ShakeCard");
                        if (this.qvd.qrR == 6) {
                            l.b bVar = this.qvd.qrS;
                            if (bVar != null && (bVar instanceof com.tencent.mm.plugin.shake.c.a.g)) {
                                com.tencent.mm.plugin.shake.c.a.g gVar = (com.tencent.mm.plugin.shake.c.a.g) bVar;
                                switch ((int) j) {
                                    case 1:
                                        ab.i("MicroMsg.ShakeReportUI", "onShakeGetReturn() ShakeCardService RETURN_OK");
                                        if (gVar.kdC == 3) {
                                            ab.i("MicroMsg.ShakeReportUI", "onShakeGetReturn() actionType is  MMBIZ_SHAKE_CARD_ACTION_TYPE_NO_CARD");
                                            if (eVar == null || TextUtils.isEmpty(eVar.qsu)) {
                                                WM(getString(R.string.ee_));
                                                AppMethodBeat.o(24838);
                                                return;
                                            }
                                            WM(eVar.qsu);
                                            AppMethodBeat.o(24838);
                                            return;
                                        }
                                        ab.i("MicroMsg.ShakeReportUI", "onShakeGetReturn() actionType is " + gVar.kdC);
                                        CD(3);
                                        if (eVar.kdC == 1) {
                                            this.quZ = false;
                                        }
                                        if (this.qvW != null && this.qvW.isShowing()) {
                                            AppMethodBeat.o(24838);
                                            return;
                                        } else if (eVar.qsw) {
                                            ViewStub viewStub = (ViewStub) findViewById(R.id.ec0);
                                            if (viewStub != null) {
                                                viewStub.inflate();
                                            }
                                            ((ShakeEggAnimFrame) findViewById(R.id.av0)).aa(this);
                                            new ak().postDelayed(new Runnable() {
                                                public final void run() {
                                                    AppMethodBeat.i(24793);
                                                    ShakeReportUI.a(ShakeReportUI.this, eVar);
                                                    AppMethodBeat.o(24793);
                                                }
                                            }, 1000);
                                            AppMethodBeat.o(24838);
                                            return;
                                        } else {
                                            a(eVar);
                                            AppMethodBeat.o(24838);
                                            return;
                                        }
                                    case 2:
                                        ab.i("MicroMsg.ShakeReportUI", "onShakeGetReturn() ShakeCardService RETURN_ERR_REPORT");
                                        WM(getString(R.string.ee_));
                                        break;
                                }
                            }
                        }
                    }
                    this.qvB = null;
                    WM(null);
                    AppMethodBeat.o(24838);
                    return;
                }
                this.qvB = null;
                WM(null);
                AppMethodBeat.o(24838);
                return;
            }
            AppMethodBeat.o(24838);
        } else if (eVar == null) {
            AppMethodBeat.o(24838);
        } else {
            ab.i("MicroMsg.ShakeReportUI", "onShakeCardReturn MMFunc_Biz_GetLbsCard");
            com.tencent.mm.plugin.shake.c.c.a.cjM();
            ckO();
            ckJ();
            ckM();
            this.qvV = 4;
            m.cjY().putValue("key_shake_card_item", eVar);
            AppMethodBeat.o(24838);
        }
    }

    private void a(com.tencent.mm.plugin.shake.c.a.e eVar) {
        AppMethodBeat.i(24839);
        this.qvW = com.tencent.mm.plugin.shake.c.b.a.a(this, eVar, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(24794);
                dialogInterface.dismiss();
                ShakeReportUI.this.quZ = true;
                ShakeReportUI.this.qvW = null;
                ShakeReportUI.this.qvj.setText("");
                AppMethodBeat.o(24794);
            }
        }, new com.tencent.mm.plugin.shake.c.b.a.b() {
            public final void ckg() {
                AppMethodBeat.i(24795);
                ShakeReportUI.this.quZ = true;
                ShakeReportUI.this.qvj.setText("");
                AppMethodBeat.o(24795);
            }
        });
        AppMethodBeat.o(24839);
    }

    private void dy(View view) {
        AppMethodBeat.i(24840);
        if (view == null) {
            AppMethodBeat.o(24840);
            return;
        }
        ab.i("MicroMsg.ShakeReportUI", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", Boolean.valueOf(com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.RECORD_AUDIO", 80, "", "")), bo.dpG(), this);
        if (com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.RECORD_AUDIO", 80, "", "")) {
            be("", false);
            if (view.getId() == R.id.ecd) {
                com.tencent.mm.plugin.report.service.h.pYm.e(11722, Integer.valueOf(1));
                if (this.qvJ != 1) {
                    if (this.qvJ == 4) {
                        kt(false);
                    }
                    this.qvJ = 1;
                    ckH();
                    kv(false);
                    if (this.qvf != null) {
                        this.qvf.setVisibility(8);
                    }
                }
            } else if (view.getId() == R.id.ecf) {
                com.tencent.mm.plugin.report.service.h.pYm.e(11722, Integer.valueOf(2));
                if (!(this.ecu || this.ecr == null)) {
                    this.ecr.a(this.ecy, true);
                }
                if (!(com.tencent.mm.r.a.bJ(this) || com.tencent.mm.r.a.bH(this) || this.qvJ == 3)) {
                    if (this.qvJ == 4) {
                        kt(false);
                    }
                    this.qvJ = 3;
                    ckH();
                    kv(false);
                    if (this.qvf != null) {
                        this.qvf.setVisibility(8);
                    }
                }
                ckE();
            } else if (view.getId() == R.id.eci) {
                com.tencent.mm.plugin.report.service.h.pYm.e(11722, Integer.valueOf(3));
                if (!(this.ecu || this.ecr == null)) {
                    this.ecr.a(this.ecy, true);
                }
                if (!(com.tencent.mm.r.a.bJ(this) || com.tencent.mm.r.a.bH(this) || this.qvJ == 4)) {
                    kt(true);
                    this.qvJ = 4;
                    ckH();
                    kv(false);
                    if (this.qvf != null) {
                        this.qvf.setVisibility(8);
                    }
                }
            } else if (view.getId() == R.id.eck || view.getId() == R.id.ec8) {
                com.tencent.mm.plugin.report.service.h.pYm.e(11722, Integer.valueOf(4));
                if (this.qvJ != 5) {
                    this.qvJ = 5;
                    ckH();
                    kv(false);
                    if (this.qvf != null) {
                        this.qvf.setVisibility(8);
                    }
                    if (!(VERSION.RELEASE.equals("6.0") || VERSION.RELEASE.equals("6.0.0") || VERSION.SDK_INT < 23)) {
                        boolean isProviderEnabled;
                        LocationManager locationManager = (LocationManager) ah.getContext().getSystemService(FirebaseAnalytics.b.LOCATION);
                        if (locationManager != null) {
                            isProviderEnabled = locationManager.isProviderEnabled("gps");
                        } else {
                            isProviderEnabled = true;
                        }
                        if (!isProviderEnabled) {
                            WM(getString(R.string.eeo));
                        }
                    }
                    BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
                    if (defaultAdapter != null && defaultAdapter.getState() != 12) {
                        WM(getString(R.string.een));
                    } else if (defaultAdapter == null) {
                        WM(getString(R.string.eer));
                    }
                }
            } else if (view.getId() == R.id.ec_) {
                com.tencent.mm.plugin.report.service.h.pYm.e(11722, Integer.valueOf(5));
                if (this.qvJ != 6) {
                    if (this.qvJ == 4) {
                        kt(false);
                    }
                    this.qvJ = 6;
                    ckH();
                    kv(false);
                    if (this.qvf != null) {
                        this.qvf.setVisibility(8);
                    }
                    com.tencent.mm.x.c.PK().y(262155, false);
                    this.qvH.setVisibility(8);
                }
            }
            ku(true);
            ky(false);
            ckR();
            AppMethodBeat.o(24840);
            return;
        }
        AppMethodBeat.o(24840);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(24841);
        super.onActivityResult(i, i2, intent);
        switch (i) {
            case 1:
                if (intent == null) {
                    AppMethodBeat.o(24841);
                    return;
                }
                Intent intent2 = new Intent();
                intent2.putExtra("CropImageMode", 4);
                intent2.putExtra("CropImage_Filter", true);
                intent2.putExtra("CropImage_DirectlyIntoFilter", true);
                StringBuilder stringBuilder = new StringBuilder();
                aw.ZK();
                intent2.putExtra("CropImage_OutputPath", stringBuilder.append(c.XW()).append("custom_shake_img_filename.jpg").toString());
                com.tencent.mm.plugin.shake.a.gkE.a(intent2, 2, (MMActivity) this, intent);
                AppMethodBeat.o(24841);
                return;
            case 2:
                if (intent == null) {
                    AppMethodBeat.o(24841);
                    return;
                }
                Object stringExtra = intent.getStringExtra("CropImage_OutputPath");
                aw.ZK();
                c.Ry().set(4110, Boolean.FALSE);
                aw.ZK();
                c.Ry().set(4111, stringExtra);
                ckF();
                AppMethodBeat.o(24841);
                return;
            case 30764:
                if (intent != null) {
                    Bundle bundleExtra = intent.getBundleExtra("result_data");
                    if (bundleExtra == null || !bundleExtra.getString("go_next", "").equals("gdpr_auth_location")) {
                        this.gwZ = true;
                        finish();
                        AppMethodBeat.o(24841);
                        return;
                    }
                    com.tencent.mm.kernel.g.RP().Ry().set(com.tencent.mm.storage.ac.a.USERINFO_GDPR_LOCATION_PERMISSION_DESCRIBE_CONFIRM_BOOLEAN_SYNC, Boolean.TRUE);
                    com.tencent.mm.pluginsdk.permission.b.b(this, "android.permission.ACCESS_COARSE_LOCATION", 64);
                    this.gwZ = false;
                    AppMethodBeat.o(24841);
                    return;
                }
                this.gwZ = true;
                finish();
                AppMethodBeat.o(24841);
                return;
            default:
                AppMethodBeat.o(24841);
                return;
        }
    }

    public final void a(String str, com.tencent.mm.sdk.e.m mVar) {
        AppMethodBeat.i(24842);
        ckI();
        if (!this.quY) {
            ku(true);
        }
        AppMethodBeat.o(24842);
    }

    public final void a(int i, com.tencent.mm.sdk.e.n nVar, Object obj) {
        AppMethodBeat.i(24843);
        a("", null);
        AppMethodBeat.o(24843);
    }

    public final void m(String str, Bitmap bitmap) {
        AppMethodBeat.i(24846);
        if (str == null || bitmap == null || bitmap.isRecycled()) {
            AppMethodBeat.o(24846);
            return;
        }
        if (!(this.qvu == null || this.qvu.getTag() == null || !str.equals((String) this.qvu.getTag()))) {
            this.qvu.setImageBitmap(bitmap);
        }
        AppMethodBeat.o(24846);
    }

    public final void ckb() {
        AppMethodBeat.i(24847);
        com.tencent.mm.plugin.shake.c.c.a.cjM();
        ckJ();
        ckK();
        ckN();
        ckO();
        ckM();
        AppMethodBeat.o(24847);
    }

    private void ckJ() {
        AppMethodBeat.i(24848);
        if (com.tencent.mm.plugin.shake.c.c.a.cks()) {
            if (com.tencent.mm.x.c.PK().bY(262155, 266259)) {
                this.qvH.setVisibility(0);
                AppMethodBeat.o(24848);
                return;
            }
            this.qvH.setVisibility(8);
        }
        AppMethodBeat.o(24848);
    }

    private void ckK() {
        AppMethodBeat.i(24849);
        if (this.qvJ == 6 && com.tencent.mm.plugin.shake.c.c.a.cks()) {
            boolean bY = com.tencent.mm.x.c.PK().bY(262154, 266258);
            boolean bY2 = com.tencent.mm.x.c.PK().bY(262155, 266259);
            if (bY) {
                be(com.tencent.mm.plugin.shake.c.c.a.ckn(), true);
                AppMethodBeat.o(24849);
                return;
            } else if (bY2) {
                be(com.tencent.mm.plugin.shake.c.c.a.ckp(), true);
                AppMethodBeat.o(24849);
                return;
            } else if (!this.qvX) {
                if (TextUtils.isEmpty(com.tencent.mm.plugin.shake.c.c.a.ckl())) {
                    be(getString(R.string.eea), true);
                } else {
                    be(com.tencent.mm.plugin.shake.c.c.a.ckl(), true);
                    AppMethodBeat.o(24849);
                    return;
                }
            }
        }
        AppMethodBeat.o(24849);
    }

    private void be(String str, boolean z) {
        AppMethodBeat.i(24850);
        this.quX = false;
        if (this.qvr == null) {
            this.qvr = AnimationUtils.loadAnimation(this.mController.ylL, R.anim.ay);
        }
        CD(2);
        kx(true);
        if (str != null && str.length() > 1) {
            this.qvi.setText(str);
        } else if (z) {
            this.qvi.setText(R.string.eea);
        } else {
            this.qvi.setText("");
            kx(false);
        }
        this.qva = true;
        AppMethodBeat.o(24850);
    }

    private void ckL() {
        AppMethodBeat.i(24851);
        if (this.qvW != null && this.qvW.isShowing()) {
            this.qvW.dismiss();
        }
        this.qvW = null;
        AppMethodBeat.o(24851);
    }

    private void ckM() {
        int intExtra;
        int i;
        int i2 = 1;
        AppMethodBeat.i(24852);
        boolean cjN = com.tencent.mm.plugin.shake.c.c.a.cjN();
        boolean bY = com.tencent.mm.x.c.PK().bY(262154, 266258);
        boolean bY2 = com.tencent.mm.x.c.PK().bY(262155, 266259);
        if (getIntent().getBooleanExtra("shake_card", false)) {
            intExtra = getIntent().getIntExtra("shake_card", 0);
        } else {
            intExtra = 0;
        }
        com.tencent.mm.plugin.report.service.h hVar = com.tencent.mm.plugin.report.service.h.pYm;
        Object[] objArr = new Object[6];
        objArr[0] = Integer.valueOf(1);
        objArr[1] = Integer.valueOf(intExtra);
        if (bY) {
            i = 1;
        } else {
            i = 0;
        }
        objArr[2] = Integer.valueOf(i);
        objArr[3] = Integer.valueOf(cjN ? 1 : 0);
        objArr[4] = com.tencent.mm.plugin.shake.c.c.a.cko();
        objArr[5] = Integer.valueOf(com.tencent.mm.plugin.shake.c.c.a.ckk());
        hVar.e(11668, objArr);
        com.tencent.mm.plugin.report.service.h hVar2 = com.tencent.mm.plugin.report.service.h.pYm;
        Object[] objArr2 = new Object[6];
        objArr2[0] = Integer.valueOf(2);
        objArr2[1] = Integer.valueOf(intExtra);
        if (bY2) {
            intExtra = 1;
        } else {
            intExtra = 0;
        }
        objArr2[2] = Integer.valueOf(intExtra);
        if (!cjN) {
            i2 = 0;
        }
        objArr2[3] = Integer.valueOf(i2);
        objArr2[4] = com.tencent.mm.plugin.shake.c.c.a.cko();
        objArr2[5] = Integer.valueOf(com.tencent.mm.plugin.shake.c.c.a.ckk());
        hVar2.e(11668, objArr2);
        AppMethodBeat.o(24852);
    }

    private void ckN() {
        AppMethodBeat.i(24853);
        if (!TextUtils.isEmpty(com.tencent.mm.plugin.shake.c.c.a.ckm())) {
            this.qvI.setText(com.tencent.mm.plugin.shake.c.c.a.ckm());
        }
        AppMethodBeat.o(24853);
    }

    private void ckO() {
        AppMethodBeat.i(24854);
        if (com.tencent.mm.aw.d.aim()) {
            ab.i("MicroMsg.ShakeReportUI", "is not oversea user, show shake music");
            this.qvY.put(Integer.valueOf(3), Boolean.TRUE);
            findViewById(R.id.ecf).setVisibility(0);
            if (com.tencent.mm.aw.d.ain()) {
                aw.ZK();
                if (c.Ry().getInt(4118, 0) == 0) {
                    this.qvG.setVisibility(0);
                } else {
                    this.qvG.setVisibility(8);
                }
            }
        } else {
            this.qvY.put(Integer.valueOf(3), Boolean.FALSE);
            findViewById(R.id.ecf).setVisibility(8);
            ab.i("MicroMsg.ShakeReportUI", "is oversea user, hide shake music");
        }
        if (k.cjQ()) {
            this.qvY.put(Integer.valueOf(4), Boolean.TRUE);
            findViewById(R.id.eci).setVisibility(0);
            ab.i("MicroMsg.ShakeReportUI", "show shake tv tab");
        } else {
            this.qvY.put(Integer.valueOf(4), Boolean.FALSE);
            findViewById(R.id.eci).setVisibility(8);
            ab.i("MicroMsg.ShakeReportUI", "hide shake tv tab");
        }
        if (com.tencent.mm.plugin.shake.c.c.a.cks()) {
            this.qvY.put(Integer.valueOf(6), Boolean.TRUE);
            findViewById(R.id.ec_).setVisibility(0);
            ab.i("MicroMsg.ShakeReportUI", "show shake card tab");
        } else {
            findViewById(R.id.ec_).setVisibility(8);
            this.qvY.put(Integer.valueOf(6), Boolean.FALSE);
            ab.i("MicroMsg.ShakeReportUI", "hide shake card tab");
        }
        if (ckP()) {
            this.qvY.put(Integer.valueOf(5), Boolean.TRUE);
            this.qvU.setVisibility(0);
            ab.i("MicroMsg.ShakeReportUI", "[shakezb]show shake ibeacon tab");
        } else {
            this.qvY.put(Integer.valueOf(5), Boolean.FALSE);
            this.qvU.setVisibility(8);
            ab.i("MicroMsg.ShakeReportUI", "[shakezb]hide shake ibeacon tab");
        }
        int i = 0;
        for (Boolean booleanValue : this.qvY.values()) {
            int i2;
            if (booleanValue.booleanValue()) {
                i2 = i + 1;
            } else {
                i2 = i;
            }
            i = i2;
        }
        this.qvK = i;
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.ec7);
        if (i == 1) {
            linearLayout.setVisibility(8);
        } else {
            linearLayout.setVisibility(0);
        }
        if (i <= 4 || !this.qwf) {
            if (i > 4 && !this.qwf) {
                this.qvU.setVisibility(8);
                this.qvZ = false;
                this.qvK--;
                ab.i("MicroMsg.ShakeReportUI", "show tab count is > 4 and beaconMap.size() <= 0.");
            }
            AppMethodBeat.o(24854);
            return;
        }
        findViewById(R.id.eci).setVisibility(8);
        ab.i("MicroMsg.ShakeReportUI", "show tab count is > 4 and beaconMap.size() > 0.");
        this.qvK--;
        AppMethodBeat.o(24854);
    }

    private boolean ckP() {
        AppMethodBeat.i(24855);
        ab.i("MicroMsg.ShakeReportUI", "[shakezb] isChineseAppLang :" + aa.don() + " ,getApplicationLanguage[en or zh_CN or zh_HK or zh_TW is avaliable] :" + aa.dor());
        if (this.qvZ && ckQ()) {
            AppMethodBeat.o(24855);
            return true;
        }
        AppMethodBeat.o(24855);
        return false;
    }

    private static boolean ckQ() {
        AppMethodBeat.i(24856);
        if (aa.don() || aa.dor().equals("en") || aa.dor().equals("ja")) {
            AppMethodBeat.o(24856);
            return true;
        }
        AppMethodBeat.o(24856);
        return false;
    }

    private void ckR() {
        AppMethodBeat.i(24857);
        this.qvL.setVisibility(8);
        AppMethodBeat.o(24857);
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        AppMethodBeat.i(24858);
        if (iArr == null || iArr.length <= 0) {
            ab.i("MicroMsg.ShakeReportUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", Integer.valueOf(i), Long.valueOf(Thread.currentThread().getId()));
            AppMethodBeat.o(24858);
            return;
        }
        ab.i("MicroMsg.ShakeReportUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId()));
        switch (i) {
            case 64:
                if (iArr[0] != 0) {
                    this.gwZ = false;
                    h.a((Context) this, getString(R.string.dby), getString(R.string.dc8), getString(R.string.ckr), getString(R.string.abx), false, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.i(24799);
                            ShakeReportUI.this.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                            ShakeReportUI.this.gwZ = true;
                            ShakeReportUI.this.finish();
                            AppMethodBeat.o(24799);
                        }
                    }, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.i(24801);
                            ShakeReportUI.this.gwZ = true;
                            ShakeReportUI.this.finish();
                            AppMethodBeat.o(24801);
                        }
                    });
                    break;
                }
                cdJ();
                AppMethodBeat.o(24858);
                return;
            case 80:
                if (iArr[0] != 0) {
                    h.a((Context) this, getString(R.string.dc0), getString(R.string.dc8), getString(R.string.ckr), getString(R.string.abx), false, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.i(24797);
                            dialogInterface.dismiss();
                            ShakeReportUI.this.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                            AppMethodBeat.o(24797);
                        }
                    }, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.i(24798);
                            dialogInterface.dismiss();
                            AppMethodBeat.o(24798);
                        }
                    });
                    AppMethodBeat.o(24858);
                    return;
                }
                break;
        }
        AppMethodBeat.o(24858);
    }

    private void c(com.tencent.mm.plugin.shake.b.d dVar) {
        AppMethodBeat.i(24844);
        if (bo.isNullOrNil(dVar.field_username)) {
            AppMethodBeat.o(24844);
            return;
        }
        String string;
        this.qvf.setTag(dVar.field_username);
        this.qvf.setVisibility(0);
        aw.ZK();
        ad aoO = c.XM().aoO(dVar.field_username);
        StringBuilder append = new StringBuilder().append(dVar.field_nickname);
        if (com.tencent.mm.n.a.jh(aoO.field_type)) {
            string = getString(R.string.efa);
        } else {
            string = "";
        }
        String stringBuilder = append.append(string).toString();
        if (dVar.field_sex == 1) {
            this.qvf.setContentDescription(stringBuilder + dVar.field_distance + this.mController.ylL.getString(R.string.eg3));
        } else if (dVar.field_sex == 2) {
            this.qvf.setContentDescription(stringBuilder + dVar.field_distance + this.mController.ylL.getString(R.string.eg2));
        } else {
            this.qvf.setContentDescription(stringBuilder + dVar.field_distance);
        }
        TextView textView = (TextView) this.qvf.findViewById(R.id.ec3);
        textView.setText(com.tencent.mm.pluginsdk.ui.e.j.b(this.mController.ylL, dVar.field_nickname + (com.tencent.mm.n.a.jh(aoO.field_type) ? getString(R.string.efa) : ""), textView.getTextSize()));
        if (this.eks != null) {
            if (bo.isNullOrNil(stringBuilder)) {
                this.eks.setContentDescription(getString(R.string.ee4));
            } else {
                this.eks.setContentDescription(String.format(getString(R.string.ee3), new Object[]{stringBuilder}));
            }
        }
        ((TextView) this.qvf.findViewById(R.id.ec6)).setText(dVar.field_distance);
        com.tencent.mm.pluginsdk.ui.a.b.b((ImageView) this.qvf.findViewById(R.id.ec2), dVar.field_username);
        ImageView imageView = (ImageView) this.qvf.findViewById(R.id.ec5);
        if (dVar.field_reserved1 != 0) {
            imageView.setVisibility(0);
            imageView.setImageBitmap(BackwardSupportUtil.b.i(com.tencent.mm.model.ao.a.flw.ky(dVar.field_reserved1), 2.0f));
        } else {
            imageView.setVisibility(8);
        }
        if (dVar.field_reserved1 != 0 || dVar.field_sex == 0) {
            this.qvf.findViewById(R.id.ec4).setVisibility(8);
        } else {
            Drawable g = com.tencent.mm.bz.a.g(this, dVar.field_sex == 1 ? R.raw.ic_sex_male : R.raw.ic_sex_female);
            this.qvf.findViewById(R.id.ec4).setVisibility(0);
            ((ImageView) this.qvf.findViewById(R.id.ec4)).setImageDrawable(g);
        }
        if (dVar.getProvince() == null) {
            ab.e("MicroMsg.ShakeReportUI", "PROVINCE NULL");
            dVar.field_province = "";
        }
        if (dVar.getCity() == null) {
            ab.e("MicroMsg.ShakeReportUI", "CITY NULL");
            dVar.field_city = "";
        }
        this.qvf.startAnimation(AnimationUtils.loadAnimation(this.mController.ylL, R.anim.d1));
        AppMethodBeat.o(24844);
    }

    private void d(com.tencent.mm.plugin.shake.b.d dVar) {
        AppMethodBeat.i(24845);
        if (bo.isNullOrNil(dVar.field_username)) {
            AppMethodBeat.o(24845);
            return;
        }
        this.qvf.setTag(dVar.field_username);
        ((TextView) this.qvf.findViewById(R.id.ec3)).setText(dVar.field_username);
        this.qvf.setContentDescription(bo.nullAsNil(dVar.field_nickname));
        ((TextView) this.qvf.findViewById(R.id.ec6)).setText(dVar.field_signature);
        this.fGv.a(dVar.getProvince(), (ImageView) this.qvf.findViewById(R.id.ec2));
        this.qvf.findViewById(R.id.ec4).setVisibility(8);
        this.qvf.startAnimation(AnimationUtils.loadAnimation(this.mController.ylL, R.anim.d1));
        this.qvf.setVisibility(0);
        AppMethodBeat.o(24845);
    }

    static /* synthetic */ void j(ShakeReportUI shakeReportUI) {
        AppMethodBeat.i(24859);
        if (ckQ()) {
            ViewGroup viewGroup = (ViewGroup) shakeReportUI.findViewById(R.id.ec7);
            if (viewGroup != null) {
                int i;
                int childCount = viewGroup.getChildCount();
                ArrayList arrayList = new ArrayList();
                int i2 = 0;
                for (i = 0; i < childCount; i++) {
                    if (viewGroup.getChildAt(i).getVisibility() == 0) {
                        i2++;
                        arrayList.add(viewGroup.getChildAt(i));
                    }
                }
                int width;
                TranslateAnimation translateAnimation;
                View view;
                if (!shakeReportUI.qvZ && (shakeReportUI.qwa || shakeReportUI.qwc)) {
                    childCount = viewGroup.getWidth() / (i2 + 1);
                    width = viewGroup.getWidth() / i2;
                    AnimationSet animationSet = new AnimationSet(false);
                    AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                    alphaAnimation.setDuration(600);
                    translateAnimation = new TranslateAnimation((float) viewGroup.getWidth(), (float) (viewGroup.getWidth() - childCount), 0.0f, 0.0f);
                    animationSet.addAnimation(alphaAnimation);
                    translateAnimation.setDuration(600);
                    animationSet.addAnimation(translateAnimation);
                    shakeReportUI.findViewById(R.id.eck).setAnimation(animationSet);
                    if (i2 < 4) {
                        for (i = 0; i < i2; i++) {
                            view = (View) arrayList.get(i);
                            translateAnimation = new TranslateAnimation((float) (((i * width) + (width / 2)) - ((i * childCount) + (childCount / 2))), 0.0f, 0.0f, 0.0f);
                            translateAnimation.setDuration(600);
                            view.setAnimation(translateAnimation);
                        }
                    }
                } else if (!(shakeReportUI.qvZ || shakeReportUI.qwa || shakeReportUI.qwc)) {
                    childCount = viewGroup.getWidth() / (i2 + 1);
                    width = viewGroup.getWidth() / i2;
                    AnimationSet animationSet2 = new AnimationSet(false);
                    AlphaAnimation alphaAnimation2 = new AlphaAnimation(0.0f, 1.0f);
                    alphaAnimation2.setDuration(1200);
                    TranslateAnimation translateAnimation2 = new TranslateAnimation((float) ((-childCount) / 2), 0.0f, 0.0f, 0.0f);
                    animationSet2.addAnimation(alphaAnimation2);
                    translateAnimation2.setDuration(600);
                    animationSet2.addAnimation(translateAnimation2);
                    shakeReportUI.findViewById(R.id.ec8).setAnimation(animationSet2);
                    for (i = 1; i < i2 + 1; i++) {
                        view = (View) arrayList.get(i - 1);
                        translateAnimation = new TranslateAnimation((float) (-(((i * childCount) + (childCount / 2)) - (((i - 1) * width) + (width / 2)))), 0.0f, 0.0f, 0.0f);
                        translateAnimation.setDuration(600);
                        view.setAnimation(translateAnimation);
                    }
                }
                shakeReportUI.qvZ = true;
                shakeReportUI.qvJ = 5;
                shakeReportUI.qwf = true;
                shakeReportUI.ckO();
                shakeReportUI.ckH();
                shakeReportUI.kv(false);
            }
        }
        AppMethodBeat.o(24859);
    }

    static /* synthetic */ void A(ShakeReportUI shakeReportUI) {
        AppMethodBeat.i(24865);
        if (shakeReportUI.qvk == null) {
            shakeReportUI.qvk = shakeReportUI.findViewById(R.id.ebq);
        }
        if (shakeReportUI.qvl == null) {
            shakeReportUI.qvl = shakeReportUI.findViewById(R.id.ebt);
        }
        if (shakeReportUI.qvm == null) {
            shakeReportUI.qvm = shakeReportUI.findViewById(R.id.ebz);
        }
        if (shakeReportUI.qvn == null) {
            shakeReportUI.qvn = shakeReportUI.findViewById(R.id.ebs);
        }
        if (shakeReportUI.qvo == null) {
            shakeReportUI.qvo = AnimationUtils.loadAnimation(shakeReportUI.mController.ylL, R.anim.dy);
            shakeReportUI.qvo.setAnimationListener(new AnimationListener() {
                public final void onAnimationStart(Animation animation) {
                    AppMethodBeat.i(24787);
                    ShakeReportUI.this.quU = false;
                    ShakeReportUI.this.quV = true;
                    ShakeReportUI.f(ShakeReportUI.this, false);
                    ShakeReportUI.this.quY = true;
                    ShakeReportUI.B(ShakeReportUI.this);
                    AppMethodBeat.o(24787);
                }

                public final void onAnimationEnd(Animation animation) {
                    AppMethodBeat.i(24788);
                    ShakeReportUI.f(ShakeReportUI.this, true);
                    ShakeReportUI.this.quY = false;
                    if (!ShakeReportUI.this.quU) {
                        ShakeReportUI.this.quX = true;
                        ShakeReportUI.d(ShakeReportUI.this, true);
                        ShakeReportUI.D(ShakeReportUI.this);
                        if (ShakeReportUI.this.qvd.qrR == 3) {
                            com.tencent.mm.aw.a.aic();
                        } else if (ShakeReportUI.this.qvd.qrR == 5) {
                            l.b bVar = ShakeReportUI.this.qvd.qrS;
                            if (bVar != null && (bVar instanceof com.tencent.mm.plugin.shake.d.a.h)) {
                                com.tencent.mm.plugin.shake.d.a.h hVar = (com.tencent.mm.plugin.shake.d.a.h) bVar;
                                ArrayList arrayList = new ArrayList();
                                arrayList.addAll(ShakeReportUI.ecw);
                                hVar.qtL = arrayList;
                            }
                        }
                        ShakeReportUI.this.qvd.qrS.start();
                    }
                    ShakeReportUI.this.quV = false;
                    AppMethodBeat.o(24788);
                }

                public final void onAnimationRepeat(Animation animation) {
                }
            });
        }
        if (shakeReportUI.qvp == null) {
            shakeReportUI.qvp = AnimationUtils.loadAnimation(shakeReportUI.mController.ylL, R.anim.dw);
        }
        if (shakeReportUI.qvq == null) {
            shakeReportUI.qvq = AnimationUtils.loadAnimation(shakeReportUI.mController.ylL, R.anim.cy);
        }
        if (!(shakeReportUI.qvr == null || shakeReportUI.qvi == null)) {
            com.tencent.mm.sdk.platformtools.BackwardSupportUtil.a.a(shakeReportUI.qvi, shakeReportUI.qvr);
        }
        shakeReportUI.CD(3);
        shakeReportUI.qvm.startAnimation(shakeReportUI.qvq);
        shakeReportUI.qvn.startAnimation(shakeReportUI.qvq);
        shakeReportUI.qvm.setVisibility(0);
        shakeReportUI.qvn.setVisibility(0);
        shakeReportUI.qvh.setVisibility(4);
        shakeReportUI.qvk.startAnimation(shakeReportUI.qvo);
        shakeReportUI.qvl.startAnimation(shakeReportUI.qvp);
        if (shakeReportUI.qvf != null && shakeReportUI.qvf.getVisibility() == 0) {
            Animation loadAnimation = AnimationUtils.loadAnimation(shakeReportUI.mController.ylL, R.anim.d2);
            loadAnimation.setFillAfter(true);
            shakeReportUI.qvf.startAnimation(loadAnimation);
            new ak().postDelayed(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(24789);
                    if (ShakeReportUI.this.qvf != null) {
                        ShakeReportUI.this.qvf.setVisibility(8);
                    }
                    AppMethodBeat.o(24789);
                }
            }, loadAnimation.getDuration());
        }
        shakeReportUI.qva = false;
        new ak().postDelayed(new Runnable() {
            public final void run() {
                AppMethodBeat.i(24791);
                if (ShakeReportUI.this.qvm != null) {
                    ShakeReportUI.this.qvm.setVisibility(8);
                }
                if (ShakeReportUI.this.qvn != null) {
                    ShakeReportUI.this.qvn.setVisibility(8);
                }
                if (ShakeReportUI.this.qvh != null) {
                    ShakeReportUI.this.qvh.setVisibility(0);
                }
                if (!(ShakeReportUI.this.qva || ShakeReportUI.this.quU)) {
                    ShakeReportUI.J(ShakeReportUI.this);
                }
                AppMethodBeat.o(24791);
            }
        }, 1200);
        AppMethodBeat.o(24865);
    }
}
