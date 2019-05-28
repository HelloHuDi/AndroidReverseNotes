package android.support.p057v4.view.p067a;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import java.util.List;

/* renamed from: android.support.v4.view.a.c */
public class C0447c {
    /* renamed from: Oo */
    public final Object f549Oo;

    /* renamed from: android.support.v4.view.a.c$a */
    static class C0446a extends AccessibilityNodeProvider {
        /* renamed from: Op */
        final C0447c f548Op;

        C0446a(C0447c c0447c) {
            this.f548Op = c0447c;
        }

        public AccessibilityNodeInfo createAccessibilityNodeInfo(int i) {
            C0445b aL = this.f548Op.mo1018aL(i);
            if (aL == null) {
                return null;
            }
            return aL.f546NG;
        }

        public List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText(String str, int i) {
            return null;
        }

        public boolean performAction(int i, int i2, Bundle bundle) {
            return this.f548Op.performAction(i, i2, bundle);
        }
    }

    /* renamed from: android.support.v4.view.a.c$b */
    static class C0448b extends C0446a {
        C0448b(C0447c c0447c) {
            super(c0447c);
        }

        public final AccessibilityNodeInfo findFocus(int i) {
            C0445b aM = this.f548Op.mo1019aM(i);
            if (aM == null) {
                return null;
            }
            return aM.f546NG;
        }
    }

    public C0447c() {
        if (VERSION.SDK_INT >= 19) {
            this.f549Oo = new C0448b(this);
        } else if (VERSION.SDK_INT >= 16) {
            this.f549Oo = new C0446a(this);
        } else {
            this.f549Oo = null;
        }
    }

    public C0447c(Object obj) {
        this.f549Oo = obj;
    }

    /* renamed from: aL */
    public C0445b mo1018aL(int i) {
        return null;
    }

    public boolean performAction(int i, int i2, Bundle bundle) {
        return false;
    }

    /* renamed from: aM */
    public C0445b mo1019aM(int i) {
        return null;
    }
}
