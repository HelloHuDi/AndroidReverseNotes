package com.tencent.p177mm.plugin.multitalk.p459ui.widget;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.drawable.AnimationDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.p182ah.C17884o;
import com.tencent.p177mm.p182ah.C41732d.C8915a;
import com.tencent.p177mm.p203bg.C17981e;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p612ui.C5222ae;
import com.tencent.p177mm.p612ui.widget.p633a.C5653c;
import com.tencent.p177mm.plugin.multitalk.model.C12626e;
import com.tencent.p177mm.plugin.multitalk.model.C12630f;
import com.tencent.p177mm.plugin.multitalk.model.C34571j;
import com.tencent.p177mm.plugin.multitalk.model.C34572p;
import com.tencent.p177mm.plugin.multitalk.model.C3512k;
import com.tencent.p177mm.plugin.multitalk.model.C3512k.C3515b;
import com.tencent.p177mm.plugin.multitalk.p459ui.MultiTalkMainUI;
import com.tencent.p177mm.plugin.video.ObservableTextureView;
import com.tencent.p177mm.plugin.voip.p546ui.MMCheckBox;
import com.tencent.p177mm.plugin.voip.video.C14088g;
import com.tencent.p177mm.plugin.voip.video.C46326a;
import com.tencent.p177mm.plugin.voip.video.OpenGlRender;
import com.tencent.p177mm.pluginsdk.permission.C35805b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5023at;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p659pb.common.p660b.p661a.C24202a.C24193av;
import com.tencent.p659pb.talkroom.sdk.C46732g;
import com.tencent.p659pb.talkroom.sdk.MultiTalkGroup;
import com.tencent.p659pb.talkroom.sdk.MultiTalkGroupMember;
import com.tencent.view.C31128d;
import com.tencent.wecall.talkroom.model.C6001c;
import com.tencent.wecall.talkroom.model.TalkRoom;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.multitalk.ui.widget.f */
public final class C16836f implements OnClickListener, C8915a, C14088g {
    public TextView enf;
    C5653c gLj = null;
    public FrameLayout oII;
    public FrameLayout oIJ;
    private RelativeLayout oIK;
    public View oIL;
    private View oIM;
    private View oIN;
    public View oIO;
    public MMCheckBox oIP;
    public MMCheckBox oIQ;
    public MMCheckBox oIR;
    private int oIS;
    private int oIT;
    public ArrayList<RelativeLayout> oIU = new ArrayList(9);
    private RelativeLayout oIV;
    private C46326a oIW;
    private C3512k oIX;
    private ObservableTextureView oIY;
    public String oIZ;
    private MultiTalkMainUI oIm;
    private ImageButton oIs;
    private int oJa;
    public long oJb;
    C16840c oJc = new C16840c(this, (byte) 0);

    /* renamed from: com.tencent.mm.plugin.multitalk.ui.widget.f$2 */
    class C126532 implements Runnable {
        C126532() {
        }

        public final void run() {
            AppMethodBeat.m2504i(54201);
            C16836f.this.mo30835js(false);
            AppMethodBeat.m2505o(54201);
        }
    }

    /* renamed from: com.tencent.mm.plugin.multitalk.ui.widget.f$1 */
    class C168371 implements Runnable {
        C168371() {
        }

        public final void run() {
            AppMethodBeat.m2504i(54200);
            C16836f.this.enf.setText(C25738R.string.d25);
            AppMethodBeat.m2505o(54200);
        }
    }

    /* renamed from: com.tencent.mm.plugin.multitalk.ui.widget.f$b */
    public class C16838b implements Runnable {
        C16839a oJi;

        public C16838b(C16839a c16839a) {
            this.oJi = c16839a;
        }

        public final void run() {
            AppMethodBeat.m2504i(54202);
            this.oJi.oJh.setVisibility(8);
            AppMethodBeat.m2505o(54202);
        }
    }

    /* renamed from: com.tencent.mm.plugin.multitalk.ui.widget.f$a */
    public static class C16839a {
        View iVh;
        public MultiTalkVideoView oJe;
        public ImageView oJf;
        public ImageView oJg;
        public TextView oJh;
        ImageView ohf;
    }

    /* renamed from: com.tencent.mm.plugin.multitalk.ui.widget.f$c */
    class C16840c {
        /* renamed from: h */
        int f3577h;
        int[] oHc;
        /* renamed from: w */
        int f3578w;

        private C16840c() {
        }

        /* synthetic */ C16840c(C16836f c16836f, byte b) {
            this();
        }
    }

    public C16836f(MultiTalkMainUI multiTalkMainUI) {
        int hC;
        RelativeLayout relativeLayout;
        AppMethodBeat.m2504i(54203);
        this.oIm = multiTalkMainUI;
        this.oIK = (RelativeLayout) multiTalkMainUI.findViewById(2131826223);
        if (C5222ae.m7950hD(multiTalkMainUI.mController.ylL)) {
            hC = C5222ae.m7949hC(multiTalkMainUI.mController.ylL) + 0;
        } else {
            hC = 0;
        }
        this.oIK.setPadding(0, hC, 0, 0);
        this.enf = (TextView) multiTalkMainUI.findViewById(2131820988);
        this.oIL = multiTalkMainUI.findViewById(2131826222);
        this.oIs = (ImageButton) multiTalkMainUI.findViewById(2131826232);
        this.oII = (FrameLayout) multiTalkMainUI.findViewById(2131826224);
        this.oIJ = (FrameLayout) multiTalkMainUI.findViewById(2131826225);
        this.oIM = multiTalkMainUI.findViewById(2131826226);
        this.oIN = multiTalkMainUI.findViewById(2131826227);
        this.oIP = (MMCheckBox) multiTalkMainUI.findViewById(2131826230);
        this.oIQ = (MMCheckBox) multiTalkMainUI.findViewById(2131826229);
        this.oIR = (MMCheckBox) multiTalkMainUI.findViewById(2131826231);
        this.oIO = multiTalkMainUI.findViewById(2131826233);
        this.oIQ.setChecked(C34572p.bSf().eif);
        this.oIR.setChecked(C34572p.bSf().oGb);
        this.oIP.setChecked(C34572p.bSf().bRF());
        this.oIS = C1338a.m2868gd(multiTalkMainUI.mController.ylL);
        this.oIT = C43320b.m77261eC(multiTalkMainUI.mController.ylL);
        C4990ab.m7417i("MicroMsg.MT.MultiTalkTalkingUILogic", "talkingAvatarContainerHeight %d", Integer.valueOf(this.oIT));
        this.oIs.setOnClickListener(this);
        this.oIM.setOnClickListener(this);
        this.oIP.setOnClickListener(this);
        this.oIQ.setOnClickListener(this);
        this.oIR.setOnClickListener(this);
        this.oIN.setOnClickListener(this);
        this.oIO.setOnClickListener(this);
        C17884o.acd().mo67498a((C8915a) this);
        for (int i = 8; i >= 0; i--) {
            relativeLayout = (RelativeLayout) LayoutInflater.from(multiTalkMainUI).inflate(2130970022, this.oII, false);
            C16839a c16839a = new C16839a();
            c16839a.oJe = (MultiTalkVideoView) relativeLayout.findViewById(2131825730);
            c16839a.oJe.setIndex(i);
            c16839a.oJe.setOnClickListener(this);
            c16839a.iVh = relativeLayout.findViewById(2131825731);
            c16839a.oJf = (ImageView) relativeLayout.findViewById(2131825734);
            c16839a.oJg = (ImageView) relativeLayout.findViewById(2131825735);
            c16839a.oJh = (TextView) relativeLayout.findViewById(2131825733);
            c16839a.ohf = (ImageView) relativeLayout.findViewById(2131825732);
            relativeLayout.setTag(c16839a);
            relativeLayout.setVisibility(8);
            this.oIU.add(relativeLayout);
            this.oII.addView(relativeLayout);
        }
        if (this.oIJ != null) {
            relativeLayout = (RelativeLayout) LayoutInflater.from(multiTalkMainUI).inflate(2130970022, this.oIJ, false);
            C16839a c16839a2 = new C16839a();
            c16839a2.oJe = (MultiTalkVideoView) relativeLayout.findViewById(2131825730);
            c16839a2.oJe.setIndex(0);
            c16839a2.oJe.setOnClickListener(this);
            c16839a2.iVh = relativeLayout.findViewById(2131825731);
            c16839a2.oJf = (ImageView) relativeLayout.findViewById(2131825734);
            c16839a2.oJg = (ImageView) relativeLayout.findViewById(2131825735);
            c16839a2.oJh = (TextView) relativeLayout.findViewById(2131825733);
            c16839a2.ohf = (ImageView) relativeLayout.findViewById(2131825732);
            relativeLayout.setTag(c16839a2);
            relativeLayout.setVisibility(8);
            this.oIV = relativeLayout;
            this.oIJ.addView(relativeLayout);
        }
        this.oIJ.setVisibility(8);
        if (C34572p.bSf().bRF()) {
            this.oIO.setVisibility(0);
        } else {
            this.oIO.setVisibility(8);
        }
        this.oIZ = "";
        bSp();
        AppMethodBeat.m2505o(54203);
    }

    /* renamed from: o */
    public final void mo30837o(MultiTalkGroup multiTalkGroup) {
        AppMethodBeat.m2504i(54204);
        this.oIL.setVisibility(0);
        LinkedList linkedList = new LinkedList();
        for (MultiTalkGroupMember multiTalkGroupMember : multiTalkGroup.Aqg) {
            if (multiTalkGroupMember.status == 10 || multiTalkGroupMember.status == 1) {
                linkedList.add(multiTalkGroupMember);
            }
        }
        m25968ag(linkedList);
        bSp();
        AppMethodBeat.m2505o(54204);
    }

    /* renamed from: ag */
    private void m25968ag(LinkedList<MultiTalkGroupMember> linkedList) {
        int i;
        int i2;
        int i3;
        float[] fArr;
        AppMethodBeat.m2504i(54205);
        this.oJa = linkedList.size();
        LayoutParams layoutParams = this.oII.getLayoutParams();
        if (this.oJa <= 4) {
            i = this.oIS / 2;
            i2 = this.oIT / 2 > i ? i : this.oIT / 2;
            layoutParams.height = i2 * 2;
            i3 = i2;
        } else if (this.oJa <= 9) {
            i = this.oIS / 3;
            i2 = this.oIT / 3 > i ? i : this.oIT / 3;
            layoutParams.height = i2 * 3;
            i3 = i2;
        } else {
            C4990ab.m7413e("MicroMsg.MT.MultiTalkTalkingUILogic", "onlineUserSize larger than 9, %s", Integer.valueOf(this.oJa));
            AppMethodBeat.m2505o(54205);
            return;
        }
        this.oII.setLayoutParams(layoutParams);
        C4990ab.m7417i("MicroMsg.MT.MultiTalkTalkingUILogic", "talkingAvatarWidth: %d | talkingAvatarHeight: %d | size %d", Integer.valueOf(i), Integer.valueOf(i3), Integer.valueOf(this.oJa));
        HashSet hashSet = new HashSet();
        hashSet.addAll(C34572p.bSf().oGf);
        if (C34572p.bSf().bRF()) {
            hashSet.add(C1853r.m3846Yz());
        }
        if (this.oJa <= 4) {
            fArr = C34571j.oGR[this.oJa];
        } else {
            fArr = C34571j.oGR[5];
        }
        if (fArr != null) {
            i2 = 0;
            while (true) {
                int i4 = i2;
                if (i4 >= fArr.length) {
                    break;
                }
                MultiTalkGroupMember multiTalkGroupMember;
                if (this.oJa > i4 / 2) {
                    multiTalkGroupMember = (MultiTalkGroupMember) linkedList.get(i4 / 2);
                } else {
                    multiTalkGroupMember = null;
                }
                i2 = (int) (fArr[i4] * ((float) i));
                int i5 = (int) (fArr[i4 + 1] * ((float) i3));
                if (this.oJa == 2 && i2 == 0) {
                    i2 = 1;
                }
                if (this.oJa == 4 && r0 == 0) {
                    i2 = 1;
                }
                int i6 = i2;
                RelativeLayout relativeLayout = (RelativeLayout) this.oIU.get(i4 / 2);
                FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
                layoutParams2.width = i;
                layoutParams2.height = i3;
                layoutParams2.leftMargin = i6;
                layoutParams2.topMargin = i5;
                relativeLayout.setLayoutParams(layoutParams2);
                C16836f.m25966a(relativeLayout, multiTalkGroupMember, false, hashSet);
                relativeLayout.setVisibility(0);
                C4990ab.m7417i("MicroMsg.MT.MultiTalkTalkingUILogic", "setIvLayoutParams, width: %s, height: %s, marginLeft: %s, marginTop: %s", Integer.valueOf(i), Integer.valueOf(i3), Integer.valueOf(i6), Integer.valueOf(i5));
                i2 = i4 + 2;
            }
        }
        if (this.oJa <= 4) {
            i2 = this.oJa;
            while (true) {
                i = i2;
                if (i >= 9) {
                    break;
                }
                ((RelativeLayout) this.oIU.get(i)).setVisibility(8);
                i2 = i + 1;
            }
        }
        if (!(!C34572p.bSf().bRH() || this.oIP == null || this.oIP.isChecked())) {
            C34572p.bSf().mo24599zf(1);
        }
        AppMethodBeat.m2505o(54205);
    }

    /* renamed from: a */
    private static void m25966a(RelativeLayout relativeLayout, MultiTalkGroupMember multiTalkGroupMember, boolean z, HashSet<String> hashSet) {
        AppMethodBeat.m2504i(54206);
        C16839a c16839a = (C16839a) relativeLayout.getTag();
        if (multiTalkGroupMember != null) {
            c16839a.oJe.mo41658Sr(multiTalkGroupMember.Aqh);
            c16839a.oJe.setPosition(c16839a.oJe.getIndex());
            if (multiTalkGroupMember.status != 10) {
                c16839a.iVh.setVisibility(0);
                C16836f.m25967a(c16839a);
            } else {
                c16839a.iVh.setVisibility(8);
                C16836f.m25969b(c16839a);
            }
            if (!hashSet.contains(multiTalkGroupMember.Aqh) || z) {
                c16839a.oJe.bSr();
                AppMethodBeat.m2505o(54206);
                return;
            }
            c16839a.oJe.bSs();
            AppMethodBeat.m2505o(54206);
            return;
        }
        c16839a.iVh.setVisibility(8);
        C16836f.m25969b(c16839a);
        c16839a.oJe.bSt();
        AppMethodBeat.m2505o(54206);
    }

    /* renamed from: Sq */
    public final RelativeLayout mo30827Sq(String str) {
        AppMethodBeat.m2504i(54207);
        Iterator it = this.oIU.iterator();
        while (it.hasNext()) {
            RelativeLayout relativeLayout = (RelativeLayout) it.next();
            if (str.equals(((C16839a) relativeLayout.getTag()).oJe.getUsername())) {
                AppMethodBeat.m2505o(54207);
                return relativeLayout;
            }
        }
        AppMethodBeat.m2505o(54207);
        return null;
    }

    /* renamed from: x */
    private static int m25970x(boolean z, int i) {
        int i2;
        AppMethodBeat.m2504i(54208);
        if (z) {
            i2 = i;
        } else {
            i2 = -1;
        }
        ByteBuffer allocate = ByteBuffer.allocate(4);
        allocate.order(ByteOrder.LITTLE_ENDIAN).putInt(i2);
        int appCmd = C34572p.bSe().oFP.setAppCmd(22, allocate.array(), 4);
        if (appCmd < 0) {
            C4990ab.m7413e("MicroMsg.MT.MultiTalkTalkingUILogic", "steve:set netBigVideo failed or NO need!, ret:%d, vID:%d, memberId:%d", Integer.valueOf(appCmd), Integer.valueOf(i2), Integer.valueOf(i));
            AppMethodBeat.m2505o(54208);
            return -1;
        }
        AppMethodBeat.m2505o(54208);
        return appCmd;
    }

    public final void onClick(View view) {
        boolean z = true;
        AppMethodBeat.m2504i(54209);
        int i;
        if (view instanceof MultiTalkVideoView) {
            MultiTalkVideoView multiTalkVideoView = (MultiTalkVideoView) view;
            C16839a c16839a;
            if (this.oIJ.getVisibility() != 8) {
                if (!(multiTalkVideoView.getUsername() == null || multiTalkVideoView.getUsername().equals(C1853r.m3846Yz()))) {
                    C4990ab.m7410d("MicroMsg.MT.MultiTalkTalkingUILogic", "steve: unsubscribe big video!");
                    C34572p.bSf().mo24566Sj("");
                    C16836f.m25970x(false, -1);
                }
                this.oIJ.setVisibility(8);
                this.oII.setVisibility(0);
                if (this.oIV != null) {
                    c16839a = (C16839a) this.oIV.getTag();
                    if (c16839a != null) {
                        c16839a.oJe.bSt();
                    }
                }
                this.oIZ = "";
                C12626e.bRE();
                AppMethodBeat.m2505o(54209);
            } else if (multiTalkVideoView.bSw()) {
                this.oIJ.setVisibility(0);
                this.oII.setVisibility(8);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.width = this.oIS;
                layoutParams.height = this.oIS;
                layoutParams.leftMargin = 0;
                layoutParams.topMargin = 0;
                this.oIV.setLayoutParams(layoutParams);
                String username = multiTalkVideoView.getUsername();
                MultiTalkGroupMember multiTalkGroupMember = null;
                if (C34572p.bSf().oGh != null) {
                    for (MultiTalkGroupMember multiTalkGroupMember2 : C34572p.bSf().oGh.Aqg) {
                        MultiTalkGroupMember multiTalkGroupMember22;
                        if ((multiTalkGroupMember22.status != 10 && multiTalkGroupMember22.status != 1) || !multiTalkGroupMember22.Aqh.equals(username)) {
                            multiTalkGroupMember22 = multiTalkGroupMember;
                        }
                        multiTalkGroupMember = multiTalkGroupMember22;
                    }
                }
                TalkRoom auE = C6001c.dTg().auE(C34572p.bSf().oGh.Aqc);
                if (auE != null) {
                    for (C24193av c24193av : auE.dTa()) {
                        if (c24193av.Aop.equals(username)) {
                            i = c24193av.kyZ;
                            break;
                        }
                    }
                }
                i = 0;
                if (!username.equals(C1853r.m3846Yz())) {
                    C4990ab.m7411d("MicroMsg.MT.MultiTalkTalkingUILogic", "steve:click memberId:%d", Integer.valueOf(i));
                    C34572p.bSf().mo24566Sj(username);
                    C16836f.m25970x(true, i);
                }
                if (!(C5023at.is2G(this.oIm) || C5023at.is3G(this.oIm))) {
                    z = false;
                }
                HashSet hashSet = new HashSet();
                hashSet.addAll(C34572p.bSf().oGf);
                if (C34572p.bSf().bRF()) {
                    hashSet.add(C1853r.m3846Yz());
                }
                c16839a = (C16839a) this.oIV.getTag();
                c16839a.oJe.mo41658Sr(username);
                c16839a.oJe.bSt();
                this.oIV.setTag(c16839a);
                C16836f.m25966a(this.oIV, multiTalkGroupMember, z, hashSet);
                this.oIV.setVisibility(0);
                this.oIZ = username;
                C12626e.bRD();
                AppMethodBeat.m2505o(54209);
            } else {
                AppMethodBeat.m2505o(54209);
            }
        } else if (view.getId() == 2131826232) {
            C34572p.bSf().mo24587h(true, false, false);
            AppMethodBeat.m2505o(54209);
        } else if (view.getId() == 2131826226) {
            C12626e.oFV++;
            C34572p.bSf().mo24590jn(true);
            C12626e.bRC();
            AppMethodBeat.m2505o(54209);
        } else {
            if (view.getId() == 2131826231) {
                if (this.oIR.isEnabled()) {
                    C12626e.oFX++;
                    C34572p.bSf().mo24591jo(this.oIR.isChecked());
                    bSp();
                    if (this.oIR.isChecked()) {
                        C12626e.bRx();
                        AppMethodBeat.m2505o(54209);
                        return;
                    }
                    C12626e.bRy();
                    AppMethodBeat.m2505o(54209);
                    return;
                }
            } else if (view.getId() == 2131826229) {
                C12626e.oFW++;
                C12630f bSf = C34572p.bSf();
                boolean isChecked = this.oIQ.isChecked();
                C34572p.bSe().oFP.mo58371rm(isChecked);
                bSf.mo24588jg(isChecked);
                if (this.oIQ.isChecked()) {
                    C12626e.bRv();
                    AppMethodBeat.m2505o(54209);
                    return;
                }
                C12626e.bRw();
                AppMethodBeat.m2505o(54209);
                return;
            } else if (view.getId() == 2131826233) {
                if (this.oIW != null) {
                    this.oIW.cLB();
                }
                C12626e.bRB();
                AppMethodBeat.m2505o(54209);
                return;
            } else if (view.getId() == 2131826230) {
                C12626e.oFY++;
                C4990ab.m7417i("MicroMsg.MT.MultiTalkTalkingUILogic", "summerper checkPermission checkcamera[%b], stack[%s], activity[%s]", Boolean.valueOf(C35805b.m58707a(this.oIm.mController.ylL, "android.permission.CAMERA", 22, "", "")), C5046bo.dpG(), this.oIm.mController.ylL);
                if (C35805b.m58707a(this.oIm.mController.ylL, "android.permission.CAMERA", 22, "", "")) {
                    boolean z2 = true;
                } else {
                    i = 0;
                }
                if (i == 0) {
                    this.oIP.setChecked(false);
                    AppMethodBeat.m2505o(54209);
                    return;
                } else if (!C34572p.bSf().bRH()) {
                    this.oIP.setChecked(false);
                    AppMethodBeat.m2505o(54209);
                    return;
                } else if (!C5023at.isNetworkConnected(this.oIm)) {
                    C17981e.m28295a(this.oIm, C25738R.string.f6c, null);
                    this.oIP.setChecked(false);
                    AppMethodBeat.m2505o(54209);
                    return;
                } else if (C34571j.bRY()) {
                    if (this.oIP.isChecked()) {
                        mo30834jr(false);
                        C12626e.bRz();
                    } else {
                        mo30835js(false);
                        C34572p.bSf().mo24599zf(1);
                        C12626e.bRA();
                    }
                    this.oIP.setChecked(C34572p.bSf().bRF());
                    AppMethodBeat.m2505o(54209);
                    return;
                } else {
                    Toast.makeText(this.oIm, C25738R.string.d24, 1).show();
                    this.oIP.setChecked(false);
                    AppMethodBeat.m2505o(54209);
                    return;
                }
            } else if (view.getId() == 2131826227) {
                C12626e.oFZ++;
                this.oIm.bSk();
            }
            AppMethodBeat.m2505o(54209);
        }
    }

    /* renamed from: d */
    public final void mo30833d(HashSet<String> hashSet) {
        AppMethodBeat.m2504i(54210);
        Iterator it = this.oIU.iterator();
        while (it.hasNext()) {
            C16839a c16839a = (C16839a) ((RelativeLayout) it.next()).getTag();
            if (!C1853r.m3846Yz().equals(c16839a.oJe.getUsername())) {
                if (hashSet.contains(c16839a.oJe.getUsername())) {
                    if (!c16839a.oJe.bSw()) {
                        c16839a.oJe.bSs();
                    }
                } else if (c16839a.oJe.bSw()) {
                    c16839a.oJe.bSr();
                    if (!(c16839a.oJe.getUsername() == null || c16839a.oJe.getUsername().equals(C1853r.m3846Yz()))) {
                        C4990ab.m7410d("MicroMsg.MT.MultiTalkTalkingUILogic", "steve: unsubscribe big video!");
                        C34572p.bSf().mo24566Sj("");
                        C16836f.m25970x(false, -1);
                    }
                    if (this.oIZ.equals(c16839a.oJe.getUsername()) && this.oIJ.getVisibility() == 0) {
                        this.oIZ = "";
                        this.oIJ.setVisibility(8);
                        this.oII.setVisibility(0);
                    }
                }
            }
        }
        AppMethodBeat.m2505o(54210);
    }

    public final void bSn() {
        AppMethodBeat.m2504i(54211);
        Iterator it = this.oIU.iterator();
        while (it.hasNext()) {
            C16839a c16839a = (C16839a) ((RelativeLayout) it.next()).getTag();
            if (!C1853r.m3846Yz().equals(c16839a.oJe.getUsername()) && c16839a.oJe.bSw()) {
                c16839a.oJe.bSr();
            }
        }
        AppMethodBeat.m2505o(54211);
    }

    /* renamed from: jr */
    public final void mo30834jr(boolean z) {
        ViewGroup Sq;
        AppMethodBeat.m2504i(54212);
        if (!z) {
            this.oJb = System.currentTimeMillis();
        }
        C4990ab.m7416i("MicroMsg.MT.MultiTalkTalkingUILogic", "start capture render");
        if (this.oIJ == null || this.oIJ.getVisibility() != 0) {
            Sq = mo30827Sq(C1853r.m3846Yz());
        } else {
            Sq = this.oIm.bSl();
        }
        if (Sq != null) {
            if (this.oIY == null) {
                C4990ab.m7416i("MicroMsg.MT.MultiTalkTalkingUILogic", "create capture View");
                this.oIY = new ObservableTextureView(this.oIm);
                this.oIY.setLayoutParams(new RelativeLayout.LayoutParams(1, 1));
                Sq.addView(this.oIY);
                this.oIY.setVisibility(0);
            }
            if (this.oIW == null) {
                C4990ab.m7416i("MicroMsg.MT.MultiTalkTalkingUILogic", "create capture Render");
                this.oIW = new C46326a(320, 240);
                this.oIW.mo74532a((C14088g) this, C34572p.bSf().oGe);
                this.oIW.mo74534a(this.oIY);
                this.oIW.cLC();
                C4990ab.m7417i("MicroMsg.MT.MultiTalkTalkingUILogic", "captureRender.mIsCurrentFaceCamera=%b captureRender.mIsCameraRemote180=%b", Boolean.valueOf(this.oIW.cLE()), Boolean.valueOf(this.oIW.cLF()));
            }
            if (this.oIX == null) {
                this.oIX = new C3512k(this.oIm);
                this.oIX.start();
            }
        }
        AppMethodBeat.m2505o(54212);
    }

    /* renamed from: js */
    public final void mo30835js(boolean z) {
        AppMethodBeat.m2504i(54213);
        if (!z && this.oJb != 0 && System.currentTimeMillis() - this.oJb > 0 && C34572p.bSf().bRc()) {
            C12626e.m20597r(System.currentTimeMillis() - this.oJb, C34571j.bRU());
            this.oJb = 0;
        }
        C4990ab.m7416i("MicroMsg.MT.MultiTalkTalkingUILogic", "stop capture render");
        if (this.oIY != null) {
            ViewParent parent = this.oIY.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.oIY);
            }
            this.oIY = null;
        }
        if (this.oIW != null) {
            this.oIW.cLD();
            this.oIW = null;
        }
        if (this.oIX != null) {
            this.oIX.stop();
            this.oIX = null;
        }
        AppMethodBeat.m2505o(54213);
    }

    public final boolean bRh() {
        return this.oIW != null;
    }

    /* renamed from: jt */
    public final void mo30836jt(boolean z) {
        AppMethodBeat.m2504i(54214);
        C4990ab.m7416i("MicroMsg.MT.MultiTalkTalkingUILogic", "onRefreshed");
        this.oJa = 0;
        if (!z) {
            C5004al.m7441d(new C168371());
        }
        mo30835js(false);
        Iterator it = this.oIU.iterator();
        while (it.hasNext()) {
            ((C16839a) ((RelativeLayout) it.next()).getTag()).oJe.setSurfaceTextureListener(null);
        }
        C17884o.acd().mo67500b(this);
        AppMethodBeat.m2505o(54214);
    }

    /* renamed from: a */
    public final void mo26415a(byte[] bArr, long j, int i, int i2, int i3, int i4) {
        AppMethodBeat.m2504i(54215);
        if (C34572p.bSf().bRH()) {
            if (this.oJc.oHc == null) {
                this.oJc.f3578w = i;
                this.oJc.f3577h = i2;
                this.oJc.oHc = new int[(this.oJc.f3578w * this.oJc.f3577h)];
            }
            if (!C34572p.bSf().bRF()) {
                C34571j.bRW();
                C34572p.bSf().mo24599zf(3);
            }
            long currentTimeMillis = System.currentTimeMillis();
            C34572p.bSf().oGe = this.oIW.cLE();
            int i5 = this.oIW.cLE() ? OpenGlRender.FLAG_Mirror : 0;
            int i6 = this.oIW.cLF() ? OpenGlRender.FLAG_Angle270 : OpenGlRender.FLAG_Angle90;
            C46732g a = C34572p.bSe().oFP.mo58360a(bArr, (int) j, this.oJc.f3578w, this.oJc.f3577h, (i3 + i4) & 31, this.oJc.oHc);
            if (a.ret < 0 || this.oJc.oHc == null || a.Aqp == 0 || a.Aqq == 0) {
                C4990ab.m7413e("MicroMsg.MT.MultiTalkTalkingUILogic", "ret: %d", Integer.valueOf(a.ret));
                AppMethodBeat.m2505o(54215);
                return;
            }
            int i7;
            long currentTimeMillis2 = System.currentTimeMillis();
            int i8 = i5 == OpenGlRender.FLAG_Mirror ? C31128d.MIC_PTU_ZIPAI_TOKYO : 1;
            if (C34572p.bSf().oGt) {
                i7 = i5 == OpenGlRender.FLAG_Mirror ? C31128d.MIC_PTU_ZIPAI_MEDSEA : 3;
            } else {
                i7 = i8;
            }
            i8 = C34572p.bSe().oFP.mo58359a(bArr, (short) ((int) j), i, i2, i3 + i4, i7);
            if (System.currentTimeMillis() - currentTimeMillis > 30) {
                C4990ab.m7411d("MicroMsg.MT.MultiTalkTalkingUILogic", "steve: trans size:%dx%d, total: %d, trans: %d, enc: %d", Integer.valueOf(a.Aqp), Integer.valueOf(a.Aqq), Long.valueOf(System.currentTimeMillis() - currentTimeMillis), Long.valueOf(currentTimeMillis2 - currentTimeMillis), Long.valueOf(System.currentTimeMillis() - currentTimeMillis2));
            }
            if (i8 <= 0) {
                C4990ab.m7419v("MicroMsg.MT.MultiTalkTalkingUILogic", "send ret = %d", Integer.valueOf(i8));
            }
            if (!(this.oIX == null || this.oJc.oHc == null)) {
                C3512k c3512k = this.oIX;
                int[] iArr = this.oJc.oHc;
                i8 = a.Aqp;
                int i9 = a.Aqq;
                int i10 = i3 + i4;
                if (iArr == null) {
                    C4990ab.m7412e("MicroMsg.MT.MultiTalkVideoNativeReceiver", "onDrawerReady pBuffer is null");
                    AppMethodBeat.m2505o(54215);
                    return;
                } else if (c3512k.oGY.eBB) {
                    C4990ab.m7410d("MicroMsg.MT.MultiTalkVideoNativeReceiver", "onDrawerReady busy!!!!");
                    AppMethodBeat.m2505o(54215);
                    return;
                } else {
                    if (c3512k.oGY.oHc == null) {
                        c3512k.oGY.oHc = new int[iArr.length];
                    }
                    c3512k.oGY.f1274w = i8;
                    c3512k.oGY.f1273h = i9;
                    c3512k.oGY.oHa = i10;
                    c3512k.oGY.oHb = i5;
                    c3512k.oGY.angle = i6;
                    long currentTimeMillis3 = System.currentTimeMillis();
                    i7 = c3512k.oGY.f1273h;
                    if (c3512k.oGY.f1273h > c3512k.oGY.f1274w) {
                        i7 = c3512k.oGY.f1274w;
                    }
                    if (c3512k.oGY.mQQ == null) {
                        c3512k.oGY.mQQ = Bitmap.createBitmap(i7, i7, Config.RGB_565);
                    }
                    if (c3512k.oGY.mQQ != null) {
                        c3512k.oGY.mQQ.setPixels(iArr, c3512k.oGY.f1274w - c3512k.oGY.f1273h, c3512k.oGY.f1274w, 0, 0, i7, i7);
                    }
                    if (System.currentTimeMillis() - currentTimeMillis3 > 30) {
                        C4990ab.m7411d("MicroMsg.MT.MultiTalkVideoNativeReceiver", "steve: createBitmap: %d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis3));
                    }
                    if (c3512k.oGX != null) {
                        c3512k.oGX.post(new C3515b());
                    }
                }
            }
            AppMethodBeat.m2505o(54215);
            return;
        }
        mo30835js(false);
        AppMethodBeat.m2505o(54215);
    }

    /* renamed from: a */
    public final synchronized void mo30829a(String str, int[] iArr, int i, int i2, int i3) {
        AppMethodBeat.m2504i(54216);
        if (this.oIJ.getVisibility() == 0) {
            C16839a c16839a = (C16839a) this.oIV.getTag();
            if (str.equals(c16839a.oJe.getUsername())) {
                c16839a.oJe.mo41659b(iArr, i, i2, i3);
            }
            AppMethodBeat.m2505o(54216);
        } else {
            RelativeLayout Sq = mo30827Sq(str);
            if (Sq != null) {
                ((C16839a) Sq.getTag()).oJe.mo41659b(iArr, i, i2, i3);
            }
            AppMethodBeat.m2505o(54216);
        }
    }

    /* renamed from: a */
    public final synchronized void mo30828a(String str, Bitmap bitmap, int i, int i2) {
        AppMethodBeat.m2504i(54217);
        if (this.oIJ.getVisibility() == 0) {
            C16839a c16839a = (C16839a) this.oIV.getTag();
            if (str.equals(c16839a.oJe.getUsername())) {
                c16839a.oJe.mo41665d(bitmap, i2, i);
            }
            AppMethodBeat.m2505o(54217);
        } else {
            RelativeLayout Sq = mo30827Sq(str);
            if (Sq != null) {
                ((C16839a) Sq.getTag()).oJe.mo41665d(bitmap, i2, i);
            }
            AppMethodBeat.m2505o(54217);
        }
    }

    public final void bSo() {
        AppMethodBeat.m2504i(54218);
        C4990ab.m7412e("MicroMsg.MT.MultiTalkTalkingUILogic", "onCameraError");
        if (this.gLj == null) {
            this.gLj = C17981e.m28295a(this.oIm, C25738R.string.f6d, new C126532());
        }
        if (!this.gLj.isShowing()) {
            this.gLj.show();
        }
        C34572p.bSf().mo24599zf(1);
        AppMethodBeat.m2505o(54218);
    }

    /* renamed from: qj */
    public final void mo20342qj(String str) {
        AppMethodBeat.m2504i(54219);
        C4990ab.m7417i("MicroMsg.MT.MultiTalkTalkingUILogic", "notifyChanged %s", str);
        RelativeLayout Sq = mo30827Sq(str);
        if (Sq != null) {
            ((C16839a) Sq.getTag()).oJe.bSq();
        }
        AppMethodBeat.m2505o(54219);
    }

    /* renamed from: a */
    private static void m25967a(C16839a c16839a) {
        AppMethodBeat.m2504i(54220);
        if (c16839a.ohf.getBackground() != null) {
            c16839a.ohf.setVisibility(0);
            ((AnimationDrawable) c16839a.ohf.getBackground()).stop();
            ((AnimationDrawable) c16839a.ohf.getBackground()).start();
        }
        AppMethodBeat.m2505o(54220);
    }

    /* renamed from: b */
    private static void m25969b(C16839a c16839a) {
        AppMethodBeat.m2504i(54221);
        if (c16839a.ohf.getBackground() != null) {
            ((AnimationDrawable) c16839a.ohf.getBackground()).stop();
        }
        c16839a.ohf.setVisibility(8);
        AppMethodBeat.m2505o(54221);
    }

    public final void bSp() {
        AppMethodBeat.m2504i(54222);
        if (this.oIR.isEnabled()) {
            C34572p.bSf().mo24593jq(this.oIR.isChecked());
        }
        AppMethodBeat.m2505o(54222);
    }
}
