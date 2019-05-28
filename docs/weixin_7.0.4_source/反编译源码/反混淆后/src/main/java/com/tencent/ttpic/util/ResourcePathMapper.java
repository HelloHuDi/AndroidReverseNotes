package com.tencent.ttpic.util;

import android.util.Xml;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.FileUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;
import org.xmlpull.v1.XmlSerializer;

public class ResourcePathMapper {
    public static boolean COPY_XML = true;
    public static final String RES_PREFIX_ASSETS = "assets://";
    private static Map<String, String> lutFilterIdMap = new HashMap();
    private static Map<String, ResourcePath> resMap = new HashMap();
    private static String resPathXml;

    public enum MODE {
        REMOTE,
        LOCAL;

        static {
            AppMethodBeat.m2505o(83948);
        }
    }

    public static class ResourcePath {
        /* renamed from: id */
        private String f1685id;
        private List<String> items;
        private String name;
        private String path;
        private String type;

        public ResourcePath(String str, String str2, String str3, String str4) {
            AppMethodBeat.m2504i(83949);
            this.f1685id = str;
            this.type = str2;
            this.name = str3;
            this.path = str4;
            this.items = new ArrayList();
            AppMethodBeat.m2505o(83949);
        }

        public void addItem(String str) {
            AppMethodBeat.m2504i(83950);
            if (str != null) {
                this.items.add(str);
            }
            AppMethodBeat.m2505o(83950);
        }

        public String getId() {
            return this.f1685id;
        }

        public void setId(String str) {
            this.f1685id = str;
        }

        public String getType() {
            return this.type;
        }

        public void setType(String str) {
            this.type = str;
        }

        public String getName() {
            return this.name;
        }

        public void setName(String str) {
            this.name = str;
        }

        public String getPath() {
            return this.path;
        }

        public void setPath(String str) {
            this.path = str;
        }

        public List<String> getItems() {
            return this.items;
        }

        public void setItems(List<String> list) {
            this.items = list;
        }
    }

    static {
        AppMethodBeat.m2504i(83963);
        AppMethodBeat.m2505o(83963);
    }

    public static void init(MODE mode) {
        AppMethodBeat.m2504i(83951);
        String str = VideoGlobalContext.getContext().getFilesDir().getAbsolutePath() + File.separator + "resource_path.xml";
        resPathXml = str;
        if (!checkFileExist(str) || COPY_XML) {
            FileUtils.copyAssets(VideoGlobalContext.getContext(), "resource_path.xml", resPathXml);
            COPY_XML = false;
        }
        parseXml(resPathXml, resMap, lutFilterIdMap);
        if (mode == MODE.REMOTE) {
            clearResourceMap();
        }
        AppMethodBeat.m2505o(83951);
    }

    public static void updateResoucePathStorage() {
        AppMethodBeat.m2504i(83952);
        updateXmlFile(resMap, resPathXml);
        AppMethodBeat.m2505o(83952);
    }

    public static String getFilterResPath(String str) {
        AppMethodBeat.m2504i(83953);
        if (str == null) {
            AppMethodBeat.m2505o(83953);
            return null;
        }
        String substring = str.substring(str.lastIndexOf(47) + 1);
        String str2 = (String) lutFilterIdMap.get(substring);
        if (str2 != null) {
            str2 = getResPath(str2) + substring;
            AppMethodBeat.m2505o(83953);
            return str2;
        }
        AppMethodBeat.m2505o(83953);
        return null;
    }

    public static String getResPath(String str) {
        AppMethodBeat.m2504i(83954);
        if (str == null) {
            AppMethodBeat.m2505o(83954);
            return null;
        }
        ResourcePath resourcePath = (ResourcePath) resMap.get(str);
        if (resourcePath == null || resourcePath.getPath().equals("")) {
            AppMethodBeat.m2505o(83954);
            return null;
        }
        String path = resourcePath.getPath();
        AppMethodBeat.m2505o(83954);
        return path;
    }

    public static void setResPath(String str, String str2) {
        AppMethodBeat.m2504i(83955);
        if (str == null || str2 == null) {
            AppMethodBeat.m2505o(83955);
            return;
        }
        if (!str2.endsWith(File.separator)) {
            str2 = str2 + File.separator;
        }
        ResourcePath resourcePath = (ResourcePath) resMap.get(str);
        if (resourcePath != null) {
            resourcePath.setPath(str2);
            resMap.put(str, resourcePath);
        }
        AppMethodBeat.m2505o(83955);
    }

    public static String getModelResPath(String str) {
        AppMethodBeat.m2504i(83956);
        if (str == null) {
            AppMethodBeat.m2505o(83956);
            return null;
        }
        String str2 = (String) lutFilterIdMap.get(str);
        if (str2 != null) {
            str2 = getResPath(str2);
            AppMethodBeat.m2505o(83956);
            return str2;
        }
        AppMethodBeat.m2505o(83956);
        return null;
    }

    private static void updateXmlFile(Map<String, ResourcePath> map, String str) {
        AppMethodBeat.m2504i(83957);
        if (map == null || str == null) {
            AppMethodBeat.m2505o(83957);
            return;
        }
        File file = new File(str);
        if (file.exists()) {
            file.delete();
            try {
                file.createNewFile();
            } catch (IOException e) {
            }
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            XmlSerializer newSerializer = Xml.newSerializer();
            try {
                newSerializer.setOutput(fileOutputStream, "UTF-8");
                newSerializer.startDocument(null, Boolean.TRUE);
                newSerializer.startTag(null, "resources");
                for (String str2 : map.keySet()) {
                    ResourcePath resourcePath = (ResourcePath) map.get(str2);
                    newSerializer.startTag(null, "resource");
                    newSerializer.attribute(null, "type", resourcePath.getType());
                    newSerializer.attribute(null, "id", resourcePath.getId());
                    newSerializer.attribute(null, "name", resourcePath.getName());
                    newSerializer.attribute(null, "path", resourcePath.getPath());
                    for (String str22 : resourcePath.getItems()) {
                        newSerializer.startTag(null, "item");
                        newSerializer.text(str22);
                        newSerializer.endTag(null, "item");
                    }
                    newSerializer.endTag(null, "resource");
                }
                newSerializer.endTag(null, "resources");
                newSerializer.endDocument();
                newSerializer.flush();
                fileOutputStream.close();
                AppMethodBeat.m2505o(83957);
            } catch (Exception e2) {
                AppMethodBeat.m2505o(83957);
            }
        } catch (FileNotFoundException e3) {
            AppMethodBeat.m2505o(83957);
        }
    }

    private static void parseXml(String str, Map<String, ResourcePath> map, Map<String, String> map2) {
        ResourcePath resourcePath = null;
        AppMethodBeat.m2504i(83958);
        if (!checkFileExist(str) || map == null || map2 == null) {
            AppMethodBeat.m2505o(83958);
            return;
        }
        try {
            XmlPullParser newPullParser = XmlPullParserFactory.newInstance().newPullParser();
            try {
                newPullParser.setInput(new StringReader(bufferedReaderFile(str)));
                int eventType = newPullParser.getEventType();
                while (eventType != 1) {
                    try {
                        String name = newPullParser.getName();
                        switch (eventType) {
                            case 2:
                                String nextText;
                                if (!"resource".equals(name)) {
                                    if ("item".equals(name)) {
                                        nextText = newPullParser.nextText();
                                        resourcePath.addItem(nextText);
                                        map2.put(nextText, resourcePath.getId());
                                        break;
                                    }
                                }
                                name = newPullParser.getAttributeValue(null, "type");
                                String attributeValue = newPullParser.getAttributeValue(null, "id");
                                String attributeValue2 = newPullParser.getAttributeValue(null, "name");
                                String attributeValue3 = newPullParser.getAttributeValue(null, "path");
                                if (attributeValue3 == null || attributeValue3.equals("") || attributeValue3.endsWith(File.separator)) {
                                    nextText = attributeValue3;
                                } else {
                                    nextText = attributeValue3 + File.separator;
                                }
                                resourcePath = new ResourcePath(attributeValue, name, attributeValue2, nextText);
                                map.put(attributeValue, resourcePath);
                                break;
                                break;
                        }
                        eventType = newPullParser.next();
                    } catch (IOException e) {
                        AppMethodBeat.m2505o(83958);
                        return;
                    }
                }
                AppMethodBeat.m2505o(83958);
            } catch (Exception e2) {
                AppMethodBeat.m2505o(83958);
            }
        } catch (XmlPullParserException e3) {
            AppMethodBeat.m2505o(83958);
        }
    }

    private static void clearResourceMap() {
        AppMethodBeat.m2504i(83959);
        if (!(resMap == null || resMap.isEmpty())) {
            for (String str : resMap.keySet()) {
                ResourcePath resourcePath = (ResourcePath) resMap.get(str);
                if (resourcePath.getType().equals("model") || resourcePath.getType().equals("so")) {
                    resourcePath.setPath("");
                    resMap.put(str, resourcePath);
                }
            }
        }
        AppMethodBeat.m2505o(83959);
    }

    private static String bufferedReaderFile(String str) {
        AppMethodBeat.m2504i(83960);
        if (str == null) {
            AppMethodBeat.m2505o(83960);
            return null;
        }
        File file = new File(str);
        if (!file.exists() || file.isDirectory()) {
            FileNotFoundException fileNotFoundException = new FileNotFoundException();
            AppMethodBeat.m2505o(83960);
            throw fileNotFoundException;
        }
        String readLine;
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        StringBuffer stringBuffer = new StringBuffer();
        for (readLine = bufferedReader.readLine(); readLine != null; readLine = bufferedReader.readLine()) {
            stringBuffer.append(readLine + " ");
        }
        bufferedReader.close();
        readLine = stringBuffer.toString();
        AppMethodBeat.m2505o(83960);
        return readLine;
    }

    public static boolean checkFileExist(String str) {
        AppMethodBeat.m2504i(83961);
        if (str == null) {
            AppMethodBeat.m2505o(83961);
            return false;
        } else if (new File(str).exists()) {
            AppMethodBeat.m2505o(83961);
            return true;
        } else {
            AppMethodBeat.m2505o(83961);
            return false;
        }
    }

    public static void printMap() {
        AppMethodBeat.m2504i(83962);
        if (resMap != null) {
            new StringBuilder("resMap.size = ").append(resMap.size());
        }
        for (String str : resMap.keySet()) {
            new StringBuilder("resMap = ").append(((ResourcePath) resMap.get(str)).getId()).append(", ").append(((ResourcePath) resMap.get(str)).getName());
        }
        AppMethodBeat.m2505o(83962);
    }
}
