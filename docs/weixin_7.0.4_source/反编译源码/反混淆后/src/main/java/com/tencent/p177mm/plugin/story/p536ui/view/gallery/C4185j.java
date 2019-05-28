package com.tencent.p177mm.plugin.story.p536ui.view.gallery;

import android.support.p069v7.widget.C17487am;
import android.support.p069v7.widget.C17491an;
import android.support.p069v7.widget.RecyclerView.C17480i;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J \u0010\f\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u0004H\u0002J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0002J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/view/gallery/PageScrollHelper;", "Landroid/support/v7/widget/PagerSnapHelper;", "()V", "horizontalHelper", "Landroid/support/v7/widget/OrientationHelper;", "verticalHelper", "calculateDistanceToFinalSnap", "", "layoutManager", "Landroid/support/v7/widget/RecyclerView$LayoutManager;", "targetView", "Landroid/view/View;", "distanceToCenter", "", "helper", "getHorizontalHelper", "getVerticalHelper", "Companion", "plugin-story_release"})
/* renamed from: com.tencent.mm.plugin.story.ui.view.gallery.j */
public final class C4185j extends C17491an {
    private static final String TAG = TAG;
    public static final C4184a soO = new C4184a();
    private C17487am soM;
    private C17487am soN;

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u0005"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/view/gallery/PageScrollHelper$Companion;", "", "()V", "TAG", "", "plugin-story_release"})
    /* renamed from: com.tencent.mm.plugin.story.ui.view.gallery.j$a */
    public static final class C4184a {
        private C4184a() {
        }

        public /* synthetic */ C4184a(byte b) {
            this();
        }
    }

    static {
        AppMethodBeat.m2504i(110762);
        AppMethodBeat.m2505o(110762);
    }

    /* JADX WARNING: Missing block: B:7:0x0043, code skipped:
            if ((r1 != null ? r1.getLayoutManager() : null) != r8) goto L_0x0045;
     */
    /* JADX WARNING: Missing block: B:20:0x006a, code skipped:
            if (r0 != r8) goto L_0x006c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public final int[] mo9101a(C17480i c17480i, View view) {
        C17487am c17487am;
        C17480i c17480i2 = null;
        AppMethodBeat.m2504i(110760);
        C25052j.m39376p(c17480i, "layoutManager");
        C25052j.m39376p(view, "targetView");
        C4990ab.m7416i(TAG, "LogStory: calculateDistanceToFinalSnap " + C17480i.m27148bt(view));
        int[] iArr = new int[2];
        if (c17480i.mo1776iG()) {
            if (this.soN != null) {
                c17487am = this.soN;
            }
            this.soN = C17487am.m27241d(c17480i);
            c17487am = this.soN;
            if (c17487am == null) {
                C25052j.dWJ();
            }
            iArr[0] = C4185j.m6537a(c17480i, view, c17487am);
        } else {
            iArr[0] = 0;
        }
        if (c17480i.mo1777iH()) {
            if (this.soM != null) {
                c17487am = this.soM;
                if (c17487am != null) {
                    c17480i2 = c17487am.getLayoutManager();
                }
            }
            this.soM = C17487am.m27242e(c17480i);
            C17487am c17487am2 = this.soM;
            if (c17487am2 == null) {
                C25052j.dWJ();
            }
            iArr[1] = C4185j.m6537a(c17480i, view, c17487am2);
        } else {
            iArr[1] = 0;
        }
        AppMethodBeat.m2505o(110760);
        return iArr;
    }

    /* renamed from: a */
    private static int m6537a(C17480i c17480i, View view, C17487am c17487am) {
        int bD;
        AppMethodBeat.m2504i(110761);
        if (c17480i.mo1776iG()) {
            bD = C17480i.m27146bD(view) + C17480i.m27147bE(view);
        } else {
            bD = C17480i.m27144bB(view) + C17480i.m27145bC(view);
        }
        int bf = c17487am.mo31893bf(view) + ((c17487am.mo31897bj(view) - bD) / 2);
        if (c17480i.getClipToPadding()) {
            bD = c17487am.mo31905je() + (c17487am.mo31907jg() / 2);
        } else {
            bD = c17487am.getEnd() / 2;
        }
        bD = bf - bD;
        AppMethodBeat.m2505o(110761);
        return bD;
    }
}
