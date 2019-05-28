package com.tencent.p177mm.p612ui.widget.snackbar;

import android.app.Activity;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.view.WindowManager.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p612ui.C5227ai;
import com.tencent.p177mm.p612ui.C5230ak;
import com.tencent.p177mm.p612ui.widget.snackbar.SnackContainer.C44405a;

/* renamed from: com.tencent.mm.ui.widget.snackbar.a */
public final class C24110a {
    Handler mHandler = new Handler();
    View mParentView;
    SnackContainer zTN;
    C24109b zTO;
    C24112c zTP;
    private final OnClickListener zTQ = new C241151();

    /* renamed from: com.tencent.mm.ui.widget.snackbar.a$b */
    public interface C24109b {
        void aIu();
    }

    /* renamed from: com.tencent.mm.ui.widget.snackbar.a$a */
    public static class C24111a {
        /* renamed from: MW */
        private int f4441MW = -1;
        private Context mContext;
        String nqb;
        String zTI;
        private int zTJ = 0;
        private Parcelable zTK;
        private short zTL = (short) 3500;
        private C24110a zTU;
        private int zTV = 0;

        public C24111a(Activity activity) {
            AppMethodBeat.m2504i(112976);
            this.mContext = activity.getApplicationContext();
            this.zTU = new C24110a(activity, this.zTV);
            AppMethodBeat.m2505o(112976);
        }

        public C24111a(Context context, View view) {
            AppMethodBeat.m2504i(112977);
            this.mContext = context;
            this.zTU = new C24110a(context, view, this.zTV);
            AppMethodBeat.m2505o(112977);
        }

        /* renamed from: a */
        public final C24111a mo39917a(Short sh) {
            AppMethodBeat.m2504i(112978);
            this.zTL = sh.shortValue();
            AppMethodBeat.m2505o(112978);
            return this;
        }

        /* renamed from: a */
        public final C24111a mo39915a(C24109b c24109b) {
            this.zTU.zTO = c24109b;
            return this;
        }

        /* renamed from: a */
        public final C24111a mo39916a(C24112c c24112c) {
            this.zTU.zTP = c24112c;
            return this;
        }

        public final C24110a dLw() {
            int i;
            AppMethodBeat.m2504i(112979);
            String str = this.nqb;
            String toUpperCase = this.zTI != null ? this.zTI.toUpperCase() : null;
            int i2 = this.zTJ;
            Parcelable parcelable = this.zTK;
            short s = this.zTL;
            if (this.f4441MW != -1) {
                i = this.f4441MW;
            } else {
                i = this.mContext.getResources().getColor(C25738R.color.a61);
            }
            Snack snack = new Snack(str, toUpperCase, i2, parcelable, s, i);
            C24110a c24110a = this.zTU;
            if (c24110a.zTN != null) {
                ViewParent viewParent = c24110a.zTN;
                View view = c24110a.mParentView;
                C24112c c24112c = c24110a.zTP;
                if (!(view.getParent() == null || view.getParent() == viewParent)) {
                    ((ViewGroup) view.getParent()).removeView(view);
                }
                C44405a c44405a = new C44405a(snack, view, c24112c, (byte) 0);
                viewParent.zTX.offer(c44405a);
                if (viewParent.zTX.size() == 1) {
                    viewParent.mo70282a(c44405a);
                }
            }
            C24110a c24110a2 = this.zTU;
            AppMethodBeat.m2505o(112979);
            return c24110a2;
        }
    }

    /* renamed from: com.tencent.mm.ui.widget.snackbar.a$c */
    public interface C24112c {
        void cLd();

        void onHide();

        void onShow();
    }

    /* renamed from: com.tencent.mm.ui.widget.snackbar.a$2 */
    class C241132 implements OnTouchListener {

        /* renamed from: com.tencent.mm.ui.widget.snackbar.a$2$1 */
        class C241141 implements Runnable {
            C241141() {
            }

            public final void run() {
                AppMethodBeat.m2504i(112974);
                C24110a.this.zTN.hide();
                AppMethodBeat.m2505o(112974);
            }
        }

        C241132() {
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            AppMethodBeat.m2504i(112975);
            if (C5670b.aFF() && C24110a.this.zTN.isShowing()) {
                C5670b.m8524rf(false);
                C24110a.this.mHandler.postDelayed(new C241141(), 100);
            }
            AppMethodBeat.m2505o(112975);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.ui.widget.snackbar.a$1 */
    class C241151 implements OnClickListener {

        /* renamed from: com.tencent.mm.ui.widget.snackbar.a$1$1 */
        class C160161 implements Runnable {
            C160161() {
            }

            public final void run() {
                AppMethodBeat.m2504i(112972);
                C24110a.this.zTN.hide();
                AppMethodBeat.m2505o(112972);
            }
        }

        C241151() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(112973);
            if (C24110a.this.zTO != null && C24110a.this.zTN.isShowing()) {
                C24110a.this.zTO.aIu();
            }
            C24110a.this.mHandler.postDelayed(new C160161(), 100);
            AppMethodBeat.m2505o(112973);
        }
    }

    public C24110a(Activity activity, int i) {
        AppMethodBeat.m2504i(112980);
        View findViewById = activity.findViewById(16908290);
        LayoutInflater layoutInflater = (LayoutInflater) activity.getSystemService("layout_inflater");
        layoutInflater.inflate(2130970709, (ViewGroup) findViewById);
        m37079a((ViewGroup) findViewById, layoutInflater.inflate(2130970710, (ViewGroup) findViewById, false), i, activity);
        AppMethodBeat.m2505o(112980);
    }

    public C24110a(Context context, View view, int i) {
        View findViewById;
        AppMethodBeat.m2504i(112981);
        if (view == null && (context instanceof Activity)) {
            findViewById = ((Activity) context).findViewById(16908290);
        } else {
            findViewById = view;
        }
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService("layout_inflater");
        layoutInflater.inflate(2130970709, (ViewGroup) findViewById);
        m37079a((ViewGroup) findViewById, layoutInflater.inflate(2130970710, (ViewGroup) findViewById, false), i, context);
        AppMethodBeat.m2505o(112981);
    }

    /* renamed from: a */
    private void m37079a(ViewGroup viewGroup, View view, int i, Context context) {
        AppMethodBeat.m2504i(112982);
        if (viewGroup == null) {
            AppMethodBeat.m2505o(112982);
            return;
        }
        this.zTN = (SnackContainer) viewGroup.findViewById(2131827595);
        if (this.zTN == null) {
            this.zTN = new SnackContainer(viewGroup);
        }
        this.mParentView = view;
        if (i == 36) {
            this.zTN.setOnTouchListener(new C241132());
        }
        ((TextView) view.findViewById(2131827598)).setOnClickListener(this.zTQ);
        C5227ai.m7973i("MicroMsg.SnackBar", "snackbar:isNavBarVisibility : %B,navBarHeightd:%d", Boolean.valueOf(C5230ak.m7991hw(context)), Integer.valueOf(C5230ak.m7988fr(context)));
        C5227ai.m7973i("MicroMsg.SnackBar", "snackbar:isNavBarTranslucent : %B", Boolean.valueOf(C24110a.m37080aA((Activity) context)));
        if (C24110a.m37080aA((Activity) context) && r0) {
            LinearLayout linearLayout = (LinearLayout) view.findViewById(2131827596);
            MarginLayoutParams marginLayoutParams = (MarginLayoutParams) linearLayout.getLayoutParams();
            marginLayoutParams.bottomMargin = r2;
            linearLayout.setLayoutParams(marginLayoutParams);
        }
        AppMethodBeat.m2505o(112982);
    }

    /* renamed from: aA */
    private static boolean m37080aA(Activity activity) {
        AppMethodBeat.m2504i(112983);
        if (VERSION.SDK_INT >= 19) {
            LayoutParams attributes = activity.getWindow().getAttributes();
            if (attributes.flags == ((attributes.flags & -134217729) | 134217728)) {
                AppMethodBeat.m2505o(112983);
                return true;
            }
        }
        AppMethodBeat.m2505o(112983);
        return false;
    }
}
