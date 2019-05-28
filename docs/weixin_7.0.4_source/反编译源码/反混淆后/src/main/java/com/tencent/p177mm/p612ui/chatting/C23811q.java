package com.tencent.p177mm.p612ui.chatting;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Looper;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnHoverListener;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.p230g.p231a.C26250ui;
import com.tencent.p177mm.p612ui.base.C46633o;
import com.tencent.p177mm.p612ui.chatting.C30458ai.C15576a;
import com.tencent.p177mm.p612ui.chatting.C30458ai.C15577b;
import com.tencent.p177mm.p612ui.chatting.viewitems.C40814ay;
import com.tencent.p177mm.platformtools.C42252ah;
import com.tencent.p177mm.plugin.appbrand.jsapi.p306g.C19395n;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C7564ap;
import com.tencent.p177mm.sdk.platformtools.C7564ap.C5015a;

/* renamed from: com.tencent.mm.ui.chatting.q */
public final class C23811q {
    public static C5362b yJv = new C5362b();

    /* renamed from: com.tencent.mm.ui.chatting.q$b */
    public static class C5362b implements OnClickListener, OnTouchListener, C15577b {
        /* renamed from: WL */
        private View f1304WL;
        private View auE;
        private C7564ap gyS;
        /* renamed from: hz */
        private int f1305hz;
        private int iJp;
        private int pnS;
        private int yJA;
        private int yJB;
        private boolean yJC;
        private C15710a yJD = new C15710a();
        private OnTouchListener yJE = new C53631();
        private int yJF = 300;
        private C5015a yJG = new C53642();
        private C46633o yJw;
        private View yJx;
        private View yJy;
        private int yJz;

        /* renamed from: com.tencent.mm.ui.chatting.q$b$1 */
        class C53631 implements OnTouchListener {
            C53631() {
            }

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.m2504i(30696);
                if (C5362b.this.yJD != null) {
                    C5362b.this.yJD.onTouch(C5362b.this.f1304WL, motionEvent);
                }
                AppMethodBeat.m2505o(30696);
                return false;
            }
        }

        /* renamed from: com.tencent.mm.ui.chatting.q$b$2 */
        class C53642 implements C5015a {
            C53642() {
            }

            /* renamed from: BI */
            public final boolean mo4499BI() {
                AppMethodBeat.m2504i(30697);
                if (!(C5362b.this.auE == null || C5362b.this.yJw == null)) {
                    C5362b.this.yJw.showAsDropDown(C5362b.this.auE, C5362b.this.yJA, C5362b.this.yJB);
                }
                AppMethodBeat.m2505o(30697);
                return false;
            }
        }

        public C5362b() {
            AppMethodBeat.m2504i(30698);
            AppMethodBeat.m2505o(30698);
        }

        /* renamed from: a */
        static /* synthetic */ void m8105a(C5362b c5362b) {
            AppMethodBeat.m2504i(30703);
            c5362b.dismiss();
            AppMethodBeat.m2505o(30703);
        }

        private void dismiss() {
            AppMethodBeat.m2504i(30699);
            if (this.yJw != null) {
                this.yJw.dismiss();
            }
            AppMethodBeat.m2505o(30699);
        }

        /* renamed from: f */
        public final boolean mo10987f(View view, MotionEvent motionEvent) {
            AppMethodBeat.m2504i(30700);
            Object tag = view.getTag();
            if (tag == null || !(tag instanceof C40814ay)) {
                C4990ab.m7416i("MicroMsg.ChattingItemAvatarOnHoverHelper", "The Tag of the View is not a instance of ItemDataTag or is null.");
                AppMethodBeat.m2505o(30700);
                return false;
            }
            boolean z;
            C40814ay c40814ay = (C40814ay) view.getTag();
            String str = c40814ay.userName;
            String Yz = C1853r.m3846Yz();
            if (C42252ah.isNullOrNil(Yz) || Yz.equals(str)) {
                C4990ab.m7418v("MicroMsg.ChattingItemAvatarOnHoverHelper", "Can't talk to self and self username can't be null.");
                z = false;
            } else {
                z = true;
            }
            if (z) {
                Context context = view.getContext();
                if (this.yJw == null) {
                    Resources resources = context.getResources();
                    this.yJz = (int) ((resources.getDimension(C25738R.dimen.f9723do) * 2.0f) + resources.getDimension(C25738R.dimen.f9969lt));
                    this.f1304WL = View.inflate(context, 2130969028, null);
                    this.yJx = this.f1304WL.findViewById(2131822449);
                    this.yJy = this.f1304WL.findViewById(2131822450);
                    this.yJy.setOnClickListener(this);
                    this.yJx.setOnClickListener(this);
                    this.yJy.setOnTouchListener(this.yJE);
                    this.yJx.setOnTouchListener(this.yJE);
                    this.yJw = new C46633o(this.f1304WL, -2, this.yJz, false);
                    this.yJw.setOutsideTouchable(true);
                    Rect rect = new Rect();
                    if (context instanceof Activity) {
                        ((Activity) context).getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                    }
                    this.iJp = rect.top;
                    DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
                    if (displayMetrics.widthPixels > displayMetrics.heightPixels) {
                        this.pnS = context.getResources().getDimensionPixelSize(C25738R.dimen.f9777fc);
                    } else {
                        this.pnS = context.getResources().getDimensionPixelSize(C25738R.dimen.f9778fd);
                    }
                    this.yJw.setBackgroundDrawable(new ColorDrawable(16777215));
                    this.f1305hz = 0;
                    this.gyS = new C7564ap(Looper.getMainLooper(), this.yJG, false);
                    C4990ab.m7416i("MicroMsg.ChattingItemAvatarOnHoverHelper", "Create a new PopupWindow.");
                }
                C46633o c46633o = this.yJw;
                switch (motionEvent.getAction()) {
                    case 9:
                        this.auE = view;
                        view.setOnTouchListener(this);
                        if (c46633o.isShowing()) {
                            c46633o.dismiss();
                        }
                        if (!this.yJC) {
                            this.yJy.setTag(c40814ay);
                            this.yJx.setTag(c40814ay);
                            this.yJy.setVisibility(0);
                            this.yJx.setVisibility(8);
                            int[] iArr = new int[2];
                            view.getLocationInWindow(iArr);
                            int i = iArr[1];
                            view.getWidth();
                            int height = view.getHeight();
                            this.yJB = this.f1305hz;
                            if (i > (this.iJp + this.pnS) + this.yJz) {
                                this.yJB = ((-height) - this.yJz) - this.f1305hz;
                            }
                            this.yJA = 0;
                            if (this.yJB >= 0) {
                                this.f1304WL.setBackgroundResource(C25738R.drawable.b15);
                            } else {
                                this.f1304WL.setBackgroundResource(C25738R.drawable.b16);
                            }
                            long j = (long) this.yJF;
                            this.gyS.mo16770ae(j, j);
                            break;
                        }
                        break;
                    case 10:
                        this.yJC = false;
                        this.auE = null;
                        break;
                }
                AppMethodBeat.m2505o(30700);
                return true;
            }
            AppMethodBeat.m2505o(30700);
            return false;
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            AppMethodBeat.m2504i(30701);
            switch (motionEvent.getAction()) {
                case 1:
                    this.yJC = true;
                    break;
                case 3:
                    break;
            }
            dismiss();
            AppMethodBeat.m2505o(30701);
            return false;
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(30702);
            C40814ay c40814ay = (C40814ay) view.getTag();
            if (view == this.yJy) {
                C23811q.m36643w(view.getContext(), c40814ay.userName, 3);
            } else {
                C23811q.m36643w(view.getContext(), c40814ay.userName, 2);
            }
            dismiss();
            AppMethodBeat.m2505o(30702);
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.q$a */
    public static class C15710a implements OnTouchListener {
        private int mColor;

        public C15710a() {
            this(Color.argb(255, C19395n.CTRL_INDEX, C19395n.CTRL_INDEX, C19395n.CTRL_INDEX));
            AppMethodBeat.m2504i(30694);
            AppMethodBeat.m2505o(30694);
        }

        private C15710a(int i) {
            this.mColor = i;
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            Drawable drawable;
            AppMethodBeat.m2504i(30695);
            int action = motionEvent.getAction();
            if (view instanceof ImageView) {
                drawable = ((ImageView) view).getDrawable();
            } else {
                drawable = view.getBackground();
            }
            if (drawable != null) {
                if (action == 0) {
                    drawable.setColorFilter(this.mColor, Mode.MULTIPLY);
                } else if (action == 3 || action == 1) {
                    drawable.clearColorFilter();
                }
            }
            AppMethodBeat.m2505o(30695);
            return false;
        }
    }

    static {
        AppMethodBeat.m2504i(30707);
        AppMethodBeat.m2505o(30707);
    }

    /* renamed from: eJ */
    public static void m36642eJ(View view) {
        AppMethodBeat.m2504i(30704);
        C5362b c5362b = yJv;
        if (view == null || c5362b == null) {
            C4990ab.m7420w("MicroMsg.OnHoverCompatibleHelper", "view or callback is null.");
            AppMethodBeat.m2505o(30704);
            return;
        }
        if (VERSION.SDK_INT >= 14) {
            C30458ai dCK = C30458ai.dCK();
            if (VERSION.SDK_INT >= 14 && dCK.yLS == null) {
                dCK.yLS = new C15576a(c5362b);
            }
            Object obj = dCK.yLS;
            if (obj != null && VERSION.SDK_INT >= 14 && (obj instanceof OnHoverListener)) {
                view.setOnHoverListener((OnHoverListener) obj);
            }
        }
        AppMethodBeat.m2505o(30704);
    }

    public static void dismiss() {
        AppMethodBeat.m2504i(30705);
        try {
            if (yJv != null) {
                C5362b.m8105a(yJv);
            }
            AppMethodBeat.m2505o(30705);
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.ChattingItemAvatarOnHoverHelper", "exception in dismiss, %s", e.getMessage());
            AppMethodBeat.m2505o(30705);
        }
    }

    /* renamed from: w */
    static /* synthetic */ void m36643w(Context context, String str, int i) {
        AppMethodBeat.m2504i(30706);
        C26250ui c26250ui = new C26250ui();
        c26250ui.cQx.cAd = 5;
        c26250ui.cQx.talker = str;
        c26250ui.cQx.context = context;
        c26250ui.cQx.cQs = i;
        C4879a.xxA.mo10055m(c26250ui);
        C7060h.pYm.mo8381e(11033, Integer.valueOf(4), Integer.valueOf(1), Integer.valueOf(0));
        AppMethodBeat.m2505o(30706);
    }
}
