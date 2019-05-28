package com.tencent.p177mm.plugin.card.p931d;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.compatible.util.C6457e;
import com.tencent.p177mm.p190at.C32291o;
import com.tencent.p177mm.p190at.p191a.p1527d.C37477b;
import com.tencent.p177mm.p190at.p191a.p193c.C9014g;
import com.tencent.p177mm.p190at.p191a.p827a.C25814c.C17927a;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.plugin.card.base.C42837b;
import com.tencent.p177mm.plugin.card.model.C33770m;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.card.d.m */
public final class C45778m {

    /* renamed from: com.tencent.mm.plugin.card.d.m$3 */
    public static class C457773 implements AnimationListener {
        final /* synthetic */ View krT;
        final /* synthetic */ ScaleAnimation krU;

        public C457773(View view, ScaleAnimation scaleAnimation) {
            this.krT = view;
            this.krU = scaleAnimation;
        }

        public final void onAnimationStart(Animation animation) {
        }

        public final void onAnimationRepeat(Animation animation) {
        }

        public final void onAnimationEnd(Animation animation) {
            AppMethodBeat.m2504i(88929);
            this.krT.startAnimation(this.krU);
            AppMethodBeat.m2505o(88929);
        }
    }

    /* renamed from: dc */
    public static Rect m84648dc(View view) {
        AppMethodBeat.m2504i(88930);
        Rect rect = new Rect();
        rect.left = view.getPaddingLeft();
        rect.right = view.getPaddingRight();
        rect.top = view.getPaddingTop();
        rect.bottom = view.getPaddingBottom();
        AppMethodBeat.m2505o(88930);
        return rect;
    }

    /* renamed from: k */
    public static void m84649k(View view, Rect rect) {
        AppMethodBeat.m2504i(88931);
        view.setPadding(rect.left, rect.top, rect.right, rect.bottom);
        AppMethodBeat.m2505o(88931);
    }

    /* renamed from: Hu */
    public static String m84640Hu(String str) {
        AppMethodBeat.m2504i(88932);
        String str2;
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7412e("MicroMsg.CardViewUtil", "toApply is null");
            str2 = "";
            AppMethodBeat.m2505o(88932);
            return str2;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            stringBuilder.append(str.charAt(i));
            if ((i + 1) % 4 == 0) {
                stringBuilder.append(" ");
            }
        }
        str2 = stringBuilder.toString();
        AppMethodBeat.m2505o(88932);
        return str2;
    }

    /* renamed from: a */
    public static void m84644a(ImageView imageView, String str, int i, int i2, boolean z) {
        AppMethodBeat.m2504i(88933);
        if (imageView == null || TextUtils.isEmpty(str)) {
            AppMethodBeat.m2505o(88933);
        } else if (TextUtils.isEmpty(str)) {
            imageView.setImageResource(i2);
            AppMethodBeat.m2505o(88933);
        } else {
            C17927a c17927a = new C17927a();
            c17927a.ePK = C6457e.eSn;
            C32291o.ahq();
            c17927a.ePY = null;
            c17927a.ePJ = C33770m.m55183Gz(str);
            c17927a.ePH = true;
            c17927a.eQf = z;
            c17927a.ePF = true;
            c17927a.ePO = i;
            c17927a.ePN = i;
            c17927a.ePT = i2;
            C32291o.ahp().mo43766a(str, imageView, c17927a.ahG());
            AppMethodBeat.m2505o(88933);
        }
    }

    /* renamed from: a */
    public static void m84641a(final Context context, final ImageView imageView, String str, int i, final int i2) {
        AppMethodBeat.m2504i(88934);
        if (imageView == null || TextUtils.isEmpty(str)) {
            AppMethodBeat.m2505o(88934);
        } else if (TextUtils.isEmpty(str)) {
            C45778m.m84643a(imageView, C25738R.drawable.azs, i2);
            AppMethodBeat.m2505o(88934);
        } else {
            C17927a c17927a = new C17927a();
            c17927a.ePK = C6457e.eSn;
            C32291o.ahq();
            c17927a.ePY = null;
            c17927a.ePJ = C33770m.m55183Gz(str);
            c17927a.ePH = true;
            c17927a.eQf = false;
            c17927a.ePF = true;
            c17927a.ePO = i;
            c17927a.ePN = i;
            c17927a.ePT = C25738R.drawable.azs;
            C32291o.ahp().mo43767a(str, imageView, c17927a.ahG(), new C9014g() {
                final /* synthetic */ int krQ = C25738R.drawable.azs;

                /* renamed from: sH */
                public final void mo7596sH(String str) {
                }

                /* renamed from: a */
                public final Bitmap mo7594a(String str, View view, C37477b c37477b) {
                    return null;
                }

                /* renamed from: b */
                public final void mo7595b(String str, View view, C37477b c37477b) {
                    AppMethodBeat.m2504i(88927);
                    if (c37477b.bitmap != null) {
                        final Bitmap bitmap = c37477b.bitmap;
                        C5004al.m7441d(new Runnable() {
                            public final void run() {
                                AppMethodBeat.m2504i(88926);
                                imageView.setImageBitmap(bitmap);
                                imageView.setColorFilter(i2, Mode.SRC_IN);
                                AppMethodBeat.m2505o(88926);
                            }
                        });
                        AppMethodBeat.m2505o(88927);
                        return;
                    }
                    C45778m.m84643a(imageView, this.krQ, i2);
                    AppMethodBeat.m2505o(88927);
                }
            });
            AppMethodBeat.m2505o(88934);
        }
    }

    /* renamed from: a */
    public static void m84643a(final ImageView imageView, final int i, final int i2) {
        AppMethodBeat.m2504i(88935);
        C5004al.m7441d(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(88928);
                imageView.setImageResource(i);
                imageView.setColorFilter(i2, Mode.SRC_IN);
                AppMethodBeat.m2505o(88928);
            }
        });
        AppMethodBeat.m2505o(88935);
    }

    /* renamed from: a */
    public static void m84645a(MMActivity mMActivity, C42837b c42837b) {
        AppMethodBeat.m2504i(88936);
        mMActivity.mo17446xE(C38736l.m65701Hn(c42837b.aZV().color));
        AppMethodBeat.m2505o(88936);
    }

    /* renamed from: d */
    public static void m84647d(MMActivity mMActivity) {
        AppMethodBeat.m2504i(88937);
        mMActivity.mo17446xE(mMActivity.getResources().getColor(C25738R.color.a69));
        AppMethodBeat.m2505o(88937);
    }

    /* renamed from: c */
    public static void m84646c(TextView textView, int i) {
        AppMethodBeat.m2504i(88938);
        switch (i) {
            case 0:
                textView.setText(C25738R.string.ahx);
                AppMethodBeat.m2505o(88938);
                return;
            case 1:
                textView.setText(C25738R.string.ahs);
                AppMethodBeat.m2505o(88938);
                return;
            case 2:
                textView.setText(C25738R.string.ahv);
                AppMethodBeat.m2505o(88938);
                return;
            case 3:
                textView.setText(C25738R.string.ahu);
                AppMethodBeat.m2505o(88938);
                return;
            case 4:
                textView.setText(C25738R.string.ahy);
                AppMethodBeat.m2505o(88938);
                return;
            case 5:
                textView.setText(C25738R.string.ahz);
                AppMethodBeat.m2505o(88938);
                return;
            case 6:
                textView.setText(C25738R.string.aht);
                AppMethodBeat.m2505o(88938);
                return;
            case 7:
                textView.setText(C25738R.string.ahw);
                break;
        }
        AppMethodBeat.m2505o(88938);
    }

    /* renamed from: a */
    public static void m84642a(View view, LinearLayout linearLayout) {
        AppMethodBeat.m2504i(88939);
        view.setLayoutParams(new LayoutParams(-1, -2));
        linearLayout.addView(view);
        AppMethodBeat.m2505o(88939);
    }
}
