package com.tencent.ttpic.model;

public class WMEditItem {
    public static int ITEM_TYPE_COUNTDOWN = 3;
    public static int ITEM_TYPE_SINCE = 2;
    public static int ITEM_TYPE_TEXT = 1;
    public int itemType;
    public String value;

    public WMEditItem(String str, int i) {
        this.value = str;
        this.itemType = i;
    }
}
