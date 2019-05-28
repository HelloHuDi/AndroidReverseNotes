package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.at.c;
import com.tencent.mm.model.t;
import com.tencent.mm.modelsns.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.c.a;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.ax;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.protobuf.ayt;
import com.tencent.mm.protocal.protobuf.cco;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.v;
import com.tencent.mm.vfs.e;
import java.util.LinkedList;
import java.util.List;

public final class o implements y {
    private String appId = "";
    private String appName = "";
    private String cMg;
    private MMActivity crP;
    private Bitmap fru = null;
    private TextView gne = null;
    private int h = -1;
    private String imgPath = "";
    private View jAp = null;
    private String link = "";
    private boolean mog = false;
    private String rid = "";
    private byte[] rie = null;
    private String rif;
    private int rig;
    private CdnImageView rih = null;
    private TextView rii = null;
    private int rij;
    private String rik = "";
    private String ril = "";
    private b rim = null;
    private String title = "";
    private int w = -1;

    public o(MMActivity mMActivity) {
        this.crP = mMActivity;
    }

    public final void M(Bundle bundle) {
        AppMethodBeat.i(38219);
        this.rim = b.u(this.crP.getIntent());
        this.w = this.crP.getIntent().getIntExtra("Ksnsupload_width", -1);
        this.h = this.crP.getIntent().getIntExtra("Ksnsupload_height", -1);
        this.rig = this.crP.getIntent().getIntExtra("Ksnsupload_source", 0);
        this.link = bo.bc(this.crP.getIntent().getStringExtra("Ksnsupload_link"), "");
        this.title = bo.bc(this.crP.getIntent().getStringExtra("Ksnsupload_title"), "");
        this.rid = bo.bc(this.crP.getIntent().getStringExtra("Ksnsupload_imgurl"), "");
        this.imgPath = this.crP.getIntent().getStringExtra("KsnsUpload_imgPath");
        this.mog = this.crP.getIntent().getBooleanExtra("ksnsis_video", false);
        this.cMg = bo.bc(this.crP.getIntent().getStringExtra("src_username"), "");
        this.rif = bo.bc(this.crP.getIntent().getStringExtra("src_displayname"), "");
        this.ril = bo.bc(this.crP.getIntent().getStringExtra("KContentObjDesc"), "");
        this.rik = bo.bc(this.crP.getIntent().getStringExtra("KUploadProduct_UserData"), "");
        this.appName = bo.bc(this.crP.getIntent().getStringExtra("Ksnsupload_appname"), "");
        this.appId = bo.bc(this.crP.getIntent().getStringExtra("Ksnsupload_appid"), "");
        this.rij = this.crP.getIntent().getIntExtra("KUploadProduct_subType", 0);
        AppMethodBeat.o(38219);
    }

    public final void N(Bundle bundle) {
    }

    public final boolean crG() {
        return true;
    }

    public final View crH() {
        AppMethodBeat.i(38220);
        this.jAp = v.hu(this.crP).inflate(R.layout.b12, null);
        this.rih = (CdnImageView) this.jAp.findViewById(R.id.d11);
        this.gne = (TextView) this.jAp.findViewById(R.id.d13);
        this.rii = (TextView) this.jAp.findViewById(R.id.d14);
        if (this.mog) {
            this.jAp.findViewById(R.id.c9m).setVisibility(0);
        } else {
            this.jAp.findViewById(R.id.c9m).setVisibility(8);
        }
        this.gne.setText(this.title);
        if (!bo.isNullOrNil(this.rid)) {
            this.rih.setVisibility(0);
            this.rih.setUrl(this.rid);
        } else if (bo.cb(this.rie)) {
            this.rih.setVisibility(8);
        } else {
            this.rih.setVisibility(0);
            this.fru = d.bQ(this.rie);
            this.rih.setImageBitmap(this.fru);
        }
        i.b(this.rih, this.crP);
        View view = this.jAp;
        AppMethodBeat.o(38220);
        return view;
    }

    public final boolean a(int i, int i2, org.b.d.i iVar, String str, List<String> list, ayt ayt, int i3, boolean z, List<String> list2, PInt pInt, String str2, int i4, int i5) {
        AppMethodBeat.i(38221);
        ax axVar = new ax(10);
        pInt.value = axVar.aPA;
        if (i3 > a.qFE) {
            axVar.Dd(2);
        }
        if (iVar != null) {
            axVar.gc(iVar.token, iVar.wFn);
        }
        axVar.Yr(this.title).Yp(this.ril).Yq(this.link).Ym(str);
        boolean z2 = false;
        if (!bo.isNullOrNil(this.imgPath)) {
            z2 = axVar.a(e.e(this.imgPath, 0, -1), this.ril, this.title, this.rij, this.rik);
        } else if (!(bo.isNullOrNil(this.rid) || com.tencent.mm.at.o.ahk() == null)) {
            com.tencent.mm.at.o.ahk();
            Bitmap kR = c.kR(this.rid);
            if (kR != null) {
                z2 = axVar.a(d.aj(kR), this.ril, this.title, this.rij, this.rik);
            }
        }
        if (!z2) {
            ab.i("MicroMsg.EmojiShareWidget", "set userData user imgurl ");
            z2 = axVar.b(this.rid, this.rid, this.ril, this.rij, this.rik);
        }
        if (!z2) {
            ab.e("MicroMsg.EmojiShareWidget", "set userData faild");
        }
        axVar.Dh(this.rig);
        axVar.Yu(this.cMg);
        axVar.Yv(this.rif);
        if (z) {
            axVar.Di(1);
        } else {
            axVar.Di(0);
        }
        axVar.dg(list2);
        if (!bo.isNullOrNil(this.appId)) {
            axVar.Ys(this.appId);
            axVar.Yt(this.appName);
        }
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
        axVar.ar(linkedList).Df(i);
        axVar.g(null, null, null, i4, i5);
        axVar.a(ayt);
        int commit = axVar.commit();
        if (this.rim != null) {
            this.rim.ma(commit);
            g.qTp.c(this.rim);
        }
        af.cnB().cmp();
        this.crP.finish();
        String Jl = ((com.tencent.mm.plugin.emoji.b.d) com.tencent.mm.kernel.g.M(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().Jl(this.rik);
        h.pYm.e(10993, Integer.valueOf(1), Jl);
        AppMethodBeat.o(38221);
        return false;
    }

    public final boolean f(int i, Intent intent) {
        return false;
    }

    public final boolean crI() {
        AppMethodBeat.i(38222);
        if (!(this.fru == null || this.fru.isRecycled())) {
            this.fru.recycle();
        }
        AppMethodBeat.o(38222);
        return false;
    }
}
