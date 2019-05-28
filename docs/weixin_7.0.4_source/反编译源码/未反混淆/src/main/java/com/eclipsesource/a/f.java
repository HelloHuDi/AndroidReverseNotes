package com.eclipsesource.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiOperateMusicPlayer;
import com.tencent.mm.plugin.appbrand.jsapi.l.e;
import com.tencent.qqmusic.mediaplayer.PlayerException;
import com.tencent.view.d;
import com.tencent.wcdb.FileUtils;
import java.io.Reader;
import java.io.StringReader;
import org.xwalk.core.XWalkEnvironment;

final class f {
    private int aLA;
    private int aLB;
    private StringBuilder aLC;
    private int aLD;
    private final char[] aLx;
    private int aLy;
    private int aLz;
    private int index;
    private int line;
    private final Reader reader;

    f(String str) {
        this(new StringReader(str), Math.max(10, Math.min(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, str.length())));
        AppMethodBeat.i(70555);
        AppMethodBeat.o(70555);
    }

    private f(Reader reader, int i) {
        AppMethodBeat.i(70556);
        this.reader = reader;
        this.aLx = new char[i];
        this.line = 1;
        this.aLD = -1;
        AppMethodBeat.o(70556);
    }

    /* Access modifiers changed, original: final */
    public final h oT() {
        AppMethodBeat.i(70557);
        h pa;
        switch (this.aLB) {
            case 34:
                pa = pa();
                AppMethodBeat.o(70557);
                return pa;
            case IMediaObject.TYPE_BUSINESS_CARD /*45*/:
            case 48:
            case XWalkEnvironment.SDK_SUPPORT_MIN_APKVERSION /*49*/:
            case 50:
            case 51:
            case 52:
            case PlayerException.EXCEPTION_TYPE_FILENOTFOUND /*53*/:
            case PlayerException.EXCEPTION_TYPE_FILECANNOTREAD /*54*/:
            case PlayerException.EXCEPTION_TYPE_UNKNOWFORMAT /*55*/:
            case FileUtils.S_IRWXG /*56*/:
            case e.CTRL_INDEX /*57*/:
                pa = pd();
                AppMethodBeat.o(70557);
                return pa;
            case PlayerException.EXCEPTION_IN_PREPARE /*91*/:
                pa = oU();
                AppMethodBeat.o(70557);
                return pa;
            case 102:
                pa = oZ();
                AppMethodBeat.o(70557);
                return pa;
            case 110:
                pa = oX();
                AppMethodBeat.o(70557);
                return pa;
            case 116:
                pa = oY();
                AppMethodBeat.o(70557);
                return pa;
            case 123:
                pa = oV();
                AppMethodBeat.o(70557);
                return pa;
            default:
                j al = al("value");
                AppMethodBeat.o(70557);
                throw al;
        }
    }

    private b oU() {
        AppMethodBeat.i(70558);
        pi();
        b bVar = new b();
        ph();
        if (b(']')) {
            AppMethodBeat.o(70558);
        } else {
            do {
                ph();
                bVar.a(oT());
                ph();
            } while (b(','));
            if (b(']')) {
                AppMethodBeat.o(70558);
            } else {
                j al = al("',' or ']'");
                AppMethodBeat.o(70558);
                throw al;
            }
        }
        return bVar;
    }

    private e oV() {
        AppMethodBeat.i(70559);
        pi();
        e eVar = new e();
        ph();
        if (b('}')) {
            AppMethodBeat.o(70559);
        } else {
            j al;
            do {
                ph();
                String oW = oW();
                ph();
                if (b(':')) {
                    ph();
                    eVar.a(oW, oT());
                    ph();
                } else {
                    al = al("':'");
                    AppMethodBeat.o(70559);
                    throw al;
                }
            } while (b(','));
            if (b('}')) {
                AppMethodBeat.o(70559);
            } else {
                al = al("',' or '}'");
                AppMethodBeat.o(70559);
                throw al;
            }
        }
        return eVar;
    }

    private String oW() {
        AppMethodBeat.i(70560);
        if (this.aLB != 34) {
            j al = al("name");
            AppMethodBeat.o(70560);
            throw al;
        }
        String pb = pb();
        AppMethodBeat.o(70560);
        return pb;
    }

    private h oX() {
        AppMethodBeat.i(70561);
        pi();
        a('u');
        a('l');
        a('l');
        h hVar = a.aLi;
        AppMethodBeat.o(70561);
        return hVar;
    }

    private h oY() {
        AppMethodBeat.i(70562);
        pi();
        a('r');
        a('u');
        a('e');
        h hVar = a.aLj;
        AppMethodBeat.o(70562);
        return hVar;
    }

    private h oZ() {
        AppMethodBeat.i(70563);
        pi();
        a('a');
        a('l');
        a('s');
        a('e');
        h hVar = a.aLk;
        AppMethodBeat.o(70563);
        return hVar;
    }

    private void a(char c) {
        AppMethodBeat.i(70564);
        if (b(c)) {
            AppMethodBeat.o(70564);
            return;
        }
        j al = al("'" + c + "'");
        AppMethodBeat.o(70564);
        throw al;
    }

    private h pa() {
        AppMethodBeat.i(70565);
        g gVar = new g(pb());
        AppMethodBeat.o(70565);
        return gVar;
    }

    private String pb() {
        AppMethodBeat.i(70566);
        pi();
        pj();
        while (this.aLB != 34) {
            if (this.aLB == 92) {
                pk();
                pc();
                pj();
            } else if (this.aLB < 32) {
                j al = al("valid string character");
                AppMethodBeat.o(70566);
                throw al;
            } else {
                pi();
            }
        }
        String pl = pl();
        pi();
        AppMethodBeat.o(70566);
        return pl;
    }

    private void pc() {
        AppMethodBeat.i(70567);
        pi();
        j al;
        switch (this.aLB) {
            case 34:
            case JsApiOperateMusicPlayer.CTRL_INDEX /*47*/:
            case 92:
                this.aLC.append((char) this.aLB);
                break;
            case 98:
                this.aLC.append(8);
                break;
            case 102:
                this.aLC.append(12);
                break;
            case 110:
                this.aLC.append(10);
                break;
            case 114:
                this.aLC.append(13);
                break;
            case 116:
                this.aLC.append(9);
                break;
            case d.MIC_ALPHA_ADJUST_REAL /*117*/:
                char[] cArr = new char[4];
                int i = 0;
                while (i < 4) {
                    pi();
                    if (po()) {
                        cArr[i] = (char) this.aLB;
                        i++;
                    } else {
                        al = al("hexadecimal digit");
                        AppMethodBeat.o(70567);
                        throw al;
                    }
                }
                this.aLC.append((char) Integer.parseInt(new String(cArr), 16));
                break;
            default:
                al = al("valid escape sequence");
                AppMethodBeat.o(70567);
                throw al;
        }
        pi();
        AppMethodBeat.o(70567);
    }

    private h pd() {
        AppMethodBeat.i(70568);
        pj();
        b('-');
        int i = this.aLB;
        if (pg()) {
            if (i != 48) {
                do {
                } while (pg());
            }
            pe();
            pf();
            d dVar = new d(pl());
            AppMethodBeat.o(70568);
            return dVar;
        }
        j al = al("digit");
        AppMethodBeat.o(70568);
        throw al;
    }

    private boolean pe() {
        AppMethodBeat.i(70569);
        if (!b('.')) {
            AppMethodBeat.o(70569);
            return false;
        } else if (pg()) {
            do {
            } while (pg());
            AppMethodBeat.o(70569);
            return true;
        } else {
            j al = al("digit");
            AppMethodBeat.o(70569);
            throw al;
        }
    }

    private boolean pf() {
        AppMethodBeat.i(70570);
        if (b('e') || b('E')) {
            if (!b('+')) {
                b('-');
            }
            if (pg()) {
                do {
                } while (pg());
                AppMethodBeat.o(70570);
                return true;
            }
            j al = al("digit");
            AppMethodBeat.o(70570);
            throw al;
        }
        AppMethodBeat.o(70570);
        return false;
    }

    private boolean b(char c) {
        AppMethodBeat.i(70571);
        if (this.aLB != c) {
            AppMethodBeat.o(70571);
            return false;
        }
        pi();
        AppMethodBeat.o(70571);
        return true;
    }

    private boolean pg() {
        AppMethodBeat.i(70572);
        if (pn()) {
            pi();
            AppMethodBeat.o(70572);
            return true;
        }
        AppMethodBeat.o(70572);
        return false;
    }

    /* Access modifiers changed, original: final */
    public final void ph() {
        AppMethodBeat.i(70573);
        while (pm()) {
            pi();
        }
        AppMethodBeat.o(70573);
    }

    /* Access modifiers changed, original: final */
    public final void pi() {
        AppMethodBeat.i(70574);
        if (this.index == this.aLz) {
            if (this.aLD != -1) {
                this.aLC.append(this.aLx, this.aLD, this.aLz - this.aLD);
                this.aLD = 0;
            }
            this.aLy += this.aLz;
            this.aLz = this.reader.read(this.aLx, 0, this.aLx.length);
            this.index = 0;
            if (this.aLz == -1) {
                this.aLB = -1;
                AppMethodBeat.o(70574);
                return;
            }
        }
        if (this.aLB == 10) {
            this.line++;
            this.aLA = this.aLy + this.index;
        }
        char[] cArr = this.aLx;
        int i = this.index;
        this.index = i + 1;
        this.aLB = cArr[i];
        AppMethodBeat.o(70574);
    }

    private void pj() {
        AppMethodBeat.i(70575);
        if (this.aLC == null) {
            this.aLC = new StringBuilder();
        }
        this.aLD = this.index - 1;
        AppMethodBeat.o(70575);
    }

    private void pk() {
        AppMethodBeat.i(70576);
        int i = this.aLB == -1 ? this.index : this.index - 1;
        StringBuilder stringBuilder = this.aLC;
        char[] cArr = this.aLx;
        int i2 = this.aLD;
        stringBuilder.append(cArr, i2, i - i2);
        this.aLD = -1;
        AppMethodBeat.o(70576);
    }

    private String pl() {
        String stringBuilder;
        AppMethodBeat.i(70577);
        int i = this.aLB == -1 ? this.index : this.index - 1;
        if (this.aLC.length() > 0) {
            StringBuilder stringBuilder2 = this.aLC;
            char[] cArr = this.aLx;
            int i2 = this.aLD;
            stringBuilder2.append(cArr, i2, i - i2);
            stringBuilder = this.aLC.toString();
            this.aLC.setLength(0);
        } else {
            stringBuilder = new String(this.aLx, this.aLD, i - this.aLD);
        }
        this.aLD = -1;
        AppMethodBeat.o(70577);
        return stringBuilder;
    }

    private j al(String str) {
        AppMethodBeat.i(70578);
        j am;
        if (pp()) {
            am = am("Unexpected end of input");
            AppMethodBeat.o(70578);
            return am;
        }
        am = am("Expected ".concat(String.valueOf(str)));
        AppMethodBeat.o(70578);
        return am;
    }

    /* Access modifiers changed, original: final */
    public final j am(String str) {
        AppMethodBeat.i(70579);
        int i = this.aLy + this.index;
        int i2 = i - this.aLA;
        if (!pp()) {
            i--;
        }
        j jVar = new j(str, i, this.line, i2 - 1);
        AppMethodBeat.o(70579);
        return jVar;
    }

    private boolean pm() {
        return this.aLB == 32 || this.aLB == 9 || this.aLB == 10 || this.aLB == 13;
    }

    private boolean pn() {
        return this.aLB >= 48 && this.aLB <= 57;
    }

    private boolean po() {
        return (this.aLB >= 48 && this.aLB <= 57) || ((this.aLB >= 97 && this.aLB <= 102) || (this.aLB >= 65 && this.aLB <= 70));
    }

    /* Access modifiers changed, original: final */
    public final boolean pp() {
        return this.aLB == -1;
    }
}
