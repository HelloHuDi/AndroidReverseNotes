package com.tencent.mm.plugin.sns.ui;

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
import com.tencent.mm.R;
import com.tencent.mm.g.a.qt;
import com.tencent.mm.memory.n;
import com.tencent.mm.model.t;
import com.tencent.mm.modelsns.b;
import com.tencent.mm.plugin.sight.decode.a.a;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.ax;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.protobuf.ayt;
import com.tencent.mm.protocal.protobuf.cco;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.vfs.e;
import java.util.LinkedList;
import java.util.List;

public final class ak implements y {
    MMActivity crP;
    String cvZ = "";
    private boolean cwB = false;
    private String desc = "";
    ProgressDialog ehJ = null;
    private View jAp = null;
    ProgressBar progressBar;
    private int rig;
    private b rim = null;
    private Bitmap rkA = null;
    private c rkN = new c<qt>() {
        {
            AppMethodBeat.i(38597);
            this.xxI = qt.class.getName().hashCode();
            AppMethodBeat.o(38597);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(38598);
            qt qtVar = (qt) bVar;
            ab.i("MicroMsg.SightWidget", "on sight send result callback, type %d", Integer.valueOf(qtVar.cMT.type));
            switch (qtVar.cMT.type) {
                case 1:
                    ab.i("MicroMsg.SightWidget", "come event done");
                    ak.this.videoPath = qtVar.cMT.videoPath;
                    ak.this.cvZ = qtVar.cMT.cMW;
                    if (ak.this.ehJ != null) {
                        ak.this.ehJ.dismiss();
                    }
                    ak.this.rny.bf(ak.this.videoPath, false);
                    ak.this.progressBar.setVisibility(8);
                    if (qtVar.cMT.cMV && ak.this.rkO != null) {
                        ak.this.csv();
                    }
                    ab.i("MicroMsg.SightWidget", "mux finish %B videoPath %s %d md5 %s", Boolean.valueOf(qtVar.cMT.cMV), qtVar.cMT.videoPath, Long.valueOf(e.asZ(qtVar.cMT.videoPath)), ak.this.cvZ);
                    break;
            }
            AppMethodBeat.o(38598);
            return false;
        }
    };
    ax rkO = null;
    private boolean rkz = false;
    a rny;
    com.tencent.mm.plugin.sight.decode.ui.c rnz = null;
    String thumbPath = "";
    String videoPath = "";

    public ak(MMActivity mMActivity) {
        AppMethodBeat.i(38600);
        this.crP = mMActivity;
        AppMethodBeat.o(38600);
    }

    public final void M(Bundle bundle) {
        AppMethodBeat.i(38601);
        this.rim = b.u(this.crP.getIntent());
        this.thumbPath = this.crP.getIntent().getStringExtra("KSightThumbPath");
        this.videoPath = this.crP.getIntent().getStringExtra("KSightPath");
        this.cvZ = this.crP.getIntent().getStringExtra("sight_md5");
        this.rig = this.crP.getIntent().getIntExtra("Ksnsupload_source", 0);
        qt qtVar = new qt();
        qtVar.cMT.type = 2;
        com.tencent.mm.sdk.b.a.xxA.m(qtVar);
        if (bo.isNullOrNil(this.videoPath)) {
            this.videoPath = bo.bc(qtVar.cMU.cMY, "");
            ab.e("MicroMsg.SightWidget", "videoPath is null %s", this.videoPath);
        }
        this.cvZ = bo.isNullOrNil(this.cvZ) ? bo.bc(qtVar.cMU.cMW, "") : this.cvZ;
        ab.i("MicroMsg.SightWidget", "oncreate thumb path %s videopath %s md5 %s", this.thumbPath, this.videoPath, this.cvZ);
        com.tencent.mm.sdk.b.a.xxA.c(this.rkN);
        AppMethodBeat.o(38601);
    }

    public final void N(Bundle bundle) {
    }

    public final boolean crG() {
        return true;
    }

    public final View crH() {
        AppMethodBeat.i(38602);
        this.jAp = View.inflate(this.crP, R.layout.b15, null);
        this.rny = (a) this.jAp.findViewById(R.id.bl);
        this.rny.setDrawableWidth(com.tencent.mm.bz.a.fromDPToPix(this.crP, 90));
        this.progressBar = (ProgressBar) this.jAp.findViewById(R.id.bpn);
        this.crP.getResources().getDisplayMetrics();
        this.jAp.findViewById(R.id.ap9).setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(38599);
                if (e.ct(ak.this.videoPath)) {
                    if (ak.this.rnz != null) {
                        ak.this.rnz.dismiss();
                        ak.this.rnz = null;
                    }
                    ak.this.rnz = new com.tencent.mm.plugin.sight.decode.ui.c(ak.this.crP);
                    com.tencent.mm.plugin.sight.decode.ui.c cVar = ak.this.rnz;
                    String str = ak.this.videoPath;
                    String str2 = ak.this.thumbPath;
                    cVar.ePJ = str;
                    cVar.imagePath = str2;
                    cVar = ak.this.rnz;
                    cVar.cPL = 0;
                    cVar.qxZ = 0;
                    cVar.mik = 1;
                    ak.this.rnz.show();
                    AppMethodBeat.o(38599);
                    return;
                }
                ab.i("MicroMsg.SightWidget", "click videopath is not exist " + ak.this.videoPath);
                AppMethodBeat.o(38599);
            }
        });
        ab.i("MicroMsg.SightWidget", "videoPath " + this.videoPath + " thumbPath " + this.thumbPath + " " + e.asZ(this.videoPath) + " " + e.asZ(this.thumbPath));
        if (e.ct(this.videoPath)) {
            this.rny.bf(this.videoPath, false);
            this.progressBar.setVisibility(8);
            ab.i("MicroMsg.SightWidget", "videopath exist videopath %s md5 %s", this.videoPath, this.cvZ);
        } else {
            n Xk = i.Xk(this.thumbPath);
            if (Xk != null) {
                this.rkA = Xk.Xh();
                if (i.B(this.rkA)) {
                    this.rny.setThumbBmp(this.rkA);
                }
            }
            this.progressBar.setVisibility(0);
        }
        View view = this.jAp;
        AppMethodBeat.o(38602);
        return view;
    }

    public final boolean a(int i, int i2, org.b.d.i iVar, String str, List<String> list, ayt ayt, int i3, boolean z, List<String> list2, PInt pInt, String str2, int i4, int i5) {
        AppMethodBeat.i(38603);
        if (this.rkO != null) {
            AppMethodBeat.o(38603);
            return false;
        }
        this.desc = str;
        LinkedList linkedList = new LinkedList();
        if (list != null) {
            LinkedList linkedList2 = new LinkedList();
            List Zn = t.Zn();
            for (String str3 : list) {
                if (!Zn.contains(str3)) {
                    cco cco = new cco();
                    cco.jBB = str3;
                    linkedList.add(cco);
                }
            }
        }
        this.rkO = new ax(15);
        pInt.value = this.rkO.aPA;
        if (i3 > com.tencent.mm.plugin.sns.c.a.qFE) {
            this.rkO.Dd(3);
        }
        ax Ym = this.rkO.Ym(str);
        LinkedList linkedList3 = new LinkedList();
        Ym.a(ayt).ar(linkedList).Df(i).Dg(i2).dg(list2);
        if (z) {
            this.rkO.Di(1);
        } else {
            this.rkO.Di(0);
        }
        this.rkO.dg(list2).Df(i);
        this.rkO.Dh(this.rig);
        this.rkO.g(null, null, null, i4, i5);
        if (e.ct(this.videoPath)) {
            csv();
            AppMethodBeat.o(38603);
            return true;
        }
        ab.i("MicroMsg.SightWidget", "commit file is not exist " + this.videoPath);
        Context context = this.crP;
        this.crP.getString(R.string.tz);
        this.ehJ = h.b(context, this.crP.getString(R.string.eoh), true, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                ak.this.rkO = null;
            }
        });
        AppMethodBeat.o(38603);
        return true;
    }

    /* Access modifiers changed, original: final */
    public final void csv() {
        AppMethodBeat.i(38604);
        if (this.rkz) {
            AppMethodBeat.o(38604);
        } else if (this.rkO.t(this.videoPath, this.thumbPath, this.desc, this.cvZ)) {
            qt qtVar = new qt();
            qtVar.cMT.type = 0;
            qtVar.cMT.cMV = true;
            com.tencent.mm.sdk.b.a.xxA.m(qtVar);
            this.rkz = true;
            int commit = this.rkO.commit();
            if (this.rim != null) {
                this.rim.ma(commit);
                g.qTp.c(this.rim);
            }
            af.cnM().rmK = 0;
            Intent intent = new Intent();
            intent.putExtra("sns_resume_state", false);
            intent.putExtra("sns_timeline_NeedFirstLoadint", true);
            intent.setClass(this.crP, SnsTimeLineUI.class);
            intent.addFlags(67108864);
            this.crP.startActivity(intent);
            this.crP.setResult(-1);
            this.crP.finish();
            AppMethodBeat.o(38604);
        } else {
            ab.i("MicroMsg.SightWidget", "videopath " + e.asZ(this.videoPath) + " thumb: " + e.asZ(this.thumbPath));
            com.tencent.mm.ui.base.t.makeText(this.crP, R.string.e3n, 0).show();
            AppMethodBeat.o(38604);
        }
    }

    public final boolean f(int i, Intent intent) {
        return false;
    }

    public final boolean crI() {
        AppMethodBeat.i(38605);
        if (this.ehJ != null) {
            this.ehJ.dismiss();
        }
        com.tencent.mm.sdk.b.a.xxA.d(this.rkN);
        if (i.B(this.rkA)) {
            this.rkA.recycle();
        }
        AppMethodBeat.o(38605);
        return false;
    }
}
