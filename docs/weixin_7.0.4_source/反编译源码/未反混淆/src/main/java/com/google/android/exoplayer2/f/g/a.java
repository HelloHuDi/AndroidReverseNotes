package com.google.android.exoplayer2.f.g;

import android.text.TextUtils;
import com.google.android.exoplayer2.i.d;
import com.google.android.exoplayer2.i.l;
import com.google.android.exoplayer2.i.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.IOUtils;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class a {
    private static final Pattern bor = Pattern.compile("\\[voice=\"([^\"]*)\"\\]");
    private final l bos = new l();
    private final StringBuilder bot = new StringBuilder();

    static {
        AppMethodBeat.i(95715);
        AppMethodBeat.o(95715);
    }

    public a() {
        AppMethodBeat.i(95708);
        AppMethodBeat.o(95708);
    }

    public final d C(l lVar) {
        String str;
        Object obj;
        int i;
        Object obj2;
        AppMethodBeat.i(95709);
        this.bot.setLength(0);
        int i2 = lVar.position;
        do {
        } while (!TextUtils.isEmpty(lVar.readLine()));
        this.bos.n(lVar.data, lVar.position);
        this.bos.setPosition(i2);
        l lVar2 = this.bos;
        StringBuilder stringBuilder = this.bot;
        D(lVar2);
        if (lVar2.tB() < 5) {
            str = null;
        } else {
            if ("::cue".equals(lVar2.readString(5))) {
                i2 = lVar2.position;
                String a = a(lVar2, stringBuilder);
                if (a == null) {
                    str = null;
                } else if ("{".equals(a)) {
                    lVar2.setPosition(i2);
                    str = "";
                } else {
                    str = null;
                    if ("(".equals(a)) {
                        i2 = lVar2.position;
                        int i3 = lVar2.limit;
                        int i4 = i2;
                        obj = null;
                        while (i4 < i3 && obj == null) {
                            i = i4 + 1;
                            obj2 = ((char) lVar2.data[i4]) == ')' ? 1 : null;
                            i4 = i;
                            obj = obj2;
                        }
                        str = lVar2.readString((i4 - 1) - lVar2.position).trim();
                    }
                    a = a(lVar2, stringBuilder);
                    if (!")".equals(a) || a == null) {
                        str = null;
                    }
                }
            } else {
                str = null;
            }
        }
        if (str == null || !"{".equals(a(this.bos, this.bot))) {
            AppMethodBeat.o(95709);
            return null;
        }
        int indexOf;
        d dVar = new d();
        if (!"".equals(str)) {
            i = str.indexOf(91);
            if (i != -1) {
                Matcher matcher = bor.matcher(str.substring(i));
                if (matcher.matches()) {
                    dVar.boB = matcher.group(1);
                }
                str = str.substring(0, i);
            }
            String[] split = str.split("\\.");
            String str2 = split[0];
            indexOf = str2.indexOf(35);
            if (indexOf != -1) {
                dVar.boz = str2.substring(0, indexOf);
                dVar.boy = str2.substring(indexOf + 1);
            } else {
                dVar.boz = str2;
            }
            if (split.length > 1) {
                dVar.boA = Arrays.asList((String[]) Arrays.copyOfRange(split, 1, split.length));
            }
        }
        Object obj3 = null;
        obj2 = null;
        while (obj2 == null) {
            indexOf = this.bos.position;
            obj3 = a(this.bos, this.bot);
            obj2 = (obj3 == null || "}".equals(obj3)) ? 1 : null;
            if (obj2 == null) {
                this.bos.setPosition(indexOf);
                lVar2 = this.bos;
                stringBuilder = this.bot;
                D(lVar2);
                String b = b(lVar2, stringBuilder);
                if (!"".equals(b) && VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D.equals(a(lVar2, stringBuilder))) {
                    D(lVar2);
                    StringBuilder stringBuilder2 = new StringBuilder();
                    obj = null;
                    while (obj == null) {
                        int i5 = lVar2.position;
                        String a2 = a(lVar2, stringBuilder);
                        if (a2 == null) {
                            obj = null;
                            break;
                        } else if ("}".equals(a2) || ";".equals(a2)) {
                            lVar2.setPosition(i5);
                            obj = 1;
                        } else {
                            stringBuilder2.append(a2);
                        }
                    }
                    obj = stringBuilder2.toString();
                    if (!(obj == null || "".equals(obj))) {
                        int i6 = lVar2.position;
                        String a3 = a(lVar2, stringBuilder);
                        if (!";".equals(a3)) {
                            if ("}".equals(a3)) {
                                lVar2.setPosition(i6);
                            }
                        }
                        if ("color".equals(b)) {
                            dVar.bnT = d.aG(obj);
                            dVar.bnU = true;
                        } else if ("background-color".equals(b)) {
                            dVar.backgroundColor = d.aG(obj);
                            dVar.bnV = true;
                        } else if ("text-decoration".equals(b)) {
                            if ("underline".equals(obj)) {
                                dVar.bnX = 1;
                            }
                        } else if ("font-family".equals(b)) {
                            dVar.bnS = v.aR(obj);
                        } else if ("font-weight".equals(b)) {
                            if ("bold".equals(obj)) {
                                dVar.bnY = 1;
                            }
                        } else if ("font-style".equals(b) && "italic".equals(obj)) {
                            dVar.bnZ = 1;
                        }
                    }
                }
            }
        }
        if ("}".equals(obj3)) {
            AppMethodBeat.o(95709);
            return dVar;
        }
        AppMethodBeat.o(95709);
        return null;
    }

    private static void D(l lVar) {
        AppMethodBeat.i(95710);
        Object obj = 1;
        while (lVar.tB() > 0 && obj != null) {
            obj = (E(lVar) || F(lVar)) ? 1 : null;
        }
        AppMethodBeat.o(95710);
    }

    private static String a(l lVar, StringBuilder stringBuilder) {
        AppMethodBeat.i(95711);
        D(lVar);
        if (lVar.tB() == 0) {
            AppMethodBeat.o(95711);
            return null;
        }
        String b = b(lVar, stringBuilder);
        if ("".equals(b)) {
            b = ((char) lVar.readUnsignedByte());
            AppMethodBeat.o(95711);
            return b;
        }
        AppMethodBeat.o(95711);
        return b;
    }

    private static String b(l lVar, StringBuilder stringBuilder) {
        int i = 0;
        AppMethodBeat.i(95714);
        stringBuilder.setLength(0);
        int i2 = lVar.position;
        int i3 = lVar.limit;
        while (i2 < i3 && i == 0) {
            char c = (char) lVar.data[i2];
            if ((c < 'A' || c > 'Z') && ((c < 'a' || c > 'z') && !((c >= '0' && c <= '9') || c == '#' || c == '-' || c == '.' || c == '_'))) {
                i = 1;
            } else {
                i2++;
                stringBuilder.append(c);
            }
        }
        lVar.eM(i2 - lVar.position);
        String stringBuilder2 = stringBuilder.toString();
        AppMethodBeat.o(95714);
        return stringBuilder2;
    }

    private static boolean E(l lVar) {
        AppMethodBeat.i(95712);
        switch ((char) lVar.data[lVar.position]) {
            case 9:
            case 10:
            case 12:
            case 13:
            case ' ':
                lVar.eM(1);
                AppMethodBeat.o(95712);
                return true;
            default:
                AppMethodBeat.o(95712);
                return false;
        }
    }

    private static boolean F(l lVar) {
        AppMethodBeat.i(95713);
        int i = lVar.position;
        int i2 = lVar.limit;
        byte[] bArr = lVar.data;
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
                    lVar.eM(i2 - lVar.position);
                    AppMethodBeat.o(95713);
                    return true;
                }
            }
        }
        AppMethodBeat.o(95713);
        return false;
    }
}
