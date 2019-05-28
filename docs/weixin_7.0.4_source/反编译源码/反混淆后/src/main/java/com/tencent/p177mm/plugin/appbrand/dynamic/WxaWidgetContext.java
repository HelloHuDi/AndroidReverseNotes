package com.tencent.p177mm.plugin.appbrand.dynamic;

import android.os.Parcelable;
import com.tencent.p177mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.p177mm.plugin.appbrand.dynamic.debugger.DebuggerInfo;
import com.tencent.p177mm.plugin.appbrand.dynamic.launching.WidgetRuntimeConfig;
import com.tencent.p177mm.plugin.appbrand.dynamic.launching.WidgetSysConfig;

/* renamed from: com.tencent.mm.plugin.appbrand.dynamic.WxaWidgetContext */
public interface WxaWidgetContext extends Parcelable {
    int avn();

    WxaPkgWrappingInfo azF();

    WxaPkgWrappingInfo azG();

    int azH();

    byte[] azI();

    int azJ();

    DebuggerInfo azK();

    WidgetSysConfig azL();

    WidgetRuntimeConfig azM();

    String getAppId();

    String getId();
}
