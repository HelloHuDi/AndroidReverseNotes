package com.tencent.p177mm.plugin.remittance.bankcard.p496ui;

import android.app.Activity;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import com.facebook.internal.Utility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.wallet_core.p650ui.WalletBaseUI;
import java.lang.reflect.Field;

/* renamed from: com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitBaseUI */
public abstract class BankRemitBaseUI extends WalletBaseUI {

    /* renamed from: com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitBaseUI$1 */
    class C37181 implements OnMenuItemClickListener {
        C37181() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(44587);
            if (BankRemitBaseUI.this.cNR()) {
                BankRemitBaseUI.this.aqX();
                BankRemitBaseUI.this.showDialog(1000);
            } else {
                BankRemitBaseUI.this.finish();
            }
            AppMethodBeat.m2505o(44587);
            return true;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        bFY();
        setBackBtn(new C37181());
    }

    /* Access modifiers changed, original: protected */
    public void bFY() {
        C4990ab.m7417i("BankRemitBase", "ret: %s", Integer.valueOf(BankRemitBaseUI.m6024Y(this)));
    }

    /* renamed from: Y */
    public static int m6024Y(Activity activity) {
        if (VERSION.SDK_INT < 19) {
            return 0;
        }
        if (VERSION.SDK_INT >= 23) {
            activity.getWindow().getDecorView().setSystemUiVisibility(Utility.DEFAULT_STREAM_BUFFER_SIZE);
            return 3;
        } else if (BankRemitBaseUI.m6025Z(activity)) {
            return 1;
        } else {
            if (BankRemitBaseUI.m6027d(activity.getWindow())) {
                return 2;
            }
            return 0;
        }
    }

    /* renamed from: d */
    private static boolean m6027d(Window window) {
        if (window != null) {
            try {
                LayoutParams attributes = window.getAttributes();
                Field declaredField = LayoutParams.class.getDeclaredField("MEIZU_FLAG_DARK_STATUS_BAR_ICON");
                Field declaredField2 = LayoutParams.class.getDeclaredField("meizuFlags");
                declaredField.setAccessible(true);
                declaredField2.setAccessible(true);
                declaredField2.setInt(attributes, declaredField.getInt(null) | declaredField2.getInt(attributes));
                window.setAttributes(attributes);
                return true;
            } catch (Exception e) {
            }
        }
        return false;
    }

    /* renamed from: Z */
    private static boolean m6025Z(Activity activity) {
        Window window = activity.getWindow();
        if (window == null) {
            return false;
        }
        Class cls = window.getClass();
        try {
            Class cls2 = Class.forName("android.view.MiuiWindowManager$LayoutParams");
            int i = cls2.getField("EXTRA_FLAG_STATUS_BAR_DARK_MODE").getInt(cls2);
            cls.getMethod("setExtraFlags", new Class[]{Integer.TYPE, Integer.TYPE}).invoke(window, new Object[]{Integer.valueOf(i), Integer.valueOf(i)});
            try {
                if (VERSION.SDK_INT < 23) {
                    return true;
                }
                activity.getWindow().getDecorView().setSystemUiVisibility(Utility.DEFAULT_STREAM_BUFFER_SIZE);
                return true;
            } catch (Exception e) {
                return true;
            }
        } catch (Exception e2) {
            return false;
        }
    }
}
