package com.tencent.mm.ui.applet;

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
import com.tencent.mm.R;
import com.tencent.mm.cf.b;

public final class c {

    public static final class a {
        private ImageView cDh;
        private View mView;
        FrameLayout yrF;
        WindowManager yrG;
        LayoutParams yrH;
        private ViewGroup.LayoutParams yrI;

        public a(Context context, View view) {
            AppMethodBeat.i(29975);
            if (this.yrF == null || this.yrG == null) {
                view.findViewById(R.id.ez0).setVisibility(8);
                this.cDh = (ImageView) view.findViewById(R.id.i3);
                ((ImageView) view.findViewById(R.id.ez1)).setOnClickListener(new OnClickListener() {
                    public final void onClick(View view) {
                        AppMethodBeat.i(29972);
                        a.this.dzo();
                        AppMethodBeat.o(29972);
                    }
                });
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
                    int yrM = ((displayMetrics.widthPixels - a.this.yrH.width) - 1);
                    int yrN = ((displayMetrics.heightPixels - a.this.yrH.height) - 1);
                    long yrO;

                    public final boolean onTouch(View view, MotionEvent motionEvent) {
                        AppMethodBeat.i(29974);
                        switch (motionEvent.getAction()) {
                            case 0:
                                this.yrK = ((int) motionEvent.getRawX()) - a.this.yrH.x;
                                this.yrL = ((int) motionEvent.getRawY()) - a.this.yrH.y;
                                this.yrO = System.currentTimeMillis();
                                break;
                            case 1:
                                if (System.currentTimeMillis() - this.yrO < 300) {
                                    b.dvT();
                                    b.ag(false, true);
                                    a.this.dzo();
                                    break;
                                }
                                break;
                            case 2:
                                this.yrM = (displayMetrics.widthPixels - a.this.yrH.width) - 1;
                                this.yrN = (displayMetrics.heightPixels - a.this.yrH.height) - 1;
                                a.this.yrH.x = ((int) motionEvent.getRawX()) - this.yrK;
                                a.this.yrH.y = ((int) motionEvent.getRawY()) - this.yrL;
                                a.this.yrH.x = a.this.yrH.x < 0 ? 0 : a.this.yrH.x;
                                a.this.yrH.x = a.this.yrH.x > this.yrM ? this.yrM : a.this.yrH.x;
                                a.this.yrH.y = a.this.yrH.y < 0 ? 0 : a.this.yrH.y;
                                a.this.yrH.y = a.this.yrH.y > this.yrN ? this.yrN : a.this.yrH.y;
                                a.this.yrG.updateViewLayout(a.this.yrF, a.this.yrH);
                                break;
                        }
                        AppMethodBeat.o(29974);
                        return false;
                    }
                });
                AppMethodBeat.o(29975);
                return;
            }
            AppMethodBeat.o(29975);
        }

        public final void show() {
            AppMethodBeat.i(29976);
            this.yrG.addView(this.yrF, this.yrH);
            AppMethodBeat.o(29976);
        }

        public final void dzo() {
            AppMethodBeat.i(29977);
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
                AppMethodBeat.o(29977);
            } catch (Exception e) {
                AppMethodBeat.o(29977);
            }
        }
    }

    public static void hH(Context context) {
        AppMethodBeat.i(29978);
        new a(context, LayoutInflater.from(context).inflate(R.layout.b0n, null)).show();
        AppMethodBeat.o(29978);
    }
}
