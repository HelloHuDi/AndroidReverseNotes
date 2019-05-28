package com.tencent.mm.plugin.multitalk.ui.widget;

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
import com.tencent.mm.R;
import com.tencent.mm.ah.o;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.multitalk.model.e;
import com.tencent.mm.plugin.multitalk.model.j;
import com.tencent.mm.plugin.multitalk.model.k;
import com.tencent.mm.plugin.multitalk.model.p;
import com.tencent.mm.plugin.multitalk.ui.MultiTalkMainUI;
import com.tencent.mm.plugin.video.ObservableTextureView;
import com.tencent.mm.plugin.voip.ui.MMCheckBox;
import com.tencent.mm.plugin.voip.video.OpenGlRender;
import com.tencent.mm.plugin.voip.video.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.ae;
import com.tencent.pb.common.b.a.a.av;
import com.tencent.pb.talkroom.sdk.MultiTalkGroup;
import com.tencent.pb.talkroom.sdk.MultiTalkGroupMember;
import com.tencent.view.d;
import com.tencent.wecall.talkroom.model.TalkRoom;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

public final class f implements OnClickListener, com.tencent.mm.ah.d.a, g {
    public TextView enf;
    com.tencent.mm.ui.widget.a.c gLj = null;
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
    private com.tencent.mm.plugin.voip.video.a oIW;
    private k oIX;
    private ObservableTextureView oIY;
    public String oIZ;
    private MultiTalkMainUI oIm;
    private ImageButton oIs;
    private int oJa;
    public long oJb;
    c oJc = new c(this, (byte) 0);

    public class b implements Runnable {
        a oJi;

        public b(a aVar) {
            this.oJi = aVar;
        }

        public final void run() {
            AppMethodBeat.i(54202);
            this.oJi.oJh.setVisibility(8);
            AppMethodBeat.o(54202);
        }
    }

    public static class a {
        View iVh;
        public MultiTalkVideoView oJe;
        public ImageView oJf;
        public ImageView oJg;
        public TextView oJh;
        ImageView ohf;
    }

    class c {
        int h;
        int[] oHc;
        int w;

        private c() {
        }

        /* synthetic */ c(f fVar, byte b) {
            this();
        }
    }

    public f(MultiTalkMainUI multiTalkMainUI) {
        int hC;
        RelativeLayout relativeLayout;
        AppMethodBeat.i(54203);
        this.oIm = multiTalkMainUI;
        this.oIK = (RelativeLayout) multiTalkMainUI.findViewById(R.id.dei);
        if (ae.hD(multiTalkMainUI.mController.ylL)) {
            hC = ae.hC(multiTalkMainUI.mController.ylL) + 0;
        } else {
            hC = 0;
        }
        this.oIK.setPadding(0, hC, 0, 0);
        this.enf = (TextView) multiTalkMainUI.findViewById(R.id.la);
        this.oIL = multiTalkMainUI.findViewById(R.id.deh);
        this.oIs = (ImageButton) multiTalkMainUI.findViewById(R.id.der);
        this.oII = (FrameLayout) multiTalkMainUI.findViewById(R.id.dej);
        this.oIJ = (FrameLayout) multiTalkMainUI.findViewById(R.id.dek);
        this.oIM = multiTalkMainUI.findViewById(R.id.del);
        this.oIN = multiTalkMainUI.findViewById(R.id.dem);
        this.oIP = (MMCheckBox) multiTalkMainUI.findViewById(R.id.dep);
        this.oIQ = (MMCheckBox) multiTalkMainUI.findViewById(R.id.deo);
        this.oIR = (MMCheckBox) multiTalkMainUI.findViewById(R.id.deq);
        this.oIO = multiTalkMainUI.findViewById(R.id.des);
        this.oIQ.setChecked(p.bSf().eif);
        this.oIR.setChecked(p.bSf().oGb);
        this.oIP.setChecked(p.bSf().bRF());
        this.oIS = com.tencent.mm.bz.a.gd(multiTalkMainUI.mController.ylL);
        this.oIT = b.eC(multiTalkMainUI.mController.ylL);
        ab.i("MicroMsg.MT.MultiTalkTalkingUILogic", "talkingAvatarContainerHeight %d", Integer.valueOf(this.oIT));
        this.oIs.setOnClickListener(this);
        this.oIM.setOnClickListener(this);
        this.oIP.setOnClickListener(this);
        this.oIQ.setOnClickListener(this);
        this.oIR.setOnClickListener(this);
        this.oIN.setOnClickListener(this);
        this.oIO.setOnClickListener(this);
        o.acd().a((com.tencent.mm.ah.d.a) this);
        for (int i = 8; i >= 0; i--) {
            relativeLayout = (RelativeLayout) LayoutInflater.from(multiTalkMainUI).inflate(R.layout.ab_, this.oII, false);
            a aVar = new a();
            aVar.oJe = (MultiTalkVideoView) relativeLayout.findViewById(R.id.d27);
            aVar.oJe.setIndex(i);
            aVar.oJe.setOnClickListener(this);
            aVar.iVh = relativeLayout.findViewById(R.id.d28);
            aVar.oJf = (ImageView) relativeLayout.findViewById(R.id.d2a);
            aVar.oJg = (ImageView) relativeLayout.findViewById(R.id.d2b);
            aVar.oJh = (TextView) relativeLayout.findViewById(R.id.d2_);
            aVar.ohf = (ImageView) relativeLayout.findViewById(R.id.d29);
            relativeLayout.setTag(aVar);
            relativeLayout.setVisibility(8);
            this.oIU.add(relativeLayout);
            this.oII.addView(relativeLayout);
        }
        if (this.oIJ != null) {
            relativeLayout = (RelativeLayout) LayoutInflater.from(multiTalkMainUI).inflate(R.layout.ab_, this.oIJ, false);
            a aVar2 = new a();
            aVar2.oJe = (MultiTalkVideoView) relativeLayout.findViewById(R.id.d27);
            aVar2.oJe.setIndex(0);
            aVar2.oJe.setOnClickListener(this);
            aVar2.iVh = relativeLayout.findViewById(R.id.d28);
            aVar2.oJf = (ImageView) relativeLayout.findViewById(R.id.d2a);
            aVar2.oJg = (ImageView) relativeLayout.findViewById(R.id.d2b);
            aVar2.oJh = (TextView) relativeLayout.findViewById(R.id.d2_);
            aVar2.ohf = (ImageView) relativeLayout.findViewById(R.id.d29);
            relativeLayout.setTag(aVar2);
            relativeLayout.setVisibility(8);
            this.oIV = relativeLayout;
            this.oIJ.addView(relativeLayout);
        }
        this.oIJ.setVisibility(8);
        if (p.bSf().bRF()) {
            this.oIO.setVisibility(0);
        } else {
            this.oIO.setVisibility(8);
        }
        this.oIZ = "";
        bSp();
        AppMethodBeat.o(54203);
    }

    public final void o(MultiTalkGroup multiTalkGroup) {
        AppMethodBeat.i(54204);
        this.oIL.setVisibility(0);
        LinkedList linkedList = new LinkedList();
        for (MultiTalkGroupMember multiTalkGroupMember : multiTalkGroup.Aqg) {
            if (multiTalkGroupMember.status == 10 || multiTalkGroupMember.status == 1) {
                linkedList.add(multiTalkGroupMember);
            }
        }
        ag(linkedList);
        bSp();
        AppMethodBeat.o(54204);
    }

    private void ag(LinkedList<MultiTalkGroupMember> linkedList) {
        int i;
        int i2;
        int i3;
        float[] fArr;
        AppMethodBeat.i(54205);
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
            ab.e("MicroMsg.MT.MultiTalkTalkingUILogic", "onlineUserSize larger than 9, %s", Integer.valueOf(this.oJa));
            AppMethodBeat.o(54205);
            return;
        }
        this.oII.setLayoutParams(layoutParams);
        ab.i("MicroMsg.MT.MultiTalkTalkingUILogic", "talkingAvatarWidth: %d | talkingAvatarHeight: %d | size %d", Integer.valueOf(i), Integer.valueOf(i3), Integer.valueOf(this.oJa));
        HashSet hashSet = new HashSet();
        hashSet.addAll(p.bSf().oGf);
        if (p.bSf().bRF()) {
            hashSet.add(r.Yz());
        }
        if (this.oJa <= 4) {
            fArr = j.oGR[this.oJa];
        } else {
            fArr = j.oGR[5];
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
                a(relativeLayout, multiTalkGroupMember, false, hashSet);
                relativeLayout.setVisibility(0);
                ab.i("MicroMsg.MT.MultiTalkTalkingUILogic", "setIvLayoutParams, width: %s, height: %s, marginLeft: %s, marginTop: %s", Integer.valueOf(i), Integer.valueOf(i3), Integer.valueOf(i6), Integer.valueOf(i5));
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
        if (!(!p.bSf().bRH() || this.oIP == null || this.oIP.isChecked())) {
            p.bSf().zf(1);
        }
        AppMethodBeat.o(54205);
    }

    private static void a(RelativeLayout relativeLayout, MultiTalkGroupMember multiTalkGroupMember, boolean z, HashSet<String> hashSet) {
        AppMethodBeat.i(54206);
        a aVar = (a) relativeLayout.getTag();
        if (multiTalkGroupMember != null) {
            aVar.oJe.Sr(multiTalkGroupMember.Aqh);
            aVar.oJe.setPosition(aVar.oJe.getIndex());
            if (multiTalkGroupMember.status != 10) {
                aVar.iVh.setVisibility(0);
                a(aVar);
            } else {
                aVar.iVh.setVisibility(8);
                b(aVar);
            }
            if (!hashSet.contains(multiTalkGroupMember.Aqh) || z) {
                aVar.oJe.bSr();
                AppMethodBeat.o(54206);
                return;
            }
            aVar.oJe.bSs();
            AppMethodBeat.o(54206);
            return;
        }
        aVar.iVh.setVisibility(8);
        b(aVar);
        aVar.oJe.bSt();
        AppMethodBeat.o(54206);
    }

    public final RelativeLayout Sq(String str) {
        AppMethodBeat.i(54207);
        Iterator it = this.oIU.iterator();
        while (it.hasNext()) {
            RelativeLayout relativeLayout = (RelativeLayout) it.next();
            if (str.equals(((a) relativeLayout.getTag()).oJe.getUsername())) {
                AppMethodBeat.o(54207);
                return relativeLayout;
            }
        }
        AppMethodBeat.o(54207);
        return null;
    }

    private static int x(boolean z, int i) {
        int i2;
        AppMethodBeat.i(54208);
        if (z) {
            i2 = i;
        } else {
            i2 = -1;
        }
        ByteBuffer allocate = ByteBuffer.allocate(4);
        allocate.order(ByteOrder.LITTLE_ENDIAN).putInt(i2);
        int appCmd = p.bSe().oFP.setAppCmd(22, allocate.array(), 4);
        if (appCmd < 0) {
            ab.e("MicroMsg.MT.MultiTalkTalkingUILogic", "steve:set netBigVideo failed or NO need!, ret:%d, vID:%d, memberId:%d", Integer.valueOf(appCmd), Integer.valueOf(i2), Integer.valueOf(i));
            AppMethodBeat.o(54208);
            return -1;
        }
        AppMethodBeat.o(54208);
        return appCmd;
    }

    public final void onClick(View view) {
        boolean z = true;
        AppMethodBeat.i(54209);
        int i;
        if (view instanceof MultiTalkVideoView) {
            MultiTalkVideoView multiTalkVideoView = (MultiTalkVideoView) view;
            a aVar;
            if (this.oIJ.getVisibility() != 8) {
                if (!(multiTalkVideoView.getUsername() == null || multiTalkVideoView.getUsername().equals(r.Yz()))) {
                    ab.d("MicroMsg.MT.MultiTalkTalkingUILogic", "steve: unsubscribe big video!");
                    p.bSf().Sj("");
                    x(false, -1);
                }
                this.oIJ.setVisibility(8);
                this.oII.setVisibility(0);
                if (this.oIV != null) {
                    aVar = (a) this.oIV.getTag();
                    if (aVar != null) {
                        aVar.oJe.bSt();
                    }
                }
                this.oIZ = "";
                e.bRE();
                AppMethodBeat.o(54209);
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
                if (p.bSf().oGh != null) {
                    for (MultiTalkGroupMember multiTalkGroupMember2 : p.bSf().oGh.Aqg) {
                        MultiTalkGroupMember multiTalkGroupMember22;
                        if ((multiTalkGroupMember22.status != 10 && multiTalkGroupMember22.status != 1) || !multiTalkGroupMember22.Aqh.equals(username)) {
                            multiTalkGroupMember22 = multiTalkGroupMember;
                        }
                        multiTalkGroupMember = multiTalkGroupMember22;
                    }
                }
                TalkRoom auE = com.tencent.wecall.talkroom.model.c.dTg().auE(p.bSf().oGh.Aqc);
                if (auE != null) {
                    for (av avVar : auE.dTa()) {
                        if (avVar.Aop.equals(username)) {
                            i = avVar.kyZ;
                            break;
                        }
                    }
                }
                i = 0;
                if (!username.equals(r.Yz())) {
                    ab.d("MicroMsg.MT.MultiTalkTalkingUILogic", "steve:click memberId:%d", Integer.valueOf(i));
                    p.bSf().Sj(username);
                    x(true, i);
                }
                if (!(at.is2G(this.oIm) || at.is3G(this.oIm))) {
                    z = false;
                }
                HashSet hashSet = new HashSet();
                hashSet.addAll(p.bSf().oGf);
                if (p.bSf().bRF()) {
                    hashSet.add(r.Yz());
                }
                aVar = (a) this.oIV.getTag();
                aVar.oJe.Sr(username);
                aVar.oJe.bSt();
                this.oIV.setTag(aVar);
                a(this.oIV, multiTalkGroupMember, z, hashSet);
                this.oIV.setVisibility(0);
                this.oIZ = username;
                e.bRD();
                AppMethodBeat.o(54209);
            } else {
                AppMethodBeat.o(54209);
            }
        } else if (view.getId() == R.id.der) {
            p.bSf().h(true, false, false);
            AppMethodBeat.o(54209);
        } else if (view.getId() == R.id.del) {
            e.oFV++;
            p.bSf().jn(true);
            e.bRC();
            AppMethodBeat.o(54209);
        } else {
            if (view.getId() == R.id.deq) {
                if (this.oIR.isEnabled()) {
                    e.oFX++;
                    p.bSf().jo(this.oIR.isChecked());
                    bSp();
                    if (this.oIR.isChecked()) {
                        e.bRx();
                        AppMethodBeat.o(54209);
                        return;
                    }
                    e.bRy();
                    AppMethodBeat.o(54209);
                    return;
                }
            } else if (view.getId() == R.id.deo) {
                e.oFW++;
                com.tencent.mm.plugin.multitalk.model.f bSf = p.bSf();
                boolean isChecked = this.oIQ.isChecked();
                p.bSe().oFP.rm(isChecked);
                bSf.jg(isChecked);
                if (this.oIQ.isChecked()) {
                    e.bRv();
                    AppMethodBeat.o(54209);
                    return;
                }
                e.bRw();
                AppMethodBeat.o(54209);
                return;
            } else if (view.getId() == R.id.des) {
                if (this.oIW != null) {
                    this.oIW.cLB();
                }
                e.bRB();
                AppMethodBeat.o(54209);
                return;
            } else if (view.getId() == R.id.dep) {
                e.oFY++;
                ab.i("MicroMsg.MT.MultiTalkTalkingUILogic", "summerper checkPermission checkcamera[%b], stack[%s], activity[%s]", Boolean.valueOf(com.tencent.mm.pluginsdk.permission.b.a(this.oIm.mController.ylL, "android.permission.CAMERA", 22, "", "")), bo.dpG(), this.oIm.mController.ylL);
                if (com.tencent.mm.pluginsdk.permission.b.a(this.oIm.mController.ylL, "android.permission.CAMERA", 22, "", "")) {
                    boolean z2 = true;
                } else {
                    i = 0;
                }
                if (i == 0) {
                    this.oIP.setChecked(false);
                    AppMethodBeat.o(54209);
                    return;
                } else if (!p.bSf().bRH()) {
                    this.oIP.setChecked(false);
                    AppMethodBeat.o(54209);
                    return;
                } else if (!at.isNetworkConnected(this.oIm)) {
                    com.tencent.mm.bg.e.a(this.oIm, R.string.f6c, null);
                    this.oIP.setChecked(false);
                    AppMethodBeat.o(54209);
                    return;
                } else if (j.bRY()) {
                    if (this.oIP.isChecked()) {
                        jr(false);
                        e.bRz();
                    } else {
                        js(false);
                        p.bSf().zf(1);
                        e.bRA();
                    }
                    this.oIP.setChecked(p.bSf().bRF());
                    AppMethodBeat.o(54209);
                    return;
                } else {
                    Toast.makeText(this.oIm, R.string.d24, 1).show();
                    this.oIP.setChecked(false);
                    AppMethodBeat.o(54209);
                    return;
                }
            } else if (view.getId() == R.id.dem) {
                e.oFZ++;
                this.oIm.bSk();
            }
            AppMethodBeat.o(54209);
        }
    }

    public final void d(HashSet<String> hashSet) {
        AppMethodBeat.i(54210);
        Iterator it = this.oIU.iterator();
        while (it.hasNext()) {
            a aVar = (a) ((RelativeLayout) it.next()).getTag();
            if (!r.Yz().equals(aVar.oJe.getUsername())) {
                if (hashSet.contains(aVar.oJe.getUsername())) {
                    if (!aVar.oJe.bSw()) {
                        aVar.oJe.bSs();
                    }
                } else if (aVar.oJe.bSw()) {
                    aVar.oJe.bSr();
                    if (!(aVar.oJe.getUsername() == null || aVar.oJe.getUsername().equals(r.Yz()))) {
                        ab.d("MicroMsg.MT.MultiTalkTalkingUILogic", "steve: unsubscribe big video!");
                        p.bSf().Sj("");
                        x(false, -1);
                    }
                    if (this.oIZ.equals(aVar.oJe.getUsername()) && this.oIJ.getVisibility() == 0) {
                        this.oIZ = "";
                        this.oIJ.setVisibility(8);
                        this.oII.setVisibility(0);
                    }
                }
            }
        }
        AppMethodBeat.o(54210);
    }

    public final void bSn() {
        AppMethodBeat.i(54211);
        Iterator it = this.oIU.iterator();
        while (it.hasNext()) {
            a aVar = (a) ((RelativeLayout) it.next()).getTag();
            if (!r.Yz().equals(aVar.oJe.getUsername()) && aVar.oJe.bSw()) {
                aVar.oJe.bSr();
            }
        }
        AppMethodBeat.o(54211);
    }

    public final void jr(boolean z) {
        ViewGroup Sq;
        AppMethodBeat.i(54212);
        if (!z) {
            this.oJb = System.currentTimeMillis();
        }
        ab.i("MicroMsg.MT.MultiTalkTalkingUILogic", "start capture render");
        if (this.oIJ == null || this.oIJ.getVisibility() != 0) {
            Sq = Sq(r.Yz());
        } else {
            Sq = this.oIm.bSl();
        }
        if (Sq != null) {
            if (this.oIY == null) {
                ab.i("MicroMsg.MT.MultiTalkTalkingUILogic", "create capture View");
                this.oIY = new ObservableTextureView(this.oIm);
                this.oIY.setLayoutParams(new RelativeLayout.LayoutParams(1, 1));
                Sq.addView(this.oIY);
                this.oIY.setVisibility(0);
            }
            if (this.oIW == null) {
                ab.i("MicroMsg.MT.MultiTalkTalkingUILogic", "create capture Render");
                this.oIW = new com.tencent.mm.plugin.voip.video.a(320, 240);
                this.oIW.a((g) this, p.bSf().oGe);
                this.oIW.a(this.oIY);
                this.oIW.cLC();
                ab.i("MicroMsg.MT.MultiTalkTalkingUILogic", "captureRender.mIsCurrentFaceCamera=%b captureRender.mIsCameraRemote180=%b", Boolean.valueOf(this.oIW.cLE()), Boolean.valueOf(this.oIW.cLF()));
            }
            if (this.oIX == null) {
                this.oIX = new k(this.oIm);
                this.oIX.start();
            }
        }
        AppMethodBeat.o(54212);
    }

    public final void js(boolean z) {
        AppMethodBeat.i(54213);
        if (!z && this.oJb != 0 && System.currentTimeMillis() - this.oJb > 0 && p.bSf().bRc()) {
            e.r(System.currentTimeMillis() - this.oJb, j.bRU());
            this.oJb = 0;
        }
        ab.i("MicroMsg.MT.MultiTalkTalkingUILogic", "stop capture render");
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
        AppMethodBeat.o(54213);
    }

    public final boolean bRh() {
        return this.oIW != null;
    }

    public final void jt(boolean z) {
        AppMethodBeat.i(54214);
        ab.i("MicroMsg.MT.MultiTalkTalkingUILogic", "onRefreshed");
        this.oJa = 0;
        if (!z) {
            al.d(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(54200);
                    f.this.enf.setText(R.string.d25);
                    AppMethodBeat.o(54200);
                }
            });
        }
        js(false);
        Iterator it = this.oIU.iterator();
        while (it.hasNext()) {
            ((a) ((RelativeLayout) it.next()).getTag()).oJe.setSurfaceTextureListener(null);
        }
        o.acd().b(this);
        AppMethodBeat.o(54214);
    }

    public final void a(byte[] bArr, long j, int i, int i2, int i3, int i4) {
        AppMethodBeat.i(54215);
        if (p.bSf().bRH()) {
            if (this.oJc.oHc == null) {
                this.oJc.w = i;
                this.oJc.h = i2;
                this.oJc.oHc = new int[(this.oJc.w * this.oJc.h)];
            }
            if (!p.bSf().bRF()) {
                j.bRW();
                p.bSf().zf(3);
            }
            long currentTimeMillis = System.currentTimeMillis();
            p.bSf().oGe = this.oIW.cLE();
            int i5 = this.oIW.cLE() ? OpenGlRender.FLAG_Mirror : 0;
            int i6 = this.oIW.cLF() ? OpenGlRender.FLAG_Angle270 : OpenGlRender.FLAG_Angle90;
            com.tencent.pb.talkroom.sdk.g a = p.bSe().oFP.a(bArr, (int) j, this.oJc.w, this.oJc.h, (i3 + i4) & 31, this.oJc.oHc);
            if (a.ret < 0 || this.oJc.oHc == null || a.Aqp == 0 || a.Aqq == 0) {
                ab.e("MicroMsg.MT.MultiTalkTalkingUILogic", "ret: %d", Integer.valueOf(a.ret));
                AppMethodBeat.o(54215);
                return;
            }
            int i7;
            long currentTimeMillis2 = System.currentTimeMillis();
            int i8 = i5 == OpenGlRender.FLAG_Mirror ? d.MIC_PTU_ZIPAI_TOKYO : 1;
            if (p.bSf().oGt) {
                i7 = i5 == OpenGlRender.FLAG_Mirror ? d.MIC_PTU_ZIPAI_MEDSEA : 3;
            } else {
                i7 = i8;
            }
            i8 = p.bSe().oFP.a(bArr, (short) ((int) j), i, i2, i3 + i4, i7);
            if (System.currentTimeMillis() - currentTimeMillis > 30) {
                ab.d("MicroMsg.MT.MultiTalkTalkingUILogic", "steve: trans size:%dx%d, total: %d, trans: %d, enc: %d", Integer.valueOf(a.Aqp), Integer.valueOf(a.Aqq), Long.valueOf(System.currentTimeMillis() - currentTimeMillis), Long.valueOf(currentTimeMillis2 - currentTimeMillis), Long.valueOf(System.currentTimeMillis() - currentTimeMillis2));
            }
            if (i8 <= 0) {
                ab.v("MicroMsg.MT.MultiTalkTalkingUILogic", "send ret = %d", Integer.valueOf(i8));
            }
            if (!(this.oIX == null || this.oJc.oHc == null)) {
                k kVar = this.oIX;
                int[] iArr = this.oJc.oHc;
                i8 = a.Aqp;
                int i9 = a.Aqq;
                int i10 = i3 + i4;
                if (iArr == null) {
                    ab.e("MicroMsg.MT.MultiTalkVideoNativeReceiver", "onDrawerReady pBuffer is null");
                    AppMethodBeat.o(54215);
                    return;
                } else if (kVar.oGY.eBB) {
                    ab.d("MicroMsg.MT.MultiTalkVideoNativeReceiver", "onDrawerReady busy!!!!");
                    AppMethodBeat.o(54215);
                    return;
                } else {
                    if (kVar.oGY.oHc == null) {
                        kVar.oGY.oHc = new int[iArr.length];
                    }
                    kVar.oGY.w = i8;
                    kVar.oGY.h = i9;
                    kVar.oGY.oHa = i10;
                    kVar.oGY.oHb = i5;
                    kVar.oGY.angle = i6;
                    long currentTimeMillis3 = System.currentTimeMillis();
                    i7 = kVar.oGY.h;
                    if (kVar.oGY.h > kVar.oGY.w) {
                        i7 = kVar.oGY.w;
                    }
                    if (kVar.oGY.mQQ == null) {
                        kVar.oGY.mQQ = Bitmap.createBitmap(i7, i7, Config.RGB_565);
                    }
                    if (kVar.oGY.mQQ != null) {
                        kVar.oGY.mQQ.setPixels(iArr, kVar.oGY.w - kVar.oGY.h, kVar.oGY.w, 0, 0, i7, i7);
                    }
                    if (System.currentTimeMillis() - currentTimeMillis3 > 30) {
                        ab.d("MicroMsg.MT.MultiTalkVideoNativeReceiver", "steve: createBitmap: %d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis3));
                    }
                    if (kVar.oGX != null) {
                        kVar.oGX.post(new com.tencent.mm.plugin.multitalk.model.k.b());
                    }
                }
            }
            AppMethodBeat.o(54215);
            return;
        }
        js(false);
        AppMethodBeat.o(54215);
    }

    public final synchronized void a(String str, int[] iArr, int i, int i2, int i3) {
        AppMethodBeat.i(54216);
        if (this.oIJ.getVisibility() == 0) {
            a aVar = (a) this.oIV.getTag();
            if (str.equals(aVar.oJe.getUsername())) {
                aVar.oJe.b(iArr, i, i2, i3);
            }
            AppMethodBeat.o(54216);
        } else {
            RelativeLayout Sq = Sq(str);
            if (Sq != null) {
                ((a) Sq.getTag()).oJe.b(iArr, i, i2, i3);
            }
            AppMethodBeat.o(54216);
        }
    }

    public final synchronized void a(String str, Bitmap bitmap, int i, int i2) {
        AppMethodBeat.i(54217);
        if (this.oIJ.getVisibility() == 0) {
            a aVar = (a) this.oIV.getTag();
            if (str.equals(aVar.oJe.getUsername())) {
                aVar.oJe.d(bitmap, i2, i);
            }
            AppMethodBeat.o(54217);
        } else {
            RelativeLayout Sq = Sq(str);
            if (Sq != null) {
                ((a) Sq.getTag()).oJe.d(bitmap, i2, i);
            }
            AppMethodBeat.o(54217);
        }
    }

    public final void bSo() {
        AppMethodBeat.i(54218);
        ab.e("MicroMsg.MT.MultiTalkTalkingUILogic", "onCameraError");
        if (this.gLj == null) {
            this.gLj = com.tencent.mm.bg.e.a(this.oIm, R.string.f6d, new Runnable() {
                public final void run() {
                    AppMethodBeat.i(54201);
                    f.this.js(false);
                    AppMethodBeat.o(54201);
                }
            });
        }
        if (!this.gLj.isShowing()) {
            this.gLj.show();
        }
        p.bSf().zf(1);
        AppMethodBeat.o(54218);
    }

    public final void qj(String str) {
        AppMethodBeat.i(54219);
        ab.i("MicroMsg.MT.MultiTalkTalkingUILogic", "notifyChanged %s", str);
        RelativeLayout Sq = Sq(str);
        if (Sq != null) {
            ((a) Sq.getTag()).oJe.bSq();
        }
        AppMethodBeat.o(54219);
    }

    private static void a(a aVar) {
        AppMethodBeat.i(54220);
        if (aVar.ohf.getBackground() != null) {
            aVar.ohf.setVisibility(0);
            ((AnimationDrawable) aVar.ohf.getBackground()).stop();
            ((AnimationDrawable) aVar.ohf.getBackground()).start();
        }
        AppMethodBeat.o(54220);
    }

    private static void b(a aVar) {
        AppMethodBeat.i(54221);
        if (aVar.ohf.getBackground() != null) {
            ((AnimationDrawable) aVar.ohf.getBackground()).stop();
        }
        aVar.ohf.setVisibility(8);
        AppMethodBeat.o(54221);
    }

    public final void bSp() {
        AppMethodBeat.i(54222);
        if (this.oIR.isEnabled()) {
            p.bSf().jq(this.oIR.isChecked());
        }
        AppMethodBeat.o(54222);
    }
}
