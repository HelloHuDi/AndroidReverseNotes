package com.tencent.mm.plugin.appbrand.game.e;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.os.Bundle;
import com.tencent.magicbrush.handler.MBCanvasHandler;
import com.tencent.magicbrush.handler.MBCanvasHandler.AnonymousClass3;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObject;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObjectManager;
import com.tencent.mm.plugin.appbrand.game.b;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.file.f;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.io.IOException;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public final class c extends a<b> {
    public static final int CTRL_INDEX = 100;
    public static final String NAME = "canvasToTempFilePath";

    /* JADX WARNING: Unknown top exception splitter block from list: {B:114:0x0371=Splitter:B:114:0x0371, B:135:0x0442=Splitter:B:135:0x0442, B:130:0x03e6=Splitter:B:130:0x03e6} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static f.a a(com.tencent.mm.plugin.appbrand.game.page.f fVar, JSONObject jSONObject, boolean z) {
        Throwable e;
        AppMethodBeat.i(130194);
        f.a aVar;
        try {
            int i = jSONObject.getInt("canvasId");
            try {
                Bitmap bitmap;
                Bundle bundle = new Bundle();
                bundle.putInt("canvasId", i);
                bundle.putBoolean("sync", z);
                ab.i("AppBrandGame.WAGamePageView", "got message doGetCanvasBitmap");
                int i2 = bundle.getInt("canvasId", -1);
                boolean z2 = bundle.getBoolean("sync", true);
                if (i2 == -1) {
                    ab.e("AppBrandGame.WAGamePageView", "got message doGetCanvasBitmap canvasId is illegal");
                    bitmap = null;
                } else {
                    ab.i("AppBrandGame.WAGamePageView", "got message doGetCanvasBitmap canvasId:%d,sync:%b", Integer.valueOf(i2), Boolean.valueOf(z2));
                    if (fVar.hsM == null) {
                        ab.e("AppBrandGame.WAGamePageView", "captureCanvas with [%d], view == null", Integer.valueOf(i2));
                        bitmap = null;
                    } else if (com.tencent.mm.plugin.appbrand.game.page.f.$assertionsDisabled || fVar.hsM.getMBRuntime() != null) {
                        MBCanvasHandler canvasHandler = fVar.hsM.getMBRuntime().getCanvasHandler();
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
                                bitmap = canvasHandler.a(null, z2);
                            } else if (!z2) {
                                bitmap = (Bitmap) canvasHandler.bSv.getJsThreadHandler().a(new AnonymousClass3(i2));
                            } else if (canvasHandler.bSv.isDestroyedUnlock()) {
                                bitmap = null;
                            } else {
                                bitmap = canvasHandler.nativeCaptureCanvas(canvasHandler.mNativeInst, i2);
                            }
                        }
                    } else {
                        AssertionError assertionError = new AssertionError();
                        AppMethodBeat.o(130194);
                        throw assertionError;
                    }
                    ab.i("AppBrandGame.WAGamePageView", "got message doGetCanvasBitmap end");
                }
                if (bitmap == null) {
                    ab.w("MicroMsg.WAGameJsApiCanvasToTempFilePath", "get screenBitmap return null.");
                    aVar = new f.a("fail:get bitmap failed", new Object[0]);
                    AppMethodBeat.o(130194);
                    return aVar;
                }
                float f;
                float width = (float) bitmap.getWidth();
                float height = (float) bitmap.getHeight();
                float width2 = (float) bitmap.getWidth();
                float height2 = (float) bitmap.getHeight();
                ab.i("MicroMsg.WAGameJsApiCanvasToTempFilePath", "screenWidth:%f,screenHeight:%f,canvasWidth:%f,canvasHeight:%f", Float.valueOf(width), Float.valueOf(height), Float.valueOf(width2), Float.valueOf(height2));
                float optDouble = (float) jSONObject.optDouble(VideoMaterialUtil.CRAZYFACE_X, 0.0d);
                float optDouble2 = (float) jSONObject.optDouble(VideoMaterialUtil.CRAZYFACE_Y, 0.0d);
                float optDouble3 = (float) jSONObject.optDouble("width", (double) width2);
                float optDouble4 = (float) jSONObject.optDouble("height", (double) height2);
                ab.i("MicroMsg.WAGameJsApiCanvasToTempFilePath", "x:%f,y:%f,width:%f,height:%f", Float.valueOf(optDouble), Float.valueOf(optDouble2), Float.valueOf(optDouble3), Float.valueOf(optDouble4));
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
                ab.i("MicroMsg.WAGameJsApiCanvasToTempFilePath", "x:%f,y:%f,screenWidth:%f,screenHeight:%f,width:%f,height:%f,imgWidth:%f,imgHeight:%f", Float.valueOf(optDouble), Float.valueOf(width2), Float.valueOf(width), Float.valueOf(height), Float.valueOf(f), Float.valueOf(height2), Float.valueOf(optDouble5), Float.valueOf(optDouble6));
                if (((int) optDouble) < 0 || ((int) width2) < 0 || ((int) f) <= 0 || ((int) height2) <= 0 || ((int) (optDouble + f)) > ((int) width) || ((int) (width2 + height2)) > ((int) height) || ((int) optDouble5) <= 0 || ((int) optDouble6) <= 0) {
                    ab.e("MicroMsg.WAGameJsApiCanvasToTempFilePath", "illegal arguments(x : %s, y : %s, width : %s, height : %s) failed, canvasId(%s).", Float.valueOf(optDouble), Float.valueOf(width2), Float.valueOf(f), Float.valueOf(height2), Integer.valueOf(i));
                    aVar = new f.a("fail:illegal arguments", new Object[0]);
                    AppMethodBeat.o(130194);
                    return aVar;
                }
                Bitmap bitmap2;
                if (f == width && height2 == height) {
                    bitmap2 = bitmap;
                } else {
                    bitmap2 = Bitmap.createBitmap(bitmap, (int) optDouble, (int) width2, (int) f, (int) height2, null, false);
                    bitmap.recycle();
                }
                if (bitmap2 == null) {
                    ab.e("MicroMsg.WAGameJsApiCanvasToTempFilePath", "screenBitmap.content null!");
                    aVar = new f.a("fail:gen bitmap failed!", new Object[0]);
                    AppMethodBeat.o(130194);
                    return aVar;
                } else if (bitmap2.getWidth() <= 0 || bitmap2.getHeight() <= 0) {
                    ab.e("MicroMsg.WAGameJsApiCanvasToTempFilePath", "screenBitmap.content width or height <=0!");
                    aVar = new f.a("fail:gen bitmap failed!", new Object[0]);
                    AppMethodBeat.o(130194);
                    return aVar;
                } else {
                    if (!(f == optDouble5 && height2 == optDouble6)) {
                        Bitmap createScaledBitmap;
                        try {
                            createScaledBitmap = Bitmap.createScaledBitmap(bitmap2, (int) optDouble5, (int) optDouble6, false);
                            bitmap2.recycle();
                            if (createScaledBitmap == null) {
                                try {
                                    h.pYm.k(807, 9, 1);
                                    aVar = new f.a("fail:gen bitmap failed because of null pointer!", new Object[0]);
                                    AppMethodBeat.o(130194);
                                    return aVar;
                                } catch (NullPointerException e2) {
                                    e = e2;
                                    bitmap2 = createScaledBitmap;
                                    ab.w("MicroMsg.WAGameJsApiCanvasToTempFilePath", "hy: dump exception npe: %d, %d, %f, %f", Integer.valueOf(bitmap2.getWidth()), Integer.valueOf(bitmap2.getHeight()), Float.valueOf(optDouble5), Float.valueOf(optDouble6));
                                    ab.printErrStackTrace("MicroMsg.WAGameJsApiCanvasToTempFilePath", e, "hy: weired exception occured!!", new Object[0]);
                                    h.pYm.k(807, 9, 1);
                                    aVar = new f.a("fail:gen bitmap failed because of null pointer!", new Object[0]);
                                    AppMethodBeat.o(130194);
                                    return aVar;
                                } catch (IllegalArgumentException e3) {
                                    e = e3;
                                    ab.w("MicroMsg.WAGameJsApiCanvasToTempFilePath", "hy: dump exception ilae: %d, %d, %f, %f", Integer.valueOf(createScaledBitmap.getWidth()), Integer.valueOf(createScaledBitmap.getHeight()), Float.valueOf(optDouble5), Float.valueOf(optDouble6));
                                    ab.printErrStackTrace("MicroMsg.WAGameJsApiCanvasToTempFilePath", e, "hy: illegalArgument exception occured!!", new Object[0]);
                                    h.pYm.k(807, 10, 1);
                                    aVar = new f.a("fail:gen bitmap failed because of illegal argument!", new Object[0]);
                                    AppMethodBeat.o(130194);
                                    return aVar;
                                }
                            }
                            bitmap2 = createScaledBitmap;
                        } catch (NullPointerException e4) {
                            e = e4;
                            ab.w("MicroMsg.WAGameJsApiCanvasToTempFilePath", "hy: dump exception npe: %d, %d, %f, %f", Integer.valueOf(bitmap2.getWidth()), Integer.valueOf(bitmap2.getHeight()), Float.valueOf(optDouble5), Float.valueOf(optDouble6));
                            ab.printErrStackTrace("MicroMsg.WAGameJsApiCanvasToTempFilePath", e, "hy: weired exception occured!!", new Object[0]);
                            h.pYm.k(807, 9, 1);
                            aVar = new f.a("fail:gen bitmap failed because of null pointer!", new Object[0]);
                            AppMethodBeat.o(130194);
                            return aVar;
                        } catch (IllegalArgumentException e5) {
                            e = e5;
                            createScaledBitmap = bitmap2;
                            ab.w("MicroMsg.WAGameJsApiCanvasToTempFilePath", "hy: dump exception ilae: %d, %d, %f, %f", Integer.valueOf(createScaledBitmap.getWidth()), Integer.valueOf(createScaledBitmap.getHeight()), Float.valueOf(optDouble5), Float.valueOf(optDouble6));
                            ab.printErrStackTrace("MicroMsg.WAGameJsApiCanvasToTempFilePath", e, "hy: illegalArgument exception occured!!", new Object[0]);
                            h.pYm.k(807, 10, 1);
                            aVar = new f.a("fail:gen bitmap failed because of illegal argument!", new Object[0]);
                            AppMethodBeat.o(130194);
                            return aVar;
                        }
                    }
                    CompressFormat x = com.tencent.mm.plugin.appbrand.jsapi.b.c.x(jSONObject);
                    if (x == CompressFormat.PNG) {
                        bitmap = Bitmap.createBitmap(bitmap2.getWidth(), bitmap2.getHeight(), Config.RGB_565);
                        new Canvas(bitmap).drawBitmap(bitmap2, 0.0f, 0.0f, null);
                    } else {
                        bitmap = bitmap2;
                    }
                    String genMediaFilePath = AppBrandLocalMediaObjectManager.genMediaFilePath(fVar.getAppId(), "canvas_".concat(String.valueOf(i)));
                    try {
                        d.a(bitmap, com.tencent.mm.plugin.appbrand.jsapi.b.c.w(jSONObject), x, genMediaFilePath, true);
                        AppBrandLocalMediaObject c = AppBrandLocalMediaObjectManager.c(fVar.getAppId(), genMediaFilePath, x == CompressFormat.JPEG ? "jpg" : "png", true);
                        if (c == null) {
                            ab.w("MicroMsg.WAGameJsApiCanvasToTempFilePath", "gen temp file failed, canvasId : %s.", Integer.valueOf(i));
                            aVar = new f.a("fail:gen temp file failed", new Object[0]);
                            AppMethodBeat.o(130194);
                            return aVar;
                        }
                        HashMap hashMap = new HashMap();
                        hashMap.put("tempFilePath", c.czD);
                        ab.v("MicroMsg.WAGameJsApiCanvasToTempFilePath", "save file(id : %s) to path : %s", c.czD, c.fnQ);
                        aVar = new f.a("ok", new Object[0]).y(hashMap);
                        AppMethodBeat.o(130194);
                        return aVar;
                    } catch (IOException e6) {
                        ab.w("MicroMsg.WAGameJsApiCanvasToTempFilePath", "save bitmap to file failed, viewId(%s). exception : %s", Integer.valueOf(i), e6);
                        aVar = new f.a("fail:write file failed", new Object[0]);
                        AppMethodBeat.o(130194);
                        return aVar;
                    }
                }
            } catch (OutOfMemoryError e7) {
                ab.printErrStackTrace("MicroMsg.WAGameJsApiCanvasToTempFilePath", e7, "hy: out of memory!!", new Object[0]);
                h.pYm.k(807, 12, 1);
                aVar = new f.a("fail:out of memory!", new Object[0]);
                AppMethodBeat.o(130194);
                return aVar;
            }
        } catch (JSONException e8) {
            ab.w("MicroMsg.WAGameJsApiCanvasToTempFilePath", "canvasId do not exist. exception : %s", e8);
            aVar = new f.a("fail:canvasId do not exist", new Object[0]);
            AppMethodBeat.o(130194);
            return aVar;
        }
    }
}
