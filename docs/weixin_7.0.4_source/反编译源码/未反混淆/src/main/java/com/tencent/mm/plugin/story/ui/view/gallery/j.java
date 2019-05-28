package com.tencent.mm.plugin.story.ui.view.gallery;

import a.l;
import android.support.v7.widget.RecyclerView.i;
import android.support.v7.widget.am;
import android.support.v7.widget.an;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

@l(dWo = {1, 1, 13}, dWp = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J \u0010\f\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u0004H\u0002J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0002J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/view/gallery/PageScrollHelper;", "Landroid/support/v7/widget/PagerSnapHelper;", "()V", "horizontalHelper", "Landroid/support/v7/widget/OrientationHelper;", "verticalHelper", "calculateDistanceToFinalSnap", "", "layoutManager", "Landroid/support/v7/widget/RecyclerView$LayoutManager;", "targetView", "Landroid/view/View;", "distanceToCenter", "", "helper", "getHorizontalHelper", "getVerticalHelper", "Companion", "plugin-story_release"})
public final class j extends an {
    private static final String TAG = TAG;
    public static final a soO = new a();
    private am soM;
    private am soN;

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u0005"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/view/gallery/PageScrollHelper$Companion;", "", "()V", "TAG", "", "plugin-story_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }

    static {
        AppMethodBeat.i(110762);
        AppMethodBeat.o(110762);
    }

    /* JADX WARNING: Missing block: B:7:0x0043, code skipped:
            if ((r1 != null ? r1.getLayoutManager() : null) != r8) goto L_0x0045;
     */
    /* JADX WARNING: Missing block: B:20:0x006a, code skipped:
            if (r0 != r8) goto L_0x006c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int[] a(i iVar, View view) {
        am amVar;
        i iVar2 = null;
        AppMethodBeat.i(110760);
        a.f.b.j.p(iVar, "layoutManager");
        a.f.b.j.p(view, "targetView");
        ab.i(TAG, "LogStory: calculateDistanceToFinalSnap " + i.bt(view));
        int[] iArr = new int[2];
        if (iVar.iG()) {
            if (this.soN != null) {
                amVar = this.soN;
            }
            this.soN = am.d(iVar);
            amVar = this.soN;
            if (amVar == null) {
                a.f.b.j.dWJ();
            }
            iArr[0] = a(iVar, view, amVar);
        } else {
            iArr[0] = 0;
        }
        if (iVar.iH()) {
            if (this.soM != null) {
                amVar = this.soM;
                if (amVar != null) {
                    iVar2 = amVar.getLayoutManager();
                }
            }
            this.soM = am.e(iVar);
            am amVar2 = this.soM;
            if (amVar2 == null) {
                a.f.b.j.dWJ();
            }
            iArr[1] = a(iVar, view, amVar2);
        } else {
            iArr[1] = 0;
        }
        AppMethodBeat.o(110760);
        return iArr;
    }

    private static int a(i iVar, View view, am amVar) {
        int bD;
        AppMethodBeat.i(110761);
        if (iVar.iG()) {
            bD = i.bD(view) + i.bE(view);
        } else {
            bD = i.bB(view) + i.bC(view);
        }
        int bf = amVar.bf(view) + ((amVar.bj(view) - bD) / 2);
        if (iVar.getClipToPadding()) {
            bD = amVar.je() + (amVar.jg() / 2);
        } else {
            bD = amVar.getEnd() / 2;
        }
        bD = bf - bD;
        AppMethodBeat.o(110761);
        return bD;
    }
}
