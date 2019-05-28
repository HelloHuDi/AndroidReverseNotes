package com.tencent.p177mm.plugin.brandservice.p349ui.timeline;

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
import com.tencent.neattextview.textview.layout.C5782a;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.kernel.C1668a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1854s;
import com.tencent.p177mm.modelsimple.C37951y;
import com.tencent.p177mm.modelvoice.C42230n;
import com.tencent.p177mm.p181af.C1192l;
import com.tencent.p177mm.p181af.C32223o;
import com.tencent.p177mm.p181af.C32224p;
import com.tencent.p177mm.p184aj.C41747z;
import com.tencent.p177mm.p190at.C32291o;
import com.tencent.p177mm.p190at.p191a.C25815a;
import com.tencent.p177mm.p190at.p191a.p827a.C25814c.C17927a;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p217ci.C41930g;
import com.tencent.p177mm.p264n.C7486a;
import com.tencent.p177mm.p612ui.chatting.C44290ao;
import com.tencent.p177mm.p612ui.widget.C5664a;
import com.tencent.p177mm.p612ui.widget.MMNeat7extView;
import com.tencent.p177mm.p612ui.widget.p1095b.C24088a;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.biz.p1395a.C27500a;
import com.tencent.p177mm.plugin.brandservice.p1241a.C20022a;
import com.tencent.p177mm.plugin.brandservice.p1241a.C20023b;
import com.tencent.p177mm.plugin.brandservice.p349ui.p1242b.C38689c;
import com.tencent.p177mm.plugin.brandservice.p349ui.p1242b.C42808a;
import com.tencent.p177mm.plugin.brandservice.p349ui.p1242b.C42809b;
import com.tencent.p177mm.plugin.brandservice.p349ui.timeline.C20055f.C11243a;
import com.tencent.p177mm.plugin.brandservice.p349ui.timeline.offenread.BizTimeLineHotView;
import com.tencent.p177mm.plugin.brandservice.p349ui.timeline.offenread.C42822d;
import com.tencent.p177mm.plugin.brandservice.p349ui.timeline.p350a.C11229f;
import com.tencent.p177mm.plugin.brandservice.p349ui.timeline.p350a.C11229f.C112312;
import com.tencent.p177mm.plugin.brandservice.p349ui.timeline.p350a.C11232g;
import com.tencent.p177mm.plugin.brandservice.p349ui.timeline.p350a.C11234h;
import com.tencent.p177mm.plugin.brandservice.p349ui.timeline.p350a.C11234h.C112351;
import com.tencent.p177mm.plugin.brandservice.p349ui.timeline.p350a.C11234h.C112362;
import com.tencent.p177mm.plugin.brandservice.p349ui.timeline.p350a.C11237i;
import com.tencent.p177mm.plugin.brandservice.p349ui.timeline.p350a.C11237i.C112381;
import com.tencent.p177mm.plugin.brandservice.p349ui.timeline.p350a.C20054o;
import com.tencent.p177mm.plugin.brandservice.p349ui.timeline.p350a.C27519e;
import com.tencent.p177mm.plugin.brandservice.p349ui.timeline.p350a.C27520n;
import com.tencent.p177mm.plugin.brandservice.p349ui.timeline.p350a.C27521p;
import com.tencent.p177mm.plugin.brandservice.p349ui.timeline.p350a.C27521p.C26951;
import com.tencent.p177mm.plugin.brandservice.p349ui.timeline.p350a.C27521p.C275222;
import com.tencent.p177mm.plugin.brandservice.p349ui.timeline.p350a.C27521p.C275233;
import com.tencent.p177mm.plugin.brandservice.p349ui.timeline.p350a.C33730b;
import com.tencent.p177mm.plugin.brandservice.p349ui.timeline.p350a.C38696d;
import com.tencent.p177mm.plugin.brandservice.p349ui.timeline.p350a.C38696d.C112273;
import com.tencent.p177mm.plugin.brandservice.p349ui.timeline.p350a.C38696d.C386951;
import com.tencent.p177mm.plugin.brandservice.p349ui.timeline.p350a.C38696d.C386972;
import com.tencent.p177mm.plugin.brandservice.p349ui.timeline.p350a.C38698k;
import com.tencent.p177mm.plugin.brandservice.p349ui.timeline.p350a.C38698k.C112401;
import com.tencent.p177mm.plugin.brandservice.p349ui.timeline.p350a.C38699m.C387001;
import com.tencent.p177mm.plugin.brandservice.p349ui.timeline.p350a.C42814j.C112391;
import com.tencent.p177mm.plugin.brandservice.p349ui.timeline.p350a.C45762c;
import com.tencent.p177mm.plugin.brandservice.p349ui.timeline.p350a.C46900l;
import com.tencent.p177mm.plugin.brandservice.p349ui.timeline.preload.C2703c;
import com.tencent.p177mm.plugin.brandservice.p349ui.timeline.preload.PreloadLogic;
import com.tencent.p177mm.plugin.brandservice.p349ui.timeline.video.p929a.C11263c;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.pluginsdk.p1079f.C14835h;
import com.tencent.p177mm.pluginsdk.p597ui.C40459a.C40460b;
import com.tencent.p177mm.pluginsdk.p597ui.applet.C35836e;
import com.tencent.p177mm.pluginsdk.p597ui.applet.C35836e.C35837a;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.protocal.protobuf.chc;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C30309s;
import com.tencent.p177mm.storage.C40635r.C40633a;
import com.tencent.p177mm.storage.C40635r.C40634c;
import com.tencent.p177mm.storage.C46627q;
import com.tencent.p177mm.storage.C7616ad;
import com.tencent.p177mm.vending.p637c.C5681a;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.a */
public final class C38701a extends BaseAdapter implements OnCreateContextMenuListener {
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
    List<C46627q> iKa = new LinkedList();
    C40634c jKp = new C387021();
    private int jLX = 0;
    private int jLY = 0;
    private C24088a jMO;
    public OnTouchListener jNA = new C200527();
    private OnLongClickListener jNB = new C200538();
    private OnClickListener jNC = new C275189();
    private C11244i jND = new C2005010();
    boolean jNE = false;
    private HashSet jNF = new HashSet();
    private BizTimeLineUI jNd;
    public C46627q jNl;
    public int jNm;
    public int jNn = 0;
    public BizTimeLineHotView jNo;
    public C2703c jNp;
    private C11232g jNq;
    private long jNu = -1;
    public C2696g jNv;
    boolean jNw = false;
    private C33731b jNx;
    public C20055f jNy;
    private Set<String> jNz = new HashSet();

    /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.a$10 */
    class C2005010 implements C11244i {
        C2005010() {
        }

        /* renamed from: a */
        public final void mo22942a(C46627q c46627q, int i, int i2) {
            AppMethodBeat.m2504i(14107);
            C20055f c20055f = C38701a.this.jNy;
            if (c46627q != null) {
                C11243a c11243a = (C11243a) c20055f.jOf.get(c46627q.field_msgId + "_" + i);
                if (c11243a != null) {
                    c11243a.vOi = 1;
                    C4990ab.m7411d("MicroMsg.BizTimeLineReport", "onClick %d", Integer.valueOf(i));
                }
                c20055f.mo35300a(c46627q, i, 11, i2);
            }
            C38701a.this.jNo.mo68287d(c46627q);
            AppMethodBeat.m2505o(14107);
        }
    }

    /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.a$7 */
    class C200527 implements OnTouchListener {
        C200527() {
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            AppMethodBeat.m2504i(14104);
            switch (motionEvent.getAction()) {
                case 0:
                    C38701a.this.jLX = (int) motionEvent.getRawX();
                    C38701a.this.jLY = (int) motionEvent.getRawY();
                    break;
            }
            AppMethodBeat.m2505o(14104);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.a$8 */
    class C200538 implements OnLongClickListener {
        C200538() {
        }

        public final boolean onLongClick(View view) {
            AppMethodBeat.m2504i(14105);
            C38701a.this.jNl = (C46627q) view.getTag();
            C38701a.this.jNn = 0;
            C38701a.this.jMO.mo39886a(view, C38701a.this, C38701a.this.jNq, C38701a.this.jLX, C38701a.this.jLY);
            AppMethodBeat.m2505o(14105);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.a$9 */
    class C275189 implements OnClickListener {
        C275189() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(14106);
            C46627q c46627q = (C46627q) view.getTag();
            Intent intent = new Intent();
            intent.putExtra("Chat_User", c46627q.field_talker);
            intent.putExtra("finish_direct", true);
            intent.putExtra("KOpenArticleSceneFromScene", 90);
            intent.putExtra("specific_chat_from_scene", 2);
            intent.putExtra("preChatTYPE", 11);
            C25985d.m41473f(C38701a.this.jNd, ".ui.chatting.ChattingUI", intent);
            C38701a.this.jNy.mo35304d(c46627q, 9);
            AppMethodBeat.m2505o(14106);
        }
    }

    /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.a$1 */
    class C387021 implements C40634c {
        C387021() {
        }

        /* renamed from: a */
        public final void mo22929a(final Object obj, final C40633a c40633a) {
            AppMethodBeat.m2504i(14098);
            if (c40633a == null || !c40633a.xIe) {
                Looper.myQueue().addIdleHandler(new IdleHandler() {
                    public final boolean queueIdle() {
                        AppMethodBeat.m2504i(14097);
                        Looper.myQueue().removeIdleHandler(this);
                        if (C38701a.this.jNd == null || C38701a.this.jNd.isFinishing()) {
                            AppMethodBeat.m2505o(14097);
                        } else {
                            C38701a.m65639a(C38701a.this, c40633a);
                            AppMethodBeat.m2505o(14097);
                        }
                        return false;
                    }
                });
                AppMethodBeat.m2505o(14098);
                return;
            }
            AppMethodBeat.m2505o(14098);
        }
    }

    /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.a$3 */
    class C387043 implements C5681a<Void, Boolean> {
        C387043() {
        }

        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.m2504i(14100);
            if (((Boolean) obj).booleanValue()) {
                C38701a.this.jNd.aWE();
            }
            AppMethodBeat.m2505o(14100);
            return null;
        }
    }

    public final /* synthetic */ Object getItem(int i) {
        AppMethodBeat.m2504i(14130);
        C46627q sg = mo61563sg(i);
        AppMethodBeat.m2505o(14130);
        return sg;
    }

    public C38701a(BizTimeLineUI bizTimeLineUI, List<C46627q> list, boolean z, C20055f c20055f, BizTimeLineHotView bizTimeLineHotView) {
        AppMethodBeat.m2504i(14108);
        this.jNd = bizTimeLineUI;
        this.jNo = bizTimeLineHotView;
        this.jMO = new C24088a(this.jNd);
        this.jNy = c20055f;
        if (jNe == 0) {
            jNf = bizTimeLineUI.getResources().getDimensionPixelSize(C25738R.dimen.f10207ui);
            jNg = bizTimeLineUI.getResources().getDimensionPixelSize(C25738R.dimen.f10206uh);
            jNh = bizTimeLineUI.getResources().getDimensionPixelSize(C25738R.dimen.f9948l5);
            jNi = bizTimeLineUI.getResources().getDimensionPixelSize(C25738R.dimen.f9966lo);
            jNj = bizTimeLineUI.getResources().getDimensionPixelSize(C25738R.dimen.f10211um);
            jNk = C1338a.fromDPToPix(this.jNd, 2);
            int gd = C1338a.m2868gd(bizTimeLineUI);
            int ge = C1338a.m2869ge(bizTimeLineUI);
            if (gd >= ge) {
                gd = ge;
            }
            jNe = (int) (((float) (gd - ((int) (C1338a.getDensity(bizTimeLineUI) * 16.0f)))) / 2.35f);
        }
        C41747z.aeX().mo64101a(this.jKp, Looper.getMainLooper());
        this.iKa = list;
        this.jNv = new C2696g(this);
        this.jNw = z;
        aWo();
        this.jNp = new C2703c(bizTimeLineUI, jNe, jNf, this.iKa);
        this.jNq = new C11232g(this, bizTimeLineUI);
        AppMethodBeat.m2505o(14108);
    }

    private void aWo() {
        AppMethodBeat.m2504i(14109);
        aWr();
        if (this.jNw) {
            C46627q aWq = aWq();
            if (!(aWq == null || aWq.drF())) {
                long j = -1;
                for (C46627q aWq2 : this.iKa) {
                    if (j == -1 || j == aWq2.drB()) {
                        j = aWq2.drB();
                    } else {
                        jNr = Long.valueOf(aWq2.field_orderFlag);
                        AppMethodBeat.m2505o(14109);
                        return;
                    }
                }
            }
        }
        AppMethodBeat.m2505o(14109);
    }

    public final int getCount() {
        AppMethodBeat.m2504i(14110);
        int size = this.iKa.size();
        AppMethodBeat.m2505o(14110);
        return size;
    }

    /* renamed from: sg */
    public final C46627q mo61563sg(int i) {
        AppMethodBeat.m2504i(14111);
        if (i >= this.iKa.size() || i < 0) {
            AppMethodBeat.m2505o(14111);
            return null;
        }
        C46627q c46627q = (C46627q) this.iKa.get(i);
        AppMethodBeat.m2505o(14111);
        return c46627q;
    }

    public final long getItemId(int i) {
        return 0;
    }

    public final int getItemViewType(int i) {
        AppMethodBeat.m2504i(14112);
        C46627q sg = mo61563sg(i);
        if (sg == null) {
            C4990ab.m7412e("MicroMsg.BizTimeLineAdapter", "getItemViewType info is null");
            AppMethodBeat.m2505o(14112);
            return 0;
        }
        switch (sg.field_type) {
            case 1:
                AppMethodBeat.m2505o(14112);
                return 2;
            case 3:
                AppMethodBeat.m2505o(14112);
                return 4;
            case 34:
                AppMethodBeat.m2505o(14112);
                return 3;
            case 285212721:
                AppMethodBeat.m2505o(14112);
                return 1;
            default:
                AppMethodBeat.m2505o(14112);
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
        AppMethodBeat.m2504i(14113);
        C46627q sg = mo61563sg(i);
        if (sg == null) {
            C4990ab.m7412e("MicroMsg.BizTimeLineAdapter", "getView info is null");
            AppMethodBeat.m2505o(14113);
        } else {
            if (i == getCount() - 1 && !this.jNE) {
                final int i2 = i;
                C5004al.m7442n(new Runnable() {
                    public final void run() {
                        int i = 0;
                        AppMethodBeat.m2504i(14099);
                        if (i2 == C38701a.this.getCount() - 1 && !C38701a.this.jNE) {
                            C4990ab.m7417i("MicroMsg.BizTimeLineAdapter", "loadMoreData %d/%d", Integer.valueOf(i2), Integer.valueOf(C38701a.this.getCount()));
                            C38701a c38701a = C38701a.this;
                            C46627q aWp = c38701a.aWp();
                            if (aWp != null) {
                                List ah = C41747z.aeX().mo64102ah(10, aWp.field_orderFlag);
                                C38689c.m65624aX(ah);
                                c38701a.iKa.addAll(ah);
                                c38701a.notifyDataSetChanged();
                                if (ah.size() > 0) {
                                    i = 1;
                                }
                            }
                            if (i == 0) {
                                C38701a.this.jNE = true;
                                C38701a.this.jNd.aWB();
                                AppMethodBeat.m2505o(14099);
                                return;
                            }
                            C38701a.this.jNp.mo6779KB();
                        }
                        AppMethodBeat.m2505o(14099);
                    }
                }, 300);
            }
            C27519e c11234h;
            C27519e c27519e;
            C5782a QV;
            int dPe;
            LayoutParams layoutParams;
            String kr;
            View view2;
            int i3;
            switch (sg.field_type) {
                case 1:
                    if (view == null) {
                        c11234h = new C11234h();
                        view = c11234h.mo22938a(this.jNd, this);
                        view.setTag(c11234h);
                        c27519e = c11234h;
                    } else {
                        c27519e = (C11234h) view.getTag();
                    }
                    SpannableString a = C44089j.m79283a(c27519e.mContext, sg.field_content, (int) c27519e.jPi.getTextSize(), 1, null, null);
                    c27519e.jPi.setMaxLines(BaseClientBuilder.API_PRIORITY_OTHER);
                    c27519e.jPi.mo15921ah(a);
                    QV = c27519e.jPi.mo15918QV(c27519e.jPm.jNp.getContentWidth() - ((int) (C1338a.getDensity(c27519e.mContext) * 48.0f)));
                    if (QV != null) {
                        dPe = QV.dPe();
                    } else {
                        dPe = 0;
                    }
                    if (dPe > 5) {
                        if (!sg.field_isExpand) {
                            c27519e.jPi.setMaxLines(5);
                        }
                        c27519e.jPK.setVisibility(0);
                        if (sg.field_isExpand) {
                            c27519e.jPK.setText(C25738R.string.a_2);
                        } else {
                            c27519e.jPK.setText(C25738R.string.a_1);
                        }
                        c27519e.jPK.setOnClickListener(new C112351(sg));
                    } else {
                        c27519e.jPi.setMaxLines(BaseClientBuilder.API_PRIORITY_OTHER);
                        c27519e.jPK.setVisibility(8);
                    }
                    layoutParams = (LayoutParams) c27519e.jPi.getLayoutParams();
                    if (dPe == 1) {
                        layoutParams.gravity = 17;
                    } else {
                        layoutParams.gravity = 19;
                    }
                    c27519e.jPi.setLayoutParams(layoutParams);
                    c27519e.jPm.m65638a(c27519e, sg);
                    c27519e.jPm.m65636a(i, sg, c27519e.jOQ, c27519e.jOP);
                    c27519e.jPL.setOnTouchListener(c27519e.jPm.jNA);
                    c27519e.jPL.setOnLongClickListener(new C112362(sg));
                    break;
                case 3:
                    if (view == null) {
                        c11234h = new C38696d();
                        view = c11234h.mo61546a(this.jNd, this);
                        view.setTag(c11234h);
                    } else {
                        C38696d c38696d = (C38696d) view.getTag();
                    }
                    if (this.jNx == null) {
                        this.jNx = new C33731b(this.jNd);
                    }
                    C33731b c33731b = this.jNx;
                    c11234h.jPm.m65638a(c11234h, sg);
                    c11234h.jPm.m65636a(i, sg, c11234h.jOQ, c11234h.jOP);
                    sg.xHT = C42808a.m75913e(sg);
                    if (!sg.xHT) {
                        c11234h.jPk.setVisibility(0);
                        c11234h.jPj.setVisibility(8);
                        c11234h.jOS.setVisibility(8);
                        c11234h.jPi.mo15921ah(c11234h.mContext.getText(C25738R.string.a9y));
                        c33731b.mo54269a(sg, i, c11234h.jPh, 0);
                        c11234h.jPk.setOnClickListener(new C112273(sg));
                        break;
                    }
                    c11234h.jPk.setVisibility(8);
                    c11234h.jPj.setVisibility(0);
                    C27519e.m43648N(c11234h.jPg, jNe);
                    C27519e.m43648N(c11234h.jPf, jNe);
                    c33731b.mo54269a(sg, i, c11234h.jPf, jNe);
                    c11234h.jPg.setOnClickListener(new C386951(sg));
                    c11234h.jPg.setOnTouchListener(c11234h.jPm.jNA);
                    c11234h.jPg.setOnLongClickListener(new C386972(sg));
                    break;
                case 34:
                    C27519e c27519e2;
                    MMNeat7extView mMNeat7extView;
                    ImageView imageView;
                    if (view == null) {
                        c11234h = new C27521p();
                        view = c11234h.mo45312a(this.jNd, this);
                        view.setTag(c11234h);
                        c27519e2 = c11234h;
                    } else {
                        c27519e2 = (C27521p) view.getTag();
                    }
                    sg.xHT = C42808a.m75913e(sg);
                    if (sg.xHT) {
                        c27519e2.jPj.setVisibility(0);
                        c27519e2.jPk.setVisibility(8);
                        mMNeat7extView = c27519e2.jPi;
                        imageView = c27519e2.jOY;
                    } else {
                        c27519e2.jOS.setVisibility(8);
                        c27519e2.jPj.setVisibility(8);
                        c27519e2.jPk.setVisibility(0);
                        c27519e2.jQa.setVisibility(8);
                        c27519e2.jPZ.setVisibility(0);
                        mMNeat7extView = c27519e2.jQb;
                        ImageView imageView2 = c27519e2.jPZ;
                        c27519e2.jPk.setOnClickListener(new C26951());
                        imageView = imageView2;
                    }
                    C42230n c42230n = new C42230n(sg.field_content);
                    mMNeat7extView.mo15921ah(C14835h.formatTime("yyyy/MM/dd", System.currentTimeMillis() / 1000));
                    if (sg.xHT) {
                        kr = C1192l.m2623kr((int) (c42230n.time / 1000));
                        if (TextUtils.isEmpty(kr)) {
                            c27519e2.jPY.setVisibility(8);
                        } else {
                            c27519e2.jPY.setVisibility(0);
                            c27519e2.jPY.setText(kr);
                        }
                        c27519e2.jPL.setOnClickListener(new C275222());
                        c27519e2.jPL.setBackgroundResource(C25738R.drawable.f6575in);
                        view2 = c27519e2.jPL;
                        int i4 = jNh;
                        i3 = jNg;
                        int i5 = jNh;
                        view2.setPadding(i4, i3, i5, i5);
                    }
                    Drawable drawable = imageView.getDrawable();
                    if ((drawable instanceof AnimationDrawable) && ((AnimationDrawable) drawable).isRunning()) {
                        ((AnimationDrawable) drawable).stop();
                    }
                    if (c27519e2.jPm.jNv.isPlaying() && sg.field_msgId == c27519e2.jPm.jNv.jON) {
                        imageView.setImageResource(C25738R.drawable.f6569ig);
                        if (imageView.getDrawable() instanceof AnimationDrawable) {
                            ((AnimationDrawable) imageView.getDrawable()).start();
                        }
                    } else {
                        imageView.setImageResource(C25738R.drawable.f6568if);
                    }
                    imageView.setOnClickListener(new C275233(sg, imageView));
                    c27519e2.jPm.m65638a(c27519e2, sg);
                    c27519e2.jPm.m65636a(i, sg, c27519e2.jOQ, c27519e2.jOP);
                    break;
                case 285212721:
                    C27519e c27519e3;
                    if (!this.jNw) {
                        C38689c.m65627f(sg);
                    }
                    if (view == null) {
                        c27519e = new C11229f();
                        view = View.inflate(this.jNd, 2130968865, null);
                        c27519e.jPr = (LinearLayout) view.findViewById(2131821829);
                        c27519e.jPs = (LinearLayout) view.findViewById(2131821836);
                        c27519e.jPt = (TextView) view.findViewById(2131821837);
                        c27519e.jOP = (LinearLayout) view.findViewById(2131821845);
                        c27519e.jOQ = (LinearLayout) view.findViewById(2131821844);
                        c27519e.jOR = view;
                        c27519e.aWH();
                        view.setTag(c27519e);
                        c27519e3 = c27519e;
                    } else {
                        c27519e3 = (C11229f) view.getTag();
                    }
                    c27519e3.mo45311b(this.jNd, this);
                    for (C33730b c33730b : c27519e3.jPu) {
                        C44290ao.m80047aj(c33730b.jOR, 3);
                        c27519e3.jPr.removeView(c33730b.jOR);
                    }
                    c27519e3.jPu.clear();
                    C32223o b = ((C27500a) C1720g.m3528K(C27500a.class)).mo35246b(sg.field_msgId, sg.field_content);
                    List list = b.fjr;
                    int size = list.size();
                    if (size == 0) {
                        c27519e3.jPr.setVisibility(8);
                        c27519e3.mo22935a((C11229f) c27519e3, -1, 0);
                        break;
                    }
                    boolean z;
                    boolean z2;
                    LayoutInflater layoutInflater;
                    int size2;
                    C38701a c38701a;
                    View view3;
                    Context context;
                    LinearLayout linearLayout;
                    C33730b c33730b2;
                    c27519e3.jPr.setVisibility(0);
                    C32224p c32224p = (C32224p) list.get(0);
                    boolean a2 = C2703c.m4938a(sg, c32224p);
                    if (!a2) {
                        z = a2;
                    } else if (!C5046bo.isNullOrNil(c32224p.fjx) || (c32224p.type != 5 && c32224p.type != 0)) {
                        c27519e3.mo22935a((C11229f) c27519e3, ((C32224p) list.get(0)).type, size);
                        z2 = a2;
                        sg.xHT = z2;
                        layoutInflater = ((Activity) c27519e3.mContext).getLayoutInflater();
                        size2 = c27519e3.jPu.size();
                        while (true) {
                            i3 = size2;
                            if (i3 < size) {
                                size2 = 0;
                                while (true) {
                                    dPe = size2;
                                    if (dPe >= c27519e3.jPu.size()) {
                                        if (z2) {
                                            C45762c c45762c;
                                            C2703c c2703c;
                                            String str;
                                            ImageView imageView3;
                                            int i6;
                                            int i7;
                                            View view4;
                                            boolean z3;
                                            if (c32224p.type == 5) {
                                                c45762c = c27519e3.jPw;
                                                sg.xHU = C42822d.m75969FG(sg.field_talker);
                                                C27519e.m43648N(c45762c.jPn, jNe);
                                                if (C5046bo.isNullOrNil(c32224p.title)) {
                                                    c45762c.jPi.setVisibility(8);
                                                } else {
                                                    c45762c.jPi.mo15921ah(c32224p.title);
                                                    c45762c.jPi.getPaint().setFakeBoldText(true);
                                                    c45762c.jPi.setVisibility(0);
                                                }
                                                kr = C1192l.m2623kr(c32224p.fjB);
                                                if (TextUtils.isEmpty(kr)) {
                                                    c45762c.jPV.setVisibility(8);
                                                } else {
                                                    c45762c.jPV.setVisibility(0);
                                                    c45762c.jPV.setText(kr);
                                                    c45762c.jPV.setTextColor(c45762c.mContext.getResources().getColor(C25738R.color.f12119t1));
                                                }
                                                c45762c.mo45309a(c45762c, sg, c32224p);
                                                c45762c.jPm.m65637a(c32224p, sg, i, b, c45762c.jPn, size > 1, 0);
                                                c45762c.jPd.setVisibility(8);
                                                c45762c.jPi.setTextColor(c45762c.mContext.getResources().getColor(C25738R.color.f12119t1));
                                                c45762c.jPa.setTextColor(c45762c.mContext.getResources().getColor(C25738R.color.f12119t1));
                                                c45762c.jPm.jNp.mo6781a(c32224p.fjx, c45762c.jOX, sg.field_type, jNe, new C387001(sg, i), size == 1);
                                                if (size == 1) {
                                                    c45762c.jPe.setBackgroundResource(C25738R.drawable.f6452en);
                                                    c45762c.jPd.setBackgroundResource(C25738R.drawable.f6467f4);
                                                } else {
                                                    c45762c.jPe.setBackgroundResource(C25738R.drawable.f6454ep);
                                                    c45762c.jPd.setBackgroundResource(C25738R.drawable.f6468f5);
                                                }
                                                if (C1338a.m2860dm(c45762c.mContext) >= 1.375f) {
                                                    c45762c.jPi.setMaxLines(1);
                                                } else {
                                                    c45762c.jPi.setMaxLines(2);
                                                }
                                            } else if (c32224p.type == 8) {
                                                c45762c = c27519e3.jPx;
                                                C27519e.m43648N(c45762c.jPQ, jNe);
                                                c45762c.jPd.setVisibility(8);
                                                c45762c.jPa.setTextColor(c45762c.mContext.getResources().getColor(C25738R.color.f12119t1));
                                                c45762c.iNr.setBackgroundResource(C1318a.chatting_item_biz_pic_loading_icon);
                                                c45762c.jPm.jNp.mo6781a(c32224p.fjx, c45762c.jOX, sg.field_type, jNe, new C112391(sg, i), size == 1);
                                                c45762c.mo45309a(c45762c, sg, c32224p);
                                                c45762c.jPm.m65637a(c32224p, sg, i, b, c45762c.jPn, size > 1, 0);
                                                if (size == 1) {
                                                    c45762c.jPe.setBackgroundResource(C25738R.drawable.f6452en);
                                                    c45762c.jPd.setBackgroundResource(C25738R.drawable.f6459ew);
                                                } else {
                                                    c45762c.jPe.setBackgroundResource(C25738R.drawable.f6454ep);
                                                    c45762c.jPd.setBackgroundResource(C25738R.drawable.f6460ex);
                                                }
                                            } else if (c32224p.type == 7) {
                                                C27520n c27520n = c27519e3.jPy;
                                                if (C5046bo.isNullOrNil(c32224p.title)) {
                                                    c27520n.jPi.setVisibility(8);
                                                } else {
                                                    c27520n.jPi.setVisibility(0);
                                                    c27520n.jPi.mo15921ah(c32224p.title);
                                                }
                                                kr = C1192l.m2623kr(c32224p.fjB);
                                                if (TextUtils.isEmpty(kr)) {
                                                    c27520n.jPY.setVisibility(8);
                                                } else {
                                                    c27520n.jPY.setVisibility(0);
                                                    c27520n.jPY.setText(kr);
                                                }
                                                Drawable drawable2 = c27520n.jOY.getDrawable();
                                                if ((drawable2 instanceof AnimationDrawable) && ((AnimationDrawable) drawable2).isRunning()) {
                                                    ((AnimationDrawable) drawable2).stop();
                                                }
                                                if ((sg.field_msgId + "_0").equals(C38689c.aYR())) {
                                                    c27520n.jOY.setImageResource(C25738R.drawable.f6569ig);
                                                    if (c27520n.jOY.getDrawable() instanceof AnimationDrawable) {
                                                        ((AnimationDrawable) c27520n.jOY.getDrawable()).start();
                                                    }
                                                } else {
                                                    c27520n.jOY.setImageResource(C25738R.drawable.f6568if);
                                                }
                                                c27520n.mo45307a(c27520n.jOY, sg, 0, c32224p.fjx);
                                                c27520n.mo45309a(c27520n, sg, c32224p);
                                                c27520n.jPm.m65637a(c32224p, sg, i, b, c27520n.jPn, size > 1, 0);
                                                if (size == 1) {
                                                    c27520n.jPn.setBackgroundResource(C25738R.drawable.f6575in);
                                                } else {
                                                    c27520n.jPn.setBackgroundResource(C25738R.drawable.f6576io);
                                                }
                                                c27520n.jPn.setPadding(jNh, jNg, jNh, jNg);
                                            } else if (c32224p.type == 6) {
                                                C11237i c11237i = c27519e3.jPz;
                                                C32224p c32224p2 = (C32224p) list.get(0);
                                                if (C5046bo.isNullOrNil(c32224p2.title)) {
                                                    c11237i.jPi.setVisibility(8);
                                                } else {
                                                    c11237i.jPi.setVisibility(0);
                                                    c11237i.jPi.mo15921ah(c32224p2.title);
                                                }
                                                if (TextUtils.isEmpty(c32224p2.fjL)) {
                                                    c11237i.jPN.setVisibility(8);
                                                } else {
                                                    c11237i.jPN.setVisibility(0);
                                                    c11237i.jPN.setText(c32224p2.fjL);
                                                }
                                                if (c32224p2.fjM == 2) {
                                                    c11237i.jPO.setImageResource(C1318a.chatting_item_biz_kugou_music_watermark);
                                                } else {
                                                    c11237i.jPO.setImageResource(C1318a.chatting_item_biz_qq_music_watermark);
                                                }
                                                c11237i.mo45307a(c11237i.jOY, sg, 0, c32224p2.fjx);
                                                c11237i.mo45309a(c11237i, sg, c32224p2);
                                                c11237i.jPm.m65637a(c32224p2, sg, i, b, c11237i.jPn, size > 1, 0);
                                                if ((sg.field_msgId + "_0").equals(C38689c.aYR())) {
                                                    c11237i.jOY.setImageResource(C1318a.chatting_item_biz_music_pause_loading_icon);
                                                } else {
                                                    c11237i.jOY.setImageResource(C1318a.chatting_item_biz_music_play_loading_icon);
                                                }
                                                c11237i.jPd.setVisibility(8);
                                                c2703c = c11237i.jPm.jNp;
                                                str = c32224p2.fjx;
                                                imageView3 = c11237i.jOX;
                                                i6 = sg.field_type;
                                                i7 = jNf;
                                                c2703c.mo6780a(str, imageView3, i6, i7, i7, "@S", new C112381(sg, i));
                                                if (size == 1) {
                                                    c11237i.jPn.setBackgroundResource(C25738R.drawable.f6575in);
                                                } else {
                                                    c11237i.jPn.setBackgroundResource(C25738R.drawable.f6576io);
                                                }
                                                view2 = c11237i.jPn;
                                                if (size > 1) {
                                                    dPe = jNh;
                                                    i3 = jNh;
                                                    view2.setPadding(dPe, dPe, i3, i3);
                                                } else {
                                                    dPe = jNh;
                                                    view2.setPadding(dPe, dPe, jNh, jNg);
                                                }
                                            } else if (c32224p.type == 10) {
                                                C46900l c46900l = c27519e3.jPA;
                                                sg.xHU = C42822d.m75969FG(sg.field_talker);
                                                if (C5046bo.isNullOrNil(c32224p.title)) {
                                                    c46900l.jPi.setVisibility(8);
                                                } else {
                                                    c46900l.jPi.setVisibility(0);
                                                    c46900l.jPi.mo15921ah(C44089j.m79282a(c46900l.mContext, c32224p.title, (int) c46900l.jPi.getTextSize()));
                                                    QV = c46900l.jPi.mo15918QV(c46900l.jPm.jNp.getContentWidth() - ((int) (C1338a.getDensity(c46900l.mContext) * 48.0f)));
                                                    if (QV != null) {
                                                        dPe = QV.dPe();
                                                    } else {
                                                        dPe = 0;
                                                    }
                                                    layoutParams = (LayoutParams) c46900l.jPi.getLayoutParams();
                                                    if (dPe == 1) {
                                                        layoutParams.gravity = 17;
                                                    } else {
                                                        layoutParams.gravity = 19;
                                                    }
                                                    c46900l.jPi.setLayoutParams(layoutParams);
                                                }
                                                if (size > 1) {
                                                    c46900l.jPU.setVisibility(8);
                                                    c46900l.jPn.setBackgroundResource(C25738R.drawable.f6576io);
                                                } else {
                                                    c46900l.jPU.setVisibility(0);
                                                    c46900l.jPn.setBackgroundResource(C25738R.drawable.f6575in);
                                                }
                                                c46900l.mo45309a(c46900l, sg, c32224p);
                                                c38701a = c46900l.jPm;
                                                view4 = c46900l.jPn;
                                                if (size > 1) {
                                                    z3 = true;
                                                } else {
                                                    z3 = false;
                                                }
                                                c38701a.m65637a(c32224p, sg, i, b, view4, z3, 0);
                                            } else {
                                                boolean z4;
                                                C38698k c38698k = c27519e3.jPv;
                                                C27519e.m43648N(c38698k.jOX, jNe);
                                                c38698k.jPi.mo15921ah(c32224p.title);
                                                c38698k.jPi.getPaint().setFakeBoldText(true);
                                                c38698k.jOX.setVisibility(0);
                                                c38698k.jPi.setTextColor(c38698k.mContext.getResources().getColor(C25738R.color.f12119t1));
                                                c38698k.jPa.setTextColor(c38698k.mContext.getResources().getColor(C25738R.color.f12119t1));
                                                c38698k.jPS.setBackgroundResource(C25738R.drawable.f6900uv);
                                                c2703c = c38698k.jPm.jNp;
                                                str = c32224p.fjx;
                                                imageView3 = c38698k.jOX;
                                                i6 = sg.field_type;
                                                i7 = jNe;
                                                C35837a c112401 = new C112401(size, sg, i);
                                                if (size == 1) {
                                                    z4 = true;
                                                } else {
                                                    z4 = false;
                                                }
                                                c2703c.mo6781a(str, imageView3, i6, i7, c112401, z4);
                                                if (size == 1) {
                                                    c38698k.jPe.setBackgroundResource(C25738R.drawable.f6452en);
                                                } else {
                                                    c38698k.jPe.setBackgroundResource(C25738R.drawable.f6454ep);
                                                }
                                                c38698k.mo45309a(c38698k, sg, c32224p);
                                                c38701a = c38698k.jPm;
                                                view4 = c38698k.jPn;
                                                if (size > 1) {
                                                    z3 = true;
                                                } else {
                                                    z3 = false;
                                                }
                                                c38701a.m65637a(c32224p, sg, i, b, view4, z3, 0);
                                            }
                                        }
                                        if (size <= 2 || sg.field_isExpand) {
                                            c27519e3.jPs.setVisibility(8);
                                        } else {
                                            c27519e3.jPs.setVisibility(0);
                                            c27519e3.jPt.setText(c27519e3.mContext.getString(C25738R.string.a_h, new Object[]{Integer.valueOf(size - 2)}));
                                            c27519e3.jPs.setTag(sg);
                                            c27519e3.jPs.setOnClickListener(c27519e3.jPB);
                                        }
                                        int i8 = z2 ? 1 : 0;
                                        while (i8 < size && (sg.field_isExpand || i8 <= 1)) {
                                            C32224p c32224p3 = (C32224p) list.get(i8);
                                            List list2 = c27519e3.jPu;
                                            if (z2) {
                                                size2 = i8 - 1;
                                            } else {
                                                size2 = i8;
                                            }
                                            C33730b c33730b3 = (C33730b) list2.get(size2);
                                            size2 = c32224p.type;
                                            if (i8 == 0) {
                                                c33730b3.jOS.setVisibility(8);
                                            } else if (z2 && i8 == 1 && (size2 == 5 || size2 == 8 || size2 == 0)) {
                                                c33730b3.jOS.setVisibility(8);
                                            } else {
                                                c33730b3.jOS.setVisibility(0);
                                                if (!z2 || i8 > 1) {
                                                    C32224p c32224p4 = (C32224p) list.get(i8 - 1);
                                                    C32224p c32224p5 = (C32224p) list.get(i8);
                                                    if ((c32224p4.type == 7 || c32224p4.type == 5 || c32224p4.type == 6 || !C5046bo.isNullOrNil(c32224p4.fjx)) && (c32224p5.type == 7 || c32224p5.type == 5 || c32224p5.type == 6 || !C5046bo.isNullOrNil(c32224p5.fjx))) {
                                                        C11229f.m18950O(c33730b3.jOS, jNj);
                                                    } else {
                                                        C11229f.m18950O(c33730b3.jOS, jNh);
                                                    }
                                                } else {
                                                    C11229f.m18950O(c33730b3.jOS, jNh);
                                                }
                                            }
                                            if (z2) {
                                                if (i8 == 1) {
                                                    if (i8 == size - 1) {
                                                        C11229f.m18952r(c33730b3.jOT, jNh, jNg);
                                                    } else {
                                                        C11229f.m18952r(c33730b3.jOT, jNh, jNi);
                                                    }
                                                } else if (i8 == size - 1) {
                                                    C11229f.m18952r(c33730b3.jOT, jNi, jNg);
                                                } else {
                                                    view2 = c33730b3.jOT;
                                                    dPe = jNi;
                                                    C11229f.m18952r(view2, dPe, dPe);
                                                }
                                            } else if (i8 == 0) {
                                                if (size == 1) {
                                                    C11229f.m18952r(c33730b3.jOT, jNh, jNg);
                                                } else {
                                                    C11229f.m18952r(c33730b3.jOT, jNh, jNi);
                                                }
                                            } else if (i8 == 1) {
                                                if (size == 2) {
                                                    C11229f.m18952r(c33730b3.jOT, jNi, jNg);
                                                } else {
                                                    view2 = c33730b3.jOT;
                                                    dPe = jNi;
                                                    C11229f.m18952r(view2, dPe, dPe);
                                                }
                                            } else if (i8 == size - 1) {
                                                C11229f.m18952r(c33730b3.jOT, jNi, jNg);
                                            } else {
                                                view2 = c33730b3.jOT;
                                                dPe = jNi;
                                                C11229f.m18952r(view2, dPe, dPe);
                                            }
                                            c33730b3.mo54268a(c32224p3, sg, i8, false);
                                            c33730b3.mo45308a(c33730b3.jOZ, c33730b3.jPa, sg, c32224p3);
                                            c33730b3.jOU.mo15921ah(c32224p3.title);
                                            c33730b3.jOU.setTextColor(c27519e3.mContext.getResources().getColor(C25738R.color.f11782h4));
                                            if (c32224p3.fjA == 0 || c32224p3.fjA == 1) {
                                                c33730b3.jOW.setVisibility(0);
                                                c33730b3.jOU.setTextColor(c27519e3.mContext.getResources().getColor(C25738R.color.f11782h4));
                                                ImageView imageView4;
                                                if (c32224p3.type == 7) {
                                                    c33730b3.jOX.setVisibility(8);
                                                } else if (!C5046bo.isNullOrNil(c32224p3.fjx)) {
                                                    c33730b3.jOX.setVisibility(0);
                                                    String str2 = c32224p3.fjx;
                                                    String str3 = "@S";
                                                    if (i8 == 0 && !C5046bo.isNullOrNil(c32224p3.fjO)) {
                                                        str2 = C1192l.m2619a(c32224p3);
                                                    } else if (i8 == 0) {
                                                        str3 = "@T";
                                                    }
                                                    C2703c c2703c2 = c27519e3.jPm.jNp;
                                                    imageView4 = c33730b3.jOX;
                                                    int i9 = sg.field_type;
                                                    int i10 = jNf;
                                                    c2703c2.mo6780a(str2, imageView4, i9, i10, i10, str3, new C112312(c33730b3, c32224p3, sg, i8));
                                                } else if (c32224p3.type == 5 || c32224p3.type == 6) {
                                                    c33730b3.jOX.setVisibility(0);
                                                    C2703c c2703c3 = c27519e3.jPm.jNp;
                                                    imageView4 = c33730b3.jOX;
                                                    dPe = jNf;
                                                    imageView4.setContentDescription(c2703c3.jNd.getString(C25738R.string.al_));
                                                    C25815a ahp = C32291o.ahp();
                                                    C17927a c17927a = new C17927a();
                                                    c17927a.ePF = true;
                                                    c17927a.ePT = C25738R.color.f11875k8;
                                                    c17927a = c17927a.mo33448ct(dPe, dPe);
                                                    c17927a.fHe = 4;
                                                    ahp.mo43769a("2130841060", imageView4, c17927a.ahG(), null, new C35836e());
                                                } else {
                                                    c33730b3.jOW.setVisibility(8);
                                                }
                                            } else {
                                                c33730b3.jOW.setVisibility(8);
                                                c33730b3.jOU.setTextColor(c27519e3.mContext.getResources().getColor(C25738R.color.f12092s0));
                                            }
                                            if (C5046bo.isNullOrNil(c32224p3.fjz) || c32224p3.type != 3) {
                                                c33730b3.jOV.setVisibility(8);
                                            } else {
                                                c33730b3.jOV.setText(c32224p3.fjz);
                                                c33730b3.jOV.setVisibility(0);
                                            }
                                            c33730b3.jOR.setVisibility(0);
                                            c27519e3.jPm.m65637a(c32224p3, sg, i, b, c33730b3.jOR, size > 1, i8);
                                            if (i8 != size - 1 || c27519e3.jPs.getVisibility() == 0) {
                                                c33730b3.jOR.setBackgroundResource(C25738R.drawable.f6576io);
                                            } else {
                                                c33730b3.jOR.setBackgroundResource(C25738R.drawable.f6575in);
                                            }
                                            i8++;
                                        }
                                        c27519e3.jPm.m65636a(i, sg, c27519e3.jOQ, c27519e3.jOP);
                                        c27519e3.jPm.m65638a(c27519e3, sg);
                                        break;
                                    }
                                    ((C33730b) c27519e3.jPu.get(dPe)).jOR.setVisibility(8);
                                    size2 = dPe + 1;
                                }
                            } else {
                                view2 = C44290ao.m80046Ot(3);
                                if (view2 == null) {
                                    view2 = layoutInflater.inflate(2130968866, null);
                                }
                                view3 = view2;
                                c38701a = c27519e3.jPm;
                                context = c27519e3.mContext;
                                linearLayout = c27519e3.jPr;
                                c33730b2 = new C33730b(c38701a, context);
                                c33730b2.jOR = view3;
                                c33730b2.jOS = view3.findViewById(2131821838);
                                c33730b2.jOT = view3.findViewById(2131821839);
                                c33730b2.jOU = (MMNeat7extView) view3.findViewById(2131821840);
                                c33730b2.jOV = (TextView) view3.findViewById(2131821841);
                                c33730b2.jOW = view3.findViewById(2131821403);
                                c33730b2.jOX = (ImageView) view3.findViewById(2131821842);
                                c33730b2.jOY = (ImageView) view3.findViewById(2131821843);
                                c33730b2.jOZ = view3.findViewById(2131821848);
                                c33730b2.jPa = (TextView) view3.findViewById(2131821849);
                                linearLayout.addView(view3, linearLayout.getChildCount());
                                c27519e3.jPu.add(c33730b2);
                                size2 = i3 + 1;
                            }
                        }
                    } else {
                        z = false;
                    }
                    c27519e3.mo22935a((C11229f) c27519e3, -1, size);
                    z2 = z;
                    sg.xHT = z2;
                    layoutInflater = ((Activity) c27519e3.mContext).getLayoutInflater();
                    size2 = c27519e3.jPu.size();
                    while (true) {
                        i3 = size2;
                        if (i3 < size) {
                        }
                        view3 = view2;
                        c38701a = c27519e3.jPm;
                        context = c27519e3.mContext;
                        linearLayout = c27519e3.jPr;
                        c33730b2 = new C33730b(c38701a, context);
                        c33730b2.jOR = view3;
                        c33730b2.jOS = view3.findViewById(2131821838);
                        c33730b2.jOT = view3.findViewById(2131821839);
                        c33730b2.jOU = (MMNeat7extView) view3.findViewById(2131821840);
                        c33730b2.jOV = (TextView) view3.findViewById(2131821841);
                        c33730b2.jOW = view3.findViewById(2131821403);
                        c33730b2.jOX = (ImageView) view3.findViewById(2131821842);
                        c33730b2.jOY = (ImageView) view3.findViewById(2131821843);
                        c33730b2.jOZ = view3.findViewById(2131821848);
                        c33730b2.jPa = (TextView) view3.findViewById(2131821849);
                        linearLayout.addView(view3, linearLayout.getChildCount());
                        c27519e3.jPu.add(c33730b2);
                        size2 = i3 + 1;
                    }
                    break;
                default:
                    if (view == null) {
                        c27519e = new C20054o();
                        BizTimeLineUI bizTimeLineUI = this.jNd;
                        if (c27519e.jOR != null) {
                            view2 = c27519e.jOR;
                        } else {
                            c27519e.jOR = View.inflate(bizTimeLineUI, 2130968878, null);
                            c27519e.aWH();
                            view2 = c27519e.jOR;
                        }
                        view2.setTag(c27519e);
                        view = view2;
                    } else {
                        c27519e = (C20054o) view.getTag();
                    }
                    m65638a(c27519e, sg);
                    m65636a(i, sg, c27519e.jOQ, c27519e.jOP);
                    break;
            }
            if (!(this.jNw || this.cAY)) {
                this.jNy.mo35303c(sg, i);
                mo61548FE(sg.field_talker);
            }
            AppMethodBeat.m2505o(14113);
        }
        return view;
    }

    /* renamed from: FE */
    public final void mo61548FE(String str) {
        AppMethodBeat.m2504i(14114);
        C1720g.m3537RQ();
        if (C1668a.m3404jP(C1720g.m3534RN().eIV) && !this.jNz.contains(str)) {
            C37951y.m64163ab(str, 2);
            this.jNz.add(str);
        }
        AppMethodBeat.m2505o(14114);
    }

    /* renamed from: a */
    public final void mo61549a(C46627q c46627q) {
        AppMethodBeat.m2504i(14115);
        if (c46627q == null) {
            C4990ab.m7420w("MicroMsg.BizTimeLineAdapter", "updateGroupId info is null");
            AppMethodBeat.m2505o(14115);
            return;
        }
        C4990ab.m7411d("MicroMsg.BizTimeLineAdapter", "updateGroupId keep %b, groupId %d, maxGroupId %d", Boolean.valueOf(this.jNw), Long.valueOf(c46627q.drB()), Long.valueOf(C41747z.aeX().drL()));
        if (!this.jNw && r0 == r2) {
            final long j = c46627q.field_orderFlag;
            C41930g.m74067da(Long.valueOf(j)).mo60492h(new C5681a<Boolean, Long>() {
                public final /* synthetic */ Object call(Object obj) {
                    AppMethodBeat.m2504i(14101);
                    Boolean valueOf = Boolean.valueOf(C30309s.m48273mL(j));
                    AppMethodBeat.m2505o(14101);
                    return valueOf;
                }
            }).mo60487b(new C387043());
        }
        AppMethodBeat.m2505o(14115);
    }

    /* renamed from: a */
    private boolean m65640a(C46627q c46627q, int i) {
        AppMethodBeat.m2504i(14116);
        if (jNr == null) {
            long drB = c46627q.drB();
            long j = 0;
            C46627q sg = mo61563sg(i - 1);
            if (sg != null) {
                j = sg.drB();
            }
            if (drB == j || jNt == null || j != jNt.longValue()) {
                AppMethodBeat.m2505o(14116);
                return false;
            }
            jNr = Long.valueOf(c46627q.field_orderFlag);
            AppMethodBeat.m2505o(14116);
            return true;
        } else if (jNr.longValue() == c46627q.field_orderFlag) {
            AppMethodBeat.m2505o(14116);
            return true;
        } else {
            AppMethodBeat.m2505o(14116);
            return false;
        }
    }

    /* renamed from: b */
    private boolean m65643b(C46627q c46627q, int i) {
        AppMethodBeat.m2504i(14117);
        if (jNs == null) {
            C46627q sg = mo61563sg(i - 1);
            if (sg == null) {
                AppMethodBeat.m2505o(14117);
                return false;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - c46627q.field_createTime <= 86400000 || currentTimeMillis - sg.field_createTime > 86400000) {
                AppMethodBeat.m2505o(14117);
                return false;
            } else if (aWs() || (jNr != null && jNr.longValue() > c46627q.field_orderFlag)) {
                jNs = Long.valueOf(c46627q.field_orderFlag);
                AppMethodBeat.m2505o(14117);
                return true;
            } else {
                jNs = Long.valueOf(-1);
                AppMethodBeat.m2505o(14117);
                return false;
            }
        } else if (jNr != null && jNr.longValue() <= jNs.longValue()) {
            jNs = Long.valueOf(-1);
            AppMethodBeat.m2505o(14117);
            return false;
        } else if (jNs.longValue() == c46627q.field_orderFlag) {
            AppMethodBeat.m2505o(14117);
            return true;
        } else {
            AppMethodBeat.m2505o(14117);
            return false;
        }
    }

    /* renamed from: a */
    private void m65636a(int i, C46627q c46627q, View view, View view2) {
        AppMethodBeat.m2504i(14118);
        if (i > 0) {
            view.setVisibility(0);
            if (m65640a(c46627q, i)) {
                view2.setVisibility(0);
                ((TextView) view2.findViewById(2131821846)).setText(this.jNd.getString(C25738R.string.a9z));
            } else if (m65643b(c46627q, i)) {
                view2.setVisibility(0);
                ((TextView) view2.findViewById(2131821846)).setText(this.jNd.getString(C25738R.string.a_0));
            } else {
                view2.setVisibility(8);
            }
        } else {
            view.setVisibility(0);
            view2.setVisibility(8);
        }
        mo61549a(c46627q);
        AppMethodBeat.m2505o(14118);
    }

    /* renamed from: a */
    private void m65637a(C32224p c32224p, final C46627q c46627q, int i, C32223o c32223o, View view, boolean z, int i2) {
        AppMethodBeat.m2504i(14119);
        ((C20022a) C1720g.m3528K(C20022a.class)).mo35262a(c32224p, c46627q, i, c32223o, view, z, i2, this.jND);
        view.setOnTouchListener(this.jNA);
        final int i3 = i2;
        view.setOnLongClickListener(new OnLongClickListener() {
            public final boolean onLongClick(View view) {
                AppMethodBeat.m2504i(14102);
                C38701a.this.jNl = c46627q;
                C38701a.this.jNm = i3;
                C38701a.this.jNn = 1;
                C38701a.this.jMO.mo39886a(view, C38701a.this, C38701a.this.jNq, C38701a.this.jLX, C38701a.this.jLY);
                AppMethodBeat.m2505o(14102);
                return true;
            }
        });
        if (c32224p.type == 5 && ((C20023b) C1720g.m3528K(C20023b.class)).aVP()) {
            i3 = i2;
            view.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    View findViewById;
                    AppMethodBeat.m2504i(14103);
                    int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
                    if (i3 > 0 || !c46627q.xHT) {
                        findViewById = view.findViewById(2131821842);
                    } else {
                        findViewById = view.findViewById(2131821404);
                    }
                    Bundle bundle = new Bundle();
                    bundle.putInt("biz_video_scene", 90);
                    bundle.putInt("biz_video_subscene", C38701a.this.jNd.getIntent().getIntExtra("KOpenArticleSceneFromScene", Downloads.MIN_WAIT_FOR_NETWORK));
                    bundle.putInt("geta8key_scene", 56);
                    C11263c.m18982a(C38701a.this.jNd, c46627q.field_msgId, c46627q.field_msgSvrId, i3, findViewById, bundle);
                    C38701a.this.jND.mo22942a(c46627q, i3, currentTimeMillis);
                    AppMethodBeat.m2505o(14103);
                }
            });
        }
        AppMethodBeat.m2505o(14119);
    }

    /* renamed from: a */
    private void m65638a(C27519e c27519e, C46627q c46627q) {
        AppMethodBeat.m2504i(14120);
        C40460b.m69437r(c27519e.ejo, c46627q.field_talker);
        CharSequence mJ = C1854s.m3866mJ(c46627q.field_talker);
        C7616ad aoO = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(c46627q.field_talker);
        if (aoO == null || !aoO.mo16702Oe()) {
            c27519e.jPp.setText(C44089j.m79293b(this.jNd, mJ, c27519e.jPp.getTextSize()));
        } else {
            Drawable drawable = this.jNd.getResources().getDrawable(C25738R.drawable.axl);
            int textSize = (int) c27519e.jPp.getTextSize();
            drawable.setBounds(0, 0, textSize, textSize);
            C5664a c5664a = new C5664a(drawable);
            new SpannableString("@").setSpan(c5664a, 0, 1, 33);
            c27519e.jPp.setText(TextUtils.concat(new CharSequence[]{C44089j.m79293b(this.jNd, mJ, c27519e.jPp.getTextSize()) + "  ", r0}));
        }
        if (c46627q.field_isRead == 1) {
            c27519e.jPp.getPaint().setFakeBoldText(false);
            c27519e.jPp.setTextColor(this.jNd.getResources().getColor(C25738R.color.f12084rr));
        } else {
            c27519e.jPp.getPaint().setFakeBoldText(true);
            c27519e.jPp.setTextColor(this.jNd.getResources().getColor(C25738R.color.f11782h4));
        }
        c27519e.enf.setText(C42809b.m75917e(this.jNd, c46627q.field_createTime));
        c27519e.jPo.setOnTouchListener(this.jNA);
        c27519e.jPo.setTag(c46627q);
        c27519e.jPo.setOnLongClickListener(this.jNB);
        c27519e.jPo.setOnClickListener(this.jNC);
        AppMethodBeat.m2505o(14120);
    }

    public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        AppMethodBeat.m2504i(14121);
        if (this.jNl == null) {
            C4990ab.m7420w("MicroMsg.BizTimeLineAdapter", "onCreateContextMenu mInfo == null");
            AppMethodBeat.m2505o(14121);
        } else if (this.jNn == 0) {
            C7616ad aoO = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(this.jNl.field_talker);
            if (aoO == null) {
                C4990ab.m7412e("MicroMsg.BizTimeLineAdapter", "onCreateContextMenu, contact is null, talker = " + this.jNl.field_talker);
                AppMethodBeat.m2505o(14121);
                return;
            }
            contextMenu.setHeaderTitle(C44089j.m79292b(this.jNd, aoO.mo16707Oj()));
            if (C7486a.m12942jh(aoO.field_type)) {
                contextMenu.add(0, 10, 0, C25738R.string.a9p);
                contextMenu.add(0, 2, 0, C25738R.string.cvi);
            }
            AppMethodBeat.m2505o(14121);
        } else {
            contextMenu.add(0, 11, 0, C25738R.string.a9r);
            AppMethodBeat.m2505o(14121);
        }
    }

    public final void notifyDataSetChanged() {
        AppMethodBeat.m2504i(14122);
        super.notifyDataSetChanged();
        AppMethodBeat.m2505o(14122);
    }

    public final C46627q aWp() {
        AppMethodBeat.m2504i(14123);
        if (this.iKa.size() > 0) {
            C46627q c46627q = (C46627q) this.iKa.get(this.iKa.size() - 1);
            AppMethodBeat.m2505o(14123);
            return c46627q;
        }
        AppMethodBeat.m2505o(14123);
        return null;
    }

    public final C46627q aWq() {
        AppMethodBeat.m2504i(14124);
        if (this.iKa.size() > 0) {
            C46627q c46627q = (C46627q) this.iKa.get(0);
            AppMethodBeat.m2505o(14124);
            return c46627q;
        }
        AppMethodBeat.m2505o(14124);
        return null;
    }

    public final void aWr() {
        AppMethodBeat.m2504i(14125);
        C46627q aWq = aWq();
        if (aWq != null) {
            jNt = Long.valueOf(aWq.drB());
        }
        jNr = null;
        jNs = null;
        AppMethodBeat.m2505o(14125);
    }

    private boolean aWs() {
        AppMethodBeat.m2504i(14126);
        C46627q aWq = aWq();
        if (aWq == null) {
            AppMethodBeat.m2505o(14126);
            return false;
        } else if (aWq.drF()) {
            AppMethodBeat.m2505o(14126);
            return true;
        } else {
            if (this.jNu < 0) {
                aWt();
            }
            if (aWq.drB() == this.jNu) {
                AppMethodBeat.m2505o(14126);
                return true;
            }
            AppMethodBeat.m2505o(14126);
            return false;
        }
    }

    public final boolean isEmpty() {
        AppMethodBeat.m2504i(14127);
        if (super.isEmpty()) {
            if (C41747z.aeY().baS() > 0) {
                AppMethodBeat.m2505o(14127);
                return false;
            }
            boolean z;
            chc aWL = C42822d.aWL();
            if (aWL == null || C5046bo.m7548ek(aWL.xfW)) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                AppMethodBeat.m2505o(14127);
                return false;
            }
        }
        boolean isEmpty = super.isEmpty();
        AppMethodBeat.m2505o(14127);
        return isEmpty;
    }

    private void aWt() {
        AppMethodBeat.m2504i(14128);
        C46627q drJ = C41747z.aeX().drJ();
        if (drJ != null) {
            this.jNu = drJ.drB();
        }
        AppMethodBeat.m2505o(14128);
    }

    /* renamed from: dD */
    public final void mo61553dD(int i, int i2) {
        AppMethodBeat.m2504i(14129);
        ArrayList arrayList = new ArrayList();
        while (i <= i2) {
            C46627q sg = mo61563sg(i);
            if (!(sg == null || sg.field_type != 285212721 || this.jNF.contains(Long.valueOf(sg.field_msgId)))) {
                C4990ab.m7418v("MicroMsg.BizTimeLineAdapter", "terry checkpreload:" + sg.field_msgId);
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
            PreloadLogic.m31031j(arrayList, 90);
        }
        AppMethodBeat.m2505o(14129);
    }
}
