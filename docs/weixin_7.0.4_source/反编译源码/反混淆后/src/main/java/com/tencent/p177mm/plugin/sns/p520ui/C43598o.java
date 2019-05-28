package com.tencent.p177mm.plugin.sns.p520ui;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.modelsns.C37952b;
import com.tencent.p177mm.p190at.C17937c;
import com.tencent.p177mm.p190at.C32291o;
import com.tencent.p177mm.p612ui.C5616v;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.plugin.emoji.p725b.C6835d;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.sns.data.C29036i;
import com.tencent.p177mm.plugin.sns.model.C13373af;
import com.tencent.p177mm.plugin.sns.model.C29054ax;
import com.tencent.p177mm.plugin.sns.p1363c.C24826a;
import com.tencent.p177mm.plugin.sns.p517i.C24827g;
import com.tencent.p177mm.pluginsdk.p597ui.applet.CdnImageView;
import com.tencent.p177mm.pointers.PInt;
import com.tencent.p177mm.protocal.protobuf.ayt;
import com.tencent.p177mm.protocal.protobuf.cco;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5056d;
import com.tencent.p177mm.vfs.C5730e;
import java.util.LinkedList;
import java.util.List;
import org.p1128b.p1132d.C41173i;

/* renamed from: com.tencent.mm.plugin.sns.ui.o */
public final class C43598o implements C22150y {
    private String appId = "";
    private String appName = "";
    private String cMg;
    private MMActivity crP;
    private Bitmap fru = null;
    private TextView gne = null;
    /* renamed from: h */
    private int f17212h = -1;
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
    private C37952b rim = null;
    private String title = "";
    /* renamed from: w */
    private int f17213w = -1;

    public C43598o(MMActivity mMActivity) {
        this.crP = mMActivity;
    }

    /* renamed from: M */
    public final void mo8910M(Bundle bundle) {
        AppMethodBeat.m2504i(38219);
        this.rim = C37952b.m64173u(this.crP.getIntent());
        this.f17213w = this.crP.getIntent().getIntExtra("Ksnsupload_width", -1);
        this.f17212h = this.crP.getIntent().getIntExtra("Ksnsupload_height", -1);
        this.rig = this.crP.getIntent().getIntExtra("Ksnsupload_source", 0);
        this.link = C5046bo.m7532bc(this.crP.getIntent().getStringExtra("Ksnsupload_link"), "");
        this.title = C5046bo.m7532bc(this.crP.getIntent().getStringExtra("Ksnsupload_title"), "");
        this.rid = C5046bo.m7532bc(this.crP.getIntent().getStringExtra("Ksnsupload_imgurl"), "");
        this.imgPath = this.crP.getIntent().getStringExtra("KsnsUpload_imgPath");
        this.mog = this.crP.getIntent().getBooleanExtra("ksnsis_video", false);
        this.cMg = C5046bo.m7532bc(this.crP.getIntent().getStringExtra("src_username"), "");
        this.rif = C5046bo.m7532bc(this.crP.getIntent().getStringExtra("src_displayname"), "");
        this.ril = C5046bo.m7532bc(this.crP.getIntent().getStringExtra("KContentObjDesc"), "");
        this.rik = C5046bo.m7532bc(this.crP.getIntent().getStringExtra("KUploadProduct_UserData"), "");
        this.appName = C5046bo.m7532bc(this.crP.getIntent().getStringExtra("Ksnsupload_appname"), "");
        this.appId = C5046bo.m7532bc(this.crP.getIntent().getStringExtra("Ksnsupload_appid"), "");
        this.rij = this.crP.getIntent().getIntExtra("KUploadProduct_subType", 0);
        AppMethodBeat.m2505o(38219);
    }

    /* renamed from: N */
    public final void mo8911N(Bundle bundle) {
    }

    public final boolean crG() {
        return true;
    }

    public final View crH() {
        AppMethodBeat.m2504i(38220);
        this.jAp = C5616v.m8409hu(this.crP).inflate(2130970978, null);
        this.rih = (CdnImageView) this.jAp.findViewById(2131825687);
        this.gne = (TextView) this.jAp.findViewById(2131825689);
        this.rii = (TextView) this.jAp.findViewById(2131825690);
        if (this.mog) {
            this.jAp.findViewById(2131824637).setVisibility(0);
        } else {
            this.jAp.findViewById(2131824637).setVisibility(8);
        }
        this.gne.setText(this.title);
        if (!C5046bo.isNullOrNil(this.rid)) {
            this.rih.setVisibility(0);
            this.rih.setUrl(this.rid);
        } else if (C5046bo.m7540cb(this.rie)) {
            this.rih.setVisibility(8);
        } else {
            this.rih.setVisibility(0);
            this.fru = C5056d.m7652bQ(this.rie);
            this.rih.setImageBitmap(this.fru);
        }
        C29036i.m46100b(this.rih, this.crP);
        View view = this.jAp;
        AppMethodBeat.m2505o(38220);
        return view;
    }

    /* renamed from: a */
    public final boolean mo8912a(int i, int i2, C41173i c41173i, String str, List<String> list, ayt ayt, int i3, boolean z, List<String> list2, PInt pInt, String str2, int i4, int i5) {
        AppMethodBeat.m2504i(38221);
        C29054ax c29054ax = new C29054ax(10);
        pInt.value = c29054ax.aPA;
        if (i3 > C24826a.qFE) {
            c29054ax.mo47138Dd(2);
        }
        if (c41173i != null) {
            c29054ax.mo47165gc(c41173i.token, c41173i.wFn);
        }
        c29054ax.mo47149Yr(this.title).mo47147Yp(this.ril).mo47148Yq(this.link).mo47144Ym(str);
        boolean z2 = false;
        if (!C5046bo.isNullOrNil(this.imgPath)) {
            z2 = c29054ax.mo47155a(C5730e.m8632e(this.imgPath, 0, -1), this.ril, this.title, this.rij, this.rik);
        } else if (!(C5046bo.isNullOrNil(this.rid) || C32291o.ahk() == null)) {
            C32291o.ahk();
            Bitmap kR = C17937c.m28186kR(this.rid);
            if (kR != null) {
                z2 = c29054ax.mo47155a(C5056d.m7637aj(kR), this.ril, this.title, this.rij, this.rik);
            }
        }
        if (!z2) {
            C4990ab.m7416i("MicroMsg.EmojiShareWidget", "set userData user imgurl ");
            z2 = c29054ax.mo47159b(this.rid, this.rid, this.ril, this.rij, this.rik);
        }
        if (!z2) {
            C4990ab.m7412e("MicroMsg.EmojiShareWidget", "set userData faild");
        }
        c29054ax.mo47142Dh(this.rig);
        c29054ax.mo47152Yu(this.cMg);
        c29054ax.mo47153Yv(this.rif);
        if (z) {
            c29054ax.mo47143Di(1);
        } else {
            c29054ax.mo47143Di(0);
        }
        c29054ax.mo47162dg(list2);
        if (!C5046bo.isNullOrNil(this.appId)) {
            c29054ax.mo47150Ys(this.appId);
            c29054ax.mo47151Yt(this.appName);
        }
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
        c29054ax.mo47158ar(linkedList).mo47140Df(i);
        c29054ax.mo47164g(null, null, null, i4, i5);
        c29054ax.mo47154a(ayt);
        int commit = c29054ax.commit();
        if (this.rim != null) {
            this.rim.mo60719ma(commit);
            C24827g.qTp.mo37379c(this.rim);
        }
        C13373af.cnB().cmp();
        this.crP.finish();
        String Jl = ((C6835d) C1720g.m3530M(C6835d.class)).getEmojiMgr().mo35604Jl(this.rik);
        C7060h.pYm.mo8381e(10993, Integer.valueOf(1), Jl);
        AppMethodBeat.m2505o(38221);
        return false;
    }

    /* renamed from: f */
    public final boolean mo8916f(int i, Intent intent) {
        return false;
    }

    public final boolean crI() {
        AppMethodBeat.m2504i(38222);
        if (!(this.fru == null || this.fru.isRecycled())) {
            this.fru.recycle();
        }
        AppMethodBeat.m2505o(38222);
        return false;
    }
}
