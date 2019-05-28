package com.tencent.p177mm.p612ui.applet;

import android.content.Context;
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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p215cf.C37632b;

/* renamed from: com.tencent.mm.ui.applet.c */
public final class C15497c {

    /* renamed from: com.tencent.mm.ui.applet.c$a */
    public static final class C15498a {
        private ImageView cDh;
        private View mView;
        FrameLayout yrF;
        WindowManager yrG;
        LayoutParams yrH;
        private ViewGroup.LayoutParams yrI;

        /* renamed from: com.tencent.mm.ui.applet.c$a$1 */
        class C154991 implements OnClickListener {
            C154991() {
            }

            public final void onClick(View view) {
                AppMethodBeat.m2504i(29972);
                C15498a.this.dzo();
                AppMethodBeat.m2505o(29972);
            }
        }

        public C15498a(Context context, View view) {
            AppMethodBeat.m2504i(29975);
            if (this.yrF == null || this.yrG == null) {
                view.findViewById(2131828350).setVisibility(8);
                this.cDh = (ImageView) view.findViewById(2131820869);
                ((ImageView) view.findViewById(2131828351)).setOnClickListener(new C154991());
                this.yrH = new LayoutParams();
                this.yrH.height = -2;
                this.yrH.width = -2;
                this.yrG = (WindowManager) context.getSystemService("window");
                this.yrH.x = 0;
                this.yrH.y = 0;
                this.yrH.flags = 40;
                this.yrH.type = 2002;
                this.mView = view;
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
                    int yrM = ((displayMetrics.widthPixels - C15498a.this.yrH.width) - 1);
                    int yrN = ((displayMetrics.heightPixels - C15498a.this.yrH.height) - 1);
                    long yrO;

                    public final boolean onTouch(View view, MotionEvent motionEvent) {
                        AppMethodBeat.m2504i(29974);
                        switch (motionEvent.getAction()) {
                            case 0:
                                this.yrK = ((int) motionEvent.getRawX()) - C15498a.this.yrH.x;
                                this.yrL = ((int) motionEvent.getRawY()) - C15498a.this.yrH.y;
                                this.yrO = System.currentTimeMillis();
                                break;
                            case 1:
                                if (System.currentTimeMillis() - this.yrO < 300) {
                                    C37632b.dvT();
                                    C37632b.m63571ag(false, true);
                                    C15498a.this.dzo();
                                    break;
                                }
                                break;
                            case 2:
                                this.yrM = (displayMetrics.widthPixels - C15498a.this.yrH.width) - 1;
                                this.yrN = (displayMetrics.heightPixels - C15498a.this.yrH.height) - 1;
                                C15498a.this.yrH.x = ((int) motionEvent.getRawX()) - this.yrK;
                                C15498a.this.yrH.y = ((int) motionEvent.getRawY()) - this.yrL;
                                C15498a.this.yrH.x = C15498a.this.yrH.x < 0 ? 0 : C15498a.this.yrH.x;
                                C15498a.this.yrH.x = C15498a.this.yrH.x > this.yrM ? this.yrM : C15498a.this.yrH.x;
                                C15498a.this.yrH.y = C15498a.this.yrH.y < 0 ? 0 : C15498a.this.yrH.y;
                                C15498a.this.yrH.y = C15498a.this.yrH.y > this.yrN ? this.yrN : C15498a.this.yrH.y;
                                C15498a.this.yrG.updateViewLayout(C15498a.this.yrF, C15498a.this.yrH);
                                break;
                        }
                        AppMethodBeat.m2505o(29974);
                        return false;
                    }
                });
                AppMethodBeat.m2505o(29975);
                return;
            }
            AppMethodBeat.m2505o(29975);
        }

        public final void show() {
            AppMethodBeat.m2504i(29976);
            this.yrG.addView(this.yrF, this.yrH);
            AppMethodBeat.m2505o(29976);
        }

        public final void dzo() {
            AppMethodBeat.m2504i(29977);
            try {
                if (this.yrG != null) {
                    if (this.yrF != null) {
                        this.yrG.removeView(this.yrF);
                    }
                    this.yrG = null;
                }
                if (this.yrF != null) {
                    this.yrF.removeAllViews();
                    this.yrF = null;
                }
                this.mView = null;
                AppMethodBeat.m2505o(29977);
            } catch (Exception e) {
                AppMethodBeat.m2505o(29977);
            }
        }
    }

    /* renamed from: hH */
    public static void m23813hH(Context context) {
        AppMethodBeat.m2504i(29978);
        new C15498a(context, LayoutInflater.from(context).inflate(2130970963, null)).show();
        AppMethodBeat.m2505o(29978);
    }
}
