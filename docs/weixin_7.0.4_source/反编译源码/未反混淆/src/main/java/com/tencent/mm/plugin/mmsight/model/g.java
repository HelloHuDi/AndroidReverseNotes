package com.tencent.mm.plugin.mmsight.model;

import android.graphics.Point;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.Size;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

public final class g {

    static class a implements Comparator<Size> {
        private a() {
        }

        /* synthetic */ a(byte b) {
            this();
        }

        public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
            Size size = (Size) obj;
            Size size2 = (Size) obj2;
            int i = size.height * size.width;
            int i2 = size2.height * size2.width;
            if (i2 < i) {
                return -1;
            }
            if (i2 > i) {
                return 1;
            }
            return 0;
        }
    }

    public static class b {
        public Point oum;
        public Point oun;
        public Point ouo;
        public Point oup;
        public Point ouq;
        public Point our;

        public final String toString() {
            AppMethodBeat.i(76513);
            StringBuffer stringBuffer = new StringBuffer();
            if (this.oum != null) {
                stringBuffer.append(this.oum.toString() + ",");
            }
            if (this.oun != null) {
                stringBuffer.append(this.oun.toString() + ",");
            }
            if (this.ouo != null) {
                stringBuffer.append(this.ouo.toString() + ",");
            }
            if (this.oup != null) {
                stringBuffer.append(this.oup.toString() + ",");
            }
            if (this.ouq != null) {
                stringBuffer.append(this.ouq.toString() + ",");
            }
            if (this.our != null) {
                stringBuffer.append(this.our.toString() + ",");
            }
            String stringBuffer2 = stringBuffer.toString();
            AppMethodBeat.o(76513);
            return stringBuffer2;
        }
    }

    public static b a(Parameters parameters, Point point, int i, boolean z) {
        int i2;
        AppMethodBeat.i(76514);
        ArrayList arrayList = new ArrayList(parameters.getSupportedPreviewSizes());
        Collections.sort(arrayList, new a());
        ArrayList arrayList2 = new ArrayList(parameters.getSupportedPictureSizes());
        ab.i("MicroMsg.MMSightCameraInfo", "supportedPreviewSizes: %s", d.cq(arrayList));
        float f = ((float) point.x) / ((float) point.y);
        ab.i("MicroMsg.MMSightCameraInfo", "screen.x: %d, screen.y: %d, ratio: %f, upperBoundPrewView: %s lowerBoundPreView: %s", Integer.valueOf(point.x), Integer.valueOf(point.y), Float.valueOf(f), Integer.valueOf(i), Integer.valueOf(0));
        long gO = bo.gO(ah.getContext());
        ab.d("MicroMsg.MMSightCameraInfo", "systemAvailableMemInMB: %d", Long.valueOf(gO));
        b bVar = new b();
        bVar.oum = a(arrayList, point, z, i);
        if (bVar.oum != null) {
            bVar.oun = d.a(point, bVar.oum, z);
            bVar.ouo = d.a(point, bVar.oum, z, true);
            i2 = 0;
        } else {
            Point point2 = new Point();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                Size size = (Size) it.next();
                point2.x = size.width;
                point2.y = size.height;
                if (point2.x == point2.y) {
                    ab.i("MicroMsg.MMSightCameraInfo", "exclude square curSize: %s", point2);
                } else {
                    ab.i("MicroMsg.MMSightCameraInfo", "cursize is %s * %s , and isRotate %s, screenRes.x %s, screenRes.y %s", Integer.valueOf(point2.x), Integer.valueOf(point2.y), Boolean.valueOf(z), Integer.valueOf(point.x), Integer.valueOf(point.y));
                    if (point.y > point.x) {
                        if (point2.y >= point2.x) {
                            ab.i("MicroMsg.MMSightCameraInfo", "screen ratio is differ from preview ratio  1 and unSupport preview is %s * %s", Integer.valueOf(size.height), Integer.valueOf(size.width));
                        }
                    } else if (point2.x >= point2.y) {
                        ab.i("MicroMsg.MMSightCameraInfo", "screen ratio is differ from preview ratio 2 and unSupport preview is %s * %s", Integer.valueOf(size.height), Integer.valueOf(size.width));
                    }
                    Point a = d.a(point, point2, z);
                    if (a == null) {
                        ab.i("MicroMsg.MMSightCameraInfo", "curSize: %s, can not find crop size", point2);
                    } else {
                        ab.i("MicroMsg.MMSightCameraInfo", "preViewPoint: %s --> bestSize %s ", point2, a);
                        bVar.ouq = new Point(a.x, a.y);
                        bVar.oup = new Point(point2.x, point2.y);
                        bVar.our = d.a(point, point2, z, true);
                        if (Math.min(a.x, a.y) <= i) {
                            if (Math.min(a.x, a.y) < 0) {
                                AppMethodBeat.o(76514);
                                return null;
                            }
                            bVar.oum = new Point(point2.x, point2.y);
                            bVar.oun = a;
                            bVar.ouo = d.a(point, bVar.oum, z, true);
                            i2 = 1;
                            ab.i("MicroMsg.MMSightCameraInfo", "find bestPreviewSize  %s -> %s findcount %d", r1, a, Integer.valueOf(1));
                        }
                    }
                }
            }
            i2 = 0;
        }
        ab.i("MicroMsg.MMSightCameraInfo", "final tryFindBestSize prewViewSize %s cropSize %s findcount %d", bVar.oum, bVar.oun, Integer.valueOf(i2));
        AppMethodBeat.o(76514);
        return bVar;
    }

    public static b c(Parameters parameters, Point point, int i, boolean z) {
        AppMethodBeat.i(76516);
        ArrayList arrayList = new ArrayList(parameters.getSupportedPreviewSizes());
        Collections.sort(arrayList, new a());
        ArrayList arrayList2 = new ArrayList(parameters.getSupportedPictureSizes());
        ab.i("MicroMsg.MMSightCameraInfo", "tryFindPreviewSizeAnyWay supportedPreviewSizes: %s", d.cq(arrayList));
        float f = ((float) point.x) / ((float) point.y);
        ab.i("MicroMsg.MMSightCameraInfo", "screen.x: %d, screen.y: %d, ratio: %f, upperBoundPrewView: %s", Integer.valueOf(point.x), Integer.valueOf(point.y), Float.valueOf(f), Integer.valueOf(i));
        long gO = bo.gO(ah.getContext());
        ab.d("MicroMsg.MMSightCameraInfo", "systemAvailableMemInMB: %d", Long.valueOf(gO));
        b bVar = new b();
        bVar.oum = a(arrayList, point, z, i);
        if (bVar.oum == null) {
            Point point2 = new Point();
            Math.min(point.x, point.y);
            Math.max(point.x, point.y);
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                Size size = (Size) it.next();
                point2.x = size.width;
                point2.y = size.height;
                if (point2.x != point2.y && Math.min(point2.x, point2.y) <= i && Math.max(point2.x, point2.y) <= 2000 && d.b(point, point2, z) != null) {
                    bVar.oum = null;
                    break;
                }
            }
        } else {
            bVar.oun = d.b(point, bVar.oum, z);
            bVar.ouo = d.b(point, bVar.oum, z, true);
        }
        ab.i("MicroMsg.MMSightCameraInfo", "final tryFindBestSize prewViewSize %s cropSize %s findcount %d with any way", bVar.oum, bVar.oun, Integer.valueOf(0));
        AppMethodBeat.o(76516);
        return bVar;
    }

    private static Point a(ArrayList<Size> arrayList, Point point, boolean z, int i) {
        AppMethodBeat.i(76517);
        int i2 = point.x;
        int i3 = point.y;
        if ((i3 * i) % i2 != 0) {
            AppMethodBeat.o(76517);
            return null;
        }
        int i4;
        i2 = (i3 * i) / i2;
        if (z) {
            i3 = i ^ i2;
            i4 = i3 ^ i2;
            i3 ^= i4;
        } else {
            i3 = i;
            i4 = i2;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Size size = (Size) it.next();
            if (size.width == i3 && size.height == i4) {
                ab.i("MicroMsg.MMSightCameraInfo", "findEqualsPrewViewSize FindBestSize %d %d", Integer.valueOf(i3), Integer.valueOf(i4));
                Point point2 = new Point(i3, i4);
                AppMethodBeat.o(76517);
                return point2;
            } else if (Math.min(size.width, size.height) < i) {
                AppMethodBeat.o(76517);
                return null;
            }
        }
        AppMethodBeat.o(76517);
        return null;
    }

    public static b d(Parameters parameters, Point point, int i, boolean z) {
        Point point2;
        Point point3;
        AppMethodBeat.i(76518);
        ArrayList arrayList = new ArrayList(parameters.getSupportedPreviewSizes());
        Collections.sort(arrayList, new a());
        ab.i("MicroMsg.MMSightCameraInfo", "findPreviewSizeWithoutCrop supportedPreviewSizes: %s", d.cq(arrayList));
        float f = ((float) point.x) / ((float) point.y);
        ab.i("MicroMsg.MMSightCameraInfo", "screen.x: %d, screen.y: %d, ratio: %f, upperBoundPrewView: %s ", Integer.valueOf(point.x), Integer.valueOf(point.y), Float.valueOf(f), Integer.valueOf(i));
        long gO = bo.gO(ah.getContext());
        ab.d("MicroMsg.MMSightCameraInfo", "systemAvailableMemInMB: %d", Long.valueOf(gO));
        b bVar = new b();
        int i2 = ((int) (((float) i) * 1.05f)) + 64;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Size size = (Size) it.next();
            if (size.height <= i2 && size.width <= 2000) {
                point2 = new Point();
                point2.x = size.width;
                point2.y = size.height;
                point3 = point2;
                break;
            }
        }
        point3 = null;
        ab.i("MicroMsg.MMSightCameraInfo", "preViewPoint: %s ", point3);
        bVar.ouq = new Point(point3.x, point3.y);
        bVar.oup = new Point(point3.x, point3.y);
        bVar.our = d.a(point, point3, z, true);
        bVar.oum = new Point(point3.x, point3.y);
        bVar.oun = point3;
        bVar.ouo = d.a(point, bVar.oum, z, true);
        ab.i("MicroMsg.MMSightCameraInfo", "find bestPreviewSize  %s -> %s ", point2, point3);
        AppMethodBeat.o(76518);
        return bVar;
    }

    public static b b(Parameters parameters, Point point, int i, boolean z) {
        AppMethodBeat.i(76515);
        ArrayList arrayList = new ArrayList(parameters.getSupportedPreviewSizes());
        Collections.sort(arrayList, new a());
        ab.i("MicroMsg.MMSightCameraInfo", "supportedPreviewSizes: %s", d.cq(arrayList));
        float f = ((float) point.x) / ((float) point.y);
        ab.i("MicroMsg.MMSightCameraInfo", "screen.x: %d, screen.y: %d, ratio: %f, upperBoundPrewView: %s lowerBoundPreView: %s", Integer.valueOf(point.x), Integer.valueOf(point.y), Float.valueOf(f), Integer.valueOf(i), Integer.valueOf(0));
        long gO = bo.gO(ah.getContext());
        ab.d("MicroMsg.MMSightCameraInfo", "systemAvailableMemInMB: %d", Long.valueOf(gO));
        b bVar = new b();
        Point point2 = new Point();
        int i2 = ((int) (((float) i) * 1.05f)) + 64;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Size size = (Size) it.next();
            if (size.height <= i2) {
                point2.x = size.width;
                point2.y = size.height;
                ab.i("MicroMsg.MMSightCameraInfo", "cursize is %s * %s , and isRotate %s, screenRes.x %s, screenRes.y %s", Integer.valueOf(point2.x), Integer.valueOf(point2.y), Boolean.valueOf(z), Integer.valueOf(point.x), Integer.valueOf(point.y));
                if (point.y > point.x) {
                    if (point2.y >= point2.x) {
                        ab.i("MicroMsg.MMSightCameraInfo", "screen ratio is differ from preview ratio  1 and unSupport preview is %s * %s", Integer.valueOf(size.height), Integer.valueOf(size.width));
                    }
                } else if (point2.x >= point2.y) {
                    ab.i("MicroMsg.MMSightCameraInfo", "screen ratio is differ from preview ratio 2 and unSupport preview is %s * %s", Integer.valueOf(size.height), Integer.valueOf(size.width));
                }
                Point a = d.a(point, point2, z, false);
                if (a != null) {
                    ab.i("MicroMsg.MMSightCameraInfo", "preViewPoint: %s --> bestSize %s ", point2, a);
                    bVar.ouq = new Point(a.x, a.y);
                    bVar.oup = new Point(point2.x, point2.y);
                    bVar.our = d.a(point, point2, z, true);
                    bVar.oum = new Point(point2.x, point2.y);
                    bVar.oun = a;
                    bVar.ouo = d.a(point, bVar.oum, z, true);
                    ab.i("MicroMsg.MMSightCameraInfo", "find bestPreviewSize  %s -> %s findcount %d", r3, a, Integer.valueOf(1));
                    AppMethodBeat.o(76515);
                    return bVar;
                }
            }
        }
        ab.i("MicroMsg.MMSightCameraInfo", "final tryFindBestSize prewViewSize %s cropSize %s findcount %d with crop width", bVar.oum, bVar.oun, Integer.valueOf(0));
        AppMethodBeat.o(76515);
        return bVar;
    }
}
