package com.tencent.p177mm.plugin.voip.p546ui;

import android.content.Context;
import com.tencent.p177mm.plugin.voip.video.CaptureView;

/* renamed from: com.tencent.mm.plugin.voip.ui.b */
public interface C14085b {
    /* renamed from: GC */
    void mo26389GC(int i);

    /* renamed from: a */
    void mo26390a(byte[] bArr, long j, int i, int i2, int i3, int i4, int i5, int i6);

    void abY(String str);

    void bIK();

    /* renamed from: br */
    void mo26393br(int i, String str);

    /* renamed from: c */
    void mo26394c(int i, int i2, int[] iArr);

    void cJD();

    Context cKS();

    void cKT();

    byte[] cKU();

    /* renamed from: fY */
    void mo26399fY(int i, int i2);

    /* renamed from: my */
    void mo26400my(boolean z);

    void setCaptureView(CaptureView captureView);

    void setConnectSec(long j);

    void setHWDecMode(int i);

    void setMute(boolean z);

    void setScreenEnable(boolean z);

    void setVoipBeauty(int i);

    void uninit();
}
