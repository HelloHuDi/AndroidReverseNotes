package com.tencent.ttpic.model;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import com.tencent.ttpic.util.AlgoUtils;
import com.tencent.ttpic.util.BenchUtil;
import java.util.ArrayList;
import java.util.List;

public class SingleScoreActItem extends FrameSourceItem {
    private static final String TAG = SingleScoreActItem.class.getSimpleName();
    private SizeI bitSize = new SizeI(130, ErrorCode.NEEDDOWNLOAD_TRUE);
    protected CaptureActItem captureActItem;

    static {
        AppMethodBeat.i(83523);
        AppMethodBeat.o(83523);
    }

    public SingleScoreActItem(CaptureActItem captureActItem, BaseFilter baseFilter) {
        super(baseFilter);
        AppMethodBeat.i(83517);
        this.captureActItem = captureActItem;
        AppMethodBeat.o(83517);
    }

    public void init() {
    }

    public int getTexture(CanvasItem canvasItem, long j) {
        return -1;
    }

    public void draw(h hVar, CanvasItem canvasItem, long j) {
        AppMethodBeat.i(83518);
        BenchUtil.benchStart(getClass().getSimpleName() + "[draw]");
        List bitList = getBitList(getScore(canvasItem));
        int size = bitList.size();
        for (int i = 0; i < size; i++) {
            int intValue = ((Integer) bitList.get(i)).intValue();
            BenchUtil.benchStart(getClass().getSimpleName() + "[draw] updatePosition");
            updateNumPosition(this.filter, canvasItem, i, size, hVar.width, hVar.height);
            BenchUtil.benchEnd(getClass().getSimpleName() + "[draw] updatePosition");
            BenchUtil.benchStart(getClass().getSimpleName() + "[draw] renderTexture");
            this.filter.OnDrawFrameGLSL();
            this.filter.renderTexture(getScoreTexture(canvasItem)[intValue], hVar.width, hVar.height);
            BenchUtil.benchEnd(getClass().getSimpleName() + "[draw] renderTexture");
        }
        BenchUtil.benchEnd(getClass().getSimpleName() + "[draw]");
        AppMethodBeat.o(83518);
    }

    /* Access modifiers changed, original: protected */
    public int getScore(CanvasItem canvasItem) {
        AppMethodBeat.i(83519);
        int score = this.captureActItem.getScore(canvasItem);
        AppMethodBeat.o(83519);
        return score;
    }

    /* Access modifiers changed, original: protected */
    public int[] getScoreTexture(CanvasItem canvasItem) {
        AppMethodBeat.i(83520);
        int[] scoreTexture = this.captureActItem.getScoreTexture(canvasItem);
        AppMethodBeat.o(83520);
        return scoreTexture;
    }

    private List<Integer> getBitList(int i) {
        AppMethodBeat.i(83521);
        ArrayList arrayList = new ArrayList();
        while (i > 0) {
            arrayList.add(0, Integer.valueOf(i % 10));
            i /= 10;
        }
        if (arrayList.isEmpty()) {
            arrayList.add(Integer.valueOf(0));
        }
        AppMethodBeat.o(83521);
        return arrayList;
    }

    private void updateNumPosition(BaseFilter baseFilter, CanvasItem canvasItem, int i, int i2, int i3, int i4) {
        AppMethodBeat.i(83522);
        float f = (((float) canvasItem.itemRect.height) * 1.0f) / ((float) this.bitSize.height);
        int i5 = (int) (((float) this.bitSize.width) * f);
        int i6 = (int) (f * ((float) this.bitSize.height));
        int i7 = canvasItem.itemRect.y + i6;
        int i8 = (canvasItem.itemRect.x + (i5 * i)) + ((canvasItem.itemRect.width - (i2 * i5)) / 2);
        baseFilter.setPositions(AlgoUtils.calPositions((float) i8, (float) i7, (float) (i5 + i8), (float) (i7 - i6), i3, i4));
        AppMethodBeat.o(83522);
    }

    public void clear() {
    }

    public void reset() {
    }

    public int getOrigWidth(int i) {
        return -1;
    }

    public int getOrigHeight(int i) {
        return -1;
    }
}
