package com.tencent.p177mm.plugin.voip.p546ui;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.compatible.p221e.C1427q;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1854s;
import com.tencent.p177mm.openim.room.p266a.C42249a;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p612ui.base.C23639t;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.MMTextureView;
import com.tencent.p177mm.platformtools.C1947ae;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.voip.C43727b;
import com.tencent.p177mm.plugin.voip.model.C14055q;
import com.tencent.p177mm.plugin.voip.model.C14058r;
import com.tencent.p177mm.plugin.voip.model.C40031m;
import com.tencent.p177mm.plugin.voip.p1417a.C29488d;
import com.tencent.p177mm.plugin.voip.p1417a.C40025b;
import com.tencent.p177mm.plugin.voip.video.C29512f;
import com.tencent.p177mm.plugin.voip.video.CaptureView;
import com.tencent.p177mm.plugin.voip.video.MovableTextureView;
import com.tencent.p177mm.plugin.voip.video.MovableVideoView;
import com.tencent.p177mm.plugin.voip.video.OpenGlRender;
import com.tencent.p177mm.plugin.voip.video.OpenGlView;
import com.tencent.p177mm.plugin.voip.widget.VoIPVideoView;
import com.tencent.p177mm.pluginsdk.p597ui.C40459a.C40460b;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.BackwardSupportUtil.C4977b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5023at;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7564ap;
import com.tencent.p177mm.sdk.platformtools.C7564ap.C5015a;
import com.tencent.p177mm.storage.C7616ad;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import com.tencent.ttpic.thread.FaceGestureDetGLThread;
import com.tencent.view.C31128d;
import java.io.UnsupportedEncodingException;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;

/* renamed from: com.tencent.mm.plugin.voip.ui.VoipVideoFragment */
public class VoipVideoFragment extends VoipBaseFragment {
    private long iBO = 0;
    private Runnable lmq = new C353709();
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
    private C35371a sXO;
    public MMTextureView sXP;
    public MMTextureView sXQ;
    private boolean sXR = false;
    public int sXS = 0;
    public int sXT = 0;
    private int sXU = 0;
    private int sXV = 0;
    private HandlerThread sXW = null;
    private C7564ap sXX = null;
    private boolean sXY = false;
    private OnClickListener sXZ = new C295041();
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
    private C29512f sXy = null;
    private Button sXz = null;
    private OnClickListener sYa = new C3537212();
    private OnClickListener sYb = new C1407316();
    private OnClickListener sYc = new C1407417();
    private OnClickListener sYd = new C1407718();
    private OnClickListener sYe = new C3537319();
    private OnClickListener sYf = new C1408020();
    private OnClickListener sYg = new C2950521();
    private OnClickListener sYh = new C1408122();
    private OnClickListener sYi = new C295062();
    private OnClickListener sYj = new C295073();
    private OnClickListener sYk = new C353687();
    private Runnable sYl = new C353698();
    int sYm = 0;

    /* renamed from: com.tencent.mm.plugin.voip.ui.VoipVideoFragment$15 */
    class C1407215 implements OnClickListener {
        C1407215() {
        }

        public final void onClick(View view) {
            int i;
            boolean z = false;
            AppMethodBeat.m2504i(4885);
            C7060h.pYm.mo8381e(11079, Integer.valueOf(4));
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
            VoipVideoFragment.m58050e(voipVideoFragment, z);
            if (C1947ae.gjk) {
                VoipVideoFragment.this.sXr.setVisibility(i3);
                VoipVideoFragment.this.sXs.setVisibility(i3);
                VoipVideoFragment.this.sXt.setVisibility(i3);
                VoipVideoFragment.this.sXu.setVisibility(i3);
                VoipVideoFragment.this.sXv.setVisibility(i3);
                VoipVideoFragment.this.sXw.setVisibility(i3);
            }
            if (i2 == 0) {
                VoipVideoFragment.m58067u(VoipVideoFragment.this);
            }
            AppMethodBeat.m2505o(4885);
        }
    }

    /* renamed from: com.tencent.mm.plugin.voip.ui.VoipVideoFragment$16 */
    class C1407316 implements OnClickListener {
        C1407316() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(4886);
            if (!(VoipVideoFragment.this.sVY == null || VoipVideoFragment.this.sVY.get() == null)) {
                ((C46324c) VoipVideoFragment.this.sVY.get()).cJw();
            }
            AppMethodBeat.m2505o(4886);
        }
    }

    /* renamed from: com.tencent.mm.plugin.voip.ui.VoipVideoFragment$17 */
    class C1407417 implements OnClickListener {

        /* renamed from: com.tencent.mm.plugin.voip.ui.VoipVideoFragment$17$1 */
        class C140751 implements DialogInterface.OnClickListener {
            C140751() {
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.m2504i(4887);
                C14055q.cJU();
                VoipVideoFragment.m58045c(VoipVideoFragment.this);
                AppMethodBeat.m2505o(4887);
            }
        }

        /* renamed from: com.tencent.mm.plugin.voip.ui.VoipVideoFragment$17$2 */
        class C140762 implements DialogInterface.OnClickListener {
            C140762() {
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.m2504i(4888);
                VoipVideoFragment.m58048d(VoipVideoFragment.this);
                AppMethodBeat.m2505o(4888);
            }
        }

        C1407417() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(4889);
            C4990ab.m7416i("MicroMsg.Voip.VoipVideoFragment", "click accept video invite use voice button");
            if (C5023at.isWifi(VoipVideoFragment.this.getActivity()) || C14055q.cJV()) {
                VoipVideoFragment.m58045c(VoipVideoFragment.this);
                AppMethodBeat.m2505o(4889);
                return;
            }
            C30379h.m48432a(VoipVideoFragment.this.getActivity(), (int) C25738R.string.f6f, (int) C25738R.string.f6g, new C140751(), new C140762());
            AppMethodBeat.m2505o(4889);
        }
    }

    /* renamed from: com.tencent.mm.plugin.voip.ui.VoipVideoFragment$18 */
    class C1407718 implements OnClickListener {

        /* renamed from: com.tencent.mm.plugin.voip.ui.VoipVideoFragment$18$2 */
        class C140782 implements DialogInterface.OnClickListener {
            C140782() {
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.m2504i(4891);
                VoipVideoFragment.m58048d(VoipVideoFragment.this);
                AppMethodBeat.m2505o(4891);
            }
        }

        /* renamed from: com.tencent.mm.plugin.voip.ui.VoipVideoFragment$18$1 */
        class C140791 implements DialogInterface.OnClickListener {
            C140791() {
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.m2504i(4890);
                if (!C5023at.is2G(VoipVideoFragment.this.getActivity())) {
                    C14055q.cJU();
                }
                VoipVideoFragment.m58049e(VoipVideoFragment.this);
                AppMethodBeat.m2505o(4890);
            }
        }

        C1407718() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(4892);
            C4990ab.m7416i("MicroMsg.Voip.VoipVideoFragment", "click accept video invite button");
            if (C5023at.isWifi(VoipVideoFragment.this.getActivity()) || (C14055q.cJV() && !C5023at.is2G(VoipVideoFragment.this.getActivity()))) {
                VoipVideoFragment.m58049e(VoipVideoFragment.this);
                AppMethodBeat.m2505o(4892);
                return;
            }
            C30379h.m48432a(VoipVideoFragment.this.getActivity(), (int) C25738R.string.f6f, (int) C25738R.string.f6g, new C140791(), new C140782());
            AppMethodBeat.m2505o(4892);
        }
    }

    /* renamed from: com.tencent.mm.plugin.voip.ui.VoipVideoFragment$20 */
    class C1408020 implements OnClickListener {
        C1408020() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(4894);
            C4990ab.m7416i("MicroMsg.Voip.VoipVideoFragment", "click cancel video invite button");
            if (!(VoipVideoFragment.this.sVY == null || VoipVideoFragment.this.sVY.get() == null || !((C46324c) VoipVideoFragment.this.sVY.get()).cJr())) {
                VoipVideoFragment.this.sXp.setEnabled(false);
                VoipVideoFragment.this.sXl.setEnabled(false);
                VoipVideoFragment.this.sXe.setVisibility(0);
                VoipVideoFragment.this.sXe.setText(C25738R.string.f4f);
            }
            AppMethodBeat.m2505o(4894);
        }
    }

    /* renamed from: com.tencent.mm.plugin.voip.ui.VoipVideoFragment$22 */
    class C1408122 implements OnClickListener {
        C1408122() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(4896);
            C7060h.pYm.mo8381e(11619, Integer.valueOf(2));
            if (!(VoipVideoFragment.this.sVY == null || VoipVideoFragment.this.sVY.get() == null)) {
                ((C46324c) VoipVideoFragment.this.sVY.get()).cJL();
            }
            AppMethodBeat.m2505o(4896);
        }
    }

    /* renamed from: com.tencent.mm.plugin.voip.ui.VoipVideoFragment$5 */
    class C140825 implements OnClickListener {
        C140825() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(4874);
            C4990ab.m7416i("MicroMsg.Voip.VoipVideoFragment", "steve: hwTxtureViewSmall clicked!");
            if (VoipVideoFragment.this.sXR) {
                boolean z;
                VoipVideoFragment.this.sXI = !VoipVideoFragment.this.sXI;
                VoipVideoFragment voipVideoFragment = VoipVideoFragment.this;
                if (VoipVideoFragment.this.sXI) {
                    z = false;
                } else {
                    z = true;
                }
                Point d = VoipVideoFragment.m58047d(voipVideoFragment, z);
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
                VoipVideoFragment.m58063q(VoipVideoFragment.this);
                VoipVideoFragment.this.sXP.setVisibility(0);
                VoipVideoFragment.this.sWT.setVisibility(0);
                C4990ab.m7416i("MicroMsg.Voip.VoipVideoFragment", "steve: change to big hw texture view!");
                LayoutParams layoutParams3 = new LayoutParams(-1, -2);
                layoutParams3.addRule(13);
                int indexOfChild = VoipVideoFragment.this.sWp.indexOfChild(VoipVideoFragment.this.sWS);
                VoipVideoFragment.this.sWp.removeView(VoipVideoFragment.this.sXQ);
                VoipVideoFragment.this.sWp.addView(VoipVideoFragment.this.sXP, indexOfChild + 1, layoutParams3);
                ((C46324c) VoipVideoFragment.this.sVY.get()).mo30882b(VoipVideoFragment.this.sXP);
                VoipVideoFragment.this.sXR = false;
                C7060h.pYm.mo8381e(11079, Integer.valueOf(3));
            }
            AppMethodBeat.m2505o(4874);
        }
    }

    /* renamed from: com.tencent.mm.plugin.voip.ui.VoipVideoFragment$1 */
    class C295041 implements OnClickListener {
        C295041() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(4870);
            C4990ab.m7416i("MicroMsg.Voip.VoipVideoFragment", "hangup video talking");
            if (!(VoipVideoFragment.this.sVY == null || VoipVideoFragment.this.sVY.get() == null || !((C46324c) VoipVideoFragment.this.sVY.get()).cJk())) {
                VoipVideoFragment.this.sXp.setEnabled(false);
                VoipVideoFragment.this.sXo.setEnabled(false);
                VoipVideoFragment.this.mo56114fZ(C25738R.string.f5m, -1);
            }
            AppMethodBeat.m2505o(4870);
        }
    }

    /* renamed from: com.tencent.mm.plugin.voip.ui.VoipVideoFragment$21 */
    class C2950521 implements OnClickListener {
        C2950521() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(4895);
            if (System.currentTimeMillis() - VoipVideoFragment.this.iBO <= 1000) {
                AppMethodBeat.m2505o(4895);
                return;
            }
            VoipVideoFragment.this.iBO = System.currentTimeMillis();
            C7060h.pYm.mo8381e(11618, Integer.valueOf(2), Integer.valueOf(1));
            if (!(VoipVideoFragment.this.sVY == null || VoipVideoFragment.this.sVY.get() == null)) {
                ((C46324c) VoipVideoFragment.this.sVY.get()).mo30913mv(true);
                if (VoipVideoFragment.this.sXR) {
                    VoipVideoFragment.this.sWp.removeView(VoipVideoFragment.this.sXQ);
                } else {
                    VoipVideoFragment.this.sWp.removeView(VoipVideoFragment.this.sXP);
                }
                VoipVideoFragment.this.sXR = false;
            }
            if (VoipVideoFragment.this.sWu != null) {
                VoipVideoFragment.this.cJD();
                VoipVideoFragment.this.sWu.mo63352S(false, true);
            }
            AppMethodBeat.m2505o(4895);
        }
    }

    /* renamed from: com.tencent.mm.plugin.voip.ui.VoipVideoFragment$2 */
    class C295062 implements OnClickListener {
        C295062() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(4871);
            VoipVideoFragment.this.sXB = !VoipVideoFragment.this.sXB;
            if (!VoipVideoFragment.this.sXB) {
                VoipVideoFragment.this.sXy.setVisibility(8);
            }
            Toast.makeText(VoipVideoFragment.this.getActivity(), String.format("mIsShowFaceRect:%b", new Object[]{Boolean.valueOf(VoipVideoFragment.this.sXB)}), 0).show();
            AppMethodBeat.m2505o(4871);
        }
    }

    /* renamed from: com.tencent.mm.plugin.voip.ui.VoipVideoFragment$3 */
    class C295073 implements OnClickListener {
        C295073() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(4872);
            boolean a = C5046bo.m7517a((Boolean) view.getTag(), false);
            view.setTag(Boolean.valueOf(!a));
            if (a) {
                VoipVideoFragment.this.sXy.setVisibility(8);
                Toast.makeText(VoipVideoFragment.this.getActivity(), "stop face detect", 0).show();
            } else {
                Toast.makeText(VoipVideoFragment.this.getActivity(), "start face detect", 0).show();
            }
            if (!(VoipVideoFragment.this.sVY == null || VoipVideoFragment.this.sVY.get() == null)) {
                ((C46324c) VoipVideoFragment.this.sVY.get()).cJM();
            }
            AppMethodBeat.m2505o(4872);
        }
    }

    /* renamed from: com.tencent.mm.plugin.voip.ui.VoipVideoFragment$4 */
    class C295084 implements OnClickListener {
        C295084() {
        }

        public final void onClick(View view) {
            boolean z;
            AppMethodBeat.m2504i(4873);
            VoipVideoFragment.this.sXI = !VoipVideoFragment.this.sXI;
            VoipVideoFragment voipVideoFragment = VoipVideoFragment.this;
            if (VoipVideoFragment.this.sXI) {
                z = false;
            } else {
                z = true;
            }
            Point d = VoipVideoFragment.m58047d(voipVideoFragment, z);
            VoipVideoFragment.this.sWT.mo26412gc(d.x, d.y);
            C4990ab.m7416i("MicroMsg.Voip.VoipVideoFragment", "steve: mGlSmallVideoView clicked!");
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
                    ((C46324c) VoipVideoFragment.this.sVY.get()).mo30882b(VoipVideoFragment.this.sXQ);
                    VoipVideoFragment.this.sXR = true;
                    C4990ab.m7416i("MicroMsg.Voip.VoipVideoFragment", "steve: change hw texture view!");
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
            C7060h.pYm.mo8381e(11079, Integer.valueOf(3));
            AppMethodBeat.m2505o(4873);
        }
    }

    /* renamed from: com.tencent.mm.plugin.voip.ui.VoipVideoFragment$10 */
    class C3536410 implements Runnable {
        C3536410() {
        }

        public final void run() {
            AppMethodBeat.m2504i(4879);
            VoipVideoFragment.this.sXP.setVisibility(4);
            VoipVideoFragment.this.sXQ.setVisibility(4);
            VoipVideoFragment.this.sWT.setVisibility(0);
            VoipVideoFragment.this.sWT.bringToFront();
            VoipVideoFragment.this.sWS.setVisibility(0);
            AppMethodBeat.m2505o(4879);
        }
    }

    /* renamed from: com.tencent.mm.plugin.voip.ui.VoipVideoFragment$11 */
    class C3536511 implements Runnable {
        C3536511() {
        }

        public final void run() {
            AppMethodBeat.m2504i(4880);
            if (VoipVideoFragment.this.sXI) {
                if (VoipVideoFragment.this.sXR) {
                    VoipVideoFragment.this.sXQ.setVisibility(4);
                    VoipVideoFragment.this.sXP.setVisibility(0);
                    C4990ab.m7416i("MicroMsg.Voip.VoipVideoFragment", "steve: change to big hw texture view!");
                    LayoutParams layoutParams = new LayoutParams(-1, -2);
                    layoutParams.addRule(13);
                    int indexOfChild = VoipVideoFragment.this.sWp.indexOfChild(VoipVideoFragment.this.sWS);
                    VoipVideoFragment.this.sWp.removeView(VoipVideoFragment.this.sXQ);
                    VoipVideoFragment.this.sWp.addView(VoipVideoFragment.this.sXP, indexOfChild + 1, layoutParams);
                    ((C46324c) VoipVideoFragment.this.sVY.get()).mo30882b(VoipVideoFragment.this.sXP);
                }
                VoipVideoFragment.this.sWS.setVisibility(4);
                VoipVideoFragment.this.sWT.setVisibility(0);
                VoipVideoFragment.m58063q(VoipVideoFragment.this);
                VoipVideoFragment.this.sXP.setVisibility(0);
                C4990ab.m7416i("MicroMsg.Voip.VoipVideoFragment", "set big hw view visible");
                VoipVideoFragment.this.sXR = false;
                AppMethodBeat.m2505o(4880);
                return;
            }
            if (!VoipVideoFragment.this.sXR) {
                VoipVideoFragment.this.sXP.setVisibility(4);
                VoipVideoFragment.this.sWp.removeView(VoipVideoFragment.this.sXP);
                VoipVideoFragment.this.sWp.addView(VoipVideoFragment.this.sXQ);
                ((C46324c) VoipVideoFragment.this.sVY.get()).mo30882b(VoipVideoFragment.this.sXQ);
            }
            VoipVideoFragment.this.sWT.setVisibility(4);
            VoipVideoFragment.this.sXQ.setVisibility(0);
            C4990ab.m7416i("MicroMsg.Voip.VoipVideoFragment", "set big hw view visible");
            VoipVideoFragment.this.sXQ.bringToFront();
            VoipVideoFragment.this.sWS.setVisibility(0);
            VoipVideoFragment.this.sXR = true;
            AppMethodBeat.m2505o(4880);
        }
    }

    /* renamed from: com.tencent.mm.plugin.voip.ui.VoipVideoFragment$13 */
    class C3536613 extends TimerTask {

        /* renamed from: com.tencent.mm.plugin.voip.ui.VoipVideoFragment$13$1 */
        class C295031 implements Runnable {
            C295031() {
            }

            public final void run() {
                AppMethodBeat.m2504i(4882);
                VoipVideoFragment.this.sXd.setText(VoipBaseFragment.m68591fQ(C5046bo.m7549fp(VoipVideoFragment.this.sVZ)));
                VoipVideoFragment.m58072z(VoipVideoFragment.this);
                AppMethodBeat.m2505o(4882);
            }
        }

        C3536613() {
        }

        public final void run() {
            AppMethodBeat.m2504i(4883);
            VoipVideoFragment.this.iGP.post(new C295031());
            AppMethodBeat.m2505o(4883);
        }
    }

    /* renamed from: com.tencent.mm.plugin.voip.ui.VoipVideoFragment$14 */
    class C3536714 implements C5015a {
        C3536714() {
        }

        /* renamed from: BI */
        public final boolean mo4499BI() {
            AppMethodBeat.m2504i(4884);
            if (VoipVideoFragment.this.sXY) {
                VoipVideoFragment.m58029B(VoipVideoFragment.this);
                AppMethodBeat.m2505o(4884);
                return true;
            }
            AppMethodBeat.m2505o(4884);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.voip.ui.VoipVideoFragment$7 */
    class C353687 implements OnClickListener {
        C353687() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(4876);
            C4990ab.m7416i("MicroMsg.Voip.VoipVideoFragment", "switch camera");
            VoipVideoFragment.this.sXq.setEnabled(false);
            VoipVideoFragment.m58067u(VoipVideoFragment.this);
            VoipVideoFragment.this.sXq.setEnabled(true);
            if (!(VoipVideoFragment.this.sVY == null || VoipVideoFragment.this.sVY.get() == null)) {
                ((C46324c) VoipVideoFragment.this.sVY.get()).cJu();
            }
            AppMethodBeat.m2505o(4876);
        }
    }

    /* renamed from: com.tencent.mm.plugin.voip.ui.VoipVideoFragment$8 */
    class C353698 implements Runnable {
        C353698() {
        }

        public final void run() {
            AppMethodBeat.m2504i(4877);
            C4990ab.m7416i("MicroMsg.Voip.VoipVideoFragment", "dismiss bar");
            VoipVideoFragment.this.sXH = VoipVideoFragment.this.sXH - 1;
            if (VoipVideoFragment.this.getActivity() == null || VoipVideoFragment.this.getActivity().isFinishing()) {
                AppMethodBeat.m2505o(4877);
            } else if (VoipVideoFragment.this.sXH > 0) {
                AppMethodBeat.m2505o(4877);
            } else {
                VoipVideoFragment.this.sXq.setVisibility(8);
                VoipVideoFragment.this.sXh.setVisibility(8);
                VoipVideoFragment.this.sXd.setVisibility(8);
                VoipVideoFragment.this.sXp.setVisibility(8);
                VoipVideoFragment.this.sXo.setVisibility(8);
                VoipVideoFragment.m58050e(VoipVideoFragment.this, false);
                AppMethodBeat.m2505o(4877);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.voip.ui.VoipVideoFragment$9 */
    class C353709 implements Runnable {
        C353709() {
        }

        public final void run() {
            AppMethodBeat.m2504i(4878);
            if (VoipVideoFragment.this.getActivity() == null || VoipVideoFragment.this.getActivity().isFinishing()) {
                AppMethodBeat.m2505o(4878);
                return;
            }
            VoipVideoFragment.this.sXe.setVisibility(8);
            AppMethodBeat.m2505o(4878);
        }
    }

    /* renamed from: com.tencent.mm.plugin.voip.ui.VoipVideoFragment$a */
    public class C35371a implements Runnable {
        final /* synthetic */ VoipVideoFragment sYn;

        public final void run() {
            AppMethodBeat.m2504i(4898);
            C4990ab.m7416i("MicroMsg.Voip.VoipVideoFragment", "try load blur bitmap");
            final Bitmap I = this.sYn.sXN;
            this.sYn.iGP.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(4897);
                    if (C35371a.this.sYn.sWq != null) {
                        C35371a.this.sYn.sWq.setBackgroundDrawable(new BitmapDrawable(I));
                    }
                    C35371a.this.sYn.sXO = null;
                    AppMethodBeat.m2505o(4897);
                }
            });
            AppMethodBeat.m2505o(4898);
        }
    }

    /* renamed from: com.tencent.mm.plugin.voip.ui.VoipVideoFragment$12 */
    class C3537212 implements OnClickListener {
        C3537212() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(4881);
            if (!(VoipVideoFragment.this.sVY == null || VoipVideoFragment.this.sVY.get() == null)) {
                ((C46324c) VoipVideoFragment.this.sVY.get()).cJw();
            }
            AppMethodBeat.m2505o(4881);
        }
    }

    /* renamed from: com.tencent.mm.plugin.voip.ui.VoipVideoFragment$19 */
    class C3537319 implements OnClickListener {
        C3537319() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(4893);
            C4990ab.m7416i("MicroMsg.Voip.VoipVideoFragment", "click reject video invite button");
            VoipVideoFragment.m58048d(VoipVideoFragment.this);
            AppMethodBeat.m2505o(4893);
        }
    }

    /* renamed from: com.tencent.mm.plugin.voip.ui.VoipVideoFragment$6 */
    class C353746 implements Runnable {
        C353746() {
        }

        public final void run() {
            AppMethodBeat.m2504i(4875);
            VoipVideoFragment.this.sXa.setText(C25738R.string.f60);
            VoipVideoFragment.this.sWv.mo63349a(VoipVideoFragment.this.sXb, VoipBaseFragment.sWo);
            AppMethodBeat.m2505o(4875);
        }
    }

    public VoipVideoFragment() {
        AppMethodBeat.m2504i(4899);
        AppMethodBeat.m2505o(4899);
    }

    /* renamed from: d */
    static /* synthetic */ Point m58047d(VoipVideoFragment voipVideoFragment, boolean z) {
        AppMethodBeat.m2504i(4932);
        Point mA = voipVideoFragment.m58059mA(z);
        AppMethodBeat.m2505o(4932);
        return mA;
    }

    /* renamed from: u */
    static /* synthetic */ void m58067u(VoipVideoFragment voipVideoFragment) {
        AppMethodBeat.m2504i(4934);
        voipVideoFragment.cLe();
        AppMethodBeat.m2505o(4934);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        AppMethodBeat.m2504i(4900);
        this.sWp = (RelativeLayout) layoutInflater.inflate(2130971033, viewGroup, false);
        if (Build.MANUFACTURER.equalsIgnoreCase("meizu")) {
            ((RelativeLayout) this.sWp.findViewById(2131828532)).setPadding(0, 0, 0, C4977b.m7371b(getActivity(), 40.0f));
        }
        this.sWq = (ImageView) this.sWp.findViewById(2131828511);
        this.sWr = (ImageView) this.sWp.findViewById(2131828514);
        this.sXg = (RelativeLayout) this.sWp.findViewById(2131828516);
        this.sWS = (OpenGlView) this.sWp.findViewById(2131828513);
        this.sWS.mo26411gb(mScreenWidth, mScreenHeight);
        this.sXP = (MMTextureView) this.sWp.findViewById(2131828515);
        this.sXP.setVisibility(0);
        C4990ab.m7416i("MicroMsg.Voip.VoipVideoFragment", "steve: onCreateView!");
        if (this.sXP != null) {
            C4990ab.m7416i("MicroMsg.Voip.VoipVideoFragment", "hwView creat ok");
        }
        this.sXq = (VoipBigIconButton) this.sWp.findViewById(2131828543);
        this.sXq.setOnClickListener(this.sYk);
        this.sXp = (VoipBigIconButton) this.sWp.findViewById(2131828542);
        this.sXp.setOnClickListener(this.sYa);
        this.sXl = (VoipBigIconButton) this.sWp.findViewById(2131828533);
        this.sXl.setOnClickListener(this.sYf);
        this.sXo = (VoipBigIconButton) this.sWp.findViewById(2131828539);
        this.sXo.setOnClickListener(this.sXZ);
        this.sXn = (VoipBigIconButton) this.sWp.findViewById(2131828537);
        this.sXn.setOnClickListener(this.sYd);
        this.sXk = (VoipSmallIconButton) this.sWp.findViewById(2131828538);
        this.sXk.setOnClickListener(this.sYc);
        this.sXm = (VoipBigIconButton) this.sWp.findViewById(2131828535);
        this.sXm.setOnClickListener(this.sYe);
        this.sXj = (VoipSmallIconButton) this.sWp.findViewById(2131828534);
        this.sXj.setOnClickListener(this.sYb);
        this.sXL = C29488d.m46806vn("VOIPBlockIgnoreButton") == 0;
        this.sXi = (VoipSmallIconButton) this.sWp.findViewById(2131828536);
        this.sXi.setOnClickListener(this.sYh);
        if (!this.sXL) {
            this.sXi.setVisibility(8);
        }
        this.sXd = (TextView) this.sWp.findViewById(2131828541);
        this.sWW = this.sWp.findViewById(2131828518);
        this.sWX = (ImageView) this.sWp.findViewById(2131828519);
        C40460b.m69433a(this.sWX, this.edV, 0.05882353f, true);
        this.sWY = (TextView) this.sWp.findViewById(2131828521);
        this.sWZ = (TextView) this.sWp.findViewById(2131828522);
        this.sXa = (TextView) this.sWp.findViewById(2131828524);
        this.sXb = (TextView) this.sWp.findViewById(2131828525);
        this.sXc = this.sWp.findViewById(2131828523);
        mo63346j(this.sXb);
        this.sXe = (TextView) this.sWp.findViewById(2131828545);
        this.sXf = (TextView) this.sWp.findViewById(2131828544);
        this.sXh = (Button) this.sWp.findViewById(2131828517);
        this.nGB = (TextView) this.sWp.findViewById(2131825090);
        if (C1947ae.gjk) {
            this.sXr = (TextView) this.sWp.findViewById(2131828526);
            this.sXs = (TextView) this.sWp.findViewById(2131828527);
            this.sXt = (TextView) this.sWp.findViewById(2131828528);
            this.sXu = (TextView) this.sWp.findViewById(2131828529);
            this.sXv = (TextView) this.sWp.findViewById(2131828530);
            this.sXw = (TextView) this.sWp.findViewById(2131828531);
        }
        this.sXz = (Button) this.sWp.findViewById(2131828546);
        this.sXA = (Button) this.sWp.findViewById(2131828547);
        this.sXz.setVisibility(8);
        this.sXA.setVisibility(8);
        this.sXz.setOnClickListener(this.sYi);
        this.sXA.setOnClickListener(this.sYj);
        this.sXy = new C29512f(getActivity());
        this.sWp.addView(this.sXy);
        this.sXy.setVisibility(8);
        this.sXh.setOnClickListener(this.sYg);
        m58043b(this.sRg);
        int hF = C23639t.m36491hF(getActivity());
        C4990ab.m7410d("MicroMsg.Voip.VoipVideoFragment", "statusHeight: ".concat(String.valueOf(hF)));
        VoipBaseFragment.m68589ae(this.sXh, hF);
        VoipBaseFragment.m68589ae(this.sWp.findViewById(2131828540), hF);
        VoipBaseFragment.m68589ae(this.sWW, hF);
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
        ((MovableVideoView) this.sWT).mo26410ga(width, height);
        this.sWT.setVisibility(8);
        this.sWU = new OpenGlRender(this.sWT, OpenGlRender.RenderRemote);
        this.sWT.setRenderer(this.sWU);
        this.sWT.setRenderMode(0);
        this.sWV = new OpenGlRender(this.sWS, OpenGlRender.RenderLocal);
        this.sWS.setRenderer(this.sWV);
        this.sWS.setRenderMode(0);
        this.sWS.setVisibility(0);
        C4990ab.m7416i("MicroMsg.Voip.VoipVideoFragment", "steve: before AvcDecoder init");
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
        layoutParams.topMargin = C1338a.fromDPToPix(movableTextureView.getContext(), 12) + C23639t.m36491hF(movableTextureView.getContext());
        layoutParams.leftMargin = ((movableTextureView.mScreenWidth - movableTextureView.mWidth) - layoutParams.topMargin) + C23639t.m36491hF(movableTextureView.getContext());
        movableTextureView.setLayoutParams(layoutParams);
        movableTextureView.taq = movableTextureView.mScreenHeight - movableTextureView.sZX;
        movableTextureView.tar = movableTextureView.mScreenWidth - movableTextureView.mWidth;
        windowManager2.getDefaultDisplay().getMetrics(displayMetrics);
        C4990ab.m7416i("MicroMsg.MovableTextureView", "steve: Init MovableTextureView successfully! size=" + width + " x " + height);
        this.sXQ.setVisibility(8);
        ((C46324c) this.sVY.get()).mo30882b(this.sXP);
        if (Build.MODEL.equals("Nexus 6")) {
            this.sWT.setZOrderOnTop(true);
        } else {
            this.sWT.setZOrderMediaOverlay(true);
        }
        this.sWp.addView(this.sWT);
        this.sWT.setOnClickListener(new C295084());
        this.sXQ.setOnClickListener(new C140825());
        C7616ad aoO = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(this.edV);
        this.sWY.setText(C44089j.m79293b(getActivity(), C1854s.m3860a(aoO, this.edV), this.sWY.getTextSize()));
        String A = C42249a.m74595A(aoO);
        if (!C5046bo.isNullOrNil(A)) {
            this.sWZ.setText(A);
        }
        if (this.sRm) {
            this.iGP.postDelayed(new C353746(), FaceGestureDetGLThread.BRIGHTNESS_DURATION);
        }
        this.sXx = (VoIPVideoView) this.sWp.findViewById(2131828512);
        this.mTimer = new Timer("VoIP_video_talking_count");
        C4990ab.m7417i("MicroMsg.Voip.VoipVideoFragment", "onCreateView, voipBeautyMode: %s", Integer.valueOf(this.sXT));
        this.sWV.setVoipBeauty(this.sXT);
        this.sWU.setVoipBeauty(this.sXT);
        this.sXK = true;
        mo56113fY(0, this.mStatus);
        RelativeLayout relativeLayout = this.sWp;
        AppMethodBeat.m2505o(4900);
        return relativeLayout;
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(4901);
        this.sXJ = false;
        super.onDestroy();
        AppMethodBeat.m2505o(4901);
    }

    private void cLe() {
        AppMethodBeat.m2504i(4902);
        C4990ab.m7416i("MicroMsg.Voip.VoipVideoFragment", "trigger dismiss bar");
        this.sXH++;
        this.iGP.postDelayed(this.sYl, 10000);
        AppMethodBeat.m2505o(4902);
    }

    /* renamed from: fY */
    public final void mo56113fY(int i, int i2) {
        AppMethodBeat.m2504i(4903);
        super.mo56113fY(i, i2);
        C4990ab.m7416i("MicroMsg.Voip.VoipVideoFragment", "newState: " + C40025b.m68545GK(i2));
        if (this.sWp == null) {
            C4990ab.m7416i("MicroMsg.Voip.VoipVideoFragment", "fragment no create, return first, onCreateView will call it again");
            AppMethodBeat.m2505o(4903);
            return;
        }
        switch (i2) {
            case 0:
            case 2:
                cLg();
                AppMethodBeat.m2505o(4903);
                return;
            case 4:
            case C31128d.MIC_PTU_ZIPAI_SAPPORO /*258*/:
                cLi();
                break;
            case 6:
            case C31128d.MIC_PTU_ZIPAI_GRADIENT_BLUEYELLOW /*260*/:
                cLj();
                cLh();
                AppMethodBeat.m2505o(4903);
                return;
            case 8:
            case C31128d.MIC_PTU_ZIPAI_GRADIENT_GLAREFONDDREAM /*262*/:
                m58035GD(i);
                AppMethodBeat.m2505o(4903);
                return;
            case 256:
                cLf();
                AppMethodBeat.m2505o(4903);
                return;
        }
        AppMethodBeat.m2505o(4903);
    }

    /* renamed from: a */
    public final void mo56105a(CaptureView captureView) {
        AppMethodBeat.m2504i(4904);
        this.sRg = captureView;
        m58043b(this.sRg);
        AppMethodBeat.m2505o(4904);
    }

    public final void uninit() {
        AppMethodBeat.m2504i(4905);
        this.sWT.setVisibility(4);
        if (this.sRg != null) {
            this.sWp.removeView(this.sRg);
            this.sRg = null;
            C4990ab.m7410d("MicroMsg.Voip.VoipVideoFragment", "CaptureView removed");
        }
        if (this.sXO != null) {
            C7305d.xDG.remove(this.sXO);
            this.sXO = null;
        }
        super.uninit();
        AppMethodBeat.m2505o(4905);
    }

    public final void setMute(boolean z) {
    }

    public void onStop() {
        AppMethodBeat.m2504i(4906);
        this.sWV.cLI();
        this.sWU.cLI();
        super.onStop();
        AppMethodBeat.m2505o(4906);
    }

    public void onStart() {
        AppMethodBeat.m2504i(4907);
        this.sWV.taA = true;
        this.sWU.taA = true;
        super.onStart();
        AppMethodBeat.m2505o(4907);
    }

    /* Access modifiers changed, original: protected|final */
    public final void abY(String str) {
        AppMethodBeat.m2504i(4908);
        if (this.sXf != null) {
            this.sXf.setVisibility(0);
            this.sXf.setText(str);
        }
        AppMethodBeat.m2505o(4908);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: fZ */
    public final void mo56114fZ(int i, int i2) {
        AppMethodBeat.m2504i(4909);
        if (this.sXe == null) {
            AppMethodBeat.m2505o(4909);
            return;
        }
        this.sXe.setText(i);
        this.sXe.setVisibility(0);
        this.sXe.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
        this.sXe.setBackgroundResource(C25738R.drawable.bk3);
        this.sXe.setCompoundDrawables(null, null, null, null);
        this.sXe.setCompoundDrawablePadding(0);
        this.iGP.removeCallbacks(this.lmq);
        if (-1 != i2) {
            this.iGP.postDelayed(this.lmq, (long) i2);
        }
        AppMethodBeat.m2505o(4909);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: mz */
    public final void mo56116mz(boolean z) {
        AppMethodBeat.m2504i(4910);
        if (this.nGB != null) {
            if (z) {
                this.nGB.setText(C25738R.string.gaq);
            } else {
                this.nGB.setText(C25738R.string.gap);
            }
            this.nGB.clearAnimation();
            this.nGB.setVisibility(0);
        }
        AppMethodBeat.m2505o(4910);
    }

    /* Access modifiers changed, original: protected|final */
    public final void cKY() {
        AppMethodBeat.m2504i(4911);
        if (this.nGB != null) {
            this.nGB.clearAnimation();
            this.nGB.setVisibility(8);
        }
        AppMethodBeat.m2505o(4911);
    }

    public final void cKZ() {
        AppMethodBeat.m2504i(4912);
        this.sWS.setLayoutParams(new LayoutParams(-1, -1));
        MovableVideoView movableVideoView = (MovableVideoView) this.sWT;
        C4990ab.m7417i("MicroMsg.MovableVideoView", "refrsh view %s, %s", Integer.valueOf(movableVideoView.mWidth), Integer.valueOf(movableVideoView.sZX));
        movableVideoView.mScreenWidth = 0;
        movableVideoView.mo26410ga(movableVideoView.mWidth, movableVideoView.sZX);
        AppMethodBeat.m2505o(4912);
    }

    private void cLf() {
        AppMethodBeat.m2504i(4913);
        this.sWS.setVisibility(0);
        if (this.sWr != null) {
            cLb();
        }
        this.sWW.setVisibility(0);
        this.sWY.setVisibility(0);
        if (!C7616ad.aox(this.edV) || C5046bo.m7519ac(this.sWZ.getText())) {
            this.sWZ.setVisibility(8);
        } else {
            this.sWZ.setVisibility(0);
        }
        this.sXa.setText(C25738R.string.f62);
        this.sXc.setVisibility(0);
        this.sWX.setVisibility(0);
        this.sWv.mo63349a(this.sXb, sWo);
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
        if (C43727b.cIj().sRK != null) {
            this.sXf.setVisibility(0);
            this.sXf.setText(C43727b.cIj().sRK);
        }
        AppMethodBeat.m2505o(4913);
    }

    private void cLg() {
        AppMethodBeat.m2504i(4914);
        this.sXc.setVisibility(0);
        this.sWS.setVisibility(0);
        this.sXa.setText(C25738R.string.f60);
        if (!C7616ad.aox(this.edV) || C5046bo.m7519ac(this.sWZ.getText())) {
            this.sWZ.setVisibility(8);
        } else {
            this.sWZ.setVisibility(0);
        }
        this.sWq.setVisibility(8);
        this.sXe.setVisibility(8);
        this.sXf.setVisibility(8);
        if (C43727b.cIj().sRK != null) {
            this.sXf.setVisibility(0);
            this.sXf.setText(C43727b.cIj().sRK);
        }
        this.sWv.mo63349a(this.sXb, sWo);
        this.sXq.setVisibility(8);
        this.sXp.setVisibility(8);
        this.sXl.setVisibility(0);
        this.sXo.setVisibility(8);
        this.sXn.setVisibility(8);
        this.sXk.setVisibility(8);
        this.sXm.setVisibility(8);
        this.sXj.setVisibility(0);
        this.sXi.setVisibility(8);
        AppMethodBeat.m2505o(4914);
    }

    private void cLh() {
        boolean z = true;
        AppMethodBeat.m2504i(4915);
        if (this.sWr != null) {
            this.sWr.setVisibility(8);
        }
        if (this.sWT.getVisibility() == 0) {
            AppMethodBeat.m2505o(4915);
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
            Point mA = m58059mA(z2);
            this.sWT.mo26412gc(mA.x, mA.y);
        } else {
            if (this.sXI) {
                z2 = false;
            } else {
                z2 = true;
            }
            this.sXI = z2;
            this.sXx.setVisibility(8);
        }
        if (C1947ae.gjk) {
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
        C4990ab.m7411d("MicroMsg.Voip.VoipVideoFragment", "steve: showVideoTalking decMode:%d", Integer.valueOf(this.sXS));
        if (this.sXI) {
            z = false;
        }
        Point mA2 = m58059mA(z);
        ((MovableVideoView) this.sWT).mo26410ga(mA2.x, mA2.y);
        arh();
        if (C4996ah.doB().getBoolean("voipfaceDebug", false)) {
            this.sXz.setVisibility(0);
            this.sXA.setVisibility(0);
        }
        cLe();
        if (this.sWs == 4102) {
            mo56114fZ(C25738R.string.f3n, Downloads.MIN_WAIT_FOR_NETWORK);
        }
        AppMethodBeat.m2505o(4915);
    }

    /* renamed from: a */
    public final void mo56106a(byte[] bArr, long j, int i, int i2, int i3, int i4, int i5, int i6) {
        AppMethodBeat.m2504i(4916);
        if (this.sXK) {
            if (OpenGlRender.taQ == 1) {
                if (this.sYm < i * i2) {
                    this.oHc = null;
                }
                if (this.oHc == null) {
                    this.sYm = i * i2;
                    this.oHc = new int[this.sYm];
                }
                if (C43727b.cIj().mo26344a(bArr, (int) j, i3 & 31, i, i2, this.oHc, true) < 0 || this.oHc == null) {
                    AppMethodBeat.m2505o(4916);
                    return;
                } else if (this.sXI) {
                    this.sWU.mo63360a(this.oHc, i, i2, (OpenGlRender.FLAG_RGBAClip + i4) + i5, true);
                } else {
                    this.sWV.mo63360a(this.oHc, i, i2, (OpenGlRender.FLAG_RGBAClip + i4) + i5, true);
                }
            } else if (OpenGlRender.taQ == 2) {
                if (this.sXI) {
                    this.sWU.mo63361c(bArr, i, i2, (OpenGlRender.FLAG_NV21 + i4) + i5, true);
                } else {
                    this.sWV.mo63361c(bArr, i, i2, (OpenGlRender.FLAG_NV21 + i4) + i5, true);
                }
            }
            this.sXD++;
            if (i6 > 0) {
                this.sXC++;
            }
            C29512f c29512f = this.sXy;
            c29512f.sZZ = i;
            c29512f.taa = i2;
            c29512f = this.sXy;
            int width = this.sWp.getWidth();
            int height = this.sWp.getHeight();
            c29512f.sZY = width;
            c29512f.f13715np = height;
            AppMethodBeat.m2505o(4916);
            return;
        }
        AppMethodBeat.m2505o(4916);
    }

    public final void setHWDecMode(int i) {
        AppMethodBeat.m2504i(4917);
        int i2 = i & 1;
        if (this.iGP != null) {
            C4990ab.m7417i("MicroMsg.Voip.VoipVideoFragment", "setHWDecMode, hwdec: %s", Boolean.valueOf(i2 != 0));
            if (i2 != 0) {
                C4990ab.m7416i("MicroMsg.Voip.VoipVideoFragment", "use hw texture");
                this.iGP.post(new C3536511());
            } else {
                this.iGP.post(new C3536410());
            }
        }
        this.sXS = i;
        AppMethodBeat.m2505o(4917);
    }

    public final OpenGlRender getFilterData() {
        if (this.sXI) {
            return this.sWU;
        }
        return this.sWV;
    }

    /* renamed from: c */
    public final void mo56108c(int i, int i2, int[] iArr) {
        AppMethodBeat.m2504i(4918);
        if (this.sXK) {
            this.sXE++;
            if (OpenGlRender.taQ == 1) {
                if (this.sXI) {
                    this.sWV.mo63360a(iArr, i, i2, OpenGlRender.FLAG_RGBAClip + OpenGlRender.FLAG_Angle90, false);
                    AppMethodBeat.m2505o(4918);
                    return;
                }
                this.sWU.mo63360a(iArr, i, i2, OpenGlRender.FLAG_RGBAClip + OpenGlRender.FLAG_Angle90, false);
                AppMethodBeat.m2505o(4918);
                return;
            } else if (this.sXI) {
                this.sWV.mo63360a(iArr, i, i2, OpenGlRender.FLAG_YV12Edge + OpenGlRender.FLAG_Angle90, false);
                AppMethodBeat.m2505o(4918);
                return;
            } else {
                this.sWU.mo63360a(iArr, i, i2, OpenGlRender.FLAG_YV12Edge + OpenGlRender.FLAG_Angle90, false);
                AppMethodBeat.m2505o(4918);
                return;
            }
        }
        AppMethodBeat.m2505o(4918);
    }

    public final void cJD() {
        AppMethodBeat.m2504i(4919);
        if (this.sXK) {
            this.sWV.cLJ();
            this.sWU.cLJ();
            AppMethodBeat.m2505o(4919);
            return;
        }
        AppMethodBeat.m2505o(4919);
    }

    public final void setVoipBeauty(int i) {
        AppMethodBeat.m2504i(4920);
        C4990ab.m7417i("MicroMsg.Voip.VoipVideoFragment", "setVoipBeauty isON:%d, mInitDone:%b", Integer.valueOf(i), Boolean.valueOf(this.sXK));
        this.sXT = i;
        if (this.sXK) {
            this.sWV.setVoipBeauty(this.sXT);
            this.sWU.setVoipBeauty(this.sXT);
            AppMethodBeat.m2505o(4920);
            return;
        }
        AppMethodBeat.m2505o(4920);
    }

    private void cLi() {
        AppMethodBeat.m2504i(4921);
        this.sXa.setText(C25738R.string.f7s);
        this.sWv.mo63349a(this.sXb, sWo);
        AppMethodBeat.m2505o(4921);
    }

    /* renamed from: GD */
    private void m58035GD(int i) {
        AppMethodBeat.m2504i(4922);
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
                this.sXe.setText(C25738R.string.f6e);
                break;
        }
        if (this.sWu != null) {
            this.sWu.mo63352S(true, false);
        }
        AppMethodBeat.m2505o(4922);
    }

    private void arh() {
        AppMethodBeat.m2504i(4923);
        if (this.mTimer == null || this.sXJ) {
            AppMethodBeat.m2505o(4923);
            return;
        }
        if (-1 == this.sVZ) {
            this.sVZ = C5046bo.anT();
        }
        this.sXM = this.sVZ;
        this.sXJ = true;
        this.mTimer.schedule(new C3536613(), 1000, 1000);
        this.sXW = C7305d.anM("VoipVideoFragment_cpuStatThread");
        this.sXW.start();
        this.sXX = new C7564ap(this.sXW.getLooper(), new C3536714(), true);
        this.sXY = true;
        this.sXX.mo16770ae(1000, 1000);
        AppMethodBeat.m2505o(4923);
    }

    private void cLj() {
        AppMethodBeat.m2504i(4924);
        this.sWp.setOnClickListener(new C1407215());
        AppMethodBeat.m2505o(4924);
    }

    /* renamed from: b */
    private void m58043b(CaptureView captureView) {
        AppMethodBeat.m2504i(4925);
        if (this.sWp == null || captureView == null) {
            AppMethodBeat.m2505o(4925);
            return;
        }
        this.sWp.removeView(this.sRg);
        this.sRg = null;
        this.sRg = captureView;
        this.sWp.addView(captureView, new LayoutParams(1, 1));
        this.sRg.setVisibility(0);
        this.sRg.setAlpha(0.0f);
        C4990ab.m7410d("MicroMsg.Voip.VoipVideoFragment", "CaptureView added");
        AppMethodBeat.m2505o(4925);
    }

    public final void cKT() {
        AppMethodBeat.m2504i(4926);
        if (this.sRg != null) {
            this.sWp.removeView(this.sRg);
            this.sWp.addView(this.sRg, new LayoutParams(1, 1));
            this.sRg.setVisibility(0);
            this.sRg.setAlpha(0.0f);
            C4990ab.m7416i("MicroMsg.Voip.VoipVideoFragment", "resetCaptureView");
        }
        AppMethodBeat.m2505o(4926);
    }

    public void onDetach() {
        AppMethodBeat.m2504i(4927);
        C4990ab.m7416i("MicroMsg.Voip.VoipVideoFragment", "onDetach");
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
        AppMethodBeat.m2505o(4927);
    }

    /* renamed from: GC */
    public final void mo56104GC(int i) {
    }

    /* renamed from: mA */
    private Point m58059mA(boolean z) {
        AppMethodBeat.m2504i(4928);
        int height = (int) (((double) getActivity().getWindowManager().getDefaultDisplay().getHeight()) / 5.0d);
        float f = (float) height;
        C43727b.cIj();
        Point point = new Point((int) (f * C14058r.m22231mw(z)), height);
        AppMethodBeat.m2505o(4928);
        return point;
    }

    /* renamed from: c */
    static /* synthetic */ void m58045c(VoipVideoFragment voipVideoFragment) {
        AppMethodBeat.m2504i(4929);
        C4990ab.m7416i("MicroMsg.Voip.VoipVideoFragment", "accept video invite use voice");
        C7060h.pYm.mo8377a(11526, true, true, Integer.valueOf(C43727b.cIj().cJZ()), Long.valueOf(C43727b.cIj().cKa()), Long.valueOf(C43727b.cIj().cIK()), Integer.valueOf(3));
        if (!(voipVideoFragment.sVY == null || voipVideoFragment.sVY.get() == null || !((C46324c) voipVideoFragment.sVY.get()).cJl())) {
            voipVideoFragment.sXk.setEnabled(false);
            voipVideoFragment.sXn.setEnabled(false);
            voipVideoFragment.sXm.setEnabled(false);
            voipVideoFragment.sXa.setText(C25738R.string.f7s);
            voipVideoFragment.sWv.mo63349a(voipVideoFragment.sXb, sWo);
        }
        AppMethodBeat.m2505o(4929);
    }

    /* renamed from: d */
    static /* synthetic */ void m58048d(VoipVideoFragment voipVideoFragment) {
        AppMethodBeat.m2504i(4930);
        C4990ab.m7416i("MicroMsg.Voip.VoipVideoFragment", "reject video invite");
        C7060h.pYm.mo8377a(11526, true, true, Integer.valueOf(C43727b.cIj().cJZ()), Long.valueOf(C43727b.cIj().cKa()), Long.valueOf(C43727b.cIj().cIK()), Integer.valueOf(4));
        if (!(voipVideoFragment.sVY == null || voipVideoFragment.sVY.get() == null || !((C46324c) voipVideoFragment.sVY.get()).cJm())) {
            voipVideoFragment.mo56114fZ(C25738R.string.f6q, -1);
            voipVideoFragment.sXm.setEnabled(false);
            voipVideoFragment.sXn.setEnabled(false);
            voipVideoFragment.sXk.setEnabled(false);
        }
        AppMethodBeat.m2505o(4930);
    }

    /* renamed from: e */
    static /* synthetic */ void m58049e(VoipVideoFragment voipVideoFragment) {
        AppMethodBeat.m2504i(4931);
        C4990ab.m7416i("MicroMsg.Voip.VoipVideoFragment", "accept video invite");
        C7060h.pYm.mo8377a(11526, true, true, Integer.valueOf(C43727b.cIj().cJZ()), Long.valueOf(C43727b.cIj().cKa()), Long.valueOf(C43727b.cIj().cIK()), Integer.valueOf(1));
        if (!(voipVideoFragment.sVY == null || voipVideoFragment.sVY.get() == null || !((C46324c) voipVideoFragment.sVY.get()).cJn())) {
            voipVideoFragment.sXn.setEnabled(false);
            voipVideoFragment.sXm.setEnabled(false);
            voipVideoFragment.sXk.setEnabled(false);
            voipVideoFragment.sXl.setVisibility(8);
        }
        AppMethodBeat.m2505o(4931);
    }

    /* renamed from: q */
    static /* synthetic */ void m58063q(VoipVideoFragment voipVideoFragment) {
        AppMethodBeat.m2504i(4933);
        C4990ab.m7416i("MicroMsg.Voip.VoipVideoFragment", "setBigHwTextureViewParam");
        ViewGroup.LayoutParams layoutParams = voipVideoFragment.sXP.getLayoutParams();
        layoutParams.width = -1;
        layoutParams.height = -1;
        voipVideoFragment.sXP.setLayoutParams(layoutParams);
        AppMethodBeat.m2505o(4933);
    }

    /* renamed from: e */
    static /* synthetic */ void m58050e(VoipVideoFragment voipVideoFragment, boolean z) {
        AppMethodBeat.m2504i(4935);
        if (z) {
            voipVideoFragment.getActivity().getWindow().clearFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
            AppMethodBeat.m2505o(4935);
            return;
        }
        voipVideoFragment.getActivity().getWindow().setFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
        AppMethodBeat.m2505o(4935);
    }

    /* renamed from: z */
    static /* synthetic */ void m58072z(VoipVideoFragment voipVideoFragment) {
        AppMethodBeat.m2504i(4936);
        C14058r cIj = C43727b.cIj();
        int i = voipVideoFragment.sXD;
        int i2 = voipVideoFragment.sXV;
        C40031m c40031m = cIj.sSP.sNl.sPr;
        c40031m.sNl.sPp.sVc = i;
        c40031m.sNl.sPp.sVd = i2;
        if (C1947ae.gjk) {
            long anT = C5046bo.anT();
            int i3 = (int) (anT - voipVideoFragment.sXM);
            if (i3 <= 1) {
                i3 = 1;
            }
            String format = String.format(Locale.US, "Capt: %d,CPU:%d,vP:%d", new Object[]{Integer.valueOf(voipVideoFragment.sXD), Integer.valueOf(voipVideoFragment.sXV), Integer.valueOf(voipVideoFragment.sXT)});
            String format2 = String.format(Locale.US, "Send Fps: %d", new Object[]{Integer.valueOf(voipVideoFragment.sXC)});
            String format3 = String.format(Locale.US, "Recv Fps: %d", new Object[]{Integer.valueOf(voipVideoFragment.sXE)});
            int i4 = C43727b.cIj().sSP.sNl.sPr.sNl.sPp.field_sendVideoLen;
            int i5 = C43727b.cIj().sSP.sNl.sPr.sNl.sPp.field_recvVideoLen;
            voipVideoFragment.sXF = (int) ((((double) (i4 - voipVideoFragment.sXF)) * 8.0d) / ((double) (i3 * 1000)));
            voipVideoFragment.sXG = (int) ((((double) (i5 - voipVideoFragment.sXG)) * 8.0d) / ((double) (i3 * 1000)));
            i3 = (voipVideoFragment.sXS >> 8) != 0 ? 1 : 0;
            i = (voipVideoFragment.sXS & 255) != 0 ? 1 : 0;
            String format4 = String.format(Locale.US, "Tx:%d, HWEnc:%d", new Object[]{Integer.valueOf(voipVideoFragment.sXF), Integer.valueOf(i3)});
            String format5 = String.format(Locale.US, "Rx:%d, HWDec:%d", new Object[]{Integer.valueOf(voipVideoFragment.sXG), Integer.valueOf(i)});
            byte[] bArr = C43727b.cIj().sSP.sNl.sPp.sVe;
            if (bArr != null) {
                try {
                    voipVideoFragment.sXw.setText(new String(bArr, "UTF-8"));
                } catch (UnsupportedEncodingException e) {
                    C4990ab.printErrStackTrace("MicroMsg.Voip.VoipVideoFragment", e, "", new Object[0]);
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
        AppMethodBeat.m2505o(4936);
    }

    /* renamed from: B */
    static /* synthetic */ void m58029B(VoipVideoFragment voipVideoFragment) {
        AppMethodBeat.m2504i(4937);
        boolean cKc = C43727b.cIj().cKc();
        int i = voipVideoFragment.sXU;
        voipVideoFragment.sXU = i + 1;
        if (i % 5 == 0 && cKc) {
            int LI = C1427q.eto.mo4873LI();
            C4990ab.m7410d("MicroMsg.Voip.VoipVideoFragment", "devincdai: cpu_usage = ".concat(String.valueOf(LI)));
            voipVideoFragment.sXV = LI;
        }
        AppMethodBeat.m2505o(4937);
    }
}
