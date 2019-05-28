package com.tencent.mm.plugin.brandservice.ui.timeline;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Looper;
import android.os.MessageQueue.IdleHandler;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnCreateContextMenuListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.af.l;
import com.tencent.mm.af.o;
import com.tencent.mm.aj.z;
import com.tencent.mm.bp.d;
import com.tencent.mm.modelsimple.y;
import com.tencent.mm.modelvoice.n;
import com.tencent.mm.plugin.brandservice.ui.timeline.a.b;
import com.tencent.mm.plugin.brandservice.ui.timeline.a.e;
import com.tencent.mm.plugin.brandservice.ui.timeline.a.f;
import com.tencent.mm.plugin.brandservice.ui.timeline.a.g;
import com.tencent.mm.plugin.brandservice.ui.timeline.a.h;
import com.tencent.mm.plugin.brandservice.ui.timeline.a.i;
import com.tencent.mm.plugin.brandservice.ui.timeline.a.k;
import com.tencent.mm.plugin.brandservice.ui.timeline.a.p;
import com.tencent.mm.plugin.brandservice.ui.timeline.offenread.BizTimeLineHotView;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.PreloadLogic;
import com.tencent.mm.pluginsdk.ui.e.j;
import com.tencent.mm.protocal.protobuf.chc;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.q;
import com.tencent.mm.storage.r.c;
import com.tencent.mm.storage.s;
import com.tencent.mm.ui.chatting.ao;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public final class a extends BaseAdapter implements OnCreateContextMenuListener {
    public static int jNe = 0;
    public static int jNf;
    public static int jNg = 0;
    public static int jNh = 0;
    public static int jNi = 0;
    public static int jNj;
    public static int jNk;
    private static Long jNr = null;
    private static Long jNs = null;
    private static Long jNt = null;
    boolean cAY = false;
    List<q> iKa = new LinkedList();
    c jKp = new c() {
        public final void a(final Object obj, final com.tencent.mm.storage.r.a aVar) {
            AppMethodBeat.i(14098);
            if (aVar == null || !aVar.xIe) {
                Looper.myQueue().addIdleHandler(new IdleHandler() {
                    public final boolean queueIdle() {
                        AppMethodBeat.i(14097);
                        Looper.myQueue().removeIdleHandler(this);
                        if (a.this.jNd == null || a.this.jNd.isFinishing()) {
                            AppMethodBeat.o(14097);
                        } else {
                            a.a(a.this, aVar);
                            AppMethodBeat.o(14097);
                        }
                        return false;
                    }
                });
                AppMethodBeat.o(14098);
                return;
            }
            AppMethodBeat.o(14098);
        }
    };
    private int jLX = 0;
    private int jLY = 0;
    private com.tencent.mm.ui.widget.b.a jMO;
    public OnTouchListener jNA = new OnTouchListener() {
        public final boolean onTouch(View view, MotionEvent motionEvent) {
            AppMethodBeat.i(14104);
            switch (motionEvent.getAction()) {
                case 0:
                    a.this.jLX = (int) motionEvent.getRawX();
                    a.this.jLY = (int) motionEvent.getRawY();
                    break;
            }
            AppMethodBeat.o(14104);
            return false;
        }
    };
    private OnLongClickListener jNB = new OnLongClickListener() {
        public final boolean onLongClick(View view) {
            AppMethodBeat.i(14105);
            a.this.jNl = (q) view.getTag();
            a.this.jNn = 0;
            a.this.jMO.a(view, a.this, a.this.jNq, a.this.jLX, a.this.jLY);
            AppMethodBeat.o(14105);
            return true;
        }
    };
    private OnClickListener jNC = new OnClickListener() {
        public final void onClick(View view) {
            AppMethodBeat.i(14106);
            q qVar = (q) view.getTag();
            Intent intent = new Intent();
            intent.putExtra("Chat_User", qVar.field_talker);
            intent.putExtra("finish_direct", true);
            intent.putExtra("KOpenArticleSceneFromScene", 90);
            intent.putExtra("specific_chat_from_scene", 2);
            intent.putExtra("preChatTYPE", 11);
            d.f(a.this.jNd, ".ui.chatting.ChattingUI", intent);
            a.this.jNy.d(qVar, 9);
            AppMethodBeat.o(14106);
        }
    };
    private i jND = new i() {
        public final void a(q qVar, int i, int i2) {
            AppMethodBeat.i(14107);
            f fVar = a.this.jNy;
            if (qVar != null) {
                a aVar = (a) fVar.jOf.get(qVar.field_msgId + "_" + i);
                if (aVar != null) {
                    aVar.vOi = 1;
                    ab.d("MicroMsg.BizTimeLineReport", "onClick %d", Integer.valueOf(i));
                }
                fVar.a(qVar, i, 11, i2);
            }
            a.this.jNo.d(qVar);
            AppMethodBeat.o(14107);
        }
    };
    boolean jNE = false;
    private HashSet jNF = new HashSet();
    private BizTimeLineUI jNd;
    public q jNl;
    public int jNm;
    public int jNn = 0;
    public BizTimeLineHotView jNo;
    public com.tencent.mm.plugin.brandservice.ui.timeline.preload.c jNp;
    private g jNq;
    private long jNu = -1;
    public g jNv;
    boolean jNw = false;
    private b jNx;
    public f jNy;
    private Set<String> jNz = new HashSet();

    public final /* synthetic */ Object getItem(int i) {
        AppMethodBeat.i(14130);
        q sg = sg(i);
        AppMethodBeat.o(14130);
        return sg;
    }

    public a(BizTimeLineUI bizTimeLineUI, List<q> list, boolean z, f fVar, BizTimeLineHotView bizTimeLineHotView) {
        AppMethodBeat.i(14108);
        this.jNd = bizTimeLineUI;
        this.jNo = bizTimeLineHotView;
        this.jMO = new com.tencent.mm.ui.widget.b.a(this.jNd);
        this.jNy = fVar;
        if (jNe == 0) {
            jNf = bizTimeLineUI.getResources().getDimensionPixelSize(R.dimen.ui);
            jNg = bizTimeLineUI.getResources().getDimensionPixelSize(R.dimen.uh);
            jNh = bizTimeLineUI.getResources().getDimensionPixelSize(R.dimen.l5);
            jNi = bizTimeLineUI.getResources().getDimensionPixelSize(R.dimen.lo);
            jNj = bizTimeLineUI.getResources().getDimensionPixelSize(R.dimen.um);
            jNk = com.tencent.mm.bz.a.fromDPToPix(this.jNd, 2);
            int gd = com.tencent.mm.bz.a.gd(bizTimeLineUI);
            int ge = com.tencent.mm.bz.a.ge(bizTimeLineUI);
            if (gd >= ge) {
                gd = ge;
            }
            jNe = (int) (((float) (gd - ((int) (com.tencent.mm.bz.a.getDensity(bizTimeLineUI) * 16.0f)))) / 2.35f);
        }
        z.aeX().a(this.jKp, Looper.getMainLooper());
        this.iKa = list;
        this.jNv = new g(this);
        this.jNw = z;
        aWo();
        this.jNp = new com.tencent.mm.plugin.brandservice.ui.timeline.preload.c(bizTimeLineUI, jNe, jNf, this.iKa);
        this.jNq = new g(this, bizTimeLineUI);
        AppMethodBeat.o(14108);
    }

    private void aWo() {
        AppMethodBeat.i(14109);
        aWr();
        if (this.jNw) {
            q aWq = aWq();
            if (!(aWq == null || aWq.drF())) {
                long j = -1;
                for (q aWq2 : this.iKa) {
                    if (j == -1 || j == aWq2.drB()) {
                        j = aWq2.drB();
                    } else {
                        jNr = Long.valueOf(aWq2.field_orderFlag);
                        AppMethodBeat.o(14109);
                        return;
                    }
                }
            }
        }
        AppMethodBeat.o(14109);
    }

    public final int getCount() {
        AppMethodBeat.i(14110);
        int size = this.iKa.size();
        AppMethodBeat.o(14110);
        return size;
    }

    public final q sg(int i) {
        AppMethodBeat.i(14111);
        if (i >= this.iKa.size() || i < 0) {
            AppMethodBeat.o(14111);
            return null;
        }
        q qVar = (q) this.iKa.get(i);
        AppMethodBeat.o(14111);
        return qVar;
    }

    public final long getItemId(int i) {
        return 0;
    }

    public final int getItemViewType(int i) {
        AppMethodBeat.i(14112);
        q sg = sg(i);
        if (sg == null) {
            ab.e("MicroMsg.BizTimeLineAdapter", "getItemViewType info is null");
            AppMethodBeat.o(14112);
            return 0;
        }
        switch (sg.field_type) {
            case 1:
                AppMethodBeat.o(14112);
                return 2;
            case 3:
                AppMethodBeat.o(14112);
                return 4;
            case 34:
                AppMethodBeat.o(14112);
                return 3;
            case 285212721:
                AppMethodBeat.o(14112);
                return 1;
            default:
                AppMethodBeat.o(14112);
                return 0;
        }
    }

    public final int getViewTypeCount() {
        return 5;
    }

    /* JADX WARNING: Removed duplicated region for block: B:383:0x0256 A:{SYNTHETIC} */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x01ad  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final View getView(int i, View view, ViewGroup viewGroup) {
        AppMethodBeat.i(14113);
        q sg = sg(i);
        if (sg == null) {
            ab.e("MicroMsg.BizTimeLineAdapter", "getView info is null");
            AppMethodBeat.o(14113);
        } else {
            if (i == getCount() - 1 && !this.jNE) {
                final int i2 = i;
                al.n(new Runnable() {
                    public final void run() {
                        int i = 0;
                        AppMethodBeat.i(14099);
                        if (i2 == a.this.getCount() - 1 && !a.this.jNE) {
                            ab.i("MicroMsg.BizTimeLineAdapter", "loadMoreData %d/%d", Integer.valueOf(i2), Integer.valueOf(a.this.getCount()));
                            a aVar = a.this;
                            q aWp = aVar.aWp();
                            if (aWp != null) {
                                List ah = z.aeX().ah(10, aWp.field_orderFlag);
                                com.tencent.mm.plugin.brandservice.ui.b.c.aX(ah);
                                aVar.iKa.addAll(ah);
                                aVar.notifyDataSetChanged();
                                if (ah.size() > 0) {
                                    i = 1;
                                }
                            }
                            if (i == 0) {
                                a.this.jNE = true;
                                a.this.jNd.aWB();
                                AppMethodBeat.o(14099);
                                return;
                            }
                            a.this.jNp.KB();
                        }
                        AppMethodBeat.o(14099);
                    }
                }, 300);
            }
            e hVar;
            e eVar;
            com.tencent.neattextview.textview.layout.a QV;
            int dPe;
            LayoutParams layoutParams;
            String kr;
            View view2;
            int i3;
            switch (sg.field_type) {
                case 1:
                    if (view == null) {
                        hVar = new h();
                        view = hVar.a(this.jNd, this);
                        view.setTag(hVar);
                        eVar = hVar;
                    } else {
                        eVar = (h) view.getTag();
                    }
                    SpannableString a = j.a(eVar.mContext, sg.field_content, (int) eVar.jPi.getTextSize(), 1, null, null);
                    eVar.jPi.setMaxLines(BaseClientBuilder.API_PRIORITY_OTHER);
                    eVar.jPi.ah(a);
                    QV = eVar.jPi.QV(eVar.jPm.jNp.getContentWidth() - ((int) (com.tencent.mm.bz.a.getDensity(eVar.mContext) * 48.0f)));
                    if (QV != null) {
                        dPe = QV.dPe();
                    } else {
                        dPe = 0;
                    }
                    if (dPe > 5) {
                        if (!sg.field_isExpand) {
                            eVar.jPi.setMaxLines(5);
                        }
                        eVar.jPK.setVisibility(0);
                        if (sg.field_isExpand) {
                            eVar.jPK.setText(R.string.a_2);
                        } else {
                            eVar.jPK.setText(R.string.a_1);
                        }
                        eVar.jPK.setOnClickListener(new com.tencent.mm.plugin.brandservice.ui.timeline.a.h.AnonymousClass1(sg));
                    } else {
                        eVar.jPi.setMaxLines(BaseClientBuilder.API_PRIORITY_OTHER);
                        eVar.jPK.setVisibility(8);
                    }
                    layoutParams = (LayoutParams) eVar.jPi.getLayoutParams();
                    if (dPe == 1) {
                        layoutParams.gravity = 17;
                    } else {
                        layoutParams.gravity = 19;
                    }
                    eVar.jPi.setLayoutParams(layoutParams);
                    eVar.jPm.a(eVar, sg);
                    eVar.jPm.a(i, sg, eVar.jOQ, eVar.jOP);
                    eVar.jPL.setOnTouchListener(eVar.jPm.jNA);
                    eVar.jPL.setOnLongClickListener(new com.tencent.mm.plugin.brandservice.ui.timeline.a.h.AnonymousClass2(sg));
                    break;
                case 3:
                    if (view == null) {
                        hVar = new com.tencent.mm.plugin.brandservice.ui.timeline.a.d();
                        view = hVar.a(this.jNd, this);
                        view.setTag(hVar);
                    } else {
                        com.tencent.mm.plugin.brandservice.ui.timeline.a.d dVar = (com.tencent.mm.plugin.brandservice.ui.timeline.a.d) view.getTag();
                    }
                    if (this.jNx == null) {
                        this.jNx = new b(this.jNd);
                    }
                    b bVar = this.jNx;
                    hVar.jPm.a(hVar, sg);
                    hVar.jPm.a(i, sg, hVar.jOQ, hVar.jOP);
                    sg.xHT = com.tencent.mm.plugin.brandservice.ui.b.a.e(sg);
                    if (!sg.xHT) {
                        hVar.jPk.setVisibility(0);
                        hVar.jPj.setVisibility(8);
                        hVar.jOS.setVisibility(8);
                        hVar.jPi.ah(hVar.mContext.getText(R.string.a9y));
                        bVar.a(sg, i, hVar.jPh, 0);
                        hVar.jPk.setOnClickListener(new com.tencent.mm.plugin.brandservice.ui.timeline.a.d.AnonymousClass3(sg));
                        break;
                    }
                    hVar.jPk.setVisibility(8);
                    hVar.jPj.setVisibility(0);
                    e.N(hVar.jPg, jNe);
                    e.N(hVar.jPf, jNe);
                    bVar.a(sg, i, hVar.jPf, jNe);
                    hVar.jPg.setOnClickListener(new com.tencent.mm.plugin.brandservice.ui.timeline.a.d.AnonymousClass1(sg));
                    hVar.jPg.setOnTouchListener(hVar.jPm.jNA);
                    hVar.jPg.setOnLongClickListener(new com.tencent.mm.plugin.brandservice.ui.timeline.a.d.AnonymousClass2(sg));
                    break;
                case 34:
                    e eVar2;
                    MMNeat7extView mMNeat7extView;
                    ImageView imageView;
                    if (view == null) {
                        hVar = new p();
                        view = hVar.a(this.jNd, this);
                        view.setTag(hVar);
                        eVar2 = hVar;
                    } else {
                        eVar2 = (p) view.getTag();
                    }
                    sg.xHT = com.tencent.mm.plugin.brandservice.ui.b.a.e(sg);
                    if (sg.xHT) {
                        eVar2.jPj.setVisibility(0);
                        eVar2.jPk.setVisibility(8);
                        mMNeat7extView = eVar2.jPi;
                        imageView = eVar2.jOY;
                    } else {
                        eVar2.jOS.setVisibility(8);
                        eVar2.jPj.setVisibility(8);
                        eVar2.jPk.setVisibility(0);
                        eVar2.jQa.setVisibility(8);
                        eVar2.jPZ.setVisibility(0);
                        mMNeat7extView = eVar2.jQb;
                        ImageView imageView2 = eVar2.jPZ;
                        eVar2.jPk.setOnClickListener(new OnClickListener() {
                            public final void onClick(View view) {
                            }
                        });
                        imageView = imageView2;
                    }
                    n nVar = new n(sg.field_content);
                    mMNeat7extView.ah(com.tencent.mm.pluginsdk.f.h.formatTime("yyyy/MM/dd", System.currentTimeMillis() / 1000));
                    if (sg.xHT) {
                        kr = l.kr((int) (nVar.time / 1000));
                        if (TextUtils.isEmpty(kr)) {
                            eVar2.jPY.setVisibility(8);
                        } else {
                            eVar2.jPY.setVisibility(0);
                            eVar2.jPY.setText(kr);
                        }
                        eVar2.jPL.setOnClickListener(new OnClickListener() {
                            public final void onClick(View view) {
                            }
                        });
                        eVar2.jPL.setBackgroundResource(R.drawable.in);
                        view2 = eVar2.jPL;
                        int i4 = jNh;
                        i3 = jNg;
                        int i5 = jNh;
                        view2.setPadding(i4, i3, i5, i5);
                    }
                    Drawable drawable = imageView.getDrawable();
                    if ((drawable instanceof AnimationDrawable) && ((AnimationDrawable) drawable).isRunning()) {
                        ((AnimationDrawable) drawable).stop();
                    }
                    if (eVar2.jPm.jNv.isPlaying() && sg.field_msgId == eVar2.jPm.jNv.jON) {
                        imageView.setImageResource(R.drawable.ig);
                        if (imageView.getDrawable() instanceof AnimationDrawable) {
                            ((AnimationDrawable) imageView.getDrawable()).start();
                        }
                    } else {
                        imageView.setImageResource(R.drawable.f8if);
                    }
                    imageView.setOnClickListener(new com.tencent.mm.plugin.brandservice.ui.timeline.a.p.AnonymousClass3(sg, imageView));
                    eVar2.jPm.a(eVar2, sg);
                    eVar2.jPm.a(i, sg, eVar2.jOQ, eVar2.jOP);
                    break;
                case 285212721:
                    e eVar3;
                    if (!this.jNw) {
                        com.tencent.mm.plugin.brandservice.ui.b.c.f(sg);
                    }
                    if (view == null) {
                        eVar = new f();
                        view = View.inflate(this.jNd, R.layout.h4, null);
                        eVar.jPr = (LinearLayout) view.findViewById(R.id.a7p);
                        eVar.jPs = (LinearLayout) view.findViewById(R.id.a7w);
                        eVar.jPt = (TextView) view.findViewById(R.id.a7x);
                        eVar.jOP = (LinearLayout) view.findViewById(R.id.a85);
                        eVar.jOQ = (LinearLayout) view.findViewById(R.id.a84);
                        eVar.jOR = view;
                        eVar.aWH();
                        view.setTag(eVar);
                        eVar3 = eVar;
                    } else {
                        eVar3 = (f) view.getTag();
                    }
                    eVar3.b(this.jNd, this);
                    for (b bVar2 : eVar3.jPu) {
                        ao.aj(bVar2.jOR, 3);
                        eVar3.jPr.removeView(bVar2.jOR);
                    }
                    eVar3.jPu.clear();
                    o b = ((com.tencent.mm.plugin.biz.a.a) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.biz.a.a.class)).b(sg.field_msgId, sg.field_content);
                    List list = b.fjr;
                    int size = list.size();
                    if (size == 0) {
                        eVar3.jPr.setVisibility(8);
                        eVar3.a((f) eVar3, -1, 0);
                        break;
                    }
                    boolean z;
                    boolean z2;
                    LayoutInflater layoutInflater;
                    int size2;
                    a aVar;
                    View view3;
                    Context context;
                    LinearLayout linearLayout;
                    b bVar3;
                    eVar3.jPr.setVisibility(0);
                    com.tencent.mm.af.p pVar = (com.tencent.mm.af.p) list.get(0);
                    boolean a2 = com.tencent.mm.plugin.brandservice.ui.timeline.preload.c.a(sg, pVar);
                    if (!a2) {
                        z = a2;
                    } else if (!bo.isNullOrNil(pVar.fjx) || (pVar.type != 5 && pVar.type != 0)) {
                        eVar3.a((f) eVar3, ((com.tencent.mm.af.p) list.get(0)).type, size);
                        z2 = a2;
                        sg.xHT = z2;
                        layoutInflater = ((Activity) eVar3.mContext).getLayoutInflater();
                        size2 = eVar3.jPu.size();
                        while (true) {
                            i3 = size2;
                            if (i3 < size) {
                                size2 = 0;
                                while (true) {
                                    dPe = size2;
                                    if (dPe >= eVar3.jPu.size()) {
                                        if (z2) {
                                            com.tencent.mm.plugin.brandservice.ui.timeline.a.c cVar;
                                            com.tencent.mm.plugin.brandservice.ui.timeline.preload.c cVar2;
                                            String str;
                                            ImageView imageView3;
                                            int i6;
                                            int i7;
                                            View view4;
                                            boolean z3;
                                            if (pVar.type == 5) {
                                                cVar = eVar3.jPw;
                                                sg.xHU = com.tencent.mm.plugin.brandservice.ui.timeline.offenread.d.FG(sg.field_talker);
                                                e.N(cVar.jPn, jNe);
                                                if (bo.isNullOrNil(pVar.title)) {
                                                    cVar.jPi.setVisibility(8);
                                                } else {
                                                    cVar.jPi.ah(pVar.title);
                                                    cVar.jPi.getPaint().setFakeBoldText(true);
                                                    cVar.jPi.setVisibility(0);
                                                }
                                                kr = l.kr(pVar.fjB);
                                                if (TextUtils.isEmpty(kr)) {
                                                    cVar.jPV.setVisibility(8);
                                                } else {
                                                    cVar.jPV.setVisibility(0);
                                                    cVar.jPV.setText(kr);
                                                    cVar.jPV.setTextColor(cVar.mContext.getResources().getColor(R.color.t1));
                                                }
                                                cVar.a(cVar, sg, pVar);
                                                cVar.jPm.a(pVar, sg, i, b, cVar.jPn, size > 1, 0);
                                                cVar.jPd.setVisibility(8);
                                                cVar.jPi.setTextColor(cVar.mContext.getResources().getColor(R.color.t1));
                                                cVar.jPa.setTextColor(cVar.mContext.getResources().getColor(R.color.t1));
                                                cVar.jPm.jNp.a(pVar.fjx, cVar.jOX, sg.field_type, jNe, new com.tencent.mm.plugin.brandservice.ui.timeline.a.m.AnonymousClass1(sg, i), size == 1);
                                                if (size == 1) {
                                                    cVar.jPe.setBackgroundResource(R.drawable.en);
                                                    cVar.jPd.setBackgroundResource(R.drawable.f4);
                                                } else {
                                                    cVar.jPe.setBackgroundResource(R.drawable.ep);
                                                    cVar.jPd.setBackgroundResource(R.drawable.f5);
                                                }
                                                if (com.tencent.mm.bz.a.dm(cVar.mContext) >= 1.375f) {
                                                    cVar.jPi.setMaxLines(1);
                                                } else {
                                                    cVar.jPi.setMaxLines(2);
                                                }
                                            } else if (pVar.type == 8) {
                                                cVar = eVar3.jPx;
                                                e.N(cVar.jPQ, jNe);
                                                cVar.jPd.setVisibility(8);
                                                cVar.jPa.setTextColor(cVar.mContext.getResources().getColor(R.color.t1));
                                                cVar.iNr.setBackgroundResource(R.raw.chatting_item_biz_pic_loading_icon);
                                                cVar.jPm.jNp.a(pVar.fjx, cVar.jOX, sg.field_type, jNe, new com.tencent.mm.plugin.brandservice.ui.timeline.a.j.AnonymousClass1(sg, i), size == 1);
                                                cVar.a(cVar, sg, pVar);
                                                cVar.jPm.a(pVar, sg, i, b, cVar.jPn, size > 1, 0);
                                                if (size == 1) {
                                                    cVar.jPe.setBackgroundResource(R.drawable.en);
                                                    cVar.jPd.setBackgroundResource(R.drawable.ew);
                                                } else {
                                                    cVar.jPe.setBackgroundResource(R.drawable.ep);
                                                    cVar.jPd.setBackgroundResource(R.drawable.ex);
                                                }
                                            } else if (pVar.type == 7) {
                                                com.tencent.mm.plugin.brandservice.ui.timeline.a.n nVar2 = eVar3.jPy;
                                                if (bo.isNullOrNil(pVar.title)) {
                                                    nVar2.jPi.setVisibility(8);
                                                } else {
                                                    nVar2.jPi.setVisibility(0);
                                                    nVar2.jPi.ah(pVar.title);
                                                }
                                                kr = l.kr(pVar.fjB);
                                                if (TextUtils.isEmpty(kr)) {
                                                    nVar2.jPY.setVisibility(8);
                                                } else {
                                                    nVar2.jPY.setVisibility(0);
                                                    nVar2.jPY.setText(kr);
                                                }
                                                Drawable drawable2 = nVar2.jOY.getDrawable();
                                                if ((drawable2 instanceof AnimationDrawable) && ((AnimationDrawable) drawable2).isRunning()) {
                                                    ((AnimationDrawable) drawable2).stop();
                                                }
                                                if ((sg.field_msgId + "_0").equals(com.tencent.mm.plugin.brandservice.ui.b.c.aYR())) {
                                                    nVar2.jOY.setImageResource(R.drawable.ig);
                                                    if (nVar2.jOY.getDrawable() instanceof AnimationDrawable) {
                                                        ((AnimationDrawable) nVar2.jOY.getDrawable()).start();
                                                    }
                                                } else {
                                                    nVar2.jOY.setImageResource(R.drawable.f8if);
                                                }
                                                nVar2.a(nVar2.jOY, sg, 0, pVar.fjx);
                                                nVar2.a(nVar2, sg, pVar);
                                                nVar2.jPm.a(pVar, sg, i, b, nVar2.jPn, size > 1, 0);
                                                if (size == 1) {
                                                    nVar2.jPn.setBackgroundResource(R.drawable.in);
                                                } else {
                                                    nVar2.jPn.setBackgroundResource(R.drawable.io);
                                                }
                                                nVar2.jPn.setPadding(jNh, jNg, jNh, jNg);
                                            } else if (pVar.type == 6) {
                                                i iVar = eVar3.jPz;
                                                com.tencent.mm.af.p pVar2 = (com.tencent.mm.af.p) list.get(0);
                                                if (bo.isNullOrNil(pVar2.title)) {
                                                    iVar.jPi.setVisibility(8);
                                                } else {
                                                    iVar.jPi.setVisibility(0);
                                                    iVar.jPi.ah(pVar2.title);
                                                }
                                                if (TextUtils.isEmpty(pVar2.fjL)) {
                                                    iVar.jPN.setVisibility(8);
                                                } else {
                                                    iVar.jPN.setVisibility(0);
                                                    iVar.jPN.setText(pVar2.fjL);
                                                }
                                                if (pVar2.fjM == 2) {
                                                    iVar.jPO.setImageResource(R.raw.chatting_item_biz_kugou_music_watermark);
                                                } else {
                                                    iVar.jPO.setImageResource(R.raw.chatting_item_biz_qq_music_watermark);
                                                }
                                                iVar.a(iVar.jOY, sg, 0, pVar2.fjx);
                                                iVar.a(iVar, sg, pVar2);
                                                iVar.jPm.a(pVar2, sg, i, b, iVar.jPn, size > 1, 0);
                                                if ((sg.field_msgId + "_0").equals(com.tencent.mm.plugin.brandservice.ui.b.c.aYR())) {
                                                    iVar.jOY.setImageResource(R.raw.chatting_item_biz_music_pause_loading_icon);
                                                } else {
                                                    iVar.jOY.setImageResource(R.raw.chatting_item_biz_music_play_loading_icon);
                                                }
                                                iVar.jPd.setVisibility(8);
                                                cVar2 = iVar.jPm.jNp;
                                                str = pVar2.fjx;
                                                imageView3 = iVar.jOX;
                                                i6 = sg.field_type;
                                                i7 = jNf;
                                                cVar2.a(str, imageView3, i6, i7, i7, "@S", new com.tencent.mm.plugin.brandservice.ui.timeline.a.i.AnonymousClass1(sg, i));
                                                if (size == 1) {
                                                    iVar.jPn.setBackgroundResource(R.drawable.in);
                                                } else {
                                                    iVar.jPn.setBackgroundResource(R.drawable.io);
                                                }
                                                view2 = iVar.jPn;
                                                if (size > 1) {
                                                    dPe = jNh;
                                                    i3 = jNh;
                                                    view2.setPadding(dPe, dPe, i3, i3);
                                                } else {
                                                    dPe = jNh;
                                                    view2.setPadding(dPe, dPe, jNh, jNg);
                                                }
                                            } else if (pVar.type == 10) {
                                                com.tencent.mm.plugin.brandservice.ui.timeline.a.l lVar = eVar3.jPA;
                                                sg.xHU = com.tencent.mm.plugin.brandservice.ui.timeline.offenread.d.FG(sg.field_talker);
                                                if (bo.isNullOrNil(pVar.title)) {
                                                    lVar.jPi.setVisibility(8);
                                                } else {
                                                    lVar.jPi.setVisibility(0);
                                                    lVar.jPi.ah(j.a(lVar.mContext, pVar.title, (int) lVar.jPi.getTextSize()));
                                                    QV = lVar.jPi.QV(lVar.jPm.jNp.getContentWidth() - ((int) (com.tencent.mm.bz.a.getDensity(lVar.mContext) * 48.0f)));
                                                    if (QV != null) {
                                                        dPe = QV.dPe();
                                                    } else {
                                                        dPe = 0;
                                                    }
                                                    layoutParams = (LayoutParams) lVar.jPi.getLayoutParams();
                                                    if (dPe == 1) {
                                                        layoutParams.gravity = 17;
                                                    } else {
                                                        layoutParams.gravity = 19;
                                                    }
                                                    lVar.jPi.setLayoutParams(layoutParams);
                                                }
                                                if (size > 1) {
                                                    lVar.jPU.setVisibility(8);
                                                    lVar.jPn.setBackgroundResource(R.drawable.io);
                                                } else {
                                                    lVar.jPU.setVisibility(0);
                                                    lVar.jPn.setBackgroundResource(R.drawable.in);
                                                }
                                                lVar.a(lVar, sg, pVar);
                                                aVar = lVar.jPm;
                                                view4 = lVar.jPn;
                                                if (size > 1) {
                                                    z3 = true;
                                                } else {
                                                    z3 = false;
                                                }
                                                aVar.a(pVar, sg, i, b, view4, z3, 0);
                                            } else {
                                                boolean z4;
                                                k kVar = eVar3.jPv;
                                                e.N(kVar.jOX, jNe);
                                                kVar.jPi.ah(pVar.title);
                                                kVar.jPi.getPaint().setFakeBoldText(true);
                                                kVar.jOX.setVisibility(0);
                                                kVar.jPi.setTextColor(kVar.mContext.getResources().getColor(R.color.t1));
                                                kVar.jPa.setTextColor(kVar.mContext.getResources().getColor(R.color.t1));
                                                kVar.jPS.setBackgroundResource(R.drawable.uv);
                                                cVar2 = kVar.jPm.jNp;
                                                str = pVar.fjx;
                                                imageView3 = kVar.jOX;
                                                i6 = sg.field_type;
                                                i7 = jNe;
                                                com.tencent.mm.pluginsdk.ui.applet.e.a anonymousClass1 = new com.tencent.mm.plugin.brandservice.ui.timeline.a.k.AnonymousClass1(size, sg, i);
                                                if (size == 1) {
                                                    z4 = true;
                                                } else {
                                                    z4 = false;
                                                }
                                                cVar2.a(str, imageView3, i6, i7, anonymousClass1, z4);
                                                if (size == 1) {
                                                    kVar.jPe.setBackgroundResource(R.drawable.en);
                                                } else {
                                                    kVar.jPe.setBackgroundResource(R.drawable.ep);
                                                }
                                                kVar.a(kVar, sg, pVar);
                                                aVar = kVar.jPm;
                                                view4 = kVar.jPn;
                                                if (size > 1) {
                                                    z3 = true;
                                                } else {
                                                    z3 = false;
                                                }
                                                aVar.a(pVar, sg, i, b, view4, z3, 0);
                                            }
                                        }
                                        if (size <= 2 || sg.field_isExpand) {
                                            eVar3.jPs.setVisibility(8);
                                        } else {
                                            eVar3.jPs.setVisibility(0);
                                            eVar3.jPt.setText(eVar3.mContext.getString(R.string.a_h, new Object[]{Integer.valueOf(size - 2)}));
                                            eVar3.jPs.setTag(sg);
                                            eVar3.jPs.setOnClickListener(eVar3.jPB);
                                        }
                                        int i8 = z2 ? 1 : 0;
                                        while (i8 < size && (sg.field_isExpand || i8 <= 1)) {
                                            com.tencent.mm.af.p pVar3 = (com.tencent.mm.af.p) list.get(i8);
                                            List list2 = eVar3.jPu;
                                            if (z2) {
                                                size2 = i8 - 1;
                                            } else {
                                                size2 = i8;
                                            }
                                            b bVar4 = (b) list2.get(size2);
                                            size2 = pVar.type;
                                            if (i8 == 0) {
                                                bVar4.jOS.setVisibility(8);
                                            } else if (z2 && i8 == 1 && (size2 == 5 || size2 == 8 || size2 == 0)) {
                                                bVar4.jOS.setVisibility(8);
                                            } else {
                                                bVar4.jOS.setVisibility(0);
                                                if (!z2 || i8 > 1) {
                                                    com.tencent.mm.af.p pVar4 = (com.tencent.mm.af.p) list.get(i8 - 1);
                                                    com.tencent.mm.af.p pVar5 = (com.tencent.mm.af.p) list.get(i8);
                                                    if ((pVar4.type == 7 || pVar4.type == 5 || pVar4.type == 6 || !bo.isNullOrNil(pVar4.fjx)) && (pVar5.type == 7 || pVar5.type == 5 || pVar5.type == 6 || !bo.isNullOrNil(pVar5.fjx))) {
                                                        f.O(bVar4.jOS, jNj);
                                                    } else {
                                                        f.O(bVar4.jOS, jNh);
                                                    }
                                                } else {
                                                    f.O(bVar4.jOS, jNh);
                                                }
                                            }
                                            if (z2) {
                                                if (i8 == 1) {
                                                    if (i8 == size - 1) {
                                                        f.r(bVar4.jOT, jNh, jNg);
                                                    } else {
                                                        f.r(bVar4.jOT, jNh, jNi);
                                                    }
                                                } else if (i8 == size - 1) {
                                                    f.r(bVar4.jOT, jNi, jNg);
                                                } else {
                                                    view2 = bVar4.jOT;
                                                    dPe = jNi;
                                                    f.r(view2, dPe, dPe);
                                                }
                                            } else if (i8 == 0) {
                                                if (size == 1) {
                                                    f.r(bVar4.jOT, jNh, jNg);
                                                } else {
                                                    f.r(bVar4.jOT, jNh, jNi);
                                                }
                                            } else if (i8 == 1) {
                                                if (size == 2) {
                                                    f.r(bVar4.jOT, jNi, jNg);
                                                } else {
                                                    view2 = bVar4.jOT;
                                                    dPe = jNi;
                                                    f.r(view2, dPe, dPe);
                                                }
                                            } else if (i8 == size - 1) {
                                                f.r(bVar4.jOT, jNi, jNg);
                                            } else {
                                                view2 = bVar4.jOT;
                                                dPe = jNi;
                                                f.r(view2, dPe, dPe);
                                            }
                                            bVar4.a(pVar3, sg, i8, false);
                                            bVar4.a(bVar4.jOZ, bVar4.jPa, sg, pVar3);
                                            bVar4.jOU.ah(pVar3.title);
                                            bVar4.jOU.setTextColor(eVar3.mContext.getResources().getColor(R.color.h4));
                                            if (pVar3.fjA == 0 || pVar3.fjA == 1) {
                                                bVar4.jOW.setVisibility(0);
                                                bVar4.jOU.setTextColor(eVar3.mContext.getResources().getColor(R.color.h4));
                                                ImageView imageView4;
                                                if (pVar3.type == 7) {
                                                    bVar4.jOX.setVisibility(8);
                                                } else if (!bo.isNullOrNil(pVar3.fjx)) {
                                                    bVar4.jOX.setVisibility(0);
                                                    String str2 = pVar3.fjx;
                                                    String str3 = "@S";
                                                    if (i8 == 0 && !bo.isNullOrNil(pVar3.fjO)) {
                                                        str2 = l.a(pVar3);
                                                    } else if (i8 == 0) {
                                                        str3 = "@T";
                                                    }
                                                    com.tencent.mm.plugin.brandservice.ui.timeline.preload.c cVar3 = eVar3.jPm.jNp;
                                                    imageView4 = bVar4.jOX;
                                                    int i9 = sg.field_type;
                                                    int i10 = jNf;
                                                    cVar3.a(str2, imageView4, i9, i10, i10, str3, new com.tencent.mm.plugin.brandservice.ui.timeline.a.f.AnonymousClass2(bVar4, pVar3, sg, i8));
                                                } else if (pVar3.type == 5 || pVar3.type == 6) {
                                                    bVar4.jOX.setVisibility(0);
                                                    com.tencent.mm.plugin.brandservice.ui.timeline.preload.c cVar4 = eVar3.jPm.jNp;
                                                    imageView4 = bVar4.jOX;
                                                    dPe = jNf;
                                                    imageView4.setContentDescription(cVar4.jNd.getString(R.string.al_));
                                                    com.tencent.mm.at.a.a ahp = com.tencent.mm.at.o.ahp();
                                                    com.tencent.mm.at.a.a.c.a aVar2 = new com.tencent.mm.at.a.a.c.a();
                                                    aVar2.ePF = true;
                                                    aVar2.ePT = R.color.k8;
                                                    aVar2 = aVar2.ct(dPe, dPe);
                                                    aVar2.fHe = 4;
                                                    ahp.a("2130841060", imageView4, aVar2.ahG(), null, new com.tencent.mm.pluginsdk.ui.applet.e());
                                                } else {
                                                    bVar4.jOW.setVisibility(8);
                                                }
                                            } else {
                                                bVar4.jOW.setVisibility(8);
                                                bVar4.jOU.setTextColor(eVar3.mContext.getResources().getColor(R.color.s0));
                                            }
                                            if (bo.isNullOrNil(pVar3.fjz) || pVar3.type != 3) {
                                                bVar4.jOV.setVisibility(8);
                                            } else {
                                                bVar4.jOV.setText(pVar3.fjz);
                                                bVar4.jOV.setVisibility(0);
                                            }
                                            bVar4.jOR.setVisibility(0);
                                            eVar3.jPm.a(pVar3, sg, i, b, bVar4.jOR, size > 1, i8);
                                            if (i8 != size - 1 || eVar3.jPs.getVisibility() == 0) {
                                                bVar4.jOR.setBackgroundResource(R.drawable.io);
                                            } else {
                                                bVar4.jOR.setBackgroundResource(R.drawable.in);
                                            }
                                            i8++;
                                        }
                                        eVar3.jPm.a(i, sg, eVar3.jOQ, eVar3.jOP);
                                        eVar3.jPm.a(eVar3, sg);
                                        break;
                                    }
                                    ((b) eVar3.jPu.get(dPe)).jOR.setVisibility(8);
                                    size2 = dPe + 1;
                                }
                            } else {
                                view2 = ao.Ot(3);
                                if (view2 == null) {
                                    view2 = layoutInflater.inflate(R.layout.h5, null);
                                }
                                view3 = view2;
                                aVar = eVar3.jPm;
                                context = eVar3.mContext;
                                linearLayout = eVar3.jPr;
                                bVar3 = new b(aVar, context);
                                bVar3.jOR = view3;
                                bVar3.jOS = view3.findViewById(R.id.a7y);
                                bVar3.jOT = view3.findViewById(R.id.a7z);
                                bVar3.jOU = (MMNeat7extView) view3.findViewById(R.id.a80);
                                bVar3.jOV = (TextView) view3.findViewById(R.id.a81);
                                bVar3.jOW = view3.findViewById(R.id.wi);
                                bVar3.jOX = (ImageView) view3.findViewById(R.id.a82);
                                bVar3.jOY = (ImageView) view3.findViewById(R.id.a83);
                                bVar3.jOZ = view3.findViewById(R.id.a88);
                                bVar3.jPa = (TextView) view3.findViewById(R.id.a89);
                                linearLayout.addView(view3, linearLayout.getChildCount());
                                eVar3.jPu.add(bVar3);
                                size2 = i3 + 1;
                            }
                        }
                    } else {
                        z = false;
                    }
                    eVar3.a((f) eVar3, -1, size);
                    z2 = z;
                    sg.xHT = z2;
                    layoutInflater = ((Activity) eVar3.mContext).getLayoutInflater();
                    size2 = eVar3.jPu.size();
                    while (true) {
                        i3 = size2;
                        if (i3 < size) {
                        }
                        view3 = view2;
                        aVar = eVar3.jPm;
                        context = eVar3.mContext;
                        linearLayout = eVar3.jPr;
                        bVar3 = new b(aVar, context);
                        bVar3.jOR = view3;
                        bVar3.jOS = view3.findViewById(R.id.a7y);
                        bVar3.jOT = view3.findViewById(R.id.a7z);
                        bVar3.jOU = (MMNeat7extView) view3.findViewById(R.id.a80);
                        bVar3.jOV = (TextView) view3.findViewById(R.id.a81);
                        bVar3.jOW = view3.findViewById(R.id.wi);
                        bVar3.jOX = (ImageView) view3.findViewById(R.id.a82);
                        bVar3.jOY = (ImageView) view3.findViewById(R.id.a83);
                        bVar3.jOZ = view3.findViewById(R.id.a88);
                        bVar3.jPa = (TextView) view3.findViewById(R.id.a89);
                        linearLayout.addView(view3, linearLayout.getChildCount());
                        eVar3.jPu.add(bVar3);
                        size2 = i3 + 1;
                    }
                    break;
                default:
                    if (view == null) {
                        eVar = new com.tencent.mm.plugin.brandservice.ui.timeline.a.o();
                        BizTimeLineUI bizTimeLineUI = this.jNd;
                        if (eVar.jOR != null) {
                            view2 = eVar.jOR;
                        } else {
                            eVar.jOR = View.inflate(bizTimeLineUI, R.layout.hg, null);
                            eVar.aWH();
                            view2 = eVar.jOR;
                        }
                        view2.setTag(eVar);
                        view = view2;
                    } else {
                        eVar = (com.tencent.mm.plugin.brandservice.ui.timeline.a.o) view.getTag();
                    }
                    a(eVar, sg);
                    a(i, sg, eVar.jOQ, eVar.jOP);
                    break;
            }
            if (!(this.jNw || this.cAY)) {
                this.jNy.c(sg, i);
                FE(sg.field_talker);
            }
            AppMethodBeat.o(14113);
        }
        return view;
    }

    public final void FE(String str) {
        AppMethodBeat.i(14114);
        com.tencent.mm.kernel.g.RQ();
        if (com.tencent.mm.kernel.a.jP(com.tencent.mm.kernel.g.RN().eIV) && !this.jNz.contains(str)) {
            y.ab(str, 2);
            this.jNz.add(str);
        }
        AppMethodBeat.o(14114);
    }

    public final void a(q qVar) {
        AppMethodBeat.i(14115);
        if (qVar == null) {
            ab.w("MicroMsg.BizTimeLineAdapter", "updateGroupId info is null");
            AppMethodBeat.o(14115);
            return;
        }
        ab.d("MicroMsg.BizTimeLineAdapter", "updateGroupId keep %b, groupId %d, maxGroupId %d", Boolean.valueOf(this.jNw), Long.valueOf(qVar.drB()), Long.valueOf(z.aeX().drL()));
        if (!this.jNw && r0 == r2) {
            final long j = qVar.field_orderFlag;
            com.tencent.mm.ci.g.da(Long.valueOf(j)).h(new com.tencent.mm.vending.c.a<Boolean, Long>() {
                public final /* synthetic */ Object call(Object obj) {
                    AppMethodBeat.i(14101);
                    Boolean valueOf = Boolean.valueOf(s.mL(j));
                    AppMethodBeat.o(14101);
                    return valueOf;
                }
            }).b(new com.tencent.mm.vending.c.a<Void, Boolean>() {
                public final /* synthetic */ Object call(Object obj) {
                    AppMethodBeat.i(14100);
                    if (((Boolean) obj).booleanValue()) {
                        a.this.jNd.aWE();
                    }
                    AppMethodBeat.o(14100);
                    return null;
                }
            });
        }
        AppMethodBeat.o(14115);
    }

    private boolean a(q qVar, int i) {
        AppMethodBeat.i(14116);
        if (jNr == null) {
            long drB = qVar.drB();
            long j = 0;
            q sg = sg(i - 1);
            if (sg != null) {
                j = sg.drB();
            }
            if (drB == j || jNt == null || j != jNt.longValue()) {
                AppMethodBeat.o(14116);
                return false;
            }
            jNr = Long.valueOf(qVar.field_orderFlag);
            AppMethodBeat.o(14116);
            return true;
        } else if (jNr.longValue() == qVar.field_orderFlag) {
            AppMethodBeat.o(14116);
            return true;
        } else {
            AppMethodBeat.o(14116);
            return false;
        }
    }

    private boolean b(q qVar, int i) {
        AppMethodBeat.i(14117);
        if (jNs == null) {
            q sg = sg(i - 1);
            if (sg == null) {
                AppMethodBeat.o(14117);
                return false;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - qVar.field_createTime <= 86400000 || currentTimeMillis - sg.field_createTime > 86400000) {
                AppMethodBeat.o(14117);
                return false;
            } else if (aWs() || (jNr != null && jNr.longValue() > qVar.field_orderFlag)) {
                jNs = Long.valueOf(qVar.field_orderFlag);
                AppMethodBeat.o(14117);
                return true;
            } else {
                jNs = Long.valueOf(-1);
                AppMethodBeat.o(14117);
                return false;
            }
        } else if (jNr != null && jNr.longValue() <= jNs.longValue()) {
            jNs = Long.valueOf(-1);
            AppMethodBeat.o(14117);
            return false;
        } else if (jNs.longValue() == qVar.field_orderFlag) {
            AppMethodBeat.o(14117);
            return true;
        } else {
            AppMethodBeat.o(14117);
            return false;
        }
    }

    private void a(int i, q qVar, View view, View view2) {
        AppMethodBeat.i(14118);
        if (i > 0) {
            view.setVisibility(0);
            if (a(qVar, i)) {
                view2.setVisibility(0);
                ((TextView) view2.findViewById(R.id.a86)).setText(this.jNd.getString(R.string.a9z));
            } else if (b(qVar, i)) {
                view2.setVisibility(0);
                ((TextView) view2.findViewById(R.id.a86)).setText(this.jNd.getString(R.string.a_0));
            } else {
                view2.setVisibility(8);
            }
        } else {
            view.setVisibility(0);
            view2.setVisibility(8);
        }
        a(qVar);
        AppMethodBeat.o(14118);
    }

    private void a(com.tencent.mm.af.p pVar, final q qVar, int i, o oVar, View view, boolean z, int i2) {
        AppMethodBeat.i(14119);
        ((com.tencent.mm.plugin.brandservice.a.a) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.brandservice.a.a.class)).a(pVar, qVar, i, oVar, view, z, i2, this.jND);
        view.setOnTouchListener(this.jNA);
        final int i3 = i2;
        view.setOnLongClickListener(new OnLongClickListener() {
            public final boolean onLongClick(View view) {
                AppMethodBeat.i(14102);
                a.this.jNl = qVar;
                a.this.jNm = i3;
                a.this.jNn = 1;
                a.this.jMO.a(view, a.this, a.this.jNq, a.this.jLX, a.this.jLY);
                AppMethodBeat.o(14102);
                return true;
            }
        });
        if (pVar.type == 5 && ((com.tencent.mm.plugin.brandservice.a.b) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.brandservice.a.b.class)).aVP()) {
            i3 = i2;
            view.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    View findViewById;
                    AppMethodBeat.i(14103);
                    int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
                    if (i3 > 0 || !qVar.xHT) {
                        findViewById = view.findViewById(R.id.a82);
                    } else {
                        findViewById = view.findViewById(R.id.wj);
                    }
                    Bundle bundle = new Bundle();
                    bundle.putInt("biz_video_scene", 90);
                    bundle.putInt("biz_video_subscene", a.this.jNd.getIntent().getIntExtra("KOpenArticleSceneFromScene", Downloads.MIN_WAIT_FOR_NETWORK));
                    bundle.putInt("geta8key_scene", 56);
                    com.tencent.mm.plugin.brandservice.ui.timeline.video.a.c.a(a.this.jNd, qVar.field_msgId, qVar.field_msgSvrId, i3, findViewById, bundle);
                    a.this.jND.a(qVar, i3, currentTimeMillis);
                    AppMethodBeat.o(14103);
                }
            });
        }
        AppMethodBeat.o(14119);
    }

    private void a(e eVar, q qVar) {
        AppMethodBeat.i(14120);
        com.tencent.mm.pluginsdk.ui.a.b.r(eVar.ejo, qVar.field_talker);
        CharSequence mJ = com.tencent.mm.model.s.mJ(qVar.field_talker);
        ad aoO = ((com.tencent.mm.plugin.messenger.foundation.a.j) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).XM().aoO(qVar.field_talker);
        if (aoO == null || !aoO.Oe()) {
            eVar.jPp.setText(j.b(this.jNd, mJ, eVar.jPp.getTextSize()));
        } else {
            Drawable drawable = this.jNd.getResources().getDrawable(R.drawable.axl);
            int textSize = (int) eVar.jPp.getTextSize();
            drawable.setBounds(0, 0, textSize, textSize);
            com.tencent.mm.ui.widget.a aVar = new com.tencent.mm.ui.widget.a(drawable);
            new SpannableString("@").setSpan(aVar, 0, 1, 33);
            eVar.jPp.setText(TextUtils.concat(new CharSequence[]{j.b(this.jNd, mJ, eVar.jPp.getTextSize()) + "  ", r0}));
        }
        if (qVar.field_isRead == 1) {
            eVar.jPp.getPaint().setFakeBoldText(false);
            eVar.jPp.setTextColor(this.jNd.getResources().getColor(R.color.rr));
        } else {
            eVar.jPp.getPaint().setFakeBoldText(true);
            eVar.jPp.setTextColor(this.jNd.getResources().getColor(R.color.h4));
        }
        eVar.enf.setText(com.tencent.mm.plugin.brandservice.ui.b.b.e(this.jNd, qVar.field_createTime));
        eVar.jPo.setOnTouchListener(this.jNA);
        eVar.jPo.setTag(qVar);
        eVar.jPo.setOnLongClickListener(this.jNB);
        eVar.jPo.setOnClickListener(this.jNC);
        AppMethodBeat.o(14120);
    }

    public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        AppMethodBeat.i(14121);
        if (this.jNl == null) {
            ab.w("MicroMsg.BizTimeLineAdapter", "onCreateContextMenu mInfo == null");
            AppMethodBeat.o(14121);
        } else if (this.jNn == 0) {
            ad aoO = ((com.tencent.mm.plugin.messenger.foundation.a.j) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).XM().aoO(this.jNl.field_talker);
            if (aoO == null) {
                ab.e("MicroMsg.BizTimeLineAdapter", "onCreateContextMenu, contact is null, talker = " + this.jNl.field_talker);
                AppMethodBeat.o(14121);
                return;
            }
            contextMenu.setHeaderTitle(j.b(this.jNd, aoO.Oj()));
            if (com.tencent.mm.n.a.jh(aoO.field_type)) {
                contextMenu.add(0, 10, 0, R.string.a9p);
                contextMenu.add(0, 2, 0, R.string.cvi);
            }
            AppMethodBeat.o(14121);
        } else {
            contextMenu.add(0, 11, 0, R.string.a9r);
            AppMethodBeat.o(14121);
        }
    }

    public final void notifyDataSetChanged() {
        AppMethodBeat.i(14122);
        super.notifyDataSetChanged();
        AppMethodBeat.o(14122);
    }

    public final q aWp() {
        AppMethodBeat.i(14123);
        if (this.iKa.size() > 0) {
            q qVar = (q) this.iKa.get(this.iKa.size() - 1);
            AppMethodBeat.o(14123);
            return qVar;
        }
        AppMethodBeat.o(14123);
        return null;
    }

    public final q aWq() {
        AppMethodBeat.i(14124);
        if (this.iKa.size() > 0) {
            q qVar = (q) this.iKa.get(0);
            AppMethodBeat.o(14124);
            return qVar;
        }
        AppMethodBeat.o(14124);
        return null;
    }

    public final void aWr() {
        AppMethodBeat.i(14125);
        q aWq = aWq();
        if (aWq != null) {
            jNt = Long.valueOf(aWq.drB());
        }
        jNr = null;
        jNs = null;
        AppMethodBeat.o(14125);
    }

    private boolean aWs() {
        AppMethodBeat.i(14126);
        q aWq = aWq();
        if (aWq == null) {
            AppMethodBeat.o(14126);
            return false;
        } else if (aWq.drF()) {
            AppMethodBeat.o(14126);
            return true;
        } else {
            if (this.jNu < 0) {
                aWt();
            }
            if (aWq.drB() == this.jNu) {
                AppMethodBeat.o(14126);
                return true;
            }
            AppMethodBeat.o(14126);
            return false;
        }
    }

    public final boolean isEmpty() {
        AppMethodBeat.i(14127);
        if (super.isEmpty()) {
            if (z.aeY().baS() > 0) {
                AppMethodBeat.o(14127);
                return false;
            }
            boolean z;
            chc aWL = com.tencent.mm.plugin.brandservice.ui.timeline.offenread.d.aWL();
            if (aWL == null || bo.ek(aWL.xfW)) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                AppMethodBeat.o(14127);
                return false;
            }
        }
        boolean isEmpty = super.isEmpty();
        AppMethodBeat.o(14127);
        return isEmpty;
    }

    private void aWt() {
        AppMethodBeat.i(14128);
        q drJ = z.aeX().drJ();
        if (drJ != null) {
            this.jNu = drJ.drB();
        }
        AppMethodBeat.o(14128);
    }

    public final void dD(int i, int i2) {
        AppMethodBeat.i(14129);
        ArrayList arrayList = new ArrayList();
        while (i <= i2) {
            q sg = sg(i);
            if (!(sg == null || sg.field_type != 285212721 || this.jNF.contains(Long.valueOf(sg.field_msgId)))) {
                ab.v("MicroMsg.BizTimeLineAdapter", "terry checkpreload:" + sg.field_msgId);
                this.jNF.add(Long.valueOf(sg.field_msgId));
                String[] strArr = new String[3];
                strArr[0] = String.valueOf(sg.field_msgId);
                strArr[1] = sg.field_content;
                strArr[2] = sg.field_isExpand ? "-1" : "2";
                arrayList.add(strArr);
            }
            i++;
        }
        if (arrayList.size() > 0) {
            PreloadLogic.j(arrayList, 90);
        }
        AppMethodBeat.o(14129);
    }
}
