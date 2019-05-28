package com.tencent.p177mm.plugin.sns.p517i;

import android.view.View;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.modelsns.C32830c;
import com.tencent.p177mm.plugin.sns.data.C29036i;
import com.tencent.p177mm.plugin.sns.p520ui.C46251au;
import com.tencent.p177mm.plugin.sns.p520ui.SnsHeader;
import com.tencent.p177mm.plugin.sns.p520ui.item.BaseTimeLineItem.BaseViewHolder;
import com.tencent.p177mm.plugin.sns.storage.C46236n;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.sns.i.a */
public final class C13363a {
    public ListView gKd;
    public int mScreenHeight = 0;
    public int mScreenWidth = 0;
    public SnsHeader qQt;
    public boolean qQu = false;

    /* renamed from: com.tencent.mm.plugin.sns.i.a$b */
    public static class C13364b {
        public int aKu;
        public int aKv;
        public int qQA;
        public int qQB;
        public boolean qQC;
        public String qQD;
        public int qQE;
        public int qQF;
        public int qQG;
        public int qQH;
        public int qQI;
        public int qQJ;
        public int qQK;
        public int qQL;
        public int qQM;
        public int qQN;
        public int qQz;
    }

    /* renamed from: com.tencent.mm.plugin.sns.i.a$a */
    public static class C13365a {
        public int aaF;
        public int mScreenHeight;
        public int mScreenWidth;
        public long qQv;
        public int qQw;
        public int qQx;
        public List<C13364b> qQy;
    }

    /* renamed from: a */
    public final C13365a mo25474a(C46251au c46251au) {
        AppMethodBeat.m2504i(36842);
        int i = C32830c.fQr;
        if (i == 2) {
            AppMethodBeat.m2505o(36842);
            return null;
        } else if (i != 4 || this.qQu) {
            long nanoTime = System.nanoTime();
            C13365a c13365a = new C13365a();
            c13365a.qQv = System.currentTimeMillis();
            c13365a.mScreenHeight = this.mScreenHeight;
            c13365a.mScreenWidth = this.mScreenWidth;
            int top = this.qQt.getTop();
            i = this.qQt.getHeight();
            if (top < 0) {
                i += top;
            }
            c13365a.qQx = i;
            top = this.gKd.getFirstVisiblePosition() - 1;
            int lastVisiblePosition = this.gKd.getLastVisiblePosition() - 1;
            c13365a.qQw = top;
            c13365a.aaF = lastVisiblePosition;
            int count = c46251au.getCount();
            boolean z = false;
            if (this.gKd.getChildAt(0) != null) {
                z = this.gKd.getChildAt(0) instanceof SnsHeader;
            }
            C4990ab.m7419v("MicroMsg.CaptureSnsHelper", "first last %s %s isHeaderExist %s", Integer.valueOf(top), Integer.valueOf(lastVisiblePosition), Boolean.valueOf(z));
            i = z ? 1 : 0;
            int childCount = this.gKd.getChildCount();
            int i2 = top;
            while (i2 <= lastVisiblePosition) {
                if (i2 < count && i2 >= 0) {
                    if (i >= childCount) {
                        C4990ab.m7413e("MicroMsg.CaptureSnsHelper", "childPos biger than childCount %d %d", Integer.valueOf(i), Integer.valueOf(childCount));
                    } else {
                        int left;
                        int height;
                        int width;
                        if (c13365a.qQy == null) {
                            c13365a.qQy = new LinkedList();
                        }
                        C13364b c13364b = new C13364b();
                        c13365a.qQy.add(c13364b);
                        View childAt = this.gKd.getChildAt(i);
                        top = i + 1;
                        if (childAt != null) {
                            i = childAt.getTop();
                            left = childAt.getLeft();
                            height = childAt.getHeight();
                            width = childAt.getWidth();
                            C46236n DP = c46251au.mo74340DP(i2);
                            c13364b.qQD = C29036i.m46115j(DP);
                            c13364b.qQB = DP.field_type;
                            c13364b.qQC = DP.mo74253DI(32);
                            c13364b.qQz = i;
                            c13364b.qQA = left;
                            c13364b.aKv = height;
                            c13364b.aKu = width;
                        }
                        if (!(childAt == null || childAt.getTag() == null || !(childAt.getTag() instanceof BaseViewHolder))) {
                            BaseViewHolder baseViewHolder = (BaseViewHolder) childAt.getTag();
                            if (baseViewHolder.rHW && baseViewHolder.rgx != null) {
                                int top2 = baseViewHolder.rgx.getTop();
                                left = baseViewHolder.rgx.getLeft();
                                height = baseViewHolder.rHO.getHeight();
                                width = baseViewHolder.rHO.getWidth();
                                int top3 = baseViewHolder.rHP.getTop() + top2;
                                int left2 = baseViewHolder.rHP.getLeft() + left;
                                int height2 = baseViewHolder.rHP.getHeight();
                                int width2 = baseViewHolder.rHP.getWidth();
                                C4990ab.m7419v("MicroMsg.CaptureSnsHelper", "holder position %s %s index %s", Integer.valueOf(baseViewHolder.position), Integer.valueOf(i2), Integer.valueOf(top));
                                if (baseViewHolder.qCX.xao != 0) {
                                    c13364b.qQF = baseViewHolder.qCX.xao;
                                    c13364b.qQG = top2;
                                    c13364b.qQH = left;
                                    c13364b.qQI = width;
                                    c13364b.qQJ = height;
                                }
                                if (baseViewHolder.qCX.xar != 0) {
                                    c13364b.qQE = baseViewHolder.qCX.xar;
                                    c13364b.qQL = left2;
                                    c13364b.qQK = top3;
                                    c13364b.qQM = width2;
                                    c13364b.qQN = height2;
                                }
                            }
                        }
                        i = top;
                    }
                }
                i2++;
            }
            C4990ab.m7416i("MicroMsg.CaptureSnsHelper", "end cap: " + (System.nanoTime() - nanoTime));
            AppMethodBeat.m2505o(36842);
            return c13365a;
        } else {
            AppMethodBeat.m2505o(36842);
            return null;
        }
    }
}
