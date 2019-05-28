package com.tencent.p177mm.plugin.wenote.p587ui.nativenote;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Parcelable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import com.google.firebase.analytics.FirebaseAnalytics.C8741b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.audio.p195b.C25833j;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.compatible.p219b.C18168c.C18169a;
import com.tencent.p177mm.compatible.util.C1445f;
import com.tencent.p177mm.compatible.util.C6457e;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.modelcontrol.VideoTransPara;
import com.tencent.p177mm.modelvoice.C9742k;
import com.tencent.p177mm.p1179au.C17950b;
import com.tencent.p177mm.p1510r.C35973a;
import com.tencent.p177mm.p1593bk.C41793a;
import com.tencent.p177mm.p612ui.MMFragment;
import com.tencent.p177mm.p612ui.base.C23639t;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.account.p765a.p1216b.C32921a;
import com.tencent.p177mm.plugin.fav.p407a.C11851an;
import com.tencent.p177mm.plugin.mmsight.SightParams;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.wenote.model.C14719f;
import com.tencent.p177mm.plugin.wenote.model.C40371k;
import com.tencent.p177mm.plugin.wenote.model.C40371k.C403721;
import com.tencent.p177mm.plugin.wenote.model.C40371k.C403732;
import com.tencent.p177mm.plugin.wenote.model.nativenote.manager.C40380c;
import com.tencent.p177mm.plugin.wenote.model.nativenote.manager.C46457k;
import com.tencent.p177mm.plugin.wenote.model.nativenote.p1565b.C40377a;
import com.tencent.p177mm.plugin.wenote.model.nativenote.p1565b.C46455b;
import com.tencent.p177mm.plugin.wenote.model.nativenote.spans.C23185t;
import com.tencent.p177mm.plugin.wenote.model.nativenote.spans.C29993u;
import com.tencent.p177mm.plugin.wenote.model.nativenote.spans.C36861b;
import com.tencent.p177mm.plugin.wenote.model.p1665b.C46452a;
import com.tencent.p177mm.plugin.wenote.model.p585a.C31480h;
import com.tencent.p177mm.plugin.wenote.model.p585a.C40365i;
import com.tencent.p177mm.plugin.wenote.model.p585a.C44001c;
import com.tencent.p177mm.plugin.wenote.model.p585a.C44003l;
import com.tencent.p177mm.plugin.wenote.p587ui.nativenote.voiceview.C44019a;
import com.tencent.p177mm.pluginsdk.p597ui.tools.FileExplorerUI;
import com.tencent.p177mm.pluginsdk.permission.C35805b;
import com.tencent.p177mm.protocal.protobuf.aar;
import com.tencent.p177mm.sdk.platformtools.C4988aa;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.p177mm.vfs.C5728b;
import com.tencent.p177mm.vfs.C5730e;
import com.tencent.ttpic.util.VideoMaterialUtil;

/* renamed from: com.tencent.mm.plugin.wenote.ui.nativenote.c */
public final class C46937c implements C46452a, C46455b {
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
    C46937c uTW = this;
    boolean uTX = false;
    boolean uTY = false;
    boolean uTZ = false;
    boolean uUa = false;

    /* renamed from: com.tencent.mm.plugin.wenote.ui.nativenote.c$10 */
    class C1479510 implements OnClickListener {
        final /* synthetic */ C40377a uUb;

        C1479510(C40377a c40377a) {
            this.uUb = c40377a;
        }

        public final void onClick(View view) {
            boolean z = true;
            AppMethodBeat.m2504i(27124);
            C7060h.pYm.mo8381e(14547, Integer.valueOf(11));
            C46937c.this.uTR.setPressed(false);
            C46937c.this.uTS.setPressed(false);
            if (C46937c.this.uTZ || C46937c.this.uTY) {
                C46937c.this.uUa = false;
            }
            C46937c.m89641c(C29993u.uSA, Boolean.valueOf(!C46937c.this.uUa));
            C46937c c46937c = C46937c.this;
            if (C46937c.this.uUa) {
                z = false;
            }
            c46937c.uUa = z;
            C46937c.m89639a(C46937c.this, view, C46937c.this.uUa);
            C46937c.m89640b(this.uUb);
            C46937c.this.uTZ = false;
            C46937c.this.uTY = false;
            AppMethodBeat.m2505o(27124);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wenote.ui.nativenote.c$7 */
    class C231927 implements OnClickListener {
        final /* synthetic */ C40377a uUb;
        final /* synthetic */ Context val$context;

        C231927(C40377a c40377a, Context context) {
            this.uUb = c40377a;
            this.val$context = context;
        }

        public final void onClick(View view) {
            boolean z = false;
            AppMethodBeat.m2504i(27121);
            if (C46937c.m89638a(C46937c.this) == 3) {
                this.uUb.mo27050g(true, 50);
                this.uUb.mo27029af(1, 0);
            }
            C40380c.dem().mo63763av(-1, false);
            C4990ab.m7417i("MicroMsg.WNNoteFootPannel", "summerper checkPermission checkMicrophone[%b],stack[%s]", Boolean.valueOf(C35805b.m58707a((Activity) this.val$context, "android.permission.RECORD_AUDIO", 80, null, null)), C5046bo.dpG());
            if (C35805b.m58707a((Activity) this.val$context, "android.permission.RECORD_AUDIO", 80, null, null)) {
                if (!C46937c.this.uTV) {
                    if (!C1445f.m3070Mn()) {
                        C23639t.m36492hO(this.val$context);
                        AppMethodBeat.m2505o(27121);
                        return;
                    } else if (C35973a.m59179bJ(this.val$context) || C35973a.m59177bH(this.val$context)) {
                        AppMethodBeat.m2505o(27121);
                        return;
                    }
                }
                if (C46937c.this.uTV) {
                    C46937c.this.mo76175a(this.uUb);
                    AppMethodBeat.m2505o(27121);
                    return;
                }
                C7060h.pYm.mo8381e(14547, Integer.valueOf(3));
                if (C40380c.dem().mo63776gF(0, 1)) {
                    this.uUb.ddW();
                    AppMethodBeat.m2505o(27121);
                    return;
                }
                C46937c.this.uTP.setImageResource(C1318a.fav_note_voiceplayer_record_icon);
                if (C44019a.dfY().buH()) {
                    C44019a.dfY().stopPlay();
                }
                C46937c.this.uTV = true;
                C44001c c44003l = new C44003l();
                c44003l.type = 4;
                c44003l.uOp = false;
                c44003l.uOh = Boolean.TRUE;
                c44003l.uOD = this.val$context.getString(C25738R.string.bsh);
                C46937c.this.uNM = "speex";
                c44003l.cAO = 1;
                c44003l.uOo = C40380c.dem().des();
                c44003l.uOf = C46937c.this.uNM;
                c44003l.mnd = C14719f.agW(c44003l.toString());
                aar aar = new aar();
                aar.akU(c44003l.mnd);
                aar.akR(c44003l.uOf);
                C46457k deT = C46457k.deT();
                if (deT != null) {
                    C40380c.dem().mo63752a(c44003l, deT.deW(), false, false, false);
                } else {
                    C40380c.dem().mo63752a(c44003l, null, false, false, false);
                }
                C40371k ddK = C40371k.ddK();
                C46937c c46937c = C46937c.this.uTW;
                String o = C14719f.m22910o(aar);
                ddK.uNQ = c44003l;
                int i = C5046bo.getInt(c44003l.uOo.substring(7), 0);
                String str = c44003l.uOf;
                if (!ddK.miB) {
                    String bvn;
                    ddK.miB = true;
                    ddK.mkf = null;
                    ddK.uNO = i;
                    ddK.uNP = c46937c;
                    ddK.uNM = str;
                    ddK.path = o;
                    if (ddK.gar != null) {
                        ddK.gar.requestFocus();
                    }
                    ddK.miC = false;
                    if (C5046bo.isNullOrNil(ddK.path)) {
                        bvn = C11851an.bvn();
                        C5728b c5728b = new C5728b(bvn);
                        if (!c5728b.exists()) {
                            c5728b.mkdirs();
                        }
                        do {
                            o = bvn + "/" + System.currentTimeMillis();
                        } while (new C5728b(o).exists());
                        ddK.path = o;
                    }
                    if (C5046bo.isNullOrNil(str)) {
                        bvn = "amr";
                    } else {
                        bvn = str;
                    }
                    if (bvn.equals("speex")) {
                        ddK.uNL = new C9742k();
                        C403721 c403721 = new C403721();
                    } else {
                        C18169a c18169a = C18169a.AMR;
                        ddK.miM = new C25833j();
                        ddK.miM.crh = new C403732();
                    }
                    ddK.miD = -1;
                    Boolean bool = Boolean.FALSE;
                    if (str.equals("speex")) {
                        bool = Boolean.valueOf(ddK.uNL.mo5467el(ddK.path));
                    } else {
                        bool = Boolean.valueOf(ddK.miM.mo43819en(ddK.path));
                    }
                    if (bool.booleanValue()) {
                        ddK.ljM = C5046bo.m7588yz();
                        ddK.miP.mo16770ae(200, 200);
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
                    C46937c.this.mo76175a(this.uUb);
                }
                AppMethodBeat.m2505o(27121);
                return;
            }
            AppMethodBeat.m2505o(27121);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wenote.ui.nativenote.c$8 */
    class C231938 implements OnClickListener {
        final /* synthetic */ Context val$context;

        C231938(Context context) {
            this.val$context = context;
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(27122);
            C40380c.dem().mo63763av(-1, false);
            if (C1445f.m3070Mn()) {
                Intent intent = new Intent(this.val$context, FileExplorerUI.class);
                intent.putExtra("key_title", this.val$context.getString(C25738R.string.bq8));
                ((Activity) this.val$context).startActivityForResult(intent, 4099);
                AppMethodBeat.m2505o(27122);
                return;
            }
            C23639t.m36492hO(this.val$context);
            AppMethodBeat.m2505o(27122);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wenote.ui.nativenote.c$6 */
    class C300016 implements OnClickListener {
        final /* synthetic */ Context val$context;

        C300016(Context context) {
            this.val$context = context;
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(27120);
            C4990ab.m7416i("MicroMsg.WNNoteFootPannel", "go to GalleryEntryUI");
            C40380c.dem().mo63763av(-1, false);
            Intent intent = new Intent();
            intent.putExtra("max_select_count", 9);
            intent.putExtra("query_source_type", 13);
            intent.putExtra("query_media_type", 3);
            intent.putExtra("show_header_view", true);
            intent.putExtra("send_btn_string", this.val$context.getString(C25738R.string.bnl));
            Parcelable parcelable = (SightParams) intent.getParcelableExtra("KEY_SIGHT_PARAMS");
            if (parcelable == null) {
                parcelable = new SightParams(4, 0);
            }
            String str = "micromsg_" + System.currentTimeMillis();
            String str2 = C6457e.euR + str + VideoMaterialUtil.MP4_SUFFIX;
            String str3 = C6457e.euR + str + ".jpeg";
            int intExtra = intent.getIntExtra("key_pick_local_media_duration", 60);
            SightParams sightParams = new SightParams(4, 1);
            sightParams.osJ = 2;
            sightParams.mode = 0;
            if (sightParams.fcY == null) {
                sightParams.fcY = new VideoTransPara();
            }
            sightParams.fcY.duration = intExtra;
            sightParams.mo36644q(str, str2, str3, C6457e.euR + String.format("%s%d.%s", new Object[]{"capture", Long.valueOf(System.currentTimeMillis()), "jpg"}));
            intent.putExtra("KEY_SIGHT_PARAMS", parcelable);
            intent.putExtra("record_video_force_sys_camera", false);
            intent.putExtra("record_video_is_sight_capture", true);
            intent.addFlags(67108864);
            intent.putExtra("key_can_select_video_and_pic", true);
            C25985d.m41468b(this.val$context, "gallery", ".ui.GalleryEntryUI", intent, 4097);
            AppMethodBeat.m2505o(27120);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wenote.ui.nativenote.c$9 */
    class C300029 implements OnClickListener {
        final /* synthetic */ Context val$context;

        C300029(Context context) {
            this.val$context = context;
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(27123);
            C40380c.dem().mo63763av(-1, false);
            if (!C17950b.m28216sO((String) C1720g.m3536RP().mo5239Ry().get(274436, null))) {
                C4990ab.m7417i("MicroMsg.WNNoteFootPannel", "summerper checkPermission checkLocation[%b]", Boolean.valueOf(C35805b.m58707a((Activity) this.val$context, "android.permission.ACCESS_COARSE_LOCATION", 64, null, null)));
                if (!C35805b.m58707a((Activity) this.val$context, "android.permission.ACCESS_COARSE_LOCATION", 64, null, null)) {
                    AppMethodBeat.m2505o(27123);
                    return;
                }
            } else if (!C35805b.m58714o((Activity) this.val$context, "android.permission.ACCESS_COARSE_LOCATION")) {
                if (((Boolean) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_GDPR_LOCATION_PERMISSION_DESCRIBE_CONFIRM_BOOLEAN_SYNC, Boolean.FALSE)).booleanValue()) {
                    C35805b.m58709b((Activity) this.val$context, "android.permission.ACCESS_COARSE_LOCATION", 64);
                    AppMethodBeat.m2505o(27123);
                    return;
                }
                C32921a.m53856b((Activity) this.val$context, this.val$context.getResources().getString(C25738R.string.g7p, new Object[]{C4988aa.dor()}), 30764, true);
                AppMethodBeat.m2505o(27123);
                return;
            }
            Intent intent = new Intent();
            intent.putExtra(MMFragment.FLAG_OVERRIDE_EXIT_ANIMATION, C25738R.anim.f8373ce);
            intent.putExtra(MMFragment.FLAG_OVERRIDE_ENTER_ANIMATION, C25738R.anim.f8332b5);
            intent.putExtra("map_view_type", 3);
            C25985d.m41468b(this.val$context, C8741b.LOCATION, ".ui.RedirectUI", intent, 4098);
            AppMethodBeat.m2505o(27123);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wenote.ui.nativenote.c$11 */
    class C3574911 implements OnClickListener {
        final /* synthetic */ C40377a uUb;

        C3574911(C40377a c40377a) {
            this.uUb = c40377a;
        }

        public final void onClick(View view) {
            boolean z;
            boolean z2 = true;
            AppMethodBeat.m2504i(27125);
            C7060h.pYm.mo8381e(14547, Integer.valueOf(7));
            C36861b c36861b = C29993u.uSz;
            if (C46937c.this.uTX) {
                z = false;
            } else {
                z = true;
            }
            C46937c.m89641c(c36861b, Boolean.valueOf(z));
            C46937c c46937c = C46937c.this;
            if (C46937c.this.uTX) {
                z2 = false;
            }
            c46937c.uTX = z2;
            C46937c.m89639a(C46937c.this, view, C46937c.this.uTX);
            C46937c.m89640b(this.uUb);
            AppMethodBeat.m2505o(27125);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wenote.ui.nativenote.c$12 */
    class C3575012 implements OnClickListener {
        final /* synthetic */ C40377a uUb;

        C3575012(C40377a c40377a) {
            this.uUb = c40377a;
        }

        public final void onClick(View view) {
            boolean z = true;
            AppMethodBeat.m2504i(27126);
            C7060h.pYm.mo8381e(14547, Integer.valueOf(8));
            C46937c.this.uTU.setPressed(false);
            C46937c.this.uTS.setPressed(false);
            if (C46937c.this.uTZ || C46937c.this.uUa) {
                C46937c.this.uTY = false;
            }
            C46937c.m89641c(C29993u.uSB, Boolean.valueOf(!C46937c.this.uTY));
            C46937c c46937c = C46937c.this;
            if (C46937c.this.uTY) {
                z = false;
            }
            c46937c.uTY = z;
            C46937c.m89639a(C46937c.this, view, C46937c.this.uTY);
            C46937c.m89640b(this.uUb);
            C46937c.this.uTZ = false;
            C46937c.this.uUa = false;
            AppMethodBeat.m2505o(27126);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wenote.ui.nativenote.c$3 */
    class C403903 implements DialogInterface.OnClickListener {
        C403903() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(27118);
            C46937c.this.mo76175a(null);
            AppMethodBeat.m2505o(27118);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wenote.ui.nativenote.c$13 */
    class C4646413 implements OnClickListener {
        final /* synthetic */ C40377a uUb;

        C4646413(C40377a c40377a) {
            this.uUb = c40377a;
        }

        public final void onClick(View view) {
            boolean z = true;
            AppMethodBeat.m2504i(27127);
            C7060h.pYm.mo8381e(14547, Integer.valueOf(9));
            C46937c.this.uTR.setPressed(false);
            C46937c.this.uTU.setPressed(false);
            if (C46937c.this.uTY || C46937c.this.uUa) {
                C46937c.this.uTZ = false;
            }
            C46937c.m89641c(C29993u.uSC, Boolean.valueOf(!C46937c.this.uTZ));
            C46937c c46937c = C46937c.this;
            if (C46937c.this.uTZ) {
                z = false;
            }
            c46937c.uTZ = z;
            C46937c.m89639a(C46937c.this, view, C46937c.this.uTZ);
            C46937c.m89640b(this.uUb);
            C46937c.this.uTY = false;
            C46937c.this.uUa = false;
            AppMethodBeat.m2505o(27127);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wenote.ui.nativenote.c$1 */
    class C464651 implements OnClickListener {
        final /* synthetic */ C40377a uUb;

        C464651(C40377a c40377a) {
            this.uUb = c40377a;
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(27116);
            int a = C46937c.m89638a(C46937c.this);
            if (a == 1) {
                this.uUb.mo27050g(false, 0);
                this.uUb.mo27029af(3, 100);
                AppMethodBeat.m2505o(27116);
            } else if (a == 3) {
                this.uUb.mo27050g(true, 50);
                this.uUb.mo27029af(1, 0);
                AppMethodBeat.m2505o(27116);
            } else {
                if (a == 2) {
                    this.uUb.mo27029af(3, 0);
                }
                AppMethodBeat.m2505o(27116);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.wenote.ui.nativenote.c$2 */
    class C464662 implements OnClickListener {
        final /* synthetic */ C40377a uUb;

        C464662(C40377a c40377a) {
            this.uUb = c40377a;
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(27117);
            C7060h.pYm.mo8381e(14547, Integer.valueOf(10));
            C44001c c31480h = new C31480h();
            C46457k deT = C46457k.deT();
            if (deT != null) {
                C40380c.dem().mo63752a(c31480h, deT.deW(), false, false, true);
            } else {
                C40380c.dem().mo63752a(c31480h, null, false, false, true);
            }
            C46937c.m89640b(this.uUb);
            AppMethodBeat.m2505o(27117);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wenote.ui.nativenote.c$4 */
    class C464674 implements DialogInterface.OnClickListener {
        C464674() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    public C46937c() {
        AppMethodBeat.m2504i(27128);
        AppMethodBeat.m2505o(27128);
    }

    public final void ddT() {
        AppMethodBeat.m2504i(27129);
        C30379h.m48449a(this.uTP.getContext(), this.uTP.getContext().getString(C25738R.string.d89), "", true, new C403903(), new C464674());
        AppMethodBeat.m2505o(27129);
    }

    public final void ddS() {
        AppMethodBeat.m2504i(27130);
        mo76175a(null);
        AppMethodBeat.m2505o(27130);
    }

    /* renamed from: a */
    public final void mo76175a(C40377a c40377a) {
        AppMethodBeat.m2504i(27131);
        this.uTP.setImageResource(C25738R.drawable.a7g);
        if (this.uTV) {
            this.uTV = false;
            C40371k.ddK().ddL();
            String ddM = C40371k.ddK().ddM();
            int i = (int) C40371k.ddK().duration;
            int fY = (int) C41793a.m73795fY((long) i);
            int der = C40380c.dem().der();
            C44001c Ke = C40380c.dem().mo63750Ke(der);
            if (C5730e.m8628ct(ddM)) {
                if (!(der == -1 || Ke == null || Ke.getType() != 4)) {
                    ((C44003l) Ke).uOh = Boolean.FALSE;
                    ((C44003l) Ke).type = 4;
                    ((C44003l) Ke).uOp = true;
                    ((C44003l) Ke).uOD = "";
                    ((C44003l) Ke).length = fY;
                    ((C44003l) Ke).uOC = C41793a.m73794B(C4996ah.getContext(), fY).toString();
                    ((C44003l) Ke).hNN = C11851an.bvi() + "/fav_fileicon_recording.png";
                    ((C44003l) Ke).cHg = ddM;
                    ((C44003l) Ke).cAP = i;
                    C40380c.dem().mo63751Kg(der);
                }
                AppMethodBeat.m2505o(27131);
                return;
            }
            C4990ab.m7412e("MicroMsg.WNNoteFootPannel", "voicePath not exist, remove data from datalist and ui");
            C40380c.dem().mo63762au(der, false);
            if (c40377a != null) {
                c40377a.mo27025JZ(der);
            }
            C44001c c40365i = new C40365i();
            c40365i.content = "";
            c40365i.uNT = true;
            c40365i.uNZ = false;
            C40380c.dem().mo63756a(der, c40365i);
            C40380c.dem().mo63777gG(der - 1, der + 1);
            AppMethodBeat.m2505o(27131);
            return;
        }
        AppMethodBeat.m2505o(27131);
    }

    /* renamed from: ok */
    public final void mo74674ok(boolean z) {
        AppMethodBeat.m2504i(27132);
        this.uTX = z;
        this.uTQ.setPressed(z);
        AppMethodBeat.m2505o(27132);
    }

    /* renamed from: ol */
    public final void mo74675ol(boolean z) {
        AppMethodBeat.m2504i(27133);
        this.uTY = z;
        this.uTR.setPressed(z);
        AppMethodBeat.m2505o(27133);
    }

    /* renamed from: om */
    public final void mo74676om(boolean z) {
        AppMethodBeat.m2504i(27134);
        this.uTZ = z;
        this.uTS.setPressed(z);
        AppMethodBeat.m2505o(27134);
    }

    /* renamed from: on */
    public final void mo74677on(boolean z) {
        AppMethodBeat.m2504i(27135);
        this.uUa = z;
        this.uTU.setPressed(z);
        AppMethodBeat.m2505o(27135);
    }

    /* renamed from: c */
    static /* synthetic */ void m89641c(C23185t c23185t, Object obj) {
        AppMethodBeat.m2504i(27137);
        if (C46457k.deT() != null) {
            C46457k.deT().mo74681b(c23185t, obj);
        }
        AppMethodBeat.m2505o(27137);
    }

    /* renamed from: a */
    static /* synthetic */ void m89639a(C46937c c46937c, final View view, final boolean z) {
        AppMethodBeat.m2504i(27138);
        view.postDelayed(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(27119);
                view.setPressed(z);
                AppMethodBeat.m2505o(27119);
            }
        }, 100);
        AppMethodBeat.m2505o(27138);
    }

    /* renamed from: b */
    static /* synthetic */ void m89640b(C40377a c40377a) {
        AppMethodBeat.m2504i(27139);
        c40377a.mo27050g(true, 50);
        c40377a.mo27029af(1, 0);
        AppMethodBeat.m2505o(27139);
    }
}
