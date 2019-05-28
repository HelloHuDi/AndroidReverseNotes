package com.tencent.mm.plugin.appbrand.appcache.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.g.a.c.k;

public interface b<_Request extends a, _Response, _Progress extends k> {

    public interface a<_Response, _Progress> {

        public enum a {
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
                AppMethodBeat.o(59555);
            }

            private a(int i) {
                this.code = i;
            }
        }

        void a(String str, a aVar, _Response _response);

        void bl(_Progress _progress);
    }
}
