package com.tencent.tinker.loader;

import android.content.Intent;
import com.tencent.tinker.loader.app.TinkerApplication;

public abstract class AbstractTinkerLoader {
    public abstract Intent tryLoad(TinkerApplication tinkerApplication);
}
