package com.tencent.p177mm.plugin.wenote.p587ui.nativenote;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.os.Bundle;
import android.os.Handler;
import android.support.p057v4.view.C0477s;
import android.support.p069v7.app.AppCompatActivity;
import android.support.p069v7.widget.C17495av;
import android.support.p069v7.widget.LinearLayoutManager;
import android.support.p069v7.widget.RecyclerView;
import android.support.p069v7.widget.RecyclerView.C17480i;
import android.support.p069v7.widget.RecyclerView.C41523a;
import android.support.p069v7.widget.RecyclerView.C41530m;
import android.support.p069v7.widget.RecyclerView.C41531v;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnTouchListener;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.gms.common.util.CrashUtils.ErrorDialogData;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.memory.p259a.C26399b;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.model.p262c.C18624c;
import com.tencent.p177mm.p1179au.C17950b;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p230g.p231a.C18348nt;
import com.tencent.p177mm.p230g.p231a.C37721gh;
import com.tencent.p177mm.p230g.p231a.C45316cl;
import com.tencent.p177mm.p249m.C42164b;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C40671n.C36073c;
import com.tencent.p177mm.p612ui.base.C40671n.C5279d;
import com.tencent.p177mm.p612ui.base.C44273l;
import com.tencent.p177mm.p612ui.base.C44275p;
import com.tencent.p177mm.p612ui.widget.p633a.C36356d;
import com.tencent.p177mm.p612ui.widget.snackbar.C24110a.C24109b;
import com.tencent.p177mm.p612ui.widget.snackbar.C5670b;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.fav.p407a.C27968h;
import com.tencent.p177mm.plugin.fav.p407a.C27968h.C27969a;
import com.tencent.p177mm.plugin.fav.p407a.C39037b;
import com.tencent.p177mm.plugin.fav.p407a.C7604ae;
import com.tencent.p177mm.plugin.fav.p410ui.C3105g;
import com.tencent.p177mm.plugin.fav.p410ui.C45932c;
import com.tencent.p177mm.plugin.fav.p410ui.detail.BaseFavDetailReportUI;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.sight.base.C21846d;
import com.tencent.p177mm.plugin.sight.base.C43528a;
import com.tencent.p177mm.plugin.wenote.model.C14719f;
import com.tencent.p177mm.plugin.wenote.model.C29980h;
import com.tencent.p177mm.plugin.wenote.model.C40368b;
import com.tencent.p177mm.plugin.wenote.model.C40369d;
import com.tencent.p177mm.plugin.wenote.model.C40371k;
import com.tencent.p177mm.plugin.wenote.model.C46453c;
import com.tencent.p177mm.plugin.wenote.model.nativenote.manager.C14734g;
import com.tencent.p177mm.plugin.wenote.model.nativenote.manager.C14734g.C4685a;
import com.tencent.p177mm.plugin.wenote.model.nativenote.manager.C14738h;
import com.tencent.p177mm.plugin.wenote.model.nativenote.manager.C29986d;
import com.tencent.p177mm.plugin.wenote.model.nativenote.manager.C29986d.C29987a;
import com.tencent.p177mm.plugin.wenote.model.nativenote.manager.C29989f;
import com.tencent.p177mm.plugin.wenote.model.nativenote.manager.C40380c;
import com.tencent.p177mm.plugin.wenote.model.nativenote.manager.C46457k;
import com.tencent.p177mm.plugin.wenote.model.nativenote.manager.WXRTEditText;
import com.tencent.p177mm.plugin.wenote.model.nativenote.p1074a.C14724a;
import com.tencent.p177mm.plugin.wenote.model.nativenote.p1565b.C40377a;
import com.tencent.p177mm.plugin.wenote.model.nativenote.p586c.C14729f;
import com.tencent.p177mm.plugin.wenote.model.nativenote.p586c.C40379a;
import com.tencent.p177mm.plugin.wenote.model.nativenote.p586c.C46456b;
import com.tencent.p177mm.plugin.wenote.model.nativenote.p586c.C4670d;
import com.tencent.p177mm.plugin.wenote.model.nativenote.p586c.C4675e;
import com.tencent.p177mm.plugin.wenote.model.nativenote.p586c.C4675e.C46714;
import com.tencent.p177mm.plugin.wenote.model.nativenote.p586c.C4675e.C46725;
import com.tencent.p177mm.plugin.wenote.model.nativenote.p586c.C4675e.C467710;
import com.tencent.p177mm.plugin.wenote.model.nativenote.p586c.C4675e.C46792;
import com.tencent.p177mm.plugin.wenote.model.nativenote.p586c.C4675e.C46803;
import com.tencent.p177mm.plugin.wenote.model.nativenote.p586c.C4675e.C468212;
import com.tencent.p177mm.plugin.wenote.model.nativenote.p586c.C4675e.C468311;
import com.tencent.p177mm.plugin.wenote.model.nativenote.p586c.C4675e.C468413;
import com.tencent.p177mm.plugin.wenote.model.p585a.C23177e;
import com.tencent.p177mm.plugin.wenote.model.p585a.C23178g;
import com.tencent.p177mm.plugin.wenote.model.p585a.C24930f;
import com.tencent.p177mm.plugin.wenote.model.p585a.C29978o;
import com.tencent.p177mm.plugin.wenote.model.p585a.C29979q;
import com.tencent.p177mm.plugin.wenote.model.p585a.C31480h;
import com.tencent.p177mm.plugin.wenote.model.p585a.C40365i;
import com.tencent.p177mm.plugin.wenote.model.p585a.C40366k;
import com.tencent.p177mm.plugin.wenote.model.p585a.C44000a;
import com.tencent.p177mm.plugin.wenote.model.p585a.C44001c;
import com.tencent.p177mm.plugin.wenote.model.p585a.C44002d;
import com.tencent.p177mm.plugin.wenote.model.p585a.C44003l;
import com.tencent.p177mm.plugin.wenote.model.p585a.C44004m;
import com.tencent.p177mm.plugin.wenote.model.p585a.C44794b;
import com.tencent.p177mm.plugin.wenote.model.p585a.C46451j;
import com.tencent.p177mm.plugin.wenote.model.p585a.C4668w;
import com.tencent.p177mm.plugin.wenote.p1333b.C23176b;
import com.tencent.p177mm.plugin.wenote.p1333b.C29977c;
import com.tencent.p177mm.plugin.wenote.p1333b.C43999a;
import com.tencent.p177mm.plugin.wenote.p587ui.nativenote.C46937c.C1479510;
import com.tencent.p177mm.plugin.wenote.p587ui.nativenote.C46937c.C231927;
import com.tencent.p177mm.plugin.wenote.p587ui.nativenote.C46937c.C231938;
import com.tencent.p177mm.plugin.wenote.p587ui.nativenote.C46937c.C300016;
import com.tencent.p177mm.plugin.wenote.p587ui.nativenote.C46937c.C300029;
import com.tencent.p177mm.plugin.wenote.p587ui.nativenote.C46937c.C3574911;
import com.tencent.p177mm.plugin.wenote.p587ui.nativenote.C46937c.C3575012;
import com.tencent.p177mm.plugin.wenote.p587ui.nativenote.C46937c.C4646413;
import com.tencent.p177mm.plugin.wenote.p587ui.nativenote.C46937c.C464651;
import com.tencent.p177mm.plugin.wenote.p587ui.nativenote.C46937c.C464662;
import com.tencent.p177mm.plugin.wenote.p587ui.nativenote.p1075a.C14789b;
import com.tencent.p177mm.plugin.wenote.p587ui.nativenote.p1075a.C29994a;
import com.tencent.p177mm.plugin.wenote.p587ui.nativenote.p1075a.C29995c;
import com.tencent.p177mm.plugin.wenote.p587ui.nativenote.voiceview.C44019a;
import com.tencent.p177mm.pluginsdk.C30036f;
import com.tencent.p177mm.pluginsdk.model.C40443e;
import com.tencent.p177mm.pluginsdk.permission.C35805b;
import com.tencent.p177mm.protocal.protobuf.aar;
import com.tencent.p177mm.protocal.protobuf.abf;
import com.tencent.p177mm.sdk.p1574f.C40612a;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C40619x;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.p177mm.storage.C7620bi;
import com.tencent.p177mm.vfs.C5728b;
import com.tencent.p177mm.vfs.C5730e;
import com.tencent.ttpic.baseutils.IOUtils;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: com.tencent.mm.plugin.wenote.ui.nativenote.NoteEditorUI */
public class NoteEditorUI extends BaseFavDetailReportUI implements C1202f, C40377a, C4685a, C29996a {
    private static final long mky = ((long) C42164b.m74341Nc());
    /* renamed from: WL */
    private View f2964WL = null;
    private int aaF = 0;
    OnGlobalLayoutListener aeL = new C1474232();
    private RecyclerView aiB;
    private long cvx = -1;
    private ProgressDialog ehJ = null;
    long fDy = -1;
    private C7306ak fbD;
    private float hkg = 0.0f;
    private float hkh = 0.0f;
    private String lZg;
    private String lsy = "";
    private C44275p lzK = null;
    protected C24109b mUw = new C1476516();
    boolean uMY = false;
    boolean uNq = false;
    private int uQI;
    private C46457k uSJ;
    private C29995c uSK;
    private LinearLayout uSL;
    private C46937c uSM = null;
    private RelativeLayout uSN = null;
    private C14734g uSO = null;
    private boolean uSP = false;
    boolean uSQ = false;
    private boolean uSR = false;
    private String uSS = "";
    private C29994a uST;
    private boolean uSU = false;
    private boolean uSV = false;
    private C14757a uSW;
    private aar uSX;
    private boolean uSY = false;
    private final Object uSZ = new Object();
    private LinearLayout uTa = null;
    private String uTb = "";
    private int uTc = 0;
    private int uTd = 0;
    private int uTe = 0;
    private String[] uTf = null;
    private boolean uTg = true;
    private long uTh = 0;
    private boolean uTi = false;
    private String uTj;
    boolean uTk = false;
    private boolean uTl = false;
    private boolean uTm = false;
    private boolean uTn = true;
    private int uTo = 0;
    private C41530m uTp = null;
    OnTouchListener uTq = new C1476736();
    private boolean uTr = false;
    private int uTs = -1;
    private boolean uTt = false;

    /* renamed from: com.tencent.mm.plugin.wenote.ui.nativenote.NoteEditorUI$4 */
    class C46884 implements Runnable {
        C46884() {
        }

        public final void run() {
            AppMethodBeat.m2504i(26997);
            if (NoteEditorUI.this.uST != null) {
                NoteEditorUI.this.uST.mo1757ah(NoteEditorUI.this.uTd, NoteEditorUI.this.uTe);
                NoteEditorUI.this.aaF = NoteEditorUI.this.uTd;
                NoteEditorUI.this.uTc = NoteEditorUI.this.uTe;
            }
            AppMethodBeat.m2505o(26997);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wenote.ui.nativenote.NoteEditorUI$31 */
    class C1474131 implements OnMenuItemClickListener {
        C1474131() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(27039);
            if (NoteEditorUI.m22944K(NoteEditorUI.this)) {
                NoteEditorUI.m22945L(NoteEditorUI.this);
                NoteEditorUI.this.finish();
                AppMethodBeat.m2505o(27039);
            } else {
                AppMethodBeat.m2505o(27039);
            }
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.wenote.ui.nativenote.NoteEditorUI$32 */
    class C1474232 implements OnGlobalLayoutListener {

        /* renamed from: com.tencent.mm.plugin.wenote.ui.nativenote.NoteEditorUI$32$1 */
        class C147431 implements Runnable {
            C147431() {
            }

            public final void run() {
                AppMethodBeat.m2504i(27040);
                NoteEditorUI.this.mo27055oj(false);
                AppMethodBeat.m2505o(27040);
            }
        }

        C1474232() {
        }

        public final void onGlobalLayout() {
            AppMethodBeat.m2504i(27041);
            long currentTimeMillis = System.currentTimeMillis();
            C4990ab.m7417i("MicroMsg.Note.NoteEditorUI", "startnoteeditorui, onGlobalLayout, current time is %d,from oncreate to dataloading, cost %d", Long.valueOf(currentTimeMillis), Long.valueOf(currentTimeMillis - NoteEditorUI.this.uTh));
            C5004al RS = C9638aw.m17180RS();
            C147431 c147431 = new C147431();
            if (NoteEditorUI.this.uQI == 1) {
                currentTimeMillis = 100;
            } else {
                currentTimeMillis = 0;
            }
            RS.mo10310m(c147431, currentTimeMillis);
            NoteEditorUI.this.aiB.getViewTreeObserver().removeGlobalOnLayoutListener(NoteEditorUI.this.aeL);
            AppMethodBeat.m2505o(27041);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wenote.ui.nativenote.NoteEditorUI$33 */
    class C1474433 extends C41530m {
        C1474433() {
        }

        /* renamed from: c */
        public final void mo6643c(RecyclerView recyclerView, int i) {
            AppMethodBeat.m2504i(27042);
            super.mo6643c(recyclerView, i);
            switch (i) {
                case 0:
                    C4675e.dfb().mo9794oq(C4675e.dfb().dfi());
                    C4675e.dfb().mo9793op(C4675e.dfb().dfg());
                    C4675e.dfb().mo9790h(false, 50);
                    break;
                case 1:
                    C4675e.dfb().dfj();
                    C4675e.dfb().dfh();
                    AppMethodBeat.m2505o(27042);
                    return;
                case 2:
                    AppMethodBeat.m2505o(27042);
                    return;
            }
            AppMethodBeat.m2505o(27042);
        }

        /* renamed from: a */
        public final void mo6642a(RecyclerView recyclerView, int i, int i2) {
            AppMethodBeat.m2504i(27043);
            super.mo6642a(recyclerView, i, i2);
            if (i2 > 30) {
                C4675e.dfb().dfj();
                C4675e.dfb().dfh();
            }
            C4670d dfd = C4675e.dfb().dfd();
            if ((NoteEditorUI.this.uSV || (NoteEditorUI.this.uSL != null && NoteEditorUI.this.uSL.getVisibility() == 0)) && dfd.dfa() == 2 && C14729f.m22928f(recyclerView, dfd.coc) == null) {
                NoteEditorUI.this.deb();
            }
            AppMethodBeat.m2505o(27043);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wenote.ui.nativenote.NoteEditorUI$5 */
    class C147475 implements Runnable {
        C147475() {
        }

        public final void run() {
            AppMethodBeat.m2504i(26998);
            try {
                int iT = ((LinearLayoutManager) NoteEditorUI.this.aiB.getLayoutManager()).mo1783iT();
                C44001c Ke = C40380c.dem().mo63750Ke(iT);
                if (!(Ke == null || Ke.getType() != 4 || ((C44003l) Ke).uOp)) {
                    NoteEditorUI.this.mo27023JX(iT);
                }
                AppMethodBeat.m2505o(26998);
            } catch (NullPointerException e) {
                AppMethodBeat.m2505o(26998);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.wenote.ui.nativenote.NoteEditorUI$12 */
    class C1475012 implements OnCancelListener {
        C1475012() {
        }

        public final void onCancel(DialogInterface dialogInterface) {
            AppMethodBeat.m2504i(27007);
            if (NoteEditorUI.this.lzK != null) {
                NoteEditorUI.this.lzK.dismiss();
                NoteEditorUI.this.lzK = null;
            }
            AppMethodBeat.m2505o(27007);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wenote.ui.nativenote.NoteEditorUI$14 */
    class C1475114 implements C29987a {
        C1475114() {
        }

        /* renamed from: a */
        public final void mo27057a(String str, C40366k c40366k) {
            AppMethodBeat.m2504i(27009);
            C4990ab.m7416i("MicroMsg.Note.NoteEditorUI", "compressNoteVideo onImportFinish");
            if (!(C5046bo.isNullOrNil(str) || !C5730e.m8628ct(str) || c40366k == null)) {
                c40366k.thumbPath = str;
            }
            AppMethodBeat.m2505o(27009);
        }

        /* renamed from: b */
        public final void mo27058b(String str, C40366k c40366k) {
            AppMethodBeat.m2504i(27010);
            C4990ab.m7416i("MicroMsg.Note.NoteEditorUI", "compressNoteVideo onExportFinish");
            if (NoteEditorUI.this.ehJ != null) {
                NoteEditorUI.this.ehJ.dismiss();
                NoteEditorUI.this.ehJ = null;
            }
            if (C5046bo.isNullOrNil(str) || !C5730e.m8628ct(str) || c40366k == null || c40366k.uOg) {
                C4990ab.m7416i("MicroMsg.Note.NoteEditorUI", "file not exist or user canceled");
            } else if (new C5728b(str).length() < NoteEditorUI.mky) {
                c40366k.cHg = str;
                C40380c.dem().mo63752a((C44001c) c40366k, NoteEditorUI.this.uSJ.deW(), false, true, false);
            } else {
                Toast.makeText(NoteEditorUI.this.mController.ylL, NoteEditorUI.this.getString(C25738R.string.bs4), 1).show();
            }
            NoteEditorUI.this.mo27050g(true, 100);
            NoteEditorUI.this.mo27029af(1, 0);
            AppMethodBeat.m2505o(27010);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wenote.ui.nativenote.NoteEditorUI$25 */
    class C1475325 implements Runnable {
        C1475325() {
        }

        public final void run() {
            AppMethodBeat.m2504i(27033);
            if (NoteEditorUI.this.ehJ != null) {
                NoteEditorUI.this.ehJ.dismiss();
                NoteEditorUI.this.ehJ = null;
            }
            AppMethodBeat.m2505o(27033);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wenote.ui.nativenote.NoteEditorUI$26 */
    class C1475426 implements Runnable {
        C1475426() {
        }

        public final void run() {
            AppMethodBeat.m2504i(27034);
            C30379h.m48461b(NoteEditorUI.this.mController.ylL, NoteEditorUI.this.getString(C25738R.string.g1n), null, true);
            AppMethodBeat.m2505o(27034);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wenote.ui.nativenote.NoteEditorUI$27 */
    class C1475527 implements OnClickListener {
        C1475527() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(27035);
            NoteEditorUI.this.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
            AppMethodBeat.m2505o(27035);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wenote.ui.nativenote.NoteEditorUI$28 */
    class C1475628 implements OnClickListener {
        C1475628() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(27036);
            dialogInterface.dismiss();
            NoteEditorUI.this.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
            AppMethodBeat.m2505o(27036);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wenote.ui.nativenote.NoteEditorUI$a */
    class C14757a extends C14789b {
        C14757a() {
        }

        public final void dfS() {
            AppMethodBeat.m2504i(27048);
            NoteEditorUI.m22967aa(NoteEditorUI.this);
            AppMethodBeat.m2505o(27048);
        }

        public final void dfT() {
            AppMethodBeat.m2504i(27049);
            NoteEditorUI.this.dyc();
            NoteEditorUI.m22967aa(NoteEditorUI.this);
            AppMethodBeat.m2505o(27049);
        }

        public final void dfU() {
            AppMethodBeat.m2504i(27050);
            NoteEditorUI.this.dyb();
            AppMethodBeat.m2505o(27050);
        }

        public final void dfV() {
            AppMethodBeat.m2504i(27051);
            NoteEditorUI.this.mlz.mfe = true;
            AppMethodBeat.m2505o(27051);
        }

        /* renamed from: c */
        public final void mo6643c(RecyclerView recyclerView, int i) {
            AppMethodBeat.m2504i(27052);
            super.mo6643c(recyclerView, i);
            if (recyclerView.getLayoutManager() != null) {
                View childAt = ((LinearLayoutManager) NoteEditorUI.this.aiB.getLayoutManager()).getChildAt(0);
                if (childAt != null) {
                    NoteEditorUI.this.uTc = childAt.getTop();
                    NoteEditorUI.this.aaF = C17480i.m27148bt(childAt);
                }
            }
            AppMethodBeat.m2505o(27052);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wenote.ui.nativenote.NoteEditorUI$29 */
    class C1476029 implements OnClickListener {
        C1476029() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(27037);
            dialogInterface.dismiss();
            AppMethodBeat.m2505o(27037);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wenote.ui.nativenote.NoteEditorUI$19 */
    class C1476219 implements Runnable {
        C1476219() {
        }

        public final void run() {
            AppMethodBeat.m2504i(27015);
            C4675e.dfb().mo9794oq(C4675e.dfb().dfi());
            C4675e.dfb().mo9793op(C4675e.dfb().dfg());
            AppMethodBeat.m2505o(27015);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wenote.ui.nativenote.NoteEditorUI$1 */
    class C147631 implements View.OnClickListener {
        C147631() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(26994);
            if (NoteEditorUI.this.uSO != null) {
                NoteEditorUI.this.uSO.uPB.dismiss();
            }
            NoteEditorUI.this.uSN.setVisibility(8);
            AppMethodBeat.m2505o(26994);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wenote.ui.nativenote.NoteEditorUI$16 */
    class C1476516 implements C24109b {
        C1476516() {
        }

        public final void aIu() {
            AppMethodBeat.m2504i(27012);
            C37721gh c37721gh = new C37721gh();
            c37721gh.cAH.type = 35;
            C4879a.xxA.mo10055m(c37721gh);
            AppMethodBeat.m2505o(27012);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wenote.ui.nativenote.NoteEditorUI$18 */
    class C1476618 implements Runnable {
        C1476618() {
        }

        public final void run() {
            AppMethodBeat.m2504i(27014);
            WXRTEditText deS = NoteEditorUI.this.uSJ.deS();
            if (deS != null) {
                deS.clearFocus();
            }
            AppMethodBeat.m2505o(27014);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wenote.ui.nativenote.NoteEditorUI$36 */
    class C1476736 implements OnTouchListener {

        /* renamed from: com.tencent.mm.plugin.wenote.ui.nativenote.NoteEditorUI$36$1 */
        class C147681 implements Runnable {
            C147681() {
            }

            public final void run() {
                AppMethodBeat.m2504i(27046);
                C4675e.dfb().mo9794oq(true);
                C4675e.dfb().mo9793op(true);
                AppMethodBeat.m2505o(27046);
            }
        }

        C1476736() {
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            AppMethodBeat.m2504i(27047);
            if (motionEvent.getAction() == 0) {
                NoteEditorUI.this.hkg = motionEvent.getX();
                NoteEditorUI.this.hkh = motionEvent.getY();
            }
            float abs;
            float abs2;
            if (motionEvent.getAction() == 1 && NoteEditorUI.this.aiB.mo66441x(motionEvent.getX(), motionEvent.getY()) == null) {
                abs = Math.abs(NoteEditorUI.this.hkg - motionEvent.getX());
                abs2 = Math.abs(NoteEditorUI.this.hkh - motionEvent.getY());
                if (abs < 30.0f && abs2 < 30.0f) {
                    if (NoteEditorUI.this.uSN.getVisibility() != 8) {
                        if (NoteEditorUI.this.uSO != null) {
                            NoteEditorUI.this.uSO.uPB.dismiss();
                        }
                        NoteEditorUI.this.uSN.setVisibility(8);
                    } else {
                        int size = C40380c.dem().size();
                        C44001c Ke = C40380c.dem().mo63750Ke(size - 1);
                        if (Ke != null) {
                            boolean z = Ke.uNT;
                            C40380c.dem().dep();
                            Ke.uNT = true;
                            Ke.uNZ = false;
                            Ke.uNV = -1;
                            NoteEditorUI.this.uSK.mo66316cg(size - 1);
                            NoteEditorUI.this.mo27050g(true, 50);
                            NoteEditorUI.this.mo27029af(1, 0);
                            if (NoteEditorUI.this.uTn && z) {
                                NoteEditorUI.this.fbD.postDelayed(new C147681(), 100);
                            }
                        }
                    }
                }
            } else if (motionEvent.getAction() == 2) {
                abs = Math.abs(NoteEditorUI.this.hkg - motionEvent.getX());
                abs2 = Math.abs(NoteEditorUI.this.hkh - motionEvent.getY());
                if (abs > 120.0f || abs2 > 120.0f) {
                    if (NoteEditorUI.this.uTn) {
                        if (C4675e.dfb().dfa() == 1) {
                            NoteEditorUI.this.deb();
                            C4675e.dfb().dff();
                        }
                    } else if (!NoteEditorUI.this.uSU) {
                        NoteEditorUI.this.deb();
                    }
                }
            }
            AppMethodBeat.m2505o(27047);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.wenote.ui.nativenote.NoteEditorUI$8 */
    class C147698 implements OnCancelListener {
        C147698() {
        }

        public final void onCancel(DialogInterface dialogInterface) {
            AppMethodBeat.m2504i(27003);
            if (NoteEditorUI.this.ehJ != null) {
                NoteEditorUI.this.ehJ.dismiss();
                NoteEditorUI.this.ehJ = null;
            }
            AppMethodBeat.m2505o(27003);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wenote.ui.nativenote.NoteEditorUI$10 */
    class C1477010 implements OnCancelListener {
        C1477010() {
        }

        public final void onCancel(DialogInterface dialogInterface) {
            AppMethodBeat.m2504i(27005);
            if (NoteEditorUI.this.ehJ != null) {
                NoteEditorUI.this.ehJ.dismiss();
                NoteEditorUI.this.ehJ = null;
            }
            AppMethodBeat.m2505o(27005);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wenote.ui.nativenote.NoteEditorUI$11 */
    class C1477111 implements Runnable {
        C1477111() {
        }

        public final void run() {
            AppMethodBeat.m2504i(27006);
            Toast.makeText(NoteEditorUI.this, NoteEditorUI.this.getString(C25738R.string.egv), 0).show();
            AppMethodBeat.m2505o(27006);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wenote.ui.nativenote.NoteEditorUI$17 */
    class C1477217 implements OnClickListener {
        C1477217() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(27013);
            C4675e.dfb().dfp();
            AppMethodBeat.m2505o(27013);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wenote.ui.nativenote.NoteEditorUI$23 */
    class C1477523 implements OnMenuItemClickListener {

        /* renamed from: com.tencent.mm.plugin.wenote.ui.nativenote.NoteEditorUI$23$1 */
        class C147761 implements C36073c {
            C147761() {
            }

            /* renamed from: a */
            public final void mo5746a(C44273l c44273l) {
                AppMethodBeat.m2504i(27019);
                if (NoteEditorUI.this.uQI == 1) {
                    c44273l.mo70068e(4, NoteEditorUI.this.getString(C25738R.string.bri));
                    NoteEditorUI.m22966a(NoteEditorUI.this, c44273l);
                    c44273l.mo70068e(3, NoteEditorUI.this.getString(C25738R.string.dcq));
                    AppMethodBeat.m2505o(27019);
                } else if (NoteEditorUI.this.uQI == 2) {
                    int i;
                    c44273l.mo70068e(0, NoteEditorUI.this.getString(C25738R.string.bri));
                    if (C43999a.dfJ()) {
                        c44273l.mo70068e(7, NoteEditorUI.this.mController.ylL.getString(C25738R.string.bq_));
                    }
                    if (!NoteEditorUI.this.uTi) {
                        c44273l.mo70068e(14, NoteEditorUI.this.getString(C25738R.string.br7));
                    }
                    String str = (String) C18624c.abi().mo17131ll("100353").dru().get("Close");
                    if (C5046bo.isNullOrNil(str)) {
                        i = 0;
                    } else {
                        i = C5046bo.getInt(str, 0);
                    }
                    if (i == 0) {
                        i = 1;
                    } else {
                        i = 0;
                    }
                    if (i != 0) {
                        c44273l.mo70068e(8, NoteEditorUI.this.mController.ylL.getString(C25738R.string.d8b));
                    }
                    NoteEditorUI.m22966a(NoteEditorUI.this, c44273l);
                    c44273l.mo70068e(1, NoteEditorUI.this.getString(C25738R.string.bo8));
                    c44273l.mo70068e(2, NoteEditorUI.this.mController.ylL.getString(C25738R.string.f9088p4));
                    AppMethodBeat.m2505o(27019);
                } else {
                    if (NoteEditorUI.this.uQI == 4) {
                        c44273l.mo70068e(9, NoteEditorUI.this.getString(C25738R.string.bri));
                        if (C43999a.dfJ()) {
                            c44273l.mo70068e(12, NoteEditorUI.this.mController.ylL.getString(C25738R.string.bq_));
                        }
                        c44273l.mo70068e(10, NoteEditorUI.this.getString(C25738R.string.dcq));
                    }
                    AppMethodBeat.m2505o(27019);
                }
            }
        }

        /* renamed from: com.tencent.mm.plugin.wenote.ui.nativenote.NoteEditorUI$23$2 */
        class C147772 implements C5279d {

            /* renamed from: com.tencent.mm.plugin.wenote.ui.nativenote.NoteEditorUI$23$2$4 */
            class C46864 implements Runnable {
                C46864() {
                }

                public final void run() {
                    AppMethodBeat.m2504i(27025);
                    Toast.makeText(NoteEditorUI.this, NoteEditorUI.this.getString(C25738R.string.egu), 0).show();
                    AppMethodBeat.m2505o(27025);
                }
            }

            /* renamed from: com.tencent.mm.plugin.wenote.ui.nativenote.NoteEditorUI$23$2$7 */
            class C46877 implements Runnable {
                C46877() {
                }

                public final void run() {
                    AppMethodBeat.m2504i(27028);
                    Toast.makeText(NoteEditorUI.this, NoteEditorUI.this.getString(C25738R.string.egu), 0).show();
                    AppMethodBeat.m2505o(27028);
                }
            }

            /* renamed from: com.tencent.mm.plugin.wenote.ui.nativenote.NoteEditorUI$23$2$5 */
            class C147785 implements OnCancelListener {
                C147785() {
                }

                public final void onCancel(DialogInterface dialogInterface) {
                    AppMethodBeat.m2504i(27026);
                    if (NoteEditorUI.this.lzK != null) {
                        NoteEditorUI.this.lzK.dismiss();
                        NoteEditorUI.this.lzK = null;
                    }
                    AppMethodBeat.m2505o(27026);
                }
            }

            /* renamed from: com.tencent.mm.plugin.wenote.ui.nativenote.NoteEditorUI$23$2$1 */
            class C147791 implements OnCancelListener {
                C147791() {
                }

                public final void onCancel(DialogInterface dialogInterface) {
                    AppMethodBeat.m2504i(27020);
                    if (NoteEditorUI.this.lzK != null) {
                        NoteEditorUI.this.lzK.dismiss();
                        NoteEditorUI.this.lzK = null;
                    }
                    AppMethodBeat.m2505o(27020);
                }
            }

            /* renamed from: com.tencent.mm.plugin.wenote.ui.nativenote.NoteEditorUI$23$2$3 */
            class C147803 implements OnClickListener {
                C147803() {
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.m2504i(27024);
                    final C44275p b = C30379h.m48458b(NoteEditorUI.this.mController.ylL, NoteEditorUI.this.getString(C25738R.string.f9089p5), false, null);
                    NoteEditorUI.this.uSJ.deV();
                    C37721gh c37721gh = new C37721gh();
                    c37721gh.cAH.type = 12;
                    c37721gh.cAH.cvv = NoteEditorUI.this.fDy;
                    c37721gh.cAH.cAM = new Runnable() {
                        public final void run() {
                            AppMethodBeat.m2504i(27023);
                            NoteEditorUI.this.mlz.mfd = true;
                            b.dismiss();
                            C4990ab.m7411d("MicroMsg.Note.NoteEditorUI", "do del, local id %d", Long.valueOf(NoteEditorUI.this.fDy));
                            NoteEditorUI.this.finish();
                            AppMethodBeat.m2505o(27023);
                        }
                    };
                    C4879a.xxA.mo10055m(c37721gh);
                    AppMethodBeat.m2505o(27024);
                }
            }

            /* renamed from: com.tencent.mm.plugin.wenote.ui.nativenote.NoteEditorUI$23$2$6 */
            class C147826 implements Runnable {
                C147826() {
                }

                public final void run() {
                    AppMethodBeat.m2504i(27027);
                    NoteEditorUI.this.uSJ.deV();
                    C44001c c44000a = new C44000a();
                    c44000a.uNT = false;
                    c44000a.uNZ = false;
                    C40380c.dem().mo63757a(c44000a);
                    int i = NoteEditorUI.this.uSJ.uQI;
                    NoteEditorUI.this.uSJ.uQI = 3;
                    C29980h.m47434JW(i);
                    AppMethodBeat.m2505o(27027);
                }
            }

            /* renamed from: com.tencent.mm.plugin.wenote.ui.nativenote.NoteEditorUI$23$2$2 */
            class C147832 implements Runnable {

                /* renamed from: com.tencent.mm.plugin.wenote.ui.nativenote.NoteEditorUI$23$2$2$1 */
                class C147841 implements Runnable {
                    C147841() {
                    }

                    public final void run() {
                        AppMethodBeat.m2504i(27021);
                        NoteEditorUI.m22982g(NoteEditorUI.this);
                        C37721gh c37721gh = new C37721gh();
                        c37721gh.cAH.type = 32;
                        c37721gh.cAH.cvv = NoteEditorUI.this.fDy;
                        C4879a.xxA.mo10055m(c37721gh);
                        boolean z = c37721gh.cAI.cAY;
                        int i = c37721gh.cAI.ret != 0 ? 1 : 0;
                        if (c37721gh.cAI.path == null) {
                            C30379h.m48465bQ(NoteEditorUI.this.mController.ylL, NoteEditorUI.this.getString(C25738R.string.br6));
                            AppMethodBeat.m2505o(27021);
                        } else if (z) {
                            C30379h.m48465bQ(NoteEditorUI.this.mController.ylL, NoteEditorUI.this.getString(C25738R.string.f8637ak));
                            AppMethodBeat.m2505o(27021);
                        } else if (i != 0) {
                            C30379h.m48465bQ(NoteEditorUI.this.mController.ylL, NoteEditorUI.this.getString(C25738R.string.f8638al));
                            AppMethodBeat.m2505o(27021);
                        } else {
                            Intent intent = new Intent();
                            intent.putExtra("Select_Conv_Type", 3);
                            intent.putExtra("scene_from", 1);
                            intent.putExtra("mutil_select_is_ret", true);
                            intent.putExtra("select_fav_local_id", NoteEditorUI.this.fDy);
                            C25985d.m41466b(NoteEditorUI.this, ".ui.transmit.SelectConversationUI", intent, 4101);
                            C27968h.m44531j(NoteEditorUI.this.fDy, 1, 0);
                            C27969a i2 = NoteEditorUI.this.mlz;
                            i2.meZ++;
                            AppMethodBeat.m2505o(27021);
                        }
                    }
                }

                C147832() {
                }

                public final void run() {
                    AppMethodBeat.m2504i(27022);
                    NoteEditorUI noteEditorUI = NoteEditorUI.this;
                    String deu = C40380c.dem().deu();
                    if (NoteEditorUI.ahr(deu)) {
                        C37721gh c37721gh = new C37721gh();
                        c37721gh.cAH.type = 12;
                        c37721gh.cAH.cvv = noteEditorUI.fDy;
                        C4879a.xxA.mo10055m(c37721gh);
                    } else {
                        if (noteEditorUI.uNq || noteEditorUI.uMY) {
                            C4990ab.m7416i("MicroMsg.Note.NoteEditorUI", "syncWNNoteFavItem noteeditorui, do savewnnotefavitem");
                            noteEditorUI.mo27054i(deu, true, true);
                        } else if (noteEditorUI.uSQ) {
                            C4990ab.m7416i("MicroMsg.Note.NoteEditorUI", "syncWNNoteFavItem noteeditorui, do updateWNNoteFavitem");
                            noteEditorUI.mo27054i(deu, false, true);
                        }
                        noteEditorUI.uTk = true;
                    }
                    if (NoteEditorUI.this.lzK == null) {
                        AppMethodBeat.m2505o(27022);
                        return;
                    }
                    C5004al.m7441d(new C147841());
                    AppMethodBeat.m2505o(27022);
                }
            }

            C147772() {
            }

            public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                int i2 = 0;
                int i3 = 1;
                AppMethodBeat.m2504i(27029);
                Intent intent;
                C27969a k;
                C37721gh c37721gh;
                boolean z;
                switch (menuItem.getItemId()) {
                    case 0:
                        if (NoteEditorUI.this.uSM != null) {
                            NoteEditorUI.this.uSM.mo76175a(null);
                        }
                        NoteEditorUI.this.lzK = C30379h.m48458b(NoteEditorUI.this.mController.ylL, NoteEditorUI.this.getString(C25738R.string.f8639am), true, new C147791());
                        C7305d.post(new C147832(), "AddFavNoteSync");
                        AppMethodBeat.m2505o(27029);
                        return;
                    case 1:
                        if (NoteEditorUI.this.uSM != null) {
                            NoteEditorUI.this.uSM.mo76175a(null);
                        }
                        NoteEditorUI.this.uSJ.deV();
                        intent = new Intent();
                        intent.putExtra("key_fav_scene", 2);
                        intent.putExtra("key_fav_item_id", NoteEditorUI.this.fDy);
                        C39037b.m66371b(NoteEditorUI.this.mController.ylL, ".ui.FavTagEditUI", intent);
                        k = NoteEditorUI.this.mlz;
                        k.mfc++;
                        AppMethodBeat.m2505o(27029);
                        return;
                    case 2:
                        C30379h.m48440a(NoteEditorUI.this.mController.ylL, NoteEditorUI.this.getString(C25738R.string.f9089p5), "", new C147803(), null);
                        AppMethodBeat.m2505o(27029);
                        return;
                    case 3:
                        C45316cl c45316cl = new C45316cl();
                        C40443e.m69369a(c45316cl, NoteEditorUI.this.cvx);
                        C4879a.xxA.mo10055m(c45316cl);
                        C45932c.m85258a(c45316cl.cvB.ret, NoteEditorUI.this, NoteEditorUI.this.mUw);
                        AppMethodBeat.m2505o(27029);
                        return;
                    case 4:
                        intent = new Intent();
                        intent.putExtra("Select_Conv_Type", 3);
                        intent.putExtra("select_is_ret", true);
                        intent.putExtra("mutil_select_is_ret", true);
                        intent.putExtra("Retr_Msg_Type", 2);
                        intent.putExtra("Retr_Msg_Id", NoteEditorUI.this.cvx);
                        C25985d.m41466b(NoteEditorUI.this, ".ui.transmit.SelectConversationUI", intent, 4096);
                        k = NoteEditorUI.this.mlz;
                        k.meZ++;
                        AppMethodBeat.m2505o(27029);
                        return;
                    case 5:
                        NoteEditorUI.this.uSJ.deV();
                        C29979q c29979q = new C29979q();
                        c29979q.uOr = NoteEditorUI.this.uQI == 1;
                        c29979q.uOv = NoteEditorUI.this.uTb;
                        c29979q.uOu = C40380c.dem().ahf(NoteEditorUI.this.getString(C25738R.string.g16));
                        c29979q.uOw = NoteEditorUI.this.aaF;
                        c29979q.uOx = NoteEditorUI.this.uTc;
                        if (NoteEditorUI.this.uQI == 1) {
                            c29979q.uOt = NoteEditorUI.this.cvx;
                            if (NoteEditorUI.this.uTl) {
                                c29979q.mgQ = true;
                                C7060h.pYm.mo8381e(14790, Integer.valueOf(3));
                            } else {
                                c29979q.mgQ = false;
                                C7060h.pYm.mo8381e(14790, Integer.valueOf(2));
                            }
                        } else {
                            C7060h.pYm.mo8381e(14790, Integer.valueOf(1));
                            c29979q.uOs = NoteEditorUI.this.fDy;
                        }
                        C14738h.deH().mo27009a(c29979q);
                        C5670b.m8523i(NoteEditorUI.this, NoteEditorUI.this.getString(C25738R.string.g17));
                        AppMethodBeat.m2505o(27029);
                        return;
                    case 6:
                        C14738h.deH().mo27009a(null);
                        C5670b.m8523i(NoteEditorUI.this, NoteEditorUI.this.getString(C25738R.string.g11));
                        AppMethodBeat.m2505o(27029);
                        return;
                    case 7:
                        C27968h.m44531j(NoteEditorUI.this.fDy, 0, 0);
                        if (NoteEditorUI.this.uMY || NoteEditorUI.this.uNq) {
                            i2 = 1;
                        } else if (NoteEditorUI.this.uSQ && !C40380c.dem().deu().equals(NoteEditorUI.this.uSS)) {
                            i2 = 1;
                        }
                        if (i2 != 0) {
                            NoteEditorUI.this.uSJ.deV();
                            NoteEditorUI.this.dfL();
                            NoteEditorUI.this.uTk = true;
                        }
                        if (NoteEditorUI.this.uMY || NoteEditorUI.this.uNq) {
                            NoteEditorUI.this.uMY = false;
                            NoteEditorUI.this.uNq = false;
                            NoteEditorUI.this.uSQ = true;
                        }
                        c37721gh = new C37721gh();
                        c37721gh.cAH.type = 30;
                        c37721gh.cAH.cAO = 1;
                        c37721gh.cAH.cvv = NoteEditorUI.this.fDy;
                        C4879a.xxA.mo10055m(c37721gh);
                        String str = c37721gh.cAI.path;
                        NoteEditorUI.this.lZg = c37721gh.cAI.thumbPath;
                        if (C5046bo.isNullOrNil(str)) {
                            NoteEditorUI.this.fbD.post(new C46864());
                            AppMethodBeat.m2505o(27029);
                            return;
                        }
                        NoteEditorUI.m22976b(NoteEditorUI.this, str);
                        k = NoteEditorUI.this.mlz;
                        k.mfa++;
                        AppMethodBeat.m2505o(27029);
                        return;
                    case 8:
                        NoteEditorUI.this.lzK = C30379h.m48458b(NoteEditorUI.this.mController.ylL, NoteEditorUI.this.getString(C25738R.string.g2l), true, new C147785());
                        c37721gh = new C37721gh();
                        c37721gh.cAH.type = 32;
                        c37721gh.cAH.cvv = NoteEditorUI.this.fDy;
                        c37721gh.cAH.cvC = C46453c.ddG().uMN.uMZ;
                        C4879a.xxA.mo10055m(c37721gh);
                        z = c37721gh.cAI.cAY;
                        C7060h c7060h;
                        Object[] objArr;
                        if (c37721gh.cAI.path == null) {
                            NoteEditorUI.m22982g(NoteEditorUI.this);
                            Toast.makeText(NoteEditorUI.this.mController.ylL, NoteEditorUI.this.mController.ylL.getString(C25738R.string.d87), 1).show();
                            c7060h = C7060h.pYm;
                            objArr = new Object[5];
                            objArr[0] = Integer.valueOf(0);
                            objArr[1] = Integer.valueOf(0);
                            objArr[2] = Integer.valueOf(0);
                            objArr[3] = Integer.valueOf(5);
                            if (!NoteEditorUI.this.uTi) {
                                i3 = 0;
                            }
                            objArr[4] = Integer.valueOf(i3);
                            c7060h.mo8381e(14811, objArr);
                            AppMethodBeat.m2505o(27029);
                            return;
                        } else if (z) {
                            NoteEditorUI.m22982g(NoteEditorUI.this);
                            Toast.makeText(NoteEditorUI.this.mController.ylL, NoteEditorUI.this.mController.ylL.getString(C25738R.string.d87), 1).show();
                            c7060h = C7060h.pYm;
                            objArr = new Object[5];
                            objArr[0] = Integer.valueOf(0);
                            objArr[1] = Integer.valueOf(0);
                            objArr[2] = Integer.valueOf(0);
                            objArr[3] = Integer.valueOf(5);
                            if (!NoteEditorUI.this.uTi) {
                                i3 = 0;
                            }
                            objArr[4] = Integer.valueOf(i3);
                            c7060h.mo8381e(14811, objArr);
                            AppMethodBeat.m2505o(27029);
                            return;
                        } else {
                            NoteEditorUI.this.fbD.post(new C147826());
                            AppMethodBeat.m2505o(27029);
                            return;
                        }
                    case 9:
                        c37721gh = new C37721gh();
                        c37721gh.cAH.type = 32;
                        c37721gh.cAH.cvv = NoteEditorUI.this.fDy;
                        c37721gh.cAH.cvC = C46453c.ddG().uMN.uMZ;
                        C4879a.xxA.mo10055m(c37721gh);
                        z = c37721gh.cAI.cAY;
                        if (c37721gh.cAI.ret != 0) {
                            i2 = 1;
                        }
                        if (c37721gh.cAI.path == null) {
                            C30379h.m48465bQ(NoteEditorUI.this.mController.ylL, NoteEditorUI.this.getString(C25738R.string.br6));
                            AppMethodBeat.m2505o(27029);
                            return;
                        } else if (z) {
                            C30379h.m48465bQ(NoteEditorUI.this.mController.ylL, NoteEditorUI.this.getString(C25738R.string.f8637ak));
                            AppMethodBeat.m2505o(27029);
                            return;
                        } else if (i2 != 0) {
                            C30379h.m48465bQ(NoteEditorUI.this.mController.ylL, NoteEditorUI.this.getString(C25738R.string.f8638al));
                            AppMethodBeat.m2505o(27029);
                            return;
                        } else {
                            intent = new Intent();
                            intent.putExtra("Select_Conv_Type", 3);
                            intent.putExtra("scene_from", 1);
                            intent.putExtra("mutil_select_is_ret", true);
                            intent.putExtra("select_fav_local_id", NoteEditorUI.this.fDy);
                            intent.putExtra("Retr_fav_xml_str", C46453c.ddG().uMN.ddH());
                            C25985d.m41466b(NoteEditorUI.this, ".ui.transmit.SelectConversationUI", intent, 4355);
                            k = NoteEditorUI.this.mlz;
                            k.meZ++;
                            AppMethodBeat.m2505o(27029);
                            return;
                        }
                    case 10:
                        C29980h.m47440br(NoteEditorUI.this.mController.ylL, NoteEditorUI.this.lsy);
                        AppMethodBeat.m2505o(27029);
                        return;
                    case 11:
                        AppMethodBeat.m2505o(27029);
                        return;
                    case 12:
                        if (C5046bo.isNullOrNil(NoteEditorUI.this.uTj)) {
                            NoteEditorUI.this.fbD.post(new C46877());
                            AppMethodBeat.m2505o(27029);
                            return;
                        }
                        k = NoteEditorUI.this.mlz;
                        k.mfa++;
                        NoteEditorUI.m22976b(NoteEditorUI.this, NoteEditorUI.this.uTj);
                        AppMethodBeat.m2505o(27029);
                        return;
                    case 13:
                        intent = new Intent();
                        intent.putExtra("k_expose_msg_id", NoteEditorUI.this.lsy);
                        if (NoteEditorUI.this.uTf != null && NoteEditorUI.this.uTf.length > 1) {
                            intent.putExtra("k_username", NoteEditorUI.this.uTf[1]);
                        }
                        intent.putExtra("showShare", NoteEditorUI.this.uTg);
                        intent.putExtra("rawUrl", String.format("https://weixin110.qq.com/security/readtemplate?t=weixin_report/w_type&scene=%d#wechat_redirect", new Object[]{Integer.valueOf(33)}));
                        C25985d.m41467b(NoteEditorUI.this.mController.ylL, "webview", ".ui.tools.WebViewUI", intent);
                        AppMethodBeat.m2505o(27029);
                        return;
                    case 14:
                        C3105g.m5347a(NoteEditorUI.this, NoteEditorUI.this.fDy, NoteEditorUI.this.mlz);
                        break;
                }
                AppMethodBeat.m2505o(27029);
            }
        }

        C1477523() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            int i = 1;
            AppMethodBeat.m2504i(27031);
            final C36356d c36356d = new C36356d(NoteEditorUI.this.mController.ylL, 1, false);
            c36356d.rBl = new C147761();
            c36356d.rBm = new C147772();
            if (NoteEditorUI.this.uQI == 2) {
                C40380c dem = C40380c.dem();
                if (dem.uPe <= 0 && dem.uPd <= 0) {
                    i = 0;
                }
                if (i == 0) {
                    AppMethodBeat.m2505o(27031);
                    return false;
                }
            }
            if (NoteEditorUI.this.uQI == 2) {
                NoteEditorUI.this.deb();
                if (NoteEditorUI.this.uSO != null) {
                    NoteEditorUI.this.uSO.uPB.dismiss();
                }
                NoteEditorUI.this.uSN.setVisibility(8);
                if (NoteEditorUI.this.uTn) {
                    C4675e.dfb().dff();
                }
            }
            NoteEditorUI.this.fbD.postDelayed(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(27030);
                    c36356d.cpD();
                    AppMethodBeat.m2505o(27030);
                }
            }, 100);
            AppMethodBeat.m2505o(27031);
            return false;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public NoteEditorUI() {
        AppMethodBeat.m2504i(27053);
        AppMethodBeat.m2505o(27053);
    }

    /* renamed from: K */
    static /* synthetic */ boolean m22944K(NoteEditorUI noteEditorUI) {
        AppMethodBeat.m2504i(27108);
        boolean dfK = noteEditorUI.dfK();
        AppMethodBeat.m2505o(27108);
        return dfK;
    }

    /* renamed from: L */
    static /* synthetic */ void m22945L(NoteEditorUI noteEditorUI) {
        AppMethodBeat.m2504i(27109);
        noteEditorUI.goBack();
        AppMethodBeat.m2505o(27109);
    }

    /* renamed from: g */
    static /* synthetic */ void m22982g(NoteEditorUI noteEditorUI) {
        AppMethodBeat.m2504i(27106);
        noteEditorUI.bpD();
        AppMethodBeat.m2505o(27106);
    }

    /* renamed from: c */
    private boolean m22978c(C29979q c29979q) {
        if (c29979q == null) {
            return false;
        }
        if (c29979q.uOr != (this.uQI == 1)) {
            return false;
        }
        if ((this.uQI == 1 && c29979q.uOt == this.cvx) || (this.uQI == 2 && c29979q.uOs == this.fDy)) {
            return true;
        }
        return false;
    }

    public void onBackPressed() {
        AppMethodBeat.m2504i(27055);
        if (dfK()) {
            goBack();
            super.onBackPressed();
            AppMethodBeat.m2505o(27055);
            return;
        }
        AppMethodBeat.m2505o(27055);
    }

    public final int getLayoutId() {
        return 2130970314;
    }

    private boolean dfK() {
        AppMethodBeat.m2504i(27057);
        if (this.uSM == null || !this.uSM.uTV) {
            AppMethodBeat.m2505o(27057);
            return true;
        }
        ddY();
        AppMethodBeat.m2505o(27057);
        return false;
    }

    private void goBack() {
        AppMethodBeat.m2504i(27058);
        if (this.uQI == 2 && this.uSJ.uQJ) {
            if (!(this.uSQ || this.uMY)) {
                if (dfQ()) {
                    AppMethodBeat.m2505o(27058);
                    return;
                } else {
                    this.uSQ = true;
                    this.uSR = true;
                }
            }
            dfL();
            finish();
            AppMethodBeat.m2505o(27058);
            return;
        }
        AppMethodBeat.m2505o(27058);
    }

    public final void dfL() {
        AppMethodBeat.m2504i(27059);
        this.uSM.mo76175a((C40377a) this);
        String deu = C40380c.dem().deu();
        if (NoteEditorUI.ahr(deu)) {
            C37721gh c37721gh = new C37721gh();
            c37721gh.cAH.type = 12;
            c37721gh.cAH.cvv = this.fDy;
            C4879a.xxA.mo10055m(c37721gh);
            AppMethodBeat.m2505o(27059);
        } else if (this.uNq || this.uMY) {
            C4990ab.m7416i("MicroMsg.Note.NoteEditorUI", "leave noteeditorui, do savewnnotefavitem");
            ahp(deu);
            AppMethodBeat.m2505o(27059);
        } else {
            if (this.uSQ) {
                C4990ab.m7416i("MicroMsg.Note.NoteEditorUI", "leave noteeditorui, do updateWNNoteFavitem");
                ahq(deu);
            }
            AppMethodBeat.m2505o(27059);
        }
    }

    private void ahp(final String str) {
        AppMethodBeat.m2504i(27060);
        C9638aw.m17180RS().mo10302aa(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(27044);
                NoteEditorUI.this.mo27054i(str, true, false);
                AppMethodBeat.m2505o(27044);
            }
        });
        AppMethodBeat.m2505o(27060);
    }

    private void ahq(final String str) {
        AppMethodBeat.m2504i(27061);
        C9638aw.m17180RS().mo10302aa(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(27045);
                NoteEditorUI.this.mo27054i(str, false, false);
                AppMethodBeat.m2505o(27045);
            }
        });
        AppMethodBeat.m2505o(27061);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(27062);
        super.onDestroy();
        if (this.uTn) {
            if (this.aiB != null) {
                this.aiB.mo66348b(this.uTp);
            }
            C4675e dfb = C4675e.dfb();
            C4990ab.m7416i("NoteSelectManager", "onDestroy");
            C4675e.mHasInit = false;
            if (dfb.uRD != null) {
                dfb.uRD.stopTimer();
            }
            if (dfb.uRE != null) {
                dfb.uRE.stopTimer();
            }
            if (dfb.uRw != null) {
                dfb.uRw.dismiss();
            }
            if (dfb.uRx != null) {
                dfb.uRx.dismiss();
            }
            if (dfb.uRy != null) {
                dfb.uRy.dismiss();
            }
            if (dfb.uRz != null) {
                dfb.uRz.dismiss();
            }
            C4675e.uRg = null;
        }
        C9638aw.m17182Rg().mo14546b(921, (C1202f) this);
        if (this.uSJ != null) {
            C46457k c46457k = this.uSJ;
            c46457k.uQL.stopTimer();
            c46457k.uQB = -1;
            if (C46457k.uQx == c46457k) {
                C46457k.uQx = null;
            }
        }
        if (C46453c.ddG().uMN != null) {
            C46453c.ddG().uMN.uMT.clear();
            C46453c.ddG().uMN.uMS.clear();
            C46453c.ddG().uMN.uMR.clear();
        }
        C44019a dfY = C44019a.dfY();
        dfY.stopPlay();
        dfY.mfW = null;
        dfY.mfS = null;
        dfY.callbacks.clear();
        C44019a.uVh = null;
        if (C40371k.ddO() != null) {
            C40371k.ddO();
            C40371k.destroy();
        }
        C40380c dem = C40380c.dem();
        dem.uPa = null;
        if (dem.iPr != null) {
            Iterator it = dem.iPr.iterator();
            while (it.hasNext()) {
                C44001c c44001c = (C44001c) it.next();
                c44001c.uNY = null;
                c44001c.uNW = null;
                c44001c.uNX = null;
            }
        }
        AppMethodBeat.m2505o(27062);
    }

    public final void deh() {
        AppMethodBeat.m2504i(27063);
        if (this.uSM != null) {
            this.uSM.mo76175a(null);
        }
        AppMethodBeat.m2505o(27063);
    }

    /* renamed from: JX */
    public final void mo27023JX(final int i) {
        AppMethodBeat.m2504i(27064);
        Handler handler = getWindow().getDecorView().getHandler();
        if (handler == null) {
            AppMethodBeat.m2505o(27064);
            return;
        }
        handler.postDelayed(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(26995);
                C4990ab.m7417i("MicroMsg.Note.NoteEditorUI", "huahuastart: onNotifyItemChanged,position is %d", Integer.valueOf(i));
                NoteEditorUI.this.uSK.mo66316cg(i);
                C4990ab.m7417i("MicroMsg.Note.NoteEditorUI", "huahuaend: onNotifyItemChanged,position is %d", Integer.valueOf(i));
                AppMethodBeat.m2505o(26995);
            }
        }, 0);
        AppMethodBeat.m2505o(27064);
    }

    /* renamed from: JZ */
    public final void mo27025JZ(int i) {
        AppMethodBeat.m2504i(27065);
        try {
            this.uSK.mo66318ci(i);
            AppMethodBeat.m2505o(27065);
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.Note.NoteEditorUI", "onNotifyItemRemoved error,positionStart:%d", Integer.valueOf(i));
            AppMethodBeat.m2505o(27065);
        }
    }

    /* renamed from: JY */
    public final void mo27024JY(int i) {
        AppMethodBeat.m2504i(27066);
        try {
            this.uSK.mo66317ch(i);
            AppMethodBeat.m2505o(27066);
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.Note.NoteEditorUI", e, "", new Object[0]);
            C4990ab.m7413e("MicroMsg.Note.NoteEditorUI", "onNotifyItemInserted error,positionStart:%d", Integer.valueOf(i));
            AppMethodBeat.m2505o(27066);
        }
    }

    /* renamed from: gC */
    public final void mo27051gC(int i, int i2) {
        AppMethodBeat.m2504i(27067);
        try {
            this.uSK.mo66310at(i, i2);
            AppMethodBeat.m2505o(27067);
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.Note.NoteEditorUI", e, "", new Object[0]);
            C4990ab.m7413e("MicroMsg.Note.NoteEditorUI", "onNotifyitemRangeInsert error,positionStart:%d,count:%d", Integer.valueOf(i), Integer.valueOf(i2));
            AppMethodBeat.m2505o(27067);
        }
    }

    /* renamed from: gD */
    public final void mo27052gD(int i, int i2) {
        AppMethodBeat.m2504i(27068);
        try {
            this.uSK.mo66308ar(i, i2);
            AppMethodBeat.m2505o(27068);
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.Note.NoteEditorUI", "onNotifyItemRangeChanged error,positionStart:%d,count:%d", Integer.valueOf(i), Integer.valueOf(i2));
            AppMethodBeat.m2505o(27068);
        }
    }

    public final void dfM() {
        AppMethodBeat.m2504i(27069);
        try {
            this.uSK.aop.notifyChanged();
            AppMethodBeat.m2505o(27069);
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.Note.NoteEditorUI", e, "", new Object[0]);
            C4990ab.m7416i("MicroMsg.Note.NoteEditorUI", "onNotifyDataChanged error");
            AppMethodBeat.m2505o(27069);
        }
    }

    /* renamed from: oj */
    public final void mo27055oj(boolean z) {
        AppMethodBeat.m2504i(27070);
        C4990ab.m7417i("MicroMsg.Note.NoteEditorUI", "notifyNoteDataListFresh,force:%B", Boolean.valueOf(z));
        if (this.uSP || C46453c.ddG().uMN == null) {
            String str = "MicroMsg.Note.NoteEditorUI";
            String str2 = "notifyNoteDataListFresh,isInitDataList:%B,SubCoreWNNoteMsg.getCore().getWnNoteBase() == null :%B";
            Object[] objArr = new Object[2];
            objArr[0] = Boolean.valueOf(this.uSP);
            objArr[1] = Boolean.valueOf(C46453c.ddG().uMN == null);
            C4990ab.m7413e(str, str2, objArr);
            AppMethodBeat.m2505o(27070);
            return;
        }
        C4668w c4668w;
        if (this.uQI != 1) {
            C4990ab.m7416i("MicroMsg.Note.NoteEditorUI", "notifyNoteDataListFresh,open from fav");
            if (C46453c.ddG().uMN.uMQ == null) {
                C4990ab.m7412e("MicroMsg.Note.NoteEditorUI", "notifyNoteDataListFresh,SubCoreWNNoteMsg.getCore().getWnNoteBase().mClickedFavItemInfo == null ");
                AppMethodBeat.m2505o(27070);
                return;
            }
            c4668w = (C4668w) C46453c.ddG().uMN.uMR.get(Long.toString(C46453c.ddG().uMN.uMQ.field_localId));
        } else {
            C4990ab.m7416i("MicroMsg.Note.NoteEditorUI", "notifyNoteDataListFresh,open from Session");
            if (C46453c.ddG().uMN.uMP == null) {
                C4990ab.m7412e("MicroMsg.Note.NoteEditorUI", "notifyNoteDataListFresh,SubCoreWNNoteMsg.getCore().getWnNoteBase().mWNNoteData == null ");
                AppMethodBeat.m2505o(27070);
                return;
            }
            c4668w = (C4668w) C46453c.ddG().uMN.uMR.get(Long.toString(C46453c.ddG().uMN.uMP.cvx));
        }
        if (!(c4668w == null || this.uMY)) {
            this.uSY = c4668w.uOG;
            if (c4668w.uOG) {
                mo27030c(c4668w.uOF, false);
            } else {
                this.uSP = true;
                mo27030c(c4668w.uOF, true);
                AppMethodBeat.m2505o(27070);
                return;
            }
        }
        AppMethodBeat.m2505o(27070);
    }

    /* renamed from: c */
    public final synchronized void mo27030c(Object obj, final boolean z) {
        int th = 0;
        synchronized (this) {
            AppMethodBeat.m2504i(27071);
            C4990ab.m7417i("MicroMsg.Note.NoteEditorUI", "notifyNoteDataListFresh,setUpNoteData,canDismissLoadingDialog:%B", Boolean.valueOf(z));
            synchronized (this.uSZ) {
                int i;
                try {
                    C40380c.dem().den();
                    ArrayList arrayList = (ArrayList) obj;
                    if (arrayList == null) {
                        AppMethodBeat.m2505o(th);
                    } else {
                        C29978o c29978o;
                        C4990ab.m7416i("MicroMsg.Note.NoteEditorUI", "notifyNoteDataListFresh,setUpNoteData start");
                        if (this.uQI == 2 && !this.uTi) {
                            C44004m c44004m = C46453c.ddG().uMN.uMP;
                            if (c44004m == null) {
                                AppMethodBeat.m2505o(27071);
                            } else {
                                C44001c c23177e = new C23177e(c44004m.uOm);
                                c23177e.uNT = false;
                                c23177e.uNZ = false;
                                C40380c.dem().mo63757a(c23177e);
                            }
                        }
                        if (z) {
                            for (i = 0; i < arrayList.size(); i++) {
                                c29978o = (C29978o) arrayList.get(i);
                                if (c29978o.getType() == 20) {
                                    C44794b c44794b = (C44794b) c29978o;
                                    if (!this.uTi || !c44794b.qxI) {
                                        C40365i c40365i = new C40365i();
                                        c40365i.uOo = c44794b.uOo;
                                        c40365i.content = getString(C25738R.string.f9256ug) + " " + c44794b.uOC + IOUtils.LINE_SEPARATOR_UNIX;
                                        arrayList.set(i, c40365i);
                                    }
                                }
                            }
                        }
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            c29978o = (C29978o) it.next();
                            switch (c29978o.type) {
                                case -3:
                                case -2:
                                    break;
                                case -1:
                                    C40380c.dem().mo63757a((C31480h) c29978o);
                                    continue;
                                case 1:
                                    C44001c c44001c = (C40365i) c29978o;
                                    if (C5046bo.isNullOrNil(c44001c.content)) {
                                        c44001c.content = "";
                                    }
                                    c44001c.content = c44001c.content.replaceAll("<font", "<wx-font").replaceAll("<div", "<wx-div").replaceAll("<p", "<wx-p").replaceAll("</font>", "</wx-font>").replaceAll("<ul>", "<wx-ul>").replaceAll("</ul>", "</wx-ul>").replaceAll("<ol>", "<wx-ol>").replaceAll("</ol>", "</wx-ol>").replaceAll("<li>", "<wx-li>").replaceAll("</li>", "</wx-li>").replaceAll("<b>", "<wx-b>").replaceAll("</b>", "</wx-b>").replaceAll("</div>", "</wx-div>").replaceAll("</p>", "</wx-p>");
                                    if (c44001c.content.length() > 100) {
                                        C14724a.ahb(c44001c.content);
                                    } else if (C23176b.ahi(c44001c.content)) {
                                        c44001c.content = c44001c.content.substring(0, c44001c.content.length() - 5);
                                    }
                                    C40380c.dem().mo63757a(c44001c);
                                    continue;
                                case 2:
                                    C40380c.dem().mo63757a((C24930f) c29978o);
                                    continue;
                                case 3:
                                    C40380c.dem().mo63757a((C23178g) c29978o);
                                    continue;
                                case 4:
                                    C40380c.dem().mo63757a((C44003l) c29978o);
                                    continue;
                                case 5:
                                    break;
                                case 6:
                                    C40380c.dem().mo63757a((C40366k) c29978o);
                                    continue;
                                case 20:
                                    C40380c.dem().mo63757a((C44794b) c29978o);
                                    break;
                                default:
                                    C40380c.dem().mo63757a((C46451j) c29978o);
                                    continue;
                            }
                            C40380c.dem().mo63757a((C44002d) c29978o);
                        }
                        C4990ab.m7416i("MicroMsg.Note.NoteEditorUI", "notifyNoteDataListFresh,setUpNoteData finish");
                        if (!z) {
                            i = C40380c.dem();
                            synchronized (i) {
                                i.uPf = true;
                            }
                        }
                        C5004al.m7441d(new Runnable() {
                            public final void run() {
                                AppMethodBeat.m2504i(26996);
                                synchronized (NoteEditorUI.this.uSZ) {
                                    try {
                                        NoteEditorUI.this.dfM();
                                        NoteEditorUI.this.uSP = true;
                                        C4990ab.m7417i("MicroMsg.Note.NoteEditorUI", "postToMainThread,isInitDataList = true,canDismissLoadingDialog :%B,mHasFreshedDataByHtml:%B", Boolean.valueOf(z), Boolean.valueOf(NoteEditorUI.this.uSY));
                                        if (NoteEditorUI.this.lzK != null && z) {
                                            NoteEditorUI.this.lzK.dismiss();
                                        }
                                    } finally {
                                        while (true) {
                                        }
                                        AppMethodBeat.m2505o(26996);
                                    }
                                }
                            }
                        });
                        if (this.uTd > 0 || this.uTe != 0) {
                            this.fbD.postDelayed(new C46884(), 100);
                        }
                        C40380c.dem().des();
                        AppMethodBeat.m2505o(27071);
                    }
                } catch (Throwable th2) {
                    while (true) {
                        th = th2;
                        AppMethodBeat.m2505o(i);
                    }
                } finally {
                    i = 27071;
                    AppMethodBeat.m2505o(27071);
                }
            }
        }
    }

    public final RecyclerView dfN() {
        return this.aiB;
    }

    public final C40377a dfP() {
        return this;
    }

    static {
        AppMethodBeat.m2504i(27111);
        AppMethodBeat.m2505o(27111);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(27072);
        super.onActivityResult(i, i2, intent);
        C4990ab.m7417i("MicroMsg.Note.NoteEditorUI", "onActivityResult reqCode: %d, retCod: %d", Integer.valueOf(i), Integer.valueOf(i2));
        this.uTs = i;
        if (i2 != -1) {
            this.uTr = false;
            AppMethodBeat.m2505o(27072);
            return;
        }
        int i3;
        this.uTr = true;
        final String stringExtra;
        String str;
        Context context;
        C44001c c23178g;
        String stringExtra2;
        final C44275p b;
        C37721gh c37721gh;
        switch (i) {
            case 4096:
                stringExtra = intent == null ? null : intent.getStringExtra("Select_Conv_User");
                final String stringExtra3 = intent == null ? null : intent.getStringExtra("custom_send_text");
                if (!C5046bo.isNullOrNil(stringExtra)) {
                    C9638aw.m17190ZK();
                    final C7620bi jf = C18628c.m29080XO().mo15340jf(this.cvx);
                    if (jf.field_msgId == this.cvx) {
                        final C44275p b2 = C30379h.m48458b(this.mController.ylL, getString(C25738R.string.bp2), false, null);
                        C9638aw.m17180RS().mo10302aa(new Runnable() {

                            /* renamed from: com.tencent.mm.plugin.wenote.ui.nativenote.NoteEditorUI$6$1 */
                            class C147491 implements Runnable {
                                C147491() {
                                }

                                public final void run() {
                                    AppMethodBeat.m2504i(26999);
                                    b2.dismiss();
                                    C5670b.m8523i(NoteEditorUI.this, NoteEditorUI.this.getString(C25738R.string.bvk));
                                    AppMethodBeat.m2505o(26999);
                                }
                            }

                            public final void run() {
                                AppMethodBeat.m2504i(27000);
                                C18348nt c18348nt = new C18348nt();
                                c18348nt.cJY.type = 4;
                                c18348nt.cJY.cKd = jf;
                                c18348nt.cJY.toUser = stringExtra;
                                c18348nt.cJY.cAN = stringExtra3;
                                C4879a.xxA.mo10055m(c18348nt);
                                C5004al.m7441d(new C147491());
                                AppMethodBeat.m2505o(27000);
                            }

                            public final String toString() {
                                AppMethodBeat.m2504i(27001);
                                String str = super.toString() + "|onActivityResult";
                                AppMethodBeat.m2505o(27001);
                                return str;
                            }
                        });
                        i3 = 2;
                        break;
                    }
                    C4990ab.m7420w("MicroMsg.Note.NoteEditorUI", "want to send record msg, but message info is null");
                    AppMethodBeat.m2505o(27072);
                    return;
                }
                C4990ab.m7420w("MicroMsg.Note.NoteEditorUI", "want to send record msg, but toUser is null");
                AppMethodBeat.m2505o(27072);
                return;
            case 4097:
                C4990ab.m7416i("MicroMsg.Note.NoteEditorUI", "onActivityResult back from gallery");
                if (intent.getParcelableExtra("key_req_result") == null) {
                    i3 = 2;
                } else {
                    i3 = 1;
                }
                final ArrayList stringArrayListExtra = intent.getStringArrayListExtra("CropImage_OutputPath_List");
                if (stringArrayListExtra == null || stringArrayListExtra.size() <= 0) {
                    C4990ab.m7416i("MicroMsg.Note.NoteEditorUI", "no pic selected");
                } else {
                    C7060h.pYm.mo8381e(14547, Integer.valueOf(i3));
                    if (C40380c.dem().mo63776gF(0, stringArrayListExtra.size())) {
                        ddW();
                        i3 = 0;
                        break;
                    }
                    Context context2 = this.mController.ylL;
                    getString(C25738R.string.f9238tz);
                    this.ehJ = C30379h.m48458b(context2, getString(C25738R.string.f9260un), true, new C147698());
                    C9638aw.m17180RS().mo10302aa(new Runnable() {
                        public final void run() {
                            AppMethodBeat.m2504i(27004);
                            ArrayList arrayList = new ArrayList();
                            for (int i = 0; i < stringArrayListExtra.size(); i++) {
                                String str = (String) stringArrayListExtra.get(i);
                                C24930f c24930f = new C24930f();
                                c24930f.uOp = true;
                                c24930f.type = 2;
                                c24930f.uOo = C40380c.dem().des();
                                c24930f.mnd = C14719f.agW(c24930f.toString());
                                NoteEditorUI.this.uSX = new aar();
                                NoteEditorUI.this.uSX.akU(c24930f.mnd);
                                c24930f.uOq = C29977c.m47431hs(str, C14719f.m22910o(NoteEditorUI.this.uSX));
                                c24930f.cHg = C29977c.m47432ht(c24930f.uOq, C14719f.m22907c(NoteEditorUI.this.uSX));
                                arrayList.add(c24930f);
                            }
                            if (NoteEditorUI.this.ehJ == null || !NoteEditorUI.this.ehJ.isShowing()) {
                                C4990ab.m7416i("MicroMsg.Note.NoteEditorUI", "user canceled");
                                AppMethodBeat.m2505o(27004);
                                return;
                            }
                            C40380c.dem().mo63754a(arrayList, NoteEditorUI.this.uSJ.deW(), true, false, true, false);
                            NoteEditorUI.this.mo27050g(true, 100);
                            NoteEditorUI.this.mo27029af(1, 0);
                            AppMethodBeat.m2505o(27004);
                        }
                    });
                }
                stringArrayListExtra = intent.getStringArrayListExtra("key_select_video_list");
                String stringExtra4 = intent.getStringExtra("K_SEGMENTVIDEOPATH");
                if (!C5046bo.isNullOrNil(stringExtra4) && stringArrayListExtra == null) {
                    stringArrayListExtra = new ArrayList();
                    stringArrayListExtra.add(stringExtra4);
                }
                if (stringArrayListExtra != null && stringArrayListExtra.size() > 0) {
                    C7060h.pYm.mo8381e(14547, Integer.valueOf(i3));
                    if (!C40380c.dem().mo63776gF(0, stringArrayListExtra.size())) {
                        str = (String) stringArrayListExtra.get(0);
                        C43528a WR = C21846d.m33388WR(str);
                        if (WR != null) {
                            int ckU = WR.ckU();
                            final C40366k c40366k = new C40366k();
                            c40366k.uOp = true;
                            c40366k.thumbPath = "";
                            c40366k.cHg = "";
                            c40366k.duration = ckU;
                            c40366k.type = 6;
                            c40366k.uOo = C40380c.dem().des();
                            c40366k.uOf = C5730e.m8630cv(str);
                            c40366k.mnd = C14719f.agW(c40366k.toString());
                            this.uSX = new aar();
                            this.uSX.akU(c40366k.mnd);
                            this.uSX.akR(c40366k.uOf);
                            stringExtra4 = C14719f.m22907c(this.uSX);
                            stringExtra = C14719f.m22910o(this.uSX);
                            if (!C5046bo.isNullOrNil(str)) {
                                C4990ab.m7419v("MicroMsg.Note.NoteEditorUI", "compressNoteVideo path: %s", str);
                                stringArrayListExtra = new ArrayList();
                                stringArrayListExtra.add(str);
                                final C29986d c29986d = new C29986d(stringArrayListExtra, stringExtra4, stringExtra, c40366k, new C1475114());
                                context = this.mController.ylL;
                                getString(C25738R.string.f9238tz);
                                this.ehJ = C30379h.m48458b(context, getString(C25738R.string.f9260un), true, new OnCancelListener() {
                                    public final void onCancel(DialogInterface dialogInterface) {
                                        AppMethodBeat.m2504i(27011);
                                        C29986d c29986d = c29986d;
                                        c29986d.isStop = true;
                                        c29986d.interrupt();
                                        c40366k.uOg = true;
                                        NoteEditorUI.this.mo27050g(true, 100);
                                        NoteEditorUI.this.mo27029af(1, 0);
                                        AppMethodBeat.m2505o(27011);
                                    }
                                });
                                C7305d.post(c29986d, "NoteEditor_importVideo");
                                i3 = 0;
                                break;
                            }
                            C4990ab.m7412e("MicroMsg.Note.NoteEditorUI", "video is null");
                            i3 = 0;
                            break;
                        }
                        C4990ab.m7413e("MicroMsg.Note.NoteEditorUI", "mediaInfo is null, videoPath is %s", C5046bo.nullAsNil(str));
                        i3 = 0;
                        break;
                    }
                    ddW();
                    i3 = 0;
                    break;
                }
                C4990ab.m7416i("MicroMsg.Note.NoteEditorUI", "no video selected");
                i3 = 0;
                break;
                break;
            case 4098:
                C7060h.pYm.mo8381e(14547, Integer.valueOf(4));
                if (!C40380c.dem().mo63776gF(0, 1)) {
                    c23178g = new C23178g();
                    c23178g.lat = (double) ((float) intent.getDoubleExtra("kwebmap_slat", 0.0d));
                    c23178g.lng = (double) ((float) intent.getDoubleExtra("kwebmap_lng", 0.0d));
                    c23178g.scale = (double) intent.getIntExtra("kwebmap_scale", 0);
                    c23178g.fBg = C5046bo.m7532bc(intent.getStringExtra("Kwebmap_locaion"), "");
                    c23178g.eUu = intent.getStringExtra("kPoiName");
                    c23178g.uOo = C40380c.dem().des();
                    c23178g.type = 3;
                    c23178g.uOp = true;
                    c23178g.cHg = "";
                    C40380c.dem().mo63752a(c23178g, this.uSJ.deW(), false, false, false);
                    i3 = 0;
                    break;
                }
                ddW();
                i3 = 0;
                break;
            case 4099:
                C7060h.pYm.mo8381e(14547, Integer.valueOf(5));
                str = intent.getStringExtra("choosed_file_path");
                if (!C5046bo.isNullOrNil(str)) {
                    C5728b c5728b = new C5728b(str);
                    if (c5728b.exists()) {
                        if (c5728b.length() < mky) {
                            if (!C40380c.dem().mo63776gF(0, 1)) {
                                if (this.ehJ != null) {
                                    this.ehJ.dismiss();
                                    this.ehJ = null;
                                }
                                context = this.mController.ylL;
                                getString(C25738R.string.f9238tz);
                                this.ehJ = C30379h.m48458b(context, getString(C25738R.string.f9260un), true, new C1477010());
                                c23178g = new C44002d();
                                c23178g.title = c5728b.getName();
                                c23178g.content = C14719f.m22905aC((float) c5728b.length());
                                c23178g.hNN = C29980h.aha(C5730e.m8630cv(str));
                                c23178g.uOo = C40380c.dem().des();
                                c23178g.type = 5;
                                c23178g.uOp = true;
                                c23178g.uOf = C5730e.m8630cv(str);
                                c23178g.mnd = C14719f.agW(c23178g.toString());
                                this.uSX = new aar();
                                this.uSX.akU(c23178g.mnd);
                                this.uSX.akR(c23178g.uOf);
                                c23178g.cHg = C14719f.m22910o(this.uSX);
                                C5730e.m8644y(str, c23178g.cHg);
                                C40380c.dem().mo63752a(c23178g, this.uSJ.deW(), false, true, false);
                                i3 = 2;
                                break;
                            }
                            ddW();
                            i3 = 2;
                            break;
                        }
                        i3 = 3;
                        break;
                    }
                    i3 = 1;
                    break;
                }
                i3 = 1;
                break;
            case 4101:
                stringExtra2 = intent == null ? null : intent.getStringExtra("Select_Conv_User");
                if (intent == null) {
                    str = null;
                } else {
                    str = intent.getStringExtra("custom_send_text");
                }
                if (!C5046bo.isNullOrNil(stringExtra2)) {
                    b = C30379h.m48458b(this.mController.ylL, getString(C25738R.string.bp2), false, null);
                    c37721gh = new C37721gh();
                    c37721gh.cAH.type = 13;
                    c37721gh.cAH.context = this.mController.ylL;
                    c37721gh.cAH.toUser = stringExtra2;
                    c37721gh.cAH.cAN = str;
                    c37721gh.cAH.cvv = this.fDy;
                    c37721gh.cAH.cAM = new Runnable() {
                        public final void run() {
                            AppMethodBeat.m2504i(27002);
                            b.dismiss();
                            C5670b.m8523i(NoteEditorUI.this, NoteEditorUI.this.getString(C25738R.string.bvk));
                            AppMethodBeat.m2505o(27002);
                        }
                    };
                    C4879a.xxA.mo10055m(c37721gh);
                    i3 = 2;
                    break;
                }
                C4990ab.m7420w("MicroMsg.Note.NoteEditorUI", "want to send record msg, but toUser is null");
                AppMethodBeat.m2505o(27072);
                return;
            case 4354:
                this.fbD.post(new C1477111());
                i3 = 2;
                break;
            case 4355:
                stringExtra2 = intent == null ? null : intent.getStringExtra("Select_Conv_User");
                if (intent == null) {
                    str = null;
                } else {
                    str = intent.getStringExtra("custom_send_text");
                }
                if (!C5046bo.isNullOrNil(stringExtra2)) {
                    b = C30379h.m48458b(this.mController.ylL, getString(C25738R.string.bp2), false, null);
                    c37721gh = new C37721gh();
                    c37721gh.cAH.type = 13;
                    c37721gh.cAH.context = this.mController.ylL;
                    c37721gh.cAH.toUser = stringExtra2;
                    c37721gh.cAH.cAN = str;
                    c37721gh.cAH.cvv = this.fDy;
                    c37721gh.cAH.cvC = C46453c.ddG().uMN.uMZ;
                    c37721gh.cAH.cAM = new Runnable() {
                        public final void run() {
                            AppMethodBeat.m2504i(27008);
                            b.dismiss();
                            C5670b.m8523i(NoteEditorUI.this, NoteEditorUI.this.getString(C25738R.string.bvk));
                            AppMethodBeat.m2505o(27008);
                        }
                    };
                    C4879a.xxA.mo10055m(c37721gh);
                    i3 = 2;
                    break;
                }
                C4990ab.m7420w("MicroMsg.Note.NoteEditorUI", "want to send note from sns, but toUser is null");
                AppMethodBeat.m2505o(27072);
                return;
            case 30764:
                Bundle bundleExtra = intent.getBundleExtra("result_data");
                if (bundleExtra != null && bundleExtra.getString("go_next", "").equals("gdpr_auth_location")) {
                    C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_GDPR_LOCATION_PERMISSION_DESCRIBE_CONFIRM_BOOLEAN_SYNC, Boolean.TRUE);
                    C35805b.m58709b(this.mController.ylL, "android.permission.ACCESS_COARSE_LOCATION", 64);
                    break;
                }
        }
        i3 = 2;
        if (i3 == 0) {
            AppMethodBeat.m2505o(27072);
        } else if (1 == i3) {
            C30379h.m48465bQ(this.mController.ylL, getString(C25738R.string.bog));
            AppMethodBeat.m2505o(27072);
        } else {
            if (3 == i3) {
                Toast.makeText(this.mController.ylL, getString(C25738R.string.bs4), 1).show();
            }
            AppMethodBeat.m2505o(27072);
        }
    }

    /* renamed from: i */
    public final void mo27054i(String str, boolean z, boolean z2) {
        AppMethodBeat.m2504i(27073);
        C4990ab.m7417i("MicroMsg.Note.NoteEditorUI", "setEditorExportLogic,htmlstr:%s,isInsert:%B", str, Boolean.valueOf(z));
        if (z || !str.equals(this.uSS)) {
            abf ahe = C40380c.dem().ahe(str);
            if (ahe == null) {
                C4990ab.m7412e("MicroMsg.Note.NoteEditorUI", "protoitem is null,return");
                AppMethodBeat.m2505o(27073);
                return;
            }
            C37721gh c37721gh;
            if (z) {
                c37721gh = new C37721gh();
                c37721gh.cAH.type = 19;
                c37721gh.cAH.cvC = ahe;
                c37721gh.cAH.title = str;
                c37721gh.cAH.cvv = this.fDy;
                c37721gh.cAH.desc = "fav_add_new_note";
                C4879a.xxA.mo10055m(c37721gh);
            } else {
                c37721gh = new C37721gh();
                c37721gh.cAH.type = 19;
                c37721gh.cAH.cvC = ahe;
                c37721gh.cAH.title = str;
                c37721gh.cAH.cvv = this.fDy;
                c37721gh.cAH.desc = "";
                if (this.uSR) {
                    c37721gh.cAH.cAO = -2;
                }
                C4879a.xxA.mo10055m(c37721gh);
            }
            C4990ab.m7416i("MicroMsg.Note.NoteEditorUI", "write html to file suc");
            int i = 20;
            int i2;
            if (z) {
                while (true) {
                    c37721gh = new C37721gh();
                    c37721gh.cAH.type = 30;
                    c37721gh.cAH.cAO = 6;
                    c37721gh.cAH.cvv = this.fDy;
                    C4879a.xxA.mo10055m(c37721gh);
                    if ((c37721gh.cAI.ret == 1 ? 1 : 0) != 0) {
                        this.uMY = false;
                        this.uNq = false;
                        this.uSQ = true;
                        C4990ab.m7416i("MicroMsg.Note.NoteEditorUI", "hasUploadToServer: insert");
                        break;
                    }
                    try {
                        Thread.sleep(1000);
                        if (!z2) {
                            break;
                        }
                        i2 = i - 1;
                        if (i <= 0) {
                            break;
                        }
                        i = i2;
                    } catch (InterruptedException e) {
                    }
                }
            } else {
                do {
                    i2 = i;
                    if (C39037b.m66395g(((C7604ae) C1720g.m3530M(C7604ae.class)).getFavItemInfoStorage().mo23693iE(this.fDy))) {
                        C4990ab.m7417i("MicroMsg.Note.NoteEditorUI", "hasUploadToServer: update, %s", Integer.valueOf(((C7604ae) C1720g.m3530M(C7604ae.class)).getFavItemInfoStorage().mo23693iE(this.fDy).field_itemStatus));
                        break;
                    }
                    try {
                        Thread.sleep(1000);
                        if (!z2) {
                            break;
                        }
                        i = i2 - 1;
                    } catch (InterruptedException e2) {
                    }
                } while (i2 > 0);
            }
            this.uSS = C40380c.dem().deu();
            C4990ab.m7416i("MicroMsg.Note.NoteEditorUI", "setEditorExportLogic end");
            AppMethodBeat.m2505o(27073);
            return;
        }
        if (!this.uTk && this.uSJ.uQF > 0 && !C5046bo.isNullOrNil(this.uSJ.uQG) && this.uSJ.uQH > 0) {
            C37721gh c37721gh2 = new C37721gh();
            c37721gh2.cAH.type = 19;
            c37721gh2.cAH.cAO = -3;
            c37721gh2.cAH.cvv = this.fDy;
            Intent intent = new Intent();
            intent.putExtra("fav_note_item_status", this.uSJ.uQF);
            intent.putExtra("fav_note_xml", this.uSJ.uQG);
            intent.putExtra("fav_note_item_updatetime", this.uSJ.uQH);
            c37721gh2.cAH.cAK = intent;
            C4879a.xxA.mo10055m(c37721gh2);
        }
        AppMethodBeat.m2505o(27073);
    }

    static boolean ahr(String str) {
        AppMethodBeat.m2504i(27074);
        if (C5046bo.isNullOrNil(C23176b.ahj(str))) {
            AppMethodBeat.m2505o(27074);
            return true;
        }
        AppMethodBeat.m2505o(27074);
        return false;
    }

    public void onResume() {
        AppMethodBeat.m2504i(27075);
        super.onResume();
        if (this.uQI == 2) {
            switch (this.uTs) {
                case -1:
                    if (this.uTt) {
                        mo27050g(true, 100);
                        mo27029af(1, 0);
                        break;
                    }
                    break;
                case 4097:
                    if (!this.uTr) {
                        mo27050g(true, 100);
                        mo27029af(1, 0);
                        break;
                    }
                    break;
                case 4098:
                case 4099:
                    mo27050g(true, 100);
                    mo27029af(1, 0);
                    break;
            }
        }
        this.uTs = -1;
        this.uTr = false;
        AppMethodBeat.m2505o(27075);
    }

    public void onPause() {
        AppMethodBeat.m2504i(27076);
        super.onPause();
        if (this.uSM != null) {
            this.uSM.mo76175a((C40377a) this);
        }
        if (C44019a.dfY().buH()) {
            C44019a.dfY().stopPlay();
        }
        this.uTt = this.uSV;
        mo27050g(false, 0);
        C29979q deI = C14738h.deH().deI();
        if (m22978c(deI)) {
            deI.uOu = C40380c.dem().ahf(getString(C25738R.string.g16));
            deI.uOw = this.aaF;
            deI.uOx = this.uTc;
            C14738h.deH().mo27009a(deI);
        }
        AppMethodBeat.m2505o(27076);
    }

    public void onDrag() {
        AppMethodBeat.m2504i(27077);
        super.onDrag();
        if (this.uTn) {
            C4675e.dfb().dfj();
            C4675e.dfb().dfh();
        }
        AppMethodBeat.m2505o(27077);
    }

    public void onCancel() {
        AppMethodBeat.m2504i(27078);
        super.onCancel();
        if (this.uTn) {
            C4675e.dfb().mo9794oq(false);
            C4675e.dfb().mo9793op(false);
        }
        AppMethodBeat.m2505o(27078);
    }

    public final void ddZ() {
        AppMethodBeat.m2504i(27079);
        C30379h.m48466d(this, getString(C25738R.string.d82), "", getString(C25738R.string.d81), getString(C25738R.string.d80), new C1477217(), null);
        AppMethodBeat.m2505o(27079);
    }

    public final int dec() {
        AppMethodBeat.m2504i(27081);
        if (this.uSV) {
            int gp = C40619x.m70070gp(this);
            AppMethodBeat.m2505o(27081);
            return gp;
        }
        AppMethodBeat.m2505o(27081);
        return 0;
    }

    public final int ded() {
        AppMethodBeat.m2504i(27082);
        int i = 0;
        if (this.uSL != null && this.uSL.getVisibility() == 0) {
            i = this.uTo + 0;
        }
        if (this.uTa != null && this.uTa.getVisibility() == 0) {
            i += this.uTo;
        }
        AppMethodBeat.m2505o(27082);
        return i;
    }

    public final boolean dee() {
        AppMethodBeat.m2504i(27083);
        if (this.uSJ == null || this.uSJ.deS() == null) {
            AppMethodBeat.m2505o(27083);
            return false;
        }
        AppMethodBeat.m2505o(27083);
        return true;
    }

    public final RecyclerView def() {
        return this.aiB;
    }

    public final void deb() {
        AppMethodBeat.m2504i(27084);
        if (this.uQI == 2 && this.uSJ.uQJ) {
            int deo = C40380c.dem().deo();
            C44001c Ke = C40380c.dem().mo63750Ke(deo);
            if (Ke != null) {
                Ke.uNT = false;
                Ke.uNZ = false;
                mo27023JX(deo);
            }
            this.fbD.post(new C1476618());
            mo27050g(false, 0);
            mo27029af(0, 0);
            AppMethodBeat.m2505o(27084);
            return;
        }
        AppMethodBeat.m2505o(27084);
    }

    /* renamed from: a */
    public final void mo27028a(WXRTEditText wXRTEditText, boolean z, int i) {
        AppMethodBeat.m2504i(27085);
        if (this.uQI == 2 && this.uSJ.uQJ) {
            ((C29994a) this.aiB.getLayoutManager()).uUg = z;
            if (this.uSU) {
                ((C29994a) this.aiB.getLayoutManager()).uUg = false;
            }
            if (z) {
                if (!(this.uMY || this.uSQ)) {
                    this.uSS = C40380c.dem().deu();
                    this.uSQ = true;
                }
                if (wXRTEditText == null || wXRTEditText.getEditTextType() != 1) {
                    C40380c.dem().mo63764aw(i, false);
                    AppMethodBeat.m2505o(27085);
                    return;
                }
                C40380c.dem().mo63764aw(i, true);
                AppMethodBeat.m2505o(27085);
                return;
            }
            C40380c.dem().mo63763av(-1, false);
            AppMethodBeat.m2505o(27085);
            return;
        }
        AppMethodBeat.m2505o(27085);
    }

    public final void deg() {
        AppMethodBeat.m2504i(27086);
        if (!(this.uMY || this.uSQ)) {
            this.uSS = C40380c.dem().deu();
            this.uSQ = true;
        }
        AppMethodBeat.m2505o(27086);
    }

    public final void onKeyboardStateChanged() {
        AppMethodBeat.m2504i(27087);
        super.onKeyboardStateChanged();
        this.uSV = this.mController.ymc == 1;
        if (this.uSV) {
            mo27029af(1, 0);
        }
        if (this.uTn) {
            this.fbD.postDelayed(new C1476219(), 200);
        }
        AppMethodBeat.m2505o(27087);
    }

    /* renamed from: g */
    public final void mo27050g(final boolean z, long j) {
        AppMethodBeat.m2504i(27088);
        if (this.uQI == 2 && this.uSJ.uQJ) {
            this.fbD.postDelayed(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(27016);
                    if (!z || NoteEditorUI.this.uSV) {
                        if (!z && NoteEditorUI.this.uSV) {
                            NoteEditorUI.this.aqX();
                        }
                        AppMethodBeat.m2505o(27016);
                        return;
                    }
                    NoteEditorUI.this.showVKB();
                    AppMethodBeat.m2505o(27016);
                }
            }, j);
            AppMethodBeat.m2505o(27088);
            return;
        }
        AppMethodBeat.m2505o(27088);
    }

    /* renamed from: af */
    public final void mo27029af(final int i, long j) {
        AppMethodBeat.m2504i(27089);
        if (this.uQI == 2 && this.uSJ.uQJ) {
            this.fbD.postDelayed(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(27017);
                    ImageButton imageButton = (ImageButton) NoteEditorUI.this.uSL.findViewById(2131826374);
                    View findViewById = NoteEditorUI.this.uSL.findViewById(2131826375);
                    switch (i) {
                        case 0:
                            NoteEditorUI.this.uTa.setVisibility(8);
                            if (NoteEditorUI.this.uSM.uTV) {
                                NoteEditorUI.this.uSL.setVisibility(0);
                                AppMethodBeat.m2505o(27017);
                                return;
                            }
                            NoteEditorUI.this.uSL.setVisibility(8);
                            AppMethodBeat.m2505o(27017);
                            return;
                        case 1:
                            imageButton.setImageResource(C1318a.note_style_unpress);
                            findViewById.setVisibility(8);
                            NoteEditorUI.this.uSL.setVisibility(0);
                            NoteEditorUI.this.uTa.setVisibility(8);
                            AppMethodBeat.m2505o(27017);
                            return;
                        case 2:
                            NoteEditorUI.this.uSL.setVisibility(0);
                            NoteEditorUI.this.uTa.setVisibility(8);
                            AppMethodBeat.m2505o(27017);
                            return;
                        case 3:
                            imageButton.setImageResource(C1318a.note_style_press);
                            findViewById.setVisibility(0);
                            NoteEditorUI.this.uSL.setVisibility(0);
                            NoteEditorUI.this.uTa.setVisibility(0);
                            break;
                    }
                    AppMethodBeat.m2505o(27017);
                }
            }, j);
            AppMethodBeat.m2505o(27089);
            return;
        }
        AppMethodBeat.m2505o(27089);
    }

    public final void ddU() {
        AppMethodBeat.m2504i(27090);
        if (!this.uSM.uTV) {
            deb();
            final AppCompatActivity appCompatActivity = this.mController.ylL;
            this.fbD.postDelayed(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(27018);
                    int size = C40380c.dem().size();
                    int childCount = NoteEditorUI.this.aiB.getChildCount();
                    if (size == childCount) {
                        size = childCount - 1;
                        float f = 0.0f;
                        int i = size;
                        while (i >= 0) {
                            View childAt = NoteEditorUI.this.aiB.getChildAt(i);
                            float Y = C0477s.m898Y(childAt);
                            i--;
                            f = f > ((float) childAt.getBottom()) + Y ? f : ((float) childAt.getBottom()) + Y;
                        }
                        if (f < ((float) C40619x.m70068db(appCompatActivity)[1]) && f > 0.0f) {
                            LayoutParams layoutParams = (LayoutParams) NoteEditorUI.this.uSN.getLayoutParams();
                            layoutParams.height = (int) f;
                            NoteEditorUI.this.uSN.setLayoutParams(layoutParams);
                        }
                    }
                    NoteEditorUI.this.uSN.setVisibility(0);
                    if (NoteEditorUI.this.uSO != null) {
                        C14734g a = NoteEditorUI.this.uSO;
                        int[] iArr = new int[]{0, 0};
                        a.mParentView.getLocationOnScreen(iArr);
                        a.uPB.showAtLocation(a.mParentView, 49, 0, iArr[1] + 50);
                    }
                    AppMethodBeat.m2505o(27018);
                }
            }, 400);
        }
        AppMethodBeat.m2505o(27090);
    }

    /* renamed from: a */
    public final void mo27027a(WXRTEditText wXRTEditText) {
        AppMethodBeat.m2504i(27091);
        if (wXRTEditText != null) {
            boolean z;
            if (C29989f.iLD == null || C29989f.iLD.size() <= 0) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                ArrayList deA = C29989f.deA();
                if (C40380c.dem().mo63758af(deA)) {
                    ddW();
                    AppMethodBeat.m2505o(27091);
                    return;
                }
                C40380c.dem().mo63754a(deA, wXRTEditText, true, true, false, false);
                int recyclerItemPosition = wXRTEditText.getRecyclerItemPosition();
                C40380c.dem().mo63777gG(recyclerItemPosition, (deA.size() + recyclerItemPosition) + 1);
                deb();
                if (this.uTn) {
                    C4675e.dfb().dff();
                }
                AppMethodBeat.m2505o(27091);
                return;
            }
        }
        AppMethodBeat.m2505o(27091);
    }

    public final void deG() {
        AppMethodBeat.m2504i(27092);
        int deC = C29989f.deC();
        if (deC == 2) {
            if (C29989f.deB()) {
                ddW();
                AppMethodBeat.m2505o(27092);
                return;
            }
            C40380c.dem().den();
            C29989f.clearData();
            C44001c c40365i = new C40365i();
            c40365i.content = "";
            c40365i.uNT = false;
            c40365i.uNZ = false;
            c40365i.uNV = 0;
            c40365i.uOb = true;
            C40380c.dem().mo63757a(c40365i);
            dfM();
            AppMethodBeat.m2505o(27092);
        } else if (deC == 3) {
            ArrayList deA = C29989f.deA();
            if (C40380c.dem().mo63758af(deA)) {
                ddW();
                AppMethodBeat.m2505o(27092);
                return;
            }
            C40380c.dem().den();
            C40380c.dem().mo63754a(deA, null, false, false, false, false);
            deb();
            AppMethodBeat.m2505o(27092);
        } else {
            AppMethodBeat.m2505o(27092);
        }
    }

    public final void deD() {
        AppMethodBeat.m2504i(27093);
        C44001c c40365i = new C40365i();
        c40365i.content = "";
        c40365i.uNT = true;
        c40365i.uNZ = false;
        c40365i.uNV = 0;
        C40380c.dem().den();
        C40380c.dem().mo63757a(c40365i);
        dfM();
        mo27050g(true, 50);
        mo27029af(1, 0);
        AppMethodBeat.m2505o(27093);
    }

    /* renamed from: gE */
    public final void mo27053gE(int i, int i2) {
        AppMethodBeat.m2504i(27096);
        this.uSU = Math.abs(i2 - i) > 0;
        AppMethodBeat.m2505o(27096);
    }

    /* renamed from: Ka */
    public final void mo27026Ka(final int i) {
        AppMethodBeat.m2504i(27097);
        if (i < 0 || i >= C40380c.dem().size()) {
            AppMethodBeat.m2505o(27097);
            return;
        }
        this.fbD.post(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(27032);
                NoteEditorUI.this.aiB.mo61465bY(i);
                AppMethodBeat.m2505o(27032);
            }
        });
        AppMethodBeat.m2505o(27097);
    }

    public final void ddV() {
        AppMethodBeat.m2504i(27098);
        this.fbD.post(new C1475325());
        AppMethodBeat.m2505o(27098);
    }

    public final void ddW() {
        AppMethodBeat.m2504i(27099);
        if (this.uMY || this.uSQ) {
            deb();
            if (this.uTn) {
                C4675e.dfb().dff();
            }
            this.fbD.postDelayed(new C1475426(), 100);
        }
        AppMethodBeat.m2505o(27099);
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        AppMethodBeat.m2504i(27100);
        if (iArr == null || iArr.length <= 0) {
            C4990ab.m7417i("MicroMsg.Note.NoteEditorUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", Integer.valueOf(i), Long.valueOf(Thread.currentThread().getId()));
            AppMethodBeat.m2505o(27100);
            return;
        }
        C4990ab.m7417i("MicroMsg.Note.NoteEditorUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId()));
        switch (i) {
            case 64:
                if (C17950b.m28216sO((String) C1720g.m3536RP().mo5239Ry().get(274436, null)) && iArr[0] != 0) {
                    C30379h.m48445a(this.mController.ylL, getString(C25738R.string.dby), getString(C25738R.string.dc8), getString(C25738R.string.ckr), getString(C25738R.string.abx), false, new C1475527(), null);
                    break;
                }
            case 80:
                if (iArr[0] != 0) {
                    ddX();
                    AppMethodBeat.m2505o(27100);
                    return;
                }
                break;
        }
        AppMethodBeat.m2505o(27100);
    }

    public final void ddX() {
        AppMethodBeat.m2504i(27101);
        C30379h.m48445a((Context) this, getString(C25738R.string.dc0), getString(C25738R.string.dc8), getString(C25738R.string.ckr), getString(C25738R.string.abx), false, new C1475628(), new C1476029());
        AppMethodBeat.m2505o(27101);
    }

    private boolean dfQ() {
        AppMethodBeat.m2504i(27102);
        C37721gh c37721gh = new C37721gh();
        c37721gh.cAH.type = 19;
        c37721gh.cAH.cvv = this.fDy;
        c37721gh.cAH.cAO = -1;
        C4879a.xxA.mo10055m(c37721gh);
        if (c37721gh.cAI.cAY) {
            AppMethodBeat.m2505o(27102);
            return false;
        }
        AppMethodBeat.m2505o(27102);
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:108:0x032c A:{Splitter:B:72:0x023a, ExcHandler: Exception (r2_78 'e' java.lang.Exception)} */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing block: B:46:0x012b, code skipped:
            r3 = 0;
     */
    /* JADX WARNING: Missing block: B:47:0x012d, code skipped:
            if (r3 < r4) goto L_0x012f;
     */
    /* JADX WARNING: Missing block: B:48:0x012f, code skipped:
            r2 = (android.graphics.Bitmap) r7.get(java.lang.String.valueOf(r3));
     */
    /* JADX WARNING: Missing block: B:52:0x0141, code skipped:
            r2.recycle();
     */
    /* JADX WARNING: Missing block: B:53:0x0144, code skipped:
            r3 = r3 + 1;
     */
    /* JADX WARNING: Missing block: B:54:0x0148, code skipped:
            bpD();
            android.widget.Toast.makeText(r14.mController.ylL, r14.mController.ylL.getString(com.tencent.p177mm.C25738R.string.d87), 1).show();
     */
    /* JADX WARNING: Missing block: B:57:?, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(27103);
     */
    /* JADX WARNING: Missing block: B:93:?, code skipped:
            r3 = com.tencent.p177mm.plugin.report.service.C7060h.pYm;
            r5 = new java.lang.Object[5];
            r5[0] = java.lang.Integer.valueOf(0);
            r5[1] = java.lang.Integer.valueOf(0);
            r5[2] = java.lang.Integer.valueOf(0);
            r5[3] = java.lang.Integer.valueOf(2);
     */
    /* JADX WARNING: Missing block: B:94:0x02d7, code skipped:
            if (r14.uTi != false) goto L_0x02d9;
     */
    /* JADX WARNING: Missing block: B:95:0x02d9, code skipped:
            r2 = 1;
     */
    /* JADX WARNING: Missing block: B:96:0x02da, code skipped:
            r5[4] = java.lang.Integer.valueOf(r2);
            r3.mo8381e(14811, r5);
            com.tencent.p177mm.sdk.platformtools.C4990ab.m7412e("MicroMsg.Note.NoteEditorUI", "favorite, note, gen long pic , 565 error,errormsg is er:");
            bpD();
            android.widget.Toast.makeText(r14.mController.ylL, r14.mController.ylL.getString(com.tencent.p177mm.C25738R.string.d87), 1).show();
            r3 = 0;
     */
    /* JADX WARNING: Missing block: B:97:0x0308, code skipped:
            if (r3 < r6) goto L_0x030a;
     */
    /* JADX WARNING: Missing block: B:98:0x030a, code skipped:
            r2 = (android.graphics.Bitmap) r7.get(java.lang.String.valueOf(r3));
     */
    /* JADX WARNING: Missing block: B:102:0x031c, code skipped:
            r2.recycle();
     */
    /* JADX WARNING: Missing block: B:103:0x031f, code skipped:
            r3 = r3 + 1;
     */
    /* JADX WARNING: Missing block: B:104:0x0323, code skipped:
            r2 = 0;
     */
    /* JADX WARNING: Missing block: B:107:?, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(27103);
     */
    /* JADX WARNING: Missing block: B:108:0x032c, code skipped:
            r2 = move-exception;
     */
    /* JADX WARNING: Missing block: B:110:?, code skipped:
            com.tencent.p177mm.sdk.platformtools.C4990ab.m7412e("MicroMsg.Note.NoteEditorUI", "genlongpic fail,error msg Exception");
            com.tencent.p177mm.sdk.platformtools.C4990ab.printErrStackTrace("MicroMsg.Note.NoteEditorUI", r2, "", new java.lang.Object[0]);
            bpD();
            android.widget.Toast.makeText(r14.mController.ylL, r14.mController.ylL.getString(com.tencent.p177mm.C25738R.string.d87), 1).show();
            r3 = com.tencent.p177mm.plugin.report.service.C7060h.pYm;
            r5 = new java.lang.Object[5];
            r5[0] = java.lang.Integer.valueOf(0);
            r5[1] = java.lang.Integer.valueOf(0);
            r5[2] = java.lang.Integer.valueOf(0);
            r5[3] = java.lang.Integer.valueOf(1);
     */
    /* JADX WARNING: Missing block: B:111:0x0386, code skipped:
            if (r14.uTi != false) goto L_0x0388;
     */
    /* JADX WARNING: Missing block: B:112:0x0388, code skipped:
            r2 = 1;
     */
    /* JADX WARNING: Missing block: B:113:0x0389, code skipped:
            r5[4] = java.lang.Integer.valueOf(r2);
            r3.mo8381e(14811, r5);
     */
    /* JADX WARNING: Missing block: B:116:?, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(27103);
     */
    /* JADX WARNING: Missing block: B:117:0x0399, code skipped:
            r2 = 0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(27103);
        if (c1207m.getType() != 921) {
            AppMethodBeat.m2505o(27103);
        } else if (c1207m instanceof C40368b) {
            C40368b c40368b = (C40368b) c1207m;
            if (c40368b.uMF != 1) {
                AppMethodBeat.m2505o(27103);
            } else {
                C7060h c7060h;
                Object[] objArr;
                if (i2 == 0) {
                    C4990ab.m7416i("MicroMsg.Note.NoteEditorUI", "genlong pic , allow");
                    C41523a adapter = this.aiB.getAdapter();
                    if (adapter != null) {
                        int itemCount = adapter.getItemCount();
                        if (itemCount <= 0) {
                            bpD();
                            Toast.makeText(this.mController.ylL, this.mController.ylL.getString(C25738R.string.d87), 1).show();
                            c7060h = C7060h.pYm;
                            objArr = new Object[5];
                            objArr[0] = Integer.valueOf(0);
                            objArr[1] = Integer.valueOf(0);
                            objArr[2] = Integer.valueOf(0);
                            objArr[3] = Integer.valueOf(1);
                            objArr[4] = Integer.valueOf(this.uTi ? 1 : 0);
                            c7060h.mo8381e(14811, objArr);
                            AppMethodBeat.m2505o(27103);
                        } else {
                            int i3 = 0;
                            try {
                                int width;
                                Bitmap createBitmap;
                                C26399b c26399b = new C26399b(((int) (Runtime.getRuntime().maxMemory() / 1024)) / 8, getClass());
                                int i4 = 0;
                                while (i4 < itemCount) {
                                    C41531v c = adapter.mo66314c(this.aiB, adapter.getItemViewType(i4));
                                    adapter.mo4977a(c, i4);
                                    c.apJ.measure(MeasureSpec.makeMeasureSpec(this.aiB.getWidth(), ErrorDialogData.SUPPRESSED), MeasureSpec.makeMeasureSpec(0, 0));
                                    c.apJ.layout(0, 0, c.apJ.getMeasuredWidth(), c.apJ.getMeasuredHeight());
                                    width = c.apJ.getWidth();
                                    int height = c.apJ.getHeight();
                                    if (width > 0 && height > 0) {
                                        Bitmap createBitmap2 = Bitmap.createBitmap(width, height, Config.ARGB_8888);
                                        try {
                                            c.apJ.draw(new Canvas(createBitmap2));
                                        } catch (Exception e) {
                                            bpD();
                                            Toast.makeText(this.mController.ylL, this.mController.ylL.getString(C25738R.string.d87), 1).show();
                                            C7060h c7060h2 = C7060h.pYm;
                                            Object[] objArr2 = new Object[5];
                                            objArr2[0] = Integer.valueOf(0);
                                            objArr2[1] = Integer.valueOf(0);
                                            objArr2[2] = Integer.valueOf(0);
                                            objArr2[3] = Integer.valueOf(1);
                                            if (this.uTi) {
                                                width = 1;
                                            } else {
                                                width = 0;
                                            }
                                            objArr2[4] = Integer.valueOf(width);
                                            c7060h2.mo8381e(14811, objArr2);
                                        } catch (Throwable th) {
                                            C4990ab.m7412e("MicroMsg.Note.NoteEditorUI", "genlongpic fail,Throwable error msg throw");
                                            bpD();
                                            Toast.makeText(this.mController.ylL, this.mController.ylL.getString(C25738R.string.d87), 1).show();
                                            c7060h = C7060h.pYm;
                                            objArr = new Object[5];
                                            objArr[0] = Integer.valueOf(0);
                                            objArr[1] = Integer.valueOf(0);
                                            objArr[2] = Integer.valueOf(0);
                                            objArr[3] = Integer.valueOf(2);
                                            if (this.uTi) {
                                                i3 = 1;
                                            } else {
                                                i3 = 0;
                                            }
                                            objArr[4] = Integer.valueOf(i3);
                                            c7060h.mo8381e(14811, objArr);
                                        }
                                        try {
                                            c26399b.put(String.valueOf(i4), createBitmap2);
                                            i3 += c.apJ.getMeasuredHeight();
                                        } catch (Exception e2) {
                                        } catch (Throwable th2) {
                                            C4990ab.m7412e("MicroMsg.Note.NoteEditorUI", "genlongpic fail,Throwable error msg throw");
                                            bpD();
                                            Toast.makeText(this.mController.ylL, this.mController.ylL.getString(C25738R.string.d87), 1).show();
                                            c7060h = C7060h.pYm;
                                            objArr = new Object[5];
                                            objArr[0] = Integer.valueOf(0);
                                            objArr[1] = Integer.valueOf(0);
                                            objArr[2] = Integer.valueOf(0);
                                            objArr[3] = Integer.valueOf(2);
                                            if (this.uTi) {
                                                i3 = 1;
                                            } else {
                                                i3 = 0;
                                            }
                                            objArr[4] = Integer.valueOf(i3);
                                            c7060h.mo8381e(14811, objArr);
                                        }
                                    }
                                    i4++;
                                }
                                try {
                                    width = C1338a.fromDPToPix(this.mController.ylL, 14);
                                    createBitmap = Bitmap.createBitmap(this.aiB.getMeasuredWidth() + 0, i3 + width, Config.ARGB_8888);
                                } catch (Exception e22) {
                                } catch (Throwable th3) {
                                    C4990ab.m7412e("MicroMsg.Note.NoteEditorUI", "favorite, note, gen long pic ,rgb 888  error,errormsg ");
                                    createBitmap = Bitmap.createBitmap(this.aiB.getMeasuredWidth() + 0, i3 + width, Config.RGB_565);
                                }
                                Canvas canvas = new Canvas(createBitmap);
                                canvas.drawColor(-1);
                                width = C1338a.fromDPToPix(this.mController.ylL, 8);
                                i4 = 0;
                                while (i4 < itemCount) {
                                    Bitmap bitmap = (Bitmap) c26399b.get(String.valueOf(i4));
                                    if (bitmap != null) {
                                        canvas.drawBitmap(bitmap, 0.0f, (float) width, null);
                                        width += bitmap.getHeight();
                                        if (!bitmap.isRecycled()) {
                                            bitmap.recycle();
                                        }
                                    }
                                    i4++;
                                    width = width;
                                }
                                if (this.lzK != null && this.lzK.isShowing()) {
                                    bpD();
                                    Toast.makeText(this.mController.ylL, this.mController.ylL.getString(C25738R.string.b3r, new Object[]{C40612a.dlz()}), 1).show();
                                    C9638aw.m17180RS().mo10302aa(new Runnable() {
                                        public final void run() {
                                            AppMethodBeat.m2504i(27038);
                                            C29980h.m47436a(NoteEditorUI.this.mController.ylL, createBitmap, NoteEditorUI.this.uTi);
                                            AppMethodBeat.m2505o(27038);
                                        }
                                    });
                                } else if (createBitmap != null) {
                                    if (!createBitmap.isRecycled()) {
                                        createBitmap.recycle();
                                    }
                                }
                            } catch (Exception e3) {
                                C4990ab.m7412e("MicroMsg.Note.NoteEditorUI", "genlongpic fail,Exception error msg a");
                                bpD();
                                Toast.makeText(this.mController.ylL, this.mController.ylL.getString(C25738R.string.d87), 1).show();
                                c7060h = C7060h.pYm;
                                objArr = new Object[5];
                                objArr[0] = Integer.valueOf(0);
                                objArr[1] = Integer.valueOf(0);
                                objArr[2] = Integer.valueOf(0);
                                objArr[3] = Integer.valueOf(2);
                                if (this.uTi) {
                                    i3 = 1;
                                } else {
                                    i3 = 0;
                                }
                                objArr[4] = Integer.valueOf(i3);
                                c7060h.mo8381e(14811, objArr);
                            } catch (Throwable th22) {
                                C4990ab.m7412e("MicroMsg.Note.NoteEditorUI", "genlongpic fail,Throwable error msg throw");
                                bpD();
                                Toast.makeText(this.mController.ylL, this.mController.ylL.getString(C25738R.string.d87), 1).show();
                                c7060h = C7060h.pYm;
                                objArr = new Object[5];
                                objArr[0] = Integer.valueOf(0);
                                objArr[1] = Integer.valueOf(0);
                                objArr[2] = Integer.valueOf(0);
                                objArr[3] = Integer.valueOf(2);
                                if (this.uTi) {
                                    i3 = 1;
                                } else {
                                    i3 = 0;
                                }
                                objArr[4] = Integer.valueOf(i3);
                                c7060h.mo8381e(14811, objArr);
                            }
                        }
                    } else {
                        c7060h = C7060h.pYm;
                        objArr = new Object[5];
                        objArr[0] = Integer.valueOf(0);
                        objArr[1] = Integer.valueOf(0);
                        objArr[2] = Integer.valueOf(0);
                        objArr[3] = Integer.valueOf(1);
                        objArr[4] = Integer.valueOf(this.uTi ? 1 : 0);
                        c7060h.mo8381e(14811, objArr);
                        bpD();
                        Toast.makeText(this.mController.ylL, this.mController.ylL.getString(C25738R.string.d87), 1).show();
                    }
                } else {
                    c7060h = C7060h.pYm;
                    objArr = new Object[5];
                    objArr[0] = Integer.valueOf(0);
                    objArr[1] = Integer.valueOf(0);
                    objArr[2] = Integer.valueOf(0);
                    objArr[3] = Integer.valueOf(4);
                    objArr[4] = Integer.valueOf(this.uTi ? 1 : 0);
                    c7060h.mo8381e(14811, objArr);
                    C4990ab.m7412e("MicroMsg.Note.NoteEditorUI", "genlong pic , not allow");
                    bpD();
                    Toast.makeText(this.mController.ylL, this.mController.ylL.getString(C25738R.string.d87), 1).show();
                }
                this.uSJ.uQI = c40368b.uMJ;
                C40380c.dem().mo63762au(C40380c.dem().size() - 1, false);
                AppMethodBeat.m2505o(27103);
            }
        } else {
            AppMethodBeat.m2505o(27103);
        }
        return;
    }

    private void bpD() {
        AppMethodBeat.m2504i(27104);
        if (this.lzK != null) {
            this.lzK.dismiss();
            this.lzK = null;
        }
        AppMethodBeat.m2505o(27104);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(27054);
        this.ylm = true;
        this.uQI = getIntent().getIntExtra("note_open_from_scene", 2);
        this.cvx = getIntent().getLongExtra("note_msgid", -1);
        this.uTl = getIntent().getBooleanExtra("record_show_share", false);
        this.fDy = getIntent().getLongExtra("note_fav_localid", -1);
        this.lsy = getIntent().getStringExtra("note_link_sns_localid");
        this.uMY = getIntent().getBooleanExtra("edit_status", false);
        this.uNq = getIntent().getBooleanExtra("need_save", false);
        this.uSQ = this.uNq;
        this.uTb = getIntent().getStringExtra("fav_note_xml");
        this.uTd = getIntent().getIntExtra("fav_note_scroll_to_position", 0);
        this.uTe = getIntent().getIntExtra("fav_note_scroll_to_offset", 0);
        this.lZg = getIntent().getStringExtra("fav_note_thumbpath");
        this.uTg = getIntent().getBooleanExtra("show_share", true);
        this.uTj = getIntent().getStringExtra("fav_note_link_sns_xml");
        String stringExtra = getIntent().getStringExtra("fav_note_link_source_info");
        this.uTm = getIntent().getBooleanExtra("fav_note_out_of_date", false);
        if (!C5046bo.isNullOrNil(stringExtra)) {
            this.uTf = stringExtra.split(";");
        }
        if (getIntent().getIntExtra("note_fav_post_scene", 0) == 6) {
            this.uTi = true;
        }
        C40369d.uNa = false;
        if (this.uTf == null && this.fDy > 0) {
            C37721gh c37721gh = new C37721gh();
            c37721gh.cAH.type = 30;
            c37721gh.cAH.cAO = 3;
            c37721gh.cAH.cvv = this.fDy;
            C4879a.xxA.mo10055m(c37721gh);
            this.uTf = C5046bo.isNullOrNil(c37721gh.cAI.path) ? null : c37721gh.cAI.path.split(";");
        }
        if (this.uTf == null || this.uTf.length >= 3) {
            this.fbD = new C7306ak();
            C40380c dem = C40380c.dem();
            dem.iPr = new ArrayList();
            dem.uPa = this;
            dem.uPb = new aar();
            dem.uPc = 0;
            dem.uPd = 0;
            dem.uPe = 0;
            C4990ab.m7416i("MicroMsg.Note.NoteEditorUI", "OnCreate MainActivity, before setContentView");
            C30036f.m47544m(this);
            super.onCreate(bundle);
            mo54745iL(this.fDy);
            C4990ab.m7416i("MicroMsg.Note.NoteEditorUI", "OnCreate MainActivity, after setContentView");
            C44001c c40365i = new C40365i();
            c40365i.content = "";
            c40365i.uNT = true;
            c40365i.uNZ = false;
            if (this.uMY) {
                C40380c.dem().mo63757a(c40365i);
                this.uTi = true;
            }
            this.f2964WL = this.mController.contentView;
            this.f2964WL.getRootView().setBackgroundColor(-1);
            this.aiB = (RecyclerView) findViewById(2131826383);
            this.uSL = (LinearLayout) this.f2964WL.findViewById(2131826382);
            this.uSL.setVisibility(8);
            this.uTa = (LinearLayout) this.uSL.findViewById(2131826424);
            this.uTa.setVisibility(8);
            this.uSN = (RelativeLayout) findViewById(2131826384);
            this.uSN.setOnClickListener(new C147631());
            this.uSO = new C14734g(this, this.uSN);
            this.uSO.uPC = this;
            this.uST = new C29994a();
            this.uST.uUf = C40619x.m70068db(this)[1];
            this.aiB.setLayoutManager(this.uST);
            this.aiB.setHasFixedSize(true);
            this.uSW = new C14757a();
            this.aiB.mo66332a(this.uSW);
            this.uSJ = new C46457k(this);
            this.uSJ.cvv = this.fDy;
            this.uSJ.uQI = this.uQI;
            this.uSJ.uQJ = this.uTi;
            if (this.uNq) {
                C46457k c46457k = this.uSJ;
                if (c46457k.uQB < 0 && c46457k.cvv > 0) {
                    c46457k.uQL.mo16770ae(60000, 60000);
                    c46457k.uQB = C5046bo.m7588yz();
                    c46457k.uQC = "";
                }
            }
            this.uSK = new C29995c(this.uSJ);
            this.aiB.setAdapter(this.uSK);
            if (this.uQI == 2) {
                this.aiB.setOnTouchListener(this.uTq);
            }
            this.aiB.getItemAnimator().aot = 0;
            this.aiB.getItemAnimator().aow = 0;
            this.aiB.getItemAnimator().aov = 0;
            this.aiB.getItemAnimator().aou = 120;
            ((C17495av) this.aiB.getItemAnimator()).arN = false;
            this.uTo = C1338a.fromDPToPix(this, 48);
            if (this.uTn) {
                C4990ab.m7416i("MicroMsg.Note.NoteEditorUI", "use multiselect");
                boolean z = this.uQI == 2 && this.uTi;
                int color = getResources().getColor(C25738R.color.f12213w6);
                C4675e dfb = C4675e.dfb();
                C4990ab.m7416i("NoteSelectManager", "onInit start");
                dfb.uRh = z;
                dfb.uRk = 14;
                dfb.uRl = 32;
                dfb.uRm = C1338a.fromDPToPix(this, 21) - dfb.uRl;
                dfb.uRn = C1338a.fromDPToPix(this, 40) + (dfb.uRl * 2);
                dfb.uRo = C1338a.fromDPToPix(this, 240) + (dfb.uRl * 2);
                dfb.uRi = C1338a.fromDPToPix(this, 22);
                dfb.uRj = C1338a.fromDPToPix(this, 1);
                dfb.mScreenHeight = getResources().getDisplayMetrics().heightPixels;
                dfb.mScreenWidth = getResources().getDisplayMetrics().widthPixels;
                dfb.uRs = new int[]{-1, -1};
                dfb.uRt = new int[]{-1, -1};
                dfb.uRu = new int[]{-1, -1};
                dfb.uRv = new int[]{-1, -1};
                C40379a c40379a = new C40379a(this, 2, dfb.uRi, dfb.uRj, color, dfb);
                dfb.uRw = new PopupWindow(c40379a, c40379a.getViewWidth(), c40379a.getViewHeight(), false);
                dfb.uRw.setClippingEnabled(false);
                dfb.uRw.setAnimationStyle(C25738R.style.a07);
                dfb.uRq = c40379a.getOffsetForCursorMid();
                dfb.uRr = C1338a.fromDPToPix(this, 6);
                C40379a c40379a2 = new C40379a(this, 3, dfb.uRi, dfb.uRj, color, dfb);
                dfb.uRx = new PopupWindow(c40379a2, c40379a2.getViewWidth(), c40379a.getViewHeight(), false);
                dfb.uRx.setClippingEnabled(false);
                dfb.uRx.setAnimationStyle(C25738R.style.a06);
                c40379a2 = new C40379a(this, 4, dfb.uRi, dfb.uRj, color, dfb);
                dfb.uRy = new PopupWindow(c40379a2, c40379a2.getViewWidth(), c40379a.getViewHeight(), false);
                dfb.uRy.setClippingEnabled(false);
                dfb.uRy.setAnimationStyle(C25738R.style.a08);
                View inflate = LayoutInflater.from(this).inflate(2130970317, null);
                inflate.measure(MeasureSpec.makeMeasureSpec(0, 0), MeasureSpec.makeMeasureSpec(0, 0));
                dfb.uRz = new PopupWindow(inflate, -2, -2, false);
                dfb.uRz.setBackgroundDrawable(getResources().getDrawable(C25738R.drawable.bij));
                dfb.uRz.setClippingEnabled(false);
                dfb.uRz.setAnimationStyle(C25738R.style.a0_);
                dfb.uRF = (TextView) inflate.findViewById(2131826415);
                dfb.uRG = (TextView) inflate.findViewById(2131826416);
                dfb.uRH = (TextView) inflate.findViewById(2131826417);
                dfb.uRI = (TextView) inflate.findViewById(2131826418);
                dfb.uRJ = (TextView) inflate.findViewById(2131826422);
                dfb.uRK = (TextView) inflate.findViewById(2131826419);
                dfb.uRL = (TextView) inflate.findViewById(2131826420);
                dfb.uRM = (TextView) inflate.findViewById(2131826421);
                C4675e.m7030g(dfb.uRF, dfb.uRk);
                C4675e.m7030g(dfb.uRG, dfb.uRk);
                C4675e.m7030g(dfb.uRH, dfb.uRk);
                C4675e.m7030g(dfb.uRI, dfb.uRk);
                C4675e.m7030g(dfb.uRJ, dfb.uRk);
                C4675e.m7030g(dfb.uRK, dfb.uRk);
                C4675e.m7030g(dfb.uRL, dfb.uRk);
                C4675e.m7030g(dfb.uRM, dfb.uRk);
                dfb.uRF.setOnClickListener(new C467710());
                dfb.uRG.setOnClickListener(new C468311());
                dfb.uRH.setOnClickListener(new C468212());
                dfb.uRI.setOnClickListener(new C468413());
                dfb.uRJ.setOnClickListener(new C46792());
                dfb.uRK.setOnClickListener(new C46803());
                dfb.uRL.setOnClickListener(new C46714());
                dfb.uRM.setOnClickListener(new C46725());
                dfb.uRp = c40379a.getViewPadding();
                dfb.uRA = this;
                dfb.uRB = new C4670d();
                dfb.uRC = new C46456b();
                dfb.mHandler = new C7306ak();
                C4675e.mHasInit = true;
                C4990ab.m7416i("NoteSelectManager", "onInit end");
                this.uTp = new C1474433();
                this.aiB.mo66332a(this.uTp);
            }
            if (this.lzK != null) {
                this.lzK.dismiss();
                this.lzK = null;
            }
            if (!(this.uMY || this.uTm)) {
                this.lzK = C30379h.m48458b(this.mController.ylL, getString(C25738R.string.g2l), true, new C1475012());
            }
            if (this.uTm) {
                C4990ab.m7416i("MicroMsg.Note.NoteEditorUI", "open msg note,  out of date");
                C30379h.m48461b(this.mController.ylL, this.mController.ylL.getString(C25738R.string.d84), null, true);
            }
            if (this.uTg) {
                addIconOptionMenu(1, C25738R.string.ewm, C1318a.actionbar_icon_dark_more, new C1477523());
            }
            if (this.uTi) {
                setMMTitle(getString(C25738R.string.bsc));
            } else {
                setMMTitle(getString(C25738R.string.bsd));
            }
            mo17427pP(true);
            setBackBtn(new C1474131(), C1318a.actionbar_icon_dark_back);
            C30036f.m47545n(this);
            if (this.uMY) {
                mo27050g(true, 300);
                mo27029af(1, 0);
            }
            if (this.uQI == 2 && this.uTi) {
                this.uSM = new C46937c();
                C46937c c46937c = this.uSM;
                LinearLayout linearLayout = this.uSL;
                c46937c.gLe = linearLayout;
                C46457k.deT().uQD = c46937c;
                c46937c.uTL = (LinearLayout) linearLayout.findViewById(2131826424);
                c46937c.uTK = (ImageButton) linearLayout.findViewById(2131826374);
                c46937c.uTM = (ImageButton) linearLayout.findViewById(2131826370);
                c46937c.uTN = (ImageButton) linearLayout.findViewById(2131826369);
                c46937c.uTO = (ImageButton) linearLayout.findViewById(2131826368);
                c46937c.uTP = (ImageButton) linearLayout.findViewById(2131826371);
                c46937c.uTQ = (LinearLayout) c46937c.uTL.findViewById(2131826426);
                c46937c.uTR = (LinearLayout) c46937c.uTL.findViewById(2131826425);
                c46937c.uTS = (LinearLayout) c46937c.uTL.findViewById(2131826429);
                c46937c.uTT = (LinearLayout) c46937c.uTL.findViewById(2131826430);
                c46937c.uTU = (LinearLayout) c46937c.uTL.findViewById(2131826431);
                c46937c.uTK.setOnClickListener(new C464651(this));
                c46937c.uTO.setOnClickListener(new C300016(this));
                c46937c.uTP.setOnClickListener(new C231927(this, this));
                c46937c.uTM.setOnClickListener(new C231938(this));
                c46937c.uTN.setOnClickListener(new C300029(this));
                c46937c.uTU.setOnClickListener(new C1479510(this));
                c46937c.uTQ.setOnClickListener(new C3574911(this));
                c46937c.uTR.setOnClickListener(new C3575012(this));
                c46937c.uTS.setOnClickListener(new C4646413(this));
                c46937c.uTT.setOnClickListener(new C464662(this));
                getWindow().setSoftInputMode(18);
            } else {
                this.uSL.setVisibility(8);
            }
            this.aiB.getViewTreeObserver().addOnGlobalLayoutListener(this.aeL);
            this.uTh = System.currentTimeMillis();
            C4990ab.m7417i("MicroMsg.Note.NoteEditorUI", "startnoteeditorui, oncreate , currenttime is %d", Long.valueOf(this.uTh));
            C9638aw.m17182Rg().mo14539a(921, (C1202f) this);
            AppMethodBeat.m2505o(27054);
            return;
        }
        AppMethodBeat.m2505o(27054);
    }

    public final void ddY() {
        AppMethodBeat.m2504i(27056);
        C30379h.m48461b(this.mController.ylL, getString(C25738R.string.d88), null, true);
        AppMethodBeat.m2505o(27056);
    }

    public final Context dfO() {
        return this.mController.ylL;
    }

    public final void dea() {
        AppMethodBeat.m2504i(27080);
        Toast.makeText(this.mController.ylL, getString(C25738R.string.d85), 0).show();
        AppMethodBeat.m2505o(27080);
    }

    public final void deE() {
        AppMethodBeat.m2504i(27094);
        C29989f.m47465c(this.mController.ylL, C40380c.dem().dev());
        AppMethodBeat.m2505o(27094);
    }

    public final void deF() {
        AppMethodBeat.m2504i(27095);
        C29989f.m47465c(this.mController.ylL, C40380c.dem().dev());
        deD();
        AppMethodBeat.m2505o(27095);
    }

    /* renamed from: aa */
    static /* synthetic */ void m22967aa(NoteEditorUI noteEditorUI) {
        AppMethodBeat.m2504i(27110);
        C9638aw.m17180RS().mo10302aa(new C147475());
        AppMethodBeat.m2505o(27110);
    }
}
