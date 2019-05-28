package com.tencent.mm.loader.d;

import a.f.b.j;
import a.l;
import com.tencent.mm.loader.h.f;

@l(dWo = {1, 1, 13}, dWp = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0002\u0010\u0011B\u0005¢\u0006\u0002\u0010\u0003J,\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rJ&\u0010\u000e\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000fH$¨\u0006\u0012"}, dWq = {"Lcom/tencent/mm/loader/common/IDataFetcher;", "T", "", "()V", "loadData", "", "url", "Lcom/tencent/mm/loader/model/data/DataItem;", "fileNameCreator", "Lcom/tencent/mm/loader/listener/ILoadFileNameCreator;", "loader", "Lcom/tencent/mm/loader/loader/ITaskLoader;", "callback", "Lcom/tencent/mm/loader/common/IDataFetcher$IDataReady;", "loadDataImp", "Lcom/tencent/mm/loader/common/IDataFetcher$IDataReady2;", "IDataReady", "IDataReady2", "libimageloader_release"})
public abstract class b<T> {

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bd\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u00020\u00032\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&J\b\u0010\u0007\u001a\u00020\u0003H&¨\u0006\b"}, dWq = {"Lcom/tencent/mm/loader/common/IDataFetcher$IDataReady2;", "", "onDataReady", "", "resp", "Lcom/tencent/mm/loader/model/Response;", "onError", "onTransferToBatchGet", "libimageloader_release"})
    public interface b {
        void a(f<?> fVar);

        void onError();
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u00020\u00032\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&J\b\u0010\u0007\u001a\u00020\u0003H&¨\u0006\b"}, dWq = {"Lcom/tencent/mm/loader/common/IDataFetcher$IDataReady;", "", "onDataReady", "", "resp", "Lcom/tencent/mm/loader/model/Response;", "onError", "onTransferToBatchGet", "libimageloader_release"})
    public interface a {
        void a(f<?> fVar);

        void onError();
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002H\n¢\u0006\u0002\b\u0003"}, dWq = {"<anonymous>", "", "T", "run"})
    public static final class c implements Runnable {
        final /* synthetic */ b eQm;
        final /* synthetic */ com.tencent.mm.loader.g.b eQn;
        final /* synthetic */ com.tencent.mm.loader.h.a.a eQo;
        final /* synthetic */ com.tencent.mm.loader.f.f eQp;
        final /* synthetic */ a eQq;

        @l(dWo = {1, 1, 13}, dWp = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002H\n¢\u0006\u0002\b\u0003"}, dWq = {"<anonymous>", "", "T", "run"})
        /* renamed from: com.tencent.mm.loader.d.b$c$1 */
        static final class AnonymousClass1 implements Runnable {
            final /* synthetic */ c eQr;

            @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u00020\u00032\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0003H\u0016J\b\u0010\u0007\u001a\u00020\u0003H\u0016¨\u0006\b"}, dWq = {"com/tencent/mm/loader/common/IDataFetcher$loadData$1$1$1", "Lcom/tencent/mm/loader/common/IDataFetcher$IDataReady2;", "onDataReady", "", "resp", "Lcom/tencent/mm/loader/model/Response;", "onError", "onTransferToBatchGet", "libimageloader_release"})
            /* renamed from: com.tencent.mm.loader.d.b$c$1$1 */
            public static final class AnonymousClass1 implements b {
                final /* synthetic */ AnonymousClass1 eQs;

                AnonymousClass1(AnonymousClass1 anonymousClass1) {
                    this.eQs = anonymousClass1;
                }

                public final void a(f<?> fVar) {
                    j.p(fVar, "resp");
                    this.eQs.eQr.eQq.a(fVar);
                }

                public final void onError() {
                    this.eQs.eQr.eQq.onError();
                }
            }

            AnonymousClass1(c cVar) {
                this.eQr = cVar;
            }

            public final void run() {
                this.eQr.eQm.a(this.eQr.eQo, this.eQr.eQp, new AnonymousClass1(this));
            }
        }

        public c(b bVar, com.tencent.mm.loader.g.b bVar2, com.tencent.mm.loader.h.a.a aVar, com.tencent.mm.loader.f.f fVar, a aVar2) {
            this.eQm = bVar;
            this.eQn = bVar2;
            this.eQo = aVar;
            this.eQp = fVar;
            this.eQq = aVar2;
        }

        public final void run() {
            this.eQn.execute(new AnonymousClass1(this));
        }
    }

    public abstract void a(com.tencent.mm.loader.h.a.a<T> aVar, com.tencent.mm.loader.f.f fVar, b bVar);
}
