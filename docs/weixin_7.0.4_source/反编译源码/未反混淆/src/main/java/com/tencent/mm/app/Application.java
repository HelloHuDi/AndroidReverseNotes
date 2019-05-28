package com.tencent.mm.app;

import com.tencent.tinker.loader.app.TinkerApplication;

public class Application extends TinkerApplication {
    public Application() {
        super(7, "com.tencent.mm.app.MMApplicationLike", "com.tencent.tinker.loader.TinkerLoader", true);
    }
}
