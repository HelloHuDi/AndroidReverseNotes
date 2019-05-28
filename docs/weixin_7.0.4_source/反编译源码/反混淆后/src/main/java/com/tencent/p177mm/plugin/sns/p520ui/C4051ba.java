package com.tencent.p177mm.plugin.sns.p520ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.modelsns.C37952b;
import com.tencent.p177mm.opensdk.modelmsg.SendMessageToWX.Req;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.opensdk.modelmsg.WXTextObject;
import com.tencent.p177mm.p612ui.C5510e.C5504k;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.plugin.sns.model.C13373af;
import com.tencent.p177mm.plugin.sns.model.C29050aw;
import com.tencent.p177mm.plugin.sns.model.C29054ax;
import com.tencent.p177mm.plugin.sns.p1363c.C24826a;
import com.tencent.p177mm.plugin.sns.p517i.C24827g;
import com.tencent.p177mm.pointers.PInt;
import com.tencent.p177mm.protocal.protobuf.ayt;
import com.tencent.p177mm.protocal.protobuf.cco;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.LinkedList;
import java.util.List;
import org.p1128b.p1132d.C41173i;

/* renamed from: com.tencent.mm.plugin.sns.ui.ba */
public final class C4051ba implements C22150y {
    private String appName = "";
    private MMActivity crP;
    private String csB = "";
    private int rig;
    private C37952b rim = null;
    private boolean rjF = false;
    private boolean rjG = false;
    private WXMediaMessage rjH = null;
    private String rkV = "";

    public C4051ba(MMActivity mMActivity) {
        this.crP = mMActivity;
    }

    /* renamed from: M */
    public final void mo8910M(Bundle bundle) {
        AppMethodBeat.m2504i(39853);
        this.rim = C37952b.m64173u(this.crP.getIntent());
        this.rkV = this.crP.getIntent().getStringExtra(C5504k.ygd);
        this.csB = C5046bo.m7532bc(this.crP.getIntent().getStringExtra("Ksnsupload_appid"), "");
        this.appName = C5046bo.m7532bc(this.crP.getIntent().getStringExtra("Ksnsupload_appname"), "");
        this.rjF = this.crP.getIntent().getBooleanExtra("KThrid_app", false);
        this.rjG = this.crP.getIntent().getBooleanExtra("KSnsAction", false);
        this.rig = this.crP.getIntent().getIntExtra("Ksnsupload_source", 0);
        this.rjH = new Req(this.crP.getIntent().getBundleExtra("Ksnsupload_timeline")).message;
        AppMethodBeat.m2505o(39853);
    }

    /* renamed from: N */
    public final void mo8911N(Bundle bundle) {
    }

    public final boolean crG() {
        return true;
    }

    public final View crH() {
        return null;
    }

    /* renamed from: a */
    public final boolean mo8912a(int i, int i2, C41173i c41173i, String str, List<String> list, ayt ayt, int i3, boolean z, List<String> list2, PInt pInt, String str2, int i4, int i5) {
        AppMethodBeat.m2504i(39854);
        if (this.rjH != null) {
            this.rjH.description = str;
            if (this.rjH.mediaObject != null && (this.rjH.mediaObject instanceof WXTextObject)) {
                ((WXTextObject) this.rjH.mediaObject).text = str;
            }
        }
        C13373af.cnB();
        C29054ax b = C29050aw.m46148b(this.rjH, str, this.csB, this.appName);
        if (b == null) {
            C4990ab.m7413e("MicroMsg.TextWidget", "packHelper == null, %s, %s", this.csB, this.appName);
            AppMethodBeat.m2505o(39854);
            return false;
        }
        pInt.value = b.aPA;
        if (i3 > C24826a.qFE) {
            b.mo47138Dd(4);
        }
        b.mo47142Dh(this.rig);
        if (this.rjF) {
            b.mo47142Dh(5);
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
        b.mo47158ar(linkedList);
        if (c41173i != null) {
            b.mo47165gc(c41173i.token, c41173i.wFn);
        }
        b.mo47154a(ayt);
        if (z) {
            b.mo47143Di(1);
        } else {
            b.mo47143Di(0);
        }
        b.mo47162dg(list2).mo47140Df(i);
        b.mo47164g(null, null, null, i4, i5);
        if (this.rjG && this.rjH != null) {
            b.mo47145Yn(this.rjH.mediaTagName);
            b.mo47157af(this.csB, this.rjH.messageExt, this.rjH.messageAction);
        }
        int commit = b.commit();
        if (this.rim != null) {
            this.rim.mo60719ma(commit);
            C24827g.qTp.mo37379c(this.rim);
        }
        C13373af.cnB().cmp();
        this.crP.finish();
        AppMethodBeat.m2505o(39854);
        return false;
    }

    /* renamed from: f */
    public final boolean mo8916f(int i, Intent intent) {
        return false;
    }

    public final boolean crI() {
        return false;
    }
}
