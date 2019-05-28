package com.tencent.p177mm.plugin.voip_cs.p547b.p548a;

import android.content.SharedPreferences;
import android.graphics.Point;
import android.graphics.SurfaceTexture;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Looper;
import android.os.Message;
import android.view.TextureView.SurfaceTextureListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.plugin.messenger.p993a.C12518f;
import com.tencent.p177mm.plugin.video.ObservableTextureView;
import com.tencent.p177mm.plugin.voip.model.C35355p;
import com.tencent.p177mm.plugin.voip.model.C35355p.C35357a;
import com.tencent.p177mm.plugin.voip.p1417a.C29488d;
import com.tencent.p177mm.plugin.voip.p546ui.VoipBigIconButton;
import com.tencent.p177mm.plugin.voip.video.C14088g;
import com.tencent.p177mm.plugin.voip.video.MovableVideoView;
import com.tencent.p177mm.plugin.voip.video.OpenGlRender;
import com.tencent.p177mm.plugin.voip.video.OpenGlView;
import com.tencent.p177mm.plugin.voip_cs.p547b.C43746a;
import com.tencent.p177mm.plugin.voip_cs.p547b.C43749c;
import com.tencent.p177mm.plugin.voip_cs.p547b.C43750d;
import com.tencent.p177mm.plugin.voip_cs.p549ui.VoipCSMainUI;
import com.tencent.p177mm.plugin.voip_cs.p747c.C29524c;
import com.tencent.p177mm.plugin.voip_cs.p747c.C43751b;
import com.tencent.p177mm.plugin.voip_cs.p747c.C46929a;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.BackwardSupportUtil.C4977b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.sdk.platformtools.C7564ap;
import com.tencent.p177mm.sdk.platformtools.C7564ap.C5015a;
import com.tencent.ttpic.thread.FaceGestureDetGLThread;
import java.io.InputStream;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Timer;
import java.util.TimerTask;

/* renamed from: com.tencent.mm.plugin.voip_cs.b.a.b */
public final class C44768b implements SurfaceTextureListener, OnClickListener, C35357a, C14088g {
    protected static int mScreenHeight;
    protected static int mScreenWidth;
    protected static final int[] sWo = new int[]{-1, C25738R.string.f57, C25738R.string.f5b, C25738R.string.f5a};
    public boolean cAY = false;
    public TextView ejp;
    private TextView enf;
    private C7306ak fbD;
    private Timer oGr;
    private View oIL;
    private ObservableTextureView oIY;
    private ImageButton oIs;
    private OpenGlView sWS;
    private OpenGlView sWT;
    public OpenGlRender sWU;
    public OpenGlRender sWV;
    private boolean sXI = false;
    private VoipBigIconButton sXq;
    private OnClickListener sYk = new C353853();
    public VoipCSMainUI tdU;
    private RelativeLayout tdV;
    private TextView tdW;
    private TextView tdX;
    private TextView tdY;
    private TextView tdZ;
    public ImageView tea;
    private C7306ak teb;
    private C46929a tec;
    private boolean ted = false;
    protected long tee = -1;
    private boolean tef = false;
    private boolean teg = false;
    private int teh = 60000;
    private int tei = 5000;
    private C43751b tej = new C43751b();
    public String tek = "";
    public String tel = "";
    private C7564ap tem = new C7564ap(Looper.getMainLooper(), new C353841(), false);
    private C7564ap ten = new C7564ap(Looper.getMainLooper(), new C400442(), false);
    C14095a teo = new C14095a(this, (byte) 0);
    C29521c tep;
    C29520b teq;
    String ter = "";
    Drawable tes = null;

    /* renamed from: com.tencent.mm.plugin.voip_cs.b.a.b$6 */
    class C140936 implements Runnable {
        C140936() {
        }

        public final void run() {
            AppMethodBeat.m2504i(135323);
            C4990ab.m7416i("MicroMsg.voipcs.VoipCSViewManager", "dismiss button");
            if (C44768b.this.tdU.isFinishing()) {
                AppMethodBeat.m2505o(135323);
                return;
            }
            C44768b.this.oIs.setVisibility(8);
            C44768b.this.enf.setVisibility(8);
            C44768b.this.tdW.setVisibility(8);
            C44768b.m81703n(C44768b.this);
            C44768b.m81704o(C44768b.this);
            AppMethodBeat.m2505o(135323);
        }
    }

    /* renamed from: com.tencent.mm.plugin.voip_cs.b.a.b$8 */
    class C140948 implements Runnable {
        C140948() {
        }

        public final void run() {
            AppMethodBeat.m2504i(135326);
            C43744a cMn = C43744a.cMn();
            if (cMn.sTj != null) {
                cMn.sTj.mo38020Gx(0);
            }
            AppMethodBeat.m2505o(135326);
        }
    }

    /* renamed from: com.tencent.mm.plugin.voip_cs.b.a.b$a */
    class C14095a {
        /* renamed from: h */
        int f2949h;
        int[] oHc;
        /* renamed from: w */
        int f2950w;

        private C14095a() {
        }

        /* synthetic */ C14095a(C44768b c44768b, byte b) {
            this();
        }
    }

    /* renamed from: com.tencent.mm.plugin.voip_cs.b.a.b$5 */
    class C295185 implements OnClickListener {
        C295185() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(135322);
            C44768b.this.sXI = !C44768b.this.sXI;
            Point b = C44768b.m81686b(C44768b.this, C44768b.this.sXI);
            C44768b.this.sWT.mo26412gc(b.x, b.y);
            AppMethodBeat.m2505o(135322);
        }
    }

    /* renamed from: com.tencent.mm.plugin.voip_cs.b.a.b$7 */
    class C295197 extends TimerTask {

        /* renamed from: com.tencent.mm.plugin.voip_cs.b.a.b$7$1 */
        class C43041 implements Runnable {
            C43041() {
            }

            public final void run() {
                AppMethodBeat.m2504i(135324);
                C44768b.this.enf.setText(C44768b.m81692fQ(C5046bo.m7549fp(C44768b.this.tee)));
                AppMethodBeat.m2505o(135324);
            }
        }

        C295197() {
        }

        public final void run() {
            AppMethodBeat.m2504i(135325);
            C44768b.this.fbD.post(new C43041());
            AppMethodBeat.m2505o(135325);
        }
    }

    /* renamed from: com.tencent.mm.plugin.voip_cs.b.a.b$b */
    class C29520b implements Runnable {
        C29520b() {
        }

        public final void run() {
            AppMethodBeat.m2504i(135328);
            C44768b.this.tes = C44768b.acf(C44768b.this.ter);
            Message message = new Message();
            message.what = 12;
            C44768b.this.teb.sendMessage(message);
            C7305d.xDG.remove(C44768b.this.teq);
            AppMethodBeat.m2505o(135328);
        }
    }

    /* renamed from: com.tencent.mm.plugin.voip_cs.b.a.b$c */
    class C29521c implements Runnable {
        boolean sQd = false;

        C29521c() {
        }

        public final void run() {
            AppMethodBeat.m2504i(135329);
            while (!this.sQd && !C44768b.this.cAY) {
                if (C43749c.cMe().tew.videoDecode(C43749c.cMe().tew.sUU) == 1) {
                    int i = C43749c.cMe().tew.field_remoteImgWidth;
                    int i2 = C43749c.cMe().tew.field_remoteImgHeight;
                    if (OpenGlRender.taQ == 1) {
                        if (C44768b.this.sXI) {
                            C44768b.this.sWV.mo63360a(C43749c.cMe().tew.sUU, i, i2, OpenGlRender.FLAG_RGBA + OpenGlRender.FLAG_Angle90, false);
                        } else {
                            C44768b.this.sWU.mo63360a(C43749c.cMe().tew.sUU, i, i2, OpenGlRender.FLAG_RGBA + OpenGlRender.FLAG_Angle90, false);
                        }
                    } else if (C44768b.this.sXI) {
                        C44768b.this.sWV.mo63360a(C43749c.cMe().tew.sUU, i, i2, OpenGlRender.FLAG_YV12Edge + OpenGlRender.FLAG_Angle90, false);
                    } else {
                        C44768b.this.sWU.mo63360a(C43749c.cMe().tew.sUU, i, i2, OpenGlRender.FLAG_YV12Edge + OpenGlRender.FLAG_Angle90, false);
                    }
                }
                try {
                    Thread.sleep(20);
                } catch (InterruptedException e) {
                    C4990ab.printErrStackTrace("MicroMsg.voipcs.VoipCSViewManager", e, "", new Object[0]);
                }
            }
            AppMethodBeat.m2505o(135329);
        }
    }

    /* renamed from: com.tencent.mm.plugin.voip_cs.b.a.b$1 */
    class C353841 implements C5015a {
        C353841() {
        }

        /* renamed from: BI */
        public final boolean mo4499BI() {
            AppMethodBeat.m2504i(135318);
            C4990ab.m7416i("MicroMsg.voipcs.VoipCSViewManager", "voipcs invite time out!opposite not responese");
            C43749c.cMg().dataType = 1;
            C44768b.this.mo71848GY(6);
            AppMethodBeat.m2505o(135318);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.voip_cs.b.a.b$3 */
    class C353853 implements OnClickListener {
        C353853() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(135320);
            C4990ab.m7416i("MicroMsg.voipcs.VoipCSViewManager", "switch camera");
            C44768b.this.sXq.setEnabled(false);
            if (C43749c.cMf().tdM > 1) {
                C44768b.m81690e(C44768b.this);
            }
            C44768b.this.sXq.setEnabled(true);
            if (C44768b.this.tec != null) {
                C44768b.this.tec.cLB();
            }
            AppMethodBeat.m2505o(135320);
        }
    }

    /* renamed from: com.tencent.mm.plugin.voip_cs.b.a.b$4 */
    class C353864 extends C7306ak {
        C353864() {
        }

        public final void handleMessage(Message message) {
            AppMethodBeat.m2504i(135321);
            switch (message.what) {
                case 12:
                    if (C44768b.this.tes == null) {
                        C44768b.this.tea.setImageResource(C25738R.drawable.ad2);
                        break;
                    }
                    C44768b.this.tea.setImageDrawable(C44768b.this.tes);
                    AppMethodBeat.m2505o(135321);
                    return;
            }
            AppMethodBeat.m2505o(135321);
        }
    }

    /* renamed from: com.tencent.mm.plugin.voip_cs.b.a.b$2 */
    class C400442 implements C5015a {
        C400442() {
        }

        /* renamed from: BI */
        public final boolean mo4499BI() {
            AppMethodBeat.m2504i(135319);
            C44768b.this.tdX.setText(C4996ah.getContext().getString(C25738R.string.f5d));
            C44768b.this.tdY.setVisibility(0);
            C43751b c = C44768b.this.tej;
            TextView b = C44768b.this.tdY;
            int[] iArr = C44768b.sWo;
            if (iArr == null || b == null) {
                C4990ab.m7412e("MicroMsg.DynamicTextWrap", "textList or tv is null");
            } else {
                c.cLc();
                c.sWE = 0;
                c.sWC = iArr;
                c.f17227sW = b;
                c.sWD = 500;
                if (c.gyS != null) {
                    long j = (long) c.sWD;
                    c.gyS.mo16770ae(j, j);
                }
                C4990ab.m7408b("MicroMsg.DynamicTextWrap", "start textview:".concat(String.valueOf(b)), new Object[0]);
            }
            AppMethodBeat.m2505o(135319);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.voip_cs.b.a.b$9 */
    class C447699 implements Runnable {
        C447699() {
        }

        public final void run() {
            AppMethodBeat.m2504i(135327);
            C44768b.this.tdU.finish();
            AppMethodBeat.m2505o(135327);
        }
    }

    /* renamed from: b */
    static /* synthetic */ Point m81686b(C44768b c44768b, boolean z) {
        AppMethodBeat.m2504i(135357);
        Point mA = c44768b.m81700mA(z);
        AppMethodBeat.m2505o(135357);
        return mA;
    }

    /* renamed from: e */
    static /* synthetic */ void m81690e(C44768b c44768b) {
        AppMethodBeat.m2504i(135356);
        c44768b.cMv();
        AppMethodBeat.m2505o(135356);
    }

    /* renamed from: n */
    static /* synthetic */ void m81703n(C44768b c44768b) {
        AppMethodBeat.m2504i(135358);
        c44768b.m81682GX(8);
        AppMethodBeat.m2505o(135358);
    }

    /* renamed from: o */
    static /* synthetic */ void m81704o(C44768b c44768b) {
        AppMethodBeat.m2504i(135359);
        c44768b.m81701mG(false);
        AppMethodBeat.m2505o(135359);
    }

    public C44768b(VoipCSMainUI voipCSMainUI) {
        AppMethodBeat.m2504i(135330);
        this.tdU = voipCSMainUI;
        WindowManager windowManager = (WindowManager) voipCSMainUI.getSystemService("window");
        int height = windowManager.getDefaultDisplay().getHeight() / 5;
        int width = (windowManager.getDefaultDisplay().getWidth() * height) / windowManager.getDefaultDisplay().getHeight();
        if (Build.MANUFACTURER.equalsIgnoreCase("meizu")) {
            ((RelativeLayout) voipCSMainUI.findViewById(2131828499)).setPadding(0, 0, 0, C4977b.m7371b(voipCSMainUI.mController.ylL, 40.0f));
        }
        this.sWT = new MovableVideoView(voipCSMainUI.getApplicationContext());
        ((MovableVideoView) this.sWT).mo26410ga(width, height);
        this.sWT.setVisibility(8);
        this.sWU = new OpenGlRender(this.sWT, OpenGlRender.RenderRemote);
        this.sWT.setRenderer(this.sWU);
        this.sWT.setRenderMode(0);
        if (Build.MODEL.equals("Nexus 6")) {
            this.sWT.setZOrderOnTop(true);
        } else {
            this.sWT.setZOrderMediaOverlay(true);
        }
        this.enf = (TextView) voipCSMainUI.findViewById(2131820988);
        this.enf.setVisibility(0);
        this.oGr = new Timer("voip_cs_talking_time");
        this.tdW = (TextView) voipCSMainUI.findViewById(2131828502);
        this.tdW.setVisibility(0);
        this.tdX = (TextView) voipCSMainUI.findViewById(2131828496);
        if (voipCSMainUI.cQL.equals("1")) {
            if (voipCSMainUI.type.equals("video")) {
                this.tdX.setText(C4996ah.getContext().getString(C25738R.string.f4q));
            } else {
                this.tdX.setText(C4996ah.getContext().getString(C25738R.string.f4r));
            }
        } else if (voipCSMainUI.type.equals("video")) {
            this.tdX.setText(C4996ah.getContext().getString(C25738R.string.f4s));
        } else {
            this.tdX.setText(C4996ah.getContext().getString(C25738R.string.f4r));
        }
        this.tdX.setVisibility(0);
        this.ejp = (TextView) voipCSMainUI.findViewById(2131828494);
        this.ejp.setVisibility(0);
        this.tea = (ImageView) voipCSMainUI.findViewById(2131828493);
        this.tea.setVisibility(0);
        this.tdZ = (TextView) voipCSMainUI.findViewById(2131828503);
        this.tdY = (TextView) voipCSMainUI.findViewById(2131828497);
        this.sXq = (VoipBigIconButton) voipCSMainUI.findViewById(2131828501);
        if (voipCSMainUI.teD == null || !voipCSMainUI.teD.equals("1")) {
            this.sXq.setVisibility(8);
        } else {
            this.sXq.setVisibility(0);
            this.sXq.setOnClickListener(this.sYk);
        }
        this.fbD = new C7306ak();
        this.teb = new C353864();
        this.oIL = voipCSMainUI.findViewById(2131828491);
        this.oIs = (ImageButton) voipCSMainUI.findViewById(2131828500);
        this.tdV = (RelativeLayout) voipCSMainUI.findViewById(2131828491);
        mScreenWidth = C1338a.m2868gd(voipCSMainUI.mController.ylL);
        mScreenHeight = C29524c.m46872fj(voipCSMainUI.mController.ylL);
        this.sWS = (OpenGlView) voipCSMainUI.findViewById(2131828492);
        this.sWS.mo26411gb(mScreenWidth, mScreenHeight);
        this.sWV = new OpenGlRender(this.sWS, OpenGlRender.RenderLocal);
        this.sWS.setRenderer(this.sWV);
        this.sWS.setRenderMode(0);
        this.sWS.setVisibility(0);
        C4990ab.m7417i("MicroMsg.voipcs.VoipCSViewManager", "mScreenHeight %d", Integer.valueOf(mScreenHeight));
        this.oIs.setOnClickListener(this);
        this.tdV.addView(this.sWT);
        this.sWT.setOnClickListener(new C295185());
        this.sWU.taA = true;
        this.sWV.taA = true;
        if (!C29488d.m46801fd(C4996ah.getContext())) {
            C29488d.m46802fe(C4996ah.getContext());
        }
        SharedPreferences doB = C4996ah.doB();
        this.tek = doB.getString(cMr(), "");
        if (this.tdU.gEl != null && !this.tdU.gEl.equals("")) {
            ace(this.tdU.gEl);
        } else if (!C5046bo.isNullOrNil(this.tek)) {
            ace(this.tek);
        }
        this.tel = doB.getString(cMs(), "");
        if (!C5046bo.isNullOrNil(this.tel)) {
            acd(this.tel);
        }
        C1202f cMf = C43749c.cMf();
        String str = this.tdU.tdN;
        C4990ab.m7410d("MicroMsg.voipcs.VoipCSService", "start getBizInfo for username:".concat(String.valueOf(str)));
        C1720g.m3540Rg().mo14539a(106, cMf);
        C1720g.m3540Rg().mo14541a(new C12518f(str), 0);
        AppMethodBeat.m2505o(135330);
    }

    public final void cMp() {
        AppMethodBeat.m2504i(135331);
        if (this.tem.doT()) {
            long j = (long) this.teh;
            this.tem.mo16770ae(j, j);
        }
        AppMethodBeat.m2505o(135331);
    }

    public final void cMq() {
        AppMethodBeat.m2504i(135332);
        if (this.ten.doT()) {
            long j = (long) this.tei;
            this.ten.mo16770ae(j, j);
        }
        AppMethodBeat.m2505o(135332);
    }

    public final void acd(String str) {
        CharSequence charSequence;
        AppMethodBeat.m2504i(135333);
        if (this.tdU.teG) {
            charSequence = str + C4996ah.getContext().getString(C25738R.string.f4h);
        } else {
            charSequence = str + C4996ah.getContext().getString(C25738R.string.f4i);
        }
        this.ejp.setText(charSequence);
        AppMethodBeat.m2505o(135333);
    }

    public final void ace(String str) {
        AppMethodBeat.m2504i(135334);
        if (!C5046bo.isNullOrNil(str)) {
            this.teq = new C29520b();
            if (this.tdU.gEl == null || this.tdU.gEl.equals("")) {
                this.ter = str;
            } else {
                this.ter = this.tdU.gEl;
            }
            C7305d.m12298f(this.teq, "VOIPCS_netPic");
        }
        AppMethodBeat.m2505o(135334);
    }

    public final String cMr() {
        AppMethodBeat.m2504i(135335);
        String str = "voip_cs_headImageUrl_" + this.tdU.tdN;
        AppMethodBeat.m2505o(135335);
        return str;
    }

    public final String cMs() {
        AppMethodBeat.m2504i(135336);
        String str = "voip_cs_nickname_" + this.tdU.tdN;
        AppMethodBeat.m2505o(135336);
        return str;
    }

    /* renamed from: mA */
    private Point m81700mA(boolean z) {
        AppMethodBeat.m2504i(135337);
        int height = ((WindowManager) this.tdU.getSystemService("window")).getDefaultDisplay().getHeight() / 5;
        Point point = new Point((int) (C44768b.m81702mw(!z) * ((float) height)), height);
        AppMethodBeat.m2505o(135337);
        return point;
    }

    /* renamed from: mw */
    private static float m81702mw(boolean z) {
        byte[] bArr;
        AppMethodBeat.m2504i(135338);
        float f = 0.74766356f;
        if (z) {
            try {
                bArr = C43749c.cMe().tew.field_capInfo;
            } catch (Exception e) {
                C4990ab.m7412e("MicroMsg.voipcs.VoipCSViewManager", "update failed: " + e.getMessage());
            }
        } else {
            bArr = C43749c.cMe().tew.sUb;
        }
        if (bArr != null) {
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            if (wrap.getInt() > CdnLogic.kBizGeneric) {
                wrap.order(ByteOrder.LITTLE_ENDIAN);
            }
            wrap.getShort();
            wrap.getShort();
            float f2 = ((float) wrap.getInt()) / 100.0f;
            if (f2 != 0.0f) {
                f = f2;
            }
            C4990ab.m7411d("MicroMsg.voipcs.VoipCSViewManager", "use rate: %s, changed: %s", Float.valueOf(f), Boolean.valueOf(z));
        }
        AppMethodBeat.m2505o(135338);
        return f;
    }

    public final void onClick(View view) {
        boolean z = false;
        AppMethodBeat.m2504i(135339);
        if (view.getId() == 2131828500) {
            if (C43749c.cMf().tdM < 2) {
                C43749c.cMg().dataType = 2;
            } else {
                C43749c.cMg().dataType = 4;
            }
            C43750d cMg = C43749c.cMg();
            cMg.tcP = 1;
            cMg.tdm = 1;
            cMg.tcQ = (int) (System.currentTimeMillis() / 1000);
            cMg = C43749c.cMg();
            C4990ab.m7410d("MicroMsg.VoipCSReportHelper", "selfCancel");
            if (cMg.tdj == 0) {
                cMg.tde = 3;
                if (cMg.tdn == 0 && cMg.tdz != 0) {
                    cMg.tdn = (long) (((int) (System.currentTimeMillis() / 1000)) - cMg.tdz);
                }
            }
            C43749c.cMg().cMh();
            C4990ab.m7410d("MicroMsg.voipcs.VoipCSViewManager", "user click hangup button!");
            mo71848GY(0);
            AppMethodBeat.m2505o(135339);
            return;
        }
        int i = this.oIs.getVisibility() == 0 ? 8 : 0;
        this.oIs.setVisibility(i);
        this.enf.setVisibility(i);
        this.tdW.setVisibility(i);
        m81682GX(i);
        if (i == 0) {
            z = true;
        }
        m81701mG(z);
        AppMethodBeat.m2505o(135339);
    }

    /* renamed from: GX */
    private void m81682GX(int i) {
        AppMethodBeat.m2504i(135340);
        if (this.tdU.teD == null || !this.tdU.teD.equals("1")) {
            this.sXq.setVisibility(8);
            AppMethodBeat.m2505o(135340);
            return;
        }
        this.sXq.setVisibility(i);
        AppMethodBeat.m2505o(135340);
    }

    public final void cMt() {
        AppMethodBeat.m2504i(135341);
        C4990ab.m7416i("MicroMsg.voipcs.VoipCSViewManager", "start capture render");
        if (this.oIY == null) {
            C4990ab.m7416i("MicroMsg.voipcs.VoipCSViewManager", "create capture View");
            this.oIY = new ObservableTextureView(this.tdU);
            this.oIY.setLayoutParams(new LayoutParams(1, 1));
            this.tdV.addView(this.oIY, new LayoutParams(1, 1));
            this.oIY.setVisibility(0);
        }
        if (this.tec == null) {
            int i = 320;
            int i2 = 240;
            C43749c.cMe();
            if (C43746a.sTV) {
                i = 640;
                i2 = 480;
            }
            C4990ab.m7416i("MicroMsg.voipcs.VoipCSViewManager", "create capture Render");
            this.tec = new C46929a(i, i2);
            this.tec.mo74532a((C14088g) this, true);
            this.tec.mo74534a(this.oIY);
            C43749c.cMe().tew.sUm = this.tec.cLG();
            this.tec.cLC();
            this.tec.cMB();
            C4990ab.m7417i("MicroMsg.voipcs.VoipCSViewManager", "captureRender.mIsCurrentFaceCamera=%b captureRender.mIsCameraRemote180=%b", Boolean.valueOf(this.tec.cLE()), Boolean.valueOf(this.tec.cLF()));
        }
        AppMethodBeat.m2505o(135341);
    }

    public final void cMu() {
        AppMethodBeat.m2504i(135342);
        C4990ab.m7416i("MicroMsg.voipcs.VoipCSViewManager", "stop capture render");
        if (this.oIY != null) {
            this.tdV.removeView(this.oIY);
            this.oIY = null;
        }
        if (this.tec != null) {
            this.tec.cLD();
            this.tec = null;
        }
        AppMethodBeat.m2505o(135342);
    }

    private void cMv() {
        AppMethodBeat.m2504i(135343);
        C4990ab.m7416i("MicroMsg.voipcs.VoipCSViewManager", "trigger dismiss button");
        this.fbD.postDelayed(new C140936(), 10000);
        AppMethodBeat.m2505o(135343);
    }

    /* renamed from: mG */
    private void m81701mG(boolean z) {
        AppMethodBeat.m2504i(135344);
        if (Build.MANUFACTURER.equalsIgnoreCase("sony")) {
            C4990ab.m7416i("MicroMsg.voipcs.VoipCSViewManager", "sony is not compatible,so we return.");
            AppMethodBeat.m2505o(135344);
        } else if (z) {
            this.tdU.getWindow().clearFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
            AppMethodBeat.m2505o(135344);
        } else {
            this.tdU.getWindow().setFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
            AppMethodBeat.m2505o(135344);
        }
    }

    public final void bGQ() {
        AppMethodBeat.m2504i(135345);
        this.tem.stopTimer();
        this.ten.stopTimer();
        this.tej.cLc();
        this.tdY.setVisibility(8);
        this.tdX.setText(C25738R.string.f5_);
        this.tdW.setText(C25738R.string.f4y);
        m81682GX(0);
        this.oIL.setOnClickListener(this);
        if (this.tdU.teE != null && this.tdU.teE.equals("1")) {
            this.sWT.setVisibility(0);
            this.sXI = true;
            Point mA = m81700mA(this.sXI);
            ((MovableVideoView) this.sWT).mo26410ga(mA.x, mA.y);
            cMw();
        }
        cMv();
        this.tef = true;
        if (this.oGr == null) {
            this.oGr = new Timer("voip_cs_talking_time");
        }
        if (this.ted) {
            AppMethodBeat.m2505o(135345);
            return;
        }
        if (this.tee == -1) {
            this.tee = C5046bo.anT();
        }
        this.ted = true;
        this.oGr.schedule(new C295197(), 1000, 1000);
        C35355p.cJR().cJS();
        C35355p.cJR().mo56094a(this);
        AppMethodBeat.m2505o(135345);
    }

    public static Drawable acf(String str) {
        AppMethodBeat.m2504i(135346);
        try {
            Drawable createFromStream = Drawable.createFromStream((InputStream) new URL(str).getContent(), "urlDrawable");
            AppMethodBeat.m2505o(135346);
            return createFromStream;
        } catch (Exception e) {
            C4990ab.m7412e("MicroMsg.voipcs.VoipCSViewManager", "parse Drawable faill!");
            AppMethodBeat.m2505o(135346);
            return null;
        }
    }

    /* renamed from: fQ */
    protected static String m81692fQ(long j) {
        AppMethodBeat.m2504i(135347);
        String format = String.format("%02d:%02d", new Object[]{Long.valueOf(j / 60), Long.valueOf(j % 60)});
        AppMethodBeat.m2505o(135347);
        return format;
    }

    /* renamed from: GY */
    public final void mo71848GY(int i) {
        AppMethodBeat.m2504i(135348);
        C4990ab.m7416i("MicroMsg.voipcs.VoipCSViewManager", "onRefreshed for action:".concat(String.valueOf(i)));
        if (this.oGr != null) {
            this.oGr.cancel();
            this.oGr = null;
        }
        if (!this.tem.doT()) {
            this.tem.stopTimer();
        }
        if (!this.ten.doT()) {
            this.ten.stopTimer();
        }
        this.tej.cLc();
        this.ted = false;
        this.tdZ.setVisibility(0);
        this.tdZ.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
        this.tdZ.setBackgroundResource(C25738R.drawable.bjm);
        this.tdZ.setCompoundDrawables(null, null, null, null);
        this.tdZ.setCompoundDrawablePadding(0);
        this.tdZ.setText(C44768b.m81683GZ(i));
        if (C43749c.cMf().tdM == 2) {
            C7305d.post(new C140948(), "VoipCS_play_end_sound");
        }
        this.fbD.postDelayed(new C447699(), FaceGestureDetGLThread.BRIGHTNESS_DURATION);
        AppMethodBeat.m2505o(135348);
    }

    /* renamed from: GZ */
    private static int m81683GZ(int i) {
        AppMethodBeat.m2504i(135349);
        if (i == 1) {
            AppMethodBeat.m2505o(135349);
            return C25738R.string.f4n;
        } else if (i == 0) {
            AppMethodBeat.m2505o(135349);
            return C25738R.string.f4u;
        } else if (i == -1 || i == 5) {
            AppMethodBeat.m2505o(135349);
            return C25738R.string.f55;
        } else if (i == 403 || i == 404) {
            AppMethodBeat.m2505o(135349);
            return C25738R.string.f5c;
        } else if (i == 6) {
            AppMethodBeat.m2505o(135349);
            return C25738R.string.f58;
        } else if (i == 1001) {
            AppMethodBeat.m2505o(135349);
            return C25738R.string.f54;
        } else if (i == 10) {
            AppMethodBeat.m2505o(135349);
            return C25738R.string.f4t;
        } else if (C43749c.cMf().tdM < 2) {
            AppMethodBeat.m2505o(135349);
            return C25738R.string.f4l;
        } else {
            AppMethodBeat.m2505o(135349);
            return C25738R.string.f4u;
        }
    }

    /* renamed from: ig */
    public final void mo30909ig(boolean z) {
        AppMethodBeat.m2504i(135350);
        this.tdZ.setVisibility(0);
        this.tdZ.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
        this.tdZ.setBackgroundResource(C25738R.drawable.bjm);
        this.tdZ.setCompoundDrawables(null, null, null, null);
        this.tdZ.setCompoundDrawablePadding(0);
        this.tdZ.setText(C44768b.m81683GZ(1001));
        AppMethodBeat.m2505o(135350);
    }

    public final void bGR() {
        AppMethodBeat.m2504i(135351);
        this.tdZ.setVisibility(8);
        AppMethodBeat.m2505o(135351);
    }

    /* renamed from: a */
    public final void mo26415a(byte[] bArr, long j, int i, int i2, int i3, int i4) {
        AppMethodBeat.m2504i(135352);
        C4990ab.m7410d("MicroMsg.voipcs.VoipCSViewManager", "receive frame data , isPause : " + this.cAY);
        if (this.cAY) {
            AppMethodBeat.m2505o(135352);
            return;
        }
        if (this.teo.oHc == null) {
            this.teo.f2950w = i;
            this.teo.f2949h = i2;
            this.teo.oHc = new int[(this.teo.f2950w * this.teo.f2949h)];
        }
        int i5 = this.tec.cLE() ? OpenGlRender.FLAG_Mirror : 0;
        int i6 = this.tec.cLF() ? OpenGlRender.FLAG_Angle270 : OpenGlRender.FLAG_Angle90;
        if (this.tef) {
            C4990ab.m7410d("MicroMsg.voipcs.VoipCSViewManager", "videoEncodeToSend , ret = ".concat(String.valueOf(C43749c.cMe().tew.videoEncodeToSend(bArr, bArr.length, i, i2, i3 + i4))));
            C43746a c43746a = C43749c.cMe().tew;
            c43746a.sVr++;
        }
        C43749c.cMe().tew.videoEncodeToLocal(bArr, (int) j, i, i2, i3 + i4, 0, 75, this.teo.oHc);
        if (OpenGlRender.taQ != 1) {
            if (OpenGlRender.taQ == 2) {
                if (this.sXI) {
                    this.sWU.mo63361c(bArr, i, i2, (OpenGlRender.FLAG_NV21 + i5) + i6, false);
                    AppMethodBeat.m2505o(135352);
                    return;
                }
                this.sWV.mo63361c(bArr, i, i2, (OpenGlRender.FLAG_NV21 + i5) + i6, false);
            }
            AppMethodBeat.m2505o(135352);
        } else if (this.sXI) {
            this.sWU.mo63360a(this.teo.oHc, i, i2, (OpenGlRender.FLAG_RGBAClip + i5) + i6, false);
            AppMethodBeat.m2505o(135352);
        } else {
            this.sWV.mo63360a(this.teo.oHc, i, i2, (OpenGlRender.FLAG_RGBAClip + i5) + i6, false);
            AppMethodBeat.m2505o(135352);
        }
    }

    public final void bSo() {
        AppMethodBeat.m2504i(135353);
        C4990ab.m7412e("MicroMsg.voipcs.VoipCSViewManager", "init camera fail！");
        AppMethodBeat.m2505o(135353);
    }

    public final void cMw() {
        AppMethodBeat.m2504i(135354);
        cMx();
        this.tep = new C29521c();
        C7305d.m12298f(this.tep, "VOIPCS_VideoDecode");
        C4990ab.m7410d("MicroMsg.voipcs.VoipCSViewManager", "start video decode thread..");
        AppMethodBeat.m2505o(135354);
    }

    public final void cMx() {
        AppMethodBeat.m2504i(135355);
        if (this.tep != null) {
            C4990ab.m7410d("MicroMsg.voipcs.VoipCSViewManager", "stop videodecode thread...");
            this.tep.sQd = true;
            C7305d.xDG.remove(this.tep);
            this.tep = null;
        }
        AppMethodBeat.m2505o(135355);
    }

    public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
    }

    public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
    }

    public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        return false;
    }

    public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }
}
