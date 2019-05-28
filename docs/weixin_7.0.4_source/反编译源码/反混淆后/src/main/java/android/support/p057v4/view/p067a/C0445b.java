package android.support.p057v4.view.p067a;

import android.graphics.Rect;
import android.os.Build.VERSION;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction;
import android.view.accessibility.AccessibilityNodeInfo.CollectionItemInfo;
import com.facebook.internal.Utility;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.wcdb.database.SQLiteGlobal;

/* renamed from: android.support.v4.view.a.b */
public final class C0445b {
    /* renamed from: NG */
    public final AccessibilityNodeInfo f546NG;
    /* renamed from: NH */
    public int f547NH = -1;

    /* renamed from: android.support.v4.view.a.b$a */
    public static class C0442a {
        /* renamed from: NI */
        public static final C0442a f513NI = new C0442a(1);
        /* renamed from: NJ */
        public static final C0442a f514NJ = new C0442a(2);
        /* renamed from: NK */
        public static final C0442a f515NK = new C0442a(4);
        /* renamed from: NL */
        public static final C0442a f516NL = new C0442a(8);
        /* renamed from: NM */
        public static final C0442a f517NM = new C0442a(16);
        /* renamed from: NN */
        public static final C0442a f518NN = new C0442a(32);
        /* renamed from: NO */
        public static final C0442a f519NO = new C0442a(64);
        /* renamed from: NP */
        public static final C0442a f520NP = new C0442a(128);
        /* renamed from: NQ */
        public static final C0442a f521NQ = new C0442a(256);
        /* renamed from: NR */
        public static final C0442a f522NR = new C0442a(512);
        /* renamed from: NS */
        public static final C0442a f523NS = new C0442a((int) WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
        /* renamed from: NT */
        public static final C0442a f524NT = new C0442a(2048);
        /* renamed from: NU */
        public static final C0442a f525NU = new C0442a(4096);
        /* renamed from: NV */
        public static final C0442a f526NV = new C0442a((int) Utility.DEFAULT_STREAM_BUFFER_SIZE);
        /* renamed from: NW */
        public static final C0442a f527NW = new C0442a(16384);
        /* renamed from: NX */
        public static final C0442a f528NX = new C0442a(32768);
        /* renamed from: NY */
        public static final C0442a f529NY = new C0442a(65536);
        /* renamed from: NZ */
        public static final C0442a f530NZ = new C0442a((int) WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT);
        /* renamed from: Oa */
        public static final C0442a f531Oa = new C0442a(262144);
        /* renamed from: Ob */
        public static final C0442a f532Ob = new C0442a((int) SQLiteGlobal.journalSizeLimit);
        /* renamed from: Oc */
        public static final C0442a f533Oc = new C0442a(1048576);
        /* renamed from: Od */
        public static final C0442a f534Od = new C0442a(2097152);
        /* renamed from: Oe */
        public static final C0442a f535Oe;
        /* renamed from: Of */
        public static final C0442a f536Of = new C0442a(VERSION.SDK_INT >= 23 ? AccessibilityAction.ACTION_SCROLL_TO_POSITION : null);
        /* renamed from: Og */
        public static final C0442a f537Og;
        /* renamed from: Oh */
        public static final C0442a f538Oh;
        /* renamed from: Oi */
        public static final C0442a f539Oi;
        /* renamed from: Oj */
        public static final C0442a f540Oj;
        /* renamed from: Ok */
        public static final C0442a f541Ok;
        /* renamed from: Ol */
        public static final C0442a f542Ol;
        /* renamed from: Om */
        final Object f543Om;

        static {
            Object obj;
            Object obj2 = null;
            if (VERSION.SDK_INT >= 23) {
                obj = AccessibilityAction.ACTION_SHOW_ON_SCREEN;
            } else {
                obj = null;
            }
            f535Oe = new C0442a(obj);
            if (VERSION.SDK_INT >= 23) {
                obj = AccessibilityAction.ACTION_SCROLL_UP;
            } else {
                obj = null;
            }
            f537Og = new C0442a(obj);
            if (VERSION.SDK_INT >= 23) {
                obj = AccessibilityAction.ACTION_SCROLL_LEFT;
            } else {
                obj = null;
            }
            f538Oh = new C0442a(obj);
            if (VERSION.SDK_INT >= 23) {
                obj = AccessibilityAction.ACTION_SCROLL_DOWN;
            } else {
                obj = null;
            }
            f539Oi = new C0442a(obj);
            if (VERSION.SDK_INT >= 23) {
                obj = AccessibilityAction.ACTION_SCROLL_RIGHT;
            } else {
                obj = null;
            }
            f540Oj = new C0442a(obj);
            if (VERSION.SDK_INT >= 23) {
                obj = AccessibilityAction.ACTION_CONTEXT_CLICK;
            } else {
                obj = null;
            }
            f541Ok = new C0442a(obj);
            if (VERSION.SDK_INT >= 24) {
                obj2 = AccessibilityAction.ACTION_SET_PROGRESS;
            }
            f542Ol = new C0442a(obj2);
        }

        private C0442a(int i) {
            Object accessibilityAction;
            if (VERSION.SDK_INT >= 21) {
                accessibilityAction = new AccessibilityAction(i, null);
            } else {
                accessibilityAction = null;
            }
            this(accessibilityAction);
        }

        private C0442a(Object obj) {
            this.f543Om = obj;
        }
    }

    /* renamed from: android.support.v4.view.a.b$b */
    public static class C0443b {
        /* renamed from: On */
        public final Object f544On;

        public C0443b(Object obj) {
            this.f544On = obj;
        }
    }

    /* renamed from: android.support.v4.view.a.b$c */
    public static class C0444c {
        /* renamed from: On */
        final Object f545On;

        /* renamed from: b */
        public static C0444c m769b(int i, int i2, int i3, int i4, boolean z) {
            if (VERSION.SDK_INT >= 21) {
                return new C0444c(CollectionItemInfo.obtain(i, i2, i3, i4, z, false));
            }
            if (VERSION.SDK_INT >= 19) {
                return new C0444c(CollectionItemInfo.obtain(i, i2, i3, i4, z));
            }
            return new C0444c(null);
        }

        private C0444c(Object obj) {
            this.f545On = obj;
        }
    }

    private C0445b(AccessibilityNodeInfo accessibilityNodeInfo) {
        this.f546NG = accessibilityNodeInfo;
    }

    /* renamed from: a */
    public static C0445b m771a(AccessibilityNodeInfo accessibilityNodeInfo) {
        return new C0445b(accessibilityNodeInfo);
    }

    /* renamed from: a */
    public static C0445b m770a(C0445b c0445b) {
        return C0445b.m771a(AccessibilityNodeInfo.obtain(c0445b.f546NG));
    }

    public final void setSource(View view) {
        this.f546NG.setSource(view);
    }

    public final void addChild(View view) {
        this.f546NG.addChild(view);
    }

    public final void addAction(int i) {
        this.f546NG.addAction(i);
    }

    /* renamed from: a */
    public final boolean mo986a(C0442a c0442a) {
        if (VERSION.SDK_INT >= 21) {
            return this.f546NG.removeAction((AccessibilityAction) c0442a.f543Om);
        }
        return false;
    }

    public final void setParent(View view) {
        this.f546NG.setParent(view);
    }

    public final void getBoundsInParent(Rect rect) {
        this.f546NG.getBoundsInParent(rect);
    }

    public final void setBoundsInParent(Rect rect) {
        this.f546NG.setBoundsInParent(rect);
    }

    public final void getBoundsInScreen(Rect rect) {
        this.f546NG.getBoundsInScreen(rect);
    }

    public final void setBoundsInScreen(Rect rect) {
        this.f546NG.setBoundsInScreen(rect);
    }

    public final void setCheckable(boolean z) {
        this.f546NG.setCheckable(z);
    }

    public final void setFocusable(boolean z) {
        this.f546NG.setFocusable(z);
    }

    public final void setFocused(boolean z) {
        this.f546NG.setFocused(z);
    }

    public final boolean isVisibleToUser() {
        if (VERSION.SDK_INT >= 16) {
            return this.f546NG.isVisibleToUser();
        }
        return false;
    }

    public final void setVisibleToUser(boolean z) {
        if (VERSION.SDK_INT >= 16) {
            this.f546NG.setVisibleToUser(z);
        }
    }

    public final boolean isAccessibilityFocused() {
        if (VERSION.SDK_INT >= 16) {
            return this.f546NG.isAccessibilityFocused();
        }
        return false;
    }

    public final void setAccessibilityFocused(boolean z) {
        if (VERSION.SDK_INT >= 16) {
            this.f546NG.setAccessibilityFocused(z);
        }
    }

    public final void setSelected(boolean z) {
        this.f546NG.setSelected(z);
    }

    public final void setClickable(boolean z) {
        this.f546NG.setClickable(z);
    }

    public final void setLongClickable(boolean z) {
        this.f546NG.setLongClickable(z);
    }

    public final void setEnabled(boolean z) {
        this.f546NG.setEnabled(z);
    }

    public final void setScrollable(boolean z) {
        this.f546NG.setScrollable(z);
    }

    public final void setPackageName(CharSequence charSequence) {
        this.f546NG.setPackageName(charSequence);
    }

    public final void setClassName(CharSequence charSequence) {
        this.f546NG.setClassName(charSequence);
    }

    public final void setText(CharSequence charSequence) {
        this.f546NG.setText(charSequence);
    }

    public final void setContentDescription(CharSequence charSequence) {
        this.f546NG.setContentDescription(charSequence);
    }

    /* renamed from: H */
    public final void mo985H(Object obj) {
        if (VERSION.SDK_INT >= 19) {
            this.f546NG.setCollectionItemInfo((CollectionItemInfo) ((C0444c) obj).f545On);
        }
    }

    public final void setDismissable(boolean z) {
        if (VERSION.SDK_INT >= 19) {
            this.f546NG.setDismissable(z);
        }
    }

    public final int hashCode() {
        return this.f546NG == null ? 0 : this.f546NG.hashCode();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        C0445b c0445b = (C0445b) obj;
        if (this.f546NG == null) {
            if (c0445b.f546NG != null) {
                return false;
            }
            return true;
        } else if (this.f546NG.equals(c0445b.f546NG)) {
            return true;
        } else {
            return false;
        }
    }

    public final String toString() {
        String viewIdResourceName;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.toString());
        Rect rect = new Rect();
        getBoundsInParent(rect);
        stringBuilder.append("; boundsInParent: ".concat(String.valueOf(rect)));
        getBoundsInScreen(rect);
        stringBuilder.append("; boundsInScreen: ".concat(String.valueOf(rect)));
        stringBuilder.append("; packageName: ").append(this.f546NG.getPackageName());
        stringBuilder.append("; className: ").append(this.f546NG.getClassName());
        stringBuilder.append("; text: ").append(this.f546NG.getText());
        stringBuilder.append("; contentDescription: ").append(this.f546NG.getContentDescription());
        StringBuilder append = stringBuilder.append("; viewId: ");
        if (VERSION.SDK_INT >= 18) {
            viewIdResourceName = this.f546NG.getViewIdResourceName();
        } else {
            viewIdResourceName = null;
        }
        append.append(viewIdResourceName);
        stringBuilder.append("; checkable: ").append(this.f546NG.isCheckable());
        stringBuilder.append("; checked: ").append(this.f546NG.isChecked());
        stringBuilder.append("; focusable: ").append(this.f546NG.isFocusable());
        stringBuilder.append("; focused: ").append(this.f546NG.isFocused());
        stringBuilder.append("; selected: ").append(this.f546NG.isSelected());
        stringBuilder.append("; clickable: ").append(this.f546NG.isClickable());
        stringBuilder.append("; longClickable: ").append(this.f546NG.isLongClickable());
        stringBuilder.append("; enabled: ").append(this.f546NG.isEnabled());
        stringBuilder.append("; password: ").append(this.f546NG.isPassword());
        stringBuilder.append("; scrollable: " + this.f546NG.isScrollable());
        stringBuilder.append("; [");
        int actions = this.f546NG.getActions();
        while (actions != 0) {
            int numberOfTrailingZeros = 1 << Integer.numberOfTrailingZeros(actions);
            int i = (numberOfTrailingZeros ^ -1) & actions;
            switch (numberOfTrailingZeros) {
                case 1:
                    viewIdResourceName = "ACTION_FOCUS";
                    break;
                case 2:
                    viewIdResourceName = "ACTION_CLEAR_FOCUS";
                    break;
                case 4:
                    viewIdResourceName = "ACTION_SELECT";
                    break;
                case 8:
                    viewIdResourceName = "ACTION_CLEAR_SELECTION";
                    break;
                case 16:
                    viewIdResourceName = "ACTION_CLICK";
                    break;
                case 32:
                    viewIdResourceName = "ACTION_LONG_CLICK";
                    break;
                case 64:
                    viewIdResourceName = "ACTION_ACCESSIBILITY_FOCUS";
                    break;
                case 128:
                    viewIdResourceName = "ACTION_CLEAR_ACCESSIBILITY_FOCUS";
                    break;
                case 256:
                    viewIdResourceName = "ACTION_NEXT_AT_MOVEMENT_GRANULARITY";
                    break;
                case 512:
                    viewIdResourceName = "ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY";
                    break;
                case WXMediaMessage.DESCRIPTION_LENGTH_LIMIT /*1024*/:
                    viewIdResourceName = "ACTION_NEXT_HTML_ELEMENT";
                    break;
                case 2048:
                    viewIdResourceName = "ACTION_PREVIOUS_HTML_ELEMENT";
                    break;
                case 4096:
                    viewIdResourceName = "ACTION_SCROLL_FORWARD";
                    break;
                case Utility.DEFAULT_STREAM_BUFFER_SIZE /*8192*/:
                    viewIdResourceName = "ACTION_SCROLL_BACKWARD";
                    break;
                case 16384:
                    viewIdResourceName = "ACTION_COPY";
                    break;
                case 32768:
                    viewIdResourceName = "ACTION_PASTE";
                    break;
                case 65536:
                    viewIdResourceName = "ACTION_CUT";
                    break;
                case WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT /*131072*/:
                    viewIdResourceName = "ACTION_SET_SELECTION";
                    break;
                default:
                    viewIdResourceName = "ACTION_UNKNOWN";
                    break;
            }
            stringBuilder.append(viewIdResourceName);
            if (i != 0) {
                stringBuilder.append(", ");
            }
            actions = i;
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
