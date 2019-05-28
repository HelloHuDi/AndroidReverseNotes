package com.tencent.mm.plugin.luckymoney.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.m;
import android.support.v7.widget.RecyclerView.v;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.luckymoney.model.f;
import com.tencent.mm.protocal.protobuf.aoj;
import com.tencent.mm.protocal.protobuf.atb;
import com.tencent.mm.protocal.protobuf.ty;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.ui.e;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@com.tencent.mm.ui.base.a(1)
public class LuckyMoneyPickEnvelopeUI extends MMActivity {
    private View Ek;
    private Dialog gII;
    private boolean isLoading = false;
    private int nSY = 0;
    private View oaV;
    private LuckyMoneyEnvelopeTouchRecyclerView ogP;
    private a ogQ;
    private com.tencent.mm.plugin.luckymoney.scaledLayout.c ogR;
    private List<b> ogS = new ArrayList();
    private int ogT = -1;
    private boolean ogU = false;
    private String ogV;
    private com.tencent.mm.plugin.luckymoney.scaledLayout.a ogW;

    class a extends android.support.v7.widget.RecyclerView.a<c> {
        private a() {
        }

        /* synthetic */ a(LuckyMoneyPickEnvelopeUI luckyMoneyPickEnvelopeUI, byte b) {
            this();
        }

        public final int getItemCount() {
            AppMethodBeat.i(42918);
            int size = LuckyMoneyPickEnvelopeUI.this.ogS.size();
            AppMethodBeat.o(42918);
            return size;
        }

        public final long getItemId(int i) {
            AppMethodBeat.i(42919);
            long hashCode = (long) ((b) LuckyMoneyPickEnvelopeUI.this.ogS.get(i)).hashCode();
            AppMethodBeat.o(42919);
            return hashCode;
        }
    }

    static class b {
        public boolean kfW;
        public atb nZq;

        private b() {
            this.kfW = false;
        }

        /* synthetic */ b(byte b) {
            this();
        }
    }

    class c extends v {
        ImageView eks;
        private Dialog gII = null;
        TextView gtb;
        TextView hrg;
        TextView jXx;
        ImageView ohc;
        RadioButton ohd;
        View ohe;
        ImageView ohf;
        ProgressBar ohg;
        TextView ohh;

        /* renamed from: com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPickEnvelopeUI$c$1 */
        class AnonymousClass1 implements OnClickListener {
            final /* synthetic */ b ohb;

            AnonymousClass1(b bVar) {
                this.ohb = bVar;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(42922);
                c.a(c.this, this.ohb.nZq);
                AppMethodBeat.o(42922);
            }
        }

        public c(View view) {
            super(view);
            AppMethodBeat.i(42925);
            this.ohc = (ImageView) view.findViewById(R.id.cyo);
            this.gtb = (TextView) view.findViewById(R.id.cyt);
            this.hrg = (TextView) view.findViewById(R.id.cyv);
            this.ohd = (RadioButton) view.findViewById(R.id.cyu);
            this.eks = (ImageView) view.findViewById(R.id.cyq);
            this.jXx = (TextView) view.findViewById(R.id.cyr);
            this.ohe = view.findViewById(R.id.cyw);
            this.ohf = (ImageView) view.findViewById(R.id.cyx);
            this.ohg = (ProgressBar) view.findViewById(R.id.cyy);
            this.ohh = (TextView) view.findViewById(R.id.cyz);
            AppMethodBeat.o(42925);
        }

        /* Access modifiers changed, original: final */
        public final void a(atb atb, boolean z) {
            AppMethodBeat.i(42926);
            ab.i("MicroMsg.LuckyMoneyPickEnvelopeUI", "try load cover image");
            if (z) {
                this.ohf.setVisibility(8);
                this.ohg.setVisibility(0);
                this.ohh.setVisibility(8);
            }
            ((com.tencent.mm.plugin.luckymoney.a.a) g.K(com.tencent.mm.plugin.luckymoney.a.a.class)).a(this.ohc, atb, new com.tencent.mm.plugin.luckymoney.a.a.a() {
                public final void iH(final boolean z) {
                    AppMethodBeat.i(42924);
                    ab.i("MicroMsg.LuckyMoneyPickEnvelopeUI", "load ok: %s", Boolean.valueOf(z));
                    AnonymousClass1 anonymousClass1 = new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(42923);
                            if (c.this.gII != null && c.this.gII.isShowing()) {
                                c.this.gII.dismiss();
                            }
                            if (z) {
                                c.this.ohe.setVisibility(8);
                                AppMethodBeat.o(42923);
                                return;
                            }
                            c.this.ohe.setVisibility(0);
                            c.this.ohf.setVisibility(0);
                            c.this.ohg.setVisibility(8);
                            c.this.ohh.setVisibility(0);
                            AppMethodBeat.o(42923);
                        }
                    };
                    if (al.isMainThread()) {
                        anonymousClass1.run();
                        AppMethodBeat.o(42924);
                        return;
                    }
                    c.this.ohe.post(anonymousClass1);
                    AppMethodBeat.o(42924);
                }
            });
            AppMethodBeat.o(42926);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public LuckyMoneyPickEnvelopeUI() {
        AppMethodBeat.i(42928);
        AppMethodBeat.o(42928);
    }

    static /* synthetic */ void i(LuckyMoneyPickEnvelopeUI luckyMoneyPickEnvelopeUI) {
        AppMethodBeat.i(42936);
        luckyMoneyPickEnvelopeUI.bMJ();
        AppMethodBeat.o(42936);
    }

    public final void initView() {
        AppMethodBeat.i(42930);
        this.ogP = (LuckyMoneyEnvelopeTouchRecyclerView) findViewById(R.id.cz0);
        this.Ek = findViewById(R.id.cz1);
        this.ogQ = new a(this, (byte) 0);
        this.ogQ.jR();
        this.ogP.setAdapter(this.ogQ);
        this.ogP.setItemAnimator(null);
        this.ogP.setItemViewCacheSize(-1);
        this.ogR = new com.tencent.mm.plugin.luckymoney.scaledLayout.c(this) {
            public final void bLV() {
                AppMethodBeat.i(42907);
                super.bLV();
                this.obq -= 31.0f;
                AppMethodBeat.o(42907);
            }
        };
        this.ogR.bLS();
        this.ogP.setLayoutManager(this.ogR);
        this.ogW = new com.tencent.mm.plugin.luckymoney.scaledLayout.a();
        this.ogW.context = this;
        this.ogW.i(this.ogP);
        this.ogP.oeF = new com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyEnvelopeTouchRecyclerView.a() {
            public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
                AppMethodBeat.i(42908);
                if (motionEvent.getAction() == 0) {
                    LuckyMoneyPickEnvelopeUI luckyMoneyPickEnvelopeUI = LuckyMoneyPickEnvelopeUI.this;
                    LuckyMoneyPickEnvelopeUI.this.ogW;
                    luckyMoneyPickEnvelopeUI.oaV = com.tencent.mm.plugin.luckymoney.scaledLayout.a.h(LuckyMoneyPickEnvelopeUI.this.ogR);
                    LuckyMoneyPickEnvelopeUI.this.ogW.oaV = LuckyMoneyPickEnvelopeUI.this.oaV;
                }
                AppMethodBeat.o(42908);
                return false;
            }
        };
        this.ogP.a((m) new m() {
            public final void c(RecyclerView recyclerView, int i) {
                AppMethodBeat.i(42909);
                super.c(recyclerView, i);
                AppMethodBeat.o(42909);
            }

            public final void a(RecyclerView recyclerView, int i, int i2) {
                AppMethodBeat.i(42910);
                super.a(recyclerView, i, i2);
                ab.v("MicroMsg.LuckyMoneyPickEnvelopeUI", "scroll last vispos: %s", Integer.valueOf(LuckyMoneyPickEnvelopeUI.this.ogR.iS()));
                if (!LuckyMoneyPickEnvelopeUI.this.isLoading && LuckyMoneyPickEnvelopeUI.this.nSY == 1 && r0 == LuckyMoneyPickEnvelopeUI.this.ogQ.getItemCount() - 1) {
                    ab.d("MicroMsg.LuckyMoneyPickEnvelopeUI", "trigger load more: %s", Integer.valueOf(r0));
                    LuckyMoneyPickEnvelopeUI.i(LuckyMoneyPickEnvelopeUI.this);
                }
                AppMethodBeat.o(42910);
            }
        });
        AppMethodBeat.o(42930);
    }

    public void onDestroy() {
        AppMethodBeat.i(42931);
        super.onDestroy();
        AppMethodBeat.o(42931);
    }

    public final int getLayoutId() {
        return R.layout.aah;
    }

    private void bMJ() {
        AppMethodBeat.i(42932);
        ab.i("MicroMsg.LuckyMoneyPickEnvelopeUI", "do get show source: %s", this.ogV);
        this.gII = h.a(this.mController.ylL, 3, (int) R.style.kd, getString(R.string.cn5), false, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
            }
        });
        this.isLoading = true;
        f bLp = f.bLp();
        bLp.b(new com.tencent.mm.plugin.luckymoney.model.c(this.ogV));
        bLp.a(new com.tencent.mm.wallet_core.c.a.a<aoj>() {
            public final /* synthetic */ void bX(Object obj) {
                AppMethodBeat.i(42911);
                aoj aoj = (aoj) obj;
                if (LuckyMoneyPickEnvelopeUI.this.gII != null && LuckyMoneyPickEnvelopeUI.this.gII.isShowing()) {
                    LuckyMoneyPickEnvelopeUI.this.gII.dismiss();
                }
                LuckyMoneyPickEnvelopeUI.this.isLoading = false;
                ab.i("MicroMsg.LuckyMoneyPickEnvelopeUI", "do get show source net callback");
                if (aoj != null) {
                    ab.i("MicroMsg.LuckyMoneyPickEnvelopeUI", "retcode: %s", Integer.valueOf(aoj.kCl));
                    if (aoj.kCl == 0) {
                        LuckyMoneyPickEnvelopeUI.this.nSY = aoj.wsC;
                        LuckyMoneyPickEnvelopeUI.this.ogV = aoj.wsB;
                        ab.i("MicroMsg.LuckyMoneyPickEnvelopeUI", "hasMore: %s, pagedata: %s", Integer.valueOf(LuckyMoneyPickEnvelopeUI.this.nSY), LuckyMoneyPickEnvelopeUI.this.ogV);
                        LuckyMoneyPickEnvelopeUI.a(LuckyMoneyPickEnvelopeUI.this, aoj);
                        AppMethodBeat.o(42911);
                        return;
                    }
                    e.atC(aoj.kCm);
                    AppMethodBeat.o(42911);
                    return;
                }
                e.aj(LuckyMoneyPickEnvelopeUI.this.mController.ylL, "");
                AppMethodBeat.o(42911);
            }

            public final /* synthetic */ void bY(Object obj) {
                AppMethodBeat.i(42912);
                aoj aoj = (aoj) obj;
                if (LuckyMoneyPickEnvelopeUI.this.gII != null && LuckyMoneyPickEnvelopeUI.this.gII.isShowing()) {
                    LuckyMoneyPickEnvelopeUI.this.gII.dismiss();
                }
                ab.i("MicroMsg.LuckyMoneyPickEnvelopeUI", "get show source cache callback");
                if (aoj != null) {
                    ab.i("MicroMsg.LuckyMoneyPickEnvelopeUI", "retcode: %s", Integer.valueOf(aoj.kCl));
                    if (aoj.kCl == 0) {
                        LuckyMoneyPickEnvelopeUI.a(LuckyMoneyPickEnvelopeUI.this, aoj);
                    }
                }
                AppMethodBeat.o(42912);
            }
        });
        AppMethodBeat.o(42932);
    }

    private void a(aoj aoj) {
        AppMethodBeat.i(42933);
        ab.i("MicroMsg.LuckyMoneyPickEnvelopeUI", "try show illegal msg");
        if (bo.isNullOrNil(aoj.nWx)) {
            AppMethodBeat.o(42933);
            return;
        }
        List arrayList = new ArrayList(bo.hT((String) g.RP().Ry().get(com.tencent.mm.storage.ac.a.USERINFO_LUCKY_MONEY_ENVELOPE_ILLEGAL2_STRING_SYNC, (Object) ""), ","));
        int i = 0;
        for (String str : aoj.wsD) {
            int i2;
            if (arrayList.contains(str)) {
                i2 = i;
            } else {
                arrayList.add(str);
                ab.i("MicroMsg.LuckyMoneyPickEnvelopeUI", "show illegal id: %s", str);
                i2 = 1;
            }
            i = i2;
        }
        if (i != 0) {
            g.RP().Ry().set(com.tencent.mm.storage.ac.a.USERINFO_LUCKY_MONEY_ENVELOPE_ILLEGAL2_STRING_SYNC, bo.c(arrayList, ","));
            h.a((Context) this, aoj.nWx, "", getString(R.string.r4), false, new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                }
            });
        }
        AppMethodBeat.o(42933);
    }

    private void b(aoj aoj) {
        AppMethodBeat.i(42934);
        ab.i("MicroMsg.LuckyMoneyPickEnvelopeUI", "update by resp");
        this.ogU = aoj.wsE == 1;
        a(aoj);
        if (aoj.wsA != null) {
            if (aoj.wsA.isEmpty()) {
                this.Ek.setVisibility(0);
                this.ogP.setVisibility(8);
            } else {
                ab.i("MicroMsg.LuckyMoneyPickEnvelopeUI", "list size: %s", Integer.valueOf(aoj.wsA.size()));
                Iterator it = aoj.wsA.iterator();
                int i = 0;
                while (it.hasNext()) {
                    atb atb = (atb) it.next();
                    b bVar = new b();
                    bVar.nZq = atb;
                    boolean z = atb.wwT == 1 && atb.wwS != 1;
                    bVar.kfW = z;
                    this.ogS.add(bVar);
                    if (bVar.kfW) {
                        this.ogT = i;
                    }
                    i++;
                }
            }
        }
        this.ogQ.aop.notifyChanged();
        this.ogP.post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(42913);
                if (LuckyMoneyPickEnvelopeUI.this.ogT >= 0 && LuckyMoneyPickEnvelopeUI.this.ogT < LuckyMoneyPickEnvelopeUI.this.ogQ.getItemCount()) {
                    ab.i("MicroMsg.LuckyMoneyPickEnvelopeUI", "scroll to pos: %s", Integer.valueOf(LuckyMoneyPickEnvelopeUI.this.ogT));
                    LuckyMoneyEnvelopeTouchRecyclerView m = LuckyMoneyPickEnvelopeUI.this.ogP;
                    com.tencent.mm.plugin.luckymoney.scaledLayout.c c = LuckyMoneyPickEnvelopeUI.this.ogR;
                    int qY = c.qY(LuckyMoneyPickEnvelopeUI.this.ogT);
                    if (c.mOrientation == 1) {
                        m.scrollBy(0, qY);
                        AppMethodBeat.o(42913);
                        return;
                    }
                    m.scrollBy(qY, 0);
                }
                AppMethodBeat.o(42913);
            }
        });
        AppMethodBeat.o(42934);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(42929);
        this.yll = true;
        super.onCreate(bundle);
        dyb();
        xE(Color.parseColor("#f1f1f1"));
        initView();
        setMMTitle((int) R.string.csj);
        byte[] byteArrayExtra = getIntent().getByteArrayExtra(com.tencent.mm.ui.e.f.yfY);
        if (byteArrayExtra != null) {
            try {
                aoj aoj = (aoj) new aoj().parseFrom(byteArrayExtra);
                if (aoj.kCl == 0) {
                    this.ogV = aoj.wsB;
                    this.nSY = aoj.wsC;
                    b(aoj);
                } else {
                    bMJ();
                }
            } catch (IOException e) {
                ab.printErrStackTrace("MicroMsg.LuckyMoneyPickEnvelopeUI", e, "", new Object[0]);
            }
            setBackBtn(new OnMenuItemClickListener() {
                public final boolean onMenuItemClick(MenuItem menuItem) {
                    AppMethodBeat.i(42902);
                    LuckyMoneyPickEnvelopeUI.this.finish();
                    AppMethodBeat.o(42902);
                    return false;
                }
            });
            a(1, getString(R.string.csg), (OnMenuItemClickListener) new OnMenuItemClickListener() {
                public final boolean onMenuItemClick(MenuItem menuItem) {
                    String str;
                    AppMethodBeat.i(42906);
                    ab.i("MicroMsg.LuckyMoneyPickEnvelopeUI", "click save: %s", Integer.valueOf(LuckyMoneyPickEnvelopeUI.this.ogT));
                    String str2 = AppEventsConstants.EVENT_PARAM_VALUE_NO;
                    if (LuckyMoneyPickEnvelopeUI.this.ogT >= 0 && LuckyMoneyPickEnvelopeUI.this.ogT < LuckyMoneyPickEnvelopeUI.this.ogS.size()) {
                        b bVar = (b) LuckyMoneyPickEnvelopeUI.this.ogS.get(LuckyMoneyPickEnvelopeUI.this.ogT);
                        if (bVar.kfW && bVar.nZq != null) {
                            str = bVar.nZq.materialId;
                            LuckyMoneyPickEnvelopeUI.a(LuckyMoneyPickEnvelopeUI.this, str);
                            com.tencent.mm.plugin.report.service.h.pYm.e(16822, Integer.valueOf(3));
                            AppMethodBeat.o(42906);
                            return false;
                        }
                    }
                    str = str2;
                    LuckyMoneyPickEnvelopeUI.a(LuckyMoneyPickEnvelopeUI.this, str);
                    com.tencent.mm.plugin.report.service.h.pYm.e(16822, Integer.valueOf(3));
                    AppMethodBeat.o(42906);
                    return false;
                }
            }, com.tencent.mm.ui.q.b.RED);
            enableOptionMenu(1, false);
            AppMethodBeat.o(42929);
        }
        bMJ();
        setBackBtn(/* anonymous class already generated */);
        a(1, getString(R.string.csg), (OnMenuItemClickListener) /* anonymous class already generated */, com.tencent.mm.ui.q.b.RED);
        enableOptionMenu(1, false);
        AppMethodBeat.o(42929);
    }

    static /* synthetic */ atb c(LuckyMoneyPickEnvelopeUI luckyMoneyPickEnvelopeUI, String str) {
        AppMethodBeat.i(42938);
        for (b bVar : luckyMoneyPickEnvelopeUI.ogS) {
            if (bVar.nZq.materialId.equals(str)) {
                atb atb = bVar.nZq;
                AppMethodBeat.o(42938);
                return atb;
            }
        }
        AppMethodBeat.o(42938);
        return null;
    }

    static /* synthetic */ void d(LuckyMoneyPickEnvelopeUI luckyMoneyPickEnvelopeUI, String str) {
        AppMethodBeat.i(42939);
        for (b bVar : luckyMoneyPickEnvelopeUI.ogS) {
            if (bVar.nZq.materialId.equals(str)) {
                luckyMoneyPickEnvelopeUI.ogS.remove(bVar);
                AppMethodBeat.o(42939);
                return;
            }
        }
        AppMethodBeat.o(42939);
    }

    static /* synthetic */ void e(LuckyMoneyPickEnvelopeUI luckyMoneyPickEnvelopeUI, final String str) {
        AppMethodBeat.i(42940);
        ab.i("MicroMsg.LuckyMoneyPickEnvelopeUI", "do delete show source: %s", str);
        luckyMoneyPickEnvelopeUI.gII = h.a(luckyMoneyPickEnvelopeUI.mController.ylL, 3, (int) R.style.kd, luckyMoneyPickEnvelopeUI.getString(R.string.cn5), false, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
            }
        });
        new com.tencent.mm.plugin.luckymoney.model.b(str).acy().b(new com.tencent.mm.vending.c.a<Object, com.tencent.mm.ai.a.a<ty>>() {
            public final /* synthetic */ Object call(Object obj) {
                AppMethodBeat.i(42905);
                com.tencent.mm.ai.a.a aVar = (com.tencent.mm.ai.a.a) obj;
                ab.i("MicroMsg.LuckyMoneyPickEnvelopeUI", "do confirm errType: %s, errCode: %s", Integer.valueOf(aVar.errType), Integer.valueOf(aVar.errCode));
                if (LuckyMoneyPickEnvelopeUI.this.gII != null) {
                    LuckyMoneyPickEnvelopeUI.this.gII.dismiss();
                }
                if (aVar.errType == 0 && aVar.errCode == 0) {
                    ab.i("MicroMsg.LuckyMoneyPickEnvelopeUI", "retcode: %s", Integer.valueOf(((ty) aVar.fsy).kCl));
                    if (((ty) aVar.fsy).kCl == 0) {
                        LuckyMoneyPickEnvelopeUI.d(LuckyMoneyPickEnvelopeUI.this, str);
                        if (LuckyMoneyPickEnvelopeUI.this.ogS.isEmpty()) {
                            LuckyMoneyPickEnvelopeUI.this.Ek.setVisibility(0);
                            LuckyMoneyPickEnvelopeUI.this.ogP.setVisibility(8);
                        }
                        LuckyMoneyPickEnvelopeUI.this.ogQ.aop.notifyChanged();
                    } else if (!bo.isNullOrNil(((ty) aVar.fsy).kCm)) {
                        Toast.makeText(LuckyMoneyPickEnvelopeUI.this.mController.ylL, ((ty) aVar.fsy).kCm, 1).show();
                    }
                }
                AppMethodBeat.o(42905);
                return null;
            }
        });
        AppMethodBeat.o(42940);
    }
}
