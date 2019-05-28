package com.tencent.mm.plugin.sns.i;

import android.view.View;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelsns.c;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.ui.SnsHeader;
import com.tencent.mm.plugin.sns.ui.au;
import com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem.BaseViewHolder;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.LinkedList;
import java.util.List;

public final class a {
    public ListView gKd;
    public int mScreenHeight = 0;
    public int mScreenWidth = 0;
    public SnsHeader qQt;
    public boolean qQu = false;

    public static class b {
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

    public static class a {
        public int aaF;
        public int mScreenHeight;
        public int mScreenWidth;
        public long qQv;
        public int qQw;
        public int qQx;
        public List<b> qQy;
    }

    public final a a(au auVar) {
        AppMethodBeat.i(36842);
        int i = c.fQr;
        if (i == 2) {
            AppMethodBeat.o(36842);
            return null;
        } else if (i != 4 || this.qQu) {
            long nanoTime = System.nanoTime();
            a aVar = new a();
            aVar.qQv = System.currentTimeMillis();
            aVar.mScreenHeight = this.mScreenHeight;
            aVar.mScreenWidth = this.mScreenWidth;
            int top = this.qQt.getTop();
            i = this.qQt.getHeight();
            if (top < 0) {
                i += top;
            }
            aVar.qQx = i;
            top = this.gKd.getFirstVisiblePosition() - 1;
            int lastVisiblePosition = this.gKd.getLastVisiblePosition() - 1;
            aVar.qQw = top;
            aVar.aaF = lastVisiblePosition;
            int count = auVar.getCount();
            boolean z = false;
            if (this.gKd.getChildAt(0) != null) {
                z = this.gKd.getChildAt(0) instanceof SnsHeader;
            }
            ab.v("MicroMsg.CaptureSnsHelper", "first last %s %s isHeaderExist %s", Integer.valueOf(top), Integer.valueOf(lastVisiblePosition), Boolean.valueOf(z));
            i = z ? 1 : 0;
            int childCount = this.gKd.getChildCount();
            int i2 = top;
            while (i2 <= lastVisiblePosition) {
                if (i2 < count && i2 >= 0) {
                    if (i >= childCount) {
                        ab.e("MicroMsg.CaptureSnsHelper", "childPos biger than childCount %d %d", Integer.valueOf(i), Integer.valueOf(childCount));
                    } else {
                        int left;
                        int height;
                        int width;
                        if (aVar.qQy == null) {
                            aVar.qQy = new LinkedList();
                        }
                        b bVar = new b();
                        aVar.qQy.add(bVar);
                        View childAt = this.gKd.getChildAt(i);
                        top = i + 1;
                        if (childAt != null) {
                            i = childAt.getTop();
                            left = childAt.getLeft();
                            height = childAt.getHeight();
                            width = childAt.getWidth();
                            n DP = auVar.DP(i2);
                            bVar.qQD = i.j(DP);
                            bVar.qQB = DP.field_type;
                            bVar.qQC = DP.DI(32);
                            bVar.qQz = i;
                            bVar.qQA = left;
                            bVar.aKv = height;
                            bVar.aKu = width;
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
                                ab.v("MicroMsg.CaptureSnsHelper", "holder position %s %s index %s", Integer.valueOf(baseViewHolder.position), Integer.valueOf(i2), Integer.valueOf(top));
                                if (baseViewHolder.qCX.xao != 0) {
                                    bVar.qQF = baseViewHolder.qCX.xao;
                                    bVar.qQG = top2;
                                    bVar.qQH = left;
                                    bVar.qQI = width;
                                    bVar.qQJ = height;
                                }
                                if (baseViewHolder.qCX.xar != 0) {
                                    bVar.qQE = baseViewHolder.qCX.xar;
                                    bVar.qQL = left2;
                                    bVar.qQK = top3;
                                    bVar.qQM = width2;
                                    bVar.qQN = height2;
                                }
                            }
                        }
                        i = top;
                    }
                }
                i2++;
            }
            ab.i("MicroMsg.CaptureSnsHelper", "end cap: " + (System.nanoTime() - nanoTime));
            AppMethodBeat.o(36842);
            return aVar;
        } else {
            AppMethodBeat.o(36842);
            return null;
        }
    }
}
