package com.tencent.ttpic.model;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.DateUtils;
import com.tencent.ttpic.logic.watermark.LogicDataManager;
import com.tencent.ttpic.util.VideoPrefsUtil;
import com.tencent.util.i;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class WMLogic {
    private static final String TAG = WMLogic.class.getSimpleName();
    private static final String TYPE_CASE = "case";
    public static final String TYPE_COUNTDOWN = "countdown";
    private static final String TYPE_RANGE = "range";
    public static final String TYPE_SINCE = "since";
    public String compare;
    public String data;
    public List<WMLogicPair> range;
    public String type;
    public List<WMLogicPair> wmcase;

    static {
        AppMethodBeat.i(83601);
        AppMethodBeat.o(83601);
    }

    public void setCompare(String str, String str2) {
        AppMethodBeat.i(83599);
        String string;
        if (this.type.equals(TYPE_SINCE)) {
            string = VideoPrefsUtil.getDefaultPrefs().getString("prefs_key_watermark_since_".concat(String.valueOf(str2)), "");
            if (!TextUtils.isEmpty(string)) {
                str = string;
            }
            this.compare = str;
            AppMethodBeat.o(83599);
        } else if (this.type.equals(TYPE_COUNTDOWN)) {
            string = VideoPrefsUtil.getDefaultPrefs().getString("prefs_key_watermark_countdown_".concat(String.valueOf(str2)), "");
            if (!TextUtils.isEmpty(string)) {
                str = string;
            }
            this.compare = str;
            AppMethodBeat.o(83599);
        } else {
            this.compare = str;
            AppMethodBeat.o(83599);
        }
    }

    public String getValue(String str) {
        AppMethodBeat.i(83600);
        String str2 = "";
        int size;
        int daysBetween;
        String str3;
        if (this.type.equals(TYPE_CASE)) {
            String value = LogicDataManager.getInstance().getValue(this.data);
            for (WMLogicPair wMLogicPair : this.wmcase) {
                if (wMLogicPair.key.equals(value)) {
                    str2 = wMLogicPair.value;
                    break;
                }
            }
        } else if (this.type.equals(TYPE_RANGE)) {
            try {
                String value2 = LogicDataManager.getInstance().getValue(this.data);
                size = this.range.size() - 1;
                while (size >= 0) {
                    if (Integer.parseInt(value2) >= Integer.parseInt(((WMLogicPair) this.range.get(size)).key) || size == 0) {
                        str2 = ((WMLogicPair) this.range.get(size)).value;
                        break;
                    }
                    size--;
                }
            } catch (NumberFormatException e) {
                i.m(TAG, e.getMessage());
            }
        } else if (this.type.equals(TYPE_SINCE)) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            if (TextUtils.isEmpty(str)) {
                str = this.compare;
            }
            daysBetween = DateUtils.daysBetween(str, simpleDateFormat.format(new Date()));
            size = 0;
            while (size < this.range.size()) {
                if (daysBetween <= Integer.parseInt(((WMLogicPair) this.range.get(size)).key) || size == this.range.size() - 1) {
                    str3 = ((WMLogicPair) this.range.get(size)).value;
                    break;
                }
                size++;
            }
            str3 = str2;
            str2 = String.format(str3, new Object[]{Integer.valueOf(daysBetween)});
        } else if (this.type.equals(TYPE_COUNTDOWN)) {
            str3 = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
            if (TextUtils.isEmpty(str)) {
                str = this.compare;
            }
            daysBetween = DateUtils.daysBetween(str3, str);
            size = 0;
            while (size < this.range.size()) {
                if (daysBetween <= Integer.parseInt(((WMLogicPair) this.range.get(size)).key) || size == this.range.size() - 1) {
                    str2 = ((WMLogicPair) this.range.get(size)).value;
                    break;
                }
                size++;
            }
            str2 = String.format(str2, new Object[]{Integer.valueOf(daysBetween)});
        }
        AppMethodBeat.o(83600);
        return str2;
    }
}
