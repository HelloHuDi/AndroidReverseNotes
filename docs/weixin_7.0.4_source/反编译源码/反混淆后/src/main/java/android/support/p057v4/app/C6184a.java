package android.support.p057v4.app;

import android.app.Activity;
import android.app.SharedElementCallback;
import android.app.SharedElementCallback.OnSharedElementsReadyListener;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.support.p057v4.app.C0324ac.C0323a;
import android.support.p057v4.content.C0380b;
import android.view.View;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import java.util.List;
import java.util.Map;

/* renamed from: android.support.v4.app.a */
public final class C6184a extends C0380b {
    /* renamed from: BP */
    private static C0316b f1748BP;

    /* renamed from: android.support.v4.app.a$a */
    public interface C0315a {
        void onRequestPermissionsResult(int i, String[] strArr, int[] iArr);
    }

    /* renamed from: android.support.v4.app.a$b */
    public interface C0316b {
        /* renamed from: de */
        boolean mo507de();

        /* renamed from: df */
        boolean mo508df();
    }

    /* renamed from: android.support.v4.app.a$c */
    public interface C0317c {
        void validateRequestPermissionsRequestCode(int i);
    }

    /* renamed from: android.support.v4.app.a$d */
    static class C0318d extends SharedElementCallback {
        /* renamed from: BR */
        protected C0324ac f265BR;

        C0318d(C0324ac c0324ac) {
            this.f265BR = c0324ac;
        }

        public void onSharedElementStart(List<String> list, List<View> list2, List<View> list3) {
        }

        public void onSharedElementEnd(List<String> list, List<View> list2, List<View> list3) {
        }

        public void onRejectSharedElements(List<View> list) {
        }

        public void onMapSharedElements(List<String> list, Map<String, View> map) {
        }

        public Parcelable onCaptureSharedElementSnapshot(View view, Matrix matrix, RectF rectF) {
            C0324ac c0324ac = this.f265BR;
            if (view instanceof ImageView) {
                ImageView imageView = (ImageView) view;
                Drawable drawable = imageView.getDrawable();
                Drawable background = imageView.getBackground();
                if (drawable != null && background == null) {
                    Bitmap a = C0324ac.m516a(drawable);
                    if (a != null) {
                        Bundle bundle = new Bundle();
                        bundle.putParcelable("sharedElement:snapshot:bitmap", a);
                        bundle.putString("sharedElement:snapshot:imageScaleType", imageView.getScaleType().toString());
                        if (imageView.getScaleType() == ScaleType.MATRIX) {
                            float[] fArr = new float[9];
                            imageView.getImageMatrix().getValues(fArr);
                            bundle.putFloatArray("sharedElement:snapshot:imageMatrix", fArr);
                        }
                        return bundle;
                    }
                }
            }
            int round = Math.round(rectF.width());
            int round2 = Math.round(rectF.height());
            if (round <= 0 || round2 <= 0) {
                return null;
            }
            float min = Math.min(1.0f, ((float) C0324ac.f280Gd) / ((float) (round * round2)));
            round = (int) (((float) round) * min);
            round2 = (int) (((float) round2) * min);
            if (c0324ac.f281ya == null) {
                c0324ac.f281ya = new Matrix();
            }
            c0324ac.f281ya.set(matrix);
            c0324ac.f281ya.postTranslate(-rectF.left, -rectF.top);
            c0324ac.f281ya.postScale(min, min);
            Parcelable createBitmap = Bitmap.createBitmap(round, round2, Config.ARGB_8888);
            Canvas canvas = new Canvas(createBitmap);
            canvas.concat(c0324ac.f281ya);
            view.draw(canvas);
            return createBitmap;
        }

        public View onCreateSnapshotView(Context context, Parcelable parcelable) {
            return C0324ac.onCreateSnapshotView(context, parcelable);
        }
    }

    /* renamed from: android.support.v4.app.a$e */
    static class C6183e extends C0318d {
        C6183e(C0324ac c0324ac) {
            super(c0324ac);
        }

        public final void onSharedElementsArrived(List<String> list, List<View> list2, final OnSharedElementsReadyListener onSharedElementsReadyListener) {
            C0324ac.m517a(new C0323a() {
                public final void onSharedElementsReady() {
                    onSharedElementsReadyListener.onSharedElementsReady();
                }
            });
        }
    }

    /* renamed from: dd */
    public static C0316b m9886dd() {
        return f1748BP;
    }

    /* renamed from: a */
    public static void m9877a(Activity activity, Intent intent, int i, Bundle bundle) {
        if (VERSION.SDK_INT >= 16) {
            activity.startActivityForResult(intent, i, bundle);
        } else {
            activity.startActivityForResult(intent, i);
        }
    }

    /* renamed from: a */
    public static void m9878a(Activity activity, IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4, Bundle bundle) {
        if (VERSION.SDK_INT >= 16) {
            activity.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4, bundle);
        } else {
            activity.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4);
        }
    }

    /* renamed from: b */
    public static void m9882b(Activity activity) {
        if (VERSION.SDK_INT >= 16) {
            activity.finishAffinity();
        } else {
            activity.finish();
        }
    }

    /* renamed from: c */
    public static void m9884c(Activity activity) {
        if (VERSION.SDK_INT >= 21) {
            activity.finishAfterTransition();
        } else {
            activity.finish();
        }
    }

    /* renamed from: a */
    public static void m9879a(Activity activity, C0324ac c0324ac) {
        SharedElementCallback sharedElementCallback = null;
        if (VERSION.SDK_INT >= 23) {
            if (c0324ac != null) {
                sharedElementCallback = new C6183e(c0324ac);
            }
            activity.setEnterSharedElementCallback(sharedElementCallback);
        } else if (VERSION.SDK_INT >= 21) {
            if (c0324ac != null) {
                sharedElementCallback = new C0318d(c0324ac);
            }
            activity.setEnterSharedElementCallback(sharedElementCallback);
        }
    }

    /* renamed from: b */
    public static void m9883b(Activity activity, C0324ac c0324ac) {
        SharedElementCallback sharedElementCallback = null;
        if (VERSION.SDK_INT >= 23) {
            if (c0324ac != null) {
                sharedElementCallback = new C6183e(c0324ac);
            }
            activity.setExitSharedElementCallback(sharedElementCallback);
        } else if (VERSION.SDK_INT >= 21) {
            if (c0324ac != null) {
                sharedElementCallback = new C0318d(c0324ac);
            }
            activity.setExitSharedElementCallback(sharedElementCallback);
        }
    }

    /* renamed from: d */
    public static void m9885d(Activity activity) {
        if (VERSION.SDK_INT >= 21) {
            activity.postponeEnterTransition();
        }
    }

    /* renamed from: e */
    public static void m9887e(Activity activity) {
        if (VERSION.SDK_INT >= 21) {
            activity.startPostponedEnterTransition();
        }
    }

    /* renamed from: a */
    public static void m9880a(final Activity activity, final String[] strArr, final int i) {
        if (f1748BP != null && f1748BP.mo507de()) {
            return;
        }
        if (VERSION.SDK_INT >= 23) {
            if (activity instanceof C0317c) {
                ((C0317c) activity).validateRequestPermissionsRequestCode(i);
            }
            activity.requestPermissions(strArr, i);
        } else if (activity instanceof C0315a) {
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                public final void run() {
                    int[] iArr = new int[strArr.length];
                    PackageManager packageManager = activity.getPackageManager();
                    String packageName = activity.getPackageName();
                    int length = strArr.length;
                    for (int i = 0; i < length; i++) {
                        iArr[i] = packageManager.checkPermission(strArr[i], packageName);
                    }
                    ((C0315a) activity).onRequestPermissionsResult(i, strArr, iArr);
                }
            });
        }
    }

    /* renamed from: a */
    public static boolean m9881a(Activity activity, String str) {
        if (VERSION.SDK_INT >= 23) {
            return activity.shouldShowRequestPermissionRationale(str);
        }
        return false;
    }
}
