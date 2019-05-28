package android.support.v4.view.a;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import java.util.List;

public class c {
    public final Object Oo;

    static class a extends AccessibilityNodeProvider {
        final c Op;

        a(c cVar) {
            this.Op = cVar;
        }

        public AccessibilityNodeInfo createAccessibilityNodeInfo(int i) {
            b aL = this.Op.aL(i);
            if (aL == null) {
                return null;
            }
            return aL.NG;
        }

        public List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText(String str, int i) {
            return null;
        }

        public boolean performAction(int i, int i2, Bundle bundle) {
            return this.Op.performAction(i, i2, bundle);
        }
    }

    static class b extends a {
        b(c cVar) {
            super(cVar);
        }

        public final AccessibilityNodeInfo findFocus(int i) {
            b aM = this.Op.aM(i);
            if (aM == null) {
                return null;
            }
            return aM.NG;
        }
    }

    public c() {
        if (VERSION.SDK_INT >= 19) {
            this.Oo = new b(this);
        } else if (VERSION.SDK_INT >= 16) {
            this.Oo = new a(this);
        } else {
            this.Oo = null;
        }
    }

    public c(Object obj) {
        this.Oo = obj;
    }

    public b aL(int i) {
        return null;
    }

    public boolean performAction(int i, int i2, Bundle bundle) {
        return false;
    }

    public b aM(int i) {
        return null;
    }
}
