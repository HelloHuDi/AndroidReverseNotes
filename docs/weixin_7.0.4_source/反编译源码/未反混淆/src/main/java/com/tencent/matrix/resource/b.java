package com.tencent.matrix.resource;

import android.app.Activity;
import android.app.Application;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import com.tencent.matrix.d.c;
import com.tencent.matrix.resource.b.a;
import java.lang.reflect.Field;

public class b extends com.tencent.matrix.b.b {
    public final a bWQ;
    private com.tencent.matrix.resource.e.b bWR = null;

    public b(a aVar) {
        this.bWQ = aVar;
    }

    public static void a(Application application) {
        application.registerActivityLifecycleCallbacks(new com.tencent.matrix.resource.e.a() {
            public final void onActivityDestroyed(Activity activity) {
                long currentTimeMillis = System.currentTimeMillis();
                if (activity != null) {
                    InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService("input_method");
                    if (inputMethodManager != null) {
                        String[] strArr = new String[]{"mCurRootView", "mServedView", "mNextServedView"};
                        for (int i = 0; i < 3; i++) {
                            try {
                                Field declaredField = inputMethodManager.getClass().getDeclaredField(strArr[i]);
                                if (!declaredField.isAccessible()) {
                                    declaredField.setAccessible(true);
                                }
                                Object obj = declaredField.get(inputMethodManager);
                                if (obj instanceof View) {
                                    View view = (View) obj;
                                    if (view.getContext() != activity) {
                                        c.i("Matrix.ActivityLeakFixer", "fixInputMethodManagerLeak break, context is not suitable, get_context=" + view.getContext() + " dest_context=" + activity, new Object[0]);
                                        break;
                                    }
                                    declaredField.set(inputMethodManager, null);
                                } else {
                                    continue;
                                }
                            } catch (Throwable th) {
                                c.e("Matrix.ActivityLeakFixer", "failed to fix InputMethodManagerLeak, %s", th.toString());
                            }
                        }
                    }
                }
                c.i("Matrix.ActivityLeakFixer", "fixInputMethodManagerLeak done, cost: %s ms.", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                currentTimeMillis = System.currentTimeMillis();
                if (activity == null || activity.getWindow() == null || activity.getWindow().peekDecorView() == null) {
                    c.i("Matrix.ActivityLeakFixer", "unbindDrawables, ui or ui's window is null, skip rest works.", new Object[0]);
                } else {
                    View rootView = activity.getWindow().peekDecorView().getRootView();
                    try {
                        a.cc(rootView);
                        if (rootView instanceof ViewGroup) {
                            ((ViewGroup) rootView).removeAllViews();
                        }
                    } catch (Throwable th2) {
                        c.w("Matrix.ActivityLeakFixer", "caught unexpected exception when unbind drawables.", th2);
                    }
                }
                c.i("Matrix.ActivityLeakFixer", "unbindDrawables done, cost: %s ms.", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            }
        });
    }

    public void init(Application application, com.tencent.matrix.b.c cVar) {
        super.init(application, cVar);
        if (VERSION.SDK_INT < 14) {
            c.e("Matrix.ResourcePlugin", "API is low Build.VERSION_CODES.ICE_CREAM_SANDWICH(14), ResourcePlugin is not supported", new Object[0]);
            unSupportPlugin();
            return;
        }
        this.bWR = new com.tencent.matrix.resource.e.b(application, this);
    }

    public void start() {
        super.start();
        if (isSupported()) {
            com.tencent.matrix.resource.e.b bVar = this.bWR;
            bVar.zp();
            Application application = bVar.bXR.getApplication();
            if (application != null) {
                application.registerActivityLifecycleCallbacks(bVar.bXZ);
                bVar.bXS.a(bVar.bYa, 0);
                c.i("Matrix.ActivityRefWatcher", "watcher is started.", new Object[0]);
                return;
            }
            return;
        }
        c.e("Matrix.ResourcePlugin", "ResourcePlugin start, ResourcePlugin is not supported, just return", new Object[0]);
    }

    public void stop() {
        super.stop();
        if (isSupported()) {
            this.bWR.zp();
            c.i("Matrix.ActivityRefWatcher", "watcher is stopped.", new Object[0]);
            return;
        }
        c.e("Matrix.ResourcePlugin", "ResourcePlugin stop, ResourcePlugin is not supported, just return", new Object[0]);
    }

    public void destroy() {
        super.destroy();
        if (isSupported()) {
            this.bWR.bXS.zu();
            c.i("Matrix.ActivityRefWatcher", "watcher is destroyed.", new Object[0]);
            return;
        }
        c.e("Matrix.ResourcePlugin", "ResourcePlugin destroy, ResourcePlugin is not supported, just return", new Object[0]);
    }

    public String getTag() {
        return "memory";
    }
}
