package com.tencent.sqlitelint;

import android.content.Context;
import android.content.res.XmlResourceParser;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.sqlitelint.util.SLog;
import com.tencent.sqlitelint.util.SQLiteLintUtil;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.xmlpull.v1.XmlPullParserException;

public final class CheckerWhiteListLogic {
    private static final String ATTRIBUTE_CHECKER_NAME = "name";
    private static final String TAG = "SQLiteLint.CheckerWhiteListLogic";
    private static final String TAG_CHECKER = "checker";
    private static final String TAG_WHITE_LIST_ELEMENT = "element";

    public static void setWhiteList(Context context, String str, int i) {
        String str2 = null;
        AppMethodBeat.m2504i(93974);
        try {
            XmlResourceParser xml = context.getResources().getXml(i);
            if (xml == null) {
                SLog.m8895w(TAG, "buildWhiteListSet: parser null", new Object[0]);
                AppMethodBeat.m2505o(93974);
                return;
            }
            try {
                int eventType = xml.getEventType();
                HashMap hashMap = new HashMap();
                int i2 = 0;
                while (eventType != 1) {
                    switch (eventType) {
                        case 0:
                        case 3:
                            break;
                        case 2:
                            String attributeValue;
                            String name = xml.getName();
                            if (TAG_CHECKER.equalsIgnoreCase(name)) {
                                attributeValue = xml.getAttributeValue(null, "name");
                            } else {
                                attributeValue = str2;
                            }
                            if (TAG_WHITE_LIST_ELEMENT.equalsIgnoreCase(name) && !SQLiteLintUtil.isNullOrNil(attributeValue)) {
                                name = xml.nextText();
                                if (hashMap.get(attributeValue) == null) {
                                    ArrayList arrayList = new ArrayList();
                                    arrayList.add(name);
                                    hashMap.put(attributeValue, arrayList);
                                } else {
                                    ((List) hashMap.get(attributeValue)).add(name);
                                }
                                SLog.m8894v(TAG, "buildWhiteListMap: add to whiteList[%s]: %s", attributeValue, name);
                                str2 = attributeValue;
                                break;
                            }
                            str2 = attributeValue;
                            break;
                            break;
                        default:
                            SLog.m8895w(TAG, "buildWhiteListMap: default branch , eventType:%d", Integer.valueOf(eventType));
                            break;
                    }
                    xml.next();
                    eventType = xml.getEventType();
                    i2++;
                    if (i2 > Downloads.MIN_WAIT_FOR_NETWORK) {
                        SLog.m8892e(TAG, "buildWhiteListMap:maybe dead loop!!", new Object[0]);
                        addToNative(str, hashMap);
                        xml.close();
                        AppMethodBeat.m2505o(93974);
                    }
                }
                addToNative(str, hashMap);
            } catch (XmlPullParserException e) {
                SLog.m8895w(TAG, "buildWhiteListSet: exp=%s", e.getLocalizedMessage());
            } catch (IOException e2) {
                SLog.m8895w(TAG, "buildWhiteListSet: exp=%s", e2.getLocalizedMessage());
            }
            xml.close();
            AppMethodBeat.m2505o(93974);
        } catch (Exception e3) {
            SLog.m8895w(TAG, "buildWhiteListSet: getResources exp=%s", e3.getLocalizedMessage());
            AppMethodBeat.m2505o(93974);
        }
    }

    private static void addToNative(String str, Map<String, List<String>> map) {
        AppMethodBeat.m2504i(93975);
        if (map == null) {
            AppMethodBeat.m2505o(93975);
            return;
        }
        String[] strArr = new String[map.size()];
        String[][] strArr2 = new String[map.size()][];
        int i = 0;
        for (Entry entry : map.entrySet()) {
            strArr[i] = (String) entry.getKey();
            List list = (List) entry.getValue();
            strArr2[i] = new String[list.size()];
            for (int i2 = 0; i2 < list.size(); i2++) {
                strArr2[i][i2] = (String) list.get(i2);
            }
            i++;
        }
        SQLiteLintNativeBridge.nativeAddToWhiteList(str, strArr, strArr2);
        AppMethodBeat.m2505o(93975);
    }
}
