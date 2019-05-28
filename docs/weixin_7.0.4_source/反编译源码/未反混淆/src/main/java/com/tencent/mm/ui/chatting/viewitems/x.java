package com.tencent.mm.ui.chatting.viewitems;

import android.graphics.Color;
import android.text.SpannableString;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.smtt.sdk.WebView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public final class x {
    private static final LayoutParams zfr = new LayoutParams(-1, -2);

    static class b {
        public boolean cNx;
        public int color;
        public int hOg;
        public boolean zfs;
        public int zfu;
        public int zfv;

        private b() {
        }

        public static b y(Map<String, String> map, String str) {
            AppMethodBeat.i(33180);
            String str2 = (String) map.get(str + ".range");
            if (bo.isNullOrNil(str2)) {
                ab.e("MicroMsg.StyleNode", "parseFrom fail, range is null");
                AppMethodBeat.o(33180);
                return null;
            } else if (str2.length() >= 5 && str2.charAt(0) == '{' && str2.charAt(str2.length() - 1) == '}' && str2.contains(",")) {
                ab.d("MicroMsg.StyleNode", "parseFrom, range = ".concat(String.valueOf(str2)));
                String[] split = str2.substring(1, str2.length() - 1).split(",");
                if (split == null || split.length != 2) {
                    ab.e("MicroMsg.StyleNode", "parseFrom fail, range wrong format, strs array length = " + split.length);
                    AppMethodBeat.o(33180);
                    return null;
                }
                b bVar = new b();
                try {
                    bVar.zfu = bo.getInt(split[0], 0);
                    bVar.zfv = bo.getInt(split[1], 0) + bVar.zfu;
                    str2 = (String) map.get(str + ".font");
                    if (bo.isNullOrNil(str2)) {
                        ab.d("MicroMsg.StyleNode", "parseFrom, font is null, use default value");
                        str2 = "m";
                    } else {
                        str2 = str2.toLowerCase();
                    }
                    bVar.cNx = x.cW(str2);
                    bVar.zfs = x.xq(str2);
                    bVar.hOg = x.arI(str2);
                    bVar.color = x.arJ((String) map.get(str + ".color"));
                    AppMethodBeat.o(33180);
                    return bVar;
                } catch (Exception e) {
                    ab.e("MicroMsg.StyleNode", "parseFrom fail, ex = " + e.getMessage());
                    AppMethodBeat.o(33180);
                    return null;
                }
            } else {
                ab.e("MicroMsg.StyleNode", "parseFrom fail, range wrong format, range = ".concat(String.valueOf(str2)));
                AppMethodBeat.o(33180);
                return null;
            }
        }
    }

    static class a implements Comparable<a> {
        public boolean cNx;
        public int color;
        public int hOg;
        public int offset;
        public boolean zfs;
        public String zft;

        private a() {
        }

        public final /* synthetic */ int compareTo(Object obj) {
            AppMethodBeat.i(33179);
            a aVar = (a) obj;
            if (aVar == null) {
                ab.e("MicroMsg.LineNode", "compareTo fail, should not be null");
                AppMethodBeat.o(33179);
                return 1;
            }
            int i = this.offset - aVar.offset;
            AppMethodBeat.o(33179);
            return i;
        }

        public static a x(Map<String, String> map, String str) {
            AppMethodBeat.i(33178);
            a aVar = new a();
            try {
                aVar.offset = bo.getInt((String) map.get(str + ".offset"), 0);
                String str2 = (String) map.get(str + ".font");
                if (bo.isNullOrNil(str2)) {
                    ab.d("MicroMsg.LineNode", "parseFrom, font is null, use default value");
                    str2 = "m";
                } else {
                    str2 = str2.toLowerCase();
                }
                aVar.cNx = x.cW(str2);
                aVar.zfs = x.xq(str2);
                aVar.hOg = x.arI(str2);
                aVar.color = x.arJ((String) map.get(str + ".color"));
                aVar.zft = (String) map.get(str + ".chars");
                if (bo.isNullOrNil(aVar.zft)) {
                    ab.e("MicroMsg.LineNode", "parseFrom fail, chars is null");
                    AppMethodBeat.o(33178);
                    return null;
                }
                AppMethodBeat.o(33178);
                return aVar;
            } catch (Exception e) {
                ab.e("MicroMsg.LineNode", "parseFrom fail, ex = " + e.getMessage());
                AppMethodBeat.o(33178);
                return null;
            }
        }
    }

    static /* synthetic */ int arJ(String str) {
        AppMethodBeat.i(33188);
        int arH = arH(str);
        AppMethodBeat.o(33188);
        return arH;
    }

    public static boolean a(LinearLayout linearLayout, Map<String, String> map) {
        AppMethodBeat.i(33181);
        if (linearLayout == null) {
            ab.e("MicroMsg.ChattingItemDyeingTemplateDecorator", "decorateStyle fail, digestLl is null");
            AppMethodBeat.o(33181);
            return false;
        }
        String str = (String) map.get(".msg.appmsg.mmreader.category.item.digest");
        if (bo.isNullOrNil(str)) {
            ab.e("MicroMsg.ChattingItemDyeingTemplateDecorator", "decorateStyle, digest is null");
            AppMethodBeat.o(33181);
            return false;
        }
        String str2;
        SpannableString spannableString = new SpannableString(str);
        try {
            spannableString.setSpan(new ForegroundColorSpan(WebView.NIGHT_MODE_COLOR), 0, spannableString.length(), 17);
        } catch (IndexOutOfBoundsException e) {
            ab.e("MicroMsg.ChattingItemDyeingTemplateDecorator", "decorateStyle setSpan error: %s", e.getMessage());
        }
        int i = 0;
        while (true) {
            str2 = ".msg.appmsg.mmreader.category.item.styles.style" + (i == 0 ? "" : String.valueOf(i));
            if (!map.containsKey(str2)) {
                break;
            }
            b y = b.y(map, str2);
            if (y == null) {
                ab.e("MicroMsg.ChattingItemDyeingTemplateDecorator", "parseFrom fail, skip to next, styleKey = ".concat(String.valueOf(str2)));
            } else if (y.zfu >= y.zfv) {
                ab.w("MicroMsg.ChattingItemDyeingTemplateDecorator", "addStyle, no need to add, rangeFrom = " + y.zfu + ", rangeTo = " + y.zfv);
            } else {
                int length;
                int i2 = y.zfu;
                int i3 = y.zfv;
                int i4 = y.hOg;
                boolean z = y.cNx;
                boolean z2 = y.zfs;
                ab.d("MicroMsg.ChattingItemDyeingTemplateDecorator", "setFont, rangeFrom = " + i2 + ", rangeTo = " + i3 + ", fontSize = " + i4 + ", isBlack = " + z + ", isUnderLine = " + z2);
                if (i2 < 0) {
                    ab.e("MicroMsg.ChattingItemDyeingTemplateDecorator", "setFont, params error. length:%d, from:%d, to:%d", Integer.valueOf(spannableString.length()), Integer.valueOf(i2), Integer.valueOf(i3));
                    i2 = 0;
                }
                if (i3 > spannableString.length()) {
                    ab.e("MicroMsg.ChattingItemDyeingTemplateDecorator", "setFont, params error. length:%d, from:%d, to:%d", Integer.valueOf(spannableString.length()), Integer.valueOf(i2), Integer.valueOf(i3));
                    length = spannableString.length();
                } else {
                    length = i3;
                }
                if (z) {
                    try {
                        spannableString.setSpan(new StyleSpan(1), i2, length, 17);
                    } catch (IndexOutOfBoundsException e2) {
                        ab.e("MicroMsg.ChattingItemDyeingTemplateDecorator", "setFont setSpan error: %s", e2.getMessage());
                    }
                }
                if (z2) {
                    try {
                        spannableString.setSpan(new UnderlineSpan(), i2, length, 17);
                    } catch (IndexOutOfBoundsException e22) {
                        ab.e("MicroMsg.ChattingItemDyeingTemplateDecorator", "setFont setSpan error: %s", e22.getMessage());
                    }
                }
                if (i4 != 14) {
                    try {
                        spannableString.setSpan(new AbsoluteSizeSpan(i4), i2, length, 17);
                    } catch (IndexOutOfBoundsException e3) {
                        ab.e("MicroMsg.ChattingItemDyeingTemplateDecorator", "setFont setSpan error: %s", e3.getMessage());
                    }
                }
                i2 = y.zfu;
                i3 = y.zfv;
                length = y.color;
                ab.d("MicroMsg.ChattingItemDyeingTemplateDecorator", "setColor, rangeFrom = " + i2 + ", rangeTo = " + i3 + ", color = " + length);
                if (i2 < 0) {
                    ab.e("MicroMsg.ChattingItemDyeingTemplateDecorator", "setColor, params error. length:%d, from:%d, to:%d", Integer.valueOf(spannableString.length()), Integer.valueOf(i2), Integer.valueOf(i3));
                    i2 = 0;
                }
                if (i3 > spannableString.length()) {
                    ab.e("MicroMsg.ChattingItemDyeingTemplateDecorator", "setColor, params error. length:%d, from:%d, to:%d", Integer.valueOf(spannableString.length()), Integer.valueOf(i2), Integer.valueOf(i3));
                    i3 = spannableString.length();
                }
                try {
                    spannableString.setSpan(new ForegroundColorSpan(length), i2, i3, 17);
                } catch (IndexOutOfBoundsException e32) {
                    ab.e("MicroMsg.ChattingItemDyeingTemplateDecorator", "setFont setSpan error: %s", e32.getMessage());
                }
            }
            i++;
        }
        ab.i("MicroMsg.ChattingItemDyeingTemplateDecorator", "decorateStyle end, total style count = ".concat(String.valueOf(i)));
        i = 0;
        ArrayList arrayList = new ArrayList();
        while (true) {
            str2 = ".msg.appmsg.mmreader.category.item.styles.line" + (i == 0 ? "" : String.valueOf(i));
            if (map.containsKey(str2)) {
                a x = a.x(map, str2);
                if (x == null) {
                    ab.e("MicroMsg.ChattingItemDyeingTemplateDecorator", "parseFrom fail, skip to next, lineKey = ".concat(String.valueOf(str2)));
                } else {
                    arrayList.add(x);
                }
                i++;
            } else {
                ab.d("MicroMsg.ChattingItemDyeingTemplateDecorator", "decorateStyle end, total line count = ".concat(String.valueOf(i)));
                Collections.sort(arrayList);
                linearLayout.removeAllViews();
                a(linearLayout, spannableString, arrayList);
                AppMethodBeat.o(33181);
                return true;
            }
        }
    }

    static {
        AppMethodBeat.i(33189);
        AppMethodBeat.o(33189);
    }

    private static boolean a(LinearLayout linearLayout, SpannableString spannableString, List<a> list) {
        AppMethodBeat.i(33182);
        ab.d("MicroMsg.ChattingItemDyeingTemplateDecorator", "addLines, nodeList size = " + list.size());
        int length = spannableString.length();
        int i = 0;
        for (a aVar : list) {
            if (aVar.offset > i) {
                TextView textView = new TextView(linearLayout.getContext());
                textView.setText(spannableString.subSequence(i, Math.min(aVar.offset, length)));
                textView.setLineSpacing(3.0f, 1.0f);
                linearLayout.addView(textView, zfr);
            }
            TextView textView2 = new TextView(linearLayout.getContext());
            textView2.setText(arG(aVar.zft));
            textView2.setSingleLine(true);
            if (aVar.hOg != 14) {
                textView2.setTextSize((float) aVar.hOg);
            }
            if (aVar.cNx) {
                textView2.setTypeface(null, 1);
            }
            if (aVar.zfs) {
                textView2.setPaintFlags(textView2.getPaintFlags() | 8);
            }
            textView2.setTextColor(aVar.color);
            linearLayout.addView(textView2, zfr);
            i = aVar.offset;
        }
        if (i >= length) {
            ab.i("MicroMsg.ChattingItemDyeingTemplateDecorator", "addLines, lastOffset >= maxLength, lastOffset = " + i + ", maxLength = " + length);
            AppMethodBeat.o(33182);
        } else {
            TextView textView3 = new TextView(linearLayout.getContext());
            textView3.setTextSize(0, (float) com.tencent.mm.bz.a.al(textView3.getContext(), R.dimen.kr));
            textView3.setText(spannableString.subSequence(i, length));
            textView3.setLineSpacing(2.0f, 1.0f);
            linearLayout.addView(textView3, zfr);
            AppMethodBeat.o(33182);
        }
        return true;
    }

    private static String arG(String str) {
        AppMethodBeat.i(33183);
        StringBuilder stringBuilder = new StringBuilder(str);
        while (stringBuilder.length() < 80) {
            stringBuilder.append(str);
        }
        String stringBuilder2 = stringBuilder.toString();
        AppMethodBeat.o(33183);
        return stringBuilder2;
    }

    private static int arH(String str) {
        int i = WebView.NIGHT_MODE_COLOR;
        AppMethodBeat.i(33184);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(33184);
        } else {
            try {
                i = Color.parseColor(str);
                AppMethodBeat.o(33184);
            } catch (Exception e) {
                ab.e("MicroMsg.ChattingItemDyeingTemplateDecorator", "parseFrom, ex = " + e.getMessage());
                AppMethodBeat.o(33184);
            }
        }
        return i;
    }

    static /* synthetic */ boolean cW(String str) {
        AppMethodBeat.i(33185);
        boolean contains = str.contains("b");
        AppMethodBeat.o(33185);
        return contains;
    }

    static /* synthetic */ boolean xq(String str) {
        AppMethodBeat.i(33186);
        boolean contains = str.contains("u");
        AppMethodBeat.o(33186);
        return contains;
    }

    static /* synthetic */ int arI(String str) {
        AppMethodBeat.i(33187);
        if (str.contains("m")) {
            AppMethodBeat.o(33187);
            return 18;
        } else if (str.contains("l")) {
            AppMethodBeat.o(33187);
            return 21;
        } else {
            AppMethodBeat.o(33187);
            return 14;
        }
    }
}
