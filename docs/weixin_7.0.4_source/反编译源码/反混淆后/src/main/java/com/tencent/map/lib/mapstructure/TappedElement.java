package com.tencent.map.lib.mapstructure;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.p667a.C36517hl;

public class TappedElement {
    private static final int BUILDING_ID_LENGTH = 128;
    private static final int BUILDING_NAME_LENGTH = 68;
    private static final int FLOOR_NAME_LENGTH = 32;
    public static final int TYPE_ANNO = 1;
    public static final int TYPE_ANNO_INDOOR_MAP = 1;
    public static final int TYPE_BLOCKROUTE_ANNO = 7;
    public static final int TYPE_COMPASS = 3;
    public static final int TYPE_INDOORMAP_AREA = 8;
    public static final int TYPE_LINE = 5;
    public static final int TYPE_LOCATION_MARKER = 6;
    public static final int TYPE_NONE = 0;
    public String buildingId;
    public String buildingName;
    public String floorName;
    public long itemId;
    public int itemType;
    public String name;
    public int nameLen;
    public int pixelX;
    public int pixelY;
    public int type;

    private TappedElement() {
    }

    public static TappedElement fromBytes(byte[] bArr) {
        int i = 20;
        AppMethodBeat.m2504i(98164);
        TappedElement tappedElement = new TappedElement();
        byte[] bArr2 = new byte[4];
        System.arraycopy(bArr, 0, bArr2, 0, 4);
        tappedElement.type = C36517hl.m60436a(bArr2);
        System.arraycopy(bArr, 4, bArr2, 0, 4);
        tappedElement.pixelX = C36517hl.m60436a(bArr2);
        System.arraycopy(bArr, 8, bArr2, 0, 4);
        tappedElement.pixelY = C36517hl.m60436a(bArr2);
        System.arraycopy(bArr, 12, bArr2, 0, 4);
        tappedElement.itemType = C36517hl.m60436a(bArr2);
        System.arraycopy(bArr, 16, bArr2, 0, 4);
        tappedElement.nameLen = C36517hl.m60436a(bArr2);
        if (tappedElement.type != 7) {
            byte[] bArr3 = new byte[64];
            System.arraycopy(bArr, 20, bArr3, 0, 64);
            i = 84;
            if (tappedElement.type != 8) {
                tappedElement.name = C36517hl.m60442d(bArr3);
            } else {
                tappedElement.name = C36517hl.m60437a(bArr3, "UTF-8");
            }
        }
        System.arraycopy(bArr, i, bArr2, 0, 4);
        int a = C36517hl.m60436a(bArr2);
        i += 4;
        System.arraycopy(bArr, i, bArr2, 0, 4);
        tappedElement.itemId = (long) (C36517hl.m60436a(bArr2) + (a << 32));
        i += 4;
        if (tappedElement.itemType == 1) {
            bArr2 = new byte[128];
            System.arraycopy(bArr, i, bArr2, 0, 128);
            i += 128;
            tappedElement.buildingId = C36517hl.m60437a(bArr2, "UTF-8");
            bArr2 = new byte[68];
            System.arraycopy(bArr, i, bArr2, 0, 68);
            i += 68;
            tappedElement.buildingName = C36517hl.m60442d(bArr2);
            bArr2 = new byte[32];
            System.arraycopy(bArr, i, bArr2, 0, 32);
            tappedElement.floorName = C36517hl.m60437a(bArr2, "UTF-8");
        }
        AppMethodBeat.m2505o(98164);
        return tappedElement;
    }
}
