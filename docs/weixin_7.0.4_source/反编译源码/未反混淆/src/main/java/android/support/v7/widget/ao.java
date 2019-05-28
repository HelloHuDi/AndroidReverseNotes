package android.support.v7.widget;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.view.a.b;
import android.support.v7.widget.RecyclerView.i;
import android.support.v7.widget.RecyclerView.o;
import android.support.v7.widget.RecyclerView.s;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo.CollectionInfo;
import com.facebook.internal.Utility;

public final class ao extends android.support.v4.view.a {
    final RecyclerView aiB;
    final android.support.v4.view.a aqa = new a(this);

    public static class a extends android.support.v4.view.a {
        final ao aqb;

        public a(ao aoVar) {
            this.aqb = aoVar;
        }

        public final void onInitializeAccessibilityNodeInfo(View view, b bVar) {
            super.onInitializeAccessibilityNodeInfo(view, bVar);
            if (!this.aqb.aiB.jO() && this.aqb.aiB.getLayoutManager() != null) {
                this.aqb.aiB.getLayoutManager().a(view, bVar);
            }
        }

        public final boolean performAccessibilityAction(View view, int i, Bundle bundle) {
            if (super.performAccessibilityAction(view, i, bundle)) {
                return true;
            }
            if (this.aqb.aiB.jO() || this.aqb.aiB.getLayoutManager() == null) {
                return false;
            }
            this.aqb.aiB.getLayoutManager();
            return false;
        }
    }

    public ao(RecyclerView recyclerView) {
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
        if (this.aiB.jO() || this.aiB.getLayoutManager() == null) {
            return false;
        }
        i layoutManager = this.aiB.getLayoutManager();
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

    public final void onInitializeAccessibilityNodeInfo(View view, b bVar) {
        super.onInitializeAccessibilityNodeInfo(view, bVar);
        bVar.setClassName(RecyclerView.class.getName());
        if (!this.aiB.jO() && this.aiB.getLayoutManager() != null) {
            b.b bVar2;
            i layoutManager = this.aiB.getLayoutManager();
            o oVar = layoutManager.aiB.anc;
            s sVar = layoutManager.aiB.anY;
            if (layoutManager.aiB.canScrollVertically(-1) || layoutManager.aiB.canScrollHorizontally(-1)) {
                bVar.addAction(Utility.DEFAULT_STREAM_BUFFER_SIZE);
                bVar.setScrollable(true);
            }
            if (layoutManager.aiB.canScrollVertically(1) || layoutManager.aiB.canScrollHorizontally(1)) {
                bVar.addAction(4096);
                bVar.setScrollable(true);
            }
            int a = layoutManager.a(oVar, sVar);
            int b = layoutManager.b(oVar, sVar);
            if (VERSION.SDK_INT >= 21) {
                bVar2 = new b.b(CollectionInfo.obtain(a, b, false, 0));
            } else if (VERSION.SDK_INT >= 19) {
                bVar2 = new b.b(CollectionInfo.obtain(a, b, false));
            } else {
                bVar2 = new b.b(null);
            }
            if (VERSION.SDK_INT >= 19) {
                bVar.NG.setCollectionInfo((CollectionInfo) bVar2.On);
            }
        }
    }

    public final void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(view, accessibilityEvent);
        accessibilityEvent.setClassName(RecyclerView.class.getName());
        if ((view instanceof RecyclerView) && !this.aiB.jO()) {
            RecyclerView recyclerView = (RecyclerView) view;
            if (recyclerView.getLayoutManager() != null) {
                recyclerView.getLayoutManager().onInitializeAccessibilityEvent(accessibilityEvent);
            }
        }
    }
}
