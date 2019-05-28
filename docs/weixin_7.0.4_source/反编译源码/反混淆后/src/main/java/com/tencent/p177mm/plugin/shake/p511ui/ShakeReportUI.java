package com.tencent.p177mm.plugin.shake.p511ui;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
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
import android.view.View.OnClickListener;
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
import com.google.firebase.analytics.FirebaseAnalytics.C8741b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1815as;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C26415ao.C26417a;
import com.tencent.p177mm.model.C32782bp;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.modelgeo.C26443d;
import com.tencent.p177mm.modelgeo.C42207b.C42206a;
import com.tencent.p177mm.p1099x.C16112c;
import com.tencent.p177mm.p1179au.C17950b;
import com.tencent.p177mm.p1374bi.C41789d;
import com.tencent.p177mm.p1510r.C35973a;
import com.tencent.p177mm.p190at.p191a.C25815a;
import com.tencent.p177mm.p198aw.C25847d;
import com.tencent.p177mm.p198aw.C37494a;
import com.tencent.p177mm.p198aw.C9058e;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p230g.p231a.C18245ds;
import com.tencent.p177mm.p230g.p231a.C32535dt;
import com.tencent.p177mm.p230g.p231a.C32628se;
import com.tencent.p177mm.p230g.p231a.C6475dz;
import com.tencent.p177mm.p249m.C26373g;
import com.tencent.p177mm.p264n.C7486a;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.MMImageView;
import com.tencent.p177mm.p612ui.base.C15532i;
import com.tencent.p177mm.p612ui.base.C23639t;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C30379h.C30391c;
import com.tencent.p177mm.p612ui.base.C5288y;
import com.tencent.p177mm.p612ui.widget.p633a.C5653c.C5652a;
import com.tencent.p177mm.p707ba.C45181k;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.platformtools.C18764x;
import com.tencent.p177mm.platformtools.C18764x.C18765a;
import com.tencent.p177mm.platformtools.C1947ae;
import com.tencent.p177mm.platformtools.C9791v;
import com.tencent.p177mm.plugin.account.p765a.p1216b.C32921a;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.shake.C46193a;
import com.tencent.p177mm.plugin.shake.p1019b.C13247e;
import com.tencent.p177mm.plugin.shake.p1019b.C13248f;
import com.tencent.p177mm.plugin.shake.p1019b.C28987m;
import com.tencent.p177mm.plugin.shake.p1019b.C34894d;
import com.tencent.p177mm.plugin.shake.p1019b.C39691l;
import com.tencent.p177mm.plugin.shake.p1019b.C39691l.C21826a;
import com.tencent.p177mm.plugin.shake.p1019b.C39691l.C21828b;
import com.tencent.p177mm.plugin.shake.p1296e.C29004b;
import com.tencent.p177mm.plugin.shake.p506c.p1411c.C28999a;
import com.tencent.p177mm.plugin.shake.p506c.p507a.C21829e;
import com.tencent.p177mm.plugin.shake.p506c.p507a.C28997f;
import com.tencent.p177mm.plugin.shake.p506c.p507a.C28997f.C28996a;
import com.tencent.p177mm.plugin.shake.p506c.p507a.C46197d;
import com.tencent.p177mm.plugin.shake.p506c.p507a.C7084g;
import com.tencent.p177mm.plugin.shake.p506c.p508b.C43523a;
import com.tencent.p177mm.plugin.shake.p506c.p508b.C43523a.C39694b;
import com.tencent.p177mm.plugin.shake.p509d.p510a.C34900h;
import com.tencent.p177mm.plugin.shake.p509d.p510a.C34900h.C3825a;
import com.tencent.p177mm.plugin.shake.p509d.p510a.C34904j;
import com.tencent.p177mm.plugin.shake.p509d.p510a.C3826k;
import com.tencent.p177mm.plugin.shake.p509d.p510a.C39695i;
import com.tencent.p177mm.pluginsdk.p1082i.C30050d;
import com.tencent.p177mm.pluginsdk.p1082i.C30050d.C30051a;
import com.tencent.p177mm.pluginsdk.p597ui.C40459a.C40460b;
import com.tencent.p177mm.pluginsdk.p597ui.C4759f;
import com.tencent.p177mm.pluginsdk.p597ui.ProfileHdHeadImg;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.pluginsdk.p597ui.tools.C14987n;
import com.tencent.p177mm.pluginsdk.permission.C35805b;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.p603e.C4935m;
import com.tencent.p177mm.sdk.p603e.C7296k.C4931a;
import com.tencent.p177mm.sdk.p603e.C7298n;
import com.tencent.p177mm.sdk.p603e.C7298n.C4937b;
import com.tencent.p177mm.sdk.platformtools.BackwardSupportUtil.C4976a;
import com.tencent.p177mm.sdk.platformtools.BackwardSupportUtil.C4977b;
import com.tencent.p177mm.sdk.platformtools.C35988ay;
import com.tencent.p177mm.sdk.platformtools.C4988aa;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5056d;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.storage.C41338bt;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.p177mm.storage.C7616ad;
import com.tencent.p177mm.vfs.C5730e;
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

/* renamed from: com.tencent.mm.plugin.shake.ui.ShakeReportUI */
public class ShakeReportUI extends MMActivity implements C1815as, C18765a, C21826a, C28996a, C4931a, C4937b {
    private static List<C3825a> ecw = new CopyOnWriteArrayList();
    private C26443d ecr;
    private boolean ecu = false;
    private Map<String, C3825a> ecv = new ConcurrentHashMap();
    private C42206a ecy = new C132681();
    private ImageView eks;
    private C25815a fGv = null;
    private boolean gwZ = true;
    private boolean nPX;
    private C30050d oOS;
    private boolean quU = false;
    private boolean quV = false;
    private boolean quW;
    private boolean quX = false;
    private boolean quY = false;
    private boolean quZ = false;
    private ImageView qvA = null;
    private C34894d qvB = null;
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
    private C43523a qvW;
    private boolean qvX = false;
    @SuppressLint({"UseSparseArrays"})
    private Map<Integer, Boolean> qvY = new HashMap();
    private boolean qvZ = false;
    private boolean qva = false;
    private int qvb = 22;
    private C39711c qvc;
    private C39691l qvd = new C39691l();
    private C4759f qve;
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
    private C4884c qwg = new C708824();
    private C4884c qwh = new C709025();
    private OnClickListener qwi = new C1328418();

    /* renamed from: com.tencent.mm.plugin.shake.ui.ShakeReportUI$11 */
    class C383911 implements Runnable {
        C383911() {
        }

        public final void run() {
            AppMethodBeat.m2504i(24789);
            if (ShakeReportUI.this.qvf != null) {
                ShakeReportUI.this.qvf.setVisibility(8);
            }
            AppMethodBeat.m2505o(24789);
        }
    }

    /* renamed from: com.tencent.mm.plugin.shake.ui.ShakeReportUI$12 */
    class C384012 implements DialogInterface.OnClickListener {
        C384012() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(24790);
            ShakeReportUI.this.finish();
            AppMethodBeat.m2505o(24790);
        }
    }

    /* renamed from: com.tencent.mm.plugin.shake.ui.ShakeReportUI$13 */
    class C384113 implements Runnable {
        C384113() {
        }

        public final void run() {
            AppMethodBeat.m2504i(24791);
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
                ShakeReportUI.m21300J(ShakeReportUI.this);
            }
            AppMethodBeat.m2505o(24791);
        }
    }

    /* renamed from: com.tencent.mm.plugin.shake.ui.ShakeReportUI$27 */
    class C384227 implements OnMenuItemClickListener {
        C384227() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(24809);
            ShakeReportUI.this.quX = false;
            ShakeReportUI.this.finish();
            AppMethodBeat.m2505o(24809);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.shake.ui.ShakeReportUI$5 */
    class C38435 implements OnClickListener {
        C38435() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(24780);
            ShakeReportUI.this.qvz.cancel();
            AppMethodBeat.m2505o(24780);
        }
    }

    /* renamed from: com.tencent.mm.plugin.shake.ui.ShakeReportUI$24 */
    class C708824 extends C4884c<C32535dt> {

        /* renamed from: com.tencent.mm.plugin.shake.ui.ShakeReportUI$24$1 */
        class C70891 implements Runnable {
            C70891() {
            }

            public final void run() {
                AppMethodBeat.m2504i(24802);
                ShakeReportUI.m21333j(ShakeReportUI.this);
                AppMethodBeat.m2505o(24802);
            }
        }

        C708824() {
            AppMethodBeat.m2504i(24803);
            this.xxI = C32535dt.class.getName().hashCode();
            AppMethodBeat.m2505o(24803);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(24804);
            C32535dt c32535dt = (C32535dt) c4883b;
            String str = c32535dt.cxk.cxi;
            int i = c32535dt.cxk.cxl;
            int i2 = c32535dt.cxk.cxm;
            String str2 = c32535dt.cxk.cxp;
            double d = c32535dt.cxk.cxo;
            int i3 = c32535dt.cxk.cxq;
            if (!ShakeReportUI.this.ecv.containsKey(str + "," + i + "," + i2)) {
                C3825a c3825a = new C3825a();
                c3825a.eCq = str;
                c3825a.fNN = c32535dt.cxk.cxn;
                c3825a.major = i;
                c3825a.minor = i2;
                c3825a.qtR = str2;
                c3825a.qtS = d;
                c3825a.qtT = i3;
                ShakeReportUI.this.ecv.put(str + "," + i + "," + i2, c3825a);
                if (c32535dt.cxk.cxn >= 0.0d && ShakeReportUI.ecw.size() > 0) {
                    int i4 = 0;
                    while (true) {
                        i3 = i4;
                        if (i3 >= ShakeReportUI.ecw.size()) {
                            break;
                        }
                        C3825a c3825a2 = (C3825a) ShakeReportUI.ecw.get(i3);
                        if (c32535dt.cxk.cxn >= c3825a2.fNN) {
                            if (i3 == ShakeReportUI.ecw.size() - 1 && c32535dt.cxk.cxn > c3825a2.fNN) {
                                ShakeReportUI.ecw.add(c3825a);
                                break;
                            }
                            i4 = i3 + 1;
                        } else {
                            ShakeReportUI.ecw.add(i3, c3825a);
                            break;
                        }
                    }
                }
                ShakeReportUI.ecw.add(c3825a);
                if (ShakeReportUI.this.ecv.size() == 1 && !ShakeReportUI.this.qwf) {
                    ShakeReportUI.this.qwe = System.currentTimeMillis() - ShakeReportUI.this.qwe;
                    C7060h.pYm.mo8381e(11497, String.valueOf((int) (((double) (ShakeReportUI.this.qwe / 1000)) + 0.5d)), Integer.valueOf(0), Integer.valueOf((int) ShakeReportUI.this.qwe));
                    ShakeReportUI.this.qwe = 0;
                    ShakeReportUI.this.runOnUiThread(new C70891());
                }
            }
            C4990ab.m7417i("MicroMsg.ShakeReportUI", "result iBeacon = %s,beaconMap.size:%d", str + "," + i + "," + i2, Integer.valueOf(ShakeReportUI.this.ecv.size()));
            AppMethodBeat.m2505o(24804);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.shake.ui.ShakeReportUI$25 */
    class C709025 extends C4884c<C6475dz> {

        /* renamed from: com.tencent.mm.plugin.shake.ui.ShakeReportUI$25$1 */
        class C70911 implements Runnable {
            C70911() {
            }

            public final void run() {
                AppMethodBeat.m2504i(24805);
                ShakeReportUI.m21333j(ShakeReportUI.this);
                AppMethodBeat.m2505o(24805);
            }
        }

        C709025() {
            AppMethodBeat.m2504i(24806);
            this.xxI = C6475dz.class.getName().hashCode();
            AppMethodBeat.m2505o(24806);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(24807);
            C6475dz c6475dz = (C6475dz) c4883b;
            C4990ab.m7411d("MicroMsg.ShakeReportUI", "ExDeviceOnBluetoothStateChangeEvent = %s", Integer.valueOf(c6475dz.cxz.cxA));
            boolean hasSystemFeature = ShakeReportUI.this.mController.ylL.getPackageManager().hasSystemFeature("android.hardware.bluetooth_le");
            if (c6475dz.cxz.cxA == 10 && VERSION.SDK_INT >= 18 && hasSystemFeature) {
                ShakeReportUI.m21334k(ShakeReportUI.this);
            } else if (c6475dz.cxz.cxA == 12) {
                int i;
                if (VERSION.SDK_INT < 18 || !hasSystemFeature) {
                    ShakeReportUI.this.qwd = 1;
                } else {
                    ShakeReportUI.m21341l(ShakeReportUI.this);
                    ShakeReportUI.this.qwd = 0;
                }
                C32782bp aao = C32782bp.aao();
                String nullAsNil = C5046bo.nullAsNil(aao.fnp);
                String nullAsNil2 = C5046bo.nullAsNil(aao.fno);
                if (hasSystemFeature) {
                    i = 1;
                } else {
                    i = 0;
                }
                if (ShakeReportUI.this.qwa) {
                    C7060h.pYm.mo8381e(13139, nullAsNil, nullAsNil2, Integer.valueOf(1), Integer.valueOf(ShakeReportUI.this.qwd), Integer.valueOf(1), Integer.valueOf(i));
                } else {
                    C7060h.pYm.mo8381e(13139, nullAsNil, nullAsNil2, Integer.valueOf(0), Integer.valueOf(ShakeReportUI.this.qwd), Integer.valueOf(1), Integer.valueOf(i));
                }
                if (ShakeReportUI.this.qwb && ShakeReportUI.this.qwa && !ShakeReportUI.this.qwf && ShakeReportUI.this.qvK < 4) {
                    ShakeReportUI.this.runOnUiThread(new C70911());
                }
            }
            AppMethodBeat.m2505o(24807);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.shake.ui.ShakeReportUI$14 */
    class C1326714 implements Runnable {
        C1326714() {
        }

        public final void run() {
            AppMethodBeat.m2504i(24792);
            ShakeReportUI.m21301K(ShakeReportUI.this);
            ShakeReportUI.m21322d(ShakeReportUI.this, false);
            AppMethodBeat.m2505o(24792);
        }
    }

    /* renamed from: com.tencent.mm.plugin.shake.ui.ShakeReportUI$1 */
    class C132681 implements C42206a {

        /* renamed from: com.tencent.mm.plugin.shake.ui.ShakeReportUI$1$1 */
        class C132691 implements DialogInterface.OnClickListener {
            C132691() {
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.m2504i(24774);
                C26443d.m42103bX(ShakeReportUI.this);
                AppMethodBeat.m2505o(24774);
            }
        }

        C132681() {
        }

        /* renamed from: a */
        public final boolean mo5861a(boolean z, float f, float f2, int i, double d, double d2, double d3) {
            AppMethodBeat.m2504i(24775);
            if (z) {
                C4990ab.m7410d("MicroMsg.ShakeReportUI", "on location get ok");
                C9638aw.m17190ZK();
                C18628c.m29072Ry().set(C5127a.USERINFO_SHAKE_TV_LATITUDE_STRING, String.valueOf(f2));
                C9638aw.m17190ZK();
                C18628c.m29072Ry().set(C5127a.USERINFO_SHAKE_TV_LONGTITUDE_STRING, String.valueOf(f));
                C9638aw.m17190ZK();
                C18628c.m29072Ry().set(C5127a.USERINFO_SHAKE_TV_ACCURACY_STRING, String.valueOf(d2));
                ShakeReportUI.this.ecu = true;
                if (ShakeReportUI.this.ecr != null) {
                    ShakeReportUI.this.ecr.mo44208c(ShakeReportUI.this.ecy);
                }
            } else {
                if (!(ShakeReportUI.this.nPX || C26443d.agA())) {
                    ShakeReportUI.this.nPX = true;
                    C30379h.m48445a(ShakeReportUI.this, ShakeReportUI.this.getString(C25738R.string.c9z), ShakeReportUI.this.getString(C25738R.string.f9238tz), ShakeReportUI.this.getString(C25738R.string.ckr), ShakeReportUI.this.getString(C25738R.string.f9076or), false, new C132691(), null);
                }
                C4990ab.m7420w("MicroMsg.ShakeReportUI", "getLocation fail");
            }
            AppMethodBeat.m2505o(24775);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.shake.ui.ShakeReportUI$26 */
    class C1327026 implements OnClickListener {
        C1327026() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(24808);
            if (ShakeReportUI.this.qvJ != 5) {
                Intent intent = new Intent(ShakeReportUI.this.mController.ylL, ProfileHdHeadImg.class);
                intent.putExtra("username", (String) ShakeReportUI.this.qvf.getTag());
                ShakeReportUI.this.startActivity(intent);
            }
            AppMethodBeat.m2505o(24808);
        }
    }

    /* renamed from: com.tencent.mm.plugin.shake.ui.ShakeReportUI$2 */
    class C132712 implements DialogInterface.OnClickListener {
        C132712() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(24776);
            if (ShakeReportUI.this.qvz != null) {
                ShakeReportUI.this.qvz.cancel();
            }
            AppMethodBeat.m2505o(24776);
        }
    }

    /* renamed from: com.tencent.mm.plugin.shake.ui.ShakeReportUI$4 */
    class C132724 implements OnCancelListener {

        /* renamed from: com.tencent.mm.plugin.shake.ui.ShakeReportUI$4$1 */
        class C132731 implements IdleHandler {
            C132731() {
            }

            public final boolean queueIdle() {
                AppMethodBeat.m2504i(24778);
                C23639t.m36485a(ShakeReportUI.this, 0, ShakeReportUI.this.getString(C25738R.string.eg0));
                C9638aw.m17190ZK();
                C18628c.m29072Ry().set(4117, Boolean.TRUE);
                AppMethodBeat.m2505o(24778);
                return false;
            }
        }

        C132724() {
        }

        public final void onCancel(DialogInterface dialogInterface) {
            AppMethodBeat.m2504i(24779);
            Looper.myQueue().addIdleHandler(new C132731());
            AppMethodBeat.m2505o(24779);
        }
    }

    /* renamed from: com.tencent.mm.plugin.shake.ui.ShakeReportUI$19 */
    class C1327419 implements DialogInterface.OnClickListener {
        C1327419() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(24797);
            dialogInterface.dismiss();
            ShakeReportUI.this.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
            AppMethodBeat.m2505o(24797);
        }
    }

    /* renamed from: com.tencent.mm.plugin.shake.ui.ShakeReportUI$3 */
    class C132753 implements OnCancelListener {
        C132753() {
        }

        public final void onCancel(DialogInterface dialogInterface) {
            AppMethodBeat.m2504i(24777);
            C9638aw.m17190ZK();
            C18628c.m29072Ry().setInt(4118, 1);
            ShakeReportUI.this.qvG.setVisibility(8);
            AppMethodBeat.m2505o(24777);
        }
    }

    /* renamed from: com.tencent.mm.plugin.shake.ui.ShakeReportUI$28 */
    class C1327728 implements OnMenuItemClickListener {
        C1327728() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(24810);
            ShakeReportUI.this.quX = false;
            Intent intent = new Intent();
            intent.setClass(ShakeReportUI.this, ShakePersonalInfoUI.class);
            ShakeReportUI.this.startActivityForResult(intent, 3);
            AppMethodBeat.m2505o(24810);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.shake.ui.ShakeReportUI$29 */
    class C1327829 implements OnClickListener {
        C1327829() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(24811);
            ShakeReportUI.m21311a(ShakeReportUI.this, view);
            AppMethodBeat.m2505o(24811);
        }
    }

    /* renamed from: com.tencent.mm.plugin.shake.ui.ShakeReportUI$6 */
    class C132796 implements IdleHandler {
        C132796() {
        }

        public final boolean queueIdle() {
            AppMethodBeat.m2504i(24781);
            C23639t.m36485a(ShakeReportUI.this, 0, ShakeReportUI.this.getString(C25738R.string.eg0));
            C9638aw.m17190ZK();
            C18628c.m29072Ry().set(4117, Boolean.TRUE);
            AppMethodBeat.m2505o(24781);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.shake.ui.ShakeReportUI$7 */
    class C132807 implements OnClickListener {

        /* renamed from: com.tencent.mm.plugin.shake.ui.ShakeReportUI$7$1 */
        class C38441 implements C30391c {
            C38441() {
            }

            /* renamed from: iE */
            public final void mo7700iE(int i) {
                AppMethodBeat.m2504i(24782);
                ShakeReportUI.this.quZ = true;
                switch (i) {
                    case 0:
                        C14987n.m23301a(ShakeReportUI.this, 1, null);
                        break;
                }
                AppMethodBeat.m2505o(24782);
            }
        }

        /* renamed from: com.tencent.mm.plugin.shake.ui.ShakeReportUI$7$2 */
        class C38452 implements OnCancelListener {
            C38452() {
            }

            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.m2504i(24783);
                ShakeReportUI.this.quZ = true;
                AppMethodBeat.m2505o(24783);
            }
        }

        C132807() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(24784);
            if (ShakeReportUI.this.quV) {
                ShakeReportUI.this.quZ = false;
                ShakeReportUI.this.quU = true;
                ShakeReportUI.m21322d(ShakeReportUI.this, false);
                C30379h.m48423a(ShakeReportUI.this.mController.ylL, null, new String[]{ShakeReportUI.this.getString(C25738R.string.eey)}, "", new C38441(), new C38452());
                AppMethodBeat.m2505o(24784);
                return;
            }
            AppMethodBeat.m2505o(24784);
        }
    }

    /* renamed from: com.tencent.mm.plugin.shake.ui.ShakeReportUI$9 */
    class C132819 implements OnClickListener {
        C132819() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(24786);
            Intent intent = new Intent(ShakeReportUI.this, ShakeMsgListUI.class);
            intent.putExtra("shake_msg_from", 1);
            intent.putExtra("shake_msg_list_title", ShakeReportUI.this.getString(C25738R.string.egm));
            ShakeReportUI.this.startActivity(intent);
            AppMethodBeat.m2505o(24786);
        }
    }

    /* renamed from: com.tencent.mm.plugin.shake.ui.ShakeReportUI$a */
    static class C13282a extends C30051a {
        private final long[] gjH = new long[]{300, 200, 300, 200};
        private Vibrator kgA;
        private long mfT = C5046bo.m7588yz();
        WeakReference<ShakeReportUI> qwq;

        public C13282a(ShakeReportUI shakeReportUI) {
            AppMethodBeat.m2504i(24812);
            this.qwq = new WeakReference(shakeReportUI);
            AppMethodBeat.m2505o(24812);
        }

        public final void bUT() {
            AppMethodBeat.m2504i(24813);
            ShakeReportUI shakeReportUI = (ShakeReportUI) this.qwq.get();
            if (shakeReportUI == null) {
                AppMethodBeat.m2505o(24813);
            } else if (shakeReportUI.isFinishing()) {
                C4990ab.m7412e("MicroMsg.ShakeReportUI", "ui finished");
                AppMethodBeat.m2505o(24813);
            } else if (shakeReportUI.quZ) {
                ShakeReportUI.m21352w(shakeReportUI);
                long az = C5046bo.m7525az(this.mfT);
                if (az < 1200) {
                    C4990ab.m7416i("MicroMsg.ShakeReportUI", "tryStartShake delay too short:".concat(String.valueOf(az)));
                    AppMethodBeat.m2505o(24813);
                    return;
                }
                C4990ab.m7420w("MicroMsg.ShakeReportUI", "tryStartShake delaytoo enough:".concat(String.valueOf(az)));
                this.mfT = C5046bo.m7588yz();
                if (shakeReportUI.qvc != null) {
                    C39711c x = shakeReportUI.qvc;
                    if (x.view != null) {
                        x.view.setKeepScreenOn(true);
                    }
                    x.che.mo16770ae(30000, 30000);
                }
                if (shakeReportUI.qve != null) {
                    C4759f y = shakeReportUI.qve;
                    if (y.vhB != null) {
                        y.vhB.dismiss();
                    }
                }
                ShakeReportUI shakeReportUI2;
                if (shakeReportUI.quW) {
                    shakeReportUI2 = (ShakeReportUI) this.qwq.get();
                    if (shakeReportUI2 != null) {
                        C35988ay.m59201au(shakeReportUI2, C25738R.string.eg4);
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
                C30051a.reset();
                ShakeReportUI.m21290A(shakeReportUI);
                AppMethodBeat.m2505o(24813);
            } else {
                C4990ab.m7416i("MicroMsg.ShakeReportUI", "tryShake the status is can's shake");
                AppMethodBeat.m2505o(24813);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.shake.ui.ShakeReportUI$16 */
    class C1328316 implements OnCancelListener {
        C1328316() {
        }

        public final void onCancel(DialogInterface dialogInterface) {
            AppMethodBeat.m2504i(24794);
            dialogInterface.dismiss();
            ShakeReportUI.this.quZ = true;
            ShakeReportUI.this.qvW = null;
            ShakeReportUI.this.qvj.setText("");
            AppMethodBeat.m2505o(24794);
        }
    }

    /* renamed from: com.tencent.mm.plugin.shake.ui.ShakeReportUI$18 */
    class C1328418 implements OnClickListener {
        public long quz = 0;

        C1328418() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(24796);
            if (C5046bo.isNullOrNil((String) ShakeReportUI.this.qvf.getTag())) {
                AppMethodBeat.m2505o(24796);
            } else if (ShakeReportUI.this.qvB == null) {
                AppMethodBeat.m2505o(24796);
            } else {
                C34894d N = ShakeReportUI.this.qvB;
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
                            C25985d.m41467b(C4996ah.getContext(), "webview", ".ui.tools.WebViewUI", intent);
                        } else {
                            String[] split = N.field_reserved3.split(",");
                            C32628se c32628se = new C32628se();
                            c32628se.cOf.userName = split[0];
                            c32628se.cOf.cOh = C5046bo.m7532bc(split[1], "");
                            c32628se.cOf.cOi = C5046bo.getInt(split[2], 0);
                            c32628se.cOf.scene = FilterEnum4Shaka.MIC_WEISHI_HEICHA;
                            C4879a.xxA.mo10055m(c32628se);
                        }
                        C21828b c21828b = ShakeReportUI.this.qvd.qrS;
                        if (c21828b != null && (c21828b instanceof C34900h)) {
                            C34900h.m57313a(N);
                            C34900h.m57316b(N);
                        }
                    }
                    AppMethodBeat.m2505o(24796);
                    return;
                }
                C9638aw.m17190ZK();
                C7616ad aoO = C18628c.m29078XM().aoO(str);
                if (C7486a.m12942jh(aoO.field_type)) {
                    Intent intent2 = new Intent();
                    intent2.putExtra("Contact_User", str);
                    intent2.putExtra("Sns_from_Scene", 22);
                    if (str != null && str.length() > 0) {
                        if (aoO.dsf()) {
                            C7060h.pYm.mo8374X(10298, str + "," + ShakeReportUI.this.qvb);
                            intent2.putExtra("Contact_Scene", ShakeReportUI.this.qvb);
                        }
                        C46193a.gkE.mo38912c(intent2, ShakeReportUI.this);
                    }
                    AppMethodBeat.m2505o(24796);
                    return;
                }
                if ((N.field_reserved1 & 8) > 0) {
                    C7060h.pYm.mo8374X(10298, N.field_username + "," + ShakeReportUI.this.qvb);
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
                C46193a.gkE.mo38912c(intent, ShakeReportUI.this);
                AppMethodBeat.m2505o(24796);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.shake.ui.ShakeReportUI$20 */
    class C1328520 implements DialogInterface.OnClickListener {
        C1328520() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(24798);
            dialogInterface.dismiss();
            AppMethodBeat.m2505o(24798);
        }
    }

    /* renamed from: com.tencent.mm.plugin.shake.ui.ShakeReportUI$22 */
    class C1328622 implements Runnable {
        C1328622() {
        }

        public final void run() {
            AppMethodBeat.m2504i(24800);
            if (ShakeReportUI.this.oOS != null) {
                ShakeReportUI.this.oOS.diJ();
            }
            AppMethodBeat.m2505o(24800);
        }
    }

    /* renamed from: com.tencent.mm.plugin.shake.ui.ShakeReportUI$8 */
    class C132878 implements OnClickListener {
        C132878() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(24785);
            Intent intent = new Intent(ShakeReportUI.this, ShakeSayHiListUI.class);
            intent.putExtra("IntentSayHiType", 1);
            ShakeReportUI.this.startActivity(intent);
            AppMethodBeat.m2505o(24785);
        }
    }

    /* renamed from: com.tencent.mm.plugin.shake.ui.ShakeReportUI$10 */
    class C1328810 implements AnimationListener {
        C1328810() {
        }

        public final void onAnimationStart(Animation animation) {
            AppMethodBeat.m2504i(24787);
            ShakeReportUI.this.quU = false;
            ShakeReportUI.this.quV = true;
            ShakeReportUI.m21328f(ShakeReportUI.this, false);
            ShakeReportUI.this.quY = true;
            ShakeReportUI.m21291B(ShakeReportUI.this);
            AppMethodBeat.m2505o(24787);
        }

        public final void onAnimationEnd(Animation animation) {
            AppMethodBeat.m2504i(24788);
            ShakeReportUI.m21328f(ShakeReportUI.this, true);
            ShakeReportUI.this.quY = false;
            if (!ShakeReportUI.this.quU) {
                ShakeReportUI.this.quX = true;
                ShakeReportUI.m21322d(ShakeReportUI.this, true);
                ShakeReportUI.m21294D(ShakeReportUI.this);
                if (ShakeReportUI.this.qvd.qrR == 3) {
                    C37494a.aic();
                } else if (ShakeReportUI.this.qvd.qrR == 5) {
                    C21828b c21828b = ShakeReportUI.this.qvd.qrS;
                    if (c21828b != null && (c21828b instanceof C34900h)) {
                        C34900h c34900h = (C34900h) c21828b;
                        ArrayList arrayList = new ArrayList();
                        arrayList.addAll(ShakeReportUI.ecw);
                        c34900h.qtL = arrayList;
                    }
                }
                ShakeReportUI.this.qvd.qrS.start();
            }
            ShakeReportUI.this.quV = false;
            AppMethodBeat.m2505o(24788);
        }

        public final void onAnimationRepeat(Animation animation) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.shake.ui.ShakeReportUI$17 */
    class C1328917 implements C39694b {
        C1328917() {
        }

        public final void ckg() {
            AppMethodBeat.m2504i(24795);
            ShakeReportUI.this.quZ = true;
            ShakeReportUI.this.qvj.setText("");
            AppMethodBeat.m2505o(24795);
        }
    }

    /* renamed from: com.tencent.mm.plugin.shake.ui.ShakeReportUI$21 */
    class C1329021 implements DialogInterface.OnClickListener {
        C1329021() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(24799);
            ShakeReportUI.this.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
            ShakeReportUI.this.gwZ = true;
            ShakeReportUI.this.finish();
            AppMethodBeat.m2505o(24799);
        }
    }

    /* renamed from: com.tencent.mm.plugin.shake.ui.ShakeReportUI$23 */
    class C1329123 implements DialogInterface.OnClickListener {
        C1329123() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(24801);
            ShakeReportUI.this.gwZ = true;
            ShakeReportUI.this.finish();
            AppMethodBeat.m2505o(24801);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public ShakeReportUI() {
        AppMethodBeat.m2504i(24814);
        AppMethodBeat.m2505o(24814);
    }

    /* renamed from: B */
    static /* synthetic */ void m21291B(ShakeReportUI shakeReportUI) {
        AppMethodBeat.m2504i(24867);
        shakeReportUI.ckR();
        AppMethodBeat.m2505o(24867);
    }

    /* renamed from: D */
    static /* synthetic */ void m21294D(ShakeReportUI shakeReportUI) {
        AppMethodBeat.m2504i(24868);
        shakeReportUI.ckH();
        AppMethodBeat.m2505o(24868);
    }

    /* renamed from: J */
    static /* synthetic */ void m21300J(ShakeReportUI shakeReportUI) {
        AppMethodBeat.m2504i(24869);
        shakeReportUI.m21293CD(1);
        AppMethodBeat.m2505o(24869);
    }

    /* renamed from: K */
    static /* synthetic */ void m21301K(ShakeReportUI shakeReportUI) {
        AppMethodBeat.m2504i(24870);
        shakeReportUI.m21339kx(false);
        AppMethodBeat.m2505o(24870);
    }

    /* renamed from: d */
    static /* synthetic */ void m21322d(ShakeReportUI shakeReportUI, boolean z) {
        AppMethodBeat.m2504i(24863);
        shakeReportUI.m21340ky(z);
        AppMethodBeat.m2505o(24863);
    }

    /* renamed from: f */
    static /* synthetic */ void m21328f(ShakeReportUI shakeReportUI, boolean z) {
        AppMethodBeat.m2504i(24866);
        shakeReportUI.m21336ku(z);
        AppMethodBeat.m2505o(24866);
    }

    /* renamed from: k */
    static /* synthetic */ void m21334k(ShakeReportUI shakeReportUI) {
        AppMethodBeat.m2504i(24860);
        shakeReportUI.ckD();
        AppMethodBeat.m2505o(24860);
    }

    /* renamed from: l */
    static /* synthetic */ void m21341l(ShakeReportUI shakeReportUI) {
        AppMethodBeat.m2504i(24861);
        shakeReportUI.ckC();
        AppMethodBeat.m2505o(24861);
    }

    /* renamed from: w */
    static /* synthetic */ void m21352w(ShakeReportUI shakeReportUI) {
        AppMethodBeat.m2504i(24864);
        shakeReportUI.ckL();
        AppMethodBeat.m2505o(24864);
    }

    public final int getLayoutId() {
        return 2130970658;
    }

    public final int getForceOrientation() {
        return 1;
    }

    public void onCreate(Bundle bundle) {
        int i;
        int i2;
        AppMethodBeat.m2504i(24815);
        super.onCreate(bundle);
        setMMTitle((int) C25738R.string.efr);
        mo17446xE(getResources().getColor(C25738R.color.f11906l8));
        mo17372Nb(getResources().getColor(C25738R.color.f11906l8));
        dyb();
        this.ecr = C26443d.agz();
        C9638aw.m17190ZK();
        C18628c.m29072Ry().set(C5127a.USERINFO_SHAKE_TV_LATITUDE_STRING, (Object) "");
        C9638aw.m17190ZK();
        C18628c.m29072Ry().set(C5127a.USERINFO_SHAKE_TV_LONGTITUDE_STRING, (Object) "");
        C9638aw.m17190ZK();
        C18628c.m29072Ry().set(C5127a.USERINFO_SHAKE_TV_ACCURACY_STRING, (Object) "");
        this.qvU = findViewById(2131827507);
        C32782bp aao = C32782bp.aao();
        String nullAsNil = C5046bo.nullAsNil(aao.fnp);
        String nullAsNil2 = C5046bo.nullAsNil(aao.fno);
        String O = C26373g.m41965Nv().mo5301O("IBeacon", "GatedLaunch");
        if (C5046bo.isNullOrNil(O)) {
            O = null;
        }
        this.qwa = false;
        this.qwb = false;
        if (O != null) {
            try {
                JSONObject jSONObject = new JSONObject(O);
                i = jSONObject.getInt("gatedlaunch");
                C9638aw.m17179RK();
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
                C4990ab.m7412e("MicroMsg.ShakeReportUI", "[shakezb]parse dymanic setting json fail!!");
                this.qwa = false;
                this.qwb = false;
            }
        }
        if (C9638aw.m17179RK()) {
            C9638aw.m17190ZK();
            if (((Integer) C18628c.m29072Ry().get(C5127a.USERINFO_IBEACON_SHAKE_TAB_IS_UIN_RESIDENT_INT, Integer.valueOf(0))).intValue() == 1) {
                this.qwc = true;
            }
        }
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        boolean hasSystemFeature = C4996ah.getContext().getPackageManager().hasSystemFeature("android.hardware.bluetooth_le");
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
            C7060h.pYm.mo8381e(13139, nullAsNil, nullAsNil2, Integer.valueOf(1), Integer.valueOf(this.qwd), Integer.valueOf(i2), Integer.valueOf(i));
        } else {
            C7060h.pYm.mo8381e(13139, nullAsNil, nullAsNil2, Integer.valueOf(0), Integer.valueOf(this.qwd), Integer.valueOf(i2), Integer.valueOf(i));
        }
        if (this.qwc || this.qwa) {
            this.qvZ = true;
            this.qvU = findViewById(2131827520);
            if (this.qwb) {
                if (defaultAdapter == null || defaultAdapter.getState() != 12) {
                    this.qvZ = false;
                } else if (defaultAdapter != null) {
                    defaultAdapter.getState();
                }
            }
        }
        C28997f cjX = C28987m.cjX();
        if (cjX.kaD == null) {
            cjX.kaD = new ArrayList();
        }
        cjX.kaD.add(new WeakReference(this));
        Boolean bool = Boolean.FALSE;
        long anT = C5046bo.anT();
        long j = 0;
        long j2 = 0;
        if (C9638aw.m17179RK()) {
            C9638aw.m17190ZK();
            C18628c.m29072Ry().set(C5127a.USERINFO_IBEACON_PUSH_IS_IN_SHAKEUI_BOOLEAN, Boolean.TRUE);
            C9638aw.m17190ZK();
            Boolean valueOf = Boolean.valueOf(C5046bo.m7517a((Boolean) C18628c.m29072Ry().get(C5127a.USERINFO_IBEACON_PUSH_IS_OPEN_BOOLEAN, null), false));
            C9638aw.m17190ZK();
            j = C5046bo.m7514a((Long) C18628c.m29072Ry().get(C5127a.USERINFO_IBEACON_PUSH_OPEN_TIEMSTAMP_LONG, null), 0);
            C9638aw.m17190ZK();
            j2 = C5046bo.m7514a((Long) C18628c.m29072Ry().get(C5127a.USERINFO_IBEACON_PUSH_CHANNEL_OPEN_TIME_LONG, null), 0);
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
            C9638aw.m17190ZK();
            String bc = C5046bo.m7532bc((String) C18628c.m29072Ry().get(C5127a.USERINFO_IBEACON_PUSH_LAST_BEACONINFO_STRING, null), "");
            C9638aw.m17190ZK();
            O = C5046bo.m7532bc((String) C18628c.m29072Ry().get(C5127a.USERINFO_IBEACON_PUSH_BEACONINFO_STRING, null), "");
            if (!(O == null || O.equals(""))) {
                String[] split = O.split(",");
                C34894d c34894d = new C34894d();
                c34894d.field_type = 11;
                c34894d.field_username = split[0];
                c34894d.field_nickname = split[0];
                c34894d.field_signature = split[1];
                c34894d.field_province = split[2];
                c34894d.field_city = split[3];
                c34894d.field_sex = 1;
                try {
                    c34894d.field_lvbuffer = (String.valueOf(split[4]) + "," + String.valueOf(split[5]) + "," + String.valueOf(split[6])).getBytes(ProtocolPackage.ServerEncoding);
                } catch (UnsupportedEncodingException e2) {
                    C4990ab.m7412e("MicroMsg.ShakeReportUI", "[kevinkma]parst shakeItem error!");
                }
                c34894d.field_insertBatch = 2;
                C13247e cjS = C28987m.cjS();
                cjS.cjI();
                cjS.mo25304a(c34894d, true);
                List linkedList = new LinkedList();
                linkedList.add(c34894d);
                mo25340b(linkedList, 1);
                C9638aw.m17190ZK();
                C18628c.m29072Ry().set(C5127a.USERINFO_IBEACON_PUSH_BEACONINFO_STRING, (Object) "");
                Object obj = bc + "," + split[4] + split[5] + split[6];
                C9638aw.m17190ZK();
                C18628c.m29072Ry().set(C5127a.USERINFO_IBEACON_PUSH_LAST_BEACONINFO_STRING, obj);
            }
        }
        this.qvc = new C39711c(this.mController.ylv);
        this.oOS = new C30050d(this);
        if (!this.oOS.diK()) {
            C30379h.m48431a((Context) this, (int) C25738R.string.efi, (int) C25738R.string.f9238tz, new C384012());
        }
        if (C46193a.gkF != null) {
            C46193a.gkF.mo38844BS();
        }
        C18764x.m29328b((C18765a) this);
        C4990ab.m7417i("MicroMsg.ShakeReportUI", "%s", getResources().getDisplayMetrics().toString());
        i = C28987m.cjT().baS();
        C7060h.pYm.mo8381e(11317, Integer.valueOf(i), C43527e.ckT());
        C7060h.pYm.mo8381e(11710, Integer.valueOf(1));
        C7060h.pYm.mo15419k(834, 0, 1);
        AppMethodBeat.m2505o(24815);
    }

    public void onResume() {
        AppMethodBeat.m2504i(24816);
        super.onResume();
        if (this.gwZ) {
            if (!C17950b.m28216sO((String) C1720g.m3536RP().mo5239Ry().get(274436, null))) {
                C4990ab.m7417i("MicroMsg.ShakeReportUI", "summerper checkPermission checkposition[%b], stack[%s], activity[%s]", Boolean.valueOf(C35805b.m58707a(this, "android.permission.ACCESS_COARSE_LOCATION", 64, "", "")), C5046bo.dpG(), this);
                if (!C35805b.m58707a(this, "android.permission.ACCESS_COARSE_LOCATION", 64, "", "")) {
                    AppMethodBeat.m2505o(24816);
                    return;
                }
            } else if (!C35805b.m58714o(this, "android.permission.ACCESS_COARSE_LOCATION")) {
                if (((Boolean) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_GDPR_LOCATION_PERMISSION_DESCRIBE_CONFIRM_BOOLEAN_SYNC, Boolean.FALSE)).booleanValue()) {
                    C35805b.m58709b(this, "android.permission.ACCESS_COARSE_LOCATION", 64);
                    AppMethodBeat.m2505o(24816);
                    return;
                }
                C32921a.m53856b(this, getString(C25738R.string.g7p, new Object[]{C4988aa.dor()}), 30764, true);
                AppMethodBeat.m2505o(24816);
                return;
            }
        }
        cdJ();
        AppMethodBeat.m2505o(24816);
    }

    private void cdJ() {
        AppMethodBeat.m2504i(24817);
        ckF();
        C9638aw.m17190ZK();
        C18628c.m29103a(this);
        C9638aw.m17190ZK();
        C18628c.m29072Ry().mo10118a(this);
        C28987m.cjS().mo10116c(this);
        if (this.qvd.qrS != null) {
            this.qvd.qrS.resume();
        }
        ckG();
        new C7306ak().postDelayed(new C1328622(), 1000);
        if (this.oOS != null) {
            this.oOS.diJ();
        }
        m21339kx(false);
        m21340ky(false);
        ckI();
        C9638aw.m17190ZK();
        String str = (String) C18628c.m29072Ry().get(327696, (Object) "1");
        if (C3826k.cjQ()) {
            if (this.qvJ == 4) {
                m21335kt(true);
            }
            if (str.equals("4")) {
                m21324dy(findViewById(2131827518));
            }
        }
        if (str.equals(TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL)) {
            m21324dy(findViewById(2131827515));
        } else if (str.equals("6") && C28999a.cks()) {
            m21324dy(findViewById(2131827509));
        }
        boolean bY = C16112c.m24429PK().mo28552bY(262154, 266258);
        if (getIntent().getBooleanExtra("shake_music", false) && C25847d.aim() && this.qvd.qrR != 3) {
            getIntent().putExtra("shake_music", false);
            this.qvJ = 3;
        } else if (getIntent().getBooleanExtra("shake_tv", false) && this.qvd.qrR != 4 && C3826k.cjQ()) {
            getIntent().putExtra("shake_tv", false);
            this.qvJ = 4;
        } else if (this.qvd.qrR != 6 && C28999a.cks() && (bY || getIntent().getBooleanExtra("shake_card", false))) {
            this.qvV = getIntent().getIntExtra("shake_card", 0);
            getIntent().putExtra("shake_card", false);
            C4990ab.m7416i("MicroMsg.ShakeReportUI", "onresume shake card tab is open, activity type is 0 or open from specialview");
            this.qvJ = 6;
        }
        ckH();
        m21336ku(true);
        C4990ab.m7411d("MicroMsg.ShakeReportUI", "isShakeGetConfigList = %s", Boolean.valueOf(C1947ae.gip));
        if (C1947ae.gip) {
            C9638aw.m17182Rg().mo14541a(new C45181k(7), 0);
        }
        ckR();
        ckO();
        ckC();
        AppMethodBeat.m2505o(24817);
    }

    public void onPause() {
        AppMethodBeat.m2504i(24818);
        C9638aw.m17190ZK();
        C18628c.m29104b(this);
        C9638aw.m17190ZK();
        C18628c.m29072Ry().mo10121b(this);
        C28987m.cjS().mo10117d(this);
        if (this.qvd.qrS != null) {
            this.qvd.qrS.pause();
        }
        this.quZ = false;
        if (this.oOS != null) {
            this.oOS.bgr();
        }
        this.qvc.ckz();
        if (this.qvJ != 5) {
            C9638aw.m17190ZK();
            C18628c.m29072Ry().set(327696, this.qvJ);
        }
        if (this.qvJ == 4) {
            m21335kt(false);
        }
        ckD();
        super.onPause();
        AppMethodBeat.m2505o(24818);
    }

    public void onDestroy() {
        boolean z = false;
        AppMethodBeat.m2504i(24819);
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
        C34904j a = C34904j.m57320a(null);
        if (C34904j.isInited) {
            C34904j.isInited = false;
            if (!a.qtU.cku()) {
                C4990ab.m7412e("Micromsg.ShakeMusicMgr", "release MusicFingerPrintRecorder error");
            }
        }
        C34904j.qtV = null;
        C18764x.m29330c((C18765a) this);
        C4879a.xxA.mo10053d(this.qwg);
        C4879a.xxA.mo10053d(this.qwh);
        C9638aw.m17190ZK();
        C18628c.m29072Ry().set(C5127a.USERINFO_IBEACON_PUSH_IS_IN_SHAKEUI_BOOLEAN, Boolean.FALSE);
        ckD();
        if (C28999a.cks()) {
            C16112c.m24429PK().mo28557y(262154, false);
        }
        ckL();
        C28997f cjX = C28987m.cjX();
        if (cjX.kaD != null) {
            while (true) {
                boolean z2 = z;
                if (z2 >= cjX.kaD.size()) {
                    break;
                }
                WeakReference weakReference = (WeakReference) cjX.kaD.get(z2);
                if (weakReference != null) {
                    C28996a c28996a = (C28996a) weakReference.get();
                    if (c28996a != null && c28996a.equals(this)) {
                        cjX.kaD.remove(weakReference);
                        break;
                    }
                }
                z = z2 + 1;
            }
        }
        C46197d cjY = C28987m.cjY();
        cjY.ecs = -85.0f;
        cjY.ect = -1000.0f;
        if (this.ecr != null) {
            this.ecr.mo44208c(this.ecy);
        }
        super.onDestroy();
        AppMethodBeat.m2505o(24819);
    }

    static {
        AppMethodBeat.m2504i(24872);
        AppMethodBeat.m2505o(24872);
    }

    private void ckC() {
        AppMethodBeat.m2504i(24820);
        if (ShakeReportUI.ckQ()) {
            if (BluetoothAdapter.getDefaultAdapter() != null) {
                List<String> Nl = C26373g.m41965Nv().mo5299Nl();
                if (Nl != null) {
                    this.qwe = System.currentTimeMillis();
                    for (String str : Nl) {
                        C4990ab.m7417i("MicroMsg.ShakeReportUI", "op=true,iBeacon = %s", str);
                        C18245ds c18245ds = new C18245ds();
                        c18245ds.cxg.cxi = str;
                        c18245ds.cxg.cxf = true;
                        C4879a.xxA.mo10055m(c18245ds);
                    }
                }
            }
            AppMethodBeat.m2505o(24820);
            return;
        }
        AppMethodBeat.m2505o(24820);
    }

    private void ckD() {
        AppMethodBeat.m2504i(24821);
        C9638aw.m17190ZK();
        if (!C5046bo.m7517a((Boolean) C18628c.m29072Ry().get(C5127a.USERINFO_IBEACON_PUSH_IS_IN_SHAKEUI_BOOLEAN, null), false)) {
            this.ecv.clear();
            ecw = new CopyOnWriteArrayList();
        }
        if (VERSION.SDK_INT >= 18) {
            List<String> Nl = C26373g.m41965Nv().mo5299Nl();
            if (Nl != null) {
                for (String str : Nl) {
                    C18245ds c18245ds = new C18245ds();
                    C4990ab.m7417i("MicroMsg.ShakeReportUI", "op=false,iBeacon = %s", str);
                    c18245ds.cxg.cxi = str;
                    c18245ds.cxg.cxf = false;
                    C4879a.xxA.mo10055m(c18245ds);
                }
            }
        }
        AppMethodBeat.m2505o(24821);
    }

    public final void initView() {
        AppMethodBeat.m2504i(24822);
        C28999a.cjM();
        this.qvY.put(Integer.valueOf(1), Boolean.TRUE);
        this.qvY.put(Integer.valueOf(3), Boolean.FALSE);
        this.qvY.put(Integer.valueOf(4), Boolean.FALSE);
        this.qvY.put(Integer.valueOf(5), Boolean.FALSE);
        this.qvY.put(Integer.valueOf(6), Boolean.FALSE);
        this.fGv = new C25815a((Context) this);
        this.qvh = (TextView) findViewById(2131827494);
        this.qvg = findViewById(2131827495);
        this.qvi = (TextView) findViewById(2131827497);
        this.qvj = (TextView) findViewById(2131827496);
        this.qvL = findViewById(2131827522);
        this.qvM = (ImageView) findViewById(2131827524);
        this.qvN = (ImageView) findViewById(2131827526);
        this.qvO = (ImageView) findViewById(2131827528);
        this.qvP = (ImageView) findViewById(2131827530);
        this.qvQ = findViewById(2131827523);
        this.qvR = findViewById(2131827525);
        this.qvS = findViewById(2131827527);
        this.qvT = findViewById(2131827529);
        this.qvf = findViewById(2131827500);
        this.qvf.setOnClickListener(this.qwi);
        this.eks = (ImageView) this.qvf.findViewById(2131827501);
        this.eks.setOnClickListener(new C1327026());
        ckF();
        View inflate = View.inflate(this.mController.ylL, 2130970654, null);
        this.qvz = new C15532i(this.mController.ylL, C25738R.style.f11415zt);
        this.qvz.setContentView(inflate);
        this.qvz.setOnCancelListener(new C132724());
        ((Button) inflate.findViewById(2131827481)).setOnClickListener(new C38435());
        C9638aw.m17190ZK();
        boolean e = C5046bo.m7546e((Boolean) C18628c.m29072Ry().get(4108, null));
        C9638aw.m17190ZK();
        boolean e2 = C5046bo.m7546e((Boolean) C18628c.m29072Ry().get(4117, null));
        if (!e) {
            inflate.setVisibility(0);
            this.qvz.show();
            C9638aw.m17190ZK();
            C18628c.m29072Ry().set(4108, Boolean.TRUE);
        } else if (!e2) {
            Looper.myQueue().addIdleHandler(new C132796());
        }
        setBackBtn(new C384227());
        addIconOptionMenu(0, C25738R.string.f8699cg, C1318a.actionbar_setting_icon, new C1327728());
        C1327829 c1327829 = new C1327829();
        if (this.qwc || this.qwa) {
            this.qvA = (ImageView) findViewById(2131827521);
        } else {
            this.qvA = (ImageView) findViewById(2131827508);
        }
        this.qvC = (ImageView) findViewById(2131827514);
        this.qvD = (ImageView) findViewById(2131827516);
        this.qvE = (ImageView) findViewById(2131827519);
        this.qvF = (ImageView) findViewById(2131827510);
        this.qvI = (TextView) findViewById(2131827512);
        this.qvH = (ImageView) findViewById(2131827511);
        this.qvG = (ImageView) findViewById(2131827517);
        ckN();
        this.qvU.setOnClickListener(c1327829);
        findViewById(2131827520).setOnClickListener(c1327829);
        findViewById(2131827513).setOnClickListener(c1327829);
        findViewById(2131827515).setOnClickListener(c1327829);
        findViewById(2131827518).setOnClickListener(c1327829);
        findViewById(2131827509).setOnClickListener(c1327829);
        C4879a.xxA.mo10052c(this.qwg);
        C4879a.xxA.mo10052c(this.qwh);
        ckJ();
        ckM();
        ckR();
        AppMethodBeat.m2505o(24822);
    }

    private void ckE() {
        AppMethodBeat.m2504i(24823);
        if (C25847d.ain()) {
            C9638aw.m17190ZK();
            if (C18628c.m29072Ry().getInt(4118, 0) == 0) {
                C5652a c5652a = new C5652a(this.mController.ylL);
                c5652a.mo11446PV(C25738R.string.f9238tz);
                c5652a.mo11450PZ(C25738R.string.eeu);
                c5652a.mo11453Qc(C25738R.string.eet).mo11457a(new C132712());
                c5652a.mo11482rc(true);
                c5652a.mo11478f(new C132753());
                this.qvz = c5652a.aMb();
                this.qvz.show();
            }
        }
        AppMethodBeat.m2505o(24823);
    }

    private void ckF() {
        AppMethodBeat.m2504i(24824);
        C9638aw.m17190ZK();
        int a = C5046bo.m7512a((Integer) C18628c.m29072Ry().get(12290, null), 0);
        ImageView imageView = (ImageView) findViewById(2131827488);
        if (!(this.qvy == null || this.qvy.isRecycled())) {
            this.qvy.recycle();
        }
        C9638aw.m17190ZK();
        if (C5046bo.m7545d((Boolean) C18628c.m29072Ry().get(4110, null))) {
            StringBuilder stringBuilder = new StringBuilder();
            C9638aw.m17190ZK();
            String stringBuilder2 = stringBuilder.append(C18628c.m29088XW()).append("default_shake_img_filename.jpg").toString();
            if (C5730e.m8628ct(stringBuilder2)) {
                this.qvy = C18764x.m29333vv(stringBuilder2);
                imageView.setImageDrawable(new BitmapDrawable(this.qvy));
            } else {
                Drawable bitmapDrawable;
                try {
                    bitmapDrawable = new BitmapDrawable(C5056d.decodeStream(this.mController.ylL.getAssets().open("resource/shakehideimg_man.jpg")));
                } catch (IOException e) {
                    C4990ab.m7420w("MicroMsg.ShakeReportUI", "Bg decode exp:" + e.getLocalizedMessage());
                    bitmapDrawable = null;
                }
                imageView.setImageDrawable(bitmapDrawable);
            }
        } else {
            C9638aw.m17190ZK();
            this.qvy = C18764x.m29333vv((String) C18628c.m29072Ry().get(4111, null));
            imageView.setImageDrawable(new BitmapDrawable(this.qvy));
        }
        imageView = (ImageView) findViewById(2131827490);
        ImageView imageView2 = (ImageView) findViewById(2131827493);
        imageView.setImageResource(a == 2 ? C25738R.drawable.bhg : C25738R.drawable.bhh);
        imageView2.setImageResource(a == 2 ? C25738R.drawable.bhf : C25738R.drawable.bhe);
        C132807 c132807 = new C132807();
        imageView.setOnClickListener(c132807);
        imageView2.setOnClickListener(c132807);
        if (this.qvm == null) {
            this.qvm = findViewById(2131827498);
        }
        this.qvm.setOnClickListener(c132807);
        if (this.qvn == null) {
            this.qvn = findViewById(2131827491);
        }
        this.qvn.setOnClickListener(c132807);
        AppMethodBeat.m2505o(24824);
    }

    private void ckG() {
        AppMethodBeat.m2504i(24825);
        this.quZ = true;
        if (!(this.qvW == null || !this.qvW.isShowing() || this.qvW.qsZ)) {
            this.quZ = false;
        }
        C4990ab.m7416i("MicroMsg.ShakeReportUI", "tryStartShake");
        if (!(this.oOS == null || this.oOS.diI())) {
            this.oOS.mo48276a(new C13282a(this));
            if (!this.oOS.diK() || this.qvh == null) {
                this.qvh.setText(getString(C25738R.string.efi));
            } else {
                this.qvh.setText(getString(C25738R.string.edu));
                AppMethodBeat.m2505o(24825);
                return;
            }
        }
        AppMethodBeat.m2505o(24825);
    }

    /* renamed from: kt */
    private void m21335kt(boolean z) {
        AppMethodBeat.m2504i(24826);
        String format = String.format("%1$s-shaketype-%2$d", new Object[]{getClass().getName(), Integer.valueOf(4)});
        C4990ab.m7410d("MicroMsg.ShakeReportUI", "activate change report , class name=" + format + ", isActive=" + z);
        C5288y.m8058d(z, new Intent().putExtra("classname", format));
        AppMethodBeat.m2505o(24826);
    }

    private void ckH() {
        AppMethodBeat.m2504i(24827);
        if (this.qvJ == 3 && C25847d.aim()) {
            this.qvJ = 3;
            this.qvj.setText(C25738R.string.efy);
            this.qvA.setBackgroundResource(C25738R.drawable.bha);
            this.qvC.setBackgroundResource(C25738R.drawable.anv);
            this.qvD.setBackgroundResource(C25738R.drawable.anu);
            this.qvE.setBackgroundResource(C25738R.drawable.anx);
            this.qvF.setBackgroundResource(C25738R.drawable.bh8);
            findViewById(2131827506).setVisibility(0);
            setMMTitle((int) C25738R.string.efu);
            C7060h.pYm.mo8381e(11720, Integer.valueOf(2));
            C7060h.pYm.mo15419k(834, 2, 1);
        } else if (this.qvJ == 4 && C3826k.cjQ()) {
            this.qvJ = 4;
            this.qvj.setText(C25738R.string.efz);
            this.qvA.setBackgroundResource(C25738R.drawable.bha);
            this.qvC.setBackgroundResource(C25738R.drawable.anv);
            this.qvD.setBackgroundResource(C25738R.drawable.ant);
            this.qvE.setBackgroundResource(C25738R.drawable.any);
            this.qvF.setBackgroundResource(C25738R.drawable.bh8);
            findViewById(2131827506).setVisibility(0);
            setMMTitle((int) C25738R.string.efv);
            C7060h.pYm.mo8381e(11720, Integer.valueOf(3));
            C7060h.pYm.mo15419k(834, 3, 1);
        } else if (this.qvJ == 5 && ckP()) {
            this.qvJ = 5;
            this.qvj.setText(C25738R.string.efx);
            this.qvA.setBackgroundResource(C25738R.drawable.bhb);
            this.qvC.setBackgroundResource(C25738R.drawable.anv);
            this.qvD.setBackgroundResource(C25738R.drawable.ant);
            this.qvE.setBackgroundResource(C25738R.drawable.anx);
            this.qvF.setBackgroundResource(C25738R.drawable.bh8);
            findViewById(2131827506).setVisibility(0);
            setMMTitle((int) C25738R.string.eft);
            C7060h.pYm.mo8381e(11720, Integer.valueOf(4));
            C7060h.pYm.mo15419k(834, 4, 1);
        } else if (this.qvJ == 6 && C28999a.cks()) {
            this.qvJ = 6;
            this.qvj.setText(C25738R.string.efw);
            this.qvA.setBackgroundResource(C25738R.drawable.bha);
            this.qvC.setBackgroundResource(C25738R.drawable.anv);
            this.qvD.setBackgroundResource(C25738R.drawable.ant);
            this.qvE.setBackgroundResource(C25738R.drawable.anx);
            this.qvF.setBackgroundResource(C25738R.drawable.bh9);
            findViewById(2131827506).setVisibility(0);
            setMMTitle((int) C25738R.string.efs);
            ckK();
            ckN();
            C7060h.pYm.mo8381e(11720, Integer.valueOf(5));
            C7060h.pYm.mo15419k(834, 5, 1);
        } else {
            this.qvJ = 1;
            this.qvj.setText(C25738R.string.eed);
            this.qvA.setBackgroundResource(C25738R.drawable.bha);
            this.qvC.setBackgroundResource(C25738R.drawable.anw);
            this.qvD.setBackgroundResource(C25738R.drawable.ant);
            this.qvE.setBackgroundResource(C25738R.drawable.anx);
            this.qvF.setBackgroundResource(C25738R.drawable.bh8);
            if (C25847d.aim()) {
                findViewById(2131827506).setVisibility(0);
            }
            setMMTitle((int) C25738R.string.efr);
            C7060h.pYm.mo8381e(11720, Integer.valueOf(1));
            C7060h.pYm.mo15419k(834, 1, 1);
        }
        C21828b a = this.qvd.mo62652a(this, this.qvJ, this);
        if (!this.quX) {
            m21340ky(false);
        }
        if (C28999a.cks() && (a instanceof C7084g)) {
            ((C7084g) a).setFromScene(this.qvV);
            if (this.qvV == 3) {
                C4990ab.m7416i("MicroMsg.ShakeReportUI", "open shake card from specialview");
                ((C7084g) a).mo15427Ix(getIntent().getStringExtra("key_shake_card_ext_info"));
            }
        }
        AppMethodBeat.m2505o(24827);
    }

    private void ckI() {
        AppMethodBeat.m2504i(24828);
        C9638aw.m17190ZK();
        this.quW = C5046bo.m7545d((Boolean) C18628c.m29072Ry().get(4112, null));
        if (this.quW) {
            setTitleMuteIconVisibility(8);
            AppMethodBeat.m2505o(24828);
            return;
        }
        setTitleMuteIconVisibility(0);
        AppMethodBeat.m2505o(24828);
    }

    /* renamed from: ku */
    private void m21336ku(boolean z) {
        AppMethodBeat.m2504i(24829);
        m21337kv(z);
        m21338kw(z);
        AppMethodBeat.m2505o(24829);
    }

    /* renamed from: kv */
    private void m21337kv(boolean z) {
        AppMethodBeat.m2504i(24830);
        if (this.qvs == null) {
            this.qvs = findViewById(2131824685);
        }
        if (this.qvd.qrR == 3 || this.qvd.qrR == 4 || this.qvd.qrR == 5 || this.qvd.qrR == 6 || !z) {
            this.qvs.setVisibility(8);
            AppMethodBeat.m2505o(24830);
            return;
        }
        int baS = C41789d.akR().baS();
        if (baS <= 0) {
            this.qvs.setVisibility(8);
            AppMethodBeat.m2505o(24830);
            return;
        }
        this.qvs.setVisibility(0);
        ((TextView) this.qvs.findViewById(2131824687)).setText(getResources().getQuantityString(C25738R.plurals.f9615a1, baS, new Object[]{Integer.valueOf(baS)}));
        this.qvs.setOnClickListener(new C132878());
        if (this.qvw == null) {
            this.qvw = (ImageView) findViewById(2131824686);
        }
        C41338bt duu = C41789d.akR().duu();
        if (duu != null) {
            this.qvx = duu.field_sayhiuser;
            C40460b.m69434b(this.qvw, this.qvx);
        }
        AppMethodBeat.m2505o(24830);
    }

    /* renamed from: kw */
    private void m21338kw(boolean z) {
        AppMethodBeat.m2504i(24831);
        if (this.qvt == null) {
            this.qvt = findViewById(2131824688);
        }
        if (z) {
            if (C28987m.cjT().baS() <= 0) {
                this.qvt.setVisibility(8);
                AppMethodBeat.m2505o(24831);
                return;
            }
            if (this.qvv == null) {
                this.qvv = (TextView) this.qvt.findViewById(2131824690);
            }
            this.qvv.setText(getString(C25738R.string.efb, new Object[]{Integer.valueOf(r1)}));
            this.qvt.setOnClickListener(new C132819());
            if (this.qvu == null) {
                this.qvu = (MMImageView) findViewById(2131824689);
            }
            C13248f cjJ = C28987m.cjT().cjJ();
            if (cjJ != null) {
                String str = cjJ.field_thumburl;
                if (C5046bo.isNullOrNil(str)) {
                    this.qvu.setImageResource(C1318a.app_attach_file_icon_webpage);
                } else {
                    C9791v c29004b = new C29004b(str);
                    Bitmap a = C18764x.m29325a(c29004b);
                    this.qvu.setTag(c29004b.anL());
                    if (a == null || a.isRecycled()) {
                        this.qvu.setImageResource(C1318a.app_attach_file_icon_webpage);
                    } else {
                        this.qvu.setImageBitmap(a);
                    }
                }
            }
            this.qvt.setVisibility(0);
            AppMethodBeat.m2505o(24831);
            return;
        }
        this.qvt.setVisibility(8);
        AppMethodBeat.m2505o(24831);
    }

    /* renamed from: kx */
    private void m21339kx(boolean z) {
        AppMethodBeat.m2504i(24832);
        if (this.qvi != null) {
            if (z) {
                this.qvi.setVisibility(0);
                AppMethodBeat.m2505o(24832);
                return;
            }
            this.qvi.setVisibility(8);
            this.qvi.cancelLongPress();
        }
        AppMethodBeat.m2505o(24832);
    }

    /* renamed from: ky */
    private void m21340ky(boolean z) {
        AppMethodBeat.m2504i(24833);
        if (this.qvg != null) {
            if (z) {
                this.qvg.setVisibility(0);
                AppMethodBeat.m2505o(24833);
                return;
            }
            this.qvg.setVisibility(4);
        }
        AppMethodBeat.m2505o(24833);
    }

    /* renamed from: CD */
    private void m21293CD(int i) {
        AppMethodBeat.m2504i(24834);
        m21340ky(i == 1);
        if (i == 2) {
            m21339kx(true);
            AppMethodBeat.m2505o(24834);
            return;
        }
        m21339kx(false);
        AppMethodBeat.m2505o(24834);
    }

    /* renamed from: ZB */
    public final void mo5390ZB() {
        AppMethodBeat.m2504i(24835);
        ckH();
        AppMethodBeat.m2505o(24835);
    }

    /* renamed from: WM */
    private void m21307WM(String str) {
        AppMethodBeat.m2504i(24836);
        this.quX = false;
        if (this.quW) {
            C35988ay.m59201au(this.mController.ylL, C25738R.string.efh);
        }
        if (this.qvr == null) {
            this.qvr = AnimationUtils.loadAnimation(this.mController.ylL, C25738R.anim.f8327ay);
        }
        m21293CD(2);
        if (str == null || str.length() <= 1) {
            this.qvi.setText(C25738R.string.eek);
        } else {
            this.qvi.setText(str);
        }
        this.qvi.startAnimation(this.qvr);
        this.qva = true;
        C5004al.m7442n(new C1326714(), this.qvr.getDuration());
        AppMethodBeat.m2505o(24836);
    }

    /* renamed from: b */
    public final void mo25340b(List<C34894d> list, long j) {
        AppMethodBeat.m2504i(24837);
        ckR();
        if (list == null || !this.quX || j == 6) {
            this.qvB = null;
            if (j == 6) {
                m21307WM(getString(C25738R.string.ees));
                AppMethodBeat.m2505o(24837);
                return;
            } else if (j == 7) {
                m21307WM(getString(C25738R.string.eeq));
                AppMethodBeat.m2505o(24837);
                return;
            } else if (j == 8) {
                m21307WM(getString(C25738R.string.eeo));
                AppMethodBeat.m2505o(24837);
                return;
            } else if (j == 9) {
                m21307WM(getString(C25738R.string.een));
                AppMethodBeat.m2505o(24837);
                return;
            } else if (j == 10) {
                m21307WM(getString(C25738R.string.eer));
                AppMethodBeat.m2505o(24837);
                return;
            } else {
                m21307WM(null);
                AppMethodBeat.m2505o(24837);
                return;
            }
        }
        this.quX = false;
        if (list.size() > 0) {
            this.qvB = (C34894d) list.get(0);
        }
        int size;
        Intent intent;
        if (this.qvd.qrR == 1) {
            if (list.size() <= 0 || ((C34894d) list.get(0)).field_type == 0) {
                this.qvb = ((C34894d) list.get(0)).scene;
                size = list.size();
                if (size == 0) {
                    m21307WM(null);
                    AppMethodBeat.m2505o(24837);
                    return;
                } else if (size == 1) {
                    String str = ((C34894d) list.get(0)).field_username;
                    C4990ab.m7416i("MicroMsg.ShakeReportUI", "1 u:" + str + " n:" + ((C34894d) list.get(0)).field_nickname + " d:" + ((C34894d) list.get(0)).field_distance);
                    if (this.quW) {
                        C35988ay.m59201au(this.mController.ylL, C25738R.string.ef_);
                    }
                    m21293CD(3);
                    m21319c((C34894d) list.get(0));
                    AppMethodBeat.m2505o(24837);
                    return;
                } else {
                    if (this.quW) {
                        C35988ay.m59201au(this.mController.ylL, C25738R.string.ef_);
                    }
                    m21293CD(3);
                    m21337kv(false);
                    intent = new Intent(this, ShakeItemListUI.class);
                    intent.putExtra("_key_show_type_", -1);
                    intent.putExtra("_key_title_", getString(C25738R.string.ef5));
                    startActivity(intent);
                    AppMethodBeat.m2505o(24837);
                    return;
                }
            }
            m21307WM(null);
            AppMethodBeat.m2505o(24837);
        } else if (this.qvd.qrR == 3) {
            size = list.size();
            if (size == 0) {
                m21307WM(getString(C25738R.string.efg));
                AppMethodBeat.m2505o(24837);
                return;
            }
            if (size == 1) {
                if (this.quW) {
                    C35988ay.m59201au(this.mController.ylL, C25738R.string.ef_);
                }
                m21293CD(3);
                if (((C34894d) list.get(0)).field_type == 4) {
                    C9058e d = C39695i.m67840d(((C34894d) list.get(0)).field_lvbuffer, j);
                    C37494a.m63281c(d);
                    Intent intent2 = new Intent();
                    intent2.putExtra("key_mode", 1);
                    intent2.putExtra("key_offset", d.fJV);
                    intent2.putExtra("music_player_beg_time", d.fKn);
                    intent2.putExtra("key_scene", 3);
                    if (C25847d.ain()) {
                        intent2.putExtra("KGlobalShakeMusic", true);
                    }
                    C25985d.m41467b((Context) this, "music", ".ui.MusicMainUI", intent2);
                    AppMethodBeat.m2505o(24837);
                    return;
                }
                C4990ab.m7420w("MicroMsg.ShakeReportUI", "Unexpected type, ignore.");
            }
            AppMethodBeat.m2505o(24837);
        } else if (this.qvd.qrR == 4) {
            ckR();
            size = list.size();
            if (size == 0) {
                m21307WM(getString(C25738R.string.egn));
                AppMethodBeat.m2505o(24837);
                return;
            }
            if (size == 1) {
                if (this.quW) {
                    C35988ay.m59201au(this.mController.ylL, C25738R.string.ef_);
                }
                m21293CD(3);
                C3826k.m6120a((C34894d) list.get(0), this);
            }
            AppMethodBeat.m2505o(24837);
        } else {
            if (this.qvd.qrR == 5) {
                switch ((int) j) {
                    case 1:
                        if (list.isEmpty() || ((C34894d) list.get(0)).field_type != 11) {
                            m21307WM(null);
                            AppMethodBeat.m2505o(24837);
                            return;
                        } else if (list.size() == 1) {
                            if (this.quW) {
                                C35988ay.m59201au(this.mController.ylL, C25738R.string.ef_);
                            }
                            m21293CD(3);
                            m21321d((C34894d) list.get(0));
                            AppMethodBeat.m2505o(24837);
                            return;
                        } else {
                            if (this.quW) {
                                C35988ay.m59201au(this.mController.ylL, C25738R.string.ef_);
                            }
                            m21293CD(3);
                            m21337kv(false);
                            intent = new Intent(this, ShakeItemListUI.class);
                            intent.putExtra("_key_show_type_", -12);
                            intent.putExtra("_key_title_", getString(C25738R.string.ef3));
                            intent.putExtra("_key_show_from_shake_", true);
                            intent.putExtra("_ibeacon_new_insert_size", list.size());
                            startActivity(intent);
                            AppMethodBeat.m2505o(24837);
                            return;
                        }
                    case 6:
                        m21307WM(getString(C25738R.string.ees));
                        break;
                }
            }
            AppMethodBeat.m2505o(24837);
        }
    }

    /* renamed from: a */
    public final void mo25339a(int i, final C21829e c21829e, long j) {
        AppMethodBeat.m2504i(24838);
        this.qvX = true;
        if (i != 1251) {
            if (i == 1250) {
                if (c21829e != null) {
                    if ((c21829e != null && !this.quX) || this.quX) {
                        this.quX = false;
                        C4990ab.m7416i("MicroMsg.ShakeReportUI", "onShakeCardReturn MMFunc_Biz_ShakeCard");
                        if (this.qvd.qrR == 6) {
                            C21828b c21828b = this.qvd.qrS;
                            if (c21828b != null && (c21828b instanceof C7084g)) {
                                C7084g c7084g = (C7084g) c21828b;
                                switch ((int) j) {
                                    case 1:
                                        C4990ab.m7416i("MicroMsg.ShakeReportUI", "onShakeGetReturn() ShakeCardService RETURN_OK");
                                        if (c7084g.kdC == 3) {
                                            C4990ab.m7416i("MicroMsg.ShakeReportUI", "onShakeGetReturn() actionType is  MMBIZ_SHAKE_CARD_ACTION_TYPE_NO_CARD");
                                            if (c21829e == null || TextUtils.isEmpty(c21829e.qsu)) {
                                                m21307WM(getString(C25738R.string.ee_));
                                                AppMethodBeat.m2505o(24838);
                                                return;
                                            }
                                            m21307WM(c21829e.qsu);
                                            AppMethodBeat.m2505o(24838);
                                            return;
                                        }
                                        C4990ab.m7416i("MicroMsg.ShakeReportUI", "onShakeGetReturn() actionType is " + c7084g.kdC);
                                        m21293CD(3);
                                        if (c21829e.kdC == 1) {
                                            this.quZ = false;
                                        }
                                        if (this.qvW != null && this.qvW.isShowing()) {
                                            AppMethodBeat.m2505o(24838);
                                            return;
                                        } else if (c21829e.qsw) {
                                            ViewStub viewStub = (ViewStub) findViewById(2131827499);
                                            if (viewStub != null) {
                                                viewStub.inflate();
                                            }
                                            ((ShakeEggAnimFrame) findViewById(2131822727)).mo8495aa(this);
                                            new C7306ak().postDelayed(new Runnable() {
                                                public final void run() {
                                                    AppMethodBeat.m2504i(24793);
                                                    ShakeReportUI.m21312a(ShakeReportUI.this, c21829e);
                                                    AppMethodBeat.m2505o(24793);
                                                }
                                            }, 1000);
                                            AppMethodBeat.m2505o(24838);
                                            return;
                                        } else {
                                            m21310a(c21829e);
                                            AppMethodBeat.m2505o(24838);
                                            return;
                                        }
                                    case 2:
                                        C4990ab.m7416i("MicroMsg.ShakeReportUI", "onShakeGetReturn() ShakeCardService RETURN_ERR_REPORT");
                                        m21307WM(getString(C25738R.string.ee_));
                                        break;
                                }
                            }
                        }
                    }
                    this.qvB = null;
                    m21307WM(null);
                    AppMethodBeat.m2505o(24838);
                    return;
                }
                this.qvB = null;
                m21307WM(null);
                AppMethodBeat.m2505o(24838);
                return;
            }
            AppMethodBeat.m2505o(24838);
        } else if (c21829e == null) {
            AppMethodBeat.m2505o(24838);
        } else {
            C4990ab.m7416i("MicroMsg.ShakeReportUI", "onShakeCardReturn MMFunc_Biz_GetLbsCard");
            C28999a.cjM();
            ckO();
            ckJ();
            ckM();
            this.qvV = 4;
            C28987m.cjY().putValue("key_shake_card_item", c21829e);
            AppMethodBeat.m2505o(24838);
        }
    }

    /* renamed from: a */
    private void m21310a(C21829e c21829e) {
        AppMethodBeat.m2504i(24839);
        this.qvW = C43523a.m77765a(this, c21829e, new C1328316(), new C1328917());
        AppMethodBeat.m2505o(24839);
    }

    /* renamed from: dy */
    private void m21324dy(View view) {
        AppMethodBeat.m2504i(24840);
        if (view == null) {
            AppMethodBeat.m2505o(24840);
            return;
        }
        C4990ab.m7417i("MicroMsg.ShakeReportUI", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", Boolean.valueOf(C35805b.m58707a(this, "android.permission.RECORD_AUDIO", 80, "", "")), C5046bo.dpG(), this);
        if (C35805b.m58707a(this, "android.permission.RECORD_AUDIO", 80, "", "")) {
            m21317be("", false);
            if (view.getId() == 2131827513) {
                C7060h.pYm.mo8381e(11722, Integer.valueOf(1));
                if (this.qvJ != 1) {
                    if (this.qvJ == 4) {
                        m21335kt(false);
                    }
                    this.qvJ = 1;
                    ckH();
                    m21337kv(false);
                    if (this.qvf != null) {
                        this.qvf.setVisibility(8);
                    }
                }
            } else if (view.getId() == 2131827515) {
                C7060h.pYm.mo8381e(11722, Integer.valueOf(2));
                if (!(this.ecu || this.ecr == null)) {
                    this.ecr.mo44204a(this.ecy, true);
                }
                if (!(C35973a.m59179bJ(this) || C35973a.m59177bH(this) || this.qvJ == 3)) {
                    if (this.qvJ == 4) {
                        m21335kt(false);
                    }
                    this.qvJ = 3;
                    ckH();
                    m21337kv(false);
                    if (this.qvf != null) {
                        this.qvf.setVisibility(8);
                    }
                }
                ckE();
            } else if (view.getId() == 2131827518) {
                C7060h.pYm.mo8381e(11722, Integer.valueOf(3));
                if (!(this.ecu || this.ecr == null)) {
                    this.ecr.mo44204a(this.ecy, true);
                }
                if (!(C35973a.m59179bJ(this) || C35973a.m59177bH(this) || this.qvJ == 4)) {
                    m21335kt(true);
                    this.qvJ = 4;
                    ckH();
                    m21337kv(false);
                    if (this.qvf != null) {
                        this.qvf.setVisibility(8);
                    }
                }
            } else if (view.getId() == 2131827520 || view.getId() == 2131827507) {
                C7060h.pYm.mo8381e(11722, Integer.valueOf(4));
                if (this.qvJ != 5) {
                    this.qvJ = 5;
                    ckH();
                    m21337kv(false);
                    if (this.qvf != null) {
                        this.qvf.setVisibility(8);
                    }
                    if (!(VERSION.RELEASE.equals("6.0") || VERSION.RELEASE.equals("6.0.0") || VERSION.SDK_INT < 23)) {
                        boolean isProviderEnabled;
                        LocationManager locationManager = (LocationManager) C4996ah.getContext().getSystemService(C8741b.LOCATION);
                        if (locationManager != null) {
                            isProviderEnabled = locationManager.isProviderEnabled("gps");
                        } else {
                            isProviderEnabled = true;
                        }
                        if (!isProviderEnabled) {
                            m21307WM(getString(C25738R.string.eeo));
                        }
                    }
                    BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
                    if (defaultAdapter != null && defaultAdapter.getState() != 12) {
                        m21307WM(getString(C25738R.string.een));
                    } else if (defaultAdapter == null) {
                        m21307WM(getString(C25738R.string.eer));
                    }
                }
            } else if (view.getId() == 2131827509) {
                C7060h.pYm.mo8381e(11722, Integer.valueOf(5));
                if (this.qvJ != 6) {
                    if (this.qvJ == 4) {
                        m21335kt(false);
                    }
                    this.qvJ = 6;
                    ckH();
                    m21337kv(false);
                    if (this.qvf != null) {
                        this.qvf.setVisibility(8);
                    }
                    C16112c.m24429PK().mo28557y(262155, false);
                    this.qvH.setVisibility(8);
                }
            }
            m21336ku(true);
            m21340ky(false);
            ckR();
            AppMethodBeat.m2505o(24840);
            return;
        }
        AppMethodBeat.m2505o(24840);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(24841);
        super.onActivityResult(i, i2, intent);
        switch (i) {
            case 1:
                if (intent == null) {
                    AppMethodBeat.m2505o(24841);
                    return;
                }
                Intent intent2 = new Intent();
                intent2.putExtra("CropImageMode", 4);
                intent2.putExtra("CropImage_Filter", true);
                intent2.putExtra("CropImage_DirectlyIntoFilter", true);
                StringBuilder stringBuilder = new StringBuilder();
                C9638aw.m17190ZK();
                intent2.putExtra("CropImage_OutputPath", stringBuilder.append(C18628c.m29088XW()).append("custom_shake_img_filename.jpg").toString());
                C46193a.gkE.mo38894a(intent2, 2, (MMActivity) this, intent);
                AppMethodBeat.m2505o(24841);
                return;
            case 2:
                if (intent == null) {
                    AppMethodBeat.m2505o(24841);
                    return;
                }
                Object stringExtra = intent.getStringExtra("CropImage_OutputPath");
                C9638aw.m17190ZK();
                C18628c.m29072Ry().set(4110, Boolean.FALSE);
                C9638aw.m17190ZK();
                C18628c.m29072Ry().set(4111, stringExtra);
                ckF();
                AppMethodBeat.m2505o(24841);
                return;
            case 30764:
                if (intent != null) {
                    Bundle bundleExtra = intent.getBundleExtra("result_data");
                    if (bundleExtra == null || !bundleExtra.getString("go_next", "").equals("gdpr_auth_location")) {
                        this.gwZ = true;
                        finish();
                        AppMethodBeat.m2505o(24841);
                        return;
                    }
                    C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_GDPR_LOCATION_PERMISSION_DESCRIBE_CONFIRM_BOOLEAN_SYNC, Boolean.TRUE);
                    C35805b.m58709b(this, "android.permission.ACCESS_COARSE_LOCATION", 64);
                    this.gwZ = false;
                    AppMethodBeat.m2505o(24841);
                    return;
                }
                this.gwZ = true;
                finish();
                AppMethodBeat.m2505o(24841);
                return;
            default:
                AppMethodBeat.m2505o(24841);
                return;
        }
    }

    /* renamed from: a */
    public final void mo5248a(String str, C4935m c4935m) {
        AppMethodBeat.m2504i(24842);
        ckI();
        if (!this.quY) {
            m21336ku(true);
        }
        AppMethodBeat.m2505o(24842);
    }

    /* renamed from: a */
    public final void mo10136a(int i, C7298n c7298n, Object obj) {
        AppMethodBeat.m2504i(24843);
        mo5248a("", null);
        AppMethodBeat.m2505o(24843);
    }

    /* renamed from: m */
    public final void mo8136m(String str, Bitmap bitmap) {
        AppMethodBeat.m2504i(24846);
        if (str == null || bitmap == null || bitmap.isRecycled()) {
            AppMethodBeat.m2505o(24846);
            return;
        }
        if (!(this.qvu == null || this.qvu.getTag() == null || !str.equals((String) this.qvu.getTag()))) {
            this.qvu.setImageBitmap(bitmap);
        }
        AppMethodBeat.m2505o(24846);
    }

    public final void ckb() {
        AppMethodBeat.m2504i(24847);
        C28999a.cjM();
        ckJ();
        ckK();
        ckN();
        ckO();
        ckM();
        AppMethodBeat.m2505o(24847);
    }

    private void ckJ() {
        AppMethodBeat.m2504i(24848);
        if (C28999a.cks()) {
            if (C16112c.m24429PK().mo28552bY(262155, 266259)) {
                this.qvH.setVisibility(0);
                AppMethodBeat.m2505o(24848);
                return;
            }
            this.qvH.setVisibility(8);
        }
        AppMethodBeat.m2505o(24848);
    }

    private void ckK() {
        AppMethodBeat.m2504i(24849);
        if (this.qvJ == 6 && C28999a.cks()) {
            boolean bY = C16112c.m24429PK().mo28552bY(262154, 266258);
            boolean bY2 = C16112c.m24429PK().mo28552bY(262155, 266259);
            if (bY) {
                m21317be(C28999a.ckn(), true);
                AppMethodBeat.m2505o(24849);
                return;
            } else if (bY2) {
                m21317be(C28999a.ckp(), true);
                AppMethodBeat.m2505o(24849);
                return;
            } else if (!this.qvX) {
                if (TextUtils.isEmpty(C28999a.ckl())) {
                    m21317be(getString(C25738R.string.eea), true);
                } else {
                    m21317be(C28999a.ckl(), true);
                    AppMethodBeat.m2505o(24849);
                    return;
                }
            }
        }
        AppMethodBeat.m2505o(24849);
    }

    /* renamed from: be */
    private void m21317be(String str, boolean z) {
        AppMethodBeat.m2504i(24850);
        this.quX = false;
        if (this.qvr == null) {
            this.qvr = AnimationUtils.loadAnimation(this.mController.ylL, C25738R.anim.f8327ay);
        }
        m21293CD(2);
        m21339kx(true);
        if (str != null && str.length() > 1) {
            this.qvi.setText(str);
        } else if (z) {
            this.qvi.setText(C25738R.string.eea);
        } else {
            this.qvi.setText("");
            m21339kx(false);
        }
        this.qva = true;
        AppMethodBeat.m2505o(24850);
    }

    private void ckL() {
        AppMethodBeat.m2504i(24851);
        if (this.qvW != null && this.qvW.isShowing()) {
            this.qvW.dismiss();
        }
        this.qvW = null;
        AppMethodBeat.m2505o(24851);
    }

    private void ckM() {
        int intExtra;
        int i;
        int i2 = 1;
        AppMethodBeat.m2504i(24852);
        boolean cjN = C28999a.cjN();
        boolean bY = C16112c.m24429PK().mo28552bY(262154, 266258);
        boolean bY2 = C16112c.m24429PK().mo28552bY(262155, 266259);
        if (getIntent().getBooleanExtra("shake_card", false)) {
            intExtra = getIntent().getIntExtra("shake_card", 0);
        } else {
            intExtra = 0;
        }
        C7060h c7060h = C7060h.pYm;
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
        objArr[4] = C28999a.cko();
        objArr[5] = Integer.valueOf(C28999a.ckk());
        c7060h.mo8381e(11668, objArr);
        C7060h c7060h2 = C7060h.pYm;
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
        objArr2[4] = C28999a.cko();
        objArr2[5] = Integer.valueOf(C28999a.ckk());
        c7060h2.mo8381e(11668, objArr2);
        AppMethodBeat.m2505o(24852);
    }

    private void ckN() {
        AppMethodBeat.m2504i(24853);
        if (!TextUtils.isEmpty(C28999a.ckm())) {
            this.qvI.setText(C28999a.ckm());
        }
        AppMethodBeat.m2505o(24853);
    }

    private void ckO() {
        AppMethodBeat.m2504i(24854);
        if (C25847d.aim()) {
            C4990ab.m7416i("MicroMsg.ShakeReportUI", "is not oversea user, show shake music");
            this.qvY.put(Integer.valueOf(3), Boolean.TRUE);
            findViewById(2131827515).setVisibility(0);
            if (C25847d.ain()) {
                C9638aw.m17190ZK();
                if (C18628c.m29072Ry().getInt(4118, 0) == 0) {
                    this.qvG.setVisibility(0);
                } else {
                    this.qvG.setVisibility(8);
                }
            }
        } else {
            this.qvY.put(Integer.valueOf(3), Boolean.FALSE);
            findViewById(2131827515).setVisibility(8);
            C4990ab.m7416i("MicroMsg.ShakeReportUI", "is oversea user, hide shake music");
        }
        if (C3826k.cjQ()) {
            this.qvY.put(Integer.valueOf(4), Boolean.TRUE);
            findViewById(2131827518).setVisibility(0);
            C4990ab.m7416i("MicroMsg.ShakeReportUI", "show shake tv tab");
        } else {
            this.qvY.put(Integer.valueOf(4), Boolean.FALSE);
            findViewById(2131827518).setVisibility(8);
            C4990ab.m7416i("MicroMsg.ShakeReportUI", "hide shake tv tab");
        }
        if (C28999a.cks()) {
            this.qvY.put(Integer.valueOf(6), Boolean.TRUE);
            findViewById(2131827509).setVisibility(0);
            C4990ab.m7416i("MicroMsg.ShakeReportUI", "show shake card tab");
        } else {
            findViewById(2131827509).setVisibility(8);
            this.qvY.put(Integer.valueOf(6), Boolean.FALSE);
            C4990ab.m7416i("MicroMsg.ShakeReportUI", "hide shake card tab");
        }
        if (ckP()) {
            this.qvY.put(Integer.valueOf(5), Boolean.TRUE);
            this.qvU.setVisibility(0);
            C4990ab.m7416i("MicroMsg.ShakeReportUI", "[shakezb]show shake ibeacon tab");
        } else {
            this.qvY.put(Integer.valueOf(5), Boolean.FALSE);
            this.qvU.setVisibility(8);
            C4990ab.m7416i("MicroMsg.ShakeReportUI", "[shakezb]hide shake ibeacon tab");
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
        LinearLayout linearLayout = (LinearLayout) findViewById(2131827506);
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
                C4990ab.m7416i("MicroMsg.ShakeReportUI", "show tab count is > 4 and beaconMap.size() <= 0.");
            }
            AppMethodBeat.m2505o(24854);
            return;
        }
        findViewById(2131827518).setVisibility(8);
        C4990ab.m7416i("MicroMsg.ShakeReportUI", "show tab count is > 4 and beaconMap.size() > 0.");
        this.qvK--;
        AppMethodBeat.m2505o(24854);
    }

    private boolean ckP() {
        AppMethodBeat.m2504i(24855);
        C4990ab.m7416i("MicroMsg.ShakeReportUI", "[shakezb] isChineseAppLang :" + C4988aa.don() + " ,getApplicationLanguage[en or zh_CN or zh_HK or zh_TW is avaliable] :" + C4988aa.dor());
        if (this.qvZ && ShakeReportUI.ckQ()) {
            AppMethodBeat.m2505o(24855);
            return true;
        }
        AppMethodBeat.m2505o(24855);
        return false;
    }

    private static boolean ckQ() {
        AppMethodBeat.m2504i(24856);
        if (C4988aa.don() || C4988aa.dor().equals("en") || C4988aa.dor().equals("ja")) {
            AppMethodBeat.m2505o(24856);
            return true;
        }
        AppMethodBeat.m2505o(24856);
        return false;
    }

    private void ckR() {
        AppMethodBeat.m2504i(24857);
        this.qvL.setVisibility(8);
        AppMethodBeat.m2505o(24857);
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        AppMethodBeat.m2504i(24858);
        if (iArr == null || iArr.length <= 0) {
            C4990ab.m7417i("MicroMsg.ShakeReportUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", Integer.valueOf(i), Long.valueOf(Thread.currentThread().getId()));
            AppMethodBeat.m2505o(24858);
            return;
        }
        C4990ab.m7417i("MicroMsg.ShakeReportUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId()));
        switch (i) {
            case 64:
                if (iArr[0] != 0) {
                    this.gwZ = false;
                    C30379h.m48445a((Context) this, getString(C25738R.string.dby), getString(C25738R.string.dc8), getString(C25738R.string.ckr), getString(C25738R.string.abx), false, new C1329021(), new C1329123());
                    break;
                }
                cdJ();
                AppMethodBeat.m2505o(24858);
                return;
            case 80:
                if (iArr[0] != 0) {
                    C30379h.m48445a((Context) this, getString(C25738R.string.dc0), getString(C25738R.string.dc8), getString(C25738R.string.ckr), getString(C25738R.string.abx), false, new C1327419(), new C1328520());
                    AppMethodBeat.m2505o(24858);
                    return;
                }
                break;
        }
        AppMethodBeat.m2505o(24858);
    }

    /* renamed from: c */
    private void m21319c(C34894d c34894d) {
        AppMethodBeat.m2504i(24844);
        if (C5046bo.isNullOrNil(c34894d.field_username)) {
            AppMethodBeat.m2505o(24844);
            return;
        }
        String string;
        this.qvf.setTag(c34894d.field_username);
        this.qvf.setVisibility(0);
        C9638aw.m17190ZK();
        C7616ad aoO = C18628c.m29078XM().aoO(c34894d.field_username);
        StringBuilder append = new StringBuilder().append(c34894d.field_nickname);
        if (C7486a.m12942jh(aoO.field_type)) {
            string = getString(C25738R.string.efa);
        } else {
            string = "";
        }
        String stringBuilder = append.append(string).toString();
        if (c34894d.field_sex == 1) {
            this.qvf.setContentDescription(stringBuilder + c34894d.field_distance + this.mController.ylL.getString(C25738R.string.eg3));
        } else if (c34894d.field_sex == 2) {
            this.qvf.setContentDescription(stringBuilder + c34894d.field_distance + this.mController.ylL.getString(C25738R.string.eg2));
        } else {
            this.qvf.setContentDescription(stringBuilder + c34894d.field_distance);
        }
        TextView textView = (TextView) this.qvf.findViewById(2131827502);
        textView.setText(C44089j.m79293b(this.mController.ylL, c34894d.field_nickname + (C7486a.m12942jh(aoO.field_type) ? getString(C25738R.string.efa) : ""), textView.getTextSize()));
        if (this.eks != null) {
            if (C5046bo.isNullOrNil(stringBuilder)) {
                this.eks.setContentDescription(getString(C25738R.string.ee4));
            } else {
                this.eks.setContentDescription(String.format(getString(C25738R.string.ee3), new Object[]{stringBuilder}));
            }
        }
        ((TextView) this.qvf.findViewById(2131827505)).setText(c34894d.field_distance);
        C40460b.m69434b((ImageView) this.qvf.findViewById(2131827501), c34894d.field_username);
        ImageView imageView = (ImageView) this.qvf.findViewById(2131827504);
        if (c34894d.field_reserved1 != 0) {
            imageView.setVisibility(0);
            imageView.setImageBitmap(C4977b.m7374i(C26417a.flw.mo37872ky(c34894d.field_reserved1), 2.0f));
        } else {
            imageView.setVisibility(8);
        }
        if (c34894d.field_reserved1 != 0 || c34894d.field_sex == 0) {
            this.qvf.findViewById(2131827503).setVisibility(8);
        } else {
            Drawable g = C1338a.m2864g(this, c34894d.field_sex == 1 ? C1318a.ic_sex_male : C1318a.ic_sex_female);
            this.qvf.findViewById(2131827503).setVisibility(0);
            ((ImageView) this.qvf.findViewById(2131827503)).setImageDrawable(g);
        }
        if (c34894d.getProvince() == null) {
            C4990ab.m7412e("MicroMsg.ShakeReportUI", "PROVINCE NULL");
            c34894d.field_province = "";
        }
        if (c34894d.getCity() == null) {
            C4990ab.m7412e("MicroMsg.ShakeReportUI", "CITY NULL");
            c34894d.field_city = "";
        }
        this.qvf.startAnimation(AnimationUtils.loadAnimation(this.mController.ylL, C25738R.anim.f8394d1));
        AppMethodBeat.m2505o(24844);
    }

    /* renamed from: d */
    private void m21321d(C34894d c34894d) {
        AppMethodBeat.m2504i(24845);
        if (C5046bo.isNullOrNil(c34894d.field_username)) {
            AppMethodBeat.m2505o(24845);
            return;
        }
        this.qvf.setTag(c34894d.field_username);
        ((TextView) this.qvf.findViewById(2131827502)).setText(c34894d.field_username);
        this.qvf.setContentDescription(C5046bo.nullAsNil(c34894d.field_nickname));
        ((TextView) this.qvf.findViewById(2131827505)).setText(c34894d.field_signature);
        this.fGv.mo43765a(c34894d.getProvince(), (ImageView) this.qvf.findViewById(2131827501));
        this.qvf.findViewById(2131827503).setVisibility(8);
        this.qvf.startAnimation(AnimationUtils.loadAnimation(this.mController.ylL, C25738R.anim.f8394d1));
        this.qvf.setVisibility(0);
        AppMethodBeat.m2505o(24845);
    }

    /* renamed from: j */
    static /* synthetic */ void m21333j(ShakeReportUI shakeReportUI) {
        AppMethodBeat.m2504i(24859);
        if (ShakeReportUI.ckQ()) {
            ViewGroup viewGroup = (ViewGroup) shakeReportUI.findViewById(2131827506);
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
                    shakeReportUI.findViewById(2131827520).setAnimation(animationSet);
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
                    shakeReportUI.findViewById(2131827507).setAnimation(animationSet2);
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
                shakeReportUI.m21337kv(false);
            }
        }
        AppMethodBeat.m2505o(24859);
    }

    /* renamed from: A */
    static /* synthetic */ void m21290A(ShakeReportUI shakeReportUI) {
        AppMethodBeat.m2504i(24865);
        if (shakeReportUI.qvk == null) {
            shakeReportUI.qvk = shakeReportUI.findViewById(2131827489);
        }
        if (shakeReportUI.qvl == null) {
            shakeReportUI.qvl = shakeReportUI.findViewById(2131827492);
        }
        if (shakeReportUI.qvm == null) {
            shakeReportUI.qvm = shakeReportUI.findViewById(2131827498);
        }
        if (shakeReportUI.qvn == null) {
            shakeReportUI.qvn = shakeReportUI.findViewById(2131827491);
        }
        if (shakeReportUI.qvo == null) {
            shakeReportUI.qvo = AnimationUtils.loadAnimation(shakeReportUI.mController.ylL, C25738R.anim.f8417dy);
            shakeReportUI.qvo.setAnimationListener(new C1328810());
        }
        if (shakeReportUI.qvp == null) {
            shakeReportUI.qvp = AnimationUtils.loadAnimation(shakeReportUI.mController.ylL, C25738R.anim.f8415dw);
        }
        if (shakeReportUI.qvq == null) {
            shakeReportUI.qvq = AnimationUtils.loadAnimation(shakeReportUI.mController.ylL, C25738R.anim.f8391cy);
        }
        if (!(shakeReportUI.qvr == null || shakeReportUI.qvi == null)) {
            C4976a.m7369a(shakeReportUI.qvi, shakeReportUI.qvr);
        }
        shakeReportUI.m21293CD(3);
        shakeReportUI.qvm.startAnimation(shakeReportUI.qvq);
        shakeReportUI.qvn.startAnimation(shakeReportUI.qvq);
        shakeReportUI.qvm.setVisibility(0);
        shakeReportUI.qvn.setVisibility(0);
        shakeReportUI.qvh.setVisibility(4);
        shakeReportUI.qvk.startAnimation(shakeReportUI.qvo);
        shakeReportUI.qvl.startAnimation(shakeReportUI.qvp);
        if (shakeReportUI.qvf != null && shakeReportUI.qvf.getVisibility() == 0) {
            Animation loadAnimation = AnimationUtils.loadAnimation(shakeReportUI.mController.ylL, C25738R.anim.f8395d2);
            loadAnimation.setFillAfter(true);
            shakeReportUI.qvf.startAnimation(loadAnimation);
            new C7306ak().postDelayed(new C383911(), loadAnimation.getDuration());
        }
        shakeReportUI.qva = false;
        new C7306ak().postDelayed(new C384113(), 1200);
        AppMethodBeat.m2505o(24865);
    }
}
