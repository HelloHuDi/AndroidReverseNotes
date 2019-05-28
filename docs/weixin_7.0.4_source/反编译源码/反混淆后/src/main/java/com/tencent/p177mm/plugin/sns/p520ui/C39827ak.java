package com.tencent.p177mm.plugin.sns.p520ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ProgressBar;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.memory.C45434n;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.modelsns.C37952b;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p230g.p231a.C18379qt;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C23639t;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.plugin.sight.decode.p1020a.C34915a;
import com.tencent.p177mm.plugin.sight.decode.p512ui.C46201c;
import com.tencent.p177mm.plugin.sns.data.C29036i;
import com.tencent.p177mm.plugin.sns.model.C13373af;
import com.tencent.p177mm.plugin.sns.model.C29054ax;
import com.tencent.p177mm.plugin.sns.p1363c.C24826a;
import com.tencent.p177mm.plugin.sns.p517i.C24827g;
import com.tencent.p177mm.pointers.PInt;
import com.tencent.p177mm.protocal.protobuf.ayt;
import com.tencent.p177mm.protocal.protobuf.cco;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.vfs.C5730e;
import java.util.LinkedList;
import java.util.List;
import org.p1128b.p1132d.C41173i;

/* renamed from: com.tencent.mm.plugin.sns.ui.ak */
public final class C39827ak implements C22150y {
    MMActivity crP;
    String cvZ = "";
    private boolean cwB = false;
    private String desc = "";
    ProgressDialog ehJ = null;
    private View jAp = null;
    ProgressBar progressBar;
    private int rig;
    private C37952b rim = null;
    private Bitmap rkA = null;
    private C4884c rkN = new C136251();
    C29054ax rkO = null;
    private boolean rkz = false;
    C34915a rny;
    C46201c rnz = null;
    String thumbPath = "";
    String videoPath = "";

    /* renamed from: com.tencent.mm.plugin.sns.ui.ak$1 */
    class C136251 extends C4884c<C18379qt> {
        C136251() {
            AppMethodBeat.m2504i(38597);
            this.xxI = C18379qt.class.getName().hashCode();
            AppMethodBeat.m2505o(38597);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(38598);
            C18379qt c18379qt = (C18379qt) c4883b;
            C4990ab.m7417i("MicroMsg.SightWidget", "on sight send result callback, type %d", Integer.valueOf(c18379qt.cMT.type));
            switch (c18379qt.cMT.type) {
                case 1:
                    C4990ab.m7416i("MicroMsg.SightWidget", "come event done");
                    C39827ak.this.videoPath = c18379qt.cMT.videoPath;
                    C39827ak.this.cvZ = c18379qt.cMT.cMW;
                    if (C39827ak.this.ehJ != null) {
                        C39827ak.this.ehJ.dismiss();
                    }
                    C39827ak.this.rny.mo8509bf(C39827ak.this.videoPath, false);
                    C39827ak.this.progressBar.setVisibility(8);
                    if (c18379qt.cMT.cMV && C39827ak.this.rkO != null) {
                        C39827ak.this.csv();
                    }
                    C4990ab.m7417i("MicroMsg.SightWidget", "mux finish %B videoPath %s %d md5 %s", Boolean.valueOf(c18379qt.cMT.cMV), c18379qt.cMT.videoPath, Long.valueOf(C5730e.asZ(c18379qt.cMT.videoPath)), C39827ak.this.cvZ);
                    break;
            }
            AppMethodBeat.m2505o(38598);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.ak$2 */
    class C136262 implements OnClickListener {
        C136262() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(38599);
            if (C5730e.m8628ct(C39827ak.this.videoPath)) {
                if (C39827ak.this.rnz != null) {
                    C39827ak.this.rnz.dismiss();
                    C39827ak.this.rnz = null;
                }
                C39827ak.this.rnz = new C46201c(C39827ak.this.crP);
                C46201c c46201c = C39827ak.this.rnz;
                String str = C39827ak.this.videoPath;
                String str2 = C39827ak.this.thumbPath;
                c46201c.ePJ = str;
                c46201c.imagePath = str2;
                c46201c = C39827ak.this.rnz;
                c46201c.cPL = 0;
                c46201c.qxZ = 0;
                c46201c.mik = 1;
                C39827ak.this.rnz.show();
                AppMethodBeat.m2505o(38599);
                return;
            }
            C4990ab.m7416i("MicroMsg.SightWidget", "click videopath is not exist " + C39827ak.this.videoPath);
            AppMethodBeat.m2505o(38599);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.ak$3 */
    class C350903 implements OnCancelListener {
        C350903() {
        }

        public final void onCancel(DialogInterface dialogInterface) {
            C39827ak.this.rkO = null;
        }
    }

    public C39827ak(MMActivity mMActivity) {
        AppMethodBeat.m2504i(38600);
        this.crP = mMActivity;
        AppMethodBeat.m2505o(38600);
    }

    /* renamed from: M */
    public final void mo8910M(Bundle bundle) {
        AppMethodBeat.m2504i(38601);
        this.rim = C37952b.m64173u(this.crP.getIntent());
        this.thumbPath = this.crP.getIntent().getStringExtra("KSightThumbPath");
        this.videoPath = this.crP.getIntent().getStringExtra("KSightPath");
        this.cvZ = this.crP.getIntent().getStringExtra("sight_md5");
        this.rig = this.crP.getIntent().getIntExtra("Ksnsupload_source", 0);
        C18379qt c18379qt = new C18379qt();
        c18379qt.cMT.type = 2;
        C4879a.xxA.mo10055m(c18379qt);
        if (C5046bo.isNullOrNil(this.videoPath)) {
            this.videoPath = C5046bo.m7532bc(c18379qt.cMU.cMY, "");
            C4990ab.m7413e("MicroMsg.SightWidget", "videoPath is null %s", this.videoPath);
        }
        this.cvZ = C5046bo.isNullOrNil(this.cvZ) ? C5046bo.m7532bc(c18379qt.cMU.cMW, "") : this.cvZ;
        C4990ab.m7417i("MicroMsg.SightWidget", "oncreate thumb path %s videopath %s md5 %s", this.thumbPath, this.videoPath, this.cvZ);
        C4879a.xxA.mo10052c(this.rkN);
        AppMethodBeat.m2505o(38601);
    }

    /* renamed from: N */
    public final void mo8911N(Bundle bundle) {
    }

    public final boolean crG() {
        return true;
    }

    public final View crH() {
        AppMethodBeat.m2504i(38602);
        this.jAp = View.inflate(this.crP, 2130970981, null);
        this.rny = (C34915a) this.jAp.findViewById(2131820629);
        this.rny.setDrawableWidth(C1338a.fromDPToPix(this.crP, 90));
        this.progressBar = (ProgressBar) this.jAp.findViewById(2131823898);
        this.crP.getResources().getDisplayMetrics();
        this.jAp.findViewById(2131822515).setOnClickListener(new C136262());
        C4990ab.m7416i("MicroMsg.SightWidget", "videoPath " + this.videoPath + " thumbPath " + this.thumbPath + " " + C5730e.asZ(this.videoPath) + " " + C5730e.asZ(this.thumbPath));
        if (C5730e.m8628ct(this.videoPath)) {
            this.rny.mo8509bf(this.videoPath, false);
            this.progressBar.setVisibility(8);
            C4990ab.m7417i("MicroMsg.SightWidget", "videopath exist videopath %s md5 %s", this.videoPath, this.cvZ);
        } else {
            C45434n Xk = C29036i.m46088Xk(this.thumbPath);
            if (Xk != null) {
                this.rkA = Xk.mo73229Xh();
                if (C29036i.m46072B(this.rkA)) {
                    this.rny.setThumbBmp(this.rkA);
                }
            }
            this.progressBar.setVisibility(0);
        }
        View view = this.jAp;
        AppMethodBeat.m2505o(38602);
        return view;
    }

    /* renamed from: a */
    public final boolean mo8912a(int i, int i2, C41173i c41173i, String str, List<String> list, ayt ayt, int i3, boolean z, List<String> list2, PInt pInt, String str2, int i4, int i5) {
        AppMethodBeat.m2504i(38603);
        if (this.rkO != null) {
            AppMethodBeat.m2505o(38603);
            return false;
        }
        this.desc = str;
        LinkedList linkedList = new LinkedList();
        if (list != null) {
            LinkedList linkedList2 = new LinkedList();
            List Zn = C1855t.m3877Zn();
            for (String str3 : list) {
                if (!Zn.contains(str3)) {
                    cco cco = new cco();
                    cco.jBB = str3;
                    linkedList.add(cco);
                }
            }
        }
        this.rkO = new C29054ax(15);
        pInt.value = this.rkO.aPA;
        if (i3 > C24826a.qFE) {
            this.rkO.mo47138Dd(3);
        }
        C29054ax Ym = this.rkO.mo47144Ym(str);
        LinkedList linkedList3 = new LinkedList();
        Ym.mo47154a(ayt).mo47158ar(linkedList).mo47140Df(i).mo47141Dg(i2).mo47162dg(list2);
        if (z) {
            this.rkO.mo47143Di(1);
        } else {
            this.rkO.mo47143Di(0);
        }
        this.rkO.mo47162dg(list2).mo47140Df(i);
        this.rkO.mo47142Dh(this.rig);
        this.rkO.mo47164g(null, null, null, i4, i5);
        if (C5730e.m8628ct(this.videoPath)) {
            csv();
            AppMethodBeat.m2505o(38603);
            return true;
        }
        C4990ab.m7416i("MicroMsg.SightWidget", "commit file is not exist " + this.videoPath);
        Context context = this.crP;
        this.crP.getString(C25738R.string.f9238tz);
        this.ehJ = C30379h.m48458b(context, this.crP.getString(C25738R.string.eoh), true, new C350903());
        AppMethodBeat.m2505o(38603);
        return true;
    }

    /* Access modifiers changed, original: final */
    public final void csv() {
        AppMethodBeat.m2504i(38604);
        if (this.rkz) {
            AppMethodBeat.m2505o(38604);
        } else if (this.rkO.mo47168t(this.videoPath, this.thumbPath, this.desc, this.cvZ)) {
            C18379qt c18379qt = new C18379qt();
            c18379qt.cMT.type = 0;
            c18379qt.cMT.cMV = true;
            C4879a.xxA.mo10055m(c18379qt);
            this.rkz = true;
            int commit = this.rkO.commit();
            if (this.rim != null) {
                this.rim.mo60719ma(commit);
                C24827g.qTp.mo37379c(this.rim);
            }
            C13373af.cnM().rmK = 0;
            Intent intent = new Intent();
            intent.putExtra("sns_resume_state", false);
            intent.putExtra("sns_timeline_NeedFirstLoadint", true);
            intent.setClass(this.crP, SnsTimeLineUI.class);
            intent.addFlags(67108864);
            this.crP.startActivity(intent);
            this.crP.setResult(-1);
            this.crP.finish();
            AppMethodBeat.m2505o(38604);
        } else {
            C4990ab.m7416i("MicroMsg.SightWidget", "videopath " + C5730e.asZ(this.videoPath) + " thumb: " + C5730e.asZ(this.thumbPath));
            C23639t.makeText(this.crP, C25738R.string.e3n, 0).show();
            AppMethodBeat.m2505o(38604);
        }
    }

    /* renamed from: f */
    public final boolean mo8916f(int i, Intent intent) {
        return false;
    }

    public final boolean crI() {
        AppMethodBeat.m2504i(38605);
        if (this.ehJ != null) {
            this.ehJ.dismiss();
        }
        C4879a.xxA.mo10053d(this.rkN);
        if (C29036i.m46072B(this.rkA)) {
            this.rkA.recycle();
        }
        AppMethodBeat.m2505o(38605);
        return false;
    }
}
