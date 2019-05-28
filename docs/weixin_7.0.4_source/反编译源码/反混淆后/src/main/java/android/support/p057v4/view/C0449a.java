package android.support.p057v4.view;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.p057v4.view.p067a.C0445b;
import android.support.p057v4.view.p067a.C0447c;
import android.view.View;
import android.view.View.AccessibilityDelegate;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;

/* renamed from: android.support.v4.view.a */
public class C0449a {
    private static final AccessibilityDelegate DEFAULT_DELEGATE = new AccessibilityDelegate();
    private static final C0441b IMPL;
    final AccessibilityDelegate mBridge = IMPL.mo983a(this);

    /* renamed from: android.support.v4.view.a$b */
    static class C0441b {
        C0441b() {
        }

        /* renamed from: a */
        public AccessibilityDelegate mo983a(final C0449a c0449a) {
            return new AccessibilityDelegate() {
                public final boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
                    return c0449a.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
                }

                public final void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
                    c0449a.onInitializeAccessibilityEvent(view, accessibilityEvent);
                }

                public final void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
                    c0449a.onInitializeAccessibilityNodeInfo(view, C0445b.m771a(accessibilityNodeInfo));
                }

                public final void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
                    c0449a.onPopulateAccessibilityEvent(view, accessibilityEvent);
                }

                public final boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
                    return c0449a.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
                }

                public final void sendAccessibilityEvent(View view, int i) {
                    c0449a.sendAccessibilityEvent(view, i);
                }

                public final void sendAccessibilityEventUnchecked(View view, AccessibilityEvent accessibilityEvent) {
                    c0449a.sendAccessibilityEventUnchecked(view, accessibilityEvent);
                }
            };
        }

        /* renamed from: a */
        public C0447c mo982a(AccessibilityDelegate accessibilityDelegate, View view) {
            return null;
        }

        /* renamed from: a */
        public boolean mo984a(AccessibilityDelegate accessibilityDelegate, View view, int i, Bundle bundle) {
            return false;
        }
    }

    /* renamed from: android.support.v4.view.a$a */
    static class C0450a extends C0441b {
        C0450a() {
        }

        /* renamed from: a */
        public final AccessibilityDelegate mo983a(final C0449a c0449a) {
            return new AccessibilityDelegate() {
                public final boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
                    return c0449a.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
                }

                public final void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
                    c0449a.onInitializeAccessibilityEvent(view, accessibilityEvent);
                }

                public final void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
                    c0449a.onInitializeAccessibilityNodeInfo(view, C0445b.m771a(accessibilityNodeInfo));
                }

                public final void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
                    c0449a.onPopulateAccessibilityEvent(view, accessibilityEvent);
                }

                public final boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
                    return c0449a.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
                }

                public final void sendAccessibilityEvent(View view, int i) {
                    c0449a.sendAccessibilityEvent(view, i);
                }

                public final void sendAccessibilityEventUnchecked(View view, AccessibilityEvent accessibilityEvent) {
                    c0449a.sendAccessibilityEventUnchecked(view, accessibilityEvent);
                }

                public final AccessibilityNodeProvider getAccessibilityNodeProvider(View view) {
                    C0447c accessibilityNodeProvider = c0449a.getAccessibilityNodeProvider(view);
                    return accessibilityNodeProvider != null ? (AccessibilityNodeProvider) accessibilityNodeProvider.f549Oo : null;
                }

                public final boolean performAccessibilityAction(View view, int i, Bundle bundle) {
                    return c0449a.performAccessibilityAction(view, i, bundle);
                }
            };
        }

        /* renamed from: a */
        public final C0447c mo982a(AccessibilityDelegate accessibilityDelegate, View view) {
            AccessibilityNodeProvider accessibilityNodeProvider = accessibilityDelegate.getAccessibilityNodeProvider(view);
            if (accessibilityNodeProvider != null) {
                return new C0447c(accessibilityNodeProvider);
            }
            return null;
        }

        /* renamed from: a */
        public final boolean mo984a(AccessibilityDelegate accessibilityDelegate, View view, int i, Bundle bundle) {
            return accessibilityDelegate.performAccessibilityAction(view, i, bundle);
        }
    }

    static {
        if (VERSION.SDK_INT >= 16) {
            IMPL = new C0450a();
        } else {
            IMPL = new C0441b();
        }
    }

    /* Access modifiers changed, original: 0000 */
    public AccessibilityDelegate getBridge() {
        return this.mBridge;
    }

    public void sendAccessibilityEvent(View view, int i) {
        DEFAULT_DELEGATE.sendAccessibilityEvent(view, i);
    }

    public void sendAccessibilityEventUnchecked(View view, AccessibilityEvent accessibilityEvent) {
        DEFAULT_DELEGATE.sendAccessibilityEventUnchecked(view, accessibilityEvent);
    }

    public boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        return DEFAULT_DELEGATE.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        DEFAULT_DELEGATE.onPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        DEFAULT_DELEGATE.onInitializeAccessibilityEvent(view, accessibilityEvent);
    }

    public void onInitializeAccessibilityNodeInfo(View view, C0445b c0445b) {
        DEFAULT_DELEGATE.onInitializeAccessibilityNodeInfo(view, c0445b.f546NG);
    }

    public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        return DEFAULT_DELEGATE.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
    }

    public C0447c getAccessibilityNodeProvider(View view) {
        return IMPL.mo982a(DEFAULT_DELEGATE, view);
    }

    public boolean performAccessibilityAction(View view, int i, Bundle bundle) {
        return IMPL.mo984a(DEFAULT_DELEGATE, view, i, bundle);
    }
}
