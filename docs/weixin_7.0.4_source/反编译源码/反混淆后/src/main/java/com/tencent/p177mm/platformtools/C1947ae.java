package com.tencent.p177mm.platformtools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

/* renamed from: com.tencent.mm.platformtools.ae */
public final class C1947ae {
    public static boolean ghN = false;
    public static boolean ghO = false;
    public static boolean ghP = false;
    public static boolean ghQ = false;
    public static boolean ghR = false;
    public static boolean ghS = false;
    public static boolean ghT = false;
    public static boolean ghU = false;
    public static boolean ghV = false;
    public static boolean ghW = false;
    public static boolean ghX = false;
    public static boolean ghY = false;
    public static String ghZ = "";
    public static int giA = 0;
    public static String giB = "";
    public static String giC = "";
    public static String giD = null;
    public static String giE = null;
    public static boolean giF = false;
    public static boolean giG = false;
    public static boolean giH = false;
    public static boolean giI = false;
    public static String giJ = "";
    public static String giK = "";
    public static String giL = "";
    public static String giM = "";
    public static String giN = "";
    public static boolean giO = false;
    public static boolean giP = false;
    public static boolean giQ = false;
    public static int giR = 0;
    public static boolean giS = false;
    public static boolean giT = false;
    public static boolean giU = false;
    public static boolean giV = false;
    public static boolean giW = false;
    public static boolean giX = false;
    public static boolean giY = true;
    public static boolean giZ = false;
    public static boolean gia = false;
    public static boolean gib = false;
    public static boolean gic = false;
    public static boolean gid = false;
    public static int gie = 0;
    public static boolean gif = false;
    public static boolean gig = false;
    public static boolean gih = false;
    public static String gii = "";
    public static String gij = "";
    public static boolean gik = false;
    public static boolean gil = false;
    public static boolean gim = false;
    public static boolean gin = false;
    public static boolean gio = false;
    public static boolean gip = false;
    public static boolean giq = false;
    public static int gir = 0;
    public static int gis = 0;
    public static boolean git = false;
    public static String giu = null;
    public static String giv = null;
    public static boolean giw = false;
    public static boolean gix = false;
    public static int giy = 0;
    public static int giz = 0;
    public static boolean gjA = false;
    public static boolean gjB = false;
    private static HashMap<Integer, ConcurrentLinkedQueue<Integer>> gjC = new HashMap();
    public static boolean gjD = false;
    public static boolean gjE = false;
    public static boolean gjF = false;
    public static boolean gja = false;
    public static String gjb = "";
    public static int gjc = 0;
    public static boolean gjd = false;
    public static boolean gje = false;
    public static int gjf = -1;
    public static boolean gjg = false;
    public static String gjh = "";
    public static float gji = 0.4f;
    public static float gjj = 0.7f;
    public static boolean gjk = false;
    public static String gjl = "";
    public static String gjm = "";
    public static boolean gjn = false;
    public static boolean gjo = false;
    public static String gjp = "";
    public static String gjq = "";
    public static boolean gjr = false;
    public static boolean gjs = false;
    public static boolean gjt = false;
    public static boolean gju = false;
    public static boolean gjv = false;
    public static boolean gjw = false;
    public static boolean gjx = false;
    public static boolean gjy = false;
    public static boolean gjz = false;
    public static double lat = 0.0d;
    public static double lng = 0.0d;

    static {
        AppMethodBeat.m2504i(58737);
        AppMethodBeat.m2505o(58737);
    }

    /* renamed from: cH */
    public static void m4156cH(int i, int i2) {
        AppMethodBeat.m2504i(58736);
        synchronized (gjC) {
            try {
                ConcurrentLinkedQueue concurrentLinkedQueue = (ConcurrentLinkedQueue) gjC.get(Integer.valueOf(i));
                if (concurrentLinkedQueue == null) {
                    concurrentLinkedQueue = new ConcurrentLinkedQueue();
                    gjC.put(Integer.valueOf(i), concurrentLinkedQueue);
                }
                concurrentLinkedQueue.add(Integer.valueOf(i2));
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(58736);
            }
        }
    }
}
