package com.tencent.mm.plugin.voip.ui;

import android.content.Context;
import com.tencent.mm.plugin.voip.video.CaptureView;

public interface b {
    void GC(int i);

    void a(byte[] bArr, long j, int i, int i2, int i3, int i4, int i5, int i6);

    void abY(String str);

    void bIK();

    void br(int i, String str);

    void c(int i, int i2, int[] iArr);

    void cJD();

    Context cKS();

    void cKT();

    byte[] cKU();

    void fY(int i, int i2);

    void my(boolean z);

    void setCaptureView(CaptureView captureView);

    void setConnectSec(long j);

    void setHWDecMode(int i);

    void setMute(boolean z);

    void setScreenEnable(boolean z);

    void setVoipBeauty(int i);

    void uninit();
}
