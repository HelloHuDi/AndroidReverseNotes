package com.tencent.mm.plugin.voip.ui;

import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.HandlerThread;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.s;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.voip.a.d;
import com.tencent.mm.plugin.voip.model.m;
import com.tencent.mm.plugin.voip.model.q;
import com.tencent.mm.plugin.voip.model.r;
import com.tencent.mm.plugin.voip.video.CaptureView;
import com.tencent.mm.plugin.voip.video.MovableTextureView;
import com.tencent.mm.plugin.voip.video.MovableVideoView;
import com.tencent.mm.plugin.voip.video.OpenGlRender;
import com.tencent.mm.plugin.voip.video.OpenGlView;
import com.tencent.mm.plugin.voip.video.f;
import com.tencent.mm.plugin.voip.widget.VoIPVideoView;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.ui.base.MMTextureView;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.t;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import com.tencent.ttpic.thread.FaceGestureDetGLThread;
import java.io.UnsupportedEncodingException;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;

public class VoipVideoFragment extends VoipBaseFragment {
    private long iBO = 0;
    private Runnable lmq = new Runnable() {
        public final void run() {
            AppMethodBeat.i(4878);
            if (VoipVideoFragment.this.getActivity() == null || VoipVideoFragment.this.getActivity().isFinishing()) {
                AppMethodBeat.o(4878);
                return;
            }
            VoipVideoFragment.this.sXe.setVisibility(8);
            AppMethodBeat.o(4878);
        }
    };
    private Timer mTimer;
    private TextView nGB;
    int[] oHc = null;
    Bitmap oHs = null;
    private CaptureView sRg;
    private OpenGlView sWS;
    private OpenGlView sWT;
    private OpenGlRender sWU;
    private OpenGlRender sWV;
    private View sWW;
    private ImageView sWX;
    private TextView sWY;
    private TextView sWZ;
    private Button sXA = null;
    private boolean sXB = false;
    private int sXC;
    private int sXD;
    private int sXE;
    private int sXF;
    private int sXG;
    private int sXH = 0;
    private boolean sXI = false;
    private boolean sXJ = false;
    private boolean sXK = false;
    private boolean sXL;
    public long sXM = 0;
    private Bitmap sXN = null;
    private a sXO;
    public MMTextureView sXP;
    public MMTextureView sXQ;
    private boolean sXR = false;
    public int sXS = 0;
    public int sXT = 0;
    private int sXU = 0;
    private int sXV = 0;
    private HandlerThread sXW = null;
    private ap sXX = null;
    private boolean sXY = false;
    private OnClickListener sXZ = new OnClickListener() {
        public final void onClick(View view) {
            AppMethodBeat.i(4870);
            ab.i("MicroMsg.Voip.VoipVideoFragment", "hangup video talking");
            if (!(VoipVideoFragment.this.sVY == null || VoipVideoFragment.this.sVY.get() == null || !((c) VoipVideoFragment.this.sVY.get()).cJk())) {
                VoipVideoFragment.this.sXp.setEnabled(false);
                VoipVideoFragment.this.sXo.setEnabled(false);
                VoipVideoFragment.this.fZ(R.string.f5m, -1);
            }
            AppMethodBeat.o(4870);
        }
    };
    private TextView sXa;
    private TextView sXb;
    private View sXc;
    private TextView sXd;
    private TextView sXe;
    private TextView sXf;
    private RelativeLayout sXg;
    private Button sXh;
    private VoipSmallIconButton sXi;
    private VoipSmallIconButton sXj;
    private VoipSmallIconButton sXk;
    private VoipBigIconButton sXl;
    private VoipBigIconButton sXm;
    private VoipBigIconButton sXn;
    private VoipBigIconButton sXo;
    private VoipBigIconButton sXp;
    private VoipBigIconButton sXq;
    private TextView sXr;
    private TextView sXs;
    private TextView sXt;
    private TextView sXu;
    private TextView sXv;
    private TextView sXw;
    private VoIPVideoView sXx;
    private f sXy = null;
    private Button sXz = null;
    private OnClickListener sYa = new OnClickListener() {
        public final void onClick(View view) {
            AppMethodBeat.i(4881);
            if (!(VoipVideoFragment.this.sVY == null || VoipVideoFragment.this.sVY.get() == null)) {
                ((c) VoipVideoFragment.this.sVY.get()).cJw();
            }
            AppMethodBeat.o(4881);
        }
    };
    private OnClickListener sYb = new OnClickListener() {
        public final void onClick(View view) {
            AppMethodBeat.i(4886);
            if (!(VoipVideoFragment.this.sVY == null || VoipVideoFragment.this.sVY.get() == null)) {
                ((c) VoipVideoFragment.this.sVY.get()).cJw();
            }
            AppMethodBeat.o(4886);
        }
    };
    private OnClickListener sYc = new OnClickListener() {
        public final void onClick(View view) {
            AppMethodBeat.i(4889);
            ab.i("MicroMsg.Voip.VoipVideoFragment", "click accept video invite use voice button");
            if (at.isWifi(VoipVideoFragment.this.getActivity()) || q.cJV()) {
                VoipVideoFragment.c(VoipVideoFragment.this);
                AppMethodBeat.o(4889);
                return;
            }
            h.a(VoipVideoFragment.this.getActivity(), (int) R.string.f6f, (int) R.string.f6g, new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(4887);
                    q.cJU();
                    VoipVideoFragment.c(VoipVideoFragment.this);
                    AppMethodBeat.o(4887);
                }
            }, new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(4888);
                    VoipVideoFragment.d(VoipVideoFragment.this);
                    AppMethodBeat.o(4888);
                }
            });
            AppMethodBeat.o(4889);
        }
    };
    private OnClickListener sYd = new OnClickListener() {
        public final void onClick(View view) {
            AppMethodBeat.i(4892);
            ab.i("MicroMsg.Voip.VoipVideoFragment", "click accept video invite button");
            if (at.isWifi(VoipVideoFragment.this.getActivity()) || (q.cJV() && !at.is2G(VoipVideoFragment.this.getActivity()))) {
                VoipVideoFragment.e(VoipVideoFragment.this);
                AppMethodBeat.o(4892);
                return;
            }
            h.a(VoipVideoFragment.this.getActivity(), (int) R.string.f6f, (int) R.string.f6g, new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(4890);
                    if (!at.is2G(VoipVideoFragment.this.getActivity())) {
                        q.cJU();
                    }
                    VoipVideoFragment.e(VoipVideoFragment.this);
                    AppMethodBeat.o(4890);
                }
            }, new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(4891);
                    VoipVideoFragment.d(VoipVideoFragment.this);
                    AppMethodBeat.o(4891);
                }
            });
            AppMethodBeat.o(4892);
        }
    };
    private OnClickListener sYe = new OnClickListener() {
        public final void onClick(View view) {
            AppMethodBeat.i(4893);
            ab.i("MicroMsg.Voip.VoipVideoFragment", "click reject video invite button");
            VoipVideoFragment.d(VoipVideoFragment.this);
            AppMethodBeat.o(4893);
        }
    };
    private OnClickListener sYf = new OnClickListener() {
        public final void onClick(View view) {
            AppMethodBeat.i(4894);
            ab.i("MicroMsg.Voip.VoipVideoFragment", "click cancel video invite button");
            if (!(VoipVideoFragment.this.sVY == null || VoipVideoFragment.this.sVY.get() == null || !((c) VoipVideoFragment.this.sVY.get()).cJr())) {
                VoipVideoFragment.this.sXp.setEnabled(false);
                VoipVideoFragment.this.sXl.setEnabled(false);
                VoipVideoFragment.this.sXe.setVisibility(0);
                VoipVideoFragment.this.sXe.setText(R.string.f4f);
            }
            AppMethodBeat.o(4894);
        }
    };
    private OnClickListener sYg = new OnClickListener() {
        public final void onClick(View view) {
            AppMethodBeat.i(4895);
            if (System.currentTimeMillis() - VoipVideoFragment.this.iBO <= 1000) {
                AppMethodBeat.o(4895);
                return;
            }
            VoipVideoFragment.this.iBO = System.currentTimeMillis();
            com.tencent.mm.plugin.report.service.h.pYm.e(11618, Integer.valueOf(2), Integer.valueOf(1));
            if (!(VoipVideoFragment.this.sVY == null || VoipVideoFragment.this.sVY.get() == null)) {
                ((c) VoipVideoFragment.this.sVY.get()).mv(true);
                if (VoipVideoFragment.this.sXR) {
                    VoipVideoFragment.this.sWp.removeView(VoipVideoFragment.this.sXQ);
                } else {
                    VoipVideoFragment.this.sWp.removeView(VoipVideoFragment.this.sXP);
                }
                VoipVideoFragment.this.sXR = false;
            }
            if (VoipVideoFragment.this.sWu != null) {
                VoipVideoFragment.this.cJD();
                VoipVideoFragment.this.sWu.S(false, true);
            }
            AppMethodBeat.o(4895);
        }
    };
    private OnClickListener sYh = new OnClickListener() {
        public final void onClick(View view) {
            AppMethodBeat.i(4896);
            com.tencent.mm.plugin.report.service.h.pYm.e(11619, Integer.valueOf(2));
            if (!(VoipVideoFragment.this.sVY == null || VoipVideoFragment.this.sVY.get() == null)) {
                ((c) VoipVideoFragment.this.sVY.get()).cJL();
            }
            AppMethodBeat.o(4896);
        }
    };
    private OnClickListener sYi = new OnClickListener() {
        public final void onClick(View view) {
            AppMethodBeat.i(4871);
            VoipVideoFragment.this.sXB = !VoipVideoFragment.this.sXB;
            if (!VoipVideoFragment.this.sXB) {
                VoipVideoFragment.this.sXy.setVisibility(8);
            }
            Toast.makeText(VoipVideoFragment.this.getActivity(), String.format("mIsShowFaceRect:%b", new Object[]{Boolean.valueOf(VoipVideoFragment.this.sXB)}), 0).show();
            AppMethodBeat.o(4871);
        }
    };
    private OnClickListener sYj = new OnClickListener() {
        public final void onClick(View view) {
            AppMethodBeat.i(4872);
            boolean a = bo.a((Boolean) view.getTag(), false);
            view.setTag(Boolean.valueOf(!a));
            if (a) {
                VoipVideoFragment.this.sXy.setVisibility(8);
                Toast.makeText(VoipVideoFragment.this.getActivity(), "stop face detect", 0).show();
            } else {
                Toast.makeText(VoipVideoFragment.this.getActivity(), "start face detect", 0).show();
            }
            if (!(VoipVideoFragment.this.sVY == null || VoipVideoFragment.this.sVY.get() == null)) {
                ((c) VoipVideoFragment.this.sVY.get()).cJM();
            }
            AppMethodBeat.o(4872);
        }
    };
    private OnClickListener sYk = new OnClickListener() {
        public final void onClick(View view) {
            AppMethodBeat.i(4876);
            ab.i("MicroMsg.Voip.VoipVideoFragment", "switch camera");
            VoipVideoFragment.this.sXq.setEnabled(false);
            VoipVideoFragment.u(VoipVideoFragment.this);
            VoipVideoFragment.this.sXq.setEnabled(true);
            if (!(VoipVideoFragment.this.sVY == null || VoipVideoFragment.this.sVY.get() == null)) {
                ((c) VoipVideoFragment.this.sVY.get()).cJu();
            }
            AppMethodBeat.o(4876);
        }
    };
    private Runnable sYl = new Runnable() {
        public final void run() {
            AppMethodBeat.i(4877);
            ab.i("MicroMsg.Voip.VoipVideoFragment", "dismiss bar");
            VoipVideoFragment.this.sXH = VoipVideoFragment.this.sXH - 1;
            if (VoipVideoFragment.this.getActivity() == null || VoipVideoFragment.this.getActivity().isFinishing()) {
                AppMethodBeat.o(4877);
            } else if (VoipVideoFragment.this.sXH > 0) {
                AppMethodBeat.o(4877);
            } else {
                VoipVideoFragment.this.sXq.setVisibility(8);
                VoipVideoFragment.this.sXh.setVisibility(8);
                VoipVideoFragment.this.sXd.setVisibility(8);
                VoipVideoFragment.this.sXp.setVisibility(8);
                VoipVideoFragment.this.sXo.setVisibility(8);
                VoipVideoFragment.e(VoipVideoFragment.this, false);
                AppMethodBeat.o(4877);
            }
        }
    };
    int sYm = 0;

    public class a implements Runnable {
        final /* synthetic */ VoipVideoFragment sYn;

        public final void run() {
            AppMethodBeat.i(4898);
            ab.i("MicroMsg.Voip.VoipVideoFragment", "try load blur bitmap");
            final Bitmap I = this.sYn.sXN;
            this.sYn.iGP.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(4897);
                    if (a.this.sYn.sWq != null) {
                        a.this.sYn.sWq.setBackgroundDrawable(new BitmapDrawable(I));
                    }
                    a.this.sYn.sXO = null;
                    AppMethodBeat.o(4897);
                }
            });
            AppMethodBeat.o(4898);
        }
    }

    public VoipVideoFragment() {
        AppMethodBeat.i(4899);
        AppMethodBeat.o(4899);
    }

    static /* synthetic */ Point d(VoipVideoFragment voipVideoFragment, boolean z) {
        AppMethodBeat.i(4932);
        Point mA = voipVideoFragment.mA(z);
        AppMethodBeat.o(4932);
        return mA;
    }

    static /* synthetic */ void u(VoipVideoFragment voipVideoFragment) {
        AppMethodBeat.i(4934);
        voipVideoFragment.cLe();
        AppMethodBeat.o(4934);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        AppMethodBeat.i(4900);
        this.sWp = (RelativeLayout) layoutInflater.inflate(R.layout.b2h, viewGroup, false);
        if (Build.MANUFACTURER.equalsIgnoreCase("meizu")) {
            ((RelativeLayout) this.sWp.findViewById(R.id.f3x)).setPadding(0, 0, 0, b.b(getActivity(), 40.0f));
        }
        this.sWq = (ImageView) this.sWp.findViewById(R.id.f3c);
        this.sWr = (ImageView) this.sWp.findViewById(R.id.f3f);
        this.sXg = (RelativeLayout) this.sWp.findViewById(R.id.f3h);
        this.sWS = (OpenGlView) this.sWp.findViewById(R.id.f3e);
        this.sWS.gb(mScreenWidth, mScreenHeight);
        this.sXP = (MMTextureView) this.sWp.findViewById(R.id.f3g);
        this.sXP.setVisibility(0);
        ab.i("MicroMsg.Voip.VoipVideoFragment", "steve: onCreateView!");
        if (this.sXP != null) {
            ab.i("MicroMsg.Voip.VoipVideoFragment", "hwView creat ok");
        }
        this.sXq = (VoipBigIconButton) this.sWp.findViewById(R.id.f48);
        this.sXq.setOnClickListener(this.sYk);
        this.sXp = (VoipBigIconButton) this.sWp.findViewById(R.id.f47);
        this.sXp.setOnClickListener(this.sYa);
        this.sXl = (VoipBigIconButton) this.sWp.findViewById(R.id.f3y);
        this.sXl.setOnClickListener(this.sYf);
        this.sXo = (VoipBigIconButton) this.sWp.findViewById(R.id.f44);
        this.sXo.setOnClickListener(this.sXZ);
        this.sXn = (VoipBigIconButton) this.sWp.findViewById(R.id.f42);
        this.sXn.setOnClickListener(this.sYd);
        this.sXk = (VoipSmallIconButton) this.sWp.findViewById(R.id.f43);
        this.sXk.setOnClickListener(this.sYc);
        this.sXm = (VoipBigIconButton) this.sWp.findViewById(R.id.f40);
        this.sXm.setOnClickListener(this.sYe);
        this.sXj = (VoipSmallIconButton) this.sWp.findViewById(R.id.f3z);
        this.sXj.setOnClickListener(this.sYb);
        this.sXL = d.vn("VOIPBlockIgnoreButton") == 0;
        this.sXi = (VoipSmallIconButton) this.sWp.findViewById(R.id.f41);
        this.sXi.setOnClickListener(this.sYh);
        if (!this.sXL) {
            this.sXi.setVisibility(8);
        }
        this.sXd = (TextView) this.sWp.findViewById(R.id.f46);
        this.sWW = this.sWp.findViewById(R.id.f3j);
        this.sWX = (ImageView) this.sWp.findViewById(R.id.f3k);
        com.tencent.mm.pluginsdk.ui.a.b.a(this.sWX, this.edV, 0.05882353f, true);
        this.sWY = (TextView) this.sWp.findViewById(R.id.f3m);
        this.sWZ = (TextView) this.sWp.findViewById(R.id.f3n);
        this.sXa = (TextView) this.sWp.findViewById(R.id.f3p);
        this.sXb = (TextView) this.sWp.findViewById(R.id.f3q);
        this.sXc = this.sWp.findViewById(R.id.f3o);
        j(this.sXb);
        this.sXe = (TextView) this.sWp.findViewById(R.id.f4_);
        this.sXf = (TextView) this.sWp.findViewById(R.id.f49);
        this.sXh = (Button) this.sWp.findViewById(R.id.f3i);
        this.nGB = (TextView) this.sWp.findViewById(R.id.ckv);
        if (ae.gjk) {
            this.sXr = (TextView) this.sWp.findViewById(R.id.f3r);
            this.sXs = (TextView) this.sWp.findViewById(R.id.f3s);
            this.sXt = (TextView) this.sWp.findViewById(R.id.f3t);
            this.sXu = (TextView) this.sWp.findViewById(R.id.f3u);
            this.sXv = (TextView) this.sWp.findViewById(R.id.f3v);
            this.sXw = (TextView) this.sWp.findViewById(R.id.f3w);
        }
        this.sXz = (Button) this.sWp.findViewById(R.id.f4a);
        this.sXA = (Button) this.sWp.findViewById(R.id.f4b);
        this.sXz.setVisibility(8);
        this.sXA.setVisibility(8);
        this.sXz.setOnClickListener(this.sYi);
        this.sXA.setOnClickListener(this.sYj);
        this.sXy = new f(getActivity());
        this.sWp.addView(this.sXy);
        this.sXy.setVisibility(8);
        this.sXh.setOnClickListener(this.sYg);
        b(this.sRg);
        int hF = t.hF(getActivity());
        ab.d("MicroMsg.Voip.VoipVideoFragment", "statusHeight: ".concat(String.valueOf(hF)));
        VoipBaseFragment.ae(this.sXh, hF);
        VoipBaseFragment.ae(this.sWp.findViewById(R.id.f45), hF);
        VoipBaseFragment.ae(this.sWW, hF);
        this.sXD = 0;
        this.sXC = 0;
        this.sXE = 0;
        this.sXF = 0;
        this.sXG = 0;
        this.sXU = 0;
        this.sXV = 0;
        WindowManager windowManager = (WindowManager) getActivity().getSystemService("window");
        int height = windowManager.getDefaultDisplay().getHeight() / 5;
        int width = (windowManager.getDefaultDisplay().getWidth() * height) / windowManager.getDefaultDisplay().getHeight();
        this.sWT = new MovableVideoView(getActivity().getApplicationContext());
        ((MovableVideoView) this.sWT).ga(width, height);
        this.sWT.setVisibility(8);
        this.sWU = new OpenGlRender(this.sWT, OpenGlRender.RenderRemote);
        this.sWT.setRenderer(this.sWU);
        this.sWT.setRenderMode(0);
        this.sWV = new OpenGlRender(this.sWS, OpenGlRender.RenderLocal);
        this.sWS.setRenderer(this.sWV);
        this.sWS.setRenderMode(0);
        this.sWS.setVisibility(0);
        ab.i("MicroMsg.Voip.VoipVideoFragment", "steve: before AvcDecoder init");
        this.sXQ = new MovableTextureView(getActivity().getApplicationContext());
        MovableTextureView movableTextureView = (MovableTextureView) this.sXQ;
        movableTextureView.mWidth = width;
        movableTextureView.sZX = height;
        DisplayMetrics displayMetrics = new DisplayMetrics();
        WindowManager windowManager2 = (WindowManager) movableTextureView.getContext().getSystemService("window");
        if (movableTextureView.mScreenWidth == 0) {
            movableTextureView.mScreenWidth = windowManager2.getDefaultDisplay().getWidth();
            movableTextureView.mScreenHeight = windowManager2.getDefaultDisplay().getHeight();
        }
        LayoutParams layoutParams = new LayoutParams(width, height);
        layoutParams.topMargin = com.tencent.mm.bz.a.fromDPToPix(movableTextureView.getContext(), 12) + t.hF(movableTextureView.getContext());
        layoutParams.leftMargin = ((movableTextureView.mScreenWidth - movableTextureView.mWidth) - layoutParams.topMargin) + t.hF(movableTextureView.getContext());
        movableTextureView.setLayoutParams(layoutParams);
        movableTextureView.taq = movableTextureView.mScreenHeight - movableTextureView.sZX;
        movableTextureView.tar = movableTextureView.mScreenWidth - movableTextureView.mWidth;
        windowManager2.getDefaultDisplay().getMetrics(displayMetrics);
        ab.i("MicroMsg.MovableTextureView", "steve: Init MovableTextureView successfully! size=" + width + " x " + height);
        this.sXQ.setVisibility(8);
        ((c) this.sVY.get()).b(this.sXP);
        if (Build.MODEL.equals("Nexus 6")) {
            this.sWT.setZOrderOnTop(true);
        } else {
            this.sWT.setZOrderMediaOverlay(true);
        }
        this.sWp.addView(this.sWT);
        this.sWT.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                boolean z;
                AppMethodBeat.i(4873);
                VoipVideoFragment.this.sXI = !VoipVideoFragment.this.sXI;
                VoipVideoFragment voipVideoFragment = VoipVideoFragment.this;
                if (VoipVideoFragment.this.sXI) {
                    z = false;
                } else {
                    z = true;
                }
                Point d = VoipVideoFragment.d(voipVideoFragment, z);
                VoipVideoFragment.this.sWT.gc(d.x, d.y);
                ab.i("MicroMsg.Voip.VoipVideoFragment", "steve: mGlSmallVideoView clicked!");
                if ((VoipVideoFragment.this.sXS & 1) != 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    if (!VoipVideoFragment.this.sXR) {
                        VoipVideoFragment.this.sXP.setVisibility(4);
                        VoipVideoFragment.this.sWp.removeView(VoipVideoFragment.this.sXP);
                        VoipVideoFragment.this.sWp.addView(VoipVideoFragment.this.sXQ);
                        ((c) VoipVideoFragment.this.sVY.get()).b(VoipVideoFragment.this.sXQ);
                        VoipVideoFragment.this.sXR = true;
                        ab.i("MicroMsg.Voip.VoipVideoFragment", "steve: change hw texture view!");
                    }
                    VoipVideoFragment.this.sWT.setVisibility(4);
                    VoipVideoFragment.this.sXQ.setVisibility(0);
                    VoipVideoFragment.this.sXQ.bringToFront();
                    VoipVideoFragment.this.sWS.setVisibility(0);
                } else {
                    VoipVideoFragment.this.sWT.setVisibility(0);
                    VoipVideoFragment.this.sXQ.setVisibility(4);
                    VoipVideoFragment.this.sWT.bringToFront();
                    VoipVideoFragment.this.sWS.setVisibility(0);
                }
                VoipVideoFragment.this.sWV.setVoipBeauty(VoipVideoFragment.this.sXT);
                VoipVideoFragment.this.sWU.setVoipBeauty(VoipVideoFragment.this.sXT);
                com.tencent.mm.plugin.report.service.h.pYm.e(11079, Integer.valueOf(3));
                AppMethodBeat.o(4873);
            }
        });
        this.sXQ.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(4874);
                ab.i("MicroMsg.Voip.VoipVideoFragment", "steve: hwTxtureViewSmall clicked!");
                if (VoipVideoFragment.this.sXR) {
                    boolean z;
                    VoipVideoFragment.this.sXI = !VoipVideoFragment.this.sXI;
                    VoipVideoFragment voipVideoFragment = VoipVideoFragment.this;
                    if (VoipVideoFragment.this.sXI) {
                        z = false;
                    } else {
                        z = true;
                    }
                    Point d = VoipVideoFragment.d(voipVideoFragment, z);
                    MovableTextureView movableTextureView = (MovableTextureView) VoipVideoFragment.this.sXQ;
                    int i = d.x;
                    int i2 = d.y;
                    LayoutParams layoutParams = (LayoutParams) movableTextureView.getLayoutParams();
                    LayoutParams layoutParams2 = new LayoutParams(i, i2);
                    layoutParams2.leftMargin = layoutParams.leftMargin;
                    layoutParams2.topMargin = layoutParams.topMargin;
                    movableTextureView.mWidth = i;
                    movableTextureView.sZX = i2;
                    movableTextureView.setLayoutParams(layoutParams2);
                    VoipVideoFragment.this.sXQ.setVisibility(4);
                    VoipVideoFragment.q(VoipVideoFragment.this);
                    VoipVideoFragment.this.sXP.setVisibility(0);
                    VoipVideoFragment.this.sWT.setVisibility(0);
                    ab.i("MicroMsg.Voip.VoipVideoFragment", "steve: change to big hw texture view!");
                    LayoutParams layoutParams3 = new LayoutParams(-1, -2);
                    layoutParams3.addRule(13);
                    int indexOfChild = VoipVideoFragment.this.sWp.indexOfChild(VoipVideoFragment.this.sWS);
                    VoipVideoFragment.this.sWp.removeView(VoipVideoFragment.this.sXQ);
                    VoipVideoFragment.this.sWp.addView(VoipVideoFragment.this.sXP, indexOfChild + 1, layoutParams3);
                    ((c) VoipVideoFragment.this.sVY.get()).b(VoipVideoFragment.this.sXP);
                    VoipVideoFragment.this.sXR = false;
                    com.tencent.mm.plugin.report.service.h.pYm.e(11079, Integer.valueOf(3));
                }
                AppMethodBeat.o(4874);
            }
        });
        ad aoO = ((j) g.K(j.class)).XM().aoO(this.edV);
        this.sWY.setText(com.tencent.mm.pluginsdk.ui.e.j.b(getActivity(), s.a(aoO, this.edV), this.sWY.getTextSize()));
        String A = com.tencent.mm.openim.room.a.a.A(aoO);
        if (!bo.isNullOrNil(A)) {
            this.sWZ.setText(A);
        }
        if (this.sRm) {
            this.iGP.postDelayed(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(4875);
                    VoipVideoFragment.this.sXa.setText(R.string.f60);
                    VoipVideoFragment.this.sWv.a(VoipVideoFragment.this.sXb, VoipBaseFragment.sWo);
                    AppMethodBeat.o(4875);
                }
            }, FaceGestureDetGLThread.BRIGHTNESS_DURATION);
        }
        this.sXx = (VoIPVideoView) this.sWp.findViewById(R.id.f3d);
        this.mTimer = new Timer("VoIP_video_talking_count");
        ab.i("MicroMsg.Voip.VoipVideoFragment", "onCreateView, voipBeautyMode: %s", Integer.valueOf(this.sXT));
        this.sWV.setVoipBeauty(this.sXT);
        this.sWU.setVoipBeauty(this.sXT);
        this.sXK = true;
        fY(0, this.mStatus);
        RelativeLayout relativeLayout = this.sWp;
        AppMethodBeat.o(4900);
        return relativeLayout;
    }

    public void onDestroy() {
        AppMethodBeat.i(4901);
        this.sXJ = false;
        super.onDestroy();
        AppMethodBeat.o(4901);
    }

    private void cLe() {
        AppMethodBeat.i(4902);
        ab.i("MicroMsg.Voip.VoipVideoFragment", "trigger dismiss bar");
        this.sXH++;
        this.iGP.postDelayed(this.sYl, 10000);
        AppMethodBeat.o(4902);
    }

    public final void fY(int i, int i2) {
        AppMethodBeat.i(4903);
        super.fY(i, i2);
        ab.i("MicroMsg.Voip.VoipVideoFragment", "newState: " + com.tencent.mm.plugin.voip.a.b.GK(i2));
        if (this.sWp == null) {
            ab.i("MicroMsg.Voip.VoipVideoFragment", "fragment no create, return first, onCreateView will call it again");
            AppMethodBeat.o(4903);
            return;
        }
        switch (i2) {
            case 0:
            case 2:
                cLg();
                AppMethodBeat.o(4903);
                return;
            case 4:
            case com.tencent.view.d.MIC_PTU_ZIPAI_SAPPORO /*258*/:
                cLi();
                break;
            case 6:
            case com.tencent.view.d.MIC_PTU_ZIPAI_GRADIENT_BLUEYELLOW /*260*/:
                cLj();
                cLh();
                AppMethodBeat.o(4903);
                return;
            case 8:
            case com.tencent.view.d.MIC_PTU_ZIPAI_GRADIENT_GLAREFONDDREAM /*262*/:
                GD(i);
                AppMethodBeat.o(4903);
                return;
            case 256:
                cLf();
                AppMethodBeat.o(4903);
                return;
        }
        AppMethodBeat.o(4903);
    }

    public final void a(CaptureView captureView) {
        AppMethodBeat.i(4904);
        this.sRg = captureView;
        b(this.sRg);
        AppMethodBeat.o(4904);
    }

    public final void uninit() {
        AppMethodBeat.i(4905);
        this.sWT.setVisibility(4);
        if (this.sRg != null) {
            this.sWp.removeView(this.sRg);
            this.sRg = null;
            ab.d("MicroMsg.Voip.VoipVideoFragment", "CaptureView removed");
        }
        if (this.sXO != null) {
            com.tencent.mm.sdk.g.d.xDG.remove(this.sXO);
            this.sXO = null;
        }
        super.uninit();
        AppMethodBeat.o(4905);
    }

    public final void setMute(boolean z) {
    }

    public void onStop() {
        AppMethodBeat.i(4906);
        this.sWV.cLI();
        this.sWU.cLI();
        super.onStop();
        AppMethodBeat.o(4906);
    }

    public void onStart() {
        AppMethodBeat.i(4907);
        this.sWV.taA = true;
        this.sWU.taA = true;
        super.onStart();
        AppMethodBeat.o(4907);
    }

    /* Access modifiers changed, original: protected|final */
    public final void abY(String str) {
        AppMethodBeat.i(4908);
        if (this.sXf != null) {
            this.sXf.setVisibility(0);
            this.sXf.setText(str);
        }
        AppMethodBeat.o(4908);
    }

    /* Access modifiers changed, original: protected|final */
    public final void fZ(int i, int i2) {
        AppMethodBeat.i(4909);
        if (this.sXe == null) {
            AppMethodBeat.o(4909);
            return;
        }
        this.sXe.setText(i);
        this.sXe.setVisibility(0);
        this.sXe.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
        this.sXe.setBackgroundResource(R.drawable.bk3);
        this.sXe.setCompoundDrawables(null, null, null, null);
        this.sXe.setCompoundDrawablePadding(0);
        this.iGP.removeCallbacks(this.lmq);
        if (-1 != i2) {
            this.iGP.postDelayed(this.lmq, (long) i2);
        }
        AppMethodBeat.o(4909);
    }

    /* Access modifiers changed, original: protected|final */
    public final void mz(boolean z) {
        AppMethodBeat.i(4910);
        if (this.nGB != null) {
            if (z) {
                this.nGB.setText(R.string.gaq);
            } else {
                this.nGB.setText(R.string.gap);
            }
            this.nGB.clearAnimation();
            this.nGB.setVisibility(0);
        }
        AppMethodBeat.o(4910);
    }

    /* Access modifiers changed, original: protected|final */
    public final void cKY() {
        AppMethodBeat.i(4911);
        if (this.nGB != null) {
            this.nGB.clearAnimation();
            this.nGB.setVisibility(8);
        }
        AppMethodBeat.o(4911);
    }

    public final void cKZ() {
        AppMethodBeat.i(4912);
        this.sWS.setLayoutParams(new LayoutParams(-1, -1));
        MovableVideoView movableVideoView = (MovableVideoView) this.sWT;
        ab.i("MicroMsg.MovableVideoView", "refrsh view %s, %s", Integer.valueOf(movableVideoView.mWidth), Integer.valueOf(movableVideoView.sZX));
        movableVideoView.mScreenWidth = 0;
        movableVideoView.ga(movableVideoView.mWidth, movableVideoView.sZX);
        AppMethodBeat.o(4912);
    }

    private void cLf() {
        AppMethodBeat.i(4913);
        this.sWS.setVisibility(0);
        if (this.sWr != null) {
            cLb();
        }
        this.sWW.setVisibility(0);
        this.sWY.setVisibility(0);
        if (!ad.aox(this.edV) || bo.ac(this.sWZ.getText())) {
            this.sWZ.setVisibility(8);
        } else {
            this.sWZ.setVisibility(0);
        }
        this.sXa.setText(R.string.f62);
        this.sXc.setVisibility(0);
        this.sWX.setVisibility(0);
        this.sWv.a(this.sXb, sWo);
        this.sXq.setVisibility(8);
        this.sXp.setVisibility(8);
        this.sXl.setVisibility(8);
        this.sXo.setVisibility(8);
        this.sXn.setVisibility(0);
        this.sXk.setVisibility(0);
        this.sXm.setVisibility(0);
        this.sXj.setVisibility(8);
        if (this.sXL) {
            this.sXi.setVisibility(0);
        }
        this.sXf.setVisibility(8);
        if (com.tencent.mm.plugin.voip.b.cIj().sRK != null) {
            this.sXf.setVisibility(0);
            this.sXf.setText(com.tencent.mm.plugin.voip.b.cIj().sRK);
        }
        AppMethodBeat.o(4913);
    }

    private void cLg() {
        AppMethodBeat.i(4914);
        this.sXc.setVisibility(0);
        this.sWS.setVisibility(0);
        this.sXa.setText(R.string.f60);
        if (!ad.aox(this.edV) || bo.ac(this.sWZ.getText())) {
            this.sWZ.setVisibility(8);
        } else {
            this.sWZ.setVisibility(0);
        }
        this.sWq.setVisibility(8);
        this.sXe.setVisibility(8);
        this.sXf.setVisibility(8);
        if (com.tencent.mm.plugin.voip.b.cIj().sRK != null) {
            this.sXf.setVisibility(0);
            this.sXf.setText(com.tencent.mm.plugin.voip.b.cIj().sRK);
        }
        this.sWv.a(this.sXb, sWo);
        this.sXq.setVisibility(8);
        this.sXp.setVisibility(8);
        this.sXl.setVisibility(0);
        this.sXo.setVisibility(8);
        this.sXn.setVisibility(8);
        this.sXk.setVisibility(8);
        this.sXm.setVisibility(8);
        this.sXj.setVisibility(0);
        this.sXi.setVisibility(8);
        AppMethodBeat.o(4914);
    }

    private void cLh() {
        boolean z = true;
        AppMethodBeat.i(4915);
        if (this.sWr != null) {
            this.sWr.setVisibility(8);
        }
        if (this.sWT.getVisibility() == 0) {
            AppMethodBeat.o(4915);
            return;
        }
        boolean z2;
        if (this.sRm) {
            this.sXI = !this.sXI;
            if (this.sXI) {
                z2 = false;
            } else {
                z2 = true;
            }
            Point mA = mA(z2);
            this.sWT.gc(mA.x, mA.y);
        } else {
            if (this.sXI) {
                z2 = false;
            } else {
                z2 = true;
            }
            this.sXI = z2;
            this.sXx.setVisibility(8);
        }
        if (ae.gjk) {
            this.sXr.setVisibility(0);
            this.sXs.setVisibility(0);
            this.sXt.setVisibility(0);
            this.sXu.setVisibility(0);
            this.sXv.setVisibility(0);
            this.sXw.setVisibility(0);
        }
        this.sWW.setVisibility(8);
        this.sWS.setVisibility(0);
        this.sWT.setVisibility(0);
        this.sXP.setVisibility(0);
        this.sXd.setVisibility(0);
        this.sXh.setVisibility(0);
        this.sXq.setVisibility(0);
        this.sXp.setVisibility(0);
        this.sXl.setVisibility(8);
        this.sXo.setVisibility(0);
        this.sXn.setVisibility(8);
        this.sXk.setVisibility(8);
        this.sXm.setVisibility(8);
        this.sXj.setVisibility(8);
        this.sXi.setVisibility(8);
        setHWDecMode(this.sXS);
        ab.d("MicroMsg.Voip.VoipVideoFragment", "steve: showVideoTalking decMode:%d", Integer.valueOf(this.sXS));
        if (this.sXI) {
            z = false;
        }
        Point mA2 = mA(z);
        ((MovableVideoView) this.sWT).ga(mA2.x, mA2.y);
        arh();
        if (ah.doB().getBoolean("voipfaceDebug", false)) {
            this.sXz.setVisibility(0);
            this.sXA.setVisibility(0);
        }
        cLe();
        if (this.sWs == 4102) {
            fZ(R.string.f3n, Downloads.MIN_WAIT_FOR_NETWORK);
        }
        AppMethodBeat.o(4915);
    }

    public final void a(byte[] bArr, long j, int i, int i2, int i3, int i4, int i5, int i6) {
        AppMethodBeat.i(4916);
        if (this.sXK) {
            if (OpenGlRender.taQ == 1) {
                if (this.sYm < i * i2) {
                    this.oHc = null;
                }
                if (this.oHc == null) {
                    this.sYm = i * i2;
                    this.oHc = new int[this.sYm];
                }
                if (com.tencent.mm.plugin.voip.b.cIj().a(bArr, (int) j, i3 & 31, i, i2, this.oHc, true) < 0 || this.oHc == null) {
                    AppMethodBeat.o(4916);
                    return;
                } else if (this.sXI) {
                    this.sWU.a(this.oHc, i, i2, (OpenGlRender.FLAG_RGBAClip + i4) + i5, true);
                } else {
                    this.sWV.a(this.oHc, i, i2, (OpenGlRender.FLAG_RGBAClip + i4) + i5, true);
                }
            } else if (OpenGlRender.taQ == 2) {
                if (this.sXI) {
                    this.sWU.c(bArr, i, i2, (OpenGlRender.FLAG_NV21 + i4) + i5, true);
                } else {
                    this.sWV.c(bArr, i, i2, (OpenGlRender.FLAG_NV21 + i4) + i5, true);
                }
            }
            this.sXD++;
            if (i6 > 0) {
                this.sXC++;
            }
            f fVar = this.sXy;
            fVar.sZZ = i;
            fVar.taa = i2;
            fVar = this.sXy;
            int width = this.sWp.getWidth();
            int height = this.sWp.getHeight();
            fVar.sZY = width;
            fVar.np = height;
            AppMethodBeat.o(4916);
            return;
        }
        AppMethodBeat.o(4916);
    }

    public final void setHWDecMode(int i) {
        AppMethodBeat.i(4917);
        int i2 = i & 1;
        if (this.iGP != null) {
            ab.i("MicroMsg.Voip.VoipVideoFragment", "setHWDecMode, hwdec: %s", Boolean.valueOf(i2 != 0));
            if (i2 != 0) {
                ab.i("MicroMsg.Voip.VoipVideoFragment", "use hw texture");
                this.iGP.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(4880);
                        if (VoipVideoFragment.this.sXI) {
                            if (VoipVideoFragment.this.sXR) {
                                VoipVideoFragment.this.sXQ.setVisibility(4);
                                VoipVideoFragment.this.sXP.setVisibility(0);
                                ab.i("MicroMsg.Voip.VoipVideoFragment", "steve: change to big hw texture view!");
                                LayoutParams layoutParams = new LayoutParams(-1, -2);
                                layoutParams.addRule(13);
                                int indexOfChild = VoipVideoFragment.this.sWp.indexOfChild(VoipVideoFragment.this.sWS);
                                VoipVideoFragment.this.sWp.removeView(VoipVideoFragment.this.sXQ);
                                VoipVideoFragment.this.sWp.addView(VoipVideoFragment.this.sXP, indexOfChild + 1, layoutParams);
                                ((c) VoipVideoFragment.this.sVY.get()).b(VoipVideoFragment.this.sXP);
                            }
                            VoipVideoFragment.this.sWS.setVisibility(4);
                            VoipVideoFragment.this.sWT.setVisibility(0);
                            VoipVideoFragment.q(VoipVideoFragment.this);
                            VoipVideoFragment.this.sXP.setVisibility(0);
                            ab.i("MicroMsg.Voip.VoipVideoFragment", "set big hw view visible");
                            VoipVideoFragment.this.sXR = false;
                            AppMethodBeat.o(4880);
                            return;
                        }
                        if (!VoipVideoFragment.this.sXR) {
                            VoipVideoFragment.this.sXP.setVisibility(4);
                            VoipVideoFragment.this.sWp.removeView(VoipVideoFragment.this.sXP);
                            VoipVideoFragment.this.sWp.addView(VoipVideoFragment.this.sXQ);
                            ((c) VoipVideoFragment.this.sVY.get()).b(VoipVideoFragment.this.sXQ);
                        }
                        VoipVideoFragment.this.sWT.setVisibility(4);
                        VoipVideoFragment.this.sXQ.setVisibility(0);
                        ab.i("MicroMsg.Voip.VoipVideoFragment", "set big hw view visible");
                        VoipVideoFragment.this.sXQ.bringToFront();
                        VoipVideoFragment.this.sWS.setVisibility(0);
                        VoipVideoFragment.this.sXR = true;
                        AppMethodBeat.o(4880);
                    }
                });
            } else {
                this.iGP.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(4879);
                        VoipVideoFragment.this.sXP.setVisibility(4);
                        VoipVideoFragment.this.sXQ.setVisibility(4);
                        VoipVideoFragment.this.sWT.setVisibility(0);
                        VoipVideoFragment.this.sWT.bringToFront();
                        VoipVideoFragment.this.sWS.setVisibility(0);
                        AppMethodBeat.o(4879);
                    }
                });
            }
        }
        this.sXS = i;
        AppMethodBeat.o(4917);
    }

    public final OpenGlRender getFilterData() {
        if (this.sXI) {
            return this.sWU;
        }
        return this.sWV;
    }

    public final void c(int i, int i2, int[] iArr) {
        AppMethodBeat.i(4918);
        if (this.sXK) {
            this.sXE++;
            if (OpenGlRender.taQ == 1) {
                if (this.sXI) {
                    this.sWV.a(iArr, i, i2, OpenGlRender.FLAG_RGBAClip + OpenGlRender.FLAG_Angle90, false);
                    AppMethodBeat.o(4918);
                    return;
                }
                this.sWU.a(iArr, i, i2, OpenGlRender.FLAG_RGBAClip + OpenGlRender.FLAG_Angle90, false);
                AppMethodBeat.o(4918);
                return;
            } else if (this.sXI) {
                this.sWV.a(iArr, i, i2, OpenGlRender.FLAG_YV12Edge + OpenGlRender.FLAG_Angle90, false);
                AppMethodBeat.o(4918);
                return;
            } else {
                this.sWU.a(iArr, i, i2, OpenGlRender.FLAG_YV12Edge + OpenGlRender.FLAG_Angle90, false);
                AppMethodBeat.o(4918);
                return;
            }
        }
        AppMethodBeat.o(4918);
    }

    public final void cJD() {
        AppMethodBeat.i(4919);
        if (this.sXK) {
            this.sWV.cLJ();
            this.sWU.cLJ();
            AppMethodBeat.o(4919);
            return;
        }
        AppMethodBeat.o(4919);
    }

    public final void setVoipBeauty(int i) {
        AppMethodBeat.i(4920);
        ab.i("MicroMsg.Voip.VoipVideoFragment", "setVoipBeauty isON:%d, mInitDone:%b", Integer.valueOf(i), Boolean.valueOf(this.sXK));
        this.sXT = i;
        if (this.sXK) {
            this.sWV.setVoipBeauty(this.sXT);
            this.sWU.setVoipBeauty(this.sXT);
            AppMethodBeat.o(4920);
            return;
        }
        AppMethodBeat.o(4920);
    }

    private void cLi() {
        AppMethodBeat.i(4921);
        this.sXa.setText(R.string.f7s);
        this.sWv.a(this.sXb, sWo);
        AppMethodBeat.o(4921);
    }

    private void GD(int i) {
        AppMethodBeat.i(4922);
        this.sWv.cLc();
        this.sXl.setEnabled(false);
        this.sXp.setEnabled(false);
        this.sXo.setEnabled(false);
        this.sXn.setEnabled(false);
        this.sXm.setEnabled(false);
        this.sXk.setEnabled(false);
        this.sXq.setEnabled(false);
        this.sXj.setEnabled(false);
        this.sXi.setEnabled(false);
        switch (i) {
            case 4105:
                this.sXe.setVisibility(0);
                this.sXe.setText(R.string.f6e);
                break;
        }
        if (this.sWu != null) {
            this.sWu.S(true, false);
        }
        AppMethodBeat.o(4922);
    }

    private void arh() {
        AppMethodBeat.i(4923);
        if (this.mTimer == null || this.sXJ) {
            AppMethodBeat.o(4923);
            return;
        }
        if (-1 == this.sVZ) {
            this.sVZ = bo.anT();
        }
        this.sXM = this.sVZ;
        this.sXJ = true;
        this.mTimer.schedule(new TimerTask() {
            public final void run() {
                AppMethodBeat.i(4883);
                VoipVideoFragment.this.iGP.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(4882);
                        VoipVideoFragment.this.sXd.setText(VoipBaseFragment.fQ(bo.fp(VoipVideoFragment.this.sVZ)));
                        VoipVideoFragment.z(VoipVideoFragment.this);
                        AppMethodBeat.o(4882);
                    }
                });
                AppMethodBeat.o(4883);
            }
        }, 1000, 1000);
        this.sXW = com.tencent.mm.sdk.g.d.anM("VoipVideoFragment_cpuStatThread");
        this.sXW.start();
        this.sXX = new ap(this.sXW.getLooper(), new com.tencent.mm.sdk.platformtools.ap.a() {
            public final boolean BI() {
                AppMethodBeat.i(4884);
                if (VoipVideoFragment.this.sXY) {
                    VoipVideoFragment.B(VoipVideoFragment.this);
                    AppMethodBeat.o(4884);
                    return true;
                }
                AppMethodBeat.o(4884);
                return false;
            }
        }, true);
        this.sXY = true;
        this.sXX.ae(1000, 1000);
        AppMethodBeat.o(4923);
    }

    private void cLj() {
        AppMethodBeat.i(4924);
        this.sWp.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                int i;
                boolean z = false;
                AppMethodBeat.i(4885);
                com.tencent.mm.plugin.report.service.h.pYm.e(11079, Integer.valueOf(4));
                if (!(VoipVideoFragment.this.sXI || VoipVideoFragment.this.sVY.get() == null)) {
                    VoipVideoFragment.this.sXq.getVisibility();
                }
                if (VoipVideoFragment.this.sXq.getVisibility() == 0) {
                    i = 4;
                } else {
                    boolean i2 = false;
                }
                int i3 = i2 == 0 ? 0 : 8;
                VoipVideoFragment.this.sXq.setVisibility(i3);
                VoipVideoFragment.this.sXh.setVisibility(i3);
                VoipVideoFragment.this.sXd.setVisibility(i3);
                VoipVideoFragment.this.sXo.setVisibility(i3);
                VoipVideoFragment.this.sXp.setVisibility(i3);
                VoipVideoFragment voipVideoFragment = VoipVideoFragment.this;
                if (i3 == 0) {
                    z = true;
                }
                VoipVideoFragment.e(voipVideoFragment, z);
                if (ae.gjk) {
                    VoipVideoFragment.this.sXr.setVisibility(i3);
                    VoipVideoFragment.this.sXs.setVisibility(i3);
                    VoipVideoFragment.this.sXt.setVisibility(i3);
                    VoipVideoFragment.this.sXu.setVisibility(i3);
                    VoipVideoFragment.this.sXv.setVisibility(i3);
                    VoipVideoFragment.this.sXw.setVisibility(i3);
                }
                if (i2 == 0) {
                    VoipVideoFragment.u(VoipVideoFragment.this);
                }
                AppMethodBeat.o(4885);
            }
        });
        AppMethodBeat.o(4924);
    }

    private void b(CaptureView captureView) {
        AppMethodBeat.i(4925);
        if (this.sWp == null || captureView == null) {
            AppMethodBeat.o(4925);
            return;
        }
        this.sWp.removeView(this.sRg);
        this.sRg = null;
        this.sRg = captureView;
        this.sWp.addView(captureView, new LayoutParams(1, 1));
        this.sRg.setVisibility(0);
        this.sRg.setAlpha(0.0f);
        ab.d("MicroMsg.Voip.VoipVideoFragment", "CaptureView added");
        AppMethodBeat.o(4925);
    }

    public final void cKT() {
        AppMethodBeat.i(4926);
        if (this.sRg != null) {
            this.sWp.removeView(this.sRg);
            this.sWp.addView(this.sRg, new LayoutParams(1, 1));
            this.sRg.setVisibility(0);
            this.sRg.setAlpha(0.0f);
            ab.i("MicroMsg.Voip.VoipVideoFragment", "resetCaptureView");
        }
        AppMethodBeat.o(4926);
    }

    public void onDetach() {
        AppMethodBeat.i(4927);
        ab.i("MicroMsg.Voip.VoipVideoFragment", "onDetach");
        if (this.mTimer != null) {
            this.mTimer.cancel();
            this.mTimer = null;
        }
        if (!(this.sXX == null || this.sXW == null)) {
            this.sXX.stopTimer();
            this.sXW.quit();
        }
        this.sXY = false;
        super.onDetach();
        AppMethodBeat.o(4927);
    }

    public final void GC(int i) {
    }

    private Point mA(boolean z) {
        AppMethodBeat.i(4928);
        int height = (int) (((double) getActivity().getWindowManager().getDefaultDisplay().getHeight()) / 5.0d);
        float f = (float) height;
        com.tencent.mm.plugin.voip.b.cIj();
        Point point = new Point((int) (f * r.mw(z)), height);
        AppMethodBeat.o(4928);
        return point;
    }

    static /* synthetic */ void c(VoipVideoFragment voipVideoFragment) {
        AppMethodBeat.i(4929);
        ab.i("MicroMsg.Voip.VoipVideoFragment", "accept video invite use voice");
        com.tencent.mm.plugin.report.service.h.pYm.a(11526, true, true, Integer.valueOf(com.tencent.mm.plugin.voip.b.cIj().cJZ()), Long.valueOf(com.tencent.mm.plugin.voip.b.cIj().cKa()), Long.valueOf(com.tencent.mm.plugin.voip.b.cIj().cIK()), Integer.valueOf(3));
        if (!(voipVideoFragment.sVY == null || voipVideoFragment.sVY.get() == null || !((c) voipVideoFragment.sVY.get()).cJl())) {
            voipVideoFragment.sXk.setEnabled(false);
            voipVideoFragment.sXn.setEnabled(false);
            voipVideoFragment.sXm.setEnabled(false);
            voipVideoFragment.sXa.setText(R.string.f7s);
            voipVideoFragment.sWv.a(voipVideoFragment.sXb, sWo);
        }
        AppMethodBeat.o(4929);
    }

    static /* synthetic */ void d(VoipVideoFragment voipVideoFragment) {
        AppMethodBeat.i(4930);
        ab.i("MicroMsg.Voip.VoipVideoFragment", "reject video invite");
        com.tencent.mm.plugin.report.service.h.pYm.a(11526, true, true, Integer.valueOf(com.tencent.mm.plugin.voip.b.cIj().cJZ()), Long.valueOf(com.tencent.mm.plugin.voip.b.cIj().cKa()), Long.valueOf(com.tencent.mm.plugin.voip.b.cIj().cIK()), Integer.valueOf(4));
        if (!(voipVideoFragment.sVY == null || voipVideoFragment.sVY.get() == null || !((c) voipVideoFragment.sVY.get()).cJm())) {
            voipVideoFragment.fZ(R.string.f6q, -1);
            voipVideoFragment.sXm.setEnabled(false);
            voipVideoFragment.sXn.setEnabled(false);
            voipVideoFragment.sXk.setEnabled(false);
        }
        AppMethodBeat.o(4930);
    }

    static /* synthetic */ void e(VoipVideoFragment voipVideoFragment) {
        AppMethodBeat.i(4931);
        ab.i("MicroMsg.Voip.VoipVideoFragment", "accept video invite");
        com.tencent.mm.plugin.report.service.h.pYm.a(11526, true, true, Integer.valueOf(com.tencent.mm.plugin.voip.b.cIj().cJZ()), Long.valueOf(com.tencent.mm.plugin.voip.b.cIj().cKa()), Long.valueOf(com.tencent.mm.plugin.voip.b.cIj().cIK()), Integer.valueOf(1));
        if (!(voipVideoFragment.sVY == null || voipVideoFragment.sVY.get() == null || !((c) voipVideoFragment.sVY.get()).cJn())) {
            voipVideoFragment.sXn.setEnabled(false);
            voipVideoFragment.sXm.setEnabled(false);
            voipVideoFragment.sXk.setEnabled(false);
            voipVideoFragment.sXl.setVisibility(8);
        }
        AppMethodBeat.o(4931);
    }

    static /* synthetic */ void q(VoipVideoFragment voipVideoFragment) {
        AppMethodBeat.i(4933);
        ab.i("MicroMsg.Voip.VoipVideoFragment", "setBigHwTextureViewParam");
        ViewGroup.LayoutParams layoutParams = voipVideoFragment.sXP.getLayoutParams();
        layoutParams.width = -1;
        layoutParams.height = -1;
        voipVideoFragment.sXP.setLayoutParams(layoutParams);
        AppMethodBeat.o(4933);
    }

    static /* synthetic */ void e(VoipVideoFragment voipVideoFragment, boolean z) {
        AppMethodBeat.i(4935);
        if (z) {
            voipVideoFragment.getActivity().getWindow().clearFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
            AppMethodBeat.o(4935);
            return;
        }
        voipVideoFragment.getActivity().getWindow().setFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
        AppMethodBeat.o(4935);
    }

    static /* synthetic */ void z(VoipVideoFragment voipVideoFragment) {
        AppMethodBeat.i(4936);
        r cIj = com.tencent.mm.plugin.voip.b.cIj();
        int i = voipVideoFragment.sXD;
        int i2 = voipVideoFragment.sXV;
        m mVar = cIj.sSP.sNl.sPr;
        mVar.sNl.sPp.sVc = i;
        mVar.sNl.sPp.sVd = i2;
        if (ae.gjk) {
            long anT = bo.anT();
            int i3 = (int) (anT - voipVideoFragment.sXM);
            if (i3 <= 1) {
                i3 = 1;
            }
            String format = String.format(Locale.US, "Capt: %d,CPU:%d,vP:%d", new Object[]{Integer.valueOf(voipVideoFragment.sXD), Integer.valueOf(voipVideoFragment.sXV), Integer.valueOf(voipVideoFragment.sXT)});
            String format2 = String.format(Locale.US, "Send Fps: %d", new Object[]{Integer.valueOf(voipVideoFragment.sXC)});
            String format3 = String.format(Locale.US, "Recv Fps: %d", new Object[]{Integer.valueOf(voipVideoFragment.sXE)});
            int i4 = com.tencent.mm.plugin.voip.b.cIj().sSP.sNl.sPr.sNl.sPp.field_sendVideoLen;
            int i5 = com.tencent.mm.plugin.voip.b.cIj().sSP.sNl.sPr.sNl.sPp.field_recvVideoLen;
            voipVideoFragment.sXF = (int) ((((double) (i4 - voipVideoFragment.sXF)) * 8.0d) / ((double) (i3 * 1000)));
            voipVideoFragment.sXG = (int) ((((double) (i5 - voipVideoFragment.sXG)) * 8.0d) / ((double) (i3 * 1000)));
            i3 = (voipVideoFragment.sXS >> 8) != 0 ? 1 : 0;
            i = (voipVideoFragment.sXS & 255) != 0 ? 1 : 0;
            String format4 = String.format(Locale.US, "Tx:%d, HWEnc:%d", new Object[]{Integer.valueOf(voipVideoFragment.sXF), Integer.valueOf(i3)});
            String format5 = String.format(Locale.US, "Rx:%d, HWDec:%d", new Object[]{Integer.valueOf(voipVideoFragment.sXG), Integer.valueOf(i)});
            byte[] bArr = com.tencent.mm.plugin.voip.b.cIj().sSP.sNl.sPp.sVe;
            if (bArr != null) {
                try {
                    voipVideoFragment.sXw.setText(new String(bArr, "UTF-8"));
                } catch (UnsupportedEncodingException e) {
                    ab.printErrStackTrace("MicroMsg.Voip.VoipVideoFragment", e, "", new Object[0]);
                }
            }
            voipVideoFragment.sXr.setText(format);
            voipVideoFragment.sXs.setText(format2);
            voipVideoFragment.sXt.setText(format3);
            voipVideoFragment.sXv.setText(format5);
            voipVideoFragment.sXu.setText(format4);
            voipVideoFragment.sXF = i4;
            voipVideoFragment.sXG = i5;
            voipVideoFragment.sXM = anT;
        }
        voipVideoFragment.sXD = 0;
        voipVideoFragment.sXC = 0;
        voipVideoFragment.sXE = 0;
        AppMethodBeat.o(4936);
    }

    static /* synthetic */ void B(VoipVideoFragment voipVideoFragment) {
        AppMethodBeat.i(4937);
        boolean cKc = com.tencent.mm.plugin.voip.b.cIj().cKc();
        int i = voipVideoFragment.sXU;
        voipVideoFragment.sXU = i + 1;
        if (i % 5 == 0 && cKc) {
            int LI = com.tencent.mm.compatible.e.q.eto.LI();
            ab.d("MicroMsg.Voip.VoipVideoFragment", "devincdai: cpu_usage = ".concat(String.valueOf(LI)));
            voipVideoFragment.sXV = LI;
        }
        AppMethodBeat.o(4937);
    }
}
