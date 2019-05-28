package com.tencent.p177mm.plugin.appbrand.appcache.p881a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.pluginsdk.p592g.p593a.p596c.C40431k;

/* renamed from: com.tencent.mm.plugin.appbrand.appcache.a.b */
public interface C26735b<_Request extends C10065a, _Response, _Progress extends C40431k> {

    /* renamed from: com.tencent.mm.plugin.appbrand.appcache.a.b$a */
    public interface C26734a<_Response, _Progress> {

        /* renamed from: com.tencent.mm.plugin.appbrand.appcache.a.b$a$a */
        public enum C10067a {
            OK(0),
            FAILED(101),
            LOCAL_FILE_NOT_FOUND(102),
            PKG_INTEGRITY_FAILED(104),
            PKG_INVALID(105),
            SEVER_FILE_NOT_FOUND(106),
            DISK_FULL(110),
            ENV_ERR(200),
            ZSTD_OP_FAILED(301);
            
            public final int code;

            static {
                AppMethodBeat.m2505o(59555);
            }

            private C10067a(int i) {
                this.code = i;
            }
        }

        /* renamed from: a */
        void mo14965a(String str, C10067a c10067a, _Response _response);

        /* renamed from: bl */
        void mo14966bl(_Progress _progress);
    }
}
