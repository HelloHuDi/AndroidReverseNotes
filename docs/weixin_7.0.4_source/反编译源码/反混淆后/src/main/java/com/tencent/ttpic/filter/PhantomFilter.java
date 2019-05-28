package com.tencent.ttpic.filter;

import android.graphics.Bitmap;
import com.tencent.filter.C25624m.C0934g;
import com.tencent.filter.C25624m.C0935i;
import com.tencent.filter.C25624m.C25628k;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.BitmapUtils;
import com.tencent.ttpic.baseutils.FileUtils;
import com.tencent.ttpic.config.MediaConfig;
import com.tencent.ttpic.model.PhantomItem;
import com.tencent.ttpic.model.WMElement;
import com.tencent.ttpic.util.VideoGlobalContext;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PhantomFilter extends VideoFilterBase {
    public static final String FRAGMENT_SHADER = FileUtils.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/PhantomFragmentShader.dat");
    private static final String TAG = PhantomFilter.class.getSimpleName();
    public static final String VERTEX_SHADER = FileUtils.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/PhantomVertexShader.dat");
    private final int MAX_ITEM_SIZE = 8;
    private List<Bitmap> bitmaps = new ArrayList();
    private List<PhantomItem> items = null;
    private long mLastTimestamp = 0;
    private List<String> maskNames = new ArrayList();

    static {
        AppMethodBeat.m2504i(82730);
        AppMethodBeat.m2505o(82730);
    }

    public PhantomFilter(List<PhantomItem> list) {
        super(VERTEX_SHADER, FRAGMENT_SHADER);
        AppMethodBeat.m2504i(82727);
        this.items = list;
        initParams();
        AppMethodBeat.m2505o(82727);
    }

    public void initParams() {
        AppMethodBeat.m2504i(82728);
        int i = 1;
        float[] fArr = new float[8];
        float[] fArr2 = new float[8];
        float[] fArr3 = new float[8];
        float[] fArr4 = new float[8];
        float[] fArr5 = new float[8];
        Iterator it = this.items.iterator();
        while (true) {
            int i2 = i;
            if (!it.hasNext()) {
                break;
            }
            PhantomItem phantomItem = (PhantomItem) it.next();
            if (i2 > 8) {
                break;
            }
            if (phantomItem.getScale() != 0.0d) {
                fArr2[i2 - 1] = (float) (1.0d / phantomItem.getScale());
            } else {
                fArr2[i2 - 1] = 1.0f;
            }
            fArr3[i2 - 1] = (float) phantomItem.getOpacity();
            fArr[i2 - 1] = (float) phantomItem.getBlendMode();
            fArr4[i2 - 1] = (float) phantomItem.getxOffset();
            fArr5[i2 - 1] = (float) phantomItem.getyOffset();
            phantomItem.setXtime(phantomItem.getxRange()[0]);
            phantomItem.setYtime(phantomItem.getyRange()[0]);
            int indexOf = this.maskNames.indexOf(phantomItem.getMaskImage());
            if (indexOf < 0) {
                Bitmap decodeSampledBitmapFromAssets;
                String str = phantomItem.getDataPath() + File.separator + phantomItem.getMaskImage();
                if (str.startsWith("assets://")) {
                    decodeSampledBitmapFromAssets = BitmapUtils.decodeSampledBitmapFromAssets(VideoGlobalContext.getContext(), FileUtils.getRealPath(str), MediaConfig.VIDEO_IMAGE_WIDTH, MediaConfig.VIDEO_IMAGE_HEIGHT);
                } else {
                    decodeSampledBitmapFromAssets = BitmapUtils.decodeSampledBitmapFromFile(str, MediaConfig.VIDEO_IMAGE_WIDTH, MediaConfig.VIDEO_IMAGE_HEIGHT);
                }
                if (BitmapUtils.isLegal(decodeSampledBitmapFromAssets)) {
                    this.maskNames.add(phantomItem.getMaskImage());
                    this.bitmaps.add(decodeSampledBitmapFromAssets);
                    addParam(new C25628k("inputImageTexture_".concat(String.valueOf(i2)), decodeSampledBitmapFromAssets, 33985 + i2, true));
                    new StringBuilder("PhantomFitler inputImageTexuture_").append(i2).append(" mask bitmap loaded. ").append(phantomItem.getMaskImage());
                }
            } else {
                addParam(new C25628k("inputImageTexture_".concat(String.valueOf(i2)), (Bitmap) this.bitmaps.get(indexOf), 33985 + i2, true));
                new StringBuilder("PhantomFitler inputImageTexuture_").append(i2).append(" mask bitmap already loaded. ").append(phantomItem.getMaskImage());
            }
            i = i2 + 1;
        }
        addParam(new C0935i("itemCount", this.items.size()));
        addParam(new C0934g(WMElement.ANIMATE_TYPE_SCALE, fArr2));
        addParam(new C0934g("opacity", fArr3));
        addParam(new C0934g("blendMode", fArr));
        addParam(new C0934g("offsetX", fArr4));
        addParam(new C0934g("offsetY", fArr5));
        AppMethodBeat.m2505o(82728);
    }

    public void updatePreview(long j) {
        long j2;
        AppMethodBeat.m2504i(82729);
        if (this.mLastTimestamp == 0) {
            this.mLastTimestamp = j;
            j2 = 0;
        } else {
            long j3 = j - this.mLastTimestamp;
            this.mLastTimestamp = j;
            j2 = j3;
        }
        int i = 1;
        float[] fArr = new float[8];
        float[] fArr2 = new float[8];
        Iterator it = this.items.iterator();
        while (true) {
            int i2 = i;
            if (it.hasNext()) {
                PhantomItem phantomItem = (PhantomItem) it.next();
                phantomItem.makeXStep(j2);
                double toRadians = Math.toRadians(phantomItem.getXtime());
                fArr[i2 - 1] = (float) (((Math.cos(toRadians + phantomItem.getyPhase()) * phantomItem.getxBcos()) + ((phantomItem.getxK() * toRadians) + (phantomItem.getxAsin() * Math.sin(phantomItem.getxPhase() + toRadians)))) + phantomItem.getxOffset());
                phantomItem.makeYStep(j2);
                toRadians = Math.toRadians(phantomItem.getYtime());
                fArr2[i2 - 1] = (float) (((Math.cos(toRadians + phantomItem.getyPhase()) * phantomItem.getyBcos()) + ((phantomItem.getyK() * toRadians) + (phantomItem.getyAsin() * Math.sin(phantomItem.getyPhase() + toRadians)))) + phantomItem.getyOffset());
                i = i2 + 1;
            } else {
                addParam(new C0934g("offsetX", fArr));
                addParam(new C0934g("offsetY", fArr2));
                AppMethodBeat.m2505o(82729);
                return;
            }
        }
    }
}
