package com.tencent.p177mm.p612ui.chatting.viewitems;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.style.CharacterStyle;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.neattextview.textview.view.NeatTextView.C5787b;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p612ui.widget.MMNeat7extView;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C23306f;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C30132m;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7620bi;
import com.tencent.view.C31128d;

/* renamed from: com.tencent.mm.ui.chatting.viewitems.ChattingItemTranslate */
public class ChattingItemTranslate extends RelativeLayout {
    private SpannableStringBuilder vji = new SpannableStringBuilder();
    private CharacterStyle vjl = new ForegroundColorSpan(-5066062);
    private int vjo = 3;
    private MMNeat7extView zgY;
    private LinearLayout zgZ;
    private ProgressBar zha;
    private TextView zhb;
    private C5787b zhc;
    private boolean zhd;
    private GestureDetector zhe = new GestureDetector(getContext(), new C53691());

    /* renamed from: com.tencent.mm.ui.chatting.viewitems.ChattingItemTranslate$1 */
    class C53691 extends SimpleOnGestureListener {
        C53691() {
        }

        public final boolean onDoubleTap(MotionEvent motionEvent) {
            AppMethodBeat.m2504i(33323);
            if (ChattingItemTranslate.this.zhc == null) {
                AppMethodBeat.m2505o(33323);
                return false;
            }
            boolean fi = ChattingItemTranslate.this.zhc.mo11868fi(ChattingItemTranslate.this.zgY);
            AppMethodBeat.m2505o(33323);
            return fi;
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.viewitems.ChattingItemTranslate$a */
    public static class C5370a extends C40814ay {
        public int klY = 1;

        public C5370a(C7620bi c7620bi, boolean z, int i) {
            super(c7620bi, z, i, null, 0);
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.viewitems.ChattingItemTranslate$b */
    public enum C5371b {
        NoTransform,
        PreTransform,
        Transforming,
        Transformed;

        static {
            AppMethodBeat.m2505o(33326);
        }
    }

    public ChattingItemTranslate(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(33327);
        AppMethodBeat.m2505o(33327);
    }

    public final void init() {
        AppMethodBeat.m2504i(33328);
        this.zgY = (MMNeat7extView) findViewById(2131822677);
        this.zha = (ProgressBar) findViewById(2131822676);
        this.zgZ = (LinearLayout) findViewById(2131822678);
        this.zhb = (TextView) findViewById(2131822680);
        this.zgY.setOnTouchListener(new C23306f(this.zgY, new C30132m(this.zgY.getContext())));
        AppMethodBeat.m2505o(33328);
    }

    /* renamed from: a */
    public final void mo10995a(CharSequence charSequence, C5371b c5371b) {
        AppMethodBeat.m2504i(33329);
        if (!C5046bo.m7519ac(charSequence)) {
            this.zgY.setMinWidth(C1338a.fromDPToPix(C4996ah.getContext(), 80));
            this.zgY.setMaxWidth(C1338a.fromDPToPix(C4996ah.getContext(), C31128d.MIC_PTU_ZIPAI_MEDSEA));
            this.zgY.setVisibility(0);
            if (c5371b == C5371b.Transforming) {
                this.vji.clear();
                this.zgY.mo15921ah(m8116a(this.vji, charSequence));
            } else {
                this.zgY.mo15921ah(charSequence);
            }
            this.zha.setVisibility(8);
            if (c5371b == C5371b.Transformed) {
                m8119qz(true);
            } else {
                m8119qz(false);
            }
        } else if (c5371b != C5371b.NoTransform) {
            this.zha.setVisibility(0);
            this.zgY.setVisibility(8);
            m8119qz(false);
        }
        setVisibility(0);
        AppMethodBeat.m2505o(33329);
    }

    public void setBrandWording(String str) {
        AppMethodBeat.m2504i(33330);
        this.zhb.setText(str);
        AppMethodBeat.m2505o(33330);
    }

    public void setOnDoubleClickListener(C5787b c5787b) {
        this.zhc = c5787b;
    }

    /* renamed from: qz */
    private void m8119qz(boolean z) {
        AppMethodBeat.m2504i(33331);
        Context context = C4996ah.getContext();
        if (context == null) {
            AppMethodBeat.m2505o(33331);
        } else if (z) {
            this.zgY.setPadding(C1338a.fromDPToPix(context, 10), C1338a.fromDPToPix(context, 8), C1338a.fromDPToPix(context, 10), C1338a.fromDPToPix(context, 4));
            this.zgZ.setVisibility(0);
            AppMethodBeat.m2505o(33331);
        } else {
            this.zgY.setPadding(C1338a.fromDPToPix(context, 10), C1338a.fromDPToPix(context, 8), C1338a.fromDPToPix(context, 10), C1338a.fromDPToPix(context, 8));
            this.zgZ.setVisibility(8);
            AppMethodBeat.m2505o(33331);
        }
    }

    /* renamed from: a */
    private SpannableStringBuilder m8116a(SpannableStringBuilder spannableStringBuilder, CharSequence charSequence) {
        AppMethodBeat.m2504i(33332);
        if (spannableStringBuilder == null || charSequence == null || charSequence.length() == 0) {
            AppMethodBeat.m2505o(33332);
        } else {
            int length;
            int i;
            if (charSequence.length() < this.vjo) {
                length = charSequence.length();
                i = 0;
            } else {
                length = charSequence.length();
                i = length - this.vjo;
            }
            spannableStringBuilder.append(charSequence).setSpan(this.vjl, i, length, 33);
            AppMethodBeat.m2505o(33332);
        }
        return spannableStringBuilder;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = true;
        AppMethodBeat.m2504i(33333);
        int action = motionEvent.getAction();
        boolean z2 = action == 1 && this.zhd;
        if (z2) {
            C4990ab.m7410d("MicroMsg.ChattingItemTranslate", "ignore Action Up Event this time");
            AppMethodBeat.m2505o(33333);
        } else {
            if (action == 0) {
                this.zhd = false;
            }
            if (this.zhc == null || this.zhe == null) {
                z = false;
            } else {
                z = this.zhe.onTouchEvent(motionEvent);
            }
            if (!z) {
                z = super.onTouchEvent(motionEvent);
            }
            AppMethodBeat.m2505o(33333);
        }
        return z;
    }
}
