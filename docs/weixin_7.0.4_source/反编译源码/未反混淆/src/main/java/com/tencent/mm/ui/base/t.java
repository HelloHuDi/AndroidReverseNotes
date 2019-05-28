package com.tencent.mm.ui.base;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.h;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.ui.ae;
import com.tencent.ttpic.thread.FaceGestureDetGLThread;

public final class t extends Toast {
    public final ap che = new ap(new com.tencent.mm.sdk.platformtools.ap.a() {
        public final boolean BI() {
            AppMethodBeat.i(106870);
            if (t.this.duration == -1) {
                t.this.show();
                AppMethodBeat.o(106870);
                return true;
            }
            t.this.kmW = t.this.kmW - 1;
            if (t.this.kmW >= 0) {
                t.this.show();
                AppMethodBeat.o(106870);
                return true;
            }
            t.this.cancel();
            AppMethodBeat.o(106870);
            return false;
        }
    }, true);
    private final Context context;
    public long duration;
    private View hVf;
    public int kmW;
    private int level;
    private final TextView nBV;

    static class a {
        private static Toast mMP = null;
        public static int yyc = 0;

        public static void az(Context context, int i) {
            AppMethodBeat.i(106878);
            Context applicationContext = context.getApplicationContext();
            if (yyc != i) {
                mMP = null;
                yyc = i;
            }
            if (mMP == null) {
                mMP = Toast.makeText(applicationContext, "", 1);
            }
            View inflate = View.inflate(applicationContext, R.layout.app, null);
            if (i == 1) {
                ((TextView) inflate.findViewById(R.id.e63)).setText(R.string.cza);
            } else if (i == 3) {
                ((TextView) inflate.findViewById(R.id.e63)).setText(R.string.czb);
            } else {
                ((TextView) inflate.findViewById(R.id.e63)).setText(R.string.czc);
            }
            mMP.setView(inflate);
            mMP.show();
            AppMethodBeat.o(106878);
        }
    }

    public t(Context context) {
        super(context);
        AppMethodBeat.i(106879);
        this.context = context;
        reset();
        this.hVf = View.inflate(context, R.layout.azv, null);
        setView(this.hVf);
        setGravity(55, 0, b.b(context, 40.0f));
        setDuration(0);
        this.nBV = (TextView) this.hVf.findViewById(R.id.ew7);
        switch (this.level) {
            case 1:
                this.nBV.setTextColor(-1);
                AppMethodBeat.o(106879);
                return;
            case 2:
                this.nBV.setTextColor(this.context.getResources().getColor(R.color.a3b));
                break;
        }
        AppMethodBeat.o(106879);
    }

    public final void setText(CharSequence charSequence) {
        AppMethodBeat.i(106880);
        this.nBV.setText(charSequence);
        AppMethodBeat.o(106880);
    }

    public final void setText(int i) {
        AppMethodBeat.i(106881);
        this.nBV.setText(i);
        AppMethodBeat.o(106881);
    }

    public final void reset() {
        this.level = 1;
        this.duration = FaceGestureDetGLThread.BRIGHTNESS_DURATION;
        this.kmW = ((int) (this.duration / 70)) + 1;
    }

    public static o a(Activity activity, String str, long j) {
        AppMethodBeat.i(106882);
        View inflate = View.inflate(activity, R.layout.azv, null);
        ((TextView) inflate.findViewById(R.id.ew7)).setText(str);
        final o oVar = new o(inflate);
        oVar.setWidth(-1);
        oVar.setHeight(-2);
        Rect rect = new Rect();
        activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
        oVar.showAtLocation(activity.getWindow().getDecorView(), 48, 0, rect.top + de(activity));
        new ak() {
            public final void handleMessage(Message message) {
                AppMethodBeat.i(106873);
                oVar.dismiss();
                super.handleMessage(message);
                AppMethodBeat.o(106873);
            }
        }.sendEmptyMessageDelayed(0, j);
        AppMethodBeat.o(106882);
        return oVar;
    }

    private static int de(Context context) {
        int dimensionPixelSize;
        AppMethodBeat.i(106883);
        if (!(context instanceof AppCompatActivity) || ((AppCompatActivity) context).getSupportActionBar() == null) {
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            if (displayMetrics.widthPixels > displayMetrics.heightPixels) {
                dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.fc);
            } else {
                dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.fd);
            }
        } else {
            dimensionPixelSize = ((AppCompatActivity) context).getSupportActionBar().getHeight();
        }
        if (dimensionPixelSize == 0) {
            dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.fd);
            AppMethodBeat.o(106883);
            return dimensionPixelSize;
        }
        AppMethodBeat.o(106883);
        return dimensionPixelSize;
    }

    public static o a(Activity activity, String str, final OnClickListener onClickListener) {
        AppMethodBeat.i(106885);
        View inflate = View.inflate(activity, R.layout.azq, null);
        ((LinearLayout) inflate.findViewById(R.id.evz)).setBackgroundColor(activity.getResources().getColor(R.color.a38));
        TextView textView = (TextView) inflate.findViewById(R.id.ew1);
        textView.setText(str);
        textView.setOnClickListener(null);
        textView.setTextColor(activity.getResources().getColor(R.color.h7));
        ((ImageView) inflate.findViewById(R.id.ew0)).setImageResource(R.raw.tipsbar_icon_warning);
        final o oVar = new o(inflate);
        oVar.setWidth(-1);
        oVar.setHeight(-2);
        Rect rect = new Rect();
        final Window window = activity.getWindow();
        window.getDecorView().getWindowVisibleDisplayFrame(rect);
        int i = rect.top;
        int de = de(activity);
        if (i == 0) {
            i = ae.hB(activity);
        }
        i += de;
        if (window.getDecorView() != null) {
            window.getDecorView().post(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(106875);
                    al.d(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(106874);
                            oVar.showAtLocation(window.getDecorView(), 48, 0, i);
                            AppMethodBeat.o(106874);
                        }
                    });
                    AppMethodBeat.o(106875);
                }
            });
        }
        ImageView imageView = (ImageView) inflate.findViewById(R.id.ew2);
        imageView.setImageResource(R.drawable.a3k);
        imageView.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(106876);
                oVar.dismiss();
                if (onClickListener != null) {
                    onClickListener.onClick(view);
                }
                AppMethodBeat.o(106876);
            }
        });
        AppMethodBeat.o(106885);
        return oVar;
    }

    public static void hO(Context context) {
        AppMethodBeat.i(106886);
        if (h.getExternalStorageState().equals("mounted_ro")) {
            a.az(context, 3);
            AppMethodBeat.o(106886);
            return;
        }
        a.az(context, 1);
        AppMethodBeat.o(106886);
    }

    public static void hP(Context context) {
        AppMethodBeat.i(106887);
        a.az(context, 2);
        AppMethodBeat.o(106887);
    }

    public static o a(final Activity activity, int i, String str) {
        AppMethodBeat.i(106884);
        View inflate = View.inflate(activity, R.layout.a9z, null);
        TextView textView = (TextView) inflate.findViewById(R.id.cpj);
        textView.setText(str);
        textView.setOnClickListener(null);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.cpi);
        if (i == 0) {
            imageView.setVisibility(8);
        } else {
            imageView.setImageResource(i);
        }
        final o oVar = new o(inflate);
        oVar.setWidth(-1);
        oVar.setHeight(-2);
        Rect rect = new Rect();
        activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
        int i2 = rect.top;
        int de = de(activity);
        if (i2 == 0) {
            i2 = ae.hB(activity);
        }
        i2 += de;
        al.d(new Runnable() {
            public final void run() {
                AppMethodBeat.i(106877);
                oVar.showAtLocation(activity.getWindow().getDecorView(), 48, 0, i2);
                AppMethodBeat.o(106877);
            }
        });
        al.n(new Runnable() {
            public final void run() {
                AppMethodBeat.i(106871);
                oVar.dismiss();
                AppMethodBeat.o(106871);
            }
        }, FaceGestureDetGLThread.BRIGHTNESS_DURATION);
        ImageButton imageButton = (ImageButton) inflate.findViewById(R.id.cpk);
        imageButton.setVisibility(8);
        imageButton.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(106872);
                oVar.dismiss();
                AppMethodBeat.o(106872);
            }
        });
        AppMethodBeat.o(106884);
        return oVar;
    }

    public static int hF(Context context) {
        AppMethodBeat.i(139073);
        int hB = ae.hB(context);
        AppMethodBeat.o(139073);
        return hB;
    }
}
