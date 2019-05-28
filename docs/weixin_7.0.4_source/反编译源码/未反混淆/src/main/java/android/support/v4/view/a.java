package android.support.v4.view;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.view.a.c;
import android.view.View;
import android.view.View.AccessibilityDelegate;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;

public class a {
    private static final AccessibilityDelegate DEFAULT_DELEGATE = new AccessibilityDelegate();
    private static final b IMPL;
    final AccessibilityDelegate mBridge = IMPL.a(this);

    static class b {
        b() {
        }

        public AccessibilityDelegate a(final a aVar) {
            return new AccessibilityDelegate() {
                public final boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
                    return aVar.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
                }

                public final void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
                    aVar.onInitializeAccessibilityEvent(view, accessibilityEvent);
                }

                public final void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
                    aVar.onInitializeAccessibilityNodeInfo(view, android.support.v4.view.a.b.a(accessibilityNodeInfo));
                }

                public final void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
                    aVar.onPopulateAccessibilityEvent(view, accessibilityEvent);
                }

                public final boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
                    return aVar.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
                }

                public final void sendAccessibilityEvent(View view, int i) {
                    aVar.sendAccessibilityEvent(view, i);
                }

                public final void sendAccessibilityEventUnchecked(View view, AccessibilityEvent accessibilityEvent) {
                    aVar.sendAccessibilityEventUnchecked(view, accessibilityEvent);
                }
            };
        }

        public c a(AccessibilityDelegate accessibilityDelegate, View view) {
            return null;
        }

        public boolean a(AccessibilityDelegate accessibilityDelegate, View view, int i, Bundle bundle) {
            return false;
        }
    }

    static class a extends b {
        a() {
        }

        public final AccessibilityDelegate a(final a aVar) {
            return new AccessibilityDelegate() {
                public final boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
                    return aVar.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
                }

                public final void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
                    aVar.onInitializeAccessibilityEvent(view, accessibilityEvent);
                }

                public final void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
                    aVar.onInitializeAccessibilityNodeInfo(view, android.support.v4.view.a.b.a(accessibilityNodeInfo));
                }

                public final void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
                    aVar.onPopulateAccessibilityEvent(view, accessibilityEvent);
                }

                public final boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
                    return aVar.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
                }

                public final void sendAccessibilityEvent(View view, int i) {
                    aVar.sendAccessibilityEvent(view, i);
                }

                public final void sendAccessibilityEventUnchecked(View view, AccessibilityEvent accessibilityEvent) {
                    aVar.sendAccessibilityEventUnchecked(view, accessibilityEvent);
                }

                public final AccessibilityNodeProvider getAccessibilityNodeProvider(View view) {
                    c accessibilityNodeProvider = aVar.getAccessibilityNodeProvider(view);
                    return accessibilityNodeProvider != null ? (AccessibilityNodeProvider) accessibilityNodeProvider.Oo : null;
                }

                public final boolean performAccessibilityAction(View view, int i, Bundle bundle) {
                    return aVar.performAccessibilityAction(view, i, bundle);
                }
            };
        }

        public final c a(AccessibilityDelegate accessibilityDelegate, View view) {
            AccessibilityNodeProvider accessibilityNodeProvider = accessibilityDelegate.getAccessibilityNodeProvider(view);
            if (accessibilityNodeProvider != null) {
                return new c(accessibilityNodeProvider);
            }
            return null;
        }

        public final boolean a(AccessibilityDelegate accessibilityDelegate, View view, int i, Bundle bundle) {
            return accessibilityDelegate.performAccessibilityAction(view, i, bundle);
        }
    }

    static {
        if (VERSION.SDK_INT >= 16) {
            IMPL = new a();
        } else {
            IMPL = new b();
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

    public void onInitializeAccessibilityNodeInfo(View view, android.support.v4.view.a.b bVar) {
        DEFAULT_DELEGATE.onInitializeAccessibilityNodeInfo(view, bVar.NG);
    }

    public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        return DEFAULT_DELEGATE.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
    }

    public c getAccessibilityNodeProvider(View view) {
        return IMPL.a(DEFAULT_DELEGATE, view);
    }

    public boolean performAccessibilityAction(View view, int i, Bundle bundle) {
        return IMPL.a(DEFAULT_DELEGATE, view, i, bundle);
    }
}
