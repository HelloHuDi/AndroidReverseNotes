package com.tencent.mm.ui.chatting;

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
import com.tencent.mm.R;
import com.tencent.mm.g.a.ui;
import com.tencent.mm.model.r;
import com.tencent.mm.platformtools.ah;
import com.tencent.mm.plugin.appbrand.jsapi.g.n;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.chatting.viewitems.ay;

public final class q {
    public static b yJv = new b();

    public static class b implements OnClickListener, OnTouchListener, com.tencent.mm.ui.chatting.ai.b {
        private View WL;
        private View auE;
        private ap gyS;
        private int hz;
        private int iJp;
        private int pnS;
        private int yJA;
        private int yJB;
        private boolean yJC;
        private a yJD = new a();
        private OnTouchListener yJE = new OnTouchListener() {
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(30696);
                if (b.this.yJD != null) {
                    b.this.yJD.onTouch(b.this.WL, motionEvent);
                }
                AppMethodBeat.o(30696);
                return false;
            }
        };
        private int yJF = 300;
        private com.tencent.mm.sdk.platformtools.ap.a yJG = new com.tencent.mm.sdk.platformtools.ap.a() {
            public final boolean BI() {
                AppMethodBeat.i(30697);
                if (!(b.this.auE == null || b.this.yJw == null)) {
                    b.this.yJw.showAsDropDown(b.this.auE, b.this.yJA, b.this.yJB);
                }
                AppMethodBeat.o(30697);
                return false;
            }
        };
        private o yJw;
        private View yJx;
        private View yJy;
        private int yJz;

        public b() {
            AppMethodBeat.i(30698);
            AppMethodBeat.o(30698);
        }

        static /* synthetic */ void a(b bVar) {
            AppMethodBeat.i(30703);
            bVar.dismiss();
            AppMethodBeat.o(30703);
        }

        private void dismiss() {
            AppMethodBeat.i(30699);
            if (this.yJw != null) {
                this.yJw.dismiss();
            }
            AppMethodBeat.o(30699);
        }

        public final boolean f(View view, MotionEvent motionEvent) {
            AppMethodBeat.i(30700);
            Object tag = view.getTag();
            if (tag == null || !(tag instanceof ay)) {
                ab.i("MicroMsg.ChattingItemAvatarOnHoverHelper", "The Tag of the View is not a instance of ItemDataTag or is null.");
                AppMethodBeat.o(30700);
                return false;
            }
            boolean z;
            ay ayVar = (ay) view.getTag();
            String str = ayVar.userName;
            String Yz = r.Yz();
            if (ah.isNullOrNil(Yz) || Yz.equals(str)) {
                ab.v("MicroMsg.ChattingItemAvatarOnHoverHelper", "Can't talk to self and self username can't be null.");
                z = false;
            } else {
                z = true;
            }
            if (z) {
                Context context = view.getContext();
                if (this.yJw == null) {
                    Resources resources = context.getResources();
                    this.yJz = (int) ((resources.getDimension(R.dimen.f15do) * 2.0f) + resources.getDimension(R.dimen.lt));
                    this.WL = View.inflate(context, R.layout.li, null);
                    this.yJx = this.WL.findViewById(R.id.ang);
                    this.yJy = this.WL.findViewById(R.id.anh);
                    this.yJy.setOnClickListener(this);
                    this.yJx.setOnClickListener(this);
                    this.yJy.setOnTouchListener(this.yJE);
                    this.yJx.setOnTouchListener(this.yJE);
                    this.yJw = new o(this.WL, -2, this.yJz, false);
                    this.yJw.setOutsideTouchable(true);
                    Rect rect = new Rect();
                    if (context instanceof Activity) {
                        ((Activity) context).getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                    }
                    this.iJp = rect.top;
                    DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
                    if (displayMetrics.widthPixels > displayMetrics.heightPixels) {
                        this.pnS = context.getResources().getDimensionPixelSize(R.dimen.fc);
                    } else {
                        this.pnS = context.getResources().getDimensionPixelSize(R.dimen.fd);
                    }
                    this.yJw.setBackgroundDrawable(new ColorDrawable(16777215));
                    this.hz = 0;
                    this.gyS = new ap(Looper.getMainLooper(), this.yJG, false);
                    ab.i("MicroMsg.ChattingItemAvatarOnHoverHelper", "Create a new PopupWindow.");
                }
                o oVar = this.yJw;
                switch (motionEvent.getAction()) {
                    case 9:
                        this.auE = view;
                        view.setOnTouchListener(this);
                        if (oVar.isShowing()) {
                            oVar.dismiss();
                        }
                        if (!this.yJC) {
                            this.yJy.setTag(ayVar);
                            this.yJx.setTag(ayVar);
                            this.yJy.setVisibility(0);
                            this.yJx.setVisibility(8);
                            int[] iArr = new int[2];
                            view.getLocationInWindow(iArr);
                            int i = iArr[1];
                            view.getWidth();
                            int height = view.getHeight();
                            this.yJB = this.hz;
                            if (i > (this.iJp + this.pnS) + this.yJz) {
                                this.yJB = ((-height) - this.yJz) - this.hz;
                            }
                            this.yJA = 0;
                            if (this.yJB >= 0) {
                                this.WL.setBackgroundResource(R.drawable.b15);
                            } else {
                                this.WL.setBackgroundResource(R.drawable.b16);
                            }
                            long j = (long) this.yJF;
                            this.gyS.ae(j, j);
                            break;
                        }
                        break;
                    case 10:
                        this.yJC = false;
                        this.auE = null;
                        break;
                }
                AppMethodBeat.o(30700);
                return true;
            }
            AppMethodBeat.o(30700);
            return false;
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            AppMethodBeat.i(30701);
            switch (motionEvent.getAction()) {
                case 1:
                    this.yJC = true;
                    break;
                case 3:
                    break;
            }
            dismiss();
            AppMethodBeat.o(30701);
            return false;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(30702);
            ay ayVar = (ay) view.getTag();
            if (view == this.yJy) {
                q.w(view.getContext(), ayVar.userName, 3);
            } else {
                q.w(view.getContext(), ayVar.userName, 2);
            }
            dismiss();
            AppMethodBeat.o(30702);
        }
    }

    public static class a implements OnTouchListener {
        private int mColor;

        public a() {
            this(Color.argb(255, n.CTRL_INDEX, n.CTRL_INDEX, n.CTRL_INDEX));
            AppMethodBeat.i(30694);
            AppMethodBeat.o(30694);
        }

        private a(int i) {
            this.mColor = i;
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            Drawable drawable;
            AppMethodBeat.i(30695);
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
            AppMethodBeat.o(30695);
            return false;
        }
    }

    static {
        AppMethodBeat.i(30707);
        AppMethodBeat.o(30707);
    }

    public static void eJ(View view) {
        AppMethodBeat.i(30704);
        b bVar = yJv;
        if (view == null || bVar == null) {
            ab.w("MicroMsg.OnHoverCompatibleHelper", "view or callback is null.");
            AppMethodBeat.o(30704);
            return;
        }
        if (VERSION.SDK_INT >= 14) {
            ai dCK = ai.dCK();
            if (VERSION.SDK_INT >= 14 && dCK.yLS == null) {
                dCK.yLS = new com.tencent.mm.ui.chatting.ai.a(bVar);
            }
            Object obj = dCK.yLS;
            if (obj != null && VERSION.SDK_INT >= 14 && (obj instanceof OnHoverListener)) {
                view.setOnHoverListener((OnHoverListener) obj);
            }
        }
        AppMethodBeat.o(30704);
    }

    public static void dismiss() {
        AppMethodBeat.i(30705);
        try {
            if (yJv != null) {
                b.a(yJv);
            }
            AppMethodBeat.o(30705);
        } catch (Exception e) {
            ab.e("MicroMsg.ChattingItemAvatarOnHoverHelper", "exception in dismiss, %s", e.getMessage());
            AppMethodBeat.o(30705);
        }
    }

    static /* synthetic */ void w(Context context, String str, int i) {
        AppMethodBeat.i(30706);
        ui uiVar = new ui();
        uiVar.cQx.cAd = 5;
        uiVar.cQx.talker = str;
        uiVar.cQx.context = context;
        uiVar.cQx.cQs = i;
        com.tencent.mm.sdk.b.a.xxA.m(uiVar);
        h.pYm.e(11033, Integer.valueOf(4), Integer.valueOf(1), Integer.valueOf(0));
        AppMethodBeat.o(30706);
    }
}
