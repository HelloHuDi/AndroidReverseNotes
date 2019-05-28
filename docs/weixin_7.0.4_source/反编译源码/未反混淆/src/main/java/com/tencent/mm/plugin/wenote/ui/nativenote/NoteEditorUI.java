package com.tencent.mm.plugin.wenote.ui.nativenote;

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
import android.support.v4.view.s;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.i;
import android.support.v7.widget.RecyclerView.m;
import android.support.v7.widget.RecyclerView.v;
import android.support.v7.widget.av;
import android.text.ClipboardManager;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
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
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.g.a.cl;
import com.tencent.mm.g.a.gh;
import com.tencent.mm.g.a.nt;
import com.tencent.mm.m.b;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.fav.a.ae;
import com.tencent.mm.plugin.fav.ui.detail.BaseFavDetailReportUI;
import com.tencent.mm.plugin.wenote.model.a.d;
import com.tencent.mm.plugin.wenote.model.a.h;
import com.tencent.mm.plugin.wenote.model.a.j;
import com.tencent.mm.plugin.wenote.model.a.l;
import com.tencent.mm.plugin.wenote.model.a.o;
import com.tencent.mm.plugin.wenote.model.a.q;
import com.tencent.mm.plugin.wenote.model.a.w;
import com.tencent.mm.plugin.wenote.model.nativenote.a.a;
import com.tencent.mm.plugin.wenote.model.nativenote.c.e;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.WXRTEditText;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.g;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.k;
import com.tencent.mm.plugin.wenote.ui.nativenote.a.c;
import com.tencent.mm.protocal.protobuf.aar;
import com.tencent.mm.protocal.protobuf.abf;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.p;
import com.tencent.ttpic.baseutils.IOUtils;
import java.util.ArrayList;
import java.util.Iterator;

public class NoteEditorUI extends BaseFavDetailReportUI implements f, com.tencent.mm.plugin.wenote.model.nativenote.b.a, com.tencent.mm.plugin.wenote.model.nativenote.manager.g.a, a {
    private static final long mky = ((long) b.Nc());
    private View WL = null;
    private int aaF = 0;
    OnGlobalLayoutListener aeL = new OnGlobalLayoutListener() {
        public final void onGlobalLayout() {
            AppMethodBeat.i(27041);
            long currentTimeMillis = System.currentTimeMillis();
            ab.i("MicroMsg.Note.NoteEditorUI", "startnoteeditorui, onGlobalLayout, current time is %d,from oncreate to dataloading, cost %d", Long.valueOf(currentTimeMillis), Long.valueOf(currentTimeMillis - NoteEditorUI.this.uTh));
            al RS = aw.RS();
            AnonymousClass1 anonymousClass1 = new Runnable() {
                public final void run() {
                    AppMethodBeat.i(27040);
                    NoteEditorUI.this.oj(false);
                    AppMethodBeat.o(27040);
                }
            };
            if (NoteEditorUI.this.uQI == 1) {
                currentTimeMillis = 100;
            } else {
                currentTimeMillis = 0;
            }
            RS.m(anonymousClass1, currentTimeMillis);
            NoteEditorUI.this.aiB.getViewTreeObserver().removeGlobalOnLayoutListener(NoteEditorUI.this.aeL);
            AppMethodBeat.o(27041);
        }
    };
    private RecyclerView aiB;
    private long cvx = -1;
    private ProgressDialog ehJ = null;
    long fDy = -1;
    private ak fbD;
    private float hkg = 0.0f;
    private float hkh = 0.0f;
    private String lZg;
    private String lsy = "";
    private p lzK = null;
    protected com.tencent.mm.ui.widget.snackbar.a.b mUw = new com.tencent.mm.ui.widget.snackbar.a.b() {
        public final void aIu() {
            AppMethodBeat.i(27012);
            gh ghVar = new gh();
            ghVar.cAH.type = 35;
            com.tencent.mm.sdk.b.a.xxA.m(ghVar);
            AppMethodBeat.o(27012);
        }
    };
    boolean uMY = false;
    boolean uNq = false;
    private int uQI;
    private k uSJ;
    private c uSK;
    private LinearLayout uSL;
    private c uSM = null;
    private RelativeLayout uSN = null;
    private g uSO = null;
    private boolean uSP = false;
    boolean uSQ = false;
    private boolean uSR = false;
    private String uSS = "";
    private com.tencent.mm.plugin.wenote.ui.nativenote.a.a uST;
    private boolean uSU = false;
    private boolean uSV = false;
    private a uSW;
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
    private m uTp = null;
    OnTouchListener uTq = new OnTouchListener() {
        public final boolean onTouch(View view, MotionEvent motionEvent) {
            AppMethodBeat.i(27047);
            if (motionEvent.getAction() == 0) {
                NoteEditorUI.this.hkg = motionEvent.getX();
                NoteEditorUI.this.hkh = motionEvent.getY();
            }
            float abs;
            float abs2;
            if (motionEvent.getAction() == 1 && NoteEditorUI.this.aiB.x(motionEvent.getX(), motionEvent.getY()) == null) {
                abs = Math.abs(NoteEditorUI.this.hkg - motionEvent.getX());
                abs2 = Math.abs(NoteEditorUI.this.hkh - motionEvent.getY());
                if (abs < 30.0f && abs2 < 30.0f) {
                    if (NoteEditorUI.this.uSN.getVisibility() != 8) {
                        if (NoteEditorUI.this.uSO != null) {
                            NoteEditorUI.this.uSO.uPB.dismiss();
                        }
                        NoteEditorUI.this.uSN.setVisibility(8);
                    } else {
                        int size = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.dem().size();
                        com.tencent.mm.plugin.wenote.model.a.c Ke = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.dem().Ke(size - 1);
                        if (Ke != null) {
                            boolean z = Ke.uNT;
                            com.tencent.mm.plugin.wenote.model.nativenote.manager.c.dem().dep();
                            Ke.uNT = true;
                            Ke.uNZ = false;
                            Ke.uNV = -1;
                            NoteEditorUI.this.uSK.cg(size - 1);
                            NoteEditorUI.this.g(true, 50);
                            NoteEditorUI.this.af(1, 0);
                            if (NoteEditorUI.this.uTn && z) {
                                NoteEditorUI.this.fbD.postDelayed(new Runnable() {
                                    public final void run() {
                                        AppMethodBeat.i(27046);
                                        e.dfb().oq(true);
                                        e.dfb().op(true);
                                        AppMethodBeat.o(27046);
                                    }
                                }, 100);
                            }
                        }
                    }
                }
            } else if (motionEvent.getAction() == 2) {
                abs = Math.abs(NoteEditorUI.this.hkg - motionEvent.getX());
                abs2 = Math.abs(NoteEditorUI.this.hkh - motionEvent.getY());
                if (abs > 120.0f || abs2 > 120.0f) {
                    if (NoteEditorUI.this.uTn) {
                        if (e.dfb().dfa() == 1) {
                            NoteEditorUI.this.deb();
                            e.dfb().dff();
                        }
                    } else if (!NoteEditorUI.this.uSU) {
                        NoteEditorUI.this.deb();
                    }
                }
            }
            AppMethodBeat.o(27047);
            return false;
        }
    };
    private boolean uTr = false;
    private int uTs = -1;
    private boolean uTt = false;

    class a extends com.tencent.mm.plugin.wenote.ui.nativenote.a.b {
        a() {
        }

        public final void dfS() {
            AppMethodBeat.i(27048);
            NoteEditorUI.aa(NoteEditorUI.this);
            AppMethodBeat.o(27048);
        }

        public final void dfT() {
            AppMethodBeat.i(27049);
            NoteEditorUI.this.dyc();
            NoteEditorUI.aa(NoteEditorUI.this);
            AppMethodBeat.o(27049);
        }

        public final void dfU() {
            AppMethodBeat.i(27050);
            NoteEditorUI.this.dyb();
            AppMethodBeat.o(27050);
        }

        public final void dfV() {
            AppMethodBeat.i(27051);
            NoteEditorUI.this.mlz.mfe = true;
            AppMethodBeat.o(27051);
        }

        public final void c(RecyclerView recyclerView, int i) {
            AppMethodBeat.i(27052);
            super.c(recyclerView, i);
            if (recyclerView.getLayoutManager() != null) {
                View childAt = ((LinearLayoutManager) NoteEditorUI.this.aiB.getLayoutManager()).getChildAt(0);
                if (childAt != null) {
                    NoteEditorUI.this.uTc = childAt.getTop();
                    NoteEditorUI.this.aaF = i.bt(childAt);
                }
            }
            AppMethodBeat.o(27052);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public NoteEditorUI() {
        AppMethodBeat.i(27053);
        AppMethodBeat.o(27053);
    }

    static /* synthetic */ boolean K(NoteEditorUI noteEditorUI) {
        AppMethodBeat.i(27108);
        boolean dfK = noteEditorUI.dfK();
        AppMethodBeat.o(27108);
        return dfK;
    }

    static /* synthetic */ void L(NoteEditorUI noteEditorUI) {
        AppMethodBeat.i(27109);
        noteEditorUI.goBack();
        AppMethodBeat.o(27109);
    }

    static /* synthetic */ void g(NoteEditorUI noteEditorUI) {
        AppMethodBeat.i(27106);
        noteEditorUI.bpD();
        AppMethodBeat.o(27106);
    }

    private boolean c(q qVar) {
        if (qVar == null) {
            return false;
        }
        if (qVar.uOr != (this.uQI == 1)) {
            return false;
        }
        if ((this.uQI == 1 && qVar.uOt == this.cvx) || (this.uQI == 2 && qVar.uOs == this.fDy)) {
            return true;
        }
        return false;
    }

    public void onBackPressed() {
        AppMethodBeat.i(27055);
        if (dfK()) {
            goBack();
            super.onBackPressed();
            AppMethodBeat.o(27055);
            return;
        }
        AppMethodBeat.o(27055);
    }

    public final int getLayoutId() {
        return R.layout.aj6;
    }

    private boolean dfK() {
        AppMethodBeat.i(27057);
        if (this.uSM == null || !this.uSM.uTV) {
            AppMethodBeat.o(27057);
            return true;
        }
        ddY();
        AppMethodBeat.o(27057);
        return false;
    }

    private void goBack() {
        AppMethodBeat.i(27058);
        if (this.uQI == 2 && this.uSJ.uQJ) {
            if (!(this.uSQ || this.uMY)) {
                if (dfQ()) {
                    AppMethodBeat.o(27058);
                    return;
                } else {
                    this.uSQ = true;
                    this.uSR = true;
                }
            }
            dfL();
            finish();
            AppMethodBeat.o(27058);
            return;
        }
        AppMethodBeat.o(27058);
    }

    public final void dfL() {
        AppMethodBeat.i(27059);
        this.uSM.a((com.tencent.mm.plugin.wenote.model.nativenote.b.a) this);
        String deu = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.dem().deu();
        if (ahr(deu)) {
            gh ghVar = new gh();
            ghVar.cAH.type = 12;
            ghVar.cAH.cvv = this.fDy;
            com.tencent.mm.sdk.b.a.xxA.m(ghVar);
            AppMethodBeat.o(27059);
        } else if (this.uNq || this.uMY) {
            ab.i("MicroMsg.Note.NoteEditorUI", "leave noteeditorui, do savewnnotefavitem");
            ahp(deu);
            AppMethodBeat.o(27059);
        } else {
            if (this.uSQ) {
                ab.i("MicroMsg.Note.NoteEditorUI", "leave noteeditorui, do updateWNNoteFavitem");
                ahq(deu);
            }
            AppMethodBeat.o(27059);
        }
    }

    private void ahp(final String str) {
        AppMethodBeat.i(27060);
        aw.RS().aa(new Runnable() {
            public final void run() {
                AppMethodBeat.i(27044);
                NoteEditorUI.this.i(str, true, false);
                AppMethodBeat.o(27044);
            }
        });
        AppMethodBeat.o(27060);
    }

    private void ahq(final String str) {
        AppMethodBeat.i(27061);
        aw.RS().aa(new Runnable() {
            public final void run() {
                AppMethodBeat.i(27045);
                NoteEditorUI.this.i(str, false, false);
                AppMethodBeat.o(27045);
            }
        });
        AppMethodBeat.o(27061);
    }

    public void onDestroy() {
        AppMethodBeat.i(27062);
        super.onDestroy();
        if (this.uTn) {
            if (this.aiB != null) {
                this.aiB.b(this.uTp);
            }
            e dfb = e.dfb();
            ab.i("NoteSelectManager", "onDestroy");
            e.mHasInit = false;
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
            e.uRg = null;
        }
        aw.Rg().b(921, (f) this);
        if (this.uSJ != null) {
            k kVar = this.uSJ;
            kVar.uQL.stopTimer();
            kVar.uQB = -1;
            if (k.uQx == kVar) {
                k.uQx = null;
            }
        }
        if (com.tencent.mm.plugin.wenote.model.c.ddG().uMN != null) {
            com.tencent.mm.plugin.wenote.model.c.ddG().uMN.uMT.clear();
            com.tencent.mm.plugin.wenote.model.c.ddG().uMN.uMS.clear();
            com.tencent.mm.plugin.wenote.model.c.ddG().uMN.uMR.clear();
        }
        com.tencent.mm.plugin.wenote.ui.nativenote.voiceview.a dfY = com.tencent.mm.plugin.wenote.ui.nativenote.voiceview.a.dfY();
        dfY.stopPlay();
        dfY.mfW = null;
        dfY.mfS = null;
        dfY.callbacks.clear();
        com.tencent.mm.plugin.wenote.ui.nativenote.voiceview.a.uVh = null;
        if (com.tencent.mm.plugin.wenote.model.k.ddO() != null) {
            com.tencent.mm.plugin.wenote.model.k.ddO();
            com.tencent.mm.plugin.wenote.model.k.destroy();
        }
        com.tencent.mm.plugin.wenote.model.nativenote.manager.c dem = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.dem();
        dem.uPa = null;
        if (dem.iPr != null) {
            Iterator it = dem.iPr.iterator();
            while (it.hasNext()) {
                com.tencent.mm.plugin.wenote.model.a.c cVar = (com.tencent.mm.plugin.wenote.model.a.c) it.next();
                cVar.uNY = null;
                cVar.uNW = null;
                cVar.uNX = null;
            }
        }
        AppMethodBeat.o(27062);
    }

    public final void deh() {
        AppMethodBeat.i(27063);
        if (this.uSM != null) {
            this.uSM.a(null);
        }
        AppMethodBeat.o(27063);
    }

    public final void JX(final int i) {
        AppMethodBeat.i(27064);
        Handler handler = getWindow().getDecorView().getHandler();
        if (handler == null) {
            AppMethodBeat.o(27064);
            return;
        }
        handler.postDelayed(new Runnable() {
            public final void run() {
                AppMethodBeat.i(26995);
                ab.i("MicroMsg.Note.NoteEditorUI", "huahuastart: onNotifyItemChanged,position is %d", Integer.valueOf(i));
                NoteEditorUI.this.uSK.cg(i);
                ab.i("MicroMsg.Note.NoteEditorUI", "huahuaend: onNotifyItemChanged,position is %d", Integer.valueOf(i));
                AppMethodBeat.o(26995);
            }
        }, 0);
        AppMethodBeat.o(27064);
    }

    public final void JZ(int i) {
        AppMethodBeat.i(27065);
        try {
            this.uSK.ci(i);
            AppMethodBeat.o(27065);
        } catch (Exception e) {
            ab.e("MicroMsg.Note.NoteEditorUI", "onNotifyItemRemoved error,positionStart:%d", Integer.valueOf(i));
            AppMethodBeat.o(27065);
        }
    }

    public final void JY(int i) {
        AppMethodBeat.i(27066);
        try {
            this.uSK.ch(i);
            AppMethodBeat.o(27066);
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.Note.NoteEditorUI", e, "", new Object[0]);
            ab.e("MicroMsg.Note.NoteEditorUI", "onNotifyItemInserted error,positionStart:%d", Integer.valueOf(i));
            AppMethodBeat.o(27066);
        }
    }

    public final void gC(int i, int i2) {
        AppMethodBeat.i(27067);
        try {
            this.uSK.at(i, i2);
            AppMethodBeat.o(27067);
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.Note.NoteEditorUI", e, "", new Object[0]);
            ab.e("MicroMsg.Note.NoteEditorUI", "onNotifyitemRangeInsert error,positionStart:%d,count:%d", Integer.valueOf(i), Integer.valueOf(i2));
            AppMethodBeat.o(27067);
        }
    }

    public final void gD(int i, int i2) {
        AppMethodBeat.i(27068);
        try {
            this.uSK.ar(i, i2);
            AppMethodBeat.o(27068);
        } catch (Exception e) {
            ab.e("MicroMsg.Note.NoteEditorUI", "onNotifyItemRangeChanged error,positionStart:%d,count:%d", Integer.valueOf(i), Integer.valueOf(i2));
            AppMethodBeat.o(27068);
        }
    }

    public final void dfM() {
        AppMethodBeat.i(27069);
        try {
            this.uSK.aop.notifyChanged();
            AppMethodBeat.o(27069);
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.Note.NoteEditorUI", e, "", new Object[0]);
            ab.i("MicroMsg.Note.NoteEditorUI", "onNotifyDataChanged error");
            AppMethodBeat.o(27069);
        }
    }

    public final void oj(boolean z) {
        AppMethodBeat.i(27070);
        ab.i("MicroMsg.Note.NoteEditorUI", "notifyNoteDataListFresh,force:%B", Boolean.valueOf(z));
        if (this.uSP || com.tencent.mm.plugin.wenote.model.c.ddG().uMN == null) {
            String str = "MicroMsg.Note.NoteEditorUI";
            String str2 = "notifyNoteDataListFresh,isInitDataList:%B,SubCoreWNNoteMsg.getCore().getWnNoteBase() == null :%B";
            Object[] objArr = new Object[2];
            objArr[0] = Boolean.valueOf(this.uSP);
            objArr[1] = Boolean.valueOf(com.tencent.mm.plugin.wenote.model.c.ddG().uMN == null);
            ab.e(str, str2, objArr);
            AppMethodBeat.o(27070);
            return;
        }
        w wVar;
        if (this.uQI != 1) {
            ab.i("MicroMsg.Note.NoteEditorUI", "notifyNoteDataListFresh,open from fav");
            if (com.tencent.mm.plugin.wenote.model.c.ddG().uMN.uMQ == null) {
                ab.e("MicroMsg.Note.NoteEditorUI", "notifyNoteDataListFresh,SubCoreWNNoteMsg.getCore().getWnNoteBase().mClickedFavItemInfo == null ");
                AppMethodBeat.o(27070);
                return;
            }
            wVar = (w) com.tencent.mm.plugin.wenote.model.c.ddG().uMN.uMR.get(Long.toString(com.tencent.mm.plugin.wenote.model.c.ddG().uMN.uMQ.field_localId));
        } else {
            ab.i("MicroMsg.Note.NoteEditorUI", "notifyNoteDataListFresh,open from Session");
            if (com.tencent.mm.plugin.wenote.model.c.ddG().uMN.uMP == null) {
                ab.e("MicroMsg.Note.NoteEditorUI", "notifyNoteDataListFresh,SubCoreWNNoteMsg.getCore().getWnNoteBase().mWNNoteData == null ");
                AppMethodBeat.o(27070);
                return;
            }
            wVar = (w) com.tencent.mm.plugin.wenote.model.c.ddG().uMN.uMR.get(Long.toString(com.tencent.mm.plugin.wenote.model.c.ddG().uMN.uMP.cvx));
        }
        if (!(wVar == null || this.uMY)) {
            this.uSY = wVar.uOG;
            if (wVar.uOG) {
                c(wVar.uOF, false);
            } else {
                this.uSP = true;
                c(wVar.uOF, true);
                AppMethodBeat.o(27070);
                return;
            }
        }
        AppMethodBeat.o(27070);
    }

    public final synchronized void c(Object obj, final boolean z) {
        int th = 0;
        synchronized (this) {
            AppMethodBeat.i(27071);
            ab.i("MicroMsg.Note.NoteEditorUI", "notifyNoteDataListFresh,setUpNoteData,canDismissLoadingDialog:%B", Boolean.valueOf(z));
            synchronized (this.uSZ) {
                int i;
                try {
                    com.tencent.mm.plugin.wenote.model.nativenote.manager.c.dem().den();
                    ArrayList arrayList = (ArrayList) obj;
                    if (arrayList == null) {
                        AppMethodBeat.o(th);
                    } else {
                        o oVar;
                        ab.i("MicroMsg.Note.NoteEditorUI", "notifyNoteDataListFresh,setUpNoteData start");
                        if (this.uQI == 2 && !this.uTi) {
                            com.tencent.mm.plugin.wenote.model.a.m mVar = com.tencent.mm.plugin.wenote.model.c.ddG().uMN.uMP;
                            if (mVar == null) {
                                AppMethodBeat.o(27071);
                            } else {
                                com.tencent.mm.plugin.wenote.model.a.c eVar = new com.tencent.mm.plugin.wenote.model.a.e(mVar.uOm);
                                eVar.uNT = false;
                                eVar.uNZ = false;
                                com.tencent.mm.plugin.wenote.model.nativenote.manager.c.dem().a(eVar);
                            }
                        }
                        if (z) {
                            for (i = 0; i < arrayList.size(); i++) {
                                oVar = (o) arrayList.get(i);
                                if (oVar.getType() == 20) {
                                    com.tencent.mm.plugin.wenote.model.a.b bVar = (com.tencent.mm.plugin.wenote.model.a.b) oVar;
                                    if (!this.uTi || !bVar.qxI) {
                                        com.tencent.mm.plugin.wenote.model.a.i iVar = new com.tencent.mm.plugin.wenote.model.a.i();
                                        iVar.uOo = bVar.uOo;
                                        iVar.content = getString(R.string.ug) + " " + bVar.uOC + IOUtils.LINE_SEPARATOR_UNIX;
                                        arrayList.set(i, iVar);
                                    }
                                }
                            }
                        }
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            oVar = (o) it.next();
                            switch (oVar.type) {
                                case -3:
                                case -2:
                                    break;
                                case -1:
                                    com.tencent.mm.plugin.wenote.model.nativenote.manager.c.dem().a((h) oVar);
                                    continue;
                                case 1:
                                    com.tencent.mm.plugin.wenote.model.a.c cVar = (com.tencent.mm.plugin.wenote.model.a.i) oVar;
                                    if (bo.isNullOrNil(cVar.content)) {
                                        cVar.content = "";
                                    }
                                    cVar.content = cVar.content.replaceAll("<font", "<wx-font").replaceAll("<div", "<wx-div").replaceAll("<p", "<wx-p").replaceAll("</font>", "</wx-font>").replaceAll("<ul>", "<wx-ul>").replaceAll("</ul>", "</wx-ul>").replaceAll("<ol>", "<wx-ol>").replaceAll("</ol>", "</wx-ol>").replaceAll("<li>", "<wx-li>").replaceAll("</li>", "</wx-li>").replaceAll("<b>", "<wx-b>").replaceAll("</b>", "</wx-b>").replaceAll("</div>", "</wx-div>").replaceAll("</p>", "</wx-p>");
                                    if (cVar.content.length() > 100) {
                                        com.tencent.mm.plugin.wenote.model.nativenote.a.a.ahb(cVar.content);
                                    } else if (com.tencent.mm.plugin.wenote.b.b.ahi(cVar.content)) {
                                        cVar.content = cVar.content.substring(0, cVar.content.length() - 5);
                                    }
                                    com.tencent.mm.plugin.wenote.model.nativenote.manager.c.dem().a(cVar);
                                    continue;
                                case 2:
                                    com.tencent.mm.plugin.wenote.model.nativenote.manager.c.dem().a((com.tencent.mm.plugin.wenote.model.a.f) oVar);
                                    continue;
                                case 3:
                                    com.tencent.mm.plugin.wenote.model.nativenote.manager.c.dem().a((com.tencent.mm.plugin.wenote.model.a.g) oVar);
                                    continue;
                                case 4:
                                    com.tencent.mm.plugin.wenote.model.nativenote.manager.c.dem().a((l) oVar);
                                    continue;
                                case 5:
                                    break;
                                case 6:
                                    com.tencent.mm.plugin.wenote.model.nativenote.manager.c.dem().a((com.tencent.mm.plugin.wenote.model.a.k) oVar);
                                    continue;
                                case 20:
                                    com.tencent.mm.plugin.wenote.model.nativenote.manager.c.dem().a((com.tencent.mm.plugin.wenote.model.a.b) oVar);
                                    break;
                                default:
                                    com.tencent.mm.plugin.wenote.model.nativenote.manager.c.dem().a((j) oVar);
                                    continue;
                            }
                            com.tencent.mm.plugin.wenote.model.nativenote.manager.c.dem().a((d) oVar);
                        }
                        ab.i("MicroMsg.Note.NoteEditorUI", "notifyNoteDataListFresh,setUpNoteData finish");
                        if (!z) {
                            i = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.dem();
                            synchronized (i) {
                                i.uPf = true;
                            }
                        }
                        al.d(new Runnable() {
                            public final void run() {
                                AppMethodBeat.i(26996);
                                synchronized (NoteEditorUI.this.uSZ) {
                                    try {
                                        NoteEditorUI.this.dfM();
                                        NoteEditorUI.this.uSP = true;
                                        ab.i("MicroMsg.Note.NoteEditorUI", "postToMainThread,isInitDataList = true,canDismissLoadingDialog :%B,mHasFreshedDataByHtml:%B", Boolean.valueOf(z), Boolean.valueOf(NoteEditorUI.this.uSY));
                                        if (NoteEditorUI.this.lzK != null && z) {
                                            NoteEditorUI.this.lzK.dismiss();
                                        }
                                    } finally {
                                        while (true) {
                                        }
                                        AppMethodBeat.o(26996);
                                    }
                                }
                            }
                        });
                        if (this.uTd > 0 || this.uTe != 0) {
                            this.fbD.postDelayed(new Runnable() {
                                public final void run() {
                                    AppMethodBeat.i(26997);
                                    if (NoteEditorUI.this.uST != null) {
                                        NoteEditorUI.this.uST.ah(NoteEditorUI.this.uTd, NoteEditorUI.this.uTe);
                                        NoteEditorUI.this.aaF = NoteEditorUI.this.uTd;
                                        NoteEditorUI.this.uTc = NoteEditorUI.this.uTe;
                                    }
                                    AppMethodBeat.o(26997);
                                }
                            }, 100);
                        }
                        com.tencent.mm.plugin.wenote.model.nativenote.manager.c.dem().des();
                        AppMethodBeat.o(27071);
                    }
                } catch (Throwable th2) {
                    while (true) {
                        th = th2;
                        AppMethodBeat.o(i);
                    }
                } finally {
                    i = 27071;
                    AppMethodBeat.o(27071);
                }
            }
        }
    }

    public final RecyclerView dfN() {
        return this.aiB;
    }

    public final com.tencent.mm.plugin.wenote.model.nativenote.b.a dfP() {
        return this;
    }

    static {
        AppMethodBeat.i(27111);
        AppMethodBeat.o(27111);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(27072);
        super.onActivityResult(i, i2, intent);
        ab.i("MicroMsg.Note.NoteEditorUI", "onActivityResult reqCode: %d, retCod: %d", Integer.valueOf(i), Integer.valueOf(i2));
        this.uTs = i;
        if (i2 != -1) {
            this.uTr = false;
            AppMethodBeat.o(27072);
            return;
        }
        int i3;
        this.uTr = true;
        final String stringExtra;
        String str;
        Context context;
        com.tencent.mm.plugin.wenote.model.a.c gVar;
        String stringExtra2;
        final p b;
        gh ghVar;
        switch (i) {
            case 4096:
                stringExtra = intent == null ? null : intent.getStringExtra("Select_Conv_User");
                final String stringExtra3 = intent == null ? null : intent.getStringExtra("custom_send_text");
                if (!bo.isNullOrNil(stringExtra)) {
                    aw.ZK();
                    final bi jf = com.tencent.mm.model.c.XO().jf(this.cvx);
                    if (jf.field_msgId == this.cvx) {
                        final p b2 = com.tencent.mm.ui.base.h.b(this.mController.ylL, getString(R.string.bp2), false, null);
                        aw.RS().aa(new Runnable() {
                            public final void run() {
                                AppMethodBeat.i(27000);
                                nt ntVar = new nt();
                                ntVar.cJY.type = 4;
                                ntVar.cJY.cKd = jf;
                                ntVar.cJY.toUser = stringExtra;
                                ntVar.cJY.cAN = stringExtra3;
                                com.tencent.mm.sdk.b.a.xxA.m(ntVar);
                                al.d(new Runnable() {
                                    public final void run() {
                                        AppMethodBeat.i(26999);
                                        b2.dismiss();
                                        com.tencent.mm.ui.widget.snackbar.b.i(NoteEditorUI.this, NoteEditorUI.this.getString(R.string.bvk));
                                        AppMethodBeat.o(26999);
                                    }
                                });
                                AppMethodBeat.o(27000);
                            }

                            public final String toString() {
                                AppMethodBeat.i(27001);
                                String str = super.toString() + "|onActivityResult";
                                AppMethodBeat.o(27001);
                                return str;
                            }
                        });
                        i3 = 2;
                        break;
                    }
                    ab.w("MicroMsg.Note.NoteEditorUI", "want to send record msg, but message info is null");
                    AppMethodBeat.o(27072);
                    return;
                }
                ab.w("MicroMsg.Note.NoteEditorUI", "want to send record msg, but toUser is null");
                AppMethodBeat.o(27072);
                return;
            case 4097:
                ab.i("MicroMsg.Note.NoteEditorUI", "onActivityResult back from gallery");
                if (intent.getParcelableExtra("key_req_result") == null) {
                    i3 = 2;
                } else {
                    i3 = 1;
                }
                final ArrayList stringArrayListExtra = intent.getStringArrayListExtra("CropImage_OutputPath_List");
                if (stringArrayListExtra == null || stringArrayListExtra.size() <= 0) {
                    ab.i("MicroMsg.Note.NoteEditorUI", "no pic selected");
                } else {
                    com.tencent.mm.plugin.report.service.h.pYm.e(14547, Integer.valueOf(i3));
                    if (com.tencent.mm.plugin.wenote.model.nativenote.manager.c.dem().gF(0, stringArrayListExtra.size())) {
                        ddW();
                        i3 = 0;
                        break;
                    }
                    Context context2 = this.mController.ylL;
                    getString(R.string.tz);
                    this.ehJ = com.tencent.mm.ui.base.h.b(context2, getString(R.string.un), true, new OnCancelListener() {
                        public final void onCancel(DialogInterface dialogInterface) {
                            AppMethodBeat.i(27003);
                            if (NoteEditorUI.this.ehJ != null) {
                                NoteEditorUI.this.ehJ.dismiss();
                                NoteEditorUI.this.ehJ = null;
                            }
                            AppMethodBeat.o(27003);
                        }
                    });
                    aw.RS().aa(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(27004);
                            ArrayList arrayList = new ArrayList();
                            for (int i = 0; i < stringArrayListExtra.size(); i++) {
                                String str = (String) stringArrayListExtra.get(i);
                                com.tencent.mm.plugin.wenote.model.a.f fVar = new com.tencent.mm.plugin.wenote.model.a.f();
                                fVar.uOp = true;
                                fVar.type = 2;
                                fVar.uOo = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.dem().des();
                                fVar.mnd = com.tencent.mm.plugin.wenote.model.f.agW(fVar.toString());
                                NoteEditorUI.this.uSX = new aar();
                                NoteEditorUI.this.uSX.akU(fVar.mnd);
                                fVar.uOq = com.tencent.mm.plugin.wenote.b.c.hs(str, com.tencent.mm.plugin.wenote.model.f.o(NoteEditorUI.this.uSX));
                                fVar.cHg = com.tencent.mm.plugin.wenote.b.c.ht(fVar.uOq, com.tencent.mm.plugin.wenote.model.f.c(NoteEditorUI.this.uSX));
                                arrayList.add(fVar);
                            }
                            if (NoteEditorUI.this.ehJ == null || !NoteEditorUI.this.ehJ.isShowing()) {
                                ab.i("MicroMsg.Note.NoteEditorUI", "user canceled");
                                AppMethodBeat.o(27004);
                                return;
                            }
                            com.tencent.mm.plugin.wenote.model.nativenote.manager.c.dem().a(arrayList, NoteEditorUI.this.uSJ.deW(), true, false, true, false);
                            NoteEditorUI.this.g(true, 100);
                            NoteEditorUI.this.af(1, 0);
                            AppMethodBeat.o(27004);
                        }
                    });
                }
                stringArrayListExtra = intent.getStringArrayListExtra("key_select_video_list");
                String stringExtra4 = intent.getStringExtra("K_SEGMENTVIDEOPATH");
                if (!bo.isNullOrNil(stringExtra4) && stringArrayListExtra == null) {
                    stringArrayListExtra = new ArrayList();
                    stringArrayListExtra.add(stringExtra4);
                }
                if (stringArrayListExtra != null && stringArrayListExtra.size() > 0) {
                    com.tencent.mm.plugin.report.service.h.pYm.e(14547, Integer.valueOf(i3));
                    if (!com.tencent.mm.plugin.wenote.model.nativenote.manager.c.dem().gF(0, stringArrayListExtra.size())) {
                        str = (String) stringArrayListExtra.get(0);
                        com.tencent.mm.plugin.sight.base.a WR = com.tencent.mm.plugin.sight.base.d.WR(str);
                        if (WR != null) {
                            int ckU = WR.ckU();
                            final com.tencent.mm.plugin.wenote.model.a.k kVar = new com.tencent.mm.plugin.wenote.model.a.k();
                            kVar.uOp = true;
                            kVar.thumbPath = "";
                            kVar.cHg = "";
                            kVar.duration = ckU;
                            kVar.type = 6;
                            kVar.uOo = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.dem().des();
                            kVar.uOf = com.tencent.mm.vfs.e.cv(str);
                            kVar.mnd = com.tencent.mm.plugin.wenote.model.f.agW(kVar.toString());
                            this.uSX = new aar();
                            this.uSX.akU(kVar.mnd);
                            this.uSX.akR(kVar.uOf);
                            stringExtra4 = com.tencent.mm.plugin.wenote.model.f.c(this.uSX);
                            stringExtra = com.tencent.mm.plugin.wenote.model.f.o(this.uSX);
                            if (!bo.isNullOrNil(str)) {
                                ab.v("MicroMsg.Note.NoteEditorUI", "compressNoteVideo path: %s", str);
                                stringArrayListExtra = new ArrayList();
                                stringArrayListExtra.add(str);
                                final com.tencent.mm.plugin.wenote.model.nativenote.manager.d dVar = new com.tencent.mm.plugin.wenote.model.nativenote.manager.d(stringArrayListExtra, stringExtra4, stringExtra, kVar, new com.tencent.mm.plugin.wenote.model.nativenote.manager.d.a() {
                                    public final void a(String str, com.tencent.mm.plugin.wenote.model.a.k kVar) {
                                        AppMethodBeat.i(27009);
                                        ab.i("MicroMsg.Note.NoteEditorUI", "compressNoteVideo onImportFinish");
                                        if (!(bo.isNullOrNil(str) || !com.tencent.mm.vfs.e.ct(str) || kVar == null)) {
                                            kVar.thumbPath = str;
                                        }
                                        AppMethodBeat.o(27009);
                                    }

                                    public final void b(String str, com.tencent.mm.plugin.wenote.model.a.k kVar) {
                                        AppMethodBeat.i(27010);
                                        ab.i("MicroMsg.Note.NoteEditorUI", "compressNoteVideo onExportFinish");
                                        if (NoteEditorUI.this.ehJ != null) {
                                            NoteEditorUI.this.ehJ.dismiss();
                                            NoteEditorUI.this.ehJ = null;
                                        }
                                        if (bo.isNullOrNil(str) || !com.tencent.mm.vfs.e.ct(str) || kVar == null || kVar.uOg) {
                                            ab.i("MicroMsg.Note.NoteEditorUI", "file not exist or user canceled");
                                        } else if (new com.tencent.mm.vfs.b(str).length() < NoteEditorUI.mky) {
                                            kVar.cHg = str;
                                            com.tencent.mm.plugin.wenote.model.nativenote.manager.c.dem().a((com.tencent.mm.plugin.wenote.model.a.c) kVar, NoteEditorUI.this.uSJ.deW(), false, true, false);
                                        } else {
                                            Toast.makeText(NoteEditorUI.this.mController.ylL, NoteEditorUI.this.getString(R.string.bs4), 1).show();
                                        }
                                        NoteEditorUI.this.g(true, 100);
                                        NoteEditorUI.this.af(1, 0);
                                        AppMethodBeat.o(27010);
                                    }
                                });
                                context = this.mController.ylL;
                                getString(R.string.tz);
                                this.ehJ = com.tencent.mm.ui.base.h.b(context, getString(R.string.un), true, new OnCancelListener() {
                                    public final void onCancel(DialogInterface dialogInterface) {
                                        AppMethodBeat.i(27011);
                                        com.tencent.mm.plugin.wenote.model.nativenote.manager.d dVar = dVar;
                                        dVar.isStop = true;
                                        dVar.interrupt();
                                        kVar.uOg = true;
                                        NoteEditorUI.this.g(true, 100);
                                        NoteEditorUI.this.af(1, 0);
                                        AppMethodBeat.o(27011);
                                    }
                                });
                                com.tencent.mm.sdk.g.d.post(dVar, "NoteEditor_importVideo");
                                i3 = 0;
                                break;
                            }
                            ab.e("MicroMsg.Note.NoteEditorUI", "video is null");
                            i3 = 0;
                            break;
                        }
                        ab.e("MicroMsg.Note.NoteEditorUI", "mediaInfo is null, videoPath is %s", bo.nullAsNil(str));
                        i3 = 0;
                        break;
                    }
                    ddW();
                    i3 = 0;
                    break;
                }
                ab.i("MicroMsg.Note.NoteEditorUI", "no video selected");
                i3 = 0;
                break;
                break;
            case 4098:
                com.tencent.mm.plugin.report.service.h.pYm.e(14547, Integer.valueOf(4));
                if (!com.tencent.mm.plugin.wenote.model.nativenote.manager.c.dem().gF(0, 1)) {
                    gVar = new com.tencent.mm.plugin.wenote.model.a.g();
                    gVar.lat = (double) ((float) intent.getDoubleExtra("kwebmap_slat", 0.0d));
                    gVar.lng = (double) ((float) intent.getDoubleExtra("kwebmap_lng", 0.0d));
                    gVar.scale = (double) intent.getIntExtra("kwebmap_scale", 0);
                    gVar.fBg = bo.bc(intent.getStringExtra("Kwebmap_locaion"), "");
                    gVar.eUu = intent.getStringExtra("kPoiName");
                    gVar.uOo = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.dem().des();
                    gVar.type = 3;
                    gVar.uOp = true;
                    gVar.cHg = "";
                    com.tencent.mm.plugin.wenote.model.nativenote.manager.c.dem().a(gVar, this.uSJ.deW(), false, false, false);
                    i3 = 0;
                    break;
                }
                ddW();
                i3 = 0;
                break;
            case 4099:
                com.tencent.mm.plugin.report.service.h.pYm.e(14547, Integer.valueOf(5));
                str = intent.getStringExtra("choosed_file_path");
                if (!bo.isNullOrNil(str)) {
                    com.tencent.mm.vfs.b bVar = new com.tencent.mm.vfs.b(str);
                    if (bVar.exists()) {
                        if (bVar.length() < mky) {
                            if (!com.tencent.mm.plugin.wenote.model.nativenote.manager.c.dem().gF(0, 1)) {
                                if (this.ehJ != null) {
                                    this.ehJ.dismiss();
                                    this.ehJ = null;
                                }
                                context = this.mController.ylL;
                                getString(R.string.tz);
                                this.ehJ = com.tencent.mm.ui.base.h.b(context, getString(R.string.un), true, new OnCancelListener() {
                                    public final void onCancel(DialogInterface dialogInterface) {
                                        AppMethodBeat.i(27005);
                                        if (NoteEditorUI.this.ehJ != null) {
                                            NoteEditorUI.this.ehJ.dismiss();
                                            NoteEditorUI.this.ehJ = null;
                                        }
                                        AppMethodBeat.o(27005);
                                    }
                                });
                                gVar = new d();
                                gVar.title = bVar.getName();
                                gVar.content = com.tencent.mm.plugin.wenote.model.f.aC((float) bVar.length());
                                gVar.hNN = com.tencent.mm.plugin.wenote.model.h.aha(com.tencent.mm.vfs.e.cv(str));
                                gVar.uOo = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.dem().des();
                                gVar.type = 5;
                                gVar.uOp = true;
                                gVar.uOf = com.tencent.mm.vfs.e.cv(str);
                                gVar.mnd = com.tencent.mm.plugin.wenote.model.f.agW(gVar.toString());
                                this.uSX = new aar();
                                this.uSX.akU(gVar.mnd);
                                this.uSX.akR(gVar.uOf);
                                gVar.cHg = com.tencent.mm.plugin.wenote.model.f.o(this.uSX);
                                com.tencent.mm.vfs.e.y(str, gVar.cHg);
                                com.tencent.mm.plugin.wenote.model.nativenote.manager.c.dem().a(gVar, this.uSJ.deW(), false, true, false);
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
                if (!bo.isNullOrNil(stringExtra2)) {
                    b = com.tencent.mm.ui.base.h.b(this.mController.ylL, getString(R.string.bp2), false, null);
                    ghVar = new gh();
                    ghVar.cAH.type = 13;
                    ghVar.cAH.context = this.mController.ylL;
                    ghVar.cAH.toUser = stringExtra2;
                    ghVar.cAH.cAN = str;
                    ghVar.cAH.cvv = this.fDy;
                    ghVar.cAH.cAM = new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(27002);
                            b.dismiss();
                            com.tencent.mm.ui.widget.snackbar.b.i(NoteEditorUI.this, NoteEditorUI.this.getString(R.string.bvk));
                            AppMethodBeat.o(27002);
                        }
                    };
                    com.tencent.mm.sdk.b.a.xxA.m(ghVar);
                    i3 = 2;
                    break;
                }
                ab.w("MicroMsg.Note.NoteEditorUI", "want to send record msg, but toUser is null");
                AppMethodBeat.o(27072);
                return;
            case 4354:
                this.fbD.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(27006);
                        Toast.makeText(NoteEditorUI.this, NoteEditorUI.this.getString(R.string.egv), 0).show();
                        AppMethodBeat.o(27006);
                    }
                });
                i3 = 2;
                break;
            case 4355:
                stringExtra2 = intent == null ? null : intent.getStringExtra("Select_Conv_User");
                if (intent == null) {
                    str = null;
                } else {
                    str = intent.getStringExtra("custom_send_text");
                }
                if (!bo.isNullOrNil(stringExtra2)) {
                    b = com.tencent.mm.ui.base.h.b(this.mController.ylL, getString(R.string.bp2), false, null);
                    ghVar = new gh();
                    ghVar.cAH.type = 13;
                    ghVar.cAH.context = this.mController.ylL;
                    ghVar.cAH.toUser = stringExtra2;
                    ghVar.cAH.cAN = str;
                    ghVar.cAH.cvv = this.fDy;
                    ghVar.cAH.cvC = com.tencent.mm.plugin.wenote.model.c.ddG().uMN.uMZ;
                    ghVar.cAH.cAM = new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(27008);
                            b.dismiss();
                            com.tencent.mm.ui.widget.snackbar.b.i(NoteEditorUI.this, NoteEditorUI.this.getString(R.string.bvk));
                            AppMethodBeat.o(27008);
                        }
                    };
                    com.tencent.mm.sdk.b.a.xxA.m(ghVar);
                    i3 = 2;
                    break;
                }
                ab.w("MicroMsg.Note.NoteEditorUI", "want to send note from sns, but toUser is null");
                AppMethodBeat.o(27072);
                return;
            case 30764:
                Bundle bundleExtra = intent.getBundleExtra("result_data");
                if (bundleExtra != null && bundleExtra.getString("go_next", "").equals("gdpr_auth_location")) {
                    com.tencent.mm.kernel.g.RP().Ry().set(com.tencent.mm.storage.ac.a.USERINFO_GDPR_LOCATION_PERMISSION_DESCRIBE_CONFIRM_BOOLEAN_SYNC, Boolean.TRUE);
                    com.tencent.mm.pluginsdk.permission.b.b(this.mController.ylL, "android.permission.ACCESS_COARSE_LOCATION", 64);
                    break;
                }
        }
        i3 = 2;
        if (i3 == 0) {
            AppMethodBeat.o(27072);
        } else if (1 == i3) {
            com.tencent.mm.ui.base.h.bQ(this.mController.ylL, getString(R.string.bog));
            AppMethodBeat.o(27072);
        } else {
            if (3 == i3) {
                Toast.makeText(this.mController.ylL, getString(R.string.bs4), 1).show();
            }
            AppMethodBeat.o(27072);
        }
    }

    public final void i(String str, boolean z, boolean z2) {
        AppMethodBeat.i(27073);
        ab.i("MicroMsg.Note.NoteEditorUI", "setEditorExportLogic,htmlstr:%s,isInsert:%B", str, Boolean.valueOf(z));
        if (z || !str.equals(this.uSS)) {
            abf ahe = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.dem().ahe(str);
            if (ahe == null) {
                ab.e("MicroMsg.Note.NoteEditorUI", "protoitem is null,return");
                AppMethodBeat.o(27073);
                return;
            }
            gh ghVar;
            if (z) {
                ghVar = new gh();
                ghVar.cAH.type = 19;
                ghVar.cAH.cvC = ahe;
                ghVar.cAH.title = str;
                ghVar.cAH.cvv = this.fDy;
                ghVar.cAH.desc = "fav_add_new_note";
                com.tencent.mm.sdk.b.a.xxA.m(ghVar);
            } else {
                ghVar = new gh();
                ghVar.cAH.type = 19;
                ghVar.cAH.cvC = ahe;
                ghVar.cAH.title = str;
                ghVar.cAH.cvv = this.fDy;
                ghVar.cAH.desc = "";
                if (this.uSR) {
                    ghVar.cAH.cAO = -2;
                }
                com.tencent.mm.sdk.b.a.xxA.m(ghVar);
            }
            ab.i("MicroMsg.Note.NoteEditorUI", "write html to file suc");
            int i = 20;
            int i2;
            if (z) {
                while (true) {
                    ghVar = new gh();
                    ghVar.cAH.type = 30;
                    ghVar.cAH.cAO = 6;
                    ghVar.cAH.cvv = this.fDy;
                    com.tencent.mm.sdk.b.a.xxA.m(ghVar);
                    if ((ghVar.cAI.ret == 1 ? 1 : 0) != 0) {
                        this.uMY = false;
                        this.uNq = false;
                        this.uSQ = true;
                        ab.i("MicroMsg.Note.NoteEditorUI", "hasUploadToServer: insert");
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
                    if (com.tencent.mm.plugin.fav.a.b.g(((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavItemInfoStorage().iE(this.fDy))) {
                        ab.i("MicroMsg.Note.NoteEditorUI", "hasUploadToServer: update, %s", Integer.valueOf(((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavItemInfoStorage().iE(this.fDy).field_itemStatus));
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
            this.uSS = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.dem().deu();
            ab.i("MicroMsg.Note.NoteEditorUI", "setEditorExportLogic end");
            AppMethodBeat.o(27073);
            return;
        }
        if (!this.uTk && this.uSJ.uQF > 0 && !bo.isNullOrNil(this.uSJ.uQG) && this.uSJ.uQH > 0) {
            gh ghVar2 = new gh();
            ghVar2.cAH.type = 19;
            ghVar2.cAH.cAO = -3;
            ghVar2.cAH.cvv = this.fDy;
            Intent intent = new Intent();
            intent.putExtra("fav_note_item_status", this.uSJ.uQF);
            intent.putExtra("fav_note_xml", this.uSJ.uQG);
            intent.putExtra("fav_note_item_updatetime", this.uSJ.uQH);
            ghVar2.cAH.cAK = intent;
            com.tencent.mm.sdk.b.a.xxA.m(ghVar2);
        }
        AppMethodBeat.o(27073);
    }

    static boolean ahr(String str) {
        AppMethodBeat.i(27074);
        if (bo.isNullOrNil(com.tencent.mm.plugin.wenote.b.b.ahj(str))) {
            AppMethodBeat.o(27074);
            return true;
        }
        AppMethodBeat.o(27074);
        return false;
    }

    public void onResume() {
        AppMethodBeat.i(27075);
        super.onResume();
        if (this.uQI == 2) {
            switch (this.uTs) {
                case -1:
                    if (this.uTt) {
                        g(true, 100);
                        af(1, 0);
                        break;
                    }
                    break;
                case 4097:
                    if (!this.uTr) {
                        g(true, 100);
                        af(1, 0);
                        break;
                    }
                    break;
                case 4098:
                case 4099:
                    g(true, 100);
                    af(1, 0);
                    break;
            }
        }
        this.uTs = -1;
        this.uTr = false;
        AppMethodBeat.o(27075);
    }

    public void onPause() {
        AppMethodBeat.i(27076);
        super.onPause();
        if (this.uSM != null) {
            this.uSM.a((com.tencent.mm.plugin.wenote.model.nativenote.b.a) this);
        }
        if (com.tencent.mm.plugin.wenote.ui.nativenote.voiceview.a.dfY().buH()) {
            com.tencent.mm.plugin.wenote.ui.nativenote.voiceview.a.dfY().stopPlay();
        }
        this.uTt = this.uSV;
        g(false, 0);
        q deI = com.tencent.mm.plugin.wenote.model.nativenote.manager.h.deH().deI();
        if (c(deI)) {
            deI.uOu = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.dem().ahf(getString(R.string.g16));
            deI.uOw = this.aaF;
            deI.uOx = this.uTc;
            com.tencent.mm.plugin.wenote.model.nativenote.manager.h.deH().a(deI);
        }
        AppMethodBeat.o(27076);
    }

    public void onDrag() {
        AppMethodBeat.i(27077);
        super.onDrag();
        if (this.uTn) {
            e.dfb().dfj();
            e.dfb().dfh();
        }
        AppMethodBeat.o(27077);
    }

    public void onCancel() {
        AppMethodBeat.i(27078);
        super.onCancel();
        if (this.uTn) {
            e.dfb().oq(false);
            e.dfb().op(false);
        }
        AppMethodBeat.o(27078);
    }

    public final void ddZ() {
        AppMethodBeat.i(27079);
        com.tencent.mm.ui.base.h.d(this, getString(R.string.d82), "", getString(R.string.d81), getString(R.string.d80), new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.i(27013);
                e.dfb().dfp();
                AppMethodBeat.o(27013);
            }
        }, null);
        AppMethodBeat.o(27079);
    }

    public final int dec() {
        AppMethodBeat.i(27081);
        if (this.uSV) {
            int gp = x.gp(this);
            AppMethodBeat.o(27081);
            return gp;
        }
        AppMethodBeat.o(27081);
        return 0;
    }

    public final int ded() {
        AppMethodBeat.i(27082);
        int i = 0;
        if (this.uSL != null && this.uSL.getVisibility() == 0) {
            i = this.uTo + 0;
        }
        if (this.uTa != null && this.uTa.getVisibility() == 0) {
            i += this.uTo;
        }
        AppMethodBeat.o(27082);
        return i;
    }

    public final boolean dee() {
        AppMethodBeat.i(27083);
        if (this.uSJ == null || this.uSJ.deS() == null) {
            AppMethodBeat.o(27083);
            return false;
        }
        AppMethodBeat.o(27083);
        return true;
    }

    public final RecyclerView def() {
        return this.aiB;
    }

    public final void deb() {
        AppMethodBeat.i(27084);
        if (this.uQI == 2 && this.uSJ.uQJ) {
            int deo = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.dem().deo();
            com.tencent.mm.plugin.wenote.model.a.c Ke = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.dem().Ke(deo);
            if (Ke != null) {
                Ke.uNT = false;
                Ke.uNZ = false;
                JX(deo);
            }
            this.fbD.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(27014);
                    WXRTEditText deS = NoteEditorUI.this.uSJ.deS();
                    if (deS != null) {
                        deS.clearFocus();
                    }
                    AppMethodBeat.o(27014);
                }
            });
            g(false, 0);
            af(0, 0);
            AppMethodBeat.o(27084);
            return;
        }
        AppMethodBeat.o(27084);
    }

    public final void a(WXRTEditText wXRTEditText, boolean z, int i) {
        AppMethodBeat.i(27085);
        if (this.uQI == 2 && this.uSJ.uQJ) {
            ((com.tencent.mm.plugin.wenote.ui.nativenote.a.a) this.aiB.getLayoutManager()).uUg = z;
            if (this.uSU) {
                ((com.tencent.mm.plugin.wenote.ui.nativenote.a.a) this.aiB.getLayoutManager()).uUg = false;
            }
            if (z) {
                if (!(this.uMY || this.uSQ)) {
                    this.uSS = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.dem().deu();
                    this.uSQ = true;
                }
                if (wXRTEditText == null || wXRTEditText.getEditTextType() != 1) {
                    com.tencent.mm.plugin.wenote.model.nativenote.manager.c.dem().aw(i, false);
                    AppMethodBeat.o(27085);
                    return;
                }
                com.tencent.mm.plugin.wenote.model.nativenote.manager.c.dem().aw(i, true);
                AppMethodBeat.o(27085);
                return;
            }
            com.tencent.mm.plugin.wenote.model.nativenote.manager.c.dem().av(-1, false);
            AppMethodBeat.o(27085);
            return;
        }
        AppMethodBeat.o(27085);
    }

    public final void deg() {
        AppMethodBeat.i(27086);
        if (!(this.uMY || this.uSQ)) {
            this.uSS = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.dem().deu();
            this.uSQ = true;
        }
        AppMethodBeat.o(27086);
    }

    public final void onKeyboardStateChanged() {
        AppMethodBeat.i(27087);
        super.onKeyboardStateChanged();
        this.uSV = this.mController.ymc == 1;
        if (this.uSV) {
            af(1, 0);
        }
        if (this.uTn) {
            this.fbD.postDelayed(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(27015);
                    e.dfb().oq(e.dfb().dfi());
                    e.dfb().op(e.dfb().dfg());
                    AppMethodBeat.o(27015);
                }
            }, 200);
        }
        AppMethodBeat.o(27087);
    }

    public final void g(final boolean z, long j) {
        AppMethodBeat.i(27088);
        if (this.uQI == 2 && this.uSJ.uQJ) {
            this.fbD.postDelayed(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(27016);
                    if (!z || NoteEditorUI.this.uSV) {
                        if (!z && NoteEditorUI.this.uSV) {
                            NoteEditorUI.this.aqX();
                        }
                        AppMethodBeat.o(27016);
                        return;
                    }
                    NoteEditorUI.this.showVKB();
                    AppMethodBeat.o(27016);
                }
            }, j);
            AppMethodBeat.o(27088);
            return;
        }
        AppMethodBeat.o(27088);
    }

    public final void af(final int i, long j) {
        AppMethodBeat.i(27089);
        if (this.uQI == 2 && this.uSJ.uQJ) {
            this.fbD.postDelayed(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(27017);
                    ImageButton imageButton = (ImageButton) NoteEditorUI.this.uSL.findViewById(R.id.dil);
                    View findViewById = NoteEditorUI.this.uSL.findViewById(R.id.dim);
                    switch (i) {
                        case 0:
                            NoteEditorUI.this.uTa.setVisibility(8);
                            if (NoteEditorUI.this.uSM.uTV) {
                                NoteEditorUI.this.uSL.setVisibility(0);
                                AppMethodBeat.o(27017);
                                return;
                            }
                            NoteEditorUI.this.uSL.setVisibility(8);
                            AppMethodBeat.o(27017);
                            return;
                        case 1:
                            imageButton.setImageResource(R.raw.note_style_unpress);
                            findViewById.setVisibility(8);
                            NoteEditorUI.this.uSL.setVisibility(0);
                            NoteEditorUI.this.uTa.setVisibility(8);
                            AppMethodBeat.o(27017);
                            return;
                        case 2:
                            NoteEditorUI.this.uSL.setVisibility(0);
                            NoteEditorUI.this.uTa.setVisibility(8);
                            AppMethodBeat.o(27017);
                            return;
                        case 3:
                            imageButton.setImageResource(R.raw.note_style_press);
                            findViewById.setVisibility(0);
                            NoteEditorUI.this.uSL.setVisibility(0);
                            NoteEditorUI.this.uTa.setVisibility(0);
                            break;
                    }
                    AppMethodBeat.o(27017);
                }
            }, j);
            AppMethodBeat.o(27089);
            return;
        }
        AppMethodBeat.o(27089);
    }

    public final void ddU() {
        AppMethodBeat.i(27090);
        if (!this.uSM.uTV) {
            deb();
            final AppCompatActivity appCompatActivity = this.mController.ylL;
            this.fbD.postDelayed(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(27018);
                    int size = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.dem().size();
                    int childCount = NoteEditorUI.this.aiB.getChildCount();
                    if (size == childCount) {
                        size = childCount - 1;
                        float f = 0.0f;
                        int i = size;
                        while (i >= 0) {
                            View childAt = NoteEditorUI.this.aiB.getChildAt(i);
                            float Y = s.Y(childAt);
                            i--;
                            f = f > ((float) childAt.getBottom()) + Y ? f : ((float) childAt.getBottom()) + Y;
                        }
                        if (f < ((float) x.db(appCompatActivity)[1]) && f > 0.0f) {
                            LayoutParams layoutParams = (LayoutParams) NoteEditorUI.this.uSN.getLayoutParams();
                            layoutParams.height = (int) f;
                            NoteEditorUI.this.uSN.setLayoutParams(layoutParams);
                        }
                    }
                    NoteEditorUI.this.uSN.setVisibility(0);
                    if (NoteEditorUI.this.uSO != null) {
                        g a = NoteEditorUI.this.uSO;
                        int[] iArr = new int[]{0, 0};
                        a.mParentView.getLocationOnScreen(iArr);
                        a.uPB.showAtLocation(a.mParentView, 49, 0, iArr[1] + 50);
                    }
                    AppMethodBeat.o(27018);
                }
            }, 400);
        }
        AppMethodBeat.o(27090);
    }

    public final void a(WXRTEditText wXRTEditText) {
        AppMethodBeat.i(27091);
        if (wXRTEditText != null) {
            boolean z;
            if (com.tencent.mm.plugin.wenote.model.nativenote.manager.f.iLD == null || com.tencent.mm.plugin.wenote.model.nativenote.manager.f.iLD.size() <= 0) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                ArrayList deA = com.tencent.mm.plugin.wenote.model.nativenote.manager.f.deA();
                if (com.tencent.mm.plugin.wenote.model.nativenote.manager.c.dem().af(deA)) {
                    ddW();
                    AppMethodBeat.o(27091);
                    return;
                }
                com.tencent.mm.plugin.wenote.model.nativenote.manager.c.dem().a(deA, wXRTEditText, true, true, false, false);
                int recyclerItemPosition = wXRTEditText.getRecyclerItemPosition();
                com.tencent.mm.plugin.wenote.model.nativenote.manager.c.dem().gG(recyclerItemPosition, (deA.size() + recyclerItemPosition) + 1);
                deb();
                if (this.uTn) {
                    e.dfb().dff();
                }
                AppMethodBeat.o(27091);
                return;
            }
        }
        AppMethodBeat.o(27091);
    }

    public final void deG() {
        AppMethodBeat.i(27092);
        int deC = com.tencent.mm.plugin.wenote.model.nativenote.manager.f.deC();
        if (deC == 2) {
            if (com.tencent.mm.plugin.wenote.model.nativenote.manager.f.deB()) {
                ddW();
                AppMethodBeat.o(27092);
                return;
            }
            com.tencent.mm.plugin.wenote.model.nativenote.manager.c.dem().den();
            com.tencent.mm.plugin.wenote.model.nativenote.manager.f.clearData();
            com.tencent.mm.plugin.wenote.model.a.c iVar = new com.tencent.mm.plugin.wenote.model.a.i();
            iVar.content = "";
            iVar.uNT = false;
            iVar.uNZ = false;
            iVar.uNV = 0;
            iVar.uOb = true;
            com.tencent.mm.plugin.wenote.model.nativenote.manager.c.dem().a(iVar);
            dfM();
            AppMethodBeat.o(27092);
        } else if (deC == 3) {
            ArrayList deA = com.tencent.mm.plugin.wenote.model.nativenote.manager.f.deA();
            if (com.tencent.mm.plugin.wenote.model.nativenote.manager.c.dem().af(deA)) {
                ddW();
                AppMethodBeat.o(27092);
                return;
            }
            com.tencent.mm.plugin.wenote.model.nativenote.manager.c.dem().den();
            com.tencent.mm.plugin.wenote.model.nativenote.manager.c.dem().a(deA, null, false, false, false, false);
            deb();
            AppMethodBeat.o(27092);
        } else {
            AppMethodBeat.o(27092);
        }
    }

    public final void deD() {
        AppMethodBeat.i(27093);
        com.tencent.mm.plugin.wenote.model.a.c iVar = new com.tencent.mm.plugin.wenote.model.a.i();
        iVar.content = "";
        iVar.uNT = true;
        iVar.uNZ = false;
        iVar.uNV = 0;
        com.tencent.mm.plugin.wenote.model.nativenote.manager.c.dem().den();
        com.tencent.mm.plugin.wenote.model.nativenote.manager.c.dem().a(iVar);
        dfM();
        g(true, 50);
        af(1, 0);
        AppMethodBeat.o(27093);
    }

    public final void gE(int i, int i2) {
        AppMethodBeat.i(27096);
        this.uSU = Math.abs(i2 - i) > 0;
        AppMethodBeat.o(27096);
    }

    public final void Ka(final int i) {
        AppMethodBeat.i(27097);
        if (i < 0 || i >= com.tencent.mm.plugin.wenote.model.nativenote.manager.c.dem().size()) {
            AppMethodBeat.o(27097);
            return;
        }
        this.fbD.post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(27032);
                NoteEditorUI.this.aiB.bY(i);
                AppMethodBeat.o(27032);
            }
        });
        AppMethodBeat.o(27097);
    }

    public final void ddV() {
        AppMethodBeat.i(27098);
        this.fbD.post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(27033);
                if (NoteEditorUI.this.ehJ != null) {
                    NoteEditorUI.this.ehJ.dismiss();
                    NoteEditorUI.this.ehJ = null;
                }
                AppMethodBeat.o(27033);
            }
        });
        AppMethodBeat.o(27098);
    }

    public final void ddW() {
        AppMethodBeat.i(27099);
        if (this.uMY || this.uSQ) {
            deb();
            if (this.uTn) {
                e.dfb().dff();
            }
            this.fbD.postDelayed(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(27034);
                    com.tencent.mm.ui.base.h.b(NoteEditorUI.this.mController.ylL, NoteEditorUI.this.getString(R.string.g1n), null, true);
                    AppMethodBeat.o(27034);
                }
            }, 100);
        }
        AppMethodBeat.o(27099);
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        AppMethodBeat.i(27100);
        if (iArr == null || iArr.length <= 0) {
            ab.i("MicroMsg.Note.NoteEditorUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", Integer.valueOf(i), Long.valueOf(Thread.currentThread().getId()));
            AppMethodBeat.o(27100);
            return;
        }
        ab.i("MicroMsg.Note.NoteEditorUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId()));
        switch (i) {
            case 64:
                if (com.tencent.mm.au.b.sO((String) com.tencent.mm.kernel.g.RP().Ry().get(274436, null)) && iArr[0] != 0) {
                    com.tencent.mm.ui.base.h.a(this.mController.ylL, getString(R.string.dby), getString(R.string.dc8), getString(R.string.ckr), getString(R.string.abx), false, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.i(27035);
                            NoteEditorUI.this.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                            AppMethodBeat.o(27035);
                        }
                    }, null);
                    break;
                }
            case 80:
                if (iArr[0] != 0) {
                    ddX();
                    AppMethodBeat.o(27100);
                    return;
                }
                break;
        }
        AppMethodBeat.o(27100);
    }

    public final void ddX() {
        AppMethodBeat.i(27101);
        com.tencent.mm.ui.base.h.a((Context) this, getString(R.string.dc0), getString(R.string.dc8), getString(R.string.ckr), getString(R.string.abx), false, new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.i(27036);
                dialogInterface.dismiss();
                NoteEditorUI.this.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                AppMethodBeat.o(27036);
            }
        }, new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.i(27037);
                dialogInterface.dismiss();
                AppMethodBeat.o(27037);
            }
        });
        AppMethodBeat.o(27101);
    }

    private boolean dfQ() {
        AppMethodBeat.i(27102);
        gh ghVar = new gh();
        ghVar.cAH.type = 19;
        ghVar.cAH.cvv = this.fDy;
        ghVar.cAH.cAO = -1;
        com.tencent.mm.sdk.b.a.xxA.m(ghVar);
        if (ghVar.cAI.cAY) {
            AppMethodBeat.o(27102);
            return false;
        }
        AppMethodBeat.o(27102);
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
            android.widget.Toast.makeText(r14.mController.ylL, r14.mController.ylL.getString(com.tencent.mm.R.string.d87), 1).show();
     */
    /* JADX WARNING: Missing block: B:57:?, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.o(27103);
     */
    /* JADX WARNING: Missing block: B:93:?, code skipped:
            r3 = com.tencent.mm.plugin.report.service.h.pYm;
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
            r3.e(14811, r5);
            com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.Note.NoteEditorUI", "favorite, note, gen long pic , 565 error,errormsg is er:");
            bpD();
            android.widget.Toast.makeText(r14.mController.ylL, r14.mController.ylL.getString(com.tencent.mm.R.string.d87), 1).show();
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
            com.tencent.matrix.trace.core.AppMethodBeat.o(27103);
     */
    /* JADX WARNING: Missing block: B:108:0x032c, code skipped:
            r2 = move-exception;
     */
    /* JADX WARNING: Missing block: B:110:?, code skipped:
            com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.Note.NoteEditorUI", "genlongpic fail,error msg Exception");
            com.tencent.mm.sdk.platformtools.ab.printErrStackTrace("MicroMsg.Note.NoteEditorUI", r2, "", new java.lang.Object[0]);
            bpD();
            android.widget.Toast.makeText(r14.mController.ylL, r14.mController.ylL.getString(com.tencent.mm.R.string.d87), 1).show();
            r3 = com.tencent.mm.plugin.report.service.h.pYm;
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
            r3.e(14811, r5);
     */
    /* JADX WARNING: Missing block: B:116:?, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.o(27103);
     */
    /* JADX WARNING: Missing block: B:117:0x0399, code skipped:
            r2 = 0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void onSceneEnd(int i, int i2, String str, com.tencent.mm.ai.m mVar) {
        AppMethodBeat.i(27103);
        if (mVar.getType() != 921) {
            AppMethodBeat.o(27103);
        } else if (mVar instanceof com.tencent.mm.plugin.wenote.model.b) {
            com.tencent.mm.plugin.wenote.model.b bVar = (com.tencent.mm.plugin.wenote.model.b) mVar;
            if (bVar.uMF != 1) {
                AppMethodBeat.o(27103);
            } else {
                com.tencent.mm.plugin.report.service.h hVar;
                Object[] objArr;
                if (i2 == 0) {
                    ab.i("MicroMsg.Note.NoteEditorUI", "genlong pic , allow");
                    android.support.v7.widget.RecyclerView.a adapter = this.aiB.getAdapter();
                    if (adapter != null) {
                        int itemCount = adapter.getItemCount();
                        if (itemCount <= 0) {
                            bpD();
                            Toast.makeText(this.mController.ylL, this.mController.ylL.getString(R.string.d87), 1).show();
                            hVar = com.tencent.mm.plugin.report.service.h.pYm;
                            objArr = new Object[5];
                            objArr[0] = Integer.valueOf(0);
                            objArr[1] = Integer.valueOf(0);
                            objArr[2] = Integer.valueOf(0);
                            objArr[3] = Integer.valueOf(1);
                            objArr[4] = Integer.valueOf(this.uTi ? 1 : 0);
                            hVar.e(14811, objArr);
                            AppMethodBeat.o(27103);
                        } else {
                            int i3 = 0;
                            try {
                                int width;
                                Bitmap createBitmap;
                                com.tencent.mm.memory.a.b bVar2 = new com.tencent.mm.memory.a.b(((int) (Runtime.getRuntime().maxMemory() / 1024)) / 8, getClass());
                                int i4 = 0;
                                while (i4 < itemCount) {
                                    v c = adapter.c(this.aiB, adapter.getItemViewType(i4));
                                    adapter.a(c, i4);
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
                                            Toast.makeText(this.mController.ylL, this.mController.ylL.getString(R.string.d87), 1).show();
                                            com.tencent.mm.plugin.report.service.h hVar2 = com.tencent.mm.plugin.report.service.h.pYm;
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
                                            hVar2.e(14811, objArr2);
                                        } catch (Throwable th) {
                                            ab.e("MicroMsg.Note.NoteEditorUI", "genlongpic fail,Throwable error msg throw");
                                            bpD();
                                            Toast.makeText(this.mController.ylL, this.mController.ylL.getString(R.string.d87), 1).show();
                                            hVar = com.tencent.mm.plugin.report.service.h.pYm;
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
                                            hVar.e(14811, objArr);
                                        }
                                        try {
                                            bVar2.put(String.valueOf(i4), createBitmap2);
                                            i3 += c.apJ.getMeasuredHeight();
                                        } catch (Exception e2) {
                                        } catch (Throwable th2) {
                                            ab.e("MicroMsg.Note.NoteEditorUI", "genlongpic fail,Throwable error msg throw");
                                            bpD();
                                            Toast.makeText(this.mController.ylL, this.mController.ylL.getString(R.string.d87), 1).show();
                                            hVar = com.tencent.mm.plugin.report.service.h.pYm;
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
                                            hVar.e(14811, objArr);
                                        }
                                    }
                                    i4++;
                                }
                                try {
                                    width = com.tencent.mm.bz.a.fromDPToPix(this.mController.ylL, 14);
                                    createBitmap = Bitmap.createBitmap(this.aiB.getMeasuredWidth() + 0, i3 + width, Config.ARGB_8888);
                                } catch (Exception e22) {
                                } catch (Throwable th3) {
                                    ab.e("MicroMsg.Note.NoteEditorUI", "favorite, note, gen long pic ,rgb 888  error,errormsg ");
                                    createBitmap = Bitmap.createBitmap(this.aiB.getMeasuredWidth() + 0, i3 + width, Config.RGB_565);
                                }
                                Canvas canvas = new Canvas(createBitmap);
                                canvas.drawColor(-1);
                                width = com.tencent.mm.bz.a.fromDPToPix(this.mController.ylL, 8);
                                i4 = 0;
                                while (i4 < itemCount) {
                                    Bitmap bitmap = (Bitmap) bVar2.get(String.valueOf(i4));
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
                                    Toast.makeText(this.mController.ylL, this.mController.ylL.getString(R.string.b3r, new Object[]{com.tencent.mm.sdk.f.a.dlz()}), 1).show();
                                    aw.RS().aa(new Runnable() {
                                        public final void run() {
                                            AppMethodBeat.i(27038);
                                            com.tencent.mm.plugin.wenote.model.h.a(NoteEditorUI.this.mController.ylL, createBitmap, NoteEditorUI.this.uTi);
                                            AppMethodBeat.o(27038);
                                        }
                                    });
                                } else if (createBitmap != null) {
                                    if (!createBitmap.isRecycled()) {
                                        createBitmap.recycle();
                                    }
                                }
                            } catch (Exception e3) {
                                ab.e("MicroMsg.Note.NoteEditorUI", "genlongpic fail,Exception error msg a");
                                bpD();
                                Toast.makeText(this.mController.ylL, this.mController.ylL.getString(R.string.d87), 1).show();
                                hVar = com.tencent.mm.plugin.report.service.h.pYm;
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
                                hVar.e(14811, objArr);
                            } catch (Throwable th22) {
                                ab.e("MicroMsg.Note.NoteEditorUI", "genlongpic fail,Throwable error msg throw");
                                bpD();
                                Toast.makeText(this.mController.ylL, this.mController.ylL.getString(R.string.d87), 1).show();
                                hVar = com.tencent.mm.plugin.report.service.h.pYm;
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
                                hVar.e(14811, objArr);
                            }
                        }
                    } else {
                        hVar = com.tencent.mm.plugin.report.service.h.pYm;
                        objArr = new Object[5];
                        objArr[0] = Integer.valueOf(0);
                        objArr[1] = Integer.valueOf(0);
                        objArr[2] = Integer.valueOf(0);
                        objArr[3] = Integer.valueOf(1);
                        objArr[4] = Integer.valueOf(this.uTi ? 1 : 0);
                        hVar.e(14811, objArr);
                        bpD();
                        Toast.makeText(this.mController.ylL, this.mController.ylL.getString(R.string.d87), 1).show();
                    }
                } else {
                    hVar = com.tencent.mm.plugin.report.service.h.pYm;
                    objArr = new Object[5];
                    objArr[0] = Integer.valueOf(0);
                    objArr[1] = Integer.valueOf(0);
                    objArr[2] = Integer.valueOf(0);
                    objArr[3] = Integer.valueOf(4);
                    objArr[4] = Integer.valueOf(this.uTi ? 1 : 0);
                    hVar.e(14811, objArr);
                    ab.e("MicroMsg.Note.NoteEditorUI", "genlong pic , not allow");
                    bpD();
                    Toast.makeText(this.mController.ylL, this.mController.ylL.getString(R.string.d87), 1).show();
                }
                this.uSJ.uQI = bVar.uMJ;
                com.tencent.mm.plugin.wenote.model.nativenote.manager.c.dem().au(com.tencent.mm.plugin.wenote.model.nativenote.manager.c.dem().size() - 1, false);
                AppMethodBeat.o(27103);
            }
        } else {
            AppMethodBeat.o(27103);
        }
        return;
    }

    private void bpD() {
        AppMethodBeat.i(27104);
        if (this.lzK != null) {
            this.lzK.dismiss();
            this.lzK = null;
        }
        AppMethodBeat.o(27104);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(27054);
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
        if (!bo.isNullOrNil(stringExtra)) {
            this.uTf = stringExtra.split(";");
        }
        if (getIntent().getIntExtra("note_fav_post_scene", 0) == 6) {
            this.uTi = true;
        }
        com.tencent.mm.plugin.wenote.model.d.uNa = false;
        if (this.uTf == null && this.fDy > 0) {
            gh ghVar = new gh();
            ghVar.cAH.type = 30;
            ghVar.cAH.cAO = 3;
            ghVar.cAH.cvv = this.fDy;
            com.tencent.mm.sdk.b.a.xxA.m(ghVar);
            this.uTf = bo.isNullOrNil(ghVar.cAI.path) ? null : ghVar.cAI.path.split(";");
        }
        if (this.uTf == null || this.uTf.length >= 3) {
            this.fbD = new ak();
            com.tencent.mm.plugin.wenote.model.nativenote.manager.c dem = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.dem();
            dem.iPr = new ArrayList();
            dem.uPa = this;
            dem.uPb = new aar();
            dem.uPc = 0;
            dem.uPd = 0;
            dem.uPe = 0;
            ab.i("MicroMsg.Note.NoteEditorUI", "OnCreate MainActivity, before setContentView");
            com.tencent.mm.pluginsdk.f.m(this);
            super.onCreate(bundle);
            iL(this.fDy);
            ab.i("MicroMsg.Note.NoteEditorUI", "OnCreate MainActivity, after setContentView");
            com.tencent.mm.plugin.wenote.model.a.c iVar = new com.tencent.mm.plugin.wenote.model.a.i();
            iVar.content = "";
            iVar.uNT = true;
            iVar.uNZ = false;
            if (this.uMY) {
                com.tencent.mm.plugin.wenote.model.nativenote.manager.c.dem().a(iVar);
                this.uTi = true;
            }
            this.WL = this.mController.contentView;
            this.WL.getRootView().setBackgroundColor(-1);
            this.aiB = (RecyclerView) findViewById(R.id.diu);
            this.uSL = (LinearLayout) this.WL.findViewById(R.id.dit);
            this.uSL.setVisibility(8);
            this.uTa = (LinearLayout) this.uSL.findViewById(R.id.djy);
            this.uTa.setVisibility(8);
            this.uSN = (RelativeLayout) findViewById(R.id.div);
            this.uSN.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(26994);
                    if (NoteEditorUI.this.uSO != null) {
                        NoteEditorUI.this.uSO.uPB.dismiss();
                    }
                    NoteEditorUI.this.uSN.setVisibility(8);
                    AppMethodBeat.o(26994);
                }
            });
            this.uSO = new g(this, this.uSN);
            this.uSO.uPC = this;
            this.uST = new com.tencent.mm.plugin.wenote.ui.nativenote.a.a();
            this.uST.uUf = x.db(this)[1];
            this.aiB.setLayoutManager(this.uST);
            this.aiB.setHasFixedSize(true);
            this.uSW = new a();
            this.aiB.a(this.uSW);
            this.uSJ = new k(this);
            this.uSJ.cvv = this.fDy;
            this.uSJ.uQI = this.uQI;
            this.uSJ.uQJ = this.uTi;
            if (this.uNq) {
                k kVar = this.uSJ;
                if (kVar.uQB < 0 && kVar.cvv > 0) {
                    kVar.uQL.ae(60000, 60000);
                    kVar.uQB = bo.yz();
                    kVar.uQC = "";
                }
            }
            this.uSK = new c(this.uSJ);
            this.aiB.setAdapter(this.uSK);
            if (this.uQI == 2) {
                this.aiB.setOnTouchListener(this.uTq);
            }
            this.aiB.getItemAnimator().aot = 0;
            this.aiB.getItemAnimator().aow = 0;
            this.aiB.getItemAnimator().aov = 0;
            this.aiB.getItemAnimator().aou = 120;
            ((av) this.aiB.getItemAnimator()).arN = false;
            this.uTo = com.tencent.mm.bz.a.fromDPToPix(this, 48);
            if (this.uTn) {
                ab.i("MicroMsg.Note.NoteEditorUI", "use multiselect");
                boolean z = this.uQI == 2 && this.uTi;
                int color = getResources().getColor(R.color.w6);
                e dfb = e.dfb();
                ab.i("NoteSelectManager", "onInit start");
                dfb.uRh = z;
                dfb.uRk = 14;
                dfb.uRl = 32;
                dfb.uRm = com.tencent.mm.bz.a.fromDPToPix(this, 21) - dfb.uRl;
                dfb.uRn = com.tencent.mm.bz.a.fromDPToPix(this, 40) + (dfb.uRl * 2);
                dfb.uRo = com.tencent.mm.bz.a.fromDPToPix(this, 240) + (dfb.uRl * 2);
                dfb.uRi = com.tencent.mm.bz.a.fromDPToPix(this, 22);
                dfb.uRj = com.tencent.mm.bz.a.fromDPToPix(this, 1);
                dfb.mScreenHeight = getResources().getDisplayMetrics().heightPixels;
                dfb.mScreenWidth = getResources().getDisplayMetrics().widthPixels;
                dfb.uRs = new int[]{-1, -1};
                dfb.uRt = new int[]{-1, -1};
                dfb.uRu = new int[]{-1, -1};
                dfb.uRv = new int[]{-1, -1};
                com.tencent.mm.plugin.wenote.model.nativenote.c.a aVar = new com.tencent.mm.plugin.wenote.model.nativenote.c.a(this, 2, dfb.uRi, dfb.uRj, color, dfb);
                dfb.uRw = new PopupWindow(aVar, aVar.getViewWidth(), aVar.getViewHeight(), false);
                dfb.uRw.setClippingEnabled(false);
                dfb.uRw.setAnimationStyle(R.style.a07);
                dfb.uRq = aVar.getOffsetForCursorMid();
                dfb.uRr = com.tencent.mm.bz.a.fromDPToPix(this, 6);
                com.tencent.mm.plugin.wenote.model.nativenote.c.a aVar2 = new com.tencent.mm.plugin.wenote.model.nativenote.c.a(this, 3, dfb.uRi, dfb.uRj, color, dfb);
                dfb.uRx = new PopupWindow(aVar2, aVar2.getViewWidth(), aVar.getViewHeight(), false);
                dfb.uRx.setClippingEnabled(false);
                dfb.uRx.setAnimationStyle(R.style.a06);
                aVar2 = new com.tencent.mm.plugin.wenote.model.nativenote.c.a(this, 4, dfb.uRi, dfb.uRj, color, dfb);
                dfb.uRy = new PopupWindow(aVar2, aVar2.getViewWidth(), aVar.getViewHeight(), false);
                dfb.uRy.setClippingEnabled(false);
                dfb.uRy.setAnimationStyle(R.style.a08);
                View inflate = LayoutInflater.from(this).inflate(R.layout.aj9, null);
                inflate.measure(MeasureSpec.makeMeasureSpec(0, 0), MeasureSpec.makeMeasureSpec(0, 0));
                dfb.uRz = new PopupWindow(inflate, -2, -2, false);
                dfb.uRz.setBackgroundDrawable(getResources().getDrawable(R.drawable.bij));
                dfb.uRz.setClippingEnabled(false);
                dfb.uRz.setAnimationStyle(R.style.a0_);
                dfb.uRF = (TextView) inflate.findViewById(R.id.djp);
                dfb.uRG = (TextView) inflate.findViewById(R.id.djq);
                dfb.uRH = (TextView) inflate.findViewById(R.id.djr);
                dfb.uRI = (TextView) inflate.findViewById(R.id.djs);
                dfb.uRJ = (TextView) inflate.findViewById(R.id.djw);
                dfb.uRK = (TextView) inflate.findViewById(R.id.djt);
                dfb.uRL = (TextView) inflate.findViewById(R.id.dju);
                dfb.uRM = (TextView) inflate.findViewById(R.id.djv);
                e.g(dfb.uRF, dfb.uRk);
                e.g(dfb.uRG, dfb.uRk);
                e.g(dfb.uRH, dfb.uRk);
                e.g(dfb.uRI, dfb.uRk);
                e.g(dfb.uRJ, dfb.uRk);
                e.g(dfb.uRK, dfb.uRk);
                e.g(dfb.uRL, dfb.uRk);
                e.g(dfb.uRM, dfb.uRk);
                dfb.uRF.setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View view) {
                        AppMethodBeat.i(26867);
                        ab.i("NoteSelectManager", "bold");
                        e.this.dfh();
                        AppMethodBeat.o(26867);
                    }
                });
                dfb.uRG.setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View view) {
                        AppMethodBeat.i(26868);
                        ab.i("NoteSelectManager", "unbold");
                        e.this.dfh();
                        AppMethodBeat.o(26868);
                    }
                });
                dfb.uRH.setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View view) {
                        com.tencent.mm.plugin.wenote.model.a.c cVar = null;
                        AppMethodBeat.i(26869);
                        ab.i("NoteSelectManager", "select");
                        e.this.dfh();
                        if (!e.mHasInit) {
                            ab.e("NoteSelectManager", "select: not init");
                            AppMethodBeat.o(26869);
                        } else if (e.this.dfa() != 1) {
                            ab.e("NoteSelectManager", "select: not insert");
                            e.h(e.this);
                            AppMethodBeat.o(26869);
                        } else if (com.tencent.mm.plugin.wenote.model.nativenote.manager.c.dem().Ke(e.this.uRB.coc) == null) {
                            ab.e("NoteSelectManager", "select: item is null");
                            e.h(e.this);
                            AppMethodBeat.o(26869);
                        } else {
                            RecyclerView a = e.a(e.this);
                            if (a == null) {
                                ab.e("NoteSelectManager", "select: recyclerView is null");
                                e.h(e.this);
                                AppMethodBeat.o(26869);
                                return;
                            }
                            c er = f.er(f.f(a, e.this.uRB.coc));
                            if (er == null) {
                                ab.e("NoteSelectManager", "select: rteInfo is null");
                                e.h(e.this);
                                AppMethodBeat.o(26869);
                            } else if (er.uRc != null) {
                                Editable text = er.uRc.getText();
                                if (text == null) {
                                    ab.e("NoteSelectManager", "select: text is null");
                                    e.h(e.this);
                                    AppMethodBeat.o(26869);
                                } else if (text.length() > 0) {
                                    er.uRc.ax(e.this.uRB.startOffset, true);
                                    AppMethodBeat.o(26869);
                                } else {
                                    com.tencent.mm.plugin.wenote.model.a.c Ke = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.dem().Ke(e.this.uRB.coc - 1);
                                    if (Ke != null && Ke.getType() == -3) {
                                        Ke = null;
                                    }
                                    com.tencent.mm.plugin.wenote.model.a.c Ke2 = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.dem().Ke(e.this.uRB.coc + 1);
                                    if (Ke2 == null || Ke2.getType() != -2) {
                                        cVar = Ke2;
                                    }
                                    if (Ke != null) {
                                        if (Ke.getType() == 1) {
                                            Spanned ahb = a.ahb(((com.tencent.mm.plugin.wenote.model.a.i) Ke).content);
                                            if (ahb == null) {
                                                ab.e("NoteSelectManager", "select: spanned is null");
                                                e.h(e.this);
                                                AppMethodBeat.o(26869);
                                                return;
                                            }
                                            e.this.H(e.this.uRB.coc - 1, ahb.length(), e.this.uRB.coc, 0);
                                        } else {
                                            e.this.H(e.this.uRB.coc - 1, 0, e.this.uRB.coc, 0);
                                        }
                                    } else if (cVar == null) {
                                        ab.e("NoteSelectManager", "select: no neighbor");
                                        e.h(e.this);
                                        AppMethodBeat.o(26869);
                                        return;
                                    } else if (cVar.getType() == 1) {
                                        e.this.H(e.this.uRB.coc, 0, e.this.uRB.coc + 1, 0);
                                    } else {
                                        e.this.H(e.this.uRB.coc, 0, e.this.uRB.coc + 1, 1);
                                    }
                                    e.e(e.this);
                                    e.this.ab(true, true);
                                    AppMethodBeat.o(26869);
                                }
                            } else if (er.uRd == null || er.uRe == null) {
                                ab.e("NoteSelectManager", "select: rteInfo invalid");
                                e.h(e.this);
                                AppMethodBeat.o(26869);
                            } else {
                                e.e(e.this);
                                e.this.H(e.this.uRB.coc, 0, e.this.uRB.coc, 1);
                                e.this.ab(true, true);
                                AppMethodBeat.o(26869);
                            }
                        }
                    }
                });
                dfb.uRI.setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View view) {
                        AppMethodBeat.i(26870);
                        ab.i("NoteSelectManager", "select all");
                        e.this.dfh();
                        if (e.mHasInit) {
                            int dex = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.dem().dex();
                            int dey = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.dem().dey();
                            com.tencent.mm.plugin.wenote.model.a.c Ke = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.dem().Ke(dex);
                            com.tencent.mm.plugin.wenote.model.a.c Ke2 = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.dem().Ke(dey);
                            if (Ke == null || Ke2 == null) {
                                ab.e("NoteSelectManager", "select all: item is null");
                                e.h(e.this);
                                AppMethodBeat.o(26870);
                                return;
                            }
                            int length;
                            if (Ke2.getType() == 1) {
                                Spanned ahb = a.ahb(((com.tencent.mm.plugin.wenote.model.a.i) Ke2).content);
                                if (ahb == null) {
                                    ab.e("NoteSelectManager", "select all: spanned is null");
                                    e.h(e.this);
                                    AppMethodBeat.o(26870);
                                    return;
                                }
                                length = ahb.length();
                            } else {
                                length = 1;
                            }
                            e.e(e.this);
                            e.this.H(dex, 0, dey, length);
                            e.this.dfj();
                            e.this.dfh();
                            e.j(e.this);
                            e.this.oq(false);
                            e.this.oo(false);
                            AppMethodBeat.o(26870);
                            return;
                        }
                        ab.e("NoteSelectManager", "select all: not init");
                        AppMethodBeat.o(26870);
                    }
                });
                dfb.uRJ.setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View view) {
                        AppMethodBeat.i(26859);
                        ab.i("NoteSelectManager", "delete");
                        if (!e.mHasInit || !e.this.uRh) {
                            ab.e("NoteSelectManager", "delete: not init or not editable");
                            e.this.dfh();
                            AppMethodBeat.o(26859);
                        } else if (e.l(e.this)) {
                            if (e.this.uRA != null) {
                                e.this.uRA.ddY();
                            }
                            AppMethodBeat.o(26859);
                        } else if (e.this.uRA != null) {
                            e.this.uRA.ddZ();
                            AppMethodBeat.o(26859);
                        } else {
                            e.this.dfp();
                            AppMethodBeat.o(26859);
                        }
                    }
                });
                dfb.uRK.setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View view) {
                        AppMethodBeat.i(26860);
                        ab.i("NoteSelectManager", "cut");
                        if (!e.mHasInit || !e.this.uRh) {
                            ab.e("NoteSelectManager", "cut: not init or not editable");
                            e.this.dfh();
                            AppMethodBeat.o(26860);
                        } else if (e.l(e.this)) {
                            if (e.this.uRA != null) {
                                e.this.uRA.ddY();
                            }
                            AppMethodBeat.o(26860);
                        } else {
                            e.this.dfh();
                            int dfa = e.this.dfa();
                            ArrayList arrayList;
                            if (dfa == 2) {
                                SpannableStringBuilder a = e.a(e.this, true, null, "");
                                if (bo.ac(a)) {
                                    ab.e("NoteSelectManager", "cut: selectedSpan is null or empty");
                                    e.h(e.this);
                                    AppMethodBeat.o(26860);
                                    return;
                                }
                                com.tencent.mm.plugin.wenote.model.a.i iVar = new com.tencent.mm.plugin.wenote.model.a.i();
                                iVar.content = com.tencent.mm.plugin.wenote.model.nativenote.a.b.a(a);
                                iVar.uNV = -1;
                                iVar.uNT = false;
                                arrayList = new ArrayList();
                                arrayList.add(iVar);
                                com.tencent.mm.plugin.wenote.model.nativenote.manager.f.c(ah.getContext(), arrayList);
                                AppMethodBeat.o(26860);
                            } else if (dfa == 3) {
                                arrayList = e.b(e.this, true, null, "");
                                if (arrayList == null || arrayList.size() <= 0) {
                                    ab.e("NoteSelectManager", "cut: dataList is null or empty");
                                    e.h(e.this);
                                    AppMethodBeat.o(26860);
                                    return;
                                }
                                com.tencent.mm.plugin.wenote.model.nativenote.manager.f.c(ah.getContext(), arrayList);
                                AppMethodBeat.o(26860);
                            } else {
                                ab.e("NoteSelectManager", "cut: not in select");
                                e.h(e.this);
                                AppMethodBeat.o(26860);
                            }
                        }
                    }
                });
                dfb.uRL.setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View view) {
                        AppMethodBeat.i(26861);
                        ab.i("NoteSelectManager", "copy");
                        if (!e.mHasInit) {
                            ab.e("NoteSelectManager", "copy: not init");
                            e.this.dfh();
                            AppMethodBeat.o(26861);
                        } else if (e.l(e.this)) {
                            if (e.this.uRA != null) {
                                e.this.uRA.ddY();
                            }
                            AppMethodBeat.o(26861);
                        } else {
                            e.this.dfh();
                            int dfa = e.this.dfa();
                            ArrayList arrayList;
                            if (dfa == 2) {
                                SpannableStringBuilder a = e.a(e.this, false, null, "");
                                if (bo.ac(a)) {
                                    ab.e("NoteSelectManager", "copy: selectedSpan is null or empty");
                                    e.h(e.this);
                                    AppMethodBeat.o(26861);
                                    return;
                                }
                                com.tencent.mm.plugin.wenote.model.a.i iVar = new com.tencent.mm.plugin.wenote.model.a.i();
                                iVar.content = com.tencent.mm.plugin.wenote.model.nativenote.a.b.a(a);
                                iVar.uNV = -1;
                                iVar.uNT = false;
                                arrayList = new ArrayList();
                                arrayList.add(iVar);
                                com.tencent.mm.plugin.wenote.model.nativenote.manager.f.c(ah.getContext(), arrayList);
                                AppMethodBeat.o(26861);
                            } else if (dfa == 3) {
                                arrayList = e.b(e.this, false, null, "");
                                if (arrayList == null || arrayList.size() <= 0) {
                                    ab.e("NoteSelectManager", "copy: dataList is null or empty");
                                    e.h(e.this);
                                    AppMethodBeat.o(26861);
                                    return;
                                }
                                com.tencent.mm.plugin.wenote.model.nativenote.manager.f.c(ah.getContext(), arrayList);
                                AppMethodBeat.o(26861);
                            } else {
                                ab.e("NoteSelectManager", "copy: not in select");
                                e.h(e.this);
                                AppMethodBeat.o(26861);
                            }
                        }
                    }
                });
                dfb.uRM.setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View view) {
                        AppMethodBeat.i(26862);
                        ab.i("NoteSelectManager", "paste");
                        if (!e.mHasInit || !e.this.uRh) {
                            ab.e("NoteSelectManager", "paste: not init or not editable");
                            e.this.dfh();
                            AppMethodBeat.o(26862);
                        } else if (e.l(e.this)) {
                            if (e.this.uRA != null) {
                                e.this.uRA.ddY();
                            }
                            AppMethodBeat.o(26862);
                        } else {
                            ArrayList arrayList;
                            e.this.dfh();
                            String str = "";
                            ah.getContext();
                            int deC = com.tencent.mm.plugin.wenote.model.nativenote.manager.f.deC();
                            if (deC == 2) {
                                if (e.this.uRA != null) {
                                    ah.getContext();
                                    if (com.tencent.mm.plugin.wenote.model.nativenote.manager.f.deB()) {
                                        e.this.uRA.ddW();
                                        AppMethodBeat.o(26862);
                                        return;
                                    }
                                }
                                ClipboardManager clipboardManager = (ClipboardManager) ah.getContext().getSystemService("clipboard");
                                if (clipboardManager == null) {
                                    ab.e("NoteSelectManager", "paste: clipboard is null");
                                    e.h(e.this);
                                    AppMethodBeat.o(26862);
                                    return;
                                }
                                try {
                                    String a;
                                    CharSequence text = clipboardManager.getText();
                                    if (text instanceof Spanned) {
                                        a = com.tencent.mm.plugin.wenote.model.nativenote.a.b.a((Spanned) text);
                                    } else {
                                        String charSequence = text.toString();
                                        StringBuilder stringBuilder = new StringBuilder();
                                        com.tencent.mm.plugin.wenote.model.nativenote.a.b.a(charSequence, stringBuilder, 0, charSequence.length());
                                        a = stringBuilder.toString();
                                    }
                                    if (bo.isNullOrNil(a)) {
                                        a = "";
                                    }
                                    com.tencent.mm.plugin.wenote.model.nativenote.manager.f.clearData();
                                    arrayList = null;
                                    str = a;
                                } catch (Exception e) {
                                    ab.e("NoteSelectManager", "get clipboard data error : ", e);
                                    e.h(e.this);
                                    AppMethodBeat.o(26862);
                                    return;
                                }
                            } else if (deC == 3) {
                                ArrayList deA = com.tencent.mm.plugin.wenote.model.nativenote.manager.f.deA();
                                if (deA.size() <= 0) {
                                    ab.e("NoteSelectManager", "paste: tempDataList is null or empty");
                                    e.h(e.this);
                                    AppMethodBeat.o(26862);
                                    return;
                                } else if (deA.size() == 1 && deA.get(0) != null && ((com.tencent.mm.plugin.wenote.model.a.c) deA.get(0)).getType() == 1) {
                                    arrayList = null;
                                    str = ((com.tencent.mm.plugin.wenote.model.a.i) deA.get(0)).content;
                                } else {
                                    arrayList = deA;
                                }
                            } else {
                                ab.e("NoteSelectManager", "paste: no data");
                                e.h(e.this);
                                AppMethodBeat.o(26862);
                                return;
                            }
                            if (bo.isNullOrNil(str) && (arrayList == null || arrayList.size() == 0)) {
                                ab.e("NoteSelectManager", "paste: no useful data");
                                e.h(e.this);
                                AppMethodBeat.o(26862);
                            } else if (e.this.uRA == null || !e.a(e.this, arrayList, str)) {
                                int dfa = e.this.dfa();
                                if (dfa == 1 || dfa == 2) {
                                    e.a(e.this, true, arrayList, str);
                                    AppMethodBeat.o(26862);
                                } else if (dfa == 3) {
                                    e.b(e.this, true, arrayList, str);
                                    AppMethodBeat.o(26862);
                                } else {
                                    ab.e("NoteSelectManager", "paste: invalid selection");
                                    e.h(e.this);
                                    AppMethodBeat.o(26862);
                                }
                            } else {
                                e.this.uRA.ddW();
                                AppMethodBeat.o(26862);
                            }
                        }
                    }
                });
                dfb.uRp = aVar.getViewPadding();
                dfb.uRA = this;
                dfb.uRB = new com.tencent.mm.plugin.wenote.model.nativenote.c.d();
                dfb.uRC = new com.tencent.mm.plugin.wenote.model.nativenote.c.b();
                dfb.mHandler = new ak();
                e.mHasInit = true;
                ab.i("NoteSelectManager", "onInit end");
                this.uTp = new m() {
                    public final void c(RecyclerView recyclerView, int i) {
                        AppMethodBeat.i(27042);
                        super.c(recyclerView, i);
                        switch (i) {
                            case 0:
                                e.dfb().oq(e.dfb().dfi());
                                e.dfb().op(e.dfb().dfg());
                                e.dfb().h(false, 50);
                                break;
                            case 1:
                                e.dfb().dfj();
                                e.dfb().dfh();
                                AppMethodBeat.o(27042);
                                return;
                            case 2:
                                AppMethodBeat.o(27042);
                                return;
                        }
                        AppMethodBeat.o(27042);
                    }

                    public final void a(RecyclerView recyclerView, int i, int i2) {
                        AppMethodBeat.i(27043);
                        super.a(recyclerView, i, i2);
                        if (i2 > 30) {
                            e.dfb().dfj();
                            e.dfb().dfh();
                        }
                        com.tencent.mm.plugin.wenote.model.nativenote.c.d dfd = e.dfb().dfd();
                        if ((NoteEditorUI.this.uSV || (NoteEditorUI.this.uSL != null && NoteEditorUI.this.uSL.getVisibility() == 0)) && dfd.dfa() == 2 && com.tencent.mm.plugin.wenote.model.nativenote.c.f.f(recyclerView, dfd.coc) == null) {
                            NoteEditorUI.this.deb();
                        }
                        AppMethodBeat.o(27043);
                    }
                };
                this.aiB.a(this.uTp);
            }
            if (this.lzK != null) {
                this.lzK.dismiss();
                this.lzK = null;
            }
            if (!(this.uMY || this.uTm)) {
                this.lzK = com.tencent.mm.ui.base.h.b(this.mController.ylL, getString(R.string.g2l), true, new OnCancelListener() {
                    public final void onCancel(DialogInterface dialogInterface) {
                        AppMethodBeat.i(27007);
                        if (NoteEditorUI.this.lzK != null) {
                            NoteEditorUI.this.lzK.dismiss();
                            NoteEditorUI.this.lzK = null;
                        }
                        AppMethodBeat.o(27007);
                    }
                });
            }
            if (this.uTm) {
                ab.i("MicroMsg.Note.NoteEditorUI", "open msg note,  out of date");
                com.tencent.mm.ui.base.h.b(this.mController.ylL, this.mController.ylL.getString(R.string.d84), null, true);
            }
            if (this.uTg) {
                addIconOptionMenu(1, R.string.ewm, R.raw.actionbar_icon_dark_more, new OnMenuItemClickListener() {
                    public final boolean onMenuItemClick(MenuItem menuItem) {
                        int i = 1;
                        AppMethodBeat.i(27031);
                        final com.tencent.mm.ui.widget.a.d dVar = new com.tencent.mm.ui.widget.a.d(NoteEditorUI.this.mController.ylL, 1, false);
                        dVar.rBl = new n.c() {
                            public final void a(com.tencent.mm.ui.base.l lVar) {
                                AppMethodBeat.i(27019);
                                if (NoteEditorUI.this.uQI == 1) {
                                    lVar.e(4, NoteEditorUI.this.getString(R.string.bri));
                                    NoteEditorUI.a(NoteEditorUI.this, lVar);
                                    lVar.e(3, NoteEditorUI.this.getString(R.string.dcq));
                                    AppMethodBeat.o(27019);
                                } else if (NoteEditorUI.this.uQI == 2) {
                                    int i;
                                    lVar.e(0, NoteEditorUI.this.getString(R.string.bri));
                                    if (com.tencent.mm.plugin.wenote.b.a.dfJ()) {
                                        lVar.e(7, NoteEditorUI.this.mController.ylL.getString(R.string.bq_));
                                    }
                                    if (!NoteEditorUI.this.uTi) {
                                        lVar.e(14, NoteEditorUI.this.getString(R.string.br7));
                                    }
                                    String str = (String) com.tencent.mm.model.c.c.abi().ll("100353").dru().get("Close");
                                    if (bo.isNullOrNil(str)) {
                                        i = 0;
                                    } else {
                                        i = bo.getInt(str, 0);
                                    }
                                    if (i == 0) {
                                        i = 1;
                                    } else {
                                        i = 0;
                                    }
                                    if (i != 0) {
                                        lVar.e(8, NoteEditorUI.this.mController.ylL.getString(R.string.d8b));
                                    }
                                    NoteEditorUI.a(NoteEditorUI.this, lVar);
                                    lVar.e(1, NoteEditorUI.this.getString(R.string.bo8));
                                    lVar.e(2, NoteEditorUI.this.mController.ylL.getString(R.string.p4));
                                    AppMethodBeat.o(27019);
                                } else {
                                    if (NoteEditorUI.this.uQI == 4) {
                                        lVar.e(9, NoteEditorUI.this.getString(R.string.bri));
                                        if (com.tencent.mm.plugin.wenote.b.a.dfJ()) {
                                            lVar.e(12, NoteEditorUI.this.mController.ylL.getString(R.string.bq_));
                                        }
                                        lVar.e(10, NoteEditorUI.this.getString(R.string.dcq));
                                    }
                                    AppMethodBeat.o(27019);
                                }
                            }
                        };
                        dVar.rBm = new n.d() {
                            public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                                int i2 = 0;
                                int i3 = 1;
                                AppMethodBeat.i(27029);
                                Intent intent;
                                com.tencent.mm.plugin.fav.a.h.a k;
                                gh ghVar;
                                boolean z;
                                switch (menuItem.getItemId()) {
                                    case 0:
                                        if (NoteEditorUI.this.uSM != null) {
                                            NoteEditorUI.this.uSM.a(null);
                                        }
                                        NoteEditorUI.this.lzK = com.tencent.mm.ui.base.h.b(NoteEditorUI.this.mController.ylL, NoteEditorUI.this.getString(R.string.am), true, new OnCancelListener() {
                                            public final void onCancel(DialogInterface dialogInterface) {
                                                AppMethodBeat.i(27020);
                                                if (NoteEditorUI.this.lzK != null) {
                                                    NoteEditorUI.this.lzK.dismiss();
                                                    NoteEditorUI.this.lzK = null;
                                                }
                                                AppMethodBeat.o(27020);
                                            }
                                        });
                                        com.tencent.mm.sdk.g.d.post(new Runnable() {
                                            public final void run() {
                                                AppMethodBeat.i(27022);
                                                NoteEditorUI noteEditorUI = NoteEditorUI.this;
                                                String deu = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.dem().deu();
                                                if (NoteEditorUI.ahr(deu)) {
                                                    gh ghVar = new gh();
                                                    ghVar.cAH.type = 12;
                                                    ghVar.cAH.cvv = noteEditorUI.fDy;
                                                    com.tencent.mm.sdk.b.a.xxA.m(ghVar);
                                                } else {
                                                    if (noteEditorUI.uNq || noteEditorUI.uMY) {
                                                        ab.i("MicroMsg.Note.NoteEditorUI", "syncWNNoteFavItem noteeditorui, do savewnnotefavitem");
                                                        noteEditorUI.i(deu, true, true);
                                                    } else if (noteEditorUI.uSQ) {
                                                        ab.i("MicroMsg.Note.NoteEditorUI", "syncWNNoteFavItem noteeditorui, do updateWNNoteFavitem");
                                                        noteEditorUI.i(deu, false, true);
                                                    }
                                                    noteEditorUI.uTk = true;
                                                }
                                                if (NoteEditorUI.this.lzK == null) {
                                                    AppMethodBeat.o(27022);
                                                    return;
                                                }
                                                al.d(new Runnable() {
                                                    public final void run() {
                                                        AppMethodBeat.i(27021);
                                                        NoteEditorUI.g(NoteEditorUI.this);
                                                        gh ghVar = new gh();
                                                        ghVar.cAH.type = 32;
                                                        ghVar.cAH.cvv = NoteEditorUI.this.fDy;
                                                        com.tencent.mm.sdk.b.a.xxA.m(ghVar);
                                                        boolean z = ghVar.cAI.cAY;
                                                        int i = ghVar.cAI.ret != 0 ? 1 : 0;
                                                        if (ghVar.cAI.path == null) {
                                                            com.tencent.mm.ui.base.h.bQ(NoteEditorUI.this.mController.ylL, NoteEditorUI.this.getString(R.string.br6));
                                                            AppMethodBeat.o(27021);
                                                        } else if (z) {
                                                            com.tencent.mm.ui.base.h.bQ(NoteEditorUI.this.mController.ylL, NoteEditorUI.this.getString(R.string.ak));
                                                            AppMethodBeat.o(27021);
                                                        } else if (i != 0) {
                                                            com.tencent.mm.ui.base.h.bQ(NoteEditorUI.this.mController.ylL, NoteEditorUI.this.getString(R.string.al));
                                                            AppMethodBeat.o(27021);
                                                        } else {
                                                            Intent intent = new Intent();
                                                            intent.putExtra("Select_Conv_Type", 3);
                                                            intent.putExtra("scene_from", 1);
                                                            intent.putExtra("mutil_select_is_ret", true);
                                                            intent.putExtra("select_fav_local_id", NoteEditorUI.this.fDy);
                                                            com.tencent.mm.bp.d.b(NoteEditorUI.this, ".ui.transmit.SelectConversationUI", intent, 4101);
                                                            com.tencent.mm.plugin.fav.a.h.j(NoteEditorUI.this.fDy, 1, 0);
                                                            com.tencent.mm.plugin.fav.a.h.a i2 = NoteEditorUI.this.mlz;
                                                            i2.meZ++;
                                                            AppMethodBeat.o(27021);
                                                        }
                                                    }
                                                });
                                                AppMethodBeat.o(27022);
                                            }
                                        }, "AddFavNoteSync");
                                        AppMethodBeat.o(27029);
                                        return;
                                    case 1:
                                        if (NoteEditorUI.this.uSM != null) {
                                            NoteEditorUI.this.uSM.a(null);
                                        }
                                        NoteEditorUI.this.uSJ.deV();
                                        intent = new Intent();
                                        intent.putExtra("key_fav_scene", 2);
                                        intent.putExtra("key_fav_item_id", NoteEditorUI.this.fDy);
                                        com.tencent.mm.plugin.fav.a.b.b(NoteEditorUI.this.mController.ylL, ".ui.FavTagEditUI", intent);
                                        k = NoteEditorUI.this.mlz;
                                        k.mfc++;
                                        AppMethodBeat.o(27029);
                                        return;
                                    case 2:
                                        com.tencent.mm.ui.base.h.a(NoteEditorUI.this.mController.ylL, NoteEditorUI.this.getString(R.string.p5), "", new OnClickListener() {
                                            public final void onClick(DialogInterface dialogInterface, int i) {
                                                AppMethodBeat.i(27024);
                                                final p b = com.tencent.mm.ui.base.h.b(NoteEditorUI.this.mController.ylL, NoteEditorUI.this.getString(R.string.p5), false, null);
                                                NoteEditorUI.this.uSJ.deV();
                                                gh ghVar = new gh();
                                                ghVar.cAH.type = 12;
                                                ghVar.cAH.cvv = NoteEditorUI.this.fDy;
                                                ghVar.cAH.cAM = new Runnable() {
                                                    public final void run() {
                                                        AppMethodBeat.i(27023);
                                                        NoteEditorUI.this.mlz.mfd = true;
                                                        b.dismiss();
                                                        ab.d("MicroMsg.Note.NoteEditorUI", "do del, local id %d", Long.valueOf(NoteEditorUI.this.fDy));
                                                        NoteEditorUI.this.finish();
                                                        AppMethodBeat.o(27023);
                                                    }
                                                };
                                                com.tencent.mm.sdk.b.a.xxA.m(ghVar);
                                                AppMethodBeat.o(27024);
                                            }
                                        }, null);
                                        AppMethodBeat.o(27029);
                                        return;
                                    case 3:
                                        cl clVar = new cl();
                                        com.tencent.mm.pluginsdk.model.e.a(clVar, NoteEditorUI.this.cvx);
                                        com.tencent.mm.sdk.b.a.xxA.m(clVar);
                                        com.tencent.mm.plugin.fav.ui.c.a(clVar.cvB.ret, NoteEditorUI.this, NoteEditorUI.this.mUw);
                                        AppMethodBeat.o(27029);
                                        return;
                                    case 4:
                                        intent = new Intent();
                                        intent.putExtra("Select_Conv_Type", 3);
                                        intent.putExtra("select_is_ret", true);
                                        intent.putExtra("mutil_select_is_ret", true);
                                        intent.putExtra("Retr_Msg_Type", 2);
                                        intent.putExtra("Retr_Msg_Id", NoteEditorUI.this.cvx);
                                        com.tencent.mm.bp.d.b(NoteEditorUI.this, ".ui.transmit.SelectConversationUI", intent, 4096);
                                        k = NoteEditorUI.this.mlz;
                                        k.meZ++;
                                        AppMethodBeat.o(27029);
                                        return;
                                    case 5:
                                        NoteEditorUI.this.uSJ.deV();
                                        q qVar = new q();
                                        qVar.uOr = NoteEditorUI.this.uQI == 1;
                                        qVar.uOv = NoteEditorUI.this.uTb;
                                        qVar.uOu = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.dem().ahf(NoteEditorUI.this.getString(R.string.g16));
                                        qVar.uOw = NoteEditorUI.this.aaF;
                                        qVar.uOx = NoteEditorUI.this.uTc;
                                        if (NoteEditorUI.this.uQI == 1) {
                                            qVar.uOt = NoteEditorUI.this.cvx;
                                            if (NoteEditorUI.this.uTl) {
                                                qVar.mgQ = true;
                                                com.tencent.mm.plugin.report.service.h.pYm.e(14790, Integer.valueOf(3));
                                            } else {
                                                qVar.mgQ = false;
                                                com.tencent.mm.plugin.report.service.h.pYm.e(14790, Integer.valueOf(2));
                                            }
                                        } else {
                                            com.tencent.mm.plugin.report.service.h.pYm.e(14790, Integer.valueOf(1));
                                            qVar.uOs = NoteEditorUI.this.fDy;
                                        }
                                        com.tencent.mm.plugin.wenote.model.nativenote.manager.h.deH().a(qVar);
                                        com.tencent.mm.ui.widget.snackbar.b.i(NoteEditorUI.this, NoteEditorUI.this.getString(R.string.g17));
                                        AppMethodBeat.o(27029);
                                        return;
                                    case 6:
                                        com.tencent.mm.plugin.wenote.model.nativenote.manager.h.deH().a(null);
                                        com.tencent.mm.ui.widget.snackbar.b.i(NoteEditorUI.this, NoteEditorUI.this.getString(R.string.g11));
                                        AppMethodBeat.o(27029);
                                        return;
                                    case 7:
                                        com.tencent.mm.plugin.fav.a.h.j(NoteEditorUI.this.fDy, 0, 0);
                                        if (NoteEditorUI.this.uMY || NoteEditorUI.this.uNq) {
                                            i2 = 1;
                                        } else if (NoteEditorUI.this.uSQ && !com.tencent.mm.plugin.wenote.model.nativenote.manager.c.dem().deu().equals(NoteEditorUI.this.uSS)) {
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
                                        ghVar = new gh();
                                        ghVar.cAH.type = 30;
                                        ghVar.cAH.cAO = 1;
                                        ghVar.cAH.cvv = NoteEditorUI.this.fDy;
                                        com.tencent.mm.sdk.b.a.xxA.m(ghVar);
                                        String str = ghVar.cAI.path;
                                        NoteEditorUI.this.lZg = ghVar.cAI.thumbPath;
                                        if (bo.isNullOrNil(str)) {
                                            NoteEditorUI.this.fbD.post(new Runnable() {
                                                public final void run() {
                                                    AppMethodBeat.i(27025);
                                                    Toast.makeText(NoteEditorUI.this, NoteEditorUI.this.getString(R.string.egu), 0).show();
                                                    AppMethodBeat.o(27025);
                                                }
                                            });
                                            AppMethodBeat.o(27029);
                                            return;
                                        }
                                        NoteEditorUI.b(NoteEditorUI.this, str);
                                        k = NoteEditorUI.this.mlz;
                                        k.mfa++;
                                        AppMethodBeat.o(27029);
                                        return;
                                    case 8:
                                        NoteEditorUI.this.lzK = com.tencent.mm.ui.base.h.b(NoteEditorUI.this.mController.ylL, NoteEditorUI.this.getString(R.string.g2l), true, new OnCancelListener() {
                                            public final void onCancel(DialogInterface dialogInterface) {
                                                AppMethodBeat.i(27026);
                                                if (NoteEditorUI.this.lzK != null) {
                                                    NoteEditorUI.this.lzK.dismiss();
                                                    NoteEditorUI.this.lzK = null;
                                                }
                                                AppMethodBeat.o(27026);
                                            }
                                        });
                                        ghVar = new gh();
                                        ghVar.cAH.type = 32;
                                        ghVar.cAH.cvv = NoteEditorUI.this.fDy;
                                        ghVar.cAH.cvC = com.tencent.mm.plugin.wenote.model.c.ddG().uMN.uMZ;
                                        com.tencent.mm.sdk.b.a.xxA.m(ghVar);
                                        z = ghVar.cAI.cAY;
                                        com.tencent.mm.plugin.report.service.h hVar;
                                        Object[] objArr;
                                        if (ghVar.cAI.path == null) {
                                            NoteEditorUI.g(NoteEditorUI.this);
                                            Toast.makeText(NoteEditorUI.this.mController.ylL, NoteEditorUI.this.mController.ylL.getString(R.string.d87), 1).show();
                                            hVar = com.tencent.mm.plugin.report.service.h.pYm;
                                            objArr = new Object[5];
                                            objArr[0] = Integer.valueOf(0);
                                            objArr[1] = Integer.valueOf(0);
                                            objArr[2] = Integer.valueOf(0);
                                            objArr[3] = Integer.valueOf(5);
                                            if (!NoteEditorUI.this.uTi) {
                                                i3 = 0;
                                            }
                                            objArr[4] = Integer.valueOf(i3);
                                            hVar.e(14811, objArr);
                                            AppMethodBeat.o(27029);
                                            return;
                                        } else if (z) {
                                            NoteEditorUI.g(NoteEditorUI.this);
                                            Toast.makeText(NoteEditorUI.this.mController.ylL, NoteEditorUI.this.mController.ylL.getString(R.string.d87), 1).show();
                                            hVar = com.tencent.mm.plugin.report.service.h.pYm;
                                            objArr = new Object[5];
                                            objArr[0] = Integer.valueOf(0);
                                            objArr[1] = Integer.valueOf(0);
                                            objArr[2] = Integer.valueOf(0);
                                            objArr[3] = Integer.valueOf(5);
                                            if (!NoteEditorUI.this.uTi) {
                                                i3 = 0;
                                            }
                                            objArr[4] = Integer.valueOf(i3);
                                            hVar.e(14811, objArr);
                                            AppMethodBeat.o(27029);
                                            return;
                                        } else {
                                            NoteEditorUI.this.fbD.post(new Runnable() {
                                                public final void run() {
                                                    AppMethodBeat.i(27027);
                                                    NoteEditorUI.this.uSJ.deV();
                                                    com.tencent.mm.plugin.wenote.model.a.c aVar = new com.tencent.mm.plugin.wenote.model.a.a();
                                                    aVar.uNT = false;
                                                    aVar.uNZ = false;
                                                    com.tencent.mm.plugin.wenote.model.nativenote.manager.c.dem().a(aVar);
                                                    int i = NoteEditorUI.this.uSJ.uQI;
                                                    NoteEditorUI.this.uSJ.uQI = 3;
                                                    com.tencent.mm.plugin.wenote.model.h.JW(i);
                                                    AppMethodBeat.o(27027);
                                                }
                                            });
                                            AppMethodBeat.o(27029);
                                            return;
                                        }
                                    case 9:
                                        ghVar = new gh();
                                        ghVar.cAH.type = 32;
                                        ghVar.cAH.cvv = NoteEditorUI.this.fDy;
                                        ghVar.cAH.cvC = com.tencent.mm.plugin.wenote.model.c.ddG().uMN.uMZ;
                                        com.tencent.mm.sdk.b.a.xxA.m(ghVar);
                                        z = ghVar.cAI.cAY;
                                        if (ghVar.cAI.ret != 0) {
                                            i2 = 1;
                                        }
                                        if (ghVar.cAI.path == null) {
                                            com.tencent.mm.ui.base.h.bQ(NoteEditorUI.this.mController.ylL, NoteEditorUI.this.getString(R.string.br6));
                                            AppMethodBeat.o(27029);
                                            return;
                                        } else if (z) {
                                            com.tencent.mm.ui.base.h.bQ(NoteEditorUI.this.mController.ylL, NoteEditorUI.this.getString(R.string.ak));
                                            AppMethodBeat.o(27029);
                                            return;
                                        } else if (i2 != 0) {
                                            com.tencent.mm.ui.base.h.bQ(NoteEditorUI.this.mController.ylL, NoteEditorUI.this.getString(R.string.al));
                                            AppMethodBeat.o(27029);
                                            return;
                                        } else {
                                            intent = new Intent();
                                            intent.putExtra("Select_Conv_Type", 3);
                                            intent.putExtra("scene_from", 1);
                                            intent.putExtra("mutil_select_is_ret", true);
                                            intent.putExtra("select_fav_local_id", NoteEditorUI.this.fDy);
                                            intent.putExtra("Retr_fav_xml_str", com.tencent.mm.plugin.wenote.model.c.ddG().uMN.ddH());
                                            com.tencent.mm.bp.d.b(NoteEditorUI.this, ".ui.transmit.SelectConversationUI", intent, 4355);
                                            k = NoteEditorUI.this.mlz;
                                            k.meZ++;
                                            AppMethodBeat.o(27029);
                                            return;
                                        }
                                    case 10:
                                        com.tencent.mm.plugin.wenote.model.h.br(NoteEditorUI.this.mController.ylL, NoteEditorUI.this.lsy);
                                        AppMethodBeat.o(27029);
                                        return;
                                    case 11:
                                        AppMethodBeat.o(27029);
                                        return;
                                    case 12:
                                        if (bo.isNullOrNil(NoteEditorUI.this.uTj)) {
                                            NoteEditorUI.this.fbD.post(new Runnable() {
                                                public final void run() {
                                                    AppMethodBeat.i(27028);
                                                    Toast.makeText(NoteEditorUI.this, NoteEditorUI.this.getString(R.string.egu), 0).show();
                                                    AppMethodBeat.o(27028);
                                                }
                                            });
                                            AppMethodBeat.o(27029);
                                            return;
                                        }
                                        k = NoteEditorUI.this.mlz;
                                        k.mfa++;
                                        NoteEditorUI.b(NoteEditorUI.this, NoteEditorUI.this.uTj);
                                        AppMethodBeat.o(27029);
                                        return;
                                    case 13:
                                        intent = new Intent();
                                        intent.putExtra("k_expose_msg_id", NoteEditorUI.this.lsy);
                                        if (NoteEditorUI.this.uTf != null && NoteEditorUI.this.uTf.length > 1) {
                                            intent.putExtra("k_username", NoteEditorUI.this.uTf[1]);
                                        }
                                        intent.putExtra("showShare", NoteEditorUI.this.uTg);
                                        intent.putExtra("rawUrl", String.format("https://weixin110.qq.com/security/readtemplate?t=weixin_report/w_type&scene=%d#wechat_redirect", new Object[]{Integer.valueOf(33)}));
                                        com.tencent.mm.bp.d.b(NoteEditorUI.this.mController.ylL, "webview", ".ui.tools.WebViewUI", intent);
                                        AppMethodBeat.o(27029);
                                        return;
                                    case 14:
                                        com.tencent.mm.plugin.fav.ui.g.a(NoteEditorUI.this, NoteEditorUI.this.fDy, NoteEditorUI.this.mlz);
                                        break;
                                }
                                AppMethodBeat.o(27029);
                            }
                        };
                        if (NoteEditorUI.this.uQI == 2) {
                            com.tencent.mm.plugin.wenote.model.nativenote.manager.c dem = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.dem();
                            if (dem.uPe <= 0 && dem.uPd <= 0) {
                                i = 0;
                            }
                            if (i == 0) {
                                AppMethodBeat.o(27031);
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
                                e.dfb().dff();
                            }
                        }
                        NoteEditorUI.this.fbD.postDelayed(new Runnable() {
                            public final void run() {
                                AppMethodBeat.i(27030);
                                dVar.cpD();
                                AppMethodBeat.o(27030);
                            }
                        }, 100);
                        AppMethodBeat.o(27031);
                        return false;
                    }
                });
            }
            if (this.uTi) {
                setMMTitle(getString(R.string.bsc));
            } else {
                setMMTitle(getString(R.string.bsd));
            }
            pP(true);
            setBackBtn(new OnMenuItemClickListener() {
                public final boolean onMenuItemClick(MenuItem menuItem) {
                    AppMethodBeat.i(27039);
                    if (NoteEditorUI.K(NoteEditorUI.this)) {
                        NoteEditorUI.L(NoteEditorUI.this);
                        NoteEditorUI.this.finish();
                        AppMethodBeat.o(27039);
                    } else {
                        AppMethodBeat.o(27039);
                    }
                    return true;
                }
            }, R.raw.actionbar_icon_dark_back);
            com.tencent.mm.pluginsdk.f.n(this);
            if (this.uMY) {
                g(true, 300);
                af(1, 0);
            }
            if (this.uQI == 2 && this.uTi) {
                this.uSM = new c();
                c cVar = this.uSM;
                LinearLayout linearLayout = this.uSL;
                cVar.gLe = linearLayout;
                k.deT().uQD = cVar;
                cVar.uTL = (LinearLayout) linearLayout.findViewById(R.id.djy);
                cVar.uTK = (ImageButton) linearLayout.findViewById(R.id.dil);
                cVar.uTM = (ImageButton) linearLayout.findViewById(R.id.dih);
                cVar.uTN = (ImageButton) linearLayout.findViewById(R.id.dig);
                cVar.uTO = (ImageButton) linearLayout.findViewById(R.id.dif);
                cVar.uTP = (ImageButton) linearLayout.findViewById(R.id.dii);
                cVar.uTQ = (LinearLayout) cVar.uTL.findViewById(R.id.dk0);
                cVar.uTR = (LinearLayout) cVar.uTL.findViewById(R.id.djz);
                cVar.uTS = (LinearLayout) cVar.uTL.findViewById(R.id.dk3);
                cVar.uTT = (LinearLayout) cVar.uTL.findViewById(R.id.dk4);
                cVar.uTU = (LinearLayout) cVar.uTL.findViewById(R.id.dk5);
                cVar.uTK.setOnClickListener(new com.tencent.mm.plugin.wenote.ui.nativenote.c.AnonymousClass1(this));
                cVar.uTO.setOnClickListener(new com.tencent.mm.plugin.wenote.ui.nativenote.c.AnonymousClass6(this));
                cVar.uTP.setOnClickListener(new com.tencent.mm.plugin.wenote.ui.nativenote.c.AnonymousClass7(this, this));
                cVar.uTM.setOnClickListener(new com.tencent.mm.plugin.wenote.ui.nativenote.c.AnonymousClass8(this));
                cVar.uTN.setOnClickListener(new com.tencent.mm.plugin.wenote.ui.nativenote.c.AnonymousClass9(this));
                cVar.uTU.setOnClickListener(new com.tencent.mm.plugin.wenote.ui.nativenote.c.AnonymousClass10(this));
                cVar.uTQ.setOnClickListener(new com.tencent.mm.plugin.wenote.ui.nativenote.c.AnonymousClass11(this));
                cVar.uTR.setOnClickListener(new com.tencent.mm.plugin.wenote.ui.nativenote.c.AnonymousClass12(this));
                cVar.uTS.setOnClickListener(new com.tencent.mm.plugin.wenote.ui.nativenote.c.AnonymousClass13(this));
                cVar.uTT.setOnClickListener(new com.tencent.mm.plugin.wenote.ui.nativenote.c.AnonymousClass2(this));
                getWindow().setSoftInputMode(18);
            } else {
                this.uSL.setVisibility(8);
            }
            this.aiB.getViewTreeObserver().addOnGlobalLayoutListener(this.aeL);
            this.uTh = System.currentTimeMillis();
            ab.i("MicroMsg.Note.NoteEditorUI", "startnoteeditorui, oncreate , currenttime is %d", Long.valueOf(this.uTh));
            aw.Rg().a(921, (f) this);
            AppMethodBeat.o(27054);
            return;
        }
        AppMethodBeat.o(27054);
    }

    public final void ddY() {
        AppMethodBeat.i(27056);
        com.tencent.mm.ui.base.h.b(this.mController.ylL, getString(R.string.d88), null, true);
        AppMethodBeat.o(27056);
    }

    public final Context dfO() {
        return this.mController.ylL;
    }

    public final void dea() {
        AppMethodBeat.i(27080);
        Toast.makeText(this.mController.ylL, getString(R.string.d85), 0).show();
        AppMethodBeat.o(27080);
    }

    public final void deE() {
        AppMethodBeat.i(27094);
        com.tencent.mm.plugin.wenote.model.nativenote.manager.f.c(this.mController.ylL, com.tencent.mm.plugin.wenote.model.nativenote.manager.c.dem().dev());
        AppMethodBeat.o(27094);
    }

    public final void deF() {
        AppMethodBeat.i(27095);
        com.tencent.mm.plugin.wenote.model.nativenote.manager.f.c(this.mController.ylL, com.tencent.mm.plugin.wenote.model.nativenote.manager.c.dem().dev());
        deD();
        AppMethodBeat.o(27095);
    }

    static /* synthetic */ void aa(NoteEditorUI noteEditorUI) {
        AppMethodBeat.i(27110);
        aw.RS().aa(new Runnable() {
            public final void run() {
                AppMethodBeat.i(26998);
                try {
                    int iT = ((LinearLayoutManager) NoteEditorUI.this.aiB.getLayoutManager()).iT();
                    com.tencent.mm.plugin.wenote.model.a.c Ke = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.dem().Ke(iT);
                    if (!(Ke == null || Ke.getType() != 4 || ((l) Ke).uOp)) {
                        NoteEditorUI.this.JX(iT);
                    }
                    AppMethodBeat.o(26998);
                } catch (NullPointerException e) {
                    AppMethodBeat.o(26998);
                }
            }
        });
        AppMethodBeat.o(27110);
    }
}
