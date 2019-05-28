package com.tencent.p177mm.p612ui.base;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.sdk.platformtools.BackwardSupportUtil.C4976a;

/* renamed from: com.tencent.mm.ui.base.TalkRoomPopupNav */
public class TalkRoomPopupNav extends LinearLayout {
    public View miL;
    private C36068a yAE;
    public LinearLayout yAF;
    private LinearLayout yAG;
    private ImageView yAH;
    private ImageView yAI;
    public ScaleAnimation yAJ;
    public Animation yAK;
    public int yAL = 0;
    public int yAM = 0;
    private ScaleAnimation yAN;
    private Animation yAO;
    private AlphaAnimation yAP;
    private AlphaAnimation yAQ;
    public LinearLayout yoK;

    /* renamed from: com.tencent.mm.ui.base.TalkRoomPopupNav$5 */
    public class C52695 implements AnimationListener {
        public final void onAnimationStart(Animation animation) {
        }

        public final void onAnimationRepeat(Animation animation) {
        }

        public final void onAnimationEnd(Animation animation) {
            AppMethodBeat.m2504i(30010);
            TalkRoomPopupNav.this.yoK.setVisibility(8);
            TalkRoomPopupNav.this.yoK.setClickable(false);
            AppMethodBeat.m2505o(30010);
        }
    }

    /* renamed from: com.tencent.mm.ui.base.TalkRoomPopupNav$4 */
    public class C155274 implements AnimationListener {
        public final void onAnimationStart(Animation animation) {
        }

        public final void onAnimationRepeat(Animation animation) {
        }

        public final void onAnimationEnd(Animation animation) {
            AppMethodBeat.m2504i(30009);
            TalkRoomPopupNav.this.yAG.startAnimation(AnimationUtils.loadAnimation(TalkRoomPopupNav.this.getContext(), C25738R.anim.f8332b5));
            TalkRoomPopupNav.this.yAG.setVisibility(0);
            AppMethodBeat.m2505o(30009);
        }
    }

    /* renamed from: com.tencent.mm.ui.base.TalkRoomPopupNav$2 */
    class C236242 implements OnClickListener {
        C236242() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(30007);
            TalkRoomPopupNav.m59362b(TalkRoomPopupNav.this);
            AppMethodBeat.m2505o(30007);
        }
    }

    /* renamed from: com.tencent.mm.ui.base.TalkRoomPopupNav$3 */
    class C360643 implements OnClickListener {
        C360643() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(30008);
            TalkRoomPopupNav.m59362b(TalkRoomPopupNav.this);
            if (TalkRoomPopupNav.this.yAE != null) {
                TalkRoomPopupNav.this.yAE.dAu();
            }
            AppMethodBeat.m2505o(30008);
        }
    }

    /* renamed from: com.tencent.mm.ui.base.TalkRoomPopupNav$6 */
    class C360656 implements AnimationListener {
        C360656() {
        }

        public final void onAnimationStart(Animation animation) {
            AppMethodBeat.m2504i(30011);
            TalkRoomPopupNav.this.yAG.setVisibility(4);
            AppMethodBeat.m2505o(30011);
        }

        public final void onAnimationRepeat(Animation animation) {
        }

        public final void onAnimationEnd(Animation animation) {
            AppMethodBeat.m2504i(30012);
            TalkRoomPopupNav.this.yAF.setVisibility(8);
            TalkRoomPopupNav.this.yoK.setClickable(true);
            AppMethodBeat.m2505o(30012);
        }
    }

    /* renamed from: com.tencent.mm.ui.base.TalkRoomPopupNav$8 */
    class C360668 implements AnimationListener {
        C360668() {
        }

        public final void onAnimationStart(Animation animation) {
        }

        public final void onAnimationRepeat(Animation animation) {
        }

        public final void onAnimationEnd(Animation animation) {
            AppMethodBeat.m2504i(30014);
            if (TalkRoomPopupNav.this.yAQ != null) {
                TalkRoomPopupNav.this.yAI.startAnimation(TalkRoomPopupNav.this.yAQ);
            }
            AppMethodBeat.m2505o(30014);
        }
    }

    /* renamed from: com.tencent.mm.ui.base.TalkRoomPopupNav$9 */
    class C360679 implements AnimationListener {
        C360679() {
        }

        public final void onAnimationStart(Animation animation) {
        }

        public final void onAnimationRepeat(Animation animation) {
        }

        public final void onAnimationEnd(Animation animation) {
            AppMethodBeat.m2504i(30015);
            if (TalkRoomPopupNav.this.yAP != null) {
                TalkRoomPopupNav.this.yAI.startAnimation(TalkRoomPopupNav.this.yAP);
            }
            AppMethodBeat.m2505o(30015);
        }
    }

    /* renamed from: com.tencent.mm.ui.base.TalkRoomPopupNav$a */
    public interface C36068a {
        void dAt();

        void dAu();
    }

    /* renamed from: com.tencent.mm.ui.base.TalkRoomPopupNav$7 */
    class C360697 implements AnimationListener {
        C360697() {
        }

        public final void onAnimationStart(Animation animation) {
        }

        public final void onAnimationRepeat(Animation animation) {
        }

        public final void onAnimationEnd(Animation animation) {
            AppMethodBeat.m2504i(30013);
            TalkRoomPopupNav.this.yAG.setVisibility(4);
            TalkRoomPopupNav.this.yAF.setVisibility(4);
            AppMethodBeat.m2505o(30013);
        }
    }

    /* renamed from: com.tencent.mm.ui.base.TalkRoomPopupNav$1 */
    class C360701 implements OnClickListener {
        C360701() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(30006);
            if (TalkRoomPopupNav.this.yAE != null) {
                TalkRoomPopupNav.this.yAE.dAt();
            }
            AppMethodBeat.m2505o(30006);
        }
    }

    @TargetApi(11)
    public TalkRoomPopupNav(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(30016);
        initView();
        AppMethodBeat.m2505o(30016);
    }

    public TalkRoomPopupNav(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(30017);
        initView();
        AppMethodBeat.m2505o(30017);
    }

    public void setOnClickListener(C36068a c36068a) {
        this.yAE = c36068a;
    }

    public void setNavContent(String str) {
        AppMethodBeat.m2504i(30018);
        ((TextView) findViewById(2131828222)).setText(str);
        AppMethodBeat.m2505o(30018);
    }

    public void setDialogContent(String str) {
        AppMethodBeat.m2504i(30019);
        ((TextView) findViewById(2131828224)).setText(str);
        AppMethodBeat.m2505o(30019);
    }

    public void setBgViewResource(int i) {
        AppMethodBeat.m2504i(30020);
        if (this.miL != null) {
            this.miL.setBackgroundResource(i);
        }
        AppMethodBeat.m2505o(30020);
    }

    public void setIconRes(int i) {
        AppMethodBeat.m2504i(30021);
        if (this.yAH != null) {
            this.yAH.setImageResource(i);
        }
        AppMethodBeat.m2505o(30021);
    }

    public void setIconAnim(int i) {
        AppMethodBeat.m2504i(30022);
        if (i < 0) {
            if (this.yAI != null) {
                this.yAI.setVisibility(8);
            }
            AppMethodBeat.m2505o(30022);
            return;
        }
        if (this.yAI != null) {
            this.yAI.setImageResource(i);
            this.yAI.setVisibility(0);
        }
        AppMethodBeat.m2505o(30022);
    }

    private void initView() {
        AppMethodBeat.m2504i(30023);
        TalkRoomPopupNav.inflate(getContext(), 2130970917, this);
        this.yoK = (LinearLayout) findViewById(2131828219);
        this.yAF = (LinearLayout) findViewById(2131828223);
        this.yAG = (LinearLayout) findViewById(2131828225);
        this.miL = findViewById(2131828218);
        this.yAH = (ImageView) findViewById(2131828220);
        this.yAI = (ImageView) findViewById(2131828221);
        this.yAI.setVisibility(8);
        this.yoK.setOnClickListener(new C360701());
        ((Button) findViewById(2131828226)).setOnClickListener(new C236242());
        ((Button) findViewById(2131828227)).setOnClickListener(new C360643());
        this.yAL = this.miL.getLayoutParams().height;
        this.yAM = this.yAF.getLayoutParams().height;
        AppMethodBeat.m2505o(30023);
    }

    public final void stop() {
        AppMethodBeat.m2504i(30025);
        if (!(this.yAP == null || this.yAQ == null)) {
            C4976a.m7369a(this.yAI, this.yAP);
            C4976a.m7369a(this.yAI, this.yAQ);
            this.yAI.clearAnimation();
            this.yAP = null;
            this.yAQ = null;
        }
        AppMethodBeat.m2505o(30025);
    }

    public final void start() {
        AppMethodBeat.m2504i(30024);
        if (this.yAP == null || this.yAQ == null) {
            this.yAP = new AlphaAnimation(0.0f, 1.0f);
            this.yAP.setDuration(1000);
            this.yAP.setStartOffset(0);
            this.yAQ = new AlphaAnimation(1.0f, 0.0f);
            this.yAQ.setDuration(1000);
            this.yAQ.setStartOffset(0);
            this.yAP.setAnimationListener(new C360668());
            this.yAQ.setAnimationListener(new C360679());
            this.yAI.startAnimation(this.yAP);
        }
        AppMethodBeat.m2505o(30024);
    }

    /* renamed from: b */
    static /* synthetic */ void m59362b(TalkRoomPopupNav talkRoomPopupNav) {
        AppMethodBeat.m2504i(30026);
        if (talkRoomPopupNav.yAN == null) {
            talkRoomPopupNav.yAN = new ScaleAnimation(1.0f, 1.0f, (((float) talkRoomPopupNav.yAM) * 1.0f) / ((float) talkRoomPopupNav.yAL), 1.0f);
            talkRoomPopupNav.yAN.setDuration(300);
            talkRoomPopupNav.yAN.setAnimationListener(new C360656());
        }
        if (talkRoomPopupNav.yAO == null) {
            talkRoomPopupNav.yAO = AnimationUtils.loadAnimation(talkRoomPopupNav.getContext(), C25738R.anim.f8333b6);
            talkRoomPopupNav.yAO.setFillAfter(true);
            talkRoomPopupNav.yAO.setAnimationListener(new C360697());
        }
        LayoutParams layoutParams = talkRoomPopupNav.miL.getLayoutParams();
        layoutParams.height = talkRoomPopupNav.yAL;
        talkRoomPopupNav.miL.setLayoutParams(layoutParams);
        talkRoomPopupNav.miL.startAnimation(talkRoomPopupNav.yAN);
        talkRoomPopupNav.yAF.startAnimation(talkRoomPopupNav.yAO);
        talkRoomPopupNav.yoK.startAnimation(AnimationUtils.loadAnimation(talkRoomPopupNav.getContext(), C25738R.anim.f8332b5));
        talkRoomPopupNav.yoK.setVisibility(0);
        AppMethodBeat.m2505o(30026);
    }
}
