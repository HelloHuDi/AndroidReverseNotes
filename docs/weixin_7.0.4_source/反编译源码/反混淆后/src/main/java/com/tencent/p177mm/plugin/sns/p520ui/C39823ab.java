package com.tencent.p177mm.plugin.sns.p520ui;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.modelsns.C37952b;
import com.tencent.p177mm.opensdk.modelmsg.SendMessageToWX.Req;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.opensdk.modelmsg.WXMusicObject;
import com.tencent.p177mm.p198aw.C37494a;
import com.tencent.p177mm.p198aw.C9058e;
import com.tencent.p177mm.p230g.p231a.C37752ke;
import com.tencent.p177mm.p612ui.C5616v;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.plugin.sns.data.C29036i;
import com.tencent.p177mm.plugin.sns.model.C13373af;
import com.tencent.p177mm.plugin.sns.model.C29050aw;
import com.tencent.p177mm.plugin.sns.model.C29054ax;
import com.tencent.p177mm.plugin.sns.p1363c.C24826a;
import com.tencent.p177mm.plugin.sns.p517i.C24827g;
import com.tencent.p177mm.pluginsdk.p597ui.applet.CdnImageView;
import com.tencent.p177mm.pointers.PInt;
import com.tencent.p177mm.protocal.protobuf.ayt;
import com.tencent.p177mm.protocal.protobuf.cco;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5056d;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import java.util.LinkedList;
import java.util.List;
import org.p1128b.p1132d.C41173i;

/* renamed from: com.tencent.mm.plugin.sns.ui.ab */
public final class C39823ab implements C22150y {
    private String appName = "";
    String cHr;
    MMActivity crP;
    String csB = "";
    private TextView gne = null;
    private C4884c hAA = new C291721();
    boolean isPlaying = false;
    private View jAp;
    private int rig;
    private CdnImageView rih = null;
    private TextView rii = null;
    private C37952b rim = null;
    private boolean rjF = false;
    private boolean rjG = false;
    WXMediaMessage rjH = null;
    ImageView rku;
    private Bitmap rkv;

    /* renamed from: com.tencent.mm.plugin.sns.ui.ab$2 */
    class C136202 implements Runnable {
        C136202() {
        }

        public final void run() {
            AppMethodBeat.m2504i(38326);
            C37494a.aic();
            C39823ab.this.isPlaying = false;
            AppMethodBeat.m2505o(38326);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.ab$1 */
    class C291721 extends C4884c<C37752ke> {
        C291721() {
            AppMethodBeat.m2504i(38324);
            this.xxI = C37752ke.class.getName().hashCode();
            AppMethodBeat.m2505o(38324);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(38325);
            switch (((C37752ke) c4883b).cFH.action) {
                case 0:
                case 1:
                    C39823ab.this.rku.setImageResource(C25738R.drawable.f6930vq);
                    break;
                case 2:
                case 3:
                case 4:
                case 7:
                    C39823ab.this.rku.setImageResource(C25738R.drawable.f6932vs);
                    break;
            }
            AppMethodBeat.m2505o(38325);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.ab$4 */
    class C398224 implements OnClickListener {
        C398224() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(38328);
            if (C37494a.aie()) {
                C39823ab.this.crY();
                AppMethodBeat.m2505o(38328);
                return;
            }
            C39823ab c39823ab = C39823ab.this;
            if (c39823ab.rjH == null) {
                C4990ab.m7420w("MicroMsg.MusicWidget", "doBeingPlayMusic: but item is null");
                AppMethodBeat.m2505o(38328);
                return;
            }
            new C7306ak(c39823ab.crP.getMainLooper()).post(new C398243());
            AppMethodBeat.m2505o(38328);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.ab$3 */
    class C398243 implements Runnable {
        C398243() {
        }

        public final void run() {
            AppMethodBeat.m2504i(38327);
            if (3 == C39823ab.this.rjH.getType()) {
                C39823ab.this.isPlaying = true;
                WXMusicObject wXMusicObject = (WXMusicObject) C39823ab.this.rjH.mediaObject;
                String bc = C5046bo.m7532bc(!C5046bo.isNullOrNil(wXMusicObject.musicUrl) ? wXMusicObject.musicUrl : wXMusicObject.musicLowBandUrl, "");
                String bc2 = C5046bo.m7532bc(!C5046bo.isNullOrNil(wXMusicObject.musicDataUrl) ? wXMusicObject.musicDataUrl : wXMusicObject.musicUrl, "");
                if (C5046bo.isNullOrNil(C39823ab.this.cHr)) {
                    C39823ab.this.cHr = System.currentTimeMillis();
                }
                C9058e c9058e = new C9058e();
                c9058e.fJS = 1;
                c9058e.fJU = C39823ab.this.cHr;
                c9058e.fJV = 0.0f;
                c9058e.fJY = "";
                c9058e.fKe = null;
                c9058e.fJT = 1;
                c9058e.fKd = null;
                c9058e.fJW = C39823ab.this.rjH.title;
                c9058e.fJX = C39823ab.this.rjH.description;
                c9058e.fKc = bc;
                c9058e.fKb = bc2;
                c9058e.fKa = bc2;
                c9058e.fKk = "";
                c9058e.fKf = C13373af.getAccPath();
                c9058e.fKh = C39823ab.this.csB;
                C37494a.m63280b(c9058e);
            }
            AppMethodBeat.m2505o(38327);
        }
    }

    public C39823ab(MMActivity mMActivity) {
        AppMethodBeat.m2504i(38329);
        this.crP = mMActivity;
        C4879a.xxA.mo10052c(this.hAA);
        AppMethodBeat.m2505o(38329);
    }

    /* renamed from: M */
    public final void mo8910M(Bundle bundle) {
        AppMethodBeat.m2504i(38330);
        this.rjH = new Req(this.crP.getIntent().getBundleExtra("Ksnsupload_timeline")).message;
        this.cHr = this.crP.getIntent().getStringExtra("Ksnsupload_musicid");
        this.rim = C37952b.m64173u(this.crP.getIntent());
        this.csB = C5046bo.m7532bc(this.crP.getIntent().getStringExtra("Ksnsupload_appid"), "");
        this.appName = C5046bo.m7532bc(this.crP.getIntent().getStringExtra("Ksnsupload_appname"), "");
        this.rjF = this.crP.getIntent().getBooleanExtra("KThrid_app", false);
        this.rjG = this.crP.getIntent().getBooleanExtra("KSnsAction", false);
        this.rig = this.crP.getIntent().getIntExtra("Ksnsupload_source", 0);
        AppMethodBeat.m2505o(38330);
    }

    /* renamed from: N */
    public final void mo8911N(Bundle bundle) {
    }

    public final boolean crG() {
        return true;
    }

    /* Access modifiers changed, original: final */
    public final void crY() {
        AppMethodBeat.m2504i(38331);
        new C7306ak(this.crP.getMainLooper()).post(new C136202());
        AppMethodBeat.m2505o(38331);
    }

    public final View crH() {
        AppMethodBeat.m2504i(38332);
        this.jAp = C5616v.m8409hu(this.crP).inflate(2130970979, null);
        this.rih = (CdnImageView) this.jAp.findViewById(2131825687);
        this.gne = (TextView) this.jAp.findViewById(2131825689);
        this.rii = (TextView) this.jAp.findViewById(2131825690);
        this.jAp.findViewById(2131824637).setVisibility(8);
        this.gne.setText(this.rjH.title);
        if (this.rjH.thumbData != null) {
            this.rkv = C5056d.m7652bQ(this.rjH.thumbData);
        }
        this.rih.setImageBitmap(this.rkv);
        if (C5046bo.isNullOrNil(this.rjH.description)) {
            this.rii.setVisibility(8);
        } else {
            this.rii.setText(this.rjH.description);
            this.rii.setVisibility(0);
        }
        this.rku = (ImageView) this.jAp.findViewById(2131824637);
        this.rku.setVisibility(0);
        if (C37494a.aie() && this.isPlaying) {
            this.rku.setImageResource(C25738R.drawable.f6930vq);
        } else {
            this.rku.setImageResource(C25738R.drawable.f6932vs);
        }
        this.rku.setOnClickListener(new C398224());
        C29036i.m46100b(this.rih, this.crP);
        View view = this.jAp;
        AppMethodBeat.m2505o(38332);
        return view;
    }

    /* renamed from: a */
    public final boolean mo8912a(int i, int i2, C41173i c41173i, String str, List<String> list, ayt ayt, int i3, boolean z, List<String> list2, PInt pInt, String str2, int i4, int i5) {
        AppMethodBeat.m2504i(38333);
        C13373af.cnB();
        C29054ax b = C29050aw.m46148b(this.rjH, str, this.csB, this.appName);
        if (b == null) {
            C4990ab.m7413e("MicroMsg.MusicWidget", "packHelper == null, %s, %s", this.csB, this.appName);
            AppMethodBeat.m2505o(38333);
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
        AppMethodBeat.m2505o(38333);
        return false;
    }

    /* renamed from: f */
    public final boolean mo8916f(int i, Intent intent) {
        return false;
    }

    public final boolean crI() {
        AppMethodBeat.m2504i(38334);
        if (!(this.rkv == null || this.rkv.isRecycled())) {
            this.rkv.recycle();
        }
        C4879a.xxA.mo10053d(this.hAA);
        if (C37494a.aie() && this.isPlaying) {
            crY();
        }
        boolean aie = C37494a.aie();
        AppMethodBeat.m2505o(38334);
        return aie;
    }
}
