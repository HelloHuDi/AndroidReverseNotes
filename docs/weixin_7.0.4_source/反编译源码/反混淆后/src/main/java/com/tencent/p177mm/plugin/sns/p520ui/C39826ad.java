package com.tencent.p177mm.plugin.sns.p520ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.modelsns.C37952b;
import com.tencent.p177mm.opensdk.modelmsg.SendMessageToWX.Req;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.p612ui.C5510e.C5504k;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.plugin.sns.model.C13373af;
import com.tencent.p177mm.plugin.sns.model.C29054ax;
import com.tencent.p177mm.plugin.sns.p1363c.C24826a;
import com.tencent.p177mm.plugin.sns.p517i.C24827g;
import com.tencent.p177mm.pointers.PInt;
import com.tencent.p177mm.protocal.protobuf.ayt;
import com.tencent.p177mm.protocal.protobuf.cco;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.LinkedList;
import java.util.List;
import org.p1128b.p1132d.C41173i;

/* renamed from: com.tencent.mm.plugin.sns.ui.ad */
public final class C39826ad implements C22150y {
    private String appName = "";
    private MMActivity crP;
    private String csB = "";
    private int rig;
    private C37952b rim = null;
    private boolean rjF = false;
    private boolean rjG = false;
    private WXMediaMessage rjH = null;
    private String rkV = "";
    private boolean rkW = false;

    public C39826ad(MMActivity mMActivity, boolean z) {
        this.crP = mMActivity;
        this.rkW = z;
    }

    /* renamed from: M */
    public final void mo8910M(Bundle bundle) {
        AppMethodBeat.m2504i(38358);
        this.rim = C37952b.m64173u(this.crP.getIntent());
        this.rkV = this.crP.getIntent().getStringExtra(C5504k.ygd);
        this.csB = C5046bo.m7532bc(this.crP.getIntent().getStringExtra("Ksnsupload_appid"), "");
        this.appName = C5046bo.m7532bc(this.crP.getIntent().getStringExtra("Ksnsupload_appname"), "");
        this.rjF = this.crP.getIntent().getBooleanExtra("KThrid_app", false);
        this.rjG = this.crP.getIntent().getBooleanExtra("KSnsAction", false);
        this.rig = this.crP.getIntent().getIntExtra("Ksnsupload_source", 0);
        Bundle bundleExtra = this.crP.getIntent().getBundleExtra("Ksnsupload_timeline");
        if (bundleExtra != null) {
            this.rjH = new Req(bundleExtra).message;
        }
        AppMethodBeat.m2505o(38358);
    }

    /* renamed from: N */
    public final void mo8911N(Bundle bundle) {
    }

    public final boolean crG() {
        return this.rkW;
    }

    public final View crH() {
        return null;
    }

    /* renamed from: a */
    public final boolean mo8912a(int i, int i2, C41173i c41173i, String str, List<String> list, ayt ayt, int i3, boolean z, List<String> list2, PInt pInt, String str2, int i4, int i5) {
        AppMethodBeat.m2504i(38359);
        if (this.crP.isFinishing()) {
            AppMethodBeat.m2505o(38359);
            return false;
        }
        C29054ax c29054ax = new C29054ax(2);
        pInt.value = c29054ax.aPA;
        if (i3 > C24826a.qFE) {
            c29054ax.mo47138Dd(2);
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
        if (z) {
            c29054ax.mo47143Di(1);
        } else {
            c29054ax.mo47143Di(0);
        }
        if (c41173i != null) {
            c29054ax.mo47165gc(c41173i.token, c41173i.wFn);
        }
        c29054ax.mo47142Dh(this.rig);
        if (this.rjF) {
            c29054ax.mo47142Dh(5);
        }
        if (this.rjG && this.rjH != null) {
            c29054ax.mo47145Yn(this.rjH.mediaTagName);
            c29054ax.mo47157af(this.csB, this.rjH.messageExt, this.rjH.messageAction);
        }
        c29054ax.mo47164g(null, null, null, i4, i5);
        c29054ax.mo47144Ym(str).mo47154a(ayt).mo47158ar(linkedList).mo47140Df(i).mo47141Dg(i2).mo47162dg(list2);
        int commit = c29054ax.commit();
        if (this.rim != null) {
            this.rim.mo60719ma(commit);
            C24827g.qTp.mo37379c(this.rim);
        }
        this.crP.setResult(-1);
        C13373af.cnB().cmp();
        this.crP.finish();
        AppMethodBeat.m2505o(38359);
        return true;
    }

    /* renamed from: f */
    public final boolean mo8916f(int i, Intent intent) {
        return false;
    }

    public final boolean crI() {
        return false;
    }
}
