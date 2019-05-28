package com.tencent.mm.loader.c;

import a.f.b.j;
import a.l;
import android.graphics.Bitmap;
import com.tencent.mm.loader.b.a.b;
import com.tencent.mm.loader.b.a.d;
import com.tencent.mm.loader.d.a;
import com.tencent.mm.loader.e.g;
import com.tencent.mm.loader.f.e;
import com.tencent.mm.loader.f.f;

@l(dWo = {1, 1, 13}, dWp = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006H\u0016J\u0010\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\bH\u0016J\u0014\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\nH\u0016J\n\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\u000e\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00020\u000eH\u0016J\n\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\n\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\u000e\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00030\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u001cH\u0016J\n\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\u0014\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030 H\u0016¨\u0006!"}, dWq = {"Lcom/tencent/mm/loader/cfg/DefaultImageLoaderConfiguration;", "Lcom/tencent/mm/loader/cfg/ILoaderConfiguration;", "", "Landroid/graphics/Bitmap;", "()V", "headResourceTranscoder", "Lcom/tencent/mm/loader/impr/transcoder/HeadResourceTranscoder;", "imageBatchGet", "Lcom/tencent/mm/loader/common/IDataBatchFetcher;", "imageDiskCache", "Lcom/tencent/mm/loader/cache/disk/IDiskCache;", "imageDownloadTaskExecutor", "Lcom/tencent/mm/loader/common/IImageLoaderExecutor;", "imageDownloader", "Lcom/tencent/mm/loader/common/IDataFetcher;", "imageFileBrokenCallback", "Lcom/tencent/mm/loader/listener/IImageFileBrokenCallback;", "imageFileNameCreator", "Lcom/tencent/mm/loader/listener/ILoadFileNameCreator;", "imageLoadReportCallback", "Lcom/tencent/mm/loader/listener/IImageLoaderReportListener;", "imageLoaderOptions", "Lcom/tencent/mm/loader/cfg/ImageLoaderOptions;", "imageMd5CheckListener", "Lcom/tencent/mm/loader/common/IImageMD5Check;", "imageProducer", "Lcom/tencent/mm/loader/common/IImageResourceProducer;", "imageRetryListener", "Lcom/tencent/mm/loader/common/IImageRetryDownload;", "imageTempFileCleanExecutor", "Ljava/util/concurrent/Executor;", "memoryCache", "Lcom/tencent/mm/loader/cache/memory/IMemoryCache;", "libimageloader_release"})
public final class c implements d<String, Bitmap> {
    public final a<String> Tq() {
        return null;
    }

    public final com.tencent.mm.loader.b.b.c<String, Bitmap> Tf() {
        return new com.tencent.mm.loader.b.b.a();
    }

    public final d<String, Bitmap> Tg() {
        return new b();
    }

    public final com.tencent.mm.loader.d.d<Bitmap> Ti() {
        return new com.tencent.mm.loader.e.a.a();
    }

    public final com.tencent.mm.loader.e.c.a<Bitmap> Tk() {
        return null;
    }

    public final e Tl() {
        e Tr = e.Tr();
        j.o(Tr, "ImageLoaderOptions.createSimpleOption()");
        return Tr;
    }

    public final com.tencent.mm.loader.d.b<String> Th() {
        return new com.tencent.mm.loader.e.b();
    }

    public final f Tj() {
        return new com.tencent.mm.loader.e.a();
    }

    public final e Tm() {
        return new g();
    }

    public final com.tencent.mm.loader.d.c Tn() {
        return null;
    }

    public final com.tencent.mm.loader.f.b To() {
        return new com.tencent.mm.loader.e.c();
    }

    public final com.tencent.mm.loader.d.e Tp() {
        return new com.tencent.mm.loader.e.e();
    }
}
