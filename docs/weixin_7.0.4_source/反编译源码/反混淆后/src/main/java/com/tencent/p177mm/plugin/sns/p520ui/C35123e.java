package com.tencent.p177mm.plugin.sns.p520ui;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.ByteArrayOutputStream;

/* renamed from: com.tencent.mm.plugin.sns.ui.e */
public final class C35123e {
    /* renamed from: bj */
    public static byte[] m57727bj(byte[] bArr) {
        AppMethodBeat.m2504i(38080);
        Bitmap decodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
        Bitmap copy = decodeByteArray.copy(Config.ARGB_8888, true);
        Canvas canvas = new Canvas(copy);
        canvas.drawColor(-1);
        canvas.drawBitmap(decodeByteArray, 0.0f, 0.0f, null);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        copy.compress(CompressFormat.JPEG, 100, byteArrayOutputStream);
        byte[] toByteArray = byteArrayOutputStream.toByteArray();
        AppMethodBeat.m2505o(38080);
        return toByteArray;
    }
}
