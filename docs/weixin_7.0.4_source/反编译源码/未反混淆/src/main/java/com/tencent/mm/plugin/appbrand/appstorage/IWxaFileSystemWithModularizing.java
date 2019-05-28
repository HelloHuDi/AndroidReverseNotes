package com.tencent.mm.plugin.appbrand.appstorage;

import android.support.annotation.Keep;
import com.tencent.mm.plugin.appbrand.appcache.ao;

@Keep
public interface IWxaFileSystemWithModularizing extends p {
    ao findAppropriateModuleInfo(String str);
}
