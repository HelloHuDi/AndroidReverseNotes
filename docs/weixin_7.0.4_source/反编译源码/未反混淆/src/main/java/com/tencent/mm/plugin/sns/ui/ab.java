package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.aw.e;
import com.tencent.mm.g.a.ke;
import com.tencent.mm.model.t;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX.Req;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMusicObject;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.aw;
import com.tencent.mm.plugin.sns.model.ax;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.protobuf.ayt;
import com.tencent.mm.protocal.protobuf.cco;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.v;
import java.util.LinkedList;
import java.util.List;

public final class ab implements y {
    private String appName = "";
    String cHr;
    MMActivity crP;
    String csB = "";
    private TextView gne = null;
    private c hAA = new c<ke>() {
        {
            AppMethodBeat.i(38324);
            this.xxI = ke.class.getName().hashCode();
            AppMethodBeat.o(38324);
        }

        public final /* synthetic */ boolean a(b bVar) {
            AppMethodBeat.i(38325);
            switch (((ke) bVar).cFH.action) {
                case 0:
                case 1:
                    ab.this.rku.setImageResource(R.drawable.vq);
                    break;
                case 2:
                case 3:
                case 4:
                case 7:
                    ab.this.rku.setImageResource(R.drawable.vs);
                    break;
            }
            AppMethodBeat.o(38325);
            return false;
        }
    };
    boolean isPlaying = false;
    private View jAp;
    private int rig;
    private CdnImageView rih = null;
    private TextView rii = null;
    private com.tencent.mm.modelsns.b rim = null;
    private boolean rjF = false;
    private boolean rjG = false;
    WXMediaMessage rjH = null;
    ImageView rku;
    private Bitmap rkv;

    public ab(MMActivity mMActivity) {
        AppMethodBeat.i(38329);
        this.crP = mMActivity;
        a.xxA.c(this.hAA);
        AppMethodBeat.o(38329);
    }

    public final void M(Bundle bundle) {
        AppMethodBeat.i(38330);
        this.rjH = new Req(this.crP.getIntent().getBundleExtra("Ksnsupload_timeline")).message;
        this.cHr = this.crP.getIntent().getStringExtra("Ksnsupload_musicid");
        this.rim = com.tencent.mm.modelsns.b.u(this.crP.getIntent());
        this.csB = bo.bc(this.crP.getIntent().getStringExtra("Ksnsupload_appid"), "");
        this.appName = bo.bc(this.crP.getIntent().getStringExtra("Ksnsupload_appname"), "");
        this.rjF = this.crP.getIntent().getBooleanExtra("KThrid_app", false);
        this.rjG = this.crP.getIntent().getBooleanExtra("KSnsAction", false);
        this.rig = this.crP.getIntent().getIntExtra("Ksnsupload_source", 0);
        AppMethodBeat.o(38330);
    }

    public final void N(Bundle bundle) {
    }

    public final boolean crG() {
        return true;
    }

    /* Access modifiers changed, original: final */
    public final void crY() {
        AppMethodBeat.i(38331);
        new ak(this.crP.getMainLooper()).post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(38326);
                com.tencent.mm.aw.a.aic();
                ab.this.isPlaying = false;
                AppMethodBeat.o(38326);
            }
        });
        AppMethodBeat.o(38331);
    }

    public final View crH() {
        AppMethodBeat.i(38332);
        this.jAp = v.hu(this.crP).inflate(R.layout.b13, null);
        this.rih = (CdnImageView) this.jAp.findViewById(R.id.d11);
        this.gne = (TextView) this.jAp.findViewById(R.id.d13);
        this.rii = (TextView) this.jAp.findViewById(R.id.d14);
        this.jAp.findViewById(R.id.c9m).setVisibility(8);
        this.gne.setText(this.rjH.title);
        if (this.rjH.thumbData != null) {
            this.rkv = d.bQ(this.rjH.thumbData);
        }
        this.rih.setImageBitmap(this.rkv);
        if (bo.isNullOrNil(this.rjH.description)) {
            this.rii.setVisibility(8);
        } else {
            this.rii.setText(this.rjH.description);
            this.rii.setVisibility(0);
        }
        this.rku = (ImageView) this.jAp.findViewById(R.id.c9m);
        this.rku.setVisibility(0);
        if (com.tencent.mm.aw.a.aie() && this.isPlaying) {
            this.rku.setImageResource(R.drawable.vq);
        } else {
            this.rku.setImageResource(R.drawable.vs);
        }
        this.rku.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(38328);
                if (com.tencent.mm.aw.a.aie()) {
                    ab.this.crY();
                    AppMethodBeat.o(38328);
                    return;
                }
                ab abVar = ab.this;
                if (abVar.rjH == null) {
                    com.tencent.mm.sdk.platformtools.ab.w("MicroMsg.MusicWidget", "doBeingPlayMusic: but item is null");
                    AppMethodBeat.o(38328);
                    return;
                }
                new ak(abVar.crP.getMainLooper()).post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(38327);
                        if (3 == ab.this.rjH.getType()) {
                            ab.this.isPlaying = true;
                            WXMusicObject wXMusicObject = (WXMusicObject) ab.this.rjH.mediaObject;
                            String bc = bo.bc(!bo.isNullOrNil(wXMusicObject.musicUrl) ? wXMusicObject.musicUrl : wXMusicObject.musicLowBandUrl, "");
                            String bc2 = bo.bc(!bo.isNullOrNil(wXMusicObject.musicDataUrl) ? wXMusicObject.musicDataUrl : wXMusicObject.musicUrl, "");
                            if (bo.isNullOrNil(ab.this.cHr)) {
                                ab.this.cHr = System.currentTimeMillis();
                            }
                            e eVar = new e();
                            eVar.fJS = 1;
                            eVar.fJU = ab.this.cHr;
                            eVar.fJV = 0.0f;
                            eVar.fJY = "";
                            eVar.fKe = null;
                            eVar.fJT = 1;
                            eVar.fKd = null;
                            eVar.fJW = ab.this.rjH.title;
                            eVar.fJX = ab.this.rjH.description;
                            eVar.fKc = bc;
                            eVar.fKb = bc2;
                            eVar.fKa = bc2;
                            eVar.fKk = "";
                            eVar.fKf = af.getAccPath();
                            eVar.fKh = ab.this.csB;
                            com.tencent.mm.aw.a.b(eVar);
                        }
                        AppMethodBeat.o(38327);
                    }
                });
                AppMethodBeat.o(38328);
            }
        });
        i.b(this.rih, this.crP);
        View view = this.jAp;
        AppMethodBeat.o(38332);
        return view;
    }

    public final boolean a(int i, int i2, org.b.d.i iVar, String str, List<String> list, ayt ayt, int i3, boolean z, List<String> list2, PInt pInt, String str2, int i4, int i5) {
        AppMethodBeat.i(38333);
        af.cnB();
        ax b = aw.b(this.rjH, str, this.csB, this.appName);
        if (b == null) {
            com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.MusicWidget", "packHelper == null, %s, %s", this.csB, this.appName);
            AppMethodBeat.o(38333);
            return false;
        }
        pInt.value = b.aPA;
        if (i3 > com.tencent.mm.plugin.sns.c.a.qFE) {
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
        AppMethodBeat.o(38333);
        return false;
    }

    public final boolean f(int i, Intent intent) {
        return false;
    }

    public final boolean crI() {
        AppMethodBeat.i(38334);
        if (!(this.rkv == null || this.rkv.isRecycled())) {
            this.rkv.recycle();
        }
        a.xxA.d(this.hAA);
        if (com.tencent.mm.aw.a.aie() && this.isPlaying) {
            crY();
        }
        boolean aie = com.tencent.mm.aw.a.aie();
        AppMethodBeat.o(38334);
        return aie;
    }
}
