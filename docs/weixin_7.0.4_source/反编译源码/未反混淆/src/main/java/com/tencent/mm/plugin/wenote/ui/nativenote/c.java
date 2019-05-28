package com.tencent.mm.plugin.wenote.ui.nativenote;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Parcelable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.j;
import com.tencent.mm.bp.d;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.fav.a.an;
import com.tencent.mm.plugin.mmsight.SightParams;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wenote.model.a.i;
import com.tencent.mm.plugin.wenote.model.a.l;
import com.tencent.mm.plugin.wenote.model.b.a;
import com.tencent.mm.plugin.wenote.model.nativenote.b.b;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.k;
import com.tencent.mm.plugin.wenote.model.nativenote.spans.u;
import com.tencent.mm.pluginsdk.ui.tools.FileExplorerUI;
import com.tencent.mm.protocal.protobuf.aar;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.base.t;
import com.tencent.ttpic.util.VideoMaterialUtil;

public final class c implements a, b {
    View gLe;
    String uNM = "";
    ImageButton uTK;
    LinearLayout uTL;
    ImageButton uTM;
    ImageButton uTN;
    ImageButton uTO;
    ImageButton uTP;
    LinearLayout uTQ;
    LinearLayout uTR;
    LinearLayout uTS;
    LinearLayout uTT;
    LinearLayout uTU;
    public boolean uTV = false;
    c uTW = this;
    boolean uTX = false;
    boolean uTY = false;
    boolean uTZ = false;
    boolean uUa = false;

    /* renamed from: com.tencent.mm.plugin.wenote.ui.nativenote.c$10 */
    class AnonymousClass10 implements OnClickListener {
        final /* synthetic */ com.tencent.mm.plugin.wenote.model.nativenote.b.a uUb;

        AnonymousClass10(com.tencent.mm.plugin.wenote.model.nativenote.b.a aVar) {
            this.uUb = aVar;
        }

        public final void onClick(View view) {
            boolean z = true;
            AppMethodBeat.i(27124);
            h.pYm.e(14547, Integer.valueOf(11));
            c.this.uTR.setPressed(false);
            c.this.uTS.setPressed(false);
            if (c.this.uTZ || c.this.uTY) {
                c.this.uUa = false;
            }
            c.c(u.uSA, Boolean.valueOf(!c.this.uUa));
            c cVar = c.this;
            if (c.this.uUa) {
                z = false;
            }
            cVar.uUa = z;
            c.a(c.this, view, c.this.uUa);
            c.b(this.uUb);
            c.this.uTZ = false;
            c.this.uTY = false;
            AppMethodBeat.o(27124);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wenote.ui.nativenote.c$7 */
    class AnonymousClass7 implements OnClickListener {
        final /* synthetic */ com.tencent.mm.plugin.wenote.model.nativenote.b.a uUb;
        final /* synthetic */ Context val$context;

        AnonymousClass7(com.tencent.mm.plugin.wenote.model.nativenote.b.a aVar, Context context) {
            this.uUb = aVar;
            this.val$context = context;
        }

        public final void onClick(View view) {
            boolean z = false;
            AppMethodBeat.i(27121);
            if (c.a(c.this) == 3) {
                this.uUb.g(true, 50);
                this.uUb.af(1, 0);
            }
            com.tencent.mm.plugin.wenote.model.nativenote.manager.c.dem().av(-1, false);
            ab.i("MicroMsg.WNNoteFootPannel", "summerper checkPermission checkMicrophone[%b],stack[%s]", Boolean.valueOf(com.tencent.mm.pluginsdk.permission.b.a((Activity) this.val$context, "android.permission.RECORD_AUDIO", 80, null, null)), bo.dpG());
            if (com.tencent.mm.pluginsdk.permission.b.a((Activity) this.val$context, "android.permission.RECORD_AUDIO", 80, null, null)) {
                if (!c.this.uTV) {
                    if (!f.Mn()) {
                        t.hO(this.val$context);
                        AppMethodBeat.o(27121);
                        return;
                    } else if (com.tencent.mm.r.a.bJ(this.val$context) || com.tencent.mm.r.a.bH(this.val$context)) {
                        AppMethodBeat.o(27121);
                        return;
                    }
                }
                if (c.this.uTV) {
                    c.this.a(this.uUb);
                    AppMethodBeat.o(27121);
                    return;
                }
                h.pYm.e(14547, Integer.valueOf(3));
                if (com.tencent.mm.plugin.wenote.model.nativenote.manager.c.dem().gF(0, 1)) {
                    this.uUb.ddW();
                    AppMethodBeat.o(27121);
                    return;
                }
                c.this.uTP.setImageResource(R.raw.fav_note_voiceplayer_record_icon);
                if (com.tencent.mm.plugin.wenote.ui.nativenote.voiceview.a.dfY().buH()) {
                    com.tencent.mm.plugin.wenote.ui.nativenote.voiceview.a.dfY().stopPlay();
                }
                c.this.uTV = true;
                com.tencent.mm.plugin.wenote.model.a.c lVar = new l();
                lVar.type = 4;
                lVar.uOp = false;
                lVar.uOh = Boolean.TRUE;
                lVar.uOD = this.val$context.getString(R.string.bsh);
                c.this.uNM = "speex";
                lVar.cAO = 1;
                lVar.uOo = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.dem().des();
                lVar.uOf = c.this.uNM;
                lVar.mnd = com.tencent.mm.plugin.wenote.model.f.agW(lVar.toString());
                aar aar = new aar();
                aar.akU(lVar.mnd);
                aar.akR(lVar.uOf);
                k deT = k.deT();
                if (deT != null) {
                    com.tencent.mm.plugin.wenote.model.nativenote.manager.c.dem().a(lVar, deT.deW(), false, false, false);
                } else {
                    com.tencent.mm.plugin.wenote.model.nativenote.manager.c.dem().a(lVar, null, false, false, false);
                }
                com.tencent.mm.plugin.wenote.model.k ddK = com.tencent.mm.plugin.wenote.model.k.ddK();
                c cVar = c.this.uTW;
                String o = com.tencent.mm.plugin.wenote.model.f.o(aar);
                ddK.uNQ = lVar;
                int i = bo.getInt(lVar.uOo.substring(7), 0);
                String str = lVar.uOf;
                if (!ddK.miB) {
                    String bvn;
                    ddK.miB = true;
                    ddK.mkf = null;
                    ddK.uNO = i;
                    ddK.uNP = cVar;
                    ddK.uNM = str;
                    ddK.path = o;
                    if (ddK.gar != null) {
                        ddK.gar.requestFocus();
                    }
                    ddK.miC = false;
                    if (bo.isNullOrNil(ddK.path)) {
                        bvn = an.bvn();
                        com.tencent.mm.vfs.b bVar = new com.tencent.mm.vfs.b(bvn);
                        if (!bVar.exists()) {
                            bVar.mkdirs();
                        }
                        do {
                            o = bvn + "/" + System.currentTimeMillis();
                        } while (new com.tencent.mm.vfs.b(o).exists());
                        ddK.path = o;
                    }
                    if (bo.isNullOrNil(str)) {
                        bvn = "amr";
                    } else {
                        bvn = str;
                    }
                    if (bvn.equals("speex")) {
                        ddK.uNL = new com.tencent.mm.modelvoice.k();
                        com.tencent.mm.plugin.wenote.model.k.AnonymousClass1 anonymousClass1 = new j.a() {
                            public final void onError() {
                                AppMethodBeat.i(26664);
                                ab.e("MicroMsg.WNNoteVoiceLogic", "SpeexRecorder,Record Failed");
                                k.this.miP.stopTimer();
                                AppMethodBeat.o(26664);
                            }
                        };
                    } else {
                        com.tencent.mm.compatible.b.c.a aVar = com.tencent.mm.compatible.b.c.a.AMR;
                        ddK.miM = new com.tencent.mm.audio.b.j();
                        ddK.miM.crh = new com.tencent.mm.audio.b.j.a() {
                            public final void onError() {
                                AppMethodBeat.i(26665);
                                ab.e("MicroMsg.WNNoteVoiceLogic", "SimpleVoiceRecorder,Record Failed");
                                k.this.miP.stopTimer();
                                AppMethodBeat.o(26665);
                            }
                        };
                    }
                    ddK.miD = -1;
                    Boolean bool = Boolean.FALSE;
                    if (str.equals("speex")) {
                        bool = Boolean.valueOf(ddK.uNL.el(ddK.path));
                    } else {
                        bool = Boolean.valueOf(ddK.miM.en(ddK.path));
                    }
                    if (bool.booleanValue()) {
                        ddK.ljM = bo.yz();
                        ddK.miP.ae(200, 200);
                    } else {
                        ddK.ljM = 0;
                    }
                    if (ddK.ljM == 0) {
                        z = true;
                    } else {
                        ddK.uNR.sendEmptyMessage(4096);
                    }
                }
                if (z >= false) {
                    this.uUb.ddX();
                    c.this.a(this.uUb);
                }
                AppMethodBeat.o(27121);
                return;
            }
            AppMethodBeat.o(27121);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wenote.ui.nativenote.c$8 */
    class AnonymousClass8 implements OnClickListener {
        final /* synthetic */ Context val$context;

        AnonymousClass8(Context context) {
            this.val$context = context;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(27122);
            com.tencent.mm.plugin.wenote.model.nativenote.manager.c.dem().av(-1, false);
            if (f.Mn()) {
                Intent intent = new Intent(this.val$context, FileExplorerUI.class);
                intent.putExtra("key_title", this.val$context.getString(R.string.bq8));
                ((Activity) this.val$context).startActivityForResult(intent, 4099);
                AppMethodBeat.o(27122);
                return;
            }
            t.hO(this.val$context);
            AppMethodBeat.o(27122);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wenote.ui.nativenote.c$6 */
    class AnonymousClass6 implements OnClickListener {
        final /* synthetic */ Context val$context;

        AnonymousClass6(Context context) {
            this.val$context = context;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(27120);
            ab.i("MicroMsg.WNNoteFootPannel", "go to GalleryEntryUI");
            com.tencent.mm.plugin.wenote.model.nativenote.manager.c.dem().av(-1, false);
            Intent intent = new Intent();
            intent.putExtra("max_select_count", 9);
            intent.putExtra("query_source_type", 13);
            intent.putExtra("query_media_type", 3);
            intent.putExtra("show_header_view", true);
            intent.putExtra("send_btn_string", this.val$context.getString(R.string.bnl));
            Parcelable parcelable = (SightParams) intent.getParcelableExtra("KEY_SIGHT_PARAMS");
            if (parcelable == null) {
                parcelable = new SightParams(4, 0);
            }
            String str = "micromsg_" + System.currentTimeMillis();
            String str2 = e.euR + str + VideoMaterialUtil.MP4_SUFFIX;
            String str3 = e.euR + str + ".jpeg";
            int intExtra = intent.getIntExtra("key_pick_local_media_duration", 60);
            SightParams sightParams = new SightParams(4, 1);
            sightParams.osJ = 2;
            sightParams.mode = 0;
            if (sightParams.fcY == null) {
                sightParams.fcY = new VideoTransPara();
            }
            sightParams.fcY.duration = intExtra;
            sightParams.q(str, str2, str3, e.euR + String.format("%s%d.%s", new Object[]{"capture", Long.valueOf(System.currentTimeMillis()), "jpg"}));
            intent.putExtra("KEY_SIGHT_PARAMS", parcelable);
            intent.putExtra("record_video_force_sys_camera", false);
            intent.putExtra("record_video_is_sight_capture", true);
            intent.addFlags(67108864);
            intent.putExtra("key_can_select_video_and_pic", true);
            d.b(this.val$context, "gallery", ".ui.GalleryEntryUI", intent, 4097);
            AppMethodBeat.o(27120);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wenote.ui.nativenote.c$9 */
    class AnonymousClass9 implements OnClickListener {
        final /* synthetic */ Context val$context;

        AnonymousClass9(Context context) {
            this.val$context = context;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(27123);
            com.tencent.mm.plugin.wenote.model.nativenote.manager.c.dem().av(-1, false);
            if (!com.tencent.mm.au.b.sO((String) g.RP().Ry().get(274436, null))) {
                ab.i("MicroMsg.WNNoteFootPannel", "summerper checkPermission checkLocation[%b]", Boolean.valueOf(com.tencent.mm.pluginsdk.permission.b.a((Activity) this.val$context, "android.permission.ACCESS_COARSE_LOCATION", 64, null, null)));
                if (!com.tencent.mm.pluginsdk.permission.b.a((Activity) this.val$context, "android.permission.ACCESS_COARSE_LOCATION", 64, null, null)) {
                    AppMethodBeat.o(27123);
                    return;
                }
            } else if (!com.tencent.mm.pluginsdk.permission.b.o((Activity) this.val$context, "android.permission.ACCESS_COARSE_LOCATION")) {
                if (((Boolean) g.RP().Ry().get(ac.a.USERINFO_GDPR_LOCATION_PERMISSION_DESCRIBE_CONFIRM_BOOLEAN_SYNC, Boolean.FALSE)).booleanValue()) {
                    com.tencent.mm.pluginsdk.permission.b.b((Activity) this.val$context, "android.permission.ACCESS_COARSE_LOCATION", 64);
                    AppMethodBeat.o(27123);
                    return;
                }
                com.tencent.mm.plugin.account.a.b.a.b((Activity) this.val$context, this.val$context.getResources().getString(R.string.g7p, new Object[]{aa.dor()}), 30764, true);
                AppMethodBeat.o(27123);
                return;
            }
            Intent intent = new Intent();
            intent.putExtra(MMFragment.FLAG_OVERRIDE_EXIT_ANIMATION, R.anim.ce);
            intent.putExtra(MMFragment.FLAG_OVERRIDE_ENTER_ANIMATION, R.anim.b5);
            intent.putExtra("map_view_type", 3);
            d.b(this.val$context, FirebaseAnalytics.b.LOCATION, ".ui.RedirectUI", intent, 4098);
            AppMethodBeat.o(27123);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wenote.ui.nativenote.c$11 */
    class AnonymousClass11 implements OnClickListener {
        final /* synthetic */ com.tencent.mm.plugin.wenote.model.nativenote.b.a uUb;

        AnonymousClass11(com.tencent.mm.plugin.wenote.model.nativenote.b.a aVar) {
            this.uUb = aVar;
        }

        public final void onClick(View view) {
            boolean z;
            boolean z2 = true;
            AppMethodBeat.i(27125);
            h.pYm.e(14547, Integer.valueOf(7));
            com.tencent.mm.plugin.wenote.model.nativenote.spans.b bVar = u.uSz;
            if (c.this.uTX) {
                z = false;
            } else {
                z = true;
            }
            c.c(bVar, Boolean.valueOf(z));
            c cVar = c.this;
            if (c.this.uTX) {
                z2 = false;
            }
            cVar.uTX = z2;
            c.a(c.this, view, c.this.uTX);
            c.b(this.uUb);
            AppMethodBeat.o(27125);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wenote.ui.nativenote.c$12 */
    class AnonymousClass12 implements OnClickListener {
        final /* synthetic */ com.tencent.mm.plugin.wenote.model.nativenote.b.a uUb;

        AnonymousClass12(com.tencent.mm.plugin.wenote.model.nativenote.b.a aVar) {
            this.uUb = aVar;
        }

        public final void onClick(View view) {
            boolean z = true;
            AppMethodBeat.i(27126);
            h.pYm.e(14547, Integer.valueOf(8));
            c.this.uTU.setPressed(false);
            c.this.uTS.setPressed(false);
            if (c.this.uTZ || c.this.uUa) {
                c.this.uTY = false;
            }
            c.c(u.uSB, Boolean.valueOf(!c.this.uTY));
            c cVar = c.this;
            if (c.this.uTY) {
                z = false;
            }
            cVar.uTY = z;
            c.a(c.this, view, c.this.uTY);
            c.b(this.uUb);
            c.this.uTZ = false;
            c.this.uUa = false;
            AppMethodBeat.o(27126);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wenote.ui.nativenote.c$13 */
    class AnonymousClass13 implements OnClickListener {
        final /* synthetic */ com.tencent.mm.plugin.wenote.model.nativenote.b.a uUb;

        AnonymousClass13(com.tencent.mm.plugin.wenote.model.nativenote.b.a aVar) {
            this.uUb = aVar;
        }

        public final void onClick(View view) {
            boolean z = true;
            AppMethodBeat.i(27127);
            h.pYm.e(14547, Integer.valueOf(9));
            c.this.uTR.setPressed(false);
            c.this.uTU.setPressed(false);
            if (c.this.uTY || c.this.uUa) {
                c.this.uTZ = false;
            }
            c.c(u.uSC, Boolean.valueOf(!c.this.uTZ));
            c cVar = c.this;
            if (c.this.uTZ) {
                z = false;
            }
            cVar.uTZ = z;
            c.a(c.this, view, c.this.uTZ);
            c.b(this.uUb);
            c.this.uTY = false;
            c.this.uUa = false;
            AppMethodBeat.o(27127);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wenote.ui.nativenote.c$1 */
    class AnonymousClass1 implements OnClickListener {
        final /* synthetic */ com.tencent.mm.plugin.wenote.model.nativenote.b.a uUb;

        AnonymousClass1(com.tencent.mm.plugin.wenote.model.nativenote.b.a aVar) {
            this.uUb = aVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(27116);
            int a = c.a(c.this);
            if (a == 1) {
                this.uUb.g(false, 0);
                this.uUb.af(3, 100);
                AppMethodBeat.o(27116);
            } else if (a == 3) {
                this.uUb.g(true, 50);
                this.uUb.af(1, 0);
                AppMethodBeat.o(27116);
            } else {
                if (a == 2) {
                    this.uUb.af(3, 0);
                }
                AppMethodBeat.o(27116);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.wenote.ui.nativenote.c$2 */
    class AnonymousClass2 implements OnClickListener {
        final /* synthetic */ com.tencent.mm.plugin.wenote.model.nativenote.b.a uUb;

        AnonymousClass2(com.tencent.mm.plugin.wenote.model.nativenote.b.a aVar) {
            this.uUb = aVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(27117);
            h.pYm.e(14547, Integer.valueOf(10));
            com.tencent.mm.plugin.wenote.model.a.c hVar = new com.tencent.mm.plugin.wenote.model.a.h();
            k deT = k.deT();
            if (deT != null) {
                com.tencent.mm.plugin.wenote.model.nativenote.manager.c.dem().a(hVar, deT.deW(), false, false, true);
            } else {
                com.tencent.mm.plugin.wenote.model.nativenote.manager.c.dem().a(hVar, null, false, false, true);
            }
            c.b(this.uUb);
            AppMethodBeat.o(27117);
        }
    }

    public c() {
        AppMethodBeat.i(27128);
        AppMethodBeat.o(27128);
    }

    public final void ddT() {
        AppMethodBeat.i(27129);
        com.tencent.mm.ui.base.h.a(this.uTP.getContext(), this.uTP.getContext().getString(R.string.d89), "", true, new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.i(27118);
                c.this.a(null);
                AppMethodBeat.o(27118);
            }
        }, new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
            }
        });
        AppMethodBeat.o(27129);
    }

    public final void ddS() {
        AppMethodBeat.i(27130);
        a(null);
        AppMethodBeat.o(27130);
    }

    public final void a(com.tencent.mm.plugin.wenote.model.nativenote.b.a aVar) {
        AppMethodBeat.i(27131);
        this.uTP.setImageResource(R.drawable.a7g);
        if (this.uTV) {
            this.uTV = false;
            com.tencent.mm.plugin.wenote.model.k.ddK().ddL();
            String ddM = com.tencent.mm.plugin.wenote.model.k.ddK().ddM();
            int i = (int) com.tencent.mm.plugin.wenote.model.k.ddK().duration;
            int fY = (int) com.tencent.mm.bk.a.fY((long) i);
            int der = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.dem().der();
            com.tencent.mm.plugin.wenote.model.a.c Ke = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.dem().Ke(der);
            if (com.tencent.mm.vfs.e.ct(ddM)) {
                if (!(der == -1 || Ke == null || Ke.getType() != 4)) {
                    ((l) Ke).uOh = Boolean.FALSE;
                    ((l) Ke).type = 4;
                    ((l) Ke).uOp = true;
                    ((l) Ke).uOD = "";
                    ((l) Ke).length = fY;
                    ((l) Ke).uOC = com.tencent.mm.bk.a.B(ah.getContext(), fY).toString();
                    ((l) Ke).hNN = an.bvi() + "/fav_fileicon_recording.png";
                    ((l) Ke).cHg = ddM;
                    ((l) Ke).cAP = i;
                    com.tencent.mm.plugin.wenote.model.nativenote.manager.c.dem().Kg(der);
                }
                AppMethodBeat.o(27131);
                return;
            }
            ab.e("MicroMsg.WNNoteFootPannel", "voicePath not exist, remove data from datalist and ui");
            com.tencent.mm.plugin.wenote.model.nativenote.manager.c.dem().au(der, false);
            if (aVar != null) {
                aVar.JZ(der);
            }
            com.tencent.mm.plugin.wenote.model.a.c iVar = new i();
            iVar.content = "";
            iVar.uNT = true;
            iVar.uNZ = false;
            com.tencent.mm.plugin.wenote.model.nativenote.manager.c.dem().a(der, iVar);
            com.tencent.mm.plugin.wenote.model.nativenote.manager.c.dem().gG(der - 1, der + 1);
            AppMethodBeat.o(27131);
            return;
        }
        AppMethodBeat.o(27131);
    }

    public final void ok(boolean z) {
        AppMethodBeat.i(27132);
        this.uTX = z;
        this.uTQ.setPressed(z);
        AppMethodBeat.o(27132);
    }

    public final void ol(boolean z) {
        AppMethodBeat.i(27133);
        this.uTY = z;
        this.uTR.setPressed(z);
        AppMethodBeat.o(27133);
    }

    public final void om(boolean z) {
        AppMethodBeat.i(27134);
        this.uTZ = z;
        this.uTS.setPressed(z);
        AppMethodBeat.o(27134);
    }

    public final void on(boolean z) {
        AppMethodBeat.i(27135);
        this.uUa = z;
        this.uTU.setPressed(z);
        AppMethodBeat.o(27135);
    }

    static /* synthetic */ void c(com.tencent.mm.plugin.wenote.model.nativenote.spans.t tVar, Object obj) {
        AppMethodBeat.i(27137);
        if (k.deT() != null) {
            k.deT().b(tVar, obj);
        }
        AppMethodBeat.o(27137);
    }

    static /* synthetic */ void a(c cVar, final View view, final boolean z) {
        AppMethodBeat.i(27138);
        view.postDelayed(new Runnable() {
            public final void run() {
                AppMethodBeat.i(27119);
                view.setPressed(z);
                AppMethodBeat.o(27119);
            }
        }, 100);
        AppMethodBeat.o(27138);
    }

    static /* synthetic */ void b(com.tencent.mm.plugin.wenote.model.nativenote.b.a aVar) {
        AppMethodBeat.i(27139);
        aVar.g(true, 50);
        aVar.af(1, 0);
        AppMethodBeat.o(27139);
    }
}
