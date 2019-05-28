package com.tencent.p177mm.plugin.mmsight.model;

import android.graphics.Point;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.Size;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.mmsight.C3475d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

/* renamed from: com.tencent.mm.plugin.mmsight.model.g */
public final class C39388g {

    /* renamed from: com.tencent.mm.plugin.mmsight.model.g$a */
    static class C3482a implements Comparator<Size> {
        private C3482a() {
        }

        /* synthetic */ C3482a(byte b) {
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

    /* renamed from: com.tencent.mm.plugin.mmsight.model.g$b */
    public static class C39389b {
        public Point oum;
        public Point oun;
        public Point ouo;
        public Point oup;
        public Point ouq;
        public Point our;

        public final String toString() {
            AppMethodBeat.m2504i(76513);
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
            AppMethodBeat.m2505o(76513);
            return stringBuffer2;
        }
    }

    /* renamed from: a */
    public static C39389b m67218a(Parameters parameters, Point point, int i, boolean z) {
        int i2;
        AppMethodBeat.m2504i(76514);
        ArrayList arrayList = new ArrayList(parameters.getSupportedPreviewSizes());
        Collections.sort(arrayList, new C3482a());
        ArrayList arrayList2 = new ArrayList(parameters.getSupportedPictureSizes());
        C4990ab.m7417i("MicroMsg.MMSightCameraInfo", "supportedPreviewSizes: %s", C3475d.m5778cq(arrayList));
        float f = ((float) point.x) / ((float) point.y);
        C4990ab.m7417i("MicroMsg.MMSightCameraInfo", "screen.x: %d, screen.y: %d, ratio: %f, upperBoundPrewView: %s lowerBoundPreView: %s", Integer.valueOf(point.x), Integer.valueOf(point.y), Float.valueOf(f), Integer.valueOf(i), Integer.valueOf(0));
        long gO = C5046bo.m7553gO(C4996ah.getContext());
        C4990ab.m7411d("MicroMsg.MMSightCameraInfo", "systemAvailableMemInMB: %d", Long.valueOf(gO));
        C39389b c39389b = new C39389b();
        c39389b.oum = C39388g.m67217a(arrayList, point, z, i);
        if (c39389b.oum != null) {
            c39389b.oun = C3475d.m5767a(point, c39389b.oum, z);
            c39389b.ouo = C3475d.m5768a(point, c39389b.oum, z, true);
            i2 = 0;
        } else {
            Point point2 = new Point();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                Size size = (Size) it.next();
                point2.x = size.width;
                point2.y = size.height;
                if (point2.x == point2.y) {
                    C4990ab.m7417i("MicroMsg.MMSightCameraInfo", "exclude square curSize: %s", point2);
                } else {
                    C4990ab.m7417i("MicroMsg.MMSightCameraInfo", "cursize is %s * %s , and isRotate %s, screenRes.x %s, screenRes.y %s", Integer.valueOf(point2.x), Integer.valueOf(point2.y), Boolean.valueOf(z), Integer.valueOf(point.x), Integer.valueOf(point.y));
                    if (point.y > point.x) {
                        if (point2.y >= point2.x) {
                            C4990ab.m7417i("MicroMsg.MMSightCameraInfo", "screen ratio is differ from preview ratio  1 and unSupport preview is %s * %s", Integer.valueOf(size.height), Integer.valueOf(size.width));
                        }
                    } else if (point2.x >= point2.y) {
                        C4990ab.m7417i("MicroMsg.MMSightCameraInfo", "screen ratio is differ from preview ratio 2 and unSupport preview is %s * %s", Integer.valueOf(size.height), Integer.valueOf(size.width));
                    }
                    Point a = C3475d.m5767a(point, point2, z);
                    if (a == null) {
                        C4990ab.m7417i("MicroMsg.MMSightCameraInfo", "curSize: %s, can not find crop size", point2);
                    } else {
                        C4990ab.m7417i("MicroMsg.MMSightCameraInfo", "preViewPoint: %s --> bestSize %s ", point2, a);
                        c39389b.ouq = new Point(a.x, a.y);
                        c39389b.oup = new Point(point2.x, point2.y);
                        c39389b.our = C3475d.m5768a(point, point2, z, true);
                        if (Math.min(a.x, a.y) <= i) {
                            if (Math.min(a.x, a.y) < 0) {
                                AppMethodBeat.m2505o(76514);
                                return null;
                            }
                            c39389b.oum = new Point(point2.x, point2.y);
                            c39389b.oun = a;
                            c39389b.ouo = C3475d.m5768a(point, c39389b.oum, z, true);
                            i2 = 1;
                            C4990ab.m7417i("MicroMsg.MMSightCameraInfo", "find bestPreviewSize  %s -> %s findcount %d", r1, a, Integer.valueOf(1));
                        }
                    }
                }
            }
            i2 = 0;
        }
        C4990ab.m7417i("MicroMsg.MMSightCameraInfo", "final tryFindBestSize prewViewSize %s cropSize %s findcount %d", c39389b.oum, c39389b.oun, Integer.valueOf(i2));
        AppMethodBeat.m2505o(76514);
        return c39389b;
    }

    /* renamed from: c */
    public static C39389b m67220c(Parameters parameters, Point point, int i, boolean z) {
        AppMethodBeat.m2504i(76516);
        ArrayList arrayList = new ArrayList(parameters.getSupportedPreviewSizes());
        Collections.sort(arrayList, new C3482a());
        ArrayList arrayList2 = new ArrayList(parameters.getSupportedPictureSizes());
        C4990ab.m7417i("MicroMsg.MMSightCameraInfo", "tryFindPreviewSizeAnyWay supportedPreviewSizes: %s", C3475d.m5778cq(arrayList));
        float f = ((float) point.x) / ((float) point.y);
        C4990ab.m7417i("MicroMsg.MMSightCameraInfo", "screen.x: %d, screen.y: %d, ratio: %f, upperBoundPrewView: %s", Integer.valueOf(point.x), Integer.valueOf(point.y), Float.valueOf(f), Integer.valueOf(i));
        long gO = C5046bo.m7553gO(C4996ah.getContext());
        C4990ab.m7411d("MicroMsg.MMSightCameraInfo", "systemAvailableMemInMB: %d", Long.valueOf(gO));
        C39389b c39389b = new C39389b();
        c39389b.oum = C39388g.m67217a(arrayList, point, z, i);
        if (c39389b.oum == null) {
            Point point2 = new Point();
            Math.min(point.x, point.y);
            Math.max(point.x, point.y);
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                Size size = (Size) it.next();
                point2.x = size.width;
                point2.y = size.height;
                if (point2.x != point2.y && Math.min(point2.x, point2.y) <= i && Math.max(point2.x, point2.y) <= 2000 && C3475d.m5773b(point, point2, z) != null) {
                    c39389b.oum = null;
                    break;
                }
            }
        } else {
            c39389b.oun = C3475d.m5773b(point, c39389b.oum, z);
            c39389b.ouo = C3475d.m5774b(point, c39389b.oum, z, true);
        }
        C4990ab.m7417i("MicroMsg.MMSightCameraInfo", "final tryFindBestSize prewViewSize %s cropSize %s findcount %d with any way", c39389b.oum, c39389b.oun, Integer.valueOf(0));
        AppMethodBeat.m2505o(76516);
        return c39389b;
    }

    /* renamed from: a */
    private static Point m67217a(ArrayList<Size> arrayList, Point point, boolean z, int i) {
        AppMethodBeat.m2504i(76517);
        int i2 = point.x;
        int i3 = point.y;
        if ((i3 * i) % i2 != 0) {
            AppMethodBeat.m2505o(76517);
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
                C4990ab.m7417i("MicroMsg.MMSightCameraInfo", "findEqualsPrewViewSize FindBestSize %d %d", Integer.valueOf(i3), Integer.valueOf(i4));
                Point point2 = new Point(i3, i4);
                AppMethodBeat.m2505o(76517);
                return point2;
            } else if (Math.min(size.width, size.height) < i) {
                AppMethodBeat.m2505o(76517);
                return null;
            }
        }
        AppMethodBeat.m2505o(76517);
        return null;
    }

    /* renamed from: d */
    public static C39389b m67221d(Parameters parameters, Point point, int i, boolean z) {
        Point point2;
        Point point3;
        AppMethodBeat.m2504i(76518);
        ArrayList arrayList = new ArrayList(parameters.getSupportedPreviewSizes());
        Collections.sort(arrayList, new C3482a());
        C4990ab.m7417i("MicroMsg.MMSightCameraInfo", "findPreviewSizeWithoutCrop supportedPreviewSizes: %s", C3475d.m5778cq(arrayList));
        float f = ((float) point.x) / ((float) point.y);
        C4990ab.m7417i("MicroMsg.MMSightCameraInfo", "screen.x: %d, screen.y: %d, ratio: %f, upperBoundPrewView: %s ", Integer.valueOf(point.x), Integer.valueOf(point.y), Float.valueOf(f), Integer.valueOf(i));
        long gO = C5046bo.m7553gO(C4996ah.getContext());
        C4990ab.m7411d("MicroMsg.MMSightCameraInfo", "systemAvailableMemInMB: %d", Long.valueOf(gO));
        C39389b c39389b = new C39389b();
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
        C4990ab.m7417i("MicroMsg.MMSightCameraInfo", "preViewPoint: %s ", point3);
        c39389b.ouq = new Point(point3.x, point3.y);
        c39389b.oup = new Point(point3.x, point3.y);
        c39389b.our = C3475d.m5768a(point, point3, z, true);
        c39389b.oum = new Point(point3.x, point3.y);
        c39389b.oun = point3;
        c39389b.ouo = C3475d.m5768a(point, c39389b.oum, z, true);
        C4990ab.m7417i("MicroMsg.MMSightCameraInfo", "find bestPreviewSize  %s -> %s ", point2, point3);
        AppMethodBeat.m2505o(76518);
        return c39389b;
    }

    /* renamed from: b */
    public static C39389b m67219b(Parameters parameters, Point point, int i, boolean z) {
        AppMethodBeat.m2504i(76515);
        ArrayList arrayList = new ArrayList(parameters.getSupportedPreviewSizes());
        Collections.sort(arrayList, new C3482a());
        C4990ab.m7417i("MicroMsg.MMSightCameraInfo", "supportedPreviewSizes: %s", C3475d.m5778cq(arrayList));
        float f = ((float) point.x) / ((float) point.y);
        C4990ab.m7417i("MicroMsg.MMSightCameraInfo", "screen.x: %d, screen.y: %d, ratio: %f, upperBoundPrewView: %s lowerBoundPreView: %s", Integer.valueOf(point.x), Integer.valueOf(point.y), Float.valueOf(f), Integer.valueOf(i), Integer.valueOf(0));
        long gO = C5046bo.m7553gO(C4996ah.getContext());
        C4990ab.m7411d("MicroMsg.MMSightCameraInfo", "systemAvailableMemInMB: %d", Long.valueOf(gO));
        C39389b c39389b = new C39389b();
        Point point2 = new Point();
        int i2 = ((int) (((float) i) * 1.05f)) + 64;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Size size = (Size) it.next();
            if (size.height <= i2) {
                point2.x = size.width;
                point2.y = size.height;
                C4990ab.m7417i("MicroMsg.MMSightCameraInfo", "cursize is %s * %s , and isRotate %s, screenRes.x %s, screenRes.y %s", Integer.valueOf(point2.x), Integer.valueOf(point2.y), Boolean.valueOf(z), Integer.valueOf(point.x), Integer.valueOf(point.y));
                if (point.y > point.x) {
                    if (point2.y >= point2.x) {
                        C4990ab.m7417i("MicroMsg.MMSightCameraInfo", "screen ratio is differ from preview ratio  1 and unSupport preview is %s * %s", Integer.valueOf(size.height), Integer.valueOf(size.width));
                    }
                } else if (point2.x >= point2.y) {
                    C4990ab.m7417i("MicroMsg.MMSightCameraInfo", "screen ratio is differ from preview ratio 2 and unSupport preview is %s * %s", Integer.valueOf(size.height), Integer.valueOf(size.width));
                }
                Point a = C3475d.m5768a(point, point2, z, false);
                if (a != null) {
                    C4990ab.m7417i("MicroMsg.MMSightCameraInfo", "preViewPoint: %s --> bestSize %s ", point2, a);
                    c39389b.ouq = new Point(a.x, a.y);
                    c39389b.oup = new Point(point2.x, point2.y);
                    c39389b.our = C3475d.m5768a(point, point2, z, true);
                    c39389b.oum = new Point(point2.x, point2.y);
                    c39389b.oun = a;
                    c39389b.ouo = C3475d.m5768a(point, c39389b.oum, z, true);
                    C4990ab.m7417i("MicroMsg.MMSightCameraInfo", "find bestPreviewSize  %s -> %s findcount %d", r3, a, Integer.valueOf(1));
                    AppMethodBeat.m2505o(76515);
                    return c39389b;
                }
            }
        }
        C4990ab.m7417i("MicroMsg.MMSightCameraInfo", "final tryFindBestSize prewViewSize %s cropSize %s findcount %d with crop width", c39389b.oum, c39389b.oun, Integer.valueOf(0));
        AppMethodBeat.m2505o(76515);
        return c39389b;
    }
}
