package com.tencent.p177mm.plugin.appbrand.game.p295e;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.os.Bundle;
import com.tencent.magicbrush.handler.MBCanvasHandler;
import com.tencent.magicbrush.handler.MBCanvasHandler.C10083;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.appstorage.AppBrandLocalMediaObject;
import com.tencent.p177mm.plugin.appbrand.appstorage.AppBrandLocalMediaObjectManager;
import com.tencent.p177mm.plugin.appbrand.game.C42439b;
import com.tencent.p177mm.plugin.appbrand.game.page.C33204f;
import com.tencent.p177mm.plugin.appbrand.jsapi.C10296a;
import com.tencent.p177mm.plugin.appbrand.jsapi.file.C19377f.C10396a;
import com.tencent.p177mm.plugin.appbrand.jsapi.p299b.C38265c;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5056d;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.io.IOException;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.game.e.c */
public final class C38224c extends C10296a<C42439b> {
    public static final int CTRL_INDEX = 100;
    public static final String NAME = "canvasToTempFilePath";

    /* JADX WARNING: Unknown top exception splitter block from list: {B:114:0x0371=Splitter:B:114:0x0371, B:135:0x0442=Splitter:B:135:0x0442, B:130:0x03e6=Splitter:B:130:0x03e6} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public static C10396a m64672a(C33204f c33204f, JSONObject jSONObject, boolean z) {
        Throwable e;
        AppMethodBeat.m2504i(130194);
        C10396a c10396a;
        try {
            int i = jSONObject.getInt("canvasId");
            try {
                Bitmap bitmap;
                Bundle bundle = new Bundle();
                bundle.putInt("canvasId", i);
                bundle.putBoolean("sync", z);
                C4990ab.m7416i("AppBrandGame.WAGamePageView", "got message doGetCanvasBitmap");
                int i2 = bundle.getInt("canvasId", -1);
                boolean z2 = bundle.getBoolean("sync", true);
                if (i2 == -1) {
                    C4990ab.m7412e("AppBrandGame.WAGamePageView", "got message doGetCanvasBitmap canvasId is illegal");
                    bitmap = null;
                } else {
                    C4990ab.m7417i("AppBrandGame.WAGamePageView", "got message doGetCanvasBitmap canvasId:%d,sync:%b", Integer.valueOf(i2), Boolean.valueOf(z2));
                    if (c33204f.hsM == null) {
                        C4990ab.m7413e("AppBrandGame.WAGamePageView", "captureCanvas with [%d], view == null", Integer.valueOf(i2));
                        bitmap = null;
                    } else if (C33204f.$assertionsDisabled || c33204f.hsM.getMBRuntime() != null) {
                        MBCanvasHandler canvasHandler = c33204f.hsM.getMBRuntime().getCanvasHandler();
                        if (i2 <= 0) {
                            bitmap = null;
                        } else {
                            Object obj;
                            if (canvasHandler.bSv.getScreenCanvasId() <= 0 || i2 <= 0 || canvasHandler.bSv.getScreenCanvasId() != i2) {
                                obj = null;
                            } else {
                                obj = 1;
                            }
                            if (obj != null) {
                                bitmap = canvasHandler.mo4006a(null, z2);
                            } else if (!z2) {
                                bitmap = (Bitmap) canvasHandler.bSv.getJsThreadHandler().mo41497a(new C10083(i2));
                            } else if (canvasHandler.bSv.isDestroyedUnlock()) {
                                bitmap = null;
                            } else {
                                bitmap = canvasHandler.nativeCaptureCanvas(canvasHandler.mNativeInst, i2);
                            }
                        }
                    } else {
                        AssertionError assertionError = new AssertionError();
                        AppMethodBeat.m2505o(130194);
                        throw assertionError;
                    }
                    C4990ab.m7416i("AppBrandGame.WAGamePageView", "got message doGetCanvasBitmap end");
                }
                if (bitmap == null) {
                    C4990ab.m7420w("MicroMsg.WAGameJsApiCanvasToTempFilePath", "get screenBitmap return null.");
                    c10396a = new C10396a("fail:get bitmap failed", new Object[0]);
                    AppMethodBeat.m2505o(130194);
                    return c10396a;
                }
                float f;
                float width = (float) bitmap.getWidth();
                float height = (float) bitmap.getHeight();
                float width2 = (float) bitmap.getWidth();
                float height2 = (float) bitmap.getHeight();
                C4990ab.m7417i("MicroMsg.WAGameJsApiCanvasToTempFilePath", "screenWidth:%f,screenHeight:%f,canvasWidth:%f,canvasHeight:%f", Float.valueOf(width), Float.valueOf(height), Float.valueOf(width2), Float.valueOf(height2));
                float optDouble = (float) jSONObject.optDouble(VideoMaterialUtil.CRAZYFACE_X, 0.0d);
                float optDouble2 = (float) jSONObject.optDouble(VideoMaterialUtil.CRAZYFACE_Y, 0.0d);
                float optDouble3 = (float) jSONObject.optDouble("width", (double) width2);
                float optDouble4 = (float) jSONObject.optDouble("height", (double) height2);
                C4990ab.m7417i("MicroMsg.WAGameJsApiCanvasToTempFilePath", "x:%f,y:%f,width:%f,height:%f", Float.valueOf(optDouble), Float.valueOf(optDouble2), Float.valueOf(optDouble3), Float.valueOf(optDouble4));
                if (width2 <= 0.0f || height2 <= 0.0f || (width == width2 && height == height2)) {
                    width2 = optDouble2;
                } else {
                    if (optDouble > 0.0f) {
                        optDouble = (optDouble / width2) * width;
                    }
                    if (optDouble2 > 0.0f) {
                        optDouble2 = (optDouble2 / height2) * height;
                    }
                    optDouble3 = (optDouble3 / width2) * width;
                    optDouble4 = (optDouble4 / height2) * height;
                    width2 = optDouble2;
                }
                if (optDouble + optDouble3 > width) {
                    f = width - optDouble;
                } else {
                    f = optDouble3;
                }
                if (width2 + optDouble4 > height) {
                    height2 = height - width2;
                } else {
                    height2 = optDouble4;
                }
                float optDouble5 = (float) jSONObject.optDouble("destWidth", (double) f);
                float optDouble6 = (float) jSONObject.optDouble("destHeight", (double) height2);
                C4990ab.m7417i("MicroMsg.WAGameJsApiCanvasToTempFilePath", "x:%f,y:%f,screenWidth:%f,screenHeight:%f,width:%f,height:%f,imgWidth:%f,imgHeight:%f", Float.valueOf(optDouble), Float.valueOf(width2), Float.valueOf(width), Float.valueOf(height), Float.valueOf(f), Float.valueOf(height2), Float.valueOf(optDouble5), Float.valueOf(optDouble6));
                if (((int) optDouble) < 0 || ((int) width2) < 0 || ((int) f) <= 0 || ((int) height2) <= 0 || ((int) (optDouble + f)) > ((int) width) || ((int) (width2 + height2)) > ((int) height) || ((int) optDouble5) <= 0 || ((int) optDouble6) <= 0) {
                    C4990ab.m7413e("MicroMsg.WAGameJsApiCanvasToTempFilePath", "illegal arguments(x : %s, y : %s, width : %s, height : %s) failed, canvasId(%s).", Float.valueOf(optDouble), Float.valueOf(width2), Float.valueOf(f), Float.valueOf(height2), Integer.valueOf(i));
                    c10396a = new C10396a("fail:illegal arguments", new Object[0]);
                    AppMethodBeat.m2505o(130194);
                    return c10396a;
                }
                Bitmap bitmap2;
                if (f == width && height2 == height) {
                    bitmap2 = bitmap;
                } else {
                    bitmap2 = Bitmap.createBitmap(bitmap, (int) optDouble, (int) width2, (int) f, (int) height2, null, false);
                    bitmap.recycle();
                }
                if (bitmap2 == null) {
                    C4990ab.m7412e("MicroMsg.WAGameJsApiCanvasToTempFilePath", "screenBitmap.content null!");
                    c10396a = new C10396a("fail:gen bitmap failed!", new Object[0]);
                    AppMethodBeat.m2505o(130194);
                    return c10396a;
                } else if (bitmap2.getWidth() <= 0 || bitmap2.getHeight() <= 0) {
                    C4990ab.m7412e("MicroMsg.WAGameJsApiCanvasToTempFilePath", "screenBitmap.content width or height <=0!");
                    c10396a = new C10396a("fail:gen bitmap failed!", new Object[0]);
                    AppMethodBeat.m2505o(130194);
                    return c10396a;
                } else {
                    if (!(f == optDouble5 && height2 == optDouble6)) {
                        Bitmap createScaledBitmap;
                        try {
                            createScaledBitmap = Bitmap.createScaledBitmap(bitmap2, (int) optDouble5, (int) optDouble6, false);
                            bitmap2.recycle();
                            if (createScaledBitmap == null) {
                                try {
                                    C7060h.pYm.mo15419k(807, 9, 1);
                                    c10396a = new C10396a("fail:gen bitmap failed because of null pointer!", new Object[0]);
                                    AppMethodBeat.m2505o(130194);
                                    return c10396a;
                                } catch (NullPointerException e2) {
                                    e = e2;
                                    bitmap2 = createScaledBitmap;
                                    C4990ab.m7421w("MicroMsg.WAGameJsApiCanvasToTempFilePath", "hy: dump exception npe: %d, %d, %f, %f", Integer.valueOf(bitmap2.getWidth()), Integer.valueOf(bitmap2.getHeight()), Float.valueOf(optDouble5), Float.valueOf(optDouble6));
                                    C4990ab.printErrStackTrace("MicroMsg.WAGameJsApiCanvasToTempFilePath", e, "hy: weired exception occured!!", new Object[0]);
                                    C7060h.pYm.mo15419k(807, 9, 1);
                                    c10396a = new C10396a("fail:gen bitmap failed because of null pointer!", new Object[0]);
                                    AppMethodBeat.m2505o(130194);
                                    return c10396a;
                                } catch (IllegalArgumentException e3) {
                                    e = e3;
                                    C4990ab.m7421w("MicroMsg.WAGameJsApiCanvasToTempFilePath", "hy: dump exception ilae: %d, %d, %f, %f", Integer.valueOf(createScaledBitmap.getWidth()), Integer.valueOf(createScaledBitmap.getHeight()), Float.valueOf(optDouble5), Float.valueOf(optDouble6));
                                    C4990ab.printErrStackTrace("MicroMsg.WAGameJsApiCanvasToTempFilePath", e, "hy: illegalArgument exception occured!!", new Object[0]);
                                    C7060h.pYm.mo15419k(807, 10, 1);
                                    c10396a = new C10396a("fail:gen bitmap failed because of illegal argument!", new Object[0]);
                                    AppMethodBeat.m2505o(130194);
                                    return c10396a;
                                }
                            }
                            bitmap2 = createScaledBitmap;
                        } catch (NullPointerException e4) {
                            e = e4;
                            C4990ab.m7421w("MicroMsg.WAGameJsApiCanvasToTempFilePath", "hy: dump exception npe: %d, %d, %f, %f", Integer.valueOf(bitmap2.getWidth()), Integer.valueOf(bitmap2.getHeight()), Float.valueOf(optDouble5), Float.valueOf(optDouble6));
                            C4990ab.printErrStackTrace("MicroMsg.WAGameJsApiCanvasToTempFilePath", e, "hy: weired exception occured!!", new Object[0]);
                            C7060h.pYm.mo15419k(807, 9, 1);
                            c10396a = new C10396a("fail:gen bitmap failed because of null pointer!", new Object[0]);
                            AppMethodBeat.m2505o(130194);
                            return c10396a;
                        } catch (IllegalArgumentException e5) {
                            e = e5;
                            createScaledBitmap = bitmap2;
                            C4990ab.m7421w("MicroMsg.WAGameJsApiCanvasToTempFilePath", "hy: dump exception ilae: %d, %d, %f, %f", Integer.valueOf(createScaledBitmap.getWidth()), Integer.valueOf(createScaledBitmap.getHeight()), Float.valueOf(optDouble5), Float.valueOf(optDouble6));
                            C4990ab.printErrStackTrace("MicroMsg.WAGameJsApiCanvasToTempFilePath", e, "hy: illegalArgument exception occured!!", new Object[0]);
                            C7060h.pYm.mo15419k(807, 10, 1);
                            c10396a = new C10396a("fail:gen bitmap failed because of illegal argument!", new Object[0]);
                            AppMethodBeat.m2505o(130194);
                            return c10396a;
                        }
                    }
                    CompressFormat x = C38265c.m64758x(jSONObject);
                    if (x == CompressFormat.PNG) {
                        bitmap = Bitmap.createBitmap(bitmap2.getWidth(), bitmap2.getHeight(), Config.RGB_565);
                        new Canvas(bitmap).drawBitmap(bitmap2, 0.0f, 0.0f, null);
                    } else {
                        bitmap = bitmap2;
                    }
                    String genMediaFilePath = AppBrandLocalMediaObjectManager.genMediaFilePath(c33204f.getAppId(), "canvas_".concat(String.valueOf(i)));
                    try {
                        C5056d.m7625a(bitmap, C38265c.m64757w(jSONObject), x, genMediaFilePath, true);
                        AppBrandLocalMediaObject c = AppBrandLocalMediaObjectManager.m29650c(c33204f.getAppId(), genMediaFilePath, x == CompressFormat.JPEG ? "jpg" : "png", true);
                        if (c == null) {
                            C4990ab.m7421w("MicroMsg.WAGameJsApiCanvasToTempFilePath", "gen temp file failed, canvasId : %s.", Integer.valueOf(i));
                            c10396a = new C10396a("fail:gen temp file failed", new Object[0]);
                            AppMethodBeat.m2505o(130194);
                            return c10396a;
                        }
                        HashMap hashMap = new HashMap();
                        hashMap.put("tempFilePath", c.czD);
                        C4990ab.m7419v("MicroMsg.WAGameJsApiCanvasToTempFilePath", "save file(id : %s) to path : %s", c.czD, c.fnQ);
                        c10396a = new C10396a("ok", new Object[0]).mo21869y(hashMap);
                        AppMethodBeat.m2505o(130194);
                        return c10396a;
                    } catch (IOException e6) {
                        C4990ab.m7421w("MicroMsg.WAGameJsApiCanvasToTempFilePath", "save bitmap to file failed, viewId(%s). exception : %s", Integer.valueOf(i), e6);
                        c10396a = new C10396a("fail:write file failed", new Object[0]);
                        AppMethodBeat.m2505o(130194);
                        return c10396a;
                    }
                }
            } catch (OutOfMemoryError e7) {
                C4990ab.printErrStackTrace("MicroMsg.WAGameJsApiCanvasToTempFilePath", e7, "hy: out of memory!!", new Object[0]);
                C7060h.pYm.mo15419k(807, 12, 1);
                c10396a = new C10396a("fail:out of memory!", new Object[0]);
                AppMethodBeat.m2505o(130194);
                return c10396a;
            }
        } catch (JSONException e8) {
            C4990ab.m7421w("MicroMsg.WAGameJsApiCanvasToTempFilePath", "canvasId do not exist. exception : %s", e8);
            c10396a = new C10396a("fail:canvasId do not exist", new Object[0]);
            AppMethodBeat.m2505o(130194);
            return c10396a;
        }
    }
}
