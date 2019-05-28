package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.t;
import com.tencent.mm.modelsns.b;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX.Req;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.sns.c.a;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.ax;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.protobuf.ayt;
import com.tencent.mm.protocal.protobuf.cco;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.e.k;
import java.util.LinkedList;
import java.util.List;
import org.b.d.i;

public final class ad implements y {
    private String appName = "";
    private MMActivity crP;
    private String csB = "";
    private int rig;
    private b rim = null;
    private boolean rjF = false;
    private boolean rjG = false;
    private WXMediaMessage rjH = null;
    private String rkV = "";
    private boolean rkW = false;

    public ad(MMActivity mMActivity, boolean z) {
        this.crP = mMActivity;
        this.rkW = z;
    }

    public final void M(Bundle bundle) {
        AppMethodBeat.i(38358);
        this.rim = b.u(this.crP.getIntent());
        this.rkV = this.crP.getIntent().getStringExtra(k.ygd);
        this.csB = bo.bc(this.crP.getIntent().getStringExtra("Ksnsupload_appid"), "");
        this.appName = bo.bc(this.crP.getIntent().getStringExtra("Ksnsupload_appname"), "");
        this.rjF = this.crP.getIntent().getBooleanExtra("KThrid_app", false);
        this.rjG = this.crP.getIntent().getBooleanExtra("KSnsAction", false);
        this.rig = this.crP.getIntent().getIntExtra("Ksnsupload_source", 0);
        Bundle bundleExtra = this.crP.getIntent().getBundleExtra("Ksnsupload_timeline");
        if (bundleExtra != null) {
            this.rjH = new Req(bundleExtra).message;
        }
        AppMethodBeat.o(38358);
    }

    public final void N(Bundle bundle) {
    }

    public final boolean crG() {
        return this.rkW;
    }

    public final View crH() {
        return null;
    }

    public final boolean a(int i, int i2, i iVar, String str, List<String> list, ayt ayt, int i3, boolean z, List<String> list2, PInt pInt, String str2, int i4, int i5) {
        AppMethodBeat.i(38359);
        if (this.crP.isFinishing()) {
            AppMethodBeat.o(38359);
            return false;
        }
        ax axVar = new ax(2);
        pInt.value = axVar.aPA;
        if (i3 > a.qFE) {
            axVar.Dd(2);
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
        if (z) {
            axVar.Di(1);
        } else {
            axVar.Di(0);
        }
        if (iVar != null) {
            axVar.gc(iVar.token, iVar.wFn);
        }
        axVar.Dh(this.rig);
        if (this.rjF) {
            axVar.Dh(5);
        }
        if (this.rjG && this.rjH != null) {
            axVar.Yn(this.rjH.mediaTagName);
            axVar.af(this.csB, this.rjH.messageExt, this.rjH.messageAction);
        }
        axVar.g(null, null, null, i4, i5);
        axVar.Ym(str).a(ayt).ar(linkedList).Df(i).Dg(i2).dg(list2);
        int commit = axVar.commit();
        if (this.rim != null) {
            this.rim.ma(commit);
            g.qTp.c(this.rim);
        }
        this.crP.setResult(-1);
        af.cnB().cmp();
        this.crP.finish();
        AppMethodBeat.o(38359);
        return true;
    }

    public final boolean f(int i, Intent intent) {
        return false;
    }

    public final boolean crI() {
        return false;
    }
}
