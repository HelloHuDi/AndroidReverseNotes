package android.support.p069v7.widget;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.p057v4.view.C0449a;
import android.support.p057v4.view.p067a.C0445b;
import android.support.p057v4.view.p067a.C0445b.C0443b;
import android.support.p069v7.widget.RecyclerView.C17480i;
import android.support.p069v7.widget.RecyclerView.C25374o;
import android.support.p069v7.widget.RecyclerView.C31880s;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo.CollectionInfo;
import com.facebook.internal.Utility;

/* renamed from: android.support.v7.widget.ao */
public final class C17492ao extends C0449a {
    final RecyclerView aiB;
    final C0449a aqa = new C17493a(this);

    /* renamed from: android.support.v7.widget.ao$a */
    public static class C17493a extends C0449a {
        final C17492ao aqb;

        public C17493a(C17492ao c17492ao) {
            this.aqb = c17492ao;
        }

        public final void onInitializeAccessibilityNodeInfo(View view, C0445b c0445b) {
            super.onInitializeAccessibilityNodeInfo(view, c0445b);
            if (!this.aqb.aiB.mo66397jO() && this.aqb.aiB.getLayoutManager() != null) {
                this.aqb.aiB.getLayoutManager().mo31832a(view, c0445b);
            }
        }

        public final boolean performAccessibilityAction(View view, int i, Bundle bundle) {
            if (super.performAccessibilityAction(view, i, bundle)) {
                return true;
            }
            if (this.aqb.aiB.mo66397jO() || this.aqb.aiB.getLayoutManager() == null) {
                return false;
            }
            this.aqb.aiB.getLayoutManager();
            return false;
        }
    }

    public C17492ao(RecyclerView recyclerView) {
        this.aiB = recyclerView;
    }

    /* JADX WARNING: Missing block: B:26:0x0089, code skipped:
            r3 = 0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean performAccessibilityAction(View view, int i, Bundle bundle) {
        if (super.performAccessibilityAction(view, i, bundle)) {
            return true;
        }
        if (this.aiB.mo66397jO() || this.aiB.getLayoutManager() == null) {
            return false;
        }
        C17480i layoutManager = this.aiB.getLayoutManager();
        if (layoutManager.aiB == null) {
            return false;
        }
        int paddingTop;
        int paddingLeft;
        switch (i) {
            case 4096:
                if (layoutManager.aiB.canScrollVertically(1)) {
                    paddingTop = (layoutManager.mHeight - layoutManager.getPaddingTop()) - layoutManager.getPaddingBottom();
                } else {
                    paddingTop = 0;
                }
                if (layoutManager.aiB.canScrollHorizontally(1)) {
                    paddingLeft = (layoutManager.mWidth - layoutManager.getPaddingLeft()) - layoutManager.getPaddingRight();
                    break;
                }
            case Utility.DEFAULT_STREAM_BUFFER_SIZE /*8192*/:
                if (layoutManager.aiB.canScrollVertically(-1)) {
                    paddingTop = -((layoutManager.mHeight - layoutManager.getPaddingTop()) - layoutManager.getPaddingBottom());
                } else {
                    paddingTop = 0;
                }
                if (layoutManager.aiB.canScrollHorizontally(-1)) {
                    paddingLeft = -((layoutManager.mWidth - layoutManager.getPaddingLeft()) - layoutManager.getPaddingRight());
                    break;
                }
            default:
                paddingLeft = 0;
                paddingTop = 0;
                break;
        }
        if (paddingTop == 0 && paddingLeft == 0) {
            return false;
        }
        layoutManager.aiB.scrollBy(paddingLeft, paddingTop);
        return true;
    }

    public final void onInitializeAccessibilityNodeInfo(View view, C0445b c0445b) {
        super.onInitializeAccessibilityNodeInfo(view, c0445b);
        c0445b.setClassName(RecyclerView.class.getName());
        if (!this.aiB.mo66397jO() && this.aiB.getLayoutManager() != null) {
            C0443b c0443b;
            C17480i layoutManager = this.aiB.getLayoutManager();
            C25374o c25374o = layoutManager.aiB.anc;
            C31880s c31880s = layoutManager.aiB.anY;
            if (layoutManager.aiB.canScrollVertically(-1) || layoutManager.aiB.canScrollHorizontally(-1)) {
                c0445b.addAction(Utility.DEFAULT_STREAM_BUFFER_SIZE);
                c0445b.setScrollable(true);
            }
            if (layoutManager.aiB.canScrollVertically(1) || layoutManager.aiB.canScrollHorizontally(1)) {
                c0445b.addAction(4096);
                c0445b.setScrollable(true);
            }
            int a = layoutManager.mo31824a(c25374o, c31880s);
            int b = layoutManager.mo31844b(c25374o, c31880s);
            if (VERSION.SDK_INT >= 21) {
                c0443b = new C0443b(CollectionInfo.obtain(a, b, false, 0));
            } else if (VERSION.SDK_INT >= 19) {
                c0443b = new C0443b(CollectionInfo.obtain(a, b, false));
            } else {
                c0443b = new C0443b(null);
            }
            if (VERSION.SDK_INT >= 19) {
                c0445b.f546NG.setCollectionInfo((CollectionInfo) c0443b.f544On);
            }
        }
    }

    public final void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(view, accessibilityEvent);
        accessibilityEvent.setClassName(RecyclerView.class.getName());
        if ((view instanceof RecyclerView) && !this.aiB.mo66397jO()) {
            RecyclerView recyclerView = (RecyclerView) view;
            if (recyclerView.getLayoutManager() != null) {
                recyclerView.getLayoutManager().onInitializeAccessibilityEvent(accessibilityEvent);
            }
        }
    }
}
