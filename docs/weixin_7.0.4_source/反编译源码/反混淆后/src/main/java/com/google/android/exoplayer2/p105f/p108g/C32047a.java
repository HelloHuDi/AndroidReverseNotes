package com.google.android.exoplayer2.p105f.p108g;

import android.text.TextUtils;
import com.google.android.exoplayer2.p111i.C0871d;
import com.google.android.exoplayer2.p111i.C17675v;
import com.google.android.exoplayer2.p111i.C32065l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.IOUtils;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* renamed from: com.google.android.exoplayer2.f.g.a */
final class C32047a {
    private static final Pattern bor = Pattern.compile("\\[voice=\"([^\"]*)\"\\]");
    private final C32065l bos = new C32065l();
    private final StringBuilder bot = new StringBuilder();

    static {
        AppMethodBeat.m2504i(95715);
        AppMethodBeat.m2505o(95715);
    }

    public C32047a() {
        AppMethodBeat.m2504i(95708);
        AppMethodBeat.m2505o(95708);
    }

    /* renamed from: C */
    public final C32050d mo52332C(C32065l c32065l) {
        String str;
        Object obj;
        int i;
        Object obj2;
        AppMethodBeat.m2504i(95709);
        this.bot.setLength(0);
        int i2 = c32065l.position;
        do {
        } while (!TextUtils.isEmpty(c32065l.readLine()));
        this.bos.mo52371n(c32065l.data, c32065l.position);
        this.bos.setPosition(i2);
        C32065l c32065l2 = this.bos;
        StringBuilder stringBuilder = this.bot;
        C32047a.m52089D(c32065l2);
        if (c32065l2.mo52382tB() < 5) {
            str = null;
        } else {
            if ("::cue".equals(c32065l2.readString(5))) {
                i2 = c32065l2.position;
                String a = C32047a.m52092a(c32065l2, stringBuilder);
                if (a == null) {
                    str = null;
                } else if ("{".equals(a)) {
                    c32065l2.setPosition(i2);
                    str = "";
                } else {
                    str = null;
                    if ("(".equals(a)) {
                        i2 = c32065l2.position;
                        int i3 = c32065l2.limit;
                        int i4 = i2;
                        obj = null;
                        while (i4 < i3 && obj == null) {
                            i = i4 + 1;
                            obj2 = ((char) c32065l2.data[i4]) == ')' ? 1 : null;
                            i4 = i;
                            obj = obj2;
                        }
                        str = c32065l2.readString((i4 - 1) - c32065l2.position).trim();
                    }
                    a = C32047a.m52092a(c32065l2, stringBuilder);
                    if (!")".equals(a) || a == null) {
                        str = null;
                    }
                }
            } else {
                str = null;
            }
        }
        if (str == null || !"{".equals(C32047a.m52092a(this.bos, this.bot))) {
            AppMethodBeat.m2505o(95709);
            return null;
        }
        int indexOf;
        C32050d c32050d = new C32050d();
        if (!"".equals(str)) {
            i = str.indexOf(91);
            if (i != -1) {
                Matcher matcher = bor.matcher(str.substring(i));
                if (matcher.matches()) {
                    c32050d.boB = matcher.group(1);
                }
                str = str.substring(0, i);
            }
            String[] split = str.split("\\.");
            String str2 = split[0];
            indexOf = str2.indexOf(35);
            if (indexOf != -1) {
                c32050d.boz = str2.substring(0, indexOf);
                c32050d.boy = str2.substring(indexOf + 1);
            } else {
                c32050d.boz = str2;
            }
            if (split.length > 1) {
                c32050d.boA = Arrays.asList((String[]) Arrays.copyOfRange(split, 1, split.length));
            }
        }
        Object obj3 = null;
        obj2 = null;
        while (obj2 == null) {
            indexOf = this.bos.position;
            obj3 = C32047a.m52092a(this.bos, this.bot);
            obj2 = (obj3 == null || "}".equals(obj3)) ? 1 : null;
            if (obj2 == null) {
                this.bos.setPosition(indexOf);
                c32065l2 = this.bos;
                stringBuilder = this.bot;
                C32047a.m52089D(c32065l2);
                String b = C32047a.m52093b(c32065l2, stringBuilder);
                if (!"".equals(b) && VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D.equals(C32047a.m52092a(c32065l2, stringBuilder))) {
                    C32047a.m52089D(c32065l2);
                    StringBuilder stringBuilder2 = new StringBuilder();
                    obj = null;
                    while (obj == null) {
                        int i5 = c32065l2.position;
                        String a2 = C32047a.m52092a(c32065l2, stringBuilder);
                        if (a2 == null) {
                            obj = null;
                            break;
                        } else if ("}".equals(a2) || ";".equals(a2)) {
                            c32065l2.setPosition(i5);
                            obj = 1;
                        } else {
                            stringBuilder2.append(a2);
                        }
                    }
                    obj = stringBuilder2.toString();
                    if (!(obj == null || "".equals(obj))) {
                        int i6 = c32065l2.position;
                        String a3 = C32047a.m52092a(c32065l2, stringBuilder);
                        if (!";".equals(a3)) {
                            if ("}".equals(a3)) {
                                c32065l2.setPosition(i6);
                            }
                        }
                        if ("color".equals(b)) {
                            c32050d.bnT = C0871d.m1976aG(obj);
                            c32050d.bnU = true;
                        } else if ("background-color".equals(b)) {
                            c32050d.backgroundColor = C0871d.m1976aG(obj);
                            c32050d.bnV = true;
                        } else if ("text-decoration".equals(b)) {
                            if ("underline".equals(obj)) {
                                c32050d.bnX = 1;
                            }
                        } else if ("font-family".equals(b)) {
                            c32050d.bnS = C17675v.m27560aR(obj);
                        } else if ("font-weight".equals(b)) {
                            if ("bold".equals(obj)) {
                                c32050d.bnY = 1;
                            }
                        } else if ("font-style".equals(b) && "italic".equals(obj)) {
                            c32050d.bnZ = 1;
                        }
                    }
                }
            }
        }
        if ("}".equals(obj3)) {
            AppMethodBeat.m2505o(95709);
            return c32050d;
        }
        AppMethodBeat.m2505o(95709);
        return null;
    }

    /* renamed from: D */
    private static void m52089D(C32065l c32065l) {
        AppMethodBeat.m2504i(95710);
        Object obj = 1;
        while (c32065l.mo52382tB() > 0 && obj != null) {
            obj = (C32047a.m52090E(c32065l) || C32047a.m52091F(c32065l)) ? 1 : null;
        }
        AppMethodBeat.m2505o(95710);
    }

    /* renamed from: a */
    private static String m52092a(C32065l c32065l, StringBuilder stringBuilder) {
        AppMethodBeat.m2504i(95711);
        C32047a.m52089D(c32065l);
        if (c32065l.mo52382tB() == 0) {
            AppMethodBeat.m2505o(95711);
            return null;
        }
        String b = C32047a.m52093b(c32065l, stringBuilder);
        if ("".equals(b)) {
            b = ((char) c32065l.readUnsignedByte());
            AppMethodBeat.m2505o(95711);
            return b;
        }
        AppMethodBeat.m2505o(95711);
        return b;
    }

    /* renamed from: b */
    private static String m52093b(C32065l c32065l, StringBuilder stringBuilder) {
        int i = 0;
        AppMethodBeat.m2504i(95714);
        stringBuilder.setLength(0);
        int i2 = c32065l.position;
        int i3 = c32065l.limit;
        while (i2 < i3 && i == 0) {
            char c = (char) c32065l.data[i2];
            if ((c < 'A' || c > 'Z') && ((c < 'a' || c > 'z') && !((c >= '0' && c <= '9') || c == '#' || c == '-' || c == '.' || c == '_'))) {
                i = 1;
            } else {
                i2++;
                stringBuilder.append(c);
            }
        }
        c32065l.mo52369eM(i2 - c32065l.position);
        String stringBuilder2 = stringBuilder.toString();
        AppMethodBeat.m2505o(95714);
        return stringBuilder2;
    }

    /* renamed from: E */
    private static boolean m52090E(C32065l c32065l) {
        AppMethodBeat.m2504i(95712);
        switch ((char) c32065l.data[c32065l.position]) {
            case 9:
            case 10:
            case 12:
            case 13:
            case ' ':
                c32065l.mo52369eM(1);
                AppMethodBeat.m2505o(95712);
                return true;
            default:
                AppMethodBeat.m2505o(95712);
                return false;
        }
    }

    /* renamed from: F */
    private static boolean m52091F(C32065l c32065l) {
        AppMethodBeat.m2504i(95713);
        int i = c32065l.position;
        int i2 = c32065l.limit;
        byte[] bArr = c32065l.data;
        if (i + 2 <= i2) {
            int i3 = i + 1;
            if (bArr[i] == (byte) 47) {
                int i4 = i3 + 1;
                if (bArr[i3] == (byte) 42) {
                    while (i4 + 1 < i2) {
                        i = i4 + 1;
                        if (((char) bArr[i4]) == '*' && ((char) bArr[i]) == IOUtils.DIR_SEPARATOR_UNIX) {
                            i++;
                            i2 = i;
                            i4 = i;
                        } else {
                            i4 = i;
                        }
                    }
                    c32065l.mo52369eM(i2 - c32065l.position);
                    AppMethodBeat.m2505o(95713);
                    return true;
                }
            }
        }
        AppMethodBeat.m2505o(95713);
        return false;
    }
}
