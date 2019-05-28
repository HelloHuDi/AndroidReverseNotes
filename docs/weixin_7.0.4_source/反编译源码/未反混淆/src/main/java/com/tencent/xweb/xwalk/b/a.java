package com.tencent.xweb.xwalk.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
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

public final class a {

    public static class b {
        public String ATb;
        public int ATf;
        public String ATg;
        public boolean ATh;
        public boolean bUseCdn;
    }

    public static class c {
        public String ATb = "";
        public String ATc = "";
        public d[] ATi = null;
    }

    public static class e {
        com.tencent.xweb.c.a.b AOK = new com.tencent.xweb.c.a.b();
        public String ATb;
        public String ATg;
        public boolean ATh;
        public int ATl;
        public b[] ATm;
        public int ATn;
        public f ATo = new f();
        public boolean bTryUseSharedCore = true;
        public boolean bUseCdn;

        public e() {
            AppMethodBeat.i(85445);
            AppMethodBeat.o(85445);
        }
    }

    public static class d {
        public com.tencent.xweb.c.a.b AOK = new com.tencent.xweb.c.a.b();
        public String ATb = "";
        public String ATg = "";
        public boolean ATh;
        public String ATj = "";
        public int ATk = 0;
        public int ATl = 0;
        public b[] ATm = null;
        public boolean bUseCdn;

        public d() {
            AppMethodBeat.i(85444);
            AppMethodBeat.o(85444);
        }
    }

    public static class a {
        public String ATb;
        public String ATc;
        public e[] ATd;
        public com.tencent.xweb.c.a.a[] ATe;
    }

    public static class f {
        public String ATp = "";
    }

    public static a avv(String str) {
        AppMethodBeat.i(85446);
        if (str == null) {
            XWalkInitializer.addXWalkInitializeLog("parse config failed ,path is empty");
            AppMethodBeat.o(85446);
            return null;
        }
        File file = new File(str);
        if (file.exists()) {
            a j = j(file, a(file, (int) file.length(), "<Versions>"));
            AppMethodBeat.o(85446);
            return j;
        }
        XWalkInitializer.addXWalkInitializeLog("parse config failed ,file not exist");
        AppMethodBeat.o(85446);
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:55:0x00cb A:{SYNTHETIC, Splitter:B:55:0x00cb} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static String a(File file, int i, String str) {
        Throwable th;
        FileInputStream fileInputStream;
        String str2 = null;
        AppMethodBeat.i(85447);
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
                        Log.e("ConfigParser", "getConfigCheckValue close inputStream failed");
                    }
                    AppMethodBeat.o(85447);
                } else {
                    String str3 = new String(bArr, 0, read);
                    int indexOf = str3.indexOf(str);
                    if (indexOf < 0) {
                        try {
                            fileInputStream2.close();
                        } catch (Exception e2) {
                            Log.e("ConfigParser", "getConfigCheckValue close inputStream failed");
                        }
                        AppMethodBeat.o(85447);
                    } else {
                        bArr = MessageDigest.getInstance("MD5").digest(str3.substring(indexOf).getBytes());
                        if (bArr == null || bArr.length == 0) {
                            try {
                                fileInputStream2.close();
                            } catch (Exception e3) {
                                Log.e("ConfigParser", "getConfigCheckValue close inputStream failed");
                            }
                            AppMethodBeat.o(85447);
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
                                Log.e("ConfigParser", "getConfigCheckValue close inputStream failed");
                            }
                            AppMethodBeat.o(85447);
                        }
                    }
                }
            } catch (Exception e5) {
            } catch (Throwable th2) {
                th = th2;
                fileInputStream = fileInputStream2;
                if (fileInputStream != null) {
                }
                AppMethodBeat.o(85447);
                throw th;
            }
        } catch (Exception e6) {
            fileInputStream2 = null;
            if (fileInputStream2 != null) {
                try {
                    fileInputStream2.close();
                } catch (Exception e7) {
                    Log.e("ConfigParser", "getConfigCheckValue close inputStream failed");
                }
            }
            AppMethodBeat.o(85447);
            return str2;
        } catch (Throwable th3) {
            th = th3;
            fileInputStream = null;
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (Exception e8) {
                    Log.e("ConfigParser", "getConfigCheckValue close inputStream failed");
                }
            }
            AppMethodBeat.o(85447);
            throw th;
        }
        return str2;
    }

    private static int a(Element element, String str) {
        AppMethodBeat.i(85448);
        if (element == null) {
            AppMethodBeat.o(85448);
            return 0;
        }
        String attribute = element.getAttribute(str);
        if (attribute == null || attribute.isEmpty()) {
            AppMethodBeat.o(85448);
            return 0;
        }
        int parseInt = Integer.parseInt(attribute);
        AppMethodBeat.o(85448);
        return parseInt;
    }

    private static boolean b(Element element, String str) {
        AppMethodBeat.i(85449);
        if (element == null) {
            AppMethodBeat.o(85449);
            return false;
        }
        String attribute = element.getAttribute(str);
        if (attribute == null || attribute.isEmpty()) {
            AppMethodBeat.o(85449);
            return false;
        }
        boolean parseBoolean = Boolean.parseBoolean(attribute);
        AppMethodBeat.o(85449);
        return parseBoolean;
    }

    private static b[] a(Element element) {
        AppMethodBeat.i(85450);
        NodeList elementsByTagName = element.getElementsByTagName("Patch");
        if (elementsByTagName == null || elementsByTagName.getLength() == 0) {
            AppMethodBeat.o(85450);
            return null;
        }
        b[] bVarArr = new b[elementsByTagName.getLength()];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < elementsByTagName.getLength()) {
                b bVar = new b();
                Element element2 = (Element) elementsByTagName.item(i2);
                bVar.ATg = element2.getAttribute("url");
                bVar.ATf = a(element2, "targetVersion");
                bVar.ATb = element2.getAttribute("md5");
                bVar.ATh = b(element2, "useCellular");
                bVar.bUseCdn = b(element2, "useCdn");
                bVarArr[i2] = bVar;
                i = i2 + 1;
            } else {
                AppMethodBeat.o(85450);
                return bVarArr;
            }
        }
    }

    private static void a(a aVar, Element element) {
        AppMethodBeat.i(85451);
        if (element == null) {
            AppMethodBeat.o(85451);
            return;
        }
        try {
            NodeList elementsByTagName = element.getElementsByTagName("command");
            if (elementsByTagName != null && elementsByTagName.getLength() != 0) {
                aVar.ATe = new com.tencent.xweb.c.a.a[elementsByTagName.getLength()];
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= elementsByTagName.getLength()) {
                        break;
                    }
                    com.tencent.xweb.c.a.a aVar2 = new com.tencent.xweb.c.a.a();
                    Element element2 = (Element) elementsByTagName.item(i2);
                    aVar2.AOK.AOQ = a(element2, "apkMin");
                    aVar2.AOK.AOR = a(element2, "apkMax");
                    aVar2.AOK.AOO = a(element2, "sdkMin");
                    aVar2.AOK.AOP = a(element2, "sdkMax");
                    aVar2.AOK.AOS = a(element2, "apiMin");
                    aVar2.AOK.AOT = a(element2, "apiMax");
                    aVar2.AOK.AOU = element2.getAttribute("forbidDeviceRegex");
                    aVar2.AOK.AOV = element2.getAttribute("whiteDeviceRegex");
                    aVar2.AOK.APb = element2.getAttribute("forbidAppRegex");
                    aVar2.AOK.APc = element2.getAttribute("whiteAppRegex");
                    aVar2.AOK.AOW = a(element2, "grayMin");
                    aVar2.AOK.AOX = a(element2, "grayMax");
                    aVar2.AOK.AOY = a(element2, "chromeMin");
                    aVar2.AOK.AOZ = a(element2, "chromeMax");
                    aVar2.AOK.APa = a(element2, "usertype");
                    aVar2.AOL = element2.getAttribute("optype");
                    aVar2.AOM = element2.getAttribute("opvalue");
                    aVar2.AON = element2.getAttribute("module");
                    aVar2.AOK.APd = a(element2, "x5sdkmin");
                    aVar2.AOK.APe = a(element2, "x5sdkmax");
                    aVar2.AOK.APf = a(element2, "x5coremin");
                    aVar2.AOK.APg = a(element2, "x5coremax");
                    aVar.ATe[i2] = aVar2;
                    i = i2 + 1;
                }
            }
            AppMethodBeat.o(85451);
        } catch (Exception e) {
            AppMethodBeat.o(85451);
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
    private static a j(File file, String str) {
        Throwable th;
        int i = 0;
        AppMethodBeat.i(85452);
        DocumentBuilderFactory newInstance = DocumentBuilderFactory.newInstance();
        FileInputStream fileInputStream;
        a aVar;
        try {
            fileInputStream = new FileInputStream(file);
            try {
                a aVar2 = new a();
                try {
                    Element documentElement = newInstance.newDocumentBuilder().parse(fileInputStream).getDocumentElement();
                    if (documentElement == null) {
                        XWalkInitializer.addXWalkInitializeLog("xml is cruppted");
                        try {
                            fileInputStream.close();
                        } catch (Exception e) {
                            Log.e("ConfigParser", "parse close inputStream failed");
                        }
                        AppMethodBeat.o(85452);
                        return null;
                    }
                    aVar2.ATb = documentElement.getAttribute("checkvalue");
                    if (aVar2.ATb == null || !aVar2.ATb.equalsIgnoreCase(str)) {
                        com.tencent.xweb.util.f.nI(34);
                        XWalkInitializer.addXWalkInitializeLog("parse config failed , md5 not match");
                        try {
                            fileInputStream.close();
                        } catch (Exception e2) {
                            Log.e("ConfigParser", "parse close inputStream failed");
                        }
                        AppMethodBeat.o(85452);
                        return null;
                    }
                    aVar2.ATc = documentElement.getAttribute("configVer");
                    a(aVar2, documentElement);
                    NodeList elementsByTagName = documentElement.getElementsByTagName("VersionInfo");
                    if (elementsByTagName != null && elementsByTagName.getLength() != 0) {
                        aVar2.ATd = new e[elementsByTagName.getLength()];
                        while (true) {
                            int i2 = i;
                            if (i2 < elementsByTagName.getLength()) {
                                e eVar = new e();
                                Element element = (Element) elementsByTagName.item(i2);
                                eVar.ATg = element.getAttribute("fullurl");
                                eVar.ATb = element.getAttribute("md5");
                                eVar.AOK.AOU = element.getAttribute("forbidDeviceRegex");
                                eVar.AOK.AOV = element.getAttribute("whiteDeviceRegex");
                                eVar.AOK.AOQ = a(element, "apkMin");
                                eVar.AOK.AOR = a(element, "apkMax");
                                eVar.AOK.AOO = a(element, "sdkMin");
                                eVar.AOK.AOP = a(element, "sdkMax");
                                eVar.AOK.AOS = a(element, "apiMin");
                                eVar.AOK.AOT = a(element, "apiMax");
                                eVar.ATl = a(element, "period");
                                eVar.ATn = a(element, "version");
                                eVar.ATh = b(element, "useCellular");
                                eVar.AOK.AOW = a(element, "grayMin");
                                eVar.AOK.AOX = a(element, "grayMax");
                                eVar.AOK.AOY = a(element, "chromeMin");
                                eVar.AOK.AOZ = a(element, "chromeMax");
                                eVar.AOK.APa = a(element, "usertype");
                                eVar.bUseCdn = b(element, "useCdn");
                                eVar.AOK.APd = a(element, "x5sdkmin");
                                eVar.AOK.APe = a(element, "x5sdkmax");
                                eVar.AOK.APf = a(element, "x5coremin");
                                eVar.AOK.APg = a(element, "x5coremax");
                                String attribute = element.getAttribute("tryUseSharedCore");
                                if (!(attribute == null || attribute.isEmpty())) {
                                    eVar.bTryUseSharedCore = Boolean.parseBoolean(attribute);
                                }
                                f fVar = eVar.ATo;
                                if (fVar != null) {
                                    NodeList elementsByTagName2 = element.getElementsByTagName("Description");
                                    if (!(elementsByTagName2 == null || elementsByTagName2.getLength() == 0)) {
                                        fVar.ATp = ((Element) elementsByTagName2.item(0)).getAttribute("versionStr");
                                    }
                                }
                                eVar.ATm = a(element);
                                aVar2.ATd[i2] = eVar;
                                i = i2 + 1;
                            }
                        }
                        fileInputStream.close();
                        aVar = aVar2;
                        AppMethodBeat.o(85452);
                        return aVar;
                    }
                    try {
                        fileInputStream.close();
                        aVar = aVar2;
                    } catch (Exception e3) {
                        Log.e("ConfigParser", "parse close inputStream failed");
                        aVar = aVar2;
                    }
                    AppMethodBeat.o(85452);
                    return aVar;
                } catch (ParserConfigurationException e4) {
                    aVar = aVar2;
                    try {
                        XWalkInitializer.addXWalkInitializeLog("xml is cruppted");
                        if (fileInputStream != null) {
                        }
                        AppMethodBeat.o(85452);
                        return aVar;
                    } catch (Throwable th2) {
                        th = th2;
                        if (fileInputStream != null) {
                        }
                        AppMethodBeat.o(85452);
                        throw th;
                    }
                } catch (SAXException e5) {
                    aVar = aVar2;
                    XWalkInitializer.addXWalkInitializeLog("xml is cruppted");
                    if (fileInputStream != null) {
                    }
                    AppMethodBeat.o(85452);
                    return aVar;
                } catch (IOException e6) {
                    aVar = aVar2;
                    XWalkInitializer.addXWalkInitializeLog("xml is cruppted");
                    if (fileInputStream != null) {
                    }
                    AppMethodBeat.o(85452);
                    return aVar;
                }
            } catch (ParserConfigurationException e7) {
                aVar = null;
                XWalkInitializer.addXWalkInitializeLog("xml is cruppted");
                if (fileInputStream != null) {
                }
                AppMethodBeat.o(85452);
                return aVar;
            } catch (SAXException e8) {
                aVar = null;
                XWalkInitializer.addXWalkInitializeLog("xml is cruppted");
                if (fileInputStream != null) {
                }
                AppMethodBeat.o(85452);
                return aVar;
            } catch (IOException e9) {
                aVar = null;
                XWalkInitializer.addXWalkInitializeLog("xml is cruppted");
                if (fileInputStream != null) {
                }
                AppMethodBeat.o(85452);
                return aVar;
            }
        } catch (ParserConfigurationException e10) {
            fileInputStream = null;
            aVar = null;
            XWalkInitializer.addXWalkInitializeLog("xml is cruppted");
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (Exception e11) {
                    Log.e("ConfigParser", "parse close inputStream failed");
                }
            }
            AppMethodBeat.o(85452);
            return aVar;
        } catch (SAXException e12) {
            fileInputStream = null;
            aVar = null;
            XWalkInitializer.addXWalkInitializeLog("xml is cruppted");
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (Exception e13) {
                    Log.e("ConfigParser", "parse close inputStream failed");
                }
            }
            AppMethodBeat.o(85452);
            return aVar;
        } catch (IOException e14) {
            fileInputStream = null;
            aVar = null;
            XWalkInitializer.addXWalkInitializeLog("xml is cruppted");
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (Exception e15) {
                    Log.e("ConfigParser", "parse close inputStream failed");
                }
            }
            AppMethodBeat.o(85452);
            return aVar;
        } catch (Throwable th3) {
            th = th3;
            fileInputStream = null;
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (Exception e16) {
                    Log.e("ConfigParser", "parse close inputStream failed");
                }
            }
            AppMethodBeat.o(85452);
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
    public static c k(File file, String str) {
        Throwable th;
        AppMethodBeat.i(85453);
        DocumentBuilderFactory newInstance = DocumentBuilderFactory.newInstance();
        FileInputStream fileInputStream;
        c cVar;
        try {
            fileInputStream = new FileInputStream(file);
            try {
                c cVar2 = new c();
                try {
                    Element documentElement = newInstance.newDocumentBuilder().parse(fileInputStream).getDocumentElement();
                    if (documentElement == null) {
                        XWalkInitializer.addXWalkInitializeLog("parse plugin config xml root is null");
                        try {
                            fileInputStream.close();
                        } catch (Exception e) {
                            Log.e("ConfigParser", "parsePluginConfig close inputStream failed");
                        }
                        AppMethodBeat.o(85453);
                        return null;
                    }
                    cVar2.ATb = documentElement.getAttribute("checkvalue");
                    if (cVar2.ATb == null || !cVar2.ATb.equalsIgnoreCase(str)) {
                        XWalkInitializer.addXWalkInitializeLog("parse plugin config xml md5 not match");
                        try {
                            fileInputStream.close();
                        } catch (Exception e2) {
                            Log.e("ConfigParser", "parsePluginConfig close inputStream failed");
                        }
                        AppMethodBeat.o(85453);
                        return null;
                    }
                    cVar2.ATc = documentElement.getAttribute("configVer");
                    NodeList elementsByTagName = documentElement.getElementsByTagName("PluginInfo");
                    if (elementsByTagName != null && elementsByTagName.getLength() != 0) {
                        cVar2.ATi = new d[elementsByTagName.getLength()];
                        int i = 0;
                        while (true) {
                            int i2 = i;
                            if (i2 < elementsByTagName.getLength()) {
                                documentElement = (Element) elementsByTagName.item(i2);
                                d dVar = new d();
                                dVar.ATj = documentElement.getAttribute("name");
                                dVar.ATk = a(documentElement, "version");
                                dVar.ATg = documentElement.getAttribute("fullurl");
                                dVar.ATb = documentElement.getAttribute("md5");
                                dVar.ATh = b(documentElement, "useCellular");
                                dVar.bUseCdn = b(documentElement, "useCdn");
                                dVar.ATl = a(documentElement, "period");
                                dVar.AOK.AOO = a(documentElement, "sdkMin");
                                dVar.AOK.AOP = a(documentElement, "sdkMax");
                                dVar.AOK.AOQ = a(documentElement, "apkMin");
                                dVar.AOK.AOR = a(documentElement, "apkMax");
                                dVar.AOK.AOS = a(documentElement, "apiMin");
                                dVar.AOK.AOT = a(documentElement, "apiMax");
                                dVar.AOK.AOW = a(documentElement, "grayMin");
                                dVar.AOK.AOX = a(documentElement, "grayMax");
                                dVar.AOK.AOY = a(documentElement, "chromeMin");
                                dVar.AOK.AOZ = a(documentElement, "chromeMax");
                                dVar.AOK.APa = a(documentElement, "usertype");
                                dVar.AOK.AOU = documentElement.getAttribute("forbidDeviceRegex");
                                dVar.AOK.AOV = documentElement.getAttribute("whiteDeviceRegex");
                                dVar.AOK.APb = documentElement.getAttribute("forbidAppRegex");
                                dVar.AOK.APc = documentElement.getAttribute("whiteAppRegex");
                                dVar.AOK.APd = a(documentElement, "x5sdkmin");
                                dVar.AOK.APe = a(documentElement, "x5sdkmax");
                                dVar.AOK.APf = a(documentElement, "x5coremin");
                                dVar.AOK.APg = a(documentElement, "x5coremax");
                                dVar.ATm = a(documentElement);
                                cVar2.ATi[i2] = dVar;
                                i = i2 + 1;
                            }
                        }
                        fileInputStream.close();
                        cVar = cVar2;
                        AppMethodBeat.o(85453);
                        return cVar;
                    }
                    try {
                        fileInputStream.close();
                        cVar = cVar2;
                    } catch (Exception e3) {
                        Log.e("ConfigParser", "parsePluginConfig close inputStream failed");
                        cVar = cVar2;
                    }
                    AppMethodBeat.o(85453);
                    return cVar;
                } catch (ParserConfigurationException e4) {
                    cVar = cVar2;
                    try {
                        XWalkInitializer.addXWalkInitializeLog("parse plugin config xml ParserConfigurationException");
                        if (fileInputStream != null) {
                        }
                        AppMethodBeat.o(85453);
                        return cVar;
                    } catch (Throwable th2) {
                        th = th2;
                        if (fileInputStream != null) {
                        }
                        AppMethodBeat.o(85453);
                        throw th;
                    }
                } catch (SAXException e5) {
                    cVar = cVar2;
                    XWalkInitializer.addXWalkInitializeLog("parse plugin config xml SAXException");
                    if (fileInputStream != null) {
                    }
                    AppMethodBeat.o(85453);
                    return cVar;
                } catch (IOException e6) {
                    cVar = cVar2;
                    XWalkInitializer.addXWalkInitializeLog("parse plugin config xml IOException");
                    if (fileInputStream != null) {
                    }
                    AppMethodBeat.o(85453);
                    return cVar;
                }
            } catch (ParserConfigurationException e7) {
                cVar = null;
                XWalkInitializer.addXWalkInitializeLog("parse plugin config xml ParserConfigurationException");
                if (fileInputStream != null) {
                }
                AppMethodBeat.o(85453);
                return cVar;
            } catch (SAXException e8) {
                cVar = null;
                XWalkInitializer.addXWalkInitializeLog("parse plugin config xml SAXException");
                if (fileInputStream != null) {
                }
                AppMethodBeat.o(85453);
                return cVar;
            } catch (IOException e9) {
                cVar = null;
                XWalkInitializer.addXWalkInitializeLog("parse plugin config xml IOException");
                if (fileInputStream != null) {
                }
                AppMethodBeat.o(85453);
                return cVar;
            }
        } catch (ParserConfigurationException e10) {
            fileInputStream = null;
            cVar = null;
            XWalkInitializer.addXWalkInitializeLog("parse plugin config xml ParserConfigurationException");
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (Exception e11) {
                    Log.e("ConfigParser", "parsePluginConfig close inputStream failed");
                }
            }
            AppMethodBeat.o(85453);
            return cVar;
        } catch (SAXException e12) {
            fileInputStream = null;
            cVar = null;
            XWalkInitializer.addXWalkInitializeLog("parse plugin config xml SAXException");
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (Exception e13) {
                    Log.e("ConfigParser", "parsePluginConfig close inputStream failed");
                }
            }
            AppMethodBeat.o(85453);
            return cVar;
        } catch (IOException e14) {
            fileInputStream = null;
            cVar = null;
            XWalkInitializer.addXWalkInitializeLog("parse plugin config xml IOException");
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (Exception e15) {
                    Log.e("ConfigParser", "parsePluginConfig close inputStream failed");
                }
            }
            AppMethodBeat.o(85453);
            return cVar;
        } catch (Throwable th3) {
            th = th3;
            fileInputStream = null;
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (Exception e16) {
                    Log.e("ConfigParser", "parsePluginConfig close inputStream failed");
                }
            }
            AppMethodBeat.o(85453);
            throw th;
        }
    }
}
