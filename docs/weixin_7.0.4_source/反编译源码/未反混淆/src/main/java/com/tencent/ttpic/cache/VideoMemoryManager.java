package com.tencent.ttpic.cache;

import android.graphics.Bitmap;
import android.opengl.ETC1Util.ETC1Texture;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.ttpic.baseutils.BitmapUtils;
import com.tencent.ttpic.cache.LoadItemManager.LOAD_TYPE;
import com.tencent.ttpic.device.DeviceInstance;
import com.tencent.ttpic.device.DeviceUtils;
import com.tencent.ttpic.filter.FabbyMvPart;
import com.tencent.ttpic.gameplaysdk.model.StickerItem3D;
import com.tencent.ttpic.model.FaceFeatureItem;
import com.tencent.ttpic.model.FaceItem;
import com.tencent.ttpic.model.MultiViewerItem;
import com.tencent.ttpic.model.StickerItem;
import com.tencent.ttpic.model.VideoMaterial;
import com.tencent.ttpic.util.FaceOffUtil.FEATURE_TYPE;
import com.tencent.ttpic.util.VideoFilterFactory.STICKER_TYPE;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class VideoMemoryManager {
    private static final String TAG = VideoMemoryManager.class.getSimpleName();
    public static final int VIDEO_CACHE_MEM_CACHE_MIN_SIZE_IN_KB = 51200;
    public static final int VIDEO_CACHE_MEM_CACHE_REMAIN_SIZE = 10240;
    private static final VideoMemoryManager mInstance = new VideoMemoryManager();
    private final Map<String, Bitmap> mBeautyFaceCache = new ConcurrentHashMap();
    private final Map<String, Bitmap> mCache = new ConcurrentHashMap();
    private double mCurMaterialSizeInMB;
    private final Map<String, ETC1Texture> mETCCache = new ConcurrentHashMap();
    private final Map<FEATURE_TYPE, Bitmap> mGrayCache = new ConcurrentHashMap();
    private final Handler mHandler = new Handler(HandlerThreadManager.getInstance().getHanderThread(TAG).getLooper());
    private int mInitSampleSize = 1;
    private int mMaxPreloadSizeInKB;
    private int mSampleSize;
    private final Map<String, LoadItemManager> managers = new ConcurrentHashMap();

    static /* synthetic */ long access$100(VideoMemoryManager videoMemoryManager, VideoMaterial videoMaterial) {
        AppMethodBeat.i(81847);
        long materialImageSizeInKB = videoMemoryManager.getMaterialImageSizeInKB(videoMaterial);
        AppMethodBeat.o(81847);
        return materialImageSizeInKB;
    }

    static /* synthetic */ void access$600(VideoMemoryManager videoMemoryManager, VideoMaterial videoMaterial, int i) {
        AppMethodBeat.i(81848);
        videoMemoryManager.loadAllItemsAppend(videoMaterial, i);
        AppMethodBeat.o(81848);
    }

    static /* synthetic */ void access$700(VideoMemoryManager videoMemoryManager, VideoMaterial videoMaterial, int i) {
        AppMethodBeat.i(81849);
        videoMemoryManager.loadImportMaterial(videoMaterial, i);
        AppMethodBeat.o(81849);
    }

    static {
        AppMethodBeat.i(81850);
        AppMethodBeat.o(81850);
    }

    public static VideoMemoryManager getInstance() {
        return mInstance;
    }

    public void setSampleSize(int i) {
        this.mInitSampleSize = i;
    }

    private VideoMemoryManager() {
        AppMethodBeat.i(81833);
        AppMethodBeat.o(81833);
    }

    public void setMaxPreloadMemorySizeInKB(int i) {
        this.mMaxPreloadSizeInKB = i;
    }

    public void loadAllImages(final VideoMaterial videoMaterial) {
        AppMethodBeat.i(81834);
        clear();
        this.mHandler.post(new Runnable() {
            public void run() {
                AppMethodBeat.i(81832);
                long runtimeRemainSize = DeviceUtils.getRuntimeRemainSize(1);
                runtimeRemainSize = Math.min((long) Math.max(Math.min(((double) runtimeRemainSize) * 0.75d, (double) (runtimeRemainSize - 51200)), 0.0d), (long) DeviceInstance.getInstance().getMaxMemorySizeInKB());
                if (VideoMemoryManager.this.mMaxPreloadSizeInKB > 0) {
                    runtimeRemainSize = Math.min(runtimeRemainSize, (long) VideoMemoryManager.this.mMaxPreloadSizeInKB);
                }
                long access$100 = VideoMemoryManager.access$100(VideoMemoryManager.this, videoMaterial);
                VideoMemoryManager.this.mCurMaterialSizeInMB = (double) (access$100 / 1024);
                VideoMemoryManager.this.mSampleSize = VideoMaterialUtil.calSampleSize(runtimeRemainSize, access$100, VideoMemoryManager.this.mInitSampleSize);
                VideoMemoryManager.TAG;
                new StringBuilder("[heap size] = ").append(runtimeRemainSize / 1024).append(" MB, [material size] = ").append(VideoMemoryManager.this.mCurMaterialSizeInMB).append(" MB, [sampleSize] = ").append(VideoMemoryManager.this.mSampleSize);
                VideoMemoryManager.access$600(VideoMemoryManager.this, videoMaterial, VideoMemoryManager.this.mSampleSize);
                VideoMemoryManager.access$700(VideoMemoryManager.this, videoMaterial, VideoMemoryManager.this.mSampleSize);
                for (LoadItemManager prepareImages : VideoMemoryManager.this.managers.values()) {
                    prepareImages.prepareImages();
                }
                AppMethodBeat.o(81832);
            }
        });
        AppMethodBeat.o(81834);
    }

    private void loadImportMaterial(VideoMaterial videoMaterial, int i) {
        AppMethodBeat.i(81835);
        for (MultiViewerItem multiViewerItem : videoMaterial.getMultiViewerItemList()) {
            if (multiViewerItem != null) {
                loadAllItemsAppend(multiViewerItem.videoMaterial, i);
            }
        }
        AppMethodBeat.o(81835);
    }

    private void loadAllItemsAppend(VideoMaterial videoMaterial, int i) {
        AppMethodBeat.i(81836);
        if (videoMaterial == null) {
            AppMethodBeat.o(81836);
            return;
        }
        if (videoMaterial.getFaceOffItemList() != null) {
            for (FaceItem faceItem : videoMaterial.getFaceOffItemList()) {
                if (!VideoMaterialUtil.isEmptyItem(faceItem)) {
                    this.managers.put(TextUtils.isEmpty(faceItem.id) ? faceItem.faceExchangeImage : faceItem.id, new LoadFaceItemManager(this.mCache, this.mGrayCache, videoMaterial.getDataPath(), faceItem, i));
                }
            }
        }
        if (videoMaterial.getFaceFeatureItemList() != null) {
            for (FaceFeatureItem faceFeatureItem : videoMaterial.getFaceFeatureItemList()) {
                if (!(faceFeatureItem == null || faceFeatureItem.getFaceOffItemList() == null)) {
                    for (FaceItem faceItem2 : faceFeatureItem.getFaceOffItemList()) {
                        if (!VideoMaterialUtil.isEmptyItem(faceItem2)) {
                            this.managers.put(TextUtils.isEmpty(faceItem2.id) ? faceItem2.faceExchangeImage : faceItem2.id, new LoadFaceItemManager(this.mCache, this.mGrayCache, faceFeatureItem.getDataPath(), faceItem2, i));
                        }
                    }
                }
            }
        }
        ArrayList<StickerItem> arrayList = new ArrayList();
        if (videoMaterial.getItemList() != null) {
            arrayList.addAll(videoMaterial.getItemList());
        }
        if (videoMaterial.getHeadCropItemList() != null) {
            arrayList.addAll(videoMaterial.getHeadCropItemList());
        }
        if (videoMaterial.getFabbyParts() != null) {
            for (FabbyMvPart fabbyMvPart : videoMaterial.getFabbyParts().getParts()) {
                if (fabbyMvPart.bgItem != null) {
                    arrayList.add(fabbyMvPart.bgItem);
                }
                if (fabbyMvPart.fgItem != null) {
                    arrayList.add(fabbyMvPart.fgItem);
                }
                if (fabbyMvPart.coverItem != null) {
                    arrayList.add(fabbyMvPart.coverItem);
                }
                if (fabbyMvPart.transitionItem != null) {
                    arrayList.add(fabbyMvPart.transitionItem);
                }
            }
        }
        if (videoMaterial.getFaceFeatureItemList() != null) {
            for (FaceFeatureItem faceFeatureItem2 : videoMaterial.getFaceFeatureItemList()) {
                if (!(faceFeatureItem2 == null || faceFeatureItem2.getStickerItems() == null)) {
                    arrayList.addAll(faceFeatureItem2.getStickerItems());
                }
            }
        }
        for (StickerItem stickerItem : arrayList) {
            if (!(this.managers.containsKey(stickerItem.id) || VideoMaterialUtil.isEmptyItem(stickerItem))) {
                if (stickerItem.stickerType == STICKER_TYPE.ETC.type) {
                    this.managers.put(stickerItem.id, new LoadETCItemManager(this.mETCCache, videoMaterial.getDataPath(), stickerItem));
                } else {
                    this.managers.put(stickerItem.id, new LoadStickerItemManager(this.mCache, videoMaterial.getDataPath(), stickerItem, LOAD_TYPE.LOAD_ALL, i));
                }
            }
        }
        List<StickerItem3D> itemList3D = videoMaterial.getItemList3D();
        if (itemList3D != null) {
            if (!(videoMaterial.getGameParams() == null || videoMaterial.getGameParams().textureImages == null)) {
                this.managers.put("", new Load3DTextureManager(videoMaterial.getDataPath(), videoMaterial.getGameParams().textureImages));
            }
            HashSet hashSet = new HashSet();
            for (StickerItem3D stickerItem3D : itemList3D) {
                if (stickerItem3D.id.contains(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D)) {
                    String[] split = stickerItem3D.id.split(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D);
                    if (split.length == 2) {
                        Object obj = split[1];
                        if (!hashSet.contains(obj)) {
                            this.managers.put(stickerItem3D.id, new LoadStickerItemManager3D(videoMaterial.getDataPath(), stickerItem3D, obj, LOAD_TYPE.LOAD_ALL));
                            hashSet.add(obj);
                        }
                    }
                }
            }
        }
        AppMethodBeat.o(81836);
    }

    private long getMaterialImageSizeInKB(VideoMaterial videoMaterial) {
        long j = 0;
        AppMethodBeat.i(81837);
        if (videoMaterial == null) {
            AppMethodBeat.o(81837);
        } else {
            ArrayList<StickerItem> arrayList = new ArrayList();
            if (videoMaterial.getItemList() != null) {
                arrayList.addAll(videoMaterial.getItemList());
            }
            if (videoMaterial.getHeadCropItemList() != null) {
                arrayList.addAll(videoMaterial.getHeadCropItemList());
            }
            if (videoMaterial.getFabbyParts() != null) {
                for (FabbyMvPart fabbyMvPart : videoMaterial.getFabbyParts().getParts()) {
                    if (fabbyMvPart.bgItem != null) {
                        arrayList.add(fabbyMvPart.bgItem);
                    }
                    if (fabbyMvPart.fgItem != null) {
                        arrayList.add(fabbyMvPart.fgItem);
                    }
                    if (fabbyMvPart.coverItem != null) {
                        arrayList.add(fabbyMvPart.coverItem);
                    }
                    if (fabbyMvPart.transitionItem != null) {
                        arrayList.add(fabbyMvPart.transitionItem);
                    }
                }
            }
            if (videoMaterial.getFaceFeatureItemList() != null) {
                for (FaceFeatureItem faceFeatureItem : videoMaterial.getFaceFeatureItemList()) {
                    if (!(faceFeatureItem == null || faceFeatureItem.getStickerItems() == null)) {
                        arrayList.addAll(faceFeatureItem.getStickerItems());
                    }
                }
            }
            for (StickerItem stickerItem : arrayList) {
                j = ((long) (VideoMaterialUtil.getAllImageSize(videoMaterial.getDataPath() + File.separator + stickerItem.subFolder) / WXMediaMessage.DESCRIPTION_LENGTH_LIMIT)) + j;
            }
            if (videoMaterial.getFaceOffItemList() != null) {
                for (FaceItem faceItem : videoMaterial.getFaceOffItemList()) {
                    if (!TextUtils.isEmpty(faceItem.id)) {
                        j += (long) (VideoMaterialUtil.getAllImageSize(videoMaterial.getDataPath() + File.separator + faceItem.id) / WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
                    }
                }
            }
            if (videoMaterial.getFaceFeatureItemList() != null) {
                for (FaceFeatureItem faceFeatureItem2 : videoMaterial.getFaceFeatureItemList()) {
                    if (!(faceFeatureItem2 == null || faceFeatureItem2.getFaceOffItemList() == null)) {
                        for (FaceItem faceItem2 : faceFeatureItem2.getFaceOffItemList()) {
                            if (!TextUtils.isEmpty(faceItem2.id)) {
                                j += (long) (VideoMaterialUtil.getAllImageSize(videoMaterial.getDataPath() + File.separator + faceItem2.id) / WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
                            }
                        }
                    }
                }
            }
            List<MultiViewerItem> multiViewerItemList = videoMaterial.getMultiViewerItemList();
            if (multiViewerItemList != null) {
                for (MultiViewerItem multiViewerItem : multiViewerItemList) {
                    if (multiViewerItem != null) {
                        j += getMaterialImageSizeInKB(multiViewerItem.videoMaterial);
                    }
                }
            }
            AppMethodBeat.o(81837);
        }
        return j;
    }

    public Bitmap loadImage(String str, String str2) {
        AppMethodBeat.i(81838);
        LoadItemManager loadItemManager = (LoadItemManager) this.managers.get(str);
        if (loadItemManager != null) {
            Bitmap loadImage = loadItemManager.loadImage(str2);
            AppMethodBeat.o(81838);
            return loadImage;
        }
        AppMethodBeat.o(81838);
        return null;
    }

    public Bitmap loadImage(String str, int i) {
        AppMethodBeat.i(81839);
        LoadItemManager loadItemManager = (LoadItemManager) this.managers.get(str);
        if (loadItemManager != null) {
            Bitmap loadImage = loadItemManager.loadImage(i);
            AppMethodBeat.o(81839);
            return loadImage;
        }
        AppMethodBeat.o(81839);
        return null;
    }

    public Bitmap loadImage(FEATURE_TYPE feature_type) {
        AppMethodBeat.i(81840);
        Bitmap bitmap = (Bitmap) this.mGrayCache.get(feature_type);
        AppMethodBeat.o(81840);
        return bitmap;
    }

    public ETC1Texture loadETCRGBTexture(String str, int i) {
        AppMethodBeat.i(81841);
        LoadItemManager loadItemManager = (LoadItemManager) this.managers.get(str);
        if (loadItemManager != null) {
            ETC1Texture loadETCRGBTexture = loadItemManager.loadETCRGBTexture(i);
            AppMethodBeat.o(81841);
            return loadETCRGBTexture;
        }
        AppMethodBeat.o(81841);
        return null;
    }

    public ETC1Texture loadETCAlphaTexture(String str, int i) {
        AppMethodBeat.i(81842);
        LoadItemManager loadItemManager = (LoadItemManager) this.managers.get(str);
        if (loadItemManager != null) {
            ETC1Texture loadETCAlphaTexture = loadItemManager.loadETCAlphaTexture(i);
            AppMethodBeat.o(81842);
            return loadETCAlphaTexture;
        }
        AppMethodBeat.o(81842);
        return null;
    }

    public void clear() {
        AppMethodBeat.i(81843);
        for (LoadItemManager clear : this.managers.values()) {
            clear.clear();
        }
        this.managers.clear();
        synchronized (PreLoader.LOCK_IMAGE_PRE_LOADER) {
            try {
                for (Bitmap bitmap : this.mCache.values()) {
                    if (BitmapUtils.isLegal(bitmap)) {
                        bitmap.recycle();
                    }
                }
                for (Bitmap bitmap2 : this.mGrayCache.values()) {
                    if (BitmapUtils.isLegal(bitmap2)) {
                        bitmap2.recycle();
                    }
                }
            } finally {
                AppMethodBeat.o(81843);
            }
        }
        this.mCache.clear();
        this.mGrayCache.clear();
        this.mCurMaterialSizeInMB = 0.0d;
    }

    public void reset(String str) {
        AppMethodBeat.i(81844);
        LoadItemManager loadItemManager = (LoadItemManager) this.managers.get(str);
        if (loadItemManager != null) {
            loadItemManager.reset();
        }
        AppMethodBeat.o(81844);
    }

    public double getMaterialSizeInMB() {
        return this.mCurMaterialSizeInMB;
    }

    public int getSampleSize() {
        return this.mSampleSize;
    }

    public Bitmap getBeautyFaceCacheBitmap(String str) {
        AppMethodBeat.i(81845);
        Bitmap bitmap = (Bitmap) this.mBeautyFaceCache.get(str);
        AppMethodBeat.o(81845);
        return bitmap;
    }

    public void loadBeautyFaceCacheBitmap(List<String> list) {
        AppMethodBeat.i(81846);
        for (String str : list) {
            if (this.mBeautyFaceCache.containsKey(str) && !BitmapUtils.isLegal((Bitmap) this.mBeautyFaceCache.get(str))) {
            }
        }
        AppMethodBeat.o(81846);
    }
}
