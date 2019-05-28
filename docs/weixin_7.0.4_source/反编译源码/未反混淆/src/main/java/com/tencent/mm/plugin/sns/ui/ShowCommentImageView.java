package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.lang.reflect.Field;

public class ShowCommentImageView extends ImageView {
    private static Bitmap rmU;
    private static Bitmap rmV;
    private static Field rmW;
    private static Field rmX;
    private static boolean rmY = false;
    private boolean rmT = false;

    public ShowCommentImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(38572);
        init();
        AppMethodBeat.o(38572);
    }

    public ShowCommentImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(38573);
        init();
        AppMethodBeat.o(38573);
    }

    private static void init() {
        AppMethodBeat.i(38574);
        if (rmW == null || rmX == null) {
            try {
                rmW = View.class.getDeclaredField("mDrawingCache");
                rmX = View.class.getDeclaredField("mUnscaledDrawingCache");
                rmW.setAccessible(true);
                rmX.setAccessible(true);
                rmY = true;
                AppMethodBeat.o(38574);
                return;
            } catch (Exception e) {
                ab.e("MicroMsg.ShowCommentImageView", "init error: %s", e.getMessage());
                rmY = false;
                AppMethodBeat.o(38574);
                return;
            }
        }
        AppMethodBeat.o(38574);
    }

    public void buildDrawingCache(boolean z) {
        AppMethodBeat.i(38575);
        if (rmY) {
            if (this.rmT) {
                J(z, true);
            } else if (lf(z)) {
                super.buildDrawingCache(z);
                AppMethodBeat.o(38575);
                return;
            } else {
                Bitmap bitmap = z ? rmV : rmU;
                if (bitmap == null || bitmap.isRecycled()) {
                    Field field;
                    boolean z2;
                    super.buildDrawingCache(z);
                    if (z) {
                        try {
                            field = rmW;
                        } catch (Exception e) {
                            ab.e("MicroMsg.ShowCommentImageView", "getStaticDrawingCache error: %s", e.getMessage());
                            AppMethodBeat.o(38575);
                            return;
                        }
                    }
                    field = rmX;
                    bitmap = (Bitmap) field.get(this);
                    String str = "MicroMsg.ShowCommentImageView";
                    String str2 = "getStaticDrawingCache, autoScale: %s, cache==null: %s";
                    Object[] objArr = new Object[2];
                    objArr[0] = Boolean.valueOf(z);
                    if (bitmap == null) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    objArr[1] = Boolean.valueOf(z2);
                    ab.d(str, str2, objArr);
                    if (bitmap != null) {
                        if (z) {
                            rmV = bitmap;
                            AppMethodBeat.o(38575);
                            return;
                        }
                        rmU = bitmap;
                    }
                    AppMethodBeat.o(38575);
                    return;
                }
                J(z, false);
                AppMethodBeat.o(38575);
                return;
            }
        }
        super.buildDrawingCache(z);
        AppMethodBeat.o(38575);
    }

    private boolean lf(boolean z) {
        AppMethodBeat.i(38576);
        if (rmY) {
            Field field;
            if (z) {
                try {
                    field = rmW;
                } catch (Exception e) {
                    ab.printErrStackTrace("MicroMsg.ShowCommentImageView", e, "", new Object[0]);
                    ab.e("MicroMsg.ShowCommentImageView", "checkIfCanReuseDrawingCache error: %s", e.getMessage());
                    AppMethodBeat.o(38576);
                    return false;
                }
            }
            field = rmX;
            if (((Bitmap) field.get(this)) != null) {
                AppMethodBeat.o(38576);
                return true;
            }
            AppMethodBeat.o(38576);
            return false;
        }
        AppMethodBeat.o(38576);
        return false;
    }

    private void J(boolean z, boolean z2) {
        Field field;
        AppMethodBeat.i(38577);
        if (z) {
            try {
                field = rmW;
            } catch (Exception e) {
                ab.e("MicroMsg.ShowCommentImageView", "setDrawingCache error: %s", e.getMessage());
                AppMethodBeat.o(38577);
                return;
            }
        }
        field = rmX;
        if (z2) {
            field.set(this, null);
            AppMethodBeat.o(38577);
            return;
        }
        Object obj;
        boolean z3;
        if (z) {
            obj = rmV;
        } else {
            Bitmap obj2 = rmU;
        }
        String str = "MicroMsg.ShowCommentImageView";
        String str2 = "setDrawingCache, autoScale: %s, cache==null: %s";
        Object[] objArr = new Object[2];
        objArr[0] = Boolean.valueOf(z);
        if (obj2 == null) {
            z3 = true;
        } else {
            z3 = false;
        }
        objArr[1] = Boolean.valueOf(z3);
        ab.d(str, str2, objArr);
        if (obj2 != null) {
            field.set(this, obj2);
        }
        AppMethodBeat.o(38577);
    }

    public void destroyDrawingCache() {
        AppMethodBeat.i(38579);
        super.destroyDrawingCache();
        AppMethodBeat.o(38579);
    }

    public void setOnClickListener(final OnClickListener onClickListener) {
        AppMethodBeat.i(38580);
        super.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(38570);
                ShowCommentImageView.this.rmT = true;
                onClickListener.onClick(view);
                AppMethodBeat.o(38570);
            }
        });
        AppMethodBeat.o(38580);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(38581);
        if (motionEvent.getAction() == 3 || motionEvent.getAction() == 1) {
            postDelayed(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(38571);
                    ShowCommentImageView.this.rmT = false;
                    AppMethodBeat.o(38571);
                }
            }, 100);
        } else {
            this.rmT = true;
        }
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        AppMethodBeat.o(38581);
        return onTouchEvent;
    }

    /* Access modifiers changed, original: protected */
    public void onDetachedFromWindow() {
        AppMethodBeat.i(38578);
        try {
            rmW.set(this, null);
            rmX.set(this, null);
        } catch (Exception e) {
            ab.e("MicroMsg.ShowCommentImageView", "setDrawingCache error: %s", e.getMessage());
        }
        super.onDetachedFromWindow();
        AppMethodBeat.o(38578);
    }
}
