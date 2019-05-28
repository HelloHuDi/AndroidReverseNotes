package com.tencent.mm.plugin.appbrand.jsapi.camera;

import android.view.View;
import com.tencent.mm.plugin.appbrand.jsapi.f.b;
import com.tencent.mm.plugin.appbrand.jsapi.f.c;
import com.tencent.mm.plugin.appbrand.jsapi.f.d;

public interface e extends b, c, d {
    public static final e hGY = new e() {
        public final void setMode(String str) {
        }

        public final void setFrameLimitSize(int i) {
        }

        public final void wU() {
        }

        public final void wW() {
        }

        public final void onDestroy() {
        }

        public final void setCameraId(int i) {
        }

        public final int getCameraId() {
            return 0;
        }

        public final void ai(String str, boolean z) {
        }

        public final void setFlash(String str) {
        }

        public final void setNeedOutput(boolean z) {
        }

        public final boolean da(int i, int i2) {
            return false;
        }

        public final void setQuality(String str) {
        }

        public final void setOperateCallBack(c cVar) {
        }

        public final void setOutPutCallBack(b bVar) {
        }

        public final void setScanFreq(int i) {
        }

        public final void w(int i, int i2, int i3, int i4) {
        }

        public final void aDd() {
        }

        public final void aDm() {
        }

        public final void aDn() {
        }

        public final void aDf() {
        }

        public final void n(com.tencent.mm.plugin.appbrand.jsapi.c cVar) {
        }

        public final void aDg() {
        }

        public final void initView() {
        }

        public final View getView() {
            return null;
        }

        public final void release() {
        }

        public final void setAppId(String str) {
        }

        public final void setPage(com.tencent.mm.plugin.appbrand.jsapi.e eVar) {
        }
    };

    void aDd();

    void aDf();

    void aDg();

    void aDm();

    void aDn();

    void ai(String str, boolean z);

    boolean da(int i, int i2);

    int getCameraId();

    View getView();

    void initView();

    void n(com.tencent.mm.plugin.appbrand.jsapi.c cVar);

    void release();

    void setAppId(String str);

    void setCameraId(int i);

    void setFlash(String str);

    void setFrameLimitSize(int i);

    void setMode(String str);

    void setNeedOutput(boolean z);

    void setOperateCallBack(c cVar);

    void setOutPutCallBack(b bVar);

    void setPage(com.tencent.mm.plugin.appbrand.jsapi.e eVar);

    void setQuality(String str);

    void setScanFreq(int i);

    void w(int i, int i2, int i3, int i4);
}
