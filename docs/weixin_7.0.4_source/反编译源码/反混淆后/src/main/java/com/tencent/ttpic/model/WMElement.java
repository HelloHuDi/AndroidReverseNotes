package com.tencent.ttpic.model;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.PointF;
import android.graphics.RectF;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.BitmapUtils;
import com.tencent.ttpic.logic.watermark.LogicDataManager;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class WMElement {
    public static final String ANIMATE_TYPE_DITHERING = "dithering";
    public static final String ANIMATE_TYPE_SCALE = "scale";
    private static final int EDIT_TYPE_EDITABLE = 1;
    protected static final String INT_D = "%d";
    protected static final String LOGIC = "[logic]";
    private static final String TAG = WMElement.class.getSimpleName();
    public static final int TEXT_SIZE_ADJUST = 1;
    public static final int TEXT_SIZE_FIXED = 0;
    private int active = 0;
    public String alignment;
    public PointF anchor;
    public String animateType;
    private Bitmap[] bitmaps = new Bitmap[2];
    public String color;
    public String curShaderBmp;
    public String curValue;
    protected Set<String> dataKeys = new HashSet();
    public String dataPath;
    public int edittype;
    public boolean emboss;
    public RectF finalContentRect = new RectF();
    protected boolean firstDrew = false;
    public String fmtstr;
    public boolean fontBold;
    public int fontFit;
    public boolean fontItalics;
    public String fontName;
    public float fontSize;
    public String fontTexture;
    public int frameDuration;
    public int frames;
    public int height;
    /* renamed from: id */
    public String f16566id;
    public String imgPath;
    private boolean isContentChanged = false;
    public String itemId;
    public int kern;
    public String lastValue;
    public WMLogic logic;
    public boolean multiRow;
    public int offsetX;
    public int offsetY;
    public String outerStrokeColor;
    public float outerStrokeSize;
    public PointF relativeAnchor;
    public String relativeID;
    public String shaderBmp;
    public String shadowColor;
    public float shadowDx;
    public float shadowDy;
    public float shadowSize;
    public String sid;
    public String strokeColor;
    public float strokeSize;
    public String userValue;
    public int vertical;
    public int width;
    public int wmtype;

    public enum WMType {
        TEXT(1),
        IMAGE(2);
        
        public final int value;

        static {
            AppMethodBeat.m2505o(83588);
        }

        private WMType(int i) {
            this.value = i;
        }
    }

    public abstract boolean updateBitmap(long j, boolean z);

    public abstract boolean updateBitmap(long j, boolean z, boolean z2);

    public void init() {
        clear();
        this.bitmaps[0] = Bitmap.createBitmap(this.width, this.height, Config.ARGB_8888);
        this.bitmaps[1] = Bitmap.createBitmap(this.width, this.height, Config.ARGB_8888);
        if ((this instanceof TextWMElement) && this.edittype == 1) {
            LogicDataManager.getInstance().addEditableWMElement(this);
        }
        Matcher matcher = Pattern.compile("(\\[.+?\\])").matcher(this.wmtype == WMType.TEXT.value ? this.fmtstr : this.imgPath);
        while (matcher.find()) {
            if (matcher.groupCount() > 0) {
                this.dataKeys.add(matcher.group());
            }
        }
        if (!(this.logic == null || TextUtils.isEmpty(this.logic.data))) {
            this.dataKeys.add(this.logic.data);
        }
        if (this.dataKeys.contains(LogicDataManager.f4883DB)) {
            LogicDataManager.getInstance().setNeedDB(true);
        }
        if (!TextUtils.isEmpty(this.shaderBmp)) {
            this.curShaderBmp = String.format(this.shaderBmp, new Object[]{Integer.valueOf(0)});
        }
    }

    public Bitmap getBitmap() {
        return this.bitmaps[this.active];
    }

    public Bitmap getIdleBitmap() {
        return this.bitmaps[this.active ^ 1];
    }

    public void setIdleBitmap(Bitmap bitmap) {
        this.bitmaps[this.active ^ 1] = bitmap;
    }

    public void swapActiveBitmap() {
        this.active ^= 1;
    }

    public void setContentChanged(boolean z) {
        this.isContentChanged = z;
    }

    public boolean isContentChanged() {
        return this.isContentChanged;
    }

    public void clear() {
        for (Bitmap bitmap : this.bitmaps) {
            if (BitmapUtils.isLegal(bitmap)) {
                bitmap.recycle();
            }
        }
        if ((this instanceof TextWMElement) && this.edittype == 1) {
            LogicDataManager.getInstance().removeEditableWMElement(this);
        }
        this.dataKeys.clear();
        this.lastValue = null;
        this.firstDrew = false;
    }

    public void reset() {
    }

    public void setDataPath(String str) {
        this.dataPath = str;
    }
}
