package com.tencent.mm.plugin.card.d;

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
import com.tencent.mm.R;
import com.tencent.mm.at.a.a.c.a;
import com.tencent.mm.at.a.c.g;
import com.tencent.mm.at.a.d.b;
import com.tencent.mm.at.o;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;

public final class m {

    /* renamed from: com.tencent.mm.plugin.card.d.m$3 */
    public static class AnonymousClass3 implements AnimationListener {
        final /* synthetic */ View krT;
        final /* synthetic */ ScaleAnimation krU;

        public AnonymousClass3(View view, ScaleAnimation scaleAnimation) {
            this.krT = view;
            this.krU = scaleAnimation;
        }

        public final void onAnimationStart(Animation animation) {
        }

        public final void onAnimationRepeat(Animation animation) {
        }

        public final void onAnimationEnd(Animation animation) {
            AppMethodBeat.i(88929);
            this.krT.startAnimation(this.krU);
            AppMethodBeat.o(88929);
        }
    }

    public static Rect dc(View view) {
        AppMethodBeat.i(88930);
        Rect rect = new Rect();
        rect.left = view.getPaddingLeft();
        rect.right = view.getPaddingRight();
        rect.top = view.getPaddingTop();
        rect.bottom = view.getPaddingBottom();
        AppMethodBeat.o(88930);
        return rect;
    }

    public static void k(View view, Rect rect) {
        AppMethodBeat.i(88931);
        view.setPadding(rect.left, rect.top, rect.right, rect.bottom);
        AppMethodBeat.o(88931);
    }

    public static String Hu(String str) {
        AppMethodBeat.i(88932);
        String str2;
        if (bo.isNullOrNil(str)) {
            ab.e("MicroMsg.CardViewUtil", "toApply is null");
            str2 = "";
            AppMethodBeat.o(88932);
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
        AppMethodBeat.o(88932);
        return str2;
    }

    public static void a(ImageView imageView, String str, int i, int i2, boolean z) {
        AppMethodBeat.i(88933);
        if (imageView == null || TextUtils.isEmpty(str)) {
            AppMethodBeat.o(88933);
        } else if (TextUtils.isEmpty(str)) {
            imageView.setImageResource(i2);
            AppMethodBeat.o(88933);
        } else {
            a aVar = new a();
            aVar.ePK = e.eSn;
            o.ahq();
            aVar.ePY = null;
            aVar.ePJ = com.tencent.mm.plugin.card.model.m.Gz(str);
            aVar.ePH = true;
            aVar.eQf = z;
            aVar.ePF = true;
            aVar.ePO = i;
            aVar.ePN = i;
            aVar.ePT = i2;
            o.ahp().a(str, imageView, aVar.ahG());
            AppMethodBeat.o(88933);
        }
    }

    public static void a(final Context context, final ImageView imageView, String str, int i, final int i2) {
        AppMethodBeat.i(88934);
        if (imageView == null || TextUtils.isEmpty(str)) {
            AppMethodBeat.o(88934);
        } else if (TextUtils.isEmpty(str)) {
            a(imageView, R.drawable.azs, i2);
            AppMethodBeat.o(88934);
        } else {
            a aVar = new a();
            aVar.ePK = e.eSn;
            o.ahq();
            aVar.ePY = null;
            aVar.ePJ = com.tencent.mm.plugin.card.model.m.Gz(str);
            aVar.ePH = true;
            aVar.eQf = false;
            aVar.ePF = true;
            aVar.ePO = i;
            aVar.ePN = i;
            aVar.ePT = R.drawable.azs;
            o.ahp().a(str, imageView, aVar.ahG(), new g() {
                final /* synthetic */ int krQ = R.drawable.azs;

                public final void sH(String str) {
                }

                public final Bitmap a(String str, View view, b bVar) {
                    return null;
                }

                public final void b(String str, View view, b bVar) {
                    AppMethodBeat.i(88927);
                    if (bVar.bitmap != null) {
                        final Bitmap bitmap = bVar.bitmap;
                        al.d(new Runnable() {
                            public final void run() {
                                AppMethodBeat.i(88926);
                                imageView.setImageBitmap(bitmap);
                                imageView.setColorFilter(i2, Mode.SRC_IN);
                                AppMethodBeat.o(88926);
                            }
                        });
                        AppMethodBeat.o(88927);
                        return;
                    }
                    m.a(imageView, this.krQ, i2);
                    AppMethodBeat.o(88927);
                }
            });
            AppMethodBeat.o(88934);
        }
    }

    public static void a(final ImageView imageView, final int i, final int i2) {
        AppMethodBeat.i(88935);
        al.d(new Runnable() {
            public final void run() {
                AppMethodBeat.i(88928);
                imageView.setImageResource(i);
                imageView.setColorFilter(i2, Mode.SRC_IN);
                AppMethodBeat.o(88928);
            }
        });
        AppMethodBeat.o(88935);
    }

    public static void a(MMActivity mMActivity, com.tencent.mm.plugin.card.base.b bVar) {
        AppMethodBeat.i(88936);
        mMActivity.xE(l.Hn(bVar.aZV().color));
        AppMethodBeat.o(88936);
    }

    public static void d(MMActivity mMActivity) {
        AppMethodBeat.i(88937);
        mMActivity.xE(mMActivity.getResources().getColor(R.color.a69));
        AppMethodBeat.o(88937);
    }

    public static void c(TextView textView, int i) {
        AppMethodBeat.i(88938);
        switch (i) {
            case 0:
                textView.setText(R.string.ahx);
                AppMethodBeat.o(88938);
                return;
            case 1:
                textView.setText(R.string.ahs);
                AppMethodBeat.o(88938);
                return;
            case 2:
                textView.setText(R.string.ahv);
                AppMethodBeat.o(88938);
                return;
            case 3:
                textView.setText(R.string.ahu);
                AppMethodBeat.o(88938);
                return;
            case 4:
                textView.setText(R.string.ahy);
                AppMethodBeat.o(88938);
                return;
            case 5:
                textView.setText(R.string.ahz);
                AppMethodBeat.o(88938);
                return;
            case 6:
                textView.setText(R.string.aht);
                AppMethodBeat.o(88938);
                return;
            case 7:
                textView.setText(R.string.ahw);
                break;
        }
        AppMethodBeat.o(88938);
    }

    public static void a(View view, LinearLayout linearLayout) {
        AppMethodBeat.i(88939);
        view.setLayoutParams(new LayoutParams(-1, -2));
        linearLayout.addView(view);
        AppMethodBeat.o(88939);
    }
}
