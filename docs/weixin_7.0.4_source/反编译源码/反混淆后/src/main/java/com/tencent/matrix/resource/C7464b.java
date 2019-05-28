package com.tencent.matrix.resource;

import android.app.Activity;
import android.app.Application;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import com.tencent.matrix.p155b.C1061c;
import com.tencent.matrix.p155b.C6283b;
import com.tencent.matrix.p157d.C1070c;
import com.tencent.matrix.resource.p163b.C1099a;
import com.tencent.matrix.resource.p169e.C1116a;
import com.tencent.matrix.resource.p169e.C7465b;
import java.lang.reflect.Field;

/* renamed from: com.tencent.matrix.resource.b */
public class C7464b extends C6283b {
    public final C1099a bWQ;
    private C7465b bWR = null;

    /* renamed from: com.tencent.matrix.resource.b$1 */
    static class C62861 extends C1116a {
        C62861() {
        }

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
                                    C1070c.m2368i("Matrix.ActivityLeakFixer", "fixInputMethodManagerLeak break, context is not suitable, get_context=" + view.getContext() + " dest_context=" + activity, new Object[0]);
                                    break;
                                }
                                declaredField.set(inputMethodManager, null);
                            } else {
                                continue;
                            }
                        } catch (Throwable th) {
                            C1070c.m2367e("Matrix.ActivityLeakFixer", "failed to fix InputMethodManagerLeak, %s", th.toString());
                        }
                    }
                }
            }
            C1070c.m2368i("Matrix.ActivityLeakFixer", "fixInputMethodManagerLeak done, cost: %s ms.", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            currentTimeMillis = System.currentTimeMillis();
            if (activity == null || activity.getWindow() == null || activity.getWindow().peekDecorView() == null) {
                C1070c.m2368i("Matrix.ActivityLeakFixer", "unbindDrawables, ui or ui's window is null, skip rest works.", new Object[0]);
            } else {
                View rootView = activity.getWindow().peekDecorView().getRootView();
                try {
                    C1096a.m2412cc(rootView);
                    if (rootView instanceof ViewGroup) {
                        ((ViewGroup) rootView).removeAllViews();
                    }
                } catch (Throwable th2) {
                    C1070c.m2370w("Matrix.ActivityLeakFixer", "caught unexpected exception when unbind drawables.", th2);
                }
            }
            C1070c.m2368i("Matrix.ActivityLeakFixer", "unbindDrawables done, cost: %s ms.", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        }
    }

    public C7464b(C1099a c1099a) {
        this.bWQ = c1099a;
    }

    /* renamed from: a */
    public static void m12830a(Application application) {
        application.registerActivityLifecycleCallbacks(new C62861());
    }

    public void init(Application application, C1061c c1061c) {
        super.init(application, c1061c);
        if (VERSION.SDK_INT < 14) {
            C1070c.m2367e("Matrix.ResourcePlugin", "API is low Build.VERSION_CODES.ICE_CREAM_SANDWICH(14), ResourcePlugin is not supported", new Object[0]);
            unSupportPlugin();
            return;
        }
        this.bWR = new C7465b(application, this);
    }

    public void start() {
        super.start();
        if (isSupported()) {
            C7465b c7465b = this.bWR;
            c7465b.mo16642zp();
            Application application = c7465b.bXR.getApplication();
            if (application != null) {
                application.registerActivityLifecycleCallbacks(c7465b.bXZ);
                c7465b.bXS.mo4349a(c7465b.bYa, 0);
                C1070c.m2368i("Matrix.ActivityRefWatcher", "watcher is started.", new Object[0]);
                return;
            }
            return;
        }
        C1070c.m2367e("Matrix.ResourcePlugin", "ResourcePlugin start, ResourcePlugin is not supported, just return", new Object[0]);
    }

    public void stop() {
        super.stop();
        if (isSupported()) {
            this.bWR.mo16642zp();
            C1070c.m2368i("Matrix.ActivityRefWatcher", "watcher is stopped.", new Object[0]);
            return;
        }
        C1070c.m2367e("Matrix.ResourcePlugin", "ResourcePlugin stop, ResourcePlugin is not supported, just return", new Object[0]);
    }

    public void destroy() {
        super.destroy();
        if (isSupported()) {
            this.bWR.bXS.mo4350zu();
            C1070c.m2368i("Matrix.ActivityRefWatcher", "watcher is destroyed.", new Object[0]);
            return;
        }
        C1070c.m2367e("Matrix.ResourcePlugin", "ResourcePlugin destroy, ResourcePlugin is not supported, just return", new Object[0]);
    }

    public String getTag() {
        return "memory";
    }
}
