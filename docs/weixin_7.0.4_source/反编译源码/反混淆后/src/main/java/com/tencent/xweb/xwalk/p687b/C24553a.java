package com.tencent.xweb.xwalk.p687b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.p1115c.C46831a.C16383a;
import com.tencent.xweb.p1115c.C46831a.C46830b;
import com.tencent.xweb.util.C24532f;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.xwalk.core.Log;
import org.xwalk.core.XWalkInitializer;

/* renamed from: com.tencent.xweb.xwalk.b.a */
public final class C24553a {

    /* renamed from: com.tencent.xweb.xwalk.b.a$b */
    public static class C16409b {
        public String ATb;
        public int ATf;
        public String ATg;
        public boolean ATh;
        public boolean bUseCdn;
    }

    /* renamed from: com.tencent.xweb.xwalk.b.a$c */
    public static class C16410c {
        public String ATb = "";
        public String ATc = "";
        public C24554d[] ATi = null;
    }

    /* renamed from: com.tencent.xweb.xwalk.b.a$e */
    public static class C16411e {
        C46830b AOK = new C46830b();
        public String ATb;
        public String ATg;
        public boolean ATh;
        public int ATl;
        public C16409b[] ATm;
        public int ATn;
        public C24556f ATo = new C24556f();
        public boolean bTryUseSharedCore = true;
        public boolean bUseCdn;

        public C16411e() {
            AppMethodBeat.m2504i(85445);
            AppMethodBeat.m2505o(85445);
        }
    }

    /* renamed from: com.tencent.xweb.xwalk.b.a$d */
    public static class C24554d {
        public C46830b AOK = new C46830b();
        public String ATb = "";
        public String ATg = "";
        public boolean ATh;
        public String ATj = "";
        public int ATk = 0;
        public int ATl = 0;
        public C16409b[] ATm = null;
        public boolean bUseCdn;

        public C24554d() {
            AppMethodBeat.m2504i(85444);
            AppMethodBeat.m2505o(85444);
        }
    }

    /* renamed from: com.tencent.xweb.xwalk.b.a$a */
    public static class C24555a {
        public String ATb;
        public String ATc;
        public C16411e[] ATd;
        public C16383a[] ATe;
    }

    /* renamed from: com.tencent.xweb.xwalk.b.a$f */
    public static class C24556f {
        public String ATp = "";
    }

    public static C24555a avv(String str) {
        AppMethodBeat.m2504i(85446);
        if (str == null) {
            XWalkInitializer.addXWalkInitializeLog("parse config failed ,path is empty");
            AppMethodBeat.m2505o(85446);
            return null;
        }
        File file = new File(str);
        if (file.exists()) {
            C24555a j = C24553a.m38221j(file, C24553a.m38217a(file, (int) file.length(), "<Versions>"));
            AppMethodBeat.m2505o(85446);
            return j;
        }
        XWalkInitializer.addXWalkInitializeLog("parse config failed ,file not exist");
        AppMethodBeat.m2505o(85446);
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:55:0x00cb A:{SYNTHETIC, Splitter:B:55:0x00cb} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public static String m38217a(File file, int i, String str) {
        Throwable th;
        FileInputStream fileInputStream;
        String str2 = null;
        AppMethodBeat.m2504i(85447);
        FileInputStream fileInputStream2;
        try {
            byte[] bArr = new byte[i];
            fileInputStream2 = new FileInputStream(file);
            try {
                int read = fileInputStream2.read(bArr, 0, bArr.length);
                if (read != bArr.length) {
                    try {
                        fileInputStream2.close();
                    } catch (Exception e) {
                        Log.m81046e("ConfigParser", "getConfigCheckValue close inputStream failed");
                    }
                    AppMethodBeat.m2505o(85447);
                } else {
                    String str3 = new String(bArr, 0, read);
                    int indexOf = str3.indexOf(str);
                    if (indexOf < 0) {
                        try {
                            fileInputStream2.close();
                        } catch (Exception e2) {
                            Log.m81046e("ConfigParser", "getConfigCheckValue close inputStream failed");
                        }
                        AppMethodBeat.m2505o(85447);
                    } else {
                        bArr = MessageDigest.getInstance("MD5").digest(str3.substring(indexOf).getBytes());
                        if (bArr == null || bArr.length == 0) {
                            try {
                                fileInputStream2.close();
                            } catch (Exception e3) {
                                Log.m81046e("ConfigParser", "getConfigCheckValue close inputStream failed");
                            }
                            AppMethodBeat.m2505o(85447);
                        } else {
                            StringBuilder stringBuilder = new StringBuilder(bArr.length);
                            for (byte b : bArr) {
                                String toHexString = Integer.toHexString(b & 255);
                                if (toHexString.length() == 1) {
                                    stringBuilder.append(0);
                                }
                                stringBuilder.append(toHexString);
                            }
                            str2 = stringBuilder.toString().toUpperCase();
                            try {
                                fileInputStream2.close();
                            } catch (Exception e4) {
                                Log.m81046e("ConfigParser", "getConfigCheckValue close inputStream failed");
                            }
                            AppMethodBeat.m2505o(85447);
                        }
                    }
                }
            } catch (Exception e5) {
            } catch (Throwable th2) {
                th = th2;
                fileInputStream = fileInputStream2;
                if (fileInputStream != null) {
                }
                AppMethodBeat.m2505o(85447);
                throw th;
            }
        } catch (Exception e6) {
            fileInputStream2 = null;
            if (fileInputStream2 != null) {
                try {
                    fileInputStream2.close();
                } catch (Exception e7) {
                    Log.m81046e("ConfigParser", "getConfigCheckValue close inputStream failed");
                }
            }
            AppMethodBeat.m2505o(85447);
            return str2;
        } catch (Throwable th3) {
            th = th3;
            fileInputStream = null;
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (Exception e8) {
                    Log.m81046e("ConfigParser", "getConfigCheckValue close inputStream failed");
                }
            }
            AppMethodBeat.m2505o(85447);
            throw th;
        }
        return str2;
    }

    /* renamed from: a */
    private static int m38216a(Element element, String str) {
        AppMethodBeat.m2504i(85448);
        if (element == null) {
            AppMethodBeat.m2505o(85448);
            return 0;
        }
        String attribute = element.getAttribute(str);
        if (attribute == null || attribute.isEmpty()) {
            AppMethodBeat.m2505o(85448);
            return 0;
        }
        int parseInt = Integer.parseInt(attribute);
        AppMethodBeat.m2505o(85448);
        return parseInt;
    }

    /* renamed from: b */
    private static boolean m38220b(Element element, String str) {
        AppMethodBeat.m2504i(85449);
        if (element == null) {
            AppMethodBeat.m2505o(85449);
            return false;
        }
        String attribute = element.getAttribute(str);
        if (attribute == null || attribute.isEmpty()) {
            AppMethodBeat.m2505o(85449);
            return false;
        }
        boolean parseBoolean = Boolean.parseBoolean(attribute);
        AppMethodBeat.m2505o(85449);
        return parseBoolean;
    }

    /* renamed from: a */
    private static C16409b[] m38219a(Element element) {
        AppMethodBeat.m2504i(85450);
        NodeList elementsByTagName = element.getElementsByTagName("Patch");
        if (elementsByTagName == null || elementsByTagName.getLength() == 0) {
            AppMethodBeat.m2505o(85450);
            return null;
        }
        C16409b[] c16409bArr = new C16409b[elementsByTagName.getLength()];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < elementsByTagName.getLength()) {
                C16409b c16409b = new C16409b();
                Element element2 = (Element) elementsByTagName.item(i2);
                c16409b.ATg = element2.getAttribute("url");
                c16409b.ATf = C24553a.m38216a(element2, "targetVersion");
                c16409b.ATb = element2.getAttribute("md5");
                c16409b.ATh = C24553a.m38220b(element2, "useCellular");
                c16409b.bUseCdn = C24553a.m38220b(element2, "useCdn");
                c16409bArr[i2] = c16409b;
                i = i2 + 1;
            } else {
                AppMethodBeat.m2505o(85450);
                return c16409bArr;
            }
        }
    }

    /* renamed from: a */
    private static void m38218a(C24555a c24555a, Element element) {
        AppMethodBeat.m2504i(85451);
        if (element == null) {
            AppMethodBeat.m2505o(85451);
            return;
        }
        try {
            NodeList elementsByTagName = element.getElementsByTagName("command");
            if (elementsByTagName != null && elementsByTagName.getLength() != 0) {
                c24555a.ATe = new C16383a[elementsByTagName.getLength()];
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= elementsByTagName.getLength()) {
                        break;
                    }
                    C16383a c16383a = new C16383a();
                    Element element2 = (Element) elementsByTagName.item(i2);
                    c16383a.AOK.AOQ = C24553a.m38216a(element2, "apkMin");
                    c16383a.AOK.AOR = C24553a.m38216a(element2, "apkMax");
                    c16383a.AOK.AOO = C24553a.m38216a(element2, "sdkMin");
                    c16383a.AOK.AOP = C24553a.m38216a(element2, "sdkMax");
                    c16383a.AOK.AOS = C24553a.m38216a(element2, "apiMin");
                    c16383a.AOK.AOT = C24553a.m38216a(element2, "apiMax");
                    c16383a.AOK.AOU = element2.getAttribute("forbidDeviceRegex");
                    c16383a.AOK.AOV = element2.getAttribute("whiteDeviceRegex");
                    c16383a.AOK.APb = element2.getAttribute("forbidAppRegex");
                    c16383a.AOK.APc = element2.getAttribute("whiteAppRegex");
                    c16383a.AOK.AOW = C24553a.m38216a(element2, "grayMin");
                    c16383a.AOK.AOX = C24553a.m38216a(element2, "grayMax");
                    c16383a.AOK.AOY = C24553a.m38216a(element2, "chromeMin");
                    c16383a.AOK.AOZ = C24553a.m38216a(element2, "chromeMax");
                    c16383a.AOK.APa = C24553a.m38216a(element2, "usertype");
                    c16383a.AOL = element2.getAttribute("optype");
                    c16383a.AOM = element2.getAttribute("opvalue");
                    c16383a.AON = element2.getAttribute("module");
                    c16383a.AOK.APd = C24553a.m38216a(element2, "x5sdkmin");
                    c16383a.AOK.APe = C24553a.m38216a(element2, "x5sdkmax");
                    c16383a.AOK.APf = C24553a.m38216a(element2, "x5coremin");
                    c16383a.AOK.APg = C24553a.m38216a(element2, "x5coremax");
                    c24555a.ATe[i2] = c16383a;
                    i = i2 + 1;
                }
            }
            AppMethodBeat.m2505o(85451);
        } catch (Exception e) {
            AppMethodBeat.m2505o(85451);
        }
    }

    /* JADX WARNING: Unknown top exception splitter block from list: {B:55:0x01f5=Splitter:B:55:0x01f5, B:73:0x0229=Splitter:B:73:0x0229, B:64:0x020f=Splitter:B:64:0x020f} */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x0244 A:{SYNTHETIC, Splitter:B:83:0x0244} */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x01fd A:{SYNTHETIC, Splitter:B:58:0x01fd} */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x0217 A:{SYNTHETIC, Splitter:B:67:0x0217} */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x0231 A:{SYNTHETIC, Splitter:B:76:0x0231} */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x01fd A:{SYNTHETIC, Splitter:B:58:0x01fd} */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x0217 A:{SYNTHETIC, Splitter:B:67:0x0217} */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x0231 A:{SYNTHETIC, Splitter:B:76:0x0231} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: j */
    private static C24555a m38221j(File file, String str) {
        Throwable th;
        int i = 0;
        AppMethodBeat.m2504i(85452);
        DocumentBuilderFactory newInstance = DocumentBuilderFactory.newInstance();
        FileInputStream fileInputStream;
        C24555a c24555a;
        try {
            fileInputStream = new FileInputStream(file);
            try {
                C24555a c24555a2 = new C24555a();
                try {
                    Element documentElement = newInstance.newDocumentBuilder().parse(fileInputStream).getDocumentElement();
                    if (documentElement == null) {
                        XWalkInitializer.addXWalkInitializeLog("xml is cruppted");
                        try {
                            fileInputStream.close();
                        } catch (Exception e) {
                            Log.m81046e("ConfigParser", "parse close inputStream failed");
                        }
                        AppMethodBeat.m2505o(85452);
                        return null;
                    }
                    c24555a2.ATb = documentElement.getAttribute("checkvalue");
                    if (c24555a2.ATb == null || !c24555a2.ATb.equalsIgnoreCase(str)) {
                        C24532f.m38181nI(34);
                        XWalkInitializer.addXWalkInitializeLog("parse config failed , md5 not match");
                        try {
                            fileInputStream.close();
                        } catch (Exception e2) {
                            Log.m81046e("ConfigParser", "parse close inputStream failed");
                        }
                        AppMethodBeat.m2505o(85452);
                        return null;
                    }
                    c24555a2.ATc = documentElement.getAttribute("configVer");
                    C24553a.m38218a(c24555a2, documentElement);
                    NodeList elementsByTagName = documentElement.getElementsByTagName("VersionInfo");
                    if (elementsByTagName != null && elementsByTagName.getLength() != 0) {
                        c24555a2.ATd = new C16411e[elementsByTagName.getLength()];
                        while (true) {
                            int i2 = i;
                            if (i2 < elementsByTagName.getLength()) {
                                C16411e c16411e = new C16411e();
                                Element element = (Element) elementsByTagName.item(i2);
                                c16411e.ATg = element.getAttribute("fullurl");
                                c16411e.ATb = element.getAttribute("md5");
                                c16411e.AOK.AOU = element.getAttribute("forbidDeviceRegex");
                                c16411e.AOK.AOV = element.getAttribute("whiteDeviceRegex");
                                c16411e.AOK.AOQ = C24553a.m38216a(element, "apkMin");
                                c16411e.AOK.AOR = C24553a.m38216a(element, "apkMax");
                                c16411e.AOK.AOO = C24553a.m38216a(element, "sdkMin");
                                c16411e.AOK.AOP = C24553a.m38216a(element, "sdkMax");
                                c16411e.AOK.AOS = C24553a.m38216a(element, "apiMin");
                                c16411e.AOK.AOT = C24553a.m38216a(element, "apiMax");
                                c16411e.ATl = C24553a.m38216a(element, "period");
                                c16411e.ATn = C24553a.m38216a(element, "version");
                                c16411e.ATh = C24553a.m38220b(element, "useCellular");
                                c16411e.AOK.AOW = C24553a.m38216a(element, "grayMin");
                                c16411e.AOK.AOX = C24553a.m38216a(element, "grayMax");
                                c16411e.AOK.AOY = C24553a.m38216a(element, "chromeMin");
                                c16411e.AOK.AOZ = C24553a.m38216a(element, "chromeMax");
                                c16411e.AOK.APa = C24553a.m38216a(element, "usertype");
                                c16411e.bUseCdn = C24553a.m38220b(element, "useCdn");
                                c16411e.AOK.APd = C24553a.m38216a(element, "x5sdkmin");
                                c16411e.AOK.APe = C24553a.m38216a(element, "x5sdkmax");
                                c16411e.AOK.APf = C24553a.m38216a(element, "x5coremin");
                                c16411e.AOK.APg = C24553a.m38216a(element, "x5coremax");
                                String attribute = element.getAttribute("tryUseSharedCore");
                                if (!(attribute == null || attribute.isEmpty())) {
                                    c16411e.bTryUseSharedCore = Boolean.parseBoolean(attribute);
                                }
                                C24556f c24556f = c16411e.ATo;
                                if (c24556f != null) {
                                    NodeList elementsByTagName2 = element.getElementsByTagName("Description");
                                    if (!(elementsByTagName2 == null || elementsByTagName2.getLength() == 0)) {
                                        c24556f.ATp = ((Element) elementsByTagName2.item(0)).getAttribute("versionStr");
                                    }
                                }
                                c16411e.ATm = C24553a.m38219a(element);
                                c24555a2.ATd[i2] = c16411e;
                                i = i2 + 1;
                            }
                        }
                        fileInputStream.close();
                        c24555a = c24555a2;
                        AppMethodBeat.m2505o(85452);
                        return c24555a;
                    }
                    try {
                        fileInputStream.close();
                        c24555a = c24555a2;
                    } catch (Exception e3) {
                        Log.m81046e("ConfigParser", "parse close inputStream failed");
                        c24555a = c24555a2;
                    }
                    AppMethodBeat.m2505o(85452);
                    return c24555a;
                } catch (ParserConfigurationException e4) {
                    c24555a = c24555a2;
                    try {
                        XWalkInitializer.addXWalkInitializeLog("xml is cruppted");
                        if (fileInputStream != null) {
                        }
                        AppMethodBeat.m2505o(85452);
                        return c24555a;
                    } catch (Throwable th2) {
                        th = th2;
                        if (fileInputStream != null) {
                        }
                        AppMethodBeat.m2505o(85452);
                        throw th;
                    }
                } catch (SAXException e5) {
                    c24555a = c24555a2;
                    XWalkInitializer.addXWalkInitializeLog("xml is cruppted");
                    if (fileInputStream != null) {
                    }
                    AppMethodBeat.m2505o(85452);
                    return c24555a;
                } catch (IOException e6) {
                    c24555a = c24555a2;
                    XWalkInitializer.addXWalkInitializeLog("xml is cruppted");
                    if (fileInputStream != null) {
                    }
                    AppMethodBeat.m2505o(85452);
                    return c24555a;
                }
            } catch (ParserConfigurationException e7) {
                c24555a = null;
                XWalkInitializer.addXWalkInitializeLog("xml is cruppted");
                if (fileInputStream != null) {
                }
                AppMethodBeat.m2505o(85452);
                return c24555a;
            } catch (SAXException e8) {
                c24555a = null;
                XWalkInitializer.addXWalkInitializeLog("xml is cruppted");
                if (fileInputStream != null) {
                }
                AppMethodBeat.m2505o(85452);
                return c24555a;
            } catch (IOException e9) {
                c24555a = null;
                XWalkInitializer.addXWalkInitializeLog("xml is cruppted");
                if (fileInputStream != null) {
                }
                AppMethodBeat.m2505o(85452);
                return c24555a;
            }
        } catch (ParserConfigurationException e10) {
            fileInputStream = null;
            c24555a = null;
            XWalkInitializer.addXWalkInitializeLog("xml is cruppted");
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (Exception e11) {
                    Log.m81046e("ConfigParser", "parse close inputStream failed");
                }
            }
            AppMethodBeat.m2505o(85452);
            return c24555a;
        } catch (SAXException e12) {
            fileInputStream = null;
            c24555a = null;
            XWalkInitializer.addXWalkInitializeLog("xml is cruppted");
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (Exception e13) {
                    Log.m81046e("ConfigParser", "parse close inputStream failed");
                }
            }
            AppMethodBeat.m2505o(85452);
            return c24555a;
        } catch (IOException e14) {
            fileInputStream = null;
            c24555a = null;
            XWalkInitializer.addXWalkInitializeLog("xml is cruppted");
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (Exception e15) {
                    Log.m81046e("ConfigParser", "parse close inputStream failed");
                }
            }
            AppMethodBeat.m2505o(85452);
            return c24555a;
        } catch (Throwable th3) {
            th = th3;
            fileInputStream = null;
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (Exception e16) {
                    Log.m81046e("ConfigParser", "parse close inputStream failed");
                }
            }
            AppMethodBeat.m2505o(85452);
            throw th;
        }
    }

    /* JADX WARNING: Unknown top exception splitter block from list: {B:43:0x01d4=Splitter:B:43:0x01d4, B:61:0x0208=Splitter:B:61:0x0208, B:52:0x01ee=Splitter:B:52:0x01ee} */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x0223 A:{SYNTHETIC, Splitter:B:71:0x0223} */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x01dc A:{SYNTHETIC, Splitter:B:46:0x01dc} */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x01f6 A:{SYNTHETIC, Splitter:B:55:0x01f6} */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x0210 A:{SYNTHETIC, Splitter:B:64:0x0210} */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x01dc A:{SYNTHETIC, Splitter:B:46:0x01dc} */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x01f6 A:{SYNTHETIC, Splitter:B:55:0x01f6} */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x0210 A:{SYNTHETIC, Splitter:B:64:0x0210} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: k */
    public static C16410c m38222k(File file, String str) {
        Throwable th;
        AppMethodBeat.m2504i(85453);
        DocumentBuilderFactory newInstance = DocumentBuilderFactory.newInstance();
        FileInputStream fileInputStream;
        C16410c c16410c;
        try {
            fileInputStream = new FileInputStream(file);
            try {
                C16410c c16410c2 = new C16410c();
                try {
                    Element documentElement = newInstance.newDocumentBuilder().parse(fileInputStream).getDocumentElement();
                    if (documentElement == null) {
                        XWalkInitializer.addXWalkInitializeLog("parse plugin config xml root is null");
                        try {
                            fileInputStream.close();
                        } catch (Exception e) {
                            Log.m81046e("ConfigParser", "parsePluginConfig close inputStream failed");
                        }
                        AppMethodBeat.m2505o(85453);
                        return null;
                    }
                    c16410c2.ATb = documentElement.getAttribute("checkvalue");
                    if (c16410c2.ATb == null || !c16410c2.ATb.equalsIgnoreCase(str)) {
                        XWalkInitializer.addXWalkInitializeLog("parse plugin config xml md5 not match");
                        try {
                            fileInputStream.close();
                        } catch (Exception e2) {
                            Log.m81046e("ConfigParser", "parsePluginConfig close inputStream failed");
                        }
                        AppMethodBeat.m2505o(85453);
                        return null;
                    }
                    c16410c2.ATc = documentElement.getAttribute("configVer");
                    NodeList elementsByTagName = documentElement.getElementsByTagName("PluginInfo");
                    if (elementsByTagName != null && elementsByTagName.getLength() != 0) {
                        c16410c2.ATi = new C24554d[elementsByTagName.getLength()];
                        int i = 0;
                        while (true) {
                            int i2 = i;
                            if (i2 < elementsByTagName.getLength()) {
                                documentElement = (Element) elementsByTagName.item(i2);
                                C24554d c24554d = new C24554d();
                                c24554d.ATj = documentElement.getAttribute("name");
                                c24554d.ATk = C24553a.m38216a(documentElement, "version");
                                c24554d.ATg = documentElement.getAttribute("fullurl");
                                c24554d.ATb = documentElement.getAttribute("md5");
                                c24554d.ATh = C24553a.m38220b(documentElement, "useCellular");
                                c24554d.bUseCdn = C24553a.m38220b(documentElement, "useCdn");
                                c24554d.ATl = C24553a.m38216a(documentElement, "period");
                                c24554d.AOK.AOO = C24553a.m38216a(documentElement, "sdkMin");
                                c24554d.AOK.AOP = C24553a.m38216a(documentElement, "sdkMax");
                                c24554d.AOK.AOQ = C24553a.m38216a(documentElement, "apkMin");
                                c24554d.AOK.AOR = C24553a.m38216a(documentElement, "apkMax");
                                c24554d.AOK.AOS = C24553a.m38216a(documentElement, "apiMin");
                                c24554d.AOK.AOT = C24553a.m38216a(documentElement, "apiMax");
                                c24554d.AOK.AOW = C24553a.m38216a(documentElement, "grayMin");
                                c24554d.AOK.AOX = C24553a.m38216a(documentElement, "grayMax");
                                c24554d.AOK.AOY = C24553a.m38216a(documentElement, "chromeMin");
                                c24554d.AOK.AOZ = C24553a.m38216a(documentElement, "chromeMax");
                                c24554d.AOK.APa = C24553a.m38216a(documentElement, "usertype");
                                c24554d.AOK.AOU = documentElement.getAttribute("forbidDeviceRegex");
                                c24554d.AOK.AOV = documentElement.getAttribute("whiteDeviceRegex");
                                c24554d.AOK.APb = documentElement.getAttribute("forbidAppRegex");
                                c24554d.AOK.APc = documentElement.getAttribute("whiteAppRegex");
                                c24554d.AOK.APd = C24553a.m38216a(documentElement, "x5sdkmin");
                                c24554d.AOK.APe = C24553a.m38216a(documentElement, "x5sdkmax");
                                c24554d.AOK.APf = C24553a.m38216a(documentElement, "x5coremin");
                                c24554d.AOK.APg = C24553a.m38216a(documentElement, "x5coremax");
                                c24554d.ATm = C24553a.m38219a(documentElement);
                                c16410c2.ATi[i2] = c24554d;
                                i = i2 + 1;
                            }
                        }
                        fileInputStream.close();
                        c16410c = c16410c2;
                        AppMethodBeat.m2505o(85453);
                        return c16410c;
                    }
                    try {
                        fileInputStream.close();
                        c16410c = c16410c2;
                    } catch (Exception e3) {
                        Log.m81046e("ConfigParser", "parsePluginConfig close inputStream failed");
                        c16410c = c16410c2;
                    }
                    AppMethodBeat.m2505o(85453);
                    return c16410c;
                } catch (ParserConfigurationException e4) {
                    c16410c = c16410c2;
                    try {
                        XWalkInitializer.addXWalkInitializeLog("parse plugin config xml ParserConfigurationException");
                        if (fileInputStream != null) {
                        }
                        AppMethodBeat.m2505o(85453);
                        return c16410c;
                    } catch (Throwable th2) {
                        th = th2;
                        if (fileInputStream != null) {
                        }
                        AppMethodBeat.m2505o(85453);
                        throw th;
                    }
                } catch (SAXException e5) {
                    c16410c = c16410c2;
                    XWalkInitializer.addXWalkInitializeLog("parse plugin config xml SAXException");
                    if (fileInputStream != null) {
                    }
                    AppMethodBeat.m2505o(85453);
                    return c16410c;
                } catch (IOException e6) {
                    c16410c = c16410c2;
                    XWalkInitializer.addXWalkInitializeLog("parse plugin config xml IOException");
                    if (fileInputStream != null) {
                    }
                    AppMethodBeat.m2505o(85453);
                    return c16410c;
                }
            } catch (ParserConfigurationException e7) {
                c16410c = null;
                XWalkInitializer.addXWalkInitializeLog("parse plugin config xml ParserConfigurationException");
                if (fileInputStream != null) {
                }
                AppMethodBeat.m2505o(85453);
                return c16410c;
            } catch (SAXException e8) {
                c16410c = null;
                XWalkInitializer.addXWalkInitializeLog("parse plugin config xml SAXException");
                if (fileInputStream != null) {
                }
                AppMethodBeat.m2505o(85453);
                return c16410c;
            } catch (IOException e9) {
                c16410c = null;
                XWalkInitializer.addXWalkInitializeLog("parse plugin config xml IOException");
                if (fileInputStream != null) {
                }
                AppMethodBeat.m2505o(85453);
                return c16410c;
            }
        } catch (ParserConfigurationException e10) {
            fileInputStream = null;
            c16410c = null;
            XWalkInitializer.addXWalkInitializeLog("parse plugin config xml ParserConfigurationException");
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (Exception e11) {
                    Log.m81046e("ConfigParser", "parsePluginConfig close inputStream failed");
                }
            }
            AppMethodBeat.m2505o(85453);
            return c16410c;
        } catch (SAXException e12) {
            fileInputStream = null;
            c16410c = null;
            XWalkInitializer.addXWalkInitializeLog("parse plugin config xml SAXException");
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (Exception e13) {
                    Log.m81046e("ConfigParser", "parsePluginConfig close inputStream failed");
                }
            }
            AppMethodBeat.m2505o(85453);
            return c16410c;
        } catch (IOException e14) {
            fileInputStream = null;
            c16410c = null;
            XWalkInitializer.addXWalkInitializeLog("parse plugin config xml IOException");
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (Exception e15) {
                    Log.m81046e("ConfigParser", "parsePluginConfig close inputStream failed");
                }
            }
            AppMethodBeat.m2505o(85453);
            return c16410c;
        } catch (Throwable th3) {
            th = th3;
            fileInputStream = null;
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (Exception e16) {
                    Log.m81046e("ConfigParser", "parsePluginConfig close inputStream failed");
                }
            }
            AppMethodBeat.m2505o(85453);
            throw th;
        }
    }
}
