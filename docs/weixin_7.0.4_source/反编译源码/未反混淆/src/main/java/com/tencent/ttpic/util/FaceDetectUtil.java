package com.tencent.ttpic.util;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.PointF;
import com.tencent.faceBeauty.FaceParam;
import com.tencent.faceBeauty.a;
import com.tencent.faceBeauty.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.util.youtu.TTpicBitmapFaceDetect;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FaceDetectUtil {
    public static final List<PointF> EMPTY_LIST = new ArrayList();
    public static final int ILLEGAL_BIG_FACE = 2;
    public static final int ILLEGAL_SMALL_FACE = 1;
    public static final int LEGAL_NORMAL_FACE = 0;

    /* JADX WARNING: Removed duplicated region for block: B:31:0x007d  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0082  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x007d  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0082  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static List<FaceParam> cosFunDetect(Bitmap bitmap, int i, HashMap<FaceParam, float[]> hashMap) {
        Throwable th;
        b bVar;
        b bVar2 = null;
        AppMethodBeat.i(83866);
        ArrayList arrayList = new ArrayList();
        if (bitmap == null || bitmap.isRecycled()) {
            AppMethodBeat.o(83866);
            return arrayList;
        }
        TTpicBitmapFaceDetect tTpicBitmapFaceDetect;
        try {
            tTpicBitmapFaceDetect = new TTpicBitmapFaceDetect();
            try {
                tTpicBitmapFaceDetect.needDetectFaceFeatures(true);
                tTpicBitmapFaceDetect.needDetectFaceGender(true);
                tTpicBitmapFaceDetect.detectFace(bitmap);
                if (tTpicBitmapFaceDetect.detectedFace()) {
                    arrayList.addAll(pickAvailableFaces(tTpicBitmapFaceDetect, i, hashMap));
                } else {
                    b aVar = new a();
                    try {
                        aVar.detectFace(bitmap);
                        boolean detectedFace = aVar.detectedFace();
                        FaceParam faceParams = aVar.getFaceParams(0);
                        if (detectedFace && faceParams != null) {
                            tTpicBitmapFaceDetect.detectFaceByManual(bitmap, faceParams.bJk, faceParams.bJn, faceParams.bJo);
                            FaceParam faceParams2 = tTpicBitmapFaceDetect.getFaceParams(0);
                            if (faceParams2 != null) {
                                arrayList.add(faceParams2);
                                if (hashMap != null) {
                                    hashMap.put(faceParams2, tTpicBitmapFaceDetect.getFaceAngles(0));
                                }
                            }
                        }
                        bVar2 = aVar;
                    } catch (Throwable th2) {
                        th = th2;
                        bVar = aVar;
                        if (tTpicBitmapFaceDetect != null) {
                        }
                        if (bVar != null) {
                        }
                        AppMethodBeat.o(83866);
                        throw th;
                    }
                }
                tTpicBitmapFaceDetect.destroy();
                if (bVar2 != null) {
                    bVar2.release();
                }
                AppMethodBeat.o(83866);
                return arrayList;
            } catch (Throwable th3) {
                th = th3;
                bVar = null;
                if (tTpicBitmapFaceDetect != null) {
                }
                if (bVar != null) {
                }
                AppMethodBeat.o(83866);
                throw th;
            }
        } catch (Throwable th32) {
            th = th32;
            bVar = null;
            tTpicBitmapFaceDetect = null;
            if (tTpicBitmapFaceDetect != null) {
                tTpicBitmapFaceDetect.destroy();
            }
            if (bVar != null) {
                bVar.release();
            }
            AppMethodBeat.o(83866);
            throw th;
        }
    }

    private static List<FaceParam> pickAvailableFaces(TTpicBitmapFaceDetect tTpicBitmapFaceDetect, int i, HashMap<FaceParam, float[]> hashMap) {
        AppMethodBeat.i(83867);
        ArrayList arrayList = new ArrayList();
        if (tTpicBitmapFaceDetect.mFaceParams != null && tTpicBitmapFaceDetect.mFaceParams.size() > 0) {
            FaceParam faceParam;
            for (int i2 = 0; i2 < tTpicBitmapFaceDetect.mFaceParams.size(); i2++) {
                faceParam = (FaceParam) tTpicBitmapFaceDetect.mFaceParams.get(i2);
                if (checkLegalFace(faceParam, i) != 1) {
                    arrayList.add(faceParam);
                    if (hashMap != null) {
                        hashMap.put(faceParam, tTpicBitmapFaceDetect.getFaceAngles(i2));
                    }
                }
            }
            if (arrayList.isEmpty()) {
                faceParam = (FaceParam) tTpicBitmapFaceDetect.mFaceParams.get(0);
                arrayList.add(faceParam);
                if (hashMap != null) {
                    hashMap.put(faceParam, tTpicBitmapFaceDetect.getFaceAngles(0));
                }
            }
        }
        AppMethodBeat.o(83867);
        return arrayList;
    }

    public static int checkLegalFace(FaceParam faceParam, int i) {
        AppMethodBeat.i(83868);
        if (faceParam == null) {
            AppMethodBeat.o(83868);
            return 1;
        }
        int distance = distance(faceParam.bJn, faceParam.bJo);
        if (distance < 40) {
            AppMethodBeat.o(83868);
            return 1;
        } else if (distance > i) {
            AppMethodBeat.o(83868);
            return 2;
        } else {
            AppMethodBeat.o(83868);
            return 0;
        }
    }

    private static int distance(Point point, Point point2) {
        AppMethodBeat.i(83869);
        int sqrt = (int) Math.sqrt((double) ((Math.abs(point.x - point2.x) * Math.abs(point.x - point2.x)) + (Math.abs(point.y - point2.y) * Math.abs(point.y - point2.y))));
        AppMethodBeat.o(83869);
        return sqrt;
    }

    static {
        AppMethodBeat.i(83874);
        AppMethodBeat.o(83874);
    }

    public static PointF[] flatArray2Points(float[] fArr) {
        AppMethodBeat.i(83870);
        if (fArr == null) {
            AppMethodBeat.o(83870);
            return null;
        }
        PointF[] pointFArr = new PointF[(fArr.length / 2)];
        for (int i = 0; i < fArr.length / 2; i++) {
            pointFArr[i] = new PointF(fArr[i * 2], fArr[(i * 2) + 1]);
        }
        AppMethodBeat.o(83870);
        return pointFArr;
    }

    public static PointF[] ulsee2Orig(PointF[] pointFArr) {
        AppMethodBeat.i(83871);
        if (pointFArr == null) {
            AppMethodBeat.o(83871);
            return null;
        }
        PointF[] pointFArr2 = new PointF[]{pointFArr[0], AlgoUtils.middlePoint(pointFArr[1], pointFArr[2]), pointFArr[3], AlgoUtils.middlePoint(pointFArr[4], pointFArr[5]), pointFArr[6], pointFArr[8], pointFArr[10], pointFArr[12], pointFArr[14], pointFArr[16], pointFArr[18], pointFArr[20], pointFArr[22], pointFArr[24], pointFArr[26], AlgoUtils.middlePoint(pointFArr[27], pointFArr[28]), pointFArr[29], AlgoUtils.middlePoint(pointFArr[30], pointFArr[31]), pointFArr[32], pointFArr[33], pointFArr[64], pointFArr[65], pointFArr[66], pointFArr[67], pointFArr[36], pointFArr[35], pointFArr[34], pointFArr[42], pointFArr[71], pointFArr[70], pointFArr[69], pointFArr[68], pointFArr[39], pointFArr[40], pointFArr[41], pointFArr[52], pointFArr[57], pointFArr[73], pointFArr[56], pointFArr[55], pointFArr[54], pointFArr[72], pointFArr[53], pointFArr[74], pointFArr[104], pointFArr[61], pointFArr[62], pointFArr[76], pointFArr[63], pointFArr[58], pointFArr[59], pointFArr[75], pointFArr[60], pointFArr[77], pointFArr[105], pointFArr[78], pointFArr[80], pointFArr[82], AlgoUtils.middlePoint(pointFArr[47], pointFArr[48]), pointFArr[49], AlgoUtils.middlePoint(pointFArr[50], pointFArr[51]), pointFArr[83], pointFArr[81], pointFArr[79], pointFArr[46], pointFArr[84], pointFArr[90], pointFArr[95], pointFArr[94], pointFArr[93], pointFArr[92], pointFArr[91], pointFArr[101], pointFArr[102], pointFArr[103], pointFArr[85], pointFArr[86], pointFArr[87], pointFArr[88], pointFArr[89], pointFArr[99], pointFArr[98], pointFArr[97]};
        AppMethodBeat.o(83871);
        return pointFArr2;
    }

    public static List<PointF> array2List(PointF[] pointFArr) {
        AppMethodBeat.i(83872);
        ArrayList arrayList = new ArrayList();
        if (pointFArr == null) {
            AppMethodBeat.o(83872);
        } else {
            for (Object add : pointFArr) {
                arrayList.add(add);
            }
            AppMethodBeat.o(83872);
        }
        return arrayList;
    }

    public static List<PointF> facePointf83to90(List<PointF> list) {
        AppMethodBeat.i(83873);
        if (list == null || list.size() < 83) {
            AppMethodBeat.o(83873);
        } else {
            while (list.size() < 90) {
                list.add(new PointF());
            }
            while (list.size() > 90) {
                list.remove(list.size() - 1);
            }
            ((PointF) list.get(83)).x = ((((PointF) list.get(63)).x - ((PointF) list.get(55)).x) / 2.0f) + ((PointF) list.get(55)).x;
            ((PointF) list.get(83)).y = ((((PointF) list.get(63)).y - ((PointF) list.get(55)).y) / 2.0f) + ((PointF) list.get(55)).y;
            ((PointF) list.get(84)).x = ((((PointF) list.get(31)).x - ((PointF) list.get(23)).x) / 2.0f) + ((PointF) list.get(23)).x;
            ((PointF) list.get(84)).y = ((((PointF) list.get(31)).y - ((PointF) list.get(23)).y) / 2.0f) + ((PointF) list.get(23)).y;
            ((PointF) list.get(85)).x = ((((PointF) list.get(77)).x - ((PointF) list.get(59)).x) / 2.0f) + ((PointF) list.get(59)).x;
            ((PointF) list.get(85)).y = ((((PointF) list.get(77)).y - ((PointF) list.get(59)).y) / 2.0f) + ((PointF) list.get(59)).y;
            ((PointF) list.get(86)).x = (((PointF) list.get(35)).x - ((PointF) list.get(6)).x) + ((PointF) list.get(35)).x;
            ((PointF) list.get(86)).y = (((PointF) list.get(35)).y - ((PointF) list.get(6)).y) + ((PointF) list.get(35)).y;
            ((PointF) list.get(87)).x = ((((PointF) list.get(64)).x - ((PointF) list.get(9)).x) * 1.4f) + ((PointF) list.get(64)).x;
            ((PointF) list.get(87)).y = ((((PointF) list.get(64)).y - ((PointF) list.get(9)).y) * 1.4f) + ((PointF) list.get(64)).y;
            ((PointF) list.get(88)).x = (((PointF) list.get(45)).x - ((PointF) list.get(12)).x) + ((PointF) list.get(45)).x;
            ((PointF) list.get(88)).y = (((PointF) list.get(45)).y - ((PointF) list.get(12)).y) + ((PointF) list.get(45)).y;
            ((PointF) list.get(89)).x = (((PointF) list.get(83)).x - ((PointF) list.get(59)).x) + ((PointF) list.get(83)).x;
            ((PointF) list.get(89)).y = (((PointF) list.get(83)).y - ((PointF) list.get(59)).y) + ((PointF) list.get(83)).y;
            AppMethodBeat.o(83873);
        }
        return list;
    }
}
