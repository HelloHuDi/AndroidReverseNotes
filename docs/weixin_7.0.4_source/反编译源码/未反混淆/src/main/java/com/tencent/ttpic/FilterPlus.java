package com.tencent.ttpic;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.a.ab;
import com.tencent.filter.m.k;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.view.b;
import com.tencent.view.e;
import java.util.HashMap;
import java.util.HashSet;

public class FilterPlus {
    public static HashMap<Integer, String> FilterIdToResIdMap = new HashMap<Integer, String>() {
        {
            AppMethodBeat.i(80641);
            put(Integer.valueOf(FilterEnum4Shaka.MIC_WEISHI_v4_4_NORMAL), "filters_v4_4/filter_none.png");
            put(Integer.valueOf(FilterEnum4Shaka.MIC_WEISHI_v4_4_NORMAL_BACKCAMEA), "filters_v4_4/filter_none_backcam.png");
            put(Integer.valueOf(FilterEnum4Shaka.MIC_WEISHI_v4_4_ZIRAN), "filters_v4_4/filter_ziran.png");
            put(Integer.valueOf(FilterEnum4Shaka.MIC_WEISHI_v4_4_ZIRAN_BACKCAMERA), "filters_v4_4/filter_ziran_backcam.png");
            put(Integer.valueOf(FilterEnum4Shaka.MIC_WEISHI_v4_4_HEIBAI), "filters_v4_4/filter_heibai.png");
            put(Integer.valueOf(FilterEnum4Shaka.MIC_WEISHI_v4_4_HONGJIU), "filters_v4_4/filter_hongjiu.png");
            put(Integer.valueOf(FilterEnum4Shaka.MIC_WEISHI_v4_4_MAKALONG), "filters_v4_4/filter_makalong.png");
            put(Integer.valueOf(FilterEnum4Shaka.MIC_WEISHI_v4_4_QINGCHE), "filters_v4_4/filter_qingche.png");
            put(Integer.valueOf(FilterEnum4Shaka.MIC_WEISHI_v4_4_TIANPIN), "filters_v4_4/filter_tianpin.png");
            put(Integer.valueOf(FilterEnum4Shaka.MIC_WEISHI_v4_4_LAODIANYING), "filters_v4_4/filter_laodianying.png");
            put(Integer.valueOf(FilterEnum4Shaka.MIC_WEISHI_v4_4_XINDONG), "filters_v4_4/filter_xindong.png");
            put(Integer.valueOf(FilterEnum4Shaka.MIC_WEISHI_v4_4_CHUNJIE), "res1_filter_chunjie_v4_4");
            put(Integer.valueOf(FilterEnum4Shaka.MIC_WEISHI_v4_4_QINGCHEN), "res1_filter_qingchen_v4_4");
            put(Integer.valueOf(FilterEnum4Shaka.MIC_WEISHI_v4_4_YINGTAO), "res1_filter_yingtao_v4_4");
            put(Integer.valueOf(FilterEnum4Shaka.MIC_WEISHI_v4_4_BUDING), "res1_filter_buding_v4_4");
            put(Integer.valueOf(FilterEnum4Shaka.MIC_WEISHI_v4_4_CHUXUE), "res1_filter_chuxue_v4_4");
            put(Integer.valueOf(FilterEnum4Shaka.MIC_WEISHI_v4_4_LANMEI), "res1_filter_lanmei_v4_4");
            put(Integer.valueOf(FilterEnum4Shaka.MIC_WEISHI_v4_4_NAICHA), "res1_filter_naicha_v4_4");
            put(Integer.valueOf(FilterEnum4Shaka.MIC_WEISHI_v4_4_HUAYANG), "res1_filter_huayang_v4_4");
            put(Integer.valueOf(FilterEnum4Shaka.MIC_WEISHI_v4_4_CHENGJING), "res1_filter_chengjing_v4_4");
            put(Integer.valueOf(FilterEnum4Shaka.MIC_WEISHI_v4_4_LIANKONG), "res1_filter_liankong_v4_4");
            put(Integer.valueOf(FilterEnum4Shaka.MIC_WEISHI_v4_4_MEIWEI), "res1_filter_meiwei_v4_4");
            put(Integer.valueOf(FilterEnum4Shaka.MIC_WEISHI_v4_4_XINXIAN), "res1_filter_xinxian_v4_4");
            put(Integer.valueOf(1101), "res1_filter_qingzhuanwa_v4_4");
            put(Integer.valueOf(1102), "res1_filter_huoli_v4_4");
            AppMethodBeat.o(80641);
        }
    };
    private static final String TAG = "FilterPlus";
    public static HashSet<Integer> preInstallFilterId = new HashSet<Integer>() {
        {
            AppMethodBeat.i(80640);
            add(Integer.valueOf(FilterEnum4Shaka.MIC_WEISHI_v4_4_NORMAL));
            add(Integer.valueOf(FilterEnum4Shaka.MIC_WEISHI_v4_4_ZIRAN));
            add(Integer.valueOf(FilterEnum4Shaka.MIC_WEISHI_v4_4_HEIBAI));
            add(Integer.valueOf(FilterEnum4Shaka.MIC_WEISHI_v4_4_HONGJIU));
            add(Integer.valueOf(FilterEnum4Shaka.MIC_WEISHI_v4_4_MAKALONG));
            add(Integer.valueOf(FilterEnum4Shaka.MIC_WEISHI_v4_4_QINGCHE));
            add(Integer.valueOf(FilterEnum4Shaka.MIC_WEISHI_v4_4_TIANPIN));
            add(Integer.valueOf(FilterEnum4Shaka.MIC_WEISHI_v4_4_LAODIANYING));
            add(Integer.valueOf(FilterEnum4Shaka.MIC_WEISHI_v4_4_XINDONG));
            AppMethodBeat.o(80640);
        }
    };
    private static HashMap<String, String> resIdSavePathMap = new HashMap();
    protected BaseFilter mFilter = e.createFilter(0);

    public FilterPlus() {
        AppMethodBeat.i(80642);
        AppMethodBeat.o(80642);
    }

    static {
        AppMethodBeat.i(80645);
        AppMethodBeat.o(80645);
    }

    public static void setResSavePath(String str, String str2) {
        AppMethodBeat.i(80643);
        resIdSavePathMap.put(str, str2);
        AppMethodBeat.o(80643);
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x004c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static BaseFilter createFilter(int i) {
        OutOfMemoryError outOfMemoryError;
        AppMethodBeat.i(80644);
        BaseFilter baseFilter = null;
        boolean z = b.AIE;
        BaseFilter baseFilter2;
        Object outOfMemoryError2;
        try {
            BaseFilter abVar;
            Bitmap vt;
            if (preInstallFilterId.contains(Integer.valueOf(i))) {
                switch (i) {
                    case 1014:
                        abVar = new ab();
                        try {
                            b.AIE = true;
                            vt = b.vt("filters/18CA9978-832A-452F-AE35-331B48417B61");
                            b.AIE = z;
                            abVar.addParam(new k("inputImageTexture2", vt, 33986, true));
                            baseFilter = abVar;
                            break;
                        } catch (OutOfMemoryError e) {
                            outOfMemoryError2 = e;
                            baseFilter2 = abVar;
                            break;
                        }
                    case 1016:
                        abVar = new ab();
                        try {
                            b.AIE = true;
                            vt = b.vt("filters/96FDA0CA-9E92-4073-B832-E5CD7AC0FEBF");
                            b.AIE = z;
                            abVar.addParam(new k("inputImageTexture2", vt, 33986, true));
                            baseFilter = abVar;
                            break;
                        } catch (OutOfMemoryError e2) {
                            outOfMemoryError2 = e2;
                            baseFilter2 = abVar;
                            break;
                        }
                    case FilterEnum4Shaka.MIC_WEISHI_QINSHUI /*1061*/:
                        abVar = new ab();
                        try {
                            b.AIE = true;
                            vt = b.vt("filters/filter_qinshui.png");
                            b.AIE = z;
                            abVar.addParam(new k("inputImageTexture2", vt, 33986, true));
                            baseFilter = abVar;
                            break;
                        } catch (OutOfMemoryError e22) {
                            outOfMemoryError2 = e22;
                            baseFilter2 = abVar;
                            break;
                        }
                    case FilterEnum4Shaka.MIC_WEISHI_RUOZHU /*1065*/:
                        abVar = new ab();
                        try {
                            b.AIE = true;
                            vt = b.vt("filters/filter_ruozhu.png");
                            b.AIE = z;
                            abVar.addParam(new k("inputImageTexture2", vt, 33986, true));
                            baseFilter = abVar;
                            break;
                        } catch (OutOfMemoryError e222) {
                            outOfMemoryError2 = e222;
                            baseFilter2 = abVar;
                            break;
                        }
                    case FilterEnum4Shaka.MIC_WEISHI_v4_4_NORMAL /*1078*/:
                    case FilterEnum4Shaka.MIC_WEISHI_v4_4_ZIRAN_BACKCAMERA /*1079*/:
                    case FilterEnum4Shaka.MIC_WEISHI_v4_4_ZIRAN /*1080*/:
                    case FilterEnum4Shaka.MIC_WEISHI_v4_4_QINGCHE /*1081*/:
                    case FilterEnum4Shaka.MIC_WEISHI_v4_4_MAKALONG /*1086*/:
                    case FilterEnum4Shaka.MIC_WEISHI_v4_4_HONGJIU /*1089*/:
                    case FilterEnum4Shaka.MIC_WEISHI_v4_4_HEIBAI /*1093*/:
                    case FilterEnum4Shaka.MIC_WEISHI_v4_4_NORMAL_BACKCAMEA /*1100*/:
                        if (i >= FilterEnum4Shaka.MIC_WEISHI_v4_4_NORMAL && i <= FilterEnum4Shaka.MIC_WEISHI_v4_4_TIANPIN) {
                            abVar = new ab();
                            try {
                                b.AIE = true;
                                vt = b.vt((String) FilterIdToResIdMap.get(Integer.valueOf(i)));
                                b.AIE = z;
                                abVar.addParam(new k("inputImageTexture2", vt, 33986, true));
                                baseFilter = abVar;
                                break;
                            } catch (OutOfMemoryError e2222) {
                                outOfMemoryError2 = e2222;
                                baseFilter2 = abVar;
                                break;
                            }
                        }
                    default:
                        if (i >= FilterEnum4Shaka.MIC_WEISHI_v4_4_NORMAL && i <= FilterEnum4Shaka.MIC_WEISHI_v4_4_TIANPIN) {
                            abVar = new ab();
                            try {
                                b.AIE = true;
                                vt = b.vt((String) FilterIdToResIdMap.get(Integer.valueOf(i)));
                                b.AIE = z;
                                abVar.addParam(new k("inputImageTexture2", vt, 33986, true));
                                baseFilter = abVar;
                                break;
                            } catch (OutOfMemoryError e22222) {
                                outOfMemoryError2 = e22222;
                                baseFilter2 = abVar;
                                break;
                            }
                        }
                }
                new StringBuilder("oom").append(outOfMemoryError2);
                baseFilter = baseFilter2;
                if (baseFilter == null) {
                    baseFilter = new BaseFilter(GLSLRender.bJB);
                }
                AppMethodBeat.o(80644);
                return baseFilter;
            }
            abVar = new ab();
            try {
                String str = (String) resIdSavePathMap.get(FilterIdToResIdMap.get(Integer.valueOf(i)));
                if (TextUtils.isEmpty(str)) {
                    baseFilter = abVar;
                } else {
                    vt = b.auB(str);
                    if (vt == null) {
                        baseFilter = null;
                    } else {
                        abVar.addParam(new k("inputImageTexture2", vt, 33986, true));
                        baseFilter = abVar;
                    }
                }
            } catch (OutOfMemoryError e222222) {
                outOfMemoryError2 = e222222;
                baseFilter2 = abVar;
            }
            if (baseFilter == null) {
            }
            AppMethodBeat.o(80644);
            return baseFilter;
        } catch (OutOfMemoryError e3) {
            outOfMemoryError2 = e3;
            baseFilter2 = null;
        }
    }
}
