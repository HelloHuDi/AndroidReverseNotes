package android.support.p057v4.widget;

import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.p057v4.p065f.C0418n;
import android.support.p057v4.view.C0449a;
import android.support.p057v4.view.C0477s;
import android.support.p057v4.view.C0492v;
import android.support.p057v4.view.p067a.C0445b;
import android.support.p057v4.view.p067a.C0447c;
import android.support.p057v4.view.p067a.C41515a;
import android.support.p057v4.widget.C31870k.C17468a;
import android.support.p057v4.widget.C31870k.C31869b;
import android.support.p057v4.widget.C31870k.C8419c;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.qqmusic.mediaplayer.PlayerException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* renamed from: android.support.v4.widget.j */
public abstract class C8415j extends C0449a {
    private static final String DEFAULT_CLASS_NAME = "android.view.View";
    public static final int HOST_ID = -1;
    public static final int INVALID_ID = Integer.MIN_VALUE;
    private static final Rect INVALID_PARENT_BOUNDS = new Rect(BaseClientBuilder.API_PRIORITY_OTHER, BaseClientBuilder.API_PRIORITY_OTHER, INVALID_ID, INVALID_ID);
    private static final C17468a<C0445b> NODE_ADAPTER = new C84161();
    private static final C31869b<C0418n<C0445b>, C0445b> SPARSE_VALUES_ADAPTER = new C84172();
    private int mAccessibilityFocusedVirtualViewId = INVALID_ID;
    private final View mHost;
    private int mHoveredVirtualViewId = INVALID_ID;
    private int mKeyboardFocusedVirtualViewId = INVALID_ID;
    private final AccessibilityManager mManager;
    private C8418a mNodeProvider;
    private final int[] mTempGlobalRect = new int[2];
    private final Rect mTempParentRect = new Rect();
    private final Rect mTempScreenRect = new Rect();
    private final Rect mTempVisibleRect = new Rect();

    /* renamed from: android.support.v4.widget.j$1 */
    static class C84161 implements C17468a<C0445b> {
        C84161() {
        }

        /* renamed from: b */
        public final /* synthetic */ void mo18385b(Object obj, Rect rect) {
            ((C0445b) obj).getBoundsInParent(rect);
        }
    }

    /* renamed from: android.support.v4.widget.j$2 */
    static class C84172 implements C31869b<C0418n<C0445b>, C0445b> {
        C84172() {
        }

        /* renamed from: L */
        public final /* synthetic */ int mo18386L(Object obj) {
            return ((C0418n) obj).size();
        }

        public final /* synthetic */ Object get(Object obj, int i) {
            return (C0445b) ((C0418n) obj).valueAt(i);
        }
    }

    /* renamed from: android.support.v4.widget.j$a */
    class C8418a extends C0447c {
        C8418a() {
        }

        /* renamed from: aL */
        public final C0445b mo1018aL(int i) {
            return C0445b.m770a(C8415j.this.obtainAccessibilityNodeInfo(i));
        }

        public final boolean performAction(int i, int i2, Bundle bundle) {
            return C8415j.this.performAction(i, i2, bundle);
        }

        /* renamed from: aM */
        public final C0445b mo1019aM(int i) {
            int access$000 = i == 2 ? C8415j.this.mAccessibilityFocusedVirtualViewId : C8415j.this.mKeyboardFocusedVirtualViewId;
            if (access$000 == C8415j.INVALID_ID) {
                return null;
            }
            return mo1018aL(access$000);
        }
    }

    public abstract int getVirtualViewAt(float f, float f2);

    public abstract void getVisibleVirtualViews(List<Integer> list);

    public abstract boolean onPerformActionForVirtualView(int i, int i2, Bundle bundle);

    public abstract void onPopulateNodeForVirtualView(int i, C0445b c0445b);

    public C8415j(View view) {
        if (view == null) {
            throw new IllegalArgumentException("View may not be null");
        }
        this.mHost = view;
        this.mManager = (AccessibilityManager) view.getContext().getSystemService("accessibility");
        view.setFocusable(true);
        if (C0477s.m892S(view) == 0) {
            C0477s.m949o(view, 1);
        }
    }

    public C0447c getAccessibilityNodeProvider(View view) {
        if (this.mNodeProvider == null) {
            this.mNodeProvider = new C8418a();
        }
        return this.mNodeProvider;
    }

    public final boolean dispatchHoverEvent(MotionEvent motionEvent) {
        if (!this.mManager.isEnabled() || !this.mManager.isTouchExplorationEnabled()) {
            return false;
        }
        switch (motionEvent.getAction()) {
            case 7:
            case 9:
                int virtualViewAt = getVirtualViewAt(motionEvent.getX(), motionEvent.getY());
                updateHoveredVirtualView(virtualViewAt);
                if (virtualViewAt == INVALID_ID) {
                    return false;
                }
                return true;
            case 10:
                if (this.mAccessibilityFocusedVirtualViewId == INVALID_ID) {
                    return false;
                }
                updateHoveredVirtualView(INVALID_ID);
                return true;
            default:
                return false;
        }
    }

    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getAction() != 1) {
            int keyCode = keyEvent.getKeyCode();
            switch (keyCode) {
                case 19:
                case 20:
                case 21:
                case 22:
                    if (keyEvent.hasNoModifiers()) {
                        int keyToDirection = C8415j.keyToDirection(keyCode);
                        int repeatCount = keyEvent.getRepeatCount() + 1;
                        int i = 0;
                        boolean z = false;
                        while (i < repeatCount && moveFocus(keyToDirection, null)) {
                            i++;
                            z = true;
                        }
                        return z;
                    }
                    break;
                case 23:
                case 66:
                    if (keyEvent.hasNoModifiers() && keyEvent.getRepeatCount() == 0) {
                        clickKeyboardFocusedVirtualView();
                        return true;
                    }
                case PlayerException.EXCEPTION_TYPE_INITLIB /*61*/:
                    if (keyEvent.hasNoModifiers()) {
                        return moveFocus(2, null);
                    }
                    if (keyEvent.hasModifiers(1)) {
                        return moveFocus(1, null);
                    }
                    break;
            }
        }
        return false;
    }

    public final void onFocusChanged(boolean z, int i, Rect rect) {
        if (this.mKeyboardFocusedVirtualViewId != INVALID_ID) {
            clearKeyboardFocusForVirtualView(this.mKeyboardFocusedVirtualViewId);
        }
        if (z) {
            moveFocus(i, rect);
        }
    }

    public final int getAccessibilityFocusedVirtualViewId() {
        return this.mAccessibilityFocusedVirtualViewId;
    }

    public final int getKeyboardFocusedVirtualViewId() {
        return this.mKeyboardFocusedVirtualViewId;
    }

    private static int keyToDirection(int i) {
        switch (i) {
            case 19:
                return 33;
            case 21:
                return 17;
            case 22:
                return 66;
            default:
                return 130;
        }
    }

    private void getBoundsInParent(int i, Rect rect) {
        obtainAccessibilityNodeInfo(i).getBoundsInParent(rect);
    }

    private boolean moveFocus(int i, Rect rect) {
        Object obj;
        Object obj2;
        int i2 = 0;
        C0418n allNodes = getAllNodes();
        int i3 = this.mKeyboardFocusedVirtualViewId;
        if (i3 == INVALID_ID) {
            obj = null;
        } else {
            C0445b obj3 = (C0445b) allNodes.mo847aH(i3);
        }
        switch (i) {
            case 1:
            case 2:
                boolean z = C0477s.m893T(this.mHost) == 1;
                C31869b c31869b = SPARSE_VALUES_ADAPTER;
                C17468a c17468a = NODE_ADAPTER;
                int L = c31869b.mo18386L(allNodes);
                ArrayList arrayList = new ArrayList(L);
                while (i2 < L) {
                    arrayList.add(c31869b.get(allNodes, i2));
                    i2++;
                }
                Collections.sort(arrayList, new C8419c(z, c17468a));
                switch (i) {
                    case 1:
                        i3 = arrayList.size();
                        if (obj3 != null) {
                            i3 = arrayList.indexOf(obj3);
                        }
                        i3--;
                        if (i3 < 0) {
                            obj2 = null;
                            break;
                        }
                        obj2 = arrayList.get(i3);
                        break;
                    case 2:
                        i3 = (obj3 == null ? -1 : arrayList.lastIndexOf(obj3)) + 1;
                        if (i3 >= arrayList.size()) {
                            obj2 = null;
                            break;
                        }
                        obj2 = arrayList.get(i3);
                        break;
                    default:
                        throw new IllegalArgumentException("direction must be one of {FOCUS_FORWARD, FOCUS_BACKWARD}.");
                }
                obj2 = (C0445b) obj2;
                break;
            case 17:
            case 33:
            case 66:
            case 130:
                Rect rect2 = new Rect();
                if (this.mKeyboardFocusedVirtualViewId != INVALID_ID) {
                    getBoundsInParent(this.mKeyboardFocusedVirtualViewId, rect2);
                } else if (rect != null) {
                    rect2.set(rect);
                } else {
                    C8415j.guessPreviouslyFocusedRect(this.mHost, i, rect2);
                }
                C0445b c0445b = (C0445b) C31870k.m51641a(allNodes, SPARSE_VALUES_ADAPTER, NODE_ADAPTER, obj3, rect2, i);
                break;
            default:
                throw new IllegalArgumentException("direction must be one of {FOCUS_FORWARD, FOCUS_BACKWARD, FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        }
        return requestKeyboardFocusForVirtualView(obj2 == null ? INVALID_ID : allNodes.keyAt(allNodes.indexOfValue(obj2)));
    }

    private C0418n<C0445b> getAllNodes() {
        ArrayList arrayList = new ArrayList();
        getVisibleVirtualViews(arrayList);
        C0418n c0418n = new C0418n();
        for (int i = 0; i < arrayList.size(); i++) {
            c0418n.put(i, createNodeForChild(i));
        }
        return c0418n;
    }

    private static Rect guessPreviouslyFocusedRect(View view, int i, Rect rect) {
        int width = view.getWidth();
        int height = view.getHeight();
        switch (i) {
            case 17:
                rect.set(width, 0, width, height);
                break;
            case 33:
                rect.set(0, height, width, height);
                break;
            case 66:
                rect.set(-1, 0, -1, height);
                break;
            case 130:
                rect.set(0, -1, width, -1);
                break;
            default:
                throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        }
        return rect;
    }

    private boolean clickKeyboardFocusedVirtualView() {
        return this.mKeyboardFocusedVirtualViewId != INVALID_ID && onPerformActionForVirtualView(this.mKeyboardFocusedVirtualViewId, 16, null);
    }

    public final boolean sendEventForVirtualView(int i, int i2) {
        if (i == INVALID_ID || !this.mManager.isEnabled()) {
            return false;
        }
        ViewParent parent = this.mHost.getParent();
        if (parent == null) {
            return false;
        }
        return C0492v.m1027a(parent, this.mHost, createEvent(i, i2));
    }

    public final void invalidateRoot() {
        invalidateVirtualView(-1, 1);
    }

    public final void invalidateVirtualView(int i) {
        invalidateVirtualView(i, 0);
    }

    public final void invalidateVirtualView(int i, int i2) {
        if (i != INVALID_ID && this.mManager.isEnabled()) {
            ViewParent parent = this.mHost.getParent();
            if (parent != null) {
                AccessibilityEvent createEvent = createEvent(i, 2048);
                C41515a.m72498a(createEvent, i2);
                C0492v.m1027a(parent, this.mHost, createEvent);
            }
        }
    }

    @Deprecated
    public int getFocusedVirtualView() {
        return getAccessibilityFocusedVirtualViewId();
    }

    /* Access modifiers changed, original: protected */
    public void onVirtualViewKeyboardFocusChanged(int i, boolean z) {
    }

    private void updateHoveredVirtualView(int i) {
        if (this.mHoveredVirtualViewId != i) {
            int i2 = this.mHoveredVirtualViewId;
            this.mHoveredVirtualViewId = i;
            sendEventForVirtualView(i, 128);
            sendEventForVirtualView(i2, 256);
        }
    }

    private AccessibilityEvent createEvent(int i, int i2) {
        switch (i) {
            case -1:
                return createEventForHost(i2);
            default:
                return createEventForChild(i, i2);
        }
    }

    private AccessibilityEvent createEventForHost(int i) {
        AccessibilityEvent obtain = AccessibilityEvent.obtain(i);
        this.mHost.onInitializeAccessibilityEvent(obtain);
        return obtain;
    }

    public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(view, accessibilityEvent);
        onPopulateEventForHost(accessibilityEvent);
    }

    private AccessibilityEvent createEventForChild(int i, int i2) {
        AccessibilityEvent obtain = AccessibilityEvent.obtain(i2);
        C0445b obtainAccessibilityNodeInfo = obtainAccessibilityNodeInfo(i);
        obtain.getText().add(obtainAccessibilityNodeInfo.f546NG.getText());
        obtain.setContentDescription(obtainAccessibilityNodeInfo.f546NG.getContentDescription());
        obtain.setScrollable(obtainAccessibilityNodeInfo.f546NG.isScrollable());
        obtain.setPassword(obtainAccessibilityNodeInfo.f546NG.isPassword());
        obtain.setEnabled(obtainAccessibilityNodeInfo.f546NG.isEnabled());
        obtain.setChecked(obtainAccessibilityNodeInfo.f546NG.isChecked());
        onPopulateEventForVirtualView(i, obtain);
        if (obtain.getText().isEmpty() && obtain.getContentDescription() == null) {
            throw new RuntimeException("Callbacks must add text or a content description in populateEventForVirtualViewId()");
        }
        obtain.setClassName(obtainAccessibilityNodeInfo.f546NG.getClassName());
        View view = this.mHost;
        if (VERSION.SDK_INT >= 16) {
            obtain.setSource(view, i);
        }
        obtain.setPackageName(this.mHost.getContext().getPackageName());
        return obtain;
    }

    /* Access modifiers changed, original: 0000 */
    public C0445b obtainAccessibilityNodeInfo(int i) {
        if (i == -1) {
            return createNodeForHost();
        }
        return createNodeForChild(i);
    }

    private C0445b createNodeForHost() {
        C0445b a = C0445b.m771a(AccessibilityNodeInfo.obtain(this.mHost));
        C0477s.onInitializeAccessibilityNodeInfo(this.mHost, a);
        ArrayList arrayList = new ArrayList();
        getVisibleVirtualViews(arrayList);
        if (a.f546NG.getChildCount() <= 0 || arrayList.size() <= 0) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                View view = this.mHost;
                int intValue = ((Integer) arrayList.get(i)).intValue();
                if (VERSION.SDK_INT >= 16) {
                    a.f546NG.addChild(view, intValue);
                }
            }
            return a;
        }
        throw new RuntimeException("Views cannot have both real and virtual children");
    }

    public void onInitializeAccessibilityNodeInfo(View view, C0445b c0445b) {
        super.onInitializeAccessibilityNodeInfo(view, c0445b);
        onPopulateNodeForHost(c0445b);
    }

    /* Access modifiers changed, original: 0000 */
    public boolean performAction(int i, int i2, Bundle bundle) {
        switch (i) {
            case -1:
                return performActionForHost(i2, bundle);
            default:
                return performActionForChild(i, i2, bundle);
        }
    }

    private boolean performActionForHost(int i, Bundle bundle) {
        return C0477s.performAccessibilityAction(this.mHost, i, bundle);
    }

    private boolean performActionForChild(int i, int i2, Bundle bundle) {
        switch (i2) {
            case 1:
                return requestKeyboardFocusForVirtualView(i);
            case 2:
                return clearKeyboardFocusForVirtualView(i);
            case 64:
                return requestAccessibilityFocus(i);
            case 128:
                return clearAccessibilityFocus(i);
            default:
                return onPerformActionForVirtualView(i, i2, bundle);
        }
    }

    private boolean isVisibleToUser(Rect rect) {
        if (rect == null || rect.isEmpty()) {
            return false;
        }
        if (this.mHost.getWindowVisibility() != 0) {
            return false;
        }
        ViewParent parent = this.mHost.getParent();
        while (parent instanceof View) {
            View view = (View) parent;
            if (view.getAlpha() <= 0.0f || view.getVisibility() != 0) {
                return false;
            }
            parent = view.getParent();
        }
        return parent != null;
    }

    private boolean requestAccessibilityFocus(int i) {
        if (!this.mManager.isEnabled() || !this.mManager.isTouchExplorationEnabled() || this.mAccessibilityFocusedVirtualViewId == i) {
            return false;
        }
        if (this.mAccessibilityFocusedVirtualViewId != INVALID_ID) {
            clearAccessibilityFocus(this.mAccessibilityFocusedVirtualViewId);
        }
        this.mAccessibilityFocusedVirtualViewId = i;
        this.mHost.invalidate();
        sendEventForVirtualView(i, 32768);
        return true;
    }

    private boolean clearAccessibilityFocus(int i) {
        if (this.mAccessibilityFocusedVirtualViewId != i) {
            return false;
        }
        this.mAccessibilityFocusedVirtualViewId = INVALID_ID;
        this.mHost.invalidate();
        sendEventForVirtualView(i, 65536);
        return true;
    }

    public final boolean requestKeyboardFocusForVirtualView(int i) {
        if ((!this.mHost.isFocused() && !this.mHost.requestFocus()) || this.mKeyboardFocusedVirtualViewId == i) {
            return false;
        }
        if (this.mKeyboardFocusedVirtualViewId != INVALID_ID) {
            clearKeyboardFocusForVirtualView(this.mKeyboardFocusedVirtualViewId);
        }
        this.mKeyboardFocusedVirtualViewId = i;
        onVirtualViewKeyboardFocusChanged(i, true);
        sendEventForVirtualView(i, 8);
        return true;
    }

    public final boolean clearKeyboardFocusForVirtualView(int i) {
        if (this.mKeyboardFocusedVirtualViewId != i) {
            return false;
        }
        this.mKeyboardFocusedVirtualViewId = INVALID_ID;
        onVirtualViewKeyboardFocusChanged(i, false);
        sendEventForVirtualView(i, 8);
        return true;
    }

    /* Access modifiers changed, original: protected */
    public void onPopulateEventForVirtualView(int i, AccessibilityEvent accessibilityEvent) {
    }

    /* Access modifiers changed, original: protected */
    public void onPopulateEventForHost(AccessibilityEvent accessibilityEvent) {
    }

    /* Access modifiers changed, original: protected */
    public void onPopulateNodeForHost(C0445b c0445b) {
    }

    private C0445b createNodeForChild(int i) {
        C0445b a = C0445b.m771a(AccessibilityNodeInfo.obtain());
        a.setEnabled(true);
        a.setFocusable(true);
        a.setClassName(DEFAULT_CLASS_NAME);
        a.setBoundsInParent(INVALID_PARENT_BOUNDS);
        a.setBoundsInScreen(INVALID_PARENT_BOUNDS);
        a.setParent(this.mHost);
        onPopulateNodeForVirtualView(i, a);
        if (a.f546NG.getText() == null && a.f546NG.getContentDescription() == null) {
            throw new RuntimeException("Callbacks must add text or a content description in populateNodeForVirtualViewId()");
        }
        a.getBoundsInParent(this.mTempParentRect);
        if (this.mTempParentRect.equals(INVALID_PARENT_BOUNDS)) {
            throw new RuntimeException("Callbacks must set parent bounds in populateNodeForVirtualViewId()");
        }
        int actions = a.f546NG.getActions();
        if ((actions & 64) != 0) {
            throw new RuntimeException("Callbacks must not add ACTION_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
        } else if ((actions & 128) != 0) {
            throw new RuntimeException("Callbacks must not add ACTION_CLEAR_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
        } else {
            boolean z;
            a.setPackageName(this.mHost.getContext().getPackageName());
            View view = this.mHost;
            if (VERSION.SDK_INT >= 16) {
                a.f546NG.setSource(view, i);
            }
            if (this.mAccessibilityFocusedVirtualViewId == i) {
                a.setAccessibilityFocused(true);
                a.addAction(128);
            } else {
                a.setAccessibilityFocused(false);
                a.addAction(64);
            }
            if (this.mKeyboardFocusedVirtualViewId == i) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                a.addAction(2);
            } else if (a.f546NG.isFocusable()) {
                a.addAction(1);
            }
            a.setFocused(z);
            this.mHost.getLocationOnScreen(this.mTempGlobalRect);
            a.getBoundsInScreen(this.mTempScreenRect);
            if (this.mTempScreenRect.equals(INVALID_PARENT_BOUNDS)) {
                a.getBoundsInParent(this.mTempScreenRect);
                if (a.f547NH != -1) {
                    C0445b a2 = C0445b.m771a(AccessibilityNodeInfo.obtain());
                    for (actions = a.f547NH; actions != -1; actions = a2.f547NH) {
                        View view2 = this.mHost;
                        a2.f547NH = -1;
                        if (VERSION.SDK_INT >= 16) {
                            a2.f546NG.setParent(view2, -1);
                        }
                        a2.setBoundsInParent(INVALID_PARENT_BOUNDS);
                        onPopulateNodeForVirtualView(actions, a2);
                        a2.getBoundsInParent(this.mTempParentRect);
                        this.mTempScreenRect.offset(this.mTempParentRect.left, this.mTempParentRect.top);
                    }
                    a2.f546NG.recycle();
                }
                this.mTempScreenRect.offset(this.mTempGlobalRect[0] - this.mHost.getScrollX(), this.mTempGlobalRect[1] - this.mHost.getScrollY());
            }
            if (this.mHost.getLocalVisibleRect(this.mTempVisibleRect)) {
                this.mTempVisibleRect.offset(this.mTempGlobalRect[0] - this.mHost.getScrollX(), this.mTempGlobalRect[1] - this.mHost.getScrollY());
                if (this.mTempScreenRect.intersect(this.mTempVisibleRect)) {
                    a.setBoundsInScreen(this.mTempScreenRect);
                    if (isVisibleToUser(this.mTempScreenRect)) {
                        a.setVisibleToUser(true);
                    }
                }
            }
            return a;
        }
    }
}
