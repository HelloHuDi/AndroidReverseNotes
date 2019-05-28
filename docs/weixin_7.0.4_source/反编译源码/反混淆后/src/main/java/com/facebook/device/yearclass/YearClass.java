package com.facebook.device.yearclass;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collections;

public class YearClass {
    public static final int CLASS_2008 = 2008;
    public static final int CLASS_2009 = 2009;
    public static final int CLASS_2010 = 2010;
    public static final int CLASS_2011 = 2011;
    public static final int CLASS_2012 = 2012;
    public static final int CLASS_2013 = 2013;
    public static final int CLASS_2014 = 2014;
    public static final int CLASS_2015 = 2015;
    public static final int CLASS_2016 = 2016;
    public static final int CLASS_UNKNOWN = -1;
    /* renamed from: MB */
    private static final long f14674MB = 1048576;
    private static final int MHZ_IN_KHZ = 1000;
    private static volatile Integer mYearCategory;

    public static int get(Context context) {
        AppMethodBeat.m2504i(114635);
        if (mYearCategory == null) {
            synchronized (YearClass.class) {
                try {
                    if (mYearCategory == null) {
                        mYearCategory = Integer.valueOf(categorizeByYear2016Method(context));
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.m2505o(114635);
                    }
                }
            }
        }
        int intValue = mYearCategory.intValue();
        AppMethodBeat.m2505o(114635);
        return intValue;
    }

    private static void conditionallyAdd(ArrayList<Integer> arrayList, int i) {
        AppMethodBeat.m2504i(114636);
        if (i != -1) {
            arrayList.add(Integer.valueOf(i));
        }
        AppMethodBeat.m2505o(114636);
    }

    private static int categorizeByYear2016Method(Context context) {
        AppMethodBeat.m2504i(114637);
        long totalMemory = DeviceInfo.getTotalMemory(context);
        if (totalMemory == -1) {
            int categorizeByYear2014Method = categorizeByYear2014Method(context);
            AppMethodBeat.m2505o(114637);
            return categorizeByYear2014Method;
        } else if (totalMemory <= 805306368) {
            if (DeviceInfo.getNumberOfCPUCores() <= 1) {
                AppMethodBeat.m2505o(114637);
                return 2009;
            }
            AppMethodBeat.m2505o(114637);
            return 2010;
        } else if (totalMemory <= 1073741824) {
            if (DeviceInfo.getCPUMaxFreqKHz() < 1300000) {
                AppMethodBeat.m2505o(114637);
                return 2011;
            }
            AppMethodBeat.m2505o(114637);
            return 2012;
        } else if (totalMemory <= 1610612736) {
            if (DeviceInfo.getCPUMaxFreqKHz() < 1800000) {
                AppMethodBeat.m2505o(114637);
                return 2012;
            }
            AppMethodBeat.m2505o(114637);
            return 2013;
        } else if (totalMemory <= 2147483648L) {
            AppMethodBeat.m2505o(114637);
            return 2013;
        } else if (totalMemory <= 3221225472L) {
            AppMethodBeat.m2505o(114637);
            return 2014;
        } else if (totalMemory <= 5368709120L) {
            AppMethodBeat.m2505o(114637);
            return 2015;
        } else {
            AppMethodBeat.m2505o(114637);
            return CLASS_2016;
        }
    }

    private static int categorizeByYear2014Method(Context context) {
        AppMethodBeat.m2504i(114638);
        ArrayList arrayList = new ArrayList();
        conditionallyAdd(arrayList, getNumCoresYear());
        conditionallyAdd(arrayList, getClockSpeedYear());
        conditionallyAdd(arrayList, getRamYear(context));
        if (arrayList.isEmpty()) {
            AppMethodBeat.m2505o(114638);
            return -1;
        }
        Collections.sort(arrayList);
        int intValue;
        if ((arrayList.size() & 1) == 1) {
            intValue = ((Integer) arrayList.get(arrayList.size() / 2)).intValue();
            AppMethodBeat.m2505o(114638);
            return intValue;
        }
        int size = (arrayList.size() / 2) - 1;
        intValue = ((((Integer) arrayList.get(size + 1)).intValue() - ((Integer) arrayList.get(size)).intValue()) / 2) + ((Integer) arrayList.get(size)).intValue();
        AppMethodBeat.m2505o(114638);
        return intValue;
    }

    private static int getNumCoresYear() {
        AppMethodBeat.m2504i(114639);
        int numberOfCPUCores = DeviceInfo.getNumberOfCPUCores();
        if (numberOfCPUCores <= 0) {
            AppMethodBeat.m2505o(114639);
            return -1;
        } else if (numberOfCPUCores == 1) {
            AppMethodBeat.m2505o(114639);
            return 2008;
        } else if (numberOfCPUCores <= 3) {
            AppMethodBeat.m2505o(114639);
            return 2011;
        } else {
            AppMethodBeat.m2505o(114639);
            return 2012;
        }
    }

    private static int getClockSpeedYear() {
        AppMethodBeat.m2504i(114640);
        long cPUMaxFreqKHz = (long) DeviceInfo.getCPUMaxFreqKHz();
        if (cPUMaxFreqKHz == -1) {
            AppMethodBeat.m2505o(114640);
            return -1;
        } else if (cPUMaxFreqKHz <= 528000) {
            AppMethodBeat.m2505o(114640);
            return 2008;
        } else if (cPUMaxFreqKHz <= 620000) {
            AppMethodBeat.m2505o(114640);
            return 2009;
        } else if (cPUMaxFreqKHz <= 1020000) {
            AppMethodBeat.m2505o(114640);
            return 2010;
        } else if (cPUMaxFreqKHz <= 1220000) {
            AppMethodBeat.m2505o(114640);
            return 2011;
        } else if (cPUMaxFreqKHz <= 1520000) {
            AppMethodBeat.m2505o(114640);
            return 2012;
        } else if (cPUMaxFreqKHz <= 2020000) {
            AppMethodBeat.m2505o(114640);
            return 2013;
        } else {
            AppMethodBeat.m2505o(114640);
            return 2014;
        }
    }

    private static int getRamYear(Context context) {
        AppMethodBeat.m2504i(114641);
        long totalMemory = DeviceInfo.getTotalMemory(context);
        if (totalMemory <= 0) {
            AppMethodBeat.m2505o(114641);
            return -1;
        } else if (totalMemory <= 201326592) {
            AppMethodBeat.m2505o(114641);
            return 2008;
        } else if (totalMemory <= 304087040) {
            AppMethodBeat.m2505o(114641);
            return 2009;
        } else if (totalMemory <= 536870912) {
            AppMethodBeat.m2505o(114641);
            return 2010;
        } else if (totalMemory <= 1073741824) {
            AppMethodBeat.m2505o(114641);
            return 2011;
        } else if (totalMemory <= 1610612736) {
            AppMethodBeat.m2505o(114641);
            return 2012;
        } else if (totalMemory <= 2147483648L) {
            AppMethodBeat.m2505o(114641);
            return 2013;
        } else {
            AppMethodBeat.m2505o(114641);
            return 2014;
        }
    }
}
