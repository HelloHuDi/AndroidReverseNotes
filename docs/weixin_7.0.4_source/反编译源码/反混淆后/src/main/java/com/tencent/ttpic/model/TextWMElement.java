package com.tencent.ttpic.model;

import android.graphics.Bitmap;
import android.graphics.RectF;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.logic.watermark.LogicDataManager;
import com.tencent.ttpic.util.BenchUtil;
import com.tencent.ttpic.util.WMTextDrawer;

public class TextWMElement extends WMElement {
    protected static final String INT_D = "%d";
    private long firstTimestamp;
    public RectF mTextRect = new RectF();
    public int rotate = 0;
    private long timestamp;
    public WMTextDrawer wmTextDrawer = new WMTextDrawer();

    public TextWMElement() {
        AppMethodBeat.m2504i(83539);
        AppMethodBeat.m2505o(83539);
    }

    public void init() {
        AppMethodBeat.m2504i(83540);
        super.init();
        if (this.vertical == 2) {
            this.rotate = 90;
        } else if (this.vertical == 3) {
            this.rotate = -90;
        }
        this.curValue = getValue();
        AppMethodBeat.m2505o(83540);
    }

    private String getValue() {
        AppMethodBeat.m2504i(83541);
        String str;
        if (this.userValue == null || isDateWatermark()) {
            str = "";
            if (this.fmtstr != null) {
                str = new String(this.fmtstr);
            }
            if (this.logic != null) {
                str = str.replace("[logic]", this.logic.getValue(this.userValue));
            }
            BenchUtil.benchStart("replaceWithData");
            str = LogicDataManager.getInstance().replaceWithData(str, this.dataKeys);
            BenchUtil.benchEnd("replaceWithData");
            AppMethodBeat.m2505o(83541);
            return str;
        }
        str = this.userValue;
        AppMethodBeat.m2505o(83541);
        return str;
    }

    private boolean isDateWatermark() {
        AppMethodBeat.m2504i(83542);
        if (this.logic == null || this.logic.type == null || !(this.logic.type.equals(WMLogic.TYPE_SINCE) || this.logic.type.equals(WMLogic.TYPE_COUNTDOWN))) {
            AppMethodBeat.m2505o(83542);
            return false;
        }
        AppMethodBeat.m2505o(83542);
        return true;
    }

    public boolean updateBitmap(long j, boolean z) {
        AppMethodBeat.m2504i(83543);
        boolean updateBitmap = updateBitmap(j, z, false);
        AppMethodBeat.m2505o(83543);
        return updateBitmap;
    }

    public boolean updateBitmap(long j, boolean z, boolean z2) {
        boolean z3 = true;
        AppMethodBeat.m2504i(83544);
        BenchUtil.benchStart("TextUpdateBitmap");
        this.timestamp = j;
        if (isAsyncDrawFinished()) {
            this.curValue = getValue();
            if (needUpdateTextBitmap(z)) {
                BenchUtil.benchStart("drawTextToBitmap");
                this.wmTextDrawer.drawTextToBitmap(this, this.curValue, false, z2);
                BenchUtil.benchEnd("drawTextToBitmap");
                this.firstDrew = true;
            } else {
                if (!(TextUtils.isEmpty(this.shaderBmp) || TextUtils.isEmpty(this.wmTextDrawer.lastDrawText))) {
                    this.wmTextDrawer.drawTextToBitmap(this, this.lastValue, true, z2);
                }
                z3 = false;
            }
            this.lastValue = this.curValue;
            BenchUtil.benchEnd("TextUpdateBitmap");
            AppMethodBeat.m2505o(83544);
            return z3;
        }
        AppMethodBeat.m2505o(83544);
        return false;
    }

    public Bitmap getBitmap() {
        AppMethodBeat.m2504i(83545);
        setContentChanged(false);
        Bitmap bitmap = super.getBitmap();
        AppMethodBeat.m2505o(83545);
        return bitmap;
    }

    public boolean updateTextShaderBmp(long j) {
        AppMethodBeat.m2504i(83546);
        if (this.shaderBmp != null) {
            if (isAsyncDrawFinished()) {
                this.timestamp = j;
                String replace = this.shaderBmp.replace(INT_D, String.valueOf(getFrameIndex()));
                if (!(TextUtils.isEmpty(replace) || replace.equals(this.curShaderBmp))) {
                    this.wmTextDrawer.drawTextToBitmap(this, this.lastValue, true, false);
                    AppMethodBeat.m2505o(83546);
                    return true;
                }
            }
            AppMethodBeat.m2505o(83546);
            return false;
        }
        AppMethodBeat.m2505o(83546);
        return false;
    }

    public boolean isAsyncDrawFinished() {
        AppMethodBeat.m2504i(83547);
        boolean isAsyncDrawFinished = this.wmTextDrawer.isAsyncDrawFinished();
        AppMethodBeat.m2505o(83547);
        return isAsyncDrawFinished;
    }

    public int getFrameIndex() {
        if (this.firstTimestamp <= 0) {
            this.firstTimestamp = this.timestamp;
        }
        if (this.frames <= 0) {
            return 0;
        }
        return ((int) ((this.timestamp - this.firstTimestamp) / ((long) this.frameDuration))) % this.frames;
    }

    private boolean needUpdateTextBitmap(boolean z) {
        AppMethodBeat.m2504i(83548);
        if (this.curValue == null || TextUtils.isEmpty(this.curValue) || (!z && this.curValue.equals(this.lastValue) && (this.curValue == null || TextUtils.isEmpty(this.curValue.trim()) || TextUtils.isEmpty(this.animateType)))) {
            AppMethodBeat.m2505o(83548);
            return false;
        }
        AppMethodBeat.m2505o(83548);
        return true;
    }

    private boolean needUpdateTextShaderBmp(long j) {
        AppMethodBeat.m2504i(83549);
        boolean updateTextShaderBmp = updateTextShaderBmp(j);
        AppMethodBeat.m2505o(83549);
        return updateTextShaderBmp;
    }

    public RectF getTextRect() {
        return this.mTextRect;
    }

    public void reset() {
        AppMethodBeat.m2504i(83550);
        this.lastValue = "";
        this.curValue = "";
        this.wmTextDrawer.cancelAsyncDrawTask();
        setContentChanged(false);
        AppMethodBeat.m2505o(83550);
    }
}
