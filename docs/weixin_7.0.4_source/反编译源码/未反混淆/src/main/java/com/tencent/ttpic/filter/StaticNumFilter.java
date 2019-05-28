package com.tencent.ttpic.filter;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.PointF;
import com.tencent.filter.m.i;
import com.tencent.filter.m.k;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.PTDetectInfo;
import com.tencent.ttpic.baseutils.BitmapUtils;
import com.tencent.ttpic.baseutils.FileUtils;
import com.tencent.ttpic.cache.VideoMemoryManager;
import com.tencent.ttpic.config.MediaConfig;
import com.tencent.ttpic.gles.GlUtil;
import com.tencent.ttpic.model.StickerItem;
import com.tencent.ttpic.model.TRIGGERED_STATUS;
import com.tencent.ttpic.util.AlgoUtils;
import com.tencent.ttpic.util.VideoGlobalContext;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StaticNumFilter extends NormalVideoFilter {
    private Map<String, Point> mBitSizeMap = new HashMap();
    private boolean mIsUnitExists = false;
    private int mLastBitIndex = -1;
    private Map<String, Integer> mLastImageIndexMap = new HashMap();
    private int mNum = -1;
    private k mTextureParam;

    public StaticNumFilter(StickerItem stickerItem, String str) {
        super(stickerItem, str);
        AppMethodBeat.i(82954);
        AppMethodBeat.o(82954);
    }

    public void initParams() {
        AppMethodBeat.i(82955);
        addParam(new i("texNeedTransform", -1));
        addParam(new i("blendMode", this.item.blendMode));
        AppMethodBeat.o(82955);
    }

    public void updateVideoSize(int i, int i2, double d) {
        AppMethodBeat.i(82956);
        super.updateVideoSize(i, i2, d);
        AppMethodBeat.o(82956);
    }

    public void updatePreview(PTDetectInfo pTDetectInfo) {
        AppMethodBeat.i(82957);
        updatePlayer(updateActionTriggered(pTDetectInfo) == TRIGGERED_STATUS.FIRST_TRIGGERED);
        if (!needRenderTexture()) {
            clearTextureParam();
            setNum(-1);
        }
        AppMethodBeat.o(82957);
    }

    public void clearTextureParam() {
        AppMethodBeat.i(82958);
        if (this.mTextureParam != null) {
            this.mTextureParam.clear();
            this.mTextureParam = null;
        }
        setPositions(GlUtil.EMPTY_POSITIONS);
        AppMethodBeat.o(82958);
    }

    /* Access modifiers changed, original: protected */
    public void updatePositions(List<PointF> list, float[] fArr, float f) {
    }

    private Bitmap getNextFrame(String str, int i, int i2) {
        AppMethodBeat.i(82959);
        Bitmap loadImage = VideoMemoryManager.getInstance().loadImage(str, str + "_" + i2 + "_" + (i == -1 ? VideoMaterialUtil.CRAZYFACE_X : Integer.valueOf(i)) + ".png");
        if (BitmapUtils.isLegal(loadImage)) {
            AppMethodBeat.o(82959);
            return loadImage;
        }
        loadImage = loadFromAssetsOrFile(str, i, i2);
        AppMethodBeat.o(82959);
        return loadImage;
    }

    private Bitmap loadFromAssetsOrFile(String str, int i, int i2) {
        AppMethodBeat.i(82960);
        String str2 = this.dataPath + File.separator + str + File.separator + str + "_" + i2 + "_" + (i == -1 ? VideoMaterialUtil.CRAZYFACE_X : Integer.valueOf(i)) + ".png";
        Bitmap decodeSampledBitmapFromAssets;
        if (this.dataPath.startsWith("assets://")) {
            decodeSampledBitmapFromAssets = BitmapUtils.decodeSampledBitmapFromAssets(VideoGlobalContext.getContext(), FileUtils.getRealPath(str2), MediaConfig.VIDEO_OUTPUT_WIDTH, MediaConfig.VIDEO_OUTPUT_HEIGHT);
            AppMethodBeat.o(82960);
            return decodeSampledBitmapFromAssets;
        }
        decodeSampledBitmapFromAssets = BitmapUtils.decodeSampledBitmapFromFile(str2, MediaConfig.VIDEO_OUTPUT_WIDTH, MediaConfig.VIDEO_OUTPUT_HEIGHT);
        AppMethodBeat.o(82960);
        return decodeSampledBitmapFromAssets;
    }

    private void updateTextureParam(String str, int i, int i2) {
        AppMethodBeat.i(82961);
        String str2 = str + "_" + (i == -1 ? VideoMaterialUtil.CRAZYFACE_X : Integer.valueOf(i));
        int frameIndex = this.triggerCtrlItem.getFrameIndex();
        if (i2 == this.mLastBitIndex && this.mLastImageIndexMap.containsKey(str2) && frameIndex == ((Integer) this.mLastImageIndexMap.get(str2)).intValue() && this.mTextureParam != null) {
            AppMethodBeat.o(82961);
            return;
        }
        Bitmap nextFrame = getNextFrame(str, i, frameIndex);
        if (BitmapUtils.isLegal(nextFrame) && needRenderTexture()) {
            if (i == -1) {
                this.mIsUnitExists = true;
            }
            if (!this.mBitSizeMap.containsKey(str2)) {
                this.mBitSizeMap.put(str2, new Point(nextFrame.getWidth(), nextFrame.getHeight()));
            }
            try {
                if (this.mTextureParam != null) {
                    this.mTextureParam.m(nextFrame);
                } else {
                    this.mTextureParam = new k("inputImageTexture2", nextFrame, 33986, false);
                    this.mTextureParam.initialParams(getProgramIds());
                    addParam(this.mTextureParam);
                }
            } catch (Exception e) {
                com.tencent.util.i.m(this, e.getMessage());
            }
            this.mLastImageIndexMap.put(str + "_" + (i == -1 ? VideoMaterialUtil.CRAZYFACE_X : Integer.valueOf(i)), Integer.valueOf(frameIndex));
            AppMethodBeat.o(82961);
            return;
        }
        clearTextureParam();
        AppMethodBeat.o(82961);
    }

    private void updateNumPosition(String str, int i, int i2) {
        AppMethodBeat.i(82962);
        if (this.item == null || this.item.position == null || this.item.position.length < 2) {
            setPositions(GlUtil.EMPTY_POSITIONS);
            AppMethodBeat.o(82962);
            return;
        }
        Point point;
        if (this.mBitSizeMap.containsKey(str)) {
            point = (Point) this.mBitSizeMap.get(str);
        } else {
            point = new Point(this.item.width, this.item.height);
        }
        int i3 = (int) (((((double) point.x) * 1.0d) / ((double) point.y)) * ((double) this.item.height));
        int i4 = (this.item.width - (i2 * i3)) / 2;
        double d;
        int i5;
        int i6;
        if (((double) this.width) / ((double) this.height) >= 0.75d) {
            d = ((double) this.width) / 720.0d;
            int i7 = (int) (((double) this.width) / 0.75d);
            i5 = (int) (((double) ((int) (((double) ((int) (((double) this.width) * this.item.position[0]))) + (((double) (((i2 - i) - 1) * i3)) * d)))) + (((double) i4) * d));
            i6 = ((int) (((double) i7) * (1.0d - this.item.position[1]))) - ((i7 - this.height) / 2);
            setPositions(AlgoUtils.calPositions((float) i5, (float) i6, (float) (((int) (((double) i3) * d)) + i5), (float) ((int) (((double) i6) - (d * ((double) this.item.height)))), this.width, this.height));
            AppMethodBeat.o(82962);
            return;
        }
        d = ((double) this.height) / 960.0d;
        i6 = (int) (((double) this.height) * (1.0d - this.item.position[1]));
        double d2 = ((double) i4) * d;
        i5 = (int) (d2 + ((double) ((int) (((double) ((int) (((double) ((int) (((double) this.height) * 0.75d))) * this.item.position[0]))) + (((double) (((i2 - i) - 1) * i3)) * d)))));
        setPositions(AlgoUtils.calPositions((float) i5, (float) i6, (float) (((int) (((double) i3) * d)) + i5), (float) ((int) (((double) i6) - (d * ((double) this.item.height)))), this.width, this.height));
        AppMethodBeat.o(82962);
    }

    public boolean renderTexture(int i, int i2, int i3) {
        int i4 = 0;
        AppMethodBeat.i(82963);
        if (this.mNum < 0) {
            AppMethodBeat.o(82963);
        } else {
            int totalBit = getTotalBit(this.mNum);
            updateTextureParam(this.item.id, -1, 0);
            if (this.mIsUnitExists) {
                totalBit++;
                updateNumPosition(this.item.id + "_x", 0, totalBit);
                OnDrawFrameGLSL();
                super.renderTexture(i, i2, i3);
                this.mLastBitIndex = 0;
            }
            int i5;
            if (this.mNum < 10) {
                if (this.mIsUnitExists) {
                    i4 = 1;
                }
                updateTextureParam(this.item.id, this.mNum, i4);
                updateNumPosition(this.item.id + "_" + this.mNum, i4, totalBit);
                OnDrawFrameGLSL();
                super.renderTexture(i, i2, i3);
                this.mLastBitIndex = i4;
            } else if (10 > this.mNum || this.mNum >= 100) {
                if (this.mIsUnitExists) {
                    i4 = 1;
                }
                i5 = this.mNum % 10;
                updateTextureParam(this.item.id, i5, i4);
                updateNumPosition(this.item.id + "_" + i5, i4, totalBit);
                OnDrawFrameGLSL();
                super.renderTexture(i, i2, i3);
                this.mLastBitIndex = i4;
                i4++;
                i5 = (this.mNum / 10) % 10;
                updateTextureParam(this.item.id, i5, i4);
                updateNumPosition(this.item.id + "_" + i5, i4, totalBit);
                OnDrawFrameGLSL();
                super.renderTexture(i, i2, i3);
                this.mLastBitIndex = i4;
                i4++;
                i5 = this.mNum / 100;
                updateTextureParam(this.item.id, i5, i4);
                updateNumPosition(this.item.id + "_" + i5, i4, totalBit);
                OnDrawFrameGLSL();
                super.renderTexture(i, i2, i3);
                this.mLastBitIndex = i4;
            } else {
                if (this.mIsUnitExists) {
                    i4 = 1;
                }
                i5 = this.mNum % 10;
                updateTextureParam(this.item.id, i5, i4);
                updateNumPosition(this.item.id + "_" + i5, i4, totalBit);
                OnDrawFrameGLSL();
                super.renderTexture(i, i2, i3);
                this.mLastBitIndex = i4;
                i4++;
                i5 = this.mNum / 10;
                updateTextureParam(this.item.id, i5, i4);
                updateNumPosition(this.item.id + "_" + i5, i4, totalBit);
                OnDrawFrameGLSL();
                super.renderTexture(i, i2, i3);
                this.mLastBitIndex = i4;
            }
            AppMethodBeat.o(82963);
        }
        return true;
    }

    private int getTotalBit(int i) {
        int i2 = 0;
        while (i > 0) {
            i /= 10;
            i2++;
        }
        return i2;
    }

    public void setNum(int i) {
        this.mNum = i;
    }

    public boolean isRenderReady() {
        return this.mNum >= 0;
    }
}
