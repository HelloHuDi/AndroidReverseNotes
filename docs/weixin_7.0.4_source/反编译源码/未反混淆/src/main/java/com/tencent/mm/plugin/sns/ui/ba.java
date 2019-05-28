package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.t;
import com.tencent.mm.modelsns.b;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX.Req;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXTextObject;
import com.tencent.mm.plugin.sns.c.a;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.aw;
import com.tencent.mm.plugin.sns.model.ax;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.protobuf.ayt;
import com.tencent.mm.protocal.protobuf.cco;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.e.k;
import java.util.LinkedList;
import java.util.List;
import org.b.d.i;

public final class ba implements y {
    private String appName = "";
    private MMActivity crP;
    private String csB = "";
    private int rig;
    private b rim = null;
    private boolean rjF = false;
    private boolean rjG = false;
    private WXMediaMessage rjH = null;
    private String rkV = "";

    public ba(MMActivity mMActivity) {
        this.crP = mMActivity;
    }

    public final void M(Bundle bundle) {
        AppMethodBeat.i(39853);
        this.rim = b.u(this.crP.getIntent());
        this.rkV = this.crP.getIntent().getStringExtra(k.ygd);
        this.csB = bo.bc(this.crP.getIntent().getStringExtra("Ksnsupload_appid"), "");
        this.appName = bo.bc(this.crP.getIntent().getStringExtra("Ksnsupload_appname"), "");
        this.rjF = this.crP.getIntent().getBooleanExtra("KThrid_app", false);
        this.rjG = this.crP.getIntent().getBooleanExtra("KSnsAction", false);
        this.rig = this.crP.getIntent().getIntExtra("Ksnsupload_source", 0);
        this.rjH = new Req(this.crP.getIntent().getBundleExtra("Ksnsupload_timeline")).message;
        AppMethodBeat.o(39853);
    }

    public final void N(Bundle bundle) {
    }

    public final boolean crG() {
        return true;
    }

    public final View crH() {
        return null;
    }

    public final boolean a(int i, int i2, i iVar, String str, List<String> list, ayt ayt, int i3, boolean z, List<String> list2, PInt pInt, String str2, int i4, int i5) {
        AppMethodBeat.i(39854);
        if (this.rjH != null) {
            this.rjH.description = str;
            if (this.rjH.mediaObject != null && (this.rjH.mediaObject instanceof WXTextObject)) {
                ((WXTextObject) this.rjH.mediaObject).text = str;
            }
        }
        af.cnB();
        ax b = aw.b(this.rjH, str, this.csB, this.appName);
        if (b == null) {
            ab.e("MicroMsg.TextWidget", "packHelper == null, %s, %s", this.csB, this.appName);
            AppMethodBeat.o(39854);
            return false;
        }
        pInt.value = b.aPA;
        if (i3 > a.qFE) {
            b.Dd(4);
        }
        b.Dh(this.rig);
        if (this.rjF) {
            b.Dh(5);
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
        b.ar(linkedList);
        if (iVar != null) {
            b.gc(iVar.token, iVar.wFn);
        }
        b.a(ayt);
        if (z) {
            b.Di(1);
        } else {
            b.Di(0);
        }
        b.dg(list2).Df(i);
        b.g(null, null, null, i4, i5);
        if (this.rjG && this.rjH != null) {
            b.Yn(this.rjH.mediaTagName);
            b.af(this.csB, this.rjH.messageExt, this.rjH.messageAction);
        }
        int commit = b.commit();
        if (this.rim != null) {
            this.rim.ma(commit);
            g.qTp.c(this.rim);
        }
        af.cnB().cmp();
        this.crP.finish();
        AppMethodBeat.o(39854);
        return false;
    }

    public final boolean f(int i, Intent intent) {
        return false;
    }

    public final boolean crI() {
        return false;
    }
}
