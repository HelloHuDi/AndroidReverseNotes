package com.tencent.mm.plugin.voip_cs.b.a;

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
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.video.ObservableTextureView;
import com.tencent.mm.plugin.voip.model.p;
import com.tencent.mm.plugin.voip.ui.VoipBigIconButton;
import com.tencent.mm.plugin.voip.video.MovableVideoView;
import com.tencent.mm.plugin.voip.video.OpenGlRender;
import com.tencent.mm.plugin.voip.video.OpenGlView;
import com.tencent.mm.plugin.voip.video.g;
import com.tencent.mm.plugin.voip_cs.ui.VoipCSMainUI;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.ttpic.thread.FaceGestureDetGLThread;
import java.io.InputStream;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Timer;
import java.util.TimerTask;

public final class b implements SurfaceTextureListener, OnClickListener, com.tencent.mm.plugin.voip.model.p.a, g {
    protected static int mScreenHeight;
    protected static int mScreenWidth;
    protected static final int[] sWo = new int[]{-1, R.string.f57, R.string.f5b, R.string.f5a};
    public boolean cAY = false;
    public TextView ejp;
    private TextView enf;
    private ak fbD;
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
    private OnClickListener sYk = new OnClickListener() {
        public final void onClick(View view) {
            AppMethodBeat.i(135320);
            ab.i("MicroMsg.voipcs.VoipCSViewManager", "switch camera");
            b.this.sXq.setEnabled(false);
            if (com.tencent.mm.plugin.voip_cs.b.c.cMf().tdM > 1) {
                b.e(b.this);
            }
            b.this.sXq.setEnabled(true);
            if (b.this.tec != null) {
                b.this.tec.cLB();
            }
            AppMethodBeat.o(135320);
        }
    };
    public VoipCSMainUI tdU;
    private RelativeLayout tdV;
    private TextView tdW;
    private TextView tdX;
    private TextView tdY;
    private TextView tdZ;
    public ImageView tea;
    private ak teb;
    private com.tencent.mm.plugin.voip_cs.c.a tec;
    private boolean ted = false;
    protected long tee = -1;
    private boolean tef = false;
    private boolean teg = false;
    private int teh = 60000;
    private int tei = 5000;
    private com.tencent.mm.plugin.voip_cs.c.b tej = new com.tencent.mm.plugin.voip_cs.c.b();
    public String tek = "";
    public String tel = "";
    private ap tem = new ap(Looper.getMainLooper(), new com.tencent.mm.sdk.platformtools.ap.a() {
        public final boolean BI() {
            AppMethodBeat.i(135318);
            ab.i("MicroMsg.voipcs.VoipCSViewManager", "voipcs invite time out!opposite not responese");
            com.tencent.mm.plugin.voip_cs.b.c.cMg().dataType = 1;
            b.this.GY(6);
            AppMethodBeat.o(135318);
            return true;
        }
    }, false);
    private ap ten = new ap(Looper.getMainLooper(), new com.tencent.mm.sdk.platformtools.ap.a() {
        public final boolean BI() {
            AppMethodBeat.i(135319);
            b.this.tdX.setText(ah.getContext().getString(R.string.f5d));
            b.this.tdY.setVisibility(0);
            com.tencent.mm.plugin.voip_cs.c.b c = b.this.tej;
            TextView b = b.this.tdY;
            int[] iArr = b.sWo;
            if (iArr == null || b == null) {
                ab.e("MicroMsg.DynamicTextWrap", "textList or tv is null");
            } else {
                c.cLc();
                c.sWE = 0;
                c.sWC = iArr;
                c.sW = b;
                c.sWD = 500;
                if (c.gyS != null) {
                    long j = (long) c.sWD;
                    c.gyS.ae(j, j);
                }
                ab.b("MicroMsg.DynamicTextWrap", "start textview:".concat(String.valueOf(b)), new Object[0]);
            }
            AppMethodBeat.o(135319);
            return true;
        }
    }, false);
    a teo = new a(this, (byte) 0);
    c tep;
    b teq;
    String ter = "";
    Drawable tes = null;

    class a {
        int h;
        int[] oHc;
        int w;

        private a() {
        }

        /* synthetic */ a(b bVar, byte b) {
            this();
        }
    }

    class b implements Runnable {
        b() {
        }

        public final void run() {
            AppMethodBeat.i(135328);
            b.this.tes = b.acf(b.this.ter);
            Message message = new Message();
            message.what = 12;
            b.this.teb.sendMessage(message);
            d.xDG.remove(b.this.teq);
            AppMethodBeat.o(135328);
        }
    }

    class c implements Runnable {
        boolean sQd = false;

        c() {
        }

        public final void run() {
            AppMethodBeat.i(135329);
            while (!this.sQd && !b.this.cAY) {
                if (com.tencent.mm.plugin.voip_cs.b.c.cMe().tew.videoDecode(com.tencent.mm.plugin.voip_cs.b.c.cMe().tew.sUU) == 1) {
                    int i = com.tencent.mm.plugin.voip_cs.b.c.cMe().tew.field_remoteImgWidth;
                    int i2 = com.tencent.mm.plugin.voip_cs.b.c.cMe().tew.field_remoteImgHeight;
                    if (OpenGlRender.taQ == 1) {
                        if (b.this.sXI) {
                            b.this.sWV.a(com.tencent.mm.plugin.voip_cs.b.c.cMe().tew.sUU, i, i2, OpenGlRender.FLAG_RGBA + OpenGlRender.FLAG_Angle90, false);
                        } else {
                            b.this.sWU.a(com.tencent.mm.plugin.voip_cs.b.c.cMe().tew.sUU, i, i2, OpenGlRender.FLAG_RGBA + OpenGlRender.FLAG_Angle90, false);
                        }
                    } else if (b.this.sXI) {
                        b.this.sWV.a(com.tencent.mm.plugin.voip_cs.b.c.cMe().tew.sUU, i, i2, OpenGlRender.FLAG_YV12Edge + OpenGlRender.FLAG_Angle90, false);
                    } else {
                        b.this.sWU.a(com.tencent.mm.plugin.voip_cs.b.c.cMe().tew.sUU, i, i2, OpenGlRender.FLAG_YV12Edge + OpenGlRender.FLAG_Angle90, false);
                    }
                }
                try {
                    Thread.sleep(20);
                } catch (InterruptedException e) {
                    ab.printErrStackTrace("MicroMsg.voipcs.VoipCSViewManager", e, "", new Object[0]);
                }
            }
            AppMethodBeat.o(135329);
        }
    }

    static /* synthetic */ Point b(b bVar, boolean z) {
        AppMethodBeat.i(135357);
        Point mA = bVar.mA(z);
        AppMethodBeat.o(135357);
        return mA;
    }

    static /* synthetic */ void e(b bVar) {
        AppMethodBeat.i(135356);
        bVar.cMv();
        AppMethodBeat.o(135356);
    }

    static /* synthetic */ void n(b bVar) {
        AppMethodBeat.i(135358);
        bVar.GX(8);
        AppMethodBeat.o(135358);
    }

    static /* synthetic */ void o(b bVar) {
        AppMethodBeat.i(135359);
        bVar.mG(false);
        AppMethodBeat.o(135359);
    }

    public b(VoipCSMainUI voipCSMainUI) {
        AppMethodBeat.i(135330);
        this.tdU = voipCSMainUI;
        WindowManager windowManager = (WindowManager) voipCSMainUI.getSystemService("window");
        int height = windowManager.getDefaultDisplay().getHeight() / 5;
        int width = (windowManager.getDefaultDisplay().getWidth() * height) / windowManager.getDefaultDisplay().getHeight();
        if (Build.MANUFACTURER.equalsIgnoreCase("meizu")) {
            ((RelativeLayout) voipCSMainUI.findViewById(R.id.f31)).setPadding(0, 0, 0, com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.b(voipCSMainUI.mController.ylL, 40.0f));
        }
        this.sWT = new MovableVideoView(voipCSMainUI.getApplicationContext());
        ((MovableVideoView) this.sWT).ga(width, height);
        this.sWT.setVisibility(8);
        this.sWU = new OpenGlRender(this.sWT, OpenGlRender.RenderRemote);
        this.sWT.setRenderer(this.sWU);
        this.sWT.setRenderMode(0);
        if (Build.MODEL.equals("Nexus 6")) {
            this.sWT.setZOrderOnTop(true);
        } else {
            this.sWT.setZOrderMediaOverlay(true);
        }
        this.enf = (TextView) voipCSMainUI.findViewById(R.id.la);
        this.enf.setVisibility(0);
        this.oGr = new Timer("voip_cs_talking_time");
        this.tdW = (TextView) voipCSMainUI.findViewById(R.id.f34);
        this.tdW.setVisibility(0);
        this.tdX = (TextView) voipCSMainUI.findViewById(R.id.f2y);
        if (voipCSMainUI.cQL.equals("1")) {
            if (voipCSMainUI.type.equals("video")) {
                this.tdX.setText(ah.getContext().getString(R.string.f4q));
            } else {
                this.tdX.setText(ah.getContext().getString(R.string.f4r));
            }
        } else if (voipCSMainUI.type.equals("video")) {
            this.tdX.setText(ah.getContext().getString(R.string.f4s));
        } else {
            this.tdX.setText(ah.getContext().getString(R.string.f4r));
        }
        this.tdX.setVisibility(0);
        this.ejp = (TextView) voipCSMainUI.findViewById(R.id.f2w);
        this.ejp.setVisibility(0);
        this.tea = (ImageView) voipCSMainUI.findViewById(R.id.f2v);
        this.tea.setVisibility(0);
        this.tdZ = (TextView) voipCSMainUI.findViewById(R.id.f35);
        this.tdY = (TextView) voipCSMainUI.findViewById(R.id.f2z);
        this.sXq = (VoipBigIconButton) voipCSMainUI.findViewById(R.id.f33);
        if (voipCSMainUI.teD == null || !voipCSMainUI.teD.equals("1")) {
            this.sXq.setVisibility(8);
        } else {
            this.sXq.setVisibility(0);
            this.sXq.setOnClickListener(this.sYk);
        }
        this.fbD = new ak();
        this.teb = new ak() {
            public final void handleMessage(Message message) {
                AppMethodBeat.i(135321);
                switch (message.what) {
                    case 12:
                        if (b.this.tes == null) {
                            b.this.tea.setImageResource(R.drawable.ad2);
                            break;
                        }
                        b.this.tea.setImageDrawable(b.this.tes);
                        AppMethodBeat.o(135321);
                        return;
                }
                AppMethodBeat.o(135321);
            }
        };
        this.oIL = voipCSMainUI.findViewById(R.id.f2t);
        this.oIs = (ImageButton) voipCSMainUI.findViewById(R.id.f32);
        this.tdV = (RelativeLayout) voipCSMainUI.findViewById(R.id.f2t);
        mScreenWidth = com.tencent.mm.bz.a.gd(voipCSMainUI.mController.ylL);
        mScreenHeight = com.tencent.mm.plugin.voip_cs.c.c.fj(voipCSMainUI.mController.ylL);
        this.sWS = (OpenGlView) voipCSMainUI.findViewById(R.id.f2u);
        this.sWS.gb(mScreenWidth, mScreenHeight);
        this.sWV = new OpenGlRender(this.sWS, OpenGlRender.RenderLocal);
        this.sWS.setRenderer(this.sWV);
        this.sWS.setRenderMode(0);
        this.sWS.setVisibility(0);
        ab.i("MicroMsg.voipcs.VoipCSViewManager", "mScreenHeight %d", Integer.valueOf(mScreenHeight));
        this.oIs.setOnClickListener(this);
        this.tdV.addView(this.sWT);
        this.sWT.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(135322);
                b.this.sXI = !b.this.sXI;
                Point b = b.b(b.this, b.this.sXI);
                b.this.sWT.gc(b.x, b.y);
                AppMethodBeat.o(135322);
            }
        });
        this.sWU.taA = true;
        this.sWV.taA = true;
        if (!com.tencent.mm.plugin.voip.a.d.fd(ah.getContext())) {
            com.tencent.mm.plugin.voip.a.d.fe(ah.getContext());
        }
        SharedPreferences doB = ah.doB();
        this.tek = doB.getString(cMr(), "");
        if (this.tdU.gEl != null && !this.tdU.gEl.equals("")) {
            ace(this.tdU.gEl);
        } else if (!bo.isNullOrNil(this.tek)) {
            ace(this.tek);
        }
        this.tel = doB.getString(cMs(), "");
        if (!bo.isNullOrNil(this.tel)) {
            acd(this.tel);
        }
        f cMf = com.tencent.mm.plugin.voip_cs.b.c.cMf();
        String str = this.tdU.tdN;
        ab.d("MicroMsg.voipcs.VoipCSService", "start getBizInfo for username:".concat(String.valueOf(str)));
        com.tencent.mm.kernel.g.Rg().a(106, cMf);
        com.tencent.mm.kernel.g.Rg().a(new com.tencent.mm.plugin.messenger.a.f(str), 0);
        AppMethodBeat.o(135330);
    }

    public final void cMp() {
        AppMethodBeat.i(135331);
        if (this.tem.doT()) {
            long j = (long) this.teh;
            this.tem.ae(j, j);
        }
        AppMethodBeat.o(135331);
    }

    public final void cMq() {
        AppMethodBeat.i(135332);
        if (this.ten.doT()) {
            long j = (long) this.tei;
            this.ten.ae(j, j);
        }
        AppMethodBeat.o(135332);
    }

    public final void acd(String str) {
        CharSequence charSequence;
        AppMethodBeat.i(135333);
        if (this.tdU.teG) {
            charSequence = str + ah.getContext().getString(R.string.f4h);
        } else {
            charSequence = str + ah.getContext().getString(R.string.f4i);
        }
        this.ejp.setText(charSequence);
        AppMethodBeat.o(135333);
    }

    public final void ace(String str) {
        AppMethodBeat.i(135334);
        if (!bo.isNullOrNil(str)) {
            this.teq = new b();
            if (this.tdU.gEl == null || this.tdU.gEl.equals("")) {
                this.ter = str;
            } else {
                this.ter = this.tdU.gEl;
            }
            d.f(this.teq, "VOIPCS_netPic");
        }
        AppMethodBeat.o(135334);
    }

    public final String cMr() {
        AppMethodBeat.i(135335);
        String str = "voip_cs_headImageUrl_" + this.tdU.tdN;
        AppMethodBeat.o(135335);
        return str;
    }

    public final String cMs() {
        AppMethodBeat.i(135336);
        String str = "voip_cs_nickname_" + this.tdU.tdN;
        AppMethodBeat.o(135336);
        return str;
    }

    private Point mA(boolean z) {
        AppMethodBeat.i(135337);
        int height = ((WindowManager) this.tdU.getSystemService("window")).getDefaultDisplay().getHeight() / 5;
        Point point = new Point((int) (mw(!z) * ((float) height)), height);
        AppMethodBeat.o(135337);
        return point;
    }

    private static float mw(boolean z) {
        byte[] bArr;
        AppMethodBeat.i(135338);
        float f = 0.74766356f;
        if (z) {
            try {
                bArr = com.tencent.mm.plugin.voip_cs.b.c.cMe().tew.field_capInfo;
            } catch (Exception e) {
                ab.e("MicroMsg.voipcs.VoipCSViewManager", "update failed: " + e.getMessage());
            }
        } else {
            bArr = com.tencent.mm.plugin.voip_cs.b.c.cMe().tew.sUb;
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
            ab.d("MicroMsg.voipcs.VoipCSViewManager", "use rate: %s, changed: %s", Float.valueOf(f), Boolean.valueOf(z));
        }
        AppMethodBeat.o(135338);
        return f;
    }

    public final void onClick(View view) {
        boolean z = false;
        AppMethodBeat.i(135339);
        if (view.getId() == R.id.f32) {
            if (com.tencent.mm.plugin.voip_cs.b.c.cMf().tdM < 2) {
                com.tencent.mm.plugin.voip_cs.b.c.cMg().dataType = 2;
            } else {
                com.tencent.mm.plugin.voip_cs.b.c.cMg().dataType = 4;
            }
            com.tencent.mm.plugin.voip_cs.b.d cMg = com.tencent.mm.plugin.voip_cs.b.c.cMg();
            cMg.tcP = 1;
            cMg.tdm = 1;
            cMg.tcQ = (int) (System.currentTimeMillis() / 1000);
            cMg = com.tencent.mm.plugin.voip_cs.b.c.cMg();
            ab.d("MicroMsg.VoipCSReportHelper", "selfCancel");
            if (cMg.tdj == 0) {
                cMg.tde = 3;
                if (cMg.tdn == 0 && cMg.tdz != 0) {
                    cMg.tdn = (long) (((int) (System.currentTimeMillis() / 1000)) - cMg.tdz);
                }
            }
            com.tencent.mm.plugin.voip_cs.b.c.cMg().cMh();
            ab.d("MicroMsg.voipcs.VoipCSViewManager", "user click hangup button!");
            GY(0);
            AppMethodBeat.o(135339);
            return;
        }
        int i = this.oIs.getVisibility() == 0 ? 8 : 0;
        this.oIs.setVisibility(i);
        this.enf.setVisibility(i);
        this.tdW.setVisibility(i);
        GX(i);
        if (i == 0) {
            z = true;
        }
        mG(z);
        AppMethodBeat.o(135339);
    }

    private void GX(int i) {
        AppMethodBeat.i(135340);
        if (this.tdU.teD == null || !this.tdU.teD.equals("1")) {
            this.sXq.setVisibility(8);
            AppMethodBeat.o(135340);
            return;
        }
        this.sXq.setVisibility(i);
        AppMethodBeat.o(135340);
    }

    public final void cMt() {
        AppMethodBeat.i(135341);
        ab.i("MicroMsg.voipcs.VoipCSViewManager", "start capture render");
        if (this.oIY == null) {
            ab.i("MicroMsg.voipcs.VoipCSViewManager", "create capture View");
            this.oIY = new ObservableTextureView(this.tdU);
            this.oIY.setLayoutParams(new LayoutParams(1, 1));
            this.tdV.addView(this.oIY, new LayoutParams(1, 1));
            this.oIY.setVisibility(0);
        }
        if (this.tec == null) {
            int i = 320;
            int i2 = 240;
            com.tencent.mm.plugin.voip_cs.b.c.cMe();
            if (com.tencent.mm.plugin.voip_cs.b.a.sTV) {
                i = 640;
                i2 = 480;
            }
            ab.i("MicroMsg.voipcs.VoipCSViewManager", "create capture Render");
            this.tec = new com.tencent.mm.plugin.voip_cs.c.a(i, i2);
            this.tec.a((g) this, true);
            this.tec.a(this.oIY);
            com.tencent.mm.plugin.voip_cs.b.c.cMe().tew.sUm = this.tec.cLG();
            this.tec.cLC();
            this.tec.cMB();
            ab.i("MicroMsg.voipcs.VoipCSViewManager", "captureRender.mIsCurrentFaceCamera=%b captureRender.mIsCameraRemote180=%b", Boolean.valueOf(this.tec.cLE()), Boolean.valueOf(this.tec.cLF()));
        }
        AppMethodBeat.o(135341);
    }

    public final void cMu() {
        AppMethodBeat.i(135342);
        ab.i("MicroMsg.voipcs.VoipCSViewManager", "stop capture render");
        if (this.oIY != null) {
            this.tdV.removeView(this.oIY);
            this.oIY = null;
        }
        if (this.tec != null) {
            this.tec.cLD();
            this.tec = null;
        }
        AppMethodBeat.o(135342);
    }

    private void cMv() {
        AppMethodBeat.i(135343);
        ab.i("MicroMsg.voipcs.VoipCSViewManager", "trigger dismiss button");
        this.fbD.postDelayed(new Runnable() {
            public final void run() {
                AppMethodBeat.i(135323);
                ab.i("MicroMsg.voipcs.VoipCSViewManager", "dismiss button");
                if (b.this.tdU.isFinishing()) {
                    AppMethodBeat.o(135323);
                    return;
                }
                b.this.oIs.setVisibility(8);
                b.this.enf.setVisibility(8);
                b.this.tdW.setVisibility(8);
                b.n(b.this);
                b.o(b.this);
                AppMethodBeat.o(135323);
            }
        }, 10000);
        AppMethodBeat.o(135343);
    }

    private void mG(boolean z) {
        AppMethodBeat.i(135344);
        if (Build.MANUFACTURER.equalsIgnoreCase("sony")) {
            ab.i("MicroMsg.voipcs.VoipCSViewManager", "sony is not compatible,so we return.");
            AppMethodBeat.o(135344);
        } else if (z) {
            this.tdU.getWindow().clearFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
            AppMethodBeat.o(135344);
        } else {
            this.tdU.getWindow().setFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
            AppMethodBeat.o(135344);
        }
    }

    public final void bGQ() {
        AppMethodBeat.i(135345);
        this.tem.stopTimer();
        this.ten.stopTimer();
        this.tej.cLc();
        this.tdY.setVisibility(8);
        this.tdX.setText(R.string.f5_);
        this.tdW.setText(R.string.f4y);
        GX(0);
        this.oIL.setOnClickListener(this);
        if (this.tdU.teE != null && this.tdU.teE.equals("1")) {
            this.sWT.setVisibility(0);
            this.sXI = true;
            Point mA = mA(this.sXI);
            ((MovableVideoView) this.sWT).ga(mA.x, mA.y);
            cMw();
        }
        cMv();
        this.tef = true;
        if (this.oGr == null) {
            this.oGr = new Timer("voip_cs_talking_time");
        }
        if (this.ted) {
            AppMethodBeat.o(135345);
            return;
        }
        if (this.tee == -1) {
            this.tee = bo.anT();
        }
        this.ted = true;
        this.oGr.schedule(new TimerTask() {
            public final void run() {
                AppMethodBeat.i(135325);
                b.this.fbD.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(135324);
                        b.this.enf.setText(b.fQ(bo.fp(b.this.tee)));
                        AppMethodBeat.o(135324);
                    }
                });
                AppMethodBeat.o(135325);
            }
        }, 1000, 1000);
        p.cJR().cJS();
        p.cJR().a(this);
        AppMethodBeat.o(135345);
    }

    public static Drawable acf(String str) {
        AppMethodBeat.i(135346);
        try {
            Drawable createFromStream = Drawable.createFromStream((InputStream) new URL(str).getContent(), "urlDrawable");
            AppMethodBeat.o(135346);
            return createFromStream;
        } catch (Exception e) {
            ab.e("MicroMsg.voipcs.VoipCSViewManager", "parse Drawable faill!");
            AppMethodBeat.o(135346);
            return null;
        }
    }

    protected static String fQ(long j) {
        AppMethodBeat.i(135347);
        String format = String.format("%02d:%02d", new Object[]{Long.valueOf(j / 60), Long.valueOf(j % 60)});
        AppMethodBeat.o(135347);
        return format;
    }

    public final void GY(int i) {
        AppMethodBeat.i(135348);
        ab.i("MicroMsg.voipcs.VoipCSViewManager", "onRefreshed for action:".concat(String.valueOf(i)));
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
        this.tdZ.setBackgroundResource(R.drawable.bjm);
        this.tdZ.setCompoundDrawables(null, null, null, null);
        this.tdZ.setCompoundDrawablePadding(0);
        this.tdZ.setText(GZ(i));
        if (com.tencent.mm.plugin.voip_cs.b.c.cMf().tdM == 2) {
            d.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(135326);
                    a cMn = a.cMn();
                    if (cMn.sTj != null) {
                        cMn.sTj.Gx(0);
                    }
                    AppMethodBeat.o(135326);
                }
            }, "VoipCS_play_end_sound");
        }
        this.fbD.postDelayed(new Runnable() {
            public final void run() {
                AppMethodBeat.i(135327);
                b.this.tdU.finish();
                AppMethodBeat.o(135327);
            }
        }, FaceGestureDetGLThread.BRIGHTNESS_DURATION);
        AppMethodBeat.o(135348);
    }

    private static int GZ(int i) {
        AppMethodBeat.i(135349);
        if (i == 1) {
            AppMethodBeat.o(135349);
            return R.string.f4n;
        } else if (i == 0) {
            AppMethodBeat.o(135349);
            return R.string.f4u;
        } else if (i == -1 || i == 5) {
            AppMethodBeat.o(135349);
            return R.string.f55;
        } else if (i == 403 || i == 404) {
            AppMethodBeat.o(135349);
            return R.string.f5c;
        } else if (i == 6) {
            AppMethodBeat.o(135349);
            return R.string.f58;
        } else if (i == 1001) {
            AppMethodBeat.o(135349);
            return R.string.f54;
        } else if (i == 10) {
            AppMethodBeat.o(135349);
            return R.string.f4t;
        } else if (com.tencent.mm.plugin.voip_cs.b.c.cMf().tdM < 2) {
            AppMethodBeat.o(135349);
            return R.string.f4l;
        } else {
            AppMethodBeat.o(135349);
            return R.string.f4u;
        }
    }

    public final void ig(boolean z) {
        AppMethodBeat.i(135350);
        this.tdZ.setVisibility(0);
        this.tdZ.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
        this.tdZ.setBackgroundResource(R.drawable.bjm);
        this.tdZ.setCompoundDrawables(null, null, null, null);
        this.tdZ.setCompoundDrawablePadding(0);
        this.tdZ.setText(GZ(1001));
        AppMethodBeat.o(135350);
    }

    public final void bGR() {
        AppMethodBeat.i(135351);
        this.tdZ.setVisibility(8);
        AppMethodBeat.o(135351);
    }

    public final void a(byte[] bArr, long j, int i, int i2, int i3, int i4) {
        AppMethodBeat.i(135352);
        ab.d("MicroMsg.voipcs.VoipCSViewManager", "receive frame data , isPause : " + this.cAY);
        if (this.cAY) {
            AppMethodBeat.o(135352);
            return;
        }
        if (this.teo.oHc == null) {
            this.teo.w = i;
            this.teo.h = i2;
            this.teo.oHc = new int[(this.teo.w * this.teo.h)];
        }
        int i5 = this.tec.cLE() ? OpenGlRender.FLAG_Mirror : 0;
        int i6 = this.tec.cLF() ? OpenGlRender.FLAG_Angle270 : OpenGlRender.FLAG_Angle90;
        if (this.tef) {
            ab.d("MicroMsg.voipcs.VoipCSViewManager", "videoEncodeToSend , ret = ".concat(String.valueOf(com.tencent.mm.plugin.voip_cs.b.c.cMe().tew.videoEncodeToSend(bArr, bArr.length, i, i2, i3 + i4))));
            com.tencent.mm.plugin.voip_cs.b.a aVar = com.tencent.mm.plugin.voip_cs.b.c.cMe().tew;
            aVar.sVr++;
        }
        com.tencent.mm.plugin.voip_cs.b.c.cMe().tew.videoEncodeToLocal(bArr, (int) j, i, i2, i3 + i4, 0, 75, this.teo.oHc);
        if (OpenGlRender.taQ != 1) {
            if (OpenGlRender.taQ == 2) {
                if (this.sXI) {
                    this.sWU.c(bArr, i, i2, (OpenGlRender.FLAG_NV21 + i5) + i6, false);
                    AppMethodBeat.o(135352);
                    return;
                }
                this.sWV.c(bArr, i, i2, (OpenGlRender.FLAG_NV21 + i5) + i6, false);
            }
            AppMethodBeat.o(135352);
        } else if (this.sXI) {
            this.sWU.a(this.teo.oHc, i, i2, (OpenGlRender.FLAG_RGBAClip + i5) + i6, false);
            AppMethodBeat.o(135352);
        } else {
            this.sWV.a(this.teo.oHc, i, i2, (OpenGlRender.FLAG_RGBAClip + i5) + i6, false);
            AppMethodBeat.o(135352);
        }
    }

    public final void bSo() {
        AppMethodBeat.i(135353);
        ab.e("MicroMsg.voipcs.VoipCSViewManager", "init camera fail！");
        AppMethodBeat.o(135353);
    }

    public final void cMw() {
        AppMethodBeat.i(135354);
        cMx();
        this.tep = new c();
        d.f(this.tep, "VOIPCS_VideoDecode");
        ab.d("MicroMsg.voipcs.VoipCSViewManager", "start video decode thread..");
        AppMethodBeat.o(135354);
    }

    public final void cMx() {
        AppMethodBeat.i(135355);
        if (this.tep != null) {
            ab.d("MicroMsg.voipcs.VoipCSViewManager", "stop videodecode thread...");
            this.tep.sQd = true;
            d.xDG.remove(this.tep);
            this.tep = null;
        }
        AppMethodBeat.o(135355);
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
