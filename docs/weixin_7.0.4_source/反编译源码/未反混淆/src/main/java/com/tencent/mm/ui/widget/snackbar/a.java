package com.tencent.mm.ui.widget.snackbar;

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
import com.tencent.mm.R;
import com.tencent.mm.ui.ai;
import com.tencent.mm.ui.ak;

public final class a {
    Handler mHandler = new Handler();
    View mParentView;
    SnackContainer zTN;
    b zTO;
    c zTP;
    private final OnClickListener zTQ = new OnClickListener() {
        public final void onClick(View view) {
            AppMethodBeat.i(112973);
            if (a.this.zTO != null && a.this.zTN.isShowing()) {
                a.this.zTO.aIu();
            }
            a.this.mHandler.postDelayed(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(112972);
                    a.this.zTN.hide();
                    AppMethodBeat.o(112972);
                }
            }, 100);
            AppMethodBeat.o(112973);
        }
    };

    public interface b {
        void aIu();
    }

    public static class a {
        private int MW = -1;
        private Context mContext;
        String nqb;
        String zTI;
        private int zTJ = 0;
        private Parcelable zTK;
        private short zTL = (short) 3500;
        private a zTU;
        private int zTV = 0;

        public a(Activity activity) {
            AppMethodBeat.i(112976);
            this.mContext = activity.getApplicationContext();
            this.zTU = new a(activity, this.zTV);
            AppMethodBeat.o(112976);
        }

        public a(Context context, View view) {
            AppMethodBeat.i(112977);
            this.mContext = context;
            this.zTU = new a(context, view, this.zTV);
            AppMethodBeat.o(112977);
        }

        public final a a(Short sh) {
            AppMethodBeat.i(112978);
            this.zTL = sh.shortValue();
            AppMethodBeat.o(112978);
            return this;
        }

        public final a a(b bVar) {
            this.zTU.zTO = bVar;
            return this;
        }

        public final a a(c cVar) {
            this.zTU.zTP = cVar;
            return this;
        }

        public final a dLw() {
            int i;
            AppMethodBeat.i(112979);
            String str = this.nqb;
            String toUpperCase = this.zTI != null ? this.zTI.toUpperCase() : null;
            int i2 = this.zTJ;
            Parcelable parcelable = this.zTK;
            short s = this.zTL;
            if (this.MW != -1) {
                i = this.MW;
            } else {
                i = this.mContext.getResources().getColor(R.color.a61);
            }
            Snack snack = new Snack(str, toUpperCase, i2, parcelable, s, i);
            a aVar = this.zTU;
            if (aVar.zTN != null) {
                ViewParent viewParent = aVar.zTN;
                View view = aVar.mParentView;
                c cVar = aVar.zTP;
                if (!(view.getParent() == null || view.getParent() == viewParent)) {
                    ((ViewGroup) view.getParent()).removeView(view);
                }
                a aVar2 = new a(snack, view, cVar, (byte) 0);
                viewParent.zTX.offer(aVar2);
                if (viewParent.zTX.size() == 1) {
                    viewParent.a(aVar2);
                }
            }
            a aVar3 = this.zTU;
            AppMethodBeat.o(112979);
            return aVar3;
        }
    }

    public interface c {
        void cLd();

        void onHide();

        void onShow();
    }

    public a(Activity activity, int i) {
        AppMethodBeat.i(112980);
        View findViewById = activity.findViewById(16908290);
        LayoutInflater layoutInflater = (LayoutInflater) activity.getSystemService("layout_inflater");
        layoutInflater.inflate(R.layout.att, (ViewGroup) findViewById);
        a((ViewGroup) findViewById, layoutInflater.inflate(R.layout.atu, (ViewGroup) findViewById, false), i, activity);
        AppMethodBeat.o(112980);
    }

    public a(Context context, View view, int i) {
        View findViewById;
        AppMethodBeat.i(112981);
        if (view == null && (context instanceof Activity)) {
            findViewById = ((Activity) context).findViewById(16908290);
        } else {
            findViewById = view;
        }
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService("layout_inflater");
        layoutInflater.inflate(R.layout.att, (ViewGroup) findViewById);
        a((ViewGroup) findViewById, layoutInflater.inflate(R.layout.atu, (ViewGroup) findViewById, false), i, context);
        AppMethodBeat.o(112981);
    }

    private void a(ViewGroup viewGroup, View view, int i, Context context) {
        AppMethodBeat.i(112982);
        if (viewGroup == null) {
            AppMethodBeat.o(112982);
            return;
        }
        this.zTN = (SnackContainer) viewGroup.findViewById(R.id.eel);
        if (this.zTN == null) {
            this.zTN = new SnackContainer(viewGroup);
        }
        this.mParentView = view;
        if (i == 36) {
            this.zTN.setOnTouchListener(new OnTouchListener() {
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    AppMethodBeat.i(112975);
                    if (b.aFF() && a.this.zTN.isShowing()) {
                        b.rf(false);
                        a.this.mHandler.postDelayed(new Runnable() {
                            public final void run() {
                                AppMethodBeat.i(112974);
                                a.this.zTN.hide();
                                AppMethodBeat.o(112974);
                            }
                        }, 100);
                    }
                    AppMethodBeat.o(112975);
                    return true;
                }
            });
        }
        ((TextView) view.findViewById(R.id.eeo)).setOnClickListener(this.zTQ);
        ai.i("MicroMsg.SnackBar", "snackbar:isNavBarVisibility : %B,navBarHeightd:%d", Boolean.valueOf(ak.hw(context)), Integer.valueOf(ak.fr(context)));
        ai.i("MicroMsg.SnackBar", "snackbar:isNavBarTranslucent : %B", Boolean.valueOf(aA((Activity) context)));
        if (aA((Activity) context) && r0) {
            LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.eem);
            MarginLayoutParams marginLayoutParams = (MarginLayoutParams) linearLayout.getLayoutParams();
            marginLayoutParams.bottomMargin = r2;
            linearLayout.setLayoutParams(marginLayoutParams);
        }
        AppMethodBeat.o(112982);
    }

    private static boolean aA(Activity activity) {
        AppMethodBeat.i(112983);
        if (VERSION.SDK_INT >= 19) {
            LayoutParams attributes = activity.getWindow().getAttributes();
            if (attributes.flags == ((attributes.flags & -134217729) | 134217728)) {
                AppMethodBeat.o(112983);
                return true;
            }
        }
        AppMethodBeat.o(112983);
        return false;
    }
}
