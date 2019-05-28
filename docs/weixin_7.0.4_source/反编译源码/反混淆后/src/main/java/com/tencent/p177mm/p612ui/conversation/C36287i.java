package com.tencent.p177mm.p612ui.conversation;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.booter.notification.p841a.C37622h;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1854s;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.modelvoice.C42230n;
import com.tencent.p177mm.p208bz.C1338a;
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
import com.tencent.p177mm.platformtools.C42252ah;
import com.tencent.p177mm.plugin.emoji.p725b.C6835d;
import com.tencent.p177mm.pluginsdk.p1079f.C14835h;
import com.tencent.p177mm.pluginsdk.p1079f.C46486g;
import com.tencent.p177mm.pluginsdk.p597ui.C40459a.C40460b;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.sdk.p603e.C4935m;
import com.tencent.p177mm.sdk.p603e.C7298n;
import com.tencent.p177mm.sdk.p603e.C7298n.C4937b;
import com.tencent.p177mm.sdk.platformtools.C4988aa;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C7564ap;
import com.tencent.p177mm.sdk.platformtools.C7564ap.C5015a;
import com.tencent.p177mm.storage.C7616ad;
import com.tencent.p177mm.storage.C7617ak;
import com.tencent.ttpic.thread.FaceGestureDetGLThread;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.util.HashMap;
import java.util.Map.Entry;

/* renamed from: com.tencent.mm.ui.conversation.i */
public final class C36287i extends C46692p<C7617ak> implements C4937b {
    private static long zrA = FaceGestureDetGLThread.BRIGHTNESS_DURATION;
    private String cIe;
    protected C23600g jJO;
    protected C15521c jJP;
    protected C23599f jJQ;
    protected C23597d jJR = MMSlideDelView.getItemStatusCallBack();
    private boolean lhi = false;
    private float yDU = -1.0f;
    private float yDV = -1.0f;
    private float yDW = -1.0f;
    HashMap<String, C15870a> yDY;
    private boolean zrB = false;
    C7564ap zrC = new C7564ap(C9638aw.m17180RS().oAl.getLooper(), new C362881(), false);
    private boolean zrp = false;
    public String zrv = "";
    private final int zrx;
    private final int zry;
    private ColorStateList[] zug = new ColorStateList[5];

    /* renamed from: com.tencent.mm.ui.conversation.i$a */
    class C15870a {
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

        private C15870a() {
        }

        /* synthetic */ C15870a(C36287i c36287i, byte b) {
            this();
        }
    }

    /* renamed from: com.tencent.mm.ui.conversation.i$b */
    public static class C36286b {
        public ImageView ejo;
        public ImageView yEf;
        public View yEh;
        public NoMeasuredTextView zui;
        public NoMeasuredTextView zuj;
        public NoMeasuredTextView zuk;
        public TextView zul;
    }

    /* renamed from: com.tencent.mm.ui.conversation.i$1 */
    class C362881 implements C5015a {
        C362881() {
        }

        /* renamed from: BI */
        public final boolean mo4499BI() {
            AppMethodBeat.m2504i(34397);
            if (C36287i.this.zrB) {
                C36287i.m59730b(C36287i.this);
            }
            AppMethodBeat.m2505o(34397);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.ui.conversation.i$2 */
    class C362892 implements Runnable {
        C362892() {
        }

        public final void run() {
            AppMethodBeat.m2504i(34398);
            if (C9638aw.m17179RK()) {
                long anU = C42252ah.anU();
                C36287i.m59733d(C36287i.this);
                C4990ab.m7411d("MicroMsg.EnterpriseConversationAdapter", "dkpno handleDataChange guest:%d old:%d needNotify:%b", Long.valueOf(C42252ah.m74623gb(anU) * 3), Long.valueOf(C36287i.zrA), Boolean.valueOf(C36287i.this.zrB));
                C36287i.zrA = (anU + C36287i.zrA) / 2;
                C36287i.this.zrB = false;
                C7564ap c = C36287i.this.zrC;
                long dIL = C36287i.zrA;
                c.mo16770ae(dIL, dIL);
                AppMethodBeat.m2505o(34398);
                return;
            }
            C36287i.this.zrC.stopTimer();
            C4990ab.m7412e("MicroMsg.EnterpriseConversationAdapter", "dkpno handleDataChange acc has not ready");
            AppMethodBeat.m2505o(34398);
        }
    }

    /* renamed from: b */
    static /* synthetic */ void m59730b(C36287i c36287i) {
        AppMethodBeat.m2504i(34415);
        c36287i.dIs();
        AppMethodBeat.m2505o(34415);
    }

    /* renamed from: d */
    static /* synthetic */ void m59733d(C36287i c36287i) {
        AppMethodBeat.m2504i(34416);
        super.mo5248a(null, null);
        AppMethodBeat.m2505o(34416);
    }

    public C36287i(Context context, String str, C30723a c30723a) {
        super(context, new C7617ak());
        AppMethodBeat.m2504i(34399);
        super.mo74992a(c30723a);
        this.cIe = str;
        this.yDY = new HashMap();
        this.zug[0] = C1338a.m2870h(context, (int) C25738R.color.f12092s0);
        this.zug[1] = C1338a.m2870h(context, (int) C25738R.color.a7y);
        this.zug[3] = C1338a.m2870h(context, (int) C25738R.color.f12212w4);
        this.zug[2] = C1338a.m2870h(context, (int) C25738R.color.a7v);
        this.zug[2] = C1338a.m2870h(context, (int) C25738R.color.a7v);
        this.zug[4] = C1338a.m2870h(context, (int) C25738R.color.f12120t3);
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
        C9638aw.m17190ZK();
        C18628c.m29083XR().mo10118a(this);
        AppMethodBeat.m2505o(34399);
    }

    public final void setPerformItemClickListener(C23600g c23600g) {
        this.jJO = c23600g;
    }

    /* renamed from: a */
    public final void mo57151a(C23599f c23599f) {
        this.jJQ = c23599f;
    }

    public final void setGetViewPositionCallback(C15521c c15521c) {
        this.jJP = c15521c;
    }

    public final void onPause() {
        AppMethodBeat.m2504i(34400);
        if (this.jJR != null) {
            this.jJR.bIp();
        }
        this.lhi = false;
        AppMethodBeat.m2505o(34400);
    }

    public final void onResume() {
        boolean z = true;
        AppMethodBeat.m2504i(34401);
        this.lhi = true;
        Time time = new Time();
        time.setToNow();
        String charSequence = C46486g.m87705a("MM/dd", time).toString();
        if (this.zrv.equals(charSequence)) {
            z = false;
        }
        this.zrv = charSequence;
        if (z) {
            dIq();
        }
        if (this.zrp) {
            super.mo5248a(null, null);
            this.zrp = false;
        }
        AppMethodBeat.m2505o(34401);
    }

    /* renamed from: KD */
    public final void mo6870KD() {
        AppMethodBeat.m2504i(34402);
        mo6869KC();
        AppMethodBeat.m2505o(34402);
    }

    /* renamed from: KC */
    public final void mo6869KC() {
        AppMethodBeat.m2504i(34403);
        bIf();
        C9638aw.m17190ZK();
        setCursor(C18628c.m29083XR().mo15804c(C1855t.fkP, null, this.cIe));
        if (this.yle != null) {
            this.yle.apt();
        }
        super.notifyDataSetChanged();
        AppMethodBeat.m2505o(34403);
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        C36286b c36286b;
        View inflate;
        int i2;
        C15870a c15870a;
        AppMethodBeat.m2504i(34404);
        C7617ak c7617ak = (C7617ak) getItem(i);
        String str = c7617ak.field_username;
        C36286b c36286b2 = null;
        if (view != null) {
            c36286b2 = (C36286b) view.getTag();
        }
        if (view == null || c36286b2 == null) {
            c36286b = new C36286b();
            if (C1338a.m2865ga(this.context)) {
                inflate = View.inflate(this.context, 2130969242, null);
            } else {
                inflate = View.inflate(this.context, 2130969241, null);
            }
            c36286b.ejo = (ImageView) inflate.findViewById(2131821183);
            c36286b.zui = (NoMeasuredTextView) inflate.findViewById(2131823149);
            c36286b.zui.setTextSize(0, this.yDU);
            c36286b.zui.setTextColor(this.zug[3]);
            c36286b.zui.setShouldEllipsize(true);
            c36286b.zuj = (NoMeasuredTextView) inflate.findViewById(2131823150);
            c36286b.zuj.setTextSize(0, this.yDW);
            c36286b.zuj.setTextColor(this.zug[4]);
            c36286b.zuj.setShouldEllipsize(false);
            c36286b.zuj.setGravity(5);
            c36286b.zuk = (NoMeasuredTextView) inflate.findViewById(2131823151);
            c36286b.zuk.setTextSize(0, this.yDV);
            c36286b.zuk.setTextColor(this.zug[0]);
            c36286b.zuk.setShouldEllipsize(true);
            c36286b.zul = (TextView) inflate.findViewById(2131821067);
            c36286b.zul.setBackgroundResource(C44385r.m80243ik(this.context));
            c36286b.yEf = (ImageView) inflate.findViewById(2131823153);
            c36286b.yEh = inflate.findViewById(2131823148);
            inflate.findViewById(2131823154).setVisibility(8);
            inflate.findViewById(2131823155).setVisibility(8);
            inflate.setTag(c36286b);
        } else {
            c36286b = c36286b2;
            inflate = view;
        }
        C15870a c15870a2 = (C15870a) this.yDY.get(str);
        C9638aw.m17190ZK();
        C7616ad aoO = C18628c.m29078XM().aoO(str);
        if (c15870a2 == null) {
            C15870a c15870a3 = new C15870a(this, (byte) 0);
            if (aoO != null) {
                c15870a3.zrK = (int) aoO.ewQ;
            } else {
                c15870a3.zrK = -1;
            }
            c15870a3.zrQ = aoO != null;
            boolean z = aoO != null && aoO.mo16674Kc();
            c15870a3.zrS = z;
            if (aoO == null || !aoO.mo16673DX()) {
                z = false;
            } else {
                z = true;
            }
            c15870a3.zrN = z;
            c15870a3.rXd = c7617ak.field_unReadCount > 0;
            c15870a3.klY = 0;
            if (C36287i.m59736k(c7617ak) == 34 && c7617ak.field_isSend == 0 && !C42252ah.isNullOrNil(c7617ak.field_content) && !new C42230n(c7617ak.field_content).fWX) {
                c15870a3.klY = 1;
            }
            c15870a3.nickName = C44089j.m79293b(this.context, C1854s.m3861a(aoO, str, false), c36286b.zui.getTextSize());
            c15870a3.zrH = m59735h(c7617ak);
            int textSize = (int) c36286b.zuk.getTextSize();
            if (c15870a3.zrN && c15870a3.rXd) {
                z = true;
            } else {
                z = false;
            }
            c15870a3.zrI = m59732c(c7617ak, textSize, z);
            c15870a3.zrT = c7617ak.field_attrflag;
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
            c15870a3.zrJ = i2;
            C9638aw.m17190ZK();
            c15870a3.yDZ = C18628c.m29083XR().mo15822g(c7617ak);
            c15870a3.zrO = C4988aa.don();
            this.yDY.put(str, c15870a3);
            c15870a = c15870a3;
        } else {
            c15870a = c15870a2;
        }
        if (c15870a.zrH == null) {
            c15870a.zrH = m59735h(c7617ak);
        }
        if (c15870a.zrN && c15870a.rXd) {
            c36286b.zuk.setTextColor(this.zug[0]);
        } else {
            c36286b.zuk.setTextColor(this.zug[c15870a.klY]);
        }
        C37622h.m63534iv(c36286b.zuk.getWidth());
        C37622h.m63535iw((int) c36286b.zuk.getTextSize());
        C37622h.m63525a(c36286b.zuk.getPaint());
        if (c15870a.zrJ != -1) {
            c36286b.zuk.setCompoundLeftDrawablesWithIntrinsicBounds(c15870a.zrJ);
            c36286b.zuk.setDrawLeftDrawable(true);
        } else {
            c36286b.zuk.setDrawLeftDrawable(false);
        }
        c36286b.zuk.setText(c15870a.zrI);
        c36286b.zui.setDrawRightDrawable(false);
        c36286b.zui.setText(c15870a.nickName);
        LayoutParams layoutParams = c36286b.zuj.getLayoutParams();
        if (c15870a.zrH.length() > 9) {
            if (layoutParams.width != this.zry) {
                layoutParams.width = this.zry;
                c36286b.zuj.setLayoutParams(layoutParams);
            }
        } else if (layoutParams.width != this.zrx) {
            layoutParams.width = this.zrx;
            c36286b.zuj.setLayoutParams(layoutParams);
        }
        c36286b.zuj.setText(c15870a.zrH);
        if (c15870a.zrN) {
            c36286b.yEf.setVisibility(0);
        } else {
            c36286b.yEf.setVisibility(8);
        }
        C40460b.m69434b(c36286b.ejo, str);
        c36286b.zul.setVisibility(4);
        c36286b.yEh.setVisibility(4);
        if (c15870a.zrQ && c15870a.zrK != 0) {
            i2 = c7617ak.field_unReadCount;
            if (c15870a.zrN) {
                View view2 = c36286b.yEh;
                if (i2 > 0) {
                    i2 = 0;
                } else {
                    i2 = 4;
                }
                view2.setVisibility(i2);
            } else if (i2 > 99) {
                c36286b.zul.setText("");
                c36286b.zul.setBackgroundResource(C1318a.badge_count_more);
                c36286b.zul.setVisibility(0);
            } else if (i2 > 0) {
                c36286b.zul.setText(String.valueOf(i2));
                c36286b.zul.setBackgroundResource(C44385r.m80243ik(this.context));
                c36286b.zul.setVisibility(0);
            }
        }
        if (!c15870a.yDZ || c7617ak.field_conversationTime == -1) {
            inflate.findViewById(2131823147).setBackgroundResource(C25738R.drawable.f6623k5);
        } else {
            inflate.findViewById(2131823147).setBackgroundResource(C25738R.drawable.f6622k4);
        }
        C5215a.yqY.mo10714a(inflate, String.valueOf(c15870a.nickName), c7617ak.field_unReadCount, String.valueOf(c15870a.zrH), String.valueOf(c15870a.zrI));
        AppMethodBeat.m2505o(34404);
        return inflate;
    }

    private static String aqV(String str) {
        AppMethodBeat.m2504i(34407);
        if (str == null || str.length() != 32) {
            AppMethodBeat.m2505o(34407);
            return null;
        }
        String Jh = ((C6835d) C1720g.m3530M(C6835d.class)).getEmojiMgr().mo35600Jh(str);
        AppMethodBeat.m2505o(34407);
        return Jh;
    }

    private void dIq() {
        AppMethodBeat.m2504i(34409);
        if (this.yDY == null) {
            AppMethodBeat.m2505o(34409);
            return;
        }
        for (Entry value : this.yDY.entrySet()) {
            ((C15870a) value.getValue()).zrH = null;
        }
        AppMethodBeat.m2505o(34409);
    }

    /* renamed from: a */
    public final void mo10136a(int i, C7298n c7298n, Object obj) {
        AppMethodBeat.m2504i(34410);
        if (obj == null || !(obj instanceof String)) {
            C4990ab.m7413e("MicroMsg.EnterpriseConversationAdapter", "onNotifyChange obj not String event:%d stg:%s obj:%s", Integer.valueOf(i), c7298n, obj);
            AppMethodBeat.m2505o(34410);
            return;
        }
        mo5248a((String) obj, null);
        AppMethodBeat.m2505o(34410);
    }

    /* renamed from: a */
    public final void mo5248a(String str, C4935m c4935m) {
        AppMethodBeat.m2504i(34411);
        C4990ab.m7417i("MicroMsg.EnterpriseConversationAdapter", "dkpno onNotifyChange mIsFront:%b mChangedBackground:%b event:%s", Boolean.valueOf(this.lhi), Boolean.valueOf(this.zrp), str);
        if (!(C42252ah.isNullOrNil(str) || this.yDY == null)) {
            this.yDY.remove(str);
        }
        if (this.lhi) {
            dIr();
            AppMethodBeat.m2505o(34411);
            return;
        }
        this.zrp = true;
        AppMethodBeat.m2505o(34411);
    }

    private void dIr() {
        AppMethodBeat.m2504i(34412);
        C4990ab.m7411d("MicroMsg.EnterpriseConversationAdapter", "dkpno postTryNotify needNotify:%b timerStopped:%b", Boolean.valueOf(this.zrB), Boolean.valueOf(this.zrC.doT()));
        this.zrB = true;
        if (this.zrC.doT()) {
            dIs();
        }
        AppMethodBeat.m2505o(34412);
    }

    private void dIs() {
        AppMethodBeat.m2504i(34413);
        C5004al.m7441d(new C362892());
        AppMethodBeat.m2505o(34413);
    }

    /* renamed from: k */
    private static int m59736k(C7617ak c7617ak) {
        int i = 1;
        AppMethodBeat.m2504i(34405);
        String str = c7617ak.field_msgType;
        if (str != null && str.length() > 0) {
            try {
                i = Integer.valueOf(str).intValue();
            } catch (NumberFormatException e) {
            }
        }
        AppMethodBeat.m2505o(34405);
        return i;
    }

    /* renamed from: c */
    private CharSequence m59732c(C7617ak c7617ak, int i, boolean z) {
        AppMethodBeat.m2504i(34406);
        if (C42252ah.isNullOrNil(c7617ak.field_editingMsg) || (c7617ak.field_atCount > 0 && c7617ak.field_unReadCount > 0)) {
            CharSequence charSequence = c7617ak.field_digest;
            CharSequence charSequence2;
            if (charSequence == null || !charSequence.startsWith("<img src=\"original_label.png\"/>  ")) {
                String str;
                if (C36287i.m59736k(c7617ak) == 47 || C36287i.m59736k(c7617ak) == 1048625) {
                    String aqV = C36287i.aqV(c7617ak.field_digest);
                    str = "";
                    if (aqV != null) {
                        charSequence2 = "[" + aqV + "]";
                        AppMethodBeat.m2505o(34406);
                        return charSequence2;
                    }
                    if (c7617ak.field_digest != null && c7617ak.field_digest.contains(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D)) {
                        str = c7617ak.field_digest.substring(0, c7617ak.field_digest.indexOf(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D));
                        aqV = C36287i.aqV(c7617ak.field_digest.substring(c7617ak.field_digest.indexOf(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D) + 1).replace(" ", ""));
                        if (aqV != null) {
                            aqV = "[" + aqV + "]";
                            if (C42252ah.isNullOrNil(str)) {
                                AppMethodBeat.m2505o(34406);
                                return aqV;
                            }
                            charSequence2 = str + ": " + aqV;
                            AppMethodBeat.m2505o(34406);
                            return charSequence2;
                        }
                    }
                    aqV = this.context.getString(C25738R.string.f9100ph);
                    if (C42252ah.isNullOrNil(str)) {
                        str = aqV;
                    } else {
                        str = str + ": " + aqV;
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
                    charSequence2 = str.replace(10, ' ');
                    if (c7617ak.field_atCount > 0 || c7617ak.field_unReadCount <= 0) {
                        if (z && c7617ak.field_unReadCount > 1) {
                            charSequence2 = this.context.getString(C25738R.string.cvg, new Object[]{Integer.valueOf(c7617ak.field_unReadCount), charSequence2});
                        }
                        charSequence2 = C44089j.m79294b(this.context, charSequence2, i);
                        AppMethodBeat.m2505o(34406);
                        return charSequence2;
                    }
                    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.context.getString(C25738R.string.cvd));
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(-5569532), 0, spannableStringBuilder.length(), 33);
                    spannableStringBuilder.append(" ").append(C44089j.m79294b(this.context, charSequence2, i));
                    AppMethodBeat.m2505o(34406);
                    return spannableStringBuilder;
                }
                str = C37622h.m63519a(c7617ak.field_isSend, c7617ak.field_username, c7617ak.field_content, C36287i.m59736k(c7617ak), this.context);
                charSequence2 = str.replace(10, ' ');
                if (c7617ak.field_atCount > 0) {
                }
                charSequence2 = this.context.getString(C25738R.string.cvg, new Object[]{Integer.valueOf(c7617ak.field_unReadCount), charSequence2});
                charSequence2 = C44089j.m79294b(this.context, charSequence2, i);
                AppMethodBeat.m2505o(34406);
                return charSequence2;
            }
            charSequence2 = new SpannableString(C44089j.m79303e(this.context, charSequence, (float) i));
            AppMethodBeat.m2505o(34406);
            return charSequence2;
        }
        SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(this.context.getString(C25738R.string.cvh));
        spannableStringBuilder2.setSpan(new ForegroundColorSpan(-5569532), 0, spannableStringBuilder2.length(), 33);
        spannableStringBuilder2.append(" ").append(C44089j.m79294b(this.context, c7617ak.field_editingMsg, i));
        AppMethodBeat.m2505o(34406);
        return spannableStringBuilder2;
    }

    /* renamed from: h */
    private CharSequence m59735h(C7617ak c7617ak) {
        AppMethodBeat.m2504i(34408);
        CharSequence charSequence;
        if (c7617ak.field_status == 1) {
            String string = this.context.getString(C25738R.string.cw8);
            AppMethodBeat.m2505o(34408);
            return string;
        } else if (c7617ak.field_conversationTime == Long.MAX_VALUE) {
            charSequence = "";
            AppMethodBeat.m2505o(34408);
            return charSequence;
        } else {
            charSequence = C14835h.m23089c(this.context, c7617ak.field_conversationTime, true);
            AppMethodBeat.m2505o(34408);
            return charSequence;
        }
    }
}
