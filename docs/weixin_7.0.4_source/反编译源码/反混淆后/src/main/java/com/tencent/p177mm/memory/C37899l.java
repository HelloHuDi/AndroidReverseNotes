package com.tencent.p177mm.memory;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.graphics.Rect;
import com.tencent.p177mm.compatible.util.C1443d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5061l;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;

/* renamed from: com.tencent.mm.memory.l */
public abstract class C37899l {
    private static C41213j fdH = new C41213j();
    private static C41214m fdI = new C41214m();
    private static int fdJ = -1;

    /* renamed from: a */
    public abstract Bitmap mo60650a(String str, Options options);

    /* renamed from: a */
    public abstract Bitmap mo60651a(String str, Rect rect, Options options);

    /* renamed from: v */
    public abstract void mo60652v(Bitmap bitmap);

    /* renamed from: Xg */
    public static boolean m63998Xg() {
        boolean iW = C1443d.m3068iW(19);
        boolean dpH = C5046bo.dpH();
        C4990ab.m7417i("MicroMsg.PlatformBitmapFactory", "canUseInBitmapFactory, isVersionMatch: %b, isART: %b, result: %s", Boolean.valueOf(iW), Boolean.valueOf(dpH), Boolean.valueOf(iW));
        return iW;
    }

    /* renamed from: t */
    protected static InputStream m63999t(InputStream inputStream) {
        if (inputStream.markSupported()) {
            return inputStream;
        }
        if (inputStream instanceof FileInputStream) {
            return new C5061l((FileInputStream) inputStream);
        }
        return new BufferedInputStream(inputStream);
    }

    /* renamed from: u */
    protected static void m64000u(InputStream inputStream) {
        try {
            inputStream.reset();
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.PlatformBitmapFactory", e, "reset stream error: %s", e.getMessage());
        }
    }

    /* renamed from: Xf */
    public static C37899l m63997Xf() {
        if (fdJ == -1) {
            if (C37899l.m63998Xg()) {
                fdJ = 1;
            } else {
                fdJ = 2;
            }
        }
        switch (fdJ) {
            case 1:
                return fdH;
            case 2:
                return fdI;
            default:
                return fdI;
        }
    }
}
