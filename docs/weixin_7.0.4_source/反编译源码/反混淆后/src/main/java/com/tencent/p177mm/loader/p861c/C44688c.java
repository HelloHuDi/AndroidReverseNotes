package com.tencent.p177mm.loader.p861c;

import android.graphics.Bitmap;
import com.tencent.p177mm.loader.p245d.C1749a;
import com.tencent.p177mm.loader.p245d.C32725b;
import com.tencent.p177mm.loader.p245d.C32727c;
import com.tencent.p177mm.loader.p245d.C32728d;
import com.tencent.p177mm.loader.p245d.C32729e;
import com.tencent.p177mm.loader.p246e.C1757e;
import com.tencent.p177mm.loader.p246e.C1759g;
import com.tencent.p177mm.loader.p246e.C32732c;
import com.tencent.p177mm.loader.p246e.C36696b;
import com.tencent.p177mm.loader.p246e.C45418a;
import com.tencent.p177mm.loader.p246e.p1195a.C37880a;
import com.tencent.p177mm.loader.p246e.p862c.C9569a;
import com.tencent.p177mm.loader.p858b.p859a.C26352d;
import com.tencent.p177mm.loader.p858b.p859a.C45417b;
import com.tencent.p177mm.loader.p858b.p860b.C18529a;
import com.tencent.p177mm.loader.p858b.p860b.C9566c;
import com.tencent.p177mm.loader.p863f.C32733f;
import com.tencent.p177mm.loader.p863f.C9573b;
import com.tencent.p177mm.loader.p863f.C9575e;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006H\u0016J\u0010\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\bH\u0016J\u0014\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\nH\u0016J\n\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\u000e\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00020\u000eH\u0016J\n\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\n\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\u000e\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00030\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u001cH\u0016J\n\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\u0014\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030 H\u0016¨\u0006!"}, dWq = {"Lcom/tencent/mm/loader/cfg/DefaultImageLoaderConfiguration;", "Lcom/tencent/mm/loader/cfg/ILoaderConfiguration;", "", "Landroid/graphics/Bitmap;", "()V", "headResourceTranscoder", "Lcom/tencent/mm/loader/impr/transcoder/HeadResourceTranscoder;", "imageBatchGet", "Lcom/tencent/mm/loader/common/IDataBatchFetcher;", "imageDiskCache", "Lcom/tencent/mm/loader/cache/disk/IDiskCache;", "imageDownloadTaskExecutor", "Lcom/tencent/mm/loader/common/IImageLoaderExecutor;", "imageDownloader", "Lcom/tencent/mm/loader/common/IDataFetcher;", "imageFileBrokenCallback", "Lcom/tencent/mm/loader/listener/IImageFileBrokenCallback;", "imageFileNameCreator", "Lcom/tencent/mm/loader/listener/ILoadFileNameCreator;", "imageLoadReportCallback", "Lcom/tencent/mm/loader/listener/IImageLoaderReportListener;", "imageLoaderOptions", "Lcom/tencent/mm/loader/cfg/ImageLoaderOptions;", "imageMd5CheckListener", "Lcom/tencent/mm/loader/common/IImageMD5Check;", "imageProducer", "Lcom/tencent/mm/loader/common/IImageResourceProducer;", "imageRetryListener", "Lcom/tencent/mm/loader/common/IImageRetryDownload;", "imageTempFileCleanExecutor", "Ljava/util/concurrent/Executor;", "memoryCache", "Lcom/tencent/mm/loader/cache/memory/IMemoryCache;", "libimageloader_release"})
/* renamed from: com.tencent.mm.loader.c.c */
public final class C44688c implements C42153d<String, Bitmap> {
    /* renamed from: Tq */
    public final C1749a<String> mo20888Tq() {
        return null;
    }

    /* renamed from: Tf */
    public final C9566c<String, Bitmap> mo20877Tf() {
        return new C18529a();
    }

    /* renamed from: Tg */
    public final C26352d<String, Bitmap> mo20878Tg() {
        return new C45417b();
    }

    /* renamed from: Ti */
    public final C32728d<Bitmap> mo20880Ti() {
        return new C37880a();
    }

    /* renamed from: Tk */
    public final C9569a<Bitmap> mo20882Tk() {
        return null;
    }

    /* renamed from: Tl */
    public final C37878e mo20883Tl() {
        C37878e Tr = C37878e.m63924Tr();
        C25052j.m39375o(Tr, "ImageLoaderOptions.createSimpleOption()");
        return Tr;
    }

    /* renamed from: Th */
    public final C32725b<String> mo20879Th() {
        return new C36696b();
    }

    /* renamed from: Tj */
    public final C32733f mo20881Tj() {
        return new C45418a();
    }

    /* renamed from: Tm */
    public final C9575e mo20884Tm() {
        return new C1759g();
    }

    /* renamed from: Tn */
    public final C32727c mo20885Tn() {
        return null;
    }

    /* renamed from: To */
    public final C9573b mo20886To() {
        return new C32732c();
    }

    /* renamed from: Tp */
    public final C32729e mo20887Tp() {
        return new C1757e();
    }
}
