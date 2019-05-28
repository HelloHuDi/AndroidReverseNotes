package com.tencent.mm.ui.applet;

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
import com.tencent.mm.R;
import com.tencent.mm.cf.d.b;
import com.tencent.mm.sdk.platformtools.ak;
import java.lang.ref.WeakReference;

public final class d {
    private static int yrY = 0;

    public static final class a {
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
        b ysa = new b() {
            public final void dvX() {
                AppMethodBeat.i(29980);
                a.this.hJ(a.this.context);
                Toast.makeText(a.this.context, "trace file has saved ", 0).show();
                AppMethodBeat.o(29980);
            }
        };
        com.tencent.mm.cf.d.a ysb;
        int ysc = 0;
        ak ysd = new ak() {
            public final void handleMessage(Message message) {
                AppMethodBeat.i(29984);
                if (a.this.ngD.getVisibility() != 0) {
                    a.this.ysc = 0;
                    AppMethodBeat.o(29984);
                    return;
                }
                a aVar = a.this;
                aVar.ysc++;
                a.this.dzq();
                super.handleMessage(message);
                AppMethodBeat.o(29984);
            }
        };

        public a(Context context, View view) {
            AppMethodBeat.i(29985);
            if (this.yrF == null || this.yrG == null) {
                com.tencent.mm.cf.d.dvV().ydM = new WeakReference(this.ysa);
                this.ngD = (TextView) view.findViewById(R.id.aoy);
                this.cDh = (ImageView) view.findViewById(R.id.i3);
                ((ImageView) view.findViewById(R.id.ez1)).setOnClickListener(new OnClickListener() {
                    public final void onClick(View view) {
                        AppMethodBeat.i(29981);
                        if (a.this.yrZ && a.this.cDj.getVisibility() != 0) {
                            com.tencent.mm.cf.d.dvV().b(a.this.ysb);
                        }
                        a aVar = a.this;
                        try {
                            if (aVar.yrG != null) {
                                if (aVar.yrF != null) {
                                    aVar.yrG.removeView(aVar.yrF);
                                }
                                aVar.yrG = null;
                            }
                            if (aVar.yrF != null) {
                                aVar.yrF.removeAllViews();
                                aVar.yrF = null;
                            }
                            aVar.mView = null;
                        } catch (Exception e) {
                        }
                        d.dzp();
                        AppMethodBeat.o(29981);
                    }
                });
                this.cDj = (ProgressBar) view.findViewById(R.id.ez0);
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
                    int yrM = ((displayMetrics.widthPixels - a.this.yrH.width) - 1);
                    int yrN = ((displayMetrics.heightPixels - a.this.yrH.height) - 1);
                    long yrO;

                    public final boolean onTouch(View view, MotionEvent motionEvent) {
                        AppMethodBeat.i(29983);
                        switch (motionEvent.getAction()) {
                            case 0:
                                this.yrK = ((int) motionEvent.getRawX()) - a.this.yrH.x;
                                this.yrL = ((int) motionEvent.getRawY()) - a.this.yrH.y;
                                this.yrO = System.currentTimeMillis();
                                break;
                            case 1:
                                if (System.currentTimeMillis() - this.yrO < 300) {
                                    a aVar = a.this;
                                    aVar.ysd.removeMessages(0);
                                    aVar.ysc = 0;
                                    if (!aVar.yrZ) {
                                        boolean z;
                                        aVar.cDh.setVisibility(0);
                                        aVar.cDh.setBackgroundDrawable(aVar.context.getResources().getDrawable(R.drawable.aq4));
                                        if (aVar.yrZ) {
                                            z = false;
                                        } else {
                                            z = true;
                                        }
                                        aVar.yrZ = z;
                                        aVar.ysb = new com.tencent.mm.cf.d.a(null, 6, 8, 0);
                                        com.tencent.mm.cf.d.dvV().c(aVar.ysb);
                                        aVar.dzq();
                                        break;
                                    }
                                    aVar.cDj.setVisibility(0);
                                    aVar.cDh.setVisibility(4);
                                    if (!com.tencent.mm.cf.d.dvV().b(aVar.ysb)) {
                                        aVar.hJ(aVar.context);
                                        break;
                                    }
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
                        AppMethodBeat.o(29983);
                        return false;
                    }
                });
                AppMethodBeat.o(29985);
                return;
            }
            AppMethodBeat.o(29985);
        }

        /* Access modifiers changed, original: final */
        public final void hJ(Context context) {
            boolean z = false;
            AppMethodBeat.i(29986);
            this.cDh.setVisibility(0);
            this.cDj.setVisibility(4);
            if (!this.yrZ) {
                z = true;
            }
            this.yrZ = z;
            this.cDh.setBackgroundDrawable(context.getResources().getDrawable(R.drawable.aq3));
            this.ngD.setVisibility(8);
            AppMethodBeat.o(29986);
        }

        /* Access modifiers changed, original: final */
        public final void dzq() {
            AppMethodBeat.i(29987);
            this.ngD.setText(this.ysc);
            this.ysd.sendEmptyMessageDelayed(0, 1000);
            AppMethodBeat.o(29987);
        }
    }

    static /* synthetic */ int dzp() {
        int i = yrY;
        yrY = i - 1;
        return i;
    }

    public static void hI(Context context) {
        AppMethodBeat.i(29988);
        if (yrY > 0) {
            AppMethodBeat.o(29988);
            return;
        }
        a aVar = new a(context, LayoutInflater.from(context).inflate(R.layout.b0n, null));
        aVar.yrG.addView(aVar.yrF, aVar.yrH);
        yrY++;
        AppMethodBeat.o(29988);
    }
}
