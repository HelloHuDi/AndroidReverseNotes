package android.support.v4.app;

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
import android.view.View;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import java.util.List;
import java.util.Map;

public final class a extends android.support.v4.content.b {
    private static b BP;

    public interface a {
        void onRequestPermissionsResult(int i, String[] strArr, int[] iArr);
    }

    public interface b {
        boolean de();

        boolean df();
    }

    public interface c {
        void validateRequestPermissionsRequestCode(int i);
    }

    static class d extends SharedElementCallback {
        protected ac BR;

        d(ac acVar) {
            this.BR = acVar;
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
            ac acVar = this.BR;
            if (view instanceof ImageView) {
                ImageView imageView = (ImageView) view;
                Drawable drawable = imageView.getDrawable();
                Drawable background = imageView.getBackground();
                if (drawable != null && background == null) {
                    Bitmap a = ac.a(drawable);
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
            float min = Math.min(1.0f, ((float) ac.Gd) / ((float) (round * round2)));
            round = (int) (((float) round) * min);
            round2 = (int) (((float) round2) * min);
            if (acVar.ya == null) {
                acVar.ya = new Matrix();
            }
            acVar.ya.set(matrix);
            acVar.ya.postTranslate(-rectF.left, -rectF.top);
            acVar.ya.postScale(min, min);
            Parcelable createBitmap = Bitmap.createBitmap(round, round2, Config.ARGB_8888);
            Canvas canvas = new Canvas(createBitmap);
            canvas.concat(acVar.ya);
            view.draw(canvas);
            return createBitmap;
        }

        public View onCreateSnapshotView(Context context, Parcelable parcelable) {
            return ac.onCreateSnapshotView(context, parcelable);
        }
    }

    static class e extends d {
        e(ac acVar) {
            super(acVar);
        }

        public final void onSharedElementsArrived(List<String> list, List<View> list2, final OnSharedElementsReadyListener onSharedElementsReadyListener) {
            ac.a(new android.support.v4.app.ac.a() {
                public final void onSharedElementsReady() {
                    onSharedElementsReadyListener.onSharedElementsReady();
                }
            });
        }
    }

    public static b dd() {
        return BP;
    }

    public static void a(Activity activity, Intent intent, int i, Bundle bundle) {
        if (VERSION.SDK_INT >= 16) {
            activity.startActivityForResult(intent, i, bundle);
        } else {
            activity.startActivityForResult(intent, i);
        }
    }

    public static void a(Activity activity, IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4, Bundle bundle) {
        if (VERSION.SDK_INT >= 16) {
            activity.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4, bundle);
        } else {
            activity.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4);
        }
    }

    public static void b(Activity activity) {
        if (VERSION.SDK_INT >= 16) {
            activity.finishAffinity();
        } else {
            activity.finish();
        }
    }

    public static void c(Activity activity) {
        if (VERSION.SDK_INT >= 21) {
            activity.finishAfterTransition();
        } else {
            activity.finish();
        }
    }

    public static void a(Activity activity, ac acVar) {
        SharedElementCallback sharedElementCallback = null;
        if (VERSION.SDK_INT >= 23) {
            if (acVar != null) {
                sharedElementCallback = new e(acVar);
            }
            activity.setEnterSharedElementCallback(sharedElementCallback);
        } else if (VERSION.SDK_INT >= 21) {
            if (acVar != null) {
                sharedElementCallback = new d(acVar);
            }
            activity.setEnterSharedElementCallback(sharedElementCallback);
        }
    }

    public static void b(Activity activity, ac acVar) {
        SharedElementCallback sharedElementCallback = null;
        if (VERSION.SDK_INT >= 23) {
            if (acVar != null) {
                sharedElementCallback = new e(acVar);
            }
            activity.setExitSharedElementCallback(sharedElementCallback);
        } else if (VERSION.SDK_INT >= 21) {
            if (acVar != null) {
                sharedElementCallback = new d(acVar);
            }
            activity.setExitSharedElementCallback(sharedElementCallback);
        }
    }

    public static void d(Activity activity) {
        if (VERSION.SDK_INT >= 21) {
            activity.postponeEnterTransition();
        }
    }

    public static void e(Activity activity) {
        if (VERSION.SDK_INT >= 21) {
            activity.startPostponedEnterTransition();
        }
    }

    public static void a(final Activity activity, final String[] strArr, final int i) {
        if (BP != null && BP.de()) {
            return;
        }
        if (VERSION.SDK_INT >= 23) {
            if (activity instanceof c) {
                ((c) activity).validateRequestPermissionsRequestCode(i);
            }
            activity.requestPermissions(strArr, i);
        } else if (activity instanceof a) {
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                public final void run() {
                    int[] iArr = new int[strArr.length];
                    PackageManager packageManager = activity.getPackageManager();
                    String packageName = activity.getPackageName();
                    int length = strArr.length;
                    for (int i = 0; i < length; i++) {
                        iArr[i] = packageManager.checkPermission(strArr[i], packageName);
                    }
                    ((a) activity).onRequestPermissionsResult(i, strArr, iArr);
                }
            });
        }
    }

    public static boolean a(Activity activity, String str) {
        if (VERSION.SDK_INT >= 23) {
            return activity.shouldShowRequestPermissionRationale(str);
        }
        return false;
    }
}
