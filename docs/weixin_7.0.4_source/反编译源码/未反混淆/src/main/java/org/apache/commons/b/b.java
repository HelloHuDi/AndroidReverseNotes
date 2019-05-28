package org.apache.commons.b;

import com.facebook.appevents.UserDataStore;
import com.google.android.gms.common.internal.GmsClientSupervisor;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.g.e;
import com.tencent.mm.plugin.appbrand.jsapi.g.n;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import com.tencent.view.d;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

final class b {
    private static final String[][] BWP;
    private static final String[][] BWQ;
    static final String[][] BWR;
    static final String[][] BWS;
    public static final b BWT;
    public static final b BWU;
    public static final b BWV;
    private final a BWW = new b();

    static class c implements a {
        private final Map BWX = new HashMap();
        private final c BWY = new c();

        c() {
            AppMethodBeat.i(116928);
            AppMethodBeat.o(116928);
        }

        public final void h(String str, int i) {
            AppMethodBeat.i(116929);
            this.BWX.put(str, Integer.valueOf(i));
            this.BWY.v(i, str);
            AppMethodBeat.o(116929);
        }

        public final int awK(String str) {
            AppMethodBeat.i(116930);
            Object obj = this.BWX.get(str);
            if (obj == null) {
                AppMethodBeat.o(116930);
                return -1;
            }
            int intValue = ((Integer) obj).intValue();
            AppMethodBeat.o(116930);
            return intValue;
        }
    }

    static class b extends c {
        b() {
        }
    }

    interface a {
        int awK(String str);

        void h(String str, int i);
    }

    static {
        AppMethodBeat.i(116935);
        r0 = new String[4][];
        r0[0] = new String[]{"quot", "34"};
        r0[1] = new String[]{"amp", "38"};
        r0[2] = new String[]{"lt", "60"};
        r0[3] = new String[]{"gt", "62"};
        BWP = r0;
        r0 = new String[1][];
        r0[0] = new String[]{"apos", "39"};
        BWQ = r0;
        r0 = new String[96][];
        r0[0] = new String[]{"nbsp", "160"};
        r0[1] = new String[]{"iexcl", "161"};
        r0[2] = new String[]{"cent", "162"};
        r0[3] = new String[]{"pound", "163"};
        r0[4] = new String[]{"curren", "164"};
        r0[5] = new String[]{"yen", "165"};
        r0[6] = new String[]{"brvbar", "166"};
        r0[7] = new String[]{"sect", "167"};
        r0[8] = new String[]{"uml", "168"};
        r0[9] = new String[]{"copy", "169"};
        r0[10] = new String[]{"ordf", "170"};
        r0[11] = new String[]{"laquo", "171"};
        r0[12] = new String[]{"not", "172"};
        r0[13] = new String[]{"shy", "173"};
        r0[14] = new String[]{"reg", "174"};
        r0[15] = new String[]{"macr", "175"};
        r0[16] = new String[]{"deg", "176"};
        r0[17] = new String[]{"plusmn", "177"};
        r0[18] = new String[]{"sup2", "178"};
        r0[19] = new String[]{"sup3", "179"};
        r0[20] = new String[]{"acute", "180"};
        r0[21] = new String[]{"micro", "181"};
        r0[22] = new String[]{"para", "182"};
        r0[23] = new String[]{"middot", "183"};
        r0[24] = new String[]{"cedil", "184"};
        r0[25] = new String[]{"sup1", "185"};
        r0[26] = new String[]{"ordm", "186"};
        r0[27] = new String[]{"raquo", "187"};
        r0[28] = new String[]{"frac14", "188"};
        r0[29] = new String[]{"frac12", "189"};
        r0[30] = new String[]{"frac34", "190"};
        r0[31] = new String[]{"iquest", "191"};
        r0[32] = new String[]{"Agrave", "192"};
        r0[33] = new String[]{"Aacute", "193"};
        r0[34] = new String[]{"Acirc", "194"};
        r0[35] = new String[]{"Atilde", "195"};
        r0[36] = new String[]{"Auml", "196"};
        r0[37] = new String[]{"Aring", "197"};
        r0[38] = new String[]{"AElig", "198"};
        r0[39] = new String[]{"Ccedil", "199"};
        r0[40] = new String[]{"Egrave", "200"};
        r0[41] = new String[]{"Eacute", "201"};
        r0[42] = new String[]{"Ecirc", "202"};
        r0[43] = new String[]{"Euml", "203"};
        r0[44] = new String[]{"Igrave", "204"};
        r0[45] = new String[]{"Iacute", "205"};
        r0[46] = new String[]{"Icirc", "206"};
        r0[47] = new String[]{"Iuml", "207"};
        r0[48] = new String[]{"ETH", "208"};
        r0[49] = new String[]{"Ntilde", "209"};
        r0[50] = new String[]{"Ograve", "210"};
        r0[51] = new String[]{"Oacute", "211"};
        r0[52] = new String[]{"Ocirc", "212"};
        r0[53] = new String[]{"Otilde", "213"};
        r0[54] = new String[]{"Ouml", "214"};
        r0[55] = new String[]{"times", "215"};
        r0[56] = new String[]{"Oslash", "216"};
        r0[57] = new String[]{"Ugrave", "217"};
        r0[58] = new String[]{"Uacute", "218"};
        r0[59] = new String[]{"Ucirc", "219"};
        r0[60] = new String[]{"Uuml", "220"};
        r0[61] = new String[]{"Yacute", "221"};
        r0[62] = new String[]{"THORN", "222"};
        r0[63] = new String[]{"szlig", "223"};
        r0[64] = new String[]{"agrave", "224"};
        r0[65] = new String[]{"aacute", "225"};
        r0[66] = new String[]{"acirc", "226"};
        r0[67] = new String[]{"atilde", "227"};
        r0[68] = new String[]{"auml", "228"};
        r0[69] = new String[]{"aring", "229"};
        r0[70] = new String[]{"aelig", "230"};
        r0[71] = new String[]{"ccedil", "231"};
        r0[72] = new String[]{"egrave", "232"};
        r0[73] = new String[]{"eacute", "233"};
        r0[74] = new String[]{"ecirc", "234"};
        r0[75] = new String[]{"euml", "235"};
        r0[76] = new String[]{"igrave", "236"};
        r0[77] = new String[]{"iacute", "237"};
        r0[78] = new String[]{"icirc", "238"};
        r0[79] = new String[]{"iuml", "239"};
        r0[80] = new String[]{"eth", "240"};
        r0[81] = new String[]{"ntilde", "241"};
        r0[82] = new String[]{"ograve", "242"};
        r0[83] = new String[]{"oacute", "243"};
        r0[84] = new String[]{"ocirc", "244"};
        r0[85] = new String[]{"otilde", "245"};
        r0[86] = new String[]{"ouml", "246"};
        r0[87] = new String[]{"divide", "247"};
        r0[88] = new String[]{"oslash", "248"};
        r0[89] = new String[]{"ugrave", "249"};
        r0[90] = new String[]{"uacute", "250"};
        r0[91] = new String[]{"ucirc", "251"};
        r0[92] = new String[]{"uuml", "252"};
        r0[93] = new String[]{"yacute", "253"};
        r0[94] = new String[]{"thorn", "254"};
        r0[95] = new String[]{"yuml", "255"};
        BWR = r0;
        r0 = new String[151][];
        r0[0] = new String[]{"fnof", "402"};
        r0[1] = new String[]{"Alpha", "913"};
        r0[2] = new String[]{"Beta", "914"};
        r0[3] = new String[]{android.support.d.a.TAG_GAMMA, "915"};
        r0[4] = new String[]{"Delta", "916"};
        r0[5] = new String[]{"Epsilon", "917"};
        r0[6] = new String[]{"Zeta", "918"};
        r0[7] = new String[]{"Eta", "919"};
        r0[8] = new String[]{"Theta", "920"};
        r0[9] = new String[]{"Iota", "921"};
        r0[10] = new String[]{"Kappa", "922"};
        r0[11] = new String[]{"Lambda", "923"};
        r0[12] = new String[]{"Mu", "924"};
        r0[13] = new String[]{"Nu", "925"};
        r0[14] = new String[]{"Xi", "926"};
        r0[15] = new String[]{"Omicron", "927"};
        r0[16] = new String[]{"Pi", "928"};
        r0[17] = new String[]{"Rho", "929"};
        r0[18] = new String[]{"Sigma", "931"};
        r0[19] = new String[]{"Tau", "932"};
        r0[20] = new String[]{"Upsilon", "933"};
        r0[21] = new String[]{"Phi", "934"};
        r0[22] = new String[]{"Chi", "935"};
        r0[23] = new String[]{"Psi", "936"};
        r0[24] = new String[]{"Omega", "937"};
        r0[25] = new String[]{"alpha", "945"};
        r0[26] = new String[]{"beta", "946"};
        r0[27] = new String[]{"gamma", "947"};
        r0[28] = new String[]{"delta", "948"};
        r0[29] = new String[]{"epsilon", "949"};
        r0[30] = new String[]{"zeta", "950"};
        r0[31] = new String[]{"eta", "951"};
        r0[32] = new String[]{"theta", "952"};
        r0[33] = new String[]{"iota", "953"};
        r0[34] = new String[]{"kappa", "954"};
        r0[35] = new String[]{"lambda", "955"};
        r0[36] = new String[]{"mu", "956"};
        r0[37] = new String[]{"nu", "957"};
        r0[38] = new String[]{"xi", "958"};
        r0[39] = new String[]{"omicron", "959"};
        r0[40] = new String[]{"pi", "960"};
        r0[41] = new String[]{"rho", "961"};
        r0[42] = new String[]{"sigmaf", "962"};
        r0[43] = new String[]{"sigma", "963"};
        r0[44] = new String[]{"tau", "964"};
        r0[45] = new String[]{"upsilon", "965"};
        r0[46] = new String[]{"phi", "966"};
        r0[47] = new String[]{"chi", "967"};
        r0[48] = new String[]{"psi", "968"};
        r0[49] = new String[]{"omega", "969"};
        r0[50] = new String[]{"thetasym", "977"};
        r0[51] = new String[]{"upsih", "978"};
        r0[52] = new String[]{"piv", "982"};
        r0[53] = new String[]{"bull", "8226"};
        r0[54] = new String[]{"hellip", "8230"};
        r0[55] = new String[]{"prime", "8242"};
        r0[56] = new String[]{"Prime", "8243"};
        r0[57] = new String[]{"oline", "8254"};
        r0[58] = new String[]{"frasl", "8260"};
        r0[59] = new String[]{"weierp", "8472"};
        r0[60] = new String[]{"image", "8465"};
        r0[61] = new String[]{"real", "8476"};
        r0[62] = new String[]{"trade", "8482"};
        r0[63] = new String[]{"alefsym", "8501"};
        r0[64] = new String[]{"larr", "8592"};
        r0[65] = new String[]{"uarr", "8593"};
        r0[66] = new String[]{"rarr", "8594"};
        r0[67] = new String[]{"darr", "8595"};
        r0[68] = new String[]{"harr", "8596"};
        r0[69] = new String[]{"crarr", "8629"};
        r0[70] = new String[]{"lArr", "8656"};
        r0[71] = new String[]{"uArr", "8657"};
        r0[72] = new String[]{"rArr", "8658"};
        r0[73] = new String[]{"dArr", "8659"};
        r0[74] = new String[]{"hArr", "8660"};
        r0[75] = new String[]{"forall", "8704"};
        r0[76] = new String[]{"part", "8706"};
        r0[77] = new String[]{"exist", "8707"};
        r0[78] = new String[]{"empty", "8709"};
        r0[79] = new String[]{"nabla", "8711"};
        r0[80] = new String[]{"isin", "8712"};
        r0[81] = new String[]{"notin", "8713"};
        r0[82] = new String[]{"ni", "8715"};
        r0[83] = new String[]{"prod", "8719"};
        r0[84] = new String[]{"sum", "8721"};
        r0[85] = new String[]{"minus", "8722"};
        r0[86] = new String[]{"lowast", "8727"};
        r0[87] = new String[]{"radic", "8730"};
        r0[88] = new String[]{"prop", "8733"};
        r0[89] = new String[]{"infin", "8734"};
        r0[90] = new String[]{"ang", "8736"};
        r0[91] = new String[]{"and", "8743"};
        r0[92] = new String[]{"or", "8744"};
        r0[93] = new String[]{"cap", "8745"};
        r0[94] = new String[]{"cup", "8746"};
        r0[95] = new String[]{"int", "8747"};
        r0[96] = new String[]{"there4", "8756"};
        r0[97] = new String[]{"sim", "8764"};
        r0[98] = new String[]{"cong", "8773"};
        r0[99] = new String[]{"asymp", "8776"};
        r0[100] = new String[]{"ne", "8800"};
        r0[101] = new String[]{"equiv", "8801"};
        r0[102] = new String[]{"le", "8804"};
        r0[103] = new String[]{UserDataStore.GENDER, "8805"};
        r0[104] = new String[]{"sub", "8834"};
        r0[105] = new String[]{"sup", "8835"};
        r0[106] = new String[]{"sube", "8838"};
        r0[107] = new String[]{"supe", "8839"};
        r0[108] = new String[]{"oplus", "8853"};
        r0[109] = new String[]{"otimes", "8855"};
        r0[110] = new String[]{"perp", "8869"};
        r0[111] = new String[]{"sdot", "8901"};
        r0[112] = new String[]{"lceil", "8968"};
        r0[113] = new String[]{"rceil", "8969"};
        r0[114] = new String[]{"lfloor", "8970"};
        r0[115] = new String[]{"rfloor", "8971"};
        r0[116] = new String[]{"lang", "9001"};
        r0[d.MIC_ALPHA_ADJUST_REAL] = new String[]{"rang", "9002"};
        r0[118] = new String[]{"loz", "9674"};
        r0[d.MIC_AVROUND_BLUR] = new String[]{"spades", "9824"};
        r0[120] = new String[]{"clubs", "9827"};
        r0[121] = new String[]{"hearts", "9829"};
        r0[122] = new String[]{"diams", "9830"};
        r0[123] = new String[]{"OElig", "338"};
        r0[124] = new String[]{"oelig", "339"};
        r0[125] = new String[]{"Scaron", "352"};
        r0[126] = new String[]{"scaron", "353"};
        r0[d.MIC_SketchMark] = new String[]{"Yuml", "376"};
        r0[128] = new String[]{"circ", "710"};
        r0[GmsClientSupervisor.DEFAULT_BIND_FLAGS] = new String[]{"tilde", "732"};
        r0[130] = new String[]{"ensp", "8194"};
        r0[131] = new String[]{"emsp", "8195"};
        r0[132] = new String[]{"thinsp", "8201"};
        r0[e.CTRL_INDEX] = new String[]{"zwnj", "8204"};
        r0[com.tencent.mm.plugin.appbrand.jsapi.g.d.CTRL_INDEX] = new String[]{"zwj", "8205"};
        r0[com.tencent.mm.plugin.appbrand.jsapi.g.b.CTRL_INDEX] = new String[]{"lrm", "8206"};
        r0[n.CTRL_INDEX] = new String[]{"rlm", "8207"};
        r0[137] = new String[]{"ndash", "8211"};
        r0[138] = new String[]{"mdash", "8212"};
        r0[com.tencent.mm.plugin.appbrand.jsapi.k.a.CTRL_INDEX] = new String[]{"lsquo", "8216"};
        r0[140] = new String[]{"rsquo", "8217"};
        r0[141] = new String[]{"sbquo", "8218"};
        r0[ErrorCode.NEEDDOWNLOAD_3] = new String[]{"ldquo", "8220"};
        r0[ErrorCode.NEEDDOWNLOAD_4] = new String[]{"rdquo", "8221"};
        r0[144] = new String[]{"bdquo", "8222"};
        r0[145] = new String[]{"dagger", "8224"};
        r0[146] = new String[]{"Dagger", "8225"};
        r0[ErrorCode.NEEDDOWNLOAD_8] = new String[]{"permil", "8240"};
        r0[148] = new String[]{"lsaquo", "8249"};
        r0[149] = new String[]{"rsaquo", "8250"};
        r0[150] = new String[]{"euro", "8364"};
        BWS = r0;
        b bVar = new b();
        bVar.a(BWP);
        bVar.a(BWQ);
        BWT = bVar;
        bVar = new b();
        bVar.a(BWP);
        bVar.a(BWR);
        BWU = bVar;
        bVar = new b();
        bVar.a(BWP);
        bVar.a(BWR);
        bVar.a(BWS);
        BWV = bVar;
        AppMethodBeat.o(116935);
    }

    public b() {
        AppMethodBeat.i(116931);
        AppMethodBeat.o(116931);
    }

    private void a(String[][] strArr) {
        AppMethodBeat.i(116932);
        for (int i = 0; i < strArr.length; i++) {
            this.BWW.h(strArr[i][0], Integer.parseInt(strArr[i][1]));
        }
        AppMethodBeat.o(116932);
    }

    public final String unescape(String str) {
        AppMethodBeat.i(116933);
        int indexOf = str.indexOf(38);
        if (indexOf < 0) {
            AppMethodBeat.o(116933);
            return str;
        }
        StringWriter stringWriter = new StringWriter((int) (((double) str.length()) + (((double) str.length()) * 0.1d)));
        try {
            a(stringWriter, str, indexOf);
            str = stringWriter.toString();
            AppMethodBeat.o(116933);
            return str;
        } catch (IOException e) {
            g gVar = new g(e);
            AppMethodBeat.o(116933);
            throw gVar;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x0088  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0067  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(Writer writer, String str, int i) {
        AppMethodBeat.i(116934);
        writer.write(str, 0, i);
        int length = str.length();
        int i2 = i;
        while (i2 < length) {
            char charAt = str.charAt(i2);
            if (charAt == '&') {
                int i3 = i2 + 1;
                int indexOf = str.indexOf(59, i3);
                if (indexOf == -1) {
                    writer.write(charAt);
                } else {
                    int indexOf2 = str.indexOf(38, i2 + 1);
                    if (indexOf2 == -1 || indexOf2 >= indexOf) {
                        String substring = str.substring(i3, indexOf);
                        i2 = substring.length();
                        if (i2 > 0) {
                            if (substring.charAt(0) != '#') {
                                i2 = this.BWW.awK(substring);
                            } else if (i2 > 1) {
                                switch (substring.charAt(1)) {
                                    case 'X':
                                    case 'x':
                                        i2 = Integer.parseInt(substring.substring(2), 16);
                                        break;
                                    default:
                                        try {
                                            i2 = Integer.parseInt(substring.substring(1), 10);
                                            break;
                                        } catch (NumberFormatException e) {
                                            i2 = -1;
                                            break;
                                        }
                                }
                                if (i2 > CdnLogic.kBizGeneric) {
                                    i2 = -1;
                                }
                            }
                            if (i2 != -1) {
                                writer.write(38);
                                writer.write(substring);
                                writer.write(59);
                            } else {
                                writer.write(i2);
                            }
                            i2 = indexOf;
                        }
                        i2 = -1;
                        if (i2 != -1) {
                        }
                        i2 = indexOf;
                    } else {
                        writer.write(charAt);
                    }
                }
            } else {
                writer.write(charAt);
            }
            i2++;
        }
        AppMethodBeat.o(116934);
    }
}
