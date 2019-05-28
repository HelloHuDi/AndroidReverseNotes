package com.tencent.mm.ui.conversation;

import android.content.Context;
import android.content.res.ColorStateList;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.format.Time;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.booter.notification.a.h;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.s;
import com.tencent.mm.model.t;
import com.tencent.mm.modelvoice.n;
import com.tencent.mm.platformtools.ah;
import com.tencent.mm.pluginsdk.ui.e.j;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.ak;
import com.tencent.mm.ui.base.MMSlideDelView;
import com.tencent.mm.ui.base.MMSlideDelView.c;
import com.tencent.mm.ui.base.MMSlideDelView.d;
import com.tencent.mm.ui.base.MMSlideDelView.f;
import com.tencent.mm.ui.base.MMSlideDelView.g;
import com.tencent.mm.ui.base.NoMeasuredTextView;
import com.tencent.mm.ui.p;
import com.tencent.mm.ui.tools.r;
import com.tencent.ttpic.thread.FaceGestureDetGLThread;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.util.HashMap;
import java.util.Map.Entry;

public final class i extends p<ak> implements com.tencent.mm.sdk.e.n.b {
    private static long zrA = FaceGestureDetGLThread.BRIGHTNESS_DURATION;
    private String cIe;
    protected g jJO;
    protected c jJP;
    protected f jJQ;
    protected d jJR = MMSlideDelView.getItemStatusCallBack();
    private boolean lhi = false;
    private float yDU = -1.0f;
    private float yDV = -1.0f;
    private float yDW = -1.0f;
    HashMap<String, a> yDY;
    private boolean zrB = false;
    ap zrC = new ap(aw.RS().oAl.getLooper(), new com.tencent.mm.sdk.platformtools.ap.a() {
        public final boolean BI() {
            AppMethodBeat.i(34397);
            if (i.this.zrB) {
                i.b(i.this);
            }
            AppMethodBeat.o(34397);
            return false;
        }
    }, false);
    private boolean zrp = false;
    public String zrv = "";
    private final int zrx;
    private final int zry;
    private ColorStateList[] zug = new ColorStateList[5];

    class a {
        public int klY;
        public CharSequence nickName;
        public boolean rXd;
        public boolean yDZ;
        public CharSequence zrH;
        public CharSequence zrI;
        public int zrJ;
        public int zrK;
        public boolean zrN;
        public boolean zrO;
        public boolean zrQ;
        public boolean zrS;
        public int zrT;

        private a() {
        }

        /* synthetic */ a(i iVar, byte b) {
            this();
        }
    }

    public static class b {
        public ImageView ejo;
        public ImageView yEf;
        public View yEh;
        public NoMeasuredTextView zui;
        public NoMeasuredTextView zuj;
        public NoMeasuredTextView zuk;
        public TextView zul;
    }

    static /* synthetic */ void b(i iVar) {
        AppMethodBeat.i(34415);
        iVar.dIs();
        AppMethodBeat.o(34415);
    }

    static /* synthetic */ void d(i iVar) {
        AppMethodBeat.i(34416);
        super.a(null, null);
        AppMethodBeat.o(34416);
    }

    public i(Context context, String str, com.tencent.mm.ui.p.a aVar) {
        super(context, new ak());
        AppMethodBeat.i(34399);
        super.a(aVar);
        this.cIe = str;
        this.yDY = new HashMap();
        this.zug[0] = com.tencent.mm.bz.a.h(context, (int) R.color.s0);
        this.zug[1] = com.tencent.mm.bz.a.h(context, (int) R.color.a7y);
        this.zug[3] = com.tencent.mm.bz.a.h(context, (int) R.color.w4);
        this.zug[2] = com.tencent.mm.bz.a.h(context, (int) R.color.a7v);
        this.zug[2] = com.tencent.mm.bz.a.h(context, (int) R.color.a7v);
        this.zug[4] = com.tencent.mm.bz.a.h(context, (int) R.color.t3);
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
        aw.ZK();
        com.tencent.mm.model.c.XR().a(this);
        AppMethodBeat.o(34399);
    }

    public final void setPerformItemClickListener(g gVar) {
        this.jJO = gVar;
    }

    public final void a(f fVar) {
        this.jJQ = fVar;
    }

    public final void setGetViewPositionCallback(c cVar) {
        this.jJP = cVar;
    }

    public final void onPause() {
        AppMethodBeat.i(34400);
        if (this.jJR != null) {
            this.jJR.bIp();
        }
        this.lhi = false;
        AppMethodBeat.o(34400);
    }

    public final void onResume() {
        boolean z = true;
        AppMethodBeat.i(34401);
        this.lhi = true;
        Time time = new Time();
        time.setToNow();
        String charSequence = com.tencent.mm.pluginsdk.f.g.a("MM/dd", time).toString();
        if (this.zrv.equals(charSequence)) {
            z = false;
        }
        this.zrv = charSequence;
        if (z) {
            dIq();
        }
        if (this.zrp) {
            super.a(null, null);
            this.zrp = false;
        }
        AppMethodBeat.o(34401);
    }

    public final void KD() {
        AppMethodBeat.i(34402);
        KC();
        AppMethodBeat.o(34402);
    }

    public final void KC() {
        AppMethodBeat.i(34403);
        bIf();
        aw.ZK();
        setCursor(com.tencent.mm.model.c.XR().c(t.fkP, null, this.cIe));
        if (this.yle != null) {
            this.yle.apt();
        }
        super.notifyDataSetChanged();
        AppMethodBeat.o(34403);
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        View inflate;
        int i2;
        a aVar;
        AppMethodBeat.i(34404);
        ak akVar = (ak) getItem(i);
        String str = akVar.field_username;
        b bVar2 = null;
        if (view != null) {
            bVar2 = (b) view.getTag();
        }
        if (view == null || bVar2 == null) {
            bVar = new b();
            if (com.tencent.mm.bz.a.ga(this.context)) {
                inflate = View.inflate(this.context, R.layout.r9, null);
            } else {
                inflate = View.inflate(this.context, R.layout.r8, null);
            }
            bVar.ejo = (ImageView) inflate.findViewById(R.id.qk);
            bVar.zui = (NoMeasuredTextView) inflate.findViewById(R.id.b6e);
            bVar.zui.setTextSize(0, this.yDU);
            bVar.zui.setTextColor(this.zug[3]);
            bVar.zui.setShouldEllipsize(true);
            bVar.zuj = (NoMeasuredTextView) inflate.findViewById(R.id.b6f);
            bVar.zuj.setTextSize(0, this.yDW);
            bVar.zuj.setTextColor(this.zug[4]);
            bVar.zuj.setShouldEllipsize(false);
            bVar.zuj.setGravity(5);
            bVar.zuk = (NoMeasuredTextView) inflate.findViewById(R.id.b6g);
            bVar.zuk.setTextSize(0, this.yDV);
            bVar.zuk.setTextColor(this.zug[0]);
            bVar.zuk.setShouldEllipsize(true);
            bVar.zul = (TextView) inflate.findViewById(R.id.nf);
            bVar.zul.setBackgroundResource(r.ik(this.context));
            bVar.yEf = (ImageView) inflate.findViewById(R.id.b6i);
            bVar.yEh = inflate.findViewById(R.id.b6d);
            inflate.findViewById(R.id.b6j).setVisibility(8);
            inflate.findViewById(R.id.b6k).setVisibility(8);
            inflate.setTag(bVar);
        } else {
            bVar = bVar2;
            inflate = view;
        }
        a aVar2 = (a) this.yDY.get(str);
        aw.ZK();
        ad aoO = com.tencent.mm.model.c.XM().aoO(str);
        if (aVar2 == null) {
            a aVar3 = new a(this, (byte) 0);
            if (aoO != null) {
                aVar3.zrK = (int) aoO.ewQ;
            } else {
                aVar3.zrK = -1;
            }
            aVar3.zrQ = aoO != null;
            boolean z = aoO != null && aoO.Kc();
            aVar3.zrS = z;
            if (aoO == null || !aoO.DX()) {
                z = false;
            } else {
                z = true;
            }
            aVar3.zrN = z;
            aVar3.rXd = akVar.field_unReadCount > 0;
            aVar3.klY = 0;
            if (k(akVar) == 34 && akVar.field_isSend == 0 && !ah.isNullOrNil(akVar.field_content) && !new n(akVar.field_content).fWX) {
                aVar3.klY = 1;
            }
            aVar3.nickName = j.b(this.context, s.a(aoO, str, false), bVar.zui.getTextSize());
            aVar3.zrH = h(akVar);
            int textSize = (int) bVar.zuk.getTextSize();
            if (aVar3.zrN && aVar3.rXd) {
                z = true;
            } else {
                z = false;
            }
            aVar3.zrI = c(akVar, textSize, z);
            aVar3.zrT = akVar.field_attrflag;
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
            aVar3.zrJ = i2;
            aw.ZK();
            aVar3.yDZ = com.tencent.mm.model.c.XR().g(akVar);
            aVar3.zrO = aa.don();
            this.yDY.put(str, aVar3);
            aVar = aVar3;
        } else {
            aVar = aVar2;
        }
        if (aVar.zrH == null) {
            aVar.zrH = h(akVar);
        }
        if (aVar.zrN && aVar.rXd) {
            bVar.zuk.setTextColor(this.zug[0]);
        } else {
            bVar.zuk.setTextColor(this.zug[aVar.klY]);
        }
        h.iv(bVar.zuk.getWidth());
        h.iw((int) bVar.zuk.getTextSize());
        h.a(bVar.zuk.getPaint());
        if (aVar.zrJ != -1) {
            bVar.zuk.setCompoundLeftDrawablesWithIntrinsicBounds(aVar.zrJ);
            bVar.zuk.setDrawLeftDrawable(true);
        } else {
            bVar.zuk.setDrawLeftDrawable(false);
        }
        bVar.zuk.setText(aVar.zrI);
        bVar.zui.setDrawRightDrawable(false);
        bVar.zui.setText(aVar.nickName);
        LayoutParams layoutParams = bVar.zuj.getLayoutParams();
        if (aVar.zrH.length() > 9) {
            if (layoutParams.width != this.zry) {
                layoutParams.width = this.zry;
                bVar.zuj.setLayoutParams(layoutParams);
            }
        } else if (layoutParams.width != this.zrx) {
            layoutParams.width = this.zrx;
            bVar.zuj.setLayoutParams(layoutParams);
        }
        bVar.zuj.setText(aVar.zrH);
        if (aVar.zrN) {
            bVar.yEf.setVisibility(0);
        } else {
            bVar.yEf.setVisibility(8);
        }
        com.tencent.mm.pluginsdk.ui.a.b.b(bVar.ejo, str);
        bVar.zul.setVisibility(4);
        bVar.yEh.setVisibility(4);
        if (aVar.zrQ && aVar.zrK != 0) {
            i2 = akVar.field_unReadCount;
            if (aVar.zrN) {
                View view2 = bVar.yEh;
                if (i2 > 0) {
                    i2 = 0;
                } else {
                    i2 = 4;
                }
                view2.setVisibility(i2);
            } else if (i2 > 99) {
                bVar.zul.setText("");
                bVar.zul.setBackgroundResource(R.raw.badge_count_more);
                bVar.zul.setVisibility(0);
            } else if (i2 > 0) {
                bVar.zul.setText(String.valueOf(i2));
                bVar.zul.setBackgroundResource(r.ik(this.context));
                bVar.zul.setVisibility(0);
            }
        }
        if (!aVar.yDZ || akVar.field_conversationTime == -1) {
            inflate.findViewById(R.id.b6c).setBackgroundResource(R.drawable.k5);
        } else {
            inflate.findViewById(R.id.b6c).setBackgroundResource(R.drawable.k4);
        }
        com.tencent.mm.ui.a.a.a.yqY.a(inflate, String.valueOf(aVar.nickName), akVar.field_unReadCount, String.valueOf(aVar.zrH), String.valueOf(aVar.zrI));
        AppMethodBeat.o(34404);
        return inflate;
    }

    private static String aqV(String str) {
        AppMethodBeat.i(34407);
        if (str == null || str.length() != 32) {
            AppMethodBeat.o(34407);
            return null;
        }
        String Jh = ((com.tencent.mm.plugin.emoji.b.d) com.tencent.mm.kernel.g.M(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().Jh(str);
        AppMethodBeat.o(34407);
        return Jh;
    }

    private void dIq() {
        AppMethodBeat.i(34409);
        if (this.yDY == null) {
            AppMethodBeat.o(34409);
            return;
        }
        for (Entry value : this.yDY.entrySet()) {
            ((a) value.getValue()).zrH = null;
        }
        AppMethodBeat.o(34409);
    }

    public final void a(int i, com.tencent.mm.sdk.e.n nVar, Object obj) {
        AppMethodBeat.i(34410);
        if (obj == null || !(obj instanceof String)) {
            ab.e("MicroMsg.EnterpriseConversationAdapter", "onNotifyChange obj not String event:%d stg:%s obj:%s", Integer.valueOf(i), nVar, obj);
            AppMethodBeat.o(34410);
            return;
        }
        a((String) obj, null);
        AppMethodBeat.o(34410);
    }

    public final void a(String str, m mVar) {
        AppMethodBeat.i(34411);
        ab.i("MicroMsg.EnterpriseConversationAdapter", "dkpno onNotifyChange mIsFront:%b mChangedBackground:%b event:%s", Boolean.valueOf(this.lhi), Boolean.valueOf(this.zrp), str);
        if (!(ah.isNullOrNil(str) || this.yDY == null)) {
            this.yDY.remove(str);
        }
        if (this.lhi) {
            dIr();
            AppMethodBeat.o(34411);
            return;
        }
        this.zrp = true;
        AppMethodBeat.o(34411);
    }

    private void dIr() {
        AppMethodBeat.i(34412);
        ab.d("MicroMsg.EnterpriseConversationAdapter", "dkpno postTryNotify needNotify:%b timerStopped:%b", Boolean.valueOf(this.zrB), Boolean.valueOf(this.zrC.doT()));
        this.zrB = true;
        if (this.zrC.doT()) {
            dIs();
        }
        AppMethodBeat.o(34412);
    }

    private void dIs() {
        AppMethodBeat.i(34413);
        al.d(new Runnable() {
            public final void run() {
                AppMethodBeat.i(34398);
                if (aw.RK()) {
                    long anU = ah.anU();
                    i.d(i.this);
                    ab.d("MicroMsg.EnterpriseConversationAdapter", "dkpno handleDataChange guest:%d old:%d needNotify:%b", Long.valueOf(ah.gb(anU) * 3), Long.valueOf(i.zrA), Boolean.valueOf(i.this.zrB));
                    i.zrA = (anU + i.zrA) / 2;
                    i.this.zrB = false;
                    ap c = i.this.zrC;
                    long dIL = i.zrA;
                    c.ae(dIL, dIL);
                    AppMethodBeat.o(34398);
                    return;
                }
                i.this.zrC.stopTimer();
                ab.e("MicroMsg.EnterpriseConversationAdapter", "dkpno handleDataChange acc has not ready");
                AppMethodBeat.o(34398);
            }
        });
        AppMethodBeat.o(34413);
    }

    private static int k(ak akVar) {
        int i = 1;
        AppMethodBeat.i(34405);
        String str = akVar.field_msgType;
        if (str != null && str.length() > 0) {
            try {
                i = Integer.valueOf(str).intValue();
            } catch (NumberFormatException e) {
            }
        }
        AppMethodBeat.o(34405);
        return i;
    }

    private CharSequence c(ak akVar, int i, boolean z) {
        AppMethodBeat.i(34406);
        if (ah.isNullOrNil(akVar.field_editingMsg) || (akVar.field_atCount > 0 && akVar.field_unReadCount > 0)) {
            CharSequence charSequence = akVar.field_digest;
            CharSequence charSequence2;
            if (charSequence == null || !charSequence.startsWith("<img src=\"original_label.png\"/>  ")) {
                String str;
                if (k(akVar) == 47 || k(akVar) == 1048625) {
                    String aqV = aqV(akVar.field_digest);
                    str = "";
                    if (aqV != null) {
                        charSequence2 = "[" + aqV + "]";
                        AppMethodBeat.o(34406);
                        return charSequence2;
                    }
                    if (akVar.field_digest != null && akVar.field_digest.contains(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D)) {
                        str = akVar.field_digest.substring(0, akVar.field_digest.indexOf(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D));
                        aqV = aqV(akVar.field_digest.substring(akVar.field_digest.indexOf(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D) + 1).replace(" ", ""));
                        if (aqV != null) {
                            aqV = "[" + aqV + "]";
                            if (ah.isNullOrNil(str)) {
                                AppMethodBeat.o(34406);
                                return aqV;
                            }
                            charSequence2 = str + ": " + aqV;
                            AppMethodBeat.o(34406);
                            return charSequence2;
                        }
                    }
                    aqV = this.context.getString(R.string.ph);
                    if (ah.isNullOrNil(str)) {
                        str = aqV;
                    } else {
                        str = str + ": " + aqV;
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
                    charSequence2 = str.replace(10, ' ');
                    if (akVar.field_atCount > 0 || akVar.field_unReadCount <= 0) {
                        if (z && akVar.field_unReadCount > 1) {
                            charSequence2 = this.context.getString(R.string.cvg, new Object[]{Integer.valueOf(akVar.field_unReadCount), charSequence2});
                        }
                        charSequence2 = j.b(this.context, charSequence2, i);
                        AppMethodBeat.o(34406);
                        return charSequence2;
                    }
                    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.context.getString(R.string.cvd));
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(-5569532), 0, spannableStringBuilder.length(), 33);
                    spannableStringBuilder.append(" ").append(j.b(this.context, charSequence2, i));
                    AppMethodBeat.o(34406);
                    return spannableStringBuilder;
                }
                str = h.a(akVar.field_isSend, akVar.field_username, akVar.field_content, k(akVar), this.context);
                charSequence2 = str.replace(10, ' ');
                if (akVar.field_atCount > 0) {
                }
                charSequence2 = this.context.getString(R.string.cvg, new Object[]{Integer.valueOf(akVar.field_unReadCount), charSequence2});
                charSequence2 = j.b(this.context, charSequence2, i);
                AppMethodBeat.o(34406);
                return charSequence2;
            }
            charSequence2 = new SpannableString(j.e(this.context, charSequence, (float) i));
            AppMethodBeat.o(34406);
            return charSequence2;
        }
        SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(this.context.getString(R.string.cvh));
        spannableStringBuilder2.setSpan(new ForegroundColorSpan(-5569532), 0, spannableStringBuilder2.length(), 33);
        spannableStringBuilder2.append(" ").append(j.b(this.context, akVar.field_editingMsg, i));
        AppMethodBeat.o(34406);
        return spannableStringBuilder2;
    }

    private CharSequence h(ak akVar) {
        AppMethodBeat.i(34408);
        CharSequence charSequence;
        if (akVar.field_status == 1) {
            String string = this.context.getString(R.string.cw8);
            AppMethodBeat.o(34408);
            return string;
        } else if (akVar.field_conversationTime == Long.MAX_VALUE) {
            charSequence = "";
            AppMethodBeat.o(34408);
            return charSequence;
        } else {
            charSequence = com.tencent.mm.pluginsdk.f.h.c(this.context, akVar.field_conversationTime, true);
            AppMethodBeat.o(34408);
            return charSequence;
        }
    }
}
