package android.support.v4.view.a;

import android.graphics.Rect;
import android.os.Build.VERSION;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction;
import android.view.accessibility.AccessibilityNodeInfo.CollectionItemInfo;
import com.facebook.internal.Utility;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.wcdb.database.SQLiteGlobal;

public final class b {
    public final AccessibilityNodeInfo NG;
    public int NH = -1;

    public static class a {
        public static final a NI = new a(1);
        public static final a NJ = new a(2);
        public static final a NK = new a(4);
        public static final a NL = new a(8);
        public static final a NM = new a(16);
        public static final a NN = new a(32);
        public static final a NO = new a(64);
        public static final a NP = new a(128);
        public static final a NQ = new a(256);
        public static final a NR = new a(512);
        public static final a NS = new a((int) WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
        public static final a NT = new a(2048);
        public static final a NU = new a(4096);
        public static final a NV = new a((int) Utility.DEFAULT_STREAM_BUFFER_SIZE);
        public static final a NW = new a(16384);
        public static final a NX = new a(32768);
        public static final a NY = new a(65536);
        public static final a NZ = new a((int) WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT);
        public static final a Oa = new a(262144);
        public static final a Ob = new a((int) SQLiteGlobal.journalSizeLimit);
        public static final a Oc = new a(1048576);
        public static final a Od = new a(2097152);
        public static final a Oe;
        public static final a Of = new a(VERSION.SDK_INT >= 23 ? AccessibilityAction.ACTION_SCROLL_TO_POSITION : null);
        public static final a Og;
        public static final a Oh;
        public static final a Oi;
        public static final a Oj;
        public static final a Ok;
        public static final a Ol;
        final Object Om;

        static {
            Object obj;
            Object obj2 = null;
            if (VERSION.SDK_INT >= 23) {
                obj = AccessibilityAction.ACTION_SHOW_ON_SCREEN;
            } else {
                obj = null;
            }
            Oe = new a(obj);
            if (VERSION.SDK_INT >= 23) {
                obj = AccessibilityAction.ACTION_SCROLL_UP;
            } else {
                obj = null;
            }
            Og = new a(obj);
            if (VERSION.SDK_INT >= 23) {
                obj = AccessibilityAction.ACTION_SCROLL_LEFT;
            } else {
                obj = null;
            }
            Oh = new a(obj);
            if (VERSION.SDK_INT >= 23) {
                obj = AccessibilityAction.ACTION_SCROLL_DOWN;
            } else {
                obj = null;
            }
            Oi = new a(obj);
            if (VERSION.SDK_INT >= 23) {
                obj = AccessibilityAction.ACTION_SCROLL_RIGHT;
            } else {
                obj = null;
            }
            Oj = new a(obj);
            if (VERSION.SDK_INT >= 23) {
                obj = AccessibilityAction.ACTION_CONTEXT_CLICK;
            } else {
                obj = null;
            }
            Ok = new a(obj);
            if (VERSION.SDK_INT >= 24) {
                obj2 = AccessibilityAction.ACTION_SET_PROGRESS;
            }
            Ol = new a(obj2);
        }

        private a(int i) {
            Object accessibilityAction;
            if (VERSION.SDK_INT >= 21) {
                accessibilityAction = new AccessibilityAction(i, null);
            } else {
                accessibilityAction = null;
            }
            this(accessibilityAction);
        }

        private a(Object obj) {
            this.Om = obj;
        }
    }

    public static class b {
        public final Object On;

        public b(Object obj) {
            this.On = obj;
        }
    }

    public static class c {
        final Object On;

        public static c b(int i, int i2, int i3, int i4, boolean z) {
            if (VERSION.SDK_INT >= 21) {
                return new c(CollectionItemInfo.obtain(i, i2, i3, i4, z, false));
            }
            if (VERSION.SDK_INT >= 19) {
                return new c(CollectionItemInfo.obtain(i, i2, i3, i4, z));
            }
            return new c(null);
        }

        private c(Object obj) {
            this.On = obj;
        }
    }

    private b(AccessibilityNodeInfo accessibilityNodeInfo) {
        this.NG = accessibilityNodeInfo;
    }

    public static b a(AccessibilityNodeInfo accessibilityNodeInfo) {
        return new b(accessibilityNodeInfo);
    }

    public static b a(b bVar) {
        return a(AccessibilityNodeInfo.obtain(bVar.NG));
    }

    public final void setSource(View view) {
        this.NG.setSource(view);
    }

    public final void addChild(View view) {
        this.NG.addChild(view);
    }

    public final void addAction(int i) {
        this.NG.addAction(i);
    }

    public final boolean a(a aVar) {
        if (VERSION.SDK_INT >= 21) {
            return this.NG.removeAction((AccessibilityAction) aVar.Om);
        }
        return false;
    }

    public final void setParent(View view) {
        this.NG.setParent(view);
    }

    public final void getBoundsInParent(Rect rect) {
        this.NG.getBoundsInParent(rect);
    }

    public final void setBoundsInParent(Rect rect) {
        this.NG.setBoundsInParent(rect);
    }

    public final void getBoundsInScreen(Rect rect) {
        this.NG.getBoundsInScreen(rect);
    }

    public final void setBoundsInScreen(Rect rect) {
        this.NG.setBoundsInScreen(rect);
    }

    public final void setCheckable(boolean z) {
        this.NG.setCheckable(z);
    }

    public final void setFocusable(boolean z) {
        this.NG.setFocusable(z);
    }

    public final void setFocused(boolean z) {
        this.NG.setFocused(z);
    }

    public final boolean isVisibleToUser() {
        if (VERSION.SDK_INT >= 16) {
            return this.NG.isVisibleToUser();
        }
        return false;
    }

    public final void setVisibleToUser(boolean z) {
        if (VERSION.SDK_INT >= 16) {
            this.NG.setVisibleToUser(z);
        }
    }

    public final boolean isAccessibilityFocused() {
        if (VERSION.SDK_INT >= 16) {
            return this.NG.isAccessibilityFocused();
        }
        return false;
    }

    public final void setAccessibilityFocused(boolean z) {
        if (VERSION.SDK_INT >= 16) {
            this.NG.setAccessibilityFocused(z);
        }
    }

    public final void setSelected(boolean z) {
        this.NG.setSelected(z);
    }

    public final void setClickable(boolean z) {
        this.NG.setClickable(z);
    }

    public final void setLongClickable(boolean z) {
        this.NG.setLongClickable(z);
    }

    public final void setEnabled(boolean z) {
        this.NG.setEnabled(z);
    }

    public final void setScrollable(boolean z) {
        this.NG.setScrollable(z);
    }

    public final void setPackageName(CharSequence charSequence) {
        this.NG.setPackageName(charSequence);
    }

    public final void setClassName(CharSequence charSequence) {
        this.NG.setClassName(charSequence);
    }

    public final void setText(CharSequence charSequence) {
        this.NG.setText(charSequence);
    }

    public final void setContentDescription(CharSequence charSequence) {
        this.NG.setContentDescription(charSequence);
    }

    public final void H(Object obj) {
        if (VERSION.SDK_INT >= 19) {
            this.NG.setCollectionItemInfo((CollectionItemInfo) ((c) obj).On);
        }
    }

    public final void setDismissable(boolean z) {
        if (VERSION.SDK_INT >= 19) {
            this.NG.setDismissable(z);
        }
    }

    public final int hashCode() {
        return this.NG == null ? 0 : this.NG.hashCode();
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
        b bVar = (b) obj;
        if (this.NG == null) {
            if (bVar.NG != null) {
                return false;
            }
            return true;
        } else if (this.NG.equals(bVar.NG)) {
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
        stringBuilder.append("; packageName: ").append(this.NG.getPackageName());
        stringBuilder.append("; className: ").append(this.NG.getClassName());
        stringBuilder.append("; text: ").append(this.NG.getText());
        stringBuilder.append("; contentDescription: ").append(this.NG.getContentDescription());
        StringBuilder append = stringBuilder.append("; viewId: ");
        if (VERSION.SDK_INT >= 18) {
            viewIdResourceName = this.NG.getViewIdResourceName();
        } else {
            viewIdResourceName = null;
        }
        append.append(viewIdResourceName);
        stringBuilder.append("; checkable: ").append(this.NG.isCheckable());
        stringBuilder.append("; checked: ").append(this.NG.isChecked());
        stringBuilder.append("; focusable: ").append(this.NG.isFocusable());
        stringBuilder.append("; focused: ").append(this.NG.isFocused());
        stringBuilder.append("; selected: ").append(this.NG.isSelected());
        stringBuilder.append("; clickable: ").append(this.NG.isClickable());
        stringBuilder.append("; longClickable: ").append(this.NG.isLongClickable());
        stringBuilder.append("; enabled: ").append(this.NG.isEnabled());
        stringBuilder.append("; password: ").append(this.NG.isPassword());
        stringBuilder.append("; scrollable: " + this.NG.isScrollable());
        stringBuilder.append("; [");
        int actions = this.NG.getActions();
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
