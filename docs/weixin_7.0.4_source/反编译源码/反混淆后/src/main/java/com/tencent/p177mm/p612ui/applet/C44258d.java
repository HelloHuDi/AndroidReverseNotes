package com.tencent.p177mm.p612ui.applet;

import android.content.Context;
import android.os.Message;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p215cf.C37634d;
import com.tencent.p177mm.p215cf.C37634d.C1371b;
import com.tencent.p177mm.p215cf.C37634d.C37636a;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import java.lang.ref.WeakReference;

/* renamed from: com.tencent.mm.ui.applet.d */
public final class C44258d {
    private static int yrY = 0;

    /* renamed from: com.tencent.mm.ui.applet.d$a */
    public static final class C44259a {
        ImageView cDh;
        ProgressBar cDj;
        Context context;
        View mView;
        TextView ngD;
        FrameLayout yrF;
        WindowManager yrG;
        LayoutParams yrH;
        private ViewGroup.LayoutParams yrI;
        boolean yrZ = false;
        C1371b ysa = new C235781();
        C37636a ysb;
        int ysc = 0;
        C7306ak ysd = new C442574();

        /* renamed from: com.tencent.mm.ui.applet.d$a$1 */
        class C235781 implements C1371b {
            C235781() {
            }

            public final void dvX() {
                AppMethodBeat.m2504i(29980);
                C44259a.this.mo69921hJ(C44259a.this.context);
                Toast.makeText(C44259a.this.context, "trace file has saved ", 0).show();
                AppMethodBeat.m2505o(29980);
            }
        }

        /* renamed from: com.tencent.mm.ui.applet.d$a$2 */
        class C442552 implements OnClickListener {
            C442552() {
            }

            public final void onClick(View view) {
                AppMethodBeat.m2504i(29981);
                if (C44259a.this.yrZ && C44259a.this.cDj.getVisibility() != 0) {
                    C37634d.dvV().mo60466b(C44259a.this.ysb);
                }
                C44259a c44259a = C44259a.this;
                try {
                    if (c44259a.yrG != null) {
                        if (c44259a.yrF != null) {
                            c44259a.yrG.removeView(c44259a.yrF);
                        }
                        c44259a.yrG = null;
                    }
                    if (c44259a.yrF != null) {
                        c44259a.yrF.removeAllViews();
                        c44259a.yrF = null;
                    }
                    c44259a.mView = null;
                } catch (Exception e) {
                }
                C44258d.dzp();
                AppMethodBeat.m2505o(29981);
            }
        }

        /* renamed from: com.tencent.mm.ui.applet.d$a$4 */
        class C442574 extends C7306ak {
            C442574() {
            }

            public final void handleMessage(Message message) {
                AppMethodBeat.m2504i(29984);
                if (C44259a.this.ngD.getVisibility() != 0) {
                    C44259a.this.ysc = 0;
                    AppMethodBeat.m2505o(29984);
                    return;
                }
                C44259a c44259a = C44259a.this;
                c44259a.ysc++;
                C44259a.this.dzq();
                super.handleMessage(message);
                AppMethodBeat.m2505o(29984);
            }
        }

        public C44259a(Context context, View view) {
            AppMethodBeat.m2504i(29985);
            if (this.yrF == null || this.yrG == null) {
                C37634d.dvV().ydM = new WeakReference(this.ysa);
                this.ngD = (TextView) view.findViewById(2131822504);
                this.cDh = (ImageView) view.findViewById(2131820869);
                ((ImageView) view.findViewById(2131828351)).setOnClickListener(new C442552());
                this.cDj = (ProgressBar) view.findViewById(2131828350);
                this.cDj.setVisibility(8);
                this.context = context;
                this.yrH = new LayoutParams();
                this.yrH.height = -2;
                this.yrH.width = -2;
                this.yrG = (WindowManager) context.getSystemService("window");
                this.yrH.x = 0;
                this.yrH.y = 0;
                this.yrH.flags = 40;
                this.yrH.type = 2002;
                this.mView = view;
                this.ngD.setVisibility(8);
                this.yrH.gravity = 51;
                this.yrH.format = 1;
                this.yrF = new FrameLayout(context);
                this.yrF.setPadding(4, 4, 4, 4);
                this.yrI = new ViewGroup.LayoutParams(-2, -2);
                this.yrF.addView(this.mView, this.yrI);
                final DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
                this.yrF.setOnTouchListener(new OnTouchListener() {
                    int yrK;
                    int yrL;
                    int yrM = ((displayMetrics.widthPixels - C44259a.this.yrH.width) - 1);
                    int yrN = ((displayMetrics.heightPixels - C44259a.this.yrH.height) - 1);
                    long yrO;

                    public final boolean onTouch(View view, MotionEvent motionEvent) {
                        AppMethodBeat.m2504i(29983);
                        switch (motionEvent.getAction()) {
                            case 0:
                                this.yrK = ((int) motionEvent.getRawX()) - C44259a.this.yrH.x;
                                this.yrL = ((int) motionEvent.getRawY()) - C44259a.this.yrH.y;
                                this.yrO = System.currentTimeMillis();
                                break;
                            case 1:
                                if (System.currentTimeMillis() - this.yrO < 300) {
                                    C44259a c44259a = C44259a.this;
                                    c44259a.ysd.removeMessages(0);
                                    c44259a.ysc = 0;
                                    if (!c44259a.yrZ) {
                                        boolean z;
                                        c44259a.cDh.setVisibility(0);
                                        c44259a.cDh.setBackgroundDrawable(c44259a.context.getResources().getDrawable(C25738R.drawable.aq4));
                                        if (c44259a.yrZ) {
                                            z = false;
                                        } else {
                                            z = true;
                                        }
                                        c44259a.yrZ = z;
                                        c44259a.ysb = new C37636a(null, 6, 8, 0);
                                        C37634d.dvV().mo60467c(c44259a.ysb);
                                        c44259a.dzq();
                                        break;
                                    }
                                    c44259a.cDj.setVisibility(0);
                                    c44259a.cDh.setVisibility(4);
                                    if (!C37634d.dvV().mo60466b(c44259a.ysb)) {
                                        c44259a.mo69921hJ(c44259a.context);
                                        break;
                                    }
                                }
                                break;
                            case 2:
                                this.yrM = (displayMetrics.widthPixels - C44259a.this.yrH.width) - 1;
                                this.yrN = (displayMetrics.heightPixels - C44259a.this.yrH.height) - 1;
                                C44259a.this.yrH.x = ((int) motionEvent.getRawX()) - this.yrK;
                                C44259a.this.yrH.y = ((int) motionEvent.getRawY()) - this.yrL;
                                C44259a.this.yrH.x = C44259a.this.yrH.x < 0 ? 0 : C44259a.this.yrH.x;
                                C44259a.this.yrH.x = C44259a.this.yrH.x > this.yrM ? this.yrM : C44259a.this.yrH.x;
                                C44259a.this.yrH.y = C44259a.this.yrH.y < 0 ? 0 : C44259a.this.yrH.y;
                                C44259a.this.yrH.y = C44259a.this.yrH.y > this.yrN ? this.yrN : C44259a.this.yrH.y;
                                C44259a.this.yrG.updateViewLayout(C44259a.this.yrF, C44259a.this.yrH);
                                break;
                        }
                        AppMethodBeat.m2505o(29983);
                        return false;
                    }
                });
                AppMethodBeat.m2505o(29985);
                return;
            }
            AppMethodBeat.m2505o(29985);
        }

        /* Access modifiers changed, original: final */
        /* renamed from: hJ */
        public final void mo69921hJ(Context context) {
            boolean z = false;
            AppMethodBeat.m2504i(29986);
            this.cDh.setVisibility(0);
            this.cDj.setVisibility(4);
            if (!this.yrZ) {
                z = true;
            }
            this.yrZ = z;
            this.cDh.setBackgroundDrawable(context.getResources().getDrawable(C25738R.drawable.aq3));
            this.ngD.setVisibility(8);
            AppMethodBeat.m2505o(29986);
        }

        /* Access modifiers changed, original: final */
        public final void dzq() {
            AppMethodBeat.m2504i(29987);
            this.ngD.setText(this.ysc);
            this.ysd.sendEmptyMessageDelayed(0, 1000);
            AppMethodBeat.m2505o(29987);
        }
    }

    static /* synthetic */ int dzp() {
        int i = yrY;
        yrY = i - 1;
        return i;
    }

    /* renamed from: hI */
    public static void m79916hI(Context context) {
        AppMethodBeat.m2504i(29988);
        if (yrY > 0) {
            AppMethodBeat.m2505o(29988);
            return;
        }
        C44259a c44259a = new C44259a(context, LayoutInflater.from(context).inflate(2130970963, null));
        c44259a.yrG.addView(c44259a.yrF, c44259a.yrH);
        yrY++;
        AppMethodBeat.m2505o(29988);
    }
}
