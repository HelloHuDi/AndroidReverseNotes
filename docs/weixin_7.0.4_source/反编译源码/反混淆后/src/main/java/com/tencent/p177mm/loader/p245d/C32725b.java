package com.tencent.p177mm.loader.p245d;

import com.tencent.p177mm.loader.p1197h.C42162f;
import com.tencent.p177mm.loader.p1197h.p1198a.C42156a;
import com.tencent.p177mm.loader.p863f.C32733f;
import com.tencent.p177mm.loader.p864g.C9576b;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0002\u0010\u0011B\u0005¢\u0006\u0002\u0010\u0003J,\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rJ&\u0010\u000e\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000fH$¨\u0006\u0012"}, dWq = {"Lcom/tencent/mm/loader/common/IDataFetcher;", "T", "", "()V", "loadData", "", "url", "Lcom/tencent/mm/loader/model/data/DataItem;", "fileNameCreator", "Lcom/tencent/mm/loader/listener/ILoadFileNameCreator;", "loader", "Lcom/tencent/mm/loader/loader/ITaskLoader;", "callback", "Lcom/tencent/mm/loader/common/IDataFetcher$IDataReady;", "loadDataImp", "Lcom/tencent/mm/loader/common/IDataFetcher$IDataReady2;", "IDataReady", "IDataReady2", "libimageloader_release"})
/* renamed from: com.tencent.mm.loader.d.b */
public abstract class C32725b<T> {

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bd\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u00020\u00032\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&J\b\u0010\u0007\u001a\u00020\u0003H&¨\u0006\b"}, dWq = {"Lcom/tencent/mm/loader/common/IDataFetcher$IDataReady2;", "", "onDataReady", "", "resp", "Lcom/tencent/mm/loader/model/Response;", "onError", "onTransferToBatchGet", "libimageloader_release"})
    /* renamed from: com.tencent.mm.loader.d.b$b */
    public interface C18531b {
        /* renamed from: a */
        void mo33782a(C42162f<?> c42162f);

        void onError();
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u00020\u00032\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&J\b\u0010\u0007\u001a\u00020\u0003H&¨\u0006\b"}, dWq = {"Lcom/tencent/mm/loader/common/IDataFetcher$IDataReady;", "", "onDataReady", "", "resp", "Lcom/tencent/mm/loader/model/Response;", "onError", "onTransferToBatchGet", "libimageloader_release"})
    /* renamed from: com.tencent.mm.loader.d.b$a */
    public interface C26356a {
        /* renamed from: a */
        void mo44154a(C42162f<?> c42162f);

        void onError();
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002H\n¢\u0006\u0002\b\u0003"}, dWq = {"<anonymous>", "", "T", "run"})
    /* renamed from: com.tencent.mm.loader.d.b$c */
    public static final class C32726c implements Runnable {
        final /* synthetic */ C32725b eQm;
        final /* synthetic */ C9576b eQn;
        final /* synthetic */ C42156a eQo;
        final /* synthetic */ C32733f eQp;
        final /* synthetic */ C26356a eQq;

        @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002H\n¢\u0006\u0002\b\u0003"}, dWq = {"<anonymous>", "", "T", "run"})
        /* renamed from: com.tencent.mm.loader.d.b$c$1 */
        static final class C263571 implements Runnable {
            final /* synthetic */ C32726c eQr;

            @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u00020\u00032\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0003H\u0016J\b\u0010\u0007\u001a\u00020\u0003H\u0016¨\u0006\b"}, dWq = {"com/tencent/mm/loader/common/IDataFetcher$loadData$1$1$1", "Lcom/tencent/mm/loader/common/IDataFetcher$IDataReady2;", "onDataReady", "", "resp", "Lcom/tencent/mm/loader/model/Response;", "onError", "onTransferToBatchGet", "libimageloader_release"})
            /* renamed from: com.tencent.mm.loader.d.b$c$1$1 */
            public static final class C263581 implements C18531b {
                final /* synthetic */ C263571 eQs;

                C263581(C263571 c263571) {
                    this.eQs = c263571;
                }

                /* renamed from: a */
                public final void mo33782a(C42162f<?> c42162f) {
                    C25052j.m39376p(c42162f, "resp");
                    this.eQs.eQr.eQq.mo44154a(c42162f);
                }

                public final void onError() {
                    this.eQs.eQr.eQq.onError();
                }
            }

            C263571(C32726c c32726c) {
                this.eQr = c32726c;
            }

            public final void run() {
                this.eQr.eQm.mo37770a(this.eQr.eQo, this.eQr.eQp, new C263581(this));
            }
        }

        public C32726c(C32725b c32725b, C9576b c9576b, C42156a c42156a, C32733f c32733f, C26356a c26356a) {
            this.eQm = c32725b;
            this.eQn = c9576b;
            this.eQo = c42156a;
            this.eQp = c32733f;
            this.eQq = c26356a;
        }

        public final void run() {
            this.eQn.execute(new C263571(this));
        }
    }

    /* renamed from: a */
    public abstract void mo37770a(C42156a<T> c42156a, C32733f c32733f, C18531b c18531b);
}
