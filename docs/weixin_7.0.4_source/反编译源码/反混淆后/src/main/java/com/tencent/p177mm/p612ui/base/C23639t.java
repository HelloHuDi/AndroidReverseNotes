package com.tencent.p177mm.p612ui.base;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.os.Message;
import android.support.p069v7.app.AppCompatActivity;
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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.compatible.util.C1448h;
import com.tencent.p177mm.p612ui.C5222ae;
import com.tencent.p177mm.sdk.platformtools.BackwardSupportUtil.C4977b;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.sdk.platformtools.C7564ap;
import com.tencent.p177mm.sdk.platformtools.C7564ap.C5015a;
import com.tencent.ttpic.thread.FaceGestureDetGLThread;

/* renamed from: com.tencent.mm.ui.base.t */
public final class C23639t extends Toast {
    public final C7564ap che = new C7564ap(new C236401(), true);
    private final Context context;
    public long duration;
    private View hVf;
    public int kmW;
    private int level;
    private final TextView nBV;

    /* renamed from: com.tencent.mm.ui.base.t$a */
    static class C5287a {
        private static Toast mMP = null;
        public static int yyc = 0;

        /* renamed from: az */
        public static void m8057az(Context context, int i) {
            AppMethodBeat.m2504i(106878);
            Context applicationContext = context.getApplicationContext();
            if (yyc != i) {
                mMP = null;
                yyc = i;
            }
            if (mMP == null) {
                mMP = Toast.makeText(applicationContext, "", 1);
            }
            View inflate = View.inflate(applicationContext, 2130970557, null);
            if (i == 1) {
                ((TextView) inflate.findViewById(2131827243)).setText(C25738R.string.cza);
            } else if (i == 3) {
                ((TextView) inflate.findViewById(2131827243)).setText(C25738R.string.czb);
            } else {
                ((TextView) inflate.findViewById(2131827243)).setText(C25738R.string.czc);
            }
            mMP.setView(inflate);
            mMP.show();
            AppMethodBeat.m2505o(106878);
        }
    }

    /* renamed from: com.tencent.mm.ui.base.t$1 */
    class C236401 implements C5015a {
        C236401() {
        }

        /* renamed from: BI */
        public final boolean mo4499BI() {
            AppMethodBeat.m2504i(106870);
            if (C23639t.this.duration == -1) {
                C23639t.this.show();
                AppMethodBeat.m2505o(106870);
                return true;
            }
            C23639t.this.kmW = C23639t.this.kmW - 1;
            if (C23639t.this.kmW >= 0) {
                C23639t.this.show();
                AppMethodBeat.m2505o(106870);
                return true;
            }
            C23639t.this.cancel();
            AppMethodBeat.m2505o(106870);
            return false;
        }
    }

    public C23639t(Context context) {
        super(context);
        AppMethodBeat.m2504i(106879);
        this.context = context;
        reset();
        this.hVf = View.inflate(context, 2130970934, null);
        setView(this.hVf);
        setGravity(55, 0, C4977b.m7371b(context, 40.0f));
        setDuration(0);
        this.nBV = (TextView) this.hVf.findViewById(2131828246);
        switch (this.level) {
            case 1:
                this.nBV.setTextColor(-1);
                AppMethodBeat.m2505o(106879);
                return;
            case 2:
                this.nBV.setTextColor(this.context.getResources().getColor(C25738R.color.a3b));
                break;
        }
        AppMethodBeat.m2505o(106879);
    }

    public final void setText(CharSequence charSequence) {
        AppMethodBeat.m2504i(106880);
        this.nBV.setText(charSequence);
        AppMethodBeat.m2505o(106880);
    }

    public final void setText(int i) {
        AppMethodBeat.m2504i(106881);
        this.nBV.setText(i);
        AppMethodBeat.m2505o(106881);
    }

    public final void reset() {
        this.level = 1;
        this.duration = FaceGestureDetGLThread.BRIGHTNESS_DURATION;
        this.kmW = ((int) (this.duration / 70)) + 1;
    }

    /* renamed from: a */
    public static C46633o m36486a(Activity activity, String str, long j) {
        AppMethodBeat.m2504i(106882);
        View inflate = View.inflate(activity, 2130970934, null);
        ((TextView) inflate.findViewById(2131828246)).setText(str);
        final C46633o c46633o = new C46633o(inflate);
        c46633o.setWidth(-1);
        c46633o.setHeight(-2);
        Rect rect = new Rect();
        activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
        c46633o.showAtLocation(activity.getWindow().getDecorView(), 48, 0, rect.top + C23639t.m36490de(activity));
        new C7306ak() {
            public final void handleMessage(Message message) {
                AppMethodBeat.m2504i(106873);
                c46633o.dismiss();
                super.handleMessage(message);
                AppMethodBeat.m2505o(106873);
            }
        }.sendEmptyMessageDelayed(0, j);
        AppMethodBeat.m2505o(106882);
        return c46633o;
    }

    /* renamed from: de */
    private static int m36490de(Context context) {
        int dimensionPixelSize;
        AppMethodBeat.m2504i(106883);
        if (!(context instanceof AppCompatActivity) || ((AppCompatActivity) context).getSupportActionBar() == null) {
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            if (displayMetrics.widthPixels > displayMetrics.heightPixels) {
                dimensionPixelSize = context.getResources().getDimensionPixelSize(C25738R.dimen.f9777fc);
            } else {
                dimensionPixelSize = context.getResources().getDimensionPixelSize(C25738R.dimen.f9778fd);
            }
        } else {
            dimensionPixelSize = ((AppCompatActivity) context).getSupportActionBar().getHeight();
        }
        if (dimensionPixelSize == 0) {
            dimensionPixelSize = context.getResources().getDimensionPixelSize(C25738R.dimen.f9778fd);
            AppMethodBeat.m2505o(106883);
            return dimensionPixelSize;
        }
        AppMethodBeat.m2505o(106883);
        return dimensionPixelSize;
    }

    /* renamed from: a */
    public static C46633o m36487a(Activity activity, String str, final OnClickListener onClickListener) {
        AppMethodBeat.m2504i(106885);
        View inflate = View.inflate(activity, 2130970929, null);
        ((LinearLayout) inflate.findViewById(2131828238)).setBackgroundColor(activity.getResources().getColor(C25738R.color.a38));
        TextView textView = (TextView) inflate.findViewById(2131828240);
        textView.setText(str);
        textView.setOnClickListener(null);
        textView.setTextColor(activity.getResources().getColor(C25738R.color.f11785h7));
        ((ImageView) inflate.findViewById(2131828239)).setImageResource(C1318a.tipsbar_icon_warning);
        final C46633o c46633o = new C46633o(inflate);
        c46633o.setWidth(-1);
        c46633o.setHeight(-2);
        Rect rect = new Rect();
        final Window window = activity.getWindow();
        window.getDecorView().getWindowVisibleDisplayFrame(rect);
        int i = rect.top;
        int de = C23639t.m36490de(activity);
        if (i == 0) {
            i = C5222ae.m7948hB(activity);
        }
        i += de;
        if (window.getDecorView() != null) {
            window.getDecorView().post(new Runnable() {

                /* renamed from: com.tencent.mm.ui.base.t$5$1 */
                class C236431 implements Runnable {
                    C236431() {
                    }

                    public final void run() {
                        AppMethodBeat.m2504i(106874);
                        c46633o.showAtLocation(window.getDecorView(), 48, 0, i);
                        AppMethodBeat.m2505o(106874);
                    }
                }

                public final void run() {
                    AppMethodBeat.m2504i(106875);
                    C5004al.m7441d(new C236431());
                    AppMethodBeat.m2505o(106875);
                }
            });
        }
        ImageView imageView = (ImageView) inflate.findViewById(2131828241);
        imageView.setImageResource(C25738R.drawable.a3k);
        imageView.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.m2504i(106876);
                c46633o.dismiss();
                if (onClickListener != null) {
                    onClickListener.onClick(view);
                }
                AppMethodBeat.m2505o(106876);
            }
        });
        AppMethodBeat.m2505o(106885);
        return c46633o;
    }

    /* renamed from: hO */
    public static void m36492hO(Context context) {
        AppMethodBeat.m2504i(106886);
        if (C1448h.getExternalStorageState().equals("mounted_ro")) {
            C5287a.m8057az(context, 3);
            AppMethodBeat.m2505o(106886);
            return;
        }
        C5287a.m8057az(context, 1);
        AppMethodBeat.m2505o(106886);
    }

    /* renamed from: hP */
    public static void m36493hP(Context context) {
        AppMethodBeat.m2504i(106887);
        C5287a.m8057az(context, 2);
        AppMethodBeat.m2505o(106887);
    }

    /* renamed from: a */
    public static C46633o m36485a(final Activity activity, int i, String str) {
        AppMethodBeat.m2504i(106884);
        View inflate = View.inflate(activity, 2130969937, null);
        TextView textView = (TextView) inflate.findViewById(2131825262);
        textView.setText(str);
        textView.setOnClickListener(null);
        ImageView imageView = (ImageView) inflate.findViewById(2131825261);
        if (i == 0) {
            imageView.setVisibility(8);
        } else {
            imageView.setImageResource(i);
        }
        final C46633o c46633o = new C46633o(inflate);
        c46633o.setWidth(-1);
        c46633o.setHeight(-2);
        Rect rect = new Rect();
        activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
        int i2 = rect.top;
        int de = C23639t.m36490de(activity);
        if (i2 == 0) {
            i2 = C5222ae.m7948hB(activity);
        }
        i2 += de;
        C5004al.m7441d(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(106877);
                c46633o.showAtLocation(activity.getWindow().getDecorView(), 48, 0, i2);
                AppMethodBeat.m2505o(106877);
            }
        });
        C5004al.m7442n(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(106871);
                c46633o.dismiss();
                AppMethodBeat.m2505o(106871);
            }
        }, FaceGestureDetGLThread.BRIGHTNESS_DURATION);
        ImageButton imageButton = (ImageButton) inflate.findViewById(2131825263);
        imageButton.setVisibility(8);
        imageButton.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.m2504i(106872);
                c46633o.dismiss();
                AppMethodBeat.m2505o(106872);
            }
        });
        AppMethodBeat.m2505o(106884);
        return c46633o;
    }

    /* renamed from: hF */
    public static int m36491hF(Context context) {
        AppMethodBeat.m2504i(139073);
        int hB = C5222ae.m7948hB(context);
        AppMethodBeat.m2505o(139073);
        return hB;
    }
}
