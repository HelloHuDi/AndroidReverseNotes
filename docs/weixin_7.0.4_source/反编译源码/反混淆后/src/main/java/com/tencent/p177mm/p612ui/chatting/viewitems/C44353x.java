package com.tencent.p177mm.p612ui.chatting.viewitems;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.smtt.sdk.WebView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* renamed from: com.tencent.mm.ui.chatting.viewitems.x */
public final class C44353x {
    private static final LayoutParams zfr = new LayoutParams(-1, -2);

    /* renamed from: com.tencent.mm.ui.chatting.viewitems.x$b */
    static class C23885b {
        public boolean cNx;
        public int color;
        public int hOg;
        public boolean zfs;
        public int zfu;
        public int zfv;

        private C23885b() {
        }

        /* renamed from: y */
        public static C23885b m36795y(Map<String, String> map, String str) {
            AppMethodBeat.m2504i(33180);
            String str2 = (String) map.get(str + ".range");
            if (C5046bo.isNullOrNil(str2)) {
                C4990ab.m7412e("MicroMsg.StyleNode", "parseFrom fail, range is null");
                AppMethodBeat.m2505o(33180);
                return null;
            } else if (str2.length() >= 5 && str2.charAt(0) == '{' && str2.charAt(str2.length() - 1) == '}' && str2.contains(",")) {
                C4990ab.m7410d("MicroMsg.StyleNode", "parseFrom, range = ".concat(String.valueOf(str2)));
                String[] split = str2.substring(1, str2.length() - 1).split(",");
                if (split == null || split.length != 2) {
                    C4990ab.m7412e("MicroMsg.StyleNode", "parseFrom fail, range wrong format, strs array length = " + split.length);
                    AppMethodBeat.m2505o(33180);
                    return null;
                }
                C23885b c23885b = new C23885b();
                try {
                    c23885b.zfu = C5046bo.getInt(split[0], 0);
                    c23885b.zfv = C5046bo.getInt(split[1], 0) + c23885b.zfu;
                    str2 = (String) map.get(str + ".font");
                    if (C5046bo.isNullOrNil(str2)) {
                        C4990ab.m7410d("MicroMsg.StyleNode", "parseFrom, font is null, use default value");
                        str2 = "m";
                    } else {
                        str2 = str2.toLowerCase();
                    }
                    c23885b.cNx = C44353x.m80174cW(str2);
                    c23885b.zfs = C44353x.m80175xq(str2);
                    c23885b.hOg = C44353x.arI(str2);
                    c23885b.color = C44353x.arJ((String) map.get(str + ".color"));
                    AppMethodBeat.m2505o(33180);
                    return c23885b;
                } catch (Exception e) {
                    C4990ab.m7412e("MicroMsg.StyleNode", "parseFrom fail, ex = " + e.getMessage());
                    AppMethodBeat.m2505o(33180);
                    return null;
                }
            } else {
                C4990ab.m7412e("MicroMsg.StyleNode", "parseFrom fail, range wrong format, range = ".concat(String.valueOf(str2)));
                AppMethodBeat.m2505o(33180);
                return null;
            }
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.viewitems.x$a */
    static class C44354a implements Comparable<C44354a> {
        public boolean cNx;
        public int color;
        public int hOg;
        public int offset;
        public boolean zfs;
        public String zft;

        private C44354a() {
        }

        public final /* synthetic */ int compareTo(Object obj) {
            AppMethodBeat.m2504i(33179);
            C44354a c44354a = (C44354a) obj;
            if (c44354a == null) {
                C4990ab.m7412e("MicroMsg.LineNode", "compareTo fail, should not be null");
                AppMethodBeat.m2505o(33179);
                return 1;
            }
            int i = this.offset - c44354a.offset;
            AppMethodBeat.m2505o(33179);
            return i;
        }

        /* renamed from: x */
        public static C44354a m80176x(Map<String, String> map, String str) {
            AppMethodBeat.m2504i(33178);
            C44354a c44354a = new C44354a();
            try {
                c44354a.offset = C5046bo.getInt((String) map.get(str + ".offset"), 0);
                String str2 = (String) map.get(str + ".font");
                if (C5046bo.isNullOrNil(str2)) {
                    C4990ab.m7410d("MicroMsg.LineNode", "parseFrom, font is null, use default value");
                    str2 = "m";
                } else {
                    str2 = str2.toLowerCase();
                }
                c44354a.cNx = C44353x.m80174cW(str2);
                c44354a.zfs = C44353x.m80175xq(str2);
                c44354a.hOg = C44353x.arI(str2);
                c44354a.color = C44353x.arJ((String) map.get(str + ".color"));
                c44354a.zft = (String) map.get(str + ".chars");
                if (C5046bo.isNullOrNil(c44354a.zft)) {
                    C4990ab.m7412e("MicroMsg.LineNode", "parseFrom fail, chars is null");
                    AppMethodBeat.m2505o(33178);
                    return null;
                }
                AppMethodBeat.m2505o(33178);
                return c44354a;
            } catch (Exception e) {
                C4990ab.m7412e("MicroMsg.LineNode", "parseFrom fail, ex = " + e.getMessage());
                AppMethodBeat.m2505o(33178);
                return null;
            }
        }
    }

    static /* synthetic */ int arJ(String str) {
        AppMethodBeat.m2504i(33188);
        int arH = C44353x.arH(str);
        AppMethodBeat.m2505o(33188);
        return arH;
    }

    /* renamed from: a */
    public static boolean m80173a(LinearLayout linearLayout, Map<String, String> map) {
        AppMethodBeat.m2504i(33181);
        if (linearLayout == null) {
            C4990ab.m7412e("MicroMsg.ChattingItemDyeingTemplateDecorator", "decorateStyle fail, digestLl is null");
            AppMethodBeat.m2505o(33181);
            return false;
        }
        String str = (String) map.get(".msg.appmsg.mmreader.category.item.digest");
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7412e("MicroMsg.ChattingItemDyeingTemplateDecorator", "decorateStyle, digest is null");
            AppMethodBeat.m2505o(33181);
            return false;
        }
        String str2;
        SpannableString spannableString = new SpannableString(str);
        try {
            spannableString.setSpan(new ForegroundColorSpan(WebView.NIGHT_MODE_COLOR), 0, spannableString.length(), 17);
        } catch (IndexOutOfBoundsException e) {
            C4990ab.m7413e("MicroMsg.ChattingItemDyeingTemplateDecorator", "decorateStyle setSpan error: %s", e.getMessage());
        }
        int i = 0;
        while (true) {
            str2 = ".msg.appmsg.mmreader.category.item.styles.style" + (i == 0 ? "" : String.valueOf(i));
            if (!map.containsKey(str2)) {
                break;
            }
            C23885b y = C23885b.m36795y(map, str2);
            if (y == null) {
                C4990ab.m7412e("MicroMsg.ChattingItemDyeingTemplateDecorator", "parseFrom fail, skip to next, styleKey = ".concat(String.valueOf(str2)));
            } else if (y.zfu >= y.zfv) {
                C4990ab.m7420w("MicroMsg.ChattingItemDyeingTemplateDecorator", "addStyle, no need to add, rangeFrom = " + y.zfu + ", rangeTo = " + y.zfv);
            } else {
                int length;
                int i2 = y.zfu;
                int i3 = y.zfv;
                int i4 = y.hOg;
                boolean z = y.cNx;
                boolean z2 = y.zfs;
                C4990ab.m7410d("MicroMsg.ChattingItemDyeingTemplateDecorator", "setFont, rangeFrom = " + i2 + ", rangeTo = " + i3 + ", fontSize = " + i4 + ", isBlack = " + z + ", isUnderLine = " + z2);
                if (i2 < 0) {
                    C4990ab.m7413e("MicroMsg.ChattingItemDyeingTemplateDecorator", "setFont, params error. length:%d, from:%d, to:%d", Integer.valueOf(spannableString.length()), Integer.valueOf(i2), Integer.valueOf(i3));
                    i2 = 0;
                }
                if (i3 > spannableString.length()) {
                    C4990ab.m7413e("MicroMsg.ChattingItemDyeingTemplateDecorator", "setFont, params error. length:%d, from:%d, to:%d", Integer.valueOf(spannableString.length()), Integer.valueOf(i2), Integer.valueOf(i3));
                    length = spannableString.length();
                } else {
                    length = i3;
                }
                if (z) {
                    try {
                        spannableString.setSpan(new StyleSpan(1), i2, length, 17);
                    } catch (IndexOutOfBoundsException e2) {
                        C4990ab.m7413e("MicroMsg.ChattingItemDyeingTemplateDecorator", "setFont setSpan error: %s", e2.getMessage());
                    }
                }
                if (z2) {
                    try {
                        spannableString.setSpan(new UnderlineSpan(), i2, length, 17);
                    } catch (IndexOutOfBoundsException e22) {
                        C4990ab.m7413e("MicroMsg.ChattingItemDyeingTemplateDecorator", "setFont setSpan error: %s", e22.getMessage());
                    }
                }
                if (i4 != 14) {
                    try {
                        spannableString.setSpan(new AbsoluteSizeSpan(i4), i2, length, 17);
                    } catch (IndexOutOfBoundsException e3) {
                        C4990ab.m7413e("MicroMsg.ChattingItemDyeingTemplateDecorator", "setFont setSpan error: %s", e3.getMessage());
                    }
                }
                i2 = y.zfu;
                i3 = y.zfv;
                length = y.color;
                C4990ab.m7410d("MicroMsg.ChattingItemDyeingTemplateDecorator", "setColor, rangeFrom = " + i2 + ", rangeTo = " + i3 + ", color = " + length);
                if (i2 < 0) {
                    C4990ab.m7413e("MicroMsg.ChattingItemDyeingTemplateDecorator", "setColor, params error. length:%d, from:%d, to:%d", Integer.valueOf(spannableString.length()), Integer.valueOf(i2), Integer.valueOf(i3));
                    i2 = 0;
                }
                if (i3 > spannableString.length()) {
                    C4990ab.m7413e("MicroMsg.ChattingItemDyeingTemplateDecorator", "setColor, params error. length:%d, from:%d, to:%d", Integer.valueOf(spannableString.length()), Integer.valueOf(i2), Integer.valueOf(i3));
                    i3 = spannableString.length();
                }
                try {
                    spannableString.setSpan(new ForegroundColorSpan(length), i2, i3, 17);
                } catch (IndexOutOfBoundsException e32) {
                    C4990ab.m7413e("MicroMsg.ChattingItemDyeingTemplateDecorator", "setFont setSpan error: %s", e32.getMessage());
                }
            }
            i++;
        }
        C4990ab.m7416i("MicroMsg.ChattingItemDyeingTemplateDecorator", "decorateStyle end, total style count = ".concat(String.valueOf(i)));
        i = 0;
        ArrayList arrayList = new ArrayList();
        while (true) {
            str2 = ".msg.appmsg.mmreader.category.item.styles.line" + (i == 0 ? "" : String.valueOf(i));
            if (map.containsKey(str2)) {
                C44354a x = C44354a.m80176x(map, str2);
                if (x == null) {
                    C4990ab.m7412e("MicroMsg.ChattingItemDyeingTemplateDecorator", "parseFrom fail, skip to next, lineKey = ".concat(String.valueOf(str2)));
                } else {
                    arrayList.add(x);
                }
                i++;
            } else {
                C4990ab.m7410d("MicroMsg.ChattingItemDyeingTemplateDecorator", "decorateStyle end, total line count = ".concat(String.valueOf(i)));
                Collections.sort(arrayList);
                linearLayout.removeAllViews();
                C44353x.m80172a(linearLayout, spannableString, arrayList);
                AppMethodBeat.m2505o(33181);
                return true;
            }
        }
    }

    static {
        AppMethodBeat.m2504i(33189);
        AppMethodBeat.m2505o(33189);
    }

    /* renamed from: a */
    private static boolean m80172a(LinearLayout linearLayout, SpannableString spannableString, List<C44354a> list) {
        AppMethodBeat.m2504i(33182);
        C4990ab.m7410d("MicroMsg.ChattingItemDyeingTemplateDecorator", "addLines, nodeList size = " + list.size());
        int length = spannableString.length();
        int i = 0;
        for (C44354a c44354a : list) {
            if (c44354a.offset > i) {
                TextView textView = new TextView(linearLayout.getContext());
                textView.setText(spannableString.subSequence(i, Math.min(c44354a.offset, length)));
                textView.setLineSpacing(3.0f, 1.0f);
                linearLayout.addView(textView, zfr);
            }
            TextView textView2 = new TextView(linearLayout.getContext());
            textView2.setText(C44353x.arG(c44354a.zft));
            textView2.setSingleLine(true);
            if (c44354a.hOg != 14) {
                textView2.setTextSize((float) c44354a.hOg);
            }
            if (c44354a.cNx) {
                textView2.setTypeface(null, 1);
            }
            if (c44354a.zfs) {
                textView2.setPaintFlags(textView2.getPaintFlags() | 8);
            }
            textView2.setTextColor(c44354a.color);
            linearLayout.addView(textView2, zfr);
            i = c44354a.offset;
        }
        if (i >= length) {
            C4990ab.m7416i("MicroMsg.ChattingItemDyeingTemplateDecorator", "addLines, lastOffset >= maxLength, lastOffset = " + i + ", maxLength = " + length);
            AppMethodBeat.m2505o(33182);
        } else {
            TextView textView3 = new TextView(linearLayout.getContext());
            textView3.setTextSize(0, (float) C1338a.m2856al(textView3.getContext(), C25738R.dimen.f9936kr));
            textView3.setText(spannableString.subSequence(i, length));
            textView3.setLineSpacing(2.0f, 1.0f);
            linearLayout.addView(textView3, zfr);
            AppMethodBeat.m2505o(33182);
        }
        return true;
    }

    private static String arG(String str) {
        AppMethodBeat.m2504i(33183);
        StringBuilder stringBuilder = new StringBuilder(str);
        while (stringBuilder.length() < 80) {
            stringBuilder.append(str);
        }
        String stringBuilder2 = stringBuilder.toString();
        AppMethodBeat.m2505o(33183);
        return stringBuilder2;
    }

    private static int arH(String str) {
        int i = WebView.NIGHT_MODE_COLOR;
        AppMethodBeat.m2504i(33184);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(33184);
        } else {
            try {
                i = Color.parseColor(str);
                AppMethodBeat.m2505o(33184);
            } catch (Exception e) {
                C4990ab.m7412e("MicroMsg.ChattingItemDyeingTemplateDecorator", "parseFrom, ex = " + e.getMessage());
                AppMethodBeat.m2505o(33184);
            }
        }
        return i;
    }

    /* renamed from: cW */
    static /* synthetic */ boolean m80174cW(String str) {
        AppMethodBeat.m2504i(33185);
        boolean contains = str.contains("b");
        AppMethodBeat.m2505o(33185);
        return contains;
    }

    /* renamed from: xq */
    static /* synthetic */ boolean m80175xq(String str) {
        AppMethodBeat.m2504i(33186);
        boolean contains = str.contains("u");
        AppMethodBeat.m2505o(33186);
        return contains;
    }

    static /* synthetic */ int arI(String str) {
        AppMethodBeat.m2504i(33187);
        if (str.contains("m")) {
            AppMethodBeat.m2505o(33187);
            return 18;
        } else if (str.contains("l")) {
            AppMethodBeat.m2505o(33187);
            return 21;
        } else {
            AppMethodBeat.m2505o(33187);
            return 14;
        }
    }
}
