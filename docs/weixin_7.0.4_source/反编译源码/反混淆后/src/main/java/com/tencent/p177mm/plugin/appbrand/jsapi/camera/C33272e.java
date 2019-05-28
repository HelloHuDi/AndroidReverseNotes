package com.tencent.p177mm.plugin.appbrand.jsapi.camera;

import android.view.View;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.appbrand.jsapi.C33303e;
import com.tencent.p177mm.plugin.appbrand.jsapi.C45596f.C10379b;
import com.tencent.p177mm.plugin.appbrand.jsapi.C45596f.C10380c;
import com.tencent.p177mm.plugin.appbrand.jsapi.C45596f.C10381d;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.camera.e */
public interface C33272e extends C10379b, C10380c, C10381d {
    public static final C33272e hGY = new C332731();

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.camera.e$1 */
    static class C332731 implements C33272e {
        C332731() {
        }

        public final void setMode(String str) {
        }

        public final void setFrameLimitSize(int i) {
        }

        /* renamed from: wU */
        public final void mo6095wU() {
        }

        /* renamed from: wW */
        public final void mo21857wW() {
        }

        public final void onDestroy() {
        }

        public final void setCameraId(int i) {
        }

        public final int getCameraId() {
            return 0;
        }

        /* renamed from: ai */
        public final void mo30612ai(String str, boolean z) {
        }

        public final void setFlash(String str) {
        }

        public final void setNeedOutput(boolean z) {
        }

        /* renamed from: da */
        public final boolean mo30613da(int i, int i2) {
            return false;
        }

        public final void setQuality(String str) {
        }

        public final void setOperateCallBack(C10362c c10362c) {
        }

        public final void setOutPutCallBack(C26953b c26953b) {
        }

        public final void setScanFreq(int i) {
        }

        /* renamed from: w */
        public final void mo30630w(int i, int i2, int i3, int i4) {
        }

        public final void aDd() {
        }

        public final void aDm() {
        }

        public final void aDn() {
        }

        public final void aDf() {
        }

        /* renamed from: n */
        public final void mo30617n(C2241c c2241c) {
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

        public final void setPage(C33303e c33303e) {
        }
    }

    void aDd();

    void aDf();

    void aDg();

    void aDm();

    void aDn();

    /* renamed from: ai */
    void mo30612ai(String str, boolean z);

    /* renamed from: da */
    boolean mo30613da(int i, int i2);

    int getCameraId();

    View getView();

    void initView();

    /* renamed from: n */
    void mo30617n(C2241c c2241c);

    void release();

    void setAppId(String str);

    void setCameraId(int i);

    void setFlash(String str);

    void setFrameLimitSize(int i);

    void setMode(String str);

    void setNeedOutput(boolean z);

    void setOperateCallBack(C10362c c10362c);

    void setOutPutCallBack(C26953b c26953b);

    void setPage(C33303e c33303e);

    void setQuality(String str);

    void setScanFreq(int i);

    /* renamed from: w */
    void mo30630w(int i, int i2, int i3, int i4);
}
