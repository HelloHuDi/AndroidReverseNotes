package com.tencent.p177mm.p612ui.conversation;

import android.content.Context;
import android.content.res.ColorStateList;
import android.database.Cursor;
import android.database.MergeCursor;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.format.Time;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.booter.notification.p841a.C37622h;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1854s;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.modelvoice.C42230n;
import com.tencent.p177mm.p181af.C32223o;
import com.tencent.p177mm.p181af.C32224p;
import com.tencent.p177mm.p203bg.C32337g;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p230g.p231a.C42062sz;
import com.tencent.p177mm.p612ui.C46692p;
import com.tencent.p177mm.p612ui.C46692p.C30723a;
import com.tencent.p177mm.p612ui.base.MMSlideDelView;
import com.tencent.p177mm.p612ui.base.MMSlideDelView.C15521c;
import com.tencent.p177mm.p612ui.base.MMSlideDelView.C23597d;
import com.tencent.p177mm.p612ui.base.MMSlideDelView.C23599f;
import com.tencent.p177mm.p612ui.base.MMSlideDelView.C23600g;
import com.tencent.p177mm.p612ui.base.NoMeasuredTextView;
import com.tencent.p177mm.p612ui.p613a.C5216a.C5215a;
import com.tencent.p177mm.p612ui.tools.C44385r;
import com.tencent.p177mm.p612ui.widget.C5664a;
import com.tencent.p177mm.p761o.C7487a;
import com.tencent.p177mm.p837bh.C25859d;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.platformtools.C42252ah;
import com.tencent.p177mm.plugin.biz.p1395a.C27500a;
import com.tencent.p177mm.plugin.brandservice.p1241a.C20023b;
import com.tencent.p177mm.plugin.emoji.p725b.C6835d;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.p455a.C43298a;
import com.tencent.p177mm.pluginsdk.p1079f.C14835h;
import com.tencent.p177mm.pluginsdk.p1079f.C46486g;
import com.tencent.p177mm.pluginsdk.p597ui.C14943d;
import com.tencent.p177mm.pluginsdk.p597ui.C40459a;
import com.tencent.p177mm.pluginsdk.p597ui.C40459a.C40460b;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.p603e.C4935m;
import com.tencent.p177mm.sdk.p603e.C7298n;
import com.tencent.p177mm.sdk.p603e.C7298n.C4937b;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4988aa;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C7564ap;
import com.tencent.p177mm.sdk.platformtools.C7564ap.C5015a;
import com.tencent.p177mm.storage.C5140bq;
import com.tencent.p177mm.storage.C7616ad;
import com.tencent.p177mm.storage.C7617ak;
import com.tencent.ttpic.thread.FaceGestureDetGLThread;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map.Entry;

/* renamed from: com.tencent.mm.ui.conversation.e */
public class C36282e extends C46692p<C7617ak> implements C4937b {
    private static long zrA = FaceGestureDetGLThread.BRIGHTNESS_DURATION;
    protected List<String> elZ = null;
    private String gtX;
    private boolean gxV = false;
    protected C23600g jJO;
    protected C15521c jJP;
    protected C23599f jJQ;
    protected C23597d jJR = MMSlideDelView.getItemStatusCallBack();
    private boolean lhi = false;
    boolean riR = false;
    private float yDU = -1.0f;
    protected float yDV = -1.0f;
    private float yDW = -1.0f;
    private ColorStateList[] yDX = new ColorStateList[5];
    HashMap<String, C36279d> yDY;
    private boolean zrB = false;
    private C7564ap zrC = new C7564ap(C9638aw.m17180RS().oAl.getLooper(), new C362831(), false);
    HashSet<Long> zrD = new HashSet();
    private boolean zrm = true;
    private C36281f zrn;
    private C14943d zro;
    private boolean zrp = false;
    private boolean zrq = false;
    private boolean zrr = false;
    private C36278c zrs;
    private C4884c zrt = null;
    private C36277b zru = null;
    public String zrv = "";
    final C36280e zrw = new C36280e();
    private final int zrx;
    private final int zry;
    private C15868a zrz;

    /* renamed from: com.tencent.mm.ui.conversation.e$g */
    public static class C5486g {
        public ImageView ejo;
        public TextView jJV;
        public NoMeasuredTextView yEc;
        public NoMeasuredTextView yEd;
        public NoMeasuredTextView yEe;
        public ImageView yEf;
        public ImageView yEg;
        public View yEh;
        public NoMeasuredTextView zrV;
        public ImageView zrW;
    }

    /* renamed from: com.tencent.mm.ui.conversation.e$a */
    class C15868a {
        public String bCu;
        public String content;
        public int zrF;
        public String zrG;

        private C15868a() {
        }

        /* synthetic */ C15868a(C36282e c36282e, byte b) {
            this();
        }
    }

    /* renamed from: com.tencent.mm.ui.conversation.e$b */
    public interface C36277b {
    }

    /* renamed from: com.tencent.mm.ui.conversation.e$c */
    class C36278c implements C4937b {
        final /* synthetic */ C36282e zrE;

        /* renamed from: a */
        public final void mo10136a(int i, C7298n c7298n, Object obj) {
            AppMethodBeat.m2504i(34188);
            if (obj == null || !(obj instanceof String)) {
                C4990ab.m7411d("MicroMsg.ConversationAdapter", "onNotifyChange obj not String event:%d stg:%s obj:%s", Integer.valueOf(i), c7298n, obj);
                AppMethodBeat.m2505o(34188);
                return;
            }
            String str = (String) obj;
            if (this.zrE.lhi) {
                AppMethodBeat.m2505o(34188);
                return;
            }
            if (!(str == null || str.equals("") || this.zrE.yDY == null || !this.zrE.yDY.containsKey(Integer.valueOf(i)))) {
                this.zrE.yDY.remove(Integer.valueOf(i));
                this.zrE.zrr = true;
            }
            AppMethodBeat.m2505o(34188);
        }
    }

    /* renamed from: com.tencent.mm.ui.conversation.e$d */
    class C36279d {
        public int klY;
        public boolean mgQ;
        public CharSequence nickName;
        public boolean yDZ;
        public CharSequence zrH;
        public CharSequence zrI;
        public int zrJ;
        public int zrK;
        public int zrL;
        public boolean zrM;
        public boolean zrN;
        public boolean zrO;
        public boolean zrP;
        public boolean zrQ;
        public boolean zrR;
        public boolean zrS;
        public int zrT;

        private C36279d() {
        }

        /* synthetic */ C36279d(C36282e c36282e, byte b) {
            this();
        }
    }

    /* renamed from: com.tencent.mm.ui.conversation.e$e */
    class C36280e {
        C7616ad ehM;
        boolean initialized;
        String talker;
        Integer zrU;

        public C36280e() {
            this.initialized = false;
            this.talker = null;
            this.initialized = false;
            this.ehM = null;
            this.zrU = null;
        }
    }

    /* renamed from: com.tencent.mm.ui.conversation.e$f */
    public interface C36281f {
    }

    /* renamed from: com.tencent.mm.ui.conversation.e$1 */
    class C362831 implements C5015a {
        C362831() {
        }

        /* renamed from: BI */
        public final boolean mo4499BI() {
            AppMethodBeat.m2504i(34185);
            if (C36282e.this.zrB) {
                C36282e.m59714e(C36282e.this);
            }
            AppMethodBeat.m2505o(34185);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.ui.conversation.e$2 */
    class C362842 implements Runnable {
        C362842() {
        }

        public final void run() {
            AppMethodBeat.m2504i(34186);
            if (C9638aw.m17179RK()) {
                long anU = C42252ah.anU();
                C36282e.m59716g(C36282e.this);
                C4990ab.m7411d("MicroMsg.ConversationAdapter", "dkpno handleDataChange guest:%d old:%d needNotify:%b", Long.valueOf(C42252ah.m74623gb(anU) * 3), Long.valueOf(C36282e.zrA), Boolean.valueOf(C36282e.this.zrB));
                C36282e.zrA = (anU + C36282e.zrA) / 2;
                C36282e.this.zrB = false;
                C7564ap f = C36282e.this.zrC;
                long dIt = C36282e.zrA;
                f.mo16770ae(dIt, dIt);
                AppMethodBeat.m2505o(34186);
                return;
            }
            C36282e.this.zrC.stopTimer();
            C4990ab.m7412e("MicroMsg.ConversationAdapter", "dkpno handleDataChange acc has not ready");
            AppMethodBeat.m2505o(34186);
        }
    }

    /* renamed from: e */
    static /* synthetic */ void m59714e(C36282e c36282e) {
        AppMethodBeat.m2504i(34207);
        c36282e.dIs();
        AppMethodBeat.m2505o(34207);
    }

    /* renamed from: g */
    static /* synthetic */ void m59716g(C36282e c36282e) {
        AppMethodBeat.m2504i(34208);
        super.mo5248a(null, null);
        AppMethodBeat.m2505o(34208);
    }

    public C36282e(Context context, C30723a c30723a) {
        super(context, new C7617ak());
        AppMethodBeat.m2504i(34189);
        super.mo74992a(c30723a);
        this.yDX[0] = C1338a.m2870h(context, (int) C25738R.color.f12092s0);
        this.yDX[1] = C1338a.m2870h(context, (int) C25738R.color.a7y);
        this.yDX[3] = C1338a.m2870h(context, (int) C25738R.color.f12212w4);
        this.yDX[2] = C1338a.m2870h(context, (int) C25738R.color.a7v);
        this.yDX[2] = C1338a.m2870h(context, (int) C25738R.color.a7v);
        this.yDX[4] = C1338a.m2870h(context, (int) C25738R.color.f12120t3);
        this.yDY = new HashMap();
        if (C1338a.m2865ga(context)) {
            this.zry = context.getResources().getDimensionPixelSize(C25738R.dimen.f9771f7);
            this.zrx = context.getResources().getDimensionPixelSize(C25738R.dimen.f9773f9);
        } else {
            this.zry = context.getResources().getDimensionPixelSize(C25738R.dimen.f9770f6);
            this.zrx = context.getResources().getDimensionPixelSize(C25738R.dimen.f9774f_);
        }
        this.yDU = (float) C1338a.m2856al(context, C25738R.dimen.f9980m5);
        this.yDV = (float) C1338a.m2856al(context, C25738R.dimen.f9936kr);
        this.yDW = (float) C1338a.m2856al(context, C25738R.dimen.f10018nk);
        AppMethodBeat.m2505o(34189);
    }

    public final void setPerformItemClickListener(C23600g c23600g) {
        this.jJO = c23600g;
    }

    /* renamed from: a */
    public final void mo57142a(C23599f c23599f) {
        this.jJQ = c23599f;
    }

    public final void setGetViewPositionCallback(C15521c c15521c) {
        this.jJP = c15521c;
    }

    public void detach() {
    }

    /* renamed from: KD */
    public final void mo6870KD() {
        AppMethodBeat.m2504i(34191);
        mo6869KC();
        AppMethodBeat.m2505o(34191);
    }

    public final void onPause() {
        AppMethodBeat.m2504i(34192);
        if (this.jJR != null) {
            this.jJR.bIp();
        }
        this.lhi = false;
        AppMethodBeat.m2505o(34192);
    }

    private void dIq() {
        AppMethodBeat.m2504i(34193);
        if (this.yDY == null) {
            AppMethodBeat.m2505o(34193);
            return;
        }
        for (Entry value : this.yDY.entrySet()) {
            ((C36279d) value.getValue()).zrH = null;
        }
        AppMethodBeat.m2505o(34193);
    }

    public final void onResume() {
        int i = 1;
        AppMethodBeat.m2504i(34194);
        C4990ab.m7417i("MicroMsg.ConversationAdapter", "dkpno onResume mIsFront:%b  mNeedReCreate:%b mChangedBackground:%b mContactBackground:%b", Boolean.valueOf(this.lhi), Boolean.valueOf(this.zrq), Boolean.valueOf(this.zrp), Boolean.valueOf(this.zrr));
        this.lhi = true;
        Time time = new Time();
        time.setToNow();
        String charSequence = C46486g.m87705a("MM/dd", time).toString();
        if (this.zrv.equals(charSequence)) {
            i = 0;
        }
        this.zrv = charSequence;
        if (i != 0) {
            dIq();
        }
        if (this.zrq && this.zru != null) {
            this.zrq = false;
        }
        if (this.zrp || this.zrr) {
            super.mo5248a(null, null);
            this.zrp = false;
            this.zrr = false;
        }
        AppMethodBeat.m2505o(34194);
    }

    public final void onDestroy() {
        AppMethodBeat.m2504i(34195);
        this.zrC.stopTimer();
        this.zru = null;
        this.zrs = null;
        ayz();
        bIf();
        dww();
        detach();
        AppMethodBeat.m2505o(34195);
    }

    /* renamed from: KC */
    public void mo6869KC() {
        AppMethodBeat.m2504i(34196);
        C4990ab.m7417i("MicroMsg.ConversationAdapter", "dkpno resetCursor search:%b", Boolean.valueOf(this.gxV));
        if (this.gxV) {
            Cursor[] cursorArr = new Cursor[2];
            cursorArr[0] = C9638aw.m17190ZK().fkd.mo44190b(C1855t.fkP, this.elZ, this.gtX);
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            if (this.elZ != null && this.elZ.size() > 0) {
                arrayList.addAll(this.elZ);
            }
            while (cursorArr[0].moveToNext()) {
                try {
                    String string = cursorArr[0].getString(cursorArr[0].getColumnIndex("username"));
                    arrayList.add(string);
                    if (!C1855t.m3896kH(string)) {
                        arrayList2.add(string);
                    }
                    C4990ab.m7410d("MicroMsg.ConversationAdapter", "block user ".concat(String.valueOf(string)));
                } catch (Exception e) {
                    C4990ab.printErrStackTrace("MicroMsg.ConversationAdapter", e, "", new Object[0]);
                }
            }
            arrayList.add("officialaccounts");
            arrayList.add("helper_entry");
            cursorArr[1] = C9638aw.m17190ZK().fke.mo20977b(this.gtX, "@micromsg.with.all.biz.qq.com", arrayList, arrayList2);
            setCursor(new MergeCursor(cursorArr));
        } else {
            C9638aw.m17190ZK();
            setCursor(C18628c.m29083XR().mo15769a(C1855t.fkP, this.elZ, C7487a.ewS, false));
        }
        if (!(this.zrn == null || this.gtX == null)) {
            getCursor().getCount();
        }
        super.notifyDataSetChanged();
        AppMethodBeat.m2505o(34196);
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        View inflate;
        C5486g c5486g;
        int i2;
        C36279d c36279d;
        C42062sz c42062sz;
        C15868a c15868a;
        AppMethodBeat.m2504i(34197);
        C7617ak c7617ak = (C7617ak) getItem(i);
        String str = c7617ak.field_username;
        C36280e c36280e = this.zrw;
        c36280e.talker = str;
        c36280e.ehM = null;
        c36280e.zrU = null;
        c36280e.initialized = false;
        if (!C42252ah.isNullOrNil(str)) {
            c36280e.initialized = true;
        }
        this.zrz = new C15868a(this, (byte) 0);
        if (view == null) {
            C5486g c5486g2 = new C5486g();
            if (C1338a.m2865ga(this.context)) {
                inflate = View.inflate(this.context, 2130969242, null);
            } else {
                inflate = View.inflate(this.context, 2130969241, null);
            }
            c5486g2.ejo = (ImageView) inflate.findViewById(2131821183);
            if ((this.context instanceof BizConversationUI) || (this.context instanceof NewBizConversationUI)) {
                C40460b.m69437r(c5486g2.ejo, str);
            } else {
                C40460b.m69434b(c5486g2.ejo, str);
            }
            C40459a c40459a = (C40459a) c5486g2.ejo.getDrawable();
            if (this.zro != null) {
                this.zro.mo27290a(c40459a);
            }
            c5486g2.yEc = (NoMeasuredTextView) inflate.findViewById(2131823149);
            c5486g2.zrV = (NoMeasuredTextView) inflate.findViewById(2131821512);
            c5486g2.yEd = (NoMeasuredTextView) inflate.findViewById(2131823150);
            c5486g2.yEe = (NoMeasuredTextView) inflate.findViewById(2131823151);
            c5486g2.jJV = (TextView) inflate.findViewById(2131821067);
            c5486g2.jJV.setBackgroundResource(C44385r.m80243ik(this.context));
            c5486g2.yEf = (ImageView) inflate.findViewById(2131823153);
            c5486g2.yEh = inflate.findViewById(2131823148);
            c5486g2.yEg = (ImageView) inflate.findViewById(2131823154);
            c5486g2.zrW = (ImageView) inflate.findViewById(2131823155);
            inflate.setTag(c5486g2);
            c5486g2.yEe.setTextSize(0, this.yDV);
            c5486g2.yEd.setTextSize(0, this.yDW);
            c5486g2.yEc.setTextSize(0, this.yDU);
            c5486g2.zrV.setTextSize(0, this.yDV);
            c5486g2.yEe.setTextColor(this.yDX[0]);
            c5486g2.yEd.setTextColor(this.yDX[4]);
            c5486g2.yEc.setTextColor(this.yDX[3]);
            c5486g2.zrV.setTextColor(this.yDX[0]);
            c5486g2.yEe.setShouldEllipsize(true);
            c5486g2.yEd.setShouldEllipsize(false);
            c5486g2.yEc.setShouldEllipsize(true);
            c5486g2.zrV.setShouldEllipsize(true);
            c5486g2.yEd.setGravity(5);
            c5486g = c5486g2;
        } else {
            c5486g = (C5486g) view.getTag();
            inflate = view;
        }
        C36279d c36279d2 = (C36279d) this.yDY.get(str);
        if (c36279d2 == null) {
            String str2;
            C36279d c36279d3 = new C36279d(this, (byte) 0);
            c36280e = this.zrw;
            if (c36280e.initialized && c36280e.ehM == null) {
                C9638aw.m17190ZK();
                c36280e.ehM = C18628c.m29078XM().aoO(c36280e.talker);
            }
            C7616ad c7616ad = c36280e.ehM;
            if (c7616ad != null) {
                c36279d3.zrL = c7616ad.duk;
                c36279d3.zrK = (int) c7616ad.ewQ;
            } else {
                c36279d3.zrL = -1;
                c36279d3.zrK = -1;
            }
            c36279d3.zrQ = c7616ad != null;
            boolean z = c7616ad != null && c7616ad.mo16674Kc();
            c36279d3.zrS = z;
            z = c7616ad != null && c7616ad.dua == 0;
            c36279d3.zrR = z;
            c36279d3.mgQ = C1855t.m3896kH(str);
            z = c36279d3.mgQ && c36279d3.zrR && c7617ak.field_unReadCount > 0;
            c36279d3.zrP = z;
            c36279d3.klY = 0;
            int FB = C36282e.m59708FB(c7617ak.field_msgType);
            if (FB == 34 && c7617ak.field_isSend == 0 && !C42252ah.isNullOrNil(c7617ak.field_content)) {
                str2 = c7617ak.field_content;
                if (str.equals("qmessage") || str.equals("floatbottle")) {
                    String[] split = str2.split(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D);
                    if (split != null && split.length > 3) {
                        str2 = split[1] + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + split[2] + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + split[3];
                    }
                }
                if (!new C42230n(str2).fWX) {
                    c36279d3.klY = 1;
                }
            }
            if (FB == 285212721 && c7617ak.field_unReadCount > 0) {
                str2 = c7617ak.field_content;
                Long valueOf = Long.valueOf(c7617ak.field_lastSeq);
                if (!this.zrD.contains(valueOf)) {
                    this.zrD.add(valueOf);
                    C7305d.xDG.mo10151b(new Runnable() {
                        public final void run() {
                            AppMethodBeat.m2504i(34187);
                            C32223o b = ((C27500a) C1720g.m3528K(C27500a.class)).mo35246b(0, str2);
                            if (b == null || b.fjr.size() == 0) {
                                AppMethodBeat.m2505o(34187);
                                return;
                            }
                            C32224p c32224p = (C32224p) b.fjr.getFirst();
                            ((C20023b) C1720g.m3528K(C20023b.class)).mo6749a(c32224p.url, c32224p.type, 92, new Object[0]);
                            C4990ab.m7419v("MicroMsg.ConversationAdapter", "terry trace preload:%s", c32224p.title);
                            AppMethodBeat.m2505o(34187);
                        }
                    }, "tmplPreload");
                }
            }
            str2 = C1854s.m3861a(c7616ad, str, c36279d3.mgQ);
            if (c36279d3.mgQ && str2 == null) {
                c36279d3.nickName = this.context.getString(C25738R.string.ao1);
            } else {
                c36279d3.nickName = C44089j.m79293b(this.context, C1854s.m3861a(c7616ad, str, c36279d3.mgQ), c5486g.yEc.getTextSize());
            }
            c36279d3.zrH = m59717h(c7617ak);
            c36279d3.zrI = m59709a(c7617ak, (int) c5486g.yEe.getTextSize(), c36279d3.zrP);
            c36279d3.zrT = c7617ak.field_attrflag;
            switch (c7617ak.field_status) {
                case 0:
                    i2 = -1;
                    break;
                case 1:
                    i2 = C1318a.msg_state_sending;
                    break;
                case 2:
                    i2 = -1;
                    break;
                case 5:
                    i2 = C1318a.msg_state_failed;
                    break;
                default:
                    i2 = -1;
                    break;
            }
            c36279d3.zrJ = i2;
            c36279d3.zrM = C1855t.m3881a(c7617ak);
            C9638aw.m17190ZK();
            c36279d3.yDZ = C18628c.m29083XR().mo15822g(c7617ak);
            z = c7616ad != null && c7616ad.mo16673DX();
            c36279d3.zrN = z;
            c36279d3.zrO = C4988aa.don();
            this.yDY.put(str, c36279d3);
            c36279d = c36279d3;
        } else {
            c36279d = c36279d2;
        }
        if (c36279d.zrH == null) {
            c36279d.zrH = m59717h(c7617ak);
        }
        if (c36279d.zrP || C1855t.m3956ny(c7617ak.field_parentRef)) {
            c5486g.yEe.setTextColor(this.yDX[0]);
        } else {
            c5486g.yEe.setTextColor(this.yDX[c36279d.klY]);
        }
        C37622h.m63534iv(c5486g.yEe.getWidth());
        C37622h.m63535iw((int) c5486g.yEe.getTextSize());
        C37622h.m63525a(c5486g.yEe.getPaint());
        if (str.toLowerCase().endsWith("@t.qq.com")) {
            c5486g.yEc.setCompoundRightDrawablesWithIntrinsicBounds((int) C25738R.drawable.icon_tencent_weibo);
            c5486g.yEc.setDrawRightDrawable(true);
        } else {
            c5486g.yEc.setDrawRightDrawable(false);
        }
        i2 = c36279d.zrJ;
        if (i2 != -1) {
            c5486g.yEe.setCompoundLeftDrawablesWithIntrinsicBounds(i2);
            c5486g.yEe.setDrawLeftDrawable(true);
        } else {
            c5486g.yEe.setDrawLeftDrawable(false);
        }
        c5486g.zrV.setVisibility(8);
        LayoutParams layoutParams = c5486g.yEd.getLayoutParams();
        if (c36279d.zrH.length() > 9) {
            if (layoutParams.width != this.zry) {
                layoutParams.width = this.zry;
                c5486g.yEd.setLayoutParams(layoutParams);
            }
        } else if (layoutParams.width != this.zrx) {
            layoutParams.width = this.zrx;
            c5486g.yEd.setLayoutParams(layoutParams);
        }
        C4990ab.m7419v("MicroMsg.ConversationAdapter", "layout update time width %d", Integer.valueOf(layoutParams.width));
        c5486g.yEd.setText(c36279d.zrH);
        c5486g.yEe.setText(c36279d.zrI);
        if (c36279d.mgQ && c36279d.zrR) {
            c5486g.yEf.setVisibility(0);
        } else if (c36279d.zrN) {
            c5486g.yEf.setVisibility(0);
        } else {
            c5486g.yEf.setVisibility(8);
        }
        if ((this.context instanceof BizConversationUI) || (this.context instanceof NewBizConversationUI)) {
            C40460b.m69437r(c5486g.ejo, str);
        } else {
            C40460b.m69434b(c5486g.ejo, str);
        }
        if (this.zrm) {
            if (c7617ak == null || c5486g == null || c36279d == null) {
                C4990ab.m7420w("MicroMsg.ConversationAdapter", "handle show tip cnt, but conversation or viewholder is null");
            } else {
                c5486g.jJV.setVisibility(4);
                c5486g.yEh.setVisibility(4);
                if (C1855t.m3956ny(c7617ak.field_username)) {
                    c5486g.yEh.setVisibility(c7617ak.field_unReadCount > 0 ? 0 : 4);
                    c5486g.yEc.setTextColor(this.yDX[3]);
                } else {
                    ColorStateList colorStateList;
                    NoMeasuredTextView noMeasuredTextView = c5486g.yEc;
                    if (c36279d.zrQ && c36279d.zrL == 1) {
                        colorStateList = this.yDX[2];
                    } else {
                        colorStateList = this.yDX[3];
                    }
                    noMeasuredTextView.setTextColor(colorStateList);
                    if (!c36279d.zrQ || c36279d.zrK == 0) {
                        C4990ab.m7420w("MicroMsg.ConversationAdapter", "handle show tip count, but talker is null");
                    } else if (C1855t.m3956ny(c7617ak.field_parentRef)) {
                        if (!(this.context instanceof NewBizConversationUI)) {
                            c5486g.yEh.setVisibility(c7617ak.field_unReadCount > 0 ? 0 : 4);
                        }
                    } else if (c36279d.zrN && c36279d.zrS) {
                        c5486g.yEh.setVisibility(c7617ak.field_unReadCount > 0 ? 0 : 4);
                    } else if (c36279d.mgQ && c36279d.zrR) {
                        c5486g.yEh.setVisibility(c7617ak.field_unReadCount > 0 ? 0 : 4);
                    } else {
                        i2 = c7617ak.field_unReadCount;
                        if (i2 > 99) {
                            c5486g.jJV.setText("");
                            c5486g.jJV.setBackgroundResource(C1318a.badge_count_more);
                            c5486g.jJV.setVisibility(0);
                        } else if (i2 > 0) {
                            c5486g.jJV.setText(c7617ak.field_unReadCount);
                            c5486g.jJV.setBackgroundResource(C44385r.m80243ik(this.context));
                            c5486g.jJV.setVisibility(0);
                        }
                        this.zrz.zrF = i2;
                    }
                }
            }
        }
        if (!c36279d.zrM && c36279d.yDZ && C9638aw.m17179RK()) {
            C9638aw.m17190ZK();
            C18628c.m29083XR().mo15821f(c7617ak);
        }
        if ((this.context instanceof NewBizConversationUI) && c36279d.yDZ && c7617ak.field_conversationTime != -1) {
            Drawable drawable = this.context.getResources().getDrawable(C25738R.drawable.axl);
            int textSize = (int) c5486g.yEc.getTextSize();
            drawable.setBounds(0, 0, textSize, textSize);
            new SpannableString("@").setSpan(new C5664a(drawable), 0, 1, 33);
            c5486g.yEc.setText(TextUtils.concat(new CharSequence[]{c36279d.nickName, " ", r0}));
        } else {
            c5486g.yEc.setText(c36279d.nickName);
            if (c36279d.yDZ && c7617ak.field_conversationTime != -1) {
                inflate.findViewById(2131823147).setBackgroundResource(C25738R.drawable.f6622k4);
                C25985d.dlL();
                c42062sz = new C42062sz();
                c42062sz.cPf.cPh = true;
                C4879a.xxA.mo10055m(c42062sz);
                if (!(0 == C43298a.m77176a(c7617ak, 7, 0) || c7617ak.field_username.equals(c42062sz.cPg.cPj))) {
                    c7617ak.mo14743eE(C43298a.m77176a(c7617ak, 6, c7617ak.field_conversationTime));
                    C9638aw.m17190ZK();
                    C18628c.m29083XR().mo15767a(c7617ak, c7617ak.field_username);
                }
                if (C32337g.fUs == null && C32337g.fUs.mo4625tN(c7617ak.field_username)) {
                    c5486g.yEg.setVisibility(0);
                    if (c7617ak.field_username.equals(c42062sz.cPg.cPj)) {
                        c5486g.yEg.setImageResource(C1318a.talk_room_mic_speaking);
                    } else {
                        c5486g.yEg.setImageResource(C1318a.talk_room_mic_idle);
                    }
                } else {
                    c5486g.yEg.setVisibility(8);
                }
                if (C25859d.fUu == null && C25859d.fUu.mo20565tQ(c7617ak.field_username)) {
                    c5486g.zrW.setVisibility(0);
                } else {
                    c5486g.zrW.setVisibility(8);
                }
                this.zrz.content = String.valueOf(c36279d.zrI);
                this.zrz.bCu = String.valueOf(c36279d.nickName);
                this.zrz.zrG = String.valueOf(c36279d.zrH);
                c15868a = this.zrz;
                C5215a.yqY.mo10714a(inflate, c15868a.bCu, c15868a.zrF, c15868a.zrG, c15868a.content);
                mo31098a(str, c5486g);
                mo17781a(c7617ak, c36279d.yDZ, i, false);
                AppMethodBeat.m2505o(34197);
                return inflate;
            }
        }
        inflate.findViewById(2131823147).setBackgroundResource(C25738R.drawable.f6623k5);
        C25985d.dlL();
        c42062sz = new C42062sz();
        c42062sz.cPf.cPh = true;
        C4879a.xxA.mo10055m(c42062sz);
        c7617ak.mo14743eE(C43298a.m77176a(c7617ak, 6, c7617ak.field_conversationTime));
        C9638aw.m17190ZK();
        C18628c.m29083XR().mo15767a(c7617ak, c7617ak.field_username);
        if (C32337g.fUs == null) {
        }
        c5486g.yEg.setVisibility(8);
        if (C25859d.fUu == null) {
        }
        c5486g.zrW.setVisibility(8);
        this.zrz.content = String.valueOf(c36279d.zrI);
        this.zrz.bCu = String.valueOf(c36279d.nickName);
        this.zrz.zrG = String.valueOf(c36279d.zrH);
        c15868a = this.zrz;
        C5215a.yqY.mo10714a(inflate, c15868a.bCu, c15868a.zrF, c15868a.zrG, c15868a.content);
        mo31098a(str, c5486g);
        mo17781a(c7617ak, c36279d.yDZ, i, false);
        AppMethodBeat.m2505o(34197);
        return inflate;
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: a */
    public void mo31098a(String str, C5486g c5486g) {
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: a */
    public void mo17781a(C7617ak c7617ak, boolean z, int i, boolean z2) {
    }

    /* renamed from: FB */
    private static int m59708FB(String str) {
        int i = 1;
        AppMethodBeat.m2504i(34198);
        if (str != null && str.length() > 0) {
            try {
                i = Integer.valueOf(str).intValue();
            } catch (NumberFormatException e) {
            }
        }
        AppMethodBeat.m2505o(34198);
        return i;
    }

    private void ayz() {
        AppMethodBeat.m2504i(34199);
        if (this.yDY != null) {
            this.yDY.clear();
            this.yDY = null;
        }
        AppMethodBeat.m2505o(34199);
    }

    private static String aqV(String str) {
        AppMethodBeat.m2504i(34201);
        if (str == null || str.length() != 32) {
            AppMethodBeat.m2505o(34201);
            return null;
        }
        String Jh = ((C6835d) C1720g.m3530M(C6835d.class)).getEmojiMgr().mo35600Jh(str);
        AppMethodBeat.m2505o(34201);
        return Jh;
    }

    /* renamed from: a */
    public final void mo10136a(int i, C7298n c7298n, Object obj) {
        AppMethodBeat.m2504i(34202);
        if (obj == null || !(obj instanceof String)) {
            C4990ab.m7413e("MicroMsg.ConversationAdapter", "onNotifyChange obj not String event:%d stg:%s obj:%s", Integer.valueOf(i), c7298n, obj);
            AppMethodBeat.m2505o(34202);
            return;
        }
        mo5248a((String) obj, null);
        AppMethodBeat.m2505o(34202);
    }

    /* renamed from: a */
    public final void mo5248a(String str, C4935m c4935m) {
        AppMethodBeat.m2504i(34203);
        C4990ab.m7417i("MicroMsg.ConversationAdapter", "dkpno onNotifyChange mIsFront:%b mChangedBackground:%b event:%s", Boolean.valueOf(this.lhi), Boolean.valueOf(this.zrp), str);
        if (!(C42252ah.isNullOrNil(str) || this.yDY == null)) {
            this.yDY.remove(str);
        }
        if (this.lhi) {
            dIr();
            AppMethodBeat.m2505o(34203);
            return;
        }
        this.zrp = true;
        AppMethodBeat.m2505o(34203);
    }

    private void dIr() {
        AppMethodBeat.m2504i(34204);
        C4990ab.m7411d("MicroMsg.ConversationAdapter", "dkpno postTryNotify needNotify:%b timerStopped:%b", Boolean.valueOf(this.zrB), Boolean.valueOf(this.zrC.doT()));
        this.zrB = true;
        if (this.zrC.doT()) {
            dIs();
        }
        AppMethodBeat.m2505o(34204);
    }

    private void dIs() {
        AppMethodBeat.m2504i(34205);
        C5004al.m7441d(new C362842());
        AppMethodBeat.m2505o(34205);
    }

    /* renamed from: h */
    private CharSequence m59717h(C7617ak c7617ak) {
        AppMethodBeat.m2504i(34190);
        CharSequence charSequence;
        if (c7617ak.field_status == 1) {
            String string = this.context.getString(C25738R.string.cw8);
            AppMethodBeat.m2505o(34190);
            return string;
        } else if (c7617ak.field_conversationTime == Long.MAX_VALUE) {
            charSequence = "";
            AppMethodBeat.m2505o(34190);
            return charSequence;
        } else {
            charSequence = C14835h.m23089c(this.context, c7617ak.field_conversationTime, true);
            AppMethodBeat.m2505o(34190);
            return charSequence;
        }
    }

    /* renamed from: a */
    private CharSequence m59709a(C7617ak c7617ak, int i, boolean z) {
        AppMethodBeat.m2504i(34200);
        if (C42252ah.isNullOrNil(c7617ak.field_editingMsg) || (c7617ak.field_atCount > 0 && c7617ak.field_unReadCount > 0)) {
            CharSequence charSequence = c7617ak.field_digest;
            CharSequence string;
            if (charSequence == null || !charSequence.startsWith("<img src=\"original_label.png\"/>  ")) {
                int i2;
                String str;
                String str2 = c7617ak.field_username;
                if (str2.equals("qqmail")) {
                    C9638aw.m17190ZK();
                    if (C42252ah.m74624h((Integer) C18628c.m29072Ry().get(17, null)) == 1) {
                        i2 = 1;
                    } else {
                        i2 = 0;
                    }
                    if (i2 == 0) {
                        string = this.context.getString(C25738R.string.e_7);
                        AppMethodBeat.m2505o(34200);
                        return string;
                    }
                }
                if (str2.equals("tmessage")) {
                    C9638aw.m17190ZK();
                    C5140bq RA = C18628c.m29086XU().mo15356RA("@t.qq.com");
                    if (RA == null || !RA.isEnable()) {
                        i2 = 0;
                    } else {
                        i2 = 1;
                    }
                    if (i2 == 0) {
                        string = this.context.getString(C25738R.string.e_7);
                        AppMethodBeat.m2505o(34200);
                        return string;
                    }
                }
                if (c7617ak.field_msgType != null && (c7617ak.field_msgType.equals("47") || c7617ak.field_msgType.equals("1048625"))) {
                    str2 = C36282e.aqV(c7617ak.field_digest);
                    str = "";
                    if (str2 != null) {
                        string = "[" + str2 + "]";
                        AppMethodBeat.m2505o(34200);
                        return string;
                    }
                    if (c7617ak.field_digest != null && c7617ak.field_digest.contains(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D)) {
                        str = c7617ak.field_digest.substring(0, c7617ak.field_digest.indexOf(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D));
                        str2 = C36282e.aqV(c7617ak.field_digest.substring(c7617ak.field_digest.indexOf(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D) + 1).replace(" ", ""));
                        if (str2 != null) {
                            str2 = "[" + str2 + "]";
                            if (C42252ah.isNullOrNil(str)) {
                                AppMethodBeat.m2505o(34200);
                                return str2;
                            }
                            string = str + ": " + str2;
                            AppMethodBeat.m2505o(34200);
                            return string;
                        }
                    }
                    str2 = this.context.getString(C25738R.string.f9100ph);
                    if (C42252ah.isNullOrNil(str)) {
                        str = str2;
                    } else {
                        str = str + ": " + str2;
                    }
                    c7617ak.mo14758jh(str);
                }
                if (!C42252ah.isNullOrNil(c7617ak.field_digest)) {
                    if (C42252ah.isNullOrNil(c7617ak.field_digestUser)) {
                        str = c7617ak.field_digest;
                    } else {
                        if (c7617ak.field_isSend == 0 && C1855t.m3896kH(c7617ak.field_username)) {
                            str = C1854s.getDisplayName(c7617ak.field_digestUser, c7617ak.field_username);
                        } else {
                            str = C1854s.m3866mJ(c7617ak.field_digestUser);
                        }
                        try {
                            str = String.format(c7617ak.field_digest, new Object[]{str});
                        } catch (Exception e) {
                        }
                    }
                    string = str.replace(10, ' ');
                    if (c7617ak.field_atCount > 0 || c7617ak.field_unReadCount <= 0) {
                        if (!z && c7617ak.field_unReadCount > 1) {
                            string = this.context.getString(C25738R.string.cvg, new Object[]{Integer.valueOf(c7617ak.field_unReadCount), string});
                        } else if (c7617ak.field_unReadCount > 0 && C1855t.m3956ny(c7617ak.field_parentRef) && !(this.context instanceof NewBizConversationUI)) {
                            string = this.context.getString(C25738R.string.cvg, new Object[]{Integer.valueOf(c7617ak.field_unReadCount), string});
                        }
                        string = C44089j.m79294b(this.context, string, i);
                        AppMethodBeat.m2505o(34200);
                        return string;
                    }
                    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.context.getString(C25738R.string.cvd));
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(-5569532), 0, spannableStringBuilder.length(), 33);
                    spannableStringBuilder.append(" ").append(C44089j.m79294b(this.context, string, i));
                    AppMethodBeat.m2505o(34200);
                    return spannableStringBuilder;
                }
                str = C37622h.m63519a(c7617ak.field_isSend, c7617ak.field_username, c7617ak.field_content, C36282e.m59708FB(c7617ak.field_msgType), this.context);
                string = str.replace(10, ' ');
                if (c7617ak.field_atCount > 0) {
                }
                if (!z) {
                }
                string = this.context.getString(C25738R.string.cvg, new Object[]{Integer.valueOf(c7617ak.field_unReadCount), string});
                string = C44089j.m79294b(this.context, string, i);
                AppMethodBeat.m2505o(34200);
                return string;
            }
            string = new SpannableString(C44089j.m79303e(this.context, charSequence, (float) i));
            AppMethodBeat.m2505o(34200);
            return string;
        }
        SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(this.context.getString(C25738R.string.cvh));
        spannableStringBuilder2.setSpan(new ForegroundColorSpan(-5569532), 0, spannableStringBuilder2.length(), 33);
        spannableStringBuilder2.append(" ").append(C44089j.m79294b(this.context, c7617ak.field_editingMsg, i));
        AppMethodBeat.m2505o(34200);
        return spannableStringBuilder2;
    }
}
