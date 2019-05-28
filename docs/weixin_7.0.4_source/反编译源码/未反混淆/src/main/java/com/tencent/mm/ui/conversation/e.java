package com.tencent.mm.ui.conversation;

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
import com.tencent.mm.R;
import com.tencent.mm.af.o;
import com.tencent.mm.booter.notification.a.h;
import com.tencent.mm.g.a.sz;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.s;
import com.tencent.mm.model.t;
import com.tencent.mm.platformtools.ah;
import com.tencent.mm.pluginsdk.ui.e.j;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.e.n;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.ak;
import com.tencent.mm.storage.bq;
import com.tencent.mm.ui.base.MMSlideDelView;
import com.tencent.mm.ui.base.NoMeasuredTextView;
import com.tencent.mm.ui.p;
import com.tencent.mm.ui.tools.r;
import com.tencent.ttpic.thread.FaceGestureDetGLThread;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map.Entry;

public class e extends p<ak> implements com.tencent.mm.sdk.e.n.b {
    private static long zrA = FaceGestureDetGLThread.BRIGHTNESS_DURATION;
    protected List<String> elZ = null;
    private String gtX;
    private boolean gxV = false;
    protected com.tencent.mm.ui.base.MMSlideDelView.g jJO;
    protected com.tencent.mm.ui.base.MMSlideDelView.c jJP;
    protected com.tencent.mm.ui.base.MMSlideDelView.f jJQ;
    protected com.tencent.mm.ui.base.MMSlideDelView.d jJR = MMSlideDelView.getItemStatusCallBack();
    private boolean lhi = false;
    boolean riR = false;
    private float yDU = -1.0f;
    protected float yDV = -1.0f;
    private float yDW = -1.0f;
    private ColorStateList[] yDX = new ColorStateList[5];
    HashMap<String, d> yDY;
    private boolean zrB = false;
    private ap zrC = new ap(aw.RS().oAl.getLooper(), new com.tencent.mm.sdk.platformtools.ap.a() {
        public final boolean BI() {
            AppMethodBeat.i(34185);
            if (e.this.zrB) {
                e.e(e.this);
            }
            AppMethodBeat.o(34185);
            return false;
        }
    }, false);
    HashSet<Long> zrD = new HashSet();
    private boolean zrm = true;
    private f zrn;
    private com.tencent.mm.pluginsdk.ui.d zro;
    private boolean zrp = false;
    private boolean zrq = false;
    private boolean zrr = false;
    private c zrs;
    private com.tencent.mm.sdk.b.c zrt = null;
    private b zru = null;
    public String zrv = "";
    final e zrw = new e();
    private final int zrx;
    private final int zry;
    private a zrz;

    public static class g {
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

    class a {
        public String bCu;
        public String content;
        public int zrF;
        public String zrG;

        private a() {
        }

        /* synthetic */ a(e eVar, byte b) {
            this();
        }
    }

    public interface b {
    }

    class c implements com.tencent.mm.sdk.e.n.b {
        final /* synthetic */ e zrE;

        public final void a(int i, n nVar, Object obj) {
            AppMethodBeat.i(34188);
            if (obj == null || !(obj instanceof String)) {
                ab.d("MicroMsg.ConversationAdapter", "onNotifyChange obj not String event:%d stg:%s obj:%s", Integer.valueOf(i), nVar, obj);
                AppMethodBeat.o(34188);
                return;
            }
            String str = (String) obj;
            if (this.zrE.lhi) {
                AppMethodBeat.o(34188);
                return;
            }
            if (!(str == null || str.equals("") || this.zrE.yDY == null || !this.zrE.yDY.containsKey(Integer.valueOf(i)))) {
                this.zrE.yDY.remove(Integer.valueOf(i));
                this.zrE.zrr = true;
            }
            AppMethodBeat.o(34188);
        }
    }

    class d {
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

        private d() {
        }

        /* synthetic */ d(e eVar, byte b) {
            this();
        }
    }

    class e {
        ad ehM;
        boolean initialized;
        String talker;
        Integer zrU;

        public e() {
            this.initialized = false;
            this.talker = null;
            this.initialized = false;
            this.ehM = null;
            this.zrU = null;
        }
    }

    public interface f {
    }

    static /* synthetic */ void e(e eVar) {
        AppMethodBeat.i(34207);
        eVar.dIs();
        AppMethodBeat.o(34207);
    }

    static /* synthetic */ void g(e eVar) {
        AppMethodBeat.i(34208);
        super.a(null, null);
        AppMethodBeat.o(34208);
    }

    public e(Context context, com.tencent.mm.ui.p.a aVar) {
        super(context, new ak());
        AppMethodBeat.i(34189);
        super.a(aVar);
        this.yDX[0] = com.tencent.mm.bz.a.h(context, (int) R.color.s0);
        this.yDX[1] = com.tencent.mm.bz.a.h(context, (int) R.color.a7y);
        this.yDX[3] = com.tencent.mm.bz.a.h(context, (int) R.color.w4);
        this.yDX[2] = com.tencent.mm.bz.a.h(context, (int) R.color.a7v);
        this.yDX[2] = com.tencent.mm.bz.a.h(context, (int) R.color.a7v);
        this.yDX[4] = com.tencent.mm.bz.a.h(context, (int) R.color.t3);
        this.yDY = new HashMap();
        if (com.tencent.mm.bz.a.ga(context)) {
            this.zry = context.getResources().getDimensionPixelSize(R.dimen.f7);
            this.zrx = context.getResources().getDimensionPixelSize(R.dimen.f9);
        } else {
            this.zry = context.getResources().getDimensionPixelSize(R.dimen.f6);
            this.zrx = context.getResources().getDimensionPixelSize(R.dimen.f_);
        }
        this.yDU = (float) com.tencent.mm.bz.a.al(context, R.dimen.m5);
        this.yDV = (float) com.tencent.mm.bz.a.al(context, R.dimen.kr);
        this.yDW = (float) com.tencent.mm.bz.a.al(context, R.dimen.nk);
        AppMethodBeat.o(34189);
    }

    public final void setPerformItemClickListener(com.tencent.mm.ui.base.MMSlideDelView.g gVar) {
        this.jJO = gVar;
    }

    public final void a(com.tencent.mm.ui.base.MMSlideDelView.f fVar) {
        this.jJQ = fVar;
    }

    public final void setGetViewPositionCallback(com.tencent.mm.ui.base.MMSlideDelView.c cVar) {
        this.jJP = cVar;
    }

    public void detach() {
    }

    public final void KD() {
        AppMethodBeat.i(34191);
        KC();
        AppMethodBeat.o(34191);
    }

    public final void onPause() {
        AppMethodBeat.i(34192);
        if (this.jJR != null) {
            this.jJR.bIp();
        }
        this.lhi = false;
        AppMethodBeat.o(34192);
    }

    private void dIq() {
        AppMethodBeat.i(34193);
        if (this.yDY == null) {
            AppMethodBeat.o(34193);
            return;
        }
        for (Entry value : this.yDY.entrySet()) {
            ((d) value.getValue()).zrH = null;
        }
        AppMethodBeat.o(34193);
    }

    public final void onResume() {
        int i = 1;
        AppMethodBeat.i(34194);
        ab.i("MicroMsg.ConversationAdapter", "dkpno onResume mIsFront:%b  mNeedReCreate:%b mChangedBackground:%b mContactBackground:%b", Boolean.valueOf(this.lhi), Boolean.valueOf(this.zrq), Boolean.valueOf(this.zrp), Boolean.valueOf(this.zrr));
        this.lhi = true;
        Time time = new Time();
        time.setToNow();
        String charSequence = com.tencent.mm.pluginsdk.f.g.a("MM/dd", time).toString();
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
            super.a(null, null);
            this.zrp = false;
            this.zrr = false;
        }
        AppMethodBeat.o(34194);
    }

    public final void onDestroy() {
        AppMethodBeat.i(34195);
        this.zrC.stopTimer();
        this.zru = null;
        this.zrs = null;
        ayz();
        bIf();
        dww();
        detach();
        AppMethodBeat.o(34195);
    }

    public void KC() {
        AppMethodBeat.i(34196);
        ab.i("MicroMsg.ConversationAdapter", "dkpno resetCursor search:%b", Boolean.valueOf(this.gxV));
        if (this.gxV) {
            Cursor[] cursorArr = new Cursor[2];
            cursorArr[0] = aw.ZK().fkd.b(t.fkP, this.elZ, this.gtX);
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            if (this.elZ != null && this.elZ.size() > 0) {
                arrayList.addAll(this.elZ);
            }
            while (cursorArr[0].moveToNext()) {
                try {
                    String string = cursorArr[0].getString(cursorArr[0].getColumnIndex("username"));
                    arrayList.add(string);
                    if (!t.kH(string)) {
                        arrayList2.add(string);
                    }
                    ab.d("MicroMsg.ConversationAdapter", "block user ".concat(String.valueOf(string)));
                } catch (Exception e) {
                    ab.printErrStackTrace("MicroMsg.ConversationAdapter", e, "", new Object[0]);
                }
            }
            arrayList.add("officialaccounts");
            arrayList.add("helper_entry");
            cursorArr[1] = aw.ZK().fke.b(this.gtX, "@micromsg.with.all.biz.qq.com", arrayList, arrayList2);
            setCursor(new MergeCursor(cursorArr));
        } else {
            aw.ZK();
            setCursor(com.tencent.mm.model.c.XR().a(t.fkP, this.elZ, com.tencent.mm.o.a.ewS, false));
        }
        if (!(this.zrn == null || this.gtX == null)) {
            getCursor().getCount();
        }
        super.notifyDataSetChanged();
        AppMethodBeat.o(34196);
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        View inflate;
        g gVar;
        int i2;
        d dVar;
        sz szVar;
        a aVar;
        AppMethodBeat.i(34197);
        ak akVar = (ak) getItem(i);
        String str = akVar.field_username;
        e eVar = this.zrw;
        eVar.talker = str;
        eVar.ehM = null;
        eVar.zrU = null;
        eVar.initialized = false;
        if (!ah.isNullOrNil(str)) {
            eVar.initialized = true;
        }
        this.zrz = new a(this, (byte) 0);
        if (view == null) {
            g gVar2 = new g();
            if (com.tencent.mm.bz.a.ga(this.context)) {
                inflate = View.inflate(this.context, R.layout.r9, null);
            } else {
                inflate = View.inflate(this.context, R.layout.r8, null);
            }
            gVar2.ejo = (ImageView) inflate.findViewById(R.id.qk);
            if ((this.context instanceof BizConversationUI) || (this.context instanceof NewBizConversationUI)) {
                com.tencent.mm.pluginsdk.ui.a.b.r(gVar2.ejo, str);
            } else {
                com.tencent.mm.pluginsdk.ui.a.b.b(gVar2.ejo, str);
            }
            com.tencent.mm.pluginsdk.ui.a aVar2 = (com.tencent.mm.pluginsdk.ui.a) gVar2.ejo.getDrawable();
            if (this.zro != null) {
                this.zro.a(aVar2);
            }
            gVar2.yEc = (NoMeasuredTextView) inflate.findViewById(R.id.b6e);
            gVar2.zrV = (NoMeasuredTextView) inflate.findViewById(R.id.z5);
            gVar2.yEd = (NoMeasuredTextView) inflate.findViewById(R.id.b6f);
            gVar2.yEe = (NoMeasuredTextView) inflate.findViewById(R.id.b6g);
            gVar2.jJV = (TextView) inflate.findViewById(R.id.nf);
            gVar2.jJV.setBackgroundResource(r.ik(this.context));
            gVar2.yEf = (ImageView) inflate.findViewById(R.id.b6i);
            gVar2.yEh = inflate.findViewById(R.id.b6d);
            gVar2.yEg = (ImageView) inflate.findViewById(R.id.b6j);
            gVar2.zrW = (ImageView) inflate.findViewById(R.id.b6k);
            inflate.setTag(gVar2);
            gVar2.yEe.setTextSize(0, this.yDV);
            gVar2.yEd.setTextSize(0, this.yDW);
            gVar2.yEc.setTextSize(0, this.yDU);
            gVar2.zrV.setTextSize(0, this.yDV);
            gVar2.yEe.setTextColor(this.yDX[0]);
            gVar2.yEd.setTextColor(this.yDX[4]);
            gVar2.yEc.setTextColor(this.yDX[3]);
            gVar2.zrV.setTextColor(this.yDX[0]);
            gVar2.yEe.setShouldEllipsize(true);
            gVar2.yEd.setShouldEllipsize(false);
            gVar2.yEc.setShouldEllipsize(true);
            gVar2.zrV.setShouldEllipsize(true);
            gVar2.yEd.setGravity(5);
            gVar = gVar2;
        } else {
            gVar = (g) view.getTag();
            inflate = view;
        }
        d dVar2 = (d) this.yDY.get(str);
        if (dVar2 == null) {
            String str2;
            d dVar3 = new d(this, (byte) 0);
            eVar = this.zrw;
            if (eVar.initialized && eVar.ehM == null) {
                aw.ZK();
                eVar.ehM = com.tencent.mm.model.c.XM().aoO(eVar.talker);
            }
            ad adVar = eVar.ehM;
            if (adVar != null) {
                dVar3.zrL = adVar.duk;
                dVar3.zrK = (int) adVar.ewQ;
            } else {
                dVar3.zrL = -1;
                dVar3.zrK = -1;
            }
            dVar3.zrQ = adVar != null;
            boolean z = adVar != null && adVar.Kc();
            dVar3.zrS = z;
            z = adVar != null && adVar.dua == 0;
            dVar3.zrR = z;
            dVar3.mgQ = t.kH(str);
            z = dVar3.mgQ && dVar3.zrR && akVar.field_unReadCount > 0;
            dVar3.zrP = z;
            dVar3.klY = 0;
            int FB = FB(akVar.field_msgType);
            if (FB == 34 && akVar.field_isSend == 0 && !ah.isNullOrNil(akVar.field_content)) {
                str2 = akVar.field_content;
                if (str.equals("qmessage") || str.equals("floatbottle")) {
                    String[] split = str2.split(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D);
                    if (split != null && split.length > 3) {
                        str2 = split[1] + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + split[2] + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + split[3];
                    }
                }
                if (!new com.tencent.mm.modelvoice.n(str2).fWX) {
                    dVar3.klY = 1;
                }
            }
            if (FB == 285212721 && akVar.field_unReadCount > 0) {
                str2 = akVar.field_content;
                Long valueOf = Long.valueOf(akVar.field_lastSeq);
                if (!this.zrD.contains(valueOf)) {
                    this.zrD.add(valueOf);
                    com.tencent.mm.sdk.g.d.xDG.b(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(34187);
                            o b = ((com.tencent.mm.plugin.biz.a.a) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.biz.a.a.class)).b(0, str2);
                            if (b == null || b.fjr.size() == 0) {
                                AppMethodBeat.o(34187);
                                return;
                            }
                            com.tencent.mm.af.p pVar = (com.tencent.mm.af.p) b.fjr.getFirst();
                            ((com.tencent.mm.plugin.brandservice.a.b) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.brandservice.a.b.class)).a(pVar.url, pVar.type, 92, new Object[0]);
                            ab.v("MicroMsg.ConversationAdapter", "terry trace preload:%s", pVar.title);
                            AppMethodBeat.o(34187);
                        }
                    }, "tmplPreload");
                }
            }
            str2 = s.a(adVar, str, dVar3.mgQ);
            if (dVar3.mgQ && str2 == null) {
                dVar3.nickName = this.context.getString(R.string.ao1);
            } else {
                dVar3.nickName = j.b(this.context, s.a(adVar, str, dVar3.mgQ), gVar.yEc.getTextSize());
            }
            dVar3.zrH = h(akVar);
            dVar3.zrI = a(akVar, (int) gVar.yEe.getTextSize(), dVar3.zrP);
            dVar3.zrT = akVar.field_attrflag;
            switch (akVar.field_status) {
                case 0:
                    i2 = -1;
                    break;
                case 1:
                    i2 = R.raw.msg_state_sending;
                    break;
                case 2:
                    i2 = -1;
                    break;
                case 5:
                    i2 = R.raw.msg_state_failed;
                    break;
                default:
                    i2 = -1;
                    break;
            }
            dVar3.zrJ = i2;
            dVar3.zrM = t.a(akVar);
            aw.ZK();
            dVar3.yDZ = com.tencent.mm.model.c.XR().g(akVar);
            z = adVar != null && adVar.DX();
            dVar3.zrN = z;
            dVar3.zrO = aa.don();
            this.yDY.put(str, dVar3);
            dVar = dVar3;
        } else {
            dVar = dVar2;
        }
        if (dVar.zrH == null) {
            dVar.zrH = h(akVar);
        }
        if (dVar.zrP || t.ny(akVar.field_parentRef)) {
            gVar.yEe.setTextColor(this.yDX[0]);
        } else {
            gVar.yEe.setTextColor(this.yDX[dVar.klY]);
        }
        h.iv(gVar.yEe.getWidth());
        h.iw((int) gVar.yEe.getTextSize());
        h.a(gVar.yEe.getPaint());
        if (str.toLowerCase().endsWith("@t.qq.com")) {
            gVar.yEc.setCompoundRightDrawablesWithIntrinsicBounds((int) R.drawable.icon_tencent_weibo);
            gVar.yEc.setDrawRightDrawable(true);
        } else {
            gVar.yEc.setDrawRightDrawable(false);
        }
        i2 = dVar.zrJ;
        if (i2 != -1) {
            gVar.yEe.setCompoundLeftDrawablesWithIntrinsicBounds(i2);
            gVar.yEe.setDrawLeftDrawable(true);
        } else {
            gVar.yEe.setDrawLeftDrawable(false);
        }
        gVar.zrV.setVisibility(8);
        LayoutParams layoutParams = gVar.yEd.getLayoutParams();
        if (dVar.zrH.length() > 9) {
            if (layoutParams.width != this.zry) {
                layoutParams.width = this.zry;
                gVar.yEd.setLayoutParams(layoutParams);
            }
        } else if (layoutParams.width != this.zrx) {
            layoutParams.width = this.zrx;
            gVar.yEd.setLayoutParams(layoutParams);
        }
        ab.v("MicroMsg.ConversationAdapter", "layout update time width %d", Integer.valueOf(layoutParams.width));
        gVar.yEd.setText(dVar.zrH);
        gVar.yEe.setText(dVar.zrI);
        if (dVar.mgQ && dVar.zrR) {
            gVar.yEf.setVisibility(0);
        } else if (dVar.zrN) {
            gVar.yEf.setVisibility(0);
        } else {
            gVar.yEf.setVisibility(8);
        }
        if ((this.context instanceof BizConversationUI) || (this.context instanceof NewBizConversationUI)) {
            com.tencent.mm.pluginsdk.ui.a.b.r(gVar.ejo, str);
        } else {
            com.tencent.mm.pluginsdk.ui.a.b.b(gVar.ejo, str);
        }
        if (this.zrm) {
            if (akVar == null || gVar == null || dVar == null) {
                ab.w("MicroMsg.ConversationAdapter", "handle show tip cnt, but conversation or viewholder is null");
            } else {
                gVar.jJV.setVisibility(4);
                gVar.yEh.setVisibility(4);
                if (t.ny(akVar.field_username)) {
                    gVar.yEh.setVisibility(akVar.field_unReadCount > 0 ? 0 : 4);
                    gVar.yEc.setTextColor(this.yDX[3]);
                } else {
                    ColorStateList colorStateList;
                    NoMeasuredTextView noMeasuredTextView = gVar.yEc;
                    if (dVar.zrQ && dVar.zrL == 1) {
                        colorStateList = this.yDX[2];
                    } else {
                        colorStateList = this.yDX[3];
                    }
                    noMeasuredTextView.setTextColor(colorStateList);
                    if (!dVar.zrQ || dVar.zrK == 0) {
                        ab.w("MicroMsg.ConversationAdapter", "handle show tip count, but talker is null");
                    } else if (t.ny(akVar.field_parentRef)) {
                        if (!(this.context instanceof NewBizConversationUI)) {
                            gVar.yEh.setVisibility(akVar.field_unReadCount > 0 ? 0 : 4);
                        }
                    } else if (dVar.zrN && dVar.zrS) {
                        gVar.yEh.setVisibility(akVar.field_unReadCount > 0 ? 0 : 4);
                    } else if (dVar.mgQ && dVar.zrR) {
                        gVar.yEh.setVisibility(akVar.field_unReadCount > 0 ? 0 : 4);
                    } else {
                        i2 = akVar.field_unReadCount;
                        if (i2 > 99) {
                            gVar.jJV.setText("");
                            gVar.jJV.setBackgroundResource(R.raw.badge_count_more);
                            gVar.jJV.setVisibility(0);
                        } else if (i2 > 0) {
                            gVar.jJV.setText(akVar.field_unReadCount);
                            gVar.jJV.setBackgroundResource(r.ik(this.context));
                            gVar.jJV.setVisibility(0);
                        }
                        this.zrz.zrF = i2;
                    }
                }
            }
        }
        if (!dVar.zrM && dVar.yDZ && aw.RK()) {
            aw.ZK();
            com.tencent.mm.model.c.XR().f(akVar);
        }
        if ((this.context instanceof NewBizConversationUI) && dVar.yDZ && akVar.field_conversationTime != -1) {
            Drawable drawable = this.context.getResources().getDrawable(R.drawable.axl);
            int textSize = (int) gVar.yEc.getTextSize();
            drawable.setBounds(0, 0, textSize, textSize);
            new SpannableString("@").setSpan(new com.tencent.mm.ui.widget.a(drawable), 0, 1, 33);
            gVar.yEc.setText(TextUtils.concat(new CharSequence[]{dVar.nickName, " ", r0}));
        } else {
            gVar.yEc.setText(dVar.nickName);
            if (dVar.yDZ && akVar.field_conversationTime != -1) {
                inflate.findViewById(R.id.b6c).setBackgroundResource(R.drawable.k4);
                com.tencent.mm.bp.d.dlL();
                szVar = new sz();
                szVar.cPf.cPh = true;
                com.tencent.mm.sdk.b.a.xxA.m(szVar);
                if (!(0 == com.tencent.mm.plugin.messenger.foundation.a.a.a.a(akVar, 7, 0) || akVar.field_username.equals(szVar.cPg.cPj))) {
                    akVar.eE(com.tencent.mm.plugin.messenger.foundation.a.a.a.a(akVar, 6, akVar.field_conversationTime));
                    aw.ZK();
                    com.tencent.mm.model.c.XR().a(akVar, akVar.field_username);
                }
                if (com.tencent.mm.bg.g.fUs == null && com.tencent.mm.bg.g.fUs.tN(akVar.field_username)) {
                    gVar.yEg.setVisibility(0);
                    if (akVar.field_username.equals(szVar.cPg.cPj)) {
                        gVar.yEg.setImageResource(R.raw.talk_room_mic_speaking);
                    } else {
                        gVar.yEg.setImageResource(R.raw.talk_room_mic_idle);
                    }
                } else {
                    gVar.yEg.setVisibility(8);
                }
                if (com.tencent.mm.bh.d.fUu == null && com.tencent.mm.bh.d.fUu.tQ(akVar.field_username)) {
                    gVar.zrW.setVisibility(0);
                } else {
                    gVar.zrW.setVisibility(8);
                }
                this.zrz.content = String.valueOf(dVar.zrI);
                this.zrz.bCu = String.valueOf(dVar.nickName);
                this.zrz.zrG = String.valueOf(dVar.zrH);
                aVar = this.zrz;
                com.tencent.mm.ui.a.a.a.yqY.a(inflate, aVar.bCu, aVar.zrF, aVar.zrG, aVar.content);
                a(str, gVar);
                a(akVar, dVar.yDZ, i, false);
                AppMethodBeat.o(34197);
                return inflate;
            }
        }
        inflate.findViewById(R.id.b6c).setBackgroundResource(R.drawable.k5);
        com.tencent.mm.bp.d.dlL();
        szVar = new sz();
        szVar.cPf.cPh = true;
        com.tencent.mm.sdk.b.a.xxA.m(szVar);
        akVar.eE(com.tencent.mm.plugin.messenger.foundation.a.a.a.a(akVar, 6, akVar.field_conversationTime));
        aw.ZK();
        com.tencent.mm.model.c.XR().a(akVar, akVar.field_username);
        if (com.tencent.mm.bg.g.fUs == null) {
        }
        gVar.yEg.setVisibility(8);
        if (com.tencent.mm.bh.d.fUu == null) {
        }
        gVar.zrW.setVisibility(8);
        this.zrz.content = String.valueOf(dVar.zrI);
        this.zrz.bCu = String.valueOf(dVar.nickName);
        this.zrz.zrG = String.valueOf(dVar.zrH);
        aVar = this.zrz;
        com.tencent.mm.ui.a.a.a.yqY.a(inflate, aVar.bCu, aVar.zrF, aVar.zrG, aVar.content);
        a(str, gVar);
        a(akVar, dVar.yDZ, i, false);
        AppMethodBeat.o(34197);
        return inflate;
    }

    /* Access modifiers changed, original: protected */
    public void a(String str, g gVar) {
    }

    /* Access modifiers changed, original: protected */
    public void a(ak akVar, boolean z, int i, boolean z2) {
    }

    private static int FB(String str) {
        int i = 1;
        AppMethodBeat.i(34198);
        if (str != null && str.length() > 0) {
            try {
                i = Integer.valueOf(str).intValue();
            } catch (NumberFormatException e) {
            }
        }
        AppMethodBeat.o(34198);
        return i;
    }

    private void ayz() {
        AppMethodBeat.i(34199);
        if (this.yDY != null) {
            this.yDY.clear();
            this.yDY = null;
        }
        AppMethodBeat.o(34199);
    }

    private static String aqV(String str) {
        AppMethodBeat.i(34201);
        if (str == null || str.length() != 32) {
            AppMethodBeat.o(34201);
            return null;
        }
        String Jh = ((com.tencent.mm.plugin.emoji.b.d) com.tencent.mm.kernel.g.M(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().Jh(str);
        AppMethodBeat.o(34201);
        return Jh;
    }

    public final void a(int i, n nVar, Object obj) {
        AppMethodBeat.i(34202);
        if (obj == null || !(obj instanceof String)) {
            ab.e("MicroMsg.ConversationAdapter", "onNotifyChange obj not String event:%d stg:%s obj:%s", Integer.valueOf(i), nVar, obj);
            AppMethodBeat.o(34202);
            return;
        }
        a((String) obj, null);
        AppMethodBeat.o(34202);
    }

    public final void a(String str, m mVar) {
        AppMethodBeat.i(34203);
        ab.i("MicroMsg.ConversationAdapter", "dkpno onNotifyChange mIsFront:%b mChangedBackground:%b event:%s", Boolean.valueOf(this.lhi), Boolean.valueOf(this.zrp), str);
        if (!(ah.isNullOrNil(str) || this.yDY == null)) {
            this.yDY.remove(str);
        }
        if (this.lhi) {
            dIr();
            AppMethodBeat.o(34203);
            return;
        }
        this.zrp = true;
        AppMethodBeat.o(34203);
    }

    private void dIr() {
        AppMethodBeat.i(34204);
        ab.d("MicroMsg.ConversationAdapter", "dkpno postTryNotify needNotify:%b timerStopped:%b", Boolean.valueOf(this.zrB), Boolean.valueOf(this.zrC.doT()));
        this.zrB = true;
        if (this.zrC.doT()) {
            dIs();
        }
        AppMethodBeat.o(34204);
    }

    private void dIs() {
        AppMethodBeat.i(34205);
        al.d(new Runnable() {
            public final void run() {
                AppMethodBeat.i(34186);
                if (aw.RK()) {
                    long anU = ah.anU();
                    e.g(e.this);
                    ab.d("MicroMsg.ConversationAdapter", "dkpno handleDataChange guest:%d old:%d needNotify:%b", Long.valueOf(ah.gb(anU) * 3), Long.valueOf(e.zrA), Boolean.valueOf(e.this.zrB));
                    e.zrA = (anU + e.zrA) / 2;
                    e.this.zrB = false;
                    ap f = e.this.zrC;
                    long dIt = e.zrA;
                    f.ae(dIt, dIt);
                    AppMethodBeat.o(34186);
                    return;
                }
                e.this.zrC.stopTimer();
                ab.e("MicroMsg.ConversationAdapter", "dkpno handleDataChange acc has not ready");
                AppMethodBeat.o(34186);
            }
        });
        AppMethodBeat.o(34205);
    }

    private CharSequence h(ak akVar) {
        AppMethodBeat.i(34190);
        CharSequence charSequence;
        if (akVar.field_status == 1) {
            String string = this.context.getString(R.string.cw8);
            AppMethodBeat.o(34190);
            return string;
        } else if (akVar.field_conversationTime == Long.MAX_VALUE) {
            charSequence = "";
            AppMethodBeat.o(34190);
            return charSequence;
        } else {
            charSequence = com.tencent.mm.pluginsdk.f.h.c(this.context, akVar.field_conversationTime, true);
            AppMethodBeat.o(34190);
            return charSequence;
        }
    }

    private CharSequence a(ak akVar, int i, boolean z) {
        AppMethodBeat.i(34200);
        if (ah.isNullOrNil(akVar.field_editingMsg) || (akVar.field_atCount > 0 && akVar.field_unReadCount > 0)) {
            CharSequence charSequence = akVar.field_digest;
            CharSequence string;
            if (charSequence == null || !charSequence.startsWith("<img src=\"original_label.png\"/>  ")) {
                int i2;
                String str;
                String str2 = akVar.field_username;
                if (str2.equals("qqmail")) {
                    aw.ZK();
                    if (ah.h((Integer) com.tencent.mm.model.c.Ry().get(17, null)) == 1) {
                        i2 = 1;
                    } else {
                        i2 = 0;
                    }
                    if (i2 == 0) {
                        string = this.context.getString(R.string.e_7);
                        AppMethodBeat.o(34200);
                        return string;
                    }
                }
                if (str2.equals("tmessage")) {
                    aw.ZK();
                    bq RA = com.tencent.mm.model.c.XU().RA("@t.qq.com");
                    if (RA == null || !RA.isEnable()) {
                        i2 = 0;
                    } else {
                        i2 = 1;
                    }
                    if (i2 == 0) {
                        string = this.context.getString(R.string.e_7);
                        AppMethodBeat.o(34200);
                        return string;
                    }
                }
                if (akVar.field_msgType != null && (akVar.field_msgType.equals("47") || akVar.field_msgType.equals("1048625"))) {
                    str2 = aqV(akVar.field_digest);
                    str = "";
                    if (str2 != null) {
                        string = "[" + str2 + "]";
                        AppMethodBeat.o(34200);
                        return string;
                    }
                    if (akVar.field_digest != null && akVar.field_digest.contains(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D)) {
                        str = akVar.field_digest.substring(0, akVar.field_digest.indexOf(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D));
                        str2 = aqV(akVar.field_digest.substring(akVar.field_digest.indexOf(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D) + 1).replace(" ", ""));
                        if (str2 != null) {
                            str2 = "[" + str2 + "]";
                            if (ah.isNullOrNil(str)) {
                                AppMethodBeat.o(34200);
                                return str2;
                            }
                            string = str + ": " + str2;
                            AppMethodBeat.o(34200);
                            return string;
                        }
                    }
                    str2 = this.context.getString(R.string.ph);
                    if (ah.isNullOrNil(str)) {
                        str = str2;
                    } else {
                        str = str + ": " + str2;
                    }
                    akVar.jh(str);
                }
                if (!ah.isNullOrNil(akVar.field_digest)) {
                    if (ah.isNullOrNil(akVar.field_digestUser)) {
                        str = akVar.field_digest;
                    } else {
                        if (akVar.field_isSend == 0 && t.kH(akVar.field_username)) {
                            str = s.getDisplayName(akVar.field_digestUser, akVar.field_username);
                        } else {
                            str = s.mJ(akVar.field_digestUser);
                        }
                        try {
                            str = String.format(akVar.field_digest, new Object[]{str});
                        } catch (Exception e) {
                        }
                    }
                    string = str.replace(10, ' ');
                    if (akVar.field_atCount > 0 || akVar.field_unReadCount <= 0) {
                        if (!z && akVar.field_unReadCount > 1) {
                            string = this.context.getString(R.string.cvg, new Object[]{Integer.valueOf(akVar.field_unReadCount), string});
                        } else if (akVar.field_unReadCount > 0 && t.ny(akVar.field_parentRef) && !(this.context instanceof NewBizConversationUI)) {
                            string = this.context.getString(R.string.cvg, new Object[]{Integer.valueOf(akVar.field_unReadCount), string});
                        }
                        string = j.b(this.context, string, i);
                        AppMethodBeat.o(34200);
                        return string;
                    }
                    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.context.getString(R.string.cvd));
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(-5569532), 0, spannableStringBuilder.length(), 33);
                    spannableStringBuilder.append(" ").append(j.b(this.context, string, i));
                    AppMethodBeat.o(34200);
                    return spannableStringBuilder;
                }
                str = h.a(akVar.field_isSend, akVar.field_username, akVar.field_content, FB(akVar.field_msgType), this.context);
                string = str.replace(10, ' ');
                if (akVar.field_atCount > 0) {
                }
                if (!z) {
                }
                string = this.context.getString(R.string.cvg, new Object[]{Integer.valueOf(akVar.field_unReadCount), string});
                string = j.b(this.context, string, i);
                AppMethodBeat.o(34200);
                return string;
            }
            string = new SpannableString(j.e(this.context, charSequence, (float) i));
            AppMethodBeat.o(34200);
            return string;
        }
        SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(this.context.getString(R.string.cvh));
        spannableStringBuilder2.setSpan(new ForegroundColorSpan(-5569532), 0, spannableStringBuilder2.length(), 33);
        spannableStringBuilder2.append(" ").append(j.b(this.context, akVar.field_editingMsg, i));
        AppMethodBeat.o(34200);
        return spannableStringBuilder2;
    }
}
